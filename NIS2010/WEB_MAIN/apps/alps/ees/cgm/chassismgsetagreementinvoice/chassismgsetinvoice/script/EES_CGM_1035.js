/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1035.js
 *@FileTitle : Invoice Inquiry
 *Open Issues :
 *Change history : 1. 2015.03.05, CHM-201534565, 이율규, 다운 엑셀 버튼 추가
 *@LastModifyDate : 2009.12.21
 *@LastModifier : 조재성
 *@LastVersion : 1.0
 * 2009.12.21 조재성
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
 * @class EES_CGM_1035 : EES_CGM_1035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_1035() {
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if (validateForm(sheetObject1, formObject, IBSEARCH) != false) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;

		case "btn_New":
			initControl();
			break;

		case "btns_Calendar1": // Agreement Date (To Date)
			if(formObject.cost_yrmon.Code == "cost_month")
    	  	{
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.inv_fm_date, "yyyy-MM");
    	  	}else
    	  	{
            	var cal = new ComCalendarFromTo();
            	cal.select(formObject.inv_fm_date,  formObject.inv_to_date,  'yyyy-MM-dd');
    	  	}
			break;
			
		case "btns_Calendar2": // Agreement Date (To Date)
			if(formObject.cost_yrmon.Code == "cost_month")
    	  	{
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.inv_to_date, "yyyy-MM");
    	  	}else
    	  	{
            	var cal = new ComCalendarFromTo();
            	cal.select(formObject.inv_fm_date,  formObject.inv_to_date,  'yyyy-MM-dd');
    	  	}			
			break;
			
		case "btns_office": // Office Code 가져오기 팝업
			if (!formObject.cost_ofc_cd.readOnly) {
				ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480,
						"ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
			}
			break;
		case "btns_vndr":
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor",
					"1,0,1,1,1,1", true, false);
			break;
		
		case "btn_Exceldown": 
		sheetObject1.SpeedDown2Excel(-1);	// 1. 2015.03.05, CHM-201534565, 이율규, 다운 엑셀 버튼 추가
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
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * 콜백 함수. <br>
 * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 조재성
 * @version 2009.12.22
 */
function callBackVendor(aryPopupData, row, col, sheetIdx) {

	var formObj = document.form;
	var vndrSeq = "";
	var vndrNm = "";
	var i = 0;

	for (i = 0; i < aryPopupData.length; i++) {
		vndrSeq = vndrSeq + aryPopupData[i][2];
		vndrNm = vndrNm + aryPopupData[i][4];
		if (i < aryPopupData.length - 1) {
			vndrSeq = vndrSeq + ",";
			vndrNm = vndrNm + ",";
		}
	}

	formObj.vndr_seq.value = vndrSeq;
	formObj.vndr_nm.value = vndrNm;

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
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

}

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.12.22
 */
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	// axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListener('change', 'obj_change', 'cost_ofc_cd');
	axon_event.addListener('change', 'obj_change', 'inv_csr_no');
	// axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	axon_event.addListener('change', 'obj_change', 'vndr_seq');
	axon_event.addListener('change', 'period_type_change', 'cost_yrmon');
	
	/**
	 * 20091019 떨림현상 제거 start
	 */
	// Multi Combo 초기화
	comboObjects[comboCnt++] = document.cost_yrmon;
	comboObjects[comboCnt++] = document.chss_mgst_inv_knd_cd;
	comboObjects[comboCnt++] = document.inv_status;
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}

	// cost_yrmon 값 초기화
	var arrActive = new Array();
	arrActive[0] = "cost_month|Cost Month";
	arrActive[1] = "issue_date|Issue Date";
	arrActive[2] = "receive_date|Receive Date";
	arrActive[3] = "confirm_date|Confirm Date";
	arrActive[4] = "payment_date|Payment Date";
	makeComboObject(document.form.cost_yrmon, arrActive, 1, 0, 0);

	// chss_mgst_inv_knd_cd 값 초기화
	var arrT2 = new Array();
	arrT2[0] = "LS|Lease         ";
	arrT2[1] = "CP|Co-Op Pool    ";
	arrT2[2] = "NP|Neutral Pool  ";
	// makeComboObject(document.form.chss_mgst_inv_knd_cd, arrT2, 1, 0, 0);
	MakeComboObject2(document.form.chss_mgst_inv_knd_cd, arrT2, 0);

	// INV_STATUS 조회
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);

	initControl();

	sheetObj.WaitImageVisible = true;
}

/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */
function initControl() {
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];

	// Form Object 초기화
	with (formObj) {
//		inv_fm_date.value = '200901'; //"";
//		inv_to_date.value = '200912';  //"";
//		cost_ofc_cd.value = 'SELPIO'; //formObj.ofc_cd.value;
//		cre_usr_id.value = '0360371'; //formObj.usr_id.value;
		
		inv_fm_date.value = "";
		inv_to_date.value = "";
		cost_ofc_cd.value = ""; //formObj.ofc_cd.value;
		cre_usr_id.value = ""; //formObj.usr_id.value;
		inv_csr_no_chk[0].checked = true;
		vndr_seq.value = "";
		vndr_nm.value = "";
	}

	// MultiCombo 초기화
	for ( var i = 0; i < comboObjects.length; i++) {
		comboObjects[i].Text2 = "";
	}
	// Sheet Object 초기화
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	// sheetObj.ColHidden("group1") = true;
	// 초기값 설정
	comboObjects[0].Index = 0;
	comboObjects[2].Index2 = 0;

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 172;//202;
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
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle1 = "|Seq.|DIV|S.Provider|Invoice No.|CSR No.|Status|Cost Month|Rev Month|Net Amount|Tax DIV|Tax|Total Amount|Issue DT|Receive DT|Confirm DT|CRE User"
								+ "|pay_inv_seq";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 6, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	"Status");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "chss_mgst_inv_knd_cd", 	false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vndr_nm", 				false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "inv_no", 				false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "csr_no", 				false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "inv_sts_nm",			false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cost_yrmon", 			false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rev_vvd", 				false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "chg_smry_amt", 			false,	"", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "inv_tax_clt_tp_cd", 	false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "inv_tax_rt", 			false,	"", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true, "inv_smry_amt", 			false,	"", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "inv_iss_dt", 			false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "inv_rcv_dt", 			false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "inv_cfm_dt", 			false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "usr_nm", 				false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,30,	 daCenter,	true, "pay_inv_seq");
			CountPosition = 0;

		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 172;//202;
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
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle1 = "|Seq.|Agreement No.|Term|Account|EQ No.|TP/SZ|Currency|CHG TP|Tax|Credit|Rental";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
		    
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	"Status");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "Seq", 			false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "agmt_no", 		false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "agmt_lstm_cd", 	false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "acct_cd", 		false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "eq_no", 		false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "eq_tpsz_cd", 	false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "curr_cd", 		false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "chg_cd", 		false,	"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 110, daRight, true, "pay_tax_amt", 	false,	"", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 110, daRight, true, "pay_cr_amt", 	false,	"", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "pay_lse_chg_amt",false,	"", dfFloat, 2, false, false);
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
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1")
			{
				sheetObjects[0].removeAll();
				sheetObjects[1].removeAll();
				// Form Object 값 설정
		    	formObj.f_cmd.value = SEARCH;
		 		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
		 		
		 		// 조회실행
		 		if(validateForm(sheetObj,formObj,sAction))
		 		{
			 		sheetObj.WaitImageVisible=false;
			 		ComOpenWait(true);		 			
		 			var sXml = sheetObj.GetSearchXml("EES_CGM_1035GS.do" , FormQueryString(formObj));
		 			sheetObj.LoadSearchXml(sXml);
			 		ComOpenWait(false);
		 		}
		 		
			}
			else if (sheetObj.id == "sheet2")
			{
				sheetObjects[1].removeAll();
				// Form Object 값 설정
		    	formObj.f_cmd.value = SEARCH01;
		 		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
		 		
		 		// 조회실행
		 		if(validateForm(sheetObj,formObj,sAction))
		 		{
			 		sheetObj.WaitImageVisible=false;
			 		ComOpenWait(true);		 			
		 			var sXml = sheetObj.GetSearchXml("EES_CGM_1035GS.do" , FormQueryString(formObj));
		 			sheetObj.LoadSearchXml(sXml);
			 		ComOpenWait(false);
		 		}
			}

		break;

	case IBSEARCH_ASYNC03: // Option 조회
		formObj.f_cmd.value = SEARCH;
		formObj.intg_cd_id.value = COM_CD_TYPE_CD02355;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do",
				FormQueryString(formObj), '', true);
		var sStr = ComGetEtcData(sXml, "comboList");
		var arrStr = sStr.split("@");

		// combo control, 결과 문자열, Text Index, Code Index
		MakeComboObjectAll(document.form.inv_status, arrStr, 1, 0);
		break;

	case IBSEARCH_ASYNC04:
		var ofcCd = formObj.ofc_cd.value;
		formObj.ofc_cd.value = formObj.cost_ofc_cd.value;

		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("CgmValidationGS.do",
				FormQueryString(formObj), '', true);
		var sCheckResult = ComGetEtcData(sXml, "checkResult");
		if (sCheckResult == COM_VALIDATION_FALSE) {
			ComShowCodeMessage('CGM10009', 'Office');
			formObj.cost_ofc_cd.value = "";
			formObj.cost_ofc_cd.focus();
		}
		formObj.ofc_cd.value = ofcCd;
		break;

 	case IBSEARCH_ASYNC05:	// Vendor Code,Name 조회
		formObj.f_cmd.value = SEARCH07;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
		var text = ComCgmNullToBlank(ComGetEtcData(sXml,"text"));
		
		formObj.vndr_nm.value = text;
		break;			
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
 * @author 조재성
 * @version 2009.07.21
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			// 날짜 공백 체크
			if (inv_fm_date.value == '') {
				ComShowCodeMessage('CGM10004', 'Period ');
				inv_fm_date.focus();
				return false;
			}
			if (inv_to_date.value == '') {
				ComShowCodeMessage('CGM10004', 'Period ');
				inv_to_date.focus();
				return false;
			}
			// 날짜 범위 체크
			var dt_str = ComReplaceStr(document.form.inv_fm_date.value, "-", "");
			var dt_end = ComReplaceStr(document.form.inv_to_date.value, "-", "");

			if (dt_str != '' && dt_end != '') {
				if (dt_end < dt_str) {
					ComShowCodeMessage('COM12133', 'To date', 'From date',
							'greater');
					inv_fm_date.value = '';
					inv_to_date.value = '';
					inv_fm_date.focus();
					return false;
				}
			}
			
			/* chungpa 20091224 필수사항이 아님.
			// Office 체크
			if (document.form.cost_ofc_cd.value == '') {
				ComShowCodeMessage('CGM10009', 'Invoice Office.');
				return false;
			}
			// Creation User ID check
			if (document.form.cre_usr_id.value == '') {
				ComShowCodeMessage('CGM10009', 'Creation User ID.');
				return false;
			}
			*/
			break;
		}
	}
	return true;
}
 
 /** 
 * Invoice Date 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 
 * @version 2013.03.25
 */ 
function cost_yrmon_OnChange(comboObj, idx_cd, text){
	if(idx_cd == "cost_month"){
		document.getElementById("inv_fm_date").setAttribute("maxLength", 6);
		document.getElementById("inv_to_date").setAttribute("maxLength", 6);
	}else{
		document.getElementById("inv_fm_date").setAttribute("maxLength", 8);
		document.getElementById("inv_to_date").setAttribute("maxLength", 8);
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) != "CHK")
		return; // 체크컬럼이 바뀐경우만 처리
	var Col2 = sheetObj.SaveNameCol("InvoiceNo"); // InvoiceNo 컬럼 위치
	var sInvoiceNo = sheetObj.CellText(Row, Col2); // InvoiceNo 값
	var Row2 = sheetObj.FindText(Col2, sInvoiceNo); // InvoiceNo 값이 동일한 행 찾기
	while (Row2 > 0) {
		sheetObj.CellValue2(Row2, Col) = Value; // InvoiceNo 값이 동일한 행 체크
		Row2 = sheetObj.FindText(Col2, sInvoiceNo, Row2 + 1);
	}
}

/** 
 * Object 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */
function obj_change() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	obj = event.srcElement;
	switch (obj.name) {

	case "inv_csr_no":
		var invCsrNo = ComTrimAll(formObj.inv_csr_no.value);
		var arrInvCsrNo = invCsrNo.split(",");

		for ( var i = 0; i < arrInvCsrNo.length; i++) {
			// 입력오류 체크 (예> ,,)
			if (arrInvCsrNo[i] == '') {
				ComShowCodeMessage('CGM10009', 'Invoice No.');
				formObj.inv_csr_no.value = "";
				ComSetFocus(formObj.inv_csr_no);
				break;
			}
		}
		break;

	case "cost_ofc_cd":
		if (formObj.cost_ofc_cd.value != '') {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
		}
		break;

	case "vndr_seq":
 		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
 		
 		if(vndrSeq != ''){
 			// Lessor 명칭 가져오기
	 		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
 		} else {
 			// vndr_seq 입력 텍스트에서 삭제할 경우 Lessor 명칭을 삭제
 			formObj.vndr_nm.value = "";
 		}
		break;
	}
}
/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.12.23
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
}

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.12.23
 */
function obj_deactivate() {
	var formObj = document.form;
	obj = event.srcElement;

	if (obj.name == "inv_fm_date") {
		with (formObj) {
			var creDtFr = ComReplaceStr(inv_fm_date.value, "-", "");
		}
		ComChkObjValid(event.srcElement);
	}
	if (obj.name == "inv_to_date") {
		with (formObj) {
			var creDtFr = ComReplaceStr(inv_to_date.value, "-", "");
		}
		ComChkObjValid(event.srcElement);
	}
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.12.22
 */
function obj_keypress() {
	obj = event.srcElement;
	if (obj.dataformat == null)
		return;

	window.defaultStatus = obj.dataformat;

	switch (obj.dataformat) {
	case "ym":
	case "ymd":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		if (obj.name == "vndr_seq")
			ComKeyOnlyNumber(obj, ",");
		else
			ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		if (obj.name == "vndr_seq") {
			//ComKeyOnlyNumber(obj, ","); // multi
			ComKeyOnlyNumber(obj); // single
		} else
			ComKeyOnlyAlphabet();
		break;
	case "engup":
		if (obj.name == "cost_ofc_cd")
			ComKeyOnlyAlphabet('uppernum');
		else if (obj.name == "inv_csr_no")
			ComKeyOnlyAlphabet('uppernum', "44");
		else
			ComKeyOnlyAlphabet('upper');
		break;
	case "engdn":
		if (obj.name == "txtEngDn2")
			ComKeyOnlyAlphabet('lowernum')
		else
			ComKeyOnlyAlphabet('lower');
		break;
	}
}
/** 
 * Combo Object 초기화  <br>
 * @param  {object} comboObj	필수 Combo Object
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */
function initCombo(comboObj) {
	switch (comboObj.id) {
	case "cost_yrmon":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			DropHeight = 100;
			MultiSelect = false;
			MaxSelect = 1;
			UseCode = true;
			Enable = true;
		}
		break;

	case "chss_mgst_inv_knd_cd":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			DropHeight = 100;
			MultiSelect = true;
			MaxSelect = 10;
			UseCode = true;
			Enable = true;

			ValidChar(2, 3); // 영어 대문자, 숫자포함+특수(',')
			IMEMode = 0; // 영문
			MaxLength = 50; // 100자까지 입력
		}
		break;

	case "inv_status":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			BackColor = "#FFFFFF";
			DropHeight = 100;
			MultiSelect = false;
			MaxSelect = 1;
			UseCode = true;
			Enable = true;
		}
		break;
	}
}

/** 
 * Combo Object 에 값을 추가하는 처리 <br>
 * @param  {object} cmbObj	필수 Combo Object
 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
 * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
 * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
 * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
 * @return 없음
 * @author 조재성
 * @version 2009.07.16
 */
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	cmbObj.RemoveAll();

	if (opt == 0) {
		for ( var i = 0; i < arrStr.length; i++) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
		}
	} else if (opt == 1) {
		cmbObj.InsertItem(0, "", "");
		for ( var i = 0; i < arrStr.length; i++) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i + 1, arrCode[txtCol], arrCode[codeCol]);
		}
	}

	cmbObj.Index2 = "";
}

/** 
 * Combo Object 에 값을 추가하는 처리 <br>
 * @param  {object} cmbObj	필수 Combo Object
 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
 * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
 * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
 * @return 없음
 * @author 김창식
 * @version 2009.09.22
 */
function MakeComboObjectAll(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "ALL|ALL", "ALL");
	for ( var i = 0; i < arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		//cmbObj.InsertItem(i + 1, arrCode[txtCol], arrCode[codeCol]);
		cmbObj.InsertItem(i + 1, arrStr[i], arrCode[codeCol]);
	}
	
	
	//cmbObj.Index2 = "" ;
}

function MakeComboObject2(cmbObj, arrStr, col) {
	cmbObj.RemoveAll();

	for ( var i = 0; i < arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i, arrStr[i], arrCode[col]);
	}
	cmbObj.Index2 = "";
}
/** 
 * 기본조건 입력 후 ENTER키 적용 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.14
 */
function enterFire() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if (event.keyCode == 13) {
		if (validateForm(sheetObj, formObj, IBSEARCH)) {
			ComKeyEnter('search');
		}
	}

}
 
 /**
  * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
  * @author 조재성
  * @version 2009.07.28
  */      
 function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH)
 {
	 var formObj = document.form;
	 if(sheetObj.cellValue(Row,"pay_inv_seq") != null 
			 && sheetObj.cellValue(Row,"pay_inv_seq") != '')
	 {
		 formObj.pay_inv_seq.value = sheetObj.cellValue(Row,"pay_inv_seq"); 
		 doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	 }
  
 }    
  
  /** 
   * period_type 의 change 이벤트에 대한 처리  <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.08.24
   */
  function period_type_change(){
  	var formObj = document.form;
	
  	formObj.inv_fm_date.value = "";
  	formObj.inv_to_date.value = "";
  	
    if(formObj.cost_yrmon.Code == "cost_month")
  	{
  		formObj.inv_fm_date.dataformat="ym";
  		formObj.inv_to_date.dataformat="ym";
  		formObj.inv_fm_date.maxlength="6";
  		formObj.inv_to_date.maxlength="6";
  	}else 
  	{
  		//issue_date
  		//receive_date
  		//confirm_date
  		//payment_date
  		formObj.inv_fm_date.dataformat="ymd";
  		formObj.inv_to_date.dataformat="ymd";
  		formObj.inv_fm_date.maxlength="8";
  		formObj.inv_to_date.maxlength="8";
  	}
  	
  }    
/* 개발자 작업  끝 */