/*
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_MAS_0035.js
*@FileTitle      : Inquire by Srouce Data
*Open Issues     :
*Change history  :
*@LastModifyDate : 2010.02.22 
*@LastModifier   : 이연각
*@LastVersion    : 1.0
* 2006-12-07 Kim Jong Beom
* 1.0 최초 생성
*=========================================================
* History
* 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*                Year, Month, Week관련 화면변경에 따른 Script변경
* 2008.02.26 PEJ N200802220016 MAS 조회 기간 관련 수정 요청
*                2007.07, 2007.27 이전 데이터를 조회 할수 없도록 함
* 2008.02.28 PEJ N200802250022 MAS_RD 관련 수정 요청
*                SOC 항목 추가
* 2008.02.21 PEJ N200802280015 MAS_Report 관련 수정 요청_3번항목
*                - Sales Rep 정보 이원화 : C.S.Rep과 L.Rep으로 구분
*                - OFC 정보 세분화 및 명칭 변경 : C.RHQ, C.AD, C.OFC, L.RHQ, L.AD, L.OFC
*                - CMDT 관련 정보 위치 변경 : REP CMDT, CMDT CD, CMDT DESC
*                - Cust CD = > CUST CD
*                - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화[035]
* 2008.03.21 PEJ R200803125390 P/L 화면 보완 요청_1,2번항목
*                Week선택시에 Month, Week를 입력할수 있도록 변경
* 2008.04.29 임옥영 N200804280007 Source Data Download 수정
* 2008.06.24 PEJ N200806120005 MAS_Report 조회 오류
* 2008.07.15 박은주 N200806270002 Inquiry by Source Data 화면의 Misc 컬럼 제거 Total만 남겨둠[035]
* 2008.08.29 박은주 CSR No. N200807290002 Expense Detail로 테이블 변경하면서 화면단 모두 변경[035]
* 2008.10.14 박상희 Shipper 검색조건으로 조회가 가능하도록 수정
* 2008.10.21 전윤주 N200810200014 REV MT , DG, BB, AK 항목 추가 [035]
* 2008.10.21 박상희 Filedownload 기간제한 설정
* 2008.11.24 박상희 N200811060006 Weight 정보 추가
* 2008.12.05 박상희 FileDownload 월별조회 - Trade 제약조건 추가
* 2008.12.16 박상희 N200811270017 STP Cost 를 Other-vol activity cost로 변경
* 2008.12.30 박상희 FileDownload - 1week 조회 시 Trade 제약조건 삭제.
* 2009.02.02 임옥영 N200901190016 - MAS_조직개편 관련 기능 수정 changeCostYrmon추가, f_ofc_lvl_OnChange수정
* 2009.02.03 박상희 N200901210013 - 조회기간 제약조건 수정
* 2009.02.10 임옥영 N200902090050
* 2009.02.10 박상희 N200902090063 - Head Office 또는 RHQ에서 Office를 All로 조회시 제약조건 추가
* 2009.04.24 박상희 N200904070094 CM 계산수식 변경
* 2009.04.30 박상희 N200904160100 Report Item 변경 및 추가
* 2009.05.14 박상희 N200904160100 OP COST, OP 추가 [035]
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.10.12 김기식 Alps전환작업
* 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
* 2010.02.10 윤진영 CHM-200901765 TAA_NO 추가
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.05.07 윤진영 load total 값 소수점 2자리로 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2011.03.18 최성민 [CHM-201109506-01] Inquiry by Source data Void제거 기능추가
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.05.13 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가
* 2011.07.26 김상수 [CHM-201112106-01] Retrieve, File Download 기능을 Back end job 으로 기능 수정
* 2012.01.03 이석준 [CHM-201114896-01] CM2 비용 반영
* 2012.07.18 이석준 [CHM-201219034-01] Inquiry by source data 계정 추가
* 
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.05.07 박찬민 [CHM-201324571] [MAS] Inquiry by source Data 권한 관련 - OFC_CD = SELCDA 일 경우 Lane 선택 하지 않아도 조회 가능
* 2013.10.07 박찬민 [CHM-201326932] [MAS] T/S 기준의 BKG Data 확보를 위한 MAS 화면 수정/개발 요청
* 2014.01.16 김수정 [CHM-201428540] [MAS] Inquiry by Source Data 정보 추가 요청
* 2015.05.14 손진환 [CHM-201535424] [MAS] MAS 상 Fixed Rate 반영 / Fixed Rate가 checked일때 Lane 선택없이 조회되도록 수정
* 2015.05.27 손진환 [CHM-201536029] [MAS] MAS 상 Fixed Rate 반영 요청 CSR
* 2015.07.21 손진환 [CHM-201536959] [MAS] Inquiry by Source Data에서 Sub Trade 구분자 삽입 요청 CSR
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2016.04.26 김성욱 Input에 포커스 있는 상태에서 combo로 포커스 이동시 콤보 안열리는 현상 처리
* 2017.04.06 김동호 SELCSG/조지윤 차장님 요청으로 file download 시 기간 제한 validation 삭제. 
* 2017.06.01 김동호 [CSR #1026] CM(BKG) Total 컬럼 추가
* 2017.06.05 김동호 [CSR #1049] 2017년도 이후 데이터에 대해서는 검색 제약 조건 해제.
* 2017.07.28 김동호 [CSR #1661] Login Office가 BA, BB 인 경우 해당 OFC_CD의 내역만 조회(하위 포함)
* 2017.11.20 김동호 [CSR #2557] CM(BKG) Total 컬럼 제거
*=========================================================*/

/**
 * @fileoverview
 * @author 한진해운
 */

/**
 * @extends
 * @class ESM_MAS_0035 : ESM_MAS_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0035() {
    this.processButtonClick = processButtonClick;
    this.loadPage = loadPage;
    this.initCombo = initCombo;
    this.initSheet = initSheet;
    this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
    this.setPeriod = setPeriod;
    this.fTrdCdOnChange = fTrdCdOnChange;
    this.rPTFormOnChange = rPTFormOnChange;
    this.fOfcLvlOnChange = fOfcLvlOnChange;
    this.shipperPopUp = shipperPopUp;
    this.comPopupLoc = comPopupLoc;
    this.getComEns021_1 = getComEns021_1;
    this.getComEns021_2 = getComEns021_2;
    this.changeCostYrmon = changeCostYrmon;
    this.doActionIBSheet = doActionIBSheet;
    this.doActionIBSheet2 = doActionIBSheet2;
    this.validateCond = validateCond;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var sheet_selno = ""; //현재선택된 SHEET

var RPTForm_Acct = "ACCT"; //Account
var RPTForm_TpSz = "TPSZ"; //Type Size

var sheet_height1 = 20; // sheet1의 height
var sheet_height2 = 20; // sheet2의 height
var TmrID;

var saveFileName = "";
var timer = null;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
                if (sheet_selno == RPTForm_Acct) { //첫번째 SHEET 이면
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    } else if (sheet_selno == RPTForm_TpSz) { //두번째 SHEET 이면
                        doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
                    }
                    break;

                case "btn_downexcel":
                    if (sheet_selno == RPTForm_Acct) {        //첫번째 SHEET 이면
                        doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    } else if (sheet_selno == RPTForm_TpSz) { //두번째 SHEET 이면
                        doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
                    }
                    break;

                case "btn_filedownload":
                    if (sheet_selno == RPTForm_Acct) {        //첫번째 SHEET 이면
                        doActionIBSheet(sheetObject1,formObject,IBCREATE);
                    } else if (sheet_selno == RPTForm_TpSz) { //두번째 SHEET 이면
                        doActionIBSheet2(sheetObject2,formObject,IBCREATE);
                    }
                    break;
                
                case "btn_sendmail":
                    if (sheet_selno == RPTForm_Acct) {        //첫 번째 SHEET 이면
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
                    } else if (sheet_selno == RPTForm_TpSz) { //두 번째 SHEET 이면
                        doActionIBSheet2(sheetObject2,formObject,IBSEARCH_ASYNC01);
                    }
                    break;

                case "bu_zoom_in1": //next
                case "bu_zoom_in2":
                    if (sheet_selno == RPTForm_Acct) { //첫번째 SHEET 이면
                        sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",1);
                        sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
                        div_zoom_in1.style.display = "none";
                        div_zoom_out1.style.display = "inline";
                        parent.syncHeight();
                    } else if (sheet_selno == RPTForm_TpSz) { //두번째 SHEET 이면
                        sheet_height2 = getSheetHeightCnt(sheetObject2,"MAX",1);
                        sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
                        div_zoom_in2.style.display = "none";
                        div_zoom_out2.style.display = "inline";
                        parent.syncHeight();
                    }
                    break;

                case "bu_zoom_out1": //next
                case "bu_zoom_out2":
                    if (sheet_selno == RPTForm_Acct) { //첫번째 SHEET 이면
                        sheet_height1 = getSheetHeightCnt(sheetObject1,"MIN",0);
                        sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
                        div_zoom_in1.style.display = "inline";
                        div_zoom_out1.style.display = "none";
                        parent.syncHeight();
                    } else if (sheet_selno == RPTForm_TpSz) { //두번째 SHEET 이면
                        sheet_height2 = getSheetHeightCnt(sheetObject2,"MIN",0);
                        sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
                        div_zoom_in2.style.display = "inline";
                        div_zoom_out2.style.display = "none";
                        parent.syncHeight();
                    }
                    break;


            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        var formObject = document.form;

        loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

        // 멀티콤보 처리 (시작) ---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k], k+1);
        }
        // 멀티콤보 처리 (종료) ---------------------------------------------

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //---------------------------------------------
        /*
        formObject.f_year.value = ComGetNowInfo("yy");
        formObject.f_sls_mon.value = ComGetNowInfo("mm").lpad(2, "0");
        formObject.f_year.focus();*/

        document.getElementById("tabLayer2").style.display = "none"; // tabLayer2.style.display = "none";
        RPTForm_Acct = "ACCT";
        RPTForm_TpSz = "TPSZ";
        sheet_selno = RPTForm_Acct; //현재선택된 SHEET (첫번째 쉬트)

        //Profit Level 에 OP 권한 확인
        ComMasOpCheckOfcCd(formObject.f_pro_lvl, ComGetObjValue(formObject.f_usr_lgn_ofc_cd));
        
        loadingMode = false;
        
        formObject.f_ofc_vw.Code = "L"; // Loading 을 기본으로...

        // [CSR 1661] Login Office Type 이 BA나 BB이면 자기 OFC만 조회 가능.
        if(formObject.f_usr_ofc_tp_cd.value == "BA" || formObject.f_usr_ofc_tp_cd.value == "BB") {
            if(formObject.f_usr_lgn_ofc_lvl.value < 5 || !ComIsNumber(formObject.f_usr_lgn_ofc_lvl.value)) {
                formObject.f_ofc_lvl.Code = "5";
            } else {
                formObject.f_ofc_lvl.Code = formObject.f_usr_lgn_ofc_lvl.value;
            }
            formObject.f_ofc_lvl.Enable = false;
            setTimeout(function() {
                formObject.f_ofc_cd.Code = formObject.f_usr_lgn_ofc_cd.value;
                formObject.f_ofc_cd.Enable = false;
            }, 500);
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
     * @return 없음
     * @author 최성민
     * @version 2011.03.18
     */
      function initCombo(comboObj, comboId) {
          switch(comboObj.id) {
             case "f_pro_vw":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     Index = 0;
                 }
                 break;
             case "f_ofc_vw":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     Index = 0;
                 }
                 break;
            case "f_pro_lvl":
                with(comboObj) {
                    DropHeight = 300;
                    MultiSelect = false;
                    MaxSelect = 1;
                    Index = 0;
                }
                break;
           case "f_ofc_lvl":
                with(comboObj) {
                    DropHeight = 300;
                    MultiSelect = false;
                    MaxSelect = 1;
                    Index = 0;
                }
                break;
             case "f_ofc_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 6;
                     UseAutoComplete = false;
                     ValidChar(2, 1);    //영문대문자+숫자
                     Index = 0;
                 }
                 break;
             case "f_trd_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 3;
                     UseAutoComplete = false;
                     ValidChar(2, 1);    //영문대문자+숫자
                     Index = 0;
                 }
                 break;
             case "f_sub_trd_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 2;
                     UseAutoComplete = false;
                     ValidChar(2, 1);    //영문대문자+숫자
                     Index = 0;
                 }
                 break;
             case "f_rlane_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 5;
                     UseAutoComplete = false;
                     ValidChar(2, 1);    //영문대문자+숫자
                     Index = 0;
                 }
                 break;
             case "f_ioc_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 1;
                     UseAutoComplete = false;
                     ValidChar(2, 0);    //영문만 입력
                     Index = 0;
                 }
                 break;
             case "f_dir_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 1;
                     UseAutoComplete = false;
                     ValidChar(2, 0);    //영문만 입력
                     Index = 0;
                 }
                 break;
             case "f_rep_cmdt_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 4;
                     UseAutoComplete = false;
                     ValidChar(2, 1);    //영문대문자+숫자
                     Index = 0;
                 }
                 break;
             case "f_usa_bkg_mod_cd":
                 with(comboObj) {
                     DropHeight = 300;
                     MultiSelect = false;
                     MaxSelect = 1;
                     MaxLength = 10;
                     UseAutoComplete = false;
                     ValidChar(2, 0);    //영문만 입력
                     Index = 0;
                 }
             case "f_hul_bnd_cd":
                 with(comboObj) {
                     MultiSelect = false;
                     MaxSelect = 1;
                     ValidChar(2, 0);    //영문만 입력
                     Index = 0;
                 }
                 break;
         }
    }

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var formObj = document.form;
    var tpsz = "";
    var tpsz_cnt = 0;
    var rev_head = "";
    var load_hade = "";
    var cm_cost_hade = "";
    var cm2_cost_hade = "";
    var op_cost_hade = "";
    var cm_hade = "";
    var cm2_hade = "";
    var op_hade = "";
    var tmp_cnt = 0;
    var fix_cnt = 0;
    var var_cnt = 0;
    var HeadTitle = "";
    var n = 0;

    //HeadTitleCM  = "|Domestic Saving Credit"; // Agent Commission와 자리를 바꾸고 사이에 Oneway Saving를 추가함.
    /* 2017.08.03 [CSR #1531] 김동호 신규 장비비 계정으로 통합
    HeadTitleCM  = "|CNTR Short Term EQ Rental 1";
    HeadTitleCM += "|CNTR Long Term EQ Rental 1";
    HeadTitleCM += "|CNTR M&R Charge 1";
    HeadTitleCM += "|CNTR Depreciation 1";
    HeadTitleCM += "|CNTR Insurance 1";
    HeadTitleCM += "|CNTR Short Term EQ Rental 2";
    HeadTitleCM += "|CNTR Long Term EQ Rental 2";
    HeadTitleCM += "|CNTR M&R Charge 2";
    HeadTitleCM += "|CNTR Depreciation 2";
    HeadTitleCM += "|CNTR Insurance 2";
    */
    
    HeadTitleCM  = "|CNTR EQ Rental";
    HeadTitleCM += "|CNTR M&R Charge";
    HeadTitleCM += "|CNTR Depreciation";
    HeadTitleCM += "|CNTR Insurance";
    
    HeadTitleCM += "|Chassis EQ Cost";

    HeadTitleOP  = "|Port EXP";
    HeadTitleOP += "|Canal Transit Fee";
    HeadTitleOP += "|Bunker";
    HeadTitleOP += "|Crew EXP";
    HeadTitleOP += "|Insurance";
    HeadTitleOP += "|Lubricant EXP";
    HeadTitleOP += "|Store Supply EXP";
    HeadTitleOP += "|Vessel M&R";
    HeadTitleOP += "|Depreciations";
    HeadTitleOP += "|Telecom EXP";
    HeadTitleOP += "|Other Operation Fixed Exp";
    HeadTitleOP += "|Time Charterage";
    HeadTitleOP += "|Space Charterage";
    HeadTitleOP += "|General Expense";
    HeadTitleOP += "|Vessel Interest";
    
    switch(sheetNo) {
        case 1:      //sheet1 init
            if (strTpsz == "") {
                head1 = "|AAA|BBB|CCC|DDD|EEE|FFF";
                head2 = "|AAA|BBB|CCC|DDD|EEE|FFF";
            }
            tpsz = strTpsz.replace(/(^\s*)/g, '').split("|");
            tpsz_cnt = tpsz.length;

            for(j=1; j<tpsz_cnt; j++){
                rev_head  = rev_head  + "|FR_REV_" + tpsz[j];
                load_hade = load_hade + "|LOAD_"   + tpsz[j];
            }

            with (sheetObj) {

            	if(formObj.f_include_ts.checked && ComGetObjValue(formObj.f_rlane_cd) != "RBCCO"){
                    fix_cnt = 107;
		            HeadTitle = "SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|F_Index|BL NO|Inquiry Mon|Inquiry Week|Inquiry Trade|Inquiry Lane|Inquiry BND|Inquiry VVD|Inquiry Trade Dir.|TRADE|SUB TRD|R.LANE|IOC|REV VVD|Status|DIR|Trade Dir." //16개
		                  + "|C.RHQ|C.AD|C.OFC|C.Region OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.Region OFC|L.REP|BKG OFC|BKG STS|USA MODE|Trunk POL|Trunk POD|BKG POR|BKG POL|BKG POD|BKG DEL" //15개
		                  + "|RCV TERM|DEL TERM|Customs Desc|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|IAS RGN|TRADE1|TRADE2|TRADE3|TRADE4|TRADE5" //13개
		                  + "|LANE1|LANE2|LANE3|LANE4|LANE5|VVD1|VVD2|VVD3|VVD4|VVD5|T/S PORT|T/S POL|T/S POD|POL1|POL2|POL3|POL4|POL5|POD1|POD2|POD3|POD4|POD5" //15개
		                  + "|SC NO|RFA No|RFA Type|Source|NVOCC|CUST TP|SC/RFA CUST CD|SC/RFA CUST NM|G/Customer Code(Shipper)|G/Customer Name(Shipper)|G/Customer Type(C.Customer)|G/Customer Code(C.Customer)|G/Customer Name(C.Customer)|A/Customer Code|A/Customer Name|BKG SHPR CD|BKG SHPR NM" //8개
		                  + "|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT" //6개
		                  + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RF|DG|BB|AK|WEIGHT|UNIT" //9개
		                  //82개로 변경됨.
            	} else if(formObj.f_include_ts.checked && ComGetObjValue(formObj.f_rlane_cd) == "RBCCO"){
                    fix_cnt = 100;
		            HeadTitle = "SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|F_Index|BL NO|TRADE|SUB TRD|R.LANE|IOC|REV VVD|Status|DIR|Trade Dir." //15개
		                  + "|C.RHQ|C.AD|C.OFC|C.Region OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.Region OFC|L.REP|BKG OFC|BKG STS|USA MODE|Trunk POL|Trunk POD|BKG POR|BKG POL|BKG POD|BKG DEL" //19개
		                  + "|RCV TERM|DEL TERM|Customs Desc|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|IAS RGN|TRADE1|TRADE2|TRADE3|TRADE4|TRADE5" //13개
		                  + "|LANE1|LANE2|LANE3|LANE4|LANE5|VVD1|VVD2|VVD3|VVD4|VVD5|T/S PORT|T/S POL|T/S POD|POL1|POL2|POL3|POL4|POL5|POD1|POD2|POD3|POD4|POD5" //23개
		                  + "|SC NO|RFA No|RFA Type|Source|NVOCC|CUST TP|SC/RFA CUST CD|SC/RFA CUST NM|G/Customer Code(Shipper)|G/Customer Name(Shipper)|G/Customer Type(C.Customer)|G/Customer Code(C.Customer)|G/Customer Name(C.Customer)|A/Customer Code|A/Customer Name|BKG SHPR CD|BKG SHPR NM" //15개
		                  + "|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT" //6개
		                  + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RF|DG|BB|AK|WEIGHT|UNIT" //9개
		                
            	}else{
                    fix_cnt = 80;
                    
		            HeadTitle = "SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|F_Index|BL NO|TRADE|SUB TRD|R.LANE|IOC|REV VVD|Status|DIR|Trade Dir." //15개
		                  + "|C.RHQ|C.AD|C.OFC|C.Region OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.Region OFC|L.REP|BKG OFC|BKG STS|USA MODE|Trunk POL|Trunk POD|BKG POR|BKG POL|BKG POD|BKG DEL" //15개
		                  + "|RCV TERM|DEL TERM|Customs Desc|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|IAS RGN|TRADE1|TRADE2|TRADE3|TRADE4|TRADE5" //13개
		                  + "|LANE1|LANE2|LANE3|LANE4|LANE5|VVD1|VVD2|VVD3|VVD4|VVD5|T/S PORT|POL1|POL2|POL3|POL4|POL5|POD1|POD2|POD3|POD4|POD5" //15개
		                  + "|SC NO|RFA No|RFA Type|Source|NVOCC|CUST TP|SC/RFA CUST CD|SC/RFA CUST NM|G/Customer Code(Shipper)|G/Customer Name(Shipper)|G/Customer Type(C.Customer)|G/Customer Code(C.Customer)|G/Customer Name(C.Customer)|A/Customer Code|A/Customer Name|BKG SHPR CD|BKG SHPR NM" //8개
		                  + "|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT" //6개
		                  + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RF|DG|BB|AK|WEIGHT|UNIT" //9개
		                  ;
		                  //78개로 변경됨.
            	}
            	
            	if (ComGetObjValue(formObj.f_pro_vw) == "R" && ComGetObjValue(formObj.f_pro_lvl) == "O") {
                    var_cnt = 39; // 2015.04.22 수 Oneway Saving추가
                    HeadTitle = HeadTitle
                              + rev_head
                              + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL"
                              + load_hade
                              + "|LOAD_TTL(TEU)"
                              + "|Freight Revenue|Misc Operation Revenue|CNTR DEM/DET|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                              + "|Carriers Haulage Service Charge|Internal EQ Rental(EMU)_MT Repo Cost|Internal EQ Rental(EMU)_EMU Credit|Domestic Saving Credit|Oneway Saving|Agent Commission" // 2015.04.22 수 Oneway Saving추가
                              + "|CM Cost Total|CM Total"
                              + "|CNTR Fixed Cost|Chassis Fixed Cost" //EQ Cost 추가
                              + "|Own-Vol Activity Cost|Activity Cost for STP Expense|Internal Slot Rental(SMU Cost)"
                              + "|OP COST Total|BKG OP Total";
         		} else if (ComGetObjValue(formObj.f_pro_vw) == "R" && (ComGetObjValue(formObj.f_pro_lvl) == "C")) {                  
         			var_cnt = 43; // 2015.04.22 수 Oneway Saving추가
         			HeadTitle = HeadTitle
                              + rev_head
                              + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL"
                              + load_hade
                              + "|LOAD_TTL(TEU)"
                              + "|Freight Revenue|Misc Operation Revenue|CNTR DEM/DET|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                              + "|Carriers Haulage Service Charge|Internal EQ Rental(EMU)_MT Repo Cost|Internal EQ Rental(EMU)_EMU Credit|Domestic Saving Credit|Oneway Saving|Agent Commission"; // 2015.04.22 수 Oneway Saving추가
//                     if (ComGetObjValue(formObj.f_pro_lvl) == "M"){ // CM2 일때      
//                    	 var_cnt = 31;
//                         HeadTitle = HeadTitle + "|BKG CM Cost Total|BKG CM Total|BKG CM2 COST|BKG CM2 Cost Total|BKG CM2 Total";
//                     } else {
//                    	 var_cnt = 28;
//                    	 HeadTitle = HeadTitle + "|BKG CM Cost Total|BKG CM Total";
//                     }                	 
                	 HeadTitle += HeadTitleCM;  
                	 HeadTitle += "|CM Cost Total|CM Total";
         		} else if (ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "O") {
                     var_cnt = 45; // 2015.04.22 수 Oneway Saving추가
                     HeadTitle = HeadTitle
                              + rev_head
                              + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL"
                              + load_hade
                              + "|LOAD_TTL(TEU)"
                              + "|Freight Revenue|Misc Operation Revenue|CNTR DEM/DET|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                              + "|Carriers Haulage Service Charge|Empty Terminal Expense|Empty Transport Expense|Domestic Saving Credit|Oneway Saving|Agent Commission"
                              + HeadTitleCM ;
                     
                     HeadTitle = HeadTitle
                              + "|CM Cost Total|CM Total"
                              + HeadTitleOP
                              + "|OP COST Total|OP Total" ;

         		} else if (ComGetObjValue(formObj.f_pro_vw) == "P" && (ComGetObjValue(formObj.f_pro_lvl) == "C")) {
                     var_cnt = 27;
                     HeadTitle = HeadTitle
                              + rev_head
                              + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL"
                              + load_hade
                              + "|LOAD_TTL(TEU)";
                     
                     if (ComGetObjValue(formObj.f_pro_lvl) == "M"){ // CM2 일때
                    	 var_cnt = 32; // 2015.04.22 수 CM2일 경우는 쓰임이 없으므로 변경안함
                    	 HeadTitle = HeadTitle
                    	      + "|Freight Revenue|Misc Operation Revenue|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                              + "|Carriers Haulage Service Charge|Empty Terminal Expense|Empty Transport Expense|Agent Commission"
                              + "|CM Cost Total|CM Total|CM2 COST|CM2 Cost Total|CM2 Total ";
                              //54 개 ->42개
                     } else {
                    	 var_cnt = 43; // 2015.04.22 수 Oneway Saving추가
                    	 HeadTitle = HeadTitle
               	               + "|Freight Revenue|Misc Operation Revenue|CNTR DEM/DET|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                               + "|Carriers Haulage Service Charge|Empty Terminal Expense|Empty Transport Expense|Domestic Saving Credit|Oneway Saving|Agent Commission"
                               + HeadTitleCM 
                               + "|CM Cost Total|CM Total ";                    	 
                     }

                }
                style.height = GetSheetHeight(sheet_height1) ;

                SheetWidth = mainTable1.clientWidth;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msNone;  //msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 100);
                var headCount = ComCountHeadTitle(HeadTitle);
                InitColumnInfo(headCount, 5, 0, true);
                InitHeadMode(true, true, false, true, false, false);
                InitHeadRow(0, HeadTitle, false);

                 cnt = 0;
                //1~6
                InitDataProperty(0, cnt++, dtSeq,     35, daCenter, false, "", false, "", dfNone,    0, true, true); // SEQ
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // R.Month
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // S.Month
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Week
                InitDataProperty(0, cnt++, dtData,    90, daLeft,   false, "", false, "", dfNone,    0, true, true); // BKG No
                InitDataProperty(0, cnt++, dtData,    60, daCenter,   false, "", false, "", dfNone,    0, true, true); // F_Index
                InitDataProperty(0, cnt++, dtData,    90, daLeft,   false, "", false, "", dfNone,    0, true, true); // BL No
                if(formObj.f_include_ts.checked && ComGetObjValue(formObj.f_rlane_cd) != "RBCCO"){
                	InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Mon
                	InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Week
                	InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Trade
                	InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Lane
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry BOUND
	                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry VVD
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Trade Dir.
                }
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Trade
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Sub Trade
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // R.Lane
                InitDataProperty(0, cnt++, dtData,    40, daCenter, false, "", false, "", dfNone,    0, true, true); // IOC
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // REV VVD
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Status

                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // DIR
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // Trade Dir.
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.RHQ
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.AD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.OFC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.Region OFC
                InitDataProperty(0, cnt++, dtData,    75, daCenter, false, "", false, "", dfNone,    0, true, true); // C.S.Rep
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.RHQ
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // L.AD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.OFC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.Region OFC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.Rep
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG OFC

                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG STS
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // USA Mode
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Trunk POL
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Trunk POD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG POR
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG POL
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG POD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG DEL
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG R.Term
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG D.Term
                
                InitDataProperty(0, cnt++, dtData,   150, daLeft, 	false, "", false, "", dfNone,    0, true, true); // Customs Desc
                
                InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "", false, "", dfNone,    0, true, true); // REP CMDT CD
                InitDataProperty(0, cnt++, dtData,   150, daLeft,   false, "", false, "", dfNone,    0, true, true); // REP CMDT DESC

                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // CMDT CD
                InitDataProperty(0, cnt++, dtData,   150, daLeft,   false, "", false, "", dfNone,    0, true, true); // CMDT DESC
                InitDataProperty(0, cnt++, dtData,   100, daLeft,   false, "", false, "", dfNone,    0, true, true); // IAS Region Code
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE1
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE2
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE3
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE4
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE5
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane1
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane2
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane3
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane4
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane5

                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD1
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD2
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD3
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD4
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD5
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // T/S PORT
                if(formObj.f_include_ts.checked){
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // T/S POL
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // T/S POD
                }
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL1
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL2
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL3
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL4
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL5
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD1
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD2

                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD3
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD4
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD5
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // SC No
                InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "", false, "", dfNone,    0, true, true); // RFA No
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // RFA Type
                InitDataProperty(0, cnt++, dtData,  130, daCenter, false, "", false, "", dfNone,    0, true, true); // Source
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // NVOCC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // CUST TP
                InitDataProperty(0, cnt++, dtData,   110, daCenter, false, "", false, "", dfNone,    0, true, true); // SC CUST CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // SC CUST NM
                InitDataProperty(0, cnt++, dtData,   170, daCenter, false, "", false, "", dfNone,    0, true, true); // G/Customer Code(Shipper)
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // G/Customer Name(Shipper)
                InitDataProperty(0, cnt++, dtData,   180, daCenter, false, "", false, "", dfNone,    0, true, true); // G/Customer Type(C.Customer)
                InitDataProperty(0, cnt++, dtData,   180, daCenter, false, "", false, "", dfNone,    0, true, true); // G/Customer Code(C.Customer)
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // G/Customer Name(C.Customer)
                InitDataProperty(0, cnt++, dtData,   110, daCenter, false, "", false, "", dfNone,    0, true, true); // A/Customer Code
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // A/Customer Name
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG SHPR_CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // BKG SHPR_NM

                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // B/L SHPR NM
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // CNEE CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // CNEE NM
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // NOTIFY CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // NOTIFY NM
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // PPD CCT
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "", false, "", dfNone,    0, true, true); // BL OnBoard DT
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "", false, "", dfNone,    0, true, true); // CGO RCV DT
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // SOC
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // REV MT

                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // RF
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // DG
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // BB
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // AK
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight,  false, "", false, "", dfFloatOrg,1, true, true); // Weight
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Unit

                // FR_REV 가변
                for(j=1; j<tpsz_cnt; j++){
                    InitDataProperty(0, cnt, dtAutoSum, 80, daRight, false, "fr_rev_"+tpsz[n], false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(255, 248, 251);
                    cnt++;
                }
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, false,"fr_rev_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "fr_rev_tot") = WebColor("#FFD5D2");
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, false,"misc_rev_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "misc_rev_tot") = WebColor("#FFD5D2");
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, false,"rev_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "rev_tot") = WebColor("#FFD5D2");

                // LOAD 가변
                for(j=1; j<tpsz_cnt; j++){
                    InitDataProperty(0, cnt, dtAutoSum, 80, daRight, false, "load_"+tpsz[n], false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(255, 248, 251);
                    cnt++;
                }
                InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"load_tot", false, "",  dfFloatOrg, 2, true, true);
                CellBackColor(0, "load_tot") = WebColor("#FFD5D2");

                // CM COST ACCOUNT -------------------------------------------------------------------------------------
                tmp_cnt = cnt;
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Freight Revenue
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Misc Operation Revenue
//                if (ComGetObjValue(formObj.f_pro_lvl) == "O"){
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR DEM/DET
//                }
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Basic Stevedorage
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Other CY Expense
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // T/S Stevedorage
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // On Dock CY Expense
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Cargo Handling Expense
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Storage
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Misc Cargo Handling Expense
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Exclusive Terminal Additional Cost
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Cargo Variable Volume Discount
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Rail Direct
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Rail Truck
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Truck Direct
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Water Direct
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Water Rail
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Water Truck
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Other Transport Expense
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Carriers Haulage Service Charge
                 
                if(ComGetObjValue(formObj.f_pro_vw) == "R"){
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Internal EQ Rental(EMU Cost)_MT Repo
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Internal EQ Rental(EMU Cost)_MT Simulated
                } else if(ComGetObjValue(formObj.f_pro_vw) == "P"){
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Empty Terminal Expense
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Empty Transport Expense
                }
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Domestic Saving Credit
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Oneway Saving
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Agent Commission
                
                /* 2017.08.03 [CSR #1531] 김동호 신규 장비비 계정으로 통합
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Short Term EQ Rental 1 
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Long Term EQ Rental 1  
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR M&R Charge 1           
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Depreciation 1         
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Insurance 1            
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Short Term EQ Rental 2 
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Long Term EQ Rental 2  
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR M&R Charge 2           
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Depreciation 2         
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Insurance 2
                */    
                
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR EQ Rental 
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR M&R Charge          
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Depreciation        
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Insurance                  
                
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Chassis EQ Cost                
                                
                RangeBackColor(0, tmp_cnt, 0, cnt-1)= RgbColor(222, 251, 248);
                //cm cost랑 bkg cm 구분하는 부분
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false,"cm_cost_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "cm_cost_tot") = WebColor("#A7EEFF");
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "cm", false, "" , dfFloatOrg , 1, true, true);
                CellBackColor(0, "cm") = WebColor("#A7EEFF");
                //InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "cm_bkg", false, "" , dfFloatOrg , 1, true, true);
                //CellBackColor(0, "cm_bkg") = WebColor("#A7EEFF");
//                if (ComGetObjValue(formObj.f_pro_lvl) == "M"){ // CM2 일때
//                	InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "own_fdr", false, "",  dfFloatOrg, 1, true, true); // Own Feeder
//                	CellBackColor(0,"own_fdr") = RgbColor(222, 251, 248);
//                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false,"cm2_cost_tot", false, "",  dfFloatOrg, 1, true, true);
//                    CellBackColor(0, "cm2_cost_tot") = WebColor("#A7EEFF");
//                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "cm2", false, "" , dfFloatOrg , 1, true, true);
//                    CellBackColor(0, "cm2") = WebColor("#A7EEFF");                	
//                }
                if (ComGetObjValue(formObj.f_pro_lvl) == "O" && ComGetObjValue(formObj.f_pro_vw) == "R" ) {
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Domestic Saving Credit 
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // CNTR Fixed Cost
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Chassis Fixed Cost
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Own-Vol Activity Cost
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Activity Cost for STP Expense
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // Internal Slot Rental_Base
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "op_cost_total", false, "",  dfFloatOrg, 1, true, true); // OP COST
                    CellBackColor(0, "op_cost_total") = RgbColor(170,210,130);
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "op_total", false, "",  dfFloatOrg, 1, true, true); // OP
                    CellBackColor(0, "op_total") = RgbColor(170,210,130);
                }
                if(ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "O"){
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Port EXP                  
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Canal Transit Fee         
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Bunker                    
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Crew EXP                  
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Insurance                 
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Lubricant EXP             
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Store Supply EXP          
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Vessel M&R                
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Depreciations             
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Telecom EXP               
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Other Operation Fixed Exp 
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Time Charterage           
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Space Charterage          
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |General Expense           
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "", false, "",  dfFloatOrg, 1, true, true); // |Vessel Interest    
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "op_cost_total", false, "",  dfFloatOrg, 1, true, true); // OP COST
                    CellBackColor(0, "op_cost_total") = RgbColor(170,210,130);
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false, "op_total", false, "",  dfFloatOrg, 1, true, true); // OP
                    CellBackColor(0, "op_total") = RgbColor(170,210,130);
                }

                HeadRowHeight = 10;
                CountPosition = 0 ;
            }
            break;

        case 2:      //sheet2 init
            if (strTpsz == "") {
                head1 = "|AAA|BBB|CCC|DDD|EEE|FFF";
                head2 = "|AAA|BBB|CCC|DDD|EEE|FFF";
            }
            tpsz = strTpsz.replace(/(^\s*)/g, '').split("|");
            tpsz_cnt = tpsz.length;

            for(j=1; j<tpsz_cnt; j++){
                rev_head     = rev_head  + "|FR_REV_" + tpsz[j];
                load_hade    = load_hade + "|LOAD_"   + tpsz[j];
                if (ComGetObjValue(formObj.f_pro_lvl) == "M"){ //CM2
                	cm_cost_hade = cm_cost_hade + "|CM_COST_"   + tpsz[j]+"|CM2_COST_"+tpsz[j];
                } else {
                	cm_cost_hade = cm_cost_hade + "|CM_COST_"   + tpsz[j];
                }                
                op_cost_hade = op_cost_hade + "|OP_COST_"   + tpsz[j];
                op_hade      = op_hade      + "|OP_"   + tpsz[j];
                if (ComGetObjValue(formObj.f_pro_lvl) == "M"){
                    cm_hade      = cm_hade      + "|CM_"   + tpsz[j]+ "|CM2_"   + tpsz[j];
                } else {
                	cm_hade      = cm_hade      + "|CM_"   + tpsz[j];
                }
            }

            with (sheetObj) {
            	if(formObj.f_include_ts.checked && ComGetObjValue(formObj.f_rlane_cd) != "RBCCO"){
            		fix_cnt = 84;
		            HeadTitle = "SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|F_Index|BL NO|Inquiry Mon|Inquiry Week|Inquiry Trade|Inquiry Lane|Inquiry BND|Inquiry VVD|Inquiry Trade Dir.|TRADE|SUB TRD|R.LANE|IOC|REV VVD|Status|DIR|Trade Dir."
		                  + "|C.RHQ|C.AD|C.OFC|C.Region OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.Region OFC|L.REP|BKG OFC|BKG STS|USA MODE|Trunk POL|Trunk POD|BKG POR|BKG POL|BKG POD|BKG DEL"
		                  + "|RCV TERM|DEL TERM|Customs Desc|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|IAS RGN|TRADE1|TRADE2|TRADE3|TRADE4|TRADE5"
		                  + "|LANE1|LANE2|LANE3|LANE4|LANE5|VVD1|VVD2|VVD3|VVD4|VVD5|T/S PORT|T/S POL|T/S POD|POL1|POL2|POL3|POL4|POL5|POD1|POD2|POD3|POD4|POD5"
		                  + "|SC NO|RFA No|RFA Type|Source|NVOCC|CUST TP|SC CUST CD|SC CUST NM|G/Customer Code(Shipper)|G/Customer Name(Shipper)|G/Customer Type(C.Customer)|G/Customer Code(C.Customer)|G/Customer Name(C.Customer)|A/Customer Code|A/Customer Name|BKG SHPR CD|BKG SHPR NM"
		                  + "|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT"
		                  + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RF|DG|BB|AK|WEIGHT|UNIT"
		                  //83개로 변경됨.
            	} else if(formObj.f_include_ts.checked && ComGetObjValue(formObj.f_rlane_cd) == "RBCCO"){
                    fix_cnt = 82;
		            HeadTitle = "SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|F_Index|BL NO|TRADE|SUB TRD|R.LANE|IOC|REV VVD|Status|DIR|Trade Dir." //15개
		                  + "|C.RHQ|C.AD|C.OFC|C.Region OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.Region OFC|L.REP|BKG OFC|BKG STS|USA MODE|Trunk POL|Trunk POD|BKG POR|BKG POL|BKG POD|BKG DEL" //15개
		                  + "|RCV TERM|DEL TERM|Customs Desc|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|IAS RGN|TRADE1|TRADE2|TRADE3|TRADE4|TRADE5" //13개
		                  + "|LANE1|LANE2|LANE3|LANE4|LANE5|VVD1|VVD2|VVD3|VVD4|VVD5|T/S PORT|T/S POL|T/S POD|POL1|POL2|POL3|POL4|POL5|POD1|POD2|POD3|POD4|POD5" //15개
		                  + "|SC NO|RFA No|RFA Type|Source|NVOCC|CUST TP|SC/RFA CUST CD|SC/RFA CUST NM|G/Customer Code(Shipper)|G/Customer Name(Shipper)|G/Customer Type(C.Customer)|G/Customer Code(C.Customer)|G/Customer Name(C.Customer)|A/Customer Code|A/Customer Name|BKG SHPR CD|BKG SHPR NM" //8개
		                  + "|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT" //6개
		                  + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RF|DG|BB|AK|WEIGHT|UNIT" //9개
		            
            	}else{
            		fix_cnt = 80;
		            HeadTitle = "SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|F_Index|BL NO|TRADE|SUB TRD|R.LANE|IOC|REV VVD|Status|DIR|Trade Dir."
		                  + "|C.RHQ|C.AD|C.OFC|C.Region OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.Region OFC|L.REP|BKG OFC|BKG STS|USA MODE|Trunk POL|Trunk POD|BKG POR|BKG POL|BKG POD|BKG DEL"
		                  + "|RCV TERM|DEL TERM|Customs Desc|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|IAS RGN|TRADE1|TRADE2|TRADE3|TRADE4|TRADE5"
		                  + "|LANE1|LANE2|LANE3|LANE4|LANE5|VVD1|VVD2|VVD3|VVD4|VVD5|T/S PORT|POL1|POL2|POL3|POL4|POL5|POD1|POD2|POD3|POD4|POD5"
		                  + "|SC NO|RFA No|RFA Type|Source|NVOCC|CUST TP|SC CUST CD|SC CUST NM|G/Customer Code(Shipper)|G/Customer Name(Shipper)|G/Customer Type(C.Customer)|G/Customer Code(C.Customer)|G/Customer Name(C.Customer)|A/Customer Code|A/Customer Name|BKG SHPR CD|BKG SHPR NM"
		                  + "|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT"
		                  + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RF|DG|BB|AK|WEIGHT|UNIT";
		                  //78개로 변경됨.
            	}
            	
                if (ComGetObjValue(formObj.f_pro_lvl) == "C" && ComGetObjValue(formObj.f_pro_vw) == "P" ) {
                    var_cnt = (tpsz_cnt-1)*4 +8;
                    HeadTitle = HeadTitle
                          + rev_head
                          + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC 제거
                          + "|DEM DET"
                          + load_hade
                          + "|LOAD_TTL(TEU)"
                          + cm_cost_hade
                          + "|CM Cost Total"
                          + cm_hade
                          + "|CM Total";
                } else if (ComGetObjValue(formObj.f_pro_lvl) == "M" &&  ComGetObjValue(formObj.f_pro_vw) == "P") {
                    var_cnt = (tpsz_cnt-1)*6 +9;
                    HeadTitle = HeadTitle
                          + rev_head
                          + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC 제거
                          + load_hade
                          + "|LOAD_TTL(TEU)"
                          + cm_cost_hade
                          + "|CM Cost Total|CM2 Cost Total"
                          + cm_hade
                          + "|CM Total|CM2 Total";                       
                } else if (ComGetObjValue(formObj.f_pro_lvl) == "C" &&  ComGetObjValue(formObj.f_pro_vw) == "R") {
                     var_cnt = (tpsz_cnt-1)*4 +8;
                     HeadTitle = HeadTitle
                          + rev_head
                          + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC 제거
                          + "|DEM DET"
                          + load_hade
                          + "|LOAD_TTL(TEU)"
                          + cm_cost_hade
                          + "|CM Cost Total"
                          + cm_hade
                          + "|CM Total";
                } else if (ComGetObjValue(formObj.f_pro_lvl) == "M" &&  ComGetObjValue(formObj.f_pro_vw) == "R") {
                    var_cnt = (tpsz_cnt-1)*6 +9;
                    HeadTitle = HeadTitle
                         + rev_head
                         + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC 제거
                         + load_hade
                         + "|LOAD_TTL(TEU)"
                         + cm_cost_hade
                         + "|CM Cost Total|CM2 Cost Total"
                         + cm_hade
                         + "|CM Total|CM2 Total";                          
                } else if (ComGetObjValue(formObj.f_pro_lvl) == "O" &&  ComGetObjValue(formObj.f_pro_vw) == "P") {
                     var_cnt = (tpsz_cnt-1)*6 +8;
                     HeadTitle = HeadTitle
                          + rev_head
                          + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC 제거
                          + "|DEM DET"
                          + load_hade
                          + "|LOAD_TTL(TEU)"
                          + cm_cost_hade
                          + "|CM Cost Total"
                          +  cm_hade
                          + "|CM Total"
                          + op_cost_hade
                          + "|OP Cost Total"
                          + op_hade
                          + "|OP Total";                          
                } else if (ComGetObjValue(formObj.f_pro_lvl) == "O" &&  ComGetObjValue(formObj.f_pro_vw) == "R") {
                    var_cnt = (tpsz_cnt-1)*6 +10;
                     HeadTitle = HeadTitle
                          + rev_head
                          + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC 제거
                          + load_hade
                          + "|LOAD_TTL(TEU)"
                          + cm_cost_hade
                          + "|CM Cost Total"
                          + cm_hade
                          + "|CM Total"
                          + "|DEM DET"
                          + op_cost_hade
                          + "|OP Cost Total"
                          + op_hade
                          + "|OP Total";
                }

                style.height = GetSheetHeight(sheet_height2);
                SheetWidth = mainTable2.clientWidth;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msNone;  //msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 100);
                var headCount = ComCountHeadTitle(HeadTitle);
                InitColumnInfo(headCount , 5, 0, true);
                InitHeadMode(true, true, false, true, false, false);
                InitHeadRow(0, HeadTitle, false);

                cnt = 0;
                //1~5
                InitDataProperty(0, cnt++, dtSeq,     35, daCenter, false, "", false, "", dfNone,    0, true, true); // SEQ
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // R.Month
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // S.Month
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Week
                InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG No
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // F_Index
                InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "", false, "", dfNone,    0, true, true); // BL No
                if(formObj.f_include_ts.checked && ComGetObjValue(formObj.f_rlane_cd) != "RBCCO"){
                	InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Mon
                	InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Week
                	InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Trade
                	InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Lane
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry BOUND
	                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry VVD
	                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // Inquiry Trade Dir.
                }
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Trade
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Sub Trade
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // R.Lane
                InitDataProperty(0, cnt++, dtData,    40, daCenter, false, "", false, "", dfNone,    0, true, true); // IOC
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // REV VVD
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Status

                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // DIR
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // Trade Dir.
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.RHQ
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.AD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.OFC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // C.Region OFC
                InitDataProperty(0, cnt++, dtData,    75, daCenter, false, "", false, "", dfNone,    0, true, true); // C.S.Rep
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.RHQ
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // L.AD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.OFC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.Region OFC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // L.Rep
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG OFC

                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG STS
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // USA Mode
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Trunk POL
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // Trunk POD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG POR
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG POL
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG POD
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG DEL
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG R.Term
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // BKG D.Term
                
                InitDataProperty(0, cnt++, dtData,   150, daLeft, 	false, "", false, "", dfNone,    0, true, true); //  Customs Desc
                
                InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "", false, "", dfNone,    0, true, true); // REP CMDT CD
                InitDataProperty(0, cnt++, dtData,   150, daLeft,   false, "", false, "", dfNone,    0, true, true); // REP CMDT DESC

                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // CMDT CD
                InitDataProperty(0, cnt++, dtData,   150, daLeft,   false, "", false, "", dfNone,    0, true, true); // CMDT DESC
                InitDataProperty(0, cnt++, dtData,   100, daLeft,   false, "", false, "", dfNone,    0, true, true); // IAS REGION
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE1
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE2
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE3
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE4
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // TRADE5
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane1
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane2
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane3
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane4
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // Lane5

                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD1
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD2
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD3
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD4
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // VVD5
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // T/S PORT
                if(formObj.f_include_ts.checked){
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // T/S POL
	                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // T/S POD
                }
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL1
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL2
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL3
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL4
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POL5
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD1
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD2

                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD3
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD4
                InitDataProperty(0, cnt++, dtData,    65, daCenter, false, "", false, "", dfNone,    0, true, true); // POD5
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // SC No
                InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "", false, "", dfNone,    0, true, true); // RFA No
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // RFA Type
                InitDataProperty(0, cnt++, dtData,  130, daCenter, false, "", false, "", dfNone,    0, true, true); // Source
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // NVOCC
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // CUST TP
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // SC CUST CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // SC CUST NM
                InitDataProperty(0, cnt++, dtData,   170, daCenter, false, "", false, "", dfNone,    0, true, true); // G/Customer Code(Shipper)
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // G/Customer Name(Shipper)
                InitDataProperty(0, cnt++, dtData,   180, daCenter, false, "", false, "", dfNone,    0, true, true); // G/Customer Type(C.Customer)
                InitDataProperty(0, cnt++, dtData,   180, daCenter, false, "", false, "", dfNone,    0, true, true); // G/Customer Code(C.Customer)
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // G/Customer Name(C.Customer)
                InitDataProperty(0, cnt++, dtData,   110, daCenter, false, "", false, "", dfNone,    0, true, true); // A/Customer Code
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // A/Customer Name
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // SHPR_CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // SHPR_NM

                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // B/L SHPR NM
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "", false, "", dfNone,    0, true, true); // CNEE CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // CNEE NM
                InitDataProperty(0, cnt++, dtData,    70, daCenter, false, "", false, "", dfNone,    0, true, true); // NOTIFY CD
                InitDataProperty(0, cnt++, dtData,   200, daLeft,   false, "", false, "", dfNone,    0, true, true); // NOTIFY NM
                InitDataProperty(0, cnt++, dtData,    60, daCenter, false, "", false, "", dfNone,    0, true, true); // PPD CCT
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "", false, "", dfNone,    0, true, true); // BL OnBoard DT
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "", false, "", dfNone,    0, true, true); // CGO RCV DT
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // SOC
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // REV MT

                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // RF
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // DG
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // BB
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // AK
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight,  false, "", false, "", dfFloatOrg,1, true, true); // Weight
                InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "", false, "", dfNone,    0, true, true); // Unit


                // FR_REV 가변
                for(j=1; j<tpsz_cnt; j++){
                    InitDataProperty(0, cnt, dtAutoSum, 80, daRight, false, "fr_rev_"+tpsz[n], false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(255, 248, 251);
                    cnt++;
                }
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, false,"fr_rev_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "fr_rev_tot") = WebColor("#FFD5D2");
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, false,"misc_rev_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "misc_rev_tot") = WebColor("#FFD5D2");
                InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, false,"rev_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "rev_tot") = WebColor("#FFD5D2");

                InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"dem_det", false, "",  dfFloatOrg, 1, true, true); //DEM/DET
                CellBackColor(0, "dem_det") = WebColor("#A7EEFF");
                
                // LOAD 가변
                for(j=1; j<tpsz_cnt; j++){
                    InitDataProperty(0, cnt, dtAutoSum, 80, daRight, false, "load_"+tpsz[n], false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(255, 248, 251);
                    cnt++;
                }
                InitDataProperty(0, cnt++, dtAutoSum, 95, daRight, false,"load_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "load_tot") = WebColor("#FFD5D2");

                // CM COST -------------------------------------------------------------------------------------
                for(j=1; j<tpsz_cnt; j++){
                	if (ComGetObjValue(formObj.f_pro_lvl) == "M"){ //CM2
                    InitDataProperty(0, cnt, dtAutoSum, 90, daRight, false, "", false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(222,  251, 248);
                    cnt++;
                	}
                    InitDataProperty(0, cnt, dtAutoSum, 90, daRight, false, "", false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(222,  251, 248);
                    cnt++;
                }
                
                InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false,"cm_cost_tot", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "cm_cost_tot") = WebColor("#A7EEFF");
                if (ComGetObjValue(formObj.f_pro_lvl) == "M"){
                    InitDataProperty(0, cnt++, dtAutoSum, 120, daRight, false,"cm2_cost_tot", false, "",  dfFloatOrg, 1, true, true);
                    CellBackColor(0, "cm2_cost_tot") = WebColor("#A7EEFF");
                }

                // CM -------------------------------------------------------------------------------------
                for(j=1; j<tpsz_cnt; j++){
                	if (ComGetObjValue(formObj.f_pro_lvl) == "M"){
                    InitDataProperty(0, cnt, dtAutoSum, 90, daRight, false, "", false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(222,  251, 248);                	
                    cnt++;
                	}
                    InitDataProperty(0, cnt, dtAutoSum, 90, daRight, false, "", false, "",  dfFloatOrg, 1 , true, true);
                    CellBackColor(0, cnt) = RgbColor(222,  251, 248);                	
                    cnt++;                	
                }
                InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"cm", false, "",  dfFloatOrg, 1, true, true);
                CellBackColor(0, "cm") = WebColor("#C8FAC8");
                //InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"cm_bkg", false, "",  dfFloatOrg, 1, true, true);
                //CellBackColor(0, "cm_bkg") = WebColor("#C8FAC8");
                if (ComGetObjValue(formObj.f_pro_lvl) == "M"){
                    InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"cm2", false, "",  dfFloatOrg, 1, true, true);
                    CellBackColor(0, "cm2") = WebColor("#C8FAC8");
                }


                if (ComGetObjValue(formObj.f_pro_lvl) == "O" &&  ComGetObjValue(formObj.f_pro_vw) == "P"){
                    // OP COST  -------------------------------------------------------------------------------------
//                      InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"dem_det", false, "",  dfFloatOrg, 1, true, true); //DEM/DET
//                      CellBackColor(0, "dem_det") = WebColor("#A7EEFF");
                    for(j=1; j<tpsz_cnt; j++){
                        InitDataProperty(0, cnt, dtAutoSum, 90, daRight, false, "", false, "",  dfFloatOrg, 1 , true, true);
                        CellBackColor(0, cnt) = RgbColor(222,  251, 248);
                        cnt++;
                    }
                    InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"op_cost_tot", false, "",  dfFloatOrg, 1, true, true);
                    CellBackColor(0, "op_cost_tot") = WebColor("#A7EEFF");
                    // OP -------------------------------------------------------------------------------------
                    for(j=1; j<tpsz_cnt; j++){
                        InitDataProperty(0, cnt, dtAutoSum, 90, daRight, false, "", false, "",  dfFloatOrg, 1 , true, true);
                        CellBackColor(0, cnt) = RgbColor(222,  251, 248);
                        cnt++;
                    }
                    InitDataProperty(0, cnt++, dtAutoSum, 100, daRight, false,"op_tot", false, "",  dfFloatOrg, 1, true, true);
                    CellBackColor(0, "op_tot") = WebColor("#A7EEFF");
                }

                HeadRowHeight = 10;
                CountPosition = 0 ;
            }
            break;

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
     * 멀티콤보 처리
     * - IBCombo Object를 배열로 등록
     * - 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * - 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
     */
    function setPeriod(obj) {
         ComMasSetPeriod4(obj);
    }

     /**
      * 검색시 필수입력사항 체크
      */
     function chkValidSearch(){
         var formObj = document.form;

         with(formObj){
             if (f_year.value == "") {
                 // [COM12114] : Year 를(을) 확인하세요.
                 ComShowMessage(ComGetMsg("COM12114", "Year"));
                 f_year.focus();
                 return false;
             }
             if(formObj.f_chkprd[0].checked){


                 if (f_fm_wk.value != "" && f_to_wk.value == ""){
                     // [COM12114] : Week 를(을) 확인하세요.
                     ComShowMessage(ComGetMsg("COM12114", "Week"));
                     f_to_wk.focus();
                     return false;
                 }
                 if (f_fm_wk.value == "" && f_to_wk.value != ""){
                     // [COM12114] : Week 를(을) 확인하세요.
                     ComShowMessage(ComGetMsg("COM12114", "Week"));
                     f_fm_wk.focus();
                     return false;
                 }

                 if (f_fm_wk.value == "" && f_to_wk.value == ""){
                     // [COM12114] : Week 를(을) 확인하세요.
                     ComShowMessage(ComGetMsg("COM12114", "Week"));
                     f_fm_wk.focus();
                     return false;
                 }

                 if (f_fm_wk.value > f_to_wk.value) {
                     // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
                     ComShowMessage(ComGetMsg("MAS10011","Week","From","To"));
                     f_to_wk.focus();
                     return false;
                 }

                 if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
                 if(!ComChkObjValid(f_sls_mon, null, null, "ym")) return false;
                 if(!ComChkObjValid(f_fm_wk, null, null, "yw")) return false;
                 if(!ComChkObjValid(f_to_wk, null, null, "yw")) return false;
             }else{
                 if (f_mon.value == "") {
                     // [COM12114] : Month 를(을) 확인하세요.
                     ComShowMessage(ComGetMsg("COM12114", "Month"));
                     f_mon.focus();
                     return false;
                 }
                 if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
                 if(!ComChkObjValid(f_mon, null, null, "ym")) return false;
             }
         }
         return true;
     }

     function f_trd_cd_OnFocus(){
    	 document.getElementById("btn_retrieve").focus();
    	 document.getElementById("f_trd_cd").focus();
     }


    /**
     * ifram을 이용하여 R.Lane 표시
     */

    function f_trd_cd_OnChange(obj) {
        if (loadingMode == true)
            return;
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (obj.Text != "") {
            formObj.f_cmd.value = SEARCHLIST11;
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0035GS2.do", FormQueryString(formObj));
            var arrXml = sXml.split("|$$|");
            if (arrXml.length > 0){
            	ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "code");
            	ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");            	
            	formObj.f_sub_trd_cd.Index = 0;
            	formObj.f_rlane_cd.Index = 0;
            }
        }
    }
    
    
    /**
     * ifram을 이용하여 R.Lane 표시
     */
    function f_sub_trd_cd_OnChange(obj) {
        if (loadingMode == true)
            return;
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (obj.Text != "") {
            formObj.f_cmd.value = SEARCHLIST17;
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0035GS2.do", masFormQueryString(formObj));
            var arrXml = sXml.split("|$$|");
            if (arrXml.length > 0){
            	ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");            	
            	formObj.f_rlane_cd.Index = 0;
            }
        }
    }
    function f_sub_trd_cd_OnFocus(){
   	 document.getElementById("btn_retrieve").focus();
   	 document.getElementById("f_sub_trd_cd").focus();
    }
    
    /**
     * 화면의 RPT Form 처리
     */
    function rPTFormOnChange(obj) {
        var formObj = document.form;
        var flag = obj.value;  //1:Account, 2:TpSz

        if (flag == "ACCT") { //Account 선택시
            document.getElementById("tabLayer1").style.display= "inline";
            document.getElementById("tabLayer2").style.display= "none";
        } else if (flag == "TPSZ") { //TpSz 선택시
            document.getElementById("tabLayer1").style.display= "none";
            document.getElementById("tabLayer2").style.display= "inline";
        }
        sheet_selno = (flag==null)?"ACCT":flag ;
//        parent.syncHeight();
    }
    
    var vFastfProVw = false;
    function f_pro_vw_OnChange(obj, code){
        var formObj = document.form;
    	if(vFastfProVw){
            if(code == "P"){
            	formObj.f_pro_lvl.InsertItem(-1, "OP", "O");
            }else if(code == "R"){
            	formObj.f_pro_lvl.DeleteItem("O");
            	formObj.f_pro_lvl.Code = "C";
            }    		
    	}
    	vFastfProVw = true;
    }
    
    function f_ofc_lvl_OnChange(obj, code){
        if (loadingMode == true) return;
        fOfcLvlOnChange(obj);
    }

    /**
     * ifram을 이용하여 OFC 변경
     */
    function fOfcLvlOnChange(obj){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];

         if(obj.Text != ""){
             formObj.f_cmd.value = SEARCHLIST12;
             var sXml = sheetObj.GetSearchXml("ESM_MAS_0035GS2.do", masFormQueryString(formObj));
             var arrXml = sXml.split("|$$|");
             if (arrXml.length > 0)
             ComXml2ComboItem(arrXml[0], formObj.f_ofc_cd, "code", "code");
             formObj.f_ofc_cd.Index=0;
         }
    }


    /**
     * Shipper PopUp 화면을 열어 준다
     *
     */
    function shipperPopUp(){
        var formObj = document.form;
        var param = "";
        var tmp = formObj.txtShipper.value;

        formObj.f_cmd.value = "";
        if(tmp.length == 0){
            param = "?f_cust_cnt_cd=&f_cust_seq="
        }
        if(tmp.length >0 && tmp.length< 3){
            param = "?f_cust_cnt_cd=" + tmp +"&f_cust_seq=";
        } else if(tmp.length>2) {
            param = "?f_cust_cnt_cd=" + tmp.substring(0,2);
            param = param + "&f_cust_seq=" + tmp.substring(2);
        }
        ComOpenWindow('ESM_MAS_0144.do' + param, 'Shipper Pop', 'width=600,height=450,menubar=0,status=1,scrollbars=0,resizable=0');

    }

    /**
     * SC_NO, RFA_NO 조회 팝업화면 콜
     */
    function comPopupLoc(flag) {
        var formObj = document.form;
        var display = "1,0,1,1,1,1,1,1";
        var cont_tp = "";
        var cont_no = "";

        if (flag==1) {
            cont_tp = formObj.f_sc_no.value.substring(0,3);
            //cont_tp = (cont_tp=="")?"AEF":cont_tp;
            cont_no = formObj.f_sc_no.value.substring(3,formObj.f_rfa_no.value.length);
        } else if (flag==2) {
            cont_tp = formObj.f_rfa_no.value.substring(0,3);
            //cont_tp = (cont_tp=="")?"AAR":cont_tp;
            cont_no = formObj.f_rfa_no.value.substring(3,formObj.f_rfa_no.value.length);
        }

        var param = "?cont_tp="+cont_tp+"&cont_no="+cont_no+"&flag="+flag;
        ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 780, 500, 'getComEns021_1' + flag, display, true); // radio PopUp
    }

    /**
     * SC_NO를 세팅한다.
     */
    function getComEns021_1(rowArray) {
        var colArray = rowArray[0];
        document.form.f_sc_no.value = colArray[2];
    }

    /**
     * RFA_NO를 세팅한다.
     */
    function getComEns021_2(rowArray) {
        var colArray = rowArray[0];
        document.form.f_rfa_no.value = colArray[2];
    }

    /*
     * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
     */
    function changeCostYrmon(val){
        if(val != ''  && document.form.f_usr_ofc_tp_cd.value != "BA" && document.form.f_usr_ofc_tp_cd.value != "BB") 
            fOfcLvlOnChange(document.form.f_ofc_lvl);
    }
    //changeCostYrmon


    // Sheet1_Account 관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBCLEAR:          //조회
                //formObj.f_sls_mon.value = ComGetNowInfo("mm").lpad(2, "0");
                formObj.f_mon.value = ComGetNowInfo("mm").lpad(2, "0");

                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);

                var sXml = document.form.sXml.value;
                var arrXml = sXml.split("|$$|");
                if (ComGetEtcData(arrXml[0], "ofc_cd") == undefined){
                    ComShowMessage(OBJECT_ERROR);
                    ComOpenWait(false);
                    return;
                }
                formObj.f_usr_ofc_cd.value = ComGetEtcData(arrXml[0], "ofc_cd");
                formObj.f_usr_ofc_lvl.value = ComGetEtcData(arrXml[0], "ofc_lvl");
                formObj.f_usr_lgn_ofc_lvl.value = ComGetEtcData(arrXml[0], "lgn_ofc_lvl");
                formObj.f_usr_ofc_tp_cd.value = ComGetEtcData(arrXml[0], "ofc_tp_cd");
                formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
                formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
                formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
                document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";

                if (arrXml.length > 0)
                    ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
                if (arrXml.length > 1)
                    ComXml2ComboItem(arrXml[1], formObj.f_ofc_vw, "code", "name");
                if (arrXml.length > 2)
                    ComXml2ComboItem(arrXml[2], formObj.f_pro_lvl, "code", "name");
                if (arrXml.length > 3)
                    ComXml2ComboItem(arrXml[3], formObj.f_ofc_lvl, "code", "name");
                if (arrXml.length > 4)
                    ComXml2ComboItem(arrXml[4], formObj.f_ofc_cd, "code", "code");
                if (arrXml.length > 5)
                    ComXml2ComboItem(arrXml[5], formObj.f_trd_cd, "code", "code");
                if (arrXml.length > 6)
                    ComXml2ComboItem(arrXml[6], formObj.f_rlane_cd, "code", "code");
                if (arrXml.length > 7)
                    ComXml2ComboItem(arrXml[7], formObj.f_ioc_cd, "code", "code");
                if (arrXml.length > 8)
                    ComXml2ComboItem(arrXml[8], formObj.f_dir_cd, "code", "code");
                if (arrXml.length > 9)
                    ComXml2ComboItem(arrXml[9], formObj.f_rep_cmdt_cd, "code", "code|name");
                if (arrXml.length > 10)
                    ComXml2ComboItem(arrXml[10], formObj.f_usa_bkg_mod_cd, "code", "code");
                if (arrXml.length > 11)
                    ComXml2ComboItem(arrXml[11], formObj.f_hul_bnd_cd, "code", "name");
                if (arrXml.length > 12)
                    ComXml2ComboItem(arrXml[12], formObj.f_sub_trd_cd, "code", "name");
                
                document.form.sXml.value = "";
                ComOpenWait(false);
                break;

            case IBSEARCH:      //조회
                if (!validateCond(formObj, sAction)) {
                    return false;
                }
                // 업무처리중 버튼사용 금지 처리
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = COMMAND01;
                formObj.f_excel.value = "N";

                var sXml = sheetObj.GetSaveXml("ESM_MAS_0035GS.do", masFormQueryString(formObj));
                var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                if (backEndJobKey.length > 0) {
                    formObj.backendjob_key.value = backEndJobKey;
                    sheetObj.RequestTimeOut = 20000;
                    timer = setInterval(getBackEndJobStatus1, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                }
                break;

            case IBCREATE:      // File DownLoad 상태조회
                if (!validateCond(formObj, sAction)) {
                    return false;
                }

                // 업무처리중 버튼사용 금지 처리
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = COMMAND01;
                formObj.f_excel.value = "Y";

                var sXml = sheetObj.GetSaveXml("ESM_MAS_0035GS.do", masFormQueryString(formObj));
                var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                if (backEndJobKey.length > 0) {
                    formObj.backendjob_key.value = backEndJobKey;
                    sheetObj.RequestTimeOut = 20000;
                    timer = setInterval(getBackEndJobStatus1, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                }

                break;
                
            case IBSEARCH_ASYNC01 : //조회 결과를 login user의 mail로 전송
                if (!validateCond(formObj, sAction)) {
                    return false;
                }
                
                ComOpenWait(true);
                
                /*--------------------------------------------*/
                formObj.f_cmd.value = SEARCH01;
                formObj.f_excel.value = "Y";
                var sXml = sheetObj.GetSaveXml("ESM_MAS_0035GS2.do", masFormQueryString(formObj));
                var result = ComGetEtcData(sXml, "result");
                ComOpenWait(false);
                
                if(result == "1") {
                    alert("E-mail send process has been started.\n(it may takes several minutes.)");
                }
                
                break;

            case IBDOWNEXCEL:   //엑셀 다운로드
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }
                break;

        }
    }


    /**
     * BackEndJob 호출함수 (Sheet1)
     */
    function getBackEndJobStatus1() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        formObj.f_cmd.value = COMMAND02;
        var sXml = sheetObj.GetSearchXml("ESM_MAS_0035GS.do", masFormQueryString(formObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")

        if (jobState == "3") {
            if (formObj.f_excel.value == "Y") {    // File Download
                //-------------------------------
                // 비동기로 데이터 생성
                //-------------------------------
                formObj.f_cmd.value = COMMAND09;
                document.location.href = "ESM_MAS_0035DL.do?" + masFormQueryString(formObj);
                document.onreadystatechange = function() {
                    if (document.readyState == "interactive") {
                        ComOpenWait(false);
                    }
                }
                clearInterval(timer);

            } else {                               //  Retrieve
                formObj.f_cmd.value = COMMAND03;
                formObj.f_shpr_cd.value = formObj.txtShipper.value;
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                sheetObj.RemoveEtcData();
                sheetObj.Reset();
                ComConfigSheet(sheetObj);
                initSheet(sheetObj, 1);
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                //속도 향상을 위해 SpeedOption 처리
                sheetObj.SpeedOption ="NOPROGRESSTICK,NOSTATUS,NOTRIM,NOCALC,NOTDTAG,NOCOMBO";
                sheetObj.DoSearch4Sax("ESM_MAS_0035GS.do", masFormQueryString(formObj));
                clearInterval(timer);
                ComOpenWait(false);
            }

        } else if (jobState == "4") {
            clearInterval(timer);
            ComOpenWait(false);
            // BackEndJob을 실패 하였습니다.
            ComShowCodeMessage("MAS00001");

        } else if (jobState == "5") {
            clearInterval(timer);
            ComOpenWait(false);
            // 이미 BackEndJob 결과 파일을 읽었습니다.
            ComShowCodeMessage("MAS00002");

        }
    }


    // Sheet2_Type Size 관련 프로세스 처리
    function doActionIBSheet2(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:      //조회
                if (!validateCond(formObj, sAction)) {
                    return false;
                }
                // 업무처리중 버튼사용 금지 처리
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = COMMAND11;
                formObj.f_excel.value = "N";

                var sXml = sheetObj.GetSearchXml("ESM_MAS_0035GS.do", masFormQueryString(formObj));
                var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                if (backEndJobKey.length > 0) {
                    formObj.backendjob_key.value = backEndJobKey;
                    sheetObj.RequestTimeOut = 20000;
                    timer = setInterval(getBackEndJobStatus2, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                }
                break;

            case IBCREATE:      //파일다운로드
                if (!validateCond(formObj, sAction)) {
                    return false;
                }

                // 업무처리중 버튼사용 금지 처리
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = COMMAND11;
                formObj.f_excel.value = "Y";

                var sXml = sheetObj.GetSaveXml("ESM_MAS_0035GS.do", masFormQueryString(formObj));
                var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                if (backEndJobKey.length > 0) {
                    formObj.backendjob_key.value = backEndJobKey;
                    sheetObj.RequestTimeOut = 20000;
                    timer = setInterval(getBackEndJobStatus1, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                }
                break;
                
            case IBSEARCH_ASYNC01 : //조회 결과를 login user의 mail로 전송
                if (!validateCond(formObj, sAction)) {
                    return false;
                }
                
                ComOpenWait(true);
                
                /*--------------------------------------------*/
                formObj.f_cmd.value = SEARCH11;
                formObj.f_excel.value = "Y";
                var sXml = sheetObj.GetSaveXml("ESM_MAS_0035GS2.do", masFormQueryString(formObj));
                ComOpenWait(false);
                
                break;

            case IBDOWNEXCEL:   //엑셀 다운로드
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }
                break;

        }
    }

    /**
     * BackEndJob 호출함수 (Sheet2)
     */
    function getBackEndJobStatus2() {
        var formObj = document.form;
        var sheetObj = sheetObjects[1];
        formObj.f_cmd.value = COMMAND12;
        var sXml = sheetObj.GetSearchXml("ESM_MAS_0035GS.do", masFormQueryString(formObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")

        if (jobState == "3") {
            if (formObj.f_excel.value == "Y") {    // File Download
                //-------------------------------
                // 비동기로 데이터 생성
                //-------------------------------
                formObj.f_cmd.value = COMMAND19;
                window.location.href = "ESM_MAS_0035DL.do?" + masFormQueryString(formObj);
                document.onreadystatechange = function() {
                    if (document.readyState == "interactive") {
                        ComOpenWait(false);
                    }
                }
                clearInterval(timer);

            } else {                               //  Retrieve
                formObj.f_cmd.value = COMMAND13;
                formObj.f_shpr_cd.value = formObj.txtShipper.value;
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                sheetObj.RemoveEtcData();
                sheetObj.Reset();
                ComConfigSheet(sheetObj);
                initSheet(sheetObj, 2);
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                //속도 향상을 위해 SpeedOption 처리
                sheetObj.SpeedOption ="NOPROGRESSTICK,NOSTATUS,NOTRIM,NOCALC,NOTDTAG,NOCOMBO";
                sheetObj.DoSearch4Sax("ESM_MAS_0035GS.do", masFormQueryString(formObj));
                clearInterval(timer);
                ComOpenWait(false);
            }

        } else if (jobState == "4") {
            clearInterval(timer);
            ComOpenWait(false);
            // BackEndJob을 실패 하였습니다.
            ComShowCodeMessage("MAS00001");

        } else if (jobState == "5") {
            clearInterval(timer);
            ComOpenWait(false);
            // 이미 BackEndJob 결과 파일을 읽었습니다.
            ComShowCodeMessage("MAS00002");

        }
    }


    function getIbComboObjValue(obj){
        if (obj.Code == "All" ){
            return "";
        }
        return obj.Code;
    }


    /**
     * 화면 조회값에 대한 유효성검증 프로세스 처리
     */
    function validateCond(formObj, sAction) {
        with(formObj){
            // msg1 + '  를(을) 확인하세요.';
            if (ComTrim(f_year.value) == "") {
                ComShowMessage(ComGetMsg('COM12114','Year'));
                f_year.focus();
                return false;
            }
            // msg1 + '  과 ' + msg2 + '중 하나는 입력하세요.';
            if (ComTrim(f_mon.value) == "" && ComTrim(f_fm_wk.value) == "") {
                ComShowMessage(ComGetMsg('COM12138','Month','Week'));
                f_mon.focus();
                return false;
            }

            // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
            if (ComTrim(f_fm_wk.value) != "" && ComTrim(f_to_wk.value) != "") {
                if(ComParseInt(f_fm_wk.value) > ComParseInt(f_to_wk.value)){
                    ComShowMessage(ComGetMsg('MAS10011','Week','First Element','Second Element'));
                    f_fm_wk.focus();
                    return false;
                }
            }
            if(sAction == IBCREATE || sAction == IBSEARCH_ASYNC01){
            	/* 2017.04.06 조지윤 차장님 요청으로 validation 삭제
                if(getIbComboObjValue(f_ofc_cd) != "") {
                    if(parseInt(getIbComboObjValue(f_ofc_lvl)) <= 3){
                        if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) != 0){
                            // [MAS10003] : Week 는(은) 1wk 만 처리할수 있습니다.
                            ComShowMessage(ComGetMsg("MAS10003", "Week", "1wk"));
                            f_to_wk.focus();
                            return false;
                        }
                    } else {
                        if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) > 4){
                            // [MAS10003] : Week 는(은) 5wk 만 처리할수 있습니다.
                            ComShowMessage(ComGetMsg("MAS10003", "Week", "5wk"));
                            f_to_wk.focus();
                            return false;
                        }
                    }
                } else {
                    if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) != 0){
                        // [MAS10003] : Week 는(은) 1wk 만 처리할수 있습니다.
                        ComShowMessage(ComGetMsg("MAS10003", "Week", "1wk"));
                        f_to_wk.focus();
                        return false;
                    }
                }
                */
                if(f_mon.value != "" && f_chkprd[1].checked) {
                    if(parseInt(getIbComboObjValue(f_ofc_lvl)) < 3 && getIbComboObjValue(f_trd_cd) == "") {
                         ComShowMessage(ComGetMsg('COM12114','Trade'));
                         ComSetFocus(f_trd_cd);
                         return false;
                    }
                }

            // SEARCHLIST before 2017
            } else if (parseInt(f_year.value) < 2017) {

                if(parseInt(f_usr_ofc_lvl.value) == 1 && getIbComboObjValue(f_ofc_cd) == "" && parseInt(ComGetObjValue(f_ofc_lvl)) < 6){ // sales ofc 까지 All  선택 시 Trade 및 Lane 제약
                   if(getIbComboObjValue(f_trd_cd) == ""){
                            ComShowMessage(ComGetMsg('COM12114','Trade'));
                            ComSetFocus(f_trd_cd);
                            return false;
                   }
                   if(getIbComboObjValue(f_rlane_cd) == "" && formObj.f_usr_lgn_ofc_cd.value != "SELCSG" && formObj.f_usr_lgn_ofc_cd.value != "CLTCO"
                	   && formObj.f_usr_lgn_ofc_cd.value != 'SELAPM'){
                	   if(!formObj.f_fixed_rate.checked){
                            ComShowMessage(ComGetMsg('COM12114','Lane'));
                            ComSetFocus(f_rlane_cd);
                            return false;
                            
                	   }
                   }
              }
               if(getIbComboObjValue(f_ofc_cd) != "" || parseInt(getIbComboObjValue(f_ofc_lvl)) > 3) { //Area 이상일때
                    // Level    Trade   Rlane   Period
                    //--------------------------------------
                    // Head Office       O      0      1
                    //--------------------------------------
                    // Regional Grp      O      0      1
                    //--------------------------------------
                    // SubRegional Grp   O      0      1
                    //--------------------------------------
                    // Area              O      X      3
                    //--------------------------------------
                    // 이하              X      X      3
                    //--------------------------------------
                    if(parseInt(getIbComboObjValue(f_ofc_lvl)) <= 4){ //OFC 선택 & HQ ~ Area 까지
                        if(getIbComboObjValue(f_trd_cd) == ""){
                            ComShowMessage(ComGetMsg('COM12114','Trade'));
                            ComSetFocus(f_trd_cd);
                            return false;
                        }
                    }
                    if(parseInt(getIbComboObjValue(f_ofc_lvl)) < 4){ //OFC 선택 & HQ ~ sub regional group 까지
                        if(getIbComboObjValue(f_rlane_cd) == ""){
                            ComShowMessage(ComGetMsg('COM12114','Lane'));
                            ComSetFocus(f_rlane_cd);
                            return false;
                        }
                    }
                    if(parseInt(getIbComboObjValue(f_ofc_lvl)) <= 4){ // OFC 선택 & HQ ~ Area 까지
                        if(ComParseInt(ComGetObjValue(f_to_wk))-ComParseInt(ComGetObjValue(f_fm_wk)) > 4){
                            // [MAS10003] : Week 는(은) 1wk 만 처리할수 있습니다.
                            ComShowMessage(ComGetMsg("MAS10003", "Week", "5wk"));
                            f_to_wk.focus();
                            return false;
                        }
                    } else { // OFC 선택 & Sales OFC 이상
                        if(ComParseInt(ComGetObjValue(f_to_wk))-ComParseInt(ComGetObjValue(f_fm_wk)) > 4){
                            // [MAS10003] : Week 는(은) 3wk 만 처리할수 있습니다.
                            ComShowMessage(ComGetMsg("MAS10003", "Week", "5wk"));
                            f_to_wk.focus();
                            return false;
                        }
                    }
              } else {
                    if(getIbComboObjValue(f_trd_cd) == ""){
                        ComShowMessage(ComGetMsg('COM12114','Trade'));
                        ComSetFocus(f_trd_cd);
                        return false;
                    }
                    if(getIbComboObjValue(f_rlane_cd) == "" && formObj.f_usr_lgn_ofc_cd.value != "SELCSG" && formObj.f_usr_lgn_ofc_cd.value != "CLTCO"
                    	&& formObj.f_usr_lgn_ofc_cd.value != 'SELAPM'){
                    	if(!formObj.f_fixed_rate.checked){
	                        ComShowMessage(ComGetMsg('COM12114','Lane'));
	                        ComSetFocus(f_rlane_cd);
	                        return false;
                    	}
                    }
                    if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) > 9){
                        // [MAS10003] : Week 는(은) 1wk 만 처리할수 있습니다.
                        ComShowMessage(ComGetMsg("MAS10003", "Week", "10wk"));
                        f_to_wk.focus();
                        return false;
                    }
                }
               
               if(f_include_ts.checked && (getIbComboObjValue(f_trd_cd) == ""||getIbComboObjValue(f_rlane_cd) == "")){
                    ComShowMessage(ComGetMsg('COM12114','Trade&Lane'));
                    return false;
                }
                
                //1week별 RBCCO include T/S data가 4천건 이상 존재하므로 한주차만 조회
                if(f_include_ts.checked && (getIbComboObjValue(f_rlane_cd) == "RBCCO")){
                    if(ComParseInt(ComGetObjValue(f_to_wk))-ComParseInt(ComGetObjValue(f_fm_wk)) > 0){
                        // [COA10003] : Week 는(은) 3wk 만 처리할수 있습니다.
                        ComShowMessage(ComGetMsg("COA10003", "Week ", "1wk (Include T/S, RBCCO)"));
                        f_to_wk.focus();
                        return false;
                    }
                }
            }

            if((f_chkprd[1].checked && f_year.value == "2007" && ComParseInt(f_mon.value) < 7) ||
                (f_chkprd[0].checked && f_year.value == "2007" && ComParseInt(f_fm_wk.value) < 27)){
                 // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
                 ComShowMessage(ComGetMsg("MAS10037"));
                 return false;
             } 
            
        }
        return true;
    }
    
/* Input에 포커스가 있는 상태에서 Combo 클릭시 선택 안되는 현상 회피를 위해 콤보에 포커스 올때 다른쪽으로 포커스 한번 주고 이동시킴. */
    function f_pro_vw_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_pro_vw").focus();
	}
	function f_ofc_vw_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_ofc_vw").focus();
	}
	function f_pro_lvl_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_pro_lvl").focus();
	}
	function f_ofc_lvl_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_ofc_lvl").focus();
	}
	function f_ofc_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_ofc_cd").focus();
	}
	function f_rlane_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_rlane_cd").focus();
	}
	function f_dir_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_dir_cd").focus();
	}
	function f_ioc_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_ioc_cd").focus();
	}
	function f_hul_bnd_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("_hul_bnd_cd").focus();
	}
	function f_rep_cmdt_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_rep_cmdt_cd").focus();
	}
	function f_usa_bkg_mod_cd_OnFocus() {
		document.getElementById("btn_retrieve").focus();
		document.getElementById("f_usa_bkg_mod_cd").focus();
	}
