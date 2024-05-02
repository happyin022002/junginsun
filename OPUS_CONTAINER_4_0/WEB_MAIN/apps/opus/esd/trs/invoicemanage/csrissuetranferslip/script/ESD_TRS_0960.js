/**
 * ========================================================= <br>
 * Copyright(c) 2014 CyberLogitec. All Rights Reserved. <br>
 * @FileName : ESD_TRS_0960.jsp <br>
 * @FileTitle : Terminal invoice CSR Creation - Detail <br>
 * @author : CLT <br>
 * @version : 1.0 <br>
 * @since : 2014/07/08  <br>
 * ========================================================= 
 */

var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
/**
 * 
 * @returns {Boolean}
 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var formObject = document.form;
	var checkflag = false;
	var confirmflag = false;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btng_detailinquiry": {
				var chkRowCount = sheetObject.CheckedRows("chk");
				if (chkRowCount != "1") {
					ComShowCodeMessage("TRS90141");
					return false;
				}
				var chkRow = sheetObject.FindCheckedRow("chk");
				chkRow = chkRow.substring(0, chkRow.length);
				var flag = sheetObject.GetCellValue(chkRow, "flag");
				var inv_tp_cd = sheetObject.GetCellValue(chkRow, "inv_tp_cd");
				document.AuditForm.inv_no.value = sheetObject.GetCellValue(chkRow, "inv_no");
				document.AuditForm.inv_vndr_seq.value = sheetObject.GetCellValue(chkRow, "inv_vndr_seq");
				document.AuditForm.inv_vndr_nm.value = sheetObject.GetCellValue(chkRow, 'inv_vndr_nm');
				document.AuditForm.editflag.value = "N";
				document.AuditForm.mode.value = "search";
				document.AuditForm.mode_tab.value = "C"; // A(Auditing tab)-Default Value, C(Confirm tab)
				document.AuditForm.pgmNo.value = "ESD_TRS_0038";
				if (flag == "R") {
					window.open('', 'OpenAudit', "scroll:no,status:no,help:no,width=1010,Height=550");
					document.AuditForm.action = 'ESD_TRS_0038_POP.do?parentPgmNo=ESD_TRS_M001&mainPage=false';
				} else {
					var pgmNo = "";
					var wdth = "1010";
					if (inv_tp_cd == 'C') {
						pgmNo = "ESD_TRS_0033";
						wdth = "1100";
					} else if (inv_tp_cd == 'R') {
						pgmNo = "ESD_TRS_0040";
					} else {
						pgmNo = "ESD_TRS_0041";
					}
					document.AuditForm.pgmNo.value = pgmNo;
					window.open('', 'OpenAudit', "scroll:no,status:no,help:no,width=" + wdth + ",Height=600");
					document.AuditForm.action = pgmNo + '_POP.do?parentPgmNo=ESD_TRS_M001&mainPage=false';
				}
				document.AuditForm.target = "OpenAudit";
				document.AuditForm.submit();
				break;
			}
			case "btn_close": {
				ComClosePopup();
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComEnableObject(formObj.csr_no, false);
	ComEnableObject(formObj.vndr_no, false);
	ComEnableObject(formObj.vndr_nm, false);
	ComEnableObject(formObj.inv_cnt, false);
	ComEnableObject(formObj.csr_curr_cd, false);
	ComEnableObject(formObj.csr_amt, false);
	ComEnableObject(formObj.asa_no, false);
	ComEnableObject(formObj.cost_ofc, false);
	ComEnableObject(formObj.max_iss_dt, false);
	ComEnableObject(formObj.max_rcv_dt, false);
	ComEnableObject(formObj.vndr_term_nm, false);
	ComEnableObject(formObj.payment_due_dt, false);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1: {
            with(sheetObj){
                var HeadTitle="Seq.||Invoice No.|Net Amount|V.A.T. Amount|W.H.T Amount|Total Amount|INV ISS Date|INV RCV Date|INV CFM Date" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
     
                var cols = [
                          {Type:"Seq",       Hidden:0,    Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"CheckBox",  Hidden:0,    Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,    Width:85,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Float",     Hidden:0,    Width:85,   Align:"Right",   ColMerge:0,   SaveName:"inv_bzc_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Float",     Hidden:0,    Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_vat_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Float",     Hidden:0,    Width:85,   Align:"Right",   ColMerge:0,   SaveName:"inv_whld_tax_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Float",     Hidden:0,    Width:85,   Align:"Right",   ColMerge:0,   SaveName:"inv_ttl_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Date",      Hidden:0,    Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Date",      Hidden:0,    Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_rcv_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Date",      Hidden:0,    Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1,    Width:1,    Align:"Right",   ColMerge:0,   SaveName:"inv_vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1,    Width:1,    Align:"Right",   ColMerge:0,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Status",    Hidden:1,    Width:1,    Align:"Right",   ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1,    Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1,    Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_vndr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                ComResizeSheet(sheetObj);
              }
            break;
        }
    }
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchData("ESD_TRS_0960GS.do", TrsFrmQryString(formObj), { Sync : 2 });
			if (sXml != "") {
				sheetObj.LoadSearchData(sXml, { Sync : 1 });
			}
			break;
		}
	}
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "" && ErrMsg != 0 && ErrMsg != -1) {
		return;
	}
	ComEtcDataToForm(document.form, sheetObj);
	sheetObj.RemoveEtcData();
	ComChkObjValid(document.form.max_iss_dt);
	ComChkObjValid(document.form.max_rcv_dt);
	if (!ComIsNumber(document.form.vndr_term_nm)) {
		document.form.vndr_term_nm.value = "KR H/O Payment_60";
	}
}
