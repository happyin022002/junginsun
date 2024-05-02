/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0167.js
 *@FileTitle : Buyer Inquiry Pop up 
 *Open Issues :     
 *Change history :   
 *@LastModifyDate : 2016.06.17
 *@LastModifier : 이율규 
 *@LastVersion : 1.0 
 * 2016.06.17 이율규		   		
 * 1.0 Creation 	 	   
=========================================================*/
/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/*-----------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

// 공통전역변수
var ipageNo = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_Close":
			self.close();
			break;

		case "btn_OK":
			setBuyerListToParentWindow();
			self.close();
			break;

		case "btn2_Down_Excel":
			sheetObject.Down2Excel(false, false, true, false, "", "", false,
					false, "", false, "0|1|2");
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

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

// 업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj = event.srcElement;
	if (obj.dataformat == null)
		return;
	window.defaultStatus = obj.dataformat;
	switch (obj.name) {
	/*
	 * case "buyer_code2": break; case "ofc_cd": ComKeyOnlyAlphabet('upper');
	 * break; case "cust_nm": // ComKeyOnlyAlphabet('upper','32'); break; case
	 * "buyer_code1": ComKeyOnlyAlphabet('upper'); break;
	 */
	}
}

function buyerControl(checkbox) {

	if (checkbox.name == "Buyer_All") {
		if (document.form.Buyer_All.checked == true) {
			document.form.Buyer_Global.checked = true;
			document.form.Buyer_RHQ.checked = true;
			document.form.Buyer_Local.checked = true;
		} else {
			if( strMnrOfficeLevel != "L1" && document.form.disp_tp_cd.value == "B"){
				document.form.Buyer_Global.checked = true;	
			}else{
				document.form.Buyer_Global.checked = false;
			}
			
			document.form.Buyer_RHQ.checked = false;
			document.form.Buyer_Local.checked = false;
		}
	} else {
		if (document.form.Buyer_Global.checked == true
				&& document.form.Buyer_RHQ.checked == true
				&& document.form.Buyer_Local.checked == true) {
			document.form.Buyer_All.checked = true;
		} else {
			document.form.Buyer_All.checked = false;
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
		// -시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// -마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	
	document.form.Buyer_All.checked = true;
	document.form.Buyer_Global.checked = true;
	document.form.Buyer_RHQ.checked = true;
	document.form.Buyer_Local.checked = true;
	
	//Office Level 조회  및 전역변수(strMnrOfficeLevel)에 세팅
	MnrOfficeLevel(currOfcCd,rhqOfcCd);
	
	if( strMnrOfficeLevel != "L1" && document.form.disp_tp_cd.value == "B" ){
		document.form.Buyer_Global.disabled = true;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1:
		with (sheetObj) {
			// 높이 설정
			style.height = 310;
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

			var HeadTitle1 = "|Sel|Seq|Buyer Code|Buyer Name|Buyer Type";

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다.
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, false,	"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 		40, 	daCenter, true,		"del_chk");
			InitDataProperty(0, cnt++, dtSeq,	 		30, 	daCenter, false, 	"Seq",				false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, false,	"mnr_prnr_id", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			500, 	daLeft,	  false,	"vndr_lgl_eng_nm", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 		80, 	daCenter, false,	"mnr_prnr_knd_cd", 	false, "", dfNone, 0, false, false);

			// 키값 히든용
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"disp_no", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"ofc_cd",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"mnr_prnr_eml", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"part_amt", 		false, "", dfNone, 0, true, true);
			// mnr_prnr_id = mnr_prnr_cnt_cd + mnr_prnr_seq
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"mnr_prnr_cnt_cd", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"mnr_prnr_seq", 	false, "", dfNone, 0, true, true);
			CountPosition = 0;

			InitDataCombo(0, "mnr_prnr_knd_cd",
					"Global Partner|RHQ Partner|Local Partner", "G|R|L")

			// SELECT 로우 배경색
			SelectionMode = smSelectionRow;
			SelectHighLight = false;
			SelectFontBold = false;
			SelectBackColor = RgbColor(SelectBackColorR, SelectBackColorG,
					SelectBackColorB);
			EditableColorDiff = true;
		}
		break;

	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH:
		// 파트너 조회
		formObj.f_cmd.value = SEARCH01;

		sParam = FormQueryString(formObj);

		var sXml = sheetObj.GetSaveXml("EES_MNR_0167GS.do", sParam);
		sheetObj.LoadSearchXml(sXml);

		break;
	}
}

function sheet1_OnSearchEnd(){
	
	var selectedBuyerArray = window.dialogArguments.document.form.selected_buyer.value.split("|");
	
	for(var i = 1; i < sheetObjects[0].Rows; i++){
		for(var j = 0; j < 	selectedBuyerArray.length; j++){
			if(sheetObjects[0].CellValue(i, "mnr_prnr_id") == selectedBuyerArray[j]){
				sheetObjects[0].CellValue(i, "del_chk") = 1;
			}
		}
		
	}
	
	if( strMnrOfficeLevel != "L1" && document.form.disp_tp_cd.value == "B"){
		for(var i = 0; i < sheetObjects[0].Rows; i++){
			if(sheetObjects[0].CellValue(i, "mnr_prnr_knd_cd") == "G"){
				sheetObjects[0].CellValue(i, "del_chk") = 1;
				sheetObjects[0].RowEditable(i) = false;
			}	
		}
	}
}


function setBuyerListToParentWindow() {

	window.dialogArguments.sheetObjects[2].RemoveAll();
	for ( var i = 1; i < sheetObjects[0].Rows; i++) {
		if (sheetObjects[0].CellValue(i, "del_chk") == 1) {
			var mnr_prnr_id 	= sheetObjects[0].CellValue(i, "mnr_prnr_id")
			var vndr_lgl_eng_nm = sheetObjects[0].CellValue(i, "vndr_lgl_eng_nm")
			var mnr_prnr_knd_cd = sheetObjects[0].CellValue(i, "mnr_prnr_knd_cd")
			var mnr_prnr_cnt_cd = sheetObjects[0].CellValue(i, "mnr_prnr_cnt_cd")
			var mnr_prnr_seq 	= sheetObjects[0].CellValue(i, "mnr_prnr_seq")
			window.dialogArguments.setBuyerList(mnr_prnr_id, vndr_lgl_eng_nm, mnr_prnr_knd_cd, mnr_prnr_cnt_cd, mnr_prnr_seq);
		}
	}
}

function sheet1_OnClick(Row, Col, Value) {
	if (document.form.disp_tp_cd.value == "C"
			&& sheetObjects[0].FindCheckedRow("del_chk") != "") {
		var sRow = sheetObjects[0].FindCheckedRow("del_chk");
		var arrRow = sRow.split("|");
		sheetObjects[0].CellValue(arrRow[0], "del_chk") = 0;
	}
}

// /**
// * 화면 폼입력값에 대한 유효성검증 프로세스 처리
// */
// function validateForm(sheetObj,formObj,sAction){
// with(formObj){
//           
// }
//
// return true;
// }
