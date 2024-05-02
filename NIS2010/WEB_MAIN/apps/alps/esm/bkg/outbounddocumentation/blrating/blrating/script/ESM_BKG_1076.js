/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1076.js
 *@FileTitle : TAA Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.27
 *@LastModifier : 김태경
 *@LastVersion : 1.0
 * 2009.06.26 김태경
 * 1.0 Creation
=========================================================*/
/* History
 * 2010.09.02 김태경 [CHM-201005462-01] BL Type에 대한 OFT 발생시 Autorating 변경 요청, Note Conversion encoding 추가
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.11.29 조정민 [CHM-201221300] TAA 계약 존재시 bkg 생성및 변경시점 Rate 유무 체크 및 G/W 연계 요청
 * 2013.05.13 김진주 [CHM-201324625] s/c information 창 오류
 * 2013.07.22 김진주 [CHM-201325778] Charge 화면의 TRI No. 자동 반영 요청
 * 2013.10.28 김진주 [CHM-201326965] Split 01-SURCHARGE 및 오토레이팅 보완 관련 CSR(Hide Flag)
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
 * @class esm_bkg_1076 : esm_bkg_1076 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1076() {
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
var URL_ESM_BKG = 'ESM_BKG_1076GS.do';

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
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	//날짜 셋팅
	var formObject = document.form;
	var rCntr_cdr_dt = formObject.application_date.value.substr(0,4)+'-'+formObject.application_date.value.substr(4,2)+'-'+formObject.application_date.value.substr(6,2) ;		
	ComSetObjValue(formObject.frm_cntr_cdr_dt, rCntr_cdr_dt);
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

var ee_arr = [82,76,65,88,79,82,85,68];
var ee_idx = 0;
function initControl() {
	var formObj = document.form;
	axon_event.addListener('keydown', 'easteregg', 'form'); //- 키보드 입력할때
}
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
			var headCount = 29;

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
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "taa_no"); // rtaa_no 를 수정
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "srep_eml");
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

			var HeadTitle1 = " |PT|Commodity Description|POR|POL|POD|DEL|R/D|Per|CGO\nTP|SOC|Cur|Amount|Trans Mode\n(O/D)|Q’TY|Rate\nDetail |Route\nNote |";
			var headCount = 123;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			/* UI GRID START */    
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false, "_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "rt_mtch_patt_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "por_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pol_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "del_cd", false, "", dfNone, 0, false);
						
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rcv_de_term_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "soc_flg", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "curr_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "trns_mod_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 45, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dtl", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "note", false, "", dfNone, 0, false);					
			/* UI GRID END */              
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ctrt_no", false, "", dfNone, 0, false );	
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "prc_rt_mtch_patt_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "calc_ctrt_tp_cd", false, "", dfNone, 0, false );
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
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "da_add_chg_seq", false, "", dfNone, 0, false );        
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cm_prc_cmdt_tp_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cm_prc_cmdt_def_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rcv_term_cd", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "de_term_cd", false, "", dfNone, 0, false );
			
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
			
			/* ori arb */                              
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rout_pnt_loc_def_cd",    false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_bse_port_def_cd",        false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_via_port_def_cd",        false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_dir_call_flg",           false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rat_ut_cd",              false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_prc_cgo_tp_cd",          false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_prc_trsp_mod_cd",        false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rcv_de_term_cd",         false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_prc_cmdt_def_cd",        false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_curr_cd",                false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_fnl_frt_rt_amt",         false, "", dfNullFloat, 2, false);
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_bkg_conv_tp_cd"      , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_note_conv_seq"       , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_note_conv_rule_cd"   , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_note_conv_tp_cd"     , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_rt_op_cd"            , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_curr_cd"             , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_frt_rt_amt"          , false, "", dfNullFloat, 2, false);
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_bkg_conv_tp_cd"      , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_note_conv_seq"       , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_note_conv_rule_cd"   , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_note_conv_tp_cd"     , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_rt_op_cd"            , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_curr_cd"             , false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_frt_rt_amt"          , false, "", dfNullFloat, 2, false);
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "por_mtch_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "del_mtch_flg", false, "", dfNone, 0, false );
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oih_flg", false, "", dfNone, 0, false );	
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dih_flg", false, "", dfNone, 0, false );
			
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "bkg_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_gen_spcl_rt_tp_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_cmdt_hdr_seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_rout_seq", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, true, "prc_rt_seq", false, "", dfNone, 0, false);
		
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "tri_prop_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "tri_no", false, "", dfNone, 0, false);
			/* note conversion detail  */
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "note_ctnt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_typ_conv_ctnt", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_typ_conv_ctnt"          , false, "", dfNone, 0, false);		
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_rac_conv_ctnt"          , false, "", dfNone, 0, false);	
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rt_calc_frt_rt_amt"          , false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oa_calc_frt_rt_amt"          , false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "dp_seq"          , false, "", dfNone, 0, false);
			
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "eq_subst_cntr_tpsz_cd"          , false, "", dfNone, 0, false);
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			MultiSelection = false;
			SelectHighLight = true;
			CountPosition = 0;

		}
		break;
	case "sheet4": //Surcharge
		with (sheetObj) {

			// 높이 설정
			style.height = 162;
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
			style.height = 162;
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
			var headCount = 33;
	
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
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "chg_amt",	  false, "", dfNone, 0, false);
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
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "tri_prop_no" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "tri_no" ,false , "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_subst_cntr_tpsz_cd"          , false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "incl_oft_flg",	  false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			
			MultiSelection = false;
			SelectHighLight = true;
			CountPosition = 0;

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
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			doActionIBSheet(sheetObject1, formObject, SEARCH06);
			break;
			
		case "btn_Select":
			/* 
			 * Select 버튼 클릭시 로직 
			 * 1. Multi Rate 기능
			 * 2. QTY Validation
			 * 3. Surcharge 구하기
			 * 4. Charge 화면에 Data setting
			 */
				//1. Multi Rate 기능
				//1. validation 체크  TP/SZ TYPE의 갯수 확인 
				var rArray	 = new Array();
				var formObj	 = document.form;
				var sheetObj0 = sheetObjects[0];
				var sheetObj1 = sheetObjects[1];
				var sheetObj3 = sheetObjects[3];
				var sheetObj4 = sheetObjects[4];
				var sheetObj5 = sheetObjects[5];
			
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
									&& tCgo == sheetObj3.CellValue(ix,"cgo_tp_cd")
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
					 * RFA 와 TAA 는 무조건 Break Down 기능 적용 
				 	 * */
				 
				 	sheetObj5.RemoveAll();// 시트 초기화 해줌
					/* 6. Charge 화면에 Data setting( 3번 기능 과 6번 기능 script 가 섞여 있음)
					 *    Charge 화면에 OFT 셋팅 로직에  Break Down 기능 추가
					 */ 
					var idx = 0;
					for ( var ix = 1; ix <= cnt3_row; ix++) {
						if (sheetObj3.CellValue(ix,"_flg") == 1){
							
							var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
							var obj		= new Object(); // 값셋팅 
								obj.charge	= 'OFT';
								obj.cur		= sheetObj3.CellValue(ix, "curr_cd");
								obj.rate	= sheetObj3.CellValue(ix, "rt_calc_frt_rt_amt");
								obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
								obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
								obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
								obj.soc 	= sheetObj3.CellValue(ix, "soc_flg");
								obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") +"/"+ sheetObj3.CellValue(ix,"de_term_cd");
								obj.term_cd = formObj.term_cd.value;
								obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
								obj.trino = sheetObj3.CellValue(ix,"tri_no");
								/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,4);
								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
								obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
								
								obj.incl	= 'N';
								obj.m		= 'A';
								/* 2010.03.31 TP/SZ Charge 화면으로 넘겨줌(per type 이 20,40,BL 인 경우가 있어서.. */
								obj.rat_ut2_cd = sheetObj3.CellValue(ix, "cntr_tpsz_cd");
								obj.rat_ut3_cd = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd");
								rArray[idx++] = obj;

								//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
								sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OFT'; 
								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "curr_cd"	        );
								sheetObj5.CellValue(newRow, "chg_ut_amt"	   ) = sheetObj3.CellValue(ix, "rt_calc_frt_rt_amt"	    );   
								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	    );     
								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        );    
								sheetObj5.CellValue(newRow, "chg_amt"	       ) = sheetObj3.CellValue(ix, "rt_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");
								sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	        );     
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
								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");    
								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"   );    
								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"       );    
								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"        );    
								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"         );   
								sheetObj5.CellValue(newRow, "fnl_frt_rt_amt"       ) = sheetObj3.CellValue(ix, "fnl_frt_rt_amt"     );
								sheetObj5.CellValue(newRow, "tri_prop_no"          ) = sheetObj3.CellValue(ix, "tri_prop_no"        );
								sheetObj5.CellValue(newRow, "tri_no"               ) = sheetObj3.CellValue(ix, "tri_no"             );
								/* POL, DEL Match 로직 */
								sheetObj5.CellValue(newRow, "por_mtch_flg"		   ) = sheetObj3.CellValue(ix, "por_mtch_flg"       );
								sheetObj5.CellValue(newRow, "del_mtch_flg"		   ) = sheetObj3.CellValue(ix, "del_mtch_flg"       );
								
								sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd") = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd");
							
								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
								
								
							
							var comp1_cd =  sheetObj3.CellValue(ix,"rat_ut_cd");
							
							//부족분 채우기 
//							for ( var p = 0; p < pArray.length; p++) {
//								var comp2_cd =  pArray[p].tpsz_cd;
//								var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
//								if(comp1_cd == comp2_cd){
//									var obj		= new Object();// 값셋팅 
//									obj.charge	= 'OFT';
//									obj.cur		= sheetObj3.CellValue(ix, "curr_cd");
//									obj.rate	= 0.00;
//									obj.rate_as	= pArray[p].tpsz_qty;
//									obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
//									obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
//									obj.term	= sheetObj3.CellValue(ix,"rcv_term_cd") +"/"+ sheetObj3.CellValue(ix,"de_term_cd");
//									obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
//									obj.m		= 'A';
//									
//									/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
//									obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,4);
//									obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
//									obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
//									obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
//									
//									
//									//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
//									sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OFT'; 
//									sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "curr_cd"	        );
//									sheetObj5.CellValue(newRow, "chg_ut_amt"	   	   ) = 0.00;   
//									
//									sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
//									sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        );     
//									sheetObj5.CellValue(newRow, "chg_amt"	           ) =  0 ;       
//	     
//									sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    );     
//									sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	        );     
//									sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    );     
//									sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        );     
//									sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    );     
//	     
//									sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        );     
//									sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    );     
//									sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"	);     
//									sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        );    
//									sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        );    
//									sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        );     
//									sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        );     
//									sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        );     
//									sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        );     
//									sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
//									sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
//									sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
//									sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
//									sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
//									sheetObj5.CellValue(newRow, "fnl_frt_rt_amt"       ) = sheetObj3.CellValue(ix, "fnl_frt_rt_amt"         );
//									sheetObj5.CellValue(newRow, "tri_prop_no"          ) = sheetObj3.CellValue(ix, "tri_prop_no"             );
//									
//									/* POL, DEL Match 로직 */
//									sheetObj5.CellValue(newRow, "por_mtch_flg"		   ) = sheetObj3.CellValue(ix, "por_mtch_flg"         );
//									sheetObj5.CellValue(newRow, "del_mtch_flg"		   ) = sheetObj3.CellValue(ix, "del_mtch_flg"         );
//									
//									/* POL, DEL Match 로직 */
//									sheetObj5.CellValue(newRow, "por_mtch_flg"		   ) = sheetObj3.CellValue(ix, "por_mtch_flg"         );
//									sheetObj5.CellValue(newRow, "del_mtch_flg"		   ) = sheetObj3.CellValue(ix, "del_mtch_flg"         );
//									sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   	
//									
//									rArray[idx++] = obj;
//								}
//							}
							
							

							if(sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,1) == 1){
								if(sheetObj3.CellValue(ix,"oa_fnl_frt_rt_amt") !='0' || 
										(sheetObj3.CellText(ix,"rt_arb_rt_appl_tp_cd") == 'F' && sheetObj3.CellValue(ix,"rt_arb_frt_rt_amt") !='0')){ // 2010.05.17 김미선 차장님 요청 BreakDown 시 금액이 0 값이 있을경우 표시하지 않음
									var newRow = sheetObj5.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
					 				var obj		= new Object();// 값셋팅 
					 				obj.charge	= 'OAR';
					 				obj.cur		= sheetObj3.CellValue(ix, "oa_curr_cd");
					 				obj.rate	= sheetObj3.CellValue(ix, "oa_calc_frt_rt_amt");
					 				obj.rate_as	= sheetObj3.CellValue(ix, "op_cntr_qty");
					 				obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
					 				obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
					 				obj.soc 	= sheetObj3.CellValue(ix, "soc_flg");
					 				obj.term	= sheetObj3.CellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.CellValue(ix, "de_term_cd");
		//			 				obj.term_cd = sheetObj1.CellValue(1,  "frt_term_cd");
					 				obj.term_cd = formObj.term_cd.value;
									obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
					 				obj.incl	= 'N';
					 				obj.m		= 'A';
					 				obj.amt		= sheetObj3.CellValue(ix, "oa_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty")


									/* Charge 화면에서 Note 볼수 있도록 OFT 에서 값을 넘겨줌 */
									obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,4);
									obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
									obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
									obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
									obj.calcCtrtTp	= sheetObj3.CellValue(ix, "calc_ctrt_tp_cd");
					 				rArray[idx++] = obj;
					 				
					 				//Surcharge 에서 사용 할수 있도록  Sheet5번에 Break Down 되는 data를 셋팅함 
					 				sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OAR'; 
									sheetObj5.CellValue(newRow, "curr_cd"	       ) = sheetObj3.CellValue(ix, "oa_curr_cd"	        );
									sheetObj5.CellValue(newRow, "chg_ut_amt"	       ) = sheetObj3.CellValue(ix, "oa_fnl_frt_rt_amt"	);   
									sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
									sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        );     
									sheetObj5.CellValue(newRow, "chg_amt"	           ) = sheetObj3.CellValue(ix, "oa_fnl_frt_rt_amt") * sheetObj3.CellValue(ix, "op_cntr_qty");
									sheetObj5.CellValue(newRow, "incl_oft_flg"	       ) = 'N';     
									sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    );     
									sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"        );     
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
									sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");    
									sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"   );    
									sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"       );    
									sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"        );    
									sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"         );   
									sheetObj5.CellValue(newRow, "fnl_frt_rt_amt"       ) = sheetObj3.CellValue(ix, "fnl_frt_rt_amt"     );
									
									/* POL, DEL Match 로직 */
									sheetObj5.CellValue(newRow, "por_mtch_flg"		   ) = sheetObj3.CellValue(ix, "por_mtch_flg"         );
									sheetObj5.CellValue(newRow, "del_mtch_flg"		   ) = sheetObj3.CellValue(ix, "del_mtch_flg"         );
									
									sheetObj5.CellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ) = sheetObj3.CellValue(ix, "eq_subst_cntr_tpsz_cd"         );
									sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   
								}
							}
						}
					}
				
				 
				//POR_MTCH, DEL_MTCH 추가

				for( var j = 1; j <= cnt3_row; j++){
					if(sheetObj3.CellValue(j, "_flg") == 1){
						if(sheetObj3.CellValue(j, "por_mtch_flg") == "N" && sheetObj3.CellValue(j,"rt_mtch_patt_cd").substr(1,1) != 1 ){
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
							obj.imo		= sheetObj3.CellValue(j, "imdg_clss_cd");
							obj.m		= 'A';
							rArray[idx++] = obj;

						}
						if(sheetObj3.CellValue(j, "del_mtch_flg") =="N"){
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
							obj.imo		= sheetObj3.CellValue(j, "imdg_clss_cd");
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
					/* 해당 로직 제거 무조건 적용 2010.04.13 김태경*/
//					if(sheetObj4.CellValue(i,"rat_ut_cd") =="PC"){
//						obj.amt = sheetObj4.CellValue(i,"chg_amt");
//					}
					obj.amt = sheetObj4.CellValue(i,"chg_amt");
					obj.cargo	= sheetObj4.CellValue(i,"cgo_tp_cd");
					obj.incl	= sheetObj4.CellValue(i,"incl_oft_flg");
					obj.term_cd	= sheetObj4.CellValue(i,"frt_term_cd");
					obj.term    = sheetObj4.CellValue(i,"rcv_term_cd") +"/"+ sheetObj4.CellValue(i,"de_term_cd");
					obj.imo		= sheetObj4.CellValue(i,"imdg_clss_cd");
					obj.incl    = sheetObj4.CellValue(i,"frt_incl_xcld_div_cd");
					obj.hdn		= sheetObj4.CellValue(i,"prn_hdn_flg");
					obj.m		= 'A';
					rArray[idx++] = obj;
				}
				
				//7. TAA No를 Charge 화면으로 넘겨줌
				for ( var ix = 1; ix <= cnt3_row; ix++) {
					if (sheetObj3.CellValue(ix,"_flg") == 1){
						var _obj = new Object(); //값 셋팅
						_obj.actionType	= "TAA_No";
						_obj.tripropno = sheetObj3.CellValue(ix,"tri_prop_no");
						rArray[idx++] = _obj;
					}
				}
				
				window.returnValue = rArray ;//retVal 변수값 설정.				 		 
				self.close();
				
			break;

		case "btn_Close":
			if(formObject.is_bkg.value == "Y" && formObject.chk_oft.value == 'N'){

				ComShowCodeMessage("BKG02205","TAA");
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

				var subject = "[Warning message] No applicable rate in [" + formObject.taa_no.value + "] - " + formObject.bkg_no.value;
				var contents    = "<br>TO : Sales Rep." +
				  				  "<br><br>Update applicable TRI rate through the TAA amendment before cargo receiving date to avoid any FMC violation<br><br>" + 
								  "BKG No : " + formObject.bkg_no.value + "<BR>" +						
								  "BKG Route : " + formObject.frm_bkg_por_cd.value + " / " + 
								  formObject.frm_bkg_pol_cd.value + " / " + 
								  formObject.frm_bkg_pod_cd.value + " / " + 
								  formObject.frm_del_cd.value + "<BR>" +						
								  "TAA No : " + formObject.taa_no.value + "<BR>" +						
								  "Type/Size : " + cntrInfo + "<BR>" +						
								  "Commodity Code : " + formObject.frm_cmdt_cd.value + "<BR>" +
								  "Sales Rep : " + formObject.srep_eml.value;
				
				if(formObject.ob_srep_eml.value != "")
					contents = contents + "<BR>" + "Loading Rep : " + formObject.ob_srep_eml.value;
				
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
				
				
		        ComSetObjValue(formObject.gw_subject,subject);
//		        ComSetObjValue(formObj.gw_contents,contents);
		        formObject.gw_contents.value = contents;
				ComOpenGroupwareMail(sheetObjects[0], formObject);

				window.close();
			}else {			
				
				var idx = 0;
				var formObj = document.form;
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
			}
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert("지금은 사용하실 수가 없습니다 ");
			bkg_error_alert(e);
		} else {
			alert(e);
			bkg_error_alert(e);
		}
	}
}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
	
		switch (sAction) {
	
		case IBSEARCH: //조회1
				try{
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true); // 대기창 보임
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
			try{
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				// Parameter 로 넘겨준 스콥으로  AutoRating 한다 2010.04.26 김태경
				if(formObj.set_svc_scp_cd.value != "")
					ComSetObjValue(formObj.svc_scp_cd, ComGetObjValue(formObj.set_svc_scp_cd));
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
			
		case IBSAVE: // Surcharge 를 위해서 임시테이블에 저장
			
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = MULTI;
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); // 대기창 보임
			
//			var sParam = ComGetSaveString(sheetObjects[3]);
			var sParam = ComGetSaveString(sheetObjects[5]);
			sParam += "&" + FormQueryString(formObj);
	
			var SaveXml = sheetObj.GetSaveXml("ESM_BKG_1076GS.do", sParam);
			var sheetObject4 = sheetObjects[4];
			sheetObjects[4].LoadSaveXml(SaveXml);
					
			break;
		
			
		case SEARCH03: //Close 버튼을 눌렀을 경우 Surcharge 만 값 적용 

			if(!validateForm(sheetObj,formObj,sAction)) return;
		
			formObj.f_cmd.value = SEARCH03;
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); // 대기창 보임
			
			sParam += "&"+ FormQueryString(formObj);
			var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0739GS.do", sParam);
			var sheetObject4 = sheetObjects[4];
		    sheetObjects[4].LoadSaveXml(SaveXml);
		
			break;	
			
		case SEARCH06:
			var param = "f_cmd=" + sAction + "&bl_no=" + ComGetObjValue(formObj.bkg_no) + "&taa_no=" + ComGetObjValue(formObj.taa_no)
			 + "&ca_flg=" + ComGetObjValue(formObj.ca_flg) + "&frm_svc_scp_cd=" + ComGetObjValue(formObj.frm_svc_scp_cd);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0269GS.do", param);
			formObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
			

			break;	
		}
		ComOpenWait(false); //대기창 사라짐 
	}

	/**
	 * Sheet 조회완료 후 이벤트 발생
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	 	var formObj = document.form;
		var c_row = sheetObj.LastRow;
		with (sheetObj) {
			for ( var row = 1; row <= c_row; row++) {
				if(sheetObj.cellvalue(row, "nt") != ''){
					sheetObj.CellFontColor(row,"nt_v") = sheetObj.RgbColor(255, 0, 0);
				}
			}
		}
	}
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
		  if(sheetObj.ColSaveName(col) == "note"){
			  if(sheetObj.CellValue(row,"note_ctnt") == '' ) return;
			  
			  var param = "?title="+"NOTE CONV"+"&text="+encodeURIComponent(note_ctnt);
			  ComOpenPopup('/hanjin/ESM_BKG_0988.do'+param, 550, 335, 'NOTE CONV', '0,0', true);
		  }
	}
 
	/*
	 * 조회후  이벤트 처리 >>> 폰트 칼라변경 
	 */ 
	 function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		 with(sheetObj)
		 	var redColor = RgbColor(255, 0, 0);
		 	var LastRow = sheetObjects[3].LastRow;
		 	var formObj = document.form;
		 	
			for(var i= 1; i <= LastRow; i++){
				
				 var note = sheetObj.CellValue(i, "note_ctnt");
				 if (!note.length == 0)
				 {		sheetObj.CellValue(i,"note") = "Y";
						sheetObj.CellFontColor(i,16)= redColor;
//						sheetObj.CellFont("FontItalic", i,16) = true;				 
				 }else{
					 sheetObj.CellValue(i,"note") = "N";
				 }
			}
		 	pageMaxCnt = sheetObj.LastRow;
		 	LastRow = 0;
		 	// DP_SEQ 에 따라 Sort 한다
			sheetObj.ColumnSort("dp_seq");
	 }
	/**
	 * getSelectedRow
	 * 선택한 row의 값을 넘겨준다. 
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
			bkg_error_alert(e);
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
	     var chg_row1 = "\n" + "=================================================";
	  	 var chg_row2 = "\n" + "--------------------------------------------------------------------------------------------------------------";
	  	 var chg_row3 = "\n" + "=================================================";
	  	 var sheetObj3 = sheetObjects[3];

	     pt_cd = sheetObj.CellValue(row, "rt_mtch_patt_cd"); //PT TYPE
	     
	     fnl_amount = sheetObj.CellText(row,"fnl_frt_rt_amt"); //FINAL AMOUNT
	     
	     /* TYPE CONVERSION */
		  if(sheetObj.CellValue(row,"rt_typ_conv_ctnt") !='' || sheetObj.CellValue(row,"oa_typ_conv_ctnt") !=''){
			  // OA ARB TYP CONV
			  if(sheetObj.CellValue(row,"oa_typ_rt_op_cd") !="+" && sheetObj.CellValue(row,"oa_typ_rt_op_cd") !="-" &&sheetObj.CellValue(row,"oa_typ_conv_ctnt") !='' ){
				  oa_typ_conv = "\n"+ sheetObj.CellValue(row,"oa_typ_conv_ctnt");
			  }
			  // RT TYP CONV
			  if(sheetObj.CellValue(row,"rt_typ_conv_ctnt") !=''){
				  rt_typ_conv = "\n"+ sheetObj.CellValue(row,"rt_typ_conv_ctnt");
			  }
			  typ_conv = "\n" + "TYPE CONVERSION" +
				 oa_typ_conv + rt_typ_conv +
				 "\n" + "=================================================";  
		  }
	     
		  
	     /* Detail 상세로직 */
		  /* 1 ROW FROM + VIA + TO + VIA */
		  /* 2 ROW TRANSMODE */

	     var pt_cd = sheetObj3.CellValue(row,"rt_mtch_patt_cd").substr(0,4); // PT TYPE
	     if(pt_cd == "0000"){
	    	 rt_head += "Pattern 1 : THR" +
	    	 			"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd == "0100"){
	    	 rt_head += "Pattern 2 : OAR + THR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ; 
	     }else if (pt_cd == "0010"){
	    	 rt_head += "Pattern 3 : THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="0110"){
	    	 rt_head += "Pattern 4 : OAR + THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1000"){
	    	 rt_head += "Pattern 5 : OIH + THR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1100"){
	    	 rt_head += "Pattern 6 : OIH + OAR + THR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1010"){
	    	 rt_head += "Pattern 7 : OIH + THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1110"){
	    	 rt_head += "\n" +	"Pattern 8 : OIH + OAR + THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="0001"){
	    	 rt_head += "Pattern 9 : THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="0101"){
	    	 rt_head += "Pattern 10 : OAR + THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1001"){
	    	 rt_head += "Pattern 11 : OIH + THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1101"){
	    	 rt_head += "Pattern 12 : OIH + OAR + THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="1011"){
	    	 rt_head += "Pattern 13 : OIH + THR + DAR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd == "0111"){
	    	 rt_head += "Pattern 14 : OAR + THR + DAR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }else if (pt_cd =="0011"){
	    	 rt_head += "Pattern 15 : THR + DAR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	     }
	  	if(pt_cd.substr(1,1) == 1){
	  		/*    Ori ARB   */	rt_dtl +="\n" +	'OAR : ' +sheetObj.CellValue(row,"oa_rout_pnt_loc_def_cd")+ ' - '+ sheetObj.CellValue(row,"oa_via_port_def_cd")+' - ' + sheetObj.CellValue(row,"oa_bse_port_def_cd")+
	  											' - ' + sheetObj.CellValue(row,"oa_prc_trsp_mod_cd")+' - ' + sheetObj.CellValue(row,"oa_rcv_de_term_cd")+' - ' + sheetObj.CellValue(row,"oa_curr_cd")+' - ';
	  											if(sheetObj.CellText(row,"rt_arb_rt_appl_tp_cd") == 'F'){
	  												rt_dtl += sheetObj.CellText(row,"rt_arb_frt_rt_amt") + " (FIXED)" +  ' - ' + sheetObj.CellValue(row,"eq_subst_cntr_tpsz_cd")+' - ' + sheetObj.CellValue(row,"cgo_cate_cd") ;
	  											}else{
	  												rt_dtl += sheetObj.CellText(row,"oa_fnl_frt_rt_amt") +  ' - ' + sheetObj.CellValue(row,"oa_rat_ut_cd")+' - ' + sheetObj.CellValue(row,"oa_prc_cgo_tp_cd") ; 
	  											}
	  	}
	     /* Through Rate */    	rt_dtl += "\n" +	'THR : '+ sheetObj.CellValue(row,"op_rout_pnt_loc_def_cd")+' - '+sheetObj.CellValue(row,"ov_rout_via_port_def_cd")+' - '+ sheetObj.CellValue(row,"dv_rout_via_port_def_cd")+' - '+ sheetObj.CellValue(row,"dp_rout_pnt_loc_def_cd") +
													' - '+ sheetObj.CellValue(row,"trns_mod_cd")+' - '+ sheetObj.CellValue(row,"rcv_de_term_cd")+' - '+ sheetObj.CellValue(row,"curr_cd")+' - '+ sheetObj.CellValue(row,"rt_fnl_frt_rt_amt")+' - '+ sheetObj.CellValue(row,"rt_rat_ut_cd")+' - '+ sheetObj.CellValue(row,"rt_prc_cgo_tp_cd") ;	     
	     typ_conv  = typ_head + oa_typ_conv + oi_typ_conv + rt_typ_conv + da_typ_conv + di_typ_conv ;
	     
		 fnl = "\n" +	"=================================================" + "\n" +	" FINAL : USD " + fnl_amount  
		  
		  // 연산기호가 인코딩 되지 않아 encodeURIComponent 처리 함
//		  rt_string += encodeURIComponent(dtl_title + rt_head + rt_dtl + typ_conv + rt_rar_conv + rt_rac_conv + rt_rap_conv + rt_dor_conv + rt_ras_conv + fnl) ;
		  rt_string += encodeURIComponent(dtl_title + rt_head+ rt_dtl + chg_row1 + typ_conv + fnl) ;
		  
		  
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
	
/* 개발자 작업  끝 */