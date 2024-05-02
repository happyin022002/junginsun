/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0002.js
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
function esm_bkg_0002() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnDblClick = sheet1_OnDblClick;

}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var isCA_Usr;
var sheet2HeadCount;
var vPolCd = "";
var vPodCd = "";
var vCstmsPortCd = "";
var vRow = "";
var intervalId = "";

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
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObject, formObject, MODIFY);
			break;
		case "btn_downexcel":
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_addbl":
			if (validateForm(sheetObjects[1], formObject, COMMAND01)) {
				var row = sheetObjects[0].selectRow;
				var vvd = sheetObjects[0].CellValue(row, "vvd_cd");
				var pol = sheetObjects[0].CellValue(row, "pol_cd");
				var pod = sheetObjects[0].CellValue(row, "pod_cd");
				var eta = sheetObjects[0].CellValue(row, "eta_dt");
				var pgmNo = "pgmNo=ESM_BKG_0029";
				if (isCA_Usr) {
					pgmNo = "pgmNo=ESM_BKG_0029_2";
				}
				ComOpenWindowCenter("/hanjin/ESM_BKG_0029.do?" + pgmNo + "&type=add&vvd=" + vvd + "&pod=" + pod + "&eta=" + eta,
						"0029", 1020, 660);
			}
			break;
		case "btn_editbl":
			if (validateForm(sheetObjects[1], formObject, COMMAND02)) {
				sheet2_OnDblClick(sheetObjects[1], sheetObjects[1].selectRow, 1)
			}
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_terminal":
			document.form.terminal_auto_snd.value = "";
			doActionIBSheet(sheetObject, formObject, MULTI02);
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
 * @param isCA_Usr 캐나다유저 플래그
 */
function loadPage(isCA_Usr) {
	this.isCA_Usr = isCA_Usr
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	document.form.vvd_cd.focus();
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	if (!isCA_Usr) {
//		ComBtnDisable("btn_terminal")
//	}
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
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 120;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "Seq.|VVD|POL|POD|ETA|FROB|Customs|SENT TIME|A6A|CNTR COUNT|B/L COUNT|etl_dt|bdr_flg|Terminal";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq.", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "vvd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "eta_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "frob_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cstms_port_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "mf_snd_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "a6a", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bl_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "etl_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bdr_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pa", false, "", dfNone, 0, false, true);
		}
		break;
	case "sheet2": //sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 270;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "||Seq.|B/L No.|POL|POD|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|SHPR|SHPR|SHPR|SHPR|SHPR|SHPR|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|Booking Container|Booking Container|Booking Container|Booking Container|Container Manifest|Container Manifest|Container Manifest|Container Manifest|EDI|Sent Time||||||";
			var HeadTitle2 = "||Seq.|B/L No.|POL|POD|DEL|HUB|FILER|T/M|PK|WT|LOC OF GOODS|NM|AD|City|State|CNT|ZIP|NM|AD|City|State|CNT|ZIP|NM|AD|City|State|CNT|ZIP|Container|Seal|Rail AMS File No.|P/MIB No.|PK|WT|MK|DS|EDI|Sent Time||||||";
			var headCount = ComCountHeadTitle(HeadTitle1) + 2;

			sheet2HeadCount = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "bl_no2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenterTop, true, "ibflag", false);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "bl_cnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "bl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "del_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "hub_loc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "cstms_file_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "trsp_mod_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "bl_pck_qty", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cgo_wgt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "ibd_loc_gds_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_nm1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_addr1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_cty_nm1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "cust_ste_cd1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_cnt_cd1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_zip_id1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_nm2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_addr2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_cty_nm2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "cust_ste_cd2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_cnt_cd2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_zip_id2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_nm3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_addr3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_cty_nm3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "cust_ste_cd3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_cnt_cd3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cust_zip_id3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seal_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "rail_crr_ref_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "usa_ib_trsp_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "pck_qty", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "grs_wgt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "mk_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "cgo_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "edi", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "sent_time", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "hbl_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "mbl1_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "mbl2_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "mbl3_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "bl_tot_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "error", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "full_mty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenterTop, true, "mh", false, "", dfNone, 0, true, true);
			CountPosition = 0;
		}
		break;
	case 3: //sheet3 init
		with (sheetObj) {// 높이 설정
			style.height = 100;
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
			var HeadTitle = "RESULT";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "key", false, "", dfNone, 0, false, false);
		}
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
	switch (sAction) {
	case SEARCH:
		//초기 조회, 캐나다 유저의 경우 sheet2에도 데이타 뿌림
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			initSheet(sheetObjects[1], 1);
			for (i = 0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].readOnly == true) {
					formObj.elements[i].value = "";
				}
			}
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0002GS.do", FormQueryString(formObj));
			formObj.etl_dt.value = sheetObjects[0].CellValue(1, "etl_dt");
			for (var i=1; i<sheetObj.RowCount+1;i++) {
				sheetObj.CellFont("FontBold", i, 7) = true; 
				sheetObj.CellFont("FontBold", i, 8) = true;
			}
			if (sheetObj.RowCount == 1)
			{
				sheet1_OnDblClick(sheetObj, 1, 1);
			}
			ComOpenWait(false);
		}
		break;

	case MODIFY: //Delete
		if (validateForm(sheetObjects[1], formObj, sAction)) {
			if (ComShowCodeConfirm("BKG00393")) {
				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY;
				var sParam = "bl_no=" + sheetObjects[1].CellValue(sheetObjects[1].selectRow, "bl_no") + "&f_cmd=" + MODIFY;
				var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0002GS.do", sParam);
				if (ComBkgErrMessage(sheetObjects[1], sXml)) {
					var row = sheetObjects[0].SelectRow;
					doActionIBSheet(sheetObjects[0], document.form, SEARCH);
					sheet1_OnDblClick(sheetObjects[0], row, 1);
				}
				ComOpenWait(false);
			}
		}
		break;
	case MULTI: //Transmit
		if (validateForm(sheetObjects[1], formObj, sAction)) {
			ComOpenWait(true);
			var sParam = "f_cmd=" + MULTI;
			var sPreBlNo = "";
			for ( var i = 2; i < sheetObjects[1].RowCount + 2; i++) {
				if (sPreBlNo != sheetObjects[1].CellValue(i, "bl_no")) {
					sParam = sParam + "&bl_no=" + sheetObjects[1].CellValue(i, "bl_no");
					sPreBlNo = sheetObjects[1].CellValue(i, "bl_no");
				}
			}
			ComOpenWait(true, true);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0002GS.do", sParam);
			// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림 3초마다
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		}
		break;
	case MULTI02:
		if (validateForm(sheetObjects[1], formObj, sAction)) {
			var sParam = "f_cmd=" + MULTI + "&type=Terminal&terminal_auto_snd="+formObj.terminal_auto_snd.value;
			var sPreBlNo = "";
			var iCnt = 0;
			for ( var i = 2; i < sheetObjects[1].RowCount + 2; i++) {
				// EMPTY BL은 Terminal 전송안함
				if (sheetObjects[1].CellValue(i, "full_mty_cd") == "M") {
					continue;
				}
				// POD가 CAVAN, CAPRR만 Terminal 전송함.
				if (sheetObjects[1].CellValue(i, "pod_cd") != "CAVAN" 
					&& sheetObjects[1].CellValue(i, "pod_cd") != "CAPRR"
						&& sheetObjects[1].CellValue(i, "pod_cd") != "CAMTR"
							&& sheetObjects[1].CellValue(i, "pod_cd") != "CAHAL") {
					continue;
				}
				if (sPreBlNo != sheetObjects[1].CellValue(i, "bl_no")) {
					sParam = sParam + "&bl_no=" + sheetObjects[1].CellValue(i, "bl_no");
					sPreBlNo = sheetObjects[1].CellValue(i, "bl_no");
					iCnt++;
				}
			}
			if (iCnt == 0) {
				ComShowCodeMessage("BKG01096");
				return;
			}
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0002GS.do", sParam);
			// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림 3초마다
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		}
		break;
	}
	//에러 BL색상표시
	setCellFontColor(sheetObjects[1], sheetObjects[1].RowCount, sheet2HeadCount);
}

 /**
  * 저장을 BackEndJob으로 하기 때문에 저장버튼 클릭 후 완료되었는지 확인하는 로직
  * @param sheetObj 시트오브젝트
  * @param sKey BackEndJob Key
  */
 function doActionValidationResult(sheetObj, sKey) {
 	var sXml = sheetObj.GetSearchXml("ESM_BKG_0002GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
 	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
 	// 에러가 발생했을 경우 대기사항을 종료한다.
 	if (!ComBkgErrMessage(sheetObj, sXml)) {
 		clearInterval(intervalId);
 		ComOpenWait(false);
 		return;
 	}
 	if (sJbStsFlg == "SUCCESS") {
 		clearInterval(intervalId);
 		// 성공메시지 보여주고
 		ComShowMessage(ComResultMessage(sXml));
 		// sheet1, sheet2 다시 조회
 		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
 		sheet1_OnDblClick(sheetObjects[0], vRow, 1);
 		sheetObjects[0].SelectRow = vRow;
 		ComOpenWait(false);
 		return;
 	} else if (sJbStsFlg == "FAIL") {
 		//에러
 		clearInterval(intervalId);
 		// 에러메시지 보여주고
 		ComShowMessage(ComResultMessage(sXml));
 		ComOpenWait(false);
 		return;
 	}
 }
 
/**
 * 저장을 BackEndJob으로 하기 때문에 저장버튼 클릭 후 완료되었는지 확인하는 로직<BR>
 * Terminal자동 전송하기 위해서 새로 만듬
 * @param sheetObj 시트오브젝트
 * @param sKey BackEndJob Key
 */
function doActionValidationResult2(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0002GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		var iCnt = 0;
		for ( var i = 2; i < sheetObjects[1].RowCount + 2; i++) {
			// EMPTY BL은 Terminal 전송안함
			if (sheetObjects[1].CellValue(i, "full_mty_cd") == "M") {
				continue;
			}
			// POD가 CAVAN, CAPRR만 Terminal 전송함.
			if (sheetObjects[1].CellValue(i, "pod_cd") != "CAVAN" 
				&& sheetObjects[1].CellValue(i, "pod_cd") != "CAPRR"
					&& sheetObjects[1].CellValue(i, "pod_cd") != "CAMTR"
						&& sheetObjects[1].CellValue(i, "pod_cd") != "CAHAL") {
				continue;
			}
			iCnt++;
		}
		if (iCnt == 0) {
			clearInterval(intervalId);
			// 성공메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
			// sheet1, sheet2 다시 조회
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			sheet1_OnDblClick(sheetObjects[0], vRow, 1);
			ComOpenWait(false);
		} else {
			// 터미널 전송까지하자.
			clearInterval(intervalId);
			document.form.terminal_auto_snd.value = "A6A_AUTO";
			doActionIBSheet(sheetObjects[0], document.form, MULTI02);
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
		ComOpenWait(false);
		return;
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
	case SEARCH:
		//기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		if (isCA_Usr) {
			if (ComIsEmpty(formObj.pod_cd) && ComIsEmpty(formObj.cstms_port_cd)) {
				ComShowMessage("POD or Customs" + Msg_Required);
				formObj.pod_cd.focus();
				return false;
			}
		}
		break;
	case MODIFY: //Delete
	case COMMAND02: //EDIT BL
		if (sheetObjects[1].RowCount <= 0) {
			ComShowCodeMessage("BKG00395");
			return false;
		}
		break;
	case COMMAND01: //ADD BL
		if (sheetObjects[0].RowCount <= 0) {
			ComShowCodeMessage("BKG00395");
			return false;
		}
		break;
	case MULTI:
		if (sheetObjects[1].RowCount <= 0) {
			ComShowCodeMessage("BKG00395");
			return false;
		}
		if (formObj.error_data.value) {
			if (!ComShowCodeConfirm("BKG00397"))
				return false;
		} else {
			if (!ComShowCodeConfirm("BKG01023", "A6A", "Canada Customs"))
				return false;
		}
		break;
	case MULTI02:
		if (sheetObjects[1].RowCount <= 0) {
			ComShowCodeMessage("BKG00395");
			return false;
		}
		if (!ComShowCodeConfirm("BKG01023", "PA", "Terminal")) {
			return false;
		}
		break;
	}
	return true;
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	ComOpenWait(true);
	var pod_cd = sheetObj.CellValue(row, "pod_cd");
	var pol_cd = sheetObj.CellValue(row, "pol_cd");
	var frob_flg = sheetObj.CellValue(row, "frob_flg");
	var cstms_port_cd = sheetObj.CellValue(row, "cstms_port_cd");

	document.form.f_cmd.value = SEARCH01;
	sheetObjects[1].DoSearch("ESM_BKG_0002GS.do?pol_cd=" + pol_cd + "&pod_cd=" + pod_cd + "&frob_flg=" + frob_flg + "&cstms_port_cd="
			+ cstms_port_cd, FormQueryString(document.form));
	// 에러 BL색상표시
	setCellFontColor(sheetObjects[1], sheetObjects[1].RowCount, sheet2HeadCount);

	vPolCd = pol_cd;
	vPodCd = pod_cd;
	vCstmsPortCd = cstms_port_cd;
	vRow = row;

	if (sheetObjects[1].RowCount > 0) {
		IBS_CopyRowToForm(sheetObjects[1], document.form, 2, "frm_");
		sheet2_OnClick(sheetObjects[1], 2, 1)
	}
	if (!isCA_Usr && sheetObj.CellValue(row, "bdr_flg") == "Y") {
		ComBtnDisable("btn_transmit");
		ComBtnDisable("btn_terminal");
	}
//	if (sheetObj.CellValue(row, "a6a") == "Y") {
//		ComBtnDisable("btn_transmit");
//	} else {
//		ComBtnEnable("btn_transmit");
//	}
//	if (sheetObj.CellValue(row, "pa") == "Y") {
//		ComBtnDisable("btn_terminal");
//	} else {
//		ComBtnEnable("btn_terminal");
//	}
	ComOpenWait(false);
}

/**
 * Sheet2 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet2_OnDblClick(sheetObj, row, col) {
	var bl_no = sheetObjects[1].CellValue(row, "bl_no");
	var params = "?type=edit&bl_no=" + bl_no;
	if (isCA_Usr) {
		params = params + "&pgmNo=ESM_BKG_0029_2";
	} else {
		params = params + "&pgmNo=ESM_BKG_0029";
	}
	ComOpenWindowCenter("/hanjin/ESM_BKG_0029.do" + params, "0029", 1020, 660);
}

/**
 * Sheet1 클릭했을 때 발생하는 이벤트
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet2_OnClick(sheetObj, row, col) {
	/**
	 * 시트를 선택하면 BL No.가 머지되서 선택한 색깔이 제대로 표시되지 않음
	 * BL No.가 같은거는 같은색으로 보이도록 처리함. 초기 바탕색은 흰색
	 */
	var bl_no = sheetObj.CellValue(row, "bl_no")
	for ( var i = 2; i < sheetObj.RowCount + 2; i++) {
		if (sheetObj.CellValue(i, "bl_no") == bl_no) {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(231, 250, 246);
		} else {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 255)
		}
	}
}

/**
 * 에러 BL색상표시
 * @param sheetObj 시트오브젝트
 * @param rowCount Row Count
 * @param colCount Col Count
 * @return
 */
function setCellFontColor(sheetObj, rowCount, colCount) {
	var vErrorData = false;
	for ( var i = 1; i <= rowCount + 1; i++) {
		for ( var j = 1; j <= colCount; j++) {
			if (sheetObj.CellValue(i, j) == "N") {
				sheetObj.CellFontColor(i, j) = sheetObj.RgbColor(255, 0, 0);
				vErrorData = true;
			}
		}
		if (sheetObj.CellValue(i, "mh") == "H") {
			sheetObj.CellFontColor(i, "bl_no") = sheetObj.RgbColor(0, 0, 255);
		}
	}
	if (vErrorData)
		document.form.error_data.value = "true";
}

 /**
  * 조회조건 입력 후 자동으로 다음항목으로 이동
  */
 function obj_KeyUp() {
 	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	 var formObject = document.form;
 	var srcName = window.event.srcElement.getAttribute("name");
 	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	var srcValue = window.event.srcElement.getAttribute("value");
 	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
 		ComSetNextFocus();
 	}
 }