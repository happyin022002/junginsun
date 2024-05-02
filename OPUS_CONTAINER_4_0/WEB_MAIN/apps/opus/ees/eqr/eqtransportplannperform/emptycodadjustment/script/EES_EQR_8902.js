/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_8902.js
*@FileTitle  : MTY Repo Inquiry by Period
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
// common static variable
var docObjects=new Array();
var sheetCnt=0;

/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject=docObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btng_print":
			viewer.print({isServerSide:true});
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			errMsg=getMsg("TES22506");
			showErrMessage(errMsg);
		} else {
			showErrMessage(e);
		}
	}
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	rdOpen();
	// viewer.PrintDialog();
}
function CimMakeRDXml(sheet_obj, no) {
	// checking parameter effectiveness
	if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
		alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
		return "";
	}
	var rowXml="";
	var allXml="<SHEET" + no + ">  <DATA TOTAL='" + sheet_obj.LastRow()+ "'>";
	var rowcount=sheet_obj.RowCount()+ sheet_obj.headerRows - 1;
	for (ir=sheet_obj.HeaderRows(); ir <= sheet_obj.LastRow(); ir++) {
		if (sheet_obj.RowCount()- 1 != ir && sheet_obj.RowCount()!= ir) {
			rowXml="<TR>";
			for (ic=0; ic <= sheet_obj.LastCol(); ic++) {
				rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir, ic) + "]]></TD>";
			}
			rowXml += "</TR>";
			allXml += rowXml;
		}
	}
	allXml += "  </DATA></SHEET" + no + ">";
	return allXml;
}
/**
 * calling screen to print
 */
function rdOpen() {
	var sXml="";
	var i=0;
	var j=0;
	  var opener_obj=window.dialogArguments;
      if (!opener_obj) opener_obj=parent;
	//var opener_obj=window.dialogArguments;
	var opener_sheet_obj1=opener_obj.sheet1;
	var fromObj=new Array();
	var rdObj=new Array();
	fromObj[1]=document.form; 
	rdObj[0]=opener_sheet_obj1;
	sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
	// alert(" rdObj[0].RowCount [" + rdObj[i].RowCount + "]");
	sheetCnt=1;
	// i = sheet count
	for (i=0; i < 1; i++) {
		sheetCnt=i + 1;
		if (rdObj[i].RowCount()== 0) {
			sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
			for (j=0; j <= rdObj[i].LastCol(); j++) {
				sXml += "<TD></TD>";
			}
			sXml += "</TR></DATA></SHEET" + sheetCnt + ">";
		} else {
			//sXml += CimMakeRDXml(rdObj[i], sheetCnt);
			sXml += RD_GetDataSearchXml(rdObj[i], sheetCnt);
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
	if (rdObj[0].RowCount()== "0")
	{
		errMsg='No data found.';
		showErrMessage(errMsg);
		return;
	}
	
	viewer.setRData(sXml);
	
	// in case of US, setting rpaper = LETTER
	if(opener_obj.document.form.rpt_cnt_cd.value == "US"){ 
		RDServer += "/rpaper [LETTER]";
	}
	viewer.openFile(RD_path + 'apps/opus/ees/eqr/eqtransportplannperform/emptycodadjustment/report/EES_EQR_8902.mrd', RDServer, {timeout:1800});
}
