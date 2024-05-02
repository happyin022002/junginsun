/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1427.js
*@FileTitle : Multi Rate BKG List for Audit(1)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.24
*@LastModifier : 전두태
*@LastVersion : 1.0
* 2017.10.24 전두태
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
 * @class esm_bkg_1427 : esm_bkg_1427 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1427() {
	this.processButtonClick	= tprocessButtonClick;
	this.setSheetObject		= setSheetObject;
	this.loadPage			= loadPage;
	this.initSheet			= initSheet;
	this.initControl		= initControl;
	this.doActionIBSheet	= doActionIBSheet;
	this.setTabObject		= setTabObject;
	this.validateForm		= validateForm;
}


/* 개발자 작업	*/
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btns_calendar1":	//달력버튼
				var cal = new ComCalendar();
				cal.select(form.from_dt, 'yyyy-MM-dd');
				break;
				
			case "btns_calendar2":
				var cal = new ComCalendar();
				cal.select(form.to_dt, 'yyyy-MM-dd');
				break;
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
				
			case "btn_New":
				removeAll(formObject);
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
				
			case "btn_DownExcel":						
				sheetObjects[0].Down2Excel(-1);
				break;
				
			case "btn_com_ens_ob2":
				var param = "";
				//param = param + "lane_cd=" + ComGetObjValue(form.vsl_slan_cd);
				//param = "loc_cd="+ComGetObjValue(form.pol_cd);
				//param = param + "&" + "pod_cd="+ComGetObjValue(form.pod_cd);
				param = param + "&" + "vvd_cd=" + form.t_vvd.value;
				//param = param + "&" + "etd_cd="+form.etd_cd.value;
				ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 780, 470, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
				break;
				
			case "btn_Remarks_Update":
				var remarks = trim(formObject.remarks_update.value);
				remarksUpdate(sheetObjects[0], remarks);
				break;
				
			case "btn_Confirm":
				doActionIBSheet(sheetObjects[0], document.form, MULTI01);
				break;
				
			case "btn_Release":
				doActionIBSheet(sheetObjects[0], document.form, MULTI02);
				break;
		}	// end switch
	} catch(e) {
		if(e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

        
/**
 * IBMulti Combo Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setComboObject(combo_obj);
 * </pre>
 * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */ 
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}


/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */
function loadPage() {
	var form = document.form;
	
	//IBMultiCombo초기화
	for(var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	
	for(i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);			
	axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		    
}


function sheet1_OnLoadFinish(sheetObj) {
	// Error Status 칼럼을 강제로 Merge 시키는 Script 가 IBSheet Error 를 발생시켜서 임시로 막아둠.         	 
	// sheetObj.SetMergeCell (0, 20, 2, 2);
	initIBComboItem();
} 


function obj_deactivate() {
	var form = document.form;
	var formObj = event.srcElement;
	var srcName = formObj.getAttribute("name");
	
	switch(srcName) {
		case "t_vvd":
		case "ctrt_no":
			break;
			
		default :
			ComChkObjValid(formObj);
		}
}


/** 
 * Object 의 Keypress 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음  
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2009.10.21
 */ 
function obj_keypress() {
	var obj = event.srcElement;
	
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
 	
	switch(obj.dataformat) {
		case "ymd":		//날짜 입력하기
			ComKeyOnlyNumber(obj,"-");
			break;
			
		case "int":		//숫자만 입력
		case "number":	//숫자만 입력
			ComKeyOnlyNumber(obj);
			break;
			
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
			
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
			
		default:
			//ComKeyOnlyNumber(obj);
			break;
	}
}


/**
 * OnBeforeActivate   event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_activate()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */  
function obj_activate() {
	ComClearSeparator (event.srcElement);	   
}


/**
 * IBSHEET COMBO를 LOAD하는 함수<br>
 * <br><b>Example :</b>
 * <pre>
 * 		initCombo(comboObj, comboNo)
 * </pre>
 * @return 없음
 * @author 조정민
 * @version 2009.06.10
 */ 
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
		case "rct_rhq_cd":
			var i = 0;
			with(comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
				MaxLength = 6;      // 6자리만 입력
			}
			break;
			
		case "bkg_ofc_cd":
			var i = 0;
			with(comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
				MaxLength = 6;      // 6자리만 입력
			}
			break;
			
		case "bkg_ctrt_tp_cd":
			var i = 0;
			with(comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
			}
			break;
			
		case "bdr_flg":
			var i = 0;
			with(comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(1, 2);    // 영문만 입력 + 특수문자
			}
			break;
	}
}


/**
 * rct_rhq_cd 변경시 활성화됨<br>
 * qttn_ver_no로 조회한다.<br>
 * <br><b>Example :</b>
 * <pre>
 * 		
 * </pre>
 * @param {comboObj} comboObj    필수,comboObj Object
 * @param {String} code    
 * @param {String} text 
 * @return 없음   
 * @author 조정민
 * @version 2009.06.10
 */ 
function rct_rhq_cd_OnChange(comboObj, code, text) {
	if(comboObj.Index == "0") {
		comboObjects[1].removeAll();
		return;
	}	
	
	if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
		var formObj = document.form;
		formObj.etc2.value 	= code;
 				
		// 조직도 combo2
		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, formObj.bkg_ofc_cd, "cd", "cd");
		formObj.bkg_ofc_cd.Code = formObj.strOfc_cd.value;
		formObj.bkg_ofc_cd.InsertItem(0,'','');
	} 
}


/**
 * IBMultiCombo 에 Item을 setting한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     initIBComboItem();
 * </pre>
 * @return 없음
 * @author 김대호
 * @version 2009.12.15
 */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'rct_rhq_cd'),         "|", "\t" );
    ComBkgTextCode2ComboItem(scpComboValue,			 scpComboText,		    getComboObject(comboObjects, 'svc_scp_cd'),         "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );

	document.form.bdr_flg.InsertItem(0, '', '');
	document.form.bdr_flg.InsertItem(1, 'Yes', 'Y');
	document.form.bdr_flg.InsertItem(2, 'No', 'N');
	
	document.form.por_pol_equals.InsertItem(0, '', '');
    document.form.por_pol_equals.InsertItem(1, 'Yes', 'Y');
    document.form.por_pol_equals.InsertItem(2, 'No', 'N');
    
    document.form.pod_del_equals.InsertItem(0, '', '');
    document.form.pod_del_equals.InsertItem(1, 'Yes', 'Y');
    document.form.pod_del_equals.InsertItem(2, 'No', 'N');
    
    document.form.multi_cntr.InsertItem(0, '', '');
    document.form.multi_cntr.InsertItem(1, 'Yes', 'Y');
    document.form.multi_cntr.InsertItem(2, 'No', 'N');
    
    document.form.sm_prime.InsertItem(0, '', '');
    document.form.sm_prime.InsertItem(1, 'Yes', 'Y');
    document.form.sm_prime.InsertItem(2, 'No', 'N');
    
    document.form.usr_ins_amt.InsertItem(0, '', '');
    document.form.usr_ins_amt.InsertItem(1, 'Yes', 'Y');
    document.form.usr_ins_amt.InsertItem(2, 'No', 'N');

    document.form.sgl_mlt_cd.InsertItem(0, '', '');
    document.form.sgl_mlt_cd.InsertItem(1, 'Single', 'S');
    document.form.sgl_mlt_cd.InsertItem(2, 'Multi', 'M');
    
    document.form.oft_cnt.InsertItem(0, '', '');
    document.form.oft_cnt.InsertItem(1, '1', '1');
    document.form.oft_cnt.InsertItem(2, '2', '2');
    document.form.oft_cnt.InsertItem(3, 'Over 2', 'Over 2');
    
    document.form.tpsz_cnt.InsertItem(0, '', '');
    document.form.tpsz_cnt.InsertItem(1, '1', '1');
    document.form.tpsz_cnt.InsertItem(2, '2', '2');
    document.form.tpsz_cnt.InsertItem(3, 'Over 2', 'Over 2');
    
    document.form.pls_zr_mnus_cd_1.InsertItem(0, '', '');
    document.form.pls_zr_mnus_cd_1.InsertItem(1, 'Plus', 'Plus');
    document.form.pls_zr_mnus_cd_1.InsertItem(2, 'Zero', 'Zero');
    document.form.pls_zr_mnus_cd_1.InsertItem(3, 'Minus', 'Minus');
    
    document.form.pls_zr_mnus_cd_2.InsertItem(0, '', '');
    document.form.pls_zr_mnus_cd_2.InsertItem(1, 'Plus', 'Plus');
    document.form.pls_zr_mnus_cd_2.InsertItem(2, 'Zero', 'Zero');
    document.form.pls_zr_mnus_cd_2.InsertItem(3, 'Minus', 'Minus');
    
    document.form.pls_zr_mnus_cd_3.InsertItem(0, '', '');
    document.form.pls_zr_mnus_cd_3.InsertItem(1, 'Plus', 'Plus');
    document.form.pls_zr_mnus_cd_3.InsertItem(2, 'Zero', 'Zero');
    document.form.pls_zr_mnus_cd_3.InsertItem(3, 'Minus', 'Minus');
    
    document.form.usr_upd_cfm_flg.InsertItem(0, '', '');
    document.form.usr_upd_cfm_flg.InsertItem(1, 'Y', 'Y');
    document.form.usr_upd_cfm_flg.InsertItem(2, 'N', 'N');
}


/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	
	switch(sheetID) {
		case "sheet1":	// sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 370;
				
				// 높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다.
				AutoRowHeight = false;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				// MergeSheet = msHeaderOnly;
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				InitRowInfo(2, 1, 2, 100);
				var HeadTitle1 = "|Sel.|BKG No|Single\nMulti|OFT\nCount|CNTR TP\nCount|RHQ|Office|Service\nScope|Application\nDate|BDR|Contract\nType|Contract No|Commodity|Commodity|Cargo\nType|POR|POL|POD|DEL|T/VVD|POR\n= POL|POD\n= DEL|Multi\nCNTR|1st|1st|1st|1st|1st|1st|2nd|2nd|2nd|2nd|2nd|2nd|Amount|Amount|Amount|Amount|PSA\nGroup|SM\nPrime|Actual\nCustomer|Remarks|Audit\nAmount|Confirm\nFlag|Confirm Date|Update Date|";
				var HeadTitle2 = "|Sel.|BKG No|Single\nMulti|OFT\nCount|CNTR TP\nCount|RHQ|Office|Service\nScope|Application\nDate|BDR|Contract\nType|Contract No|Code|Name|Cargo\nType|POR|POL|POD|DEL|T/VVD|POR\n= POL|POD\n= DEL|Multi\nCNTR|PT|CMDT Desc|Per|Cargo\nType|Amount|Route Note|PT|CMDT Desc|Per|Cargo\nType|Amount|Route Note|BKG|BKG - 1st|BKG - 2nd|BKG - \nCommodity|PSA\nGroup|SM\nPrime|Actual\nCustomer|Remarks|Audit\nAmount|Confirm\nFlag|Confirm Date|Update Date|";
				
				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 4, 0, false);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
				
				// 해더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				// 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter, 	false,	"ibflag");
				InitDataProperty(0, cnt++,	dtCheckBox,		40,		daCenter,	true,	"chk",						false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++,	dtPopup,		110,	daCenter,	true,	"bkg_no",					false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"sgl_mlt_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"oft_cnt",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"tpsz_cnt",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"rct_rhq_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"bkg_ofc_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daCenter,	true,	"svc_scp_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			80,		daCenter,	true,	"rt_aply_dt",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"bdr_flg",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daCenter,	true,	"bkg_ctrt_tp_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			90,		daCenter,	true,	"ctrt_no",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daCenter,	true,	"cmdt_cd",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			190,	daLeft,		true,	"cmdt_nm",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,	"prc_cgo_tp_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			63,		daCenter,	true,	"por_cd",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			63,		daCenter,	true,	"pol_cd",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			63,		daCenter,	true,	"pod_cd",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			63,		daCenter,	true,	"del_cd",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			80,		daCenter,	true,	"t_vvd",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "por_pol_equals",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "pod_del_equals",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "multi_cntr",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			70,		daCenter,   true,   "prc_rt_mtch_patt_cd_1",	false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			190,	daLeft,		true,   "cmdt_nm_1",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "rat_ut_cd_1",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "prc_cgo_tp_cd_1",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daRight,	true,   "fnl_frt_rt_amt_1",			false,	"",	dfNumber,	0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			190,	daLeft,		true,   "note_ctnt_1",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			70,		daCenter,   true,   "prc_rt_mtch_patt_cd_2",	false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			190,	daLeft,		true,   "cmdt_nm_2",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "rat_ut_cd_2",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "prc_cgo_tp_cd_2",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daRight,	true,   "fnl_frt_rt_amt_2",			false,	"",	dfNumber,	0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			190,	daLeft,		true,   "note_ctnt_2",				false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daRight,	true,   "chg_ut_amt",				false,	"",	dfNumber,	0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daCenter,   true,   "pls_zr_mnus_cd_1",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			60,		daCenter,   true,   "pls_zr_mnus_cd_2",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			70,		daCenter,   true,   "pls_zr_mnus_cd_3",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,   "psa_no",					false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,	true,   "sm_prime",					false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			70,		daCenter,	true,   "act_cust",					false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			190,	daLeft,		true,   "usr_upd_ctnt",				false,	"",	dfNone,		0,  true,	true);
				InitDataProperty(0, cnt++,	dtData,			70,		daRight,	true,   "usr_ins_amt",				false,	"",	dfNumber,	0,  true,	true);
				InitDataProperty(0, cnt++,	dtData,			50,		daCenter,   true,   "usr_upd_cfm_flg",			false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			130,	daCenter,   true,   "cfm_dt",					false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtData,			110,	daCenter,   true,   "upd_dt",					false,	"",	dfNone,		0,  false,	false);
				InitDataProperty(0, cnt++,	dtHidden,		80,		daCenter,	true,	"bl_cnt",					false,	"",	dfNone,		0,	false,	false);
				
				Ellipsis = true;
				ShowButtonImage = 2;
				CountPosition = 0;
			}
			break;
	}
}


/**
 * Sheet관련 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 조정민
 * @version 2009.04.17
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var form = document.form;
	
	var chkRows = sheetObj.FindCheckedRow("chk");
	var arrRow = chkRows.split("|");
	var arrLen = arrRow.length - 1;
	var usr_upd_cfm_flg = "";
	var rowCnt = sheetObj.Rows - sheetObj.HeaderRows;
	
	switch(sAction) {
		case IBSEARCH:	// Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1427GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);	// Grid1.
				ComOpenWait(false);
			}
			break;
        
		case IBSAVE:	// Save
			// 업무처리중 버튼사용 금지 처리
			ComOpenWait(true);
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_BKG_1427GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			
		case MULTI01:	// Confirm
			for (var i = 0; i < rowCnt; i++) {						// 전체 행애서
				sheetObj.RowStatus(i + sheetObj.HeaderRows) = "";	// ibflag값 지우고
			}
			
			// Confirm Flag를 N -> Y로 변경.. 이미 Y인 Row가 선택된 경우 Confirm 취소처리
			for (var i = 0; i < arrLen; i++) {										// Sel.로 선택된 행만
				sheetObj.RowStatus(arrRow[i]) = "U";								// ibflag에 UPD 표시
				
				usr_upd_cfm_flg = sheetObj.CellValue(arrRow[i], "usr_upd_cfm_flg");	// Confirm Flag의 값을 가져와서
				if (usr_upd_cfm_flg == "Y") {										// Y이면 (Confirm을 받았으면) UPDATE 취소
					ComShowCodeMessage("BKG95133", sheetObj.CellValue(arrRow[i], "bkg_no"));
					return false;
				}
			}
			
			// 업무처리중 버튼사용 금지 처리
			ComOpenWait(true);
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESM_BKG_1427GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			
		case MULTI02:	// Release
			for (var i = 0; i < rowCnt; i++) {						// 전체 행에서
				sheetObj.RowStatus(i + sheetObj.HeaderRows) = "";	// ibflag값 지우고
			}
			
			// Confirm Flag를 Y -> N으로 변경.. 아직 N인 Row가 선택된 경우 Release 취소처리
			for (var i = 0; i < arrLen; i++) {										// Sel.로 선택된 행만
				sheetObj.RowStatus(arrRow[i]) = "U";								// ibflag에 UPD 표시
				
				usr_upd_cfm_flg = sheetObj.CellValue(arrRow[i], "usr_upd_cfm_flg");	// Confirm Flag의 값을 가져와서
				if (usr_upd_cfm_flg == "N") {										// N이면 (Confirm을 받지 않았으면) UPDATE 취소
					ComShowCodeMessage("BKG95134", sheetObj.CellValue(arrRow[i], "bkg_no"));
					return false;
				}
			}
			
			// 업무처리중 버튼사용 금지 처리
			ComOpenWait(true);
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_BKG_1427GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         로직처리;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 조정민
 * @version 2009.04.17
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:	// 조회
			var fmDtObj = form.from_dt;
	 		var toDtObj = form.to_dt;
			var fmDtValue = fmDtObj.value.replace(/-/g, '');
			var toDtValue = toDtObj.value.replace(/-/g, '');
			
			if("" == comboObjects[0].Code) {
				ComShowCodeMessage("BKG95025", "RHQ");
				ComSetFocus(fmDtObj);
				return false;
			}
			
	 		if("" == fmDtValue || "" == toDtValue) {
	 			ComShowCodeMessage("BKG95025", "Date");	// "Please input {?msg2}."
	 			if("" == fmDtValue) {
	 				ComSetFocus(fmDtObj);
	 			} else {
	 				ComSetFocus(toDtObj);
	 			}
	 			return false;
	 		}

    		if(!ComChkObjValid(fmDtObj)) {return false;}
    		if(!ComChkObjValid(toDtObj)) {return false;}
			if(!chkDate(formObj)) {return false;}

			return true;
			break;
	}
}


/**
 * 화면을 전체 리셋한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     removeAll(formObj)
 * </pre>
 * @param {formObj} formObj    
 * @return 없음
 * @author 조정민
 * @version 2009.06.10
 */
function removeAll(formObj) {
	formObj.reset();
	/***************************************/
	comboObjects[1].removeAll();	// 순서
	comboObjects[0].Index = "-1";	// 중요
	/***************************************/
	comboObjects[2].Index = "-1";
	comboObjects[3].Index = "-1";
	sheetObjects[0].RemoveAll();
}


function setCallBack0B2(aryPopupData) {
	var form = document.form;
	//form.etd_cd.value = ComGetMaskedValue(aryPopupData[0][5], "ymd");
	//var strValue = aryPopupData[0][7];
	form.t_vvd.value = aryPopupData[0][7];
	//form.vsl_cd.value = strValue.substr(0, 4);
	//form.skd_voy_no.value = strValue.substr(4, 4);
	//form.skd_dir_cd_txt.value = strValue.substr(8);
}


function chkDate(formObj) {
	var form = document.form;
	var fmDtObj = form.from_dt;
	var toDtObj = form.to_dt;
	var fmDtValue = fmDtObj.value.replace(/-/g, '');
	var toDtValue = toDtObj.value.replace(/-/g, '');
	
	if(fmDtValue != "" && toDtValue != "") {
		if(parseInt(fmDtValue, 10) > parseInt(toDtValue, 10)) {
			ComShowCodeMessage("BKG95026", "From Date", "To Date");
			event.returnValue = false;
			ComSetFocus(formObj);
			
			return false;
		}
		
		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 99, "", true);	// 100일
		
		if(parseInt(toDtValue,10) > parseInt(fromAddDays,10)) {
			ComShowCodeMessage("BKG95027", "100 days");	// "The period of Date can't be over {?msg1}."
			event.returnValue = false;
			ComSetFocus(formObj);
			
			return false;
		}
	}
	
	return true;
}


function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var form		= document.form;
	var colName		= sheetObj.ColSaveName(Col);
	var sName		= sheetObj.ColSaveName(Col);
	var scRfaNo		= sheetObj.CellValue(Row, "ctrt_no");
	var ctrtTpCd	= sheetObj.CellValue(Row, "ctrt_tp_cd");
	var bkgNo		= sheetObj.CellValue(Row, "bkg_no");
	
	switch(colName) {
		case "bkg_no":
			if(null == bkgNo || "" == bkgNo) {return;}
			
			var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
			comRASCallPop("ESM_BKG_0079", "ESM_BKG_1423", popParams, "");
			break;
			
		/*
		case "ctrt_no":
			if(null == scRfaNo || "" == scRfaNo) {return;}
			
			var pgmNo = "ESM_PRI_0004";
			var scRfaNoP = scRfaNo.substr(0, 3);
			var scRfaNoS = scRfaNo.substr(3);
			var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.fm_dt.value + "&exp_dt=" + form.to_dt.value;
			
			if(ctrtTpCd == "RFA") {			// RFA
				pgmNo = "ESM_PRI_2019";
				popParams = "s_rfa_no=" + scRfaNo;
			} else if(ctrtTpCd == "T") {	// TAA
				pgmNo = "ESM_PRI_3007";
				popParams = "cond_taa_no=" + scRfaNo;  
			}
			
			comRASCallPop(pgmNo, "ESM_BKG_1423", popParams, "");
			break;
		*/
	}
}


function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var form = document.form;
	
	if(sheetObj.RowCount > 0) {
		form.bl_cnt.value = sheetObj.CellValue(2, "bl_cnt");
	} else {
		form.bl_cnt.value = "0";
	}
}


function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	var row = sheetObj.MouseRow;
    var col = sheetObj.MouseCol;
	var colname = sheetObj.ColSaveName(col);
	var sText = sheetObj.CellText(row, col);
	var toolTipOption = "balloon:true;width:1000;icon:1;title:";
	
	sheetObj.MouseToolTipText = sText;	//풍선도움말 만들기
	switch(colname) {
		case "note_ctnt_1":
			sheetObj.ToolTipOption = toolTipOption + "1st Route Note";
			break;
		case "note_ctnt_2":
			sheetObj.ToolTipOption = toolTipOption + "2nd Route Note";
			break;
		case "usr_upd_ctnt":
			sheetObj.ToolTipOption = toolTipOption + "Remarks";
			break;
		default:
			sheetObj.ToolTipOption = "";
			sheetObj.MouseToolTipText = "";
			break;
	}
}


function sheet1_OnDblClick(sheetObj, Row, Col) {
	var colname = sheetObj.ColSaveName(Col);
	var rowTop = (sheetObj.RowTop(Row) - sheetObj.RowHeight(0) * 2) / sheetObj.DataRowHeight;	// Top에서 선택한 행까지 순번
	var viewRows = sheetObj.ViewRows - sheetObj.HeaderRows - 1;									// 한 화면에 보여지는 행 개수
	
	switch(colname) {
		case "chk":
			for (var i = Row; i < Row + viewRows - rowTop; i++) {
				if (sheetObj.CellValue(Row, 1) == "1") {
					sheetObj.CellValue(i, 1) = "Y";
				} else {
					sheetObj.CellValue(i, 1) = "N";
				}
			}
			break;
	}
}


function trim(stringToTrim) {
    return stringToTrim.replace(/^\s+|\s+$/g, "");
}


function remarksUpdate(sheetObj, remarks) {
	var chkRows = sheetObj.FindCheckedRow("chk");
	var arrRow = chkRows.split("|");
	var arrLen = arrRow.length - 1;
	
	if (arrLen > 0) {
		for (var i = 0; i < arrLen; i++) {
			sheetObj.CellValue(arrRow[i], "usr_upd_ctnt") = remarks;
		}
	}
}
/* 개발자 작업  끝 */