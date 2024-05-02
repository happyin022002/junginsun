/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1190.js
*@FileTitle : ESM_BKG_1190
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/29
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer's work*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
// global variable
var intervalId="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObj = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "mode_type":
			doActionIBSheet(sheetObjects[0], formObj, INIT);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
			break;
		case "btn_new":
			doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			break;
		case "btn_download":
			doActionIBSheet(sheetObjects[0], formObj, MULTI01);
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObj, MULTI03);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObjects[0], formObj, MULTI02);
			break;
		case "btn_viewmsg":
			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObjects[0], formObj, MULTI05);
			break;  
		} // end switchdesc bkg_cstms_ars_bl;
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], formObj, INIT);
}

function initControl(){
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form'); 
}


/**
 * handling buttons on loading
 */
function SetButtonStatus(){
		// Customs Common Code 테이블의 NA Staff 인 경우에만 Data Delete 버튼 활성화
		if(sheetObjects[0].GetCellValue(1, "na_stf_flg")=="Y"){
			document.getElementById("btn_delete").style.display='';
		}else{
			document.getElementById("btn_delete").style.display='none';
		}		
    }

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	switch (sheetNo) {
	case 1:
		with (sheetObj) {

			var HeadTitle1 = "|Seq.|Sel.|Download|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|In Transit|SEND DATE|SENDER";
			var headCount = ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:7, Page:100} );
			
			var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			 
			InitHeaders(headers, info);

			var cols = [
			     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"row_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"down_yn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, Wrap:1 ,EditLen:1,  AcceptKeys:"E", InputCaseSensitive:1},
				 {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lloyd_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"call_sgn_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eta_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mode_type",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"na_stf_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 }];
			  
			 InitColumns(cols);

			 SetEditable(1);
			 SetCountPosition(0);
			 SetSelectionMode(smSelectionRow);
             SetSheetHeight(400);
             ComResizeSheet(sheetObjects[0]);
		}
	}
}

/**
 * handling of Sheet <br>
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
    	case INIT:
			if (formObj.mode_type[0].checked) {
				formObj.pol_cd.className = "input1";
				formObj.pod_cd.className = "input";
				formObj.pol_cd.value = 'ARBUE';
				formObj.pol_cd.readOnly = true;
				formObj.pod_cd.value = "";
				formObj.pod_cd.readOnly = false;
				
			} else if (form.mode_type[1].checked) {
				formObj.pol_cd.className = "input";
				formObj.pod_cd.className = "input1";
				formObj.pod_cd.value = 'ARBUE';
				formObj.pod_cd.readOnly = true;
				formObj.pol_cd.value = "";
				formObj.pol_cd.readOnly = false;
			}
			
			ComSetFocus(formObj.vvd_cd);
    		break;
		case IBCLEAR: // New
			sheetObjects[0].RemoveAll();
			formObj.reset();
			formObj.vvd_cd.focus();
			formObj.mode_type[1].checked;
			doActionIBSheet(sheetObjects[0], formObj, INIT);
			break;
		case SEARCH01: // Retrieve
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value=SEARCH01;
			ComOpenWait(true);
            var sXml=sheetObj.GetSearchData("ESM_BKG_1190GS.do", FormQueryString(formObj));
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            ComOpenWait(false);
			break;
		case MULTI01: // Data Download
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			var sParam = ComGetSaveString(sheetObj) + "&f_cmd=" + MULTI01;
			var sXml = sheetObj.GetSaveData("ESM_BKG_1190GS.do", sParam);
			sheetObj.LoadSaveData(sXml, {Sync : 1});
            ComOpenWait(false);
			break;
		case MULTI03: // Data Save
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI03;
			var sParam =ComGetSaveString(sheetObj)+"&f_cmd=" + MULTI03;
			var sXml = sheetObj.GetSaveData("ESM_BKG_1190GS.do", sParam);
			sheetObj.LoadSaveData(sXml, {Sync : 1});
            ComOpenWait(false);
			break;
		case MULTI02: // Transmit
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI02;
			for ( var i = 1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "sel") == "1") {
					sheetObj.SetCellValue(i, "ibflag", "U");
				}
			}
			var sParam = ComGetSaveString(sheetObj) + "&f_cmd=" + MULTI02;
			var sXml = sheetObj.GetSaveData("ESM_BKG_1190GS.do", sParam);
			sheetObj.LoadSaveData(sXml, {Sync : 1});
            ComOpenWait(false);
			break;
		case SEARCH02: // View Send File
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var sUrl="ESM_BKG_1191.do?pgmNo=ESM_BKG_1191&bl_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_no") 
			          + "&io_bnd_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "mode_type")
			          + "&snd_dt=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "snd_dt");
			ComOpenWindowCenter(sUrl, "ESM_BKG_1191", 600, 600, false);
			break;
		case MULTI05: // 데이터 삭제
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value=MULTI05;
			var sParam = ComGetSaveString(sheetObj) + "&f_cmd=" + MULTI05;
			var sXml = sheetObj.GetSaveData("ESM_BKG_1190GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			doActionIBSheet(sheetObj,form,SEARCH01); // 데이터 삭제 후 재조회함
			break;
    }
}

function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case SEARCH01:// Retrieve
			// 기본포멧체크
			if (!ComChkValid(formObj))
				return false;
	
			if (ComIsNull(formObj.bl_no)) {
				if (ComIsNull(formObj.vvd_cd)) {
					ComShowCodeMessage('BKG00626', 'VVD');
					formObj.vvd_cd.focus();
					return false;
				} else if (formObj.mode_type[0].checked && ComIsNull(formObj.pol_cd)) {
					ComShowCodeMessage('BKG00626', 'POL');
					formObj.pol_cd.focus();
					return false;
				} else if (formObj.mode_type[1].checked && ComIsNull(formObj.pod_cd)) {
					ComShowCodeMessage('BKG00626', 'POD');
					formObj.pod_cd.focus();
					return false;
				}
			}
			break;
		case MULTI01:// Download
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage('BKG00333'); // Nothing To Select
				return false;
			}
			var downCnt = 0;
			for ( var i = 1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "sel") == "1" && sheetObj.GetCellValue(i, "down_yn") == "N") {
					downCnt++;
				}
			}
			if (downCnt == 0) {
				ComShowCodeMessage('BKG95017', 'download'); // "There is no data to {?msg1}. Please check again."
				return false;
			}
			if (!ComShowCodeConfirm("BKG01087")) // Do you want to download selected B/L?
                return false;
			break;
		
		case MULTI03:// Save
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage('BKG00333'); // Nothing To Select
				return false;
			}
			var downCnt = 0;
			for ( var i = 1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "sel") == "1" && sheetObj.GetCellValue(i, "down_yn") == "Y") {
					downCnt++;
				}
			}
			if (downCnt != sheetObj.CheckedRows("sel")) {
				ComShowCodeMessage('COM12114', 'download column. Some data is not downloaded.'); // 'Please check {?msg1}'
				return false;
			}
			if (!ComShowCodeConfirm("BKG01087")) // Do you want to download selected B/L?
                return false;
			break;
			
		case MULTI02:// Transmit
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage('BKG00333'); // "Nothing To Select"
				return false;
			}
			if (formObj.f_cmd.value != MULTI01) {
				var downCnt = 0;
				for ( var i = 1; i <= sheetObj.RowCount(); i++) {
					if (sheetObj.GetCellValue(i, "sel") == "1" && sheetObj.GetCellValue(i, "down_yn") == "Y") {
						downCnt++;
					}
				}
				if (downCnt == 0) {
					ComShowCodeMessage('BKG95017', 'transmit');
					return false;
				}
			}
			if (!ComShowCodeConfirm("BKG00447")) {
				if (formObj.f_cmd.value == MULTI01) {
					doActionIBSheet(sheetObj, document.form, SEARCH01);
				}
                return false;
			}
			break;

		case SEARCH02:// Send Log
			if (sheetObj.RowCount() == 0) {
				ComShowCodeMessage('BKG00395');
				return false;
			}
			break;
		case MULTI05: // Data Delete
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage('BKG00333'); // "Nothing To Select"
				return false;
			}
			if(!ComShowCodeConfirm("BKG01188")) return; // Do you want to delete all saved data?
			break;
	} // end case.
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	if (sheetObj.RowCount() == 0)
	{
		formObj.vsl_eng_nm.value  = "";
		formObj.lloyd_no.value    = "";
		formObj.call_sgn_no.value = "";
		formObj.eta_dt.value      = "";
		formObj.etd_dt.value      = "";
	}
	else
	{
		formObj.vsl_eng_nm.value  = sheetObj.GetCellValue(1, "vsl_eng_nm");
		formObj.lloyd_no.value    = sheetObj.GetCellValue(1, "lloyd_no");
		formObj.call_sgn_no.value = sheetObj.GetCellValue(1, "call_sgn_no");
		formObj.eta_dt.value      = sheetObj.GetCellValue(1, "eta_dt");
		formObj.etd_dt.value      = sheetObj.GetCellValue(1, "etd_dt");
		sheetObj.SetColFontUnderline("bl_no", 1);
	}
	SetButtonStatus();
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var state = sheetObj.GetEtcData("TRANS_RESULT_KEY");

	if (state == "S") {
		if (formObj.f_cmd.value == MULTI01) {
			doActionIBSheet(sheetObjects[0], formObj, MULTI02);
		} else if (formObj.f_cmd.value == MULTI02||formObj.f_cmd.value == MULTI03) {
			doActionIBSheet(sheetObj, document.form, SEARCH01);
		}
	} else {
		doActionIBSheet(sheetObj, document.form, SEARCH01);
	}
}

/**
 * B/L Inquiry
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var colSaveName = sheetObj.ColSaveName(col);
	switch (colSaveName) {
	case "bl_no":
		ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
		break;
	}
}