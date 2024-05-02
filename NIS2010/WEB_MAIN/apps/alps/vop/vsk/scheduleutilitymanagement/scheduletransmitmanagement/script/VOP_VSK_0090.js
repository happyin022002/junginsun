/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0090.js
*@FileTitle : ETA sending (Auto TLX/FAX)
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
 * @class VOP_VSK_0090 : VOP_VSK_0090 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0090() {
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
			
		case "btn_New":
			formObject.reset();
			sheetObject.RemoveAll();
			formObject.fm_eta_dt.value = ComGetNowInfo();
			formObject.to_eta_dt.value = ComGetDateAdd(null, "D", 7);
			break;

		case "btn_vps_port_cd":
			sUrl = "/hanjin/VOP_VSK_0043.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
			if (rVal) {
				formObject.vps_port_cd.value = rVal;
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
        		sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + vslCd;//inc_del_vsl_pop가 Y가 아니면, 삭제된 vessel은 조회하지 않음.
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
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "sheet1_auto_fax_pop", "", false, "", true);//image부분은 제외 & header merge
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	
	document.form.fm_eta_dt.value = ComGetNowInfo();
    document.form.to_eta_dt.value = ComGetDateAdd(null, "D", 7);
    document.form.vps_port_cd.focus();
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
	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
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

			var HeadTitle1 = "|Port|yd_cd|Terminal\nName|Lane|VVD|Vessel Name|OPR|Coastal SKD|Coastal SKD|Coastal SKD|ETA notice via Auto TLX/FAX|ETA notice via Auto TLX/FAX|ETA notice via Auto TLX/FAX|Sending date|Sent status|Auto TLX/FAX|Result|Result|Result|clpt_ind_seq|trsm_his_seq|tmp1|tmp2|tmp3|tmp4|tmp5|vsl_cd|skd_voy_no|skd_dir_cd|vsl_fax_no|vsl_tlx_no|vsl_eml|dflt_fax_imst_cd|dflt_tlx_imst_cd|trsm_ownr_cd|lane_pic_eml|trsm_purp_cd";
			var HeadTitle2 = "|Port|yd_cd|Terminal\nName|Lane|VVD|Vessel Name|OPR|ETA|ETB|ETD|ETA|ETB|ETD|Sending date|Sent status|Auto TLX/FAX|Time of adj. RPM|Old RPM|New RPM|clpt_ind_seq|trsm_his_seq|tmp1|tmp2|tmp3|tmp4|tmp5|vsl_cd|skd_voy_no|skd_dir_cd|vsl_fax_no|vsl_tlx_no|vsl_eml|dflt_fax_imst_cd|dflt_tlx_imst_cd|trsm_ownr_cd|lane_pic_eml|trsm_purp_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix+"ibflag",				false,	"",      	dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"vps_port_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"yd_cd",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,	prefix+"yd_nm",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"slan_cd",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"vvd",					false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,	prefix+"vsl_eng_nm",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"act_crr_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"vps_eta_dt",			false,	"",			dfUserFormat2,	0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"vps_etb_dt",			false,	"",			dfUserFormat2,	0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"vps_etd_dt",			false,	"",			dfUserFormat2,	0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"ntc_eta_dt",			false,	"",			dfUserFormat2,	0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"ntc_etb_dt",			false,	"",			dfUserFormat2,	0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"ntc_etd_dt",			false,	"",			dfUserFormat2,	0,			true,		true);

			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefix+"trsm_locl_dt",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"skd_trsm_sts_cd",		false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtImage,		85,		daCenter,	true,	prefix+"auto_fax_pop",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"rpm_adj_dt",			false,	"",			dfUserFormat2,	0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"org_rpm_pwr",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"crnt_rpm_pwr",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"clpt_ind_seq",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"trsm_his_seq",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"tmp_rpm_adj_dt",		false,	"",			dfUserFormat2,	0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"tmp_org_rpm_pwr",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"tmp_crnt_rpm_pwr",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"tmp_ntc_eta_dt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"tmp_ntc_etb_dt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"vsl_cd",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"skd_voy_no",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"skd_dir_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"vsl_fax_no",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"vsl_tlx_no",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"vsl_eml",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"dflt_fax_imst_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"dflt_tlx_imst_cd",		false,	"",			dfNone,			0,			false,		false);

			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"trsm_ownr_cd",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"lane_pic_eml",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix+"trsm_purp_cd",			false,	"",			dfNone,			0,			false,		false);
			
			InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"ntc_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"ntc_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"ntc_etd_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"rpm_adj_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"tmp_rpm_adj_dt", "####-##-## ##:##", "-|:" );
			ImageList(0) = "img/alps/button/btng_send.gif";
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
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0090GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
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
		
	case IBSAVE:
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = MULTI;
			setFlag(sheetObj);//status setting
			
			var SaveStr = ComGetSaveString(sheetObj);
			if(SaveStr == undefined || SaveStr.length <= 0 ) return;
			
			ComOpenWait(true);
			var aryPrefix = new Array("sheet1_");		
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0090GS.do", SaveStr + "&"+FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
				sheetObj.LoadSaveXml(sXml);
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
			}
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
//			}
//			break; 
//		case "vps_port_cd":
//	    	if(obj.value.length == 5){
//	    		formObj.slan_cd.focus();
//	    	}
//			break; 
//		case "slan_cd":
//			if(obj.value.length == 3){
//				formObj.vsl_cd.focus();
//			}
//			break; 
//	    case "vsl_cd":
//	    	if(obj.value.length == 4){
//	    		formObj.skd_voy_no.focus();
//	    	}
//			break; 
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
			}else if(formObj.vps_port_cd.value==""){
				ComShowCodeMessage('VSK00027', 'Port');
				formObj.vps_port_cd.focus();
				return false;
			}
			
			// fm_dt to_dt보다 앞선일자가 아니면 오류
			if(!checkPeriod(formObj.fm_eta_dt, formObj.to_eta_dt)){
				ComShowCodeMessage("VSK00025", "End date", "start date");
				formObj.to_eta_dt.focus();
				return false;
			}
			break;
			
		case IBSAVE:
			
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

function sheet1_OnClick(sheetObj, Row, Col){
	var formObj = document.form;
	var colSaveName = sheetObj.ColSaveName(Col);
	
	switch(colSaveName){

		case "sheet1_auto_fax_pop":
			if(sheetObj.CellValue(Row, "sheet1_ntc_eta_dt")=="" || sheetObj.CellValue(Row, "sheet1_ntc_etb_dt")==""){
				ComShowMessage("Please Check [ETA, ETB notice via Auto TLX/FAX] Date");
			}else{
				openAutoFaxPop(sheetObj, Row);
			}
			break;
	}
}

/**
 * IBSheet OnChange Event
 */
function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
	 	case prefix + "ntc_eta_dt" :   
	 		if(!ComIsDateTime(sheetObj.CellValue(Row, Col), "ymd", "hm") && sheetObj.CellValue(Row, Col) != ""){
	 			ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
	 			sheetObj.CellValue(Row, Col) = "";
	 			sheetObj.SelectCell(Row, Col, true);
	 		}
	 		if(sheetObj.CellValue(Row, Col)==sheetObj.CellValue(Row, prefix+"tmp_ntc_eta_dt")){
	 			//backcolor 흰색
	 			sheetObj.CellBackColor(Row, Col) = sheetObj.RgbColor(255, 255, 255); 
	 		}else{
	 			//backcolor 푸른색
	 			sheetObj.CellBackColor(Row, Col) = sheetObj.RgbColor(175, 175, 255); 
	 		}
	 		break;
	 		
	 	case prefix + "ntc_etb_dt" :   
	 		if(!ComIsDateTime(sheetObj.CellValue(Row, Col), "ymd", "hm") && sheetObj.CellValue(Row, Col) != ""){
	 			ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
	 			sheetObj.CellValue(Row, Col) = "";
	 			sheetObj.SelectCell(Row, Col, true);
	 		}
	 		if(sheetObj.CellValue(Row, Col)==sheetObj.CellValue(Row, prefix+"tmp_ntc_etb_dt")){
	 			//backcolor 흰색
	 			sheetObj.CellBackColor(Row, Col) = sheetObj.RgbColor(255, 255, 255); 
	 		}else{
	 			//backcolor 푸른색
	 			sheetObj.CellBackColor(Row, Col) = sheetObj.RgbColor(175, 175, 255); 
	 		}
	 		break;
	 		
	 	case prefix + "rpm_adj_dt" :   
	 		if(!ComIsDateTime(sheetObj.CellValue(Row, Col), "ymd", "hm") && sheetObj.CellValue(Row, Col) != ""){
	 			ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
	 			sheetObj.CellValue(Row, Col) = "";
	 			sheetObj.SelectCell(Row, Col, true);
	 		}
	 		break;
	}
}	

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	if(sheetObj.RowCount > 0){
		for(var row=sheetObj.HeaderRows; row<sheetObj.HeaderRows+sheetObj.RowCount; row++){
			//save할 대상 비교를 위해
			sheetObj.CellValue2(row, "sheet1_tmp_rpm_adj_dt")	= sheetObj.CellValue(row, "sheet1_rpm_adj_dt");
			sheetObj.CellValue2(row, "sheet1_tmp_org_rpm_pwr")		= sheetObj.CellValue(row, "sheet1_org_rpm_pwr");
			sheetObj.CellValue2(row, "sheet1_tmp_crnt_rpm_pwr")		= sheetObj.CellValue(row, "sheet1_crnt_rpm_pwr");
			
			//notice 정보 변경시 색깔 정렬을 위해
			sheetObj.CellValue2(row, "sheet1_tmp_ntc_eta_dt")		= sheetObj.CellValue(row, "sheet1_ntc_eta_dt");
			sheetObj.CellValue2(row, "sheet1_tmp_ntc_etb_dt")		= sheetObj.CellValue(row, "sheet1_ntc_etb_dt");
			
			if(sheetObj.CellValue(row, "sheet1_trsm_his_seq") == ""){
				sheetObj.CellEditable(row, "sheet1_rpm_adj_dt") = false;
				sheetObj.CellEditable(row, "sheet1_org_rpm_pwr") = false;
				sheetObj.CellEditable(row, "sheet1_crnt_rpm_pwr") = false;
			}
		}
	}
}

/**
 * MDM에 Port Code가 존재하는지 확인한다.
 */
function isCheckPortCd(sheetObj, formObj){
	if(formObj.vps_port_cd.value == null || formObj.vps_port_cd.value == undefined || formObj.vps_port_cd.value == "") return false;
	
	if(ComChkLen(formObj.vps_port_cd, 5) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
		var chkPort = ComGetEtcData(sXml, "check_port");//X-사용가능
		if(chkPort != "X"){
			ComShowCodeMessage("VSK00029", formObj.vps_port_cd.value);
			formObj.vps_port_cd.value = "";
			formObj.vps_port_cd.focus();
		}else{
			formObj.slan_cd.focus();
		}
	}else{
		ComShowCodeMessage("COM12114", "Port Code");
		formObj.vps_port_cd.value = "";
		formObj.vps_port_cd.focus();
	}
}
 
/**
 * MDM에 Lane Code가 존재하는지 확인한다.
 */
function isCheckLaneCd(sheetObj, formObj){
	if(formObj.slan_cd.value == null || formObj.slan_cd.value == undefined || formObj.slan_cd.value == "") return false;
 
	if(ComChkLen(formObj.slan_cd, 3) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
		var chkLane = ComGetEtcData(sXml, "check_lane");//X-사용가능
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
		var chkVsl = ComGetEtcData(sXml, "check_vsl");//X-사용가능
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

//화면상에 입력 가능한 값 중 저장할 값(Result) 변경시에만 flag를 update로 지정함.
function setFlag(sheetObj){
	if(sheetObj.RowCount==0){
		return false;
	}
	
	for(var row=sheetObj.HeaderRows; row<sheetObj.HeaderRows+sheetObj.RowCount; row++){
		if(sheetObj.CellValue(row, "sheet1_rpm_adj_dt")!=sheetObj.CellValue(row, "sheet1_tmp_rpm_adj_dt")||
				sheetObj.CellValue(row, "sheet1_org_rpm_pwr")!=sheetObj.CellValue(row, "sheet1_tmp_org_rpm_pwr")||
				sheetObj.CellValue(row, "sheet1_crnt_rpm_pwr")!=sheetObj.CellValue(row, "sheet1_tmp_crnt_rpm_pwr")){
			sheetObj.RowStatus(row) =  "U";
		}else{
			sheetObj.RowStatus(row) =  "R";
		}
	}
	return true;
}

function openAutoFaxPop(sheetObj, Row){
	var url = "/hanjin/VOP_VSK_0290.do?vslCd="
		+ sheetObj.CellValue(Row, "sheet1_vsl_cd") 				+ "&skdVoyNo=" 
		+ sheetObj.CellValue(Row, "sheet1_skd_voy_no") 			+ "&skdDirCd="
		+ sheetObj.CellValue(Row, "sheet1_skd_dir_cd") 			+ "&vvd="
		+ sheetObj.CellValue(Row, "sheet1_vvd") 				+ "&vpsPortCd="
		+ sheetObj.CellValue(Row, "sheet1_vps_port_cd") 		+ "&clptIndSeq="
		+ sheetObj.CellValue(Row, "sheet1_clpt_ind_seq")		+ "&ydCd="
		+ sheetObj.CellValue(Row, "sheet1_yd_cd") 				+ "&slanCd="
		+ sheetObj.CellValue(Row, "sheet1_slan_cd") 			+ "&actCrrCd="
		+ sheetObj.CellValue(Row, "sheet1_act_crr_cd") 			+ "&vpsEtaDt="
		+ sheetObj.CellValue(Row, "sheet1_vps_eta_dt") 			+ "&vpsEtbDt="
		+ sheetObj.CellValue(Row, "sheet1_vps_etb_dt") 			+ "&vpsEtdDt="
		+ sheetObj.CellValue(Row, "sheet1_vps_etd_dt") 			+ "&ntcEtaDt="
		+ sheetObj.CellValue(Row, "sheet1_ntc_eta_dt") 			+ "&ntcEtbDt="
		+ sheetObj.CellValue(Row, "sheet1_ntc_etb_dt") 			+ "&ntcEtdDt="
		+ sheetObj.CellValue(Row, "sheet1_ntc_etd_dt") 			+ "&vslFaxNo="
		+ sheetObj.CellValue(Row, "sheet1_vsl_fax_no") 			+ "&vslTlxNo="
		+ sheetObj.CellValue(Row, "sheet1_vsl_tlx_no") 			+ "&vslEml="
		+ sheetObj.CellValue(Row, "sheet1_vsl_eml") 			+ "&vslEngNm="
		+ sheetObj.CellValue(Row, "sheet1_vsl_eng_nm") 			+ "&ydNm="
		+ sheetObj.CellValue(Row, "sheet1_yd_nm") 				+ "&dfltFaxImstCd="
		+ sheetObj.CellValue(Row, "sheet1_dflt_fax_imst_cd") 	+ "&landPicEml="
		+ sheetObj.CellValue(Row, "sheet1_lane_pic_eml") 		+ "&dfltTlxImstCd="
		+ sheetObj.CellValue(Row, "sheet1_dflt_tlx_imst_cd");
	
	ComOpenPopup(url, 600, 595, '', '0,0', true, true);
	
	
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