/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0008.js
*@FileTitle  : Receipt Refund Information Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class stm_sar_0008 : business script for stm_sar_0008
 */
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_apgl_calendar":
	            var cal=new ComCalendar();                
	            cal.select(formObj.ap_gl_dt, 'yyyy-MM-dd');
				break;				
			case "btn_Ok":
				if(mandatory_check()){
					sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(1, "wrtf_rmk",formObj.wrtf_rmk.value,0);
					sheetObj.SetCellValue(1, "ap_ofc_cd",formObj.ap_ofc_cd.value,0);
					sheetObj.SetCellValue(1, "vndr_no",formObj.vndr_no.value,0);
					sheetObj.SetCellValue(1, "ap_gl_dt",ComReplaceStr(formObj.ap_gl_dt.value, "-", ""),0);
					sheetObj.SetCellValue(1, "ap_rmk",formObj.ap_rmk.value,0);
					comPopupOK();
				}	
				break;	
			case "btn_Close":
				ComClosePopup(); 
				break;
			case "btns_search_vndr":
				ComOpenPopup("STM_SAR_0002.do", 900, 380, "setVndr", "0,0", false, false);
				break;					
			case "btns_search_ofc":
				ComOpenPopup("STM_SAR_0001.do", 800, 490, "setOfc", "0,0", false, false);				
				break;									
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * setVndr 조회 후 값 Return 받아 셋팅한다.
 */
function setVndr(aryPopupData) {
    document.form.vndr_no.value=aryPopupData[0][1];
}
/**
 * setOfc 조회 후 값 Return 받아 셋팅한다.
 */
function setOfc(aryPopupData) {
    document.form.ap_ofc_cd.value=aryPopupData[0][1];
}
/**
 * 필수값 확인
 */
function mandatory_check() {	
	var formObj=document.form;
	if(ComIsEmpty(formObj.ap_ofc_cd)){
		ComShowCodeMessage("COM130403", "AP Office");
		return false;
	} 
	if(ComIsEmpty(formObj.vndr_no)){
		ComShowCodeMessage("COM130403", "Vendor Code");
		return false;
	} 
	if(ComIsEmpty(formObj.ap_gl_dt)){
		ComShowCodeMessage("COM130403", "AP GL Date");
		ComSetFocus(formObj.ap_gl_dt);
		return false;
	} 
	var apGlDt=ComReplaceStr(formObj.ap_gl_dt.value, "-", "");
	var rctDpsDt=ComReplaceStr(formObj.rct_dps_dt.value, "-", "");
	if(ComChkPeriod(rctDpsDt, apGlDt) < 1){
		ComShowCodeMessage("SAR00023");
		ComSetFocus(formObj.ap_gl_dt);
		return false;
	}
	if(ComIsEmpty(formObj.ap_rmk)){
		ComShowCodeMessage("COM130403", "AP Remark");
		ComSetFocus(formObj.ap_rmk);
		return false;
	}
	return true;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
				var HeadTitle1="|AR Remark|AP Office|Vendor Code|AP GL Date|AP Remark";
				var headCount=ComCountHeadTitle(HeadTitle1);
	
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"wrtf_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ap_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ap_gl_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ap_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
				InitColumns(cols);
	
				SetEditable(1);
				SetSheetHeight(170);
	     }
	break;
	}
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
    //handling Axon event. event catch
	axon_event.addListenerForm ('change', 'obj_onchange', formObj);
}
//handling Axon event 2
function obj_onchange(){
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	var apOfcCd = formObj.ap_ofc_cd.value;
	var vndrNo = formObj.vndr_no.value;
	var cnt = 0;
	
	switch(ComGetEvent("name")){
		case "ap_ofc_cd":
			if (!ComIsEmpty(apOfcCd)) {
				
				var param="f_cmd=" + SEARCH + "&ofc_cd=" + apOfcCd;
				var sXml=sheetObject.GetSearchData("STM_SAR_0001GS.do", param);
				var rows = ComGetTotalRows(sXml)
				
				if(rows > 0){
					var arrStr = SarXmlToArray(sXml);
					
					for(var i = 0; i < arrStr.length; i++){
						if(arrStr[i][0] == apOfcCd) cnt++;
					}
				}
				
				if(rows == 0 || cnt == 0){
					ComShowCodeMessage("SAR00052", apOfcCd);
					ComClearObject(formObj.ap_ofc_cd);
					ComSetFocus(formObj.ap_ofc_cd);
				}			
			} 
			
			break;
			
		case "vndr_no":
			if (!ComIsEmpty(vndrNo)) {
				
				var param="f_cmd=" + SEARCH + "&vndr_seq=" + vndrNo;
				var sXml=sheetObject.GetSearchData("STM_SAR_0002GS.do", param);
				var rows = ComGetTotalRows(sXml)
				
				if(rows > 0){
					var arrStr = SarXmlToArray(sXml);
					
					for(var i = 0; i < arrStr.length; i++){
						if(arrStr[i][5] == vndrNo) cnt++;
					}
				}
				
				if(rows == 0 || cnt == 0){
					ComShowCodeMessage("SAR00052", vndrNo);
					ComClearObject(formObj.vndr_no);
					ComSetFocus(formObj.vndr_no);
				}			
			} 
			
			break;	
	}
}
