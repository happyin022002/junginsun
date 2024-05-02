/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0739.js
 *@FileTitle : RFA Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.26 이진서
 * 1.0 Creation
=========================================================*/
/* History
 * 2010.09.02 김태경 [CHM-201005462-01]	BL Type에 대한 OFT 발생시 Autorating 변경 요청, Note Conversion encoding 추가
 * 2012.02.06  정선용 [CHM-201215875-01]	S/C Information 화면의 lane 정보 추가 요청
 * 2012.03.16 김진주 [CHM-201216312]	RFA 모듈 오토레이팅 적용시 Tariff formula rule 추가 적용  
 * 2012.06.22 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.06.27 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.08.16 김진주 [CHM-201219530] RFA AEE/AEW Autorating 로직 보완
 * 2012.11.06 조정민 [CHM-201220857] Charge의 RFA information 화면에 Scope 정보 추가 요청 (S/C information과 동일)
 * 2012.12.18 김진주 [CHM-201220395-04] Add-on management T/F
 * 2013.05.13 김진주 [CHM-201324625] s/c information 창 오류
 * 2013.10.28 김진주 [CHM-201326965] Split 01-SURCHARGE 및 오토레이팅 보완 관련 CSR(Hide Flag)
 * 2018.02.09 김동호 [CSR 3232] 인도향/발 IHC 계산 로직 추가 요청
 */
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
 * @class esm_bkg_0739 : esm_bkg_0739 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0739() {
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
var URL_ESM_BKG = 'ESM_BKG_0739GS.do';

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
		self.close();
	}
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
* initControl : sheet 초기화 
*/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObject = document.form;
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); //- 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); //- 포커스 들어갈때
	axon_event.addListener('keydown', 'easteregg', 'form'); //- 키보드 입력할때
	//날짜 셋팅
	var rCntr_cdr_dt = formObject.application_date.value.substr(0,4)+'-'+formObject.application_date.value.substr(4,2)+'-'+formObject.application_date.value.substr(6,2) ;		
	ComSetObjValue(formObject.frm_cntr_cdr_dt, rCntr_cdr_dt);	
	sheetObjects[0].WaitImageVisible = false;
}




var ee_arr = [82,76,65,88,79,82,85,68];
var ee_idx = 0;

/* Hidden easteregg */
function easteregg() {
	if (ee_arr[ee_idx++]==event.keyCode) {
		if (ee_arr.length==ee_idx) {
			ee_idx = 0;
			for (var ee=0; ee<sheetObjects.length; ee++) {
				sheetObjects[ee].SpeedDown2Excel(0);
			}
		}
	} else {
		ee_idx = 0;
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	
	case "sheet0":
		with (sheetObj) {

			// 높이 설정
			style.height = 122;
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

			var HeadTitle1 = "TP/SZ|CGO|QTY|EQ SUB|QTY";
			var headCount = 5;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cgo", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "qty",false, "",  dfNullFloat, 2, false, true, 12, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "eq_sub", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "eq_sub_qty", false, "",  dfNullFloat, 2, false, true, 12, false);
			
			MultiSelection = false;
			SelectHighLight = true;
			CountPosition = 0;

		}
		
		break;			
	case "sheet1":
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

			var HeadTitle1 = "";
			var headCount = 32;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "hdnStatus");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_no");
//			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cntr_cdr_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_cgo_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "svc_scp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bdr_cng_flg");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cmdt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cmdt_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rep_cmdt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rep_cmdt_nm");
			InitDataProperty(0, cnt++, dtData, 0, daRight, false, "act_wgt", false, "", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daRight, false, "meas_qty", false, "", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "meas_ut_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "wgt_ut_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_por_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_pol_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_pod_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "del_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vv_pol_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vv_pod_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rcv_term_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "de_term_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "special");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "frt_term_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rfa_no"); // frfa_no 에서 수정 
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "slan_cd");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "srep_eml");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "usr_eml");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "ob_srep_eml");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "scp_cd");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "aply_tp");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "cgo_rcv_dt");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "etd_dt");
		}
		break;
	case "sheet2":
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

			var HeadTitle1 = "";
			var headCount = 16;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "hdnStatus");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "s_cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "s_cust_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "s_cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "c_cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "c_cust_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "c_cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "n_cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "n_cust_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "n_cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "a_cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "a_cust_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "a_cust_nm");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "p_cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "p_cust_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "p_cust_nm");

		}
		break;
	case "sheet3":
		with (sheetObj) {

			// 높이 설정
			style.height = 162;
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

			var HeadTitle1 = " |PT|Commodity Description|POR|POL|POD|DEL|Weight ARB\n<=|Weight ARB\n<|Weight ADD\n<=|Weight ADD\n<|R/D|Per|CGO\nTP|SOC|Cur|Amount|Trans Mode\n(O/D)|Q’TY|Rate\nDetail |Route\nNote |";
			var headCount = 143;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			/* UI GRID START */    
			InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, false, "_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "rt_mtch_patt_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 155, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "por_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pol_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pod_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "del_cd", false, "", dfNone, 0, false);
			
			
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "oa_min_cgo_wgt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "oa_max_cgo_wgt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "da_min_cgo_wgt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "da_max_cgo_wgt", false, "", dfNone, 0, false);
			
			
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "rcv_de_term_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "soc_flg", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "trns_mod_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "dtl", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "note", false, "", dfNone, 0, false);					
			/* UI GRID END */              
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ctrt_no", false, "", dfNone, 0, false );	
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "prc_rt_mtch_patt_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "prop_no", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "amdt_seq", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "svc_scp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_seq", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_bq_seq", false, "", dfNone, 0, false );
			/* BKG_AUTO_RT_OCN_FRT_TMP 에 임시 저장할 칼럼 START */
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ctrt_cntr_tpsz_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rcv_term_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "de_term_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dry_cgo_flg", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "awk_cgo_flg", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dcgo_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rc_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bb_cgo_flg", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "soc_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "imdg_clss_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cmdt_hdr_seq", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rout_seq", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_seq", false, "", dfNone, 0, false );
			/* BKG_AUTO_RT_OCN_FRT_TMP 에 임시 저장할 칼럼 END */
			
			
			
			/* CHARGE UI 에 필요 속성 START */
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cgo_cate_cd", false, "", dfNone, 0, false );					
			/* CHARGE UI 에 필요 속성 END */                        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_por_appl_flg", false, "", dfNone, 0, false );                                                        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_pol_appl_flg", false, "", dfNone, 0, false );                                                        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_pod_appl_flg", false, "", dfNone, 0, false );                                                        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_del_appl_flg", false, "", dfNone, 0, false );                                                        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_por_rly_port_appl_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bq_pst_rly_port_appl_flg", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_add_chg_seq", false, "", dfNone, 0, false );      
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_add_chg_seq", false, "", dfNone, 0, false );          
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_add_chg_seq", false, "", dfNone, 0, false );          
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_add_chg_seq", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cm_prc_cmdt_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cm_prc_cmdt_def_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "op_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ov_rout_via_port_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dv_rout_via_port_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dp_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "op_prc_trsp_mod_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dp_prc_trsp_mod_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_rat_ut_cd", false, "", dfNone, 0, false );
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_prc_cgo_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_rcv_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_bse_port_def_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rat_ut_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_prc_cgo_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_prc_trsp_mod_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rcv_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_bse_port_def_cd", false, "", dfNone, 0, false );     
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_via_port_def_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_rat_ut_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_prc_cgo_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_prc_trsp_mod_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_rcv_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_fdr_rcv_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_fdr_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_fnl_fdr_rt_amt", false, "", dfNullFloat, 2, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_fnl_ihc_rt_amt", false, "", dfNullFloat, 2, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oi_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_bse_port_def_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_rat_ut_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_prc_cgo_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_prc_trsp_mod_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_rcv_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_bse_port_def_cd", false, "", dfNone, 0, false );     
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_via_port_def_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_rat_ut_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_prc_cgo_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_prc_trsp_mod_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_rcv_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_fdr_rcv_de_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_fdr_curr_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_fnl_fdr_rt_amt", false, "", dfNullFloat, 2, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_fnl_ihc_rt_amt", false, "", dfNullFloat, 2, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "di_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_bkg_conv_tp_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_note_conv_mapg_id", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_note_conv_seq", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_note_conv_rule_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_note_conv_tp_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_rt_op_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_curr_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_app_frt_rt_amt", false, "", dfNullFloat, 2, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_bkg_conv_tp_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_note_conv_mapg_id", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_note_conv_seq", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_note_conv_rule_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_note_conv_tp_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_rt_op_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_curr_cd", false, "", dfNone, 0, false );   
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_frt_rt_amt", false, "", dfNullFloat, 2, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "por_mtch_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "del_mtch_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rtro_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oih_flg", false, "", dfNone, 0, false );	
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dih_flg", false, "", dfNone, 0, false );
			
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "bkg_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_gen_spcl_rt_tp_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_cmdt_hdr_seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_rout_seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_rt_seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "calc_ctrt_tp_cd" , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "mst_rfa_rout_id" , false, "", dfNone, 0, false);
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "eq_subst_cntr_tpsz_cd"          , false, "", dfNone, 0, false);
			
			
			/* note conversion detail  */
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "note_ctnt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_ras_conv_ctnt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_typ_conv_ctnt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dp_seq"          , false, "", dfNone, 0, false);
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			MultiSelection = false;
			SelectHighLight = true;
			CountPosition = 0;

		}
		break;
	case "sheet4": //Surcharge
		with (sheetObj) {

			// 높이 설정
			//style.height = 90;
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			SheetWidth = 0;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = " Charge |PCT BSE |Cur |Rate |Rate as |Per |Amount |IN |Term |Cargo |rcv Term |DeTerm |IMO | ";
			var headCount = 18;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "pct_bse_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "curr_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_ut_amt",	  false, "", dfNullFloat, 2, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rat_as_qty",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rat_ut_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_amt",	  false, "", dfNullFloat, 2, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "frt_incl_xcld_div_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "frt_term_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "cgo_tp_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rcv_term_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "de_term_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "imdg_clss_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "soc_flg",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_hngr_bar_tp_cd",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "in_ga_flg",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prn_hdn_flg",	  false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			
			MultiSelection = false;
			SelectHighLight = true;
			CountPosition = 0;

		}
		break;
		
	case "sheet5": //Break Down 로직
		with (sheetObj) {
	
			// 높이 설정
			//style.height = 90;
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			SheetWidth = 0;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
	
			var HeadTitle1 = " Charge |Cur |Rate |Rate as |Per |Amount |IN |Term |Cargo |rcv Term |DeTerm |IMO |M | Hide ";
			var headCount = 31;
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "curr_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_ut_amt",	  false, "", dfNullFloat, 2, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rat_as_qty",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rat_ut_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_amt",	  false, "", dfNullFloat, 2, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "frt_incl_xcld_div_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "frt_term_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "cgo_tp_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rcv_term_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "de_term_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "imdg_clss_cd",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "m",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "hide",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_no", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "cntr_tpsz_cd" ,false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "ctrt_cntr_tpsz_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "dry_cgo_flg" ,false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "awk_cgo_flg" ,false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "dcgo_flg" ,false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "rc_flg" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bb_cgo_flg" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "soc_flg" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_gen_spcl_rt_tp_cd" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_cmdt_hdr_seq" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_rout_seq" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "op_cntr_qty" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_rt_seq" ,false , "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_subst_cntr_tpsz_cd"          , false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "incl_oft_flg"          , false, "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			
			MultiSelection = false;
			SelectHighLight = true;
			CountPosition = 0;

		}
		break;
		case "sheet6":
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
	
				var HeadTitle1 = " |rt_mtch_patt_cd|cmdt_nm|por_cd|pol_cd|pod_cd|del_cd|oa_min_cgo_wgt|oa_max_cgo_wgt|da_min_cgo_wgt|da_max_cgo_wgt|rcv_de_term_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|fnl_frt_rt_amt|trns_mod_cd|op_cntr_qty|dtl|note|ctrt_no|prc_rt_mtch_patt_cd|prop_no|amdt_seq|svc_scp_cd|bq_seq|bkg_bq_seq|cntr_tpsz_cd|ctrt_cntr_tpsz_cd|rcv_term_cd|de_term_cd|dry_cgo_flg|awk_cgo_flg|dcgo_flg|rc_flg|bb_cgo_flg|soc_flg|imdg_clss_cd|cmdt_hdr_seq|rout_seq|rt_seq|cgo_cate_cd|bq_por_appl_flg|bq_pol_appl_flg|bq_pod_appl_flg|bq_del_appl_flg|bq_por_rly_port_appl_flg|bq_pst_rly_port_appl_flg|oa_add_chg_seq|da_add_chg_seq|cm_prc_cmdt_tp_cd|cm_prc_cmdt_def_cd|op_rout_pnt_loc_def_cd|ov_rout_via_port_def_cd|dv_rout_via_port_def_cd|dp_rout_pnt_loc_def_cd|op_prc_trsp_mod_cd|dp_prc_trsp_mod_cd|rt_rat_ut_cd|rt_prc_cgo_tp_cd|rt_curr_cd|rt_fnl_frt_rt_amt|oa_rout_pnt_loc_def_cd|oa_bse_port_def_cd|oa_rat_ut_cd|oa_prc_cgo_tp_cd|oa_prc_trsp_mod_cd|oa_rcv_de_term_cd|oa_curr_cd|oa_fnl_frt_rt_amt|da_rout_pnt_loc_def_cd|da_bse_port_def_cd|da_rat_ut_cd|da_prc_cgo_tp_cd|da_prc_trsp_mod_cd|da_rcv_de_term_cd|da_curr_cd|da_fnl_frt_rt_amt|rt_app_bkg_conv_tp_cd|rt_app_note_conv_mapg_id|rt_app_note_conv_seq|rt_app_note_conv_rule_cd|rt_app_note_conv_tp_cd|rt_app_rt_op_cd|rt_app_curr_cd|rt_app_frt_rt_amt|rt_ras_bkg_conv_tp_cd|rt_ras_note_conv_mapg_id|rt_ras_note_conv_seq|rt_ras_note_conv_rule_cd|rt_ras_note_conv_tp_cd|rt_ras_rt_op_cd|rt_ras_curr_cd|rt_ras_frt_rt_amt|por_mtch_flg|del_mtch_flg|oih_flg|dih_flg|bkg_no|prc_gen_spcl_rt_tp_cd|prc_cmdt_hdr_seq|prc_rout_seq|prc_rt_seq|eq_subst_cntr_tpsz_cd|note_ctnt|rt_ras_conv_ctnt|rt_typ_conv_ctnt|dp_seq";
				var headCount = 109;
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				/* UI GRID START */    
				InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, false, "_flg", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "rt_mtch_patt_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 155, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "por_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pol_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pod_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "del_cd", false, "", dfNone, 0, false);
				
				
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "oa_min_cgo_wgt", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "oa_max_cgo_wgt", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "da_min_cgo_wgt", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "da_max_cgo_wgt", false, "", dfNone, 0, false);
				
				
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "rcv_de_term_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 60, daRight, true, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "trns_mod_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 45, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "dtl", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "note", false, "", dfNone, 0, false);					
				/* UI GRID END */              
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ctrt_no", false, "", dfNone, 0, false );	
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "prc_rt_mtch_patt_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "prop_no", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "amdt_seq", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "svc_scp_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_seq", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_bq_seq", false, "", dfNone, 0, false );
				/* BKG_AUTO_RT_OCN_FRT_TMP 에 임시 저장할 칼럼 START */
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ctrt_cntr_tpsz_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rcv_term_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "de_term_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dry_cgo_flg", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "awk_cgo_flg", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dcgo_flg", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rc_flg", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bb_cgo_flg", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "soc_flg", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "imdg_clss_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_hdr_seq", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_seq", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_seq", false, "", dfNone, 0, false );
				/* BKG_AUTO_RT_OCN_FRT_TMP 에 임시 저장할 칼럼 END */
				
				
				
				/* CHARGE UI 에 필요 속성 START */
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cgo_cate_cd", false, "", dfNone, 0, false );					
				/* CHARGE UI 에 필요 속성 END */                        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_por_appl_flg", false, "", dfNone, 0, false );                                                        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_pol_appl_flg", false, "", dfNone, 0, false );                                                        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_pod_appl_flg", false, "", dfNone, 0, false );                                                        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_del_appl_flg", false, "", dfNone, 0, false );                                                        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_por_rly_port_appl_flg", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bq_pst_rly_port_appl_flg", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_add_chg_seq", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_add_chg_seq", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cm_prc_cmdt_tp_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cm_prc_cmdt_def_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "op_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ov_rout_via_port_def_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dv_rout_via_port_def_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dp_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "op_prc_trsp_mod_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dp_prc_trsp_mod_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_rat_ut_cd", false, "", dfNone, 0, false );
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_prc_cgo_tp_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_curr_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_bse_port_def_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_rat_ut_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_prc_cgo_tp_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_prc_trsp_mod_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_rcv_de_term_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_curr_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oa_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_rout_pnt_loc_def_cd", false, "", dfNone, 0, false );        
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_bse_port_def_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_rat_ut_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_prc_cgo_tp_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_prc_trsp_mod_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_rcv_de_term_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_curr_cd", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "da_fnl_frt_rt_amt", false, "", dfNullFloat, 2, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_bkg_conv_tp_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_note_conv_mapg_id", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_note_conv_seq", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_note_conv_rule_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_note_conv_tp_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_rt_op_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_curr_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_app_frt_rt_amt", false, "", dfNullFloat, 2, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_bkg_conv_tp_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_note_conv_mapg_id", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_note_conv_seq", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_note_conv_rule_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_note_conv_tp_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_rt_op_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_curr_cd", false, "", dfNone, 0, false );   
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_frt_rt_amt", false, "", dfNullFloat, 2, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "por_mtch_flg", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "del_mtch_flg", false, "", dfNone, 0, false );
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "oih_flg", false, "", dfNone, 0, false );	
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dih_flg", false, "", dfNone, 0, false );
				
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_no", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_gen_spcl_rt_tp_cd", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_cmdt_hdr_seq", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_rout_seq", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "prc_rt_seq", false, "", dfNone, 0, false);
			
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_subst_cntr_tpsz_cd"          , false, "", dfNone, 0, false);
				
				
				/* note conversion detail  */
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "note_ctnt", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_ras_conv_ctnt", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rt_typ_conv_ctnt", false, "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dp_seq"          , false, "", dfNone, 0, false);
				
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
				MultiSelection = false;
				SelectHighLight = true;
				CountPosition = 0;
	
			}
			 break;
			 
		case "sheet7":
		    with (sheetObj) {

            // 높이 설정
            style.height = 0;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(5, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle = "|cntr_no|cntr_tpsz_cd|vgm_wgt|fin_flg";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,  dtHiddenStatus, 20,    daCenter,   false,     "ibflag");
            InitDataProperty(0, cnt++,  dtData,         90,    daCenter,   false,     "cntr_no",           false,     "",      dfNone,    0,        true,        true);
            InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cntr_tpsz_cd",      false,     "",      dfNone,    0,        false,       false);
            InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_wgt",           false,     "",      dfFloat,   3,        true,        true, 13);
            InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "fin_flg",      false,     "",      dfNone,    0,        false,       false);
            }
             break;
	}
}

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject0 = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var sheetObject4 = sheetObjects[4];
	var sheetObject5 = sheetObjects[5];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, SEARCH02);
			doActionIBSheet(sheetObject1, formObject, SEARCH05);
			break;
		case "btn_Select":
			/* 
			 * Select 버튼 클릭시 로직 
			 * 1. Multi Rate 기능
			 * 2. QTY Validation
			 * 3. Surcharge 구하기
			 * 4. Charge 화면에 Data setting
			 */
			//1. validation 체크  TP/SZ TYPE의 갯수 확인 
				var rArray	 = new Array();
				var formObj	 = document.form;
				var sheetObj0 = sheetObjects[0];
				var sheetObj1 = sheetObjects[1];
				var sheetObj3 = sheetObjects[3];
				var sheetObj4 = sheetObjects[4];
				var sheetObj5 = sheetObjects[5];
			
				if(formObj.frm_cmdt_nm.value==""){
					ComShowCodeMessage("BKG00010");
					return;
				}

				/* Multi rate 추가 */
				var cnt0_row = sheetObj0.TotalRows;
				var cnt3_row = sheetObj3.TotalRows;
				var flg_cnt = 0 ;
				for ( var z= 1; z <= cnt3_row; z++){
					if(sheetObj3.CellValue(z,"_flg") == 1){
						flg_cnt++;
					}
				}
				if(flg_cnt == 0){
					ComShowCodeMessage("BKG00249");////BKG00249  :  "No Selected Row";
					return;
				}


				// 기준 sheet와 비교 sheet의 내용 비교 
				var tmpPertpsz 	= '';  
				var tmpCgo 		= '';  
				var tmpPersub 	= '';
				var tmpQty1A 	= 0;
				
				var comPer 		= '';
				var comQty 	 	= 0;
				var cflag 		= false;
				
				var t_Tpsz_cd	= '';  
				var t_Qty1A 	= 0;

				// 기준 대상 sheet
				 for ( var i = 1; i <= cnt0_row; i++){
					tmpPertpsz 	= sheetObj0.CellValue(i,"cntr_tpsz_cd");
					tmpCgo 		= sheetObj0.CellValue(i,"cgo");
					tmpPersub 	= sheetObj0.CellValue(i,"eq_sub");
					tmpQty1A	= sheetObj0.CellValue(i,"qty");
					
					// 비교 대상 sheet 
					for ( var ix = 1; ix <= cnt3_row; ix++){						
						comPer =  sheetObj3.CellValue(ix,"cntr_tpsz_cd");
						if(comPer == '20') comPer = 'D2';
						if(comPer == '40') comPer = 'D4';
						
						// 체크된 것들 중에서 
						if(sheetObj3.CellValue(ix,"_flg") == 1){
							//alert(tmpPertpsz +"::::"+ comPer+";;;"+sheetObj3.CellValue(ix,"prc_cgo_tp_cd")+";;"+tmpCgo);
							//per_tpsz 타입과  sub_per 타입이 동일할경우  
							if ((tmpPertpsz == comPer)
								//&&(tmpCgo == sheetObj3.CellValue(ix,"prc_cgo_tp_cd")) 
								) {
								comQty = comQty + parseFloat(sheetObj3.CellValue(ix,"op_cntr_qty"));
								cflag=true;
							}
						}
					}
					
					t_Tpsz_cd = '';
					t_Qty1A = 0;
					for ( var z = 1; z <= cnt0_row; z++){
						t_Tpsz_cd 	= sheetObj0.CellValue(z,"cntr_tpsz_cd");
						if(t_Tpsz_cd == tmpPertpsz){
							t_Qty1A = t_Qty1A + parseFloat(sheetObj0.CellValue(z,"qty"));
						}
					}
					//alert(t_Qty1A+"::"+tmpQty1A+"::"+comQty);
					t_Qty1A = Math.round( t_Qty1A * 1000 ) / 1000;
					comQty = Math.round( comQty * 1000 ) / 1000;
					
					if(cflag){
						cflag = false; 
						// total 갯수와 비교 하여 동일하지 않을경우 
						if(t_Qty1A != comQty){
							// 비교sheet의 Qty가클경우
							if(t_Qty1A < comQty){ 
								ComShowMessage("Dose not match with BKG quantity!"); 
								return;
							}
						// 기준sheet의 Qty가 클경우 
						}else if(tmpQty1A > comQty ){// Sheet0 의  QTY 가 클 경우
							if(!ComShowConfirm("Dose not match with BKG quantity! do you want to continue ?")){
								return;
							}
						
						// 동일할경우  Multi rate 판단유무 
						}else{
							
							var tPer  = '';
							var tCgo  = '';
							var tpor  = '';
							var tpol  = '';
							var tpod  = '';
							var tdel  = '';
							for ( var ix = 1; ix <= cnt3_row; ix++){				
								// 체크된 것들 중에서 
								if(sheetObj3.CellValue(ix,"_flg") == 1){
									
									if(tPer == sheetObj3.CellValue(ix,"rat_ut_cd")
									//&& tCgo == sheetObj3.CellValue(ix,"cgo_tp_cd")
									){
										
										tpor  = sheetObj3.CellValue(ix,"bkg_por_cd");
										tpol  = sheetObj3.CellValue(ix,"bkg_pol_cd");
										tpod  = sheetObj3.CellValue(ix,"bkg_pod_cd");
										tdel  = sheetObj3.CellValue(ix,"del_cd");
										
										if(
										   tpor  != sheetObj3.CellValue(ix,"bkg_por_cd")
										|| tpol  != sheetObj3.CellValue(ix,"bkg_pol_cd")
										|| tpod  != sheetObj3.CellValue(ix,"bkg_pod_cd")
										|| tdel  != sheetObj3.CellValue(ix,"del_cd")
										){
											if (!ComShowConfirm("Do you want to select 'MULTI-RATE' ?")){
												return;	
											}else{
												break;
											}
										}
									}
									tPer =  sheetObj3.CellValue(ix,"rat_ut_cd");
									tCgo =  sheetObj3.CellValue(ix,"cgo_tp_cd");
								}
							}
						}
					}
					tmpQty1A = 0;
					comQty = 0;
				}

				/**
				 3. ESM_BKG_0079_08 표시
				 ＊ Per Type 이 적게 선택 되었을 경우 선택 되지 않은 Per Type 은 Rate 는 .00, Rate As 는 TP/SZ QTY , Amount .00 으로 표시
				 ＊ Per Type 가 각각 나누어져 선택 되었을 경우 선택 되어진 Per Type 개수 만큼 로우 삽입 하여 각각 분리 Amount 값도 다르게 표시
				 */
				 var pArray   = new Array();
				 var tpsz_cd1  = '';
				 var tpsz_cd2  = '';
				 var tpsz_qty1 = 0;
				 var tpsz_qty2 = 0;
				 var x = 0;
				 for ( var i = 1; i <= cnt0_row; i++){
				 	tpsz_cd1 =  sheetObj0.CellValue(i,"cntr_tpsz_cd");
				 	for ( var ix = 1; ix <= cnt3_row; ix ++){
				 		if(sheetObj3.CellValue(ix,"_flg") == 1){
				 			tpsz_cd2 =  sheetObj3.CellValue(ix,"rat_ut_cd");
				 				if( tpsz_cd1 == tpsz_cd2 ){
				 					tpsz_qty2 = tpsz_qty2 + parseInt(sheetObj3.CellValue(ix,"op_cntr_qty"));
				 				}
				 		}
				 	}
				 	
				 	tpsz_qty1 = sheetObj0.CellValue(i,"qty");
				 	
				 	if(tpsz_qty1 > tpsz_qty2){
				 		//alert("부족"+tpsz_qty1+"::"+tpsz_qty2);
				 		var cnt 	 = tpsz_qty1 - tpsz_qty2 ;
				 		var obj		 = new Object();// 값셋팅 
				 		obj.tpsz_cd  = tpsz_cd1;
				 		obj.tpsz_qty = cnt;
				 		pArray[x++]  = obj;
				 	}
				 }
				 	/* 3. Break Down 기능 
				 	 * Charge 화면에서 Break Down Indicator 가 체크 됬을 경우
				 	 * OFT 로 표시되던 CHG Code 를 각각 분할 한다(Charge 정보를 각각 쪼갬 OA, OI, TH, DA, DI) 
				 	 * 분할된 값을 Charge 화면에 넘겨주고 
				 	 * Surcharge 에서 PC 로직에서 참조 할수 있도록  Surcharge 인서트 쿼리에 Row 별로 인서트 함
				 	 *  
				 	 * */
				 
				 	sheetObj5.RemoveAll();// 시트 초기화 해줌
					/* 6. Charge 화면에 Data setting( 3번 기능 과 6번 기능 script 가 섞여 있음)
					 *    Charge 화면에 OFT 셋팅 로직에  Break Down 기능 추가
					 */ 
					var idx = 0;
					for ( var ix = 1; ix <= cnt3_row; ix++) {
						if (sheetObj3.CellValue(ix,"_flg") == 1 && sheetObj3.RowHidden(ix) != true){
//alert(sheetObj3.CellValue(ix, "rtro_flg"));
							var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
							var obj		= new Object(); // 값셋팅 
								obj.charge	= 'OFT';
								obj.cur		= sheetObj3.CellValue(ix, "curr_cd");
								// Break Down 시 Amount 를 쪼갬
//								obj.rate	=  sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt");
								/*RAS 금액이 있는경우 RAS 금액까지 추가
								 * ras 금액이 있는경우 rate금액 = oft rt_ras_rt_op_cd(연산기호) rt_ras_frt_rt_amt
								 * 							100 * 10 = 1000
								 */ 
								if(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt") ==""){
									obj.rate	=  sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt");
								}else{
									if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "+"){							
										obj.rate	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) + parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "-"){
										obj.rate	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) - parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "*"){
										obj.rate	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) * parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "/"){
										obj.rate	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) / parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}
								}
								obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
								obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
								obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
								obj.soc 	= sheetObj3.CellValue(ix, "soc_flg");
								obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") +"/"+ sheetObj3.CellValue(ix,"de_term_cd");
//								obj.term_cd = sheetObj1.CellValue(1,  "frt_term_cd");
								obj.term_cd = formObj.term_cd.value;
								obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
								
								/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
//------------------------------------
								obj.rtroFlg	= sheetObj3.CellValue(ix, "rtro_flg");
								if (obj.rtroFlg == 'Y'){
									formObj.frm_rtro_flg.value = 'Y';
								}
//------------------------------------								
								obj.incl	= 'N';
								obj.m		= 'A';
								/* 2010.03.31 TP/SZ Charge 화면으로 넘겨줌(per type 이 20,40,BL 인 경우가 있어서.. */
								obj.rat_ut2_cd = sheetObj3.CellValue(ix, "cntr_tpsz_cd");
								obj.rat_ut3_cd = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd");
								rArray[idx++] = obj;

								//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
								sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OFT'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "curr_cd"	        );
//								sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) = sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt"	);
								//RAS 금액이 있는경우 RAS 금액까지 추가
								if(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt") ==""){
									sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) =  sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt");
								}else{
									if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "+"){							
										sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) 	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) + parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "-"){
										sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) 	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) - parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "*"){
										sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) 	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) * parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "/"){
										sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) 	=  parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) / parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"));
									}
								}

								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        );   
								
//								sheetObj5.CellValue(newRow, "chg_amt"	       ) = sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");
								//RAS 금액이 있는경우 RAS 금액까지 추가
								if(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt") ==""){
									sheetObj5.CellValue(newRow, "chg_amt"	   ) =  sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");
								}else{
									if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "+"){							
										sheetObj5.CellValue(newRow, "chg_amt"	   ) 	=  (parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) + parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"))) * sheetObj3.CellValue(ix, "op_cntr_qty");
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "-"){
										sheetObj5.CellValue(newRow, "chg_amt"	   ) 	=  (parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) - parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"))) * sheetObj3.CellValue(ix, "op_cntr_qty");
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "*"){
										sheetObj5.CellValue(newRow, "chg_amt"	   ) 	=  ComTrunc((parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) * parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"))),2) * sheetObj3.CellValue(ix, "op_cntr_qty");
									}else if(sheetObj3.CellValue(ix,"rt_ras_rt_op_cd") == "/"){
										sheetObj5.CellValue(newRow, "chg_amt"	   ) 	=  ComTrunc((parseFloat(sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt")) / parseFloat(sheetObj3.CellValue(ix,"rt_ras_frt_rt_amt"))),2) * sheetObj3.CellValue(ix, "op_cntr_qty");
									}
								}
									

								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    );     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	        );     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    );     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        );     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    );     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        );     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    );     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"	);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        );    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        );    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        );     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        );     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        );     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        );     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );   
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd"           ) = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"             );
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   	
								
								
							
							var comp1_cd =  sheetObj3.CellValue(ix,"rat_ut_cd");
							
						}
					}
				 
				/* 3. Break Down 기능 
				 * PT Code 별로 CHG Code 를 나눔
				 * Break Down 시에만 CHG_CD 나누어서 적용 Break Down이 아닐경우 Skip
				 * RFA 와 TAA 는 무조건 Break Down 기능 적용 
				 */
				 	for ( var ix = 1; ix<= cnt3_row; ix++){
				 		if(sheetObj3.CellValue(ix,"_flg") == 1){//&& sheetObj3.RowHidden(ix) != true){
				 			var pt_cd = sheetObj3.CellValue(ix,"rt_mtch_patt_cd"); // PT TYPE
				 			
				 			// All-in Rate(With IHC)인 경우
				 			if(pt_cd.substr(1,3)=='000' && sheetObj3.CellValue(ix, "oi_fnl_frt_rt_amt")>0){
				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj	   = new Object();
				 				obj.charge  = 'OIH'; //Guideline Origin IHC
				 				obj.cur		= sheetObj3.CellValue(ix, "oi_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "oi_fnl_frt_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc  	= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
				 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");	
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");		
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'I';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;
				 				
				 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
				 				sheetObj5.CellValue(newRow, "chg_cd"		   ) = 'OIH'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "oi_curr_cd"	        );
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "oi_fnl_frt_rt_amt"	);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	    );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        );     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "oi_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'I';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	    );     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    );     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        );     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    );     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        );     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    );     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"	);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        );    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        );    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        );     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        );     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        );     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        );     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd"           ) = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"             );
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			
				 			if(pt_cd.substr(1,1)==1 && sheetObj3.CellValue(ix, "oi_fnl_ihc_rt_amt")>0){
				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj	   = new Object();
				 				obj.charge  = 'OIH'; //Guideline Origin IHC
				 				obj.cur		= sheetObj3.CellValue(ix, "oi_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "oi_fnl_ihc_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "oi_rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc 	= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
				 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");	
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");	
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'N';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;
				 				
				 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
				 				sheetObj5.CellValue(newRow, "chg_cd"		   ) = 'OIH'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "oi_curr_cd"	        );
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "oi_fnl_ihc_rt_amt"	);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	    );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "oi_rat_ut_cd"	    );     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "oi_fnl_ihc_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"		);     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"		);     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        );     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    );     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        );     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    );     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"	);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        );    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        );    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        );     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        );     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        );     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        );     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd"           ) = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"             );
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			
				 			if(pt_cd.substr(2,1)==1 && sheetObj3.CellValue(ix, "oi_fnl_fdr_rt_amt")>0){
				 				var obj	   = new Object();
				 				obj.charge  = 'OAR'; //Guideline Origin Add-On
				 				obj.cur		= sheetObj3.CellValue(ix, "oi_fdr_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "oi_fnl_fdr_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "oi_rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc		= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
				 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");	
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'N';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;

				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
				 				sheetObj5.CellValue(newRow, "chg_cd"			   ) = 'OAR'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "oi_fdr_curr_cd"	        	);
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "oi_fnl_fdr_rt_amt"		);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "oi_rat_ut_cd"	        );     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "oi_fnl_fdr_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	    	);     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        	);     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    	);     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        	);     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    	);     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"		);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        	);     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        	);     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"	);
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			
				 			if(pt_cd.substr(3,1) == 1){ //Origin Arbitrary 사용
				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj		= new Object();// 값셋팅

				 				if(sheetObj3.CellValue(ix,"por_mtch_flg") =="Y" && pt_cd.substr(1,1)==0 && 
				 						(sheetObj3.CellValue(ix,"oih_flg") =="Y"||(sheetObj3.CellValue(ix,"oih_flg") =="N" && sheetObj3.CellValue(ix, "rcv_term_cd") =="D"))){
				 					//1.POR<>POL이고 Origin Arbitrary만 사용한 경우
				 					//POR<>POL이고  Origin Arbitrary와 Origin Add-On이 함께 사용된 경우
				 					obj.charge  = 'OIH'; 				 					
				 				}else{
				 					//1.POR=POL이고 Origin Arbitrary 를 사용한 경우
				 					//2.POR<>POL이고 Origin Arbitrary 와 Origin IHC가 함께 사용된 경우 
				 					obj.charge  = 'OAR'; 
				 				}
				 				
				 				obj.cur		= sheetObj3.CellValue(ix, "oa_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "oa_fnl_frt_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "oa_rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc		= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
				 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");	
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");	
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'N';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;
			 							 				
				 				if(sheetObj3.CellValue(ix,"por_mtch_flg") =="Y" && sheetObj3.CellValue(ix,"oih_flg") =="Y" && pt_cd.substr(1,1)==0){
				 					//1.POR<>POL이고 Origin Arbitrary만 사용한 경우
				 					//POR<>POL이고  Origin Arbitrary와 Origin Add-On이 함께 사용된 경우
				 					sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OIH'; 				 					
				 				}else{
				 					//1.POR=POL이고 Origin Arbitrary 를 사용한 경우
				 					//2.POR<>POL이고 Origin Arbitrary 와 Origin IHC가 함께 사용된 경우 
				 					sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OAR'; 
				 				}
				 				
								sheetObj5.CellValue(newRow, "curr_cd"	       	   ) = sheetObj3.CellValue(ix, "oa_curr_cd"	        	);
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "oa_fnl_frt_rt_amt"		);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "oa_rat_ut_cd"	        );     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "oa_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	    	);     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        	);     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    	);     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        	);     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    	);     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"		);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        	);     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        	);     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"	);
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			

				 			// All-in Rate(With IHC)인 경우
				 			if(pt_cd.substr(4,3)=='000' && sheetObj3.CellValue(ix, "di_fnl_frt_rt_amt")>0){
				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj		= new Object();// 값셋팅 
				 					
				 				obj.charge  = 'DIH'; //Guideline Destination IHC
				 				obj.cur		= sheetObj3.CellValue(ix, "di_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "di_fnl_frt_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc		= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
			 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'I';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;
				 				
				 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
				 				
				 				sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'DIH'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "di_curr_cd"	        	);
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "di_fnl_frt_rt_amt"		);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        	);     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "di_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'I';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	        );     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        	);     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    	);     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        	);     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    	);     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"		);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        	);     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        	);     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"	);
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			
				 			
				 			if(pt_cd.substr(6,1)==1 && sheetObj3.CellValue(ix, "di_fnl_ihc_rt_amt")>0){
				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj		= new Object();// 값셋팅 
				 					
				 				obj.charge  = 'DIH'; //Guideline Destination IHC
				 				obj.cur		= sheetObj3.CellValue(ix, "di_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "di_fnl_ihc_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "di_rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc		= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
			 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'N';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;
				 				
				 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
				 				
				 				sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'DIH'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "di_curr_cd"	        	);
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "di_fnl_ihc_rt_amt"		);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "di_rat_ut_cd"	        );     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "di_fnl_ihc_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	    	);     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    	);     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        	);     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    	);     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"		);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        	);     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        	);     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"	);
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			
				 			
				 			if(pt_cd.substr(5,1)==1 && sheetObj3.CellValue(ix, "di_fnl_fdr_rt_amt")>0){ //Guideline Destination Add-On
				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj		= new Object();// 값셋팅 
				 				
				 				obj.charge  = 'DAR';
				 				obj.cur		= sheetObj3.CellValue(ix, "di_fdr_curr_cd");
				 				obj.rate	= sheetObj3.CellValue(ix, "di_fnl_fdr_rt_amt");
				 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
				 				obj.per		= sheetObj3.CellValue(ix, "di_rat_ut_cd");
				 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
				 				obj.soc		= sheetObj3.CellValue(ix, "soc_flg");
				 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
				 				obj.term_cd = formObj.term_cd.value;
				 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
			 				
				 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
								obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
				 				
				 				obj.incl	= 'N';
				 				obj.m		= 'A';
				 				rArray[idx++] = obj;
				 				
				 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
				 				
				 				sheetObj5.CellValue(newRow, "chg_cd"			   ) = 'DAR'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "di_fdr_curr_cd"	        	);
								sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "di_fnl_fdr_rt_amt"		);   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "di_rat_ut_cd"	        );     
								sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "di_fnl_fdr_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	    	);     
								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    	);     
								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	    		);     
								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    	);     
								sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
								sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	       		);     
								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    	);     
								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"		);     
								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        	);    
								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        	);     
								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        	);     
								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        	);     
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"	);
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 			
				 			if(pt_cd.substr(4,1) == 1){

				 				var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
				 				var obj		= new Object();// 값셋팅 
				 				/* DEL_MTCH_FLG = 'Y' AND DIH_FLG = 'Y' 일 경우 'DAR' 을 'DIH' 로 표시 
				 				 * Charge Code 만 DAR 에서 DIH 로 변경 한다 */
				 				if(sheetObj3.CellValue(ix,"del_mtch_flg") =="Y" && pt_cd.substr(6,1) == 0 
				 						&& (sheetObj3.CellValue(ix,"dih_flg") =="Y" || (sheetObj3.CellValue(ix,"dih_flg") =="N" && sheetObj3.CellValue(ix, "de_term_cd") == "D"))){
				 					obj.charge  = 'DIH'; 
				 				}else{
				 					obj.charge	= 'DAR';
				 				}
					 				obj.cur		= sheetObj3.CellValue(ix, "da_curr_cd");
					 				obj.rate	= sheetObj3.CellValue(ix, "da_fnl_frt_rt_amt");
					 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
					 				obj.per		= sheetObj3.CellValue(ix, "da_rat_ut_cd");
					 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
					 				obj.soc		= sheetObj3.CellValue(ix, "soc_flg");
					 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
					 				obj.term_cd = formObj.term_cd.value;
					 				obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
				 				
					 				/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
									obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,6);
									obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
									obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
									obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
									obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
									obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
									obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
									obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");
									obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
									obj.mstRfaRoutId= sheetObj3.CellValue(ix, "mst_rfa_rout_id");
					 				
					 				obj.incl	= 'N';
					 				obj.m		= 'A';
					 				rArray[idx++] = obj;
					 				
					 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
//					 				sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'DAR'; 
					 				
					 				if(sheetObj3.CellValue(ix,"dih_flg") == "Y" || pt_cd.substr(6,1) == 1){
					 					 
					 				}else{
					 					sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'DAR'; 
					 				}

					 				if(sheetObj3.CellValue(ix,"del_mtch_flg") =="Y" && sheetObj3.CellValue(ix,"dih_flg") =="Y" && pt_cd.substr(6,1) == 0){
					 						sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'DIH';
						 				}else{
						 					sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'DAR'; 
						 				}
					 				
					 				
									sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "da_curr_cd"	        	);
									sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "da_fnl_frt_rt_amt"		);   
									sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
									sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "da_rat_ut_cd"	        );     
									sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "da_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");       
									sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
									sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    		);     
									sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	    	);     
									sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    	);     
									sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	  			);     
									sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    	);     
									sheetObj5.CellValue(newRow, "m"		               ) = 'A';     
									sheetObj5.CellValue(newRow, "hide"	  	   	       ) = ' ';     
									sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        	);     
									sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    	);     
									sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"		);     
									sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        	);    
									sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        	);    
									sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        	);     
									sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        	);     
									sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        	);     
									sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        	);     
									sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
									sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
									sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
									sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
									sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
									sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"	);
									sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
				 			}
				 		}
				 	}
				 				
				//POR_MTCH, DEL_MTCH 추가

				for( var j = 1; j <= cnt3_row; j++){
					if(sheetObj3.CellValue(j, "_flg") == 1 && sheetObj3.RowHidden(j) != true){
						if((sheetObj3.CellValue(j, "por_mtch_flg") == "N" )
							&& ((sheetObj3.CellValue(j, "oi_fnl_frt_rt_amt") == null) || (sheetObj3.CellValue(j, "oi_fnl_frt_rt_amt") == ''))){
							var obj = new Object(); //값 셋팅
							obj.charge	= 'OIH';
							obj.curr	= '';
							obj.rate	= '';
							obj.rate_as	= '';
							obj.per		= '';
							obj.cargo	= sheetObj3.CellValue(j,"cgo_cate_cd");
							obj.incl	= 'N';
							obj.term_cd = formObj.term_cd.value;
							obj.term	= sheetObj3.CellValue(j,"rcv_term_cd") +"/"+ sheetObj3.CellValue(j,"de_term_cd");
							obj.imo		= sheetObj3.CellValue(j,"imdg_clss_cd");
							obj.m		= 'A';
							rArray[idx++] = obj;
						}

						if((sheetObj3.CellValue(j, "del_mtch_flg") =="N") 
								&& ((sheetObj3.CellValue(j, "di_fnl_frt_rt_amt" )== null || sheetObj3.CellValue(j, "di_fnl_frt_rt_amt" )== ''))){
							var obj = new Object(); //값 셋팅
							obj.charge	='DIH';
							obj.curr	= '';
							obj.rate	= '';
							obj.rate_as	= '';
							obj.per		= '';
							obj.cargo	= sheetObj3.CellValue(j,"cgo_cate_cd");
							obj.incl	= 'N';
							obj.term_cd = formObj.term_cd.value;
							obj.term	= sheetObj3.CellValue(j,"rcv_term_cd") +"/"+ sheetObj3.CellValue(j,"de_term_cd");
							obj.imo		= sheetObj3.CellValue(j,"imdg_clss_cd");
							obj.m		= 'A';
							rArray[idx++] = obj;
						}
					}	
				}
				//5. Surcharge 구하기 Sheet5번을 Insert 후 Search 하여 Sheet4번에 넣어줌 
				doActionIBSheet(sheetObject5, formObj, IBSAVE);
				
				
				//6. Charge 화면에 Data setting
				var sch = sheetObjects[4].TotalRows;
				for ( var i = 1; i <= sch; i++)
				{
					var obj = new Object(); //값 셋팅
					obj.charge	= sheetObj4.CellValue(i,"chg_cd");
					obj.cur		= sheetObj4.CellValue(i,"curr_cd");
					obj.rate	= sheetObj4.CellValue(i,"chg_ut_amt");
					obj.rate_as = sheetObj4.CellValue(i,"rat_as_qty");
					obj.per		= sheetObj4.CellValue(i,"rat_ut_cd");
					/* Per Type 이 PC 일 경우 AMT 강제로 박아줌 Charge 화면에 ''을 넘길경우 % 계산이 안되고 자동 계산 됨*/
					/* 해당 로직 제거 무조건 적용 2010.04.13 김태경 */
//					if(sheetObj4.CellValue(i,"rat_ut_cd") =="PC"){
//						obj.amt = sheetObj4.CellValue(i,"chg_amt");
//					}
					obj.amt = sheetObj4.CellValue(i,"chg_amt");
					obj.cargo	= sheetObj4.CellValue(i,"cgo_tp_cd");
					obj.incl	= sheetObj4.CellValue(i,"incl_oft_flg");
					obj.term_cd	= sheetObj4.CellValue(i,"frt_term_cd");
					obj.term	= sheetObj4.CellValue(i, "rcv_term_cd") + "/"+ sheetObj4.CellValue(i, "de_term_cd");
					obj.imo		= sheetObj4.CellValue(i,"imdg_clss_cd");
					obj.incl    = sheetObj4.CellValue(i,"frt_incl_xcld_div_cd");
					obj.hdn		= sheetObj4.CellValue(i,"prn_hdn_flg");
					obj.m		= 'A';
					rArray[idx++] = obj;
				}
				
				//7. Application Date 및 Commodity 를 Charge 화면으로 넘겨줌
				
				var _obj = new Object(); //값 셋팅
				_obj.appldt = ComGetObjValue(formObj.frm_cntr_cdr_dt);
				_obj.cmdtcd = ComGetObjValue(formObj.frm_cmdt_cd);
				_obj.cmdtnm = ComGetObjValue(formObj.frm_cmdt_nm);
				_obj.repcmdtcd = ComGetObjValue(formObj.frm_rep_cmdt_cd);
				_obj.repcmdtnm = ComGetObjValue(formObj.frm_rep_cmdt_nm);
				_obj.rtroFlg = ComGetObjValue(formObj.frm_rtro_flg);
//alert("_obj.rtroFlg  : ==="+ _obj.rtroFlg); 
				_obj.actionType	= "Commodity";
				rArray[idx++] = _obj;
								
				window.returnValue = rArray ;//retVal 변수값 설정.				 		 
				self.close();
				
			break;
			
		case "btn_pop_Commodity":

			var repCmdtCd = document.form.frm_rep_cmdt_cd.value;
			var rfaNo = document.form.rfa_no.value;
			var cmdtCd = document.form.frm_cmdt_cd.value;
			var bkgNo = document.form.bkg_no.value;
//			var svcScpCd = document.form.svc_scp_cd.value;
			var porCd = document.form.frm_bkg_por_cd.value;
			var delCd = document.form.frm_del_cd.value;
			var bkgTrunkVvd = ""; //formObj.bkg_trunk_vvd.value;
			if(bkgTrunkVvd.length!=9) bkgTrunkVvd = ""; 

			if(rfaNo == ''){
				comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd); // MDM 팝업
			}else{
				comBkgCallPop0656('callBack0656',rfaNo,bkgNo,bkgTrunkVvd,porCd,delCd);  //RFA 팝업
			}

			break;

		case "btn_Close":
			var formObj = document.form;
			if(formObj.is_bkg.value == "Y" && formObj.chk_oft.value == 'N'){

				ComShowCodeMessage("BKG02209");
				//cntr 정보 추출
				var cntrInfo = '';	
				var _row = sheetObjects[1].LastRow;
				for(var i = 1 ; i < sheetObjects[0].Rows ; i++){

					if(i > 1){
						cntrInfo =  cntrInfo + ", " + 
									sheetObjects[0].CellValue(i, "cntr_tpsz_cd") + " - " + 
									sheetObjects[0].CellValue(i, "cgo") +" X "+
									sheetObjects[0].CellValue(i, "qty");

					}else{
						cntrInfo =  sheetObjects[0].CellValue(i, "cntr_tpsz_cd") + " - " + 
									sheetObjects[0].CellValue(i, "cgo") +" X "+
									sheetObjects[0].CellValue(i, "qty");
					}
				}

				var subject = "[Warning message] No applicable rate in [" + formObj.rfa_no.value + "] - " + formObj.bkg_no.value;
				var contents    = "<br>TO : Sales Rep." +
				  				  "<br><br>Create new rate through the RFA amendment before application date comply with pricing working procedure.<br><br>" + 
								  "BKG No : " + formObj.bkg_no.value + "<BR>" +						
								  "BKG Route : " + formObj.frm_bkg_por_cd.value + " / " + 
								  formObj.frm_bkg_pol_cd.value + " / " + 
								  formObj.frm_bkg_pod_cd.value + " / " + 
								  formObj.frm_del_cd.value + "<BR>" +						
								  "RFA No : " + formObj.rfa_no.value + "<BR>" +						
								  "Type/Size : " + cntrInfo + "<BR>" +						
								  "Commodity Code : " + formObj.frm_cmdt_cd.value + "<BR>" +
								  "Sales Rep : " + formObj.srep_eml.value + "<BR>" +
								  "Approval Rep : " + formObj.usr_eml.value;
				
				if(formObj.ob_srep_eml.value != "")
					contents = contents + "<BR>" + "Loading Rep : " + formObj.ob_srep_eml.value;
				
				if(sheetObjects[1].CellText(_row, "aply_tp") == "C"){
					
					if(sheetObjects[1].CellText(_row, "cgo_rcv_dt") == ""){
						contents = contents + "<BR>" + "CRD : No Data" + "<BR>" +" ETD : " + sheetObjects[1].CellText(_row, "etd_dt");
					} else {
						contents = contents + "<BR>" + "CRD : " + sheetObjects[1].CellText(_row, "cgo_rcv_dt")
											+ "<BR>" + "ETD : "+ sheetObjects[1].CellText(_row, "etd_dt");										
					}
										
				} else {
					contents = contents + "<BR>" + "ETD : " + sheetObjects[1].CellText(_row, "etd_dt");
				}
				
		        ComSetObjValue(formObj.gw_subject,subject);
//		        ComSetObjValue(formObj.gw_contents,contents);
		    	formObj.gw_contents.value = contents;
				ComOpenGroupwareMail(sheetObjects[0], formObj);

				window.close();
			}else {			

				var idx = 0;
				var rArray	 = new Array();
				var sheetObj3 = sheetObjects[3];
				var sheetObj4 = sheetObjects[4];
				var cnt3_row = sheetObj3.TotalRows;
				var flg_cnt = 0 ;
				
				
					for ( var z= 1; z <= cnt3_row; z++){
						if(sheetObj3.CellValue(z,"_flg") == 1){
							flg_cnt++;
						}
					}
					//Close 시 조회결과가 없을경우  Surcharge 입력 여부 확인
	//				if(flg_cnt == 0  ){
						doActionIBSheet(sheetObject5, formObj, SEARCH03);
	//				}
					// Charge 화면에 Data setting
					var sch = sheetObjects[4].TotalRows;
		
					
					if(sch == 0 ){
						var obj = new Object(); //값 셋팅
						
						obj.prcPttCd	= "";
						obj.genSpclTp	= "";
						obj.cmdtHdrSeq	= "";
						obj.routSeq	= "";
						obj.actionType	= "Close";
				
						rArray[idx++] = obj;
						
					}else{
						if(sch > 0){
							for ( var i = 1; i <= sch; i++)
							{ 
								var obj = new Object(); //값 셋팅
								obj.charge	= sheetObj4.CellValue(i,"chg_cd");
								obj.cur		= sheetObj4.CellValue(i,"curr_cd");
								obj.rate	= sheetObj4.CellValue(i,"chg_ut_amt");
								obj.rate_as = sheetObj4.CellValue(i,"rat_as_qty");
								obj.per		= sheetObj4.CellValue(i,"rat_ut_cd");
								obj.amt 	= sheetObj4.CellValue(i,"chg_amt");
								obj.cargo	= sheetObj4.CellValue(i,"cgo_tp_cd");
								obj.incl	= sheetObj4.CellValue(i,"incl_oft_flg");
								obj.term_cd	= sheetObj4.CellValue(i,"frt_term_cd");
								obj.term	= sheetObj4.CellValue(i, "rcv_term_cd") + "/"+ sheetObj4.CellValue(i, "de_term_cd");
								obj.imo		= sheetObj4.CellValue(i,"imdg_clss_cd");
								obj.incl    = sheetObj4.CellValue(i,"frt_incl_xcld_div_cd");
								obj.m		= 'A';
								
								obj.prcPttCd	= "";
								obj.genSpclTp	= "";
								obj.cmdtHdrSeq	= "";
								obj.routSeq		= "";
								obj.actionType	= "Close";
								
								rArray[idx++] = obj;
							}
						}
					}
					window.returnValue = rArray ;//retVal 변수값 설정.
	
				window.close();
				break;
			}
			

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
			bkg_error_ComShowMessage(e);
		} else {
			ComShowMessage(e);
			bkg_error_ComShowMessage(e);
		}
	}
}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
	
		switch (sAction) {
	
		case IBSEARCH: //조회1
		try {
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
				ComSetObjValue(formObj.f_cmd, SEARCH);
				// 2.조회조건으로 조회실행
				var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj));
				pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
		
				var formObj = document.form;
				// 3.조회후 결과처리
				var arrXml = sXml.split("|$$|");
				var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
				/* 조회 성공실패 추가 */
				if (State != "S"){
					ComShowCodeMessage('BKG00450');
				}
							
				for ( var inx = 0; inx < arrXml.length; inx++) {
					sheetObjects[inx].LoadSearchXml(arrXml[inx]);
				}
				// 4.HTML 변수와 Binding 
				IBS_CopyRowToForm(sheetObjects[1], formObj, 1, "frm_");
				IBS_CopyRowToForm(sheetObjects[2], formObj, 1, "frm_");
	
				var _row = sheetObjects[1].LastRow;
				if(_row == 0) return;
				ComSetObjValue(formObj.frm_act_wgt, sheetObjects[1].CellText(_row, "act_wgt"));// Weight
				ComSetObjValue(formObj.frm_meas_qty, sheetObjects[1].CellText(_row, "meas_qty"));// Measure
				ComSetObjValue(formObj.srep_eml, sheetObjects[1].CellText(_row, "srep_eml"));
				ComSetObjValue(formObj.usr_eml, sheetObjects[1].CellText(_row, "usr_eml"));
				ComSetObjValue(formObj.ob_srep_eml, sheetObjects[1].CellText(_row, "ob_srep_eml"));
				ComSetObjValue(formObj.scp_cd, sheetObjects[1].CellText(_row, "scp_cd"));

				//조회 실행 
				/*
				if(formObj.frm_bkg_por_cd.value.substring(0, 2) == "IN"
				    || formObj.frm_bkg_pol_cd.value.substring(0, 2) == "IN"
			        || formObj.frm_bkg_pod_cd.value.substring(0, 2) == "IN"
                    || formObj.frm_del_cd.value.substring(0, 2) == "IN") { // 인도 향발인 경우
				    
				    doActionIBSheet(sheetObjects[7], formObj, SEARCH07);
				    
				} else {
				    doActionIBSheet(sheetObjects[3], formObj, SEARCH01);
				}
				*/
				doActionIBSheet(sheetObjects[7], formObj, SEARCH07);
				doActionIBSheet(sheetObjects[3], formObj, SEARCH01);
				
				formObj.frm_frt_term_cd.value = ComGetObjValue(formObj.term_cd); 
				
				var svc_scp_cd = ComGetObjValue(formObj.scp_cd);
				var rName = svc_scp_cd.split("$");
				var rCode = '';
				var _first = false;
				for ( var j = 0; j < rName.length; j++) {
					if (_first) {
						rCode += '$';
					}
					rCode += rName[j].substring(0, 3);
					_first = true;
				}
				//- svc_scp_cd setting
				var r_value = rCode + "^" + svc_scp_cd;
				svc_scp_cd = formObj.svc_scp_cd.value;
				fnSetComboBox('set_svc_scp_cd', r_value, svc_scp_cd);
						
				ComOpenWait(false); //대기창 사라짐 
		} catch (e) {
			if (e == "[Faile to retrieve data.]") {
				ComShowMessage("BKG00450");
				bkg_error_ComShowMessage(e);
			} else {
				ComShowMessage(e);
				bkg_error_ComShowMessage(e);
			}
		}
	
				break;
			
		case SEARCH01: // 조회1
		try {
				if(formObj.set_svc_scp_cd.value != "")
					ComSetObjValue(formObj.svc_scp_cd, ComGetObjValue(formObj.set_svc_scp_cd));	
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				// Parameter 로 넘겨준 스콥으로  AutoRating 한다 2010.04.26 김태경
				ComSetObjValue(formObj.frm_svc_scp_cd, formObj.svc_scp_cd.value);
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				//Sheet에 존재하는 값을 form에 Binding 
				//if (IBS_CopyFormToRow(formObj, sheetObjects[3], 1, "frm_")) {};
				// 2.조회조건으로 조회실행
				sheetObj.DoSearch(URL_ESM_BKG, FormQueryString(formObj));
				ComOpenWait(false); //대기창 사라짐 
		} catch (e) {
			if (e == "[Faile to retrieve data.]") {
				ComShowMessage("BKG00450");
				bkg_error_ComShowMessage(e);
			} else {
				ComShowMessage(e);
				bkg_error_ComShowMessage(e);
			}
		}
					break;
					
		case SEARCH02: //조회1
			try {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
					ComSetObjValue(formObj.f_cmd, SEARCH);
					// 2.조회조건으로 조회실행
					var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj));
					pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
			
					var formObj = document.form;
					// 3.조회후 결과처리
					var arrXml = sXml.split("|$$|");
					var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
					/* 조회 성공실패 추가 */
					if (State != "S"){
						ComShowCodeMessage('BKG00450');
					}
					
					for ( var inx = 0; inx < arrXml.length; inx++) {
						if(inx!=1){
							sheetObjects[inx].LoadSearchXml(arrXml[inx]);
						}
					}
					// 4.HTML 변수와 Binding 
//					IBS_CopyRowToForm(sheetObjects[1], formObj, 1, "frm_");
					IBS_CopyRowToForm(sheetObjects[2], formObj, 1, "frm_");
		
					var _row = sheetObjects[1].LastRow;
					if(_row == 0) return;
					ComSetObjValue(formObj.frm_act_wgt, sheetObjects[1].CellText(_row, "act_wgt"));// Weight
					ComSetObjValue(formObj.frm_meas_qty, sheetObjects[1].CellText(_row, "meas_qty"));// Measure
					ComSetObjValue(formObj.srep_eml, sheetObjects[1].CellText(_row, "srep_eml"));
					ComSetObjValue(formObj.usr_eml, sheetObjects[1].CellText(_row, "usr_eml"));
					ComSetObjValue(formObj.ob_srep_eml, sheetObjects[1].CellText(_row, "ob_srep_eml"));
					ComSetObjValue(formObj.scp_cd, sheetObjects[1].CellText(_row, "scp_cd"));

					//조회 실행 
					doActionIBSheet(sheetObjects[3], formObj, SEARCH01);
					
					formObj.frm_frt_term_cd.value = ComGetObjValue(formObj.term_cd); 
					
					var svc_scp_cd = ComGetObjValue(formObj.scp_cd);
					var rName = svc_scp_cd.split("$");
					var rCode = '';
					var _first = false;
					for ( var j = 0; j < rName.length; j++) {
						if (_first) {
							rCode += '$';
						}
						rCode += rName[j].substring(0, 3);
						_first = true;
					}
					//- svc_scp_cd setting
					var r_value = rCode + "^" + svc_scp_cd;
					svc_scp_cd = formObj.svc_scp_cd.value;
					fnSetComboBox('set_svc_scp_cd', r_value, svc_scp_cd);
							
					ComOpenWait(false); //대기창 사라짐 
			} catch (e) {
				if (e == "[Faile to retrieve data.]") {
					ComShowMessage("BKG00450");
					bkg_error_ComShowMessage(e);
				} else {
					ComShowMessage(e);
					bkg_error_ComShowMessage(e);
				}
			}
		
					break;
			
		case IBSAVE: // Surcharge 를 위해서 임시테이블에 저장
			
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = MULTI;
//			var sParam = ComGetSaveString(sheetObjects[3]);
			var sParam = ComGetSaveString(sheetObjects[5]);
			sParam += "&" + FormQueryString(formObj);
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); // 대기창 보임
			var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0739GS.do", sParam);
			var sheetObject4 = sheetObjects[4];
			sheetObjects[4].LoadSaveXml(SaveXml);
			
					
			break;
			
		case SEARCH03: //Close 버튼을 눌렀을 경우 Surcharge 만 값 적용 

			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH03;
			sParam += "&"+ FormQueryString(formObj);
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); // 대기창 보임
			var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0739GS.do", sParam);
			var sheetObject4 = sheetObjects[4];
		    sheetObjects[4].LoadSaveXml(SaveXml);
		
			break;
			
		case SEARCH05:
			var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&rfa_no=" + ComGetObjValue(formObj.rfa_no)
			 + "&ca_flg=" + ComGetObjValue(formObj.ca_flg) + "&frm_svc_scp_cd=" + ComGetObjValue(formObj.frm_svc_scp_cd);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0739GS.do", param);
			formObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
			

			break;	
			
		case SEARCH07:
            var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&ca_flg=" + ComGetObjValue(formObj.ca_flg);
            sheetObj.DoSearch(URL_ESM_BKG, param);

            break;  
		}
		ComOpenWait(false); //대기창 사라짐
	}

	/**
	 * Sheet 조회완료 후 이벤트 발생
	 */
//	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
//	 	var formObj = document.form;
//		var c_row = sheetObj.LastRow;
//		with (sheetObj) {
//			for ( var row = 1; row <= c_row; row++) {
//				if(sheetObj.cellvalue(row, "nt") != ''){
//					sheetObj.CellFontColor(row,"nt_v") = sheetObj.RgbColor(255, 0, 0);
//				}
//			}
//		}
//	}
	/**
	 * 마우스 오버
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet3_OnMouseMove(Button, Shift, X, Y) {
		var sheetObj = sheetObjects[3];
		var m_row = sheetObj.MouseRow;
		var m_col = sheetObj.MouseCol;
		if (m_row > 0 && m_col == 16) {
			sheetObj.ToolTipText(m_row, m_col) = sheetObj.CellText(m_row, "nt");
		}
	}
	var isChecked = false;
	function sheet3_OnChange(sheetObj, row, col, value) {
		if (sheetObj.ColSaveName(col) == "_flg" && !isChecked) {
			isChecked = true;
			with(sheetObj) {
				var chkValue = CellValue(row, "prc_cmdt_hdr_seq")
					+ CellValue(row, "prc_rout_seq")
					+ CellValue(row, "prc_rt_seq")
					+ CellValue(row, "prop_no")
					+ CellValue(row, "amdt_seq")
					+ CellValue(row, "svc_scp_cd")
					+ CellValue(row, "fnl_frt_rt_amt");
				for (var i=HeaderRows; i<=LastRow; i++) {  //LastRow; iRow >= HeaderRows; iRow--) {
					if (CellValue(i, "rat_ut_cd") == 'BL') {
						if (chkValue == CellValue(i, "prc_cmdt_hdr_seq")
								+ CellValue(i, "prc_rout_seq")
								+ CellValue(i, "prc_rt_seq")
								+ CellValue(i, "prop_no")
								+ CellValue(i, "amdt_seq")
								+ CellValue(i, "svc_scp_cd")
								+ CellValue(i, "fnl_frt_rt_amt")) {
							CellValue(i, "_flg") = value;
						}
					}
				}
			}
			isChecked = false;
		}
	}

	/**
	  *  Remark MemoPad 
	  */
	function sheet3_OnClick(sheetObj, row, col, value) {
		  //Detail 로직 에서 Detail 정보를 String으로 받아 온다
//		  detail_info(sheetObj, row, col);
		  var rt_data = detail_info(sheetObj, row, col);
		  var id = rt_data.lastIndexOf('$$');
		  var rfa_data = rt_data.substring(id+2,rt_data.length);
		  var note_ctnt = sheetObj.CellValue(row,"note_ctnt");
		  
		  // DTL Sheet 를 클릭하였을 경우 DTL 팝업이 Open 된단
		  if(sheetObj.ColSaveName(col) == "dtl"){
			  if(sheetObj.CellValue(row,"dtl") == '' ) return;
			  
			  var param ="?title="+"Detail_INFO"+"&text="+rfa_data;
			  ComOpenPopup('/hanjin/ESM_BKG_0988.do'+param, 550, 335, 'Detail INFO','0,0', true);
			  
		  }
		  // Note Sheet 를 클릭하였을 경우 Note Conversion 팝업이 Open 된다
	     if (sheetObj.ColSaveName(col) =="note"){
	    	  if(sheetObj.CellValue(row,"note_ctnt") == '') return;
	    	  
	    	  var param ="?title="+"NOTE CONV"+"&text="+encodeURIComponent(note_ctnt);
	    	  //ComOpenWindowCenter2("/hanjin/ESM_BKG_0988.do"+param, "NOTE CONV" , 500,270, false,"scrollbars=yes,resizeable=no");
	    	  ComOpenPopup('/hanjin/ESM_BKG_0988.do'+param, 550, 355, 'NOTE CONV', '0,0', true);
	     }
	}
	/*
	 * 조회후  이벤트 처리 >>> 폰트 칼라변경 
	 */ 
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			if (RowCount && 0 < RowCount) {
				var formObj = document.form;
				var redColor = RgbColor(255, 0, 0);
				for ( var i = 1; i <= LastRow; i++) {
					var note = CellValue(i, "note_ctnt");
					if (!note.length == 0) {
						CellValue(i, "note") = "Y";
						CellFontColor(i, 19) = redColor;
					} else {
						CellValue(i, "note") = "N";
					}
				}
				pageMaxCnt = LastRow;
				// DP_SEQ 에 따라 Sort 한다
				ColumnSort("dp_seq");
	
				/*
				 * sheet3 에 rat_ut_cd ='BL' 이고 prc_cmdt_hdr_seq,
				 * prc_rout_seq,prc_rt_seq,prop_no,amdt_seq,svc_scp_cd 가 동일할 경우 해당건은
				 * 1개의 Row 만 남기고 모두 RowHidden 처리 한다
				 */
				for ( var iRow = LastRow; iRow >= HeaderRows; iRow--) {
					if (CellValue(iRow, "rat_ut_cd") == 'BL') {
						var chkValue = CellValue(iRow, "prc_cmdt_hdr_seq")
								+ CellValue(iRow, "prc_rout_seq")
								+ CellValue(iRow, "prc_rt_seq")
								+ CellValue(iRow, "prop_no")
								+ CellValue(iRow, "amdt_seq")
								+ CellValue(iRow, "svc_scp_cd")
								+ CellValue(iRow, "fnl_frt_rt_amt");
						if (chkValue == CellValue(iRow - 1, "prc_cmdt_hdr_seq")
								+ CellValue(iRow - 1, "prc_rout_seq")
								+ CellValue(iRow - 1, "prc_rt_seq")
								+ CellValue(iRow - 1, "prop_no")
								+ CellValue(iRow - 1, "amdt_seq")
								+ CellValue(iRow - 1, "svc_scp_cd")
								+ CellValue(iRow - 1, "fnl_frt_rt_amt")) {
							RowHidden(iRow) = true;
						}
					}
				}
				
				/* [CSR 3232] 인도향/발 IHC에 대한 VGM 비교 로직 시작 */
				if (  document.form.frm_bkg_por_cd.value.substr(0,2) == "IN"
				       && document.form.frm_bkg_pol_cd.value.substr(0,2) == "IN"
				   || document.form.frm_bkg_pod_cd.value.substr(0,2) == "IN"
				       && document.form.frm_del_cd.value.substr(0,2) == "IN" ) {
				    
				    var isVGMComplete = false;
				    var hasIHCRate = false;
    				
				    // VGM List 조회결과가 있으면서, fin_flg가 Y여야 VGM이 작성된걸로 본다. 
				    // 작성이 안된 경우에는 경고메시지가 표출되고 IHC관련 항목을 모두 숨긴다.
    				if(sheetObjects[7].FindText("fin_flg", "Y", sheetObjects[7].HeaderRows, -1, true) >= 0 
    				        && sheetObjects[7].SearchRows > 0) { 
    				    isVGMComplete = true;
    				}
    				
    				for (var iRow = HeaderRows; iRow <= SearchRows; iRow++) {
    				    RowHidden(iRow) = true;
    				}
    				
    				for (var iRow = HeaderRows; iRow <= SearchRows; iRow++) {
    				    if(CellValue(iRow, "rt_mtch_patt_cd").substr(1,6) == "000000") { // THRU rate 는 넘어간다.
    				        RowHidden(iRow) = false; 
    				        continue; 
    				    } else {
    				        hasIHCRate = true;
    				    }
    				    
    				    var needRowHiddenCheck = 0;
    				    
    				    if(isVGMComplete) { // VGM 입력이 완료되었으면 VGM 검사
                            var vgm_wgt = 0.0;
                            var oa_min_cgo_wgt = parseFloat(CellValue(iRow, "oa_min_cgo_wgt"));
                            var oa_max_cgo_wgt = parseFloat(CellValue(iRow, "oa_max_cgo_wgt"));
                            var da_min_cgo_wgt = parseFloat(CellValue(iRow, "da_min_cgo_wgt"));
                            var da_max_cgo_wgt = parseFloat(CellValue(iRow, "da_max_cgo_wgt"));
                            
                            // 둘다 비어있으면 검색에 안걸리게 처리하고 한쪽만 채워져 있으면 최소/최대값으로 인식 처리
                            if(isNaN(oa_min_cgo_wgt) && isNaN(oa_max_cgo_wgt)) { 
                                oa_min_cgo_wgt = -99;
                                oa_max_cgo_wgt = -99;
                            } else if (isNaN(oa_min_cgo_wgt)) {
                                oa_min_cgo_wgt = 0.0;
                            } else if (isNaN(oa_max_cgo_wgt)) {
                                oa_max_cgo_wgt = 99.99;
                            }
                            
                            // 둘다 비어있으면 검색에 안걸리게 처리하고 한쪽만 채워져 있으면 최소/최대값으로 인식 처리
                            if(isNaN(da_min_cgo_wgt) && isNaN(da_max_cgo_wgt)) { 
                                da_min_cgo_wgt = -99;
                                da_max_cgo_wgt = -99;
                            } else if (isNaN(da_min_cgo_wgt)) {
                                da_min_cgo_wgt = 0.0;
                            } else if (isNaN(da_max_cgo_wgt)) {
                                da_max_cgo_wgt = 99.99;
                            }
        				        
            				for (var iVgm = sheetObjects[7].HeaderRows; iVgm <= sheetObjects[7].SearchRows; iVgm++) {                        
                                if(CellValue(iRow, "cntr_tpsz_cd") != sheetObjects[7].CellValue(iVgm, "cntr_tpsz_cd")) continue;
                                
                                vgm_wgt = parseFloat(sheetObjects[7].CellValue(iVgm, "vgm_wgt"));
            				    
    				            if(CellValue(iRow, "rt_mtch_patt_cd").substr(1,3) != "000"
                                    && (oa_min_cgo_wgt <= vgm_wgt && vgm_wgt < oa_max_cgo_wgt) 
    				                || 
    			                   CellValue(iRow, "rt_mtch_patt_cd").substr(4,3) != "000"
                                    && (da_min_cgo_wgt <= vgm_wgt && vgm_wgt < da_max_cgo_wgt)) {
    				                RowHidden(iRow) = false;        
    				            }
                            }
    				    }
    				}
    				
    				if(!isVGMComplete && hasIHCRate) { // VGM이 입력되지 않았으며, IHC 운임이 존재하는 경우 Alert표출
    				    alert("Please input VGM weight for a correct IHC calculation.");
    				}
				}
				/* IHC에 대한 VGM 비교 로직 끝 */
			}
		}
	}
	/**
	 * getSelectedRow 선택한 row의 값을 넘겨준다.
	 */
	function getCheckedRows(colName) {
		var sheetObj = sheetObjects[3];
		var formObj = document.form;
		var checkRows = sheetObj.CheckedRows('radio');
		if (checkRows == 0){
			return null;
		}
		
		var rArray = null; //행데이터를 담고 있는 배열
		var cArray = null; //열데이터를 담고 있는 배열
	
		try {
	
			var rows = sheetObj.Rows;
			var idx = 0;
			rArray = new Array(checkRows);
	
			for ( var i = 0; i < rows; i++) {
				if (sheetObj.CellValue(i, 'radio') == 1) {
					cArray = sheetObj.CellValue(i, colName);
					rArray[idx++] = cArray;
				}
			}
		} catch (e) {
			bkg_error_ComShowMessage(e);
		}
		return rArray;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			//             if (!isNumber(formObj.iPage)) {
			//                 return false;
			//             }
		}
	
		return true;
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
	 * bkg_error_alert 에러메세지 
	 */
	function bkg_error_alert(msg, ex) {
		alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
	}
	
	/* 유저의 요청에 따라 기존 As Is 와 동일하게 팝업 구현 
	 * PATERN 은 동일하나 코드 가 바뀜
	 */
	function detail_info(sheetObj, row, col){
		
		/* Rate Detail 화면 구성도
		 * 1. Rate Source - General Rate / Special Rate
		 * 2. Pattern 정보
		 * 3. Rate 배열 (Text 형식으로 Value 만 표시 ) 
		 * 4. Conversion 적용 Pattern 상세별
		 * 5. Final : USD 
	     */
	     
	     /*
		  * 1 : Through Rate, 
		  *	2 : Origin ARB + Through Rate,
		  *	3 : Through Rate + Dest ARB.
		  *	4 : Origin ARB + Through Rate + Dest ARB
		  *	5 : Origin IHC + Through Rate
		  *	6 : Origin IHC + Origin ARB + Through Rate 
		  *	7 : Origin IHC + Through Rate + Dest ARB
		  *	8 : Origin IHC + Origin ARB + Through Rate + Dest ARB
		  *	9 : Through Rate + Dest IHC
		  *	10 : Origin ARB + Through Rate + Dest IHC
		  *	11 : Origin IHC + Through Rate + Dest IHC
		  *	12 : Origin IHC + Origin ARB + Through Rate + Dest IHC
		  *	13 : Origin IHC + Through Rate + Dest ARB + Dest IHC
		  *	14 : Origin ARB + Through Rate + Dest ARB + Dest IHC
		  */
	     
	     var dtl_title ="";// Detail Popup Title
	     var pt_cd // Pattern Code 별로 Rate 구성
	     var rt_string = ""; // Detail을 String 형태로 가지고 있어 Title 과 같이 Poup 으로 넘기는 변수
	     var rt_head ="";
		 var rt_dtl ="";
	     var fnl_amount = "";
	     var fnl = "";
	     var typ_head = "";
	  	 var typ_conv = ""; //TYPE CONV
	  	 var oa_typ_conv = ""; // OA ARB TYP CONV 
	  	 var oi_typ_conv = ""; // OA IHC TYP CONV
	  	 var rt_typ_conv = ""; // RT TYP CONV 
	  	 var da_typ_conv = ""; // DA ARB TYP CONV 
	  	 var di_typ_conv = ""; // DA IHC TYP CONV
	  	 var rt_rar_conv = ""; // RT RAR CONV
	  	 var rt_rac_conv = ""; // RT RAC CONV
	  	 var rt_rap_conv = ""; // RT RAP CONV
	  	 var rt_dor_conv = ""; // RT DOR CONV
	  	 var rt_ras_conv = ""; // RT RAS CONV
	  	 var rt_typ_conv = ""; // RT TYP CONV
	     var chg_row1 = "\n" + "=================================================";
	  	 var chg_row2 = "\n" + "--------------------------------------------------------------------------------------------------------------";
	  	 var chg_row3 = "\n" + "=================================================";
	  	 var sheetObj3 = sheetObjects[3];

	     pt_cd = sheetObj.CellValue(row, "rt_mtch_patt_cd"); //PT TYPE
	     
	     fnl_amount = sheetObj.CellText(row,"fnl_frt_rt_amt"); //FINAL AMOUNT
	     
	     
	     /* RT RAS CONVERSION */
		  if(sheetObj.CellValue(row,"rt_ras_conv_ctnt") !=''){
			  rt_ras_conv = "\n" + "=================================================" +
	     					"\n" + sheetObj.CellValue(row,"rt_ras_conv_ctnt");
		  }
		  
		  /* TYPE CONVERSION */
		  if(sheetObj.CellValue(row,"rt_typ_conv_ctnt") !=''){
			  // RT TYP CONV
			  if(sheetObj.CellValue(row,"rt_typ_conv_ctnt") !=''){
				  rt_typ_conv = "\n"+ sheetObj.CellValue(row,"rt_typ_conv_ctnt");
			  }
			  
			  typ_conv = "\n" + "TYPE CONVERSION" + rt_typ_conv +
			  			 "\n" + "=================================================";  
		  }			  
		  
	     /* Detail 상세로직 */
		  /* 1 ROW FROM + VIA + TO + VIA */
		  /* 2 ROW TRANSMODE */

	     var pt_cd = sheetObj3.CellValue(row,"rt_mtch_patt_cd").substr(1,6); // PT TYPE
	     
	     if(pt_cd == "000000"){
	    	 rt_head += "Pattern 1 : THRU" +
	    	 	"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd == "001000"){
	    	 rt_head += "Pattern 2 : OAR + THRU"+
	 			"\n" +	"--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101000"){
	    	 rt_head += "Pattern 3 : OIH(G) + OAR + THRU"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011000"){
	    	 rt_head += "Pattern 4 : OIH + OAR(G) + THRU"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110000"){
	    	 rt_head += "Pattern 5 : OIH(G) + OAR(G) + THRU"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="000100"){
	    	 rt_head += "Pattern 6 : THRU + DAR"+
	    	 	"\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="001100"){
	    	 rt_head += "Pattern 7 : OAR + THRU + DAR"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101100"){
	    	 rt_head += "Pattern 8 : OIH(G) + OAR + THRU + DAR"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011100"){
	    	 rt_head += "Pattern 9 : OIH + OAR(G) + THRU + DAR"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110100"){
	    	 rt_head += "Pattern 10 : OIH(G) + OAR(G) + THRU + DAR"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100000"){
	    	 rt_head += "Pattern 11 : OIH(G) + THRU"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100100"){
	    	 rt_head += "Pattern 12 : OIH(G) + THRU + DAR"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010000"){
	    	 rt_head += "Pattern 13 : OAR(G) + THRU"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010100"){
	    	 rt_head += "Pattern 14 : OAR(G) + THRU + DAR"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="001010"){
	    	 rt_head += "Pattern 15 : OAR + THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="001101"){
	    	 rt_head += "Pattern 16 : OAR + THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="001001"){
	    	 rt_head += "Pattern 17 : OAR + THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="001110"){
	    	 rt_head += "Pattern 18 : OAR + THRU + DAR(G) + DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="001011"){
	    	 rt_head += "Pattern 19 : OAR + THRU + DAR(G) + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101010"){
	    	 rt_head += "Pattern 20 : OIH(G) + OAR + THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101101"){
	    	 rt_head += "Pattern 21 : OIH(G) + OAR + THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101001"){
	    	 rt_head += "Pattern 22 : OIH(G) + OAR + THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101110"){
	    	 rt_head += "Pattern 23 : OIH(G) + OAR + THRU + DAR(G) + DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="101011"){
	    	 rt_head += "Pattern 24 : OIH(G) + OAR + THRU + DAR(G) + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011010"){
	    	 rt_head += "Pattern 25 : OIH + OAR(G) + THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011101"){
	    	 rt_head += "Pattern 26 : OIH + OAR(G) + THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011001"){
	    	 rt_head += "Pattern 27 : OIH + OAR(G) + THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011110"){
	    	 rt_head += "Pattern 28 : OIH + OAR(G) + THRU + DAR(G) + DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="011011"){
	    	 rt_head += "Pattern 29 : OIH + OAR(G) + THRU + DAR(G) + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110010"){
	    	 rt_head += "Pattern 30 : OIH(G) + OAR(G) + THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110101"){
	    	 rt_head += "Pattern 31 : OIH(G) + OAR(G) + THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110001"){
	    	 rt_head += "Pattern 32 : OIH(G) + OAR(G) + THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110110"){
	    	 rt_head += "Pattern 33 : OIH(G) + OAR(G) + THRU + DAR(G) +DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="110011"){
	    	 rt_head += "Pattern 34 : OIH(G) + OAR(G) + THRU + DAR(G) +DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="000010"){
	    	 rt_head += "Pattern 35 : THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="000101"){
	    	 rt_head += "Pattern 36 : THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="000001"){
	    	 rt_head += "Pattern 37 : THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="000110"){
	    	 rt_head += "Pattern 38 : THRU + DAR(G) + DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="000011"){
	    	 rt_head += "Pattern 39 : THRU + DAR(G) + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100010"){
	    	 rt_head += "Pattern 40 : OIH(G) + THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100101"){
	    	 rt_head += "Pattern 41 : OIH(G) + THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100001"){
	    	 rt_head += "Pattern 42 : OIH(G) + THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100110"){
	    	 rt_head += "Pattern 43 : OIH(G) + THRU + DAR(G) + DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="100011"){
	    	 rt_head += "Pattern 44 : OIH(G) + THRU + DAR(G) + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010010"){
	    	 rt_head += "Pattern 45 : OAR(G) + THRU + DAR(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010101"){
	    	 rt_head += "Pattern 46 : OAR(G) + THRU + DAR + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010001"){
	    	 rt_head += "Pattern 47 : OAR(G) + THRU + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010110"){
	    	 rt_head += "Pattern 48 : OAR(G) + THRU + DAR(G) + DIH"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd =="010011"){
	    	 rt_head += "Pattern 49 : OAR(G) + THRU + DAR(G) + DIH(G)"+
	 		    "\n" + "--------------------------------------------------------------------------------------------------------------" ; 
	     }  
	     
	     if(pt_cd.substr(0,3) == '100'){
	    	 rt_dtl += "\n" +'OIH : ' +sheetObj.CellValue(row,"oi_rout_pnt_loc_def_cd")+ ' - '+ sheetObj.CellValue(row,"oi_bse_port_def_cd")+ ' - ' + 
				                    sheetObj.CellValue(row,"oi_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oi_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oi_curr_cd")+' - '+ 
	                                sheetObj.CellValue(row,"oi_fnl_ihc_rt_amt") +' - ' + sheetObj.CellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oi_prc_cgo_tp_cd") ;
	     }
	     if(pt_cd.substr(0,3) == '010'){
	    	 rt_dtl += "\n" +'OAR : ' +sheetObj.CellValue(row,"oi_rout_pnt_loc_def_cd")+ ' - '+ sheetObj.CellValue(row,"oi_bse_port_def_cd")+ ' - ' + 
				                    sheetObj.CellValue(row,"oi_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oi_fdr_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oi_fdr_curr_cd")+' - '+ 
					                sheetObj.CellValue(row,"oi_fnl_fdr_rt_amt") +' - ' + sheetObj.CellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oi_prc_cgo_tp_cd") ;
	     }	  	     
	     if(pt_cd.substr(0,3)=='110'){
	    	 rt_dtl += "\n" +'OIH : ' +sheetObj.CellValue(row,"oi_rout_pnt_loc_def_cd")+ ' - '+ sheetObj.CellValue(row,"oi_via_port_def_cd")+ ' - ' + 
	    	 						sheetObj.CellValue(row,"oi_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oi_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oi_curr_cd")+' - '+ 
	    	 						sheetObj.CellValue(row,"oi_fnl_ihc_rt_amt") +' - ' + sheetObj.CellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oi_prc_cgo_tp_cd") ;
	    	 rt_dtl += "\n" +'OAR : ' +sheetObj.CellValue(row,"oi_via_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"oi_bse_port_def_cd")+ ' - ' + 
									'F'+' - ' + sheetObj.CellValue(row,"oi_fdr_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oi_fdr_curr_cd")+' - '+ 
									sheetObj.CellValue(row,"oi_fnl_fdr_rt_amt") +' - ' + sheetObj.CellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oi_prc_cgo_tp_cd") ;
	     }	     
	     if(pt_cd.substr(0,3)=='001'){
	    	 if(sheetObj.CellValue(row,"oih_flg") =="Y" && pt_cd.substr(0,1)==0){
	    		 rt_dtl+= "\n" +'OIH : '
	    	 }else{
	    		 rt_dtl+= "\n" +'OAR : '
	    	 }
	    	 rt_dtl+= sheetObj.CellValue(row,"oa_rout_pnt_loc_def_cd")+ ' - '+  sheetObj.CellValue(row,"oa_bse_port_def_cd")+' - ' + 
	    	 						sheetObj.CellValue(row,"oa_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oa_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oa_curr_cd")+' - '+ 
	    	 						sheetObj.CellValue(row,"oa_fnl_frt_rt_amt") +' - ' + sheetObj.CellValue(row,"oa_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oa_prc_cgo_tp_cd") ;	 
	     }
	     if(pt_cd.substr(0,3)=='101'){
	    	 rt_dtl += "\n" +'OIH : ' +sheetObj.CellValue(row,"oi_rout_pnt_loc_def_cd")+ ' - '+ sheetObj.CellValue(row,"oi_via_port_def_cd")+ ' - ' + 
                                    sheetObj.CellValue(row,"oi_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oi_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oi_curr_cd")+' - '+ 
                                    sheetObj.CellValue(row,"oi_fnl_ihc_rt_amt") +' - ' + sheetObj.CellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oi_prc_cgo_tp_cd") ;
	    	 rt_dtl += "\n" + 'OAR : ' + sheetObj.CellValue(row,"oi_via_port_def_cd")+ ' - '+  sheetObj.CellValue(row,"oa_bse_port_def_cd")+' - ' + 
				                    sheetObj.CellValue(row,"oa_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oa_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oa_curr_cd")+' - '+ 
					                sheetObj.CellValue(row,"oa_fnl_frt_rt_amt") +' - ' + sheetObj.CellValue(row,"oa_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oa_prc_cgo_tp_cd") ;
	     }

	     if(pt_cd.substr(0,3)=='011'){
	    	 rt_dtl+= "\n" +'OIH : '+ sheetObj.CellValue(row,"oa_rout_pnt_loc_def_cd")+ ' - '+  sheetObj.CellValue(row,"oi_via_port_def_cd")+' - ' + 
				                   sheetObj.CellValue(row,"oa_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oa_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oa_curr_cd")+' - '+ 
				                   sheetObj.CellValue(row,"oa_fnl_frt_rt_amt") +' - ' + sheetObj.CellValue(row,"oa_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oa_prc_cgo_tp_cd") ;	 

	    	 rt_dtl += "\n" +'OAR : ' +sheetObj.CellValue(row,"oi_via_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"oi_bse_port_def_cd")+ ' - ' + 
				                    'F'+' - ' + sheetObj.CellValue(row,"oi_fdr_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oi_fdr_curr_cd")+' - '+ 
				                    sheetObj.CellValue(row,"oi_fnl_fdr_rt_amt") +' - ' + sheetObj.CellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oi_prc_cgo_tp_cd") ;
	     }
	     
	     /* Through Rate */    	
	     rt_dtl += "\n" +	'THR : '+ sheetObj.CellValue(row,"op_rout_pnt_loc_def_cd")+' - '+ sheetObj.CellValue(row,"ov_rout_via_port_def_cd")+' - '+
	     							sheetObj.CellValue(row,"dv_rout_via_port_def_cd")+' - '+ sheetObj.CellValue(row,"dp_rout_pnt_loc_def_cd") +' - '+ 
	     							sheetObj.CellValue(row,"op_prc_trsp_mod_cd")+'/'+sheetObj.CellValue(row,"dp_prc_trsp_mod_cd")+' - '+
	     						 	sheetObj.CellValue(row,"rt_rcv_term_cd") + '/' + sheetObj.CellValue(row,"rt_de_term_cd") + ' - ' +
	     						 	sheetObj.CellValue(row,"curr_cd")+' - '+ sheetObj.CellValue(row,"rt_fnl_frt_rt_amt")+' - '+ 
	     						 	sheetObj.CellValue(row,"rt_rat_ut_cd")+' - '+ sheetObj.CellValue(row,"rt_prc_cgo_tp_cd") ;


	     if(pt_cd.substr(3,3) == '001'){
	    	 rt_dtl += "\n" +'DIH : ' +sheetObj.CellValue(row,"di_bse_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"di_rout_pnt_loc_def_cd")+ ' - ' + 
				sheetObj.CellValue(row,"di_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"di_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"di_curr_cd")+' - '+ 
				sheetObj.CellValue(row,"di_fnl_ihc_rt_amt") +' - ' + sheetObj.CellValue(row,"di_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"di_prc_cgo_tp_cd") ;
	     }
	     if(pt_cd.substr(3,3) == '010'){
	    	 rt_dtl += "\n" +'DAR : ' +sheetObj.CellValue(row,"di_bse_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"di_rout_pnt_loc_def_cd")+ ' - ' + 
				sheetObj.CellValue(row,"di_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"di_fdr_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"di_fdr_curr_cd")+' - '+ 
				sheetObj.CellValue(row,"di_fnl_fdr_rt_amt") +' - ' + sheetObj.CellValue(row,"di_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"di_prc_cgo_tp_cd") ;
	     }
	     if(pt_cd.substr(3,3) == '011'){
	    	 rt_dtl += "\n" +'DAR : ' +sheetObj.CellValue(row,"di_bse_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"di_via_port_def_cd")+ ' - ' + 
									'F'+' - ' + sheetObj.CellValue(row,"di_fdr_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"di_fdr_curr_cd")+' - '+ 
									sheetObj.CellValue(row,"di_fnl_fdr_rt_amt") +' - ' + sheetObj.CellValue(row,"di_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"di_prc_cgo_tp_cd") ;
	    	 rt_dtl += "\n" +'DIH : ' +sheetObj.CellValue(row,"di_via_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"di_rout_pnt_loc_def_cd")+ ' - ' + 
				sheetObj.CellValue(row,"di_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"di_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"di_curr_cd")+' - '+ 
				sheetObj.CellValue(row,"di_fnl_ihc_rt_amt") +' - ' + sheetObj.CellValue(row,"di_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"di_prc_cgo_tp_cd") ;
	     }
	     if(pt_cd.substr(3,3) == '100'){
	    	 if(sheetObj.CellValue(row,"dih_flg") == "Y" && pt_cd.substr(5,1) == 0){
	    		 rt_dtl+= "\n" +'DIH : '
	    	 }else{
	    		 rt_dtl+= "\n" +'DAR : '
	    	 }
	    	 rt_dtl+= sheetObj.CellValue(row,"da_bse_port_def_cd")+ ' - ' + sheetObj.CellValue(row,"da_rout_pnt_loc_def_cd")+' - ' + 
	    	 						sheetObj.CellValue(row,"da_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"da_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"da_curr_cd")+' - '+ 
	    	 						sheetObj.CellValue(row,"da_fnl_frt_rt_amt")+' - '+ sheetObj.CellValue(row,"da_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"da_prc_cgo_tp_cd");
	     }
	     if(pt_cd.substr(3,3) == '101'){
		     rt_dtl += "\n" +'DAR : '+sheetObj.CellValue(row,"da_bse_port_def_cd")+ ' - ' + sheetObj.CellValue(row,"di_via_port_def_cd")+' - ' + 
				sheetObj.CellValue(row,"da_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"da_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"da_curr_cd")+' - '+ 
					sheetObj.CellValue(row,"da_fnl_frt_rt_amt")+' - '+ sheetObj.CellValue(row,"da_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"da_prc_cgo_tp_cd");
	    	 rt_dtl += "\n" +'DIH : ' +sheetObj.CellValue(row,"di_via_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"di_rout_pnt_loc_def_cd")+ ' - ' + 
				sheetObj.CellValue(row,"di_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"di_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"di_curr_cd")+' - '+ 
				sheetObj.CellValue(row,"di_fnl_ihc_rt_amt") +' - ' + sheetObj.CellValue(row,"di_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"di_prc_cgo_tp_cd") ;
	     }
	     if(pt_cd.substr(3,3) == '110'){
	    	 rt_dtl+= "\n" +'DAR : ' +sheetObj.CellValue(row,"di_bse_port_def_cd")+ ' - '+ sheetObj.CellValue(row,"di_via_port_def_cd")+ ' - ' + 
				'F'+' - ' + sheetObj.CellValue(row,"di_fdr_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"di_fdr_curr_cd")+' - '+ 
				sheetObj.CellValue(row,"di_fnl_fdr_rt_amt") +' - ' + sheetObj.CellValue(row,"di_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"di_prc_cgo_tp_cd") ;
	    	 rt_dtl += "\n" +'DIH : ' +sheetObj.CellValue(row,"di_via_port_def_cd")+ ' - ' + sheetObj.CellValue(row,"da_rout_pnt_loc_def_cd")+' - ' + 
				sheetObj.CellValue(row,"da_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"da_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"da_curr_cd")+' - '+ 
				sheetObj.CellValue(row,"da_fnl_frt_rt_amt")+' - '+ sheetObj.CellValue(row,"da_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"da_prc_cgo_tp_cd");
	     }
	     
	     typ_conv  = typ_head + oa_typ_conv + oi_typ_conv + rt_typ_conv + da_typ_conv + di_typ_conv ;
	     
		 fnl = "\n" +	"=================================================" + "\n" +	" FINAL : USD " + fnl_amount  
		  
		  // 연산기호가 인코딩 되지 않아 encodeURIComponent 처리 함
		  rt_string += encodeURIComponent(dtl_title + rt_head + rt_dtl + typ_conv + rt_rar_conv + rt_rac_conv + rt_rap_conv + rt_dor_conv + rt_ras_conv + fnl) ;
		  
		  
	  	  value = dtl_title + '$$' + rt_string;

	  	  return value ;
	     
	}
	    
	    
	    /**
	     * Combobox select 리스트 
	     * @param vCombo  : SELECT 박스 위치 ID값
	     * @param vCode	 :  list 생성 목록 
	     * @param vSelected : 초기 선택값 
	     * @return
	     */
	    function fnSetComboBox(vCombo, vCode, vSelected) {
	    	var _spr = "^"; // 구분값
	    	var obj = eval("document.all." + vCombo); // SELECT 박스 위치 ID값
	    	for ( var i = obj.length - 1; i >= 0; i--)
	    		obj[i] = null; // 초기화
	    	try {
	    		var result = vCode;
	    		if (result != "ERR" && result != "^") {
	    			var aList = result.split(_spr);
	    			var aCode, aName;
	    			var aCode = aList[0].split("$");
	    			var aName = aList[1].split("$");
	    			var optioncnt = obj.options.length;
	    			var codeindex = 0;
	    			for ( var j = optioncnt; j < aCode.length + optioncnt; j++) {
	    				obj.options[j] = new Option();
	    				obj.options[j].text = aName[codeindex];
	    				obj.options[j].value = aCode[codeindex];
	    				if (vSelected == aCode[codeindex]) {
	    					obj.options[j].selected = true;
	    				}
	    				++codeindex;
	    			}
	    		}

	    	} catch (ex) {
	    		fnBkgErrorAlert('fnSetComboBox', ex);
	    	}
	    }
	    
	    /* Commodity 에 Code 만 넣고 조회시 Rep Cmdt 까지 가져옴 */
	    function searchCmdt(cmdt){
	  	 
	  	  var formObj  = document.form;
	  	  var sheetObj = sheetObjects[0];

	  	  if( ComTrim(formObj.frm_cmdt_cd.value) == "" || formObj.frm_cmdt_cd.value.length == 0){
	  		  formObj.frm_cmdt_nm.value ="";
	  		  formObj.frm_rep_cmdt_cd.value = "";
	  		  formObj.frm_rep_cmdt_nm.value = "";
	  		  formObj.frm_cmdt_cd.value = "";
	  		  ComShowCodeMessage("BKG00010");// Message 
	  		  return;
	  	  }else{
	  		  if(formObj.frm_cmdt_cd.value.length<6){
	  			  ComSetObjValue(formObj.frm_cmdt_cd, ComLpad(formObj.frm_cmdt_cd.value,6,"0"));
	  		  }
	  	  }

	  	  formObj.f_cmd.value = SEARCH02;   
	  	  
	  	  var searchXml = sheetObj.GetSearchXml("ESM_BKG_0269GS.do" , FormQueryString(formObj));
	  	  if(!ComIsNull(ComGetEtcData(searchXml,"cmdtnm"))){
	  		 formObj.frm_cmdt_nm.value = ComGetEtcData(searchXml,"cmdtnm");
	  		 formObj.frm_rep_cmdt_cd.value = ComGetEtcData(searchXml,"repcmdtcd");
	  		 formObj.frm_rep_cmdt_nm.value = ComGetEtcData(searchXml,"repcmdtnm");
	  		 doActionIBSheet(sheetObjects[1], formObj, SEARCH02);
	  	  }else{
	  		  formObj.frm_cmdt_nm.value ="";
	  		  formObj.frm_rep_cmdt_cd.value = "";
	  		  formObj.frm_rep_cmdt_nm.value = "";
	  		  ComShowCodeMessage("BKG00010");
			  return;
	  	  }

	    }
	    
	    
	    
	    
	    
	    
	    
	    /**
	     * RFA Commodity Popup후 Return받는 함수. <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     callBack0656(arrBal);
	     * </pre>
	     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
	     * @return 없음
	     * @author 김병규
	     * @version 2009.05.14
	     */    
	    function callBack0656(arrVal){
	    	var formObj = document.form;

	    	if(arrVal != null){		
	    		if(arrVal[0][6] =="0000" && arrVal[0][4] == "000004"){
	    			ComOpenPopup("ESM_BKG_0653.do", 820, 690, 'callBack0653',"1,0,1,1,1,1", true,false,0,0,0,'callBack0653');
	    		} else if(arrVal[0][6] == "0000"||arrVal[0][1]=="000000"||arrVal[0][6] == "9901"||arrVal[0][6] == "REP"){
	    			ComOpenPopup("ESM_BKG_0653.do", 820, 690, 'callBack0653',"1,0,1,1,1,1", true,false,0,0,0,'callBack0653');
//	    			comBkgCallPop0653('callBack0653',"","");
//	    		} else if(arrVal[0][3] == "REP"){
//	    			comBkgCallPop0653('callBack0653',"",arrVal[0][1]);					
	    		} else {
					ComSetObjValue(formObj.frm_cmdt_cd,arrVal[0][4]);
					ComSetObjValue(formObj.frm_cmdt_nm, arrVal[0][2]);
					ComSetObjValue(formObj.frm_rep_cmdt_cd, arrVal[0][6]);
					doActionIBSheet(sheetObjects[1], formObj, SEARCH02);
	    		}
	    	}
	    }         
	     
	   
	   /**
	    * CMDT 화면 호출후 Return받는 함수. <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     callBack00653(arrBal);
	    * </pre>
	    * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
	    * @return 없음
	    * @author 김태경
	    * @version 2009.11.25
	    */    
	 	function callBack0653(arrVal){
	   	 var formObj = document.form;
	   	 		if(arrVal != null){				
	 				ComSetObjValue(formObj.frm_cmdt_cd, arrVal[0][3]);
	 				ComSetObjValue(formObj.frm_rep_cmdt_cd, arrVal[0][5]);
	 				ComSetObjValue(formObj.frm_cmdt_nm, arrVal[0][4]);	
	 				doActionIBSheet(sheetObjects[1], formObj, SEARCH02);
	 			}
	 	}     
	   	
	
/* 개발자 작업  끝 */