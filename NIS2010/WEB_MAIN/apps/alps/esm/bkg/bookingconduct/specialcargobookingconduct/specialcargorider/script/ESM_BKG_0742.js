/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0742.js
 *@FileTitle : B/L Rider
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.16
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.16 이진서
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
 * @class esm_bkg_0742 : esm_bkg_0742 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0742() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var URL_ESM_BKG = 'ESM_BKG_0742GS.do';
var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();

/*	if (document.form.bkg_no.value == '') {
		alert('[경고] 필수값이 없습니다.\n 테스트 데이터[DUSZ4070019]로 대체합니다.');
		document.form.bkg_no.value = 'KORZB035223';
		document.form.bl_no.value = 'HAME18694106';
		document.form.vsl_cd.value = 'HJSZ0003E';
		document.form.vs_rgst_dt.value = '2009-06-25';
		document.form.ve_rgst_dt.value = '2009-06-26';
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}*/
}

function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); //- 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); //- 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
	axon_event.addListener('keydown', 'check_Enter', 'form');
	
	//ComSetObjValue(formObject.vs_rgst_dt, ComGetNowInfo());
	//ComSetObjValue(formObject.ve_rgst_dt, ComGetNowInfo());
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {

	case 1: //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 382;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			 MergeSheet = msPrevColumnMerge + msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "  |Type|Booking No.|B/L|LANE|VVD|POL|POD|Attach File|Container |Container |B/OFC|S/OFC|Register|Register|Register||";
			var HeadTitle2 = "  |Type|Booking No.|B/L|LANE|VVD|POL|POD|Attach File|Container|SEQ|B/OFC|S/OFC|By|OFC|Date||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode(true, true, false, true, false, false);
			InitHeadMode(false, true, true, true, false, false)
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, prefix + "idx", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 60, daLeft, true, prefix + "ridr_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 85, daLeft, true, prefix + "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 85, daLeft, true, prefix + "bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daLeft, true, prefix + "slan_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, true, prefix + "vsl_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix + "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix + "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 250, daLeft, true, prefix + "file_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix + "cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "cntr_cgo_seq", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "bkg_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, prefix + "ob_sls_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "rgst_usr_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "rgst_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "rgst_dt", false, "", dfUserFormat2, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "usr_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "file_sav_id");

			InitUserFormat2(0, prefix + "rgst_dt", "####-##-## ##:##", "-|:");
			//MultiSelection = false;

			CountPosition = 0;
		}
		break;
	}
}
/**
 * 조회한 다음 후처리 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var color1 = RgbColor(129, 0, 129);
		ColFontUnderline(prefix + "bkg_no") = true;
		DataLinkMouse(prefix + "bkg_no") = true;
		ColFontColor(prefix + "bkg_no") = color1;

		ColFontUnderline(prefix + "file_nm") = true;
		DataLinkMouse(prefix + "file_nm") = true;
		ColFontColor(prefix + "file_nm") = color1;

		ColFontUnderline(prefix + "rgst_usr_id") = true;
		DataLinkMouse(prefix + "rgst_usr_id") = true;
		ColFontColor(prefix + "rgst_usr_id") = color1;
	}
}

/**
 * 마우스 오버
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var m_row = sheetObj.MouseRow;
	var m_col = sheetObj.MouseCol;
	if (m_row > 0 && m_col == 13) {
		sheetObj.ToolTipText(m_row, m_col) = sheetObj.CellText(m_row, prefix + "usr_nm");
	}
}

/**
 * 마우스 다운 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
var current_Row = 0;
function sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var m_row = sheetObj.MouseRow;
	var m_col = sheetObj.MouseCol;

	try {
		//Booking NO. 3번째 컬럼에서만 팝업창 열림   
		if (m_row > 0 && m_col == 2) {
			if(sheetObj.CellValue(m_row, m_col) == '') return;
//			ComOpenWindow("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(m_row, m_col), "ESM_BKG_0079", "width=1024,height=768", false);
			comBkgCallPopBkgDetail(sheetObj.CellValue(m_row, m_col));
			//Attach File NO. 9번째 컬럼에서만 팝업창 열림   
		} else if (m_row > 0 && m_col == 8) {
			
			// 파일이 존재시 다운로드 받는다.
			var key_id = sheetObj.CellValue(m_row, prefix + "file_sav_id");
			
			var exist = fnSaveFileExist(key_id , sheetObj);
			// 서버에 파일존재유무확인 
			if(eval(exist)){
				hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id; 
			}else{
				ComShowMessage(ComGetMsg("BKG08127"));
			}
		}
	} catch (ex) {
		return false;
	}
}
/**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_id,sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	return output_text;
}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	/*******************************************************/
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_New":
			formObject.reset();
			break;

		case "btn_DownExcel":
			sheetObject1.Down2Excel(-1);
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			bkg_error_ComShowMessage(e);
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet1_");

	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
		ComSetObjValue(formObj.f_cmd, SEARCH);
		//2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet1_'));
		//3.조회후 결과처리
		sheetObj.LoadSearchXml(sXml);

		break;

	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction))


		break;

	case IBINSERT: // 입력

		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			//필수 입력 등 Validation 체크
			if (!ComChkValid(formObj))
				return false;

		if(ComGetObjValue(formObj.vsl_cd) == ''
			&&ComGetObjValue(formObj.pre_post_vsl_cd) == ''			
			&&ComGetObjValue(formObj.vs_rgst_dt) == ''
			&&ComGetObjValue(formObj.ve_rgst_dt) == ''
			&&ComGetObjValue(formObj.bl_no) == ''
			&&ComGetObjValue(formObj.bkg_no) == ''
			&&ComGetObjValue(formObj.cntr_no) != ''	
			){
				ComShowCodeMessage("BKG00845");
				formObj.vsl_cd.focus();
				return false;
			}	
		
			if(ComGetObjValue(formObj.vsl_cd) == ''
			&&ComGetObjValue(formObj.pre_post_vsl_cd) == ''				
			&&ComGetObjValue(formObj.vs_rgst_dt) == ''
			&&ComGetObjValue(formObj.ve_rgst_dt) == ''
			&&ComGetObjValue(formObj.bl_no) == ''
			&&ComGetObjValue(formObj.bkg_no) == ''							
			){
				ComShowCodeMessage("BKG00847");
				formObj.vsl_cd.focus();
				return false;
			}
			
		
			
			ComSetObjValue(formObj.s_rgst_dt, ComGetObjValue(formObj.vs_rgst_dt).split('-').join("")+"000000");
			ComSetObjValue(formObj.e_rgst_dt, ComGetObjValue(formObj.ve_rgst_dt).split('-').join("")+"235959");
		   
			if(ComGetObjValue(formObj.vs_rgst_dt) != ''
				&&ComGetObjValue(formObj.ve_rgst_dt) != ''
			){
				// . 조회기간 범위 체크 (30 Days)
			    if(ComGetDaysBetween(formObj.s_rgst_dt,formObj.e_rgst_dt) > 30){
					ComShowCodeMessage("BKG00605");
					return false;
			    }
			}

		} else if (sAction == IBSAVE) {

		}
	}
	return true;
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
 * ETD,ETB 기간 선택 달력 띄우기
 */
function callDatePop(val) {
	var cal = new ComCalendarFromTo();
	if (val == 'ETD') {
		cal.select(form.vs_rgst_dt, form.ve_rgst_dt, 'yyyy-MM-dd');
	}
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_activate() {
	//입력Validation 확인하기
	switch (event.srcElement.name) {

	case "vs_rgst_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "ve_rgst_dt":
		ComClearSeparator(event.srcElement);
		break;
	default:
		break;
	}
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate() {
	//if (event.srcElement.getAttribute("required") != null) return;

	//입력Validation 확인하기
	switch (event.srcElement.name) {

	case "vs_rgst_dt":
		ComAddSeparator(event.srcElement);
		break;
	case "ve_rgst_dt":
		ComAddSeparator(event.srcElement);
		break;
	default:
		break;
	}
}
/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
function obj_keypress() {

	switch (event.srcElement.dataformat) {
	case "int":
		//숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "engnum"://숫자+"영문대소"입력하기
  	  	ComKeyOnlyAlphabet('num'); 
		break;	  	
	default:
		//숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}
/*조회조건 에터키 이력시 조회*/
function check_Enter() {
	if (event.keyCode == 13)
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/* 개발자 작업  끝 */