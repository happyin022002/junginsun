/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0067.js
 *@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2009.06.18 함대성
 * 1.0 Creation
---------------------------------------------------------------------
 * History
 * 2010.11.08 이준범 [CHM-201006731-01]
 * 1. 대상 기능
 *   - JO Member Information Creation(JOO_0066)
 *   - Inquiry of JO Member Information(JOO_0067)
 * 2. 보완 대상
 *   - Revenue Lane 정보 반영 
 *   - MS Office( Excel, Worl, Power Point등) 첨부
 *   - Carrier Name등 컬럼 반영
 * 2010.12.02 이준범 [CHM-201007349-01]
 * 1. 보완 기능 
 *   - JO Member Information Creation
 *   - Inquiry of JO Member Information
 * 2. 보완 요청 사항
 *   - 컬럼 추가 : PIC of SML(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
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
 * @class FNS_JOO_0067 : FNS_JOO_0067 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0067() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//New button click시에 IBCombo들의 change이벤트를 타지 못하도록 하기 위함
var gNew = false;

var prefix="sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break; 

		case "btn_downexcel":
			sheetObject1.SpeedDown2Excel();
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, crrCombo);
    }
    
    //initControl();
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
	var formObject = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObject); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('click'           , 'obj_onclick'  , 	formObject);
    axon_event.addListener('click', 'change_event_radio', 're_divr_cd');    
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}

function obj_activate(){
    ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")
}

function obj_onclick(){
	var src = window.event.srcElement.getAttribute("name")
}

function change_event_radio(){
	var src = window.event.srcElement.getAttribute("name")
	sheetObjects[0].RemoveAll();
}
 

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
	/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetObj.id) {
         case "sheet1":      //t1sheet1 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 460;
                
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Carrier|Lane|SEQ|Attachment|Carrier Full Name|Contact Person|E-mail Address|Tel. No.|Fax No.|Service In charge|Office Address|PIC of SML(ID)|Name of PIC|RHQ|Office|Start Date|Creation Date|crr_cntc_seq";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN,		COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,		0,			daCenter,		true,			"Status");
                 
                 InitDataProperty(0, cnt++ , dtData,	    	    50,			daCenter,		true,			prefix+"jo_crr_cd",				false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,		        60,			daCenter,		true,			prefix+"rlane_cd",				false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				30,			daCenter,		true,			prefix+"rid",			        false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtPopup,			    80,			daCenter,		true,			prefix+"file_cnt",				false,	        "",	     dfNone,	  		0,	 	true,	     true);
                 InitDataProperty(0, cnt++ , dtData,				180,		daLeft,			true,			prefix+"crr_nm",        		false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"cntc_pson_nm",			false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				140,		daLeft,			true,			prefix+"jo_cntc_eml",			false,          "",      dfNone,      		0,     false,       false);                 
                 InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"jo_cntc_phn_no",		false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				140,		daLeft,			true,			prefix+"jo_cntc_fax_no",		false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				140,		daLeft,			true,			prefix+"svc_in_chg_nm",			false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"jo_cntc_ofc_addr",		false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				100,		daCenter,		true,			prefix+"jo_cntc_pic_id",		false,          "",      dfNone,    		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				160,		daLeft,			true,			prefix+"usr_nm",		        false,          "",      dfNone,     		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				 80,		daCenter,		true,			prefix+"ar_hd_qtr_ofc_cd",      false,          "",      dfNone,      		0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				 80,		daCenter,		true,			prefix+"ofc_cd",                false,          "",      dfNone,            0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				 70,	    daCenter,		true,			prefix+"jo_cntc_st_dt",         false,          "",      dfUserFormat2,     0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,				 70,	    daCenter,		true,			prefix+"cre_dt",                false,          "",      dfUserFormat2,     0,     false,       false);
                 
                 InitDataProperty(0, cnt++ , dtHidden,			     30,		daCenter,		true,			prefix+"crr_cntc_seq",			false,          "",      dfNone,      		0,      false,      false);
     			 InitUserFormat2(0, prefix+"jo_cntc_st_dt" , "####-##-##", "-");
    			 InitUserFormat2(0, prefix+"cre_dt" , "####-##-##", "-");
				 CountPosition = 0;
				}
             break;

     }
 }

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
//			formObj.f_cmd.value = SEARCH;
//			if(formObj.jo_crr_cd.text == "ALL") {
//				formObj.jo_crr_cd.text="ALL"; 
//				formObj.hid_jo_crr_cd.text="ALL"; 
//			}
//			sheetObj.DoSearch("FNS_JOO_0067GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//			
//			if(formObj.hid_jo_crr_cd.text == "ALL") {
//				formObj.jo_crr_cd.text="ALL"; 
//				formObj.hid_jo_crr_cd.text="ALL"; 
//			}
//			break;
		case IBSEARCH: // 조회
		
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH;

			var sXml = sheetObj.GetSearchXml("FNS_JOO_0067GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			sheetObj.LoadSearchXml(sXml);
		}
 
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, crrCombo) {
    var formObject = document.form
    switch(comboObj.id) {  
    	case "jo_crr_cd": 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left|left");        
				SetColWidth("0|30");
 				DropHeight = 160;
                ValidChar(2,0);//영문대문자만 입력가능
 		    }
            var comboItems = crrCombo.split("|");
            addComboItem(comboObj, comboItems);           	
            comboObj.Index2 = 0;
            
        break; 
        
    	case "rlane_cd": 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left|left");        
 				SetColWidth("0|30");
  				DropHeight = 160;
  		    }
            var comboItems = ("ALL,ALL"+"").split("|");
            addComboItem(comboObj, comboItems); 
            formObject.rlane_cd.text = "ALL";
  			break;         
 			 
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj, sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
    
    case IBSEARCH:

			if (sComboObj.id == "rlane_cd"){
				
				var joCrrCd = formObj.jo_crr_cd.text;
				
				if (joCrrCd == "ALL") joCrrCd = "";
					
				formObj.f_cmd.value = SEARCHLIST07;
				formObj.super_cd1.value = joCrrCd;
				formObj.super_cd2.value = "";
				formObj.code.value = "";
				sheetObj.WaitImageVisible=false;
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
				var comboItems = ("ALL,ALL|"+ComGetEtcData(sXml, sComboKey)).split("|");				
				addComboItem(sComboObj, comboItems);
			}
														
	        break;
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBCREATE: //저장용 조회
		case IBSEARCH: //조회
		/*
			if (formObj.jo_crr_cd.text.length < 3){
				ComShowMessage("Select a Carrier code...");
				return false;
			}
		*/
			break; 
	}
	return true;
}
 function sheet1_OnPopupClick(sheetObj, Row, Col){
		
		var saveName = sheetObj.ColSaveName(Col);
		
		if (saveName == prefix+"file_cnt"){
			
			var joCrrCd    = sheetObj.CellValue(Row, prefix+"jo_crr_cd");
			var crrCntcSeq = sheetObj.CellValue(Row, prefix+"crr_cntc_seq");
			
			if (crrCntcSeq == "") {
				ComShowCodeMessage('JOO00003');
				return;
			}
			
			var param = "?jo_crr_cd="+joCrrCd+"&crr_cntc_seq="+crrCntcSeq+"&edit_able="+"N";
			ComOpenPopup("/hanjin/FNS_JOO_0082.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");		
		}
	}

//Carrier코드 변경시 Reset
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	var formObj = document.form;
 	sheetObjects[0].RemoveAll();
 	comboObjects[1].Index2 = -1;
 	comboObjects[1].RemoveAll();
 	comboObj.Enable = false;
 	doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[1], "rlane_cd");
 	comboObj.Enable = true;		
    formObj.rlane_cd.text = "ALL";
}

function rlane_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
}
 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
 		{
            //
 		}
}


function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){ 
	//
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	//
	 
}
/* 개발자 작업  끝 */