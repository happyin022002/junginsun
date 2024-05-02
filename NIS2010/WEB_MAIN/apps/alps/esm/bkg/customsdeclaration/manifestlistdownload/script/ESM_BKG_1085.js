/*=========================================================
 *Copyright(c) 2017 SM Line
 *@FileName : esm_bkg_1085.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.11.14
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2017.11.14 하대성  두바이 세관 라이브 반영
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
function esm_bkg_1085() {
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

var aryPrefix = new Array("s1_", "s2_"); //prefix 문자열 배열

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
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH, 1);
			break;
		case "btn_New":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObject.reset();
			formObject.vvd.focus();
			formObject.cgo_code.Code2="";
			formObject.du_trd_cd.Code2="";

			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_Edi":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_Excel":
			if (sheetObjects[0].RowCount > 0)
				sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			if (sheetObjects[1].RowCount > 0)
				sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_bl":
			var bl_no = "";
			var pod_cd = "";
			with (sheetObjects[tabObjects[0].selectedIndex]) {
				bl_no = CellValue(SelectRow, aryPrefix[tabObjects[0].selectedIndex] + "bl_no");
				pod_cd = CellValue(SelectRow, aryPrefix[tabObjects[0].selectedIndex] + "pod_cd");
			}
			openBL(bl_no, pod_cd, 0);
			break;
		case "btn_cust":
			var bl_no = "";
			var pod_cd = "";
			with (sheetObjects[tabObjects[0].selectedIndex]) {
				bl_no = CellValue(SelectRow, aryPrefix[tabObjects[0].selectedIndex] + "bl_no");
				pod_cd = CellValue(SelectRow, aryPrefix[tabObjects[0].selectedIndex] + "pod_cd");
			}
			openBL(bl_no, pod_cd, 1);
			break;
		case "btn_Unit":
			ComOpenWindowCenter("/hanjin/ESM_BKG_1086.do?pgmNo=ESM_BKG_1086", "1086", 500, 470, true);
			break;
		case "btn_calendar":
			var cal = new ComCalendar();
			cal.select(formObject.eta_dt, 'yyyy-MM-dd');
			break;
		case "data_type":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
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
 */
function loadPage() {

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
	doActionIBSheet(sheetObjects[0], document.form, INIT, 1);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComBtnDisable('btn_bl');
	ComBtnDisable('btn_cust');
	document.form.vvd.focus();
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
			style.height = 330;
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

			var HeadTitle1 = "|Sel.|Rotation No.|B/L No.|Line\nCode|Agent\nCode|POR|POL|POD|DEL|Trade\nCode|Cargo\nCode|Console\nIND|Origin\nCountry|CNEE\nName|CNEE\nAddress|COMM\nCode|PKG\nQTY|PKG\nTP|PKG\nTP|Cargo\nWeight|Gross\nWeight";
			var headCount = ComCountHeadTitle(HeadTitle1) + 11;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, aryPrefix[0] + "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, aryPrefix[0] + "chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, aryPrefix[0] + "du_rotn_no", false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, aryPrefix[0] + "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, aryPrefix[0] + "du_line_id", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[0] + "du_voy_agn_id", false, "", dfNone, 0, true, true, 6);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[0] + "por_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[0] + "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[0] + "pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[0] + "del_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtCombo, 100, daLeft, true, aryPrefix[0] + "du_trd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 100, daLeft, true, aryPrefix[0] + "du_cgo_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, aryPrefix[0] + "cnsl_cgo_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, aryPrefix[0] + "org_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, aryPrefix[0] + "cust_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, aryPrefix[0] + "cust_addr", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, aryPrefix[0] + "du_cmdt_cd", false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, aryPrefix[0] + "pck_qty", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[0] + "du_pck_tp_cd", false, "", dfNone, 0, true, true, 3, true);
			InitDataProperty(0, cnt++, dtImageText, 20, daCenter, true, aryPrefix[0] + "du_pck_tp_cd2", false, "", dfNone, 0, true, true, 3, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, aryPrefix[0] + "cgo_wgt", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, aryPrefix[0] + "grs_wgt", false, "", dfNullFloat, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "eta_dt");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "vsl_nm");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "vsl_cd");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "clpt_seq");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "v_du_rotn_no");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "du_instl_no");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "bkg_cust_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[0] + "du_mrn_no");
			
			InitDataCombo(0, aryPrefix[0] + "cnsl_cgo_flg", "Y|N", "Y|N")

			InitDataValid(0, aryPrefix[0] + "du_line_id", vtEngUpOther, "1234567890");
			InitDataValid(0, aryPrefix[0] + "du_voy_agn_id", vtEngUpOther, "1234567890");
			InitDataValid(0, aryPrefix[0] + "org_cnt_cd", vtEngUpOnly);
			InitDataValid(0, aryPrefix[0] + "du_pck_tp_cd", vtEngUpOnly);
			InitDataValid(0, aryPrefix[0] + "du_cmdt_cd", vtNumericOnly);
			
			ImageList(0) = "img/btns_search.gif";
			InitDataImage(0,aryPrefix[0] + "du_pck_tp_cd2", daRight);
		}
		break;
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 330;
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

			var HeadTitle1 = "|Seq.|B/L No.|POD|CNTR No.|Tare\nWGT|Seal|Serial\nNo.|Marks &\nNumber|Cargo Description|CMDT\nCode|PKG|PKG\nTP|PKG\nTP|No of\nPallets|Weight|Measure|DG|IMO\nClass|UN\nNumber|Flash\nPoint|Temp.\nUnit|Strorage\nReq.|Rf\nReq.|Min\nTemp|Max\nTemp|Temp.\nUnit";
			var headCount = ComCountHeadTitle(HeadTitle1) + 2;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 5, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, aryPrefix[1] + "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, aryPrefix[1] + "", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, aryPrefix[1] + "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, aryPrefix[1] + "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, aryPrefix[1] + "cntr_tare_wgt", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, aryPrefix[1] + "cntr_seal_no", false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, aryPrefix[1] + "du_cntr_ser_no", false, "", dfNullInteger, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, aryPrefix[1] + "cntr_mf_mk_desc", false, "", dfNone, 0, true, true, 4000);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, aryPrefix[1] + "cntr_mf_gds_desc", false, "", dfNone, 0, true, true, 400);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, aryPrefix[1] + "cmdt_hs_cd", false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, aryPrefix[1] + "pck_qty", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtImageText, 40, daCenter, true, aryPrefix[1] + "du_pck_tp_cd", false, "", dfNone, 0, true, true, 3, true);
			InitDataProperty(0, cnt++, dtImageText, 20, daCenter, true, aryPrefix[1] + "du_pck_tp_cd2", false, "", dfNone, 0, true, true, 3, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, aryPrefix[1] + "plt_qty", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, aryPrefix[1] + "cntr_mf_wgt", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, aryPrefix[1] + "meas_qty", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, aryPrefix[1] + "dcgo_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "imdg_clss_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "imdg_un_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "flsh_pnt_cdo_temp", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "dcgo_temp_ut_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, aryPrefix[1] + "dg_sto_req_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, aryPrefix[1] + "rfrt_req_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "min_temp", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "max_temp", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, aryPrefix[1] + "cgo_temp_ut_cd", false, "", dfNone, 0, true, true, 1);
			
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[1] + "cntr_mf_seq");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, aryPrefix[1] + "bkg_no");
			
			InitDataCombo(0, aryPrefix[1] + "dcgo_flg", "Y|N", "Y|N");
			InitDataCombo(0, aryPrefix[1] + "dg_sto_req_flg", "Y|N", "Y|N");
			InitDataCombo(0, aryPrefix[1] + "rfrt_req_flg", "Y|N", "Y|N");
			
			InitDataValid(0, aryPrefix[1] + "cntr_seal_no", vtEngUpOther, "1234567890");
			InitDataValid(0, aryPrefix[1] + "cmdt_hs_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, aryPrefix[1] + "du_pck_tp_cd", vtEngUpOnly);

			ImageList(0) = "img/btns_search.gif";
			InitDataImage(0,aryPrefix[1] + "du_pck_tp_cd2", daRight);
		}
		break;
	case "sheet3":
		with (sheetObj) {
            // 높이 설정
            style.height = 0;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            //var HeadTitle = "|vvd_cd|pol_cd|pod_cd|line_cd|flatFile";
            var HeadTitle = "flatFile";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,	100, daLeft, false,	"flat_file");
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
			InsertTab(cnt++, "B/L List", -1);
			InsertTab(cnt++, "Container List", -1);
//			InsertTab(cnt++, "Vessel", -1);
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
	//
	formObj.f_cmd.value = sAction;
	switch (sAction) {
	case INIT:
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1085GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		// DUBAI TRADE CODE
		var arrCombo1 = ComXml2ComboString(arrXml[0], "name", "val") ;
		
		arrCombo1[0] = " |" + arrCombo1[0];
		arrCombo1[1] = " |"  + arrCombo1[1];
		sheetObjects[0].InitDataCombo(0, aryPrefix[0] + "du_trd_cd", arrCombo1[0], arrCombo1[1]);
		// DUBAI CARGO CODE
		var arrCombo2 = ComXml2ComboString(arrXml[1], "desc", "val");
		arrCombo2[0] = " |" + arrCombo2[0];
		arrCombo2[1] = " |"  + arrCombo2[1];
		sheetObjects[0].InitDataCombo(0, aryPrefix[0] + "du_cgo_cd", arrCombo2[0], arrCombo2[1]);
		// DUBAI PACKAGE TYPE CODE
//		var arrCombo3 = ComXml2ComboString(arrXml[2], "name", "val");
//		arrCombo3[0] = " |" + arrCombo3[0];
//		arrCombo3[1] = " |"  + arrCombo3[1];
//		sheetObjects[0].InitDataCombo(0, aryPrefix[0] + "du_pck_tp_cd", arrCombo3[0], arrCombo3[1]);
//		sheetObjects[1].InitDataCombo(0, aryPrefix[1] + "du_pck_tp_cd", arrCombo3[0], arrCombo3[1]);
		// 조회조건  DUBAI CARGO CODE
	
		ComXml2ComboItem(arrXml[1], formObj.cgo_code, "val", "val|desc");
		formObj.cgo_code.InsertItem(0, "|", "");
		
		
		ComXml2ComboItem(arrXml[0], formObj.du_trd_cd,  "val", "val|name");
		formObj.du_trd_cd.InsertItem(0, "A|ALL", "A");
		break;
	case SEARCH: //Retrieve, Tab1
		
		if (validateForm(sheetObj, formObj, sAction)) {
			
			ComOpenWait(true);
			formObj.sheet_no.value = tabno;
						
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1085GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			if (sheetObjects[0].RowCount > 0) {
				formObj.vvd_nm.value = sheetObjects[0].CellValue(1, aryPrefix[0] + "vsl_nm");
				formObj.eta_dt.value = sheetObjects[0].CellValue(1, aryPrefix[0] + "eta_dt");
				formObj.rotn_no.value = sheetObjects[0].CellValue(1, aryPrefix[0] + "v_du_rotn_no");
				formObj.instl_no.value = sheetObjects[0].CellValue(1, aryPrefix[0] + "du_instl_no");
				formObj.mrn_no.value = sheetObjects[0].CellValue(1, aryPrefix[0] + "du_mrn_no");
				// 
				if (formObj.data_type[0].checked) {
					ComBtnDisable('btn_bl');
					ComBtnDisable('btn_cust');
					ComBtnDisable('btn_Edi');
				} else {
					ComBtnEnable('btn_bl');
					ComBtnEnable('btn_cust');
					ComBtnEnable('btn_Edi');
				}
			} else {
				if (formObj.data_type[1].checked) {
					if (ComShowCodeConfirm("BKG95003", "retrieve B/L data")) {
						formObj.data_type[0].checked = true;
						doActionIBSheet(sheetObj, formObj, COMMAND02, 1);
						doActionIBSheet(sheetObj, formObj, SEARCH, 1);
					}
				}
				ComBtnDisable('btn_bl');
				ComBtnDisable('btn_cust');
				ComBtnDisable('btn_Edi');
			}
			for(var i = 1; i<sheetObjects[0].RowCount+1 ;i++) {
				sheetObjects[0].CellImage(i,aryPrefix[0]+"du_pck_tp_cd2") = 0;
				sheetObjects[0].CellFont("FontUnderline", i, aryPrefix[0]+"bl_no") = true;
			}
			for(var i = 1; i<sheetObjects[1].RowCount+1 ;i++) {
				sheetObjects[1].CellImage(i,aryPrefix[1]+"du_pck_tp_cd2") = 0;
				sheetObjects[1].CellFont("FontUnderline", i, aryPrefix[1]+"bl_no") = true;
			}
			if (formObj.data_type[1].checked) {
				sheetObj.CheckAll(aryPrefix[0] + "chk") = 1;
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND02:
		if (formObj.data_type[0].checked) {
			document.getElementById("cgo1").style.display = "block";
			document.getElementById("cgo2").style.display = "none";
		} else {
			document.getElementById("cgo1").style.display = "none";
			document.getElementById("cgo2").style.display = "block";
		}
		break;
	case MULTI: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			var sParam = "";
			if (formObj.data_type[0].checked) {
				formObj.f_cmd.value = MULTI01;
				sParam = FormQueryString(formObj) 
				+ "&" + sheetObjects[0].GetSaveString(true)
				+ "&" + sheetObjects[1].GetSaveString() 
				+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1085GS.do", sParam);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					// 저장성공메시지
					sheetObj.loadSaveXml(sXml);
					formObj.data_type[1].checked = true;
					doActionIBSheet(sheetObj, formObj, COMMAND02, 1);
					doActionIBSheet(sheetObj, formObj, SEARCH, 1);
					sheetObj.CheckAll(aryPrefix[0] + "chk") = 1;
				}
			} else {
				formObj.f_cmd.value = MULTI02;
				sParam = FormQueryString(formObj) 
				+ "&" + sheetObjects[0].GetSaveString()
				+ "&" + sheetObjects[1].GetSaveString() 
				+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1085GS.do", sParam);
				sheetObj.loadSaveXml(sXml);
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND01: // EDI File Download
		if(validateForm(sheetObj,formObj,sAction)) {
			// 파일명
			var savedFileName = "";
			if (formObj.bl_no.value != "") {
				savedFileName = formObj.bl_no.value;
			} else {
				savedFileName = formObj.vvd.value + "_"+ formObj.pod_cd.value;
			}
			formObj.f_cmd.value = COMMAND01;
			ComOpenWait(true);
			for(var i=1; i<=sheetObj.RowCount; i++) {
				if(sheetObj.CellValue(i, "s1_chk") == 1) {
					sheetObj.RowStatus(i) = "U";
				} else {
					sheetObj.RowStatus(i) = "";
				}
			}
			var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
			sheetObjects[2].DoSearch("ESM_BKG_1085GS.do", sParam)
			ComOpenWait(false);
			sheetObjects[2].Down2Text("", "", "", savedFileName, "c:\\flatFile\\", "", false, false, true);
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
		if (!ComChkValid(formObj))
			return false;
		if (ComIsNull(formObj.bl_no) && (ComIsNull(formObj.vvd) || ComIsNull(formObj.pod_cd)) ) {
			ComShowCodeMessage('BKG00701','VVD & POD or B/L No.');
			formObj.vvd.focus();
			return false;
		}
		break;
	case MULTI:
		for (var i=1; i<sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, aryPrefix[0] + "cust_nm").length > 48)
			{
				ComShowCodeMessage('BKG00107', 'CNEE Name [maximum:48]');
				sheetObj.SelectCell(i, aryPrefix[0] + "cust_nm");
				return false;
			}
			if (sheetObj.CellValue(i, aryPrefix[0] + "cust_addr").length > 240)
			{
				ComShowCodeMessage('BKG00107', 'CNEE Address [maximum:240]');
				sheetObj.SelectCell(i, aryPrefix[0] + "cust_addr");
				return false;
			}
		}
		if (formObj.data_type[1].checked) {
			sheetObjects[0].CellValue2(1, aryPrefix[0] + "eta_dt") = formObj.eta_dt.value;
			sheetObjects[0].CellValue2(1, aryPrefix[0] + "du_rotn_no") = formObj.rotn_no.value;
			sheetObjects[0].CellValue2(1, aryPrefix[0] + "du_instl_no") = formObj.instl_no.value;
			sheetObjects[0].CellValue2(1, aryPrefix[0] + "du_mrn_no") = formObj.mrn_no.value;
			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
				ComShowCodeMessage('BKG00743');
				return false;
			}
		}
		if (!ComShowCodeConfirm("BKG00824")) {
			return false;
		}
		break;
	case COMMAND01:
		if (sheetObjects[0].CheckedRows(aryPrefix[0] + "chk") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		if (!ComShowCodeConfirm("BKG00447")) {
			return false;
		}
		break;
	}
	return true;
}

/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @return
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	switch (sheetObj.ColSaveName(col)) {
	case aryPrefix[0] + "cust_addr":
		sheetObj.CellEditable(row, col) = false;
		ComShowMemoPad(sheetObj, row, col, false, 250, 100);
		sheetObj.CellEditable(row, col) = true;
		break;
	case aryPrefix[0] + "du_pck_tp_cd2":
		var du_pck_tp_cd = ComOpenWindowCenter("ESM_BKG_1086.do?select=true", "1086" , 500, 470, true);
		if (du_pck_tp_cd == undefined || du_pck_tp_cd == null) break;
		sheetObj.CellValue2(row, aryPrefix[0] + "du_pck_tp_cd") = du_pck_tp_cd;
		break;
	}
}

/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @return
 */
function sheet2_OnClick(sheetObj, row, col, value) {
	switch (sheetObj.ColSaveName(col)) {
	case aryPrefix[1] + "du_pck_tp_cd2":
		var du_pck_tp_cd = ComOpenWindowCenter("ESM_BKG_1086.do?select=true", "1086" , 500, 470, true);
		if (du_pck_tp_cd == undefined || du_pck_tp_cd == null) break;
		sheetObj.CellValue2(row, aryPrefix[1] + "du_pck_tp_cd") = du_pck_tp_cd;
		break;
	case aryPrefix[1] + "cntr_mf_mk_desc":
		sheetObj.CellEditable(row, col) = false;
		ComShowMemoPad(sheetObj, row, col, false, 300, 100);
		sheetObj.CellEditable(row, col) = true;
		break;
	case aryPrefix[1] + "cntr_mf_gds_desc":
		sheetObj.CellEditable(row, col) = false;
		ComShowMemoPad(sheetObj, row, col, false, 350, 100);
		sheetObj.CellEditable(row, col) = true;
		break;
	}
}
/**
 * 마우스 올릴때
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if (sheetObj.ColSaveName(sheetObj.MouseCol) == aryPrefix[0] + "bl_no") {
		sheetObj.MousePointer = "Hand";
	} else {
		sheetObj.MousePointer = "Default";
	}
}

/**
 * 마우스 올릴때
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if (sheetObj.ColSaveName(sheetObj.MouseCol) == aryPrefix[1] + "cntr_no") {
		sheetObj.MousePointer = "Hand";
	} else {
		sheetObj.MousePointer = "Default";
	}
}

/**
 * 시트1 변경시 이벤트
 * @param sheetObj 시트오브젝트
 * @param Row Row Index
 * @param Col Col Index
 * @param Value 변경값
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Value != "" && sheetObj.ColSaveName(Col) == aryPrefix[0] + "du_pck_tp_cd") {
		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1085GS.do"
				+ "?attr_ctnt1=" + sheetObj.CellValue(Row, aryPrefix[0] + "du_pck_tp_cd")
				+ "&f_cmd=" + SEARCH02);
		if (ComGetEtcData(sXml, "du_pck_tp_cd") == "")
		{
			ComShowCodeMessage('BKG00530');
			sheetObj.CellValue2(Row, aryPrefix[0] + "du_pck_tp_cd") = "";
			sheetObj.SelectCell(Row, aryPrefix[0] + "du_pck_tp_cd");
			return;
		}
	}
}

/**
 * 시트1 변경시 이벤트
 * @param sheetObj 시트오브젝트
 * @param Row Row Index
 * @param Col Col Index
 * @param Value 변경값
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	if (Value != "" && sheetObj.ColSaveName(Col) == aryPrefix[1] + "du_pck_tp_cd") {
		var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_1085GS.do"
				+ "?cstms_pck_tp_cd=" + sheetObj.CellValue(Row, aryPrefix[1] + "du_pck_tp_cd")
				+ "&f_cmd=" + SEARCH02);
		if (ComGetEtcData(sXml, "du_pck_tp_cd") == "")
		{
			ComShowCodeMessage('BKG00530');
			sheetObj.CellValue2(Row, aryPrefix[1] + "du_pck_tp_cd") = "";
			sheetObj.SelectCell(Row, aryPrefix[1] + "du_pck_tp_cd");
			return;
		}
	}
}
 
/**
 * B/L Detail Open
 * @param bl_no
 * @param tabIndex
 * @return
 */
function openBL(bl_no, pod_cd, tabIndex) {
	ComOpenWindowCenter("/hanjin/ESM_BKG_1087.do?pgmNo=ESM_BKG_1087"
			+"&bl_no="+bl_no
			+"&pod_cd="+pod_cd
			+"&tabIndex=" + tabIndex, "1087", 900, 620, true);
}

/**
 * 자동 다음항목 이동 및 엔터키 입력 시 자동조회
 */
function obj_KeyUp() {
	var formObj = document.form;
	var srcName = event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 더블클릭시
 * @param sheetObj
 * @param row
 * @param col
 * @return
  */
function sheet1_OnDblClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == aryPrefix[0] + "bl_no") {
		//2010.04.10 모달 작업
		var sParam = "pgmNo=ESM_BKG_0079&openTab=B9&bkg_no=" + sheetObj.CellValue(row, aryPrefix[0] + "bkg_no");
		
		
		ComOpenWindowCenter("ESM_BKG_0079.do?" + sParam, "ESM_BKG_0079", 1024, 650,true);
		
	}
}

/**
* 더블클릭시
* @param sheetObj
* @param row
* @param col
* @return
 */
function sheet2_OnDblClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == aryPrefix[1] + "bl_no") {
		var sParam = "&bkg_no=" + sheetObj.CellValue(row, aryPrefix[1] + "bkg_no");
		
		comBkgCallPopBkgDetail(sheetObj.CellValue(row, aryPrefix[1] + "bkg_no"));
	}
}