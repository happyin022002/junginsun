/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0613.js
 *@FileTitle : US Manifest Transmit(MI)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.05.25 김도완
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.06.21 민정호 [CHM-201111495] ACE MI PILOT TEST를 위한 MI 전송 로직 수정 요청 (TEST VERSION ONLY)
 * 2011.10.12 윤태승 [CHM-201113684-01][ESB_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
 * 2013.04.02 김보배 [CHM-201323809] [BKG] [US AMS] MI 전송 화면 & Transmission & receiving history 화면 보완
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0613() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 현재화면에서 사용하는 전역변수.
var deleteRowIndex = -1;
var MISENT = "";
var intervalId = "";

var userAuthMiMultiStr = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	
	/** **************************************************** */
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			break;
		
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		
		case "btn_downexcel":
			sheetObject.SpeedDown2Excel(-1);
			sheetObject1.SpeedDown2Excel(-1);
			break;
		
		case "btn_Add_BL":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
			break;
		
		case "btn_Edit_BL":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
			break;
		
		case "btn_Transmit":
		case "btn_Transmit_e":
			doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
			break;
		case "btn_OfmGeneration":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND04);
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
 */
function setSheetObject(sheet_obj) {
	
	sheetObjects[sheetCnt++] = sheet_obj;
	
}

/**
 * 조회조건 입력할 때 처리
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
	// 화면 로딩 시에는 Transmit (Full) 버튼으로 초기화 
	ComSetDisplay("btn_Transmit", true);
	ComSetDisplay("btn_Transmit_e", false);

	doActionIBSheet(sheetObjects[0], document.form, INIT);
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'chkChange2', document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	document.form.vvd.focus();
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	
	ComBtnDisable("btn_Add_BL");
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
			style.height = 140;
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
			InitRowInfo(1, 1, 2, 100);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(16, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|VVD|POL|POD|ETA|FROB|Customs|SENT TIME|MI|CNTR COUNT|B/L COUNT|||||";
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			var prefix = "sheet1_";
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, prefix + "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "pol", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "pod", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, prefix + "eta", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "frob", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "customs", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, prefix + "sent_time", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "mi", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, prefix + "cntr_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, prefix + "bl_count", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, prefix + "mbl_count01", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, prefix + "mbl_count02", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, prefix + "mbl_count03", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, prefix + "hbl_count", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, prefix + "bdr_count", false, "", dfNone, 0, true, true);
			
		}
		break;
	
	case 2: //sheet2 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 242;
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
			InitRowInfo(2, 1, 2, 100);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(27, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|Seq.|B/L No.||POL|POD|||B/L|B/L|B/L|B/L|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|Booking Container|Booking Container|Container Manifest|Container Manifest|Container Manifest|Container Manifest|cgo_tp_cd";
			var HeadTitle2 = "|Seq.|B/L No.||POL|POD|||DEL|FILER|PK|WT|NM|AD|NM|AD|NM|AD|Number|Seal|PK|WT|MK|DS|cgo_tp_cd";
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			var prefix = "sheet2_";
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, prefix + "ibflag");
			
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, prefix + "row_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenterTop, true, prefix + "bl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "dummy", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, prefix + "pol", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenterTop, true, prefix + "pod", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, prefix + "transmit_cd", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, prefix + "full_mty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "del", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, prefix + "filer", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "pk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "wt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "shpr_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "shpr_ad", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "cnee_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "cnee_ad", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "ntfy_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "ntfy_ad", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "cntr_no", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "seal", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "cntr_pk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "cntr_wt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "cntr_mk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix + "cntr_ds", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, prefix + "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, prefix + "eta", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, prefix + "cgo_tp_cd", false, "", dfNone, 0, true, true);
			
			CountPosition = 0;
			
			MultiSelection = false;
			
		}
		break;
	// Ofm Text 저장을 위한 시트.
	case 3: //sheet3 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 100;
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
			InitRowInfo(1, 1, 2, 100);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(2, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|";
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			var prefix = "sheet3_";
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "flat_file", false, "", dfNone, 0, false, false);
		}
		break;
	
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, row) {
	sheetObj.ShowDebugMsg = false;
	var pgmNo = formObj.pageNo.value;
	if (pgmNo == null || pgmNo == "")
		pageNo = "ESM_BKG_0613";
	var blInqueryPgmNo = "ESM_BKG_0034-01";
	if (pgmNo == "ESM_BKG_0613_2") {
		blInqueryPgmNo = "ESM_BKG_0034-03";
	}
	switch (sAction) {
	case INIT:

		formObj.f_cmd.value = INIT;
		if ("sheet1" == sheetObj.id) {
			
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			var userAuthStr = ComGetEtcData(sXml, "user_auth_str");
			userAuthMiMultiStr = ComGetEtcData(sXml, "user_auth_mi_multi_str");
			
			// alert("userAuthStr : " + userAuthStr);
			
			// OFM List Retrieve, Preparation 버튼 활성권한 셋업.
			if (userAuthStr == "Y") {
				ComBtnEnable("btn_OfmGeneration");
			} else {
				ComBtnDisable("btn_OfmGeneration");
			}
		}
		break;
	case SEARCH01: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH01;
		formObj.search_mtd.value = "Summary";
		if ("sheet1" == sheetObj.id) {
			sheetObj.DoSearch("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			sheetObjects[1].removeAll();
			deleteRowIndex = -1;
		}
		formObj.totbl.value = "";
		formObj.hbl01.value = "";
		
		formObj.mbl01.value = "";
		formObj.mbl02.value = "";
		formObj.mbl03.value = "";
		break;
	
	case SEARCH02: //조회
		var sheetObject2 = sheetObjects[1];
		formObj.f_cmd.value = SEARCH01;
		formObj.search_mtd.value = "Detail";
		var fEval = formObj.full_empty.value;
		var miVal = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_mi");
		var bdrVal = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_bdr_count");
		MISENT = miVal;
		var host = location.host;
		
		/*
		 * 2010년 8월 6일 경종윤
		 * 조회 조건중 EMPTY일 경우도 Transmit버튼을 활성화 시키도록 해당 부분 주석처리함
		 */
//		if (fEval == "E") {
//			ComBtnDisable("btn_Transmit");
//		} else {
			if (miVal == "Y") {
				if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
					ComBtnEnable("btn_Transmit");			// 개발
					ComBtnEnable("btn_Transmit_e");			// 개발
				}else{
					if (location.href.indexOf("alpsdev") > -1 ){
						ComBtnEnable("btn_Transmit");			// 개발
						ComBtnEnable("btn_Transmit_e");			// 개발
					}else{
						ComBtnDisable("btn_Transmit");			// 운영
						ComBtnDisable("btn_Transmit_e");			// 운영
					}
				}
			} else {
				if (pgmNo == "ESM_BKG_0613" && eval(bdrVal) > 0) {
					if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
						ComBtnEnable("btn_Transmit");				// 개발
						ComBtnEnable("btn_Transmit_e");				// 개발
					}else{
						if (location.href.indexOf("alpsdev") > -1 ){
							ComBtnEnable("btn_Transmit");			// 개발
							ComBtnEnable("btn_Transmit_e");			// 개발
						}else{
							ComBtnDisable("btn_Transmit");			// 운영
							ComBtnDisable("btn_Transmit_e");			// 운영
						}
					}					
				} else {
					ComBtnEnable("btn_Transmit");
					ComBtnEnable("btn_Transmit_e");
				}
			}
			
			if (userAuthMiMultiStr == "Y") {
				ComBtnEnable("btn_Transmit");
				ComBtnEnable("btn_Transmit_e");
			}
//		}
		
		// double click한 row의 값으로 form의 object들을 임시로 셋업 한후, FormQueryString 작성이 끝나면 본래 값으로 되돌린다.
		var temp_vvd = formObj.vvd.value;
		var temp_pol = formObj.pol.value;
		var temp_pod = formObj.pod.value;
		var temp_customs = formObj.customs.value;
		
		formObj.vvd.value = sheetObj.CellValue(row, "sheet1_vvd");
		formObj.pol.value = sheetObj.CellValue(row, "sheet1_pol");
		formObj.pod.value = sheetObj.CellValue(row, "sheet1_pod");
		formObj.customs.value = sheetObj.CellValue(row, "sheet1_customs");
		
		if ("sheet1" == sheetObj.id)
			sheetObject2.DoSearch("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
		formObj.vvd.value = temp_vvd;
		formObj.pol.value = temp_pol;
		formObj.pod.value = temp_pod;
		formObj.customs.value = temp_customs;
		
		sheet2_total_setup(formObj, sheetObject2);
		
		deleteRowIndex = -1;
		
		ComBtnEnable("btn_Add_BL");
		break;
	
	case IBSAVE: //삭제저장
		var sheetObject2 = sheetObjects[1];
		if (sheetObject2.SelectRow == "-1") {
			ComShowMessage(ComGetMsg("BKG00249"));
			return;
		}
		if (!ComShowConfirm(ComGetMsg("BKG00535")))
			return;
		formObj.f_cmd.value = REMOVE01;
		//hideNchangeStatByD(sheetObject2, deleteRowIndex);
		hideNchangeStatByD(sheetObject2, sheetObject2.SelectRow);
		
		sheetObject2.DoSave("ESM_BKG_0613GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
		
		break;
	
	case COMMAND01:
		formObj.f_cmd.value = MULTI01;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		// var sheetObject2 = sheetObjects[1];
		var sParam = ComGetSaveString(sheetObj) + "&f_cmd=" + MULTI01 + "&" + ComGetPrefixParam("sheet2_");
		
		sheetObjects[1].WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0613GS.do", sParam);
		var key = ComGetEtcData(sXml, "KEY");
		sheetObjects[0].WaitImageVisible = false;
		ComOpenWait(true);
		intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		
		break;
	case IBINSERT: // 입력
		break;
	case COMMAND02: //add Bl
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		
		var sheet1SelectRow = sheetObject1.SelectRow;
		var sheet2SelectRow = sheetObject2.SelectRow;
		
		var vvd = "";
		var eta = "";
		var pod = "";
		
		if(sheet2SelectRow != -1) {
			vvd = sheetObject2.CellValue(sheet2SelectRow, "sheet2_vvd");
			eta = sheetObject2.CellValue(sheet2SelectRow, "sheet2_eta");
			pod = sheetObject2.CellValue(sheet2SelectRow, "sheet2_pod");
			
		} else {
			if(sheet1SelectRow != -1) {
				vvd = sheetObject1.CellValue(sheet1SelectRow, "sheet1_vvd");
				eta = sheetObject1.CellValue(sheet1SelectRow, "sheet1_eta");
				pod = sheetObject1.CellValue(sheet1SelectRow, "sheet1_pod");
			}
		}

		var param = "vvd=" + vvd + "&eta=" + eta + "&pod=" + pod;
		//alert("param : " + param);
		ComOpenWindowCenter("ESM_BKG_0034.do?pgmNo=" + blInqueryPgmNo + "&" + param, "ESM_BKG_0034", 1024, 660, true);
		break;
	
	case COMMAND03: //edit Bl
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		
		var sheetObject2 = sheetObjects[1];
		
		if (sheetObject2.SelectRow == -1) {
			ComShowMessage(ComGetMsg("BKG01002"));
			return;
		}
		var bl_no = sheetObject2.CellValue(sheetObject2.SelectRow, "sheet2_bl_no");
		var param = "bl_no=" + bl_no;
		ComOpenWindowCenter("ESM_BKG_0034.do?pgmNo=" + blInqueryPgmNo + "&" + param, "ESM_BKG_0034", 1024, 660, true);
		break;
	
	// OFM Generation
	case COMMAND04:
		formObj.f_cmd.value = MULTI02;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		var sheetObject2 = sheetObjects[1];
		ComOpenWait(true);
		var sParam = ComGetSaveString(sheetObject2) + "&f_cmd=" + MULTI02 + "&" + ComGetPrefixParam("sheet2_");
		
		var sXml = sheetObject2.GetSaveXml("ESM_BKG_0613GS.do", sParam);
		
		sheetObjects[2].LoadSaveXml(sXml);
		if (sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
			//formObj.output.value = sheetObjects[2].EtcData("flatFile");	// OFM Generation 수행시 생성된 flatfile을 보기 위해사용
			ComShowCodeMessage('BKG06071');
		}
		ComOpenWait(false);
		break;
	}
}

/**
 * BackEndJob 실행결과조회.
 */
function doActionValidationResult(sheetObj, sKey) {
	
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0613GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowCodeMessage('BKG06070');
		
		// sheet1, sheet2 다시 조회
		sheetObjects[0].WaitImageVisible = true;
		var selRow = sheetObjects[0].SelectRow;
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH02, selRow);
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		sheetObjects[0].WaitImageVisible = true;
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheetObject1 = sheetObjects[1];
	switch (sAction) {
	case SEARCH01:
		if (!ComChkValid(formObj))
			return false;
		if (formObj.pageNo.value == "ESM_BKG_0613_2") {
			if (formObj.pod.value == "" && formObj.customs.value == "") {
				ComShowMessage(ComGetMsg("BKG01030"));
				formObj.pod.focus();
				return false;
			}
		}
		break;
	case COMMAND01:
		if (sheetObject1.RowCount == 0) {
			//BKG00396,There is no data to transmit.
			ComShowCodeMessage('BKG00396');
			return false;
		}		
		var fullItemCnt = 0;
		var errorItemCnt = 0;
		for ( var j = 2; j < sheetObject1.RowCount + 2; j++) {
			if (sheetObject1.CellValue(j, "sheet2_del") == "N" || sheetObject1.CellValue(j, "sheet2_filer") == "N"
					|| sheetObject1.CellValue(j, "sheet2_pk") == "N" || sheetObject1.CellValue(j, "sheet2_wt") == "N"
					|| sheetObject1.CellValue(j, "sheet2_shpr_nm") == "N" || sheetObject1.CellValue(j, "sheet2_shpr_ad") == "N"
					|| sheetObject1.CellValue(j, "sheet2_cnee_nm") == "N" || sheetObject1.CellValue(j, "sheet2_cnee_ad") == "N"
					|| sheetObject1.CellValue(j, "sheet2_ntfy_nm") == "N" || sheetObject1.CellValue(j, "sheet2_ntfy_ad") == "N"
					|| sheetObject1.CellValue(j, "sheet2_cntr_no") == "N" || sheetObject1.CellValue(j, "sheet2_seal") == "N"
					|| sheetObject1.CellValue(j, "sheet2_cntr_pk") == "N" || sheetObject1.CellValue(j, "sheet2_cntr_wt") == "N"
					|| sheetObject1.CellValue(j, "sheet2_cntr_mk") == "N" || sheetObject1.CellValue(j, "sheet2_cntr_ds") == "N") {
				
				errorItemCnt++;				
			}			
			if (sheetObject1.CellValue(j, "sheet2_full_mty_cd") == "F") {
				fullItemCnt++;
			}			
		}		
		if (errorItemCnt > 0) {
			if (!ComShowConfirm(ComGetMsg("BKG01033")))
				return false;
		}		
		if (fullItemCnt == 0) {
			if (!ComShowConfirm(ComGetMsg("BKG01032")))
				return false;
		}		
		return true;
		break;
	case COMMAND04:
		if (sheetObject1.RowCount == 0) {
			//BKG01066,There is no data for OFM Generation.
			ComShowCodeMessage('BKG01066');
			return false;
		}
		if (MISENT == "N") {
			return true;
		} else if (MISENT == "") {
			return true;
		}
	}
	return true;
}

/**
 * 
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(SheetObj, Row, Col) {
	var sheetObject1 = sheetObjects[0];
	doActionIBSheet(sheetObject1,document.form,SEARCH02, Row);
}

 /**
  * 
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */
function sheet2_OnClick(sheetObj,Row, Col, Value){
	// 전역변수에 해당 로우 인덱스 셋업.
	deleteRowIndex = Row;
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @return
 */
function hideNchangeStatByD(sheetObj,Row){
	sheetObj.RedrawSum = false;	// 합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비
	sheetObj.RowHidden(Row)= true;		// 2.행 숨기기
	sheetObj.RowStatus(Row)= "D";		// 3.트랜잭션 상태 "삭제"로 만들기
	sheetObj.RedrawSum = true;	// 합계 계산하기
}

/**
 * 
 * @param formObj
 * @param sheetObj
 * @return
 */
function sheet2_total_setup(formObj, sheetObj){
	var hbl01 = 0;
	var mbl01 = 0;
	var mbl02 = 0;
	var mbl03 = 0;
	var prefix = "sheet2_";
	var pre_row = "";
	for(var i = 2; i < sheetObj.rowCount+2; i++){
		var row_seq = sheetObj.CellValue(i, prefix + "row_seq");
		if(row_seq != pre_row){
			var filerVal = sheetObj.CellValue(i, prefix + "filer");
			if(filerVal == " " ){
				hbl01++;
			}
			if(filerVal == "1" ){
				mbl01++;
			}
			if(filerVal == "2" ){
				mbl02++;
			}
			if(filerVal == "3" ){
				mbl03++;
			}
		}
		pre_row = row_seq;
	}
	
	formObj.totbl.value = sheetObj.CellValue(sheetObj.LastRow, prefix + "row_seq");
	formObj.hbl01.value = hbl01;
	
	formObj.mbl01.value = mbl01;
	formObj.mbl02.value = mbl02;
	formObj.mbl03.value = mbl03;
}

/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	
	if (ErrMsg == "") {
		if (document.form.f_cmd.value == REMOVE01) {
			
			doActionIBSheet(sheetObjects[0],formObj, SEARCH02, sheetObjects[0].SelectRow);
		} 
	}
}

/**
* 조회 후 이벤트
* @param sheetObj
* @param ErrMsg
* @return
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		
	var formObj = document.form;
	var prefix = "sheet2_";
	if (ErrMsg == "") {					
		for(var j = 2; j < sheetObj.RowCount+2 ; j++){
			if(sheetObj.CellValue(j, prefix+"del") == "N"){
				sheetObj.CellFontColor(j, prefix+"del") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"filer") == "N"){
				sheetObj.CellFontColor(j, prefix+"filer") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"pk") == "N"){
				sheetObj.CellFontColor(j, prefix+"pk") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"wt") == "N"){
				sheetObj.CellFontColor(j, prefix+"wt") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"shpr_nm") == "N"){
				sheetObj.CellFontColor(j, prefix+"shpr_nm") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"shpr_ad") == "N"){
				sheetObj.CellFontColor(j, prefix+"shpr_ad") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cnee_nm") == "N"){
				sheetObj.CellFontColor(j, prefix+"cnee_nm") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cnee_ad") == "N"){
				sheetObj.CellFontColor(j, prefix+"cnee_ad") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"ntfy_nm") == "N"){
				sheetObj.CellFontColor(j, prefix+"ntfy_nm") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"ntfy_ad") == "N"){
				sheetObj.CellFontColor(j, prefix+"ntfy_ad") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cntr_no") == "N"){
				sheetObj.CellFontColor(j, prefix+"cntr_no") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"seal") == "N"){
				sheetObj.CellFontColor(j, prefix+"seal") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cntr_pk") == "N"){
				sheetObj.CellFontColor(j, prefix+"cntr_pk") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cntr_wt") == "N"){
				sheetObj.CellFontColor(j, prefix+"cntr_wt") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cntr_mk") == "N"){
				sheetObj.CellFontColor(j, prefix+"cntr_mk") = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(j, prefix+"cntr_ds") == "N"){
				sheetObj.CellFontColor(j, prefix+"cntr_ds") = sheetObj.RgbColor(255, 0, 0);
			}
			
			// cgo_tp_cd 셋팅
			sheetObj.CellValue(j, prefix+"cgo_tp_cd") = formObj.full_empty.value;
			
		}
	}
}

/**
 * change이벤트 발생시, VVD, POL 필드가 대상이 되었다면, Actual Filing VVD 셋업실행.
 * @return
 */
function chkChange2(){
	var srcName = event.srcElement.getAttribute("name");
	var formObj = document.form;
	if(srcName == "pol"){
		if(document.form.vvd.value.length == 9 && document.form.pol.value.length == 5 ){
			//VVD가 'W'이고 POL이 'CA'이면 W를 E로 수정해서 보여준다.
			// POD가 'US','CA'가 아닌 경우 추가.
			if(document.form.vvd.value.substring(8, 9) == "W" && document.form.pol.value.substring(0, 2) == "CA"
					// && document.form.pod.value.substring(0, 2) != "CA" && document.form.pod.value.substring(0, 2) != "US"
				)
			{ 
//				form.actualvvd.value = document.form.vvd.value.substring(0, 8) + "E";
				formObj.f_cmd.value = COMMAND01;
				var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0613GS.do", FormQueryString(formObj));
				formObj.actualvvd.value = ComGetEtcData(sXml, "ACT_VVD");
			}
			else
			{
				form.actualvvd.value = "";
			}
		}else{
			form.actualvvd.value = "";
			if(srcName == "vvd" && document.form.vvd.value.length > 0 && document.form.vvd.value.length != 9){
				ComShowCodeMessage('BKG00007'); // VVD is not available !
				return;
			}
			if(srcName == "pol" && document.form.pol.value.length > 0 && document.form.pol.value.length != 5){
				ComShowCodeMessage('BKG00288'); // POL is not available
				return;
			}
			if(srcName == "vvd" && document.form.pol.value == ""){
				document.form.pol.focus();
			}
		}
	}
	
	if(srcName == "full_empty"){
		if(formObj.full_empty.value == "F"){
			ComSetDisplay("btn_Transmit", true);
			ComSetDisplay("btn_Transmit_e", false);
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.hbl01.value = "";
			formObj.mbl01.value = "";
			formObj.mbl02.value = "";
			formObj.mbl03.value = "";
			formObj.totbl.value = "";
//			formObj.total.reset();
		}else{
			ComSetDisplay("btn_Transmit", false);
			ComSetDisplay("btn_Transmit_e", true);
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.hbl01.value = "";
			formObj.mbl01.value = "";
			formObj.mbl02.value = "";
			formObj.mbl03.value = "";
			formObj.totbl.value = "";
//			formObj.total.reset();
		}
	}
	
}