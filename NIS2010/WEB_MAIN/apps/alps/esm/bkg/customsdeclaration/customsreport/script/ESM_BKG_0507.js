/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0507.js
 *@FileTitle : US AMS: Transmission History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.14
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.14 이수빈
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
 * @class US AMS: Transmission History : US AMS: Transmission History 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0507() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
 
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// OFM 조회 시 허용된 USER_ID --> 하드 코딩 삭제 (오픈 시 로그인 아이디 OFM 조회권한 조회)
// var arrUser = new Array('SDS_KOR','110804','EDI_KOR','110039','110035','04900013','03191005','03206014','03206015','03206030');

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_calendar":
			if (formObject.snd_fromd.disabled)
				return;
			var cal = new ComCalendarFromTo();
			cal.select(formObject.snd_fromd, formObject.snd_tod, 'yyyy-MM-dd');
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;

		case "btn_new":
			doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
			
			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.vvd,"");
			ComClearManyObjects(document.form.pol_cd,"");
			ComClearManyObjects(document.form.pod_cd,"");
			
			break;

		case "btn_file":
			doActionIBSheet(sheetObjects[0], formObject, IBROWSEARCH);
			break;

		case "btn_ofm_retrieve":
			formObject.io_bnd_cd.value = 'O';
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;

		case "btn_ofm_file":
			doActionIBSheet(sheetObjects[0], formObject, IBROWSEARCH);
			break;
		case "btn_downexcel":
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
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
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "trsm_msg_tp_id":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#CCFFFD";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
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

	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	// 콤보 데이터 생성
	var sXml = document.form.code_list.value;
	ComXml2ComboItem(sXml, document.form.trsm_msg_tp_id, "val", "name|desc");
	document.form.trsm_msg_tp_id.Code = 'AL';

	if ( document.form.io_bnd_cd.value == "I" ) {
		comboObjects[0].DeleteItem("XI");
	} else {
		document.form.trsm_msg_tp_id.value = 'XI';	
		comboObjects[0].DeleteItem("AL");
		comboObjects[0].DeleteItem("MI");
		comboObjects[0].DeleteItem("AI");
		comboObjects[0].DeleteItem("HI");
		comboObjects[0].DeleteItem("TI");
		comboObjects[0].DeleteItem("BA");
		comboObjects[0].DeleteItem("SN");
		comboObjects[0].index = 0;
	}	

	ComBtnDisable("btn_file");

	// OFM History Retrieve, View OFM File 버튼 활성화 처리
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

	// ComBtnDisable("btn_ofm_retrieve");
	// ComBtnDisable("btn_ofm_file");

	// var usrId = document.form.usr_id.value;
	// for(i=0; i<arrUser.length; i++){
	// if(arrUser[i] == usrId){
	// ComBtnEnable("btn_ofm_retrieve");
	// }
	// }

	document.form.vvd.focus();

	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
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
			InitRowInfo(1, 1, 4, 1000);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			ShowSortArrow = true;

			var HeadTitle1 = "|Seq.|MSG|SEND DATE|SEND DATE|OFFICE|USER ID|VVD|POL|POD|Customs|B/L No.|TTL CNTR|||||||RCV DATE";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "trsm_msg_tp_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "snd_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "snd_tm", false, "", dfTimeHms, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "ofc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "usr_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pod_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cstms_port_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "cntr_knt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, false, "stwg_snd_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cnt_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "io_bnd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "his_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "snd_date", false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 200, daCenter, false, "msg_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "rcv_dt", false, "", dfUserFormat2, 0, true, true);			

			InitUserFormat2(0, "snd_date", "####-##-## ##:##:##", "-|:|:");
			InitUserFormat2(0, "rcv_dt", "####-##-## ##:##:##", "-|:|:");

			CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;
	}
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

	if (keyValue != 9 && keyValue !=16 &&(srcName == "vvd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 체크박스 클릭 시 처리
 */
function obj_click() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");
	var srcVal = srcObj.checked;

	if (srcName == "gubun") {
		alterRequiredChk(srcVal);
	}
}

/**
 * 체크박스 상태에 따라 버튼 처리
 */
function alterRequiredChk(checked) {
	var formObject = document.form;

	if (checked) {
		formObject.snd_fromd.disabled = false;
		formObject.snd_tod.disabled = false;
		formObject.snd_fromt.disabled = false;
		formObject.snd_tot.disabled = false;
	} else {
		formObject.snd_fromd.disabled = true;
		formObject.snd_tod.disabled = true;
		formObject.snd_fromt.disabled = true;
		formObject.snd_tot.disabled = true;
		formObject.vvd.focus();
	}
}

/**
 * 조회 후 버튼 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == '' && sheetObj.RowCount > 0) {
		var io_bnd_cd = document.form.io_bnd_cd.value;

		if	(io_bnd_cd == "O") {
			ComBtnEnable("btn_file");
		} else { 
			if (io_bnd_cd == "I") {
				ComBtnEnable("btn_file");
				ComBtnDisable("btn_ofm_file");
			} else {
				ComBtnEnable("btn_ofm_file");
				ComBtnDisable("btn_file");
				if (document.form.trsm_msg_tp_id.Code != 'AL' && document.form.trsm_msg_tp_id.Code != 'MI') {
					document.form.trsm_msg_tp_id.Code = 'MI';
				}
			}
		}
	}
}

/**
 * 헤더 클릭 시 Sort 처리
 */
function sheet1_OnSort(sheetObj, col, sortArr) {
	if (col == 3) {
		sheetObj.ColumnSort("snd_dt|snd_tm", sortArr);
	}
}

//수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;

	switch (sAction) {

	case IBCREATE:
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0507GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], formObj.rct_rhq_cd, "val", "desc");
		var userAuthStr = ComGetEtcData(arrXml[0], "user_auth_str");

		// OFM List Retrieve, Preparation 버튼 활성권한 셋업.
		if ( formObj.io_bnd_cd.value == 'I' ) {
			if (userAuthStr == "Y") {
				ComBtnEnable("btn_ofm_retrieve");
				ComBtnEnable("btn_ofm_file");
			} else {
				ComBtnDisable("btn_ofm_retrieve");
				ComBtnDisable("btn_ofm_file");
			}
		}
		break;

	case IBSEARCH: //조회
		
		fn_auto_notification(sheetObj);
		
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		if (formObj.bl_no.value != "") {
			formObj.vvd.value = "";
			formObj.pol_cd.value = "";
			formObj.pod_cd.value = "";
			formObj.snd_ofc_cd.value = "";
			formObj.snd_usr_id.value = "";
			formObj.lst_for_pol.value = "";
			comboObjects[0].index = 0;
			comboObjects[1].index = 0;

			formObj.snd_fromd.value = today;
			formObj.snd_tod.value = today;
			formObj.gubun.checked = false;
			formObj.auto_notification.checked = false;
			alterRequiredChk(false);
		}

		var ioBndCd = formObj.io_bnd_cd.value;
		if (ioBndCd == "I") {
			formObj.ofm_flg.value = 'N';
		} else {
			formObj.ofm_flg.value = 'Y';
		}
		sheetObj.DoSearch("ESM_BKG_0507GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;

	case IBSEARCHAPPEND: // 페이징 조회
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0507GS.do", CondParam, "page_no=" + PageNo, true);
		ComOpenWait(false);
		break;

	case IBROWSEARCH:
		if (sheetObj.RowCount == 0)
			return false;

		var params;
		var vvd = sheetObj.CellValue(sheetObj.SelectRow, "vvd");
		var pol = sheetObj.CellValue(sheetObj.SelectRow, "pol_cd");
		var pod = sheetObj.CellValue(sheetObj.SelectRow, "pod_cd");
		var ofc = sheetObj.CellValue(sheetObj.SelectRow, "ofc_cd");
		var usr = sheetObj.CellValue(sheetObj.SelectRow, "usr_id");
		params = "vvd2=" + vvd + "&pol=" + pol + "&pod=" + pod + "&ofc=" + ofc + "&usr=" + usr;

		var msg_tp = sheetObj.CellValue(sheetObj.SelectRow, "trsm_msg_tp_id");
		if (msg_tp == "BAPLIE" || msg_tp == "ISF-5") {
			var stwg_snd_id = sheetObj.CellValue(sheetObj.SelectRow, "stwg_snd_id");
			var snd_date = sheetObj.CellValue(sheetObj.SelectRow, "snd_date");
			params = params + "&trsm_msg_tp_id=" + msg_tp + "&stwg_snd_id=" + stwg_snd_id + "&snd_date=" + snd_date;
		} else {
			var cnt_cd = sheetObj.CellValue(sheetObj.SelectRow, "cnt_cd");
			var io_bnd_cd = sheetObj.CellValue(sheetObj.SelectRow, "io_bnd_cd");
			var snd_date = sheetObj.CellValue(sheetObj.SelectRow, "snd_date");
			var his_seq = sheetObj.CellValue(sheetObj.SelectRow, "his_seq");
			params = params + "&trsm_msg_tp_id=" + msg_tp + "&cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd + "&snd_date="
					+ snd_date + "&his_seq=" + his_seq;
		}

		if	(document.form.io_bnd_cd.value == "I") {
			if (ComIsBtnEnable("btn_ofm_file")) {
				params = params + "&ofm=Y";
			} else {
				params = params + "&ofm=N";
			}
		} else {
			params = params + "&ofm=N";
		}
		ComOpenWindowCenter("ESM_BKG_0508.do?" + params, "ESM_BKG_0508", 500, 640);
		break;

	case IBCLEAR: //조회조건 초기화
		formObj.reset();
		comboObjects[0].Code = 'AL';
		sheetObj.RemoveAll();
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //조회
		if (formObj.gubun.checked) {
			if (!ComChkRequired(formObj))
				return false;

			var days = ComGetDaysBetween(formObj.snd_fromd.value, formObj.snd_tod.value);
			
			if (formObj.auto_notification.checked) {
				if (days >= 31) {
					ComShowCodeMessage('BKG50468'); // Can't Input Date Over 31 days!"
					formObj.snd_fromd.focus();
					return false;
				}				
			} else {
				if (days >= 15) {
					ComShowCodeMessage('BKG50468'); // Can't Input Date Over 15 days!"
					formObj.snd_fromd.focus();
					return false;
				}
			}
		} else {
			if (formObj.vvd.value == '' && formObj.bl_no.value == '') {
				ComShowMessage("'VVD' or 'B/L No.'" + Msg_Required);
				return false;
			}
		}
		return true;
		break;
	default:
		return true;
		break;
	}
} 

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	if (document.form.io_bnd_cd.value != "O") {
		document.form.io_bnd_cd.value = "";
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
	}
}

/**
 * Auto Notification 
 */
function fn_auto_notification(sheetObj){
	var formObj = document.form;
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");
	var srcVal = srcObj.checked;
	
	var trsm_msg_tp_id = formObj.trsm_msg_tp_id.Code;		
	if ( (formObj.auto_notification.checked) && (trsm_msg_tp_id == "AL" || trsm_msg_tp_id == "MI" || trsm_msg_tp_id == "AI")) {
		sheetObj.ColHidden("rcv_dt") = false;
		formObj.auto_gubun.value = "X";
	} else {
		sheetObj.ColHidden("rcv_dt") = true;
		formObj.auto_notification.checked = false;
		formObj.auto_gubun.value = "";
	}
	if (formObj.bl_no.value != "") {
		sheetObj.ColHidden("rcv_dt") = true;
	}
	
}


/* 개발자 작업  끝 */