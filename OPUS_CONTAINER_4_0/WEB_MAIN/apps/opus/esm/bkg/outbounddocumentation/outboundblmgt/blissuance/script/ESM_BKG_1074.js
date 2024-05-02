/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1074.jsp
*@FileTitle  : Internet O.B/L Print Authorize
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/13
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Search]SEARCH=2; [List Search]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* developer job	*/
// common global variables
var sheetObjects = new Array();
var sheetCnt = 0;
var prefix = "sheet1_";
// Event handler processing by button click event
document.onclick = processButtonClick;

// Event handler processing by button name
function loadPage() {

	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463");
		ComClosePopup();
	}

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02); //Get e-mail template
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			var HeadTitle = "status|bkg_no|cust_tp|cust_cd|cust_nm";
			
			SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
			
			SetEditable(1);
			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
			             {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"cust_tp" },
			             {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"cust_cd" },
			             {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"cust_nm" } ];
			InitColumns(cols);
			
			SetCountPosition(0);
			
			//setting height
			SetSheetHeight(255);
		}
		break;

	}
}
//Event handler processing by button name
function processButtonClick() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName=ComGetEvent("name");

		switch (srcName) {

		case "pop_shpr":
			var s_cust_cnt_cd = ComGetObjValue(formObj.shpr_cd).substring(0,2) ; 
			var s_cust_seq = ComGetObjValue(formObj.shpr_cd).substring(2,formObj.shpr_cd.length) ; 
			var s_cust_nm = ComGetObjValue(formObj.shpr_nm);
			comBkgCallPop0652('callBack0652', 'S', s_cust_cnt_cd, s_cust_seq, (ComIsNull(s_cust_seq)?(s_cust_nm.substring(0,10)):""));

			break;

		case "pop_fwdr":
			var f_cust_cnt_cd = ComGetObjValue(formObj.fwdr_cd).substring(0,2) ; 
			var f_cust_seq = ComGetObjValue(formObj.fwdr_cd).substring(2,formObj.fwdr_cd.length) ; 
			var f_cust_nm = ComGetObjValue(formObj.fwdr_nm);
			comBkgCallPop0652('callBack0652', 'F', f_cust_cnt_cd, f_cust_seq, (ComIsNull(f_cust_seq)?(f_cust_nm.substring(0,10)):""));

			break;

		case "btn_Authorize":
			doActionIBSheet(sheetObj, formObj, MULTI01);
			break;

		case "btn_Email":
			if (ComIsEmpty(formObj.email_to.value)) {
				ComShowMessage(ComGetMsg("BKG00857"));
				ComSetFocus(formObj.email_to);
				return;
			}
			doActionIBSheet(sheetObj, formObj, MULTI02);
			break;

		case "btn_close":
			ComClosePopup();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			bkg_error_alert('processButtonClick', e);
			
		} else {
			alert(e);
		}
	}
}



/**
 * Customer Inquiry popup call<br>
 */
function comBkgCallPop0652(callback_func, bkgCustTpCd, custCntCd, custSeq, custNm) {
	ComOpenPopup("ESM_BKG_0652.do?pgmNo=ESM_BKG_0652&bkg_cust_tp_cd="+bkgCustTpCd+"&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm, 980, 540, callback_func,"1,0,1,1,1", true);
//	ComOpenPopup("ESM_BKG_0652.do?bkg_cust_tp_cd=" + bkgCustTpCd
//			+ "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq, 900, 690,
//			callback_func, "1,0,1,1,1", true);
}


 /**
  * Customer Inquiry popup call back<br>
  */
function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
	var formObj = document.form;
	var email = ComGetObjValue(formObj.email_to);
	var f_flg =false; 
	if(rArray2 != null){
		if(email.length>0)email=email+ ";";
		for(i = 0 ; i < rArray2.length ; i++){
			if(rArray2[i][7] == '') continue;
			if(f_flg){
				email= email + ";"+ rArray2[i][7];
			}else{
				email= email + rArray2[i][7]; 
				f_flg = true;
			}
		}
	}
	ComSetObjValue(formObj.email_to, email);
}

//handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	
		switch (sAction) {

		case IBSEARCH: // search
			if (validateForm(sheetObj, formObj, sAction))
				ComOpenWait(true);
			ComSetObjValue(formObj.f_cmd, SEARCH);
			var sParam = FormQueryString(formObj); 
			
			var sXml = sheetObj.GetSearchData("ESM_BKG_1074GS.do", sParam);

			var State = ComGetEtcData(sXml, "TRANS_RESULT_KEY");

			if (State == "S") {
				sheetObj.LoadSearchData(sXml,{Sync:1});
			} else {
				var rMsg = ComGetEtcData(sXml, "Exception");
				var rmsg = rMsg.split("<||>");
				if (rmsg[3] != '') {
					ComShowMessage(rmsg[3]);
				}
			}

			break;

		case MULTI01: //authorize

			if (ComShowConfirm(ComGetMsg("BKG08110"))) {
				// Are you sure to authorize the printing of Internet O.B/L?) 

				try {
					ComOpenWait(true);

					//2014.11.28 Maeda Add setTimeout to show waiting image
					setTimeout( function(){
					var localopener = (opener || parent);
					localopener.btn_Authorize();
				
					ComBtnDisable("btn_Authorize");
					
					ComShowMessage(ComGetMsg("BKG06071"));
					
					}, 100);
					
				} catch (ex) {
					bkg_error_alert('sheet1_OnSearchEnd', ex);
					ComOpenWait(false); 
				}
			
			}

			break;

		case MULTI02: //e-mail

			if (!ComShowConfirm(ComGetMsg("BKG08111")))
				return; // Do you want to send E-mail?
			ComOpenWait(true);
			ComSetObjValue(formObj.f_cmd, MULTI02);
			var sParam = FormQueryString(formObj); // hidden param value
			// 2. save
			var sXml = sheetObj.GetSaveData("ESM_BKG_1074GS.do", sParam);
			// 3. after save
			var State = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			if (State == "S") {
				sheetObj.LoadSaveData(sXml);
				ComShowMessage(ComGetMsg("BKG00497"));
			} else {
				fnExceptionMessage(sXml);
			}
			break;

		case SEARCH02: // search02 Template search
			if (validateForm(sheetObj, formObj, sAction))
				ComOpenWait(true);
			ComSetObjValue(formObj.f_cmd, SEARCH02);
			var sParam = FormQueryString(formObj); 

			var sXml = sheetObj.GetSearchData("ESM_BKG_1074GS.do", sParam);
	
			ComSetObjValue(document.form.email_subject, ComGetEtcData(sXml, "emlTitle"));
			ComSetObjValue(document.form.email_contents, ComGetEtcData(sXml, "emlBody"));
			
			break;
		}
	ComOpenWait(false); 
}

/**
* fnExceptionMessage 
*/
function fnExceptionMessage(rXml){
	var rMsg = ComGetEtcData(rXml,"Exception")
	var rmsg = rMsg.split("<||>");	
	if(rmsg[3] != undefined && rmsg[3].length > 0) {
		ComShowMessage(rmsg[3]);
	}else{
		sheetObjects[0].LoadSaveData(rXml);
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	var formObj = document.form;
	var cnt = sheetObj.RowCount();
	try {

		if (cnt > 0) {
			for ( var i = 1; i <= cnt; i++) {

				if (sheetObj.GetCellValue(i, "cust_tp") == "SHPR") {
					ComSetObjValue(formObj.shpr_cd, sheetObj.GetCellValue(i, "cust_cd"));
					ComSetObjValue(formObj.shpr_nm, sheetObj.GetCellValue(i, "cust_nm"));
				}
				if (sheetObj.GetCellValue(i, "cust_tp") == "FWDR") {
					ComSetObjValue(formObj.fwdr_cd, sheetObj.GetCellValue(i, "cust_cd"));
					ComSetObjValue(formObj.fwdr_nm, sheetObj.GetCellValue(i, "cust_nm"));
				}
			}
		}

	} catch (ex) {
		bkg_error_alert('sheet1_OnSearchEnd', ex);
	}	
	
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		// }
	}

	return true;
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 
 /**
  * bkg_error_alert 
  */
 function bkg_error_alert(msg, ex) {
 	ComShowMessage('[ ' + msg + ' ] \n [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
 }
  /* end developers work */