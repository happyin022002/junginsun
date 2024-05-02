/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1064.js
 *@FileTitle : Match-back by Vessel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.16
 *@LastModifier : 문중철
 *@LastVersion : 1.0 
 * 2009.07.16 문중철
 * 1.0 최초 생성 
=========================================================*/

// 공통전역변수
var docObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = docObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	var rdObject = rdObjects[0];

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_close":
			window.close();
			break;

		case "btng_print":
			rdObject.PrintDialog();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = getMsg("TES22506");
			showErrMessage(errMsg);
		} else {
			showErrMessage(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	rdOpen();
	// rdObjects[0].PrintDialog();
}

function CimMakeRDXml(sheet_obj, no) {
	// 함수 인자 유효성 확인
	if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
		alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
		return "";
	}

	var rowXml = "";
	var allXml = "<SHEET" + no + ">  <DATA TOTAL='" + sheet_obj.LastRow + "'>";

	var rowcount = sheet_obj.RowCount + sheet_obj.headerRows - 1;
	for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
		if (sheet_obj.RowCount - 1 != ir && sheet_obj.RowCount != ir) {
			rowXml = "<TR>";
			for (ic = 0; ic <= sheet_obj.LastCol; ic++) {
				rowXml += "<TD><![CDATA[" + sheet_obj.CellValue(ir, ic) + "]]></TD>";
			}
			rowXml += "</TR>";
			allXml += rowXml;
		}

	}

	allXml += "  </DATA></SHEET" + no + ">";

	return allXml;

}

/**
 * print화면 오픈 print화면 오픈 print할수 있는 화면 오픈
 */
function rdOpen() {

	var sXml = "";
	var i = 0;
	var j = 0;
	var opener_obj = window.dialogArguments;
	var opener_sheet_obj1 = opener_obj.document.sheet1;

	var fromObj = new Array();
	var rdObj = new Array();

	fromObj[1] = document.form; // RD 로 보내기 위해 배열로담는다
	rdObj[0] = opener_sheet_obj1;

	sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
	// alert(" rdObj[0].RowCount [" + rdObj[i].RowCount + "]");
	sheetCnt = 1;
	// i = 시트 카운트,
	for (i = 0; i < 1; i++) {
		sheetCnt = i + 1;
		if (rdObj[i].RowCount == 0) {
			sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
			for (j = 0; j <= rdObj[i].LastCol; j++) {
				sXml += "<TD></TD>";
			}
			sXml += "</TR></DATA></SHEET" + sheetCnt + ">";
		} else {
			sXml += CimMakeRDXml(rdObj[i], sheetCnt);
		}
	}
	// alert("sXml [" + sXml + "]");

	sXml += "<ETC>";
	sXml += "    <FROM_DATE>" + opener_obj.document.form.rpt_fromdate.value + "</FROM_DATE>"
	sXml += "    <END_DATE>" + opener_obj.document.form.rpt_enddate.value + "</END_DATE>"
	sXml += "    <INQUIRY_LEVEL>" + opener_obj.document.form.rpt_inpuirylevel.value + "</INQUIRY_LEVEL>"
	sXml += "    <LOCATION>" + opener_obj.document.form.rpt_location.value + "</LOCATION>"
	sXml += "    <OPTION>" + opener_obj.document.form.rpt_div.value + "</OPTION>"
	sXml += "    <TP_SZ>" + opener_obj.document.form.rpt_tpsz.value + "</TP_SZ>"
	sXml += "    <TP_SZ_LIST>" + opener_obj.document.form.rpt_tpszlist.value + "</TP_SZ_LIST>"
	sXml += "</ETC>"
	sXml += "</SHEET>";

	if (rdObj[0].RowCount == "0") // RD 로 보낼 sheet 에 데이타가 없으면 Error
	{
		errMsg = 'No data found.';
		showErrMessage(errMsg);
		return;
	}
	rdObjects[0].AutoAdjust = true;
	rdObjects[0].HideToolbar();
	rdObjects[0].HideStatusbar();
	rdObjects[0].ViewShowMode(2);

	rdObjects[0].setbackgroundcolor(255, 255, 255);
	rdObjects[0].SetPageLineColor(255, 255, 255);
	rdObjects[0].SetRData(sXml);
	
	// 접속 지역이 미국이면 용지설정을 LETTER 로 한다.
	if(opener_obj.document.form.rpt_cnt_cd.value == "US"){ 
		RDServer += "/rpaper [LETTER]";
	}
	
	rdObjects[0].FileOpen(RD_path + 'apps/alps/ees/eqr/cntrcodconfirm/emptycodadjustment/report/EES_EQR_1064.mrd', RDServer);
}