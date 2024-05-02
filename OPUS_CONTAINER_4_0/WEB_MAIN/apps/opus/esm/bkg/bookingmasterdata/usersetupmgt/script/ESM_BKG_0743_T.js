/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : esm_bkg_0743.js
 *@FileTitle  : B/L Print Option
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
 EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
 OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * business script for esm_bkg_0548
 */
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 *
 * @param sheet_obj
 *            IBSheet Object
 */
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";
var prefix = "sheet1_";
var firstYn = false;
var obl_iss_knt = 1;
var bl_tp_cd = "";
var obl_iss_flg = "";
var obl_prn_flg = "";
var bb_cgo_flg = "";
var bl_cpy_knt = "";
var pre_form_type = "";
var pre_container_type = "";
var org_ppd_rcv_cd = "";
var org_n3pty_ppd_cd = "";
var print_release_yn = "";
var save_face_print_cnt = "";
var save_rider_print_cnt = "";
var bl_esig_flg = "";
var bl_cpy_esig_flg = "";
var bl_knt_flg = "";
/** ********************* EDTITABLE MULIT COMBO START ******************* */
var comboCnt = 0;
var comboObjects = new Array();
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * initializing combo
 *
 * @param comboObj
 * @param comboId
 * @return
 */
function initCombo(comboObj, comboId) {
	var formObject = document.form
	initComboEditable(comboObj)
}
/**
 * initializing combo editable
 *
 * @param combo
 * @return
 */
function initComboEditable(combo) {
	with (combo) {
		SetMultiSelect(0);
		SetUseEdit(0);
		SetDropHeight(200);
	}
}
/** ********************* EDTITABLE MULIT COMBO END******************* */
/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// MultiCo1mbo Init
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	for (i = 0; i < rdObjects.length; i++) {
		initRdConfig(rdObjects[i], i + 1);
	}

	firstYn = false;
	initPrintList();
	doActionIBSheet(sheetObjects[0], form, IBSEARCH);
	Retrive(sheetObjects[0]);
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

var strPrintList = "";
var defaultPrint = "";
/**
 * init print list
 */
function initPrintList() {
	var rdViewer = document.form.Rdviewer;    // for IE11
	if (rdViewer == undefined) rdViewer = Rdviewer;    // for Chrome
	strPrintList = rdViewer.GetLocalInfo("PrnNames", "");
	defaultPrint = rdViewer.GetLocalInfo("DefaultPrnName", "");

	if (strPrintList == undefined || strPrintList == null || strPrintList == "") return;
	var arrPrintList = strPrintList.split("|");
	printListXml = " <SHEET> \n";
	printListXml += " <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='"
			+ (arrPrintList.length - 1) + "'> \n";
	for ( var i = 0; i < arrPrintList.length - 1; i++) {
		printListXml += " 	<TR><![CDATA[" + arrPrintList[i] + "]]></TR> \n";
	}
	printListXml += " </DATA> \n";
	printListXml += " </SHEET> ";
	ComXml2ComboItem(printListXml, bl_face_prn_dvc_nm, "val", "val");
	ComXml2ComboItem(printListXml, bl_ridr_prn_dvc_nm, "val", "val");
}
/**
 * check print list
 *
 * @param val
 * @return
 */
function checkPrintList(val) {
	var arrPrintList = strPrintList.split("|");
	for ( var i = 0; i < arrPrintList.length - 1; i++) {
		if (val == arrPrintList[i])
			return true;
	}
	return false;
}
/**
 * init RD configuration
 *
 * @param rdObject
 * @return
 */
function initRdConfig(rdObject) {
	rdObject.AutoAdjust = true;
	rdObject.ViewShowMode(0);
	rdObject.SetBackgroundColor(128, 128, 128);
	rdObject.SetPageLineColor(128, 128, 128);
	// rdObject.SetSheetHeight(0);
	rdObject.ApplyLicense("0.0.0.0");
}
/**
 * ojb click
 */
function obj_click() {
	var formObject = document.form;
	var obj = ComGetEvent();
	switch (ComGetEvent("name")) {
	case "hiddenData": // hiddenData
		// alert(obj.name + "\n\n" + obj.value);
		Retrive(sheetObjects[0]);
		break;
	case "bl_ca_yn": // bl_ca_yn
		// alert(obj.name + "\n\n" + obj.value);
		if (obj.checked == false) {
			formObject.corr_no.value = "";
			formObject.ca_no.SetSelectCode("");
		}
		Retrive(sheetObjects[0]);
		break;
	}
}
/**
 * retrieve
 *
 * @param sheetObject
 * @return
 */
function Retrive(sheetObject) {
	//
	var formObject = document.form;
	ComOpenWait(true);
	doActionIBSheet(sheetObjects[0], form, SEARCH01);
	// sheetObjects[0].RemoveAll()
	ComOpenWait(false);
}
/**
 * start RD
 */
function rdStart() {
	var formObject = document.form;
	var strBkgNo = formObject.bkg_no.value;
	var FaceYn = "Y";
	var RiderYn = "";
	var HBYn = "";
//	var CopyYn = "";
	if (strBkgNo.length == 0) {
		ComShowCodeMessage('BKG00626', 'BKG No.');
		return;
	}
	// Original B/L
	// Error in case of B/L Release
	if (formObject.form_type.value == 4 && formObject.obl_rlse_flg.value == "Y") {
		ComShowCodeMessage('BKG08098');
		return;
	}
	if (formObject.rider_only_yn.checked) {
		RiderYn = "Y";
	}
	if (formObject.nvocc_only_yn.checked) {
		HBYn = "Y";
	}
	if (formObject.rider_nvocc_yn.checked) {
		RiderYn = "";
		HBYn = "Y";
	}
//	if (formObject.bl_cpy_no.value > 0) {
//		CopyYn = "Y";
//	}
	rdOpen(formObject, RiderYn, HBYn);
}
/**
 * open RD
 *
 * @param formObject
 * @param RiderYn
 * @param HBYn
 * @return
 */
function rdOpen(formObject, RiderYn, HBYn) {
	var totalPage = rdOpenStart(formObject, RiderYn, HBYn);
	var Rdviewer_Face = document.form.report1;    // for IE11
	if (Rdviewer_Face == undefined) Rdviewer_Face = report1;    // for Chrome
	var Rdviewer_Rider = document.form.report2;    // for IE11
	if (Rdviewer_Rider == undefined) Rdviewer_Rider = report2;    // for Chrome
	var Rdviewer_Hb = document.form.report3;    // for IE11
	if (Rdviewer_Hb == undefined) Rdviewer_Hb = report3;    // for Chrome
	// ComOpenWait(true);
	var RiderPrintYn = false;
	var rdParam_Face = "";
	var rdParam_Face_rv = "";
	var rdParam_Rider = "";
	var rdParam_Rider_rv = "";
	var rdParam_Hb = "";
	var strFacePath = "";
	var strRiderPath = "";
	var strHbPath = "";
	var bkgNo = formObject.bkg_no.value; // bkg_no
	var formType = form_type.GetSelectCode(); // form_type
	var formDataOnly = formObject.preview_yn.checked == true ? "N" : "Y"; // Preview
	var formManifest = formObject.form_manifest.value; // form_manifest
	var formUserId = formObject.usr_id.value; // form_usrId
	var formHiddenData = formObject.hiddenData.checked == true ? "Y" : "N"; // form_hiddeData
	var formOfcCd = formObject.ofc_cd.value; // ofc_cd
	// ComReplaceStr(formObject.form_remark.value, "\r\n", "[##]")
	var formRemark = ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)"); // form_remark
	formRemark = ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(
			formRemark, "\'", "'||CHR(39)||'"), "\"", "'||CHR(34)||'"), "\n",
			"'||CHR(10)||'"), "\r", "'||CHR(13)||'");
	var formRate = form_Rate.GetSelectCode(); // form_Rate
	var formCntr = form_Cntr.GetSelectCode(); // form_Cntr
	// var formMainOnly = (formObject.rider_only_yn.disabled == false||
	// formObject.rider_nvocc_yn.disabled == false) ? "N" : "Y"; //
	// form_mainOnly
	var formMainOnly = "Y";
	var formCorrNo = formObject.bl_ca_yn.checked == true ? formObject.ca_no.GetSelectCode() : ""; // form_CorrNo
	var formHisCntr = formObject.bl_ca_yn.checked == true ? "BKG_CNTR_HIS" : "BKG_CONTAINER"; // form_his_cntr
	var formHisBkg = formObject.bl_ca_yn.checked == true ? "BKG_BKG_HIS" : "BKG_BOOKING"; // form_his_bkg
	var formHisMkd = formObject.bl_ca_yn.checked == true ? "BKG_BL_MK_DESC_HIS" : "BKG_BL_MK_DESC"; // form_his_mkd
	var formHisXpt = formObject.bl_ca_yn.checked == true ? "BKG_XPT_IMP_LIC_HIS" : "BKG_XPT_IMP_LIC"; // form_his_xpt
	var formHisBl = formObject.bl_ca_yn.checked == true ? "BKG_BL_DOC_HIS" : "BKG_BL_DOC"; // form_his_bl
	var formRqstViaCd = ""; // form_rqst_via_cd
	var formHisBlMkd = formObject.bl_ca_yn.checked == true ? "BKG_BL_ISS_HIS" : "BKG_BL_ISS"; // form_his_bl_mkd
	var formCaYn = formObject.bl_ca_yn.checked == true ? "Y" : ""; // form_caYn
	var Face_PrnDrv = bl_face_prn_dvc_nm.GetSelectCode(); // Print Setup (Face)
	var Face_PrnCnt = formObject.face_print_cnt.value; // Print Count (Face)
	var Rider_PrnDrv = bl_ridr_prn_dvc_nm.GetSelectCode(); // Print Setup (Rider)
	var Rider_PrnCnt = formObject.rider_print_cnt.value; // Print Count (Rider)
	var CopyYn = formObject.bl_cpy_no.value > 0 ? "Y" : "N";
	var formEsig = formObject.signed_yn.checked == true ? "Y" : "N";
	var formCpyEsig = formObject.copy_signed_yn.checked == true ? "Y" : "N";
	var formKntFlg = formObject.bl_knt_flg.value;

	// Face
	if (getRadioValue2(form.paper_type) == '1') {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
	} else if (getRadioValue2(form.paper_type) == '4') {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
	} else if (getRadioValue2(form.paper_type) == '10') {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_DOT.mrd";
	}
	/*
	 * /rv form_bkgNo[( 'ATLZ4030031', 'TPEZ1295047', 'MUCZ3270004',
	 * 'HAMY5080012', 'SZPZ1145010', 'BKK6C135013' )] form_type[2] ---> Default
	 * form_dataOnly[N] ---> Default form_manifest[N] ---> Default
	 * form_usrId[TES_AARBA] ---> Session form_hiddeData[N] ---> Default
	 * form_level[(1)] ---> Default (ex - (1,2,3,4,5)) form_remark[] --->
	 * Default form_Cntr[1] ---> Default form_mainOnly[N] ---> Default
	 * form_CorrNo[] ---> Default form_his_cntr[BKG_CONTAINER] ---> Default
	 * form_his_bkg[BKG_BOOKING] ---> Default form_his_mkd[BKG_BL_MK_DESC] --->
	 * Default form_his_xpt[BKG_XPT_IMP_LIC] ---> Default
	 * form_his_bl[BKG_BL_DOC] ---> Default /rp [] ---> Default /riprnmargin
	 */
	rdParam_Face_rv = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
	rdParam_Face_rv += "form_type[" + formType + "] "; // form_type
	rdParam_Face_rv += "form_dataOnly[" + formDataOnly + "] "; // form_dataOnly
	rdParam_Face_rv += "form_manifest[" + formManifest + "] "; // form_manifest
	rdParam_Face_rv += "form_usrId[" + formUserId + "] "; // form_usrId
	rdParam_Face_rv += "form_mainOnly[" + formMainOnly + "] "; // form_mainOnly
	rdParam_Face_rv += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
	rdParam_Face_rv += "form_level[(" + formRate + ")] "; // form_level
	rdParam_Face_rv += "form_remark[" + formRemark + "] "; // form_remark
	rdParam_Face_rv += "form_Cntr[" + formCntr + "] "; // form_Cntr
	rdParam_Face_rv += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
	rdParam_Face_rv += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
	rdParam_Face_rv += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
	rdParam_Face_rv += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
	rdParam_Face_rv += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
	rdParam_Face_rv += "form_his_bl[" + formHisBl + "] "; // form_his_bl
	rdParam_Face_rv += "form_rqst_via_cd[" + formRqstViaCd + "] "; // form_rqst_via_cd
	rdParam_Face_rv += "form_his_bl_mkd[" + formHisBlMkd + "] "; // form_his_bl_mkd
	rdParam_Face_rv += "form_end_no[" + totalPage + "]"; // form_end_no
	rdParam_Face_rv += "form_path[" + getFileDownPath() + "]";
	rdParam_Face_rv += "form_esig[" + formEsig + "] "; // form_esig
	rdParam_Face_rv += "form_cpy_esig[" + formCpyEsig + "] "; // form_cpy_esig
	rdParam_Face_rv += "form_knt_flg[" + formKntFlg + "] "; // form_knt_flg

	rdParam_Face = "/rp [" + formCaYn + "] "; // form_caYn
	rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
	// adjust position down 2.5mm in case of BOMBB, DELBS, MAABS
	if (formOfcCd == "BOMBB" || formOfcCd == "DELBS" || formOfcCd == "MAABS") {
		rdParam_Face += " /rpypos [25]";
	} // /rprncenteropt [1]
	// Rider
	if ((formObject.rider_only_yn.disabled == false && formObject.rider_only_yn.checked == true)
			|| (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true)) {
		// Rider Print
		RiderPrintYn = true;
		if (getRadioValue2(form.paper_type) == '1') {
			strRiderPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_A4_Rider.mrd";
		} else if (getRadioValue2(form.paper_type) == '4') {
			strRiderPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_LETTER_Rider.mrd";
		} else if (getRadioValue2(form.paper_type) == '10') {
			strRiderPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DOT_Rider.mrd";
		}
		/*
		 * /rv form_bkgNo[( 'ATLZ4030031', 'TPEZ1295047', 'MUCZ3270004',
		 * 'HAMY5080012', 'SZPZ1145010', 'BKK6C135013' )] form_hiddeData[N] --->
		 * Default form_level[(1)] ---> Default form_Rate[] ---> Default
		 * form_Cntr[1] ---> Default form_gubun[M] ---> Default form_CorrNo[]
		 * ---> Default form_his_cntr[BKG_CONTAINER] ---> Default
		 * form_his_bkg[BKG_BOOKING] ---> Default form_his_mkd[BKG_BL_MK_DESC]
		 * ---> Default form_his_xpt[BKG_XPT_IMP_LIC] ---> Default
		 * form_his_bl[BKG_BL_DOC] ---> Default /rp [] ---> Default /riprnmargin
		 */
		rdParam_Rider_rv = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
		rdParam_Rider_rv += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
		rdParam_Rider_rv += "form_level[(" + formRate + ")] "; // form_level
		rdParam_Rider_rv += "form_Rate[] "; // form_Rate
		rdParam_Rider_rv += "form_Cntr[" + formCntr + "] "; // form_Cntr
		// rdParam_Rider += "form_gubun[M] "; // form_gubun
		rdParam_Rider_rv += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
		rdParam_Rider_rv += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
		rdParam_Rider_rv += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
		rdParam_Rider_rv += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
		rdParam_Rider_rv += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
		rdParam_Rider_rv += "form_his_bl[" + formHisBl + "] "; // form_his_bl
		rdParam_Rider_rv += "form_type [" + formType + "] "; // form_type
		rdParam_Rider_rv += "form_rqst_via_cd [" + formRqstViaCd + "] "; // form_rqst_via_cd
		rdParam_Rider_rv += "form_his_bl_mkd [" + formHisBlMkd + "] "; // form_his_bl_mkd
		rdParam_Rider_rv += "form_end_no[" + totalPage + "]"; // form_end_no
		rdParam_Rider_rv += "form_path[" + getFileDownPath() + "]";
		rdParam_Rider_rv += "form_esig[" + formEsig + "] "; // form_esig
		rdParam_Rider_rv += "form_cpy_esig[" + formCpyEsig + "] "; // form_cpy_esig
		rdParam_Rider_rv += "form_knt_flg[" + formKntFlg + "] "; // form_knt_flg
		rdParam_Rider = "/rp [" + formCaYn + "] "; // form_caYn
		rdParam_Rider += "/riprnmargin /rmatchprndrv [3]";
	}

	/////////////////////// PRINT LOGIC 수정 ////////////////////////////////////////////////////////
	var face_cnt 	= parseInt(Face_PrnCnt);
	var rider_cnt 	= parseInt(Rider_PrnCnt);
	var rider_prn_cnt = 0;

	//ORIGINAL Face_PrnCnt 만큼 loop를 돌아 title을 바꾼다.
	if(formType == "4" && formKntFlg == "Y" && face_cnt > 0){

		//////////////////  face >= rider
		if(face_cnt >= rider_cnt){
			for(var i=1; i< parseInt(Face_PrnCnt)+1;i++){
				/////////////////// FACE PRINT ////////////////////////////////////////
				var temp_rv = rdParam_Face_rv;
				temp_rv += "form_count["+i+"] "; // form_count

				Rdviewer_Face.SetMessageboxShow(1);
				Rdviewer_Face.FileOpen(strFacePath, RDServer + temp_rv + rdParam_Face);
				// alert(strFacePath+rdParam_Face);

				// return;
				// Face
				// Printer Driver Name : Face_PrnDrv
				// Print page : Face_PrnCnt
				// per 1 page : 1
				// hidden dialog popup : 4
				// Rdviewer_main.SetPrintInfo
//					Rdviewer_Face.SetPrintInfo(Face_PrnDrv, parseInt(Face_PrnCnt), 1, 4);
				Rdviewer_Face.SetPrintInfo(Face_PrnDrv, 1, 1, 4);
				Rdviewer_Face.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
						0, 100);
				Rdviewer_Face.CMPrint();

				/////////////////// RIDER PRINT ////////////////////////////////////////
				if (RiderPrintYn == true && i <= rider_cnt) {
					temp_rv = rdParam_Rider_rv;
					temp_rv += "form_count["+i+"] "; // form_count
					Rdviewer_Rider.SetMessageboxShow(1);
					Rdviewer_Rider.FileOpen(strRiderPath, RDServer + temp_rv + rdParam_Rider);
					// Rider
					// Printer Driver Name : Face_PrnDrv
					// Print page : Face_PrnCnt
					// per 1 page : 1
					// hidden dialog popup : 4
					// Rdviewer_main.SetPrintInfo
	//				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
					Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
					// alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt :
					// [" + Rider_PrnCnt + "]");
					Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
							0, 100);
					Rdviewer_Rider.CMPrint();
				}
			}
		}else{
			//////////////////  face < rider
			for(var i=1; i< parseInt(Face_PrnCnt)+1;i++){
				/////////////////// FACE PRINT ////////////////////////////////////////
				var temp_rv = rdParam_Face_rv;
				temp_rv += "form_count["+i+"] "; // form_count

				Rdviewer_Face.SetMessageboxShow(1);
				Rdviewer_Face.FileOpen(strFacePath, RDServer + temp_rv + rdParam_Face);
				// alert(strFacePath+rdParam_Face);

				// return;
				// Face
				// Printer Driver Name : Face_PrnDrv
				// Print page : Face_PrnCnt
				// per 1 page : 1
				// hidden dialog popup : 4
				// Rdviewer_main.SetPrintInfo
//					Rdviewer_Face.SetPrintInfo(Face_PrnDrv, parseInt(Face_PrnCnt), 1, 4);
				Rdviewer_Face.SetPrintInfo(Face_PrnDrv, 1, 1, 4);
				Rdviewer_Face.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
						0, 100);
				Rdviewer_Face.CMPrint();

				/////////////////// RIDER PRINT ////////////////////////////////////////
				if (RiderPrintYn == true) {
					temp_rv = rdParam_Rider_rv;
					temp_rv += "form_count["+i+"] "; // form_count
					Rdviewer_Rider.SetMessageboxShow(1);
					Rdviewer_Rider.FileOpen(strRiderPath, RDServer + temp_rv + rdParam_Rider);
					// Rider
					// Printer Driver Name : Face_PrnDrv
					// Print page : Face_PrnCnt
					// per 1 page : 1
					// hidden dialog popup : 4
					// Rdviewer_main.SetPrintInfo
	//				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
					Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
					// alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt :
					// [" + Rider_PrnCnt + "]");
					Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
							0, 100);
					Rdviewer_Rider.CMPrint();
					rider_prn_cnt++;
				}
			}

			/////////////////// RIDER ADD PRINT ////////////////////////////////////////
			var rider_add_cnt = rider_cnt - rider_prn_cnt;
			if(RiderPrintYn == true && rider_add_cnt > 0){
				temp_rv = rdParam_Rider_rv;
				temp_rv += "form_count[] "; // form_count
				Rdviewer_Rider.SetMessageboxShow(1);
				Rdviewer_Rider.FileOpen(strRiderPath, RDServer + temp_rv + rdParam_Rider);
				// Rider
				// Printer Driver Name : Face_PrnDrv
				// Print page : Face_PrnCnt
				// per 1 page : 1
				// hidden dialog popup : 4
				// Rdviewer_main.SetPrintInfo
				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, rider_add_cnt, 1, 4);
//				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
				// alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt :
				// [" + Rider_PrnCnt + "]");
				Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
						0, 100);
				Rdviewer_Rider.CMPrint();
			}
		}

		////////////// House B/L ////////////////////////////////////////
		if ((formObject.nvocc_only_yn.disabled == false && formObject.nvocc_only_yn.checked == true)
				|| (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true)) {
			rdParam_Hb = "/rv form_bkgNo[( '" + bkgNo + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";
			strHbPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D.mrd";
			Rdviewer_Hb.SetMessageboxShow(1);
			Rdviewer_Hb.FileOpen(strHbPath, RDServer + rdParam_Hb);
			Rdviewer_Hb.SetPrintInfo(Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
//			Rdviewer_Hb.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
			Rdviewer_Hb.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1, 0,
					100);
			Rdviewer_Hb.CMPrint();
		}
	//FACE+RIDER 쌍으로 처리
	}else{
		rdParam_Face_rv += "form_count[] "; // form_count
		rider_prn_cnt = 0;

		Rdviewer_Face.SetMessageboxShow(1);
		Rdviewer_Face.FileOpen(strFacePath, RDServer + rdParam_Face_rv + rdParam_Face);
		// alert(strFacePath+rdParam_Face);
		if (RiderPrintYn) {

			rdParam_Rider_rv += "form_count[] "; // form_count
			// alert("RiderPrintYn : [" + RiderPrintYn + "]");
			Rdviewer_Rider.SetMessageboxShow(1);
			Rdviewer_Rider.FileOpen(strRiderPath, RDServer + rdParam_Rider_rv + rdParam_Rider);
		}

		//////////////////face >= rider
		if(face_cnt >= rider_cnt){
			for(var i=1; i< face_cnt+1;i++){
				// Face
				// Printer Driver Name : Face_PrnDrv
				// Print page : Face_PrnCnt
				// per 1 page : 1
				// hidden dialog popup : 4
				// Rdviewer_main.SetPrintInfo
//				Rdviewer_Face.SetPrintInfo(Face_PrnDrv, parseInt(Face_PrnCnt), 1, 4);
				Rdviewer_Face.SetPrintInfo(Face_PrnDrv, 1, 1, 4);
				// alert("Face_PrnDrv : [" + Face_PrnDrv + "]\n\n" + "Face_PrnCnt : [" +
				// Face_PrnCnt + "]");
				Rdviewer_Face.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
						0, 100);
				Rdviewer_Face.CMPrint();

				/////////////////// RIDER PRINT ////////////////////////////////////////
				if (RiderPrintYn == true && i <= rider_cnt) {
					// Rider
					// Printer Driver Name : Face_PrnDrv
					// Print page : Face_PrnCnt
					// per 1 page : 1
					// hidden dialog popup : 4
					// Rdviewer_main.SetPrintInfo
//					Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
					Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
					// alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt :
					// [" + Rider_PrnCnt + "]");
					Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
							0, 100);
					Rdviewer_Rider.CMPrint();
				}
			}
		}else{
		//////////////////face < rider
			for(var i=1; i< face_cnt+1;i++){
				/////////////////// FACE PRINT ////////////////////////////////////////
				// Face
				// Printer Driver Name : Face_PrnDrv
				// Print page : Face_PrnCnt
				// per 1 page : 1
				// hidden dialog popup : 4
				// Rdviewer_main.SetPrintInfo
//				Rdviewer_Face.SetPrintInfo(Face_PrnDrv, parseInt(Face_PrnCnt), 1, 4);
				Rdviewer_Face.SetPrintInfo(Face_PrnDrv, 1, 1, 4);
				// alert("Face_PrnDrv : [" + Face_PrnDrv + "]\n\n" + "Face_PrnCnt : [" +
				// Face_PrnCnt + "]");
				Rdviewer_Face.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
						0, 100);
				Rdviewer_Face.CMPrint();

				/////////////////// RIDER PRINT ////////////////////////////////////////
				if (RiderPrintYn == true) {
					// Rider
					// Printer Driver Name : Face_PrnDrv
					// Print page : Face_PrnCnt
					// per 1 page : 1
					// hidden dialog popup : 4
					// Rdviewer_main.SetPrintInfo
//					Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
					Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
					// alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt :
					// [" + Rider_PrnCnt + "]");
					Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
							0, 100);
					Rdviewer_Rider.CMPrint();
					rider_prn_cnt++;
				}

			}
			/////////////////// RIDER ADD PRINT ////////////////////////////////////////
			var rider_add_cnt = rider_cnt - rider_prn_cnt;
			if (RiderPrintYn == true && rider_add_cnt > 0) {
				// Rider
				// Printer Driver Name : Face_PrnDrv
				// Print page : Face_PrnCnt
				// per 1 page : 1
				// hidden dialog popup : 4
				// Rdviewer_main.SetPrintInfo
				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, rider_add_cnt, 1, 4);
//				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4);
				// alert("Rider_PrnDrv : [" + Rider_PrnDrv + "]\n\n" + "Rider_PrnCnt :
				// [" + Rider_PrnCnt + "]");
				Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1,
						0, 100);
				Rdviewer_Rider.CMPrint();
			}
		}

		if ((formObject.nvocc_only_yn.disabled == false && formObject.nvocc_only_yn.checked == true)
				|| (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true)) {
			rdParam_Hb = "/rv form_bkgNo[( '" + bkgNo + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";
			strHbPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D.mrd";
			Rdviewer_Hb.SetMessageboxShow(1);
			Rdviewer_Hb.FileOpen(strHbPath, RDServer + rdParam_Hb);
			Rdviewer_Hb.SetPrintInfo(Rider_PrnDrv, parseInt(Rider_PrnCnt), 1, 4);
			Rdviewer_Hb.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1, 0,
					100);
			Rdviewer_Hb.CMPrint();
		}
	}
	// COPY NON NEGOTIABLE PRINT START
	if ((formType == "4" || formType == "5") && CopyYn == "Y") {
		formType = "8"; // COPY
		var blCpyNo = formObject.bl_cpy_no.value;
		rdParam_Face = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
		rdParam_Face += "form_type[" + formType + "] "; // form_type
		rdParam_Face += "form_dataOnly[" + formDataOnly + "] "; // form_dataOnly
		rdParam_Face += "form_manifest[" + formManifest + "] "; // form_manifest
		rdParam_Face += "form_usrId[" + formUserId + "] "; // form_usrId
		rdParam_Face += "form_mainOnly[" + formMainOnly + "] "; // form_mainOnly
		rdParam_Face += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
		rdParam_Face += "form_level[(" + formRate + ")] "; // form_level
		rdParam_Face += "form_remark[" + formRemark + "] "; // form_remark
		rdParam_Face += "form_Cntr[" + formCntr + "] "; // form_Cntr
		rdParam_Face += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
		rdParam_Face += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
		rdParam_Face += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
		rdParam_Face += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
		rdParam_Face += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
		rdParam_Face += "form_his_bl[" + formHisBl + "] "; // form_his_bl
		rdParam_Face += "form_rqst_via_cd[" + formRqstViaCd + "] "; // form_rqst_via_cd
		rdParam_Face += "form_his_bl_mkd[" + formHisBlMkd + "] "; // form_his_bl_mkd
		rdParam_Face += "form_end_no[" + totalPage + "]"; // form_end_no
		rdParam_Face += "form_path[" + getFileDownPath() + "]"; // form_path
		rdParam_Face += "form_esig[" + formEsig + "] "; // form_esig
		rdParam_Face += "form_cpy_esig[" + formCpyEsig + "] "; // form_cpy_esig
		rdParam_Face += "form_knt_flg[] "; // form_knt_flg
		rdParam_Face += "form_count[] "; // form_knt_flg
		rdParam_Face += "/rp [" + formCaYn + "] "; // form_caYn
		rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
		// adjust position down 2.5mm in case of BOMBB, DELBS, MAABS
		if (formOfcCd == "BOMBB" || formOfcCd == "DELBS"
				|| formOfcCd == "MAABS") {
			rdParam_Face += " /rpypos [25]";
		} // /rprncenteropt [1]
		// Rider
		if ((formObject.rider_only_yn.disabled == false && formObject.rider_only_yn.checked == true)
				|| (formObject.rider_nvocc_yn.disabled == false && formObject.rider_nvocc_yn.checked == true)) {
			// Rider Print
			RiderPrintYn = true;
			if (getRadioValue2(form.paper_type) == '1') {
				strRiderPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_A4_Rider.mrd";
			} else if (getRadioValue2(form.paper_type) == '4') {
				strRiderPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_LETTER_Rider.mrd";
			} else if (getRadioValue2(form.paper_type) == '10') {
				strRiderPath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DOT_Rider.mrd";
			}
			rdParam_Rider = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
			rdParam_Rider += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
			rdParam_Rider += "form_level[(" + formRate + ")] "; // form_level
			rdParam_Rider += "form_Rate[] "; // form_Rate
			rdParam_Rider += "form_Cntr[" + formCntr + "] "; // form_Cntr
			// rdParam_Rider += "form_gubun[M] "; // form_gubun
			rdParam_Rider += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
			rdParam_Rider += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
			rdParam_Rider += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
			rdParam_Rider += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
			rdParam_Rider += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
			rdParam_Rider += "form_his_bl[" + formHisBl + "] "; // form_his_bl
			rdParam_Rider += "form_type [" + formType + "] "; // form_type
			rdParam_Rider += "form_rqst_via_cd [" + formRqstViaCd + "] "; // form_rqst_via_cd
			rdParam_Rider += "form_his_bl_mkd [" + formHisBlMkd + "] "; // form_his_bl_mkd
			rdParam_Rider += "form_end_no[" + totalPage + "]"; // form_end_no
			rdParam_Rider += "form_path[" + getFileDownPath() + "]";
			rdParam_Rider += "form_esig[" + formEsig + "] "; // form_esig
			rdParam_Rider += "form_cpy_esig[" + formCpyEsig + "] "; // form_cpy_esig
			rdParam_Rider += "form_knt_flg[] "; // form_knt_flg
			rdParam_Rider += "form_count[] "; // form_knt_flg
			rdParam_Rider += "/rp [" + formCaYn + "] "; // form_caYn
			rdParam_Rider += "/riprnmargin /rmatchprndrv [3]";
		}
		Rdviewer_Face.SetMessageboxShow(1);
		Rdviewer_Face.FileOpen(strFacePath, RDServer + rdParam_Face);
		if (RiderPrintYn) {
			Rdviewer_Rider.SetMessageboxShow(1);
			Rdviewer_Rider.FileOpen(strRiderPath, RDServer + rdParam_Rider);
		}

		//COPY
		for(var i=1; i < parseInt(blCpyNo)+1; i++){
			//FACE
			Rdviewer_Face.SetPrintInfo(Face_PrnDrv, 1, 1, 4); // blCpyNo
			Rdviewer_Face.SetPrint2(parseInt(getRadioValue2(form.paper_type)),
					1, 0, 100);
			Rdviewer_Face.CMPrint();

			//RIDER
			if (RiderPrintYn == true) {
				Rdviewer_Rider.SetPrintInfo(Rider_PrnDrv, 1, 1, 4); // blCpyNo
				Rdviewer_Rider.SetPrint2(parseInt(getRadioValue2(form.paper_type)), 1, 0, 100);
				Rdviewer_Rider.CMPrint();
			}
		}
	}
	// COPY NON NEGOTIABLE PRINT END
}

// 전체 페이지 숫자를 알기위해 formMainOnly='N'로 하여 Face를 실행 한다.
function rdOpenStart(formObject, RiderYn, HBYn) {
	var Rdviewer_Total = document.form.report4;    // for IE11
	if (Rdviewer_Total == undefined) Rdviewer_Total = report4;    // for Chrome
	// ComOpenWait(true);
	var RiderPrintYn = false;
	var rdParam_Face = "";
	var rdParam_Rider = "";
	var rdParam_Hb = "";
	var strFacePath = "";
	var strRiderPath = "";
	var strHbPath = "";
	var bkgNo = formObject.bkg_no.value; // bkg_no
	var formType = form_type.GetSelectCode(); // form_type
	var formDataOnly = formObject.preview_yn.checked == true ? "N" : "Y"; // Preview
	var formManifest = formObject.form_manifest.value; // form_manifest
	var formUserId = formObject.usr_id.value; // form_usrId
	var formHiddenData = formObject.hiddenData.checked == true ? "Y" : "N"; // form_hiddeData
	var formOfcCd = formObject.ofc_cd.value; // ofc_cd
	var formRemark = ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)"); // form_remark
	formRemark = ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(
			formRemark, "\'", "'||CHR(39)||'"), "\"", "'||CHR(34)||'"), "\n",
			"'||CHR(10)||'"), "\r", "'||CHR(13)||'");
	var formRate = form_Rate.GetSelectCode(); // form_Rate
	var formCntr = form_Cntr.GetSelectCode(); // form_Cntr
	var formMainOnly = "N";
	var formCorrNo = formObject.bl_ca_yn.checked == true ? formObject.ca_no.GetSelectCode() : ""; // form_CorrNo
	var formHisCntr = formObject.bl_ca_yn.checked == true ? "BKG_CNTR_HIS" : "BKG_CONTAINER"; // form_his_cntr
	var formHisBkg = formObject.bl_ca_yn.checked == true ? "BKG_BKG_HIS" : "BKG_BOOKING"; // form_his_bkg
	var formHisMkd = formObject.bl_ca_yn.checked == true ? "BKG_BL_MK_DESC_HIS" : "BKG_BL_MK_DESC"; // form_his_mkd
	var formHisXpt = formObject.bl_ca_yn.checked == true ? "BKG_XPT_IMP_LIC_HIS" : "BKG_XPT_IMP_LIC"; // form_his_xpt
	var formHisBl = formObject.bl_ca_yn.checked == true ? "BKG_BL_DOC_HIS" : "BKG_BL_DOC"; // form_his_bl
	var formRqstViaCd = ""; // form_rqst_via_cd
	var formHisBlMkd = formObject.bl_ca_yn.checked == true ? "BKG_BL_ISS_HIS" : "BKG_BL_ISS"; // form_his_bl_mkd
	var formCaYn = formObject.bl_ca_yn.checked == true ? "Y" : ""; // form_caYn
	var Face_PrnDrv = bl_face_prn_dvc_nm.GetSelectCode(); // Print Setup (Face)
	var Face_PrnCnt = formObject.face_print_cnt.value; // Print Count (Face)
	var Rider_PrnDrv = bl_ridr_prn_dvc_nm.GetSelectCode(); // Print Setup (Rider)
	var Rider_PrnCnt = formObject.rider_print_cnt.value; // Print Count (Rider)
	// Face
	if (getRadioValue2(form.paper_type) == '1') {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
	} else if (getRadioValue2(form.paper_type) == '4') {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
	} else if (getRadioValue2(form.paper_type) == '10') {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_DOT.mrd";
	}
	rdParam_Face = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
	rdParam_Face += "form_type[" + formType + "] "; // form_type
	rdParam_Face += "form_dataOnly[" + formDataOnly + "] "; // form_dataOnly
	rdParam_Face += "form_manifest[" + formManifest + "] "; // form_manifest
	rdParam_Face += "form_usrId[" + formUserId + "] "; // form_usrId
	rdParam_Face += "form_mainOnly[" + formMainOnly + "] "; // form_mainOnly
	rdParam_Face += "form_hiddeData[" + formHiddenData + "] "; // form_hiddeData
	rdParam_Face += "form_level[(" + formRate + ")] "; // form_level
	rdParam_Face += "form_remark[" + formRemark + "] "; // form_remark
	rdParam_Face += "form_Cntr[" + formCntr + "] "; // form_Cntr
	rdParam_Face += "form_CorrNo[" + formCorrNo + "] "; // form_CorrNo
	rdParam_Face += "form_his_cntr[" + formHisCntr + "] "; // form_his_cntr
	rdParam_Face += "form_his_bkg[" + formHisBkg + "] "; // form_his_bkg
	rdParam_Face += "form_his_mkd[" + formHisMkd + "] "; // form_his_mkd
	rdParam_Face += "form_his_xpt[" + formHisXpt + "] "; // form_his_xpt
	rdParam_Face += "form_his_bl[" + formHisBl + "] "; // form_his_bl
	rdParam_Face += "form_rqst_via_cd[" + formRqstViaCd + "] "; // form_rqst_via_cd
	rdParam_Face += "form_his_bl_mkd[" + formHisBlMkd + "] "; // form_his_bl_mkd
	rdParam_Face += "form_path[" + getFileDownPath() + "] "; // form_path
	rdParam_Face += "form_esig[] "; // form_esig
	rdParam_Face += "form_cpy_esig[] "; // form_cpy_esig
	rdParam_Face += "form_knt_flg[] "; // form_knt_flg
	rdParam_Face += "form_count[] "; // form_count
	rdParam_Face += "/rp [" + formCaYn + "] "; // form_caYn
	rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
	// adjust position down 2.5mm in case of BOMBB, DELBS, MAABS
	if (formOfcCd == "BOMBB" || formOfcCd == "DELBS" || formOfcCd == "MAABS") {
		rdParam_Face += " /rpypos [25]";
	} // /rprncenteropt [1]
	Rdviewer_Total.FileOpen(strFacePath, RDServer + rdParam_Face);
	return Rdviewer_Total.GetTotalPageNo();
}
/** ********************* KEY EVENT START ******************* */
/**
 * obj key press event handling
 */
function bkg_keypress() {
	switch (ComGetEvent("dataformat")) {
	case "engup":
		// only upper case of Alphabet
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":
		// only Number, upper case of Alphabet
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "num":
		// only Number
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "custname":
		// only Number
		ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
		break;
	default:
	}
}

/** ********************* KEY EVENT END ******************* */
/**
 * setting print cnt
 */
function setPrintcnt() {
	var form_type_code = form_type.GetSelectCode();
	if (form_type_code == "0") {
		form.face_print_cnt.options[1].selected = true;
		form.rider_print_cnt.options[1].selected = true;
	} else if (form_type_code == "1") {
		form.face_print_cnt.options[5].selected = true;
		form.rider_print_cnt.options[5].selected = true;
	} else if (form_type_code == "2") {
		form.face_print_cnt.options[1].selected = true;
		form.rider_print_cnt.options[1].selected = true;
	} else if (form_type_code == "3") {
		form.face_print_cnt.options[obl_iss_knt].selected = true;
		form.rider_print_cnt.options[obl_iss_knt].selected = true;
	} else if (form_type_code == "4") {
		// if(save_face_print_cnt ==""){
		if (bl_cpy_knt == "0")
			form.face_print_cnt.options[3].selected = true;
		else
			form.face_print_cnt.options[eval(bl_cpy_knt)].selected = true;
		// }else{
		// form.face_print_cnt.options[eval(save_face_print_cnt)].selected =
		// true;
		// }
		if (save_rider_print_cnt == "") {
			if (bl_cpy_knt == "0")
				form.rider_print_cnt.options[3].selected = true;
			else
				form.rider_print_cnt.options[eval(bl_cpy_knt)].selected = true;
		} else {
			form.rider_print_cnt.options[eval(save_rider_print_cnt)].selected = true;
		}
		form.face_print_cnt.disabled = true;

		// form.rider_print_cnt.disabled = true;
		return;
		// form.face_print_cnt.options[3].selected = true;
		// form.rider_print_cnt.options[3].selected = true;
	} else if (form_type_code == "5") {
		form.face_print_cnt.options[1].selected = true;
		form.rider_print_cnt.options[1].selected = true;
	}
	form.face_print_cnt.disabled = false;
	form.rider_print_cnt.disabled = false;
}
// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject1 = sheetObjects[0];
	var form_type_code = form_type.GetSelectCode();

	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, MODIFY01);
			break;
		case "btn_Print":
			if (formObject.bkg_no.value == "") {
				ComShowCodeMessage('BKG00626', 'BKG No.');
				return false;
			}
			if (form_type.GetSelectCode() == '4' && obl_prn_flg == 'Y') {
				ComShowCodeMessage('BKG08091');
				return false;
			}

			ComOpenWait(true);
			rdStart();
			ComOpenWait(false);
			if (form_type_code == "4") {
				doActionIBSheet(sheetObject1, formObject, MODIFY03);
				obl_prn_flg = "Y";
			} else if (form_type_code == "5" || form_type_code == "6") {
				doActionIBSheet(sheetObject1, formObject, MODIFY04);
			}

			break;
		case "btn_Print_Release":
			if (formObject.bkg_no.value == "") {
				ComShowCodeMessage('BKG00626', 'BKG No.');
				return false;
			}
			if (form_type_code == "4") {
				if (org_ppd_rcv_cd != "Y" || org_n3pty_ppd_cd != "Y") {
					ComShowCodeMessage('BKG08079');
					return;
				}
			}
			if (print_release_yn != "Y") {
				ComShowCodeMessage('BKG00434');
				return;
			}
			ComOpenWait(true);
			rdStart();
			if (form_type_code == "4") {
				doActionIBSheet(sheetObject1, formObject, MODIFY02);
				formObject.obl_rlse_flg.value == "Y";
				obl_prn_flg = "Y";
			} else if (form_type_code == "5" || form_type_code == "6") {
				doActionIBSheet(sheetObject1, formObject, MODIFY04);
			}
			ComOpenWait(false);
			break;
		case "btn_Print_Setup":
			window.print();
			break;
		case "btn_Print_Setup1":
			window.print();
			break;
		case "btn_close":
			ComClosePopup();
			break;
		case "rider_only_yn":
			if (form.rider_only_yn.checked) {
				form.nvocc_only_yn.checked = false;
				form.rider_nvocc_yn.checked = false;
			}
			break;
		case "nvocc_only_yn":
			if (form.nvocc_only_yn.checked) {
				form.rider_only_yn.checked = false;
				form.rider_nvocc_yn.checked = false;
			}
			break;
		case "rider_nvocc_yn":
			if (form.rider_nvocc_yn.checked) {
				form.nvocc_only_yn.checked = false;
				form.rider_only_yn.checked = false;
			}
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
// retrieve print configure (1>2>3>3>5,2>3>2>3>5)
// BL_PRN_TP_CD||'>'||BL_PRN_CHG_TP_CD||'>'||
// BL_PRN_CNTR_TP_CD||'>'||BL_FACE_PRN_KNT||'>'||BL_RIDR_PRN_KNT
var bl_prn_setup = "";
var bl_prn_setup_Map = new Array();
/**
 * init print setup
 *
 * @param val
 * @return
 */
function setInitPrintSetup(val) {
	var formObj = document.form;
	if (val == "") {
		form_type.SetSelectCode('2');
		form_Rate.SetSelectCode('1');
		form_Cntr.SetSelectCode('1');
		pre_form_type = form_type.GetSelectCode();
		pre_container_type = form_Cntr.GetSelectCode();
		bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
		bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
		setPrintcnt();
		initYn = false;
		// form_signed setting
		formObj.signed_yn.disabled = false;
		formObj.copy_signed_yn.disabled = false;
		return;
	}
	bl_prn_setup = val;
	var arr_bl_prn_setup = bl_prn_setup.split("@");
	var arr_combo_setup = null;
	for ( var i = 0; i < arr_bl_prn_setup.length; i++) {
		arr_combo_setup = arr_bl_prn_setup[i].split(">");
		bl_prn_setup_Map[arr_combo_setup[0]] = arr_bl_prn_setup[i];
		if (arr_combo_setup[0] == '2') {
			form_type.SetSelectCode(arr_combo_setup[0]);
			pre_form_type = form_type.GetSelectCode();
			form_Rate.SetSelectCode(arr_combo_setup[1]);
			form_Cntr.SetSelectCode(arr_combo_setup[2]);
			form.face_print_cnt.options[arr_combo_setup[3]].selected = true;
			form.rider_print_cnt.options[arr_combo_setup[4]].selected = true;
			/** ********** Print Driver Setting ********************* */
			if (!checkPrintList(arr_combo_setup[5])) { // FACE_PRINT
				bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
			} else {
				bl_face_prn_dvc_nm.SetSelectCode(arr_combo_setup[5]);
			}
			if (!checkPrintList(arr_combo_setup[6])) {// RIDER_PRINT
				bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
			} else {
				bl_ridr_prn_dvc_nm.SetSelectCode(arr_combo_setup[6]);
			}
			/** ********** Print Driver Setting End ********************* */
		}
	}
	var form_type_code = form_type.GetSelectCode();
	var form_Cntr_code = form_Cntr.GetSelectCode();
	if (form_type_code != '2') {
		form_type.SetSelectCode('2');
		form_type_code = '2';
		form_Rate.SetSelectCode('1');
		form_Cntr.SetSelectCode('1');
		form_Cntr_code = '1';
		pre_form_type = form_type_code;
		pre_container_type = form_Cntr_code;
		bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
		bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
		setPrintcnt();
	}
	pre_container_type = form_Cntr.GetSelectCode();
	initYn = false;

	// form_signed setting
	if (form_type_code == "4" || form_type_code == "5") {
		formObj.signed_yn.disabled = false;
		formObj.copy_signed_yn.disabled = true;
	} else if(form_type_code == "2"){
		formObj.signed_yn.disabled = true;
		formObj.copy_signed_yn.disabled = false;
	} else {
		formObj.signed_yn.disabled = true;
		formObj.copy_signed_yn.disabled = true;
	}

}
/**
 * save print setup
 */
function savePrintSetup() {
	bl_prn_setup_Map[form_type.SetSelectCode] = form_type.GetSelectCode() + ">"
			+ form_Rate.GetSelectCode() + ">" + form_Cntr.GetSelectCode() + ">"
			+ ComGetObjValue(form.face_print_cnt) + ">"
			+ ComGetObjValue(form.rider_print_cnt) + ">"
			+ bl_face_prn_dvc_nm.GetSelectCode() + ">"
			+ bl_ridr_prn_dvc_nm.GetSelectCode();
}// org_ppd_rcv_cd != "C" 
/**
 * setting button for print release
 */
function setBtn_Print_Release() {
	if (form_type.GetSelectCode() == '4' && form.obl_rlse_flg.value != "Y") {
		if (org_ppd_rcv_cd != "Y" || org_n3pty_ppd_cd != "Y"
			|| print_release_yn != "Y") {
			if(org_ppd_rcv_cd != "C" || org_n3pty_ppd_cd != "C"){
				ComBtnDisable("btn_Print_Release");
				return;
			}
		}
		ComBtnEnable("btn_Print_Release");
	} else {
		ComBtnDisable("btn_Print_Release");
	}
}
var initYn = true;
/**
 * form tyep change handling
 *
 * @param comboObj
 * @return
 */
function form_type_OnChange(comboObj) {
	setBtn_Print_Release();
	if (initYn)
		return;
	var formObject = document.form;
	if (comboObj.GetSelectCode() == '4' && bl_tp_cd == 'W') {
		ComShowCodeMessage('BKG08089');
		form_type.SetSelectCode(pre_form_type);
		return;
	} else if (comboObj.GetSelectCode() == '4' && obl_iss_flg == 'N') {
		ComShowCodeMessage('BKG08090');
		form_type.SetSelectCode(pre_form_type);
		return;
	} else if (comboObj.GetSelectCode() == '4' && obl_prn_flg == 'Y') {
		ComShowCodeMessage('BKG08091');
		form_type.SetSelectCode(pre_form_type);
		return;
	} else if (comboObj.GetSelectCode() == '4'
			&& form.obl_rlse_flg.value == 'Y') {
		ComShowCodeMessage('BKG08098');
		form_type.SetSelectCode(pre_form_type);
		return;
	} else if ((comboObj.GetSelectCode() == '5' || comboObj.GetSelectCode() == '6')
			&& bl_tp_cd != 'W') {
		ComShowCodeMessage('BKG08092');
		form_type.SetSelectCode(pre_form_type);
		return;
	}
	// form_signed setting
	if (comboObj.GetSelectCode() == "4" || comboObj.GetSelectCode() == "5") {
		formObject.signed_yn.disabled = false;
		formObject.copy_signed_yn.disabled = true;
	} else if(comboObj.GetSelectCode() == "2"){
		formObject.signed_yn.disabled = true;
		formObject.copy_signed_yn.disabled = false;
	} else {
		formObject.signed_yn.disabled = true;
		formObject.copy_signed_yn.disabled = true;
	}
	pre_form_type = comboObj.GetSelectCode();
	if (bl_prn_setup_Map[comboObj.GetSelectCode()] == undefined) {
		form_Rate.SetSelectCode('1');
		form_Cntr.SetSelectCode('1');
		pre_container_type = form_Cntr.GetSelectCode();
		bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
		bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
		setPrintcnt();
		return;
	}
	var arr_combo_setup = bl_prn_setup_Map[comboObj.GetSelectCode()].split(">");
	form_Rate.SetSelectCode(arr_combo_setup[1]);
	form_Cntr.SetSelectCode(arr_combo_setup[2]);
	pre_container_type = form_Cntr.GetSelectCode();
	if (comboObj.GetSelectCode() == '4') {
		if (arr_combo_setup[3] != "")
			save_face_print_cnt = arr_combo_setup[3];
		if (arr_combo_setup[4] != "")
			save_rider_print_cnt = arr_combo_setup[4];
		setPrintcnt();// default setting in case of Original B/L
	} else {
		form.face_print_cnt.options[arr_combo_setup[3]].selected = true;
		form.rider_print_cnt.options[arr_combo_setup[4]].selected = true;
		form.face_print_cnt.disabled = false;
		form.rider_print_cnt.disabled = false;
	}
	/** ********** Print Driver Setting ********************* */
	if (!checkPrintList(arr_combo_setup[5])) { // FACE_PRINT
		bl_face_prn_dvc_nm.SetSelectCode(defaultPrint);
	} else {
		bl_face_prn_dvc_nm.SetSelectCode(arr_combo_setup[5]);
	}
	if (!checkPrintList(arr_combo_setup[6])) {// RIDER_PRINT
		bl_ridr_prn_dvc_nm.SetSelectCode(defaultPrint);
	} else {
		bl_ridr_prn_dvc_nm.SetSelectCode(arr_combo_setup[6]);
	}
	/** ********** Print Driver Setting End ********************* */
	// if( comboObj.Code == "4" && formObject.obl_rlse_flg.value == "Y"){
	// ComShowCodeMessage("BKG02019");
	// }
}
/**
 * form rate change handling
 *
 * @param comboObj
 * @return
 */
function form_Rate_OnChange(comboObj) {
	if (initYn)
		return;
	if (bl_prn_setup_Map[comboObj.GetSelectCode()] == undefined) {
		setPrintcnt();
	}
	Retrive(sheetObjects[0]);
}
var pre_cntr_setup_flag = false;
/**
 * form Container change handling
 *
 * @param comboObj
 * @return
 */
function form_Cntr_OnChange(comboObj) {
	if (initYn)
		return;
	var formObject = document.form;
	if (pre_cntr_setup_flag) {
		pre_cntr_setup_flag = false;
		return;
	}
	if (comboObj.GetSelectCode() == "4" && bb_cgo_flg == "N") {
		ComShowCodeMessage("BKG08093");
		pre_cntr_setup_flag = true;
		comboObj.SetSelectCode(pre_container_type);
		return;
	}
	if (bl_prn_setup_Map[comboObj.GetSelectCode()] == undefined) {
		setPrintcnt();
	}
	pre_container_type = form_Cntr.GetSelectCode();
	Retrive(sheetObjects[0]);
}
/**
 * Sheet process handling
 *
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param Row
 * @param Col
 * @param PageNo
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH;
		sheetObj.RemoveAll();
		sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(1);
		var sXmls = sheetObj.GetSearchData("ESM_BKG_0743GS.do",
				FormQueryString(formObj));
		var arrSXml = sXmls.split("|$$|");
		var sXml = arrSXml[0];
		sheetObj.LoadSearchData(sXml, {
			Sync : 1
		});
		sheetObj.SetWaitImageVisible(0);
		// sheetObj.RenderSheet(1);
		if (firstYn == false) {
			ComXml2ComboItem(sXml, formObj.ca_no, "corr_no", "corr_no");
			firstYn = true;
		}
		ComXml2ComboItem(arrSXml[1], form_type, "val", "name");
		ComXml2ComboItem(arrSXml[2], form_Rate, "val", "name");
		ComXml2ComboItem(arrSXml[3], form_Cntr, "val", "name");
		bl_tp_cd = ComGetEtcData(sXml, "bl_tp_cd");
		setInitPrintSetup(ComGetEtcData(sXml, "bl_prn_setup"));
		// if(ComGetEtcData(sXml, "bl_tp_cd") == "W"){
		// formObj.form_type.DeleteItem('4');
		// }else if(ComGetEtcData(sXml, "bl_tp_cd") == ""){
		// formObj.form_type.DeleteItem('5');
		// formObj.form_type.DeleteItem('6');
		// }
		// /************ Print Driver Setting **********************/
		// if(ComGetEtcData(sXml, "bl_face_prn_dvc_nm") == undefined){
		// form.bl_face_prn_dvc_nm.Code = defaultPrint;
		// form.bl_ridr_prn_dvc_nm.Code = defaultPrint;
		// }else{
		// if(!checkPrintList(ComGetEtcData(sXml, "bl_face_prn_dvc_nm"))){
		// form.bl_face_prn_dvc_nm.Code = defaultPrint;
		//
		// }else{
		// form.bl_face_prn_dvc_nm.Code = ComGetEtcData(sXml,
		// "bl_face_prn_dvc_nm");
		// }
		//
		// if(!checkPrintList(ComGetEtcData(sXml, "bl_ridr_prn_dvc_nm"))){
		// form.bl_ridr_prn_dvc_nm.Code = defaultPrint;
		// }else{
		// form.bl_ridr_prn_dvc_nm.Code = ComGetEtcData(sXml, " ");
		// }
		// }
		// /************ Print Driver Setting End **********************/
		var rider_only_yn = ComGetEtcData(sXml, "rider_only_yn");
		var nvocc_only_yn = ComGetEtcData(sXml, "nvocc_only_yn");
		org_ppd_rcv_cd = ComGetEtcData(sXml, "org_ppd_rcv_cd");
		org_n3pty_ppd_cd = ComGetEtcData(sXml, "org_n3pty_ppd_cd");
		obl_iss_knt = ComGetEtcData(sXml, "obl_iss_knt");
		obl_iss_flg = ComGetEtcData(sXml, "obl_iss_flg");
		obl_prn_flg = ComGetEtcData(sXml, "obl_prn_flg");
		bb_cgo_flg = ComGetEtcData(sXml, "bb_cgo_flg");
		bl_cpy_knt = ComGetEtcData(sXml, "bl_cpy_knt");
		conti_cd = ComGetEtcData(sXml, "conti_cd");
		print_release_yn = ComGetEtcData(sXml, "print_release_yn");
		bl_esig_flg = ComGetEtcData(sXml, "bl_esig_flg");
		bl_cpy_esig_flg = ComGetEtcData(sXml, "bl_cpy_esig_flg");
		formObj.bl_knt_flg.value = ComGetEtcData(sXml, "bl_knt_flg");
		if (conti_cd == 'M') {
			formObj.paper_type[1].checked = true;
		}
		formObj.obl_rlse_flg.value = ComGetEtcData(sXml, "obl_rlse_flg");
		// alert("rider_only_yn : [" + rider_only_yn + "]\n\n" + "nvocc_only_yn
		// : [" + nvocc_only_yn + "]");
		// checked
		// if(rider_only_yn == "Y" && nvocc_only_yn == "Y"){
		// formObj.rider_nvocc_yn.checked = true;
		formObj.bl_cpy_no.value = ComGetEtcData(sXml, "bl_cpy_no");
		if (rider_only_yn == "Y") {
			formObj.rider_only_yn.checked = true;
		} else if (nvocc_only_yn == "Y") {
			// formObj.nvocc_only_yn.checked = true;
		} else if (rider_only_yn == "N") {
			formObj.rider_only_yn.checked = false;
		} else if (nvocc_only_yn == "N") {
			// formObj.nvocc_only_yn.checked = false;
		} else {
			// formObj.rider_nvocc_yn.checked = false;
		}

		if(bl_esig_flg == "Y") {
			formObj.signed_yn.checked = true;
		}
		if(bl_cpy_esig_flg == "Y") {
			formObj.copy_signed_yn.checked = true;
		}


		// disable
		if (rider_only_yn != "Y" || nvocc_only_yn != "Y") {
			// formObj.rider_nvocc_yn.disabled = true;
			if (rider_only_yn != "Y") {
				formObj.rider_only_yn.disabled = true;
			} else {
				formObj.rider_only_yn.disabled = false;
			}
			if (nvocc_only_yn != "Y") {
				// formObj.nvocc_only_yn.disabled = true;
			} else {
				// formObj.nvocc_only_yn.disabled = false;
			}
		}
		break;
	case SEARCH01: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH01;
		// sheetObj.RemoveAll();
		// sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(1);
		var sXml = sheetObj.GetSearchData("ESM_BKG_0743GS.do",
				FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml, {
			Sync : 1
		});
		sheetObj.SetWaitImageVisible(0);
		// sheetObj.RenderSheet(1);
		var rider_only_yn = ComGetEtcData(sXml, "rider_only_yn");
		var nvocc_only_yn = ComGetEtcData(sXml, "nvocc_only_yn");
		// checked
		// if(rider_only_yn == "Y" && nvocc_only_yn == "Y"){
		// formObj.rider_nvocc_yn.checked = true;
		if (rider_only_yn == "Y") {
			formObj.rider_only_yn.checked = true;
		} else if (nvocc_only_yn == "Y") {
			// formObj.nvocc_only_yn.checked = true;
		} else if (rider_only_yn == "N") {
			formObj.rider_only_yn.checked = false;
		} else if (nvocc_only_yn == "N") {
			// formObj.nvocc_only_yn.checked = false;
		} else {
			// formObj.rider_nvocc_yn.checked = false;
		}
		// disable
		if (rider_only_yn != "Y" || nvocc_only_yn != "Y") {
			// formObj.rider_nvocc_yn.disabled = true;
			if (rider_only_yn != "Y") {
				formObj.rider_only_yn.disabled = true;
			} else {
				formObj.rider_only_yn.disabled = false;
			}
			if (nvocc_only_yn != "Y") {
				// formObj.nvocc_only_yn.disabled = true;
			} else {
				// formObj.nvocc_only_yn.disabled = false;
			}
		}
		break;
	case MODIFY01: // Save
		formObj.f_cmd.value = MODIFY01;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		var sParam = "&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveData("ESM_BKG_0743GS.do", sParam);
		if (ComGetEtcData(sXml, "success_yn") == "Y") {
			savePrintSetup();
			ComShowCodeMessage('COM130102', 'Data');
		} else {
			ComShowCodeMessage('COM130103', 'Data');
		}
		break;
	case MODIFY02: // OBL_PRN_FLG, OBL_RLSE_FLG Update
		formObj.f_cmd.value = MODIFY02;
		var sParam = "&obl_prn_flg=Y&released=Y&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveData("ESM_BKG_0743GS.do", sParam);
		if (ComGetEtcData(sXml, "success_yn") != "Y") {
			ComShowCodeMessage('COM130103', 'Data');
		} else {
			if (!opener)
				opener = parent;
			if (opener.name == "t8frame") { // In case of openning in ESM_BKG_0079_09
				var openerDocObj = opener.document;
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').value = "Y";
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').style.color = "red";
				openerDocObj.getElementById('frm_t11sheet1_released').value = "Y";
				openerDocObj.getElementById('frm_t11sheet1_released').style.color = "red";
			} else if (opener.name = "PopupEsmBkg0927") { // In case of openning in ESM_BKG_0927
				var openerDocObj = opener.opener.document.getElementById("t8frame").contentWindow.document;
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').value = "Y";
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').style.color = "red";
				openerDocObj.getElementById('frm_t11sheet1_released').value = "Y";
				openerDocObj.getElementById('frm_t11sheet1_released').style.color = "red";
			}
		}
		break;
	case MODIFY03: // OBL_PRN_FLG Update
		formObj.f_cmd.value = MODIFY02;
		var sParam = "&obl_prn_flg=Y&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveData("ESM_BKG_0743GS.do", sParam);
		if (ComGetEtcData(sXml, "success_yn") != "Y") {
			ComShowCodeMessage('COM130103', 'Data');
		} else {

			if (!opener)
				opener = parent;
			if (opener.name == "t8frame") { // In case of openning in ESM_BKG_0079_09
				var openerDocObj = opener.document;
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').value = "Y";
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').style.color = "red";
			} else if (opener.name = "PopupEsmBkg0927") { // In case of openning in ESM_BKG_0927
				var openerDocObj = opener.opener.document.getElementById("t8frame").contentWindow.document;
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').value = "Y";
				openerDocObj.getElementById('frm_t11sheet1_obl_prn_flg').style.color = "red";
			}
		}
		break;
	case MODIFY04: // WBL_PRN_FLG Update
		formObj.f_cmd.value = MODIFY03;
		var sParam = "&wbl_prn_flg=Y&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveData("ESM_BKG_0743GS.do", sParam);
		if (ComGetEtcData(sXml, "success_yn") != "Y") {
			ComShowCodeMessage('COM130103', 'Data');
		}
		break;
	}
}
/**
 * handling process for input validation
 *
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (formObj.bkg_no.value == "") {
			ComShowCodeMessage('BKG00626', 'BKG No.');
			return false;
		}
		break;
	case MODIFY01:
		if (bl_face_prn_dvc_nm.GetSelectCode() == "") {
			ComShowCodeMessage('BKG00626', 'Print Setup(Face)');
			return false;
		}
		break;
	}
	return true;
}

/**
 * setting sheet initial values and header
 *
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1 = "Sel|Group|User ID|User Name";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				DataRowMerge : 1
			});

			var info = {
				Sort : 1,
				ColMove : 1,
				HeaderCheck : 1,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			// var cols = [ ];
			//
			// InitColumns(cols);
			// SetSheetHeight(150);
			// SetEditable(1);
		}
		break;
	}
}
/**
 * CA No change handling
 *
 * @param ComboObj
 * @param Index_Code
 * @param Text
 * @return
 */
function ca_no_OnChange(ComboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt,
		NewCod) {
	var formObject = document.form;
	if (formObject.bl_ca_yn.checked) {
		var bComboUC = ComboObj.GetSelectCode();
		// ComboObj.UseCode == true ? false : true;
		// alert("Index_Code : [" + Index_Code + "]\n\n" + "Text : [" +
		// ComboObj.Text + "]");
		formObject.corr_no.value = ComboObj.GetSelectCode();
		Retrive(sheetObjects[0]);
		// ComboObj.UseCode = bComboUC;
	}
}
