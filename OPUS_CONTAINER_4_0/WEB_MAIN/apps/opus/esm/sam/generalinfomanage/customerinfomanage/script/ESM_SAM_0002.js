/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_SAM_0002.js
 *@FileTitle  : Customer Information
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/20
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
function ESM_SAM_0002() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}
var tabObjects = new Array();
var tabCnt = 0;
var tab_no = 0;
var tab_no2 = 0;
var beforetab = 1;
var checkCustCd = null;
var custCd = null;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;
var tabItem = 0;
var seqSheet1 = 0;
var seqSheet2 = 0;
var loadPageCnt = 0;
var permissionSrep = false;
var permission = false;
var ofcCdData = new Array();
var itop = 0;
var tabCustCd = null;
var initRetrieve = false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].SetSheetHeight(220);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	// MultiCombo초기화
	for ( var k = 1; k < comboObjects.length - 1; k++) {
		initCombo(comboObjects[k]);
	}
	initControl();
	
//    2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다.
    document.getElementById("sButtonTable").style.display="none";
	
	var formObj = document.form;
	doActionIBCombo(sheetObjects[0], formObj, SEARCH);
	loadPageCnt = 1;
	if (document.form.cust_cd.value.length > 0) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	} else {
		ComSetFocus(document.form.cust_cd);
		checkPermission();
	}
}
/**
 * 콤보 초기설정값
 * 
 * @param {IBMultiCombo}
 *            comboObj comboObj
 */
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(150);
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
			: event.charCode;
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue != 16
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
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
	axon_event.addListenerForm('change', 'obj_change', formObject);
	axon_event.addListenerFormat ('keydown', 'obj_keydown', formObject);
	axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // t1sheet1 init (KeyMan and Basic Info)
		with (sheetObj) {
			var HeadTitle1 = "|Seq.|First Name|Last Name|Gender|Job Title|Country Phone|Phone#|Fax#|Email|||||||||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 0
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Status",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ibflag"
			}, {
				Type : "Popup",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_kman_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "kman_n1st_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "kman_lst_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "kman_gnd_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "jb_tit_rmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "intl_phn_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "kman_ofc_phn_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "kman_ofc_fax_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "kman_eml",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_sts_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_cust_tp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_rgst_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "fax_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_eml",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bzet_addr",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "key_acct_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_grp_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "mlt_trd_acct_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "intl_fax_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "indiv_corp_div_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "phn_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			} ];

			InitColumns(cols);
			SetSheetHeight(220);
			SetEditable(1);
			SetEditableColorDiff(1);
		}
		break;
	case 2: // t2sheet1 init (Addresses)
		with (sheetObj) {
			var HeadTitle1 = "|Seq.|Primary|Address Type|Customer Name|Address|Country|City|State|Zip Code|Contact Email|Contact Person|LOCAL ADDRESS1|LOCAL ADDRESS2|LOCAL ADDRESS3|LOCAL ADDRESS4|Remark|Delete Flag||";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 0
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Status",
				Hidden : 1,
				Width : 0,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "addr_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 70,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prmry_chk_flg",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 1
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "addr_tp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 200,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bzet_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 50
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 200,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bzet_addr",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 200
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cnt_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cty_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 50
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ste_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 3
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "zip_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntc_eml",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 50
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntc_pson_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 50
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 140,
				Align : "Center",
				ColMerge : 0,
				SaveName : "locl_addr1",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 30
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "locl_addr2",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 30
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "locl_addr3",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 30
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "locl_addr4",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 30
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bzet_rmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 1000
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "delt_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_cnt_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			} ];

			InitColumns(cols);
			SetSheetHeight(220);
			SetEditable(1);
			SetEditableColorDiff(1);
			SetColProperty('prmry_chk_flg', {
				ComboText : "N|Y",
				ComboCode : "N|Y"
			});
			SetColProperty('delt_flg', {
				ComboText : "N|Y",
				ComboCode : "N|Y"
			});
			var info2 = {
				AcceptKeys : "E",
				InputCaseSensitive : 1
			};
			SetColProperty(0, "cnt_cd", info2);
		}
		break;
	case 3: // t3sheet1 init (Preference&Needs)
		with (sheetObj) {
			var HeadTitle1 = "|Seq.|Category|Mode|From Location|To Location|Vendor Code|Vendor";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 0
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Status",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_prf_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_cate_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_mod_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_fm_loc_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen:5,
				AcceptKeys:"E",
				InputCaseSensitive:1
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_to_loc_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen:5,
				AcceptKeys:"E", 
				InputCaseSensitive:1
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_vndr_seq",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 350,
				Align : "Center",
				ColMerge : 0,
				SaveName : "vndr_lgl_eng_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_cnt_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			} ];

			InitColumns(cols);
			SetSheetHeight(220);
			SetEditable(1);
			SetEditableColorDiff(1);
			SetColProperty(0 ,"prf_fm_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
            SetColProperty(0 ,"prf_to_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			SetColProperty(2, {
				ComboText : "|ServiceProvider",
				ComboCode : "|S"
			});
			SetColProperty(3, {
				ComboText : "|Rail|Truck|Feeder|Barge",
				ComboCode : "|R|T|F|B",
				DefaultValue : "R"
			});
		}
		break;
	case 4: // t4sheet1 init (Coverage Team)
		with (sheetObj) {
			var HeadTitle1 = "|Seq.|Primary|First Name|Last Name|S.Rep. ABBR NM|S.Rep. Code|Role|Office|Area|Phone#||";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Status",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ibflag"
			}, {
				Type : "Seq",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "seq"
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_prmry_flg",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_ft_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_lt_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_abbr_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prnt_ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 200,
				Align : "Center",
				ColMerge : 0,
				SaveName : "mphn_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_cnt_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				AxceptKeys : "N|E",
				InputCaseSensitive : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "pre_srep_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "op_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "delt_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			} ];

			InitColumns(cols);
			SetSheetHeight(220);
			SetEditable(1);
			SetEditableColorDiff(1);
			SetColProperty(2, {
				ComboText : "N|Y",
				ComboCode : "N|Y"
			});
			var info2 = {
				AcceptKeys : "N|E",
				InputCaseSensitive : 1
			};
			SetColProperty(0, "srep_cd", info2);
		}
		break;
	case 5: // t5sheet1 init (Activity)
		with (sheetObj) {
			var HeadTitle1 = "Seq.|Activity No.|Description|Sales Rep.|Activity|Activity|Plan Date|Actual Date|Status";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 0
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Seq",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 0,
				SaveName : "seq"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "sls_act_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_cmt_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "srep_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "sls_act_tp_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "sls_act_sub_tp_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "act_pln_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "sls_act_act_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Center",
				ColMerge : 0,
				SaveName : "sls_sts",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			} ];

			InitColumns(cols);
			SetSheetHeight(220);
			SetEditable(1);
			SetEditableColorDiff(1);
		}
		break;
	case 6: // t6sheet1 init (More Info)
		with (sheetObj) {
			var HeadTitle1 = "|Created By|Field|Old Value|New Value|Date";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Status",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ibflag"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "nvocc_co_scac_cd"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "nvocc_lic_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "nvocc_bd_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 450,
				Align : "Center",
				ColMerge : 0,
				SaveName : "nvocc_bd_amt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "nvocc_bd_st_eff_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "nvocc_bd_end_eff_dt"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cmpt_desc"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "spcl_req_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_rmk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 450,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_cntr_tpsz_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bkg_alt_rsn",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bkg_alt_msg"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bkg_alt_fm_dt"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "bkg_alt_to_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "user_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 450,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cr_amt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cr_clt_ofc_cd"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ib_cr_term_dys"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ob_cr_term_dys",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "indus_tp_n1st_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 450,
				Align : "Center",
				ColMerge : 0,
				SaveName : "mjr_n1st_trd_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "mjr_n2nd_trd_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "indus_tp_n2nd_desc"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_n1st_rep_cmdt_cd"
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "prf_n2nd_rep_cmdt_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "yry_vol_qty",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 450,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_sla_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 450,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_url",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			} ];

			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
			SetEditableColorDiff(1);
		}
		break;
	case 7: // t7sheet1 init (History)
		with (sheetObj) {
			var HeadTitle1 = "|Created By|Field|Old Value|New Value|Date";
			var headCount = ComCountHeadTitle(HeadTitle1);
			SetConfig({
				SearchMode : 2,
				MergeSheet : 1,
				Page : 20,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "Status",
				Hidden : 1,
				Width : 30,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ibflag"
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cust_his_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Left",
				ColMerge : 0,
				SaveName : "cng_itm_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 320,
				Align : "Center",
				ColMerge : 0,
				SaveName : "old_val_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 320,
				Align : "Center",
				ColMerge : 0,
				SaveName : "new_val_desc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 150,
				Align : "Center",
				ColMerge : 0,
				SaveName : "upd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			} ];

			InitColumns(cols);
			SetSheetHeight(220);
			SetEditable(1);
			SetEditableColorDiff(1);
			SetColProperty("upd_dt", {
				Format : "####-##-##"
			});
		}
		break;
	}
}

function retrieveTabDetail(tabItem){
	if (tabItem == 0) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	} else if (tabItem == 1) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		if (document.form.bzet_addr.value != "") {
			tab1_OnChange(tab1, 1);
			doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
		}
	} else if (tabItem == 2) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		tab1_OnChange(tab1, 2);
	} else if (tabItem == 3) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		tab1_OnChange(tab1, 3);
	} else if (tabItem == 4) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		tab1_OnChange(tab1, 4);
	} else if (tabItem == 5) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		tab1_OnChange(tab1, 5);
	} else if (tabItem == 6) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		tab1_OnChange(tab1, 6);
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve": // Basic Info 조회 KeyMan Tab 선택되어 있을때는 KeyMan Info 도 같이 조회
			initRetrieve = true;
			tabObjects[0].SetSelectedIndex(0);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_Save": // Basic Info SAVE
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			break;
		case "btn_new": // Main New
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		    document.getElementById("sButtonTable").style.display="none";
			ComSetFocus(document.form.cust_cd);
			break;
		case "btn_RowAdd": // Tab 별 시트에 Row 추가
			if (tabItem == 1) {
				addRow(1);
			} else if (tabItem == 2) {
				addRow(2);
			} else if (tabItem == 3) {
				addRow(3);
			}
			break;
		case "btn_Delete": // Tab 별 시트의 Row 삭제
			if (tabItem == 1) {
				btnDeleteup(1);
			} else if (tabItem == 2) {
				btnDeleteup(2);
			} else if (tabItem == 3) {
				btnDeleteup(3);
			}
			break;
		case "btn_TabSave": // Tab 별 Save
			if (tabItem == 1) {
				var count = null;
				for (i = 0; i < sheetObjects[1].RowCount(); i++) {
					if (sheetObjects[1].GetCellValue(i + 1, "prmry_chk_flg") == 'Y') {
						count = count + 1;
					}
				}
				if (count < 1) {
					ComShowCodeMessage("COM12119", "Primary Flg", "Y");
					return true;
				} else{
					doActionIBSheet(sheetObjects[1], document.form, MULTI02);
					retrieveTabDetail(tabItem);
				}
			} else if (tabItem == 2) {
				doActionIBSheet(sheetObjects[2], document.form, MULTI03);
				retrieveTabDetail(tabItem);
			} else if (tabItem == 3) {
				var deleteCnt = 0;
				for (i = 1; i <= sheetObjects[3].RowCount(); i++){
					if(sheetObjects[3].GetRowStatus(i)=='D'){
						deleteCnt ++;
					}
				}
				if(sheetObjects[3].RowCount() < 1 || sheetObjects[3].RowCount() == deleteCnt){
					ComShowCodeMessage("SAM00020");
					doActionIBSheet(sheetObjects[3], document.form, SEARCH03);
				}else{
					for (i = 1; i <= sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetCellValue(i, "srep_cd") == "") {
							ComShowCodeMessage("COM130403", "Srep Code");
							return false;
						}
					}
					var count = null;
					for (i = 0; i < sheetObjects[3].RowCount(); i++) {
						if (sheetObjects[3].GetRowStatus(i+1)!='D' && sheetObjects[3].GetCellValue(i + 1, "srep_prmry_flg") == 'Y') {
							count = count + 1;
						}
					}
					if (count == null) {
						ComShowCodeMessage("SAM00021");
						return false;
					}else if(count>1){
						ComShowCodeMessage("COM12119", "Primary Flg", "Y");
						return false;
					}else{
						doActionIBSheet(sheetObjects[3], document.form, MULTI04);
						retrieveTabDetail(tabItem);
					}
				}
			}
			break;
		case "btn2_TabSave": // More Info Save
			doActionIBSheet(sheetObjects[5], document.form, MULTI05);
			retrieveTabDetail(tabItem);
			break;
		case "btn_search":
			ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 500, 'getCustCd', "1,0,1", true);
			break;
		case "btn_commodity1": // More Info Tab의 Srep Commdity 코드 입력
			param = '?classId=COM_ENS_012&rep_cmdt_cd='
					+ formObject.prf_n1st_rep_cmdt_cd.value;
			ComOpenPopup('/opuscntr/COM_ENS_012.do' + param, 1024, 685,
					'getcmdtcd1', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			break;
		case "btn_commodity2": // More Info Tab의 Srep Commdity 코드 입력
			param = '?classId=COM_ENS_012&rep_cmdt_cd='
					+ formObject.prf_n2nd_rep_cmdt_cd.value;
			ComOpenPopup('/opuscntr/COM_ENS_012.do' + param, 1024, 685,
					'getcmdtcd2', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			break;
		case "btn_cal1_fr": // More Info Tab의 eff.date(from) 입력
			var cal = new ComCalendar();
			if (permission == true) {
				cal.select(formObject.nvocc_bd_st_eff_dt, 'yyyy-MM-dd');
			}
			break;
		case "btn_cal1_to": // More Info Tab의 eff.date(to) 입력
			var cal = new ComCalendar();
			if (permission == true) {
				cal.select(formObject.nvocc_bd_end_eff_dt, 'yyyy-MM-dd');
			}
			break;
		case "btn_cal2_fr": // More Info Tab의 Booking Alert Period(from) 입력
			var cal = new ComCalendar();
			if (permission == true) {
				cal.select(formObject.bkg_alt_fm_dt, 'yyyy-MM-dd');
			}
			break;
		case "btn_cal2_to": // More Info Tab의 Booking Alert Period(from) 입력
			var cal = new ComCalendar();
			if (permission == true) {
				cal.select(formObject.bkg_alt_to_dt, 'yyyy-MM-dd');
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * COM_ENS_011 : More Info Commodity1 Code를 화면에 설정
 * 
 * @author 박찬민
 * @version 2011.06.02
 */
function getcmdtcd1(rowArray) {
	var colArray = rowArray[0];
	if (permission == true) {
		document.form.prf_n1st_rep_cmdt_cd.value = colArray[5];
		document.form.prf_n1st_cmdt_grp_dtl.value = colArray[6];
	}
}

function getCustCd(aryPopupData) {
	var form=document.form;
	form.cust_cd.value=aryPopupData[0][3];
} 

/**
 * COM_ENS_011 : More Info Commodity2 Code를 화면에 설정
 * 
 * @author 박찬민
 * @version 2011.06.02
 */
function getcmdtcd2(rowArray) {
	var colArray = rowArray[0];
	if (permission == true) {
		document.form.prf_n2nd_rep_cmdt_cd.value = colArray[5];
		document.form.prf_n2nd_cmdt_grp_dtl.value = colArray[6];
	}
}
/**
 * Address tab 팝업
 * 
 * @author 
 * @version 2012.02.10
 */
function t2sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	switch (colname) {
	case "cnt_cd":
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "COM_ENS_0M1";
		var sheet = "1";
		var param = '?sheet=' + sheet + '&classId=' + classId;
		ComOpenPopup('COM_ENS_0M1.do' + param, 780, 490, 'getCOM_ENS_0M1',
				dispaly, false, false);
		break;
	case "ste_cd":
		// param = param + "&" + "ste_cd="
		// ComOpenPopup('COM_ENS_0X1.do?' + param, 310, 350, 'getCOM_ENS_0X1',
		// '1,0,1,1,1,1,1,1', true, Col,Row);
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "COM_ENS_0X1";
		var sheet = "1";
		var param = '?sheet=' + sheet + '&classId=' + classId;
		ComOpenPopup('COM_ENS_0X1.do' + param, 700, 440, 'getCOM_ENS_0X1',
				dispaly, false, false);
		// ComOpenPopup('COM_ENS_0X1.do' + param, 310, 350, 'getCOM_ENS_0X1',
		// dispaly, true, false);
		break;
	}
}
function getCOM_ENS_0M1(aryPopupData, Row, Col) {
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	if (aryPopupData.length > 0) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cnt_cd",
				aryPopupData[0][3]);
	}
}
function getCOM_ENS_0X1(aryPopupData, Row, Col) {
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	if (aryPopupData.length > 0) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ste_cd",
				aryPopupData[0][3]);
	}
}
/**
 * Tab1Sheet OnPopupClick 이벤트 발생시 호출되는 function <br>
 * 시트별 컬럼에 대한 팝업 호출
 * 
 * </pre>
 * 
 * @param {ibsheet}
 *            sheetObj 필수 IBSheet Object
 * @param {int}
 *            Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int}
 *            Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str}
 *            Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
 * @return 없음
 * @author 박찬민
 * @version 2011.06.02
 */
function t1sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	switch (colname) {
	case "cust_kman_seq":
		var currIdx = sheetObjects[0].GetSelectRow();
		var pCust_cd = document.form.cust_cd.value;
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "ESM_SAM_0003";
		var sheet = "2";
		var param = '?sheet=' + sheet + '&classId=' + classId + "&cust_cd="
				+ pCust_cd;
		// if(sheetObjects[0].GetCellValue(currIdx, "cust_kman_seq") != ""){
		// ComOpenPopup('ESM_SAM_0003.do' + param, 1024, 640, '', dispaly, true,
		// false);
		ComOpenWindow2('ESM_SAM_0003.do' + param, 'getESM_SAM_0003',
				"width=1300, height=770");
		// } else{
		// ComShowCodeMessage("COM12113");
		// }
		break;
	}
}

/**
 * Tab3Sheet OnPopupClick 이벤트 발생시 호출되는 function <br>
 * 시트별 컬럼에 대한 팝업 호출
 * 
 * </pre>
 * 
 * @param {ibsheet}
 *            sheetObj 필수 IBSheet Object
 * @param {int}
 *            Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int}
 *            Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str}
 *            Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
 * @return 없음
 * @author 박찬민
 * @version 2011.06.02
 */
function t3sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	switch (colname) {
	case "prf_fm_loc_cd":
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "COM_ENS_051";
		var sheet = "2";
		var param = '?sheet=' + sheet + '&classId=' + classId;
		ComOpenPopup('COM_ENS_051.do' + param, 770, 470, 'getfmloccd', dispaly,
				true, false);
		break;
	case "prf_to_loc_cd":
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "COM_ENS_051";
		var sheet = "2";
		var param = '?sheet=' + sheet + '&classId=' + classId;
		ComOpenPopup('COM_ENS_051.do' + param, 770, 470, 'gettoloccd', dispaly,
				true, false);
		break;
	case "prf_vndr_seq":
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "COM_ENS_OC1";
		var sheet = "2";
		var param = '?sheet=' + sheet + '&classId=' + classId;
		ComOpenPopup('COM_ENS_0C1.do' + param, 770, 550, 'getvndrseq', dispaly,
				true, false);
		break;
	}
}
/**
 * COM_ENS_0051 : Preference&Needs Tab의 From Location 정보를 가져오는 Function
 * 
 * @author 박찬민
 * @version 2011.06.02 현재 팝업 미완성으로 Function 미완성
 */
function getfmloccd(rowArray, row, col) {
	var sheetObj = sheetObjects[2];
	var colArray = rowArray[0];
	sheetObj
			.SetCellValue(sheetObj.GetSelectRow(), "prf_fm_loc_cd", colArray[3]);
}
/**
 * COM_ENS_0051 : Preference&Needs Tab의 To Location 정보를 가져오는 Function
 * 
 * @author 박찬민
 * @version 2011.06.02 현재 팝업 미완성으로 Function 미완성
 */
function gettoloccd(rowArray, row, col) {
	var sheetObj = sheetObjects[2];
	var colArray = rowArray[0];
	sheetObj
			.SetCellValue(sheetObj.GetSelectRow(), "prf_to_loc_cd", colArray[3]);
}
/**
 * COM_ENS_0051 : Preference&Needs Tab의 Vendor Code 정보를 가져오는 Function
 * 
 * @author 박찬민
 * @version 2011.06.02 현재 팝업 미완성으로 Function 미완성
 */
function getvndrseq(rowArray, row, col) {
	var sheetObj = sheetObjects[2];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prf_vndr_seq", colArray[2]);
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_lgl_eng_nm",
			colArray[4]);
}
/**
 * Tab4Sheet OnPopupClick 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet}
 *            sheetObj 필수 IBSheet Object
 * @param {int}
 *            Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int}
 *            Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str}
 *            Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
 * @return 없음
 * @author 박찬민
 * @version 2011.06.02
 */
function t4sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	switch (colname) {
	case "srep_cd":
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "ESM_SAM_0005";
		var sheet = "2";
		var row = sheetObjects[3].GetSelectRow();
		var pOfcCd = sheetObjects[3].GetCellValue(row, "ofc_cd");
		var param = '?sheet=' + sheet + '&classId=' + classId + '&opn=2'
				+ "&ofc_cd=" + pOfcCd;
		ComOpenPopup('ESM_SAM_0005_POP.do' + param, 1000, 600, 'getsrepflg',dispaly, true, false);
		break;
	}
}
function t2sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	with (sheetObj) {
		switch (ColSaveName(col)) {
		case "cnt_cd":
			var in_cnt_cd = GetCellValue(GetSelectRow(), "cnt_cd");
			if (in_cnt_cd != "") {
				formObject.f_cmd.value = SEARCH16;
				var sParam = "f_cmd=" + formObject.f_cmd.value
						+ "&Check_String=" + in_cnt_cd;
				var sXml = sheetObjects[2].GetSearchData("ESM_SAM_0002GS.do",
						sParam);
				var check_cd = ComGetEtcData(sXml, "result");
				if (check_cd == "") {
					SetCellValue(GetSelectRow(), "cnt_cd", "");
					ComShowCodeMessage("COM130402", "Country");
				}
			}
			break;
		case "ste_cd":
			var in_ste_cd = GetCellValue(GetSelectRow(), "ste_cd");
			if (in_ste_cd != "") {
				formObject.f_cmd.value = SEARCH17;
				var sParam = "f_cmd=" + formObject.f_cmd.value
						+ "&Check_String=" + in_ste_cd;
				var sXml = sheetObjects[2].GetSearchData("ESM_SAM_0002GS.do",
						sParam);
				var check_cd = ComGetEtcData(sXml, "result");
				if (check_cd == "") {
					SetCellValue(GetSelectRow(), "ste_cd", "");
					ComShowCodeMessage("COM130402", "State");
				}
			}
			break;
		}
	}
}
function t3sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	with (sheetObj) {
		switch (ColSaveName(col)) {
		case "prf_fm_loc_cd":
			var in_loc_cd = GetCellValue(GetSelectRow(), "prf_fm_loc_cd");
			if (in_loc_cd != "") {
				formObject.f_cmd.value = SEARCH14;
				var sParam = "f_cmd=" + formObject.f_cmd.value
						+ "&Check_String=" + in_loc_cd;
				var sXml = sheetObjects[3].GetSearchData("ESM_SAM_0002GS.do",
						sParam);
				var check_cd = ComGetEtcData(sXml, "result");
				if (check_cd == "") {
					SetCellValue(GetSelectRow(), "prf_fm_loc_cd", "");
					ComShowCodeMessage("COM130402", "Location");
				}
			}
			break;
		case "prf_to_loc_cd":
			var in_loc_cd = GetCellValue(GetSelectRow(), "prf_to_loc_cd");
			if (in_loc_cd != "") {
				formObject.f_cmd.value = SEARCH14;
				var sParam = "f_cmd=" + formObject.f_cmd.value
						+ "&Check_String=" + in_loc_cd;
				var sXml = sheetObjects[3].GetSearchData("ESM_SAM_0002GS.do",
						sParam);
				var check_cd = ComGetEtcData(sXml, "result");
				if (check_cd == "") {
					SetCellValue(GetSelectRow(), "prf_to_loc_cd", "");
					ComShowCodeMessage("COM130402", "Location");
				}
			}
			break;
		case "prf_vndr_seq":
			var in_vndr_seq = GetCellValue(GetSelectRow(), "prf_vndr_seq");
			if (in_vndr_seq != "") {
				formObject.f_cmd.value = SEARCH15;
				var sParam = "f_cmd=" + formObject.f_cmd.value
						+ "&Check_String=" + in_vndr_seq;
				var sXml = sheetObjects[3].GetSearchData("ESM_SAM_0002GS.do",
						sParam);
				var check_cd = ComGetEtcData(sXml, "result");
				if (check_cd == "") {
					SetCellValue(GetSelectRow(), "prf_vndr_seq", "");
					ComShowCodeMessage("COM130402", "Vendor Code");
				}
			}
			break;
		}
	}
}
function t4sheet1_OnChange(sheetObj, row, col, value) {
	with (sheetObj) {
		switch (ColSaveName(col)) {
		case "srep_cd":
			document.form.chk_srep_cd.value = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "srep_cd");
			doActionIBSheet(sheetObj, document.form, SEARCH10);
			break;
		case "srep_prmry_flg":
			var sheetObj = sheetObjects[3];
			if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "op_cd") != "I") {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "op_cd", "U");
			}
		}
	}
}
/**
 * ESM_SAM_0005 : Coverage Tab의 Srep_cd 정보를 가져오는 Function
 * 
 * @author 박찬민
 * @version 2011.06.02 현재 팝업 미완성으로 Function 미완성
 */
function getsrepflg(rowArray, row, col) {
	var sheetObj = sheetObjects[3];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "srep_cd", colArray[2]);
}
/**
 * t5sheet1 OnDblClick 이벤트 발생시 호출되는 function <br>
 * 팝업 화면에 Activity Number를 전송
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet}
 *            sheetObj, Row, Col, Value
 * @return 없음
 * @author 박찬민
 * @version 2011.06.03
 */
function t5sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	switch (colname) {
	case "srep_cmt_desc":
		ComShowMemoPad(sheetObj, Row, Col, true, 300, 200);
		break;
	case "sls_act_seq":
		var dispaly = "0,1,1,1,1,1,1,1,1,1"; // Row PopUp
		var classId = "ESM_SAM_0007";
		var sheet = "2";
		var currIdx = sheetObjects[4].GetSelectRow();
		var pSlsActSeq = sheetObjects[4].GetCellValue(currIdx, "sls_act_seq");
		var params = '?sheet=' + sheet + '&classId=' + classId + '&opn=2'
				+ "&sls_act_seq=" + pSlsActSeq;
		var pgmUrl = "/opuscntr/ESM_SAM_0007.do"
		var pgmNo = "ESM_SAM_0007";
		var parentPgmNo = pgmNo.substring(0, 8) + 'M001';
		var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&pgmNo="
				+ pgmNo + params;
		var sFeatures = "status=no, width=1024, height=750, resizable=yes, scrollbars=yes";
		var winObj = window.open("opusMain.screen?parentPgmNo=" + parentPgmNo
				+ src, "", sFeatures);
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Basic Info and KeyMan Info Retrieve
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		basicInfo_clear();
		if (ComGetEtcData(sXml, "cust_lgl_eng_nm") == undefined) {
			formObj.cust_lgl_eng_nm.value = '';
		} else {
			formObj.cust_lgl_eng_nm.value = ComGetEtcData(sXml, "cust_lgl_eng_nm");
		}
		if (ComGetEtcData(sXml, "ofc_cd") == undefined) {
			formObj.ofc_cd.value = '';
		} else {
			formObj.ofc_cd.value = ComGetEtcData(sXml, "ofc_cd");
		}
		if (ComGetEtcData(sXml, "cust_sts_cd") == undefined) {
			cust_sts_cd.SetSelectText('');
		} else {
			cust_sts_cd.SetSelectCode(ComGetEtcData(sXml, "cust_sts_cd"));
		}
		if (ComGetEtcData(sXml, "srep_cd") == undefined) {
			formObj.srep_cd.value = '';
		} else {
			formObj.srep_cd.value = ComGetEtcData(sXml, "srep_cd");
		}
		if (ComGetEtcData(sXml, "cntr_cust_tp_cd") == undefined) {
			cntr_cust_tp_cd.SetSelectText('');
		} else {
			cntr_cust_tp_cd.SetSelectCode(ComGetEtcData(sXml, "cntr_cust_tp_cd"));
		}
		if (ComGetEtcData(sXml, "indiv_corp_div_cd") == undefined) {
			indiv_corp_div_cd.SetSelectText('');
		} else {
			indiv_corp_div_cd.SetSelectCode(ComGetEtcData(sXml,"indiv_corp_div_cd"));
		}
		if (ComGetEtcData(sXml, "loc_cd") == undefined) {
			formObj.loc_cd.value = '';
		} else {
			formObj.loc_cd.value = ComGetEtcData(sXml, "loc_cd");
		}
		if (ComGetEtcData(sXml, "cust_rgst_no") == undefined) {
			formObj.cust_rgst_no.value = '';
		} else {
			formObj.cust_rgst_no.value = ComGetEtcData(sXml, "cust_rgst_no");
		}
		if (ComGetEtcData(sXml, "key_acct_flg") == undefined) {
			formObj.key_acct_flg.value = '';
		} else {
			formObj.key_acct_flg.value = ComGetEtcData(sXml, "key_acct_flg");
		}
		if (ComGetEtcData(sXml, "cust_grp_id") == undefined) {
			formObj.cust_grp_id.value = '';
		} else {
			formObj.cust_grp_id.value = ComGetEtcData(sXml, "cust_grp_id");
		}
		if (ComGetEtcData(sXml, "mlt_trd_acct_flg") == undefined) {
			formObj.mlt_trd_acct_flg.value = '';
		} else {
			formObj.mlt_trd_acct_flg.value = ComGetEtcData(sXml, "mlt_trd_acct_flg");
		}
		if (ComGetEtcData(sXml, "cre_usr_id") == undefined) {
			formObj.cre_usr_id.value = '';
		} else {
			formObj.cre_usr_id.value = ComGetEtcData(sXml, "cre_usr_id");
		}
		if (ComGetEtcData(sXml, "ofc_eng_nm") == undefined) {
			formObj.ofc_eng_nm.value = '';
		} else {
			formObj.ofc_eng_nm.value = ComGetEtcData(sXml, "ofc_eng_nm");
		}
		if (ComGetEtcData(sXml, "srep_nm") == undefined) {
			formObj.srep_nm.value = '';
		} else {
			formObj.srep_nm.value = ComGetEtcData(sXml, "srep_nm");
		}
		if (ComGetEtcData(sXml, "phn_no") == undefined) {
			formObj.phn_no.value = '';
		} else {
			formObj.phn_no.value = ComGetEtcData(sXml, "phn_no");
		}
		if (ComGetEtcData(sXml, "fax_no") == undefined) {
			formObj.fax_no.value = '';
		} else {
			formObj.fax_no.value = ComGetEtcData(sXml, "fax_no");
		}
		if (ComGetEtcData(sXml, "cust_eml") == undefined) {
			formObj.cust_eml.value = '';
		} else {
			formObj.cust_eml.value = ComGetEtcData(sXml, "cust_eml");
		}
		if (ComGetEtcData(sXml, "bzet_addr") == undefined) {
			formObj.bzet_addr.value = '';
		} else {
			formObj.bzet_addr.value = ComGetEtcData(sXml, "bzet_addr");
		}
		if (ComGetEtcData(sXml, "usr_nm") == undefined) {
			formObj.usr_nm.value = '';
		} else {
			formObj.usr_nm.value = ComGetEtcData(sXml, "usr_nm");
		}
		if (ComGetEtcData(sXml, "cre_ofc_cd") == undefined) {
			formObj.cre_ofc_cd.value = '';
		} else {
			formObj.cre_ofc_cd.value = ComGetEtcData(sXml, "cre_ofc_cd");
		}
		if (ComGetEtcData(sXml, "cts_no") == undefined) {
			formObj.cts_no.value = '';
		} else {
			formObj.cts_no.value = ComGetEtcData(sXml, "cts_no");
		}
		if (ComGetEtcData(sXml, "intl_phn_no") == undefined) {
			formObj.intl_phn_no.value = '';
		} else {
			formObj.intl_phn_no.value = ComGetEtcData(sXml, "intl_phn_no");
		}
		if (ComGetEtcData(sXml, "intl_fax_no") == undefined) {
			formObj.intl_fax_no.value = '';
		} else {
			formObj.intl_fax_no.value = ComGetEtcData(sXml, "intl_fax_no");
		}
		if (ComGetEtcData(sXml, "cust_grp_nm") == undefined) {
			formObj.cust_grp_nm.value = '';
		} else {
			formObj.cust_grp_nm.value = ComGetEtcData(sXml, "cust_grp_nm");
		}
		if (formObj.key_acct_flg.value == 'Y') {
			formObj.key_acct_flg.checked = true;
		} else if (formObj.key_acct_flg.value == 'N') {
			formObj.key_acct_flg.checked = false;
		}
		if (formObj.mlt_trd_acct_flg.value == 'Y') {
			formObj.mlt_trd_acct_flg.checked = true;
		} else if (formObj.mlt_trd_acct_flg.value == 'N') {
			formObj.mlt_trd_acct_flg.checked = false;
		}
		if (arrXml.length > 2)
			sheetObjects[2].LoadSearchData(arrXml[2], {
				Sync : 0
			});
		if (arrXml.length > 1)
			sheetObjects[1].LoadSearchData(arrXml[1], {
				Sync : 0
			});
		if (arrXml.length > 0)
			sheetObjects[0].LoadSearchData(arrXml[0], {
				Sync : 0
			});
		doActionIBSheet(sheetObjects[3], document.form, SEARCH03);
		checkPermission();
		tabCustCd = formObj.cust_cd.value;
		initRetrieve = false;
		ComOpenWait(false);
		break;
	case MULTI: // Basic Info Save
		if (!validateForm(sheetObj, document.form, sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI;
		if (sheetObjects[0].RowCount() == 0) {
			sheetObjects[0].DataInsert(-1);
		}
		sheetObjects[0].RowCount();

		sheetObjects[0].SetCellValue(1, "cust_sts_cd", cust_sts_cd.GetSelectCode());
		sheetObjects[0].SetCellValue(1, "cntr_cust_tp_cd", cntr_cust_tp_cd.GetSelectCode());
		sheetObjects[0].SetCellValue(1, "cust_rgst_no", formObj.cust_rgst_no.value);
		sheetObjects[0].SetCellValue(1, "fax_no", formObj.fax_no.value);
		sheetObjects[0].SetCellValue(1, "cust_eml", formObj.cust_eml.value);
		sheetObjects[0].SetCellValue(1, "bzet_addr", formObj.bzet_addr.value);
		sheetObjects[0].SetCellValue(1, "key_acct_flg",
				formObj.key_acct_flg.value);
		sheetObjects[0].SetCellValue(1, "cust_grp_id",
				formObj.cust_grp_id.value);
		sheetObjects[0].SetCellValue(1, "mlt_trd_acct_flg",
				formObj.mlt_trd_acct_flg.value);
		sheetObjects[0].SetCellValue(1, "cust_cd", formObj.cust_cd.value);
		sheetObjects[0].SetCellValue(1, "intl_fax_no",
				formObj.intl_fax_no.value);
		sheetObjects[0].SetCellValue(1, "indiv_corp_div_cd", indiv_corp_div_cd.GetSelectCode());

		sheetObjects[0].SetCellValue(1, "intl_phn_no",
				formObj.intl_phn_no.value);
		sheetObjects[0].SetCellValue(1, "phn_no", formObj.phn_no.value);

		var sParam = sheetObj.GetSaveString(false, true, "ibflag");
		var sXml = sheetObj.GetSaveData("ESM_SAM_0002GS.do", "f_cmd=" + MULTI+ "&" + sParam);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		break;
	case MULTI02: // Address Info Save
		if (!validateForm(sheetObj, document.form, sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI02;
		sheetObj.RemoveEtcData();
		sheetObj.DoSave("ESM_SAM_0002GS.do", {
			Param : FormQueryString(formObj),
			Sync : 2,
			Quest: 0
		});
		var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        if(result != "F"){
            ComShowCodeMessage("COM130102", "Data");
        }else{
            ComShowCodeMessage("COM130103", "data");
        }
		break;
	case MULTI03: // Reference&Needs Info Save
		formObj.f_cmd.value = MULTI03;
		sheetObj.RemoveEtcData();
		sheetObj.DoSave("ESM_SAM_0002GS.do", {
			Param : FormQueryString(formObj),
			Sync : 2,
			Quest: 0
		});
		var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        if(result != "F"){
            ComShowCodeMessage("COM130102", "Data");
        }else{
            ComShowCodeMessage("COM130103", "data");
        }
		break;
	case MULTI04: // Coverage Team Info Save
		formObj.f_cmd.value = MULTI04;
		sheetObj.RemoveEtcData();
		sheetObj.DoSave("ESM_SAM_0002GS.do", {
			Param : FormQueryString(formObj),
			Sync : 2,
			Quest: 0
		});
		var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        if(result != "F"){
            ComShowCodeMessage("COM130102", "Data");
        }else{
            ComShowCodeMessage("COM130103", "data");
        }
		break;
	case MULTI05: // More Info Save
		formObj.f_cmd.value = MULTI05;
		sheetObjects[5].SetCellValue(1, "nvocc_co_scac_cd",
				formObj.nvocc_co_scac_cd.value);
		sheetObjects[5].SetCellValue(1, "nvocc_lic_no",
				formObj.nvocc_lic_no.value);
		sheetObjects[5].SetCellValue(1, "nvocc_bd_no",
				formObj.nvocc_bd_no.value);
		sheetObjects[5].SetCellValue(1, "nvocc_bd_amt",
				formObj.nvocc_bd_amt.value);
		sheetObjects[5].SetCellValue(1, "nvocc_bd_st_eff_dt",
				formObj.nvocc_bd_st_eff_dt.value);
		sheetObjects[5].SetCellValue(1, "nvocc_bd_end_eff_dt",
				formObj.nvocc_bd_end_eff_dt.value);
		sheetObjects[5].SetCellValue(1, "cmpt_desc", formObj.cmpt_desc.value);
		sheetObjects[5].SetCellValue(1, "spcl_req_desc",
				formObj.spcl_req_desc.value);
		sheetObjects[5].SetCellValue(1, "cust_rmk", formObj.cust_rmk.value);
		sheetObjects[5].SetCellValue(1, "prf_cntr_tpsz_cd",
				formObj.prf_cntr_tpsz_cd.value);
		sheetObjects[5].SetCellValue(1, "bkg_alt_rsn",
				formObj.bkg_alt_rsn.value);
		sheetObjects[5].SetCellValue(1, "bkg_alt_msg",
				formObj.bkg_alt_msg.value);
		sheetObjects[5].SetCellValue(1, "bkg_alt_fm_dt",
				formObj.bkg_alt_fm_dt.value);
		sheetObjects[5].SetCellValue(1, "bkg_alt_to_dt",
				formObj.bkg_alt_to_dt.value);
		sheetObjects[5].SetCellValue(1, "cust_cd", formObj.cust_cd.value);
		sheetObjects[5].SetCellValue(1, "cr_amt", formObj.cr_amt.value);
		sheetObjects[5].SetCellValue(1, "cr_clt_ofc_cd",
				formObj.cr_clt_ofc_cd.value);
		sheetObjects[5].SetCellValue(1, "ib_cr_term_dys",
				formObj.ib_cr_term_dys.value);
		sheetObjects[5].SetCellValue(1, "ob_cr_term_dys",
				formObj.ob_cr_term_dys.value);
		sheetObjects[5].SetCellValue(1, "indus_tp_n1st_desc",
				formObj.indus_tp_n1st_desc.value);
		sheetObjects[5].SetCellValue(1, "mjr_n1st_trd_cd", mjr_n1st_trd_cd
				.GetSelectCode());
		sheetObjects[5].SetCellValue(1, "mjr_n2nd_trd_cd", mjr_n2nd_trd_cd
				.GetSelectCode());
		sheetObjects[5].SetCellValue(1, "indus_tp_n2nd_desc",
				formObj.indus_tp_n2nd_desc.value);
		sheetObjects[5].SetCellValue(1, "prf_n2nd_rep_cmdt_cd",
				formObj.prf_n2nd_rep_cmdt_cd.value);
		sheetObjects[5].SetCellValue(1, "prf_n1st_rep_cmdt_cd",
				formObj.prf_n1st_rep_cmdt_cd.value);
		sheetObjects[5].SetCellValue(1, "yry_vol_qty",
				formObj.yry_vol_qty.value);
		sheetObjects[5].SetCellValue(1, "cust_sla_flg",
				formObj.cust_sla_flg.value);
		sheetObjects[5].SetCellValue(1, "cust_url", formObj.cust_url.value);
		var sParam = sheetObj.GetSaveString(false, true, "ibflag");
		var sXml = sheetObj.GetSaveData("ESM_SAM_0002GS.do", "f_cmd=" + MULTI05+ "&" + sParam);
		var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        if(result != "F"){
            ComShowCodeMessage("COM130102", "Data");
        }else{
            ComShowCodeMessage("COM130103", "data");
        }
		doActionIBSheet(sheetObjects[4], document.form, SEARCH05);
		break;
	case SEARCH01: // Address Info Retrieve
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do",
				FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml, {
			Sync : 1
		});
		ComOpenWait(false);
		break;
	case SEARCH02: // Preference&Needs Info Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value = SEARCH02;
		sheetObj.DoSearch("ESM_SAM_0002GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	case SEARCH03: // Coverage Team Info Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value = SEARCH03;
		initPermission();
		var sXml=sheetObjects[3].GetSearchData("ESM_SAM_0002GS.do" , FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if(arrXml.length > 0){
			if(ComXmlString(sXml, "ofc_cd") != ""){
				var ofcStr=ComXmlString(sXml, "ofc_cd").pop();
		        var arrData = new Array();
		        arrData = ofcStr.split("|");
		        if (arrData !=null && arrData.length > 0){
		        	for(var i=0; i<arrData.length; i++){
		        		ofcCdData.push(arrData[i]);
		        	}
		        }
			}
		}
		sheetObj.LoadSearchData(sXml, {Sync:1} );
		ComOpenWait(false);
		break;
	case SEARCH04: // Activity Info Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value = SEARCH04;
		sheetObj.DoSearch("ESM_SAM_0002GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	case SEARCH05: // More Info Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value = SEARCH05;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		formObj.nvocc_co_scac_cd.value = '';
		formObj.nvocc_lic_no.value = '';
		formObj.nvocc_bd_no.value = '';
		formObj.nvocc_bd_amt.value = '';
		formObj.nvocc_bd_st_eff_dt.value = '';
		formObj.nvocc_bd_end_eff_dt.value = '';
		formObj.cr_amt.value = '';
		formObj.cr_clt_ofc_cd.value = '';
		formObj.ib_cr_term_dys.value = '';
		formObj.ob_cr_term_dys.value = '';
		formObj.indus_tp_n1st_desc.value = '';
		mjr_n1st_trd_cd.SetSelectText("");
		mjr_n2nd_trd_cd.SetSelectText("");
		formObj.indus_tp_n2nd_desc.value = '';
		formObj.prf_n1st_rep_cmdt_cd.value = '';
		formObj.prf_n1st_cmdt_grp_dtl.value = '';
		formObj.cmpt_desc.value = '';
		formObj.prf_n2nd_rep_cmdt_cd.value = '';
		formObj.prf_n2nd_cmdt_grp_dtl.value = '';
		formObj.spcl_req_desc.value = '';
		formObj.cust_rmk.value = '';
		formObj.prf_cntr_tpsz_cd.value = '';
		formObj.yry_vol_qty.value = '';
		formObj.cust_sla_flg.value = '';
		formObj.bkg_alt_rsn.value = '';
		formObj.cust_url.value = '';
		formObj.bkg_alt_msg.value = '';
		formObj.bkg_alt_fm_dt.value = '';
		formObj.bkg_alt_to_dt.value = '';
		if (ComGetEtcData(sXml, "nvocc_co_scac_cd") == undefined) {
			formObj.nvocc_co_scac_cd.value = '';
		} else {
			formObj.nvocc_co_scac_cd.value = ComGetEtcData(sXml, "nvocc_co_scac_cd");
		}
		if (ComGetEtcData(sXml, "nvocc_lic_no") == undefined) {
			formObj.nvocc_lic_no.value = '';
		} else {
			formObj.nvocc_lic_no.value = ComGetEtcData(sXml, "nvocc_lic_no");
		}
		if (ComGetEtcData(sXml, "nvocc_bd_no") == undefined) {
			formObj.nvocc_lic_no.value = '';
		} else {
			formObj.nvocc_bd_no.value = ComGetEtcData(sXml, "nvocc_bd_no");
		}
		if (ComGetEtcData(sXml, "nvocc_bd_amt") == undefined) {
			formObj.nvocc_bd_amt.value = '';
		} else {
			formObj.nvocc_bd_amt.value = ComGetEtcData(sXml, "nvocc_bd_amt");
		}
		if (ComGetEtcData(sXml, "nvocc_bd_st_eff_dt") == undefined) {
			formObj.nvocc_bd_st_eff_dt.value = '';
		} else {
			formObj.nvocc_bd_st_eff_dt.value = ComGetEtcData(sXml,
					"nvocc_bd_st_eff_dt");
		}
		if (ComGetEtcData(sXml, "nvocc_bd_end_eff_dt") == undefined) {
			formObj.nvocc_bd_end_eff_dt.value = '';
		} else {
			formObj.nvocc_bd_end_eff_dt.value = ComGetEtcData(sXml,
					"nvocc_bd_end_eff_dt");
		}
		if (ComGetEtcData(sXml, "cr_amt") == undefined) {
			formObj.cr_amt.value = '';
		} else {
			formObj.cr_amt.value = ComGetEtcData(sXml, "cr_amt");
		}
		if (ComGetEtcData(sXml, "cr_clt_ofc_cd") == undefined) {
			formObj.cr_clt_ofc_cd.value = '';
		} else {
			formObj.cr_clt_ofc_cd.value = ComGetEtcData(sXml, "cr_clt_ofc_cd");
		}
		if (ComGetEtcData(sXml, "ib_cr_term_dys") == undefined) {
			formObj.ib_cr_term_dys.value = '';
		} else {
			formObj.ib_cr_term_dys.value = ComGetEtcData(sXml, "ib_cr_term_dys");
		}
		if (ComGetEtcData(sXml, "ob_cr_term_dys") == undefined) {
			formObj.ob_cr_term_dys.value = '';
		} else {
			formObj.ob_cr_term_dys.value = ComGetEtcData(sXml, "ob_cr_term_dys");
		}
		if (ComGetEtcData(sXml, "indus_tp_n1st_desc") == undefined) {
			formObj.indus_tp_n1st_desc.value = '';
		} else {
			formObj.indus_tp_n1st_desc.value = ComGetEtcData(sXml,
					"indus_tp_n1st_desc");
		}
		if (ComGetEtcData(sXml, "mjr_n1st_trd_cd") == undefined) {
			mjr_n1st_trd_cd.SetSelectText("");
		} else {
			mjr_n1st_trd_cd.SetSelectCode(ComGetEtcData(sXml, "mjr_n1st_trd_cd"));
		}
		if (ComGetEtcData(sXml, "mjr_n2nd_trd_cd") == undefined) {
			mjr_n2nd_trd_cd.SetSelectText("");
		} else {
			mjr_n2nd_trd_cd.SetSelectCode(ComGetEtcData(sXml, "mjr_n2nd_trd_cd"));
		}
		if (ComGetEtcData(sXml, "indus_tp_n2nd_desc") == undefined) {
			formObj.indus_tp_n2nd_desc.value = '';
		} else {
			formObj.indus_tp_n2nd_desc.value = ComGetEtcData(sXml, "indus_tp_n2nd_desc");
		}
		if (ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd") == undefined) {
			formObj.prf_n1st_rep_cmdt_cd.value = '';
		} else {
			formObj.prf_n1st_rep_cmdt_cd.value = ComGetEtcData(sXml,
					"prf_n1st_rep_cmdt_cd");
		}
		if (ComGetEtcData(sXml, "prf_n1st_cmdt_grp_dtl") == undefined) {
			formObj.prf_n1st_cmdt_grp_dtl.value = '';
		} else {
			formObj.prf_n1st_cmdt_grp_dtl.value = ComGetEtcData(sXml,
					"prf_n1st_cmdt_grp_dtl");
		}
		if (ComGetEtcData(sXml, "cmpt_desc") == undefined) {
			formObj.cmpt_desc.value = '';
		} else {
			formObj.cmpt_desc.value = ComGetEtcData(sXml, "cmpt_desc");
		}
		if (ComGetEtcData(sXml, "prf_n2nd_rep_cmdt_cd") == undefined) {
			formObj.prf_n2nd_rep_cmdt_cd.value = '';
		} else {
			formObj.prf_n2nd_rep_cmdt_cd.value = ComGetEtcData(sXml,
					"prf_n2nd_rep_cmdt_cd");
		}
		if (ComGetEtcData(sXml, "prf_n2nd_cmdt_grp_dtl") == undefined) {
			formObj.prf_n2nd_cmdt_grp_dtl.value = '';
		} else {
			formObj.prf_n2nd_cmdt_grp_dtl.value = ComGetEtcData(sXml, "prf_n2nd_cmdt_grp_dtl");
		}
		if (ComGetEtcData(sXml, "spcl_req_desc") == undefined) {
			formObj.spcl_req_desc.value = '';
		} else {
			formObj.spcl_req_desc.value = ComGetEtcData(sXml, "spcl_req_desc");
		}
		if (ComGetEtcData(sXml, "cust_rmk") == undefined) {
			formObj.cust_rmk.value = '';
		} else {
			formObj.cust_rmk.value = ComGetEtcData(sXml, "cust_rmk");
		}
		if (ComGetEtcData(sXml, "prf_cntr_tpsz_cd") == undefined) {
			formObj.prf_cntr_tpsz_cd.value = '';
		} else {
			formObj.prf_cntr_tpsz_cd.value = ComGetEtcData(sXml, "prf_cntr_tpsz_cd");
		}
		if (ComGetEtcData(sXml, "yry_vol_qty") == undefined) {
			formObj.yry_vol_qty.value = '';
		} else {
			formObj.yry_vol_qty.value = ComGetEtcData(sXml, "yry_vol_qty");
		}
		if (ComGetEtcData(sXml, "cust_sla_flg") == undefined) {
			formObj.cust_sla_flg.value = '';
		} else {
			formObj.cust_sla_flg.value = ComGetEtcData(sXml, "cust_sla_flg");
		}
		if (ComGetEtcData(sXml, "bkg_alt_rsn") == undefined) {
			formObj.bkg_alt_rsn.value = '';
		} else {
			formObj.bkg_alt_rsn.value = ComGetEtcData(sXml, "bkg_alt_rsn");
		}
		if (ComGetEtcData(sXml, "cust_url") == undefined) {
			formObj.cust_url.value = '';
		} else {
			formObj.cust_url.value = ComGetEtcData(sXml, "cust_url");
		}
		if (ComGetEtcData(sXml, "bkg_alt_msg") == undefined) {
			formObj.bkg_alt_msg.value = '';
		} else {
			formObj.bkg_alt_msg.value = ComGetEtcData(sXml, "bkg_alt_msg");
		}
		if (ComGetEtcData(sXml, "bkg_alt_fm_dt") == undefined) {
			formObj.bkg_alt_fm_dt.value = '';
		} else {
			formObj.bkg_alt_fm_dt.value = ComGetEtcData(sXml, "bkg_alt_fm_dt");
		}
		if (ComGetEtcData(sXml, "bkg_alt_to_dt") == undefined) {
			formObj.bkg_alt_to_dt.value = '';
		} else {
			formObj.bkg_alt_to_dt.value = ComGetEtcData(sXml, "bkg_alt_to_dt");
		}
		sheetObj.DoSearch("ESM_SAM_0002GS.do", FormQueryString(formObj));
		if (formObj.cust_sla_flg.value == 'Y') {
			formObj.cust_sla_flg.checked = true;
		} else if (document.form.key_acct_flg.checked == 'N') {
			formObj.cust_sla_flg.checked = false;
		}
		ComOpenWait(false);
		break;
	case SEARCH06: // History Info Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value = SEARCH06;
		sheetObj.DoSearch("ESM_SAM_0002GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	case SEARCH07: // Customer Code Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = SEARCH07;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do",
				FormQueryString(formObj));
		formObj.cust_cd.value = ComGetEtcData(sXml, "cust_cd");
		break;
	case SEARCH08: // Customer Code Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = SEARCH08;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do", FormQueryString(formObj));
		if (ComGetEtcData(sXml, "cust_cd") == "") {
			formObj.cr_amt.disabled = true;
			formObj.cr_clt_ofc_cd.disabled = true;
			formObj.ib_cr_term_dys.disabled = true;
			formObj.ob_cr_term_dys.disabled = true;
			formObj.cr_amt.setAttribute("className", "input2");
			formObj.cr_clt_ofc_cd.setAttribute("className", "input2");
			formObj.ib_cr_term_dys.setAttribute("className", "input2");
			formObj.ob_cr_term_dys.setAttribute("className", "input2");
		} else {
			formObj.cr_amt.disabled = false;
			formObj.cr_clt_ofc_cd.disabled = false;
			formObj.ib_cr_term_dys.disabled = false;
			formObj.ob_cr_term_dys.disabled = false;
			formObj.cr_amt.setAttribute("className", "input");
			formObj.cr_clt_ofc_cd.setAttribute("className", "input");
			formObj.ib_cr_term_dys.setAttribute("className", "input");
			formObj.ob_cr_term_dys.setAttribute("className", "input");
		}
		break;
	case SEARCH09: // Customer URL Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = SEARCH09;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do",
				FormQueryString(formObj));
		if (ComGetEtcData(sXml, "cust_cd") == "") {
			formObj.cust_url.disabled = true;
		} else {
			formObj.cust_url.disabled = false;
		}
		break;
	case SEARCH10: // S.rep Code Retrieve
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = SEARCH10;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do", FormQueryString(formObj));
		var currIdx = sheetObjects[3].GetSelectRow();
		if (ComGetEtcData(sXml, "srep_cd_for_mdm") == "") {
			ComShowCodeMessage("COM130402", "Sales Rep Code");
			sheetObjects[3].SetCellValue(currIdx, "srep_cd", sheetObjects[3].GetCellValue(currIdx, "pre_srep_cd"));
			return false;
		}
		if (ComGetEtcData(sXml, "srep_cd_for_sam") != "") {
			sheetObjects[3].SetCellValue(currIdx, "op_cd", "U");
		} else if (ComGetEtcData(sXml, "srep_cd_for_sam") == "") {
			sheetObjects[3].SetCellValue(currIdx, "op_cd", "I");
		}
		break;
	case SEARCH11: // S.rep Code Retrieve Admin
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		permissionSrep = false;
		formObj.f_cmd.value = SEARCH11;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do",
				FormQueryString(formObj));
		if (ComGetEtcData(sXml, "srep_cd_for_samPermission") == "null"
				|| ComGetEtcData(sXml, "srep_cd_for_samPermission") == "") {
			permissionSrep = false;
		} else if (ComGetEtcData(sXml, "srep_cd_for_samPermission") != "") {
			permissionSrep = true;
		}
		break;
	case SEARCH12: // Commodity Code Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = SEARCH12;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do",
				FormQueryString(formObj));
		if (ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd") == "" || ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd") == undefined) {
			ComShowCodeMessage("COM130402", "Commodity Code");
		} else {
			document.form.prf_n1st_rep_cmdt_cd.value = ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd");
			document.form.prf_n1st_cmdt_grp_dtl.value = ComGetEtcData(sXml, "prf_n1st_cmdt_grp_dtl");
		}
		break;
	case SEARCH13: // Commodity Code Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = SEARCH12;
		var sXml = sheetObj.GetSearchData("ESM_SAM_0002GS.do", FormQueryString(formObj));
		if (ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd") == "" || ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd") == undefined) {
			ComShowCodeMessage("COM130402", "Commodity Code");
		} else {
			document.form.prf_n2nd_rep_cmdt_cd.value = ComGetEtcData(sXml, "prf_n1st_rep_cmdt_cd");
			document.form.prf_n2nd_cmdt_grp_dtl.value = ComGetEtcData(sXml, "prf_n1st_cmdt_grp_dtl");
		}
		break;
	case IBCLEAR: // 초기화
		clearAllForms();
		clearAllPages();
		initPermission();
		checkPermission();
		tabObjects[0].SetSelectedIndex(0);
		document.getElementById("sButtonTable").style.display="none";
	    document.getElementById("sButtonTable2").style.display="none";
		formObj.cust_cd.focus();
		break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI02: // Address Info Save
		var dupRow = sheetObj.ColValueDup("prmry_chk_flg|addr_tp_cd");
		if (dupRow > 0) {
			sheetObj.SetSelectRow(dupRow);
			if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prmry_chk_flg") != 'Y') {
				return true;
			} else {
				ComShowCodeMessage("COM131302", "Selected Address Type Primary Key");
				ComSetFocus(sheetObj.ColValueDupRows("prmry_chk_flg|addr_tp_cd"));
				return false;
			}
		}
		break;

//	case MULTI04:
	case SEARCH10: // Coverage team sales rep dup check
		var count = 0;
		for (i = sheetObj.HeaderRows(); i < sheetObj.RowCount() + 1; i++) {
			if (sheetObj.GetRowStatus(i)!='D' && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "srep_cd") == sheetObj.GetCellValue(i, "srep_cd")) {
				count = count + 1;
			}
		}
		if (count > 1) {
			ComShowCodeMessage("COM12115", "Sales Rep. Code");
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "srep_cd", "", 0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "op_cd", "", 0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ofc_cd", "", 0);
			return false;
		}
		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "srep_cd") == "") {
			return false;
		}
		break;
	
	case MULTI: // Basic Info SAVE
		if(formObj.cust_eml.value != ""){
			if(!ComIsEmailAddr(formObj.cust_eml.value)){
				ComShowCodeMessage("COM132201","E-mail Address");
				formObj.cust_eml.focus(); 
				return false;
			}
		}
		break;
	}
	return true;
}
/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}
/**
 * RowAdd 버튼에 대한 액션 각 탭의 선택 Row 아래에 Row추가
 */
function addRow(tab_no) {

	switch (tab_no) {
	case 1:
		var cnt_cd = document.form.cust_cd.value;
		with (sheetObjects[1]) {
			var nowRow = GetSelectRow();
			nowRow = DataInsert(-1);
			SetRowStatus(nowRow, "I");
			SetCellValue(nowRow, "cust_cnt_cd", cnt_cd.substr(0, 2));
			SetCellValue(nowRow, "cust_seq", cnt_cd.substr(2, 6));
			return true;
		}
		break;
	case 2:
		var cnt_cd = document.form.cust_cd.value;
		with (sheetObjects[2]) {
			var nowRow = GetSelectRow();
			nowRow = DataInsert(-1);
			SetRowStatus(nowRow, "I");
			SetCellValue(nowRow, "cust_cnt_cd", cnt_cd.substr(0, 2));
			SetCellValue(nowRow, "cust_seq", cnt_cd.substr(2, 6));
			return true;
		}
		break;
	case 3:
		var cnt_cd = document.form.cust_cd.value;
		with (sheetObjects[3]) {
			var nowRow = GetSelectRow();
			nowRow = DataInsert(-1);
			SetRowStatus(nowRow, "I");
			SetCellValue(nowRow, "delt_flg", "N");
			SetCellValue(nowRow, "cust_cnt_cd", cnt_cd.substr(0, 2));
			SetCellValue(nowRow, "cust_seq", cnt_cd.substr(2, 6));
			return true;
		}
		break;
	}
}
/**
 * RowDel 버튼에 대한 액션 해당 Row 삭제
 */
function btnDeleteup(tab_no2) {
	switch (tab_no2) {
	case 1:
		with (sheetObjects[1]) {
			var nowRow = GetSelectRow();
			if (GetCellValue(nowRow, "ibflag") == "I") {
				RowDelete(nowRow);
				return;
			} else {
				sheetObjects[1].SetRowHidden(nowRow, 1);
				SetRowStatus(nowRow, "D");
			}
		}
		break;
	case 2:
		with (sheetObjects[2]) {
			var nowRow = GetSelectRow();
			if (GetCellValue(nowRow, "ibflag") == "I") {
				RowDelete(nowRow);
				return;
			} else {
				sheetObjects[2].SetRowHidden(nowRow, 1);
				SetRowStatus(nowRow, "D");
			}
		}
		break;
	case 3:
		with (sheetObjects[3]) {
			var nowRow = GetSelectRow();
			if (GetCellValue(nowRow, "ibflag") == "I") {
				RowDelete(nowRow);
				return;
			} else {
				sheetObjects[3].SetRowHidden(nowRow, 1);
				SetRowStatus(nowRow, "D");
				SetCellValue(nowRow, "op_cd", "D");
			}
		}
		break;
	}
}
/**
 * CheckBox 클릭 onChangeCheckBox 클릭시 각 항목에 대한 값 설정
 */
function onChangeCheckBox() {
	if (document.form.key_acct_flg.checked == false) {
		document.form.key_acct_flg.value = 'N'
	} else if (document.form.key_acct_flg.checked == true) {
		document.form.key_acct_flg.value = 'Y';
	}
	if (document.form.mlt_trd_acct_flg.checked == false) {
		document.form.mlt_trd_acct_flg.value = 'N'
	} else if (document.form.mlt_trd_acct_flg.checked == true) {
		document.form.mlt_trd_acct_flg.value = 'Y';
	}
	if (document.form.cust_sla_flg.checked == false) {
		document.form.cust_sla_flg.value = 'N'
	} else if (document.form.cust_sla_flg.checked == true) {
		document.form.cust_sla_flg.value = 'Y';
	}
}
/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertItem("Key Man", "");
			InsertItem("Addresses", "");
			InsertItem("Preference&Needs", "");
			InsertItem("Coverage Team", "");
			InsertItem("Activity", "");
			InsertItem("More Info", "");
			InsertItem("History", "");
		}
		if (tabNo == 1 || tabNo == 2 || tabNo == 3) {
			
		    document.getElementById("sButtonTable").style.display="";
		    document.getElementById("sButtonTable2").style.display="none";
		}
		if (tabNo == 0 || tabNo == 4 || tabNo == 6) {
		    document.getElementById("sButtonTable").style.display="none";
		    document.getElementById("sButtonTable2").style.display="none";
		}
		if (tabNo == 5) {
		    document.getElementById("sButtonTable").style.display="none";
		    document.getElementById("sButtonTable2").style.display="";
		}
		break;
	}
}

function resizeSheet(sheetObj){
	if ((!sheetObj) || (!sheetObj.IBSheetVersion)) {
		return;
	}
	var tempTop = AnchorPosition_getPageOffsetTop(sheetObj);
	if(tempTop > 0){
		itop = tempTop;
	}
}

/**
 * Tab 변경시 이벤트 관련 선택한 탭의 정보를 조회.
 */
function tab1_OnChange(tabObj, nItem) {
	tabItem = nItem;
	document.form.tab_item.value = tabItem;
	var formObject = document.form;
	resizeSheet(sheetObjects[tabItem]);
	if(tabCustCd != null){
		if(tabCustCd != formObject.cust_cd.value && formObject.cust_cd.value != ""){
			if(!initRetrieve){
				retrieveTabDetail(tabItem);
				return;
			}
		}
	}else if(tabCustCd == null){
		if(tabItem != 0){
			retrieveTabDetail(tabItem);
			return;
		}
	}
	if (formObject.cust_cd.value != ""){
		checkPermission();
		if (tabItem == 0) {
		    document.getElementById("sButtonTable").style.display="none";
		    document.getElementById("sButtonTable2").style.display="none";
		    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		if (tabItem == 1) {
			if (permission == true) {
			    document.getElementById("sButtonTable").style.display="";
			    document.getElementById("sButtonTable2").style.display="none";
			} else {
			    document.getElementById("sButtonTable").style.display="none";
			    document.getElementById("sButtonTable2").style.display="none";
			}
			if (document.form.bzet_addr.value != "") {
				doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
			}
		}
		if (tabItem == 2) {
			if (permission == true) {
			    document.getElementById("sButtonTable").style.display="";
			    document.getElementById("sButtonTable2").style.display="none";
			} else {
			    document.getElementById("sButtonTable").style.display="none";
			    document.getElementById("sButtonTable2").style.display="none";
			}
			doActionIBSheet(sheetObjects[2], document.form, SEARCH02);
		}
		if (tabItem == 3) {
			if (permission == true) {
			    document.getElementById("sButtonTable").style.display="";
			    document.getElementById("sButtonTable2").style.display="none";
			} else {
			    document.getElementById("sButtonTable").style.display="none";
			    document.getElementById("sButtonTable2").style.display="none";
			}
			doActionIBSheet(sheetObjects[3], document.form, SEARCH03);
		}
		if (tabItem == 4) {
		    document.getElementById("sButtonTable").style.display="none";
		    document.getElementById("sButtonTable2").style.display="none";
			doActionIBSheet(sheetObjects[4], document.form, SEARCH04);
		}
		if (tabItem == 5) {
			if (permission == true) {
			    document.getElementById("sButtonTable").style.display="none";
			    document.getElementById("sButtonTable2").style.display="";
			} else {
			    document.getElementById("sButtonTable").style.display="none";
			    document.getElementById("sButtonTable2").style.display="none";
			}
			doActionIBSheet(sheetObjects[5], document.form, SEARCH08);
			doActionIBSheet(sheetObjects[5], document.form, SEARCH09);
			doActionIBSheet(sheetObjects[5], document.form, SEARCH05);
		}
		if (tabItem == 6) {
		    document.getElementById("sButtonTable").style.display="none";
		    document.getElementById("sButtonTable2").style.display="none";
			doActionIBSheet(sheetObjects[6], document.form, SEARCH06);
		}
	}
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	for ( var i = 0; i < objs.length; i++) {
		if (i != nItem) {
			objs[i].style.display = "none";
			objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		}
	}
	initRetrieve = false;
	beforetab = nItem;
	if (loadPageCnt == 0)
		return;
}
/**
 * 모든 콤보 박스 조회 공통 부분 완성되면 추가 작업 요
 */
function doActionIBCombo(sheetObj, formObj, sAction, sComboObj, sComboAction, sComboKey) {
	switch (sAction) {
	case SEARCH: // load page 시
		var param = "f_cmd=" + SEARCH + "&scr_no=" + "0002";
		var sXml = sheetObj.GetSearchData("ESM_SAM_COMGS.do", param);
		var rtnValue = sXml.split("|$$|");
		for ( var i = 0; i < rtnValue.length; i++) {
			var comboXml = ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
			var cdName = comboXml[0].split("|");
			var cdValue = comboXml[1].split("|");
			if (i == 0) {
				ComXml2ComboItem(rtnValue[i], cust_sts_cd, "cd", "cd_desc|cd");
			} else if (i == 1) {
				ComXml2ComboItem(rtnValue[i], cntr_cust_tp_cd, "cd",
						"cd_desc|cd");
			} else if (i == 2) {
				ComXml2ComboItem(rtnValue[i], mjr_n1st_trd_cd, "cd",
						"cd_desc|cd");
				ComXml2ComboItem(rtnValue[i], mjr_n2nd_trd_cd, "cd",
						"cd_desc|cd");
			} else if (i == 3) {
				// sheetObjects[1].SetColProperty("addr_tp_cd",
				// {ComboText:"|"+comboXml[0],
				// ComboCode:"|"+comboXml[1].toString()} );
				sheetObjects[1].SetColProperty("addr_tp_cd", {
					ComboText : comboXml[0],
					ComboCode : comboXml[1].toString()
				});
			} else if (i == 4) {
				ComXml2ComboItem(rtnValue[i], indiv_corp_div_cd, "cd",
						"cd_desc|cd");
			} else if (i == 5) {
				sheetObjects[0].SetColProperty("kman_gnd_cd", {
					ComboText : "|" + comboXml[0],
					ComboCode : "|" + comboXml[1].toString()
				});
			}
		}
		// if (arrXml.length > 0){
		// ComXml2ComboItem(arrXml[0], formObj.cust_sts_cd, "cd", "cd_desc|cd");
		// ComXml2ComboItem(arrXml[1], formObj.cntr_cust_tp_cd, "cd",
		// "cd_desc|cd");
		// ComXml2ComboItem(arrXml[2], formObj.mjr_n1st_trd_cd, "cd",
		// "cd_desc|cd");
		// ComXml2ComboItem(arrXml[2], formObj.mjr_n2nd_trd_cd, "cd",
		// "cd_desc|cd");
		// ComXml2ComboItem(arrXml[4], formObj.indiv_corp_div_cd, "cd",
		// "cd_desc|cd");
		// }
		// var comboXml = ComXml2ComboString(arrXml[3], "cd_desc", "cd");
		// var cdName = comboXml[0].split("|");
		// var cdValue = comboXml[1].split("|");
		// sheetObjects[1].InitDataCombo(0, "addr_tp_cd", "|" + comboXml[0], "|"
		// + comboXml[1]);
		break;
	}
}
function basicInfo_clear() {
	var formObj = document.form;
	formObj.cust_lgl_eng_nm.value = '';
	formObj.ofc_cd.value = '';
	formObj.srep_cd.value = '';
	formObj.loc_cd.value = '';
	formObj.cust_rgst_no.value = '';
	formObj.key_acct_flg.value = '';
	formObj.cust_grp_id.value = '';
	formObj.mlt_trd_acct_flg.value = '';
	formObj.cre_usr_id.value = '';
	formObj.ofc_eng_nm.value = '';
	formObj.srep_nm.value = '';
	formObj.phn_no.value = '';
	formObj.fax_no.value = '';
	formObj.cust_eml.value = '';
	formObj.bzet_addr.value = '';
	formObj.usr_nm.value = '';
	formObj.cre_ofc_cd.value = '';
	formObj.cust_grp_nm.value = '';
	formObj.cts_no.value = '';
	formObj.intl_phn_no.value = '';
	formObj.intl_fax_no.value = '';

	// 2014.08.12 김용습 - 콤보박스 값 삭제 안되는 버그 해결 하기 위해 수정
	cust_sts_cd.SetSelectText("");
	cntr_cust_tp_cd.SetSelectText("");
	indiv_corp_div_cd.SetSelectText('');
}

function validateCustCode(formObject) {
	var rtnVal = "Y";
	if(formObject.cust_cd.value.length == 8){
		if (!ComIsAlphabet(formObject.cust_cd.value.substring(0, 2), "u") || !ComIsNumber(formObject.cust_cd.value.substring(2, 8))) {
			rtnVal = "N";
			return rtnVal;
		}
		custCd = formObject.cust_cd.value;
		doActionIBSheet(sheetObjects[0], document.form, SEARCH07);
		if (custCd = !formObject.cust_cd.value) {
			rtnVal = "N";
		}
	}else if(formObject.cust_cd.value.length < 8){
		rtnVal = "N";
		return rtnVal;
	}
	return rtnVal;
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (ComGetEvent("dataformat")) {
	case "int":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "float":
		ComKeyOnlyNumber(ComGetEvent(), ".");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		ComKeyOnlyNumber(ComGetEvent());
	}
}

/**
 * OnKeyDown event를 처리한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param N/A
 * @return N/A
 * @author 
 * @version 2016.04.07
 */
function obj_keydown() {
	// enter key조회
	var formObj = document.form;
	var eleName = ComGetEvent("name");
	if (eleName == "cust_cd") {
		if (event.keyCode == 13) {
			if (formObj.cust_cd.value == "") {
				ComShowCodeMessage("COM130201", "Customer Code");
				doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
				return;
			}
			if(validateCustCode(formObj) == "N"){
				ComShowCodeMessage("SAM00017", "Customer Code");
				doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
				return;
			}
			initRetrieve = true;
			tabObjects[0].SetSelectedIndex(0);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
}

function obj_change() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	var formObject = document.form;
	/** **************************************************** */
	try {
		var srcName = event.srcElement.name;
		switch (srcName) {
		case "cust_cd":
			if (formObject.cust_cd.value == "") {
				ComShowCodeMessage("COM130201", "Customer Code");
				doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
				break;
			}
			if(validateCustCode(formObject) == "N"){
				ComShowCodeMessage("SAM00017", "Customer Code");
				doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
				break;
			}
			break;
		case "prf_n1st_rep_cmdt_cd":
			formObject.chk_cmdt_cd.value = formObject.prf_n1st_rep_cmdt_cd.value;
			doActionIBSheet(sheetObjects[0], document.form, SEARCH12);
			break;
		case "prf_n2nd_rep_cmdt_cd":
			formObject.chk_cmdt_cd.value = formObject.prf_n2nd_rep_cmdt_cd.value;
			doActionIBSheet(sheetObjects[0], document.form, SEARCH13);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Initiate Permission as not allowed.
 */
function initPermission() {
	permission = false;
	ofcCdData.length = 0;
}

/**
 * Check permission by confirming match of user office code and Coverage Team's office code.
 * 
 */
function checkPermission() {
	doActionIBSheet(sheetObjects[0], document.form, SEARCH11);
	if(permissionSrep){
		permission = true;
	}else if(ofcCdData.length != 0){
		for(var i=0; i<ofcCdData.length; i++){
			if(document.form.usr_ofc_cd.value == ofcCdData[i]){
				permission = true;
				break;
			}
		}
	}
	modifyForm();
}
/**
 * 권한에 따라 화면 Editalbe Setting
 * 
 */
function modifyForm() {
	var formObj = document.form;
	if (permission == false) {
		ComEnableObject(formObj.intl_phn_no, true);
		ComEnableObject(formObj.phn_no, true);
		ComEnableObject(formObj.cust_rgst_no, true);
		ComEnableObject(formObj.intl_fax_no, true);
		ComEnableObject(formObj.fax_no, true);
		ComEnableObject(formObj.bzet_addr, true);
		ComEnableObject(formObj.key_acct_flg, true);
		ComEnableObject(formObj.mlt_trd_acct_flg, true);
		ComEnableObject(formObj.cust_eml, true);
		ComEnableObject(formObj.nvocc_co_scac_cd, true);
		ComEnableObject(formObj.nvocc_lic_no, true);
		ComEnableObject(formObj.nvocc_bd_no, true);
		ComEnableObject(formObj.nvocc_bd_amt, true);
		ComEnableObject(formObj.nvocc_bd_st_eff_dt, true);
		ComEnableObject(formObj.nvocc_bd_end_eff_dt, true);
		ComEnableObject(formObj.cmpt_desc, true);
		ComEnableObject(formObj.spcl_req_desc, true);
		ComEnableObject(formObj.cust_rmk, true);
		ComEnableObject(formObj.prf_cntr_tpsz_cd, true);
		ComEnableObject(formObj.bkg_alt_rsn, true);
		ComEnableObject(formObj.bkg_alt_msg, true);
		ComEnableObject(formObj.bkg_alt_fm_dt, true);
		ComEnableObject(formObj.bkg_alt_to_dt, true);
		ComEnableObject(formObj.cr_amt, true);
		ComEnableObject(formObj.cr_clt_ofc_cd, true);
		ComEnableObject(formObj.ib_cr_term_dys, true);
		ComEnableObject(formObj.ob_cr_term_dys, true);
		ComEnableObject(formObj.indus_tp_n1st_desc, true);
		ComEnableObject(formObj.indus_tp_n2nd_desc, true);
		ComEnableObject(formObj.prf_n2nd_rep_cmdt_cd, true);
		ComEnableObject(formObj.prf_n1st_rep_cmdt_cd, true);
		ComEnableObject(formObj.yry_vol_qty, true);
		ComEnableObject(formObj.cust_sla_flg, true);
		ComEnableObject(formObj.cust_url, true);
		comboObjects[0].SetEnable(1);
		comboObjects[1].SetEnable(1);
		comboObjects[2].SetEnable(1);
		comboObjects[3].SetEnable(1);
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_cal1_fr");
		ComBtnEnable("btn_cal1_to");
		ComBtnEnable("btn_cal2_fr");
		ComBtnEnable("btn_cal2_to");
		ComEnableObject(formObj.intl_phn_no, false);
		ComEnableObject(formObj.phn_no, false);
		ComEnableObject(formObj.cust_rgst_no, false);
		ComEnableObject(formObj.intl_fax_no, false);
		ComEnableObject(formObj.fax_no, false);
		ComEnableObject(formObj.bzet_addr, false);
		ComEnableObject(formObj.key_acct_flg, false);
		ComEnableObject(formObj.mlt_trd_acct_flg, false);
		ComEnableObject(formObj.cust_eml, false);
		ComEnableObject(formObj.nvocc_co_scac_cd, false);
		ComEnableObject(formObj.nvocc_lic_no, false);
		ComEnableObject(formObj.nvocc_bd_no, false);
		ComEnableObject(formObj.nvocc_bd_amt, false);
		ComEnableObject(formObj.nvocc_bd_st_eff_dt, false);
		ComEnableObject(formObj.nvocc_bd_end_eff_dt, false);
		ComEnableObject(formObj.cmpt_desc, false);
		ComEnableObject(formObj.spcl_req_desc, false);
		ComEnableObject(formObj.cust_rmk, false);
		ComEnableObject(formObj.prf_cntr_tpsz_cd, false);
		ComEnableObject(formObj.bkg_alt_rsn, false);
		ComEnableObject(formObj.bkg_alt_msg, false);
		ComEnableObject(formObj.bkg_alt_fm_dt, false);
		ComEnableObject(formObj.bkg_alt_to_dt, false);
		ComEnableObject(formObj.cr_amt, false);
		ComEnableObject(formObj.cr_clt_ofc_cd, false);
		ComEnableObject(formObj.ib_cr_term_dys, false);
		ComEnableObject(formObj.ob_cr_term_dys, false);
		ComEnableObject(formObj.indus_tp_n1st_desc, false);
		ComEnableObject(formObj.indus_tp_n2nd_desc, false);
		ComEnableObject(formObj.prf_n2nd_rep_cmdt_cd, false);
		ComEnableObject(formObj.prf_n1st_rep_cmdt_cd, false);
		ComEnableObject(formObj.yry_vol_qty, false);
		ComEnableObject(formObj.cust_sla_flg, false);
		ComEnableObject(formObj.cust_url, false);
		comboObjects[0].SetEnable(0);
		comboObjects[1].SetEnable(0);
		comboObjects[2].SetEnable(0);
		comboObjects[3].SetEnable(0);
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_cal1_fr");
		ComBtnDisable("btn_cal1_to");
		ComBtnDisable("btn_cal2_fr");
		ComBtnDisable("btn_cal2_to");
	}
	if (permission == true) {
		ComEnableObject(formObj.intl_phn_no, true);
		ComEnableObject(formObj.phn_no, true);
		ComEnableObject(formObj.cust_rgst_no, true);
		ComEnableObject(formObj.intl_fax_no, true);
		ComEnableObject(formObj.fax_no, true);
		ComEnableObject(formObj.bzet_addr, true);
		ComEnableObject(formObj.key_acct_flg, true);
		ComEnableObject(formObj.mlt_trd_acct_flg, true);
		ComEnableObject(formObj.cust_eml, true);
		ComEnableObject(formObj.nvocc_co_scac_cd, true);
		ComEnableObject(formObj.nvocc_lic_no, true);
		ComEnableObject(formObj.nvocc_bd_no, true);
		ComEnableObject(formObj.nvocc_bd_amt, true);
		ComEnableObject(formObj.nvocc_bd_st_eff_dt, true);
		ComEnableObject(formObj.nvocc_bd_end_eff_dt, true);
		ComEnableObject(formObj.cmpt_desc, true);
		ComEnableObject(formObj.spcl_req_desc, true);
		ComEnableObject(formObj.cust_rmk, true);
		ComEnableObject(formObj.prf_cntr_tpsz_cd, true);
		ComEnableObject(formObj.bkg_alt_rsn, true);
		ComEnableObject(formObj.bkg_alt_msg, true);
		ComEnableObject(formObj.bkg_alt_fm_dt, true);
		ComEnableObject(formObj.bkg_alt_to_dt, true);
		ComEnableObject(formObj.cr_amt, true);
		ComEnableObject(formObj.cr_clt_ofc_cd, true);
		ComEnableObject(formObj.ib_cr_term_dys, true);
		ComEnableObject(formObj.ob_cr_term_dys, true);
		ComEnableObject(formObj.indus_tp_n1st_desc, true);
		ComEnableObject(formObj.indus_tp_n2nd_desc, true);
		ComEnableObject(formObj.prf_n2nd_rep_cmdt_cd, true);
		ComEnableObject(formObj.prf_n1st_rep_cmdt_cd, true);
		ComEnableObject(formObj.yry_vol_qty, true);
		ComEnableObject(formObj.cust_sla_flg, true);
		ComEnableObject(formObj.cust_url, true);
		comboObjects[0].SetEnable(1);
		comboObjects[1].SetEnable(1);
		comboObjects[2].SetEnable(1);
		comboObjects[3].SetEnable(1);
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_cal1_fr");
		ComBtnEnable("btn_cal1_to");
		ComBtnEnable("btn_cal2_fr");
		ComBtnEnable("btn_cal2_to");
	}
}
/**
 * 모든 Sheet의 데이터를 Clear한다. <br>
 * 
 * @param 없음
 * @return 없음
 * @author 
 * @version 2012.02.06
 */
function clearAllPages() {
	for ( var i = 0; i < sheetCnt; i++) {
		sheetObjects[i].RemoveAll();
	}
}
/**
 * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * clearAllForms()
 * </pre>
 * 
 * @param 없음
 * @return 없음
 * @author 
 * @version 2012.02.06
 */
function clearAllForms() {
	var formObj = document.form;
	formObj.cust_cd.value = "";
	formObj.cust_lgl_eng_nm.value = "";
	formObj.ofc_cd.value = "";
	formObj.ofc_eng_nm.value = "";
	formObj.srep_cd.value = "";
	formObj.srep_nm.value = "";
	formObj.loc_cd.value = "";
	formObj.cts_no.value = "";
	formObj.intl_phn_no.value = "";
	formObj.phn_no.value = "";
	formObj.cust_rgst_no.value = "";
	formObj.intl_fax_no.value = "";
	formObj.fax_no.value = "";
	formObj.cust_eml.value = "";
	formObj.bzet_addr.value = "";
	formObj.cust_grp_id.value = "";
	formObj.cust_grp_nm.value = "";
	formObj.cre_usr_id.value = "";
	formObj.usr_nm.value = "";
	formObj.cre_ofc_cd.value = "";
	formObj.key_acct_flg.checked = false;
	formObj.mlt_trd_acct_flg.checked = false;
	comboObjects[0].SetSelectIndex(-1);
	comboObjects[1].SetSelectIndex(-1);
	comboObjects[2].SetSelectIndex(-1);
}

/**
 * ESM_SAM_0005.js에서 opener.callDoActionIBSheet로 넘어오는 부분 
 * 
 * @author 김용습
 * @version 2014.12.03
 */
function callDoActionIBSheet(opnsheetObj, opnformObj){
	doActionIBSheet(opnsheetObj, opnformObj, SEARCH10);
}

 