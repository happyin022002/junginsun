/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0111.js
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.03
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.08.03 강동윤
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
 * @class ESM_BKG_0111_01 : ESM_BKG_0111_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0111_01() {
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

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var tabItem = 0;
var seqSheet1 = 0;
var seqSheet2 = 0;

var loadPageCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

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
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	//MultiCombo초기화 
	for ( var k = 1; k < comboObjects.length - 1; k++) {
		initCombo(comboObjects[k]);
	}

	document.form.vvd.focus();
	initControl();
	
	loadPageCnt = 1;

	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd)) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		document.getElementById('tab_tot').innerHTML = document.form.master_tot.value;
	}
	
}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	// comboObj.LineColor = "#ffffff";
	// comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
	comboObj.DropHeight = 150;
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
     var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     
     //alert("keyValue : " + keyValue);
	 
	 
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if ( keyValue != 9 && keyValue !=16 && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드 입력할때

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key 처리
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
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
	case "engupnum":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		//숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
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
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge+msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(47, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Seq|B/L No.|Booking No.|S/C|Contract Party\nName|Filer|Filer|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
			var HeadTitle2 = "Seq|B/L No.|Booking No.|S/C|Contract Party\nName|US|CA|NM|AD|CT|CN|ZIP|NM|AD|CT|ST|CN|ZIP|NM|AD|CT|ST|CN|ZIP|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|HS|NCM|Container|S|Package|Weight|Measure";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "sc_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "ctrt_cust_nm", false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "usa_cstms_file_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cnd_cstms_file_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_nm_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_addr_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_cty_nm_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cstms_decl_cnt_cd_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_zip_id_s", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_nm_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_addr_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_cty_nm_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_ste_cd_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cstms_decl_cnt_cd_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_zip_id_c", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_nm_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_addr_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_cty_nm_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_ste_cd_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cstms_decl_cnt_cd_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "cust_zip_id_n", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "pck_qty_da", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "pck_qty_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "act_wgt", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "act_wet_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "meas_qty_da", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "meas_qty_chk", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "pck_qty_cm", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "cntr_mf_wgt", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "meas_qty_cm", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_mf_gds_desc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_mf_mk_desc", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_mf_hts", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_mf_hs", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_mf_ncm", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_seal_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "pck_qty_co", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "cntr_wgt", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "meas_qty_co", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "good_idx");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "error_idx");

			CountPosition = 0;
		}
		break;

	case 2: //t2sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(42, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Seq|H/B No.|Manifest File No.|Master B/L No.|S/C|Contract Party\nName|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
			var HeadTitle2 = "Seq|H/B No.|Manifest File No.|Master B/L No.|S/C|Contract Party\nName|NM|AD|CT|CN|NM|AD|CT|ST|CN|NM|AD|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|NCM|AMS|Container|S|Package|Weight|Measure";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bhl_no");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "b_usa_cstms_file_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "b_bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "sc_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, true, "ctrt_cust_nm", false, "", dfNone, 0, false, true);			
			// InitDataProperty(0, cnt++ , dtData, 90, daCenter, true, "AMSRefNo2", false, "", dfNone, 0, false, true);

			// InitDataProperty(0, cnt++ , dtData, 50, daCenter, true, "b_hbl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_nm_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_addr_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_ct_s", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_cn_s", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_nm_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_addr_c", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_ct_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_st_c", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_cn_c", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_nm_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, true, "b_cust_addr_n", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "b_pck_qty_da", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "b_pck_qty_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "b_hbl_wgt_da", false, "", dfNullFloat, 3, false, true);

			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "b_hbl_wgt_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "b_meas_qty_da", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "b_meas_qty_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, false, "b_pck_qty_cm", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "b_cntr_wgt_cm", false, "", dfNullFloat, 3, false, true);

			InitDataProperty(0, cnt++, dtData, 55, daRight, false, "b_meas_qty_cm", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "b_cntr_mf_gds_desc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "b_cntr_mf_mk_desc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "b_cntr_mf_hts", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "b_cntr_mf_ncm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "b_cntr_mf_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "b_cntr_no", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "b_cntr_seal_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, false, "b_pck_qty_co", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "b_cntr_wgt_co", false, "", dfNullFloat, 3, false, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, false, "b_meas_qty_co", false, "", dfNullFloat, 3, false, true);

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "good_idx");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "error_idx");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no");

			CountPosition = 0;
		}
		break;

	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if (tabItem == 0) {

				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			} else {

				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			}
			break;

		case "btn_New":
			ComResetAll();

			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.vvd,"");
			ComClearManyObjects(document.form.pol_cd,"");
			ComClearManyObjects(document.form.pod_cd,"");
			
			document.form.tab_item.value = tabItem;
			break;

		case "btn_SaveExcel":
			if (tabItem == 0) {

				sheetObject1.SpeedDown2Excel(-1);
			} else {

				sheetObject2.SpeedDown2Excel(-1);
			}
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		sheetObj.FocusAfterProcess = false;
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0111GS.do", FormQueryString(formObj));

		searchEnd(sheetObj);
		sheetObj.SelectCell(0, 0, false);

		ComOpenWait(false);
		break;

	case COMMAND01: //CODE 조회						
		formObj.f_cmd.value = SEARCH01;
		// sheetObj.DoSearch("ESM_BKG_0111GS.do",FormQueryString(formObj));
		var searchXml = sheetObj.GetSearchXml("ESM_BKG_0111GS.do", FormQueryString(formObj));

		var sXml = searchXml.split("|$$|");

		// US Filer
		ComBkgXml2ComboItem(sXml[0], formObj.usa_cstms_file_cd, "val", "name");
		// CA Filer
		ComBkgXml2ComboItem(sXml[0], formObj.cnd_cstms_file_cd, "val", "name");

		formObj.usa_cstms_file_cd.Index = 1;
		formObj.cnd_cstms_file_cd.Index = 1;
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	if (formObj.vvd.value == '' || formObj.vvd.value.length != 9) {

		ComShowCodeMessage("BKG00007");// VVD is not available !
		formObj.vvd.focus();
		return false;
	} else {

		formObj.vsl_cd.value = formObj.vvd.value.substring(0, 4);
		formObj.skd_voy_no.value = formObj.vvd.value.substring(4, 8);
		formObj.skd_dir_cd.value = formObj.vvd.value.substring(8);

		// alert( formObj.vsl_cd.value + "_" + formObj.skd_voy_no.value + "_" + formObj.skd_dir_cd.value);
	}

	if (formObj.pol_cd.value == '' && formObj.pod_cd.value == '') {

		ComShowCodeMessage("BKG00137");// POL/POD is not available
		formObj.pol_cd.focus();
		return false;
	}

	if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value == '') {

		ComShowCodeMessage("BKG00458");// invalid customer code
		formObj.cust_cnt_cd.focus();
		return false;
	}

	if (formObj.cust_cnt_cd.value == '' && formObj.cust_seq.value != '') {

		ComShowCodeMessage("BKG00458");// invalid customer code
		formObj.cust_seq.focus();
		return false;
	}

	if (formObj.pol_nod_cd.value != '') {

		formObj.pol_yd_cd.value = formObj.pol_cd.value + formObj.pol_nod_cd.value;
	} else {

		formObj.pol_yd_cd.value = "";
	}

	if (formObj.pod_nod_cd.value != '') {

		formObj.pod_yd_cd.value = formObj.pod_cd.value + formObj.pod_nod_cd.value;
	} else {

		formObj.pod_yd_cd.value = "";
	}

	return true;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {

			var cnt = 0;
			InsertTab(cnt++, "Master B/L", -1);
			InsertTab(cnt++, "House B/L", -1);

		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	tabItem = nItem;

	document.form.tab_item.value = tabItem;

	if (tabItem == 0) {

		document.getElementById('tab_tot').innerHTML = document.form.master_tot.value;
		
	} else {
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		//document.getElementById('tab_tot').innerHTML = document.form.houser_tot.value;
		
	}
	
	
	
	
	/*
	if (tabItem == 0){
		
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
	}else{
	
	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}
	
	
		if(nItem==0 &&tabLoad[0]!=1)
			frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
		else if(nItem==1 &&tabLoad[1]!=1)
			frameLayer1.document.location = 'tab3.jsp?frame=Tab2';
	 */

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
	
    if(loadPageCnt == 0) return;
    
    document.getElementById("btn_Retrieve").fireEvent("onclick");
    

}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function searchEnd(sheetObj)// 변수명 임의 생성
{
	with (sheetObj) {
		var redColor = RgbColor(255, 0, 0);
		var blueColor = RgbColor(0, 0, 255);

		for ( var i = 2; i <= LastRow; i++) {

			if (tabItem == 0) {
				CellFontColor(i, "bkg_no") = blueColor;
				CellFontUnderline(i, "bkg_no") = true;
				CellFontColor(i, "bl_no") = blueColor;
				CellFontUnderline(i, "bl_no") = true;

				if ("E" == CellValue(i, "pck_qty_chk")) {
					CellFontColor(i, "pck_qty_chk") = redColor;
				}

				if ("E" == CellValue(i, "act_wet_chk")) {
					CellFontColor(i, "act_wet_chk") = redColor;
				}

				if ("E" == CellValue(i, "meas_qty_chk")) {
					CellFontColor(i, "meas_qty_chk") = redColor;
				}
				/*
				if ("N" == CellValue(i, "cntr_mf_mk_desc")){
					CellFontColor(i, "cntr_mf_mk_desc") = redColor;
				}
				 */
				/*
				 * if ("N" == CellValue(i, "cntr_mf_hts")){ CellFontColor(i, "cntr_mf_hts") = redColor; } if ("N" == CellValue(i,
				 * "cntr_mf_hs")){ CellFontColor(i, "cntr_mf_hs") = redColor; } if ("N" == CellValue(i, "cntr_mf_ncm")){
				 * CellFontColor(i, "cntr_mf_ncm") = redColor; }
				 */
				if ("N" == CellValue(i, "cntr_mf_no")) {
					CellFontColor(i, "cntr_mf_no") = redColor;
				}
				/*
				if ("N" == CellValue(i, "cntr_mf_gds_desc")){
					CellFontColor(i, "cntr_mf_gds_desc") = redColor;
				}*/

				if ("E" == CellValue(i, "cntr_seal_seq")) {
					CellFontColor(i, "cntr_seal_seq") = redColor;
				}

				if ("E" == CellValue(i, "cust_nm_s")) {
					CellFontColor(i, "cust_nm_s") = redColor;
				}

				if ("E" == CellValue(i, "cust_addr_s")) {
					CellFontColor(i, "cust_addr_s") = redColor;
				}

				if ("E" == CellValue(i, "cust_cty_nm_s")) {
					CellFontColor(i, "cust_cty_nm_s") = redColor;
				}

				if ("E" == CellValue(i, "cstms_decl_cnt_cd_s")) {
					CellFontColor(i, "cstms_decl_cnt_cd_s") = redColor;
				}

				if ("E" == CellValue(i, "cust_zip_id_s")) {
					CellFontColor(i, "cust_zip_id_s") = redColor;
				}

				if ("E" == CellValue(i, "cust_nm_c")) {
					CellFontColor(i, "cust_nm_c") = redColor;
				}

				if ("E" == CellValue(i, "cust_addr_c")) {
					CellFontColor(i, "cust_addr_c") = redColor;
				}

				if ("E" == CellValue(i, "cust_cty_nm_c")) {
					CellFontColor(i, "cust_cty_nm_c") = redColor;
				}

				if ("E" == CellValue(i, "cust_ste_cd_c")) {
					CellFontColor(i, "cust_ste_cd_c") = redColor;
				}

				if ("E" == CellValue(i, "cstms_decl_cnt_cd_c")) {
					CellFontColor(i, "cstms_decl_cnt_cd_c") = redColor;
				}

				if ("E" == CellValue(i, "cust_zip_id_c")) {
					CellFontColor(i, "cust_zip_id_c") = redColor;
				}

				if ("E" == CellValue(i, "cust_nm_n")) {
					CellFontColor(i, "cust_nm_n") = redColor;
				}

				if ("E" == CellValue(i, "cust_addr_n")) {
					CellFontColor(i, "cust_addr_n") = redColor;
				}

				if ("E" == CellValue(i, "cust_cty_nm_n")) {
					CellFontColor(i, "cust_cty_nm_n") = redColor;
				}

				if ("E" == CellValue(i, "cust_ste_cd_n")) {
					CellFontColor(i, "cust_ste_cd_n") = redColor;
				}

				if ("E" == CellValue(i, "cstms_decl_cnt_cd_n")) {
					CellFontColor(i, "cstms_decl_cnt_cd_n") = redColor;
				}

				if ("E" == CellValue(i, "cust_zip_id_n")) {
					CellFontColor(i, "cust_zip_id_n") = redColor;
				}

				if ("E" == CellValue(i, "pck_qty_chk")) {
					CellFontColor(i, "pck_qty_chk") = redColor;
				}

				if ("E" == CellValue(i, "act_wet_chk")) {
					CellFontColor(i, "act_wet_chk") = redColor;
				}

				if ("E" == CellValue(i, "meas_qty_chk")) {
					CellFontColor(i, "meas_qty_chk") = redColor;
				}
			} else {

				CellFontColor(i, "b_bl_no") = blueColor;
				CellFontUnderline(i, "b_bl_no") = true;

				if ("E" == CellValue(i, "b_pck_qty_chk")) {
					CellFontColor(i, "b_pck_qty_chk") = redColor;
				}

				if ("E" == CellValue(i, "b_hbl_wgt_chk")) {
					CellFontColor(i, "b_hbl_wgt_chk") = redColor;
				}

				if ("E" == CellValue(i, "b_meas_qty_chk")) {
					CellFontColor(i, "b_meas_qty_chk") = redColor;
				}
				/*
				if ("N" == CellValue(i, "b_cntr_mf_mk_desc")){
					CellFontColor(i, "b_cntr_mf_mk_desc") = redColor;
				}*/
				/*
				 * if ("N" == CellValue(i, "b_cntr_mf_hts")){ CellFontColor(i, "b_cntr_mf_hts") = redColor; } if ("N" ==
				 * CellValue(i, "b_cntr_mf_ncm")){ CellFontColor(i, "b_cntr_mf_ncm") = redColor; }
				 */
				/*
				 * if ("N" == CellValue(i, "b_cntr_mf_no")){ CellFontColor(i, "b_cntr_mf_no") = redColor; }
				 */
				/*
				 * if ("N" == CellValue(i, "b_cntr_mf_gds_desc")){ CellFontColor(i, "b_cntr_mf_gds_desc") = redColor; }
				 */
				if ("E" == CellValue(i, "b_cntr_seal_seq")) {
					CellFontColor(i, "b_cntr_seal_seq") = redColor;
				}

				if ("0" == CellValue(i, "b_pck_qty_cm")) {
					CellFontColor(i, "b_pck_qty_cm") = redColor;
				}

				if ("0" == CellValue(i, "b_cntr_wgt_cm")) {
					CellFontColor(i, "b_cntr_wgt_cm") = redColor;
				}

				if ("E" == CellValue(i, "b_cust_nm_s")) {
					CellFontColor(i, "b_cust_nm_s") = redColor;
				}

				if ("E" == CellValue(i, "b_cust_addr_s")) {
					CellFontColor(i, "b_cust_addr_s") = redColor;
				}

				if ("E" == CellValue(i, "b_cust_nm_c")) {
					CellFontColor(i, "b_cust_nm_c") = redColor;
				}

				if ("E" == CellValue(i, "b_cust_addr_c")) {
					CellFontColor(i, "b_cust_addr_c") = redColor;
				}

				if ("E" == CellValue(i, "b_cust_nm_n")) {
					CellFontColor(i, "b_cust_nm_n") = redColor;
				}

				if ("E" == CellValue(i, "b_cust_addr_n")) {
					CellFontColor(i, "b_cust_addr_n") = redColor;
				}

				if ("E" == CellValue(i, "b_pck_qty_chk")) {
					CellFontColor(i, "b_pck_qty_chk") = redColor;
				}

				if ("E" == CellValue(i, "b_hbl_wgt_chk")) {
					CellFontColor(i, "b_hbl_wgt_chk") = redColor;
				}

				if ("E" == CellValue(i, "b_meas_qty_chk")) {
					CellFontColor(i, "b_meas_qty_chk") = redColor;
				}
			}
		}

		document.form.master_tot.value = "Total : " + CellValue(LastRow, "Seq") + " (Good : " + CellValue(LastRow, "good_idx")
				+ " , Error : " + CellValue(LastRow, "error_idx") + ")";
		document.getElementById('tab_tot').innerHTML = document.form.master_tot.value;

		// sheetObj.CountFormat = "[ 1 / " + seqSheet1 + " ]";
	}
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		document.form.houser_tot.value = "Total : " + CellValue(LastRow, "Seq") + " (Good : " + CellValue(LastRow, "good_idx")
				+ " , Error : " + CellValue(LastRow, "error_idx") + ")";
		document.getElementById('tab_tot').innerHTML = document.form.houser_tot.value;

		var redColor = RgbColor(255, 0, 0);
		var blueColor = RgbColor(0, 0, 255);

		for ( var i = 2; i <= LastRow; i++) {
			CellFontColor(i, "b_bl_no") = blueColor;
			CellFontUnderline(i, "b_bl_no") = true;

			if ("N" == CellValue(i, "b_pck_qty_chk")) {
				CellFontColor(i, "b_pck_qty_chk") = redColor;
			}

			if ("N" == CellValue(i, "b_hbl_wgt_chk")) {
				CellFontColor(i, "b_hbl_wgt_chk") = redColor;
			}

			if ("N" == CellValue(i, "b_meas_qty_chk")) {
				CellFontColor(i, "b_meas_qty_chk") = redColor;
			}
			/*
			if ("N" == CellValue(i, "b_cntr_mf_mk_desc")){
				CellFontColor(i, "b_cntr_mf_mk_desc") = redColor;
			}*/
			/*
			 * if ("N" == CellValue(i, "b_cntr_mf_gds_desc")){ CellFontColor(i, "b_cntr_mf_gds_desc") = redColor; }
			 */

			if ("E" == CellValue(i, "b_cntr_seal_seq")) {
				CellFontColor(i, "b_cntr_seal_seq") = redColor;
			}

			if ("0" == CellValue(i, "b_pck_qty_cm")) {
				CellFontColor(i, "b_pck_qty_cm") = redColor;
			}

			if ("0" == CellValue(i, "b_cntr_wgt_cm")) {
				CellFontColor(i, "b_cntr_wgt_cm") = redColor;
			}

			if ("E" == CellValue(i, "b_cust_nm_s")) {
				CellFontColor(i, "b_cust_nm_s") = redColor;
			}

			if ("E" == CellValue(i, "b_cust_addr_s")) {
				CellFontColor(i, "b_cust_addr_s") = redColor;
			}

			if ("E" == CellValue(i, "b_cust_nm_c")) {
				CellFontColor(i, "b_cust_nm_c") = redColor;
			}

			if ("E" == CellValue(i, "b_cust_addr_c")) {
				CellFontColor(i, "b_cust_addr_c") = redColor;
			}

			if ("E" == CellValue(i, "b_cust_nm_n")) {
				CellFontColor(i, "b_cust_nm_n") = redColor;
			}

			if ("E" == CellValue(i, "b_cust_addr_n")) {
				CellFontColor(i, "b_cust_addr_n") = redColor;
			}

			if ("E" == CellValue(i, "b_pck_qty_chk")) {
				CellFontColor(i, "b_pck_qty_chk") = redColor;
			}

			if ("E" == CellValue(i, "b_hbl_wgt_chk")) {
				CellFontColor(i, "b_hbl_wgt_chk") = redColor;
			}

			if ("E" == CellValue(i, "b_meas_qty_chk")) {
				CellFontColor(i, "b_meas_qty_chk") = redColor;
			}
			/*
			if ("N" == CellValue(i, "b_cntr_mf_hts")){
				CellFontColor(i, "b_cntr_mf_hts") = redColor;
			}
			if ("N" == CellValue(i, "b_cntr_mf_ncm")){
				CellFontColor(i, "b_cntr_mf_ncm") = redColor;
			}*/

			/*
			 * if ("N" == CellValue(i, "b_cntr_mf_no")){ CellFontColor(i, "b_cntr_mf_no") = redColor; }
			 */
		}

		//sheetObj.CountFormat = "[ 1 / " + seqSheet2 + " ]";
	}
}

/*
 *  Search Option or Item Option Modify
 * */
function t1sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {

	if (colIdx == sheetObj.SaveNameCol("bkg_no")) {
		//					var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
		// ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
		// 모달로 변경 2010.04.10
		comBkgCallBkgDetail(sheetObj.CellValue(rowIdx, "bkg_no"));

	} else if (colIdx == sheetObj.SaveNameCol("bl_no")) {
		//					var param= "?bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
		var param = "?bkg_no=" + sheetObj.CellValue(rowIdx, "bkg_no");
		// ComOpenWindowCenter2("/hanjin/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
		// ComOpenWindow("/hanjin/ESM_BKG_0927.do" + param, "PopupEsmBkg0927", "width=1024, height=740, scrollbars=no", true);
		ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do" + param, "BL Preview", 1024, 740, true, "scrollbars=yes,resizable=yes");
		// ComOpenWindow("/hanjin/ESM_BKG_0109.do"+param, "BL Preview", "width=1024,height=740,scrollbars=yes,resizable=yes");
	}
}

/*
 *  Search Option or Item Option Modify
 * */
function t2sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {

	if (colIdx == sheetObj.SaveNameCol("b_bkg_no")) {
		//					var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
		// ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
		// 모달로 변경 2010.04.10
		comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, "bkg_no"));

	} else if (colIdx == sheetObj.SaveNameCol("b_bl_no")) {
		var param = "?pgmNo=ESM_BKG_0079&bkg_no=" + sheetObj.CellValue(rowIdx, "bkg_no");
		// ComOpenWindowCenter2("/hanjin/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
		// ComOpenWindow("/hanjin/ESM_BKG_0927.do" + param, "PopupEsmBkg0927", "width=916, height=730, scrollbars=no", false);
		// ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
		// 모달로 변경 2010.04.10
		comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, "bkg_no"));
	}
}
/*
// grid click Event 처리
function t1sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.CountFormat = "[ " + sheetObj.CellValue(Row, 0) + " / " + seqSheet1 + " ]";
}

// grid click Event 처리
function t2sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.CountFormat = "[ " + sheetObj.CellValue(Row, 0) + " / " + seqSheet2 + " ]";
}
 */
/* 개발자 작업 끝 */