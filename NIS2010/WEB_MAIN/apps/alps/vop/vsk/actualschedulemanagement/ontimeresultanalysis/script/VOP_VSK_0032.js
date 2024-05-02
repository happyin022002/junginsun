/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0032.js
 *@FileTitle : On-Time Ratio
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.11
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.09.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
 * 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
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
 * @class VOP_VSK_0032 : VOP_VSK_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0032() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {

			case "btn_Retrieve":
				with(formObj){
					if(start_date1.value==""){
						ComShowCodeMessage('VSK00027', "Period1 Start Date");
						start_date1.focus();
						return;
					}else if(end_date1.value==""){
						ComShowCodeMessage('VSK00027', "Period1 End Date");
						end_date1.focus();
						return;
					}
//					else if(start_date2.value==""){
//						ComShowCodeMessage('VSK00027', "Period2 Start Date");
//						start_date2.focus();
//						return;
//					}else if(end_date2.value==""){
//						ComShowCodeMessage('VSK00027', "Period2 End Date");
//						end_date2.focus();
//						return;
//					}
					
					// period1, period2 의 종료일중 더 큰값을  sum_date로 설정한다.
					if(end_date2.value==""){
						sum_date.value = end_date1.value;
					}else{
						if(end_date2.value > end_date1.value){
							sum_date.value = end_date2.value;
						}else{
							sum_date.value = end_date1.value;
						}
					}
					
				}
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
				
			case "btn_cal11":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.start_date1, 'yyyy-MM');
				break;
				
			case "btn_cal12":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.end_date1, 'yyyy-MM');
				break;
				
			case "btn_cal21":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.start_date2, 'yyyy-MM');
				break;
				
			case "btn_cal22":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.end_date2, 'yyyy-MM');
				break;
				
			case "btns_search1":
				var sUrl = "/hanjin/VOP_VSK_0202.do?intg_cd_id=CD00717";
				var rVal = ComOpenPopupWithTarget(sUrl, 428, 470, "", "0,0", true);
				if(rVal){
					formObj.vsl_slan_cd.value = rVal;
				}
				break;
				
			case "btns_search2":
				var sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y"; //[CHM-201109577-01]
				var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
				if(rVal){
					formObj.vsl_cd.value = rVal;
				}
				break;
				
			case "btns_search3":
				var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
				var rVal = ComOpenPopupWithTarget(sUrl, 428, 520, "", "0,0", true);
				if(rVal){
					formObj.vps_port_cd.value = rVal;
				}
				break;
				
			case "btns_search4":
				var sUrl = "/hanjin/COM_ENS_0N1.do";
				ComOpenPopupWithTarget(sUrl, 426, 450, "3:crr_cd", "0,0", true);
				break;
			
			case "btn_DownExcel":
				sheetObjects[0].Down2Excel(-1);
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	
	// 날짜초기화
	var formObj = document.form;
	var today = new Date();
	with (formObj) {
		start_date1.value = ComGetNowInfo("ym", "-");
		end_date1.value = ComGetNowInfo("ym", "-");
	}
	
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 340;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(11, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false)

			var HeadTitle1 = "Port|Period 1|Period 1|Period 1|Period 2|Period 2|Period 2|Diff.|||SUM";
			var HeadTitle2 = "Port|Call|On-time|Ratio(%)|Call|On-time|Ratio(%)|Ratio(%) |||Ratio(%)";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 			107, daCenter, true, "grp_id", 			false, "", dfNone, 			0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 	107, daRight, true, 	"ttl_call01", 			false, "", dfNullInteger, 	0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 	107, daRight, true, 	"ontime_call01", 	false, "", dfNullInteger, 	0, false, false);
			InitDataProperty(0, cnt++, dtData, 			107, daRight, true, 	"dur_ratio01", 		false, "", dfNullFloat, 		1, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 	107, daRight, true, 	"ttl_call02", 			false, "", dfNullInteger, 	0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 	107, daRight, true, 	"ontime_call02", 	false, "", dfNullInteger, 	0, false, false);
			InitDataProperty(0, cnt++, dtData, 			107, daRight, true, 	"dur_ratio02", 		false, "", dfNullFloat, 		1, false, false);
			InitDataProperty(0, cnt++, dtData, 			107, daRight, true, 	"diff_rat", 			false, "", dfNullFloat,		1, false, false);
			
			InitDataProperty(0, cnt++, dtAutoSum, 	0, daRight, true, 	"ttl_call03", 			false, "", dfNullInteger, 	0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 	0, daRight, true, 	"ontime_call03", 	false, "", dfNullInteger, 	0, false, false);
			InitDataProperty(0, cnt++, dtData,			107, daRight, true, 	"dur_ratio03",		false, "", dfNullFloat, 		1, false, false);

			MessageText("Sum") ="Total"; 
			
			ColHidden(8) = true;
			ColHidden(9) = true;
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	
		case IBSEARCH: // 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			if(formObj.ontime_opt.value==""){
				formObj.ontime_opt.value = "0";
			}
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			break;
			
		case SEARCH01: // Lane Code 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			
			var vsl_slan_cd = ComGetEtcData(sXml, "vsl_slan_cd");
			if(vsl_slan_cd==null){
				ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
			}
			break;
			
		case SEARCH02: // Vessel Code 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			
			var vsl_cd = ComGetEtcData(sXml, "vsl_cd");
			if(vsl_cd==null){
				ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.vsl_cd.value = "";
				formObj.vsl_cd.focus();
			}
			break;
			
		case SEARCH03: // Port Code 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH03;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			
			var vps_port_cd = ComGetEtcData(sXml, "vps_port_cd");
			if(vps_port_cd==null){
				ComShowCodeMessage('VSK00029', formObj.vps_port_cd.value);
				formObj.vps_port_cd.value = "";
				formObj.vps_port_cd.focus();
			}
			break;
			
		case SEARCH04: // Carrier Code 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH04;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			
			var crr_cd = ComGetEtcData(sXml, "crr_cd");
			if(crr_cd==null){
				ComShowCodeMessage('VSK00021', formObj.crr_cd.value);
				formObj.crr_cd.value = "";
				formObj.crr_cd.focus();
			}
			break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}

function initControl(){
	var formObj = document.form;
	axon_event.addListenerForm("keypress", "enter_keypress", formObj);	//- Enter 키 처리
    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);		//- 자동포커스 처리
    
    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("beforedeactivate", "obj_beforedeactivate", formObj);
    axon_event.addListenerForm("focus", "obj_activate", formObj);
    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
    
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

function obj_keypress(){

	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
	case "vsl_slan_cd":
	case "vsl_cd":
	case "vps_port_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;

	case "crr_cd":
		ComKeyOnlyAlphabet('upper');
		break;
		
	case "start_date1":
	case "end_date1":
	case "start_date2":
	case "end_date2":
		ComKeyOnlyNumber();
		break;
		
	case "ontime_opt":
		ComKeyOnlyNumber(event.srcElement);
		break;
			
	}
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_beforedeactivate() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "start_date1":
		case "end_date1":
		case "start_date2":
		case "end_date2":
			ComChkObjValid(event.srcElement);
			break;
	}
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_activate() {
	// 마스크구분자 없애기
	switch (event.srcElement.name) {
		case "start_date1":
		case "end_date1":
		case "start_date2":
		case "end_date2":
			ComClearSeparator(event.srcElement);
			break;	
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_keyup(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH01);
			}
			break;
		case "vsl_cd":
			if(ComChkLen(obj.value, 4)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH02);
			}
			break;
		case "vps_port_cd":
			if(ComChkLen(obj.value, 5)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH03);
			}
			break;
		case "crr_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH04);
			}
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	
	var formObj = document.form;
	var group = formObj.grp_id;
	sheetObj.CellValue2(0, 0) = group.options[group.selectedIndex].text;
	sheetObj.CellValue2(1, 0) = group.options[group.selectedIndex].text;
	
	for(var i=2; i<=sheetObj.LastRow; i++){
		if(sheetObj.CellValue(i, "diff_rat")<0){
			sheetObj.CellFontColor(i, "diff_rat") = sheetObj.RgbColor(255, 0, 0);
		}
	}
	
	// total row가 있으면 각 항목을 계산한다.
	with(sheetObj){
		if(CellValue(LastRow, "grp_id")=="Total"){
			// Period Ratio1 
			// 수식 : Period Ontime1 / Period Call1 * 100
			if(CellValue(LastRow, "ttl_call01")==0){
				CellValue2(LastRow, "dur_ratio01") = 0;
			}else{
				CellValue2(LastRow, "dur_ratio01") = CellValue(LastRow, "ontime_call01") / CellValue(LastRow, "ttl_call01") * 100;
			}
			
			// Period Ratio2
			// 수식 : Period Ontime2 / Period Call2 * 100
			if(CellValue(LastRow, "ttl_call02")==0){
				CellValue2(LastRow, "dur_ratio02") = 0;
			}else{
				CellValue2(LastRow, "dur_ratio02") = CellValue(LastRow, "ontime_call02") / CellValue(LastRow, "ttl_call02") * 100;
			}
			
			// Diff
			// 수식 : Period Ratio1 - Period Ratio2
			CellValue2(LastRow, "diff_rat") = CellValue(LastRow, "dur_ratio01") - CellValue(LastRow, "dur_ratio02");
			
			// Sum
			// 수식 : Sum Ontime / Sum Call * 100
			if(CellValue(LastRow, "ttl_call03")==0){
				CellValue2(LastRow, "dur_ratio03") = 0;
			}else{
				CellValue2(LastRow, "dur_ratio03") = CellValue(LastRow, "ontime_call03") / CellValue(LastRow, "ttl_call03") * 100;
			}
		}	
	}
	
	
}

/* 개발자 작업 끝 */