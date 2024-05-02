/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0093.js
*@FileTitle : Auto TLX vs Actual arrival monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.05 진마리아
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
 * @class VOP_VSK_0093 : VOP_VSK_0093 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0093() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
}

/* 개발자 작업 */

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

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
		case "btn_New":
			formObject.reset();
			sheetObject.RemoveAll();
			// comboObj들 new
			formObject.vskd_port_rhq_cd.RemoveAll();
			formObject.vop_port_ctrl_ofc_cd.RemoveAll();
			formObject.tml_cd.RemoveAll();
			formObject.trsm_mzd_cd.value = "";
			formObject.fm_eta_dt.value = ComGetNowInfo();
			formObject.to_eta_dt.value = ComGetDateAdd(null, "D", 7);
			formObject.lst_flg.checked = false;
			
			// CTRL Combo Setting.
			doActionIBSheet(sheetObjects[0], formObject, SEARCH04);
			
			break;

		case "btn_vps_port_cd":
			sUrl = "/hanjin/VOP_VSK_0043.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
			if (rVal) {
				formObject.vps_port_cd.value = rVal;
				isCheckPortCd(sheetObject, formObject);
			}
			break;
			
		case "btn_slan_cd":
			sUrl = "/hanjin/VOP_VSK_0202.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 470, "", "0,0", true);
			if (rVal) {
				formObject.slan_cd.value = rVal;
			}
			break;
			
		case "btn_vvd_search":
			var vslCd = formObject.vsl_cd.value;
        	var sUrl = "";
        	
        	if(vslCd == ""){
        		sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + vslCd;// inc_del_vsl_pop가
																	// Y가 아니면,
																	// 삭제된
																	// vessel은
																	// 조회하지 않음.
        		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
        	}else{
        		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
        		ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
        	}
			break;

		case "btn_period":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fm_eta_dt, formObject.to_eta_dt, 'yyyy-MM-dd');
			break;
			
		case "btn_DownExcel":
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true); //header merge
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
 * IBCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
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
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	initControl();
	
	document.form.fm_eta_dt.value = ComGetNowInfo();
    document.form.to_eta_dt.value = ComGetDateAdd(null, "D", 7);
    
	// CTRL Combo Setting.
	doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
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
	axon_event.addListenerForm('focus', 'obj_focus', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);
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
			InitRowInfo(2, 1, 3, document.form.pagerows.value);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|CTRL HQ|CTRL Office|Port|TMNL|Lane|VVD|Vessel Name|OPR|Coastal SKD(At the time of TLX sending)|Coastal SKD(At the time of TLX sending)|ATA|ATB|ATD|Difference\n(Hours)|ETA notice via Auto TLX|ETA notice via Auto TLX|ETA notice via Auto TLX|ETA notice via Auto TLX|Difference(Hour)|Difference(Hour)|via cd|Send via|Result|Result|Result|esvc_vndr_seq|trsm_his_seq|trsm_ownr_cd";
			var HeadTitle2 = "|CTRL HQ|CTRL Office|Port|TMNL|Lane|VVD|Vessel Name|OPR|ETA|ETB|ATA|ATB|ATD|Difference\n(Hours)|ETA|ETB|Sending date|User ID|Arrival|Berthing|via cd|Send via|Time of adj. RPM|Old RPM|New RPM|esvc_vndr_seq|trsm_his_seq|trsm_ownr_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix+"ibflag",				false,	"",      	dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"rhq_ofc_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"ctrl_ofc_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"vps_port_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"yd_cd",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"slan_cd",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"vvd",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,	prefix+"vsl_eng_nm",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"act_crr_cd",			false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	true,	prefix+"vps_eta_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	true,	prefix+"vps_etb_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"act_arr_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"act_brth_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"act_dep_dt",			false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"stw_dif_hrs",			false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	prefix+"ntc_eta_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	prefix+"ntc_etb_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"trsm_locl_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"upd_usr_id",			false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"dif_over_arr_dt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"dif_over_brth_dt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"trsm_mzd_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"trsm_mzd_nm",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix+"rpm_adj_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daRight,	true,	prefix+"org_rpm_pwr",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daRight,	true,	prefix+"crnt_rpm_pwr",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix+"esvc_vndr_seq",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix+"trsm_his_seq",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix+"trsm_ownr_cd",			false,	"",			dfNone,			0,			false,		false);

		}
		break;

	}
}
 
/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form;
    
    switch(comboObj.id) { 
    	case "vskd_port_rhq_cd": 
    		with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
	    	}
    		break;
    	case "vop_port_ctrl_ofc_cd":
    		with (comboObj) { 
				MultiSelect = true;
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
	    	}
    		break;
    	case "tml_cd":
    		with (comboObj) { 
				MultiSelect = true;
				UseAutoComplete = true;	
				SetColAlign("left|left");        
				SetColWidth("70|300");
				DropHeight = 160;
// Enable = false;
	    	}
    		break;
     }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";
	
	switch (sAction) {
	case IBSEARCH: // 조회
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0093GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
		}
		break;

	case SEARCH01: //Port Code Check
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0090GS.do", FormQueryString(formObj));
			return sXml;
		}
		break;
	
	case SEARCH02: //Lane Code Check
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0090GS.do", FormQueryString(formObj));
			return sXml;
		}
		break;
	
	case SEARCH03: //VVD Check
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0090GS.do", FormQueryString(formObj));
			return sXml;
		}
		break;
		
	case SEARCH04:      // Open
		formObj.f_cmd.value = SEARCH04;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
		
		var rhqCdArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
		var rhqDescArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
		
		// CTRL Combo Setting.
		appendMultiComboItem(getComboObject("vskd_port_rhq_cd"), rhqCdArr, rhqDescArr);
		break;
	
	case SEARCH05:      // Control Office
		formObj.f_cmd.value = SEARCH05;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
		
		var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
		var ctrlOfcArr = null;
		if(sCtrlOfc != null && sCtrlOfc != undefined){
			ctrlOfcArr = ("ALL|"+sCtrlOfc).split("|");	//
		}
		
		//CTRL Combo Setting.
		appendMultiComboItem(getComboObject("vop_port_ctrl_ofc_cd"), ctrlOfcArr, ctrlOfcArr);
		break;
		
	case SEARCH06:      //yard
		if(validateForm(sheetObj, formObj, sAction)){
			var sXml = null;
			formObj.f_cmd.value = SEARCH04;
			formObj.country_cd.value = formObj.vps_port_cd.value;// COMMON
																	// 로직을 위해,
																	// country_cd
																	// 임시사용
			var sParam = FormQueryString(formObj);
			sXml = sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
			formObj.country_cd.value = "";
			return sXml;
		}else{
			return "";
		}
		break;
	}
}

function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_blur(){
	var srcName = event.srcElement.name;
	
	switch(srcName){
		case "fm_eta_dt":
		case "to_eta_dt":
			ComChkObjValid(event.srcElement);
			break;
	}
}

function obj_focus(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;

	switch (event.srcElement.name) {
//		case "act_crr_cd":
//			if(obj.value.length == 3){
//				formObj.vps_port_cd.focus();
// }
// break;
// case "vps_port_cd":
// if(obj.value.length == 5){
// formObj.slan_cd.focus();
// }
// break;
// case "slan_cd":
// if(obj.value.length == 3){
// formObj.vsl_cd.focus();
// }
// break;
// case "vsl_cd":
// if(obj.value.length == 4){
// formObj.skd_voy_no.focus();
// }
// break;
	    case "skd_voy_no":
	    	if(obj.value.length == 4){
	    		formObj.skd_dir_cd.focus();
	    	}
	    	break; 
	}
}

function obj_keypress(){
	var formObj = document.form;
	switch (event.srcElement.name) {

		case "act_crr_cd":
	    case "vps_port_cd":
	    case "slan_cd":
	    case "vsl_cd":
	    	ComKeyOnlyAlphabet('uppernum');
			break;

	    case "skd_dir_cd":
	    	ComKeyOnlyAlphabet('upper');
	    	break;
	    	
	    case "skd_voy_no":
	    case "dif_over_arr_dt":
	    	ComKeyOnlyNumber(event.srcElement);
			break;
			
	    case "fm_eta_dt":
	    	ComKeyOnlyNumber(formObj.fm_eta_dt);
			break;
			
	    case "to_eta_dt":
	    	ComKeyOnlyNumber(formObj.to_eta_dt);
			break;
	    	
	}
}

function obj_change(){
	var formObj = document.form;
    var sheetObj = sheetObjects[0];
	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
            case "vps_port_cd":
            	isCheckPortCd(sheetObj, formObj);
            	break;
            	
            case "slan_cd":
            	isCheckLaneCd(sheetObj, formObj);
            	break;
            	
            case "vsl_cd":
            	isCheckVslCd(sheetObj, formObj);
            	break;

            case "fm_eta_dt":
            	formObj.fm_eta_dt.value = ComGetMaskedValue(formObj.fm_eta_dt.value, "ymd");
            	break;
            	
            case "to_eta_dt":
            	formObj.to_eta_dt.value = ComGetMaskedValue(formObj.to_eta_dt.value, "ymd");
            	break;
            	
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

		case IBSEARCH:
			if(formObj.fm_eta_dt.value==""){
				ComShowCodeMessage('VSK00027', 'ETA Period [From]');
				formObj.fm_eta_dt.focus();
				return false;
			}else if(formObj.to_eta_dt.value==""){
				ComShowCodeMessage('VSK00027', 'ETA Period [To]');
				formObj.to_eta_dt.focus();
				return false;
			}
			
			// fm_dt to_dt보다 앞선일자가 아니면 오류
			if(!checkPeriod(formObj.fm_eta_dt, formObj.to_eta_dt)){
				ComShowCodeMessage("VSK00025", "End date", "start date");
				formObj.to_eta_dt.focus();
				return false;
			}
			break;
			
	}
	return true;
}



/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress() {
	VskKeyEnter();
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

function getVvdData(obj){
	if(obj){
		var rtnDatas = obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.skd_voy_no.value = rtnDatas[2];
				document.form.skd_dir_cd.value = rtnDatas[3];
			}
		}
	}
}

/*
 * RHQ 선택시 Control Office 조회
 */
function vskd_port_rhq_cd_OnChange(comboObj, Index_Code, Text) {
	doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
}

/**
 * MDM에 Port Code가 존재하는지 확인한다.
 */
function isCheckPortCd(sheetObj, formObj){
	if(formObj.vps_port_cd.value == null || formObj.vps_port_cd.value == undefined) return false;
	
	var portCd = formObj.vps_port_cd.value;
	if(portCd != ""){
		if(ComChkLen(formObj.vps_port_cd, 5) == 2){
			var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
			var chkPort = ComGetEtcData(sXml, "check_port");// X-사용가능
			if(chkPort != "X"){
				ComShowCodeMessage("VSK00029", formObj.vps_port_cd.value);
				formObj.vps_port_cd.value = "";
				appendMultiComboItem(getComboObject("tml_cd"), "", "");
				formObj.vps_port_cd.focus();
			}else{
				var rtnXml = doActionIBSheet(sheetObj, formObj, SEARCH06);	// Terminal
				// Code
				// 가져온다.
				setTmlCdCombo(rtnXml);
				
				formObj.tml_cd.focus();
			}
		}else{
			ComShowCodeMessage("COM12114", "Port Code");
			formObj.vps_port_cd.value = "";
			appendMultiComboItem(getComboObject("tml_cd"), "", "");
			formObj.vps_port_cd.focus();
		}
	}else{
		appendMultiComboItem(getComboObject("tml_cd"), "", "");
	}
}
 
/**
 * MDM에 Lane Code가 존재하는지 확인한다.
 */
function isCheckLaneCd(sheetObj, formObj){
	if(formObj.slan_cd.value == null || formObj.slan_cd.value == undefined || formObj.slan_cd.value == "") return false;
 
	if(ComChkLen(formObj.slan_cd, 3) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
		var chkLane = ComGetEtcData(sXml, "check_lane");// X-사용가능
		if(chkLane != "X"){
			ComShowCodeMessage("VSK00021", "Lane Code");
			formObj.slan_cd.value = "";
			formObj.slan_cd.focus();
		}else{
			formObj.vsl_cd.focus();
		}
	}else{
		ComShowCodeMessage("COM12114", "Lane Code");
		formObj.slan_cd.value = "";
		formObj.slan_cd.focus();
	}
}
  
/**
 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
 */
function isCheckVslCd(sheetObj, formObj){
	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
  	
	if(ComChkLen(formObj.vsl_cd, 4) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
		var chkVsl = ComGetEtcData(sXml, "check_vsl");// X-사용가능
		if(chkVsl != "X"){
			ComShowCodeMessage("VSK00021", "Vessel Code");
			formObj.vsl_cd.value = "";
			formObj.vsl_cd.focus();
		}else{
			formObj.skd_voy_no.focus();
		}
	}else{
		ComShowCodeMessage("COM12114", "Vessel Code");
		formObj.vsl_cd.value = "";
		formObj.vsl_cd.focus();
	}
}

/**
 * CTRL Office - ALL 선택시 전체 체크
 */
function vop_port_ctrl_ofc_cd_OnCheckClick(comboObj, index, code) {
	if (code == "" || code == "ALL") {
		var bChk = comboObj.CheckIndex(index);
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = bChk;
    	}
   }else{
	   comboObj.CheckIndex(0) = false;
   }
}

/**
 * TMNL Code - ALL 선택시 전체 체크
 */
function tml_cd_OnCheckClick(comboObj, index, code) {
	if (code == "" || code == "ALL") {
		var bChk = comboObj.CheckIndex(index);
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = bChk;
    	}
   }else{
	   comboObj.CheckIndex(0) = false;
   }
}

/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 */
function getComboObject(comboId){
	var cnt = comboObjects.length;
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].id == comboId){
				return comboObjects[i];
			}
		}
	}
	
	return null;
}
 
/**
 * Mutil Combo에 item을 추가한다.
 * @param comboObj
 * @param optionCds
 * @param optionTxts
 * @param selCode
 * @return
 */
function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
	comboObj.RemoveAll();
	for(var i=0; i<optionCds.length; i++) {
		comboObj.InsertItem(i, optionTxts[i], optionCds[i]);
	}
}

/**
 * Tml Cd Combo를 Setting.
 * @return
 */
function setTmlCdCombo(sXml){
	if(sXml == null || sXml == undefined || sXml == ""){
		return;
	}
	
	var ydCd = ComGetEtcData(sXml, "yd_cd");
	var ydNm = ComGetEtcData(sXml, "yd_nm");

	var ydTxtArr = new Array();
	var ydCdArr = ("ALL|"+ ydCd).split("|");
	var ydNmArr = ("ALL|"+ ydNm).split("|");
	var ydCnt = ydCdArr.length;

	ydTxtArr[0] = ydCdArr[0] + "|" + ydNmArr[0];
	for(var i=1; i<ydCnt; i++){
		ydTxtArr[i] = ydCdArr[i] + "|" + ydNmArr[i];
	}
	appendMultiComboItem(getComboObject("tml_cd"), ydCdArr, ydTxtArr);
}

function checkPeriod(fromDate, toDate){
	var fmDt = ComReplaceStr(fromDate.value, "-", "");
	var toDt = ComReplaceStr(toDate.value, "-", "");
	if(ComChkPeriod(fmDt, toDt) < 1){
		return false;
	}else{
		return true;
	}
}
	
/* 개발자 작업 끝 */