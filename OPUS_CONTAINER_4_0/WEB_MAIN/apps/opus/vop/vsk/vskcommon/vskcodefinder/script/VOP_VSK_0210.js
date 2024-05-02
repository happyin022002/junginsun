/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0210.jsp
*@FileTitle : Country Code Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObj=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		var cal=new ComCalendar();
		cal.offsetX=95; 
		cal.offsetY=128;
		switch (srcName) {
		case "btn_ok":
			// if(window.returnValue){
			var sDate=formObj.src_day.value;
			var sTime=formObj.src_time.value;
			sDate=sDate.replace(/\-|\ /g, ""); // Remove date separator, space
			sTime=sTime.replace(/\:|\ /g, ""); // Remove time separator, space
			var year=sDate.substr(0, 4);
			var month=sDate.substr(4, 2);
			var date=sDate.substr(6, 2);
			var destdate=month + '/' + date + year + sTime;
			ComPopUpReturnValue(destdate);
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btn_cal":
			// cal.select(formObj.src_day, 'MM/ddyyyy');
			cal.select(formObj.src_day, 'yyyy-MM-dd');
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
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	loadDate();
	document.form.src_day.blur();
}
function loadDate() {
	var formObj=document.form;
	var srcdate=formObj.srcdate.value;
	var dDate=new Date(getDateFromFormat(srcdate, 'MM/ddyyyyHHmm'));
	srcdate=srcdate.replace(/\/|\ /g, ""); // Remove date separator, space
	if (srcdate.length == 12) {
		var year=srcdate.substr(4, 4);
		var month=srcdate.substr(0, 2);
		var date=srcdate.substr(2, 2);
		var hours=srcdate.substr(8, 2);
		var minutes=srcdate.substr(10, 2);
		formObj.src_day.value=year + '-' + month + '-' + date;
		formObj.src_time.value=hours + ':' + minutes;
		formObj.oldday.value=formObj.src_day.value;
		formObj.oldtime.value=formObj.src_time.value;
	}
}