/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0049.js
 *@FileTitle : Settlement Status for Basic Allocation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 장강철
 *@LastVersion : 1.0
 * 2009.07.10 장강철
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
 * @class FNS_JOO_0049 : FNS_JOO_0049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0049() {
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

var comboObjects = new Array();
var comboCnt = 0;

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

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_New":
			doActionIBSheet(sheetObjects[0], document.form, IBRESET);
			break;

		case "btn_DownExcel":
			var paramObj = new Object();
			paramObj.cols = 10;
			var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", url);
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	initControl();

}
function sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
}

/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
	var formObject = document.form

	switch (comboObj.id) {
	case "rlane_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 160;
			ValidChar(2,1);//영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
		break;
	case "trd_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 160;
			ValidChar(2, 0);
			MaxLength = 3;
		}
		break;
	case "ofc_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2,2);//영문대문자만 입력가능
			MaxLength=3;
		}
		var comboItems = gOffList.split("|");
		addComboItem(comboObj, comboItems);
		comboObj.Index2 = 0;
        if (comboItems.length == 1){
        	comboObj.Enable = false;
        }else{
        	comboObj.Enable = true;
        }		
		break;
	}
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	var formObject = document.form;
	axon_event.addListenerForm('keydown', 'ComKeyEnter', formObject);
	axon_event.addListenerForm('keypress', 'fnObjKeyPress', formObject);

	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_fr_back");
	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_fr_next");
	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_to_back");
	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_to_next");

	axon_event.addListenerFormat('blur', 'fnDeactivate', formObject);
	axon_event.addListenerFormat('focus', 'fnActivate', formObject);
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

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
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|Seq.|Revenue\nMonth|Carrier\nCode|VVD|Trade|Lane|REVENUE|REVENUE|EXPENSE|EXPENSE|DIFF_R_YN|DIFF_E_YN";
			var HeadTitle2 = "|Seq.|Revenue\nMonth|Carrier\nCode|VVD|Trade|Lane|BSA|JOO|BSA|JOO|DIFF_R_YN|DIFF_E_YN";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//                     var calcAmount20 = "|UR_20| * |DifRFS|";

			//데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, true,	"Status");
			InitDataProperty(0, cnt++, dtSeq         ,  40, daCenter, true, "Seq"   );
//			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true, "acct_yrmon", false, "", dfDateYm   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true, "cost_yrmon", false, "", dfDateYm   , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  60, daCenter, true, "jo_crr_cd" , false, "", dfNone     , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  90, daCenter, true, "vvd"       , false, "", dfNone     , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, "trd_cd"    , false, "", dfNone     , 0, true, true);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, "rlane_cd"  , false, "", dfNone     , 0, true, true);
			InitDataProperty(0, cnt++, dtData        , 130, daRight , true, "bsa_r_amt" , false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData        , 130, daRight , true, "joo_r_amt" , false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData        , 130, daRight , true, "bsa_e_amt" , false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData        , 130, daRight , true, "joo_e_amt" , false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden      ,  80, daRight , true, "diff_r_yn" , false, "", dfNone     , 0, true, true);
			InitDataProperty(0, cnt++, dtHidden      ,  80, daRight , true, "diff_e_yn" , false, "", dfNone     , 0, true, true);
			//                     InitDataProperty(0, cnt++ , dtData,         85,     daRight,        true,       "coa_bsa_crr_perf_amt",        false,      "",                     dfNullInteger,0,            true,       true);
			//                     InitDataProperty(0, cnt++ , dtData,         85,     daRight,        true,       "joo_stl_locl_amt",        false,      "",                     dfNullInteger,0,            true,       true);
			//                     
			//                     InitDataProperty(0, cnt++ , dtData,         85,    daRight,        true,       "coa_lease_crr_perf_amt",        false,      "",                     dfNullInteger,0,            true,       true);
			//                     InitDataProperty(0, cnt++ , dtData,         85,    daRight,        true,       "joo_lease_stl_locl_amt",        false,      "",                     dfNullInteger,0,            true,       true);
			//                     InitDataProperty(0, cnt++ , dtData,         85,     daRight,        true,       "coa_add_crr_perf_amt",        false,      "",                     dfNullInteger,0,            true,       true);
			//                     InitDataProperty(0, cnt++ , dtData,         85,     daRight,        true,       "joo_add_stl_locl_amt",        false,      "",                     dfNullInteger,0,            true,       true);
			// 
			//                     InitDataProperty(0, cnt++ , dtHidden,      100,    daRight,        true,       "coa101_bgcolor_yn",        false,      "",                     dfNone,0,            true,       true);
			//                     InitDataProperty(0, cnt++ , dtHidden,       85,     daRight,        true,       "coa102_bgcolor_yn",        false,      "",                     dfNone,0,            true,       true);
			//                     InitDataProperty(0, cnt++ , dtHidden,       85,     daRight,        true,       "coa103_bgcolor_yn",        false,      "",                     dfNone,0,            true,       true);

		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBCLEAR: //Trade Combo List
		formObj.f_cmd.value = SEARCH01;
		var param = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0049GS.do", param);
		ComXml2ComboItem(sXml, formObj.trd_cd, "code", "code");
		break;

	case IBSEARCH_ASYNC02: //Lane Combo List
		//2010.03.24 권한필요없음 =>박효숙 차장
		//formObj.f_cmd.value = SEARCHLIST07;            
		formObj.f_cmd.value = SEARCH16;
		var code = formObj.trd_cd.Text;
		var param = FormQueryString(formObj) + "&super_cd2=" + code;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", param);
		ComXml2ComboItem(sXml, formObj.rlane_cd, "code", "code");
		break;

	case IBSEARCH: //조회 
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}
		formObj.f_cmd.value = SEARCHLIST01;
		var param = FormQueryString(formObj);
		sheetObj.DoSearch("FNS_JOO_0049GS.do", param);
		fnSetBgColorRedForSearchEnd(sheetObj);
		break;

	case IBRESET:
		formObj.reopt[0].checked = true;
		formObj.trd_cd.Code2 = '';
		formObj.rlane_cd.Code2 = '';
		fnBtnNew();
		formObj.acct_yrmon_fr.value = yyyyMM;
		formObj.acct_yrmon_to.value = yyyyMM;
		break;
	}
}

/**
 * 설명영역. <br>
 * <br><b>Example : </b>
 * <pre>
 *     Carrier Code(Object Name : trd_cd) OnChange 
 *                                이벤트 발생시 처리.  
 * </pre>
 * @param {인자Type} 콤보object 선택
 * @return void
 * @see #링크연결
 * @author jang kang cheol
 * @version 2009.07.01
 */
function trd_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	formObj.rlane_cd.RemoveAll();
}
function rlane_cd_OnFocus(comboObj) {
	var formObj = document.form;
	if (formObj.trd_cd.Code == "") {
		return;
	}
	if (comboObj.GetCount() == 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[sheetObjects.length - 1], formObj,
				IBSEARCH_ASYNC02);
		comboObj.Enable = true;
	}
}
/**
 * 년월 NAVI 처리 이벤트 
 * @param void
 * @return void
 */
function fnDocClick() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {

	case "btn_acct_yrmon_fr_back":
		if (formObj.acct_yrmon_fr.value != "") {
			formObj.acct_yrmon_fr.value = ComGetDateAdd(
					formObj.acct_yrmon_fr.value + "-01", "M", -1).substring(0,
					7);
		}
		fnBtnNew();

		break;
	case "btn_acct_yrmon_fr_next":
		if (formObj.acct_yrmon_fr.value != "") {
			formObj.acct_yrmon_fr.value = ComGetDateAdd(
					formObj.acct_yrmon_fr.value + "-01", "M", +1).substring(0,
					7);
		}
		fnBtnNew();

		break;
	case "btn_acct_yrmon_to_back":
		if (formObj.acct_yrmon_to.value != "") {
			formObj.acct_yrmon_to.value = ComGetDateAdd(
					formObj.acct_yrmon_to.value + "-01", "M", -1).substring(0,
					7);
		}
		fnBtnNew();

		break;
	case "btn_acct_yrmon_to_next":
		if (formObj.acct_yrmon_to.value != "") {
			formObj.acct_yrmon_to.value = ComGetDateAdd(
					formObj.acct_yrmon_to.value + "-01", "M", +1).substring(0,
					7);
		}
		fnBtnNew();

		break;
	}
}
/**
 * NEW 버튼 처리 
 * @param    void
 * @return   void
 */
function fnBtnNew() {
	var formObj = document.form;

	if (sheetObjects[0].RowCount > 0) {
		sheetObjects[0].RemoveAll();
	}
}
/**
 * <pre>
 *    form Element의 KeyPress Event 발생시 처리.
 *    
 * </pre>
 * @return
 */
function fnObjKeyPress() {
	var obj = event.srcElement;
	var formObj = document.form;
	switch (obj.name) {
	case 'acct_yrmon_fr':
		ComKeyOnlyNumber(obj);
		break;

	case 'acct_yrmon_to':
		ComKeyOnlyNumber(obj);
		break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 잃었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnDeactivate() {
	switch (event.srcElement.name) {
	case 'acct_yrmon_fr':
		ComAddSeparator(event.srcElement);
		break;
	case 'acct_yrmon_to':
		ComAddSeparator(event.srcElement);
		break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 얻었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnActivate() {
	switch (event.srcElement.name) {
	case 'acct_yrmon_fr':
		ComClearSeparator(event.srcElement);
		break;
	case 'acct_yrmon_to':
		ComClearSeparator(event.srcElement);
		break;

	}
	event.srcElement.select();
}
/**
 * 
 * <pre>
 *    조회후, Joo 값 Color
 * </pre>
 *
 * @param   
 * @return
 * @author jang kang cheol
 */
function fnSetBgColorRedForSearchEnd(sheetObj) {

	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {

		if (sheetObj.CellValue(i, "diff_r_yn") == "Y") {
			sheetObj.CellFontColor(i, "joo_r_amt") = sheetObj.RgbColor(255, 0, 0);
		}
		if (sheetObj.CellValue(i, "diff_e_yn") == "Y") {
			sheetObj.CellFontColor(i, "joo_e_amt") = sheetObj.RgbColor(255, 0, 0);
		}
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			//if (!ComChkValid(formObj)) return false;
			if (formObj.trd_cd.Code == "") {
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}
			//                       if( formObj.rlane_cd.Code == "") {
			//                           ComShowCodeMessage('JOO00010');   
			//                           formObj.rlane_cd.focus();
			//                           return false;
			//                       }   
			break;
		}
	}

	return true;
}
/* 개발자 작업  끝 */