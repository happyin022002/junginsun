/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1136.js
 *@FileTitle : ESM_BKG_1136
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.04
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2011.11.04 민정호
 * 1.0 Creation
 * 
 * 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
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
 * @class ESM_BKG_0573 : ESM_BKG_0573 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1136() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.obj_blur = obj_blur;
	this.obj_focus = obj_focus;
	this.obj_keypress = obj_keypress;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
		break;
		
		case "btn_New":
			doActionIBSheet(sheetObject,formObject,IBRESET);	
		break;
		
		case "btn_Downexcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
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
function loadPage(dType, callGubun) {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	document.form.vvd.focus();
}
 
 /**
  * 조회 후 이벤트
  * @param sheetObj
  * @param ErrMsg
  * @return
  */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	if(ErrMsg == "") {					
		var rowCnt = sheetObj.RowCount;
		
		sheetObjects[1].RemoveAll();
		sheetObjects[1].DataInsert(-1);
		sheetObjects[1].CellValue2(1,"Total") = sheetObj.CellValue(2,"total_cnt");
		sheetObjects[1].CellValue2(1,"Matched") = sheetObj.CellValue(2,"match_cnt");
		sheetObjects[1].CellValue2(1,"Unmatched") = sheetObj.CellValue(2,"unmatch_cnt");
		
		for(var i=2; i<=rowCnt+1; i++){
			if(sheetObj.CellValue(i,"pod_m") == 'U'){
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0); // read
			}
		}
		
		for(var k=rowCnt+1; k>=2; k--){
			if(sheetObj.CellValue(k,"bl") == ''){
				sheetObj.RowDelete(k,false);
			}		
		}
		
		for(var m=2; m<=sheetObj.RowCount+1; m++){
			sheetObj.CellText(m,"seq") = m-1;
		}
	}
 }

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //IBSheet1 init
		with (sheetObj) {
			//높이 설정
			style.height = 360;
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
			InitRowInfo(2, 1, 10, 100);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize],
			// [RowMove],[Head3D])
			InitHeadMode(true, true, true, true, false, false)
			
			var HeadTitle1 = "No.|Booking No.|POD|POD|POD|Container No.|Container No.|Container No.|||||";
			var HeadTitle2 = "No.|B/L|CLL|B/L|M|CLL|B/L|M|||||";			
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++, dtSeq,  50, daCenter, true, "seq", 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 160, daCenter, true, "bl", 				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "pod_cll", 			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "pod_bl", 			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_m", 			false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtData, 160, daCenter, true, "cntrno_cll",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 160, daCenter, true, "cntrno_bl",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cntrno_m", 		false, "", dfNone, 0, false, false);		
			InitDataProperty(0, cnt++, dtHidden, 110, daCenter, true, "total_cnt",		false, "", dfNone, 0, false, false);	
			InitDataProperty(0, cnt++, dtHidden, 110, daCenter, true, "match_cnt",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 110, daCenter, true, "unmatch_cnt",		false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtHiddenStatus, 0,    daCenter,  false,   "ibflag");
			
			SelectHighLight = false;
		}
		break;
	case 2:      //sheet2 init
		with (sheetObj) {
	        // 높이 설정
	        style.height = 60;
	        //전체 너비 설정
	        SheetWidth = 200;
	
	        //Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	        //전체Merge 종류 [선택, Default msNone]
	        MergeSheet = msNone;
	
	       //전체Edit 허용 여부 [선택, Default false]
	        Editable = true;
	
	        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        InitRowInfo(1, 1, 1, 100);
	
	        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(3, 0, 0, true);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, false, true, false,false)
	
	        var HeadTitle1 = "Total|Matched|Un-matched";
	
	        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        InitHeadRow(0, HeadTitle1, true);
	
	        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"Total",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	false,		"Matched",		false,			"",      dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		75,		daCenter,	false,		"Unmatched",	false,			"",      dfNone,			0,		false,		false);
	
			CountPosition = 0;
		}
		break;		
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
		return;	
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_1136GS.do", FormQueryString(formObj));
		sheetObj.FocusAfterProcess = false;
		ComOpenWait(false);	
		break;
	case IBDOWNEXCEL: // 엑셀
	 	if(sheetObj.RowCount < 1) return;
	    sheetObj.WaitImageVisible = false;  
		ComOpenWait(true); 
		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		ComOpenWait(false); 
	    sheetObj.WaitImageVisible = true;  	
		break;
	case IBRESET: // New
		formObj.reset();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		formObj.vvd.focus();
		break;				
	}
}


/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			if (!ComChkValid(formObj))
				return false;		
		break;
	}
	return true;
}

/**
* 조회조건 입력할 때 처리
*/
function obj_KeyUp() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}