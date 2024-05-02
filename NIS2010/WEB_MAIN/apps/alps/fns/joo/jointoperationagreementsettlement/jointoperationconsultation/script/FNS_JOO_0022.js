/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0022.js
 *@FileTitle : CSR Approval
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.10 박희동
 * 1.0 Creation
 * 
 * 2014.07.25 민정호 CHM-20430993 [Develop-FMS-JOO]비용 전표 상신용 Approval 구축
 * 10만불 이상 금액에 대해서 CEO 결재 승인 기능 추가 
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
 * @class fns_joo_0022 : fns_joo_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0022() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var prefix = "sheet1_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
	
			case "btn_calendar":
				var cal = new ComCalendar();
				cal.select(formObject.slp_iss_dt, 'yyyy-MM-dd');
				break;
				
			case "btn_downexcel":
				sheetObject1.SpeedDown2Excel();
				break;

			case "btn_new":
				formObject.csr_no.value="";
				formObject.if_flg[0].checked = true;
				formObject.slp_iss_dt.value = formObject.sysdate.value;
				sheetObject1.RemoveAll();
				formObject.if_flg[1].focus();
				break;

			case "btn_csr":
				if (sheetObject1.SelectRow == undefined || sheetObject1.SelectRow == null){
					ComShowCodeMessage('JOO00072');
					return;
				}
				if (sheetObject1.LastRow == 0){
					ComShowCodeMessage('JOO00073');
					return;
				}
				var row = sheetObject1.SelectRow;
				
				var csrNo = sheetObject1.CellValue(row, prefix+"csr_no");
				
				if (csrNo == ""){
					ComShowCodeMessage('JOO00074');
					return;
				}
				
				var param = '?csrNo='+csrNo;
				//ComOpenPopup('/hanjin/FNS_JOO_0024.do'+param, 835, 450, 'popupFinish', '1,0,1,1,1,1,1,1', true);
				ComOpenPopup('/hanjin/FNS_JOO_0024.do'+param, 835, 430, '', 'none', true);
  				//ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
				
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

function popupFinish(aryPopupData){
	///alert("popUpFinish");
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
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
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
    document.form.if_flg[1].focus()
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	switch (sheetNo) {
		case 1: //t1sheet1 init
			with (sheetObj) {
	
				// 높이 설정
				style.height = 460;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "status|Register No.|Issue Date|Effective Date|Currency|Amount|Issuer|Description|LastAproFlg";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix+"ibflag");
				InitDataProperty(0, cnt++, dtData        , 0, daCenter, true, prefix+"csr_no"          , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 0, daCenter, true, prefix+"slp_iss_dt"      , false, "", dfDateYmd);
				InitDataProperty(0, cnt++, dtData        , 0, daCenter, true, prefix+"eff_dt" 	       , false, "", dfDateYmd);
				InitDataProperty(0, cnt++, dtData        , 0, daCenter, true, prefix+"csr_locl_curr_cd", false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 0, daRight , true, prefix+"csr_locl_amt"    , false, "", dfNullFloat, 2);
				InitDataProperty(0, cnt++, dtData        , 0, daCenter, true, prefix+"issuer"          , false, "", dfNone);
				InitDataProperty(0, cnt++, dtData        , 0, daLeft  , true, prefix+"csr_desc"        , false, "", dfNone);
				InitDataProperty(0, cnt++, dtHidden      , 0, daLeft  , true, prefix+"lst_apro_flg"    , false, "", dfNone);
				FitColWidth("0|15|9|9|10|10|12|");
			}
		break;
	}
}

function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObject = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur' , formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_focus', formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObject);

    axon_event.addListener  ('keypress', 'csr_no_keypress' , 'csr_no');		
    axon_event.addListener  ('keypress', 'slp_iss_dt_keypress' , 'slp_iss_dt');		
    axon_event.addListener  ('click', 'change_event_radio', 'if_flg');    
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
    ComChkObjValid(event.srcElement);
}

function obj_focus(){
    ComClearSeparator(event.srcElement);
}

function csr_no_keypress(){
    //영대문자 자동변환
    ComKeyOnlyAlphabet('uppernum');
    if (ComTrim(document.form.slp_iss_dt.value) != "")
    	document.form.slp_iss_dt.value = "";
    
    sheetObjects[0].RemoveAll();
}

function change_event_radio(){
	sheetObjects[0].RemoveAll();
}

function slp_iss_dt_keypress(){
    ComKeyOnlyNumber(document.form.slp_iss_dt);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if (!validateForm(sheetObj, formObj, sAction))
		return;

	formObj.slp_iss_dt.value = ComReplaceStr(formObj.slp_iss_dt,"-","");

	switch (sAction) {
		case IBSEARCH: //조회
			if (formObj.csr_no.value.length >= 19){
//				var param = '?csrNo='+formObj.csr_no.value+"&editable=Y";
//				ComOpenPopup("/hanjin/FNS_JOO_0023.do"+param, 1024, 410, "popupFinish1", "1,0,1,1,1,1,1,1", true);
				
				//201407 민정호 파일 팝업 세션 끊기는 문제때문에 호출방식 변경	
				var height = screen.height; 
				var width = screen.width;
				
				var w = 1024;
			    var h = 410;
			    
			    var leftpos = width/2 - w/2; 
				var toppos = height/2 - h/2; 
				
				var url = "/hanjin/FNS_JOO_0023.do?csrNo="+formObj.csr_no.value+'&editable=Y';
			   	window.open(url, "xxxxxxxx", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);	
			   	
			}else{
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("FNS_JOO_0022GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			}
			break;
	}
	formObj.slp_iss_dt.focus();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: //조회
			var csrNo = formObj.csr_no.value; 
			if (csrNo.length > 0 && csrNo.length < 19){
				ComShowCodeMessage("JOO00075");
				formObj.csr_no.focus();
				return false;
			}
			var slpIssDt = ComReplaceStr(formObj.slp_iss_dt,"-","");

			if (csrNo.length == 0 && slpIssDt.length == 0){
				ComShowCodeMessage("JOO00076");
				formObj.csr_no.focus();
				return false;
			}
		break;
	}

	return true;
}

/**
 * double Click 시
 * @param sheetObj
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
//function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
function sheet1_OnDblClick(sheetObj, Row, Col) {
//	var param = '?csrNo='+sheetObj.CellValue(Row, prefix+'csr_no')+'&editable=Y';
//	ComOpenPopup('/hanjin/FNS_JOO_0023.do'+param, 1024, 410, 'popupFinish1', '1,0,1,1,1,1,1,1', true);
	
	//201407 민정호 파일 팝업 세션 끊기는 문제때문에 호출방식 변경	
	var height = screen.height; 
	var width = screen.width;
	
	var w = 1024;
    var h = 410;
    
    var leftpos = width/2 - w/2; 
	var toppos = height/2 - h/2; 
	
	var url = "/hanjin/FNS_JOO_0023.do?csrNo="+sheetObj.CellValue(Row, prefix+'csr_no')+'&editable=Y';
   	window.open(url, "xxxxxxxx", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);	
}

///**
// * pop up창이 닫혔을때
// * @param arry
// * @return
// */
//function popupFinish1(arry){
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//}

/**
 * pop up창이 닫혔을때
 * @param arry
 * @return
 */
function popupFinish1(){
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/* 개발자 작업  끝 */