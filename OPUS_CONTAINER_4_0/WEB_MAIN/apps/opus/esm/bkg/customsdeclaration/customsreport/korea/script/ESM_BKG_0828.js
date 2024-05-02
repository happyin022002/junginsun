/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0828.js
*@FileTitle : Discharging Cargo Declaration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.04.16 박상훈
* 1.0 Creation
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0828()
{
	this.processButtonClick 	= processButtonClick;
	this.loadPage				= loadPage;
	this.rdOpen					= rdOpen;
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	try {
		var srcName = window.event.srcElement.getAttribute("name");
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
	var sXml = "";
	var opener_obj = opener;
	var form = opener_obj.document.form;
	var opener_sheet_obj1 =  opener_obj.sheet2;

	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1);
	sXml +="<ETC>" ;
	sXml +="<MRN_NO>"+opener_sheet_obj1.GetCellValue(1, "mrn_no")+opener_sheet_obj1.GetCellValue(1, "mrn_chk_no")+"</MRN_NO>" ;
	sXml +="<CO_NM>"+opener_sheet_obj1.GetCellValue(1, "co_nm")+"</CO_NM>" ;
	sXml +="<ETB_DT>"+opener_sheet_obj1.GetCellValue(1, "vps_etb_dt")+"</ETB_DT>" ;
	sXml +="<SHP_NM>"+opener_sheet_obj1.GetCellValue(1, "vsl_eng_nm")+"</SHP_NM>" ;
	sXml +="</ETC>";
	sXml +="</SHEET>";

	viewer.setRData(sXml);
//	RD_path = "http://localhost:9001/opuscntr/"; // TEST 할때만..
	viewer.openFile(RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/korea/report/ESM_BKG_0828.mrd", RDServer, {timeout:1800});
}