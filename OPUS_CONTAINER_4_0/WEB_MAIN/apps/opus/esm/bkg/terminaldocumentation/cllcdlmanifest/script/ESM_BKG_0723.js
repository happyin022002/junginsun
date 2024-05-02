/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   Esm_bkg_0723.js
*@FileTitle  : CLL/CDL EDI Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Global Variables */
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
/* Event handler defined process to button click event */
document.onclick=processButtonClick;
/* Event handler is branch processing by name of button */
function processButtonClick() {
	/***** Assignment sheet in case of over 2 by tab****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName= ComGetEvent("name");
		switch (srcName) {
		case "btn_OK":
			doActionIBSheet(sheetObjects[1], formObject, COMMAND01);
			break;
		case "btn_Close":
			ComClosePopup(); 
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
 * Register as an IBSheet Object array
 * This is called from comSheetObject(id)
 * Process can add in case of future necessity to process other items
 * Array defined at the top of the source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Initializing sheet
 * To implement onLoad event of body tag
 * Add functionality to after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		//Setting startup environment. Change the name of the function
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//Setting final environment.
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//if (parent.document != undefined && parent.document != null && parent.document.URL.indexOf('159') != -1) {
//  	  sheetObjects[1].SetVisible(0);
    //}
	initControl();
}
/**
 * Loading dynamically event of HTML Control in page <br> 
 * Calling {@link #loadPage} in function. Initializing IBSheet Object <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects array seq.
 */
function initControl() {
	// ** Date indicator **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
//	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - focus
//	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * Processing in case of retrieve condition inputting
 */
//function obj_KeyUp() {
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//		ComSetNextFocus();
//	}
//}
/**
 * Controlling keyboard inputting in onkeypress event of HTML Control
 */
//function obj_keypress() {
//	switch (event.srcElement.dataformat) {
//	case "uppernum":
//		// only upper case, numbers
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	case "upper":
//		// only upper case
//		ComKeyOnlyAlphabet('upper');
//		break;
//	case "uppernum2":
//		// only upper case, numbers
//		ComKeyAlphabetNChar('uppernum');
//		break;
//	default:
//		// only numbers(numbers,date,time)
//		ComKeyOnlyNumber(event.srcElement);
//	}
//}
/**
 * Initializing sheet. Defining header
 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
 * Composition a initial module in case of multi sheet
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
	      //if (location.hostname != "")
	      var HeadTitle1=" |Sel.|Terminal|Receiver ID (TP ID)|Snd|Svr|AREA|Message Type|VVD|BL";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,  Align:"Left",    ColMerge:0,   SaveName:"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"edi_rcv_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"edi_snd_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"edi_tml_svr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"area_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"msg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vvd_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(140);
	      SetEditable(1);
	      }
		break;
	case "sheet2": // sheet2 init
	    with(sheetObj){
	      var HeadTitle="|Seq.|Sel.|Cntr No.|Booking No.";
	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(200);
	      SetEditable(1);
        }
		break;
	}
}
/* Processing Sheet */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		if (formObj.in_list_type.value == "L")
			formObj.port_cd.value=formObj.in_pol_cd.value;
		else
			formObj.port_cd.value=formObj.in_pod_cd.value;
		// alert(formObj.in_port_cd.value);
 		sheetObj.DoSearch("ESM_BKG_0723GS.do", FormQueryString(formObj) );
		// alert(opener.document.sheet1);
//		var opener_obj=opener;
//		//var opener_sheet=window.dialogArguments.document.sheet1;
//		var opener_sheet=sheetObjects[1];
//		var rowcnt=0;
//		sheetObjects[1].RemoveAll();
//			if (formObj.in_list_type.value == "L") {
//				for ( var i=1 ; i<opener_sheet.RowCount()+1 ; i++ )
//				{
//					if ( opener_sheet.GetCellValue(i, "del_chk") == 1 )
//					{
//						//alert();
//						sheetObjects[1].DataInsert(-1);
//						rowcnt=rowcnt+1;
//						//alert(sheetObjects[1].CellValue(rowcnt,"cntr_no"));
//						sheetObjects[1].SetCellValue(rowcnt,"cntr_no",opener_sheet.GetCellValue(i,"cntr_no"));
//						sheetObjects[1].SetCellValue(rowcnt,"bkg_no",opener_sheet.GetCellValue(i,"bkg_no2"));
//						sheetObjects[1].SetCellValue(rowcnt, "del_chk",1);
//					}
//					sheetObjects[1].SetCellValue(rowcnt, "msg","COPRAR");
//				}
//			} 
//			for(var i=1 ; i<sheetObj.RowCount()+1 ; i++ )
//			{
//				sheetObjects[0].SetCellValue(i, "msg","COPRAR");
//			}
		ComOpenWait(false);
		break;
	case COMMAND01: // Save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=MULTI;
			formObj.in_rcv_id.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "edi_rcv_id");
			formObj.in_snd_id.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "edi_snd_id");
			formObj.in_yd_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "yd_cd");
			formObj.in_dest_svr_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "edi_tml_svr_cd");
			formObj.in_area_id.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "area_id");
			formObj.in_vvd_flg.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "vvd_flg");
			formObj.in_bl_flg.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bl_flg");
			// alert(formObj.in_area_id.value);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sParam="";
			if (formObj.in_list_type.value == "L")
			{
//				var sParamSheet1=sheetObj.GetSaveString(); 
				var sParamSheet1=ComGetSaveString(sheetObj); 
				if (sParamSheet1 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet1, "");
				}
				sParam += "&" + FormQueryString(formObj);
//				alert("param1:"+sParam);
 				var sXml=sheetObj.GetSaveData("ESM_BKG_0723GS.do", sParam);
			} else {				
				var opener_obj=window.dialogArguments;
				if (!opener_obj) opener_obj=window.opener;  //이 코드 추가할것
				if (!opener_obj) opener_obj=parent;               // 기존 가이드 부분
				var opener_sheet=opener_obj.sheet1;
				var sParamSheet1=opener_sheet.GetSaveString();
				if (sParamSheet1 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet1, "");
				}
				sParam += "&" + FormQueryString(formObj);
//				alert("sParam:"+sParam);
 				var sXml=opener_sheet.GetSaveData("ESM_BKG_0723GS.do", sParam);
			}
			var key=ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId=setInterval("doActionValidationResult(sheetObjects[1], '" + key + "');",3000);
		}
		break;
	case IBINSERT: // Insert
		break;
	}
}
/**
 * Processing BackEndJob
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	//sheetObjects[1].SetWaitImageVisble(0);
 	var sXml=sheetObj.GetSearchData("ESM_BKG_0723GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	var resultMsg=ComGetEtcData(sXml, "resultMsg");
	// Ending standby elements in case of error happen
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// Showing complete message
		if(resultMsg==null || resultMsg==""){
			ComShowCodeMessage('BKG00204');
		}else{
			ComShowMessage(resultMsg);
		}
		// ComShowMessage(ComResultMessage(sXml));
		return;
	} else if (sJbStsFlg == "FAIL") {
		// Error
		clearInterval(intervalId);
		ComOpenWait(false);
		// Showing error message
		ComShowMessage(ComResultMessage(sXml));
	}
}
/**
 * Checking validation of input value
 * @param sheetObj Sheet
 * @param formObj form object
 * @param sAction action code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case COMMAND01: // retrieve
		var vIsCheck=false;
		//for ( var i = 1; i <= sheetObj.RowCount; i++) {
		//	if (sheetObj.CellValue(i, "del_chk") == 1) {
		//		vIsCheck = true;
		//		break;
		//	}
		//}
		//alert(vIsCheck);
		//if (!vIsCheck) {
		//	ComShowCodeMessage('BKG00249', '');
		//	return false;
		//}
		var vIsCheck=false;
		for ( var i=0; i <= sheetObjects[0].RowCount(); i++) {
			if (sheetObjects[0].GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		//alert(vIsCheck);
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		break;
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var opener_obj=window.dialogArguments;
	if (!opener_obj)  opener_obj=window.opener;  //이 코드 추가할것
	if (!opener_obj) opener_obj=parent; //이 코드 추가할것
	//var opener_sheet=window.dialogArguments.document.sheet1;
	
	var opener_sheet=opener_obj.sheet1;
	
	
//	var opener_sheet=sheetObjects[1];
	// alert(opener_obj.document.sheet1.RowCount);
	var rowcnt=0;
	sheetObjects[1].RemoveAll();
		if (formObj.in_list_type.value == "L") {
			for ( var i=1 ; i<opener_sheet.RowCount()+1 ; i++ )
			{
				if ( opener_sheet.GetCellValue(i, "del_chk") == 1 )
				{
					//alert();
					sheetObjects[1].DataInsert(-1);
					rowcnt=rowcnt+1;
					//alert(sheetObjects[1].CellValue(rowcnt,"cntr_no"));
					sheetObjects[1].SetCellValue(rowcnt,"cntr_no",opener_sheet.GetCellValue(i,"cntr_no"));
					sheetObjects[1].SetCellValue(rowcnt,"bkg_no",opener_sheet.GetCellValue(i,"bkg_no2"));
					sheetObjects[1].SetCellValue(rowcnt, "del_chk",1);
				}
				sheetObjects[1].SetCellValue(rowcnt, "msg","COPRAR");
			}
		} 
		for(var i=1 ; i<sheetObj.RowCount()+1 ; i++ )
		{
			sheetObjects[0].SetCellValue(i, "msg","COPRAR");
		}
	
}