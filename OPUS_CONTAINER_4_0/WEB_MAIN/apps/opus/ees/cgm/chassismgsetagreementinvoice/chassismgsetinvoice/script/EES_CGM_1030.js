/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1030.js
*@FileTitle  : Invoice Import & Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1030 : ees_cgm_1030 business script for
 */
/* developer job	*/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
var opener;
// Event handler processing by button name */
function processButtonClick() {
	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Loadexcel":
			doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
			ComBtnDisable("btn_Save");
			break;
		case "btn_Downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;
		case "btn_Audit":
			//doActionIBSheet(sheetObject1, formObject, MULTI01); // 
			doActionIBSheet(sheetObject1, formObject, MULTI03); // STEP1.INSERT
																// STEP2.SEARCH
			break;
		case "btn_New":
			initControl();
			break;
		case "btn_Agreemapping":
			var pgmNo='EES_CGM_1028';
			var pgmUrl='/opuscntr/EES_CGM_1028.do';
			var parentPgmNo=pgmNo.substring(0, 8) + 'M001';
			var src="&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&pgmNo=" + pgmNo;
			var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
//			var winObj=window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);
			ComOpenWindowCenter('/opuscntr/EES_CGM_1028_POP.do?parentPgmNo=' + parentPgmNo + src, "", 1250, 700, false);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_Close":
			opener.closeSearch();
			ComClosePopup(); 
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
	opener = window.dialogArguments;
	if (!opener)
		opener = parent;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	initControl();
}
function initControl() {
	var formObj=document.form;
	sheetObjects[0].RemoveAll();
	formObj.vrfy_scs_flg.value="N";
	ComBtnDisable("btn_Save");
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
        
		      var HeadTitle="|Seq.|Lessor Chassis No.|OWN Chassis No.|Actual Chassis No.|Invoice Reference No.|Invoice No.|Charge Type|On-Hire Loc.|On-Hire Date|Billing Start Date|Off-Hire Loc.|Off-Hire Date|Billing End Date|Used Days|Rate|Total|Verify Status|||||"
		      + "|||||||||||||||||||||";
		      var headCount=ComCountHeadTitle(HeadTitle);
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0, FrozenCol:5 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                      Wrap:1 },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                         Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"inv_cust_eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"inv_eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"inv_ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_chg_tp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_eq_onh_loc_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_eq_onh_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"inv_bil_st_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_eq_offh_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_eq_offh_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"inv_bil_end_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_lse_use_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"inv_lse_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10,    Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_lse_chg_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10,    Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",             Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",                    Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",                 Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",                Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vrfy_scs_flg",                Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"inv_tax_amt",                 Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"inv_cr_amt",                  Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                      Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cost_cd",                     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",                     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_use_dys",                 Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_rt_amt",                  Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_chg_amt",                 Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_chg_aud_sts_cd",          Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_chg_aud_rslt_rsn_cd",     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_chg_sts_cd",              Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pay_lse_chg_sts_cd",          Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"inv_smry_amt",                Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cr_smry_amt",                 Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tax_smry_amt",                Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",              Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"aud_umch_eq_sts_evnt_yd_cd",  Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"aud_umch_eq_aset_sts_cd",     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"aud_umch_eq_sts_evnt_dt",     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                     Wrap:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"inv_seq",                     Wrap:1 } ];
		       
		      InitColumns(cols);
		      SetColProperty(0, "inv_no" , {AcceptKeys:"E|[0123456789,_-!@#$%^&*()>?./]"});
		      SetEditable(1);
		      SetSheetHeight(280);
		     // SetColProperty(0 ,"inv_no" , {AcceptKeys:"E|N|[,_-!@#$%^&*()>?./]"});
            }
		break;
	}
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg){
	if(isExceedMaxRow(msg))return;

//	if(result) {

		for(var i =1 ; i < sheetObjects[0].RowCount()+1 ; i++){
			sheetObjects[0].SetCellValue(i, "inv_no",sheetObjects[0].GetCellValue(i, "inv_no").toUpperCase());

			if(i == 1){
				var checkInvNo = CGMcheckInvoiceNo(sheetObjects[0],sheetObjects[0].GetCellValue(1, "inv_no"),document.form.vndr_seq.value,"","CHS");
				
				if(checkInvNo != null && checkInvNo != ""){
//					ComShowCodeMessage("CGM20039");
					sheetObjects[0].RemoveAll();
					break;
				}
			}
 		}
//	}

}


// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case MULTI01: // Verify
		// Dup Check
		// var duprows = sheetObj.ColValueDupRows("inv_eq_no|inv_no|chg_cd");
		// var arrDuprows = duprows.split(",")
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);	
		formObj.f_cmd.value=MULTI01;
		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
		// var sParam = sheetObjects[0].GetSaveString(true);
		var sParam=ComCgmGetAllSaveText(sheetObjects[0], true);
		sParam=sParam + "&";
		sParam=sParam + FormQueryString(formObj);
		var sXml=sheetObj.GetSaveData("EES_CGM_1030GS.do", sParam);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
 		ComOpenWait(false);	
		if (sheetObj.FindText("vrfy_scs_flg", 'N') == -1) {
			formObj.vrfy_scs_flg.value="Y";
			ComBtnEnable("btn_Save");
		} else {
			formObj.vrfy_scs_flg.value="N";
			ComBtnDisable("btn_Save");
		}
		break;
	case MULTI03: // Verify Insert=> Verify Search
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=MULTI03;
		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;

//		var sParam=ComCgmGetAllSaveText(sheetObjects[0], true);
		var sParam=sheetObj.GetSaveString(true);
		sParam=sParam + "&";
		sParam=sParam + FormQueryString(formObj);
		var sXml=sheetObj.GetSaveData("EES_CGM_1030GS.do", sParam);
		var insResult=ComCgmNullToBlank(ComGetEtcData(sXml, "ins_result"));
//		sheetObj.LoadSearchData(sXml,{Sync:1} );
		
		if (insResult == "SUCCESS") {
			formObj.f_cmd.value=MULTI04;
			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_CGM_1030GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:0} );
		}
		ComOpenWait(false);	
		break;
	case IBSAVE: //saving
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);	
		if (formObj.vrfy_scs_flg.value == 'Y') {
			// Save 
			formObj.f_cmd.value=MULTI02;
			formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
			 var sParam = sheetObjects[0].GetSaveString(true);
//			var sParam=ComCgmGetAllSaveText(sheetObjects[0], true);
			sParam=sParam + "&";
			sParam=sParam + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("EES_CGM_1030GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
		} else {
			ComShowCodeMessage('CGM10005');
		}
		ComBtnDisable("btn_Save");
		ComOpenWait(false);
		break;
	case IBINSERT: // inserting
		break;
	case IBSEARCH_ASYNC01: // Vendor Code,Name retrieve
		formObj.f_cmd.value=SEARCH07;
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj), '', true);
		var text=ComGetEtcData(sXml, "text");
		formObj.vndr_lgl_eng_nm.value=text;
		break;
	case IBLOADEXCEL: // EXCEL UPLOAD
		sheetObj.RemoveAll();
 		sheetObj.LoadExcel();
		break;
	case IBDOWNEXCEL: // EXCEL DOWNLOAD
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1});
			}

		break;
	}
}
/**
 * Sheet1 OnSaveEnd event handling <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {string} ErrMsg		 String
 * @return 
 * @version 2009.08.31
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '') {
		ComShowCodeMessage('CGM00003');
	}
}

function sheet1_OnSearchEnd(sheetObj, errMsg){
	var formObj = document.form;
	if (sheetObj.FindText("vrfy_scs_flg", 'N') == -1) {
		formObj.vrfy_scs_flg.value = "Y";
		ComBtnEnable("btn_Save");
	} else {
		formObj.vrfy_scs_flg.value = "N";
		ComBtnDisable("btn_Save");
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}
/* developer job end */
