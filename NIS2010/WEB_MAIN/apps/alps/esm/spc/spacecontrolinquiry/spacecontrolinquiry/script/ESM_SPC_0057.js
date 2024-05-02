/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SPC_0057.js
*@FileTitle      : Space Utilization Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.10.30
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
* 2014.10.10 Arie IM [CHM-201432357] Space utilization inquiry 메뉴 로직 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SPC_0057 : ESM_SPC_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0057() {
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

// 공통전역변수
var sheetObjects = new Array();
var comObjects   = new Array();
var sheetCnt     = 0;
var clickName;
var srarchParam;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
				
			case "btn_downexcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
				
			case "btn_downexcelall":
				doActionIBSheet(sheetObj, formObj, "IBDOWNEXCELALL");
				break;
				
			case "btn_new":
				doActionIBSheet(sheetObj, formObj, IBCLEAR);
				break;
				
			case "btn_calendar1":
				// 달력 팝업
				var cal = new ComCalendar();
				cal.select(formObj.sDate, 'yyyy-MM-dd');
				break;
				
			case "btn_calendar2":
				// 달력 팝업
				var cal = new ComCalendar();
				cal.select(formObj.eDate, 'yyyy-MM-dd');
				break;
				
			case "btn_popup_pol_cd":
				clickName = srcName;
				
				if ( !formObj.pol_cd.disabled ) {
					spcPopup("POL", "loc_cd=" + formObj.pol_cd.value, 770, 470, "callbackPopup", "1,0,1,1,1,1,1,1");
				}
				break;
				
			case "btn_popup_pod_cd":
				clickName = srcName;
				
				if ( !formObj.pod_cd.disabled ) {
					spcPopup("POD", "loc_cd=" + formObj.pod_cd.value, 770, 470, "callbackPopup", "1,0,1,1,1,1,1,1");
				}
				break;
				
			case "btn_popup_lane_cd":
				clickName = srcName;
				
				spcPopup("Lane", "lane_cd=" + formObj.lane.value, 770, 470, "callbackPopup", "1,0,1,1,1,1,1,1");
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var sheetResizeFull = true;
	document_onresize();
	
	setInitDate();
	
	initControl();	
	formObj.lane.focus();

	//formObj.sDate.value = '2012-11-08';
	//formObj.eDate.value = '2012-11-14';
	//formObj.pol_cd.value = 'KRPUS';
	//formObj.pol_cd.value = 'KRPUS';
	//formObj.pod_cd.value = 'SGSIN';
	//formObj.lane.value   = 'FMXIA';
	
}

function setInitDate() {
	var formObj = document.form;
	var cDate = new Date();
	formObj.sDate.value = cDate.getYear()+"-"+((cDate.getMonth()+1)<10?"0":"")+(cDate.getMonth()+1)+"-"+((cDate.getDate())<10?"0":"")+cDate.getDate();
	
	cDate = new Date(cDate.getYear(), cDate.getMonth(), cDate.getDate() + 6);
	formObj.eDate.value = cDate.getYear()+"-"+((cDate.getMonth()+1)<10?"0":"")+(cDate.getMonth()+1)+"-"+((cDate.getDate())<10?"0":"")+cDate.getDate();
	
	formObj.sDate.focus();
	
//	ComBtnDisable("btn_downexcelall");
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				FocusEditMode = default_edit_mode;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 10, 100);
				
				var HeadTitle1 = "Seq|VVD|Lane|POL|POL|POL|POL|POD|POD|POD|POD|Carrier\nCode|Space|Space|AVG CMPB|view type||";
				var HeadTitle2 = "Seq|VVD|Lane|Port Code|TMNL Code|ETA|ETD|Port Code|TMNL Code|ETA|ETD|Carrier\nCode|TEU|Weight|AVG CMPB|view type||";
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1) + 1, 0 , 0, true);//컬럼추가(isR01)
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, true, false,false) ;
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(17) ;
				
				// 데이터속성 [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN,  COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDataSeq,	50,    daCenter,   true,    "seq",			false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		80,    daCenter,   true,    "vvd",			false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		50,    daCenter,   true,    "rlane_cd",		false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		80,    daCenter,   true,    "pol_yd_cd",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		80,    daCenter,   true,    "pol_tml_cd",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		100,   daCenter,   true,    "pol_eta",		false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		100,   daCenter,   true,    "pol_etd",		false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		80,    daCenter,   true,    "pod_yd_cd",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		80,    daCenter,   true,    "pod_tml_cd",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		100,   daCenter,   true,    "pod_eta",		false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		100,   daCenter,   true,    "pod_etd",		false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		50,    daCenter,   true,    "carrier_cd",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		50,    daRight,    true,    "load_teu_ttl",	false,    "",         dfNullInteger,	0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		55,    daRight,    true,    "load_wgt_ttl",	false,    "",         dfNullInteger,	0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,		70,    daRight,    true,    "avg_cmpb",		false,    "",         dfNullInteger,	0,          false,       false);
				InitDataProperty(0, cnt++ , dtHidden,	70,    daCenter,   true,    "view_type",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtHidden,	30,    daCenter,   true,    "is_r01",	false,    "",         dfNone,		0,          false,       false);
				InitDataProperty(0, cnt++ , dtHidden,	30,    daCenter,   true,    "is_r02",	false,    "",         dfNone,		0,          false,       false);
			}
			break;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.Redraw = false;
	
	switch(sAction) {
		
		case IBSEARCH:      //조회
			if ( !validateForm(sheetObj,formObj,sAction) ) {
				sheetObj.Redraw = true;
				return false;
			}
			
			formObj.f_cmd.value = SEARCHLIST;
			
			var param = SpcFormString(formObj,'sDate,eDate,view_type11,pol_cd,pod_cd,lane,login_user_id');
			
			var rtn =  sheetObj.GetSearchXml("ESM_SPC_0057GS.do","f_cmd=" + (SEARCHLIST)+"&"+param);
			
			if ( ComGetObjValue(formObj.view_type11[0]) == "P" ) {
				sheetObj.ColHidden("pol_yd_cd")  = true;
				sheetObj.ColHidden("pod_yd_cd")  = true;
				sheetObj.ColHidden("pol_tml_cd") = false;
				sheetObj.ColHidden("pod_tml_cd") = false;
			} else {
				sheetObj.ColHidden("pol_yd_cd")  = false;
				sheetObj.ColHidden("pod_yd_cd")  = false;
				sheetObj.ColHidden("pol_tml_cd") = true;
				sheetObj.ColHidden("pod_tml_cd") = true;
				sheetObj.ColHidden("rlane_cd")   = true;
			}
			
			if (ComGetObjValue(formObj.lane) == "") {
				ComBtnDisable("btn_downexcelall");
			} else {
				ComBtnEnable("btn_downexcelall");
			}
			
			sheetObj.LoadSearchXml(rtn);
			break;
			
		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;
			
		case "IBDOWNEXCELALL":		// 엑셀 다운로드
			if ( !validateForm(sheetObj,formObj,sAction) ) {
				sheetObj.Redraw = true;
				return false;
			}
			ComOpenWait(true);
			
			var param = SpcFormString(formObj,'sDate,eDate,view_type11,pol_cd,pod_cd,lane');
			
			document.location.href = "ESM_SPC_0057DL.do?f_cmd=" + (ComGetObjValue(formObj.view_type11[0]) == "P"?COMMAND01:COMMAND02) + "&" + param;
			
			ComOpenWait(false);
			break;
			
		case IBCLEAR:        //초기화
			resetAll();
			setInitDate();
			break;
	}
	sheetObj.Redraw = true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	
	switch(sAction) {
		
		case IBSEARCH:      //조회
			// To Date 가 From Date 보다 큰지 Check 
			if ( formObj.sDate.value > formObj.eDate.value ) {
				ComShowCodeMessage("COM12133", "To Date", "from Date", "later");
				formObj.sDate.focus();
				return false;
			}
			
			// by port는 2주 이내 조회 by lane은 30일 이내 조회 Check
			//if ( ComGetObjValue(formObj.view_type11[0]) == "L" )
			var fDt = document.form.sDate.value.split("-").join("");
			var tDt = document.form.eDate.value.split("-").join("");
	
			if (ComGetObjValue(formObj.lane) != "") {
				if ( SpcGetDateIntervals(fDt, tDt, "D") >= 30 ) {
					ComShowCodeMessage("COM12114", "Date");
					formObj.sDate.focus();
					return false;
				}
			}else{
				if ( SpcGetDateIntervals(fDt, tDt, "D") >= 14 ) {
					ComShowCodeMessage("COM12114", "Date");
					formObj.sDate.focus();
					return false;
				}
			}
				
			
			if (ComGetObjValue(formObj.view_type11[0]) == "P") {
				if (ComGetObjValue(formObj.pol_cd) == "") {
					ComShowCodeMessage("COM130403", "POL");
					formObj.pol_cd.focus();
					return false;
				}
				
				if (ComGetObjValue(formObj.pod_cd) == "") {
					ComShowCodeMessage("COM130403", "POD");
					formObj.pod_cd.focus();
					return false;
				}
			} else {
				if (ComGetObjValue(formObj.lane) == "") {
					ComShowCodeMessage("COM130403", "Lane Code");
					formObj.lane.focus();
					return false;
				}
			}
			break;
			
		case "IBDOWNEXCELALL":
			if ( sheetObj.SearchRows == 0 ) {
				ComShowMessage(getMsg("SPC90144"));
				return false;
			}
			break;
	}
	
	return true;
}

function callbackPopup(rowArray){
	var formObj  = document.form;
	var colArray = rowArray[0];
	var val = colArray[3];
	
	if ( clickName == "btn_popup_pol_cd" ) {
		formObj.pol_cd.value = val;
	} else if ( clickName == "btn_popup_pod_cd" ) {
		formObj.pod_cd.value = val;
	} else if ( clickName == "btn_popup_lane_cd" ) {
		formObj.lane.value = val;
	}
}

function initControl() {
	var formObj = document.form;
	
	axon_event.addListenerForm("click",	"obj_click",	formObj);
}

function obj_click() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	
	with(formObj) {
		
		switch(srcName) {
		
			case "view_type11":
				if ( view_type11[0].checked ) {
					pol_cd.className = "input1";
					pod_cd.className = "input1";
					lane.className   = "input4";
					
					pol_cd.disabled = false;
					pod_cd.disabled = false;
				} else {
					pol_cd.className = "input2";
					pod_cd.className = "input2";
					lane.className   = "input1";
					
					pol_cd.disabled = true;
					pod_cd.disabled = true;
				}
				break;
		}
	}
}

function sheet1_OnDblClick(sheetObj, row, col){
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	
		if ( colName == "vvd" && sheetObj.CellValue(row, col).length == 9 && sheetObj.CellValue(row, "view_type") == "P") {
			if(sheetObj.CellValue(row, "is_r01")=="N"){
				ComShowCodeMessage("COM131601");
			}else if(sheetObj.CellValue(row, "is_r01")=="Y"){
				var pgmNo  = "&pgmNo=ESM_SPC_0042";
		        var param  = "vvd="       + sheetObj.CellValue(row, col);
		            param += "&rlane_cd=" + sheetObj.CellValue(row, "rlane_cd");
		            param += "&type="     + "Y";	// VVD, Lane 정보로 조회 및 Edit 불가
		            
				var url = "ESM_SPC_0042.do?" + param + pgmNo;
				
				var leftpos = (screen.width - 1024) / 2;
				if (leftpos < 0)
					leftpos = 0;
				var toppos = (screen.height - 540) / 2;
				if (toppos < 0)
					toppos = 0;    				
		
				ComOpenWindow(url, 'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight540px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
			}
		} else if ( colName == "vvd" && sheetObj.CellValue(row, col).length == 9 && sheetObj.CellValue(row, "view_type") == "L") {
			if(sheetObj.CellValue(row, "is_r02")=="N"){
				ComShowCodeMessage("COM131601");
			}else if(sheetObj.CellValue(row, "is_r02")=="Y"){
				var vvd   = sheetObj.CellValue(row, col);
				var param = "";
				param = param + "&vvd="   + vvd;
				param = param + "&popupcheck=Y";
				
				var url = "ESM_SPC_0058.do?" + param;
				
				//var leftpos = (screen.width - 1100) / 2;
				//if (leftpos < 0)
				//	leftpos = 0;
				//var toppos = (screen.height - 1000) / 2;
				//if (toppos < 0)
				//	toppos = 0;    	
				var rtn = window.open(url, "POPUP", "height=700px,width=1024px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")		
				//ComOpenWindow(url, 'none',"scroll:no;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1100px;dialogHeight1000px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
			}
		}
}
/* 개발자 작업  끝 */