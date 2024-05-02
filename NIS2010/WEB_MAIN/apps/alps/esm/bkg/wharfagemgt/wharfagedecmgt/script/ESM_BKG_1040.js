/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName :ESM_BKG_1040.js
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
function ESM_BKG_1040() {
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

var searchFlg = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var aryPrefix = new Array("", "sheet1_", "sheet2_"); //prefix 문자열 배열

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
			case "btn_retrieve":
				doActionIBSheet(sheetObject, document.form, COMMAND01);
				break;
			case "btn_Rate":
				var bound = formObject.bound.value;
				ComOpenWindowCenter("/hanjin/ESM_BKG_1042_P.do?pgmNo=ESM_BKG_1042&vvd=&bound="+bound, "1042", 730, 370, true);
				break;
			case "btn_Berth":
				ComOpenWindowCenter("/hanjin/ESM_BKG_0751.do?pgmNo=ESM_BKG_0751&port_cd="+formObject.port.value, "0751", 520, 450, true);
				break;
			case "btn_WhfSetup":
				var vvd = formObject.vvd.value;
				var bound = formObject.bound.value;
				var crr_cd = formObject.crr_cd.value;
				var param = "?pgmNo=ESM_BKG_1041&vvd=" + vvd + "&bound=" + bound + "&crr_cd=" + crr_cd;
				ComOpenWindowCenter("/hanjin/ESM_BKG_1041.do" + param, "1041", 1024, 690, true);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObject, MULTI);
				break;
			case "btn_Preview":
				if (sheetObjects[2].RowCount == 0)
				{
					ComShowCodeMessage("BKG95010");
					return;
				}
				formObject.com_mrdPath.value = "apps/alps/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0752.mrd";
				var strArg = "/rp ["+ formObject.vvd.value +"]" +
					"["+ formObject.port.value +"]"+
					"["+ formObject.bound.value +"]"+
					"["+ strUsr_nm +"]";
				formObject.com_mrdArguments.value = strArg;
				ComOpenRDPopup();
//				ComOpenWindowCenter("/hanjin/ESM_BKG_0752.do", "0752", 1024, 750, true);
				break;
			case "btn_Send":
				doActionIBSheet(sheetObjects[1], document.form, MODIFY01);
				break;
			case "btn_Close":
				window.close();
				break;
			case "btn_RowAddHis":
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].CellValue2(sheetObjects[1].LastRow, "sheet2_chk") = 1;
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
 * @param searchFlg 초기화면 조회여부
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
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle1 = "|||0-7M (20FT.)|7-9M (24FT.)|9-13M (40FT.)|OVR 13M (45FT.)|CONT|TEUS|AUTOS|Amount Due";
			var headCount = ComCountHeadTitle(HeadTitle1) + 7;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 1, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)
			
			Rows = 6;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = 'sheet1_';
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "");
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtAutoSum, 0,   daRight, true, prefix + "temp", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, true, prefix + "ft20", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 	  100, daRight, true, prefix + "", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, true, prefix + "ft40", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, true, prefix + "ft45", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, true, prefix + "cont", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, true, prefix + "teus", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 	  80,  daRight, true, prefix + "temp2", false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtAutoSum, 0,   daRight, true, "whf_amt", false,	"|2|*|10|+|4|*|11|+|5|*|12|+|6|*|13|+|7|*|14|", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 0,   daRight, true, prefix + "whf_amt", false, "", dfNullFloat, 2, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, prefix + "ut_prc_20ft", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, prefix + "ut_prc_40ft", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, prefix + "ut_prc_45ft", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, prefix + "ut_prc_cont", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, prefix + "ut_prc_teus", false, "", dfFloat, 2, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, prefix + "full_mty_cd");
			InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, prefix + "usa_whf_trsp_tp_cd");

			InitHeadColumn(0, "LOCAL Full CNTR|LOCAL Empty CNTR|IPI Full CNTR|IPI Empty CNTR|TOTAL", daCenter);
			ColHidden(2) = true;
			CountPosition = 0;
			ScrollBar = 0;
		}
		break;
	case "sheet2": //sheet2 init
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
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Sel.|E-Mail|Result|Send Date|Send ID|Staff||";
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
			var prefix = 'sheet2_';
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40,  daCenter, false,prefix + "chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,     300, daLeft,   true, prefix + "cntc_eml", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,     150, daCenter, true, prefix + "fax_eml_snd_rslt_msg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,     150, daCenter, true, prefix + "snd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,     150, daCenter, true, prefix + "snd_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,     0, 	daCenter, true, prefix + "snd_usr_id", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "his_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ntc_via_cd");
			CountPosition = 0;
		}
		break;
	case "sheet3": //sheet3 init
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
			var prefix = '';
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "vsl_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "port_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "io_bnd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "vsl_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "crr_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "vsl_voy_dir_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "brth_desc");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "dep_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "arr_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bil_rcv_pty_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bil_snd_pty_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "snd_rmk");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "whf_dc_rt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ddct_amt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "locl_upd_dt");
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
		case COMMAND01:
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true,true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1040GS.do", FormQueryString(formObj));
				// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림  3초마다
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 1000);
			}
			break;
		case SEARCH: //Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1040GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				sheetObjects[2].LoadSearchXml(arrXml[0]);
				if(sheetObjects[2].RowCount > 0){
					sheetObjects[0].ColHidden(2) = false;
					IBS_CopyRowToForm(sheetObjects[2], formObj, 1, "frm_");
					sheetObjects[0].LoadSearchXml(arrXml[1]);
					sheetObjects[1].LoadSearchXml(arrXml[2]);
					sheetObjects[0].ColHidden(2) = true;
					sheetObjects[0].RowHidden(5) = true;
					
					for (var i=1; i<sheetObjects[0].RowCount + 1; i++) {
						sheetObjects[0].CellValue2(i, aryPrefix[1]+"temp") = 
							sheetObjects[0].CellValue(i, aryPrefix[1]+"whf_amt");
					}
					formObj.crr_cd.value = sheetObjects[2].CellValue(1, "crr_cd");
				} else {
					IBS_CopyRowToForm(sheetObjects[2], formObj, 1, "frm_");
					// "조회된 데이타가 없습니다" 메시지를 표시하기 위해
					sheetObjects[0].LoadSearchXml(arrXml[1]);
					sheetObjects[1].LoadSearchXml(arrXml[2]);
					
					formObj.crr_cd.value = "";
				}
			}
			break;
		case MULTI: //Save
		case MODIFY01:
			if (sheetObjects[1].RowCount == 0) {
				ComShowCodeMessage("BKG95010");
				return false;
			}
			IBS_CopyFormToRow(formObj, sheetObjects[2], 1, "frm_");
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true,true);
				sheetObjects[2].CellValue2(1, "ibflag") = "U";
				var sParam = FormQueryString(formObj) 
					+ "&" + sheetObjects[2].GetSaveString() 
					+ "&" + sheetObjects[0].GetSaveString()
					+ "&" + sheetObjects[1].GetSaveString()
					+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_1040GS.do", sParam);
				if(ComBkgErrMessage(sheetObjects[0], sXml)) {
					sheetObjects[0].LoadSaveXml(sXml);
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * 시트1 조회 후 발생하는 이벤트
 * @param sheetObj 시트
 * @param ErrMsg 에러메시지
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.InitHeadColumn(0, "LOCAL Full CNTR|LOCAL Empty CNTR|IPI Full CNTR|IPI Empty CNTR|TOTAL|TOTAL", daCenter);
}

/**
 * BackEndJob 결과조회
 * @param sheetObj 시트오브젝으
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1040GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
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
		// 에러
		clearInterval(intervalId);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
		ComOpenWait(false);
		return;
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
	if (sheetObj.ColSaveName(Col) == aryPrefix[1] + "ft20"
			|| sheetObj.ColSaveName(Col) == aryPrefix[1] + "ft40"
			|| sheetObj.ColSaveName(Col) == aryPrefix[1] + "ft45")
	{
		// CONT, TEUS 계산
		if (sheetObj.CellValue(Row, aryPrefix[1] + "full_mty_cd") == "F")
		{
			sheetObj.CellValue2(Row, aryPrefix[1] + "cont") = sheetObj.ComputeSum("|3|+|5|+|6|", Row, Row);
			sheetObj.CellValue2(Row, aryPrefix[1] + "teus") = sheetObj.ComputeSum("|3|+|5|*2+|6|*2.25", Row, Row);
		}
	}
	// 합계
	if (sheetObj.ColSaveName(Col) != aryPrefix[1] + "whf_amt") {
		if (sheetObj.CellValue(Row, aryPrefix[1] + "ut_prc_teus") > 0)
		{
			sheetObj.CellValue2(Row, aryPrefix[1] + "whf_amt") = 
				sheetObj.CellValue(Row, aryPrefix[1] + "teus") * sheetObj.CellValue(Row, aryPrefix[1] + "ut_prc_teus");
		}
		else if (sheetObj.CellValue(Row, aryPrefix[1] + "ut_prc_cont") > 0)
		{
			sheetObj.CellValue2(Row, aryPrefix[1] + "whf_amt") = 
				sheetObj.CellValue(Row, aryPrefix[1] + "cont") * sheetObj.CellValue(Row, aryPrefix[1] + "ut_prc_cont");
		}
		else
		{
			sheetObj.CellValue2(Row, aryPrefix[1] + "whf_amt") = sheetObj.ComputeSum("|3|*|11|+|5|*|12|+|6|*|13|", Row, Row);
		}
		sheetObj.CellValue2(Row, aryPrefix[1] + "temp") = sheetObj.CellValue(Row, aryPrefix[1] + "whf_amt");
		sheetObj.CellBackColor(Row, aryPrefix[1] + "whf_amt") = sheetObj.RgbColor(255, 255, 254);
	} else {
		if (sheetObj.CellValue(Row, aryPrefix[1] + "whf_amt") != sheetObj.CellValue(Row, aryPrefix[1] + "temp")) {
			sheetObj.CellBackColor(Row, aryPrefix[1] + "whf_amt") = sheetObj.RgbColor(255, 0, 0);
		} else {
			sheetObj.CellBackColor(Row, aryPrefix[1] + "whf_amt") = sheetObj.RgbColor(255, 255, 254);
		}
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
		if (sheetObjects[2].RowCount == 0) {
			ComShowCodeMessage("BKG95010");
			return false;
		}
		if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified	&& !sheetObjects[2].IsDataModified) {
			ComShowCodeMessage("BKG95005");
			return false;
		}
		break;
	case MODIFY01:
		if (sheetObjects[1].CheckedRows(aryPrefix[2]+"chk") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		for (var i=1; i<sheetObjects[1].RowCount+1; i++) {
			if (sheetObjects[1].CellValue(i, aryPrefix[2]+"chk") == "1" && 
					sheetObjects[1].CellValue(i, aryPrefix[2]+"cntc_eml") == "")
			{
				ComShowCodeMessage('BKG00717', 'E-Mail');
				sheetObjects[1].SelectCell(i, aryPrefix[2]+"cntc_eml");
				return false;
			}
		}
		if (!ComShowCodeConfirm("BKG95003", "send")) {
			return false;
		}
		break;
	}
	return true;
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
 * 엔터치면 자동조회. textarea가 있기 때문에 조회조건만 해당
 */
function obj_KeyEnter() {
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "vvd" || srcName == "bound") {
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
		initSheet(sheetObjects[0], 1);
		var vvd = formObject.vvd.value;
		var bound = formObject.bound.value;
		formObject.reset();
		formObject.vvd.value = vvd;
		formObject.bound.value = bound;
	}
}