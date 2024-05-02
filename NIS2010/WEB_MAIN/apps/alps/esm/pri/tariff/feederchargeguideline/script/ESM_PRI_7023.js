/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7023.js.js
 *@FileTitle : EUR Add-on Guideline Creation & Amendment – Special Pop up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7023() {
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
			var HeadTitle1 = "|EQ Size.|Reefer|Reefer|DG|DG|Overweight(Ton)|Overweight(Ton)|Overweight(Ton)|Overweight(Ton)";
			var HeadTitle2 = "|EQ Size.|Fixed\n(USD)|%|Fixed\n(USD)|%|From|To|Fixed\n(USD)|%";

			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter,	true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 			60, 		daCenter, 	true, "prc_inlnd_trf_cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, "rf_rt_amt", 					false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			40, 	daRight, 	true, "rf_rt_rto", 					false, "", dfNullFloat, 1, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			80,	daRight, 	true, "dg_rt_amt", 					false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			40, 	daRight, 	true, "dg_rt_rto", 					false, "", dfNullFloat, 1, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, "min_cgo_wgt", 				false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, "max_cgo_wgt", 				false, "", dfNullFloat, 2, false, false, 18);
			InitDataProperty(0, cnt++, dtData, 			80,	daRight, 	true, "ovr_wgt_rt_amt", 			false, "", dfNullFloat, 2, false, false, 18);
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
				sheetObj.DoSearch("ESM_PRI_7023GS.do", FormQueryString(formObj));
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
		if (formObj.svcScpCd.value == "") {
			ComShowCodeMessage("COM130403", "Service Scope");
			return false;
		}
		if (formObj.fdrTrfNo.value == "") {
			ComShowCodeMessage("COM130403", "Feeder Tariff Number");
			return false;
		}
		break;
	}
	return true;
}