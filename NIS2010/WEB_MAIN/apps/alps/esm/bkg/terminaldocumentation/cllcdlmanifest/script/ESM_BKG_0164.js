/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0164.js
 *@FileTitle : ESM_BKG_0164
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.09.29 이수빈
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class ESM_BKG_0164 : ESM_BKG_0164 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0164() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var searchFlag = false;
var loadExcelFlg = false;
var oldType = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
    var rdObject = rdObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
			break; 
			
			case "btn_new":
				doActionIBSheet(sheetObjects[0],document.form,IBRESET);	
			break; 
			
			case "btn_loadExcel":
				doActionIBSheet(sheetObjects[0],document.form,IBLOADEXCEL);	
			break; 

			case "btn_downExcel":
				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);	
			break; 
			
			case "btn_print":
	        	rdOpen(rdObject);
			break; 

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

	
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initRdConfig(rdObjects[0]);
	
	ComBtnDisable("btn_loadExcel");
	
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("Click","obj_Click", document.form);
	axon_event.addListenerForm("Change","obj_Change", document.form);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}


/**
 * Rd 설정
 */
function initRdConfig(rdObject){
	
	var Rdviewer = rdObject;
	
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0); 
	Rdviewer.IsShowDlg = 0;
	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
	Rdviewer.style.height = 0;
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * Form 컨트롤 클릭 시 처리
 * Match, Unmatch 라디오 버튼 클릭 시 
 * 시트에 해당 데이터만 남기고 Hidden 처리
 */ 
function obj_Click() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");
	
	if ( srcName == "inc_mty_chk" ) {
		if(srcObj.checked){
			formObject.inc_mty.value = "Y";
		}else{
			formObject.inc_mty.value = "N";
		}
	}
	if ( srcName == "data_chk") {
		var sheetObj = sheetObjects[0];
		if(sheetObj.RowCount == 0) {
			ComShowCodeMessage('BKG00889'); // No Data Found
			formObject.data_chk[0].checked = true;
			return;
		}
		if(!loadExcelFlg) {
			formObject.data_chk[0].checked = true;
			return;
		}
		ComOpenWait(true);
		sheetObj.Redraw = false;
		var rowCnt = 1;
		if(formObject.data_chk[1].checked){ // Matched
			for(var i=1; i<=sheetObj.LastRow; i++){
				sheetObj.RowHidden(i) = false;
			}
			for(var i=1; i<=sheetObj.RowCount; i=i+2){
				if(sheetObj.CellValue(i, "match") == "M"){
					sheetObj.CellValue2(i, "rnum") = rowCnt;
					sheetObj.CellValue2(i+1, "rnum") = rowCnt;
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(239,240,243);
					sheetObj.RowBackColor(i+1) = sheetObj.RgbColor(239,240,243);
					rowCnt++;
				}else{
					sheetObj.RowHidden(i) = true;
					sheetObj.RowHidden(i+1) = true;
				}
			}
		}
		else if(formObject.data_chk[2].checked){ // UnMatched
			for(var i=1; i<=sheetObj.RowCount; i++){
				sheetObj.RowHidden(i) = false;
			}
			for(var i=1; i<=sheetObj.LastRow; i=i+2){
				if(sheetObj.CellValue(i, "match") == "U"){
					sheetObj.CellValue2(i, "rnum") = rowCnt;
					sheetObj.CellValue2(i+1, "rnum") = rowCnt;
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,172);
					sheetObj.RowBackColor(i+1) = sheetObj.RgbColor(255,255,172);
					rowCnt++;
				}else{
					sheetObj.RowHidden(i) = true;
					sheetObj.RowHidden(i+1) = true;
				}
			}
		}
		else{
			for(var i=1; i<=sheetObj.RowCount; i=i+2){
				sheetObj.CellValue2(i, "rnum") = rowCnt;
				sheetObj.CellValue2(i+1, "rnum") = rowCnt;
				sheetObj.RowHidden(i) = false;
				sheetObj.RowHidden(i+1) = false;
				rowCnt++;
			}
		}
		sheetObj.SelectCell(1,1);
		sheetObj.SelectCell(0,0);
		sheetObj.Redraw = true;
		ComOpenWait(false);
	}
}

/**
 * Terminal 타입 변경 시 처리
 */ 
function obj_Change() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");

	if ( srcName == "tmnl_type") {
		if(srcValue != oldType) {
			searchFlag = false;
			loadExcelFlg = false;
			ComBtnEnable("btn_retrieve");
			ComBtnDisable("btn_loadExcel");
			oldType = srcValue;
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	var sheetID = sheetObj.id;				
    switch(sheetID) {
    case "sheet1":
	case "sheet4":
	case "sheet5":
		with (sheetObj) {

            // 높이 설정
            style.height = 322;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(11, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);

            var HeadTitle1 = "|M|K|Booking No.|BKG Q'ty|BKG Q'ty|Shipper|POD|Container No.|Commodity|Special";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtData,		30,		daCenter,		true,		"rnum",			false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		30,		daCenter,		true,		"match",		false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		30,		daCenter,		false,		"kind",			false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		120,	daCenter,		false,		"bkg_no",		false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		40,		daCenter,		false,		"bkg_qty1",		false,			"",      dfNone,			0,		false,		false);
                                                                                                                                                            
            InitDataProperty(0, cnt++ , dtData,		30,		daCenter,		false,		"bkg_qty2",		false,			"",      dfNullInteger,		0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		220,	daLeft,			false,		"shpr_nm",		false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"fpod",			false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		95,		daCenter,		false,		"cntr_no",		false,			"",      dfNone,			0,		false,		false);
            InitDataProperty(0, cnt++ , dtData,		220,	daLeft,			false,		"cmdt_nm",		false,			"",      dfNone,			0,		false,		false);
            
            InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"special",		false,			"",      dfNone,			0,		false,		false);

            CountPosition = 0;
            //CountFormat = "[SELECTDATAROW / ROWCOUNT]";
		}
		break;

	case "sheet2":      //sheet2 init
		with (sheetObj) {

            // 높이 설정
            style.height = 62;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(5, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle1 = "Total|BKG|20'|40'|45'";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		105,	daCenter,	false,		"Total",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"BKG",			false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"Qty20",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"Qty40",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,		"Qty45",		false,			"",      dfNone,			0,		false,		false);

			CountPosition = 0;
		}
		break;


	case "sheet3":      //sheet3 init
		with (sheetObj) {

            // 높이 설정
            style.height = 60;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 1, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(3, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle1 = "Total|Matched|Un-matched";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"Total",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	false,		"Matched",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	false,		"Unmatched",	false,			"",      dfNone,			0,		false,		false);

			CountPosition = 0;
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: // 조회
			if(!validateForm(sheetObj, formObj, sAction)) return false;
			
			// 기존에 조회 된 데이터 Reset
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			formObj.data_chk[0].checked = true;
			
			formObj.f_cmd.value = SEARCH;	
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0164GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
			if(State == "S"){
				// 조회 후 버튼 처리
				searchFlag = true;
				loadExcelFlg = false;
				ComBtnEnable("btn_loadExcel");
				// 시트에 데이터 로드
				var sheetObj4 = sheetObjects[1];
                sheetObj.Redraw = false;       
                sheetObj.LoadSearchXml(sXml);
                sheetObj4.LoadSearchXml(sXml);
				sheetObj.SelectCell(0,0);
				
				// Terminal 타입에 따라서 POD 또는 F/POD 로 헤더 타이틀 변경
				if(formObj.tmnl_type.value == "COSCO"){
					sheetObj.CellText(0, "fpod") = "F/POD";
				}
				else if(formObj.tmnl_type.value == "TTI" || formObj.tmnl_type.value == "GPA"){
					sheetObj.CellText(0, "fpod") = "POD";
				}
				
				if(sheetObj.RowCount == 0) {
	                sheetObj.Redraw = true;
					return;
				}
				
				// Down Excel 시 필요한 시트 값 셋팅
				for(var i=1; i<sheetObj4.RowCount+1; i++){
					if(sheetObj4.CellValue(i, "kind") != "A")
						sheetObj4.RowDelete(i, false);
				}

				// Sheet2 - ALPS Total, Bkg Qty 카운트
				var tot_bkg = sheetObj.CellValue(sheetObj.LastRow, "rnum");
				var tot_20 = 0;
				var tot_40 = 0;
				var tot_45 = 0;
				for(var i=1; i<sheetObj.RowCount+1; i=i+2){
					if(sheetObj.CellValue(i, "bkg_qty1") == "20") tot_20++;
					if(sheetObj.CellValue(i, "bkg_qty1") == "40") tot_40++;
					if(sheetObj.CellValue(i, "bkg_qty1") == "45") tot_45++;
				}
				
				// Sheet2 - ALPS, Terminal 별 값 세팅
				var sheetObj2 = sheetObjects[2];
                sheetObj2.Redraw = false; 
                sheetObj2.RemoveAll();
                var row = sheetObj2.DataInsert(-1);
				sheetObj2.CellValue2(row, "Total") = "ALPS";
				sheetObj2.CellBackColor(row, "Total") = sheetObj2.RgbColor(193,196,232);
				sheetObj2.CellValue2(row, "BKG")   = tot_bkg;
				sheetObj2.CellValue2(row, "Qty20") = tot_20;
				sheetObj2.CellValue2(row, "Qty40") = tot_40;
				sheetObj2.CellValue2(row, "Qty45") = tot_45;
				row = sheetObj2.DataInsert(-1);
				sheetObj2.CellValue2(row, "Total") = "Terminal";
				sheetObj2.CellBackColor(row, "Total") = sheetObj2.RgbColor(193,196,232);
				sheetObj2.SelectCell(0,0);

				// Sheet3 - Match, UnMatch 값 세팅
				var sheetObj3 = sheetObjects[3];
                sheetObj3.Redraw = false; 
                row = sheetObj3.DataInsert(-1);
				//sheetObj3.CellValue2(row, "Total") = tot_bkg;
				sheetObj3.SelectCell(0,0);
                
				// 각 시트에 변경된 데이터 보이기
                sheetObj.Redraw = true; 
                sheetObj2.Redraw = true; 
                sheetObj3.Redraw = true; 
			}
			break;	
			
		case IBRESET: // New
			formObj.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			searchFlag = false;
			loadExcelFlg = false;
			ComBtnDisable('btn_loadExcel');
			formObj.vvd.focus();
			break;		
			
		case IBLOADEXCEL: // Load Excel
			if(!searchFlag) return;
			searchFlag = false;
            var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
            if (strFilePath != "<USER_CANCEL>") {
                sheetObj.WaitImageVisible = false;  
    			ComOpenWait(true); 
    			
            	// 파일 선택 시 버튼 처리
    			loadExcelFlg = true;
    			ComBtnDisable("btn_loadExcel");
    			
    			// 시트 데이터 보이기 막음
            	var sheet_load = sheetObj;
            	var sheet_temp = sheetObjects[4];
            	sheet_load.Redraw = false; 
            	sheetObjects[2].Redraw = false; 
            	sheetObjects[3].Redraw = false; 

            	// 데이터 없는 Row 삭제
				for(var i=1; i<sheet_load.RowCount+1; i++){
					if(sheet_load.CellValue(i, "kind") != "A")
						sheet_load.RowDelete(i, false);
				}

				/************************************************
				 * Terminal 타입에 따라서 엑셀 데이터 시트에 로드
				 ************************************************/
            	var appendIdx = sheetObjects[1].LastRow + 1;
            	var startIdx = 0;
            	var endIdx = 0;
            	var findIdx = 0;
				/**
				 * LoadExcel Syntax
				 * mySheet.LoadExcel([Mode], [SheetNo], [FileName], [StartExcelRow], [EndExcelRow], 
				 * 					 [WorkSheetName], [IsAppend], [bProtect], [ColumnMapping])
				 */ 
				if(formObj.tmnl_type.value == "COSCO"){
					/******************************************************************
					 * Temp Sheet 에 먼저 로드 후 필요한 데이터만 Load Sheet에 복사한다.
					 ******************************************************************/
					sheet_temp.LoadExcel(-1, 1, strFilePath, 8, -1, "", true, false, 
							"1=>bkg_no|3=>cntr_no|5=>bkg_qty1|8=>fpod|9=>cmdt_nm|14=>shpr_nm");
					findIdx = sheet_temp.FindText("bkg_no", "Grand Totals")-1;
					
					for(var h=0; h<findIdx; h=endIdx){
						startIdx = sheet_temp.FindText("bkg_no", "PORT:", endIdx, 0, true) + 3;
						endIdx = sheet_temp.FindText("bkg_no", "Port Total", startIdx);

						for(var i=startIdx; i<endIdx; i++){
							if(sheet_temp.CellValue(i, "bkg_no") == "SZTP") continue;
							if(sheet_temp.CellValue(i, "bkg_no") == "D2") continue;
							if(sheet_temp.CellValue(i, "bkg_no") == "D4") continue;
							if(sheet_temp.CellValue(i, "bkg_no") == "D5") continue;
							if(sheet_temp.CellValue(i, "bkg_no") == "D7") continue;
							addRow = sheet_load.DataInsert(-1);
							for(var j=0; j<=sheet_load.LastCol; j++){
								if(sheet_load.ColSaveName(j) == "bkg_no" && sheet_temp.CellValue(i, j) == ""){
									sheet_temp.CellValue(i, j) = sheet_temp.CellValue(i-1, j);
								}
								if(sheet_load.ColSaveName(j) == "bkg_qty1"){
									if(sheet_temp.CellValue(i, j) == "D2") sheet_temp.CellValue2(i, j) = "20";
									if(sheet_temp.CellValue(i, j) == "D4") sheet_temp.CellValue2(i, j) = "40";
									if(sheet_temp.CellValue(i, j) == "D5") sheet_temp.CellValue2(i, j) = "40";
									if(sheet_temp.CellValue(i, j) == "D7") sheet_temp.CellValue2(i, j) = "45";
								}
								sheet_load.CellValue2(addRow, j) = sheet_temp.CellValue(i, j);
							}
						}
					}
				}
				else if(formObj.tmnl_type.value == "GPA"){
					sheet_load.LoadExcel(-1, 1, strFilePath, 1, -1, "", true, false, 
							"13=>bkg_no|5=>bkg_qty1|1=>cntr_no|4=>fpod");
					sheet_temp.LoadExcel(-1, 1, strFilePath, 1, -1, "", true, false, 
							"13=>bkg_no|5=>bkg_qty1|1=>cntr_no|4=>fpod");
				}
				else if(formObj.tmnl_type.value == "TTI" || formObj.tmnl_type.value == "General"){
					/******************************************************************
					 * Temp Sheet 에 먼저 로드 후 필요한 데이터만 Load Sheet에 복사한다.
					 ******************************************************************/
					sheet_temp.LoadExcel(-1, 1, strFilePath, 11, -1, "", true, false, 
							"1=>bkg_no|11=>bkg_qty1|30=>bkg_qty2|7=>fpod|12=>cntr_no|4=>shpr_nm|20=>cmdt_nm|23=>special");
					findIdx = sheet_temp.FindText("cntr_no", "Total");
					
					for(var i=findIdx+1; i<=sheet_temp.LastRow; i++){
						sheet_temp.RowDelete(i, false);
					}
					for(var i=1; i<=sheet_temp.RowCount; i++){
						if(sheet_temp.CellValue(i, "bkg_no") == "" && sheet_temp.CellValue(i, "bkg_qty1") == "" &&
						   sheet_temp.CellValue(i, "fpod") == "" && sheet_temp.CellValue(i, "cntr_no") == "") {
							sheet_temp.RowDelete(i, false);
							continue;
						}
						if(sheet_temp.CellValue(i, "bkg_no") == "") sheet_temp.CellValue2(i, "bkg_no") = sheet_temp.CellValue(i-1, "bkg_no");
					}

					/******************************************************************
					 * Container No. 에 'Total' 이 들어있는 Row까지 Load Sheet에 Copy
					 ******************************************************************/
					var addRow;
					findIdx = sheet_temp.FindText("cntr_no", "Total");
					for(var i=1; i<findIdx; i++){
						addRow = sheet_load.DataInsert(-1);
						for(var j=0; j<=sheet_load.LastCol; j++){
							sheet_load.CellValue2(addRow, j) = sheet_temp.CellValue(i, j);
						}
					}
					sheet_load.ColumnSort("bkg_no|cntr_no", "ASC");
				}
            	else{
            		sheet_load.LoadExcel(-1, 1, strFilePath, -1, -1, "", true, false, "");
            		sheet_temp.LoadExcel(-1, 1, strFilePath, -1, -1, "", true, false, "");
            	}

				/******************************************************************
				 * 데이터 없는 Row 삭제, Bkg No 없으면 바로 위 Bkg No 데이터 카피
				 ******************************************************************/
				for(var i=appendIdx; i<=sheet_load.RowCount; i++){
					if(sheet_load.CellValue(i, "bkg_no") == "" && sheet_load.CellValue(i, "bkg_qty1") == "" &&
					   sheet_load.CellValue(i, "fpod") == "" && sheet_load.CellValue(i, "cntr_no") == "") {
						sheet_load.RowDelete(i, false);
						continue;
					}
					if(sheet_load.CellValue(i, "bkg_no") == "") {
						sheet_load.CellValue2(i, "bkg_no") = sheet_load.CellValue(i-1, "bkg_no");
					}
				}
				sheet_load.ColumnSort("bkg_no|cntr_no", "ASC");

				/******************************************
				 *  로드 된 데이터에 Seq, Kind(T) 값 세팅
				 ******************************************/
				for(var i=1; i<=sheet_load.RowCount; i++){
					if(sheet_load.CellValue(i, "rnum") == ""){
						sheet_load.CellValue2(i, "kind") = "T";
						sheet_load.CellValue2(i, "rnum") = sheet_load.CellValue(i-1, "rnum");
					}
				}
				sheet_load.ColumnSort("rnum|kind", "ASC");

				var addRow;
				var matchCnt = 0;
				var unMatchCnt = 0;
				for(var i=1; i<=sheet_load.RowCount; i++){
					if(sheet_load.CellValue(i, "kind") == "T"){

						/******************************************************************************* 
						 * 로드 된 데이터가 조회된 데이터와 동일한 것이 없을 경우
						 * 바로 위에 Row 추가 하여 Seq, Kind(A) 값 세팅 한 후 
						 * - UnMatch 표시, UnMatch 카운트
						 *******************************************************************************/ 
						if( sheet_load.CellValue(i, "bkg_no") != sheet_load.CellValue(i-1, "bkg_no") ||
							sheet_load.CellValue(i, "cntr_no") != sheet_load.CellValue(i-1, "cntr_no") ) {
							sheet_load.SelectCell(i,0);
							addRow = sheet_load.DataInsert();
							sheet_load.CellValue2(addRow, "kind") = "A";
							sheet_load.CellValue2(addRow, "rnum") = sheet_load.CellValue(i, "rnum");
							sheet_load.CellValue2(addRow, "match") = "U";
							sheet_load.CellValue2(i, "match") = "U";
							sheet_load.RowBackColor(addRow) = sheet_load.RgbColor(255,255,172);
							sheet_load.RowBackColor(i) = sheet_load.RgbColor(255,255,172);
							unMatchCnt++;
						}
						/******************************************************************************* 
						 * 로드 된 데이터가 조회된 데이터와 동일한 것이 있을 경우
						 * - Match 표시, Match 카운트
						 * 데이터가 다를 경우
						 * - UnMatch 표시, UnMatch 카운트
						 *******************************************************************************/ 
						else{
							if(formObj.tmnl_type.value == "TTI" || formObj.tmnl_type.value == "General"){
								if( sheet_load.CellValue(i, "bkg_no")   == sheet_load.CellValue(i-1, "bkg_no")   && 
									sheet_load.CellValue(i, "bkg_qty1") == sheet_load.CellValue(i-1, "bkg_qty1") &&
									sheet_load.CellValue(i, "bkg_qty2") == sheet_load.CellValue(i-1, "bkg_qty2") &&
								    sheet_load.CellValue(i, "fpod")     == sheet_load.CellValue(i-1, "fpod")     && 
								    sheet_load.CellValue(i, "cntr_no")  == sheet_load.CellValue(i-1, "cntr_no")  && 
								    sheet_load.CellValue(i, "special")  == sheet_load.CellValue(i-1, "special") ) 
								{
									sheet_load.CellValue2(i, "match") = "M";
									sheet_load.CellValue2(i-1, "match") = "M";
									matchCnt++;
								}else{
									sheet_load.CellValue2(i-1, "match") = "U";
									sheet_load.CellValue2(i, "match") = "U";
									sheet_load.RowBackColor(i-1) = sheet_load.RgbColor(255,255,172);
									sheet_load.RowBackColor(i) = sheet_load.RgbColor(255,255,172);
									unMatchCnt++;
								}
							}else{
								if( sheet_load.CellValue(i, "bkg_no")   == sheet_load.CellValue(i-1, "bkg_no")   && 
									sheet_load.CellValue(i, "bkg_qty1") == sheet_load.CellValue(i-1, "bkg_qty1") &&
								    sheet_load.CellValue(i, "fpod")     == sheet_load.CellValue(i-1, "fpod")     && 
								    sheet_load.CellValue(i, "cntr_no")  == sheet_load.CellValue(i-1, "cntr_no") ) 
								{
									sheet_load.CellValue2(i, "match") = "M";
									sheet_load.CellValue2(i-1, "match") = "M";
									matchCnt++;
								}else{
									sheet_load.CellValue2(i-1, "match") = "U";
									sheet_load.CellValue2(i, "match") = "U";
									sheet_load.RowBackColor(i-1) = sheet_load.RgbColor(255,255,172);
									sheet_load.RowBackColor(i) = sheet_load.RgbColor(255,255,172);
									unMatchCnt++;
								}
							}
						}
					}
				}
				
				/******************************************************************************* 
				 * 조회 된 데이터 중 Match 표시가 없으면 로드된 데이터와 동일한 것이 없으므로
				 * 바로 아래 Row 추가 하여 Seq, Kind(T) 값 세팅 한 후 
				 * - UnMatch 표시, UnMatch 카운트
				 *******************************************************************************/ 
				for(var i=1; i<=sheet_load.RowCount; i++){
					if(sheet_load.CellValue(i, "match") == " "){
						sheet_load.SelectCell(i,0);
						addRow = sheet_load.DataInsert();
						sheet_load.CellValue2(addRow, "kind") = "T";
						sheet_load.CellValue2(addRow, "rnum") = sheet_load.CellValue(i, "rnum");
						sheet_load.CellValue2(addRow, "match") = "U";
						sheet_load.CellValue2(i, "match") = "U";
						sheet_load.RowBackColor(addRow) = sheet_load.RgbColor(255,255,172);
						sheet_load.RowBackColor(i) = sheet_load.RgbColor(255,255,172);
						unMatchCnt++;
					}
				}
				
				/****************************************************
				 * Seq 데이터가 중복이 생기므로 Seq 값 다시 세팅
				 ****************************************************/
				var rowCnt = 1;
				for(var i=1; i<=sheet_load.RowCount; i=i+2){
					sheet_load.CellValue2(i, "rnum") = rowCnt;
					sheet_load.CellValue2(i+1, "rnum") = rowCnt;
					rowCnt++;
				}
				sheet_load.ColumnSort("rnum|match|kind", "ASC");
				sheet_load.SelectCell(1,1);
				sheet_load.SelectCell(0,0);

				/****************************************************
				 * Sheet2 - Terminal BkgQty 값 카운트
				 ****************************************************/
				var tmnlBkgNoCnt = 0;
				var tmnlBkg20Cnt = 0;
				var tmnlBkg40Cnt = 0;
				var tmnlBkg45Cnt = 0;
				for(var i=1; i<=sheet_temp.RowCount; i++){
					if( sheet_temp.CellValue(i, "bkg_no") == "" && sheet_temp.CellValue(i, "bkg_qty1") == "" &&
					    sheet_temp.CellValue(i, "fpod") == "" && sheet_temp.CellValue(i, "cntr_no") == "" ) {
						sheet_temp.RowDelete(i, false);
					}
					if(sheet_temp.CellValue(i, "bkg_no") != "" || sheet_temp.CellValue(i, "cntr_no") != ""){
						if(sheet_temp.CellValue(i, "bkg_qty1") == "20") tmnlBkg20Cnt++;
						if(sheet_temp.CellValue(i, "bkg_qty1") == "40") tmnlBkg40Cnt++;
						if(sheet_temp.CellValue(i, "bkg_qty1") == "45") tmnlBkg45Cnt++;
					}
				}
				findIdx = sheet_temp.FindText("cntr_no", "Total");
				if(findIdx > 0) tmnlBkgNoCnt = findIdx-1;
				else tmnlBkgNoCnt = sheet_temp.RowCount;

				/********************************************************
				 * Sheet2,Sheet3 - Total, BkgQty, Match, UnMatch 값 세팅
				 ********************************************************/
				sheetObjects[2].CellValue2(2, "BKG") = tmnlBkgNoCnt;
				sheetObjects[2].CellValue2(2, "Qty20") = tmnlBkg20Cnt;
				sheetObjects[2].CellValue2(2, "Qty40") = tmnlBkg40Cnt;
				sheetObjects[2].CellValue2(2, "Qty45") = tmnlBkg45Cnt;
				sheetObjects[3].CellValue2(1, "Total") = matchCnt+unMatchCnt;
				sheetObjects[3].CellValue2(1, "Matched") = matchCnt;
				sheetObjects[3].CellValue2(1, "Unmatched") = unMatchCnt;

    			ComOpenWait(false); 
                sheetObj.WaitImageVisible = true;
				// 각 시트에 변경된 데이터 보이기
            	sheet_load.Redraw = true; 
            	sheetObjects[2].Redraw = true; 
            	sheetObjects[3].Redraw = true; 
            	ComBtnDisable("btn_loadExcel");
            }
			break;	
	
		case IBDOWNEXCEL: // Down Excel
            sheetObj.WaitImageVisible = false;  
			ComOpenWait(true); 
			if(loadExcelFlg){
		   	    sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			}else{
		   	    sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			} 
			ComOpenWait(false); 
            sheetObj.WaitImageVisible = true;  
			break;	
	
		case IBPRINT: // Print
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		return true;
		break;
		
	case IBSAVE: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;	
	}
}
/**
 * RD 오픈  및  출력
 */
function rdOpen(rdObject){

	var sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
	sXml += "</SHEET>";
	
//	rdObject.AutoAdjust = true;
//	rdObject.HideToolbar();
//	rdObject.HideStatusbar();
//	rdObject.ViewShowMode(0); 
//
//	rdObject.setbackgroundcolor(128,128,128);
//	rdObject.SetPageLineColor(128,128,128);

	//var RD_path = "http://localhost:7001/hanjin/";
	var strPath = RD_path+'apps/alps/esm/bkg/terminaldocumentation/cllcdlmanifest/report/ESM_BKG_0784.mrd';

	rdObject.SetRData(sXml);
	rdObject.FileOpen(strPath ,RDServer);
	rdObject.PrintDialog();
}

/* 개발자 작업 끝 */