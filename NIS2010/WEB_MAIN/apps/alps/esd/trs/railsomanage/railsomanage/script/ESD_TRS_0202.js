/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0201.js
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 최 선
*@LastVersion : 1.4
* 2006.11.23 
* 1.0 최초 생성
*----------------------------------------------------------
* History
* N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
* S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
* N200907240070 2009-09-29 미주 Rail Billing CA 지역 Rail Billing Block 적용 보완
* 2011.03.15 최 선   1.4 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
* 2014.10.20 신동일[CHM-201432366]No rate BKG에 대한 S/O Creation 미허용 로직
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0202 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0202() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수  */
//var calPop = new ComCalendarGrid();
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0; //SHEET를 늘렸다가 줄였다가.
var docObjsep = "O";

var R = 222;
var G = 251;
var B = 248;

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
    
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	document.all.bkgdtl.style.visibility = "hidden" ;

	if(s_cntr_no != undefined && s_cntr_no != ''){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		formObject.bkg_no.value = s_bkg_no;
		formObject.cntr_no.value = s_cntr_no;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
		}
	}
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
				style.height = GetSheetHeight(13); // 높이 설정
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(82, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "S|STS|Container\nNumber|Type\nSize|POR|POR|Rail ORG|Rail ORG|InterchangeⅠ|InterchangeⅠ|InterchangeⅡ|InterchangeⅡ|Rail DEST|Rail DEST|POL|POL|Booking No|Term|BKG\nCargo Type|BKG\nSPE|CNTR\nSPE|Seal No|Weight\n(LBS)|VGM|No of\nPKG|PKG\nCode|STCC|Commodity\nDescription|Reference No|Route\nPlan|Trunk\nVVD|Lane|AES No|AES No|Request S/P|Verify\nResult|Planned Time|Planned Time|Planned Time|Planned Time|Internal\nRemark|Remark\n(Special Instruction)|BKG\nStatus" ;
				var HeadTitle2 = "S|STS|Container\nNumber|Type\nSize|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Booking No|Term|BKG\nCargo Type|BKG\nSPE|CNTR\nSPE|Seal No|Weight\n(LBS)|VGM|No of\nPKG|PKG\nCode|STCC|Commodity\nDescription|Reference No|Route\nPlan|Trunk\nVVD|Lane|||Request S/P|Verify\nResult|From Departure|From Departure|To Arrival|To Arrival|Internal\nRemark|Remark\n(Special Instruction)|BKG\nStatus" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				//InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "por_cd", false, "", dfNone, 0, false, false);
				//InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "por_cd_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "por_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "por_nod_cd_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "fm_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "interchange1_loc", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "interchange1_nod", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "interchange2_loc", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "interchange2_nod", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "to_nod_yard", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "pol_cd_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone,0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup, 50, daCenter, true, "bkg_spe", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "spcl_cgo_cntr_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cntr_seal_no", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 80, daRight, true, "cntr_wgt", false, "", dfNullFloat, 3,true, true);
				InitDataProperty(0, cnt++, dtData, 80, daRight, true, "vgm_wgt", false, "", dfNullFloat, 3,true, true);
				InitDataProperty(0, cnt++, dtData, 50, daRight, true, "pck_qty", false, "", dfNullInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo,60, daCenter, true, "pck_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "stnd_cmdt_no", false, "", dfNone, 0, true, true, 8);
				InitDataProperty(0, cnt++, dtData,100, daLeft, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 135, daCenter, true, "ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_pln_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "trunkvvd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "slan_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "auto_xpt_sys_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "auto_xpt_sys_no", false, "", dfNone, 0, true, true, 15);
				InitDataProperty(0, cnt++, dtPopup,80, daCenter, true, "request_sp", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "verify_result", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "n1st_nod_pln_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "n1st_nod_pln_dt_hms", false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "lst_nod_pln_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "lst_nod_pln_dt_hms", false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "inter_rmk", false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "spcl_instr_rmk", false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData, 40,  daCenter, true, "non_rt_sts_cd", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "rail_cmb_thru_tp_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "so_cre_yn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "act_grp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rout_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rout_org_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rout_dest_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "inlnd_rout_rmk", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "del_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "del_nod_cd_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "pod_cd_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "del_scc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rout_dtl_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ibd_ipi_locl_ind_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_cost_dtl_mod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cust_seq", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "sc_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "por_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "del_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "inv_bil_patt_div_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rtr_div_cnt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rail_rcv_coff_fm_dt_min_global", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rail_rcv_coff_to_dt_min_global", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rail_rcv_coff_fm_dt", false, "",  dfDateYmd, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "org_fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "org_fm_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "org_to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "org_to_nod_yard", false, "", dfNone, 0, false, false);
				

				RangeBackColor(1, 30, 1, 33) = RgbColor(222, 251, 248);   // ENIS

				InitDataCombo(0, 'auto_xpt_sys_cd', auto_xpt_sys_cdText, auto_xpt_sys_cdCode);
				InitDataCombo(0, 'pck_tp_cd', pck_tp_cdText, pck_tp_cdCode);

				HeadRowHeight = 25 ;
			}
		break;


		case 2:      //sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(6); // 높이 설정
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "S|BKG No|BKG CNTR No|COP CNTR No|TP/SZ|S/O No|Rail ORG|Rail Dest|Rail Road|404 EDI Sent Time" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "bkg_no", false, "", dfNone,0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bkg_cntr_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cop_cntr_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "so_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rail_org", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rail_dest", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rail_road", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "edi_sent_time", false, "", dfNone, 0, false, false);

				RangeBackColor(1, 30, 1, 33) = RgbColor(222, 251, 248);   // ENIS

				HeadRowHeight = 25 ;
			}
		break;
	

		case 3:      //sheet1 init
			with (sheetObj) {
				style.height = 0; // 높이 설정
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(4, 5, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				InitDataProperty(0, cnt++, dtData,60, daCenter, true, "sep", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,600, daCenter, true, "verify_result", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,90, daCenter, true, "verify_yn", false, "", dfNone, 0, false, false);
			}
		break;
	
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
				}
			break;

			case "btn_reset":
				formObject.reset();
				formObject.frm_yard.RemoveAll(); // combo 데이터삭제
				formObject.to_yard.RemoveAll(); // combo 데이터삭제
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
			break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;

			case "btng_verify":
				if( searchValidation(sheetObject, formObject, "chk1") ) {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "02");
				}
			break;

			case "btng_irgadjust":
				doActionPopupOpen(sheetObject, formObject);
			break;

			case "btng_socreation":
				if( validateForm(sheetObject, formObject ) ) {
				    
					doActionIBSheet(sheetObject, formObject, IBINSERT, "");
				}
			break;

			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;

			case "btns_pornode": //PorNode Popup창
				openHireYardPopup('getPorNode');
			break;

			case "btns_polnode": //PorNode Popup창
				openPolYardPopup('getPolNode');
			break;

			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;

			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;

			case "btns_multivvd": //M Trunk VVD
				openMultipleinquiry('VVD', 'T.VVD');
			break;

			case "btns_calendar":
				getCalendar();
			break;

			case "btns_tvvd": //Trunk VVD Popup창
				openTVVDPopup();
			break;

			case "bkg_dtl_upper":
				reSize( 0 );
			break;

			case "bkg_dtl_downer":
				reSize( 1 );
			break;


		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction,obj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:	  //조회
			if( obj == "01" ) {  // MAIN 시트 조회
				formObj.f_cmd.value = SEARCH06;
				sheetObj.DoSearch4Post("ESD_TRS_0202GS.do", TrsFrmQryString(formObj));
			} else if( obj == "02" ) {  // S/O Verify 조회
				formObj.f_cmd.value = SEARCH07;
				sheetObj.DoSearch4Post("ESD_TRS_0202GS.do", TrsFrmQryString(formObj));
			} else if( obj == "03" ) {  // 하부 시트. bkg,cntr 로 조회시 Bkg_cntr, Cop_cntr 리스트 조회.
				formObj.f_cmd.value = SEARCH16;
				sheetObj.DoSearch4Post("ESD_TRS_0202GS.do", TrsFrmQryString(formObj));
			}

		break;

		case IBINSERT:	  //입력
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0202GS.do", TrsFrmQryString(formObj), "chk1", false, true);
		break;
	}
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var fromRow = 0;
	var weitcheck = false;
	var bverifychk = false;
	var birgchk = false;
	
	for( var i=0; i<arrRow.length-1; i++ ) {

		fromRow = arrRow[i];

		if( sheetObj.CellValue(fromRow, "cntr_wgt") <= 0.00 || sheetObj.CellValue(fromRow, "pck_qty") < 1  || sheetObj.CellValue(fromRow, "pck_tp_cd") == "" ) {
			sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
			weitcheck = true;
		} else {
			sheetObj.RowBackColor(fromRow) = sheetObj.UnEditableColor;
		}
		if( sheetObj.CellValue(fromRow, "so_cre_yn") != "Y" ) {
			sheetObj.RowStatus(fromRow) = "R";
			sheetObj.CellValue2(fromRow, "chk1") = "0";
			sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
			bverifychk = true;
		}
		if( sheetObj.CellValue(fromRow, "inv_bil_patt_div_flg") == "Y" ) {
			if( sheetObj.CellValue(fromRow, "rtr_div_cnt") <= 0 ) {
				sheetObj.RowStatus(fromRow) = "R";
				sheetObj.CellValue2(fromRow, "chk1") = "0";
				sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
				birgchk = true;			
			}
		} else {
			if( sheetObj.CellValue(fromRow, "rout_dtl_seq") == "0" ) {
				sheetObj.RowStatus(fromRow) = "R";
				sheetObj.CellValue2(fromRow, "chk1") = "0";
				sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
				birgchk = true;
			}
		}
	}

	if( weitcheck ) {
		errMsg = ComGetMsg("TRS90340");
		ComShowMessage(errMsg);
		return false;
	}
	if( bverifychk ) {
		errMsg = ComGetMsg("TRS90078");
		ComShowMessage(errMsg);
		return false;
	}
	if( birgchk ) {
		errMsg = ComGetMsg("TRS90363");
		ComShowMessage(errMsg);
		return false;
	}

	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {

		return true;
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function searchValidation(sheetObj, formObj, sStatus) {
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var lvEq_no = "";
	var lvToNodCd = "";
	var lvBkgNo = "";
	var noRatechk = false;

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	
	if( arrRow.length-1 > 0 && arrRow.length-1 < 1001 ) {
		for( var i=0; i<arrRow.length-1; i++ ) {
			fromRow = arrRow[i];
			if( arrRow.length-2 == i ) {
				lvEq_no = lvEq_no +""+ sheetObj.CellValue(fromRow, "eq_no");
				lvToNodCd = lvToNodCd +""+ sheetObj.CellValue(fromRow, "to_nod_cd");
				lvBkgNo = lvBkgNo+""+ sheetObj.CellValue(fromRow, "bkg_no");
			} else {
				lvEq_no = lvEq_no +""+ sheetObj.CellValue(fromRow, "eq_no")+",";
				lvToNodCd = lvToNodCd +""+ sheetObj.CellValue(fromRow, "to_nod_cd")+",";
				lvBkgNo = lvBkgNo +""+ sheetObj.CellValue(fromRow, "bkg_no")+",";
			}
			
			if( sheetObj.CellValue(fromRow, "non_rt_sts_cd") == "R" ) {
				sheetObj.RowStatus(fromRow) = "R";
				sheetObj.CellValue2(fromRow, "chk1") = "0";
				noRatechk = true;
			}	
		}
		formObj.eq_no_verify.value = lvEq_no;
		formObj.to_nod_verify.value = lvToNodCd;
		formObj.bkg_no_verify.value = lvBkgNo;
		
		if( noRatechk ) {
			errMsg = ComGetMsg("TRS90620");
			ComShowMessage(errMsg);
			return false;
		}
	}else{
		ComShowMessage('Only 1000 rows or less could be imported at a time.');
		return false;
	}	
	return true;
}

//팝업창에 넘겨주는 Sheet의 Object
function openObjSheet() {
	return sheetObjects[0];
}

/**
 * Sheet1에서 이벤트를 발생시킴.
 */
function sheet1_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.RowStatus(row) = "I";
		} else {
			sheetObj.RowStatus(row) = "R";
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		
		var formObj = document.form;
		
		if( sheetObj.Rowcount ==0 &&  (formObj.bkg_no.value != "" || formObj.cntr_no.value != "")   )  {
			document.all.bkgdtl.style.visibility = "visible" ;
			document.all.bkgdtl.style.display = "inline" ;
			doActionIBSheet(sheetObjects[1] , formObj, IBSEARCH, "03");
		} else{
			sheetObjects[1] .RemoveAll();

		}

	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {

		var formObj = document.form;
		errMsg = ComGetMsg("TRS90103");
		ComShowMessage(errMsg);
		//원본에서 역순으로 특정 상태의 행을 이동한다.
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		for( var ir = arrRow.length-2; ir >=0 ; ir-- ) {
			//원본에서 지움
			sheetObj.RowDelete(arrRow[ir], false);
		}

		// BKG DTL 시트도 REFRESH
		if( sheetObj.Rowcount ==0 &&  (formObj.bkg_no.value != "" || formObj.cntr_no.value != "")   )  {
			doActionIBSheet(sheetObjects[1] , formObj, IBSEARCH, "03");
		}


	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet3_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		doSearchVerify(sheetObjects[0], sheetObjects[2]);
	}
}

/*
 * Verify 조회한 결과에 대한 S/O Creation 항목 선택
 * * N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
 */
function doSearchVerify(sheetObj1, sheetObj2) {	
	var sRow = sheetObj1.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var fromRow = 0;	
	var two_year = "";
	var two_month = "";
	var two_day = "";
	var verifyCount = 0;
	
	for( var i=0; i<arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		var lvEa_no = sheetObj1.CellValue(fromRow, "eq_no");
		sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";
		if( sheetObj1.CellValue(fromRow, "fm_nod_cd").substring(0,2) == "US" 
		&& sheetObj1.CellValue(fromRow, "to_nod_cd").substring(0,2) == "CA" 
		&& (sheetObj1.CellValue(fromRow, "auto_xpt_sys_cd") == "" 
			|| sheetObj1.CellValue(fromRow, "auto_xpt_sys_no") == "")){
			sheetObj1.CellValue2(fromRow, "verify_result") = "AES No is mandatory";
			sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";
		}else{
			sheetObj1.CellValue2(fromRow, "verify_result") = "";
		}
		
		/*
		 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
		 */
		two_year = sheetObj1.CellValue(fromRow, "rail_rcv_coff_fm_dt").substr(0,4);
		two_month = sheetObj1.CellValue(fromRow, "rail_rcv_coff_fm_dt").substr(4,2);
		two_day = sheetObj1.CellValue(fromRow, "rail_rcv_coff_fm_dt").substr(6,2);
		
		/*
		 * N200907240070 2009-09-29 미주 Rail Billing CA 지역 Rail Billing Block 적용 보완
		 */		
		if(sheetObj1.CellValue(fromRow, "pol_cd") == "USSEA"
			|| sheetObj1.CellValue(fromRow, "pol_cd") == "USPDX"){
			if(sheetObj1.CellValue(fromRow, "so_cre_yn") != ""){
				if(sheetObj1.CellValue(fromRow, "eq_tpsz_cd").substr(0,1) == "R" 
					&& sheetObj1.CellValue(fromRow, "rail_rcv_coff_fm_dt_min_global") > 0){
					sheetObj1.CellValue2(fromRow, "verify_result") = "Can not create S/O before " + two_year + "-" +two_month + "-" + two_day;
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";
				}else{
					sheetObj1.CellValue2(fromRow, "verify_result") = "";
				}				
			}					
		}else{
			if(sheetObj1.CellValue(fromRow, "so_cre_yn") != ""){
				if(sheetObj1.CellValue(fromRow, "rail_rcv_coff_fm_dt_min_global") > 0){
					sheetObj1.CellValue2(fromRow, "verify_result") = "Can not create S/O before " + two_year + "-" +two_month + "-" + two_day;
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";						
				}else{
					sheetObj1.CellValue2(fromRow, "verify_result") = "";
				}
			}		
		}
		
		if(sheetObj1.CellValue(fromRow, "pol_cd") == "USORF"
			&& sheetObj1.CellValue(fromRow, "slan_cd") == "NTA"){
			if(sheetObj1.CellValue(fromRow, "so_cre_yn") != ""){
				if(sheetObj1.CellValue(fromRow, "rail_rcv_coff_to_dt_min_global") < 0){
					sheetObj1.CellValue2(fromRow, "verify_result") = "Railbilling is impossible right now. Please contact our booking office.";
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";				
				}else{
					sheetObj1.CellValue2(fromRow, "verify_result") = "";				
				}					
			}						
		}		
		
		for( var z=1; z<(sheetObj2.RowCount+1); z++ ) {
			if( lvEa_no == sheetObj2.CellValue(z, "eq_no") ) {
				sheetObj1.CellValue2(fromRow, "verify_result") = sheetObj2.CellValue(z, "verify_result");
				if( sheetObj2.CellValue(z, "verify_yn") == "N" ) { //S/O Creation 가능
					if(sheetObj1.CellValue(fromRow, "rail_rcv_coff_fm_dt_min_global") > 0){
						sheetObj1.CellValue2(fromRow, "verify_result") = "Can not create S/O before " + two_year + "-" +two_month + "-" + two_day;
						sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";												
					}else{
						sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";						
					}					
				} else {
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";
					sheetObj1.RowStatus(fromRow) = "R";
					sheetObj1.CellValue2(fromRow, "chk1") = "0";
					sheetObj1.RowBackColor(fromRow) = sheetObj1.RgbColor(R,G,B);
				}
				sheetObj2.RowDelete(z, false);
				break;
			}
		}
		
		if( sheetObj1.CellValue(fromRow, "verify_result") == "" ) { //지연요청(이용태)
			sheetObj1.CellValue2(fromRow, "verify_result") = "OK";
		}
		
		if(sheetObj1.CellValue(fromRow, "verify_result") != "OK"){
			verifyCount = verifyCount + 1;
		}
	}
	
	if(verifyCount < 1){
		errMsg = ComGetMsg("TRS90375");
		ComShowMessage(errMsg);	
	}
}

// dtPopupEdit 로 처리 할 경우 팝업오픈 처리
var docProvvndrseq = "";
function sheet1_OnPopupClick(sheetObj, row, col) {
	docProvvndrseq = "";
	if( sheetObj.ColSaveName(col) == "request_sp" ) {
		docProvvndrseq = sheetObj.CellValue(row, "request_sp");
		if( docProvvndrseq != "" ) {
//			ComOpenWindow('ESD_TRS_0956Pop.screen', 'ESD_TRS_0956', 'top=200,left=200,width=402,height=256,toolbar=0, directories=0, status=yes, menubar=0, scrollbars=0, resizable=0');
		    ComOpenWindow('ESD_TRS_0956Pop.screen', 'ESD_TRS_0956Pop', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:402px;dialogHeight:286px', true);

        }
	} else if( sheetObj.ColSaveName(col) == "bkg_spe" ) {
		var myOption = "dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
		var lvbkg = sheetObj.CellValue(row, "bkg_no");
		var lveqno = sheetObj.CellValue(row, "eq_no");
		var lvbkgspe = sheetObj.CellValue(row, "bkg_spe").substr(0,2)	;

		if( lvbkgspe == 'DG' ) {
			var url = "ESD_TRS_0938.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			window.showModalDialog(url, window, myOption);
		} else if( lvbkgspe== 'BB' ) {
			var url = "ESD_TRS_0937.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			window.showModalDialog(url, window, myOption);
		} else if( lvbkgspe== 'AK' ) {
			var url = "ESD_TRS_0936.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			window.showModalDialog(url, window, myOption);
		} else if( lvbkgspe== 'RF' ) {
			var url = "ESD_TRS_0935.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			window.showModalDialog(url, window, myOption);
		} else if( lvbkgspe== 'HG' ) {
			var url = "ESD_TRS_0932.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			window.showModalDialog(url, window, myOption);
		}
	}
}

/**
 * 화면을 줄였다가 늘렸다가 된다.
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
	}
}

function validateFormSearch(formObj) {
	var lvFrmDate = ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate = ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");

	var lvFrm_node = ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node = ComTrimAll(formObj.to_node.value, " ");

	var lvBkg_no = ComTrimAll(formObj.bkg_no.value, " ");
	var lvCntr_no = ComTrimAll(formObj.cntr_no.value, " ");
	var lvTrunk_vvd = ComTrimAll(formObj.trunk_vvd.value, " ");

	if( lvFrmDate == "" ) //from date
		formObj.frm_plandate.value = "";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value = "";

	if( lvBkg_no == "" ) //BKG No
		formObj.bkg_no.value = "";
	if( lvCntr_no == "" ) //CNTR No
		formObj.cntr_no.value = "";

	if( lvFrmDate == "" && lvToDate != "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //날짜 체크하는 부분
		if( !ComIsDate(lvFrmDate) ) {
			errMsg = ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_plandate.focus();
			return false;
		} else if( !ComIsDate(lvToDate) ) {
			errMsg = ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_plandate.focus();
			return false;
		}
		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 14 ) {
			errMsg = ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
	} else {
		if( lvBkg_no == "" && lvCntr_no == "" && lvTrunk_vvd == "" ) {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}

	if( lvFrm_node == "" ) { //From Node
		formObj.frm_node.value = "";
		formObj.frm_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvTo_node == "" ) { //To Node
		formObj.to_node.value = "";
		formObj.to_yard.RemoveAll(); // combo 데이터삭제
	}

	if( !ComIsAlphabet(ComTrimAll(lvBkg_no, ","), "n") && lvBkg_no != "" ) {
		formObj.bkg_no.value = "";
		formObj.bkg_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != ""  ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	formObj.hid_frmdate.value = lvFrmDate; //from Date
	formObj.hid_todate.value = lvToDate; //to Date

	formObj.frm_node.value = lvFrm_node.toUpperCase();
	formObj.to_node.value = lvTo_node.toUpperCase();

	formObj.bkg_no.value = lvBkg_no.toUpperCase(); //BKG No.
	formObj.cntr_no.value = lvCntr_no.toUpperCase(); //CNTR No
	return true;
}

/*
 * IRG Adjuct Pop up을 호출한다.
 */
function doActionPopupOpen(sheetObj, formObject) {
	var doc_flg = false;
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
	} else {
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		for( var i=0; i<arrRow.length-1; i++ ) {
			if( sheetObj.CellValue(arrRow[i], "inv_bil_patt_div_flg") == "Y" ) {
				sheetObj.RowStatus(arrRow[i]) = "R";
				sheetObj.CellValue2(arrRow[i], "chk1") = "0";
				sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
				doc_flg = true;
			} else {
				if( sheetObj.CellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
					sheetObj.RowStatus(arrRow[i]) = "R";
					sheetObj.CellValue2(arrRow[i], "chk1") = "0";
					sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
				}
			}
		}
		if( doc_flg ) {
			errMsg = ComGetMsg("TRS90363");
			ComShowMessage(errMsg);
		} else {
			if( sheetObj.RowCount("I") < 1 ) {
				errMsg = ComGetMsg("TRS90363");
				ComShowMessage(errMsg);
			} else {
				var pop_width = 1000;
				var pop_leftloc= window.screenLeft;
				var pop_toploc = window.screenTop-400;
//				ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'top='+pop_toploc +', left='+pop_leftloc+',width='+ pop_width +' , height=475, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0', true);
                ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:1000px;dialogHeight:510px', true);
				

			}
		}
	}
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = ComTrimAll(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'R' ) {
		lvPorNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'L' ) {
		lvPolNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/**
 * POL Node popup
 */
function openPolYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var param = '?sysCode=ENIS';
	ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * 공통 Node popup
 */
 function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.frm_node.value = lvLoc;
	getYardCombo(document.frm_yard, sheetObjects[0], formObject, lvLoc);
	document.frm_yard.CODE = lvYard;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_node.value = lvLoc;
	getYardCombo(document.to_yard, sheetObjects[0], formObject, lvLoc);
	document.to_yard.CODE = lvYard;
}

/**
 * Por Node 팝업에 대한 리턴값
 */
function getPorNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.por_node.value = lvLoc;
	getYardCombo(document.por_yard, sheetObjects[0], formObject, lvLoc);
	document.por_yard.CODE = lvYard;
}

/**
 * Por Node 팝업에 대한 리턴값
 */
function getPolNode(rowArray) {
	var colArray = rowArray[0];
	document.form.pol_node.value = colArray[3];
}

/**
 * 공통 Trunk VVD popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value = reObj;
	} else if( obj == "BKG" ) {
		formObject.bkg_no.value = reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value = reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value = multiCntrChkDgt(reObj);


	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

/**
 * 공통 Trunk VVD popup
 */
 function openTVVDPopup() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_VVD_1";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

// Trunk VVD Return Value
function getCOM_ENS_VVD_1(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.trunk_vvd.value = colArray[7] + gubun;
}

/*
 * 멀티 달력 입력 Pop-Up
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}

// 일자에 더하기를 한다.
function getDateBetween(obj) {
	if(document.form.frm_plandate.value == ""){
		document.form.to_plandate.value = "";
	}else{
		document.form.to_plandate.value = ComGetDateAdd(obj.value, "D", 14);		
	}	
}



/*  bkg_detail 시트 열고 닫기 */
function reSize(i){
	document.all.bkgdtl.style.visibility = "visible" ;

	if ( i==0 ){
		// dtl 시트 닫기
		document.all.bkgdtl.style.display = "none" ;
	} else {
		document.all.bkgdtl.style.display = "inline" ;
	}
}
