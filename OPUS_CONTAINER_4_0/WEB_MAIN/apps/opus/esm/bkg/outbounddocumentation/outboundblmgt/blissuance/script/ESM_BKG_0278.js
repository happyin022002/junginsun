/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0278.js
 *@FileTitle : Group & Multi B/L Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
 * @author CLT
 */

// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var queryStr="";
var prefix1="t1sheet1_";
var prefix2="t2sheet1_";
var prefix3="t2sheet2";
var iterator="|$$|";
var multiSeparator="|";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		// bl_sheet
		if (srcName != "tb1_btn_input_bl_no") {
			if (srcName != "input_bl_no") {
				setBlNo(sheetObject1, 3);
				// alert("go");
			}
		}
		switch (srcName) {
		/** tab [ esm_bkg_0278 ] (S) **/
		case "tb1_btn_Retrieve":
			Retrive(srcName);
			break;
		case "tb1_btn_New": // btn_New
			pageReset(sheetObject1, formObject);
			break;
		case "tb1_btn_calendar": // B/L Release (Issue) Date
			var cal=new ComCalendarFromTo();
			cal.select(formObject.obl_iss_from_dt, formObject.obl_iss_to_dt, 'yyyy-MM-dd');
			break;
		case "tb1_btn_rep_cmdt_cd": // Rep. Commodity
			Pop_COM_ENS_011(formObject);
			break;
		case "tb1_btn_cmdt_cd": // Commodity
			Pop_COM_ENS_011(formObject);
			break;
		case "tb1_btn_sc_rfa_no": // S/C / RFA
			// S/C - UI_BKG-0655 | RFA - UI_BKG-0654
			Pop_ESM_BKG_06545(formObject);
			break;
		case "tb1_btn_cust_cd": // Customer KR
			Pop_COM_ENS_041(formObject);
			break;
		case "tb1_btn_input_bl_no": // B/L No.
			if (document.getElementById("bl_input").style.display == "block") {
				setBlNo(sheetObject1, 1);
			} else {
				setBlNo(sheetObject1, 2);
			}
			break;
		case "bkg_sts_cd_w": // W-Waiting
			if (formObject.bkg_sts_cd_w.checked) {
				formObject.bkg_rsn_spcl_cgo_flg.disabled=false;
				formObject.wt_rsn_hld_flg.disabled=false;
			} else {
				formObject.bkg_rsn_spcl_cgo_flg.disabled=true;
				formObject.wt_rsn_hld_flg.disabled=true;
				formObject.bkg_rsn_spcl_cgo_flg.checked=false;
				formObject.wt_rsn_hld_flg.checked=false;
			}
			break;
		case "eq_por_cd": // EQ Control Office
			if (formObject.eq_por_cd.checked) {
				formObject.eq_del_cd.checked=false;
			}
			break;
		case "eq_del_cd": // EQ Control Office
			if (formObject.eq_del_cd.checked) {
				formObject.eq_por_cd.checked=false;
			}
			break;
		/** tab [ esm_bkg_0278 ] (E) * */
		/** tab [ esm_bkg_0280 ] (S) * */
		case "tb2_btn_Sort": // btn_Sort
			Pop_ESM_BKG_0161(formObject);
			break;
		case "tb2_btn_CheckAll":
			sheetObject2.CheckAll(prefix2 + "Check",1,1);
			break;
		case "tb2_btn_UncheckAll":
			sheetObject2.CheckAll(prefix2 + "Check",0,1);
			break;
		case "tb2_btn_Retrieve":
			doActionIBSheet(sheetObject2, formObject, IBSEARCH);
			break;
		case "tb2_btn_EIR":
			RdPrint(sheetObject2, "HKG");
			break;
		case "tb2_btn_dovn":
			var param=bkgNos="";
			var arrRow=ComFindText(sheetObject2, prefix2 + "Check", 1);
			if (arrRow && 0 < arrRow.length) {
				for ( var i=0; i < arrRow.length; i++) {
					bkgNos += sheetObject2.GetCellValue(arrRow[i], prefix2
							+ "bkg_no")
							+ ",";
				}
				if (0 < bkgNos.indexOf(","))
					bkgNos=bkgNos.substring(0, bkgNos.length - 1);
				if (500 < bkgNos.split(",").length) {
					ComShowCodeMessage("BKG08124", 500); // You select more
															// than {?msg1} B/Ls
															// for B/L print.
															// Max is {?msg1}
															// B/Ls one time
					return;
				}
			} else {
				ComShowCodeMessage("COM12176");
				return false;
			}
			var formObject2=document.form2;
			param="?bkg_no=" + bkgNos+"&form_manifest=V";
//			ComOpenWindowCenter("/opuscntr/ESM_BKG_0743_01.do" + param,
//					"PopupEsmBkg074301", 925, 370, false);
			var width=925;
			var height=370;
			var left=(screen.width-width)/2;
			var top=(screen.height-height)/2;
			ComOpenWindow("", "PopupEsmBkg074301", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
			formObject2.bkg_no.value=bkgNos;
			formObject2.action="/opuscntr/ESM_BKG_0743_01.do";
			formObject2.target="PopupEsmBkg074301";
			formObject2.param= "&form_manifest=V";
			formObject2.submit();
			break;
/*
				var bkgNos="";
				for (var i=0; i<arrRow.length; i++) {
bkgNos += "'"+sheetObject2.GetCellValue(arrRow[i],prefix2+"bkg_no")+"',";
				}
				bkgNos=bkgNos.substring(0,bkgNos.lastIndexOf(","));
				rdParam=" /rv";
				rdParam += " form_bkgNo[("+bkgNos+")]";
				rdParam += " form_type[2]";
				rdParam += " form_dataOnly[N]";
				rdParam += " form_manifest[V]";
				rdParam += " form_usrId["+formObject.strUsr_id.value+"]";
				rdParam += " form_hiddeData[N]";
				rdParam += " form_level[(6)]";
				rdParam += " form_remark[]";
				rdParam += " form_Cntr[1]";
				rdParam += " form_mainOnly[N]";
				rdParam += " form_CorrNo[]";
				rdParam += " form_his_cntr[BKG_CONTAINER]";
				rdParam += " form_his_bkg[BKG_BOOKING]";
				rdParam += " form_his_mkd[BKG_BL_MK_DESC]";
				rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]";
				rdParam += " form_his_bl[BKG_BL_DOC]";
				rdParam += " /rp [] /riprnmargin /rwait";
				formObject.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
				formObject.com_mrdArguments.value=rdParam;
				formObject.com_mrdBodyTitle.value="OPUS Shipping Draft B/L Copies";
				formObject.com_mrdTitle.value="OPUS Shipping Draft B/L Copies";
formObject.com_mrdSaveDialogFileName.value=sheetObject2.GetCellValue(arrRow[0],prefix2+"bkg_no");
				ComOpenRDPopup("resizable=yes, width=900, height=800");
*/
		case "tb2_btn_Manifest":
			if (0==sheetObject2.RowCount()) {
				ComShowCodeMessage("BKG00155");
				return false;
			}
			if (0==sheetObject2.CheckedRows(prefix2+"Check")) {
				ComShowCodeMessage("BKG00155");
				return false;
			}
			if (50<sheetObject2.CheckedRows(prefix2+"Check")) {
				ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
				return false;
			}
			var arrRow=ComFindText(sheetObject2, prefix2+"Check", 1);
			if (arrRow && 0<arrRow.length && 50>=arrRow.length) {
				var bkgNos="";
				for (var i=0; i<arrRow.length; i++) {
					bkgNos += "'"+sheetObject2.GetCellValue(arrRow[i],prefix2+"bkg_no")+"',";
				}
				bkgNos=bkgNos.substring(0,bkgNos.lastIndexOf(","));
				rdParam=" /rv";
				rdParam += " form_bkgNo[("+bkgNos+")]";
				rdParam += " form_type[2]";
				rdParam += " form_dataOnly[N]";
				rdParam += " form_manifest[X]";
				rdParam += " form_usrId["+formObject.strUsr_id.value+"]";
				rdParam += " form_hiddeData[N]";
				rdParam += " form_level[(6)]";
				rdParam += " form_remark[]";
				rdParam += " form_Cntr[1]";
				rdParam += " form_mainOnly[N]";
				rdParam += " form_CorrNo[]";
				rdParam += " form_his_cntr[BKG_CONTAINER]";
				rdParam += " form_his_bkg[BKG_BOOKING]";
				rdParam += " form_his_mkd[BKG_BL_MK_DESC]";
				rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]";
				rdParam += " form_his_bl[BKG_BL_DOC]";
				rdParam += " form_rqst_via_cd[]";
				rdParam += " form_his_bl_mkd[BKG_BL_ISS]";
				rdParam += " form_path[" + getFileDownPath() + "]";
				rdParam += " form_esig[]";
				rdParam += " form_cpy_esig[]";
				rdParam += " form_knt_flg[]";
				rdParam += " form_count[]";
				rdParam += " /rp [] /riprnmargin /rwait";
				formObject.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
				if (0==formObject.booking_por_cd.value.indexOf("US")) {
					formObject.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
				}
				formObject.com_mrdArguments.value=rdParam;
				formObject.com_mrdBodyTitle.value="Draft B/L Copies";
				formObject.com_mrdTitle.value="Draft B/L Copies";
				formObject.com_mrdSaveDialogFileName.value=sheetObject2.GetCellValue(arrRow[0],prefix2+"bkg_no");
				ComOpenRDPopup("resizable=yes, width=900, height=800");
			}
			break;
		case "tb2_btn_BLPreview":
			var bkgNos="";
			var arrRow=ComFindText(sheetObject2, prefix2 + "Check", 1);
			if (arrRow && 0 < arrRow.length) {
				for ( var i=0; i < arrRow.length; i++) {
					bkgNos += sheetObject2.GetCellValue(arrRow[i], prefix2
							+ "bkg_no")
							+ ",";
				}
				if (0 < bkgNos.indexOf(","))
					bkgNos=bkgNos.substring(0, bkgNos.length - 1);
				if (1 < bkgNos.split(",").length) {
					ComShowCodeMessage("BKG01002"); // Please select one B/L No
					return;
				}
			} else {
				ComShowCodeMessage("COM12176"); // Please select one at least.
				return false;
			}
			comBkgCallPop0927(sheetObject2.GetCellValue(arrRow[0], prefix2
					+ "bkg_no"), sheetObject2.GetCellValue(arrRow[0], prefix2
					+ "bl_no"));
			break;
		case "tb2_btn_BLPrint":
			var param=bkgNos="";
			var arrRow=ComFindText(sheetObject2, prefix2 + "Check", 1);
			if (arrRow && 0 < arrRow.length) {
				for ( var i=0; i < arrRow.length; i++) {
					bkgNos += sheetObject2.GetCellValue(arrRow[i], prefix2
							+ "bkg_no")
							+ ",";
				}
				if (0 < bkgNos.indexOf(","))
					bkgNos=bkgNos.substring(0, bkgNos.length - 1);
				if (500 < bkgNos.split(",").length) {
					ComShowCodeMessage("BKG08124", 500); // You select more
															// than {?msg1} B/Ls
															// for B/L print.
															// Max is {?msg1}
															// B/Ls one time
					return;
				}
			} else {
				ComShowCodeMessage("COM12176");
				return false;
			}
			var formObject2=document.form2;
			var width=925;
			var height=370;
			var left=(screen.width-width)/2;
			var top=(screen.height-height)/2;
//			ComOpenWindow("", "PopupEsmBkg074301", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no",false);
			callPostPop074301(formObject2, bkgNos, "/opuscntr/ESM_BKG_0743_01.do", "PopupEsmBkg074301", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no" );
//			formObject2.bkg_no.value=bkgNos;
//			formObject2.action="/opuscntr/ESM_BKG_0743_01.do";
//			formObject2.target="PopupEsmBkg074301";
//			formObject2.submit();
			break;
		case "tb2_btn_Back":
			tabObjects[0].SetSelectedIndex(0);
			break;
		case "tb2_btn_DownExcel":
			doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
			break;
		case "tb2_btn_Test0927":
			var bkg_no=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), prefix2
					+ "bkg_no");
			// var bkg_no = "";
			// var bl_no = sheetObject2.CellValue(sheetObject2.SelectRow,
			// prefix2 + "bl_no");
			var bl_no="";
			bl_no=(bl_no.length != 0 && bl_no.length > 12) ? bl_no.substring(
					0, 12) : bl_no;
			var bl_tp_cd="";
			var param="bkg_no=" + bkg_no + "&bl_no=" + bl_no + "&bl_tp_cd="
					+ bl_tp_cd + "&email=bateau75@naver.com";
			// alert("param : [" + param + "]");
			// ComOpenWindow("/opuscntr/ESM_BKG_0927.do?" + param,
			// "PopupEsmBkg0927", "dialogWidth:916px; dialogHeight:768px",
			// true);
			ComOpenWindow("/opuscntr/ESM_BKG_0927.do?" + param,
					"PopupEsmBkg0927", "width=916, height=768, scrollbars=no",
					false);
			break;
			case "vvd_pol_local":
					if(formObject.vvd_pol_local.checked){
						formObject.vvd_pol_ts.checked=false;
					}
					break; 		
			case "vvd_pol_ts":
					if(formObject.vvd_pol_ts.checked){
						formObject.vvd_pol_local.checked=false;
					}
					break; 										
			case "vvd_pod_local":
					if(formObject.vvd_pod_local.checked){
						formObject.vvd_pod_ts.checked=false;
					}
					break; 		
			case "vvd_pod_ts":
					if(formObject.vvd_pod_ts.checked){
						formObject.vvd_pod_local.checked=false;
					}
					break; 	
		/** tab [ esm_bkg_0280 ] (E) * */
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			//ComShowMessage(OBJECT_ERROR);
			alert(e.description);
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
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initSheetInsert();
	initCombo();
	init_Control();
	// checkHtml5RDPass
	
}
function initSheetInsert(){
	var formObject=document.form;
	// generates row 50
	// input_bl_no.value 
	// Remove title
	t1sheet1.RenderSheet(0);
	for ( var i=1; i <= 50; i++) {
		//
		t1sheet1.DataInsert(-1);
		t1sheet1.SetCellValue(i, prefix1 + "ibflag","R");
	}
	t1sheet1.SetCellValue(1, prefix1 + "bl_no",formObject.input_bl_no.value,0);
	t1sheet1.SelectCell(1, prefix1 + "bl_no");
	t1sheet1.SetRowHidden(0,1);
	t1sheet1.RenderSheet(1);
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
	case "t1sheet1":
	    with(sheetObj){

	      var HeadTitle1=" |bl_no|bl_combo";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix1+"ibflag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix1+"bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix1+"bl_combo", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetSheetHeight(150);
	    }
	    
		
		break;
	case "t2sheet1": //t2sheet1
	    with(sheetObj){
        
      var HeadTitle1="Sel.|Seq.|B/L No.|Booking Route|Booking Route|Booking Route|Booking Route|R/D Term|R/D Term|Relay Port|Relay Port|Commodity |Commodity |Special Cargo|Special Cargo|Special Cargo|Special Cargo|A/S|ST|BDR|CA|S/O|EQ Control Office|EQ Control Office|Contract|AES|CAED|Manifest|Rating|Consignee|Shipper|OB/L|OB/L|OB/L||||||";
      var HeadTitle2="Sel.|Seq.|B/L No.|POR|POL|POD|DEL|R|D|POL|POD|Rep|Commodity|D|R|A|B|A/S|ST|BDR|CA|S/O|POR|DEL|Contract|AES|CAED|Manifest|Rating|Consignee|Shipper|Issue|Print|Release||||||";
      var headCount=ComCountHeadTitle(HeadTitle1);

      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"Check" },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"por",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pol",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pod",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"del",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"r_term",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"d_term",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rly_pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rly_pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rep",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"commodity",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"d_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"r_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"a_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"b_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"a_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"st",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"bdr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"ca",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"twn_so_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"por_eq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"del_eq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"sc_rfa_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"aes",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"caed",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"manifest",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rate",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"consignee",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"shipper",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"obl_iss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"obl_prn_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"obl_rlse_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix2+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_bkg_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_act_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_meas_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"order_col",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"blank",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
       
      InitColumns(cols);

      SetMergeCell(0, 0, 2, 1);
      SetAutoRowHeight(0);
      SetSheetHeight(420);
      }
		break;
		case "t2sheet2": //t3sheet1
		    with(sheetObj){
	        
	      var HeadTitle1="Sel.|Seq.|B/L No.|Booking Route|Booking Route|Booking Route|Booking Route|R/D Term|R/D Term|Relay Port|Relay Port|Commodity |Commodity |Special Cargo|Special Cargo|Special Cargo|Special Cargo|A/S|ST|BDR|CA|S/O|EQ Control Office|EQ Control Office|Contract|AES|CAED|Manifest|Rating|Consignee|Shipper|OB/L|OB/L|OB/L||||||";
	      var HeadTitle2="Sel.|Seq.|B/L No.|POR|POL|POD|DEL|R|D|POL|POD|Rep|Commodity|D|R|A|B|A/S|ST|BDR|CA|S/O|POR|DEL|Contract|AES|CAED|Manifest|Rating|Consignee|Shipper|Issue|Print|Release||||||";
	      var headCount=ComCountHeadTitle(HeadTitle1);

	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );

	      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"Check" },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix3+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"por",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"pol",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"pod",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"del",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"r_term",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"d_term",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"rly_pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"rly_pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"rep",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"commodity",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"d_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"r_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"a_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"b_sc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"a_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"st",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"bdr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"ca",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"twn_so_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"por_eq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"del_eq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"sc_rfa_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"aes",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"caed",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"manifest",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"rate",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix3+"consignee",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix3+"shipper",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"obl_iss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"obl_prn_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"obl_rlse_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix3+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"bl_bkg_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"bl_act_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"bl_meas_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"order_col",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"blank",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
	       
	      InitColumns(cols);

	      SetMergeCell(0, 0, 2, 1);
	      SetAutoRowHeight(0);
	      SetSheetHeight(420);
	      SetVisible(0);
	      }

		break;
	}
}
 var arrSXml ;
// Sheet handling process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //Retrieve
		formObj.f_cmd.value=SEARCH;
		// sheetObj.DoSearch4Post("ESM_BKG_0280GS.do",FormQueryString(formObj) +
		// "&" + ComGetPrefixParam(prefix2));
		//sheetObj.DoSearch4Post("ESM_BKG_0278_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2));
		// GetSearchXml / LoadSearchXml 
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0278_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2));
		arrSXml=sXml.split(iterator);
		sheetObj.LoadSearchData(arrSXml[0],{Sync:1} );
		break;
	case IBDOWNEXCEL: // Excel download
//		sheetObj.WaitImageVisible=false;
		// sheetObj.SpeedDown2Excel(-1);
//		var formObj = document.form;
//
//		var sqlOrder = formObj.query_sort.value.split("|");
//
//		var sqlShowSubSumCol = sqlOrder[0].toLowerCase();
//
//		var sRow = "";
//		/*
//		 * for (var i=0; i < sheetObj.HeaderRows; i++) { // sRow += i+"|"; }
//		 */
//		sRow += sheetObj.FindSubSumRow(prefix2 + sqlShowSubSumCol);
//
//		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "",
//				false, "", sRow, false);
//		sheetObj.Copy2SheetCol(sheetObjects[2],"","",-1,-1,-1,1,false,false);
		/* editing the XML that is converted from sheet without copying it and saving  */
//		if(sheetObjects[2].RowCount()<= 0){
//			ComShowCodeMessage("BKG00395")
//			return false;
//		}
		
		sheetObjects[2].LoadSearchData(ComReplaceStr(arrSXml[0],{Sync:0} ));
		
		break;
	}
}
function init_Control() {
	//Axon event handling 1
	axon_event.addListenerForm("blur", "obj_blur", form); 
	axon_event.addListenerFormat("focus", "obj_focus", form);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", form); 
	axon_event.addListenerForm("keydown", "obj_keydown", form);
	axon_event.addListener("keydown", "sheet_keydown", "mainTable2");
	axon_event.addListener("keyup", "sheet_keyup", "mainTable2");
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
}
function obj_change() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "cmdt_cd" && srcValue == "") {
		formObject.cmdt_nm.value="";
	}
}
//Axon event handling 2
function obj_blur() {
	switch (event.srcElement.name) {
	case "obl_iss_from_dt":
		event.srcElement.value=ComGetMaskedValue(event.srcElement, "ymd");
		break;
	case "obl_iss_to_dt":
		event.srcElement.value=ComGetMaskedValue(event.srcElement, "ymd");
		break;
	default:
		if (event.srcElement.name == "cust_seq") {
			event.srcElement.value=ComReplaceStr(event.srcElement.value, ",",
					"");
		} else {
			//ComChkObjValid(event.srcElement);
		}
	}
}
function obj_focus() {
	ComClearSeparator(event.srcElement);
}
function obj_keydown() {
	var formObject=document.form;
	var obj=event.srcElement;
	if (event.keyCode == 13) { // Enter Key
		//
		switch(ComGetEvent("name")) {
		// Multi combo Enter Key Event handling
		/*
		 * case "rep_cmdt_cd": // Rep. Commodity //obj.blur();
		 * Pop_COM_ENS_011(formObject); break; case "cmdt_cd": // Commodity
		 * //obj.blur(); Pop_COM_ENS_011(formObject); break; case "cmdt_nm": //
		 * Commodity //obj.blur(); Pop_COM_ENS_011(formObject); break; case
		 * "sc_rfa_no": // S/C RFA //obj.blur(); Pop_ESM_BKG_06545(formObject);
		 * break; case "cust_cnt_cd": // Customer //obj.blur();
		 * Pop_COM_ENS_041(formObject); break; case "cust_seq": // Customer
		 * //obj.blur(); Pop_COM_ENS_041(formObject); break; case "cust_nm": //
		 * Customer //obj.blur(); Pop_COM_ENS_041(formObject); break;
		 */
		default:
			Retrive(obj.name);
		}
	}
}
/**
 * Register as array  to IBTab Object
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Search", "");
			InsertItem( "Result", "");
		}
		break;
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	// --------------- Importance --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab=nItem;
	if(nItem==0){
		ComShowObject(document.form.tb1_btn_Retrieve,  true);
		ComShowObject(document.form.tb1_btn_New,  true);
		ComShowObject(document.form.tb2_btn_DownExcel,  false);
		ComShowObject(document.form.tb2_btn_Back,  false);
	}else{
		ComShowObject(document.form.tb1_btn_Retrieve,  false);
		ComShowObject(document.form.tb1_btn_New,  false);
		ComShowObject(document.form.tb2_btn_DownExcel,  true);
		ComShowObject(document.form.tb2_btn_Back,  true);
	}
}
function cmdt_cd_OnChange() {
alert("eee");
	if(document.form.cmdt_cd.value =="")
		{
		document.form.cmdt_nm.value =="";
		}
}
function initCombo() {
	// initCombo
	var formObject=document.form;
 	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0278GS.do", FormQueryString(formObject));
	var arrXml=sXml.split(iterator);
	// IBMultiCombo Setting
	// [0] - R/D Term - rcv_term_cd
	// [1] - R/D Term - de_term_cd
	// [2] - R/D Term - tb1_Morg_sconti_cd
	// [3] - R/D Term - tb1_Mdesc_sconti_cd
	// [4] - R/D Term - tb1_Morg_svc_mod_cd
	// [5] - R/D Term - tb1_Mdesc_inlnd_svc_mod_cd
	// IBMultiCombo Setting
	if (arrXml[0].length > 0) {
		ComBkgXml2ComboItem(arrXml[0], tb1_Mbooking_rcv_term_cd,"val", "name"); // R/D Term - rcv_term_cd
		tb1_Mbooking_rcv_term_cd.SetMultiSelect(1);
		tb1_Mbooking_rcv_term_cd.SetMultiSeparator(multiSeparator);
	}
	if (arrXml[1].length > 0) {
		ComBkgXml2ComboItem(arrXml[1], tb1_Mbooking_de_term_cd,"val", "name"); // R/D Term - de_term_cd
		tb1_Mbooking_de_term_cd.SetMultiSelect(1);
		tb1_Mbooking_de_term_cd.SetMultiSeparator(multiSeparator);
	}
	if (arrXml[2].length > 0) {
		ComBkgXml2ComboItem(arrXml[2], tb1_Morg_sconti_cd, "val","name"); // S.Route(From) - tb1_Morg_sconti_cd
		tb1_Morg_sconti_cd.SetMultiSelect(1);
		tb1_Morg_sconti_cd.SetMultiSeparator(multiSeparator);
	}
	if (arrXml[3].length > 0) {
		ComBkgXml2ComboItem(arrXml[3], tb1_Mdesc_sconti_cd, "val","name"); // S.Route(to) - tb1_Mdesc_sconti_cd
		tb1_Mdesc_sconti_cd.SetMultiSelect(1);
		tb1_Mdesc_sconti_cd.SetMultiSeparator(multiSeparator);
	}
	if (arrXml[4].length > 0) {
		ComBkgXml2ComboItem(arrXml[4], tb1_Morg_svc_mod_cd, "val","name"); // S.Mode(From) - tb1_Morg_svc_mod_cd
		tb1_Morg_svc_mod_cd.SetMultiSelect(1);
		tb1_Morg_svc_mod_cd.SetMultiSeparator(multiSeparator);
	}
	if (arrXml[5].length > 0) {
		ComBkgXml2ComboItem(arrXml[5], tb1_Mdesc_inlnd_svc_mod_cd,"val", "name"); // S.Mode(From) - tb1_Mdesc_inlnd_svc_mod_cd
		tb1_Mdesc_inlnd_svc_mod_cd.SetMultiSelect(1);
		tb1_Mdesc_inlnd_svc_mod_cd.SetMultiSeparator(multiSeparator);
	}
}
function Retrive(srcName) {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	if (validateForm(sheetObject1, formObject, srcName)) {
		// MultiCombo Value Setting
		formObject.booking_rcv_term_cd.value=tb1_Mbooking_rcv_term_cd.GetSelectCode();
		formObject.booking_de_term_cd.value=tb1_Mbooking_de_term_cd.GetSelectCode();
		formObject.org_sconti_cd.value=tb1_Morg_sconti_cd.GetSelectCode();
		formObject.desc_sconti_cd.value=tb1_Mdesc_sconti_cd.GetSelectCode();
		formObject.org_svc_mod_cd.value=tb1_Morg_svc_mod_cd.GetSelectCode();
		formObject.desc_inlnd_svc_mod_cd.value=tb1_Mdesc_inlnd_svc_mod_cd.GetSelectCode();
		var strValue="";
		// bkg_cgo_tp_cd
		if (formObject.bkg_cgo_tp_cd_f.checked) {
			strValue += formObject.bkg_cgo_tp_cd_f.value + "|";
		}
		if (formObject.bkg_cgo_tp_cd_p.checked) {
			strValue += formObject.bkg_cgo_tp_cd_p.value + "|";
		}
		if (formObject.bkg_cgo_tp_cd_r.checked) {
			strValue += formObject.bkg_cgo_tp_cd_r.value + "|";
		}
		strValue=strValue.substring(0, eval(strValue.lengthByte()) - 1);
		formObject.bkg_cgo_tp_cd.value=strValue;
		strValue="";
		// bkg_sts_cd
		if (formObject.bkg_sts_cd_f.checked) {
			strValue += formObject.bkg_sts_cd_f.value + "|";
		}
		if (formObject.bkg_sts_cd_w.checked) {
			strValue += formObject.bkg_sts_cd_w.value + "|";
		}
		strValue=strValue.substring(0, eval(strValue.lengthByte()) - 1);
		formObject.bkg_sts_cd.value=strValue;
		strValue="";
		// adv_shtg_cd
		if (formObject.adv_shtg_cd_a.checked) {
			strValue += formObject.adv_shtg_cd_a.value + "|";
		}
		if (formObject.adv_shtg_cd_s.checked) {
			strValue += formObject.adv_shtg_cd_s.value + "|";
		}
		strValue=strValue.substring(0, eval(strValue.lengthByte()) - 1);
		formObject.adv_shtg_cd.value=strValue;
		strValue="";
		// revenue
		if (formObject.revenue_r.checked) {
			//strValue += formObject.revenue_r.value + "|";
			strValue=formObject.revenue_r.value;
		} else if (formObject.revenue_n.checked) {
			//strValue += formObject.revenue_n.value + "|";
			strValue=formObject.revenue_n.value;
		} else {
			//
			strValue="";
		}
		formObject.revenue.value=strValue;
		strValue="";
		// Sort Test
		formObject.query_sort.value="POL|POD";
		// alert(formObject.vvd_pol_cd.value.indexOf("US"));
		if (formObject.booking_por_cd.value.indexOf("US") != -1
				|| formObject.booking_pol_cd.value.indexOf("US") != -1
				|| formObject.vvd_pol_cd.value.indexOf("US") != -1) {
			sheetObjects[1].SetColHidden(prefix2 + "aes",0);
			sheetObjects[1].SetColHidden(prefix2 + "manifest",0);
			sheetObjects[1].SetColHidden(prefix2 + "rate",0);
		} else {
			sheetObjects[1].SetColHidden(prefix2 + "aes",1);
			sheetObjects[1].SetColHidden(prefix2 + "manifest",1);
			sheetObjects[1].SetColHidden(prefix2 + "rate",1);
		}
		if (formObject.booking_por_cd.value.indexOf("CA") != -1
				|| formObject.booking_pol_cd.value.indexOf("CA") != -1
				|| formObject.vvd_pol_cd.value.indexOf("CA") != -1) {
			sheetObjects[1].SetColHidden(prefix2 + "caed",0);
		} else {
			sheetObjects[1].SetColHidden(prefix2 + "caed",1);
		}
		tabObjects[0].SetSelectedIndex(1);
		formObject.obl_iss_date.value=formObject.obl_iss_chk[0].checked ? formObject.obl_iss_chk[0].value : formObject.obl_iss_chk[1].value;
		doActionIBSheet(sheetObject2, document.form, IBSEARCH);
	}
}
/**
 * Rep. Commodity Select Value Return
 */
function getCOM_ENS_011(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	// alert("colArray[0] : [" + colArray[0] + "]\n\n" + "colArray[1] : [" +
	// colArray[1] + "]\n\n" + "colArray[2] : [" + colArray[2] + "]\n\n" +
	// "colArray[3] : [" + colArray[3] + "]\n\n" + "colArray[4] : [" +
	// colArray[4] + "]\n\n" + "colArray[5] : [" + colArray[5] + "]\n\n" +
	// "colArray[6] : [" + colArray[6] + "]");
	formObject.rep_cmdt_cd.value=colArray[4]; // Rep. Commodity -
												// btn_rep_cmdt_cd
	formObject.cmdt_cd.value=colArray[2]; // Commodity - cmdt_cd
	formObject.cmdt_nm.value=colArray[3]; // Commodity - btn_cmdt_cd
}
/**
 * Contract / RFA Popup Select Value Return
 */
function getESM_BKG_06545(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	if (formObject.sc_rfa_chk[0].checked == true) {
		formObject.sc_rfa_no.value=colArray[5]; // Contract S/C
	} else {
		formObject.sc_rfa_no.value=colArray[5]; // Contract RFA
	}
}
/**
 * Customer KR Popup Select Value Return
 */
function getCOM_ENS_041(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	// alert("colArray[3] : [" + colArray[3] + "]\n\n" + "colArray[4] : [" +
	// colArray[4] + "]\n\n" + "colArray[3].length : [" +
	// colArray[3].lengthByte() + "]");
	if (colArray[3].lengthByte() >= 3) {
		formObject.cust_cnt_cd.value=colArray[3].substring(0, 2); // Customer
																	// -
																	// cust_cnt_cd
																	// (EX - KR)
		formObject.cust_seq.value=colArray[3].substring(2, colArray[3]
				.lengthByte()); // Customer - cust_seq (EX - 949)
	}
	formObject.cust_nm.value=colArray[4]; // Customer - cust_nm (EX - SAMSUNG
											// SDI.)
}
/**
 * Contract / RFA Popup Select Value Return
 */
function setOrderBy(returnCode) {
	var formObject=document.form;
	if (returnCode != "") {
		// alert( "****** returnCode *****" + "\n\n" + ComReplaceStr(returnCode, ",", multiSeparator) );
		formObject.query_sort.value=ComReplaceStr(returnCode, ",",
				multiSeparator);
		// alert("query_sort : [" + formObject.query_sort.value + "]");
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
}
/**
 * B/L No. Setting the Value
 */
function setBlNo(sheetObj, param) {
	//alert("param : [" + param + "]");
	var formObject=document.form;
	var rect=document.getElementById("td_bl_no").getBoundingClientRect();
	formObject.rect_top.value=formObject.rect_top.value == "" ? rect.top : formObject.rect_top.value;
	formObject.rect_left.value=formObject.rect_left.value == "" ? rect.left : formObject.rect_left.value;
	
	if (param == 1) {
		// sheet Enable
		document.getElementById("bl_input").style.display="none";
		document.getElementById("bl_sheet").style.display="block";
		// sheet positioning
		document.getElementById("bl_sheet").style.top=formObject.rect_top.value;
		document.getElementById("bl_sheet").style.left=formObject.rect_left.value;
		var BlNoselectRow=!ComIsEmpty(formObject.sheet_bl_no_row_chk) ? formObject.sheet_bl_no_row_chk.value : "1";
		
		if (!ComIsEmpty(formObject.input_bl_no)) {
			sheetObj.SetCellValue(BlNoselectRow, prefix1 + "bl_no",formObject.input_bl_no.value,0);
		}
		sheetObj.SelectCell(BlNoselectRow, prefix1 + "bl_no");
	} else if (param == 2) {
		document.getElementById("bl_input").style.display="block";
		document.getElementById("bl_sheet").style.display="none";
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (!ComIsEmpty(sheetObj.GetCellValue(i, prefix1 + "blank")) && !ComIsEmpty(sheetObj.GetCellValue(i, prefix1 + "bl_no"))) {
				formObject.sheet_bl_no_row_chk.value=i;
				formObject.input_bl_no.value=sheetObj.GetCellValue(i, prefix1 + "bl_no");
				break;
			}
		}
	} else if (param == 3) {
		if (document.getElementById("bl_sheet").style.display == "block") {
			setBlNo(sheetObj, 2);
		}
	}
}
/**
 * Initialization page
 */
function pageReset(sheetObj, formObject) {
	// pageReset(sheetObjects[0] formObject)	
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		sheetObj.SetCellValue(i, prefix1 + "bl_no","",0);
	}
	formObject.reset();

	// Multi Combo initialization
	tb1_Mbooking_rcv_term_cd.SetSelectCode("");
	tb1_Mbooking_de_term_cd.SetSelectCode("");
	tb1_Morg_sconti_cd.SetSelectCode("");
	tb1_Mdesc_sconti_cd.SetSelectCode("");
	tb1_Morg_svc_mod_cd.SetSelectCode("");
	tb1_Mdesc_inlnd_svc_mod_cd.SetSelectCode("");

}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObject, sAction, bParam) {
	//alert("validateForm\n\nwindow.event  : [" + chk + "]");
	with (formObject) {
		var BlNoselectRow=sheet_bl_no_row_chk.value != "" ? sheet_bl_no_row_chk.value : "1";
		if (!ComIsEmpty(input_bl_no.value)) {
			sheetObj.SetCellValue(BlNoselectRow, prefix1 + "bl_no",input_bl_no.value,0);
		}
		// B/L No
		master_bl_no.value=multiSheetRow(formObject, sheetObj, prefix1 + "bl_no", true);
		master_bl_no.value=master_bl_no.value.length == 0 ? input_bl_no.value : master_bl_no.value;
		if (vvd.value.trimAll().length == 0 && master_bl_no.value.length == 0 && obl_iss_from_dt.value == "" && obl_iss_to_dt.value == "") {
			ComShowCodeMessage("BKG00367");
			if (window.event != null) {
				if (vvd.value.length == 0) {
					vvd.focus();
				} else if (master_bl_no.value.length == 0) {
					master_bl_no.focus();
				} else if (obl_iss_from_dt.value.length == 0) {
					obl_iss_from_dt.focus();
				} else if (obl_iss_to_dt.value.length == 0) {
					obl_iss_to_dt.focus();
				}
			}
			return false;
		}
		// obl_iss_from_dt / obl_iss_to_dt
		if (obl_iss_from_dt.value != "" && obl_iss_to_dt.value != "") {
			var sTitle1=(obl_iss_from_dt.getAttribute("caption") == null) ? "start date" : obl_iss_from_dt.getAttribute("caption");
			var sTitle2=(obl_iss_to_dt.getAttribute("caption") == null) ? "start date" : obl_iss_to_dt.getAttribute("caption");
			var blDateChk=0;
			blDateChk=ComGetDaysBetween(obl_iss_from_dt.value, obl_iss_to_dt.value);
			if (blDateChk < 0) {
				var sMsg=ComGetMsg("COM12133", "'" + sTitle1 + "'", "'" + sTitle2 + "'", "later");
				ComShowMessage(sMsg);
				obl_iss_from_dt.focus();
				return false;
			}
			if (ComGetDaysBetween(obl_iss_from_dt.value, obl_iss_to_dt.value) > 7) {
				ComShowCodeMessage("BKG00756", "Duration", "7Days")
				obl_iss_from_dt.focus();
				return false;
			}
		}
		if (ComIsEmpty(vvd) && ComIsEmpty(input_bl_no)
				&& !ComIsEmpty(obl_iss_from_dt) && !ComIsEmpty(obl_iss_to_dt)
				&& ComIsEmpty(vvd_pol_cd) && ComIsEmpty(vvd_pod_cd)
				&& ComIsEmpty(booking_por_cd) && ComIsEmpty(booking_pol_cd)
				&& ComIsEmpty(booking_pod_cd) && ComIsEmpty(booking_del_cd)
				&& ComIsEmpty(bkg_ofc_cd) && ComIsEmpty(doc_usr_cd)
				&& ComIsEmpty(ob_sls_ofc_cd) && ComIsEmpty(ob_srep_cd)
				&& ComIsEmpty(obl_iss_ofc_cd) && ComIsEmpty(obl_iss_usr_id)) {
			//Mandatory item is missing. Please enter ({?msg1})
			ComShowCodeMessage("BKG00104", "\n\tPOL or" + "\n\tPOD or"
					+ "\n\tBooking Route or" + "\n\tBooking Office or"
					+ "\n\tBooking Staff or" + "\n\tSales Office or"
					+ "\n\tSales Rep. or" + "\n\tB/L Office or"
					+ "\n\tB/L Staff");
			return false;
		}
	}
	return true;
}
/**
 * Common pop-up - COM_ENS_011
 */
function Pop_COM_ENS_011(formObject) {
	var param="?rep_cmdt_cd=" + formObject.rep_cmdt_cd.value;
	param += "&cmdt_cd=" + formObject.cmdt_cd.value;
	param += "&cmdt_nm=" + formObject.cmdt_nm.value;
	ComOpenPopup("/opuscntr/COM_ENS_011.do" + param, 780, 480, "getCOM_ENS_011",
			"1,0,1,1,1,1,1,1", true);
}
/**
 * pop-up - ESM_BKG_0655.do / ESM_BKG_0654.do
 */
function Pop_ESM_BKG_06545(formObject) {
	if (formObject.sc_rfa_chk[0].checked) {
		ComOpenPopup("/opuscntr/ESM_BKG_0655.do", 800, 500, "getESM_BKG_06545", "1,0,1,1,1,1,1,1", true);
	} else if (formObject.sc_rfa_chk[1].checked) {
		ComOpenPopup("/opuscntr/ESM_BKG_0654.do", 835, 480, "getESM_BKG_06545", "1,0,1,1,1,1,1,1", true);
	} else if (formObject.sc_rfa_chk[2].checked) {
		var pgmNo="ESM_PRI_3007";
		var pgmUrl="/opuscntr/ESM_PRI_3007.do";
		var params="&cond_taa_no=" + ComGetObjValue(formObject.sc_rfa_no);
		var parentPgmNo=pgmNo.substring(0, 8) + "M001";
		var src="&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&pgmNo=" + pgmNo + params;
		var sUrl="opussMain.screen?parentPgmNo=" + parentPgmNo + src;
		var iWidth=1024;
		var iHeight=700;
		var leftpos=(screen.width - iWidth) / 2;
		if (leftpos < 0) leftpos=0;
		var toppos=(screen.height - iHeight) / 2;
		if (toppos < 0) toppos=0;
		var sFeatures="status=no, resizable=yes, scrollbars=yes, width=" + iWidth + ", height=" + iHeight + ", left=" + leftpos + ", top=" + toppos;
		ComOpenWindow(pgmUrl, "", sFeatures);
	}
}
/**
 * Common pop-up - COM_ENS_041
 */
function Pop_COM_ENS_041(formObject) {
	var param="?cust_cd=" + formObject.cust_cnt_cd.value + formObject.cust_seq.value;
	param += "&cust_nm=" + formObject.cust_nm.value;
	ComOpenPopup("/opuscntr/COM_ENS_041.do" + param, 780, 470, "getCOM_ENS_041", "1,0,1,1,1,1,1,1", true);
}
/**
 * Common pop-up - Pop_ESM_BKG_0161
 */
function Pop_ESM_BKG_0161(formObject) {
	ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?isPop=Y&codeGubun=CD02347", "OrderBy", 400,230,false,"scrollbars=no,resizable=yes");
}
/**
 * BLPrint / Manifest
 */
function BLPrint(formObj, sheetObj, strGubun) {
	var iCheckRow=sheetObj.FindCheckedRow(prefix2 + "Check");
	var obl_rlse_flg="";
	if (iCheckRow <= 1) {
		ComShowCodeMessage("COM12176"); // Please select one at least.
		return;
	}
	var strResult="";
	var arrRow=iCheckRow.split("|");
	for (idx=0; idx < arrRow.length - 1; idx++) {
		if (0 > strResult.indexOf(sheetObj.GetCellValue(arrRow[idx], prefix2 + "bkg_no"))) {
			strResult += sheetObj.GetCellValue(arrRow[idx], prefix2 + "bkg_no") + ",";
		}
		if (0==idx && "" != obl_rlse_flg) {
			obl_rlse_flg=sheetObj.GetCellValue(arrRow[idx], prefix2 + "obl_rlse_flg");
		}
	}
	strResult=strResult.substring(0, eval(strResult.lengthByte()) - 1);
	var form_manifest="N";
	/*
	 * 1.showing the yard name in Final Destination if POD of the searching list condition is Location Code that starts with VN like that : 
	 *	being manifest and  meeting the VN searching condition
	 * 2. showing POD of T/VVD instead of  Booking POD B/L Port of Discharging in case of being B/L print : 
	 *  being manifest, and showing BKG_VVD.POD_CD(based on TRUNK VVD) instead of BKG_BOOKING.POD_CD
	 */
	if (strGubun == "Manifest") {
		form_manifest="X";
	}
	var param="?bkg_no=" + strResult + "&form_manifest=" + form_manifest + "&obl_rlse_flg=" + obl_rlse_flg;
	if (500 < strResult.split(",").length) {
		ComShowCodeMessage("BKG08124", 500); // You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
		return;
	}
	var obj=new Object();
	obj.bkg_no=strResult;
	obj.form_manifest=form_manifest;
	obj.obl_rlse_flg=obl_rlse_flg;
	var sFeatures="scroll:no;status:no;help:no;dialogWidth:925px;dialogHeight:390px";// ;dialogLeft:450;dialogTop:345";
	
	var formObject2 = document.form2;
	var url = "";
		url="/opuscntr/ESM_BKG_0743.do";
	
	ComOpenWindow(url,  obj,  sFeatures , true);
}
/**
 * t2shee1 sheet post-processing
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var blNos=new Array();
	if (sheetObj.RowCount()> 0) {
		sheetObj.SetColFontUnderline(prefix2 + "bl_no",1);
		sheetObj.SetColFontColor(prefix2 + "bl_no","#0000FF");
		sheetObj.SetColBackColor(prefix2 + "consignee","#EFEBEF");
		sheetObj.SetColBackColor(prefix2 + "shipper","#EFEBEF");
		var bkgnoCnt=blnoCnt=0;
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if ("chk"==sheetObj.GetCellValue(i, prefix2 + "blank")) {
				if (!ComIsEmpty(sheetObj.GetCellValue(i, prefix2 + "bkg_no"))) {
					bkgnoCnt++;
				}
				if (!ComIsEmpty(sheetObj.GetCellValue(i, prefix2 + "bl_no"))) {
					blnoCnt++;
				}
			}
		}
		formObj.bookingCnt.value=ComAddComma(blnoCnt);  // Booking Q'ty set - sheetObj.RowCount()
		formObj.bldocCnt.value=ComAddComma(bkgnoCnt);  // B/L Q'ty set - blbkgnoCnt
		formObj.weightTon.value=ComAddComma(ComTrunc(sheetObj.ComputeSum("|"+prefix2+"bl_act_wgt"+"|"), 0));  // Weight(TON) set
		formObj.Measure.value=ComAddComma(ComTrunc(sheetObj.ComputeSum("|"+prefix2+"bl_meas_qty"+"|"), 0));  // Measure set
		// searching = false;
		if (tabObjects[0].GetSelectedIndex() != 1) {
			tabObjects[0].SetSelectedIndex(1);
		}
		var inputBlNoCnt=sheetObjects[0].RowCount()- ComFindText(sheetObjects[0], prefix1 + "bl_no", "").length;
		if (0 < inputBlNoCnt) {
			var idx=0;
			var isntExist=true;
			var blNo;
			for (var i=1; i<sheetObjects[0].RowCount(); i++) {
				blNo=sheetObjects[0].GetCellValue(i,prefix1+"bl_no");
				if (!ComIsEmpty(blNo)) {
					isntExist=true;
					for (var j=2; j<=sheetObjects[1].LastRow(); j++) {
						if (!ComIsEmpty(sheetObjects[1].GetCellValue(j,prefix2+"blank")) &&
								0<=sheetObjects[1].GetCellValue(j,prefix2+"bl_no").indexOf(blNo)) {
							isntExist=false;
							break;
						}
					}
					if (isntExist) {
						blNos[idx++]="  "+blNo;
					}
				}
			}
		}
	} else {
		formObj.bookingCnt.value="";  // Booking Q'ty set - sheetObj.RowCount()
		formObj.bldocCnt.value="";  // B/L Q'ty set - blbkgnoCnt
		formObj.weightTon.value="";  // Weight(TON) set
		formObj.Measure.value="";  // Measure set
		var idx=0;
		var blNos=new Array();
		for (var i=1; i<sheetObjects[0].RowCount(); i++) {
			blNo=sheetObjects[0].GetCellValue(i,prefix1+"bl_no");
			if (!ComIsEmpty(sheetObjects[0].GetCellValue(i,prefix1+"bl_no"))) {
				blNos[idx++]="  "+sheetObjects[0].GetCellValue(i,prefix1+"bl_no");
			}
		}
	}
	if (0 < blNos.length) {
		ComShowCodeMessage("BKG40031","\n"+blNos.join("\n")+"\n");
	}
	// B/L No. > 1 ->  bl_sheet Layer popup open
	if (1 < inputBlNoCnt) {
		setBlNo(sheetObjects[0], 1);
	}
}
/**
 * t2shee1  check cell-> check Event
 */
var oldRow=0;
var oldChk=0;
var isShift=false;
function t2sheet1_OnBeforeCheck(sheetObj, newRow, Col) {
	if (0 == Col) {
		with (sheetObj) {
			if (ComIsEmpty(GetCellValue(newRow, prefix2 + "blank"))) {
				/*
				for (var i=newRow+1; i<=RowCount()+1; i++) {
if (ComIsEmpty(GetCellValue(i, prefix2 + "blank"))) {
						break;
					}
SetCellValue(i, prefix2 + "Check",0 == GetCellValue(newRow, prefix2 + "Check") ? 1 : 0,0);
				}
				*/
				SetCellValue(newRow, prefix2 + "Check",0,0);
				return false;
			}
			if (isShift) {
				var curRow=newRow;
				if (newRow < oldRow) {
					newRow=oldRow;
					oldRow=curRow;
				}
				for ( var i=oldRow; i <= newRow; i++) {
					if (!ComIsEmpty(GetCellValue(i, prefix2 + "blank"))) {
						SetCellValue(i, prefix2 + "Check",0 == oldChk ? 1 : 0,0);
					}
				}
				SetCellValue(curRow, prefix2 + "Check",0 == GetCellValue(curRow, prefix2 + "Check") ? 1 : 0,0);
			}
			oldRow=newRow;
			oldChk=GetCellValue(oldRow, prefix2 + "Check");
		}
	}
}
function sheet_keydown() {
	if (16 == event.keyCode) { //shift
		isShift=true;
	}
}
function sheet_keyup() {
	if (16 == event.keyCode) { //shift
		isShift=false;
	}
}
/**
 * t2shee1 cell Double-click event
 */
function t2sheet1_OnDblClick(sheetObj, Row, Col) {
	var colnm=sheetObj.ColSaveName(Col);
	if (colnm == prefix2 + "bl_no" && !ComIsEmpty(sheetObj.GetCellValue(Row, prefix2 + "blank"))) {
//		var param = "bkg_no=" + sheetObj.CellValue(Row, prefix2 + "bkg_no") + "&pgmNo=ESM_BKG_0079";
//		ComOpenWindow("/opuscntr/ESM_BKG_0079.do?" + param, "PopupEsmBkg0079", '1024','768', true);
		comBkgCallPopBkgDetail(sheetObj.GetCellValue(Row, prefix2 + "bkg_no"));
	}
}

/**
 * t2shee1 sheet post-processing
 */
function t2sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var cnt=sheetObj.RowCount();
	for ( var i=sheetObj.LastRow(); i >= sheetObj.HeaderRows(); i--) {
		if ("1" == sheetObjects[1].GetCellValue(i,prefix2 +"Check")){
			sheetObj.SetCellValue(i,prefix3 +"Check",sheetObjects[1].GetCellValue(i,prefix2 +"Check"));
		}
		if (ComIsEmpty(sheetObj.GetCellValue(i, prefix3 + "blank"))) {
			sheetObj.RowDelete(i,false);
		}
	}
	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(		sheetObj), SheetDesign:1,Merge:0 });
}
function RdPrint(sheetObject, param) {
	///rp [( ('SHAZ7250007','  '), ('SLCZ5120010','  ') )] /riprnmargin /rprncenteropt [1]
	var formObject=document.form;
	var iCheckRow=sheetObject.FindCheckedRow(prefix2 + "Check");
	if (iCheckRow <= 1) {
		ComShowCodeMessage("COM12176"); // Please select one at least.
		return;
	}
	var strResult="";
	var arrRow=iCheckRow.split("|");
	for (idx=0; idx < arrRow.length - 1; idx++) {
		//alert(arrRow[idx]);
		strResult += sheetObject.GetCellValue(arrRow[idx], prefix2 + "bkg_no") + ",";
	}
	if (0 < strResult.indexOf(","))
		strResult=strResult.substring(0, strResult.length - 1);
//	if (50 < strResult.split(",").length) {
//		ComShowCodeMessage("BKG08124", 50); // You select more than {?msg1} B/Ls
//											// for B/L print. Max is {?msg1}
//											// B/Ls one time
//		return;
//	}
  if(ComGetLenByByte(strResult) > 4000){
			rdParam += " bkg_nos[" + getStringToClobString(bkgnoForGeneralRD, 200) + "] "; // form_type
			strResult="[ " + getStringToClobString(strResult, 200) + " ] [" + param + "]";
	} else{
			strResult="['" + strResult + "'] [" + param + "]";
	}
	// alert("strResult : [" + strResult + "]");
	// rdOpen(rdObjects[0], document.form, strResult);
	formObject.com_mrdTitle.value="EIR (HKG)";
	formObject.com_mrdBodyTitle.value="EIR (HKG)";
	formObject.com_mrdPath.value="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0791.mrd";
	formObject.com_mrdArguments.value="/rp " + strResult + " /riprnmargin";
	ComOpenRDPopup();
}
/**
 * Returns a string value of Row
 * @param {object} sheetObj mandatory, IBSheet Object
 * @param {object} formObj mandatory, form Object
 * @param {boolean} boolean 
 */
function multiSheetRow(formObject, sheetObj, col, gubun) {
	var strValue="";
	// B/L No. ->If there is input data
	if (sheetObj.RowCount()> 0) {
		sheetObj.SetCellValue(0, prefix1 + "bl_no",formObject.input_bl_no.value,0);
	}
	//formObject.input_bl_no.value
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, col) != "") {
			if (gubun) {
				strValue += sheetObj.GetCellValue(i, col) + "|";
			} else {
				strValue += sheetObj.GetCellValue(i, col);
			}
		}
	}
	strValue=strValue.substring(0, eval(strValue.lengthByte()) - 1);
	return strValue;
}

/**
 * POST window popup ESM_BKG_0743_01
 * @param formObject
 * @param bkgNos
 * @param sUrl
 * @param sWinName
 * @param sFeatures
 */
function callPostPop074301(formObject, bkgNos, sUrl, sWinName, sFeatures ){
	window.open("", sWinName, sFeatures);
	formObject.bkg_no.value=bkgNos;
	formObject.action=sUrl;
	formObject.target="PopupEsmBkg074301";
	formObject.submit();
}


