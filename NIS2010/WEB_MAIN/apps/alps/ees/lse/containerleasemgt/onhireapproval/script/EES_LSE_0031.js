/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_lse_0031.js
 *@FileTitle : On Hire Approval inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.06.04 진준성
 * 1.0 Creation
 * ======================================================
 * 2010.12.06 남궁진호 [CHM-201007443-01] REF_NO 항목 Left 정렬
 * 2010.12.15 남궁진호 [CHM-201007751-01]IBSheet Size 수정
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
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
 * @class ees_lse_0031 : ees_lse_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_lse_0031() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.setComboObject     = setComboObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
	this.obj_change         = obj_change;
	this.combo1_OnChange    = combo1_OnChange;
	this.obj_keydown        = obj_keydown;
	this.obj_keypress       = obj_keypress;
	this.cntr_onh_auth_no_OnChange = cntr_onh_auth_no_OnChange;
	this.cntr_onh_auth_no_OnKeyDown = cntr_onh_auth_no_OnKeyDown;
}

/* 개발자 작업  */

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var checkDt  = 0;
// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;
var arrTpSz  = new Array();
var arrTpSz2 = new Array();
var arrTpSz3 = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "Retrieve":
			for(var i=0; i<arrTpSz3.length; i++){
				sheetObjects[0].ColHidden(arrTpSz3[i]) = true
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "New":
			formObject.cntr_tpsz_cd.value        = "";
			formObject.loc_cd.value      = "";
			comboObjects[0].Text         = "";
			formObject.pkup_due_dt.value = "";			
			formObject.period_stdt.value = "";
			formObject.period_eddt.value = "";
			comboObjects[1].RemoveAll();
			sheetObject.RemoveAll();
			for(var i=0; i<arrTpSz3.length; i++){
				sheetObject.ColHidden(arrTpSz3[i]) = true
			}
			sheetObject.SheetWidth = 725;
			formObject.apro_rmk.value = "";
			ComSetFocus(formObject.loc_cd);
		break;

		case "btns_calendar1":		
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.period_stdt, "yyyy-MM");
			}

			break;

		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.period_eddt, "yyyy-MM");
			}
			break;
			
		case "btns_search1":    // onh_loc_cd Pop-up
		   if ( srcObj.style.filter == "" ) {
			  openPopup("1");
		   }
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
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function sheet1_OnLoadFinish() {
	 /* IBMulti Combo Item Setting */
	 doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	 initSheet(sheetObjects[0],1);
	 for(var i=0; i < arrTpSz3.length; i++){
	     sheetObjects[0].ColHidden(arrTpSz3[i]) = true
	 }
	 this.title_color();
	 sheetObjects[0].ScrollBar = 3;
	 document.form.loc_cd.focus();
}
 
function loadPage(){

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	/* IBMultiCombo 초기화 */
	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}	

	/* Axon Control Setting*/
	initControl();
	
	//var objs = document.all.item("tabLayer");
	//objs.style.display = "Inline";	
}
 
 
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj); //- 변경될때.
	axon_event.addListenerForm('keypress',  'obj_keypress', formObj); //- 키 눌렸을때
	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
	//axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
	//axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리

}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
	case 1:      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		//style.height = 285;
		//전체 너비 설정
		SheetWidth = 984;// mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet =  msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 2, 1, 13, 100);
		var HeadTitleTemp  = "";
		var HeadTitle2Temp = "";
		
		for(var i=0; i<arrTpSz.length; i++){			
			HeadTitleTemp  = HeadTitleTemp  + "|" + arrTpSz[i] + "|" + arrTpSz[i] + "|" + arrTpSz[i];
			HeadTitle2Temp = HeadTitle2Temp + "|Old|L/On|New";
		}
		var HeadTitle   = "sta|AGMT No.|Ref No.|Lease\nTerm |Lessor ABBR|Order\nYear|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|P/Up LOC|Off-Hire LOC|DIV Total|DIV Total" + HeadTitleTemp + "|pkup_due_dt|apro_rmk" ;
		var HeadTitle2  = "sta|AGMT No.|Ref No.|Lease\nTerm |Lessor ABBR|Order\nYear|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|P/Up LOC|Off-Hire LOC|Old|New" + HeadTitle2Temp + "|pkup_due_dt|apro_rmk"  ;
		
		var headCount = ComCountHeadTitle(HeadTitle);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);
		InitHeadRow(1, HeadTitle2, true);
		
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		//InitDataProperty(0, cnt++ , dtHiddenStatus,      0,    daCenter,  true,     "Sta");
		InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true, "ibflag");
		InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true, "agmt_no",            false,   "",      dfEngUpKey,    0,  true,     true , 3);
		InitDataProperty(0, cnt++ , dtData,         100,    daLeft,	  true, "ref_no",             false,   "",      dfEngUpKey,    0,  true,     true , 3);
		InitDataProperty(0, cnt++ , dtData,         55,    daCenter,  true, "lstm_cd",            false,   "",      dfNone,        0,  false,   true);
		InitDataProperty(0, cnt++ , dtData,         95,    daCenter,  true, "lessor",             false,   "",      dfNone,        0,  false,    true);
		InitDataProperty(0, cnt++ , dtData,         55,    daCenter,  true, "onh_ord_yr",         false,   "",      dfNone,        0,  false,   false);
		InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true, "m_year",             false,   "",      dfNone,        0,  true,     true , 4);
		InitDataProperty(0, cnt++ , dtData,         65,    daRight,   true, "free_day",           false,   "",      dfNullInteger, 0,  true,     true , 5);
		InitDataProperty(0, cnt++ , dtData,         90,    daRight,   true, "p_up_charge",        false,   "",      dfFloat,       2,  true,     true , 8);
		InitDataProperty(0, cnt++ , dtData,         90,    daRight,   true, "p_up_credit",        false,   "",      dfFloat,       2,  true,     true , 8);
		InitDataProperty(0, cnt++ , dtData,         95,    daRight,   true, "min_onh_days",       false,   "",      dfNullInteger, 0,  true,     true , 5);
		InitDataProperty(0, cnt++ , dtCombo,		70,	   daCenter,  true,  "ecc_cd",				false,	 "",	  dfNone,	  	 0,	 true,	    true);
		InitDataProperty(0, cnt++ , dtCombo,		80,	   daCenter,  true,  "loc_cod",				false,	 "",	  dfNone,	  	 0,	 true,	    true);
		InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true, "div_total_old",      false,   "",      dfNullInteger, 0,  false,    true);
		InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true, "div_total_new",      false,   "",      dfNullInteger, 0,  false,    true);
		for(var i=0; i<arrTpSz2.length; i++){		
		InitDataProperty(0, cnt++ , dtData,         50,    daRight,   true, arrTpSz2[i] + "_old", false,   "",      dfNullInteger, 0,  false,    true , 6);
		InitDataProperty(0, cnt++ , dtData,         50,    daRight,   true, arrTpSz2[i] + "_lon", false,   "",      dfFloat,       2,  false,    true , 6);
		InitDataProperty(0, cnt++ , dtData,         50,    daRight,   true, arrTpSz2[i] + "_new", false,   "",      dfNullInteger, 0,  false,    true , 6);
		}		
		InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  true, "pkup_due_dt",        false,   "",      dfNone,        0,  false,    true);
		InitDataProperty(0, cnt++ , dtHidden,        0,    daCenter,  true, "apro_rmk",           false,   "",      dfNone,        0,  false,    true);
		
		SelectBackColor = LSE_SELECT_BACK_COLOR;
		
		sheetObj.CellBackColor(0, "div_total_old") = sheetObj.RgbColor(176 , 196 , 222);
		sheetObj.CellBackColor(0, "div_total_new") = sheetObj.RgbColor(176 , 196 , 222);
		ScrollBar = 0;
		FrozenCols = 5;
	}

	break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
	formObj.f_cmd.value = SEARCH;
	if(validateForm(sheetObj,formObj,sAction)){
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoSearch("EES_LSE_0031GS.do",FormQueryString(formObj));
		ComOpenWait(false);
	}

	if(sheetObj.RowCount > 0){
		formObj.pkup_due_dt.value = sheetObj.CellValue(2,"pkup_due_dt");
		formObj.apro_rmk.value    = sheetObj.CellValue(2,"apro_rmk");

		var strTpszCd = "";
		var strTxt    = "";
		var chkHidden = true;

		for( var j = 15 ; j <=  arrTpSz3.length + 12 ; j++){
			chkHidden = true;
			for( var i = 2 ; i <= sheetObj.RowCount + 1 ; i++){
				if( sheetObj.CellText(i,j) != "0" && sheetObj.CellText(i,j) != "0.00" &&  sheetObj.CellText(i,j) != "" && sheetObj.CellText(i,j) != null){
					chkHidden = false;
					strTxt = sheetObj.CellText(0,j);
					if(strTpszCd.indexOf(strTxt) < 0){
						strTpszCd = strTpszCd + "," + strTxt;
					}
				}
			}
			
			if(chkHidden == false){
				if(sheetObj.CellText(1,j) == "New" ){
					sheetObj.ColHidden(j)   = false;
					sheetObj.ColHidden(j-1) = false;
					sheetObj.ColHidden(j-2) = false;
				}else if(sheetObj.CellText(1,j) == "Old"){
					sheetObj.ColHidden(j)   = false;
					sheetObj.ColHidden(j+1) = false;
					sheetObj.ColHidden(j+2) = false;
				}else if(sheetObj.CellText(1,j) == "L/On"){	
					sheetObj.ColHidden(j-1) = false;
					sheetObj.ColHidden(j)   = false;
					sheetObj.ColHidden(j+1) = false;					
				}
			}
		}
		
		if(strTpszCd.length > 0){
		    //strTpszCd = strTpszCd.substr(1) ;
		    formObj.cntr_tpsz_cd.value = strTpszCd;
		}		
        
		if(strTpszCd.length > 0){
			strTpszCd = strTpszCd.substr(1) ;
			formObj.cntr_tpsz_cd.value = strTpszCd;
			var arryTpszCd =  strTpszCd.split(",");
			var addCnt  = arryTpszCd.length;
			var addSize = 0;
			if(document.form.cntr_tpsz_cd.value != ""){
				if(addCnt == 1){
					sheetObjects[0].SheetWidth = 984;
				}else if(addCnt == 2){
					sheetObjects[0].SheetWidth = 984;				
				}else if(addCnt > 2){	
					var addSize   = Number(addCnt) * 150 ;
					if( 660 + addSize > 984){
						sheetObjects[0].SheetWidth = 984;
					}else{
						sheetObjects[0].SheetWidth = 775 + addSize;
					}
				}else{
					sheetObjects[0].SheetWidth = 984;
				}
			}else{
				sheetObjects[0].SheetWidth = 765;
			}
		}
	}
	
	sheetObj.ColBackColor(9) = sheetObj.RgbColor(220 , 220 , 220);
	sheetObj.ColBackColor(10) = sheetObj.RgbColor(220 , 220 , 220);		

	break;

	case IBCREATE:
		comboObjects[0].InsertItem(0, 'OW');
		comboObjects[0].InsertItem(1, 'LP');
		comboObjects[0].InsertItem(2, 'OL');
		comboObjects[0].InsertItem(3, 'LT');
		comboObjects[0].InsertItem(4, 'ST');
		comboObjects[0].InsertItem(5, 'OF');
		comboObjects[0].InsertItem(6, 'SI');

		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		if ( sXml2 != "" ) {
			vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");
			formObj.tysz.value = vOrcCntrTpszCd;		   
			arrTpSz   =  vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2  =  vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
			var j = 0;
			for(var i = 0 ; i <  arrTpSz2.length ; i++){
				arrTpSz3[j] = arrTpSz2[i] + "_old";				
				j++;
				arrTpSz3[j] = arrTpSz2[i] + "_lon";
				j++;
				arrTpSz3[j] = arrTpSz2[i] + "_new";
				j++;
			}
		}
		break;

	case IBSEARCH_ASYNC01:      //auth_no list 조회
	var vLocCd  = formObj.loc_cd.value;
	var vCombo1 = ComGetObjValue(comboObjects[0]);
	if(vLocCd != null && vLocCd != "" && vCombo1 != null && vCombo1 != ""){
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0031GS2.do", FormQueryString(formObj));

		if ( sXml != "" ) {
			ComXml2ComboItem(sXml, comboObjects[1], "cntr_onh_auth_no", "cntr_onh_auth_no");
		}
	}
	break;

	case IBSEARCH_ASYNC03:  // Location 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH05;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));

			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "lcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "lcc_cd") != "" ) {

					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value = "";
						ComSetFocus(formObj.loc_cd);
					}
				} else {
					var errMsg = LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					formObj.loc_cd.value = "";
					ComSetFocus(formObj.loc_cd);
				}
			}
		}
	}

	break;
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	with(formObj){
		switch(sAction) {
		case IBSEARCH:      //저장

		if ( formObj.loc_cd.value == "" ) {
			ComShowCodeMessage("LSE01046");
			ComSetFocus(formObj.loc_cd);
			return false;
			break;
		}

		if ( comboObjects[0].text == "" ) {
			ComShowCodeMessage("LSE01009");
			ComSetFocus(comboObjects[0]);
			return false;
			break;
		}
		
		var periodStdt = formObj.period_stdt.value;
		periodStdt = periodStdt.replaceStr("-","");
		var periodEtdt = formObj.period_eddt.value;			          
		periodEtdt = periodEtdt.replaceStr("-","");
		
		if ( Number(periodStdt) > Number(periodEtdt)) {
			ComShowCodeMessage("LSE01051");
			ComSetFocus(formObj.period_stdt);
			return false;
			break;
		}
		
		if ( comboObjects[1].text == "" ) {
			ComShowCodeMessage("LSE01050");
			ComSetFocus(comboObjects[1]);
			return false;
			break;
		}

		break;
		}
	}

	return true;
}
/**
 * Key-Press Event 처리
 */
function obj_keypress() {
	var obj = event.srcElement;

	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
	case "int":
		ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		if(obj.name == "loc_cd") {
            ComKeyOnlyAlphabet('uppernum');
    	}else{
    		ComKeyOnlyAlphabet('upper');
    	}
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	default:
		ComKeyOnlyNumber(obj);
	break;	
	}	
	
	switch(obj.name) {
	case "period_eddt":	
		if(document.form.period_eddt.value.length == 6){
			checkDt = 0;
		}
    	break;
	}	
}


/**
 * 콤보 초기설정값, 헤더 정의
 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
	case "combo1":
		with(comboObj) {
			//BackColor = "cyan";
			DropHeight = 150;
			MultiSelect = false;
			MaxSelect = 1;
		}

		break;

	case "cntr_onh_auth_no":
		with(comboObj) {
			//BackColor = "cyan";
			DropHeight = 150;
			MultiSelect = false;
			//MaxSelect = 1;
			FontName = "Courier New";
		}
		break;
	}
}

/**
 * Pop-up Open 부분<br>
 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
 * @param object 대상 Object
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 */
function openPopup(type, Row, Col) {
	var formObj = document.form;

	if ( type == "1" ) {
		//var formObj = document.form;
		var sUrl    = '/hanjin/COM_ENS_051.do';
		var iWidth  = 800;
		var iHeight = 430;
		var sTargetObjList = "lcc_cd:loc_cd";
		var sDisplay = "1,0,1,1,1,1,1,1";

		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
	}
}
/**
 * combo item change 부분<br>
 * @param type 
 * @param object 대상 Object
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 */
function combo1_OnChange(comboObj,value,text){
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
}  

function cntr_onh_auth_no_OnChange(comboObj,value,text){
	if ( value == "" ) {
		ComShowCodeMessage("LSE01047");
		ComSetFocus(comboObjects[1]);
		return false;       
	}
}      

function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) {
		case "loc_cd":
			ComChkObjValid(obj);
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			var strLocCd = formObj.loc_cd.value;
			if(strLocCd.length == 5 && comboObjects[0].Text != "" ){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			}
			break;
		
		}
	}
}
function title_color(){
    for(var i=0; i<arrTpSz2.length; i++){			
    	sheetObjects[0].CellBackColor(0, arrTpSz2[i] + "_old") =  sheetObjects[0].RgbColor(176 , 196 , 222);
        sheetObjects[0].CellBackColor(0, arrTpSz2[i] + "_lon") =  sheetObjects[0].RgbColor(176 , 196 , 222);
        sheetObjects[0].CellBackColor(1, arrTpSz2[i] + "_old") =  sheetObjects[0].RgbColor(176 , 196 , 222);
        sheetObjects[0].CellBackColor(1, arrTpSz2[i] + "_lon") =  sheetObjects[0].RgbColor(176 , 196 , 222);
    }
}

/**
* Key-Down Event 처리
*/
function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;
	var srcObj  = window.event.srcElement;
	if ( vKeyCode == 13 ) {
		switch(obj.name) {
		    case "period_eddt":	
		    	    			    	
		    	break;
		    default :
			    if ( srcObj.style.filter == "" ) {
				    sheetObjects[0].RemoveAll();				
				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			    }
		    	break;	
	    }
	}
}

/**
 * Period FM  beforeactivate 이벤트 처리
 * Period FM  beforeactivate -없애기 
 */    
	function obj_activate() {
		
		var obj  = event.srcElement;
		if( obj.readOnly ) {
			//ComSetNextFocus(obj);
		} else {
			//마스크구분자 없애기
			if(obj.name == "period_stdt" || obj.name == "period_eddt"){			  
				if(obj.name == "period_stdt" && document.form.period_eddt.value != ""){
					document.form.period_eddt.value = "";
				}
				if(obj.value.length == 7 ){
			      ComClearSeparator(event.srcElement);
			    }
			}  
		}
	}


   /**
	* Period to  beforedeactivate 이벤트 처리
	* Period to  beforedeactivate YYYY-MM 포멧 처리 
	*/	
	function obj_deactivate() {		
		var periodStdt = document.form.period_stdt.value;
		periodStdt = periodStdt.replaceStr("-","");
		var periodEtdt = document.form.period_eddt.value;			          
		periodEtdt = periodEtdt.replaceStr("-","");
		obj = event.srcElement;		
		 if (obj.name == "period_stdt") {            
			 ComAddSeparator(event.srcElement);                  
	     }else if (obj.name == "period_eddt") {		
	    	ComAddSeparator(event.srcElement); 
	    	
	    	if( checkDt == 0 && ( ComGetMaskedValue(periodEtdt, "ym") == "" || Number(periodStdt) > Number(periodEtdt) ) ){       	            	   	        
	    	    checkDt = 1;	    	    
	    		if(ComGetMaskedValue(periodEtdt, "ym") != "" ){
                  ComShowCodeMessage("LSE01051");
                  ComSetFocus(document.form.cntr_onh_auth);
        	      ComSetFocus(document.form.period_eddt);	    	 
	    	   }
	        }
            
            if(checkDt == 0 ){
            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
            }           
		}
	}

/**
* cntr_onh_auth_no_OnKeyDown
*/
function cntr_onh_auth_no_OnKeyDown(comboObj, KeyCode, Shift) {	  
   with(comboObj) {
	    if ( KeyCode == 13 ){
		    sheetObjects[0].RemoveAll(); 			 
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    }
   }
} 
/* 개발자 작업  끝 */