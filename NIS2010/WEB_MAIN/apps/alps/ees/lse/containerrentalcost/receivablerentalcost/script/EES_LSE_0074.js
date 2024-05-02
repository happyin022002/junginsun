/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0074.js
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
* 1.0 Creation
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
 * @class EES_LSE_0074 : EES_LSE_0074 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_LSE_0074() {
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
	this.obj_keypress       = obj_keypress;
	this.validateForm       = validateForm;
	this.loc_tp_OnChange    = loc_tp_OnChange;
	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
	this.combo1_OnBlur 			= combo1_OnBlur;
	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
	this.combo2_OnCheckClick 	= combo2_OnCheckClick;
	this.combo2_OnBlur 			= combo2_OnBlur;
	this.combo2_OnKeyDown 		= combo2_OnKeyDown;
	this.combo3_OnCheckClick 	= combo3_OnCheckClick;
	this.combo3_OnBlur 			= combo3_OnBlur;
	this.combo3_OnKeyDown 		= combo3_OnKeyDown;
}

/* 개발자 작업	*/
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

var arrTpSz  = new Array();
var arrTpSz2 = new Array();

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;

		case "btn_print":
			if(sheetObjects[0].RowCount <= 0){
				return;
			}
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			fromObj[0] = formObject;                            // RD 로 보내기 위해 배열로담는다
			rdObj[0] = sheetObjects[0];     					// Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다
			// RD 로 보내기 위한 설정
			parmObj[0] = "1";
			parmObj[1] = "";
			parmObj[2] = "N";

			if(document.form.report_type.value == "rp_0074"){
				ComOpenPopupWithTarget('/hanjin/EES_LSE_0080.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0075"){
				ComOpenPopupWithTarget('/hanjin/EES_LSE_0081.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0076"){
				ComOpenPopupWithTarget('/hanjin/EES_LSE_0082.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0077"){
				ComOpenPopupWithTarget('/hanjin/EES_LSE_0083.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0078"){
				ComOpenPopupWithTarget('/hanjin/EES_LSE_0084.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0079"){
				ComOpenPopupWithTarget('/hanjin/EES_LSE_0085.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}
			break;

		case "btn_New":

			sheetObject1.RemoveAll();
			formObject.period_stdt.value = "";
			formObject.period_eddt.value = "";
			formObject.period_year.value = "";
			formObject.company[1].selected = true;
			formObject.status[0].selected = true;
			formObject.receivable[0].selected = true;

			formObject.agmt_seq.value = "";
			formObject.contract_no.value = "";

			formObject.vndr_seq.value = "";
			formObject.vndr_nm.value = "";
			formObject.abbr_nm.value = "";

			formObject.loc_cd.value = "";
			formObject.loc_tp[0].selected = true;
			ComEnableObject(document.form.btns_search1, false);

			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
				comboObjects[0].CheckIndex(i)=false;
			}
			comboObjects[0].CheckIndex(0) = true;
			formObject.lstm_cd.value = "";

			for(var i = 1 ; i < comboObjects[1].GetCount(); i++ ){
				comboObjects[1].CheckIndex(i)=false;
			}
			comboObjects[1].CheckIndex(0) = true;
			formObject.cntr_tpsz_cd.value = "";

			for(var i = 1 ; i < comboObjects[2].GetCount(); i++ ){
				comboObjects[2].CheckIndex(i)=false;
			}
			comboObjects[2].CheckIndex(0) = true;
			formObject.charge_type_cd.value = "";
		    if(document.form.report_type.value == "rp_0075" || document.form.report_type.value == "rp_0077" || document.form.report_type.value == "rp_0078" ){
		    	document.form.period_year.focus();
		    }else{
		    	document.form.period_stdt.focus();
		    }
			break;

		case "btns_calendar1":
			/*var cal = new ComCalendar();
			cal.select(formObject.period_year, "yyyy");*/
			if ( srcObj.style.filter == "" ) {
			    var cal = new ComCalendar();
			    cal.setDisplayType('year');
			    cal.select(formObject.period_year, "yyyy");
			}

		break;

		case "btns_calendar2":
			/*if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM');
			}*/

			if ( srcObj.style.filter == "" ) {
			    var cal = new ComCalendar();
			    cal.setDisplayType('month');
			    cal.select(formObject.period_stdt, "yyyy-MM");
			}

		break;

		case "btns_calendar3":
			if ( srcObj.style.filter == "" ) {
			    var cal = new ComCalendar();
			    cal.setDisplayType('month');
			    cal.select(formObject.period_eddt, "yyyy-MM");
			}

		break;

		case "btns_search1":      // loc_cd
		if ( srcObj.style.filter == "" ) {

			openPopup("1");

		}
		break;

		case "btns_search2":     // lessor
		if ( srcObj.style.filter == "" ) {
			openPopup("2");
		}
		break;

		case "btns_search3":	//agmt_seq
		if ( srcObj.style.filter == "" ) {
			openPopup("3");
		}
		break;

		case "btn_DownExcel":
			sheetObject1.SpeedDown2Excel(-1);
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
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();

	/* IBMultiCombo 초기화 */
	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
}

function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	initSheet(sheetObjects[0],1);
	comboObjects[1].CheckIndex(0) = true;
    var OBJ = document.getElementById("fixLayer1");
	OBJ.style.visibility = "visible";
	document.form.period_stdt.focus();
	comboObjects[0].InsertItem(0, 'ALL' , 'ALL');
	comboObjects[0].InsertItem(1, 'SO'  , 'SO');
	comboObjects[0].InsertItem(2, 'MO'  , 'MO');
	comboObjects[0].CheckIndex(0) =  true;

	comboObjects[2].InsertItem(0,  'ALL' , 'ALL');
	comboObjects[2].InsertItem(1,  'PDM' , 'PDM');
	comboObjects[2].InsertItem(2,  'PUC' , 'PUC');
	comboObjects[2].InsertItem(3,  'PCR' , 'PCR');
	comboObjects[2].InsertItem(4,  'LON' , 'LON');
	comboObjects[2].InsertItem(5,  'LOF' , 'LOF');
	comboObjects[2].InsertItem(6,  'DOC' , 'DOC');
	comboObjects[2].InsertItem(7,  'DCR' , 'DCR');
    comboObjects[2].InsertItem(8,  'DIO' , 'DIO');
    comboObjects[2].InsertItem(9,  'DPP' , 'DPP');
    comboObjects[2].InsertItem(10, 'CRD' , 'CRD');

	comboObjects[2].CheckIndex(0) =  true;
	comboObjects[2].Enable = false;
    document.form.loc_cd.readOnly = true;
	document.form.loc_cd.className = "input2";
	ComEnableObject(document.form.btns_search1, false);
	sheetObjects[0].CellText(0, 1) = "RCC";
	sheetObjects[0].CellText(1, 1) = "RCC";
}
/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;

	switch(sheetid) {
	case "sheet1":
		with (sheetObj) {
            if(document.form.report_type.value == "rp_0074"){
                // 높이 설정
                style.height = 280;
                //전체 너비 설정
                SheetWidth = 984;//mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 15, 100);

                var HeadTitle   = "sta|Status|Lessee| |TP/SZ|Q'ty|G.TTL|PDM|Pick-Up|Pick-Up|Pick-Up|Lift Charge|Lift Charge|Lift Charge|Drop Charge|Drop Charge|Drop Charge|Gate Charge|Gate Charge|Gate Charge|DPP|CRD|";
                var HeadTitle2  = "sta|Status|Lessee| |TP/SZ|Q'ty|G.TTL|PDM|PUC|PCR|S.TTL|LON|LOF|S.TTL|DOC|DCR|S.TTL|GTI|GTO|S.TTL|DPP|CRD|";
                var headCount   = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle , true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                //InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "pkup_chg_amt",  false,  "",  dfFloat,       2,  true,     true , 8);
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,   daCenter,  true,  "ibflag");
                InitDataProperty(0, cnt++ , dtData,         80,  daCenter,  true,  "status",        false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         60,  daCenter,  true,  "vndr_seq",      false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         30,  daCenter,  true,  "abbr_nm",       false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         50,  daCenter,  true,  "cntr_tpsz_cd",  false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "qty",           false,  "",  dfInteger);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "g_ttl",         false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "pdm",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "puc",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "pcr",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_1",         false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "lon",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "lof",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_2",         false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "doc",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "dcr",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_4",         false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "gti",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "gto",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_3",         false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "dpp",           false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "CRD",           false,  "",  dfFloat, 2);

				InitDataProperty(0, cnt++ , dtAutoSum,      80,  daRight,   true,  "auto_sum",      false,  "",  dfFloat, 2);
				ColHidden("auto_sum") = true;

                SelectBackColor = LSE_SELECT_BACK_COLOR;
                sheetObjects[0].SetMergeCell(0, 2, 2, 2);
                FrozenCols = 7;
				SelectRow = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
            }else if(document.form.report_type.value == "rp_0075"){
                // 높이 설정
                style.height = 280;
                //전체 너비 설정
                SheetWidth = 984;//mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 3, 15, 100);

                var HeadTitle   = "sta|TP/SZ|Month|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var HeadTitle2  = "sta|TP/SZ|DIV|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";

                var headCount   = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle , true);
                InitHeadRow(1, HeadTitle2, true);

				for(var j = 0; j < 3; j ++) {
    				cnt = 0;
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(j, cnt++ , dtHiddenStatus, 0,   daCenter,  true,  "ibflag");
	                InitDataProperty(j, cnt++ , dtData,         80,  daCenter,  true,  "cntr_tpsz_cd", false,  "",  dfNone);
	                InitDataProperty(j, cnt++ , dtData,         50,  daCenter,  true,  "div",          false,  "",  dfNone);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "g_ttl",        false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "jan",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "feb",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "mar",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "ttl_1",        false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "apr",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "may",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "jun",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "ttl_2",        false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "jul",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "aug",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "sep",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "ttl_3",        false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "oct",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "nov",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "dec",          false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "ttl_4",        false,  "",  dfFloat, 2);
	                InitDataProperty(j, cnt++ , dtAutoSum,      80,  daRight,   true,  "auto_sum",     false,  "",  dfFloat, 2);
				}

				ColHidden("auto_sum") = true;
                SelectBackColor = LSE_SELECT_BACK_COLOR;
                FrozenCols = 4;
                SelectRow = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
            }else if(document.form.report_type.value == "rp_0076"){
                // 높이 설정
                style.height = 280;
                //전체 너비 설정
                SheetWidth = 984;//mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 3, 15, 100);
    			var HeadTitleTemp  = "";
    			for(var i=0; i<arrTpSz.length; i++){
    				HeadTitleTemp = HeadTitleTemp + "|" + arrTpSz[i];
    			}
                var HeadTitle   = "sta|Charge Type|TP/SZ|G.TTL" + HeadTitleTemp +"|";
                var HeadTitle2  = "sta|Charge Type|DIV|G.TTL" + HeadTitleTemp +"|";
                var headCount   = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle , true);
                InitHeadRow(1, HeadTitle2, true);

				for(var j = 0; j < 3; j ++) {
    				cnt = 0;
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(j, cnt++ , dtHiddenStatus, 0,   daCenter,  true,  "ibflag");
	                InitDataProperty(j, cnt++ , dtData,         80,  daCenter,  true,  "charge_type",  false,  "",  dfNone);
	                InitDataProperty(j, cnt++ , dtData,         50,  daCenter,  true,  "div",          false,  "",  dfNone);
	                InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  "g_ttl",        false,  "",  dfFloat, 2);
	                for(var i=0; i<arrTpSz2.length; i++){
	                    InitDataProperty(j, cnt++ , dtData,         80,  daRight,   true,  arrTpSz2[i] + "",           false,  "",  dfFloat, 2);
	                }
	                InitDataProperty(j, cnt++ , dtAutoSum,      80,  daRight,   true,  "auto_sum",     false,  "",  dfFloat, 2);
				}

				ColHidden("auto_sum") = true;
                SelectBackColor = LSE_SELECT_BACK_COLOR;
                FrozenCols = 4;
                SelectRow = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
            }else if(document.form.report_type.value == "rp_0077"){
                                // 높이 설정
                style.height = 280;
                //전체 너비 설정
                SheetWidth = 984;//mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 15, 100);

                var HeadTitle   = "sta|Term|Month|Month|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var HeadTitle2  = "sta|Term|Lessee|Lessee|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var headCount   = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle , true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,   daCenter,  true,  "ibflag");
                InitDataProperty(0, cnt++ , dtData,         50,  daCenter,  true,  "lstm_cd",      false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         50,  daCenter,  true,  "vndr_seq",     false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         50,  daCenter,  true,  "abbr_nm",      false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "g_ttl",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "jan",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "feb",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "mar",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_1",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "apr",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "may",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "jun",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_2",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "jul",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "aug",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "sep",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_3",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "oct",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "nov",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "dec",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "ttl_4",        false,  "",  dfFloat, 2);

				InitDataProperty(0, cnt++ , dtAutoSum,      80,  daRight,   true,  "auto_sum",     false,  "",  dfFloat, 2);
				ColHidden("auto_sum") = true;
                SelectBackColor = LSE_SELECT_BACK_COLOR;
                FrozenCols = 5;
                SelectRow = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
            }else if(document.form.report_type.value == "rp_0078"){
                                // 높이 설정
                style.height = 280;
                //전체 너비 설정
                SheetWidth = 984;//mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 2, 1, 15, 100);

                var HeadTitle   = "sta|Month|Month|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var HeadTitle2  = "sta|Lessee|Lessee|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var headCount   = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle , true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,   daCenter, true,  "ibflag");
                InitDataProperty(0, cnt++ , dtData,         50,  daCenter, true,  "vndr_seq",     false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         50,  daCenter, true,  "abbr_nm",      false,  "",  dfNone);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "g_ttl",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "jan",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "feb",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "mar",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "ttl_1",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "apr",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "may",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "jun",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "ttl_2",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "jul",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "aug",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "sep",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "ttl_3",        false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "oct",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "nov",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "dec",          false,  "",  dfFloat, 2);
                InitDataProperty(0, cnt++ , dtData,         80,  daRight,  true,  "ttl_4",        false,  "",  dfFloat, 2);

				InitDataProperty(0, cnt++ , dtAutoSum,      80,  daRight,   true,  "auto_sum",    false,  "",  dfFloat, 2);
				ColHidden("auto_sum") = true;
                SelectBackColor = LSE_SELECT_BACK_COLOR;
                FrozenCols = 4;
                SelectRow = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
            }else if(document.form.report_type.value == "rp_0079"){
            	style.height = 280;
                //전체 너비 설정
                SheetWidth = 984;//mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo( 1, 1, 15, 100);
    			var HeadTitleTemp  = "";
    			for(var i=0; i<arrTpSz.length; i++){
    				HeadTitleTemp = HeadTitleTemp + "|" + arrTpSz[i];
    			}
    			var HeadTitle   = "|Month|Charge|Lessee|Lessee|Term|AGMT No.|Total" + HeadTitleTemp +"|";

    			var headCount   = ComCountHeadTitle(HeadTitle);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false,false)

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle , true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtHiddenStatus, 0,   daCenter,  true,  "ibflag");
    			InitDataProperty(0, cnt++ , dtData,         70,  daCenter,  true,  "cost_yrmon",   false,  "",  dfNone);
    			InitDataProperty(0, cnt++ , dtData,         70,  daCenter,  true,  "charge_type",  false,  "",  dfNone);
    			InitDataProperty(0, cnt++ , dtData,         60,  daCenter,  true,  "vndr_seq",     false,  "",  dfNone);
    			InitDataProperty(0, cnt++ , dtData,         60,  daCenter,  true,  "abbr_nm",      false,  "",  dfNone);
    			InitDataProperty(0, cnt++ , dtData,         40,  daCenter,  true,  "lstm_cd",      false,  "",  dfNone);
    			InitDataProperty(0, cnt++ , dtData,         80,  daCenter,  true,  "agmt_no",      false,  "",  dfNone);
    			InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  "g_ttl",        false,  "",  dfFloat, 2);
    			for(var i=0; i<arrTpSz2.length; i++){
    				InitDataProperty(0, cnt++ , dtData,         80,  daRight,   true,  arrTpSz2[i] + "",           false,  "",  dfFloat, 2);
    			}

    			InitDataProperty(0, cnt++ , dtAutoSum,      80,  daRight,   true,  "auto_sum",     false,  "",  dfFloat, 2);
				ColHidden("auto_sum") = true;
    			SelectBackColor = LSE_SELECT_BACK_COLOR;
    			FrozenCols = 8;
    			SelectRow = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
            }
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
	if(validateForm(sheetObj,formObj,sAction)){
		if (sheetObj.id == "sheet1"){
			formObj.f_cmd.value = SEARCH;

			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var rptType =document.form.report_type.value; 
			if(rptType == "rp_0076" || rptType =="rp_0079" ){
				var sXml = sheetObj.GetSearchXml("EES_LSE_0074GS2.do", FormQueryString(formObj));
			}else{
				var sXml = sheetObj.GetSearchXml("EES_LSE_0074GS.do", FormQueryString(formObj));
			}

			if(ComGetTotalRows(sXml) > 1) {
				sheetObj.LoadSearchXml(sXml);

				if(document.form.report_type.value == "rp_0074"){
					var strRows = ComFindAll(sheetObjects[0], 2, "S.TTL");
					if(strRows != -1) {
						strRows = strRows + "";
						arrRows = strRows.replaceStr("|", ",").split(",");
						for( var i = 0 ; i < arrRows.length ; i++ ){
							sheetObjects[0].SetMergeCell(arrRows[i] , 2, 1, 3);
						}
						if(sheetObjects[0].CellValue(sheetObjects[0].LastRow -1, 1) == "G.TTL" ){
							for(var j = 0; j < sheetObj.LastCol; j++) {
								sheetObj.CellText(sheetObj.LastRow, j) = sheetObj.CellText(sheetObj.LastRow -1, j);
							}

							sheetObj.RowHidden(sheetObj.LastRow -1) = true;
							sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow , 1, 1, 4);
							sheetObj.CellText(sheetObj.LastRow, 1) = "G.TTL";
							//sheetObjects[0].RowBackColor(sheetObjects[0].LastRow) = LSE_TOTCOL_BACK_COLOR;
						}
					}
				}else if(document.form.report_type.value == "rp_0075"){
					if(sheetObjects[0].CellValue(sheetObjects[0].LastRow -3 , 1) == "G.TTL" ){

						for(var i = sheetObj.LastRow -5; i < sheetObj.LastRow -2; i++) {
							sheetObj.CellAlign(i +3, "div") = daCenter;
							for(var j = 0; j < sheetObj.LastCol; j++) {
								sheetObj.CellText(i +3, j) = sheetObj.CellText(i, j);
							}
						}

						sheetObj.RowHidden(sheetObj.LastRow -5) = true;
						sheetObj.RowHidden(sheetObj.LastRow -4) = true;
						sheetObj.RowHidden(sheetObj.LastRow -3) = true;
						sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow -2, 1, 3, 1);
						//sheetObjects[0].RowBackColor(sheetObjects[0].LastRow) = LSE_TOTCOL_BACK_COLOR;
					}
				}else if(document.form.report_type.value == "rp_0076"){
					if(sheetObjects[0].CellValue(sheetObjects[0].LastRow -3 , 1) == "G.TTL" ){

						for(var i = sheetObj.LastRow -5; i < sheetObj.LastRow -2; i++) {
							sheetObj.CellAlign(i +3, "div") = daCenter;
							for(var j = 0; j < sheetObj.LastCol; j++) {
								sheetObj.CellText(i +3, j) = sheetObj.CellText(i, j);
							}
						}

						sheetObj.RowHidden(sheetObj.LastRow -5) = true;
						sheetObj.RowHidden(sheetObj.LastRow -4) = true;
						sheetObj.RowHidden(sheetObj.LastRow -3) = true;
						sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow -2, 1, 3, 1);
						//sheetObjects[0].RowBackColor(sheetObjects[0].LastRow) = LSE_TOTCOL_BACK_COLOR;
					}
				}else if(document.form.report_type.value == "rp_0077"){
					var strRows = ComFindAll(sheetObjects[0], 2, "S.TTL");
					if(strRows != -1) {
						strRows = strRows + "";
						arrRows = strRows.replaceStr("|", ",").split(",");
						for( var i = 0 ; i < arrRows.length ; i++ ){
							sheetObjects[0].SetMergeCell(arrRows[i] , 2, 1, 2);
						}
						if(sheetObjects[0].CellValue(sheetObjects[0].LastRow -1 , 1) == "G.TTL" ){
							for(var j = 0; j < sheetObj.LastCol; j++) {
								sheetObj.CellText(sheetObj.LastRow, j) = sheetObj.CellText(sheetObj.LastRow -1, j);
							}

							sheetObj.RowHidden(sheetObj.LastRow -1) = true;
							sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow , 1, 1, 3);
							sheetObj.CellText(sheetObj.LastRow, 1) = "G.TTL";
							//sheetObjects[0].RowBackColor(sheetObjects[0].LastRow) = LSE_TOTCOL_BACK_COLOR;
						}
					}
				}else if(document.form.report_type.value == "rp_0078"){
					if(sheetObjects[0].CellValue(sheetObjects[0].LastRow -1, 1) == "G.TTL" ){
						for(var j = 0; j < sheetObj.LastCol; j++) {
							sheetObj.CellText(sheetObj.LastRow, j) = sheetObj.CellText(sheetObj.LastRow -1, j);
						}

						sheetObj.RowHidden(sheetObj.LastRow -1) = true;
						sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow , 1, 1, 2);
						sheetObj.CellText(sheetObj.LastRow, 1) = "G.TTL";
						//sheetObjects[0].RowBackColor(sheetObjects[0].LastRow) = LSE_TOTCOL_BACK_COLOR;
					}
				}else if(document.form.report_type.value == "rp_0079"){
					if(sheetObjects[0].CellValue(sheetObjects[0].LastRow -1, 1) == "G.TTL" ){
						for(var j = 0; j < sheetObj.LastCol; j++) {
							sheetObj.CellText(sheetObj.LastRow, j) = sheetObj.CellText(sheetObj.LastRow -1, j);
						}

						sheetObj.RowHidden(sheetObj.LastRow -1) = true;
						sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow , 1, 1, 6);
						sheetObj.CellText(sheetObj.LastRow, 1) = "G.TTL";
						//sheetObjects[0].RowBackColor(sheetObjects[0].LastRow) = LSE_TOTCOL_BACK_COLOR;
					}
				}
			} else {
				sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
			}

			ComOpenWait(false);
			sheetObj.Redraw = true;
		}
	}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;

		if ( sXml2 != "" ) {
			comboObjects[1].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");
			formObj.tysz.value = vOrcCntrTpszCd;
			arrTpSz   =  vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2  =  vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
		}
		break;

	case IBSEARCH_ASYNC02:      //조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
				if(ComGetEtcData(sXml, "lstm_cd") == "SO" || ComGetEtcData(sXml, "lstm_cd") == "MO" ){
					formObj.contract_no.value = ComGetEtcData(sXml, "ref_no");
					comboObjects[0].CheckIndex(0) = false;
	 			    comboObjects[0].CheckCode(ComGetEtcData(sXml, "lstm_cd")) = true;
	 			    formObj.lstm_cd.value  = ComGetEtcData(sXml, "lstm_cd");
					formObj.vndr_seq.value = ComGetEtcData(sXml, "vndr_seq");
					formObj.abbr_nm.value  = ComGetEtcData(sXml, "vndr_abbr_nm");
					formObj.vndr_nm.value  = ComGetEtcData(sXml, "vndr_lgl_eng_nm");
				}else{
					ComShowCodeMessage("LSE01007");
					formObj.agmt_seq.value = "";
					formObj.contract_no.value = "";
					ComSetFocus(formObj.agmt_seq);
				}
			} else {
				ComShowCodeMessage("LSE01007");
				formObj.agmt_seq.value = "";
				formObj.contract_no.value = "";
				ComSetFocus(formObj.agmt_seq);
			}
		}
	}
	break;

	case IBSEARCH_ASYNC03:
		/* Lease Term Form Combo Item Setting */
		ComSetObjValue(formObj.f_cmd, SEARCH01);
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		if ( sXml != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		}
		vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");

		break;

	case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
	if ( validateForm(sheetObj, formObj, sAction) ) {
		var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
		sheetObj.WaitImageVisible = true;

		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
				ComSetFocus(formObj.vndr_nm);
			} else {
				ComShowCodeMessage("LSE01019");
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value  = "";
				ComSetFocus(formObj.vndr_seq);
			}
		} else {
			ComShowCodeMessage("LSE01019");
			formObj.vndr_seq.value = "";
			formObj.vndr_nm.value  = "";
			ComSetFocus(formObj.vndr_seq);
		}
	}
	break;
	case IBSEARCH_ASYNC05:	// Location 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var vLocTp = formObj.loc_tp.value;
			var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp + "CC"
			+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
			sheetObj.WaitImageVisible = true;
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
						var vLocCd = "";
						switch (vLocTp) {
						case "R":
							vLocCd = ComGetEtcData(sXml, "rcc_cd");
							break;

						case "L":
							vLocCd = ComGetEtcData(sXml, "lcc_cd");
							break;

						case "S":
							vLocCd = ComGetEtcData(sXml, "scc_cd");
							break;
						}
						formObj.loc_cd.value = vLocCd;
						ComSetFocus(formObj.loc_cd);
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
	case IBSEARCH_ASYNC06:	// Yard 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var param = "f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.loc_cd)
			+ "&mode=yard";
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do",param);
			sheetObj.WaitImageVisible = true;

			var rowCnt = ComGetTotalRows(sXml);
			if ( ComGetTotalRows(sXml) > 0 ) {
				ComSetFocus(formObj.loc_cd);
			} else {
				ComShowCodeMessage("LSE01048");
				formObj.loc_cd.value = "";
				ComSetFocus(formObj.loc_cd);
			}
		}
	}
	break;

	case IBSEARCH_ASYNC07:	// Country 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var param = "f_cmd="+SEARCH10+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
			sheetObj.WaitImageVisible = true;
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
						formObj.loc_cd.value = ComGetEtcData(sXml, "loc_cd") ;
					}else{
						ComShowCodeMessage("LSE01048");
						formObj.loc_cd.value = "";
						ComSetFocus(formObj.loc_cd);
					}
				}else{
					ComShowCodeMessage("LSE01048");
					formObj.loc_cd.value = "";
					ComSetFocus(formObj.loc_cd);
				}
			}else{
				ComShowCodeMessage("LSE01048");
				formObj.loc_cd.value = "";
				ComSetFocus(formObj.loc_cd);
			}
		}
	}
	break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:      //저장
			if(document.form.report_type.value == "rp_0075" || document.form.report_type.value == "rp_0077" || document.form.report_type.value == "rp_0078" ){
				var periodYear = formObj.period_year.value;
				if ( periodYear.length != 4 ) {
				    ComShowCodeMessage("LSE01010");
				    ComSetFocus(formObj.period_year);
				    return false;
				    break;
			    }
			}else{
			    var periodStdt = formObj.period_stdt.value;
			    periodStdt = periodStdt.replaceStr("-","");
			    var periodEtdt = formObj.period_eddt.value;
			    periodEtdt = periodEtdt.replaceStr("-","");

			    if ( periodStdt == "" ) {

				    ComShowCodeMessage("LSE01010");
				    ComSetFocus(formObj.period_stdt);
				    return false;
				    break;
			    }
			    if( periodStdt != "" &&  ComGetMaskedValue(periodStdt, "ym") != "" ){
			        if ( periodEtdt == "" ) {
				        ComShowCodeMessage("LSE01011");
				        ComSetFocus(formObj.period_eddt);
				        return false;
				        break;
			        }
			    }
				if(document.form.report_type.value == "rp_0074" || document.form.report_type.value == "rp_0076" || document.form.report_type.value == "rp_0079" ){
					if(document.form.period_eddt.value != ""){
						var chk = checkDatePeriod(document.form.period_stdt , document.form.period_eddt , "ym") ;
						if(chk == false){
							return false;
							break;
						}
					}
				}

				if(document.form.report_type.value == "rp_0074" || document.form.report_type.value == "rp_0076" || document.form.report_type.value == "rp_0079" ){
					var chk = checkDatePeriod(document.form.period_stdt , document.form.period_eddt , "ym") ;
					if(chk == false){
						return false;
						break;
					}
				}

			    if ( periodStdt.length == 6 && periodEtdt.length == 6 && Number(periodStdt) > Number(periodEtdt)) {
				    ComShowCodeMessage("LSE01051");
				    formObj.period_eddt.value = "";
				    ComSetFocus(formObj.period_eddt);
				    return false;
				    break;
			    }
			}
			break;
			}
		}
	}
	return true;
}

/**
* HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
*/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){
	case "period_stdt":
		//숫자이면서 천단위 구분을 하지 않는다.
		//ComChkObjValid(obj);
		ComAddSeparator(event.srcElement);
		break;
	case "period_eddt":
		//숫자이면서 천단위 구분을 하지 않는다.
		//ComChkObjValid(obj);
		ComAddSeparator(event.srcElement);
		break;
	case "btns_calendar3":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "agmt_seq":
		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
			document.form.contract_no.value = "";
		}
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value = "";
			document.form.abbr_nm.value = "";
		}
		break;
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
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
		      DropHeight = 250;
		      MultiSelect = true;
		      //MaxSelect = 1;
		      MultiSeparator = ",";
		      Style = 0;
		      UseAutoComplete = true;
		      //영문(대)+특수문자 - Lease Term
		      ValidChar(2,2);
		   }

		   break;

	case "combo2":
        with(comboObj) {
         DropHeight = 200;
         MultiSelect = true;
         //MaxSelect = 1;
         MultiSeparator = ",";
         Style = 0;
         UseAutoComplete = true;
         //영문(대)+특수문자,숫자 - TP/SZ
         ValidChar(2,3);
    }
    break;

	case "combo3":
		   with(comboObj) {
		      DropHeight = 250;
		      MultiSelect = true;
		      //MaxSelect = 1;
		      MultiSeparator = ",";
		      Style = 0;
		      UseAutoComplete = true;
		      //영문(대)+특수문자
		      ValidChar(2,2);
		   }

		   break;

	}
}
/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
function combo1_OnCheckClick(comboObj, index, code) {
  if(index==0) {
    var bChk = comboObj.CheckIndex(index);
    if(bChk){
      for(var i = 1 ; i < comboObj.GetCount() ; i++) {
        comboObj.CheckIndex(i) = false;
      }
    }
  } else {
    comboObj.CheckIndex(0) = false;
  }
}


/**
 * combo1_OnBlur
 */
function combo1_OnBlur(comboObj, Index_Code, Text) {
  var formObj = document.form;
  if( comboObj.CheckIndex(0)){
 	 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
          comboObj.CheckIndex(i) = false;
     }
 	formObj.lstm_cd.value = "";
 }else if(comboObj.Text == ""){
 	comboObj.CheckIndex(0) = true;
 	formObj.lstm_cd.value = "";
 }else{
  formObj.lstm_cd.value = ComGetObjValue(comboObj);
 }
}


/**
 * combo1_OnKeyDown
 */
 function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	 with(comboObj) {
	      if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
	    	  comboObj.Text = "";
	      }else if(KeyCode == 13){
	 		  sheetObjects[0].RemoveAll();
	 		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  }
	 }
 }


  /**
   * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
   * @return
   */
  function combo2_OnCheckClick(comboObj, index, code) {
    if(index==0) {
      var bChk = comboObj.CheckIndex(index);
      if(bChk){
        for(var i = 1 ; i < comboObj.GetCount() ; i++) {
          comboObj.CheckIndex(i) = false;
        }
      }
    } else {
      comboObj.CheckIndex(0) = false;
    }
  }

  /**
   * combo2_OnBlur
   */
  function combo2_OnBlur(comboObj, Index_Code, Text) {
    var formObj = document.form;
    if( comboObj.CheckIndex(0)){
    	 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
             comboObj.CheckIndex(i) = false;
         }
    	 formObj.cntr_tpsz_cd.value = "";
    }else if(comboObj.Text == ""){
    	comboObj.CheckIndex(0) = true;
    	formObj.cntr_tpsz_cd.value = "";
    }else{
        formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
    }
  }

  /**
   * combo2_OnKeyDown
   */
  function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
    with(comboObj) {
      if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
    	  comboObj.Text = "";
      }else if(KeyCode == 13){
 		  sheetObjects[0].RemoveAll();
 		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  }
    }
  }

   /**
    * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
    * @return
    */
   function combo3_OnCheckClick(comboObj, index, code) {
     if(index==0) {
       var bChk = comboObj.CheckIndex(index);
       if(bChk){
         for(var i = 1 ; i < comboObj.GetCount() ; i++) {
           comboObj.CheckIndex(i) = false;
         }
       }
     } else {
       comboObj.CheckIndex(0) = false;
     }
   }

   /**
    * combo3_OnBlur
    */
   function combo3_OnBlur(comboObj, Index_Code, Text) {
     var formObj = document.form;
     if( comboObj.CheckIndex(0)){
    	 for(var i = 1 ; i < comboObj.GetCount() ; i++) {
             comboObj.CheckIndex(i) = false;
         }
    	 formObj.charge_type_cd.value = "";
    }else if(comboObj.Text == ""){
    	comboObj.CheckIndex(0) = true;
    	formObj.charge_type_cd.value = "";
    }else{
     formObj.charge_type_cd.value = ComGetObjValue(comboObj);
    }
   }

   /**
    * combo3_OnKeyDown
    */
    function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
        with(comboObj) {
          if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
        	  comboObj.Text = "";
          }else if(KeyCode == 13){
	 		  sheetObjects[0].RemoveAll();
	 		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  }
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
		switch(formObj.loc_tp.value) {
		case "R" :	//RCC
		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "L" :	//LCC
		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "S" :	//SCC
		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "Y" :	//Yard
		ComOpenPopup("/hanjin/COM_ENS_061.do",755, 610, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
		break;
		case "C" :	//Country
		ComOpenPopup("/hanjin/COM_ENS_0M1.do",565, 480, 'getCOM_ENS_0M1_2', "1,0,1,1,1,1,1", true);
		break;
		default : 	//do nothing
		}

	} else if ( type == "2") {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);

	} else if ( type == "3") {
		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);

	}
}

/**
* DeliveryLoc(Country) Pop-up Return Value 처리 부분<br>
* @param {arry} returnedValues Pop-up 화면의 Return value array
* @param Row 대상Object가 IBSheet일 경우 해당 Row index
* @param Col 대상Object가 IBSheet일 경우 해당 Col index
* @param 대상IBSheet의 Sheet Array index
*/
function getCOM_ENS_0M1_2(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
	}
}

/**
* DeliveryLoc(Yard) Pop-up Return Value 처리 부분<br>
* @param {arry} returnedValues Pop-up 화면의 Return value array
* @param Row 대상Object가 IBSheet일 경우 해당 Row index
* @param Col 대상Object가 IBSheet일 경우 해당 Col index
* @param 대상IBSheet의 Sheet Array index
*/
function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
	}
}

/**
* Currency Pop-up Return Value 처리 부분<br>
* @param {arry} returnedValues Pop-up 화면의 Return value array
* @param Row 대상Object가 IBSheet일 경우 해당 Row index
* @param Col 대상Object가 IBSheet일 경우 해당 Col index
* @param 대상IBSheet의 Sheet Array index
*/
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if( aryPopupData.length > 0 ) {
		if(aryPopupData[0][6] == "SO" || aryPopupData[0][6] == "MO"){
		    ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
		    ComSetObjValue(formObj.contract_no, aryPopupData[0][5]);
		    comboObjects[0].CheckIndex(0) = false;
		    comboObjects[0].CheckCode(aryPopupData[0][6]) = true;
		    formObj.vndr_seq.value = aryPopupData[0][7];
		    formObj.abbr_nm.value  = aryPopupData[0][13];
		    formObj.vndr_nm.value  = aryPopupData[0][8];
		}
	}
}

/**
* Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
* @param {arry} returnedValues Pop-up 화면의 Return value array
* @param Row 대상Object가 IBSheet일 경우 해당 Row index
* @param Col 대상Object가 IBSheet일 경우 해당 Col index
* @param 대상IBSheet의 Sheet Array index
*/
function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
		formObj.vndr_nm.value  = aryPopupData[0][4];
		formObj.abbr_nm.value  = aryPopupData[0][5];
	}
}

/**
* HTML Control의 Value가 변경되었을 경우 처리한다.
*/
function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
		switch(obj.name) {
		case "agmt_seq":
			if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
			}
			break;

		case "vndr_seq":
			if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
			}
			break;

		case "loc_cd":		//Location Code
		if ( ComTrim(obj.value) != "" ) {
			if(document.form.loc_tp.value == "Y" ) {
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC06);
			} else if(document.form.loc_tp.value == "C" ) {
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC07);
			} else if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L" || document.form.loc_tp.value == "S"){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
			}
		}
		break;

		case "loc_tp":		//Location Type
		formObj.loc_cd.value = "";
		if(obj.value == "") {
			formObj.loc_cd.readOnly = true;
			formObj.loc_cd.className = "input2";
			ComEnableObject(formObj.btns_search1, false);
			if(document.form.report_type.value == "rp_0074"){
			   sheetObjects[0].CellText(0, 1) = "RCC";
			   sheetObjects[0].CellText(1, 1) = "RCC";
			}
		} else {
			formObj.loc_cd.readOnly = false;
			formObj.loc_cd.className = "input";
			ComEnableObject(formObj.btns_search1, true);
			if(obj.value == "Y"){
			    formObj.loc_cd.maxLength = 7;
			}else if(obj.value == "C"){
				formObj.loc_cd.maxLength = 2;
				if(document.form.report_type.value == "rp_0074"){
					sheetObjects[0].CellText(0, 1) = "Country";
					sheetObjects[0].CellText(1, 1) = "Country";
				}

			}else if(obj.value == "R"){
				formObj.loc_cd.maxLength = 5;
				if(document.form.report_type.value == "rp_0074"){
					sheetObjects[0].CellText(0, 1) = "RCC";
					sheetObjects[0].CellText(1, 1) = "RCC";
				}
			}else if(obj.value == "L"){
				formObj.loc_cd.maxLength = 5;
				if(document.form.report_type.value == "rp_0074"){
					sheetObjects[0].CellText(0, 1) = "LCC";
					sheetObjects[0].CellText(1, 1) = "LCC";
				}
			}else if(obj.value == "S"){
				formObj.loc_cd.maxLength = 5;
				if(document.form.report_type.value == "rp_0074"){
					sheetObjects[0].CellText(0, 1) = "SCC";
					sheetObjects[0].CellText(1, 1) = "SCC";
				}
			}else{
				formObj.loc_cd.maxLength = 5;
				if(document.form.report_type.value == "rp_0074"){
					sheetObjects[0].CellText(0, 1) = "RCC";
					sheetObjects[0].CellText(1, 1) = "RCC";
				}
			}
			ComSetNextFocus(obj);
		}
		break;

		case "period_stdt":		//Location Code


		    if(document.form.report_type.value == "rp_0074" || document.form.report_type.value == "rp_0076" || document.form.report_type.value == "rp_0079" ){

		    	if(formObj.period_stdt.value != "" && formObj.period_eddt.value != "" ){
		    		var chk = period_termchk(formObj.period_stdt.value ,  formObj.period_eddt.value);
		    		if(Number(chk) > 12){
		    			ComShowCodeMessage("LSE01146");
		    		    formObj.period_eddt.value = "";
		    		    ComSetFocus(formObj.period_eddt);
				        return;
				    }
		    		checkDatePeriod( formObj.period_stdt , formObj.period_eddt , "ym") ;
	    	    }
	        }
	    break;

		case "period_eddt":		//Location Code
		    if(document.form.report_type.value == "rp_0074" || document.form.report_type.value == "rp_0076" || document.form.report_type.value == "rp_0079" ){
		    	var chk = period_termchk(formObj.period_stdt.value ,  formObj.period_eddt.value);
		    	if(formObj.period_stdt.value != "" && formObj.period_eddt.value != "" && Number(chk) > 12){
		    		ComShowCodeMessage("LSE01146");
		    	    formObj.period_eddt.value = "";
		    	    ComSetFocus(formObj.period_eddt);
		    	    return;
		    	}
		    	checkDatePeriod( formObj.period_stdt , formObj.period_eddt , "ym") ;
		    }
		break;

		case "report_type":		//Location Code
		    sheetObjects[0].Reset()
		    initSheet(sheetObjects[0],1);
		    document.form.period_stdt.value = "";
		    document.form.period_eddt.value = "";
		    document.form.period_year.value = "";

		    if(document.form.report_type.value == "rp_0075" || document.form.report_type.value == "rp_0077" || document.form.report_type.value == "rp_0078" ){
		    	var OBJ1 = document.getElementById("fixLayer1");
		    	OBJ1.style.visibility = "hidden";
		        var OBJ2 = document.getElementById("fixLayer2");
		    	OBJ2.style.visibility = "visible";
		    	document.form.temp_text1.focus();
		    	document.form.period_year.focus();
		    }else{
		    	var OBJ1 = document.getElementById("fixLayer1");
		    	OBJ1.style.visibility = "visible";
		        var OBJ2 = document.getElementById("fixLayer2");
		    	OBJ2.style.visibility = "hidden";
		    	document.form.temp_text1.focus();
		    	document.form.period_stdt.focus();
		    }

			if(document.form.report_type.value == "rp_0074" ){
				for(var i = 1 ; i < comboObjects[2].GetCount(); i++ ){
					comboObjects[2].CheckIndex(i)=false;
				}
				comboObjects[2].CheckIndex(0) = true;
				comboObjects[2].Enable = false;
				sheetObjects[0].CellText(0, 1) = "RCC";
				sheetObjects[0].CellText(1, 1) = "RCC";

				document.form.loc_cd.value = "";
				document.form.loc_tp[0].selected = true;
	            ComEnableObject(document.form.btns_search1, false);

			}else if(document.form.report_type.value == "rp_0079" ){
				for(var i = 1 ; i < comboObjects[2].GetCount(); i++ ){
					comboObjects[2].CheckIndex(i)=false;
				}
				comboObjects[2].CheckIndex(0) = true;
				comboObjects[2].Enable = false;
			}else{
				comboObjects[2].Enable = true;
			}



	    break;

		}
}
/**
* HTML Control의 키보드 이벤트 방 포멧처리 한다.
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
}

/**
* HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
*/
function obj_focus(){
	var obj  = event.srcElement;
	if( obj.readOnly ) {
			ComSetNextFocus(obj);
	} else {
	    //마스크구분자 없애기
	    if(document.form.report_type.value == "rp_0075" || document.form.report_type.value == "rp_0077" || document.form.report_type.value == "rp_0078" ){
	        //ComClearSeparator(event.srcElement);
	    }else{
	    	if(obj.name == "period_stdt" ||  obj.name == "period_eddt"){
			    if(obj.value.length == 7 ){
	    	        ComClearSeparator(event.srcElement);
			    }
	    	}
	    }
	}
}

/**
 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		//sheetObj.LastRow

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
 		    case "aaa":
 		    default :
 			    if ( srcObj.style.filter == "" ) {
 				    sheetObjects[0].RemoveAll();
 				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			    }
 	    }
 	}
 }

/**
 * 조회조건 시작 일자 종료일자의 개월수를 계산하는 함수
 */
function period_termchk(stDt , endDt){
   var stYear   = stDt.substr(0,4);
   var stMonth  = "";
   if(stDt.length == 6){
	   stMonth = stDt.substr(4,6);
   }else{
	   stMonth = stDt.substr(5,7);
   }

   var endYear  = endDt.substr(0,4);
   var endMonth = "";

   if(endDt.length == 6){
	   endMonth = endDt.substr(4,6);
   }else{
	   endMonth = endDt.substr(5,7);
   }

   var sdate = new Date(stYear,Number(stMonth),1);
   var edate = new Date(endYear,Number(endMonth),1);
   var sDate  = sdate.getDate();
   var count=0;

   while (Date.parse(edate)>=Date.parse(sdate)) {
      if(sdate.getDate() == sDate){
         count++;
      }
      sdate.setDate(sdate.getDate()+1);
   }
   return count;
}
/* 개발자 작업  끝 */