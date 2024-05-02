/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0249.js
 *@FileTitle : VSL SKD Delete Information (Pop-Up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.14
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.06.15 유혁
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
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
 * @class VOP_VSK_0249 : VOP_VSK_0249 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0249() {
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

		case "btn_ok":
			var cause = formObj.vskd_cng_tp_cd.selectedIndex;

			switch (cause) {
			case 0:
				// 필수 체크하기 위해서는 아래 주석을 해제
				// if(formObj.tmp_vsl_slan_cd.value==''){
				// ComShowCodeMessage('VSK00027', 'Lane');
				// formObj.tmp_vsl_slan_cd.focus();
				// return false;
				// }

				formObj.aft_vsl_slan_cd.value = formObj.tmp_vsl_slan_cd.value;

				break;
			case 1:
				// 필수 체크하기 위해서는 아래 주석을 해제
				// if(formObj.tmp_vsl_cd.value==''){
				// ComShowCodeMessage('VSK00027', 'VVD');
				// formObj.tmp_vsl_cd.focus();
				// return false;
				// }else if(formObj.tmp_skd_voy_no.value==''){
				// ComShowCodeMessage('VSK00027', 'VVD');
				// formObj.tmp_skd_voy_no.focus();
				// return false;
				// }else if(formObj.tmp_skd_dir_cd.value==''){
				// ComShowCodeMessage('VSK00027', 'VVD');
				// formObj.tmp_skd_dir_cd.focus();
				// return false;
				// }

				formObj.aft_vsl_cd.value = formObj.tmp_vsl_cd.value;
				formObj.aft_skd_voy_no.value = formObj.tmp_skd_voy_no.value;
				formObj.aft_skd_dir_cd.value = formObj.tmp_skd_dir_cd.value;

				break;
			case 2:
				// 필수 체크하기 위해서는 아래 주석을 해제
				// if(formObj.tmp_vps_port_cd.value==''){
				// ComShowCodeMessage('VSK00027', 'Port');
				// formObj.tmp_vps_port_cd.focus();
				// return false;
				// }

				formObj.aft_vps_port_cd.value = formObj.tmp_vps_port_cd.value;

				break;

			}

			formObj.diff_rmk.value = formObj.vskd_cng_tp_cd.options(cause).text + "/" + formObj.rmk.value;
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;

		case "btn_close":
			window.close();
			break;

		case "btns_lane_search":
			if (!formObj.tmp_vsl_slan_cd.disabled) {
				openLandCdHelp(formObj, sheetObject1);
			}
			break;

		case "btns_vvd_search":
			if (!formObj.tmp_vsl_cd.disabled) {
				if (formObj.tmp_vsl_cd.value == '') {
					openVslCdHelp(formObj, sheetObject1);
				} else if (formObj.tmp_skd_voy_no.value == '') {
					openVoyNoHelp(formObj, sheetObject1);
				}
			}
			break;

		case "btns_port_search":
			if (!formObj.tmp_vps_port_cd.disabled) {
				openPortCdHelp(formObj, sheetObject1);
			}
			break;

		default:

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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	obj_able(0);
	initControl();
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);

	if (formObj.tmp_vsl_slan_cd.value != "") {
		formObj.tmp_vsl_slan_cd.readOnly = true;
	}

	formObj.rmk.focus();

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 150;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable],
			// [UserResize], [RowMove],[Head3D])
			InitHeadMode(false, false, false, false, false, false);

			var HeadTitle = "||Seq|Lane|VVD|||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox, 	30, 	daCenter, 	false,	"Sel");
			InitDataProperty(0, cnt++ , dtSeq,				30,	daCenter,	false,	"Seq",			false,	"",		dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"vsl_slan_cd",	false,	"",		dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"bkg_vvd",		false,	"",		dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			30,	daCenter,	false,	"hisflag",		false,	"",		dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			30,	daCenter,	false,	"turn_skd_voy_no",		false,	"",		dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			30,	daCenter,	false,	"turn_skd_dir_cd",		false,	"",		dfNone,		0,			true,		true);

			CountPosition = 0;

			ColHidden(1) = true;
			ColHidden(5) = true;
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
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1") {
				sheetObj.LoadSearchXml(formObj.xml.value);
			}
		break;

	case SEARCH01: // lane 조회
		formObj.f_cmd.value = SEARCH01;
		ComOpenWait(true);
		var sParam = FormQueryString(formObj) + "&vsl_slan_cd=" + formObj.tmp_vsl_slan_cd.value;
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0249GS.do", sParam);
		ComOpenWait(false);
		var nm = ComGetEtcData(rXml, "vsl_slan_nm");
		if (nm == null) {
			ComShowCodeMessage('VSK00021', formObj.tmp_vsl_slan_cd.value);
			formObj.tmp_vsl_slan_cd.value = '';
			formObj.tmp_vsl_slan_cd.focus();
		}
		break;

	case SEARCH02:
		if (formObj.tmp_vsl_cd.value != ''
				&& formObj.tmp_skd_voy_no.value != ''
				&& formObj.tmp_skd_dir_cd.value != '') {

			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			var sParam = FormQueryString(formObj) + "&vsl_cd="
					+ formObj.tmp_vsl_cd.value + "&skd_voy_no="
					+ formObj.tmp_skd_voy_no.value + "&skd_dir_cd="
					+ formObj.tmp_skd_dir_cd.value;
			var rXml = sheetObj.GetSearchXml("VOP_VSK_0249GS.do", sParam);
			ComOpenWait(false);
			var vvd = ComGetEtcData(rXml, "vvd");
			if (vvd == null) {
				ComShowCodeMessage('VSK00028', formObj.tmp_vsl_cd.value
						+ formObj.tmp_skd_voy_no.value
						+ formObj.tmp_skd_dir_cd.value);
				formObj.tmp_vsl_cd.value = '';
				formObj.tmp_skd_voy_no.value = '';
				formObj.tmp_skd_dir_cd.value = '';
				formObj.tmp_vsl_cd.focus();
			}
			break;
		}

		break;

	case SEARCH03:
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH03;
		var sParam = FormQueryString(formObj) + "&vps_loc_cd=" + formObj.tmp_vps_port_cd.value;
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0249GS.do", sParam);
		ComOpenWait(false);
		var nm = ComGetEtcData(rXml, "loc_nm");
		if (nm == null) {
			ComShowCodeMessage('VSK00029', formObj.tmp_vps_port_cd.value);
			formObj.tmp_vps_port_cd.value = '';
			formObj.tmp_vps_port_cd.focus();
		}
		break;

	case IBSAVE: // 저장
		formObj.f_cmd.value = MULTI;
		for ( var i = 0; i < sheetObj.RowCount; i++) {
			sheetObj.CellValue(i + 1, 1) = 1;
		}
		var sParam = FormQueryString(formObj);

		if (formObj.tp.value == "1") {
			// VOP_VSK_0010 화면에서 호출한 경우
			// VOP_VSK_0010 화면으로 사유만 전달한다.

			var returnParam = "&vskd_tp_cd=" + formObj.vskd_tp_cd.value
					+ "&diff_rmk=" + formObj.diff_rmk.value
					+ "&vskd_cng_tp_cd=" + formObj.vskd_cng_tp_cd.value
					+ "&rmk=" + formObj.rmk.value + "&aft_vsl_slan_cd="
					+ formObj.aft_vsl_slan_cd.value + "&aft_vsl_cd="
					+ formObj.aft_vsl_cd.value + "&aft_skd_voy_no="
					+ formObj.aft_skd_voy_no.value + "&aft_skd_dir_cd="
					+ formObj.aft_skd_dir_cd.value + "&aft_vps_port_cd="
					+ formObj.aft_vps_port_cd.value

			window.returnValue = returnParam;
			window.close();
		} else {

			var cause = formObj.vskd_cng_tp_cd.selectedIndex;

			// VOP_VSK_0018, VOP_VSK_0059 화면에서 호출한 경우
			ComOpenWait(true);
			var rXml = sheetObj.GetSaveXml("VOP_VSK_0249GS.do", sParam + "&" + ComGetSaveString(sheetObj));
			sheetObj.LoadSaveXml(rXml);
			ComOpenWait(false);
			if (!VskGetErrorXml(rXml)) {
				window.close();
			}
		}

		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change', 'obj_change', formObj);
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
	axon_event.addListener('keypress', 'eng_keypress', 'form'); // - 영문자 입력하기
	axon_event.addListener('keypress', 'num_keypress', 'form'); // - 숫자 입력하기
	axon_event.addListener('keypress', 'enter_keypress', 'form'); // - Enter 키
																	// 처리
	axon_event.addListener('keyup', "VskKeyFocus", 'form'); // - 자동포커스 처리
}

function obj_focus(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문 입력 처리한다. <br>
 */
function eng_keypress() {
	var name = event.srcElement.name;
	switch (name) {
	case "tmp_vsl_slan_cd":
	case "tmp_vsl_cd":
	case "tmp_vps_port_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "tmp_skd_dir_cd":
		ComKeyOnlyAlphabet('upper');
		break;
	default:
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력 처리한다. <br>
 */
function num_keypress() {
	var name = event.srcElement.name;
	switch (name) {
	case "tmp_skd_voy_no":
		ComKeyOnlyNumber(event.srcElement);
		break;
	default:
	}
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress() {
	VskKeyEnter();
}

function obj_change() {
	var formObj = document.form;
	try {
		var obj = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "vskd_cng_tp_cd":
			obj_able(obj.selectedIndex);
			break;
		case "tmp_vsl_slan_cd":
			if (obj.value != '') {
				doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
			}
			break;
		case "tmp_vsl_cd":
		case "tmp_skd_voy_no":
		case "tmp_skd_dir_cd":
			if (formObj.tmp_vsl_cd.value != ''
					&& formObj.tmp_skd_voy_no.value != ''
					&& formObj.tmp_skd_dir_cd.value != '') {
				doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
			}
			break;
		case "tmp_vps_port_cd":
			if (obj.value != '') {
				doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function obj_able(index) {
	var formObj = document.form;
	with (formObj) {
		tmp_vsl_slan_cd.disabled = true;
		tmp_vsl_cd.disabled = true;
		tmp_skd_voy_no.disabled = true;
		tmp_skd_dir_cd.disabled = true;
		tmp_vps_port_cd.disabled = true;

		aft_vsl_slan_cd.value = "";
		aft_vsl_cd.value = "";
		aft_skd_voy_no.value = "";
		aft_skd_dir_cd.value = "";
		aft_vps_port_cd.value = "";
		aft_clpt_ind_seq.value = "";
		aft_yd_cd.value = "";
		aft_vps_eta_dt.value = "";
		aft_vps_etb_dt.value = "";
		aft_vps_etd_dt.value = "";

		switch (index) {
		case 0:
			tmp_vsl_slan_cd.disabled = false;
			tmp_vsl_slan_cd.focus();
			break;
		case 1:
			tmp_vsl_cd.disabled = false;
			tmp_skd_voy_no.disabled = false;
			tmp_skd_dir_cd.disabled = false;
			tmp_vsl_cd.focus();
			break;
		case 2:
			tmp_vps_port_cd.disabled = false;
			tmp_vps_port_cd.focus();
			break;

		default:
		}
	}
}

/**
 * Lane Code Help 화면을 오픈한다
 */
function openLandCdHelp(formObj, sheetObj) {
	var targetObjList = "sheet1_vsl_slan_cd:tmp_vsl_slan_cd";
	var v_display = "0,0";
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 420, 450, targetObjList,
			v_display, true);
}

/**
 * Vessel Code Help 화면을 오픈한다.
 */
function openVslCdHelp(formObj, sheetObj) {
	var sUrl = "/hanjin/VOP_VSK_0219.do";
	var rVal = ComOpenPopupWithTarget(sUrl, 458, 450, "", "0,0", true);
	if (rVal) {
		formObj.tmp_vsl_cd.value = rVal;
	}
}

/**
 * Voyage No Help 화면을 오픈한다.
 */
function openVoyNoHelp(formObj, sheetObj) {
	var sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd=" + formObj.tmp_vsl_cd.value;
	ComOpenPopupWithTarget(sUrl, 340, 410, "skd_voy_no:tmp_skd_voy_no|skd_dir_cd:tmp_skd_dir_cd", "0,0", true);
}

/**
 * Port Code Help 화면을 오픈한다.
 */
function openPortCdHelp(formObj, sheetObj) {
	var sUrl = "/hanjin/VOP_VSK_0043.do";
	var rVal = ComOpenPopupWithTarget(sUrl, 422, 464, "", "0,0", true);
	if (rVal) {
		formObj.tmp_vps_port_cd.value = rVal;
	}
}
