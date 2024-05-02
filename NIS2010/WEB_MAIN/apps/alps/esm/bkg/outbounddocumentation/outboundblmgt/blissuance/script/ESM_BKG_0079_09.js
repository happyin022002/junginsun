/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0079_09.js
 *@FileTitle : Cancel Issue Release
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.20 이진서
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2012.02.27 정선용 [CHM-201216098-01] BKG Inquiry 메뉴의 SAVE 버튼 기능 오류
 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
 2012.03.30 서미진 [CHM-201217003] on board type 부재시 BL Issue 버튼 Disable
 2012.07.17 이준근 [CHM-201218309-01] LBP 적용 로직 일부 수정 요청
 2012.07.25 이준근 [CHM-201218600-01] C/A 중에 B/L Issue와 Release가 안되도록 로직 수정 및 팝업 메세지 추가
 2012.08.13 이준근 [CHM-201219604-01] 잘못된 B/L No 입력후 waiting 너무 길어요
 2012.08.30 이준근 Error 발생시 Message 처리 수정 (B/L Issue [Issue])
 2012.09.11 이준근 [CHM-201219948-01] B/L Issue 시 or SeaWayBill, Surrender 시 Validation 추가
 2012.10.18 이재위 [CHM-201220612] [BKG] BL Issue화면- shipper의 A/R고객정보 팝업 연결
 2012.11.19 조정민 [CHM-201221436] [BKG] LBP 적용 로직 확대 요청 (Auto-rating)
 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
 2012.11.16 김보배 [CHM-201221290] [BKG] B/L Issue 화면에 B/L HOLD 기능 추가 & B/L Status Report 기능 보완 (NSC #2 & #3)
 2013.05.13 김태경 [CHM-201324336] ALPS B/L Issue 화면 "Remark" 입력 기능 보완
 2015.05.07 양동훈 [CHM-201535530-01]  O.B/L Printed가 "Y"이면 "SWB Release"가 비활성화, Released가 "Y"이면 "O.B/L Release"가 비활성화
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
 * @class ESM_BKG_0079_09 : ESM_BKG_0079_09 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0079_09() {
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
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0079_09GS.do';
var prefix1 = "t11sheet1_";
var prefix2 = "t11sheet2_";
var prefix3 = "t11sheet3_";
var prefix4 = "otsRcvInfo_";
var prefix5 = "lbpInfo_";
var sheetNames   = new Array("t11sheet1","otsRcvInfo","otsRcvPop","lbpInfo");
var tab_alert_msg = false; // 메세지 표시유무
var lbpApplyFlg='N'; //Issue 반영시점 Flg
var chgExpRqst = 'N';

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// window.onunload=function(){var formObj = document.form;
// ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t11sheet1_bkg_no));
// }
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	
	//------------------------------------------------>
	
	// ------------------------------------------------>
    // IBMultiCombo초기화
    for(var j=0;j<comboObjects.length;j++){
        initCombo(comboObjects[j],j+1);
    }
    
    //------------------------------------------------>
	// 시작 환경 설정 함수 이름 변경
    for(i=0;i<sheetNames.length;i++){
		ComConfigSheet (sheetObjects[sheetNames[i]] );
		initSheet(sheetObjects[sheetNames[i]],i+1);
	    ComEndConfigSheet(sheetObjects[sheetNames[i]]);	// 마지막 환경 설정 함수 추가
	}
	
	//------------------------------------------------>
	// combo box 기본값 설정
	setComboDefault();
	
	// control 초기화
	initControl();
	
	// ------------------------------------------------>
	var formObj  = document.form;
	if(formObj.bkg_no.value != ""){ 
		ComSetObjValue(formObj.frm_t11sheet1_bkg_no ,formObj.bkg_no.value);
		doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
	}
	//------------------------------------------------>
	// setInquiryDisableButton 이벤트 호출
	if(ComGetObjValue(formObj.isInquiry) == "Y"){
		setInquiryDisableButton();
	}
//	// control 초기화
//	initControl();
}
/**
* 메뉴 오픈시 화면 깜빡임은 시트의 초기화와 DB처리 로드한다. <br>
* 화면 깜빡임 관련 보안<br>
* @param {ibsheet} sheetObj IBSheet Object
*/
function setComboDefault() {  

	var formObj = document.form;
	var sXml = document.frm.sXml.value;
	var arrXml = sXml.split("|$$|");    

	if (arrXml.length > 0){
		ComBkgXml2ComboItem(arrXml[0], formObj.on_board_type, "val", "name");
	}
	if (arrXml.length > 1){
		ComBkgXml2ComboItem(arrXml[1], formObj.bl_ready_type, "val", "name");			
	}  	
	if (arrXml.length > 2){
		ComBkgXml2ComboItem(arrXml[2], formObj.ppd_confirm, "val", "name");
		ComBkgXml2ComboItem(arrXml[2], formObj.trd_ppd_confirm, "val", "name");
		ComBkgXml2ComboItem(arrXml[2], formObj.cct_confirm, "val", "name");
		ComBkgXml2ComboItem(arrXml[2], formObj.trd_cct_confirm, "val", "name");	
	}
	if (arrXml.length > 3){
		ComBkgXml2ComboItem(arrXml[3], formObj.bl_hld_rsn_cd, "val", "desc");
	}
}

/**
* 초기 컨트롤 설정하기 
**/
var bkgMAP = null;
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); //
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //
	axon_event.addListenerForm('keydown', 'check_Enter', formObj);
	axon_event.addListenerForm  ("change", 			"form_onChange", 		formObj);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); 
	
	document.form.bl_ready_type.SetColWidth("30|100");// B/L READY(Type)
	document.form.on_board_type.SetColWidth("30|200");// ON BOARD(Type)
	document.form.ppd_confirm.SetColWidth("30|100");	// Term RCV
	document.form.trd_ppd_confirm.SetColWidth("30|100");
	document.form.cct_confirm.SetColWidth("30|100");
	document.form.trd_cct_confirm.SetColWidth("30|100");
	document.form.bl_hld_rsn_cd.SetColWidth("30|150");
	document.form.bl_hld_rsn_cd.Code = "CR"; // B/L Hold 이유
	
	/**
	 * 메뉴 별도경로에서 들어올때 비활성화처리 ComBtnDisable("btn_t11Save");
	 * ComBtnDisable("btn_t11Issuer_Set");
	 */
	buttonDisabledAll();
	ComBtnDisable("btn_t11ISSNOTE");
	
	/*
	 * 초기값 셋팅 SELECT ATTR_CTNT1,ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT WHERE
	 * HRD_CDG_ID = 'OBL_RCV_TP_CD'
	 */
	bkgMAP = new fnBkgJsMap();
	bkgMAP.put('B', 'B/L');
	bkgMAP.put('W', 'WAY BILL');
	bkgMAP.put('L', 'LG/LOI');
	
	applyShortcut();
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
   comboObjects[comboCnt++] = combo_obj;
}
/**
* IBSheet Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setSheetObject(sheet_obj) {
	 sheetObjects[sheet_obj.id] = sheet_obj;
}
/**
* 초기 initCombo 설정하기 
**/
function initCombo(comboObj, comboNo) {
    comboObj.RemoveAll(); 
    comboObj.UseEdit = true; 
    // comboObj.ValidChar(2, 1); // 영어 대문자, 숫자 입력 가능
    comboObj.IMEMODE = 0;			// IMEMODE = 영문
    comboObj.MaxLength = 30;
    // comboObj.FontColor = "red";
}
 /**
 * 화면의 모든 버튼을 비 활성화 시킨다.
 **/
 function buttonDisabledAll(){
	var formObj = document.form;
	ComBtnDisable("btn_t11OBLRelease");
	ComBtnDisable("btn_t11CancelRelease");
	ComBtnDisable("btn_t11SWBRelease");
	ComBtnDisable("btn_t11SWBEmail");
	ComBtnDisable("btn_t11OBLSurrender");
	ComBtnDisable("btn_t11Issue");	
	ComBtnDisable("btn_t11InternetAUTH");
	ComBtnDisable("btn_t11CancelAUTH");
//	ComBtnDisable("btn_t11ISSNOTE");
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
		switch (sheetID) {

		case "t11sheet1": //t1sheet1 init
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
				InitColumnInfo(115, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle1 = "||||||||||||||||||||||||||||||||||||||||||||";

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
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "tvvd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_sts");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bdr");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "shpr_name");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "shpr_address");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "shpr_cnt_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "shpr_seq");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "f_fwd_name");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "f_fwd_address");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "vessel_direction");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pre_carriage_by");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "por_code");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "por_name");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pol_code");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pol_name");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pod_code");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pod_name");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "del_code");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "del_name");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "move_type");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "final_dest");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_rcv");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_by");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "ppd_date", false, "", dfDateYmd, 0, false, true);

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_confirm");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_ppd_rcv");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_ppd_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_ppd_by");				
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "trd_ppd_date", false, "", dfDateYmd, 0, false, true);

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_ppd_confirm");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cct_rcv");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cct_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cct_by");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "cct_date", false, "", dfDateYmd, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cct_confirm");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_cct_rcv");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_cct_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_cct_by");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "trd_cct_date", false, "", dfDateYmd, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_cct_confirm");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_ready_checkbox");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_ready_by");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_ready_date");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_ready_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_ready_type");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "doc_proc_modyflg");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "doc_proc_type");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "doc_proc_seq");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_proofbyshipper_checkbox");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_proofbyshipper_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_proofbyshipper_by");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_proofbyshipper_date");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "on_board_type");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "on_board_date");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_issuebl_type");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_issue_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_issue_date");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_issue_release");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_issue_at");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_issue_by");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_hld_flg");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_hld_rsn_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_hld_dt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_hld_usr_id");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "issued");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "released");
				// InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,
				// prefix1 + "issued_enable");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "o_blreceive_type");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "o_blreceive_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "o_blreceive_date");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "o_blreceive_at");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "o_blreceive_by");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "surrender");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "do_issue_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "do_issue_date");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "do_issue_at");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "do_issue_by");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "print_option");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "doc_request_flag");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "auth_flag");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "internet_auth");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "tpb_indicator");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "tpb_status");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "black_customer_flag");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pol_etd_dt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "flg_rate");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "flg_md");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "flg_ppd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_flg_ppd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "flg_to_order");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "flg_do");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_prn_flg");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cust_to_ord_flg");
				<!-- by 신자영 추가요청 -->
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_rcv_user_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "ppd_rcv_user_id");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "ppd_rcv_dt", false, "", dfDateYmd, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_ppd_rcv_user_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_ppd_rcv_user_id");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "trd_ppd_rcv_dt", false, "", dfDateYmd, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cct_rcv_user_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cct_rcv_user_id");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "cct_rcv_dt", false, "", dfDateYmd, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_cct_rcv_user_office");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "trd_cct_rcv_user_id");
				InitDataProperty(0, cnt++ , dtData,  0, daCenter, false,prefix1 + "trd_cct_rcv_dt", false, "", dfDateYmd, 0, false, true);
				<!-- internet Auth에서 이메일주소 얻기 -->
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cntc_pson_eml");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_iss_rmk");// Remark
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "pod_nod_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "del_nod_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "wbl_eml");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "wbl_rt_tp_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "img_flg");

				CountPosition = 0;
				DateFormatChar = "/";
			}
			break;

        case "otsRcvInfo":
            /****************************************************************
            // 11. 운임 결재 여부와 Outstanding Amounts 정보 추출
            *****************************************************************/

            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";

                var headCount = ComCountHeadTitle(HeadTitle);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(68, 0, 0, true);

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix="otsRcvInfo_";
                InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  80,    daCenter,  false,   prefix +"ibflag");
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_sts_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd1" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd2" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd3" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd4" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd5" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt1"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt2"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt3"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt4"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt5"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_curr_cd1" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_curr_cd2" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_curr_cd3" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_curr_cd4" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_curr_cd5" ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_amt1"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_amt2"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_amt3"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_amt4"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_ots_amt5"     ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);

                CountPosition = 0;
            }
        break;
        
        case "otsRcvPop":
            /****************************************************************
            // Total Billable Amount
            *****************************************************************/

            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;

               // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

                var HeadTitle1 = "|OUTSTANDING|OUTSTANDING";
                var headCount = ComCountHeadTitle(HeadTitle1);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                prefix = "otsRcvPop_";
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
                InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "curr_cd",         false,      "",     dfNone,         0,      false,      true);
                InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "tot_ots_amt",     false,      "",     dfNone,         0,      false,      true);

                CountPosition = 0;
            }
            break;
            
        case "lbpInfo":
            /****************************************************************
            // 11. 운임 결재 여부와 Outstanding Amounts 정보 추출
            *****************************************************************/

            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 10, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = " |BKG_NO|RAT_UT_CD|CURR_CD|SCG_AMT|CGO_CATE_CD|PAY_TERM_CD|APPLY_FLG";

                var headCount = ComCountHeadTitle(HeadTitle);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(8, 0, 0, true);

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix="lbpInfo_";
                InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  80,    daCenter,  false,   prefix+"ibflag");
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"bkg_no"         ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"rat_ut_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"curr_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"scg_amt"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"cgo_cate_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"pay_term_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix+"apply_flg"           ,   false,     "",        dfNone,     0,          false,       true);
                
                
    

                CountPosition = 0;
            }
        break;
        
		}
	} catch (ex) {
		fnBkgErrorAlert('initSheet', ex);
	}
}
 
 /**
 * btn_Authorize 이벤트 발생 
 * param :
 */
function btn_Authorize(){
	var sheetObj = sheetObjects['t11sheet1'];	
	doActionIBSheet(sheetObj, document.form, MULTI01);
}

 var isShowOrgBlNo = true;
 var returnValue ;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var formObj = document.form;
	var sheetObject1 = sheetObjects['t11sheet1'];	
	var srcName = window.event.srcElement.getAttribute("name");

	try {
		
		//유효성 체크 
		if(!processValidate(srcName)) return; 

		// 처음버튼상태는 설정하지 않는다.
		if("btn_t11CancelRelease" != srcName 
			&& "btn_t11OBLSurrender" != srcName 
			&& "btn_t11CancelAUTH" != srcName
			&& "btn_t11InternetAUTH" != srcName
			&& "btn_t11OBLRelease" != srcName			
		){
			processStatus(srcName);
			fnBlIssueButton() ;
		}

		//검색 
		ComSetObjValue(formObj.f_cmd, SEARCH);
		ComSetObjValue(formObj.setupfocoblflag, '');

		if(srcName != "btn_splitPop"){
    		if(layList.style.display == ""){
    			layList.style.display="none";
    		}    	    			
		}
		
		ComSetObjValue(formObj.buttonType, srcName);// by 추가요청
		
		switch (srcName) {

		/** * POP UP BL ISSUE (S) ** */

		case "btn_splitPop":
			doActionIBSheet(sheetObject1,formObj,COMMAND03);					
			break;           
		case "btn_OrgBlPop":
			if(isShowOrgBlNo){
				blNoSet();
				isShowOrgBlNo = false;
			}else{
				blNoHide();
				isShowOrgBlNo = true;
			}					
			break;	
			
		case "pop_on_board_date":
			var cal = new ComCalendar();
			cal.select(formObj.frm_t11sheet1_on_board_date, 'yyyy-MM-dd');
			break;
		case "pop_bl_issue_date":
			var _cal = new ComCalendar();
			_cal.select(formObj.frm_t11sheet1_bl_issue_date, 'yyyy-MM-dd');
			break;
		case "pop_bl_ready_date":
			var _cal = new ComCalendar();
			_cal.select(formObj.frm_t11sheet1_bl_ready_date, 'yyyy-MM-dd');
			break;
		case "pop_bl_proofbyshipper_date":
			var _cal = new ComCalendar();
			_cal.select(formObj.frm_t11sheet1_bl_proofbyshipper_date, 'yyyy-MM-dd');
			break;			
		case "pop_bkg_no":
			fnSetSelectNumberBox('span_bkg_no', 'text_bkg_no');
			break;
		case "pop_bl_no":
			fnSetSelectNumberBox('span_bl_no', 'text_bl_no');
			break;
		case "pop_pol":
			/*1. POL CD의 Name을 MDM_LOCATION의 내용으로 변경한다.
			<EXCEPTION>	1.a Location 이 존재하지 않을 경우 메시지 [BKG00061] 표시 후 리턴
			 */
			fnSearchMdmLocName('pol');
			break;
		case "pop_pod":
			/* 1. POD CD의 Name을 MDM_LOCATION의 내용으로 변경한다.
			<EXCEPTION> 1.a Location 이 존재하지 않을 경우 메시지 [BKG00061] 표시 후 리턴
			 */
			 
			 /* 홍우리님 요청 VNSGNY2 & VNSGNY1 인 경우 각각 POD, DEL항목 비활성화*/
//			if (null != ComGetObjValue(formObj.frm_t11sheet1_pod_nod_cd) 
//				&& ("VNSGNY2" == ComGetObjValue(formObj.frm_t11sheet1_pod_nod_cd) 
//				||  "VNSGNY1" == ComGetObjValue(formObj.frm_t11sheet1_pod_nod_cd))){
//			}else{
				fnSearchMdmLocName('pod');
//			}
			break;
		case "pop_ppd":
			/*1. EAI를 통해서 ERP OTS 정보를 조회함*/
			getBKGotsRcvPop('pop_ppd');
			break;
		case "pop_trd_ppd":
			/*1. EAI를 통해서 ERP OTS 정보를 조회함*/
			getBKGotsRcvPop('pop_trd_ppd');
			break;
		case "pop_cct":
			/*1. EAI를 통해서 ERP OTS 정보를 조회함*/
			getBKGotsRcvPop('pop_cct');
			break;
		case "pop_trd_cct":
			/*1. EAI를 통해서 ERP OTS 정보를 조회함*/
			getBKGotsRcvPop('pop_trd_cct');
			break;

		case "pop_tpb":
			/*BKG No. RHQ(User 소속 office RHQ),  3rd Party Type “Customer”*/
		
	/*
	 * var otsStsCd = ""; if (document.form.tpb_status.value == "1") { otsStsCd =
	 * "P"; } else { otsStsCd = "T"; }
	 * 
	 * var pgmNo = "&pgmNo=ESD_TPB_0116" var param =
	 * "s_bkg_no_all="+ComGetObjValue(formObj.bkg_no) +"&s_ots_sts_cd="+
	 * otsStsCd +"&s_state=BKG" +"&s_n3pty_src_sub_sys_cd=TRS"
	 * +"&s_n3pty_src_sub_sys_cd_check=TRS" ; var url = "ESD_TPB_0116.do?" +
	 * param + pgmNo; ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" +
	 * _Width + "px; dialogHeight:" + _Height + "px", true);
	 */
	// pop up UI
			var _Width = '1024';
			var _Height = '468';
			var param = 's_state=BKG'+'&s_bkg_no_all=' + ComGetObjValue(formObj.bkg_no)+ '&s_ots_sts_cd=T&pgmNo=ESD_TPB_0134';
			// var url = "ESM_BKG_0292_02.do?" + param;			
			var url = "ESD_TPB_0134.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
			break;

			
    	case "pop_bl_certi":
    		var bkgNo = ComGetObjValue(formObj.bkg_no); 
			if (bkgNo == "") {
				ComShowCodeMessage("BKG00255");
				return false;
			}

			if(formObj.strOfc_cd.value=="BOMSC"||formObj.frm_t11sheet1_por_code.value.substring(0, 2) == 'IN'){
				var rdParam = "";
				var rdUrl = "";
				var rdFile = "";

				formObj.com_mrdBodyTitle.value = "Landing Certificate";
				rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
				rdFile = "ESM_BKG_0361_04.mrd";
				rdParam = "/rv BKG_NO['"+ bkgNo + "']";
				
				formObj.com_mrdPath.value = rdUrl+rdFile;
				formObj.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
				formObj.com_mrdSaveDialogFileName.value = bkgNo;
				ComOpenRDPopupModal("dialogWidth:900px;dialogHeight:800px");
			}else{
				var url = "ESM_BKG_9466.do?bkg_no="+bkgNo+"&bl_no="+ComGetObjValue(formObj.bl_no)+"&ui_id=ESM_BKG_0079_09";
				ComOpenWindowCenter(url, "ESM_BKG_9466", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
			}

        	break;
        	
		case "pop_shpr":
			var _Width = '1000';
			var _Height = '610';
			var param = 'cust_cnt_cd=' + ComGetObjValue(formObj.frm_t11sheet1_shpr_cnt_cd);
			param += "&cust_seq=" + ComGetObjValue(formObj.frm_t11sheet1_shpr_seq);
			param += "&pop_yn=Y";
			
			var url = "FNS_INV_0013.do?" + param;
			ComOpenPopup(url, _Width, _Height, '', '1,0', true);

			break;
			
		/** * Btn BL ISSUE (S) ** */
		case "btn_t11Doc_Requirement":
			/*Pop-up의 결과 Out 인자를 B/L Ready의 Type에 설정한다.*/
			var _Width = '500';
			var _Height = '535';
			var param = 'bkg_no=' + ComGetObjValue(formObj.bkg_no);
			var url = "ESM_BKG_0059.do?" + param;
			rValue = ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
			break;
			
		case "btn_t11ISSNOTE":
			/*Issue note  : 1. Pop-up을 실행한다.*/
			var _Width = '750';
			var _Height = '280';
			var param = 'bkg_no=' + ComGetObjValue(formObj.bkg_no);
			var url = "ESM_BKG_9462.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true)

			break; 
			
			
		case "btn_t103rdBLReq":
//          doActionIBSheet(sheetObject1,formObj,COMMAND08);     
          ComOpenWindowCenter("ESM_BKG_9460.do?ui_id=ESM_BKG_0079_08&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&pop_mode=1", "ESM_BKG_9460", 1020, 600, false);
          break;
			
		case "btn_t11TS_Route":
			/*TS Route  : 1. Pop-up을 실행한다.*/
			var _Width = '740';
			var _Height = '330';
			var param = 'bkg_no=' + ComGetObjValue(formObj.bkg_no);
			var url = "ESM_BKG_0650.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true)

			break;
		case "btn_t11Issuer_Set":
			//1. B/L Issue의 항목 중 Date/At/By로 현재 사용자의 정보를 설정
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_by, ComGetObjValue(formObj.strUsr_id));
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_at, ComGetObjValue(formObj.strOfc_cd));
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_date, ComGetNowInfo());

			break;
		case "btn_t11Issue":
			//2. B/L Issue 정보 여부 체크
			// <EXCEPTION>2.a 빈 컬럼이 있을 경우 메시지 [BKG00466]를 표시 후 리턴
			
			lbpApplyFlg='Y'; //Issue 시 Surcharge Table의 조건에 따라 LBP 반영 multi01
			
			/* 홍우리님 요청 POD or DEL 항목이 VNSGN 인 경우 POD NAME, DEL NAME 변경시 메시지 */
			if(null != formObj.old_pod_name.value 
					&& "VNSGN" == ComGetObjValue(formObj.frm_t11sheet1_pod_code)
					&& (formObj.old_pod_name.value != ComGetObjValue(formObj.frm_t11sheet1_pod_name))){
				ComShowCodeMessage("BKG08269");
			}else if (null != formObj.old_del_name.value
					&& "VNSGN" == ComGetObjValue(formObj.frm_t11sheet1_del_code)
					&& (formObj.old_del_name.value != ComGetObjValue(formObj.frm_t11sheet1_del_name))){
				ComShowCodeMessage("BKG08269");
			}
			doActionIBSheet(sheetObject1, document.form, MULTI01);
			break;

		case "btn_t11Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			//retrieve시에 focus가 booking no로 가도록 함
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			break;

		case "btn_t11New":
			ComResetAll();
			//bkg_no 초기화 추가
			ComSetObjValue(formObj.frm_t11sheet1_bkg_no,"");
			eval('DIV_btn_t11InternetAUTH').style.display = 'block';
			eval('DIV_btn_t11CancelAUTH').style.display = 'none';
			try{
				parent.initCAControl("", "N", "N", "N", "");
			}catch(e){}
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			break;

		case "btn_t11Save":
			tab_alert_msg = true;
			/* 홍우리님 요청 POD or DEL 항목이 VNSGN 인 경우 POD NAME, DEL NAME 변경시 메시지 */
			if(null != formObj.old_pod_name.value
					&& "VNSGN" == ComGetObjValue(formObj.frm_t11sheet1_pod_code)
					&& (formObj.old_pod_name.value != ComGetObjValue(formObj.frm_t11sheet1_pod_name))){
				ComShowCodeMessage("BKG08269");
			}else if (null != formObj.old_del_name.value
					&& "VNSGN" == ComGetObjValue(formObj.frm_t11sheet1_del_code)
					&& (formObj.old_del_name.value != ComGetObjValue(formObj.frm_t11sheet1_del_name))){
				ComShowCodeMessage("BKG08269");
			}
			
			doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;

		case "btn_t11BLPreview":
			var _Width = '540';
			var _Height = '530';
			var bl_tp_cd = ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type);
			if ("B"==bl_tp_cd) bl_tp_Cd = "D";
			var param = 'bkg_no='+ComGetObjValue(formObj.bkg_no)+'&bl_no='+ComGetObjValue(formObj.bl_no)+'&bl_tp_cd='+bl_tp_cd; 
			ComOpenWindow("/hanjin/ESM_BKG_0927.do?" + param, "PopupEsmBkg0927", "width=916, height=750, scrollbars=no", false);
			break;

		case "btn_t11InternetAUTH":
			/*			
				1. Script 공통 참조
				2. Black Customer Flag가 'Y'일 경우 메시지 [BKG01036] 표시
				3. On-Board type이 'L' or 'S' 일때 On-Board Date와 Vessel ETA or ETD at POL Date 확인
					(onboard Date와 ETD의 일치여부 확인 message)
				4. On-Board type이 'R' 일때 Rate Cargo Receiving Date 확인
				5. B/L data 작성 여부(M&D 및 Rate) 및 ppd 운임회수 확인
				6. 변경된 정보가 있을 경우 저장 호출
			
				<EXCEPTION>
				3.a On-Board Date와 SKD Date가 다를 경우 메시지 [BKG00467] 표시(단순 경고메세지)
				4.a On-Board Date와 CRD가 다를 경우 메시지 [BKG00468] 표시(단순 경고메세지)
				5.a 작성완료 되지 않은 경우 메세지 [BKG00470] 표시 후 리턴
			 */
			 ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_black_customer_flag)) {
				ComShowCodeMessage("BKG01036");
			}
			
			if ('R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)
			) {	
				ComShowCodeMessage("BKG00468");
			}
			
			var _Width = '850';
			var _Height = '660';
			var param = "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&bl_no=" + ComGetObjValue(formObj.bl_no);
			var pgmNo = "&pgmNo=ESM_BKG_1074";
			var url = "ESM_BKG_1074.do?" + param + pgmNo;
			
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true)

			break;

		case "btn_t11OBLRelease":
			ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			doActionIBSheet(sheetObject1, document.form, MULTI01);
			
			break;
			
		case "btn_t11CancelRelease":
			ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			/* 1. 변경된 정보가 있을 경우 저장 호출 */
			var _Width = '550';
			var _Height = '400';
			var do_value = 'Y'
				if("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do) 
				|| "L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)){
					do_value = 'N'
				}
			var param = 'bl_no=' + ComGetObjValue(formObj.frm_t11sheet1_bl_no);
			param += "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			param += "&isPopUp=Y";
			param += "&frm_t11sheet1_surrender=" + ComGetObjValue(formObj.frm_t11sheet1_surrender);
			param += "&frm_t11sheet1_issued=" + ComGetObjValue(formObj.frm_t11sheet1_issued);
			param += "&frm_t11sheet1_released=" + ComGetObjValue(formObj.frm_t11sheet1_released);
			param += "&frm_t11sheet1_flg_do=" + ComGetObjValue(formObj.frm_t11sheet1_flg_do);
			//param += "&frm_t11sheet1_flg_do=" + do_value;
			param += "&frm_t11sheet1_bl_issue_no=" + ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no);
			
			var url = "ESM_BKG_0649.do?" + param;
			returnValue = ComOpenPopup(url, _Width, _Height, 'getBKG_0649', '0,0', true, true, 0,"", 1);
			getBKGreturnValue(returnValue,srcName);
			break;

		case "btn_t11CancelAUTH":
			ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			/* 1. 변경된 정보가 있을 경우 저장 호출 */
			var _Width = '550';
			var _Height = '550';
			var param = 'bl_no=' + ComGetObjValue(formObj.frm_t11sheet1_bl_no);
			param += "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			param += "&isPopUp=Y";
			param += "&frm_t11sheet1_surrender=" + ComGetObjValue(formObj.frm_t11sheet1_surrender);
			param += "&frm_t11sheet1_issued=" + ComGetObjValue(formObj.frm_t11sheet1_issued);
			param += "&frm_t11sheet1_flg_do=" + ComGetObjValue(formObj.frm_t11sheet1_flg_do);
			param += "&frm_t11sheet1_bl_issue_no=" + ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no);
			
			var url = "ESM_BKG_0649.do?" + param;
			returnValue = ComOpenPopup(url, _Width, _Height, 'getBKG_0649', '0,0', true, true, 0,"", 1);
			getBKGreturnValue(returnValue,srcName);

			break;
	
		case "btn_t11SWBRelease":
			ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			doActionIBSheet(sheetObject1, document.form, MULTI01);
			
			break;

		case "btn_t11SWBEmail":
			var _Width = '990';
			var _Height = '700';
			var param = 'bkg_no=' + ComGetObjValue(formObj.bkg_no) + '&docType=W';
			var url = "ESM_BKG_0095.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true)
			break;

		case "btn_t11OBLSurrender":
			/*
			1. Black Customer Flag가 'Y'일 경우 메시지 [BKG01036] 표시
			2. Pop-Up 오픈
			(
			 * Surrender에 'Y' 체크
			 * 참고를 참조하여 Button과 Flag설정
			 * 팝업에서 O.B/L Receive에 Type = 'B'로 하고 팝업에서 받은 No, Date, At, By로 설정함
			)"
			 */
			if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_black_customer_flag)) {
				ComShowCodeMessage("BKG01036");
			}

			var _Width = '900';
			var _Height = '300';
			var param = 'bkg_no=' + ComGetObjValue(formObj.bkg_no) + '&bl_no=' + ComGetObjValue(formObj.bl_no);
			param += "&isPopUp=Y";
			var url = "ESM_BKG_0400.do?" + param;
			
			ComOpenWindowCenter(url, "BKG_Win", _Width, _Height, false);
			
			break;

		case "btn_t11BLPrint":
			/*	
			1. Release Flag 확인
			2. Script 공통 참조
			<EXCEPTION>	1.a 'Y'인경우 Cancel Release 호출"
			 */
				var _Width = '540';
				var _Height = '410';
				var param = 'bkg_no=' + ComGetObjValue(formObj.bkg_no);
				var url = "ESM_BKG_0743.do?" + param;
				ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true)
		
		break;
				
		case "btn_t11sheet1_obl_iss_rmk":
			
			var paramVal = "?sheet_name=B&pgmNo=ESM_BKG_9459";
            ComOpenWindowCenter('/hanjin/ESM_BKG_9459.do' + paramVal, 'win4', 600, 270, true);
            
		break;
		
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
			fnBkgErrorAlert('processButtonClick', e);
		} else {
			fnBkgErrorAlert('processButtonClick', e);
		}
	}
}
/**
* charge_cd callback 함수 getBKGotsRcvPop 호출 .<br>
* @param _val
*/
function getBKGotsRcvPop(_val) {
	var formObj = document.form;
	if (sheetObjects["otsRcvInfo"].RowCount == 0) {
		ComShowMessage("Outstanding Amount does not exist.");
        return;
    }
	sheetObjects["otsRcvPop"].RemoveAll();
    var maxRow = sheetObjects["otsRcvInfo"].LastRow;
	var cellValue = "";
	var prefix="otsRcvInfo_";

	var curr_cd = "";
	var ots_amt = 0;
	var i = 1;

	    switch(_val) {
	
		    case 'pop_ppd': //pop_ppd
				for(var q=1;q<6;q++){
					if (sheetObjects["otsRcvInfo"].CellValue(i, prefix + "ppt_ots_amt" + q) > 0) {
						curr_cd = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "ppt_ots_curr_cd" + q);
						ots_amt = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "ppt_ots_amt" + q);
						
						sheetObjects["otsRcvPop"].DataInsert(-1);
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_curr_cd") = curr_cd;
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_tot_ots_amt") = ots_amt;
					}	
				}
		    break;
		
		    case 'pop_trd_ppd': //pop_trd_ppd
				for(var q=1;q<6;q++){
				    if (sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_ppt_ots_amt" + q) > 0) {
						curr_cd = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_ppt_ots_curr_cd" + q);
						ots_amt = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_ppt_ots_amt" + q);
						
						sheetObjects["otsRcvPop"].DataInsert(-1);
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_curr_cd") = curr_cd;
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_tot_ots_amt") = ots_amt;
					}	
				}
		    break;
		
		    case 'pop_cct': //pop_cct
				for(var q=1;q<6;q++){
					if (sheetObjects["otsRcvInfo"].CellValue(i, prefix + "cct_ots_amt" + q) > 0) {
						curr_cd = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "cct_ots_curr_cd" + q);
						ots_amt = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "cct_ots_amt" + q);
						
						sheetObjects["otsRcvPop"].DataInsert(-1);
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_curr_cd") = curr_cd;
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_tot_ots_amt") = ots_amt;
					}	
				}
		    break;
		
		    case 'pop_trd_cct': //pop_trd_cct
				for(var q=1;q<6;q++){
				    if (sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
						curr_cd = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
						ots_amt = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_cct_ots_amt" + q);
						
						sheetObjects["otsRcvPop"].DataInsert(-1);
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_curr_cd") = curr_cd;
						sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_tot_ots_amt") = ots_amt;
					}
				}
		    break;
	    }	    
		if (sheetObjects["otsRcvPop"].RowCount > 0) {
	    	var sXml = IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
	        document.form.oaXmlData.value = sXml;
	        // by 신자영 bl자리 제한
			var t_bl_no = ComGetObjValue(formObj.frm_t11sheet1_bl_no);
			if(t_bl_no.length>12){
				ComSetObjValue(formObj.bl_no, t_bl_no.substr(0,12));
			}
	        ComOpenPopup("/hanjin/ESM_BKG_1022.do", 400, 350, "", "1,0", true);
		}
}
/**
 * charge_cd callback 함수 getBKGreturnValue 호출 .<br>
 * @param _val
 */
function getBKGreturnValue(_val,_srcName) { 
	var obj = _val;
	var formObj = document.form;
	try{
		if(obj == null) return;
		if(obj.msg == "OK"){
			if(processStatus(_srcName)){
				ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, '');// 초기화
				ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, '');// 초기화
				doActionIBSheet(sheetObjects['t11sheet1'], document.form, MULTI01);
			}
		}
	}catch(e){
		fnBkgErrorAlert('getBKGreturnValue', e);
	}
}
/**
 * processValidate 이벤트 발생 
 * param :comObj
 */
function processValidate(_action){
	var formObj = document.form;
	var sheetObject1 = sheetObjects['t11sheet1'];

	if(_action == null) return;

	if(
		!(_action == "frm_t11sheet1_bkg_no" 
		|| _action == "frm_t11sheet1_bl_no"
		|| _action == "pop_bl_no"
		)
	){
/*
		if(ComIsEmpty(formObj.frm_t11sheet1_bkg_no.value)){
			ComShowCodeMessage("BKG08019");// 조회를 위한 BKG no가 없습니다.
			return false;
		}
*/	
	}
	
	switch (_action) {
		case "btn_t11Save":
		if(!checkCaProcessing(sheetObject1, document.form)) {
			return false;
		}
		
		// on_board_date 데이터 체크 - Issue Date가 On-board Date보다 이전 이면 Save막음 by 신자영 2010.01.12  
		if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date) && 
			'' != ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) &&
			(ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) < ComGetObjValue(formObj.frm_t11sheet1_on_board_date))){
			ComShowCodeMessage("BKG00476");// Issue Date should be later than
											// On-Board Date.
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_date);
			return; 
		}
		var mnd_cnt  	= ComGetObjValue(formObj.mnd_cnt);
		var rate_cnt  	= ComGetObjValue(formObj.rate_cnt);
		var cntr_cnt  	= ComGetObjValue(formObj.cntr_cnt);
		var cust_cnt  	= ComGetObjValue(formObj.cust_cnt);
		// check box : bl_ready_checkbox
		if (formObj.bl_ready_checkbox.checked) {
			ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "Y");
		} else {
			ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "N");
		}

		if((ComGetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox)== "Y") && 
			(mnd_cnt == 0||rate_cnt == 0||cntr_cnt == 0||mnd_cnt == 0)){
			formObj.bl_ready_checkbox.checked = false
			ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, "");
			ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by, "");
			ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date, "");
			ComSetFocus(formObj.frm_t11sheet1_bl_ready_checkbox);
			ComShowCodeMessage("BKG08145");// "B/L is not completed."
			return false;
			}	
		break;
		case "btn_t11Issue":
			// POD CD 에 따른 Validation
			if(!validateByPodCd("B")) {
				return false;
			}
			
			if(!checkCaProcessing(sheetObject1, document.form)) {
				return false;
			}
		 // 2018.02.27 iylee DEL 이 ID인 경우, on board date와 b/l issue date 가 동일 할 경우 Issue 버튼 활성화
		 if(ComGetObjValue(formObj.frm_t11sheet1_del_code).substr(0,2) == "ID"){
			 var onBoardDate = ComGetObjValue(formObj.frm_t11sheet1_on_board_date).split('-').join("")+"000000";
			 var blIssueDate = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date).split('-').join("")+"000000";
			 if(onBoardDate != blIssueDate){
				 ComShowCodeMessage("BKG95136");
				 return false;
			 }
		 } 							
		//Rate=Y,	M&D=Y, 
		// on_board_date 데이터 체크 - Issue Date가 On-board Date보다 이전 이면 Save막음 by 신자영 2010.01.12  
		if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date) && 
			'' != ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) &&
			(ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) < ComGetObjValue(formObj.frm_t11sheet1_on_board_date))){
			ComShowCodeMessage("BKG00476");// Issue Date should be later than
											// On-Board Date.
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_date);
			return; 
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
			ComShowCodeMessage("BKG08077");// M&D data is not Ready
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
			ComShowCodeMessage("BKG08078");// Rate Data is not Ready
			return false;
		}
		//issue 정보 (AT/BY/DATE_존재여부
		if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_by.value)){
			ComShowCodeMessage("BKG08072");// "B/L Issue information is not
											// ready";
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_by);
			return;
		}
		if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_at.value)){
			ComShowCodeMessage("BKG08072");// "B/L Issue information is not
											// ready";
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_at);
			return;
		}
		if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_date.value)){
			ComShowCodeMessage("BKG08072");// "B/L Issue information is not
											// ready";
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_date);
			return;
		}
		//장수 check 추가 2009.12.17 by cateshin requested by emily
		if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value)|| 0 == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no)){
			ComShowCodeMessage("BKG08109");// Please check No. of B/L
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
			return;
		}
		//issue 정보 (AT/BY/DATE_존재여부
		if ('A' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)||'X' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)||'W' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)) {
			ComShowCodeMessage("BKG08073");// Not allowed to issue for
											// advanced/cancelled booking
			return;
		}
		// on_board_date 데이터 체크 by 신자영  
		if('' == ComTrim(ComGetObjValue(formObj.frm_t11sheet1_on_board_date))){
			ComShowCodeMessage("COM12193","ON BOARD Date");
			ComSetFocus(formObj.frm_t11sheet1_on_board_date);
			return; 
		}
 		// 서미진 [CHM-201217003] on board type 부재시 BL Issue 버튼 Disable
		if	(formObj.on_board_type.Code==""){
			ComShowCodeMessage("BKG08223");
			return; 
		}
		//[CHM-201641353]  B/L Issue & Onboard Date Update 화면에서 BL ISSUE를 위해 CHECK시 VALIDATION 추가
		//issue validation 추가 (cntr, cust, rate, mnd validation 추가)
		var mnd_cnt  	= ComGetObjValue(formObj.mnd_cnt);
		var rate_cnt  	= ComGetObjValue(formObj.rate_cnt);
		var cntr_cnt  	= ComGetObjValue(formObj.cntr_cnt);
		var cust_cnt  	= ComGetObjValue(formObj.cust_cnt);
		
		if(mnd_cnt == 0){
			ComShowMessage(ComGetMsg("BKG95113","M&D"));// {?msg1} information is not filled properly
			return false;
		}else if(rate_cnt == 0)	{
			ComShowMessage(ComGetMsg("BKG95113","Rate"));// {?msg1} information is not filled properly
			return false;
		}else if(cntr_cnt ==0) {
			ComShowMessage(ComGetMsg("BKG95113","Container"));// {?msg1} information is not filled properly
			return false;
		}else if(cust_cnt == 0) {
			ComShowMessage(ComGetMsg("BKG95113","Customer"));// {?msg1} information is not filled properly
			return false;
		}
		break;
		case "btn_t11InternetAUTH":
			if(!fnBlNotReady()){   return;}
		//Rate=Y,	M&D=Y, 운임회수=Y
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
			ComShowCodeMessage("BKG08078"); 
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
			ComShowCodeMessage("BKG08077");
			return false;
		}
		if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
			||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_trd_flg_ppd))) {
			ComShowCodeMessage("BKG08079");
			return false;
		}		
		if (!ComIsEmpty(formObj.frm_t11sheet1_do_issue_date.value)&& 'L' != ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)) {
			ComShowCodeMessage("BKG00434");
			return false;
		}
		//20091130 OBL release와 동일 validation추가 by jy.shin
		if(!fnExistBlackListedCustomer()){
			//return false; // 경고표시만 하고 진행하도록 수정
		}
		// date가 null인  경우는  비교하지말것 
		if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
			if(
				('L' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	|| 'S' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type))
				&&	
				(ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )
			) {
					if (!ComShowConfirm(ComGetMsg("BKG00467"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
							return false;
					}
				}
			else if(		
				'R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	
				&&	
				(ComGetObjValue(formObj.frm_t11sheet1_cgo_rcv_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )				
			){
				if (!ComShowConfirm(ComGetMsg("BKG08137"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
						return false;
				}
			}
		}
		//장수 check 추가 2009.12.23 by cateshin requested by emily
		if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value) || '0' == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no)){
			ComShowCodeMessage("BKG08109");// Please check No. of B/L
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
			return false;
		}
		
		break;
		
		case "btn_t11OBLRelease": 
		if(!checkCaProcessing(sheetObject1, document.form)) {
			return false;
		}
		
		if(!fnBlNotReady()){   return;}
		//Rate=Y,	M&D=Y, 운임회수=Y
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
			ComShowCodeMessage("BKG08078"); 
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
			ComShowCodeMessage("BKG08077");
			return false;
		}
		if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
			||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_trd_flg_ppd))) {
			ComShowCodeMessage("BKG08079") 
			return false;
		}
		if(!fnExistBlackListedCustomer()){
			//return false; // 경고표시만 하고 진행하도록 수정
		}
		// date가 null인  경우는  비교하지말것 
		if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
			if(
				('L' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	|| 'S' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type))
				&&	
				(ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )
			) {
					if (!ComShowConfirm(ComGetMsg("BKG00467"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
							return false;
					}
				}
			else if(		
				'R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	
				&&	
				(ComGetObjValue(formObj.frm_t11sheet1_cgo_rcv_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )				
			){
				if (!ComShowConfirm(ComGetMsg("BKG08137"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
						return false;
				}
			}
		}
		//장수 check 추가 2009.12.23 by cateshin requested by emily
		if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value) || '0' == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no)){
			ComShowCodeMessage("BKG08109");// Please check No. of B/L
			ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
			return false;
		}		
		break;
		case "btn_t11CancelRelease":
			
		// 1차 :CHG_READY = 0 or MK_READY = 0 이면 ERROR
		var chg_ready  	= ComGetObjValue(formObj.chg_ready);
		var mk_ready  	= ComGetObjValue(formObj.mk_ready);
// if(chg_ready == 0 || mk_ready == 0){
// ComShowCodeMessage("BKG08066");// "B/L is not Ready.";
// return false;
// }
		// Issue=Y,
// if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_issued)) {
// ComShowCodeMessage("BKG08080");
// return false;
// }

		break;
		case "btn_t11SWBRelease": 
			// POD CD 에 따른 Validation
			if(!validateByPodCd("W")) {
				return false;
			}
			
			if(!checkCaProcessing(sheetObject1, document.form)) {
				return false;
			}
			
			if(!fnBlNotReady()){   return;}
			
		//Doc requirement화면에 SWB RATE조건이나 EMAIL주소가 입력되지 않았을 떄 	
//		if ('' == ComGetObjValue(formObj.frm_t11sheet1_wbl_eml) || '' == ComGetObjValue(formObj.frm_t11sheet1_wbl_rt_tp_cd)) {
//			ComShowCodeMessage("BKG08323"); 
//			return false;
//		}		
		
		//cust_to_ord_flg == Y 이면 release할수 없음  by 신자영
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_cust_to_ord_flg)) {
			ComShowCodeMessage("BKG00469"); 
			return false;
		}	
		//Rate=Y,	M&D=Y, 운임회수=Y
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
			ComShowCodeMessage("BKG08078"); 
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
			ComShowCodeMessage("BKG08077");
			return false;
		}
		if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
			||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_trd_flg_ppd))) {
			ComShowCodeMessage("BKG08079") 
			return false;
		}
		//20091130 OBL release와 동일 validation추가 by jy.shin
		if(!fnExistBlackListedCustomer()){
			//return false; // 경고표시만 하고 진행하도록 수정
		}
		// date가 null인  경우는  비교하지말것 
		if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
			if(
				('L' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	|| 'S' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type))
				&&	
				(ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )
			) {
					if (!ComShowConfirm(ComGetMsg("BKG00467"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
							return false;
					}
				}
			else if(		
				'R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	
				&&	
				(ComGetObjValue(formObj.frm_t11sheet1_cgo_rcv_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )				
			){
				if (!ComShowConfirm(ComGetMsg("BKG08137"))){// On board Date is not same as cargo receiving date. Do you want to continue?";
						return false;
				}
			}
		}
		break;
		case "btn_t11CancelAUTH": 
			if(!fnBlNotReady()){   return;}
		//Issue=Y,Released=Y,
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_issued)) {
			ComShowCodeMessage("BKG08080"); 
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_released)) {
			ComShowCodeMessage("BKG08081"); 
			return false;
		}		
		if ('B' != ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)) {
			ComShowCodeMessage("BKG08082"); 
			return false;
		}
		
		break;
		case "btn_t11OBLSurrender": 
			if(!fnBlNotReady()){   return;}
			
		// POD CD 에 따른 Validation
		if(!validateByPodCd("S")) {
			return false;
		}
		
		//Rate=Y, M&D=Y, 운임회수=Y,Issue=Y,Released=Y
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
			ComShowCodeMessage("BKG08078"); 
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
			ComShowCodeMessage("BKG08077");
			return false;
		}
		if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
			||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_trd_flg_ppd))) {
			ComShowCodeMessage("BKG08079") 
			return false;
		}	
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_issued)) {
			ComShowCodeMessage("BKG08080"); 
			return false;
		}
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_released)) {
			ComShowCodeMessage("BKG08081"); 
			return false;
		}		
		if ('B' != ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)) {
			ComShowCodeMessage("BKG08082"); 
			return false;
		}
		break;
		case "btn_t11OSurrenderCancel":
		//Surrender=Y,
		if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_surrender)) {
			ComShowCodeMessage("BKG08083"); 
			return false;
		}
		break;
	}
	return true;
}
/**
* fnBlNotReady  validation 체크 
* param :comObj
*/
function fnBlNotReady(_check){
	var formObj = document.form;
	
	// 1차 :CHG_READY = 0 or MK_READY = 0 이면 ERROR
	var chg_ready  	= ComGetObjValue(formObj.chg_ready);
	var mk_ready  	= ComGetObjValue(formObj.mk_ready);
	if(chg_ready == 0 || mk_ready == 0){
		ComShowCodeMessage("BKG08066");// "B/L is not Ready.";
		return false;
	}
	var mnd_cnt  	= ComGetObjValue(formObj.mnd_cnt);
	var rate_cnt  	= ComGetObjValue(formObj.rate_cnt);
	var cntr_cnt  	= ComGetObjValue(formObj.cntr_cnt);
	var cust_cnt  	= ComGetObjValue(formObj.cust_cnt);
	// released 되었을 경우만 체크한다.
	if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_released)) {
		//2차 : (if CHG_PPD_IND > 0 & PPD = 'N') or (CHG_PPD_THIRD_IND > 0 & PPD Third = 'N') 이면 ERROR
		// message 내용 : PPD Data is not Ready.
		var chg_ppd_ind  					= ComGetObjValue(formObj.chg_ppd_ind);
		var chg_ppd_third_ind  				= ComGetObjValue(formObj.chg_ppd_third_ind);
		var frm_t11sheet1_ppd_confirm  		= ComGetObjValue(formObj.frm_t11sheet1_ppd_confirm);
		var frm_t11sheet1_trd_ppd_confirm  	= ComGetObjValue(formObj.frm_t11sheet1_trd_ppd_confirm);
		if(( parseInt(chg_ppd_ind)> 0 && frm_t11sheet1_ppd_confirm == 'N') 
		|| ( parseInt(chg_ppd_third_ind) > 0 && frm_t11sheet1_trd_ppd_confirm == 'N')){
			ComShowCodeMessage("BKG08079");// "PPD Data is not Ready.";
			return false;
		}		
	}
	return true;
}
/**
* processStatus 이벤트 발생 
* param :comObj
*/
function processStatus(_action){
	var formObj = document.form;

	switch (_action) {

		case "btn_t11Issue": 
		//B/L type = '' , Issued = Y , Released = N, Internet Auth = N
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');
		ComSetObjValue(formObj.frm_t11sheet1_released, 'N');
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
		
		break;
		case "btn_t11InternetAUTH":
		//B/L type = B , Issued = Y , Released = Y, Internet Auth = Y
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'Y');	
		
		break;
		case "btn_t11CancelAUTH": 
		//B/L type = '' , Issued = N , Released = N, Internet Auth = N
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'N');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'N');	
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
		
		break;
		case "btn_t11OBLRelease": 
		//B/L type = B , Issued = Y , Released = Y, Internet Auth = N
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	

		break;
		case "btn_t11CancelRelease":
		//B/L type = '' , Issued = N , Released = N, Internet Auth = N
/*
 * ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');
 * ComSetObjValue(formObj.frm_t11sheet1_issued, 'N');
 * ComSetObjValue(formObj.frm_t11sheet1_released, 'N');
 * ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');
 */
		break;
		case "btn_t11SWBRelease": 
		//B/L type = W , Issued = Y , Released = Y, Internet Auth = N
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'W');	
		ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'W');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
		ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_no, '0');
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, '0');

		break;
		case "btn_t11OBLSurrender": 
		//B/L type = 'B' , Issued = Y , Released = Y, Surrender = Y
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_surrender, 'Y');	
		
		break;
		case "btn_t11OSurrenderCancel":
		//B/L type = 'B' , Issued = Y , Released = Y, Surrender = N
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_surrender, 'N');	
		
		break;
		case "btn_t11BLPrint":
		//B/L type = 'B' , Issued = Y 
		// ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');
		// ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');
		break;
	}
	//상태에 따른 색상변경 처리 
	setChangeColor();
	return true;
}

/**
* fnBlIssueButton 처리 
* obj으로 체크상태에 따른 액션 수행.
* param : r_obj
*/
function fnBlIssueButton() {
	var formObj = document.form;
	/**
	 * 메뉴 별도경로에서 들어올때 비활성화처리
	 */
	buttonDisabledAll();
	/**
	 * [Issue 버튼 활성 조건] ( 1. Issued = 'N', 2. Released = 'N', 3. not Surrender
	 * (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue)
	 */
	
	 if("N" == ComGetObjValue(formObj.frm_t11sheet1_issued)
	  //&&"N" == ComGetObjValue(formObj.frm_t11sheet1_released)
	  //&&"N" == ComGetObjValue(formObj.frm_t11sheet1_surrender)
	  &&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
	 ){
		 ComBtnEnable("btn_t11Issue");
	 } 
	 
	 // 2018.02.27 iylee DEL 이 ID인 경우, on board date와 b/l issue date 가 동일 할 경우 Issue 버튼 활성화
	 if(ComGetObjValue(formObj.frm_t11sheet1_del_code).substr(0,2) == "ID"){
		 var onBoardDate = ComGetObjValue(formObj.frm_t11sheet1_on_board_date).split('-').join("")+"000000";
		 var blIssueDate = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date).split('-').join("")+"000000";
		 if(onBoardDate == blIssueDate){
			 ComBtnEnable("btn_t11Issue");
		 }
	 }
	/**
	 *[O/BL Release, SWB Release 활성 조건 ]
	 *(1. Issued = 'Y', 2. Released = 'N', 3. not Surrender (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue)
	 */
	 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued)
	  &&"N" == ComGetObjValue(formObj.frm_t11sheet1_released)
	  &&"N" == ComGetObjValue(formObj.frm_t11sheet1_surrender)
	  &&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
	 ){
		 ComBtnEnable("btn_t11OBLRelease");
		 /**
		  * 로직추가 - O.B/L printed flag가 Y이면 SWB Release 버튼 비활성화
		  */
		 if('Y'!=document.form.frm_t11sheet1_obl_prn_flg.value)
			 ComBtnEnable("btn_t11SWBRelease");
		 		 
	 	/**
		 * [Internet Auth 활성 조건] ( 1. Issued = 'Y', 2. BKG_BL_ISS.OBL_INET_FLG =
		 * 'N', 3. BKG_INET_AUTH에 USR_ID가 접속한 ID로 데이터 존재)
		 */
		 if("N" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)
			&&"Y" == ComGetObjValue(formObj.frm_t11sheet1_auth_flag)
		 ){
				eval('DIV_btn_t11InternetAUTH').style.display = 'block';
				eval('DIV_btn_t11CancelAUTH').style.display = 'none';
				ComBtnEnable("btn_t11InternetAUTH");
				var obj =  document.getElementById('web_print_approved');
				obj.innerHTML = '';
		 }		 
	 }
		
	/**
	 * [Cancel Release,  활성 조건 ]
	 * ( 1. Issued = 'Y' or 2. Released = 'Y' , 4. DO not Issue) 
	 */
	 if( ("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued)|| "Y" == ComGetObjValue(formObj.frm_t11sheet1_released))
		&&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do) ||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
	 ){
		 ComBtnEnable("btn_t11CancelRelease");
		 
		 // [기능추가] btn_t11CancelAUTH 추가
		 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)
			&&"Y" == ComGetObjValue(formObj.frm_t11sheet1_auth_flag)
		  ){
				eval('DIV_btn_t11InternetAUTH').style.display = 'none';
				eval('DIV_btn_t11CancelAUTH').style.display = 'block';
				ComBtnEnable("btn_t11CancelAUTH");
				var obj =  document.getElementById('web_print_approved');
				obj.innerHTML = 'WEB B/L Print Approved'; 
		 }
		 
	 }
	 /**
	 * [O/BL Surrender 활성 조건 ]
	 * ( 1. Issued = 'Y', 2. Released = 'Y', 3. not Surrender (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue) 
	 */
	 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued) && "Y" == ComGetObjValue(formObj.frm_t11sheet1_released)
		&&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))){
		 ComBtnEnable("btn_t11OBLSurrender");
	 }
	
	 //* SWB E-mail	B/L type = 'W'	Released = 'Y'
	if("W" == ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)
		&& "Y" == ComGetObjValue(formObj.frm_t11sheet1_released)){
		ComBtnEnable("btn_t11SWBEmail");
	}
	
	/**
	Surrender = 'Y' or D/O ='Y'
	**/
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)
			&&"L" != ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)
	// || "Y" == ComGetObjValue(formObj.frm_t11sheet1_surrender)
	){
		ComBtnDisable("btn_t11Issue");
		ComBtnDisable("btn_t11InternetAUTH");
		ComBtnDisable("btn_t11OBLRelease");
		ComBtnDisable("btn_t11CancelRelease");
		ComBtnDisable("btn_t11SWBRelease");
		ComBtnDisable("btn_t11OBLSurrender");
	}
	// internet auth가 이미 발생한 경우에는 항상 문구가 보이도록 set
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)){
		var obj =  document.getElementById('web_print_approved');
		obj.innerHTML = 'WEB B/L Print Approved'; 		
	}
	
	//save버튼 처리..jsy
	if(ComGetObjValue(formObj.isInquiry) == "Y"){
		setInquiryDisableButton();
	}
}

/**
 * select_vessel_direction_OnBlur 이벤트 발생 
 * param :comObj
 */
function select_vessel_direction_OnBlur(comObj){
	var formObj = document.form;
	var text = comObj.Text();
	// 콤보값이 변경된 경우
	//if( text != "" && text != comObj.Code)
	if( text != comObj.Code){
		var finded = comObj.FindIndex(comObj.Text() , 0);
		// 1.임시저장소에 저장한다.

		ComSetObjValue(formObj.vessel_direction, text);
		// 2.콤보박스를 다시 구성한다. vessel_direction
		UserComXmlComboItem(arrXml_vessel_direction, formObj.select_vessel_direction, "t11sheet3_name", "t11sheet3_name","vessel_direction");	
		// 3.임시 저장한 값으로 셋팅한다.

		ComSetObjValue(formObj.select_vessel_direction, ComGetObjValue(formObj.vessel_direction));		
	}
}
/**
* select_pre_carriage_by_OnBlur 이벤트 발생 
* param : comObj
*/
function select_pre_carriage_by_OnBlur(comObj){
	var formObj = document.form;
	var text = comObj.Text();
	
	if( text != comObj.Code){
		var finded = comObj.FindIndex(comObj.Text() , 0);
		// 1.임시저장소에 저장한다.
		ComSetObjValue(formObj.pre_carriage_by, text);
		// 2.콤보박스를 다시 구성한다. pre_carriage_by
		UserComXmlComboItem(arrXml_pre_carriage_by, formObj.select_pre_carriage_by, "t11sheet2_name", "t11sheet2_name","pre_carriage_by");
		// 3.임시 저장한 값으로 셋팅한다.
		ComSetObjValue(formObj.select_pre_carriage_by, ComGetObjValue(formObj.pre_carriage_by));
	}
}

function bl_ready_type_OnChange(comObj,index,text){	
	ComSetObjValue(document.form.modify_flag, "Y");
}
function on_board_type_OnChange(comObj,index,text){	
	ComSetObjValue(document.form.modify_flag, "Y");
}
/**
* select_vessel_direction_OnChange 이벤트 발생 
* param :comObj,index,text
*/
function select_vessel_direction_OnChange(comObj,index,text){	
	var formObj = document.form;
	ComSetObjValue(formObj.vessel_direction, text);
	ComSetObjValue(document.form.modify_flag, "Y");
}
/**
* select_pre_carriage_by_OnChange 이벤트 발생 
* param :comObj,index,text
*/
function select_pre_carriage_by_OnChange(comObj,index,text){
	var formObj = document.form;
	ComSetObjValue(formObj.pre_carriage_by, text);
	ComSetObjValue(document.form.modify_flag, "Y");
}

var initFrist = true;
/**
 * ppd_confirm_OnChange OnChange이벤트 발생 param : comObj,index,text
 */
function ppd_confirm_OnChange(comObj,index,text){
	if(initFrist) return;
	var formObj = document.form;
	if(ComGetObjValue(formObj.ppd_confirm) == 'N'){
		ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_user_office, '');
		ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_user_id, '');
		ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_dt	, '');	
	}else{
		if(ComGetObjValue(formObj.frm_t11sheet1_ppd_rcv_user_office) == ''){
			ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_user_office, ComGetObjValue(formObj.strOfc_cd));	
		}
		ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_user_id, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_dt	, ComGetNowInfo());	
	}
	ComSetObjValue(document.form.modify_flag, "Y");
}
/**
 * trd_ppd_confirm_OnChange
 * OnChange이벤트 발생
 * param : comObj,index,text
 */
function trd_ppd_confirm_OnChange(comObj,index,text){
	if(initFrist) return;
	var formObj = document.form;
	if(ComGetObjValue(formObj.trd_ppd_confirm) == 'N'){
		ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_user_office, '');
		ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_user_id, '');
		ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_dt	, '');	
	}else{
		if(ComGetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_user_office) == ''){
			ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_user_office, ComGetObjValue(formObj.strOfc_cd));	
		}
		
		ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_user_id, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_dt	, ComGetNowInfo());	
	}
	ComSetObjValue(document.form.modify_flag, "Y");
}
/**
 * cct_confirm_OnChange
 * OnChange이벤트 발생
 * param : comObj,index,text
 */
function cct_confirm_OnChange(comObj,index,text){
	if(initFrist) return;
	var formObj = document.form;
	if(ComGetObjValue(formObj.cct_confirm) == 'N'){
		ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_user_office, '');
		ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_user_id, '');
		ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_dt	, '');	
	}else{
		if(ComGetObjValue(formObj.frm_t11sheet1_cct_rcv_user_office) == ''){
			ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_user_office, ComGetObjValue(formObj.strOfc_cd));	
		}
		ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_user_id, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_dt	, ComGetNowInfo());	
	}
	ComSetObjValue(document.form.modify_flag, "Y");
}
/**
 * trd_cct_confirm_OnChange
 * OnChange이벤트 발생
 * param : comObj,index,text
 */
function trd_cct_confirm_OnChange(comObj,index,text){
	if(initFrist) return;
	var formObj = document.form;
	if(ComGetObjValue(formObj.trd_cct_confirm) == 'N'){
		ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_user_office, '');
		ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_user_id, '');
		ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_dt	, '');	
	}else{
		if(ComGetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_user_office) == ''){
			ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_user_office, ComGetObjValue(formObj.strOfc_cd));	
		}
		ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_user_id, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_dt	, ComGetNowInfo());	
	}
	ComSetObjValue(document.form.modify_flag, "Y");
}

//pol, pod 바뀌었을 때 histoty 관리를 위해서 onchange 메소드 이용 code입력 시 name이 바로 나오게 수정 
function form_onChange(){ 
  	var srcName = window.event.srcElement.getAttribute("name");
  	var srcValue = window.event.srcElement.getAttribute("value");
	var formObject = document.form; 
 	if(srcName == "frm_t11sheet1_pol_code"){
 		fnSearchMdmLocName('pol');
 	} else if(srcName == "frm_t11sheet1_pod_code"){
 		fnSearchMdmLocName('pod');
 	}
}

/**
* UserComXmlComboItem 이벤트 발생 
* param : xmlStr, cmbObj, codeCol, textCol, typeValue
*/
var isExist = false;
function UserComXmlComboItem(xmlStr, cmbObj, codeCol, textCol, typeValue) {
	if (xmlStr == null || codeCol == "" || cmbObj == null || textCol == "") {
		return;
	}
	try {
		cmbObj.RemoveAll();
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}
		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) { return;	}
		var colListIdx = Array();
		var arrText = textCol.split("|");
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;// 동일코드
			}
			for ( var j = 0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j + 1] = i;// 동일텍스트
				}
			}
		}
		//비교값을 임시로 저장한다. 
		var compareValue = ComGetObjValue(eval('document.form.'+typeValue));
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			var item = "";
			var tempItem ="";
			for ( var j = 1; j < colListIdx.length; j++) {
				tempItem = arrData[colListIdx[j]];
				// 비교한다.
				if(tempItem == compareValue){
					isExist = true;
				}else{
					isExist = false;
				}
				item += tempItem;
				if (j < colListIdx.length - 1) {
					item += "|";
				}
			}
			cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
			// 변수값이랑 동일하면 true
		}
		// 추가 가능한 item인경우 
		if(!isExist){
			cmbObj.InsertItem(dataChildNodes.length, compareValue, compareValue);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return true;
}

var arrXml_vessel_direction;
var arrXml_pre_carriage_by ;

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = 1;
	var formObj = document.form;
	initFrist=true;// 초기검색 변경 여부
	var State ;
	var aryPrefix = new Array(prefix1,prefix2, prefix3,prefix4,prefix5);
	
	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}
	
	switch (sAction) {		
		
	case IBSEARCH: //조회
		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCH);
		document.form.frm_t11sheet1_bkg_sts.style.color = '';
		document.getElementById('btn_t11Doc_Requirement').style.color="";
		
		var obj =  document.getElementById('web_print_approved');
		obj.innerHTML = '';    
		
		//save 버튼 dis 처리 jsy
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
			setInquiryDisableButton();
		}
		try{
			parent.initCAControl("", "N", "N", "N", "");
		}catch(e){}
		
		try{
			ComOpenWait(true); // 대기창 보임
	
			// 2.조회조건으로 조회실행
			var parm   = "f_cmd=" 				+ SEARCH 
						+ "&bkg_no=" 			+ formObj.bkg_no.value
						+ "&bl_no=" 			+ formObj.bl_no.value 
						+ "&setupfocoblflag" 	+ formObj.setupfocoblflag.value;	
			var sXml   = sheetObj.GetSearchXml(URL_ESM_BKG, parm + "&" + ComGetPrefixParam(aryPrefix));
			// fnClearForm();
		
			// 3.조회후 결과처리
			var arrXml = sXml.split("|$$|");
	
			var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
			if ( State == "S" ) {
				// form_text
				sheetObjects['t11sheet1'].LoadSearchXml(arrXml[0]);
				// pre_carriage_by
				arrXml_pre_carriage_by = arrXml[1];
				// vessel_direction
				arrXml_vessel_direction = arrXml[2];
				// ots_rcv_info
				sheetObjects['otsRcvInfo'].LoadSearchXml(arrXml[3]);
				
				// 값이없을경우
				if(arrXml_pre_carriage_by.length == '45'){
					arrXml_pre_carriage_by = "<SHEET><DATA COLORDER='t11sheet2_val|t11sheet2_ibflag|t11sheet2_desc|t11sheet2_name|t11sheet2_comboCd|t11sheet2_pagerows|' COLSEPARATOR='☜☞' TOTAL='0'></DATA></SHEET>";
				}
	
				UserComXmlComboItem(arrXml_pre_carriage_by, formObj.select_pre_carriage_by, "t11sheet2_name", "t11sheet2_name","frm_t11sheet1_pre_carriage_by");
				UserComXmlComboItem(arrXml_vessel_direction, formObj.select_vessel_direction, "t11sheet3_name", "t11sheet3_name","frm_t11sheet1_vessel_direction");
				// select box : vessel_direction / pre_carriage_by
				ComSetObjValue(formObj.select_vessel_direction, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_vessel_direction), ""));		
				ComSetObjValue(formObj.select_pre_carriage_by, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_pre_carriage_by), ""));
				// hidden value :
				ComSetObjValue(formObj.vessel_direction, ComGetObjValue(formObj.frm_t11sheet1_vessel_direction));
				ComSetObjValue(formObj.pre_carriage_by, ComGetObjValue(formObj.frm_t11sheet1_pre_carriage_by));
	
				// vesselVoyageDirectionEqual 추가 - by 전성진
				if('F' == ComGetEtcData(arrXml[0], "vesselVoyageDirectionEqual")){
					comboObjects[0].FontColor = "red"; // 다를경우 색상변경처리
				}else{
					comboObjects[0].FontColor = "gray"; 
				}
	
				// TPB Status 추가
		        if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
		            document.getElementById("tpb_status").value = ComGetEtcData(arrXml[0], "tpbStatus");
		            tpbImgSet(document.getElementById("tpb_status").value);
		        }
		        // docReqButton 추가 
		        if("Y" == ComGetEtcData(arrXml[0], "docReqButton")){
		    		//Doc_Requirement에 값이 존재하면 빨간색으로 나오게한다.
		    		document.getElementById('btn_t11Doc_Requirement').style.color="blue";
		        }else{
		        	document.getElementById('btn_t11Doc_Requirement').style.color="";
		        }
		        ComBtnDisable("btn_t11ISSNOTE");
		        // blNoteButton 추가 
		        if("Y" == ComGetEtcData(arrXml[0], "blNoteButton")){
		    		ComBtnEnable("btn_t11ISSNOTE");
		    		document.getElementById('btn_t11ISSNOTE').style.color="blue";
		        }else{
		        	document.getElementById('btn_t11ISSNOTE').style.color="#c0c0c0";
		        	ComBtnDisable("btn_t11ISSNOTE");
		        }
		        // 3rd Party B/L Request 추가 
				var output_text1 = ComGetEtcData(arrXml[0], "output_text");
				if ('A' == output_text1) {
					document.getElementById('btn_t103rdBLReq').style.color = "blue";
				} else if ('X' == output_text1) {
					document.getElementById('btn_t103rdBLReq').style.color = "red";
				} else if ('R' == output_text1) {
					document.getElementById('btn_t103rdBLReq').style.color = "gold";
				} else {
					document.getElementById('btn_t103rdBLReq').style.color = "gray";
				}
				
		        // Remark 추가
		        chkRemark();
		        // blNoReady 체크 로직 추가  BY 신자영
		        var blNoReady = ComGetEtcData(arrXml[0], "blNoReady");
		    	var ready_val = blNoReady.split("|");
		    	ComSetObjValue(formObj.chg_ready, ready_val[0]);
		    	ComSetObjValue(formObj.mk_ready, ready_val[1]);
		    	ComSetObjValue(formObj.chg_ppd_ind, ready_val[2]);
		    	ComSetObjValue(formObj.chg_ppd_third_ind, ready_val[3]);
		    	ComSetObjValue(formObj.mnd_cnt, ready_val[4]);
		    	ComSetObjValue(formObj.rate_cnt, ready_val[5]);
		    	ComSetObjValue(formObj.cntr_cnt, ready_val[6]);
		    	ComSetObjValue(formObj.cust_cnt, ready_val[7]);
		    	
		    	ComSetObjValue(formObj.caflag			, ComGetEtcData(arrXml[0], "caflag"));
				ComSetObjValue(formObj.bdrflag			, ComGetEtcData(arrXml[0], "bdrflag"));
				ComSetObjValue(formObj.ca_exist_flg		, ComGetEtcData(arrXml[0], "ca_exist_flg"));
				ComSetObjValue(formObj.old_bkg_no		, ComGetEtcData(arrXml[0], "bkg_no"));
				try{
					// C/A 버튼 Control 
					parent.initCAControl(ComGetObjValue(formObj.bkg_no),ComGetObjValue(formObj.caflag),	ComGetObjValue(formObj.bdrflag),ComGetObjValue(formObj.ca_exist_flg),ComGetObjValue(formObj.bl_no));
					fnOblInterSerNo(sheetObj, formObj, 'B', ComGetEtcData(arrXml[0], "bkg_no"));
				}catch(e){}
				
			}else{
				// Error Msg Print
				ComShowMessage(ComResultMessage(sXml));
				
				//fnExceptionMessage(sXml);
				
				var tmpBkgNo = formObj.bkg_no.value;
				// Screen init
				ComResetAll();
				formObj.frm_t11sheet1_bkg_no.value = tmpBkgNo;
			}
		}catch(e){
		}finally{
			ComOpenWait(false); // 대기창 사라짐
		}
    	
    	//save버튼 dis 처리 jsy
    	if(ComGetObjValue(formObj.isInquiry) == "Y"){
    		setInquiryDisableButton();
    	}
		fnOnSearchEnd();
		ComSetFocus(formObj.frm_t11sheet1_bkg_no);
    	
		break;

	case IBSAVE: //저장
	
		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, MULTI);
		SetSaveData(sheetObj, formObj);
		// 2.저장조건으로 실행
		var sParam = ComGetSaveString(sheetObjects['t11sheet1']); // 변경된//
																	// sheet문자열

		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix 문자열 배열
		if (!ComShowConfirm(ComGetMsg("BKG00350"))) {//"Do you want to Save your Changes?";
			return;
		}
		ComOpenWait(true); // 대기창 보임
		// 2.저장처리
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		// 3.저장후 결과처리
		State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveXml(sXml);
		}else{
//			fnExceptionMessage(sXml);
			ComShowMessage(ComResultMessage(sXml));
		}
		if(tab_alert_msg){// TAB 이동시에 조회방지
			doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		}
		break;
	
	// [Internet AUTH] btn_t11InternetAUTH
	case MULTI01:
		ComOpenWait(true); // 대기창 보임
		var srcName = window.event.srcElement.getAttribute("name");
		// LBP Check..
		// lbpApplyFlg => Issue시 반영되도록 변경
		
		if(formObj.frm_t11sheet1_ppd_confirm.value !="C"){
		 if(lbpApplyFlg=='Y'){     
		   if(formObj.strOfc_cd.value=="SELSC" || formObj.strOfc_cd.value=="PUSSC" ||  formObj.strOfc_cd.value=="FXTSC" ||  formObj.strOfc_cd.value=="SINSC"){ 
			//2012.01.19 조원주 Login OFC : ‘PUSSC’ 추가, 2012.07.11 이준근 Login OFC : ‘FXTSC’ 추가
				var prefix="lbpInfo_";
				//SELSC 일때 LBP 적용 여부를 hidden sheet 에 조회 결과 가져옴 2011.12.23 조원주

				formObj.f_cmd.value = SEARCH01;
			    var sheetObjL = sheetObjects['lbpInfo'];
			    
		        var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_09GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("lbpInfo_"));
		        sheetObjects['lbpInfo'].LoadSearchXml(rXml, false);

		        
		        var currCd =sheetObjL.CellValue(1, prefix+"curr_cd");
		        var scgAmt =sheetObjL.CellValue(1, prefix+"scg_amt");
				
				//hidden sheet에 조회된 apply_flg가 Y일때 LBP를 적용할 것인지 메시지를 띄운후
				//LBP적용 및 저장
				if ((sheetObjL.CellValue(1, prefix+"apply_flg")=="Y")&&(lbpApplyFlg=='Y')){
					if(confirm(ComGetMsg("BKG02105", currCd, scgAmt))){
						formObj.lbpFlg.value = 'Y';
						
					}else {
						// No 를 선택하더라도 우선 I/F하고, Exemption Request 화면을 통해 면제요청을 하도록 한다.
						// 저장 이후  BCC(OBS, LBP) Exemption Request 팝업을 열어줌.
						// 단, -	POR/POL country가 US 이거나, POD/DEL Country가 US인 경우 제외
						
						var input_text = ComGetObjValue(formObj.bkg_no);
					 	var param = param + "&f_cmd=" + COMMAND17 + "&input_text=" + input_text;
					 	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
					 	var por_cnt_cd = ComGetEtcData(sXml, "por_cnt_cd");
					 	var pol_cnt_cd = ComGetEtcData(sXml, "pol_cnt_cd");
					 	var pod_cnt_cd = ComGetEtcData(sXml, "pod_cnt_cd");
					 	var del_cnt_cd = ComGetEtcData(sXml, "del_cnt_cd");
					 	if((por_cnt_cd == 'US' || pol_cnt_cd == 'US' || pod_cnt_cd == 'US' || del_cnt_cd == 'US') 
					 			|| formObj.strOfc_cd.value == "SELSC" || formObj.strOfc_cd.value == "PUSSC"){
					 		formObj.lbpFlg.value = 'N';
					 	} else {
					 		formObj.lbpFlg.value = 'Y';
							chgExpRqst = 'Y';
					 	}
												
					}
					
				}			    
			}else{
				formObj.lbpFlg.value = 'N';
			}
	      }
		}
		
		
		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, MULTI01);
		// 화면값 셋팅
		SetSaveData(sheetObj, formObj);
		// 2.저장조건으로 실행
		
		var sParam = ComGetSaveString(sheetObjects['t11sheet1']); // 변경된
																	// sheet문자열
		var sParam2 = ComGetSaveString(sheetObjects['lbpInfo'],true,true);
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix 문자열 배열
		sParam2 += "&" + ComGetPrefixParam(prefix5);// prefix 문자열 배열
		sParam += sParam2;

		
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		
		
		// 3.저장후 결과처리
		 State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveXml(sXml);
			
		}else{
			//fnExceptionMessage(sXml);
			ComShowMessage(ComResultMessage(sXml));
		}
		doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		
		lbpApplyFlg='N';
		formObj.lbpFlg.value = 'N';
		
		
		// LBP Charge 면제요청을 위한 팝업 오픈
		if(chgExpRqst == 'Y'){

			var formObj = document.form;
			var _Width = '449';
			var _Height = '460';
			var pgmNo = "&pgmNo=ESM_BKG_1600";
			var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)+"&chg_cd=LBP" ;
			var url = "ESM_BKG_1600.do?" + param + pgmNo;
			ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
			chgExpRqst = 'N'
			
		}
		
		break;
        
	// [O/BL Release] btn_t11OBLRelease
	case COMMAND02:
		ComOpenWait(true); // 대기창 보임
		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, MULTI01);
		// 화면값 셋팅
		SetSaveData(sheetObj, formObj);
		// 2.저장조건으로 실행
		var sParam = ComGetSaveString(sheetObjects['t11sheet1']); // 변경된
																	// sheet문자열
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix 문자열 배열

		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		// 3.저장후 결과처리
		 State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveXml(sXml);
			doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		}else{
			fnExceptionMessage(sXml);
		}
		
		break;

	
	case COMMAND03:
		formObj.f_cmd.value = COMMAND03;
		var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t11sheet1_bkg_no);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
	 	var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
	 	bkgSplitNoListPop(formObj.frm_t11sheet1_bkg_no,bkg_split_no_list,-15); 
		break;

	// [Cancel Release] btn_t11CancelRelease
	case COMMAND04:
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.			
		ComSetObjValue(formObj.f_cmd, MULTI01);
		// 화면값 셋팅
		SetSaveData(sheetObj, formObj);
		// 2.저장조건으로 실행
		var sParam = ComGetSaveString(sheetObjects['t11sheet1']); // 변경된
																	// sheet문자열
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix 문자열 배열
		if (!ComShowConfirm(ComGetMsg("BKG00498"))) {
			return;
		}
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		// 3.저장후 결과처리
		 State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveXml(sXml);
			doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		}else{
			fnExceptionMessage(sXml);
		}
		break;
	}	
	// 버튼설정 
	if ( State == "S" ) {	
		fnBlIssueButton() ;
		State='';
	}

	ComSetObjValue(document.form.modify_flag, "N");
	ComOpenWait(false); // 대기창 사라짐
}

/**
 * 조회완료시
 */  
 function fnOnSearchEnd(sheetObj, ErrMsg) {
	changeEnabledDisabled(false);
 }
 
 /**
 * changeEnabled : all disabled 제어
 */ 
 function changeEnabledDisabled(bFlag) {
 	var formObj = document.form;
 	with(formObj) {
 			ComEnableManyIBCombo(bFlag, cct_confirm);		
 	 		ComEnableManyObjects_loc(bFlag, frm_t11sheet1_cct_rcv_user_office);
 	 		ComEnableManyIBCombo(true, trd_cct_confirm);		
 	 		ComEnableManyObjects_loc(true, frm_t11sheet1_trd_cct_rcv_user_office);
 	}
 }
 /**
  * ComEnableManyIBCombo 일괄 Enable/Disable 처리  
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
  * ComEnableManyObjects_loc 일괄 Enable/Disable 처리  
  */
 function ComEnableManyObjects_loc(bEnable, objs) {
 	try {
 	    var args = arguments;
 	    if (args.length < 2) return;
 	    for(var i=1; i<args.length; i++) {
 		if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
 	    }
 	} catch(err) { ComFuncErrMsg(err.message); }
 }
 /**
  * ComEnableObject_loc 일괄 Enable/Disable 처리  
  */   
 function ComEnableObject_loc(obj, bEnable){
	 try {
	 //disabled나 readOnly 설정하기
	   switch( obj.type ) {
	 	case "password" :
	 	case "text" :
	 		obj.readOnly = !bEnable;
	 	    break;
	 	default:
	 	    obj.disabled = !bEnable;
	   }
	
	 //설정에 따라 css 처리하기
	  switch( obj.type ) {
	 	case "select-one" :
	 	case "text" :
	 	    if (bEnable){
		 		if (obj.className=="input2_2"){		//회색바탕 - 필수입력
		 			obj.className = "input1";	// 흰색바탕 - 필수입력
		 		} else if (obj.className=="input2"){	//흰색 입력바탕
		 			obj.className = "input";	// 흰색바탕
		 		}
	 	    } else {
		 		if (obj.className=="input1"){		//필수 입력바탕
		 			obj.className = "input2_2";	// 회색바탕
		 		} else if (obj.className=="input"){	//흰색 입력바탕
		 			obj.className = "input2";	// 회색바탕
		 		} else if (obj.className=="noinput"){	//흰색 입력바탕
		 			obj.className = "noinput2";	// 회색바탕
		 		}
	 	    }
	 	    break;
	 	case "textarea":
	 	    if (bEnable){
	 		obj.className = "textarea";
	 	    } else {
	 		obj.className = "textarea2";
	 	    }
	 	    break;
	 	default :
	 	    if (obj.tagName=="IMG" || obj.tagName=="img") {
	 		if (bEnable){
	 		    obj.style.cursor = "hand";
	 		    obj.style.filter="";
	 		} else {
	 		    obj.style.cursor = "default";
	 		    obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
	 		}
	 	    }
	     }
	 } catch(err) { ComFuncErrMsg(err.message); }
 }
 
  /** 
   * (특정)콤보 배경색 변경 
   */
   function setComboBackColor(comboObj) {
   	if ("" != comboObj.Text) {
		comboObj.BackColor = "#E8E7EC"; 
		//comboObj.fontcolor = "#ffffff";
	} else {
		comboObj.BackColor = "#ffffff";
		comboObj.fontcolor = "#606060";
	} 
   }
   
/**
* 화면 폼입력값에 대한 데이터 셋팅 
*/
function SetSaveData(sheetObj, formObj) {
	//select box :  ppd_confirm 
	ComSetObjValue(formObj.frm_t11sheet1_ppd_confirm, ComGetObjValue(formObj.ppd_confirm));

	// select box : trd_ppd_confirm
	ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_confirm, ComGetObjValue(formObj.trd_ppd_confirm));

	// select box : cct_confirm
	ComSetObjValue(formObj.frm_t11sheet1_cct_confirm, ComGetObjValue(formObj.cct_confirm));

	// select box : trd_cct_confirm
	ComSetObjValue(formObj.frm_t11sheet1_trd_cct_confirm, ComGetObjValue(formObj.trd_cct_confirm));

	// check box : frm_t11sheet1_bdr
	if (formObj.check_bdr.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bdr, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bdr, "N");
	}
	// check box :  bl_ready_checkbox
	if (formObj.bl_ready_checkbox.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "N");
	}
	// check box :  bl_proofbyshipper_checkbox
	if (formObj.bl_proofbyshipper_checkbox.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_checkbox, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_checkbox, "N");
	}
	// check box :  bl_hld_flg 체크박스
	if (formObj.bl_hld_flg.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bl_hld_flg, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_hld_flg, "N");
	}
	
	// 1.저장변수  
	ComSetObjValue(formObj.frm_t11sheet1_vessel_direction	, ComGetObjValue(formObj.vessel_direction));
	ComSetObjValue(formObj.frm_t11sheet1_pre_carriage_by	, ComGetObjValue(formObj.pre_carriage_by));
	ComSetObjValue(formObj.frm_t11sheet1_on_board_type		, ComGetObjValue(formObj.on_board_type));
	ComSetObjValue(formObj.frm_t11sheet1_bl_ready_type		, ComGetObjValue(formObj.bl_ready_type));
	ComSetObjValue(formObj.frm_t11sheet1_bl_hld_rsn_cd		, ComGetObjValue(formObj.bl_hld_rsn_cd));

	// 2.저장변수 셋팅
	if (IBS_CopyFormToRow(formObj, sheetObjects['t11sheet1'], 1, "frm_")) {};

	// 3. 날짜변수 구분자 제거
	sheetObj.CellValue2(1, prefix1 + "bl_issue_date") = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date).split('-').join("")+"000000";
	sheetObj.CellValue2(1, prefix1 + "bl_proofbyshipper_date") = ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date).split('-').join("")+"000000";
	sheetObj.CellValue2(1, prefix1 + "on_board_date") = ComGetObjValue(formObj.frm_t11sheet1_on_board_date).split('-').join("")+"000000";
	sheetObj.CellValue2(1, prefix1 + "bl_ready_date") = ComGetObjValue(formObj.frm_t11sheet1_bl_ready_date).split('-').join("")+"000000";
	sheetObj.CellValue2(1, prefix1 + "bl_hld_dt") = ComGetObjValue(formObj.frm_t11sheet1_bl_hld_dt).split('-').join("")+"000000";
	return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	 var bkgNo = formObj.bkg_no.value;
	/* 
	 * Script 공통
	 4. [Retrieve 제외]BKG Status 확인
	 5. [Retrieve 제외]D/O 여부 확인
	 6. [Retrieve 제외]조회한 BKG와 변경하려는 BKG no 체크

	 <EXCEPTION>
	 4.a 'X' 또는 'A'인 BKG 일 경우 메시지 [BKG00879] 표시 후 리턴
	 5.a D/O 발행 이후면 메세지 [BKG00434] 표시 후 리턴
	 6.a 다른 No로 변경하려 할 경우 메시지 [BKG00048] 표시 후 리턴"
	 */

	switch (sAction) {
	
	case IBSEARCH: // search   
	
		if (ComGetObjValue(formObj.frm_t11sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_t11sheet1_bl_no) == '') {
			//ComShowCodeMessage("BKG00425");
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			return false;
		}
		ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t11sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t11sheet1_bl_no));
		formObj.IssuerSet_checkbox.checked = false;	// 초기화
		formObj.date_set_checkbox.checked = false;	// 초기화
		break;
		
	case IBSAVE: // save
		/*
		 * 1. Script 공통 참조 4. Straight BKG의 B/L Issue Type 확인 6. ISSUE DATE와 ON
		 * BOARD DATE 비교 <EXCEPTION> 4.a 'W' 일 경우 메시지 [BKG00474] 표시 후 리턴 6.a
		 * ISSUE DATE가 ON BOARD DATE보다 이전 DATE인 경우 메시지 [BKG00476] 표시 후 리턴
		 */
		
	   if(""!= ComGetObjValue(formObj.old_bkg_no) && ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
			ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			return false;    				
		}
	
		if (ComGetObjValue(formObj.bkg_no) == '' && ComGetObjValue(formObj.bl_no) == '') {
			if(tab_alert_msg){
				ComShowCodeMessage("BKG00425");
			}
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			return false;
		}
	 
		if(ComGetObjValue(formObj.frm_t11sheet1_bkg_no) != ComGetObjValue(formObj.bkg_no)
		|| ComGetObjValue(formObj.frm_t11sheet1_bl_no) != ComGetObjValue(formObj.bl_no)	
		){
			if(tab_alert_msg){
				ComShowCodeMessage("BKG01053");
			}
			return false;
		}
		/** by 신자영. 해제요청 
		if ('W' == ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)) {
			if(tab_alert_msg){
				ComShowCodeMessage("BKG00474");
			}
			return false;
		}
		 */
		/*
		 * var on_board_date =
		 * ComGetObjValue(formObj.frm_t11sheet1_on_board_date).split('-').join("");
		 * var issue_date =
		 * ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date).split('-').join("");
		 * if(issue_date.length > 0){ if (issue_date < on_board_date) {
		 * ComShowCodeMessage("BKG00476"); return false; } }
		 */
		 
		 //Issue 후 ON BOARD DATE는 Mandatory 처리
		 if(ComGetObjValue(formObj.frm_t11sheet1_issued) =='Y' && ComTrim(ComGetObjValue(formObj.frm_t11sheet1_on_board_date)) == ''){
			 ComShowCodeMessage('BKG08271');
			 return false;
		 }
		
		 
		break;

	case MULTI01: //  
		/*
		 * "1. Script 공통 참조 2. Black Customer Flag가 'Y'일 경우 메시지 [BKG01036] 표시 3.
		 * On-Board type이 'L' or 'S' 일때 On-Board Date와 Vessel ETA or ETD at POL
		 * Date 확인 4. On-Board type이 'R' 일때 Rate Cargo Receiving Date 확인 5. B/L
		 * data 작성 여부(M&D 및 Rate) 및 PPD 운임회수 확인 6. 변경된 정보가 있을 경우 저장 호출
		 * 
		 * <EXCEPTION> 3.a On-Board Date와 SKD Date가 다를 경우 메시지 [BKG00467] 표시(단순
		 * 경고메세지) 4.a On-Board Date와 CRD가 다를 경우 메시지 [BKG00468] 표시(단순 경고메세지) 5.a
		 * 작성완료 되지 않은 경우 메세지 [BKG00470] 표시 후 리턴"
		 * 
		 */

		break;
	case COMMAND02: // [O/BL Release]  btn_t11OBLRelease   
		/*
		 * "1. Script 공통 참조 2. Black Customer Flag가 'Y'일 경우 메시지 [BKG01036] 표시 3.
		 * On-Board type이 'L' or 'S' 일때 On-Board Date와 Vessel ETA or ETD at POL
		 * Date 확인 4. On-Board type이 'R' 일때 Rate Cargo Receiving Date 확인 5. B/L
		 * data 작성 여부(M&D 및 Rate) 및 PPD 운임회수 확인 6. 변경된 정보가 있을 경우 저장 호출
		 * 
		 * <EXCEPTION> 3.a On-Board Date와 SKD Date가 다를 경우 메시지 [BKG00467] 표시(단순
		 * 경고메세지) 4.a On-Board Date와 CRD가 다를 경우 메시지 [BKG00468] 표시(단순 경고메세지) 5.a
		 * 작성완료 되지 않은 경우 메세지 [BKG00470] 표시 후 리턴"
		 */

		break;
	case COMMAND03: // [SWB Release]  btn_t11SWBRelease   
		/*
		 * "1. Script 공통 참조 2. Black Customer Flag가 'Y'일 경우 메시지 [BKG01036] 표시 3.
		 * On-Board type이 'L' or 'S' 일때 On-Board Date와 Vessel ETA or ETD at POL
		 * Date 확인 4. On-Board type이 'R' 일때 Rate Cargo Receiving Date 확인 5. No를
		 * 0으로 설정, B/L Issue type을 'W'로변경 6. On-Board Date 보다 Issue Date가 이전인지
		 * 확인 7. B/L data 작성 여부(M&D 및 Rate) 및 PPD 운임회수 확인 8. To Order flag 확인 9.
		 * 변경된 정보가 있을 경우 저장 호출
		 * 
		 * <EXCEPTION> 3.a On-Board Date와 SKD Date가 다를 경우 메시지 [BKG00467] 표시(단순
		 * 경고메세지) 4.a On-Board Date와 CRD가 다를 경우 메시지 [BKG00468] 표시(단순 경고메세지) 6.a
		 * 이전일 경우 메시지 [BKG00398]를 표시 후 리턴 7.a 작성완료 되지 않은 경우 메세지 [BKG00470] 표시 후
		 * 리턴 8.a 'Y' (Straight B/L)이 아닌경우 메시지 [BKG00469] 표시 후 리턴"
		 */

		break;
	case COMMAND04: // [Cancel Release]  btn_t11CancelRelease 
		/* 1. 변경된 정보가 있을 경우 저장 호출 */

		break;
	}

	return true;
}
 
 /**
  * 1. POD가 UY, CO, EC인 경우 B/L Type B만 선택 가능
  *    다른 Type 선택 시 ‘Only Original B/L can be issued, because of Customs Regulation.’ 문구 처리
  * 2. POD가 BR인 경우
  *     B/L Issue Date와 On Board Date가 다른 상태에서 B/L Issue 시 ‘For the shipment destined to Brazil, the On Board Data and B/L Issue Date should be same. Please check the date once again.’ 문구 처리
  */
 function validateByPodCd(chkBlType) {
	var formObj    = document.form;
	var chkPodCd   = formObj.frm_t11sheet1_pod_code.value;
	//var chkBlType  = formObj.frm_t11sheet1_bl_issuebl_type.value;
	var chkBoardDt = formObj.frm_t11sheet1_on_board_date.value;
	var chkIssueDt = formObj.frm_t11sheet1_bl_issue_date.value;
	
	// 해당 BkgNo가 하드코딩 테이블에 있으면 체크하지 않는다.
	if(checkBkgHrdCdgCtnt(sheetObjects['t11sheet1'], document.form, "BKG", formObj.bkg_no.value, ""))
		return true;
	
	if(chkPodCd != null) {
		var boolW = checkBkgHrdCdgCtnt(sheetObjects['t11sheet1'], document.form, "CNT", chkPodCd.substr(0,2), "W");
		var  chkW  = "";
		if(boolW) chkW = "W";
		
		var boolS = checkBkgHrdCdgCtnt(sheetObjects['t11sheet1'], document.form, "CNT", chkPodCd.substr(0,2), "S");
		var  chkS  = "";
		if(boolS) chkS = "S";
		
		if(chkBlType == chkW || chkBlType == chkS) {
			ComShowMessage(ComGetMsg("BKG08242", ""));
			return false;
		}
		
		/*if(chkPodCd.indexOf("UY") == 0 || chkPodCd.indexOf("CO") == 0 || chkPodCd.indexOf("EC") == 0) {
			if(chkBlType == "W" || chkBlType == "S") {
				ComShowMessage(ComGetMsg("BKG08242", ""));
				return false;
			}
		}*/
		
		/*if(chkPodCd.indexOf("BR") == 0) {
			if(chkBlType == "S") {
				ComShowMessage(ComGetMsg("BKG08242", ""));
				return false;
			}
		}*/

		if(!checkBkgHrdCdgCtnt(sheetObjects['t11sheet1'], document.form, "DATE", chkPodCd.substr(0,2), "")) {
			if(chkBoardDt != chkIssueDt) {
				ComShowMessage(ComGetMsg("BKG08243", ""));
				return false;
			}
		}
	}
	
	return true;
 }
 
 /**
  * t11sheet1_OnSaveEnd  저장완료 후 이벤트 발생 
  * param :sheetObj, ErrMsg
  */
 function t11sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		initFrist=false;
 }
/**
 * t10sheet1_OnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function t11sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	
	try {
		// 값이 없으면 초기화시킴 
		if (sheetObj.TotalRows == 0){
			ComResetAll();
			try{
				parent.initCAControl("", "N", "N", "N", "");
			}catch(e){}
			
			return;
		}
		//FORM VALUE BINDING 
		if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {
		}

		ComSetObjValue(formObj.bkg_no 			, ComGetObjValue(formObj.frm_t11sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no 			, ComGetObjValue(formObj.frm_t11sheet1_bl_no));
		ComSetObjValue(formObj.on_board_type	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_on_board_type), "L"));
		ComSetObjValue(formObj.bl_ready_type	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_bl_ready_type), "U"));
		ComSetObjValue(formObj.bl_hld_rsn_cd	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_bl_hld_rsn_cd), "CR"));
		// select box : ppd_confirm
		ComSetObjValue(formObj.ppd_confirm		, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_ppd_confirm), "N"));
		// select box : trd_ppd_confirm
		ComSetObjValue(formObj.trd_ppd_confirm	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_trd_ppd_confirm), "N"));
		// select box : cct_confirm
		ComSetObjValue(formObj.cct_confirm		, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_cct_confirm), "N"));
		// select box : trd_cct_confirm
		ComSetObjValue(formObj.trd_cct_confirm	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_trd_cct_confirm), "N"));
		
		// check box : frm_t11sheet1_bdr
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_bdr)) {
			formObj.check_bdr.checked = true;
		}else{
			formObj.check_bdr.checked = false;
		}
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox)) {
			formObj.bl_ready_checkbox.checked = true;
		}else{
			formObj.bl_ready_checkbox.checked = false;
		}
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_checkbox)) {
			formObj.bl_proofbyshipper_checkbox.checked = true;
		}else{
			formObj.bl_proofbyshipper_checkbox.checked = false;
		}
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_bl_hld_flg)) {
			formObj.bl_hld_flg.checked = true;
		}else{
			formObj.bl_hld_flg.checked = false;
		}
		//추가  f_fwd_name
		ComSetObjValue(formObj.f_fwd_name, ComGetObjValue(formObj.frm_t11sheet1_f_fwd_name)+ComGetObjValue(formObj.frm_t11sheet1_f_fwd_address));
		// issued가 Y이면 비활성화
		if('Y' == ComGetObjValue(formObj.frm_t11sheet1_issued)){
			formObj.IssuerSet_checkbox.disabled = true;	
		}else{
			formObj.IssuerSet_checkbox.disabled = false;
		}
		ComSetObjValue(formObj.frm_t11sheet1_issued, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_issued), "N"));
		ComSetObjValue(formObj.frm_t11sheet1_released, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_released), "N"));
		ComSetObjValue(formObj.frm_t11sheet1_surrender, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_surrender), "N"));
		ComSetObjValue(formObj.frm_t11sheet1_obl_prn_flg, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_obl_prn_flg), "N"));
		/*
		 * <EXCEPTION> 1.a 신규의 경우 Vessel Voyage Directoin을 T.VVD로 설정 B/L ISSUE의
		 * B/L Type을 B로 No를 3으로설정
		 */
		if (sheetObj.TotalRows == 0) {
			//? Vessel Voyage Directoin을 T.VVD로 설정 
			ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, "B");
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "3");
		}
		// 기본값 B 2009.10.19 by 신자영 
		if('' == ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)){
			ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');		
		}
		// 기본 B setting 따르지만 receive가 LG/LI인 경우 'L'로 표기 되도록 재정의 2009.12.22 by cateshin
		if('L' == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)){
			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'L');	
		}else if('' == ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)){
			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'B');
		}
		// internet/cancel 구분  2009.11.11 by 신자영 
		if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)){
			eval('DIV_btn_t11InternetAUTH').style.display = 'none';
			eval('DIV_btn_t11CancelAUTH').style.display = 'block';			
		}else{
			eval('DIV_btn_t11InternetAUTH').style.display = 'block';
			eval('DIV_btn_t11CancelAUTH').style.display = 'none';
			document.getElementById('web_print_approved').innerHTML = '';
		}
		


		setChangeColor();
		setBlCertiColor();

		
		formObj.old_pod_name.value = ComGetObjValue(formObj.frm_t11sheet1_pod_name) ;
		formObj.old_del_name.value = ComGetObjValue(formObj.frm_t11sheet1_del_name) ;
		
		/* 홍우리님 요청 VNSGNY2 & VNSGNY1 인 경우 각각 POD, DEL항목 비활성화*/
//		if (null != ComGetObjValue(formObj.frm_t11sheet1_pod_nod_cd) 
//			&& ("VNSGNY2" == ComGetObjValue(formObj.frm_t11sheet1_pod_nod_cd) 
//			||  "VNSGNY1" == ComGetObjValue(formObj.frm_t11sheet1_pod_nod_cd))){
//			BkgEnableObject(formObj.frm_t11sheet1_pod_code, false);
//			BkgEnableObject(formObj.frm_t11sheet1_pod_name, false);
//		}else{
//			BkgEnableObject(formObj.frm_t11sheet1_pod_code, true);
//			BkgEnableObject(formObj.frm_t11sheet1_pod_name, true);
//		}
//		if (null != ComGetObjValue(formObj.frm_t11sheet1_del_nod_cd) 
//			&& ("VNSGNY2" == ComGetObjValue(formObj.frm_t11sheet1_del_nod_cd) 
//			||  "VNSGNY1" == ComGetObjValue(formObj.frm_t11sheet1_del_nod_cd))){
//			BkgEnableObject(formObj.frm_t11sheet1_del_name, false);
//		}else{
//			BkgEnableObject(formObj.frm_t11sheet1_del_name, true);
//		}
		 
	} catch (ex) {
		fnBkgErrorAlert('t11sheet1_OnSearchEnd', ex);
		return false;
	}
	// 초기검색 변경 여부 
	initFrist=false;
}
 /**
 * setChangeColor
 * 글자에 따른 색상변경 
 * param : 
 */
 function setChangeColor() {
	var formObj = document.form;
	// 에러인경우 색상변경
	if ('E' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)) {
		formObj.frm_t11sheet1_bkg_sts.style.color = 'red';
	}else{
		formObj.frm_t11sheet1_bkg_sts.style.color = '';
	}
	// frm_t11sheet1_issued 색상 
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued)){
		document.getElementById('frm_t11sheet1_issued').style.color="red";
		document.getElementById('frm_t11sheet1_issued').style.fontWeight="bold";
	}else{
		document.getElementById('frm_t11sheet1_issued').style.color="";
		document.getElementById('frm_t11sheet1_issued').style.fontWeight="";
	}
	// frm_t11sheet1_released 색상 
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_released)){
		document.getElementById('frm_t11sheet1_released').style.color="red";
		document.getElementById('frm_t11sheet1_released').style.fontWeight="bold";
	}else{
		document.getElementById('frm_t11sheet1_released').style.color="";
		document.getElementById('frm_t11sheet1_released').style.fontWeight="";
	}
	// frm_t11sheet1_obl_prn_flg 색상 
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_obl_prn_flg)){
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.color="red";
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.fontWeight="bold";
	}else{
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.color="";
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.fontWeight="";
	}
 }
/**
* tpbImgSet
* TPB로 부터 받아온 정보로 이미지 구성 및 코드 값 세팅
* param : tpbStatus
*/
function tpbImgSet(tpbStatus) {
	if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;

    if(document.getElementById("tpb_status").value == 1){
        document.getElementById("tpb_icon").src = "img/btng_icon_green.gif";
        document.getElementById("tpb_cd").value = 'C';
    }else if(document.getElementById("tpb_status").value == 0){
        document.getElementById("tpb_icon").src = "img/btng_icon_r.gif";
        document.getElementById("tpb_cd").value = 'P';
    }else{
        document.getElementById("tpb_icon").src = "img/btng_icon_g.gif";
        document.getElementById("tpb_cd").value = '';
    }
} 
/**
 * fnBlReadyCheckbox
 * obj으로 체크상태에 따른 액션 수행.
 * param : r_obj
 */
var tmp_bl_ready_by ="" ;
var tmp_bl_ready_office="" ;
var tmp_bl_ready_date="" ;
function fnBlReadyCheckbox(r_obj) {
	var formObj = document.form;
	if (r_obj.checked) {
		/*	1. B/L Ready의 By, Date, Office를 현재 User의 정보로 설정한다.
		 */
		tmp_bl_ready_by 	 = ComGetObjValue(formObj.frm_t11sheet1_bl_ready_by);
		tmp_bl_ready_office  = ComGetObjValue(formObj.frm_t11sheet1_bl_ready_office);
		tmp_bl_ready_date 	 = ComGetObjValue(formObj.frm_t11sheet1_bl_ready_date);
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by	, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, ComGetObjValue(formObj.strOfc_cd));
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date	, ComGetNowInfo());	
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by	, tmp_bl_ready_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, tmp_bl_ready_office);
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date	, tmp_bl_ready_date);
	}
}
/**
 * fnBlProofbyshipperCheckbox
 * obj으로 체크상태에 따른 액션 수행.
 * param : s_obj
 */
var tmp_bl_proofbyshipper_by='' ;
var tmp_bl_proofbyshipper_office='';
var tmp_bl_proofbyshipper_date='' ;
function fnBlProofbyshipperCheckbox(s_obj) {
	var formObj = document.form;
	if (s_obj.checked) {
		/*1. B/L PROOF BY SHIPPER의 By, Date를 현재 User의 정보로 설정한다.
		2. docPrcModyFlg 를 'Y'로 설정한다.
		 */
		tmp_bl_proofbyshipper_by   = ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_by);
		tmp_bl_proofbyshipper_office  = ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_office);
		tmp_bl_proofbyshipper_date = ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date);
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_by, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_office, ComGetObjValue(formObj.strOfc_cd));
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date, ComGetNowInfo());
		ComSetObjValue(formObj.frm_t11sheet1_doc_proc_modyflg, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_by , tmp_bl_proofbyshipper_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_office, tmp_bl_proofbyshipper_office);
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date, tmp_bl_proofbyshipper_date);
		ComSetObjValue(formObj.frm_t11sheet1_doc_proc_modyflg, "N");
	}
}
function fnDateSetCheckbox(r_obj) {
	var formObj = document.form;
	if (r_obj.checked) {
		/*1. On Board상의 ETD를 copy해서 Date에 Set
		 */
		tmp_pol_etd_dt 	 = ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt);
		ComSetObjValue(formObj.frm_t11sheet1_on_board_date	, tmp_pol_etd_dt);
	} else {
		tmp_on_board_date = '';
		ComSetObjValue(formObj.frm_t11sheet1_on_board_date	, tmp_on_board_date);
	}
}
/**
* fnIssuerSetCheckbox
* obj으로 체크상태에 따른 액션 수행.
* param : s_obj
*/
var tmp_bl_issue_by='';
var tmp_bl_issue_at='';
var tmp_bl_issue_date='';
var tmp_bl_issuebl_type='';
var tmp_bl_issue_no='';
function fnIssuerSetCheckbox(s_obj) {
	var formObj = document.form;
	if (s_obj.checked) {
		tmp_bl_issue_by = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_by);
		tmp_bl_issue_at = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_at);
		tmp_bl_issue_date = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date);
		tmp_bl_issuebl_type = ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type);
		tmp_bl_issue_no = ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_by, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_at, ComGetObjValue(formObj.strOfc_cd));
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_date, ComGetNowInfo());
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, "B");
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "3");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_by, tmp_bl_issue_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_at, tmp_bl_issue_at);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_date, tmp_bl_issue_date);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, tmp_bl_issuebl_type);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, tmp_bl_issue_no);
	}
}
/**
 * fnRadioCheck
 * obj와 value값으로 값을 선택한다.
 * param : v_obj, v_value
 */
function fnRadioCheck(v_obj, v_value) {
	var radio = document.getElementsByName(v_obj);
	if (radio == null)
		return;
	for ( var i = 0; i < radio.length; i++) {
		if (radio[i].value == v_value) {
			radio[i].checked = true;
			break;
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
 * fnExistBlackListedCustomer  
 * booking_no 로 This customer is blacklisted customer. Pls contact Sales Office for BKG allowance
 * param :_val
 */
function fnExistBlackListedCustomer() {
	var formObj = document.form;
	var sheetObj = sheetObjects['t11sheet1'];
	var param = "&f_cmd=" + COMMAND02 + "&input_text=" + ComGetObjValue(formObj.frm_t11sheet1_bkg_no);
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var cust_cd = ComGetEtcData(sXml, "cust_cd");;
	var rls_ctrl_rsn = ComGetEtcData(sXml, "rls_ctrl_rsn");;
	var ar_ofc = ComGetEtcData(sXml, "ar_ofc");;
	var srep_nm = ComGetEtcData(sXml, "srep_nm");
	if (cust_cd != null && cust_cd != '') {
		ComShowMessage(ComGetMsg("BKG08099", cust_cd
				                           ,"\n- Release Control Reason : " + rls_ctrl_rsn +
				                            "\n- Contact Sales or AR Office : " + ar_ofc + 
				                            "\n- Contact Sales Rep. : " + srep_nm));
		return false;// Y이면 error
	}
	return true;
}
/**
 * fnSearchMdmLocName  
 * LOC_CD 코드번호로 LOC_NM값을 얻는 함수 
 * param :sheetObj, ErrMsg
 */
function fnSearchMdmLocName(ltype) {

	var formObj = document.form;
	var sheetObj = sheetObjects['t11sheet1'];
	var objCode = eval('document.form.frm_t11sheet1_' + ltype + '_code');
	var objName = eval('document.form.frm_t11sheet1_' + ltype + '_name');
	var tmp_objCode = objCode.value;
	var tmp_objName = objName.value;
	try {
		var param = param + "&f_cmd=" + SEARCHLIST17 + "&input_text=" + ComGetObjValue(objCode);
		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
		var output_text = ComGetEtcData(sXml, "output_text");
		
		if (output_text == '' || output_text == null) {
			//<EXCEPTION>1.a Location 이 존재하지 않을 경우 메시지 [BKG00061] 표시 후 리턴
			ComShowCodeMessage("BKG00061");
			ComSetObjValue(objName, '');
		} else {
			ComSetObjValue(objName, output_text);
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
	document.form.frm_t11sheet1_bkg_no.value = split_list.options[split_list.selectedIndex].value;
	span_bkg_no.style.display="none";
}
/**
* blSplitNoList BKG_목록_이벤트 
* param :split_list
*/
function blSplitNoList(split_list){
	document.form.frm_t11sheet1_bl_no.value = split_list.options[split_list.selectedIndex].value;
	span_bl_no.style.display="none";
}

var Select_Bkg_No_Html = null;
var Select_Bl_No_Html = null;
/**
 * fnSetSelectNumberBox 테이블생성 이벤트 param :formObj_id,
 * formObj_value=변수값,데이터1값,데이터2값
 */
function fnSetSelectNumberBox(_name, _type) {
	var vobj = eval("document.all." + _name); // SELECT 박스 위치 ID값
	var sheetObj = sheetObjects['t11sheet1'];
	var formObj = document.form;
	var html = "";

	try {

		switch (_type) {

		case 'text_bkg_no': //text

				if(ComIsEmpty(formObj.frm_t11sheet1_bkg_no.value)){
					ComShowMessage(ComGetMsg("BKG08019"));
					formObj.frm_t11sheet1_bkg_no.focus();
					return false;
				}
		
				if (null == Select_Bkg_No_Html || ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t11sheet1_bkg_no)) {
					 
					var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t11sheet1_bkg_no);
					var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
					Select_Bkg_No_Html = ComGetEtcData(rXml, "bkg_split_no_list");
					if(Select_Bkg_No_Html.indexOf("<option") < 0) return false;

				}
		
				var obj = formObj.frm_t11sheet1_bkg_no;
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
					formObj.frm_t11sheet1_bl_no.focus();
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
* fnSetBlNoStringCheck BL_Number 체크 
* ComGetObjValue(formObj.frm_t11sheet1_bl_no)
* param :
*/
function fnSetBlNoStringCheck(t_bl_no) {
	var formObj = document.form;
	if ('W' != ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)) {
		if(t_bl_no.length>12){
			 ComSetObjValue(formObj.bl_no, t_bl_no.substr(0,12));
		}else{
			ComSetObjValue(formObj.bl_no, t_bl_no);
		}
	}else{
		ComSetObjValue(formObj.bl_no, t_bl_no);
	}

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

		html = "<select style='width:110;' class='input' size=5 multiple onChange='javascript:blSplitNoList(this);' name='" + _name + "'>"
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
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
 var temp_value='';
function obj_activate() {

	//입력Validation 확인하기
	switch (event.srcElement.name) {

	case "frm_t11sheet1_on_board_date":
		ComClearSeparator(event.srcElement);
		break;
	case "frm_t11sheet1_bl_issue_date":
		ComClearSeparator(event.srcElement);
		break;
	case "frm_t11sheet1_bl_proofbyshipper_date":
		ComClearSeparator(event.srcElement);
		break;
	case "frm_t11sheet1_bl_ready_date":
		ComClearSeparator(event.srcElement);
		break;		
	}
	
	 if(eval('document.form.'+event.srcElement.name).value.length > 0){
		 temp_value = eval('document.form.'+event.srcElement.name).value;
	 }
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate() {
	 var formObj = document.form;
	 if(eval('document.form.'+event.srcElement.name).value.length > 0){
		 if(temp_value != "" && temp_value != eval('document.form.'+event.srcElement.name).value){
			 ComSetObjValue(formObj.modify_flag, "Y");	 
		 }
	}
	
	// 입력Validation 확인하기
	switch (event.srcElement.name) {

		case "frm_t11sheet1_on_board_date":
			/*	
			 * 1.On-Board 와 ETD가 다를 경우 메시지 [BKG00467] 표시하고 확인여부 체크
			 * <EXCEPTION> 1.a  'No'를 선택한 경우 리턴"
			 */
			ComAddSeparator(event.srcElement);
			break;
		case "frm_t11sheet1_bl_issue_date":
			ComAddSeparator(event.srcElement);
			break;
		case "frm_t11sheet1_bl_proofbyshipper_date":
			ComAddSeparator(event.srcElement);
			break;
		case "frm_t11sheet1_bl_ready_date":
			ComAddSeparator(event.srcElement);
			break;				
		case "frm_t11sheet1_obl_iss_rmk":
			//[2009.12.20] 자릿수제한 조건추가 
			if(ComChkLen(formObj.frm_t11sheet1_obl_iss_rmk, "500") == "0"){//0  : 길이 초과<br>
				ComShowCodeMessage("BKG04012","Remark","500","");
				ComSetObjValue(formObj.frm_t11sheet1_obl_iss_rmk , ComGetObjValue(formObj.frm_t11sheet1_obl_iss_rmk).substring(0,500));
				ComSetFocus(formObj.frm_t11sheet1_obl_iss_rmk);
			}
			break;
		case "frm_t11sheet1_bkg_no":
		case "frm_t11sheet1_bl_no":
			var srcName = window.event.srcElement.getAttribute("name");
			var srcValue = window.event.srcElement.getAttribute("value");
			formObj.elements[srcName].value = srcValue.toUpperCase();
			break;
	}
}
/*조회조건 에터키 이력시 조회*/
function check_Enter() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (event.keyCode == 13) {
		if(event.srcElement.name == "frm_t11sheet1_obl_iss_rmk") return;
		
		if(event.srcElement.name == "frm_t11sheet1_bkg_no" || event.srcElement.name == "frm_t11sheet1_bl_no"){
			//fnClearForm();
			ComSetObjValue(formObj.bkg_no , ComGetObjValue(formObj.frm_t11sheet1_bkg_no));
			formObj.elements[srcName].value = srcValue.toUpperCase();
			doActionIBSheet(sheetObjects['t11sheet1'], document.form, IBSEARCH);
		}
	}
}
/**
 * fngBkgToolTipMove  이벤트 
 * 툴팁 이동하기 
 * param :evt
 */
function fngBkgToolTipMove(evt) {
	if (navigator.appName == "Netscape") {
		helpbox.style.left = evt.pageX + 10;
		helpbox.style.top = evt.pageY + 20;
	} else {
		helpbox.style.posLeft = event.x + 10 + document.body.scrollLeft;
		helpbox.style.posTop = event.y + 20 + document.body.scrollTop;
	}
}
/**
 * fngBkgToolTipView  이벤트 
 * 툴팁 보이기 
 * param :str
 */
function fngBkgToolTipView(_name) {
	var obj = eval("document.all." + _name); 
	var str = bkgMAP.get(ComGetObjValue(obj));
	if(str == null || str == 'undefined') return;
	var text;
	text = '<table align="center" border="0" cellpadding="10" cellspacing="0" style="border-width:3; border-color:#3a679e; background-color:#eaf3ff ;border-style:solid;font-size:9pt;">';
	text += '<tr><td align=center>' + str + '</td></tr></table>';
	helpbox.innerHTML = text;
}
/**
 * fngBkgToolTipHide  이벤트
 * 툴팁 숨기기  
 * param :
 */
function fngBkgToolTipHide() {
	helpbox.innerHTML = '';
}
/**
 * fnBkgJsMap  
 * javascript Array로 구현한 Map
 * param :
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
* BlNo Information 풍선도움말 관련
* param : 
*/
function blNoSet(){
	var obj = document.form.frm_t11sheet1_bl_no;
	var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+5	;
	var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetLeft+7; 
	orgBlNo.style.left=sleft;
	orgBlNo.style.top=stop;	
	
	var strMsg = document.form.frm_t11sheet1_bl_no.value;
	if(strMsg != ""){
		text ='<table  width=115  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strMsg + '</td></tr></table>';
		orgBlNo.innerHTML=text;
	}
}
/**
* blNoHide
* param : 
*/
function blNoHide(){
	orgBlNo.innerHTML='';
}	
/**
* booking split no 팝업창에서 선택값을 object에 넣음
* param : splitno
* @version 2009.06.29
*/
function bkgSplitSet(splitno){
  document.form.frm_t11sheet1_bkg_no.value = splitno;
  document.form.frm_t11sheet1_bkg_no.focus();
  layList.style.display = "none";
  isSplitNoOpen = false;
}
/**
 * bkg_error_alert 
 */
function fnBkgErrorAlert(msg, ex) {
	alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
 
/**
* fnExceptionMessage 
*/
function fnExceptionMessage(rXml){
	var rMsg = ComGetEtcData(rXml,"Exception");
	var rmsg = rMsg.split("<||>");
	if(rmsg[3] != undefined && rmsg[3].length > 0) {
		ComShowMessage(rmsg[3]);
	}else{
		sheetObjects[0].LoadSaveXml(rXml);
	}
}
/**
* checkModify: 탭이동시 저장여부
* param : 
* 0079에서 실행
*/
function checkModify(){
	var formObj  = document.form;
	if(ComGetObjValue(formObj.isInquiry) == "Y") return;
	
	if(ComGetObjValue(formObj.modify_flag) == "Y"){
		tab_alert_msg = false;
		var sheetObj = sheetObjects['t11sheet1'];
		if(!processValidate("btn_t11Save")) return; 
		doActionIBSheet(sheetObj, document.form, IBSAVE);		
	}
}

/**
* searchData : 탭이동시 검색수행
* bkgNo : 
* 0079에서 실행
*/
function searchData(bkgNo){
	var formObj = document.form;
	var sheetObj = sheetObjects['t11sheet1'];
	
	sheetObj.WaitImageVisible = false;  
	ComSetObjValue(formObj.frm_t11sheet1_bkg_no ,bkgNo);
	doActionIBSheet(sheetObj, formObj, IBSEARCH);       
	sheetObj.WaitImageVisible = true;
}  
/**
* setInquiryDisableButton 이벤트 호출 .<br>
* ComBtnDisable 을 했을경우 비활성화
* @param 
*/
function setInquiryDisableButton(){
//	ComBtnDisable("btn_t11New");
	ComBtnDisable("btn_t11Save");
	ComBtnDisable("btn_t11BLPreview");
	ComBtnDisable("btn_t11BLPrint");
	ComBtnDisable("btn_t11SWBEmail");
	ComBtnDisable("btn_t11InternetAUTH");
	ComBtnDisable("btn_t11CancelAUTH");
	ComBtnDisable("btn_t11OBLRelease");
	ComBtnDisable("btn_t11CancelRelease");
	ComBtnDisable("btn_t11SWBRelease");
	ComBtnDisable("btn_t11OBLSurrender");
}

/**
 * fnOfcCdCheck  
 * ofc_cd 유효성 체크
 * @param frm_ofc_cd
 * @return output_text
 */
function fnOfcCdCheck(frm_ofc_cd) {
 if(frm_ofc_cd.value != "") {
	 var sheetObj = sheetObjects['t11sheet1'];
	 var param = param + "&f_cmd=" + SEARCHLIST19 + "&input_text=" + frm_ofc_cd.value;
	 var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	 var output_text = ComGetEtcData(sXml, "output_text");
	 if ('Y' != output_text) {
	  // Third Office is not available
	   ComShowCodeMessage("BKG00044",'Office Code'); 
	   frm_ofc_cd.value = '';
	  ComSetFocus(frm_ofc_cd);
	 }
 }
}


function checkCaProcessing(sheetObj, formObj) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH09;
	
	var sParam = FormQueryString(formObj); // hidden param value 문자열
	sParam += "&" + ComGetPrefixParam(prefix1);// prefix 문자열 배열

	var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, sParam);
	
	// CA가 진행 중인지 판단한다.
	State = ComGetEtcData(sXml,"CaProcessing");
	if ( State != null && State == "BKG95053" ) {	
		ComShowMessage(ComGetMsg(State));
		return false;
	}
	
	return true;
}

function checkBkgHrdCdgCtnt(sheetObj, formObj, attrCtnt1, attrCtnt2, attrCtnt3) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH10;
	
	formObj.attrCtnt1.value = attrCtnt1;
	formObj.attrCtnt2.value = attrCtnt2;
	formObj.attrCtnt3.value = attrCtnt3;
	
	var sParam = FormQueryString(formObj); // hidden param value 문자열
	sParam += "&" + ComGetPrefixParam(prefix1);// prefix 문자열 배열

	var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, sParam);
	
	// Bkg Hard Coding 데이타 확인.
	State = ComGetEtcData(sXml,"BkgHrdCdgCtnt");
	if ( State != null && State == "Y" ) {
		return false;
	}
	
	return true;
}


/**
 * fnBlHldFlgCheckbox
 * obj으로 체크상태에 따른 액션 수행.
 * param : s_obj
 */
var tmp_bl_HldRsn_by = "";
var tmp_bl_HldRsn_date = "";
function fnBlHldFlgCheckbox(s_obj) {
	// B/L Issue 가 Hold 된 날짜와 Hold 한 유저 아이디 셋팅
	var formObj = document.form;
	if (s_obj.checked) {
		tmp_bl_HldRsn_by   = ComGetObjValue(formObj.frm_t11sheet1_bl_hld_usr_id);
		tmp_bl_HldRsn_date = ComGetObjValue(formObj.frm_t11sheet1_bl_hld_dt);
		ComSetObjValue(formObj.frm_t11sheet1_bl_hld_usr_id, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_hld_dt, ComGetNowInfo());
//		ComSetObjValue(formObj.bl_hld_rsn_cd	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_bl_hld_rsn_cd), "CR"));
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_hld_usr_id , tmp_bl_HldRsn_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_hld_dt, tmp_bl_HldRsn_date);
		formObj.bl_hld_rsn_cd.Code = "CR"; // B/L Hold 콤보박스 초기화
	}
}

/**
* fncTextareaMaxLine
*/
function fncTextareaMaxLine(obj){
    var str_line = obj;
    line = str_line.split("\r\n");
    ln = line.length;

    if(ln == 5 && event.keyCode == 13){
        event.returnValue = false;
    }
}

/**
* 팝업 화면의 Value 를 리턴 받는다.
*/
function funcSetRemark(remark) {
	document.form.frm_t11sheet1_obl_iss_rmk.value = remark;
	chkRemark();
}

/**
 * Remarks 항목에 값이 존재하면 버튼을 Enable 처리하고 버튼색을 파란색으로 표시한다.
 */
function chkRemark() {
	if (document.form.frm_t11sheet1_obl_iss_rmk.value.length > 0 ) {
		// 항목에 값이 존재하는 경우
		document.getElementById('btn_t11sheet1_obl_iss_rmk').style.color="blue";
	} else {
		// 항목에 값이 존재하지 않는 경우
		document.getElementById('btn_t11sheet1_obl_iss_rmk').style.color="gray";
	}
}

function setBlCertiColor() {
	var formObj = document.form;

	
    if(ComGetObjValue(formObj.frm_t11sheet1_img_flg) == "G"){
    	document.getElementById("bl_certi_icon").src = "img/btng_icon_green.gif";
    }else if(ComGetObjValue(formObj.frm_t11sheet1_img_flg) != "X"){
    	document.getElementById("bl_certi_icon").src = "img/btng_icon_r.gif";
    }else{
    	document.getElementById("bl_certi_icon").src = "img/btng_icon_g.gif";
    }

}



/* 개발자 작업  끝 */