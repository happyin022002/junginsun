/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0079_08.js
 *@FileTitle : Freight & Charge
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.26 이진서
 * 1.0 Creation
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.10.06 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발 : getBKG_0269 함수 호출 이후에 포커싱 조정
 2010.10.18 이일민 [CHM-201006493-01] Charge Save시 Self Audit 자동 실행 요청
 2010.11.01 이일민 [CHM-201006493-01] Charge Save시 Self Audit 자동 실행 요청 - Self-Audit 는 취소를 누른 경우 다시 뜨지 않도록 함, frt_term 컬럼 수정시는 제외
 2011.03.03 정선용 [CHM-201109023-01] Booking 의 Volumn 과 Container Volumn 이 일치 하지 않는 경우 Application Date 를 빨강색으로 표시
 2011.03.14 이일민 [CHM-201109170-01] (중요) E-BOOKING 에서 FREIGHT TERM 이 다르게 UPLOAD 되고 있습니다.
 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 2011.11.09 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완
 2011.11.15 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완 추가 요청. sc_no 변경시 c.ofc/rep 값 초기화
 2012.02.27 정선용 [CHM-201216098-01] BKG Inquiry 메뉴의 SAVE 버튼 기능 오류
 2012.07.02 조정민 [CHM-201218354] OFT 메뉴얼 입력 시 팝업 기능 추가
 2012.07.31 조정민 [CHM-201219327] "GST" Charge 관련 Logic 보완 요청
 2012.08.10 김진주 [CHM-201219579] VET 적용 로직 삽입 요청 (Auto-rating)
 2012.09.10 조정민 [CHM-201220009] [BKG/DOC- FRB 이외 CHG (-)금액 RATING 제한요청]
 2012.09.21 조정민 [CHM-201219952] OFT Including charge/surcharge에 대한 삭제 block
 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
 2012.10.15 김기택 [CHM-201218571-01] [BKG] C/A 항목 추가 요청
 2012.11.08 조정민 [CHM-201219697] [BKG] GST 적용 로직 수정 요청
 2013.01.24 김진주 [CHM-201322584] 오토레이팅 [GST Manual 로직 삽입 요청]
 2013.01.28 김진주 [CHM-201322629] [오토레이팅 보완] TXS surcharge 로직 추가 (=WSC 동일)
 2013.02.12 김진주 [CHM-201323014] OFT 입력시 Copy & Paste할 경우 M FLAG를 U로 수정 요청
 2013.03.25 김진주 [CHM-201323734] Charge 화면의 IN manual 입력 로직 보완
 2013.04.01 김태경 [CHM-201323821] [BKG_Outbound] 통합 로그 결과 복구
 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
 2013.05.23 김진주 [CHM-201324811] GST 오토레이팅 로직 보완 요청 (FOR OTHER CURRENCY)
 2013.06.03 김진주 [CHM-201324842] [ALPS 데이터품질 - BKG validation 로직보완] 5월 대상 건에 대한 진행 요청 건
 2013.06.04 김진주 [CHM-201324811] GST 오토레이팅 로직 보완 요청 (FOR OTHER CURRENCY) >> COS/김미선 부장님 요청으로 작업내용 원복
 2013.07.22 김진주 [CHM-201325778] Charge 화면의 TRI No. 자동 반영 요청
 2013.09.09 김진주 [CHM-201326365] Autorating 결과 계약 조회시 편의 기능 구현
 2013.10.10 김진주 [CHM-201326749] 3rd party office 관련 surcharge 부과 (TPF) auto interface 로직 개발 요청
 2013.10.28 김진주 [CHM-201326965] Split 01-SURCHARGE 및 오토레이팅 보완 관련 CSR(Hide Flag)
 2017.03.23 김동호 화주 편의를 위해 STO freight term 변경 관련 로직 추가. Auto Rating 이후 요금 Grid Manual 수정 시 -> 정하나 과장 요청
 2017.08.25 김동호 [CSR 1870] 베트남 관련 세금(VDT,VFT,VPT,VTT,VET,VCT,VST)을 전부 소수점 이하 반올림 처리 - by 조연서 대리
 ========================================================*/
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
 * @class esm_bkg_0079_08 : esm_bkg_0079_08 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0079_08() {
    this.processButtonClick = tprocessButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}

/* 개발자 작업   */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var beforetab_sub = 1;
var beforetab_trob = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0079_08GS.do';
var prefix1 = "t10sheet1_";
var prefix2 = "t10sheet2_";
var prefix3 = "t10sheet3_";
var prefix4 = "t10sheet4_";
var prefix5 = "t10sheet5_";
var prefix6 = "t10sheet6_";
var prefix7 = "t10sheet7_";
var CAF_Select_Box = null;
var CAF_MAP = null;
var tab_alert_msg = false; // 메세지 표시유무
var auto_rating = false;
var isOpenSelfAudit = false;
var isOpenSelfAudit2 = false;  //prefix2+"frt_term_cd" 컬럼을 제외한 시트의 수정여부
var volDiffFlg = 'N';
var openFlg = 'Y';
var ctrt_amdt_seq = '';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
        for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        sheetObjects[i].WaitImageVisible = false; 
        ComEndConfigSheet(sheetObjects[i]);
    }
    var formObj  = document.form;
    if(formObj.bkg_no.value != ""){ 
        ComSetObjValue(formObj.frm_t10sheet1_bkg_no ,formObj.bkg_no.value);
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    }
//  else {
//      ComBtnDisable("btn_t103rdBLReq");
//  }
    //------------------------------------------------>
    // setInquiryDisableButton 이벤트 호출
    if(ComGetObjValue(formObj.isInquiry) == "Y"){
        setInquiryDisableButton();
    }
    //------------------------------------------------>
    initControl();

    // 대기창 사라짐
    ComOpenWait(false); 
}
/**
 * 초기 컨트롤 설정하기 
 **/
function initControl() {
    DATE_SEPARATOR = "-";
    axon_event.addListenerFormat('beforeactivate'   , 'obj_activate'    , form); 
    axon_event.addListenerFormat('beforedeactivate' , 'obj_deactivate'  , form);
    axon_event.addListenerForm('keypress'           , 'obj_KeyPress'    , form);
    //sc_no변경시 C.OFC/Rep. 값 초기화 2011.11.15 kbj
    axon_event.addListenerForm('change'             , 'form_onChange'   , form);
    axon_event.addListenerForm('keydown'            , 'check_Enter'     , form);     
    applyShortcut();
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
                InitColumnInfo(80, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false, false)

                var HeadTitle1 = "||||||||||||||||||||||||||||||||||||||||||||||||";

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
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rt_aply_dt");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "aud_sts_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rt_bl_tp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rt_bl_tp_cd_old");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "mst_cvrd_bl");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_tp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "frt_term_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "por_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pol_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pod_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "del_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rep_cmdt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rep_cmdt_nm");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cmdt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cmdt_nm");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "taa_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trf_lnr_itm_no");                
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pre_rly_port_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pst_rly_port_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cust_nm");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rcv_term_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "de_term_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "svc_scp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_svc_scp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rfa_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rp_prop_sts_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trf_lnr_itm_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cstms_desc");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "sc_no1");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "sc_no2");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "sp_prop_sts_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "brk_dwn_flg");
                InitDataProperty(0, cnt++, dtData, 0, daRight, false, prefix1 + "act_wgt", false, "", dfNullFloat, 3, false, false);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "wgt_ut_cd");
                InitDataProperty(0, cnt++, dtData, 0, daRight, false, prefix1 + "meas_qty", false, "", dfNullFloat, 3, false, false);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "meas_ut_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "special");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rmark_yn");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rfa_yn");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cntr_prt_flg");
                //<!-- by 추가요구사항  현업 임종한  -->
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_rcv_ofc_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_payr_cnt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_payr_cust_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "clt_ofc_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "clt_payr_cnt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "clt_payr_cust_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_sts_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_rt_whf_expt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cobiz_auth_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_ctrt_tp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "prc_rt_mtch_patt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "prc_gen_spcl_rt_tp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "prc_cmdt_hdr_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "prc_rout_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "calc_ctrt_tp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "mst_rfa_rout_id");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "hngr_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rc_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "wsc_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cntr_wgt_cmpl_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cdr_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "txs_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "dhf_loc_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ddc_curr_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "jordan_desc");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "org_trns_mod_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "dest_trns_mod_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rwt_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "sc_no_old");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rfa_no_old");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "taa_no_old");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rtro_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "rtro_knd_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "oft_amdabl_flg");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "old_oft_amt");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "dhf_curr_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "doc_inter_rmk");
                CountPosition = 0;
            }
            break;

        case 2: //t1sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 222;
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
                InitColumnInfo(38, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false, false)

                var HeadTitle = "|||Charge||Tariff Item No.|Cur||Rate|Rated As|Per||||Amount|IN|Term|Third||Payer|Payer|||Cargo|Term|Term|IMO|SOC|M|Hide";

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
                // SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
                // UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
                // TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 100, daCenter, true, prefix2 + "ibflag");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "bkg_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "rt_seq");
                InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, false, prefix2 + "chg_cd", true, "", dfNone, 0, true, true, 3);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "exist_chg_cd");
                InitDataProperty(0, cnt++, dtData, 95, daCenter, false, prefix2 + "trf_itm_no", false, "", dfNone, 0, true, true, 15);
                InitDataProperty(0, cnt++, dtPopupEdit, 55, daCenter, false, prefix2 + "curr_cd", true, "", dfNone, 0, true, true, 3);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "exist_curr_cd");             
                InitDataProperty(0, cnt++, dtData, 80, daRight, false, prefix2 + "chg_ut_amt", true, "", dfNullFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, prefix2 + "rat_as_qty", true, "", dfNullFloat, 3, true, true);
                InitDataProperty(0, cnt++, dtPopupEdit, 45, daCenter, false, prefix2 + "rat_ut_cd", true, "", dfNone, 0, true, true, 2);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "exist_rat_ut_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "rat_ut2_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "rat_ut3_cd");
                InitDataProperty(0, cnt++, dtData, 85, daRight, false, prefix2 + "chg_amt", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix2 + "incl_oft_flg", true, "", dfNone, 0, true, true, 1);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, prefix2 + "frt_term_cd", true, "", dfNone, 0, true, true, 1);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, prefix2 + "n3pty_rcv_ofc_cd", false, "", dfNone, 0, true, true, 6);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "exist_ofc_cd");
                InitDataProperty(0, cnt++, dtData, 25, daCenter, false, prefix2 + "n3pty_cust_cnt_cd", false, "", dfNone, 0, true, true, 2);
                InitDataProperty(0, cnt++, dtPopupEdit, 70, daCenter, false, prefix2 + "n3pty_cust_seq", false, "", dfNone, 0, true, true, 6);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "exist_cust_cnt");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "exist_cust_seq");
                InitDataProperty(0, cnt++, dtData, 55, daCenter, false, prefix2 + "cgo_cate_cd", true, "", dfNone, 0, true, true, 2);
                InitDataProperty(0, cnt++, dtData, 25, daCenter, false, prefix2 + "rcv_term_cd", true, "", dfNone, 0, true, true, 1);
                InitDataProperty(0, cnt++, dtData, 25, daCenter, false, prefix2 + "de_term_cd", true, "", dfNone, 0, true, true, 1);
                InitDataProperty(0, cnt++, dtData, 45, daCenter, false, prefix2 + "imdg_clss_cd", false, "", dfNone, 0, true, true, 10);
                InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix2 + "soc_flg", false, "", dfNone, 0, true, true, 1);
                InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix2 + "auto_rat_cd", true, "", dfNone, 0, false, false,1);
                InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false, prefix2 + "prn_hdn_flg", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "note_rt_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "prop_no");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "amdt_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "svc_scp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "gen_spcl_rt_tp_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "cmdt_hdr_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "rout_seq");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "fx_rt_flg");
                InitDataValid(0, prefix2 + "chg_cd"         , vtEngUpOnly);
                InitDataValid(0, prefix2 + "curr_cd"        , vtEngUpOnly);
                InitDataValid(0, prefix2 + "rat_ut_cd"      , vtEngUpOther, "0123456789");      // rat_ut_cd
                InitDataValid(0, prefix2 + "incl_oft_flg"   , vtCharOnly, "inIN");      
                InitDataValid(0, prefix2 + "frt_term_cd"    , vtCharOnly, "cpCP");  
                InitDataValid(0, prefix2 + "n3pty_rcv_ofc_cd"   , vtEngUpOnly);
                InitDataValid(0, prefix2 + "n3pty_cust_cnt_cd"  , vtEngUpOnly);
                InitDataValid(0, prefix2 + "n3pty_cust_seq" , vtNumericOther, ".");
                InitDataValid(0, prefix2 + "cgo_cate_cd"    , vtEngUpOnly);
                InitDataValid(0, prefix2 + "soc_flg"        , vtCharOnly, "yY");    

                var rc = ComGetObjValue(document.form.frm_rcv_term_cd).valueOf(); 
                var de = ComGetObjValue(document.form.frm_de_term_cd).valueOf();

                InitDataValid(0, prefix2 + "rcv_term_cd"    , vtCharOnly , rc);
                InitDataValid(0, prefix2 + "de_term_cd"     , vtCharOnly , de);
                InitDataValid(0, prefix2 + "auto_rat_cd"    , vtEngUpOnly);
                
                DataLinkMouse(prefix2 + "chg_cd")           = true;
                DataLinkMouse(prefix2 + "curr_cd")          = true;
                DataLinkMouse(prefix2 + "rat_ut_cd")        = true;
                DataLinkMouse(prefix2 + "n3pty_cust_seq")   = true;
                
                ShowButtonImage = 2;
                CountPosition = 0;
            }
            break;

        case 3: //t1sheet1 init
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
                InitColumnInfo(7, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false, false)

                var HeadTitle1 = "||||";

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
                // SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
                // ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix3 + "ibflag");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "type");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "curr_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "chg_amt");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "ofc_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "cnt_cd");
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix3 + "cust_seq");
                CountPosition = 0;
            }
            break;
            
        case 4: //t1sheet1 init
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
            InitColumnInfo(5, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)

            var HeadTitle1 = "||";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
            // SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
            // ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix4 + "ibflag");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix4 + "cntr_tpsz_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix4 + "cgo");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix4 + "qty");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix4 + "eq_sub");
            CountPosition = 0;
        }
        break;      
        case 5: //t1sheet5 init
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
            InitColumnInfo(7, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)

            var HeadTitle1 = "||||";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
            // SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
            // ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix5 + "ibflag");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix5 + "pchg_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix5 + "pct_bse_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix5 + "chg_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix5 + "curr_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix5 + "pay_term_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix5 + "scg_amt");
            CountPosition = 0;
        }
        break;
        /*
         * 2010.1.21 김태경 Container Vol. Difference 팝업 을 위해 Charge 화면에서 Container
         * 정보를 가지고 있어야 함
         */
        case 6: //t1sheet6 init
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
            InitColumnInfo(16, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)

            var HeadTitle1 = "|cntr_dp_seq|bkg_no|cntr_no|cntr_vol_qty|cntr_tpsz_cd|rc_flg|dcgo_flg|awk_cgo_flg|bb_cgo_flg|hngr_flg|soc_flg||rcv_term|de_term|op_cntr_qty|flex_hgt_flg|";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
            // SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
            // ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix6 + "ibflag");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "cntr_dp_seq");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "bkg_no");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "cntr_no");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "cntr_vol_qty");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "cntr_tpsz_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "rc_flg");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "dcgo_flg");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "awk_cgo_flg");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "bb_cgo_flg");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "hngr_flg");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "soc_flg");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "rcv_term_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "de_term_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "op_cntr_qty");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix6 + "flex_hgt_flg");
            CountPosition = 0;
        }
        break;  
        
        case 7: //t1sheet7 init
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
            InitColumnInfo(37, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)

            // var HeadTitle = "|||Charge||Tariff Item No.|Cur||Rate|Rated
            // As|Per||Amount|IN|Term|Third||Payer|Payer|||Cargo|Term|Term|IMO|M|Hide";
            var HeadTitle = "|||||||||||||||||||||||||||||||||||";
            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
            // SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
            // UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
            // TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix7 + "ibflag");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "bkg_no");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "rt_seq");
            InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, false, prefix7 + "chg_cd", false, "", dfNone, 0, true, true, 3);
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "exist_chg_cd");
            InitDataProperty(0, cnt++, dtData, 90, daCenter, false, prefix7 + "trf_itm_no", false, "", dfNone, 0, true, true, 13);
            InitDataProperty(0, cnt++, dtPopupEdit, 60, daCenter, false, prefix7 + "curr_cd", false, "", dfNone, 0, true, true, 3);
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "exist_curr_cd");             
            InitDataProperty(0, cnt++, dtData, 80, daRight, false, prefix7 + "chg_ut_amt", false, "", dfNullFloat, 2, true, true);
            InitDataProperty(0, cnt++, dtData, 70, daRight, false, prefix7 + "rat_as_qty", false, "", dfNullFloat, 3, true, true);
            InitDataProperty(0, cnt++, dtPopupEdit, 50, daCenter, false, prefix7 + "rat_ut_cd", false, "", dfNone, 0, true, true, 2);
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "exist_rat_ut_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "rat_ut2_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix2 + "rat_ut3_cd");
            InitDataProperty(0, cnt++, dtData, 90, daRight, false, prefix7 + "chg_amt", false, "", dfNullFloat, 2, false, false);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix7 + "incl_oft_flg", false, "", dfNone, 0, true, true, 1);
            InitDataProperty(0, cnt++, dtData, 50, daCenter, false, prefix7 + "frt_term_cd", false, "", dfNone, 0, true, true, 1);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix7 + "n3pty_rcv_ofc_cd", false, "", dfNone, 0, true, true, 6);
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "exist_ofc_cd");
            InitDataProperty(0, cnt++, dtData, 25, daCenter, false, prefix7 + "n3pty_cust_cnt_cd", false, "", dfNone, 0, true, true, 2);
            InitDataProperty(0, cnt++, dtPopupEdit, 70, daCenter, false, prefix7 + "n3pty_cust_seq", false, "", dfNone, 0, true, true, 5);
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "exist_cust_cnt");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "exist_cust_seq");
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix7 + "cgo_cate_cd", false, "", dfNone, 0, true, true, 2);
            InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix7 + "soc_flg", false, "", dfNone, 0, true, true, 1);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix7 + "rcv_term_cd", false, "", dfNone, 0, true, true, 1);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix7 + "de_term_cd", false, "", dfNone, 0, true, true, 1);
            InitDataProperty(0, cnt++, dtData, 45, daCenter, false, prefix7 + "imdg_clss_cd", false, "", dfNone, 0, true, true, 10);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, false, prefix7 + "auto_rat_cd", false, "", dfNone, 0, false, false,1);
            InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false, prefix7 + "prn_hdn_flg", false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "note_rt_seq");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "prop_no");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "amdt_seq");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "svc_scp_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "gen_spcl_rt_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "cmdt_hdr_seq");
            InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix7 + "rout_seq");

            CountPosition = 0;
        }
        break;
        
        }

    } catch (ex) {
        fnBkgErrorAlert('initSheet', ex);
    }
}
 
 /**
 * Dumy 타당성 체크.<br>
 * @param rValue
 */
 function fnDumyNotValidCheck(){
    var formObj = document.form;
    if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 
    || formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 
    || formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1){
        if('B' != ComGetObjValue(formObj.rt_bl_tp_cd)){
            ComShowCodeMessage("BKG08152");
            return true;
        }
    }
    fnCozNotValidCheck();
    return false;
}
 
 /**
  * fnCozNotValidCheck 타당성 체크.<br>
  * @param rValue
  */
function fnCozNotValidCheck(){
    var formObj = document.form;
    if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
        // BY 김태경
    }else{
        //BY 김태경 2010.04.21 RFA COZ항목 통과 
        if(formObj.frm_t10sheet1_rfa_no.value.indexOf("COZ") != -1 ){   
            ComSetObjValue(formObj.frm_t10sheet1_rfa_no, 'COZ00000001');
            ComSetObjValue(formObj.rt_bl_tp_cd, "B");
        }
    }
}
  
  function form_onChange(evt,el) {
        var formObj = document.form;
        var srcName;
        var srcValue;
        var srcObj;
        if (el) {
            srcObj = el;
            srcName = el.getAttribute("name");
            srcValue = el.getAttribute("value");
        } else {
            srcObj = window.event.srcElement;
            srcName = srcObj.getAttribute("name");
            srcValue = srcObj.getAttribute("value");
        }
        ComSetObjValue(formObj.modify_flag, "Y");
        //sc_no변경시 C.OFC/Rep. 값 초기화 2011.11.15 kbj
        if(srcName == "frm_t10sheet1_sc_no1"){
            ComSetObjValue(formObj.sc_no,ComGetObjValue(formObj.frm_t10sheet1_sc_no1));
            ComSetObjValue(formObj.ctrt_ofc_cd,"");
            ComSetObjValue(formObj.ctrt_srep_cd,"");
        }
  }
  

var isShowOrgBlNo = true;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    var sheetObject3 = sheetObjects[2];
    var sheetObject4 = sheetObjects[3];
    var sheetObject5 = sheetObjects[4];
    var sheetObject6 = sheetObjects[5];
    /** **************************************************** */
    var formObj = document.form;
    ComSetObjValue(formObj.f_cmd, SEARCH);
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        if(srcName != "btn_splitPop"){
            if(layList.style.display == ""){
                layList.style.display="none";
            }                       
        }
        
        /** * POP UP Charge (S) ** */
        switch (srcName) {
        case "btn_splitPop":
            doActionIBSheet(sheetObject1,formObj,COMMAND03);                    
            break;           
    
        case "pop_bkg_no":
            fnSetSelectNumberBox('span_bkg_no', 'text_bkg_no');
            break;

        case "pop_bl_no":
            fnSetSelectNumberBox('span_bl_no', 'text_bl_no');
            break;

        case "pop_covered":
            //          if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
            //              return;
            //          }   
            var _Width = '320';
            var _Height = '430';
            var pgmNo = "&pgmNo=ESM_BKG_0771";
            var param = "f_cmd=" + SEARCH +"&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&bl_no="+ComGetObjValue(formObj.bl_no)+"&bdrflag="+ComGetObjValue(formObj.bdrflag)+"&caflag="+ComGetObjValue(formObj.caflag);
            var url = "ESM_BKG_0771.do?" + param + pgmNo;
            var rValue771 = ComOpenPopup(url, _Width, _Height, 'getBKG_0771', '0,0', true, true, 0, "", 1);
            break;

        case "pop_rfa_no":
            if(ComGetObjValue(formObj.isInquiry) == "Y"){
                return false;
            }

            var ctrtType = "rfa";
            var ctrtNo = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
            var applicationDate = ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join("");
            var cmdt_hdr_seq = sheetObject1.CellValue(1,"t10sheet1_prc_cmdt_hdr_seq");
            var rout_seq = sheetObject1.CellValue(1,"t10sheet1_prc_rout_seq");
            var svc_scp_cd = ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd).substring(0,3);

            if(validatePriPopUp(ctrtType, ctrtNo, applicationDate)){
                if(ctrtNo != '' && ctrt_amdt_seq != ''){
                    
                    if(ctrtNo.substring(5,6) =="G" || ctrtNo.substring(5,6) =="M"){
                        ComOpenWindowCenter("ESM_PRI_2120.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+ctrt_amdt_seq+"&s_cmdt_hdr_seq="+cmdt_hdr_seq
                                 +"&s_rout_seq="+rout_seq+"&s_svc_scp_cd="+svc_scp_cd, "", '1024', '700', false, "yes");    
                    } else {
                        ComOpenWindowCenter("ESM_PRI_2020.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+ctrt_amdt_seq+"&s_cmdt_hdr_seq="+cmdt_hdr_seq
                                 +"&s_rout_seq="+rout_seq+"&s_svc_scp_cd="+svc_scp_cd, "", '1024', '700', false, "yes");    
                    }
                }
            }
            break;

        case "pop_sc_no":
            if(ComGetObjValue(formObj.isInquiry) == "Y"){
                return false;
            }
            
             var ctrtType = "sc";
//           var ctrtNo = formObj.frm_t10sheet1_sc_no1;
             var ctrtNo = ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
             var applicationDate = ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join("");
             var cmdt_hdr_seq = sheetObject1.CellValue(1,"t10sheet1_prc_cmdt_hdr_seq");
             var rout_seq = sheetObject1.CellValue(1,"t10sheet1_prc_rout_seq");
             var svc_scp_cd = ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd).substring(0,3);
             var gen_spcl_tp = sheetObject1.CellValue(1,"t10sheet1_prc_gen_spcl_rt_tp_cd");
             if(validatePriPopUp(ctrtType, ctrtNo, applicationDate)){
                 ComOpenWindowCenter("ESM_PRI_0087.do?sc_no="+ctrtNo+"&amdt_seq="+ctrt_amdt_seq+"&s_cmdt_hdr_seq="+cmdt_hdr_seq
                         +"&s_rout_seq="+rout_seq+"&s_svc_scp_cd="+svc_scp_cd+"&s_gen_spcl_rt_tp_cd="+gen_spcl_tp, "", '1024', '700', false, "yes");
             }
             break; 

        case "pop_tta_no":
            if(ComGetObjValue(formObj.isInquiry) == "Y"){
                return false;
            }
            
             var ctrtType = "taa";
             var ctrtNo = ComGetObjValue(formObj.frm_t10sheet1_taa_no);
             var applicationDate = ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join("");
             var trf_itm_no = sheetObject2.CellValue(1, prefix2 + "trf_itm_no").split('-').join("");
             
             if(validatePriPopUp(ctrtType, ctrtNo, applicationDate)){
                 ComOpenWindowCenter("ESM_PRI_3019.do?taa_no="+ctrtNo+"&amdt_seq="+ctrt_amdt_seq+"&s_tri_no="+trf_itm_no, "", '1024', '700', false, "yes");
             }
             break;

        case "pop_prepaid":
            var _Width = '540';
            var _Height = '320';
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no) + "&ca_flg="+ComGetObjValue(formObj.caflag);
            var pgmNo = "&pgmNo=ESM_BKG_0961";
            var url = "ESM_BKG_0961.do?" + param + pgmNo + "&call_type=PPD";
            var rValue961 = ComOpenPopup(url, _Width, _Height, 'getBKG_0961', '0,0', true, true, 0, "", 1);
            getBKG_0961(rValue961, "PPD");
            break;

        case "pop_collect":
            var _Width = '540';
            var _Height = '320';
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no) + "&ca_flg="+ComGetObjValue(formObj.caflag);
            var pgmNo = "&pgmNo=ESM_BKG_0961";
            var url = "ESM_BKG_0961.do?" + param + pgmNo + "&call_type=CCT";
            var rValue961 = ComOpenPopup(url, _Width, _Height, 'getBKG_0961', '0,0', true, true, 0, "", 1);
            getBKG_0961(rValue961,"CCT")
            break;

        case "btn_t10note":
            var _Width = '1050';
            var _Height = '550';
            var pgmNo = "&pgmNo=ESM_BKG_0270";
            var svc_scp_cd = ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd);
            var bkg_no = ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
            var sc_no = ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
            
            // UI 270 으로 넘기는 Parameter
            var note_rt_seq = "";
            var prop_no = "";
            var amdt_seq = "";
            var svc_scp_cd = "";
            var gen_spcl_rt_tp_cd ="";
            var cmdt_hdr_seq ="";
            var rout_seq = "";
            
            var cnt = sheetObject2.RowCount;
            var sheetObj = sheetObject2;
            if(cnt > 0){
                for (var i = 0; i <= cnt; i++){
                    if(sheetObj.CellValue(i,prefix2 + "chg_cd") =="OFT"){
                        note_rt_seq = sheetObj.CellValue(i,prefix2 + "note_rt_seq");
                        prop_no = sheetObj.CellValue(i,prefix2 + "prop_no");
                        amdt_seq = sheetObj.CellValue(i,prefix2 + "amdt_seq");
                        svc_scp_cd = sheetObj.CellValue(i,prefix2 + "svc_scp_cd");
                        gen_spcl_rt_tp_cd = sheetObj.CellValue(i,prefix2 + "gen_spcl_rt_tp_cd");
                        cmdt_hdr_seq = sheetObj.CellValue(i,prefix2 + "cmdt_hdr_seq");
                        rout_seq = sheetObj.CellValue(i,prefix2 + "rout_seq");
                        break;
                    }
                }
            }
            /* 2010.1.21 Prop No, Seq, ScpCd 없을경우 Note 팝업을 오픈 하지 않는다 */
            if((prop_no+amdt_seq+svc_scp_cd).length <= 0 | prop_no+amdt_seq+svc_scp_cd =='') return;
            
            
            var rfa_no = formObj.frm_t10sheet1_rfa_no.value;
            // RFA 는 Note 가 없음 OPen 하지 않음
            if(rfa_no.length > 0 | rfa_no !='') return;
            if(svc_scp_cd.length >0) svc_scp_cd = svc_scp_cd.substring(0,3);
            
            var param = 
            'bkg_no=' + bkg_no + 
            '&application_date=' + ComGetObjValue(formObj.application_date) + 
            '&sc_no=' + sc_no + 
            '&svc_scp_cd=' + svc_scp_cd + 
            '&note_rt_seq=' + note_rt_seq + 
            '&prop_no=' + prop_no +
            '&amdt_seq=' + amdt_seq + 
            '&gen_spcl_rt_tp_cd=' +gen_spcl_rt_tp_cd +
            '&cmdt_hdr_seq=' + cmdt_hdr_seq + 
            '&rout_seq=' + rout_seq;
            var url = "ESM_BKG_0270.do?" + param + pgmNo;
            ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
            break;

        case "btn_t10websimon":
            var _Width = '1020';
            var _Height = '530';
            var param = '';
            var url = "http://websimon.dxi.com/cws202/DxiServlet.WsServlet/login";
            ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
            break;

        case "btn_t10cntr_rate":
            if(ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
                ComShowMessage(ComGetMsg("BKG00400"));
                ComSetFocus(formObj.frm_t10sheet1_bl_no);
                return false;
            }
            var _Width = '1030';
            var _Height = '650';
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no);
            var pgmNo = "&pgmNo=ESM_BKG_1043";
            var url = "ESM_BKG_1043.do?" + param + pgmNo;
            ComOpenWindowCenter(url, "BKG_Win",  _Width , _Height + "px", false);
            break;
        /** * Gride Charge (S) ** */

        case "btn_t10add":
            if(fnDumyNotValidCheck()){
                return;
            }
            /** 
             * 1. 그리드에 행 추가
            2. Rate, Rate As, Amount 0 으로 설정
            3. IN을 N으로 설정
            4. Freight Term에 따라 Term 설정
            5. Cargo에 DR로 설정
            6. BKG R/D Term으로 R/D Term 설정
            7. M(Auto/Manual)에 M으로 설정
             */
             var newRow = setDataInsert(sheetObject2, 1);
             sheetObject2.RowStatus(newRow)= "R";
            break;

        case "btn_t10del":
            /*1. 메시지 [BKG00535] 표시 후 Yes 선택하면 그리드에 선택된 행 삭제
             */ 
            var cnt     = sheetObject2.RowCount;
            var sRow    = sheetObject2.SelectRow;
            
            if(sheetObject2.RowCount == 0) return false;
            
            var selRows = sheetObject2.CellValue(sRow, prefix2 + "auto_rat_cd"); // 기준
            if(selRows == ''){
                ComShowMessage(ComGetMsg("COM12189"));
                return false;
            }

            fnRowHidden(sheetObject2,sRow);// 2.행 숨기기

            var inclFlg = sheetObject2.CellValue(sRow + 1, prefix2 + "incl_oft_flg"); // 기준
            if(inclFlg == 'I'){
                ComBtnDisable("btn_t10del");
            }
            for ( var ix = 1; ix <= cnt; ix++) {
                if (!sheetObject2.RowHidden(ix)) {
                    sheetObject2.SelectCell(ix,1);
                    break;
                }
            }
            
            var inclFlg = sheetObject2.CellValue(sheetObject2.SelectRow + 1, prefix2 + "incl_oft_flg"); // 기준
            var inclFlg1 = sheetObject2.CellValue(sheetObject2.SelectRow, prefix2 + "incl_oft_flg");
            if(inclFlg == 'I'){
                ComBtnDisable("btn_t10del");
            }
            if(inclFlg1 != 'I'){
                ComBtnEnable("btn_t10del");
            }

            for ( var z = 1; z <= cnt; z++) {
                fnChargePercentageRate(sheetObject2, z, '', '');
            }

            break;

        case "btn_t10merge":
            /* 1. 선택된 Charge 코드가 처음 나온 행으로 선택된 행을 변경
            2. 선택된 행의 Charge Code가 3자리 미만이면 메시지 [BKG00897] 표시 후 리턴
            3. Currency가 3자리 미만인 경우 메시지 [BKG00898] 표시후 리턴
            4. Term이 1자리 미만인 경우 메시지 [BKG00904] 표시후 리턴
            5. Third 가 1 미만인 경우 메시지 [BKG00905] 표시후 리턴
            6. 메시지 [BKG00934] 표시후 Yes 선택하면 계속 진행
            7. 선택된 행과 같은 Charge Code를 가진 행의 currency가 다르면 메시지 [BKG00935] 표시 후 리턴
            8. 선택된 행과 같은 Charge Code를 가진 행의 Term이 다르면 메시지 [BKG00936] 표시 후 리턴
            9. IN이 'N'이 아닌 경우 메시지 [BKG00937] 표시 후 리턴
            10. 선택된 행과 같은 Charge Code가 없는 경우 메시지 [BKG08134] 표시 후 리턴
            11. 선택된 행위에 행 추가
            12. Charge, Cur, Term, Third 에 비교시 사용한 값으로 설정
            13. Rate, Amount에 0 으로 설정
            14. Rate As에 1 로 설정
            15. IN에 N 으로 설정
            16. Per에 BL 로 설정
            17. Cargo에 DR 로 설정
            18. BKG R/D Term으로 R/D Term 설정
            19. M(Auto/Manual)에 M으로 설정
            20. Amount에 선택된 Charge Code의 합을 추가하여 더하고, 행 삭제
             */
            var cnt = sheetObject2.RowCount;
            if (cnt == 0) {
                ComShowCodeMessage("BKG00095");
                return false;
            }
            var sRow = sheetObject2.SelectRow;
            var Charge = sheetObject2.CellValue(sRow, prefix2 + "chg_cd");
            var Currency = sheetObject2.CellValue(sRow, prefix2 + "curr_cd");
            var Term = sheetObject2.CellValue(sRow, prefix2 + "frt_term_cd");
            var Third = sheetObject2.CellValue(sRow, prefix2 + "n3pty_rcv_ofc_cd");
            if (Charge.length < 3) {
                ComShowCodeMessage("BKG00897");
                return false;
            }
            if (Currency.length < 3) {
                ComShowCodeMessage("BKG00898");
                return false;
            }
            if (Term.length < 1) {
                ComShowCodeMessage("BKG00904");
                return false;
            }
            // total count 갯수 
            var cnt = sheetObject2.RowCount;
            var c_cnt = 0;
            var _flag = true;
            for ( var ix = 1; ix <= cnt; ix++) {
                if (Charge == sheetObject2.CellValue(ix, prefix2 + "chg_cd")) {
                    if (Currency != sheetObject2.CellValue(ix, prefix2 + "curr_cd")) {
                        ComShowCodeMessage("BKG00935");
                        // "Currency code is different.";
                        sheetObject2.SelectCell(ix, prefix2 + "curr_cd");
                        _flag = false;
                        break;
                    }
                    if (Term != sheetObject2.CellValue(ix, prefix2 + "frt_term_cd")) {
                        ComShowCodeMessage("BKG00936");
                        // " Payer is different";
                        sheetObject2.SelectCell(ix, prefix2 + "frt_term_cd");
                        _flag = false;
                        break;
                    }
                    if (Third != sheetObject2.CellValue(ix, prefix2 + "n3pty_rcv_ofc_cd")) {
                        ComShowCodeMessage("BKG00905");
                        // "Third Office is not available";
                        sheetObject2.SelectCell(ix, prefix2 + "n3pty_rcv_ofc_cd");
                        _flag = false;
                        break;
                    }       
                    if ('N' != sheetObject2.CellValue(ix, prefix2 + "incl_oft_flg")) {
                        ComShowCodeMessage("BKG00937");
                        // Only normal charge can be merged.";
                        sheetObject2.SelectCell(ix, prefix2 + "incl_oft_flg");
                        _flag = false;
                        break;
                    }
                    if ('' == sheetObject2.CellValue(ix, prefix2 + "chg_cd")) {
                        ComShowCodeMessage("BKG00897");
                        // "[{?msg1}] is not available.";
                        sheetObject2.SelectCell(ix, prefix2 + "chg_cd");
                        _flag = false;
                        break;
                    }
                    c_cnt++;
                }
            }
            if (!_flag){
                return;
            }
            //No need to merge -> No charge to merge 로 수정 
            if(c_cnt==1){
                ComShowCodeMessage("BKG08134");return;
            }
            if (!ComShowCodeConfirm("BKG00934", "["+Charge+"]"))
                return;

            var total_amount = 0.000;
            var t_cnt = sheetObject2.RowCount;
            for ( var t = 1; t <= t_cnt; t++) {
                if(Charge == sheetObject2.CellValue(t, prefix2 + "chg_cd")
                && 'D' != sheetObject2.CellValue(t, prefix2 + "ibflag")     
                ){
                    var amount   = sheetObject2.CellValue(t, prefix2 + "chg_amt");
                    total_amount = parseFloat(total_amount) + parseFloat(amount);
                    fnRowHidden(sheetObject2,t);// 2.행 숨기기

                }
            }

            var nRow = sheetObject2.DataInsert();
            sheetObject2.CellValue(nRow, prefix2 + "chg_cd") = Charge;
            sheetObject2.CellValue(nRow, prefix2 + "trf_itm_no") = '';
            sheetObject2.CellValue(nRow, prefix2 + "curr_cd") = Currency;
            sheetObject2.CellValue(nRow, prefix2 + "chg_ut_amt") = total_amount;
            sheetObject2.CellValue(nRow, prefix2 + "rat_as_qty") = '1';
            sheetObject2.CellValue(nRow, prefix2 + "rat_ut_cd") = 'BL';
            sheetObject2.CellValue(nRow, prefix2 + "incl_oft_flg") = 'N';
            sheetObject2.CellValue(nRow, prefix2 + "frt_term_cd") = Term;
            sheetObject2.CellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd") = Third;
            sheetObject2.CellValue(nRow, prefix2 + "n3pty_cust_cnt_cd") = '';
            sheetObject2.CellValue(nRow, prefix2 + "n3pty_cust_seq") = '';
            sheetObject2.CellValue(nRow, prefix2 + "cgo_cate_cd") = 'DR';
            sheetObject2.CellValue(nRow, prefix2 + "rcv_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd);
            sheetObject2.CellValue(nRow, prefix2 + "de_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_de_term_cd);
            sheetObject2.CellValue(nRow, prefix2 + "imdg_clss_cd") = '';
            sheetObject2.CellValue(nRow, prefix2 + "auto_rat_cd") = 'M';
            sheetObject2.CellValue(nRow, prefix2 + "prn_hdn_flg") = '0';
            
            // 숨기기
            var r_cnt = sheetObject2.RowCount;
            for ( var t = 1; t <= r_cnt; t++) {
                var _type = sheetObject2.CellValue(t, prefix2 + "ibflag");
                if( _type != undefined){
                    if(sheetObject2.RowHidden(t)){
                        if('D' != sheetObject2.CellValue(t, prefix2 + "ibflag")){
                            sheetObject2.RowStatus(t) = "D";
                        }
                    }
                }
            }
            
            break;

        case "btn_t10surcharge_Inquiry":
            var _Width = '1050';
            var _Height = '650';
            var pgmNo = "&pgmNo=ESM_PRI_4011";
            var param = 
                'bkg_no=' + ComGetObjValue(formObj.bkg_no) + 
                '&svc_scp_cd=' + ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd)
                // '&chg_cd=' + ComGetObjValue(formObj.chg_cd)
                ;
            
            var url = "ESM_PRI_4011.do?" + param + pgmNo;
            ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
            break;

        case "btn_t10whf":
            if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
                ComShowCodeMessage("BKG00048");
                return;
            }
            var _Width = '580';
            var _Height = '510';
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no);
            var pgmNo = "&pgmNo=ESM_BKG_0699";
            var url = "ESM_BKG_0699.do?" + param + pgmNo;
            ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true);
            break;
            
        case "btn_t10adj":
            if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
                ComShowCodeMessage("BKG00048");
                return;
            }
            

            // 1. map으로 CAF 목록을 만든다.
            CAF_MAP = null;
            CAF_MAP = new fnBkgJsMap();
            var cnt = sheetObject2.RowCount;
            for ( var ix = 1; ix <= cnt; ix++) {
                var charge      = sheetObject2.CellValue(ix, prefix2 + "chg_cd");
                var currency    = sheetObject2.CellValue(ix, prefix2 + "curr_cd");
                var type_charge = charge +"("+currency+")";
                if(charge == "CAF") type_charge = "CAF";
                var amount      = sheetObject2.CellValue(ix, prefix2 + "chg_amt");
                
                if (CAF_MAP.containsKey(type_charge)) {
                    //동일한 운임이  있으면  합산한다.
                    var cobj = CAF_MAP.get(type_charge);// 비교대상
                    if (cobj.currency == currency) {
                        // 화폐가 동일하면 합산한다.
                        cobj.amount = parseFloat(cobj.amount) + parseFloat(amount);
                    } else {
                        
                        //화폐가 다르다
                        cobj.diffyn = 'Y';
                        // 동일한 운임이 아님.
                        var obj = new Object();
                        obj.charge = charge;
                        obj.currency = currency;
                        obj.amount = amount;
                        obj.diffyn = 'N'; // 초기값 다르지 않음.
                        CAF_MAP.put(type_charge, obj);                      
                    }
                }else{
                    
                    //동일한 운임이  아님.
                    var obj = new Object();
                    obj.charge = charge;
                    obj.currency = currency;
                    obj.amount = amount;
                    obj.diffyn = 'N'; // 초기값 다르지 않음.
                    CAF_MAP.put(type_charge, obj);
                }
            }
            
            var _Width = '580';
            var _Height = '460';
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)+"&ca_flg="+ComGetObjValue(formObj.caflag)+"&svc_scp_cd="+ComGetObjValue(formObj.svc_scp_cd)+"&bkg_ofc_cd="+ComGetObjValue(formObj.bkg_ofc_cd)+"&pol_cd="+ComGetObjValue(formObj.frm_t10sheet1_pol_cd);
            var pgmNo = "&pgmNo=ESM_BKG_1090";
            var url = "ESM_BKG_1090.do?" + param + pgmNo;
            
            rValue = ComOpenPopup(url, _Width, _Height, 'getBKG_1090', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
            getBKG_1090(rValue);
            break;

        case "btn_t10caf":
            var debug = false;
            // 1. map으로 CAF 목록을 만든다.
            CAF_MAP = null;
            CAF_MAP = new fnBkgJsMap();
            var cnt = sheetObject2.RowCount;
            for ( var ix = 1; ix <= cnt; ix++) {
                var charge      = sheetObject2.CellValue(ix, prefix2 + "chg_cd");
                var currency    = sheetObject2.CellValue(ix, prefix2 + "curr_cd");
                var type_charge = charge +"("+currency+")";
                if(charge == "CAF") type_charge = "CAF";
                var amount      = sheetObject2.CellValue(ix, prefix2 + "chg_amt");
                
                if (CAF_MAP.containsKey(type_charge)) {
                    //동일한 운임이  있으면  합산한다.
                    var cobj = CAF_MAP.get(type_charge);// 비교대상
                    if (cobj.currency == currency) {
                        // 화폐가 동일하면 합산한다.
                        cobj.amount = parseFloat(cobj.amount) + parseFloat(amount)
                    } else {
                        
                        //화폐가 다르다
                        cobj.diffyn = 'Y';
                        // 동일한 운임이 아님.
                        var obj = new Object();
                        obj.charge = charge;
                        obj.currency = currency;
                        obj.amount = amount;
                        obj.diffyn = 'N'; // 초기값 다르지 않음.
                        CAF_MAP.put(type_charge, obj);                      
                    }
                }else{
                    
                    //동일한 운임이  아님.
                    var obj = new Object();
                    obj.charge = charge;
                    obj.currency = currency;
                    obj.amount = amount;
                    obj.diffyn = 'N'; // 초기값 다르지 않음.
                    CAF_MAP.put(type_charge, obj);
                }
            }
            
            var _Width = '530';
            var _Height = '310';
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no);
            var url = "ESM_BKG_0700.do?" + param + pgmNo;;
            rValue = ComOpenPopup(url, _Width, _Height, 'getBKG_1090', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
            getBKG_1090(rValue);
            break;

        case "btn_t10RoutId":
            var url = "ESM_BKG_1606.do?func=&mst_rfa_rout_id="+sheetObjects[0].CellValue(1, prefix1 + "mst_rfa_rout_id");
            ComOpenWindowCenter(url, "ESM_BKG_1606", 300, 150, false);
            break;
        /** * BUTTON Charge (S) ** */

        case "btn_t10bkg_qty":
            var pgmNo = "&pgmNo=ESM_BKG_1051";
            var bkg_no = ComGetObjValue(formObj.bkg_no);
            var url = "ESM_BKG_1051.do?func=&bkg_no="+bkg_no+pgmNo;
            ComOpenWindowCenter(url, "ESM_BKG_1051", 860, 450, false);
            break;
            
        case "btn_t10retrieve":
            fnClearForm();
            fnClearSelect('svc_scp_cd');// Service Scope
            doActionIBSheet(sheetObject1, formObj, IBSEARCH);
            auto_rating = "false";
            break;

        case "btn_t10save":
            if (!containsFrtTermCd()) return;
            
            var v_bkg_no = ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
            var v_rfa_no = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
            var v_date = ComGetObjValue(formObj.application_date);
            
            if(v_rfa_no.substring(5,6) =="G") {
                if(!fnRfaSpotPricingAvailable(v_bkg_no ,v_rfa_no,v_date)) {
                    ComShowCodeMessage("BKG08329");
                    return;
                }
            }

            tab_alert_msg = true;
            doActionIBSheet(sheetObject2, formObj, IBSAVE);
            auto_rating = "false";
            break;

        case "btn_t10auto_rating":
            if (!containsFrtTermCd()) return;
            //by 김태경 DUM으로 시작하는 경우 return;          
            if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 
            || formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 
            || formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1){
                //ComShowCodeMessage("BKG08121");
                // return; by 김태경
            }
            if ('' == ComGetObjValue(formObj.frm_t10sheet1_sc_no1)
                &&  '' == ComGetObjValue(formObj.frm_t10sheet1_rfa_no)
                &&  '' == ComGetObjValue(formObj.frm_t10sheet1_taa_no)
            ) {
                ComShowMessage(ComGetMsg("BKG08148"));return ;
            }
            if (formObj.brk_dwn_flg.checked) {
                ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
            } else {
                ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "N");
            }
            if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
                ComShowCodeMessage("BKG00048");
                return;
            }
            if(formObj.bkg_no.value == '' || formObj.bkg_no.value.length < 11){
                ComShowMessage(ComGetMsg("BKG00399"));  return ;
            }
            if(formObj.bl_no.value == ''){
                ComShowMessage(ComGetMsg("BKG00400"));  return ;
            }
            if(formObj.frm_t10sheet1_rt_aply_dt.value == ''){
                ComShowMessage(ComGetMsg("BKG08086"));
                ComSetFocus(formObj.frm_t10sheet1_rt_aply_dt); return ;
            }
            if(ComGetObjValue(formObj.bkg_no)!= ComGetObjValue(formObj.frm_t10sheet1_bkg_no)
             ||ComGetObjValue(formObj.bl_no)!= ComGetObjValue(formObj.frm_t10sheet1_bl_no)
            ){
                ComShowMessage(ComGetMsg("BKG01053"));return ;
            }
            //by 김태경 . svc 코드 없으면 return;
            if(ComGetObjValue(formObj.svc_scp_cd).trim() == ''){
                ComShowMessage(ComGetMsg("BKG08136"));
                ComSetFocus(formObj.svc_scp_cd); return ;
            }
            ComSetObjValue(formObj.svc_scp_cd,ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd));    
            //by 김태경 추가  RFA 존재시 check! 값이 있으면 Y return;  
            //by 김태경 막아주세요.
            //if(fnAutoRatingRFACheck(ComGetObjValue(formObj.frm_t10sheet1_bkg_no))){ return;}
                        
            var _Width = '1050';
            var _Height = '550';
            auto_rating = true;
            ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
            ComSetObjValue(formObj.sc_no, ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
            var v_bkg_no = ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
            var v_rfa_no = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
            var v_date = ComGetObjValue(formObj.application_date);
            var v_sc_no = ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
            var v_taa_no = ComGetObjValue(formObj.frm_t10sheet1_taa_no);
            var v_ca_flg = ComGetObjValue(formObj.caflag);
            var url = '';
            var pgmNo = "&pgmNo=ESM_BKG_0739";
            var param = 
                'bkg_no=' + v_bkg_no + 
                '&application_date=' + v_date + 
                '&rfa_no=' + v_rfa_no +
                '&sc_no=' + v_sc_no + 
                '&taa_no=' + v_taa_no +
                '&frt_term_cd=' + document.getElementById("frt_term_cd").Code +
                '&svc_scp_cd=' + ComGetObjValue(formObj.svc_scp_cd) +
                '&frm_t10sheet1_brk_dwn_flg=' + ComGetObjValue(formObj.frm_t10sheet1_brk_dwn_flg) +  
                '&ca_flg=' + v_ca_flg
                ;
            if('' != v_rfa_no){
                if(fnAutoratingRfaAvailable(v_bkg_no ,v_rfa_no,v_date,v_ca_flg) ){
                    url = "ESM_BKG_0739.do?" + param + pgmNo;
                    // 팝업 0739 오픈전에 아래의 쿼리에서 Y 일경우 Skip N일경우 팝업을 띄워준다
                    rValue = ComOpenPopup(url, _Width, _Height, 'getBKG_0269', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
                    //rValue = ComOpenPopup(url, 1200,1000, 'getBKG_0269', '0,0', true, true, 0, prefix2 + "chg_cd", 1); // for test
                    
                    getBKG_0269(rValue);
                }

            }
            else if('' != ComGetObjValue(formObj.frm_t10sheet1_taa_no)){
                if(fnAutoratingTaaAvailable(v_bkg_no,v_taa_no,v_date,v_ca_flg)){
                    pgmNo = "&pgmNo=ESM_BKG_1076";
                    url = "ESM_BKG_1076.do?" + param + pgmNo;
                    rValue = ComOpenPopup(url, _Width, _Height, 'getBKG_0269','0,0', true, true, 0, prefix2 + "chg_cd", 1);
                    
                    getBKG_0269(rValue);
                }
            }
            
            else if ('' != ComGetObjValue(formObj.frm_t10sheet1_sc_no1)) {
                if(fnAutoratingScAvailable(v_bkg_no ,v_sc_no,v_date,v_ca_flg) ){
                    //팝업 0269 오픈전에 아래의 쿼리에서 Y 일경우 Skip N일경우  팝업을 띄워준다
                    pgmNo = "&pgmNo=ESM_BKG_0269";
                    url = "ESM_BKG_0269.do?" + param + pgmNo;
                    rValue = ComOpenPopup(url, _Width, _Height, 'getBKG_0269', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
                    // rValue = ComOpenWindowCenter2(url, "1111" , 1200,1000,
                    // false,"scrollbars=yes,resizeable=no");//테스트편하기하기위해
                    
                    getBKG_0269(rValue);

                    if(rValue != null){
                        var actionType = rValue[0].actionType;
                        if('Close' != actionType){
                            // by 2010.3.29  김태경,sc_number check! 조건 
                            fnSearchScNoValidationCheck();
                        }
                    }
                }
            }
            break;

        case "btn_t10exchange_rating":
            var _Width = '470';
            var _Height = '470';
            var pgmNo = "&pgmNo=ESM_BKG_0945";
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no);
            var url = "ESM_BKG_0945.do?" + param + pgmNo;;
            ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
            break;

        case "btn_t10clear":
            // bdr 이면서 caf인경우 clear 안함 
            if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
                return;
            }

            sheetObjects[1].RemoveAll(); // Grid 초기화 해줌
            // removeAll 인경우 일괄삭제를 위해
            ComSetObjValue(formObj.removeAll, "Y" );
            
            /**
             * by 김태경 요청 formObj.frm_t10sheet1_bkg_no.value="";
             * formObj.bkg_no.value=""; fnClearForm();
             * fnClearSelect('svc_scp_cd');// Service Scope ComResetAll();
             */
            try{
                parent.initCAControl("", "N", "N", "N", "");
            }catch(e){}
            break;

        case "btn_t10remark":
            if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
                ComShowCodeMessage("BKG00048");
                return;
            }
            var _Width = '750';
            var _Height = '560';
            var pgmNo = "&pgmNo=ESM_BKG_0265";
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)+"&ca_flg="+ ComGetObjValue(formObj.caflag);
            
            /* BDR 상태일 경우 Remark 가 저장 되지 않도록 readOnly Flg 값을 Y 로 던져 준다 */
            /* 김태경 2010.01.17 */
            if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
                var url ="ESM_BKG_0265.do?readOnly=" +'Y'+ "&" + param + pgmNo;
            }else{
                var url = "ESM_BKG_0265.do?" + param + pgmNo;
            }
            rValue = ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
            openFlg = "N";
            doActionIBSheet(sheetObject1, formObj, IBSEARCH);
            break;

        case "btn_t10self":
            
            if(ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
                ComShowMessage(ComGetMsg("BKG00400"));
                ComSetFocus(formObj.frm_t10sheet1_bl_no);
                return false;
            }
            var _Width = '1000';
            var _Height = '728';
            var pgmNo = "&pgmNo=ESM_BKG_0263";
            var param = "bl_no="+ ComGetObjValue(formObj.bl_no).substr(0,12)+"&ca_flg="+ ComGetObjValue(formObj.caflag);
            var url = "ESM_BKG_0263.do?" + param + pgmNo;
            ComOpenPopupWithTarget(url, _Width, _Height, "selfRetrieve", "none", false);
            break;
            
        case "btn_t10tpb_link":
            
            if(ComIsEmpty(formObj.frm_t10sheet1_bkg_no.value)){
                ComShowMessage(ComGetMsg("BKG00463"));
                ComSetFocus(formObj.frm_t10sheet1_bkg_no);
                return false;
            }
            
            var _Width = '680';
            var _Height = '310';
            var pgmNo = "&pgmNo=ESM_BKG_1084";
            var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)
            +"&bl_no="   +  ComGetObjValue(formObj.bl_no).substr(0,12)
            // +"&ntc_seq=" + '2'
            +"&cust_cd=" + ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq)
            +"&cust_nm=" + ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
            var url = "/hanjin/ESM_BKG_1084.do?" + param + pgmNo;
            ComOpenPopupWithTarget(url, _Width, _Height, "", "none", true);
            break;
            
        case "btn_t10search_date":
            var bkg_no = ComGetObjValue(formObj.bkg_no);
            var bdrflag = ComGetObjValue(formObj.bdrflag);
            var caflag = ComGetObjValue(formObj.caflag);
            if(!bkg_no.length > 0 | bkg_no =='') return;
            var pgmNo = "&pgmNo=ESM_BKG_1077";
            var param = 'bkg_no='+bkg_no+"&bdrflag="+bdrflag+"&caflag="+caflag;
            var url = "ESM_BKG_1077.do?"+ param + pgmNo;
            rValue = ComOpenPopup(url, 500, 450, 'getBKG_1077', '0,0', true, true, 0, prefix2 + "bkg_no", 1);
            if(rValue == undefined) return;
            getBKG_1077(rValue);
            break;
            
        case "btn_t103rdBLReq":
//            doActionIBSheet(sheetObject1,formObj,COMMAND08);     
            ComOpenWindowCenter("ESM_BKG_9460.do?ui_id=ESM_BKG_0079_08&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&pop_mode=1", "ESM_BKG_9460", 1020, 600, false);
            break;
            
        case "btn_t10cust_link":
            
            var param = "?pgmNo=ESM_BKG_0241&bkg_no="+ ComGetObjValue(formObj.bkg_no) + "&bkg_rt_flg=Y";
            var sUrl  = "ESM_BKG_0241.do"+param;
                        
            ComOpenWindowCenter(sUrl, "ESM_BKG_0241",600,400, false);           
            break;

        /*********************************
        [CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가
        ITS/방지경 대리 요청으로 추후 반영
        case "btn_t10chg_amend":
            chargeAmendRequest();
            break;
        *********************************/

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
            fnBkgErrorAlert('processButtonClick', e);
        } else {
            ComShowMessage(e);
        }
    }
}


var comp_bl_no = '';
var comp_rt_aply_dt ='';
var comp_sc_no1 ='';
var comp_rfa_no ='';
var comp_taa_no ='';
var comp_pofc_cd ='';
var comp_pcnt_cd ='';
var comp_pcust_seq ='';
var comp_cofc_cd ='';
var comp_ccnt_cd ='';
var comp_ccust_seq ='';

/**
 * fnModifyCheckBefore 기본정보 셋팅 param :
 */
function fnModifyCheckBefore(){
    var formObj  = document.form;
     comp_bl_no = ComGetObjValue(formObj.frm_t10sheet1_bl_no);
     comp_rt_aply_dt = ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt);
     comp_sc_no1 = ComGetObjValue(formObj.frm_t10sheet1_sc_no1);
     comp_rfa_no = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
     comp_taa_no = ComGetObjValue(formObj.frm_t10sheet1_taa_no);
     comp_pofc_cd = ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd);
     comp_pcnt_cd = ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
     comp_pcust_seq = ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
     comp_cofc_cd = ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd);
     comp_ccnt_cd = ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
     comp_ccust_seq = ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
}

/**
 * fnModifyCheckAfter 기본정보 변경여부 
 * param :
 */
function fnModifyCheckAfter(){
    var formObj = document.form;
    var bmodify = false;
    if(comp_bl_no != ComGetObjValue(formObj.frm_t10sheet1_bl_no)){
        bmodify = true;
    }
    if(comp_rt_aply_dt != ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt)){
        bmodify = true;
    }
    if(comp_sc_no1 != ComGetObjValue(formObj.frm_t10sheet1_sc_no1)){
        bmodify = true;
    }
    if(comp_rfa_no != ComGetObjValue(formObj.frm_t10sheet1_rfa_no)){
        bmodify = true;
    }
    if(comp_taa_no != ComGetObjValue(formObj.frm_t10sheet1_taa_no)){
        bmodify = true;
    }
    if(comp_pofc_cd != ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd)){
        bmodify = true;
    }
    if(comp_pcnt_cd != ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd)){
        bmodify = true;
    }
    if(comp_pcust_seq != ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq)){
        bmodify = true;
    }
    if(comp_cofc_cd != ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd)){
        bmodify = true;
    }
    if(comp_ccnt_cd != ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd)){
        bmodify = true;
    }
    if(comp_ccust_seq != ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq)){
        bmodify = true;
    }

    if(bmodify){
        ComSetObjValue(document.form.modify_flag, "Y");
    }
    return true;
}


/**
* fnSearchScNoValidationCheck 함수 .<br>
* @param sc_no
*/
function fnSearchScNoValidationCheck(){
    var formObj = document.form;
    var v_date = ComGetObjValue(formObj.application_date);
    var v_sc_no = ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);

    // 1.validation
    if('' == v_sc_no ) return;
    if('' == v_date ) return;
    
    var input_text =  v_sc_no+"|"+ v_date;
    
    // 2.search
    var param = param + "&f_cmd=" + SEARCH02 + "&input_text=" + input_text;
    var sXml = sheetObjects[1].GetSearchXml("ESM_Booking_UtilGS.do", param);
    var output_text = ComGetEtcData(sXml, "output_text");
    // 3.output
    if ('Y' != output_text) {
        ComShowMessage(ComGetMsg("BKG08147", v_sc_no ));
        return ;
    }
}
/**
* fnRowHidden 함수 .<br>
* @param sheetObj,r
*/
function fnRowHidden(sheetObj,r){
    sheetObj.RowHidden(r)= true;
    sheetObj.RowStatus(r)= "D";
}

/**
 * charge_cd callback 함수 getBKG_0269 호출 .<br>
 * @param _val
 */
function getBKG_0269(_val) {
    
    if (_val == null || _val == undefined ) return;
    
    var formObj = document.form;
    var obj = _val;
    var sheetObj = sheetObjects[1];
    var sheetObj6 = sheetObjects[6]
    var ct = sheetObj.RowCount;

    // 0.default 값 생성
    var y = 0;
    var sheetObj0 = sheetObjects[0];

    sheetObj0.CellValue(1, prefix1 + "prc_rt_mtch_patt_cd")     = obj[y].prcPttCd;
    sheetObj0.CellValue(1, prefix1 + "prc_gen_spcl_rt_tp_cd")   = obj[y].genSpclTp;
    sheetObj0.CellValue(1, prefix1 + "prc_cmdt_hdr_seq")        = obj[y].cmdtHdrSeq;
    sheetObj0.CellValue(1, prefix1 + "prc_rout_seq")            = obj[y].routSeq;
    sheetObj0.CellValue(1, prefix1 + "calc_ctrt_tp_cd")         = obj[y].calcCtrtTp;
    sheetObj0.CellValue(1, prefix1 + "mst_rfa_rout_id")         = obj[y].mstRfaRoutId;
    

    if(obj[y].mstRfaRoutId == "" && obj.length > 1){
        for ( var p = 1; p < obj.length; p++) {
            if(sheetObj0.CellValue(1, prefix1 + "mst_rfa_rout_id") == "" && obj[p].mstRfaRoutId != ""){
                sheetObj0.CellValue(1, prefix1 + "mst_rfa_rout_id") = obj[p].mstRfaRoutId;
            }
        }
    }
    

    var actionType = obj[y].actionType;
    var rowInsert = false;
    var ar = 0; 
    var z = 0;  // data값 셋팅
    var newRow = 0; // OFT : 신규 로우 추가
    var newRow6 = 0;    // history OFT : 신규 로우 추가
    var rArray   = new Array();
    ComOpenWait(true);
 
    // AUTO RATING 인경우 일괄삭제를 위해
    ComSetObjValue(formObj.autoRate, "Y" );
    
    //AUTO RATING HISTORY Sheet 초기화
    sheetObjects[6].RemoveAll();
    
    if('Close' == actionType){
        //1. close 했을경우 
        if (ComShowConfirm(ComGetMsg("BKG08108"))) {

            //무조건  Grid 초기화 해줌  M인것 한다. 
            for ( var ir = 1; ir <= ct; ir++) {
                var auto_rat_cd = sheetObj.CellValue(ir, prefix2 + "auto_rat_cd");
                if ('M' != auto_rat_cd && 'I' != auto_rat_cd) {
                    fnRowHidden(sheetObj,ir);// 2.행 숨기기
                }
            }
    
            var tcnt = obj.length;
            for ( var z = 0; z < tcnt; z++) {
                
                if(undefined == obj[z]) break;
                if( '' == obj[z].charge || undefined == obj[z].charge) continue;
                newRow = sheetObj.DataInsert(-1);
                newRow6 = sheetObj6.DataInsert(-1);
                var term = obj[z].term;
                var term1,term2;
                if(term != null){
                    term = obj[z].term.split("/");
                    term1= term[0];
                    term2= term[1];
                }
                sheetObj.RowStatus(newRow)= "R";
                sheetObj.CellValue(newRow, prefix2 + "chg_cd")      = obj[z].charge;
                sheetObj.CellValue(newRow, prefix2 + "curr_cd")     = obj[z].cur;
                sheetObj.CellValue(newRow, prefix2 + "rat_ut_cd")   = obj[z].per;
                sheetObj.CellValue(newRow, prefix2 + "rat_ut2_cd")  = obj[z].rat_ut2_cd;
                sheetObj.CellValue(newRow, prefix2 + "rat_ut3_cd")  = obj[z].rat_ut3_cd;

                sheetObj.CellValue(newRow, prefix2 + "chg_ut_amt")  = obj[z].rate;
                sheetObj.CellValue(newRow, prefix2 + "rat_as_qty")  = obj[z].rate_as;

                /* History 항목  추가 */            
                sheetObj6.RowStatus(newRow6)= "R";
                sheetObj6.CellValue(newRow6, prefix7 + "chg_cd")        = obj[z].charge;
                sheetObj6.CellValue(newRow6, prefix7 + "curr_cd")   = obj[z].cur;
                sheetObj6.CellValue(newRow6, prefix7 + "rat_ut_cd")     = obj[z].per;
                sheetObj6.CellValue(newRow6, prefix7 + "rat_ut2_cd")    = obj[z].rat_ut2_cd;
                sheetObj6.CellValue(newRow6, prefix7 + "rat_ut3_cd")    = obj[z].rat_ut3_cd;

                sheetObj6.CellValue(newRow6, prefix7 + "chg_ut_amt")    = obj[z].rate;
                sheetObj6.CellValue(newRow6, prefix7 + "rat_as_qty")    = obj[z].rate_as;

                /*
                 * Per Type 이 PC 일 경우 AMT 넘겨 받아 강제로 박아줌 Charge 화면에 ''을 넘길경우 %
                 * 계산이 안되고 자동 계산 됨
                 */
                if(obj[z].per == "PC"){
                    sheetObj.CellValue(newRow, prefix2 + "chg_amt")     = obj[z].amt;
                }
                sheetObj6.CellValue(newRow6, prefix7 + "chg_amt")   = obj[z].amt;               
                
                sheetObj.CellValue(newRow, prefix2 + "incl_oft_flg")= obj[z].incl;
                sheetObj.CellValue(newRow, prefix2 + "frt_term_cd") = obj[z].term_cd;
                sheetObj.CellValue(newRow, prefix2 + "cgo_cate_cd") = obj[z].cargo;
                sheetObj.CellValue(newRow, prefix2 + "rcv_term_cd") = term1;
                sheetObj.CellValue(newRow, prefix2 + "de_term_cd")  = term2;
                sheetObj.CellValue(newRow, prefix2 + "auto_rat_cd") = obj[z].m;
                sheetObj.CellValue(newRow, prefix2 + "imdg_clss_cd")= obj[z].imo;
                sheetObj.CellValue(newRow, prefix2 + "note_rt_seq") = obj[z].noteRtSeq;
                sheetObj.CellValue(newRow, prefix2 + "prop_no")     = obj[z].propNo;
                sheetObj.CellValue(newRow, prefix2 + "amdt_seq")    = obj[z].amdtSeq;
                sheetObj.CellValue(newRow, prefix2 + "svc_scp_cd")  = obj[z].svcScpCd;
                sheetObj.CellValue(newRow, prefix2 + "gen_spcl_rt_tp_cd") = obj[z].genSpclTp;
                sheetObj.CellValue(newRow, prefix2 + "cmdt_hdr_seq") = obj[z].cmdtHdrSeq;
                sheetObj.CellValue(newRow, prefix2 + "rout_seq")    = obj[z].routSeq;
                if(obj[z].soc == 'Y'){
                    sheetObj.CellValue(newRow, prefix2 + "soc_flg")     = obj[z].soc;
                }
                if(obj[z].hdn == 'Y'){
                    sheetObj.CellValue(newRow, prefix2 + "prn_hdn_flg")     = 1;
                }
                
                /* History 항목 추가 */                     
                sheetObj6.CellValue(newRow6, prefix7 + "incl_oft_flg")= obj[z].incl;
                sheetObj6.CellValue(newRow6, prefix7 + "frt_term_cd") = obj[z].term_cd;
                sheetObj6.CellValue(newRow6, prefix7 + "cgo_cate_cd") = obj[z].cargo;
                sheetObj6.CellValue(newRow6, prefix7 + "rcv_term_cd") = term1;
                sheetObj6.CellValue(newRow6, prefix7 + "de_term_cd")    = term2;
                sheetObj6.CellValue(newRow6, prefix7 + "auto_rat_cd") = obj[z].m;
                sheetObj6.CellValue(newRow6, prefix7 + "imdg_clss_cd")= obj[z].imo;
                sheetObj6.CellValue(newRow6, prefix7 + "note_rt_seq") = obj[z].noteRtSeq;
                sheetObj6.CellValue(newRow6, prefix7 + "prop_no")   = obj[z].propNo;
                sheetObj6.CellValue(newRow6, prefix7 + "amdt_seq")  = obj[z].amdtSeq;
                sheetObj6.CellValue(newRow6, prefix7 + "svc_scp_cd")    = obj[z].svcScpCd;
                sheetObj6.CellValue(newRow6, prefix7 + "gen_spcl_rt_tp_cd") = obj[z].genSpclTp;
                sheetObj6.CellValue(newRow6, prefix7 + "cmdt_hdr_seq") = obj[z].cmdtHdrSeq;
                sheetObj6.CellValue(newRow6, prefix7 + "rout_seq")  = obj[z].routSeq;
                if(obj[z].soc == 'Y'){
                    sheetObj6.CellValue(newRow6, prefix7 + "soc_flg")     = obj[z].soc;
                }
                if(obj[z].hdn == 'Y'){
                    sheetObj6.CellValue(newRow6, prefix7 + "prn_hdn_flg")   = 1;
                }
            }
        }

    }else{
    
        // row 추가
        rowInsert=true;
        
        // Grid 초기화 해줌 A인것 한다.
        for ( var ir = 1; ir <= ct; ir++) {
            if(sheetObj.RowHidden(ir) || sheetObj.RowStatus(ir) == "D")continue; // hidden인경우           
            var auto_rat_cd = sheetObj.CellValue(ir, prefix2 + "auto_rat_cd");
            var chg_cd      = sheetObj.CellValue(ir, prefix2 + "chg_cd");
            var chg_ut_amt  = sheetObj.CellValue(ir, prefix2 + "chg_ut_amt");
            
            if ('M' != auto_rat_cd && 'I' != auto_rat_cd) {
                //[추가조건]OFT 이고 Rate 값이 0 이며 *M 이 'A' or 'U' 인것만 지워주시면 됩니다.
                if('OFT' == chg_cd && '0' == chg_ut_amt ){ 
                    fnRowHidden(sheetObj,ir);// 2.행 숨기기
                }else{
                    fnRowHidden(sheetObj,ir);// 2.행 숨기기
                }
            }
        }
            
        // by 김태경 frm_appldt : frm_cmdt_cd,
        var c_leng = obj.length - 1;
        if('Commodity' == obj[c_leng].actionType){
            ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt , obj[c_leng].appldt);
            ComSetObjValue(formObj.frm_t10sheet1_cmdt_cd    , obj[c_leng].cmdtcd);
            ComSetObjValue(formObj.frm_t10sheet1_cmdt_nm    , obj[c_leng].cmdtnm);
            ComSetObjValue(formObj.frm_t10sheet1_rep_cmdt_cd, obj[c_leng].repcmdtcd);
            ComSetObjValue(formObj.frm_t10sheet1_rep_cmdt_nm, obj[c_leng].repcmdtnm);
//alert("obj[c_leng].rtroFlg : ====" + obj[c_leng].rtroFlg);
            ComSetObjValue(formObj.frm_t10sheet1_rtro_flg, obj[c_leng].rtroFlg);        
        }else if('TAA_No' == obj[c_leng].actionType){
        //by 김태경  tripropno :  frm_t10sheet1_taa_no, 
            sheetObj.CellValue(1, prefix2 + "trf_itm_no") = obj[c_leng].tripropno;
        }
    }
 
    //신규로우 추가여부 판단 
    if(rowInsert){
        //no data not found 시
        if(ct == 0) sheetObj.RemoveAll(); // Grid 초기화 해줌

        var tcnt = obj.length;
        for ( var z = 0; z < tcnt; z++) {
            
            if(undefined == obj[z]) break;
            if( '' == obj[z].charge || undefined == obj[z].charge) continue;

            if( 'OFT'  == obj[z].charge){ 
                newRow = sheetObj.DataInsert(0);
                newRow6 = sheetObj6.DataInsert(0);
            }else{ 
                newRow = sheetObj.DataInsert(-1);
                newRow6 = sheetObj6.DataInsert(-1)
            }
            var term = obj[z].term;
            var term1,term2;
            if(term != null){
                term = obj[z].term.split("/");
                term1= term[0];
                term2= term[1];
            }
            sheetObj.RowStatus(newRow)= "R";
            sheetObj.CellValue(newRow, prefix2 + "bkg_no")      = ComGetObjValue(formObj.bkg_no);
            sheetObj.CellValue(newRow, prefix2 + "chg_cd")      = obj[z].charge;
            sheetObj.CellValue(newRow, prefix2 + "curr_cd")     = obj[z].cur;
            sheetObj.CellValue(newRow, prefix2 + "rat_ut_cd")   = obj[z].per;
            sheetObj.CellValue(newRow, prefix2 + "rat_ut2_cd")  = obj[z].rat_ut2_cd;
            sheetObj.CellValue(newRow, prefix2 + "rat_ut3_cd")  = obj[z].rat_ut3_cd;
            sheetObj.CellValue(newRow, prefix2 + "trf_itm_no") = obj[z].trino;
            sheetObj.CellValue(newRow, prefix2 + "chg_ut_amt")  = obj[z].rate;
            if ('OFT'  == obj[z].charge && 'BL' == obj[z].per) {                    
                sheetObj.CellValue(newRow, prefix2 + "rat_as_qty")  = 1.00;         
            }else{
                sheetObj.CellValue(newRow, prefix2 + "rat_as_qty")  = obj[z].rate_as;
            }
             
            sheetObj6.RowStatus(newRow6)= "R";
            sheetObj6.CellValue(newRow6, prefix7 + "bkg_no")        = ComGetObjValue(formObj.bkg_no);
            sheetObj6.CellValue(newRow6, prefix7 + "chg_cd")        = obj[z].charge;
            sheetObj6.CellValue(newRow6, prefix7 + "curr_cd")   = obj[z].cur;
            sheetObj6.CellValue(newRow6, prefix7 + "rat_ut_cd")     = obj[z].per;
            sheetObj6.CellValue(newRow6, prefix7 + "rat_ut2_cd")    = obj[z].rat_ut2_cd;
            sheetObj6.CellValue(newRow6, prefix7 + "rat_ut3_cd")    = obj[z].rat_ut3_cd;
            
            sheetObj6.CellValue(newRow6, prefix7 + "chg_ut_amt")    = obj[z].rate;
            if ('OFT'  == obj[z].charge && 'BL' == obj[z].per) {                    
                sheetObj6.CellValue(newRow6, prefix7 + "rat_as_qty") = 1.00;            
            }else{
                sheetObj6.CellValue(newRow6, prefix7 + "rat_as_qty") = obj[z].rate_as;
            }
            
            /*
             * Per Type 이 PC 일 경우 AMT 넘겨 받아 강제로 박아줌 Charge 화면에 ''을 넘길경우 % 계산이
             * 안되고 자동 계산 됨
             */
            if(obj[z].per == "PC"){
                sheetObj.CellValue(newRow, prefix2 + "chg_amt")     = obj[z].amt;
            }
            if('OFT'  == obj[z].charge &&  "BL" == obj[z].per){
                sheetObj6.CellValue(newRow6, prefix7 + "chg_amt") = obj[z].rate * 1;
            }else if('OFT'  == obj[z].charge){
                sheetObj6.CellValue(newRow6, prefix7 + "chg_amt") = obj[z].rate * obj[z].rate_as;
            }else{
                sheetObj6.CellValue(newRow6, prefix7 + "chg_amt")   = obj[z].amt;
            }
            sheetObj.CellValue(newRow, prefix2 + "incl_oft_flg")= obj[z].incl;
            sheetObj.CellValue(newRow, prefix2 + "frt_term_cd") = obj[z].term_cd;
            sheetObj.CellValue(newRow, prefix2 + "cgo_cate_cd") = obj[z].cargo;
            sheetObj.CellValue(newRow, prefix2 + "rcv_term_cd") = term1;
            sheetObj.CellValue(newRow, prefix2 + "de_term_cd")  = term2;
            sheetObj.CellValue(newRow, prefix2 + "auto_rat_cd") = obj[z].m;
            sheetObj.CellValue(newRow, prefix2 + "imdg_clss_cd")= obj[z].imo;
            sheetObj.CellValue(newRow, prefix2 + "note_rt_seq") = obj[z].noteRtSeq;
            sheetObj.CellValue(newRow, prefix2 + "prop_no")     = obj[z].propNo;
            sheetObj.CellValue(newRow, prefix2 + "amdt_seq")    = obj[z].amdtSeq;
            sheetObj.CellValue(newRow, prefix2 + "svc_scp_cd")  = obj[z].svcScpCd;
            sheetObj.CellValue(newRow, prefix2 + "gen_spcl_rt_tp_cd") = obj[z].genSpclTp;
            sheetObj.CellValue(newRow, prefix2 + "cmdt_hdr_seq") = obj[z].cmdtHdrSeq;
            sheetObj.CellValue(newRow, prefix2 + "rout_seq")    = obj[z].routSeq;
            sheetObj.CellValue(newRow, prefix2 + "fx_rt_flg")   = obj[z].fxRtFlg;
            if(obj[z].soc == 'Y'){
                sheetObj.CellValue(newRow, prefix2 + "soc_flg")     = obj[z].soc;
            }
            if(obj[z].hdn == 'Y'){
                sheetObj.CellValue(newRow, prefix2 + "prn_hdn_flg")     = 1;
            }
    
            /* History 항목 추가 */     
            sheetObj6.CellValue(newRow6, prefix7 + "incl_oft_flg")= obj[z].incl;
            sheetObj6.CellValue(newRow6, prefix7 + "frt_term_cd") = obj[z].term_cd;
            sheetObj6.CellValue(newRow6, prefix7 + "cgo_cate_cd") = obj[z].cargo;
            sheetObj6.CellValue(newRow6, prefix7 + "rcv_term_cd") = term1;
            sheetObj6.CellValue(newRow6, prefix7 + "de_term_cd")    = term2;
            sheetObj6.CellValue(newRow6, prefix7 + "auto_rat_cd") = obj[z].m;
            sheetObj6.CellValue(newRow6, prefix7 + "imdg_clss_cd")= obj[z].imo;
            sheetObj6.CellValue(newRow6, prefix7 + "note_rt_seq") = obj[z].noteRtSeq;
            sheetObj6.CellValue(newRow6, prefix7 + "prop_no")   = obj[z].propNo;
            sheetObj6.CellValue(newRow6, prefix7 + "amdt_seq")  = obj[z].amdtSeq;
            sheetObj6.CellValue(newRow6, prefix7 + "svc_scp_cd")    = obj[z].svcScpCd;
            sheetObj6.CellValue(newRow6, prefix7 + "gen_spcl_rt_tp_cd") = obj[z].genSpclTp;
            sheetObj6.CellValue(newRow6, prefix7 + "cmdt_hdr_seq") = obj[z].cmdtHdrSeq;
            sheetObj6.CellValue(newRow6, prefix7 + "rout_seq")  = obj[z].routSeq;
            if(obj[z].soc == 'Y'){
                sheetObj6.CellValue(newRow6, prefix7 + "soc_flg")     = obj[z].soc;
            }
            if(obj[z].hdn == 'Y'){
                sheetObj6.CellValue(newRow6, prefix7 + "prn_hdn_flg")   = 1;
            }
        }
        /**
            [요구사항추가] by 김태경 
            CHARGE CODE 중에 DIH, OIH 가 AUTORATING 시점에 FLG 가 I 로 된게 있으면  
            AUTORATING 에서 금액이 없는 OIH,DIH 값을 받지 않는다
        **/
         var cnt = sheetObj.RowCount;
         var exist_DIH = false;
         var exist_OIH = false;
         //존재여부 확인 
         for ( var ix = 1; ix <= cnt; ix++) {
             if(sheetObj.RowHidden(ix) || sheetObj.RowStatus(ix) == "D") continue;
             if("DIH" == sheetObj.CellValue(ix, prefix2 + "chg_cd") && 'I' == sheetObj.CellValue(ix, prefix2 + "auto_rat_cd")){
                 exist_DIH=true;
             }
             if("OIH" == sheetObj.CellValue(ix, prefix2 + "chg_cd") && 'I' == sheetObj.CellValue(ix, prefix2 + "auto_rat_cd")){
                exist_OIH=true;
             }
         }
         //존재여부 삭제  
         for ( var iz = 1; iz <= cnt; iz++) {
             if(sheetObj.RowHidden(iz) || sheetObj.RowStatus(iz) == "D") continue;
             if("DIH" == sheetObj.CellValue(iz, prefix2 + "chg_cd") && 'I' != sheetObj.CellValue(iz, prefix2 + "auto_rat_cd")){
                 if(exist_DIH)fnRowHidden(sheetObj,iz);// 2.행 숨기기
             }
             if("OIH" == sheetObj.CellValue(iz, prefix2 + "chg_cd") && 'I' != sheetObj.CellValue(iz, prefix2 + "auto_rat_cd")){
                 if(exist_OIH)fnRowHidden(sheetObj,iz);// 2.행 숨기기
             }
         }
    }
    // history sheet copy 
    //fnAutoRatingHistory(sheetObjects[6]);
    // TPsz 값을 맞추어준다.
    fnSetCntrTpsz(sheetObj);
    // note button 색상변경
    fnExistNoteButtonColor();
    

//  var cnt = sheetObj.RowCount;
//  for ( var ix = 1; ix <= cnt; ix++) {
//      fnChargePercentageRate(sheetObj, ix, '', '');
//  }

    //Self-Audit 자동팝업을 열기 위한 조건
    isOpenSelfAudit2 = true;

    setForceFocus();
    ComOpenWait(false);
}
 

 /**
 * fnSetCntrTpsz 이벤트 처리 
 * @param sheetObj
 */
 function fnSetCntrTpsz(sheetObj) {
     var sheetObj2 = sheetObjects[1];
     var sheetObj4 = sheetObjects[3];
     var cnt2 = sheetObj2.RowCount;
     var cnt4 = sheetObj4.RowCount;
     if(cnt4 == 0) return;
     var scell = 0;
     // OFT 맨처음행 선택하기
     for ( var ix = 1; ix <= cnt2; ix++) {
         if (sheetObj2.RowHidden(ix) || sheetObj2.RowStatus(ix) == "D") continue;
         if("OFT" == sheetObj2.CellValue(ix, prefix2 + "chg_cd")){
            sheetObj2.SelectCell(ix,1);
            scell++;
         }
        break;
     } 
     var newRow ;
     var ctp , rat_ut2;
     var tp ,eq_sub; 
    
     for ( var i = 1; i <= cnt4; i++) {
          tp = sheetObj4.CellValue(i, prefix4 + "cntr_tpsz_cd");
          eq_sub = sheetObj4.CellValue(i, prefix4 + "eq_sub");
          sp_cgo = sheetObj4.CellValue(i, prefix4 + "cgo");
          if(eq_sub == '') eq_sub = tp;
         // by 김태경 추가요건 Autorating화면에서 per type 40.20인경우
         ctp= 0; rat_ut2 = '';
         // 비교
         for ( var j = 1; j <= cnt2; j++) {
             if (sheetObj2.RowHidden(j)|| sheetObj2.RowStatus(j) == "D" || 'OFT' != sheetObj2.CellValue(j, prefix2 + "chg_cd")) continue;
             // rat_ut2 = sheetObj2.CellValue(j, prefix2 + "rat_ut_cd"); //
                // auto_rating에서 신규로 받은 값
             rat_ut2 = sheetObj2.CellValue(j, prefix2 + "rat_ut2_cd");
             rat_ut3 = sheetObj2.CellValue(j, prefix2 + "rat_ut3_cd");
             cgo     = sheetObj2.CellValue(j, prefix2 + "cgo_cate_cd");
             
             if(tp == rat_ut2 && eq_sub == rat_ut3 && cgo == sp_cgo ){
                 ctp++;// 존재
             }
         }
         // 없을경우 추가 
         if(ctp == 0){
             if(scell>0){
                 newRow = setDataInsert(sheetObj2, 3);// OFT존재 아래행추가
             }else{
                 newRow = setDataInsert(sheetObj2, 4);// 맨상위추가
             }
            sheetObj2.RowStatus(newRow)= "R";
            sheetObj2.CellValue(newRow, prefix2 + "chg_cd")     = 'OFT';
            sheetObj2.CellValue(newRow, prefix2 + "curr_cd")    = 'USD';
            sheetObj2.CellValue(newRow, prefix2 + "rat_ut_cd")  = sheetObj4.CellValue(i, prefix4 + "cntr_tpsz_cd");
            sheetObj2.CellValue(newRow, prefix2 + "rat_as_qty") = sheetObj4.CellValue(i, prefix4 + "qty");
            sheetObj2.CellValue(newRow, prefix2 + "cgo_cate_cd")= sheetObj4.CellValue(i, prefix4 + "cgo");
         }
     }
 }

 
/**
* autoRatingHistory 이벤트 처리 
* @param sheetObj
*/
function fnAutoRatingHistory(sheetObj) {
    // init
    sheetObj.RemoveAll();
    // copy
    sheetObjects[1].Copy2SheetCol(sheetObj,"","",-1,-1,-1,1,false,false);
    // hidden row
    
    for ( var ix = 1; ix <= sheetObj.RowCount; ix++) {
        
        if('D' != sheetObj.CellValue(ix, prefix7 + "ibflag")){
            
            fnRowHidden(sheetObj,ix);// 2.행 숨기기
        }
    }
    for ( var ix = 1; ix <= sheetObj.RowCount; ix++) {
        if('A' != sheetObj.CellValue(ix, prefix7 + "auto_rat_cd")){
            fnRowHidden(sheetObj,ix);// 2.행 숨기기
        }
    }
}

/**
 * Sheet관련 컬럼 onClick 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
 var temp_value = '';
 var change_prn_hdn_flg = false;
 function t10sheet2_OnBeforeEdit(sheetObj, Row, Col) {
     t10sheet2_OnClick(sheetObj, Row, Col);
 }
 function t10sheet2_OnClick(sheetObj, Row, Col, Value) {
      var formObj = document.form;
        var type_gubun = sheetObj.ColSaveName(Col);
        if ( type_gubun == prefix2 + "chg_cd"
            || type_gubun == prefix2 + "trf_itm_no"
            || type_gubun == prefix2 + "curr_cd"
            || type_gubun == prefix2 + "chg_ut_amt"
            || type_gubun == prefix2 + "rat_as_qty"
            || type_gubun == prefix2 + "n3pty_rcv_ofc_cd"
            || type_gubun == prefix2 + "n3pty_cust_cnt_cd"
            || type_gubun == prefix2 + "n3pty_cust_seq"
            || type_gubun == prefix2 + "incl_oft_flg"
            || type_gubun == prefix2 + "frt_term_cd"
        ) {
            temp_value = sheetObj.CellText(Row, Col) ;
        }
        
        if ( type_gubun == prefix2 + "prn_hdn_flg"){
            change_prn_hdn_flg = true;
        }
        
        //OFT Inlcuding charge/surcharge 선택시 Row Delete 버튼을 비활성화 
        if ('N' == ComGetObjValue(formObj.bdrflag) || 'Y' == ComGetObjValue(formObj.caflag)){
            var inclFlg = sheetObj.CellValue(Row, prefix2 + "incl_oft_flg"); // 기준
            if(inclFlg == 'I'){
                ComBtnDisable("btn_t10del");
            }else
                ComBtnEnable("btn_t10del");
        }
}


/**
 * Sheet관련 컬럼 OnChange 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function t10sheet2_OnChange(sheetObj, Row, Col, Value) {
    var formObj = document.form;
    var chg_cd = sheetObj.CellValue(Row, prefix2 + "chg_cd");
    if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd") {
        if (
            ('WHF' == chg_cd )&&('N' == ComGetObjValue(formObj.frm_t10sheet1_bkg_rt_whf_expt_cd))
        ){
            ComShowCodeMessage("BKG00971"); 
        }
        /**
        결과 14. CHARGE가 FRB인 경우
            Hide를 켜주는 로직
         *  요청자: 신자영
         */
        if ('FRB' == chg_cd ){
            sheetObj.CellValue2(Row, prefix2 + "prn_hdn_flg") = 1;
        }else{
            sheetObj.CellValue2(Row, prefix2 + "prn_hdn_flg") = 0;
        }
        
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt" || sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
        /*
         * Rate x rated as/100 = amount
         */
         sheetObj.CellValue2(Row, prefix2 + "chg_amt") 
            = fnCalcAmount(sheetObj.CellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.CellValue(Row, prefix2 + "rat_as_qty"));
         
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty") {
        /*
         * Rate x rated as/100 = amount
         */
        sheetObj.CellValue2(Row, prefix2 + "chg_amt") 
            = fnCalcAmount(sheetObj.CellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.CellValue(Row, prefix2 + "rat_as_qty"));

    } else if (sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg") {
        /*
         * 유저가 I/N 변경 가능. Indicator 종류 : I / N / E
         * IN의 자동표시 로직은 PRI와 확인필요
         * I/E인 경우 기울임 체로 표시
         * I/E인 경우 charge code 부분에 색깔처리(화면 참조)
         */
        var incl_oft_flg = sheetObj.CellValue(Row, prefix2 + "incl_oft_flg").toUpperCase();
        sheetObj.CellValue2(Row, prefix2 + "incl_oft_flg") = incl_oft_flg;
        if ('I' == incl_oft_flg) {
            sheetObj.CellFont("FontItalic", Row, 1,Row,24) = true;          
            sheetObj.CellBackColor(Row, prefix2 + "chg_cd") = sheetObj.RgbColor(153, 204, 255);// blue
        }else{
            sheetObj.CellFont("FontItalic", Row, 1,Row,24) = false;
            sheetObj.CellBackColor(Row, prefix2 + "chg_cd") = sheetObj.RgbColor(255, 255, 255);// white
        }
    
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd") {
        /*
         * P - prepaid. C - collect
         * RF건에 대해서는 collect 불가하도록 validation필요
         */
        var frt_term_cd = sheetObj.CellValue(Row, prefix2 + "frt_term_cd").toUpperCase();
        var cgo_cate_cd = sheetObj.CellValue(Row, prefix2 + "cgo_cate_cd").toUpperCase();
        sheetObj.CellValue2(Row, prefix2 + "frt_term_cd") = frt_term_cd;
        var incl_oft_flg = sheetObj.CellValue(Row, prefix2 + "incl_oft_flg");
        if ('RF' == cgo_cate_cd && 'C' == frt_term_cd && 'N' == incl_oft_flg ) {
            //ComShowCodeMessage("BKG08057");
        }
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "rcv_term_cd") {
        sheetObj.CellValue2(Row, prefix2 + "rcv_term_cd") = sheetObj.CellValue(Row, prefix2 + "rcv_term_cd").toUpperCase();
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "de_term_cd") {   
        sheetObj.CellValue2(Row, prefix2 + "de_term_cd") = sheetObj.CellValue(Row, prefix2 + "de_term_cd").toUpperCase();
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "cgo_cate_cd") {
        /*
         * P ? prepaid. C ? collect
         * RF건에 대해서는 collect 불가하도록 validation필요
         */
        var frt_term_cd = sheetObj.CellValue(Row, prefix2 + "frt_term_cd");
        var cgo_cate_cd = sheetObj.CellValue(Row, prefix2 + "cgo_cate_cd");
        var incl_oft_flg = sheetObj.CellValue(Row, prefix2 + "incl_oft_flg");
        if ('RF' == cgo_cate_cd && 'C' == frt_term_cd && 'N' == incl_oft_flg ) {
            //ComShowCodeMessage("BKG08057");
        }
        var cgo_cate_cd = sheetObj.CellValue(Row, prefix2 + "cgo_cate_cd");
        if(cgo_cate_cd != 'DR' && cgo_cate_cd != 'DG' && cgo_cate_cd != 'RF' && cgo_cate_cd != 'AK' && cgo_cate_cd != 'BB'){
            sheetObj.CellValue(Row, prefix2 + "cgo_cate_cd") = '';
        }       
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "soc_flg") {  
        var soc_flg = sheetObj.CellValue(Row, prefix2 + "soc_flg").toUpperCase();
        sheetObj.CellValue2(Row, prefix2 + "soc_flg") = soc_flg;
    }
    
    if(formObj.bdrflag.value == "Y" && formObj.caflag.value == "N"){
        ComSetObjValue(document.form.modify_flag, "N");
    }else{
        ComSetObjValue(document.form.modify_flag, "Y");
    }


    /* 2010.04.28 김태경
     * 해당 Sheet 에 대해서 OnChange 에 
     * KRW,JPY,IDR,ITL 인 경우 소수점 절삭 하여 보여준다 */
    fnSplitAmount();
}
 /**
  *  Rate x rated as = amount 계산 처리 
  * @param  val1,val2
  */
 function fnCalcAmount(val1,val2) {
     
    var amount = Math.round(parseFloat(val1) * parseFloat(val2) * 100)/100;
    
    return amount;
 }

  /**
   *  Rate x rated as/100 = amount 계산 처리 
   * @param  val1,val2
   */
 function fnCalcRateAmount(val1,val2) {
    var amount = (parseFloat(val1) * parseFloat(val2))/100;
    return amount;
 }
  
   /**
    * fnCAFCheck 호출 .<br>
    * charge 화면에서 CAF가 특정 금액으로 지정되어서 auto rating 된 경우는 CAF 계산에 의해서
    * update 되지 않도록 해야 함.
    * CAF 가 A/M 등록 되어 있으면 return 시킨다
    * @param sheetObj
    */
   function fnCAFCheck(sheetObj){
    var count = 0;
    var idx = 0;
    var cnt = sheetObj.RowCount;
    for ( var ix = 1; ix <= cnt; ix++) {
        var rate_chg_cd = sheetObj.CellValue(ix, prefix2 + "chg_cd");
        if('CAF' == rate_chg_cd && !sheetObj.RowHidden(ix)){
            count++; idx = ix ; 
        }
    }
 
    if(count > 1){
        if(tab_alert_msg){
            ComShowMessage(ComGetMsg("BKG08135"));
        }       
        //var sRow = sheetObj.SelectRow;
        // var findRow = sheetObj.FindText(prefix2 + "chg_cd", "CAF");
        sheetObj.SelectCell(idx, prefix2 + "chg_cd");
        return false;
    }
    return true;
   }
   

    /**
    * Sheet관련 컬럼 OnAfterEdit 엑션 이벤트 처리 
    * @param sheetObj, Row, Col, Value
    * 등록되어 있지 않은 charge code 입력 했을 경우에 다음 error message 표시해 주고
    * blank 처리 “XXX is not registered code. Please check the charge
    * code again.” cmd = SEARCHLIST16 WHF에 면제사유 입력되어 있는 경우 WHF를
    * 추가하려 할 경우 아래 message 표시하고 해당 column은 blank 처리 “WHF exemption
    * reason exists. WHF will not be inputted with exemption reason.” 
    * Item Change로 인식해야 하는 부분들 (Percentage 계산 로직) Charge / Currency / Rate /
    * Rate As / Per / Amount / IN / Term chg_cd | curr_cd | chg_ut_amt |
    * rat_as_qty | rat_ut_cd | incl_oft_flg | frt_term_cd
    */

 function t10sheet2_OnAfterEdit(sheetObj, Row, Col, Value) {
        var formObj         = document.form;

        if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd"
            ||sheetObj.ColSaveName(Col) == prefix2 + "curr_cd"
            ||sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt"
            ||sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty"
            ||sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "n3pty_rcv_ofc_cd" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_cnt_cd" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_seq" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg"
            ||sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd"
            ) {
            if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd") {
                var chg_cd = sheetObj.CellValue(Row, prefix2 + "chg_cd");
                if(chg_cd == '' || undefined == chg_cd) return;
                var param = param + "&f_cmd=" + SEARCHLIST16 + "&input_text=" + chg_cd;
                var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                var output_text = ComGetEtcData(sXml, "output_text");
                if ('Y' != output_text) {
                    ComShowMessage(ComGetMsg("BKG00970", chg_cd ));
                    sheetObj.CellValue(Row, prefix2 + "exist_chg_cd")='N';
                    return ;
                }else{
                    sheetObj.CellValue(Row, prefix2 + "exist_chg_cd")='';
                }

            } else if (sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
                //------------------------------------------------>
                /*
                 * 등록되어 있지 않은 currency code 입력 했을 경우에 다음 error message 표시해 주고
                 * blank 처리“XXX is not registered code. Please check the charge
                 * code again.” cmd = SEARCHLIST18
                 */
                if(temp_value == sheetObj.CellText(Row, Col) ) return;

                var curr_cd = sheetObj.CellValue(Row, prefix2 + "curr_cd");
                if(curr_cd == '' || undefined == curr_cd) return;
                var param = param + "&f_cmd=" + SEARCHLIST18 + "&input_text=" + curr_cd;
                var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                var output_text = ComGetEtcData(sXml, "output_text");
                if ('Y' != output_text) {
                    ComShowCodeMessage("BKG00898");
                    sheetObj.CellValue(Row, prefix2 + "exist_curr_cd")='N';
                    return ;
                }else{
                    sheetObj.CellValue(Row, prefix2 + "exist_curr_cd")='';
                }
            } else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd") {
                //------------------------------------------------>
                /*
                 * 등록되어 있지 않은 currency code 입력 했을 경우에 다음 error message 표시해 주고
                 * blank 처리“XXX is not registered code. Please check the charge
                 * code again.” cmd = SEARCHLIST18
                 */
                if(temp_value == sheetObj.CellText(Row, Col) ) return;
                var rat_ut_cd = sheetObj.CellValue(Row, prefix2 + "rat_ut_cd");
                if(rat_ut_cd == '' || undefined == rat_ut_cd) return;
                var param = param + "&f_cmd=" + COMMAND01 + "&input_text=" + rat_ut_cd;
                var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                var output_text = ComGetEtcData(sXml, "output_text");
                if ('Y' != output_text) {
                    ComShowCodeMessage("BKG00901");
                    sheetObj.CellValue(Row, prefix2 + "exist_rat_ut_cd")='N';
                    return ;
                }else{
                    sheetObj.CellValue(Row, prefix2 + "exist_rat_ut_cd")='';
                    //by 김태경 : 재계산 수행 
                    var cnt = sheetObj.RowCount;
                    for ( var ix = 1; ix <= cnt; ix++) {
                        fnChargePercentageRate(sheetObj, ix, '', '');
                    }
                }       

            } else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_rcv_ofc_cd") {
                /*
                 * SEARCHLIST19  79-08 event체크 Third (Offce cd) 유효성체크 
                 * cmd = SEARCHLIST19
                 */
                if('' == sheetObj.CellText(Row, Col)) {
                    sheetObj.CellValue(Row, prefix2 + "exist_ofc_cd")='';
                    return;
                }
                if(temp_value == sheetObj.CellText(Row, Col) ) return;

                var ofc_cd = sheetObj.CellValue(Row, prefix2 + "n3pty_rcv_ofc_cd");
                if(ofc_cd == '' || undefined == ofc_cd) return;
                var output_text = fnOfcCdCheck(ofc_cd);
                if ('Y' != output_text) {
                    // Third Office is not available
                    ComShowCodeMessage("BKG00044",'Third Office Code'); 
                    sheetObj.CellValue(Row, prefix2 + "n3pty_cust_cnt_cd")  = '';
                    sheetObj.CellValue(Row, prefix2 + "n3pty_cust_seq")     = '';
                    sheetObj.CellValue(Row, prefix2 + "exist_ofc_cd")='N';
                    return ;
                }else{
                    sheetObj.CellValue(Row, prefix2 + "exist_ofc_cd")='';
                    ComShowCodeMessage("BKG08330"); //Please check the actual payer code.
//                  fnRepCustomer(sheetObj,Row,ofc_cd); //default 로 해당 Office 대표 코드가 설정되는데 default code 로써는 빠지도록 함
                }

            } else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_cnt_cd"
            ) {
                /*
                 * SEARCHLIST06  79-08 event체크  Payer (custCntCd) 유효성체크 
                 * cmd = SEARCHLIST06
                 */
                 var cust_cnt_cd = sheetObj.CellValue(Row, prefix2 + "n3pty_cust_cnt_cd");
                 var cust_seq = sheetObj.CellValue(Row, prefix2 + "n3pty_cust_seq");

                if(cust_cnt_cd != '') {
                    var input_text = cust_cnt_cd;
                    var param = param + "&f_cmd=" + SEARCHLIST06 + "&input_text=" + input_text;
                    var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                    var output_text = ComGetEtcData(sXml, "output_text");
                    if ('Y' != output_text) {
                        ComShowCodeMessage("BKG00906");// 존재하지 않는 코드입니다.
                        sheetObj.CellValue(Row, prefix2 + "exist_cust_cnt")='N';
                        return ;
                    }else{
                        sheetObj.CellValue(Row, prefix2 + "exist_cust_cnt")='';
                    }
                    if(cust_seq == '') sheetObj.CellValue(Row, prefix2 + "exist_cust_seq")='N'; 
                }else{
                    sheetObj.CellValue(Row, prefix2 + "exist_cust_cnt")='';
                }
                
            } else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_seq" 
            ) { 
                //------------------------------------------------>
                /*
                 * SEARCHLIST20 79-08 event체크 Payer (custCntCd, custSeq) 유효성체크
                 */
                var cust_cnt_cd = sheetObj.CellValue(Row, prefix2 + "n3pty_cust_cnt_cd");
                var cust_seq = sheetObj.CellValue(Row, prefix2 + "n3pty_cust_seq");
                if(!ComIsNumber(cust_seq) && cust_seq.length != 0 ){
                    ComShowCodeMessage("BKG00458"); // invalid customer code
                }else if(cust_cnt_cd != '' && cust_seq != '') {
                    var input_text = cust_cnt_cd+"|"+cust_seq;
                    var param = param + "&f_cmd=" + SEARCHLIST20 + "&input_text=" + input_text;
                    var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                    var output_text = ComGetEtcData(sXml, "output_text");
                    if ('N' != output_text) {
                        ComShowCodeMessage("BKG00906");// 존재하지 않는 코드입니다.
                        sheetObj.CellValue(Row, prefix2 + "exist_cust_seq")='N';
                        return ;
                    }else{
                        sheetObj.CellValue(Row, prefix2 + "exist_cust_seq")='';
                    }

                }else if(cust_cnt_cd == '' && cust_seq == ''){
                    sheetObj.CellValue(Row, prefix2 + "exist_cust_seq")='';
                }else{
                    if(cust_cnt_cd == ''){
                        sheetObj.SelectCell(Row, prefix2 + "n3pty_cust_cnt_cd");
                    }else if(cust_seq == ''){
                        sheetObj.SelectCell(Row, prefix2 + "n3pty_cust_seq");
                    }
                    sheetObj.CellValue(Row, prefix2 + "exist_cust_seq")='N';
                    return;
                }
            } else if (sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd" 
            ) {
                //------------------------------------------------>
                // "SOME WARNING MSG FOR RATING STAFF'S ATTENTION. For example:
                // a. Hanger cntr, GOH should be ppd
                // b. Reefer cntr, OFT must be ppd.
                // c. Personal effect & used household goods must be ppd.
                var chg_cd      = sheetObj.CellValue(Row, prefix2 + "chg_cd");
                var frt_term_cd = sheetObj.CellValue(Row, prefix2 + "frt_term_cd");

                // 1.부킹 Main에 Reefer 이면 OFT 는 PPD 이어야 됨
                if('Y' == ComGetObjValue(formObj.frm_t10sheet1_rc_flg)){
                    if(chg_cd == 'OFT'&& frt_term_cd != 'P' ) {
                        ComShowCodeMessage("BKG08131");
                    }
                }
                //2.부킹 Main에 Hanger 이고 Charge code가 GOH 는 PPD 이어야 됨
                if('Y' == ComGetObjValue(formObj.frm_t10sheet1_hngr_flg)){
                    if(chg_cd == 'GOH'&& frt_term_cd != 'P' ) {
                        ComShowCodeMessage("BKG08133");
                    }
                }
                //3.CMDT CODE 가 961900 인경우 PPD 이어야 됨
                if('961900' == ComGetObjValue(formObj.frm_t10sheet1_cmdt_cd)){
                    if(frt_term_cd != 'P' ) {
                        //ComShowCodeMessage("BKG08132");
                    }
                }
                
                /**
                 * [화주 편의 제공을 위한 STO pay term 변경 관련 작업1] 시작
                 * 정하나 과장 요청 2017.03.23 // 김동호 수정
                 * STO의 frt_term_cd 변경 시 운임 재계산 하지 않음.
                 */ 
                 if(chg_cd == 'STO') {
                     return;
                 }
                 /**
                 * [화주 편의 제공을 위한 STO pay term 변경 가능 관련 작업1] 끝
                 */ 
            }
            //------------------------------------------------>
            // OFT, ASC charge에 currency가 USD,AUD,EUR,JPY,GBP,DEM이 아닌경우 에러표시
            // [BKG00913] // OFT(or ASC) Currency must be 'USD' or 'AUD' or
            // 'EUR' or 'JPY' or 'GBP' or 'DEM'
            if(sheetObj.ColSaveName(Col) == prefix2 + "chg_cd" || sheetObj.ColSaveName(Col) == prefix2 + "curr_cd"){
                var chg_cd = sheetObj.CellValue(Row, prefix2 + "chg_cd");
                var curr_cd = sheetObj.CellValue(Row, prefix2 + "curr_cd");
                
                if(chg_cd != '' && curr_cd != ''){
                    if('OFT' == chg_cd ||'ASC' == chg_cd){
                        if('USD' == curr_cd||'AUD' == curr_cd|| 'EUR' == curr_cd ||'JPY' == curr_cd||'GBP' == curr_cd||'DEM' == curr_cd ){
                        }else{
                            ComShowCodeMessage("BKG00913");
                        }
                    }
                }
            }
            
            // sheet에서 BL로 변경되는 경우만 1로 셋팅해준다. // per가 BL일 경우만 1로 셋팅한다. :신자영
            var rate_rat_ut_cd = sheetObj.CellValue(Row, prefix2 + "rat_ut_cd");
            if(sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd"){
                if ('BL' == rate_rat_ut_cd ) {                  
                    sheetObj.CellValue(Row, prefix2 + "rat_as_qty") = 1.00;         
                }
            }
            
            /**
             * [화주 편의 제공을 위한 STO pay term 변경 관련 작업2] 시작
             * 정하나 과장 요청 2017.03.23 // 김동호 수정
             * STO 관련 요금 정보 변경 시에만 STO pay term 을 OFT pay term으로 원복 후 운임 재계산 됨. 
             */ 
            var sto_row = sheetObj.FindText(prefix2 + "chg_cd", "STO");
            var oft_row = sheetObj.FindText(prefix2 + "chg_cd", "OFT");
            var sto_relevant_chg = false;
            if(oft_row != "undefined" && sto_row != "undefined") { // OFT와 STO 요금이 동시에 존재할 때만 동작
                var o_frt_term = sheetObj.CellValue(oft_row, prefix2 + "frt_term_cd");
                var sto_frt_term = sheetObj.CellValue(sto_row, prefix2 + "frt_term_cd");
                
                var changed_row_chg_cd = sheetObj.CellValue(Row, prefix2 + "chg_cd");
                
                if(changed_row_chg_cd == 'STO') { // STO 자신도 STO관련 요금에 포함.
                    sto_relevant_chg = true;    
                } else {
                    var sheetObj5 = sheetObjects[4];
                    var sheetObj5Cnt = sheetObj5.RowCount;
                    
                    for ( var ix = 1; ix <= sheetObj5Cnt; ix++) {
                        if(sheetObj5.CellValue(ix, prefix5 + "pchg_cd") != "STO") continue;                     
                        
                        if(sheetObj5.CellValue(ix, prefix5 + "chg_cd") == changed_row_chg_cd || changed_row_chg_cd == 'STO') { 
                            sto_relevant_chg = true;
                            break;
                        }
                    }                   
                }               
                 
                if(sto_relevant_chg && o_frt_term != sto_frt_term) { // OFT와 STO의 frt_term 이 다르면 복원 필요      
                    ComShowCodeMessage("BKG95122");     
                    sheetObj.CellValue(sto_row, prefix2 + "frt_term_cd") = sheetObj.CellValue(oft_row, prefix2 + "frt_term_cd");
                }
            }
            /**
             * [화주 편의 제공을 위한 STO pay term 변경 관련 작업2] 끝
             */ 

            // 특정단위일때 소숫점없애기
            fnSplitAmount();
             
            // 변경값에 따른 재계산 로직
            var cnt = sheetObj.RowCount;
            for ( var ix = 1; ix <= cnt; ix++) {
                /**
                 * [화주 편의 제공을 위한 STO pay term 변경 관련 작업3] 시작
                 * 정하나 과장 요청 2017.03.23 // 김동호 수정
                 * STO 관련 요금 일 때만 STO요금을 재계산한다. 애초에 STO가 존재하지 않으면 동작할 이유도 없다.
                 */ 
                if(!sto_relevant_chg && "STO" == sheetObj.CellValue(ix, prefix2 + "chg_cd")) continue;
                /**
                 * [화주 편의 제공을 위한 STO pay term 변경 관련 작업3] 끝
                 */ 
                fnChargePercentageRate(sheetObj, ix, Col, Value);
            }
        }
        
        // charge/currency/rate/rated as/per/amount/in  일경우만  Manual 표시를 한다.
        if (
            sheetObj.ColSaveName(Col) == prefix2 + "chg_cd" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "curr_cd" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty" 
            ||sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd" 
            // ||sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd"
            ||sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg" 
            ) {
            // 선택한 값과 현재 변경된 값을 비교하여 바뀐 여부를 결정한다. 
            if(temp_value != sheetObj.CellText(Row, Col) ){
                // M인경우는 U로 변경하지 않는다. by 신자영 
                if( 'M' != sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")&& 'I' != sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")){
                    sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")='U';
                }
                //by 김태경 2010.3.22 autorating인경우 OFT는 수정해도 M상태를 유지한다.
                if('' == sheetObj.CellValue(Row, prefix2 + "bkg_no")){
                    if( 'OFT' == sheetObj.CellValue(Row, prefix2 + "chg_cd")){
                        sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")='M';
                    }   
                }
            }
        }

        //prefix2+"frt_term_cd" 컬럼을 제외한 나머지 컬럼이 수정된 경우는 Self-Audit 자동팝업을 열기 위한 조건
        if (sheetObj.ColSaveName(Col) != prefix2+"frt_term_cd") {
            isOpenSelfAudit2 = true;
        }
}

 /*SRM-201333119  OFT 입력시 Copy & Paste할 경우 M FLAG를 U로 수정 요청*/
function t10sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    var colId   = sheetObj.ColSaveName(Col);
    var formObj = document.form; 
    
    switch(KeyCode){
    case 86:   // Ctrl + V  (Shift==2 사용시 반응이 둔해 조건 사용하지 않음
            if(sheetObj.ColSaveName(Col) == prefix2 + "chg_cd" 
                    ||sheetObj.ColSaveName(Col) == prefix2 + "curr_cd" 
                    ||sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt" 
                    ||sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty" 
                    ||sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd" 
                    ||sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg" ){
                
                if(temp_value != sheetObj.CellText(Row, Col) ){
                    // M인경우는 U로 변경하지 않는다. by 신자영 
                    if( 'M' != sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")&& 'I' != sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")){
                        sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")='U';
                    }
                    //by 김태경 2010.3.22 autorating인경우 OFT는 수정해도 M상태를 유지한다.
                    if('' == sheetObj.CellValue(Row, prefix2 + "bkg_no")){
                        if( 'OFT' == sheetObj.CellValue(Row, prefix2 + "chg_cd")){
                            sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")='M';
                        }   
                    }
                }
            }
        break;
    } 
}
  
 /**
 * fnChargePercentageRate을 호출 .<br>
 * Item Change로 인식해야 하는 부분들 (Percentage 계산 로직)
 * @param sheetObj, Row, Col
 */
function fnChargePercentageRate(sheetObj, Row, Col, Value) {

    if(sheetObj.RowHidden(Row) || "D" == sheetObj.RowStatus(Row)) return;
    
    var formObj         = document.form;
    // by 신자영 A인상태에서는 계산로직에서 제외시킴
    var auto_rat_cd     = sheetObj.CellValue(Row, prefix2 + "auto_rat_cd")  
    var rate_chg_cd     = sheetObj.CellValue(Row, prefix2 + "chg_cd");
    var rate_rat_ut_cd  = sheetObj.CellValue(Row, prefix2 + "rat_ut_cd");

    // by 김태경 PC관련 로직 변경
    var result = 0.00;
    var sumAmount = 0.00;
    var rat_as_qty  = sheetObj.CellValue(Row, prefix2 + "rat_as_qty");
    var chg_ut_amt  = sheetObj.CellValue(Row, prefix2 + "chg_ut_amt");
    
    try {
        /**
         *  TVA Charge 의 경우 TRO Revenue 의 % 금액으로 Fix 된 금액을 사용 해야 함
         *  PC 계산 하지 않음
         */
        if('TVA' == rate_chg_cd && 'PC' == rate_rat_ut_cd && 'I' == auto_rat_cd){
           return;
        }else 
        /**
         * 결과 10. VDT / PC Rate = DHF, OBS, DDF의 Sum (DHF, DDF, OBS 중 Curr이 VND인
         * Charge들의 Amount의 Sum) Amount = Rate / (100-Rated As)*Rated As // rate /
         * (100-rate_as)*rate_as
         */
        if ('VDT' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount)/(100-parseFloat(rat_as_qty))*parseFloat(rat_as_qty);
            result = Math.round(result);
            // 첫째자리로변경
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
        /**
         * 결과 11. VTT / PC / [[POD]] like 'VN%' Rate = DTH, DDC의 Sum (DTH, DDC 중
         * IN이 I와 E인 것은 제외한 Charge들의 Amount의 Sum) Amount = Rate / (100-Rated /
         * rate / (100-rate_as)*rate_as
         */
        if ('VTT' == rate_chg_cd &&'PC' == rate_rat_ut_cd &&( /VN/g.test(ComGetObjValue(formObj.frm_t10sheet1_pod_cd)))) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount) / (100-parseFloat(rat_as_qty)) * parseFloat(rat_as_qty);
            result = Math.round(result);
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
        /**
         * 결과 12. VTT / PC / [[POL]] like 'VN%' Rate = OTH, ORC의 Sum (OTH, ORC 중
         * IN이 I와 E인 것은 제외한 Charge들의 Amount의 Sum) Amount = Rate / (100-Rated //
         * rate / (100-rate_as)*rate_as
         * 
         */
        if ('VTT' == rate_chg_cd &&'PC' == rate_rat_ut_cd &&( /VN/g.test(ComGetObjValue(formObj.frm_t10sheet1_pol_cd)))) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount)/(100-parseFloat(rat_as_qty))*parseFloat(rat_as_qty);
            result = Math.round(result);
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else 
        /**
         * 결과 13. VET
         */ 
        if ('VET' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount) / (100-parseFloat(rat_as_qty)) * parseFloat(rat_as_qty);
            result = Math.round(result);
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
        /**
         * 결과 14. VCT
         */ 
        if ('VCT' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount) / (100-parseFloat(rat_as_qty)) * parseFloat(rat_as_qty);
            result = Math.round(result);
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
        /**
         * 결과 15. VST
         */ 
        if ('VST' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount) / (100-parseFloat(rat_as_qty)) * parseFloat(rat_as_qty);
            result = Math.round(result);
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
        /**
         * 결과 16. VFT
         */ 
        if ('VFT' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount)/(100-parseFloat(rat_as_qty))*parseFloat(rat_as_qty);
            result = Math.round(result);
            // 첫째자리로변경
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
        /**
         * 결과 10. VP / PC Rate = DHF, OBS, DDF의 Sum (DHF, DDF, OBS 중 Curr이 VND인
         * Charge들의 Amount의 Sum) Amount = Rate / (100-Rated As)*Rated As // rate /
         * (100-rate_as)*rate_as
         */
        if ('VPT' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            result = parseFloat(sumAmount)/(100-parseFloat(rat_as_qty))*parseFloat(rat_as_qty);
            result = Math.round(result);
            // 첫째자리로변경
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }else
            /**
             * by 김태경 CAF이면서 PC인경우는 퍼센트 계산.
             */

        if ('CAF' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            // 100으로 나눈값으로 처리
            result = (parseFloat(sheetObj.CellValue(Row, prefix2 + "chg_ut_amt")) * parseFloat(rat_as_qty)) /100;
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        
        }else
            
        if ('CCA' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
            // 100으로 나눈값으로 처리
            result = (parseFloat(sheetObj.CellValue(Row, prefix2 + "chg_ut_amt")) * parseFloat(rat_as_qty)) /100;
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
            
        }else
        
        if ('GST' == rate_chg_cd && 'PC' == rate_rat_ut_cd ) {
            // 100으로 나눈값으로 처리
            /*
             * 2010.04.05 김태경 해당 PC 로직에 조건이 만족하지 않으면 0 값(리턴 값 sumAmount)으로
             * 뿌려줌  // 100으로 나눈값으로 처리
             */
            
            sumAmount = fnGstSumAmountTotal(sheetObj,Row);
            if(sumAmount > 0){
                sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            }else{
                sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            }

            result = (parseFloat(sumAmount) * parseFloat(rat_as_qty)) /100;
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        /**
         * 결과 0. 이외 나머지 모두 // rate * rate_as
         */
    
        }else
            
        if (('SBC' == rate_chg_cd || 'KKC' == rate_chg_cd) &&'PC' == rate_rat_ut_cd ) {
            // 100으로 나눈값으로 처리
            /*
             * 2010.04.05 김태경 해당 PC 로직에 조건이 만족하지 않으면 0 값(리턴 값 sumAmount)으로
             * 뿌려줌  // 100으로 나눈값으로 처리
             */
            
            sumAmount = fnSbcKkcSumAmountTotal(sheetObj,Row);
            if(sumAmount > 0){
                sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            }else{
                sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            }

            result = (parseFloat(sumAmount) * parseFloat(rat_as_qty)) /100;
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        /**
         * 결과 0. 이외 나머지 모두 // rate * rate_as
         */
    
        }else
        /**
         * 결과 1. Amount = OTH의 Sum * Rated As/100 Rate = OTH의 Sum (OTH의 Sum은 현재
         * 입력되어 있는 값중에 Charge code가 OTH인 Charge들의 Amount의 합) 최초에 설계당시 제일 먼저 실행하는
         * 것으로 설계하였으나, 상위의 조건을 만족시키지 않는 other charge들에 대해 적용하기 위해 순서를 맨아래로 변경
         * 11.25 // rate * rate_as / 100
         */
                    
        if ('PC' == rate_rat_ut_cd ) {
            /*
             * 2010.04.05 김태경 해당 PC 로직에 조건이 만족하지 않으면 0 값(리턴 값 sumAmount)으로
             * 뿌려줌  // 100으로 나눈값으로 처리
             */
            sumAmount = fnSumAmountTotal(sheetObj,Row);
            if(sumAmount > 0){
                sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            }else{
                sheetObj.CellValue(Row, prefix2 + "chg_ut_amt") = sumAmount;
            }
            result = (parseFloat(sumAmount) * parseFloat(rat_as_qty)) /100;
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        /**
         * 결과 0. 이외 나머지 모두 // rate * rate_as
         */
        }else{
            result = Math.round( parseFloat(chg_ut_amt) * parseFloat(rat_as_qty) * 100) / 100;
            sheetObj.CellValue(Row, prefix2 + "chg_amt") = result;
        }

    } catch (ex) {
        fnBkgErrorAlert('fnChargePercentageRate', ex);
    }   
}

 
 /**
  * Sheet관련 컬럼 fnSumAmountTotal 호출 .<br>
  * @param sheetObj
  * @param cRow
  */
 function fnSumAmountTotal(sheetObj , cRow) {
     
     // RowCount 0 이면 return 
     var jcnt   = sheetObj.RowCount;
     if(jcnt == 0)  return 0;
     var sheetObj5  = sheetObjects[4];
     var cnt        = sheetObj5.RowCount;
     // PC가 아니면 return ;
     var sumAmount  = 0.00;
     // PC가 아니면 total값 구하지 않는다.
     if('PC' != sheetObj.CellValue(cRow, prefix2 + "rat_ut_cd")){
         return sumAmount;
     }

     var i_rat_ut_cd        = sheetObj.CellValue(cRow, prefix2 + "rat_ut_cd");
     if('PC' == i_rat_ut_cd) {
         
         var pp_chg_cd  = sheetObj.CellValue(cRow, prefix2 + "chg_cd");
        // 4. CHARGE, CUR, PER, TERM 값이 존재하는경우만 RATE 값을 얻는다.
         for ( var ix = 1; ix <= cnt; ix++) {
            var c_pchg_cd = sheetObj5.CellValue(ix, prefix5 + "pchg_cd");

            // object에서 p_chage_cd값 과 object5값이 동일한것
            if(pp_chg_cd == c_pchg_cd){
                var o_chg_cd        = sheetObj5.CellValue(ix, prefix5 + "chg_cd");
                var o_curr_cd       = sheetObj.CellValue(cRow, prefix2 + "curr_cd");
                var o_frt_term_cd   = sheetObj.CellValue(cRow, prefix2 + "frt_term_cd");
                
                // Surcharge 에 Ocean Freight 를 O 로 등록한경우 OFT Term 을 사용 한다 
                if(o_frt_term_cd =="O"){
                    findRow = sheetObj.FindText(prefix2 + "chg_cd", "OFT");
                    if(findRow){
                        o_frt_term_cd = sheetObj.CellValue(findRow, prefix2 + "frt_term_cd");
                    }
                }
                
                for ( var j = 1; j <= jcnt; j++) {
                    var p_chg_cd        = sheetObj.CellValue(j, prefix2 + "chg_cd");
                    var p_curr_cd       = sheetObj.CellValue(j, prefix2 + "curr_cd");
                    var p_frt_term_cd   = sheetObj.CellValue(j, prefix2 + "frt_term_cd");
                    var rat_ut_cd       = sheetObj.CellValue(j, prefix2 + "rat_ut_cd");
                    var incl_oft_flg    = sheetObj.CellValue(j, prefix2 + "incl_oft_flg");

                    if('PC' == rat_ut_cd) continue;// PC 인경우 합산에서 제거 by신자영
                    if('I' == incl_oft_flg) continue;// I 인경우 합산에서 제거 by김태경

                    // hidden인경우도 합산에서 제거
                    if(sheetObj.RowHidden(j) || sheetObj.RowStatus(j) == "D")continue; 
                    if(p_chg_cd.length > 0 && p_curr_cd.length > 0 && p_frt_term_cd.length > 0 ){
                        if (p_chg_cd == o_chg_cd &&p_curr_cd == o_curr_cd && p_frt_term_cd == o_frt_term_cd ) {
                            /* 2010. 04.05 김태경 chg_ut_amt 를 chg_amt 로 수정 */
                            sumAmount = sumAmount + parseFloat(sheetObj.CellValue(j, prefix2 + "chg_amt"));
                        }
                    }
                 }
            }
         }
     }
    return sumAmount;
 }
  /**
   * Sheet관련 컬럼 fnSumAmountTotal 호출 .<br>
   * @param sheetObj
   * @param cRow
   */
  function fnGstSumAmountTotal(sheetObj , cRow) {
     // RowCount 0 이면 return 
     var jcnt   = sheetObj.RowCount;
     if(jcnt == 0)  return 0;
     var sheetObj5  = sheetObjects[4];
     var cnt        = sheetObj5.RowCount;
     // PC가 아니면 return ;
     var sumAmount  = 0.00;
     // PC가 아니면 total값 구하지 않는다.
     if('PC' != sheetObj.CellValue(cRow, prefix2 + "rat_ut_cd")){
         return sumAmount;
     }

     var i_rat_ut_cd        = sheetObj.CellValue(cRow, prefix2 + "rat_ut_cd");
     if('PC' == i_rat_ut_cd) {
         
         var pp_chg_cd  = sheetObj.CellValue(cRow, prefix2 + "chg_cd");
        // 4. CHARGE, CUR, PER, TERM 값이 존재하는경우만 RATE 값을 얻는다.
         for ( var ix = 1; ix <= cnt; ix++) {
            var c_pchg_cd = sheetObj5.CellValue(ix, prefix5 + "pchg_cd");

            // object에서 p_chage_cd값 과 object5값이 동일한것
            if(pp_chg_cd == c_pchg_cd){
                var o_chg_cd        = sheetObj5.CellValue(ix, prefix5 + "chg_cd");
                var o_curr_cd       = sheetObj.CellValue(cRow, prefix2 + "curr_cd");
                var o_frt_term_cd   = sheetObj.CellValue(cRow, prefix2 + "frt_term_cd");

                
                for ( var j = 1; j <= jcnt; j++) {
                    var p_chg_cd        = sheetObj.CellValue(j, prefix2 + "chg_cd");
                    var p_curr_cd       = sheetObj.CellValue(j, prefix2 + "curr_cd");
                    var p_frt_term_cd   = sheetObj.CellValue(j, prefix2 + "frt_term_cd");
                    var p_n3pty_cust_cnt_cd = sheetObj.CellValue(j, prefix2 + "n3pty_cust_cnt_cd");
                    var rat_ut_cd       = sheetObj.CellValue(j, prefix2 + "rat_ut_cd");
                    var incl_oft_flg    = sheetObj.CellValue(j, prefix2 + "incl_oft_flg");
                    if('PC' == rat_ut_cd) continue;// PC 인경우 합산에서 제거 by신자영
                    if('I' == incl_oft_flg) continue;// I,E 인경우 합산에서 제거 by김태경

                    // hidden인경우도 합산에서 제거
                    if(sheetObj.RowHidden(j) || sheetObj.RowStatus(j) == "D")continue; 
                    
                    if(p_chg_cd.length > 0 && p_curr_cd.length > 0 && p_frt_term_cd.length > 0 ){
                        /*Cuurency별로 FRT Term이 계약과 일치하거나, FRT Term이 계약과 일치하지 않더라도 INR Charge인 경우 Summary에 합산*/
                        /* Third Party Customer가 인도가 아닌 경우 합산 대상에서 제외 */ 
                        /*CHM-201324811 Frt Term 비교로직 삭제 >> 원복 */
                        /* 기존로직 보존 -> 이전에는 GST/SBC/KKC가 동일한 로직으로 움직였다. 
                         * 세법개정이후 SBC,KKC가 쓰이지 않으나 과거 데이터를 위해 fnSbcKkcSumAmountTotal 함수로 분기
                        if (p_chg_cd == o_chg_cd &&p_curr_cd == o_curr_cd && (p_frt_term_cd == o_frt_term_cd || p_curr_cd == 'INR')
                                && ( p_curr_cd == 'INR' ||
                                    (p_curr_cd != 'INR' && (p_n3pty_cust_cnt_cd == '' || p_n3pty_cust_cnt_cd == 'IN')))) {
                            // 2010. 04.05 김태경 chg_ut_amt 를 chg_amt 로 수정
                            sumAmount = sumAmount + parseFloat(sheetObj.CellValue(j, prefix2 + "chg_amt"));
                        }
                        */
                        
                       /* 
                         * [CSR #2664] NEW GST LOGIC
                         *  A. 인도 inbound 
                         *      1. GST 대상 요금 중 frt_term이 collect 이면 CURR_CD와 상관없이 GST 대상 요금으로 채택
                         *      2. CLN, CMF, DCH, DIH, DTH. ITR, MUC, NST 요금은 FRT_TERM/CURR_CD와 상관없이 GST 대상 요금으로 채택
                         *  B. 인도 outbound
                         *      1. GST 대상 요금 중 frt_term이 prepaid 이면 CURR_CD와 상관없이 GST 모수 요금으로 채택
                         */
                       
                       var polCntCd = ComGetObjValue(document.form.frm_t10sheet1_pol_cd).substring(0,2);
                       var podCntCd = ComGetObjValue(document.form.frm_t10sheet1_pod_cd).substring(0,2);
                        
                       if (p_chg_cd == o_chg_cd && p_curr_cd == o_curr_cd 
                               && (
                                          podCntCd == 'IN' && p_frt_term_cd == 'C'
                                      ||  podCntCd == 'IN' && (p_chg_cd == 'CLN' || p_chg_cd == 'CMF' || p_chg_cd == 'DCH' 
                                                                  || p_chg_cd == 'DIH' || p_chg_cd == 'DTH' || p_chg_cd == 'ITR' 
                                                                  || p_chg_cd == 'MUC' || p_chg_cd == 'NST')
                                      ||  polCntCd == 'IN' && p_frt_term_cd == 'P'
                                  )
                               && (p_n3pty_cust_cnt_cd == '' || p_n3pty_cust_cnt_cd == 'IN')
                          ) {
                           sumAmount = sumAmount + parseFloat(sheetObj.CellValue(j, prefix2 + "chg_amt"));
                       }
                    }
                 }
            }
         }
     }
    return sumAmount;
  }
  
  /**
   * Sheet관련 컬럼 fnSbcKkcSumAmountTotal 호출 .<br>
   * @param sheetObj
   * @param cRow
   */
  function fnSbcKkcSumAmountTotal(sheetObj , cRow) {
     // RowCount 0 이면 return 
     var jcnt   = sheetObj.RowCount;
     if(jcnt == 0)  return 0;
     var sheetObj5  = sheetObjects[4];
     var cnt        = sheetObj5.RowCount;
     // PC가 아니면 return ;
     var sumAmount  = 0.00;
     // PC가 아니면 total값 구하지 않는다.
     if('PC' != sheetObj.CellValue(cRow, prefix2 + "rat_ut_cd")){
         return sumAmount;
     }

     var i_rat_ut_cd        = sheetObj.CellValue(cRow, prefix2 + "rat_ut_cd");
     if('PC' == i_rat_ut_cd) {
         
         var pp_chg_cd  = sheetObj.CellValue(cRow, prefix2 + "chg_cd");
        // 4. CHARGE, CUR, PER, TERM 값이 존재하는경우만 RATE 값을 얻는다.
         for ( var ix = 1; ix <= cnt; ix++) {
            var c_pchg_cd = sheetObj5.CellValue(ix, prefix5 + "pchg_cd");

            // object에서 p_chage_cd값 과 object5값이 동일한것
            if(pp_chg_cd == c_pchg_cd){
                var o_chg_cd        = sheetObj5.CellValue(ix, prefix5 + "chg_cd");
                var o_curr_cd       = sheetObj.CellValue(cRow, prefix2 + "curr_cd");
                var o_frt_term_cd   = sheetObj.CellValue(cRow, prefix2 + "frt_term_cd");

                
                for ( var j = 1; j <= jcnt; j++) {
                    var p_chg_cd        = sheetObj.CellValue(j, prefix2 + "chg_cd");
                    var p_curr_cd       = sheetObj.CellValue(j, prefix2 + "curr_cd");
                    var p_frt_term_cd   = sheetObj.CellValue(j, prefix2 + "frt_term_cd");
                    var p_n3pty_cust_cnt_cd = sheetObj.CellValue(j, prefix2 + "n3pty_cust_cnt_cd");
                    var rat_ut_cd       = sheetObj.CellValue(j, prefix2 + "rat_ut_cd");
                    var incl_oft_flg    = sheetObj.CellValue(j, prefix2 + "incl_oft_flg");
                    if('PC' == rat_ut_cd) continue;// PC 인경우 합산에서 제거 by신자영
                    if('I' == incl_oft_flg) continue;// I,E 인경우 합산에서 제거 by김태경

                    // hidden인경우도 합산에서 제거
                    if(sheetObj.RowHidden(j) || sheetObj.RowStatus(j) == "D")continue; 
                    
                    if(p_chg_cd.length > 0 && p_curr_cd.length > 0 && p_frt_term_cd.length > 0 ){
                        /*Cuurency별로 FRT Term이 계약과 일치하거나, FRT Term이 계약과 일치하지 않더라도 INR Charge인 경우 Summary에 합산*/
                        /* Third Party Customer가 인도가 아닌 경우 합산 대상에서 제외 */ 
                        /*CHM-201324811 Frt Term 비교로직 삭제 >> 원복 */
                        if (p_chg_cd == o_chg_cd &&p_curr_cd == o_curr_cd && (p_frt_term_cd == o_frt_term_cd || p_curr_cd == 'INR')
                                && ( p_curr_cd == 'INR' ||
                                    (p_curr_cd != 'INR' && (p_n3pty_cust_cnt_cd == '' || p_n3pty_cust_cnt_cd == 'IN')))) {
                            // 2010. 04.05 김태경 chg_ut_amt 를 chg_amt 로 수정
                            sumAmount = sumAmount + parseFloat(sheetObj.CellValue(j, prefix2 + "chg_amt"));
                        }
                    }
                 }
            }
         }
     }
    return sumAmount;
  }
  
 
/**
 * Sheet관련 컬럼 OnPopupClick을 호출 .<br>
 * @param sheetObj, Row, Col
 */
var current_Row = '';
var current_Col = '';
function t10sheet2_OnPopupClick(sheetObj, Row, Col) {
    current_Row = Row;
    current_Col = Col;

    if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd") {
        ComOpenPopup('/hanjin/ESM_BKG_0975.do?pgmNo=ESM_BKG_0975&chg_cd='+sheetObj.CellValue(Row, prefix2 + "chg_cd"), 650, 610, 'getBKG_0975', '0,0', true, true, Row, prefix2 + "chg_cd", 1);
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
        ComOpenPopup('/hanjin/COM_ENS_N13.do?pgmNo=COM_ENS_N13', 500, 450, 'getCOM_ENC_N13', '1,0,1,1,1', true, true, Row, prefix2 + "curr_cd", 1);
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd") {
        ComOpenPopup('/hanjin/ESM_PRI_4002.do?pgmNo=ESM_PRI_4002', 1024, 650, 'getPRI_4002', '1,0,1,1,1', true, true, Row, prefix2 + "rat_ut_cd", 1);
    } else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_seq") {
        ComOpenPopup('/hanjin/COM_ENS_041.do?pgmNo=COM_ENS_041', 800, 470, 'getCOM_ENS_041', '1,0,1,1,1', true, true, Row, prefix2 + "n3pty_cust_seq", 1);
    }
}
/**
* callback 함수 getBKG_0961 호출 .<br>
* @param _val
* @param rType
*/
function getBKG_0961(_val,rType) {
    if (_val == null) return;// null 이면 return
    var formObj = document.form;
    var obj = _val;
    if("PPD" == rType){
        ComSetObjValue(formObj.frm_p_t10sheet3_cnt_cd, obj.cust_cnt_cd );
        ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq, obj.cust_seq );
        ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, '');
    }else{
        ComSetObjValue(formObj.frm_c_t10sheet3_cnt_cd, obj.cust_cnt_cd);
        ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq, obj.cust_seq);
        ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, '');
    }
}
/**
 * callback 함수 getBKG_0771 호출 .<br>
 * @param _val
 */
function getBKG_0771(_val) {
    if (_val == null) return;// null 이면 return
    try{
        if(_val.msg == "OK"){
            tab_alert_msg = true;
            doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
        }
    }catch(e){
        fnBkgErrorAlert('getBKG_0771', e);
    }
}
/**
 * callback 함수 getBKG_1090 호출 .<br>
 * @param _val
 */
function getBKG_1090(_val) {
    if (_val == null) return;// null 이면 return
    var obj = _val;
    var sheetObj = sheetObjects[1];
    
    // [1.행숨기기] 해당 sheet에 CAF가 존재하는 지 판단
    var cnt = sheetObj.RowCount;
    for ( var ix = 1; ix <= cnt; ix++) {
        var chg_cd = sheetObj.CellValue(ix, prefix2 + "chg_cd");
        if("CAF" == chg_cd){
            fnRowHidden(sheetObj,ix);// 2.행 숨기기
        }
    }
    //CAF : 신규 로우 추가 
    var newRow = setDataInsert(sheetObj, 1);
    sheetObj.RowStatus(newRow)= "R";
    sheetObj.CellValue(newRow, prefix2 + "chg_cd") = obj.caf_charge;
    sheetObj.CellValue(newRow, prefix2 + "curr_cd") = obj.caf_cur;
    sheetObj.CellValue(newRow, prefix2 + "rat_ut_cd") = obj.caf_per;
    sheetObj.CellValue(newRow, prefix2 + "chg_ut_amt") = obj.caf_rate;
    sheetObj.CellValue(newRow, prefix2 + "rat_as_qty") = obj.caf_rate_as;
    sheetObj.CellValue(newRow, prefix2 + "chg_amt") = obj.caf_amount;
}
/**
 * setDataInsert 호출 .<br>
 * sheet에 data를 신규 추가 하는 기능 
 * 1. 그리드에 행 추가
 * 2. Rate, Rate As, Amount 0 으로 설정
 * 3. IN을 N으로 설정
 * 4. Freight Term에 따라 Term 설정
 * 5. Cargo에 DR로 설정
 * 6. BKG R/D Term으로 R/D Term 설정
 * 7. M(Auto/Manual)에 M으로 설정
 * @param sheetObj, sNo
 */
function setDataInsert(sheetObj, sNo) {
    var formObj = document.form;
    // 기본셋트는 상황에 따라 어떻게 변경될지 몰라서 switch 문으로 동일하게 분리시킴
    switch (sNo) {

    case 1:
        var nRow = sheetObj.DataInsert(-1); // 맨하위에 삽입
        sheetObj.CellValue(nRow, prefix2 + "chg_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "trf_itm_no") = '';
        sheetObj.CellValue(nRow, prefix2 + "curr_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_ut_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_as_qty") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_ut_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "incl_oft_flg") = 'N';
        sheetObj.CellValue(nRow, prefix2 + "frt_term_cd") = document.getElementById("frt_term_cd").Code;
        sheetObj.CellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_cnt_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_seq") = '';
        sheetObj.CellValue(nRow, prefix2 + "cgo_cate_cd") = 'DR';
        sheetObj.CellValue(nRow, prefix2 + "rcv_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "de_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_de_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "imdg_clss_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "auto_rat_cd") = 'M';
        sheetObj.CellValue(nRow, prefix2 + "prn_hdn_flg") = '';
        break;
    case 2:
        var nRow = sheetObj.DataInsert(-1); // 맨 하위에 삽입
        sheetObj.CellValue(nRow, prefix2 + "chg_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "trf_itm_no") = '';
        sheetObj.CellValue(nRow, prefix2 + "curr_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_ut_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_as_qty") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_ut_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "incl_oft_flg") = 'N';
        sheetObj.CellValue(nRow, prefix2 + "frt_term_cd") = document.getElementById("frt_term_cd").Code;
        sheetObj.CellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_cnt_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_seq") = '';
        sheetObj.CellValue(nRow, prefix2 + "cgo_cate_cd") = 'DR';
        sheetObj.CellValue(nRow, prefix2 + "rcv_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "de_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_de_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "imdg_clss_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "auto_rat_cd") = 'A';
        sheetObj.CellValue(nRow, prefix2 + "prn_hdn_flg") = '';
        break;
    case 3:
        var nRow = sheetObj.DataInsert(); // cursor 바로 아래 삽입
        sheetObj.CellValue(nRow, prefix2 + "chg_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "trf_itm_no") = '';
        sheetObj.CellValue(nRow, prefix2 + "curr_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_ut_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_as_qty") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_ut_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "incl_oft_flg") = 'N';
        sheetObj.CellValue(nRow, prefix2 + "frt_term_cd") = document.getElementById("frt_term_cd").Code;
        sheetObj.CellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_cnt_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_seq") = '';
        sheetObj.CellValue(nRow, prefix2 + "cgo_cate_cd") = 'DR';
        sheetObj.CellValue(nRow, prefix2 + "rcv_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "de_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_de_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "imdg_clss_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "auto_rat_cd") = 'A';
        sheetObj.CellValue(nRow, prefix2 + "prn_hdn_flg") = '';
        break;
    case 4:
        var nRow = sheetObj.DataInsert(0);// sheet 맨 상위에 삽입
        sheetObj.CellValue(nRow, prefix2 + "chg_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "trf_itm_no") = '';
        sheetObj.CellValue(nRow, prefix2 + "curr_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_ut_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_as_qty") = '0';
        sheetObj.CellValue(nRow, prefix2 + "rat_ut_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "chg_amt") = '0';
        sheetObj.CellValue(nRow, prefix2 + "incl_oft_flg") = 'N';
        sheetObj.CellValue(nRow, prefix2 + "frt_term_cd") = document.getElementById("frt_term_cd").Code;
        sheetObj.CellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_cnt_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_seq") = '';
        sheetObj.CellValue(nRow, prefix2 + "cgo_cate_cd") = 'DR';
        sheetObj.CellValue(nRow, prefix2 + "rcv_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "de_term_cd") = ComGetObjValue(formObj.frm_t10sheet1_de_term_cd);
        sheetObj.CellValue(nRow, prefix2 + "imdg_clss_cd") = '';
        sheetObj.CellValue(nRow, prefix2 + "auto_rat_cd") = 'A';
        sheetObj.CellValue(nRow, prefix2 + "prn_hdn_flg") = '';
        break;
    }
    return nRow;
}
/**
 * charge_cd callback 함수 t10sheet2_OnPopupClick 호출 <br>
 * @param rowArray, Row, Col, sheetIdx
 */
function getBKG_0975(rowArray, Row, Col, sheetIdx) {
    sheetObjects[sheetIdx].CellValue(Row, prefix2 + "exist_chg_cd")='';
    sheetObjects[sheetIdx].CellValue(Row, Col) = rowArray[0][1];
}
/**
 * curr_cd callback 함수 t10sheet2_OnPopupClick 호출 <br>
 * @param rowArray, Row, Col, sheetIdx
 */
function getCOM_ENC_N13(rowArray, Row, Col, sheetIdx) {
    sheetObjects[sheetIdx].CellValue(Row, prefix2 + "exist_curr_cd")='';
    sheetObjects[sheetIdx].CellValue(Row, Col) = rowArray[0][3];
}
/**
 * rat_ut_cd callback 함수 t10sheet2_OnPopupClick 호출 <br>
 * @param rowArray, Row, Col, sheetIdx
 */
function getPRI_4002(rowArray, Row, Col, sheetIdx) {
    sheetObjects[sheetIdx].CellValue(Row, prefix2 + "exist_rat_ut_cd")='';
    sheetObjects[sheetIdx].CellValue(Row, Col) = rowArray[0][3];
}
/**
 * n3pty_cust_seq callback 함수 t10sheet2_OnPopupClick 호출 .<br>
 * @param rowArray, Row, Col, sheetIdx
 */
function getCOM_ENS_041(rowArray, Row, Col, sheetIdx) {
    var _val = rowArray[0][3];
    sheetObjects[sheetIdx].CellValue(Row, prefix2 + "n3pty_cust_cnt_cd") = _val.substring(0, 2);
    sheetObjects[sheetIdx].CellValue(Row, prefix2 + "n3pty_cust_seq") = _val.substring(3);
    sheetObjects[sheetIdx].CellValue(Row, prefix2 + "exist_cust_seq")='';
}
 /**
  * UI 1077 에서 넘겨준 날짜를 넣어 준다.<br>
  * @param rValue
  */
function getBKG_1077 (rValue){
      var formObj = document.form;
      ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt, rValue);
}
 
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//  sheetObj.ShowDebugMsg = 1;
    var formObj = document.form;
    var aryPrefix = new Array(prefix1, prefix2, prefix3,prefix4,prefix5,prefix6,prefix7);
     
    switch (sAction) {
    case INIT:      //Default
        var sXml = document.frm.sXml.value;
        var arrXml = sXml.split("|$$|");    
        if (arrXml.length > 0){
            ComBkgXml2ComboItem(arrXml[0], formObj.rt_bl_tp_cd, "val", "name");
        }
        if (arrXml.length > 1){
            ComBkgXml2ComboItem(arrXml[1], formObj.frt_term_cd, "val", "name");         
        }

    case IBSEARCH: //조회
        if (!validateForm(sheetObj, formObj, sAction))  return;
        // 초기화
        ComSetObjValue(formObj.autoRate, "N" );
        ComSetObjValue(formObj.removeAll, "N" );
        fnClearForm();
        sheetObjects[6].RemoveAll();
        fnClearSelect('svc_scp_cd');// Service Scope
        // 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        ComSetObjValue(formObj.f_cmd, SEARCH);
        ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
        ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t10sheet1_bkg_no));
        ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t10sheet1_bl_no));
        
        ComOpenWait(true); // 대기창 보임
        // 2.조회조건으로 조회실행
        var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

        // 3.조회후 결과처리
        var arrXml = sXml.split("|$$|");
        
        var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
        volDiffFlg = ComGetEtcData(arrXml[0],"vol_diff_flg");
        if(volDiffFlg == 'Y') {
            
            document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = 'red';
        } else {
            document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = '';
            
        }

        //3rd Party BL Request 버튼 활성화
        fn3rdBLReqButtonColor();
        
        if ( State == "S" ) {
            for ( var inx = 0; inx < arrXml.length; inx++) {
                sheetObjects[inx].LoadSearchXml(arrXml[inx]);
            }
            ComOpenWait(false); // 대기창 사라짐
            
            //formObj.old_bkg_no.value = ComGetEtcData(arrXml[0],prefix1+"bkg_no");
            ComSetObjValue(formObj.old_bkg_no,ComGetEtcData(arrXml[0], "bkg_no"));
            
            ComSetObjValue(formObj.caflag,ComGetEtcData(arrXml[0], "caflag"));
            ComSetObjValue(formObj.bdrflag,ComGetEtcData(arrXml[0], "bdrflag"));
            ComSetObjValue(formObj.oblIssFlg,ComGetEtcData(arrXml[0], "oblIssFlg"));

            // ---jsy 
            ComSetObjValue(formObj.ctrt_ofc_cd,ComGetEtcData(arrXml[0], "ctrt_ofc_cd"));
            ComSetObjValue(formObj.ctrt_srep_cd,ComGetEtcData(arrXml[0], "ctrt_srep_cd"));
            ComSetObjValue(formObj.bkg_ofc_cd,ComGetEtcData(arrXml[0], "bkg_ofc_cd"));
            ComSetObjValue(formObj.aloc_sts_cd,ComGetEtcData(arrXml[0], "aloc_sts_cd"));

            // 기능추가 ofc_cd값을 자동으로 채운다. by 2009.11.02 신자영
            
            if( '' != ComGetEtcData(arrXml[0], "rOfc_cd") && undefined != ComGetEtcData(arrXml[0], "rOfc_cd")){
                ComSetObjValue(formObj.rOfc_cd,ComGetEtcData(arrXml[0], "rOfc_cd"));
                var rOfc_cd = ComGetObjValue(formObj.rOfc_cd).split("|");
                
                if(ComIsEmpty(formObj.frm_p_t10sheet3_ofc_cd.value)){
                    ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd, rOfc_cd[0]);
                }
                if(ComIsEmpty(formObj.frm_p_t10sheet3_cnt_cd.value)){
                    ComSetObjValue(formObj.frm_p_t10sheet3_cnt_cd, rOfc_cd[1]);
                }
                if(ComIsEmpty(formObj.frm_p_t10sheet3_cust_seq.value) || '0' == ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq) ){
                    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq, rOfc_cd[2]);
                }
                if(ComIsEmpty(formObj.frm_c_t10sheet3_ofc_cd.value)){
                    ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd, rOfc_cd[3]);
                }
                if(ComIsEmpty(formObj.frm_c_t10sheet3_cnt_cd.value)){
                    ComSetObjValue(formObj.frm_c_t10sheet3_cnt_cd, rOfc_cd[4]);
                }
                if(ComIsEmpty(formObj.frm_c_t10sheet3_cust_seq.value) || '0' == ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq)){
                    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq, rOfc_cd[5]);
                }
            }

            //BDR FLAG 에 따른 활성,비활성 처리 
            if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
                setBookingEditable(false);
            }else{
                setBookingEditable(true);
            }
            
            //1. Note button 색상변경 
            fnExistNoteButtonColor();
            
            ComSetObjValue(formObj.sc_available_red,'Y');
            ComSetObjValue(formObj.rfa_available,'Y');
            ComSetObjValue(formObj.taa_available,'Y');
            
            fnCheckNumber('sc_no',  ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
            fnCheckNumber('rfa_no', ComGetObjValue(formObj.frm_t10sheet1_rfa_no));
            fnCheckNumber('taa_no', ComGetObjValue(formObj.frm_t10sheet1_taa_no));

            //Bill Type default : N값  BY 신자영 
            ComSetObjValue(formObj.rt_bl_tp_cd, fnNullToBlank(ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd), "N"));
            
            // Freight Term setting
            document.getElementById("frt_term_cd").Code2 = fnNullToBlank(ComGetObjValue(formObj.frm_t10sheet1_frt_term_cd), "P");
            
            ComSetObjValue(document.form.modify_flag, "N");
            // by 김태경 데이터값 변경여부 체크
            fnModifyCheckBefore();

            // - fnCheckBrk_dwn_flg
            /* 2010.04.01 Break Down FLG를 TPE,TPW인경우 N, 나머지 Y */
            fnCheckBrk_dwn_flg();
            temp_value = '';
            change_prn_hdn_flg=false;
            
            //save버튼 처리 jsy
            if(ComGetObjValue(formObj.isInquiry) == "Y"){
                setInquiryDisableButton();
            }
            try{
                // C/A 버튼 Control 
                parent.initCAControl(   ComGetObjValue(formObj.bkg_no), 
                                        ComGetObjValue(formObj.caflag), 
                                        ComGetObjValue(formObj.bdrflag), 
                                        ComGetEtcData(arrXml[0], "ca_exist_flg"), 
                                        ComGetObjValue(formObj.bl_no));
            }catch(e){}
            //by 2010.3.10 김태경   Service Scope 없을경우 메세지 보이기 
            var message = ComGetEtcData(arrXml[0],"message");
            if(message != null){
                var rmsg = message.split("<||>");
                if(rmsg[3] != undefined && rmsg[3].length > 0) {
                    ComShowMessage(rmsg[3]);
                }
            }
        }else{
            fnExceptionMessage(sXml);
            fnClearForm();
            fnClearSelect('svc_scp_cd');// Service Scope
            ComResetAll();
            ComOpenWait(false); // 대기창 사라짐
        }
//      fnSearchRtAplyDateCheck();
        //inquiry 경우  버튼 비활성화 
        if(ComGetObjValue(formObj.isInquiry) == "Y"){
            setInquiryDisableButton();
        }
        if (isOpenSelfAudit && ComShowCodeConfirm("BKG08185")) {  //Do you continue to self-audit?
            document.getElementById("btn_t10self").fireEvent("onclick");
        }
        isOpenSelfAudit = false;
        isOpenSelfAudit2 = false;
        return;
        //break;

    case IBSAVE: //저장
    
        if (!validateForm(sheetObj, formObj, sAction)) return false;
    
        // 신자영 DUM으로 시장하는 경우 return;
        /* 계약이 2개 이상인경우 DUM 이 한개라도 존재하면 Validation 체크 함 */
        if(!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)
          ||!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)&&!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)
          ||!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)
          ||!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)&&!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value))      
        {
            if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 || formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 ||formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1){
                if(tab_alert_msg){
                    ComShowCodeMessage("BKG08150");
                }
                return false;
            }
        }
        if(ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)&&ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)){
            if(tab_alert_msg){
                ComShowCodeMessage("BKG08149");
            }
            return false;
        }
        
        //by 김태경수석 number체크 
        // 값을 지울 경우도 유효성 체크 하여 해당 로직 수정 2010.03.31 김태경 추가
        if(!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)){
            if('N' == ComGetObjValue(formObj.sc_available)){
            //Unable to save due to invalid S/C No.!
                if(tab_alert_msg){ComShowCodeMessage("BKG00281");ComSetFocus(formObj.frm_t10sheet1_sc_no1);}
                return false;
            }
        }
        // 값을 지울 경우도  유효성 체크 하여 해당 로직 수정 2010.03.31 김태경 추가      
        if(!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)){
            if('N' == ComGetObjValue(formObj.rfa_available)){
            //Unable to save due to invalid RFA No.!
                if(tab_alert_msg){ComShowCodeMessage("BKG00282");ComSetFocus(formObj.frm_t10sheet1_rfa_no); }
                return false;
            }
        }
        // 값을 지울 경우도  유효성 체크 하여 해당 로직 수정 2010.03.31 김태경 추가      
        if(!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)){
            if('N' == ComGetObjValue(formObj.taa_available)){
            //Unable to save due to wrong code.
                if(tab_alert_msg){ComShowCodeMessage("BKG08146");ComSetFocus(formObj.frm_t10sheet1_taa_no); }
                return false;
            }
        }

        /**
         * Rate가 0 이거나 Rated As가 0 이면 UI 상에서 Error로 (Save 클릭시에 check하여 return,
         * 커서는 check된 값에 SET) Rate가 0인 경우 메시지 BKG00899 , 내용 : Rate is not
         * available
         */
        var cnt = sheetObj.RowCount;
        for ( var ix = 1; ix <= cnt; ix++) {
            if(!sheetObj.RowHidden(ix) && sheetObj.RowStatus(ix)!= "D"){
                if(sheetObj.CellText(ix, prefix2 + "chg_ut_amt") == "0.00" || sheetObj.CellText(ix, prefix2 + "chg_ut_amt") == "0,00" ){
                    // 0 운임을 입력 가능하게 변경(단, CN(POL) - PHMNL(POD) 운송의 경우만이며, OFT에만 해당함) (2018.03, by CMI/CTY-CS)
                    // 0 운임 대상 지역에 POD (KR) 추가 (2018.04.23, by CMI 정하나)
                    if ( 
                         !( ComGetObjValue(formObj.frm_t10sheet1_pol_cd).substring(0,2) == "CN" 
                            && ( ComGetObjValue(formObj.frm_t10sheet1_pod_cd) == "PHMNL" 
                                 || ComGetObjValue(formObj.frm_t10sheet1_pod_cd).substring(0,2) == "KR" 
                               )
                          ) 
                       ) {
                        if(tab_alert_msg){
                            ComShowMessage(ComGetMsg("BKG00899", "["+ix+"] Row" ));
                        }
                        sheetObj.SelectCell(ix, prefix2 + "chg_ut_amt");  
                        return false;  
                    } else {
                        if(sheetObj.CellText(ix, prefix2 + "chg_cd") != "OFT"){
                            if(tab_alert_msg){
                                ComShowMessage(ComGetMsg("BKG00899", "["+ix+"] Row" ));
                            }
                            sheetObj.SelectCell(ix, prefix2 + "chg_ut_amt");
                            return false;
                        }
                    }
                }
            }
        }
        
        /*********************************
        [CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가
        ITS/방지경 대리 요청으로 추후 반영
        // PCT + 1일 이후 OFT 수정, Autorating시에는 Charge 수정 권한이 있어야 함.
        if(formObj.frm_t10sheet1_oft_amdabl_flg.value == "N" || formObj.frm_t10sheet1_oft_amdabl_flg.value == "Q" || formObj.frm_t10sheet1_oft_amdabl_flg.value == "R"){
            for( var ix=1; ix <= cnt; ix++){
                if(sheetObj.CellValue(ix,prefix2 + "ibflag") == "U" && sheetObj.CellValue(ix, prefix2 + "chg_cd") == "OFT"){
                    if (ComShowConfirm(ComGetMsg("BKG43050"))){
                        chargeAmendRequest();
                    }
                    return false; 
                }
            }
            
        }
        *********************************/
        /**
         * Rate As가 0일 경우 메시지 BKG00900, 내용 : Rated As is not available
         */
        for ( var ix = 1; ix <= cnt; ix++) {
            if(!sheetObj.RowHidden(ix) && sheetObj.RowStatus(ix)!= "D"){
                if(sheetObj.CellText(ix, prefix2 + "rat_as_qty") == "0.000" ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00900", "["+ix+"] Row" ));
                    }
                    sheetObj.SelectCell(ix, prefix2 + "rat_as_qty");
                    return false;
                }
            }
        }

        /**
         * Amount 가 0일 경우 메시지 BKG00900, 내용 : Rated As is not available
         */
        for ( var ix = 1; ix <= cnt; ix++) {
            if(!sheetObj.RowHidden(ix) && sheetObj.RowStatus(ix)!= "D"){
                if(Number(sheetObj.CellText(ix, prefix2 + "chg_amt")) == "0" ){
                     // 0 운임을 입력 가능하게 변경(단, CN(POL) - PHMNL(POD) 운송의 경우만이며, OFT에만 해당함) (2018.03, by CMI/CTY-CS)
                     // 0 운임 대상 지역에 POD (KR) 추가 (2018.04.23, by CMI 정하나)
                     if ( 
                         !( ComGetObjValue(formObj.frm_t10sheet1_pol_cd).substring(0,2) == "CN" 
                            && ( ComGetObjValue(formObj.frm_t10sheet1_pod_cd) == "PHMNL" 
                                 || ComGetObjValue(formObj.frm_t10sheet1_pod_cd).substring(0,2) == "KR" 
                               )
                          ) 
                       ) {
                        if(tab_alert_msg){
                            ComShowMessage(ComGetMsg("BKG00902", "["+ix+"] Row" ));
                        }
                        sheetObj.SelectCell(ix, prefix2 + "chg_amt");
                        return false;
                     } else {
                         if(sheetObj.CellText(ix, prefix2 + "chg_cd") != "OFT"){
                             if(tab_alert_msg){
                                 ComShowMessage(ComGetMsg("BKG00902", "["+ix+"] Row" ));
                             }
                             sheetObj.SelectCell(ix, prefix2 + "chg_amt");
                             return false;
                         }
                     }
                }
            }
        }
        /**
         * USD 10,000 이상 입력 시 메시지 BKG08240, 내용 : Please check again if the amount in "Charge" screen is correct.
         */ 
         for ( var ix = 1; ix <= cnt; ix++) {           
             if(!sheetObj.RowHidden(ix) && sheetObj.CellValue(ix,prefix2 + "chg_cd") == "OFT" 
                 && sheetObj.CellValue(ix,prefix2 + "curr_cd") == "USD"
                 && sheetObj.CellValue(ix,prefix2 + "ibflag") == "U"){
                 if(sheetObj.CellValue(ix,prefix2 + "auto_rat_cd") == "M"||sheetObj.CellValue(ix,prefix2 + "auto_rat_cd") == "U"){   
                 
                     if(sheetObj.CellValue(ix,prefix2 + "chg_amt") >= 10000 ){
                          if(tab_alert_msg){
                                 ComShowMessage(ComGetMsg("BKG08240"));
                          }
                    }
                 }
             }
      }
        
        var exsit_Falg = true;

        //기능추가 CCT 와 PPD At 같으면 안된다. 
        if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd).length != 0 && ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd).length != 0){
            if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd) == ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd)){
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG00931"));
                }
                ComSetFocus(formObj.frm_p_t10sheet3_ofc_cd);
                return false;
            }
        }
        
        // SEARCHLIST19  79-08 event체크 Third (Offce cd) 유효성체크
        for( var i = 1; i<= cnt; i++) {
            var ofc_cd = sheetObj.CellValue(i, prefix2 + "n3pty_rcv_ofc_cd");
            if(ofc_cd != '' && undefined != ofc_cd) {
                var output_text = fnOfcCdCheck(ofc_cd);
                if ('Y' != output_text) {
                    // Third Office is not available
                    ComShowCodeMessage("BKG00044",'Third Office Code'); 
                    sheetObj.CellValue(i, prefix2 + "n3pty_cust_cnt_cd")    = '';
                    sheetObj.CellValue(i, prefix2 + "n3pty_cust_seq")       = '';
                    sheetObj.CellValue(i, prefix2 + "exist_ofc_cd")='N';
                    return false;
                }
            }
        }
        
        //3rd Party PPD와 3rd Party CCT가 같은 Office인 값이 존재하면 메세지 표시.
        for ( var ix = 1; ix <= cnt; ix++) {
            for( var iy = ix + 1; iy <= cnt; iy++){
                if(sheetObj.CellValue(ix, prefix2 + "frt_term_cd")!= sheetObj.CellValue(iy, prefix2 + "frt_term_cd")){
                    if((sheetObj.CellValue(ix, prefix2 + "n3pty_rcv_ofc_cd") != "" && sheetObj.CellValue(iy, prefix2 + "n3pty_rcv_ofc_cd") != "" ) && 
                            (sheetObj.CellValue(ix, prefix2 + "n3pty_rcv_ofc_cd") == sheetObj.CellValue(iy, prefix2 + "n3pty_rcv_ofc_cd"))){
                        ComShowMessage(ComGetMsg("BKG00932"));
                        return false;
                    }
                }
            }
        }
        
        /*Retroactive Kind 체크
         * Retroactive Kind의 우선순위 : Contract Chagne > OFT Update > Retroactive RFA 
         * 화면에서는 Retroactive Kind를 확인하고 실제 저장은 PCT + 1 경과 여부/COD여부를 고려하여 서버에서 처리한다. */
        var oft_amt = 0;  
        var amount = 0;
        var old_oft_amt = ComGetObjValue(formObj.frm_t10sheet1_old_oft_amt);
        for ( var ix = 1; ix <= cnt; ix++) {
            if(sheetObj.CellValue(ix, prefix2 + "chg_cd") == 'OFT' && sheetObj.RowStatus(ix) != "D"){
                amount   = sheetObj.CellValue(ix, prefix2 + "chg_amt");
                oft_amt = parseFloat(oft_amt) + parseFloat(amount);
            }
        }
        
        if(ComGetObjValue(formObj.frm_t10sheet1_sc_no_old) != ComGetObjValue(formObj.frm_t10sheet1_sc_no1)
                || ComGetObjValue(formObj.frm_t10sheet1_rfa_no_old) != ComGetObjValue(formObj.frm_t10sheet1_rfa_no)
                || ComGetObjValue(formObj.frm_t10sheet1_taa_no_old) != ComGetObjValue(formObj.frm_t10sheet1_taa_no))
        {
            ComSetObjValue(formObj.frm_t10sheet1_rtro_knd_cd, "C"); // Contract Change
        }else if( old_oft_amt != oft_amt){
            ComSetObjValue(formObj.frm_t10sheet1_rtro_knd_cd, "O"); // OFT Update
        }else if(ComGetObjValue(formObj.frm_t10sheet1_rtro_flg) == "Y"){
            ComSetObjValue(formObj.frm_t10sheet1_rtro_knd_cd, "R"); // Retroactive RFA
        }
        
        if(exsit_Falg){
            findRow = sheetObj.FindText(prefix2 + "exist_chg_cd", "N");
            if (findRow > 0) {
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
                }
                sheetObj.SelectCell(findRow, prefix2 + "chg_cd");
                return false;
            }
    
              findRow = sheetObj.FindText(prefix2 + "exist_curr_cd", "N");
            if (findRow > 0) {
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
                }
                sheetObj.SelectCell(findRow, prefix2 + "curr_cd");
                return false;
            }
              findRow = sheetObj.FindText(prefix2 + "exist_rat_ut_cd", "N");
            if (findRow > 0) {
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
                }
                sheetObj.SelectCell(findRow, prefix2 + "rat_ut_cd");
                return false;
            }
              findRow = sheetObj.FindText(prefix2 + "exist_ofc_cd", "N");
            if (findRow > 0) {
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
                }
                sheetObj.SelectCell(findRow, prefix2 + "n3pty_rcv_ofc_cd");
                return false;
            }
              findRow = sheetObj.FindText(prefix2 + "exist_cust_cnt", "N");
            if (findRow > 0) {
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
                }
                sheetObj.SelectCell(findRow, prefix2 + "n3pty_cust_cnt_cd");
                return false;
            }
              findRow = sheetObj.FindText(prefix2 + "exist_cust_seq", "N");
            if (findRow > 0) {
                if(tab_alert_msg){
                    ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
                }
                sheetObj.SelectCell(findRow, prefix2 + "n3pty_cust_seq");
                return false;
            }
    
            //기능추가 2009.10.08  by 신자영 
            // 회수점소간 중복 check [10/06] third office와 다른 collect 점소가 중복되어도 error
            // 표시되지 않음
            // 1. Prepaid 조건 체크
            if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd).length >= 5){
                findRow = sheetObj.FindText(prefix2 + "n3pty_rcv_ofc_cd", ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd));
                if (findRow > 0) {
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00912", "["+findRow+"] Row" ));
                    }
                    sheetObj.SelectCell(findRow, prefix2 + "n3pty_rcv_ofc_cd");
                    return false;
                }
            }
            if(ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd).length >= 5){
                //2. Collect 조건 체크 
                findRow = sheetObj.FindText(prefix2 + "n3pty_rcv_ofc_cd", ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd));
                if (findRow > 0) {
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00912", "["+findRow+"] Row" ));
                    }
                    sheetObj.SelectCell(findRow, prefix2 + "n3pty_rcv_ofc_cd");
                    return false;
                }
            }

            //기능추가 2009.10.08  by 신자영 
            // 저장하기 전에 체크 항목
            var cnt = sheetObj.RowCount;
            var rf_check_count = 0;
            for ( var ix = 1; ix <= cnt; ix++) {
                if(sheetObj.RowHidden(ix) || "D" == sheetObj.RowStatus(ix)) continue;
                // OFT, ASC charge에 currency가 USD,AUD,EUR,JPY,GBP,DEM이 아닌경우 에러표시
                // [BKG00913]
                var chg_cd = sheetObj.CellValue(ix, prefix2 + "chg_cd");
                if ("OFT" == chg_cd || "ASC" == chg_cd) {
                    var curr_cd = sheetObj.CellValue(ix, prefix2 + "curr_cd");
                    if('USD' == curr_cd||'AUD' == curr_cd|| 'EUR' == curr_cd ||'JPY' == curr_cd||'GBP' == curr_cd||'DEM' == curr_cd ){
                    }else{
                        if(tab_alert_msg){
                            ComShowCodeMessage("BKG00913");
                            // OFT(or ASC) Currency must be 'USD' or 'AUD' or
                            // 'EUR' or 'JPY' or 'GBP' or'DEM'
                        }
                        sheetObj.SelectCell(ix, prefix2 + "curr_cd");
                        return false;
                    }
                }
                /* CHM-201429342 Charge Code "FRB" 관련 로직 삽입
                 * DEL Country 가 Brazil인 경우 Charge 중 FRB 입력 시 Block Logic 포함 및 메세지 삽입 
                 */
                if ("FRB" == chg_cd){
                    if(formObj.frm_t10sheet1_del_cd.value.substring(0, 2) != 'BR'){
                        ComShowCodeMessage("BKG02221");
                        return false;
                    }
                }
                /*
                 * P - prepaid. C - collect
                 * RF건에 대해서는 collect 불가하도록 validation필요
                 */
                var frt_term_cd = sheetObj.CellValue(ix, prefix2 + "frt_term_cd");
                var cgo_cate_cd = sheetObj.CellValue(ix, prefix2 + "cgo_cate_cd");
                var incl_oft_flg = sheetObj.CellValue(ix, prefix2 + "incl_oft_flg");
                if ('RF' == cgo_cate_cd && 'C' == frt_term_cd && 'N' == incl_oft_flg ) {
                    rf_check_count++;   // RF, C와 같은 경우 1번만 표시하기 요청 by 신자영수석
                }
                
                /*
                 * term check해서 없으면 BKG08056 표시 
                 *  "{?msg1} does not have payment term";
                 */
                if('' == frt_term_cd){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG08056", "["+chg_cd+"]" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "frt_term_cd");
                     return false;
                }
                 
                var cust_cnt_cd = sheetObj.CellValue(ix, prefix2 + "n3pty_cust_cnt_cd");
                var cust_seq = sheetObj.CellValue(ix, prefix2 + "n3pty_cust_seq");
                var rcv_ofc_cd = sheetObj.CellValue(ix, prefix2 + "n3pty_rcv_ofc_cd");
                
                // 중간에 빠진 3rd Party Customer의 경우 Office 대표 Customer로 Setting
                if(((rcv_ofc_cd.length >= 5)&&(cust_seq.length == 0)) || ((rcv_ofc_cd.length >= 5)&&(cust_cnt_cd.length == 0))){
                    fnRepCustomer(sheetObj,ix,rcv_ofc_cd);
                    var cust_cnt_cd = sheetObj.CellValue(ix, prefix2 + "n3pty_cust_cnt_cd");
                    var cust_seq = sheetObj.CellValue(ix, prefix2 + "n3pty_cust_seq");
                }
                
                if((rcv_ofc_cd.length >= 5)&&(cust_cnt_cd.length == 0)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_cnt_cd");
                     return false;                  
                }
                if((rcv_ofc_cd.length >= 5)&&(cust_seq.length == 0)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_seq");
                     return false;                  
                }
                if((cust_cnt_cd.length >= 2)&&(rcv_ofc_cd.length == 0)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "n3pty_rcv_ofc_cd");
                     return false;                  
                }
                if((cust_cnt_cd.length >= 2)&&(cust_seq.length == 0)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_seq");
                     return false;                  
                }
                if((cust_seq.length >= 1)&&(cust_cnt_cd.length == 0)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_cnt_cd");
                     return false;                  
                }
                if((cust_seq.length >= 1)&&(rcv_ofc_cd.length == 0)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
                    }
                     sheetObj.SelectCell(ix, prefix2 + "n3pty_rcv_ofc_cd");
                     return false;                  
                }
            }
        }

        //by 신자영수석   경고표시만
        if(rf_check_count > 0){
            if (!ComShowConfirm("[Warning]"+ComGetMsg("BKG08057"))){
                return false;
            }
        }
        
        //by 오동현 auto rating 이후 CHARGE CODE가 WSC 이면서 CONTAINER에 PARTIAL이 존재 하면 INFO 처리
        //by 김태경 Partial Container 의 경우 WSC 를 Rating 할수 없으므로 SVC SCP 에 WSC 존재 하면 INFO 처리 --BKG08181
        //by 김태경 Partial Container 의 경우 CDR 를 Rating 할수 없으므로 SVC SCP 에 CDR 존재 하면 INFO 처리 --BKG08236
        //by 김태경 Container Weight 가 0 값인 경우 WSC 를 Rating 할수 없으므로 INFO 처리   --BKG08202
        //by 김태경 Container Weight 가 0 값인 경우 CDR 를 Rating 할수 없으므로 INFO 처리   --BKG08233
        var cntr_prt_flg = sheetObjects[0].CellValue(1, prefix1 + "cntr_prt_flg");
        var wsc_flg = sheetObjects[0].CellValue(1, prefix1 + "wsc_flg");
        var cdr_flg = sheetObjects[0].CellValue(1, prefix1 + "cdr_flg");
        var txs_flg = sheetObjects[0].CellValue(1, prefix1 + "txs_flg");
        var rwt_flg = sheetObjects[0].CellValue(1, prefix1 + "rwt_flg");
        var cntr_wgt_cmpl_flg = sheetObjects[0].CellValue(1, prefix1+ "cntr_wgt_cmpl_flg");

        if("Y" == cntr_prt_flg && "Y" == wsc_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08181", "WSC"));
        }
        if("Y" == cntr_wgt_cmpl_flg && "Y" == wsc_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08202", "WSC"));
        }
        if("Y" == cntr_prt_flg && "Y" == cdr_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08236"));
        }
        if("Y" == cntr_wgt_cmpl_flg && "Y" == cdr_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08233"));
        }
        if("Y" == cntr_prt_flg && "Y" == txs_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08181", "TXS"));
        }
        if("Y" == cntr_wgt_cmpl_flg && "Y" == txs_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08202", "TXS"));
        }
        if("Y" == cntr_prt_flg && "Y" == rwt_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08181", "RWT"));
        }
        if("Y" == cntr_wgt_cmpl_flg && "Y" == rwt_flg && true == auto_rating ){
            ComShowMessage(ComGetMsg("BKG08202", "RWT"));
        }
        
        //4.서아프리카 Target booking : 아래의 POD를 갖고 있는 부킹 의 Freight Term은 PPD
        /*West Africa : BJCOO, NGLOS, GHTEM, CIABJ, TGLFW, DZALG, DZORN 
          -. 부킹의 Freight term이 PPD가 아닌 경우 아래의 팝업 메시지가 활성화됨.
        [Warning] For WAF service (West African ports), Prepaid term is mandatory. Therefore, the freight term will be automatically defaulted as Prepaid.
          -. 팝업 메시지를 클릭한 후 Freight term이 자동으로 PPD로 디폴트 됨.
        */
        var input_text = ComGetObjValue(formObj.bkg_no);
        var param = param + "&f_cmd=" + COMMAND16 + "&input_text=" + input_text;
        var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
        var west_africa = ComGetEtcData(sXml, "output_text");
        if(west_africa == 'Y' && document.getElementById("frt_term_cd").Code != 'P'){
            ComShowMessage(ComGetMsg("BKG06172"));
            document.getElementById("frt_term_cd").Code = 'P';
        }

        //기능추가 2009.10.08  by 신자영 
        // 자기 B/L NO는 covered B/L로 지정할수 없어야 함. "Master B/L No. can't be used for
        // covered B/L No. Please check B/L No. again."
        var comp1_bl_no = ComGetObjValue(formObj.frm_t10sheet1_bl_no);
        var comp2_bl_no = ComGetObjValue(formObj.covered_name_c);

        //기능추가 2009.11.3 by 신자영
        ComSetObjValue(formObj.frm_t10sheet1_mst_cvrd_bl, ComGetObjValue(formObj.covered_name_c));
        // 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        ComSetObjValue(formObj.f_cmd, MULTI);
        // select box : rt_bl_tp_cd
        ComSetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd, ComGetObjValue(formObj.rt_bl_tp_cd));
        // select box : frt_term_cd
        ComSetObjValue(formObj.frm_t10sheet1_frt_term_cd, document.getElementById("frt_term_cd").Code);
        // select box : svc_scp_cd
        ComSetObjValue(formObj.frm_t10sheet1_svc_scp_cd, ComGetObjValue(formObj.svc_scp_cd));
        // check box : frm_t11sheet1_brk_dwn_flg
        if (formObj.brk_dwn_flg.checked) {
            ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
        } else {
            ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "N");
        }

        // bkg_ctrt_tp_cd 값을 셋팅한다. 
        var bkg_ctrt_tp_cd ='';
        if (!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)) {
            bkg_ctrt_tp_cd='T';
        }else if (!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)) {
            bkg_ctrt_tp_cd='R';
        }else if (!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)) {
            bkg_ctrt_tp_cd='S';
        }
        
        ComSetObjValue(formObj.frm_t10sheet1_bkg_ctrt_tp_cd, bkg_ctrt_tp_cd);
        
        // Sheet에 존재하는 값을 form에 Binding
        if (IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_")) {};
        // SheetObject에 대입
        sheetObjects[0].CellValue(1, prefix1 + "taa_no")            = ComGetObjValue(formObj.frm_t10sheet1_taa_no);     
        sheetObjects[0].CellValue(1, prefix1 + "bkg_ctrt_tp_cd")    = bkg_ctrt_tp_cd;
        sheetObjects[0].CellValue(1, prefix1 + "ppd_rcv_ofc_cd")    = ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd);
        sheetObjects[0].CellValue(1, prefix1 + "ppd_payr_cnt_cd")   = ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
        sheetObjects[0].CellValue(1, prefix1 + "ppd_payr_cust_seq") = ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
        sheetObjects[0].CellValue(1, prefix1 + "clt_ofc_cd")        = ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd);
        sheetObjects[0].CellValue(1, prefix1 + "clt_payr_cnt_cd")   = ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
        sheetObjects[0].CellValue(1, prefix1 + "clt_payr_cust_seq") = ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
        

        //POD/DEL: JOAQJ 인 Booking 중
        //SC경우, S/C Type 이 Non-BCO인 대상만 문구 자동 삽입
        //RFA경우, Shipper Code가 Non-BCO인 대상만 문구 자동 삽입
        //BLDocumentationBLBCImpl.manageMndCmdtDescJOAQJ 호출여부
        if( (ComGetObjValue(formObj.frm_t10sheet1_pod_cd) == 'JOAQJ' || (ComGetObjValue(formObj.frm_t10sheet1_del_cd) == 'JOAQJ'))
                && (comp_sc_no1 != ComGetObjValue(formObj.frm_t10sheet1_sc_no1) || comp_rfa_no != ComGetObjValue(formObj.frm_t10sheet1_rfa_no)) ){
            sheetObjects[0].CellValue(1, prefix1 + "jordan_desc") = 'Y'
        }

        if(tab_alert_msg){
            if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
                // 변경했을경우 
                if(change_prn_hdn_flg){
                    // Do you want to save changed information in 'Hide' column?
                    if (!ComShowConfirm(ComGetMsg("BKG08128"))){
                        return false; 
                    }
                }else{
                    // "Only 'Hide' can be changed after BDR. Please issue C/A."      
                    ComShowMessage(ComGetMsg("BKG08174"));
                    return false; 
                }
            }else{
                if (!ComShowConfirm(ComGetMsg("BKG00350")))
                    return false; // Are you sure to save the changes?
            }
        }
        
        /* Save 시 소숫점 제거  
         * Cur = KRW, JPY, IDR, ITL 인 경우 소수점 제거 하여 저장한다
         * 2010.04.28 김태경 
         */
        fnSplitSetAmount();

        formObj.f_cmd.value = MULTI;
        // 2.저장조건으로 실행
        var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열
        if (sParam == "")
            return false;
        sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
        sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열

        ComOpenWait(true); // 대기창 보임

        //저장 후 Self-Audit 자동 팝업 여부(isOpenSelfAudit)의 조건
        //시트가 수정되었거나(frt_term 제외) Application Date 가 변경된 경우
        isOpenSelfAudit =
            isOpenSelfAudit2 ||
            ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt) != ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt_bak);
        // 2.저장처리
        var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
        // 3.저장후 결과처리
        var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
        if(State != null){
            if ( State == "S" ) {
                sheetObj.LoadSaveXml(sXml);
                ComShowMessage(ComGetMsg("BKG06071"));
                
                if(ComGetEtcData(sXml, "firm_msg_flg") == "Y"){
                    ComShowCodeMessage("BKG08300");
                }
                if(ComGetEtcData(sXml, "aloc_pop_flg") == "Y"){
                    var param = "bkg_no=" + formObj.bkg_no.value + "&aloc_pop_flg=Y"
                              + "&before_aloc_sts_cd=" + ComGetObjValue(formObj.aloc_sts_cd);
                    ComOpenPopup("ESM_BKG_1507.do?"+param, 760, 550, "","1,0,1,1,1", true);
                }
                
            } else {
                fnExceptionMessage(sXml);
            }
        }
        //por(pol)이 CA나 US인 경우만 하단의 로직을 실행 2011.11.10 kbj
        if(validateCRep(formObj)){
            // c.ofc & c.rep 를 체크 2011.10.11 jsy
            var sXml = sheetObj.GetSearchXml("ESM_BKG_1132GS.do?f_cmd="+SEARCH, "&bkg_no="+formObj.bkg_no.value+"&sc_no="+
                                              formObj.frm_t10sheet1_sc_no1.value+"&ctrt_rep_cd="+formObj.ctrt_ofc_cd.value+formObj.ctrt_srep_cd.value+"&app_date="+formObj.application_date.value );
    
            var CtrtRepCnt = ComGetEtcData(sXml, "CtrtRepCnt");
            var compare_cd = ComGetEtcData(sXml, "compare_cd");
            if( compare_cd == 'N') {
                //ComOpenPopup("ESM_BKG_1132.do?pgmNo=ESM_BKG_1132&sXml="+encodeURIComponent(sXml)+"&func=callBack1132", 500, 290, "callBack1132",  "1,0,1,1,1", true);
                ComShowMessage(ComGetMsg("BKG02098"));
                
            }
    //      if( CtrtRepCnt == 1 && compare_cd == 'N') {
    //          var cust_sls_ofc_cd = ComGetEtcData(sXml, "cust_sls_ofc_cd");
    //          var cust_srep_cd = ComGetEtcData(sXml, "cust_srep_cd");
    //          ComSetObjValue(formObj.ctrt_ofc_cd, cust_sls_ofc_cd);
    //          ComSetObjValue(formObj.ctrt_srep_cd, cust_srep_cd);
    //      }
        }

        // TPF Surcharge Interface.
        // 중국 입출항 화물인 경우 PPD, CCT, 3rd Office 에 따라 TPF 부과대상 여부가 달라지기 때문에
        // 데이터 저장 완료 후 TPF 부과여부를 확인하여 Interface 
        if(formObj.frm_t10sheet1_por_cd.value.substring(0, 2) == 'CN' || formObj.frm_t10sheet1_del_cd.value.substring(0, 2) == 'CN'){
            if('N' == ComGetObjValue(formObj.bdrflag) || 'Y' == ComGetObjValue(formObj.caflag)){
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_08GS.do?f_cmd="+SEARCH03, "&bkg_no="+formObj.bkg_no.value+"&ca_flag="+formObj.caflag.value);
                var chgCd = ComGetEtcData(sXml, "chg_cd");
                var currCd = ComGetEtcData(sXml, "curr_cd");
                var scgAmt = ComGetEtcData(sXml, "chg_ut_amt");
                if( chgCd=="TPF" ){
                    if(confirm(ComGetMsg("BKG02219", currCd, scgAmt))){
    
                        var nRow = sheetObj.DataInsert(-1); // 맨하위에 삽입
                        sheetObj.CellValue(nRow, prefix2 + "chg_cd") = chgCd;
                        sheetObj.CellValue(nRow, prefix2 + "trf_itm_no") = '';
                        sheetObj.CellValue(nRow, prefix2 + "curr_cd") = ComGetEtcData(sXml, "curr_cd");
                        sheetObj.CellValue(nRow, prefix2 + "chg_ut_amt") = scgAmt;
                        sheetObj.CellValue(nRow, prefix2 + "rat_as_qty") = '1';
                        sheetObj.CellValue(nRow, prefix2 + "rat_ut_cd") = ComGetEtcData(sXml, "rat_ut_cd");
                        sheetObj.CellValue(nRow, prefix2 + "chg_amt") = scgAmt;
                        sheetObj.CellValue(nRow, prefix2 + "incl_oft_flg") = 'N';
                        sheetObj.CellValue(nRow, prefix2 + "frt_term_cd") = ComGetEtcData(sXml, "frt_term_cd");
                        sheetObj.CellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd") = ComGetEtcData(sXml, "n3pty_rcv_ofc_cd");
                        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_cnt_cd") = ComGetEtcData(sXml, "n3pty_cust_cnt_cd");
                        sheetObj.CellValue(nRow, prefix2 + "n3pty_cust_seq") = ComGetEtcData(sXml, "n3pty_cust_seq");
                        sheetObj.CellValue(nRow, prefix2 + "cgo_cate_cd") = 'DR';
                        sheetObj.CellValue(nRow, prefix2 + "rcv_term_cd") = ComGetEtcData(sXml, "rcv_term_cd");
                        sheetObj.CellValue(nRow, prefix2 + "de_term_cd") = ComGetEtcData(sXml, "de_term_cd");
                        sheetObj.CellValue(nRow, prefix2 + "imdg_clss_cd") = '';
                        sheetObj.CellValue(nRow, prefix2 + "auto_rat_cd") = 'I';
                        sheetObj.CellValue(nRow, prefix2 + "prn_hdn_flg") = '';
    
                        formObj.f_cmd.value = MULTI;
                        ComSetObjValue(formObj.autoRate, "N" );
                        ComSetObjValue(formObj.removeAll, "N" );
                        // 2.저장조건으로 실행
                        var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열
                        if (sParam == "")
                            return false;
                        sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
                        sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열
                        ComOpenWait(true); // 대기창 보임
    
                        var sXml = sheetObj.GetSaveXml('ESM_BKG_0079_08GS.do', sParam);
                    }                                   
                }               
            }                   
        }
        
        if(tab_alert_msg){// TAB 이동시에 조회방지
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }

        break;

    case COMMAND03: // 입력
        formObj.f_cmd.value = COMMAND03;
        var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
        var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
        var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
        bkgSplitNoListPop(formObj.frm_t10sheet1_bkg_no,bkg_split_no_list,-15);          
        break;  
        
//    case COMMAND08: // 입력        
//        formObj.f_cmd.value = MULTI01;
//        ComOpenWait(true); // 대기창 보임
//        // 2.저장처리
//        var sXml = sheetObj.GetSaveXml("ESM_BKG_9460GS.do", FormQueryString(formObj));
//        // 3.저장후 결과처리
//        var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
//        if(State == null){
//                fnExceptionMessage(sXml);
//        }
//        break; 
        
    }
    
    ComOpenWait(false); // 대기창 사라짐
}
/**
  * booking split no 팝업창에서 선택값을 object에 넣음
  * param : splitno
  * @version 2009.06.29
*/
function bkgSplitSet(splitno){
    document.form.frm_t10sheet1_bkg_no.value = splitno;
    document.form.frm_t10sheet1_bkg_no.focus();
    layList.style.display = "none";
    isSplitNoOpen = false;
}

var Text_Bkg_No_Html = null;
var Select_Bkg_No_Html = null;
var Text_Bl_No_Html = null;
var Select_Bl_No_Html = null;
/**
 * fnSetSelectNumberBox 테이블생성 이벤트 param :formObj_id,
 * formObj_value=변수값,데이터1값,데이터2값
 */

function fnSetSelectNumberBox(_name, _type) {
    var vobj = eval("document.all." + _name); // SELECT 박스 위치 ID값
    var sheetObj = sheetObjects[1];
    var formObj = document.form;
    var html = "";

    try {

        switch (_type) {

        case 'text_bkg_no': //text

                if(ComIsEmpty(formObj.frm_t10sheet1_bkg_no.value)){
                    ComShowMessage(ComGetMsg("BKG00463"));
                    ComSetFocus(formObj.frm_t10sheet1_bkg_no);
                    return false;
                }
        
                if (null == Select_Bkg_No_Html || ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
                     
                    var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
                    var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
                    Select_Bkg_No_Html = ComGetEtcData(rXml, "bkg_split_no_list");
                    if(Select_Bkg_No_Html.indexOf("<option") < 0) return false;

                }
        
                var obj = formObj.frm_t10sheet1_bkg_no;
                var top = document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 10;
                var left = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
        
                vobj.innerHTML = Select_Bkg_No_Html;
                vobj.style.top = top;                   
                vobj.style.left = left;
                vobj.style.display = "inline";
                
        return;
            break; 
        case 'text_bl_no': //text

                if(ComIsEmpty(formObj.frm_t11sheet1_bl_no.value)){
                    ComShowMessage(ComGetMsg("BKG00609"));
                    ComSetFocus(formObj.frm_t11sheet1_bl_no);
                    
                    return false;
                }
                
                if (null == Select_Bl_No_Html || ComGetObjValue(formObj.bl_no) != ComGetObjValue(formObj.frm_t11sheet1_bl_no)) {
                    fnSetBlNoStringCheck(ComGetObjValue(formObj.frm_t11sheet1_bl_no));
                    var param = param + "&f_cmd=" + SEARCHLIST15 + "&input_text=" + ComGetObjValue(formObj.bl_no);
                    var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                    var output_text = ComGetEtcData(sXml, "output_text");
                    output_text = output_text + '^' + output_text;
                    Select_Bl_No_Html = fnSetSelectString('fnSetBlNo', output_text);
                }
        
                var obj = formObj.frm_t11sheet1_bl_no;
                var top = document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 10;
                var left = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
        
                vobj.innerHTML = Select_Bl_No_Html;
                vobj.style.top = top;                   
                vobj.style.left = left;
                vobj.style.display = "inline";
                
            break;
        }
    } catch (ex) {
        fnBkgErrorAlert('fnSetSelectNumberBox', ex);
    }
}
/**
* bkgSplitNoList BKG_목록_이벤트 
* param :split_list
*/
function bkgSplitNoList(split_list){
    document.form.frm_t10sheet1_bkg_no.value = split_list.options[split_list.selectedIndex].value;
    span_bkg_no.style.display="none";
}
/**
 * fnSetSelectString 테이블생성 이벤트 
 * param :formObj_id, formObj_value=변수값,데이터1값,데이터2값
 */
function fnSetSelectString(_name, _value) {
    var html = "";
    try {
        var aList = _value.split("^");
        var aCode, aName;
        var aCode = aList[0].split("$");
        var aName = aList[1].split("$");
        var len = aCode.length;
        if (len == 0)
            return;

        html = "<select style='width:110;' class='input' size=5 multiple onChange='javascript:bkgSplitNoList(this);' name='" + _name + "'>"
        for ( var z = 0; z < len; z++) {
            html += "<option value='" + aCode[z] + "'>" + aName[z] + "</option>";
        }
        html += "</table>";

    } catch (ex) {
        fnBkgErrorAlert('fnSetSelectString', ex);
    }
    return html;
}
/**
* frt_term_cd_OnChange  이벤트 발생
* 선택값에 따른 변경항목 
* P-pre 
* C-col 
*/
function frt_term_cd_OnChange(idx_cd, text) {
    var formObj = document.form;

    if(ComGetObjValue(formObj.frm_t10sheet1_frt_term_cd) != text ){
        ComSetObjValue(formObj.modify_flag, "Y");
        /* FRT_TERM_CD DATA 보정 */
        ComSetObjValue(formObj.frm_t10sheet1_frt_term_cd, text);
    }else{
        ComSetObjValue(formObj.modify_flag, "N"); 
    }
}
/**
 * rt_bl_tp_cd_OnChange  이벤트 발생
 * 선택값에 따른 변경항목 
 * N-nomal 
 * M-covers 
 * C-coverd By
 * B-Co Biz 
 */
function rt_bl_tp_cd_OnChange(idx_cd, text) {
     var formObj = document.form;
        
    if ('M' == text) {
        document.all.covered_name.innerHTML = "Covers";
        document.all.covered_id_m.style.display = "block";
        document.all.covered_id_c.style.display = "none";
        document.all.covered_id_b.style.display = "none";
    } else if ('C' == text) {
        document.all.covered_name.innerHTML = "Covered By";
        document.all.covered_id_c.style.display = "block";
        document.all.covered_id_m.style.display = "none";
        document.all.covered_id_b.style.display = "none";
        ComSetObjValue(formObj.covered_name_c, ComGetObjValue(formObj.frm_t10sheet1_mst_cvrd_bl));
    } else if ('B' == text) {
        document.all.covered_name.innerHTML = "INR Auth";
        document.all.covered_id_c.style.display = "none";
        document.all.covered_id_m.style.display = "none";
        document.all.covered_id_b.style.display = "block";
    } else {
        document.all.covered_name.innerHTML = "";
        document.all.covered_id_m.style.display = "none";
        document.all.covered_id_c.style.display = "none";
        document.all.covered_id_b.style.display = "none";
    }

    if(ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd) != text ){
        ComSetObjValue(formObj.modify_flag, "Y");
    }else{
        ComSetObjValue(formObj.modify_flag, "N"); 
    }
}
 /**
  * t10sheet2_OnSearchEnd  조회완료 후 이벤트 발생 
  * param :sheetObj, ErrMsg
  * 유저가 I/N 변경 가능. Indicator 종류 : I / N  IN의 자동표시 로직은 PRI와 확인필요 I인
  * 경우 기울임 체로 표시 I인 경우 charge code 부분에 색깔처리(화면 참조)
  */
 function t10sheet2_OnSearchEnd(sheetObj, ErrMsg) {
     var l_row = sheetObj.RowCount;
     var formObj = document.form;
     
     for ( var i = 1; i <= l_row; i++) {
        var incl_oft_flg = sheetObj.CellValue(i, prefix2 + "incl_oft_flg");
        if ('I' == incl_oft_flg) {
            sheetObj.CellFont("FontItalic", i, 1, i,24) = true;         
            sheetObj.CellBackColor(i, prefix2 + "chg_cd") = sheetObj.RgbColor(153, 204, 255);// blue
        }
     }
 }

/**
* fnSetTrf_itm_no  번호 셋팅
* param :sheetObj
*/
var trf_itm_no ='';
function fnSetTrf_itm_no(sheetObj){

    var formObj = document.form;
    var cnt = sheetObj.RowCount;
    if (cnt == 0)   return;
    
    var sc_no = ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
    var rfa_no = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
    var taa_no = ComGetObjValue(formObj.frm_t10sheet1_taa_no);

    if(sc_no != null && sc_no.length > 0){
        trf_itm_no = sc_no;
    }else{
        trf_itm_no = '';
    }

    // by2010.3.26 김태경 trf_itm_no 
    for ( var i = 1; i <= cnt; i++) {
        if(!sheetObj.RowHidden(i) && "D" != sheetObj.RowStatus(i)){ 
            var chg_cd = sheetObj.CellValue(i, prefix2 + "chg_cd");
            if ("OFT" == chg_cd) {
                if(ComIsEmpty(sheetObj.CellValue(i, prefix2 + "trf_itm_no"))){
                    sheetObj.CellValue(i, prefix2 + "trf_itm_no")= trf_itm_no;
                }
                break;
            }
        }
    }
}

/**
 * t10sheet1_OnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function t10sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    var formObj = document.form;
    var cnt = sheetObj.RowCount;
    if (cnt == 0)
        return;
    try {
        //FORM VALUE BINDING 
        if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {
        }
        ;

        var l_row = sheetObj.RowCount;
        if(l_row == 0) return;
        // Weight
        ComSetObjValue(formObj.frm_t10sheet1_act_wgt, sheetObj.CellText(l_row, "t10sheet1_act_wgt"));
        // Measure
        ComSetObjValue(formObj.frm_t10sheet1_meas_qty, sheetObj.CellText(l_row, "t10sheet1_meas_qty"));
    
        ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t10sheet1_bkg_no));
        ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t10sheet1_bl_no));
        ComSetObjValue(formObj.sc_no, ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
        ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));

        // Audit Status : E : 빨간색
        if ('E' == ComGetObjValue(formObj.frm_t10sheet1_aud_sts_cd)) {
            formObj.frm_t10sheet1_aud_sts_cd.style.color = 'red';
            document.getElementById('btn_t10self').style.color="red";
        }else{
            formObj.frm_t10sheet1_aud_sts_cd.style.color = '';
            document.getElementById('btn_t10self').style.color="";
        }
        //Remark(s) : Y : 빨간색
        if ('Y' == ComGetObjValue(formObj.frm_t10sheet1_rmark_yn)) {
            document.getElementById('btn_t10remark').style.color = 'blue';
        }else{
            document.getElementById('btn_t10remark').style.color = '';
        }

        //WHF exemption  값이존재시  빨간색 (추가: by 신자영)
        if ('' != ComGetObjValue(formObj.frm_t10sheet1_bkg_rt_whf_expt_cd)) {
            document.getElementById('btn_t10adj').style.color = 'blue';
        } else if('' != ComGetObjValue(formObj.frm_t10sheet1_dhf_loc_cd)){
            document.getElementById('btn_t10adj').style.color = 'blue';
        } else if('' != ComGetObjValue(formObj.frm_t10sheet1_ddc_curr_cd)){
            document.getElementById('btn_t10adj').style.color = 'blue';
        } else if('' != ComGetObjValue(formObj.frm_t10sheet1_dhf_curr_cd)){
            document.getElementById('btn_t10adj').style.color = 'blue';
        }else{
            document.getElementById('btn_t10adj').style.color = '';
        }
        //X이면 [SAVE]버튼  disable  (추가: by 신자영)
        if ('X' == ComGetObjValue(formObj.frm_t10sheet1_bkg_sts_cd)) {
            ComBtnDisable("btn_t10save");
        }else{
            ComBtnEnable("btn_t10save");
        }
        
        /*********************************
        [CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가
        ITS/방지경 대리 요청으로 추후 반영
        // Charge Amend 권한이 없는 경우 , Reject된 경우 [CHG Amend] 버튼 활성화
        //  기존 Amend 권한 요청이 Request(Approval 대기), 운임 변경 가능한 상태일 때 버튼 비활성화       
        if('N' == ComGetObjValue(formObj.frm_t10sheet1_oft_amdabl_flg) || 
                'R' == ComGetObjValue(formObj.frm_t10sheet1_oft_amdabl_flg) ){
            ComBtnEnable("btn_t10chg_amend");
        }else{
            ComBtnDisable("btn_t10chg_amend");
        }
        *******************************************/

        // Service Scope setting
        var svc_scp_cd = ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd);
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
        fnSetComboBox('svc_scp_cd', r_value, '');
        
        // - covered bl_no setting
        ComSetObjValue(formObj.covered_name_c, ComGetObjValue(formObj.frm_t10sheet1_mst_cvrd_bl));
        
        // - rt_bl_tp_cd Co_Biz B/L 인경우
        if ('B' == ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd)) {
            var cobiz_auth_no = ComGetObjValue(formObj.frm_t10sheet1_cobiz_auth_no);
            var inrAuth1 = cobiz_auth_no.substr(0,5);
            var inrAuth2 = cobiz_auth_no.substr(5,2);
            var inrAuth3 = cobiz_auth_no.substr(7,2);
            var inrAuth4 = cobiz_auth_no.substr(9,4);
            var inrAuth5 = cobiz_auth_no.substr(13,1);
            var inrAuth6 = cobiz_auth_no.substr(14,4);
            // ComSetObjValue(formObj.inrAuth1,inrAuth1);
            ComSetObjValue(formObj.inrAuth2,inrAuth2);
            ComSetObjValue(formObj.inrAuth3,inrAuth3);
            // ComSetObjValue(formObj.inrAuth4,inrAuth4);
            ComSetObjValue(formObj.inrAuth5,inrAuth5);
            ComSetObjValue(formObj.inrAuth6,inrAuth6);
        }else{
            ComSetObjValue(formObj.frm_t10sheet1_cobiz_auth_no,''); 
            ComSetObjValue(formObj.inrAuth2,'');
            ComSetObjValue(formObj.inrAuth3,'');
            ComSetObjValue(formObj.inrAuth5,'');
            ComSetObjValue(formObj.inrAuth6,'');
        }

        //sc_no 값셋팅
        ComSetObjValue(formObj.frm_t10sheet1_sc_no1,ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2))
        ComSetObjValue(formObj.frm_t10sheet1_sc_no2,'');
        
        // svc_scp_cd 값셋팅
        ComSetObjValue(formObj.svc_scp_cd, ComGetObjValue(formObj.frm_t10sheet1_bkg_svc_scp_cd));
        
        if ('' != sheetObj.CellText(l_row, "t10sheet1_doc_inter_rmk") && openFlg == "Y"){
            if(confirm(ComGetMsg("BKG95115"))){
                var _Width = '750';
                var _Height = '560';
                var pgmNo = "&pgmNo=ESM_BKG_0265";
                var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)+"&ca_flg="+ ComGetObjValue(formObj.caflag);
                

                if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
                    var url ="ESM_BKG_0265.do?readOnly=" +'Y'+ "&" + param + pgmNo;
                }else{
                    var url = "ESM_BKG_0265.do?" + param + pgmNo;
                }
                
                rValue = ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
                openFlg = "N";
            }
        }
    } catch (ex) {
        fnBkgErrorAlert('sheet1_OnSearchEnd', ex);
        return false;
    }
}
 /**
  * existNoteColorChange 이벤트 호출 .<br>
  * auto_rating 을 했을경우 or 값이 존재할경우 'Y' 색상을 변경
  * @param _val
  */
 function fnExistNoteButtonColor() {

    var sheetObj = sheetObjects[1];
    var cnt = sheetObj.RowCount;
    var input_text  ="";
    var output_text ="";
    var formObj = document.form;

    try{
        if(cnt > 0){
            for (var i = 0; i <= cnt; i++){
                if(sheetObj.CellValue(i,prefix2 + "chg_cd") =="OFT"){
                    var prop_no = sheetObj.CellValue(i,prefix2 + "prop_no");
                    var amdt_seq = sheetObj.CellValue(i,prefix2 + "amdt_seq");
                    var svc_scp_cd = sheetObj.CellValue(i,prefix2 + "svc_scp_cd");
                    var note_rt_seq = sheetObj.CellValue(i,prefix2 + "note_rt_seq");
                    var gen_spcl_rt_tp_cd = sheetObj.CellValue(i,prefix2 + "gen_spcl_rt_tp_cd");
                    var cmdt_hdr_seq = sheetObj.CellValue(i,prefix2 + "cmdt_hdr_seq");
                    var rout_seq = sheetObj.CellValue(i,prefix2 + "rout_seq");
                    if(prop_no.length > 0 && amdt_seq.length > 0 && svc_scp_cd.length > 0 ){
                        input_text = prop_no+"|"+amdt_seq+"|"+svc_scp_cd+"|"+note_rt_seq+"|"+gen_spcl_rt_tp_cd+"|"+cmdt_hdr_seq+"|"+rout_seq;
                    }
                    break;
                }
            }
            if(input_text.length > 0 && (ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2)).length > 0) {
                var param = param + "&f_cmd=" + COMMAND03 + "&input_text=" + input_text;
                var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
                output_text = ComGetEtcData(sXml, "output_text");
            }
        }
    
        //색상변경
        if ('Y' == output_text) {
            document.getElementById('btn_t10note').style.color = 'blue';
        }else{
            document.getElementById('btn_t10note').style.color = '';
        }
        if ("" != sheetObjects[0].CellValue(1, prefix1 + "mst_rfa_rout_id")) {
            document.getElementById('btn_t10RoutId').style.color = 'blue';
        }else{
            document.getElementById('btn_t10RoutId').style.color = '';
        }
        
        //OFT 위치 trf_itm_no 값 넣기  
        fnSetTrf_itm_no(sheetObj);
        
    } catch (ex) {
        fnBkgErrorAlert('fnExistNoteButtonColor', ex);
        return false;
    }
 }

  /**
   * fnCheckBrk_dwn_flg
   * Brk_dwn_flg : Service Scope에따라  TPE, TPW 인경우 N, 나머지 Y 
   * param : 
   */
 function fnCheckBrk_dwn_flg(){
        var formObj = document.form;
        var svc_scp_cd = ComGetObjValue(formObj.frm_t10sheet1_bkg_svc_scp_cd);
        if(svc_scp_cd.length >0){
            svc_scp_cd = svc_scp_cd.substring(0,3);
            // Service Scope 인경우 TPE, TPW 인경우 N, 나머지 Y
            if('TPE' == svc_scp_cd 
                || 'TPW' == svc_scp_cd 
                || 'ACE' == svc_scp_cd 
                || 'ACW' == svc_scp_cd 
                || 'MXE' == svc_scp_cd 
                || 'MXW' == svc_scp_cd 
            ){
                formObj.brk_dwn_flg.checked = false;
            }else{
                formObj.brk_dwn_flg.checked = true;
            }
        }
 }
 /**
  * fnCheckBrk_dwn_flg
  * Brk_dwn_flg 경우 RFA NO, S/C NO에 따른 체크 
  * param : 
  */
function fnCheckBrk_dwn_flg_back(){

    var formObj = document.form;
    // 1. RFA NO 존재하는경우
    var rfa_no = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
    var taa_no = ComGetObjValue(formObj.frm_t10sheet1_taa_no);
    if(rfa_no.length >0){
        formObj.brk_dwn_flg.checked = true;
        formObj.brk_dwn_flg.disabled = true;
        ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
    }else if(taa_no.length >0){
        formObj.brk_dwn_flg.checked = true;
        formObj.brk_dwn_flg.disabled = true;
        ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
    }else{
    //2. S/C NO 존재하고 && Service Scope 인경우 
        var svc_scp_cd = ComGetObjValue(formObj.frm_t10sheet1_bkg_svc_scp_cd);
        if(svc_scp_cd.length >0){
            svc_scp_cd = svc_scp_cd.substring(0,3);
            if('TPE' == svc_scp_cd 
            || 'TPW' == svc_scp_cd 
            || 'ACE' == svc_scp_cd 
            || 'ACW' == svc_scp_cd 
            || 'MXE' == svc_scp_cd 
            || 'MXW' == svc_scp_cd 
            ){
                return; 
            }else{
                var brk_dwn_flg_check 
                    = ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ ComGetObjValue(formObj.frm_t10sheet1_sc_no2);

                if(brk_dwn_flg_check.length >0){
                    //checked  
                    formObj.brk_dwn_flg.checked = true;
                    formObj.brk_dwn_flg.disabled = true;
                    ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
                }else{
                    formObj.brk_dwn_flg.checked = false;
                    formObj.brk_dwn_flg.disabled = false;
                    ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "N");
                    return;
                }
            }
        }else{
            //모든 조건 만족안함 
            return;
        }
    }
}
/**
 * fnNullToBlank
 * null값인 경우 default값을 return한다.
 * param : xval,yval
 */
function fnNullToBlank(xval, yval) {
    return (xval != null && xval != "") ? xval : yval;
}

/**
 * t10sheet3_OnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function t10sheet3_OnSearchEnd(sheetObj, ErrMsg) {
    var formObj = document.form;
    var cnt = sheetObj.TotalRows;
    if (cnt == 0)
        return;
    try {
        for ( var i = 1; i <= cnt; i++) {
            var type = sheetObj.CellValue(i, prefix3 + "type");
            var value1 = sheetObj.CellValue(i, prefix3 + "curr_cd");
            var value2 = sheetObj.CellValue(i, prefix3 + "chg_amt");

            if ('p_' == type) {
                fnSetShowTable('TOTAL_PPD', value1, value2);
            } else if ('c_' == type) {
                fnSetShowTable('TOTAL_CCT', value1, value2);
            } else if ('cct_' == type) {
                fnSetShowTable('TOTAL_3rdCCT', value1, value2);
                var rCombo = fnGetStringCombind(sheetObj, i);
                var result = rCombo + "^" + rCombo;
                fnSetComboBox('select_3rdCCT', result, '');
            } else if ('ppd_' == type) {
                fnSetShowTable('TOTAL_3rdPPD', value1, value2);
                var rCombo = fnGetStringCombind(sheetObj, i);
                var result = rCombo + "^" + rCombo;
                fnSetComboBox('select_3rdPPD', result, '');
            }
            IBS_CopyRowToForm(sheetObj, formObj, i, "frm_" + type);
        }
    } catch (ex) {
        fnBkgErrorAlert('sheet3_OnSearchEnd', ex);
        return false;
    }
}
/**
* t10sheet4_OnSearchEnd  조회완료 후 이벤트 발생 
* param :sheetObj, ErrMsg
*/
function t10sheet4_OnSearchEnd(sheetObj, ErrMsg) {
    var formObj = document.form;
    ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt_bak,formObj.frm_t10sheet1_rt_aply_dt.value);
    //TRO 에서 Input 한경우 날짜가 없어도 Data 가 존재하므로 Rowcheck 기능 까지 추가
    if(ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).length == 0 && sheetObjects[1].RowCount == 0){ 
        var sheetObj2 = sheetObjects[1];
        var sheetObj4 = sheetObjects[3];
        var cnt = sheetObj4.TotalRows;
        if(cnt == 0) return;
        sheetObj2.RemoveAll();  // Grid 초기화 해줌

        for ( var i = 1; i <= cnt; i++) {
            var newRow = setDataInsert(sheetObj2, 2);
            sheetObj2.RowStatus(newRow)= "R";
            sheetObj2.CellValue(newRow, prefix2 + "chg_cd")     = 'OFT';
            sheetObj2.CellValue(newRow, prefix2 + "curr_cd")    = 'USD';
            sheetObj2.CellValue(newRow, prefix2 + "rat_ut_cd")  =sheetObj4.CellValue(i, prefix4 + "cntr_tpsz_cd");
            sheetObj2.CellValue(newRow, prefix2 + "rat_as_qty") =sheetObj4.CellValue(i, prefix4 + "qty");
            sheetObj2.CellValue(newRow, prefix2 + "cgo_cate_cd")=sheetObj4.CellValue(i, prefix4 + "cgo");
        }
    }
}

/**
* setBookingEditable  활성,비활성화 
* param : isEnable
*/
function setBookingEditable(isEnable){
     var formObj = document.form;
     var sheetObj = sheetObjects[1];
     
     // input box
     BkgEnableObject(formObj.frm_t10sheet1_rt_aply_dt, isEnable);
     BkgEnableObject(formObj.frm_t10sheet1_rfa_no, isEnable);
     BkgEnableObject(formObj.frm_t10sheet1_sc_no1, isEnable);
     // BkgEnableObject(formObj.frm_t10sheet1_sc_no2, isEnable);
     BkgEnableObject(formObj.frm_t10sheet1_taa_no, isEnable);
     BkgEnableObject(formObj.frm_p_t10sheet3_ofc_cd, isEnable);
     BkgEnableObject(formObj.frm_p_t10sheet3_cnt_cd, isEnable);
     BkgEnableObject(formObj.frm_p_t10sheet3_cust_seq, isEnable);
     BkgEnableObject(formObj.frm_c_t10sheet3_ofc_cd, isEnable);
     BkgEnableObject(formObj.frm_c_t10sheet3_cnt_cd, isEnable);
     BkgEnableObject(formObj.frm_c_t10sheet3_cust_seq, isEnable);
     BkgEnableObject(formObj.frm_t10sheet1_brk_dwn_flg, isEnable);
     BkgEnableObject(formObj.covered_name_c, isEnable);
     
     BkgEnableObject(formObj.inrAuth2, isEnable);
     BkgEnableObject(formObj.inrAuth3, isEnable);
     BkgEnableObject(formObj.inrAuth5, isEnable);
     BkgEnableObject(formObj.inrAuth6, isEnable);

     // select check_box
     ComEnableManyIBCombo(isEnable, formObj.rt_bl_tp_cd, formObj.frt_term_cd);
     
     // sheetObject
     var backColor = sheetObj.RgbColor(255, 255, 255);
     var chargeColor = sheetObj.RgbColor(255, 255, 255);
     if(!isEnable){
         ComBtnDisable("btn_t10add");
         ComBtnDisable("btn_t10del");
         ComBtnDisable("btn_t10merge");
         backColor = sheetObj.RgbColor(204, 204, 204);// gray
         chargeColor = backColor;// gray
     }else{
         ComBtnEnable("btn_t10add");
         ComBtnEnable("btn_t10del");
         ComBtnEnable("btn_t10merge");
         formObj.frm_t10sheet1_rt_aply_dt.className = "input1";
     }
     
     //Sheet_object :  ColBackColor
     for(var nRow=1; nRow <= sheetObj.RowCount; nRow++) {
         sheetObj.RowBackColor(nRow) = backColor;
         sheetObj.CellEditable(nRow, prefix2 + "trf_itm_no")        = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "chg_ut_amt")        = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "rat_as_qty")        = isEnable;
         sheetObj.CellBackColor(nRow, prefix2 + "chg_amt")          = sheetObj.RgbColor(204, 204, 204);
         sheetObj.CellEditable(nRow, prefix2 + "incl_oft_flg")      = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "frt_term_cd")       = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "n3pty_rcv_ofc_cd")  = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "n3pty_cust_cnt_cd") = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "cgo_cate_cd")       = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "rcv_term_cd")       = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "de_term_cd")        = isEnable;
         sheetObj.CellEditable(nRow, prefix2 + "imdg_clss_cd")      = isEnable;

         
         //BDR 이후 Hide 를 전지역(Route) 에 적용 되었으나, ‘BR’ 지역으로만 변경  2012.10.30
         if(formObj.frm_t10sheet1_pod_cd.value.substring(0,2) =="BR"){
         // Hide Column disabled 처리 추가
        
             sheetObj.CellEditable(nRow, prefix2 + "prn_hdn_flg")       = isEnable;
         }else{
        
             sheetObj.CellBackColor(nRow, prefix2 + "prn_hdn_flg")      = sheetObj.RgbColor(255, 255, 255);
         }
        
         
         sheetObj.CellBackColor(nRow, prefix2 + "chg_cd")           = chargeColor;
         
        /*********************************
        [CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가
        ITS/방지경 대리 요청으로 추후 반영
         // PCT + 1일 이후 OFT 수정 불가. Amend 권한을 받아야 OFT 금액 변경 가능함.
         if((formObj.frm_t10sheet1_oft_amdabl_flg.value == "N" || formObj.frm_t10sheet1_oft_amdabl_flg.value == "Q" || formObj.frm_t10sheet1_oft_amdabl_flg.value == "R") && 
                 sheetObj.CellValue(nRow, prefix2 + "chg_cd") == "OFT"){
             sheetObj.RowEditable(nRow) = false;
             sheetObj.RowBackColor(nRow) = sheetObj.RgbColor(204, 204, 204);             
         }
         *******************************/
         // by 2010.2.10 김태경 : 색상blue로 변경
         var incl_oft_flg = sheetObj.CellValue(nRow, prefix2 + "incl_oft_flg");
         if ('I' == incl_oft_flg) {
             sheetObj.CellBackColor(nRow, prefix2 + "chg_cd") = sheetObj.RgbColor(153, 204, 255);
         }
     }
     
     if(isEnable){
         this.t10sheet2_OnSearchEnd(sheetObj, '');
     }
     //특정단위일때 소숫점없애기
     fnSplitAmount();
}

/**
 * IBMultiCombo 일괄 Enable/Disable 처리  
 */
function ComEnableManyIBCombo(bEnable, objs) {
    try {
        var args = arguments;

        if (args.length < 2) return;
        for(var i=1; i<args.length; i++) {
            if (args[i].tagName != undefined) {
                args[i].Enable = bEnable;
            }
        } 
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
* fnSplitAmount  특정단위일때 소숫점없이 보여주는 함수
* param :
*/
function fnSplitAmount() {
    var sheetObj = sheetObjects[1];
    var cnt = sheetObj.RowCount;
    for(var ix=1; ix <= cnt; ix++) {
        var curr_cd = sheetObj.CellValue(ix, prefix2 + "curr_cd");

        if ("KRW" == curr_cd || "JPY" == curr_cd || "IDR" == curr_cd || "ITL" == curr_cd) {
            var chg_amt = sheetObj.CellValue(ix, prefix2 + "chg_amt");
            //sheetObj.CellText(ix, prefix2 + "chg_amt") = Math.floor(chg_amt)+".00";
            chg_amt = Math.floor(chg_amt);
            sheetObj.CellText(ix, prefix2 + "chg_amt") = ComAddComma2(parseInt(chg_amt), "#,###");
        }
        // IBSheet Test 를 위해서 삽입 
        /*

        if ("KRW" == curr_cd || "JPY" == curr_cd || "IDR" == curr_cd || "ITL" == curr_cd) {
            var chg_amt = sheetObj.CellValue(ix, prefix2 + "chg_amt");
            //sheetObj.CellText(ix, prefix2 + "chg_amt") = Math.floor(chg_amt)+".00";
            chg_amt = Math.floor(chg_amt);
            sheetObj.InitCellProperty(ix,prefix2 + "chg_amt", dfNone, daRight, prefix2 + "chg_amt", "",dfNullInteger);

        }else{
            sheetObj.InitCellProperty(ix,prefix2 + "chg_amt", dfNone, daRight, prefix2 + "chg_amt", "",dfNullFloat, 2);
        }



        */
    }
}
/**
* fnSplitAmount  특정단위일때 소숫점 없애는 함수
* param :
*/
function fnSplitSetAmount() {
    var sheetObj = sheetObjects[1];
    var cnt = sheetObj.RowCount;
    for(var ix=1; ix <= cnt; ix++) {
        var curr_cd = sheetObj.CellValue(ix, prefix2 + "curr_cd");
        if ("KRW" == curr_cd || "JPY" == curr_cd || "IDR" == curr_cd || "ITL" == curr_cd) {
            var chg_amt = sheetObj.CellValue(ix, prefix2 + "chg_amt");
            sheetObj.CellValue2(ix, prefix2 + "chg_amt") = Math.floor(chg_amt);
        }
    }
}
/**
 * fnClearForm  form 초기화 이벤트 
 * param :
 */
function fnClearForm() {
    var formObj = document.form;
    
    fnClearTextBox('TOTAL_PPD');// Prepaid
    fnClearTextBox('TOTAL_CCT');// Collect
    fnClearTextBox('TOTAL_3rdPPD');// 3rd Party - PPD
    fnClearTextBox('TOTAL_3rdCCT');// 3rd Party - CCT

    fnClearSelect('select_3rdCCT');// 3rd Party - CCT
    fnClearSelect('select_3rdPPD');// 3rd Party - PPD

    ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd, "");
    ComSetObjValue(formObj.frm_p_t10sheet3_cnt_cd, "");
    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq, "");
    ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd, "");
    ComSetObjValue(formObj.frm_c_t10sheet3_cnt_cd, "");
    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq, "");
    
    ComSetObjValue(formObj.covered_name_c, '');
    ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable, '');
    ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable, '');
    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, '');
    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, '');

    document.getElementById('frm_t10sheet1_sc_no1').style.color = '';
    try{
        if(ComGetObjValue(formObj.isInquiry) == "Y"){
            setInquiryDisableButton();
        }
        parent.initCAControl("", "N", "N", "N", "");
    }catch(e){}
}
/**
 * fnGetStringCombind 문자열을 이어주는 함수 
 * param :sheetObj, y ( sheet오브젝트 , row행)
 */
function fnGetStringCombind(sheetObj, y) {
    try {
        var value1 = sheetObj.CellValue(y, prefix3 + "ofc_cd");
        var value2 = sheetObj.CellValue(y, prefix3 + "cnt_cd");
        var value3 = sheetObj.CellValue(y, prefix3 + "cust_seq");
        var _ofc_cd = value1.split("|");
        var _cnt_cd = value2.split("|");
        var _cust_seq = value3.split("|");
        var _cnt = _ofc_cd.length;

        var vCombo = '';
        var _first = false
        for ( var k = 0; k < _cnt; k++) {
            if (_first) {
                vCombo += "$";
            }
            if(_ofc_cd[k] != '')
            vCombo += _ofc_cd[k] + "  :  " + _cnt_cd[k] + "  :  " + _cust_seq[k];
            _first = true
        }
    } catch (ex) {
        fnBkgErrorAlert('fnGetStringCombind', ex);
    }
    return vCombo;
}

/**
 * fnSetShowTable 테이블생성 이벤트 
 * param :formObj_id, formObj_value=변수값,데이터1값,데이터2값
 */
function fnSetShowTable(_name, _value1, _value2) {
    try {
        var obj = eval("document.all." + _name); // SELECT 박스 위치 ID값
        var value1 = _value1.split("|");
        var value2 = _value2.split("|");
        var len = value1.length;
        if (len == 0)
            return;
        var html = "";
        var val_amt =0.00;
        html = "<div style='overflow:auto;height:48px;'><table width='100%' cellpadding='0' cellspacing='0' border='0'>"
        for ( var z = 0; z < len; z++) {
            val_amt = ComAddComma2(parseFloat(fnNullToBlank(value2[z], '0.00'))+"", "#,###.00")
            html += "<tr>" + "  <td class='tr2_head3' width='12%' align='center'>" + value1[z] + "</td>" + "    <td class='input2' width='36%' align='right'>" + val_amt + "</td>" + "</tr>";
        }
        html += "</table></div>";
        obj.innerHTML = html;
    } catch (ex) {
        fnBkgErrorAlert('fnSetShowTable', ex);
    }
}

/**
 * fnClearSelect Combobox 초기화 이벤트 
 * param :_id 
 */
function fnClearSelect(_id) {
    try {
        var obj = eval("document.all." + _id);
        for ( var i = obj.length - 1; i >= 0; i--) {
            obj[i] = null; // 초기화
        }
    } catch (ex) {
        fnBkgErrorAlert('fnClearSelect', ex);
    }
}
/**
 * fnClearTextBox 테이블 초기화 이벤트 
 * param :_id
 */
function fnClearTextBox(_id) {
    try {
        var obj = eval("document.all." + _id);
        var html = "";
        obj.innerHTML = html;
    } catch (ex) {
        fnBkgErrorAlert('fnClearTextBox', ex);
    }
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */

function validateForm(sheetObj, formObj, sAction) {
     var bkgNo = formObj.bkg_no.value;
     switch(sAction) {
        case IBSEARCH:
            if(ComIsEmpty(formObj.frm_t10sheet1_bkg_no.value)&&ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
                //ComShowMessage(ComGetMsg("BKG00445"));
                ComSetFocus(formObj.frm_t10sheet1_bkg_no);
                return false;
            }
            
            ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t10sheet1_bkg_no));
            ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t10sheet1_bl_no));
            break;

        case IBSAVE:
            //입력 체크 - BKG no(10자리), B/L no(12자리) application_date 안될 경우 메시지 [BKG00445] 출력 후 focus 처리
            with (formObj) {
                if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){    // 조회없이 Booking 번호만 변경시
                    ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
                    ComSetFocus(formObj.bkg_no);
                    return false;                   
                }
                
                if(bkg_no.value == '' || bkg_no.value.length < 11){
                    if(tab_alert_msg){
                        ComShowCodeMessage("BKG00399");ComSetFocus(formObj.frm_t10sheet1_bkg_no);
                    }
                    return false;
                }
                if(ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
                    if(tab_alert_msg){
                        ComShowCodeMessage("BKG00400");ComSetFocus(formObj.frm_t10sheet1_bl_no);
                    }
                    
                    return false;
                }
                if(ComIsEmpty(formObj.frm_t10sheet1_rt_aply_dt.value) && 'B' != ComGetObjValue(formObj.rt_bl_tp_cd)){
                    if(tab_alert_msg){
                        ComShowCodeMessage("BKG08086");ComSetFocus(formObj.frm_t10sheet1_rt_aply_dt);
                    }
                    
                    return false;
                }
                if(ComGetObjValue(formObj.bkg_no)!= ComGetObjValue(formObj.frm_t10sheet1_bkg_no)
                 ||ComGetObjValue(formObj.bl_no)!= ComGetObjValue(formObj.frm_t10sheet1_bl_no)
                ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG01053"));
                    }
                    return false;
                }
                //At 정보가 없으면 저장할수 없다. 
                if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd).length == 0 || ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd).length == 0 ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG08067"));
                    }
                    return false;
                }
                
                if(ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd).length == 0 ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_p_t10sheet3_cnt_cd);
                    }
                    
                    return false;
                }
                if(ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq).length == 0 ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_p_t10sheet3_cust_seq);
                    }
                    
                    return false;
                }
                if(ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd).length == 0 ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_c_t10sheet3_cnt_cd);
                    }
                    
                    return false;
                }
                if(ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq).length == 0 ){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_c_t10sheet3_cust_seq);
                    }
                    
                    return false;
                }
                
                // 조건추가  OFC_CD validation 체크가 안되면 저장안됨. 
                if('N' == ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00905"));ComSetFocus(formObj.frm_c_t10sheet3_ofc_cd);
                    }
                    
                    return false;
                }
                if('N' == ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00905"));ComSetFocus(formObj.frm_p_t10sheet3_ofc_cd);
                    }
                    
                    return false;
                }
                // 조건추가  cust_seq , cust_code by 신자영 
                if('N' == ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_p_t10sheet3_cust_seq);
                    }
                    
                    return false;
                }
                if('N' == ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable)){
                    if(tab_alert_msg){
                        ComShowMessage(ComGetMsg("BKG00458"));
                        ComSetFocus(formObj.frm_c_t10sheet3_cust_seq);
                    }
                    
                    return false;
                }
                //2009.11.22 by 신자영  Covered B/L  추가 
                if(document.all.covered_id_c.style.display == 'block'){
                    if(ComGetObjValue(formObj.covered_name_c).length == 0){
                        
                        if(tab_alert_msg){
                            ComShowMessage(ComGetMsg("BKG08125"));
                            ComSetFocus(formObj.covered_name_c);
                        }
                        return false;
                    }
                }
                //2009.11.22 by 신자영  CO_BIZ B/L  추가 
                if(document.all.covered_id_b.style.display == 'block'){
                    //SG/AG입력 
                    if(!('SG'==ComGetObjValue(formObj.inrAuth2) || 'AG'==ComGetObjValue(formObj.inrAuth2) )){
                        if(tab_alert_msg){
                            ComShowCodeMessage("COM12193","SG/AG");ComSetFocus(formObj.inrAuth2);
                        }
                        return false;
                    }
                    if(ComGetObjValue(formObj.inrAuth3).length != 2){
                        if(tab_alert_msg){
                            ComShowCodeMessage("COM12193","INR Auth");ComSetFocus(formObj.inrAuth3);
                        }
                        return false;
                    }
                    if(ComGetObjValue(formObj.inrAuth5).length != 1){
                        if(tab_alert_msg){
                            ComShowCodeMessage("COM12193","INR Auth");ComSetFocus(formObj.inrAuth5);
                        }
                        return false;
                    }
                    if(ComGetObjValue(formObj.inrAuth6).length != 4){
                        if(tab_alert_msg){
                            ComShowCodeMessage("COM12193","INR Auth");ComSetFocus(formObj.inrAuth6);
                        }
                        return false;
                    }
                    
                    var cobiz_auth_no 
                    = ComGetObjValue(formObj.inrAuth1)
                    + ComGetObjValue(formObj.inrAuth2)
                    + ComGetObjValue(formObj.inrAuth3)
                    + ComGetObjValue(formObj.inrAuth4)
                    + ComGetObjValue(formObj.inrAuth5)
                    + ComGetObjValue(formObj.inrAuth6)
                    ;
                    
                    ComSetObjValue(formObj.frm_t10sheet1_cobiz_auth_no,cobiz_auth_no);                  
                }
                var sheetObj1 = sheetObjects[1];
                var cnt = sheetObj1.RowCount;
                // [AUTO RATING인경우] 저장하기 전에 모두 U상태로 변경
                if('Y' == ComGetObjValue(formObj.autoRate)){
                    for ( var r = 1; r <= cnt; r++) {
                        if(!sheetObj1.RowHidden(r) && "D" != sheetObj1.RowStatus(r) && "0" != sheetObj1.CellValue(r, prefix2 + "chg_ut_amt")){
                            sheetObj1.RowStatus(r)= "U";
                        }
                    }
                }
                // [3.삭제]
                for ( var ix = 1; ix <= cnt; ix++) {
                    var _type = sheetObj1.CellValue(ix, prefix2 + "ibflag");
                    if( _type != undefined){
                        if(sheetObj1.RowHidden(ix)){ 
                            if('D' != sheetObj1.CellValue(ix, prefix2 + "ibflag")){
                                sheetObj1.RowStatus(r)= "D";
                            }
                        }
                    }
                }
                var ObjCount = 0;
                for ( var ix = 1; ix <= cnt; ix++) {
                    if(!sheetObj1.RowHidden(ix)){ 
                        ObjCount++;
                    }
                }
                if(ObjCount>0){
                    if(fnDumyNotValidCheck()){
                        return false;
                    }
                }
                var sheetObj2 = sheetObjects[1];
                for ( var ix = 1; ix <= cnt; ix++) {
                    if('D' != sheetObj2.CellValue(ix, prefix2 + "ibflag")){
                        // minus rate를 입력 가능하게 변경(단, CN(POL) - PHMNL(POD) 운송의 경우만이며, OFT에만 해당함) (2018.03, by CMI/CTY-CS)
                        if(sheetObj2.CellValue(ix,prefix2 + "chg_cd") != 'FRB' && sheetObj2.CellValue(ix,prefix2 + "chg_amt") < 0) {
                            if( !( ComGetObjValue(formObj.frm_t10sheet1_pol_cd).substring(0,2) == "CN" && ComGetObjValue(formObj.frm_t10sheet1_pod_cd) == "PHMNL") ) {
                                ComShowCodeMessage("BKG02204");
                                return false;
                            } else {
                                if(sheetObj2.CellValue(ix,prefix2 + "chg_cd") != 'OFT') {
                                    ComShowCodeMessage("BKG02204");
                                    return false;    
                                }
                            }
                        }
                        
                        if(sheetObj2.CellValue(ix,prefix2 + "incl_oft_flg") == 'E'){
                            ComShowCodeMessage('BKG00388', sheetObj2.CellValue(ix,prefix2 + "chg_cd")+" : IN");
                            return false;
                        }
                    }
                }

                //por(pol)이 CA나 US인 경우만 하단의 로직을 실행 2011.11.10 kbj
                if(validateCRep(formObj)){
                    // c.ofc & c.rep 를 체크 2011.10.11 jsy
                    var sXml = sheetObj.GetSearchXml("ESM_BKG_1132GS.do?f_cmd="+SEARCH, "&bkg_no="+formObj.bkg_no.value+"&sc_no="+
                                                      formObj.frm_t10sheet1_sc_no1.value+"&ctrt_rep_cd="+formObj.ctrt_ofc_cd.value+formObj.ctrt_srep_cd.value+"&app_date="+formObj.application_date.value );
                    var CtrtRepCnt = ComGetEtcData(sXml, "CtrtRepCnt");
                    var compare_cd = ComGetEtcData(sXml, "compare_cd");
                    if( CtrtRepCnt > 1 && compare_cd == 'N') {
                        ComOpenPopup("ESM_BKG_1132.do?pgmNo=ESM_BKG_1132&sXml="+encodeURIComponent(sXml)+"&func=callBack1132", 500, 290, "callBack1132",    "1,0,1,1,1", true);
                    }
                    if( CtrtRepCnt == 1 && compare_cd == 'N') {
                        var cust_sls_ofc_cd = ComGetEtcData(sXml, "cust_sls_ofc_cd");
                        var cust_srep_cd = ComGetEtcData(sXml, "cust_srep_cd");
                        ComSetObjValue(formObj.ctrt_ofc_cd, cust_sls_ofc_cd);
                        ComSetObjValue(formObj.ctrt_srep_cd, cust_srep_cd);
                    }
//              if(ctrt_ofc_cd_old !=  ComGetObjValue(formObj.ctrt_ofc_cd) 
//                      || ctrt_srep_cd_old !=  ComGetObjValue(formObj.ctrt_srep_cd)) {
//                  ComSetObjValue(formObj.modify_flag, "Y");
//              }
                }
            }
            break;
    }
    return true;
    //return false;
}

/**
 * Combobox select 리스트 
 * @param vCombo  : SELECT 박스 위치 ID값
 * @param vCode  :  list 생성 목록 
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

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/

function obj_activate() {

    //입력Validation 확인하기
    switch (event.srcElement.name) {
        case "frm_t10sheet1_rt_aply_dt":
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

     
    // 입력Validation 확인하기
    switch (event.srcElement.name) {
        
        case "frm_t10sheet1_sc_no1":
            fnCheckTrf_itm_no();
            break;
        // case "frm_t10sheet1_sc_no2":
            // fnSetTrf_itm_no();
            // break;
        case "frm_t10sheet1_rt_aply_dt":
            ComAddSeparator(event.srcElement);
            if(ComIsDate(event.srcElement)){
                fnCheckNumber('sc_no',  ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
                fnCheckNumber('rfa_no', ComGetObjValue(formObj.frm_t10sheet1_rfa_no));
                fnCheckNumber('taa_no', ComGetObjValue(formObj.frm_t10sheet1_taa_no));  
            }
            break;
            
        case "frm_p_t10sheet3_ofc_cd":
            var r_val = fnOfcCdCheck(event.srcElement.value);
            if ("Y" != r_val) {
                event.srcElement.select(); 
                ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable, 'N');
            }else{
                ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable, 'Y');
            }
            break;
            
        case "frm_c_t10sheet3_ofc_cd":
            var r_val = fnOfcCdCheck(event.srcElement.value);
            if ("Y" != r_val) {
                event.srcElement.select(); 
                ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable, 'N');
            }else{
                ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable, 'Y');
            }
            break;
            
        case "frm_p_t10sheet3_cnt_cd":
            var cust_cnt_cd = ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
            var cust_seq = ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
            
            if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
                var r_val = fnCustSeqCheck(cust_cnt_cd,cust_seq);
                if ("N" != r_val) {
                    event.srcElement.select(); 
                    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'N');
                }else{
                    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'Y');
                }
            }
            break;
            
        case "frm_p_t10sheet3_cust_seq":
            var cust_cnt_cd = ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
            var cust_seq = ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
            
            if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
                var r_val = fnCustSeqCheck(cust_cnt_cd,cust_seq);
                if ("N" != r_val) {
                    event.srcElement.select(); 
                    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'N');
                }else{
                    ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'Y');
                }
            }
            break;
        case "frm_c_t10sheet3_cnt_cd":
            var cust_cnt_cd = ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
            var cust_seq = ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
            if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
                var r_val = fnCustSeqCheck(cust_cnt_cd,cust_seq);
                if ("N" != r_val) {
                    event.srcElement.select();
                    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'N');
                }else{
                    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'Y');
                }
            }
            break;
        
        case "frm_c_t10sheet3_cust_seq":
            var cust_cnt_cd = ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
            var cust_seq = ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
            if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
                var r_val = fnCustSeqCheck(cust_cnt_cd,cust_seq);
                if ("N" != r_val) {
                    event.srcElement.select();
                    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'N');
                }else{
                    ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'Y');
                }
            }
            break;
        
        case "frm_t10sheet1_rfa_no":
            var rfa_no = ComGetObjValue(formObj.frm_t10sheet1_rfa_no);  
            fnCozNotValidCheck();
            fnCheckNumber('rfa_no', rfa_no);
            break;
            
        case "frm_t10sheet1_taa_no":
            var taa_no = ComGetObjValue(formObj.frm_t10sheet1_taa_no) 
            fnCheckNumber('taa_no', taa_no);
            break;

        case "frm_t10sheet1_bkg_no":
        case "frm_t10sheet1_bl_no":
            var srcName = window.event.srcElement.getAttribute("name");
            var srcValue = window.event.srcElement.getAttribute("value");
            formObj.elements[srcName].value = srcValue.toUpperCase();
            break;
        default:
            break;
    }
}
 /**
 * fnCheckTrf_itm_no 값을 sheet 맨 첫번째 라인에 자동입력한다 
 * @param 
 * @return
 */
 function fnCheckTrf_itm_no() {
    var sheetObj = sheetObjects[1];
    var formObj = document.form;
    var sc_no = ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
    var cnt = sheetObj.RowCount;
    
    if(sc_no != ''){    
        //by 김태경 - 인경우 셋팅안함. 
        if(sc_no.indexOf("DUM") != -1 ){
            if (cnt != 0) {
                for ( var ix = 1; ix <= cnt; ix++) {
                    if (!sheetObj.RowHidden(ix)) {
                        var trf_itm_no = sheetObj.CellValue(ix, prefix2 + "trf_itm_no");
                        if(trf_itm_no.indexOf("DUM") != -1 ){
                            sheetObj.CellValue(ix, prefix2 + "trf_itm_no") = '';
                        }
                        break;
                    }
                }
            }
            return;
        }
        
        if(fnCheckNumber('sc_no', sc_no)){
            
        if('Y' != ComGetObjValue(formObj.sc_available)) return;
            if (cnt != 0) {
                for ( var ix = 1; ix <= cnt; ix++) {
                    // tariff item에 이미 tri no가 입력된 경우 sc no로 대체시키지 않음
                    if (!sheetObj.RowHidden(ix) && sheetObj.CellValue(ix, prefix2 + "trf_itm_no").length!=15) {
                        sheetObj.CellValue(ix, prefix2 + "trf_itm_no") = sc_no;
                        break;
                    }
                }
            }
        }
    }else{
        if (cnt != 0) {
            for ( var ix = 1; ix <= cnt; ix++) {
                if (!sheetObj.RowHidden(ix)) {
                    sheetObj.CellValue(ix, prefix2 + "trf_itm_no") = sc_no;
                    break;
                }
            }
        }
    }
 }

 /**
 * fnCheckNumber 함수 .<br>
 * @param fnName,r_Number
 */
 function fnCheckNumber(fnName,r_Number){
     //번호가 null이면 return
    if (ComIsEmpty(r_Number))  return false;

    var formObj = document.form;
    var r_input = 'frm_t10sheet1_';
    var r_Available = '';
        
    // 날짜 setting
    //ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));

    switch (fnName) {
        case "sc_no":
            if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 ){
                r_Available = 'Y';
                ComSetObjValue(formObj.sc_available,r_Available);
                r_input=r_input+'sc_no1';
                break;
            }
            // 날짜없으면 
/*          if (ComIsEmpty(ComGetObjValue(formObj.application_date))){
                r_Available = 'N';
                ComSetObjValue(formObj.sc_available,r_Available);
            }else{*/
                // 날짜가 없으면 return
                //if (!ComIsNumber(ComGetObjValue(formObj.application_date))) return;
                
                /* 입력되는 날짜로 계속 바꿔서  application_date 를 Parameter 로 전송함 2010.04.28 */
                ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
                formObj.f_cmd.value = SEARCHLIST13;
                var param = "f_cmd=" + SEARCHLIST13 
                            +"&bkg_no="+ComGetObjValue(formObj.bkg_no)
                            +"&page_type="+ComGetObjValue(formObj.page_type)
                            +"&application_date="+ComGetObjValue(formObj.application_date)
                            +"&ca_flg="+ComGetObjValue(formObj.caflag);
                var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+ r_Number, param);
                
                r_Available = ComGetEtcData(sXml,"sc_available");
                ComSetObjValue(formObj.sc_available,r_Available);// 저장 벨리데이션
                
                //[CHM-201432440] BKG main 화면의 S/C No. 빨간색 표기 요청 (customer code 불일치시)
                formObj.f_cmd.value = COMMAND10;//mds
                var param = "f_cmd="+COMMAND10
                            +"&bkg_no="+ComGetObjValue(formObj.bkg_no)
                            +"&sc_no="+r_Number
                            +"&page_type="+ComGetObjValue(formObj.page_type)
                            +"&application_date="+ComGetObjValue(formObj.application_date)
                            +"&ca_flg="+ComGetObjValue(formObj.caflag);
                sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", param);
                
                r_Available = ComGetEtcData(sXml,"sc_available");
                ComSetObjValue(formObj.sc_available_red,r_Available);// 빨간색 표기
            //}
            
            r_input=r_input+'sc_no1';
            break;

        case "rfa_no":
            if(formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 
             ||formObj.frm_t10sheet1_rfa_no.value.indexOf("COZ") != -1      
            ){
                r_Available = 'Y'
                ComSetObjValue(formObj.rfa_available,r_Available);
                r_input=r_input+'rfa_no';
                break;
            }
/*          if (ComIsEmpty(ComGetObjValue(formObj.application_date))){
                r_Available = 'N';
                ComSetObjValue(formObj.rfa_available,r_Available);
            }else{*/
                // 날짜가 없으면 return
                //if (!ComIsNumber(ComGetObjValue(formObj.application_date))) return;
                /* 입력되는 날짜로 계속 바꿔서  application_date 를 Parameter 로 전송함 2010.04.28 */
                ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
                formObj.f_cmd.value = SEARCHLIST12;
                var param = "f_cmd=" + SEARCHLIST12 
                    +"&bkg_no="+ComGetObjValue(formObj.bkg_no)
                    +"&page_type="+ComGetObjValue(formObj.page_type)
                    +"&application_date="+ComGetObjValue(formObj.application_date)
                    +"&ca_flg="+ComGetObjValue(formObj.caflag);
                
                var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+ r_Number, param);
                r_Available = ComGetEtcData(sXml,"rfa_available");
                ComSetObjValue(formObj.rfa_available,r_Available);
            //}
            r_input=r_input+'rfa_no';
            
            break;

        case "taa_no":
            if(formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1 ){
                r_Available = 'Y'
                ComSetObjValue(formObj.taa_available,'Y');
                r_input=r_input+'taa_no';
                break;
            }
/*          if (ComIsEmpty(ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt))){
                r_Available = 'N';
                ComSetObjValue(formObj.taa_available,r_Available);
            }else{*/
                
                // 날짜가 없으면 return
                //if (!ComIsNumber(ComGetObjValue(formObj.application_date))) return;
                /* 입력되는 날짜로 계속 바꿔서  application_date 를 Parameter 로 전송함 2010.04.28 */
                ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
                formObj.f_cmd.value = SEARCH06;
                var param = "f_cmd=" + SEARCH06 
                    +"&bkg_no="+ComGetObjValue(formObj.bkg_no)
                    +"&taa_no="+ComGetObjValue(formObj.frm_t10sheet1_taa_no)
                    +"&page_type="+ComGetObjValue(formObj.page_type)
                    +"&application_date="+ComGetObjValue(formObj.application_date)
                    +"&ca_flg="+ComGetObjValue(formObj.caflag);
                
                var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+ r_Number, param);
                r_Available = ComGetEtcData(sXml,"taa_available");
                ComSetObjValue(formObj.taa_available,r_Available);
            //}
            r_input=r_input+'taa_no';
            break;

    } // end switch

    if('Y' == r_Available){
        changeObjectColor('', '', r_input , "", "input");// 사용가능
    }else{
        changeObjectColor('', '', r_input , "red", "input"); // 사용불능
    }
    
    return true;
 }
 /**
 * fnCustSeqCheck  
 * ofc_cd 유효성 체크
 * @param 
 * @return
 */
 function fnCustSeqCheck(cust_cnt_cd,cust_seq) {
    var sheetObj = sheetObjects[3];
    var input_text = cust_cnt_cd +"|"+ cust_seq;
    var param = param + "&f_cmd=" + SEARCHLIST20 + "&input_text=" + input_text;

    if(!ComIsNumber(cust_seq) && cust_seq.length != 0 ){
        ComShowCodeMessage("BKG00458"); // invalid customer code
    }else{
        var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
        var output_text = ComGetEtcData(sXml, "output_text");
        
//      if ('Y' == output_text) {
//          //ComShowCodeMessage("BKG00458"); // invalid customer code
//      }
    return output_text;
    }
 }
 /**
 * fnAutoRatingRFACheck  
 * AutoratingRfa 유효성 체크
 * @param v_bkg_no 
 * @return boolean
 */
 function fnAutoRatingRFACheck(v_bkg_no) {
    var sheetObj = sheetObjects[3];
    var input_text = v_bkg_no;
    var param = param + "&f_cmd=" + SEARCH04 + "&input_text=" + input_text;
    var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
    var output_text = ComGetEtcData(sXml, "output_text");
    // 'N'일 경우 autorating을 수행; 
    if ('N' == output_text) {
        return false ;
    }else{
        ComShowCodeMessage("BKG08156"); 
        return true;
    }
 }
 /**
 * fnAutoratingRfaAvailable  
 * AutoratingRfa 유효성 체크
 * @param v_bkg_no 
 * @param v_rfa_no 
 * @param v_date
 * @return boolean
 */
 function fnAutoratingRfaAvailable(v_bkg_no ,v_rfa_no,v_date,v_ca_flg) {
    var sheetObj = sheetObjects[3];
    var input_text = v_bkg_no +"|"+ v_rfa_no+"|"+ v_date+"|"+v_ca_flg;
    var param = param + "&f_cmd=" + COMMAND04 + "&input_text=" + input_text;
    var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
    var output_text = ComGetEtcData(sXml, "output_text");

    // 0739 오픈전에 아래의 쿼리에서 Y 일경우 Skip N일경우 팝업을 띄워준다
    // "The customer codes are unmatched btwn BKG and RFA. please check
    // itagain."
    if ('N' == output_text) {
        ComShowCodeMessage("BKG08104"); 
        return false;// popup open~
    }else{
        return true; 
    }
 }
 /**
 * fnAutoratingScAvailable  
 * AutoratingSc 유효성 체크
 * @param v_bkg_no 
 * @param v_sc_no 
 * @param v_date
 * @return boolean
 */
 function fnAutoratingScAvailable(v_bkg_no ,v_sc_no,v_date,v_ca_flg) {
    var sheetObj = sheetObjects[3];
    var input_text = v_bkg_no +"|"+ v_sc_no+"|"+ v_date+"|"+v_ca_flg;
    var param = param + "&f_cmd=" + COMMAND05 + "&input_text=" + input_text;
    var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
    var output_text = ComGetEtcData(sXml, "output_text");
    
    // 0269 오픈전에 아래의 쿼리에서 Y 일경우 Skip N일경우 팝업을 띄워준다
    if ('N' == output_text) {
        if (ComShowConfirm(ComGetMsg("BKG08105"))){
            return true;// popup open~
        }
        else {
            return false;
        }
    }
    else {
        return true;
    }
 }
 /**
 * fnAutoratingTaaAvailable  
 * 1076오픈전에 아래의 쿼리에서 Y 일 경우 Skip N일 경우 팝업을 띄워준다
 * @param v_bkg_no,v_taa_no,v_date
 * @return boolean
 */
 function fnAutoratingTaaAvailable(v_bkg_no,v_taa_no,v_date,v_ca_flg){

     var sheetObj = sheetObjects[3];
     var input_text = v_bkg_no +"|"+ v_taa_no+"|"+ v_date+"|"+v_ca_flg;
     var param = param + "&f_cmd=" + COMMAND06 + "&input_text=" + input_text;
     var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
     var output_text = ComGetEtcData(sXml, "output_text");
     
     if('N' == output_text){
        ComShowCodeMessage("BKG08123");
        return false;// popup open~
    }else{
        return true; 
    }
 }
 
 /**
  * fnOfcCdCheck  
  * ofc_cd 유효성 체크
  * @param v_ofc_cd
  * @return output_text
  */
 function fnOfcCdCheck(v_ofc_cd) {
     var sheetObj = sheetObjects[3];
     var param = param + "&f_cmd=" + SEARCHLIST19 + "&input_text=" + v_ofc_cd;
     var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
     var output_text = ComGetEtcData(sXml, "output_text");
     if ('Y' != output_text) {
        //ComShowCodeMessage("BKG00905"); // Third Office is not available
     }
     return output_text;
 }
  /**
   * fnRepCustomer  
   * REP_CUST_CNT_CD, REP_CUST_SEQ  데이터값 가져오기
   * @param v_ofc_cd
   * @return output_text
   */
  function fnRepCustomer(sheetObj,Row,v_ofc_cd){

     var param = param + "&f_cmd=" + COMMAND07 + "&input_text=" + v_ofc_cd;
     var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
     var output_text = ComGetEtcData(sXml, "output_text");
     var len = output_text.length;
     if (len != 0){
        var value1 = output_text.split("|"); 
        sheetObj.CellValue(Row, prefix2 + "n3pty_cust_cnt_cd")  = value1[0];
        sheetObj.CellValue(Row, prefix2 + "n3pty_cust_seq")     = value1[1];
     }
  }

/**
 * fnBkgJsMap  
 * javascript Array로 구현한 Map
 */
function fnBkgJsMap() { 
    this._array = new Array();// Map배열
    this.pointer = 0;
    this._getIndexByKey = function(key) {
        for ( var i = 0; i < this._array.length; i++) {
            if (key == this._array[i][0]) {
                return i;
            }
        }
        return -1;
    }
    this.put = function(key, value) {
        var index = this._getIndexByKey(key)

        if (index == -1) {
            var newArray = new Array();// key와value를 담는 배열
            newArray[0] = key;
            newArray[1] = value;
            this._array[this._array.length] = newArray;
        } else {
            this._array[index][1] = value;
        }
    }
    this.get = function(key) {

        for ( var i = 0; i < this._array.length; i++) {
            if (this._array[i][0] == key)
                return this._array[i][1];
        }
    }
    this.containsKey = function(key) {
        for ( var i = 0; i < this._array.length; i++) {
            if (this._array[i][0] == key)
                return true;
        }
        return false;
    }
    this.isNext = function() {
        var result;
        if (this._array.length > this.pointer) {
            result = true;
        } else {
            result = false;
        }
        this.pointer++;
        return result;
    }
    this.getKeyString = function(_type) {
        var _result = '';
        if (_type == null)
            _type = '|';
        for ( var i = 0; i < this._array.length; i++) {
            _result = _result + _type + this._array[i][1].charge;
        }
        return _result;
    }
    this.getTextString = function(_type) {
        var _result = '';
        if (_type == null)
            _type = '|';
        for ( var i = 0; i < this._array.length; i++) {
            _result = _result + _type + this._array[i][0];
        }
        return _result;
    }   
    this.size = function() {
        return this._array.length;
    }
    this.nowKey = function() {
        return this._array[this.pointer - 1][0];
    }
    this.nowValue = function() {
        return this._array[this.pointer - 1][1];
    }
}
 /**
 * check_Enter  
 * 조회조건 에터키 이력시 조회
 * @param 
 * @return 
 */
function check_Enter() {
    var formObj = document.form;
    var srcName = window.event.srcElement.getAttribute("name");
    var srcValue = window.event.srcElement.getAttribute("value");
    if (event.keyCode == 13) {
        if(event.srcElement.name == "frm_t10sheet1_bkg_no" || event.srcElement.name == "frm_t10sheet1_bl_no"){
            fnClearForm();
            fnClearSelect('svc_scp_cd');// Service Scope
            formObj.elements[srcName].value = srcValue.toUpperCase();
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
}
/**
 * fnBkgErrorAlert  
 * 에러 
 * @param 
 * @return 
 */
function fnBkgErrorAlert(msg, ex) {
    ComShowMessage('[ ' + msg + ' ] \n [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
/**
* fnExceptionMessage  
* 에러처리 메세지 
* @param 
* @return 
*/
function fnExceptionMessage(rXml){
    var rMsg = ComGetEtcData(rXml,"Exception")
    var rmsg = rMsg.split("<||>");
    if(rmsg[3] != undefined && rmsg[3].length > 0) {
        ComShowMessage(rmsg[3]);
    }else{
        sheetObjects[0].LoadSaveXml(rXml);
    }
}
/**
* getCntrQtyByType  
* Charge 화면에서 Cntr 정보를 Hidden으로 가지고 있고 Vol.difference 시 넘겨준다 
* @param 
* @return 
*/
function getCntrQtyByType(cntrTpsz){
    var sheetObj = sheetObjects[5];
    var tpSzs = null;
    var dry_cgo_flg = 0;
    var dcgo_flg    = 0;
    var rc_flg      = 0;
    var awk_cgo_flg = 0;
    var bb_cgo_flg  = 0;
    var hngr_flg    = 0;
    var soc_flg     = 0;
    var rcv_term_y  = 0;
    var rcv_term_d  = 0;
    var rcv_term_s  = 0;
    var rcv_term_t  = 0;
    var rcv_term_i  = 0;
    var de_term_y   = 0;
    var de_term_d   = 0;
    var de_term_s   = 0;
    var de_term_t   = 0;
    var de_term_o   = 0;
    var op_cntr_qty = 0;

    tpSzs = ComFindText(sheetObj, prefix6 + "cntr_tpsz_cd", cntrTpsz);
    if(tpSzs != null && tpSzs.length > 0){
        for(idx=0;idx<tpSzs.length;idx++){
            // values
            var vol = ComIsEmpty(sheetObj.CellValue(tpSzs[idx],prefix6 + "cntr_vol_qty")) ? 0 : parseFloat(sheetObj.CellValue(tpSzs[idx],prefix6 + "cntr_vol_qty"));
            var rterm = sheetObj.CellValue(tpSzs[idx],prefix6 + "rcv_term_cd");
            var dterm = sheetObj.CellValue(tpSzs[idx],prefix6 + "de_term_cd");
            // special cargo
            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 1) dcgo_flg += vol;
            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "rc_flg") == 1) rc_flg += vol;
            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 1) awk_cgo_flg += vol;
            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 1) bb_cgo_flg += vol;
            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "hngr_flg") == 1) hngr_flg += vol;
            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "soc_flg") == 1) soc_flg += vol;
            
            // dry cargo

            if(sheetObj.CellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 0 && 
                sheetObj.CellValue(tpSzs[idx],prefix6 + "rc_flg") == 0 && 
                sheetObj.CellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 0 && 
                sheetObj.CellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 0){
                dry_cgo_flg += vol;
            }
    
            // receive term / delivery term
            if(rterm == 'Y') rcv_term_y  += vol;
            if(rterm == 'D') rcv_term_d  += vol;
            if(rterm == 'S') rcv_term_s  += vol;
            if(rterm == 'T') rcv_term_t  += vol;
            if(rterm == 'I') rcv_term_i  += vol;
            if(dterm == 'Y') de_term_y  += vol;
            if(dterm == 'D') de_term_d  += vol;
            if(dterm == 'S') de_term_s  += vol;
            if(dterm == 'T') de_term_t  += vol;
            if(dterm == 'O') de_term_o  += vol;

            // total volumn
            op_cntr_qty += vol;
        }
    }
    if(cntrTpsz == 'D4' && document.form.flex_hgt_flg.value == 'Y'){
        tpSzs = ComFindText(sheetObj, "cntr_tpsz_cd", "D5");
        if(tpSzs != null && tpSzs.length > 0) {
            for(idx=0;idx<tpSzs.length;idx++){
                // values
                var vol = ComIsEmpty(sheetObj.CellValue(tpSzs[idx],prefix6 + "cntr_vol_qty")) ? 0 : parseFloat(sheetObj.CellValue(tpSzs[idx],prefix6 + "cntr_vol_qty"));
                var rterm = sheetObj.CellValue(tpSzs[idx],prefix6 + "rcv_term_cd");
                var dterm = sheetObj.CellValue(tpSzs[idx],prefix6 + "de_term_cd");
    
                // special cargo
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 1) dcgo_flg += vol;
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "rc_flg") == 1) rc_flg += vol;
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 1) awk_cgo_flg += vol;
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 1) bb_cgo_flg += vol;
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "hngr_flg") == 1) hngr_flg += vol;
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "soc_flg") == 1) soc_flg += vol;
                
                // dry cargo
                if(sheetObj.CellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 0 && 
                    sheetObj.CellValue(tpSzs[idx],prefix6 + "rc_flg") == 0 && 
                    sheetObj.CellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 0 && 
                    sheetObj.CellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 0){
                    dry_cgo_flg += vol;
                }
    
                // receive term / delivery term
                if(rterm == 'Y') rcv_term_y  += vol;
                if(rterm == 'D') rcv_term_d  += vol;
                if(rterm == 'S') rcv_term_s  += vol;
                if(rterm == 'T') rcv_term_t  += vol;
                if(rterm == 'I') rcv_term_i  += vol;
                if(dterm == 'Y') de_term_y  += vol;
                if(dterm == 'D') de_term_d  += vol;
                if(dterm == 'S') de_term_s  += vol;
                if(dterm == 'T') de_term_t  += vol;
                if(dterm == 'O') de_term_o  += vol;
    
                // total volumn
                op_cntr_qty += vol;
            }
        }
    }
    // return array
    var cntrQtyArr = new Array();
    cntrQtyArr[0] = cntrTpsz;
    cntrQtyArr[1] = "Difference";
    cntrQtyArr[2] = dry_cgo_flg;
    cntrQtyArr[3] = dcgo_flg;
    cntrQtyArr[4] = rc_flg;
    cntrQtyArr[5] = awk_cgo_flg;
    cntrQtyArr[6] = bb_cgo_flg;
    cntrQtyArr[7] = hngr_flg;
    cntrQtyArr[8] = soc_flg;
    cntrQtyArr[9] = rcv_term_y;
    cntrQtyArr[10] = rcv_term_d;
    cntrQtyArr[11] = rcv_term_s;
    cntrQtyArr[12] = rcv_term_t;
    cntrQtyArr[13] = rcv_term_i;
    cntrQtyArr[14] = de_term_y;
    cntrQtyArr[15] = de_term_d;
    cntrQtyArr[16] = de_term_s;
    cntrQtyArr[17] = de_term_t;
    cntrQtyArr[18] = de_term_o;
    cntrQtyArr[19] = op_cntr_qty;
    return cntrQtyArr;
}
/**
* checkModify: 탭이동시 저장여부
* param : 
* 0079에서 실행
*/
function checkModify(){ 
    var formObj  = document.form;
    if(ComGetObjValue(formObj.isInquiry) == "Y") return;
    
    if(ComGetObjValue(formObj.caflag) == "Y")return;
    // by 김태경
    if(fnModifyCheckAfter()){
        if(ComGetObjValue(formObj.modify_flag) == "Y"){
            
            if (!ComShowConfirm(ComGetMsg("BKG00350")))
                return false; // Are you sure to save the changes?
            
            tab_alert_msg = false;
            doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
        }
    }
}
/**
* searchData : 탭이동시 검색수행
* bkgNo : 
* 0079에서 실행
*/
function searchData(bkgNo){
    var formObj  = document.form;
    var sheetObj = sheetObjects[0];
    ComSetObjValue(formObj.frm_t10sheet1_bkg_no ,bkgNo);
    doActionIBSheet(sheetObj, formObj, IBSEARCH);
}
/**
* setInquiryDisableButton 이벤트 호출 .<br>
* ComBtnDisable 을 했을경우 비활성화
* @param 
*/
function setInquiryDisableButton(){
    ComBtnDisable("btn_t10save");
    ComBtnDisable("btn_t10cntr_rate");
    ComBtnDisable("btn_t10auto_rating");
    ComBtnDisable("btn_t10exchange_rating");
    ComBtnDisable("btn_t10clear");
    ComBtnDisable("btn_t10remark");
    ComBtnDisable("btn_t10self");
    ComBtnDisable("btn_t10tpb_link");
    ComEnableObject(document.form.pop_rfa_no, false);
    ComEnableObject(document.form.pop_sc_no, false);
    ComEnableObject(document.form.pop_tta_no, false);
}

/*
 * searchCovered B/L 일 경우 Charge 화면에서 
 * Application Date 를 공백으로 처리 하고 Save 할수 있도록 
 * 메시지를 띄워 유도 한다
 * 데이터가 없으면 N return 
 */
function fnSearchRtAplyDateCheck(){

    var formObj = document.form;
    var v_bkg_no = ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
    
    // 1.validation
    if ('' == v_bkg_no ) return;
    var input_text = v_bkg_no;
    
    // 2.search
    var param = param+ "&f_cmd=" + SEARCH07 + "&input_text=" + input_text;
    var sXml = sheetObjects[1].GetSearchXml("ESM_Booking_UtilGS.do", param);
    var output_text = ComGetEtcData(sXml,"output_text");
    
    if('N' == output_text && 'C' == ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd)) {
         ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt ,'');
         ComShowCodeMessage("BKG08178");         
    }
}

function selfRetrieve() {
    document.getElementById("btn_t10retrieve").fireEvent("onclick");
}

/*********************************
        [CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가
        ITS/방지경 대리 요청으로 추후 반영
function chargeAmendRequest() {
    var formObj = document.form;
    var _Width = '449';
    var _Height = '560';
    var pgmNo = "&pgmNo=ESM_BKG_1600";
    var param = "bkg_no="+ComGetObjValue(formObj.bkg_no);
    var url = "ESM_BKG_1600.do?" + param + pgmNo;
    ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
************************************/

function viewAppDtMsg() {
    if(volDiffFlg == 'Y' && ComGetObjValue(document.form.frm_t10sheet1_rt_aply_dt).length == 0){
        ComShowCodeMessage("BKG08187");
        document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = 'red';
    } else {
        if(volDiffFlg == 'Y') {
            document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = 'red';
        }else {
            document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = '';
        }
    }
}
function setTxtColor() {
    if(volDiffFlg == 'Y') {
        document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = 'red';
    }else {
        document.getElementById('frm_t10sheet1_rt_aply_dt').style.color = '';
    }
}

function containsFrtTermCd() {
    var obj = document.getElementById("frt_term_cd");
    if (obj && ComIsEmpty(obj.Code)) {
        ComShowCodeMessage("BKG01153");
        var formObj = document.form;
        var tempVal = ComGetObjValue(formObj.f_cmd);
        ComSetObjValue(formObj.f_cmd,"");
        var sXml = sheetObjects[0].GetSearchXml(URL_ESM_BKG, FormQueryString(formObj));
        var arrXml = sXml.split("|$$|");
        if (arrXml.length > 1){
            ComBkgXml2ComboItem(arrXml[1], formObj.frt_term_cd, "val", "name");
            if (!ComIsEmpty(sheetObjects[0].CellValue(1,prefix1+"frt_term_cd"))) {
                obj.Code2 = sheetObjects[0].CellValue(1,prefix1+"frt_term_cd");
            }
        }
        ComSetObjValue(formObj.f_cmd,tempVal);
        return false;
    }
    return true;
}

function validatePriPopUp(ctrtType, ctrtNo, applicationDate){
    var formObj = document.form;
    
    // 1. 계약 넘버 && application date 둘다 없을 시 팝업 연결 안함
    if(ctrtNo == '' && applicationDate == ''){
        return false;
    }
    // 2. 계약 넘버 있을시 
    if(ctrtNo !=''){
        // 2-1.Dummy Check
        if(ctrtNo.indexOf("DUM") != -1){
            ComShowCodeMessage("BKG08205");//"There is no contract no. please check it again."
            return false;
        }
        
        //2-2.Application Date Check
        if(applicationDate ==''){
            ComShowCodeMessage("BKG08086"); // "Please input Application Date"
            ComSetFocus(formObj.frm_t10sheet1_rt_aply_dt);
            return false;
        }
        // 2-3. 계약 넘버 && application date 둘다 있지만 amdt_seq 없는 경우
        if(ctrtNo !='' && applicationDate !=''){
            var param = param + "&f_cmd=" + SEARCH02 + "&ctrtType=" + ctrtType+"&ctrtNo=" + ctrtNo+"&applicationDate=" + applicationDate ;
            var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_08GS.do", param);
            
            ctrt_amdt_seq = ComGetEtcData(sXml, "amdt_seq");
            
            if(ctrt_amdt_seq == '' || ctrt_amdt_seq == null || ctrt_amdt_seq == 'null' || ctrt_amdt_seq == undefined || ctrt_amdt_seq == 'undefined'){
                ComShowCodeMessage("BKG08204");//"The duration in contract does not matched with booking. please check application date.";
                return false;
            }
        }
        return true;
    }
    return false;
}

    function callBack1132(arrVal){
        var formObj = document.form;
        if(arrVal != null){     
            ComSetObjValue(formObj.ctrt_ofc_cd, arrVal[0][1]);
            ComSetObjValue(formObj.ctrt_srep_cd, arrVal[0][2]);
//          if(ctrt_ofc_cd_old !=  ComGetObjValue(formObj.ctrt_ofc_cd) 
//                  || ctrt_srep_cd_old !=  ComGetObjValue(formObj.ctrt_srep_cd)) {
//              ComSetObjValue(formObj.modify_flag, "Y");
//          }
        }
    }
    
    

    /**
    *  C.OFC/Rep.validation <br>
    * @param formObj
    * @return boolean 
    * @author 금병주
    * @version 2011.11.10
    */
    function validateCRep(formObj){
        var falg = false; 
        var porCd       = ComGetObjValue(formObj.frm_t10sheet1_por_cd);
        var polCd       = ComGetObjValue(formObj.frm_t10sheet1_pol_cd);
        flag = ( porCd.substring(0,2) == 'CA' || porCd.substring(0,2) == 'US' ||
                polCd.substring(0,2) == 'CA' || polCd.substring(0,2) == 'US' );
        return flag;
    }
    
    function t10sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){

        if(KeyCode == 40){
            //OFT Inlcuding charge/surcharge 선택시 Row Delete 버튼을 비활성화 
            var inclFlg = sheetObj.CellValue(Row + 1, prefix2 + "incl_oft_flg"); // 기준
            if(inclFlg == 'I'){
                ComBtnDisable("btn_t10del");
            }else 
                ComBtnEnable("btn_t10del");
        }else if(KeyCode == 38){
            var inclFlg = sheetObj.CellValue(Row - 1, prefix2 + "incl_oft_flg"); // 기준
            if(inclFlg != 'I'){
                ComBtnEnable("btn_t10del");
            }
        }
        
    }
    
     /**
     * fnRfaSpotPricingAvailable  
     * SpotPricingRfa 유효성 체크
     * @param v_bkg_no 
     * @param v_rfa_no 
     * @param v_date
     * @return boolean
     */
     function fnRfaSpotPricingAvailable(v_bkg_no ,v_rfa_no,v_date) {
        var sheetObj = sheetObjects[3];
        var input_text = v_bkg_no +"|"+ v_rfa_no+"|"+ v_date;
        var param = param + "&f_cmd=" + COMMAND11 + "&input_text=" + input_text;
        var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
        var output_text = ComGetEtcData(sXml, "output_text");

        // Spot Pricing 계약의 경우 Proposal Office와 Load Office가 일치하면 저장 허용, 아니면 Check 메세지 보여줌
        if ('N' == output_text) {
            return false;
        }else{
            return true; 
        }
     }
     
     /**
      * fn3rdBLReqButtonColor 이벤트 호출 .<br>
      * 3rd Party B/L Billing & Issue Request 승인되면 파란색, 거절되면 붉은색
      * @param _val
      */
     function fn3rdBLReqButtonColor() {
        
        var formObj = document.form;
        var sheetObj = sheetObjects[3];
        var loginOfcCd = ComGetObjValue(formObj.login_ofc_cd);
        var bkg_no = bkg_no = ComGetObjValue(formObj.bkg_no);
        var input_text = input_text = bkg_no +"|"+ loginOfcCd;      
        var param = param + "&f_cmd=" + COMMAND12 + "&input_text=" + input_text;
        var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
        var output_text = output_text = ComGetEtcData(sXml, "output_text");

        // 3rd Party B/L Billing & Issue Request 승인되면 파란색, 거절되면 붉은색
//      if ('Y' == output_text) {

            var input_text1 = bkg_no;
            var param1 = param1 + "&f_cmd=" + COMMAND13 + "&input_text=" + input_text1;
            var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param1);
            var output_text1 = ComGetEtcData(sXml, "output_text");
            
            if ('A' == output_text1) {
                document.getElementById('btn_t103rdBLReq').style.color = 'blue';
            } else if ('X' == output_text1) {
                document.getElementById('btn_t103rdBLReq').style.color = 'red';
            } else if ('R' == output_text1) {
                document.getElementById('btn_t103rdBLReq').style.color = 'gold';
            } else {
                document.getElementById('btn_t103rdBLReq').style.color = 'black';
            }

            ComBtnEnable("btn_t103rdBLReq");
            
//      }else{

//          document.getElementById('btn_t103rdBLReq').style.color = 'black';  //lightgrey
//          ComBtnEnable("btn_t103rdBLReq");
//          ComBtnDisable("btn_t103rdBLReq");
//      }
     }
/* 2010.02.28 버전관리 */
/* 2010.02.16 버전관리 */
/* 개발자 작업 끝 */