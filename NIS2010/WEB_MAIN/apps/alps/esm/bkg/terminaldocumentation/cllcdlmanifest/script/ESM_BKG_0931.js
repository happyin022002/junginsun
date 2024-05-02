/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0931.js
 *@FileTitle : ESM_BKG_0931
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
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
 * @class ESM_BKG_0931 : ESM_BKG_0931 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0931() {
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
		case "btn_Summary":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;

		case "btn_Special_CGO":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;

		case "btn_Print":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
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

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

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
	var sheetId = sheetObj.id;

	switch (sheetId) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 302;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 13, 100);

			var HeadTitle1 = "Seq.|Container No.|TP|BKG No.|F/M|Seal No.|Weight|VGM|VGM|VGM Signature|VGM Method|R/D|TS|Special Cargo|Special Cargo|Stow|PC|POD|BLCK\nSTWG|MLB|A.POD|T/S VVD";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
			// "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_no",
					false, "", dfNone, 0, false, true, 11);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_no",
					false, "", dfNone, 0, false, true, 11);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"mty_bkg_cd", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "seal_no",
					false, "", dfNone, 0, false, true, 15);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "bl_wgt",
					false, "", dfNullInteger, 0, false, true, 5);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vgm_wgt", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daRight, false, "vgm_wgt_ut_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vgm_vrfy_sig_ctnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vgm_mzd_tp_cd", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"rcv_term_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "ts_flg", 
					false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 180, daCenter, false,
					"cll_rmk1", false, "", dfNone, 0, false, true, 100);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cll_rmk2",
					false, "", dfNone, 0, false, true, 100);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "stwg_cd",
					false, "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"kr_tml_prct_id", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod_cd",
					false, "", dfNone, 0, false, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "bc_cd",
					false, "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"blck_stwg_cd", false, "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "a_pod_cd",
					false, "", dfNone, 0, false, true, 5);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,
					"ts_vvd_cd", false, "", dfNone, 0, false, true, 9);

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
	// alert();
	switch (sAction) {
	case IBSEARCH: // 조회
		// alert();
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;	
		ComOpenWait(true);
		sheetObj.DoSearch("ESM_BKG_0931GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);

		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			var d2 = 0;
			var d4 = 0;
			var d5 = 0;
			var d7 = 0;
			var d8 = 0;
			var d9 = 0;
			var dw = 0;
			var dx = 0;
			var r2 = 0;
			var r4 = 0;
			var r5 = 0;
			var f2 = 0;
			var f4 = 0;
			var f5 = 0;
			var o2 = 0;
			var o4 = 0;
			var o5 = 0;
			var o7 = 0;
			var s2 = 0;
			var s4 = 0;
			var t2 = 0;
			var t4 = 0;
			var a2 = 0;
			var a4 = 0;
			var a5 = 0;
			var p2 = 0;
			var p4 = 0;
			var z2 = 0;
			var z4 = 0;
			var d3 = 0;
			var r9 = 0;
			var etc = 0;
			var totalTpSize = 0;
			var local = 0;
			var localFull = 0;
			var localEmpty = 0;
			var ts = 0;
			var tsFull = 0;
			var tsEmpty = 0;
			var wgt = 0;
			for ( var i = 1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "seq") == "") {
					sheetObj.RowEditable(i) = false;
				}
				if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "D2") {
					d2 = d2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "D4") {
					d4 = d4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "D5") {
					d5 = d5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "D7") {
					d7 = d7 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "D8") {
					d8 = d8 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "D9") {
					d9 = d9 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "DW") {
					dw = dw + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "DX") {
					dx = dx + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "R2") {
					r2 = r2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "R4") {
					r4 = r4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "R5") {
					r5 = r5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "F2") {
					f2 = f2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "F4") {
					f4 = f4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "F5") {
					f5 = f5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "O2") {
					o2 = o2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "O4") {
					o4 = o4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "O5") {
					o5 = o5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "O7") {
					o7 = o7 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "S2") {
					s2 = s2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "S4") {
					s4 = s4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "T2") {
					t2 = t2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "T4") {
					t4 = t4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "A2") {
					a2 = a2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "A4") {
					a4 = a4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "A5") {
					a5 = a5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "P2") {
					p2 = p2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "P4") {
					p4 = p4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "Z2") {
					z2 = z2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "Z4") {
					z4 = z4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D3"){
					d3 = d3 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "R9"){
					r9 = r9 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
				}
				else{ 
					if(sheetObj.CellValue(i, "cntr_tpsz_cd") != ""){
						etc = etc + 1;
						totalTpSize = totalTpSize + 1;
						wgt = wgt + sheetObj.CellValue(i, "bl_wgt") * 1;
					}
				
				}
				

				if (formObj.in_cll_type.value == "TS") {
					if (sheetObj.CellValue(i, "seq") != "") {
						ts = ts + 1;
						if (sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
					}
				} else {
					if (sheetObj.CellValue(i, "ts_flg") == "TS"
							|| sheetObj.CellValue(i, "ts_flg") == "TT") {
						ts = ts + 1;
						if (sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
					}
					if (sheetObj.CellValue(i, "ts_flg") == ""
							&& sheetObj.CellValue(i, "seq") != "") {
						local = local + 1;
						if (sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							localFull = localFull + 1;
						else
							localEmpty = localEmpty + 1;
					}
				}
			}
			formObj.d2.value = d2;
			formObj.d4.value = d4;
			formObj.d5.value = d5;
			formObj.d7.value = d7;
			formObj.d8.value = d8;
			formObj.d9.value = d9;
			formObj.dw.value = dw;
			formObj.dx.value = dx;
			formObj.r2.value = r2;
			formObj.r4.value = r4;
			formObj.r5.value = r5;
			formObj.f2.value = f2;
			formObj.f4.value = f4;
			formObj.f5.value = f5;
			formObj.o2.value = o2;
			formObj.o4.value = o4;
			formObj.o5.value = o5;
			formObj.o7.value = o7;
			formObj.s2.value = s2;
			formObj.s4.value = s4;
			formObj.t2.value = t2;
			formObj.t4.value = t4;
			formObj.a2.value = a2;
			formObj.a4.value = a4;
			formObj.a5.value = a5;
			formObj.p2.value = p2;
			formObj.p4.value = p4;
			formObj.z2.value = z2;
			formObj.z4.value = z4;
			formObj.d3.value = d3;
			formObj.r9.value = r9;
			formObj.etc.value = etc;
			formObj.totalTpSize.value = totalTpSize;
			formObj.local.value = local;
			formObj.localFull.value = localFull;
			formObj.localEmpty.value = localEmpty;
			formObj.ts.value = ts;
			formObj.tsFull.value = tsFull;
			formObj.tsEmpty.value = tsEmpty;
			formObj.wgt.value = wgt;

			formObj.wgt.value = ComGetMaskedValue(formObj.wgt.value, 'int');

			for ( var i = 1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "") {
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(192, 192, 192);
				}
			}
		}
		ComOpenWait(false);
		break;

	case COMMAND01: // 입력
		var sUrl = "/hanjin/ESM_BKG_0932.do?pgmNo=ESM_BKG_0932&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		location.href = sUrl;
		break;

	case COMMAND02: // 입력
		var sUrl = "/hanjin/ESM_BKG_0933.do?pgmNo=ESM_BKG_0933&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		location.href = sUrl;
		break;

	case COMMAND03: // 입력
		ComOpenWindowCenter("/hanjin/ESM_BKG_5006.do?pgmNo=ESM_BKG_5006",
				"5006", 1024, 720, false);

		break;

	case IBINSERT: // 입력
		sheetObj.DataInsert();
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel();
		break;

	}
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

		return true;
		break;
	case IBSAVE: // 조회

		return true;
		break;
	case COMMAND01: // 조회

		return true;
		break;
	case IBDELETE: // 조회

		return true;
		break;
	}
}

/* 개발자 작업 끝 */