/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1204.js
*@FileTitle : CPS Payable Charge Creation-Invoice Import
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.12 조경완
* 1.0 Creation
* -------------------------------------------------------------
* history
* 2013.06.26 조경완 [CHM-201324911-01] ALPS-CHSS-COPS 기능 Trouble Shooting을 위한 CSR
* 2014-08-20 Chang Young Kim
*  [CHM-201431524] COPS Invoice Audit 시, Charge Creation때, File Import 추가 수정 건
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ees_cgm_1204 : ees_cgm_1030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1204() {
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
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Loadexcel":
			doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
			break;

		case "btn_Downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;

		case "btn_Save":
			//doActionIBSheet(sheetObject1, formObject, MULTI01); // 기존
			doActionIBSheet(sheetObject1, formObject, MULTI05); // To Save Type of Invoice  except for Usage/Rebill : Only CGM_LSE_CHG_HDR
			break;

		case "btn_New":
			initPage();
			break;

		case "btn_Agreemapping":

			var pgmNo = 'EES_CGM_1028';
			var pgmUrl = '/hanjin/EES_CGM_1028.do';
			var parentPgmNo = pgmNo.substring(0, 8) + 'M001';
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&pgmNo="
					+ pgmNo;

			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
			var winObj = window.open("alpsMain.screen?parentPgmNo="
					+ parentPgmNo + src, "", sFeatures);

			break;

		case "btn_Audit":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

		case "btn_Close":
			window.close();
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	
	comboObjects[comboCnt++] = document.cmb_inv_tp;
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k]);
	}

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	
	initControl();

}

function initControl() {

	var formObj = document.form;
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
    axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
	sheetObjects[0].RemoveAll();
	formObj.vrfy_scs_flg.value = "N";
	ComBtnDisable("btn_Audit");
	ComBtnDisable("btn_Save");
}

function initPage() {
	/**************** 시트변수 지정하여 사용 ***************/
	var sheetObject1 = sheetObjects[0];
	/** ****************************************************/
	var formObj = document.form;
	
	sheetObject1.RemoveAll();
	
	with(formObj) {
		
		cmb_inv_tp.Index2 = 0;	// Invoice Type => Usage/Rebill
		org_inv_no.value = "";	// Original Invoice No => Initialization
		inv_no.value = "";		// Invoice No => Initialization
		
	}
	
	ComBtnDisable("btn_Audit");
	ComBtnDisable("btn_Save");
	ComBtnEnable("btn_Loadexcel");
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 280;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
			
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq.|Chassis No.|Container No.|Size|Charge Type|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Used Days|Bill Days|Rental Rate|Tax Rate|Rate Sum|Tax Sum|Booking No|Gate Activity ID|Bill To Mode"
							+ "|||||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,	prefix+"ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, prefix+"seq");
			InitDataProperty(0, cnt++, dtData, 125, daCenter, false, prefix+"inv_eq_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, prefix+"inv_cust_eq_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,	prefix+"inv_cust_eq_tpsz_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, prefix+"inv_chg_tp_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, prefix+"inv_eq_onh_loc_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,	prefix+"inv_eq_onh_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix+"inv_eq_offh_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, prefix+"inv_bil_st_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, prefix+"inv_bil_end_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,	prefix+"inv_lse_use_dys", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix+"inv_bil_ut_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix+"inv_lse_rt_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,	prefix+"inv_tax_amt", false, "", dfNone, 0, false, false);
			
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix+"inv_lse_chg_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix+"tax_smry_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, prefix+"inv_bkg_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, prefix+"inv_gate_act_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix+"inv_bil_mod_rmk", false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtData, 100, daCenter, false,"vrfy_rslt_desc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,prefix+"agmt_ofc_cty_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,prefix+"agmt_seq");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,prefix+"agmt_ver_no");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,prefix+"agmt_lstm_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,prefix+"vrfy_scs_flg");

		// chungpa 20091209 추가. save용 start.
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, prefix+"inv_cr_amt");
			
			// chungpa 20091209 추가. save용 end.

			// chungpa 20100428 추가. save용 start.
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, prefix+"inv_seq");
			// chungpa 20100428 추가. save용 end.
			InitDataValid(0, prefix+"inv_cust_eq_no", vtEngUpOther, "0123456789");
			
			WordWrap = true;
			// CountPosition = 0;
		}
		break;
	}
}

/**
 * Combo Object 초기화  <br>
 * @param  {object} comboObj	필수 Combo Object
 * @return 없음
 * @author 김창식
 * @version 2009.05.25
 */
function initCombo(comboObj) {
			
	switch(comboObj.id) {
	case "cmb_inv_tp":
		with(comboObj) {
			Code = "";
			Text = "";
			DropHeight = 100;
			MultiSelect = false;
			MaxSelect = 1;
			UseCode = true;
			UseAutoComplete = true;
			SetColWidth("100");
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

//	case MULTI01: // Verify
//
//		// Dup Check
//		// var duprows = sheetObj.ColValueDupRows("inv_eq_no|inv_no|chg_cd");
//
//		// var arrDuprows = duprows.split(",")
//	
//		sheetObj.WaitImageVisible=false;
//		ComOpenWait(true);	
//		
//		formObj.f_cmd.value = MULTI01;
//		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
//		
//		// var sParam = sheetObjects[0].GetSaveString(true);
//		var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
//		sParam = sParam + "&";
//		sParam = sParam + FormQueryString(formObj);
//		var sXml = sheetObj.GetSaveXml("EES_CGM_1030GS.do", sParam);
//		sheetObj.LoadSearchXml(sXml);
//
// 		ComOpenWait(false);	
// 		
//		// verify 성공여부를 hidden parametre에 저장 (성공 : Y, 실패 : N)
//		// Service에서의 체크로직이 성공인지를 확인한다.
//		if (sheetObj.FindText("vrfy_scs_flg", 'N') == -1) {
//			formObj.vrfy_scs_flg.value = "Y";
//			ComBtnEnable("btn_Audit");
//		} else {
//			formObj.vrfy_scs_flg.value = "N";
//			ComBtnDisable("btn_Audit");
//		}

		// Service에서 체크가 모두 성공했으면 중복체크 로직을 수행한다.
		/*
		 * if(formObj.vrfy_scs_flg.value == 'Y'){ // Dup Check
		 * sheetObj.SpaceDupCheck = false; var duprows =
		 * sheetObj.ColValueDupRows("agmt_seq|inv_eq_no|chg_cd");
		 * 
		 * var arrDuprows = duprows.split(",");
		 * 
		 * if(arrDuprows.length > 0 && duprows !=''){
		 * 
		 * for(var i = 0; i < arrDuprows.length; i++){
		 * sheetObj.cellValue(arrDuprows[i], "vrfy_rslt_desc") = "Please check
		 * up the Duplicated Chassis No"; sheetObj.RowFontColor(arrDuprows[i]) =
		 * sheetObj.RgbColor(255,0,0); //RED 로 변경 }
		 * 
		 * formObj.vrfy_scs_flg.value = "N"; } else { formObj.vrfy_scs_flg.value =
		 * "Y"; } }
		 */

//		break;
	case MULTI05: // To Save Type of Invoice  except for Usage/Rebill : Only CGM_LSE_CHG_HDR
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		
		if(!validateForm(sheetObj, formObj, sAction)) {
//			ComShowCodeMessage('CGM10004', "Invoice No");
			ComOpenWait(false);	
			return;
			
		}else { // invoice no 중복 체크
			formObj.f_cmd.value = SEARCH;
			
			//var sParam = sheetObjects[0].GetSaveString(true);
			var sParam = "";
			sParam = sParam + "&";
			sParam = sParam + FormQueryString(formObj);
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1204GS.do", sParam);	
			var invFlag = ComGetEtcData(sXml, "invFlag");

			if(invFlag=="F") {
				ComShowCodeMessage('CGM10086', "'" + formObj.inv_no.value + "'");
				ComOpenWait(false);	
				return;
			}
		}
		// msgs['CGM20066'] = 'Do you want to {?msg1}?';
		if(ComShowCodeConfirm('CGM20066', "Save The Invoice?")) {
		
			formObj.f_cmd.value = MULTI05;
			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			var sParam = "";
			sParam = sParam + FormQueryString(formObj);
			
//			prompt("sParam", sParam); ComOpenWait(false); return;
			var sXml = sheetObj.GetSaveXml("EES_CGM_1204GS.do", sParam);
			var sInsRslt = ComGetEtcData(sXml, "ins_result");
			
			if(sInsRslt == "SUCCESS") {
				ComShowCodeMessage("CGM00003");
				ComBtnDisable("btn_Audit");
				ComBtnDisable("btn_Loadexcel");
				ComOpenWait(false);	
			} else {
				// msgs['CGM20063'] = "Failed to {?msg1}. Please try it again.";
				ComShowCodeMessage("CGM20063", "Save");
				ComOpenWait(false);	
			}
		
		} else {
			ComOpenWait(false);	
			return;
		}
		
		break;

	case IBSAVE: // Audit
		sheetObj.WaitImageVisible=true;
		ComOpenWait(true);	
		
		if(!validateForm(sheetObj, formObj, sAction)){
//			ComShowCodeMessage('CGM10004', "Invoice No");
			ComOpenWait(false);	
			return;
			
		}else { // invoice no 중복 체크
			formObj.f_cmd.value = SEARCH;
			
			//var sParam = sheetObjects[0].GetSaveString(true);
			var sParam = "";
			sParam = sParam + "&";
			sParam = sParam + FormQueryString(formObj);
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1204GS.do", sParam);	
			var invFlag = ComGetEtcData(sXml, "invFlag");

			if(invFlag=="F") {
				ComShowCodeMessage('CGM10086', "'" + formObj.inv_no.value + "'");
				ComOpenWait(false);	
				return;
			}
		}
		// msgs['CGM20047'] = 'Do you want to audit the invoice?';	
		if(ComShowCodeConfirm('CGM20047')) {
			// Save 실행
			formObj.f_cmd.value = MULTI02;
			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	
			sParam = "";
			sParam = sheetObjects[0].GetSaveString(true);
			sParam = sParam + "&";
			sParam = sParam + FormQueryString(formObj);
//			prompt("sParam", sParam); ComOpenWait(false); return;
			var sXml = sheetObj.GetSaveXml("EES_CGM_1204GS.do", sParam);
//			sheetObj.LoadSaveXml(sXml);
			
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
	
			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 10000;
				timer1 = setInterval(getBackEndJobStatus, 3000);
			}
		} else {
			ComOpenWait(false);
			return;
		}
		
		break;

	case IBINSERT: // 입력
		break;

	case IBSEARCH_ASYNC01: // Vendor Code,Name 조회

		formObj.f_cmd.value = SEARCH07;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do",
				FormQueryString(formObj), '', true);
		var text = ComGetEtcData(sXml, "text");

		formObj.vndr_lgl_eng_nm.value = text;
		break;
	
	case IBSEARCH_ASYNC02: // Vendor Code,Name 조회

		formObj.f_cmd.value = SEARCH21;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
		var text = ComGetEtcData(sXml, "text");
	
		formObj.chss_pool_nm.value = text;
		break;
		
	case IBSEARCH_ASYNC03:	// CHASSIS COP INVOICE TYPE CODE MultiCombo 조회
		
		formObj.f_cmd.value = SEARCH;
		
		formObj.intg_cd_id.value = COM_CD_TYPE_CD03300;		// 코드Type 설정 ( CHASSIS COP INVOICE TYPE CODE )
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
		
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");
		
		// combo control, 결과 문자열, Text Index, Code Index
		MakeComboObject(formObj.cmb_inv_tp, arrStr, 1, 0);
		break;
	
	case IBLOADEXCEL: // EXCEL UPLOAD
		sheetObj.WaitImageVisible=true;
		ComOpenWait(true);
		sheetObj.RemoveAll();
		sheetObj.LoadExcel();
		
		sheet1_validate(sheetObj);
		
		break;

	case IBDOWNEXCEL: // EXCEL DOWNLOAD
		sheetObj
				.SpeedDown2Excel(
						1,
						false,
						true,
						"",
						"",
						false,
						false,
						"",
						true,
						"");
		break;
	}
}

/**
 * Sheet1 의 OnSaveEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.08.31
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '') {
		ComShowCodeMessage('CGM00003');
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	switch(sAction) {
	case IBSAVE:

		return ComChkRequired(formObj);
		
		break;
	case MULTI05:

		return ComChkRequired(formObj);
		
		break;
	}
	
	return true;
}
 
function sheet1_validate(sheetObj) {
	
	if(sheetObj.RowCount > 0){
		var check = true;
		for(var i = 1; i <= sheetObj.RowCount ; i++){
			sheetObj.CellValue2(i, prefix+"inv_cust_eq_no") = sheetObj.CellValue(i, prefix+"inv_cust_eq_no").split("-").join("");
//			sheetObj.CellValue2(i, "inv_eq_onh_dt") = convertDateFormat(sheetObj.CellValue(i, "inv_eq_onh_dt"));
//			sheetObj.CellValue2(i, "inv_eq_offh_dt") = convertDateFormat(sheetObj.CellValue(i, "inv_eq_offh_dt"));
//			sheetObj.CellValue2(i, "inv_bil_st_dt") = convertDateFormat(sheetObj.CellValue(i, "inv_bil_st_dt"));
//			sheetObj.CellValue2(i, "inv_bil_end_dt") = convertDateFormat(sheetObj.CellValue(i, "inv_bil_end_dt"));

//			sheetObj.CellValue2(i, prefix+"inv_cust_eq_tpsz_cd") = sheetObj.CellValue(i, prefix+"inv_cust_eq_tpsz_cd").substr(0,2);
			
			if(sheetObj.CellValue(i, prefix+"inv_chg_tp_nm")!= "Per Diem" && sheetObj.CellValue(i, prefix+"inv_chg_tp_nm")!= "On Terminal" && sheetObj.CellValue(i, prefix+"inv_chg_tp_nm")!= "On Street"){
//				ComShowCodeMessage("CGM20042", sheetObj.CellValue(i, prefix+"inv_chg_tp_nm"));
				sheetObj.CellBackColor(i, prefix+"inv_chg_tp_nm") = sheetObj.RgbColor(255,0,0);
				check = false;
			}
			
//			 if(sheetObj.CellValue(i, "inv_cust_eq_no") == ""){
//				sheetObj.CellBackColor(i, "inv_cust_eq_no") = sheetObj.RgbColor(255,0,0);
//				check = false;
//			}
		
		}

		if(!check){
			ComShowCodeMessage('CGM20046');
			ComBtnDisable("btn_Audit");
			ComBtnDisable("btn_Save");
		}else{
			ComShowCodeMessage('CGM20045');
			ComBtnEnable("btn_Audit");
			ComBtnDisable("btn_Save");
		}
	}

	ComOpenWait(false);	
}
 
function convertDateFormat(preDate){
	var conDate = "";
	
	if(preDate != "" && preDate != undefined){
		var dateArray = preDate.split("-");
		var year = dateArray[0].substring(2,4);
		var day = dateArray[2];
		var month = "";
		if(dateArray[1] == "01"){
			month = "JAN";
		}else if(dateArray[1] == "02"){
			month = "FEB";
		}else if(dateArray[1] == "03"){
			month = "MAR";
		}else if(dateArray[1] == "04"){
			month = "APR";
		}else if(dateArray[1] == "05"){
			month = "MAY";
		}else if(dateArray[1] == "06"){
			month = "JUN";
		}else if(dateArray[1] == "07"){
			month = "JUL";
		}else if(dateArray[1] == "08"){
			month = "AUG";
		}else if(dateArray[1] == "09"){
			month = "SEP";
		}else if(dateArray[1] == "10"){
			month = "OCT";
		}else if(dateArray[1] == "11"){
			month = "NOV";
		}else if(dateArray[1] == "12"){
			month = "DEC";
		}
		
		conDate = day + "-" +month+"-"+year;
	}
	
	return conDate;
	
}

/** 
* Object 의 Keypress 이벤트에 대한 처리  <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* @param  없음
* @return 없음
* @author 최민회
* @version 2009.05.20
*/ 
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null) return;
	 	
	 window.defaultStatus = obj.dataformat;
	 switch(obj.dataformat) {
	 	case "ymd":
	 		ComKeyOnlyNumber(obj);
	        break;
	    case "eng":
	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
	        else ComKeyOnlyAlphabet('upper');
	        break;
	    case "engup":
//	        if(obj.name=="inv_no") ComKeyOnlyAlphabet('uppernum')
//	        else ComKeyOnlyAlphabet('upper');
	        break;
	    
	 }
	 
	 
}

/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.
*/
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND01;
	var sXml = sheetObj.GetSearchXml("EES_CGM_1204GS.do", FormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	
	if (jobState == "3") {
		ComShowCodeMessage("CGM00003");
		ComBtnDisable("btn_Audit");
		ComBtnDisable("btn_Loadexcel");
		clearInterval(timer1);
		ComOpenWait(false);	
	} else if (jobState == "4") {
		ComShowCodeMessage("CGM20037");
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		clearInterval(timer1);
	} else if (jobState == "5") {
		ComShowCodeMessage("CGM20038");
		clearInterval(timer1);
	}
}

/** 
 * Combo Object 에 값을 추가하는 처리 <br>
 * @param  {object} cmbObj	필수 Combo Object
 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
 * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
 * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */ 
function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
 	cmbObj.RemoveAll();
// 	cmbObj.InsertItem(0,"","");
 	for (var i = 0; i < arrStr.length;i++ ) {
 		var arrCode = arrStr[i].split("|");
 		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
 	}
 	cmbObj.Index2 = 0;
}

function cmb_inv_tp_OnChange(cmbObj, Code, Text) {
//	alert(Code);
	/**************** 시트변수 지정하여 사용 ***************/
	var sheetObject1 = sheetObjects[0];
	/** ****************************************************/
	switch(Code) {
		case "UNR": // Usage/Rebill
			if(sheetObject1.RowCount > 0) {
				ComBtnEnable("btn_Audit");
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_Loadexcel");
			break;
		case "MIG": // Repo(Migration)
			sheetObject1.RemoveAll();
			ComBtnDisable("btn_Audit");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Loadexcel");
			break;
		case "CMT": // Min Commitment
			sheetObject1.RemoveAll();
			ComBtnDisable("btn_Audit");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Loadexcel");
			break;
		case "MCD": // MH Credit
			sheetObject1.RemoveAll();
			ComBtnDisable("btn_Audit");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Loadexcel");
			break;
		case "RSH": // Revenue Sharing
			sheetObject1.RemoveAll();
			ComBtnDisable("btn_Audit");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Loadexcel");
			break;
		case "CSH": // Cost Sharing
			sheetObject1.RemoveAll();
			ComBtnDisable("btn_Audit");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Loadexcel");
			break;
	
	}
}


/* 개발자 작업  끝 */