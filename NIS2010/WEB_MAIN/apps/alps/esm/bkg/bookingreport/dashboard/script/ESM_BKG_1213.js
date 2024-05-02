/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1213.js
 *@FileTitle : Report Item Option
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.21
 *@LastModifier : Eun jung Park
 *@LastVersion : 1.0
 * 2013.10.21 Eun jung Park
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
 * @class esm_bkg_0895 : esm_bkg_0895 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1213() {
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

// opener 창에서 클릭되었던 row 의 정보가 이 창으로 넘어오기전에 저장되었는지 여부를 확인하는 변수
var savedStatus = 'false';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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

	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	// rpt_fom_no
	if (document.form.edit_yn.value == "N") {
		ComBtnDisable("btn_OK");
	}

	checkSavedStatusFromOpener();
}

function checkSavedStatusFromOpener() {
	if (document.form.checkIbflag.value == "I"
			|| document.form.checkIbflag.value == "U") {
		savedStatus = 'false';
	} else {
		savedStatus = 'true';
	}
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetObj.id) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 520;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Item Name|||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dp_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true,
					"dbd_irr_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "rpt_id");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "dp_seq");

		}
		break;

	case "sheet2": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 520;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			var HeadTitle = "ibflag|Sel.|Seq.|Selected Items|||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dp_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true,
					"dbd_irr_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "rpt_id");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "dp_seq");
		}
		break;
		
	case "sheet3":
		with (sheetObj) {
		// 높이 설정
		style.height = 100;
			
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		
		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;
		
		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;
		
		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 15, 50);
		
		var HeadTitle1 = "ibflag| Sel. |Seq.|report no|Report Name|Report Form Description|Edit";
		
		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
		InitHeadMode(true, true, true, true, false,false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
                
		
		//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		//InitDataProperty(0, cnt++ , dtSeq,					35,		daCenter,		false,		 	"Seq");
		InitDataProperty(0, cnt++ , dtHiddenStatus, 0,	daCenter,		true,		"ibflag");                                                            
		
		InitDataProperty(0, cnt++ , dtDummyCheck,		 	40,	daCenter,		true,		 "sel_chk");
		InitDataProperty(0,	cnt++,	dtSeq,					30,		daCenter,	false,		"seq");
		InitDataProperty(0, cnt++ , dtData,					80,	daLeft,		false,	 "rpt_fom_no",			    false,			"",      dfNone,			0,		false,		false,50);
		InitDataProperty(0, cnt++ , dtData,					150,	daCenter,		false,	 "rpt_fom_nm",			    false,			"",      dfNone,			0,		false,		true, 100);
		InitDataProperty(0, cnt++ , dtData,					250,	daLeft,		false,	 "rpt_fom_desc",			    false,			"",      dfNone,			0,		true,		true, 1000);
		InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	false,	 "edit",	false,			"",      dfNone,			0,		false,	false);
				
				
		CountPosition = 0;//[1/3] 페이지 위치 
	}
				
					break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btns_add":
			addDelRow("add");
			break;

		case "btns_del":
			addDelRow("del");
			break;

		case "btns_up":
			rowUpDown(sheetObject2, "UP");
			break;

		case "btns_down":
			rowUpDown(sheetObject2, "DOWN");
			break;

		case "btn_OK":

			doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
			//opener 로 레포트 form no. 를 보낸다.
			doActionIBSheet(sheetObjects[2],document.form,SEARCH04);
			opener.sheetObjects[0].CellValue2(opener.selected, "rpt_fom_no") = sheetObjects[2].CellValue(1, "rpt_fom_no")
			opener.sheetObjects[0].CellEditable(opener.selected, "rpt_fom_nm") = false;
			/*
			 * returnValue(); 2010.01.21 0104 의 Save 버튼을 눌러준다
			 * opener.setSearchSaveOption();
			 */
			break;

		case "btn_Close":
			self.close();
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		formObj.f_cmd.value = SEARCH02;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var resultXml = sheetObj.GetSearchXml("ESM_BKG_1213GS.do",
				FormQueryString(formObj));

		var arrXml = resultXml.split("|$$|");

		sheetObjects[0].LoadSearchXml(arrXml[0], false);
		sheetObjects[1].LoadSearchXml(arrXml[1], false);

		ComOpenWait(false);

		break;

	case IBSAVE: // 저장

		formObj.f_cmd.value = MULTI01;
		sheetObjects[1].DoSave("ESM_BKG_1213GS.do", FormQueryString(formObj));

		formObj.f_cmd.value = SEARCH02;
		ComOpenWait(true);
		var resultXml = sheetObj.GetSearchXml("ESM_BKG_1213GS.do",
				FormQueryString(formObj) + '&savedStatus=' + savedStatus);
		var arrXml = resultXml.split("|$$|");

		sheetObjects[0].LoadSearchXml(arrXml[0], false);
		sheetObjects[1].LoadSearchXml(arrXml[1], false);

		ComOpenWait(false);
		break;

	case IBINSERT: // 입력
		break;
		
	case SEARCH04:        //저장
		formObj.f_cmd.value = SEARCH04;
		sheetObj.DoSearch("ESM_BKG_1212GS.do", FormQueryString(formObj)+"&reportName="+document.form.f_rptFomNm.value);
		//alert(sheetObj.CellValue(1, "rpt_fom_no"));
		
		break;	
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
 * ok event
 */
function returnValue() {

	var reValue = '';

	for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {

		// if (sheetObjects[1].CellValue(i,0) == '1'){

		reValue = reValue + "|" + sheetObjects[1].CellValue(i, "dbd_irr_tp_cd")
				+ ">" + sheetObjects[1].CellValue(i, "rpt_id");
		// }
	}

	opener.setTemplate(reValue);

	self.close();
}

/**
 * row 추가/삭제
 */
function addDelRow(type) {

	if (type == "add") {

		for ( var i = 1; i < sheetObjects[0].RowCount + 1; i++) {

			if (sheetObjects[0].CellValue(i, 1) == '1') {

				var chkValue = true;

				for ( var j = 1; j < sheetObjects[1].RowCount + 1; j++) {

					if (sheetObjects[0].CellValue(i, "dp_nm") == sheetObjects[1]
							.CellValue(j, "dp_nm")) {
						chkValue = false;
						break;
					}
				}

				if (chkValue) {
					var row = sheetObjects[1].DataInsert(-1);

					sheetObjects[1].CellValue2(row, "dp_nm") = sheetObjects[0]
							.CellValue(i, "dp_nm");
					sheetObjects[1].CellValue2(row, "dbd_irr_tp_cd") = sheetObjects[0]
							.CellValue(i, "dbd_irr_tp_cd");
					sheetObjects[1].CellValue2(row, "rpt_id") = sheetObjects[0]
							.CellValue(i, "rpt_id");
					sheetObjects[1].CellValue2(row, "dp_seq") = sheetObjects[0]
							.CellValue(i, "dp_seq");
				} else {
					// alert("exist same data");
				}
			}
		}
	} else {

		var idx = sheetObjects[1].RowCount;

		for ( var i = 1; i < idx + 1; i++) {

			for ( var j = 1; j < sheetObjects[1].RowCount + 1; j++) {

				if (sheetObjects[1].CellValue(j, 1) == '1') {

					sheetObjects[1].RowDelete(j, false);

				}
			}
		}
	}
}

/**
 * row UP/DOWN
 */
function rowUpDown(sheetObj, type) {

	Row = sheetObj.SelectRow;

	if (sheetObj.RowCount > 0) {

		if (type == 'UP') {

			if (Row > 1) {

				var tempUPCheck = sheetObj.CellValue(Row - 1, "check");
				var tempUPItem = sheetObj.CellValue(Row - 1, "dp_nm");
				var tempUPTbl = sheetObj.CellValue(Row - 1, "dbd_irr_tp_cd");
				var tempUPCol = sheetObj.CellValue(Row - 1, "rpt_id");
				var tempUPSeq = sheetObj.CellValue(Row - 1, "dp_seq");

				var tempNowCheck = sheetObj.CellValue(Row, "check");
				var tempNowItem = sheetObj.CellValue(Row, "dp_nm");
				var tempNowTbl = sheetObj.CellValue(Row, "dbd_irr_tp_cd");
				var tempNowCol = sheetObj.CellValue(Row, "rpt_id");
				var tempNowSeq = sheetObj.CellValue(Row, "dp_seq");

				sheetObj.CellValue(Row - 1, "check") = tempNowCheck;
				sheetObj.CellValue(Row - 1, "dp_nm") = tempNowItem;
				sheetObj.CellValue(Row - 1, "dbd_irr_tp_cd") = tempNowTbl;
				sheetObj.CellValue(Row - 1, "rpt_id") = tempNowCol;
				sheetObj.CellValue(Row - 1, "dp_seq") = tempNowSeq;

				sheetObj.CellValue(Row, "check") = tempUPCheck;
				sheetObj.CellValue(Row, "dp_nm") = tempUPItem;
				sheetObj.CellValue(Row, "dbd_irr_tp_cd") = tempUPTbl;
				sheetObj.CellValue(Row, "rpt_id") = tempUPCol;
				sheetObj.CellValue(Row, "dp_seq") = tempUPSeq;

				sheetObj.SelectCell(Row - 1, 1);
			}
		} else {

			if (Row < sheetObj.RowCount) {

				var tempDWCheck = sheetObj.CellValue(Row + 1, "check");
				var tempDWItem = sheetObj.CellValue(Row + 1, "dp_nm");
				var tempDWTbl = sheetObj.CellValue(Row + 1, "dbd_irr_tp_cd");
				var tempDWCol = sheetObj.CellValue(Row + 1, "rpt_id");
				var tempDWSeq = sheetObj.CellValue(Row + 1, "dp_seq");

				var tempNowCheck = sheetObj.CellValue(Row, "check");
				var tempNowItem = sheetObj.CellValue(Row, "dp_nm");
				var tempNowTbl = sheetObj.CellValue(Row, "dbd_irr_tp_cd");
				var tempNowCol = sheetObj.CellValue(Row, "rpt_id");
				var tempNowSeq = sheetObj.CellValue(Row, "dp_seq");

				sheetObj.CellValue(Row + 1, "check") = tempNowCheck;
				sheetObj.CellValue(Row + 1, "dp_nm") = tempNowItem;
				sheetObj.CellValue(Row + 1, "dbd_irr_tp_cd") = tempNowTbl;
				sheetObj.CellValue(Row + 1, "rpt_id") = tempNowCol;
				sheetObj.CellValue(Row + 1, "dp_seq") = tempNowSeq;

				sheetObj.CellValue(Row, "check") = tempDWCheck;
				sheetObj.CellValue(Row, "dp_nm") = tempDWItem;
				sheetObj.CellValue(Row, "dbd_irr_tp_cd") = tempDWTbl;
				sheetObj.CellValue(Row, "rpt_id") = tempDWCol;
				sheetObj.CellValue(Row, "dp_seq") = tempDWSeq;

				sheetObj.SelectCell(Row + 1, 1);
			}
		}
	}
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {

	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		sheetObj.CellValue(i, "ibflag") = 'I';
	}

}
/* version up 2010.1.22 */
/* 개발자 작업 끝 */