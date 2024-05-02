/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0876.js
*@FileTitle : NIS vs Portnet Reconciliation
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
function esm_bkg_0876()
{
	this.processButtonClick 	= processButtonClick;
	this.loadPage				= loadPage;
	this.rdOpen					= rdOpen;
}

// 공통전역변수
var docObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		case "btn_Close":
			window.close();
			break;
		case "btn_Print":					
			rdObjects[0].PrintDialog();
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
 * print할수 있는 화면 오픈
 */
function rdOpen(){
	var sXml = "";		
	var opener_obj = opener;
	var form = opener_obj.document.form;
	var opener_sheet_obj1 =  opener_obj.document.t1sheet1;

	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml +=RD_GetDataSearchXml(opener_sheet_obj1, 1, "sel");
	sXml +="<ETC>" ;
	sXml +="<VVD>"+form.vvd.value+"</VVD>" ;
	sXml +="<ETB>"+form.etd_dt.value+"</ETB>";
	sXml +="</ETC>";
	sXml +="</SHEET>";
	rdObjects[0].AutoAdjust = true;
	rdObjects[0].HideStatusbar();
	rdObjects[0].ViewShowMode(0); 

	rdObjects[0].setbackgroundcolor(128,128,128);
	rdObjects[0].SetPageLineColor(128,128,128);

	rdObjects[0].SetRData(sXml);
//	RD_path = "http://localhost:7001/hanjin/"; // TEST 할때만..
	rdObjects[0].FileOpen(RD_path+'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0876.mrd' ,RDServer);
}             