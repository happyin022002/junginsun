/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1523.js
*@FileTitle  : Ship Call No Registration(KCT)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_SelectAll":
			var curChk = $('#btn_SelectAll').attr('checkedFlg') == "0" ? 0 : 1;
			var btnLabel = curChk ? "Select All" : "Deselect All";
			sheetObject1.CheckAll(2, curChk == 0 ? 1 : 0);
			$('#btn_SelectAll').attr('checkedFlg', curChk == 0 ? 1 : 0).html(btnLabel);
			break;
		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;
		case "btn_Delete":
			if(ComShowCodeConfirm('BKG95003', 'delete')){
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
			}
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_ImportSchedule":
			ComOpenPopup("ESM_BKG_1525.do?pgmNo=ESM_BKG_1525", 540, 400, "0002", "1,0", false);
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
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
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1="|Seq.|Sel.|OPUS VVD|OPUS VVD|OPUS VVD|KCT Vessel Name|Ship Call No.";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,  } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",             KeyField:0,   Edit:0,   EditLen:0 },
						{Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel",             KeyField:0,   Edit:1},
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",          KeyField:1,   Edit:1,   EditLen:4,     AcceptKeys:"E|N",    InputCaseSensitive:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",      KeyField:1,   Edit:1,   EditLen:4,     AcceptKeys:"N" },
						{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",      KeyField:1,   Edit:1,   EditLen:1,     AcceptKeys:"E|N",    InputCaseSensitive:1 },
						{Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:"psa_vsl_nm",      KeyField:1,   Edit:1,   EditLen:100 },
						{Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"psa_voy_dir_cd",  KeyField:1,   Edit:1,   EditLen:6,     AcceptKeys:"E|N|[`~!@#$%^&*_+|{}:\"<>?-=\\\[\];',./ ]",    InputCaseSensitive:1 } ];
			InitColumns(cols);
			SetSheetHeight(402);
			SetEditable(1);
		}
		break;
	}
}
/**
 * Sheet1 changing  ( in case of inserting VSL_CD ,saarching VSL_NM  )
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col) {
	//  searching the VSL NM in case of inserting VSL CD
	 if (Col==3) {
		  var formObj=document.form;
		  if (Col==3) {
			  // searching
			  formObj.f_cmd.value=COMMAND01;
			  var sXml=sheetObj.GetSearchData("ESM_BKG_1523GS.do?vsl_cd="+sheetObj.GetCellValue(Row,Col)+"&f_cmd="+formObj.f_cmd.value);
			  if (ComGetEtcData(sXml, "psa_vsl_nm")!=null && ComGetEtcData(sXml, "psa_vsl_nm").length > 1) {
				  sheetObj.SetCellValue(Row, "psa_vsl_nm",ComGetEtcData(sXml, "psa_vsl_nm"));
			  }else {
				  sheetObj.SetCellValue(Row, "psa_vsl_nm","");
			  }
		  }
	  }
}
// handling of Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_1523GS.do",  FormQueryString(formObj) );
			ComOpenWait(false);
		}
	break;
	case IBSAVE:
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			formObj.f_cmd.value=MULTI;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSave("ESM_BKG_1523GS.do",  FormQueryString(formObj), -1, false);
			ComOpenWait(false);
		}
		break;
	case IBDELETE:
		ComRowHideDelete(sheetObj,"Sel");
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:
			if (formObj.vsl_cd.value.length < 4) {
				ComShowCodeMessage("BKG00115");
				formObj.vsl_cd.focus();
				return false;
			}
			break;
		}
	}
	return true;
}