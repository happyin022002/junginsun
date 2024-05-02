/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0003.js
 *@FileTitle : Inquiry of Vendor / Customer Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.18 박희동
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
 * @class fns_joo_0003 : fns_joo_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0003() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

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

			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
	
			case "btn_downexcel":
				sheetObject.SpeedDown2Excel();
				break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(crrCombo) {

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//combo 초기화
	for(var k=0;k<comboObjects.length;k++){
	    initCombo(comboObjects[k], k+1, crrCombo);
	}

	initControl();
	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    
    
    axon_event.addListener('click', 'change_event_radio', 'delt_flg');
    
    formObj.jo_crr_cd.focus();
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

//radio button click
function change_event_radio(){
	sheetObjects[0].RemoveAll();
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|Carrier|Trade|Lane|Service Provider|Customer|Service Provider / Customer Name|Address|DEL_MK";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet1_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]			
			InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, false, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtData        ,  60, daCenter, false, prefix+"jo_crr_cd"       , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData        ,  60, daCenter, false, prefix+"trd_cd"          , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData        ,  80, daCenter, false, prefix+"rlane_cd"        , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, false, prefix+"vndr_seq"        , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, false, prefix+"cust_seq"        , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData        , 220, daLeft  , false, prefix+"cust_lgl_eng_nm" , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData        , 280, daLeft  , false, prefix+"bzet_addr"       , false, "", dfNone);
			InitDataProperty(0, cnt++, dtCombo       ,  60, daCenter, false, prefix+"delt_flg"        , false, "", dfNone);
			
			InitDataCombo   (0, prefix+"delt_flg", "Yes|No", "Y|N");
		}
		break;
	case 2: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
		}
		break;
	}
}

// combo object 초기화
function initCombo(comboObj, comboNo, crrCombo) {
    var formObj = document.form

    switch(comboNo) {  
    	case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
 				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
 		    }
            var comboItems = crrCombo.split("|");
            addComboItem(comboObj, comboItems);           	
 			break; 
 			
    	case 2: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
  		    }
  			break; 

    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break; 
    } 
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: // 조회
			formObj.f_cmd.value = SEARCH;
			var prefix = "sheet1_";
			sheetObj.DoSearch("FNS_JOO_0003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;
	}
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {

    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE

			if (sComboObj.id == "trd_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH15;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = "";
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
			}else if (sComboObj.id == "rlane_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH16;
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.code.value = "";
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				var comboItems = ComGetEtcData(sXml, sComboKey).split("|");
				addComboItem(sComboObj,comboItems);
			}
														
	        break;
    }
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}

	return true;
}

//Carrier 변경시 reset
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
	
	comboObjects[1].Index2 = -1;
	comboObjects[2].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
}

//Trade에 onFocus 시 Trade Code list 조회
function trd_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj, "trd_cd");
		comboObj.Enable = true;
	}
}

//TRADE 변경시 reset 
function trd_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
}

//RLANE Code Focus 획득시 RLANE CODE LIST 조회
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1] , formObj ,IBSEARCH , comboObj, "rlane_cd");
		comboObj.Enable = true;
	}
}

//LANE 변경시 Reset
function rlane_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();	
}
/* 개발자 작업  끝 */