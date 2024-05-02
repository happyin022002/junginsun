/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_BKG_0078.js
 *@FileTitle : Booking Reactivation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.15
 *@LastModifier : 양동훈
 *@LastVersion : 1.0
 * 2015.12.15 양동훈
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
function esm_bkg_0078() {
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
var sheetCnt = 0;
var searchFlg = false;
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
	if (event.keyCode == 13) { // Enter Key  			
		switch (event.srcElement.name) {
		case "bkgNo":
			document.getElementById("bkgNo").value = (document.getElementById("bkgNo").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "trunkVVD":
			document.getElementById("trunkVVD").value = (document.getElementById("trunkVVD").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "polCd":
			document.getElementById("polCd").value = (document.getElementById("polCd").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			
		case "podCd":
			document.getElementById("podCd").value = (document.getElementById("podCd").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		}
	}
}
function obj_change() {
	switch (event.srcElement.name) {
		case "bkgNo":
			document.getElementById("bkgNo").value = (document.getElementById("bkgNo").value).toUpperCase();
			break;
		case "trunkVVD":
			document.getElementById("trunkVVD").value = (document.getElementById("trunkVVD").value).toUpperCase();
			break;	
		case "polCd":
			document.getElementById("polCd").value = (document.getElementById("polCd").value).toUpperCase();
			break;	
		case "podCd":
			document.getElementById("podCd").value = (document.getElementById("podCd").value).toUpperCase();
			break;	
		case "sts":
			if(document.getElementById("sts").value!="X"){
				document.getElementById("cxlRsn").value = "ALL";
			}
			break;
		case "cxlRsn":
			if(document.getElementById("cxlRsn").value!="ALL"){
				document.getElementById("sts").value = "X";
			}
	}
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
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
				
			case "btn_Reactivate":
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
		case 1://sheet2
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
            InitColumnInfo(17, 0, 0, true);
            
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, false, false, true, false, true)
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            
			var headTitle = "|Chk|No.|BKG_NO|T.VVD|T.Lane|STS|POL|POD|ETD|Cancel Date|Canceled By|Cancel Office|Canceled Reason|Reactive Date|Reactivated By|Reactive Office";
			InitHeadRow(0, headTitle, true);
            
            
            
			// 데이터속성                   [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++,	dtHiddenStatus,		20,		daCenter,	false,		"ibflag"); // [필수]
			InitDataProperty(0,     cnt++,  dtCheckBox,   30, daCenter, true, "DelChk");
			InitDataProperty(0,		cnt++,	dtDataSeq,		35,		daCenter,	false,		"seq");
			InitDataProperty(0,		cnt++,	dtData,			110,		daCenter,	false,		"bkg_no",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			100,	daCenter,	false,		"t_vvd",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,	daCenter,	false,		"t_lane",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			35,	daCenter,	false,		"bkg_sts_cd",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,	daCenter,	false,		"pol_cd",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,	daCenter,	false,		"pod_cd",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			130,	daCenter,	false,		"pol_etd_dt",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			130,	daCenter,	false,		"cxl_dt",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			120,	daCenter,	false,		"cxl_by",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			120,	daCenter,	false,		"cxl_ofc",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			120,	daCenter,	false,		"cxl_rsn",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			130,	daCenter,	false,		"ract_dt",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			120,	daCenter,	false,		"ract_by",			false,		"",			dfNone,			0,			false,		false);
			InitDataProperty(0,		cnt++,	dtData,			80,	daCenter,	false,		"ract_ofc",			false,		"",			dfNone,			0,			false,		false);
			
			
		}
			break;
	}
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: // 화면 로딩시 코드 조회
			if(formObj.trunkVVD.value==''&&formObj.bkgNo.value==''){
				alert("Please input BKG NO. or VVD.");
				return false;
			}
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			sheetObj.DoSearch("ESM_BKG_0078GS.do", sParam);
			searchFlg = true;
			break;
		case COMMAND01: // 화면 로딩시 코드 조회
			if (searchFlg == false){
				alert('Please retrieve first.');
				return false;
			}
			var countChk = 0;
			for ( var i = 1; i <= sheetObj.RowCount; i++) {
				if(sheetObj.CellValue(i, "DelChk") == "1" && sheetObj.CellValue(i, "bkg_sts_cd") == "F"){
					alert('This Bkg NO. has already been reactivated.');
					return false;
				}
				if(sheetObj.CellValue(i, "DelChk") == "1"){
					countChk++;
				}
			}
			if(countChk==0){
				alert("Please select row");
				return false;
			}
			
			formObj.f_cmd.value = COMMAND01;
			var params = FormQueryString(formObj);
			//sheet가 많을 땐 아래처럼 prefix넣어서 구분함
//			var sParamSheet1 = ComSetPrifix(sheetObj.GetSaveString(false,true,"DelChk"),"sheet1_");
			
			var sParamSheet1 = sheetObj.GetSaveString(false,true,"DelChk");
			sParamSheet1 = sParamSheet1+"&f_cmd="+formObj.f_cmd.value;
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0078GS.do", sParamSheet1);
			
			var state = ComGetEtcData(rXml,"isSuccess");
			if(state=='Y'){
				alert('Reactivation has been done successfully');
				retFlag = true;
			}else{
				alert('Failed to reactivate the Booking. Please contact the administrator.');
				retFlag = false;
			}
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var cntCxl = 0;
	if(sheetObjects[0].RowCount > 0){
		for(var i=1;i<=sheetObjects[0].RowCount; i++){
			if(sheetObjects[0].CellValue(i, "bkg_sts_cd") == "X"){
				cntCxl++;
			}
		}
	}
	sheetObjects[0].ColFontUnderline("bkg_no") = true; 
	document.getElementById("totCnt").value = sheetObjects[0].TotalRows;
	document.getElementById("cxlCnt").value = cntCxl;
}
function sheet1_OnDblClick(sheetObj, Row,Col){
	if(sheetObj.ColSaveName(Col) == "bkg_no"){
		ComBkgCall0079(sheetObj.CellValue(Row,Col)); 	
	}
}

function sheet1_OnChange(sheetObj, Row, Col){
	var sum = 0;
	for(var i=1;i<=sheetObj.RowCount; i++){
		if(sheetObj.CellValue(i, "DelChk")==1)
			sum += 1;
	}
	if(sum>1){
		sheetObj.CellValue2(Row, "DelChk") = 0;
		alert('BKG Reactivation is only allowed for one booking. Please select one booking.');
	}
}
/* 개발자 작업  끝 */