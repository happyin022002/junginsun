/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0050.js
 *@FileTitle : Target Voyage vs Unsettled Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 장강철
 *@LastVersion : 1.0
 * 2009.07.10 장강철
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
 * @class FNS_JOO_0050 : FNS_JOO_0050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0050() {
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

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
			
		case "btn_New":
			doActionIBSheet(sheetObjects[0], document.form, IBRESET);
			break;

		case "btn_DownExcel":
			//sheetObjects[0].SpeedDown2Excel(-1);
            var paramObj = new Object();
            var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
            sheetObjects[0].Down2Excel(-1, false,false, true, "", url);   
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
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	initControl();

}

/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
	var formObject = document.form

	switch (comboNo) {

	case 1:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2,0);//영문대문자만 입력가능
			MaxLength=3;
		}
		var comboItems = (" |"+gTrdCd).split("|");
		addComboItem(comboObj, comboItems);           	
		break;

	case 2:
		with (comboObj) { 
			MultiSelect = false; 
			UseAutoComplete = true;	
			SetColAlign("left");        
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2,1);//영문대문자+숫자만 입력가능
			MaxLength=5;
		}
		var comboItems = (" |"+gRlaneCd).split("|");
		addComboItem(comboObj, comboItems);           	
		break;

	case 3:
		with (comboObj) { 
			MultiSelect = false; 
			UseAutoComplete = true;	
			SetColAlign("left");        
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2,0);//영문대문자만 입력가능
			MaxLength=3;
		}
		var comboItems = (" |"+gJoCrrCd).split("|");
		addComboItem(comboObj, comboItems);
		break;

	case 4:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2,2);//영문대문자만 입력가능
			MaxLength=3;
		}
		var comboItems = (" |"+gJoStlItmCd).split("|");
		addComboItem(comboObj, comboItems);
		break;
	case 5:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2,2);//영문대문자만 입력가능
			MaxLength=3;
		}
		var comboItems = gOffList.split("|");
		addComboItem(comboObj, comboItems);
		comboObj.Index2 = 0;
        if (comboItems.length == 1){
        	comboObj.Enable = false;
        }else{
        	comboObj.Enable = true;
        }		
		break;
	}
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	var formObject = document.form;
	axon_event.addListenerForm('keydown', 'ComKeyEnter', formObject);
	axon_event.addListenerForm('keypress', 'fnObjKeyPress', formObject);

	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_fr_back");
	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_fr_next");
	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_to_back");
	axon_event.addListener('click', 'fnDocClick', "btn_acct_yrmon_to_next");
    axon_event.addListener('click', 'diff_only_yn_click', 'diff_only_yn');
    axon_event.addListener('click', 'rmk_yn_click', 'rmk_yn');

	axon_event.addListenerFormat('blur', 'fnDeactivate', formObject);
	axon_event.addListenerFormat('focus', 'fnActivate', formObject);
	
	comboObjects[0].focus();
}

function diff_only_yn_click(){
	var form = document.form;
	var sheetObj = sheetObjects[0];
	sheetObj.RemoveAll();
	
	if (form.diff_only_yn.checked){
		form.diff_only_yn.value = "Y";
	}else{
		form.diff_only_yn.value = "N";		
	}
}

function rmk_yn_click(){
	var form = document.form;
	var sheetObj = sheetObjects[0];
	sheetObj.RemoveAll();
	
	if (form.rmk_yn.checked){
		form.rmk_yn.value = "Y";
	}else{
		form.rmk_yn.value = "N";		
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
			style.height = 430;
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
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Trade|Lane|Carrier|VVD|Revenue\nMonth|Account\nMonth|Item|BSA Amount\n(Revenue)|Combined Amount\n(Revenue)|Slip Amount\n(Revenue)|BSA Amount\n(Expense)|Combined Amount\n(Expense)|Slip Amount\n(Expense)|Remark|r_joo_cmb_bgcolor_yn|r_joo_slp_bgcolor_yn|e_joo_cmb_bgcolor_yn|e_joo_slp_bgcolor_yn|vsl_cd|skd_voy_no|skd_dir_cd|rev_dir_cd";

			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);

			//데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, false, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtData        ,  40, daCenter,  true, prefix+"trd_cd"          , false, "", dfNone       , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter,  true, prefix+"rlane_cd"        , false, "", dfNone       , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter,  true, prefix+"jo_crr_cd"       , false, "", dfNone       , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  80, daCenter,  true, prefix+"vvd"             , false, "", dfNone       , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  65, daCenter,  true, prefix+"rev_yrmon"       , false, "", dfDateYm     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  65, daCenter,  true, prefix+"acct_yrmon"      , false, "", dfDateYm     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  35, daCenter,  true, prefix+"jo_stl_itm_cd"   , false, "", dfNone       , 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum     ,  90, daRight ,  true, prefix+"r_coa_bsa_amt"   , false, "", dfNullInteger, 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum     , 110, daRight ,  true, prefix+"r_joo_cmb_amt"   , false, "", dfNullInteger, 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum     ,  90, daRight ,  true, prefix+"r_joo_slp_amt"   , false, "", dfNullInteger, 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum     ,  90, daRight ,  true, prefix+"e_coa_bsa_amt"   , false, "", dfNullInteger, 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum     , 110, daRight ,  true, prefix+"e_joo_cmb_amt"   , false, "", dfNullInteger, 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum     ,  90, daRight ,  true, prefix+"e_joo_slp_amt"   , false, "", dfNullInteger, 2, false, false);
			InitDataProperty(0, cnt++, dtData        , 300, daLeft  ,  true, prefix+"jo_unstl_sts_rmk", false, "", dfNone       , 0, true , true ,1000);
			
            InitDataProperty(0, cnt++ , dtHidden, 100, daRight,   true, prefix+"r_joo_cmb_bgcolor_yn", false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"r_joo_slp_bgcolor_yn", false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"e_joo_cmb_bgcolor_yn", false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"e_joo_slp_bgcolor_yn", false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"vsl_cd"              , false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"skd_voy_no"          , false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"skd_dir_cd"          , false, "", dfNone,0,  true, true);
            InitDataProperty(0, cnt++ , dtHidden,  85, daRight,   true, prefix+"rev_dir_cd"          , false, "", dfNone,0,  true, true);
		}
		break;

	case 2: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
		}
		break;
	}
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "rlane_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH01;
				formObj.code.value = "";
				formObj.super_cd2.value = formObj.trd_cd.Code;
				formObj.super_cd1.value = "";
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				//Trade setting
				var comboItems = (" |"+ComGetEtcData(sXml, "rlane_cd")).split("|");
				addComboItem(comboObjects[1],comboItems);

				//Rlane setting
				var comboItems = (" |"+ComGetEtcData(sXml, "jo_crr_cd")).split("|");
				addComboItem(comboObjects[2],comboItems);
			}else if (sComboObj.id == "jo_crr_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH02;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.rlane_cd.Code;
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				var comboItems = (" |"+ComGetEtcData(sXml, sComboKey)).split("|");
				addComboItem(sComboObj,comboItems);
			}
														
	        break;
    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheetObj.ShowDebugMsg = false;
	
	switch (sAction) {
		case IBSEARCH: //조회 
			if (!validateForm(sheetObj, formObj, sAction)) {
				return;
			}
			formObj.f_cmd.value = SEARCH;
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			sheetObj.DoSearch("FNS_JOO_0050GS.do", param);
            //fnSetBgColorRedForSearchEnd(sheetObj);
			break;
	
		case IBSAVE: //저장 
			if (!validateForm(sheetObj, formObj, sAction)) {
				return;
			}
			
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}

			var SaveStr = ComGetSaveString(sheetObj);
			
			formObj.f_cmd.value = MULTI;

			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			try{
				var sXml = sheetObj.GetSaveXml("FNS_JOO_0050GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			}finally{
				ComOpenWait(false);
			}
			sheetObj.LoadSearchXml(sXml);
			break;

		case IBRESET:
			UF_reset();
			break;
	}
}

function trd_cd_OnChange(comboObj, Value, Text) {
	var formObj = document.form;
	formObj.rlane_cd.Index2 = -1;
	formObj.rlane_cd.RemoveAll();
	formObj.jo_crr_cd.Index2 = -1;
	formObj.jo_crr_cd.RemoveAll();
	sheetObjects[0].RemoveAll();
	doActionIBCombo(sheetObjects[1] , formObj, IBSEARCH, comboObjects[1],"rlane_cd");	
}

function rlane_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	formObj.jo_crr_cd.Index2 = -1;
	formObj.jo_crr_cd.RemoveAll();
	sheetObjects[0].RemoveAll();
	doActionIBCombo(sheetObjects[1] , formObj, IBSEARCH, comboObjects[2],"jo_crr_cd");	
}

function jo_crr_cd_OnChange(comboObj, value, text) {
	sheetObjects[0].RemoveAll();
}

function jo_stl_itm_cd_OnChange(comboObj, value, text) {
	sheetObjects[0].RemoveAll();
}

function ofc_cd_OnChange(comboObj, value, text) {
	sheetObjects[0].RemoveAll();
}

/**
 * 년월 NAVI 처리 이벤트 
 * @param void
 * @return void
 */
function fnDocClick() {
	var obj = event.srcElement;
	var formObj = document.form;

	var fr = formObj.acct_yrmon_fr.value;
	var to = formObj.acct_yrmon_to.value;
	switch (obj.name) {

	case "btn_acct_yrmon_fr_back":
		if (fr != "") {
			formObj.acct_yrmon_fr.value = ComGetDateAdd(fr+"-01","M",-1).substring(0,7);
		}
		sheetObjects[0].RemoveAll();
		break;

	case "btn_acct_yrmon_fr_next":
		if (fr != "") {
			formObj.acct_yrmon_fr.value = ComGetDateAdd(fr+"-01","M",+1).substring(0,7);
		}
		sheetObjects[0].RemoveAll();
		break;

	case "btn_acct_yrmon_to_back":
		if (to != "") {
			formObj.acct_yrmon_to.value = ComGetDateAdd(to+"-01","M",-1).substring(0,7);
		}
		sheetObjects[0].RemoveAll();
		break;

	case "btn_acct_yrmon_to_next":
		if (to != "") {
			formObj.acct_yrmon_to.value = ComGetDateAdd(to+"-01","M",+1).substring(0,7);
		}
		sheetObjects[0].RemoveAll();
		break;
	}
}

/**
 * <pre>
 *    form Element의 KeyPress Event 발생시 처리.
 *    
 * </pre>
 * @return
 */
function fnObjKeyPress() {
	var obj = event.srcElement;
	var formObj = document.form;
	switch (obj.name) {
	case 'acct_yrmon_fr':
		ComKeyOnlyNumber(obj);
		break;

	case 'acct_yrmon_to':
		ComKeyOnlyNumber(obj);
		break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 잃었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnDeactivate() {
	switch (event.srcElement.name) {
	case 'acct_yrmon_fr':
		ComAddSeparator(event.srcElement);
		break;
	case 'acct_yrmon_to':
		ComAddSeparator(event.srcElement);
		break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 얻었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnActivate() {
	switch (event.srcElement.name) {
	case 'acct_yrmon_fr':
		ComClearSeparator(event.srcElement);
		break;
	case 'acct_yrmon_to':
		ComClearSeparator(event.srcElement);
		break;

	}
	event.srcElement.select();
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {

	case IBSEARCH:
		if (formObj.acct_yrmon_fr.value.length == 0){
			ComShowCodeMessage('JOO00089');
			formObj.acct_yrmon_fr.focus();
			return false;
		}

		if (formObj.acct_yrmon_to.value.length == 0){
			ComShowCodeMessage('JOO00089');
			formObj.acct_yrmon_to.focus();
			return false;
		}

		var frDt = formObj.acct_yrmon_fr.value.replaceStr("-","")+"01";
		var toDt = formObj.acct_yrmon_to.value.replaceStr("-","")+"01";

		if (ComGetDaysBetween(frDt, toDt) < 0){
			ComShowCodeMessage('JOO00078');
			formObj.acct_yrmon_to.focus();
			return false;
		}	
		break;
		
	case IBSAVE :
		var SaveStr = ComGetSaveString(sheetObj);
		
		if (SaveStr == ""){
			ComShowCodeMessage("JOO00036");
			return false;
		}
	
		break;
	}

	return true;
}
 /**
  * 
  * <pre>
  *    조회후, Joo 값 Color
  * </pre>
  *
  * @param  sheetObj : SheetObj 
  * @return void
  * @author jang kang cheol
  */
 //function fnSetBgColorRedForSearchEnd(sheetObj){
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     for(var i=sheetObj.HeaderRows;i<=sheetObj.LastRow;i++){
         if( sheetObj.CellValue(i, prefix+"r_joo_cmb_bgcolor_yn") == "Y"){
             sheetObj.CellFontColor(i,prefix+"r_joo_cmb_amt") = sheetObj.RgbColor(255, 0 ,0);
         }
         if( sheetObj.CellValue(i, prefix+"r_joo_slp_bgcolor_yn") == "Y"){
             sheetObj.CellFontColor(i,prefix+"r_joo_slp_amt") = sheetObj.RgbColor(255, 0 ,0);
         }
         if( sheetObj.CellValue(i, prefix+"e_joo_cmb_bgcolor_yn") == "Y"){
             sheetObj.CellFontColor(i,prefix+"e_joo_cmb_amt") = sheetObj.RgbColor(255, 0, 0);
         }
         if( sheetObj.CellValue(i, prefix+"e_joo_slp_bgcolor_yn") == "Y"){
             sheetObj.CellFontColor(i,prefix+"e_joo_slp_amt") = sheetObj.RgbColor(255, 0, 0);
         }
     }     
 }
function UF_reset() {
	var formObj = document.form;

	comboObjects[0].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].Index2 = -1;
	comboObjects[4].Index2 = 0;

	//Rlane Combo setting
	var comboItems = (" |"+gRlaneCd).split("|");
	addComboItem(comboObjects[1], comboItems);           	
	
	//Carrier Combo setting
	comboItems = (" |"+gJoCrrCd).split("|");
	addComboItem(comboObjects[2], comboItems);           	
	
	formObj.acct_yrmon_fr.value = yyyyMM;
	formObj.acct_yrmon_to.value = yyyyMM;

	sheetObjects[0].RemoveAll();
	
	formObj.diff_only_yn.checked = true;
	formObj.diff_only_yn.value = "Y";
	
	formObj.rmk_yn.checked = false;
	formObj.rmk_yn.value = "N";

	formObj.trd_cd.focus();
}


function trd_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 9 || KeyCode == 13)
		setTimeout("document.getElementById(\"" + comboObjects[1].id  + "\").focus()", 0.1);
}

function rlane_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 9 || KeyCode == 13)
		setTimeout("document.getElementById(\"" + comboObjects[2].id  + "\").focus()", 0.1);
}

function jo_crr_cd_OnKeyDown(comboObj, KeyCode, Shift) {
//	if (KeyCode == 9 || KeyCode == 13)
//		setTimeout("document.getElementById(\"" + comboObjects[3].id  + "\").focus()", 0.1);
}

function jo_stl_itm_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 9 || KeyCode == 13)
		setTimeout("document.getElementById(\"" + comboObjects[0].id  + "\").focus()", 0.1);
}
/* 개발자 작업  끝 */