/*=========================================================
 **Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0613.js
*@FileTitle  :   US Manifest Transmit(MI)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @extends
 * @class Customer Code Entry : Customer Code Entry - task script definition for screen
 */
// public variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// public variables .
var deleteRowIndex=-1;
var MISENT="";
var intervalId="";

var userAuthMiMultiStr = "";

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
    
	var sheetObject = sheetObjects[0];
	var sheetObject1= sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], document.form, REMOVE01);
			break;
		case "btn_downexcel":
			if(sheetObject.RowCount() < 1){//no data sheet
				ComShowCodeMessage("BKG00155");
				sheet1_OnDownFinish();
			}else{	
				sheetObject.Down2Excel({FileName : 'MI VVD', DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
			}
			break;
		case "btn_Add_BL":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
			break;
		case "btn_Edit_BL":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
			break;
		case "btn_Transmit":
		case "btn_Transmit_e":
			doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
			break;
		case "btn_OfmGeneration":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND04);
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
	
	// 화면 로딩 시에는 Transmit (Full) 버튼으로 초기화 
	ComSetDisplay("btn_Transmit", true);
	ComSetDisplay("btn_Transmit_e", false);
	
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	// Event needed for screen
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'chkChange2', document.form);
	form.vvd.focus();
	
	preAction = "";
	
}
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //sheet1 init
	    with(sheetObj){        
		      if (location.hostname != "")
//		      (16, 0, 0, true);
		      var HeadTitle="|VVD|POL|POD|ETA|FROB|Customs|SENT TIME|MI|CNTR COUNT|B/L COUNT|||||";
		      var prefix="sheet1_";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eta",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frob",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"customs",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sent_time",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"mi",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_count",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_count",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mbl_count01", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mbl_count02", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mbl_count03", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hbl_count",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_count",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
//		      SetWaitImageVisible(false);
		      SetSheetHeight(140);
		      SetEditable(0);
            }


		break;
	case 2: //sheet2 init
	    with(sheetObj){        
		      var HeadTitle1="|Seq.|B/L No.||POL|POD|||B/L|B/L|B/L|B/L|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|Booking Container|Booking Container|Container Manifest|Container Manifest|Container Manifest|Container Manifest|cgo_tp_cd";
		      var HeadTitle2="|Seq.|B/L No.||POL|POD|||DEL|FILER|PK|WT|NM|AD|NM|AD|NM|AD|Number|Seal|PK|WT|MK|DS|cgo_tp_cd";
		      var prefix="sheet2_";
		
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20} );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"row_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"dummy",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"transmit_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"full_mty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"filer",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shpr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shpr_ad",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnee_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnee_ad",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ntfy_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ntfy_ad",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seal",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_pk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_wt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_mk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_ds",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eta",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             	 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
//		      SetWaitImageVisible(false);
		      SetSheetHeight(310);
		      SetEditable(0);      
            }
		break;
	case 3: //sheet3 init
	    with(sheetObj){		       
		      var HeadTitle="|";
		      var prefix="sheet3_";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"flat_file",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];		       
		      InitColumns(cols);
		      SetSheetHeight(100);
		      SetEditable(0);
        	}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, row) {
	sheetObj.ShowDebugMsg(false);
	var pgmNo=formObj.pageNo.value;
	if (pgmNo == null || pgmNo == "")
		pageNo="ESM_BKG_0613";
	var blInqueryPgmNo="ESM_BKG_0034-01";
	if (pgmNo == "ESM_BKG_0613_2") {
		blInqueryPgmNo="ESM_BKG_0034-03";
	}
	switch (sAction) {
	case INIT:
		formObj.f_cmd.value=INIT;
		if ("sheet1" == sheetObj.id) {
			var sXml=sheetObj.GetSearchData("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			var userAuthStr=ComGetEtcData(sXml, "user_auth_str");
			userAuthMiMultiStr = ComGetEtcData(sXml, "user_auth_mi_multi_str");
			
			// alert("userAuthStr : " + userAuthStr);
			// OFM List Retrieve, Preparation button disabled setup
			if (userAuthStr == "Y") {
				ComBtnEnable("btn_OfmGeneration");
			} else {
				ComBtnDisable("btn_OfmGeneration");
			}
		}
		break;
	case SEARCH01: //retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value=SEARCH01;
		formObj.search_mtd.value="Summary";
		
		if ("sheet1" == sheetObj.id) {
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
			sheetObjects[1].RemoveAll();
			deleteRowIndex=-1;
			ComOpenWait(false);
		}
		formObj.totbl.value="";
		formObj.hbl01.value="";
		formObj.mbl01.value="";
		formObj.mbl02.value="";
		formObj.mbl03.value="";
		break;
	case SEARCH02: //retrieve
		var sheetObject2=sheetObjects[1];
		formObj.f_cmd.value=SEARCH01;
		formObj.search_mtd.value="Detail";
		var fEval=formObj.full_empty.value;
		var miVal=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_mi");
		var bdrVal=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_bdr_count");
		MISENT=miVal;
		/*
		 * 2010.8.06
		 * if retrieve is EMPTY, Transmit button activate
		 */
//		if (fEval == "E") {
//			ComBtnDisable("btn_Transmit");
//		} else {
		
		var host = document.location.host
			if (miVal == "Y") {
				if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
					ComBtnEnable("btn_Transmit");			// 개발
					ComBtnEnable("btn_Transmit_e");			// 개발
				}else{
					if (location.href.indexOf("alpsdev") > -1 ){
						ComBtnEnable("btn_Transmit");			// 개발
						ComBtnEnable("btn_Transmit_e");			// 개발
					}else{
						ComBtnDisable("btn_Transmit");			// 운영
						ComBtnDisable("btn_Transmit_e");		// 운영
					}
				}
			} else {
				if (pgmNo == "ESM_BKG_0613" && eval(bdrVal) > 0) {
					if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
						ComBtnEnable("btn_Transmit");				// 개발
						ComBtnEnable("btn_Transmit_e");				// 개발
					}else{
						if (location.href.indexOf("alpsdev") > -1 ){
							ComBtnEnable("btn_Transmit");			// 개발
							ComBtnEnable("btn_Transmit_e");			// 개발
						}else{
							ComBtnDisable("btn_Transmit");			// 운영
							ComBtnDisable("btn_Transmit_e");		// 운영
						}
					}					

				} else {
					ComBtnEnable("btn_Transmit");
					ComBtnEnable("btn_Transmit_e");
				}
			}
			
			if (userAuthMiMultiStr == "Y") {
				ComBtnEnable("btn_Transmit");
				ComBtnEnable("btn_Transmit_e");
			}
			
//		}
		// double click the value of a row form of the object after a temporary setup, FormQueryString finished writing the original default values.
		var temp_vvd=formObj.vvd.value;
		var temp_pol=formObj.pol.value;
		var temp_pod=formObj.pod.value;
		var temp_customs=formObj.customs.value;
		formObj.vvd.value=sheetObj.GetCellValue(row, "sheet1_vvd");
		formObj.pol.value=sheetObj.GetCellValue(row, "sheet1_pol");
		formObj.pod.value=sheetObj.GetCellValue(row, "sheet1_pod");
		formObj.customs.value=sheetObj.GetCellValue(row, "sheet1_customs");
		if ("sheet1" == sheetObj.id) {
//			ComOpenWait(true);
			sheetObject2.DoSearch("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
//			ComOpenWait(false);
		}
		formObj.vvd.value=temp_vvd;
		formObj.pol.value=temp_pol;
		formObj.pod.value=temp_pod;
		formObj.customs.value=temp_customs;
//		sheet2_total_setup(formObj, sheetObject2);
//		deleteRowIndex=-1;
		break;
	case REMOVE01: //delete Save
		var sheetObject2=sheetObjects[1];
		if (sheetObject2.GetSelectRow()== "-1") {
			ComShowMessage(ComGetMsg("BKG00249"));
			return;
		}
		if (!ComShowConfirm(ComGetMsg("BKG00535")))
			return;
		formObj.f_cmd.value=REMOVE01;
		//hideNchangeStatByD(sheetObject2, deleteRowIndex);
		hideNchangeStatByD(sheetObject2, sheetObject2.GetSelectRow());
		sheetObject2.DoSave("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
		break;
	case COMMAND01:
		formObj.f_cmd.value=MULTI01;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		// var sheetObject2 = sheetObjects[1];
		var sParam=ComGetSaveString(sheetObj) + "&f_cmd=" + MULTI01 + "&" + ComGetPrefixParam("sheet2_");
		sheetObjects[1].SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSaveData("ESM_BKG_0613GS.do", sParam);
		var key=ComGetEtcData(sXml, "KEY");
		sheetObjects[0].SetWaitImageVisible(0);
		ComOpenWait(true);
		intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		break;
	case IBINSERT: //input
		break;
	case COMMAND02: //add Bl
		formObj.f_cmd.value='';
		formObj.pagerows.value='';
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		//var sheet1SetSelectRow(sheetObject1.GetSelectRow());
		//var sheet2SetSelectRow(sheetObject2.GetSelectRow());
		var vvd="";
		var eta="";
		var pod="";
		if(sheet2.GetSelectRow()!= -1) {
			vvd=sheetObject2.GetCellValue(sheet2.GetSelectRow(), "sheet2_vvd");
			eta=sheetObject2.GetCellValue(sheet2.GetSelectRow(), "sheet2_eta");
			pod=sheetObject2.GetCellValue(sheet2.GetSelectRow(), "sheet2_pod");
		} else {
			if(sheet1.GetSelectRow()!= -1) {
				vvd=sheetObject1.GetCellValue(sheet1.GetSelectRow(), "sheet1_vvd");
				eta=sheetObject1.GetCellValue(sheet1.GetSelectRow(), "sheet1_eta");
				pod=sheetObject1.GetCellValue(sheet1.GetSelectRow(), "sheet1_pod");
			}
		}
		var param="vvd=" + vvd + "&eta=" + eta + "&pod=" + pod;
		//alert("param : " + param);
		ComOpenWindowCenter("ESM_BKG_0034_POP.do?pgmNo=" + blInqueryPgmNo + "&" + param, "ESM_BKG_0034", 1250, 700, false);
		break;
	case COMMAND03: //edit Bl
		formObj.f_cmd.value='';
		formObj.pagerows.value='';
		var sheetObject2=sheetObjects[1];
		if (sheetObject2.GetSelectRow()== -1) {
			ComShowMessage(ComGetMsg("BKG01002"));
			return;
		}
		var bl_no=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "sheet2_bl_no");
		var param="bl_no=" + bl_no;
		ComOpenWindowCenter("ESM_BKG_0034_POP.do?pgmNo=" + blInqueryPgmNo + "&" + param, "ESM_BKG_0034", 1250, 700, false);
		break;
	// OFM Generation
	case COMMAND04:
		formObj.f_cmd.value=MULTI02;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		var sheetObject2=sheetObjects[1];
		ComOpenWait(true);
		var sParam=ComGetSaveString(sheetObject2) + "&f_cmd=" + MULTI02 + "&" + ComGetPrefixParam("sheet2_");
		var sXml=sheetObject2.GetSaveData("ESM_BKG_0613GS.do", sParam);
		sheetObjects[2].LoadSaveData(sXml);
		if (sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
			//formObj.output.value = sheetObjects[2].EtcData("flatFile");	// OFM Generation 수행시 생성된 flatfile을 보기 위해사용
			ComShowCodeMessage('BKG06071');
		}
		ComOpenWait(false);
		break;
	}
}
/**
 * BackEndJob result retrieve.
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml=sheetObj.GetSearchData("ESM_BKG_0613GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// If an error occurred , exit 
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowCodeMessage('BKG06070');
		// sheet1, sheet2  retrieve again
		sheetObjects[0].SetWaitImageVisible(1);

		
		preAction = COMMAND01;
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);

		return;
	} else if (sJbStsFlg == "FAIL") {
		//error
		clearInterval(intervalId);
		ComOpenWait(false);
		sheetObjects[0].SetWaitImageVisible(1);
		ComShowMessage(ComResultMessage(sXml));
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheetObject1=sheetObjects[1];
	switch (sAction) {
	case SEARCH01:
		if (!ComChkValid(formObj))
			return false;
		if (formObj.pageNo.value == "ESM_BKG_0613_2") {
			if (formObj.pod.value == "" && formObj.customs.value == "") {
				ComShowMessage(ComGetMsg("BKG01030"));
//				formObj.pod.focus();
				return false;
			}
		}
		break;
	case COMMAND01:
		if (sheetObject1.RowCount()== 0) {
			//BKG00396,There is no data to transmit.
			ComShowCodeMessage('BKG00396');
			return false;
		}	

		var formObj = document.form; //재확인을 위한 절차

		if(formObj.pagedbclick.value=="Y"){
			if (!ComShowConfirm(ComGetMsg("BKG01054"))){
				return false;
			}
		}
			
		var fullItemCnt=0;
		var errorItemCnt=0;
		
		if (sheetObject1.GetCellValue(j, "sheet2_full_mty_cd") == "F") { // Transmit(Full) 
			for ( var j=2; j < sheetObject1.RowCount()+ 2; j++) {
				if (sheetObject1.GetCellValue(j, "sheet2_del") == "N" || sheetObject1.GetCellValue(j, "sheet2_filer") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_pk") == "N" || sheetObject1.GetCellValue(j, "sheet2_wt") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_shpr_nm") == "N" || sheetObject1.GetCellValue(j, "sheet2_shpr_ad") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_cnee_nm") == "N" || sheetObject1.GetCellValue(j, "sheet2_cnee_ad") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_ntfy_nm") == "N" || sheetObject1.GetCellValue(j, "sheet2_ntfy_ad") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_cntr_no") == "N" || sheetObject1.GetCellValue(j, "sheet2_seal") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_cntr_pk") == "N" || sheetObject1.GetCellValue(j, "sheet2_cntr_wt") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_cntr_mk") == "N" || sheetObject1.GetCellValue(j, "sheet2_cntr_ds") == "N") {
					
					errorItemCnt++;				
				}			
				fullItemCnt++;
			}
			if (fullItemCnt == 0) {
				if (!ComShowConfirm(ComGetMsg("BKG01032")))
					return false;
			}
		} else { // Transmit(Empty)
			for ( var j=2; j < sheetObject1.RowCount()+ 2; j++) {
				if (sheetObject1.GetCellValue(j, "sheet2_del") == "N" || sheetObject1.GetCellValue(j, "sheet2_filer") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_shpr_nm") == "N" || sheetObject1.GetCellValue(j, "sheet2_shpr_ad") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_cnee_nm") == "N" || sheetObject1.GetCellValue(j, "sheet2_cnee_ad") == "N"
					|| sheetObject1.GetCellValue(j, "sheet2_ntfy_nm") == "N" || sheetObject1.GetCellValue(j, "sheet2_ntfy_ad") == "N"){
					
					errorItemCnt++;				
				}			
			}
		}

		if (errorItemCnt > 0) {
			if (!ComShowConfirm(ComGetMsg("BKG01033")))
				return false;
		}
		
		if(errorItemCnt == 0 && formObj.pagedbclick.value!="Y") {
			if (!ComShowConfirm(ComGetMsg("BKG00447")))
	            return false;
		}

		return true;
		break;
	case COMMAND04:
		if (sheetObject1.RowCount()== 0) {
			//BKG01066,There is no data for OFM Generation.
			ComShowCodeMessage('BKG01066');
			return false;
		}
		if (MISENT == "N") {
			return true;
		} else if (MISENT == "") {
			return true;
		}
	}
	return true;
}
/**
 * 
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(SheetObj, Row, Col) {
	var sheetObject1=sheetObjects[0];
	doActionIBSheet(sheetObject1,document.form,SEARCH02, Row);
}
 /**
  * 
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */
function sheet2_OnClick(sheetObj,Row, Col, Value){
	deleteRowIndex=Row;
}
/**
 * 
 * @param sheetObj
 * @param Row
 * @return
 */
function hideNchangeStatByD(sheetObj,Row){
//	sheetObj.SetRenderSheetSum(0);
	sheetObj.SetRowHidden(Row,1);
	sheetObj.SetRowStatus(Row,"D");
//	sheetObj.SetRenderSheetSum(1);
}
/**
 * 
 * @param formObj
 * @param sheetObj
 * @return
 */
function sheet2_total_setup(formObj, sheetObj){
	var hbl01=0;
	var mbl01=0;
	var mbl02=0;
	var mbl03=0;
	var prefix="sheet2_";
	var pre_row="";
	for(var i = 2; i < sheetObj.RowCount() + 2; i++){
		var row_seq=sheetObj.GetCellValue(i, prefix + "row_seq");
		if(row_seq != pre_row){
			var filerVal=sheetObj.GetCellValue(i, prefix + "filer");
			if(filerVal == " " ){
				hbl01++;
			}
			if(filerVal == "1" ){
				mbl01++;
			}
			if(filerVal == "2" ){
				mbl02++;
			}
			if(filerVal == "3" ){
				mbl03++;
			}
		}
		pre_row=row_seq;
	}
	formObj.totbl.value=sheetObj.GetCellValue(sheetObj.LastRow(), prefix + "row_seq");
	formObj.hbl01.value=hbl01;
	formObj.mbl01.value=mbl01;
	formObj.mbl02.value=mbl02;
	formObj.mbl03.value=mbl03;
}
/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (document.form.f_cmd.value == REMOVE01) {
			doActionIBSheet(sheetObjects[0], document.form, SEARCH02, sheetObjects[0].GetSelectRow());
		} 
	}
}

/**
* After retrieve event
* @param sheetObj
* @param ErrMsg
* @return
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var selRow = 0;
	var prefix="sheet2_";
	if (ErrMsg == "") {					
		selRow = sheetObjects[0].GetSelectRow();
		if(selRow > 0 ) {
			doActionIBSheet(sheetObjects[0], formObj, SEARCH02, selRow);
		}
	}
}

/**
* After retrieve event
* @param sheetObj
* @param ErrMsg
* @return
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	sheet2_total_setup(formObj, sheetObj);
	deleteRowIndex=-1;
	var prefix="sheet2_";
	if (ErrMsg == "") {					
		for(var j=2; j < sheetObj.RowCount()+2 ; j++){
			if(sheetObj.GetCellValue(j, prefix+"del") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"del","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"filer") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"filer","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"pk") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"pk","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"wt") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"wt","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"shpr_nm") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"shpr_nm","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"shpr_ad") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"shpr_ad","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cnee_nm") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cnee_nm","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cnee_ad") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cnee_ad","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"ntfy_nm") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"ntfy_nm","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"ntfy_ad") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"ntfy_ad","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cntr_no") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cntr_no","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"seal") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"seal","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cntr_pk") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cntr_pk","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cntr_wt") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cntr_wt","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cntr_mk") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cntr_mk","#FF0000");
						}
			if(sheetObj.GetCellValue(j, prefix+"cntr_ds") == "N"){
				sheetObj.SetCellFontColor(j, prefix+"cntr_ds","#FF0000");
			}
			
			// cgo_tp_cd 셋팅
			sheetObj.SetCellValue(j, prefix+"cgo_tp_cd",formObj.full_empty.value,0);

		}
		var sheetObject1=sheetObjects[0];
		var nowRow=sheetObject1.GetSelectRow();
		var prefix="sheet1_";
		// MI 전송 여부 flag 값
		if(sheetObject1.GetCellValue(nowRow,prefix+"mi")=="Y"){
			formObj.pagedbclick.value = "Y";
		}else{
			formObj.pagedbclick.value = "";
		}
		
	}
}
/**
 * change event occurs, VVD, POL field if subject, Actual Filing VVD Undo
 * @return
 */
function chkChange2(){
	 var srcName=ComGetEvent("name");
	 var formObj=document.form;
	 if(srcName == "pol"){
		 if(document.form.vvd.value.length == 9 && document.form.pol.value.length == 5 ){
			 if(document.form.vvd.value.substring(8, 9) == "W" && document.form.pol.value.substring(0, 2) == "CA"
				 	// && document.form.pod.value.substring(0, 2) != "CA" && document.form.pod.value.substring(0, 2) != "US"
			 	)
			 { 
//				 form.actualvvd.value = document.form.vvd.value.substring(0, 8) + "E";
                 formObj.f_cmd.value=COMMAND01;
                 var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0613GS.do", FormQueryString(formObj));
                 formObj.actualvvd.value=ComGetEtcData(sXml, "ACT_VVD");
			 }
			 else
			 {
				 form.actualvvd.value="";
			 }
		 }else{
			 form.actualvvd.value="";
			 if(srcName == "vvd" && document.form.vvd.value.length > 0 && document.form.vvd.value.length != 9){
				 ComShowCodeMessage('BKG00007'); // VVD is not available !
				 return;
			 }
			 if(srcName == "pol" && document.form.pol.value.length > 0 && document.form.pol.value.length != 5){
				 ComShowCodeMessage('BKG00288'); // POL is not available
				 return;
			 }
			 if(srcName == "vvd" && document.form.pol.value == ""){
//				 document.form.pol.focus();
			}
		}
	}
	 
		if(srcName == "full_empty"){
			if(formObj.full_empty.value == "F"){
				ComSetDisplay("btn_Transmit", true);
				ComSetDisplay("btn_Transmit_e", false);
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.hbl01.value = "";
				formObj.mbl01.value = "";
				formObj.mbl02.value = "";
				formObj.mbl03.value = "";
				formObj.totbl.value = "";
//				formObj.total.reset();
			}else{
				ComSetDisplay("btn_Transmit", false);
				ComSetDisplay("btn_Transmit_e", true);
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.hbl01.value = "";
				formObj.mbl01.value = "";
				formObj.mbl02.value = "";
				formObj.mbl03.value = "";
				formObj.totbl.value = "";
//				formObj.total.reset();
			}
		}	
}

function sheet1_OnDownFinish(downloadType, result) {
	if(sheet2.RowCount() < 1 ){//no data sheet1	
		ComShowCodeMessage("BKG00155");
	}else{	
		sheet2.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel2.jsp");
		sheet2.Down2Excel({FileName : 'MI BL LIST', DownCols: makeHiddenSkipCol(sheet2), SheetDesign:1,Merge:1 });
	}
}