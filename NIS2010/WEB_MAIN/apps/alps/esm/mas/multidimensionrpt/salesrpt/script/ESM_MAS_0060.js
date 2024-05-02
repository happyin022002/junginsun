/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0060.js
*@FileTitle : Inquiry by Customized Condition(점소 Weekly 비정형 실적 분석 RPT 조회1)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.01
*@LastModifier : 김기종 
*@LastVersion : 1.1
*=========================================================
* History
* 2008.02.22 박은주 N200802220016 MAS 조회 기간 관련 수정 요청
*                  2007년 7월 이전, 2007년 27주 이전 data 조회시 조회 불가 및 Error Message 보여줌
* 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
*                  Year, Month, Week관련 화면변경
* 2008.02.28 박은주 N200802250022 MAS_RD 관련 수정 요청
*                  화면에 Excluding SOC 항목 추가
* 2008.03.21 박은주 N200802280015 MAS_Report 관련 수정 요청_1,2번항목
*                  2. Inquiry by Customized Condition[060]
*                  - Cost 수식 수정 : Cost = G.RPB + DEM/DET - CMB
*                  - C.S.REP 수정 (현재 L.REP 정보를 보여주고 있음)
*                  - L.REP 추가
*                  - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화
* 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1,2번항목
*                  Week선택시에 Month, Week를 입력할수 있도록 변경[060,062,070]
* 2008.04.07 박은주 N200804020018 MAS Report 수정 요청
*                  1. Inquiry by Customized Condition
*                   - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
*                      (첨부파일 참조)
*                   - 화면 하단에 아래 메세지 수정 및 추가
*                      ▶ Please reset the report form - in the event that an error occurs.
*                      ▶ If you want to check all costs related to the booking, please include
*                          the BKG number when retrieving the data and double click it.
*                  2. Office Report vs QTA
*                   - 기간 표시 (타화면 참조)
*                  3. Inquiry by BKG
*                   - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망
* 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.06.30 박은주 N200806127354 MAS_조회권한 관련 요청
* 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060]
* 2009.02.04 김태윤 N200901210016 - MAS_조직개편 관련 기능 수정
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.03.24 배진환 N200903130001 - Key Account 조회 조건 변경
* 2009.04.03 김태윤 N200903170123 - MAS_Multi-dimension report 조회권한 변경, 디자인 수정
* 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.10.23 김기대 New FrameWork 적용
* 2009.12.03 윤진영 CHM-200901273 Inquiry by Customized Condition 검색조건 추가 및 라이크 검색 가능하도록 기능 변경
* 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
* 2010.02.01 윤진영 CHM-200901765 TAA_NO 추가
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> masFormQueryString 변경
* 2010.07.29 김기종 InitHeadMode ColumnMove 변경
* 2010.09.01 김기종 CSR No. CHM-201004982-01 MAS Architecture 위배사항 수정
* 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
* 2010.09.08 이석준 [CHM-201005894-01] RPB,CMB total값 오류
* 2010.09.27 장영석 CSR No. CHM-201005937    Inquiry by customized condition 기능추가
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.04.15 최성민 [CHM-201110234-01] Key Account / Strategic Account Check Mark 추가하여, Key Account와 Strategic group에 
									  해당하는  BKG들만 모아서 모두 조회할 수 있는 기능추가
* 2011.06.01 최윤성 [CHM-201111117-01] Split 04-Split 03-ALPS Error 처리 요청 - 폼입력값에 대한 체크 로직 추가(Year, Mon, Week)
* 2011.06.22 김민아 [CHM-201111640-01] Reefer Core Account 조회조건 추가
*                                     - Combobox, Checkbox 추가 및 W/M, Week Display Event 발생시 로직 수정
* 2012.01.03 김성훈 [CHM-201114896-01] PROFIT LEVEL 선택 부분을 신규 코드로 변경 (CD02979로 변경 )
* 2012.04.19 김종준 [CHM-201217338-01] 리드 항목에 BKG_NO,BL_NO 존재시 검색조건중 Trade,Lane 필수 검색조건으로 변경
* 2012.04.26 전윤주  [CHM-201217584]   header 에 BKG_NO, BL_NO 존재 시 
*                                    Office Level을 Head Office로 했을때 :  Trade만 강제 선택, Lane은 선택할 필요 X 
                                     Office Level이 Head Office가 아닐경우 Office도 선택해야만 Trade Lane 조건 해제
                                                                          검색 기간 조건은 10주로 줄임 
* 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
* 2012.10.23 최성민 [CHM-201220825] [MAS] CAM 조직 변경에 따른 MAS 반영
* 2012.11.13  원종규 [CHM-201221335]	[MAS] Inquiry by customized condition 기능 관련: SELCDA일 경우 BKG_No 헤더 선택 시 제한 조건을 적용하지 않도록 변경
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
* 2013.01.21 성미영 [CHM-201322531] [MAS] Inquiry by Customized Condition 버튼 수정: GA, RA check Box 추가 
* 2013.05.29 김수정[CHM-201324876]   [MAS] MAS Report내 "IAS Region " / "Bound2" 추가
* 2013.07.01 최성민[CHM-201325476] [MAS] Inquiry by Customized Condition 검색 기간 변경
* 2014.01.15 김수정 [CHM-201428428] [MAS] Inquiry by Customized Condition 조회조건 제한
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청 
* 2016.01.26 김성욱 [CHM-201539636] Inquiry by Customized Condition Rating date 구분자 개발 검토 요청
* 2016.03.02 김성욱 xxx Inquiry by Customized Condition 검색시 제약 조건 추가(out of memory 발생, TPS선택시 Sub Trade 선택 필수, month:1M, Week:4W, Result Title:30개)
* 2017.05.17 김동호 [CSR #791] ALPS 화면의 실적산출 값에 'CNTR Size/Type'를 기본 컬럼으로 추가
===========================================================================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_MAS_0060 : ESM_MAS_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0060() {
    this.processButtonClick = processButtonClick;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initCombo = initCombo;
    this.initHeader = initHeader;
    this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
    this.sheet1_OnDblClick = sheet1_OnDblClick;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
    this.clearDatePeriod = clearDatePeriod;
    this.setPeriod = setPeriod;
    this.chkValidSearch = chkValidSearch;
    this.chgHeader = chgHeader;
    this.chgGroup = chgGroup;
    this.chgInitSheet = chgInitSheet;
    this.changeViewColumn = changeViewColumn;
    this.viewBound = viewBound;
    this.viewWeek = viewWeek;
    this.changeType = changeType;
//    this.f_key_acct_group_cd_OnChange = f_key_acct_group_cd_OnChange;
    this.chgOffice = chgOffice;
    this.changeCostYrmon = changeCostYrmon;
    this.f_trd_cd_OnChange = f_trd_cd_OnChange;
    this.comPopupLoc = comPopupLoc;
    this.getCOM_ENS_021_1 = getCOM_ENS_021_1;
    this.ShipperPopUp = ShipperPopUp;
}


/**
 * =========================================================
 * History

 * =========================================================
 **/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var reportFormPopupCallCnt = 0;
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
        try {
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;

                case "bu_prev":
                    sheetObject.style.height = sheetObject.GetSheetHeight(100);
                    div_toggle_prev.style.display = "none";
                    div_toggle_next.style.display = "inline";
                    break;

                case "bu_next":
                    sheetObject.style.height = sheetObject.GetSheetHeight(18);
                    div_toggle_prev.style.display = "inline";
                    div_toggle_next.style.display = "none";
                    break;
                    
                case "btn_ExcelFile":
                	doActionIBSheet(sheetObject,formObject,IBCREATE);
                	break;

            } // end switch
        }catch(e) {
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
    function loadPage(title, col_nm) {    	 
        var formObject = document.form;
//        setFocus(formObject.f_year);

        loadingMode = true;
        initControl();    
        

        loadingMode = false;

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1, title, col_nm);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        //---------------------------------------------
        formObject.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
        formObject.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
        formObject.f_year.focus();
        
        //Profit Level 에 OP 권한 확인
        ComMasOpCheckOfcCd(formObject.f_pro_lvl, usr_ofc_cd);        
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, title, col_nm) {
        var cnt = 0;
        var colCnt = 0;
        var varCnt = 0;
        var colTotNum = 0;
        var aryTitle = new Array();
        var t1 = "";
        var colWidth = 0;
        var colWidth1 = 0;
        var formObj = document.form;
        var colTmp = 0;
        var tpCnt = 0;

        if(title != ""){
            var tNM = title.split("|");
            var tCnt = tNM.length;
            for(var j=0; j<tCnt ; j++) {
                t1 = t1+ tNM[j] + "|";
            }
        }
        aryTitle = col_nm.split("|");
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    if(t1 != "") colCnt = aryTitle.length;

                    /* 2017.05.17 [CSR #791] 에 따라 로직 제거
                    //BOX/TEU에 따라 TP/SZ 컬럼 숫자 변경 (BOX 선택시 TP/SZ 유지, TEU 선택시  TP/SZ 제외) [CHM-201641812] 2016.06.
                    if(formObj.f_view_tpsz[0].checked) {                    	
                    	tpCnt = 0;
                    } else {
                    	tpCnt = -1;
                    }
                    */
                    
                    if(formObj.f_include_ts.checked) {
                        colTotNum = colCnt + 21 + tpCnt + varCnt ;                  
                    } else {
                        colTotNum = colCnt + 20 + tpCnt + varCnt ;                    	
                    }

                    colTotNum = colTotNum + colTmp
                    SheetWidth = mainTable.clientWidth;             //전체 너비 설정
                    colWidth1 = 110;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                      //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                               //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 50);                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    //MassOfSearch = 1;                               //대량데이타조회시
                    InitColumnInfo(colTotNum, 0, 0, true);          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

                    var HeadTitle = "R.MONTH|S.MONTH|WEEK|";

                    if(formObj.f_include_ts.checked) {
                        HeadTitle = HeadTitle + "T/S Status|" + t1;                   
                    } else {
                    	HeadTitle = HeadTitle + t1;      
                    }
                    
                    
                    if(formObj.f_view_tpsz[0].checked) {
                        HeadTitle = HeadTitle + "BOUND|TP/SZ|LOAD|REV|CM COST|CM|CM2 COST|CM2|RPB(BOX)|CM_COST|CM CPB(BOX)|CMB(BOX)|OP COST|OP|OP_COST|OP CPB(BOX)|OPB(BOX)" ;
                    } else {
                        //2017.05.17 [CSR #791] 에 따라 로직 제거
                        //HeadTitle = HeadTitle + "BOUND|LOAD|REV|CM COST|CM|CM2 COST|CM2|RPB(TEU)|CM_COST|CM CPB(TEU)|CMB(TEU)|OP COST|OP|OP_COST|OP CPB(TEU)|OPB(TEU)" ;
                        HeadTitle = HeadTitle + "BOUND|TP/SZ|LOAD|REV|CM COST|CM|CM2 COST|CM2|RPB(TEU)|CM_COST|CM CPB(TEU)|CMB(TEU)|OP COST|OP|OP_COST|OP CPB(TEU)|OPB(TEU)" ;
                    }
                    
                    formObj.f_savename.value = HeadTitle;
                    

                    InitHeadRow(0, HeadTitle, true);                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "cost_yrmon", false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "sls_yrmon",  false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "cost_wk",    false,  "", dfNone,      0,  false,  false);

                    if(formObj.f_include_ts.checked) {
                        //InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true,  "bkg_no",    false,  "", dfNone,      0,  false,  false);
                        InitDataProperty(0, cnt++ , dtData,     70,         daCenter, true,  "ts_sts",    false,  "", dfNone,      0,  false,  false);              
                    }
                    
                    //동적 레이아웃 시작
                    for(var j=0; j<colCnt ; j++) {
                        if (aryTitle[j] == "CMDT_DESC" ||aryTitle[j] == "SC_DESC"||aryTitle[j] == "SHPR_CNT_CD" ){
                             InitDataProperty(0, cnt++ , dtData,  190,    daLeft,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        }  else if (aryTitle[j] == "BKG_CGO_WGT"){
                             InitDataProperty(0, cnt++ , dtData,  100,    daRight,   true, aryTitle[j],  false,  "",  dfNullFloat,  2, false, false,    6);
                        }  else if (aryTitle[j] == "MST_RFA_ROUT_ID"){
                             InitDataProperty(0, cnt++ , dtData,  130,    daCenter,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        }  else if (aryTitle[j] == "BKG_NO" || aryTitle[j] == "BL_NO" || aryTitle[j] == "REP_CMDT_DESC" || aryTitle[j] == "SC_CUST_NM" || aryTitle[j] == "BKG_SHPR_NM" || aryTitle[j] == "SHPR_NM" || aryTitle[j] == "CNEE_NM" || aryTitle[j] == "NTFY_NM"){
                        	 InitDataProperty(0, cnt++ , dtData,  colWidth1,    daLeft,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        } else if (aryTitle[j] == "VGM_WGT"){ 
                             InitDataProperty(0, cnt++ , dtData,  65,    daRight,   true, aryTitle[j],  false,  "",  dfFloatOrg,  2, false, false,    6);
                        } else {
                        	 InitDataProperty(0, cnt++ , dtData,  colWidth1,    daCenter,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        }
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "bound_cd",   false,  "", dfNone,      0,  false,  false);
                    
                    /*
                    2017.05.17 [CSR #791] 에 따라 로직 제거
                    //[CHM-201641812] 2016.06.
                    if(formObj.f_view_tpsz[0].checked) {
                    	InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "tpsz_code",  false,  "", dfNone,      0,  false,  false);
                    }
                    */
                    InitDataProperty(0, cnt++ , dtData,     60,         daCenter, true,  "tpsz_code",  false,  "", dfNone,      0,  false,  false);
                    
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "load",       false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "rev",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmc",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm",         false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm2c",	   false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm2",        false,  "", dfFloatOrg,  2,  false,  false);                    
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "g_rpb",      false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm_cost",    false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmcost",     false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmb",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opc",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op",         false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op_cost",    false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opcost",     false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opb",        false,  "", dfFloatOrg,  2,  false,  false);

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(18) ;
                    // Profit Level에 따라서 컬럼을 보여준다
                    //------------------------------------
                    ColHidden("cm_cost") = true;
                    ColHidden("op_cost") = true;
                    changeViewColumn();
                    viewBound();
                    viewWeek();

                }
                break;
        }
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
    function initCombo(comboObj, comboId) {

        with (comboObj) {
            if (comboId ==  "f_sls_ofc_cd") {
                MaxLength = 6;
                ValidChar(2, 1);
            } else if (comboId ==  "f_trd_cd") {
                MaxLength = 3;
                ValidChar(2, 0);
            }  else if (comboId ==  "f_sub_trd_cd") {
                MaxLength = 2;
                ValidChar(2, 0);
                Text2 = "All";
            } else if (comboId ==  "f_rlane_cd") {
                MaxLength = 5;
                ValidChar(2, 1);
                Text2 = "All";
            } else if (comboId ==  "f_skd_dir_cd") {
                MaxLength = 1;
                ValidChar(2, 0);
            }  else if (comboId ==  "f_hul_bnd_cd") {
                MaxLength = 2;
                ValidChar(2, 0);
            } else if (comboId ==  "f_ias_rgn_cd") {
                MaxLength = 3;
                ValidChar(2, 0);
            }  else if (comboId ==  "f_ias_sub_grp_cd") {
                MaxLength = 4;
                ValidChar(2, 1);
            } else if (comboId ==  "f_key_acct_group_cd") {
                SetColAlign("left");
                SetColWidth("300")
                Text2 = "All";
            } else if (comboId ==  "f_ofc_team_cd") {
                MaxLength = 8;
                ValidChar(2, 1);
                SetColAlign("left");
                SetColWidth("60")
                Text2 = "All";
            }
//            else if (comboId ==  "f_sa_trd_group_cd") {
//                SetColAlign("left");
//                SetColWidth("300")
//                Text2 = "All";
//            }
//            else if (comboId ==  "f_sa_trd_indvl_cd") {
//                MaxLength = 8;
//                ValidChar(2, 1);
//                SetColAlign("left|left");
//                SetColWidth("100|300")
//                Text2 = "All";
//            }
            else if (comboId ==  "f_cmdt_cd") {
                MaxLength = 4;
                ValidChar(2, 1);
                SetColAlign("left|left");
                SetColWidth("40|350")
                Text2 = "All";
            } else if (comboId ==  "f_usa_bkg_mod_cd") {    // US Mode
                ValidChar(2, 1);
            } else if (comboId ==  "f_mdm_charge_cd") {    // Surcharge
                MaxLength = 3;
                ValidChar(2, 1);
            } else if (comboId ==  "f_cntr_tpsz_cd") {    // Type/Size
            	MultiSelect = true;
            	MultiSeparator = ",";
                ValidChar(2, 1);
            } else if (comboId ==  "f_mdm_charge_type_cd") {    // Surcharge Type
                MultiSelect = true;
                UseCode = true;
                MultiSeparator = ",";
            } else if (comboId ==  "f_selgroup") {
                ValidChar(2, 1);
            } else if (comboId ==  "f_rf_core_acct_cd") {		// RF Core Acct
                SetColAlign("left");
                SetColWidth("300")
                Text2 = "All";
            } else if (comboId ==  "f_mt_pu_yd_cd") {		// Mty Pick Up CD
                SetColWidth("40")
                Text2 = "All";
            } else if (comboId ==  "f_ra_acct_group_cd") {		// RA(Group)
                SetColAlign("left");
                SetColWidth("300")
                Text2 = "All";
            } else if (comboId ==  "f_cust_rhq_cd") {		// RA(individual)
                MaxLength = 8;
                ValidChar(2, 1);
                SetColAlign("left");
                SetColWidth("60")
                Text2 = "All";
            }
            IMEMode = 0;
            DropHeight = 200;
            Index = 0;
        }
    }

    /**
     * sheet를 초기화 시킨다.
     */
    function initHeader(sheetObj, formObj){
      // Header 정보를 변경하기 위해 sheet를 초기화 한다.
      //--------------------------------------------------
      // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
      sheetObj.Redraw = false;
      sheetObj.RemoveAll();
      sheetObj.Reset();
      initSheet(sheetObj, 1, formObj.f_header.value, formObj.f_headernm.value);
      sheetObj.Redraw = true;
      //--------------------------------------------------

    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     *
     */
    function sheet1_OnDblClick(sheetObj, row, col, value){
        if(sheetObj.SaveNameCol("BKG_NO")>=0 ){
            var display       = "0,1";
            var formObj = document.form;
            var bkg_no = sheetObj.CellValue(row, "BKG_NO");

            var param = "?f_pro_vw="  +getIbComboObjValue(formObj.f_pro_vw)
                       +"&f_pro_lvl=" +getIbComboObjValue(formObj.f_pro_lvl)
                       +"&f_s_bkg_no="+bkg_no
                       +"&pgmNo=ESM_MAS_0061";
			ComOpenWindow2('ESM_MAS_0061POP.do'+param,'Inquiry by BKG', 'width=850,height=760,menubar=0,status=1,scrollbars=1,resizable=1');
        }
    }

    /*===================================================================================================================
     * 2010.09.08 이석준 [CHM-201005894-01] formObj를 선언하지 않아서 Script오류가 발생함. 이에 formObj 선언해줌
     *===================================================================================================================/
    /**
     * 조회후 Total 항목중 재계산해야 하는 항목 계산.
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){

    	var formObj = document.form;

        if(eval(sheetObj.SumValue(0, "load")) > 0){
        	if (getIbComboObjValue(formObj.f_mdm_charge_cd) != ""){

        	}else{
        		sheetObj.SumValue(0, "g_rpb")  = eval(sheetObj.SumValue(0, "rev")       + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
        	}
            sheetObj.SumValue(0, "cmcost") = eval(sheetObj.SumValue(0, "cm_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
            sheetObj.SumValue(0, "opcost") = eval(sheetObj.SumValue(0, "op_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
            sheetObj.SumValue(0, "cmb")    = eval(sheetObj.SumValue(0, "cm")        + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
            sheetObj.SumValue(0, "opb")    = eval(sheetObj.SumValue(0, "op")        + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
        } else {
            sheetObj.SumValue(0, "g_rpb")  = "0";
            sheetObj.SumValue(0, "cmcost") = "0";
            sheetObj.SumValue(0, "opcost") = "0";
            sheetObj.SumValue(0, "cmb")    = "0";
            sheetObj.SumValue(0, "opb")    = "0";
        }
    }

    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBCLEAR);
    	
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
    }
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBCLEAR:          //조회
	        	formObj.f_year.value = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        sheetObj.WaitImageVisible = false;
		        
				ComOpenWait(true);
		        /*
	        	formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", FormQueryString(formObj));
				*/
				var sXml = document.form.sXml.value;
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State == "S"){
					ComShowMessage(OBJECT_ERROR);
					ComOpenWait(false);
					return;
				}
				var arrXml = sXml.split("|$$|");
				if (ComGetEtcData(arrXml[0], "ofc_cd") == undefined){
					ComShowMessage(OBJECT_ERROR);
					ComOpenWait(false);
					return;
				}
				document.form.sXml.value = "";
				formObj.ofc_cd.value = ComGetEtcData(arrXml[0], "ofc_cd");
		        formObj.ofc_lvl.value = ComGetEtcData(arrXml[0], "ofc_lvl");
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
					ComXml2ComboItem(arrXml[3], formObj.f_rhq_cd, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_sls_ofc_cd, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], formObj.f_trd_cd, "code", "code");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], formObj.f_rlane_cd, "code", "code");
				if (arrXml.length > 7)
					ComXml2ComboItem(arrXml[7], formObj.f_sub_trd_cd, "code", "code");

//				if (arrXml.length > 7)
//					ComXml2ComboItem(arrXml[7], formObj.f_skd_dir_cd, "code", "code");
				if (arrXml.length > 8)
					ComXml2ComboItem(arrXml[8], formObj.f_key_acct_group_cd, "code", "name");
				if (arrXml.length > 9)
					ComXml2ComboItem(arrXml[9], formObj.f_ofc_team_cd, "code", "code");
				if (arrXml.length > 10)
					ComXml2ComboItem(arrXml[10], formObj.f_cmdt_cd, "code", "code|name");
				if (arrXml.length > 11)
					ComXml2ComboItem(arrXml[11], formObj.f_usa_bkg_mod_cd, "code", "code");
				if (arrXml.length > 12)
					ComXml2ComboItem(arrXml[12], formObj.f_cntr_tpsz_cd, "code", "code");
				if (arrXml.length > 13)
					ComXml2ComboItem(arrXml[13], formObj.f_selgroup, "code", "name");

				if (arrXml.length > 14)
					ComXml2ComboItem(arrXml[14], formObj.f_ias_sub_grp_cd, "code", "code");
//				if (arrXml.length > 15)
//					ComXml2ComboItem(arrXml[15], formObj.f_sa_trd_group_cd, "code", "name");
//				if (arrXml.length > 16)
//					ComXml2ComboItem(arrXml[16], formObj.f_sa_trd_indvl_cd, "code", "code|name");
				if (arrXml.length > 15)
					ComXml2ComboItem(arrXml[15], formObj.f_mdm_charge_cd, "code", "code");

				if (arrXml.length > 16)
					ComXml2ComboItem(arrXml[16], formObj.f_mdm_charge_type_cd, "code", "code");
				
//				if (arrXml.length > 19)
//					ComXml2ComboItem(arrXml[19], formObj.f_rf_core_acct_cd, "code", "name");
//
				if (arrXml.length > 17)
					ComXml2ComboItem(arrXml[17], formObj.f_ra_acct_group_cd, "code", "name");
				if (arrXml.length > 18)
					ComXml2ComboItem(arrXml[18], formObj.f_cust_rhq_cd, "code", "code");
				if (arrXml.length > 19)
					ComXml2ComboItem(arrXml[19], formObj.f_skd_dir_cd, "code", "code");
				if (arrXml.length > 20)
					ComXml2ComboItem(arrXml[20], formObj.f_ias_rgn_cd, "code", "name");
				if (arrXml.length > 21)
					ComXml2ComboItem(arrXml[21], formObj.f_hul_bnd_cd, "code", "name");
				
				ComOpenWait(false);
				break;

        	case IBSEARCH:
        		if(!validateForm(sheetObj, formObj, sAction)) return false;

                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				// Retrieve
                formObj.f_cmd.value = SEARCHLIST01;
                formObj.f_shipper.value = formObj.txtShipper.value;
                // 대용량 데이터를 뿌려줄때 사용하는 함수[LoadSearchXml4Sax]
                //---------------------------------------------------------------------------
                //20100414 이중환, FormQueryString -> masFormQueryString 변경
                var sParam = masFormQueryString(formObj);
                var xml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", sParam);
                sheetObj.LoadSearchXml4Sax(xml, false, -1, false);
                ComOpenWait(false);
                break;

            case IBRESET:          //Header 정보를 조회한다.
            	// 업무처리중 버튼사용 금지 처리
				//sheetObj.WaitImageVisible = false;
				//ComOpenWait(true);
                formObj.f_cmd.value = SEARCH01;
                //sheetObj.DoSearch4Post("ESM_MAS_0060GS.do", FormQueryString(formObj));
                //20100414 이중환, FormQueryString -> masFormQueryString 변경
                sheetObj.DoSearch4Post("ESM_MAS_0060GS3.do", masFormQueryString(formObj));
                //ComOpenWait(false);
                formObj.f_header.value   = sheetObj.EtcData("header");
                formObj.f_headernm.value = sheetObj.EtcData("headerNM");
                sheetObj.RemoveEtcData();

                initHeader(sheetObj, formObj);

                break;

            case IBDOWNEXCEL:       //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1, true, true);
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
            case IBCREATE: //Excel File Download - 검색 결과가 화면에 나타지 않음...
            	
            	if(!validateForm(sheetObj, formObj, sAction)) return false;

                // 업무처리중 버튼사용 금지 처리
 				sheetObj.WaitImageVisible = false;
 				ComOpenWait(true);
 				// Retrieve
                formObj.f_cmd.value = SEARCHLIST03;
                formObj.f_shipper.value = formObj.txtShipper.value;
                var sParam = masFormQueryString(formObj);
                formObj.target = "_blank";
                formObj.action = "ESM_MAS_DOWN.do?"+sParam;
                formObj.submit();
                ComOpenWait(false);
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * 일반 검색 : 
     *   Trade 가 TPS인 경우 sub trade 선택하지 않으면 1주 검색
     *   Trade 선택한 경우 sub trade 선택시 4주 검색
     * File Download :
     *   Trade / Sub Trade 선택안하면 1주
     *   Trade 선택 시 8주
     * 
     * 2017.07.25 SM 상선 기준 데이터 양이 많지 않아 거의 모든 제약조건을 삭제함. 
     */
    function validateForm(sheetObj,formObj,sAction){
    	
        with(formObj){
        	//var hd = document.form.f_headernm.value;
            
            if(!isValidYear(f_year,false,true)) return false;
        	            
            if(f_chkprd[0].checked){
                if(f_fm_wk.value == "") {
                    ComShowMessage(ComGetMsg("COM12114","From Week",""));
                    f_fm_wk.focus();
                    return false;
                }

                if(f_fm_wk.value.length != 2) {
                    ComShowMessage(ComGetMsg("COM12114","From Week",""));
                    f_fm_wk.focus();
                    return false;
                }

                if(f_to_wk.value == "") {
                    ComShowMessage(ComGetMsg("COM12114","To Week",""));
                    f_to_wk.focus();
                    return false;
                }

                if(f_to_wk.value.length != 2) {
                    ComShowMessage(ComGetMsg("COM12114","To Week",""));
                    f_to_wk.focus();
                    return false;
                }
            } else {
                if(f_fm_mon.value == "") {
                    ComShowMessage(ComGetMsg("COM12114","From Month",""));
                    f_fm_mon.focus();
                    return false;
                }

                if(f_fm_mon.value.length != 2) {
                    ComShowMessage(ComGetMsg("COM12114","From Month",""));
                    f_fm_mon.focus();
                    return false;
                }

                if(f_to_mon.value == "") {
                    ComShowMessage(ComGetMsg("COM12114","To Month",""));
                    f_to_mon.focus();
                    return false;
                }

                if(f_to_mon.value.length != 2) {
                    ComShowMessage(ComGetMsg("COM12114","To Month",""));
                    f_to_mon.focus();
                    return false;
                }
            }
            
            if(f_fm_mon.value == "" && f_fm_wk.value == ""){
                // [COM12138] : Month 과 Week 중 하나는 입력하세요.
                ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
                return false;
            }
            
            if((f_chkprd[1].checked && f_year.value == "2007" && ComParseInt(f_fm_mon.value) < 7) ||
               (f_chkprd[0].checked && f_year.value == "2007" && ComParseInt(f_fm_wk.value) < 27)){
                // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
                ComShowMessage(ComGetMsg("MAS10037"));
                return false;
            }            
            
            if( sAction == IBCREATE ) {
                formObj.f_excel.value = "Y";
            } else {
                formObj.f_excel.value = "N";    
            }
            
            if(parseInt(ComTrim(f_year.value)) < 2017) {
                if(f_chkprd[0].checked) {
                    if( sAction == IBSEARCH ){
                        if( getIbComboObjValue(f_trd_cd) == "" && f_to_wk.value - f_fm_wk.value >= 4){
                            ComShowMessage(ComGetMsg("MAS10038","4 Weeks"));
                            return false;
                        }
                        /*
                        if( getIbComboObjValue(f_trd_cd) != "" && getIbComboObjValue(f_sub_trd_cd) == "" && f_to_wk.value - f_fm_wk.value >= 4){
                            ComShowMessage(ComGetMsg("MAS10038","4 Weeks"));
                            return false;
                        }
                        */
                    } else if( sAction == IBCREATE ) {//엑셀파일로 다운로드
                        if( f_to_wk.value - f_fm_wk.value >= 4){
                            ComShowMessage(ComGetMsg("MAS10038","4 Weeks"));
                            ComSetFocus(f_trd_cd);
                            return false;
                        }
                    }
                } else {
                    if(  f_to_mon.value - f_fm_mon.value > 0) {//1개월 이상 불가
                        ComShowMessage(ComGetMsg("MAS10038","1 month"));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Seq를 선택하면 Date Period를 clear한다.
     */
    function clearDatePeriod(){
        document.form.txtWeek.value = "";
        document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
    	 ComMasSetPeriod(obj);
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
            if (f_fm_mon.value != "" && f_to_mon.value == ""){
                // [COM12114] : Month 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114", "Month"))
                f_to_mon.focus();
                return false;
            }
            if (f_fm_mon.value == "" && f_to_mon.value != "") {
                // [COM12114] : Month 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114", "Month"));
                f_fm_mon.focus();
                return false;
            }
            if (f_fm_mon.value > f_to_mon.value) {
                // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
                ComShowMessage(ComGetMsg("MAS10011","Month","From","To"));
                f_to_mon.focus();
                return false;
            }
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
            if (f_fm_wk.value > f_to_wk.value) {
                // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
                ComShowMessage(ComGetMsg("MAS10011","Week","From","To"));
                f_to_wk.focus();
                return false;
            }
            if(f_fm_mon.value == "" && f_fm_wk.value == ""){
//              ComShowMessage(ComGetMsg("COM12138", "month", "week"));
                return false;
            }

//            if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
//            if(!ComChkObjValid(f_fm_mon, null, null, "ym")) return false;
//            if(!ComChkObjValid(f_to_mon, null, null, "ym")) return false;
//            if(!ComChkObjValid(f_fm_wk, null, null, "yw")) return false;
//            if(!ComChkObjValid(f_to_wk, null, null, "yw")) return false;
            
            if(!isValidYear(f_year,false,true)) return false;
    		if(!isValidMonth(f_fm_mon,false,true)) return false;
    		if(!isValidMonth(f_to_mon,false,true)) return false;
    		if(!isValidWeek(f_fm_wk,false,true)) return false;
    		if(!isValidWeek(f_to_wk,false,true)) return false;
        }
        return true;
    }

    /**
     * Group combo 변경시 sheet의 Header정보를 변경시킨다.
     */
    function chgHeader(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        doActionIBSheet(sheetObj,formObj,IBRESET);
    }

    /**
     * Popup이 닫힌 후 group combo를 변경 시킨다.
     */
    function chgGroup(param){
    	var formObj = document.form;
        var sheetObj = sheetObjects[0];
     	formObj.f_cmd.value = SEARCHLIST12;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.f_selgroup, "code", "name");
		ComSetObjValue(formObj.f_selgroup,param);
     }

     /**
      * f_selgroup 변경시 sheet의 Header정보를 변경
      */
     function f_selgroup_OnChange(obj, code){
    	 if (loadingMode == true) return;
    	 chgHeader();
     }

    /**
     * 59번 화면이 닫희면서 sheet의 header목록을 변경위해서 sheet를 초기화한다..
     */
    function chgInitSheet(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        initHeader(sheetObj, formObj);

    }
	 /**
	 * Profit Level 변경시 컬럼을변경
	 */
	function f_pro_lvl_OnChange(obj, code) {
		if (loadingMode == true)
			return;
		changeViewColumn();
	}
	/**
	 * Profit View 변경시  컬럼을변경
	 */
	function f_pro_vw_OnChange(obj, code) {
		if (loadingMode == true)
			return;
		changeViewColumn();
	}
	/**
	 * Office View 변경시  컬럼을변경
	 */
	function f_ofc_vw_OnChange(obj, code) {
		if (loadingMode == true)
			return;
		changeViewColumn();
	}
	 /**
	 * Profit Level에 따라서 컬럼을 보여준다
	 */
	function changeViewColumn() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		if (getIbComboObjValue(formObj.f_pro_lvl) != "") {
			if (getIbComboObjValue(formObj.f_pro_lvl) == "O" && getIbComboObjValue(formObj.f_pro_vw) == "P") {
				sheetObj.ColHidden("opc") = false;
				sheetObj.ColHidden("op") = false;	
				sheetObj.ColHidden("opcost") = true;
				sheetObj.ColHidden("opb") = true;
				sheetObj.ColHidden("cm2") = true;
				sheetObj.ColHidden("cm2c") = true;
			} else if(getIbComboObjValue(formObj.f_pro_lvl) == "M" ){
				sheetObj.ColHidden("opc") = false;
				sheetObj.ColHidden("op") = false;
				sheetObj.ColHidden("opcost") = false;
				sheetObj.ColHidden("opb") = false;
				sheetObj.ColHidden("cm2") = false;
				sheetObj.ColHidden("cm2c") = false;
				// 2012.1.18 SHKIM OP COST , BKG_OP
				sheetObj.ColHidden("opc") = true;
				sheetObj.ColHidden("op") = true;
			} else {
				sheetObj.ColHidden("opc") = true;
				sheetObj.ColHidden("op") = true;
				sheetObj.ColHidden("opcost") = true;
				sheetObj.ColHidden("opb") = true;
				sheetObj.ColHidden("cm2") = true;
				sheetObj.ColHidden("cm2c") = true;
			}

			if (getIbComboObjValue(formObj.f_pro_vw) == "R") {
				sheetObj.CellValue(0, "cm") = "BKG CM";
				if (formObj.f_pro_lvl.GetCount () == 2) {
					formObj.f_pro_lvl.DeleteItem("O");
					formObj.f_pro_lvl.Code = "C";
				}
			} else {
				sheetObj.CellValue(0, "cm") = "CM";
				if (formObj.f_pro_lvl.GetCount () == 1) {
					formObj.f_pro_lvl.InsertItem(-1, "OP", "O");
				}
			}
		}
	}

    /**
     * Bound 컬럼의 view 유무에 따라서 sheet를 보여준다.
     */
    function viewBound(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        if(formObj.f_dir_sts.checked){
            sheetObj.ColHidden("bound_cd")     = false;
        } else {
            sheetObj.ColHidden("bound_cd")     = true;
        }
        sheetObj.RemoveAll();
    }

    function viewWeek(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        if(formObj.f_wk_sts.checked){
            sheetObj.ColHidden("cost_yrmon")  = false;
            sheetObj.ColHidden("sls_yrmon")   = false;
            sheetObj.ColHidden("cost_wk")     = false;
        } else {
        	if(formObj.f_chkprd[0].checked) sheetObj.ColHidden("cost_yrmon")  = true;
        	else sheetObj.ColHidden("cost_yrmon")  = false;
            sheetObj.ColHidden("sls_yrmon")   = true;
            sheetObj.ColHidden("cost_wk")     = true;
        }
        sheetObj.RemoveAll();

    }

    /**
     * Type per TEU/ Type per Box 에 따라서 header정보를 변경시켜준다.
     */
    function changeType(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        initHeader(sheetObj, formObj);
    }

    // 콤보 처리
    //--------------------------------------------------------------------
    /**
     * key acctount group 변경시 key acctount indvl combo변경
     */
    function f_key_acct_group_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(formObj.f_ra_acct_group_cd.Text!="All" && formObj.f_key_acct_group_cd.Text!="All"){
        	formObj.f_ra_acct_group_cd.Index2 = 0;
        }
        if(obj.Text != "All"){
        	formObj.f_cmd.value = SEARCHLIST10;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
			formObj.f_ofc_team_cd.Index2 = 1;
			if(formObj.f_ofc_team_cd.Text==""){
				formObj.f_ofc_team_cd.Index2 = 0;
			}
			if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_cust_rhq_cd, "code", "code|name");
			formObj.f_cust_rhq_cd.Index2 = 1;
			if(formObj.f_cust_rhq_cd.Text==""){
				formObj.f_cust_rhq_cd.Index2 = 0;
			}
        }else if(obj.Text == "All"){
        	formObj.f_cmd.value = SEARCHLIST16;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
			formObj.f_ofc_team_cd.Index2 = 0;
			if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_cust_rhq_cd, "code", "code|name");
			formObj.f_cust_rhq_cd.Index2 = 0;
        }
    }

    /**
     * H/O Team 변경시 Core Customer, Regional Customer combo변경
     */
    function f_ofc_team_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(formObj.f_ofc_team_cd.GetCount()>3){
	        if(obj.Text != ""){
	        	formObj.f_cmd.value = SEARCHLIST14;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_key_acct_group_cd, "code", "name");
				formObj.f_key_acct_group_cd.Index2 = 0;
				if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ra_acct_group_cd, "code", "name");
				formObj.f_ra_acct_group_cd.Index2 = 0;
	        }
        }
    }
    
    /**
     * H/O Team 변경시 Core Customer, Regional Customer combo변경
     */
    function f_cust_rhq_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(formObj.f_ofc_team_cd.GetCount()>3){
	        if(obj.Text != ""){
	        	formObj.f_cmd.value = SEARCHLIST14;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_key_acct_group_cd, "code", "name");
				formObj.f_key_acct_group_cd.Index2 = 0;
				if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ra_acct_group_cd, "code", "name");
				formObj.f_ra_acct_group_cd.Index2 = 0;
	        }
        }
    }
    

    /**
     * RA(Group) 변경시 RA indvl combo변경
     */
    function f_ra_acct_group_cd_OnChange(obj, code){
    	if (loadingMode == true) return;

    	 var formObj = document.form;
         var sheetObj = sheetObjects[0];
         if(formObj.f_ra_acct_group_cd.Text!="All" && formObj.f_key_acct_group_cd.Text!="All"){
         	formObj.f_key_acct_group_cd.Index2 = 0;
         }
         if(obj.Text != "All"){
         	formObj.f_cmd.value = SEARCHLIST10;
 			var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
 			formObj.f_ofc_team_cd.Index2 = 1;
			if(formObj.f_ofc_team_cd.Text==""){
				formObj.f_ofc_team_cd.Index2 = 0;
			}
 			if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], formObj.f_cust_rhq_cd, "code", "code|name");
 			formObj.f_cust_rhq_cd.Index2 = 0;
//			if(formObj.f_cust_rhq_cd.Text==""){
//				formObj.f_cust_rhq_cd.Index2 = 0;
//			}
 			
         }else if(obj.Text == "All"){
        	formObj.f_cmd.value = SEARCHLIST16;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_ofc_team_cd, "code", "code|name");
			formObj.f_ofc_team_cd.Index2 = 0;
			if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_cust_rhq_cd, "code", "code|name");
			formObj.f_cust_rhq_cd.Index2 = 0;
        }
    }
    
    
    /**
     * Office Level 변경시 Office combo변경
     */
    function f_rhq_cd_OnChange(obj, code){
    	 if (loadingMode == true) return;
    	 chgOffice(obj);
    }

    /**
     * 본부 콤보변경시...
     */
    function chgOffice(obj){
    	 var formObj = document.form;
         var sheetObj = sheetObjects[0];

         if(obj.Text != ""){
         	formObj.f_cmd.value = SEARCHLIST13;
 			var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_sls_ofc_cd, "code", "code");
 			formObj.f_sls_ofc_cd.Index=0;
         }
    }


     /*
     * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
     */
    function changeCostYrmon(val){


        if(val != '') chgOffice(document.form.f_rhq_cd);
    }
    //changeCostYrmon

    /**
     * ifram을 이용하여 R.Lane 표시
     */
    function f_trd_cd_OnChange(obj) {
    	if (loadingMode == true) return;
    	var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(obj.Text != ""){
        	formObj.f_cmd.value = SEARCHLIST11;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");
			formObj.f_sub_trd_cd.Index = 0;
			formObj.f_rlane_cd.Index = 0;
        }
        
        if(obj.Text != "" && obj.Text == "IAS"){
			formObj.f_ias_rgn_cd.Enable = true;
		}else{
			formObj.f_ias_rgn_cd.Enable = false;
			formObj.f_ias_rgn_cd.Index = 0;
		}
    }
    
    /**
     * ifram을 이용하여 R.Lane 표시
     */
    function f_sub_trd_cd_OnChange(obj) {
    	if (loadingMode == true) return;
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	if(obj.Text != ""){
    		formObj.f_cmd.value = SEARCHLIST17;
    		var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
    		var arrXml = sXml.split("|$$|");
    		if (arrXml.length > 0)
    			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
    		formObj.f_rlane_cd.Index = 0;
    	}
    }

    /**
     * S/C, RFA 팝업창 띄우기
     */
    function comPopupLoc(flag, value) {
        display = "1,0,1,1,1,1,1,1";
        var cont_tp = "";
        var cont_no = "";

        if(value != ""){
            cont_tp = value.substring(0,3);
            cont_no = value.substring(3);
        }
        var param = "?cont_tp="+cont_tp+"&cont_no="+cont_no+"&flag="+flag;
        if(flag == 1){
            var targetFun = "getCOM_ENS_021_1";
        }
        ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 780, 480, targetFun, display, true);    // radio PopUp
    }

    /**
     * S/C 검색결과를 반환한다.
     */
    function getCOM_ENS_021_1(rowArray) {
        var colArray = rowArray[0];
//        ComShowMessage(rowArray.length+" ::::: " + colArray[0]+":"+colArray[1]+":"+colArray[2]+":"+colArray[3]+":"+colArray[4]+":"+colArray[5]+":"+colArray[6]+":"+colArray[7]+":"+colArray[8]);
        document.all.f_sc_no.value = colArray[2];
    }

    /**
     * Shipper PopUp 화면을 열어 준다
     *
     */
    function ShipperPopUp(){
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

        ComOpenWindow2('ESM_MAS_0144.do'+param,'', 'width=600,height=450,menubar=0,status=1,scrollbars=0,resizable=0');
    }

     /**
      * Type/Size 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
      */
     function f_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
     	if (code == "" || code == "All") {
     		var bChk = comboObj.CheckIndex(index);
     		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     			comboObj.CheckIndex(i) = bChk;
         	}
        }else{
        	comboObj.CheckIndex(0) = false;
        }
     }


     /**
      * Surcharge 콤보를 클릭할 때 전체체크
      * @param comboObj
      * @param index
      * @param code
      * @return
      */
     function f_mdm_charge_cd_OnChange(comboObj, index, code) {
    	 var formObj = document.form;
     	if (code == "" || code == "All") {
     		formObj.f_mdm_charge_type_cd.Enable = false;
     		formObj.f_mdm_charge_type_cd.Index = 0;
        }else{
        	formObj.f_mdm_charge_type_cd.Enable = true;
        }
     }

	  function getIbComboObjValue(obj){
	  	if (ComGetObjValue(obj) == "All" ){
	  		return "";
	  	}
	  	return ComGetObjValue(obj);
	  }
	  
	function initControl() {        
		    //Axon 이벤트 처리1. 이벤트catch 
			var formObject = document.form;       
//		    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
//		    axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//		    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
			axon_event.addListenerForm('change',	 'obj_change',	formObject); //- 변경될때.
    	    axon_event.addListenerForm('click',      'obj_OnClick', formObject);			
		} 
    
    
	function obj_change(){     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0];  

		if (loadingMode == true) return;
		
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "f_mt_pu_cd":  
	    			
	    		    	formObj.f_cmd.value = SEARCHLIST15;
	    				var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
	    				var arrXml = sXml.split("|$$|");
	    				if (arrXml.length > 0)
	    					 ACMXml2SelectItem(arrXml[0], formObj.f_mt_pu_yd_cd, "code", "code", false);
//	    				ComXml2ComboItem(arrXml[0], formObj.f_mt_pu_yd_cd, "code", "code");
//	    				formObj.f_mt_pu_yd_cd.Index = 0;
				   	break;  	
						 			          
			}       
	    }
	} 	  
	
	
    /**
     * Onbeforedeactivate  event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */   
     function obj_OnClick() {
         var formObj = document.form;
         var sheetObj = sheetObjects[0]; 
         var eleName = event.srcElement.name;

         switch(eleName){
         case "f_otr_key_acct":
       	  if (formObj.f_local_acct.checked || formObj.f_otr_regional_acct.checked){
       		  formObj.f_otr_key_acct.checked = false;
       		  ComShowMessage(ComGetMsg("MAS10067"));
       	  }
        	 break;
         case "f_local_acct":
       	  if (formObj.f_otr_key_acct.checked || formObj.f_otr_regional_acct.checked){
       		  formObj.f_local_acct.checked = false;
       		  ComShowMessage(ComGetMsg("MAS10067"));
       	  }
        	 break;
         case "f_otr_regional_acct":
       	  if (formObj.f_otr_key_acct.checked || formObj.f_local_acct.checked){
       		  formObj.f_otr_regional_acct.checked = false;
       		  ComShowMessage(ComGetMsg("MAS10067"));
       	  }
        	 break;

 		case "f_include_ts":  
            // if(formObj.f_include_ts.checked) {
         	//	ComSetObjValue(formObj.f_selgroup,"");
         		chgHeader();
             //} else {
            //	chgHeader();
            // }
			   	break;  	
					 			          
			   	
         default:
         }     
     }
     
    function openRPTFormPopUp(){
    	reportFormPopupCallCnt = 1; //ComOpenWindow2 아래 줄에서 현재 줄로 이동시킴..
    	var formObj = document.form;
        var param = "?col_desc="+document.form.f_header.value+"&call_cnt="+reportFormPopupCallCnt;
    	ComOpenWindow2('ESM_MAS_0059.do'+param, '', 'width=600, height=440, menubar=0, status=1, scrollbars=0, resizable=0');
    }
    

    /**
     * BackEndJob 호출함수 (Sheet1)
     */
    function getBackEndJobStatus() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        formObj.f_cmd.value = COMMAND01;
        var sXml = sheetObj.GetSearchXml("ESM_MAS_0060GS.do", masFormQueryString(formObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")

        if (jobState == "3") {
            if (formObj.f_excel.value == "Y") {    // File Download
                //-------------------------------
                // 비동기로 데이터 생성
                //-------------------------------
                formObj.f_cmd.value = COMMAND02;
                document.location.href = "ESM_MAS_0060DL.do?" + masFormQueryString(formObj);
                document.onreadystatechange = function() {
                    if (document.readyState == "interactive") {
                        ComOpenWait(false);
                    }
                }
                clearInterval(timer);
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
    
    function shprChk(obj){
        var formObj = document.form;

        if(obj == null){
            return;
        }
        
        if (formObj.txtShipper.value.length > 0) {
	        if((formObj.txtShipper.value.length != 8) || (formObj.txtShipper.value.length > 2 && !ComIsNumber((formObj.txtShipper.value).substring(2)))){
		    	ComShowMessage(ComGetMsg('MAS10009', 'Shipper', 'AA123456'));
		  	  	formObj.txtShipper.value = "";
		  	  	ComSetFocus(formObj.txtShipper);
		  	  	return;
	        }
        }
    }

//--------------------------------------------------------------------E
