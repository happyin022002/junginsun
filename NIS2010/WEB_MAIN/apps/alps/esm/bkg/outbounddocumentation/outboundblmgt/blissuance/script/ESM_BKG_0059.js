/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0059.js
 *@FileTitle : Cancel Issue Release
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.20 이진서
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
 * @class ESM_BKG_0059 : ESM_BKG_0059 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */


var rqst_bl_tp_cd_old = "";
var bl_de_to_cd_old = "";
var bl_de_mzd_cd_old = "";
var wbl_rt_tp_cd_old = "";

var obl_rt_incl_knt_old = "";
var obl_rt_xcld_knt_old = "";
var obl_ttl_knt_old = "";

var non_nego_rt_incl_knt_old = "";
var non_nego_rt_xcld_knt_old = "";
var cpy_ttl_knt_old = "";

var wbl_eml = "";
var rqst_iss_plc_nm_old = "";
var rqst_iss_dt_old = "";
var bl_doc_rqst_rmk_old = "";

function ESM_BKG_0059() {
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
var URL_ESM_BKG = 'ESM_BKG_0059GS.do';
var prefix1 = "sheet1_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
var save_success = false;
var opener = window.dialogArguments;
window.onunload=function(){	if(save_success) try{ opener.bkg_search();} catch (ex) {} }
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	initControl();

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 초기 컨트롤 설정하기 
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); //- 포커스 들어갈때
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); //- 포커스 나갈때
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //- 키보드 입력할때
	axon_event.addListener('keydown', 'check_Enter', 'form');
    axon_event.addListener("click", "obj_onclick", 'bl_tp_cd');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	try {

		switch (sheetNo) {

		case 1: //t1sheet1 init
			with (sheetObj) {

				// 높이 설정
				style.height = 0;
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

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(17, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle1 = "|||||||||||||||";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
				// ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix1 + "ibflag");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rqst_bl_tp_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rt_incl_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rt_xcld_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_ttl_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "non_nego_rt_incl_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "non_nego_rt_xcld_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cpy_ttl_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rqst_iss_plc_nm");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rqst_iss_dt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_de_to_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_de_mzd_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_doc_rqst_rmk");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "loc_nm");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "wbl_eml");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "wbl_rt_tp_cd");
				CountPosition = 0;
			}
			break;
		}

	} catch (ex) {
		bkg_error_alert('initSheet', ex);
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		/** * BUTTON BL ISSUE (r) ** */
		case "btn_confirm":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_close":
			window.close();
			break;
		case "btn_pre_set":
			fnPreSet();
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

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array(prefix1);

	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}

	switch (sAction) {
	
		case IBSEARCH: //조회
	
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
			ComSetObjValue(formObj.f_cmd, SEARCH);
	
			// 2.조회조건으로 조회실행
			var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	
			// 3.조회후 결과처리
			var arrXml = sXml.split("|$$|");
			for ( var inx = 0; inx < arrXml.length; inx++) {
				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
			}
			
			fnOnSearchEnd();
			break;
	
		case IBSAVE: //저장
	
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
			ComSetObjValue(formObj.f_cmd, MULTI);
	
			//sheet에 변경된값 셋팅하기
			if (IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_")) {
			}

			
			// 2.저장조건으로 실행
			var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열
		
			sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
			sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열
			if (!ComShowConfirm(ComGetMsg("BKG00498"))) {
				return;
			}

			if((rqst_bl_tp_cd_old==ComGetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd))
					&&(bl_de_to_cd_old==ComGetObjValue(formObj.frm_sheet1_bl_de_to_cd))
					&&(bl_de_mzd_cd_old==ComGetObjValue(formObj.frm_sheet1_bl_de_mzd_cd))
					&&(wbl_rt_tp_cd_old==ComGetObjValue(formObj.frm_sheet1_wbl_rt_tp_cd))
					
					&&(obl_rt_incl_knt_old==ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt))
					&&(obl_rt_xcld_knt_old==ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt))
					&&(obl_ttl_knt_old==ComGetObjValue(formObj.frm_sheet1_obl_ttl_knt))
					
					&&(non_nego_rt_incl_knt_old==ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt))
					&&(non_nego_rt_xcld_knt_old==ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt))
					&&(cpy_ttl_knt_old==ComGetObjValue(formObj.frm_sheet1_cpy_ttl_knt))
					
					&&(wbl_eml==ComGetObjValue(formObj.frm_sheet1_wbl_eml))
					&&(rqst_iss_plc_nm_old==ComGetObjValue(formObj.frm_sheet1_rqst_iss_plc_nm))
					&&(rqst_iss_dt_old==ComGetObjValue(formObj.frm_sheet1_rqst_iss_dt))
					&&(bl_doc_rqst_rmk_old==ComGetObjValue(formObj.frm_sheet1_bl_doc_rqst_rmk))){
				
				ComShowCodeMessage("BKG00233");
				return false;
				
			}
			
			var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
			// 3.저장후 결과처리
			sheetObj.LoadSaveXml(sXml);
			var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if ( State == "S" ) {// 3.저장후 결과처리
				sheetObj.LoadSaveXml(sXml);
				ComShowMessage(ComGetMsg("BKG06071"));
				save_success =true;
				opener.document.form.frm_t11sheet1_wbl_eml.value = formObj.frm_sheet1_wbl_eml.value;
				opener.document.form.frm_t11sheet1_wbl_rt_tp_cd.value = formObj.frm_sheet1_wbl_rt_tp_cd.value;
				
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
		}
}
/**
 * fnOnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function fnOnSearchEnd() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	try {
		/** =====================================
		 *  FORM VALUE BINDING
		 *  ===================================== */
		if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {};
		 
		//B/L Type
		fnRadioCheck('bl_tp_cd', fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd),""));
		
		//Deliver To
		fnRadioCheck('bl_de_to_cd', fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_de_to_cd),""));
		
		//Method
		fnRadioCheck('bl_de_mzd_cd', fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_de_mzd_cd),""));
		
		
		if(formObj.frm_sheet1_wbl_rt_tp_cd.value=="Y"){
			formObj.chk_rate.checked = true;
			formObj.chk_unrate.checked = false;
		}else if(formObj.frm_sheet1_wbl_rt_tp_cd.value=="N"){
			formObj.chk_rate.checked = false;
			formObj.chk_unrate.checked = true;
		}else if(formObj.frm_sheet1_wbl_rt_tp_cd.value=="B"){
			formObj.chk_rate.checked = true;
			formObj.chk_unrate.checked = true;
		}else{
			formObj.chk_rate.checked = false;
			formObj.chk_unrate.checked = false;
		}

		formSet();		
		
	} catch (ex) {
		bkg_error_alert('fnOnSearchEnd', ex);
		return false;
	}
}
/* 
 * B/L Surrender Check Button 을 제어한다
 */
function checkOption(v_obj){ 
	 // onClick="checkOption()"
	var formObj = document.form;
	var srdCheck = formObj.bl_tp_cd3.value;
	
	if(formObj.bl_tp_cd3.checked){
		formObj.bl_tp_cd2.checked = true;
		formObj.bl_tp_cd1.checked = false;
		formObj.bl_tp_cd3.checked = true;
	}
}

function checkOptionForSwb(v_obj){ 
	 // onClick="checkOption()"
	var formObj = document.form;
	
	if(formObj.chk_unrate.checked && !formObj.chk_rate.checked){
		formObj.frm_sheet1_wbl_rt_tp_cd.value="N";
	}else if(!formObj.chk_unrate.checked && formObj.chk_rate.checked){		
		formObj.frm_sheet1_wbl_rt_tp_cd.value="Y";
	}else if(formObj.chk_unrate.checked && formObj.chk_rate.checked){
		formObj.frm_sheet1_wbl_rt_tp_cd.value="B";
	}else{
		formObj.frm_sheet1_wbl_rt_tp_cd.value="";
	}
}


/**
* fnPreSet
* obj와 value값으로 값을 선택한다.
* 
*/
function fnPreSet() {
	var formObj = document.form;
	//ComSetObjValue(formObj.frm_sheet1_obl_rt_icld_knt, 3);
	ComSetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt, 3);
	ComSetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt, 3);
	ComSetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt, 3);
	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,3);
	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,6);
	
	//return true;
}


/**
* fnRadioCheck
* obj와 value값으로 값을 선택한다.
* param : v_obj, v_value
*/
function fnRadioCheck(v_obj, v_value) {
	var radio = document.getElementsByName(v_obj);
	if (radio == null)
		return;
	if (v_obj=="bl_tp_cd" && v_value =="S") {
		radio[1].checked = true;
		radio[2].checked = true;
	}
	for ( var i = 0; i < radio.length; i++) {
		if (radio[i].value == v_value) {
			radio[i].checked = true;
			break;
		}
	}
}
/**
* fnNullToBlank
* null값인 경우 default값을 return한다.
* param : xval,yval
*/
function fnNullToBlank(xval,yval) {
    return (xval!= null && xval != "") ? xval : yval;
 } 
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {
	case IBSEARCH: // search   
		//<EXCEPTION>1.a BKG가 없을 경우 메시지 [BKG00463]를 표시한다.	
		if (ComGetObjValue(formObj.bkg_no) == ''){
			ComShowCodeMessage("BKG00463");
			return false;
		}
		break;
	case IBSAVE: // save

		if(formObj.bl_tp_cd3.checked)
			ComSetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd,"S");
		else
			ComSetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd,ComGetObjValue(formObj.bl_tp_cd));

		//Deliver To	
		ComSetObjValue(formObj.frm_sheet1_bl_de_to_cd, ComGetObjValue(formObj.bl_de_to_cd));
		//Method
		ComSetObjValue(formObj.frm_sheet1_bl_de_mzd_cd, ComGetObjValue(formObj.bl_de_mzd_cd));
		
	
		break;
	}
	return true;
}

 /**
  * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
  **/
 function obj_activate() {
 	//입력Validation 확인하기
 	switch (event.srcElement.name) {

 	case "frm_sheet1_rqst_iss_dt":
 		ComClearSeparator(event.srcElement);
 		break;
 	default:
 		break;
 	}
 }
 /**
  * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
  **/
 function obj_deactivate() {
	  var formObj = document.form;
	  
	  //입력Validation 확인하기
 	switch (event.srcElement.name) {

 	case "frm_sheet1_rqst_iss_dt":
 		ComAddSeparator(event.srcElement);
 		break;
 	case "frm_sheet1_obl_rt_incl_knt":
 		var sum = parseInt(ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt),10)+parseInt(ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt),10); 		
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,sum);
 		break;
 	case "frm_sheet1_obl_rt_xcld_knt":
 		var sum = parseInt(ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt),10)+parseInt(ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,sum);
 		break; 
 	case "frm_sheet1_non_nego_rt_incl_knt":
 		var sum = parseInt(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt),10)+parseInt(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,sum);
 		break;
 	case "frm_sheet1_non_nego_rt_xcld_knt":
 		var sum = parseInt(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt),10)+parseInt(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,sum);
 		break;  		
 	default:
 		break;
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
 * bkg_error_alert
 * param : msg, ex
 */
function bkg_error_alert(msg, ex) {
	alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}

function formSet(){
	
	var formObj = document.form;
	rqst_bl_tp_cd_old = ComGetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd);
	bl_de_to_cd_old = ComGetObjValue(formObj.frm_sheet1_bl_de_to_cd);
	bl_de_mzd_cd_old = ComGetObjValue(formObj.frm_sheet1_bl_de_mzd_cd);
	wbl_rt_tp_cd_old = ComGetObjValue(formObj.frm_sheet1_wbl_rt_tp_cd);

	obl_rt_incl_knt_old = ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt);
	obl_rt_xcld_knt_old = ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt);
	obl_ttl_knt_old = ComGetObjValue(formObj.frm_sheet1_obl_ttl_knt);

	non_nego_rt_incl_knt_old = ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt);
	non_nego_rt_xcld_knt_old = ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt);
	cpy_ttl_knt_old = ComGetObjValue(formObj.frm_sheet1_cpy_ttl_knt);

	wbl_eml = ComGetObjValue(formObj.frm_sheet1_wbl_eml);
	rqst_iss_plc_nm_old = ComGetObjValue(formObj.frm_sheet1_rqst_iss_plc_nm);
	rqst_iss_dt_old = ComGetObjValue(formObj.frm_sheet1_rqst_iss_dt);
	bl_doc_rqst_rmk_old = ComGetObjValue(formObj.frm_sheet1_bl_doc_rqst_rmk);
}
/* 개발자 작업  끝 */