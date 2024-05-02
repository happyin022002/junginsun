/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1918.js
*@FileTitle  : Location M/B by Logistics-Wise
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
// common global variables
var docObjects=new Array();
var sheetCnt=0;

/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject=docObjects[0];
	var sheetObject1=docObjects[1];
	var sheetObject2=docObjects[2];
	/*******************************************************/
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
			ComShowMessage(e.message);
		}
	}
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	rdOpen();
	//viewer.PrintDialog();
}
/**
 * opening print
 */
function rdOpen() {
	var sXml="";
	var i=0;
	var j=0;
	var opener_obj=window.dialogArguments;
	if (!opener_obj) {
		opener_obj=parent; 
	}
	var opener_sheet_obj1=opener_obj.t2sheet1;
	var fromObj=new Array();
	var rdObj=new Array();
	fromObj[1]=document.form; // putting in list to send to RD
	rdObj[0]=opener_sheet_obj1;
	sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
	sheetCnt=1;
	//i = Sheet count
	for (i=0; i < 1; i++) {
		sheetCnt=i + 1;
		if (rdObj[i].RowCount()== 0) {
			sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
			for (j=0; j <= rdObj[i].LastCol(); j++) {
				sXml += "<TD></TD>";
			}
			sXml += "</TR></DATA></SHEET" + sheetCnt + ">";
		} else {
			sXml += CimMakeRDXml(rdObj[i], sheetCnt);
		}
	}
	// modifying data
	var sTpsz="";
	if (opener_obj.document.form.rpt_tpsz.value == "A") {
		sTpsz="ALL";
	} else if (opener_obj.document.form.rpt_tpsz.value == "D") {
		sTpsz="DRY";
	} else if (opener_obj.document.form.rpt_tpsz.value == "S") {
		sTpsz="SPCL";
	} else if (opener_obj.document.form.rpt_tpsz.value == "R") {
		sTpsz="Reefer(" + opener_obj.document.form.rpt_rdtype.value + ")";
	}
	var sCargotype="";
	if (opener_obj.document.form.rpt_cargotype.value == "") {
		sCargotype="ALL";
	} else {
		sCargotype=opener_obj.document.form.rpt_cargotype.value;
	}
	var sPeriod="";
	if (opener_obj.document.form.rpt_period.value == "M") {
		sPeriod="Month / " + " " + opener_obj.document.form.rpt_fromdate.value + " ~ " + opener_obj.document.form.rpt_todate.value;
	} else if (opener_obj.document.form.rpt_period.value == "W") {
		sPeriod="Week / " + " " + opener_obj.document.form.rpt_fromdate.value + " ~ " + opener_obj.document.form.rpt_todate.value;
	}
	sXml += "<ETC>";
	sXml += "    <PERIOD>" + sPeriod + "</PERIOD>"
	//  sXml +="    <FROM_DATE>"  +opener_obj.document.form.rpt_fromdate  .value+"</FROM_DATE>"
	//  sXml +="    <TO_DATE>"    +opener_obj.document.form.rpt_todate    .value+"</TO_DATE>"
	sXml += "    <LOCATION_BY>" + opener_obj.document.form.rpt_locationby.value + "</LOCATION_BY>"
	sXml += "    <LOCATION>" + opener_obj.document.form.rpt_location.value + "</LOCATION>"
	sXml += "    <CARGO_TYPE>" + sCargotype + "</CARGO_TYPE>"
	sXml += "    <TP_SZ>" + sTpsz + "</TP_SZ>"
	//      sXml +="    <RD_TYPE>"    +opener_obj.document.form.rpt_rdtype    .value+"</RD_TYPE>"
	sXml += "    <EN_ROUTE>" + opener_obj.document.form.rpt_enroute.value + "</EN_ROUTE>"
	sXml += "    <SOC>" + opener_obj.document.form.rpt_soc.value + "</SOC>"
	sXml += "    <COMPANY>" + opener_obj.document.form.rpt_company.value + "</COMPANY>"
	sXml += "    <HEAD_LOC_CD>" + opener_obj.document.form.rpt_loc_cd.value + "</HEAD_LOC_CD>"
	/*
	 sXml +="    <CNTR_NO>"+opener_obj.document.form.prt_cntr_no.value+"</CNTR_NO>"
	 sXml +="    <CNTR_USE_CO_CD>"+opener_obj.document.form.prt_cntr_use_co_cd.value+"</CNTR_USE_CO_CD>"
	 */
	var real_cntr_tpsz_cd=opener_obj.head_cntr_tpsz_cd.split(",")
	var ii=0;
	for ( var i=0; i < real_cntr_tpsz_cd.length; i++) {
		ii++;
		sXml += "    <HEAD_CNTR_TPSZ_CD" + ii + ">" + real_cntr_tpsz_cd[i] + "</HEAD_CNTR_TPSZ_CD" + ii + ">"
	}
	sXml += "</ETC>"
	sXml += "</SHEET>";
	if (rdObj[0].RowCount()== "0") // error in case of no existing data in sheet to send to RD
	{
		errMsg='No data found.';
		showErrMessage(errMsg);
		return;
	}
	viewer.setRData(sXml);
	// setting LETTER paper type in case login region is US
	if(opener_obj.document.form.rpt_cnt_cd.value == "US"){ 
		RDServer += "/rpaper [LETTER]";
	}
	viewer.openFile(RD_path + 'apps/opus/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/report/EES_CIM_1918.mrd', RDServer, {timeout:1800});
}
