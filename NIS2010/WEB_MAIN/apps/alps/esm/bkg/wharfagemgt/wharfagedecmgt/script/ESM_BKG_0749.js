/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName :ESM_BKG_0749.js
 *@FileTitle : US Wharfage Exception Keyword
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0749() {
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

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";
var aryPrefix = new Array("", "", "", "", "sheet4_"); //prefix 문자열 배열

var searchFlg = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_RowAdd":
			if(sheetObjects[2].RowCount > 5) {
				ComShowCodeMessage('BKG02086');
				return;
			}
			sheetObjects[2].DataInsert(-1);
			break;
		case "btn_RowDelete":
			if (sheetObjects[2].RowCount > 0) {
				var delCnt = 0;
				for ( var i = 2; i < sheetObjects[2].RowCount + 2; i++) {
					if (sheetObjects[2].CellValue(i, "chk") == "1") {
						if (sheetObjects[2].CellValue(i, "bb_cgo_seq") != "") {
							sheetObjects[2].CellValue2(i, "ibflag") = "D";
							sheetObjects[2].RowHidden(i) = true;
						} else {
							sheetObjects[2].RowDelete(i, false);
							i--;
						}
						delCnt++;
					}
				}
				obj_Sum();
				if (delCnt == 0) {
					ComShowCodeMessage('BKG00333');
					return;
				}
			}
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_Exception":
			var bound = formObject.bound.value;
			ComOpenWindowCenter("/hanjin/ESM_BKG_0748.do?pgmNo=ESM_BKG_0748&io_bnd_cd="+bound, "0748", 620, 370, true);
			break;
		case "btn_Rate":
			var bound = formObject.bound.value;
			ComOpenWindowCenter("/hanjin/ESM_BKG_0750_P.do?pgmNo=ESM_BKG_0750&vvd=&bound="+bound, "0750", 540, 490, true);
			break;
		case "btn_Berth":
			ComOpenWindowCenter("/hanjin/ESM_BKG_0751.do?pgmNo=ESM_BKG_0751&port_cd="+formObject.port.value, "0751", 520, 450, true);
			break;
		case "btn_WhfSetup":
			var vvd = formObject.vvd.value;
			var bound = formObject.bound.value;
			var type_rail = "";
			if (formObject.type_rail.checked) 
				type_rail = formObject.type_rail.value;
			var param = "&vvd=" + vvd + "&bound=" + bound + "&type_rail=" + type_rail;
			ComOpenWindowCenter("/hanjin/ESM_BKG_0688.do?pgmNo=ESM_BKG_0688"+param, "0688", 1024, 670, true);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_Preview":
			if (sheetObjects[4].RowCount == 0)
			{
				ComShowCodeMessage("BKG95010");
				return;
			}
			formObject.com_mrdPath.value = "apps/alps/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0825.mrd";
			var vTypeRail = "";
			if (formObject.type_rail.checked) vTypeRail = "R";
			var strArg = "/rp ["+ formObject.vvd.value +"]" +
				"["+ formObject.port.value +"]"+
				"["+ formObject.bound.value +"]"+
				"["+ vTypeRail +"]"+ 
				"["+ strUsr_nm +"]";
			formObject.com_mrdArguments.value = strArg;
			ComOpenRDPopup();
//			ComOpenWindowCenter("/hanjin/ESM_BKG_0825.do", "0825", 1024, 750, true);
			break;
		case "btn_Send":
			doActionIBSheet(sheetObjects[3], document.form, MODIFY01);
			break;
		case "btn_SendWith":
			doActionIBSheet(sheetObjects[3], document.form, MODIFY02);
			break;
		case "btn_Excel":
			sheetObject.SpeedDown2Excel(-1);
			break;
		case "btn_Close":
			window.close();
			break;
		case "btn_RowAddHis":
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].CellValue2(sheetObjects[3].LastRow, "sheet4_chk") = 1;
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
 * @param searchFlg 자동조회여부
 */
function loadPage(searchFlg) {
	this.searchFlg = searchFlg;
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_KeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_Change', document.form);
	
    doActionIBSheet(sheetObjects[0], document.form, INIT);
    if (this.searchFlg) doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
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
	case "sheet1": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 240;
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
			InitRowInfo(2, 1, 10, 100);

			var HeadTitle1 = " | |REGULAR|REGULAR|REGULAR|RAIL|RAIL|RAIL|TRANSSHIP|TRANSSHIP|TRANSSHIP";
			var HeadTitle2 = " | |COUNT|Rate|Amount Due|COUNT|Rate|Amount Due|COUNT|Rate|Amount Due";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 2, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			Rows = 11;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "", false, "",	dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, true, "", false, "",	dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "local_count", false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "local_rate", false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "local_amt", false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "rail_count", false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "rail_rate", false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "rail_amt", false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "ts_count", false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "ts_rate", false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "ts_amt", false, "", dfFloat, 3, false, false);

			HeadFontBold = true;

			InitHeadColumn(0,"REGULAR|REGULAR|REGULAR|EXEMPT|EXEMPT|EXEMPT|EMPTY|EMPTY|EMPTY",daCenter);
			InitHeadColumn(1, "20’|40’|45’|20’|40’|45’|20’|40’|45’", daCenter);

			CountPosition = 0;
			ScrollBar = 0;
		}
		break;

	case "sheet2": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 130;
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
			InitRowInfo(2, 1, 10, 100);

			var HeadTitle1 = " |CONTAINER COUNT TOTAL|CONTAINER COUNT TOTAL|CONTAINER COUNT TOTAL|CONTAINER COUNT TOTAL|CONTAINER COUNT TOTAL|CONTAINER COUNT TOTAL";
			var HeadTitle2 = " |20F|20E|40F|40E|45F|45E";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 1, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			Rows = 7;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daLeft,  true, "", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "cnt_20f", false, "", dfFloat, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "cnt_20e", false, "", dfFloat, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "cnt_40f", false, "", dfFloat, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "cnt_40e", false, "", dfFloat, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "cnt_45f", false, "", dfFloat, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "cnt_45e", false, "", dfFloat, 0, false, true);

			HeadFontBold = true;

			InitHeadColumn(0, "Regular|Rail|Transship|Total|", daCenter);
			RowHidden(6) = true;
			CountPosition = 0;
		}
		break;

	case "sheet3": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 130;
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
			InitRowInfo(2, 1, 10, 100);

			var HeadTitle1 = "|NON-CONTAINERIZED|NON-CONTAINERIZED|NON-CONTAINERIZED|NON-CONTAINERIZED|NON-CONTAINERIZED|NON-CONTAINERIZED|NON-CONTAINERIZED";
			var HeadTitle2 = "|Sel.|Commodity|Unit|Qty|Unit Rate|Total|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "cmdt_desc", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "usa_whf_rat_ut_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "rat_as_qty", true, "", dfNullFloat, 1, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "whf_ut_prc", true, "", dfNullFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "blk_amt", false, "|4| * |5|", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "bb_cgo_seq");
			
			InitDataValid(0, "cmdt_desc", vtEngUpOther, "1234567890 :");
			InitDataValid(0, "usa_whf_rat_ut_cd", vtEngUpOnly);
			
			CountPosition = 0;
		}
		break;
	case "sheet4": //sheet1 init
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
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel.|Notice Type|Fax No/E-Mail|Result|Send Date|Send ID|Staff|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = 'sheet4_';
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, prefix + "chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 150, daCenter, true, prefix + "ntc_via_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, prefix + "cntc_eml", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, prefix + "fax_eml_snd_rslt_msg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, prefix + "snd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, prefix + "snd_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, prefix + "snd_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "his_seq");
			
			InitDataCombo(0, prefix + "ntc_via_cd", "E-Mail|Fax", "M|F");
			CountPosition = 0;
		}
		break;
	case "sheet5": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
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
			InitRowInfo(1, 1, 3, 100);
	
			var HeadTitle1 = "|vsl_cd|skd_voy_no|skd_dir_cd|port_cd|io_bnd_cd|vsl_nm|crr_cd|vsl_voy_dir_no|brth_desc|dep_dt|arr_dt|bil_rcv_pty_nm|bil_snd_pty_nm|snd_rmk|whf_dc_rt|ddct_amt|locl_upd_dt";
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
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag_main");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vsl_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "port_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "io_bnd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vsl_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "crr_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vsl_voy_dir_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "brth_desc");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dep_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "arr_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bil_rcv_pty_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bil_snd_pty_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "snd_rmk");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "whf_dc_rt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ddct_amt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "locl_upd_dt");
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
	formObj.f_cmd.value = sAction;
	switch (sAction) {
		case INIT:
			//Status Combo
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0749GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.frm_bil_rcv_pty_nm, "attr_ctnt1", "attr_ctnt2");
			ComXml2ComboItem(sXml, formObj.frm_brth_desc, "attr_ctnt6", "attr_ctnt7");
			break;
		case COMMAND01:
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true,true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0749GS.do", FormQueryString(formObj));
				// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림  3초마다
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[4], '" + key + "');", 1000);
			}
			break;
		case SEARCH: //Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0749GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				sheetObjects[4].LoadSearchXml(arrXml[0]);
				if(sheetObjects[4].RowCount > 0){
					IBS_CopyRowToForm(sheetObjects[4], formObj, 1, "frm_");
					formObj.frm_bil_rcv_pty_nm.Code = sheetObjects[4].CellValue(1, "bil_rcv_pty_nm");
					formObj.frm_brth_desc.Code = sheetObjects[4].CellValue(1, "brth_desc");
					sheetObjects[0].LoadSearchXml(arrXml[1]);
					sheetObjects[1].LoadSearchXml(arrXml[2]);
					sheetObjects[2].LoadSearchXml(arrXml[3]);
					sheetObjects[3].LoadSearchXml(arrXml[4]);
					// 체크박스에 체크하고 변경사항이 없으므로 ibflag를 "R"로 변경함
//					sheetObjects[3].CheckAll("sheet4_chk") = 1;
					sheetObjects[3].CellValue2(1, "sheet4_ibflag") = "R";
					sheetObjects[3].CellValue2(2, "sheet4_ibflag") = "R";
					//////////////////////////////////////////////////////////
					formObj.frm_mts.value = ComAddComma(sheetObjects[1].CellValue(6, "cnt_20e"));
					formObj.frm_teu.value = ComAddComma(sheetObjects[1].CellValue(6, "cnt_20f"));
					obj_Sum();
				} else {
					IBS_CopyRowToForm(sheetObjects[4], formObj, 1, "frm_");
					formObj.frm_bil_snd_pty_nm.Code = "";
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					formObj.frm_mts.value = "";
					formObj.frm_teu.value = "";
					formObj.frm_sum_amt.value="";
					formObj.frm_tot_amt.value="";
					// "조회된 데이타가 없습니다" 메시지를 표시하기 위해
					sheetObjects[0].LoadSearchXml(arrXml[1]);
				}
			}
			break;
		case MULTI: //Save
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
					return;
				}
				ComOpenWait(true,true);
				sheetObjects[4].CellValue2(1, "ibflag_main") = "U";
				var sParam = FormQueryString(formObj) 
					+ "&" + sheetObjects[4].GetSaveString() 
					+ "&" + sheetObjects[2].GetSaveString()
					+ "&" + sheetObjects[3].GetSaveString()
					+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0749GS.do", sParam);
				if(ComBkgErrMessage(sheetObjects[2], sXml)) {
					sheetObjects[2].LoadSaveXml(sXml);
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				ComOpenWait(false);
			}
			break;
		case MODIFY01:
		case MODIFY02:
			if (sheetObjects[4].RowCount == 0)
			{
				ComShowCodeMessage("BKG95010");
				return false;
			}
			IBS_CopyFormToRow(formObj, sheetObjects[4], 1, "frm_");
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
					return;
				}
				ComOpenWait(true,true);
				sheetObjects[4].CellValue2(1, "ibflag_main") = "U";
				for (var i=1; i<sheetObjects[3].RowCount+1; i++) {
					if (sheetObjects[3].CellValue(i, "sheet4_chk") == "1") {
						sheetObjects[3].CellValue2(i, "sheet4_ibflag") = "U";
					} else {
						sheetObjects[3].CellValue2(i, "sheet4_ibflag") = "R";
					}
				}
				var sParam = FormQueryString(formObj) 
					+ "&" + sheetObjects[4].GetSaveString() 
					+ "&" + sheetObjects[2].GetSaveString()
					+ "&" + sheetObjects[3].GetSaveString()
					+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0749GS.do", sParam);
				if(ComBkgErrMessage(sheetObjects[2], sXml)) {
					sheetObjects[2].LoadSaveXml(sXml);
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * 합계구하기
 */
function obj_Sum() {
	var formObj = document.form;
	var ddctAmt = formObj.frm_ddct_amt.value;
	if (ddctAmt == "") ddctAmt = 0;
	if (sheetObjects[2].RowCount > 0) {
		var vBlkSum = 0;
		for(var i=2; i<sheetObjects[2].RowCount+2; i++) {
			if (sheetObjects[2].CellValue(i, "ibflag") != "D") {
				vBlkSum = vBlkSum + parseFloat(sheetObjects[2].CellValue(i, "blk_amt"));
			}
		}
		vBlkSum = get_Round(vBlkSum, 3);
		
		formObj.frm_sum_amt.value = get_Round(sheetObjects[0].ComputeSum("|4|+|7|+|10|") + vBlkSum, 2);
		formObj.frm_tot_amt.value = get_Round(sheetObjects[0].ComputeSum("|4|+|7|+|10|") + vBlkSum
				                          - parseFloat(ddctAmt), 2);
	} else {
		formObj.frm_sum_amt.value = get_Round(sheetObjects[0].ComputeSum("|4|+|7|+|10|"), 2);
		formObj.frm_tot_amt.value = get_Round(sheetObjects[0].ComputeSum("|4|+|7|+|10|")
				                          - parseFloat(ddctAmt), 2);
	}
	formObj.frm_sum_amt.value = "$" + ComAddComma2(formObj.frm_sum_amt, "#,###.00");
	formObj.frm_tot_amt.value = "$" + ComAddComma2(formObj.frm_tot_amt, "#,###.00");
}

/**
 * 반올림
 * @param num 값
 * @param pos 반올림 자리수
 */
function get_Round(num,pos) {
	if(!pos){
		return Math.round(num); 
	}else{
		var posV = Math.pow(10,3)
		return Math.round(num*posV)/posV
	}
}

/**
 * BackEndJob 결과조회
 * @param sheetObj 시트오브젝으
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0749GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		// sheet1, sheet2 다시 조회
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
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
 * 시트3 키보드 up할때
 * @param sheetObj 시트오브젝트
 * @param Row Row Index
 * @param Col Col Index
 * @param KeyCode KeyCode
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 */
function sheet3_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	
	if (sheetObj.CellValue(Row, "rat_as_qty") != "" && sheetObj.CellValue(Row, "whf_ut_prc") != "") {
		sheetObj.CellValue2(Row, "blk_amt") = sheetObj.CellValue(Row, "rat_as_qty") * sheetObj.CellValue(Row, "whf_ut_prc");
		obj_Sum();
	} else {
		sheetObj.CellValue2(Row, "blk_amt") = "";
	}
}

/**
 * 조회조건 입력 후 자동으로 다음항목으로 이동
 */
function obj_KeyUp() {
	var name = window.event.srcElement.getAttribute("name");
	if (name == "frm_ddct_amt") {
		obj_Sum();
	}
	var formObject = document.form;
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
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
		case COMMAND01: //조회
			// 기본포멧체크
			if (!ComChkValid(formObj))
				return false;
			break;
		case MULTI: //저장
			if (sheetObjects[4].RowCount == 0)
			{
				ComShowCodeMessage("BKG95010");
				return false;
			}
			IBS_CopyFormToRow(formObj, sheetObjects[4], 1, "frm_");
			//sheetObjects[4].CellValue2(1, "bil_snd_pty_nm") = formObj.frm_bil_snd_pty_nm.Code;
			
			sheetObjects[4].CellValue2(1, "bil_rcv_pty_nm") = formObj.frm_bil_rcv_pty_nm.Code;
			sheetObjects[4].CellValue2(1, "brth_desc") = formObj.frm_brth_desc.Code;
			
			if (!sheetObjects[2].IsDataModified && !sheetObjects[3].IsDataModified && !sheetObjects[4].IsDataModified) {
				ComShowCodeMessage("BKG95005");
				return false;
			}
			break;
		case MODIFY01:
		case MODIFY02:
			if (sheetObjects[3].CheckedRows(aryPrefix[4]+"chk") == 0)
			{
				ComShowCodeMessage('BKG00333');
				return false;
			}
			if (sheetObjects[3].CellValue(1, aryPrefix[4]+"chk") == "1" && sheetObjects[3].CellValue(1, aryPrefix[4]+"cntc_eml") == "") {
				ComShowCodeMessage("BKG00888", "[E-Mail]");
				sheetObjects[3].SelectCell(1, aryPrefix[4]+"cntc_eml");
				return false;
			}
			if (sheetObjects[3].CellValue(2, aryPrefix[4]+"chk") == "1" && sheetObjects[3].CellValue(2, aryPrefix[4]+"cntc_eml") == "") {
				ComShowCodeMessage("BKG00888", "[Fax No]");
				sheetObjects[3].SelectCell(2, aryPrefix[4]+"cntc_eml");
				return false;
			}
			if (!ComShowCodeConfirm("BKG40038", "send")) {
				return false;
			}
	}
	return true;
}

/**
 * 숫자에 콤마를 붙임
 * @param obj 오브젝트
 * @param sFormat 포멧
 * @return 콤마 붙인 수
 */
function ComAddComma3(obj,sFormat) {
    //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
    var sVal = obj.value;
    switch(sFormat)
    {
        case "#,###.000" :
            p = sVal.split(".");
            p[0] = ComAddComma(p[0]);
            if      (p.length == 1) return p[0]+".000";
            else if (p.length == 2) {
            	var vZero = "";
             	for (i = p[1].length; i < 3; i++) {
             		vZero += "0";
             	}
             	return p[0]+"."+p[1] + vZero;
            }
            else return "";
            break;
    }
}

/**
 * 엔터치면 자동조회. textarea가 있기 때문에 조회조건만 해당
 */
function obj_KeyEnter() {
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "vvd" || srcName == "bound" || srcName == "type_rail") {
		ComKeyEnter();
	}
}

 /**
  * 조회조건 바꿀때 시트 초기화
  * @return
  */
function obj_Change() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "bound") {
		for (i = 0; i < sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}
		var vvd = formObject.vvd.value;
		var bound = formObject.bound.value;
		formObject.reset();
		formObject.vvd.value = vvd;
		formObject.bound.value = bound;
	}
}