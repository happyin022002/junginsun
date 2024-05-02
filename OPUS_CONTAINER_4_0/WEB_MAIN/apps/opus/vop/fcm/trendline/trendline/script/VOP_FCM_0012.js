/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0012.js
 *@FileTitle : Fuel Consumption Trend line M_Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.02.14 진마리아 [CHM-201216243-01] Cargo Weight 컬럼 추가
 * 2012.03.08 진마리아 [선처리] Displacement 컬럼 추가
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
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
 * @class VOP_FCM_0012 : VOP_FCM_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0012() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var chartObjects = new Array();
var chartCnt = 0;

var inqflg="";
var visibleChtNo=0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[1];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			
			case "btn_Retrieve":
				if(formObj.trnd_line_no.value==""){
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
				}else{
					doActionIBSheet(sheetObject, formObj, SEARCH04);//기존재하는 trnd line 조회 //raw data는 조회하나? 안하나?
				}
				break;
	
			case "btn_Simulation":
//				setOptRt(sheetObject, formObj);
				doActionIBSheet(sheetObject, formObj, SEARCH02);
				break;
				
			case "btn_New":
				clearAll("new");
				break;
				
			case "btn_Save":
				if(formObj.trnd_line_no.value==""){
					doActionIBSheet(sheetObject, formObj, IBSAVE);
				}else{
					doActionIBSheet(sheetObject, formObj, MULTI01);
				}
				break;
				
			case "btns_Calendar1" :		// From Date
				var cal = new ComCalendar();
				cal.select(formObj.trnd_line_fm_dt, 'yyyy-MM-dd');
				break;
	
			case "btns_Calendar2" :		// To Date
				var cal = new ComCalendar();
				cal.select(formObj.trnd_line_to_dt, 'yyyy-MM-dd');
				break;
				
			case "cht_tp_cd":
				var chtFlg = ""; //보여지고 있는 chart는 다시 선택하여도 chart를 그리지 않도록 한다.
				for(var i=0; i<formObj.cht_tp_cd.length; i++){
					if(formObj.cht_tp_cd[i].checked){
						chtFlg = i;
					}
				}
				if(chtFlg != visibleChtNo){
					visibleChtNo = chtFlg;
//					clearChart(chartObjects);
					printOneChart();
					setRsltSheet(sheetObjects[0]);
				}
				break;
				
			case "btn_trnd_line_no":
				if(formObj.trnd_line_tp_cd.value!=""){
					ComOpenPopup('/opuscntr/VOP_FCM_0014.do?trndLineTpCd='+formObj.trnd_line_tp_cd.value, 950, 650, 'setTrndLineNo', '0,0', true, false);
				}
				break;
				
			case "btn_Delete":
				doActionIBSheet(sheetObject, formObj, IBDELETE);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 
function setChartObject(chart_obj){
	chartObjects[chartCnt++] = chart_obj;
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
    for(k=0;k<chartObjects.length;k++){
        initChart(chartObjects[k],k+1);
    }
    
	 chartObjects[0].Title.Caption = "C.Spd vs A.Spd - C.Spd(Red) / A.Spd(Blue)";
	 chartObjects[1].Title.Caption = "C.Spd vs M/E FOC";
	 chartObjects[2].Title.Caption = "A.Spd vs M/E FOC";
	 chartObjects[3].Title.Caption = "C.Spd vs RPM";
	 chartObjects[4].Title.Caption = "RPM vs M/E FOC";
	 chartObjects[5].Title.Caption = "LOAD vs M/E FOC";
	 chartObjects[6].Title.Caption = "C.Spd vs LOAD";
	 
	for(var i=0; i<chartObjects.length; i++){
		// 머리글의 색상 및 문자 정렬 방식을 지정한다.
		 chartObjects[i].Title.ForeColor = '#ddffdd';
		 chartObjects[i].Title.BackColor = '#506acc';
		 chartObjects[i].Title.TextAlign = ibcTextAlignLeft;
		  // 머리글의 글꼴을 설정한다.
		 chartObjects[i].Title.Font.Name = '굴림';
		 chartObjects[i].Title.Font.Size = 10;
		 chartObjects[i].Title.Font.Bold = true;
		  // 머리글의 위치를 지정한다.
		 chartObjects[i].Title.Location.Left.Auto = true;
		 chartObjects[i].Title.Location.Top.Auto = true;
		  // 머리글의 테두리를 설정한다.
		 chartObjects[i].Title.Frame.Style = ibcFrameStyle3DOut;
		 chartObjects[i].Title.Frame.Width = 2;
		 
//		 if(i==1){
//			 chartObjects[i].Chart(ibcChartPrimary);//.Series('s01');//.Label = '고가';
//			 chartObjects[i].Chart(ibcChartSecondary);//.Series('s02');//.Label = '고가';
//		 }
		 
	}

    
	initControl();
	formObj.trnd_line_fm_dt.value = ComGetDateAdd(null, "M", -3);
	formObj.trnd_line_to_dt.value = ComGetNowInfo();
	formObj.vsl_clss_cd.Enable = false;
	formObj.vsl_slan_cd.Enable = false;
	formObj.vsl_cd.Enable = false;
	formObj.skd_dir_cd.Enable = false;
	formObj.vsl_clss_sub_cd.Enable = false;
	ComBtnDisable("btn_Simulation");
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Delete");
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;
	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm  ('click', 'obj_click', form);
}

//function obj_activate() {
//	if (event.srcElement.options) {
//		event.srcElement.focus();
//	} else {
//		event.srcElement.select();
//	}
//}

/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
*/ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	switch(comboObj.id) {  
		case "vsl_clss_cd":
			with (comboObj) {
				MultiSelect = false; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
//				MaxLength = 10;
				ColWidth = 50;
			}
		break;
			
		case "vsl_clss_sub_cd":
			with (comboObj) {
				MultiSelect = false; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
//				MaxLength = 10;
				ColWidth = 50;
			}
		break;

		case "vsl_slan_cd": 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
				MaxLength = 3;
			}
		break; 	
	
		case "vsl_cd":
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				MaxLength = 4;
			}
		break; 	
		
		case "skd_dir_cd":
			with (comboObj) {
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				MaxLength = 4;
			}
	 	break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";

	switch (sheetNo) {
	
	
	case 1:
		with (sheetObj) {
		tabIndex = -1;
		
		// 높이 설정
		style.height = 50;
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
		InitRowInfo(1, 1, 3, 100);
		
		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false)
		
//		var HeadTitle1 = "|CHT TP|coef1|coef2|coef3|Daily Consumption|Daily Consumption|Speed Limit|Speed Limit|Slip(Option)|Formula";
//		var HeadTitle2 = "|CHT TP|coef1|coef2|coef3|GE|BLR|MAX|MIN|Slip(Option)|Formula";
		var HeadTitle = "|CHT TP|coef1|coef2|coef3|GE|BLR|MAX|MIN|Slip\n(Adjusted)|Avg.Slip|Formula|R";

		var headCount = ComCountHeadTitle(HeadTitle);
		
		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);
		
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);
		
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,  false,   	prefix+"ibflag");
		InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		prefix+"trnd_line_cht_tp_cd",	false,		"",			dfNone,		0,			false,		false);
		InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,		prefix+"n1st_coef_val",		false,		"",			dfNone,		0,			false,		false);
		InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,		prefix+"n2nd_coef_val",		false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,		prefix+"trnd_line_cons_val",			false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		prefix+"avg_gnr_csm_wgt",	false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		prefix+"avg_blr_csm_wgt",	false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		prefix+"op_max_spd",		false,		"",			dfFloat,	1,			true,		false, 3);	
		InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		prefix+"op_min_spd",		false,		"",			dfFloat,	1,			true,		false, 3);	
		InitDataProperty(0, cnt++ , dtData,				90,		daRight,	true,		prefix+"aply_slp_rt",		false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtHidden,			90,		daRight,	true,		prefix+"avg_slp_rt",		false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtData,				400,	daLeft,		true,		prefix+"foml_desc",			false,		"",			dfNone,		0,			false,		false);	
		InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		prefix+"coef_of_dtmn_val",	false,		"",			dfNone,		0,			false,		false);	
		
		CountPosition = 0;
		SelectHighLight = false;
		}
	break;
	
	case 2:
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 440;
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
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			var HeadTitle1 = "||Delete|VVD|CAPA|Lane|ETA\nPort|Reported Date|Wind\nScale|Sea\nScale|sailed\nTime|OBS\nMiles|ENG\nMiles|Cargo|Cargo|DIS.|Speed|RPM|Slip|Load|M/E\nF.O|G/E\nF.O|BLR\nF.O|24ME\nFOC|24GE\nFOC|24BLR\nFOC|Total\nEnergy|Slip\n(Adjusted)|Calculated\nSpeed|vsl_cd|skd_voy_no|skd_dir_cd|incl_flg|max_spd|Avg.\nslip|option";
			var HeadTitle2 = "||Delete|VVD|CAPA|Lane|ETA\nPort|Reported Date|Wind\nScale|Sea\nScale|sailed\nTime|OBS\nMiles|ENG\nMiles|TEU|Tons|DIS.|Speed|RPM|Slip|Load|M/E\nF.O|G/E\nF.O|BLR\nF.O|24ME\nFOC|24GE\nFOC|24BLR\nFOC|Total\nEnergy|Slip\n(Adjusted)|Calculated\nSpeed|vsl_cd|skd_voy_no|skd_dir_cd|incl_flg|max_spd|Avg.\nslip|option";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			sheetObj.FrozenCols = 4;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,  false,   	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,		prefix+"org_trnd_line_xcld_flg",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix+"trnd_line_xcld_flg",			false,		"",			dfNone,		0,			true,		false);
			InitDataProperty(0, cnt++ , dtData,				75,		daCenter,	true,		prefix+"vvd",				false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"vsl_clss_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		prefix+"vsl_slan_cd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"nxt_port_cd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"noon_rpt_dt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"wnd_scl_no",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"sea_ste_no",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"sail_hrmnt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"nvgt_ml_dist",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"eng_ml_dist",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"ttl_cntr_obrd_teu",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"dep_cgo_wgt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"dep_dpl_wgt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"sail_avg_spd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"sail_avg_rpm_pwr",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"slp_rt",			false,		"",			dfNone,		0,			false,		false);
//			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"lod_ind_qty",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daLeft,	true,		prefix+"load",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"mn_foil_csm_qty",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"gnr_foil_csm_qty",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"blr_foil_csm_qty",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		prefix+"day_mn_foil_csm_qty",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		prefix+"day_gnr_foil_csm_qty",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		prefix+"day_blr_foil_csm_qty",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"mn_pwr",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				65,		daRight,	true,		prefix+"aply_slp_rt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				65,		daLeft,		true,		prefix+"calc_spd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"vsl_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"skd_voy_no",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		prefix+"skd_dir_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,		prefix+"incl_flg",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,		prefix+"max_spd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,		prefix+"avg_slp_rt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,		prefix+"avg_slp_opt_rt",		false,		"",			dfNone,		0,			false,		false);
			
			InitDataCombo(0, prefix+"trnd_line_xcld_flg", "Y|N", "Y|N");
//			CountPosition = 0;
			
//			sheetObj.SelectBackColor = sheetObj.RgbColor(255,051,204)
			SelectHighlight=false;
			EditableColorDiff=true; 

		}
		break;


		
	}
}

 /**
  * Chart 기본 설정
  * Chart의 항목을 설정한다.
  */
 function initChart(chartObj , chartNo) {
 	
 	var chart = chartObj.Chart(ibcChartPrimary);
 	var subchart = chartObj.Chart(ibcChartSecondary);
 	var points = null;
 	
 	chartObj.AutoRedraw = false;
 	chartObj.Plot.PlotArea.Boxline = false;
 	
 	// 차트 Y축 설정
 	chartObj.Plot.Axis(ibcAxisY).Min = 0;
 	chartObj.Plot.Axis(ibcAxisY).Max = 200;
 	
 	// 차트 Y축 설정
 	chartObj.Plot.Axis(ibcAxisY2).Min = 0;
 	chartObj.Plot.Axis(ibcAxisY2).Max = 200;
 	
 	// 차트 X축 설정
 	chartObj.Plot.Axis(ibcAxisX).Min = 0;
 	chartObj.Plot.Axis(ibcAxisX).Max = 26;
 	
 	// 모눈 설정
 	chartObj.Plot.Axis(ibcAxisX).Grid.Interval.Auto = false;
 	chartObj.Plot.Axis(ibcAxisY).Grid.Interval.Auto = false;
 	
 	chartObj.Plot.Axis(ibcAxisX).Grid.Interval = 1;
 	chartObj.Plot.Axis(ibcAxisY).Grid.Interval = 10;
 	
 	// X축 레이블.
 	chartObj.Plot.Axis(ibcAxisX).Annotation.AnnonateType = ibcAnnotationTypeValues;
 	
 	// Y축 레이블.
 	chartObj.Plot.Axis(ibcAxisY).Annotation.AnnonateType = ibcAnnotationTypeValues;

 	// 꺾은선 차트로 설정한다.
 	chart.ChartType = ibcType2dPlot;
 	subchart.ChartType = ibcType2dPlot;
 	
 }
 
function printChart(chartObj, chartNo){
	if(chartNo==1){
		printChartTwoLine(chartObj, chartNo);
		printChartOneLine(chartObjects[1], chartNo);
		//printChartTwoLine(chartObj, chartNo+1);
		
	}else{
 		printChartOneLine(chartObj, chartNo);
	}
}

 function printOneChart(){
	 var formObj = document.form;
	 clearChart(chartObjects);
	 // all chart closed
	 for(var i=0; i<chartObjects.length; i++){
		 chartObjects[i].style.height = 0;
	 }
	 
	 for(var i=0; i<formObj.cht_tp_cd.length; i++){
		 if(formObj.cht_tp_cd[i].checked){
			 if(i==0){
				 printChart(chartObjects[i], i+1);
			 }else{
				 i = i+1;
				 printChart(chartObjects[i], i+1);
			 }
	 
			 break;
		 }
	 }
 }
 
function printChartTwoLine(chartObj, chartNo){
	var sheetObjTrendLine = sheetObjects[0];
	var sheetObj = sheetObjects[1];
	
	if(sheetObj.RowCount==0){
		return false;
	}
	
	chartObj.style.height=390;
	chartObj.AutoRedraw = false;
	var chart = chartObj.Chart(ibcChartPrimary);
	var subchart = chartObj.Chart(ibcChartSecondary);
	var points = null;
	
	var x2Coef = null;
	var xCoef = null;
	var consts = null;
	
	chart.Series.Add('s01');
	subchart.Series.Add('s02');

	// 시리즈들의 심벌을 숨기고 Line을 설정한다.
	chart.Series('s01').Style.Line.Pattern = ibcLineSolid;
	chart.Series('s01').Style.Line.Width = 2;
	chart.Series('s01').Style.Line.Color = '#FF0000';
	chart.Series('s01').Style.Symbol.Size = 0;
	
	// 시리즈들의 심벌을 숨기고 Line을 설정한다.
	subchart.Series('s02').Style.Line.Pattern = ibcLineSolid;
	subchart.Series('s02').Style.Line.Width = 2;
	subchart.Series('s02').Style.Line.Color = '#0000FF';
	subchart.Series('s02').Style.Symbol.Size = 0;

	// find maxX, maxY
	
	var x;
	var y;
	var maxX=Number.MIN_VALUE;
	var minX=Number.MAX_VALUE;
	var maxY=Number(0);
	var minY=Number(0);
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		if(sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg")=="N"){
			x = sheetObj.CellValue(i, "sheet2_calc_spd");
			y = sheetObj.CellValue(i, "sheet2_day_mn_foil_csm_qty");
 			
 			if(x && y){
 				if(Number(x) > maxX){
 					maxX = Number(x);
 				}
 				if(Number(x) < minX){
 					minX = Number(x);
 				}
 			}
		}
	}
	
	//////////////////////// S01
	
	x2Coef = getCoefficient(sheetObjTrendLine,
			 chartNo,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObjTrendLine,
			chartNo,
			1); //1차식
	
	consts = getCoefficient(sheetObjTrendLine,
			 chartNo,
			 0); //상수
	
	points = chart.Series('S01').Point;
	
	// 데이터 포인트를 추가한다.
	if(x2Coef==0 && xCoef==0 && consts==0){
		points.Add(-1, -1);
	}else{
		for(var i=minX; i<=maxX; i=i+0.1){
			x = i;
			y = Number((x2Coef*x*x) + (xCoef*x) + consts);
			if(y < minY){
				minY = y;
			}
			if(y > maxY){
				maxY = y;
			}
			points.Add(y, x);
		}
	}
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY).Min = (minY-20>0)?minY-20:0;
	chartObj.Plot.Axis(ibcAxisY).Max = maxY+20;
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY2).Min = (minY-20>0)?minY-20:0;
	chartObj.Plot.Axis(ibcAxisY2).Max = maxY+20;
	
	// 차트 X축 설정
	chartObj.Plot.Axis(ibcAxisX).Min = (minX-10>0)?minX-10:0;
	chartObj.Plot.Axis(ibcAxisX).Max = maxX+10;
	
//	chartObj.AutoRedraw = true;
 	points = null;
	
	//////////////////////// S02
	
	x2Coef = getCoefficient(sheetObjTrendLine,
			 chartNo+1,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObjTrendLine,
			chartNo+1,
			1); //1차식
	
	consts = getCoefficient(sheetObjTrendLine,
			 chartNo+1,
			 0); //상수

	points = subchart.Series('s02').Point;
	
	// 데이터 포인트를 추가한다.
	if(x2Coef==0 && xCoef==0 && consts==0){
		points.Add(-1, -1);
	}else{
		for(var i=minX; i<=maxX; i=i+0.1){
			x = i;
			y = Number((x2Coef*x*x) + (xCoef*x) + consts);
			if(y < minY){
				minY = y;
			}
			if(y > maxY){
				maxY = y;
			}
			points.Add(y, x);
		}
	}
	
//	// 차트 Y축 설정
//	chartObj.Plot.Axis(ibcAxisY).Min = (minY-20>0)?minY-20:0;
//	chartObj.Plot.Axis(ibcAxisY).Max = maxY+20;
//	
//	// 차트 Y축 설정
//	chartObj.Plot.Axis(ibcAxisY2).Min = (minY-20>0)?minY-20:0;
//	chartObj.Plot.Axis(ibcAxisY2).Max = maxY+20;
//	
//	// 차트 X축 설정
//	chartObj.Plot.Axis(ibcAxisX).Min = (minX-10>0)?minX-10:0;
//	chartObj.Plot.Axis(ibcAxisX).Max = maxX+10;
	
	chartObj.AutoRedraw = true;
// 	points = null;
}
 
function printChartOneLine(chartObj, chartNo){
	var sheetObjTrendLine = sheetObjects[0];
	var sheetObj = sheetObjects[1];
	
	if(sheetObj.RowCount==0){
		return false;
	}
	
	chartObj.style.height=390;
	chartObj.AutoRedraw = false;
	var chart = chartObj.Chart(ibcChartPrimary);
	var subchart = chartObj.Chart(ibcChartSecondary);
	var points = null;
	
	var x2Coef = null;
	var xCoef = null;
	var consts = null;
	
	chart.Series.Add('s01');
	subchart.Series.Add('s02');

	// 시리즈들의 괘선을 숨기고 심벌을 설정한다.
	chart.Series('s01').Style.Line.Pattern = ibcLineNone;
	chart.Series('s01').Style.Symbol.Color = '#00ff00';
	chart.Series('s01').Style.Symbol.SymbolType = ibcSymbolDot;
	chart.Series('s01').Style.Symbol.Size = 3;
	
	// 시리즈들의 심벌을 숨기고 Line을 설정한다.
	subchart.Series('s02').Style.Line.Pattern = ibcLineSolid;
	subchart.Series('s02').Style.Line.Width = 3;
	subchart.Series('s02').Style.Line.Color = '#CE44CE';
	subchart.Series('s02').Style.Symbol.Size = 0;

	//////////////////////// S01
	
	points = chart.Series('S01').Point;
	
	var x;
	var y;
	var maxX=Number.MIN_VALUE;
	var minX=Number.MAX_VALUE;
	var maxY=Number(0);
	var minY=Number(0);
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		if(sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg")=="N"){
 			if(chartNo==1){
 				x = sheetObj.CellValue(i, "sheet2_calc_spd");
 				y = sheetObj.CellValue(i, "sheet2_day_mn_foil_csm_qty");
 			}else if(chartNo==3){
 				x = sheetObj.CellValue(i, "sheet2_sail_avg_spd");
 				y = sheetObj.CellValue(i, "sheet2_day_mn_foil_csm_qty");
 			}else if(chartNo==4){
 				x = sheetObj.CellValue(i, "sheet2_calc_spd");
 				y = sheetObj.CellValue(i, "sheet2_sail_avg_rpm_pwr");
 			}else if(chartNo==5){
 				x = sheetObj.CellValue(i, "sheet2_sail_avg_rpm_pwr");
 				y = sheetObj.CellValue(i, "sheet2_day_mn_foil_csm_qty");
 			}else if(chartNo==6){
// 				x = sheetObj.CellValue(i, "sheet2_lod_ind_qty");
 				x = sheetObj.CellValue(i, "sheet2_load");
 				y = sheetObj.CellValue(i, "sheet2_day_mn_foil_csm_qty");
 			}else if(chartNo==7){
 				x = sheetObj.CellValue(i, "sheet2_calc_spd");
// 				y = sheetObj.CellValue(i, "sheet2_lod_ind_qty");
 				y = sheetObj.CellValue(i, "sheet2_load");
 			}
 			
 			if(x && y){
 					
 				if(Number(x) > maxX){
 					maxX = Number(x);
 				}
 				if(Number(x) < minX){
 					minX = Number(x);
 				}
 					
 				points.Add(Number(y), Number(x));
 			}
		}
	}
	
	//////////////////////// S02
	
	if(chartNo==3){
		chartNo = 2;
	}else if(chartNo==4){
		chartNo = 3;
	}else if(chartNo==5){
		chartNo = 4;
	}else if(chartNo==6){
		chartNo = 5;
	}else if(chartNo==7){
		chartNo = 6;
	}
	
	x2Coef = getCoefficient(sheetObjTrendLine,
			 chartNo,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObjTrendLine,
			chartNo,
			1); //1차식
	
	consts = getCoefficient(sheetObjTrendLine,
			 chartNo,
			 0); //상수

	points = subchart.Series('s02').Point;
	
	// 데이터 포인트를 추가한다.
	if(x2Coef==0 && xCoef==0 && consts==0){
		points.Add(-1, -1);
	}else{
		for(var i=minX; i<=maxX; i=i+0.1){
			x = i;
			y = Number((x2Coef*x*x) + (xCoef*x) + consts);
			if(y < minY){
				minY = y;
			}
			if(y > maxY){
				maxY = y;
			}
			points.Add(y, x);
		}
	}
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY).Min = (minY-20>0)?minY-20:0;
	chartObj.Plot.Axis(ibcAxisY).Max = maxY+20;
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY2).Min = (minY-20>0)?minY-20:0;
	chartObj.Plot.Axis(ibcAxisY2).Max = maxY+20;
	
	// 차트 X축 설정
	chartObj.Plot.Axis(ibcAxisX).Min = (minX-10>0)?minX-10:0;
	chartObj.Plot.Axis(ibcAxisX).Max = maxX+10;
	
	chartObj.AutoRedraw = true;
// 	points = null;
}

 function getCoefficient(sheetObj, row, degree){
 	var coefficient = 0;
 	var saveName = "";
 	if(degree==2){
 		saveName = "n1st_coef_val";
 	}else if(degree==1){
 		saveName = "n2nd_coef_val";
 	}else if(degree==0){
 		saveName = "trnd_line_cons_val";
 	}
 	if(sheetObj.SearchRows>0){
 		coefficient = Number(sheetObj.CellValue(row, "sheet1_"+saveName));
 	}
 	return coefficient;
 }
 
 function clearChart(charts){
 	var chartObj = null;
 	for(var k=0;k<charts.length;k++){
 		chartObj = charts[k];
 		chartObj.style.height=0;
 		chartObj.AutoRedraw = false;
 		var points = chartObj.Chart(ibcChartPrimary).Series.RemoveAll();
 		var points = chartObj.Chart(ibcChartSecondary).Series.RemoveAll();
 		chartObj.AutoRedraw = true;
 	}
 }
 
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			// 기존 차트 내용 초기화
//	        clearChart(chartObjects);
	        
			formObj.f_cmd.value = SEARCH;
			var aryPrefix = new Array( "sheet1_", "sheet2_");
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0012GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			var arrXml = sXml.split("|$$|");
			inqflg="inquiry";
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			if(sheetObjects[1].SearchRows>0){
		 		var count=0;
		 		for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].HeaderRows+sheetObj.RowCount; i++){
		 			if(sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg")=="N"){
		 				count++;
		 			}
		 		}
		 		if(count<3){
		 			ComShowMessage("데이터 적어서 추세선 못구함");
		 			clearChart(chartObjects);
		 			return false;
		 		}else{
		 			printOneChart();
		 		}
			}else{
				clearChart(chartObjects);
			}
			parent.syncHeight();
		}
		break;
		
	case SEARCH01: // 기간에 해당하는 Lane, Vessel, Design Cap., Bound 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0012GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			setCombo(formObj, sXml);
		}
		break;
	
	case SEARCH02: // delt flg 변경 후 Simulation
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH02;
			var aryPrefix = new Array( "sheet1_", "sheet2_");
			ComOpenWait(true);
			setOptRt(sheetObj, formObj);
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0012GS.do", "f_cmd="+SEARCH02+"&"+ComGetSaveString(sheetObj, true, true)+"&"+ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			var arrXml = sXml.split("|$$|");
			inqflg="simulation";
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			ComBtnEnable("btn_Save");
//			clearChart(chartObjects);
			//simulation 후에는 sheet2를 재조회 하지 않으므로, org_trnd_line_xcld_flg를 trnd_line_xcld_flg로 바꿔준다.
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				sheetObj.CellValue2(i, "sheet2_org_trnd_line_xcld_flg")=sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg");
//				sheetObj.RowStatus(i)="R";
			}
			if(sheetObjects[1].RowCount>0){
		 		var count=0;
		 		for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].HeaderRows+sheetObj.RowCount; i++){
		 			if(sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg")=="N"){
		 				count++;
		 			}
		 		}
		 		if(count<3){
		 			ComShowMessage("데이터 적어서 추세선 못구함");
		 			clearChart(chartObjects);
		 			return false;
		 		}else{
		 			printOneChart();
		 		}
			}else{
				clearChart(chartObjects);
			}
			parent.syncHeight();
		}
		break;
		
	case SEARCH04: //기생성된 trnd line 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			// 기존 차트 내용 초기화
//	        clearChart(chartObjects);
	        
			formObj.f_cmd.value = SEARCH04;
			var aryPrefix = new Array( "sheet1_", "sheet2_");
			var vslSlanCd="";
			var skdDirCd="";
			if(formObj.vsl_slan_cd_i.value=="ALL"){
				vslSlanCd="A";
			}else{
				vslSlanCd=formObj.vsl_slan_cd_i.value;
			}
			if(formObj.skd_dir_cd_i.value=="ALL"){
				skdDirCd="A";
			}else{
				skdDirCd=formObj.skd_dir_cd_i.value;
			}
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			sParam = sParam + "&vsl_slan_cd_all="+vslSlanCd+"&skd_dir_cd_all="+skdDirCd;
	
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0012GS.do", sParam);
			ComOpenWait(false);
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			
			if(sheetObjects[1].SearchRows>0){
				var trndLineRmk = ComGetEtcData(sXml, "trnd_line_rmk");
				if(trndLineRmk){
					formObj.trnd_line_rmk.value = trndLineRmk;
				}
				
				ComBtnEnable("btn_Delete");
				
				printOneChart();
			}else{
				clearChart(chartObjects);
			}
			parent.syncHeight();
		}
		break;

	case IBSAVE:        //TRND LINE 생성
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			var aryPrefix 	= new Array( "sheet1_", "sheet2_"); 
			var sParam = ComGetSaveString(sheetObjects[1], true, true); // raw data - 전부 다 가져가서 trnd_line_xcld_flg가 Y인 data만 골라서 insert.
			sParam = sParam + "&" + ComGetSaveString(sheetObjects[0], true, true); // trnd line info
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSaveXml("VOP_FCM_0012GS.do", sParam);
			ComOpenWait(false);
			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
				sheetObjects[1].LoadSaveXml(sXml);
//				ComShowCodeMessage("COM130102", "Data");
				setColorBack(sheetObj, "ALL");
				ComShowMessage("Trnd Line["+ComGetEtcData(sXml, "trnd_line_no")+"] is created.");
//				clearAll("save");
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.avg_slp_rt.value="";
				formObj.avg_slp_opt_rt.value="";
				formObj.trnd_line_rmk.value="";
				formObj.trnd_line_tp_sub_cd.value="";
				formObj.vsl_clss_cd_i.value="";
				formObj.vsl_clss_sub_cd_i.value="";
				formObj.vsl_slan_cd_i.value="";
				formObj.vsl_cd_i.value="";
				formObj.skd_dir_cd_i.value="";
				clearChart(chartObjects);
				parent.syncHeight();
			}
		}
	break;
	
	case MULTI01:        //기존재하는 TRND LINE의 저장(UPDATE)
		if (validateForm(sheetObj, formObj, sAction)) {
			if(ComShowCodeConfirm("COM130501", "Trnd Line ["+formObj.trnd_line_no.value+"]")){
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				var aryPrefix 	= new Array( "sheet1_", "sheet2_"); 
				var vslSlanCd="";
				var skdDirCd="";
				if(formObj.vsl_slan_cd_i.value=="ALL"){
					vslSlanCd="A";
				}else{
					vslSlanCd=formObj.vsl_slan_cd_i.value;
				}
				if(formObj.skd_dir_cd_i.value=="ALL"){
					skdDirCd="A";
				}else{
					skdDirCd=formObj.skd_dir_cd_i.value;
				}
				var sParam = ComGetSaveString(sheetObjects[1], true, true); // raw data
				sParam = sParam + "&" + ComGetSaveString(sheetObjects[0], true, true); // trnd line info
				sParam = sParam + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
				sParam = sParam + "&vsl_slan_cd_all="+vslSlanCd+"&skd_dir_cd_all="+skdDirCd;
				var sXml = sheetObjects[1].GetSaveXml("VOP_FCM_0012GS.do", sParam);
				ComOpenWait(false);
				if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
					sheetObjects[1].LoadSaveXml(sXml);
					ComShowCodeMessage("COM130102", "Data");
					setColorBack(sheetObj, "ALL");
				}
			}
		}
	break;
	
	case IBDELETE: //기존재하는 TRND LINE 삭제
		if (validateForm(sheetObj, formObj, sAction)) {
			if(ComShowCodeConfirm("COM12165", "Trnd Line ["+formObj.trnd_line_no.value+"]")){
				ComOpenWait(true);
				formObj.f_cmd.value = REMOVE;
				var vslSlanCd="";
				var skdDirCd="";
				if(formObj.vsl_slan_cd_i.value=="ALL"){
					vslSlanCd="A";
				}else{
					vslSlanCd=formObj.vsl_slan_cd_i.value;
				}
				if(formObj.skd_dir_cd_i.value=="ALL"){
					skdDirCd="A";
				}else{
					skdDirCd=formObj.skd_dir_cd_i.value;
				}
				var sParam = FormQueryString(formObj) + "&vsl_slan_cd_all="+vslSlanCd+"&skd_dir_cd_all="+skdDirCd;
				var sXml = sheetObj.GetSaveXml("VOP_FCM_0012GS.do", sParam);
				ComOpenWait(false);
				sheetObj.LoadSaveXml(sXml);
				if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
					ComShowCodeMessage("COM130303", "Data");
					clearAll("new");
				}
			}
		}
	break;
	
	}
}

/*
 * 조회 후처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var prefix="sheet1_";
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		var x2=sheetObj.CellValue(i, prefix+"n1st_coef_val");
		var x=sheetObj.CellValue(i, prefix+"n2nd_coef_val");
		var c=sheetObj.CellValue(i, prefix+"trnd_line_cons_val");
		var v=sheetObj.CellValue(i, prefix+"coef_of_dtmn_val");
		if(x>= 0){
			x="+"+x;
		}
		if(c>= 0){
			c="+"+c;
		}

		if(x2=="NaN" || x=="NaN" || c=="NaN" || x2=="0.000000000000000" || x=="0.000000000000000" || c=="0.000000000000000"
			|| v=="NaN" || v=="0.000000000000000"){
			if(inqflg=="inquiry"){
				ComShowMessage("Can't Create "+i+"th Trend Line. Please Check Data.");
			}
//			ComBtnDisable("btn_Save");
//			ComBtnDisable("btn_Simulation");
//			break;
			sheetObj.CellValue2(i, prefix+"n1st_coef_val") = ""; 
			sheetObj.CellValue2(i, prefix+"n2nd_coef_val") = ""; 
			sheetObj.CellValue2(i, prefix+"trnd_line_cons_val") = "";
			sheetObj.CellValue2(i, prefix+"foml_desc") = "";
			sheetObj.CellValue2(i, prefix+"coef_of_dtmn_val") = "";
		}else{
			sheetObj.CellValue2(i, prefix+"foml_desc") = x2+" x2 "+x+" x "+c;
		}
		
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Simulation");
		
	}
	setRsltSheet(sheetObj);
	
}

 /**
 * MAX, MIN 변경시
 */
 function sheet1_OnChange(sheetObj,Row,Col,Value) {
	 var formObj = document.form;
	 
	 switch (sheetObj.ColSaveName(Col)) {
	 	case "sheet1_op_max_spd" :
 			if(Value!=""){
 				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
 					sheetObj.CellValue2(i, "sheet1_op_max_spd")=Value;
 				}
 			}
 			break;
 			
	 	case "sheet1_op_min_spd" :
 			if(Value!=""){
 				for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
 					sheetObj.CellValue2(i, "sheet1_op_min_spd")=Value;
 				}
 			}
 			break;
 	
 	}
 }
/*
* 조회 후처리
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	if(sheetObj.RowCount>0){
		formObj.avg_slp_rt.value = sheetObj.CellValue(sheetObj.HeaderRows, "sheet2_avg_slp_rt");
//		formObj.avg_slp_opt_rt.value = sheetObj.CellValue(sheetObj.HeaderRows, "sheet2_avg_slp_opt_rt");
//		ComBtnEnable("btn_Simulation");
//		ComBtnEnable("btn_Save");
		
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			sheetObj.CellValue2(i, "sheet2_org_trnd_line_xcld_flg")=sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg");
			sheetObj.RowStatus(i)="R";
		}
	}
}

/**
* Delete Flg 변경시
*/
function sheet2_OnChange(sheetObj,Row,Col,Value) {
	switch (sheetObj.ColSaveName(Col)) {
		case "sheet2_trnd_line_xcld_flg" :
			ComBtnDisable("btn_Save");
			if(sheetObj.Cellvalue(Row, Col)=="N"){
				setColorBack(sheetObj, Row);
//				sheetObj.CellBackColor(Row,"sheet2_trnd_line_xcld_flg") = sheetObj.RgbColor(255,255,255);//-1;
//				for(var i=3; i<32; i++){ //마지막 column 까지.
//					sheetObj.CellBackColor(Row, i) = sheetObj.RgbColor(239,240,243);
//				}
			}
			break;
	}
}

function setRawData(chartObj, points){
	var rawData = new Array();
	if(points){
		rawData = points.split(",");
	}
	chartObj.rawData = rawData;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	with (formObj) {
		switch(sAction) {
	 	case IBSEARCH:
	 		if(trnd_line_fm_dt.value == ''){
	 			ComShowCodeMessage('COM130403', 'Period');
   				trnd_line_fm_dt.focus();
   				return false;
   			}
   			if(trnd_line_to_dt.value == ''){
   				ComShowCodeMessage('COM130403', 'Period');
   				trnd_line_to_dt.focus();
   				return false;
   			}
   			if(trnd_line_tp_cd.value == ''){
   				ComShowCodeMessage('COM130403', 'Trend Line Type');
   				return false;
   			}
   			if(trnd_line_tp_cd.value=="1"){
	 			if(vsl_clss_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Design Capa');
	 				vsl_clss_cd.focus();
	 				return false;
	 			}else if(vsl_slan_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Lane');
	 				vsl_slan_cd.focus();
	 				return false;
	 			}
	 		}else if(trnd_line_tp_cd.value=="2"){
	 			if(vsl_clss_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Design Capa');
	 				vsl_clss_cd.focus();
	 				return false;
	 			}
	 		}else if(trnd_line_tp_cd.value=="3"){
	 			if(vsl_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Vessel');
	 				vsl_cd.focus();
	 				return false;
	 			}else if(skd_dir_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Bound');
	 				skd_dir_cd.focus();
	 				return false;
	 			}
	 		}else if(trnd_line_tp_cd.value=="4"){
	 			if(vsl_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Vessel');
	 				vsl_cd.focus();
	 				return false;
	 			}
	 		}
   			break;
   			
	 	case SEARCH01:
   			break;

	 	case SEARCH02:
	 		var count=0;
	 		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	 			if(sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg")=="N"){
	 				count++;
	 			}
	 		}
	 		if(count<3){
	 			ComShowMessage("Can't Create Trend line due to the lack of reports");
	 			return false;
	 		}
	 		break;

	 	case IBSAVE:
	 		if(trnd_line_tp_cd.value=="1"){
	 			if(vsl_clss_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Design Capa');
	 				vsl_clss_cd.focus();
	 				return false;
	 			}else if(vsl_slan_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Lane');
	 				vsl_slan_cd.focus();
	 				return false;
	 			}
	 		}else if(trnd_line_tp_cd.value=="2"){
	 			if(vsl_clss_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Design Capa');
	 				vsl_clss_cd.focus();
	 				return false;
	 			}
	 		}else if(trnd_line_tp_cd.value=="3"){
	 			if(vsl_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Vessel');
	 				vsl_cd.focus();
	 				return false;
	 			}else if(skd_dir_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Bound');
	 				skd_dir_cd.focus();
	 				return false;
	 			}
	 		}else if(trnd_line_tp_cd.value=="4"){
	 			if(vsl_cd.Code==""){
	 				ComShowCodeMessage('COM130403', 'Vessel');
	 				vsl_cd.focus();
	 				return false;
	 			}
	 		}
		}
	}
	return true;
}
 
 function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;

		window.defaultStatus = obj.dataformat;

		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "num":
				ComKeyOnlyNumber(obj);
				break;
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('upper');
				break;
			case "engdn":
//				ComKeyOnlyAlphabet('lowernum')
				ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "float":
				ComKeyOnlyNumber(obj,".-");
				break;
		}
 }
 
 function obj_change(){
		var formObj = document.form;
		obj = event.srcElement;   
		
		with(formObj){
			switch(obj.name) {

				case "trnd_line_tp_cd":
					clearAll("save");
					setEnAbleCombo(formObj);
					if(trnd_line_fm_dt.value!="" && trnd_line_to_dt.value!="" && trnd_line_tp_cd.value!=""){
						doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
					}
				break;
				
				case "avg_slp_opt_rt": //option
					if(avg_slp_opt_rt.value!=""){
						ComBtnDisable("btn_Save");
					}
				break;
				
				case "trnd_line_no":
					setDisplay();
				break;
				
			}
		}
 }
 
 /* 
  * Object 의 activate 이벤트에 대한 처리
  */
 function obj_activate(){
	 var srcName = event.srcElement.name;
		
		switch(srcName){
			case "trnd_line_fm_dt":
			case "trnd_line_to_dt":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				event.srcElement.select();
				break;
		}
 }
 
 /** 
  * Object 의 deactivate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 김창식
  * @version 2009.05.20
  */
 function obj_deactivate(){
	
	 var formObj = document.form;
	 obj = event.srcElement;      	
	 
	 with(formObj){
		 if(obj.name=="trnd_line_fm_dt" || obj.name=="trnd_line_to_dt"){
			 var fmDt = ComReplaceStr(trnd_line_fm_dt.value,"-","");
			 var toDt = ComReplaceStr(trnd_line_to_dt.value,"-","");
        	
			 switch(obj.name) {
    	    	case "trnd_line_fm_dt":	// Period From Date
    	    		if(fmDt != '' && toDt != ''){
    	    			if(fmDt > toDt){
    	    				ComShowCodeMessage('COM132002');
    	    				trnd_line_fm_dt.value='';
    	    				trnd_line_fm_dt.focus();
    	    				return;
    	    			}
    	    		}
    	    		formObj.trnd_line_fm_dt.value = ComGetMaskedValue(formObj.trnd_line_fm_dt.value, "ymd");
    	    		
    	            break;
    	            
    	    	case "trnd_line_to_dt":	// Period To Date
    	    		if(fmDt != '' && toDt != ''){
    	    			if(fmDt > toDt){
    	    				ComShowCodeMessage('COM132002');
    	    				trnd_line_to_dt.value='';
    	    				trnd_line_to_dt.focus();
    	    				return;
    	    			}
    	    		}
    	    		formObj.trnd_line_to_dt.value = ComGetMaskedValue(formObj.trnd_line_to_dt.value, "ymd");
    	           	break;	
        	}
        
			ComChkObjValid(event.srcElement);
			clearAll("save");
			setEnAbleCombo(formObj);
			if(trnd_line_fm_dt.value!="" && trnd_line_to_dt.value!="" && trnd_line_tp_cd.value!=""){
				doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
			}
		 }else if(obj.name=="avg_slp_opt_rt"){
			 if(!ComChkObjValid(event.srcElement)){
				 obj.value="";
			 }
		 }
    }
    	
} 

// function chart1_PointClick(chartObj, chartid, seriesindex, pointindex){
//	 chartPointClick(chartObj, chartid, pointindex);
// }
 function chart2_PointClick(chartObj, chartid, seriesindex, pointindex){
	 chartPointClick(chartObj, chartid, pointindex);
 }
 function chart3_PointClick(chartObj, chartid, seriesindex, pointindex){
	 chartPointClick(chartObj, chartid, pointindex);
 }
 function chart4_PointClick(chartObj, chartid, seriesindex, pointindex){
	 chartPointClick(chartObj, chartid, pointindex);
 }
 function chart5_PointClick(chartObj, chartid, seriesindex, pointindex){
	 chartPointClick(chartObj, chartid, pointindex);
 }
 function chart6_PointClick(chartObj, chartid, seriesindex, pointindex){
	 chartPointClick(chartObj, chartid, pointindex);
 }
 function chart7_PointClick(chartObj, chartid, seriesindex, pointindex){
	 chartPointClick(chartObj, chartid, pointindex);
 }
 
 function vsl_clss_cd_OnChange(){
	 var formObj = document.form;
	 if(formObj.vsl_slan_cd.Code=="" || formObj.vsl_clss_sub_cd.Code==""){
		 if(formObj.vsl_slan_cd.Code==""){
			 formObj.vsl_slan_cd.RemoveAll();
		 }
		 if(formObj.vsl_clss_sub_cd.Code==""){
			 formObj.vsl_clss_sub_cd.RemoveAll();
		 }
		 doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	 }
 }
 
 function vsl_clss_sub_cd_OnChange(){
	 var formObj = document.form;
	 if(formObj.vsl_slan_cd.Code=="" || formObj.vsl_clss_cd.Code==""){
		 if(formObj.vsl_slan_cd.Code==""){
			 formObj.vsl_slan_cd.RemoveAll();
		 }
		 if(formObj.vsl_clss_cd.Code==""){
			 formObj.vsl_clss_cd.RemoveAll();
		 }
		 doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	 }
 }
 
 function vsl_slan_cd_OnChange(){
	 var formObj = document.form;
	 if(formObj.vsl_clss_cd.Code=="" || formObj.vsl_clss_sub_cd.Code==""){
		 if(formObj.vsl_clss_cd.Code==""){
			 formObj.vsl_clss_cd.RemoveAll();
		 }
		 if(formObj.vsl_clss_sub_cd.Code==""){
			 formObj.vsl_clss_sub_cd.RemoveAll();
		 }
		 doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	 }
 }
 
 function vsl_cd_OnChange(){
	 var formObj = document.form;
	 if(formObj.skd_dir_cd.Code==""){
		 if(formObj.skd_dir_cd.Code==""){
			 formObj.skd_dir_cd.RemoveAll();
		 }
		 doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	 }
 }
 
 function skd_dir_cd_OnChange(){
	 var formObj = document.form;
	 if(formObj.vsl_cd.Code==""){
		 if(formObj.vsl_cd.Code==""){
			 formObj.vsl_cd.RemoveAll();
		 }
		 doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	 }
 }
 
function setCombo(formObj, sXml) {
	var capa = ComGetEtcData(sXml, "vsl_clss_cd");
	var subClass = ComGetEtcData(sXml, "vsl_clss_sub_cd");
	var lane = ComGetEtcData(sXml, "vsl_slan_cd");
	var vsl = ComGetEtcData(sXml, "vsl_cd");
	var dirCd = ComGetEtcData(sXml, "skd_dir_cd");
	
	if(capa != null && capa != undefined && capa != ""){
		formObj.vsl_clss_cd.RemoveAll();
		var capaArr = capa.split("|");
		for (var i = 0 ; i < capaArr.length ; i++) {
			formObj.vsl_clss_cd.InsertItem(-1, capaArr[i], capaArr[i]);
		}
	}
	if(subClass != null && subClass != undefined && subClass != ""){
		formObj.vsl_clss_sub_cd.RemoveAll();
		var subClassArr = subClass.split("|");
		for (var i = 0 ; i < subClassArr.length ; i++) {
			formObj.vsl_clss_sub_cd.InsertItem(-1, subClassArr[i], subClassArr[i]);
		}
	}
	if(lane != null && lane != undefined && lane != ""){
		formObj.vsl_slan_cd.RemoveAll();
		var laneArr = lane.split("|");
		for (var i = 0 ; i < laneArr.length ; i++) {
			formObj.vsl_slan_cd.InsertItem(-1, laneArr[i], laneArr[i]);
		}
		if(laneArr.length==0){
			formObj.vsl_clss_sub_cd.Enable = false;
		}else{
			formObj.vsl_clss_sub_cd.Enable = true;
		}
	}
	if(vsl != null && vsl != undefined && vsl != ""){
		formObj.vsl_cd.RemoveAll();
		var vslArr = vsl.split("|");
		for (var i = 0 ; i < vslArr.length ; i++) {
			formObj.vsl_cd.InsertItem(-1, vslArr[i], vslArr[i]);
		}
	}
	if(dirCd != null && dirCd != undefined && dirCd != ""){
		formObj.skd_dir_cd.RemoveAll();
		var dirCdArr = dirCd.split("|");
		for (var i = 0 ; i < dirCdArr.length ; i++) {
			formObj.skd_dir_cd.InsertItem(-1, dirCdArr[i], dirCdArr[i]);
		}
	}
	
}

function setEnAbleCombo(formObj){
	if(formObj.trnd_line_fm_dt.value !="" && formObj.trnd_line_to_dt.value !="" && formObj.trnd_line_tp_cd.value !=""){
		formObj.vsl_slan_cd.RemoveAll();
		formObj.vsl_cd.RemoveAll();
		formObj.vsl_clss_cd.RemoveAll();
		formObj.vsl_clss_sub_cd.RemoveAll();
		formObj.skd_dir_cd.RemoveAll();
//		doActionIBSheet(sheetObjects[1], formObj, SEARCH01);

		if(formObj.trnd_line_tp_cd.value=="1"){
			formObj.vsl_clss_cd.Enable = true;
			formObj.vsl_clss_sub_cd.Enable = true;
			formObj.vsl_slan_cd.Enable = true;
			formObj.vsl_cd.Enable = false;
			formObj.skd_dir_cd.Enable = false;
		}else if(formObj.trnd_line_tp_cd.value=="2"){
			formObj.vsl_clss_cd.Enable = true;
			formObj.vsl_clss_sub_cd.Enable = true;
			formObj.vsl_slan_cd.RemoveAll();
			formObj.vsl_slan_cd.InsertItem(0, "ALL", "A");
			formObj.vsl_slan_cd.Index = "0";
			formObj.vsl_slan_cd.Enable = true;
			formObj.vsl_cd.Enable = false;
			formObj.skd_dir_cd.Enable = false;
		}else if(formObj.trnd_line_tp_cd.value=="3"){
			formObj.vsl_clss_cd.Enable = false;
			formObj.vsl_clss_sub_cd.Enable = false;
			formObj.vsl_slan_cd.Enable = false;
			formObj.vsl_cd.Enable = true;
//			formObj.skd_dir_cd.InsertItem(0, 'N', 'N');
//			formObj.skd_dir_cd.InsertItem(1, 'S', 'S');
//			formObj.skd_dir_cd.InsertItem(2, 'W', 'W');
//			formObj.skd_dir_cd.InsertItem(3, 'E', 'E');
			formObj.skd_dir_cd.Enable = true;
		}else if(formObj.trnd_line_tp_cd.value=="4"){
			formObj.vsl_clss_cd.Enable = false;
			formObj.vsl_clss_sub_cd.Enable = false;
			formObj.vsl_slan_cd.Enable = false;
			formObj.vsl_cd.Enable = true;
			formObj.skd_dir_cd.InsertItem(0, "ALL", "A");
			formObj.skd_dir_cd.Index = "0";
			formObj.skd_dir_cd.Enable = true;
		}
	}
}

 function clearAll(str){
	 var formObj = document.form;
	 var fmDt = formObj.trnd_line_fm_dt.value;
	 var toDt = formObj.trnd_line_to_dt.value;
	 var trndLineTpCd = formObj.trnd_line_tp_cd.value;

	 formObj.reset();
	 
	 formObj.vsl_slan_cd.RemoveAll();
	 formObj.vsl_cd.RemoveAll();
	 formObj.vsl_clss_cd.RemoveAll();
	 formObj.vsl_clss_sub_cd.RemoveAll();
	 formObj.skd_dir_cd.RemoveAll();
	 formObj.vsl_clss_cd.Enable = false;
	 formObj.vsl_slan_cd.Enable = false;
	 formObj.vsl_cd.Enable = false;
	 formObj.skd_dir_cd.Enable = false;
	 ComBtnDisable("btn_Simulation");
	 ComBtnDisable("btn_Save");
	 ComBtnDisable("btn_Delete");
	 
	 if(str=="save"){
		 formObj.trnd_line_fm_dt.value=fmDt;
		 formObj.trnd_line_to_dt.value=toDt;
		 formObj.trnd_line_tp_cd.value=trndLineTpCd;
		 setEnAbleCombo(formObj);
	 }else{
			formObj.trnd_line_fm_dt.value = ComGetDateAdd(null, "M", -3);
			formObj.trnd_line_to_dt.value = ComGetNowInfo();
	 }

	 for(var i=0; i<sheetObjects.length; i++){
		 sheetObjects[i].RemoveAll();
	 }
	 clearChart(chartObjects);
	 setDisplay();
	 parent.syncHeight();
 }

 function setRsltSheet(sheetObj){
	 var formObj = document.form;
	 for(var i=0; i<formObj.cht_tp_cd.length; i++){
		 if(formObj.cht_tp_cd[i].checked){
			 sheetObj.RowHidden(sheetObj.HeaderRows+i) = false;
		 }else{
			 sheetObj.RowHidden(sheetObj.HeaderRows+i) = true;
		 }
	 }
 }
 
 function chartPointClick(chartObj, chartid, pointindex){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[1];
	 if(chartid==1){
		 var pointRow=0;
		 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			 if(sheetObj.CellValue(i, "sheet2_org_trnd_line_xcld_flg")=="N"){
				 pointRow++;
				 if(pointRow==pointindex){
					 sheetObj.SelectCell(i, "sheet2_ibflag");
					 sheetObj.CellValue(i, "sheet2_trnd_line_xcld_flg")="Y";
					 sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,051,204);
				 }
			 }
		 }
	 }
 }
 
 function setTrndLineNo(aryPopupData, row, col, sheetIdx) {
	 var formObj = document.form;
	 if(aryPopupData!=""){
		 formObj.vsl_clss_cd_i.value="";
		 formObj.vsl_clss_sub_cd_i.value="";
		 formObj.vsl_slan_cd_i.value="";
		 formObj.vsl_cd_i.value="";
		 formObj.skd_dir_cd_i.value="";
		 
		 formObj.trnd_line_no.value=aryPopupData[0][14];
		 formObj.trnd_line_tp_sub_cd.value=aryPopupData[0][7];
		 formObj.trnd_line_use_tp_cd.value=aryPopupData[0][15];
		 if(aryPopupData[0][1]=="1" || aryPopupData[0][1]=="2"){
			 formObj.vsl_clss_cd_i.value=aryPopupData[0][3];
			 if(aryPopupData[0][4]!=""){
				 formObj.vsl_clss_sub_cd_i.value=aryPopupData[0][4];
			 }
			 formObj.vsl_slan_cd_i.value=aryPopupData[0][2];
		 }else if(aryPopupData[0][1]=="3" || aryPopupData[0][1]=="4"){
			 formObj.vsl_cd_i.value=aryPopupData[0][5];
			 formObj.skd_dir_cd_i.value=aryPopupData[0][6];
		 }
		 formObj.trnd_line_fm_dt.value=aryPopupData[0][11];
		 formObj.trnd_line_to_dt.value=aryPopupData[0][12];
		 ComChkObjValid(formObj.trnd_line_fm_dt);
		 ComChkObjValid(formObj.trnd_line_to_dt);

		 setDisplay();
	 }
 }
 
 function setDisplay(){
	 var formObj = document.form;
	 if(formObj.trnd_line_no.value!=""){
		document.getElementById("creTrndLine").style.display = "none";
		document.getElementById("inqTrndLine").style.display = "inline";
//		ComEnableObject(formObj.trnd_line_fm_dt, false);
//		ComEnableObject(formObj.trnd_line_to_dt, false);
	}else{
		document.getElementById("creTrndLine").style.display = "inline";
		document.getElementById("inqTrndLine").style.display = "none";
//		formObj.trnd_line_fm_dt.value=ComGetNowInfo();
//		formObj.trnd_line_to_dt.value=ComGetDateAdd(null, "M", 1);
//		ComEnableObject(formObj.trnd_line_fm_dt, true);
//		ComEnableObject(formObj.trnd_line_to_dt, true);
		formObj.trnd_line_fm_dt.className="input1"
		formObj.trnd_line_to_dt.className="input1"
	}
 }
 
 function setColorBack(sheetObj, Row){
	 if(Row!="ALL"){
		 sheetObj.CellBackColor(Row,"sheet2_trnd_line_xcld_flg") = sheetObj.RgbColor(255,255,255);//-1;
		 for(var i=3; i<32; i++){ //마지막 column 까지.
			 sheetObj.CellBackColor(Row, i) = sheetObj.RgbColor(239,240,243);
		 }
	 }else{
		 for(var r=sheetObj.HeaderRows; r<sheetObj.HeaderRows+sheetObj.RowCount; r++){
			 sheetObj.CellBackColor(r, "sheet2_trnd_line_xcld_flg") = sheetObj.RgbColor(255,255,255);
			 for(var i=3; i<32; i++){ //마지막 column 까지.
				 sheetObj.CellBackColor(r, i) = sheetObj.RgbColor(239,240,243);
			 }
		 }
	 }
 }
 
 function setOptRt(sheetObj, formObj){
	 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		 if(formObj.avg_slp_opt_rt.value==""){
			 sheetObj.CellValue2(i, "sheet2_avg_slp_opt_rt") = 0;
		 }else{
			 sheetObj.CellValue2(i, "sheet2_avg_slp_opt_rt") = formObj.avg_slp_opt_rt.value;
		 }
	 }
 }
 
 
/* 개발자 작업 끝 */