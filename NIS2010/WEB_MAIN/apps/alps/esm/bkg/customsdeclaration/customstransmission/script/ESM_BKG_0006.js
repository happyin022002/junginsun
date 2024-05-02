/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0006.js
 *@FileTitle : Canada Export EDI Transmit
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
function ESM_BKG_0006() {
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
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_downexcel":
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_terminal":
			document.form.terminal_auto_snd.value = "";
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_editbl":
			sheet1_OnDblClick(sheetObjects[0], sheetObjects[0].selectRow, 5);
			break;
		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.atd_from_dt, formObject.atd_to_dt, 'yyyy-MM-dd');
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

	document.form.vvd_cd.focus();

	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

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
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 100);

			var HeadTitle1 = "|Sel.|NO|SEND DATE|BKG No.|B/L No.|VVD|ETD|POR|POL|POD|DEL|BDR FLG";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "chk", false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 130, daCenter, true,  "mf_snd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "bkg_no", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "bl_no", false, "", dfTimeHms, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "vvd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "etd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "por_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "del_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bdr_flg", false, "", dfNone, 0, false, false);			
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

	if (keyValue != 9 && keyValue !=16 &&(srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
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
		formObject.vvd_cd.className = "input";
		formObject.pol_cd.className = "input";
		formObject.atd_from_dt.disabled = false;
		formObject.atd_to_dt.disabled = false;
		formObject.atd_from_tm.disabled = false;
		formObject.atd_to_tm.disabled = false;
		ComSetObjValue(formObject.atd_from_dt, ComGetNowInfo());
		ComSetObjValue(formObject.atd_to_dt, ComGetNowInfo());
	} else {
		formObject.vvd_cd.className = "input1";
		formObject.pol_cd.className = "input1";
		formObject.atd_from_dt.disabled = true;
		formObject.atd_to_dt.disabled = true;
		formObject.atd_from_tm.disabled = true;
		formObject.atd_to_tm.disabled = true;
		ComSetObjValue(formObject.atd_from_dt, '');
		ComSetObjValue(formObject.atd_to_dt, '');
		ComSetObjValue(formObject.atd_pod_cd, '');		
	}
}

/**
 * 조회 후 버튼 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//삭제요청
/*	if (sheetObj.CellValue(1, "bdr_flg") == "Y") {
		ComBtnDisable("btn_terminal");
	} else {
		ComBtnEnable("btn_terminal");
	}
*/	
}

/**
 * 헤더 클릭 시 Sort 처리
 */
function sheet1_OnSort(sheetObj, col, sortArr) {
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;

	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0006GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
		
	case MULTI: //Transmit
		if (!validateForm(sheetObj, formObj, sAction)) return false;
			
		var sParam = "f_cmd=" + MULTI;
		var sPreBlNo = "";
		for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
			if ( sheetObj.CellValue(i, "chk") ){
				if (sPreBlNo != sheetObj.CellValue(i, "bkg_no")) {
					sParam = sParam + "&bl_no=" + sheetObj.CellValue(i, "bkg_no") + "&vvd_cd=" + sheetObj.CellValue(i, "vvd_cd");
					sPreBlNo = sheetObj.CellValue(i, "bkg_no");
				}
			}
		}
		
		sParam = sParam + "&vvd_cd=" + formObj.vvd_cd.value;
		
		ComOpenWait(true, true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0006GS.do", sParam);
		// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림 3초마다
		var key = ComGetEtcData(sXml, "KEY");
		intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

		break;	
   }
}

/**
 * BackEndJob 실행결과조회.
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0006GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
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
		ComShowCodeMessage('BKG00101');
		// sheet1, sheet2 다시 조회
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //조회
		
		//기본포멧체크
		if ( ( ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pol_cd) ) && !formObj.gubun.checked ) {
			ComShowCodeMessage('BKG00626', "'VVD or POL");
			ComSetFocus(form.vvd_cd)
			return false;
		}
		
		if (formObj.gubun.checked) {
			if (ComIsNull(formObj.atd_from_dt) || ComIsNull(formObj.atd_from_tm) ||
				ComIsNull(formObj.atd_to_dt) || ComIsNull(formObj.atd_to_tm)) {
				ComShowCodeMessage('BKG00626', "Vessel A.T.D. and Actual POL");
				return false;
			}
			
			if(!ComIsDate(formObj.atd_from_dt.value)){
				ComShowCodeMessage( "BKG00651", formObj.atd_from_dt.value);			
				return false;
			}
			
			if(!ComIsDate(formObj.atd_to_dt.value)){
				ComShowCodeMessage( "BKG00651", formObj.atd_to_dt.value);			
				return false;
			}
			
	    	if (!ComIsTime(ComGetObjValue(formObj.atd_from_tm),"hm")) {
	    		ComAlertFocus(formObj.time,ComGetMsg("COM132201","Time")); 
	    		return;
	    	}
	    	
	    	if (!ComIsTime(ComGetObjValue(formObj.atd_to_tm),"hm")) {
	    		ComAlertFocus(formObj.time,ComGetMsg("COM132201","Time"));
	    		return;
	    	}
			
			if (ComIsNull(formObj.atd_pod_cd)) {
					ComShowCodeMessage('BKG00626', "Actual POL ");
					return false;
			}
			
			var days = ComGetDaysBetween(formObj.atd_from_dt.value, formObj.atd_to_dt.value);
			if (days >= 15) {
				ComShowCodeMessage('BKG50468'); // Can't Input Date Over 15 days!"
				formObj.atd_from_dt.focus();
				return false;
			}
			
		}
		return true;
		break;
		
	case MULTI:

		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}

		if (!sheetObj.IsDataModified) {
			ComShowCodeMessage("BKG00249"); // No Selected Row
			return false;
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

	if ( Col == 4) {
		comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
	} else if ( Col == 5) {	
		comBkgCallPop0566(sheetObj.CellValue(Row,"bkg_no"));
	}
	
}

/* 개발자 작업  끝 */