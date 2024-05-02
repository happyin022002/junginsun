/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FNS_INV_0129.js
 * @FileTitle : 
 * Open Issues :
 * Change history :
 * @LastModifyDate : 
 * @LastModifier : 
 * @LastVersion : 1.0
 */

/**
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 *                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 *                 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 */

/**
 * Define script for creating screen.
 */
function FNS_INV_0129() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
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

var cust_cd_input = false;


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
		
			case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                break;
                 
             case "btn_Delete":
            	 if(!validateForm(sheetObjects[0],formObj,IBDELETE)) {
     				return false;
     			 }
            	ComRowHideDelete(sheetObjects[0], "DelChk");
            	break;

			 case "btn_actcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObj.cust_cnt_cd.value+'&cust_seq='+formObj.cust_seq.value+'&pop_yn=Y';
				var Row = 1;
				var Col = 1;
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break; 
        	
			case "btn_custNm":
				param = '?pgmNo=FNS_INV_0086&cust_seq='+formObj.cust_seq.value+'&cust_cnt_cd='+formObj.cust_cnt_cd.value;
				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
				break;
				
				
			case "btn_Retrieve" :
				if (cust_cd_input) {
					fn_cust_nm();
				}
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
				
			case "btn_Save" :
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
				
			case "btn_New" :
				removeAll(formObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
				break;
			case "btn_DownExcel" :
				sheetObj.Down2Excel(-1);
				break;
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
	
	initControl();

	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
	fn_cust_nm();

	// Initialize buttons.
	ComBtnDisable("btn_SendBL");
	ComBtnDisable("btn_DownExcel");

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
			style.height = 350;
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

			var HeadTitle = "|Sel.|Customer code|Customer code|customer name|Status|Remark|Update By";
			var headCount = ComCountHeadTitle(HeadTitle);

			// Set column information(Request:COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false).
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, true, true, false,false)

			// Set header row information(Request:ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false).
			InitHeadRow(0, HeadTitle, true);

			var rowCnt = 0;

			// Data attribute(ROW,      COL,    DATATYPE,       WIDTH,  DATAALIGN,      COLMERGE,    SAVENAME,          KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX).
			InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	0,		daCenter,		false,		 "ibflag");
			InitDataProperty(0, 		cnt++, 	dtDummyCheck, 		40,		daCenter, 		false,		"DelChk");				
			InitDataProperty(rowCnt,	cnt++,	dtData,			40,			daRight,	false,		 "cust_cnt_cd",		false,		"",			dfNone,	0,			false,		true,2,true);
			InitDataProperty(rowCnt,	cnt++,	dtData,			60,			daCenter,	false,		 "cust_seq",			false,		"",			dfNone,	0,			false,		true,6,true);
			InitDataProperty(rowCnt,	cnt++,	dtData,			400,		daLeft,		false,		 "cust_nm",			false,		"",			dfNone,	0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtCombo,			90,			daLeft,		false,		 "inv_eml_split_flg",	false,		"",			dfNone,	0,			false,		false);
			InitDataProperty(rowCnt,	cnt++,	dtData,			180,		daLeft,		false,		 "cust_rmk",			false,		"",			dfNone,	0,			true,		true);
			InitDataProperty(rowCnt,	cnt++,	dtData,			90,			daLeft,		false,		 "upd_usr_id",		false,		"",			dfNone,	0,			false,		false);
			InitDataCombo(0,'inv_eml_split_flg','Separate|Merge','Y|N');
			CountPosition = 2;
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

///**
// * On before activate.
// */
//function obj_activate() {
//	var formObj = document.form;
//
//	// Remove mask seperator.
//	ComClearSeparator (event.srcElement);
//	event.srcElement.select();
//}

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
		//ComOpenWait(true);
		
	
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");
		
		makeComboObject(formObj.ar_ofc_cd_all, arrStr);

		var arrStr2 = "";
		var ar_ofc_cd_all = "";

		for (var i=1; i<arrStr.length; i++) {
			arrStr2 = arrStr[i].split("^");
			if (arrStr2[1]==arrStr2[3]) {
				ar_ofc_cd_all = arrStr2[1];

				formObj.ofc.value = ar_ofc_cd_all;
				formObj.ofc_cd.value = formObj.ofc.value;	
			}
		}
		formObj.ar_ofc_cd_all.text = ar_ofc_cd_all;	
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
		
//		sXml = sheetObj.GetSearchXml("FNS_INV_0129GS.do", FormQueryString(formObj));
//		var ofc_opt = ComGetEtcData(sXml,"ofc_opt");
//		formObj.ofc_opt.value = ofc_opt;
		
		//ComOpenWait(false);
		break;
		
	case IBSEARCH : // Retrieve.
		if (validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			formObj.ar_ofc_cd.value = formObj.ofc.value;	
			
			var sXml = sheetObj.GetSearchXml("FNS_INV_0129GS.do", FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");

			if (sXml.indexOf("ERROR") < 1) {
				if (arrXml[0] != null) {
					sheetObj.LoadSearchXml(arrXml[0]);
					if (sheetObjects[0].RowCount==0) {
						ComShowCodeMessage("COM130401");
					}
				}
			}
			
			cust_cd_input =false;
		}

		break;
		
	case IBSAVE : // save.
		
		if (validateForm(sheetObj,formObj,sAction)) {
		
			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
			var sParam1 = sheetObjects[0].GetSaveString(true); 				  
	
			if (sParam1 == "") {				
				return; 
			} else {
				sParam1 = ComSetPrifix(sParam1, "sheet1_");
				sParam = sParam + "&" + sParam1;
			}
			
			
			var sXml = sheetObj.GetSearchXml("FNS_INV_0129GS.do", sParam);
		
			var arrXml = sXml.split("|$$|");
	
			if (sXml.indexOf("ERROR") < 1) {
					
				// 성공했으므로 reload한다.
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else {
				ComShowCodeMessage("INV00053");
			}
		}
		
		break;
		
	case IBINSERT : // insert.
	
		if (formObj.ofc_opt.value=="Sepatate") {
			sheetObj.InitDataCombo(0,'inv_eml_split_flg','Merge|Sepatate','N|Y');
		} else {
			sheetObj.InitDataCombo(0,'inv_eml_split_flg','Separate|Merge','Y|N');
		}
		var sheetIdx = sheetObj.DataInsert(-1);

	break;
	
	case IBSEARCH_ASYNC02 : // Search Customs's type
	
		formObj.f_cmd.value = SEARCH02;		
		sXml = sheetObj.GetSearchXml("FNS_INV_0129GS.do", FormQueryString(formObj));
		var ofc_opt = ComGetEtcData(sXml,"ofc_opt");
		formObj.ofc_opt.value = ofc_opt;
	
	break;
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

	case IBSAVE : // C,U,D.
		with (formObj) {
				
			//1. Data의 변화가 있는지 체크한다.
			var chkCnt = 0;
			var idx = sheetObj.RowCount;
			var isChanged = false;

			if (!(idx > 0)) {
				ComShowCodeMessage("INV00091");
				return false;
			}
				
			for (var i=1; i<idx+1; i++) {
				if (sheetObj.CellValue(i,"ibflag") =='I' || sheetObj.CellValue(i,"ibflag") == 'U' || sheetObj.CellValue(i,"ibflag") == 'D') {
					isChanged= true;
				}
			}
			
			if (!isChanged) {
				ComShowCodeMessage("INV00091");
				return false;
			}
			
			// 2, Cust Nm이 null인지 체크한다.
			for (var i=1; i<idx+1; i++) {
				if (sheetObj.CellValue(i,"cust_nm").trim() =='') {
					ComShowCodeMessage("INV00054");
					sheetObj.SelectCell(i, 'cust_seq');
					return false;
				}
			}
		}
		break;
		
	case IBDELETE:
		if (sheetObj.CheckedRows("DelChk") == 0) {
			ComShowMessage(msgs["INV00025"]);
			return false;
		} else if (sheetObj.CheckedRows("DelChk") > 0) {
			if(!ComShowCodeConfirm("INV00028")) return;
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
	
	formObj.cust_seq.value = "";
	formObj.cust_cnt_cd.value = "";
	formObj.cust_nm.value = "";
	
	sheetObjects[0].RemoveAll();

	// Initialize button
	ComBtnDisable("btn_DownExcel");
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

	case "cust_cnt_cd":
		
		sheetObj.cellValue2(row,'cust_cnt_cd') = value.toUpperCase();

		if (sheetObj.cellValue(row,'cust_seq') != "") {
			if(!fn_cust_nm_sheet(sheetObj, row, col)){
				sheetObj.SelectCell(row, 'cust_cnt_cd');
			}
		}
		break;
		
	case "cust_seq":
				
		if (sheetObj.cellValue(row,'cust_cnt_cd') != "") {
			if(!fn_cust_nm_sheet(sheetObj, row, col)){
				sheetObj.SelectCell(row, 'cust_seq');
			}
		}
		
		break;
	default :
		break;
	}
}
 
 /**
  * On blur in grid.
  * 
  * @param sheetObj
  * @param row
  * @param col
  * @param value
  */
 function sheet1_OnBlur(sheetObj, row, col, value) {
	 var formObj = document.form;
	 var colSaveName = sheetObj.ColSaveName(col);
	 
	 switch (colSaveName) {
	 
	 case "cust_cnt_cd":
		 
		 sheetObj.cellValue2(row,'cust_cnt_cd') = value.toUpperCase();
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
 * Making combo.
 * 
 * @param cmbObj
 * @param arrStr
 */
function makeComboObject(cmbObj, arrStr) {
	for (var i=1; i<arrStr.length; i++) {
		var arrStr2 = arrStr[i].split("^");
		var ar_ofc_cd_all = arrStr2[1];
		cmbObj.InsertItem(i-1, ar_ofc_cd_all, arrStr[i]);			 
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
  * Retrieve customer's name.
  */
 function fn_cust_nm_sheet(sheetObj,row,col) {
	 document.form.f_cmd.value = SEARCH03;
	 var cust_cnt_cd = sheetObj.CellValue(row,'cust_cnt_cd');
	 var cust_seq = sheetObj.CellValue(row,'cust_seq');
	 var cust_nm= "";
	 
	 if (cust_cnt_cd.trim()!="" && cust_seq.trim()!="") {
		 cust_seq = ComLpad(cust_seq.trim(), 6, "0");		
		 sheetObj.CellValue2(row,'cust_seq') = cust_seq;

		 // 중복 체크를한다.
		 var idx = sheetObj.RowCount;
		 for (var i =1;i<idx+1;i++) {
			 var custCntCdTmp = sheetObj.CellValue(i,'cust_cnt_cd');
			 var custSeqTmp = sheetObj.CellValue(i,'cust_seq');
			 if ( i != row && cust_cnt_cd == custCntCdTmp && cust_seq == custSeqTmp) {
				 sheetObj.CellValue2(row,'cust_nm') = "";
				 ComShowCodeMessage("INV00034");
				 return false;
			 }
		 }
		 
		 var queryParam = 	"f_cmd=103&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
		 var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", queryParam);
		 
		 cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
		 if (cust_nm == undefined) {
			 sheetObj.CellValue2(row,'cust_nm') = "";
			 ComShowCodeMessage("INV00008");
			 return false;
		 } else {
			 sheetObj.CellValue2(row,'cust_nm') = cust_nm;
			 return true;
		 }
	 }
 }
  
 function fn_keyUp(ev) {
	 cust_cd_input = true;
	 
	 if (ev.keyCode == 9 || ev.keyCode == 13) {
		fn_cust_nm(); 
	 }
 }

  
/**
 * On change in ar_ofc_cd_all.
 * 
 * @param comboObj
 * @param value
 * @param text
 */
function ar_ofc_cd_all_OnChange(comboObj, value, text){ 
	sheetObjects[0].RemoveAll();

	arrStr = value.split("^");
	document.form.ofc.value = arrStr[1];
	document.form.ofc_cd.value = arrStr[1];
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	
}