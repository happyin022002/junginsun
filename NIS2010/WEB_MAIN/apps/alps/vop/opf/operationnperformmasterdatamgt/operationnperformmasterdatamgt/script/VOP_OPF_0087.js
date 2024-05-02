/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0087.js
 *@FileTitle : Reason for Excluding from TPR (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.14
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.14 우지석
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
 * @class vop_opf_0087 : vop_opf_0087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function vop_opf_0087() {
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

	var sheetObject1 = sheetObjects[0]; // t1sheet1

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

		case "btn_RowAdd":
			doActionIBSheet(sheetObject1, formObject, COMMAND02);
			break;

		case "btn_RowInsert":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;

		case "btn_RowCopy":
			doActionIBSheet(sheetObject1, formObject, COMMAND01);
			break;

		case "btn_Delete":
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
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
			style.height = 462;
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

			var HeadTitle1 = "|Sel.|No.|Code|Reason for Excluding from TPR";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox,		50,	daCenter,	true,	"del_chk",				false,	"",	dfNone,	0,	true,	true);
			InitDataProperty(0, cnt++, dtSeq, 			50,	daCenter,	true,	"Seq.");
			InitDataProperty(0, cnt++, dtData,			80,	daCenter,	false,	"tml_prod_rpt_rsn_cd",	true,	"",	dfNone,	0,	false,	true, 3,	true);
			InitDataProperty(0, cnt++, dtData,			300,daLeft,		false,	"tml_prod_rpt_rsn_desc",false,	"",	dfNone,	0,	true,	true, 500);
            
			InitDataValid(0, "tml_prod_rpt_rsn_cd",  vtEngUpOther, "1,2,3,4,5,6,7,8,9,0,/,-,~,!,@,#,$,%,^,&,*,(,),=,{,},[,],|,:,");
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("VOP_OPF_0087GS.do", FormQueryString(formObj));
				}
			}
			break;
	
		case IBSAVE: // 저장
			if(!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
		    formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("VOP_OPF_0087GS.do", FormQueryString(formObj), -1, false);
		    break;
	
		case IBINSERT: // 입력
			var row = sheetObj.DataInsert();
			sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
			break;
	
		case COMMAND01: // 카피
			var row = sheetObj.DataCopy();
			sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
			break;
	
		case COMMAND02: // 추가
			var row = sheetObj.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가
			sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
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
	if (sAction == IBSAVE) {
		var row = sheetObj.ColValueDupRows("tml_prod_rpt_rsn_cd");
		if (row.length > 0)  {
			ComShowCodeMessage("OPF50005", 'Data');	//'{?msg1} is duplicated.'
			var arrRows = row.split(",");
			sheetObj.SelectCell(arrRows[0],3,true);
			return false;
		}
	}

	return true;
}

/* 개발자 작업 끝 */