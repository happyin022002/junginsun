/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_10.jsp
 *@FileTitle : e-Booking & SI Process Detail(HBL 1)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var iterator="|$$|";
var isCopy="false";
var sheet1ColCount=0;
var sheet2ColCount=0;
var sheet3ColCount=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			top.isCopyAllRequested=false;
			//ComBtnColor("btn_cancelcopydata", "blue");
			//ComBtnColor("btn_datacopytoopus", "#737373");	
			
			document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			break;
		case "btn_datacopytoopus":
			if (isCopy == "false") {
				dataCopy();
			}
			break;
		case "btn_package":
			comBkgCallPop0696("callbackPckTp", formObject.pck_tp_cd.value);
			break;
		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		// IBMultiCombo
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}
function initControl() {
 	var formObject=document.form;
 	// axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
	axon_event.addListenerForm  ("change", "form_onChange", formObject);
 	axon_event.addListenerForm('blur', 'form1_blur', formObject);
	applyShortcut();
}
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
 /**
  * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
function setSheetObject(sheet_obj) {
 	sheetObjects[sheetCnt++]=sheet_obj;
}
  /**
   * setting combo initial values
   * 
   * @param {IBMultiCombo}
   *            comboObj comboObj
   */
  function initCombo(comboObj) {
  	comboObj.SetMultiSelect(0);
  	comboObj.SetColAlign(0, "left");
  	comboObj.SetColAlign(1, "left");
  	comboObj.SetMultiSeparator("|");
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
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1="ibflag|xter_si_no|xter_si_seq|hbl_no|hbl_seq|shpr_nm|shpr_addr|cnee_nm|cnee_addr|noti_nm|noti_addr|hbl_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|cmdt_meas_qty|cmdt_meas_ut_cd|bl_mk_desc|bl_gds_desc|bkg_no";
			var headCount=ComCountHeadTitle(HeadTitle1);
			var prefix="sheet1_";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"xter_si_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"xter_si_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"hbl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"hbl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shpr_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"noti_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"noti_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"hbl_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_meas_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_mk_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_gds_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no" } ];
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
			SetWaitImageVisible(0);
			sheet1ColCount=cols.length;
		}
		break;
	case "sheet2":
		with (sheetObj) {
			var HeadTitle1="ibflag|xter_si_no|xter_si_seq|hbl_no|hbl_seq|shpr_nm|shpr_addr|cnee_nm|cnee_addr|noti_nm|noti_addr|hbl_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|cmdt_meas_qty|cmdt_meas_ut_cd|bl_mk_desc|bl_gds_desc|bkg_no";
			var headCount=ComCountHeadTitle(HeadTitle1);
			var prefix="sheet2_";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"xter_si_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"xter_si_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"hbl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"hbl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shpr_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"noti_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"noti_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"hbl_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_meas_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_mk_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_gds_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no" } ];
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
			SetWaitImageVisible(0);
			sheet2ColCount=cnt;
		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH_ASYNC01:
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		
		break;
	case IBSEARCH: 
		if (formObj.bkg_no.value != null && formObj.bkg_no.value != '') {
			var sXml=formObj.sXml.value;
			var arrXml=sXml.split("|$$|");
			// wgt_ut_cd
			if (arrXml.length > 0) ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");		
			// meas_ut_cd
			if (arrXml.length > 1) ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");
			for ( var i=0; i < arrXml.length - 2; i++) {
				sheetObjects[i].LoadSearchData(arrXml[i+2],{Sync:1} );
			}
		}
		comboObjects[0].SetSelectCode(sheetObjects[0].GetCellValue(1, "wgt_ut_cd"),false);
		comboObjects[1].SetSelectCode(sheetObjects[0].GetCellValue(1, "cmdt_meas_ut_cd"),false);
		formObj.opus_seq.selectedIndex=0;
		formObj.opus_seq.length=0;
		formObj.xter_seq.length=0;
		document.all.opus_seq_tot.innerHTML="";
		document.all.xter_seq_tot.innerHTML="";
		document.all.opus_seq_tot.innerHTML=sheetObjects[0].RowCount();
		document.all.xter_seq_tot.innerHTML=sheetObjects[1].RowCount();
		if (sheetObjects[0].RowCount()> 0){
			formObj.hbl1_opus.value="Y";
		}else{
			formObj.hbl1_opus.value="N";
		}
		if (sheetObjects[1].RowCount()> 0){
			formObj.hbl1_esvc.value="Y";
		}else{
			formObj.hbl1_esvc.value="N";
		}
		var obj=document.getElementById("opus_seq"); 
		for ( var i=0; i < sheetObjects[0].RowCount(); i++) {
			opt=document.createElement("option");
			opt.value=i + 1;
			opt.text=i + 1;
			obj.add(opt);
		}
		var obj2=document.getElementById("xter_seq");
		for ( var j=0; j < sheetObjects[1].RowCount(); j++) {
			opt2=document.createElement("option");
			opt2.value=j + 1;
			opt2.text=j + 1;
			obj2.add(opt2);
		}
		if (sheetObjects[0].RowCount()> 0) {
			var prefix="sheet1_";
			document.form.xter_si_no1.value=sheetObjects[0].GetCellValue(1, "xter_si_no");
			document.form.hbl_no.value=sheetObjects[0].GetCellValue(1, "hbl_no");
			document.form.shpr_nm.value=sheetObjects[0].GetCellValue(1, "shpr_nm");
			document.form.shpr_addr.value=sheetObjects[0].GetCellValue(1, "shpr_addr");
			document.form.cnee_nm.value=sheetObjects[0].GetCellValue(1, "cnee_nm");
			document.form.cnee_addr.value=sheetObjects[0].GetCellValue(1, "cnee_addr");
			document.form.noti_nm.value=sheetObjects[0].GetCellValue(1, "noti_nm");
			document.form.noti_addr.value=sheetObjects[0].GetCellValue(1, "noti_addr");
			document.form.hbl_wgt.value=ComAddComma3(sheetObjects[0].GetCellValue(1, "hbl_wgt"), "#,###.000");
			document.form.wgt_ut_cd.value=sheetObjects[0].GetCellValue(1, "wgt_ut_cd");
			document.form.pck_qty.value=sheetObjects[0].GetCellValue(1, "pck_qty");
			document.form.pck_tp_cd.value=sheetObjects[0].GetCellValue(1, "pck_tp_cd");
			document.form.cmdt_meas_qty.value=ComAddComma3(sheetObjects[0].GetCellValue(1, "cmdt_meas_qty"), "#,###.000");
			document.form.cmdt_meas_ut_cd.value=sheetObjects[0].GetCellValue(1, "cmdt_meas_ut_cd");
			document.form.bl_mk_desc.value=sheetObjects[0].GetCellValue(1, "bl_mk_desc");
			document.form.bl_gds_desc.value=sheetObjects[0].GetCellValue(1, "bl_gds_desc");
		} else {
			document.form.xter_si_no1.value='';
			document.form.hbl_no.value='';
			document.form.shpr_nm.value='';
			document.form.shpr_addr.value='';
			document.form.cnee_nm.value='';
			document.form.cnee_addr.value='';
			document.form.noti_nm.value='';
			document.form.noti_addr.value='';
			document.form.hbl_wgt.value='';
			document.form.wgt_ut_cd.value='';
			document.form.pck_qty.value='';
			document.form.pck_tp_cd.value='';
			document.form.cmdt_meas_qty.value='';
			document.form.cmdt_meas_ut_cd.value='';
			document.form.bl_mk_desc.value='';
			document.form.bl_gds_desc.value='';
		}
		if (sheetObjects[1].RowCount()> 0) {
			var prefix="sheet2_";
			sheetObjects[1].SetCellValue(1, "hbl_wgt",ComAddComma3(sheetObjects[1].GetCellValue(1, "hbl_wgt"), "#,###.000"),0);
			sheetObjects[1].SetCellValue(1, "cmdt_meas_qty",ComAddComma3(sheetObjects[1].GetCellValue(1, "cmdt_meas_qty"), "#,###.000"),0);
			document.form.xter_si_no2.value=sheetObjects[1].GetCellValue(1, "xter_si_no");
			document.form.hbl_no2.value=sheetObjects[1].GetCellValue(1, "hbl_no");
			document.form.shpr_nm2.value=sheetObjects[1].GetCellValue(1, "shpr_nm");
			document.form.shpr_addr2.value=sheetObjects[1].GetCellValue(1, "shpr_addr");
			document.form.cnee_nm2.value=sheetObjects[1].GetCellValue(1, "cnee_nm");
			document.form.cnee_addr2.value=sheetObjects[1].GetCellValue(1, "cnee_addr");
			document.form.noti_nm2.value=sheetObjects[1].GetCellValue(1, "noti_nm");
			document.form.noti_addr2.value=sheetObjects[1].GetCellValue(1, "noti_addr");
			document.form.hbl_wgt2.value=sheetObjects[1].GetCellValue(1, "hbl_wgt");
			document.form.wgt_ut_cd2.value=sheetObjects[1].GetCellValue(1, "wgt_ut_cd");
			document.form.pck_qty2.value=sheetObjects[1].GetCellValue(1, "pck_qty");
			document.form.pck_tp_cd2.value=sheetObjects[1].GetCellValue(1, "pck_tp_cd");
			document.form.cmdt_meas_qty2.value=sheetObjects[1].GetCellValue(1, "cmdt_meas_qty");
			document.form.cmdt_meas_ut_cd2.value=sheetObjects[1].GetCellValue(1, "cmdt_meas_ut_cd");
			document.form.bl_mk_desc2.value=sheetObjects[1].GetCellValue(1, "bl_mk_desc");
			document.form.bl_gds_desc2.value=sheetObjects[1].GetCellValue(1, "bl_gds_desc");
		}
		isCopy="false";
		if(top.document.form.tabload10.value == "COPY"){
			dataCopy();
		}
		if (parent.frames["t1frame"].document.form) {
			parent.frames["t1frame"].document.form.hbl_knt2.value=sheetObjects[1].LastRow() - 1;
		}
		top.document.form.tabload10.value="LOAD";
		compareItem();
		
		if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_10');
		break;
	case IBSEARCH_ASYNC02: // Data Copy
		
		var sheet1HblSeq=0;
		var sheet2HblSeq=0;
		var newRow=0;
		for ( var i=1; i < sheetObjects[1].LastRow()+1; i++) {
			sheet1HblSeq=0;
			sheet2HblSeq=0;
			for ( var j=1; j < sheetObjects[0].LastRow(); j++) {
				if ( sheetObjects[0].RowCount()> 0 ) {
					if ( sheetObjects[0].GetCellValue(i, "hbl_no") == sheetObjects[1].GetCellValue(j, "hbl_no") ) {
						sheet2HblSeq=i;
						sheet1HblSeq=j;
					}
				}
			}
			if(sheet1HblSeq == 0 && sheet1HblSeq == 0){
				newRow=sheetObjects[0].DataInsert(-1);
				for ( var j=0; j < sheet1ColCount; j++) {
					if (sheetObjects[1].ColSaveName(j) == "ibflag") {
						continue;
					}
					
					if(!ComIsNull(sheetObjects[1].GetCellValue(i, j))){
						sheetObjects[0].SetCellValue(newRow, j,sheetObjects[1].GetCellValue(i, j).toUpperCase(),0);
					}
				}
			} else {
				for ( var j=0; j < sheet1ColCount; j++) {
					if (sheetObjects[1].ColSaveName(j) == "ibflag") {
						if (sheetObjects[0].GetCellValue(sheet1HblSeq, j) == 'I') {
							continue;
						} else {
							sheetObjects[0].SetRowStatus(sheet1HblSeq,'U');
						}
					}
					
					if(!ComIsNull(sheetObjects[1].GetCellValue(sheet2HblSeq, j))){
						sheetObjects[0].SetCellValue(sheet1HblSeq, j,sheetObjects[1].GetCellValue(sheet2HblSeq, j).toUpperCase());
					}
				}
			}
		}
		if (sheetObjects[0].RowCount()> 0) {
			sheet1HblSeq.selectedIndex = 0;
			sheet1HblSeq.length = 0;
			var oldSeq = document.all.opus_seq_tot.innerHTML;
			document.all.opus_seq_tot.innerHTML = sheetObjects[0].RowCount();
			if (sheetObjects[0].RowCount()> 0){
				formObj.hbl1_opus.value = "Y";
			}else{
				formObj.hbl1_opus.value = "N";
			}
			var obj = document.getElementById("opus_seq");
			for ( var i=parseInt(oldSeq); i < sheetObjects[0].RowCount(); i++) {
				opt=document.createElement("option");
				opt.value=i + 1;
				opt.text=i + 1;
				obj.add(opt);
			}
			change_seq("sheet1", obj);
		}
		
		isCopy="true";
		compareItem();
		break;
	case IBSAVE: // Upload		
		doHBLSaveCopy();
		if(validateForm(sheetObj, formObj, sAction)==false){
			return false;
		}
		var params=getSaveStringForUpload();
 		var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0229_10GS.do", params);
		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
 			sheetObj.LoadSaveData(sXml);
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//mandatory validation not exist
	}
	return true;
}
/**
 * handler Upload button CLICK
 */
function validateForUpload() {
	return true;
}
/**
 * handler Upload button CLICK
 */
function getSaveStringForUpload() {
	if(sheetObjects[0].RowCount() == 0) return "";	
	var formObj=document.form;
	var params="";
	doHBLSaveCopy();
	for(var i=1;i<=sheetObjects[0].RowCount();i++){
		sheetObjects[0].SetCellValue(i, "pck_qty",ComTrimAll(sheetObjects[0].GetCellValue(i, "pck_qty"), ","),0);
		sheetObjects[0].SetCellValue(i, "hbl_wgt",ComTrimAll(sheetObjects[0].GetCellValue(i, "hbl_wgt"), ","),0);
		sheetObjects[0].SetCellValue(i, "cmdt_meas_qty",ComTrimAll(sheetObjects[0].GetCellValue(i, "cmdt_meas_qty"), ","),0);
	}
 	var sXml=formObj.sXml.value;
	formObj.sXml.value=null;
	formObj.f_cmd.value=MULTI;
	params=FormQueryString(formObj);
	formObj.sXml.value=sXml;
  	if (sheetObjects[0].RowCount()> 0 && ( ComGetObjValue(parent.frames["t1frame"].document.form.usa_cstms_file_cd) == '1' || ComGetObjValue(parent.frames["t1frame"].document.form.cnd_cstms_file_cd) == '1' )) {
  		params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
  	} else {
  		params="";
  	}		
	return params;
}
function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	//ComBtnColor("btn_cancelcopydata", "#737373");
	//ComBtnColor("btn_datacopytoopus", "blue");	
	
	document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;font-weight:bold;";
	document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;font-weight:bold;";
}
function compareItem() {
	var formObj = document.form;
	setDiffCheckColor(formObj.xter_si_no1.value,    formObj.xter_si_no2.value, 		'xter_si_no2');
	setDiffCheckColor(formObj.hbl_no.value,     	formObj.hbl_no2.value, 			'hbl_no2');
	setDiffCheckColor(formObj.shpr_nm.value,     	formObj.shpr_nm2.value, 		'shpr_nm2');
	setDiffCheckColor(formObj.shpr_addr.value,     	formObj.shpr_addr2.value, 		'shpr_addr2');
	setDiffCheckColor(formObj.cnee_nm.value,     	formObj.cnee_nm2.value, 		'cnee_nm2');
	setDiffCheckColor(formObj.cnee_addr.value,     	formObj.cnee_addr2.value, 		'cnee_addr2');
	setDiffCheckColor(formObj.noti_nm.value,     	formObj.noti_nm2.value, 		'noti_nm2');
	setDiffCheckColor(formObj.noti_addr.value,     	formObj.noti_addr2.value, 		'noti_addr2');
	setDiffCheckColor(formObj.hbl_wgt.value,     	formObj.hbl_wgt2.value, 		'hbl_wgt2');
	setDiffCheckColor(formObj.wgt_ut_cd.value,     	formObj.wgt_ut_cd2.value, 		'wgt_ut_cd2');
	setDiffCheckColor(formObj.pck_qty.value,     	formObj.pck_qty2.value, 		'pck_qty2');
	setDiffCheckColor(formObj.pck_tp_cd.value,     	formObj.pck_tp_cd2.value, 		'pck_tp_cd2');
	setDiffCheckColor(formObj.cmdt_meas_qty.value,  formObj.cmdt_meas_qty2.value, 	'cmdt_meas_qty2');
	setDiffCheckColor(formObj.cmdt_meas_ut_cd.value,formObj.cmdt_meas_ut_cd2.value, 'cmdt_meas_ut_cd2');
	setDiffCheckColor(formObj.bl_mk_desc.value,     formObj.bl_mk_desc2.value, 		'bl_mk_desc2');
	setDiffCheckColor(formObj.bl_gds_desc.value,    formObj.bl_gds_desc2.value, 	'bl_gds_desc2');
	
}
//copy HBL list to storage sheet
function doHBLSaveCopy() {	
	var formObj=document.form;
	var seq=ComGetObjValue(formObj.opus_seq);
	if (seq != '' ) {
		sheetObjects[0].SetCellValue(seq, "xter_si_no",document.form.xter_si_no1.value);
		sheetObjects[0].SetCellValue(seq, "hbl_no",document.form.hbl_no.value);
		sheetObjects[0].SetCellValue(seq, "shpr_nm",document.form.shpr_nm.value);
		sheetObjects[0].SetCellValue(seq, "shpr_addr",document.form.shpr_addr.value);
		sheetObjects[0].SetCellValue(seq, "cnee_nm",document.form.cnee_nm.value);
		sheetObjects[0].SetCellValue(seq, "cnee_addr",document.form.cnee_addr.value);
		sheetObjects[0].SetCellValue(seq, "noti_nm",document.form.noti_nm.value);
		sheetObjects[0].SetCellValue(seq, "noti_addr",document.form.noti_addr.value);
		sheetObjects[0].SetCellValue(seq, "hbl_wgt",document.form.hbl_wgt.value);
		sheetObjects[0].SetCellValue(seq, "wgt_ut_cd",document.form.wgt_ut_cd.value);
		sheetObjects[0].SetCellValue(seq, "pck_qty",document.form.pck_qty.value);
		sheetObjects[0].SetCellValue(seq, "pck_tp_cd",document.form.pck_tp_cd.value);
		sheetObjects[0].SetCellValue(seq, "cmdt_meas_qty",document.form.cmdt_meas_qty.value);
		sheetObjects[0].SetCellValue(seq, "cmdt_meas_ut_cd",document.form.cmdt_meas_ut_cd.value);
		sheetObjects[0].SetCellValue(seq, "bl_mk_desc",document.form.bl_mk_desc.value);
		sheetObjects[0].SetCellValue(seq, "bl_gds_desc",document.form.bl_gds_desc.value);
	}	
}
function form_onChange(){
	var srcName=ComGetEvent("name");
	var formObj=document.form;
	switch (srcName) {
	}
	isCopy="false";
	compareItem();
}
function form1_blur() {
	ComChkObjValid(event.srcElement);
}
//insert into sheet from form
function click_seq(obj) {
	var prefix="sheet3_";
	if (sheetObjects[0].RowCount()> 0) {
		sheetObjects[0].SetCellValue(obj.value, "xter_si_no",document.form.xter_si_no1.value);
		sheetObjects[0].SetCellValue(obj.value, "hbl_no",document.form.hbl_no.value);
		sheetObjects[0].SetCellValue(obj.value, "shpr_nm",document.form.shpr_nm.value);
		sheetObjects[0].SetCellValue(obj.value, "shpr_addr",document.form.shpr_addr.value);
		sheetObjects[0].SetCellValue(obj.value, "cnee_nm",document.form.cnee_nm.value);
		sheetObjects[0].SetCellValue(obj.value, "cnee_addr",document.form.cnee_addr.value);
		sheetObjects[0].SetCellValue(obj.value, "noti_nm",document.form.noti_nm.value);
		sheetObjects[0].SetCellValue(obj.value, "noti_addr",document.form.noti_addr.value);
		sheetObjects[0].SetCellValue(obj.value, "hbl_wgt",document.form.hbl_wgt.value);
		sheetObjects[0].SetCellValue(obj.value, "wgt_ut_cd",document.form.wgt_ut_cd.value);
		sheetObjects[0].SetCellValue(obj.value, "pck_qty",document.form.pck_qty.value);
		sheetObjects[0].SetCellValue(obj.value, "pck_tp_cd",document.form.pck_tp_cd.value);
		sheetObjects[0].SetCellValue(obj.value, "cmdt_meas_qty",document.form.cmdt_meas_qty.value);
		sheetObjects[0].SetCellValue(obj.value, "cmdt_meas_ut_cd",document.form.cmdt_meas_ut_cd.value);
		sheetObjects[0].SetCellValue(obj.value, "bl_mk_desc",document.form.bl_mk_desc.value);
		sheetObjects[0].SetCellValue(obj.value, "bl_gds_desc",document.form.bl_gds_desc.value);
	}
}
//get from sheet to form
function change_seq(sheet, obj) {
	var formObj = document.form;
	var prefix="";
	var postfix="";
	var rqstfix=""
	var cn=0;
	if (sheet == "sheet1") {
		prefix="sheet1_";
		postfix="";
		rqstfix="1"
		cn=0;
//		formObj.xter_si_no1.value = sheetObjects[cn].GetCellValue(obj.value, "xter_si_no");
	} else {
		prefix="sheet2_";
		postfix="2";
		cn=1;
//		eval("formObj.xter_si_no" 		+ postfix + rqstfix ).value=sheetObjects[cn].GetCellValue(obj.value, "xter_si_no");
	}
	eval("formObj.xter_si_no" 		+ postfix + rqstfix ).value=sheetObjects[cn].GetCellValue(obj.value, "xter_si_no");
	eval("formObj.hbl_no" 			+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "hbl_no");
	eval("formObj.shpr_nm" 			+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "shpr_nm");
	eval("formObj.shpr_addr" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "shpr_addr");
	eval("formObj.cnee_nm" 			+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cnee_nm");
	eval("formObj.cnee_addr" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cnee_addr");
	eval("formObj.noti_nm" 			+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "noti_nm");
	eval("formObj.noti_addr" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "noti_addr");
	eval("formObj.hbl_wgt" 			+ postfix).value=ComAddComma3(sheetObjects[cn].GetCellValue(obj.value, "hbl_wgt"), "#,###.000");
	eval("formObj.wgt_ut_cd" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "wgt_ut_cd");
	eval("formObj.pck_qty" 			+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "pck_qty");
	eval("formObj.pck_tp_cd" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "pck_tp_cd");
	eval("formObj.cmdt_meas_qty" 	+ postfix).value=ComAddComma3(sheetObjects[cn].GetCellValue(obj.value, "cmdt_meas_qty"), "#,###.000");
	eval("formObj.cmdt_meas_ut_cd" 	+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cmdt_meas_ut_cd");
	eval("formObj.bl_mk_desc" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "bl_mk_desc");
	eval("formObj.bl_gds_desc" 		+ postfix).value=sheetObjects[cn].GetCellValue(obj.value, "bl_gds_desc");
	if (sheet == "sheet1") {
		comboObjects[0].SetSelectCode(sheetObjects[cn].GetCellValue(obj.value, "wgt_ut_cd"),false);
		comboObjects[1].SetSelectCode(sheetObjects[cn].GetCellValue(obj.value, "cmdt_meas_ut_cd"),false);
	}
}
function wgt_ut_cd_OnChange(comboObj, value, text) {
	var formObj=document.form;
	setDiffCheckColor(text, wgt_ut_cd2.value, ("wgt_ut_cd2"));
}
function cmdt_meas_ut_cd_OnChange(comboObj, value, text) {
	var formObj=document.form;
	setDiffCheckColor(text, cmdt_meas_ut_cd2.value, ("cmdt_meas_ut_cd2"));
}
function setCallBack0696(aryPopupData) {
	var formObj=document.form;
	formObj.pck_tp_cd.value=aryPopupData[0][2];
}
function callbackPckTp(returnVal){
	document.form.pck_tp_cd.value=returnVal.cd;
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