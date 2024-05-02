/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_11.js
 *@FileTitle : e-Booking & SI Process Detail(HBL 2)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.12
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.12 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends 
 * @class esm_bkg_0229_11 : esm_bkg_0229_11 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_11() {
	this.processButtonClick	= tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.validateForm 		= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var iterator = "|$$|";

var isCopy = "false";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			isCopy = "false";
			top.isCopyAllRequested = false;
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");	
			break;

		case "btn_datacopytoalps":
			if (isCopy == "false") {
				dataCopy();
			}
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		// IBMultiCombo
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	initControl();
}

function initControl() {
	applyShortcut();
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
	case "sheet1":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 302;
			//전체 너비 설정
			sheetObj.SheetWidth = 300;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "||AMS File No.|SCAC|Piece";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,"ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtSeq, 	40, daCenter, 	true, "seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 220, daLeft, 	true, "usa_cstms_file_no", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, 	true, "scac_cd", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, 	true, "pck_qty", 			false, "", dfNone, 0, true, true);

			sheetObj.InitDataValid(0, "usa_cstms_file_no", vtEngUpOther, "1234567890"); // 영문대문자+숫자 입력
			sheetObj.InitDataValid(0, "scac_cd", vtEngUpOnly); // 영문대문자만 입력
			sheetObj.CountPosition = 0;
		//}
		break;

	case "sheet2":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 302;
			//전체 너비 설정
			sheetObj.SheetWidth = 300;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "||AMS File No.|SCAC|Piece";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet2_";
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtSeq, 	40, daCenter, 	true, "seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 220, daLeft, 	true, "usa_cstms_file_no", 	false, "", dfNone, 0, false, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, 	true, "scac_cd", 			false, "", dfNone, 0, false, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, 	true, "pck_qty", 			false, "", dfNone, 0, false, true);
			sheetObj.CountPosition = 0;
		//}
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH_ASYNC01: //조회
		parent.tabObjects[0].TabBackColor(11) = "#96c792";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

		break;
	case IBSEARCH: //조회
		var sXml = formObj.sXml.value;
		var arrXml = sXml.split("|$$|");
		for ( var i = 0; i < arrXml.length; i++) {
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrXml[i]);
			sheetObjects[i].Redraw = true;
		}

		formObj.hbl2_nis.value = (sheetObjects[0].TotalRows > 0)?"Y":"N";
		formObj.hbl2_esvc.value =(sheetObjects[1].TotalRows > 0)?"Y":"N";
		
		if(top.document.form.tabload11.value == "COPY"){
			dataCopy();
		}
		compareItem();
		
		top.document.form.tabload11.value = "LOAD";
		break;

	case IBSEARCH_ASYNC02: //Data Copy
		var formObj2	= document.form2;
		var obj			= null;
		var objNm 		= null;
		var objVal 		= null;
		var cntrNo 		= new Array();
		var cntrSeq 	= 0;
		var cntrTpszCd 	= new Array();
		var cntrTpszCdSeq 	= 0;
		var pckQty 		= new Array();
		var pckQtySeq 	= 0;
		var pckTpCd 	= new Array();
		var pckTpCdSeq 	= 0;
		var cntrWgt 	= new Array();
		var cntrWgtSeq 	= 0;
		var wgtUtCd 	= new Array();
		var wgtUtCdSeq 	= 0;
		var measQty 	= new Array();
		var measQtySeq 	= 0;
		var measUtCd	= new Array();
		var measUtCdSeq = 0;
		var poNo 		= new Array();
		var poNoSeq 	= 0;

		parent.tabObjects[0].TabBackColor(11) = "#fff270";

		var isInsert = true;
		for ( var i = 1; i <= sheetObjects[1].TotalRows; i++) {
			for ( var j = 1; j <= sheetObjects[0].TotalRows; j++) {
				if (sheetObjects[1].CellValue(i, "usa_cstms_file_no") == sheetObjects[0].CellValue(j, "usa_cstms_file_no")) {
					isInsert = false;
					break;
				} else {
					isInsert = true;
				}
			}
			if (isInsert) {
				var Row = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].CellValue(Row, 2) = sheetObjects[1].CellValue(i, 2);
				sheetObjects[0].CellValue(Row, 3) = sheetObjects[1].CellValue(i, 3);
				sheetObjects[0].CellValue(Row, 4) = sheetObjects[1].CellValue(i, 4);
			} else {
				if (sheetObjects[0].CellValue(i, 2) == '') {
					sheetObjects[0].CellValue(i, 2) = sheetObjects[1].CellValue(i, 2);
				}
				if (sheetObjects[0].CellValue(i, 3) == '') {
					sheetObjects[0].CellValue(i, 3) = sheetObjects[1].CellValue(i, 3);
				}
				if (sheetObjects[0].CellValue(i, 4) == '') {
					sheetObjects[0].CellValue(i, 4) = sheetObjects[1].CellValue(i, 4);
				}
			}
		}
		formObj.hbl2_nis.value = "Y";
		isCopy = "true";
		compareItem();
		break;
	}
}

/*
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm() {
	var sheetObj = sheetObjects[0];
	for (var i = 1; i < sheetObj.Rows; i++) {
		if (ComIsNull(sheetObj.CellValue(i, "usa_cstms_file_no"))) {
			//validation 변경 20100311 신은영 차장 요청
//			ComShowCodeMessage("BKG00104","AMS File No");
//			return false;
			sheetObj.RowDelete(i, false);
		}
		if (ComIsNull(sheetObj.CellValue(i, "pck_qty"))) {
			sheetObj.CellValue2(i, "pck_qty") = "0";
		}
    	for(var i = 1 ; i < sheetObj.RowCount; i++){
    		for(var j = i + 1; j <= sheetObj.RowCount; j++){
    			if(sheetObj.CellValue(i, "usa_cstms_file_no")
    					== sheetObj.CellValue(j, "usa_cstms_file_no")){
    				ComShowCodeMessage("BKG00764", sheetObj.CellValue(i, "usa_cstms_file_no"));
    				return false;
    			}
    		}
    	}
	}
	return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * Validate 실패 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동
 * Focus 이동까지 한 후 return false
 */
function validateForUpload() {	 
	return validateForm();
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	var formObj = document.form;
	
	//서버 전달 값 감소
	var sXml = formObj.sXml.value;
	formObj.sXml.value = null;

	formObj.f_cmd.value = MULTI;
	var params = FormQueryString(formObj);
	formObj.sXml.value = sXml;
	// AMS Filer US, CA 둘중에 하나라도 '1'인 경우에만 저장하도록 함. ( 이정희 차장님 요청 - 2010.05.27 - YC KIM )
	if ( ComGetObjValue(parent.frames("t1frame").document.form.usa_cstms_file_cd) == '1' || ComGetObjValue(parent.frames("t1frame").document.form.cnd_cstms_file_cd) == '1' ) {
//	if (sheetObjects[0].IsDataModified) {
		params = params + "&" + sheetObjects[0].GetSaveString(true);
	} else {
		params = "";
	}

	return (params);	
}

function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
}

//색 비교 처리
function compareItem() {
	var diffColor = sheetObjects[1].RgbColor(0, 0, 255);
	var sameColor = sheetObjects[1].RgbColor(0, 0, 0);
	var alpsSeq = 0;
	var esvcSeq = 0;
	for ( var i = 1; i <= sheetObjects[1].TotalRows; i++) {
		esvcSeq = i;
		alpsSeq = i;

		if(ComIsNull(ComTrim(sheetObjects[1].CellValue(esvcSeq, "usa_cstms_file_no")))) continue;
		
		for(var j = 1; j <= sheetObjects[0].TotalRows; j++){
			if (sheetObjects[1].CellValue(esvcSeq, "usa_cstms_file_no") == sheetObjects[0].CellValue(j, "usa_cstms_file_no")) {
				alpsSeq = j;
			}
		}
		if (sheetObjects[1].CellValue(esvcSeq, 2) != sheetObjects[0].CellValue(alpsSeq, 2)) {
			sheetObjects[1].CellFontColor(esvcSeq, 2) = diffColor;
		} else {
			sheetObjects[1].CellFontColor(esvcSeq, 2) = sameColor;			
		}
		if (sheetObjects[1].CellValue(esvcSeq, 3) != sheetObjects[0].CellValue(alpsSeq, 3)) {
			sheetObjects[1].CellFontColor(esvcSeq, 3) = diffColor;
		} else {
			sheetObjects[1].CellFontColor(esvcSeq, 3) = sameColor;
		}
		if (sheetObjects[1].CellValue(esvcSeq, 4) != sheetObjects[0].CellValue(alpsSeq, 4)) {
			sheetObjects[1].CellFontColor(esvcSeq, 4) = diffColor;
		} else {
			sheetObjects[1].CellFontColor(esvcSeq, 4) = sameColor;
		}
	}
	sheetObjects[0].ColBackColor("usa_cstms_file_no") = sheetObjects[0].RgbColor(204, 255, 253);
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	//sheet 수정시 false로 하면 다시 copy할 때 밑으로 추가됨 
//	isCopy = "false";	 
	compareItem()
}