/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0933.js
 *@FileTitle : ESM_BKG_0933
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
 * 1.0 Creation
 * 2014.10.01 이한나[CHM-201432082] (KOR) CLL의 Speicial Cargo detail 화면의 BS Code 칼럼 추가 요청
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
 * @class ESM_BKG_0933 : ESM_BKG_0933 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0933() {
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

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		// alert(srcName);
		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_Print":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			// alert(srcName);
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
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(24, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Seq.|CGO TYPE|BKG No.|TS|POD|BLCK\nSTWG|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID(FEU)|STOW|";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "bkg_no2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "cgo_type", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenterTop, true, "bkg_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "ts",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_bs",
					false, "", dfNone, 0, false, false); // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "blck_stwg_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wgt", 
					false, "", dfNullFloatOrg, 1, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "class_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "unno",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "temp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vent",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "remark",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vo_id",
					false, "", dfNullFloatOrg, 1, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stow",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true,
					"mty_bkg_cd", false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
	case "sheet2": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 180;
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
			InitRowInfo(2, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "POD|BLCK\nSTWG|DG|DG|DG|RF|RF|RF|AK|AK|AK|BB|BB|BB";
			var HeadTitle2 = "POD|BLCK\nSTWG|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtAutoSum, 135, daCenter, true,
					"pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daCenter, true, "bkg_bs",
					false, "", dfNone, 0, false, false);  // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb4",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb45",
					false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
	case "sheet4": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
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

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "Seq.|CGO TYPE|BKG No.|TS|POD|BLCK\nSTWG|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID|STOW|";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "cgo_type", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "ts",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_bs",
					false, "", dfNone, 0, false, false); // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "blck_stwg_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs1",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tp", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wgt", false,
					"", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "class_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "unno",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lq", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "temp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vent",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "remark",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vo_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stow",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true,
					"mty_bkg_cd", false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
	case "sheet3": // sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 200;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge + msHeaderOnly;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 2, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(7, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false, false);

		var HeadTitle1 = "CGO TYPE|POD|BLCK\nSTWG|MLB|CNTR|TYPE|DETAIL";
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_cgo_type",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_pod",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_bkg_bs",
				false, "", dfNone, 0, false, false);   // 2014.10.01 CHM-201432082
		InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "e_mlb",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "e_cntr_no",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_tp",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_detail",
				false, "", dfNone, 0, false, false);

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
	switch (sAction) {

	case IBSEARCH: // 조회

		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;	
		sheetObjects[1].WaitImageVisible = false;	
		ComOpenWait(true);
		var inByType = "";
		if (formObj.in_by_type_temp(0).checked)
			inByType = "ALL";
		else if (formObj.in_by_type_temp(1).checked)
			inByType = "LOCAL";
		else if (formObj.in_by_type_temp(2).checked)
			inByType = "TS";

		formObj.in_by_type.value = inByType;
		// alert();
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0933GS.do",
				FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			sheetObjects[2].LoadSearchXml(arrXml[2]);
			sheetObjects[3].LoadSearchXml(arrXml[0]);
		}
			
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
			var cntrNo = "";
			for ( var i = 1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "seq") == "") {
					sheetObj.RowEditable(i) = false;
				}
				if (sheetObj.CellValue(i, "tp") == "D2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d2 = d2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "D4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d4 = d4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "D5") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d5 = d5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "D7") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d7 = d7 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "D8") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d8 = d8 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "D9") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d9 = d9 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "DW") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						dw = dw + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "DX") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						dx = dx + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "R2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						r2 = r2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "R4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						r4 = r4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "R5") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						r5 = r5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "F2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						f2 = f2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "F4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						f4 = f4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "F5") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						f5 = f5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "O2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						o2 = o2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "O4") {
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						o4 = o4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "O5") {
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						o5 = o5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "O7") {
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						o7 = o7 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "S2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						s2 = s2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "S4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						s4 = s4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "T2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						t2 = t2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "T4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						t4 = t4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "A2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						a2 = a2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
					}
					wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
				}
				else if (sheetObj.CellValue(i, "tp") == "A4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						a4 = a4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "A5") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						a5 = a5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "P2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						p2 = p2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "P4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						p4 = p4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "Z2") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						z2 = z2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "Z4") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						z4 = z4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "D3") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						d3 = d3 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObj.CellValue(i, "tp") == "R9") {
					
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						r9 = r9 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
						wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
					}
					
				}
				else {
					if (sheetObj.CellValue(i, "tp") != ""){
						if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
							etc = etc + 1;
							totalTpSize = totalTpSize + 1;
							cntrNo = sheetObj.CellValue(i, "cntr_no");
							wgt = wgt + sheetObj.CellValue(i, "wgt") * 1;
						}
					}
				}

			}
			
			cntrNo = "";
			for ( var i = 1; i <= sheetObj.RowCount; i++) {
				
				if (sheetObj.CellValue(i, "ts") == "TS"
					|| sheetObj.CellValue(i, "ts") == "TT") {
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						ts = ts + 1;
						if (sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
					}
				}
				if (sheetObj.CellValue(i, "ts") == ""
						&& sheetObj.CellValue(i, "seq") != "") {
					if (cntrNo != sheetObj.CellValue(i, "cntr_no")) {
						local = local + 1;
						if (sheetObj.CellValue(i, "mty_bkg_cd") == "F")
							localFull = localFull + 1;
						else
							localEmpty = localEmpty + 1;
						cntrNo = sheetObj.CellValue(i, "cntr_no");
					}
				}				
			}
			//alert(wgt);
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
				if (sheetObj.CellValue(i, "tp") == "") {
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(192, 192, 192);
				}
			}
		}
		ComOpenWait(false);
		break;

	case COMMAND01: // 입력
		// alert("111");
		ComOpenWindowCenter("/hanjin/ESM_BKG_5008.do?pgmNo=ESM_BKG_5008",
				"5008", 1020, 660, false);

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
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

/**
 * gubun값에 따라 조회 방법 변경
 */
function goBySearch(gubun) {

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 새로 조회
 */
function goSearch() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/* 개발자 작업 끝 */