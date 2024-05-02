/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0036.js
*@FileTitle  : [CPS_CNI_0036] Transfer
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
// html form
var frm=null;
var frm2=null;
// grid combo
var comboText="";
var comboCode="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
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
	frm2=document.form2;//멀티콤보용
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
	//initSheet 보다 먼저해준다.
	initComboBox();
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	//초기값세팅
	frm.sch_date_div_chk.value="Transferred";
	frm.sch_trns_auth_cd_chk.value="Waiting";
    //registering initial event 
    initControl();
	doActionIBSheet(SEARCHLIST01);
}
/**
* registering initial event 
*/
function initControl() {
}
 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {
 	var sXml2=frm2.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	setMultiComboBox(arrXml[0] ); //32
 	
 	var dataCount=ComGetTotalRows(arrXml[1]);
	if (dataCount > 0) {
		var list=SheetXml2ListMap(arrXml[1]);	
	 	var listVO=list[0];
	 	clmAreaCd=listVO["clm_area_cd"];
	 	ComSetObjValue(frm.clm_area_cd,clmAreaCd );
	} else {
		var popwin=popupClientDefault(); //calling setup display not existing Area Code
		popwin.focus();
	}
}
function setMultiComboBox(pXML) {
	var vArrayListData=""; 
	var vListData="";
	var vArrayListData=SheetXml2ListMap(pXML);
	for ( var idx=0; idx < vArrayListData.length; idx++) {
	    vListData=vArrayListData[idx];
		if (vListData != undefined) {
			comboText += vListData["name"] + "|" ;
			comboCode += vListData["code"] + "|" ;
		}
	}
	comboText=comboText.substring(0, comboText.length -1);
	comboCode=comboCode.substring(0, comboCode.length -1);
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
			      var HeadTitle1="|Seq.|Claim No.|Area|Status|Frequency|Transferor|Transferor|Transferor|Transferee|Transferee|Transferee|Transferee|Transferee|div|hdlr_usr_id|hdlr_ofc_cd|trns_area_cd|upd_usr_id|clm_misc_cd|Tran_seq";
			      var HeadTitle2="|Seq.|Claim No.|Area|Status|Frequency|HOFC|Handler|Date|Status|HOFC|Handler|Date|Remark|div|hdlr_usr_id|hdlr_ofc_cd|trns_area_cd|upd_usr_id|clm_misc_cd|Tran_seq";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 0, 0, true);
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clm_misc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trns_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trns_fm_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trns_fm_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trns_fm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_trns_auth_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trns_to_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trns_to_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trns_to_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Popup",     Hidden:0, Width:280,  Align:"Left",    ColMerge:1,   SaveName:"trns_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"div",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trns_area_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clm_misc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trns_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetColProperty(0, "clm_trns_auth_cd", {ComboText:comboText, ComboCode:comboCode} );
			      SetColProperty(0, "trns_to_ofc_cd", {AcceptKeys:"E" , InputCaseSensitive:1} );
			      SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			      SetShowButtonImage(2);
			      SetSheetHeight(430);
	      }
			break;
	}
}
// ===================================================================================
// Private function
// ===================================================================================
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
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btns_date_cal1":
				calendarDisplay(frm.sch_date_from);
				break;
			case "btns_date_cal2":
				calendarDisplay(frm.sch_date_to);
				break;
			case "btn1_Retrieve":
				if(ComChkValid(frm)) {
					sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
					frm.page_no.value="1";
					doActionIBSheet(SEARCHLIST01);	
				}
				break;	
			case "btn1_New":
				//CNI00015 Do you want to initialize?
				if (ComShowCodeConfirm("CNI00015") ) {
					ComResetAll();
				}
				break;
			case "btn1_Save":
				frm.f_cmd.value=MULTI;	
			    var findRow ;
			    var acceptRow ;
			   //FindText(Col, SearchText, [StartRow], [FullMatch], [CaseSensitive]) 
			   for(var row=1; row <= sheet1.RowCount()+1 ; row++){
					findRow=sheet1.FindText("clm_trns_auth_cd", "Rejected", row, -1, false);
					if(findRow != -1){
						if(sheet1.GetCellValue(findRow,"trns_rmk").trim()  == ""){
							ComShowMessage("Please remark reason for rejection");//CNI00108
							sheet1.SelectCell(findRow, "trns_rmk");
							return;
						}
					}
					acceptRow=sheet1.FindText("clm_trns_auth_cd", "Accepted", row, -1, false);
					if(acceptRow != -1){
						if(sheet1.GetCellValue(acceptRow,"trns_to_ofc_cd").trim()  == ""){
							ComShowCodeMessage("CNI00009" , "HOFC");
							//sheet1.SelectCell(acceptRow, "trns_to_ofc_cd");
							return;
						}
						if(sheet1.GetCellValue(acceptRow,"trns_to_usr_id").trim()  == ""){
							ComShowCodeMessage("CNI00009" , "Handler");
							//sheet1.SelectCell(acceptRow, "trns_to_usr_id");
							return;
						}
					}
			   }
				if (ComShowCodeConfirm("CNI00012")) {//CNI00012(Do you want to save changes?)
					doActionIBSheet(MULTI);
				}
				break; 
			case "btn1_Down_Excel":
 				if(sheet1.RowCount() < 1){//no data	
 					ComShowCodeMessage("COM132501");
 				}else{	
 					sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
 				}	
				break; 
			case "btn1_Print":
				if (sheet1.RowCount()<= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
			case "sch_date_div":
				if(frm.sch_date_div[0].checked == true){//RD 를 위한 변수
					frm.sch_date_div_chk.value="Transferred";
				}else{
					frm.sch_date_div_chk.value="Processed";
				}	
				//값변경시 자동조회
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			break;
			case "sch_trns_auth_cd":
				if(frm.sch_trns_auth_cd[0].checked == true){//RD 를 위한 변수
					frm.sch_trns_auth_cd_chk.value="Waiting";
				}
				if(frm.sch_trns_auth_cd[1].checked == true){
					frm.sch_trns_auth_cd_chk.value="Accepted";
				}
				if(frm.sch_trns_auth_cd[2].checked == true){
					frm.sch_trns_auth_cd_chk.value="Rejected";
				}
				if(frm.sch_trns_auth_cd[3].checked == true){
					frm.sch_trns_auth_cd_chk.value="All";
				}
				//값변경시 자동조회
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			break;
		} // end switch
}
 
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * FROM / TO 데이타 처리 
 * 1. FROM 인 경우는 claim no 에 밑줄넣고 빨간색표시
 * 2. setting authority : FROM (trns_to_ofc_cd,trns_rmk)
 * 				 TO  (clm_trns_auth_cd,trns_to_ofc_cd,trns_to_usr_id,trns_to_dt,trns_rmk) 이 수정가능한 부분인데
 *               usr_roles 에 따라 editable 설정을 변경한다.
 *               단,trns_rmk 는  sheet1_OnClick 함수에서 설정한다.    
 */
 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	var usr_roles=frm.usr_roles.value;
	var usr_id=frm.usr_id.value;
	var usr_area=frm.usr_area.value;
	var usr_office=frm.usr_office.value;
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}else{
		for(var row=1; row <= sheet1.RowCount()+1 ; row++){
			if(sheet1.GetCellValue(row,"div").toUpperCase()  == "FROM"){
				sheet1.SetCellEditable(row, "clm_trns_auth_cd",0);
				sheet1.SetCellEditable(row, "trns_to_usr_id",0);
				sheet1.SetCellEditable(row, "trns_to_dt",0);
 				sheet1.SetCellFontColor(row, "cgo_clm_no","#FF0000");
 				sheet1.SetCellFontUnderline(row, "cgo_clm_no",1);
				//권한
//				if(equalsRole("CNI03") || equalsRole("CNI93")){
					sheet1.SetCellEditable(row, "trns_to_ofc_cd",1);
//				}else if(equalsRole("CNI02")){//FROM 경우는 CNI02 이면 area_cd 에 무관하게 edit 가능.
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",1);
//				}else if(equalsRole("CNI01")){
//					if(usr_id == sheet1.GetCellValue(row,"hdlr_usr_id") && usr_office == sheet1.GetCellValue(row,"hdlr_ofc_cd")){
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",1);
//					}else{
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",0);
//					}
//				}else{
//					sheet1.SetCellEditable(row, "trns_to_ofc_cd",0);
//					ComBtnDisable("btn1_Save");
//				}
			}
			if(sheet1.GetCellValue(row,"div").toUpperCase()  == "TO"){
				//권한
//				if(equalsRole("CNI03") || equalsRole("CNI93")){
					sheet1.SetCellEditable(row, "clm_trns_auth_cd",1);
					sheet1.SetCellEditable(row, "trns_to_ofc_cd",1);
					sheet1.SetCellEditable(row, "trns_to_usr_id",1);
					sheet1.SetCellEditable(row, "trns_to_dt",1);
//				}else if(equalsRole("CNI02")){//TO 경우는 CNI02 이면 Transferee 의 HOFC 의 area_cd 가 같을 경우만 edit 가능.
//					if(usr_area == sheet1.GetCellValue(row,"trns_area_cd")){
//						sheet1.SetCellEditable(row, "clm_trns_auth_cd",1);
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",1);
//						sheet1.SetCellEditable(row, "trns_to_usr_id",1);
//						sheet1.SetCellEditable(row, "trns_to_dt",1);
//					}else{
//						sheet1.SetCellEditable(row, "clm_trns_auth_cd",0);
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",0);
//						sheet1.SetCellEditable(row, "trns_to_usr_id",0);
//						sheet1.SetCellEditable(row, "trns_to_dt",0);
//					}
//				}else if(equalsRole("CNI01")){
//					if(usr_office == sheet1.GetCellValue(row,"trns_to_ofc_cd")){
//						sheet1.SetCellEditable(row, "clm_trns_auth_cd",1);
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",1);
//						sheet1.SetCellEditable(row, "trns_to_usr_id",1);
//						sheet1.SetCellEditable(row, "trns_to_dt",1);
//					}else{
//						sheet1.SetCellEditable(row, "clm_trns_auth_cd",0);
//						sheet1.SetCellEditable(row, "trns_to_ofc_cd",0);
//						sheet1.SetCellEditable(row, "trns_to_usr_id",0);
//						sheet1.SetCellEditable(row, "trns_to_dt",0);
//					}
//				}else{
//					sheet1.SetCellEditable(row, "clm_trns_auth_cd",0);
//					sheet1.SetCellEditable(row, "trns_to_ofc_cd",0);
//					sheet1.SetCellEditable(row, "trns_to_usr_id",0);
//					sheet1.SetCellEditable(row, "trns_to_dt",0);
//					ComBtnDisable("btn1_Save");
//				}
//				//Accepted 된 데이타는 수정불가.
//				if(sheet1.GetCellValue(row,"clm_trns_auth_cd") ==  "A"){
//					sheet1.SetRowEditable(row,0);
//				}
			}
		}//for
	 }//if
}
  function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value=PageNo;  
	doActionIBSheet(SEARCHLIST01);
 }
 /**
  * IBSheet Object에서 입력값이 변경된 경우
  */
function sheet1_OnChange(sheetObj,Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) == "trns_to_ofc_cd" && Value != "") {
			doActionIBSheet(SEARCHLIST02, Row);
			sheet1.SetCellValue(Row,"trns_to_usr_id","");
	}
	if (sheetObj.ColSaveName(Col) == "trns_to_usr_id" && Value != "") {
			doActionIBSheet(SEARCHLIST03, Row);
	}
}
function sheet1_OnBeforeEdit(sheetObj,Row, Col) {
	if (sheetObj.ColSaveName(Col) == "trns_to_usr_id" && sheetObj.GetCellValue(Row,"trns_to_ofc_cd") == "") {//HOFC 입력후 Handler입력
			ComShowMessage("Please input HOFC before inputing Handler");//CNI00109
			sheet1.SelectCell(Row, "trns_to_ofc_cd");
	}
}
function sheet1_OnPopupClick(sheet, row, col) {
    if (sheet.ColSaveName(col) == "trns_rmk") {
		ComShowMemoPad(sheet);
	}
}
function sheet1_OnClick(sheetObj, row, col, value) {
	//Accepted 된 데이타는 수정불가.
	if(sheet1.GetCellValue(row,"clm_trns_auth_cd") ==  "A") return;
	if (sheetObj.ColSaveName(col) == "trns_rmk") {
		//권한
//		if(equalsRole("CNI03")|| equalsRole("CNI93")){
			ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
//		}else if(equalsRole("CNI02")){
//			if(frm.usr_area.value.trim() == sheet1.GetCellValue(row,"clm_area_cd").trim()){
//				ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
//			}
//		}else if(equalsRole("CNI01")){
//			if(frm.usr_id.value.trim() == sheet1.GetCellValue(row,"hdlr_usr_id").trim() && frm.usr_office.value.trim() == sheet1.GetCellValue(row,"hdlr_ofc_cd").trim()){
//				ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
//			}
//		}
	}
}
function sheet1_OnDblClick(sheetObj, row, col) {
	if (col <= 8) {
		var cgoClmNo = sheetObj.GetCellValue(row , "cgo_clm_no");
		location.href = "CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0003&cgo_clm_no=" + cgoClmNo;	
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction, Row) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		if(!validateForm()){
			return;
		}
		frm.f_cmd.value=SEARCHLIST01;	
		//sepatator 제거
		ComClearSeparator(frm.sch_date_from);
		ComClearSeparator(frm.sch_date_to);
//		alert(FormQueryString(frm));
 		var sXml=sheet1.GetSearchData("CPS_CNI_0036GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Append:1 , Sync:1} );
		}
		ComAddSeparator(frm.sch_date_from,"ymd");
		ComAddSeparator(frm.sch_date_to,"ymd");
	} 
	else if (sAction == SEARCHLIST02){
		var ofcCd=sheet1.GetCellValue(Row , "trns_to_ofc_cd");
 		var sXml=sheet1.GetSearchData("CPS_CNI_0036GS.do" , "f_cmd="+SEARCHLIST02+"&trns_to_ofc_cd="+ofcCd);
		var result=ComGetEtcData(sXml, "EXIST_OFC_CD");
		if(result != "Y"){
			ComShowCodeMessage("CNI00001" , "HOFC");
			sheet1.SetCellValue(Row,"trns_to_ofc_cd" ,"",0);
			sheet1.SelectCell(Row, "trns_to_ofc_cd");
		}
		sheet1.SelectCell(Row, "trns_to_ofc_cd", false);
	}
	else if (sAction == SEARCHLIST03){
		var ofcCd=sheet1.GetCellValue(Row , "trns_to_ofc_cd");
		var usrId=sheet1.GetCellValue(Row , "trns_to_usr_id");
 		var sXml=sheet1.GetSearchData("CPS_CNI_0036GS.do" , "f_cmd="+SEARCHLIST03+"&trns_to_ofc_cd="+ofcCd+"&trns_to_usr_id="+usrId);
		var result=ComGetEtcData(sXml, "EXIST_USR_ID");
		if(result != "Y"){
			ComShowCodeMessage("CNI00001" , "Handler");
			sheet1.SetCellValue(Row,"trns_to_usr_id" ,"",0);
			sheet1.SelectCell(Row, "trns_to_usr_id");
		}
		sheet1.SelectCell(Row, "trns_to_usr_id", false);
	}
	else if (sAction == MULTI) {		
			frm.f_cmd.value=MULTI;
			var sXml=sheet1.DoSave("CPS_CNI_0036GS.do", FormQueryString(frm),-1,false);
			if(sXml) {// paging 처리문제
			    frm.page_no.value="1";
				sheet1.RemoveAll();
				doActionIBSheet(SEARCHLIST01);
			}
	} else if (sAction == PRINT) {		
		frm.f_cmd.value=PRINT;
		//sepatator 제거
		ComClearSeparator(frm.sch_date_from);//ComClearSeparator(frm.sch_date_from,"ymd","-"); 이렇게 해도됨.
		ComClearSeparator(frm.sch_date_to);
		frm.page_no.value="";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0089.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]"
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv=rvParam();
		frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value="Transfer-Print";		
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/claimmain/report/CPS_CNI_0089.mrd";
		popupRd(1000,600);
	} 
}
function rvParam(){
	param="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"] sch_ofc_cd["+frm.sch_ofc_cd.value+"]sch_usr_id["+frm.sch_usr_id.value+"]";
	param=param + "sch_date_div_chk["+frm.sch_date_div_chk.value+"]sch_date_from["+frm.sch_date_from.value+"]sch_date_to["+frm.sch_date_to.value+"]";
	param=param + "Status["+frm.sch_trns_auth_cd_chk.value+"]";
	return param;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	if(ComReplaceStr(frm.sch_date_from.value,"-","").length != 8 || ComReplaceStr(frm.sch_date_to.value,"-","").length != 8){
		//msgs["CNI00001"] = "{?msg1} data is invalid.";
		ComShowCodeMessage("CNI00001" , "Transferred or Processed Date");
		return false;
	}
	return true;
}
