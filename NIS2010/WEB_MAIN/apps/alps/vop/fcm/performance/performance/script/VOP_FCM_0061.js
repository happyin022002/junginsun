/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0061.js
 *@FileTitle : 화면명
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.18
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.03.08 [선반영] Saving Ratio 에 대한 % 처리
 * 2012.07.18 이혜민 [CHM-201219005-01] fuel_adt 컬럼명 fuel_adtv 로 수정
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
 * @class VOP_FCM_0061 : VOP_FCM_0061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0061() {
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

var isExist = "";
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

		case "btn_Calculation":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_month":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObj.sav_cost_cre_yrmon, 'yyyy-MM');
			break;
			
		case "btns_search":
			openLandCdHelp(sheetObj);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			
		case "btn_New":
			clearAll();
			break;
			
		case "btn_Down_Excel":
			sheetObj.Down2Excel(-1);
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
 * Lane Code Help 파일을 오픈한다
 */
function openLandCdHelp(sheetObj){
   var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
   var v_display = "0,0";
   var laneCd = document.form.vsl_slan_cd.value;
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);

}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

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
	axon_event.addListenerForm('keypress', 'obj_keypress', formObj);
	axon_event.addListenerForm("change", "obj_change", formObj);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);

}

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;

	switch (event.srcElement.name) {
	
	case "vsl_slan_cd":
		
	break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	
	var prefix = sheetObj.id + "_";
	sheetObj.prefix = prefix;

	switch (sheetNo) {
	case 1: // sheet1 init
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
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode(true, true, true, true, false, false)
			  InitHeadMode(true, true, false, true, false,false);
			var HeadTitle = "|Target\nMonth|Design\nCapa|VVD|Lane|Departure\nPort|Sea\nDistance|Sea\nSpeed|RPM|ENG.\nLoad|FOC\n(Day)|FOC\nCost|Saving\nRatio|Saving\nQ'ty|Saving\nCost|DEP.\nFOC\nQ'ty|Additive\nConsumption\nQ'ty|Additive\nUnit Price|Additive\nCost|Cost\n(DEP.)|순수\n절감액|itm_csm_rto|itm_ut_prc|||||||CLPT_IND_SEQ|"; 
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);


			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus, 100,daCenter,	false,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix+"sav_cost_cre_yrmon",		false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix+"vsl_clss_cd",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	false,	prefix+"vvd",						false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix+"vsl_slan_cd",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	prefix+"vps_port_cd",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	prefix+"nvgt_dist",					false,	"",	dfNullInteger,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,		    80,	daRight,	false,	prefix+"avg_spd",					false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	prefix+"avg_rpm_pwr",				false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtData,		    80,	daRight,	false,	prefix+"lod_ind_qty",				false,	"",	dfNullFloat,	2,	true,		false, 8);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	prefix+"foil_csm_wgt",				false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	prefix+"foil_csm_cost_amt",			false,	"",	dfNullFloat,	1,	false,		false);
//			InitDataProperty(0, cnt++ , dtData,		    80,	daRight,	false,	prefix+"sav_rto",					false,	"",	dfNullFloat,	4,	false,		false);
			InitDataProperty(0, cnt++ , dtData,		    80,	daRight,	false,	prefix+"sav_rto",					false,	"",	dfUserFormat,	2,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	prefix+"sav_qty",					false,	"",	dfNullFloat,	2,	false,		false);
			InitDataProperty(0, cnt++ , dtData,		    80,	daRight,	false,	prefix+"sav_cost_amt",				false,	"",	dfNullFloat,	2,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	false,	prefix+"port_pair_sea_foil_csm_wgt",false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daRight,	false,	prefix+"fuel_adtv_csm_wgt",			false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,	    80,	daRight,	false,	prefix+"fuel_adtv_uc_amt",			false,	"",	dfNullFloat,	2,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daRight,	false,	prefix+"fuel_adtv_csm_cost_amt",		false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,	    80,	daRight,	false,	prefix+"fuel_adtv_dep_csm_cost_amt",	false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daRight,	false,	prefix+"fuel_adtv_sav_cost_amt",		false,	"",	dfNullFloat,	1,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"itm_csm_rto",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"itm_ut_prc",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"sav_rto_n1st",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"sav_rto_n2nd",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"sav_rto_cons",				false,	"",	dfNone,			0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"sav_itm_cd",			false,	"",	dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"vsl_cd",					false,	"",	dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"skd_voy_no",				false,	"",	dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"skd_dir_cd",				false,	"",	dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	false,	prefix+"clpt_ind_seq",				false,	"",	dfNone,		0,	false,		false);
		
//			InitDataValid(0, prefix+"lod_ind_qty", vtNumericOther, "."); 
			InitUserFormat(0, prefix+"sav_rto", "###,###.##%", "%");
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
		if (validateForm(sheetObj, formObj, sAction)) {
			var aryPrefix = new Array( "sheet1_" );
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0061GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			isExist = ComGetEtcData(rXml, "is_exist");
			if(isExist=="Y"){
				ComShowMessage("This cost was already created.");
			}
			sheetObj.LoadSearchXml(rXml);
		}
		break;

	case SEARCH01: // lane code check
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			ComOpenWait(true);
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0061GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var vslSlanCd = ComGetEtcData(rXml, "vsl_slan_cd");
			if(vslSlanCd==""){
				ComShowMessage(formObj.vsl_slan_cd.value + " doesn't exist.");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
			}
		}
		break;
	
	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			ComOpenWait(true);
			var aryPrefix = new Array("sheet1_");		
			var sXml = sheetObj.GetSaveXml("VOP_FCM_0061GS.do", ComGetSaveString(sheetObj) + "&"+FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
				ComShowCodeMessage("COM130102", "Data");
				sheetObj.LoadSaveXml(sXml);
			}
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	switch(sAction){
		case IBSEARCH:
			var savCostCreYrmon = formObj.sav_cost_cre_yrmon.value;
			var vslSlanCd = formObj.vsl_slan_cd.value;
			if(ComChkLen(savCostCreYrmon, 7)!=2){
				ComShowMessage("Please check, Month");
				formObj.sav_cost_cre_yrmon.focus();
				return false;
			}
			break;
			
		case IBSAVE:
			break;
	}
	return true;
}
 
 /*
  * 조회 후처리
  */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
 	var prefix="sheet1_";
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		calculate(sheetObj, i, "N");
	}
	ComBtnEnable("btn_Save");
}

function sheet1_OnChange(sheetObj,Row,Col,Value) {
	var formObj = document.form;
		 
	switch (sheetObj.ColSaveName(Col)) {
		case "sheet1_lod_ind_qty" :
			calculate(sheetObj, Row, "Y");
		break;
	}
}

function calculate(sheetObj, Row, changeFlg){
	var formObj = document.form;
	if(sheetObj.CellValue(Row, "sheet1_avg_spd")==""){
		if(changeFlg=="Y"){
			ComShowMessage("Because Sea Speed is zero(or null), cannot calculate Fuel Comp. Cost");
			return false;
		}
	}
	if(sheetObj.CellValue(Row, "sheet1_avg_spd")==""){
		sheetObj.CellValue2(Row, "sheet1_foil_csm_cost_amt") = "";
	}else{
		sheetObj.CellValue2(Row, "sheet1_foil_csm_cost_amt") = round(Number(sheetObj.CellValue(Row, "sheet1_nvgt_dist"))/Number(sheetObj.CellValue(Row, "sheet1_avg_spd"))/24*Number(sheetObj.CellValue(Row, "sheet1_foil_csm_wgt"))*Number(formObj.fo_ut_prc.value),1);
	}
	sheetObj.CellValue2(Row, "sheet1_sav_rto") = round((Number(sheetObj.CellValue(Row, "sheet1_sav_rto_n1st"))*Number(sheetObj.CellValue(Row, "sheet1_lod_ind_qty"))*Number(sheetObj.CellValue(Row, "sheet1_lod_ind_qty"))+Number(sheetObj.CellValue(Row, "sheet1_sav_rto_n2nd"))*Number(sheetObj.CellValue(Row, "sheet1_lod_ind_qty"))+Number(sheetObj.CellValue(Row, "sheet1_sav_rto_cons")))*100,2);
	if(sheetObj.CellValue(Row, "sheet1_avg_spd")==""){
		sheetObj.CellValue2(Row, "sheet1_sav_qty") = "";
	}else{
		sheetObj.CellValue2(Row, "sheet1_sav_qty") = round(Number(sheetObj.CellValue(Row, "sheet1_sav_rto"))*Number(sheetObj.CellValue(Row, "sheet1_nvgt_dist"))/Number(sheetObj.CellValue(Row, "sheet1_avg_spd"))/24*Number(sheetObj.CellValue(Row, "sheet1_foil_csm_wgt")),2);
	}
	sheetObj.CellValue2(Row, "sheet1_sav_cost_amt") = round(Number(formObj.fo_ut_prc.value) * Number(sheetObj.CellValue(Row, "sheet1_sav_qty")),2);
	if(formObj.sav_itm_cd.value=="02"){
		if(sheetObj.CellValue(Row, "sheet1_avg_spd")==""){
			sheetObj.CellValue2(Row, "sheet1_fuel_adtv_csm_wgt") = "";
		}else{
			sheetObj.CellValue2(Row, "sheet1_fuel_adtv_csm_wgt") = round((Number(sheetObj.CellValue(Row, "sheet1_nvgt_dist"))/Number(sheetObj.CellValue(Row, "sheet1_avg_spd"))/24*Number(sheetObj.CellValue(Row, "sheet1_foil_csm_wgt"))-Number(sheetObj.CellValue(Row, "sheet1_sav_qty")))*Number(sheetObj.CellValue(Row, "sheet1_itm_csm_rto")),1);
		}
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_uc_amt") = round(Number(sheetObj.CellValue(Row, "sheet1_itm_ut_prc")),2);
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_csm_cost_amt") = round(Number(sheetObj.CellValue(Row, "sheet1_fuel_adtv_csm_wgt"))*Number(sheetObj.CellValue(Row, "sheet1_fuel_adtv_uc_amt")),1);
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_sav_cost_amt") = round(Number(sheetObj.CellValue(Row, "sheet1_sav_cost_amt"))-Number(sheetObj.CellValue(Row, "sheet1_fuel_adtv_csm_cost_amt")),1);
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_dep_csm_cost_amt") = round(Number(sheetObj.CellValue(Row, "sheet1_port_pair_sea_foil_csm_wgt"))*Number(sheetObj.CellValue(Row, "sheet1_itm_csm_rto"))*Number(sheetObj.CellValue(Row, "sheet1_itm_ut_prc")),1);
	}else{
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_csm_wgt") = "";
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_uc_amt") = "";
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_csm_cost_amt") = "";
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_sav_cost_amt") = "";
		sheetObj.CellValue2(Row, "sheet1_fuel_adtv_dep_csm_cost_amt") = "";
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
			if(obj.name=="fo_ut_prc"){
				ComKeyOnlyNumber(obj,".");
			} else {
				ComKeyOnlyNumber(obj);
			}
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
	}
}

function obj_change(){
	var formObj = document.form;
	obj = event.srcElement;   
	var sheetObj = sheetObjects[0];
	with(formObj){
		switch(obj.name) {

			case "vsl_slan_cd":
				if(sheetObj.RowCount>0){
					sheetObj.RemoveAll();
				}
				if(vsl_slan_cd.value!=""){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
				}
			break;
			
			case "sav_itm_cd":
				if(sheetObj.RowCount>0){
					sheetObj.RemoveAll();
				}
        		if(obj.value=="02"){
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_csm_wgt")) = false;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_uc_amt")) = false;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_csm_cost_amt")) = false;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_dep_csm_cost_amt")) = false;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_sav_cost_amt")) = false;
        		}else{
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_csm_wgt")) = true;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_uc_amt")) = true;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_csm_cost_amt")) = true;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_dep_csm_cost_amt")) = true;
        			sheetObj.ColHidden(sheetObj.SaveNameCol(sheetObj.prefix+"fuel_adtv_sav_cost_amt")) = true;
        		}
			break;
			
			case "fo_ut_prc":
				if(sheetObj.RowCount>0){
					ComBtnDisable("btn_Save");
				}
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
			case "sav_cost_cre_yrmon":
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

	switch(obj.name) {
		case "sav_cost_cre_yrmon":	//Month
			if(formObj.sav_cost_cre_yrmon.value!=""){
				formObj.sav_cost_cre_yrmon.value = ComGetMaskedValue(formObj.sav_cost_cre_yrmon.value, "ym");
			}
			ComChkObjValid(event.srcElement);
		break;
	}
}

function clearAll(){
	sheetObjects[0].RemoveAll();
	var formObj = document.form;
	formObj.sav_cost_cre_yrmon.value="";
	formObj.vsl_slan_cd.value="";
	formObj.fo_ut_prc.value="";
}

/* 개발자 작업 끝 */