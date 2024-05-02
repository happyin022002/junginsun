/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0507.js
*@FileTitle  : US AMS: Transmission History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// var arrUser = new Array('SDS_KOR','110804','EDI_KOR','110039','110035','04900013','03191005','03206014','03206015','03206030');
// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/* */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
        
		switch (srcName) {
		case "btn_calendar":
			if (formObject.snd_fromd.disabled)
				return;
			var cal=new ComCalendarFromTo();
			cal.select(formObject.snd_fromd, formObject.snd_tod, 'yyyy-MM-dd');
			break;
		case "btn_retrieve":
			formObject.io_bnd_cd.value='I';
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
			break;
		case "btn_file":
			doActionIBSheet(sheetObjects[0], formObject, IBROWSEARCH);
			break;
		case "btn_ofm_retrieve":
			formObject.io_bnd_cd.value='O';
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_ofm_file":
			doActionIBSheet(sheetObjects[0], formObject, IBROWSEARCH);
			break;
        case "btn_Downexcel":
            if(sheetObjects[0].RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
            }
            break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
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
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}

/**
 * initializing Combo Object
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "trsm_msg_tp_id":
		var i=0;
		with (comboObj) {
			SetColBackColor(0,"#CCFFFD");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
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
	}
	for (i=0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	// creating combo data
	var sXml=document.form.code_list.value;
	ComXml2ComboItem(sXml, trsm_msg_tp_id, "val", "name|desc");
	trsm_msg_tp_id.SetSelectCode('AL');
	ComBtnDisable("btn_file");
	// activating button of OFM History Retrieve, View OFM File 
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	document.form.vvd.focus();
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
	case "sheet1": //sheet1 init
	    with(sheetObj){
    	  	SetShowSortArrow(1);
      		var HeadTitle1="|Seq.|MSG|SEND DATE|SEND DATE|OFFICE|USER ID|VVD|POL|POD|Customs|B/L No.|TTL CNTR||||||";

      		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      		InitHeaders(headers, info);

      		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
      		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
      		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"trsm_msg_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"snd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"snd_tm",          KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cstms_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"cntr_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"stwg_snd_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"his_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Date",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"snd_date",        KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"msg_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
       
            InitColumns(cols);

            SetEditable(0);
			SetCountFormat("[SELECTDATAROW / TOTALROWS]");
//            SetSheetHeight(400);
            ComResizeSheet(sheetObj);
      	}
	    break;
	}
}

/**
 * when inputting search condition
 */
function obj_KeyUp() {
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent().getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	/**if (keyValue != 9 && keyValue !=16 &&(srcName == "vvd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}*/
}

/**
 * when clicking check box
 */
function obj_click() {
	var formObject=document.form;
	var srcObj=ComGetEvent();
	var srcName=srcObj.getAttribute("name");
	var srcVal=srcObj.checked;
	if (srcName == "gubun") {
		alterRequiredChk(srcVal);
	}
}

/**
 * handling buttons according to status of check box
 */
function alterRequiredChk(checked) {
	var formObject=document.form;
	if (checked) {
		formObject.snd_fromd.disabled=false;
		formObject.snd_tod.disabled=false;
		formObject.snd_fromt.disabled=false;
		formObject.snd_tot.disabled=false;
	} else {
		formObject.snd_fromd.disabled=true;
		formObject.snd_tod.disabled=true;
		formObject.snd_fromt.disabled=true;
		formObject.snd_tot.disabled=true;
		formObject.vvd.focus();
	}
}

/**
 * handling buttons after retrieving
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == '' && sheetObj.RowCount()> 0) {
		var io_bnd_cd=document.form.io_bnd_cd.value;
		if (io_bnd_cd == "I") {
			ComBtnEnable("btn_file");
			ComBtnDisable("btn_ofm_file");
		} else {
			ComBtnEnable("btn_ofm_file");
			ComBtnDisable("btn_file");
			if (trsm_msg_tp_id.GetSelectCode()!= 'AL' && trsm_msg_tp_id.GetSelectCode()!= 'MI') {
				trsm_msg_tp_id.SetSelectCode('MI');
			}
		}
	}
}

/**
 * sorting in case of clicking header
 */
function sheet1_OnSort(sheetObj, col, sortArr) {
	if (col == 3) {
		sheetObj.ColumnSort("snd_dt|snd_tm", sortArr);
	}
}

var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBCREATE:
			formObj.f_cmd.value=SEARCH02;
	 		var sXml=sheetObj.GetSearchData("ESM_BKG_0507GS.do", FormQueryString(formObj));
			var userAuthStr=ComGetEtcData(sXml, "user_auth_str");
			// activating/deactivating OFM List Retrieve, Preparation buttons according to authority 
			if (userAuthStr == "Y") {
				ComBtnEnable("btn_ofm_retrieve");
				ComBtnEnable("btn_ofm_file");
			} else {
				ComBtnDisable("btn_ofm_retrieve");
				ComBtnDisable("btn_ofm_file");
			}
			break;
		case IBSEARCH: //retrieve
			if (!validateForm(sheetObj, formObj, sAction))
				return false;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
//			if (formObj.bl_no.value != "") {
//				formObj.vvd.value="";
//				formObj.pol_cd.value="";
//				formObj.pod_cd.value="";
//				formObj.snd_ofc_cd.value="";
//				formObj.snd_usr_id.value="";
//				formObj.lst_for_pol.value="";
//				formObj.trsm_msg_tp_id.value="";
//				formObj.snd_fromd.value=today;
//				formObj.snd_tod.value=today;
//				formObj.gubun.checked=false;
//				alterRequiredChk(false);
//			}
			var ioBndCd=formObj.io_bnd_cd.value;
			if (ioBndCd == "I") {
				formObj.ofm_flg.value='N';
			} else {
				formObj.ofm_flg.value='Y';
			}
			iPageNo = 1;
	 		sheetObj.DoSearch("ESM_BKG_0507GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
			break;
		case IBSEARCHAPPEND: // 
			if (!validateForm(sheetObj, formObj, IBSEARCH))
				return false;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
	 		sheetObj.DoSearch("ESM_BKG_0507GS.do", CondParam+"&iPage="+PageNo, {Append:true});
			ComOpenWait(false);
			break;
		case IBROWSEARCH:
			if (sheetObj.RowCount()== 0)
				return false;
			var params;
			var vvd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vvd");
			var pol=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pol_cd");
			var pod=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pod_cd");
			var ofc=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ofc_cd");
			var usr=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "usr_id");
			params="vvd2=" + vvd + "&pol=" + pol + "&pod=" + pod + "&ofc=" + ofc + "&usr=" + usr;
			var msg_tp=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trsm_msg_tp_id");
			if (msg_tp == "BAPLIE" || msg_tp == "ISF-5") {
				var stwg_snd_id=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "stwg_snd_id");
				var snd_date=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "snd_date");
				params=params + "&trsm_msg_tp_id=" + msg_tp + "&stwg_snd_id=" + stwg_snd_id + "&snd_date=" + snd_date;
			} else {
				var cnt_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cnt_cd");
				var io_bnd_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "io_bnd_cd");
				var snd_date=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "snd_date");
				var his_seq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "his_seq");
				params=params + "&trsm_msg_tp_id=" + msg_tp + "&cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd + "&snd_date="
						+ snd_date + "&his_seq=" + his_seq;
			}
			if (ComIsBtnEnable("btn_ofm_file")) {
				params=params + "&ofm=Y";
			} else {
				params=params + "&ofm=N";
			}
			ComOpenWindowCenter("ESM_BKG_0508.do?" + params, "ESM_BKG_0508", 700, 640, false);
			break;
		case IBCLEAR: //initializing
			formObj.reset();
			comboObjects[0].SetSelectCode('AL');
			sheetObj.RemoveAll();
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (formObj.gubun.checked) {
			if (!ComChkRequired(formObj))
				return false;
			var days=ComGetDaysBetween(formObj.snd_fromd.value, formObj.snd_tod.value);
			if (days >= 15) {
				ComShowCodeMessage('BKG50468'); // Can't Input Date Over 15 days!"
				formObj.snd_fromd.focus();
				return false;
			}
		} else {
			if (ComIsNull(formObj.vvd) && ComIsNull(formObj.bl_no)) {
				ComShowMessage("'VVD' or 'B/L No.'" + Msg_Required);
				return false;
			}
		}
		return true;
		break;
	default:
		return true;
		break;
	}
}

/**
 * double click event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	if (document.form.io_bnd_cd.value != "O") {
		document.form.io_bnd_cd.value="";
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
	}
}