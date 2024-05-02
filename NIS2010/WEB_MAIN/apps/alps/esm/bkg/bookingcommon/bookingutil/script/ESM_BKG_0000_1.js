/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ui_booking_util.js
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
 * 2011.11.08 전성진 [] booking re-activate 기능 추가
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
 * @class Booking Page : Booking Page 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0000_1() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
				
			case "btn_activate":
				doActionIBSheet(sheetObjects[0],formObject, COMMAND09);
				break;
			//2015/03/03 양동훈 수정
			case "btn_noratefirm":
				doActionIBSheet(sheetObjects[0],formObject, COMMAND14);
				break;
			//수정끝
			
			//2015/03/05 양동훈 수정
			case "btnRetrieve":
				doActionIBSheet(sheetObjects[1], formObject, SEARCH16);
				break;
			case "btnSave":
				doActionIBSheet(sheetObjects[1], formObject, COMMAND15);
				break;
			//수정 끝
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
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
		case 1: //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

			}
			break;
		//2015/03/05 양동훈 수정
		case 2://sheet2
			with(sheetObj){
			// 높이 설정
            style.height = 350;
            //전체 너비 설정
            style.width = 800;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 4, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(5, 0, 0, true);
            
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, false, false, true, false, true)
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            
			var headTitle = "Status|No.|BKG_NO|CNTR_NO|CYC_NO";
			InitHeadRow(0, headTitle, true);
            
            
            
			// 데이터속성                   [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++,	dtStatus,		70,		daCenter,	false,		"ibflag"); // [필수]
			InitDataProperty(0,		cnt++,	dtDataSeq,		40,		daCenter,	false,		"seq");
			InitDataProperty(0,		cnt++,	dtData,			100,		daCenter,	false,		"bkg_no",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"cntr_no",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,	daCenter,	false,		"cnmv_cyc_no",			false,		"",			dfNone,			0,			true,		false);
			
		}
			break;
		//2015/03/05양동훈 수정 끝
	}
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: // 화면 로딩시 코드 조회
			formObj.f_cmd.value = COMMAND10;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
			
			alert(sXml);
			break;
		case COMMAND09: // 화면 로딩시 코드 조회
			formObj.f_cmd.value = COMMAND09;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));

			alert(sXml);
			break;
	//2015/03/03 양동훈 수정
		case COMMAND14:
			formObj.f_cmd.value = COMMAND14;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
			var state = ComGetEtcData(sXml,"isSuccess");
			if(state=='Y'){
				ComShowCodeMessage('BKG06071');
			}else{
				ComShowCodeMessage('BKG00202');
			}
			alert(sXml);
			break;
	//수정종료
	//2015/03/05 양동훈 수정
		case SEARCH16:
			formObj.f_cmd.value = SEARCH16;
//			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
//			sheetObj.LoadSearchXml(sXml, true);
			/*
			 * 위의 방식대로 처리해도 나옴. 하지만 검색할 때마다 결과가 append 되서 나옴
			 */
			var sParam = FormQueryString(formObj);
//			sheetObj.DoSearch("ESM_BKG_0000_1GS.do",sParam);
			sheetObj.DoSearch("ESM_BKG_0000_1GS.do", sParam);
//			alert(FormQueryString(formObj)+ "&" + ComGetPrefixParam(""));
			break;
		case COMMAND15:
			formObj.f_cmd.value = COMMAND15;
			sheetObj.DoSave("ESM_BKG_0000_1GS.do", FormQueryString(formObj));
			doActionIBSheet(sheetObjects[1], document.form, SEARCH16);

			
//			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//			alert(param);
//			sheetObj.DoSave("ESM_BKG_0000_1GS.do", param);
			break;
	}
	//수정종료
}
/* 개발자 작업  끝 */