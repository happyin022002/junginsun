/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7022.js
 *@FileTitle : Tariff code mapping
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.04.29
 *@LastModifier : 김보배
 *@LastVersion : 1.0
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7022() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_RowAdd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
				
			case "btn_RowDel":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObject, formObject, MULTI);
				break;
			
			case "btn_Close":
				window.close();
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * 함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 */
function initControl() {
	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 480;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 2, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false);

			var HeadTitle1 = "Sel.|Add-On / IHC Tariff|Add-On / IHC Tariff|Add-On / IHC Tariff|Add-On / IHC Tariff|Tariff Code|Tariff Name|";
			var HeadTitle2 = "Sel.|Country|Country Name|Bound|Scope|Tariff Code|Tariff Name|";

			var headCount = ComCountHeadTitle(HeadTitle2);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);
            
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtDummyCheck,	40, daCenter, true,		"sel");
            InitDataProperty(0, cnt++, dtCombo,	 80, daCenter, false,	"cost_cnt_cd",		true,  "", dfNone, 0, false, true);
            InitDataProperty(0, cnt++, dtData,	170, daCenter, false,	"cnt_nm",			false, "", dfNone, 0, false,false);
            InitDataProperty(0, cnt++, dtCombo,	100, daCenter, false,	"org_dest_tp_cd", 	true,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo,	 80, daCenter, false,	"svc_scp_cd",		true,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo,	100, daCenter, true,	"trf_cd",			true,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,	300, daLeft,   true,	"trf_nm", 			false, "", dfNone, 0, false,false);
			InitDataProperty(0, cnt++, dtHiddenStatus,	30, daCenter, false,	"ibflag")
			
			SelectHighLight= false;
			
			InitDataCombo(0, "trf_cd", trfCdComboText, trfCdComboValue, "", " ", 0);
//			alert("trfCdComboText >>> " + trfCdComboText);
//			alert("trfCdComboValue >>> " + trfCdComboValue);
			InitDataCombo(0, "cost_cnt_cd", costCntCdComboText, costCntCdComboValue, "", " ", 0);
			InitDataCombo(0, "svc_scp_cd", " |TAW|TAE|ASW|ASE", " |TAW|TAE|ASW|ASE");
			InitDataCombo(0, "org_dest_tp_cd", " |In bound|Out bound", " |D|O");
			
			// 들여쓰기
			ColIndent("trf_nm") = 5;
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
		case IBINSERT: // 입력
			sheetObj.DataInsert(-1);
			break;
		
		case IBDELETE: // 삭제
			var selRows = sheetObj.FindCheckedRow("sel");
			var idxArr = selRows.split("|");
			for(ix=0;ix<idxArr.length;ix++){
				if(idxArr[ix] == '') continue;
				sheetObj.RowStatus(idxArr[ix]) = 'D';
				sheetObj.RowHidden(idxArr[ix]) = true;
			}
		break;
			
		case IBSEARCH: // 조회
			sheetObjects[0].WaitImageVisible = true;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_PRI_7022GS.do", FormQueryString(formObj));
			sheetObjects[0].WaitImageVisible = false;
			break;
	
		case MULTI: // 저장
			if (!validateForm(sheetObj, formObj, sAction)) return;
			sheetObjects[0].WaitImageVisible = true;

			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
            sheetObjects[0].DoSave("ESM_PRI_7022GS.do", sParam, -1, false);
            
            sheetObjects[0].WaitImageVisible = false;
			break;
	}
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: // 조회
	
			break;
			
		case MULTI: // SAVE
			
			if(!sheetObj.IsDataModified) {
				// There is no data to save
				ComShowMessage(ComGetMsg("PRI00301"));
				return false;
			}
			
			// 중복된 값 유무 체크
			var startRow = sheetObj.HeaderRows;
			var maxCnt = sheetObj.LastRow;
			var iValue = "";
			var jValue = "";			

			for(var i= startRow; i<= maxCnt; i++) {
				
				if(sheetObj.RowStatus(i) != "I") continue;
				
				iValue = sheetObj.CellValue(i,"trf_cd") + sheetObj.CellValue(i,"svc_scp_cd") 
					+ sheetObj.CellValue(i,"org_dest_tp_cd") + sheetObj.CellValue(i,"cost_cnt_cd"); 
				
				for(var j= startRow; j<= maxCnt; j++) {
					if(i == j) continue;
					
					jValue = sheetObj.CellValue(j,"trf_cd") + sheetObj.CellValue(j,"svc_scp_cd") 
							+ sheetObj.CellValue(j,"org_dest_tp_cd") + sheetObj.CellValue(j,"cost_cnt_cd");
				
				    if(iValue == jValue && iValue != "" && jValue != "") {
						// Duplicate data found, please recheck
						ComShowMessage(ComGetMsg("PRI00302"));
						return false;
				    }

				}
			} 

			return true;
			break;
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
 	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	
	switch(colName)	{
		case "trf_cd":
			var sText = sheetObj.GetComboInfo(Row, "trf_cd", "Text");
			var idx   = sheetObj.GetComboInfo(Row, colName, "SelectedIndex");
			
			var arrText = sText.split("|");
			var val	= arrText[idx].split("\t");
			//alert("kkk >> " + val[0] + " ||||| " + val[1]);
			sheetObj.CellValue(Row,"trf_nm") = val[1];
			break;
		
		case "cost_cnt_cd":
			var sText = sheetObj.GetComboInfo(Row, "cost_cnt_cd", "Text");
			var idx   = sheetObj.GetComboInfo(Row, colName, "SelectedIndex");
			
			var arrText = sText.split("|");
			var val	= arrText[idx].split("\t");
			//alert("kkk >> " + val[0] + " ||||| " + val[1]);
			sheetObj.CellValue(Row,"cnt_nm") = val[1];
			break;
 	}
}
   

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	 
 	 if (ErrMsg == "") {
 		 	ComShowCodeMessage("PRI00101"); // Data saved successfully
	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 } 	 	
 }


/* 개발자 작업 끝 */