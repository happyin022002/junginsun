/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0840.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
// 공통전역변수
var docObjects=new Array();
var sheetCnt=0;
//var rdObjects=new Array();
//var rdCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Close":
			ComClosePopup();
			break;
		case "btn_Print":
			viewer.print({isServerSide:true});
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var sXml="";
	// var opener_obj = window.dialogArguments;
	var opener_obj=opener;
	var opener_sheet_obj1= opener_obj.sheet1;
	var form=opener_obj.form;
	var vTransType="";
	if (form.rpt_flag[0].checked) {
		vTransType="Full (A6A)";
	} else if (form.rpt_flag[1].checked) {
		vTransType="Empty (A6A)";
	} else if (form.rpt_flag[2].checked) {
		vTransType="Vessel (A6)";
	}
	var vSendDate="";
	if (form.s_snd_dt.value != "") {
		vSendDate=form.s_snd_dt.value + "~" + form.e_snd_dt.value
	}
	var vRcvDate="";
	if (form.s_rcv_dt.value != "") {
		vRcvDate=form.s_rcv_dt.value + "~" + form.s_rcv_dt.value
	}
	sXml="<?xml version='1.0' ?><SHEET>";
	// sXml +="<SHEET1>";
	sXml += RD_GetDataSearchXml(opener_sheet_obj1, 1);
	// sXml +="</SHEET1>";
	sXml += "<ETC>";
	sXml += "<TRANS_TYPE>" + vTransType + "</TRANS_TYPE>"
	sXml += "<VVD>" + form.vvd_cd.value + "</VVD>"
	sXml += "<POL>" + form.pol_cd.value + "</POL>"
	sXml += "<POD>" + form.pod_cd.value + "</POD>"
	sXml += "<SEND_DATE>" + vSendDate + "</SEND_DATE>"
	sXml += "<A6A_BL>"
			+ form.cstms_trsm_sts_cd[form.cstms_trsm_sts_cd.selectedIndex].text
			+ "</A6A_BL>"
	sXml += "<BLNO>" + form.bl_no.value + "</BLNO>"
	sXml += "<RCV_DATE>" + vRcvDate + "</RCV_DATE>"
	sXml += "<MANIFEST_TTL>[" + form.frm_manifest_ttl.value
			+ "]</MANIFEST_TTL>"
	sXml += "<SENT_BY_A6A>[" + form.frm_sent_by_a6a.value + "]</SENT_BY_A6A>"
	sXml += "<SENT_BY_AL>[" + form.frm_sent_by_al.value + "]</SENT_BY_AL>"
	sXml += "<TARGET_TTL>[" + form.frm_target_ttl.value + "]</TARGET_TTL>"
	sXml += "<UNMANIFEST>[" + form.frm_unmanifest.value + "]</UNMANIFEST>"
	sXml += "<TOTAL>" + form.frm_total.value + "</TOTAL>"
	sXml += "<PROCESSED>" + form.frm_processed.value + "</PROCESSED>"
	sXml += "<ERROR>" + form.frm_error.value + "</ERROR>"
	sXml += "</ETC>";
	sXml += "</SHEET>";
//	rdObjects[0].AutoAdjust=true;
	//rdObjects[0].HideToolBar();
//	rdObjects[0].HideStatusBar();
//	rdObjects[0].ViewShowMode(0);
//	rdObjects[0].SetBackgroundColor(128, 128, 128);
//	rdObjects[0].SetPageLineColor(128, 128, 128);
	viewer.setRData(sXml);
//	rdObjects[0].ApplyLicense("0.0.0.0");
	viewer.openFile( RD_path + 'apps/opus/esm/bkg/customsdeclaration/customsreport/canada/report/ESM_BKG_0840.mrd', RDServer,{timeout:1800});
}
