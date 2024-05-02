/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0055.js
 *@FileTitle : Fuel Consumption Trend Line Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.05
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2012.01.02 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.03.08 진마리아 [선처리] Displacement 컬럼 추가
 * 2012.03.22 진마리아 CHM-201216748-01 Trand Line Cration/Simulation내 Displacement 칼럼추가 요청 - Speed, RPM, Load, FOC 소수점자리 수정  
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2012.05.14 진마리아 CHM-201217542-01 Trend Line의 값을 이용한 RPM,load, Speed, FOC을 시뮬레이션 가능하도록 화면 수정
 * 2012.06.05 진마리아 CHM-201217542-01 Distance, Sea Time, (Speed, RPM, Load) 상호 계산 가능하도록 수정
 * 2014.02.13 SKY    CHM-201428645   Trend line simulation - chart 의 spot 삭제
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
 * @class VOP_FCM_0055 : VOP_FCM_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0055() {
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
var visibleChtNo=0;//현재 보여지고 있는 chart no

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObj = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
			
		case "btn_New":
			clearAll();
			break;
			
		case "btn_Simulation":
			doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
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
//				clearChart(chartObjects);
				printOneChart();
//				setRsltSheet(sheetObjects[0]);
			}
			break;
			
		case "chk_raw_data":
			showRawData();
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
        initChart(chartObjects[k],chartObjects[k].id);
    }
    
	for(var i=0; i<chartObjects.length; i++){
        if(chartObjects[i].id=="chart_line"){
        	chartObjects[i].Title.Caption = "C.Spd vs A.Spd - C.Spd(Red) / A.Spd(Blue)";
        }else if(chartObjects[i].id=="chart_cspd_mefoc" || chartObjects[i].id=="chart_cspd_mefoc_2"){
        	chartObjects[i].Title.Caption = "C.Spd vs M/E FOC";
        }else if(chartObjects[i].id=="chart_aspd_mefoc"){
        	chartObjects[i].Title.Caption = "A.Spd vs M/E FOC";
        }else if(chartObjects[i].id=="chart_cspd_rpm"){
        	chartObjects[i].Title.Caption = "C.Spd vs RPM";
        }else if(chartObjects[i].id=="chart_cspd_load"){
        	chartObjects[i].Title.Caption = "C.Spd vs LOAD";
        }else if(chartObjects[i].id=="chart_rpm_mefoc"){
        	chartObjects[i].Title.Caption = "RPM vs M/E FOC";
        }else if(chartObjects[i].id=="chart_load_mefoc"){
        	chartObjects[i].Title.Caption = "LOAD vs M/E FOC";
        }
        
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
	}

	initControl();
	showRawData();
	formObj.itm_cd_2.Enable = false;
	formObj.itm_cd_3.Enable = false;
	formObj.itm_cd_4.Enable = false;
	formObj.itm_val_1.Enable = false;
	formObj.itm_val_2.Enable = false;
	formObj.itm_val_3.Enable = false;
	formObj.itm_val_4.Enable = false;
	formObj.trnd_line_fm_dt.value = ComGetDateAdd(null, "M", -3);
	formObj.trnd_line_to_dt.value = ComGetNowInfo();
	
	sheetObjects[1].ColHidden("sheet2_calc_spd") = true; // open시 speed로 item이 선택되어 있기 때문
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
	axon_event.addListenerForm("keypress", "obj_keypress", formObj);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);

}

 /**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
 function initCombo(comboObj, comboNo) {
 	var formObj = document.form;
 	switch(comboObj.id) {  
 		case "itm_cd_1":
 		case "itm_cd_2":
 		case "itm_cd_3":
 		case "itm_cd_4":
 			with (comboObj) {
 				MultiSelect = false; 
 				UseAutoComplete = true;
 				UseCode = true;
 				DropHeight = 190;
 				ColWidth = 50;
 				InsertItem(0, 'Design Capacity', 'cntr_dzn_capa');
 		 		InsertItem(1, 'Vessel',			 'vsl_cd');
 		 		InsertItem(2, 'Lane',			 'vsl_slan_cd');
 		 		InsertItem(3, 'Bound',			 'skd_dir_cd');
 			}
 		break;
 			
 		case "itm_val_1":
 		case "itm_val_2":
 		case "itm_val_3":
 		case "itm_val_4":
 			with (comboObj) {
 				MultiSelect = false; 
 				UseAutoComplete = true;
 				UseCode = true;
 				DropHeight = 190;
 				ColWidth = 50;
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
			style.height = 150;
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
			
			var HeadTitle = "|CHT TP|Title|coef1|coef2|coef3|GE|BLR|MAX|MIN|Slip\n(Adjusted)|Avg.Slip|Formula|R";
	
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,  false,   	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		prefix+"trnd_line_cht_tp_cd",	false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,		prefix+"title",				false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,		prefix+"n1st_coef_val",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,		prefix+"n2nd_coef_val",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,		prefix+"trnd_line_cons_val",			false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix+"avg_gnr_csm_wgt",	false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix+"avg_blr_csm_wgt",	false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix+"op_max_spd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				60,		daRight,	true,		prefix+"op_min_spd",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				80,		daRight,	true,		prefix+"aply_slp_rt",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtHidden,			90,		daRight,	true,		prefix+"avg_slp_rt",		false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				230,	daLeft,		true,		prefix+"foml_desc",			false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		prefix+"coef_of_dtmn_val",	false,		"",			dfNone,		0,			false,		false);	
			
			CountPosition = 0;
			SelectHighLight = false;
		}
	break;
		
	case 2:
		with (sheetObj) {
			tabIndex = -1;
			
			// 높이 설정
			style.height = 60;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)
			
			var HeadTitle = "|Speed|RPM|Load|FOC\n(24HR)|FOC\n(Sea Time)";
			
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,  false,   	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,				58,		daRight,	true,		prefix+"calc_spd",			false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				58,		daRight,	true,		prefix+"sail_avg_rpm_pwr",	false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				58,		daRight,	true,		prefix+"load",				false,		"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				58,		daRight,	true,		prefix+"day_mn_foil_csm_qty",	false,	"",			dfNone,		0,			false,		false);	
			InitDataProperty(0, cnt++ , dtData,				65,		daRight,	true,		prefix+"day_mn_foil_csm_qty_sea_time",	false,	"",	dfNone,		0,			false,		false);	
			
			CountPosition = 0;
			SelectHighLight = false;
		}
		break;
		
	case 3:
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

			var HeadTitle1 = "||Delete|VVD|CAPA|Lane|ETA\nPort|Reported Date|Course|Wind\nScale|Wind\nScale|Sea\nScale|Sea\nScale|sailed\nTime|OBS\nMiles|ENG\nMiles|Cargo|Cargo|DIS.|Speed|RPM|Slip|Load|M/E\nF.O|G/E\nF.O|BLR\nF.O|24ME\nFOC|24GE\nFOC|24BLR\nFOC|Total\nEnergy|Slip\n(Adjusted)|Calculated\nSpeed|vsl_cd|skd_voy_no|skd_dir_cd|incl_flg|max_spd|Avg.\nslip|option|load_use_flg";
			var HeadTitle2 = "||Delete|VVD|CAPA|Lane|ETA\nPort|Reported Date|Course|DIR|SCL|DIR|SCL|sailed\nTime|OBS\nMiles|ENG\nMiles|TEU|Tons|DIS.|Speed|RPM|Slip|Load|M/E\nF.O|G/E\nF.O|BLR\nF.O|24ME\nFOC|24GE\nFOC|24BLR\nFOC|Total\nEnergy|Slip\n(Adjusted)|Calculated\nSpeed|vsl_cd|skd_voy_no|skd_dir_cd|incl_flg|max_spd|Avg.\nslip|option|load_use_flg";
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
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"crs_no",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"wnd_dir_ctnt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daRight,	true,		prefix+"wnd_scl_no",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		prefix+"ocn_crnt_ctnt",		false,		"",			dfNone,		0,			false,		false);
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
			InitDataProperty(0, cnt++ , dtData,				50,		daLeft,	    true,		prefix+"load",		false,		"",			dfNone,		0,			false,		false);
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
			InitDataProperty(0, cnt++ , dtData,			    50,		daCenter,	true,		prefix+"avg_slp_rt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			    50,		daCenter,	true,		prefix+"avg_slp_opt_rt",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,	true,		prefix+"load_use_flg",		false,		"",			dfNone,		0,			false,		false);
			
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
function initChart(chartObj , chartId) {
	
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

function printOneChart(){
	var formObj = document.form;
	clearChart(chartObjects);
	// all chart closed
	for(var i=0; i<chartObjects.length; i++){
		 chartObjects[i].style.height = 0;
	}

	if(formObj.cht_tp_cd[0].checked){
		printChartTwoLine(document.getElementById("chart_line"), "chart_line");
		printChartOneLine(document.getElementById("chart_cspd_mefoc"), "chart_cspd_mefoc");
	}else if(formObj.cht_tp_cd[1].checked){
		printChartOneLine(document.getElementById("chart_aspd_mefoc"), "chart_aspd_mefoc");
		printChartOneLine(document.getElementById("chart_cspd_mefoc_2"), "chart_cspd_mefoc_2");
	}else if(formObj.cht_tp_cd[2].checked){
		printChartOneLine(document.getElementById("chart_cspd_rpm"), "chart_cspd_rpm");
		printChartOneLine(document.getElementById("chart_cspd_load"), "chart_cspd_load");
	}else if(formObj.cht_tp_cd[3].checked){
		printChartOneLine(document.getElementById("chart_rpm_mefoc"), "chart_rpm_mefoc");
		printChartOneLine(document.getElementById("chart_load_mefoc"), "chart_load_mefoc");
	}
}

function printChartTwoLine(chartObj, chartId){
	var sheetObjTrendLine = sheetObjects[0];
	var sheetObj = sheetObjects[2];
	
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
		if(sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg")=="N"){
			x = sheetObj.CellValue(i, "sheet3_calc_spd");
			y = sheetObj.CellValue(i, "sheet3_day_mn_foil_csm_qty");
 			
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
			 1,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObjTrendLine,
			1,
			1); //1차식
	
	consts = getCoefficient(sheetObjTrendLine,
			 1,
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
			 2,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObjTrendLine,
			2,
			1); //1차식
	
	consts = getCoefficient(sheetObjTrendLine,
			 2,
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
	
	chartObj.AutoRedraw = true;
// 	points = null;
}

function printChartOneLine(chartObj, chartId){
	var sheetObjRslt = sheetObjects[0];
	var sheetObj = sheetObjects[2];
	
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
		if(sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg")=="N"){
			if(chartId=="chart_cspd_mefoc" || chartId=="chart_cspd_mefoc_2"){
				x = sheetObj.CellValue(i, "sheet3_calc_spd");
				y = sheetObj.CellValue(i, "sheet3_day_mn_foil_csm_qty");
			}else if(chartId=="chart_aspd_mefoc"){
				x = sheetObj.CellValue(i, "sheet3_sail_avg_spd");
				y = sheetObj.CellValue(i, "sheet3_day_mn_foil_csm_qty");
			}else if(chartId=="chart_cspd_rpm"){
				x = sheetObj.CellValue(i, "sheet3_calc_spd");
				y = sheetObj.CellValue(i, "sheet3_sail_avg_rpm_pwr");
			}else if(chartId=="chart_rpm_mefoc"){
				x = sheetObj.CellValue(i, "sheet3_sail_avg_rpm_pwr");
				y = sheetObj.CellValue(i, "sheet3_day_mn_foil_csm_qty");
			}else if(chartId=="chart_load_mefoc"){
				if(sheetObj.CellValue(i, "sheet3_load_use_flg")=="Y"){		//load는 raw data를 따로 관리
					x = sheetObj.CellValue(i, "sheet3_load");
					y = sheetObj.CellValue(i, "sheet3_day_mn_foil_csm_qty");
				}else{
					x="";
					y="";
				}
			}else if(chartId=="chart_cspd_load"){
				if(sheetObj.CellValue(i, "sheet3_load_use_flg")=="Y"){		//load는 raw data를 따로 관리
					x = sheetObj.CellValue(i, "sheet3_calc_spd");
					y = sheetObj.CellValue(i, "sheet3_load");
				}else{
					x="";
					y="";
				}
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
	
	x2Coef = getCoefficient(sheetObjRslt,
			 chartId,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObjRslt,
			chartId,
			1); //1차식
	
	consts = getCoefficient(sheetObjRslt,
			 chartId,
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
	
	if(x2Coef==0 && xCoef==0 && consts==0){
		if(chartId=="chart_cspd_load"){
			chartObj.Plot.Axis(ibcAxisY).Min = Number(document.getElementById("chart_cspd_rpm").Plot.Axis(ibcAxisY).Min);
			chartObj.Plot.Axis(ibcAxisY).Max = Number(document.getElementById("chart_cspd_rpm").Plot.Axis(ibcAxisY).Max);
			chartObj.Plot.Axis(ibcAxisY2).Min = Number(chartObj.Plot.Axis(ibcAxisY).Min);
			chartObj.Plot.Axis(ibcAxisY2).Max = Number(chartObj.Plot.Axis(ibcAxisY).Max);
			chartObj.Plot.Axis(ibcAxisX).Min = Number(document.getElementById("chart_cspd_rpm").Plot.Axis(ibcAxisX).Min);
			chartObj.Plot.Axis(ibcAxisX).Max = Number(document.getElementById("chart_cspd_rpm").Plot.Axis(ibcAxisX).Max);
		}else if(chartId=="chart_load_mefoc"){
			chartObj.Plot.Axis(ibcAxisY).Min = Number(document.getElementById("chart_rpm_mefoc").Plot.Axis(ibcAxisY).Min);
			chartObj.Plot.Axis(ibcAxisY).Max = Number(document.getElementById("chart_rpm_mefoc").Plot.Axis(ibcAxisY).Max);
			chartObj.Plot.Axis(ibcAxisY2).Min = Number(chartObj.Plot.Axis(ibcAxisY).Min);
			chartObj.Plot.Axis(ibcAxisY2).Max = Number(chartObj.Plot.Axis(ibcAxisY).Max);
			chartObj.Plot.Axis(ibcAxisX).Min = Number(document.getElementById("chart_rpm_mefoc").Plot.Axis(ibcAxisX).Min);
			chartObj.Plot.Axis(ibcAxisX).Max = Number(document.getElementById("chart_rpm_mefoc").Plot.Axis(ibcAxisX).Max);
		}
	}else{
		// 차트 Y축 설정
		chartObj.Plot.Axis(ibcAxisY).Min = (minY-20>0)?minY-20:0;
		chartObj.Plot.Axis(ibcAxisY).Max = maxY+20;
		
		// 차트 Y축 설정
		chartObj.Plot.Axis(ibcAxisY2).Min = (minY-20>0)?minY-20:0;
		chartObj.Plot.Axis(ibcAxisY2).Max = maxY+20;
		
		// 차트 X축 설정
		chartObj.Plot.Axis(ibcAxisX).Min = (minX-10>0)?minX-10:0;
		chartObj.Plot.Axis(ibcAxisX).Max = maxX+10;
	}
	
	chartObj.AutoRedraw = true;
// 	points = null;
}
 
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var aryPrefix = new Array( "sheet1_", "sheet3_");
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0055GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			var arrXml = sXml.split("|$$|");
			inqflg="inquiry";
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[2].LoadSearchXml(arrXml[1]);
			if(sheetObjects[2].SearchRows>0){
		 		var count=0;
		 		for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows+sheetObjects[2].RowCount; i++){
		 			if(sheetObjects[2].CellValue(i, "sheet3_trnd_line_xcld_flg")=="N"){
		 				count++;
		 			}
		 		}
		 		if(count<3){
		 			ComShowMessage("There are few data to draw Trend Line.");
		 			clearChart(chartObjects);
		 			return false;
		 		}else{
		 			printOneChart();
		 			parent.syncHeight();
		 		}
			}else{
				clearChart(chartObjects);
			}
		}
		break;
		
	case SEARCH01:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0055GS.do",  FormQueryString(formObj)+"&target="+formObj.itm_cd_1.Code);
			ComOpenWait(false);
			var rslt = ComGetEtcData(sXml, "rslt");
			if(rslt != null && rslt != undefined && rslt != ""){
				setItmVal(formObj.itm_val_1, rslt);
			}else{
				ComShowCodeMessage("COM130401");
				formObj.itm_cd_1.Code="";
			}
		}
		break;
		
	case SEARCH02:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0055GS.do",  FormQueryString(formObj)+"&target="+formObj.itm_cd_2.Code);
			ComOpenWait(false);
			var rslt = ComGetEtcData(sXml, "rslt");
			if(rslt != null && rslt != undefined && rslt != ""){
				setItmVal(formObj.itm_val_2, rslt);
			}else{
				ComShowCodeMessage("COM130401");
				formObj.itm_cd_2.Code="";
			}
		}
		break;
		
	case SEARCH03:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0055GS.do",  FormQueryString(formObj)+"&target="+formObj.itm_cd_3.Code);
			ComOpenWait(false);
			var rslt = ComGetEtcData(sXml, "rslt");
			if(rslt != null && rslt != undefined && rslt != ""){
				setItmVal(formObj.itm_val_3, rslt);
			}else{
				ComShowCodeMessage("COM130401");
				formObj.itm_cd_3.Code="";
			}
		}
		break;
		
	case SEARCH04:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0055GS.do",  FormQueryString(formObj)+"&target="+formObj.itm_cd_4.Code);
			ComOpenWait(false);
			var rslt = ComGetEtcData(sXml, "rslt");
			if(rslt != null && rslt != undefined && rslt != ""){
				setItmVal(formObj.itm_val_4, rslt);
			}else{
				ComShowCodeMessage("COM130401");
				formObj.itm_cd_4.Code="";
			}
		}
		break;
		
	case COMMAND01: // delt flg 변경 후 Simulation
		if (validateForm(sheetObj, formObj, sAction)) {
//			[참고] sheetObj -> sheetObjects[2]
			formObj.f_cmd.value = COMMAND01;
			var aryPrefix = new Array( "sheet1_", "sheet3_");
			ComOpenWait(true);
			setOptRt(sheetObj, formObj);
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0055GS.do", "f_cmd="+COMMAND01+"&"+ComGetSaveString(sheetObj, true, true)+"&"+ComGetPrefixParam(aryPrefix));
	 	   ComOpenWait(false);
			var arrXml = sXml.split("|$$|");
			inqflg="simulation";
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObj.LoadSearchXml(arrXml[1]);
			//simulation 후에는 sheet3를 재조회 하지 않으므로, org_trnd_line_xcld_flg를 trnd_line_xcld_flg로 바꿔준다.
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				sheetObj.CellValue2(i, "sheet3_org_trnd_line_xcld_flg")=sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg");
			}
			if(sheetObj.RowCount>0){
		 		var count=0;
		 		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		 			if(sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg")=="N"){
		 				count++;
		 			}
		 		}
		 		if(count<3){
		 			ComShowMessage("There are few data to draw Trend Line.");
		 			clearChart(chartObjects);
		 			return false;
		 		}else{
		 			printOneChart();
		 			parent.syncHeight();
		 		}
			}else{
				clearChart(chartObjects);
			}
		}
		break;
		
	}
}

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
			|| v=="NaN" || v=="0.000000000000000" || x2=="Infinity" || x=="Infinity" || c=="Infinity" || v=="Infinity"){
			if(inqflg=="inquiry"){
				ComShowMessage("Can't Create "+i+"th Trend Line. Please Check Data.");
			}
			sheetObj.CellValue2(i, prefix+"n1st_coef_val") = ""; 
			sheetObj.CellValue2(i, prefix+"n2nd_coef_val") = ""; 
			sheetObj.CellValue2(i, prefix+"trnd_line_cons_val") = "";
			sheetObj.CellValue2(i, prefix+"foml_desc") = "";
			sheetObj.CellValue2(i, prefix+"coef_of_dtmn_val") = "";
		}else{
			sheetObj.CellValue2(i, prefix+"foml_desc") = x2+" x2 "+x+" x "+c;
		}
	}
//	setRsltSheet(sheetObj);//sheet 컬럼 한개만 보이도록.

	//	bcimpl에서 trnd_line_tp_cd로 넣어주는 데이터를, 실제 차트와 연결해주기 위하여.
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		var title = "";
		if(sheetObj.CellValue(i, "sheet1_trnd_line_cht_tp_cd")=="01"){
			title = "C.SPD vs M/E FOC";
		}else if(sheetObj.CellValue(i, "sheet1_trnd_line_cht_tp_cd")=="02"){
			title = "A.SPD vs M/E FOC";
		}else if(sheetObj.CellValue(i, "sheet1_trnd_line_cht_tp_cd")=="03"){
			title = "C.SPD vs RPM";
		}else if(sheetObj.CellValue(i, "sheet1_trnd_line_cht_tp_cd")=="04"){
			title = "RPM vs M/E FOC";
		}else if(sheetObj.CellValue(i, "sheet1_trnd_line_cht_tp_cd")=="05"){
			title = "LOAD vs M/E FOC";
		}else if(sheetObj.CellValue(i, "sheet1_trnd_line_cht_tp_cd")=="06"){
			title = "C.SPD vs LOAD";
		}
		sheetObj.CellValue2(i, "sheet1_title")=title;
	}
	
	//미리 sheet2 계산을 위한 조건값을 넣어놓은 경우, 다시 계산되도록 한다.
	ComClearSeparator(formObj.sea_dist);//removing comma for calculating
	ComClearSeparator(formObj.sea_time);
	ComClearSeparator(formObj.item_val);
	if(formObj.item_val.value!="" && formObj.sea_dist.value!="" && formObj.sea_time.value!=""){
		if(formObj.item_val.className=="input2"){
			if(calcCirculation(formObj.item_val)){
				calcSpdRpmLoad();
			}
		}else if(formObj.sea_dist.className=="input2"){
			if(calcCirculation(formObj.sea_dist)){
				calcSpdRpmLoad();
			}
		}else if(formObj.sea_time.className=="input2"){
			if(calcCirculation(formObj.sea_time)){
				calcSpdRpmLoad();
			}
		}
	}else if(formObj.item_val.value!=""){
		calcSpdRpmLoad();
	}
	ComAddSeparator(formObj.sea_dist);//returning to original state
	ComAddSeparator(formObj.sea_time);
	ComAddSeparator(formObj.item_val);
}

function sheet3_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	if(sheetObj.RowCount>0){
		formObj.avg_slp_rt.value = sheetObj.CellValue(sheetObj.HeaderRows, "sheet3_avg_slp_rt");
		
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			sheetObj.CellValue2(i, "sheet3_org_trnd_line_xcld_flg")=sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg");
			sheetObj.RowStatus(i)="R";
		}
	}
}

/**
* Delete Flg 변경시
*/
function sheet3_OnChange(sheetObj,Row,Col,Value) {
	switch (sheetObj.ColSaveName(Col)) {
		case "sheet3_trnd_line_xcld_flg" :
			if(sheetObj.CellValue(Row, Col)=="N"){
				setColorBack(sheetObj, Row);
			}
			break;
	}
}

function obj_activate() {
	var srcName = event.srcElement.name;
	switch(srcName){
		case "trnd_line_fm_dt":
		case "trnd_line_to_dt":
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			event.srcElement.select();
			break;
	}
}

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
		}
	}
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
//			ComKeyOnlyAlphabet('lowernum')
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
	var sheetObj2 = sheetObjects[1];
	with(formObj){
		switch(obj.name) {

			case "avg_slp_opt_rt":
			break;
			
			case "item":
				sheetObj2.RemoveAll();
				if(formObj.item.value=="S"){//speed
					sheetObj2.ColHidden("sheet2_calc_spd") = true;
					sheetObj2.ColHidden("sheet2_sail_avg_rpm_pwr") = false;
					sheetObj2.ColHidden("sheet2_load") = false;
				}else if(formObj.item.value=="R"){//rpm
					sheetObj2.ColHidden("sheet2_calc_spd") = false;
					sheetObj2.ColHidden("sheet2_sail_avg_rpm_pwr") = true;
					sheetObj2.ColHidden("sheet2_load") = false;
				}else if(formObj.item.value=="L"){//load
					sheetObj2.ColHidden("sheet2_calc_spd") = false;
					sheetObj2.ColHidden("sheet2_sail_avg_rpm_pwr") = false;
					sheetObj2.ColHidden("sheet2_load") = true;
				}
				
				if(formObj.sea_dist.value!="" && formObj.sea_time.value!="" && formObj.item_val.value!=""){
					ComClearSeparator(formObj.sea_dist);//removing comma for calculating
					ComClearSeparator(formObj.sea_time);
					ComClearSeparator(formObj.item_val);
					
					if(formObj.item_val.className == "input2"){
						if(!calcCirculation(formObj.item_val)){
							formObj.sea_dist.value = "";
							formObj.sea_time.value = "";
						}else{
							calcSpdRpmLoad();
						}
					}else{
						formObj.item_val.value = "";
						if(formObj.sea_dist.className == "input2"){
							formObj.sea_dist.className = "input";
							formObj.sea_dist.readOnly = false;
							formObj.sea_dist.value="";
						}else{
							formObj.sea_time.className = "input";
							formObj.sea_time.readOnly = false;
							formObj.sea_time.value="";
						}
					}
					
					ComAddSeparator(formObj.sea_dist);//returning to original state
					ComAddSeparator(formObj.sea_time);
					ComAddSeparator(formObj.item_val);
				}else{
					formObj.item_val.value="";
				}
			break;
			
			case "item_val":
			case "sea_time":
			case "sea_dist":
				if(!ComChkObjValid(obj)){
					 obj.value="";
				}
				ComClearSeparator(formObj.sea_dist);//removing comma for calculating
				ComClearSeparator(formObj.sea_time);
				ComClearSeparator(formObj.item_val);
				
				setCirculation(obj);
				
				ComAddSeparator(formObj.sea_dist);//returning to original state
				ComAddSeparator(formObj.sea_time);
				ComAddSeparator(formObj.item_val);
			break;
			
		}
	}
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
			 break;
			 
		 case SEARCH01:
			 if(itm_cd_1.Code==""){
				 itm_val_1.RemoveAll();
				 return false;
			 }
			 break;
			 
		 case COMMAND01:
			 var count=0;
			 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				 if(sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg")=="N"){
					 count++;
				 }
			 }
			 if(count<3){
				 ComShowMessage("Can't Create Trend line due to the lack of reports");
				 return false;
			 }
			 break;
		 }
	 }
	 return true;
}

function clearAll(str){
	var formObj = document.form;
	formObj.cntr_dzn_capa.value="";
	formObj.vsl_cd.value="";
	formObj.vsl_slan_cd.value="";
	formObj.skd_dir_cd.value="";
	
	formObj.itm_cd_1.Code="";
	formObj.itm_cd_2.Code="";
	formObj.itm_cd_3.Code="";
	formObj.itm_cd_4.Code="";
	formObj.itm_cd_2.Enable = false;
	formObj.itm_cd_3.Enable = false;
	formObj.itm_cd_4.Enable = false;
	
	formObj.itm_val_1.RemoveAll();
	formObj.itm_val_2.RemoveAll();
	formObj.itm_val_3.RemoveAll();
	formObj.itm_val_4.RemoveAll();
	formObj.itm_val_1.Enable = false;
	formObj.itm_val_2.Enable = false;
	formObj.itm_val_3.Enable = false;
	formObj.itm_val_4.Enable = false;
	
	formObj.avg_slp_rt.value="";
	formObj.avg_slp_opt_rt.value="";
	
	formObj.sea_dist.value="";
	formObj.sea_time.value="";
	formObj.item_val.value="";
	formObj.sea_dist.className="input";
	formObj.sea_time.className="input";
	formObj.item_val.className="input";
	formObj.sea_dist.readOnly=false;
	formObj.sea_time.readOnly=false;
	formObj.item_val.readOnly=false;
	
	formObj.trnd_line_fm_dt.value = ComGetDateAdd(null, "M", -3);
	formObj.trnd_line_to_dt.value = ComGetNowInfo();
	
	for(var i=0; i<sheetObjects.length; i++){
		sheetObjects[i].RemoveAll();
	}
	clearChart(chartObjects);
	parent.syncHeight();
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

function itm_cd_1_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_1.RemoveAll();
	formObj.itm_val_2.RemoveAll();
	formObj.itm_val_3.RemoveAll();
	formObj.itm_val_4.RemoveAll();
	formObj.itm_cd_3.Code = "";
	formObj.itm_cd_4.Code = "";
	formObj.itm_cd_2.Enable = false;
	formObj.itm_cd_3.Enable = false;
	formObj.itm_cd_4.Enable = false;
	formObj.itm_val_2.Enable = false;
	formObj.itm_val_3.Enable = false;
	formObj.itm_val_4.Enable = false;
	if(Index_Code!=""){
		//다음 itm code reset 후 setting
		formObj.itm_cd_2.RemoveAll();
		initCombo(formObj.itm_cd_2, '');
		formObj.itm_cd_2.DeleteItem(formObj.itm_cd_1.Code);
		
		setKeyValue(formObj, "");
		//해당 itm value 조회
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
	}
}

function itm_val_1_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_2.RemoveAll();
	formObj.itm_val_3.RemoveAll();
	formObj.itm_val_4.RemoveAll();
	formObj.itm_cd_2.Code="";
	formObj.itm_cd_3.Code="";
	formObj.itm_cd_4.Code="";
	formObj.itm_cd_3.Enable = false;
	formObj.itm_cd_4.Enable = false;
	formObj.itm_val_2.Enable = false;
	formObj.itm_val_3.Enable = false;
	formObj.itm_val_4.Enable = false;
	if(Index_Code!=""){
		formObj.itm_cd_2.Enable = true;
		setKeyValue(formObj, "1");
	}else{
		formObj.itm_cd_2.Enable = false;
	}
}

function itm_cd_2_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_2.RemoveAll();
	formObj.itm_val_3.RemoveAll();
	formObj.itm_val_4.RemoveAll();
	formObj.itm_cd_4.Code = "";
	formObj.itm_cd_3.Enable = false;
	formObj.itm_cd_4.Enable = false;
	formObj.itm_val_3.Enable = false;
	formObj.itm_val_4.Enable = false;
	if(Index_Code!=""){
		//다음 itm code reset 후 setting
		formObj.itm_cd_3.RemoveAll();
		initCombo(formObj.itm_cd_3, '');
		formObj.itm_cd_3.DeleteItem(formObj.itm_cd_1.Code);
		formObj.itm_cd_3.DeleteItem(formObj.itm_cd_2.Code);
		
		setKeyValue(formObj, "");
		//해당 itm value 조회
		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	}
}

function itm_val_2_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_3.RemoveAll();
	formObj.itm_val_4.RemoveAll();
	formObj.itm_cd_3.Code="";
	formObj.itm_cd_4.Code="";
	formObj.itm_cd_4.Enable = false;
	formObj.itm_val_3.Enable = false;
	formObj.itm_val_4.Enable = false;
	if(Index_Code!=""){
		formObj.itm_cd_3.Enable = true;
		setKeyValue(formObj, "2");
	}else{
		formObj.itm_cd_3.Enable = false;
	}
}

function itm_cd_3_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_3.RemoveAll();
	formObj.itm_val_4.RemoveAll();
	formObj.itm_cd_4.Enable = false;
	formObj.itm_val_4.Enable = false;
	if(Index_Code!=""){
		//다음 itm code reset 후 setting
		formObj.itm_cd_4.RemoveAll();
		initCombo(formObj.itm_cd_4, '');
		formObj.itm_cd_4.DeleteItem(formObj.itm_cd_1.Code);
		formObj.itm_cd_4.DeleteItem(formObj.itm_cd_2.Code);
		formObj.itm_cd_4.DeleteItem(formObj.itm_cd_3.Code);
		
		setKeyValue(formObj, "");
		//해당 itm value 조회
		doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
	}
}

function itm_val_3_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_4.RemoveAll();
	formObj.itm_cd_4.Code="";
	formObj.itm_val_4.Enable = false;
	if(Index_Code!=""){
		formObj.itm_cd_4.Enable = true;
		setKeyValue(formObj, "3");
	}else{
		formObj.itm_cd_4.Enable = false;
	}
}

function itm_cd_4_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.itm_val_4.RemoveAll();
	if(Index_Code!=""){
		setKeyValue(formObj, "");
		//해당 itm value 조회
		doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
	}else{
		formObj.itm_val_4.RemoveAll();
	}
}

function itm_val_4_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	if(Index_Code!=""){
		setKeyValue(formObj, "4");
	}
}

function setItmVal(comboObj, rslt){
	if(rslt != null && rslt != undefined && rslt != ""){
		comboObj.RemoveAll();
		var rsltArr = rslt.split("|");
		comboObj.InsertItem(-1, "ALL", "A");
		for (var i = 0 ; i < rsltArr.length ; i++) {
			comboObj.InsertItem(-1, rsltArr[i], rsltArr[i]);
		}
		comboObj.Enable = true;
	}
}

/*
 * itm_val 선택시, 해당 itm의 순서대로 flg를 가져오며,
 * 순서에 맞지 않게 itm_cd를 재선택하는 경우가 존재하므로, flg를 ""로 가져와서, 모든 itm에 대해 다시 셋팅한다.
 */
function setKeyValue(formObj, flg){
	var itm = "";
	var val = "";
	formObj.cntr_dzn_capa.value="";
	formObj.vsl_cd.value="";
	formObj.vsl_slan_cd.value="";
	formObj.skd_dir_cd.value="";
	if(flg=="") flg="4";
	
	for(var i=flg; i>0; i--){
		if(i=="1"){					//첫번째 조건 setting
			itm = formObj.itm_cd_1.Code;
			val = formObj.itm_val_1.Code;
		}else if(i=="2"){				//두번째 조건 setting
			itm = formObj.itm_cd_2.Code;
			val = formObj.itm_val_2.Code;
		}else if(i=="3"){				//세번째 조건 setting
			itm = formObj.itm_cd_3.Code;
			val = formObj.itm_val_3.Code;
		}else if(i=="4"){				//네번째 조건 setting
			itm = formObj.itm_cd_4.Code;
			val = formObj.itm_val_4.Code;
		}
		
		if(val!=""){
			if(itm=="cntr_dzn_capa"){
				formObj.cntr_dzn_capa.value = val; 
			}else if(itm=="vsl_cd"){
				formObj.vsl_cd.value = val;
			}else if(itm=="vsl_slan_cd"){
				formObj.vsl_slan_cd.value = val;
			}else if(itm=="skd_dir_cd"){
				formObj.skd_dir_cd.value = val;
			}
		}
	}
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

function setOptRt(sheetObj, formObj){
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		if(formObj.avg_slp_opt_rt.value==""){
			sheetObj.CellValue2(i, "sheet3_avg_slp_opt_rt") = 0;
		}else{
			sheetObj.CellValue2(i, "sheet3_avg_slp_opt_rt") = formObj.avg_slp_opt_rt.value;
		}
	}
}

function calcData(sheetObj, row, cspd){
	var coef2="";
	var coef1="";
	var cons="";
	
	coef2=getCoefficient(sheetObj, "chart_cspd_mefoc", 2);
	coef1=getCoefficient(sheetObj, "chart_cspd_mefoc", 1);
	cons=getCoefficient(sheetObj, "chart_cspd_mefoc", 0);
	sheetObj.CellValue(row, "sheet1_day_mn_foil_csm_qty") = round(calcFoc(coef2,coef1,cons,cspd),2);
	 
	coef2=getCoefficient(sheetObj, "chart_cspd_rpm", 2);
	coef1=getCoefficient(sheetObj, "chart_cspd_rpm", 1);
	cons=getCoefficient(sheetObj, "chart_cspd_rpm", 0);
	sheetObj.CellValue(row, "sheet1_sail_avg_rpm_pwr") = round(calcFoc(coef2,coef1,cons,cspd),2);
	 
	coef2=getCoefficient(sheetObj, "chart_cspd_load", 2);
	coef1=getCoefficient(sheetObj, "chart_cspd_load", 1);
	cons=getCoefficient(sheetObj, "chart_cspd_load", 0);
	sheetObj.CellValue(row, "sheet1_load") = round(calcFoc(coef2,coef1,cons,cspd),2);
}

function getCoefficient(sheetObj, chartId, degree){
	var coefficient = 0;
	var saveName = "";
	var row = 0;
	if(chartId == "chart_cspd_mefoc" || chartId == "chart_cspd_mefoc_2"){
		row = sheetObj.HeaderRows;
	}else if(chartId == "chart_aspd_mefoc"){
		row = sheetObj.HeaderRows+1;
	}else if(chartId == "chart_cspd_rpm"){
		row = sheetObj.HeaderRows+2;
	}else if(chartId == "chart_cspd_load"){
		row = sheetObj.HeaderRows+5;
	}else if(chartId == "chart_rpm_mefoc"){
		row = sheetObj.HeaderRows+3;
	}else if(chartId == "chart_load_mefoc"){
		row = sheetObj.HeaderRows+4;
	}else{
		row = chartId;
	}
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

function chart_cspd_mefoc_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}
function chart_aspd_mefoc_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}
function chart_cspd_mefoc_2_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}
function chart_cspd_rpm_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}
function chart_cspd_load_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}
function chart_rpm_mefoc_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}
function chart_load_mefoc_PointClick(chartObj, chartid, seriesindex, pointindex){
	chartPointClick(chartObj, chartid, pointindex);
}

function chartPointClick(chartObj, chartid, pointindex){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[2];
	 if(chartid==1){
		 if(chartObj.id == "chart_cspd_mefoc" || chartObj.id == "chart_aspd_mefoc" || chartObj.id == "chart_cspd_mefoc_2" || chartObj.id == "chart_cspd_rpm" || chartObj.id == "chart_rpm_mefoc"){
			 var pointRow=0;
			 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				 if(sheetObj.CellValue(i, "sheet3_org_trnd_line_xcld_flg")=="N"){
					 pointRow++;
					 if(pointRow==pointindex){
						 sheetObj.SelectCell(i, "sheet3_ibflag");
						 sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg")="Y";
						 sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,051,204);
					 }
				 }
			 }
		 }else if(chartObj.id == "chart_cspd_load" || chartObj.id == "chart_load_mefoc"){
			 var pointRow=0;
			 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				 if(sheetObj.CellValue(i, "sheet3_org_trnd_line_xcld_flg")=="N" && sheetObj.CellValue(i, "sheet3_load_use_flg")=="Y"){
					 pointRow++;
					 if(pointRow==pointindex){
						 sheetObj.SelectCell(i, "sheet3_ibflag");
						 sheetObj.CellValue(i, "sheet3_trnd_line_xcld_flg")="Y";
						 sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,051,204);
					 }
				 }
			 }
		 }
	 }
}

function setColorBack(sheetObj, Row){
	 sheetObj.CellBackColor(Row,"sheet3_trnd_line_xcld_flg") = sheetObj.RgbColor(255,255,255);
	 for(var i=3; i<32; i++){ //마지막 column 까지.
		 sheetObj.CellBackColor(Row, i) = sheetObj.RgbColor(239,240,243);
	 }
}

function showRawData(){
	var formObj = document.form;
	var sheetObj3 = sheetObjects[2];
	if(formObj.chk_raw_data.checked==true){
		sheetObj3.style.height = 440;
	}else{
		sheetObj3.style.height = 0;
	}
	parent.syncHeight();
}

/*
 * spd -> rpm : 3
 *     -> load : 6
 *     -> foc : 1
 * rpm -> spd : 3의 역함수
 *     -> load : 3의 역함수 * 6
 *     -> foc : 4
 * load -> spd : 6의 역함수
 *      -> rpm : 6의 역함수 * 3
 *      -> foc : 6의 역함수 * 1
 */
function calcSpdRpmLoad(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var spd = 0;
	var rpm = 0;
	var load = 0;
	if(sheetObj.RowCount==0){
		return false;
	}
	if(formObj.item_val.value==""){
		return false;
	}
	var coef2="";
	var coef1="";
	var cons="";
	sheetObj2.RemoveAll();
	var row = sheetObj2.DataInsert(-1);
	if(formObj.item.value=="S"){

		cspd = formObj.item_val.value;
		
		coef2=getCoefficient(sheetObj, "chart_cspd_rpm", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_rpm", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_rpm", 0);
		sheetObj2.CellValue2(row, "sheet2_sail_avg_rpm_pwr") = round(calcFoc(coef2,coef1,cons,cspd),2);
		
		coef2=getCoefficient(sheetObj, "chart_cspd_load", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_load", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_load", 0);
		sheetObj2.CellValue2(row, "sheet2_load") = round(calcFoc(coef2,coef1,cons,cspd),2);
		
		coef2=getCoefficient(sheetObj, "chart_cspd_mefoc", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_mefoc", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_mefoc", 0);
		sheetObj2.CellValue2(row, "sheet2_day_mn_foil_csm_qty") = round(calcFoc(coef2,coef1,cons,cspd),2);

	}else if(formObj.item.value=="R"){
		
		rpm = formObj.item_val.value;
		
		coef2=getCoefficient(sheetObj, "chart_cspd_rpm", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_rpm", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_rpm", 0);
		cspd=quadraticFormula(coef2,coef1,cons,rpm);//반올림 이전의 cspd 값
		sheetObj2.CellValue2(row, "sheet2_calc_spd") = round(cspd,2);
		
		coef2=getCoefficient(sheetObj, "chart_cspd_load", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_load", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_load", 0);
		sheetObj2.CellValue2(row, "sheet2_load") = round(calcFoc(coef2,coef1,cons,cspd),2);
		
		coef2=getCoefficient(sheetObj, "chart_rpm_mefoc", 2);
		coef1=getCoefficient(sheetObj, "chart_rpm_mefoc", 1);
		cons=getCoefficient(sheetObj, "chart_rpm_mefoc", 0);
		sheetObj2.CellValue2(row, "sheet2_day_mn_foil_csm_qty") = round(calcFoc(coef2,coef1,cons,rpm),2);
		
	}else if(formObj.item.value=="L"){
		
		load = formObj.item_val.value;
		
		coef2=getCoefficient(sheetObj, "chart_cspd_load", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_load", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_load", 0);
		cspd=quadraticFormula(coef2,coef1,cons,load);//반올림 이전의 cspd 값
		sheetObj2.CellValue2(row, "sheet2_calc_spd") = round(cspd,2);
		
		coef2=getCoefficient(sheetObj, "chart_cspd_rpm", 2);
		coef1=getCoefficient(sheetObj, "chart_cspd_rpm", 1);
		cons=getCoefficient(sheetObj, "chart_cspd_rpm", 0);
		sheetObj2.CellValue2(row, "sheet2_sail_avg_rpm_pwr") = round(calcFoc(coef2,coef1,cons,cspd),2);
		
		coef2=getCoefficient(sheetObj, "chart_load_mefoc", 2);
		coef1=getCoefficient(sheetObj, "chart_load_mefoc", 1);
		cons=getCoefficient(sheetObj, "chart_load_mefoc", 0);
		sheetObj2.CellValue2(row, "sheet2_day_mn_foil_csm_qty") = round(calcFoc(coef2,coef1,cons,load),2);
		
	}
	
	calcSeaTimeFOC()
}
 
 function calcSeaTimeFOC(){
	 var sheetObj2 = sheetObjects[1];
	 var formObj = document.form;
	 var row = sheetObj2.HeaderRows+sheetObj2.RowCount-1;
	 if(sheetObj2.RowCount>0){
		 if(formObj.sea_time.value!=""){
			 sheetObj2.CellValue2(row, "sheet2_day_mn_foil_csm_qty_sea_time") = round(sheetObj2.CellValue(row, "sheet2_day_mn_foil_csm_qty") * Number(formObj.sea_time.value) / 24, 2);
		 }else{
			 sheetObj2.CellValue2(row, "sheet2_day_mn_foil_csm_qty_sea_time") = "";
		 }
	 }
 }
 
 function setCirculation(obj){
	 var formObj = document.form;
	 
	 if(obj.name=="sea_dist"){
		 if(obj.value!=""){
			 if(formObj.sea_time.value!="" && formObj.item_val.value!=""){
				 if(formObj.sea_time.className=="input2"){
					 formObj.sea_time.value="";
					 if(!calcCirculation(formObj.sea_time)){	//sea time 계산
						 obj.value="";
						 return false;
					 }
				 }else{
					 formObj.item_val.value="";
					 if(!calcCirculation(formObj.item_val)){	//item val 계산
						 obj.value="";
						 return false;
					 }
				 }
			 }else if(formObj.sea_time.value!="" || formObj.item_val.value!=""){
				 if(formObj.sea_time.value!=""){
					 if(!calcCirculation(formObj.item_val)){	//item val 계산
						 obj.value="";
						 return false;
					 }
					 formObj.item_val.className = "input2";
					 formObj.item_val.readOnly = true;
				 }else{
					 if(!calcCirculation(formObj.sea_time)){	//sea_time 계산
						 obj.value="";
						 return false;
					 }
					 formObj.sea_time.className = "input2";
					 formObj.sea_time.readOnly = true;
				 }
			 }
		 }else{
			 if(formObj.sea_time.value!="" && formObj.item_val.value!=""){
				 if(formObj.sea_time.className=="input2"){
					 formObj.sea_time.className = "input";
					 formObj.sea_time.readOnly = false;
					 formObj.sea_time.value = "";
				 }else{
					 formObj.item_val.className = "input";
					 formObj.item_val.readOnly = false;
					 formObj.item_val.value = "";
				 }
			 }
		 }
	 }else if(obj.name=="sea_time"){
		 if(obj.value!=""){
			 if(formObj.sea_dist.value!="" && formObj.item_val.value!=""){
				 if(formObj.sea_dist.className=="input2"){
					 formObj.sea_dist.value="";
					 if(!calcCirculation(formObj.sea_dist)){	//sea_dist 계산
						 obj.value="";
						 return false;
					 }
				 }else{
					 formObj.item_val.value="";
					 if(!calcCirculation(formObj.item_val)){	//item val 계산
						 obj.value="";
						 return false;
					 }
				 }
			 }else if(formObj.sea_dist.value!="" || formObj.item_val.value!=""){
				 if(formObj.sea_dist.value!=""){
					 if(!calcCirculation(formObj.item_val)){	//item val 계산
						 obj.value="";
						 return false;
					 }
					 formObj.item_val.className = "input2";
					 formObj.item_val.readOnly = true;
				 }else{
					 if(!calcCirculation(formObj.sea_dist)){	//sea_dist 계산
						 obj.value="";
						 return false;
					 }
					 formObj.sea_dist.className = "input2";
					 formObj.sea_dist.readOnly = true;
				 }
			 }
		 }else{
			 if(formObj.sea_dist.value!="" && formObj.item_val.value!=""){
				 if(formObj.sea_dist.className=="input2"){
					 formObj.sea_dist.className = "input";
					 formObj.sea_dist.readOnly = false;
					 formObj.sea_dist.value = "";
				 }else{
					 formObj.item_val.className = "input";
					 formObj.item_val.readOnly = false;
					 formObj.item_val.value = "";
				 }
			 }
		 }
	 }else if(obj.name=="item_val"){
		 if(obj.value!=""){
			 if(formObj.sea_dist.value!="" && formObj.sea_time.value!=""){
				 if(formObj.sea_dist.className=="input2"){
					 formObj.sea_dist.value="";
					 if(!calcCirculation(formObj.sea_dist)){	//sea_dist 계산
						 obj.value="";
						 return false;
					 }
				 }else{
					 formObj.sea_time.value="";
					 if(!calcCirculation(formObj.sea_time)){	//sea_time 계산
						 obj.value="";
						 return false;
					 }
				 }
			 }else if(formObj.sea_dist.value!="" || formObj.sea_time.value!=""){
				 if(formObj.sea_dist.value!=""){
					 if(!calcCirculation(formObj.sea_time)){	//sea_time 계산
						 obj.value="";
						 return false;
					 }
					 formObj.sea_time.className = "input2";
					 formObj.sea_time.readOnly = true;
				 }else{
					 if(!calcCirculation(formObj.sea_dist)){	//sea_dist 계산
						 obj.value="";
						 return false;
					 }
					 formObj.sea_dist.className = "input2";
					 formObj.sea_dist.readOnly = true;
				 }
			 }
		 }else{
			 if(formObj.sea_dist.value!="" && formObj.sea_time.value!=""){
				 if(formObj.sea_dist.className=="input2"){
					 formObj.sea_dist.className = "input";
					 formObj.sea_dist.readOnly = false;
					 formObj.sea_dist.value = "";
				 }else{
					 formObj.sea_time.className = "input";
					 formObj.sea_time.readOnly = false;
					 formObj.sea_time.value = "";
				 }
			 }
		 }
	 }
	 
	 calcSpdRpmLoad(); //sheet2 계산
 }
 
 function calcCirculation(targetObj){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 if(targetObj.name=="sea_time"){
		 if(findSpeed(formObj.item_val.value)!=""){
			 targetObj.value = round(formObj.sea_dist.value / findSpeed(formObj.item_val.value), 2);
		 }else{
			 targetObj.value = "";
			 targetObj.className = "input";
			 targetObj.readOnly = false;
			 return false;
		 }
	 }else if(targetObj.name=="sea_dist"){
		 if(findSpeed(formObj.item_val.value)!=""){
			 targetObj.value = round(formObj.sea_time.value / findSpeed(formObj.item_val.value), 2);
		 }else{
			 targetObj.value = "";
			 targetObj.className = "input";
			 targetObj.readOnly = false;
			 return false;
		 }
	 }else if(targetObj.name=="item_val"){
		 var cspd = formObj.sea_dist.value / formObj.sea_time.value;
		 if(formObj.item.value=="S"){
			 targetObj.value = round(cspd, 2);
		 }else if(formObj.item.value=="R"){
			 if(sheetObj.RowCount==0){
				 targetObj.className = "input";
				 targetObj.readOnly = false;
				 targetObj.value = "";
				 return false;
			 }
			 var coef2=getCoefficient(sheetObj, "chart_cspd_rpm", 2);
			 var coef1=getCoefficient(sheetObj, "chart_cspd_rpm", 1);
			 var cons=getCoefficient(sheetObj, "chart_cspd_rpm", 0);
			 targetObj.value = round(calcFoc(coef2,coef1,cons,cspd),2);
		 }else if(formObj.item.value=="L"){
			 if(sheetObj.RowCount==0){
				 targetObj.className = "input";
				 targetObj.readOnly = false;
				 targetObj.value = "";
				 return false;
			 }
			 var coef2=getCoefficient(sheetObj, "chart_cspd_load", 2);
			 var coef1=getCoefficient(sheetObj, "chart_cspd_load", 1);
			 var cons=getCoefficient(sheetObj, "chart_cspd_load", 0);
			 targetObj.value = round(calcFoc(coef2,coef1,cons,cspd),2);
		 }
	 }
	 return true;
 }
 
 function findSpeed(value){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 if(formObj.item.value=="S"){
		 return value;
	 }else if(formObj.item.value=="R"){
		 if(sheetObj.RowCount==0){
//			 ComShowMessage("조회부터해");
			 return "";
		 }
		 var coef2=getCoefficient(sheetObj, "chart_cspd_rpm", 2);
	 	 var coef1=getCoefficient(sheetObj, "chart_cspd_rpm", 1);
	 	 var cons=getCoefficient(sheetObj, "chart_cspd_rpm", 0);
	 	 var cspd=quadraticFormula(coef2,coef1,cons,value);//반올림 이전의 cspd 값
		 return cspd;//round(cspd,2);
	 }else if(formObj.item.value=="L"){
		 if(sheetObj.RowCount==0){
//			 ComShowMessage("조회부터해");
			 return "";
		 }
		 var coef2=getCoefficient(sheetObj, "chart_cspd_load", 2);
		 var coef1=getCoefficient(sheetObj, "chart_cspd_load", 1);
		 var cons=getCoefficient(sheetObj, "chart_cspd_load", 0);
		 var cspd=quadraticFormula(coef2,coef1,cons,value);//반올림 이전의 cspd 값
		 return cspd;//round(cspd,2);
	 }
 }
/* 개발자 작업 끝 */