/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0155.js
 *@FileTitle : ESM_BKG_0155
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.08.09 김보배 [CHM-201219500] [BKG] CLL/CDL EDI 전송시 Receiver S/P추가
 * 2014.09.23 이한나 [CHM-201432081] CLL/CDL 화면의 "CLL for EDI" 팝업화면내 BS 칼럼 추가 요청
 * 2015.02.09 이한나 [CHM-201533845] CLL/CDL 메뉴에 Calling sequence 추가
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
 * @class ESM_BKG_0155 : ESM_BKG_0155 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0155() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var cntrNo = "";
var bkgNo = "";
var cntrLodgNo = "";
var vvdCd = "";
var portCd = "";
var gubun = "";
var gubunValue = "";
var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_new":
			document.form.reset();
			sheetObject.RemoveAll();
			formObject.in_vvd_cd.focus();
			break;

		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;

		case "btn_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;

		case "btn_delete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);

			break;

		case "btn_loadingConfirm":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;

		case "btn_edi":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
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
 * @param sheet_obj IBSheet Object
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

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	initControl();

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
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
	// 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
	// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_edi");
	ComBtnDisable("btn_loadingConfirm");
	//alert("TEST");
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	document.form.in_vvd_cd.focus()
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 322;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(56, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Seq.|Sel.|CFM|CNTR|CNTR|R|Remark|TS||R||D||A|B|RD|Booking No.|TEU|FEU|POR|POL|POD|DEL|SOC|F/M|R/D|BS|Stowage|Net Weight|Net Weight|Gross Weight|Gross Weight|VGM|VGM|VGM Signature|VGM Method|Seal|||||||||||||||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,"ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false,"del_chk");
			InitDataProperty(0, cnt++, dtCombo, 35, daCenter, false, "cfm_flg",false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "cntr_no",false, "", dfNone, 0, true, true, 11);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,"cntr_tpsz_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtCombo, 35, daCenter, false,"edi_rcv_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bl_rmk",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 35, daCenter, false, "ts_cgo_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCheckBox, 18, daCenter, false,"rc_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 18, daCenter, false,"rc_flg_pop", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 18, daCenter, false,"dcgo_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 18, daCenter, false,"dcgo_flg_pop", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 18, daCenter, false,"awk_cgo_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 18, daCenter, false,"awk_cgo_flg_pop", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false,"bb_cgo_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false,	"rd_cgo_flg", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 95, daCenter, false, "bkg_no",	false, "", dfNone, 0, true, true, 13);
			InitDataProperty(0, cnt++, dtData, 28, daRight, false,	"teu_cntr_qty", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 28, daRight, false,	"feu_cntr_qty", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "por_cd",	false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol_cd",	false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod_cd",	false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "del_cd",	false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, false, "soc_flg",	false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 37, daCenter, false, "full_mty_cd",	false, "", dfNone, 0, true, true, 1);

			InitDataProperty(0, cnt++, dtData, 37, daCenter, false, "rcv_de_term_cd",	false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "blck_stwg_cd",	false, "", dfNone, 0, false, false, 2); // 2014.09.23 [CHM-201432081]
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "11", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 74, daRight, false, "cntr_wgt",  false, "", dfNullFloat, 3, true, true); 
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, false,"wgt_tp_cd", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 74, daRight, false,   "grs_cntr_wgt", false, "", dfNullFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, false, "grs_wgt_ut_cd", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 74, daRight, false,  "vgm_wgt", false, "", dfNullFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daRight, false, "vgm_wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vgm_vrfy_sig_ctnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vgm_mzd_tp_cd", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 74, daCenter, false,"cntr_seal_no", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"pck_qty", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"pck_tp_cd", false, "", dfNone, 0, true, true); 
			
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"meas_qty", false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"cntr_meas_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_fwrd_len", false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_bkwd_len", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_hgt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_port_len", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_sd_len", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"ovr_cntr_wgt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"fdo_temp", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"cdo_temp", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"cntr_vent_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"cntr_lodg_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"bkg_no2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"cntr_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 74, daCenter, false,"bkg_count", false, "", dfNone, 0, true, true);

			ShowButtonImage = 1;

			InitDataCombo(0, "cfm_flg", "Y|N", "Y|N", "Y", "Y");
			InitDataCombo(0, "edi_rcv_sts_cd", "M\tMerchant|C\tCarrier", "M|C",
					"Merchant", "M");
			// InitDataCombo(0, "ts_cgo_cd", "Local|TS", "L|T", "Local", "L");
			InitDataCombo(0, "ts_cgo_cd", "L\tLocal|T\tTS", "L|T", "Local", "L");
			InitDataCombo(0, "wgt_tp_cd", "KGS|LBS", "KGS|LBS", "KGS", "KGS");
			InitDataCombo(0, "grs_wgt_ut_cd", "KGS|LBS", "KGS|LBS", "KGS", "KGS");			

			InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "bl_rmk", vtEngOther,
					"0123456789!-?~@#$%&*()[]{};:<>/\|");
			InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "bkg_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "teu_cntr_qty", vtNumericOther, ".");
			InitDataValid(0, "feu_cntr_qty", vtNumericOther, ".");
			InitDataValid(0, "por_cd", vtEngUpOnly);
			InitDataValid(0, "pol_cd", vtEngUpOnly);
			InitDataValid(0, "pod_cd", vtEngUpOnly);
			InitDataValid(0, "del_cd", vtEngUpOnly);
			InitDataValid(0, "soc_flg", vtEngUpOnly);
			InitDataValid(0, "full_mty_cd", vtEngUpOnly);
			InitDataValid(0, "rcv_de_term_cd", vtEngUpOnly);
			// InitDataValid(0, "cntr_wgt", vtNumericOther, ".");
			InitDataValid(0, "cntr_seal_no", vtEngUpOther, "0123456789");
			CountPosition = 0;
		}
		break;

	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	// alert(sAction);
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			
			if (formObj.local_t(0).checked)
				formObj.local_type.value = "";
			else
				formObj.local_type.value = "Y";
			
			if (formObj.ts_t(0).checked)
				formObj.ts_type.value = "";
			else 
				formObj.ts_type.value = "Y";
			
			//alert(FormQueryString(formObj));
			sheetObj.DoSearch("ESM_BKG_0155GS.do", FormQueryString(formObj));
			ComEtcDataToForm(formObj, sheetObj);

			state = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				var cntr = 0;
				var bkg = 0;
				var teu = 0;
				var feu = 0;
				var bkgNo = "";
				var cntrNo = "";
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, "bkg_no") != "") {
						bkgNo = sheetObj.CellValue(i, "bkg_no");
						break;
					}
				}
				
				var first = false;
				for ( var i = 1; i <= sheetObj.RowCount; i++) {

					if (bkgNo == sheetObj.CellValue(i, "bkg_no")) {
						if (first == true) {
							sheetObj.CellValue(i, "bkg_no") = "";
							sheetObj.CellValue(i, "teu_cntr_qty") = "";
							sheetObj.CellValue(i, "feu_cntr_qty") = "";
						} else {
							first = true;
						}
					} else {
						bkgNo = sheetObj.CellValue(i, "bkg_no");
					}
				}
				bkgNo = "";
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (bkgNo != sheetObj.CellValue(i, "bkg_no")) {
						//bkg = bkg + 1;
						bkgNo = sheetObj.CellValue(i, "bkg_no");
					}
					teu = teu + sheetObj.CellValue(i, "teu_cntr_qty") * 1;
					feu = feu + sheetObj.CellValue(i, "feu_cntr_qty") * 1;
					sheetObj.CellValue(i, "ibflag") = "R";
				}
				if (sheetObj.RowCount > 0)
					cntr = sheetObj.CellValue(1, "cntr_count") * 1;
				bkg = sheetObj.CellValue(1, "bkg_count") * 1;
				
				// for ( var i = 1; i <= sheetObj.RowCount; i++) {
				// if ( cntrNo != sheetObj.CellValue(i, "cntr_no") )
				// {
				// cntr = cntr + 1;
				// cntrNo = sheetObj.CellValue(i, "cntr_no");
				// }
				// }
				//
				// alert(feu);
				formObj.cntr.value = cntr;
				formObj.bkg.value = bkg;
				formObj.teu.value = teu;
				formObj.feu.value = feu;
				formObj.cntr.value = ComGetMaskedValue(formObj.cntr.value,
						'int');
				formObj.bkg.value = ComGetMaskedValue(formObj.bkg.value, 'int');
				formObj.teu.value = ComGetMaskedValue(formObj.teu.value,
						'float');
				formObj.feu.value = ComGetMaskedValue(formObj.feu.value,
						'float');

				var rowCnt = sheetObj.RowCount;
				// alert(rowCnt);
				if (rowCnt == 0) {
					ComBtnDisable("btn_downExcel");
					ComBtnDisable("btn_edi");
					ComBtnDisable("btn_loadingConfirm");
				} else {
					ComBtnEnable("btn_downExcel");
					ComBtnEnable("btn_edi");
					ComBtnEnable("btn_loadingConfirm");
				}
			}
			ComOpenWait(false);
		}
		break;

	case IBSAVE: // 조회

		if (validateForm(sheetObj, formObj, sAction)) {
//			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_BKG_0155GS.do", FormQueryString(formObj));
			// ComEtcDataToForm(formObj, sheetObj);

			state = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
			}
			ComOpenWait(false);
		}
		break;

	case IBINSERT: // 입력
		sheetObj.DataInsert(-1);
		break;

	case IBDELETE: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i = sheetObj.RowCount; i >= 1; i--) {
				if (sheetObj.CellValue(i, "del_chk") == 1) {
					//alert(i);
					sheetObj.RowHidden(i) = true;
					sheetObj.RowStatus(i) = "D";
				}
			}
		}
		break;

	case IBDOWNEXCEL:
		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "",
				false, "del_chk", "");
		break;

	case COMMAND01: // 조회
		// alert();
		if (validateForm(sheetObj, formObj, sAction)) {
			var inListType = "L";
			var inVvdCd = formObj.in_vvd_cd.value;
			var inPolCd = formObj.in_pol_cd.value;
			var inPolSplitNo = formObj.in_pol_split_no.value;

			var sUrl = "/hanjin/ESM_BKG_0723.do?pgmNo=ESM_BKG_0723&inListType="
					+ inListType + "&inVvdCd=" + inVvdCd + "&inPolCd="
					+ inPolCd + "&inPolSplitNo=" + inPolSplitNo;
			// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// location.href=sUrl;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0723", 430, 430, true);
		}
		break;

	case COMMAND02: // 조회

		if (validateForm(sheetObj, formObj, sAction)) {
			var inVvdCd = formObj.in_vvd_cd.value;
			var inPolCd = formObj.in_pol_cd.value;
			var sUrl = "ESM_BKG_0617.do?pgmNo=ESM_BKG_0617&isPop=Y&inVvdCd="
					+ inVvdCd + "&inPolCd=" + inPolCd;
			// alert(sUrl);
			//location.href = sUrl;
			
            var iWidth = 1024;
            var iHeight = 600;
            var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
            var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
            var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
            var winObj = ComOpenWindowCenter("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + sUrl, "ESM_BKG_0617", 1024, 650, true);
            	//window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + sUrl, "", sFeatures);
            //winObj.focus();
			
			//ComOpenWindowCenter(sUrl, "ESM_BKG_0617", 1024, 600, true);
		}
		break;

	case COMMAND03: // 조회
		// alert();
		if (validateForm(sheetObj, formObj, sAction)) {
			//alert(cntrNo);
			var sUrl = "/hanjin/ESM_BKG_0915.do?pgmNo=ESM_BKG_0915&vvdCd="
					+ vvdCd + "&portCd=" + portCd + "&bkgNo="
					+ formObj.popBkgNo.value + "&cntrNo=" + sheetObj.CellValue(sheetObj.SelectRow, "cntr_no")
					+ "&cntrLodgNo=" + cntrLodgNo + "&rowNum="
					+ sheetObj.SelectRow;
			// alert(sUrl);
			rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0915", 555, 483, true);
		}
		break;

	case COMMAND04: // 조회
		// alert(cntrNo);
		if (validateForm(sheetObj, formObj, sAction)) {

			var sUrl = "/hanjin/ESM_BKG_0916.do?pgmNo=ESM_BKG_0916&vvdCd="
					+ vvdCd + "&portCd=" + portCd + "&bkgNo="
					+ formObj.popBkgNo.value + "&cntrNo=" + sheetObj.CellValue(sheetObj.SelectRow, "cntr_no")
					+ "&cntrLodgNo=" + cntrLodgNo + "&rowNum="
					+ sheetObj.SelectRow + "&gubun=" + gubun + "&gubunValue="
					+ gubunValue;
			// alert(sUrl);
			rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0916", 600, 325, true);
		}
		break;

	}
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {

			var cnt = 0;
			InsertTab(cnt++, "Hire", -1);
			InsertTab(cnt++, "Other ExpB", -1);
			InsertTab(cnt++, "Payment Term", -1);
			InsertTab(cnt++, "Redelivery", -1);
			InsertTab(cnt++, "CP file up", -1);
			InsertTab(cnt++, "Certi File up", -1);

		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;

	case IBSAVE: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;

	case IBDELETE: // 조회
		var vIsCheck = false;
		// alert(sheetObj.RowCount);
		if (!ComShowCodeConfirm("COM12188")) {
			//alert();
			return false;
		}
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		//alert(vIsCheck);
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}

		return true;
		break;

	case COMMAND01: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}

		var vIsCheck = false;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			//alert("test");
			ComShowCodeMessage('BKG00249', '');
			return false;
		}

		return true;
		break;

	case COMMAND02: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND03: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}

		return true;
		break;

	case COMMAND04: // 조회
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	}
}

/**
 * Sheet에서 체크박스 클릭시 팝업
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 */
function sheet1_OnClick(sheetObj, row, col) {
	var formObj = document.form;
	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "rc_flg");
	var check2 = sheetObj.CellValue(row, "dcgo_flg");
	var check3 = sheetObj.CellValue(row, "awk_cgo_flg");
	cntrNo = sheetObj.CellValue(row, "cntr_no");
	//alert(cntrNo);
	formObj.popBkgNo.value = sheetObj.CellValue(row, "bkg_no2");
	// alert(bkgNo);
	cntrLodgNo = sheetObj.CellValue(row, "cntr_lodg_no");
	vvdCd = formObj.in_vvd_cd.value;
	portCd = formObj.in_pol_cd.value;
	var colSaveName = sheetObj.ColSaveName(col);
	// alert();
	if (colSaveName == "dcgo_flg_pop") {
		//alert(vvdNo);
		// alert(portCd);
		// alert(bkgNo);
		// alert(cntrNo);
		// alert(cntrLodgNo);
		doActionIBSheet(sheetObj, formObj, COMMAND03);
	} else if (colSaveName == "rc_flg_pop" || colSaveName == "awk_cgo_flg_pop") {
		//alert(vvdNo);
		// alert(portCd);
		// alert(bkgNo);
		// alert(cntrNo);
		// alert(cntrLodgNo);
		if (colSaveName == "rc_flg_pop") {
			gubun = "rc_flg_pop";
			gubunValue = sheetObj.CellValue(sheetObj.SelectRow, "rc_flg");
		} else {
			gubun = "awk_cgo_flg_pop";
			gubunValue = sheetObj.CellValue(sheetObj.SelectRow, "awk_cgo_flg");
		}
		doActionIBSheet(sheetObj, formObj, COMMAND04);
	}

}

/**
 * 팝업에서 데이터 처리후 부모창 체크박스 세팅
 * @param rowNum rowNum
 * @param gubun gubun
 * @param rowCount rowCount
 * @param resultGubun resultGubun
 */
function setCheckBox(rowNum, gubun, rowCount, resultGubun) {
	//alert(rowNum);
	// alert(gubun);
	// alert(rowCount);
	if (gubun == "915") {
		//alert(gubun);
		if (rowCount != "0") {
			//alert(rowCount);
			sheetObjects[0].CellValue(rowNum, "dcgo_flg") = 1;
		} else {
			//alert(rowCount);
			sheetObjects[0].CellValue(rowNum, "dcgo_flg") = 0;
		}
	} else if (gubun == "916") {
		//alert(rowCount);
		if (rowCount != "0") {
			//alert(resultGubun);
			if (resultGubun == "rc_flg_pop")
				sheetObjects[0].CellValue(rowNum, "rc_flg") = 1;
			if (resultGubun == "awk_cgo_flg_pop")
				sheetObjects[0].CellValue(rowNum, "awk_cgo_flg") = 1;
		} else {
			//alert(resultGubun);
			if (resultGubun == "rc_flg_pop")
				sheetObjects[0].CellValue(rowNum, "rc_flg") = 0;
			if (resultGubun == "awk_cgo_flg_pop")
				sheetObjects[0].CellValue(rowNum, "awk_cgo_flg") = 0;
		}
	}
}
/* 개발자 작업 끝 */