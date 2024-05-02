/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESD_EAS_0218.js
 *@FileTitle : Statistics by RHQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.01
 *@LastModifier : 최종혁
 *@LastVersion : 1.0
 * 2014.12.01 최종혁
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
 * @class ESD_EAS_0218 : ESD_EAS_0218 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0218() {
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

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;	

// offce_level 설정
// 1 : 본부, 2:RQH, 3: 기타
var ofcLevel="";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;	


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
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/** 
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음
 * @return 없음
 * @see #
 * @author Choi Do Soon
 * @version 2009.11.16
 */
function loadPage() {
	var formObj = document.form;
	getEasIbComboList(formObj.s_cal_val , 'I|U|T' , 'Input|Round Up|Round Down' , ''); // Calculation Value
	formObj.s_cal_val.code2 = 'I';
	
	for(i=0;i<sheetObjects.length;i++){
		//-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObj,"offce_level");

	getEasIbComboList(formObj.s_eac_tp_cd , s_eac_tp_cdCode , s_eac_tp_cdText , 'ALL'); // EAC Type
	getEasIbComboList(formObj.s_eac_apro_tp_cd , s_eac_apro_tp_cdCode , s_eac_apro_tp_cdText , 'ALL'); // Audit Type

	formObj.s_eac_yrmon_fm.value = EasGetMonthCalc(ComGetNowInfo("ym"), -1);
	formObj.s_eac_yrmon_to.value = ComGetNowInfo("ym");

	initControl();
}

function initControl() {
	axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
	axon_event.addListenerFormat('blur',    'obj_blur',     document.form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	axon_event.addListenerFormat('focus',   'obj_focus',  document.form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
}

/**
 * HTML Control의 onChange이벤트 처리<br>
 **/
function obj_change(){
	var obj = event.srcElement;
	switch(obj.name) {	
		case "s_eac_yrmon_fm":
			if(!ComChkObjValid(obj))obj.value="" ;
			break;	
		case "s_eac_yrmon_to":
			if(!ComChkObjValid(obj))obj.value="" ;
			break;	
	}
} 

/**
 * HTML Control의 onblur이벤트 처리<br>
 **/
function obj_blur(){
	var obj = event.srcElement;
	var formObj = document.form;
	switch(obj.name) {	
	case "s_eac_yrmon_fm":
		obj.value = ComGetMaskedValue(obj,   "ym");
		formObj.s_eac_yrmon_to.value = EasGetMonthCalc(obj.value, 1);
		break;	
	case "s_eac_yrmon_to":
		obj.value = ComGetMaskedValue(obj,   "ym");
		break;	
	}
}

/**
 * HTML Control의 onfocus이벤트 처리<br>
 **/
function obj_focus(){
	var obj = event.srcElement;
	switch(obj.name) {	
	case "s_eac_yrmon_fm":
		ComClearSeparator(obj);
		obj.select();
		break;	
	case "s_eac_yrmon_to":
		ComClearSeparator(obj);
		obj.select();
		break;	
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var formObj = document.form;
	switch(sheetNo) {
	case 1:      //sheet1 init
		with (sheetObj) {
		// 높이 설정
		style.height = GetSheetHeight(21);
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(3, 1, 10, 100);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false) ;

		var HeadTitle1 = "Status|SEQ|Audit\nOffice|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Misbilling Type|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Internal Error|Missing TPB|Missing TPB|Total|Total|color_cd";
		var HeadTitle2 = "Status|SEQ|Audit\nOffice|Volume Unmatch|Volume Unmatch|Rate Discrepancy|Rate Discrepancy|Double Billing|Double Billing|Not SML's Account|Not SML's Account|Lack of Evidence|Lack of Evidence|Others|Others|Sub-Total|Sub-Total|Booking|Booking|Work Order|Work Order|Operation|Operation|Contract|Contract|System|System|Others|Others|Sub-Total|Sub-Total|Missing TPB|Missing TPB|Total|Total|color_cd";
		var HeadTitle3 = "Status|SEQ|Audit\nOffice|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|Case|Amount|color_cd";

		var headCount = ComCountHeadTitle(HeadTitle1);
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		InitHeadRow(2, HeadTitle3, true);

		var amtPointCount = 2;
		var calVal = formObj.s_cal_val.Code;
		if (calVal == "I") {
			amtPointCount = 2;
		}else{
			amtPointCount = 0;
		}
		
		HeadRowHeight = 12;
		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "status",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtSeq,          45,  	daCenter,   true,   "seq",              	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "rhq_ofc_cd",        	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_bil_umch_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_bil_umch_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_rt_dis_umch_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_rt_dis_umch_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_dbl_bil_umch_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_dbl_bil_umch_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_not_acct_umch_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_not_acct_umch_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_lack_evid_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_lack_evid_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_otr_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_otr_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "m_sub_tot_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "m_sub_tot_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);

		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_bkg_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_bkg_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_wrk_ord_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_wrk_ord_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_op_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_op_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_ctrt_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_ctrt_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_sys_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_sys_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_otr_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_otr_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "i_sub_tot_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "i_sub_tot_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);

		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "mis_tpb_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "mis_tpb_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   true,   "tot_cnt",        	false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtData,         90,  	daRight,   true,   "tot_amt",        	false,    "",      dfNullFloat,          amtPointCount,          true,        true,   0,  false, true,  "", false);
		InitDataProperty(0, cnt++ , dtHidden,         90,  	daRight,   true,   "color_cd",        	false,    "",      dfNullFloat,          0,          true,        true,   0,  false, true,  "", false);

		SetMergeCell(0,31,2,2);
		SetMergeCell(0,33,2,2);
	}
		break;
	}
}	

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;
		case "btn_downexcel":
			doActionIBSheet(sheetObject1, formObj, "btn_downexcel");
			break;
		case "btns_calendar_s":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObj.s_eac_yrmon_fm, 'yyyy-MM');
			break;
		case "btns_calendar_e":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObj.s_eac_yrmon_to, 'yyyy-MM');
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

//SHEET 관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	switch (sAction) {

	// SEARCH LOGIC
	case IBSEARCH:
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch4Post("ESD_EAS_0218GS.do", FormQueryString(formObj));
		}
		break;
	case "btn_downexcel":	// EXCEL DOWNLOAD
		sheetObj.Down2Excel(-1);
		break;

	case "offce_level":
		formObj.f_cmd.value = COMMAND01;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");

		var rhqSearchFlag = true;
		var ofcSearchFlag = true;

		// 로그인한 RHQ OFFCD 셋팅
		formObj.s_rhq_ofc_cd.InsertItem(0,rhq_ofc_cd, rhq_ofc_cd);

		if(ofcLevel=="O"){
			// 본사(심사팀) RHQ 소속이외
			rhqSearchFlag = false;
			ofcSearchFlag = false;        			
			formObj.s_rhq_ofc_cd.Enable=false;
			formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd; //Onchange Event 발생을 안하도록 index 셋팅이 아닌 code값을 설정
		}else if(ofcLevel=="R"){
			rhqSearchFlag = false;
			ofcSearchFlag = true;
			formObj.s_rhq_ofc_cd.Enable=false;
			formObj.s_rhq_ofc_cd.Index=0;
		}else if(ofcLevel=="H"){
			// 본사(심사팀) 소속
			rhqSearchFlag = true;
			ofcSearchFlag = true;
			formObj.s_rhq_ofc_cd.Enable=true;              		
		}
		if(rhqSearchFlag){
			//RHQ 콤보 리스트 조회
			formObj.s_rhq_ofc_cd.RemoveAll();
			formObj.f_cmd.value = COMMAND02;
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
			formObj.s_rhq_ofc_cd.InsertItem(0,'', '');
		}

		sheetObj.WaitImageVisible = true;
		break;
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	case IBSEARCH :
		if(formObj.s_eac_yrmon_fm.value == "" || formObj.s_eac_yrmon_to.value == ""){
			ComShowCodeMessage('COM130201', 'Audit Month'); // Booking No 값을 입력하셔야 합니다;
			return false;
		}

		var ls_fm_dt = removeBar(formObj.s_eac_yrmon_fm.value) + '01';
		var ls_to_dt = removeBar(formObj.s_eac_yrmon_to.value) + '01';
		var days_between = ComGetDaysBetween(ls_fm_dt , ls_to_dt) ;  // 조회 기간

		if ( days_between > 364 ) {
			ComShowCodeMessage("EAS90079");//Possible inquiry period is limited to 12 month.
			return false;
		}
		
		break;
	} // end switch()
	return true;
}	 		

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	for( var i = parseInt(sheetObj.HeaderRows); i <= sheetObj.LastRow; i++ ){		
		
		if (  sheetObj.CellValue(i, 'color_cd') == '2' ) {		
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(249,240,134);
		}else if (  sheetObj.CellValue(i, 'color_cd') == '3' ) {		
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(247,225,236);
		}		
	}
}

/**
 * Calculation Value 변경시 Amount Format 변경
 */
function s_cal_val_OnChange(comboObj,Index_Code, Text){
	var formObj = document.form;
	initSheet(sheetObjects[0],1);
}

/* 개발자 작업  끝 */