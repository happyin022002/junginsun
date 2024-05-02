/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0020.js
 *@FileTitle : [CPS_CNI_0020] Report-Settlement Analysis
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [cps_cni_0020] Report-Settlement Analysis
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0020() {
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
var comboText1 = "ALL";//RD를 위한변수 초기값을 ALL로 출력하기위함(AREA)
var comboText2 = "ALL";//
var comboText3 = "ALL";//
var param = "";

// html form
var frm = null;
var frm2 = null;

// Period 디폴트 세팅날짜.
var strFromDate = "";
var strToDate = "";

//디폴트 area cd
var clmAreaCd = "";

var area_cd = "";//area cd

var mainCode = "";
var locationCode = "";

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
	frm2 = document.form2;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }

	// IBMultiCombo초기화
	comboCnt = comboObjects.length;

	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}

	initComboBox();

    // Period디폴트 세팅날짜.
	strFromDate = frm.schFromStrGmt.value;
	strToDate = frm.schToStrGmt.value;

	frm.from_period.value = strFromDate;
	frm.to_period.value = strToDate;
	
	frm.rd_title.value = ComGetObjText(frm.report_by);
    
    //Form 이벤트 등록
    initControl();
    
}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm ('change', 'obj_change', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);

}

 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {

 	var sXml2 = frm2.sXml.value;	
 	var arrXml = sXml2.split("|$$|");
	var idx = 0;

    setMultiComboBox("period" ,  arrXml[idx] ); //25 period [1]
	idx++;

 	setMultiComboBox("area" ,  arrXml[idx] ); //09 Area [2]
	idx++;

	setMultiComboBox("status" ,  arrXml[idx] ); //08 status [3]
	idx++;

	setMultiComboBox("inci_plc_tp_cd" ,  arrXml[idx] ); //14 poi [4]
	idx++;

	setMultiComboBox("cgo_clm_stl_tp_cd" ,  arrXml[idx] ); //07 tos [5]
	idx++;

	setMultiComboBox("crr_term_cd" ,  arrXml[idx] ); //06 CT (terms of carriage ) [6]
	idx++;
	
	setMultiComboBox("cgo_clm_tp_cd" ,  arrXml[idx] ); //11 TOC (Type of Cargo Claim ) [7]
	idx++;
	
  	//Area Cd Setting
 	var dataCount = ComGetTotalRows(arrXml[idx]);// [6]
 	if (dataCount > 0) {
 		var list = SheetXml2ListMap(arrXml[idx]);	// [6]
 		var listVO = list[0];
 		clmAreaCd = listVO["clm_area_cd"];
		ComSetObjValue(frm.area,clmAreaCd);//초기값세팅
	}

	ComSetObjValue(frm.period,"DON");
	ComSetObjValue(frm.vt, "G");
	
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
				style.height = 320;
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msHeaderOnly;
				 MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 15, CNI_PAGE_SIZE);

				var HeadTitle1 = "|Seq.|Area|Area|Claimed|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Outstanding|Outstanding|Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment|" +
						 "Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment";
				var HeadTitle2 = "|Seq.|Area|Area|Claimed|Paid|Time Barred|Withdrawn|Repudiated|Tender of Defense|Dismissed|Total| | |Paid|Paid|LP Recovered|LP Recovered|INS Recovered|INS Recovered|" +
						 "Total Recovered|Total Recovered|Net Paid|Net Paid";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
									
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
			   
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,			daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,		"data_seq",				false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,		"report_by",			false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	false,		"div",					false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"claimed",				false,		"",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"paid",					false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"time_barred",			false,		"",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"withdrawn",			false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"repudiated",			false,		"",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"tender_defence",		false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"dismissed",			false,		"",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"tot",					false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"outstanding",			false,		"",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,			daRight,	false,		"outstanding_p",		false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"paid_dp",				false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,			daRight,	false,		"paid_dp_p",			false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"lp_recovered",			false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,			daRight,	false,		"lp_recovered_p",		false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"ins_recovered",		false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,			daRight,	false,		"ins_recovered_p",		false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"total_recovered",		false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,			daRight,	false,		"total_recovered_p",	false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,		"net_paid",				false,      "",				dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,			daRight,	false,		"net_paid_p",			false,		"",				dfNone,		0,			false,		false);
						
				//CountPosition = 0;

				//Row, Col, Rows, Cols
				SetMergeCell(0, 2, 2, 2);//Report by
				SetMergeCell(0, 4, 2, 1);//Claimed
				//SetMergeCell(0, 12, 2, 2);//Outstanding
				
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
		if(comboNo >= 4){
			comboObj.BackColor = "#ffffff";
		}else{
			comboObj.BackColor = "#CCFFFD";
		}
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 175;
	}
} 

// ===================================================================================
// Private function
// ===================================================================================

/**
 * Location 설정
 */
 function setLocation(rowArray) { 
 	  if (locationCode == "POR"){
        frm.por_cd.value = rowArray[0][3];
    } else if ( locationCode == "DEL") {
       frm.del_cd.value = rowArray[0][3]; 
    }	    
 }

// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal = new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}

function setOfficeCode(ofcCd){
	frm.hndl_ofc_cd.value = ofcCd;
}

function setMainCodeInquiry(partyVo) {
	switch(mainCode){
	case "claimant":
		frm.clmt_clm_pty_no.value = partyVo.clm_pty_no;
		frm.clmt_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
		break;
	case "claimant_agent":
		frm.clmt_clm_agn_pty_no.value = partyVo.clm_pty_no;
		frm.clmt_clm_agn_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
		break;	
	case "insurer":
		frm.insur_clm_pty_no.value = partyVo.clm_pty_no;
		frm.insur_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
		break;
	case "liable_party":
		frm.labl_clm_pty_no.value = partyVo.clm_pty_no;
		frm.clm_liable_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
		break;
	case "salvager":
		frm.slv_clm_pty_no.value = partyVo.clm_pty_no;
		frm.slv_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
	 	break;
	case "surveyor":
		frm.svey_clm_pty_no.value = partyVo.clm_pty_no;
		frm.clm_surveyor_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
		break
	}
} 

//Miscellaneous 팝업창에서 호출한 함수
function setMiscCode(miscCdVO){
	var clss_clm_misc_cd = miscCdVO.clss_clm_misc_cd;
	
	switch(clss_clm_misc_cd){
		case "02":
			frm.mjr_clm_dmg_lss_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "39":
			frm.n3rd_labl_pty_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "11":
			frm.cgo_clm_tp_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "14":
			frm.inci_plc_tp_cd.value = miscCdVO.clm_misc_cd;
			break;
		case "15":
			frm.clm_cgo_tp_cd.value = miscCdVO.clm_misc_cd;
			frm.clm_cgo_tp_nm.value = miscCdVO.clm_misc_nm;
			break;	
	}
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

			case "btn1_Retrieve":

				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";

				doActionIBSheet(SEARCHLIST01);
				
				break;	

			case "btn1_New":
				ComResetAll();
				sheet1.CellValue(0, 2)  = ComGetObjText(frm.report_by);
				sheet1.CellValue(0, 3)  = ComGetObjText(frm.report_by); 

				ComSetObjValue(frm.from_period,ComGetNowInfo("yy") + "-01-01");
				ComSetObjValue(frm.to_period,ComGetNowInfo());
				ComSetObjValue(frm.period,"DON");
				ComSetObjValue(frm.vt, "G");
				ComSetObjValue(frm.status, "All");
				ComSetObjValue(frm.area, clmAreaCd);//초기값세팅
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

			case "btns_date_cal1":
				calendarDisplay(frm.sch_from_str);
				break;
			
			case "btns_date_cal2":
				calendarDisplay(frm.sch_to_str);
				break;

			case "btn1_Cargo":
				popupMainMiscView("15");
				break;

			case "btn1_TOC":
				popupMainMiscView("11");
				break;

			case "btn1_CODL1":
				popupMainMiscView("02");
				break;

			case "btn1_CODL2":
				popupMainMiscView("39");
				break;
		  
		    case "btn1_POI":
				popupMainMiscView("14");
				break;
		  
		    case "btn1_POR":
				//공통팝업 Location호출
				var locCd = frm.por_cd.value;
				locationCode = "POR";
				popupLocation(locCd);
				break;
				
			case "btn1_DEL":
				//공통팝업 Location호출
				var locCd = frm.del_cd.value;
				locationCode = "DEL";
				popupLocation(locCd);
				break ;

			case "btn1_Liable_Party":
			case "btn1_Surveyor":
			case "btn1_Claimant":
			case "btn1_Claimant_Agent":
			case "btn1_Salvager":
			case "btn1_Insurer":
				mainCode = srcName.replace("btn1_", "").toLowerCase();
				popupMainCodeInquiry();
				break;
				
			case "btns_from_period":
			case "btns_to_period":
				var result = srcName.replace("btns_", "");
			    calObj = eval("frm." + result );
				var vCal = new ComCalendar();
				vCal.setDisplayType('date');
				vCal.select(calObj, 'yyyy-MM-dd');
				break;

			case "btns_hndl_ofc_cd":
				popupOfficeCode();
				break;

		} // end switch

}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {

	obj = event.srcElement;
    if(obj.dataformat == null) return;
    
    window.defaultStatus = obj.dataformat;

    switch(obj.dataformat) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
        case "yyyy":
            ComKeyOnlyNumber(obj);
            break;
        case "int":
            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
            else ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
        case "userYmd":
            ComKeyOnlyNumber(obj, "-");
            break;
    }
}

/**
 * HTML Control Click 이벤트 호출
 */
function obj_change() {
    switch (event.srcElement.name) {  

		case "report_by":
			//1.Grid Title Setting
				sheet1.CellValue(0, 2)  = ComGetObjText(frm.report_by);
				sheet1.CellValue(0, 3)  = ComGetObjText(frm.report_by); 
				sheet1.CellValue(1, 2)  = ComGetObjText(frm.report_by);
				sheet1.CellValue(1, 3)  = ComGetObjText(frm.report_by); 
			//2. RD Title Setting
			    frm.rd_title.value = ComGetObjText(frm.report_by);
			   
			//Month 선택시 고려사항.    
			frm.to_period.readOnly = false;
			if(frm.from_period.value.length < 8){//계속 초기화됨을 막기위함.
				frm.from_period.value = strFromDate;
			}
			if(frm.to_period.value.length < 8){
				frm.to_period.value = strToDate;
			}
			
			if(frm.report_by.value == 'MONTH'){
				frm.to_period.value="";
				frm.to_period.readOnly = true;
				ComSetObjValue(frm.from_period,strToDate.substring(0,4));
			}
			if(frm.report_by.value == 'YEAR'){
				var fromYear = getDateObj(strFromDate).getYear()-1;//getDateObj <- CoCommon.js
				ComSetObjValue(frm.from_period,fromYear);
				ComSetObjValue(frm.to_period,strToDate.substring(0,4));
			}
		break;
	}
}


/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {

	 if (event.keyCode != 13) {
  		 return;
  	 }
	 
    switch (event.srcElement.name) {    
		default:
			if (!ComIsNull(frm.from_period.value) && !ComIsNull(frm.to_period.value)) {
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
	case "from_period":
	case "to_period":
		    if(frm.report_by.value.toUpperCase() == "YEAR" || frm.report_by.value.toUpperCase() == "MONTH"){
		    	obj.dataformat = "yyyy";
		    }else{
		    	obj.dataformat = "ymd";
		    }
		    ComChkObjValid(event.srcElement);
		break;

	default:
		ComChkObjValid(event.srcElement);
	}
}


/**
 * HTML Control Foucs in
 */

function obj_activate(){
	obj = event.srcElement;
	//readonly 일때 데이터 포맷 변경되는 것  방지
	if (obj.getAttribute("readOnly")) return;
	
	switch (event.srcElement.name) {  
		//조회날짜 입력항목이 YEAR, MONTH 의 경우 년도 만 입력하므로 Common Script 를 사용하지 않고 별도로 작성함.
		case "from_period":
		case "to_period":
		    if(frm.report_by.value.toUpperCase() == "YEAR" || frm.report_by.value.toUpperCase() == "MONTH"){
		    	obj.dataformat = "yyyy";
		    }else{
		    	obj.dataformat = "ymd";
		    }
		    ComClearSeparator(obj);
			break;
		default:
			ComClearSeparator(obj);
	}
}

function period_OnChange(comboObj, Index_Code, Text) {
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
}

function area_OnChange(comboObj, Index_Code, Text) {
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
	formObj.clm_area_cd.value = ComGetObjValue(comboObj);

}

function status_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	
	var arrVal = Text.split("|");
	if(arrVal.length >1){
		comboText3 = arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText3 = "ALL";
		}
	}else{
		comboText3 = arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText3 = "ALL";
		}
	}
	formObj.cgo_clm_sts_cd.value = ComGetObjValue(comboObj);

}

function cgo_clm_stl_tp_cd_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	
	var arrVal = Text.split("|");
	if(arrVal.length >1){
		comboText5 = arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText5 = "ALL";
		}
	}else{
		comboText5 = arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText5 = "ALL";
		}
	}

}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================

 function sheet1_OnSearchEnd(sheet, ErrMsg) {

	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
		
	}
 }

  function sheet1_OnDblClick(sheetObj, Row, Col) {
	//alert(Row +" : "+Col)
 }

 function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {	
	
	//스크롤시에 Total 을 숨기기 위함.
	for(var row = 1; row <= sheet1.RowCount+1 ; row++){
		findRow = sheet1.FindText("report_by", "Total", row, -1, false);
		if(findRow != -1){
			sheet1.RowHidden(findRow) = true;
		}
	}
	//frm.page_no.value = PageNo;  
	frm.page_no.value = Math.ceil(PageNo/2); //amount, case 로 나오므로 page no 를 변형해야한다. : 페이징할경우 그래도 Total 은 해결할 수 없다.
	doActionIBSheet(SEARCHLIST01);
 } 

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;

	if (sAction == SEARCHLIST01) {
		
		//validateForm 보다 먼저 설정.
		if(frm.report_by.value == 'MONTH'){
			ComSetObjValue(frm.to_period,ComGetObjValue(frm.from_period));
		}

		if(!validateForm(sAction)){
			return;
		}

		frm.f_cmd.value = SEARCHLIST01;	
		
		var from_period = ComGetObjValue(frm.from_period);
		var to_period = ComGetObjValue(frm.to_period);
		var from_clmt_usd_amt = ComGetObjValue(frm.from_clmt_usd_amt);
		var to_clmt_usd_amt = ComGetObjValue(frm.to_clmt_usd_amt);
		var from_cgo_clm_stl_usd_amt = ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
		var to_cgo_clm_stl_usd_amt = ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Mask Clear
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		ComClearSeparator(frm.from_clmt_usd_amt);
		ComClearSeparator(frm.to_clmt_usd_amt);
		ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
		ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Data 
		var vFormData = FormQueryString(frm);
		
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
		ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
		ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
		ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
		ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0020GS.do", vFormData);		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0], true);
		}
		
		//Data 가 있을 경우만 아래를 적용함
		if(sheet1.RowCount ==0) return;
		for(var row = 1; row <= sheet1.RowCount+1 ; row++){
			// Total ROW의 컬러적용
			findRow = sheet1.FindText("report_by", "Total", row, -1, false);
			if(findRow != -1){
				sheet1.RowBackColor(findRow) = sheet1.RgbColor(255, 230, 230);
			}
			
			//아래처럼 설정하면 데이타가 많을 경우 화면세팅시간이 걸림.
			//Total Recovered/Net Paid Case 데이타 컬러적용.
			var caseRow = sheet1.FindText("div", "Case", row, -1, false);
			sheet1.Redraw=false;
			sheet1.CellBackColor(caseRow, "total_recovered")= sheet1.RgbColor(234,234,234);
			sheet1.CellBackColor(caseRow, "total_recovered_p")= sheet1.RgbColor(234,234,234);
			sheet1.CellBackColor(caseRow, "net_paid")= sheet1.RgbColor(234,234,234);
			sheet1.CellBackColor(caseRow, "net_paid_p")= sheet1.RgbColor(234,234,234);
			//포멧 변경
			sheet1.InitCellProperty(caseRow,"total_recovered",dtData, daRight, "total_recovered", "", dfNone);
			sheet1.InitCellProperty(caseRow,"total_recovered_p",dtData, daRight, "total_recovered_p", "", dfNone);
			sheet1.InitCellProperty(caseRow,"net_paid",dtData, daRight, "net_paid", "", dfNone);
			sheet1.InitCellProperty(caseRow,"net_paid_p",dtData, daRight, "net_paid_p", "", dfNone);
			sheet1.CellValue(caseRow, "total_recovered") = ""; 
			sheet1.CellValue(caseRow, "total_recovered_p") = "";
			sheet1.CellValue(caseRow, "net_paid") = "";
			sheet1.CellValue(caseRow, "net_paid_p") = "";
			sheet1.Redraw=true;

		}

	} else if (sAction == PRINT) {	
		frm.f_cmd.value = PRINT;

		if(!validateForm(sAction)){
			return;
		}
		
		//RD Header , Title.
		frm.rd_report_by.value = frm.rd_title.value;
		frm.rd_title_nm.value = "Settlement Analysis by "+frm.rd_title.value;
		
		var from_period = ComGetObjValue(frm.from_period);
		var to_period = ComGetObjValue(frm.to_period);
		var from_clmt_usd_amt = ComGetObjValue(frm.from_clmt_usd_amt);
		var to_clmt_usd_amt = ComGetObjValue(frm.to_clmt_usd_amt);
		var from_cgo_clm_stl_usd_amt = ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
		var to_cgo_clm_stl_usd_amt = ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Mask Clear
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		ComClearSeparator(frm.from_clmt_usd_amt);
		ComClearSeparator(frm.to_clmt_usd_amt);
		ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
		ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
		
		// Form Object Data 
		var vFormData = FormQueryString(frm);
		
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
		ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
		ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
		ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
		ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
		
		//RD Parameter Initialize
		frm.com_mrdArguments.value = "";
		frm.com_mrdBodyTitle.value = "";
		frm.com_mrdPath.value = "";
		
		frm.page_no.value = "";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0076.do]";
		var rpost =  "/rpost ["+vFormData+"]"
		var rpaper = "/rpaper [A4]";
		
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		
		var rv = "/rv " + getCondAllValue();
		frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value = "Settlement Analysis by "+frm.rd_title.value+"-Print";
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaimreport/containercargoclaimreport/report/CPS_CNI_0076.mrd";
		popupRd(1000,600);

	} 
}
 
 function getCondAllValue(){
		
		var vObjects = frm.elements;
		var vCondStr = "";
		for ( var kdx = 0; kdx < vObjects.length; kdx++) {
			var vObj   = vObjects[kdx];
			var vObjTp = vObj.type;
			var vObjNm = vObj.name;
	    	
			if (typeof(vObjNm) == "undefined" || vObjNm == "" || vObjTp == "hidden"){
				continue;
			}

			vCondStr += "p_" + vObjNm + "[" +  ComGetObjValue(vObj) + "]";
		} //end for
		
		vCondStr += "rd_report_by["+frm.rd_report_by.value+"]"+"rd_title_nm["+frm.rd_title_nm.value+"]";//hidden 값중 일부를 넘겨야함.
		return vCondStr;
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

	for (var idx = 0; idx < vArrayListData.length; idx++) {
	    vListData = vArrayListData[idx];
		vCaptionText = vListData["code"] + " |" + vListData["name"];
		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	} //end for
	if (pComboObjId == "status") {
		vComboObj.InsertItem(0, "ALL|All Status", "All");
		vComboObj.Index = 0
	} else if (pComboObjId == "area") {
		vComboObj.InsertItem(0, "ALL|All Area", "All");
		vComboObj.Index = 0
	} else {
		vComboObj.InsertItem(0, "", "");
		vComboObj.Index = 0
	}
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
function validateForm(sAction){

	 if (ComGetObjValue(frm.period) == "") {
		 ComShowCodeMessage("CNI00003", "period");
		 frm.period.focus();
		 return false; 
	 }
			 
	 if (ComGetObjValue(frm.period)!= "" && ComGetObjValue(frm.from_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date");
		 frm.from_period.focus();
		 return false;
	 }
	 if (ComGetObjValue(frm.period) != "" && ComGetObjValue(frm.to_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date");
		 frm.to_period.focus();
		 return false;
	 }
	 
	 var from_clmt_usd_amt = frm.from_clmt_usd_amt.value.trim(); 
	 var to_clmt_usd_amt   = frm.to_clmt_usd_amt.value.trim();
	 from_clmt_usd_amt = ComReplaceStr(from_clmt_usd_amt,",","");
	 to_clmt_usd_amt = ComReplaceStr(to_clmt_usd_amt,",","");
	 
	 if (!ComIsNull(from_clmt_usd_amt) && !ComIsNull(to_clmt_usd_amt) && 
	      parseFloat(from_clmt_usd_amt) >= parseFloat(to_clmt_usd_amt)){
		 ComShowCodeMessage("CNI00036");
		 frm.to_clmt_usd_amt.focus();
		 return false;
	 }
	 
	 var from_cgo_clm_stl_usd_amt = frm.from_cgo_clm_stl_usd_amt.value.trim(); 
	 var to_cgo_clm_stl_usd_amt   = frm.to_cgo_clm_stl_usd_amt.value.trim();
	 from_cgo_clm_stl_usd_amt = ComReplaceStr(from_cgo_clm_stl_usd_amt,",","");
	 to_cgo_clm_stl_usd_amt = ComReplaceStr(to_cgo_clm_stl_usd_amt,",","");
	 
	 if (!ComIsNull(from_cgo_clm_stl_usd_amt) && !ComIsNull(to_cgo_clm_stl_usd_amt) && 
	      parseFloat(from_cgo_clm_stl_usd_amt) >= parseFloat(to_cgo_clm_stl_usd_amt)){
		 ComShowCodeMessage("CNI00036");
		 frm.to_cgo_clm_stl_usd_amt.focus();
		 return false;
	 }	 
	 
	 if (ComGetObjValue(frm.clmt_clm_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.clmt_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clmt_clm_agn_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.clmt_clm_agn_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.insur_clm_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.insur_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_liable_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.labl_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.slv_clm_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.slv_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_surveyor_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.svey_clm_pty_no, ""); 
	 }
	 //추가해야함 다른 컬럼	
	 
	return true;
}