/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0068.js
 *@FileTitle : CSR Inquiry Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.12
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.08.12 박희동
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
 * @class FNS_JOO_0068 : FNS_JOO_0068 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0068() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName == null) {
			return;
		}
		// class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;

		case "btn_print":
			var csrNo = formObj.csr_no.value;
			if (csrNo.length < 19) {
				ComShowCodeMessage("JOO00074");
				return;
			}
			rdOpen(formObj);
			break;

		case "btn_reverse":
			doActionIBSheet(sheetObject1, formObj, IBCREATE);
			break;

		case "btn_evd":
			var csrNo = formObj.csr_no.value;
			if (csrNo.length < 19) {
				ComShowCodeMessage("JOO00074");
				return;
			}

			if (csrNo.substring(0, 2) != "06") {
				ComShowCodeMessage("JOO00119");
				return;
			}

			if (formObj.evid_tp_cd.value != "1") {
				ComShowCodeMessage("JOO00119");
				return;
			}

			var param = '?csrNo=' + csrNo + '&editable=N';
			ComOpenPopup("/hanjin/FNS_JOO_0018.do" + param, 900, 600,
					"popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
					"pop2");
			break;

		case "btn_csr":
			var csrNo = formObj.csr_no.value;
			if (csrNo.length < 19) {
				ComShowCodeMessage("JOO00074");
				return;
			}
			var param = '?csrNo=' + csrNo;
			ComOpenPopup("/hanjin/FNS_JOO_0024.do" + param, 835, 440,
					"popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
					"pop1");
			break;

		case "apro_step_btn" :
    	    var v_ofc_cd = formObj.slp_ofc_cd.value;
    	    var v_sub_sys_cd = "JOO";
            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
				ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
			break;

		case "btn_close":
			self.close();
			break;
		case "btn_attach":
			if (formObj.csr_no.value==undefined ||
					formObj.csr_no.value==null ||
					formObj.csr_no.value.trim()==''){
		    		ComShowCodeMessage("JOO00211");		// CSR No.가 없습니다.
					return false;
			}								
			var param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"N";
			ComOpenPopup("/hanjin/FNS_JOO_0098.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
			break;
			
		case "btn_gwcl":
			if (formObj.csr_no.value==undefined ||
					formObj.csr_no.value==null ||
					formObj.csr_no.value.trim()==''){
				    ComShowCodeMessage("JOO00211");		// CSR No.가 없습니다.
					return false;
			}				

			var param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"N";													
//			ComOpenPopup("/hanjin/FNS_JOO_0099.do"+param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
			window.open("/hanjin/FNS_JOO_0099.do"+param, "", "status=no, width=835, height=380, resizable=no, scrollbars=no");				
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

function popupFinish(rowArray) {
	var fstArray;
	var scnArray;
	//
	// for (var i=0; i < rowArray.length; i++){
	// fstArray = rowArray[i];
	//		
	// for(var j=0; j < fstArray.length; j++){
	// }
	// }
}
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function initRdConfig(rdObject) {
	var Rdviewer = rdObject;
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.SetBackgroundColor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
}

function rdOpen(formObj) {

	if (!setQueryStr()) {
		return;
	}

	var rdParam = '/rp ' + queryStr;

	var strPath = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_0019.mrd";

	//SINRS면 결재라인이 다르다.
    if (gOfcCd == "SINRS" || gOfcCd == "SINRSS"){
    	strPath   = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_1019.mrd";
    }

	var csrNo = formObj.csr_no.value;
	if (csrNo.substring(0, 2) == "18") {
		strPath = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_0021.mrd";
	    //SINWA면 결재라인이 다르다.
	    if (gOfcCd == "SINWA" || gOfcCd == "SINWSG"){
	    	strPath   = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_1021.mrd";
	    }
	}

	formObj.com_mrdPath.value = strPath;
	formObj.com_mrdArguments.value = rdParam;
	ComOpenRDPopup();
}

function setQueryStr() {
	var formObj = document.form;
	queryStr = "";

	queryStr += " [" + formObj.csr_no.value + "]";
	return true;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
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
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "radio|checkbox|ibflag|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_iss_dt|"
					+ "slp_ser_no|vndr_seq|cust_cnt_cd|cust_seq|csr_desc|"
					+ "csr_locl_curr_cd|csr_locl_amt|csr_usd_amt|eff_dt|evid_tp_cd|"
					+ "apro_flg|apro_dt|cxl_flg|cxl_desc|csr_offst_no|"
					+ "ddct_flg|ddct_locl_amt|ddct_desc|rqst_locl_amt|rqst_dt|"
					+ "csr_tp_cd|rvs_csr_flg|org_slp_tp_cd|org_slp_func_cd|org_slp_ofc_cd|"
					+ "org_slp_iss_dt|org_slp_ser_no	|csr_no	|issuer	|vndr_cust_seq	|"
					+ "lgl_eng_nm|evid_tp_nm|act_rqst_amt|rvs_cmb_flg|acct_yrmon|"
					+ "jo_crr_cd|stl_cmb_seq|re_divr_cd|slp_iss_ofc_cd|slp_iss_rgn_cd|slp_iss_inter_co_cd|clz_sts_cd|"
					+ "jo_stl_itm_cd|bsa_qty|bsa_slt_prc|auth_cd|apro_step|if_flg|atch_file_cnt|gw_ctrt_cnt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, false,
					"radio");
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, prefix
					+ "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_func_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_ofc_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_iss_dt", false, "", dfUserFormat2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_ser_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "vndr_seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "cust_cnt_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "cust_seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_desc");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_locl_curr_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_locl_amt", false, "", dfNullFloat, 2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_usd_amt");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "eff_dt", false, "", dfUserFormat2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "evid_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "apro_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "apro_dt");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "cxl_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "cxl_desc");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_offst_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "ddct_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "ddct_locl_amt");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "ddct_desc");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "rqst_locl_amt", false, "", dfNullFloat, 2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "rqst_dt", false, "", dfUserFormat2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "rvs_csr_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "org_slp_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "org_slp_func_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "org_slp_ofc_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "org_slp_iss_dt");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "org_slp_ser_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "csr_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "issuer");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "vndr_cust_seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "lgl_eng_nm");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "evid_tp_nm");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "act_rqst_amt", false,
					"|sheet1_csr_locl_amt|-|sheet1_ddct_locl_amt|",
					dfNullFloat, 2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "rvs_cmb_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "acct_yrmon");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "jo_crr_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "stl_cmb_seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "re_divr_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_iss_ofc_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_iss_rgn_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "slp_iss_inter_co_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix
					+ "clz_sts_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix
					+ "jo_stl_itm_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix
					+ "bsa_qty");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix
					+ "bsa_slt_prc");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix
					+ "auth_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "apro_step");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "if_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "atch_file_cnt"    );				
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "gw_ctrt_cnt"    );
			
			

			InitUserFormat2(0, prefix + "slp_iss_dt", "####-##-##", "-");
			InitUserFormat2(0, prefix + "eff_dt", "####-##-##", "-");
			InitUserFormat2(0, prefix + "rqst_dt", "####-##-##", "-");
		}
		break;
	}
}

function initControl() {
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur', formObj); 
	axon_event.addListenerFormat('beforeactivate', 'obj_focus', formObj);
	axon_event.addListener('keypress', 'csr_no_keypress', 'csr_no');
	axon_event.addListener('keypress', 'fr_dt_keypress', 'fr_dt');
	axon_event.addListener('keypress', 'tr_dt_keypress', 'to_dt');
}

// Axon 이벤트 처리2. 이벤트처리함수
function obj_blur() {
	ComChkObjValid(event.srcElement);
}

function obj_focus() {
	ComClearSeparator(event.srcElement);
}

function csr_no_keypress() {
	// 영대문자 자동변환
	ComKeyOnlyAlphabet('uppernum');
	if (document.form.slp_iss_dt.value != "")
		document.form.slp_iss_dt.value = "";
}

function fr_dt_keypress() {
	ComKeyOnlyNumber(document.form.fr_dt);
}

function to_dt_keypress() {
	ComKeyOnlyNumber(document.form.to_dt);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("FNS_JOO_0068GS.do", FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(prefix));
		setSheet2Input(formObj, sheetObj);
		break;

	case IBCREATE: // REVERSE
		sheetObj.CellValue(sheetObj.HeaderRows, prefix+"apro_step") = formObj.apro_step.value; 
			
		var SaveStr = ComGetSaveString(sheetObj, true, true);

		if (SaveStr == "") {
			ComShowCodeMessage("JOO00036");
			return;
		}

		if (!ComShowCodeConfirm("JOO00123")) {
			return false;
		}

		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSaveXml("FNS_JOO_0068GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		ComOpenWait(false);
		// save 완료 후 창을 닫고 opener를 refresh한다.
		comPopupOK();

		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		break;

	case IBCREATE: // REVERSE
		var rvsCmbFlg = formObj.rvs_cmb_flg.value;
		var csrNo = formObj.csr_no.value;
		
		if (rvsCmbFlg == "Y") {
			ComShowCodeMessage("JOO00120"); // This Combined Data has been
											// Reversed!
			return false;
		}

		var aproFlg = sheetObj.CellValue(sheetObj.LastRow, prefix + "apro_flg");// JooGetRadioValue(formObj.cxl_flg);

		if (aproFlg != "Y") {
			ComShowCodeMessage("JOO00153"); // You can make 'Reverse Slip' after approval.
			return false;
		}

		var evidTpCd = formObj.evid_tp_cd.value;
		if (evidTpCd == "1") {
			ComShowCodeMessage("JOO00121"); // This Combined Data cannot be reversed cause its evidence type is 'TAX'
			return false;
		}

		var cxlFlg = sheetObj.CellValue(sheetObj.LastRow, prefix + "cxl_flg");// JooGetRadioValue(formObj.cxl_flg);

		if (cxlFlg == "Y") {
			ComShowCodeMessage("JOO00122"); // This Combined Data was canceled.
			return false;
		}
		
		var ifFlg = sheetObj.CellValue(sheetObj.LastRow, prefix + "if_flg");

		// CSR NO 가 AR(18)이면 건너뛰도록 처리 [AP일경우만 처리하도록 처리]
		if (csrNo.substring(0, 2) != "18") {
			if (ifFlg != "Y"){
				ComShowCodeMessage("JOO00179");
				return false;
			}
		}
		

		var clzStsCd = formObj.clz_sts_cd.value;

		if (clzStsCd == "C") {
			ComShowCodeMessage("JOO00126"); // This Combined Data cannot be
											// reversed because the month of
											// Eff. Date is closed.
			return false;
		} else if (clzStsCd == "E") {
			ComShowCodeMessage("JOO00125"); // Please check Eff. Date.
			return false;
		}

		//결재선을 지정하지 않으면 Error Message
		if (ComTrim(formObj.apro_step.value) == ""){
			ComShowCodeMessage("JOO00174");
			return false;
		}
		break;
	}

	return true;
}

/**
 * sheet -> input
 * 
 * @param formObj
 * @param sheetObj
 * @return
 */
function setSheet2Input(formObj, sheetObj) {
	formObj.csr_offst_no.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "csr_offst_no");
	formObj.slp_ofc_cd.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "slp_ofc_cd");
	formObj.slp_iss_dt.value = sheetObj.CellText(sheetObj.LastRow, prefix
			+ "slp_iss_dt");
	formObj.issuer.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "issuer");
	formObj.csr_desc.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "csr_desc");
	formObj.vndr_cust_seq.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "vndr_cust_seq");
	formObj.lgl_eng_nm.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "lgl_eng_nm");
	formObj.csr_locl_curr_cd.value = sheetObj.CellValue(sheetObj.LastRow,
			prefix + "csr_locl_curr_cd");
	formObj.csr_locl_amt.value = sheetObj.CellText(sheetObj.LastRow, prefix
			+ "csr_locl_amt");
	formObj.evid_tp_nm.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "evid_tp_nm");
	formObj.eff_dt.value = sheetObj.CellText(sheetObj.LastRow, prefix
			+ "eff_dt");
	formObj.rqst_dt.value = sheetObj.CellText(sheetObj.LastRow, prefix
			+ "rqst_dt");
	formObj.cxl_desc.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "cxl_desc");
	formObj.act_rqst_amt.value = sheetObj.CellText(sheetObj.LastRow, prefix
			+ "act_rqst_amt");
	formObj.ddct_locl_amt.value = sheetObj.CellText(sheetObj.LastRow, prefix
			+ "ddct_locl_amt");
	formObj.ddct_desc.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "ddct_desc");
	formObj.rvs_csr_flg.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "rvs_csr_flg");
	formObj.rvs_cmb_flg.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "rvs_cmb_flg");
	formObj.evid_tp_cd.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "evid_tp_cd");
	formObj.clz_sts_cd.value = sheetObj.CellValue(sheetObj.LastRow, prefix
			+ "clz_sts_cd");

	var aproFlg = sheetObj.CellValue(sheetObj.LastRow, prefix + "apro_flg");
	var cxlFlg = sheetObj.CellValue(sheetObj.LastRow, prefix + "cxl_flg");
	var ddctFlg = sheetObj.CellValue(sheetObj.LastRow, prefix + "ddct_flg");

	if (aproFlg == "Y") {
		formObj.apro_flg[0].checked = true;
	} else {
		formObj.apro_flg[1].checked = true;
	}
	if (cxlFlg == "Y") {
		formObj.cxl_flg[0].checked = true;
	} else {
		formObj.cxl_flg[1].checked = true;
	}
	if (ddctFlg == "Y") {
		formObj.ddct_flg[0].checked = true;
	} else {
		formObj.ddct_flg[1].checked = true;
	}
	
	var atchFileCnt = parseInt(sheetObj.CellValue(sheetObj.LastRow, prefix+"atch_file_cnt"));
	var gwCtrtCnt = parseInt(sheetObj.CellValue(sheetObj.LastRow, prefix+"gw_ctrt_cnt"));
	
	if(atchFileCnt > 0){
		document.getElementById("btn_attach").style.color = "blue";
	}
	if(gwCtrtCnt > 0){
		document.getElementById("btn_gwcl").style.color = "blue";
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount > 0) {

		sheetObj.CellValue(sheetObj.LastRow, "radio") = "1";
		sheetObj.CellValue(sheetObj.LastRow, "check") = "1";

		var auth_cd = sheetObj.CellValue(sheetObj.LastRow, prefix + "auth_cd");
		if (auth_cd == "W") {
			JooSetBtnClass("C", true);
		} else {
			JooSetBtnClass("C", false);
		}

		// 세금계산서인 경우만 evidence button활성화
		if (sheetObj.CellValue(sheetObj.LastRow, prefix + "evid_tp_cd") == "1") {
			JooSetBtnClass("U", true);
		} else {
			JooSetBtnClass("U", false);
		}
		JooSetBtnClass("P", true); // data가 있으면 CSR Detail과 Print버튼 활성화
	} else {
		JooSetBtnClass("C", false);
		JooSetBtnClass("U", false);
		JooSetBtnClass("P", false);// data가 있으면 CSR Detail과 Print버튼 비활성화
	}
}
/* 개발자 작업 끝 */