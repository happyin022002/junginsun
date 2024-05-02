/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0043.js
 *@FileTitle : [CPS_CNI_0043] Impending TB Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0043] Impending TB Claim
 * @extends
 * @class Main Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0043() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}


// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;

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
    
    doActionIBSheet(SEARCHLIST01);
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
            // 높이 설정
			style.height = 160;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "Seq.|DOTB|CL|Claim NO.|A|HOFC|Handler|STS|Claimant";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          	InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,		"data_seq",	false,  "",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,		"tm_bar_dt",	false,  "",	dfDateYmd,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	22,	daCenter,		true,		"cgo_clm_div_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,		"cgo_clm_no",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	15,	daCenter,		true,		"clm_area_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	45,	daCenter,	true,		"hdlr_ofc_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,		"hdlr_usr_id",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	30,	daCenter,		true,		"cgo_clm_sts_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	100,	daLeft,		true,		"clmt_clm_pty_nm",	false,  "",	dfNone,		0,	true,		true);
			InitViewFormat(0, "tm_bar_dt", "yyyy-mm-dd");
			break;	
		case "sheet2": 
            // 높이 설정
			style.height = 160;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "Seq.|LP DOTB|CL|Claim NO.|A|HOFC|Handler|STS|Liable Party";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          	InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,	true,		"data_seq",	false,  "",		dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,		"tm_bar_dt",	false,  "",	dfDateYmd,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	22,	daCenter,		true,		"cgo_clm_div_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,		"cgo_clm_no",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	15,	daCenter,		true,		"clm_area_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	45,	daCenter,	true,		"hdlr_ofc_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,		"hdlr_usr_id",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	30,	daCenter,		true,		"cgo_clm_sts_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	100,	daLeft,		true,		"labl_clm_pty_nm",	false,  "",	dfNone,		0,	true,		true);
			InitViewFormat(0, "tm_bar_dt", "yyyy-mm-dd");
			break;
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================



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
    case "btn1_Detail":
    	if (sheet1.RowCount > 0 && sheet1.SelectRow > 0) {
    		opener.location.href = "CPS_CNI_0003.do?pgmNo=CPS_CNI_0003&cgo_clm_no=" + sheet1.CellValue( sheet1.SelectRow , "cgo_clm_no");
    	}
    	
    	if (sheet2.RowCount > 0 && sheet2.SelectRow > 0) {
    		opener.location.href = "CPS_CNI_0015.do?pgmNo=CPS_CNI_0015&cgo_clm_no=" + sheet2.CellValue( sheet2.SelectRow , "cgo_clm_no");
    	}
		
		break;
    case "btn1_Retrieve":
    	doActionIBSheet(SEARCHLIST01);
        break;
    case "btn1_New":
    	ComResetAll();
        break;
    case "btn1_Close":
		self.close();
        break;       
	}

}

 

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}
	opener.location.href = "CPS_CNI_0003.do?pgmNo=CPS_CNI_0003&cgo_clm_no=" + sheet1.CellValue( sheet1.SelectRow , "cgo_clm_no");
	self.close();
}

/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	sheet2.SelectRow = 0;
}

/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet2_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}
	opener.location.href = "CPS_CNI_0015.do?pgmNo=CPS_CNI_0015&cgo_clm_no=" + sheet2.CellValue( sheet2.SelectRow , "cgo_clm_no");
	self.close();
}

/**
* sheet2 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet2_OnClick(sheet , row, col, value) {	
	sheet1.SelectRow = 0;
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value = SEARCHLIST01;		
		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0043GS.do", FormQueryString(frm));
		
		var arrXml = sXml.split("|$$|");

		// ------------------------------------------------------------
		// 조회 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0]);			
		} 
				
		if (arrXml.length > 1) {
			sheet2.LoadSearchXml(arrXml[1]);
		}
		
		if (sheet1.RowCount > 0 || sheet2.RowCount > 0) {
			ComBtnEnable("btn1_Detail");
		} else {
			ComBtnDisable("btn1_Detail");
		}
		
	} 
}

