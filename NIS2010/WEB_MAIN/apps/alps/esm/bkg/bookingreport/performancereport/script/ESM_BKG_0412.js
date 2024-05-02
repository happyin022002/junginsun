/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0412.js
 *@FileTitle : Queue List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.21 김경섭
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
 * @extends 
 * @class esm_bkg_0412  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0412() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;
	this.setComboObject = setComboObject;
}

/* 개발자 작업	*/
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var rowsPerPage = 50;

var prefix = "sheet1_";//IBSheet 구분자

var bkgWinObj;

var grp_cd = "";//Current Queue 조회를 위한 전역변수  
var return_cd = "";//현재 bkg_no가 리턴 상태인지 여부  
var queueMap = new Array();

/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();

var arrWindow = new Array(null,null); 

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
//ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/*********************** EDTITABLE MULIT COMBO END********************/

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
	initControl();
}


/*
 * 화면 Open시 조회 
 * */
function inintSearch() {

	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], form, IBSEARCH);
}

function initControl() {
	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/*********************** KEY EVENT START ********************/
function bkg_keypress() {
	switch (event.srcElement.dataformat) {
		case "ymd":
			//number
			ComKeyOnlyNumber(event.srcElement, "-");
			break;
		case "engup":
			//영문대문자
			ComKeyOnlyAlphabet('upper');
			break;
		case "engupnum":
			//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "num":
			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "custname":
			//숫자 입력하기
			ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
			break;
		default:
	}
}


/*********************** KEY EVENT END ********************/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	var comboObject1 = comboObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {

		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_Retrieve":
				//sheetObject1.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0421_DATA.html");
				doActionIBSheet(sheetObjects[0], form, IBSEARCH);
				break;
				
			case "btn_Save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);  
 					break;
			case "btn_Close":
				window.close();
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);  
				break;
				
			case "btn_Delete":
				sheetObject1.CellValue2(sheetObjects[0].SelectRow, "ibflag") = "D";
				sheetObject1.RowHidden(sheetObjects[0].SelectRow)  = true;
				
				//ComRowHideDelete(sheetObject, "del_chk");
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

function openUploadWindowCheck(){
	 for (var idx=0; idx< arrWindow.length ; idx++) {
		 if(arrWindow[idx] == null || arrWindow[idx].closed) 
			 return idx;
	 }
	 
	 return 99;
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: //조회

			formObj.f_cmd.value = SEARCH;

			sheetObj.RemoveAll();
			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = true;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0412GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml);
 

			sheetObj.WaitImageVisible = false;
			sheetObj.Redraw = true;

			sheetObj.SelectCell(0, 0, false);

			break;

		case IBINSERT: // 입력
			sheetObj.DataInsert(-1);
			break;
		case IBSAVE:        //저장
 			if(validateForm(sheetObj,formObj,sAction)){
// 				sheetObj.ShowDebugMsg = true;  
 				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESM_BKG_0412GS.do", FormQueryString(formObj));
 			}

             break;
	}
}

/*
 *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
 * 초기값은 쉬트 헤더 개수
 */
var pagedMaxCnt = 2;


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
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
				style.height = 330;

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
				InitRowInfo(1, 1, 3, rowsPerPage);

				var HeadTitle1 = "|Seq.|User Group||SR Source||Criteria||Count(*)|Weight\n Value|Remark|hrd_cdg_id|hrd_cdg_seq";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(true, true, true, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  			    InitDataProperty(0,	cnt++, dtStatus,		30,		daCenter,	true,	  prefix + "ibflag");
				InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, prefix + "Seq", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, prefix + "doc_group_desc", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, prefix + "doc_group", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix + "sr_kind_desc", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 110, daCenter, false, prefix + "sr_kind", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 110, daLeft, false, prefix + "src_desc", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 110, daLeft, false, prefix + "src", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, prefix + "border", false, "", dfNone, 0, true, true );
				InitDataProperty(0, cnt++, dtData, 100, daLeft, false, prefix + "point", false, "", dfNone, 0, true, true );
				InitDataProperty(0, cnt++, dtData, 130, daLeft, false, prefix + "remark", false, "", dfNone, 0, true, true );
				InitDataProperty(0, cnt++, dtHidden, 130, daLeft, false, prefix + "hrd_cdg_id", false, "", dfNone, 0, false, false, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 130, daLeft, false, prefix + "hrd_cdg_id_seq", false, "", dfNone, 0, false, false, 0, false, false);
				 
				//RowHeight = 20;
				SelectionMode = smSelectionFree;
				
			}

			break;

	}
}

/* 개발자 작업  끝 */