/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_BKG_0577.js
 *@FileTitle : ESM_BKG_0577
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.17
 *@LastModifier : 박성진
 *@LastVersion : 1.0
 * 2011.08.17 박성진
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2012.03.09 김보배 [CHM-201216245] [BKG] PSA DG EDI 추가 요건 
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
 * @class ESM_BKG_0577 : ESM_BKG_0577 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0577() {

	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn1_Retrieve":
			doActionIBSheet(sheetObject1, formObject, SEARCH02);
			sheetObjects[1].SelectRow = 0;
			break;
			
		case "btn1_New":
			pageReset(formObject);
			// Declaration init
			initDeclarationType(formObject.init_d_type.value);
			break;

		case "btn1_EDITransmit":
			doActionIBSheet(sheetObject2, formObject, MULTI01);
			break;

		case "btn1_EDICancel":
			doActionIBSheet(sheetObject2, formObject, MULTI02);
			break;

		case "btn1_DownExcel":
			doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
			// sheetObject2.SpeedDown2Excel(-1);
			break;

		case "d_type1": // Declration 선택시(Discharging)
		case "d_type2": // Declration 선택시(Trasit)
		case "d_type3": // Declration 선택시(Loading)
		case "d_type4": // Declration 선택시(Pre-Carriage)
		case "d_type5": // Declration 선택시(On-Carriage)
			var dTypeVal = declarationCheckValue();  // 선택된 체크박스 값 구하기
			dTypeCheckValidate(dTypeVal, srcName);	// 체크 벨리데이션
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
 * 페이지 초기화
 * @param formObject
 * @return
 */
function pageReset(formObject) {
	ComResetAll();
}

/**
 * declaration 필드 선택값 리턴
 * 
 * @return
 */
function declarationCheckValue() {
	
	var formObj = document.form;
	var retVal = "";

	for ( var i = 1; i <= 5; i++) {
		var dTypeFlag = "formObj.d_type" + i + ".checked";
		var dTypeValue = "formObj.d_type" + i + ".value";
		
		if (eval(dTypeFlag)) {
			retVal += eval(dTypeValue);
		}
	} // end for(i)

	return retVal;
}

/**
 * Declaration 체크 Validation
 * @return
 */
function dTypeCheckValidate(dTypeVal, srcName) {
	
	var formObj = document.form;
	
	//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
	
	switch (srcName) {
	
		case "d_type1" :	// Discharging 
			switch (dTypeVal) {
				case "DT" :
				case "DL" :
				case "DP" :
				case "DLP" :
					formObj.d_type1.checked = false;
			
			}
			break;
		case "d_type2" : 	// Transit
			switch (dTypeVal) {
				case "DT" :
				case "TL" :
				case "TP" :
				case "TO" :
				case "TLP" :
				case "DTO" :
					formObj.d_type2.checked = false;
			}
			break;
		case "d_type3" : 	// Loading
			switch (dTypeVal) {
				case "DL" :
				case "TL" :
				case "LO" :
				case "DLO" :
					formObj.d_type3.checked = false;
			}
			break;
		case "d_type4" : 	// Pre-Carriage
			switch (dTypeVal) {
				case "DP" :
				case "TP" :
				case "PO" :
				case "DPO" :
					formObj.d_type4.checked = false;
			}
			break;
		case "d_type5" : 	// On-Carriage
			switch (dTypeVal) {
				case "TO" :
				case "LO" :
				case "PO" :
				case "LPO" :
					formObj.d_type5.checked = false;
			}
			break;
		default : 
			formObj.d_type1.checked = false;
			break;
			
	} // end switch
	
	var newType = declarationCheckValue();
	formObj.d_type.value = (newType == "LP") ? "PL" : newType;
	
	var viewText = new Array();
	
	viewText[0] = "Vessel Name"; 
	viewText[1] = "Barge Name"; 
	
	if(formObj.d_type.value == "P" || formObj.d_type.value == "O") {
		layoutView.innerHTML = viewText[1];
	} else {
		layoutView.innerHTML = viewText[0];
	}
	
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage(dType) {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// Declaraion Init
	initDeclarationType(dType);

	var comboObjMaxLen = comboObjects.length;
	for (i = 0; i < comboObjMaxLen; i++) {
		// IBCombo 초기화
		initCombo(comboObjects[i], i + 1);
	}

	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//axon_event.addListenerForm('click', 'objClick', form );

	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerForm('click', 'obj_click', document.form); // click
	
}

/**
 *  Declaration 필드를 초기화 셋팅한다.<br>
 * @return
 */
function initDeclarationType(dType) {
	
	var formObj = document.form;
	
	if (dType == "D") {
		formObj.d_type1.checked = true;
		formObj.d_type.value = "D"; 
	} else if (dType == "T") {
		formObj.d_type2.checked = true;
		formObj.d_type.value = "T"; 
	} else if (dType == "L") {
		formObj.d_type3.checked = true;
		formObj.d_type.value = "L"; 
	} else if (dType == "P") {
		formObj.d_type4.checked = true;
		formObj.d_type.value = "P"; 
	} else if (dType == "O") {
		formObj.d_type5.checked = true;
		formObj.d_type.value = "O"; 
	} else {
		formObj.d_type1.checked = true;
		formObj.d_type.value = "D"; 
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {

	case "sheet1": // 상단 master 정보
		with (sheetObj) {

			// 높이 설정
			style.height = 100;
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

			// var HeadTitle1 = "| |Harmonized Tariff
			// Code|Description|Category";
			// var HeadTitle1 =
			// "|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no|anr_role_div_cd|ssr_no|ack_rslt_id";
			var HeadTitle1 = "|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|auto_snd_tp_cd|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no" +
					"|anr_role_div_cd|ssr_no|ack_rslt_id|local_db_yn";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "d_type",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vvd_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "port_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_d",			false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_t",			false, "", dfTimeHm, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etd_d",			false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etd_t",			false, "", dfTimeHm, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "brth_yd_cd",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "yd_nm",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "auto_snd_tp_cd",false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_cd",		false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_eng_nm",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "vsl_cnt_cd",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "lloyd_no",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "call_sgn_no",	false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true,"anr_role_div_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "svc_rqst_no",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "ack_rcv_sts_cd",	false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, 	 true, "local_db_yn",	false, "", dfNone, 0, false, false);

			InitViewFormat(0, "eta_d", "yyyymmdd");
			InitViewFormat(0, "eta_t", "hhmm");
			InitViewFormat(0, "etd_d", "yyyymmdd");
			InitViewFormat(0, "etd_t", "hhmm");

			CountPosition = 0;
		}

		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			//style.height = 150;
			style.height = 290;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			// MergeSheet = msAll;
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|merge_bl_no|Sel.|Seq.|bkg_no|B/L No.|POL|POD|CNTR No."
							+"|MVMT\nStatus|Tank\nCNTR|IMO\nClass|UN No.|Substances|Quantity|Package|Weight|Flash Point|Send Type|Msg Snd No|First Msg Snd No"
							+"|DG\nInquiry|Cell Position|Class|Compati\n-bility|UN No.|S.D/G|Flash\nPoint|Package\nGroup|Forwarder\nCode|Carriage\nType|On-Carriage Date|SSR\n(Feeder)|Vessel Name\n(Feeder)|Lloy No\n(Feeder)|VVD\n(Feeder)"
							+"|Outer\nQty|Outer\nCode|EMS|Net Weight|Gross Weight|Packages|Substance|Hazardous Contents|cntr_cgo_seq|in_imdg_pck_qty1|in_imdg_pck_cd1|cntr_tpsz_cd|in_pck_desc|out_pck_desc"
							+"|Sub Label 1|Sub Label 2|Sub Label 3|Sub Label 4|Scr File No|group_cnt|DG_SHORT_NM_CNT|CNTR_CNT|IMDG_UN_NO_SEQ";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	 true, 	"ibflag");
			InitDataProperty(0, cnt++, dtHidden, 		90, daCenter, 	 true, 	"merge_bl_no", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenterTop, true, 	"check");
			InitDataProperty(0, cnt++, dtData, 			30, daCenterTop, true, 	"seq",				false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden,		100,daCenterTop, true, 	"bkg_no",			false,  "", dfNone, 0, false, false, 12);
			InitDataProperty(0, cnt++, dtData, 			100,daCenterTop, true, 	"bl_no",			false,  "", dfNone, 0, false, false, 12);
			InitDataProperty(0, cnt++, dtData, 			50, daCenterTop, true, 	"pol_cd",			false,  "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 			50, daCenterTop, true, 	"pod_cd",			false,  "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 			100,daCenterTop, true,	"cntr_no", 			false,  "", dfNone, 0, false, false, 14);
			
			InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	false,	"cnmv_sts_cd", 		false,  "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	false,	"tnk_cntr_flg", 	false,  "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	false,	"imdg_clss_cd", 	false,  "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			70, daCenter, 	false,	"imdg_un_no", 		false,  "", dfNone, 0, false, false, 4);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft, 	false,	"prp_shp_nm", 		false,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			80, daRight, 	false,	"out_imdg_pck_qty1",false,  "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			200,daLeft,   	false, 	"packages",			false,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			100,daRight, 	false, 	"grs_wgt",			false,  "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, daRight, 	false,	"flsh_pnt_cdo_temp",false,  "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	false,	"send_type",  		false,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			130,daCenter, 	false,	"msg_snd_no",  		false,  "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			110,daCenter, 	false,	"first_msg_snd_no", false,  "", dfNone, 0, false, true);
			

			InitDataProperty(0, cnt++, dtHidden, 		50, daCenter, 	false,  "dg",				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenterTop, true,	"cell_psn_no",	false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtHidden, 		50, daCenter, 	false,	"imdg_clss_cd", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		60, daCenter, 	false,	"imdg_comp_grp_cd", false,  "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 		70, daCenter, 	false,	"imdg_un_no", 		true,  "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtHidden, 		60, daCenter, 	false,	"dg_short_nm", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		50, daRight, 	false,	"flsh_pnt_cdo_temp",false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		60, daCenter, 	false,	"imdg_pck_grp_cd", 	false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtHidden,		80, daCenter, 	false, 	"fwrd_id",			false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 		60, daCenter, 	false, 	"c_type",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 	    120, daCenter, 	true, 	"crr_dt", 			false, "", dfDateYmd, 0, true, true);			

			InitDataProperty(0, cnt++, dtHidden, 		120, daRight, 	false,	"fdr_svc_rqst_no", 	false, "", dfNone, 0, true, true, 14);
			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"fdr_vsl_nm", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"fdr_vsl_lloyd_no", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"fdr_vvd_id", 		false, "", dfNone, 0, true, true, 9);
			
			InitDataProperty(0, cnt++, dtHidden, 		80, daRight, 	false,	"out_imdg_pck_qty1",true,  "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"out_imdg_pck_cd1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		60, daCenter, 	false, 	"ems_no",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		70, daRight, 	false, 	"net_wgt",			false, "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		100, daRight, 	false, 	"grs_wgt",			true,  "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		200,daLeft, 	false, 	"packages",			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		200,daLeft, 	false,	"prp_shp_nm", 		false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		0,  daLeft, 	false, 	"hzd_desc",			false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtHidden, 		0, 	daLeft, 	false,	"cntr_cgo_seq", 	false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 		80, daRight, 	false,	"in_imdg_pck_qty1", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"in_imdg_pck_cd1",  false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"cntr_tpsz_cd",  	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"in_pck_desc",  	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		80, daCenter, 	false,	"out_pck_desc",  	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		95, daCenter, 	false,	"imdg_subs_rsk_lbl_cd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		110, daCenter, 	false,	"scr_file_no", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 		110, daCenter, 	false,	"group_cnt", 		false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"dg_short_nm_cnt", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"cntr_cnt", 		false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, 	false,	"imdg_un_no_seq", 		false, "", dfNone, 0, false, false);
			

			InitDataCombo(0, "c_type", " |TBN|ROAD|RAIL|BARGE|MARINTIME"," |X|T|R|B|V");
			
			InitDataCombo(0, "imdg_pck_grp_cd", " |I|II|III|N", " |1|2|3|N");

			ShowButtonImage = 1;
			
			WaitImageVisible = false;
			
			MultiSelection = false;
			
			CountPosition = 0;

			InitDataValid(0, "bl_no", vtEngUpOther, "0123456789");
			InitDataValid(0, "pol_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "pod_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
			
			InitDataValid(0, "cell_psn_no", vtNumericOnly);
			InitDataValid(0, "imdg_clss_cd", vtNumericOther, ".");
			
			InitDataValid(0, "ems_no", vtEngUpOther, "-, ");
			InitDataValid(0, "fdr_svc_rqst_no", vtNumericOnly);
			
			InitDataValid(0, "out_imdg_pck_cd1", vtEngUpOther, "0123456789");
			InitDataValid(0, "ems_no", vtEngUpOther, "0123456789-, ");

			InitDataValid(0, "packages", vtEngOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			InitDataValid(0, "prp_shp_nm", vtEngOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			InitDataValid(0, "hzd_desc", vtEngOther, "0123456789~!@#$%^&*()-_+={}[]/,.<> ");
			
			InitViewFormat(0, "crr_dt", "yyyymmdd");
			
			InitDataValid(0, "fdr_vvd_id", vtEngUpOther, "0123456789");
			
			
			// 틀고정 설정 (cntr_no)
			FrozenCols = 8;
			
			// 문장이 길경우 ...으로 표시함
			Ellipsis = true;
			
			// 멀티로우 드로우로 선택 설정
			MultiSelection = true;
			
			// Ctrl키를 눌러 다중행을 선택함
			SelectionMode = smSelectionList;

		}
		break;
	}
}

/**
 * Combo Object 초기화
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comNo) {

	// alert("comboObj ID : " + comboObj.id);

	var i = 0;

	switch (comboObj.id) {
		case "reason_resending": {
			i = 0;
	
			with (comboObj) {
				InsertItem(i++, "", "");
				InsertItem(i++, "Mistake in previous notification", "CAM");
				InsertItem(i++, "Operation not carried out", "CAO");
				InsertItem(i++, "Change of dates of stay of truck/train/barge in the port", "CHD");
				InsertItem(i++, "Change of means of transport", "CHM");
				InsertItem(i++, "Change of name of vessel", "CHV");
				InsertItem(i++, "Specify TBN-container", "TBC");
				InsertItem(i++, "Specify TBN-forwarder", "TBF");
				InsertItem(i++, "Specify TBN-vessel/barge name", "TBN");
				
				Code = "";
			}
			break;
		}

	} // end switch

}


/**
 * Sheet관련 프로세스 처리
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction, row, col) {

	sheetObj.ShowDebugMsg = false;
	
	switch (sAction) {
	
		case SEARCH02: // Retrieve버튼 클릭시 조회
	
			if(!validateForm(sheetObj,formObj,sAction))return;
	
			formObj.f_cmd.value = SEARCH02;
			
			ComOpenWait(true);
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0577GS.do", FormQueryString(formObj));
			ComOpenWait(false);
	
			var arrXml = sXml.split("|$$|");
	
			formObj.cntr_cnt.value = ""; // Total Container 필드 초기화
			
//			var sentStatus = ComGetEtcData(arrXml[0], "ediSentStatus");
	
			if (ComBkgErrMessage(sheetObj, sXml)) {
				
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
	
				for ( var i = 1; i <= sheetObjects[1].Rows; i++) {						
					
					if(sheetObjects[1].cellValue(i,"msg_snd_no") != ""){							
						sheetObjects[1].CellBackColor(i,"seq") = sheetObjects[1].RgbColor(200,255,200);
						sheetObjects[1].CellBackColor(i,"bkg_no") = sheetObjects[1].RgbColor(200,255,200);
						sheetObjects[1].CellBackColor(i,"bl_no") = sheetObjects[1].RgbColor(200,255,200);
						sheetObjects[1].CellBackColor(i,"pol_cd") = sheetObjects[1].RgbColor(200,255,200);
						sheetObjects[1].CellBackColor(i,"pod_cd") = sheetObjects[1].RgbColor(200,255,200);
						sheetObjects[1].CellBackColor(i,"cntr_no") = sheetObjects[1].RgbColor(200,255,200);
					}

				}
				
				if (sheetObjects[1].RowCount > 0) {
					// 조회된 컨테이너 Total Count를 setting한다.
					formObj.cntr_cnt.value = sheetObjects[1].CellValue(1,"cntr_cnt");
				}
				
			}
	
			IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
			if (sheetObjects[0].RowCount == 1) {
	
				formObj.frm_eta_d.value = ComGetMaskedValue(
						formObj.frm_eta_d.value, "ymd");
				formObj.frm_eta_t.value = ComGetMaskedValue(
						formObj.frm_eta_t.value, "hm");
				formObj.frm_etd_d.value = ComGetMaskedValue(
						formObj.frm_etd_d.value, "ymd");
				formObj.frm_etd_t.value = ComGetMaskedValue(
						formObj.frm_etd_t.value, "hm");
			}
	
			// 조회 조건 값을 hidden으로 저장해 둔다.
			setSearchCond(sheetObjects[1], formObj);
	
			break;
	
		case IBDOWNEXCEL: // 엑셀
			
			if(!validateForm(sheetObj,formObj,sAction))return;
			
			ComOpenWait(true);
			sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "check");
			ComOpenWait(false);

			break;
	
		case MULTI01: // Flat File 생성 및 EDI전송
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
				//ComShowMessage("변경된 데이타가 있습니다. 먼저 저장 후 전송해 주세요!");
				ComShowCodeMessage('BKG06098');
				return;
			}
			
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			formObj.f_cmd.value = MULTI01;
			formObj.trans_type.value = "ORIGIN_SEND";
	
			if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
            	// send type 조회시 상태로 초기화
//            	initSearchValue(sheetObjects[1], "send_type", "AC");
            	sheetObjects[1].CheckAll2("check") = 0;
				return false;
            }

			var rowCnt = sheetObjects[1].RowCount;
			
			for(var i=1; i<=rowCnt; i++) {
				if(sheetObjects[1].CellValue(i, "check") == "1") {
					sheetObjects[1].RowStatus(i) = "I";
				} else {
					sheetObjects[1].RowStatus(i) = "";
				}
			}

			var sParam = "";
			
			var sParamSheet = sheetObjects[1].GetSaveString();

			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
			}
			
			sParam += "&" + FormQueryString(formObj);
			
			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0577GS.do", sParam);
			sheetObjects[1].LoadSaveXml(sXml);
			ComOpenWait(false);
			
			formObj.output1.value = sheetObjects[1].EtcData("originalFlatFile");
			formObj.output2.value = sheetObjects[1].EtcData("updateFlatFile");
			formObj.output3.value = sheetObjects[1].EtcData("cancelFlatFile");

			doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
			
			break;

		case MULTI02: // Flat File 생성 및 EDI전송(CANCEL 전송)
			
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
				ComShowCodeMessage('BKG06098');
				return;
			}

			if(!validateForm(sheetObj,formObj,sAction))return;
			
			formObj.f_cmd.value = MULTI01;
			formObj.trans_type.value = "CANCEL_SEND";
			
   			if(!ComShowConfirm(ComGetMsg("BKG95003", "[EDI Cancel Transmit]"))) {
            	return false;
            }
			
			var sParam = "";
			
            var rowCnt = sheetObjects[1].RowCount;
			
			for(var i=1; i<=rowCnt; i++) {
				if(sheetObjects[1].CellValue(i, "check") == "1") {
					sheetObjects[1].RowStatus(i) = "I";
				} else {
					sheetObjects[1].RowStatus(i) = "";
				}
			}
			
			var sParamSheet = sheetObjects[1].GetSaveString();
	
			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
	
			}
	
			if (sParam == "") {
				ComShowCodeMessage('BKG00743');
				return;
			}
	
			sParam += "&" + FormQueryString(formObj);

			ComOpenWait(true);
			var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0577GS.do", sParam);
			sheetObjects[1].LoadSaveXml(sXml);
			ComOpenWait(false);
			
			formObj.output1.value = sheetObjects[1].EtcData("originalFlatFile");
			formObj.output2.value = sheetObjects[1].EtcData("updateFlatFile");
			formObj.output3.value = sheetObjects[1].EtcData("cancelFlatFile");
			
			doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
			
			break;
			
	}
	
}

/**
 * sheet 필드중 send_type = "AC" 인 로우를 대상으로 send_type, msg_snd_no를 조회시 값으로 되돌린다.
 * @param sheetObj
 * @param colName
 * @param targetValue
 * @return
 */
//function initSearchValue(sheetObj, colName, targetValue) {
//	var rowCnt = sheetObj.RowCount;
//	
//	// send type 조회시 상태로 초기화
//	ComOpenWait(true);
//	for(var i=1; i<=rowCnt; i++) {
//		if(sheetObj.CellValue(i,"send_type") == targetValue) {
//			sheetObj.CellValue2(i,"send_type") = sheetObj.CellSearchValue(i,"send_type");
//			sheetObj.CellValue2(i,"msg_snd_no") = sheetObj.CellSearchValue(i,"msg_snd_no");
//		}
//	}
//	ComOpenWait(false);
//}

/**
 * 다중 저장시 PREFIX 붙여주기
 * 
 * @param sStr
 * @param sPrefix
 * @return
 */
function ComSetPrifix(sStr, sPrefix) {
	if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
		return sStr;
	}

	var regexp = RegExp(/&/g);
	sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
	return sStr;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {

		case SEARCH02:
//			if(document.getElementById("p_pod_cd").className == "input1" && formObj.p_pod_cd.value == ""){
//				ComShowCodeMessage('BKG01101', "POD Code");
//				return false;
//			}else if(document.getElementById("p_pol_cd").className == "input1" && formObj.p_pol_cd.value == ""){
//				ComShowCodeMessage('BKG01101', "POL Code");
//				return false;
//			}
			
			// 기본포멧체크
			if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
			break;
			
		case SEARCH04:
			// 기본포멧체크
			if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd)  ) return false;
			break;
			
		case SEARCH01:
//		case SEARCH03:
		case SEARCH05:
			if(formObj.d_type.value != "" && formObj.vvd_cd.value != "")  {
				//기본포멧체크
				if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) ) return false;
			}
			break;
			
		case IBDOWNEXCEL:
			if(sheetObj.RowCount == 0) {
        		ComShowCodeMessage('BKG00109');
        		return false;
			}
			
			break;
			
		case MULTI01 :
		case MULTI02 : //Flat File 생성 및 EDI전송(CANCEL 전송 포함) validation
			
			var sheet1RowCnt = sheetObjects[1].RowCount;
			
			if(sheet1RowCnt == 0) {
        		//ComShowMessage("전송할 데이타가 없습니다.");
        		ComShowCodeMessage("BKG01096");
        		return false;
			}
			
			// 조회시 사용된 조회조건 값이 변경된게 있는지 확인한다.
			if(formObj.hid_d_type.value != formObj.d_type.value ||
					formObj.hid_vvd_cd.value != formObj.vvd_cd.value  ) {
				ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value, formObj.d_type.value+","+formObj.vvd_cd.value);
				return false;
			}

			var currBlNo = "";
			var preBlNo = "";
			var checkCnt = 0;
			var cancelCheckCnt = 0;
			var firstCheckCnt = 0;
			var updateCheckCnt = 0;
			
	        for(var i=1; i <= sheet1RowCnt; i++) {
	        	
	        	if(sheetObj.CellValue(i, "check") == "1") {
			
		    		if(sAction == MULTI02 && sheetObj.CellValue(i, "send_type") == "") {
		    			//ComShowMessage("선택한 B/L No.중 최초전송 B/L No.가 있습니다.");
		    			ComShowCodeMessage("BKG06096");
		    			sheetObj.SelectRow = i;
			        	return false;
		    		}
		    		
		    		
		    		if(sAction == MULTI02 && sheetObj.CellValue(i, "send_type") == "C") {
		    			//ComShowMessage("선택한 B/L No.중 이미 Cancel 전송한 B/L No.가 있습니다.");
		    			ComShowCodeMessage("BKG06097", sheetObj.CellValue(i, "bl_no"));
		    			sheetObj.SelectRow = i;
			        	return false;
		    		}
	        	}
	        }

			break;
	
	} // end switch

	return true;
}

/**
 * 조회 조건 값을 hidden으로 저장해 둔다.
 * (save버튼 클릭시 조회조건이 변경 되는것을 막기위해 사용)
 * @param sheetObj
 * @param formObj
 * @return
 */
function setSearchCond(sheetObj, formObj) {
	
	if(sheetObj.RowCount > 0) {
		formObj.hid_d_type.value = formObj.d_type.value;
		formObj.hid_vvd_cd.value = formObj.vvd_cd.value;
	}
}

/**
 * 같은 first_msn_snd_no 그룹별로 체크박스를 체크한다.<br>
 * 
 * @param autoCancelFlag
 * @param confirmMsgCode
 * @return
 */
function groupCheck(autoCancelFlag, confirmMsgCode) {
	
	var currBlNo = "";
	var preBlNo = "";
	var subCurrBlNo = "";
	var subPreBlNo = "";
	var msgSndNo = "";
	var subMsgSndNo = "";
	var firstMsgSndNo = "";
	var subFirstMsgSndNo = "";

	var groupCnt = 0;
	var sheetObj = sheetObjects[1]
	var sheet1RowCnt = sheetObj.RowCount;
	
	var bLList = "";
	
	var sendType = "";
	var subSendType = "";
	
	
	for(var i=1; i <= sheet1RowCnt; i++) {
     	currBlNo = sheetObj.CellValue(i, "bl_no");
     	
    	if(currBlNo == preBlNo) continue;

    	if(sheetObj.CellValue(i, "check") == "1") {
    		firstMsgSndNo = sheetObj.CellValue(i, "first_msg_snd_no");
    		sendType = sheetObj.CellValue(i, "send_type");
    		msgSndNo = sheetObj.CellValue(i, "msg_snd_no");

    		subCurrBlNo = "";
    		subPreBlNo  = "";
    		// 현재 기준 이후 check
    		for(var j=i ; j<=sheet1RowCnt; j++) {
    			
    			subCurrBlNo = sheetObj.CellValue(j, "bl_no");
    			subSendType = sheetObj.CellValue(j, "send_type");
    			
    			if(sendType == "C") {
    				continue;
    			}
    			
    			subFirstMsgSndNo = sheetObj.CellValue(j, "first_msg_snd_no");
        		//alert("after" + "\nsubCurrBlNo : "+ subCurrBlNo + "\nfirstMsgSndNo : " + firstMsgSndNo + "\nsubFirstMsgSndNo : " + subFirstMsgSndNo);

    			if(subFirstMsgSndNo != "" && firstMsgSndNo == subFirstMsgSndNo) {
    				if(sheetObj.CellValue(j, "check") == "0") {

    					sheetObj.CellValue2(j, "check") = 1;
    				}
    			} else {
    				continue;
    			}
    			subPreBlNo = subCurrBlNo; 
    		} // end for(j)

    		subCurrBlNo = "";
    		subPreBlNo  = "";
    		subFirstMsgSndNo = "";
    		// 현재 기준 이전 check
    		for(var j=i ; j>0; j--) {
    			
    			subCurrBlNo = sheetObj.CellValue(j, "bl_no");
    			subSendType = sheetObj.CellValue(j, "send_type");
    			
    			if(sendType == "C") {
    				continue;
    			}    			
    			
    			subFirstMsgSndNo = sheetObj.CellValue(j, "first_msg_snd_no");
        		//alert("before" + "\nsubCurrBlNo : "+ subCurrBlNo + "\nfirstMsgSndNo : " + firstMsgSndNo + "\nsubFirstMsgSndNo : " + subFirstMsgSndNo);
    			
    			if(subFirstMsgSndNo != "" && firstMsgSndNo == subFirstMsgSndNo) {
    				if( sheetObj.CellValue(j, "check") == "0") {
    					sheetObj.CellValue2(j, "check") = 1;
    				}
    			} else {
    				continue;
    			}    
    			subPreBlNo = subCurrBlNo; 
    		} // end for(j)
    	}
    	
    	
    	preBlNo = currBlNo;
	 } // end for(i)
	
	
	return true;
}

/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function obj_change() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
//	if(srcName == "p_bound_cd"){
//		var frobs = formObject.elements("p_bound_cd");
//		for (i = 0; i < frobs.length; i++) {
//			if (frobs[i].checked) {
//				if (frobs[i].value == "I") {
//					formObject.p_pol_cd.value = "";
//					formObject.p_pod_cd.value = "I";
//				} else {
//					formObject.p_pod_cd.value = "";
//					formObject.p_pol_cd.value = "O";
//				}
//	
//			}
//		}
//	}
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "vvd_cd"  && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
//	if (srcName == "p_pol_cd" || srcName == "p_pod_cd") {
//		selectPortCd();
//	}
}

/**
 * 시트를 클릭했을 때 처리
 */
function sheet2_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "check");
	var mergeBlNo = sheetObj.CellValue(row, "merge_bl_no");
//	var firstMsgSndNo = sheetObj.CellValue(row, "first_msg_snd_no");
	var selectedMsgSndNo = sheetObj.CellValue(row, "first_msg_snd_no");
	var colSaveName = sheetObj.ColSaveName(col);

	/* Row Focus 색상 및 글자  기본값으로 변경 */
	sheetObj.SelectFontBold  = false;
	sheetObj.SelectBackColor = "16186087";
	
	switch(colSaveName) {
		/* 긴 문자열 MemoPad 처리*/
		case "packages" :
		case "prp_shp_nm" :
		case "hzd_desc" :
			ComShowMemoPad(sheetObj, null, null, true, 250, 80);
			break;
			
		/* Check Box 클릭시 머리클릭 처리*/
		case "check" :
			for ( var i = 1; i <= rowCnt; i++) {
				
				var sendType = sheetObj.CellValue(i, "send_type");
				if (check == 1) {
					if (i == row ) continue;
					if (mergeBlNo == sheetObj.CellValue(i, "merge_bl_no")) {
						sheetObj.CellValue2(i, "check") = 0;
					}
					
					if (selectedMsgSndNo == sheetObj.CellValue(i, "first_msg_snd_no")) {
						if(selectedMsgSndNo == "" || sendType == "C") continue;
						sheetObj.CellValue2(i, "check") = 0;
					}
					
					
				} else if (check == 0) {
					if (i == row ) continue;
					if (mergeBlNo == sheetObj.CellValue(i, "merge_bl_no")) {
						sheetObj.CellValue2(i, "check") = 1;
					}
					
					if (selectedMsgSndNo == sheetObj.CellValue(i, "first_msg_snd_no")) {
						if(selectedMsgSndNo == "" || sendType == "C") continue;
						sheetObj.CellValue2(i, "check") = 1;
					}
					
				}
			} // end for(i)
			break;
			
	} // end switch
}

/**
 * sheet2 Change 이벤트
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	
	var rowCnt = sheetObj.RowCount;
	var colSaveName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	
	
}	

/**
 * form object 클릭 이벤트를 처리한다.<br>
 * @param {void}
 * @return void
 * @author Park SungJin
 * @version 2011.10.06
  */
function obj_click() {
     var objName = event.srcElement.name;
     var formObject = document.form;
     switch(objName) {
// 	    case "p_bound_cd":
// 	    	with(formObject) {
// 	           if(p_bound_cd[0].checked == true) {
//  	        	  formObject.p_pol_cd.disabled    = true;
// 	        	  formObject.p_pod_cd.disabled    = false;
// 	        	  document.getElementById("p_pol_cd").className = "input2";
// 	        	  document.getElementById("p_pod_cd").className = "input1";
// 	        	  selectPortCd();
// 	           }else if(p_bound_cd[1].checked == true){
//   	        	  formObject.p_pol_cd.disabled    = false;
// 	        	  formObject.p_pod_cd.disabled    = true;
// 	        	  document.getElementById("p_pod_cd").className = "input2";
// 	        	  document.getElementById("p_pol_cd").className = "input1";
// 	        	  selectPortCd();
// 	           }
//     		}
// 	    	break;
     }
}
 
 /**
  * Bound 조건에 따라 Port Code를 세팅한다.<br>
  * @param {void}
  * @return void
  * @author Park SungJin
  * @version 2011.10.06
   */
 function selectPortCd() {
//      var formObject = document.form;
//      var pPolCd = formObject.p_pol_cd.value;
//      var pPodCd = formObject.p_pod_cd.value;
//      if(formObject.p_bound_cd[0].checked == true){
//    	  formObject.port_cd.value = pPodCd;
//      }else if(formObject.p_bound_cd[1].checked == true){
//    	  formObject.port_cd.value = pPolCd;
//      }
 }