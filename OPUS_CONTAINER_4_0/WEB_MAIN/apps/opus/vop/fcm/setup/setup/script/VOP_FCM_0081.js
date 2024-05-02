/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0081.js
 *@FileTitle : Vessel Registration
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.01.02
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2012.04.19 진마리아 CHM-201217192-01 Vessel Registration내 선박 추가 로직 변경 요청건
 * 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
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
 * @class VOP_FCM_0011 : VOP_FCM_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0081() {
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

//grid combo
var comboText = "Y|N";
var comboCode = "Y|N"

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_Delete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;
			
		case "btns_calendarto":
			var cal = new ComCalendar();
			cal.select(formObject.to_stk_jb_dt, 'yyyy-MM-dd');
			break;
			
		case "btn_vslpop":
			openVslCdHelp(sheetObject);
			break;
			
		case "btn_Row_Add":
			sheetObject.DataInsert(-1);
			break;
			
		case "btn_New":
			clearAll();
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
 /**
  * Vessel Code Help 파일을 오픈한다
  */
 function openVslCdHelp(sheetObj){
 	var sUrl = "VOP_VSK_0219.do?vsl_cd="+document.form.vsl_cd.value+"&inc_del_vsl_pop=Y";
 	ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
 }
 function getVslCdData(obj){
		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value = rtnDatas[1];
				}
			}
		}
	}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
		
	}
	initControl();
	document.form.vsl_cd.focus();
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
	axon_event.addListener('keypress', 'eng_keypress', 'vsl_cd', 'vsl_eng_nm', 'crr_cd', 'call_sgn_no', 'lloyd_no'); // 영문 대문자만 입력하기
	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'crr_cd');

}

function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;

	switch (event.srcElement.name) {
	case "vsl_cd":
		if(val.length==4){
			sheetObj = sheetObjects[0];
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function eng_keypress() {
	var obj = event.srcElement;
	switch (obj.name) {
	case "vsl_eng_nm":
		
		// CHM-201005418-01
		// 특수키(-, <, >, ., /, ', (, ), &, #) 입력되도록 수정
		var availKeyCode = "";
		if (event.keyCode === 32 // 공백입력가능
				|| event.keyCode === 45 // - 입력가능
				|| event.keyCode === 60 // < 입력가능
				|| event.keyCode === 62 // > 입력가능
				|| event.keyCode === 46 // . 입력가능
				|| event.keyCode === 47 // / 입력가능
				|| event.keyCode === 39 // ' 입력가능
				|| event.keyCode === 40 // ( 입력가능
				|| event.keyCode === 41 // ) 입력가능
				|| event.keyCode === 38 // & 입력가능
				|| event.keyCode === 35 // # 입력가능
				) {
			availKeyCode = String(event.keyCode); 
		}
		ComKeyOnlyAlphabet('uppernum', availKeyCode);
		break;
	case "vsl_cd":
	case "call_sgn_no":
		ComKeyOnlyAlphabet("uppernum");
		break;
	case "lloyd_no":
		ComKeyOnlyAlphabet("uppernum", "46"); // 영대문자, 숫자, 마침표 입력가능
		break;
	default:
		ComKeyOnlyAlphabet('upper');
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 444;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|SEL|Vessel\nCD|Vessel's\nFull\nName|Owners|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Dead\nWeight|Gross\nTon|Net|IMO No.|Design\nCapa|Class\nSub Code|Trend\nLine\n(Y/N)|Main Engine|Main Engine|Main Engine|Turbo-Charger|Turbo-Charger|Turbo-Charger|Turbo-Charger|Turbo-Charger|Spare Aux.blower|Spare Aux.blower|Spare Aux.blower|Saving Item|Saving Item|G/E\nConsumption\n(Day)|Maneuvering\nConsumption\n(Day)|Tank Capacity|Tank Capacity|Tank Capacity|Tank Capacity|Operational\nSpeed|Operational\nSpeed|Operational\nSpeed";
			var HeadTitle2 = "||Vessel\nCD|Vessel's\nFull\nName|Owners|Built|Max|14Ton|From|To|Dead\nWeight|Gross\nTon|Net|IMO No.|Design\nCapa|Class\nSub Code|Trend\nLine\n(Y/N)|Maker|Type|Power|No. of\nT/C|Maker|Type|Max\nRPM|Cut-off|No. of\nSpare.\nBLW|Maker|Type|Fuel\nAdditive|Hull\nPaint|G/E\nConsumption\n(Day)|Maneuvering\nConsumption\n(Day)|Full\n(㎥)|Full\n(MT)|TSERV/SETT\n(MT)|93%\n(MT)|Max|Min|Running\nAux. BLW\n&BLR"
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			sheetObj.FrozenCols = 3;
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtDelCheck,		25,		daCenter,	true,	"del_chk",					false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"vsl_cd",					false,	"",			dfEngUpKey,			0,			false,		true,4);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"vsl_eng_nm",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ownr_nm",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"vsl_bld_dt",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	"vsl_dznd_capa",			false,	"",			dfNullInteger,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	"bse_14ton_vsl_capa",		false,	"",			dfNullInteger,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"fm_dt",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"to_dt",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dwt_wgt",					false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"grs_rgst_tong_wgt",		false,	"",			dfNullInteger,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"net_rgst_tong_wgt",		false,	"",			dfNullInteger,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"lloyd_no",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"cntr_vsl_clss_capa",		false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"vsl_clss_sub_cd",			false,	"",			dfNone,			0,			true,		true,50,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"trnd_line_use_flg",		false,	"",			dfNone,			0,			true,		true,1);
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,	"mn_eng_mkr_nm",			false,	"",			dfNone,			0,			true,		true,50,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,	"mn_eng_tp_desc",			false,	"",			dfNone,			0,			true,		true,100,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"mn_eng_rpm_pwr",			false,	"",			dfNone,			0,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,	"tbcgr_no",					false,	"",			dfNone,			0,			true,		true,5);
			InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"tbcgr_mkr_nm",				false,	"",			dfNone,			0,			true,		true,50);
			InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"tbcgr_tp_desc",				false,	"",			dfNone,			0,			true,		true,100);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,	"tbcgr_rpm_pwr",				false,	"",			dfNone,			0,			true,		true,6);
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"tbcgr_coff_flg",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,	"spr_aux_blw_no",				false,	"",			dfNone,			0,			true,		true,4);
			InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,	"spr_aux_blw_mkr_nm",		false,	"",			dfNone,			0,			true,		true,50);
			
			InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,	"spr_aux_blw_tp_desc",		false,	"",			dfNone,			0,			true,		true,100);
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"foil_adtv_cd",				false,	"",			dfNone,			0,			true,		true,1);
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"hl_pnt_cd",				false,	"",			dfNone,			0,			true,		true,1);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"gnr_csm_wgt",				false,	"",			dfNone,			0,			true,		true,16);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"mnvr_csm_wgt",				false,	"",			dfNone,			0,			true,		true,16);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"foil_tnk_cbm_capa",		false,	"",			dfNone,			0,			true,		true,21);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"foil_tnk_mt_capa",			false,	"|foil_tnk_cbm_capa|*0.95",			dfNullFloat,			2,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,	"foil_stl_svc_tnk_mt_capa",	false,	"",			dfNone,			0,			true,		true,21);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,	"foil_stl_percent_mt_capa",	false,	"|foil_tnk_cbm_capa|-|foil_stl_svc_tnk_mt_capa|",			dfNullFloat,			2,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"op_max_spd",				false,	"",			dfNone,			0,			true,		true,8);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,	"op_min_spd",				false,	"",			dfNone,			0,			true,		true,8);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,	"op_gnr_spd",				false,	"",			dfNone,			0,			true,		true,8);
			
			InitDataCombo(0, "tbcgr_coff_flg", comboText, comboCode);
			InitDataCombo(0, "vsl_clss_sub_cd", " |A|B|C|D|E", " |A|B|C|D|E");
			InitDataCombo(0, "foil_adtv_cd", " |A|B|C|D|E", " |A|B|C|D|E");
			InitDataCombo(0, "hl_pnt_cd",   " |A|B|C|D|E", " |A|B|C|D|E");
			InitDataCombo(0, "trnd_line_use_flg",   "Y|N", "Y|N");
			
			InitDataValid(0, "mn_eng_rpm_pwr",   vtNumericOther,".");	
			InitDataValid(0, "tbcgr_no",    vtNumericOnly);	
	
			InitDataValid(0, "tbcgr_rpm_pwr",   vtNumericOther,".");
			InitDataValid(0, "spr_aux_blw_no",   vtNumericOnly);
		
			InitDataValid(0, "gnr_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0, "foil_tnk_cbm_capa",   vtNumericOther,".");
			InitDataValid(0, "foil_stl_svc_tnk_mt_capa",   vtNumericOther,".");	
			InitDataValid(0, "op_max_spd",   vtNumericOther,".");	
			InitDataValid(0, "op_min_spd",   vtNumericOther,".");
			InitDataValid(0, "op_gnr_spd",   vtNumericOther,".");
			
			InitDataValid(0, "vsl_cd", vtEngUpOther, "0123456789");
			
			RowHeight(0) = 30;
			RowHeight(1) = 41;
			
			CountPosition = 2;
		}
		break;
		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
	//	if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0081GS.do",
					FormQueryString(formObj));
			sheetObj.LoadSearchXml(rXml);
			ComOpenWait(false);
	//	}
		break;

	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
			var SaveStr = ComGetSaveString(sheetObjects);
			var sXml = sheetObj.GetSaveXml("VOP_FCM_0081GS.do", SaveStr + "&" + FormQueryString(formObj));
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComOpenWait(false);
		}
		break;

	case IBDELETE:
		ComOpenWait(true);
		formObj.f_cmd.value = REMOVE;
		var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
		var SaveStr = ComGetSaveString(sheetObjects);
	    var sXml = sheetObj.GetSaveXml("VOP_FCM_0081GS.do", SaveStr + "&" + FormQueryString(formObj));
	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		ComOpenWait(false);
		break;
			
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH:
			
		break;
		
		case IBSAVE:
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "ibflag")!="R" && sheetObj.CellValue(i, "vsl_cd")==""){
					ComShowMessage("Please check "+i+"th row");
					return false;
				}
			}
		break;
	}
	return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	switch (sheetObj.ColSaveName(Col)) {
		case "vsl_cd" :
			if(Value!=""){
				var formObj = document.form;				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("VOP_FCM_0081GS.do?vsl_cd="+Value+"&f_cmd="+formObj.f_cmd.value);
				var fcmExist = ComGetEtcData(sXml, "fcm_exist");
				if(fcmExist=="Y"){
					ComShowMessage("This vessel info was already existed.");
					sheetObj.CellValue2(Row, Col)="";
					sheetObj.SelectCell(Row, Col, true);
					sheetObj.CellValue(Row, "vsl_eng_nm")="";
					sheetObj.CellValue(Row, "dwt_wgt")="";
					sheetObj.CellValue(Row, "grs_rgst_tong_wgt")="";
					sheetObj.CellValue(Row, "net_rgst_tong_wgt")="";
					sheetObj.CellValue(Row, "lloyd_no")="";
					sheetObj.CellValue(Row, "cntr_vsl_clss_capa")="";
				}else{
					var mdmExist = ComGetEtcData(sXml, "mdm_exist");
					if(mdmExist=="N"){
						ComShowMessage("This vessel doesn't exist in MDM or isn't appropriate.");
						sheetObj.CellValue2(Row, Col)="";
						sheetObj.SelectCell(Row, Col, true);
						sheetObj.CellValue(Row, "vsl_eng_nm")="";
						sheetObj.CellValue(Row, "dwt_wgt")="";
						sheetObj.CellValue(Row, "grs_rgst_tong_wgt")="";
						sheetObj.CellValue(Row, "net_rgst_tong_wgt")="";
						sheetObj.CellValue(Row, "lloyd_no")="";
						sheetObj.CellValue(Row, "cntr_vsl_clss_capa")="";
					}else{
						if(mdmExist=="C"){
							ComShowMessage("This Vessel Code is not HJS operation and please check it again.");
						}
						var data = ComGetEtcData(sXml, "data");
						var dataItem = data.split("");
						sheetObj.CellValue(Row, "vsl_eng_nm")=dataItem[0];
						sheetObj.CellValue(Row, "dwt_wgt")=dataItem[1];
						sheetObj.CellValue(Row, "grs_rgst_tong_wgt")=dataItem[2];
						sheetObj.CellValue(Row, "net_rgst_tong_wgt")=dataItem[3];
						sheetObj.CellValue(Row, "lloyd_no")=dataItem[4];
						sheetObj.CellValue(Row, "cntr_vsl_clss_capa")=dataItem[5];
												
						sheetObj.CellValue(Row, "ownr_nm")=dataItem[6];
						sheetObj.CellValue(Row, "vsl_bld_dt")=dataItem[7];
						sheetObj.CellValue(Row, "vsl_dznd_capa")=dataItem[8];
						sheetObj.CellValue(Row, "bse_14ton_vsl_capa")=dataItem[9];
						sheetObj.CellValue(Row, "fm_dt")=dataItem[10];
						sheetObj.CellValue(Row, "to_dt")=dataItem[11];
					}
				}
				ComOpenWait(false);
			}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	notifyUnregFleetVessl(sheetObj);
}

/*
 * Fleet Management에 등록되지 않는 Vessel을 notify 한다.
 */
function notifyUnregFleetVessl(sheetObj){
	var list = new Array();
	var start = sheetObj.HeaderRows;
	var end = start + sheetObj.SearchRows;
	for(var k=start; k<end; k++){
		if(sheetObj.CellValue(k, "ownr_nm")==""){
			list.push(sheetObj.CellValue(k, "vsl_cd"));
		}
	}
	if(list.length>0){
		ComShowMessage("***** Unregistered Vessel *****\n" + list.join("\t"));
	}
}

function clearAll(){
	document.form.vsl_cd.value="";
	sheetObjects[0].RemoveAll();
}

/* 개발자 작업 끝 */