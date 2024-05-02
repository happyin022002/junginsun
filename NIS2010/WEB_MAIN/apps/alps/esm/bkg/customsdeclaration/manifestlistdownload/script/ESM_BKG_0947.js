/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0947.js
 *@FileTitle : Customs Result Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.20 이수빈
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
 * @class Customs Result Code : Customs Result Code 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0947() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업    */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], formObject, MULTI);
			break;
		case "btn_Excel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
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
	case "dspo_tp_cd":
		var i = 0;
		with (comboObj) {
			//ColBackColor(0) = "#CCFFFD";
			DropHeight = 700;
			MultiSelect = false;
			MaxSelect = 0;
		}
		break;
	}
}

/**
 * 콤보 Change 이벤트 처리
 */
function dspo_tp_cd_OnChange() {
	var t_cd = comboObjects[0].Code;
	if (t_cd == "F" || t_cd == "V") {
		comboObjects[0].Code = document.form.locl_trns_cd.value;
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	doActionIBSheet(sheetObjects[0], document.form, INIT);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 470;

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

			var HeadTitle1 = "|Seq.|Country|Code|Description|H|Type|Hold\nRemoval|Auto notice|Notice to O/B|Remark(s)|Update Date|User ID";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 			70, daCenter, true, "cnt_cd", 				false, "", dfNone, 0, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true, "cstms_dspo_cd", 		false, "", dfNone, 0, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 		   150, daLeft,   true, "cstms_dspo_nm", 		false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 			40, daCenter, true, "hold", 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 		90, daCenter, true, "dspo_tp_cd", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			85, daCenter, true, "cstms_pair_dspo_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 		85, daCenter, true, "auto_ntc_flg", 		true,  "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 		85, daCenter, true, "ob_ntc_flg",		    false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 		   100, daLeft,   true, "diff_rmk", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 		 	90, daCenter, true, "upd_dt", 				false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			70, daCenter, true, "upd_usr_id", 			false, "", dfNone, 0, false, false);

			InitDataCombo(0, "auto_ntc_flg", "N|Y", "N|Y");
			InitDataCombo(0, "ob_ntc_flg", "N|Y", "N|Y");

			InitUserFormat2(0, "upd_dt", "####-##-##", "-");
		}
		break;
	}
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if ((srcName == "cnt_cd" || srcName == "cstms_dspo_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 조회 후 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var type;
	for (i = 1; i < sheetObj.RowCount + 1; i++) {
		type = sheetObj.CellValue(i, "dspo_tp_cd");
		if (type == "HP" || type == "HM") {
			sheetObj.CellEditable(i, "auto_ntc_flg") = true;
		}
	}
}

/**
 * 저장 후 처리
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
}

/**
 * 시트 데이터 변경 시 데이터, 메세지 처리
 */
function sheet1_OnChange(sheetObj, row, col, val){
	var colName = sheetObj.ColSaveName(col);
	switch (colName){
		case "dspo_tp_cd":		// Type
			if( val == "HP" || val == "HM" ){
				sheetObj.CellEditable(row, "auto_ntc_flg") = true;
			} else {
				sheetObj.CellEditable(row, "auto_ntc_flg") = false;
			}
		break;
	}
}

/** 
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
		case INIT:
			// COMBO 
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0947GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.dspo_tp_cd, "val", "desc");
			formObj.dspo_tp_cd.InsertItem(0, "|", "");
			
			var arrCombo1 = ComXml2ComboString(sXml, "desc", "val") ;
			arrCombo1[0] = " |" + arrCombo1[0];
			arrCombo1[1] = " |"  + arrCombo1[1];
			
			sheetObj.InitDataCombo(0, "dspo_tp_cd", arrCombo1[0], arrCombo1[1]);
			
			break;
		case SEARCH: //조회
			if (!validateForm(sheetObj, formObj, sAction)) return false;
    		ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0947GS.do", FormQueryString(formObj));
			setTotal();
    		ComOpenWait(false);
			break;
	
		case MULTI: //저장
			if (!validateForm(sheetObj, formObj, sAction)) return false;
    		ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_BKG_0947GS.do", FormQueryString(formObj));
			setTotal();
    		ComOpenWait(false);
			break;
	
		case IBDOWNEXCEL:
    		ComOpenWait(true);
			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
    		ComOpenWait(false);
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH: // 조회
		if (!ComChkRequired(formObj))
			return false;
		return true;
		break;
	case MULTI: //저장
		if (!sheetObj.IsDataModified)
		{
			ComShowCodeMessage("BKG00743"); // There is no updated data to save.
			return false;
		}
		break;
	}
	return true;
}

/**
 * 총 Row 수 세팅
 */
function setTotal() {
	if (sheetObjects[0].RowCount > 0) {
		document.form.total.value = sheetObjects[0].TotalRows;
	}
}

/* 개발자 작업  끝 */