/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0009.js
*@FileTitle      : Lane-Office Relation Setting_New Lane Add Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.20
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.20 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0009 : ESM_SQM_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0009() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_Apply":
				doActionIBSheet(sheetObj, formObj, "Apply");
				break;
			case "btn_Close":
				window.close();
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

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObj = document.form;
	loadingMode = true;

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	ComSetObjValue(formObj.f_bse_tp_cd[0], p_bse_tp_cd);

	f_bse_tp_cd_OnChange();

	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		// sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host 정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle =  "RHQ|Office|Active|lvl|STS";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				// 전체 높이 설정
				style.height = GetSheetHeight(10);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenterTop,	true,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,		true,	"ofc_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		60,	daCenter,		true,	"sqm_act_flg",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,		true,	"",				false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	80,	daCenter,		true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);

				ImageList(0) = "img/nolines_plus.gif";
				ImageList(1) = "img/nolines_minus.gif";

				InitTreeInfo(4, "lvl", RgbColor(0,0,255), false);
			}
			break;
	}
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
		default:
			with (comboObj) {
				DropHeight = 300;
				Index      = 0;
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0009GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_dir_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}

			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			searchParams = FormQueryString(formObj);

			sheetObj.DoSearch4Post("ESM_SQM_0009GS2.do", searchParams);

			// Tree 모두 접기
			sheetObj.ShowTreeLevel(0, 1);

			ComOpenWait(false);
			break;

		case "Apply":          // Apply 버튼 클릭
			if (sheetObj.TotalRows <= 0) {
				ComShowCodeMessage("SQM00026");
				return false;
			}

			ComOpenWait(true);

			if (ComShowConfirm (ComGetMsg("SQM00012", "Apply")) != 1) {
				ComOpenWait(false);
				return false;
		    }

			var opener = window.dialogArguments;
			var rows   = sheetObj.FindStatusRow("U");
			var rowArr = rows.split(";");

			var arr        = new Array();
			var sub_trd_cd = "";

			for (var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++) {
				if ( ComTrim(sheetObj.CellValue(i, "ofc_cd")).length == 5 ) {
					sub_trd_cd = ComGetObjValue(document.form.f_sub_trd_cd);

					arr[0] = ComGetObjValue(document.form.f_trd_cd);
					arr[1] = ComTrim(sub_trd_cd)=="All"?"":sub_trd_cd;
					arr[2] = ComGetObjValue(document.form.f_dir_cd);
					arr[3] = ComGetObjValue(document.form.f_rlane_cd);
					arr[4] = sheetObj.CellValue(i, "rhq_cd");
					arr[5] = sheetObj.CellValue(i, "ofc_cd");
					arr[6] = sheetObj.CellValue(i, "sqm_act_flg");
					arr[7] = "Y";

					opener.newLaneAdd( arr );
				}
			}

			ComOpenWait(false);

			ComShowCodeMessage("SQM00011", "Lane");

			window.close();
			break;

    }
}

/**
 * Sheet1 클릭 시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "ofc_cd":
			var mark = sheetObj.CellValue(row, col);

			if(mark == "0"){
				sheetObj.RowExpanded(row)     = true;
				sheetObj.CellValue2(row, col) = "1";
			} else if(mark == "1"){
				sheetObj.RowExpanded(row)     = false;
				sheetObj.CellValue2(row, col) = "0";
			}
			break;
	}
}

/**
 *  선택된 Trade 에 해당하는 Sub Trade, R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_trd_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if (value != "All") {
		var code_name  = new Array("subTrade", "rLane");
		var code_param = new Array(value, value);
		var all_flag   = new Array("All", "All");

		var param = "f_cmd="		+ SEARCH01
		          + "&code_name="	+ code_name
		          + "&code_param="	+ code_param
		          + "&all_flag="	+ all_flag;

		var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "name");
			formObj.f_sub_trd_cd.Index = 0;
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "name");
			formObj.f_rlane_cd.Index = 0;
		}

	} else {
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=subTrade&code_param=" + value + "&all_flag=All");

		ComXml2ComboItem(sXml, formObj.f_sub_trd_cd, "code", "name");
		formObj.f_sub_trd_cd.Index = 0;

		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
	}
}

/**
 *  선택된 Sub Trade 에 해당하는 R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_sub_trd_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var trd_cd   = ComGetObjValue(formObj.f_trd_cd);

	var param = "f_cmd="		   + SEARCH01
    + "&code_name=rLane"
    + "&code_param="     + trd_cd + "|" + value
    + "&all_flag=All";
	
	var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
	var arrXml = sXml.split("|$$|");
	if (arrXml.length > 0) {
		ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
		formObj.f_rlane_cd.Index = 0;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){

	switch(sAction) {
		case IBSEARCH:
			var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
			var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
			var dir_cd     = ComGetObjValue(formObj.f_dir_cd);
			var rlane_cd   = ComGetObjValue(formObj.f_rlane_cd);

			if (trd_cd == "All") {
				ComShowCodeMessage("SQM00013", "Trade");
				formObj.f_trd_cd.focus();
				return false;
			}

			if (trd_cd != "EMS" && sub_trd_cd == "All") {
				ComShowCodeMessage("SQM00013", "Sub Trade");
				formObj.f_sub_trd_cd.focus();
				return false;
			}

			if (dir_cd == "All") {
				ComShowCodeMessage("SQM00013", "Bound");
				formObj.f_dir_cd.focus();
				return false;
			}

			if (rlane_cd == "All") {
				ComShowCodeMessage("SQM00013", "R/Lane");
				formObj.f_rlane_cd.focus();
				return false;
			}
    		break;
	}
	return true;
}


/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr    = document.getElementById("div_qtr");
	var div_period = document.getElementById("div_period");

	if (bse_tp_cd == "Y") {
		div_qtr.style.display = "none";
		div_period.style.display = "none";
		formObj.f_bse_qtr_cd.style.display = "none";
	} else {
		div_qtr.style.display = "inline";
		div_period.style.display = "inline";
		formObj.f_bse_qtr_cd.style.display = "inline";
	}

	period_change();
}

/* 개발자 작업  끝 */