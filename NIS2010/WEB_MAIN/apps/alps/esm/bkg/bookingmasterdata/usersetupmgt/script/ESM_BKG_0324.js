/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESM_BKG_0324.js
 *@FileTitle : Dangerous Cargo Filtering setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.28
 *@LastModifier : 양동훈
 *@LastVersion : 1.0
 * 2016.03.28 양동훈
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
 * @class Booking Page : Booking Page 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0324() {
	this.processButtonClick = processButtonClick;
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
var sheetObjectsMap = new Array();
var sheetCnt = 0;
var retFlg;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function initControl() {
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)    	
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	
	applyShortcut();
}
function obj_keydown() {
//	if (event.keyCode == 13) { // Enter Key  			
//		switch (event.srcElement.name) {
//		case "bkgNo":
//			document.getElementById("bkgNo").value = (document.getElementById("bkgNo").value).toUpperCase();
//			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//			break;
//		}
//	}
}
function obj_change() {
//	switch (event.srcElement.name) {
//		case "bkgNo":
//			document.getElementById("bkgNo").value = (document.getElementById("bkgNo").value).toUpperCase();
//			break;
//	}
}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	/*******************************************************/
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn1_Row_Add":
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
				break;
			
			case "btn_Delete":
				doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;	
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
				
			case "btn_Save":
				retFlag = false;
				doActionIBSheet(sheetObjects[0],formObject, COMMAND01);
				if(retFlag==true)
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
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
	sheetObjectsMap[sheet_obj.id] = sheet_obj;
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
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
		case 1://sheet1
			with(sheetObj){
			// 높이 설정
            style.height = 350;
            //전체 너비 설정
            style.width = 965;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 4, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(12, 0, 0, true);
            
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, false, false, true, false, true)
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            
			var headTitle = "|Chk|Seq.||Type|Keyword||Remark|Cre_User|Cre_Date|Upd_User|Upd_Date";
			InitHeadRow(0, headTitle, true);
            
            
            
			// 데이터속성                   [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++,	dtHiddenStatus,		20,		daCenter,	false,		"ibflag"); // [필수]
			InitDataProperty(0,     cnt++,  dtCheckBox,     30,     daCenter,   true,       "Sel");
			InitDataProperty(0,		cnt++,	dtDataSeq,		35,		daCenter,	false,		"Seq");
			InitDataProperty(0,		cnt++,	dtHidden,		80,		daCenter,	false,		"blck_kw_tp_seq",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,		daCenter,	false,		"blck_kw_tp_cd",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			200,	daCenter,	false,		"blck_kw_nm",			false,		"",			dfNone,			0,			true,		true);
			InitDataProperty(0,		cnt++,	dtHidden,		200,	daCenter,	false,		"blck_kw_ctnt",			false,		"",			dfNone,			0,			true,		true);
			InitDataProperty(0,		cnt++,	dtData,			200,	daCenter,	false,		"blck_kw_rmk",			false,		"",			dfNone,			0,			true,		true);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"cre_usr_id",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"cre_dt",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"upd_usr_id",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"upd_dt",			false,		"",			dfNone,			0,			false,		false);
			
		}
			break;
	}
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: // 화면 로딩시 코드 조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			sheetObj.DoSearch("ESM_BKG_0325GS.do", sParam);
			break;
			
		case IBINSERT: // 입력
			var Row = sheetObj.DataInsert(-1);
			var blckTpCd = document.form.blck_kw_tp_cd.value;
			if("POT"==blckTpCd){
				sheetObj.CellValue(sheetObj.SelectRow,4) = "POT";
			}else if("MIS"==blckTpCd){
				sheetObj.CellValue(sheetObj.SelectRow,4) = "MIS";
			}
			break;
		
		case IBDELETE:
			ComRowHideDelete(sheetObj, "Sel");
			break;
			
		case COMMAND01: // 화면 로딩시 코드 조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			
			formObj.f_cmd.value = COMMAND01;
//			var params = FormQueryString(formObj);
			//sheet가 많을 땐 아래처럼 prefix넣어서 구분함
//			var sParamSheet1 = ComSetPrifix(sheetObj.GetSaveString(false,true,"DelChk"),"sheet1_");
			
//			var sParamSheet1 = sheetObj.GetSaveString(false,true,"DelChk");
//			sParamSheet1 = sParamSheet1+"&f_cmd="+formObj.f_cmd.value;
//			var rXml = sheetObj.GetSaveXml("ESM_BKG_0325GS.do", sParamSheet1);
			
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("");
            sheetObj.DoSave("ESM_BKG_0325GS.do", sParam);
            retFlag = true;
			break;
	}
	
	ComOpenWait(false);

	
}
function searchByTpCd(){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
}
function sheet1_OnDblClick(sheetObj, Row,Col){
	
}

function sheet1_OnChange(sheetObj, Row, Col){
	/* 대문자 */
	var data_type = sheetObj.ReadDataProperty(Row, Col, 0);
	if(data_type == dtData) {
		sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
	}
}
/* 개발자 작업  끝 */