/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0020.js
 *@FileTitle : AR CSR Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.08.06 박희동
 * 1.0 Creation 
* -------------------------------------------------------------------------------
* History
* 2012.02.28 조병연 [CHM-20121640001][ALPS JOO] Account Month가 Closing된 후 Save 및 Delete 기능 비활성화 
* - Account Month가 Closing된 이후에는 Data 생성 및 삭제 기능들이 비활성화되도록 Logic 추가
* - 현재 AP Closing Time을 기준으로 하는것을 AR Closing Time으로 변경 (쿼리 변경)
* - Save, Delete 버튼 비활성화
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
 * @class FNS_JOO_0020 : FNS_JOO_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0020() {
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

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

var prefix = "sheet1_";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btns_back":
			if (formObj.acct_yrmon.value != "") {
				formObj.acct_yrmon.value = ComGetDateAdd(
						formObj.acct_yrmon.value + "-01", "M", -1)
						.substring(0, 7);
			}
			//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
			acct_yrmon_blur();
			break;

		case "btns_next":
			if (formObj.acct_yrmon.value != "") {
				formObj.acct_yrmon.value = ComGetDateAdd(
						formObj.acct_yrmon.value + "-01", "M", 1).substring(
						0, 7);
			}
			//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
			acct_yrmon_blur();
			break;

		case "btn_iss":
			var cal = new ComCalendar();
			cal.select(formObj.slp_iss_dt, 'yyyy-MM-dd');
			break;

		case "btn_eff":
			if(form.csr_no.value != "") return; 
			var cal = new ComCalendar();
			cal.select(formObj.eff_dt, 'yyyy-MM-dd');
			break;

		case "btn_rqst":
			if(form.csr_no.value != "") return; 
			var cal = new ComCalendar();
			cal.select(formObj.rqst_dt, 'yyyy-MM-dd');
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;

		case "btn_new":
			UF_resetCondition();
			UF_resetBody();
			UF_resetSheets();
			UF_enableInput();			
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;

		case "btn_print":
			var csrNo = formObj.csr_no.value;
			if (csrNo.length < 19){
				ComShowCodeMessage("JOO00074");
				return;
			}
            rdOpen( formObj);
			break;
						
		case "apro_step_btn" :
			if(form.csr_no.value != "") return; 
    	    var v_ofc_cd = formObj.slp_ofc_cd.value;
    	    var v_sub_sys_cd = "JOO";
            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
				ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
			break;
						
		case "btn_gwcl":
			if (formObj.csr_no.value==undefined ||
					formObj.csr_no.value==null ||
					formObj.csr_no.value.trim()==''){
				    ComShowCodeMessage("JOO00211");		// CSR No.가 없습니다.
					return false;
			}				

			var param = "";
			if(formObj.apro_flg.value == 'Y' && formObj.cxl_flg.value =='N'){	
				param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"N";					
			}else{
				param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"Y";					
			}
							
//			ComOpenPopup("/hanjin/FNS_JOO_0099.do"+param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
			window.open("/hanjin/FNS_JOO_0099.do"+param, "", "status=no, width=835, height=380, resizable=no, scrollbars=no");			
			break;				
			
		case "btn_attach":
			if (formObj.csr_no.value==undefined ||
					formObj.csr_no.value==null ||
					formObj.csr_no.value.trim()==''){
			    	ComShowCodeMessage("JOO00211");		// CSR No.가 없습니다.
					return false;
			}				
			
			var param = "";
			if(formObj.apro_flg.value == 'Y' && formObj.cxl_flg.value =='N'){				
				param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"N";
			}else{
				param = "?csr_no="+formObj.csr_no.value+"&edit_able="+"Y";				
			}
			
			ComOpenPopup("/hanjin/FNS_JOO_0098.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
			break;				
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

function initRdConfig(rdObject){
    var Rdviewer = rdObject ;
    Rdviewer.AutoAdjust = true;
    Rdviewer.ViewShowMode(0);
    Rdviewer.SetBackgroundColor(128,128,128);
    Rdviewer.SetPageLineColor(128,128,128);
}

function rdOpen( formObj){
 
    //var Rdviewer = rdObject ;

    if( !setQueryStr() ){
        return;
    }

    var rdParam = '/rp '+queryStr;

    var strPath   = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_0021.mrd";
    //SINRS면 결재라인이 다르다.
    if (gOfcCd == "SINRS" || gOfcCd == "SINRSS"){
    	strPath   = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationconsultation/report/FNS_JOO_1021.mrd";
    }

    formObj.com_mrdPath.value = strPath;
    formObj.com_mrdArguments.value = rdParam;
    ComOpenRDPopup();
}

function setQueryStr(){
    var formObj = document.form;
    queryStr = "";
    
    queryStr += " ["+formObj.csr_no.value+"]";
    return true;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur', formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate', 'obj_focus', formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', formObj);

	axon_event.addListener('keypress', 'acct_yrmon_keypress', 'acct_yrmon');
	axon_event.addListener('keypress', 'slp_iss_dt_keypress', 'slp_iss_dt');
	axon_event.addListener('keypress', 'eff_dt_keypress', 'eff_dt');
	axon_event.addListener('keypress', 'rqst_dt_keypress', 'rqst_dt');
	axon_event.addListener('beforedeactivate', 'eff_dt_blur', 'eff_dt');
	axon_event.addListener('beforedeactivate', 'acct_yrmon_blur', 'acct_yrmon');
    
	formObj.acct_yrmon.focus();
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur() {
	var formObj = document.form;	
	ComChkObjValid(event.srcElement);
	//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);

}

function obj_focus() {
	ComClearSeparator(event.srcElement);
}

function obj_keypress() {
	var src = window.event.srcElement.getAttribute("name")
}

function form_keyup() {
	ComKeyEnter('lengthnextfocus');
}

function acct_yrmon_keypress() {
	ComKeyOnlyNumber(this, '');
}

function acct_yrmon_blur(){
	var formObj = document.form;
	formObj.jo_crr_cd.Index2=-1;
	formObj.stl_cmb_seq.Index2=-1;
	formObj.stl_cmb_seq.RemoveAll();
	formObj.csr_no.value = "";
	UF_resetBody();
	UF_resetSheets();
}

function slp_iss_dt_keypress() {
	ComKeyOnlyNumber(this, '');
}

function eff_dt_keypress() { 
	ComKeyOnlyNumber(this, '');
}

function rqst_dt_keypress() {	
	ComKeyOnlyNumber(this, '');
}

function eff_dt_blur() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if (ComTrim(formObj.slp_ofc_cd.value) == ""){
		return
	}
	
	if (ComIsDate(formObj.eff_dt.value)) {
		doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
	}
}

function obj_onclick() {
	var src = window.event.srcElement.getAttribute("name")
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "STS|acct_yrmon|jo_crr_cd|stl_cmb_seq|cust_vndr_seq|cust_vndr_cnt_cd|cust_vndr_kor_nm|cust_vndr_eng_nm|cust_vndr_rgst_no|"
					+ "slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_iss_dt|slp_ser_no|csr_desc|locl_curr_cd|stl_locl_amt|evid_tp_cd|"
					+ "csr_tp_cd|eff_dt|rqst_dt|rev_yrmon|vsl_cd|skd_voy_no|skd_dir_cd|rev_dir_cd|rlane_cd|"
					+ "dr_ctr_cd|dr_loc_cd|dr_acct_cd|cr_ctr_cd|cr_loc_cd|cr_acct_cd|slp_desc|vvd_cxl_flg|dr_cr_cd|"
					+ "key_no|issuer_id|re_divr_cd|tot_amount|slp_iss_ofc_cd|csr_offst_no|slp_iss_rgn_cd|slp_iss_inter_co_cd|jo_stl_itm_cd|bsa_qty|bsa_slt_prc|chk_ctr_cd|chk_loc_cd|stl_vvd_seq|stl_seq|fin_jo_stl_itm_cd|apro_step|apro_flg|cxl_flg";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtStatus  , 60, daCenter,  true, prefix+"ibflag"             ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"acct_yrmon"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"jo_crr_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"stl_cmb_seq"        ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cust_vndr_seq"      ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cust_vndr_cnt_cd"   ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cust_vndr_kor_nm"   ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cust_vndr_eng_nm"   ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cust_vndr_rgst_no"  ,false,"",dfNone);

            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_tp_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_func_cd"        ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_ofc_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_iss_dt"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_ser_no"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"csr_desc"           ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"locl_curr_cd"       ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtAutoSum , 60, daCenter,  true, prefix+"stl_locl_amt"       ,false,"",dfNullFloat  ,2);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"evid_tp_cd"         ,false,"",dfNone);

            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"csr_tp_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"eff_dt"             ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"rqst_dt"            ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"rev_yrmon"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"vsl_cd"             ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"skd_voy_no"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"skd_dir_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"rev_dir_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"rlane_cd"           ,false,"",dfNone);
            
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"dr_ctr_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"dr_loc_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"dr_acct_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cr_ctr_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cr_loc_cd"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cr_acct_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_desc"           ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"vvd_cxl_flg"        ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"dr_cr_cd"           ,false,"",dfNone);
            
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"key_no"             ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"issuer_id"          ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"re_divr_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"tot_amount"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_iss_ofc_cd"     ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_iss_rgn_cd"     ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"slp_iss_inter_co_cd",false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"csr_offst_no"       ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"jo_stl_itm_cd"      ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"bsa_qty"            ,false,"",dfNone);

            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"bsa_slt_prc"        ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"chk_ctr_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"chk_loc_cd"         ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"stl_vvd_seq"        ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"stl_seq"          	     ,false,"",dfNone);
            
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"fin_jo_stl_itm_cd"  ,false,"",dfNone);            
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"apro_step"           ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"apro_flg"   			 ,false,"",dfNone);
            InitDataProperty(0, cnt++ , dtData    , 60, daCenter,  true, prefix+"cxl_flg"   				,false,"",dfNone);            
                        
		}
		break;
	case 2:      //sheet3 init
		with (sheetObj) {
            // 높이 설정
            style.height = 0;
            //전체 너비 설정
        	SheetWidth = 665;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 5, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(5, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, true, false, false, false)

            var HeadTitle = "|";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            
            InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,  "ibflag");
        }
        break;		
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {

	if(!(sAction == IBSAVE && formObj.csr_no.value != "")){					
		if (!validateForm(sheetObj, formObj, sAction)){
			return;
		}
	}
	
	if(formObj.apro_flg.value == 'Y' && formObj.cxl_flg.value =='N'){
		if (!validateForm(sheetObj, formObj, sAction)){
			return;
		}			
	}
	
	switch (sAction) {
	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("FNS_JOO_0020GS.do", FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(prefix));		
		break;

	case IBROWSEARCH: //EFF_DT Close여부 조회 (EFF_DT ON_BLUR)
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0020GS.do",FormQueryString(formObj));
		var closFlg = ComGetEtcData(sXml, "clos_yn");
		var effDt = ComGetEtcData(sXml, "eff_dt");
		var oldEffDt = formObj.eff_dt.value;

		if (closFlg=="C"){
			//마감이 되었고 이후의 최초 open된 것이 없다면
			if (ComTrim(effDt) == ""){
				ComShowCodeMessage("JOO00139", oldEffDt.substring(0,6));
				formObj.eff_dt.value = "";
				formObj.eff_dt.focus();
				return;					
			}
			
			//마감이 되었고 user가 계속가고자 한다면 익월1일자로 setting
			if (ComShowCodeConfirm('JOO00107',oldEffDt, effDt)){
				formObj.eff_dt.value = effDt;
			}else{
				formObj.eff_dt.value = "";
				formObj.eff_dt.focus();
			}
		//해당월도 마감전이고 이전월도 마감전이라면 
		}else if (closFlg=="X"){
			if (!ComShowCodeConfirm("JOO00140")){
				formObj.eff_dt.value = "";
				formObj.eff_dt.focus();
			}
		//데이터가 아예 존재하지 않는 경우
		}else if (closFlg=="E"){
			ComShowCodeMessage("JOO00125", oldEffDt.substring(0,6));
			formObj.eff_dt.value = "";
			formObj.eff_dt.focus();
		}
		break;

	case IBSAVE: //저장
		// CSR No.가 있는 경우 GW Contract Link만 저장 한다.
		if(formObj.csr_no.value != ""){
			if(formObj.agmt_doc_no.value == ""){		// GW Contract Link를 입력 해 주세요.
				return false;
			}else{
				sheetObjects[0].RemoveAll();					
                sheetObjects[0].DataInsert();		
									
				formObj.f_cmd.value = MULTI01;				
				formObj.ibflag.value = "U";
				
				var aryPrefix = new Array("sheet1_");
				
				ComOpenWait(true);
				var sXml = sheetObjects[0].GetSaveXml("FNS_JOO_0017GS.do", ComGetSaveString(sheetObjects)+"&"+FormQueryString(formObj)+"&"+ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);										
			}
		}else{				
			UF_setInputToSheet();
			if (!ComShowCodeConfirm("JOO00046")) {
				return false;
			}
			formObj.f_cmd.value = MULTI;
			
			var SaveStr = ComGetSaveString(sheetObj);
	
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0020GS.do", 
					SaveStr + "&"+ FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
	
			var csrNo = ComGetEtcData(sXml, "csr_no");
			
			if (csrNo == null || csrNo == undefined){
				formObj.csr_no.value = "";
				ComShowMessage("Fail to create AR CSR");
			}else if (csrNo.length >= 19){
				formObj.csr_no.value = csrNo;
				ComShowMessage("Sucesss to create AR CSR ["+csrNo+"]");
			}
		}
		break;

		
	case IBSEARCH_ASYNC10: //마감여부 조회
		formObj.f_cmd.value = SEARCH10;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0020GS.do", FormQueryString(formObj));
		
		if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			gClzYn = ComGetEtcData(sXml,"clz_yn"); 
			if (gClzYn == "C"){
				//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
				JooSetBtnClass("S", false);		// Save
				sheetObjects[0].Editable = false;
				
			//Open상태면 Authority에 따라 Button을 활성화, 비활성화 한다.
			}else{
				JooSetBtnClass("S", true);		// Save
				sheetObjects[0].Editable = true;
			}
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
	var formObj = document.form

	switch (comboNo) {
	case 1:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2,0);//영문대문자만 입력가능
			MaxLength=3
		}
		var comboItems = gCrrCombo.split("|");
		addComboItem(comboObj, comboItems);
		break;

	case 2:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left|left");
			SetColWidth("30|150");
			DropHeight = 160;
			ValidChar(2,0);//영문대문자만 입력가능
		}
		break;
	}
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj, formObj, sAction, sComboObj, sComboKey) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH: //TRADE
		//if(validateForm(sheetObj,formObj,sAction))
		if (sComboObj.id == "stl_cmb_seq") {
			//콤보필드를 초기화시킨다.
			sComboObj.RemoveAll();

			formObj.f_cmd.value = SEARCHLIST18;
			formObj.code.value = formObj.re_divr_cd.value;
			formObj.super_cd1.value = formObj.jo_crr_cd.Code;
			formObj.super_cd2.value = formObj.acct_yrmon.value;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

			//Combined No.
			var codeList = ComGetEtcData(sXml, "combined_no").split("|");
			var nameList = ComGetEtcData(sXml, "slip_no").split("|");
			for ( var i = 0; i < codeList.length; i++) {
				comboObjects[1].InsertItem(i, codeList[i]+"|"+nameList[i], codeList[i]);
			}
		}

		break;
	}
}

function UF_resetSheets() {
	sheetObjects[0].RemoveAll();
}

function jo_crr_cd_OnChange(comboObj, idx_cd, text) {
	var formObj = document.form;
	
	comboObjects[1].Index2 = -1;
	comboObjects[1].RemoveAll();

	formObj.csr_no.value = "";
	UF_resetBody();
	UF_resetSheets();
}

function stl_cmb_seq_OnFocus(comboObj) {
	var formObj = document.form;
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH,	comboObj, "stl_cmb_seq");
		comboObj.Enable = true;	
	}
}

function stl_cmb_seq_OnChange(comboObj, idx_cd, text) {
	var formObj = document.form;
	formObj.csr_no.value = "";
	UF_resetBody();
	UF_resetSheets();
	if (formObj.acct_yrmon.value.length != 0 && formObj.jo_crr_cd.Code.length == 3) {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //조회
		if (formObj.acct_yrmon.value.length == 0) {
			ComShowCodeMessage('JOO00033');
			formObj.acct_yrmon.focus();
			return false;
		}
		if (formObj.jo_crr_cd.index == -1) {
			ComShowCodeMessage('JOO00008');
			formObj.jo_crr_cd.focus();
			return false;
		}
		if (formObj.stl_cmb_seq.Index == -1) {
			ComShowCodeMessage('JOO00096');
			formObj.stl_cmb_seq.focus();
			return false;
		}
		break;

	case IBSAVE: //저장
		if (formObj.acct_yrmon.value.length == 0) {
			ComShowCodeMessage('JOO00033');
			formObj.acct_yrmon.focus();
			return false;
		}
		if (formObj.jo_crr_cd.Index == -1) {
			ComShowCodeMessage('JOO00008');
			formObj.jo_crr_cd.focus();
			return false;
		}

		if (formObj.stl_cmb_seq.Index == -1) {
			ComShowCodeMessage('JOO00096');
			formObj.stl_cmb_seq.focus();
			return false;
		}

		//CSR 번호가 있으면 다시 생성되지 못하게 한다.
		if (ComTrim(formObj.csr_no.value).length >= 19){
			ComShowCodeMessage('JOO00100');
			return false;
		}
		
		if (sheetObjects[0].DataRows < 1) {
			ComShowCodeMessage('JOO00036');
			return false;
		}

		if (formObj.cust_vndr_seq.value.length == 0){
			ComShowCodeMessage('JOO00036');
			return false;
		}

		if (formObj.csr_desc.value.length == 0) {
			ComShowCodeMessage('JOO00097');
			formObj.csr_desc.focus();
			return false;
		}

		if (formObj.eff_dt.value == "") {
			ComShowCodeMessage('JOO00101');
			formObj.eff_dt.focus();
			return false;
		}

		if (formObj.rqst_dt.value == "") {
			ComShowCodeMessage('JOO00102');
			formObj.rqst_dt.focus();
			return false;
		}

		//2010.03.04 박효숙 차장 Effective Date는 Due Date보다 이전이어야 한다.
		var eff  = Number(ComReplaceStr(formObj.eff_dt.value,"-",""));
		var rqst = Number(ComReplaceStr(formObj.rqst_dt.value,"-",""));
		
		if (eff > rqst){
			ComShowCodeMessage("JOO00176");
			return false;
		}
		
		var revYrmon = "";
		var canceledVVD = "";
		var vvd = "";
		for ( var inx = sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++) {
			revYrmon = sheetObj.CellValue(inx, prefix + "vvd_cxl_flg");
			if (revYrmon == "Y") {
				vvd = sheetObj.CellValue(inx, prefix + "vsl_cd");
				vvd += sheetObj.CellValue(inx, prefix + "skd_voy_no");
				vvd += sheetObj.CellValue(inx, prefix + "skd_dir_cd");
				vvd += sheetObj.CellValue(inx, prefix + "rev_dir_cd");
				canceledVVD += vvd + "\n";
			}
		}

		if (canceledVVD != ""){
			ComShowCodeMessage("JOO00216", canceledVVD);
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
 * sheet내용을 input box에 표현한다.
 * @return
 */
function UF_setSheetToInput() {
	var form = document.form;
	var sheet1 = sheetObjects[0];
	var row = sheet1.HeaderRows;
	form.cust_vndr_seq.value     = sheet1.CellValue(row, prefix+ "cust_vndr_seq");
	form.cust_vndr_cnt_cd.value  = sheet1.CellValue(row, prefix+ "cust_vndr_cnt_cd");
	form.cust_vndr_kor_nm.value  = sheet1.CellValue(row, prefix+ "cust_vndr_kor_nm");
	form.cust_vndr_eng_nm.value  = sheet1.CellValue(row, prefix+ "cust_vndr_eng_nm");
	form.cust_vndr_rgst_no.value = sheet1.CellValue(row, prefix+ "cust_vndr_rgst_no");
	form.locl_curr_cd.value      = sheet1.CellValue(row, prefix + "locl_curr_cd");
	form.stl_locl_amt.value      = sheet1.SumText(0, prefix + "stl_locl_amt");
	//form.eff_dt.value            = sheet1.CellValue(row, prefix+"eff_dt")           ;
	//form.rqst_dt.value           = sheet1.CellValue(row, prefix+"rqst_dt")          ;
	
	if(form.csr_no.value != ""){
		form.csr_desc.value       = sheet1.CellValue(row, prefix+"csr_desc");		
		form.eff_dt.value            = sheet1.CellValue(row, prefix+"eff_dt");
		form.rqst_dt.value          = sheet1.CellValue(row, prefix+"rqst_dt");		
		
		ComBtnDisable("btn_save");
		
		form.csr_desc.readOnly = true;
		form.csr_desc.className="input2";
		form.eff_dt.readOnly = true;
		form.eff_dt.className="input2";		
		form.rqst_dt.readOnly = true;
		form.rqst_dt.className="input2";		
		form.btn_eff.disabled = true;
		form.btn_rqst.disabled = true;
	}else{
		form.csr_desc.value       = "";		
		form.eff_dt.value            = "";
		form.rqst_dt.value          = "";			
		
		ComBtnEnable("btn_save");
		
		form.csr_desc.readOnly = false;
		form.csr_desc.className="input1";
		form.eff_dt.readOnly = false;
		form.eff_dt.className="input1";		
		form.rqst_dt.readOnly = false;
		form.rqst_dt.className="input1";		
		form.btn_eff.disabled = false;
		form.btn_rqst.disabled = false;		
	}	
	
	form.slp_iss_dt.focus();
}

/**
 * input box내용을 sheet에 setting한다.
 * @return
 */
function UF_setInputToSheet() {
	var form = document.form;
	var sheet1 = sheetObjects[0];

	for ( var row = sheet1.HeaderRows; row <= sheet1.LastRow; row++) {
		sheet1.CellValue2(row, prefix + "slp_tp_cd"  ) = form.slp_tp_cd.value;
		sheet1.CellValue2(row, prefix + "slp_func_cd") = form.slp_func_cd.value;
		sheet1.CellValue2(row, prefix + "slp_iss_ofc_cd") = form.slp_iss_ofc_cd.value;
		sheet1.CellValue2(row, prefix + "slp_iss_dt" ) = ComReplaceStr(form.slp_iss_dt.value, "-", "");
		sheet1.CellValue2(row, prefix + "issuer_id"  ) = form.issuer_id.value;
		sheet1.CellValue2(row, prefix + "csr_desc"   ) = form.csr_desc.value;
		sheet1.CellValue2(row, prefix + "re_divr_cd" ) = form.re_divr_cd.value;
		//취소되지 않은 VVD는 입력한 EFF.DT를 넣고
		//취소된 VVD는 -1일을 해준 조회된 EFF.DT를 그대로 사용한다.
		if (sheet1.Cellvalue(row, prefix + "vvd_cxl_flg") == "N") {
			sheet1.CellValue2(row, prefix + "eff_dt") = ComReplaceStr(form.eff_dt.value, "-", "");
		}
		sheet1.CellValue2(row, prefix + "rqst_dt"   ) = ComReplaceStr(form.rqst_dt.value, "-", "");
		sheet1.CellValue2(row, prefix + "tot_amount") = ComReplaceStr(form.stl_locl_amt.value, ",", "");
		sheet1.CellValue2(row, prefix + "apro_step" ) = form.apro_step.value;
	}
}

/**
 * 전체 reset
 * 
 * @return
 */
function UF_resetBody() {
	var form = document.form;
	form.cust_vndr_seq.value     = "";
	form.cust_vndr_cnt_cd.value  = "";
	form.cust_vndr_kor_nm.value  = "";
	form.cust_vndr_eng_nm.value  = "";
	form.cust_vndr_rgst_no.value = "";
	form.slp_iss_dt.value        = gYYYYMMDD;
	form.csr_desc.value          = "";
	form.locl_curr_cd.value      = "";
	form.stl_locl_amt.value      = "";
	form.eff_dt.value            = "";
	form.rqst_dt.value           = "";
}

function UF_resetCondition(){
	var form = document.form;
	form.acct_yrmon.value        = gYYYYMM;
	form.jo_crr_cd.Index2        = -1;
	form.stl_cmb_seq.RemoveAll();
	form.csr_no.value            = "";
}
/**
 * Sheet1 의 Search가 끝난 후
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var row = sheetObj.HeaderRows;

	var rowCnt = sheetObj.RowCount;
	
	if (rowCnt == 0){
		ComShowCodeMessage("JOO00000");
		return;
	}
	
	//전표번호가 이미 생성된 거면 Already Settlemented.라는 메시지와 함께 reset한다.
	var slpSerNo = sheetObj.CellValue(row, prefix+"slp_ser_no");
	
	/*GW문서, 승인여부는 모든 경우에 해당 */
	formObj.apro_flg.value      			 = sheetObj.CellValue(row, prefix+"apro_flg");
	formObj.cxl_flg.value      			= sheetObj.CellValue(row, prefix+"cxl_flg");	
		
	if (slpSerNo == ""){
		var notExistJoStlItmCdList = ""; //Financial Matrix에 존재하지 않는 Item List
		var fCtrCdList = ""; //Center Code가 다른 List
		var mCtrCdList = ""; //
		var fLocCdList = ""; //Location Code가 다른 List
		var mLocCdList = "";
		
		for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
			//Financial Matrix에 Data가 없으면 Error메시지를 뿌려준다.
			var finJoStlItmCd = sheetObj.CellValue(i, prefix+"fin_jo_stl_itm_cd");
			var chkJoStlItmCd = sheetObj.CellValue(i, prefix+"jo_stl_itm_cd");
  
			if (ComTrim(finJoStlItmCd) == ""){
			    if( notExistJoStlItmCdList.indexOf(chkJoStlItmCd) == -1){
			        notExistJoStlItmCdList +=chkJoStlItmCd+",";
			    }
			}

			//MDM의 Center코드와 Financial Matrix의 Center코드가 다르면 Error Message를 뿌려준다.
			var ctrCd    = sheetObj.CellValue(i, prefix+"dr_ctr_cd");
			var chkCtrCd = sheetObj.CellValue(i, prefix+"chk_ctr_cd");
			
			if (ctrCd != chkCtrCd){
				fCtrCdList += ctrCd+"|";
				mCtrCdList += chkCtrCd+"|";
//				ComShowCodeMessage("JOO00137",chkCtrCd, ctrCd);
//				return;
			}
	
			//MDM의 Location코드와 Financial Matrix의 Location코드가 다르면 Error Message를 뿌려준다.
			var locCd    = sheetObj.CellValue(i, prefix+"dr_loc_cd");
			var chkLocCd = sheetObj.CellValue(i, prefix+"chk_loc_cd");
			
			if (locCd != chkLocCd){
				fLocCdList += locCd+"|";
				mLocCdList += chkLocCd+"|";
//				ComShowCodeMessage("JOO00138",chkLocCd, locCd);
//				return;
			}
		}
		//JO_STL_ITM_CD   FIN_JO_STL_ITM_CD
		//Financial Matrix에 Data가 없으면 Error메시지를 뿌려준다.
		if (notExistJoStlItmCdList.length > 1){
			notExistJoStlItmCdList = notExistJoStlItmCdList.substring(0, notExistJoStlItmCdList.length - 1);
			ComShowCodeMessage("JOO00162", notExistJoStlItmCdList );
			return;
		}
		
		if (fCtrCdList.length > 1){
			ComShowCodeMessage("JOO00163");
			return;
		}

		if (fLocCdList.length > 1){
			ComShowCodeMessage("JOO00164");
			return;
		}
		
		UF_setSheetToInput();
	}else{
		var slpTpCd   = sheetObj.CellValue(row, prefix+"slp_tp_cd");
		var slpFuncCd = sheetObj.CellValue(row, prefix+"slp_func_cd");
		var slpOfcCd  = sheetObj.CellValue(row, prefix+"slp_ofc_cd");
		var slpIssDt  = sheetObj.CellValue(row, prefix+"slp_iss_dt");
		formObj.csr_no.value = slpTpCd+slpFuncCd+slpOfcCd+slpIssDt.substring(2)+slpSerNo;
		ComShowCodeMessage("JOO00100");
		UF_resetBody();
		UF_resetSheets();		
		UF_unableInput();
	}
}

/**
 * CSR No가 있을때 입력창 비활성화 <br>
 **/
function UF_unableInput(){
	form.csr_desc.readOnly = true;
	form.csr_desc.className = "input2";
	form.eff_dt.readOnly = true;
	form.eff_dt.className = "input2";	
	form.rqst_dt.readOnly = true;
	form.rqst_dt.className = "input2";	
}

/**
 * CSR No가 없을때 입력창 활성화 <br>
 **/
function UF_enableInput(){
	form.csr_desc.readOnly = false;
	form.csr_desc.className = "input1";
	form.eff_dt.readOnly = true;
	form.eff_dt.className = "input1";	
	form.rqst_dt.readOnly = true;
	form.rqst_dt.className = "input1";	
}

/* 개발자 작업  끝 */