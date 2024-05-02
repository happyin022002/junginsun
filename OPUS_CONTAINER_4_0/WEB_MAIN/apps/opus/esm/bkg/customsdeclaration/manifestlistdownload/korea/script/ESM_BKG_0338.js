/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0338.js
*@FileTitle : MSN & Bonded Inform Designate-Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
//Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	/* */
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
		case "btn_listprint":
			var exceptLines="";
			var chkCnt=0;
			for(var i=1; i <= sheetObject1.RowCount(); i++) {
				if (sheetObject1.GetCellValue(i, "Sel")==0)
					exceptLines=exceptLines + "|" + i;
				else
					chkCnt++;
			}
			if (chkCnt > 0) {
				sheetObject1.RenderSheet(0);
				sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
				sheetObject1.RenderSheet(1);
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_confirm":
			// Confirm
			for(var i=1; i <= sheetObject1.RowCount(); i++) {
				if (sheetObject1.GetCellValue(i, "mf_cfm_flg")=="Y") continue;
				sheetObject1.SetCellValue(i, "mf_cfm_flg","Y");
				sheetObject1.SetCellFontColor(i, "mf_cfm_flg","#FF0000");
			}
			break;
		case "btn1_Close":
			ComClosePopup();
			break;
		case "btn_msn":
			if (formObject.msn2.value.length > 0) formObject.msn2.value=ComLpad(formObject.msn2.value, 4, "0");
			if (formObject.msn1.value=="0000") formObject.msn1.value="0001";
			// Validation check
			if (formObject.msn2.value.length > 0 && formObject.msn2.value < formObject.msn1.value) {
				ComShowCodeMessage("BKG00689");
				formObject.msn2.focus();
			}else if (validateMsn()==false) {
				// Validation check 2
				ComShowCodeMessage("BKG95024");
				formObject.msn2.focus();
			}else {
				// MSN
				sheetObject1.SetWaitImageVisible(0);
				ComOpenWait(true);
				var nowMsn=formObject.msn1.value;
				var maxMsn=formObject.msn2.value;
				if (maxMsn.length < 1) maxMsn=9999;
				for(var i=1; i <= sheetObject1.RowCount(); i++) {
					if (sheetObject1.GetCellValue(i, "mf_seq_no").trim().length > 0) continue;
					if ( nowMsn > maxMsn ) break;
					sheetObject1.SetCellValue(i, "mf_seq_no",ComLpad(nowMsn, 4, "0"));
					sheetObject1.SetCellFontColor(i, "mf_seq_no","#FF0000");
					nowMsn++;
				}
				// Save automatically
				formObject.f_cmd.value=MULTI;
				sheetObject1.DoSave("ESM_BKG_0338GS.do", FormQueryString(formObject),-1,false);
				// From update
				formObject.msn1.value=ComLpad(nowMsn, 4, "0");
				formObject.msn2.value="";
				ComOpenWait(false);
			}
			checkBlankMsn(sheetObject1, formObject);
			break;
		case "btn_editBl":
			if (sheetObject1.RowCount()< 1) {
				ComShowCodeMessage('BKG00249');
			}else {
				var sUrl="ESM_BKG_0333_POP.do?bl_no="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "bl_no");
				sUrl=sUrl + "&pgmNo=ESM_BKG_0333";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0333", 1024, 600, false);
			}
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}


function msn1_onChange() {
	document.form.msn1.value=ComLpad(document.form.msn1.value,4,"0");
}


function msn2_onChange() {
	document.form.msn2.value=ComLpad(document.form.msn2.value,4,"0");
}


/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	sheet1_OnLoadFinish(sheet1);
}


/**
 * Event after the sheet Loading
 */
 function sheet1_OnLoadFinish(sheetObj) {
	var formObj=document.form;
	// ETA, ETD Setting
	formObj.eta.value=ComGetMaskedValue(formObj.eta.value, "ymd");
	formObj.etd.value=ComGetMaskedValue(formObj.etd.value, "ymd");
	formObj.msn2.className="input2";
	formObj.msn2.readOnly=true;
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
}


 function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	 var formObj=document.form;
	 if (sheetObj.LastRow()>=1)
		 {
		 formObj.msn1.value=ComLpad(sheetObj.GetEtcData('msn1'),4,"0");

		 }
		if (formObj.msn1.value=="0000") formObj.msn1.value="0001";
	}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":      //sheet1 init
		with(sheetObj) {

			//  (31, 11, 0, true);
			var HeadTitle="|Sel.|Seq.|Confirm|MSN|B/L No.|B/L Type|Entry Type|Bonded Area|Bonded W/H|Bonded Type|Consignee Name|Package|Package|Weight(KGS)|POL|POD|DEL|Bulk|Reefer|DG|AKW|BDR|C/A|STS|Bkg No.|BL Type|MSN NO|Next VVD|Relay POL|Relay POD";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  SaveName:"ibflag" },
						{Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  SaveName:"Sel" },
						{Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  SaveName:"Seq",                  Edit:0,   EditLen:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  SaveName:"mf_cfm_flg",           Edit:1,   EditLen:1 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  SaveName:"mf_seq_no",            Edit:1 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  SaveName:"bl_no",                Edit:0 },
						{Type:"Combo",     Hidden:0,  Width:65,   Align:"Center",  SaveName:"kr_cstms_bl_tp_cd",    Edit:1 },
						{Type:"PopupEdit", Hidden:0,  Width:70,   Align:"Center",  SaveName:"cstms_clr_tp_cd",      Edit:1 },
						{Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  SaveName:"cstms_dchg_loc_wh_cd", Edit:1 },
						{Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  SaveName:"cstms_clr_wh_cd",      Edit:1,   EditLen:10 },
						{Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  SaveName:"bd_tp_cd",             Edit:1 },
						{Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    SaveName:"cust_nm",              Edit:0 },
						{Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   SaveName:"pck_qty",              Format:"NullInteger", Edit:0 },
						{Type:"Text",      Hidden:0,  Width:25,   Align:"Right",   SaveName:"pck_tp_cd",            Edit:0 },
						{Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   SaveName:"act_wgt",              Format:"NullInteger", Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"pol_cd",               Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"pod_cd",               Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"del_cd",               Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"bb_cgo_flg",           Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"rc_flg",               Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"dcgo_flg",             Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"awk_cgo_flg",          Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"bdr_flg",              Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"bdr_cng_flg",          Edit:0 },
						{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  SaveName:"bkg_sts_cd",           Edit:0 },
						{Type:"Text",      Hidden:1,  Width:55,   Align:"Center",  SaveName:"bkg_no",               Edit:0 },
						{Type:"Text",      Hidden:1,  Width:55,   Align:"Center",  SaveName:"bl_tp_cd",             Edit:0 },
						{Type:"Text",      Hidden:1,  Width:55,   Align:"Center",  SaveName:"mf_ref_no",            Edit:0 } ];
						if (document.form.type.value == "Local") {
							cols.push({Type:"Text", Hidden:1, Width:80, Align:"Center", SaveName:"next_vvd"     });
							cols.push({Type:"Text", Hidden:1, Width:80, Align:"Center", SaveName:"relay_pol_cd" });
							cols.push({Type:"Text", Hidden:1, Width:80, Align:"Center", SaveName:"relay_pod_cd" });
						} else {
							cols.push({Type:"Text", Hidden:0, Width:80, Align:"Center", SaveName:"next_vvd",    });
							cols.push({Type:"Text", Hidden:0, Width:80, Align:"Center", SaveName:"relay_pol_cd" });
							cols.push({Type:"Text", Hidden:0, Width:80, Align:"Center", SaveName:"relay_pod_cd" });
						}

			InitColumns(cols);

			SetEditable(1);
			SetColProperty("kr_cstms_bl_tp_cd", {ComboText:"S\tSimple|C\tConsole|E\tEmpty", ComboCode:"S|C|E"} );
			var arrayKind=[ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' ];
			var arrayBondedType = [ '입항전 사전 수입신고', '차상반출', '부두 직통관', '부두 보운', '해상 간이 운송',
									'부두 경유 간이 보운', '보세운송', '의왕ICD', 'CY경유 간이 보운', '내장 통관',
									'CFS 경유 간이 보운', 'CFS', '자가 보세장치장', 'T/S', '내품  T/S',
									'자선', '타소 장치', 'Empty 컨테이너' ];
			var bd_tp_cd_text=" \t선택안함", bd_tp_cd_code=" ";
			for(var i=0; i < arrayKind.length; i++) {
				bd_tp_cd_text=bd_tp_cd_text + "|";
				bd_tp_cd_code=bd_tp_cd_code + "|";
				bd_tp_cd_text=bd_tp_cd_text + arrayKind[i]+"\t"+arrayBondedType[i];
				bd_tp_cd_code=bd_tp_cd_code + arrayKind[i];
			}
			SetColProperty("bd_tp_cd", {ComboText:bd_tp_cd_text, ComboCode:bd_tp_cd_code} );
			SetColProperty("mf_seq_no", {Format:"####"} );
			SetColProperty("mf_cfm_flg", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("mf_seq_no", {AcceptKeys : "N", InputCaseSensitive :1} );
			SetColProperty("kr_cstms_bl_tp_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("cstms_clr_tp_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("cstms_dchg_loc_wh_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("cstms_clr_wh_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("bd_tp_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );

			SetShowButtonImage(2);
			SetSheetHeight(400);
	}
	break;

	case "sheet2":      //sheet1 init
		with(sheetObj) {
			var HeadTitle="Sel";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];

			InitColumns(cols);

			SetEditable(1);
			SetVisible(false);
			}


		break;
	}
}


// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //retrieve
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			//sheetObj.RemoveAll();
			sheetObj.DoSearch("ESM_BKG_0338GS.do", FormQueryString(formObj),{Sync:2} );
			checkBlankMsn(sheetObj, formObj);
//			formObj.msn1.value=ComLpad(sheetObj.GetEtcData('msn1'),4,"0");
//			if (formObj.msn1.value=="0000") formObj.msn1.value="0001";
			ComOpenWait(false);
		}
		break;
	case IBSAVE:        //Save
		if(validateForm(sheetObj,formObj,sAction)) {
			if (ComShowCodeConfirm("BKG00350")) {
				formObj.f_cmd.value=MULTI;
				// Save
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSave("ESM_BKG_0338GS.do", FormQueryString(formObj) , -1, false);
				ComOpenWait(false);
			}
		}
		break;
	}
}


/**
 * blank MSN check
 */
function checkBlankMsn(sheetObj, formObj) {
	// Activating the MSN2 if the blank MSN exist
	var blankMsn=false;
	for(var i=1; i <= sheetObj.RowCount(); i++) {
if (sheetObj.GetCellValue(i, "mf_seq_no").trim().length < 1) {
			blankMsn=true;
			break;
		}
	}
	if (blankMsn) {
		formObj.msn2.className="input1";
		formObj.msn2.readOnly=false;
//		document.all.btn_msn.style.color='#FF0000';
		document.getElementById("btn_msn").setAttribute("style", "font-weight: bold;color:red!important");
		ComBtnEnable("btn_msn");
	}else {
		formObj.msn2.className="input2";
		formObj.msn2.readOnly=true;
		document.getElementById("btn_msn").setAttribute("style", "color:#C0C0C0");
//		document.all.btn_msn.style.color='#C0C0C0';
		ComBtnDisable("btn_msn");
	}
}


function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Col==4) checkBlankMsn(sheetObj, document.form);
	if (Col==8) {
		// Check the validation of Disch CY
		if (validateDischCY(Value)==false) {
			sheetObj.SetCellValue(Row, Col,"",0);
			ComShowCodeMessage("BKG95022", Value);
			sheetObj.SelectCell(Row, Col);
		}
	}
}


// Check the validation of Disch CY
function validateDischCY(cyVal) {
	var check=false;
	var formObj=document.form;
	form.f_cmd.value=SEARCH01;
	var params="&disch_cy="+cyVal;
	sheetObjects[1].DoSearch("ESM_BKG_0338GS.do", FormQueryString(formObj) + params, {Sync:2} );
	if (sheetObjects[1].GetEtcData("disc_valid")!="X") {
		check=false;
	} else {
		check=true;
	}
	return check;
}


// Check the validation of MSN
function validateMsn() {
	var check=false;
	var formObj=document.form;
	var params="&mf_seq_no="+ComLpad(formObj.msn1.value,4,"0");
	form.f_cmd.value=SEARCH02;
	sheetObjects[1].DoSearch("ESM_BKG_0338GS.do", FormQueryString(formObj)+params, {Sync:2} );
	if (sheetObjects[1].GetEtcData("msn_valid")!="X") {
		check=false;
	} else {
		check=true;
	}
	return check;
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction) {
	with(formObj) {
		switch(sAction) {
		case IBSAVE:
			// Check the Entry Type and blank Disch.CY
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "cstms_dchg_loc_wh_cd").trim().length < 1) {
					ComShowCodeMessage("BKG95023");
					sheetObj.SelectCell(i, "cstms_dchg_loc_wh_cd");
					return false;
				}
				if (sheetObj.GetCellValue(i, "cstms_clr_tp_cd").trim().length < 1) {
					ComShowCodeMessage("BKG95023");
					sheetObj.SelectCell(i, "cstms_clr_tp_cd");
					return false;
				}
			}
			break;
		}
	}
	return true;
}


/**
 * POP-UP of sheet1
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	with(sheetObj) {
		var sName=ColSaveName(Col);
		if(sName == "cstms_clr_tp_cd") {
			// Entry Type
			var sUrl="ESM_BKG_0335_POP.do?view_type=inquiry&entry_code="+sheetObj.GetCellValue(Row, Col);
			sUrl=sUrl + "&pgmNo=ESM_BKG_0335";
			//var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0335", 510, 400, true);
			ComOpenPopup(sUrl, 700, 500, "searchTpCd", "1,0", true);

			//if (rtnVal != null) sheetObj.SetCellValue(Row, Col,rtnVal);
		} else if(sName == "cstms_dchg_loc_wh_cd") {
			// Disch Type
			var sUrl="ESM_BKG_0334_POP.do?view_type=inquiry&otr_dchg_cd="+sheetObj.GetCellValue(Row, Col);
			sUrl=sUrl + "&pgmNo=ESM_BKG_0334";
			//var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0334", 700, 450, true);
			ComOpenPopup(sUrl, 800, 400, "searchLocWhCd", "1,0", true);

			//if (rtnVal != null) sheetObj.SetCellValue(Row, Col,rtnVal.cd);
		} else if (sName == "cstms_clr_wh_cd") {
			// Bonded WH Type
			var sUrl="ESM_BKG_0345_POP.do?cstms_cd=" + sheetObj.GetCellValue(Row, Col);
			//var rtnVal=ComOpenWindowCenter(sUrl, "searchClrWhCd", 1024, 570, true);
			ComOpenPopup(sUrl, 1024, 570, "searchClrWhCd", "0,0", true);
			//if (rtnVal != null) sheetObj.SetCellValue(Row, Col,rtnVal.cd);
		}
	}
}


function searchTpCd(rtnVal) {
	if (rtnVal != null) sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cstms_clr_tp_cd", rtnVal);

}


function searchLocWhCd(rtnVal) {
	if (rtnVal != null) sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cstms_dchg_loc_wh_cd", rtnVal.cd);

}


function searchClrWhCd(rtnVal) {
	if (rtnVal != null) sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cstms_clr_wh_cd", rtnVal.cd);

}
