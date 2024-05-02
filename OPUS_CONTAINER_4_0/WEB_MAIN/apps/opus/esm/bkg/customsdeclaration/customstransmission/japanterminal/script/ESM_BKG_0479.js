/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG-0479.js
*@FileTitle  : ESM_BKG-0479
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
var chkFlg="N";
//Event handler processing by button click event
document.onclick=processButtonClick;

function skd_delt_flg_cofing(gubun) {
	if(gubun){
		sheetObjects[0].SetColProperty(0,15,{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_delt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } );
		sheetObjects[0].SetColProperty("skd_delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
	}else{
		//sheetObjects[0].InitDataProperty(0, 15, dtData, 70, daCenterTop, true, "skd_delt_flg", 		false, "", dfNone, 0, false, false);
		sheetObjects[0].SetColProperty(0, 15, {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_delt_flg",  KeyField:0,   CalcLogic:"", Format:"",PointCount:0,   UpdateEdit:0,InsertEdit:0 });
	}
}
//Event handler processing by button name
function processButtonClick() {

	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_Retrieve":
				skd_delt_flg_cofing(false);
				chkFlg="Y";
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				ComBtnDisable("btn_Add");
				break;

			case "btn_RouteRetrieve":
				skd_delt_flg_cofing(false);
				chkFlg="N";
				doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
				ComBtnEnable("btn_Add");
				break;

			case "btn_New":
				skd_delt_flg_cofing(false);
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				ComBtnEnable("btn_Add");
				break;

			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;

			case "btn_Trans":
				doActionIBSheet(sheetObjects[0], formObject, MULTI01);
				break;

			case "btn_Add":
				skd_delt_flg_cofing(false);
				ComBtnDisable("btn_Trans");
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"edi_snd_ofc_cd",formObject.usrOfc.value,0);
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"edi_snd_usr_id",formObject.usrId.value,0);
				//sheetObject1.CellValue2(,"ibflag") = "I";
				break;

			case "btn_Delete":
				//ComRowHideDelete(sheetObject1,"del_chk");
				for(i=2; i<=sheetObjects[0].RowCount()+1 ; i++) {
					if(sheetObjects[0].GetCellValue(i,"del_chk")=="1"){
						 // sheetObjects[0].CellValue2(i,"ibflag") = "D";
						  sheetObjects[0].SetRowHidden(i,1);    //2.row hidden
						  sheetObjects[0].SetRowStatus(i,"D");  //3. transaction status = Delete
					}
				}
				break;
			case "from_Calendar": // From calendar
				var cal=new ComCalendar();
				cal.select(formObject.in_bat_skd_prd_fm_dt, 'yyyy-MM-dd');
				break;
			case "to_Calendar": // To calendar
				var cal=new ComCalendar();
				cal.select(formObject.in_bat_skd_prd_to_dt, 'yyyy-MM-dd');
				break;
			case "from_to_calendar": // From - To calendar
				var cal=new ComCalendarFromTo();
				cal.select(formObject.in_bat_skd_prd_fm_dt, formObject.in_bat_skd_prd_to_dt, 'yyyy-MM-dd');
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

	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
	ComBtnDisable("btn_Trans");
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
	switch(event.srcElement.name){
		case "in_bat_skd_prd_fm_dt":
			ComAddSeparator(event.srcElement);
			break;
		case "in_bat_skd_prd_to_dt":
			ComAddSeparator(event.srcElement);
			break;
		default:
			break;
	}
}
/**
 * onblur event Validation check of HTML Control. <br>
 */
function obj_activate() {
	switch(event.srcElement.name){
		case "in_bat_skd_prd_fm_dt":
			ComClearSeparator(event.srcElement);
			break;
		case "in_bat_skd_prd_to_dt":
			ComClearSeparator(event.srcElement);
		default:
			break;
	}
}
/**
 * onblur event Validation check of HTML Control.  <br>
 */
function obj_blur(){
	obj=event.srcElement;
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
 * Get Object Value
 */
function getObjValue(name) {
	return ComGetObjValue(eval("document.form."+name));
}
/**
* Set Object Value
*/
function setObjValue(name, value) {
	ComSetObjValue(eval("document.form."+name), value);
}
/**
 * Move Focus in Object
 */
function setFocus(name) {
	ComSetFocus(eval("document.form."+name));
	eval("document.form."+name).select();
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
		with (sheetObj) {
			var HeadTitle1="Flag|Seq.|Chk|VVD|Cons Voy.|POL|CY code|POR|CY code|Othr Ntfy|Create Date|Period|Period|Office|User ID|Delete Flg|Save Flg|vsl_pre_pst_cd|vsl_seq|be_pol_yd_cd|be_por_yd_cd|chk_vsl_flg";
			var HeadTitle2="Flag|Seq.|Chk|VVD|Cons Voy.|POL|CY code|POR|CY code|Othr Ntfy|Create Date|ETA-14\n(YYYY-MM-DD)|ETA\n(YYYY-MM-DD)|Office|User ID|Delete Flg|Save Flg|vsl_pre_pst_cd|vsl_seq|be_pol_yd_cd|be_por_yd_cd|chk_vsl_flg";
			var headCount=ComCountHeadTitle(HeadTitle2);
			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0} );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
			{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",             KeyField:0 },
						{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						{Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",            KeyField:0,   Format:"",    UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             KeyField:1,   Format:"",    UpdateEdit:0,   InsertEdit:1, EditLen:9, AcceptKeys:"E|N" , InputCaseSensitive:1},
						{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"jp_tml_vsl_no",      KeyField:1,   Format:"",    UpdateEdit:1,   InsertEdit:1, EditLen:10, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						{Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:1,   Format:"",    UpdateEdit:0,   InsertEdit:1, EditLen:5, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						{Type:"ComboEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",          KeyField:1,   Format:"",    UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						{Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",             KeyField:1,   Format:"",    UpdateEdit:0,   InsertEdit:1, EditLen:5, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						{Type:"ComboEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"por_yd_cd",          KeyField:0,   Format:"",    UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						{Type:"ComboEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"otr_ntfy_yd_cd",     KeyField:0,   Format:"",    UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"create_dt",          KeyField:0,   Format:"Ymd", UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bat_skd_prd_fm_dt",  KeyField:0,   Format:"Ymd", UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bat_skd_prd_to_dt",  KeyField:0,   Format:"Ymd", UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_ofc_cd",     KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_usr_id",     KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_delt_flg",       KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },

						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"save_flg",           KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_pre_pst_cd",     KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_seq",            KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"be_pol_yd_cd",       KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"be_por_yd_cd",       KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chk_vsl_flg",        KeyField:0,   Format:"",    UpdateEdit:0,   InsertEdit:0 } ];
			InitColumns(cols);
			SetEditable(1);

			SetColProperty("pol_yd_cd", {ComboText:"|" + jpTeminalCyCode, ComboCode:"|" + jpTeminalCyCode} );    // jpTeminalCy - JSP에서 정의
			SetColProperty("por_yd_cd", {ComboText:"|" + jpTeminalCyCode, ComboCode:"|" + jpTeminalCyCode} );    // jpTeminalCy - JSP에서 정의
			SetColProperty("otr_ntfy_yd_cd", {ComboText:"|" + jpTeminalCyCode, ComboCode:"|" + jpTeminalCyCode} );    // jpTeminalCy - JSP에서 정의

			SetSelectionMode(smSelectionCol);
			SetSheetHeight(410);
			SetRangeBackColor(1, 3, 1, 12,"#555555");

			InitComboNoMatchText(1,"",1);
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
			if (!validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			//var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0479GS.do", sParam);
			if(sXml.length>0){
				sheetObj.LoadSearchData(sXml,{Sync:1} );
			}
			ComOpenWait(false);
		break;

		case SEARCH01:      //BKG Route search
			if (!validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			//var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0479GS.do", sParam);
			if(sXml.length>0){
				sheetObj.LoadSearchData(sXml,{Sync:1} );
			}
			for(i=2; i<=sheetObj.RowCount()+1 ; i++) {
				sheetObj.SetCellValue(i,"ibflag","I",0);
			}
			ComOpenWait(false);
		break;

		case IBSAVE:        // Save
			if (!validateForm(sheetObj,formObj,sAction)) return;
			//when the data => del_chk = checked & IBflg=Update or Insert
			var sParamSheet = sheetObjects[0].GetSaveString(false, true, 2);
			if (sParamSheet == "") return;

			formObj.f_cmd.value=MULTI;
			for(i=2; i<sheetObjects[0].RowCount()+1 ; i++) {
				if(sheetObjects[0].GetCellValue(i,"por_yd_cd")==null){
					sheetObjects[0].SetCellValue(i,"por_yd_cd"," ",0);
				}
			}
			var sParam=FormQueryString(formObj)+ "&" +ComSetPrifix(sParamSheet, "");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0479GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			var resultStr=ComGetEtcData(sXml, "resultStr");
			var chkVslFlg=ComGetEtcData(sXml, "chkVslFlg");

			var flg=ComGetEtcData(sXml, "flg");
			if(resultStr=="N"){
				ComShowCodeMessage("BKG00651","BKG ROUTE");
				return;
			}

			if(flg=="Y"){
				ComShowCodeMessage("BKG03056","Mandantory value(VVD, POL, POL CY, POR, POR CY)");
				return;
			}

			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			if(sav == "S"  ){
				ComShowCodeMessage("COM130102", "Data");
				if(formObj.in_vvd_cd.value!="" && formObj.in_vvd_cd.value!= null){
					skd_delt_flg_cofing(false);
					chkFlg="Y";
					ComBtnDisable("btn_Add");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);// SKD search
				}
			} else {
				ComShowCodeMessage("COM132103", "Data");
			}
		break;

		case MULTI01:        //TRANSMIT
			if (!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=MULTI01;
			for(var i=2; i<= sheetObjects[0].RowCount()+1; i++) {
				if (sheetObjects[0].GetCellValue(i,"del_chk") == 1 && sheetObjects[0].GetCellValue(i,"skd_delt_flg") == "Y") {
					ComShowCodeMessage("BKG02119", i-1);
					return;
				}
			}
			var sParamSheet=sheetObjects[0].GetSaveString(false, true, 2);
			if (sParamSheet == "") return;

			var sParam = FormQueryString(formObj)+"&"+ComSetPrifix(sParamSheet, "");
			var sXml = sheetObj.GetSaveData("ESM_BKG_0479GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
		break;

		case IBCLEAR: // New
			formObj.reset();
			sheetObj.RemoveAll();
			formObj.in_vvd_cd.focus();
		break;
	}
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
			if( formObj.in_bat_skd_prd_fm_dt.value =="" && formObj.in_bat_skd_prd_to_dt.value == "" && formObj.in_vvd_cd.value == "" && formObj.in_pol_cd.value == "" && formObj.in_edi_snd_usr_id.value == "") {
				ComShowCodeMessage("BKG02113"); // "Please input VVD or POL or Period or User ID."
				return false;
			}
			return true;
			break;

		case SEARCH01:
			if (formObj.in_vvd_cd.value == ""||formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage("BKG00754");
				formObj.in_vvd_cd.focus();
				return false;
			}
			if(formObj.in_pol_cd.value == ""){
				ComShowCodeMessage("BKG00209");
				formObj.in_pol_cd.focus();
				return false;
			}
			return true;
			break;

		case MULTI01:
			//Is there no checked row?
			var iCheckRow=sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage("BKG02108");//  "Please click the Check Box which you want to transmit"
			   return;
			}
			return true;
			break;

		case IBSAVE:
			//Is there no checked row?
			var iCheckRow=sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage("BKG02109");//coBKG 추가   "Please click the Check Box which you want to save"
			   return;
			}
			for(i=2; i<=sheetObjects[0].RowCount()+1 ; i++) {
				if(sheetObjects[0].GetCellValue(i,"bat_skd_prd_fm_dt") > sheetObjects[0].GetCellValue(i,"bat_skd_prd_to_dt")){
					 ComShowCodeMessage("BKG95026", "From Date", "To Date");
					return;
				}
			}
			return true;
			break;
	}
}
/**
 * Post-searh processing
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;

	if(chkFlg=="Y"){
		for(i=2; i<=sheetObjects[0].RowCount()+1 ; i++) {
			//if (sheetObjects[0].CellValue(i,"save_flg")=="Y") {
			ComBtnEnable("btn_Trans");
			 //sheet1_OnClick(sheetObj, nRow, sheetObj.SaveNameCol("radio"), 1);
		//}
		}
	}else{
		ComBtnDisable("btn_Trans");
	}

	for(i=2; i<=sheetObjects[0].RowCount()+1 ; i++) {
		if(sheetObj.GetCellValue(i, "skd_delt_flg") == "Y") {
			sheetObj.SetRowBackColor(i,"#FFC0C0");
		}
	}
}

/**
 * handler afer saved
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj=document.form;

	for(i=2; i<=sheetObjects[0].RowCount()+1 ; i++) {
		if(sheetObj.GetCellValue(i, "skd_delt_flg") == "Y") {
				sheetObj.SetRowBackColor(i,"#FFC0C0");
		}
	}
	 doActionIBSheet(sheetObj, formObj, IBSEARCH);
}

