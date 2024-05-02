/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0009.jsp
 *@FileTitle : [CPS_GEM-0009] Foreign Exchange Rate Maintenance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM-0009] Foreign Exchange Rate Maintenance
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0009() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
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
var sheet2 = null;
var curYear = "";
// html form
var frm = null;


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
function loadPage(year) {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
          
    //현재년도 설정    
    var acct_xch_rt_yrmon = frm.acct_xch_rt_yrmon;    
    if (acct_xch_rt_yrmon.value == "") {
        acct_xch_rt_yrmon.value = year;
    }  
        
    curYear = year;
    
    //Form 이벤트 등록
    initControl();
    

    
}

/**
* 화면 깜박임 방지 (페이지 로딩후 실행) 
* @param {ibsheet} sheet  sheet
*/
function sheet1_OnLoadFinish(sheet) {
	sheet.WaitImageVisible = false;	    
	
    //초기 데이타 취득
    doActionIBSheet(IBSEARCH);      
    
	sheet.WaitImageVisible = true;
}

/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
            CountBackColor = RgbColor(233,233,233);
			style.height = 400;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}
			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(1, 1, 15, 100);
			var HeadTitle1 = "|Select|CUR|USD(1) : LCL|LCL : KRW";
			var headCount = ComCountHeadTitle(HeadTitle1);
			InitColumnInfo(headCount, 0, 0, true);
			InitHeadMode(true, true, false, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);
			InitDataProperty(0, cnt++, dtDummyCheck, 60, daCenter, true,
					"delChk", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd",
					true, "", dfEngKey, 0, false, true, 3, true, true, "",
					true);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true,
					"usd_locl_xch_rt", true, "", dfNullFloat, 4, true, true,
					10, false, true, "", true);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true,
					"locl_krw_xch_rt", true, "", dfNullFloat, 4, false, false,
					10, false, true, "", true);
			
			InitDataValid(0,    "curr_cd",   vtEngUpOnly);
			
			
			break;
		
		case "sheet2":
			CountBackColor = RgbColor(233,233,233);
			style.height = 400;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}

			MergeSheet = msHeaderOnly;
			Editable = false;
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Mon|USD(1) : LCL|LCL : KRW|USD(1) : KRW";

			var headCount = ComCountHeadTitle(HeadTitle1);
			InitColumnInfo(headCount, 0, 0, true);

			InitHeadMode(true, true, false, true, false, false)
			InitHeadRow(0, HeadTitle1, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"hdnStatus");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "acct_xch_rt_yrmon",
					false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true, "usd_locl_xch_rt",
					false, "", dfNullFloat, 4);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true, "locl_krw_xch_rt",
					false, "", dfNullFloat, 4);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true, "usd_krw_xch_rt",
					false, "", dfNullFloat, 4);
			
			break;	
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================
 /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
 function validateForm(sheetObj,formObj,sAction){
     return true;
 }


// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {	
	case "btn2_Excel":
		sheet1.LoadExcel(-1, 1, "", -1, -1, "", false);
		
		//locl_krw_xch_rt 계산 
		var usd_krw_xch_rt = frm.usd_krw_xch_rt.value;
		if (ComIsNumber(usd_krw_xch_rt, ".,")) {	
			usd_krw_xch_rt = ComReplaceStr(usd_krw_xch_rt,",","");
			for ( var i = 1; i <= sheet1.RowCount; i++) {				
				var usd_locl_xch_rt = sheet1.CellValue(i, "usd_locl_xch_rt");				
				sheet1.CellValue2(i, "locl_krw_xch_rt") = 
					ComRound(usd_krw_xch_rt / usd_locl_xch_rt, 4);
			}
		}
		
		//존재하지 않은 CURR_CD취득 
		var inCurrCd = "";
		for(var i = 1 ; i <= sheet1.RowCount; i++) {			
			inCurrCd += "|" + sheet1.CellValue(i,"curr_cd") ;
		}
		
		frm.inCurrCd.value = inCurrCd.substring(1);
		doActionIBSheet(IBLOADEXCEL);
		
		break;
	case "btn2_Delete":
		ComRowHideDelete(sheet1, "delChk");		
		break;
	case "btn2_Row":		
		if(!ComChkValid(frm)) {			
			return;
		}
		var row = sheet1.DataInsert(-1);		
		sheet1.SelectCell(row,"curr_cd",true);
		break;
	case "btns_calendar":
		var cal = new ComCalendar();
		cal.setDisplayType('year');
		cal.select(frm.acct_xch_rt_yrmon, 'yyyy');
		break;
	case "btns_popup":
		var sUrl = "CPS_GEM_0111.do";
		ComOpenWindowCenter(sUrl,"win_cps_gem_0111",300,210, false);
		break;
	case "btn1_Retrieve":
		if (ComChkObjValid(frm.acct_xch_rt_yrmon)) {
			doActionIBSheet(IBSEARCH);      
		}
		break;
	case "btn1_New":
		
		//GEM00011 Do you want to initialize?
		if (ComShowCodeConfirm("GEM00011") ) {
			ComResetAll();
		}
		
		frm.acct_xch_rt_yrmon.focus();
		//doActionIBSheet(IBSEARCH);
		break;
	case "btn1_Save":
		doActionIBSheet(IBSAVE);
		break;
	case "btn1_Excel":	
		var columnSkipList = "ibflag|delChk";
		var acct_xch_rt_yrmon = frm.acct_xch_rt_yrmon.value;
		if (sheet1.RowCount > 0 ) {
			//sheet1.SpeedDown2Excel(1,false,false,true,"","",false,false,acct_xch_rt_yrmon+" Initial Exchange Rate",true,columnSkipList);
			sheet1.SpeedDown2Excel(1,false,false,"","",false,false,acct_xch_rt_yrmon+" Initial Exchange Rate",true,columnSkipList);
			
		}
		columnSkipList = "hdnStatus";
		var month_curr_cd = frm.month_curr_cd.value; 
		if (sheet2.RowCount > 0 ) {
			//sheet2.SpeedDown2Excel(1,false,false,true,"","",false,false,acct_xch_rt_yrmon+"Monthly Exchange Rate("+month_curr_cd+")",true,columnSkipList);
			sheet2.SpeedDown2Excel(1,false,false,"","",false,false,acct_xch_rt_yrmon+"Monthly Exchange Rate("+month_curr_cd+")",true,columnSkipList);
		}		 
		 
		break;
	case "delt_flg":
		doActionIBSheet(IBSEARCH);
		break;
	}

}


/**
 * Form 이벤트 등록
 */
function initControl() {
    //keypress
    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    // focus in
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
    // focus out
    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
    switch (event.srcElement.name) {    
    case "acct_xch_rt_yrmon":
		ComKeyOnlyNumber(event.srcElement);
		if (frm.acct_xch_rt_yrmon.value.length == 4 && event.keyCode == 13) {
			doActionIBSheet(IBSEARCH);
		}
		break;
    case "usd_krw_xch_rt":
		ComKeyOnlyNumber(event.srcElement, ".");
		if (frm.usd_krw_xch_rt.value.length > 0 && event.keyCode == 13) {
			setLclKrw();
		}
		break;
	}
}
 /**
  * 로컬금액을 KRW 금액 시트 설정 
  **/
 function setLclKrw() {
		var usd_krw_xch_rt = frm.usd_krw_xch_rt.value;
		if (ComIsNumber(usd_krw_xch_rt, ".,")) {		
			usd_krw_xch_rt = ComReplaceStr(usd_krw_xch_rt,",","");
			for ( var i = 1; i <= sheet1.RowCount; i++) {
				var usd_locl_xch_rt = sheet1.CellValue(i, "usd_locl_xch_rt");
				//삭제가 아닌경우만 업데이트
				if (sheet1.CellValue(i, "ibflag") != "D") {					
					if (sheet1.CellValue(i, "ibflag") != "I") {
						sheet1.CellValue(i, "ibflag") = "U";
					}					
					sheet1.CellValue2(i, "locl_krw_xch_rt") = 
						ComRound(usd_krw_xch_rt / usd_locl_xch_rt, 4);	
				}		
			}
		}

 }
 
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {
	 
	var frm = document.form;
	switch (event.srcElement.name) {
	case "acct_xch_rt_yrmon":
		break;
	case "usd_krw_xch_rt":
		setLclKrw();
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
    ComClearSeparator(event.srcElement);
}




// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * sheet1 편집처리후 이벤트 
 * LCL : KRW 계산 처리 
 * LCL : KRW =   USD(1) : KRW / USD : LCL
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 * @param {string} col 해당 셀의 value  
 * 
 */
function sheet1_OnChange(sheet , row , col , value) {
	
    if (col == sheet1.SaveNameCol("usd_locl_xch_rt")) {
    	var usd_krw_xch_rt = frm.usd_krw_xch_rt.value;
        usd_krw_xch_rt = ComReplaceStr(usd_krw_xch_rt, ",", "");
		if (ComIsNumber(usd_krw_xch_rt, ".,")) {
			var usd_locl_xch_rt = sheet1.CellValue(row, "usd_locl_xch_rt");
			sheet1.CellValue2(row, "locl_krw_xch_rt") = ComRound(usd_krw_xch_rt
					/ usd_locl_xch_rt, 4);
		}
	} else if ( col == sheet1.SaveNameCol("curr_cd") ) {
		
		var curr_cd = sheet1.CellValue(row,"curr_cd");
		
		if (!ComIsNull(curr_cd) && curr_cd.length == 3 && ComIsAlphabet(curr_cd,"u")) {
			
			frm.f_cmd.value = SEARCHLIST03;			
			var sXml = sheet1.GetSearchXml("CPS_GEM_0009GS.do?curr_cd=" + curr_cd, FormQueryString(frm));
			var errCode = ComGetEtcData(sXml,"errCode");		
			
			
			//결과값 :1정상    ,  2키에러  ,  3잘못된코드
			if ( errCode == "2" ) {
				//GEM01024	ENG	W	Please check currency. It is already existed!
				ComShowCodeMessage("GEM01024");
			} else if ( errCode == "3" ) {
				//GEM01025	ENG	W	Invalid currency code, Please refer to the currency code!
				ComShowCodeMessage("GEM01025");
			}
			
			if ( errCode != "1" ) {
				sheet1.CellValue2(row,"curr_cd") = "";
				sheet1.SelectCell(row,"curr_cd",true);
			}
			

		} else {		
			//GEM01025	ENG	W	Invalid currency code, Please refer to the currency code!
			ComShowCodeMessage("GEM01025");
			sheet1.CellValue2(row,"curr_cd") = "";
			sheet1.SelectCell(row,"curr_cd",true);
		}
				
	}
    
      
}

/**
* sheet1 MouseMove 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
* @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
* @param {long} X X 좌표
* @param {long} Y Y 좌표
*/
function sheet1_OnMouseMove(sheet , button, shift, X, Y) {	
   
	   var sName = sheet1.ColSaveName(sheet1.MouseCol);
	   if ("curr_cd" == sName || "locl_krw_xch_rt" == sName) {
		   sheet1.MousePointer = "Hand";
	   } else {
		   sheet1.MousePointer = "Default";
	   }      
}


 
/**
 * sheet1 OnClick후 이벤트 
 * sheet1의  CUR 정보로 sheet2의 Monthly Exchange Rate정보리스트 취득
 * @param {ibsheet} sheet 해당 시트   
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	var curr_cd = sheet1.CellValue(row,"curr_cd");
	var ibflag = sheet1.CellValue(row,"ibflag");
	
	if ( !ComIsNull(curr_cd) && 
			curr_cd.length == 3 && 
			ComIsAlphabet(curr_cd,"u") &&
			!ComIsNull(ibflag) && ibflag != "I" && 
			(
			col == sheet1.SaveNameCol("curr_cd")
			|| col == sheet1.SaveNameCol("locl_krw_xch_rt")
			)
		) {
		frm.f_cmd.value = SEARCHLIST01;		
		sheet2.DoSearch("CPS_GEM_0009GS.do?curr_cd=" + curr_cd, FormQueryString(frm));
		frm.month_curr_cd.value = curr_cd;
	}
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == IBSEARCH) {	
		frm.f_cmd.value = SEARCHLIST;		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0009GS.do", FormQueryString(frm));
		
		var arrXml = sXml.split("|$$|");		
		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0]);
			
			//데이타가 존재 하는경우
			if ( sheet1.RowCount > 0 ) {
				
				frm.usd_krw_xch_rt.value = 
					ComGetEtcData(arrXml[0],"usd_krw_xch_rt");
								
				//포멧설정
				ComAddSeparator(frm.usd_krw_xch_rt);
				
				var curr_cd = sheet1.CellValue(1,"curr_cd"); 	
				if ( !ComIsNull(curr_cd) ) {
					frm.month_curr_cd.value = curr_cd;
				}
				
			} else {
				sheet2.RemoveAll();
				frm.month_curr_cd.value = "";
				frm.usd_krw_xch_rt.value = "";
				//GEM00013 There is no related data
				ComShowCodeMessage("GEM00013");
			}				
		}

		if (arrXml.length > 1) {
			sheet2.LoadSearchXml(arrXml[1]);			
		}
	
		 	
	} else if (sAction == IBLOADEXCEL) {	
		frm.f_cmd.value = SEARCHLIST02;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0009GS.do", FormQueryString(frm));				
		//데이타가 존재 하는경우
		if ( sheet1.RowCount > 0 ) {			
			var currCdList = 
				ComGetEtcData(sXml,"currCdList");
			var arrCurrCd = currCdList.split("|");			
			for(var i=0 ; i < arrCurrCd.length ; i++) {
				var row = sheet1.DataInsert(-1);
				sheet1.CellValue2(row,"curr_cd") = arrCurrCd[i];
			}
		} 
		 	
	} else if (sAction == IBSAVE) {
		frm.f_cmd.value = MULTI;		
		if(ComChkValid(frm)) {
			if (!ComCodeMsgBySave()) {
				return;
			}
			sheet1.DoSave("CPS_GEM_0009GS.do", FormQueryString(frm),-1,false);
		}
	}  
 
}

