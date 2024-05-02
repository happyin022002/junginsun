/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0543.js
*@FileTitle  : Vessel Departure Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_Transmit":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_close":
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
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
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
	sheetObjects[0].RemoveAll();
	sheetObjects[0].DataInsert(-1);
	initControl();
}
/**
 * setting event of HTML Control
*/
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	formObject.vvd.focus();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
			
		    (12, 0, 0, true);
		    var HeadTitle1="Flag|vvd|pol_cd|pod_cd|B/L count|Name|Atd/Etd|Eta|MI Transmit|snd yn|HI Transmit|";
		
		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    InitHeaders(headers, info);
		
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vvd" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eta" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"name" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"mi_transmit" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bl_count" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"atd" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"hi_snd_yn" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"hi_transmit" },
		            {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id" } ];
		       
		    InitColumns(cols);
		
		    SetEditable(1);
		    SetSheetHeight(200);
        }
	    break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH01;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0543GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case COMMAND01:
		formObj.f_cmd.value=MULTI01;
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i=1; i < sheetObj.rowCount + 1; i++) {
				sheetObj.SetRowStatus(i,"U");
			}
			if (ComShowConfirm("Do you want to transmit HI to US Customs?")) {
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
				+"&f_cmd=" + MULTI01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0543GS.do", sParam);
				ComOpenWait(false);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				// formObj.output.value = sheetObj.EtcData("flatFile");
				if (sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
					ComShowCodeMessage('BKG00101');
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				} else {
					ComShowCodeMessage('BKG00099');
				}
				for ( var i=1; i < sheetObj.rowCount + 1; i++) {
					sheetObj.SetRowStatus(i,"");
				}
			}
		}
		//doActionIBSheet(sheetObj,formObj,SEARCH02, sheetObj.SelectRow);
		break;
	}
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (document.form.f_cmd.value == MULTI) {
			ComShowCodeMessage('BKG00166');
			// doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		}
	} else {
		ComShowCodeMessage('BKG00167');
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
	if (ErrMsg == "") {
		if (sheetObj.RowCount()> 0) {
			document.form.vvd.value=sheetObj.GetCellValue(1, "vvd");
			document.form.pol_cd.value=sheetObj.GetCellValue(1, "pol_cd");
			document.form.pod_cd.value=sheetObj.GetCellValue(1, "pod_cd");
			document.form.bl_count.value=sheetObj.GetCellValue(1, "bl_count");
			document.form.name.value=sheetObj.GetCellValue(1, "name");
			document.form.snd_usr_id.value=sheetObj.GetCellValue(1, "snd_usr_id");
			var atdFull=sheetObj.GetCellValue(1, "atd");
			var etaFull=sheetObj.GetCellValue(1, "eta");
			var mitFull=sheetObj.GetCellValue(1, "mi_transmit");
			var hiSndYn=sheetObj.GetCellValue(1, "hi_snd_yn");
			var hitFull=sheetObj.GetCellValue(1, "hi_transmit");
//			if (hiSndYn == "Y") {
//				ComBtnDisable("btn_Transmit");
//			} else {
//				ComBtnEnable("btn_Transmit");
//			}
			if (atdFull.length > 8) {
				document.form.atd.value=atdFull.substring(0, 8);
				document.form.atd_time.value=atdFull.substring(9);
			} else {
				document.form.atd.value="";
				document.form.atd_time.value="";
			}
			if (etaFull.length > 8) {
				document.form.eta.value=etaFull.substring(0, 8);
				document.form.eta_time.value=etaFull.substring(9);
			} else {
				document.form.eta.value="";
				document.form.eta_time.value="";
			}
			if (mitFull.length > 8) {
				document.form.mi_transmit.value=mitFull.substring(0, 8);
				document.form.mi_transmit_time.value=mitFull.substring(9);
			} else {
				document.form.mi_transmit.value="";
				document.form.mi_transmit_time.value="";
			}
			if (hitFull.length > 8) {
				document.form.hi_transmit.value=hitFull.substring(0, 8);
				document.form.hi_transmit_time.value=hitFull.substring(9);
			} else {
				document.form.hi_transmit.value="";
				document.form.hi_transmit_time.value="";
				document.form.snd_usr_id.value="";
			}
		}
	} else {
		document.form.bl_count.value="";
		document.form.name.value="";
		document.form.snd_usr_id.value="";
		document.form.atd.value="";
		document.form.atd_time.value="";
		document.form.eta.value="";
		document.form.eta_time.value="";
		document.form.mi_transmit.value="";
		document.form.mi_transmit_time.value="";
		document.form.hi_transmit.value="";
		document.form.hi_transmit_time.value="";
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
			ComShowCodeMessage("BKG00626", "VVD");
			return false;
		}
		if (formObj.pol_cd.value == "" || formObj.pol_cd.value.length != 5) {
			ComShowCodeMessage("BKG00626", "POL");
			return false;
		}
		if (formObj.pod_cd.value == "" || formObj.pod_cd.value.length != 5) {
			ComShowCodeMessage("BKG00626", "POD");
			return false;
		}
		
		return true;
		break;
	case COMMAND01:
		if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
			ComShowCodeMessage("BKG00626", "VVD");
			return false;
		}
		if (formObj.pol_cd.value == "" || formObj.pol_cd.value.length != 5) {
			ComShowCodeMessage("BKG00626", "POL");
			return false;
		}
		if (formObj.pod_cd.value == "" || formObj.pod_cd.value.length != 5) {
			ComShowCodeMessage("BKG00626", "POD");
			return false;
		}

		if (formObj.bl_count.value == "" || formObj.name.value == "") {
			ComShowCodeMessage('BKG00266');
			return false;
		}
		return true;
		break;
	}
}
