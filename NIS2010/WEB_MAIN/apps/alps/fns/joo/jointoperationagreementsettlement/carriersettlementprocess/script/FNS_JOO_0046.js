/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0046.js
 *@FileTitle : Adjustment Over Used Slot Hire for RDR
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.16
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.10.16 박희동
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
 * @class FNS_JOO_0046 : FNS_JOO_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0046() {
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

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gCurRow = 0;
var prefix = "sheet1_";


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
		if (srcName == null || srcName == "re_divr_cd") {
			return;
		}

		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
		case "btn_left_fm":
	    	sheetObjects[0].RemoveAll();
			if (formObject.fm_acct_yrmon.value!=""){
				var fr = ComGetDateAdd(formObject.fm_acct_yrmon.value+"-01","M",-1).substring(0,7);
				var to = formObject.to_acct_yrmon.value;

				if (!UF_checkPeriod(fr, to)){
					formObject.fm_acct_yrmon.focus();
					return;
				}
				formObject.fm_acct_yrmon.value = fr;
			}
			break;

		case "btn_right_fm":
	    	sheetObjects[0].RemoveAll();
			if (formObject.fm_acct_yrmon.value!=""){
				var fr = ComGetDateAdd(formObject.fm_acct_yrmon.value+"-01","M", 1).substring(0,7);
				var to = formObject.to_acct_yrmon.value;
				if (!UF_checkPeriod(fr, to)){
					formObject.fm_acct_yrmon.focus();
					return;
				}
				formObject.fm_acct_yrmon.value = fr;
			}
			break;

		case "btn_left_to":
	    	sheetObjects[0].RemoveAll();
			if (formObject.to_acct_yrmon.value!=""){
				var fr = formObject.fm_acct_yrmon.value;
				var to = ComGetDateAdd(formObject.to_acct_yrmon.value+"-01","M",-1).substring(0,7);
				if (!UF_checkPeriod(fr, to)){
					formObject.to_acct_yrmon.focus();
					return;
				}
				formObject.to_acct_yrmon.value = to;
			}
			break;

		case "btn_right_to":
	    	sheetObjects[0].RemoveAll();
			if (formObject.to_acct_yrmon.value!=""){
				var fr = formObject.fm_acct_yrmon.value;
				var to = ComGetDateAdd(formObject.to_acct_yrmon.value+"-01","M", 1).substring(0,7);
				if (!UF_checkPeriod(fr, to)){
					formObject.to_acct_yrmon.focus();
					return;
				}
				formObject.to_acct_yrmon.value = to;
			}
			break;

		case "btn_delete":
			JooRowHideDelete(sheetObject1, prefix+"del_chk");
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_new":
			sheetObjects[0].RemoveAll();
			formObject.jo_crr_cd.Index2 = -1;
			formObject.trd_cd.Index2 = -1;
			formObject.rlane_cd.Index2 = -1;
			formObject.re_divr_cd[0].checked = true;
			formObject.fm_acct_yrmon.focus();
			break;

		case "btn_save":
			//doActionIBSheet(sheetObject1, formObject, IBSAVE);
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
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
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
	var formObject = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate', formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , formObject); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'    , formObject);    

    axon_event.addListener('click'   , 'change_event_radio'    , 're_divr_cd');
    
    formObject.fm_acct_yrmon.focus();
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
    
    if (window.event.srcElement.getAttribute("name") == "fm_acct_yrmon"){
    	var fm = ComReplaceStr(document.form.fm_acct_yrmon.value,"-","")+"01";	
    	var to = ComReplaceStr(document.form.to_acct_yrmon.value,"-","")+"01";
    	
    	if (!UF_checkPeriod(fm,to)){
    		document.form.fm_acct_yrmon.value="";
    		document.form.fm_acct_yrmon.focus();
    	}
    }
    
    if (window.event.srcElement.getAttribute("name") == "to_acct_yrmon"){
    	var fm = ComReplaceStr(document.form.fm_acct_yrmon.value,"-","")+"01";	
    	var to = ComReplaceStr(document.form.to_acct_yrmon.value,"-","")+"01";
    	
    	if (!UF_checkPeriod(fm,to)){
    		document.form.to_acct_yrmon.value="";
    		document.form.to_acct_yrmon.focus();
    	}
    }
    
}

function obj_activate(){
    ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")
    if (src == "fm_acct_yrmon" || src == "to_acct_yrmon"){
    	ComKeyOnlyNumber(this, '');
    }
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

function obj_onclick(){
	var src = window.event.srcElement.getAttribute("name")
}

function change_event_radio(){
	var src = window.event.srcElement.getAttribute("name")
	sheetObjects[0].RemoveAll();

	//re_divr_cd 가 변경될때에도 rlane을 읽어온다.
	if (document.form.trd_cd.Code.length == 3){
		doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[2] ,"rlane_cd");
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
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "SEL|CFM|VSL|VOY|Dir.|Fin\nDir.|Unit Cost\nBasic Port|Inter port/\nOcean|RGN|Dep.\nPort|Schedule|COA 1st BSA|COA 1st BSA|JOO BSA|JOO BSA|Diff. BSA|Diff. BSA|JOO Used Slot|JOO Used Slot|RDR Used Slot|RDR Used Slot|"
					+ "Settled\nOver Used|COA BSA \nOver Used\nSlot Price|JOO Over Used\nSlot Price|CUR.|Combined\nNO";
			var HeadTitle2 = "SEL|CFM|VSL|VOY|Dir.|Fin\nDir.|Unit Cost\nBasic Port|Inter port/\nOcean|RGN|Dep.\nPort|Schedule|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|"
				+ "Settled\nOver Used|COA BSA \nOver Used\nSlot Price|JOO Over Used\nSlot Price|CUR.|Combined\nNO"

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 6, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var calcT = "|sheet1_coa_teu| - |sheet1_fnl_hjs_bsa_qty|";
			var calcW = "|sheet1_coa_wgt| - |sheet1_fnl_bsa_wgt|";

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, true,	prefix+"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox    ,  35, daCenter, true, prefix+"cfm"            , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  35, daCenter, true, prefix+"vsl_cd"         , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  35, daCenter, true, prefix+"skd_voy_no"     , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  35, daCenter, true, prefix+"skd_dir_cd"     , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  35, daCenter, true, prefix+"rev_dir_cd"     , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true, prefix+"uc_bss_port_cd" , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true, prefix+"ioc_cd"         , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  35, daCenter, true, prefix+"sconti_cd"      , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"fm_port_cd"     , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true, prefix+"fm_port_etd_dt" , false, ""   , dfUserFormat2, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  50, daRight , true, prefix+"coa_teu"        , false, ""   , dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  60, daRight , true, prefix+"coa_wgt"        , false, ""   , dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  50, daRight , true, prefix+"fnl_hjs_bsa_qty", false, ""   , dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  60, daRight , true, prefix+"fnl_bsa_wgt"    , false, ""   , dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  50, daRight , true, prefix+"diff_teu"       , false, calcT, dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  60, daRight , true, prefix+"diff_wgt"       , false, calcW, dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  50, daRight , true, prefix+"usd_slt_bsa_qty", false, ""   , dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  60, daRight , true, prefix+"usd_slt_wgt"    , false, ""   , dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  60, daRight , true, prefix+"rdr_teu"        , false, ""   , dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  70, daRight , true, prefix+"rdr_wgt"        , false, ""   , dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  85, daRight , true, prefix+"bsa_qty"        , false, ""   , dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  85, daRight , true, prefix+"uc_amt"         , false, ""   , dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     ,  85, daRight , true, prefix+"bsa_slt_prc"    , false, ""   , dfNullFloat  , 2, false, true);
			InitDataProperty(0, cnt++, dtData        ,  70, daRight , true, prefix+"locl_curr_cd"   , false, ""   , dfNone       , 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,  70, daRight , true, prefix+"stl_cmb_seq"    , false, ""   , dfNone       , 0, false, true);
			
			InitUserFormat2(0, prefix+"fm_port_etd_dt" , "####-##-## ##:##:##", "-|:");			
		}
		break;
		
	case 2: // sheet1 init
		sheetObj.style.height = 0;
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
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0046GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObject = document.form
    
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
            var comboItems = gCrrCombo.split("|");
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
 				SetColAlign("left|left|left");        
 				SetColWidth("30|0|0"); //rlane_cd, currency, auth_cd
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break;
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "trd_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST06;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = "";
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
			}else if (sComboObj.id == "rlane_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST16;
				formObj.code.value = formObj.jo_stl_itm_cd.value; //Item
				formObj.name.value = JooGetRadioValue(formObj.re_divr_cd); //re_divr_cd
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|name|auth_cd");
			}
														
	        break;
    }
}

//TRADE 변경시 LANE 변경
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();	
	comboObjects[1].Index2 = -1;
	comboObjects[2].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
}

function trd_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"trd_cd");
		comboObj.Enable = true;	
	}	
}

//TRADE 변경시 LANE 변경
function trd_cd_OnChange(comboObj, idx_cd, text){
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
	sheetObjects[0].RemoveAll();
}

function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[1].Code.length < 3){
		ComShowCodeMessage("JOO00009");
		formObj.trd_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj, "rlane_cd");
		comboObj.Enable = true;	
	}	
}

//RLANE 변경시 clear
function rlane_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();
	document.form.locl_curr_cd.value = comboObj.GetText(code,1);
	UF_setAuth(comboObj.GetText(code,2));
}

function rlane_cd_OnBlur(comboObj){
	if (comboObj.Code.length == 5){
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

function UF_setAuth(auth){
	if (auth == null || auth == undefined){
		auth = "R";
	}
	var editable = true;
	if (auth == "R"){
		editable = false;
	}
	JooSetBtnClass("C", editable);
	for (var i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].Editable = editable;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			if (formObj.fm_acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00089');
				formObj.fm_acct_yrmon.focus();
				return false;
			}
			if (formObj.to_acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00089');
				formObj.to_acct_yrmon.focus();
				return false;
			}
			
			var fmDate = ComReplaceStr(formObj.fm_acct_yrmon.value,"-","")+"01";
			var toDate = ComReplaceStr(formObj.to_acct_yrmon.value,"-","")+"01";
			
			var fmDateAdd6m = ComGetDateAdd(fmDate,"M",6);

			//6개월 이상 차이나면 error message
			if (ComGetDaysBetween(fmDateAdd6m, toDate) > 0){
				ComShowCodeMessage("JOO00090");
				formObj.fm_acct_yrmon.focus();
				return false;
			}
			
			if (formObj.jo_crr_cd.index == -1){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			break;
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SumText(0,prefix+"vsl_cd") = "TOTAL"; //TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	var sName = sheetObj.ColSaveName(Col);

	var Value = sheetObj.EditValue;
	//4자리 치면 NEXT로 이동
	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
	}

	//4자리 치면 NEXT로 이동
	if (sName == prefix+"skd_voy_no" && Value.length==4){
		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	gCurRow = Row;
}

/**
 * acct_yrmon이 변경되었을 경우 sheet내의 Insert mode인 row의 acct_yrmon을 변경한다.
 * @param acctYrmon
 * @return
 */
function UF_setAcctYrmon(acctYrmon){
	var sheetObj = sheetObjects[0];
	for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		if (sheetObj.RowStatus(inx) != "I") continue;
		sheetObj.CellValue2(inx, prefix+"acct_yrmon") = acctYrmon;
	}
}

function UF_checkPeriod(fr, to){
	var fmDate = ComReplaceStr(fr)+"01";  
	var toDate = ComReplaceStr(to)+"01";  

	if (ComGetDaysBetween(fmDate, toDate) < 0){
		ComShowCodeMessage("JOO00078");
		return false;
	}
	
//	var fmDateAdd6m = ComGetDateAdd(fmDate,"M",6);
//	
//	if (ComGetDaysBetween(fmDateAdd6m, toDate) > 0){
//		ComShowCodeMessage("JOO00090");
//		return false;
//	}
	
	return true;
}
/* 개발자 작업  끝 */