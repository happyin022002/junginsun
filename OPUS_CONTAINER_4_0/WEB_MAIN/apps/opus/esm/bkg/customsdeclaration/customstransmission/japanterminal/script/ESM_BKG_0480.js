/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0480.js
*@FileTitle  :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
//Event handler processing by button click event
document.onclick=processButtonClick;
//Event handler processing by button name
function processButtonClick() {

	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "radio_cd":
				if(formObject.radio_cd[0].checked){
					ComEnableObject(formObject.in_bkg_no, true);
					ComEnableObject(formObject.in_vvd_cd, false);
					ComEnableObject(formObject.in_pol_cd, false);
					ComEnableObject(formObject.in_por_cd, false);
					ComEnableObject(formObject.in_bat_skd_prd_fm_dt, false);
					ComEnableObject(formObject.in_bat_skd_prd_to_dt, false);
					ComEnableObject(formObject.in_edi_snd_usr_id, false);
					ComEnableObject(document.all.from_to_calendar, false);
					formObject.in_vvd_cd.value="";
					formObject.in_pol_cd.value="";
					formObject.in_por_cd.value="";
					formObject.in_bat_skd_prd_fm_dt.value="";
					formObject.in_bat_skd_prd_to_dt.value="";
					formObject.in_edi_snd_usr_id.value="";
					document.all.from_to_calendar.value="";
					sheetObjects[0].RemoveAll();
					document.all.item("bkrbkc_save").style.display="inline";
					document.all.item("qty_save").style.display="none";
				}else if(formObject.radio_cd[1].checked){
					ComEnableObject(formObject.in_bkg_no, false);
					ComEnableObject(formObject.in_vvd_cd, true);
					ComEnableObject(formObject.in_pol_cd, true);
					ComEnableObject(formObject.in_por_cd, true);
					ComEnableObject(formObject.in_bat_skd_prd_fm_dt, true);
					ComEnableObject(formObject.in_bat_skd_prd_to_dt, true);
					ComEnableObject(formObject.in_edi_snd_usr_id, true);
					ComEnableObject(document.all.from_to_calendar, true);
					formObject.in_bkg_no.value="";
					sheetObjects[0].RemoveAll();
					document.all.item("bkrbkc_save").style.display="none";
					document.all.item("qty_save").style.display="inline";
				}
				break;

			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;

			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;

			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, MULTI01);
				break;

			case "btn_Trans":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;

			case "from_to_calendar": // From calendar
				if(formObject.radio_cd[1].checked){
					var cal=new ComCalendarFromTo();
					cal.select(formObject.in_bat_skd_prd_fm_dt, formObject.in_bat_skd_prd_to_dt, 'yyyy-MM-dd');
				}
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();

	ComEnableObject(document.all.from_to_calendar, false);
	document.form.in_bkg_no.focus();
}
/**
 * loading event of HTML Control<br>
 * initializing IBSheet Object <br>
 * @param sheetObj
 * @param sheetNo
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;

	axon_event.addListenerForm  ('blur', 'obj_deactivate', formObject); //- focus in
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); //- focus out

	axon_event.addListenerForm('blur', 'obj_blur', form);

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * onblur event Validation check of HTML Control. <br>
 */
function obj_deactivate(){
	switch(ComGetEvent("name")){
		case "in_bat_skd_prd_fm_dt":
			ComAddSeparator(ComGetEvent());
			break;
		case "in_bat_skd_prd_to_dt":
			ComAddSeparator(ComGetEvent());
			break;
		default:
			break;
	}
}
/**
 * onblur event Validation check of HTML Control. <br>
 */
function obj_activate() {
	switch(ComGetEvent("name")){
		case "in_bat_skd_prd_fm_dt":
			ComClearSeparator(ComGetEvent());
			break;
		case "in_bat_skd_prd_to_dt":
			ComClearSeparator(ComGetEvent());
		default:
			break;
	}
}
/**
 * onblur event Validation check of HTML Control.  <br>
 */
function obj_blur(){
	obj=ComGetEvent();
	var formObj=document.form;
	switch(ComGetEvent("name")) {
		case "in_bat_skd_prd_fm_dt":
			if( formObj.in_bat_skd_prd_fm_dt.value != ""){
				if(!ComChkObjValid(obj)){
					setObjValue("in_bat_skd_prd_fm_dt", "");
					setFocus("in_bat_skd_prd_fm_dt");
					return false;
				}
			}
			break;
		case "in_bat_skd_prd_to_dt":
			if( formObj.in_bat_skd_prd_to_dt.value != ""){
				if(!ComChkObjValid(obj)){
					setObjValue("in_bat_skd_prd_to_dt", "");
					setFocus("in_bat_skd_prd_to_dt");
					return false;
				}
			}
			break;
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with(sheetObj){
			var HeadTitle1="Flag|Seq.|Chk|BKR/BKC\n(R/Rv/D)|Send Date|Send Time|Office|User ID|VVD|Voyage No|POL|POL\nCY cd|POR|POR\nCY cd|Othr Ntfy|BKG No|CNTR 1|CNTR 1|CNTR2|CNTR2|CNTR3|CNTR3|CNTR4|CNTR4|CNTR5|CNTR5||||be_bkrbkc|cng_flg|bkg_skd_delt_flg";
			var HeadTitle2="Flag|Seq.|Chk|BKR/BKC\n(R/Rv/D)|Send Date|Send Time|Office|User ID|VVD|Voyage No|POL|POL\nCY cd|POR|POR\nCY cd|Othr Ntfy|BKG No|TP|Qty|TP|Qty|TP|Qty|TP|Qty|TP|Qty||||be_bkrbkc|cng_flg|bkg_skd_delt_flg";
			var headCount=ComCountHeadTitle(HeadTitle2);

			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						{Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                     Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Combo",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkrbkc",                      Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_dt",                  Format:"Ymd", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_tm",                  Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_ofc_cd",              Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_usr_id",              Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                      Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"jp_tml_vsl_no",               Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                      Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",                   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                      Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"por_yd_cd",                   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"otr_ntfy_yd_cd",              Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                      Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd1",               Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty1",               Format:"",    PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd2",               Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty2",               Format:"",    PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd3",               Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty3",               Format:"",    PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd4",               Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty4",               Format:"",    PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd5",               Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty5",               Format:"",    PointCount:2,   UpdateEdit:1,   InsertEdit:1 },

						{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                      Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",                  Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",                  Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"be_bkrbkc",                   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"snaccs_tml_edi_sts_cng_flg",  Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_skd_delt_flg",            Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			InitColumns(cols);

			SetEditable(1);
			SetCountPosition(0);

			SetColProperty("bkrbkc", {ComboText:"R|Rv|D", ComboCode:"R|V|D"} );
			SetColProperty("pol_yd_cd", {ComboText:"|" + jpTeminalCyCode, ComboCode:"|" + jpTeminalCyCode} );    // jpTeminalCy - JSP에서 정의
			SetColProperty("por_yd_cd", {ComboText:"|" + jpTeminalCyCode, ComboCode:"|" + jpTeminalCyCode} );    // jpTeminalCy - JSP에서 정의
			SetColProperty("otr_ntfy_yd_cd", {ComboText:"|" + jpTeminalCyCode, ComboCode:"|" + jpTeminalCyCode} );    // jpTeminalCy - JSP에서 정의

			SetSelectionMode(smSelectionCol);
			SetSheetHeight(410);
			SetRangeBackColor(1, 3, 1, 25,"#555555");

			InitComboNoMatchText(1, "", 1);
		}
		break;
	}
}
/**
* handling sheet process
* @param sheetObj Sheet
* @param formObj
* @param sAction
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {

		case IBSEARCH:      //Search
			if(validateForm(sheetObj,formObj,sAction)){
				if(formObj.radio_cd[0].checked){
					formObj.f_cmd.value=SEARCH;
				}else{
					formObj.f_cmd.value=SEARCH01;
				}
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0480GS.do", sParam);
				if(sXml.length>0){
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				ComOpenWait(false);
			}
			break;

		case MULTI01:   // Save
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value=MULTI01;
				var sParamSheet=sheetObj.GetSaveString(false, true, "del_chk");
				var sParam=FormQueryString(formObj)+ "&" + ComSetPrifix(sParamSheet, "");
				var sXml=sheetObj.GetSaveData("ESM_BKG_0480GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
			}
			break;

		case IBSAVE: //transmit
			if(validateForm(sheetObj,formObj,sAction)){
				if(formObj.radio_cd[0].checked){
					formObj.f_cmd.value=MULTI;
				}else{
					formObj.f_cmd.value=MULTI02;
				}
				var sParamSheet=sheetObj.GetSaveString(false, true, "del_chk");
				var sParam=FormQueryString(formObj)+ "&" + ComSetPrifix(sParamSheet, "");
				var sXml=sheetObj.GetSaveData("ESM_BKG_0480GS.do", sParam);
				var vChkFlg=ComGetEtcData(sXml, "chk_flg");
				if(vChkFlg == "ROUTE"){
					ComShowCodeMessage('BKG00651',"BKG ROUTE");
				}else{
					sheetObj.LoadSaveData(sXml);
				}
			}
			break;
		case IBCLEAR:
			formObj.reset();
			sheetObj.RemoveAll();
			ComEnableObject(formObj.in_bkg_no, true);
			ComEnableObject(formObj.in_vvd_cd, false);
			ComEnableObject(formObj.in_pol_cd, false);
			ComEnableObject(formObj.in_por_cd, false);
			ComEnableObject(formObj.in_bat_skd_prd_fm_dt, false);
			ComEnableObject(formObj.in_bat_skd_prd_to_dt, false);
			ComEnableObject(formObj.in_edi_snd_usr_id, false);
			ComEnableObject(document.all.from_to_calendar, false);
			document.all.item("bkrbkc_save").style.display="inline";
			document.all.item("qty_save").style.display="none";
			formObj.in_bkg_no.focus();
			break;
	}
}
/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {row} Long : 해당 셀의 Row Index
 * @param {col} Long : 해당 셀의 Column Index
 * @param {value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	if (document.form.radio_cd[1].checked) {
		if (sheetObj.ColSaveName(col) == "del_chk") {
			var editable=false;
			if (value == "0") editable=true;
			for (var i=0; i<5; i++) {
				if (sheetObj.GetCellValue(row, ("cntr_vol_qty"+ i)) != "") {
					sheetObj.SetCellEditable(row, ("cntr_vol_qty"+ i),editable);
				}
			}
		}
	}
}

/**
 * Processing the sheet data changes
* @param sheetObj Sheet
* @param Row
* @param Col
* @param Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
	if(Col == 3){
		if(Value == sheetObj.GetCellValue(Row, "be_bkrbkc")){
			sheetObj.SetCellValue(Row, "snaccs_tml_edi_sts_cng_flg","N");
		}else{
			sheetObj.SetCellValue(Row, "snaccs_tml_edi_sts_cng_flg","Y");
		}
	}
}

/**
 * handler afer saved
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	var formObject=document.form;
	doActionIBSheet(sheetObj, formObject, IBSEARCH, true);
}
/**
* handling process for input validation
* @param sheetObj
* @param formObj
* @param sAction
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			var fmDtObj=form.in_bat_skd_prd_fm_dt;
			var toDtObj=form.in_bat_skd_prd_to_dt;
			var fmDtValue=fmDtObj.value.replace(/-/g, "");
			var toDtValue=toDtObj.value.replace(/-/g, "");
			/*
			if(!isNull(formObj.in_bkg_no.value)){
				if( formObj.in_bkg_no.value.length != 13 ){
					ComAlertFocus(formObj.in_bkg_no, "");
					return false;
				}
			}
			*/
			if(formObj.radio_cd[0].checked){
				if(ComIsEmpty(formObj.in_bkg_no.value)){
					ComShowCodeMessage("COM130201", "BKG No");
					ComAlertFocus(formObj.in_bkg_no, "");
					return false;
				}
			}else if(formObj.radio_cd[1].checked){
//				vvd와 period 둘 중에 하나로 검색하기 위한 validation
				if (formObj.in_bat_skd_prd_fm_dt.value==""&&formObj.in_bat_skd_prd_to_dt.value=="") {
					if( formObj.in_vvd_cd.value == "" ){
						ComShowCodeMessage('BKG02111');
						formObj.in_vvd_cd.focus();
						return false;
					}
				}else {
					if (formObj.in_bat_skd_prd_fm_dt.value!="" && formObj.in_bat_skd_prd_to_dt.value=="") {
						ComShowCodeMessage('BKG02111');
						formObj.in_vvd_cd.focus();
						return false;
					}else if (formObj.in_bat_skd_prd_fm_dt.value=="" && formObj.in_bat_skd_prd_to_dt.value!="") {
						ComShowCodeMessage('BKG02111');
						formObj.in_vvd_cd.focus();
						return false;
					}
				}
		if( formObj.in_bat_skd_prd_fm_dt.value==""&&formObj.in_bat_skd_prd_to_dt.value==""&&formObj.in_vvd_cd.value == ""&&formObj.in_pol_cd.value == ""&&formObj.in_edi_snd_usr_id.value == "") {
		ComShowCodeMessage("BKG02113"); // "Please input VVD or POL or Period or User ID."
		return false;
		 }
			}
			if( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
				 ComShowCodeMessage("BKG95026", "From Date", "To Date");
				 ComSetFocus(fmDtObj);
				 return false;
			}
			var fromAddDays=ComGetDateAdd(fmDtValue, "D", 364, "", true);
			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
				ComSetFocus(fmDtObj);
				return false;
			}
			return true;
			break;
		case MULTI01:
			//모두 체크가 안되었으면 (0 이면)
			var iCheckRow=sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage('BKG02108');
			   return false;
			}
			return true;
			break;
		case IBSAVE:
			 //전송
			//모두 체크가 안되었으면 (0 이면)
			var iCheckRow=sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage('BKG02109');
			   return false;
			}
			if(sheetObjects[0].GetCellValue(i,"del_chk") == 1 &&sheetObjects[0].GetCellValue(i,"jp_tml_vsl_no") == ""){
				ComShowCodeMessage('BKG02115');// "Please input Voyage number."
				sheetObjects[0].SelectCell(i,"jp_tml_vsl_no");
			return;
			}
			return true;
			break;
	}
	return true;
}
/**
 * If Form input value is Null
 */
function isNull(itemValue){
	if(itemValue==null || itemValue=="" || itemValue=="undefined"){
		return true;
	}
	else{
		return false;
	}
}
