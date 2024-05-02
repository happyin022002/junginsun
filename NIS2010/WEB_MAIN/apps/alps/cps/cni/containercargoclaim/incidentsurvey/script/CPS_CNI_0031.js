/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0031.js
 *@FileTitle : [CPS_CNI_0031] Incident-Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [cps_cni_0031] Incident-Inquiry
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0031() {
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

// IBmultiCombo
var comboObjects = new Array();
var comboCnt = 0;
var combo1 = null;
var combo2 = null;
var comboText1 = "ALL";//RD를 위한변수 초기값을 ALL로 출력하기위함(AREA)
var comboText2 = "ALL";//POI
var param = "";

// html form
var frm = null;

// DOI, DORG 선택시 디폴트 세팅날짜.
var strFromDate = "";
var strToDate = "";

//디폴트 area cd
var clmAreaCd = "";

//초기로딩여부(콤보변경시 재조회할 경우 화면이 처음 열릴때는 제외한다)
var openPage = "";

//디폴트 INC No 세팅 = INCID+당해년도
var strGmtYear;

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

 /**
  * IBCombo Object를 배열에 등록
  * @param comboObj
  **/
 function setComboObject(comboObj){
 	comboObjects[comboCnt++] = comboObj;
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
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;

	//초기로딩여부
	openPage = "Y";
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }

	// IBMultiCombo초기화
	combo1 = comboObjects[0];
	combo2 = comboObjects[0];
	comboCnt = comboObjects.length;

	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}

	initComboBox();
	
	if(!ComIsNull(frm.schToStrGmt)){
		strGmtYear = frm.schToStrGmt.value.substring(0,4);
	}
	
	//초기값세팅
	combo1.Code = "ALL";
	frm.sch_str.value = "INCID"+strGmtYear;
	frm.sch_cond_chk.value = "INCI_NO";
	frm.sch_duration_chk.value = "DOI";
	
    // DOI, DORG 선택시 디폴트 세팅날짜.
	strFromDate = frm.schFromStrGmt.value;
	strToDate = frm.schToStrGmt.value;

	frm.sch_from_str.value = strFromDate;
	frm.sch_to_str.value = strToDate;

    //Form 이벤트 등록
    initControl();
    
    //Login User가 소속된 Office에서 Register한 Incident 를 Auto Retrieve.
	if(frm.sch_ofc_cd.value != "" && frm.sch_str.value != "INCID"+strGmtYear){
		doActionIBSheet(SEARCHLIST01);
	}
	
	ComSetFocus(frm.sch_str);

}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('click', 'obj_focus', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}

 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {

 	var sXml2 = frm.sXml.value;	

 	var arrXml = sXml2.split("|$$|");

 	setMultiComboBox("combo1" ,  arrXml[0] ); //09 Area
	setMultiComboBox("combo2" ,  arrXml[1] ); //14 poi

	//Area Cd Setting
 	var dataCount = ComGetTotalRows(arrXml[2]);
 	if (dataCount > 0) {
 		var list = SheetXml2ListMap(arrXml[2]);	
 		var listVO = list[0];
 		clmAreaCd = listVO["clm_area_cd"];
		//ComSetObjValue(frm.combo1,clmAreaCd);//초기값세팅.. 2010.01.21 요구사항변경됨(전체조회).
	}
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
					style.height = 260;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, CNI_PAGE_SIZE);

					var HeadTitle1 = "Seq.|Incident NO. |A|RGOFC|Register|DORG|POI|Location|DOI|VVD|Subject|DESC";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	               
					InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,	true,		"",	false,  "",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"cgo_clm_inci_no",	false,  "",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,	daCenter,		true,		"clm_area_cd",	false,  "",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"cre_ofc_cd",	false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"cre_usr_id",	false,  "",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"cre_dt",	false,  "",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,		"inci_plc_tp_cd",	false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"inci_loc_cd",	false,  "",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"inci_occr_dt",	false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,		"inci_ref_vvd_no",	false,  "",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		300,	daLeft,	true,		"inci_subj_nm",	false,  "",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		300,	daLeft,	true,		"inci_dev_desc",	false,  "",		dfNone,		0,	false,		false);
						
					//CountPosition = 0;
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
               }
                break;

        }
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 **/
function initCombo(comboObj, comboNo) {

	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.BackColor = "#ffffff";//"#CCFFFD";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
	}
} 


// ===================================================================================
// Private function
// ===================================================================================

/**
 * Location 설정
 */
 function setLocation(rowArray) { 
    frm.sch_loc_cd.value = rowArray[0][3];

    //값변경시 자동조회
	sheet1.RemoveAll();//append mode이므로 remove 해야함.
	frm.page_no.value="1";
	doActionIBSheet(SEARCHLIST01);
 }

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

	    //초기로딩여부
	    openPage = "N";

		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn1_Retrieve":
				/*
				var schStr = frm.sch_str.value;
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
					frm.sch_str.value = "INCID"+strGmtYear;
					frm.sch_from_str.value = strFromDate;
					frm.sch_to_str.value = strToDate;
					ComSetFocus(frm.sch_str);
				}
				break;

			case "btn1_Main":
				var cgoClmNo = sheet1.CellValue(sheet1.SelectRow , "clm_no");
				location.href = "CPS_CNI_0003.do?cgo_clm_no="+cgoClmNo;
				break;

			case "btn1_Print":
				if (sheet1.RowCount <= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 

			case "btns_location":
				//공통팝업 Location호출
				var locCd = frm.sch_loc_cd.value;
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
					var url = "CPS_CNI_0032_01.do?popupYn=Y&cgo_clm_inci_no="+frm.sch_str.value;
					var winName = "CPS_CNI_0032_01";
					var reqWin = openWinCenter(url,winName,1200,620);
				}else{
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
					ComSetFocus(frm.sch_str);
				}
				break;

			case "btn1_Down_Excel":
				sheet1.SpeedDown2Excel(-1)
                break;

		} // end switch

}

/**
 * HTML Control KeyPress 이벤트 호출
 */

function obj_keypress() {
    switch (event.srcElement.name) {    
		case "sch_str":  
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "sch_ofc_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "sch_loc_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "sch_from_str":
			ComKeyOnlyNumber(event.srcElement, "-");
			break;
		case "sch_to_str":
			ComKeyOnlyNumber(event.srcElement, "-");
			break;
	}
}

/**
 * HTML Control Click 이벤트 호출
 */
function obj_focus() {
    switch (event.srcElement.name) {  
		
		//Incident No.를 검색조건으로 선택하면 “INCID”는 자동 표시.
		case "sch_cond":
			if(frm.sch_cond[0].checked == true){
				frm.sch_str.value = "INCID"+strGmtYear;
				frm.sch_cond_chk.value = "INCI";//RD param
			}else{
				frm.sch_str.value = "";
				frm.sch_cond_chk.value = "VVD";//RD param
			}	
		break;

		case "sch_duration":
			frm.sch_from_str.value = strFromDate;
			frm.sch_to_str.value = strToDate;

			if(frm.sch_duration[0].checked == true){//RD 를 위한 변수
				frm.sch_duration_chk.value = "DOI";
			}else{
				frm.sch_duration_chk.value = "DORG";
			}	

		break;
	}
}

/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 
	 
    if (event.keyCode != 13) {
  		 return;
  	}
  	 
    switch (event.srcElement.name) {    
		case "sch_str":
		case "sch_from_str":
		case "sch_to_str":
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
		break;

		case "sch_ofc_cd":
			if (!ComIsNull(frm.sch_ofc_cd.value)) {
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;

		case "sch_cre_usr_id":
			if (!ComIsNull(frm.sch_cre_usr_id.value)) {
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;

		case "sch_loc_cd":
			if (!ComIsNull(frm.sch_loc_cd.value)) {
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;
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


function combo1_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	
	var arrVal = Text.split("|");

	if(arrVal.length >1){
		comboText1 = arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText1 = "ALL";
		}
	}else{
		comboText1 = arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText1 = "ALL";
		}
	}
	formObj.sch_area.value = ComGetObjValue(comboObj);

	//값변경시 자동조회
    if(openPage == "N"){
		sheet1.RemoveAll();//append mode이므로 remove 해야함.
		frm.page_no.value="1";
		doActionIBSheet(SEARCHLIST01);
	}

}

function combo2_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	
	var arrVal = Text.split("|");
	if(arrVal.length >1){
		comboText2 = arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText2 = "ALL";
		}
	}else{
		comboText2 = arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText2 = "ALL";
		}
	}
	formObj.sch_plc_tp_cd.value = ComGetObjValue(comboObj);

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
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */
function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmInciNo = sheet1.CellValue(row , "cgo_clm_inci_no");
	location.href = "CPS_CNI_0030.do?pgmNo=CPS_CNI_0030&cgo_clm_inci_no="+cgoClmInciNo;	
}

function sheet1_OnClick(sheet, row, col) {
	var desc = sheet1.CellValue(row , "inci_dev_desc");
	frm.inci_dev_desc.value = desc;
}

function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		frm.inci_dev_desc.value="";
		ComShowCodeMessage("CNI00013");
		
	}else{
			var desc = sheet1.CellValue(sheet1.SelectRow , "inci_dev_desc");
			frm.inci_dev_desc.value = desc;
	}
}

function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value = PageNo;  
	doActionIBSheet(SEARCHLIST01);
}   

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;

	if (sAction == SEARCHLIST01) {

		if(!validateForm()){
			return;
		}

		frm.f_cmd.value = SEARCHLIST01;	

		//sepatator 제거
		ComClearSeparator(frm.sch_from_str);
		ComClearSeparator(frm.sch_to_str);

		var sXml = sheet1.GetSearchXml("CPS_CNI_0031GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0], true);
		}

		ComAddSeparator(frm.sch_from_str,"ymd");
		ComAddSeparator(frm.sch_to_str,"ymd");

	} else if (sAction == PRINT) {	
		frm.f_cmd.value = PRINT;

		//sepatator 제거
		ComClearSeparator(frm.sch_from_str);
		ComClearSeparator(frm.sch_to_str);

		frm.page_no.value = "";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0086.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]"
		var rpaper = "/rpaper [A4]";
		
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		
		var rv =  rvParam();
		frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value = "Incident Inquiry-Print";		
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaim/incidentsurvey/report/CPS_CNI_0086.mrd";
//		var feature = "resizable=yes,width=1000,height=600"
//		ComOpenRDPopup(feature);
		popupRd(1000,600);

	} 
}

function rvParam(){
	
	if (frm.sch_cond_chk.value != "") {//INCI_NO , Area, poi
		param = "/rv sch_cond_chk["+frm.sch_cond_chk.value+"]sch_str["+frm.sch_str.value+"]Area["+comboText1+"]POI["+comboText2+"]";
	}
	
	if (frm.sch_ofc_cd.value != "") {//RGOFC
		param = param + "RGOFC["+frm.sch_ofc_cd.value+"]";
	}
    
	if (frm.sch_cre_usr_id.value != "") {//Register
		param = param + "Register["+frm.sch_cre_usr_id.value+"]";
	}

	if (frm.sch_loc_cd.value != "") {//Location
		param = param + "Location["+frm.sch_loc_cd.value+"]";
	}

	if (frm.sch_duration_chk.value != "") {//기간
		param = param + "sch_duration_chk["+frm.sch_duration_chk.value+"]from["+frm.sch_from_str.value+"]to["+frm.sch_to_str.value+"]";
	}

	return param;

}

/**
* IBMultiComboBox 설정<br>
* @param {select box} 콤보 객체
* @param {xml} code , name의 xml
* @param {String} 초기 선택 Code 
*/
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj      = null; // IBMultiComboBox
	var vArrayListData = ""; 
	var vListData      = "";
	var vCaptionText   = "";
	
	vComboObj = getComboObject(pComboObjId);
	
	if (vComboObj == null || pXML == null ) {
		return;
	}

	var vArrayListData = SheetXml2ListMap(pXML);

	vComboObj.InsertItem(0, "|", "");
	for ( var idx = 1; idx < vArrayListData.length+1; idx++) {
		vListData = vArrayListData[idx-1];
		vCaptionText = vListData["code"] + "|" + vListData["name"];
		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	}//end for
}

/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 **/
function getComboObject(pComboObjId){
	var vCnt = comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].id == pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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