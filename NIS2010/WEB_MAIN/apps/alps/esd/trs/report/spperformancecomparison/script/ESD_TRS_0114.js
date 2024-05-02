/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0114.js
*@FileTitle : Expense Summary by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 민정호
*@LastVersion : 1.7
* 2009.01.07 최종혁
* 1.0 최초 생성
*----------------------------------------------------------
* History
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
 * @class ESD_TRS_0114 
 */
function ESD_TRS_0114() {
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

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0 ;
var strActionMenu = "Default S/P Hidden|Lowest S/P Hidden|Actual PFMC Lowest S/P Hidden";

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
  sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
 
function loadPage() { 
	var formObject = document.form;
	var sel_input_office =formObject.sel_input_office.value;

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	getTrsIbComboList(formObject.sel_sotype , 'Y' ,  'CY/DOOR' , '');  //Service Order Type
	getTrsIbComboList(formObject.sel_costmode , 'CY|DR|LS|TS' ,  'CY|DOOR|LOCAL SHUTTLE|T/S sHUTTLE' , 'ALL');  //Cost Mode
	getTrsIbComboList(formObject.sel_transmode , sel_transmodeCode , sel_transmodeText  , 'ALL');  
	getTrsIbComboList(formObject.sel_bound , sel_boundCode  , sel_boundText  , 'ALL');  
	
	var strSpOptionNm = "W/O S/P = Default S/P" + //00
			"|W/O S/P = Default S/P(CNT Same)" + //01
			"|W/O S/P = Default S/P(CNT Different)" + //02
			"|W/O S/P <> Default S/P" + //10
			"|W/O S/P = Lowest S/P" + //20
			"|W/O S/P <> Lowest S/P" + //30
			"|W/O S/P = Lowest S/P(Actual)" + //40
			"|W/O S/P <> Lowest S/P(Actual)"; //50
	
	getTrsIbComboList(formObject.sel_spoption , '00|01|02|10|20|30|40|50' , strSpOptionNm , 'ALL');  //S/P Option
	
	// IBMultiCombo 설정
	for(var k = 0; k < comboObjects.length; k++){
		comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
	}
	
	formObject.sel_sotype.code2 = "Y";
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    /*
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    */
}

/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
//            ComKeyOnlyAlphabet('uppernum');
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
    var cnt = 0;
	switch(sheetNo) {
	case 1:      //sheet1 init
          with (sheetObj) {
              // 높이 설정
              style.height = 386;
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

              // 해더에서 처리할 수 있는 각종 기능을 설정한다
              InitHeadMode(true, false, false, true, false,false)
              
              var HeadTitle0 =  "Seq|RHQ|W/O\nOffice|W/O No|S/O No|CNTR No|Reason of\nS/P Select|Cost\nMode|Trans\nMode|" +
              "Customer Information|Customer Information|Customer Information|"+
              "Route Information|Route Information|Route Information|Route Information|"+
              "Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|Default S/P|" +
              "Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|Lowest S/P (AGMT)|" +
              "Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|Lowest S/P (Actual Performance)|" +
              "Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|Work Order|" +
              "Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|Discrepancy 1 (Default vs W/O)|" +
              "Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|Discrepancy 2 (AGMT Lowest vs W/O)|" +
              "Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)|Discrepancy 3 (Actual PFMC Lowest vs W/O)"; 

              var HeadTitle1 =  "Seq|RHQ|W/O\nOffice|W/O No|S/O No|CNTR No|Reason of\nS/P Select|Cost\nMode|Trans\nMode|" +
              "S/C No.|RFA No.|Contract\nCustomer Name|"+
              "From|Via|To|Door|"+
              "Code|Name|CNT\nType|AGMT No|W/O\nUSED S/P\nCount|AGMT\nUpdate Date|AGMT\nWeight Tier|AGMT\nCommodity\nCode|CUR|Basic|Fuel|VAT|Toll|Total|Total(USD)|"+
              "Code|Name|CNT\nType|AGMT No|W/O\nUSED S/P\nCount|AGMT\nUpdate Date|AGMT\nWeight Tier|AGMT\nCommodity\nCode|CUR|Basic|Fuel|VAT|Toll|Total|Total(USD)|More\nCandidate|"+
              "Code|Name|CNT\nType|AGMT No|W/O\nUSED S/P\nCount|AGMT\nUpdate Date|AGMT\nWeight Tier|AGMT\nCommodity\nCode|CUR|Basic|Fuel|VAT|Toll|Total|Total(USD)|"+
              "Code|Name|CNT\nType|AGMT No|CUR|Basic|Nego|Fuel|VAT|Toll|Additional|Total|Total(USD)|"+
              "Basic|Nego|Fuel|VAT|Toll|Additional|Total|Total (USD)|"+
              "Basic|Nego|Fuel|VAT|Toll|Additional|Total|Total (USD)|"+
              "Basic|Nego|Fuel|VAT|Toll|Additional|Total|Total (USD)";
              
			  var HeadCount = ComCountHeadTitle(HeadTitle0);
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			  InitColumnInfo(HeadCount, 6, 0, true);

              //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              InitHeadRow(0, HeadTitle0, true);
              InitHeadRow(1, HeadTitle1, true);

              //데이터속성    [ROW, COL,  DATATYPE,  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              InitDataProperty(0, cnt++ , dtSeq,	30,    daCenter,   	true,    " ",	false,      	"",	  dfNone,          0,     false,       false);
              InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "rhq_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "wo_ofc_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "wo_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "so_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "eq_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "trsp_sp_cng_rsn_nm",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "trsp_cost_dtl_mod_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "trsp_crr_mod_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sc_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rfa_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 160, daLeft, true, "cust_nm",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "fm_nod_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "via_nod_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "to_nod_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "dor_nod_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "dflt_vndr_seq",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "dflt_vndr_nm",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "dflt_cust_nomi_trkr_ind_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "dflt_agmt_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daRight, true, "dflt_usd_vndr_wo_qty",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 115, daRight, true, "dflt_trsp_agmt_upd_dt",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "dflt_to_wgt",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 75, daRight, true, "dflt_cmdt_grp_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "dflt_curr_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "dflt_bzc_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_fuel_scg_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_scg_vat_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_toll_fee_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "dflt_ttl_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "dflt_ttl_usd_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daRight, true, "low_vndr_seq",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "low_vndr_nm",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "low_cust_nomi_trkr_ind_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "low_agmt_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daRight, true, "low_usd_vndr_wo_qty",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 115, daRight, true, "low_trsp_agmt_upd_dt",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "low_to_wgt",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 75, daRight, true, "low_cmdt_grp_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "low_curr_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "low_bzc_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_fuel_scg_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_scg_vat_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_toll_fee_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "low_ttl_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "low_ttl_usd_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 65, daRight, true, "low_agmt_mor_cnddt_qty",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daRight, true, "usd_low_vndr_seq",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "usd_low_vndr_nm",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "usd_low_cust_nomi_trkr_ind_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "usd_low_agmt_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daRight, true, "usd_low_vndr_wo_qty",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 115, daRight, true, "usd_low_trsp_agmt_upd_dt",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "usd_low_to_wgt",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 75, daRight, true, "usd_low_cmdt_grp_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "usd_low_curr_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "usd_low_bzc_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_fuel_scg_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_scg_vat_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_toll_fee_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "usd_low_ttl_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "usd_low_ttl_usd_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 60, daRight, true, "wo_vndr_seq",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "wo_vndr_nm",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "wo_cust_nomi_trkr_ind_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "wo_agmt_no",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "wo_curr_cd",    false, "", dfNone, 0, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wo_bzc_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "wo_nego_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "wo_fuel_scg_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "wo_scg_vat_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "wo_toll_fee_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "wo_etc_add_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wo_ttl_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wo_ttl_usd_amt",    false, "", dfNullFloat, 2, false, false);
              
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_bzc_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "dflt_nego_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_fuel_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_vat_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_toll_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_etc_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_ttl_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "dflt_ttl_usd_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_bzc_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "low_nego_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_fuel_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_vat_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_toll_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_etc_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_ttl_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "low_ttl_usd_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_bzc_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 80, daRight, true, "usd_low_nego_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_fuel_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_vat_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_toll_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_etc_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_ttl_comp_amt",    false, "", dfNullFloat, 2, false, false);
              InitDataProperty(0, cnt++, dtData, 70, daRight, true, "usd_low_ttl_usd_comp_amt",    false, "", dfNullFloat, 2, false, false);
              
              ActionMenu = strActionMenu;
         }  
    }
}


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */  
function processButtonClick(){
    var sheetObject  = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        /***********************************************************************************************************
          이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
          공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.    
         **********************************************************************************************************/
        /*
          이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
          메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
          (순서상도 form[1]이 되겠죠?) 
          그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
          document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
        */
        switch(srcName) {
          case "btns_calendar":
            getCalendar();
            break;
            
          case "btns_frmnode": //FromNode Popup창
            openHireYardPopup('getFromNode');
          	break;
          
          case "btns_vianode": //ViaNode Popup창
            openHireYardPopup('getViaNode');
          	break;
          
          case "btns_tonode": //ToNode Popup창
            openHireYardPopup('getToNode');
          	break;
          
          case "btns_dorloc": //DoorLocation Popup창
            openHireYardPopup('getDorLoc');
          	break;

          case "btng_downexcel":
            if (sheetObject.RowCount < 1) return;
            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            break;
            
          case "btns_office": //M CNTR
            if( validation_check() ) {
              var ofc_cd = formObject.sel_input_office.value;
			  ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
            }  
            break;
          case "btn_retrieve":      
			// DATE 가 없으면 BKG,CNTR,SO,WO No 중 하나는 있어야한다.
			if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
				if ( (ComIsNull(formObject.sel_bkgno) || ComIsEmpty(formObject.sel_bkgno))
					&& (ComIsNull(formObject.sel_cntrno) || ComIsEmpty(formObject.sel_cntrno))
					&& (ComIsNull(formObject.sel_sono) || ComIsEmpty(formObject.sel_sono))
					&& (ComIsNull(formObject.sel_wono) || ComIsEmpty(formObject.sel_wono))
					) 
				{
					ComShowCodeMessage("TRS90124");
					return false;
				}
			}

            if (ComIsNull(formObject.sel_input_office) || ComIsEmpty(formObject.sel_input_office)) {
              ComShowCodeMessage("TRS90124")+" (Office Code)";
              return false;
            }
          
            var days_between = ComGetDaysBetween(formObject.from_date , formObject.to_date) ;  // 조회 기간
            if ( days_between > 15 ) {
              ComShowMessage(" Possible inquiry period is limited to 15 day.");
              return false;
            }
            
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
            break;
          case "btn_minimize":
            Mincount = (Mincount+1)%2 ;
            Minimize(Mincount);
            break;
        } // end switch
    }catch(e) {     
        /*
          자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
          물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
        if( e == "[object Error]") {
          ComShowMessage(OBJECT_ERROR);
        } else {
          ComShowMessage(e);
        }
    }
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg = false;
  switch(sAction) {
     case IBSEARCH:   //조회
      
      if(!validateForm(sheetObj,formObj,sAction)) {
        return false;
      }
      
      formObj.hid_from_date.value = removeBar(formObj.from_date.value);
      formObj.hid_to_date.value = removeBar(formObj.to_date.value);
      
			if(document.search_fm_yard.Code != '' || formObj.search_fm_loc.value != '') {
				formObj.hid_from_node.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
			}else{
				formObj.hid_from_node.value = '';
			}
			if(document.search_via_yard.Code != '' || formObj.search_via_loc.value != '') {
				formObj.hid_via_node.value = formObj.search_via_loc.value+document.search_via_yard.Code;
			}else{
				formObj.hid_via_node.value = '';
			}
			if(document.search_to_yard.Code != '' || formObj.search_to_loc.value != '') {
				formObj.hid_to_node.value = formObj.search_to_loc.value+document.search_to_yard.Code;
			}else{
				formObj.hid_to_node.value = '';
			}
			if(document.search_door_yard.Code != '' || formObj.search_door_loc.value != '') {
				formObj.hid_door_node.value = formObj.search_door_loc.value+document.search_door_yard.Code;
			}else{
				formObj.hid_door_node.value = '';
			}
      
			formObj.f_cmd.value = SEARCH01;
			
			//alert ( TrsFrmQryString(formObj) ) ;
			
			sheetObj.DoSearch4Post("ESD_TRS_0114GS.do", TrsFrmQryString(formObj));
     
      break;

    case IBDOWNEXCEL:  //엑셀내려받기
      sheetObj.SpeedDown2Excel(true);
      break;
  }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
  with(formObj){
    /**
     * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
     */
    //if (!ComIsNumber(formObj.iPage)) {
    //  return false;
     // }
  }
  
  return true;
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

function Minimize(nItem)
{
	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(22);
	}
	else
	{
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(17);
	}
}

/******* inquiryComm 추가 *******/
var ctMode = 0; //COST MODE, TRANS MODE 조합, 1-단일운송,DOOR제외, 2-복합운송,DOOR제외, 3-단일운송,DOOR, 4-복합운송,DOOR

/*
 * 멀티 달력 입력 Pop-Up
 */

function getCalendar() {
	var cal = new ComCalendarFromTo();
    cal.displayType = "date";
    cal.select(document.form.from_date, document.form.to_date, 'yyyyMMdd');
}

/*
* 외부 콤보박스의 리스트 가져오기 (ESD_TRS_003.js에도 존재).
*/
function getComboList(obj, comObj, sep) { 
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;
	
	for (var i = 0; i < lvobj.length; i++) {
		var oneChar = lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
			}else {
				charval ="N";
				break;
			}
		} else {
			charval ="N";
			break;
		}
	}
	
	if(charval=="Y") {
	} else {
		var errMessage = ComGetMsg('COM12130','Location','Node Code','');  
		ComShowMessage(errMessage);
		obj.value = "";
		obj.focus();
		return false;
	}
	
	if( lvobj == "" ) {
		obj.value = "";
		if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
		else if(obj.name == 'search_via_loc') yard_obj = document.search_via_yard;
		else if(obj.name == 'search_to_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;

		var locValue = obj.value;
		if(ComTrim(locValue) == ''){
			yard_obj.RemoveAll();
			return;
		}
	} else if( lvobj.length != 5 ) {
		//ComShowCodeMessage("TRS90074");
		if(sep=="F"){
			formObj.search_fm_loc.select();
			formObj.search_fm_loc.focus();
		}else if(sep=="V"){
			formObj.search_via_loc.select();
			formObj.search_via_loc.focus();
		}else if(sep=="T"){
			formObj.search_to_loc.select();
			formObj.search_to_loc.focus();
		}else if(sep=="D"){
			formObj.search_door_loc.select();
			formObj.search_door_loc.focus();
		}else{
		}
	}else{
		if( sep == 'F' ) {
			lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'V' ){
			lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'T' ){
			lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else{
		}
		comObj.focus();
	}
	
}

/**
* enter check
**/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'combo_svc_provider_chld':
				getTextVndrSeq(sheetObj, formObj, obj.value, "chld");
				break;
			case 'combo_svc_provider_prnt':
				getTextVndrSeq(sheetObj, formObj, obj.value, "prnt");
				break;
		}
	}
}

/*
* 포커스주기
*/
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

/*
* '-' 없애기
*/
function fun_Focus_del(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

/*
* string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
*/
function removeBar(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++ ) {
		var ch = str.charAt(i);
		if ( ch != '-' ) value = value + ch;
	}
	return value;
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
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
* Via Node 팝업에 대한 리턴값
*/
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
	document.search_via_yard.CODE = lvYard;
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
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
* Door Location 팝업에 대한 리턴값
*/
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}

/**
* blur시 데이타체크
*/
function BlurDate(obj) {
	var f =  document.form;
	var dt = obj.value;
	if( dt == ""){
	} else {
		if ( isValidDate(dt)) {
			if( dt.length == 8 ) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage("TRS90070");
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage("TRS90070");
		obj.select();
		obj.focus();
		return;
	}
}

/**
* 유효 날짜 체크(2)
*/
function isValidDate(date) {
	var year = date.substring(0,4);
	var month = date.substring(4,6);
	var day = date.substring(6,8);

	if (isDatecheck(year, month, day) ) {
		return true;
	} else {
		return false;
	}
}
	 
/**
* 유효 날짜 체크(1)
*/
function isDatecheck( year,month,day ) {
	if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) ) {
		return true;
	} else {
		return false;
	}
}

/**
* 월 체크
*/
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12 ) {
		return true;
	} else {
		return false;
	}
}

/**
* 유효 날짜 체크
*/
function checkDay( yyyy, mm, dd ) {
	var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	var im = parseInt(mm,10) - 1;
	if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) ) {
		monthDD[1] = 29;
	}
	if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] ) {
		return false;
	} else {
		return true;
	}
}

/**
* 날자포맷으로 yyyy-mm-dd
*/
function addBar(dt) {
	var dat="";
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}

/**
* 날자포맷으로 yyyy-mm-dd
*/
function addBar_from(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.from_date.value= dat;
}

/**
* 날자포맷으로 yyyy-mm-dd
*/
function addBar_to(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;

	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.to_date.value= dat;
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.sel_input_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.sel_input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.sel_input_office.value = document.form.old_ofc_cd.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.sel_input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.sel_input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.sel_input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}

/**
 * 팝업호출
 */
function so_OnPopupClick(val) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var title = val;
	var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	if(returnval=="Booking No."){
		var x2=document.form.sel_bkgno.value;
		if(x2==""){
			document.form.sel_bkgno.value = rowArray;
			formObject.sel_bkgno.focus();
		}else{
			document.form.sel_bkgno.value = document.form.sel_bkgno.value+","+rowArray;
			formObject.sel_bkgno.focus();
		}
	}else if(returnval=="Container No."){
		var x4=document.form.sel_cntrno.value;
		if(x4==""){
			document.form.sel_cntrno.value = rowArray;
			formObject.sel_cntrno.focus();
		}else{
		    document.form.sel_cntrno.value = document.form.sel_cntrno.value+","+rowArray;
			formObject.sel_cntrno.focus();
		}
	}else if(returnval=="S/O No."){
		var x5=document.form.sel_sono.value;
		if(x5==""){
			document.form.sel_sono.value = rowArray;
			formObject.sel_sono.focus();
		}else{
			document.form.sel_sono.value = document.form.sel_sono.value+","+rowArray;
			formObject.sel_sono.focus();
		}
	}else if(returnval=="W/O No."){
		var x5=document.form.sel_wono.value;
		if(x5==""){
			document.form.sel_wono.value = rowArray;
			formObject.sel_wono.focus();
		}else{
			document.form.sel_wono.value = document.form.sel_wono.value+","+rowArray;
			formObject.sel_wono.focus();
		}
	}else{
	}
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
 
 function fun_compact() {
	 var doc_compack = document.form.chk_compact;
	 if( doc_compack.checked == true ) {
		 sheetObjects[0].ColHidden("trsp_sp_cng_rsn_nm") = true;
		 
		 sheetObjects[0].ColHidden("sc_no") = true;
		 sheetObjects[0].ColHidden("rfa_no") = true;
		 sheetObjects[0].ColHidden("cust_nm") = true;
		 
		 sheetObjects[0].ColHidden("dflt_vndr_nm") = true;
		 sheetObjects[0].ColHidden("dflt_usd_vndr_wo_qty") = true;
		 sheetObjects[0].ColHidden("dflt_trsp_agmt_upd_dt") = true;
		 sheetObjects[0].ColHidden("dflt_to_wgt") = true;
		 sheetObjects[0].ColHidden("dflt_cmdt_grp_cd") = true;
		 sheetObjects[0].ColHidden("dflt_curr_cd") = true;
		 sheetObjects[0].ColHidden("dflt_fuel_scg_amt") = true;
		 sheetObjects[0].ColHidden("dflt_scg_vat_amt") = true;
		 sheetObjects[0].ColHidden("dflt_toll_fee_amt") = true;
		 sheetObjects[0].ColHidden("dflt_ttl_usd_amt") = true;
		 
		 sheetObjects[0].ColHidden("low_vndr_nm") = true;
		 sheetObjects[0].ColHidden("low_usd_vndr_wo_qty") = true;
		 sheetObjects[0].ColHidden("low_trsp_agmt_upd_dt") = true;
		 sheetObjects[0].ColHidden("low_to_wgt") = true;
		 sheetObjects[0].ColHidden("low_cmdt_grp_cd") = true;
		 sheetObjects[0].ColHidden("low_curr_cd") = true;
		 sheetObjects[0].ColHidden("low_fuel_scg_amt") = true;
		 sheetObjects[0].ColHidden("low_scg_vat_amt") = true;
		 sheetObjects[0].ColHidden("low_toll_fee_amt") = true;
		 sheetObjects[0].ColHidden("low_ttl_usd_amt") = true;
		 sheetObjects[0].ColHidden("low_agmt_mor_cnddt_qty") = true;
		 
		 sheetObjects[0].ColHidden("usd_low_vndr_nm") = true;
		 sheetObjects[0].ColHidden("usd_low_vndr_wo_qty") = true;
		 sheetObjects[0].ColHidden("usd_low_trsp_agmt_upd_dt") = true;
		 sheetObjects[0].ColHidden("usd_low_to_wgt") = true;
		 sheetObjects[0].ColHidden("usd_low_cmdt_grp_cd") = true;
		 sheetObjects[0].ColHidden("usd_low_curr_cd") = true;
		 sheetObjects[0].ColHidden("usd_low_fuel_scg_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_scg_vat_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_toll_fee_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_ttl_usd_amt") = true;
	
		 sheetObjects[0].ColHidden("wo_vndr_nm") = true;
		 sheetObjects[0].ColHidden("wo_curr_cd") = true;
		 sheetObjects[0].ColHidden("wo_fuel_scg_amt") = true;
		 sheetObjects[0].ColHidden("wo_scg_vat_amt") = true;
		 sheetObjects[0].ColHidden("wo_toll_fee_amt") = true;
		 sheetObjects[0].ColHidden("wo_ttl_usd_amt") = true;
		 
		 sheetObjects[0].ColHidden("dflt_nego_comp_amt") = true;
		 sheetObjects[0].ColHidden("dflt_fuel_comp_amt") = true;
		 sheetObjects[0].ColHidden("dflt_vat_comp_amt") = true;
		 sheetObjects[0].ColHidden("dflt_toll_comp_amt") = true;
		 sheetObjects[0].ColHidden("dflt_etc_comp_amt") = true;
//		 sheetObjects[0].ColHidden("dflt_ttl_usd_comp_amt") = true;
		 
		 sheetObjects[0].ColHidden("low_nego_comp_amt") = true;
		 sheetObjects[0].ColHidden("low_fuel_comp_amt") = true;
		 sheetObjects[0].ColHidden("low_vat_comp_amt") = true;
		 sheetObjects[0].ColHidden("low_toll_comp_amt") = true;
		 sheetObjects[0].ColHidden("low_etc_comp_amt") = true;
//		 sheetObjects[0].ColHidden("low_ttl_usd_comp_amt") = true;
		
		 sheetObjects[0].ColHidden("usd_low_nego_comp_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_fuel_comp_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_vat_comp_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_toll_comp_amt") = true;
		 sheetObjects[0].ColHidden("usd_low_etc_comp_amt") = true;
//		 sheetObjects[0].ColHidden("usd_low_ttl_usd_comp_amt") = true;
	 }else{
		 sheetObjects[0].ColHidden("trsp_sp_cng_rsn_nm") = false;
		 
         sheetObjects[0].ColHidden("sc_no") = false;
         sheetObjects[0].ColHidden("rfa_no") = false;
         sheetObjects[0].ColHidden("cust_nm") = false;
         
         sheetObjects[0].ColHidden("dflt_vndr_nm") = false;
         sheetObjects[0].ColHidden("dflt_usd_vndr_wo_qty") = false;
         sheetObjects[0].ColHidden("dflt_trsp_agmt_upd_dt") = false;
         sheetObjects[0].ColHidden("dflt_to_wgt") = false;
         sheetObjects[0].ColHidden("dflt_cmdt_grp_cd") = false;
         sheetObjects[0].ColHidden("dflt_curr_cd") = false;
         sheetObjects[0].ColHidden("dflt_fuel_scg_amt") = false;
         sheetObjects[0].ColHidden("dflt_scg_vat_amt") = false;
         sheetObjects[0].ColHidden("dflt_toll_fee_amt") = false;
         sheetObjects[0].ColHidden("dflt_ttl_usd_amt") = false;
         
         sheetObjects[0].ColHidden("low_vndr_nm") = false;
         sheetObjects[0].ColHidden("low_usd_vndr_wo_qty") = false;
         sheetObjects[0].ColHidden("low_trsp_agmt_upd_dt") = false;
         sheetObjects[0].ColHidden("low_to_wgt") = false;
         sheetObjects[0].ColHidden("low_cmdt_grp_cd") = false;
         sheetObjects[0].ColHidden("low_curr_cd") = false;
         sheetObjects[0].ColHidden("low_fuel_scg_amt") = false;
         sheetObjects[0].ColHidden("low_scg_vat_amt") = false;
         sheetObjects[0].ColHidden("low_toll_fee_amt") = false;
         sheetObjects[0].ColHidden("low_ttl_usd_amt") = false;
         sheetObjects[0].ColHidden("low_agmt_mor_cnddt_qty") = false;
         
         sheetObjects[0].ColHidden("usd_low_vndr_nm") = false;
         sheetObjects[0].ColHidden("usd_low_vndr_wo_qty") = false;
         sheetObjects[0].ColHidden("usd_low_trsp_agmt_upd_dt") = false;
         sheetObjects[0].ColHidden("usd_low_to_wgt") = false;
         sheetObjects[0].ColHidden("usd_low_cmdt_grp_cd") = false;
         sheetObjects[0].ColHidden("usd_low_curr_cd") = false;
         sheetObjects[0].ColHidden("usd_low_fuel_scg_amt") = false;
         sheetObjects[0].ColHidden("usd_low_scg_vat_amt") = false;
         sheetObjects[0].ColHidden("usd_low_toll_fee_amt") = false;
         sheetObjects[0].ColHidden("usd_low_ttl_usd_amt") = false;
 
         sheetObjects[0].ColHidden("wo_vndr_nm") = false;
         sheetObjects[0].ColHidden("wo_curr_cd") = false;
         sheetObjects[0].ColHidden("wo_fuel_scg_amt") = false;
         sheetObjects[0].ColHidden("wo_scg_vat_amt") = false;
         sheetObjects[0].ColHidden("wo_toll_fee_amt") = false;
         sheetObjects[0].ColHidden("wo_ttl_usd_amt") = false;
         
         sheetObjects[0].ColHidden("dflt_nego_comp_amt") = false;
         sheetObjects[0].ColHidden("dflt_fuel_comp_amt") = false;
         sheetObjects[0].ColHidden("dflt_vat_comp_amt") = false;
         sheetObjects[0].ColHidden("dflt_toll_comp_amt") = false;
         sheetObjects[0].ColHidden("dflt_etc_comp_amt") = false;
//         sheetObjects[0].ColHidden("dflt_ttl_usd_comp_amt") = false;
         
         sheetObjects[0].ColHidden("low_nego_comp_amt") = false;
         sheetObjects[0].ColHidden("low_fuel_comp_amt") = false;
         sheetObjects[0].ColHidden("low_vat_comp_amt") = false;
         sheetObjects[0].ColHidden("low_toll_comp_amt") = false;
         sheetObjects[0].ColHidden("low_etc_comp_amt") = false;
//         sheetObjects[0].ColHidden("low_ttl_usd_comp_amt") = false;
        
         sheetObjects[0].ColHidden("usd_low_nego_comp_amt") = false;
         sheetObjects[0].ColHidden("usd_low_fuel_comp_amt") = false;
         sheetObjects[0].ColHidden("usd_low_vat_comp_amt") = false;
         sheetObjects[0].ColHidden("usd_low_toll_comp_amt") = false;
         sheetObjects[0].ColHidden("usd_low_etc_comp_amt") = false;
//         sheetObjects[0].ColHidden("usd_low_ttl_usd_comp_amt") = false;
	 }
 }

function sheet1_OnSelectMenu(sheetObj, MenuString){
	
	 switch(MenuString){
		case('Default S/P Hidden'):
			sheetObj.ColHidden("dflt_vndr_seq") = true;
			sheetObj.ColHidden("dflt_vndr_nm") = true;
			sheetObj.ColHidden("dflt_cust_nomi_trkr_ind_cd") = true;
			sheetObj.ColHidden("dflt_agmt_no") = true;
			sheetObj.ColHidden("dflt_usd_vndr_wo_qty") = true;
			sheetObj.ColHidden("dflt_trsp_agmt_upd_dt") = true;
			sheetObj.ColHidden("dflt_to_wgt") = true;
			sheetObj.ColHidden("dflt_cmdt_grp_cd") = true;
			sheetObj.ColHidden("dflt_curr_cd") = true;
			sheetObj.ColHidden("dflt_bzc_amt") = true;
			sheetObj.ColHidden("dflt_fuel_scg_amt") = true;
			sheetObj.ColHidden("dflt_scg_vat_amt") = true;
			sheetObj.ColHidden("dflt_toll_fee_amt") = true;
			sheetObj.ColHidden("dflt_ttl_amt") = true;
			sheetObj.ColHidden("dflt_ttl_usd_amt") = true;	
			sheetObj.ColHidden("dflt_bzc_comp_amt") = true;	
			sheetObj.ColHidden("dflt_nego_comp_amt") = true;	
			sheetObj.ColHidden("dflt_fuel_comp_amt") = true;	
			sheetObj.ColHidden("dflt_vat_comp_amt") = true;	
			sheetObj.ColHidden("dflt_toll_comp_amt") = true;	
			sheetObj.ColHidden("dflt_etc_comp_amt") = true;	
			sheetObj.ColHidden("dflt_ttl_comp_amt") = true;	
			sheetObj.ColHidden("dflt_ttl_usd_comp_amt") = true;
			strActionMenu = strActionMenu.replace(MenuString, "Default S/P Visible");
			sheetObj.ActionMenu = strActionMenu
		break;
		case('Default S/P Visible'):
            sheetObj.ColHidden("dflt_vndr_seq") = false;
	        sheetObj.ColHidden("dflt_vndr_nm") = false;
	        sheetObj.ColHidden("dflt_cust_nomi_trkr_ind_cd") = false;
	        sheetObj.ColHidden("dflt_agmt_no") = false;
	        sheetObj.ColHidden("dflt_usd_vndr_wo_qty") = false;
	        sheetObj.ColHidden("dflt_trsp_agmt_upd_dt") = false;
	        sheetObj.ColHidden("dflt_to_wgt") = false;
	        sheetObj.ColHidden("dflt_cmdt_grp_cd") = false;
	        sheetObj.ColHidden("dflt_curr_cd") = false;
	        sheetObj.ColHidden("dflt_bzc_amt") = false;
	        sheetObj.ColHidden("dflt_fuel_scg_amt") = false;
	        sheetObj.ColHidden("dflt_scg_vat_amt") = false;
	        sheetObj.ColHidden("dflt_toll_fee_amt") = false;
	        sheetObj.ColHidden("dflt_ttl_amt") = false;
	        sheetObj.ColHidden("dflt_ttl_usd_amt") = false;   
	        sheetObj.ColHidden("dflt_bzc_comp_amt") = false;  
	        sheetObj.ColHidden("dflt_nego_comp_amt") = false; 
	        sheetObj.ColHidden("dflt_fuel_comp_amt") = false; 
	        sheetObj.ColHidden("dflt_vat_comp_amt") = false;  
	        sheetObj.ColHidden("dflt_toll_comp_amt") = false; 
	        sheetObj.ColHidden("dflt_etc_comp_amt") = false;  
	        sheetObj.ColHidden("dflt_ttl_comp_amt") = false;  
	        sheetObj.ColHidden("dflt_ttl_usd_comp_amt") = false;
	        strActionMenu = strActionMenu.replace(MenuString, "Default S/P Hidden");
	        sheetObj.ActionMenu = strActionMenu
		break;
		case('Lowest S/P Hidden'):
			sheetObj.ColHidden("low_vndr_seq") = true;
			sheetObj.ColHidden("low_vndr_nm") = true;
			sheetObj.ColHidden("low_cust_nomi_trkr_ind_cd") = true;
			sheetObj.ColHidden("low_agmt_no") = true;
			sheetObj.ColHidden("low_usd_vndr_wo_qty") = true;
			sheetObj.ColHidden("low_trsp_agmt_upd_dt") = true;
			sheetObj.ColHidden("low_to_wgt") = true;
			sheetObj.ColHidden("low_cmdt_grp_cd") = true;
			sheetObj.ColHidden("low_curr_cd") = true;
			sheetObj.ColHidden("low_bzc_amt") = true;
			sheetObj.ColHidden("low_fuel_scg_amt") = true;
			sheetObj.ColHidden("low_scg_vat_amt") = true;
			sheetObj.ColHidden("low_toll_fee_amt") = true;
			sheetObj.ColHidden("low_ttl_amt") = true;
			sheetObj.ColHidden("low_ttl_usd_amt") = true;
			sheetObj.ColHidden("low_agmt_mor_cnddt_qty") = true;
			sheetObj.ColHidden("low_bzc_comp_amt") = true;	
			sheetObj.ColHidden("low_nego_comp_amt") = true;	
			sheetObj.ColHidden("low_fuel_comp_amt") = true;	
			sheetObj.ColHidden("low_vat_comp_amt") = true;	
			sheetObj.ColHidden("low_toll_comp_amt") = true;	
			sheetObj.ColHidden("low_etc_comp_amt") = true;	
			sheetObj.ColHidden("low_ttl_comp_amt") = true;	
			sheetObj.ColHidden("low_ttl_usd_comp_amt") = true;	
			strActionMenu = strActionMenu.replace(MenuString, "Lowest S/P Visible");
			sheetObj.ActionMenu = strActionMenu
		break;
		case('Lowest S/P Visible'):
            sheetObj.ColHidden("low_vndr_seq") = false;
	        sheetObj.ColHidden("low_vndr_nm") = false;
	        sheetObj.ColHidden("low_cust_nomi_trkr_ind_cd") = false;
	        sheetObj.ColHidden("low_agmt_no") = false;
	        sheetObj.ColHidden("low_usd_vndr_wo_qty") = false;
	        sheetObj.ColHidden("low_trsp_agmt_upd_dt") = false;
	        sheetObj.ColHidden("low_to_wgt") = false;
	        sheetObj.ColHidden("low_cmdt_grp_cd") = false;
	        sheetObj.ColHidden("low_curr_cd") = false;
	        sheetObj.ColHidden("low_bzc_amt") = false;
	        sheetObj.ColHidden("low_fuel_scg_amt") = false;
	        sheetObj.ColHidden("low_scg_vat_amt") = false;
	        sheetObj.ColHidden("low_toll_fee_amt") = false;
	        sheetObj.ColHidden("low_ttl_amt") = false;
	        sheetObj.ColHidden("low_ttl_usd_amt") = false;
	        sheetObj.ColHidden("low_agmt_mor_cnddt_qty") = false;
	        sheetObj.ColHidden("low_bzc_comp_amt") = false;   
	        sheetObj.ColHidden("low_nego_comp_amt") = false;  
	        sheetObj.ColHidden("low_fuel_comp_amt") = false;  
	        sheetObj.ColHidden("low_vat_comp_amt") = false;   
	        sheetObj.ColHidden("low_toll_comp_amt") = false;  
	        sheetObj.ColHidden("low_etc_comp_amt") = false;   
	        sheetObj.ColHidden("low_ttl_comp_amt") = false;   
	        sheetObj.ColHidden("low_ttl_usd_comp_amt") = false;
	        strActionMenu = strActionMenu.replace(MenuString, "Lowest S/P Hidden");
	        sheetObj.ActionMenu = strActionMenu
		break;
		case('Actual PFMC Lowest S/P Hidden'):
            sheetObj.ColHidden("usd_low_vndr_seq") = true;
	        sheetObj.ColHidden("usd_low_vndr_nm") = true;
	        sheetObj.ColHidden("usd_low_cust_nomi_trkr_ind_cd") = true;
	        sheetObj.ColHidden("usd_low_agmt_no") = true;
	        sheetObj.ColHidden("usd_low_vndr_wo_qty") = true;
	        sheetObj.ColHidden("usd_low_trsp_agmt_upd_dt") = true;
	        sheetObj.ColHidden("usd_low_to_wgt") = true;
	        sheetObj.ColHidden("usd_low_cmdt_grp_cd") = true;
	        sheetObj.ColHidden("usd_low_curr_cd") = true;
	        sheetObj.ColHidden("usd_low_bzc_amt") = true;
	        sheetObj.ColHidden("usd_low_fuel_scg_amt") = true;
	        sheetObj.ColHidden("usd_low_scg_vat_amt") = true;
	        sheetObj.ColHidden("usd_low_toll_fee_amt") = true;
	        sheetObj.ColHidden("usd_low_ttl_amt") = true;
	        sheetObj.ColHidden("usd_low_ttl_usd_amt") = true;
	        sheetObj.ColHidden("usd_low_bzc_comp_amt") = true;   
	        sheetObj.ColHidden("usd_low_nego_comp_amt") = true;  
	        sheetObj.ColHidden("usd_low_fuel_comp_amt") = true;  
	        sheetObj.ColHidden("usd_low_vat_comp_amt") = true;   
	        sheetObj.ColHidden("usd_low_toll_comp_amt") = true;  
	        sheetObj.ColHidden("usd_low_etc_comp_amt") = true;   
	        sheetObj.ColHidden("usd_low_ttl_comp_amt") = true;   
	        sheetObj.ColHidden("usd_low_ttl_usd_comp_amt") = true;    
	        strActionMenu = strActionMenu.replace(MenuString, "Actual PFMC Lowest S/P Visible");
	        sheetObj.ActionMenu = strActionMenu
		break;
		case('Actual PFMC Lowest S/P Visible'):
            sheetObj.ColHidden("usd_low_vndr_seq") = false;
	        sheetObj.ColHidden("usd_low_vndr_nm") = false;
	        sheetObj.ColHidden("usd_low_cust_nomi_trkr_ind_cd") = false;
	        sheetObj.ColHidden("usd_low_agmt_no") = false;
	        sheetObj.ColHidden("usd_low_vndr_wo_qty") = false;
	        sheetObj.ColHidden("usd_low_trsp_agmt_upd_dt") = false;
	        sheetObj.ColHidden("usd_low_to_wgt") = false;
	        sheetObj.ColHidden("usd_low_cmdt_grp_cd") = false;
	        sheetObj.ColHidden("usd_low_curr_cd") = false;
	        sheetObj.ColHidden("usd_low_bzc_amt") = false;
	        sheetObj.ColHidden("usd_low_fuel_scg_amt") = false;
	        sheetObj.ColHidden("usd_low_scg_vat_amt") = false;
	        sheetObj.ColHidden("usd_low_toll_fee_amt") = false;
	        sheetObj.ColHidden("usd_low_ttl_amt") = false;
	        sheetObj.ColHidden("usd_low_ttl_usd_amt") = false;
	        sheetObj.ColHidden("usd_low_bzc_comp_amt") = false;   
	        sheetObj.ColHidden("usd_low_nego_comp_amt") = false;  
	        sheetObj.ColHidden("usd_low_fuel_comp_amt") = false;  
	        sheetObj.ColHidden("usd_low_vat_comp_amt") = false;   
	        sheetObj.ColHidden("usd_low_toll_comp_amt") = false;  
	        sheetObj.ColHidden("usd_low_etc_comp_amt") = false;   
	        sheetObj.ColHidden("usd_low_ttl_comp_amt") = false;   
	        sheetObj.ColHidden("usd_low_ttl_usd_comp_amt") = false;
	        strActionMenu = strActionMenu.replace(MenuString, "Actual PFMC Lowest S/P Hidden");
	        sheetObj.ActionMenu = strActionMenu
		break;	
		
	 }
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.sel_input_office.value = obj;
}