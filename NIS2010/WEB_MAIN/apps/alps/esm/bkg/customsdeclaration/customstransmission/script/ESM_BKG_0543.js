/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0543.js
 *@FileTitle : Vessel Departure Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.05.26 김도완
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
 * @class ESM_BKG-0543 : ESM_BKG-0543 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0543() {
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":

			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

			break;
		case "btn_Transmit":

			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_close":
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	sheetObjects[0].RemoveAll();
	sheetObjects[0].DataInsert(-1);
	initControl();

	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
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
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	document.form.vvd.focus();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
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
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "Flag|vvd|pol_cd|pod_cd|B/L count|Name|Atd/Etd|Eta|MI Transmit|snd yn|HI Transmit|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "vvd");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "eta");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "pod_cd");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "pol_cd");

			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "name");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "mi_transmit");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "bl_count");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "atd");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "hi_snd_yn");

			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "hi_transmit");
			InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "snd_usr_id");
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0543GS.do", FormQueryString(formObj));

			ComOpenWait(false);
		}
		break;
	case COMMAND01:

		formObj.f_cmd.value = MULTI01;
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i = 1; i < sheetObj.rowCount + 1; i++) {
				sheetObj.RowStatus(i) = "U";
			}
			if (ComShowConfirm("Do you want to transmit HI to US Customs?")) {
				ComOpenWait(true);

				var sParam = FormQueryString(formObj);
				+"&f_cmd=" + MULTI01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0543GS.do", sParam);
				ComOpenWait(false);
				sheetObj.LoadSearchXml(sXml);
				// formObj.output.value = sheetObj.EtcData("flatFile");
				if (sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
					ComShowCodeMessage('BKG00101');
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				} else {
					ComShowCodeMessage('BKG00099');
				}
				for ( var i = 1; i < sheetObj.rowCount + 1; i++) {
					sheetObj.RowStatus(i) = "";
				}
			}
		}
		//doActionIBSheet(sheetObj,formObj,SEARCH02, sheetObj.SelectRow);
		break;

	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (document.form.f_cmd.value == MULTI) {
			ComShowCodeMessage('BKG00166');

			// doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		}
	} else {
		ComShowCodeMessage('BKG00167');
	}
}

function ComBtnEnable2(name) {
	var tds = document.getElementsByTagName("td");
	for ( var i = 0; i < tds.length; i++) {
		var td = tds[i];
		var tmp = td.name;
		if (td.className.length > 0 && tmp != null && tmp.indexOf("no_" + name) >= 0) {
			if (td.className.indexOf('_1') > 0)
				td.className = td.className.replace(/_1/i, "");
			td.name = name;
		}
	}
}

function ComBtnDisable2(name) {
	var tds = document.getElementsByTagName("td");
	for ( var i = 0; i < tds.length; i++) {
		var td = tds[i];
		var tmp = td.name;

		if (td.className.length > 0 && tmp != null && tmp.indexOf(name) >= 0) {
			if (td.className.indexOf('_1') == -1) {
				td.className += "_1";
				td.name = "no_" + name;
			}
		}
	}

}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	if (ErrMsg == "") {
		if (sheetObj.RowCount > 0) {

			document.form.vvd.value = sheetObj.CellValue(1, "vvd");
			document.form.pol_cd.value = sheetObj.CellValue(1, "pol_cd");
			document.form.pod_cd.value = sheetObj.CellValue(1, "pod_cd");
			document.form.bl_count.value = sheetObj.CellValue(1, "bl_count");
			document.form.name.value = sheetObj.CellValue(1, "name");
			document.form.snd_usr_id.value = sheetObj.CellValue(1, "snd_usr_id");

			var atdFull = sheetObj.CellValue(1, "atd");
			var etaFull = sheetObj.CellValue(1, "eta");
			var mitFull = sheetObj.CellValue(1, "mi_transmit");
			var hiSndYn = sheetObj.CellValue(1, "hi_snd_yn");
			var hitFull = sheetObj.CellValue(1, "hi_transmit");
			
			if (hiSndYn == "Y") {
				ComBtnDisable2("btn_Transmit");
			} else {
				ComBtnEnable2("btn_Transmit");
			}
			if(location.href.indexOf('alpsdev') != -1){
				ComBtnEnable2("btn_Transmit");
			}
			if (atdFull.length > 8) {
				document.form.atd.value = atdFull.substring(0, 8);
				document.form.atd_time.value = atdFull.substring(9);
			} else {
				document.form.atd.value = "";
				document.form.atd_time.value = "";
			}
			if (etaFull.length > 8) {
				document.form.eta.value = etaFull.substring(0, 8);
				document.form.eta_time.value = etaFull.substring(9);
			} else {
				document.form.eta.value = "";
				document.form.eta_time.value = "";
			}
			if (mitFull.length > 8) {

				document.form.mi_transmit.value = mitFull.substring(0, 8);
				document.form.mi_transmit_time.value = mitFull.substring(9);
			} else {

				document.form.mi_transmit.value = "";
				document.form.mi_transmit_time.value = "";
			}

			if (hitFull.length > 8) {

				document.form.hi_transmit.value = hitFull.substring(0, 8);
				document.form.hi_transmit_time.value = hitFull.substring(9);
			} else {

				document.form.hi_transmit.value = "";
				document.form.hi_transmit_time.value = "";
				document.form.snd_usr_id.value = "";
			}

		}
	} else {
		document.form.bl_count.value = "";
		document.form.name.value = "";
		document.form.snd_usr_id.value = "";
		document.form.atd.value = "";
		document.form.atd_time.value = "";
		document.form.eta.value = "";
		document.form.eta_time.value = "";
		document.form.mi_transmit.value = "";
		document.form.mi_transmit_time.value = "";
		document.form.hi_transmit.value = "";
		document.form.hi_transmit_time.value = "";
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:

		if (!ComChkRequired(formObj))
			return false;
		return true;
		break;
	case COMMAND01:
		if (!ComChkRequired(formObj))
			return false;
		if (formObj.bl_count.value == "" || formObj.name.value == "") {
			ComShowCodeMessage('BKG00266');
			return false;
		}
		return true;
		break;
	}
}
/* 개발자 작업 끝 */