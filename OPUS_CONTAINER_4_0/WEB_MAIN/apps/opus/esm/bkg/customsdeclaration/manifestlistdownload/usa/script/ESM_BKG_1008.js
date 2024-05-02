/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1008.js
*@FileTitle  : ESM_BKG-1008
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/23
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_rowadd":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_rowdelete":
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//axon_event.addListenerFormat("KeyPress", "my_obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * setting sheet initial values and header  adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1":
    with(sheetObj){
      if (location.hostname != "")
      var HeadTitle1=" |Sel.|User|User|User|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|Manifest Details by B/L|P/MIB|P/MIB|MI|OFM|OFM|Creation|Creation|Creation";
      var HeadTitle2=" |Sel.|ID|Name|Office|VVD|POD|DEL|HUB|Customs Loc|P/MIB No.|F.POD|PTT|FTZ|DIV|HUB|Customs Loc|Multi|MI|History|Date|User ID|Office";
      var headCount=ComCountHeadTitle(HeadTitle1);
      (headCount, 0, 0, true);
      var prefix="sheet1_";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [  {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"usr_id",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"usr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_del",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_hub",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_cstms",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                    {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_mib",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_fpo",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_ptt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_ftz",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_div",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mi_hub",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mi_cstms",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mi_multi",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"of_mit",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"CheckBox",  Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"of_his",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
                ];
               
      InitColumns(cols);

      SetEditable(1);

      SetSheetHeight(420);
    }

		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction))
		{
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		}
		break;
	case SEARCH01: // retrieve
		if (validateForm(sheetObj, formObj, sAction))
		{
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			var search_auth_count=ComGetEtcData(sXml, "search_auth_count");
			if (search_auth_count > 0) {
				ComShowCodeMessage('BKG00764', 'User ID');
				sheetObj.SetCellValue(Row, "sheet1_usr_id","",0);
				sheetObj.SetCellValue(Row, "sheet1_usr_nm","",0);
				sheetObj.SetCellValue(Row, "sheet1_ofc_cd","",0);
			}
			else if (ComGetEtcData(sXml, "search_usr_nm") == undefined || ComGetEtcData(sXml, "search_usr_nm") == "")
			{
				ComShowCodeMessage("BKG00768");
				sheetObj.SetCellValue(Row, "sheet1_usr_id","",0);
				sheetObj.SetCellValue(Row, "sheet1_usr_nm","",0);
				sheetObj.SetCellValue(Row, "sheet1_ofc_cd","",0);
			}
			else
			{
				sheetObj.SetCellValue(Row, Col + 1,ComGetEtcData(sXml, "search_usr_nm"));
				sheetObj.SetCellValue(Row, Col + 2,ComGetEtcData(sXml, "search_ofc_cd"));
				if (isNullEtcData(sXml)) {
					ComShowCodeMessage('BKG00768');
					sheetObj.SetCellValue(Row, Col,"",0);
				}
			}
			ComOpenWait(false);
		}
		break;
	case IBSAVE: // save
		if (validateForm(sheetObj, formObj, sAction))
		{
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), -1, true);
			ComOpenWait(false);
		}
		break;
	case IBINSERT: // input
		sheetObj.DataInsert(-1);
		sheetObj.SelectCell(sheetObj.GetSelectRow(), 2);
		break;
	case IBDELETE: // delete
		if (sheetObj.CheckedRows(1) == 0) {
			ComShowCodeMessage('BKG00249'); // No Selected Row
			return;
		}
		if (sheetObj.CheckedRows(1) > 0) {
			if (ComShowCodeConfirm('BKG03037')) {
				ComRowHideDelete(sheetObj, "sheet1_del_chk");
			}
		}
		break;
	case IBDOWNEXCEL: 
        if(sheetObj.RowCount() < 1){//no data
            ComShowCodeMessage("COM132501");
            return;
        }
		var viewCols = "sheet1_usr_id|sheet1_usr_nm|sheet1_ofc_cd|sheet1_bl_vvd|sheet1_bl_pod|sheet1_bl_del" 
				     + "|sheet1_bl_hub|sheet1_bl_cstms|sheet1_bl_mib|sheet1_bl_fpo|sheet1_bl_ptt|sheet1_bl_ftz|sheet1_bl_div" 
				     + "|sheet1_mi_hub|sheet1_mi_cstms|sheet1_mi_multi|sheet1_of_mit|sheet1_of_his|sheet1_cre_dt|sheet1_cre_usr_id|sheet1_cofc_cd";
		sheetObj.Down2Excel({DownCols: viewCols, CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1,Merge:1 });
		break;
	}
}

/**
 * function sheet1_OnSearchEnd for ComOpenWait(false)
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI:
		var prefix="sheet1_";
		for ( var i=2; i <= sheetObj.RowCount()+ 2; i++) {
      var vUsrId=sheetObj.GetCellValue(i, prefix + "usr_id");
      if (sheetObj.GetCellValue(i, "ibflag") != "R") {
				if (!ComIsNull(vUsrId)) {
					ComShowCodeMessage('BKG00104', 'User ID');
					return false;
				}
			}
		}
		break;
	}
	return true;
}
/**
 * process as changing sheet
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var prefix="sheet1_";
	var formObject=document.form;
	if (sheetObj.ColSaveName(Col) == prefix + "usr_id") {
		formObject.ch_usr_id.value=Value;
		doActionIBSheet(sheetObj, formObject, SEARCH01, Row, Col);
	}
}
/**
 * check if ETC-DATA is null
 */
function isNullEtcData(xmlStr) {
	var rtn=false;
  var xmlDoc = ComGetXmlDoc(xmlStr);
  if (xmlDoc == null) return;
  var xmlRoot = xmlDoc.documentElement;

	var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null)
		return true;
	var etcNodes=etcDataNode.childNodes;
	if (etcNodes == null)
		return true;
	if (etcNodes.length == 0)
		rtn=true;
	return rtn;
}
/**
 * KeyPress event handling
 */
function my_obj_KeyPress() {
	switch (ComGetEvent("dataformat")) {
	case "eng": 
		MyComKeyOnlyAlphabet('uppernum');
		break;
	case "engspnum": 
		MyComKeyOnlyAlphabet('upperspecialcharnum');
		break;
	default: 
		MyComKeyOnlyAlphabet('uppernum');
		break;
	}
}
/**
 *  In case of KeyPress event,check for format
 */
function MyComKeyOnlyAlphabet(sFlag) {
	try {
		var keyValue=ComGetEvent("keycode") ? ComGetEvent("keycode") : ComGetEvent("which") ? ComGetEvent("which") : ComGetEvent("charCode");
		var bCanNum=false;
		var bSpecialChar=false;
		if (sFlag.indexOf("specialchar") >= 0)
			bSpecialChar=true;
		if (sFlag == undefined || sFlag == null || sFlag.constructor != String)
			sFlag="";
		sFlag=sFlag.toLowerCase();
		if (sFlag.length >= 3) {
			if (sFlag.substr(sFlag.length - 3) == "num")
				bCanNum=true;
			if (sFlag.length > 5)
				sFlag=sFlag.substr(0, 5);
		}
		if (keyValue >= 97 && keyValue <= 122) { 
			if (sFlag == "upper")
				ComGetEvent("keycode")=keyValue + 65 - 97;
			ComJsEventStop();
		} else if (keyValue >= 65 && keyValue <= 90) {
			if (sFlag == "lower")
				ComGetEvent("keycode")=keyValue + 97 - 65;
			ComJsEventStop();
		} else if (bCanNum && keyValue >= 48 && keyValue <= 57) {
			event.returnValue=true;
		} else if (bSpecialChar
				&& ((keyValue >= 33 && keyValue <= 47) || (keyValue >= 58 && keyValue <= 64) || (keyValue >= 91 && keyValue <= 96))) {// 특수문자
			ComJsEventStop();
		} else {
			//event.returnValue=false;
		}
		return true;
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * handling event after saving
 */
function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

