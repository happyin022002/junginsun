/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0270.js
 *@FileTitle : Freight & Charge_S/C Note
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.26 이진서
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
 * @class esm_bkg_0270 : esm_bkg_0270 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0270() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0270GS.do';
var prefix1 = "sheet1_";
var prefix2 = "sheet2_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	if (document.form.bkg_no.value == '' 
		|| document.form.svc_scp_cd.value == ''
		|| document.form.application_date.value == ''
		) {
		ComShowMessage("[sc_no],[svc_scp_cd],[application_date]은/는 필수입력 항목 입니다.");
		self.close();
	}
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

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
	switch (sheetNo) {

	case 1:
		with (sheetObj) {

			// 높이 설정
			style.height = 122;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Type|Seq|Title|Content|Effective Date|Effective Date";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "hdnStatus");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix1 + "type", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix1 + "seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, prefix1 + "title", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 540, daLeft, true, prefix1 + "content", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix1 + "effect_dt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix1 + "expire_dt", false, "", dfNone, 0, false);

			//ShowButtonImage = 2;
			CountPosition = 0;
		}
		break;

	case 2:
		with (sheetObj) {

			// 높이 설정
			style.height = 122;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Type|Seq|Title|Content|Effective Date|Effective Date";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "hdnStatus");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix2 + "type", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix2 + "seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, prefix2 + "title", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 540, daLeft, true, prefix2 + "content", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix2 + "effect_dt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix2 + "expire_dt", false, "", dfNone, 0, false);

			//ShowButtonImage = 2;
			CountPosition = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet1_", "sheet2_");
	var prefix = sheetObj.id + "_";

	switch (sAction) {

	case IBSEARCH: //조회
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
		ComSetObjValue(formObj.f_cmd, SEARCH);

		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		// 3.조회후 결과처리
		var arrXml = sXml.split("|$$|");
		//1. OFT Note를 조회한다. 2. Surcharg Note를 조회한다. 
		for ( var inx = 0; inx < arrXml.length; inx++) {
			sheetObjects[inx].LoadSearchXml(arrXml[inx]);
		}
//		var arbitrary_note = ComGetEtcData(arrXml[0], "arbitrary_note");
//		ComSetObjValue(formObj.arbitrary_note, arbitrary_note);

		var idx = 1;
		//1. OFT Note를 존재시 보여진다. 2. Surcharg Note를 존재시 보여진다. 
//		for ( var inx = 0; inx < arrXml.length; inx++) {
//			if (sheetObjects[inx].TotalRows > 0) {
//				eval('DIV_sheet' + idx++).style.display = '';
//			}
//		}
		//3. Arbitrary Note를 존재시 보여진다.
//		if (arbitrary_note.length > 0) {
//			eval('DIV_sheet3').style.display = '';
//		}

		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}

	return true;
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

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
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}
/**
 * Sheet를 클릭하였을 경우 Content 를 모두 보여준다
 */
function sheet1_OnClick(sheetObj,row,col,value){
	//desc 셀을 클릭했을때 MemoPad를 표시한다
	if(sheetObj.ColSaveName(col) == prefix1 + "content"){
//		ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)	
		ComShowMemoPad(sheetObj,null,null,true,sheetObj.ColWidth(col),null,1000);
	}
}
 /**
  * Sheet를 클릭하였을 경우 Content 를 모두 보여준다
  */
 function sheet2_OnClick(sheetObj,row,col,value){
 	//desc 셀을 클릭했을때 MemoPad를 표시한다
 	if(sheetObj.ColSaveName(col) == prefix2 + "content"){
// 		ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)	
 		ComShowMemoPad(sheetObj,null,null,true,sheetObj.ColWidth(col),null,1000);
 	}
 }
 
 
/* 개발자 작업  끝 */