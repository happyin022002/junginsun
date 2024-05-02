/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0723.js
 *@FileTitle : ESM_BKG_0723
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
 * 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
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
 * @class ESM_BKG_0723 : ESM_BKG_0723 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0723() {
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
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_OK":
			doActionIBSheet(sheetObjects[1], formObject, COMMAND01);
			break;

		case "btn_Close":
			window.close();
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

	// alert();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 140;
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

			var HeadTitle1 = " |Sel.|Terminal|Receiver ID (TP ID)|Snd|Svr|AREA|Message Type|VVD|BL";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,	"ibflag")
			InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter,	false, "del_chk",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		 70, daCenter,	false, "yd_cd",				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		120, daCenter,	false, "edi_rcv_id",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	 60, daLeft,	false, "edi_snd_id",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	 60, daLeft,	false, "edi_tml_svr_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	 60, daLeft,	false, "area_id",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		 90, daCenter,	false, "msg",				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		 30, daCenter,	false, "vvd_flg",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		 30, daCenter,	false, "bl_flg",			false, "", dfNone, 0, true, true);

		}
		break;

	case "sheet2": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 314;
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
			InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Seq.|Sel.|Cntr No.|Booking No.";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 0, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false,
					"del_chk");
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "cntr_no",
					false, "", dfNone, 0, true, true, 11);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_no",
					false, "", dfNone, 0, true, true, 13);
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
		ComOpenWait(true);
		if (formObj.in_list_type.value == "L")
			formObj.port_cd.value = formObj.in_pol_cd.value;
		else
			formObj.port_cd.value = formObj.in_pod_cd.value;
		// alert(formObj.in_port_cd.value);
		

		sheetObj.DoSearch("ESM_BKG_0723GS.do", FormQueryString(formObj));
		// alert(opener.document.sheet1);

		var opener_obj = opener;
		var opener_sheet = window.dialogArguments.document.sheet1;
		// alert(opener_obj.document.sheet1.RowCount);
		var rowcnt = 0;
		sheetObjects[1].RemoveAll();
		
		// alert(formObj.allPol.value);
		//if (formObj.allPol.value == "Y") {

		//	sheetObjects[1].DataInsert(-1);
		//	sheetObjects[1].CellValue(1, "del_chk") = 1;
		//	sheetObjects[1].CellValue(1, "cntr_no") = "";
		//	sheetObjects[1].CellValue(1, "bkg_no") = "";
		//} else {
			//alert(opener_sheet.RowCount);
			// opener_sheet.Copy2SheetCol(sheetObjects[1],"del_chk|cntr_no|bkg_no","2|3|4",-1,-1,-1,1);

			if (formObj.in_list_type.value == "L") {
				for ( var i=1 ; i<opener_sheet.RowCount+1 ; i++ )
				{
					if ( opener_sheet.CellValue(i, "del_chk") == 1 )
					{
						//alert();
						sheetObjects[1].DataInsert(-1);
						rowcnt = rowcnt+1;
						//alert(sheetObjects[1].CellValue(rowcnt,"cntr_no"));
						sheetObjects[1].CellValue(rowcnt,"cntr_no") = opener_sheet.CellValue(i,"cntr_no");
						sheetObjects[1].CellValue(rowcnt,"bkg_no") = opener_sheet.CellValue(i,"bkg_no2");
						sheetObjects[1].CellValue(rowcnt, "del_chk") = 1;
					}
					sheetObjects[1].CellValue(rowcnt, "msg") = "COPRAR";
					
				}
			} 
			for(var i=1 ; i<sheetObj.RowCount+1 ; i++ )
			{
				sheetObjects[0].CellValue(i, "msg") = "COPRAR";
			}
			//else {
				//opener_sheet.Copy2SheetCol(sheetObjects[1],
				//		"del_chk|cntr_no|bkg_no", "2|3|4", -1, -1, -1, 1);
			//}
			//for ( var i = sheetObjects[1].RowCount; i >= 1; i--) {
			//	if (sheetObjects[1].CellValue(i, "del_chk") == 0) {
			//		sheetObjects[1].RowHidden(i) = true;
			//		sheetObjects[1].RowStatus(i) = "D";
			//	}
			//}
		//}

		ComOpenWait(false);
		break;

	case COMMAND01: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			formObj.in_rcv_id.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "edi_rcv_id");
			formObj.in_snd_id.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "edi_snd_id");
			formObj.in_yd_cd.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "yd_cd");
			formObj.in_dest_svr_cd.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "edi_tml_svr_cd");
			formObj.in_area_id.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "area_id");
			formObj.in_vvd_flg.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "vvd_flg");
			formObj.in_bl_flg.value = sheetObjects[0].CellValue(
					sheetObjects[0].SelectRow, "bl_flg");
			// alert(formObj.in_area_id.value);
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sParam = "";

			if (formObj.in_list_type.value == "L")
			{
				var sParamSheet1 = sheetObj.GetSaveString();
				if (sParamSheet1 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet1, "");
				}
				sParam += "&" + FormQueryString(formObj);
				//alert("param1:"+sParam);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0723GS.do", sParam);
				
				
			} else {
				var opener_obj = opener;
				var opener_sheet = window.dialogArguments.document.sheet1;
				var sParamSheet1 = opener_sheet.GetSaveString();
				if (sParamSheet1 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet1, "");
				}
				sParam += "&" + FormQueryString(formObj);
				//alert("RowCount:"+opener_sheet.RowCount);
				var sXml = opener_sheet.GetSaveXml("ESM_BKG_0723GS.do", sParam);
			}
			

			//alert(sXml);
			// sheetObj.DoAllSave("ESM_BKG_0723GS.do",
			// FormQueryString(formObj));
			var key = ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId = setInterval(
					"doActionValidationResult(sheetObjects[1], '" + key + "');",
					3000);

			/*
			 * sheetObj.DoAllSave("ESM_BKG_0723GS.do",
			 * FormQueryString(formObj)); ComEtcDataToForm(formObj, sheetObj);
			 * 
			 * state = sheetObj.EtcData("TRANS_RESULT_KEY");
			 * 
			 * if (state == "S") { //document.form.in_cll_type_tmp(0).checked =
			 * true; doActionIBSheet(sheetObj, document.form, IBSEARCH); }
			 */
		}

		break;

	case IBINSERT: // 입력

		break;
	}
}

/**
 * BackEndJob 처리
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	sheetObjects[1].WaitImageVisble = false;
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0723GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
    var resultMsg = ComGetEtcData(sXml, "resultMsg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	
	if (sJbStsFlg == "SUCCESS") {
		if (resultMsg != ""){
			clearInterval(intervalId);
			ComOpenWait(false);
			ComShowMessage(resultMsg);
		}else {
			clearInterval(intervalId);
			ComOpenWait(false);
			// 성공메시지 보여주고
			ComShowCodeMessage('BKG00204');
			// ComShowMessage(ComResultMessage(sXml));	
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
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
	case COMMAND01: // 조회
		var vIsCheck = false;
		//for ( var i = 1; i <= sheetObj.RowCount; i++) {
		//	if (sheetObj.CellValue(i, "del_chk") == 1) {
		//		vIsCheck = true;
		//		break;
		//	}
		//}
		//alert(vIsCheck);
		//if (!vIsCheck) {
		//	ComShowCodeMessage('BKG00249', '');
		//	return false;
		//}

		var vIsCheck = false;
		for ( var i = 0; i <= sheetObjects[0].RowCount; i++) {
			if (sheetObjects[0].CellValue(i, "del_chk") == 1) {
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
	}
}
/* 개발자 작업 끝 */