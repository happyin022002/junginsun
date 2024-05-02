/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0241.js
 *@FileTitle : e-Booking & SI Process - Copy Option
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.03
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.07.03 전용진
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
 * @author SM LINE
 */

/**
 * @extends 
 * @class esm_bkg_0241 : esm_bkg_0241 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0241() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_go":
			var bkgNo = ComGetObjValue(formObject.bkg_no);
			if(null == bkgNo || "" == bkgNo) { return; }
	    	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
	    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1601", popParams, "");
			break;
			
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch(sheetId) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 250;
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
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = "Charge|Tariff Item No.|Cur|Rate|Rated As|Per|Amount|Term";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "chg_cd", true, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false, "trf_itm_no", false, "", dfNone, 0, false, false, 15);
			InitDataProperty(0, cnt++, dtPopupEdit, 55, daCenter, false, "curr_cd", true, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "chg_ut_amt", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "rat_as_qty", true, "", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtPopupEdit, 45, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 85, daRight, false, "chg_amt", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "frt_term_cd", true, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "mod_yn");
			CountPosition = 0;
		}
		break;
		
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 250;
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
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = "Charge|Tariff Item No.|Cur|Rate|Rated As|Per|Amount|Term";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "chg_cd", true, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false, "trf_itm_no", false, "", dfNone, 0, false, false, 15);
			InitDataProperty(0, cnt++, dtPopupEdit, 55, daCenter, false, "curr_cd", true, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 80, daRight, false, "chg_ut_amt", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "rat_as_qty", true, "", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtPopupEdit, 45, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 85, daRight, false, "chg_amt", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "frt_term_cd", true, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "mod_yn");
			CountPosition = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	case IBSEARCH: 
	    	formObj.f_cmd.value = SEARCH;
			
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0241GS.do", FormQueryString(formObj));
            var arrXml = sXml.split("|$$|");

            sheetObjects[0].LoadSearchXml(arrXml[0]);              
            var cmpbRtFlg = ComGetObjValue(formObj.cmpb_rt_flg);
            var bkgRtFlg = ComGetObjValue(formObj.bkg_rt_flg);
            if(cmpbRtFlg!="Y"&&bkgRtFlg!="Y"){
            	sheetObjects[1].LoadSearchXml(arrXml[1]);
            }
			var bColor = sheetObjects[0].RgbColor(0, 0, 255);
			var rColor = sheetObjects[0].RgbColor(255, 0, 0);
			var sColor = sheetObjects[0].RgbColor(187, 14, 216);
			for ( var i = 1; i < sheetObjects[0].RowCount + 1; i++) {
				if (sheetObjects[0].CellValue(i, "mod_yn") == "Y") {
					sheetObjects[0].RowFontColor(i) = rColor;
				} 
			}
	    	
        break;
	
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {

		}
	}

	return true;
}