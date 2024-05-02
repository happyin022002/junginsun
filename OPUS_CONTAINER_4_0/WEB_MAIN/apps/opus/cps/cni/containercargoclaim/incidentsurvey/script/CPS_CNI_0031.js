/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0031.js
*@FileTitle  :  [CPS_CNI_0031] Incident-Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var combo1=null;
var combo2=null;
var comboText1="ALL";//RD를 위한변수 초기값을 ALL로 출력하기위함(AREA)
var comboText2="ALL";//POI
var param="";
// html form
var frm=null;
// DOI, DORG 선택시 디폴트 세팅날짜.
var strFromDate="";
var strToDate="";
//디폴트 area cd
var clmAreaCd="";
//초기로딩여부(콤보변경시 재조회할 경우 화면이 처음 열릴때는 제외한다)
var openPage="";
//디폴트 INC No 세팅 = INCID+당해년도
var strGmtYear;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
  * registering IBCombo Object as list
  * @param comboObj
  **/
 function setComboObject(comboObj){
 	comboObjects[comboCnt++]=comboObj;
 }
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
	//초기로딩여부
	openPage="Y";
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	// IBMultiComboinitializing
	combo1=comboObjects[0];
	combo2=comboObjects[0];
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBox();
	if(!ComIsNull(frm.schToStrGmt)){
		strGmtYear=frm.schToStrGmt.value.substring(0,4);
	}
	//초기값세팅
	combo1.SetSelectCode("ALL");
	frm.sch_str.value="INCID"+strGmtYear;
	frm.sch_cond_chk.value="INCI_NO";
	frm.sch_duration_chk.value="DOI";
    // DOI, DORG 선택시 디폴트 세팅날짜.
	strFromDate=frm.schFromStrGmt.value;
	strToDate=frm.schToStrGmt.value;
	frm.sch_from_str.value=strFromDate;
	frm.sch_to_str.value=strToDate;
    //registering initial event 
    initControl();
    //Login User가 소속된 Office에서 Register한 Incident 를 Auto Retrieve.
	if(frm.sch_ofc_cd.value != "" && frm.sch_str.value != "INCID"+strGmtYear){
		doActionIBSheet(SEARCHLIST01);
	}
	ComSetFocus(frm.sch_str);
}
/**
* registering initial event 
*/
function initControl() {
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
//   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('click', 'obj_focus', frm);
 //  axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
 //  axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {
 	var sXml2=frm.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	setMultiComboBox("combo1" ,  arrXml[0] ); //09 Area
	setMultiComboBox("combo2" ,  arrXml[1] ); //14 poi
	//Area Cd Setting
 	var dataCount=ComGetTotalRows(arrXml[2]);
 	if (dataCount > 0) {
 		var list=SheetXml2ListMap(arrXml[2]);	
		for (var j=0;j<list.length;j++)
		{
			if(list[j]!=undefined){
				var listVO=list[j];
				break;
			}
		}
 		clmAreaCd=listVO["clm_area_cd"];
		//ComSetObjValue(frm.combo1,clmAreaCd);//초기값세팅.. 2010.01.21 요구사항변경됨(전체조회).
	}
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
		             var HeadTitle1="Seq.|Incident NO. |A|RGOFC|Register|DORG|POI|Location|DOI|VVD|Subject|DESC";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             (headCount, 0, 0, true);
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_inci_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inci_plc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inci_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inci_occr_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inci_ref_vvd_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"inci_subj_nm",     KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"inci_dev_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		             SetSheetHeight(260);
             }
                break;
        }
}
/**
 * Combobox Initialize, Header Definition 
 * @param {object} comboObj Mandatory, IBMultiCombo Object
 * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
 **/
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
//no support[check again]CLT 		comboObj.UseCode=true;
//no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetBackColor("#ffffff");//"#CCFFFD";
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
	}
} 
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Location
 */
 function setLocation(rowArray) { 
    frm.sch_loc_cd.value=rowArray[0][3];
    //값변경시 자동조회
	sheet1.RemoveAll();//append mode이므로 remove 해야함.
	frm.page_no.value="1";
	doActionIBSheet(SEARCHLIST01);
 }
// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal=new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	    //초기로딩여부
	    openPage="N";
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn1_Retrieve":
				/*
				var schStr=frm.sch_str.value;
				if (ComIsNull(schStr)) {
					//msgs["CNI00018"] = "Please select {?msg1}";
					ComShowCodeMessage("CNI00009" , "the Data");
					ComSetFocus(frm.sch_str);
					return;
				}
				*/
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);			
				break;	
			case "btn1_New":
				ComResetAll();
				if(frm.sch_cond[0].checked == true){
					frm.sch_str.value="INCID"+strGmtYear;
					frm.sch_from_str.value=strFromDate;
					frm.sch_to_str.value=strToDate;
					ComSetFocus(frm.sch_str);
				}
				break;
			case "btn1_Main":
				var cgoClmNo=sheet1.GetCellValue(sheet1.GetSelectRow(), "clm_no");
				location.href = "CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&cgo_clm_no="+cgoClmNo;
				break;
			case "btn1_Print":
				if (sheet1.RowCount()<= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
			case "btns_location":
				//공통팝업 Location호출
				var locCd=frm.sch_loc_cd.value;
				popupLocation(locCd);
				break;
			case "btns_date_cal1":
				calendarDisplay(frm.sch_from_str);
				break;
			case "btns_date_cal2":
				calendarDisplay(frm.sch_to_str);
				break;
			case "btn2_Claim_Search"://incident_no 선택하고 13자리 입력시
				if(frm.sch_cond[0].checked == true && frm.sch_str.value.length == 13){
					var url="CPS_CNI_0032_01.do?popupYn=Y&cgo_clm_inci_no="+frm.sch_str.value;
					var winName="CPS_CNI_0032_01";
					var reqWin=openWinCenter(url,winName,1200,620);
				}else{
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
					ComSetFocus(frm.sch_str);
				}
				break;
			case "btn1_Down_Excel":
				if(sheet1.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
				}	
                break;
		} // end switch
}
/**
 * HTML Control KeyPress event
 */
//function obj_keypress() {
//    switch (event.srcElement.name) {    
//		case "sch_str":  
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//		case "sch_ofc_cd":
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//		case "sch_loc_cd":
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//		case "sch_from_str":
//			ComKeyOnlyNumber(event.srcElement, "-");
//			break;
//		case "sch_to_str":
//			ComKeyOnlyNumber(event.srcElement, "-");
//			break;
//	}
//}
/**
 * HTML Control Click event
 */
function obj_focus() {
    switch (ComGetEvent("name")) {  
		//Incident No.를 검색조건으로 선택하면 “INCID”는 자동 표시.
		case "sch_cond":
			if(frm.sch_cond[0].checked == true){
				frm.sch_str.value="INCID"+strGmtYear;
				frm.sch_cond_chk.value="INCI";//RD param
			}else{
				frm.sch_str.value="";
				frm.sch_cond_chk.value="VVD";//RD param
			}	
		break;
		case "sch_duration":
			frm.sch_from_str.value=strFromDate;
			frm.sch_to_str.value=strToDate;
			if(frm.sch_duration[0].checked == true){//RD 를 위한 변수
				frm.sch_duration_chk.value="DOI";
			}else{
				frm.sch_duration_chk.value="DORG";
			}	
		break;
	}
}
/**
 * HTML Control KeyDowm event
 */
//function obj_keydown() {
//	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 
//    if (event.keyCode != 13) {
//  		 return;
//  	}
//    switch (event.srcElement.name) {    
//		case "sch_str":
//		case "sch_from_str":
//		case "sch_to_str":
//				sheet1.RemoveAll();//append mode이므로 remove 해야함.
//				frm.page_no.value="1";
//				doActionIBSheet(SEARCHLIST01);
//		break;
//		case "sch_ofc_cd":
//			if (!ComIsNull(frm.sch_ofc_cd.value)) {
//				sheet1.RemoveAll();//append mode이므로 remove 해야함.
//				frm.page_no.value="1";
//				doActionIBSheet(SEARCHLIST01);
//			}
//		break;
//		case "sch_cre_usr_id":
//			if (!ComIsNull(frm.sch_cre_usr_id.value)) {
//				sheet1.RemoveAll();//append mode이므로 remove 해야함.
//				frm.page_no.value="1";
//				doActionIBSheet(SEARCHLIST01);
//			}
//		break;
//		case "sch_loc_cd":
//			if (!ComIsNull(frm.sch_loc_cd.value)) {
//				sheet1.RemoveAll();//append mode이므로 remove 해야함.
//				frm.page_no.value="1";
//				doActionIBSheet(SEARCHLIST01);
//			}
//		break;
//	}
//}
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm=document.form;
	switch (event.srcElement.name) {
	default:
		ComChkObjValid(event.srcElement);
	}
}
/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}


function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var arrVal=oldText.split("|");
	if(arrVal.length >1){
		comboText1=arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText1="ALL";
		}
	}else{
		comboText1=arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText1="ALL";
		}
	}
	formObj.sch_area.value=ComGetObjValue(comboObj);
	//값변경시 자동조회
    if(openPage == "N"){
		sheet1.RemoveAll();//append mode이므로 remove 해야함.
		frm.page_no.value="1";
		doActionIBSheet(SEARCHLIST01);
	}
}
function combo2_OnChange(comboObj, Index_Code, Text) {
	var formObj=document.form;
	var arrVal=Text.split("|");
	if(arrVal.length >1){
		comboText2=arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText2="ALL";
		}
	}else{
		comboText2=arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText2="ALL";
		}
	}
	formObj.sch_plc_tp_cd.value=ComGetObjValue(comboObj);
    //값변경시 자동조회
	sheet1.RemoveAll();//append mode이므로 remove 해야함.
	frm.page_no.value="1";
	doActionIBSheet(SEARCHLIST01);
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * row double click 시 CPS_CNI_0003 화면전환
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmInciNo=sheet1.GetCellValue(row , "cgo_clm_inci_no");
	location.href = "CPS_CNI_0030.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0030&cgo_clm_inci_no=" + cgoClmInciNo;	
}
function sheet1_OnClick(sheet, row, col) {
	var desc=sheet1.GetCellValue(row , "inci_dev_desc");
	frm.inci_dev_desc.value=desc;
}
function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		frm.inci_dev_desc.value="";
		ComShowCodeMessage("CNI00013");
	}else{
		var desc=sheet1.GetCellValue(sheet1.GetSelectRow(), "inci_dev_desc");
			frm.inci_dev_desc.value=desc;
	}
}
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value=PageNo;  
	doActionIBSheet(SEARCHLIST01);
}   
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		if(!validateForm()){
			return;
		}
		frm.f_cmd.value=SEARCHLIST01;	
		//sepatator 제거
		ComClearSeparator(frm.sch_from_str);
		ComClearSeparator(frm.sch_to_str);
 		var sXml=sheet1.GetSearchData("CPS_CNI_0031GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Append:1 , Sync:1} );
		}
		ComAddSeparator(frm.sch_from_str,"ymd");
		ComAddSeparator(frm.sch_to_str,"ymd");
	} else if (sAction == PRINT) {	
		frm.f_cmd.value=PRINT;
		//sepatator 제거
		ComClearSeparator(frm.sch_from_str);
		ComClearSeparator(frm.sch_to_str);
		frm.page_no.value="";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0086.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]"
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv=rvParam();
		frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value="Incident Inquiry-Print";		
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/incidentsurvey/report/CPS_CNI_0086.mrd";
//		var feature = "resizable=yes,width=1000,height=600"
//		ComOpenRDPopup(feature);
		popupRd(1000,600);
	} 
}
function rvParam(){
	param = "/rv NgmSsoName [JSESSIONID] NgmSsoData ["+frm.jsession.value+"]"; 
	if (frm.sch_cond_chk.value != "") {//INCI_NO , Area, poi
		param=param + "sch_cond_chk["+frm.sch_cond_chk.value+"]sch_str["+frm.sch_str.value+"]Area["+comboText1+"]POI["+comboText2+"]";
	}
	if (frm.sch_ofc_cd.value != "") {//RGOFC
		param=param + "RGOFC["+frm.sch_ofc_cd.value+"]";
	}
	if (frm.sch_cre_usr_id.value != "") {//Register
		param=param + "Register["+frm.sch_cre_usr_id.value+"]";
	}
	if (frm.sch_loc_cd.value != "") {//Location
		param=param + "Location["+frm.sch_loc_cd.value+"]";
	}
	if (frm.sch_duration_chk.value != "") {//기간
		param=param + "sch_duration_chk["+frm.sch_duration_chk.value+"]from["+frm.sch_from_str.value+"]to["+frm.sch_to_str.value+"]";
	}
	return param;
}
/**
* setting IBMultiComboBox
* @param {select box} combo object
* @param {xml} code , name xml
* @param {String} selected initial Code 
*/ 
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj=null; // IBMultiComboBox
	var vArrayListData=""; 
	var vListData="";
	var vCaptionText="";
	vComboObj=getComboObject(pComboObjId);
	if (vComboObj == null || pXML == null ) {
		return;
	}
	var vArrayListData=SheetXml2ListMap(pXML);
	vComboObj.InsertItem(0, "|", "");
	for ( var idx=1; idx < vArrayListData.length+1; idx++) {
		vListData=vArrayListData[idx-1];
		if (vListData != undefined && vListData != null) {
			vCaptionText=vListData["code"] + "|" + vListData["name"];
			vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
		}
	}//end for
}
/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 **/
function getComboObject(pComboObjId){
	var vCnt=comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].options.id== pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	if(frm.sch_from_str.value != "" || frm.sch_to_str.value != ""){
		if(frm.sch_duration[0].checked == false && frm.sch_duration[1].checked == false ){
			//msgs["CNI00018"] = "Please select {?msg1}";
			ComShowCodeMessage("CNI00018" , "DOI or DORG");
			return false;
		}	
	}
	if (ComGetObjValue(frm.sch_from_str) == "") {
		 ComShowCodeMessage("CNI00003", "from date");
		 frm.sch_from_str.focus();
		 return false;
	}
	if (ComGetObjValue(frm.sch_to_str) == "") {
		 ComShowCodeMessage("CNI00003", "to date");
		 frm.sch_to_str.focus();
		 return false;
	}	
	return true;
}
