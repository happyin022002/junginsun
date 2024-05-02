/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0851.js
*@FileTitle  : Amendment Transmission to Korean Customs Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0851()
{
	this.processButtonClick=processButtonClick;
	this.loadPage=loadPage;
	this.rdOpen=rdOpen;
}
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Close":
			ComClosePopup();
			break;
		case "btn_Print":
			viewer.print({isServerSide:true});
			break;
		} // end switch
	}catch(e) {
	}
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	rdOpen();
}
/**
 * print화면 오픈
 * print화면 오픈
 * print할수 있는 화면 오픈
 */
function rdOpen(){
	var sXml="";
	var opener_obj=opener;
	var form=opener_obj.document.form;
	var opener_sheet_obj1=opener_obj.sheetObjects[0];
	sXml="<?xml version='1.0' ?><SHEET>";
	sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
	sXml +="<ETC>" ;
	sXml +="<MRN_NO>"+opener_sheet_obj1.GetEtcData("mrn_no")+"</MRN_NO>" ;
	sXml +="<BL_TP_CD>"+opener_sheet_obj1.GetEtcData("bl_tp_cd")+"</BL_TP_CD>" ;
	sXml +="<SHIP_NM>"+opener_sheet_obj1.GetEtcData("ship_nm")+"</SHIP_NM>" ;
	sXml +="<ETA_DT>"+opener_sheet_obj1.GetEtcData("eta_dt")+"</ETA_DT>" ;
	sXml +="<PORT_CD>"+opener_sheet_obj1.GetEtcData("port_cd")+"</PORT_CD>" ;
	sXml +="</ETC>";
	sXml +="</SHEET>";

	viewer.setRData(sXml);
//	RD_path = "http://localhost:9001/opuscntr/"; // TEST 할때만..
	viewer.openFile(RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/korea/report/ESM_BKG_0851.mrd", RDServer, {timeout:1800});
}
