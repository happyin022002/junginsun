/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0771.js
*@FileTitle  : Covered B/L
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_0771 : business script for ESM_BKG_0771
 */
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * initializing sheet implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {	
	if (document.form.bkg_no.value == ''||document.form.bl_no.value == '') {
		ComShowCodeMessage("BKG00463");
		ComClosePopup(); 
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
* setting sheet initial values and header
* @param sheetObj
* @param sheetNo
* @return
*/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
        if (location.hostname != "")
        var HeadTitle="|Covered B/L No";
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);
        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12, AcceptKey:"E|N", InputCaseSensitive:1 },
               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"old_bl_no" } ];
        InitColumns(cols);
        SetSheetHeight(225);
        SetEditable(1);
      //conversion of function[check again]CLT 			InitDataValid(0, prefix + "bl_no", vtEngUpOther, "1234567890");
		}
		break;
	}
}
//Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	if (ComGetObjValue(formObj.bl_no).length > 12) {
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.bl_no).substr(0, 12));
	}
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_add":
			if('Y' == ComGetObjValue(formObj.caflag) ){
				ComShowCodeMessage("BKG08157");
				return;
			}
			
			var tcnt=sheetObject1.GetTotalRows();
			if (tcnt > 0) {
				var Row=sheetObject1.LastRow();
				var bl_no=sheetObject1.GetCellValue(Row, prefix + "bl_no");
				if (typeof bl_no != "undefined" && bl_no != "") {
					sheetObject1.DataInsert(-1);
				}
			} else {
				sheetObject1.DataInsert(-1);
			}
			break;
		case "btn_delete":
			if('Y' == ComGetObjValue(formObj.caflag) ){
				ComShowCodeMessage("BKG08157");
				return;
			}
			var sRow=sheetObject1.GetSelectRow();
			sheetObject1.SetRowHidden(sRow,1);
			sheetObject1.SetRowStatus(sRow,"D");
			break;
		case "btn_save":
			var cnt=sheetObject1.LastRow();
			var tmp_bl_no, comp_bl_no;
			var comp1_bl_no=ComGetObjValue(formObj.bl_no);
			for ( var i=1; i <= cnt; i++) {
				var ibflag=sheetObject1.GetCellValue(i, prefix + "ibflag");
				if (ibflag == 'D')
					continue;
				tmp_bl_no=sheetObject1.GetCellValue(i, prefix + "bl_no");
				for ( var j=1; j <= cnt; j++) {
						comp_bl_no=sheetObject1.GetCellValue(j, prefix + "bl_no");
					if (i != j && tmp_bl_no == comp_bl_no) {
						ComShowCodeMessage("BKG95007");
						sheetObject1.SelectCell(j, prefix + "bl_no");
						return false;
					}
				}
				if (comp1_bl_no == tmp_bl_no) {
					ComShowCodeMessage("BKG08060");
					sheetObject1.SelectCell(i, prefix + "bl_no");
					return false;
				}
			}
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;
		case "btn_close":
			rValueClose();
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
 * rValueSave 
 * 결과값을 리턴 
 */
var okSAVE='';
function rValueClose() {
	var formObj=document.form;
	if ('Y' == okSAVE) {
		var obj=new Object();
		obj.msg="OK";
		window.returnValue=obj;// setting retVal variable value
	}
  ComClosePopup(); 
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array("sheet1_");
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (validateForm(sheetObj, formObj, sAction))
		// 1.input parameter and setting selected value before retrieve
		ComSetObjValue(formObj.f_cmd, SEARCH);
		// 2.Execute retrieve as retrieve condition
 		sheetObj.DoSearch("ESM_BKG_0771GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix) );
		break;
	case IBSAVE: 
	if (!validateForm(sheetObj, formObj, sAction))
			return;
		// 1.input parameter and setting selected value before retrieve
		ComSetObjValue(formObj.f_cmd, MULTI);
		// 2.Execute as save condition
		var sParam=ComGetSaveString(sheetObjects);
		if (sParam == ""){
			ComShowMessage(ComGetMsg("BKG00743"));return;
		}
		if (!ComShowConfirm(ComGetMsg("BKG00824")))
			return; // Are you sure to save the changes?
		sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix); // hidden
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0771GS.do", sParam);
		//sheetObj.LoadSaveXml(sXml);
		var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			okSAVE='Y';
			ComShowMessage(ComGetMsg("BKG06071"));
		}else{
			fnExceptionMessage(sXml);
		}
		doActionIBSheet(sheetObj, document.form, IBSEARCH); // in order to get unique key value
		break;
	case IBINSERT:
		break;
	}
}
/**
 * t10sheet2_OnSearchEnd  event occurring after retrieve
 * param :sheetObj, ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	 var l_row=sheetObj.RowCount();
	 var formObj=document.form;
	 if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
		 ComBtnDisable("btn_add");
	 	 ComBtnDisable("btn_save");
	 	 ComBtnDisable("btn_delete");
	 }else{
		 ComBtnEnable("btn_add");
		 ComBtnEnable("btn_save");
		 ComBtnEnable("btn_delete");
	 }
}
/**
* handling process for input validation <br>
* @param sheetObj
* @param formObj
* @param sAction
* @return boolean
*/
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSAVE) {
			var sObject=sheetObj;
			var c_row=sheetObj.RowCount();
			//var c_row = sheetObj.LastRow;
			if (c_row == 0) {
				//"There is no updated data to save."
				ComShowMessage(ComGetMsg("BKG00743"));
				return false;
			}
			for ( var row=1; row <= c_row; row++) {
				if ( sheetObj.GetRowHidden(row)) continue;
				var v_bl_no=sheetObj.GetCellValue(row, prefix + "bl_no");
				if (v_bl_no == '') {
					sheetObj.SetRowHidden(row,1);
					sheetObj.SetRowStatus(row,"D");
				}
			}
		} else if (sAction == IBSEARCH) {
		}
	}
	return true;
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}	
 /**
 * fnExceptionMessage  
 * Alert error message
 * @param 
 * @return 
 */
 function fnExceptionMessage(rXml){
 	var rMsg=ComGetEtcData(rXml,"Exception")
 	var rmsg=rMsg.split("<||>");
 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
 		ComShowMessage(rmsg[3]);
 	}else{
  		sheetObjects[0].LoadSaveData(rXml);
 	}
 }
