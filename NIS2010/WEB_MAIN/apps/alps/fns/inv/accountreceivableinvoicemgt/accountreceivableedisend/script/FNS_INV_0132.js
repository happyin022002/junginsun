/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0132.js
*@FileTitle : EDI Submission (Philips)
*Open Issues :
*Change history :
*@LastModifyDate : 2012-12-04
*@LastModifier : 9011620
*@LastVersion : 1.0
* 2012.12.04 9011620
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * Define script for creating screen.
 */
function FNS_INV_0132() {
	this.setSheetObject 			= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            	= initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

// Common variable.
var sheetObjects = new Array();
var sheetCnt = 0;

// IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

// Checking readOnly calendar.
var isCalendar = false;

// Define event handle for button.
document.onclick = processButtonClick;

/** 
 * Selecting logic by button's name.
 */
function processButtonClick(){
	// Selection sheet.
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btns_calendar" : // Opening calendar.
			var cal = new ComCalendar();
			cal.setDisplayType("date");
			cal.select(formObj.bil_dt, "yyyy-MM-dd");
            break;
		case "btn_Retrieve" :
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
		case "btn_New" :
			removeAll(formObj);
			break;
		case "btn_SendBL" :
			doActionIBSheet(sheetObj, formObj, IBINSERT);
			break;
//		case "btn_actcust":
//			var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObj.cust_cnt_cd.value+'&cust_seq='+formObj.cust_seq.value+'&pop_yn=Y';
//			ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
//			break;	
		case "btn_DownExcel" :
			sheetObj.Down2Excel(-1);
			break;
		case "btns_calendar1" :
			if (isCalendar) {
				var cal = new ComCalendar();
				cal.select(formObj.fm_dt, "yyyy-MM-dd");
			}
			break;
		case "btns_calendar2" :
			if (isCalendar) {
				var cal = new ComCalendar();
				cal.select(formObj.to_dt, "yyyy-MM-dd");
			}
			break;
			
//		case "btn_custNm":
//			var param = '?pgmNo=FNS_INV_0086&cust_seq='+formObj.cust_seq.value+'&cust_cnt_cd='+formObj.cust_cnt_cd.value;
//			var Row = 1;
//			var Col = 1;
//			ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
//			break;	
		}
	} catch(e) {
		if ( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Add sheet to array.
 * 
 * @param sheet_obj
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Add combo object to array.
 * 
 * @param combo_obj
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/** 
 * Initialize.
 */
function loadPage() {
	var formObj = document.form;

	for (var i=0; i<sheetObjects.length; i++) {
		// Call initial setting.
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);

		// Call latest setting.
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// Initialize IBMultiCombo.
	for (var k=0; k<comboObjects.length; k++) {
		initCombo(comboObjects[k], k+1);
	}

	initControl();
//	formObj.cust_cnt_cd.value = "US";
//	formObj.cust_seq.value = "062290";
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
	fn_cust_nm();

	// Initialize buttons.
	ComBtnDisable("btn_SendBL");
	ComBtnDisable("btn_DownExcel");

	formObj.retr_input.focus();
}

/**
 * Initialize sheet and header.
 * Coding logic by sheet's count.
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1" :
		with (sheetObj) {
			style.height = 400;
			SheetWidth = mainTable.clientWidth;
		
			// Set host information(Request:HostIp, Port, PagePath).
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// Merge kind(Option:Default msNone).
			MergeSheet = msPrevColumnMerge; //msPrevColumnMerge + msHeaderOnly; or msHeaderOnly;

			// Set use edit(Option:Default false).
			Editable = true;
			sheetObj.EditableColorDiff = false;

			// Set row information(Request:HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100).
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "||Sel.|B/L No.|EDI Date|EDI Status|FRT_USD|CHG_OTH|TTL_USD|VVD|S/A Date|INV Cust.|INV Cust.|Location Code|Order NO|POR|POL|POD|DEL|actCust.|actCust.|ofc";
			var headCount = ComCountHeadTitle(HeadTitle);

			// Set column information(Request:COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false).
			InitColumnInfo(headCount, 0, 0, true);

			// Set header's function.
			InitHeadMode(false, false, true, true, false, false);

			// Set header row information(Request:ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false).
			InitHeadRow(0, HeadTitle, true);

			var rowCnt = 0; 

			// Data attribute(ROW,      COL,    DATATYPE,       WIDTH,  DATAALIGN,      COLMERGE,    SAVENAME,          KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX).
			InitDataProperty(rowCnt,	cnt++,	dtHidden,			0,	    daCenter,		true,		 "merge_chk",		false,		"",			dfNone,    	0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	0,		daCenter,		true,		 "ibflag");
			InitDataProperty(rowCnt,	cnt++,	dtCheckBox,		45,		daCenter,		true,		 "sel_chk");
			InitDataProperty(rowCnt,	cnt++,	dtData,			90,		daCenter,		true,		 "bl_src_no",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			90,		daCenter,		true,		 "edi_snd_dt",		false,		"",			dfDateYmd,	0,			false,		false);

			InitDataProperty(rowCnt,	cnt++,	dtData,			90,		daCenter,		true,		 "ack_rslt_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			85,		daRight,		true,		 "frt_usd_rt_amt",	false,		"",			dfInteger,	0,				false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			85,		daRight,		true,		 "otr_usd_conv_amt",false,		"",			dfInteger,	0,				false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			85,		daRight,		true,		 "ttl_usd_amt",		false,		"",			dfInteger,	0,				false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			120,	daCenter,		true,		 "vvd",					false,		"",			dfNone,		0,			false,		false);

			InitDataProperty(rowCnt,	cnt++,	dtData,			90,		daCenter,		true,		 "sail_arr_dt",			false,		"",			dfDateYmd,	0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			30,		daCenter,		true,		 "inv_cust_cnt_cd",	false,		"",			dfNone,	    0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		true,		 "inv_cust_seq",		false,		"",			dfNone,	    0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			120,	daCenter,		true,		 "phils_loc_cd_ctnt",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			120,	daCenter,		true,		 "cust_ref_no_ctnt",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		true,		 "por_cd",				false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		true,		 "pol_cd",				false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		true,		 "pod_cd",			false,		"",			dfNone,		0,			false,		false);

			InitDataProperty(rowCnt,	cnt++,	dtData,			75,		daCenter,		true,		 "del_cd",				false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtHidden,	    	30,		daCenter,		true,		 "act_cust_cnt_cd",	false,		"",			dfNone,	    0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtHidden,			50,		daCenter,		true,		 "act_cust_seq",		false,		"",			dfNone,	    0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtHidden,			50,		daCenter,		true,		 "ofc_cd",      		false,		"",			dfNone,	    0,			false,		false);

			CountPosition = 2;
			SelectHighLight = false;
		}
		break;			
	}
}

/**
 * Initialize combo.
 * 
 * @param comboObj
 * @param comboNo
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "retr_opt" :
		with (comboObj) {
			InsertItem(0, "B/L No.",					"B");
			InsertItem(1, "S/A Date",				"S");
			InsertItem(2, "VVD", 					"V");
			InsertItem(3, "EDI Sent Date",			"E");

			Code = "B";

			MultiSelect = false;
			UseCode = true;
			SetColAlign("left");
			MultiSeparator = ",";
			DropHeight = 190;
		}
		break;
	case "sent_stat":
		with (comboObj) {
			RemoveAll();
			InsertItem(0, "ALL",		"A");
			InsertItem(1, "SENT",		"Y");
			InsertItem(2, "NOT SENT",	"N");

			Code = "A";

			MultiSelect = false;
			UseCode = true;
			SetColAlign("left");
			MultiSeparator = ",";
			DropHeight = 190;
		}
		break;
	}
}

/** 
 * Initialize object's event.
 */
function initControl() {
	var formObj = document.form;

	// Catching event.
	axon_event.addListenerFormat("keypress", "obj_keypress", formObj);
	axon_event.addListenerFormat("focus", "obj_activate", formObj);
	axon_event.addListenerForm("keyup", "obj_keyup", formObj);
	axon_event.addListenerForm("blur", "obj_deactivate", formObj);
	axon_event.addListenerForm("change", "obj_onchange", formObj);
}
	
/**
 * On key press.
 */
function obj_keypress() {
	var formObj = document.form;

	switch (event.srcElement.dataformat) {
	case "float" :
		// Only number or '.'.
		ComKeyOnlyNumber(event.srcElement, ".-"); 
		break;
	case "int" :
		// Only number.
		ComKeyOnlyNumber(event.srcElement,"-"); 
		break;
	case "engup" :
		switch (event.srcElement.name) {
		case "retr_input" :
			// Only upper case or number.
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "ar_if_no" :
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "cust_cnt_cd" :
			// Only upper case.		    	        
			ComKeyOnlyAlphabet('upper');
			break;
		case "port" :		    	        
			ComKeyOnlyAlphabet('upper'); 
			break;
		}
		break;
	default :
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
}

/**
 * On before activate.
 */
function obj_activate() {
	var formObj = document.form;

	// Remove mask seperator.
	ComClearSeparator (event.srcElement);
	event.srcElement.select();
}

/**
 * On key up.
 */
function obj_keyup() {
	var formObj = document.form;

	switch (event.srcElement.name) {
	case "cust_cnt_cd" :
		var custCntCd = event.srcElement.value;

		if (custCntCd.length == 2) {
			formObj.cust_seq.focus();
		}
		break;
	}
}

/**
 * On before deactivate.
 */
function obj_deactivate() {
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	switch (event.srcElement.name) {
	case "cust_seq" :
		if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
			var valueCustSeq = formObj.cust_seq.value;
			formObj.cust_seq.value = ComLpad(valueCustSeq, 6, "0");

			doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);

			var custCd = "";
			if (formObj.cust_nm.value != '') {
				custCd = formObj.cust_cnt_cd.value+ComLpad(valueCustSeq, 6, "0");
			} else {
				custCd = "";
				formObj.cust_seq.focus();
			}
		} else {
			formObj.cust_nm.value = "";
		}
		break;
	default:
		// Checking length.
		ComChkObjValid(event.srcElement);
		break;
	}
}

/** 
 * On change.
 */
function obj_onchange() {
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	switch (event.srcElement.name) {
	case "vvd" :
       	break;
    }
}

/**
 * Function for retrieve, save.
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH_ASYNC01 : // Retrieve initial AR_OFFICE_LIST.
		ComOpenWait(true);

		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));

		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");

		makeComboObject(formObj.ar_ofc_cd, arrStr);

		var arrStr2 = "";
		var ar_ofc_cd = "";

		for (var i=1; i<arrStr.length; i++) {
			arrStr2 = arrStr[i].split("^");
			if (arrStr2[1]==arrStr2[3]) {
				ar_ofc_cd = arrStr2[1];

				formObj.ofc.value = ar_ofc_cd;
				formObj.ofc_cd.value = formObj.ofc.value;	
			}
		}
		formObj.ar_ofc_cd.text = ar_ofc_cd;	

		ComOpenWait(false);
		break;
	case IBSEARCH : // Retrieve.
		if (validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCHLIST;

			var sXml = sheetObj.GetSearchXml("FNS_INV_0132GS.do", FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");

			if (sXml.indexOf("ERROR") < 1) {
				if (arrXml[0] != null) {
					sheetObj.LoadSearchXml(arrXml[0]);
					if (sheetObjects[0].RowCount==0) {
						ComShowCodeMessage("COM130401");
						formObj.retr_input.select();
					}
				}
			}
			
			if(	formObj.retr_opt.Code  == "B" && (formObj.cust_cnt_cd.value =="" ||formObj.cust_seq.value =="") ){
				formObj.cust_cnt_cd.value = sheetObj.CellValue(1,"act_cust_cnt_cd");
				formObj.cust_seq.value = sheetObj.CellValue(1,"act_cust_seq");
				formObj.cust_nm.value = "";
				fn_cust_nm();
			}
			
		} 
		break;
	case IBINSERT : // Save.
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;

			var iCheckRow = sheetObj.FindCheckedRow("sel_chk");
            
			if (iCheckRow == "") {
				ComShowCodeMessage("INV00025");
				return;
			}

			var sParam = sheetObj.GetSaveString(false, true, "sel_chk");
			if (sParam == "") {
				return;
			}

			var sXml = sheetObj.GetSaveXml("FNS_INV_0132GS.do", FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false, true, "sel_chk"), "sheet1_"));

			if (sXml.indexOf("ERROR") < 1) {
				ComShowCodeMessage("INV00051");

				formObj.f_cmd.value = SEARCHLIST;
				sXml = sheetObj.GetSearchXml("FNS_INV_0132GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml[0] != null) {
					sheetObj.LoadSearchXml(arrXml[0]);
					if (sheetObjects[0].RowCount == 0) {
						ComShowCodeMessage("COM130401");
						formObj.retr_input.select();
					}
				}
			} else {
				ComShowCodeMessage("INV00053");
			}
//			ComBtnDisable("btn_SendBL");
		}
		break;
	}
}

/**
 * Set sheet's combo box.
 * 
 * @param sheetObj  
 * @param comboValues
 * @param colName
 * @param isCellCombo
 * @param sRow
 */		
function addCellComboItem(sheetObj, comboValues, colName, isCellCombo, sRow) {
	var comboTxt = "";
	var comboVal = "";
	var comboItems;
	var comboItem;
	var ROWMARK = "|";
	var FIELDMARK = "=";

	comboValues = "|" + " " + comboValues;
	if (comboValues != undefined) {
		comboItems = comboValues.split(ROWMARK);
		for (var i=1; i<comboItems.length; i++) {				
			comboItem = comboItems[i].split(FIELDMARK);
			if (comboItem[0] != "") {
				comboTxt += comboItem[0];
				comboVal += comboItem[0];
			}
			if (i < comboItems.length-1) {
				comboTxt += ROWMARK;
				comboVal += ROWMARK;
			}
		}
	}
	if (isCellCombo) {
		sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
	} else {
		sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
	}
}

/**
 * Checking validation values.
 * 
 * @param sheetObj  
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH : // Retrieve.
		with (formObj) {
		   var retr = retr_input.value ;
			if (retr_opt.Code =="B" && retr =="") {
				ComShowCodeMessage("INV00004");
				retr_input.focus();
				return false;
			}
			
			if ( retr_opt.Code =="V" && retr.length != 9 ) {
				ComShowCodeMessage("INV00039");
				retr_input.focus();
				return false;
			}
			if ((retr_opt.Code =="S" || retr_opt.Code =="E")&& (fm_dt.value =="" ||to_dt.value=="")) {
				ComShowCodeMessage("INV00004");
				fm_dt.focus();
				return false;
			}
			if (cust_cnt_cd.value == "" && retr_opt.Code !="B") {
				ComShowCodeMessage("INV00004");
				cust_cnt_cd.focus();
				return false;
			}
			if (cust_seq.value == ""&& retr_opt.Code !="B") {
				ComShowCodeMessage("INV00004");
				cust_seq.focus();
				return false;
			}
			if (ComGetDaysBetween(fm_dt.value,to_dt.value)>90) {
				ComShowCodeMessage("INV00043");
				to_dt.focus();
				return;
			}
		}
		break;
	case IBINSERT : // Save.
		with (formObj) {
			
			var dupCnt = 0;
			var idx1 = sheetObj.RowCount;
			var dupBlNos = "";
					
			if (idx1 > 0) {
				for (var k=1; k<idx1+1; k++) {	
					
					if (sheetObj.CellValue(k,"sel_chk") == '1') {				
						var blSrcNo = sheetObj.CellValue(k, "bl_src_no");
						
						for (var t=1; t<sheetObj.RowCount+1; t++) {					
							var blSrcNoChk = sheetObj.CellValue(t, "bl_src_no");
							var ediSndDt = sheetObj.CellValue(t, "edi_snd_dt");
							var ediStatus = sheetObj.CellValue(t, "ack_rslt_cd");						
							if ((blSrcNo == blSrcNoChk) && ediSndDt != '' && (ediStatus == 'Accept' || ediStatus == '')) {						
								dupBlNos = dupBlNos + blSrcNo + ' ';
								sheetObj.CellValue2(k,"sel_chk") = "0";
								sheetObj.CellEditable(k, "sel_chk") = false;
								sheetObj.CellBackColor(k, "sel_chk") = sheetObj.RgbColor(230, 230, 230);
									
								dupCnt++;
							}
						}
					}
				}
				
				if (dupCnt > 0) {
					ComShowCodeMessage("INV00166", dupBlNos );
				}
				
			} else {
				ComShowCodeMessage("INV00091");
				return false;
			}		
			
			var chkCnt = 0;
			var idx = sheetObj.RowCount;
	
			if (idx > 0) {
					var isNotOrderNo = false;
					for (var i=1; i<idx+1; i++) {
						for (var j=1; j<sheetObj.RowCount+1; j++) {
							if (sheetObj.CellValue(j,"sel_chk") == '1') {
								var orderNo = sheetObj.CellValue(j, "cust_ref_no_ctnt");
								orderNo = orderNo.replace(/ |,/g, "");
								if (orderNo == "") {
									ComShowCodeMessage("INV00157", sheetObj.CellValue(j, "bl_src_no"));
									return false;
								}
								chkCnt ++;
							}
						}
					}
					if (chkCnt < 1) {
						ComShowCodeMessage("INV00025");
						return false;
					}

				for (var j=1; j<sheetObj.RowCount+1; j++) {
					if (sheetObj.CellValue(j,"sel_chk") == '1') {
						var loc_cd = sheetObj.CellValue(j, "phils_loc_cd_ctnt");
						if (loc_cd == "") {
							ComShowCodeMessage("INV00164", sheetObj.CellValue(j, "phils_loc_cd_ctnt"));
							return false;
						}
					}
				}

			} else {
				ComShowCodeMessage("INV00091");
				return false;
			}
		}
		break;
	}
	return true;
}

/**
 * Initalization screen.
 * 
 * @param formObj
 */
function removeAll(formObj) {
	// Initialzation B/L, charge grid.
	sheetObjects[0].RemoveAll();

	// Initialize combo
	comboObjects[0].Code = "B";			
	comboObjects[1].Code = "A";		

	// Initialize button
	ComBtnDisable("btn_SendBL");
	ComBtnDisable("btn_DownExcel");

	formObj.retr_input.value = "";
	formObj.cust_cnt_cd.value = "US";
	formObj.cust_seq.value = "062290";
	formObj.cust_nm.value = "";
	fn_cust_nm();
	formObj.retr_input.focus();
}

/**
 * Initialzation input date.
 * 
 * @param formObj
 */
function setDefaultDateValue(formObj) {
	var today= new Date();

	var year = today.getYear();
	var mon  = today.getMonth() + 1;
	var sday = today.getDate();

	formObj.fm_dt.value = year + "-" + ComLpad(mon, 2, "0") + "-" + ComLpad(sday, 2, "0");
	formObj.to_dt.value = year + "-" + ComLpad(mon, 2, "0") + "-" + ComLpad(sday, 2, "0");
}

/**
 * Search finish.
 * 
 * @param sheetObj
 * @param errorMsg
 */
function sheet1_OnSearchEnd(sheetObj, errorMsg) {
	ComBtnEnable("btn_SendBL");
	ComBtnEnable("btn_DownExcel");

	for (var i=1; i<(sheetObj.RowCount + 1); i++) {
		if (sheetObj.CellValue(i, "edi_snd_dt") != "" && sheetObj.CellValue(i, "ack_rslt_cd") != "Reject") {
			sheetObj.CellEditable(i, "sel_chk") = false;
			sheetObj.CellBackColor(i, "sel_chk") = sheetObj.RgbColor(230, 230, 230);
		}
	}
}

/**
 * On change in grid.
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var colSaveName = sheetObj.ColSaveName(col);

	switch (colSaveName) {
	case "sel_chk" :
		break;
	default :
		break;
	}
}

/**
 * On click in grid.
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col ,value) {
	var rowCnt = sheetObj.RowCount;
	var colSaveName = sheetObj.ColSaveName(col);

	switch (colSaveName) {
	case "sel_chk" :
		break;
	case "cust_ref_no_ctnt" :
		var param = "?pgmNo=FNS_INV_0126&row=" + row + "&orderNos=" + sheetObj.CellText(row, "cust_ref_no_ctnt") + "&pop_yn=Y";
		ComOpenPopup("/hanjin/FNS_INV_0126.do" + param, 350, 350, "", "0,0", false, false, "", "", 0);
		break;
	}
}

/**
 * On change in combo box.
 * 
 * @param comboObj
 * @param indexCode
 * @param text
 */
function retr_opt_OnChange(comboObj, indexCode, text) {
	var formObj = document.form;
	isCalendar = true;

	if (indexCode == "B"){
		formObj.cust_cnt_cd.className = "input";
		formObj.cust_seq.className = "input";
	}else{
		formObj.cust_cnt_cd.className = "input1";
		formObj.cust_seq.className = "input1";
	}
	
	if (indexCode == "B" || indexCode == "V") {
		with (formObj.sent_stat) {
			RemoveAll();
			InsertItem(0, "ALL",		"A");
			InsertItem(1, "SENT",		"Y");
			InsertItem(2, "NOT SENT",	"N");
			Code = "A";
		}

		isCalendar = false;
		formObj.retr_input.readOnly = false;
		formObj.fm_dt.readOnly = true;
		formObj.to_dt.readOnly = true;
		formObj.retr_input.className = "input1";
		formObj.fm_dt.className = "input2";
		formObj.to_dt.className = "input2";
		formObj.fm_dt.value = "";
		formObj.to_dt.value = "";
		formObj.retr_input.focus();

	} else if (indexCode == "S") {
		with (formObj.sent_stat) {
			RemoveAll();
			InsertItem(0, "ALL",		"A");
			InsertItem(1, "SENT",		"Y");
			InsertItem(2, "NOT SENT",	"N");
			Code = "A";
		}

		formObj.retr_input.readOnly = true;
		formObj.fm_dt.readOnly = false;
		formObj.to_dt.readOnly = false;
		formObj.retr_input.className = "input2";
		formObj.fm_dt.className = "input1";
		formObj.to_dt.className = "input1";
		formObj.retr_input.value = "";
		formObj.fm_dt.focus();
	} else if (indexCode == "E") {
		with (formObj.sent_stat) {
			RemoveAll();
			InsertItem(0, "SENT",		"Y");
			Code = "Y";
		}

		formObj.retr_input.readOnly = true;
		formObj.fm_dt.readOnly = false;
		formObj.to_dt.readOnly = false;
		formObj.retr_input.className = "input2";
		formObj.fm_dt.className = "input1";
		formObj.to_dt.className = "input1";
		formObj.retr_input.value = "";
		formObj.fm_dt.focus();
	}

	// Initialize B/L, charge grid.
	sheetObjects[0].RemoveAll();

	// Initialize combo.
	comboObjects[1].Code = "S";

	// Initialize button.
	ComBtnDisable("btn_SendBL");
	ComBtnDisable("btn_DownExcel");
}

/**
 * After validating date, set masked value.
 * 
 * @param elNm
 */
function fn_ComGetMaskedValue(elNm) {
	var formObj;

	if (elNm == "fm_dt") {
		formObj = form.fm_dt;
	} else {
		formObj = form.to_dt;
	}

	var value = formObj.value;

	if (value=="") return;

	value = ComReplaceStr(value,"-","");

	if (value.length < 8) {
		ComShowCodeMessage("INV00024");
		return;
	}

	if (value.substring(4,6) > 12) {
		ComShowCodeMessage("INV00024");
		return;
	}
	if (value.substring(4,6) == 00) {
		ComShowCodeMessage("INV00024");
		return;
	}
	if (value.substring(6,8) > 31) {
		ComShowCodeMessage("INV00024");
		return;
	}
	if (value.substring(6,8) == 00) {
		ComShowCodeMessage("INV00024");
		return;
	}

	var ret = ComGetMaskedValue(value, "ymd");

	formObj.value = ret;
	if (elNm == "fm_dt") {
		if (form.to_dt.value=="") {
			form.to_dt.value = ret;
		}
		form.to_dt.select();
	}
}

	/**
	 * 선택된 탭의 fm_dt 자릿수 체크하여  to_dt로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('20090901');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
/**
 * Checking fm_dt's length.
 * 
 * @param value
 */
function checkFmDtLeng(value) {    	  
	if (ComTrimAll(value, " ", "-", ":").length==8) {
		if (document.form.to_dt.value=="") {
			document.form.to_dt.value = ComTrimAll(value, " ", "-", ":");
		}
		document.form.to_dt.select();
	}
}

/**
 * Making combo.
 * 
 * @param cmbObj
 * @param arrStr
 */
function makeComboObject(cmbObj, arrStr) {
	for (var i=1; i<arrStr.length; i++) {
		var arrStr2 = arrStr[i].split("^");
		var ar_ofc_cd = arrStr2[1];
		cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
	}
	cmbObj.DropHeight = 190;
}

/**
 * Retrieve customer's name.
 */
function fn_cust_nm() {
	document.form.f_cmd.value = SEARCH03;
	var cust_nm = "";

	if (form.cust_cnt_cd.value.trim()!="" && form.cust_seq.value.trim()!="") {
		form.cust_seq.value = ComLpad(form.cust_seq.value.trim(), 6, "0");			
		var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
		if (cust_nm == undefined) {
			form.cust_nm.value = "";
			ComShowCodeMessage("INV00008");
			form.cust_seq.value="";
			form.cust_seq.focus();
			return;
		} else {
			form.cust_nm.value=cust_nm;
		}
	}
}

/**
 * After popup
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function getFNS_INV_0126(row, value) {
	var sheetObject = sheetObjects[0];
	sheetObject.CellValue2(row, "cust_ref_no_ctnt") = value;
}

/**
 * On change in ar_ofc_cd.
 * 
 * @param comboObj
 * @param value
 * @param text
 */
function ar_ofc_cd_OnChange(comboObj, value, text){ 
	sheetObjects[0].RemoveAll();

	arrStr = value.split("^");
	document.form.ofc.value = arrStr[1];
	document.form.ofc_cd.value = arrStr[1];
}

function sent_stat_OnChange(comboObj, value, text) {
	var formObj = document.form;
	if (value == 'N') {
		with (formObj.retr_opt) {
			if (GetCount() == 4) {
				DeleteItem("E");
			}
		}
	} else {
		with (formObj.retr_opt) {
			if (GetCount() == 3) {
				InsertItem(3, "EDI Sent Date",			"E");
			}
		}
	}
}


/**
 * After popup
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function getFNS_INV_0086_1(rowArray, row, col) {    	 
	var colArray = rowArray[0];
	document.form.cust_cnt_cd.value = colArray[8];
	document.form.cust_seq.value = ComLpad(colArray[9], 6, "0");
	fn_cust_nm();
}

/**
 * Retrieve customer's name.
 */
function fn_cust_nm() {
	document.form.f_cmd.value = SEARCH03;
	var cust_nm = "";

	if (form.cust_cnt_cd.value.trim()!="" && form.cust_seq.value.trim()!="") {
		form.cust_seq.value = ComLpad(form.cust_seq.value.trim(), 6, "0");			
		var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
		if (cust_nm == undefined) {
			form.cust_nm.value = "";
			ComShowCodeMessage("INV00008");
			form.cust_seq.value="";
			form.cust_seq.focus();
			return;
		} else {
			form.cust_nm.value=cust_nm;
		}
	}
}
