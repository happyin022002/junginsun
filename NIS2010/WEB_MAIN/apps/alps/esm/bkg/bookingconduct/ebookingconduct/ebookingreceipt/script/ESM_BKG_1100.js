﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1100.js
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class esm_bkg_1100 : esm_bkg_1100 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1100() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var comboObjects = new Array();
var comboCnt = 0;

var arrMultiCombo;//멀티콤보 세팅할 변수

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_new":
				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				break; 
			case "btn_exceldown":
				doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown");
				break;
			case "btn_save_remark":
				doActionIBSheet(sheetObjects[0],document.form,"btn_save_remark");
				break;
			case "btn_confirm":
				doActionIBSheet(sheetObjects[0],document.form,"btn_confirm");
				break;
			case "btn_reject":
				doActionIBSheet(sheetObjects[0],document.form,"btn_reject");
				break;
			case "btn_undo":
				doActionIBSheet(sheetObjects[0],document.form,"btn_undo");
				break;
			case "btns_calendar":
				var cal = new ComCalendarFromTo();
				cal.select(formObj.rqst_from_dt, formObj.rqst_to_dt,'yyyy-MM-dd');
				break;
			case "rdo_srch_mandatory":
				if ("rqst_dt"==ComGetObjValue(formObj.rdo_srch_mandatory)) {
					formObj.rqst_from_dt.className = "input1";
					formObj.rqst_to_dt.className = "input1";
					formObj.vvd.className = "input";
				} else {
					formObj.rqst_from_dt.className = "input";
					formObj.rqst_to_dt.className = "input";
					formObj.vvd.className = "input1";
				}
				break;
		}
	} catch(e) {
		if(e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 콤보 Object를 배열로 등록
 * @param combo_obj 콤보오브젝트
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

function initCombo(comboObj) {
 	comboObj.MultiSelect = true;
 	comboObj.UseCode = true;
 	comboObj.LineColor = "#ffffff";
 	comboObj.SetColAlign("left|left");
 	comboObj.MultiSeparator = ",";
}    

function initControl() {
	var formObject = document.form;
	axon_event.addListenerForm("keydown",	"obj_keydown", formObject);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject);
	axon_event.addListenerFormat("focus", "form_onFocus", formObject);
	axon_event.addListenerFormat("blur" , "form_onBlur" , formObject);
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i=0;i<sheetObjects.length;i++) {
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	comboCnt = comboObjects.length;
	for (var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
	case 1:      //sheet1 init
		with (sheetObj) {
			style.height = 340;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(2, 1, 3, 100);
			InitColumnInfo(49, 0, 0, true);
			InitHeadMode(true, true, true, true, false,false)

			var HeadTitle1 = "||SEQ|Cfm|RQST Date|U/L|Booking No.|RQST STS|RQST STS|Shipper Name|VVD|QTY|QTY|Est.WGT(KGS)|POR|T/S Port|POD|DEL|C|P/C|Customer Ref.NO|CNEE Name|SC No|RFA No|Ship Date|Space Controller Remark";
			var HeadTitle2 = "||SEQ|Cfm|RQST Date|U/L|Booking No.|SEQ|Ver.|Shipper Name|VVD|TEU|FEU|Est.WGT(KGS)|POR|T/S Port|POD|DEL|C|P/C|Customer Ref.NO|CNEE Name|SC No|RFA No|Ship Date|Space Controller Remark";
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, true, "ibflag"  );
			InitDataProperty(0, cnt++, dtCheckBox,      20, daCenter, true, "slct_flg");
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "row_num",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "xter_rqst_acpt_cd",    false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "rqst_dt",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "bkg_upld_sts_cd",      false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          90, daLeft,   true, "bkg_no",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "xter_rqst_seq",        false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "xter_bkg_rqst_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,         200, daLeft,   true, "sh_nm",                false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData,          80, daCenter, true, "vvd",                  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          50, daRight,  true, "teu",                  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          50, daRight,  true, "feu",                  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          90, daRight,  true, "est_wgt",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          50, daCenter, true, "xter_por_cd",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          54, daCenter, true, "pod_cd",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          50, daCenter, true, "xter_pod_cd",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          50, daCenter, true, "xter_del_cd",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "delivery",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          30, daCenter, true, "frt_term",             false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData,         110, daLeft,   true, "mdfy_xter_rqst_no",    false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,         200, daLeft,   true, "cn_nm",                false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "sc_no",                false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "rfa_no",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++,  dtData,        100, daCenter, true,     "rqst_dep_dt", 	   false,     "",      dfDateYmd, 0,        false,        false);
			InitDataProperty(0, cnt++, dtData,         120, daCenter, true, "spc_ctrlr_rmk",               false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "doc_tp_cd",            false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "xter_rqst_via_cd",     false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "xter_pol_cd",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "bkg_pod_cd",           false, "", dfNone, 0, false, false);
			//InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "rqst_dep_dt",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "skd_voy_no",           false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "po_no",                false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "cntc_eml",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "ofc_cd",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "upld_usr_id",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "upld_usr_nm",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "upld_dt",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "xter_sndr_id",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "vsl_cd",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "bkg_sts_cd",           false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "snaccs_split_no",      false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "xter_rqst_no",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "max_seq",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "sum_teu",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "sum_feu",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "sum_ttl",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "sum_wgt",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "sum_uld",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "sum_unu",              false, "", dfNone, 0, false, false);

			CountPosition = 0;
			sheetObj.FrozenCols = 7;
		}
		break;
	}
}

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBCLEAR:
				initCom(formObj);
				ComClearObject(formObj.xter_bkg_rqst_sts_cd);
				ComClearObject(formObj.doc_tp_cd);
				ComClearObject(formObj.delivery);
				ComClearObject(formObj.pol_cd);
				formObj.rqst_from_dt.value = ComGetDateAdd(null, "d", -1, "-");
				formObj.rqst_to_dt.value = ComGetNowInfo();
				sheetObj.RemoveAll();
				break;

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	        	formObj.f_cmd.value = SEARCH;
	    		sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
	         	sheetObj.DoSearch("ESM_BKG_1100GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;
				
			case "btn_exceldown":
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				sheetObj.SpeedDown2Excel(1);
				ComOpenWait(false);
				break;
				
			case "btn_save_remark":
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if (ComShowCodeConfirm("BKG00824")) {  //"Do you want to save?"
					formObj.f_cmd.value = MODIFY04;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_1100GS.do",FormQueryString(formObj)+"&"+sheetObj.GetSaveString(false,true,"spc_ctrlr_rmk"));
					ComOpenWait(false);
					var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if ("S"==State) {
				     	doActionIBSheet(sheetObj,formObj,IBSEARCH);
					} else {
						ComShowCodeMessage("BKG00391");  //"Failed to save data."
					}
				}
				break;

			case "btn_confirm":      //Confirm
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if (ComShowCodeConfirm("BKG00824")) {  //"Do you want to save?"
					formObj.f_cmd.value = MODIFY01;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_1100GS.do",FormQueryString(formObj)+"&"+sheetObj.GetSaveString(false,true,"slct_flg"));
					ComOpenWait(false);
					var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if ("S"==State) {
				     	sheetObj.LoadSaveXml(sXml,false,"slct_flg");
				     	doActionIBSheet(sheetObj,formObj,IBSEARCH);
					} else {
						ComShowCodeMessage("BKG00391");  //"Failed to save data."
					}
				}
				break;

			case "btn_reject":      //Reject
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if (ComShowCodeConfirm("BKG00824")) {  //"Do you want to save?"
					formObj.f_cmd.value = MODIFY02;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
			     	var sXml = sheetObj.GetSaveXml("ESM_BKG_1100GS.do",FormQueryString(formObj)+"&"+sheetObj.GetSaveString(false,true,"slct_flg"));
					ComOpenWait(false);
					var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if ("S"==State) {
				     	sheetObj.LoadSaveXml(sXml,false,"slct_flg");
				     	doActionIBSheet(sheetObj,formObj,IBSEARCH);
					} else {
						ComShowCodeMessage("BKG00391");  //"Failed to save data."
					}
				}
				break;

			case "btn_undo":      //Undo
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if (ComShowCodeConfirm("BKG00824")) {  //"Do you want to save?"
					formObj.f_cmd.value = MODIFY03;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_1100GS.do",FormQueryString(formObj)+"&"+sheetObj.GetSaveString(false,true,"slct_flg"));
					ComOpenWait(false);
					var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if ("S"==State) {
				     	sheetObj.LoadSaveXml(sXml,false,"slct_flg");
				     	doActionIBSheet(sheetObj,formObj,IBSEARCH);
					} else {
						ComShowCodeMessage("BKG00391");  //"Failed to save data."
					}
				}
				break;

        }
    }

	/*
	 * 모든 조건 값들을 초기화 한다.
	 * */
    function initCom(formObject){    	
		var sXml = ComGetObjValue(formObject.sXml);
		arrMultiCombo = sXml.split(iterator); 
		ComXml2ComboItem(arrMultiCombo[0], formObject.delivery, "val", "val|desc");
		ComXml2ComboItem(arrMultiCombo[1], formObject.bkg_upld_sts_cd, "val", "val|desc");
		ComXml2ComboItem(arrMultiCombo[2], formObject.doc_tp_cd, "val", "val|desc");
		ComXml2ComboItem(arrMultiCombo[3], formObject.xter_bkg_rqst_sts_cd, "val", "val|desc");
		formObject.bkg_upld_sts_cd.CheckIndex(0) = true;
		formObject.bkg_upld_sts_cd.CheckIndex(2) = true;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:
			if ("rqst_dt"==ComGetObjValue(formObj.rdo_srch_mandatory)) {
				if (ComIsEmpty(formObj.rqst_from_dt)) {
					ComShowCodeMessage("COM12114", "\"Request Date(from)\"");
					formObj.rqst_from_dt.focus();
					return false;
				}
				if (ComIsEmpty(formObj.rqst_to_dt)) {
					ComShowCodeMessage("COM12114", "\"Request Date(to)\"");
					formObj.rqst_to_dt.focus();
					return false;
				}
				if (!ComIsEmpty(formObj.rqst_from_dt) && !ComIsEmpty(formObj.rqst_to_dt)) {
					if (0 > ComGetDaysBetween(formObj.rqst_from_dt,formObj.rqst_to_dt)) {
						ComShowMessage(msgs['BKG00112']);
						return false;
					}
		            if (30 < ComGetDaysBetween(formObj.rqst_from_dt,formObj.rqst_to_dt)) {
		                ComShowCodeMessage("BKG00756","\"Duration","30Days\"");  //{?msg1} exceeds maximum duration {?msg2}.
		                formObj.rqst_to_dt.focus();
		                return false;
		            }
				}
			} else {
				if (ComIsEmpty(formObj.vvd)) {
					ComShowCodeMessage("COM12114", "\"VVD\"");
					formObj.vvd.focus();
					return false;
				}
				/*
				if ((ComIsEmpty(formObj.rqst_from_dt) && !ComIsEmpty(formObj.rqst_to_dt)) ||
					(!ComIsEmpty(formObj.rqst_from_dt) && ComIsEmpty(formObj.rqst_to_dt))) {
					if (ComIsEmpty(formObj.rqst_from_dt)) {
						ComShowCodeMessage("COM12114", "\"Request Date(from)\"");
						formObj.rqst_from_dt.focus();
					} else {
						ComShowCodeMessage("COM12114", "\"Request Date(to)\"");
						formObj.rqst_to_dt.focus();
					}
					return false;
				}
				*/
			}
			break;

		case "btn_exceldown":
			if (sheetObj.RowCount == 0) {
				return false;
			}
			break;

		case "btn_confirm":
		case "btn_reject":
		case "btn_undo":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			break;
		}
	}
    return true;
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	if (sheetObj.RowCount > 0) {
		var formObj = document.form;
		if (0<sheetObj.RowCount) {
			formObj.tot_teu.value = ComAddComma(sheetObj.CellValue(2,"sum_teu"));
			formObj.tot_feu.value = ComAddComma(sheetObj.CellValue(2,"sum_feu"));
			formObj.tot_ttl.value = ComAddComma(sheetObj.CellValue(2,"sum_ttl"));
			formObj.tot_wgt.value = ComAddComma(sheetObj.CellValue(2,"sum_wgt"));
			formObj.tot_uld.value = ComAddComma(sheetObj.CellValue(2,"sum_uld"));
			formObj.tot_unu.value = ComAddComma(sheetObj.CellValue(2,"sum_unu"));
		}
		for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if ("R"==sheetObj.CellValue(i, "xter_rqst_acpt_cd")) {
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
			} else if ("C"==sheetObj.CellValue(i, "xter_rqst_acpt_cd")) {
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(0,0,255);
			} else if ("N"==sheetObj.CellValue(i, "xter_rqst_acpt_cd")) {
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(0,0,0);
			}
		}
	}
}

/**
 * 마우스 IN일때 
 */
function form_onFocus(){
	//입력Validation 확인하기
	switch(event.srcElement.name){	
    	case "rqst_from_dt":
    		ComClearSeparator(event.srcElement);
			break;
    	case "rqst_to_dt":
    		ComClearSeparator(event.srcElement);
			break;
	}
}

function form_onBlur(){
	switch(event.srcElement.name){
    	case "rqst_from_dt":
    		ComAddSeparator(event.srcElement);
			break;
    	case "rqst_to_dt":
    		ComAddSeparator(event.srcElement);
			break;
	}
}

function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;
	if ( vKeyCode == 13 ) {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	return true;
}
