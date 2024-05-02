/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0029.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0029() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var tab2SearchFlag = false;
var tab3SearchFlag = false;

var sheetObjects = new Array();
var sheetCnt = 0;
var isCA_Usr = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var row = sheetObject.SelectRow;
		var bl_no = sheetObject.CellValue(row, "bl_no");

		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH, 1);
			break;
		case "btn_Save":
			if (ComIsBtnEnable("btn_Save"))
				doActionIBSheet(sheetObject, formObject, MODIFY);
			break;
		case "btn_Delete":
			if (ComIsBtnEnable("btn_Delete")) {
				sheetObject.CellValue2(1, "mf_sts_cd") = "D";
				sheetObject.CellValue2(1, "cstms_trsm_sts_cd") = "03";
				doActionIBSheet(sheetObject, formObject, REMOVE);
			}
			break;
		case "btn_Reactivate":
			if (ComIsBtnEnable("btn_Reactivate")) {
				sheetObject.CellValue2(1, "mf_sts_cd") = "A";
				sheetObject.CellValue2(1, "cstms_trsm_sts_cd") = "00";
				doActionIBSheet(sheetObject, formObject, REMOVE);
			}
			break;
		case "btn_Print":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				formObject.com_mrdPath.value = "apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5014.mrd";
				var strArg = "/rp [" + formObject.bl_no.value + "]";
				formObject.com_mrdArguments.value = strArg;
				ComOpenRDPopup();
			}
			break;
		case "btn_Container":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				ComOpenWindowCenter("/hanjin/ESM_BKG_0037.do?pgmNo=ESM_BKG_0037&bl_no=" + bl_no + "&cnt_cd=CA", "0037", 620, 400);
			}
			break;
		case "btn_CM":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				ComOpenWindowCenter("/hanjin/ESM_BKG_0036.do?pgmNo=ESM_BKG_0036&bl_no=" + bl_no + "&cnt_cd=CA", "0036", 850, 510);
			}
			break;
		case "btn_ViewMsg":
			if (validateForm(sheetObject, formObject, COMMAND01) && tabObjects[0].selectedIndex == 1 && sheetObjects[2].RowCount > 0) {
				var row = sheetObjects[2].SelectRow;
				var p1 = sheetObjects[2].CellValue(row, "cnd_ack_rcv_id");
				var p2 = sheetObjects[2].CellValue(row, "ack_desc");
				var p3 = sheetObjects[2].CellValue(row, "cnd_ack_sub_cd");
				var p4 = sheetObjects[2].CellValue(row, "result_desc");
				var p5 = sheetObjects[2].CellValue(row, "cnd_ack_err_note_desc");
				var p6 = sheetObjects[2].CellValue(row, "cstms_rjct_msg");
				var p7 = sheetObjects[2].CellValue(row, "err_cd_desc");
				var p8 = sheetObjects[2].CellValue(row, "err_tp_ctnt");

				var rcv_dt = sheetObjects[2].CellValue(row, "rcv_dt_date");
				var rcv_seq = sheetObjects[2].CellValue(row, "rcv_seq");
				
				ComOpenWindowCenter("/hanjin/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 + "&p6="
						+ p6 + "&p7=" + p7 + "&p8=" + p8 + "&rcv_dt=" + rcv_dt + "&rcv_seq=" + rcv_seq, "0433", 520, 450);
			}
			break;
		case "btn_Transmit":
			if (ComIsBtnEnable("btn_Transmit")) {
				doActionIBSheet(sheetObject, formObject, MODIFY02);
			}
			break;
		case "btn_cust_s":
			formObject.cust_tp.value = "S";
			formObject.cust_cnt_cd.value = formObject.frm_cust_cnt_cd1.value;
			formObject.cust_seq.value = formObject.frm_cust_seq1.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_cust_c":
			formObject.cust_tp.value = "C";
			formObject.cust_cnt_cd.value = formObject.frm_cust_cnt_cd2.value;
			formObject.cust_seq.value = formObject.frm_cust_seq2.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_cust_n":
			formObject.cust_tp.value = "N";
			formObject.cust_cnt_cd.value = formObject.frm_cust_cnt_cd3.value;
			formObject.cust_seq.value = formObject.frm_cust_seq3.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_cust_d":
			formObject.cust_tp.value = "D";
			formObject.cust_cnt_cd.value = formObject.frm_in_tz_yd_cd1.value;
			formObject.cust_seq.value = formObject.frm_in_tz_yd_cd2.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_Terminal":
			if (ComIsBtnEnable("btn_Terminal")) {
				doActionIBSheet(sheetObject, formObject, MODIFY03);
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
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
 * @param isCA_Usr IBSheet Object
 * @param strUsr_id User Id
 */
function loadPage(isCA_Usr, strUsr_id) {

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	this.isCA_Usr = isCA_Usr;
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	if (document.form.type.value != "add" && document.form.bl_no.value != "") {
		//B/L No.를 파라메터로 받은 팝업화면의 경우 자동조회
		doActionIBSheet(sheetObjects[0], document.form, SEARCH, 1);
	}
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_KeyDown', 'form');
	document.form.bl_no.focus();
	document.form.frm_cstms_trsm_sts_cd.Enable = false;
	// 로그인유저가 개발자아이디로 들어온경우 Stage 콤보를 수정할수 있도록함
	for (i = 1; i <= sheetObjects[4].RowCount; i++) {
		if (strUsr_id == sheetObjects[4].CellValue(i, "attr_ctnt3")) {
			document.form.frm_cstms_trsm_sts_cd.Enable = true;
			break;
		}
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
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 80;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|blno|cstms_file_tp_cd|mf_sts_cd|trsp_tp_id|full_mty_cd|||||||vvd|por|pol|pod|pod_nod_cd|eta|del|qty||wgt||hub|loc|hblcount|bdr||||||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_file_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "mf_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "trsp_tp_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "full_mty_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_mf_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_trsm_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "frt_clt_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "obl_rdem_flg", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "m_bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "ccn_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "vvd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "por_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "pod_nod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "vps_eta_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "del_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "pck_qty", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "ams_pck_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cgo_wgt", false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "wgt_ut_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "hub_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "ibd_loc_gds_desc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "hbl_count", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bdr_flg", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_cd1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_zip_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_addr", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_cty_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_ste_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "in_tz_yd_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "diff_rmk", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "t_bdr_flg", false, "", dfNone, 0, false, false);
			CountPosition = 0;
		}
		break;
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 80;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|cnt_cd1|seq1|zip_id1|cty_nm1|ste_cd1|cstms_decl_cnt_cd1|nm1|addr1|cnt_cd2|seq2|zip_id2|cty_nm2|ste_cd2|cstms_decl_cnt_cd2|nm2|addr2|to_ord_flg|cnt_cd3|seq3|zip_id3|cty_nm3|ste_cd3|cstms_decl_cnt_cd3|nm3|addr3";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_cnt_cd1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_seq1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_zip_id1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_cty_nm1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_ste_cd1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_decl_cnt_cd1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_nm1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_addr1", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_cnt_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_seq2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_zip_id2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_cty_nm2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_ste_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_decl_cnt_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_nm2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_addr2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "to_ord_flg", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_cnt_cd3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_seq3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_zip_id3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_cty_nm3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_ste_cd3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_decl_cnt_cd3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_nm3", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_addr3", false, "", dfNone, 0, false, false);
			CountPosition = 0;
		}
		break;
	case "sheet3":
		with (sheetObj) {
			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 4, 100);

			var HeadTitle1 = "SEQ|MSG|Receive Date|VVD|POL|POD|NVO|Status|Status|Reject Code(RC)|Reject Code(RC)|||||";
			var HeadTitle2 = "SEQ|MSG|Receive Date|VVD|POL|POD|NVO|Ack.|Result|Reason|DESC.";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rcv_msg_tp_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "rcv_dt_date", false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "vvd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_file_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cnd_ack_rcv_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cnd_ack_sub_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cstms_rjct_msg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "err_cd_desc", false, "", dfNone, 0, false, false);
			// Hidden
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "ack_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "result_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "cnd_ack_err_note_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "err_tp_ctnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "rcv_seq", false, "", dfNone, 0, true, true);
			sheetObj.DataLinkMouse("cnd_ack_rcv_id") = true;
			sheetObj.DataLinkMouse("cnd_ack_sub_cd") = true;
			sheetObj.DataLinkMouse("cstms_rjct_msg") = true;
			CountPosition = 0;
			
			InitUserFormat2(0, "rcv_dt_date", "####-##-## ##:##:##", "-|:" );

		}
		break;
	case "sheet4":
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "SEQ|Manifest File No.|NVO|Pieces Count|Pieces Count|HUB|Consignee";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 35, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "hm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "pck_qty", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "ams_pck_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "hub_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cust_nm", false, "", dfNone, 0, false, false);
			CountPosition = 0;
		}
		break;

	case "sheet5":
		with (sheetObj) {
			// 높이 설정
			style.height = 50;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle1 = "ID";
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "attr_ctnt3", false, "", dfNone, 0, false, false);
		}
		break;
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param tab_obj 탭오브젝트
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 * @param tabObj 탭오브젝트
 * @param tabNo 탭번호
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Customer", -1);
			InsertTab(cnt++, "Customs Result", -1);
			InsertTab(cnt++, "H.B/L List", -1);
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * @param tabObj 탭오브젝트
 * @param nItem 탭번호
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	if (nItem == 1 && !tab2SearchFlag) {
		//두번째 탭
		doActionIBSheet(sheetObjects[2], document.form, SEARCH, 2);
		tab2SearchFlag = true;
	} else if (nItem == 2 && !tab3SearchFlag) {
		//세번째 탭
		doActionIBSheet(sheetObjects[3], document.form, SEARCH, 3);
		tab3SearchFlag = true;
	}
}

/**
 * t2sheet1 조회후 이벤트
 * @param sheetObj 시트오브젝트
 * @param ErrMsg 에러메시지
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var red = RgbColor(255, 0, 0);
		var blue = RgbColor(0, 0, 255);
		RowFontColor(4) = red;
		RowFontColor(5) = blue;
		RowFontColor(7) = red;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 * @param tabno 탭번호
 */
function doActionIBSheet(sheetObj, formObj, sAction, tabno) {
	sheetObj.ShowDebugMsg = false;
	var sXml;
	var sParam;
	switch (sAction) {
	case INIT:
		formObj.f_cmd.value = INIT;
		sXml = sheetObj.GetSearchXml("ESM_BKG_0029GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], formObj.frm_wgt_ut_cd, "val", "name");
		ComXml2ComboItem(arrXml[1], formObj.frm_trsp_tp_id, "attr_ctnt1", "attr_ctnt1|attr_ctnt2");
		var trsm_sts = "<SHEET><DATA COLORDER='code|name' COLSEPARATOR='☜☞' TOTAL='3'>" +
	                   "<TR><![CDATA[00☜☞Original]]></TR>" +
	                   "<TR><![CDATA[03☜☞Delete]]></TR>" +
	                   "<TR><![CDATA[04☜☞Update]]></TR></DATA></SHEET>";
		ComXml2ComboItem(trsm_sts, formObj.frm_cstms_trsm_sts_cd, "code", "name");
		formObj.frm_wgt_ut_cd.InsertItem(0, "", "");
		formObj.frm_cstms_trsm_sts_cd.InsertItem(0, "", "");
		sheetObjects[4].LoadSearchXml(arrXml[2], false);
		if (formObj.type.value == "add") {
			//DUMMY BL 조회
			formObj.f_cmd.value = SEARCH01;
			sXml = sheetObj.GetSearchXml("ESM_BKG_0029GS.do", FormQueryString(formObj));
			formObj.bl_no.value = ComGetEtcData(sXml, "dummy_bl_no");
			formObj.frm_cstms_file_tp_cd.value = "3";
			formObj.frm_ccn_no.value = "918P" + ComGetEtcData(sXml, "dummy_bl_no");
			formObj.frm_m_bl_no.value = ComGetEtcData(sXml, "dummy_bl_no");
			formObj.frm_full_mty_cd.checked = true;
			document.getElementById("frm_mf_sts_cd").innerHTML = "Active";
			// DUMMY BL
			setButtonDisabled('add');
			tabObjects[0].TabEnable(1) = false;
			tabObjects[0].TabEnable(2) = false;
		} else if (formObj.bl_no.value == "") {
			tabObjects[0].TabEnable(1) = false;
			tabObjects[0].TabEnable(2) = false;
		}
		break;
	case SEARCH: //Retrieve, Tab1
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			formObj.tab_no.value = tabno;
			sXml = sheetObj.GetSearchXml("ESM_BKG_0029GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[tabno].LoadSearchXml(arrXml[tabno]);
			}
			if (tabno == 1) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (sheetObjects[0].RowCount > 0) {
					IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
					var vFontColor = "#000000";
					if (sheetObjects[0].CellValue(1, "mf_sts_cd") == "Active") {
						vFontColor = "blue";
					} else if (sheetObjects[0].CellValue(1, "mf_sts_cd") == "Deleted") {
						vFontColor = "red";
					}
					document.getElementById("frm_mf_sts_cd").innerHTML = "<font color='" + vFontColor + "'>"
							+ sheetObjects[0].CellValue(1, "mf_sts_cd") + "</font>";
					formObj.frm_pck_qty.value = ComAddComma2(formObj.frm_pck_qty, "#,###");
					formObj.frm_cgo_wgt.value = ComAddComma2(formObj.frm_cgo_wgt, "#,###.00");
					formObj.frm_wgt_ut_cd.Code = sheetObjects[0].CellValue(1, "wgt_ut_cd");
					formObj.frm_trsp_tp_id.Code = sheetObjects[0].CellValue(1, "trsp_tp_id");
					formObj.frm_cstms_trsm_sts_cd.Code = sheetObjects[0].CellValue(1, "cstms_trsm_sts_cd");
				}
				if (sheetObjects[1].RowCount > 0) {
					IBS_CopyRowToForm(sheetObjects[1], formObj, 1, "frm_");
				}
				//Retrieve 버튼을 누른경우(탭이 아닌경우)
				tab2SearchFlag = false;
				tab3SearchFlag = false;
				var objs = document.all.item("tabLayer");
				objs[0].style.display = "Inline";
				if (beforetab != 0) {
					objs[beforetab].style.display = "none";
					tabObjects[0].selectedIndex = 0;
				}
				beforetab = 0;
				if (formObj.bl_no.value == formObj.frm_m_bl_no.value) {
					formObj.frm_trsp_tp_id.Enable = false;
				} else {
					formObj.frm_trsp_tp_id.Enable = true;
					formObj.frm_trsp_tp_id.BackColor = "#CCFFFD";
				}
				//Retrieve 버튼을 누른경우 탭비활성화
				if (sheetObjects[0].CellValue(1, "hbl_count") > 0) {
					if (!tabObjects[0].TabEnable(2))
					{
						tabObjects[0].TabEnable(2) = true;
					}
				} else {
					tabObjects[0].TabEnable(2) = false;
				}
				if (!tabObjects[0].TabEnable(1))
				{
					tabObjects[0].TabEnable(1) = true;
				}
				if (sheetObjects[0].CellValue(1, "bl_no") == sheetObjects[0].CellValue(1, "m_bl_no")) {
					formObj.frm_trsp_tp_id.disabled = true;
				} else {
					formObj.frm_trsp_tp_id.disabled = false;
				}
				//버튼 비활성화
				if (sheetObjects[0].CellValue(1, "t_bdr_flg") == "Y") {
					if (isCA_Usr == "false") {
						setButtonDisabled('bdr');
					} else {
						setButtonDisabled('nbdr');
					}
				} else if (sheetObjects[0].CellValue(1, "t_bdr_flg") == "N") {
					setButtonDisabled('nbdr');
				} else {
					setButtonDisabled('init');
				}
			} else if (tabno == 2) {
				for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
					sheetObjects[2].CellFontColor(i, "cnd_ack_rcv_id") = sheetObjects[2].RgbColor(0, 0, 255);
					sheetObjects[2].CellFontUnderline(i, "cnd_ack_rcv_id") = true;
					sheetObjects[2].CellFontColor(i, "cnd_ack_sub_cd") = sheetObjects[2].RgbColor(0, 0, 255);
					sheetObjects[2].CellFontUnderline(i, "cnd_ack_sub_cd") = true;
					sheetObjects[2].CellFontColor(i, "cstms_rjct_msg") = sheetObjects[2].RgbColor(0, 0, 255);
					sheetObjects[2].CellFontUnderline(i, "cstms_rjct_msg") = true;
					if (sheetObj.CellValue(i, "cnd_ack_sub_cd") == "37" || sheetObj.CellValue(i, "cnd_ack_sub_cd") == "21") {
						sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
					} else if (sheetObj.CellValue(i, "cnd_ack_sub_cd") == "01") {
						sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
					}
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY: //Save
		if (formObj.type.value == "add") {
			sheetObjects[0].DataInsert(1);
			sheetObjects[0].CellValue2(1, "bl_no") = formObj.bl_no.value;
			sheetObjects[1].DataInsert(1);
		}
		if (validateForm(sheetObj, formObj, sAction)) {
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_");
			sheetObjects[0].CellValue2(1, "wgt_ut_cd") = formObj.frm_wgt_ut_cd.Code
			sheetObjects[0].CellValue2(1, "trsp_tp_id") = formObj.frm_trsp_tp_id.Code
			sheetObjects[0].CellValue2(1, "cstms_trsm_sts_cd") = formObj.frm_cstms_trsm_sts_cd.Code;
			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
				//변경된 내역이 없을경우
				ComShowCodeMessage('BKG00743');
				return;
			}
			ComOpenWait(true);
			//저장
			sheetObjects[0].RowStatus(1) = "U";
			sheetObjects[1].RowStatus(1) = "U";
			sParam = ComGetSaveString(sheetObjects) + "&f_cmd=" + MODIFY01;
			sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0029GS.do", sParam);
			// 저장성공메시지
			sheetObj.loadSaveXml(sXml);

			if (ComBkgErrMessage(sheetObjects[0], sXml)) {
				//에러가 없으면 전송여부확인
				if (ComShowCodeConfirm("BKG01023", "A6A", "Canada Customs")) {
					//전송
					doActionIBSheet(sheetObj, formObj, MODIFY02, -1)
				}
				if (formObj.type.value == "add") {
					formObj.type.value = "edit";
					doActionIBSheet(sheetObjects[0], document.form, SEARCH, 1);
				}
			}
			ComOpenWait(false);
		}
		break;
	case REMOVE: //Delete, Reactivate
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			//삭제(Reactivate)
			sheetObj.RowStatus(1) = "U";
			sParam = ComGetSaveString(sheetObj) + "&f_cmd=" + REMOVE;
			sXml = sheetObj.GetSaveXml("ESM_BKG_0029GS.do", sParam);
			sheetObj.loadSaveXml(sXml);

			if (ComBkgErrMessage(sheetObjects[0], sXml)) {
				//에러가 없으면 전송여부확인
				if (ComShowCodeConfirm("BKG01023", "A6A", "Canada Customs")) {
					//전송
					doActionIBSheet(sheetObj, formObj, MODIFY02, -1)
				} else {
					//화면 Reload
					doActionIBSheet(sheetObjects[2], document.form, SEARCH, 1);
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY02: //Transmit
		if (validateForm(sheetObj, formObj, sAction)) {
			sParam = "f_cmd=" + MODIFY02;
			sParam = sParam + "&" + sheetObjects[0].GetSaveString(true);
			// Confirm 메시지 표시여부
			if (tabno != -1) {
				if (ComShowCodeConfirm("BKG01023", "A6A", "Canada Customs")) {
					ComOpenWait(true);
					sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0029GS.do", sParam);
					if (ComBkgErrMessage(sheetObjects[0], sXml)) {
						sheetObj.loadSaveXml(sXml);
						doActionIBSheet(sheetObj, formObj, SEARCH, 1)
					}
					ComOpenWait(false);
				}
			} else {
				sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0029GS.do", sParam);
				sheetObj.loadSaveXml(sXml);
				if (ComBkgErrMessage(sheetObjects[0], sXml)) {
					doActionIBSheet(sheetObj, formObj, SEARCH, 1)
				}
			}
		}
		break;
	case SEARCH03:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH03;
			sXml = sheetObj.GetSearchXml("ESM_BKG_0029GS.do", FormQueryString(formObj));
			if (ComBkgErrMessage(sheetObjects[0], sXml)) {
				var custTp = formObj.cust_tp.value;
				if (custTp == "S") {
					formObj.frm_cust_nm1.value = ComGetEtcData(sXml, "cust_nm");
					formObj.frm_cust_addr1.value = ComGetEtcData(sXml, "cust_addr");
				} else if (custTp == "C") {
					formObj.frm_cust_nm2.value = ComGetEtcData(sXml, "cust_nm");
					formObj.frm_cust_addr2.value = ComGetEtcData(sXml, "cust_addr");
				} else if (custTp == "N") {
					formObj.frm_cust_nm3.value = ComGetEtcData(sXml, "cust_nm");
					formObj.frm_cust_addr3.value = ComGetEtcData(sXml, "cust_addr");
				} else if (custTp == "D") {
					formObj.frm_in_tz_yd_nm.value = ComGetEtcData(sXml, "cust_nm");
					formObj.frm_in_tz_yd_addr.value = ComGetEtcData(sXml, "cust_addr");
					formObj.frm_in_tz_yd_cty_nm.value = ComGetEtcData(sXml, "loc_nm");
					formObj.frm_in_tz_yd_ste_cd.value = ComGetEtcData(sXml, "ste_cd");
					formObj.frm_in_tz_yd_cnt_cd.value = ComGetEtcData(sXml, "cnt_cd");
					formObj.frm_in_tz_yd_zip_id.value = ComGetEtcData(sXml, "zip_cd");
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY03: //Terminal
		if (validateForm(sheetObj, formObj, sAction)) {
			sParam = "f_cmd=" + MODIFY03;
			sParam = sParam + "&" + sheetObjects[0].GetSaveString(true);
			// Confirm 메시지 표시여부
			if (tabno != -1) {
				if (ComShowCodeConfirm("BKG01023", "PA", "Terminal")) {
					ComOpenWait(true);
					sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0029GS.do", sParam);
					if (ComBkgErrMessage(sheetObjects[0], sXml)) {
						sheetObj.loadSaveXml(sXml);
						doActionIBSheet(sheetObj, formObj, SEARCH, 1)
					}
					ComOpenWait(false);
				}
			} else {
				sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0029GS.do", sParam);
				sheetObj.loadSaveXml(sXml);
				if (ComBkgErrMessage(sheetObjects[0], sXml)) {
					doActionIBSheet(sheetObj, formObj, SEARCH, 1)
				}
			}
		}
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
	case SEARCH: //Retrieve, Tab1
		if (ComIsNull(formObj.bl_no)) {
			ComShowMessage('B/L No. is mandatory item.');
			return false;
		}
		if (ComChkLen(formObj.bl_no, 12) != 2) {
			ComShowCodeMessage('BKG00626', 'B/L No.');
			return false;
		}
		break;
	case MODIFY:
		//기본포멧체크
		if (formObj.type.value != "add" && (sheetObjects[0].RowCount <= 0 || sheetObjects[0].CellValue(1, "bl_no") == "")) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		if (formObj.bl_no.value != formObj.frm_m_bl_no.value) {
			if (ComIsNull(formObj.frm_trsp_tp_id.Code)) {
				ComShowMessage('B/L Transporation Type is mandatory item.');
				return false;
			}
		}
		if (!ComChkValid(formObj))
			return false;
		break;
	case MODIFY01:
	case MODIFY02:
	case COMMAND01:
		if (formObj.type.value != "add" && (sheetObjects[0].RowCount <= 0 || sheetObjects[0].CellValue(1, "bl_no") == "")) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		break;
	case SEARCH03:
		if (ComIsNull(formObj.cust_cnt_cd)) {
			ComShowMessage('Country Code is mandatory item.');
			return false;
		}
		if (ComIsNull(formObj.cust_seq)) {
			ComShowMessage('Country Seq. is mandatory item.');
			return false;
		}
		break;
	}
	return true;
}

/**
 * Sheet3 마우스가 Sheet 위에서 움직일 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	var sheetObj = sheetObjects[2];
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	if (row > 1) {
		if (sheetObj.ColSaveName(col) == "cnd_ack_rcv_id") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "ack_desc");
		} else if (sheetObj.ColSaveName(col) == "cnd_ack_sub_cd") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "result_desc");
		} else if (sheetObj.ColSaveName(col) == "cstms_rjct_msg") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "err_cd_desc");
		}
	}
}

/**
 * 버튼 활성화/비활성화
 * @param type 버튼타입
 */
function setButtonDisabled(type) {
	switch (type) {
	case "add":
		ComBtnDisable("btn_Retrieve");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Reactivate");
		ComBtnDisable("btn_Print");
		// ComBtnDisable("btn_ViewMsg");
		document.form.frm_por_cd.readOnly = false;
		document.form.frm_pol_cd.readOnly = false;
		document.form.frm_por_cd.className = "input";
		document.form.frm_pol_cd.className = "input";
		break;
	case "bdr":
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_Print");

		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Reactivate");
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Terminal");
		
		break;
	case "nbdr":
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_Print");
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Transmit");
		ComBtnEnable("btn_Terminal");
		if (sheetObjects[0].CellValue(1, "mf_sts_cd") == "Active") {
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Delete");
			ComBtnDisable("btn_Reactivate");
			
		} else if (sheetObjects[0].CellValue(1, "mf_sts_cd") == "Deleted") {
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnEnable("btn_Reactivate");
		}
		break;
	case "init":
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_Reactivate");
		ComBtnEnable("btn_Print");
		ComBtnEnable("btn_Container");
		ComBtnEnable("btn_CM");
		ComBtnEnable("btn_ViewMsg");
		ComBtnEnable("btn_Transmit");
		ComBtnEnable("btn_Terminal");
		break;
	}
}

/**
 * 자동 다음항목 이동 및 엔터키 입력 시 자동조회
 */
function obj_KeyUp() {
	var formObj = document.form;
	var srcName = event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (event.srcElement.name == "bl_no") {
		ComKeyEnter();
	} else if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
	switch (event.srcElement.dataformat) {
	case "float":
		if (event.keyCode != 9) {
			document.form.elements[srcName].value = toMoney(document.form.elements[srcName].value);
			break;
		}
	}
	if (srcName == "frm_del_cd" && ComChkLen(formObj.frm_del_cd, 5) == 2) {
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0029GS.do", FormQueryString(formObj));
		formObj.frm_hub_loc_cd.value = ComGetEtcData(sXml, "hub_loc_cd");
		formObj.frm_ibd_loc_gds_desc.value = ComGetEtcData(sXml, "ibd_loc_gds_desc");
	}
}

/**
 * 콤마 붙이기
 * @param numString 입력값 
 * @return 천단위 콤마붙인값
 */
function formatCommas(numString) {
	var re = /,|\s+/g;
	numString = numString.replace(re, "");

	re = /(-?\d+)(\d{3})/;
	while (re.test(numString)) {
		numString = numString.replace(re, "$1,$2");
	}
	return numString;
}

/**
 * 콤마 붙이기
 * @param value 입력값 
 * @return 천단위 콤마붙인값
 */
function toMoney(value) {
	var indexOfPoint = value.indexOf(".");
	if (indexOfPoint == -1) {
		value = formatCommas(value);
	} else {
		value = formatCommas(value.substring(0, indexOfPoint)) + value.substring(indexOfPoint, value.length);
	}
	return value;
}

/**
 * 콤보(frm_trsp_tp_id) 변경시 이벤트
 */
function frm_trsp_tp_id_OnChange() {
	document.form.frm_del_cd.focus();
}

/**
 * 콤보(frm_wgt_ut_cd) 변경시 이벤트
 */
function frm_wgt_ut_cd_OnChange() {
	document.form.frm_hub_loc_cd.focus();
}