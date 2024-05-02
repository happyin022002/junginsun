/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0044.js
 *@FileTitle : Tax Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.18 박희동
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
 * @class fns_joo_0044 : fns_joo_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0044() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;
	var rdObject = rdObjects[0];
    try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btns_back1":
			if (formObject.tax_inv_yrmon_fr.value!=""){
				formObject.tax_inv_yrmon_fr.value = ComGetDateAdd(formObject.tax_inv_yrmon_fr.value+"-01","M",-1).substring(0,7);
			}
			break;

		case "btns_next1":
			if (formObject.tax_inv_yrmon_fr.value!=""){
				formObject.tax_inv_yrmon_fr.value = ComGetDateAdd(formObject.tax_inv_yrmon_fr.value+"-01","M",1).substring(0,7);
			}
			break;

		case "btns_back2":
			if (formObject.tax_inv_yrmon_to.value!=""){
				formObject.tax_inv_yrmon_to.value = ComGetDateAdd(formObject.tax_inv_yrmon_to.value+"-01","M",-1).substring(0,7);
			}
			break;

		case "btns_next2":
			if (formObject.tax_inv_yrmon_to.value!=""){
				formObject.tax_inv_yrmon_to.value = ComGetDateAdd(formObject.tax_inv_yrmon_to.value+"-01","M",1).substring(0,7);
			}
			break;
			
		case "btn_new":
			sheetObject1.RemoveAll();
			break;

		case "btn_downExcel":
			sheetObject1.SpeedDown2Excel();
			break;

		case "btn_print":
 
            rdOpen(  document.form);
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(tpCombo, plCombo, tpNmCombo, plNmCombo) {

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1, tpCombo, plCombo, tpNmCombo, plNmCombo);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, "rdoCity"); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리

	axon_event.addListener('keypress', 'tax_inv_yrmon_fr_keypress', 'tax_inv_yrmon_fr');	
	axon_event.addListener('keypress', 'tax_inv_yrmon_to_keypress', 'tax_inv_yrmon_to');	
	
	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    var doc = document.all;
    var formObj = document.form;
    formObj.com_mrdBodyTitle.value = doc.title.innerHTML.replace("&nbsp;","");
    formObj.com_mrdTitle.value = doc.title.innerHTML.replace("&nbsp;","");
}
 
 function rdOpen(){
     var formObj = document.form;
     queryStr="";
     if( !setQueryStr() ){
         return;
     }
    var rdParam = '/rp '+queryStr;
    var strPath   =  "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_0072.mrd";
     // 열고자 하는 RD 파일을 지정한다.
    // Rdviewer.FileOpen( strPath, RDServerBAT + rdParam);
 
    formObj.com_mrdPath.value = strPath;
    formObj.com_mrdArguments.value = rdParam;
    ComOpenRDPopup();

 }
 function setQueryStr(){
 
     var formObj = document.form;
     if( formObj.tax_inv_yrmon_fr.value == ""){
         if( !ComChkObjValid( formObj.tax_inv_yrmon_fr ) ){
             return false;
         }
     }
     if( formObj.tax_inv_yrmon_to.value == ""){
         if( !ComChkObjValid( formObj.tax_inv_yrmon_to ) ){
             return false;
         }
     }
//     var fr = tax_inv_yrmon_fr.value;
//     var to = tax_inv_yrmon_to.value;
 
     queryStr += " ["+formObj.tax_inv_yrmon_fr.value+"]";
     queryStr += " ["+formObj.tax_inv_yrmon_to.value  +"]";
    //queryStr += " ["+formObj.ofc_cd.value  +"]";     
     
 
     return true;
 }
//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}

function obj_activate(){
    ComClearSeparator(event.srcElement);
}

function tax_inv_yrmon_fr_keypress(){
	ComKeyOnlyNumber(this, '');
}

function tax_inv_yrmon_to_keypress(){
	ComKeyOnlyNumber(this, '');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, tpCombo, plCombo, tpNmCombo, plNmCombo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 420;
			// 전체 너비 설정
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

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(13, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "|세금계산서 번호|세금계산서 번호|세금계산서 번호|사업자번호|상호|발행일자|공급가액|세액|품목|TP|흑.적|전표번호";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet1_";
			
			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, true, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"tax_inv_yrmon", false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"ofc_cd"       , false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"tax_ser_no"   , false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix+"spl_rgst_no"  , false ,"", dfSaupNo , 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 100, daLeft  , true, prefix+"co_nm"        , false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix+"iss_dt"       , false ,"", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtAutoSum     , 100, daRight , true, prefix+"spl_amt"      , false ,"", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  50, daRight , true, prefix+"tax_amt"      , false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix+"itm_nm"       , false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtCombo       ,  50, daCenter, true, prefix+"tax_vat_tp_cd", false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtCombo       ,  50, daCenter, true, prefix+"tax_pl_cd"    , false ,"", dfNone   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,   0, daCenter, true, prefix+"slp_no"       , false ,"", dfNone   , 0, true, true);
			
			InitDataCombo(0, prefix+"tax_vat_tp_cd", tpNmCombo, tpCombo);
			InitDataCombo(0, prefix+"tax_pl_cd"    , plNmCombo, plCombo);
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	if (!validateForm(sheetObj, formObj, sAction)) return;
	
	switch (sAction) {
		case IBSEARCH: //조회 
			formObj.f_cmd.value = SEARCH;
			var prefix = "sheet1_";
			sheetObj.DoSearch("FNS_JOO_0044GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch(sAction){
			case IBSEARCH:
				var fr = tax_inv_yrmon_fr.value;
				var to = tax_inv_yrmon_to.value;
				
				if (fr ==""){
					ComShowCodeMessage();
					tax_inv_yrmon_fr.focus();
					return false;
				}
				if (ComGetDaysBetween(fr+"-01", to+"-01") < 0){
					ComShowCodeMessage("JOO00078");
					tax_inv_yrmon_to.focus();
					return false;
				}
				break;
		}
	}

	return true;
}
/* 개발자 작업  끝 */