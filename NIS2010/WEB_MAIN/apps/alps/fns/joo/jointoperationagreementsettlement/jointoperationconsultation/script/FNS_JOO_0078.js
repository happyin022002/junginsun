/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0078.js
 *@FileTitle : CSR Invoice Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.17
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.12.17 박희동
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
 * @class FNS_JOO_0078 : FNS_JOO_0078 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0078() {
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

var rdObjects = new Array();
var rdCnt = 0;

var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":

			if (!duration_change())
				return;

			doActionIBSheet(sheetObject, formObj, IBSEARCH);
			break;

		case "btn_new":
			ComResetAll();
			break;

		case "btn_save":
			if (ComIsBtnEnable("btn_save")) {
				doActionIBSheet(sheetObject, formObj, IBSAVE);
			}
			break;

		case "btn_fr_duration":
			var cal = new ComCalendar();

			cal.setEndFunction("duration_change"); 			
			cal.setDisplayType('date');
			cal.select(form.eff_dt_fr, 'yyyy-MM-dd');
			duration_change();
			break;

		case "btn_to_duration":
			var cal = new ComCalendar();

			cal.setEndFunction("duration_change"); 			
			cal.setDisplayType('date');
			cal.select(form.eff_dt_to, 'yyyy-MM-dd');
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

function obj_focus(){
    ComClearSeparator(event.srcElement);
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur() {
	ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress() {

	obj = event.srcElement;

	if (obj.dataformat == null)
		return;
	window.defaultStatus = obj.dataformat;

	switch (event.srcElement.dataformat) {
		case "engup":
			ComKeyOnlyAlphabet('uppernum', "0123456789");
			break;
		case "int":
			//숫자 만입력하기
			ComKeyOnlyNumber(event.srcElement);
	
			break;
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		default:
			//숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
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
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
	sheetObjects[0].ExtendLastCol = false;

	//html컨트롤 이벤트초기화
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('blur', 'obj_blur', document.form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_focus', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리

	axon_event.addListener('change', 'duration_change', 'eff_dt_fr'); //- Duration 입력 후 From~To 비교
	axon_event.addListener('change', 'duration_change', 'eff_dt_to'); //- Duration 입력 후 From~To 비교
}

/**
 * Duration 입력 후 From~To 비교
 **/
function duration_change() {

	var formObj = document.form;
	var eff_dt_fr = ComReplaceStr(formObj.eff_dt_fr.value, '-');
	var eff_dt_to = ComReplaceStr(formObj.eff_dt_to.value, '-');
	if (eff_dt_fr != '' && eff_dt_to != '') {
		if (parseFloat(eff_dt_fr) > parseFloat(eff_dt_to)) {
			ComShowCodeMessage('JOO00078');
			formObj.eff_dt_to.value = "";
			return false;
		}

	}

	return true;

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 384;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Seq|Aply|CSR No.|Offset\nNo.|Carrier|Vendor\nCode|Effective Date|Currency|Balance Amount|CSR Description|Error Type|Interface Error Message|TP|FUNC|OFC|ISS_DT|SER_NO|ACCT_YRMON|RE|SLP_ISS_OFC_CD"
				+"|evid_tp_cd|apro_flg|apro_dt|cxl_flg|cxl_desc|stl_cmb_seq|ddct_flg|ddct_locl_amt|ddct_desc|rqst_locl_amt"
				+"|rqst_dt|csr_tp_cd|slp_iss_rgn_cd|slp_iss_inter_co_cd|rvs_csr_flg|rjct_csr_flg|org_slp_tp_cd"
				+"|org_slp_func_cd|org_slp_ofc_cd|org_slp_iss_dt|org_slp_ser_no|if_flg|rcv_err_flg";	
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, true, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtSeq         ,  35, daCenter, true, prefix+"seq"   );
			InitDataProperty(0, cnt++, dtCheckBox    ,  35, daCenter, true, prefix+"aply_chk"        , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        , 150, daCenter, true, prefix+"csr_no"          , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"csr_offst_no"    , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"jo_crr_cd"       , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,  60, daCenter, true, prefix+"vndr_seq"        , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  95, daCenter,false, prefix+"eff_dt"          , false, "", dfDateYmd  , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  60, daCenter, true,	prefix+"csr_locl_curr_cd", false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        , 100, daRight , true, prefix+"csr_locl_amt"    , false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData        , 120, daLeft  , true, prefix+"csr_desc"        , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        , 100, daLeft  , true, prefix+"if_rcv_msg"      , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        , 220, daLeft  , true, prefix+"rcv_err_rsn"     , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"slp_tp_cd"       , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"slp_func_cd"     , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"slp_ofc_cd"      , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"slp_iss_dt"      , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"slp_ser_no"      , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"acct_yrmon"      , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"re_divr_cd"      , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true, prefix+"slp_iss_ofc_cd"  , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"evid_tp_cd"       );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"apro_flg"         );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"apro_dt"          );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"cxl_flg"          );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"cxl_desc"         );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"stl_cmb_seq"      );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"ddct_flg"         );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"ddct_locl_amt"    );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"ddct_desc"        );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"rqst_locl_amt"    );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"rqst_dt"          );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"csr_tp_cd"        );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"slp_iss_rgn_cd"   );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"slp_iss_inter_co_cd");
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"rvs_csr_flg"      );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"rjct_csr_flg"     );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"org_slp_tp_cd"    );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"org_slp_func_cd"  );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"org_slp_ofc_cd"   );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"org_slp_iss_dt"   );
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"org_slp_ser_no"   );	
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"if_flg"           );	
			InitDataProperty(0, cnt++, dtHidden      ,  30, daLeft  ,false, prefix+"rcv_err_flg"      );	
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheetObj.ShowDebugMsg = false;
	
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0078GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;
	
		case IBSAVE: //저장
			var SaveStr = ComGetSaveString(sheetObj);
			
			if (SaveStr==""){
				ComShowCodeMessage("JOO00165"); //Please click the row that you want to reject.
				return;
			}
	
			if (!ComShowCodeConfirm("JOO00166")){ //Are you sure to reject it?
				return false;
			}
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0078GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: //조회
			var fr = formObj.eff_dt_fr.value;
			var to = formObj.eff_dt_to.value;
			var csrNo = formObj.csr_no.value;
			if (fr.length == 0 && to.length == 0 && csrNo.length < 19){
				ComShowCodeMessage("JOO00167");
				return false;
			}
			
			if ((fr.length == 0 && to.length != 0)||(fr.length != 0 && to.length == 0)){
				ComShowCodeMessage("JOO00168");
				return false;
			}
			break;
			
		case IBSAVE: //REject
			break;
	}
	
	return true;
}

/**
 * Sheet의 클릭 이벤트시 프로세스 처리
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
		if (i == Row){
			sheetObj.CellValue(i, prefix+"aply_chk") = "1";
		}else{
			sheetObj.CellValue(i, prefix+"aply_chk") = "";
		}
	}
}
/* 개발자 작업  끝 */