/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7024.js.js
 *@FileTitle : IHC Tariff Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2013.08.06 전윤주 [CHM-201326196] TRO 화면에서 Over weight팝업 호출 시 Local curr.로 조회되도록 변경
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7024() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Close":
			self.close();
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}
	if(document.form.open_page.value == "7004" || document.form.open_page.value == "7003"){
		sheetObjects[0].ColHidden("rc_svc_flg") = true ; 
		sheetObjects[0].ColHidden("rf_rt_amt") = true ; 
		sheetObjects[0].ColHidden("rf_rt_rto") = true ; 
		sheetObjects[0].ColHidden("dcgo_svc_flg") = true ; 
		sheetObjects[0].ColHidden("dg_rt_amt") = true ; 
		sheetObjects[0].ColHidden("dg_rt_rto") = true ; 
		if(document.form.open_page.value == "7004"){
			sheetObjects[0].ColHidden("ovr_wgt_rt_amt") = true ;
			usd_display.style.display = "none";
		}
	}
	if (document.form.open_page.value != "7004"){
		sheetObjects[0].ColHidden("locl_curr_cd") = true ;
		sheetObjects[0].ColHidden("locl_ovr_wgt_rt_amt") = true ;
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			style.height = 365;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = false;
			InitRowInfo(2, 1, 3, 100);
			var HeadTitle1 = "||Trans\nMode|EQ Size.|SVC|DG|DG|WSC\nApply|Overweight(Ton)|Overweight(Ton)|Overweight(Ton)|Overweight(Ton)|Overweight(Ton)|Overweight(Ton)";
			var HeadTitle2 = "||Trans\nMode|EQ Size.|SVC|Fixed|%|WSC\nApply|From|To|Curr.|Fixed|Fixed|%";

			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter,	true, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "prc_trsp_mod_cd");
			InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, "prc_trsp_mod_cd_nm", 		false, "", dfNone, 		0, false, false);
			InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, "prc_inlnd_trf_cntr_tpsz_cd",	false, "", dfNone, 		0, false, false);
			InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, "dcgo_svc_flg", 				false, "", dfNone,      0, false, false);
			InitDataProperty(0, cnt++, dtData, 			70, 	daRight, 	true, "dg_rt_amt", 					false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			40, 	daRight, 	true, "dg_rt_rto", 					false, "", dfNullFloat, 1, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, "ovr_wgt_cgo_svc_flg", 		false, "", dfNone,      0, false, false);
			InitDataProperty(0, cnt++, dtData, 			70, 	daRight, 	true, "min_cgo_wgt", 				false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			70, 	daRight, 	true, "max_cgo_wgt", 				false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, "locl_curr_cd", 				false, "", dfNone,      0, false, false);
			InitDataProperty(0, cnt++, dtData, 			70, 	daRight, 	true, "locl_ovr_wgt_rt_amt", 		false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			70, 	daRight, 	true, "ovr_wgt_rt_amt", 			false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			40, 	daRight, 	true, "ovr_wgt_rt_rto", 			false, "", dfNullFloat, 1, false, false, 9);
		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, document.form, sAction)) {
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.WaitImageVisible = false;
				sheetObj.DoSearch("ESM_PRI_7024GS.do", FormQueryString(formObj));
			} 
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}

function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (formObj.svc_scp_cd.value == "") {
			ComShowCodeMessage("COM130403", "Service Scope");
			return false;
		}
		if (formObj.ihc_trf_no.value == "") {
			ComShowCodeMessage("COM130403", "IHC Tariff No");
			return false;
		}
		break;
	}
	return true;
}