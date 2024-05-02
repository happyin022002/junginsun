/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0048.js
 *@FileTitle : Stevedore Damage Part Code (Inquiry)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.12
 *@LastModifier : 장석현
 *@LastVersion : 1.0
 * 2009.05.12 장석현
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
 * @class vop_opf_0048 : vop_opf_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function vop_opf_0050() {
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

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;

		case "btn_DownExcel":
			//sheetObject1.Down2Excel(1);
            var paramObj = new Object();
            paramObj.title = "";
            paramObj.orientation = "Portrait";
            paramObj.columnwidth = "1:5|2:6|3:42|4:20";
            var url = ComOpfGetExcelSet(sheetObject1, paramObj);
            sheetObject1.Down2Excel(-1, false,false, true, "", url);
			break;			

		case "btn_close":
			window.close();
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
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

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 480;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			// MergeSheet = msNone;
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|No.|Code|Description|Category";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,	"ibflag");
			InitDataProperty(0, cnt++, dtDataSeq,	50,	daCenter,	true,	"seq",	false,  "", dfInteger);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "stv_dmg_cd", true, "", dfNone, 0, false, true, 3, true);
			InitDataProperty(0, cnt++, dtData, 250, daLeft, true,	"stv_dmg_cd_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 100, daLeft, false,	"stv_dmg_cate_cd", false, "", dfNone, 0, true, true);
			InitDataValid(0, "stv_dmg_cd", vtEngUpOther, "/");
			InitDataCombo(0, "stv_dmg_cate_cd", "Hull|Machinary|Material", "HULL|MACH|MATL", "Hull", "HULL");
			// CountPosition = 0;

		}
		break;

	}
}

// Sheet관련 프로세스 처리
// function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
function doActionIBSheet(sheetObj, formObj, sAction) {
//	// alert("doActionIBSheet 이동네까지 가나?");
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				// alert("btn_retrieve SEARCH");
				sheetObj.DoSearch("VOP_OPF_0050GS.do", FormQueryString(formObj));
				// alert("btn_retrieve SEARCH UI_FMS_0006GS.do");
			}
		}
		break;

	case IBSAVE: // 저장
//		alert("doActionIBSheet case IBSAVE 이동네까지 가나?");
		if(!validateForm(sheetObj, formObj, sAction)) {
//			alert("doActionIBSheet case IBSAVE !validateForm(sheetObject1,formObject) 이동네까지 가나?");
			return false;
		}
////		alert("doActionIBSheet case IBSAVE formObj.f_cmd.value = MULTI 전 이동네까지 가나?");
		formObj.f_cmd.value = MULTI;
		if(sheetObj.DoSave("VOP_OPF_0048GS.do", FormQueryString(formObj))){
//			alert("doActionIBSheet case IBSAVE sheetObj.DoSave(VOP_OPF_0048GS.do, FormQueryString(formObj)) 성공 이동네까지 가나?");
			ComShowCodeMessage('OPF00017');		
		}
		break;
	case IBINSERT: // 입력
		sheetObj.DataInsert();
		break;

	case COMMAND01: // 카피
		sheetObj.DataCopy();
		break;

	case COMMAND02: // 추가
		sheetObj.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가
		break;

	case IBDELETE: // 삭제
		ComRowHideDelete(sheetObj, "del_chk");
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
//	alert("validateForm 시작 이동네까지 가나?");
	if (sAction == IBSAVE) {
//		alert("validateForm if (sAction == IBSAVE) 시작 이동네까지 가나?");
		var row = sheetObj.ColValueDupRows("stv_dmg_cd");
//		alert("rar row = sheetObj.ColValueDupRows(stv_dmg_cd)"+row);
		if (row.length > 0)  {
			ComShowCodeMessage('OPF00016');
			var arrRows = row.split(",");
//			sheetObj.CellValue(arrRows[0],"stv_dmg_cd") = "";
//       		sheetObj.SelectCell(i, 3, true);
//			sheetObj.SelectCell(arrRows[0],"stv_dmg_cd",true);
			sheetObj.SelectCell(arrRows[0],2,true);
			return false;
		}
		
	}

	return true;
}

/* 개발자 작업 끝 */