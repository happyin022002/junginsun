/*=========================================================
 *Copyright(c) 2016 CyberLogitec 
 *@FileName : ESM_FMS_0095.js
 *@FileTitle : Owner's Account
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.18
 *@LastModifier : 손진환
 *@LastVersion : 1.0
 * 2016.02.18 손진환
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
 * @class ESM_FMS_0095 : ESM_FMS_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_FMS_0095() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initCombo = initCombo;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */ 

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var selectedCurrCd = "";

var slp_prefix = "slp_";

var s_flg = "";

var bReSearchFlag = true; 

// 이전에 입력한 Effective Date(같은 값 입력시 서버호출 방지하기 위하여 사용함)
var pre_eff_dt = "";

var opener = window.dialogArguments;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;
	s_flg = getCurFlg();
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			
//			case "btn_test":
//				var openSheetObj = opener.document.sheet1;
//				var a = openSheetObj.LastRow;
//				for(var i = 1; i <= a; i++){
//					alert(openSheetObj.CellValue(i, "seq") + " | " + openSheetObj.CellValue(i, "csr_no"));
//				}
//				return false;
//				
//				var param = "s_csr_no=" + formObject.csr_no.value + "&s_flg=ESM_FMS_0100";
//				ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "setCorrection", "0,0,1,1,1,1");
//				break;
				
			case "btn_add":
				if(formObject.vndr_seq.value == "") {
    				ComShowCodeMessage("FMS20022");
        			return false;
        		}
				
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
				
			case "btn_copy":
				if(formObject.vndr_seq.value == "") {
    				ComShowCodeMessage("FMS20022");
        			return false;
        		}
				
				doActionIBSheet(sheetObject, formObject, IBCOPYROW);
				break;
				
			case "btn_del":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
				
			case "btn_new":
				fncNew();			
				break;
	
			case "btn_save":
				if(!chkCsrAmt()){
					return;
				}
				
				doActionIBSheet(sheetObject, formObject, IBSAVE);
	
				break;

			case "btn_delete":
				// IBDELETE < ibsheet예약되있어서 "DELETE"로 대체함
				doActionIBSheet(sheetObject, formObject, "DELETE");	
				break;
				
			case "btn_submit":				
				doActionIBSheet(sheetObject, formObject, IBCREATE);
				
				break;
	
			case "btn_print":
				var s_flg = getCurFlg();
				var rtnSheetObj = null;
				
				if(s_flg == "ESM_FMS_0101") {
					rtnSheetObj = sheetObjects[3];
				}else{
					rtnSheetObj = sheetObjects[3];				
				}						
				
				var vat_csr_no =  rtnSheetObj.CellValue(1,"vat_csr_no");
				
				rdOpen(rdObjects[0], document.form);
				
//				if(vat_csr_no != ""){
//					form.csr_no.value = vat_csr_no;
//					rdOpen(rdObjects[0], document.form);
//					form.csr_no.value =      rtnSheetObj.CellValue(1,"slp_tp_cd") + rtnSheetObj.CellValue(1,"slp_func_cd") 
//													+ rtnSheetObj.CellValue(1,"slp_ofc_cd") + rtnSheetObj.CellValue(1,"slp_iss_dt") 
//													+ rtnSheetObj.CellValue(1,"slp_ser_no");
//				}
				break;
	
			case "btn_approval":
				var s_flg = getCurFlg();
				var rtnSheetObj = null;
				var url = "";
				
				if(s_flg == "ESM_FMS_0101") {
					rtnSheetObj = sheetObjects[3];
				}else{
					rtnSheetObj = sheetObjects[3];				
				}						
				
				var v_apro_rqst_no =  rtnSheetObj.CellValue(1,"apro_rqst_no");
				url = "COM_CSR_0020.do?apro_rqst_no="+v_apro_rqst_no+"&btn_flag=N";
				ComOpenPopup(url, 615, 280, "", "1,0,1,1,1", true);
				
				break;				
			case "btn_vndr_pop":
				if(s_flg == "R") {
					return;
				}
				//ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setServiceProviderInfo', '0,0', true, true);
				ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 450, '2:vndr_seq|4:vndr_nm', '1,0,1,1,1', true);
				break;
				
			case "oa_inv_dt_cal":
				if(s_flg == "R") {
					return;
				}
				var cal = new ComCalendar();
				cal.setDisplayType('date');
				cal.select(form.oa_inv_dt, 'yyyy-MM-dd');
				break;
	
			case "eff_dt_cal":
				if(s_flg == "R") {
					return;
				}
				var cal = new ComCalendar();
				cal.setDisplayType('date');
				cal.select(form.eff_dt, 'yyyy-MM-dd');
				break;
				
			case "rqst_dt_cal":
				if(s_flg == "R") {
					return;
				}
				var cal = new ComCalendar();
				cal.setDisplayType('date');
				cal.select(form.rqst_dt, 'yyyy-MM-dd');
				break;
				
			case "apro_step_btn" :
				if(s_flg == "R") {
					return;
				}
				var v_ofc_cd = formObject.slp_ofc_cd.value;

	    	    var v_sub_sys_cd = "FMS";
	            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
					ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
				break;
	
        	case "btn_taxEvidence":
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		
        		setInitVatApply(sheetObject);
        		
        		var evid_tp_cd = form.evid_tp_cd_val.value;
        		var tax_inv_yrmon = formObject.eff_dt.value;
        		var vndr_seq = formObject.vndr_seq.value;
        		
        		//ComOpenPopup("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+evid_tp_cd+"&own_gubun=own", 917, 562,"", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0029");    
        		ComOpenPopup("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+evid_tp_cd+"&own_gubun=own"+"&vndr_seq="+vndr_seq, 917, 562,"", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0029");   
        		//window.open("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+evid_tp_cd+"&own_gubun=own");        		        		
        		break;
        			
        	case "btn_asa_create":
        		fnAddAsa();
        		break;
        		
        	case "btn_msa_create":
        		fnAddMsa();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * 멀티콤보 처리
 * - IBCombo Object를 배열로 등록
 * - 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * - 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

    // 멀티콤보 처리 (시작) ---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k], k+1);
    }
    // 멀티콤보 처리 (종료) ---------------------------------------------
    
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	// Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
	sheetObjects[0].ExtendLastCol = false;

	// html컨트롤 이벤트초기화
	initControl();

	// RD
	initRdConfig(rdObjects[0]);
	
	var popup = document.form.popup.value;
	s_flg = getCurFlg();
	
	if(popup == "yes") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		
		if(form.evid_tp_cd.value == "1"){
			form.evid_tp_cd.disabled = true;			
		}
	}else{
	
		if(s_flg == "") {
			// 현재 오픈되어있는 G/L Date가져온다
			doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHGL");
			
			// 현재 접속 Local Currency를 가져온다
			doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHCURR");
			
		}
		pre_eff_dt = "";
		//운항팀(PUSMOV) currency는 항상 USD	
		if(form.slp_ofc_cd.value == "PUSMOV"){
			comboObjects[0].Code2 = "USD";	
			
			if(popup != "yes") {
			  form.oa_inv_dt.value = "";
			}
		}			
		
		eff_dt_change(); 	// eff_dt, 환율, Asa 조회		
	}

	if(form.so_if_cd.value == "O"){
		document.getElementById("asa_ap").checked = false;
		document.getElementById("asa_asa").checked = true;
		document.getElementById("asa_msa").checked = false;
	}else{
		document.getElementById("asa_ap").checked = true;
		document.getElementById("asa_asa").checked = false;	
		document.getElementById("asa_msa").checked = false;
	}			
	
	if(form.slp_ofc_cd.value == "PUSMOV"){
		document.getElementById("asa_ap").checked = false;
		document.getElementById("asa_asa").checked = false;	
		document.getElementById("asa_msa").checked = true;
	}
	edtAcctCell();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('blur', 'obj_deactivate', form); // - form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', form); // - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListener('keypress', 'obj_keypress', form); // - form 전체 컨트롤 중 keypress 이벤트 발생시
	axon_event.addListenerForm  ('change', 'obj_change', form);

	// Invoice Date & G/L Date에 오늘 일자 세팅
	setCurDate();
	
	s_flg = getCurFlg();
	
	if(s_flg == "") {
		ComBtnDisable("btn_print");				
	}
	
	//Payments Slip TaxEvidence Button Disable 하기
	ComBtnDisable("btn_taxEvidence");	
}

/**
 * Invoice Date & G/L Date에 오늘 일자 세팅
 */
function setCurDate() {
	var now = new Date();

	var y = now.getYear() + "";
	var M = now.getMonth() + 1;
	if (M < 10)
		M = '0' + M;
	var d = now.getDate();
	if (d < 10)
		d = '0' + d;

	document.form.slp_iss_dt.value = ComGetMaskedValue(y + M + d, "ymd");
	document.form.oa_inv_dt.value = ComGetMaskedValue(y + M + d, "ymd");
	document.form.eff_dt.value = ComGetMaskedValue(y + M + d, "ymd");
}

/**
 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "int":
		// 숫자 만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		// 숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;
	case "engup":
		ComKeyOnlyAlphabet('upper');
		break;
	default:
		// 숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_deactivate() {
	ComChkObjValid(event.srcElement);
	obj = event.srcElement;
	switch(obj.name) {
		case "csr_amt":
			amt_change(obj.value);
			break;
			
		case "eff_dt":
			eff_dt_change();
			break;
	}

}

function obj_change() {
	var obj = event.srcElement;
	switch(obj.name) {
	case "vndr_seq":
		if(obj.value.trim() == ""){
			return;
		}
		updateDueDt( obj.value );

		break;
	}
}

function amt_change( val ) {
	document.form.csr_amt.value = ComAddComma2(val, "#,###.00");
	document.form.dr_amt.value = ComAddComma2(val, "#,###.00");
}

function updateDueDt( vndrSeq ) {
	var param = "f_cmd=" + SEARCH02 + "&s_value=" + vndrSeq;
	
	var sXml = sheetObjects[0].GetSaveXml("FMS_COMGS.do", param);
	var payTerm = ComGetEtcData(sXml, "pay_term");
	
	if(typeof payTerm != "undefined" && payTerm != "") {
		var tmpArr = payTerm.split(":");
		var oaInvDt = document.form.oa_inv_dt.value;
		var dueDt = ComGetDateAdd(oaInvDt, "D", tmpArr[0], "-");
		
		if(document.form.slp_ofc_cd.value != "PUSMOV"){
		  document.form.rqst_dt.value = dueDt;
		}
		
		document.form.vndr_name.value = tmpArr[1];			
	}else{
		alert("Supplier is not available.");
		document.form.vndr_seq.value = "";
		document.form.vndr_name.value = "";
	}
	
	if(document.form.csr_no.value == "") {
		var lastRow = sheetObjects[0].LastRow;
		for ( var i = 1; i <= lastRow; i++) {
				sheetObjects[0].CellValue2(i, slp_prefix + "to_inv_no") = "";
			}				
	}
}
/**
 * IBCOMBO를 초기화하는 function <br> 
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} comboObj 필수 IBMultiCombo Object
 * @param {int} comboNo 필수 IBMultiCombo의 순번
 *
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
		case "csr_curr_cd":
			with(comboObj) {
				SetColAlign("center");
				SetColWidth("30");
				DropHeight = 200;
				MultiSelect = false;
				UseAutoComplete = true;	
				
				if(ComTrim(currList) != "") {
					var comboItems = (currList).split("|");
					addComboItem(comboObj, comboItems);
				}
			}
			
		case "asa_no_list":
			with(comboObj) {
				SetColAlign("center");
				SetColWidth("30");
				DropHeight = 200;
				MultiSelect = false;
				UseAutoComplete = true;	
				
				if(ComTrim(asa_no_list) != "") {
					var comboItems = (asa_no_list).split("|");
					addComboItemAsa(comboObj, comboItems);
				}
			}									
	}
}

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj, comboItems) {
	var ofcCd = document.form.ofc_cd.value;
	
	for (var i = 0 ; i < comboItems.length ; i++) {			
		comboObjects[0].InsertItem(i, comboItems[i], comboItems[i]);

	}   		
}	

/**
 * ASA 콤보필드에 데이터를 추가해준다.
 */
function addComboItemAsa(comboObj,comboItems) {
	comboObjects[1].RemoveAll(); 
	
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(",");
		comboObjects[1].InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
	}
}	

function csr_curr_cd_OnChange(obj) {
	var formObj = document.form;
	
	if(form.slp_ofc_cd.value == "PUSMOV"){
		obj.Code = "USD";	
	}
	
	selectedCurrCd = obj.Code;
	formObj.dr_curr_cd.value = obj.Code;
	formObj.cr_curr_cd.value = obj.Code;
	
	var lastRow = sheetObjects[0].LastRow;
	for ( var i = 1; i <= lastRow; i++) {
		sheetObjects[0].CellValue2(i, slp_prefix + "csr_curr_cd") = obj.Code;			
	}
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {			
			// 높이 설정
			style.height = 260;		
		
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq|Account|O/A Item|Port|VVD|ETD|Invoice No|Invoice Date|Currency|Amount|Description|Attach|Settlement|file_sav_id|vndr_lgl_eng_nm|asa_no";			
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount + 6, 0, 0, true); // 타이틀 컬럼 + 히든컬럼

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus,	30,		daCenter,	true,	slp_prefix + "ibflag");			
			InitDataProperty(0, cnt++, dtSeq,			30,		daCenter,	false,	slp_prefix + "slp_seq",			false, "", dfNone,		0, false,	false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,	slp_prefix + "acct_cd", false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtPopup,			130,	daLeft,		false,	slp_prefix + "acct_itm_nm",		false, "", dfNone,		0, true,	true);
			InitDataProperty(0, cnt++, dtData,			70,		daCenter,	false,	slp_prefix + "oa_loc_cd",		false, "", dfNone,		0, true,	true, 5);
			InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	slp_prefix + "vvd_cd",			false,"", dfNone,		0, true,	true, 10);
			InitDataProperty(0, cnt++, dtData,			100,	daCenter,	false,	slp_prefix + "vps_etd_dt",		false, "", dfDateYmd,	0, false,	false);
			InitDataProperty(0, cnt++, dtData,			130,	daCenter,	false,	slp_prefix + "to_inv_no",		false, "", dfNone,		0, true,	true);
			InitDataProperty(0, cnt++, dtPopupEditFormat,	100, daCenter,	false,	slp_prefix + "oa_inv_dt",		false, "", dfDateYmd,	0, true,	true);
			InitDataProperty(0, cnt++, dtData,			60,		daCenter,	false,	slp_prefix + "csr_curr_cd",		false, "", dfNone,		0, false,	false);
			InitDataProperty(0, cnt++, dtData,			80,		daRight,	false,	slp_prefix + "csr_amt",			false, "", dfFloat,		2, true,	true);
			InitDataProperty(0, cnt++, dtData,			220,	daLeft,		false,	slp_prefix + "csr_desc",		false, "", dfNone,		0, true,	true);
			InitDataProperty(0, cnt++, dtPopup,			50,		daCenter,	false,	slp_prefix + "atch_file_oa_lnk_cnt",	false, "", dfNone,		0, true,	true);
			//InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	slp_prefix + "oa_stl_sts_cd",	false, "", dfNone,		0, false,	false);
			InitDataProperty(0, cnt++, dtData,		   120,		daCenter,	false,	slp_prefix + "oa_stl_sts_cd",	false, "", dfNone,		0, false,	false);
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "atch_file_oa_lnk_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "vndr_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "acct_itm_seq", false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "slp_seq_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "ctr_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "file_sav_id", false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "vndr_lgl_eng_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,	slp_prefix + "asa_no", false, "", dfNone, 0, false, true);			
			
			ImageList(0) = "/hanjin/img/btns_calendar.gif";
			PopupButtonImage(0, slp_prefix + "oa_inv_dt") = 0;
			
			DataLinkMouse(slp_prefix + "acct_itm_seq") = true;
			
			ShowButtonImage = 2;
			
			InitDataValid(0, slp_prefix + "vvd_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, slp_prefix + "oa_loc_cd", vtEngUpOnly);
			
			if(document.form.slp_ofc_cd.value == "PUSMOV"){
				ColHidden(slp_prefix + "vps_etd_dt") = true;
			}				
		}					
		break;
		
    case 2:      //sheet2
        with (sheetObj) {
        	var prefix = "tax_";
            // 높이 설정
            style.height = 100;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 3, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(29, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, true, true, false, false)

            var HeadTitle = "|Seq|Sel|tax_inv_yrmon|ofc_cd|tax_iss_cd|tax_vat_tp_cd|tax_naid_flg|tax_div_cd|fa_flg|tax_pl_cd|tax_nsl_flg|spl_rgst_no|ownr_nm|co_nm|bzct_nm|bztp_nm|spl_addr|iss_dt|spl_amt|tax_amt|total_amt|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|CRE_USR_ID|UPD_USR_ID";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            										  //134
            //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtStatus,	30,    	daCenter,  	true,    	prefix + "ibflag");
            InitDataProperty(0, cnt++ , dtSeq,    		40,    	daCenter,  	true,    	prefix + "Seq");
			InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  	false,		prefix + "DelChk");
            InitDataProperty(0, cnt++ , dtData,      	180,   	daCenter,  	false,    	prefix + "tax_inv_yrmon",		false,          "",      	dfDateYm,   	0,     	true,       true);
            InitDataProperty(0, cnt++ , dtData,      	180,   	daCenter,  	false,      prefix + "ofc_cd",				false,          "",      	dfNone,   		0,     	true,       true);
            InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_iss_cd",			false,          "",      	dfNone,      	0,     	false,      false);
            InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_vat_tp_cd",		false,          "",      	dfNone,      	0,     	false,      false);
			InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "tax_naid_flg",    	false,          "",      	dfNone,   		0,     	false,      true);
			InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "tax_div_cd",     		false,          "",      	dfNone,   		0,     	true,       true);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "fa_flg",     			false,          "",      	dfNone,  		0,     	true,       true);
			InitDataProperty(0, cnt++ , dtData,      	99,    	daRight,   	false,    	prefix + "tax_pl_cd",			false,          "",      	dfNone, 		2,     	true,       true);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_nsl_flg",			false,          "",      	dfNone,      	0,     	true,       false);
			
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_rgst_no",			false,          "",      	dfNone,      	0,     	true,       false);
			InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "ownr_nm",  			false,          "",      	dfNone,   		0,     	true,       true);
			InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "co_nm",  				false,          "",      	dfNone,   		0,     	true,       true);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "bzct_nm",				false,          "",      	dfNone,      	0,     	true,       false);
			
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "bztp_nm",				false,          "",      	dfNone,      	0,     	true,       false);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_addr",			false,          "",      	dfNone,      	0,     	true,       false);
			
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "iss_dt",				false,          "",      	dfDateYmd,      0,     	true,       false);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_amt",				false,          "",      	dfNullFloat,    2,     	true,       false);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_amt",				false,          "",      	dfNullFloat,    2,     	true,       false);
			InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "total_amt",			false,          "",      	dfNullFloat,    2,     	true,       false);
			InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_tp_cd",			false,			"",			dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_func_cd",			false,			"",			dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_ofc_cd",	    	false,			"",			dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,      	65,		daCenter,	true,		prefix + "slp_iss_dt",			false,			"",			dfDateYmd,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_ser_no",			false,			"",			dfNone,			0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "cre_usr_id",			false,			"",			dfNone,			0,		false,		true);
			InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "upd_usr_id",			false,			"",			dfNone,			0,		false,		true);
        }
        break;
        
    case 3:      //sheet3
        with (sheetObj) {
        	var prefix = "txd_";
        	
            // 높이 설정
            style.height = 100;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = " |순번|Sel|품명|공급가액|세액|합계";
			var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtStatus,		80,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,      	40,		daCenter,	false,		prefix + "tax_dtl_ser_no",	false,		"",		dfNone,				0,		false,		true);
			InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	true,   	prefix + "DelChk");
			InitDataProperty(0, cnt++ , dtData,      	  	440,	daCenter,	true,		prefix + "itm_nm",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "spl_amt",			false,		"",		dfNullFloat,		2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,   	   		100,	daRight,	true,		prefix + "tax_amt",			false,		"",		dfNullFloat,		2,		false,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "total_amt",		false,		"",		dfNullFloat,		2,		false,		true);
        }
        break;
        
    case 4:      //sheet3
        with (sheetObj) {
        	var prefix = "";
        	
            // 높이 설정
            style.height = 100;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = " |rqst_dt|vndr_seq|slp_ser_no|csr_amt|slp_func_cd|slp_iss_dt|slp_ofc_cd|eff_dt|csr_desc|slp_tp_cd|csr_curr_cd|oa_inter_mm_desc|vndr_lgl_eng_nm|oa_inv_dt|evid_tp_cd|asa_no|vat_csr_no|apro_rqst_no";
			var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtStatus,			80,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "rqst_dt",				false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "vndr_seq",				false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "slp_ser_no",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "csr_amt",				false,		"",		dfNone,				0,		true,		true);			
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "slp_func_cd",		false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "slp_iss_dt",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "slp_ofc_cd",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "eff_dt",					false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "csr_desc",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "slp_tp_cd",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "csr_curr_cd",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "oa_inter_mm_desc",		false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "vndr_lgl_eng_nm",			false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "oa_inv_dt",					false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "evid_tp_cd",					false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "asa_no",					false,		"",		dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "vat_csr_no",					false,		"",		dfNone,				0,		true,		true);						
			InitDataProperty(0, cnt++ , dtData,      	  	100,	daCenter,	true,		prefix + "apro_rqst_no",					false,		"",		dfNone,				0,		true,		true);			
        }
        break;        
        
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Col, Row) {
	sheetObj.ShowDebugMsg = false;
	
	switch (sAction) {
		case IBSEARCH: // s_flg : R / E / C / D / ESM_FMS_0101
			var aryPrefix = null;						
			s_flg = getCurFlg();
					
			if(s_flg == "ESM_FMS_0101") {			
				aryPrefix = new Array("slp_", "");
			}else{
				aryPrefix = new Array("slp_","tax_", "txd_", "");
			}
			
			/***********************
			 * "R" : 조회만 가능하게 하기 위함 
			 *       > 조회만 가능
			 * "R1" : (New) Owner's Account에서 호출 시 Slip단위 csr_no가 넘어와서 구분하기 위함
			 * 		 > 조회만 가능      
			 * "E" : Owner's Account Inquiry에서 O/A Entry로 호출 시 수정가능
			 * 		 > 결재 이전 E | 결재 이후 R
			 * "C" : Owner's Account Inquiry에서 Cancel CSR 호출 시 
			 *       > 정상결재된 전표를 취소하는 거니까 원전표 그대로 두고 C전표 생성한다
			 * "D" : Owner's Account Inquiry에서 Delete & Resubmit 호출 시 
			 *       > 결재 Reject된 전표로 원전표 cancel flag "Y"주고 C전표 생성
			 * "ESM_FMS_0101" : O/A Cancellation에서 호출 시
			 * 		 > 선택한 Slip만 받아와서 취소전표 생성한다.
			 * 
			 */

			if(s_flg == "ESM_FMS_0101") {
				var openerSheetObj = opener.document.sheetOACncl;
				var checkedRows = openerSheetObj.FindCheckedRow("sheet_chk");
				var arrRow = checkedRows.split("|");
				var csrNos = "";
				for ( var i = 0; i < arrRow.length - 1; i++) {
					csrNos += openerSheetObj.CellValue(arrRow[i], "sheet_csr_no") + ",";
				}
				formObj.s_csr_no.value = EasDelLastDelim(csrNos);				
				formObj.f_cmd.value = SEARCH01;

			}else{
				formObj.f_cmd.value = SEARCH;
				
			}
			
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			
			var ofcChk = ComGetEtcData(sXml, "ofc_chk");
			if(ofcChk == "ERR"){
				alert("Log in office should be same with office under origin CSR’s RHQ.");
				break;
			}
			
			var rtnSheetObj = null;
			
			if(s_flg == "ESM_FMS_0101") {
				if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[3].LoadSearchXml(arrXml[1]);
				rtnSheetObj = sheetObjects[3];
			}else{
				if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);			
				if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);		
				if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
				rtnSheetObj = sheetObjects[3];				
			}			
						
			
			if(rtnSheetObj.LastRow == 1){
											
				formObj.vndr_seq.value = sheetObjects[0].CellValue(1,slp_prefix+"vndr_seq");						// vndr_seq
				formObj.vndr_name.value = sheetObjects[0].CellValue(1,slp_prefix+"vndr_lgl_eng_nm");		// vndr_lgl_eng_nm
				
				formObj.csr_curr_cd.Code = rtnSheetObj.CellValue(1,"csr_curr_cd");

				var csrAmt = 0;
				
				formObj.cost_ofc_cd.value = rtnSheetObj.CellValue(1,"slp_ofc_cd");
				formObj.ofc_cd.value = rtnSheetObj.CellValue(1,"slp_ofc_cd");
				formObj.slp_ofc_cd.value = rtnSheetObj.CellValue(1,"slp_ofc_cd");

				formObj.csr_no.value = rtnSheetObj.CellValue(1,"slp_tp_cd") + rtnSheetObj.CellValue(1,"slp_func_cd") 
									+ rtnSheetObj.CellValue(1,"slp_ofc_cd") + rtnSheetObj.CellValue(1,"slp_iss_dt") 
									+ rtnSheetObj.CellValue(1,"slp_ser_no");
				
				formObj.csr_amt.value = rtnSheetObj.CellValue(1,"csr_amt");
				amt_change(formObj.csr_amt.value);
				updateCsrAmt(sheetObj, formObj, slp_prefix + "csr_amt");
				
				formObj.oa_inv_dt.value = rtnSheetObj.CellValue(1,"oa_inv_dt");
				ComAddSeparator(formObj.oa_inv_dt, "ymd");
				
				formObj.eff_dt.value = rtnSheetObj.CellValue(1,"eff_dt");
				ComAddSeparator(formObj.eff_dt, "ymd");
				
				formObj.rqst_dt.value = rtnSheetObj.CellValue(1,"rqst_dt");
				ComAddSeparator(formObj.rqst_dt, "ymd");
				
				formObj.csr_desc.value = rtnSheetObj.CellValue(1,"csr_desc");
				formObj.oa_inter_mm_desc.value = rtnSheetObj.CellValue(1,"oa_inter_mm_desc");
				
				formObj.org_slp_tp_cd.value = rtnSheetObj.CellValue(1,"slp_tp_cd");
				formObj.org_slp_func_cd.value = rtnSheetObj.CellValue(1,"slp_func_cd");
				formObj.org_slp_ofc_cd.value = rtnSheetObj.CellValue(1,"slp_ofc_cd");
				formObj.org_slp_iss_dt.value = rtnSheetObj.CellValue(1,"slp_iss_dt");
				formObj.org_slp_ser_no.value = rtnSheetObj.CellValue(1,"slp_ser_no");
				formObj.evid_tp_cd.value =  rtnSheetObj.CellValue(1,"evid_tp_cd");
				setButton(form.evid_tp_cd.value);				
				formObj.asa_no_list.value =  rtnSheetObj.CellValue(1,"asa_no");
				formObj.asa_no.value =  rtnSheetObj.CellValue(1,"asa_no");				
				comboObjects[1].Code2 =rtnSheetObj.CellValue(1,"asa_no");								
				doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');		// 환율 조회
				comboObjects[1].Code = formObj.asa_no.value;
				formObj.org_vndr_seq.value = sheetObjects[0].CellValue(1,slp_prefix+"vndr_seq");				
				formObj.s_csr_no.value = formObj.csr_no.value;		// Re_Creation, Cancel CSR 세팅				
			}

				
			if(s_flg != "R"){
				inputReadOnly("N");
				
			}else if(s_flg == "R"){
				inputReadOnly("Y");
				ComBtnDisable("btn_new");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_submit");
			}
			break;
			
		case IBINSERT:
			var row = sheetObj.DataInsert(-1);
			
			if(document.form.slp_ofc_cd.value != "PUSMOV"){
			   sheetObj.CellValue2(row, slp_prefix + "oa_inv_dt") = formObj.oa_inv_dt.value;
			}
			
			sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = selectedCurrCd;
//			sheetObj.CellValue2(row, slp_prefix + "csr_desc") = formObj.csr_desc.value;
			sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "962111";
			sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = formObj.vndr_seq.value;
			
			if (formObj.ofc_cd.value == "PUSMOV") {
			   sheetObj.CellValue2(row, slp_prefix + "acct_itm_seq") = "105";
			   sheetObj.CellValue2(row, slp_prefix + "acct_itm_nm") = "Panama/Suez Canal(Booking Cancel, PCSOPEP, Extra )";
	        }
			
			edtAcctCell();
			break;
			
		case IBCOPYROW:
			var selRow = sheetObj.SelectRow;
			var newRow = sheetObj.DataInsert();
			
			sheetObj.CellValue2(newRow, slp_prefix + "acct_cd") = "962111";
			sheetObj.CellValue2(newRow, slp_prefix + "acct_itm_nm") = sheetObj.CellValue(selRow, slp_prefix + "acct_itm_nm");
			sheetObj.CellValue2(newRow, slp_prefix + "acct_itm_seq") = sheetObj.CellValue(selRow, slp_prefix + "acct_itm_seq");
			sheetObj.CellValue2(newRow, slp_prefix + "vndr_seq") = formObj.vndr_seq.value;			
			sheetObj.CellValue2(newRow, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(selRow, slp_prefix + "oa_loc_cd");		
			sheetObj.CellValue2(newRow, slp_prefix + "to_inv_no") = sheetObj.CellValue(selRow, slp_prefix + "to_inv_no");
			sheetObj.CellValue2(newRow, slp_prefix + "oa_inv_dt") = sheetObj.CellValue(selRow, slp_prefix + "oa_inv_dt");
			sheetObj.CellValue2(newRow, slp_prefix + "csr_curr_cd") = sheetObj.CellValue(selRow, slp_prefix + "csr_curr_cd");
			sheetObj.CellValue2(newRow, slp_prefix + "atch_file_oa_lnk_cnt") = 0;
						
			updateCsrAmt(sheetObj, formObj, slp_prefix + "csr_amt");			
			
			edtAcctCell();			
			break;
			
		case IBDELETE:
			var selRow = sheetObj.SelectRow;
			sheetObj.RowHidden(selRow)= true;
			sheetObj.RowStatus(selRow)= "D";
			updateCsrAmt(sheetObj, formObj, slp_prefix + "csr_amt");
			break;
			
		case IBSAVE: // 저장
			bReSearchFlag = true;
			
			var csr_no = formObj.csr_no.value;
			var aryPrefix = new Array(slp_prefix, "");
			var slp_func_cd = "";
			var csr_amt = formObj.csr_amt.value;
			
			var apro_step = formObj.apro_step.value;
			
			if(apro_step == "") {
				alert("ALPS Approval Step must exist.");
				return;	
			}
			
			var chkSign = Math.sign(csr_amt);
			
			var s_flg = getCurFlg();
			if(s_flg == "ESM_FMS_0101" || s_flg == "C" || s_flg == "D" || s_flg == "E") {		// Multi-Cancellation for O/A 에서 호출시에  slp_func_cd는 그대로 따라간다.	 //2018.03.27 C,D,E 인 경우 추가
				formObj.slp_func_cd.value =  formObj.csr_no.value.substring(2,3);
			}else{
				formObj.slp_func_cd.value = "S";			
				if(chkSign == 1){
					formObj.slp_func_cd.value = "S";
				}else if(chkSign == -1){
					formObj.slp_func_cd.value = "C";
				}				
			}

			if (!validateForm(sheetObj, formObj, sAction)){
				return;				
			}
			
			// Tax Evidence 체크
			if(   formObj.evid_tp_cd_val.value == "1"
			   || formObj.evid_tp_cd_val.value == "4") {

				if(sheetObjects[2].RowCount == 0) {
					ComShowCodeMessage("FMS01458");
					return;
				}
			}			
			
			// 세금 계산서 생성
			var evid_tp_cd = form.evid_tp_cd_val.value;
			var taxCnt = sheetObjects[2].RowCount;
																	
			if(taxCnt > 0 && evid_tp_cd == "1") {				
			}						
						
			formObj.csr_amt.value = ComReplaceStr(csr_amt, ',', ''); 
						
			//ASA 등록
			formObj.asa_no.value = comboObjects[1].Code;
			
			if(!saveConfirm()) return;						
			
			formObj.f_cmd.value = MULTI;
			
			var arrSheets = new Array(sheetObjects[0], sheetObjects[1], sheetObjects[2]);
			var sParam = ComGetSaveString(arrSheets);
						
			if (sheetObj.IsDataModified && sParam == "") {
				return; 
			}						
			var aryPrefix = new Array("", "slp_","tax_", "txd_");
			sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);				
			var xml = sheetObj.GetSaveXml("ESM_FMS_0095GS.do", sParam);
			sheetObj.LoadSaveXml(xml);
			
			break;
		
		case "DELETE":
			bReSearchFlag = false;
			
			var csr_no = formObj.csr_no.value;

			if (csr_no.trim() == ""){
				return;				
			}
			
			var lastRow = sheetObj.LastRow;
			for ( var i = 1; i <= lastRow; i++) {
				sheetObj.CellValue2(i, slp_prefix + "ibflag") = "D";
			}
			
			formObj.f_cmd.value = REMOVE;

			sheetObj.DoSave("ESM_FMS_0095GS.do", FormQueryString(formObj));
			
			ComResetAll();
			fncNew();
						
			bReSearchFlag = true;			
			
			break;
			
		case IBCREATE:
			bReSearchFlag = false;						
			var csr_amt = ComReplaceStr(formObj.csr_amt.value, ',', '');

			formObj.csr_amt.value = csr_amt;			
			formObj.f_cmd.value = MULTI01;
				
			var apro_step = formObj.apro_step.value;
			
			if(apro_step == "") {
				alert("ALPS Approval Step must exist.");
				return;	
			}
			
			if (!validateForm(sheetObj, formObj, sAction)){
				return;				
			}
			
			// Tax Evidence 체크
			if(   formObj.evid_tp_cd_val.value == "1"
			   || formObj.evid_tp_cd_val.value == "4") {

				if(sheetObjects[2].RowCount == 0) {
					ComShowCodeMessage("FMS01458");
					return;
				}
			}			
			
			if(!submitConfirm()) return;				
//			fnTax42();					
			//-------------------------------------------------			
			var arrSheets = new Array(sheetObjects[0], sheetObjects[1], sheetObjects[2]);
			var sParam = ComGetSaveString(arrSheets);
						
			if (sheetObj.IsDataModified && sParam == "") {
				return; 
			}						
			var aryPrefix = new Array("", "slp_","tax_", "txd_");
			sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
			
				
			var xml = sheetObj.GetSaveXml("ESM_FMS_0095GS.do", sParam);			
			sheetObj.LoadSaveXml(xml);
			var apro_type = ComGetEtcData(xml, "apro_type");
												
			var param = "?inv_sub_sys_cd=FMS&apro_type=" + apro_type;						
						
			if(apro_type == "GW"){// 결재요청 GroupWare
				formObj.f_cmd.value = MULTI10;
				
				var sXml = sheetObj.GetSearchXml("COM_CSR_00081GS.do" + param, FormQueryString(formObj), "", true);   			
   				var gwUrl = ComGetEtcData(sXml , "GW_URL");
				
   				if (ComIsNull(gwUrl)) {
   					ComShowMessage(ComGetMsg('TES21017'));
   					return;
   				}
   				
   				ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
   				
			}else if(apro_type == "ALPS"){// 결재요청 ALPS
				formObj.f_cmd.value = MULTI11;
				formObj.curr_cd.value = formObj.csr_curr_cd.Code;
				formObj.total_amt.value = formObj.csr_amt.value;
				formObj.payment_due_dt.value = formObj.rqst_dt.value;				
				var sXml = sheetObj.GetSearchXml("COM_CSR_00081GS.do" + param, FormQueryString(formObj), "", true);  
				sheetObj.LoadSaveXml(sXml,true);
			}
			
			if(typeof apro_type != "undefined" && apro_type != "") {			
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_submit");
			}
			
			bReSearchFlag = true;
			
			break;
			
		case IBROWSEARCH:
			if (Col == "eff_dt") {
				
				if (formObj.eff_dt.value == "") {
					break;
				}
    			
    			sheetObj.WaitImageVisible = false;
    			
				formObj.f_cmd.value = SEARCH09;
				
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(formObj),"-",""));
	   			
	   			var effDt = ComGetEtcData(sXml, "effDt");											// Eff DT
	   			var usdLoclXchRt = ComGetEtcData(sXml, "usdLoclXchRt");	   			// 환율	
				var comboItems = ComGetEtcData(sXml, "asa_no").split("|");	   			// ASA
	   			
	   			
	   			if(typeof effDt == "undefined" || effDt == "" ) {
					formObj.eff_dt.value = "";
					ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
					return;
					
				} else {
					pre_eff_dt = form.eff_dt.value;

				}	   			
	   			
	   			if(typeof usdLoclXchRt != "undefined" && usdLoclXchRt != "" ) {
	   				formObj.usd_locl_xch_rt.value = usdLoclXchRt;	   				
				}	   			
	   		   			
	   			if(typeof comboItems != "undefined" && comboItems != "" ) {	   			
	   				addComboItemAsa(comboObjects[1],comboItems);
	   			}
	   				   			
	   			sheetObj.WaitImageVisible = true;
	   			
    		}   		
			break;			
		case "IBSEARCHGL":
			formObj.f_cmd.value = SEARCH11;
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do", ComReplaceStr(FormQueryString(formObj), "-", ""));
			
			var effDt = ComGetEtcData(sXml, "effDt");
			
			formObj.eff_dt.value = effDt;
			break;
			
		case "IBSEARCHCURR":
			formObj.f_cmd.value = SEARCH12;
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do", ComReplaceStr(FormQueryString(formObj), "-", ""));
			
			var currCd = ComGetEtcData(sXml, "currCd");
			comboObjects[0].Code = currCd;
			
			break;
	}
}

/**
 * Event에 따른 화면 처리 <br>
 * 
 * @param {String} flag Event 구분값
 */
function inputReadOnly(flag) {
	var sheetObj = sheetObjects[0];
	var comboObj = comboObjects[0];
	
	var lastRow = sheetObj.LastRow;
	var lastCol = sheetObj.LastCol;
  
	var gridBtn = document.getElementById('grid_btn');
	
	if (flag == "New" || flag == "N") {
		form.vndr_seq.readOnly = false;
		form.csr_curr_cd.readOnly = false;
		form.csr_amt.readOnly = false;
		form.oa_inv_dt.readOnly = false;
		form.eff_dt.readOnly = false;
		form.rqst_dt.readOnly = false;
		form.csr_desc.readOnly = false;
		form.oa_inter_mm_desc.readOnly = false;

		document.images["btn_vndr_pop"].name = "btn_vndr_pop";
		form.btn_vndr_pop.style.cursor = "hand";
		document.images["eff_dt_cal"].name = "eff_dt_cal";
		form.eff_dt_cal.style.cursor = "hand";
		document.images["oa_inv_dt_cal"].name = "oa_inv_dt_cal";
		form.oa_inv_dt_cal.style.cursor = "hand";
		document.images["rqst_dt_cal"].name = "rqst_dt_cal";
		form.rqst_dt_cal.style.cursor = "hand";

		comboObj.Enable = true;
		
		for(var i = 1; i <= lastRow; i++) {
			sheetObj.RowEditable(i) = true;				
		}
		gridBtn.style.display = 'block';
		
		pre_eff_dt = "";
		
	} else {
		form.vndr_seq.readOnly = true;
		form.csr_curr_cd.disabled = true;
		form.csr_amt.readOnly = true;
		form.oa_inv_dt.readOnly = true;
		form.eff_dt.readOnly = true;
		form.rqst_dt.readOnly = true;
		form.csr_desc.readOnly = true;
		form.oa_inter_mm_desc.readOnly = true;
		
		document.images["btn_vndr_pop"].name = "btn_vndr_pop";
		form.btn_vndr_pop.style.cursor = "default";
		document.images["eff_dt_cal"].name = "eff_dt_cal";
		form.eff_dt_cal.style.cursor = "default";
		document.images["oa_inv_dt_cal"].name = "oa_inv_dt_cal";
		form.oa_inv_dt_cal.style.cursor = "default";
		document.images["rqst_dt_cal"].name = "rqst_dt_cal";
		form.rqst_dt_cal.style.cursor = "default";
		
		comboObj.Enable = false;
		
		for(var i = 1; i <= lastRow; i++) {
//			sheetObj.RowEditable(i) = false;			
			for(var j = 2; j < lastCol; j++) {																
				if(sheetObj.ColSaveName(j) != slp_prefix+"atch_file_oa_lnk_cnt"){				
					sheetObj.CellEditable(i, j) = false;									
				}
			}
		}
		gridBtn.style.display = 'none';
	}
}

/**
 * .<br>
 * 
 * @param {int} Row 행번호
 * @param {int} Col 컬럼번호
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	switch (sheetObj.ColSaveName(Col)) {

		case slp_prefix + "oa_inv_dt":
			var cal = new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, 'yyyyMMdd');
			break;
		
		case slp_prefix + "atch_file_oa_lnk_cnt":
			var editable = "Y";
			var csrNo = document.form.csr_no.value;
			if(csrNo.trim() == "") {
				// msgs['FMS20030'] = 'Please operate {?msg1} first.';
				ComShowCodeMessage("FMS20030", "Save");
				return;
			}
			
			var sFlg = getCurFlg();
			if(sFlg == "R") {
				editable = "N";
			}
			
			var slpSeqNo = sheetObj.CellValue(Row, slp_prefix + "slp_seq_no");
			var tempSeq = 1000;
			
			if(typeof slpSeqNo == "undefined" || slpSeqNo == "") {
				for(var i = 1; i <= sheetObj.RowCount; i++) {			
					if(sheetObj.CellValue(i, slp_prefix + "slp_seq_no") < 3000){
						if(sheetObj.CellValue(i, slp_prefix + "slp_seq_no") >= 1000){
							tempSeq = Number(sheetObj.CellValue(i, slp_prefix + "slp_seq_no")) + 1;						
						}
					}
				}
				slpSeqNo = tempSeq;			
			}											
			sheetObj.CellValue2(Row, slp_prefix + "slp_seq_no") = slpSeqNo;
			
			fmsFileUploadPopUp(sheetObj, Row, editable, csrNo + slpSeqNo);
			break;
			
		case slp_prefix + "acct_itm_nm":
			ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OW", 550, 455, "setGridItemNm", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0076");
			break;
	}
}

/**
 * IBSheet를 조회 후 실행되는 이벤트
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	s_flg = getCurFlg();
	if(s_flg == "R1"){
		inputReadOnly("Y");
	}	
	
	if(s_flg == "C" || s_flg == "ESM_FMS_0101"){
		for(var i = 1; i <= sheetObj.RowCount; i++) {
			sheetObj.CellValue2(i, slp_prefix + "to_inv_no") = "";
		}
	}
	
}

/**
 * IBSheet를 저장 후 실행되는 이벤트
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	// CSR No. Setting
	var formObj = document.form;
	var csrNo = sheetObj.EtcData("csr_no");
			
	if (typeof csrNo != "undefined" && csrNo != "") {
		formObj.csr_no.value = csrNo;
		formObj.s_csr_no.value = csrNo;

		// Submit Button Enable 하기
		ComBtnEnable("btn_submit");
		// Print Button Enable 하기
		ComBtnEnable("btn_print");

	}
	s_flg = getCurFlg();
	if(s_flg != "R"){
		formObj.s_flg.value = "E";
		
	}
	
	// 최초 bReSearchFlag를 true, Submit시에만 bReSearchFlag를 false
	if(bReSearchFlag) {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}	
}

/**
 * IBSheet Object에서 입력값이 변경된 경우
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var colname = sheetObj.ColSaveName(Col);
	
	switch (colname){
	
	case slp_prefix + "vvd_cd":		
		if(form.slp_ofc_cd.value == "PUSMOV"){		
			validateSheet(sheetObj, Row, colname, Value, SEARCH13, "VVD");
		}else{
			validateSheet(sheetObj, Row, colname, Value, COMMAND02, "VVD");			
		}					
		break;
	case slp_prefix + "oa_loc_cd":
		validateSheet(sheetObj, Row, colname, Value, SEARCH04, "Location");
		break;
	case slp_prefix + "to_inv_no":
		// Suplier + to_inv_no 조합으로 중복체크필요
		var lastRow = sheetObj.LastRow;
		
		for ( var i = 0; i <= lastRow; i++) {
			if(i != Row) {
				//if(sheetObj.CellValue(i, colname) == Value) {
				if(sheetObj.CellValue(i, colname) == Value && sheetObj.CellValue(Row, slp_prefix + "acct_cd") == "962111") {
					sheetObj.CellValue2(Row, colname) = "";
					alert("Dup Invoice No.");
					sheetObj.SelectCell(Row, colname);
					return false;
				}
			}
		}
		validateSheet(sheetObj, Row, colname, Value, COMMAND01, "Invoice No");
		break;
	case slp_prefix + "csr_amt":
		updateCsrAmt(sheetObj, formObj, Col);		
		break;		
	case slp_prefix + "acct_cd":		
		if(!(Value == "962111" || Value == "111821" || Value == "211691" )){
			alert("Use  account code only 962111, 111821, 211691");			
			sheetObjects[0].CellValue2(Row,Col) = "962111";
		}
		
		if(Value == "951111" || Value == "111821" || Value =="211691"){
			edtAcctCell();
		}
		
		break;
	}
}

/**
 * Effective Date 변경 시 체크한다. <br>
 **/
function eff_dt_change() {
	if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');
  	}
}

function validateSheet(sheetObj, Row, Col, Value, fCmd, label) {
	if(Value.trim() == ""){
		return;
	}
	
	switch (Col){
		case slp_prefix + "vvd_cd":	
			// 운항팀
			if(form.slp_ofc_cd.value == "PUSMOV"){
				var vvd = sheetObj.CellValue(Row, slp_prefix + "vvd_cd");
				var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do?vvd="+vvd+ "&f_cmd="+fCmd);
						
				var size = ComGetEtcData(sXml, "size");				
				var vsl_cd = ComGetEtcData(sXml, "vsl_cd");
				var skd_voy_no = ComGetEtcData(sXml, "skd_voy_no");
				var skd_dir_cd = ComGetEtcData(sXml, "skd_dir_cd");
				var yd_cd = ComGetEtcData(sXml, "yd_cd");
				var rlane_dir_cd = ComGetEtcData(sXml, "rlane_dir_cd");
				var rqst_amt = ComGetEtcData(sXml, "rqst_amt");
				var file_sav_id = ComGetEtcData(sXml, "file_sav_id");
				var invoice_dt = ComGetEtcData(sXml, "invoice_dt");
				var rmk = ComGetEtcData(sXml, "rmk");
				var inv_no = ComGetEtcData(sXml, "inv_no");
				
				if(form.oa_inv_dt.value < invoice_dt) {
				   form.oa_inv_dt.value = invoice_dt;
				   form.rqst_dt.value = invoice_dt;
				}

				if(size > 0){
					sheetObj.CellValue2(Row, slp_prefix + "vvd_cd") = vsl_cd+skd_voy_no+skd_dir_cd+rlane_dir_cd;
					sheetObj.CellValue2(Row, slp_prefix + "oa_loc_cd") = yd_cd;
					sheetObj.CellValue2(Row, slp_prefix + "csr_curr_cd") = "USD";
					sheetObj.CellValue2(Row, slp_prefix + "csr_amt") = rqst_amt;				
					sheetObj.CellValue2(Row, slp_prefix + "csr_desc") = rmk;	
					sheetObj.CellValue2(Row, slp_prefix + "file_sav_id") = file_sav_id;
					sheetObj.CellValue2(Row, slp_prefix + "oa_inv_dt") = invoice_dt;
					sheetObj.CellValue2(Row, slp_prefix + "to_inv_no") = inv_no;					
					
					updateCsrAmt(sheetObj, form, slp_prefix + "csr_amt");
					
				}else{
					sheetObj.CellValue2(Row, slp_prefix + "vvd_cd") = "";
					ComShowMessage("VVD is not available.");
					sheetObj.SelectCell(Row, slp_prefix + "vvd_cd");
					return false;					
				}
			}else{			
				if(ComIsEmpty(sheetObj.CellValue(Row, slp_prefix + "oa_loc_cd"))) {
					// msgs['COM130201'] = 'Please input {?msg1}.';
					ComShowCodeMessage('COM130201', "Location First!");
					sheetObj.CellValue2(Row, slp_prefix + "vvd_cd") = "";
					sheetObj.SelectCell(Row, slp_prefix + "oa_loc_cd");
					return;
				}
				
				var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do?vvd_cd=" + Value +
						"&oa_loc_cd=" + sheetObj.CellValue(Row, slp_prefix + "oa_loc_cd") + "&f_cmd=" + fCmd);
				
				var vsl_cd = ComGetEtcData(sXml, "vsl_cd");
				var skd_voy_no = ComGetEtcData(sXml, "skd_voy_no");
				var skd_dir_cd = ComGetEtcData(sXml, "skd_dir_cd");
				var rlane_dir_cd = ComGetEtcData(sXml, "rlane_dir_cd");
				var vps_etd_dt = ComGetEtcData(sXml, "vps_etd_dt");
				
				if(vsl_cd != "null"){
					sheetObj.CellValue2(Row, slp_prefix + "vvd_cd") = vsl_cd+skd_voy_no+skd_dir_cd+rlane_dir_cd;
					sheetObj.CellValue2(Row, slp_prefix + "vps_etd_dt") = vps_etd_dt;
				}else{
					sheetObj.CellValue2(Row, slp_prefix + "vvd_cd") = "";
					sheetObj.CellValue2(Row, slp_prefix + "vps_etd_dt") = "";
					ComShowMessage("VVD is not available.");
					sheetObj.SelectCell(Row, slp_prefix + "vvd_cd");
					return false;
				}
			}					
			break;
			
		case slp_prefix + "oa_loc_cd":
			sheetObj.CellValue2(Row, slp_prefix + "vvd_cd") = "";
			sheetObj.CellValue2(Row, slp_prefix + "vps_etd_dt") = "";
			
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do?loc_cd="+Value + "&f_cmd=" + fCmd);
			var cdName = ComGetEtcData(sXml, "cdName");
   			if(typeof cdName != "undefined" && cdName != "" ) {
   				sheetObj.CellValue2(Row, Col) = cdName;
			} else {
				ComShowMessage(ComGetMsg("FMS00006", label));
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
			}
			break;
			
		case slp_prefix + "to_inv_no":
			//var vndrSeq = sheetObj.CellValue(Row, slp_prefix + "vndr_seq");
			var vndrSeq = form.vndr_seq.value;
			var csrNo = form.csr_no.value;
			var vvd_cd = sheetObj.CellValue(Row, slp_prefix + "vvd_cd");
			var acct_cd = sheetObj.CellValue(Row, slp_prefix + "acct_cd");
			
			if(vvd_cd == "" && acct_cd == "962111") {
				alert("Please input VVD First!");
				sheetObj.CellValue2(Row, slp_prefix + "to_inv_no") = "";
				sheetObj.SelectCell(Row, slp_prefix + "vvd_cd");
				return false;
			}
			
			var sXml = sheetObj.GetSearchXml("ESM_FMS_0095GS.do?to_inv_no=" + Value 
					+ "&vndr_seq=" + vndrSeq + "&csr_no=" + csrNo + "&vvd=" + vvd_cd + "&f_cmd=" + fCmd);

			var inv_chk = ComGetEtcData(sXml, "INV_CHK");	

			//if(CoFmsShowXmlMessage(sXml) != "") {
			if(inv_chk == 'D') {
				sheetObj.CellValue2(Row, slp_prefix + "to_inv_no") = "";
				alert("Dup Invoice No.");
				sheetObj.SelectCell(Row, slp_prefix + "to_inv_no");
				return false;
			}
			break;
			
	}
	
}

function updateCsrAmt(sheetObj, formObj, Col) {
	var sum = 0;
	var lastRow = sheetObj.LastRow;

	for ( var i = 1; i <= lastRow; i++) {
		if(sheetObj.CellValue(i, slp_prefix + "ibflag") != "D") {
			sum += parseFloat(sheetObj.CellValue(i, Col));	
		}
	}

	formObj.cr_amt.value = ComAddComma(sum.toFixed(2));
}

/** 
 * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {int} x 필수, X 좌표
 * @param {int} y 필수, Y 좌표
 * @return 없음
 */   
function sheet1_OnMouseMove(sheetObj, button, shift, x, y){
	with(sheetObj){

		if(ColSaveName(MouseCol) == slp_prefix + "acct_itm_nm" 
				|| ColSaveName(MouseCol) == slp_prefix + "oa_inv_dt" 
				|| ColSaveName(MouseCol) == slp_prefix + "atch_file_oa_lnk_cnt") {
			if(sheetObj.CellEditable(sheetObj.MouseRow, sheetObj.MouseCol)) {
				sheetObj.MousePointer = "Hand";
			} 
//			sheetObj.MousePointer = "Hand";
		} else {
			MousePointer = "Default";
		} 	
	}
}

/**
 * FMS File Upload 팝업 오픈
 */
function fmsFileUploadPopUp(sheetObj, Row, edit_able, csr_no) {
	var atch_file_flet_lnk_id =  '';	 
	 
	atch_file_flet_lnk_id =  sheetObj.CellValue(Row, slp_prefix + "atch_file_oa_lnk_id");	
		
	if (atch_file_flet_lnk_id == undefined || atch_file_flet_lnk_id == null || ComTrim(atch_file_flet_lnk_id) == ''){
		atch_file_flet_lnk_id = '';
	}
	if (csr_no == undefined || csr_no == null || ComTrim(csr_no) == ''){
		csr_no = '';
	}
	 		
	var param = "?atch_file_flet_lnk_id=" + atch_file_flet_lnk_id+
					 "&csr_no=" + csr_no +
					 "&edit_able=" + edit_able +
					 "&tab_gubun="+ slp_prefix +
					 "&row=" + Row
					 ;					
	ComOpenPopup("/hanjin/ESM_FMS_0092.do" + param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");	 
}

/**
 * FileUpload PopUp닫고나서 실행할꺼  
 */
function popupFinish(){
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	// 필수 입력 등 Validation 체크
	if (!ComChkValid(formObj))
		return false;

	if (sAction == IBSAVE) {
		
		var asaCnt = 0;
		
		// row validation ------------------------------------
		for(var i = 1; i <= sheetObj.RowCount; i++) {			
			if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "962111"){			
				if(sheetObj.CellValue(i, slp_prefix + "acct_itm_nm") == ""){
					ComShowCodeMessage('FMS00004', sheetObj.CellValue(0, slp_prefix + "acct_itm_nm"));
					sheetObj.SelectCell(i, slp_prefix + "acct_itm_nm");
					return false;
				}else if(sheetObj.CellValue(i, slp_prefix + "vvd_cd") == ""){
					sheetObj.SelectCell(i, slp_prefix + "vvd_cd");
					return false;
				}else if(sheetObj.CellValue(i, slp_prefix + "oa_loc_cd") == ""){
					sheetObj.SelectCell(i, slp_prefix + "oa_loc_cd");
					return false;
				}else if(sheetObj.CellValue(i, slp_prefix + "to_inv_no") == ""){
					sheetObj.SelectCell(i, slp_prefix + "to_inv_no");
					return false;
				}else if(sheetObj.CellValue(i, slp_prefix + "oa_inv_dt") == ""){
					sheetObj.SelectCell(i, slp_prefix + "oa_inv_dt");
					return false;
				}else if(sheetObj.CellValue(i, slp_prefix + "csr_amt") == "0"){
					sheetObj.SelectCell(i, slp_prefix + "csr_amt");
					return false;
				}else if(sheetObj.CellValue(i, slp_prefix + "csr_desc") == ""){
					sheetObj.SelectCell(i, slp_prefix + "csr_desc");
					return false;
				}
			}
			
			if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "954113") asaCnt++;
		}
		// row validation ------------------------------------

		//2017.04.25 ASA validation 추가
		if(formObj.so_if_cd.value == "O") {
			if(formObj.asa_no_list.Code == "") {
				ComShowCodeMessage("FMS20031");
				return false;
			}
			
			if(asaCnt == 0) {
				ComShowCodeMessage("FMS20032");
				return false;
			}
		}
		
	} else if (sAction == IBCREATE) {
		var csr_no = formObj.csr_no.value;
		if(csr_no.trim() == "") {
			ComAlertFocus(formObj.csr_no, ComGetMsg("FMS20007"));
		}
		
		// row validation ------------------------------------				
		for(var i = 1; i <= sheetObj.RowCount; i++) {
			if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "962111"){
				var atch = sheetObj.CellValue(i, slp_prefix + "atch_file_oa_lnk_cnt");
				if(atch == "" || atch == "0") {
					ComShowCodeMessage("FMS01509");
					return false;
				}
			}
		}
		
		// row validation ------------------------------------		
		var aa = formObj.dr_amt.value;
		var bb = formObj.cr_amt.value;

		var drAmt = parseFloat(ComReplaceStr(aa, ',', ''));
		var crAmt = parseFloat(ComReplaceStr(bb, ',', ''));
		
		if (drAmt != crAmt) {
			ComShowCodeMessage("FMS01508");
			return false;
		}		
	}
	return true;
}

/**
 * S/P Code의 Input Text에 Popup에서 설정한 S/P Code 및 S/P Name 를 셋팅한다.
 * @param aryPopupData
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function setServiceProviderInfo(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	formObj.vndr_seq.value = aryPopupData[0][1];
	formObj.vndr_name.value = aryPopupData[0][2];
	formObj.vndr_deleted.value = aryPopupData[0][3];

	var lastRow = sheetObjects[0].LastRow;
	for ( var i = 1; i <= lastRow; i++) {
		sheetObjects[0].CellValue2(i, slp_prefix + "vndr_seq") = aryPopupData[0][1];
	}
	updateDueDt( formObj.vndr_seq.value );
}

/**
 * setGridItemNm 입력부분.<br>
 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
 */
function setGridItemNm(aryPopupData, row, col, sheetIdx){
	var selRow = sheetObjects[0].SelectRow;
	sheetObjects[0].CellValue2(selRow, slp_prefix + "acct_itm_nm") = aryPopupData[0][2];
	sheetObjects[0].CellValue2(selRow, slp_prefix + "acct_cd") = aryPopupData[0][3];
	sheetObjects[0].CellValue2(selRow, slp_prefix + "acct_itm_seq") = aryPopupData[0][4];
}

function getCurFlg() {
	var sFlg = document.form.s_flg.value;
	
	return sFlg;
}
/**
 * 페이지에 있는 RD Object를 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
 * 
 * @param {rdObject} rdObject RD Object
 */
function initRdConfig(rdObject) {
	var Rdviewer = rdObject;
	Rdviewer.style.height = 0;
	Rdviewer.style.width = 0;

	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);

	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
}

function rdOpen(rdObject, formObject) {
	
	if(sheetObjects[0].RowCount == 0) {
		ComShowCodeMessage("FMS00015");
		return;
	}
	
	var csr_no = "";		
	var csr_type = "";
			
	csr_no = form.csr_no.value;
	
	if(form.csr_no.value.substring(0,2) == "07") {
		csr_type = "AP";
	} else {
		csr_type = "AR";
	}        
	
	form.csr_type.value = "AP"; 	
	
	var rdParam = "/rv frm1_csr_no["+csr_no+"] frm1_csr_type["+csr_type+"]";
 	var strPath   = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_032.mrd";
                       	
 	form.com_mrdPath.value = strPath;
 	form.com_mrdArguments.value = rdParam;
    ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');    
       
/*	
	if (sheetObjects[0].RowCount == 0) {
		ComShowCodeMessage("FMS00015");
		return;
	}

	formObject.csr_type.value = "AP"; 
	
	var Rdviewer = rdObject;

	rdParam = RD_FormQueryString(formObject, 1);
	var rdParam = '/rv ' + rdParam;
	var rdFile = 'ESM_FMS_032.mrd';
	
	// 열고자 하는 RD 파일을 지정한다.
	Rdviewer.FileOpen( RD_path + 'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/' + rdFile, RDServer + rdParam);
	Rdviewer.CMPrint (); //인쇄 시작
*/	 
}

/**
 * 양수인지 음수인지 구분한다.
 */
Math.sign = Math.sign || function(x) {
//	x = x.replace(",", "");	
	x = ComReplaceStr(x, ',', '');
	
	x = +x; // convert to a number
	if (x === 0 || isNaN(x)) {
		return x;
	}
	return x > 0 ? 1 : -1;
}

//==============================================================================================
/**
 * New 버튼 클릭
 **/
function fncNew(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	s_flg = getCurFlg();	
	
	if (!CoFmsInitConfirm(sheetObject))
		return;
	
	ComResetAll();
	inputReadOnly("New");
	
	if(form.slp_ofc_cd.value == "PUSMOV") {
		comboObjects[0].Code2 = "USD";
		formObject.dr_curr_cd.value = "USD";
		formObject.cr_curr_cd.value = "USD";
	}
	else {
		doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHCURR");
		formObject.dr_curr_cd.value = selectedCurrCd ;
		formObject.cr_curr_cd.value = selectedCurrCd ;
	}
	//----------------------------------------------------------------------
	setCurDate();
	// 현재 오픈되어있는 G/L Date가져온다
	doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHGL");
	
	// 현재 접속 Local Currency를 가져온다
	doActionIBSheet(sheetObjects[0], document.form, "IBSEARCHCURR");
	pre_eff_dt = "";
	//운항팀(PUSMOV) currency는 항상 USD	
	if(form.slp_ofc_cd.value == "PUSMOV"){
		comboObjects[0].Code2 = "USD";	
		
		if(popup != "yes") {
		  form.oa_inv_dt.value = "";
		}
	}							
	eff_dt_change(); 	// eff_dt, 환율, Asa 조회				
	form.evid_tp_cd.value = "5";
	form.evid_tp_cd.disabled = false;
	
	ComBtnEnable("btn_save");
	ComBtnEnable("btn_delete");
	ComBtnEnable("btn_submit");
	//----------------------------------------------------------------------		
}

/**
 * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function sheet1_OnLoadFinish(sheetObj) {  
	sheetObj.WaitImageVisible = false;	
    CoFmsGetCombo('FORM', document.form, sheetObj, 'CD01745', 'evid_tp_cd', 'evid_tp_nm');    
    setEvidenceType();	
	sheetObj.WaitImageVisible = true;   
}

/**
 * Evidence Type Default 값 세팅
 * ETC Data Default 세팅(코드값:5) <br>
 **/
function setEvidenceType() {
	var length = form.evid_tp_cd.length;
	
	if(length > 0) {
		for(var i=0; i<length; i++) {
			if(form.evid_tp_cd.options[i].value == "5") {
				form.evid_tp_cd.selectedIndex = i;
				break;
			}
		}
	}
}

/**
 * Tax Evidence 버튼 클릭 시 VAT Apply 체크박스 초기화
 * @param {ibsheet}	sheetObj    IBSheet Object
 **/
function setInitVatApply(sheetObj) {
	for(var ir=1; ir<=sheetObj.LastRow; ir++) {
		sheetObj.CellValue2(ir,"vat_apply") = 0;
	}
}

/**
 * Evidence Type 변경시 Tax Evidence버튼을 컨트롤한다 <br>
 **/
function setButton(val) {
/*	
	100010	CD01745	1	TAX
	100020	CD01745	4	CI
	100030	CD01745	5	ETC
*/	
		
	if(form.cnt_cd.value != "KR"){
		if(val == "1" || val == "4" ){
			form.evid_tp_cd.value = "5";
			val = "5";
		}
	}
	
	form.evid_tp_cd_val.value = val;
	
	if(val == 5) {
    	//Payments Slip TaxEvidence Button Disable 하기
		ComBtnDisable("btn_taxEvidence");		
	} else {	
		//Payments Slip TaxEvidence Button Enable 하기
		ComBtnEnable("btn_taxEvidence");
	}
}

function setTaxEvidence(){
}

/**
 * IBSheet Object에서 입력값이 변경된 경우
 */
function sheet2_OnChange(sheetObj, Row, Col, Value){
	var currCd = comboObjects[0].Code;
	var colName = sheetObj.ColSaveName(Col);
	
	if(colName == "tax_total_amt"){								
		if(currCd == "KRW"){			
			if(sheetObj.CellValue(1, "tax_tax_pl_cd") == '1'){				// tax_tax_pl_cd 1:영세, 2:과세			
				fnTax1();		// 영세, KRW
			}else{	
				fnTax3();		// 과세, KRW				
			}			
		}else{
			if(sheetObj.CellValue(1, "tax_tax_pl_cd") == '1'){	
				fnTax2();		// 영세, USD			
			}else{				
				fnTax4();		// 과세, USD				
			}	
		}		
	}	
	edtAcctCell();
}

/**
 * 영세, KRW
 */
function fnTax1(){ 	
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;
	var oaLocCd = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
	var vndrSeq = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
	var hiddenRow = 0;		
	
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "111811" ){
			hiddenRow = i;			
			sheetObj.CellValue2(i, slp_prefix + "ibflag") = "D";
 			
		}
	}	
	if(hiddenRow > 1){
		sheetObj.RowHidden(hiddenRow) = true;
	}		
		
	var row = sheetObj.DataInsert(-1);
		
	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "111811";
	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = oaLocCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = "KRW";
	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = 0;
	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = form.csr_desc.value+" 매입 0% 일반";
	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = vndrSeq;
	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4000";		
}

/**
 * 영세, USD
 */
function fnTax2(){
	var sheetObj = sheetObjects[0];
	var currCd = comboObjects[0].Code;	
	var lastRow = sheetObj.LastRow;
	var oaLocCd = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
	var vndrSeq = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
	var hiddenRow = 0;	
		
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "111811" ){
			hiddenRow = i;			
			sheetObj.CellValue2(i, slp_prefix + "ibflag") = "D";						
		}
	}	
	
	if(hiddenRow > 1){
		sheetObj.RowHidden(hiddenRow) = true;
	}	
		
	var row = sheetObj.DataInsert(-1);
		
	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "111811";
	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = oaLocCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = currCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = 0;
	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = form.csr_desc.value+" 매입 0% 일반";	
	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = vndrSeq;
	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4000";	
}

/**
 * 과세, KRW
 */
function fnTax3(){
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;
	var oaLocCd = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
	var vndrSeq = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
	var hiddenRow = 0;		
	
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "111811" ){
			hiddenRow = i;
			sheetObj.CellValue2(i, slp_prefix + "ibflag") = "D"; 
		}
	}	
	if(hiddenRow > 1){
		sheetObj.RowHidden(hiddenRow) = true;
	}		
		
	var row = sheetObj.DataInsert(-1);		
	var tempAmt = 0;
	
	for ( var i = 1; i <= lastRow; i++) {						
		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") != "111811" ){						
			tempAmt = tempAmt + Number(sheetObj.CellValue(i, slp_prefix + "csr_amt"));
		}
	}			
	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "111811";
	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = oaLocCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = "KRW";
	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = tempAmt*0.1;
	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = form.csr_desc.value+" 매입 10% 일반";		
	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = vndrSeq;
	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4000";	
}

/**
 * 과세, USD
 */
function fnTax4(){	
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;
	var oaLocCd = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
	var vndrSeq = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
	var currCd = comboObjects[0].Code;	
	var hiddenRow = 0;
			
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "951111" ){
			hiddenRow = i;
			sheetObj.CellValue2(i, slp_prefix + "ibflag") = "D";								
		}
	}	
	if(hiddenRow > 1){
		sheetObj.RowHidden(hiddenRow) = true;
	}
			
	var row = sheetObj.DataInsert(-1);	
	var tempAmt = 0;
		
	
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") != "951111" ){
			tempAmt = tempAmt + Number(sheetObj.CellValue(i, slp_prefix + "csr_amt"));			
		}
	}	
			
	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "951111";
	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = oaLocCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = currCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = tempAmt*0.1;
	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = form.csr_desc.value+" 매입 10% 일반";		
	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = vndrSeq;
	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4000";	
}

///**
// * 과세, USD
// */
//function fnTax42(){	
//	var sheetObj = sheetObjects[0];
//	var lastRow = sheetObj.LastRow;			
//	var tempAmt = 0;
//	var xrchRt = form.usd_locl_xch_rt.value;
//	var desc = "";
//	var currCd = comboObjects[0].Code;	
//	var tax_amt = sheetObjects[1].CellValue(1,"tax_tax_amt");		
//	
//	// tax_tax_pl_cd 1:영세, 2:과세	
//	// 과세, USD만 해당.
///*	
//	100010	CD01745	1	TAX
//	100020	CD01745	4	CI
//	100030	CD01745	5	ETC
//*/
//	
//	if(form.evid_tp_cd.value != '1'){
//		return;
//	} 
//		
//	if(currCd == "KRW"){
//		return;
//	}else{
//		if(sheetObjects[1].CellValue(1, "tax_tax_pl_cd") == '1'){	
//			return;
//		}
//	}
//	
//	for ( var i = 1; i <= lastRow; i++) {		
//		if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "951111"){
//			tempAmt = tempAmt + Number(sheetObj.CellValue(i, slp_prefix + "csr_amt"));
//		}
//	}		
//	
//	var row = sheetObj.DataInsert(-1);		
//	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "951111";
//	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
//	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = "KRW";
//	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = Math.round(tempAmt*xrchRt)*-1;
//	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = "매입 10% 일반-환대체";
//	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
//	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4000";	
//	
//	row = sheetObj.DataInsert(-1);		
//	
//	if(Math.round(tempAmt*xrchRt)-tax_amt < 0){
//		desc = "외환차익";
//		sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "421211";	
//	}else{
//		desc = "외환차손";		
//		sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "580111";		
//	}
//	
//	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
//	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = "KRW";
//				
//	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = Math.round(tempAmt*xrchRt)-tax_amt
//	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = "매입 10% 일반-"+desc;	
//	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");
//	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4001";	
//
//	row = sheetObj.DataInsert(-1);		
//	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "111811";
//	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
//	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = "KRW";
//	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = sheetObj.CellValue(row-2, slp_prefix + "csr_amt")*-1;
//	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = "매입 10% 일반-"+desc;	
//	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
//	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4002";	
//
//	row = sheetObj.DataInsert(-1);		
//	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "111811";
//	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");	
//	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = "KRW";
//	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = (Math.round(tempAmt*xrchRt)-tax_amt)*-1
//	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = "매입 10% 일반-"+desc;
//	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = sheetObj.CellValue(lastRow, slp_prefix + "vndr_seq");	
//	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "4003";	
//			
//	sheetObjects[1].CellValue2(1, "tax_ibflag") = "I";
//}


/**
 * ASA 추가
 */
function fnAddAsa(){	
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;
	var currCd = comboObjects[0].Code;	
	var hiddenRow = 0;
	var sw = 1;				
	
	if(form.so_if_cd.value != "O"){
		sw = 2;
	}

	for ( var i2 = 1; i2 <= lastRow; i2++) {		
		if(sheetObj.CellValue(i2, slp_prefix + "ibflag") != "D"){		
			if(sheetObj.CellValue(i2, slp_prefix + "acct_cd") == "954113"){
				sw = 2;
			}
		}
	}	
	
	if(sw == 2){
		return;
	}
	
	
	var row = sheetObj.DataInsert(-1);	
	var tempAmt = 0;
			
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "ibflag") != "D"){		
			tempAmt = tempAmt + Number(sheetObj.CellValue(i, slp_prefix + "csr_amt"));
		}
	}	
			
	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "954113";
	sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");
	sheetObj.CellValue2(row, slp_prefix + "to_inv_no") = sheetObj.CellValue(lastRow, slp_prefix + "to_inv_no");		
	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = currCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = tempAmt*-1;
	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = form.csr_desc.value;
	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = form.vndr_seq.value;
	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "3000";	
	form.cr_amt.value = 0;
	
	edtAcctCell();
}


/**
 * MSA 추가
 */
function fnAddMsa(){	
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;
	var currCd = comboObjects[0].Code;	
	var hiddenRow = 0;
	var sw = 1;				
	
	if(form.slp_ofc_cd.value != "PUSMOV"){
		return;
	}

	for ( var i2 = 1; i2 <= lastRow; i2++) {		
		if(sheetObj.CellValue(i2, slp_prefix + "ibflag") != "D"){		
			if(sheetObj.CellValue(i2, slp_prefix + "acct_cd") == "110911"){
				sw = 2;
			}
		}
	}	
	
	if(sw == 2){
		return;
	}
	
	if(lastRow == 0){
		return;
	}
	
	
	var row = sheetObj.DataInsert(-1);	
	var tempAmt = 0;
			
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "ibflag") != "D"){		
			tempAmt = tempAmt + Number(sheetObj.CellValue(i, slp_prefix + "csr_amt"));
		}
	}	
			
	sheetObj.CellValue2(row, slp_prefix + "acct_cd") = "110911";
	//sheetObj.CellValue2(row, slp_prefix + "oa_loc_cd") = sheetObj.CellValue(lastRow, slp_prefix + "oa_loc_cd");
	sheetObj.CellValue2(row, slp_prefix + "to_inv_no") = sheetObj.CellValue(lastRow, slp_prefix + "to_inv_no");		
	sheetObj.CellValue2(row, slp_prefix + "csr_curr_cd") = currCd;
	sheetObj.CellValue2(row, slp_prefix + "csr_amt") = tempAmt*-1;
	sheetObj.CellValue2(row, slp_prefix + "csr_desc") = "Agent Account Receivable";
	sheetObj.CellValue2(row, slp_prefix + "vndr_seq") = form.vndr_seq.value;
	sheetObj.CellValue2(row, slp_prefix + "slp_seq_no") = "3000";	
	form.csr_amt.value = 0;
	form.cr_amt.value = 0;
	form.dr_amt.value = 0;
	
	edtAcctCell();
}


/**
 * 계정 체크
 */
function fnAccountChk(){ 	
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;
	var acctCnt1 = 0;
	var acctCnt2 = 0;
	var acctCnt3 = 0;	
	
	for ( var i = 1; i <= lastRow; i++) {		
		if(sheetObj.CellValue(i, slp_prefix + "ibflag") != "D"){
			if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "111811"){
				acctCnt1 = acctCnt1 + 1;
			}
			if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "951111"){
				acctCnt2 = acctCnt2 + 1;			
			}
			if(sheetObj.CellValue(i, slp_prefix + "acct_cd") == "954113"){
				acctCnt3 = acctCnt3 + 1;			
			}
		}
	}	
	
	if(acctCnt1 > 1){
		alert("Account Code('111811') must be entered only");		
		return false;
	}
	
	if(acctCnt2 > 1){
		alert("Account Code('951111') must be entered only");		
		return false;
	}

	if(acctCnt3 > 1){
		alert("Account Code('954113') must be entered only");		
		return false;
	}

	return true;
}

/**
 * Save 여부 결정 <br>
 * @return {boolean} okYn 저장 여부
 **/
function saveConfirm() {
	
	var cnt1 = sheetObjects[0].RowCount("I");
	var cnt2 = sheetObjects[0].RowCount("U");
	var cnt3 = sheetObjects[0].RowCount("D");
	
	if(chgOwner()){	
		if(cnt1+cnt2+cnt3 == 0){
			ComShowMessage(ComGetMsg('FMS01169'));
			return false;
		}
	}	
	if(!fnAccountChk()){
		return false; 
	}
	
	var okYn = ComShowConfirm(ComGetMsg("FMS00017"));
	return okYn;
}

/**
 * Submit 여부 결정 <br>
 * @return {boolean} okYn 저장 여부
 **/
function submitConfirm() {
	
	var cnt1 = sheetObjects[0].RowCount("I");
	var cnt2 = sheetObjects[0].RowCount("U");
	var cnt3 = sheetObjects[0].RowCount("D");
	
	if(!chgOwner()){
		alert("The 'Head' information was changed. Please save first and submit.");		
		return false;
	}	
	
	if(cnt1+cnt2+cnt3 > 0){
		alert("The 'Line' information was changed. Please save first and submit.");
		return false;
	}

	var cntTax1 = sheetObjects[1].RowCount("I");
	var cntTax2 = sheetObjects[1].RowCount("U");
	var cntTax3 = sheetObjects[1].RowCount("D");	

	if(cntTax1+cntTax2+cntTax3 > 0){
		alert("The 'Tax' information was changed. Please save first and submit");
		return false;
	}
	
	var cntTaxDtl1 = sheetObjects[2].RowCount("I");
	var cntTaxDtl2 = sheetObjects[2].RowCount("U");
	var cntTaxDtl3 = sheetObjects[2].RowCount("D");	
	
	if(cntTaxDtl1+cntTaxDtl2+cntTaxDtl3 > 0){
		alert("The 'Tax' information was changed. Please save first and submit");
		return false;
	}
	
	if(!fnAccountChk()){
		return false; 
	}
			
	var okYn = ComShowConfirm("Do you want to submit?");
	return okYn;
}

/*
 *  Header부분 변경 여부 체크
 */
function chgOwner(){
	var sheetObj = sheetObjects[3];	
	
	var vndr_seq 	= form.vndr_seq.value;
	var amount       = comboObjects[0].Code;
	
	var tmp_csr_amt  = ComReplaceStr(form.csr_amt.value, ',', '');
	var csr_amt 		= Number(tmp_csr_amt);
	
	var oa_inv_dt		= ComReplaceStr(form.oa_inv_dt.value,"-","");
	var eff_dt			= ComReplaceStr(form.eff_dt.value,"-","");
	var rqst_dt		= ComReplaceStr(form.rqst_dt.value,"-","");
	var evid_tp_cd	= form.evid_tp_cd.value;
	var csr_desc		= form.csr_desc.value;
	
	var vndr_seq2 	= form.org_vndr_seq.value;
	var amount2     = sheetObj.CellValue(1, "csr_curr_cd");
	var csr_amt2 	= Number(sheetObj.CellValue(1, "csr_amt"));
	var oa_inv_dt2	= sheetObj.CellValue(1, "oa_inv_dt");
	var eff_dt2			= sheetObj.CellValue(1, "eff_dt");
	var rqst_dt2		= sheetObj.CellValue(1, "rqst_dt");
	var evid_tp_cd2	= sheetObj.CellValue(1, "evid_tp_cd");
	var csr_desc2	= sheetObj.CellValue(1, "csr_desc");
	
		
	if(sheetObj.RowCount == 0){
		return true;
	}
		
	if(vndr_seq != vndr_seq2 ) { 
		return false; 
	}
	if(amount != amount2 ){
		return false; 
	}
	if(csr_amt != csr_amt2 ) {
		return false; 
	}
	if(oa_inv_dt != oa_inv_dt2 ) {
		return false; 
	}
	if(eff_dt != eff_dt2 ) {
		return false; 
	}
	if(rqst_dt != rqst_dt2 ) {
		return false; 
	}
	if(evid_tp_cd != evid_tp_cd2 ) {
		return false; 
	}
	if(csr_desc != csr_desc2 ) {
		return false; 
	}	
	
	return true;
}

/*
 *  CSR Amount 마이너스 금액 체크
 */
function chkCsrAmt(){	
	var popup = document.form.popup.value;
	var tmp_csr_amt  = ComReplaceStr(form.csr_amt.value, ',', '');
	
	if(popup != "yes") {
		if(tmp_csr_amt < 0){
			alert("Do not insert minus amount directly.\nPlease Use 'cancel csr' or 'multil cancellation for O/A'");
			document.form.csr_amt.value = '';
			return false;
		}
	}	
	return true;
}

/*
 *  Accuont Code Edit 세팅
 *  <국내>
	   Accout Code 칼럼 수정 못하게 보완
	    951111 (영세/과세 인 경우) VVD 칼럼 입력 못하게 비활성화 처리
	   asa없음

	<해외>
	   962111, 111821, 211691는 수동 입력 가능하고
	        ASA 계정은 버튼으로 자동 입력(수정 불가)하고 수동 입력이 되지 않도록 보완
	       111821, 211691 시에 VVD 칼럼 입력 못하게 비활성화 처리

	<메시지 팝업 창>
	  해외 : Use  account code only 962111, 111821, 211691 
 */
function edtAcctCell(){
	var sheetObj = sheetObjects[0];	
	var lastRow = sheetObj.LastRow;	
	
	for ( var row = 1; row <= lastRow; row++) {
		if(form.cnt_cd.value == "KR"){
			sheetObj.CellEditable(row, slp_prefix + "acct_cd") = false;
						
			if(sheetObj.CellValue(row, slp_prefix + "acct_cd") == "111811" ||
					sheetObj.CellValue(row, slp_prefix + "acct_cd") == "951111" ||
					sheetObj.CellValue(row, slp_prefix + "acct_cd") == "110911"
					){							
				sheetObj.CellEditable(row, slp_prefix + "vvd_cd") = false;				
			}
		}else{
			sheetObj.CellEditable(row, slp_prefix + "acct_cd") = true;

			if(sheetObj.CellValue(row, slp_prefix + "acct_cd") == "954113"){			// asa계정
				sheetObj.CellEditable(row, slp_prefix + "acct_cd") = false;				
				sheetObj.CellEditable(row, slp_prefix + "vvd_cd") = false;								
			}			
			
			if(sheetObj.CellValue(row, slp_prefix + "acct_cd") == "111821" ||
					sheetObj.CellValue(row, slp_prefix + "acct_cd") == "211691"
					){
				sheetObj.CellEditable(row, slp_prefix + "vvd_cd") = false;		
				sheetObj.CellValue(row, slp_prefix + "vvd_cd") = "";
				sheetObj.CellValue(row, slp_prefix + "oa_loc_cd") = "";
				sheetObj.CellValue(row, slp_prefix + "vps_etd_dt") = "";
			}						
		}				
	}		
}

function setMakeTaxEvidence(taxAmt) {
}
/* 개발자 작업 끝 */