/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0312.js
 *@FileTitle : [CPS_CNI_0312] Transfer
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0312] Transfer
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_CNI_0312() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
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
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// html form
var frm = null;
var frm2 = null;

// grid combo
var comboText = "";
var comboCode = "";

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage() {
    //전역 변수 설정 
    frm = document.form;
	frm2 = document.form2;//멀티콤보용
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;

	//initSheet 보다 먼저해준다.
	initComboBox();
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }

	//초기값세팅
	frm.sch_date_div_chk.value = "Transferred";
	frm.sch_trns_auth_cd_chk.value = "Waiting";
   
    //Form 이벤트 등록
    initControl();

	doActionIBSheet(SEARCHLIST01);

}

/**
* Form 이벤트 등록
*/
function initControl() {
   //keypress
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   //keydown
   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   // focus in
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   // focus out
   axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
   //key up
   axon_event.addListenerForm('keyup', 'obj_keyup',frm);
   //focus
   axon_event.addListenerForm ('click', 'obj_focus', frm);

}

 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {

 	var sXml2 = frm2.sXml.value;	

 	var arrXml = sXml2.split("|$$|");

 	setMultiComboBox(arrXml[0] ); //32
 	
}

function setMultiComboBox(pXML) {
	var vArrayListData = ""; 
	var vListData      = "";

	var vArrayListData = SheetXml2ListMap(pXML);
	
	for ( var idx = 0; idx < vArrayListData.length; idx++) {
	    vListData = vArrayListData[idx];
		comboText += vListData["name"] + "|" ;
		comboCode += vListData["code"] + "|" ;
	}

	comboText = comboText.substring(0, comboText.length -1);
	comboCode = comboCode.substring(0, comboCode.length -1);

}



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with (sheetObj) {

				// 높이 설정
				style.height = 430;
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 15, CNI_PAGE_SIZE);

				var HeadTitle1 = "|Seq.|Case No.|Status|Frequency|Transferor|Transferor|Transferor|Transferee|Transferee|Transferee|Transferee|Transferee|div|hdlr_usr_id|hdlr_ofc_cd|upd_usr_id|clm_misc_cd";
				var HeadTitle2 = "|Seq.|Case No.|Status|Frequency|HOFC|Handler|Date|Status|HOFC|Handler|Date|Remark|div|hdlr_usr_id|hdlr_ofc_cd|upd_usr_id|clm_misc_cd";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
									
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
			   
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
				
				InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,	true,		"",					false,	    "",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"dw_clm_no",		false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		100,daCenter,	true,		"clm_misc_nm",		false,	    "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,		"trns_knt",			false,      "",				dfNone,		0,			false,		false);				
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"trns_fm_ofc_cd",	false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,		"trns_fm_usr_id",	false,	    "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,		"trns_fm_dt",		false,      "",				dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,	80,	daCenter,	true,		"clm_trns_auth_cd",	false,	    "",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"trns_to_ofc_cd",	false,      "",				dfNone,		0,			true,		true);			
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"trns_to_usr_id",	false,      "",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"trns_to_dt",		false,	    "",				dfDateYmd,	0,			true,		true);
				InitDataProperty(0, cnt++ , dtPopup,	280,daLeft,		true,		"trns_rmk",			false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,	true,		"div",				false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	80,	daCenter,	true,		"hdlr_usr_id",		false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	80,	daCenter,	true,		"hdlr_ofc_cd",		false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	80,	daCenter,	true,		"upd_usr_id",		false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,		"clm_misc_cd",		false,	    "",				dfNone,		0,			false,		false);
				
				InitDataCombo(0, "clm_trns_auth_cd", comboText, comboCode);
				InitDataValid(0, "trns_to_ofc_cd",    vtEngUpOnly);

				InitViewFormat(0, "trns_fm_dt", "yyyy-mm-dd");
				InitViewFormat(0, "trns_to_dt", "yyyy-mm-dd");
									
				//CountPosition = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";

				PopupImage  =  "img/btns_inquiry.gif";
				ShowButtonImage = 2;
		   }
			break;

	}
}

// ===================================================================================
// Private function
// ===================================================================================
// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal = new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

		var srcName = window.event.srcElement.getAttribute("name");
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
				frm.f_cmd.value = MULTI;	

			    var findRow ;
			    var acceptRow ;
			   //FindText(Col, SearchText, [StartRow], [FullMatch], [CaseSensitive]) 
			   for(var row = 1; row <= sheet1.RowCount+1 ; row++){
					findRow = sheet1.FindText("clm_trns_auth_cd", "Rejected", row, -1, false);
					if(findRow != -1){
						if(sheet1.CellValue(findRow,"trns_rmk").trim()  == ""){
							ComShowMessage("Please remark reason for rejection");//CNI00108
							sheet1.SelectCell(findRow, "trns_rmk");
							return;
						}
					}
					
					acceptRow = sheet1.FindText("clm_trns_auth_cd", "Accepted", row, -1, false);
					if(acceptRow != -1){
						if(sheet1.CellValue(acceptRow,"trns_to_ofc_cd").trim()  == ""){
							ComShowCodeMessage("CNI00009" , "HOFC");
							//sheet1.SelectCell(acceptRow, "trns_to_ofc_cd");
							return;
						}
						if(sheet1.CellValue(acceptRow,"trns_to_usr_id").trim()  == ""){
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
				sheet1.SpeedDown2Excel(-1)
				break; 

			case "btn1_Print":
				if (sheet1.RowCount <= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 

			case "sch_date_div":

				if(frm.sch_date_div[0].checked == true){//RD 를 위한 변수
					frm.sch_date_div_chk.value = "Transferred";
				}else{
					frm.sch_date_div_chk.value = "Processed";
				}	

				//값변경시 자동조회
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);

			break;

			case "sch_trns_auth_cd":

				if(frm.sch_trns_auth_cd[0].checked == true){//RD 를 위한 변수
					frm.sch_trns_auth_cd_chk.value = "Waiting";
				}
				if(frm.sch_trns_auth_cd[1].checked == true){
					frm.sch_trns_auth_cd_chk.value = "Accepted";
				}
				if(frm.sch_trns_auth_cd[2].checked == true){
					frm.sch_trns_auth_cd_chk.value = "Rejected";
				}
				if(frm.sch_trns_auth_cd[3].checked == true){
					frm.sch_trns_auth_cd_chk.value = "All";
				}

				//값변경시 자동조회
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);

			break;

		} // end switch

}

 /**
 * HTML Control KeyPress 이벤트 호출
 */

function obj_keypress() {
    switch (event.srcElement.name) {    
		case "sch_ofc_cd":  
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "sch_usr_id":  
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}


/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {
    switch (event.srcElement.name) {    
		case "sch_ofc_cd":
		case "sch_usr_id":
			if (event.keyCode == 13) {

				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;

//		case "sch_usr_id":
//			if (!ComIsNull(frm.sch_usr_id.value) && event.keyCode == 13) {
//
//				sheet1.RemoveAll();//append mode이므로 remove 해야함.
//				frm.page_no.value="1";
//				doActionIBSheet(SEARCHLIST01);
//			}
//		break;

		case "sch_date_from":
			if (!ComIsNull(frm.sch_date_from.value) && event.keyCode == 13) {

				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;

		case "sch_date_to":
			if (!ComIsNull(frm.sch_date_to.value) && event.keyCode == 13) {

				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;

	}
}

/**
 * HTML Control KeyUp 이벤트 호출
 */
function obj_keyup() {
    switch (event.srcElement.name) {  

	}
}

/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm = document.form;
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


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
/**
 * FROM / TO 데이타 처리 
 * 1. FROM 인 경우는 claim no 에 밑줄넣고 빨간색표시
 * 2. 권한설정 : FROM (trns_to_ofc_cd,trns_rmk)
 * 				 TO  (clm_trns_auth_cd,trns_to_ofc_cd,trns_to_usr_id,trns_to_dt,trns_rmk) 이 수정가능한 부분인데
 *               usr_roles 에 따라 editable 설정을 변경한다.
 *               단,trns_rmk 는  sheet1_OnClick 함수에서 설정한다.    
 */
 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	var usr_roles = frm.usr_roles.value;
	var usr_id = frm.usr_id.value;
	var usr_area = frm.usr_area.value;
	var usr_office = frm.usr_office.value;
	
	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}else{

		for(var row = 1; row <= sheet1.RowCount+1 ; row++){
			if(sheet1.CellValue(row,"div").toUpperCase()  == "FROM"){
				sheet1.CellEditable(row, "clm_trns_auth_cd") = false;
				sheet1.CellEditable(row, "trns_to_usr_id") = false;
				sheet1.CellEditable(row, "trns_to_dt") = false;
				
				sheet1.CellFontColor(row, "dw_clm_no") = sheet1.RgbColor(255, 0, 0);
				sheet1.CellFontUnderline(row, "dw_clm_no") = true;
				
				//권한
				if(equalsRole("CNI32") || equalsRole("CNI33") || equalsRole("CNI93")){
					sheet1.CellEditable(row, "trns_to_ofc_cd") = true;
				}else if(equalsRole("CNI31")){
					if(usr_id == sheet1.CellValue(row,"hdlr_usr_id") && usr_office == sheet1.CellValue(row,"hdlr_ofc_cd")){
						sheet1.CellEditable(row, "trns_to_ofc_cd") = true;
					}else{
						sheet1.CellEditable(row, "trns_to_ofc_cd") = false;
					}
				}else{
					sheet1.CellEditable(row, "trns_to_ofc_cd") = false;
					ComBtnDisable("btn1_Save");
				}
			}
			
			if(sheet1.CellValue(row,"div").toUpperCase()  == "TO"){
				//권한
				if(equalsRole("CNI32") || equalsRole("CNI33") || equalsRole("CNI93")){
					sheet1.CellEditable(row, "clm_trns_auth_cd") = true;
					sheet1.CellEditable(row, "trns_to_ofc_cd") = true;
					sheet1.CellEditable(row, "trns_to_usr_id") = true;
					sheet1.CellEditable(row, "trns_to_dt") = true;
				}else if(equalsRole("CNI31")){
					if(usr_office == sheet1.CellValue(row,"trns_to_ofc_cd")){
						sheet1.CellEditable(row, "clm_trns_auth_cd") = true;
						sheet1.CellEditable(row, "trns_to_ofc_cd") = true;
						sheet1.CellEditable(row, "trns_to_usr_id") = true;
						sheet1.CellEditable(row, "trns_to_dt") = true;
					}else{
						sheet1.CellEditable(row, "clm_trns_auth_cd") = false;
						sheet1.CellEditable(row, "trns_to_ofc_cd") = false;
						sheet1.CellEditable(row, "trns_to_usr_id") = false;
						sheet1.CellEditable(row, "trns_to_dt") = false;
					}
				}else{
					sheet1.CellEditable(row, "clm_trns_auth_cd") = false;
					sheet1.CellEditable(row, "trns_to_ofc_cd") = false;
					sheet1.CellEditable(row, "trns_to_usr_id") = false;
					sheet1.CellEditable(row, "trns_to_dt") = false;
					ComBtnDisable("btn1_Save");
				}
				
				//Accepted 된 데이타는 수정불가.
				if(sheet1.CellValue(row,"clm_trns_auth_cd") ==  "A"){
					sheet1.RowEditable(row)  = false;
				}
				
			}

		}//for
	 }//if
}

 function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value = PageNo;  
	doActionIBSheet(SEARCHLIST01);
 }
 
 /**
  * IBSheet Object에서 입력값이 변경된 경우
  */
function sheet1_OnChange(sheetObj,Row, Col, Value) {

	if (sheetObj.ColSaveName(Col) == "trns_to_ofc_cd" && Value != "") {
			doActionIBSheet(SEARCHLIST02, Row);
			sheet1.CellValue(Row,"trns_to_usr_id") = "";
	}

	if (sheetObj.ColSaveName(Col) == "trns_to_usr_id" && Value != "") {
			doActionIBSheet(SEARCHLIST03, Row);
	}

}


function sheet1_OnBeforeEdit(sheetObj,Row, Col) {
	if (sheetObj.ColSaveName(Col) == "trns_to_usr_id" && sheetObj.CellValue(Row,"trns_to_ofc_cd") == "") {//HOFC 입력후 Handler입력
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
	if(sheet1.CellValue(row,"clm_trns_auth_cd") ==  "A") return;
	
	if (sheetObj.ColSaveName(col) == "trns_rmk") {
		//권한
		if(equalsRole("CNI32") || equalsRole("CNI33") || equalsRole("CNI93")){
			ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
		}else if(equalsRole("CNI31")){
			if(frm.usr_id.value.trim() == sheet1.CellValue(row,"hdlr_usr_id").trim() && frm.usr_office.value.trim() == sheet1.CellValue(row,"hdlr_ofc_cd").trim()){
				ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
			}
		}
	}
}

function sheet1_OnDblClick(sheetObj, row, col) {
	if (col <= 7) {
		var dwClmNo = sheetObj.CellValue(row , "dw_clm_no");
		location.href = "CPS_CNI_0301.do?pgmNo=CPS_CNI_0301&dw_clm_no="+dwClmNo;	
	}
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction, Row) {
	//sheetObj.ShowDebugMsg = false;

	if (sAction == SEARCHLIST01) {

		if(!validateForm()){
			return;
		}

		frm.f_cmd.value = SEARCHLIST01;	

		//sepatator 제거
		ComClearSeparator(frm.sch_date_from);
		ComClearSeparator(frm.sch_date_to);

		var sXml = sheet1.GetSearchXml("CPS_CNI_0312GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0], true);
		}

		ComAddSeparator(frm.sch_date_from,"ymd");
		ComAddSeparator(frm.sch_date_to,"ymd");

	} 
	else if (sAction == SEARCHLIST02){
		var ofcCd = sheet1.CellValue(Row , "trns_to_ofc_cd");

		var sXml = sheet1.GetSearchXml("CPS_CNI_0312GS.do" , "f_cmd="+SEARCHLIST02+"&trns_to_ofc_cd="+ofcCd);
		var result = ComGetEtcData(sXml, "EXIST_OFC_CD");

		if(result != "Y"){

			ComShowCodeMessage("CNI00001" , "HOFC");

			sheet1.CellValue2(Row,"trns_to_ofc_cd" ) = "";
			sheet1.SelectCell(Row, "trns_to_ofc_cd");
		}
		sheet1.SelectCell(Row, "trns_to_ofc_cd", false);
		
	}
	else if (sAction == SEARCHLIST03){
		var ofcCd = sheet1.CellValue(Row , "trns_to_ofc_cd");
		var usrId = sheet1.CellValue(Row , "trns_to_usr_id");

		var sXml = sheet1.GetSearchXml("CPS_CNI_0312GS.do" , "f_cmd="+SEARCHLIST03+"&trns_to_ofc_cd="+ofcCd+"&trns_to_usr_id="+usrId);
		var result = ComGetEtcData(sXml, "EXIST_USR_ID");

		if(result != "Y"){
			ComShowCodeMessage("CNI00001" , "Handler");
			sheet1.CellValue2(Row,"trns_to_usr_id" ) = "";
			sheet1.SelectCell(Row, "trns_to_usr_id");
		}
		sheet1.SelectCell(Row, "trns_to_usr_id", false);
		
	}
	else if (sAction == MULTI) {		
		
			frm.f_cmd.value = MULTI;
						
			var sXml = sheet1.DoSave("CPS_CNI_0312GS.do", FormQueryString(frm),-1,false);
			if(sXml) {// paging 처리문제
			    frm.page_no.value = "1";
				sheet1.RemoveAll();
				doActionIBSheet(SEARCHLIST01);
			}
	} else if (sAction == PRINT) {		
		frm.f_cmd.value = PRINT;

		//sepatator 제거
		ComClearSeparator(frm.sch_date_from);
		ComClearSeparator(frm.sch_date_to);

		frm.page_no.value = "";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0313.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]"
		var rpaper = "/rpaper [A4]";
		var rv =  rvParam();
		frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value = "Transfer-Print";		
		frm.com_mrdPath.value = "apps/alps/cps/cni/drywetclaim/drywetclaim/report/CPS_CNI_0313.mrd";
		popupRd(1000,600);
	} 
}

function rvParam(){
	
	param = "/rv sch_ofc_cd["+frm.sch_ofc_cd.value+"]sch_usr_id["+frm.sch_usr_id.value+"]";

	param = param + "sch_date_div_chk["+frm.sch_date_div_chk.value+"]sch_date_from["+frm.sch_date_from.value+"]sch_date_to["+frm.sch_date_to.value+"]";

	param = param + "Status["+frm.sch_trns_auth_cd_chk.value+"]";

	return param;

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	if(ComReplaceStr(frm.sch_date_from.value,"-","").length != 8 || ComReplaceStr(frm.sch_date_to.value,"-","").length != 8){
		//msgs["CNI00001"] = "{?msg1} data is invalid.";
		ComShowCodeMessage("CNI00001" , "Transferred or Processed Date");
		return false;
	}

	return true;
}