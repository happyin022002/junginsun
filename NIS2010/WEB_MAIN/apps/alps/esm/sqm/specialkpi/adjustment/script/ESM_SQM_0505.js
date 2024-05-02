/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0505.js
*@FileTitle      : KPI Creation & Edit_New Lane Add Pop up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.18
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.18 이혜민
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0505 : ESM_SQM_0505 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0505() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var qtaWeekArr = new Array();
qtaWeekArr["1Q"] = new Array(".wk00",".wk13");
qtaWeekArr["2Q"] = new Array(".wk14",".wk26");
qtaWeekArr["3Q"] = new Array(".wk27",".wk39");
qtaWeekArr["4Q"] = new Array(".wk40",".wk53");

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_Creation":
			doActionIBSheet(sheetObj, formObj, IBCREATE);
			break;
		case "btn_Close":
	    	//window.returnValue = "CLOSE";
	    	self.close();
	        break;

		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage(){
	var formObj = document.form;
	loadingMode = true;

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComSetObjValue(formObj.f_bse_tp_cd[0], formObj.p_bse_tp_cd.value);
	ComSetObjValue(formObj.f_spcl_tgt_cd[0], formObj.p_spcl_tgt_cd.value);
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	sheetObjects[0].DataInsert(-1);
	if(formObj.p_bse_tp_cd.value == "Q"){
		var year = formObj.f_bse_yr.value;
		var qta = formObj.f_bse_qtr_cd.value;
		document.getElementById("div_period").innerHTML = "(" + year + qtaWeekArr[qta][0] + " ~ " + year + qtaWeekArr[qta][1] + ")";
	}else{
		var year = formObj.f_bse_yr.value;
		document.getElementById("div_period").innerHTML = "(" + year + ")";
		formObj.f_bse_qtr_cd.value = "All";
	}
	//Trade 코드 값 조회
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	loadingMode = false;
}

var initSheetFn = function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle1 =  "STS|SEQ|Trade|New Lane|Trade\nBound|Copy Source Lane";

				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(10);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			40,		daCenter,	true,	"seq",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		80,		daCenter,	true,	"trd_cd",				true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtCombo,		160,	daCenter,	true,	"rlane_cd",				true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"dir_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		130,	daCenter,	true,	"src_rlane_cd",			true,	"",	dfNone,		0,	false,	true);

				CountPosition = 0;
			}
			break;
	}
}

 /**
  * Sheet 관련 프로세스 처리
  */
function doActionIBSheet(sheetObj, formObj, sAction) {
 	sheetObj.ShowDebugMsg = false;
 	switch(sAction) {
	 	case IBCLEAR:          // 화면 접속 시
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0505GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				var trade = ComXml2ComboString(arrXml[0], "code", "name");
				sheetObj.CellComboItem(sheetObj.LastRow, "trd_cd",  " |"+trade[0],  " |"+trade[1]);

			ComOpenWait(false);
			break;
 	
 		case IBSEARCH:          // 화면 접속 시 SQM_SPCL_NEW_LANE History조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0505GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			break;

		case SEARCH01:		//Trade에 맞는 Lane 조회
			ComOpenWait(true);
            var param = "f_cmd=" + SEARCH01
				            + "&code_name=rLane"
				            + "&code_param=" + sheetObj.CellValue(sheetObj.LastRow, "trd_cd")
				            + "&all_flag=" ;    // Trade

			var sXml = sheetObj.GetSearchXml("CommonGS.do", param);
			var rlane = ComXml2ComboString(sXml, "code", "name");
			sheetObj.CellComboItem(sheetObj.LastRow, "rlane_cd",  " |"+rlane[0],  " |"+rlane[1]);
			sheetObj.CellComboItem(sheetObj.LastRow, "src_rlane_cd",  " |"+rlane[0],  " |"+rlane[1]);
			ComOpenWait(false);
			break;
			
		case SEARCH02:		//Trade, Lane에 맞는 Trade Bound 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			formObj.f_trd_cd.value 	 = sheetObj.CellValue(sheetObj.SelectRow, "trd_cd");
			formObj.f_rlane_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "rlane_cd");
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0505GS.do", FormQueryString(formObj));
			sheetObj.CellValue(sheetObj.SelectRow, "dir_cd") = ComGetEtcData(sXml, "tBound");
			ComOpenWait(false);
			break;	

		case IBCREATE:          // creation
			if (!validateForm(sheetObj, formObj, sAction)) return;

			if (sheetObj.CellValue(sheetObj.LastRow, "rlane_cd") == sheetObj.CellValue(sheetObj.LastRow, "src_rlane_cd")) {
				ComShowCodeMessage("SQM00028", "New Lane", "Copy Source Lane", "Lane");
				return false;
		    }
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			formObj.f_trd_cd.value 		 = sheetObj.CellValue(sheetObj.LastRow, "trd_cd");
			formObj.f_src_rlane_cd.value = sheetObj.CellValue(sheetObj.LastRow, "src_rlane_cd");
			formObj.f_rlane_cd.value 	 = sheetObj.CellValue(sheetObj.LastRow, "rlane_cd");
			formObj.f_dir_cd.value 		 = sheetObj.CellValue(sheetObj.LastRow, "dir_cd");
			formObj.f_cmd.value = MULTI;
 			var sXml = sheetObj.GetSaveXml("ESM_SQM_0505GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00010', 'Data');
			    window.returnValue = "S"; // 메인화면의 재조회하기 위해 성공시 플래그를 넘김
			    window.close();
				//doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
    }
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
	  	case IBCREATE:  // 화면 저장시에
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount ; i++){
				if(sheetObj.CellValue(i,"ibflag") != "R"){
					if(sheetObj.CellValue(i,"trd_cd") == ""){
						ComShowCodeMessage("SQM00013", "Trade");
						return false;
					}
					if(sheetObj.CellValue(i,"rlane_cd") == ""){
						ComShowCodeMessage("SQM00013", "New Lane");
						return false;
					}
					if(sheetObj.CellValue(i,"src_rlane_cd") == ""){
						ComShowCodeMessage("SQM00013", "Copy Source Lane");
						return false;
		  			}
				}
	  		}
	  		break;
    }
    return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(Col);
	if(colName == "trd_cd"){
		if(sheetObj.CellValue(Row,"trd_cd") != ""){
			sheetObj.CellValue(Row,"dir_cd") = "";
			//Lane code 조회
			doActionIBSheet(sheetObj, formObj, SEARCH01);
		}
	}else if(colName == "rlane_cd"){
		if(sheetObj.CellValue(Row,"trd_cd") != "" && sheetObj.CellValue(Row,"rlane_cd") != "" ){
			sheetObj.CellValue(Row,"dir_cd") = "";
			//Trade Bound code 조회
			doActionIBSheet(sheetObj, formObj, SEARCH02);
		}
	}
}
/* 개발자 작업  끝 */