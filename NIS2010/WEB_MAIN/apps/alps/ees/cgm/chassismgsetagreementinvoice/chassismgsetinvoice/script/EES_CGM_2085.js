/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2085.js
 *@FileTitle : Invoice Import & Audit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.02
 *@LastModifier : 김창식
 *@LastVersion : 1.0
 * 2009.09.02 김창식 
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ees_cgm_2085 : ees_cgm_2085 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2085() {
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
			ComBtnDisable("btn_Save");
			break;

		case "btn_Downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;

		case "btn_Audit":
			//doActionIBSheet(sheetObject1, formObject, MULTI01); // 기존
			doActionIBSheet(sheetObject1, formObject, MULTI03); // STEP1.INSERT
																// STEP2.SEARCH
			break;

		case "btn_New":
			initControl();
			break;

		case "btn_Agreemapping":
			var pgmNo = 'EES_CGM_2086';
			var pgmUrl = '/hanjin/EES_CGM_2086.do';
			var parentPgmNo = pgmNo.substring(0, 8) + 'M019';
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&pgmNo="
					+ pgmNo;

			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
			var winObj = window.open("alpsMain.screen?parentPgmNo="
					+ parentPgmNo + src, "", sFeatures);

			break;

		case "btn_Save":
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

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

	initControl();

}

function initControl() {

	var formObj = document.form;

	sheetObjects[0].RemoveAll();
	formObj.vrfy_scs_flg.value = "N";
	ComBtnDisable("btn_Save");
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
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq.|Lessor M.G.Set No.|SML M.G.Set No.|Actual M.G.Set No.|Invoice Reference No.|Invoice No.|Charge Type|On-Hire Loc.|On-Hire Date|Billing Start Date|Off-Hire Loc.|Off-Hire Date|Billing End Date|Used Days|Rate|Total|Verify Status|||||"
					+ "|||||||||||||||||||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 5, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,	"ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 125, daCenter, false,"inv_cust_eq_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false,"inv_eq_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "eq_no",false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false,"inv_ref_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "inv_no",false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,	"inv_chg_tp_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false,	"inv_eq_onh_loc_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,	"inv_eq_onh_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false,"inv_bil_st_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false,	"inv_eq_offh_loc_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,	"inv_eq_offh_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false,"inv_bil_end_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false,"inv_lse_use_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false,"inv_lse_rt_amt", false, "", dfFloat, 2, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false,	"inv_lse_chg_amt", false, "", dfFloat, 2, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false,"vrfy_rslt_desc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"agmt_ofc_cty_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"agmt_seq");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"agmt_ver_no");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"agmt_lstm_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"vrfy_scs_flg");

			// chungpa 20091209 추가. save용 start.
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"inv_tax_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,"inv_cr_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "chg_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cost_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "acct_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "lse_use_dys");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "lse_rt_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "lse_chg_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "lse_chg_aud_sts_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "lse_chg_aud_rslt_rsn_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "lse_chg_sts_cd"); // 'A'고정
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pay_lse_chg_sts_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "inv_smry_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cr_smry_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "tax_smry_amt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "eq_aset_sts_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "aud_umch_eq_sts_evnt_yd_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "aud_umch_eq_aset_sts_cd");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "aud_umch_eq_sts_evnt_dt");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "curr_cd");
			// chungpa 20091209 추가. save용 end.

			// chungpa 20100428 추가. save용 start.
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "inv_seq");
			// chungpa 20100428 추가. save용 end.
			
			WordWrap = true;
			// CountPosition = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case MULTI01: // Verify

		// Dup Check
		// var duprows = sheetObj.ColValueDupRows("inv_eq_no|inv_no|chg_cd");

		// var arrDuprows = duprows.split(",")
	
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);	
		
		formObj.f_cmd.value = MULTI01;
		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
		// var sParam = sheetObjects[0].GetSaveString(true);
		var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
		sParam = sParam + "&";
		sParam = sParam + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml("EES_CGM_2085GS.do", sParam);
		sheetObj.LoadSearchXml(sXml);
		
 		ComOpenWait(true);	

		// verify 성공여부를 hidden parametre에 저장 (성공 : Y, 실패 : N)
		// Service에서의 체크로직이 성공인지를 확인한다.
		if (sheetObj.FindText("vrfy_scs_flg", 'N') == -1) {
			formObj.vrfy_scs_flg.value = "Y";
			ComBtnEnable("btn_Save");
		} else {
			formObj.vrfy_scs_flg.value = "N";
			ComBtnDisable("btn_Save");
		}

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

		break;
	case MULTI03: // Verify Insert => Verify Search
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);	
	
		formObj.f_cmd.value = MULTI03;
		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
		var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
		sParam = sParam + "&";
		sParam = sParam + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml("EES_CGM_2085GS.do", sParam);
		var insResult = ComCgmNullToBlank(ComGetEtcData(sXml, "ins_result"));
		sheetObj.LoadSearchXml(sXml);
		if (insResult == "SUCCESS") {
			formObj.f_cmd.value = MULTI04;
			formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("EES_CGM_2085GS.do", sParam);
			sheetObj.LoadSearchXml(sXml);
			// verify 성공여부를 hidden parametre에 저장 (성공 : Y, 실패 : N)
			// Service에서의 체크로직이 성공인지를 확인한다.
			if (sheetObj.FindText("vrfy_scs_flg", 'N') == -1) {
				formObj.vrfy_scs_flg.value = "Y";
				ComBtnEnable("btn_Save");
			} else {
				formObj.vrfy_scs_flg.value = "N";
				ComBtnDisable("btn_Save");
			}
		}
		
		ComOpenWait(false);	
		break;

	case IBSAVE: //저장
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);	
		
		if (formObj.vrfy_scs_flg.value == 'Y') {
			// Save 실행
			formObj.f_cmd.value = MULTI02;
			formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

			// var sParam = sheetObjects[0].GetSaveString(true);
			var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
			sParam = sParam + "&";
			sParam = sParam + FormQueryString(formObj);

			var sXml = sheetObj.GetSaveXml("EES_CGM_2085GS.do", sParam);

			sheetObj.LoadSaveXml(sXml);

		} else {
			// 확인메세지
			ComShowCodeMessage('CGM10005');
		}
		ComBtnDisable("btn_Save");
		
		ComOpenWait(false);	
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

	case IBLOADEXCEL: // EXCEL UPLOAD
		sheetObj.RemoveAll();
		sheetObj.LoadExcel();
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
						"agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|vrfy_scs_flg"
								+ "|inv_tax_amt|inv_cr_amt|cost_cd|acct_cd|lse_use_dys|lse_rt_amt|lse_chg_amt|lse_chg_aud_sts_cd"
								+ "|lse_chg_aud_rslt_rsn_cd|lse_chg_sts_cd|pay_lse_chg_sts_cd|inv_smry_amt|cr_smry_amt|tax_smry_amt"
								+ "|eq_aset_sts_cd|aud_umch_eq_sts_evnt_yd_cd|aud_umch_eq_aset_sts_cd|aud_umch_eq_sts_evnt_dt|curr_cd");
		break;
	}
}

/**
 * Sheet1 의 OnSaveEnd 이벤트처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2009.09.02
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
	return true;
}

/* 개발자 작업  끝 */