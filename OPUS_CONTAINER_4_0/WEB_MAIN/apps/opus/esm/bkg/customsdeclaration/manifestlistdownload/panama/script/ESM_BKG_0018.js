/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1008.js
*@FileTitle  : ESM_BKG_0018
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/23
=========================================================*/
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
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** ***  Tab ->two or more sheet : sheet  a variable assignment **** */
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_new":
			formObject.reset();
			sheetObject1.RemoveAll();
			formObject.vps_eta_start_dt.focus();
			ComBtnDisable('btn_transmit');
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
		case "btns_calendar": 
			var cal=new ComCalendarFromTo();
			cal.select(formObject.vps_eta_start_dt, formObject.vps_eta_end_dt, 'yyyy-MM-dd');
			break;
		case "btn_transmit": // GO TO TRANSMIT
			doActionIBSheet(sheetObjects[0], formObject, SEARCHLIST01);
			break;
		case "btn_history":
			doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
			break;
		case "btn_viewRcvFile":
			doActionIBSheet(sheetObjects[0], formObject, SEARCH02);
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
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObject=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.vps_eta_start_dt.focus();

	ComBtnDisable('btn_transmit');
	ComBtnDisable('btn_history');
	ComBtnDisable('btn_viewRcvFile');

	doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
}
/**
 * HTML Control on the page  loaded dynamically  the event. <br>
 * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects array  sequence number
 */
function initControl() {
	// ** Date Delimiter **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm  ('blur', 'obj_deactivate', formObject); //- focus in
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); //- focus out
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');  
	
	//axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); 
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}
/**
 * HTML Control onkeypress event Keyboard input and control.
 */
function obj_keypress() {
	var srcName=ComGetEvent("name");
	var srcValue=ComGetEvent("value");
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// enter only uppercase letters in English. English  uppercase+ numbers  -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// enter only uppercase letters in English. English  uppercase+ numbers  -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "ymd":
		// alert(srcValue.length);
		ComKeyOnlyNumber(event.srcElement);
		if (srcValue.length == 4) {
			document.form.elements[srcName].value=srcValue.substring(0, 4)
					+ "-"
		}
		if (srcValue.length == 7) {
			document.form.elements[srcName].value=srcValue.substring(0, 7)
					+ "-"
		}
		break;
	default:
		// only numbers Input(integer, date, time)
		ComKeyOnlyNumber(ComGetEvent());
	}
}
/**
 * handling  search condition  Input 
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * Validation of HTML Control onblur Event <br>
 */
function obj_activate() {
	// Input Validation to check
	switch (ComGetEvent("name")) {
	case "vps_eta_start_dt":
		ComClearSeparator(ComGetEvent());
		break;
	case "vps_eta_end_dt":
		ComClearSeparator(ComGetEvent());
		break;
	default:
		break;
	}
}
/**
 * Validation of HTML Control onblur Event <br>
 */
function obj_deactivate() {
	// Input Validation to check
	switch (ComGetEvent("name")) {
	case "vps_eta_start_dt":
		ComAddSeparator(ComGetEvent());
		break;
	case "vps_eta_end_dt":
		ComAddSeparator(ComGetEvent());
		break;
	default:
		break;
	}
}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
      with(sheetObj){
      if (location.hostname != "")
      var HeadTitle1="|VSLCD|VVD|Lane|ETA|Prior Port|Next Port|SHIP ID No.|Visit No.|MVMT Seq.|VSL Operater|Origin|Destination|Transmission Status|Transmission Status|Transmission Status|Acknowledge Status|Acknowledge Status|Acknowledge Status";
      var HeadTitle2="|VSLCD|VVD|Lane|ETA|Prior Port|Next Port|SHIP ID No.|Visit No.|MVMT Seq.|VSL Operater|Origin|Destination|Time|Seq.|User ID|Time|Seq.|Status";

      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [  {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd_temp" },
                    {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"shp_id_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 ,  AcceptKeys:"N" , InputCaseSensitive:1 },
                    {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vst_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 ,  AcceptKeys:"N" , InputCaseSensitive:1 },
                    {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"mvmt_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 ,  AcceptKeys:"N" , InputCaseSensitive:1 },
                    {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"pnm_vsl_opr_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"pnm_org_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"pnm_dest_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"edi_snd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rcv_log_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_ack_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                ];
               
      InitColumns(cols);
  
      SetEditable(1);
//      SetColProperty(0,
//                     "pnm_vsl_opr_cd", 
//                     {ComboText:" \t |NYK\tNYK|YANGMI\tYANG MING|COSCOC\tCOSCO|KKLINE\tK LINE AMERICA",
//                      ComboCode:"  |NYK|YANGMI|COSCOC|KKLINE", ShowCol: 1} );
      SetColProperty(0,
                     "pnm_org_cd", 
                     {ComboText:" \t |00\t[00] UNKNOWN|A0\t[A0] AROUND THE WORLD|A1\t[A1] EAST COAST OF THE UNITED STATES|A2\t[A2] EAST COAST OF CANADA|A3\t[A3] CRISTOBAL, REPUBLIC OF PANAMA|A5\t[A5] CRISTOBAL, REPUBLIC OF PANAMA|A6\t[A6] WEST INDIES|A7\t[A7] EUROPE|A8\t[A8] AFRICA|A9\t[A9] ASIA AND THE MIDDLE EAST|P0\t[P0] AROUTE THE WORLD|P1\t[P1] WEST COAST OF THE UNITED STATES|P2\t[P2] WEST COAST OF CANADA|P3\t[P3] WEST COAST OF CENTRAL AMERICA|P4\t[P4] WEST COAST OF SOUTH AMERICA|P5\t[P5] CRISTOBAL, REPUBLIC OF PANAMA|P6\t[P6] HAWALL|P7\t[P7] OCEANIA|P8\t[P8] ANTARTICA|P9\t[P9] ASIA",
                      ComboCode:"  |00|A0|A1|A2|A3|A5|A6|A7|A8|A9|P0|P1|P2|P3|P4|P5|P6|P7|P8|P9", ShowCol: 1} );
      SetColProperty(0,
                     "pnm_dest_cd",
                     {ComboText:" \t |00\t[00] UNKNOWN|A0\t[A0] AROUND THE WORLD|A1\t[A1] EAST COAST OF THE UNITED STATES|A2\t[A2] EAST COAST OF CANADA|A3\t[A3] CRISTOBAL, REPUBLIC OF PANAMA|A5\t[A5] CRISTOBAL, REPUBLIC OF PANAMA|A6\t[A6] WEST INDIES|A7\t[A7] EUROPE|A8\t[A8] AFRICA|A9\t[A9] ASIA AND THE MIDDLE EAST|P0\t[P0] AROUTE THE WORLD|P1\t[P1] WEST COAST OF THE UNITED STATES|P2\t[P2] WEST COAST OF CANADA|P3\t[P3] WEST COAST OF CENTRAL AMERICA|P4\t[P4] WEST COAST OF SOUTH AMERICA|P5\t[P5] CRISTOBAL, REPUBLIC OF PANAMA|P6\t[P6] HAWALL|P7\t[P7] OCEANIA|P8\t[P8] ANTARTICA|P9\t[P9] ASIA",
                      ComboCode:"  |00|A0|A1|A2|A3|A5|A6|A7|A8|A9|P0|P1|P2|P3|P4|P5|P6|P7|P8|P9", ShowCol: 1}  );
//      SetSheetHeight(340);
      
      ComResizeSheet(sheetObj);
      }
  
		break;

	}
}

/**
 * Sheet handling process
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // 
		if (sheetObj.id == "sheet1") {
			
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.vsl_cd.value=formObj.vvdCd.value.substring(0, 4);
				formObj.skd_voy_no.value=formObj.vvdCd.value.substring(4, 8);
				formObj.skd_dir_cd.value=formObj.vvdCd.value.substring(8);
				// removeSeparator
				sheetObj.DoSearch("ESM_BKG_0018GS.do", FormQueryString(formObj) );
			}
			
			formObj.vps_eta_start_dt.focus();
		}
		break;
	case IBSAVE: //
		if (sheetObjects[0].IsDataModified()) {
			formObj.f_cmd.value=MULTI;
//			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			
			var result=sheetObj.DoSave("ESM_BKG_0018GS.do",FormQueryString(formObj));
//			if (result == true) {
//				state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
//				if (state == "S")
//					doActionIBSheet(sheetObj, document.form, IBSEARCH);
//				else
//					ComShowCodeMessage('BKG00167');
//			}
			ComOpenWait(false);
		} else {
			ComShowCodeMessage("BKG00743");
			return false;
		}
		break;
	case SEARCHLIST01:
		var sUrl="/opuscntr/ESM_BKG_0017_POP.do?pgmNo=ESM_BKG_0017&vvdCd="+ sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vvd_cd");
		ComOpenWindowCenter(sUrl, "ESM_BKG_0017_POP", 1050, 700, false);
		break;
	case SEARCH01: //history
		var sUrl="/opuscntr/ESM_BKG_1193.do?pgmNo=ESM_BKG_1193"
			+ "&vstNo=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vst_no")
			+ "&vvdCd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vvd_cd");
		ComOpenWindowCenter(sUrl, "ESM_BKG_1193", 800, 500, false);
		break;
	case SEARCH02:
		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_log_seq") != "")
		{
			var sUrl="/opuscntr/ESM_BKG_1194.do?type=Receive&pgmNo=ESM_BKG_1194&rcv_log_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_log_seq")
			+ "&vst_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vst_no")
			+ "&vvd_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vvd_cd");
			ComOpenWindowCenter(sUrl, "ESM_BKG_1194", 600, 600, false);
		}
		else
		{
			ComShowCodeMessage('BKG95010');
		}
		break;
	case SEARCH03:
		formObj.f_cmd.value=INIT;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0018GS.do", FormQueryString(formObj));
		var arrCombo=ComXml2ComboString(sXml, "attr_ctnt2", "attr_ctnt1");
		sheetObj.SetColProperty("pnm_vsl_opr_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
		break;
	}
}

/**
 * function sheet1_OnSearchEnd for ComOpenWait(false)
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
    with(sheetObj) {
        for (var i = HeaderRows(); i <= LastRow(); i++)
    	{
        	if (GetCellValue(i, "cstms_ack_cd") == "Reject") {
            	SetCellFontColor(i, "rcv_dt", "#FF0000");
            	SetCellFontColor(i, "rcv_log_seq", "#FF0000");
            	SetCellFontColor(i, "cstms_ack_cd", "#FF0000");
        	}
    	}
        if (RowCount() > 0)
        {
        	ComBtnEnable('btn_transmit');
        	ComBtnEnable('btn_history');
        	ComBtnEnable('btn_viewRcvFile');
        }
    }
}

/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!ComChkValid(formObj)) {
			formObj.vps_eta_start_dt.focus();
			return false;
		}
		if (formObj.vvdCd.value == ""
				&& (formObj.vps_eta_start_dt.value == "" || formObj.vps_eta_end_dt.value == "")) {
			ComShowCodeMessage('BKG00111');
			formObj.vps_eta_start_dt.focus();
			return false;
		}
		if (formObj.vvdCd.value != "" && formObj.vvdCd.value.length != 9) {
			ComShowCodeMessage('BKG00111');
			formObj.vps_eta_start_dt.focus();
			formObj.vvdCd.value="";
			return false;
		}
		break;
	}
	return true;
}
/**
 * Sheet input value validation process
 * @param sheetObj Sheet
 * @param Row Row
 * @param Col Col
 * @param Value Value
 */
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
	// alert(Col+":"+Value);
	switch (Col) {
	case 8:
		if (Value == "") {
			ComShowCodeMessage('BKG00116');
			sheetObj.ValidateFail(true);
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		if (Value.length != 6) {
			ComShowCodeMessage('BKG00995');
			sheetObj.ValidateFail(true);
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		break;
	case 9:
	case 10:
		if (Value == "") {
			ComShowCodeMessage('BKG00117');
			sheetObj.ValidateFail(true);
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		break;
	}
}


function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	} else {
		ComShowCodeMessage('BKG00167');
	}
	
	ComOpenWait(false);
}
