/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0920.js
*@FileTitle : CY & Door S/O Creation Matchmaking Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
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
 * @class bkg_cre_079 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0920() {
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

var sheetObjects = new Array();
var sheetCnt = 0;
var sheetObjSingle; //Single Transportation
var sheetObjCase2; //Combined CNTR Trans. Case 2

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_apply":
				IBS_Sheet2SheetStatus6(sheetObject, sheetObject1, sheetObjCase2);
			break;
			case "btn_close":				
				doSheetSheetCheck();
				window.close();
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
	sheetObjSingle = opener.sheetObjects[0];
	sheetObjCase2 = opener.sheetObjects[2];

	document.form.ui_conti_cd.value=opener.form.ui_conti_cd.value;
	document.form.cydoor_div.value=opener.form.cydoor_div.value;
	
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	IBS_Sheet2SheetStatus5(sheetObjSingle, sheetObjects[0], "chk1");
	
	//html컨트롤 이벤트초기화
	initControl();
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}


//Axon 이벤트 처리2. 이벤트처리함수 --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
//    ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation<br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//    form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//    return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
//    ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
//    ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var cnt = 0;
	var sheetObject = sheetObjects[0];
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
                style.height = 180; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				
				InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(160, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false,false) // 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				var HeadTitle0 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|CMC|Trans\nMode|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Multi\nStop|Planned Time|Planned Time|Planned Time|Planned Time|Planned Time|Planned Time|COP No|A/G SEQ|A/G Code|BKG No|BL No|BND|Term|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.|Avaliable DT|Avaliable DT|Last Free DT|Last Free DT|S/C No|Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|Door\nSVC TP|Internal Remark|Remark\n(Special Instruction)|S/O Office|IRG|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason";
				var HeadTitle1 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|CMC|Trans\nMode|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Actual\nCustomer|Factory\nName|Zip\nCode|Address|TEL|FAX|PIC|Multi\nStop|From Departure|From Departure|To Arrival|To Arrival|Door Arrival|Door Arrival|COP No|A/G SEQ|A/G Code|No|BL No|BND|Term|SEQ|CNFM|Office|User ID|Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No|TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.|||||S/C No|Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|Door\nSVC TP|Internal Remark|Remark\n(Special Instruction)|S/O Office|IRG|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_so_cmb_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "source", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_no", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_cost_dtl_mod_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cmc");
				InitDataProperty(0, cnt++, dtCombo,100, daCenter, true, "trsp_crr_mod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "fm_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "fm_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "via_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "via_nod_yard",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "to_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "to_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "dor_nod_cd", false, "", dfNone, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "dor_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtPopup,100, daLeft, true, "cust_cnt_cd", false, "", dfNone, 1, false, false); //cust_cnt_cd = cust_cnt_cd + cust_seq
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "fctry_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_pst_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "dor_de_addr", false, "", dfNone, 1, false, false, 200);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cntc_pson_phn_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cntc_pson_fax_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cntc_pson_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "mlt_stop_de_flg", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "n1st_nod_pln_dt", false, "",    dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "n1st_nod_pln_dt_hms", false, "",   dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "lst_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lst_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dor_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dor_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cost_act_grp_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_no", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false); //bl_no = BL_NO + BL_NO_TP + BL_NO_CHK
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cnfm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_upd_dt1", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_upd_dt2", false, "", dfTimeHms, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rev_curr_cd"         , false, "", dfNone, 0, false, false);      //jsk-20071109
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "trsp_rqst_ord_rev_amt", false, "", dfNone, 0, false, false);      //jsk-20071109
				
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_lod_ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_rep_cmdt_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_qty", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup,50 , daCenter, true, "spcl_cgo_cntr_tp_cd", false, "", dfNone, 1, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50 , daLeft, true, "sealno", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daLeft, true, "sealno2", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_wgt", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_kgs_wgt", false, "", dfFloat, 3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_lbs_wgt", false, "", dfFloat, 3, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "wgt_meas_ut_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "noofpkg", false, "", dfFloat,3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pkgcode", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daLeft, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "trunkvvd", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "slan_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ib_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ob_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "por_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "del_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "shpr_cust_nm", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "cnee_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "ntfy_cust_nm", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "lst_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgor_frt_pay_ind_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgor_org_bl_rcvr_ind_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "cgor_cstms_acpt_re_ind_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "cntr_pkup_no", false, "", dfNone, 0, true, true, 12);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "aval_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "aval_dt_hms", false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "lst_free_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "lst_free_dt_hms", false, "", dfTimeHms, 0, true, true);

				InitDataProperty(0, cnt++, dtHidden, 80 , daCenter, true, "sc_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearance", false,"", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearanceNo", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80 , daCenter, true, "rfano", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80 , daCenter, true, "ownr_co_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "imdt_ext_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60 , daCenter, true, "lstm_cd", false, "", dfNone, 1, false, false);
				
				
				InitDataProperty(0, cnt++, dtCombo, 50 , daCenter, true, "dor_svc_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "inter_rmk", false, "", dfEngUpKey, 1, false, false, 255);
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, false, false, 255);

				InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "ctrl_ofc_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "irg", false, "", dfEngUpKey, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden,80 , daCenter, true, "trns_rqst_ofc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "trns_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "trns_rqst_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "act_cust_cnt_cd", false, "", dfNone, 0, false, false); //20070726 정원근 수석 요청
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "act_cust_seq", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cstms_clr_no", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_arr_dt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rep_cmdt_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rev_curr_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rqst_ord_rev_amt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_nxt_port_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cust_nomi_trkr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rail_cmb_thru_tp_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oldCMC", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "fm_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "fm_nod_yard2", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "via_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "via_nod_yard2",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "to_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "to_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "dor_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_cost_dtl_mod_sep", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "upln_so_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "vndr_seq", false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rc_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_seq", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rqst_ord_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rqst_ord_seq", false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "ref_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "repo_pln_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "pln_yrwk", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "ref_seq", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "trsp_so_cmb_tp_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "trsp_mty_cost_mod_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "trsp_mty_rqst_dt", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "lse_cntr_flg", false, "", dfNone, 0, false, false);

				//
				InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "act_cust_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq				
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "usa_do_usr_info", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "do_cre_date", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "do_cre_time", false, "", dfNone, 0, false, false, 255);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "trsp_so_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "prt_bkg_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_cfm_curr_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "tro_cfm_rev_amt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pod_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_loc_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_addr_seq", false, "", dfNone, 0, false, false); /* 2007-11-23 */
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_arr_dt", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_pln", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_dt",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_crr_mod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "tro_sub_seq", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "feedervvd", false, "", dfNone, 0, false, false);
				
				//UI에 나타나지 않는 값 끝

				RangeBackColor(1, 18, 1, 27) = RgbColor(222, 251, 248); // ENIS
				RangeBackColor(1, 8, 1, 16) = RgbColor(222, 251, 248); // ENIS

				sheetObject.ColHidden("cmc") = true;
				sheetObject.ColHidden("trsp_crr_mod_cd") = true;
				sheetObject.ColHidden("cust_cnt_cd") = true;
				sheetObject.ColHidden("mlt_stop_de_flg") = true;
				sheetObject.ColHidden("spcl_cgo_cntr_tp_cd") = true;
				sheetObject.ColHidden("dor_svc_tp_cd") = true;
				sheetObject.ColHidden("lst_loc_cd") = true;
			}
		break;
		case 2:      //sheet1 init
			with (sheetObj) {
				style.height = 180; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(160, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false,false) // 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				var HeadTitle0 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|CMC|Trans\nMode|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Multi\nStop|Planned Time|Planned Time|Planned Time|Planned Time|Planned Time|Planned Time|COP No|A/G SEQ|A/G Code|BKG No|BL No|BND|Term|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.|Avaliable DT|Avaliable DT|Last Free DT|Last Free DT|S/C No|Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|Door\nSVC TP|Internal Remark|Remark\n(Special Instruction)|S/O Office|IRG|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|78|79|80|81|82|83|84|85|86|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110|111|Reference\nNumber";
				var HeadTitle1 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|CMC|Trans\nMode|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Actual\nCustomer|Factory\nName|Zip\nCode|Address|TEL|FAX|PIC|Multi\nStop|From Departure|From Departure|To Arrival|To Arrival|Door Arrival|Door Arrival|COP No|A/G SEQ|A/G Code|No|BL No|BND|Term|SEQ|CNFM|Office|User ID|Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No|TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.|||||S/C No|Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|Door\nSVC TP|Internal Remark|Remark\n(Special Instruction)|S/O Office|IRG|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|78|79|80|81|82|83|84|85|86|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|110|111|Reference\nNumber";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_so_cmb_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "source", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_no", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_cost_dtl_mod_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "cmc");
				InitDataProperty(0, cnt++, dtCombo,100, daCenter, true, "trsp_crr_mod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "fm_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "fm_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "via_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "via_nod_yard",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "to_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "to_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "dor_nod_cd", false, "", dfNone, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "dor_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtPopup,100, daLeft, true, "cust_cnt_cd", false, "", dfNone, 1, false, false); //cust_cnt_cd = cust_cnt_cd + cust_seq
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "fctry_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_pst_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "dor_de_addr", false, "", dfNone, 1, false, false, 200);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cntc_pson_phn_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cntc_pson_fax_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cntc_pson_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "mlt_stop_de_flg", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "n1st_nod_pln_dt", false, "",    dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "n1st_nod_pln_dt_hms", false, "",   dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "lst_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lst_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dor_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dor_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cost_act_grp_cd", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_no", false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false); //bl_no = BL_NO + BL_NO_TP + BL_NO_CHK
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cnfm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_upd_dt1", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_upd_dt2", false, "", dfTimeHms, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rev_curr_cd"         , false, "", dfNone, 0, false, false);      //jsk-20071109
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "trsp_rqst_ord_rev_amt", false, "", dfNone, 0, false, false);      //jsk-20071109
				
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_lod_ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_rep_cmdt_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "bkg_qty", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup,50 , daCenter, true, "spcl_cgo_cntr_tp_cd", false, "", dfNone, 1, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50 , daLeft, true, "sealno", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daLeft, true, "sealno2", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_wgt", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_kgs_wgt", false, "", dfFloat, 3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_lbs_wgt", false, "", dfFloat, 3, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "wgt_meas_ut_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "noofpkg", false, "", dfFloat,3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pkgcode", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daLeft, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "trunkvvd", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "slan_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ib_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ob_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "por_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "del_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "shpr_cust_nm", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "cnee_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "ntfy_cust_nm", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "lst_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgor_frt_pay_ind_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgor_org_bl_rcvr_ind_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "cgor_cstms_acpt_re_ind_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "cntr_pkup_no", false, "", dfNone, 0, true, true, 12);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "aval_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "aval_dt_hms", false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "lst_free_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "lst_free_dt_hms", false, "", dfTimeHms, 0, true, true);

				InitDataProperty(0, cnt++, dtHidden, 80 , daCenter, true, "sc_no", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearance", false,"", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearanceNo", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80 , daCenter, true, "rfano", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80 , daCenter, true, "ownr_co_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "imdt_ext_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60 , daCenter, true, "lstm_cd", false, "", dfNone, 1, false, false);

				
				InitDataProperty(0, cnt++, dtCombo, 50 , daCenter, true, "dor_svc_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "inter_rmk", false, "", dfEngUpKey, 1, false, false, 255);
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, false, false, 255);

				InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "ctrl_ofc_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "irg", false, "", dfEngUpKey, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden,80 , daCenter, true, "trns_rqst_ofc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "trns_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "trns_rqst_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "act_cust_cnt_cd", false, "", dfNone, 0, false, false); //20070726 정원근 수석 요청
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "act_cust_seq", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cstms_clr_no", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_arr_dt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rep_cmdt_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rev_curr_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rqst_ord_rev_amt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_nxt_port_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cust_nomi_trkr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "rail_cmb_thru_tp_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "oldCMC", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "fm_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "fm_nod_yard2", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "via_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "via_nod_yard2",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "to_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "to_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "dor_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_cost_dtl_mod_sep", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "upln_so_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "vndr_seq", false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rc_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_seq", false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rqst_ord_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rqst_ord_seq", false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "ref_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "repo_pln_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "pln_yrwk", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "ref_seq", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "trsp_so_cmb_tp_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "trsp_mty_cost_mod_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daLeft, true, "trsp_mty_rqst_dt", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "lse_cntr_flg", false, "", dfNone, 0, false, false);

				//
				InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "act_cust_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq				
				InitDataProperty(0, cnt++, dtHidden, 120, daLeft, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "usa_do_usr_info", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "do_cre_date", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "do_cre_time", false, "", dfNone, 0, false, false, 255);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "trsp_so_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "prt_bkg_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_cfm_curr_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "tro_cfm_rev_amt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pod_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_loc_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_addr_seq", false, "", dfNone, 0, false, false); /* 2007-11-23 */
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_arr_dt", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_pln", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_dt",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_crr_mod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "tro_sub_seq", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "feedervvd", false, "", dfNone, 0, false, false);
				
				//UI에 나타나지 않는 값 끝

				RangeBackColor(1, 18, 1, 27) = RgbColor(222, 251, 248); // ENIS
				RangeBackColor(1, 8, 1, 16) = RgbColor(222, 251, 248); // ENIS

				InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);
				InitDataCombo(0, 'dor_svc_tp_cd', dor_svc_tp_cdText, dor_svc_tp_cdCode);

				sheetObject1.ColHidden("cmc") = true;
				sheetObject1.ColHidden("trsp_crr_mod_cd") = true;
				sheetObject1.ColHidden("cust_cnt_cd") = true;
				sheetObject1.ColHidden("mlt_stop_de_flg") = true;
				sheetObject1.ColHidden("spcl_cgo_cntr_tp_cd") = true;
				sheetObject1.ColHidden("dor_svc_tp_cd") = true;
				sheetObject1.ColHidden("lst_loc_cd") = true;
			}
		break;
	}
}

//라디오 버튼을 클릭시 데이터를 검색한다.
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if( Value == "1" ) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH); //라디오 버튼을 클릭시
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH: //조회 101
			formObj.f_cmd.value = SEARCH01;
//			sheetObj.ShowDebugMsg = true;
			sheetObjects[1].DoSearch4Post("ESD_TRS_0920GS.do", sheetObj.GetSaveString(false, true, "chk1")+"&"+TrsFrmQryString(formObj));
//			sheetObj.ShowDebugMsg = false;
		break;
	}
}

// PopUp창에서 Combined CNTR Case 2로 이동 시킨다.
function IBS_Sheet2SheetStatus6(topSheet, downSheet, toSheet) {
	//함수 인자 유효성 확인
	if (typeof topSheet != "object" || topSheet.tagName != "OBJECT")
		return false;
	else if (typeof downSheet != "object" || downSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var topRow = topSheet.FindCheckedRow("chk1");
	var downRow = downSheet.FindCheckedRow("chk1");
	var arrTRow = topRow.split("|");
	var arrDRow = downRow.split("|");
	if( arrTRow == "" || arrDRow == "" ) {
		errMsg = ComGetMsg("TRS90098");
		ComShowMessage(errMsg);
		return false;
	}
	var rowCount = toSheet.RowCount+1;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting
	var iz = 1 + (toSheet.RowCount/2); //combined
	var lvcolor = "";
	var chk_time = 7200;
	var lvcostmode = topSheet.CellValue(arrTRow[0], "trsp_cost_dtl_mod_cd");
	var lvtranmode = topSheet.CellValue(arrTRow[0], "trsp_crr_mod_cd");
	var lvcostmode2 = downSheet.CellValue(arrDRow[0], "trsp_cost_dtl_mod_cd");
	var lvtranmode2 = downSheet.CellValue(arrDRow[0], "trsp_crr_mod_cd");
	var lvtonod = topSheet.CellValue(arrTRow[0], "to_nod_cd")+topSheet.CellValue(arrTRow[0], "to_nod_yard");
	var lvfmnod2 = downSheet.CellValue(arrDRow[0], "fm_nod_cd")+downSheet.CellValue(arrDRow[0], "fm_nod_yard");
	var td = topSheet.CellValue(arrTRow[0], "lst_nod_pln_dt"); //lst_nod_pln_dt
	var tt = topSheet.CellValue(arrTRow[0], "lst_nod_pln_dt_hms"); //to Arrival Time
	var fd = downSheet.CellValue(arrDRow[0], "n1st_nod_pln_dt"); //n1st_nod_pln_dt
	var ft = downSheet.CellValue(arrDRow[0], "n1st_nod_pln_dt_hms"); //from Departure Time
	var lvtypsz = topSheet.CellValue(arrTRow[0], "eq_tpsz_cd"); //Container Type/Size
	var lvtypsz2 = downSheet.CellValue(arrDRow[0], "eq_tpsz_cd"); //Container Type/Size

	var lvdrnod = topSheet.CellValue(arrTRow[0], "dor_nod_cd")+topSheet.CellValue(arrTRow[0], "dor_nod_yard");
	var lvdrnod2 = downSheet.CellValue(arrDRow[0], "dor_nod_cd")+downSheet.CellValue(arrDRow[0], "dor_nod_yard");
	var lvbndcd = topSheet.CellValue(arrTRow[0], "trsp_bnd_cd"); //I
	var lvbndcd2 = downSheet.CellValue(arrDRow[0], "trsp_bnd_cd"); //O
	var dd = topSheet.CellValue(arrTRow[0], "dor_nod_pln_dt"); //lst_nod_pln_dt I
	var dt = topSheet.CellValue(arrTRow[0], "dor_nod_pln_dt_hms"); //to dor_nod_pln_dt Time I
	var dd2 = downSheet.CellValue(arrDRow[0], "dor_nod_pln_dt"); //lst_nod_pln_dt O
	var dt2 = downSheet.CellValue(arrDRow[0], "dor_nod_pln_dt_hms"); //to dor_nod_pln_dt Time O

	var doc_cgo_tp_cd = downSheet.CellValue(arrDRow[0], "cgo_tp_cd"); //cgo_tp_cd F:M Empty 추가
	var lvtsep = eval(Number(td)-Number(fd)); //Planned Time(To Arrival)
	var timesep = 100000;
	if( td == fd ) {
		timesep = eval(Number(ft.substring(0,2))*60*60 + Number(ft.substring(2,4))*60 + Number(ft.substring(4))) - eval(Number(tt.substring(0,2))*60*60 + Number(tt.substring(2,4))*60 + Number(tt.substring(4)));
	} else {
		if( lvtsep == -1 ) {
			timesep = eval((Number(ft.substring(0,2))+24)*60*60 + Number(ft.substring(2,4))*60 + Number(ft.substring(4))) - eval(Number(tt.substring(0,2))*60*60 + Number(tt.substring(2,4))*60 + Number(tt.substring(4)));
		} else if( lvtsep == 1 ) {
			timesep = eval((Number(tt.substring(0,2))+24)*60*60 + Number(tt.substring(2,4))*60 + Number(tt.substring(4))) - eval(Number(ft.substring(0,2))*60*60 + Number(ft.substring(2,4))*60 + Number(ft.substring(4)));
		}
	}
	var lvtsep2 = eval(Number(dd2)-Number(dd)); //Planned Time(Door Arrival)
	var timesep2 = 100000;
	if( dd2 == dd ) {
		timesep2 = eval(Number(dd2.substring(0,2))*60*60 + Number(dd2.substring(2,4))*60 + Number(dd2.substring(4))) - eval(Number(dd.substring(0,2))*60*60 + Number(dd.substring(2,4))*60 + Number(dd.substring(4)));
	} else {
		if( lvtsep == -1 ) {
			timesep = eval((Number(dt.substring(0,2))+24)*60*60 + Number(dt.substring(2,4))*60 + Number(dt.substring(4))) - eval(Number(dt2.substring(0,2))*60*60 + Number(dt2.substring(2,4))*60 + Number(dt2.substring(4)));
		} else if( lvtsep == 1 ) {
			timesep = eval((Number(dt2.substring(0,2))+24)*60*60 + Number(dt2.substring(2,4))*60 + Number(dt2.substring(4))) - eval(Number(dt.substring(0,2))*60*60 + Number(dt.substring(2,4))*60 + Number(dt.substring(4)));
		}
	}

	if( lvcostmode == "CY" && lvcostmode2 == "CY" ) {
		if( lvtranmode.indexOf("T") < 0 || lvtranmode2.indexOf("T") < 0 ) {
			return false;
		} else {
			if( doc_cgo_tp_cd == "F" ) { //FULL CONTAINAER인 경우는
				if( lvtonod == lvfmnod2 && lvtypsz == lvtypsz2 ) {
					if( td == fd ) {
						if( timesep > chk_time || timesep < -chk_time ) {
							return false;
						}
					} else {
						if( timesep > chk_time ) {
							return false;
						}
					}
				} else { 
					return false;
				}
				topSheet.CellValue2(arrTRow[0], "trsp_so_cmb_tp_cd") = "FF";
				downSheet.CellValue2(arrDRow[0], "trsp_so_cmb_tp_cd") = "FF";
			} else { //EMPTY CONTAINER인 경우는 동일한 날짜일 경우만 가능
				if( lvtonod == lvfmnod2 && lvtypsz == lvtypsz2 ) {
					if( td != fd ) {
						return false;
					}
				} else {
					return false;
				}
				topSheet.CellValue2(arrTRow[0], "trsp_so_cmb_tp_cd") = "FM";
				downSheet.CellValue2(arrDRow[0], "trsp_so_cmb_tp_cd") = "FM";
			}
		}
	} else if( lvcostmode == "DOOR" && lvcostmode2 == "DOOR" ) {
		if( lvbndcd == "I" && lvbndcd2 == "O" && lvtranmode.indexOf("T") > 0 && lvtranmode2.indexOf("T") > 0 ) { //김종욱수석요청.
			if( lvdrnod == lvdrnod2 && lvtypsz == lvtypsz2 ) {
				if( dd2 == dd ) {
					if( timesep2 > chk_time || timesep2 < -chk_time ) {
						return false;
					}
				} else {
					if( timesep2 > chk_time ) {
						return false;
					}
				}				
			} else {
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}

	for (ic = 0; ic<=topSheet.LastCol; ic++) {
		colOrder += topSheet.ColSaveName(ic)+"|";
	}

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	if( ir % 2 == 0 )
		iz++;

	if( iz % 2 == 0 ) 
		lvcolor = "220,234,162";
	else
		lvcolor = "255,255,255";

	//옮길 데이터를 xml로 구성한다.
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";
	rowXml = "<TR BGCOLOR='"+lvcolor+"'>";
	for (ic = 0; ic<=topSheet.LastCol; ic++) {
		if( topSheet.ColSaveName(ic) == "chk1" ) {
			rowXml += "<TD></TD>";
		} else if( topSheet.ColSaveName(ic) == "ibflag" ) {
			rowXml += "<TD></TD>";
		} else if( topSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
			rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + topSheet.CellValue(arrTRow[0], ic) + "</TD>";
		} else if( topSheet.ColSaveName(ic) == "dor_svc_tp_cd") {
			rowXml += "<TD COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + topSheet.CellValue(arrTRow[0], ic) + "</TD>";
		} else if( topSheet.ColSaveName(ic) == "lst_loc_cd"  ) { //추가
			var sText = topSheet.GetComboInfo(arrTRow[0], "lst_loc_cd", "Text");
			var sCode = topSheet.GetComboInfo(arrTRow[0], "lst_loc_cd", "Code");
			rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + topSheet.CellValue(arrTRow[0], ic) + "</TD>";
		} else if( topSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
			rowXml += "<TD>"+iz+"-1</TD>";
		} else if( topSheet.ColSaveName(ic) == "shpr_cust_nm" || topSheet.ColSaveName(ic) == "cnee_cust_nm" || topSheet.ColSaveName(ic) == "ntfy_cust_nm" || topSheet.ColSaveName(ic) == "cmdt_name" || topSheet.ColSaveName(ic) == "scremark" || topSheet.ColSaveName(ic) == "dor_de_addr" ) {
			rowXml += "<TD><![CDATA[" + topSheet.CellValue(arrTRow[0], ic) + "]]></TD>";
		} else if( topSheet.ColSaveName(ic) == "spcl_instr_rmk" || topSheet.ColSaveName(ic) == "inter_rmk" ) {
			rowXml += "<TD BGCOLOR='222,251,248'><![CDATA[" + topSheet.CellValue(arrTRow[0], ic) + "]]></TD>";
		} else if( topSheet.ReadDataProperty(arrTRow[0], ic, dpDataType) == 6 ) {
			rowXml += "<TD COMBO-TEXT='"+topSheet.CellText(arrTRow[0], ic)+"' COMBO-CODE='"+topSheet.CellText(arrTRow[0], ic)+"'>" + topSheet.CellValue(arrTRow[0], ic) + "</TD>";
		} else {
			rowXml += "<TD><![CDATA[" + topSheet.CellValue(arrTRow[0],ic) + "]]></TD>";
		}
	}
	rowXml += "</TR><TR BGCOLOR='"+lvcolor+"'>";
	for (ic = 0; ic<=downSheet.LastCol; ic++) {
		var lvTranMod = downSheet.CellValue(arrDRow[0], "trsp_cost_dtl_mod_cd");

		if( downSheet.ColSaveName(ic) == "chk1" ) {
			rowXml += "<TD></TD>";
		} else if( downSheet.ColSaveName(ic) == "ibflag" ) {
			rowXml += "<TD></TD>";
		} else if( downSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
			rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + downSheet.CellValue(arrDRow[0], ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "dor_svc_tp_cd" ) {
			if( lvTranMod == "DOOR" ) { //지연 대리 요청 20070115
				rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + downSheet.CellValue(arrDRow[0], ic) + "</TD>";
			} else {
				rowXml += "<TD COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'></TD>";
			}
		} else if( downSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
			var sText = downSheet.GetComboInfo(arrDRow[0], "lst_loc_cd", "Text");
			var sCode = downSheet.GetComboInfo(arrDRow[0], "lst_loc_cd", "Code");
			rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + downSheet.CellValue(arrDRow[0], ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
			rowXml += "<TD>"+iz+"-2</TD>";
		} else if( downSheet.ReadDataProperty(arrDRow[0], ic, dpDataType) == 6 ) {
			rowXml += "<TD COMBO-TEXT='"+downSheet.CellText(arrDRow[0], ic)+"' COMBO-CODE='"+downSheet.CellText(arrDRow[0], ic)+"'>" + downSheet.CellValue(arrDRow[0], ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "dor_de_addr" || downSheet.ColSaveName(ic) == "fctry_nm" || downSheet.ColSaveName(ic) == "cntc_pson_phn_no" || downSheet.ColSaveName(ic) == "cntc_pson_fax_no" || downSheet.ColSaveName(ic) == "cntc_pson_nm" ) {
			if( lvTranMod == "DOOR" ) { //지연 대리 요청 20070115
				rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
			} else {
				rowXml += "<TD>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
			}
		} else if( downSheet.ColSaveName(ic) == "n1st_nod_pln_dt" ) {
			rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "n1st_nod_pln_dt_hms" ) {
			rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "lst_nod_pln_dt" ) {
			rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "lst_nod_pln_dt_hms" ) {
			rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "dor_nod_pln_dt" ) {
			rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "dor_nod_pln_dt_hms" ) {
			rowXml += "<TD BGCOLOR='222,251,248' EDIT='TRUE'>" + downSheet.CellValue(arrDRow[0],ic) + "</TD>";
		} else if( downSheet.ColSaveName(ic) == "shpr_cust_nm" || downSheet.ColSaveName(ic) == "cnee_cust_nm" || downSheet.ColSaveName(ic) == "ntfy_cust_nm" || downSheet.ColSaveName(ic) == "cmdt_name" || downSheet.ColSaveName(ic) == "scremark" ) {
			rowXml += "<TD><![CDATA[" + downSheet.CellValue(arrDRow[0], ic) + "]]></TD>";
		} else if( downSheet.ColSaveName(ic) == "spcl_instr_rmk" || downSheet.ColSaveName(ic) == "inter_rmk" ) {
			rowXml += "<TD BGCOLOR='222,251,248'><![CDATA[" + downSheet.CellValue(arrDRow[0], ic) + "]]></TD>";
		} else {
			rowXml += "<TD><![CDATA[" + downSheet.CellValue(arrDRow[0],ic) + "]]></TD>";
		}
	}
	rowXml += "</TR>";
	allXml += rowXml;
	topSheet.RowDelete(arrTRow[0], false);
	downSheet.RowDelete(arrDRow[0], false);

	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);

	downSheet.RemoveAll();
	var allXml2 = "<?xml version='1.0'?><RESULT><TR-ALL>NO</TR-ALL><MESSAGE>"+ComGetMsg("TRS90374")+"</MESSAGE></RESULT>";
	
	downSheet.LoadSearchXml(allXml2, true);
}

//Single Transportation --> Combined CNTR Trans. Case Two
function IBS_Sheet2SheetStatus5(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = fromSheet.FindCheckedRow(sStatus);
	
	var arrRow = sRow.split("|");
	
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting

	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		//옮길 데이터를 xml로 구성한다.
		rowXml = "<TR>";
		for (ic = 0; ic<=fromSheet.LastCol; ic++) {
			if( fromSheet.ColSaveName(ic) == "chk1" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "source" ) {
				rowXml += "<TD>COP</TD>";
			} else if( fromSheet.ColSaveName(ic) == "fm_nod_yard" || fromSheet.ColSaveName(ic) == "to_nod_yard" || fromSheet.ColSaveName(ic) == "via_nod_yard" || fromSheet.ColSaveName(ic) == "dor_nod_yard" ) {
				rowXml += "<TD COMBO-TEXT='"+fromSheet.CellText(fromRow, ic)+"' COMBO-CODE='"+fromSheet.CellText(fromRow, ic)+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
				rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "dor_svc_tp_cd") {
				rowXml += "<TD COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "shpr_cust_nm" || fromSheet.ColSaveName(ic) == "cnee_cust_nm" || fromSheet.ColSaveName(ic) == "ntfy_cust_nm" || fromSheet.ColSaveName(ic) == "cmdt_name" || fromSheet.ColSaveName(ic) == "scremark" || fromSheet.ColSaveName(ic) == "inter_rmk" || fromSheet.ColSaveName(ic) == "spcl_instr_rmk" || fromSheet.ColSaveName(ic) == "dor_de_addr" ) {
				rowXml += "<TD><![CDATA[" + fromSheet.CellValue(fromRow,ic) + "]]></TD>";
			} else if( fromSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
				var sText = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Text");
				var sCode = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Code");
				rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else {
				rowXml += "<TD><![CDATA[" + fromSheet.CellValue(fromRow,ic) + "]]></TD>";
			}
		}
		rowXml += "</TR>";
		allXml += rowXml;
	}

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);

	toSheet.CellValue(2, "chk1") = "1";
//	doActionIBSheet(toSheet, document.form, IBSEARCH);
}

//팝업창을 닫기 하였을 때
function doSheetSheetCheck() {
	var fromSheet = sheetObjects[0];
	var toSheet = sheetObjSingle;

	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var sRow = fromSheet.RowCount;
	var rowCount = fromSheet.RowCount + toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting
	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < sRow; ir++) {
		//옮길 데이터를 xml로 구성한다.
		rowXml = "<TR>";
		for (ic = 0; ic<=fromSheet.LastCol; ic++) {
			var costDtl = fromSheet.CellValue(ir+2, "trsp_cost_dtl_mod_cd");
			var trspMod = fromSheet.CellValue(ir+2, "trsp_crr_mod_cd"); //단일운송, 복합운송비교하기 위한 값
			var lvbool = false;
			if( trspMod.indexOf("D") < 0 ) {
				lvbool = true;
			} else {
				lvbool = false;
			}

			if( fromSheet.ColSaveName(ic) == "chk1" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "fm_nod_yard" || fromSheet.ColSaveName(ic) == "to_nod_yard" || fromSheet.ColSaveName(ic) == "dor_nod_yard" ) {
				rowXml += "<TD COMBO-TEXT='"+fromSheet.CellText(ir+2, ic)+"' COMBO-CODE='"+fromSheet.CellText(ir+2, ic)+"'>" + fromSheet.CellValue(ir+2, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "via_nod_yard" ) {
				if( lvbool ) { //지연대리 요청으로 수정 20070115
					rowXml += "<TD EDIT='TRUE' COMBO-TEXT='"+fromSheet.CellText(ir+2, ic)+"' COMBO-CODE='"+fromSheet.CellText(ir+2, ic)+"'>" + fromSheet.CellValue(ir+2, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "via_nod_cd" ) { //지연대리 요청으로 수정 20070115
				if( lvbool ) {
					rowXml += "<TD EDIT='TRUE'>" + fromSheet.CellValue(ir+2, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
				rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + fromSheet.CellValue(ir+2, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "dor_svc_tp_cd") { //지연대리 요청으로 수정 20070115
				if( costDtl == "DOOR" ) {
					rowXml += "<TD EDIT='TRUE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + fromSheet.CellValue(ir+2, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "dor_de_addr" || fromSheet.ColSaveName(ic) == "fctry_nm" || fromSheet.ColSaveName(ic) == "cntc_pson_phn_no" || fromSheet.ColSaveName(ic) == "cntc_pson_fax_no" || fromSheet.ColSaveName(ic) == "cntc_pson_nm" ) { //지연대리 요청으로 수정 20070115
				if( costDtl == "DOOR" ) {
					rowXml += "<TD EDIT='TRUE'>" + fromSheet.CellValue(ir+2, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "shpr_cust_nm" || fromSheet.ColSaveName(ic) == "cnee_cust_nm" || fromSheet.ColSaveName(ic) == "ntfy_cust_nm" || fromSheet.ColSaveName(ic) == "cmdt_name" || fromSheet.ColSaveName(ic) == "scremark" || fromSheet.ColSaveName(ic) == "inter_rmk" || fromSheet.ColSaveName(ic) == "spcl_instr_rmk" ) {
				rowXml += "<TD><![CDATA[" + fromSheet.CellValue(ir+2,ic) + "]]></TD>";
			} else if( fromSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
				var sText = fromSheet.GetComboInfo(ir+2, "lst_loc_cd", "Text");
				var sCode = fromSheet.GetComboInfo(ir+2, "lst_loc_cd", "Code");
				rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'><![CDATA[" + fromSheet.CellValue(ir+2, ic) + "]]></TD>";
			} else {
				rowXml += "<TD><![CDATA[" + fromSheet.CellValue(ir+2,ic) + "]]></TD>";
			}

		}
		rowXml += "</TR>";
		allXml += rowXml;

	}
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = (sRow+1); ir >=0 ; ir--) {
		//원본에서 지움
		fromSheet.RowDelete(ir, false);
	}
	allXml += "</DATA></SHEET>";
	//opener.form.bkg_no.value = allXml;
	toSheet.LoadSearchXml(allXml, true);
}

function doClosePopup() { //Window창의 X를 클릭했을 때 호출됨.
	doSheetSheetCheck();
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function sheet_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null){
		ComShowMessage(errMsg);
	}
}
