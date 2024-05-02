/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0107.js
**@FileTitle : Daily Forecast Input(한국지점용)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2012.09.10 전상화
* 1.0 Creation
* 2012.09.10 전상화 [CHM-201220051-01] Daily FCST Input 개선 및 신규 Report 생성
* 2012.11.22 최윤성 [CHM-201221575-01] [SPC] 한국지점 Forecast Input 화면 Header 부분 로직 보완
* 2013.01.02 최윤성 [CHM-201322312-01] FCST Input(SELSC) 2차 수정요청
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - Sales Rep 조회 관련 수정 
* 2013.04.30 최윤성 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - otherFlg 추가 하여 othersToZero Function 수행 조건 변경 
* 2013.05.30 진마리아 SELCTA도 SELHO 기준으로 OFC 조회하도록
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.07.01 진마리아 Total TEU 컬럼은 상단 체크박스와 상관없이 TEU와 값이 다른 항차에 대해 모두 open
* 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
* 2013.08.02 진마리아 FEU로 입력시 Totla TEU(hidden) 값 핸들링 오류. RF, WT 값 존재시 control option과 무관하게 열리도록 수정
* 2013.08.08 진마리아 Daily Forecast, accum 팝업시 항차만 넣고 조회한 경우에 대한 오류 수정(trade 못가지고 가는..)
* 2013.11.14 진마리아 ALPS ERROR LOG 조치 - forecast 입력 자릿수 체크하지 않아서 저장할 때 자릿수 에러 발생
* 2013.11.22 진마리아 POL 컨트롤시 해당항차의 POD가 아닌 첫번째 POD에 Fcast 분배됨으로 인한 Fcast 저장 누락
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.07.27 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
* 2015.02.02 [CHM-201534072]FCST Input ACCT Adddel기능 편의 보완요청 
*            -->상단 SaleRep이 선택된경우 따로 시트의 SaleRep을 클릭하지 않아도 Acct.Add/Del기능을 사용할수 있도록 보완
* 2015.02.23 [CHM-201533936] Split13-사용자 표준환경 관련 - 버튼 공백대신 &nbsp;추가, combobox 처리
* 2015.03.04 [CHM-201534504] SMP IAS 보완에 따른 FCST 추가 개발 요청
* 2015.03.13 [CHM-201534835]Forecast Input POL별 Summary 데이터 추가 요청 + SaleRep 선택시 조회된 DATA 없어도 Acct.Add/Del 가능하도록 보완
* 2015.10.14 이혜민 선반영 Forecast 물량 수정시 Total계산 중복되던 것 수정
* 2016.03.28 이혜민 [CHM-201640572] F"cast input(loading) Duration 제한 관련 
* 2016.04.01 이혜민 [CHM-201640539] ALPS Live Out Of Memory Error 확인 및 조치 요청(Sales Rep이 몇 개의 Account를 체크했는지 개수 조회)
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
 * @class ESM_SPC_0102 : ESM_SPC_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0102() {
    this.processButtonClick = tprocessButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
}



/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var comObjects   = new Array();
var sheetCnt     = 0;
var comboCnt     = 0;
// sheetResizeFull = true;
// type check
var type_check;
// retrive check
var check_retrive = false;
var searchParams  = "";
var firFlg = "INIT";
var otherFlg = "Y";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var init_year        = '';
var init_week        = '';
var init_duration    = '1';
var init_salesOffice = '';
var init_subOffice   = '';
var init_salesRep    = '';

var sls_rhq_cd       = '';

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    var sheetObject = sheetObjects[0];
    
    /** **************************************************** */
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        
        switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;

        case "btn_new":         

            // 공통함수사용: 화면을 초기화
            sheetObject.RemoveAll();
            // resetAll();
            searchSalesRep = new Array();
            ComBtnDisable("btng_accum");
            ComBtnDisable("btng_addAccount2");
            ComBtnDisable("btng_acctMapping");
            ComBtnDisable("btng_dlyfcast");
            ComBtnDisable("btng_season_grp");
            firFlg = "INIT";
            formObject.year.value     = init_year;  
            formObject.week.value     = init_week;
            formObject.duration.value = init_duration;
            document.getElementById("salesOffice").Code2 = init_salesOffice;
            document.getElementById("subOffice").Code2   = init_subOffice;
            subOffice_OnChange(document.getElementById("subOffice"), init_subOffice, init_subOffice );          
            document.getElementById("salesRep").Code2    = init_salesRep;           
            SpcSearchOptionWeek("week", false, document.form.year.value);   
            SpcSearchOptionTrade("trade", true, true);
            SpcSearchOptionSubTrade("subtrade1");           
            SpcSearchOptionLane("rlane1", true, true);
            
            formObject.bound.selectedIndex = 0;
            formObject.ioc[0].checked      = true;
            formObject.vvd.value           = "";
            
            break;

        case "btn_save":
            
            // Data변화없이 Save버튼을 클릭한 경우 doActionIBSheet2로 처리한다.
            if (sheetObject.isDataModified == false)
                doActionIBSheet2(sheetObject, formObject, IBSAVE);
            else
                doActionIBSheet(sheetObject, formObject, IBSAVE);
            break;
            
        case "btn_downexcel":
            doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            break;

        case "btng_accum":
            accumGuidePfmc();
            break;
            
        case "btng_addAccount2":
            accountAddDelete();
            break;
            
        case "btng_acctMapping":
            doActionIBSheet(sheetObject, formObject, SEARCHLIST01);
            break;
            
        case "btng_dlyfcast":
            callDailyForecast();
            break;
            
        case "btng_season_grp":
            yieldGrpPopup();
            break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
    
    //[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    document.getElementById("trade").Enable = false;
    document.getElementById("subtrade1").Enable = false;
    
    SpcSearchOptionYear("year");
    SpcSearchOptionWeek("week");
    SpcSearchOptionDuration("duration", 5, 4);
    SpcSearchOptionTrade("trade", true, true);
    SpcSearchOptionSubTrade("subtrade1", true, false);

    //SpcSearchOptionLane("lane1", true, true);
    SpcSearchOptionBound("bound", false, true, false, true);
    
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    initDataSelection(0);

    var sheetResizeFull = true;
    document_onresize();

    var formObject = document.form;
    var comObj = document.getElementById("salesOffice");
    if (comObj.GetCount() <= 1) {
        comObj.Index = 0;
        var comObj1 = document.getElementById("subOffice");
        if (comObj.Code != comObj1.Code) {
            comObj1.Enable = false;
        }
    }

    ComBtnDisable("btng_addAccount2");
    ComBtnDisable("btng_acctMapping");
    ComBtnDisable("btng_accum");
    ComBtnDisable("btng_dlyfcast");
    
    var value   = "";
    var include = "";

    if (ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS" || ofc_cd == "SELCTA" || ofc_cd == "SELCMA") {
        value = "SELHO";
    } else if (ofc_cd == "SHARCS" || ofc_cd == "SHARCC" || ofc_cd == "SHARCO") {
        value = "SHARC";
    } else if (ofc_cd == "HAMRUS" || ofc_cd == "HAMRUC" || ofc_cd == "HAMRUO") {
        value = "HAMRU";
    } else if (ofc_cd == "NYCRAS" || ofc_cd == "NYCRAC" || ofc_cd == "NYCRAO") {
        value = "NYCRA";
    } else if (ofc_cd == "SINRSS" || ofc_cd == "SINRSO" || ofc_cd == "SINRSC") {
        value = "SHARC";
    } else if (ofc_cd == "JKTSC" || ofc_cd == "JKTBA") {
        value = "JKTBA";
    } else if (ofc_cd == "MNLSC" || ofc_cd == "MNLBA") {
        value = "MNLSC";
    } else if (ofc_cd == "PHXSA" || ofc_cd == "LGBSC") {
        value = "LGBSC";
    } else if (ofc_cd == "PKGSA" || ofc_cd == "PKGSC") {
        value = "PKGSC";
    } else if (ofc_cd == "SELSA" || ofc_cd == "SELSC") {
        value = "SELSC";
    } else if (ofc_cd == "SLCSC" || ofc_cd == "SEASC") {
        value = "SEASC";
    } else if ("HO|HQ|AQ|BB|BS|BA".indexOf(ofc_tp_cd) < 0) {
        value = ofc_cd;
    }

    var rtn = getCodeList("ChildOffice", "ofc_cd=" + value + "&level=4");
    initData_salesOffice(rtn[0].split("|"), rtn[1].split("|"));
        
    // 포커싱
    formObject.year.focus();

    init_year        = formObject.year.value; // 년 초기화용
    init_week        = formObject.week.value; // 주차 초기화용    
    init_duration    = '1';//formObject.duration.value; // duration 초기화용
    init_salesOffice = document.getElementById("salesOffice").Code;
    init_subOffice   = document.getElementById("subOffice").Code;
    init_salesRep    = document.getElementById("salesRep").Code;
    
    // add 2012.10.10.
//  formObject.year.value = 2013;
//  formObject.week.value = '30';
    formObject.duration.value = 1;
//  formObject.bound.value = 'W';
//  comObjects[0].Code = 'TPS';
//  comObjects[1].Code = 'AW';
//  comObjects[2].Code = 'AWTTP';
//  comObjects[3].Code = 'SELSC';
//  comObjects[4].Code = 'HKGSC';
//  comObjects[5].Code = 'CN011';
//  formObject.vvd.value = 'HNMI0072E';

    //[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    document.getElementById("trade").Enable = true;
    document.getElementById("subtrade1").Enable = true;

}

/**
 * id에 해당하는 Object를 show option에 따라 Display
 */
function showDataSelectionItem(id, show) {
    var objs = document.all[id];
    if(objs != null){
        for ( var i = 0; i < objs.length; i++) {
            objs[i].style.display = show ? "" : "none";
        }
    }
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;

    switch (sheetNo) {
    case 1: // sheet1 init      
        initSheet1(sheetObj, document.form.year.value
                + document.form.week.value + "|TTL", true);
        break;
    }
}

/**
 * sheet1에서 조회후 타이틀 변경
 */
var sheet1 = new Object();
function initSheet1(sheetObj, weeks, isInit) {
    var devMode = false; //개발시 hidden값 보이도록 처리
    if (isInit == undefined) {
        isInit = false;
    }

    with (sheetObj) {
        // 높이 설정
        // style.height = getSheetHeight(17);
        style.height = getSheetHeight(18);
        // 전체 너비 설정
        SheetWidth = mainTable.clientWidth;
        // Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        // 전체Merge 종류 [선택, Default msNone]
        MergeSheet = msPrevColumnMerge;
//      MergeSheet = msNone;
        // 전체Edit 허용 여부 [선택, Default false]
        var comObj = document.getElementById("salesOffice");
        // RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
        // 상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
        Editable = (comObj.GetCount() == 1);// || isDevMode || (ofc_cd == "SELCDO");
        //ScrollTrack  = false;
        //MassOfSearch = 1;
        // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        InitRowInfo(4, 1, 9, 100);

//      var HeadTitle1 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Sales Rep|Sales Rep|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|";
//      var HeadTitle2 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Account|Account|Account|Account|Account|Account|Account|Account|Account|Account|Account|Port|Port|";
//      var HeadTitle3 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Type|Yield Group|Guide|Code|Name|S/C No|RFA#|BkgYN|Bkg Cust|Bkg Nm|Chk Cust|POL|POD|";
        var HeadTitle1 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Sales Rep|Sales Rep|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|";
        var HeadTitle2 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Account|Account|Account|Account|Account|Account|Account|Account|Account|Account|Account|Account|Port|Port|";
        var HeadTitle3 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Type|Yield Group|IPI/Local|Guide|Code|Name|S/C No|RFA#|BkgYN|Bkg Cust|Bkg Nm|Chk Cust|POL|POD|";
        
        var HeadTitle4    = "||||||||";
        var HeadTitleInfo = "TRD|STRD|Lane|BD|V| V |D|IOC|SREP|USA|CUST|SEQ|POL|POD|OFC|CTP|CFM|CTRL|FCAST_SEQ|SC NO|FLG|RFA#|IB|";
        var HeadTail      = "Tree|Flag|ILane|IGrp|IRep|IUs|IUsA|IPol|SC_FLG";
        sheet1.masterColumnCount = HeadTitle1.split("|").length - 1;
        sheet1.forecastColumnCount = 13;// 5; //10->13 추가:d2,d4,rd (Total,Total TEU , TEU,FEU, d2, d4, hc, 45, 53, rf, rd, wt, remark)
        sheet1.bookingColumnCount  = 14;//11->14 추가:d2,d4,rd
        sheet1.infoColumnCount     = HeadTitleInfo.split("|").length - 1;
        
        var weekArr = weeks.split("|");
        sheet1.weekCount = weekArr.length;
        sheet1.tailColumnCount = HeadTail.split("|").length + 1;
        sheet1.itemColumnCount = sheet1.forecastColumnCount
                                + sheet1.bookingColumnCount
                                + sheet1.infoColumnCount;
        
        sheet1.columnCount = sheet1.masterColumnCount + sheet1.itemColumnCount
                * sheet1.weekCount + sheet1.tailColumnCount;
        
        sheet1.conformColorDif = sheet1.bookingColumnCount
                + sheet1.forecastColumnCount;

        // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        InitColumnInfo(sheet1.columnCount, sheet1.masterColumnCount + 1, 0, false);

        // 해더에서 처리할 수 있는 각종 기능을 설정한다
        InitHeadMode(false, true, true, true, false, false);
        
        //var teuType = document.form.ds2OTH.checked?"20|40|":"TEU|FEU|";
        var teuType = "TEU|FEU|";
        
        for ( var i = 0; i < sheet1.weekCount; i++) {
            for ( var j = 0; j < sheet1.infoColumnCount; j++) {
                HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
                HeadTitle2 = HeadTitle2 + "|";
                HeadTitle4 = HeadTitle4 + "|";
            }

            if(document.form.ds2FEU.checked)
                HeadTitle3 = HeadTitle3
                + HeadTitleInfo
                + "Total FEU|FEU|"
                + teuType
                + "D2|D4|HC|45|53'|RF|RD|WT|RMK|Total FEU|TEU|FEU|D2|D4|HC|45|53'|RF|RD|WT|CIF|FOB|OTH|";
            else 
                HeadTitle3 = HeadTitle3
                + HeadTitleInfo
                + "Total TEU|TEU|"
                + teuType
                + "D2|D4|HC|45|53'|RF|RD|WT|RMK|Total TEU|TEU|FEU|D2|D4|HC|45|53'|RF|RD|WT|CIF|FOB|OTH|";
            
            for ( var k = 0; k < sheet1.forecastColumnCount; k++) {
                HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
                HeadTitle2 = HeadTitle2 + "F'cast|";
                HeadTitle4 = HeadTitle4 + "|";
            }
            for ( var m = 0; m < sheet1.bookingColumnCount; m++) {
                HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
                HeadTitle2 = HeadTitle2 + "BKG|";
                HeadTitle4 = HeadTitle4 + "|";
            }
            
        }
        
        HeadTitle3 = HeadTitle3 + HeadTail;
        // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        InitHeadRow(0, HeadTitle1, true);
        InitHeadRow(1, HeadTitle2, true);
        InitHeadRow(2, HeadTitle3, true);
        InitHeadRow(3, HeadTitle4, true);

        var cnt = 0;
        // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
        // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
        // EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
        // FORMATFIX]
        InitDataProperty(0, cnt++, dtData, 45, daCenterTop, true, "d_trd_cd"    , false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 45, daCenterTop, true, "d_sub_trd_cd", false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "d_rlane_cd"  , false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 20, daCenterTop, true, "d_dir_cd"    , false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "d_ioc_ts_cd" , false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "d_rgn_ofc_cd", false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "d_sub_ofc_cd", false, "", dfNone, 0, false, false);
        
        InitDataProperty(0, cnt++, dtData, 50 , daCenterTop, true, "d_srep_usr_id"     ,    false, "", dfNone, 0, false, false);        
        InitDataProperty(0, cnt++, dtData, 100, daLeftTop  , true, "d_srep_usr_nm"     ,    false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 40 , daCenterTop, true, "d_fcast_cust_tp_cd",    false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 70 , daCenterTop, true, "d_acct_lvl"        ,    false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 70 , daCenterTop, true, "d_usa_bkg_mod_cd"        ,  false, "", dfNone, 0, false, false);//

        if(document.form.chkDs2FEU.checked){
            InitDataProperty(0, cnt++, dtData, 40 , daCenterTop, true, "d_guide"       ,    false, "", dfNullFloat, 1, false, false);
        }else{
            InitDataProperty(0, cnt++, dtData, 40 , daCenterTop, true, "d_guide"        ,   false, "", dfNone, 0, false, false);
        }
        InitDataProperty(0, cnt++, dtData, 60 , daCenterTop, true, "d_cust_cd"         ,    false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 100, daLeftTop  , true, "d_cust_nm"         ,    false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 70 , daCenter   , true, "d_sc_no"           ,    false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData, 80 , daCenter   , true, "d_rfa_no"          ,    false, "", dfNone, 0, false, false);
        
        // Add 2012.09.14.
        InitDataProperty(0, cnt++, dtHidden, 100, daLeftTop, true, "BkgYN"      ,   false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtHidden, 100, daLeftTop, true, "bkg_cust_cd",   false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtHidden, 100, daLeftTop, true, "bkg_cust_nm",   false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtHidden, 100, daLeftTop, true, "chk_cust_cd",   false, "", dfNone, 0, false, false);
                            
        InitDataProperty(0, cnt++, dtData,   60, daCenterTop, true, "d_pol_cd", false, "", dfNone, 0, false, false);
        InitDataProperty(0, cnt++, dtData,   60, daCenter,    true, "d_pod_cd", false, "", dfNone, 0, false, false);
        
        var calcuLogic1 = "";
        var calcuLogic2 = "";
        for ( var p = 1; p < sheet1.weekCount + 1; p++) {
            
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "trd_cd"    , false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "rlane_cd"  , false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "dir_cd"    , false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "vsl_cd"    , false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "skd_voy_no" , false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "skd_dir_cd" , false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "ioc_ts_cd"  , false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "srep_usr_id", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "usa_bkg_mod_cd", false, "", dfNone, 0, false, false);//
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "cust_cnt_cd", false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "cust_seq",   false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pol_cd"  ,   false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pod_cd"  ,   false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fcast_ofc_cd"    ,   false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fcast_cust_tp_cd",   false, "", dfNone, 0, false, false);            
            InitDataProperty(0, cnt++, devMode?dtData:dtHidden, 30, daCenter, false, "cfm_dt"          ,    false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ctrl_lvl_cd"     ,   false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "fcast_seq"       ,   false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "sc_no"           ,   false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "sc_flg"           ,  false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "rfa_no"          ,   false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, devMode?dtData:dtHidden, 30, daCenter, false, "ibflag"          ,    false, "", dfNone, 0, false, false);
            
            // 추가
            // |fcast_20ft_qty|+|fcast_40ft_qty*2|+|fcast_40ft_hc_qty*2|+|fcast_45ft_hc_qty*2|+|fcast_53ft_qty*2|
            if(document.form.chkDs2FEU.checked){
                calcuLogic1 = "|fcast_20ft_qty_"+p+"|/2+|fcast_40ft_qty_"+p+"|"+"|+|fcast_40ft_hc_qty_"+p+"|"+"|+|fcast_45ft_hc_qty_"+p+"|"+"|+|fcast_53ft_qty_"+p+"|";
                calcuLogic2 = "|fcast_20ft_qty_"+p+"|+|fcast_40ft_qty_"+p+"|*2";
                
                InitDataProperty(0, cnt++, dtData, 60, daRight, false, "fcast_ttl_teu_qty_"+p  ,    false, calcuLogic1, dfNullFloat, 1, false,  false);
                MinimumValue(0, cnt - 1) = 0;
                
                InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "fcast_ttl_qty_"+p      ,  false, calcuLogic2, dfNullFloat, 1, false, false);
                MinimumValue(0, cnt - 1) = 0;           
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_20ft_qty_"+p     ,    false, "", dfNullFloat, 1, false, false,4);     
                MinimumValue(0, cnt - 1) = 0;
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_40ft_qty_"+p     ,    false, "", dfNullFloat, 1, false, false,5);
                MinimumValue(0, cnt - 1) = 0;
                MaximumValue (0, cnt - 1) = "4999.5"; 
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_20ft_dry_qty_"+p  ,   false, "", dfNullInteger, 0, false, false,4);//
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_40ft_dry_qty_"+p  ,   false, "", dfNullInteger, 0, false, false,4);//
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_40ft_hc_qty_"+p  ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_45ft_hc_qty_"+p  ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_53ft_qty_"+p     ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_rf_qty_"+p       ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_rd_qty_"+p       ,    false, "", dfNullInteger, 0, false, false,4);//
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_ttl_wgt_"+p      ,    false, "", dfNullInteger, 0, false, false,5);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fcast_rmk_"+p    , false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daRight , false, "usd_bkg_ttl_qty_"+p    ,   false, "", dfNullFloat, 1, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_20ft_qty_"+p   ,   false, "", dfNullFloat, 1, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_40ft_qty_"+p   ,   false, "", dfNullInteger, 0, false, false);         
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_20ft_dry_qty_"+p,  false, "", dfNullInteger, 0, false, false);//
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_40ft_dry_qty_"+p,  false, "", dfNullInteger, 0, false, false);//
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_40ft_hc_qty_"+p,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_45ft_hc_qty_"+p,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_53ft_qty_"+p   ,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_rf_qty_"+p     ,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_rd_qty_"+p     ,   false, "", dfNullInteger, 0, false, false);//
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_ttl_wgt_"+p    ,   false, "", dfNullInteger, 0, false, false);
                
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cif_"+p, false, "", dfNullFloat, 1, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fob_"+p, false, "", dfNullFloat, 1, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "oth_"+p, false, "", dfNullFloat, 1, false, false);
                
            }else{
                calcuLogic1 = "|fcast_20ft_qty_"+p+"|+|fcast_40ft_qty_"+p+"|*2"+"|+|fcast_40ft_hc_qty_"+p+"|*2"+"|+|fcast_45ft_hc_qty_"+p+"|*2"+"|+|fcast_53ft_qty_"+p+"|*2";
                calcuLogic2 = "|fcast_20ft_qty_"+p+"|+|fcast_40ft_qty_"+p+"|*2";
                
                InitDataProperty(0, cnt++, dtData, 60, daRight, false, "fcast_ttl_teu_qty_"+p  ,    false, calcuLogic1, dfNullInteger, 0, false,    false);
                MinimumValue(0, cnt - 1) = 0; 
                
                InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "fcast_ttl_qty_"+p    ,    false, calcuLogic2, dfNullInteger, 0, false, false);
                MinimumValue(0, cnt - 1) = 0;           
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_20ft_qty_"+p     ,    false, "", dfNullInteger, 0, false, false,4);       
                MinimumValue(0, cnt - 1) = 0;
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_40ft_qty_"+p     ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_20ft_dry_qty_"+p  ,   false, "", dfNullInteger, 0, false, false,4);//
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_40ft_dry_qty_"+p  ,   false, "", dfNullInteger, 0, false, false,4);//             
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_40ft_hc_qty_"+p  ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_45ft_hc_qty_"+p  ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_53ft_qty_"+p     ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_rf_qty_"+p       ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_rd_qty_"+p       ,    false, "", dfNullInteger, 0, false, false,4);
                MinimumValue(0, cnt - 1) = 0;
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fcast_ttl_wgt_"+p      ,    false, "", dfNullInteger, 0, false, false,5);
                MinimumValue(0, cnt - 1) = 0;

                InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fcast_rmk_"+p          ,   false, "", dfNone       , 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daRight , false, "usd_bkg_ttl_qty_"+p    ,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_20ft_qty_"+p   ,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_40ft_qty_"+p   ,   false, "", dfNullInteger, 0, false, false);         
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_20ft_dry_qty_"+p,  false, "", dfNullInteger, 0, false, false);//
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_40ft_dry_qty_"+p,  false, "", dfNullInteger, 0, false, false);//
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_40ft_hc_qty_"+p,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_45ft_hc_qty_"+p,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_53ft_qty_"+p   ,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_rf_qty_"+p     ,   false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_rd_qty_"+p     ,   false, "", dfNullInteger, 0, false, false);//
                InitDataProperty(0, cnt++, dtData, 40, daRight , false, "usd_bkg_ttl_wgt_"+p    ,   false, "", dfNullInteger, 0, false, false);
                
                
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cif_"+p, false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "fob_"+p, false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daRight, false, "oth_"+p, false, "", dfNone, 0, false, false);
            }
            
        }

        InitDataProperty(0, cnt++, devMode?dtData:dtHidden , 150, daCenter, true, "treeLevel", false, "", dfNone       , 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtStatus:dtHiddenStatus, 50, daCenter, true, "editFlg"  , false, "", dfNone       , 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden      , 40, daRight,  true, "rowLane"  , false, "", dfNullInteger, 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden      , 40, daRight,  true, "rowGrp"   , false, "", dfNullInteger, 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden      , 40, daRight,  true, "rowRep"   , false, "", dfNullInteger, 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden      , 40, daRight,  true, "rowUs"   , false, "", dfNullInteger, 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden      , 40, daRight,  true, "rowUsA"   , false, "", dfNullInteger, 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden      , 40, daRight,  true, "rowPol"   , false, "", dfNullInteger, 0, false, false);
        InitDataProperty(0, cnt++, devMode?dtData:dtHidden, 70 , daCenter   , true, "d_sc_flg"           ,    false, "", dfNone, 0, false, false);
        
        HeadRowHeight = 10;
        
        InitTreeInfo(sheet1.columnCount - sheet1.tailColumnCount, "sLevel", RgbColor(0, 0, 255), false);
        EditableColor = RgbColor(255, 255, 128); // Default:255,255,255, 흰색
                                                    // Edit 가능 데이터 배경색
        UnEditableColor = RgbColor(255, 255, 255); // Default:239,235,239, 회색
                                                    // Edit 불가능 데이터 배경색
        EditableColorDiff = false;
        var backColor = RgbColor(222, 251, 248);
        
        RangeBackColor(1, 7, 2, sheet1.columnCount - sheet1.tailColumnCount) = backColor;
        RangeBackColor(2, sheet1.masterColumnCount, 2, sheet1.columnCount - sheet1.tailColumnCount) = RgbColor(202, 251, 220);
        RangeBackColor(3, 0, 3, sheet1.columnCount - 1) = getColor(0);
        RowHidden(3) = isInit;

    }
}

function toggleExpand(sheetObj, row, col) {
    var mark = sheetObj.CellValue(row, col);
    if (sheetObj.RowExpanded(row)) {
        sheetObj.RowExpanded(row) = false;
        ChangeValue2(sheetObj, row, col, "+");
    } else {
        sheetObj.RowExpanded(row) = true;
        ChangeValue2(sheetObj, row, col, "-");
    }
}

function initDataSelection(sheetNo) {
    
    if (sheetNo == 0) {
        changeDataSelection(document.getElementsByName("chkDs2LaneInfo")[0]);
        changeDataSelection(document.getElementsByName("chkDs2Office")[0]);
        changeDataSelection(document.getElementsByName("chkDs2USMode")[0]);//add
        changeDataSelection(document.getElementsByName("chkDs2Account")[0]);
        changeDataSelection(document.getElementsByName("chkDs2POD")[0]);
        changeDataSelection(document.getElementsByName("chkDs2RMK")[0]);
        changeDataSelection(document.getElementsByName("chkDs2MDL")[0]);
        changeDataSelection(document.getElementsByName("chkDs2ACCT")[0]);
        changeDataSelection(document.getElementsByName("chkDs2SC")[0]);
        changeDataSelection(document.getElementsByName("chkDs2RFA")[0]);
    }
}

function accountAddDelete() {
    var sheetObj = sheetObjects[0];
    var row      = sheetObj.SelectRow;
    var rcnt     = sheetObj.RowCount("R");
    var srep_id  = ComTrim(sheetObj.CellValue(row, "d_srep_usr_id"));
    var selectedCode = document.form.salesRep.Code;
//  var param2 = "";
    
    //조회조건에서 Sales Rep이 선택된 경우에는 첫번째 ROW를 찾아서 그 값을 넣어준다.
    if(srep_id == '' && selectedCode != '') {           
        row = sheetObj.FindText("d_srep_usr_id", selectedCode, 0);
        if(row>0) { //조회된 데이터 중 해당 USER가 있는경우
            srep_id  = ComTrim(sheetObj.CellValue(row, "d_srep_usr_id"));
        } else if(rcnt>0){//조회된 데이터가 있는 경우
            srep_id = selectedCode;
            row = sheetObj.LastRow;
            sheetObj.CellValue2(row, "d_trd_cd") = document.form.trade.Code;
            sheetObj.CellValue2(row, "d_sub_trd_cd") = document.form.subtrade1.Code;
            sheetObj.CellValue2(row, "d_rlane_cd") = document.form.rlane1.Code;
            sheetObj.CellValue2(row, "d_rgn_ofc_cd") = document.form.salesOffice.Code;
            sheetObj.CellValue2(row, "d_sub_ofc_cd") = document.form.subOffice.Code;
        } else if(rcnt==0) {//조회된 데이터가 없는 경우
            srep_id = selectedCode;
            row = 0;
        }
    }
    
    if (srep_id == "") {
        ComShowCodeMessage("COM12113", "Sales Rep");
        return;
    } else {
        var param = "srep_id="  + srep_id;
        if(row == 0) {
            param += "&trd_cd="     + document.form.trade.Code;
            param += "&rlane_cd="   + document.form.rlane1.Code; 
            param += "&sub_trd_cd=" + document.form.subtrade1.Code;     
            param += "&rgn_ofc_cd=" + document.form.salesOffice.Code;
            param += "&sub_ofc_cd=" + document.form.subOffice.Code;
        } else {
            param += "&srep_nm="    + sheetObj.CellValue(row, "d_srep_usr_nm");
            param += "&rlane_cd="   + sheetObj.CellValue(row, "d_rlane_cd");
            param += "&trd_cd="     + sheetObj.CellValue(row, "d_trd_cd");
            param += "&sub_trd_cd=" + sheetObj.CellValue(row, "d_sub_trd_cd");
            param += "&bound="      + sheetObj.CellValue(row, "d_dir_cd");
            param += "&rgn_ofc_cd=" + sheetObj.CellValue(row, "d_rgn_ofc_cd");
            param += "&sub_ofc_cd=" + sheetObj.CellValue(row, "d_sub_ofc_cd");
            param += "&ioc_cd="     + sheetObj.CellValue(row, "d_ioc_ts_cd");
            param += "&acc_tp="     + sheetObj.CellValue(row, "d_fcast_cust_tp_cd");
        }

        param += "&cost_yrwk="  + document.form.year.value + document.form.week.value;
        
        var rtn = window
                .showModalDialog(
                        "ESM_SPC_0106.do?" + param,
                        null,
                        "dialogHeight:580px;dialogWidth:1150px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
        if (rtn == "OK") {
            var formObject = document.form;
            doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        }
    }

}

function accumGuidePfmc() {
    var formObj = document.form;
    
    var trade = comObjects[0].Code;
    if(trade==""){
        if(sheetObjects[0].SearchRows>0){
            trade = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "d_trd_cd");
        }else{
            ComShowMessage(getMsg("SPC90117", "Trade"));
            return;
        }
    }
    var param = "year="             + formObj.year.value;
    param = param + "&week="        + formObj.week.value;
    param = param + "&trade="       + trade;
    param = param + "&salesOffice=" + comObjects[3].Code;
    
    ComOpenWindow("ESM_SPC_0108.do?" + param, "Accumulated Guide PFMC", "height=550,width=800,status=0");
}

function changeDataSelection(tobj, internal) {
    var formObj = document.form;
    
    if (internal == undefined || internal == null) {
        internal == false;
    }
    
    var sheetObj = sheetObjects[0];
    var obj = null;
    if (tobj == undefined || tobj == null) {
        tobj = null;
        obj = event.srcElement;
    } else {
        obj = tobj;
    }
    
    var sts = obj.checked;
    
    /*
     * 1-,0:20/40 1:HC 2:45 3:53 4:RF 5:WG
     */
    switch (obj.name) {

    case "chkDs2LaneInfo":
        sheetObj.ColHidden("d_trd_cd")     = !sts;
        sheetObj.ColHidden("d_sub_trd_cd") = !sts;
        sheetObj.ColHidden("d_dir_cd")     = !sts;
        sheetObj.ColHidden("d_ioc_ts_cd")  = !sts;
        break;

    case "chkDs2Office":
        sheetObj.ColHidden("d_rgn_ofc_cd") = !sts;
        sheetObj.ColHidden("d_sub_ofc_cd") = !sts;
        break;
        
    //add   
    case "chkDs2USMode":
        sheetObj.ColHidden("d_usa_bkg_mod_cd") = !sts;
        var acct = document.form.chkDs2ACCT.checked;
        var pd = document.form.chkDs2POD.checked;
        //레벨변경
        if(sts) {//펼때
            if(!acct && !pd) {
                sheetObj.ShowTreeLevel(4, 0);
                sheetObj.ColHidden("d_usa_bkg_mod_cd") = false;
            }
        } else {//접을때
            if(pd || acct) {
                sheetObj.ColHidden("d_usa_bkg_mod_cd") = true;
            } else if(!acct && pd) {
                sheetObj.ColHidden("d_usa_bkg_mod_cd") = true;
            } else if(!pd && acct) {
                sheetObj.ColHidden("d_usa_bkg_mod_cd") = true;
            } else {
                sheetObj.ColHidden("d_usa_bkg_mod_cd") = true;
                sheetObj.ShowTreeLevel(3, 1);
            }
        }
        break;

    case "chkDs2Account":
//      sheetObj.ShowTreeLevel(sts ? 5 : 4, 0);//POD 레벨 변경됨
        sheetObj.ShowTreeLevel(sts ? 6 : 5, 0);
        var mdl  = document.form.chkDs2MDL.checked;
        var acct = document.form.chkDs2ACCT.checked;
        var sc   = document.form.chkDs2SC.checked;
        var rfa  = document.form.chkDs2RFA.checked;
        
        sheetObj.ColHidden("d_fcast_cust_tp_cd") = !(sts && !acct);
        sheetObj.ColHidden("d_acct_lvl")         = !(sts && acct);
        sheetObj.ColHidden("d_guide")            = !(sts && mdl);
        
        sheetObj.ColHidden("d_cust_cd")          = !sts;
        sheetObj.ColHidden("d_cust_nm")          = !sts;
        sheetObj.ColHidden("d_sc_no")            = !(sts && sc);
        sheetObj.ColHidden("d_rfa_no")           = !(sts && rfa);
        sheetObj.ColHidden("d_pol_cd")           = !sts;

        if(sts && mdl){
            ComBtnEnable("btng_season_grp");
        }else{
            ComBtnDisable("btng_season_grp");
        }
        if (!sts) {
            document.all.ds2POD.checked = false;
            changeDataSelection(document.all.ds2POD, true);
        }
        break;

    case "chkDs2POD":
        if (!internal) {
            if (!document.all.ds2Account.checked) {
                document.all.ds2Account.checked = true;
                changeDataSelection(document.all.ds2Account);
            }
            
//          sheetObj.ShowTreeLevel(sts ? 5 : 4, 0);//POD 레벨 변경됨
            sheetObj.ShowTreeLevel(sts ? 6 : 5, 1);
        }

        sheetObj.ColHidden("d_pod_cd") = !sts;
        
        
        ChangeValues2(sheetObj, "d_pod_cd", "+", "d_pod_cd", "-");
        
        setBkgCust( );
        
        /*
        if (sts) {
        ChangeValues2(sheetObj, "d_pod_cd", "+", "d_pod_cd", "-");
        }
        ChangeValues2(sheetObj, "d_pol_cd", "+", "d_pol_cd", "-");
        */
        
        break;
    
    case "chkDs2TEU":
        var feu = formObj.chkDs2FEU;
        var oth = formObj.chkDs2OTH;
        
        if(!feu.checked && !oth.checked) {
            obj.checked = true;
        } else {
            feu.checked = false;
            oth.checked = false;
            formObj.view_type.value = "TEU";
            
            if(searchParams != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }
        break;
        
    case "chkDs2FEU":
        var teu = formObj.chkDs2TEU;
        var oth = formObj.chkDs2OTH;
        
        if(!teu.checked && !oth.checked) {
            obj.checked = true;
        } else {
            teu.checked = false;
            oth.checked = false;
            formObj.view_type.value = "FEU";
            
            if(searchParams != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }
        break;
    
    case "chkDs2OTH":
        var teu = formObj.chkDs2TEU;
        var feu = formObj.chkDs2FEU;
        
        if(!teu.checked && !feu.checked) {
            obj.checked = true;
        } else {
            teu.checked = false;
            feu.checked = false;
            formObj.view_type.value = "BOTH";
            
            if(searchParams != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }
        break;
        
    case "chkDs2D2"://
    case "chkDs2D4"://
    case "chkDs2HC":
    case "chkDs245":
    case "chkDs253":
    case "chkDs2RF":
    case "chkDs2RD"://
    case "chkDs2WT":
    case "chkDs2RMK":
    case "chkDs2CIF":
        hiddenTypeSize(sheetObj);
        break;

    case "chkDs2BKG":
        if( !sts )
            document.form.chkDs2CIF.checked = sts;
        
        hiddenTypeSize(sheetObj);
        break;
        
    case "chkDs2MDL":
        for ( var i = 0; i < sheet1.weekCount; i++) {
            var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i
            + sheet1.infoColumnCount + sheet1.forecastColumnCount;

            sheetObj.ColHidden("d_guide") = !sts;
        }
        break;
        
    case "chkDs2ACCT":
        for ( var i = 0; i < sheet1.weekCount; i++) {
            var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i
            + sheet1.infoColumnCount + sheet1.forecastColumnCount;
            
            sheetObj.ColHidden("d_acct_lvl") = !sts;
            sheetObj.ColHidden("d_fcast_cust_tp_cd") = sts;
        }
        break;
        
    case "chkDs2SC":
        for ( var i = 0; i < sheet1.weekCount; i++) {
            var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i
            + sheet1.infoColumnCount + sheet1.forecastColumnCount;
            
            sheetObj.ColHidden("d_sc_no") = !sts;
        }
        break;
        
    case "chkDs2RFA":
        for ( var i = 0; i < sheet1.weekCount; i++) {
            var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i
            + sheet1.infoColumnCount + sheet1.forecastColumnCount;
            
            sheetObj.ColHidden("d_rfa_no") = !sts;
        }
        break;

    case "chkDs2INF":
//      for ( var i = 0; i < sheet1.weekCount; i++) {
//          var sCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i
//                  + sheet1.infoColumnCount;
//          sheetObj.ColHidden(sCol - 1 ) = !sts;
//          sheetObj.ColHidden(sCol - 2 ) = !sts;
//          sheetObj.ColHidden(sCol - 4 ) = !sts;
//          sheetObj.ColHidden(sCol - 12) = !sts;
//          sheetObj.ColHidden(sCol - 13) = !sts;
//          sheetObj.ColHidden(sCol - 14) = !sts;
//      }
        break;
    }

}

function hiddenTypeSize(sheetObj) {
    var stsTeu = document.getElementsByName("chkDs2TEU")[0].checked;
    var stsFeu = document.getElementsByName("chkDs2FEU")[0].checked;
    var stsOth = document.getElementsByName("chkDs2OTH")[0].checked;
    var stsD2  = document.getElementsByName("chkDs2D2")[0].checked;//추가
    var stsD4  = document.getElementsByName("chkDs2D4")[0].checked;//추가
    var stsHC  = document.getElementsByName("chkDs2HC")[0].checked;
    var sts45  = document.getElementsByName("chkDs245")[0].checked;
    var sts53  = document.getElementsByName("chkDs253")[0].checked;
    var stsRf  = document.getElementsByName("chkDs2RF")[0].checked;
    var stsRd  = document.getElementsByName("chkDs2RD")[0].checked;//추가
    var stsWt  = document.getElementsByName("chkDs2WT")[0].checked;
    var stsRmk = document.getElementsByName("chkDs2RMK")[0].checked;
    var stsBkg = document.getElementsByName("chkDs2BKG")[0].checked;
    var stsCif = document.getElementsByName("chkDs2CIF")[0].checked;
    
    for ( var i = 1; i < sheet1.weekCount + 1; i++) {
        sheetObj.ColHidden("fcast_ttl_teu_qty_"  + i) = !(stsOth||stsHC||sts45||sts53||stsRf);
        sheetObj.ColHidden("fcast_20ft_qty_"     + i) = !(stsTeu||stsOth);
        sheetObj.ColHidden("fcast_40ft_qty_"     + i) = !(stsFeu||stsOth);
        sheetObj.ColHidden("fcast_20ft_dry_qty_"  + i) = !stsD2;//추가
        sheetObj.ColHidden("fcast_40ft_dry_qty_"  + i) = !stsD4;//추가
        sheetObj.ColHidden("fcast_40ft_hc_qty_"  + i) = !stsHC;
        sheetObj.ColHidden("fcast_45ft_hc_qty_"  + i) = !sts45;
        sheetObj.ColHidden("fcast_53ft_qty_"     + i) = !sts53;
        sheetObj.ColHidden("fcast_rf_qty_"       + i) = !stsRf;
        sheetObj.ColHidden("fcast_rd_qty_"       + i) = !stsRd;//추가
        sheetObj.ColHidden("fcast_ttl_wgt_"      + i) = !stsWt;
        sheetObj.ColHidden("fcast_rmk_"          + i) = !stsRmk;
        
        sheetObj.ColHidden("usd_bkg_ttl_qty_"     + i) = !stsBkg;
        sheetObj.ColHidden("usd_bkg_20ft_qty_"    + i) = !(stsBkg && (stsOth||stsHC||sts45||sts53||stsRf));
        sheetObj.ColHidden("usd_bkg_40ft_qty_"    + i) = !(stsBkg && (stsOth||stsHC||sts45||sts53||stsRf));
        sheetObj.ColHidden("usd_bkg_20ft_dry_qty_" + i) = !(stsBkg && stsD2);//추가
        sheetObj.ColHidden("usd_bkg_40ft_dry_qty_" + i) = !(stsBkg && stsD4);//추가
        sheetObj.ColHidden("usd_bkg_40ft_hc_qty_" + i) = !(stsBkg && stsHC);
        sheetObj.ColHidden("usd_bkg_45ft_hc_qty_" + i) = !(stsBkg && sts45);
        sheetObj.ColHidden("usd_bkg_53ft_qty_"    + i) = !(stsBkg && sts53);
        sheetObj.ColHidden("usd_bkg_rf_qty_"      + i) = !(stsBkg && stsRf);
        sheetObj.ColHidden("usd_bkg_rd_qty_"      + i) = !(stsBkg && stsRd);//추가
        sheetObj.ColHidden("usd_bkg_ttl_wgt_"     + i) = !(stsBkg && stsWt);
        
        sheetObj.ColHidden("cif_"                 + i) = !stsCif;
        sheetObj.ColHidden("fob_"                 + i) = !stsCif;
        sheetObj.ColHidden("oth_"                 + i) = !stsCif;
    }
    
}

// Status를 바꾸지 않고 컬럼의 값이 val인 컬럼의 값을 sVal로 변경한다.
function ChangeValues2(sheetObj, col, val, sCol, sVal) {
    with (sheetObj) {
        var frow = -1;

        while ((frow = FindText(col, val, frow + 1)) >= 0) {
            var status = sheetObj.RowStatus(frow);
            CellValue2(frow, sCol) = sVal;
            sheetObj.RowStatus(frow) = status;
        }
    }
}

// CellValue2로 데이터 값을 변경한다.
function ChangeValue2(sheetObj, row, col, val) {
    with (sheetObj) {
        var status = RowStatus(row);
        CellValue2(row, col) = val;
        RowStatus(row) = status;
    }
}

// CellValue로 데이터 값을 변경한다.
function ChangeValue(sheetObj, row, col, val) {
    with (sheetObj) {
        var status = RowStatus(row);
        CellValue(row, col) = val;
        RowStatus(row) = status;
    }
}

function AddValue2(sheetObj, row, col1, col2, val) {
    // var totalTeuCol = 0;
    // var totalTeuValue = 0;
    if (col1 != null) {
        var old_color = sheetObj.CellFontColor(row, col1);
        ChangeValue2(sheetObj, row, col1, val + sheetObj.CellValue(row, col1) * 1);
        sheetObj.CellFontColor(row, col1) = old_color;
        compareConfirmValue(sheetObj, row, col1);
    }

    if (col2 != null) {
        var old_color = sheetObj.CellFontColor(row, col2);
        ChangeValue2(sheetObj, row, col2, val + sheetObj.CellValue(row, col2) * 1);
        sheetObj.CellFontColor(row, col2) = old_color;
        compareConfirmValue(sheetObj, row, col2);
    }
}

function compareConfirmValue(sheetObj, row, col) {
    var val1 = sheetObj.CellValue(row, col) * 1;
    var val2 = sheetObj.CellValue(row, col + sheet1.conformColorDif) * 1;

    if (sheetObj.CellFontColor(row, col) == 255) {
        return;
    }

    sheetObj.CellFontColor(row, col) = (val1 == val2) ? sheetObj.RgbColor(0, 0,
            255) : sheetObj.DataFontColor;
}

function AddValue(sheetObj, row, col, val) {
    ChangeValue(sheetObj, row, col, val + sheetObj.CellValue(row, col) * 1);
}

var searchSalesRep = new Array();
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, quite) {
    if (quite == undefined)
        quite = false;
    sheetObj.ShowDebugMsg = false;

    switch (sAction) {
    case IBSEARCH: // 조회
        var sheetObj = sheetObjects[0];
        if (!validateForm(sheetObj, formObj, sAction)) {
            return false;
        }

        var param = "year="          + formObj.year.value;
        param = param + "&week="     + formObj.week.value;
        param = param + "&duration=" + formObj.duration.value;
        param = param + "&trade="    + comObjects[0].Code;
        param = param + "&subtrade=" + comObjects[1].Code;
        param = param + "&lane="     + comObjects[2].Code;
        param = param + "&bound="    + formObj.bound.value;
        param = param
                + "&ioc="
                + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value
                        : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value
                                : formObj.id_chk_ts.value));
        param = param + "&salesOffice=" + comObjects[3].Code;
        param = param + "&subOffice="   + comObjects[4].Code;
        param = param + "&salesRep="    + comObjects[5].Code;
        param = param + "&vvd="         + formObj.vvd.value;
        param = param + "&view_type="   + formObj.view_type.value;
        
        searchParams = param;
        var rtn = sheetObj.GetSearchXml("ESM_SPC_0102GS.do", "f_cmd="
                + (SEARCHLIST01) + "&" + param);
        
        var etcData = getEtcData(rtn);
        
        if (etcData["status"] == undefined || etcData["status"] != "OK"
                || etcData["week"] == undefined) {
            ComShowMessage("Error occurred. Try again");
            return;
        }
        
        formObj.chkDs2POD.checked = (etcData["ctrlLvl"] == "Y")?true:false;
        //2014.08.13 추가
        destLvl = etcData["destLvl"];
        destLocTp = etcData["destLocTp"];
        usModFlg = etcData["usModFlg"];
        
        formObj.chkDs2USMode.checked = (usModFlg == "Y")?true:false;
        
        
        if(formObj.id_chk_ipc.checked||formObj.id_chk_ts.checked) {
            formObj.chkDs2POD.checked = true;
        }
        
        sheetObj.Reset();
        
        initSheet1(sheetObj, etcData["week"].substring(1));
        
        var hh_flg = etcData["hhFlg"].split("|");
        if(hh_flg == "Y")
            document.all.chkDs2MDL.checked = true;
        else
            document.all.chkDs2MDL.checked = false;
        var ctrl_flg = etcData["ctrlAcct"].split("|");
        if(ctrl_flg == "Y")
            document.all.chkDs2ACCT.checked = true;
        else
            document.all.chkDs2ACCT.checked = false;
        
        sls_rhq_cd = etcData["slsRhqCd"].split("|");
        
        sheetObj.LoadSearchXml(rtn);
        
        sheet1_OnScroll(sheetObj, 0, 0, sheetObj.HeaderRows, 0, true);
        
//      initDataSelection(0);
        
        if(sheetObj.SearchRows>0){
            ComBtnEnable("btng_accum");
            ComBtnEnable("btng_addAccount2");
            ComBtnEnable("btng_acctMapping");
            ComBtnEnable("btng_dlyfcast");
        }
        var comObj = document.getElementById("trade");
        var trd_cd = comObj.Code;

        searchSalesRep[0] = document.getElementById("salesRep").Code;

        // Data변경없이 Save처리를 위해 조회시 폼값이 세팅되도록 추가
        formObj.vvdList.value = etcData["vvd"].replace('|TTL', '');
        formObj.salesRepCodeList.value = etcData["salesRepCodeList"];

        // VVD별 Control Option에 따라 컬럼 세팅해주기 위해 추가===============================
        // sheet에 대한 조회가 끝나면 VVD별로 Control Option에 따라 Column을 Hidden한다.
        // 컬럼을 돌면서, 해당 CELL이 Editable한 경우 해당 컬럼을 보이게한다.
        var isEditCol;
        var cn;
        var j = 0;
        var ctrlopt = etcData["ctrlopt"].split("|");
                                           
        for( var i = 1; i < ctrlopt.length; i+=8) {
            j++;
            sheetObj.ColHidden("fcast_20ft_dry_qty_"   + j) = (ctrlopt[i]   == "true" || formObj.chkDs2D2.checked) ? false : true;
            sheetObj.ColHidden("fcast_40ft_dry_qty_"   + j) = (ctrlopt[i+1]   == "true" || formObj.chkDs2D4.checked) ? false : true;
            sheetObj.ColHidden("fcast_40ft_hc_qty_"   + j) = (ctrlopt[i+2]   == "true" || formObj.chkDs2HC.checked) ? false : true;
            sheetObj.ColHidden("fcast_45ft_hc_qty_"   + j) = (ctrlopt[i+3] == "true" || formObj.chkDs245.checked) ? false : true;
            sheetObj.ColHidden("fcast_53ft_qty_"      + j) = (ctrlopt[i+4] == "true" || formObj.chkDs253.checked) ? false : true;
            sheetObj.ColHidden("fcast_rf_qty_"        + j) = (ctrlopt[i+5] == "true" || formObj.chkDs2RF.checked) ? false : true;
            sheetObj.ColHidden("fcast_rd_qty_"        + j) = (ctrlopt[i+6] == "true" || formObj.chkDs2RD.checked) ? false : true;
            sheetObj.ColHidden("fcast_ttl_wgt_"       + j) = (ctrlopt[i+7] == "true" || formObj.chkDs2WT.checked) ? false : true;
            
            sheetObj.ColHidden("usd_bkg_20ft_dry_qty_" + j) = (ctrlopt[i]   == "true" || formObj.chkDs2D2.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_40ft_dry_qty_" + j) = (ctrlopt[i+1]   == "true" || formObj.chkDs2D4.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_40ft_hc_qty_" + j) = (ctrlopt[i+2]   == "true" || formObj.chkDs2HC.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_45ft_hc_qty_" + j) = (ctrlopt[i+3] == "true" || formObj.chkDs245.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_53ft_qty_"    + j) = (ctrlopt[i+4] == "true" || formObj.chkDs253.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_rf_qty_"      + j) = (ctrlopt[i+5] == "true" || formObj.chkDs2RF.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_rd_qty_"      + j) = (ctrlopt[i+6] == "true" || formObj.chkDs2RD.checked) ? false : true;
            sheetObj.ColHidden("usd_bkg_ttl_wgt_"     + j) = (ctrlopt[i+7] == "true" || formObj.chkDs2WT.checked) ? false : true;
            
            //Control Option 및 화면의 Data Selection과 상관없이 Total TEU 가 TEU와 값이 다르면, Total TEU를 보여주도록 수정
            //rf, wt 값이 존재하면- 무조건 열어줘
            for( var rnum = sheetObj.HeaderRows; rnum < sheetObj.HeaderRows + sheetObj.RowCount; rnum++){
                if(sheetObj.CellValue(rnum, "d_cust_nm") == "TOTAL"){
                    if(Number(sheetObj.CellValue(rnum, "fcast_ttl_teu_qty_"+j)) != Number(sheetObj.CellValue(rnum, "fcast_ttl_qty_"+j))){
                        sheetObj.ColHidden("fcast_ttl_teu_qty_" + j) = false;
                    }
                    if(Number(sheetObj.CellValue(rnum, "fcast_rf_qty_"+j)) > 0){
                        sheetObj.ColHidden("fcast_rf_qty_" + j) = false;
                    }
                    if(Number(sheetObj.CellValue(rnum, "fcast_ttl_wgt_"+j)) > 0){
                        sheetObj.ColHidden("fcast_ttl_wgt_" + j) = false;
                    }
                    break;
                }
            }
        }
        
        if (sheetObj.RowCount > 0  ) {
            // add 2010.10.10
            checkCustByLogInUser();
            // add 2012.09.14.
            setBkgCust();
            
            // 화주 담당 S.REP이 신규로 등록된 경우 전임자 선택할 수 있는 팝업 호출([ESM_SPC_0110] Forecast Succession)
//          var newAcctFlg = etcData["newAcct"].split("|");
//          if(newAcctFlg[0] == "Y" && comObjects[5].Code != ""){
//              var sheetObj = sheetObjects[0];
//              var srep_id  = comObjects[5].Code;
//              
//              var param = "srep_cd="  + srep_id;
//              param = param + "&srep_nm="    + newAcctFlg[1];
//              param = param + "&trd_cd="     + comObjects[0].Code;
//              param = param + "&sub_trd_cd=" + comObjects[1].Code;
//              param = param + "&rlane_cd="   + comObjects[2].Code;
//              param = param + "&dir_cd="     + formObj.bound.value;
//              param = param
//                      + "&ioc_ts_cd="
//                      + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value
//                              : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value
//                                      : formObj.id_chk_ts.value));
//              param += "&ofc_cd="     + newAcctFlg[2];
//              param += "&sub_ofc_cd=" + newAcctFlg[3];
//              
//              var rtn = window.showModalDialog("ESM_SPC_0110.do?" + param,null,"dialogHeight:430px;dialogWidth:580px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
//              
//              if (rtn == "OK") {
//                  var formObject = document.form;
//                  doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
//              }
//          }
        }
        
        // ===============================================================================
        break;

    case IBSAVE: // 저장
        if (!validateForm(sheetObj, formObj, sAction)) {
            return false;
        }
        
        var uList = sheetObj.FindStatusRow("U");
        var uArr  = uList.split(";");
        var sheetInfo = sheet1;
        
        uList = sheetObj.FindStatusRow("U");
        uArr = uList.split(";");
        
        var param = "f_cmd=" + MULTI01
                  + "&week_count=" + sheetInfo.weekCount
                  + "&view_type="  + formObj.view_type.value;
        
        var rtn = doSaveSheet(sheetObj, "ESM_SPC_0102GS.do", param, null, !quite);
        if (rtn == "OK") {
            for ( var i = 0; i < uArr.length; i++) {
                var row = uArr[i] * 1;
                var lvl = sheetObj.CellValue(row, "treeLevel") * 1;
                for ( var c = 0; c < sheetInfo.weekCount; c++) {
                    var col = sheetInfo.masterColumnCount
                            + sheetInfo.itemColumnCount * c
                            + sheetInfo.infoColumnCount - 1;

                    if (sheetObj.CellValue(row, col) == "U"
                            || sheetObj.CellValue(row, col) == "I") {
                        if (sheetObj.CellValue(row, col - 4) == "C") {
                            sheetObj.CellValue2(row, col - 4) = "";
                        }
                        if (lvl == 5) {
                            sheetObj.CellValue2(row, col) = "R";
                        } else {
                            sheetObj.CellValue2(row, col) = "";
                        }
                        sheetObj.RowStatus(row) = "R";
                    }
                }
            }
        }
        
        break;

    case IBDOWNEXCEL: // 엑셀 다운로드
        sheetObj.Down2Excel(-1, false, false, true);
        break;
        
    case SEARCHLIST01:  // Account Mapping 팝업 호출
        var param = "&trade=" + comObjects[0].Code;
        param += "&sls_ofc_cd=" + comObjects[3].Code;
        param += "&cost_yrwk=" + document.form.year.value + document.form.week.value;
        
        var rtn = window
                .showModalDialog(
                        "ESM_SPC_0112.do?" + param,
                        null,
                        "dialogHeight:570px;dialogWidth:990px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
        if (rtn == "OK") {
            var formObject = document.form;
            if(searchParams != "") doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        }
        break;
    }
}

// Sheet관련 프로세스 처리, Data변경없이 Save한 경우
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;

    switch (sAction) {
    case IBSAVE: // Data변화없이 SAVE
        if (!validateForm(sheetObj, formObj, IBSEARCH)) { // IBSEARCH와 동일한
                                                            // 조건으로 입력폼값 제한
            return false;
        }

        if (formObj.salesRepCodeList.value != '') { // isEditable한 salesRep이 있는
                                                    // 경우
            // Data변화 없이도 저장 할 것인지
            if (ComShowConfirm('There is no data to changed\nPlease click "Yes" if you\'d like to continue') == 0)
                return false;

            var param = "salesRepCodeList=" + formObj.salesRepCodeList.value;
            param = param + "&vvdList=" + formObj.vvdList.value;
            param = param
                    + "&ioc="
                    + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value
                            : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value
                                    : formObj.id_chk_ts.value));

            // sheetObj.DoAllSave("ESM_SPC_0102GS.do", "f_cmd=" + MULTI03 + "&"
            // + FormQueryString(formObj));
            sheetObj.DoAllSave("ESM_SPC_0102GS.do", "f_cmd=" + MULTI03 + "&"
                    + param);
            // DoAllSave의 return값 true/false
        } else { // isEditable한 salesRep이 없는 경우
            ComShowMessage("There is no data to save");
        }
        break;
    }
}

/*
 * 저장후 호출
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
    if (sheetObj.EtcData("status") == "OK") {
        ComShowMessage("saved successfully.");
    } else if (sheetObj.EtcData("status") != "OK") {
        ComShowMessage(errMsg);
    }
}

function sheet1_OnScroll(sheetObj, oldTopRow, oldLeftCol, newTopRow,
        newLeftCol, isInit) { 
    
    if (isInit == undefined) {
        isInit = false;
    }
    
    var baseCol = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1);
    
    if ((sheetObj.CellValue(newTopRow, baseCol + 4) == ("" || undefined))) {
        return;
    }
    
    sheetObj.RowHidden(3) = (sheetObj.CellValue(newTopRow, baseCol + 4) == "");

    for ( var i = 0; i < sheet1.weekCount; i++) {
        var baseCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i;
        var vvd = sheetObj.CellValue(newTopRow, baseCol + 4)
                + sheetObj.CellValue(newTopRow, baseCol + 5)
                + sheetObj.CellValue(newTopRow, baseCol + 6);
        
        // 2012.11.22 최윤성 [CHM-201221575-01] [SPC] 한국지점 Forecast Input 화면 Header 부분 로직 보완 
        if (vvd == "000") { // 빠지는 주차 처리용 ViewAdapter 에서 000 으로 넘어옴
            // Hidden 되어진 Lane 정보를 가져옴.
            // Yard 만 비는 경우 Lane 에 VVD 정보 가지고 있고 한 주차가 비는 경우 공백이 들어있음.
            vvd = sheetObj.CellValue(newTopRow, baseCol + 2);
            
            if(vvd == null || vvd == "") vvd = " ";
        }

        if (sheetObj.CellValue(3, baseCol + sheet1.infoColumnCount) == vvd) {
            continue;
        }

        for ( var c = sheet1.infoColumnCount; c < sheet1.itemColumnCount; c++) {
            sheetObj.CellValue2(3, baseCol + c) = vvd;
        }
    }
}

var selectedCell_OldValue    = 0;
function sheet1_OnSelectCell(sheetObj, orow, ocol, row, col) {
    selectedCell_OldValue = sheetObj.CellValue(row, col) * 1;
}

// Search End - Data Select 체크에 맞게 항목 숨김처리
function sheet1_OnSearchEnd(sheetObj, errMsg){
    // SC / RFA column 열고닫기
    if(document.form.trade.Code==""){
        if(sheetObj.SearchRows>0){
            var tmpTrade =sheetObj.CellValue(sheetObj.HeaderRows, "d_trd_cd");
            if(tmpTrade=="TPS"){
                document.all.chkDs2SC.checked = true;
            } else if(tmpTrade=="AES" || tmpTrade=="IAS"){//IAS SMP 변경에 따른 보완 Requirement
                document.all.chkDs2RFA.checked = true;
            }
        }
    }
    initDataSelection(0);
    hiddenZeroUsModeRows(sheetObj);
    
    if(document.form.salesRep.Code != ''){
        ComBtnEnable("btng_addAccount2");
    }
}

/**
 * VVD Click 시 VVD SKD Inquiry 팝업 호출
 */
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
    var vvd = "";
    var dir = "";
    var col_name = "";
    
    if(sheetObj.MouseRow > 0){
        vvd = sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol);
        dir = vvd.substr(vvd.length-1);
        col_name = sheetObj.ColSaveName(sheetObj.MouseCol);
        
        if ( vvd.length == 9 && (dir == "E" || dir ==  "W" || dir == "N" || dir ==  "S") && col_name != "d_srep_usr_nm" ) {
            var url   = "ESM_SPC_0071.do?&vvd=" + vvd;
            window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px");
        }
    }
}

function sheet1_OnChange(sheetObj, row, col, value) {
    var orgValue = 0;
    
    with (sheetObj) {

    
        var level = CellValue(row, "treeLevel") * 1;
        // =====================================
        var colName = sheetObj.ColSaveName(col).substring(0,(sheetObj.ColSaveName(col).length)-2);
        if( colName != 'fcast_ttl_teu_qty' && colName != 'fcast_ttl_qty'){
            orgValue = selectedCell_OldValue;
        }
        var difValue = value * 1 - orgValue;        
        // =====================================

        if (CellEditable(row, col) && CellFontColor(row, col) == 255) {
            ComShowMessage("Please check if port is skipped or account is not registered for forecast input.");
        }
        
        if(colName == "fcast_40ft_qty" && !checkUnitValue(sheetObj, row, col)) {
            CellValue2(row, col) = selectedCell_OldValue;
            return false;
        }
        
        switch (level) {
        case 5:
        
            var colIdx = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
            var ttlCol = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1) + colIdx;
            
            compareConfirmValue(sheetObj, row, col);
            
            var frow = row;
            
            var cust_cd = CellValue(frow, "d_cust_cd");
            var pol_cd  = CellValue(frow, "d_pol_cd");
            
            var isAsigned = false;
            frow = frow + 1;
            
            // VVD Index 계산
            var itemIdx = (col - sheet1.masterColumnCount - colIdx) / sheet1.itemColumnCount;
            // 해당 VVD의 flag column 계산
            var flagCol = sheet1.masterColumnCount + itemIdx * sheet1.itemColumnCount + sheet1.infoColumnCount - 1;     
            while (  pol_cd == CellValue(frow, "d_pol_cd")  
                  && cust_cd  == CellValue(frow, "d_cust_cd")) {
                selectedCell_OldValue = CellValue(frow, col);
                if (selectedCell_OldValue != "") {
                    var old_color = CellFontColor(frow, col);
                    
                    if (isAsigned || CellValue(frow, flagCol) == "0") { //flag가 0인 경우는 해당 VVD의 POD가 아닌 경우
                        CellValue(frow, col) = 0;
                    } else {
                        CellValue(frow, col) = value;
                        isAsigned = true;
                    }
                    CellFontColor(frow, col) = old_color;
                }
                frow = frow + 1;
            }
            
            setChangedStatus(sheetObj, row, col);
            // RowStatus(row) = "R";
            break;

        case 6:
            var colIdx  = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
            var ttlCol  = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1) + colIdx;
            var rowLane = CellValue(row, "rowLane") * 1;
            var rowGrp  = CellValue(row, "rowGrp")  * 1;
            var rowRep  = CellValue(row, "rowRep")  * 1;
            var rowPol  = CellValue(row, "rowPol")  * 1;
            var rowUs  = CellValue(row, "rowUs")  * 1;
            var rowUsA  = CellValue(row, "rowUsA")  * 1;

            //compareConfirmValue(sheetObj, row, col);

            // 1.현재 행의 TTL 값 변경
            AddValue2(sheetObj, row, null, ttlCol, difValue); // POD 의 Total 계산

            // 2.현재 행의 POL에 대한 값 변경
            if (rowPol != SelectRow) {

                AddValue2(sheetObj, rowPol, col, null, difValue);   // POD SUM 값을 POL 에 입력
                //compareConfirmValue(sheetObj, rowPol, col);
                setChangedStatus(sheetObj, rowPol, col);
            }

            AddValue2(sheetObj, rowPol, null, ttlCol, difValue);    // POL 의 Total 계산
            
            if(rowGrp > 0) {

                // 3.현재 행의 Sales Rep에 대한 값 변경
                AddValue2(sheetObj, rowRep, col, ttlCol, difValue);     // Sales Rep 의 Total 계산
                //compareConfirmValue(sheetObj, rowRep, col);
                setChangedStatus(sheetObj, rowRep, col);
                // 4.현재 행의 RLane에 대한 값 변경

//              AddValue2(sheetObj, rowLane + 1 + ((ComTrim(CellValue(rowLane + 1, "d_pol_cd")) == "") ? 1 : 0), col, ttlCol, difValue);    // Lane 의 Total 계산

                AddValue2(sheetObj, rowLane + 1, col, ttlCol, difValue);    // Lane 의 Total 계산

/* 
 * Lane이 POL-POD를 사용안하므로 삭제
*/
                // 5.현재 행의 RLane의 POL에 대한 값 변경
                var frow = FindText("d_pol_cd", CellValue(row, "d_pol_cd"), rowLane);   // Lane 의 POL 계산
                AddValue2(sheetObj, frow, col, ttlCol, difValue);
/*
                // 6.현재 행의 RLane의 POD에 대한 값 변경
//              frow = FindText("d_pod_cd", CellValue(row, "d_pod_cd"), frow);  //  Lane 의 POD 계산
//              AddValue2(sheetObj, frow, col, ttlCol, difValue);
*/
                setChangedStatus(sheetObj, row, col);           
                
                if(CellValue(rowGrp, "d_acct_lvl") != " "){ 

                    // 7.Group Total 에 대한 값 변경
                    AddValue2(sheetObj, rowGrp, col, ttlCol, difValue); // Group Total 의 Total 계산
                    /*// 8.Group Total 의 POL에 대한 값 변경
                    frow = FindText("d_pol_cd", CellValue(row, "d_pol_cd"), rowGrp);    // Group Total 의 POL 계산
                    AddValue2(sheetObj, frow, col, ttlCol, difValue);
                    // 9.Group Total 의 POD에 대한 값 변경
                    frow = FindText("d_pod_cd", CellValue(row, "d_pod_cd"), frow);  // Group Total 의 POD 계산
                    AddValue2(sheetObj, frow, col, ttlCol, difValue);*/
                }
                
                if(rowUsA>0){
                    AddValue2(sheetObj, rowUsA, col, ttlCol, difValue);// Srep의 US Mode TOTAL계산
                }else if(rowUs>0){ 
                    AddValue2(sheetObj, rowUs, col, ttlCol, difValue);  // US Mode TOTAL계산
                }
            }
            
            
            
            if(CellValue(row, "d_cust_nm") == "OTHERS (+)" && otherFlg == "Y") {
                // 10. OTHERS 의 값 변경시 OTHERS 하위 내용을 모두 0으로 처리
                othersToZero(sheetObj, row, col);
            }
            
            break;
        }
        
    }
    
    if( colName != 'fcast_ttl_teu_qty' && colName != 'fcast_ttl_qty'){
        selectedCell_OldValue = value;
    }
}

function checkUnitValue(sheetObj, row, col){

    var formObj = document.form;
    var unit    = formObj.chkDs2FEU.checked;
    var val = Number(sheetObj.CellValue(row, col));
    var checkVal = val*2 + "";
    if(unit){
        var rtn = ComIsNumber(checkVal);
        if(rtn == false){
            ComShowMessage("In case of FEU unit, you can only enter decimal point as 0.0 or 0.5");
            return rtn;
        }
    }
    return true;
}

function setChangedStatus(sheetObj, row, col) {
    with (sheetObj) {
        var value = CellValue(row, col);
        var colIdx = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;

        // ======================
        // 수정 여부 Flag 설정 시작
        // VVD Index 계산
        var itemIdx = (col - sheet1.masterColumnCount - colIdx)
                / sheet1.itemColumnCount;
        // 해당 VVD의 flag column 계산
        var flagCol = sheet1.masterColumnCount + itemIdx
                * sheet1.itemColumnCount + sheet1.infoColumnCount - 1;
        log("setChangedStatus flagCol : " + flagCol);
                
        var searchValue = CellSearchValue(row, col) * 1;
        var searchFlag  = CellValue(row, flagCol);
        
        CellValue2(row, flagCol) = ( value == searchValue) ? searchFlag == "" ? ""
                : "R"
                : (searchFlag == "" ? "I" : "U");
    
        var curRowEdited = false;
        for ( var i = 0; i < sheet1.weekCount; i++) {
            var colValue = CellValue(row, sheet1.masterColumnCount
                    + sheet1.itemColumnCount * i + sheet1.infoColumnCount - 1);
            if (colValue != "" && colValue != "R") {
                curRowEdited = true;
            }
        }

        if (!curRowEdited) {
            RowStatus(row) = "R";
        }
        // 수정 여부 Flag 설정 끝
        // ----------------------
    }
}


function vvdChanged() {
    var obj = event.srcElement;
    if (obj.value == "") {
        trade_OnChange(comObjects[0], comObjects[0].Code, comObjects[0].Text);
    } else {
        document.all.id_chk_ocn.checked = true;
        document.all.id_chk_ocn.disabled = false;
        document.all.id_chk_ipc.disabled = false;
        document.all.id_chk_ts.disabled = false;
    }
}

var laneChange = false; // lane 변경 구분값
function lane_OnChange(comObj, value, text) {
    if (value == "")
        return;
    if (document.all.vvd.value != "")
        return;

    // if(value.substring(0,3) == "IMU" && comObjects[0].Text == 'AES'){
    // document.all.id_chk_ocn.checked = true;
    // document.all.id_chk_ocn.disabled = false;
    // document.all.id_chk_ipc.disabled = true;
    // document.all.id_chk_ts.disabled = false;
    // } else {
//  alert(comObj.GetText(value,0)+"//"+comObj.GetText(value,1));
    laneChange = true; // lane 변경
//  var trade = comObj.GetText(value,0);
//  var subTrade = comObj.GetText(value,1);
//  comObjects[0].Code2 = trade;
//  comObjects[1].Code2 = subTrade;
    
    var arrLane = text.split("|");
    if(arrLane.length > 1) {
        comObjects[0].Code2 = arrLane[0];
        comObjects[1].Code2 = arrLane[1];
    } else {
        comObjects[0].Code2 = comObj.GetText(value,0);  
        comObjects[1].Code2 = comObj.GetText(value,1);  
    }   
    // alert(trade+"//"+subTrade);
    trade_OnChange2(comObjects[0], comObjects[0].Text, text);
    laneChange = false; // lane 변경 초기화
    // }

}

function trade_OnChange2(combj, value, text) {
    if (value == "")
        return;
    if (document.all.vvd.value != "")
        return;

    if (value.charAt() != "I") {
        document.all.id_chk_ocn.checked = true;
        document.all.id_chk_ocn.disabled = true;
        document.all.id_chk_ipc.disabled = true;
        document.all.id_chk_ts.disabled = true;
    } else {
        document.all.id_chk_ipc.checked = true;
        document.all.id_chk_ocn.disabled = true;
        document.all.id_chk_ipc.disabled = false;
        document.all.id_chk_ts.disabled = false;
    }

    if (!laneChange) { // lane 변경없을시(trade 변경시)
        comObjects[1].Code2 = '';
        comObjects[2].Code2 = '';
    }

}


/**
 * Trade 변경시
 *  - 선택된 Trade에 해당하는 Sub Trade 및 Rev. Lane 정보 가져와서 Combo Box 셋팅
 */
function trade_OnChange_t(combj, value, text){
    var formObj = document.form;
    
    if(value == "TPS")
        formObj.chkDs2SC.checked = true;
    else
        formObj.chkDs2SC.checked = false;
    
    //IAS SMP 변경에 따른 보완 Requirement
    if(value == "AES" || value == "IAS") 
        formObj.chkDs2RFA.checked = true;
    else
        formObj.chkDs2RFA.checked = false;
    
    // Trade 및 Sales Office가 있는 경우에만 활성화
    if(value != '' && comObjects[3].Code != '')
        ComBtnEnable("btng_acctMapping");
    else
        ComBtnDisable("btng_acctMapping");
    
    if (formObj.vvd.value != "")
        return;

    if (value.charAt() != "I") {
        document.all.id_chk_ocn.checked  = true;
        document.all.id_chk_ocn.disabled = true;
        document.all.id_chk_ipc.disabled = true;
        document.all.id_chk_ts.disabled  = true;
    } else {
        document.all.id_chk_ipc.checked  = true;
        document.all.id_chk_ocn.disabled = true;
        document.all.id_chk_ipc.disabled = false;
        document.all.id_chk_ts.disabled  = false;
    }

    if (!laneChange) { // lane 변경없을시(trade 변경시)
        comObjects[1].Code2 = '';
        comObjects[2].Code2 = '';
    }
    
    // [S] 2012.01.19 SHKIM CHECK 가져오기 ..
    var trade = formObj.trade.Code;
    formObj.subtrade1.Code2 = "";   
    formObj.bound.value     = "";   
    if(trade != null && trade != ''){       
        SpcSearchOptionSubTrade("subtrade1",true,false, "", "", formObj.trade.Code);            // 0207 SHKIM           
        SpcSearchOptionLane("rlane1",true,true,'',formObj.trade.Code,'',true);  // 0207 SHKIM
    }   
    // [E] 2012.01.19 SHKIM CHECK 가져오기 ..
    RevenueLaneSetting(formObj.trade.Code);
    laneCompulsory(formObj);
}


function subtrade1_OnChange_t(combj, value, text) {

    var formObj = document.form;        
    var trade   = formObj.trade.Code;
    var sub_trd = formObj.subtrade1.Code;
    var dir_cd  = formObj.bound.value;
    
        ComOpenWait(true);
        //reset_rlane_combo("rlane1",false);        
        if(trade == null && trade == ''){
            ComShowMessage(getMsg("SPC90117", "Trade"));
            ComOpenWait(false);
            return;
        }       
        
        // [E] 2012.01.19 SHKIM CHECK 가져오기 ..
        RevenueLaneSetting(formObj.trade.Code, formObj.subtrade1.Code); 
        ComOpenWait(false);
}

function salesOffice_OnChange(comObj, value, text) {
    // Trade & Sales Office 모두 있을때만 Account Mapping 버튼 활성화
    if(value != '' && comObjects[0].Code != '')
        ComBtnEnable("btng_acctMapping");
    else
        ComBtnDisable("btng_acctMapping");
    
    var rtn = getCodeList("ChildTeamOffice", "ofc_cd=" + value + "&level=5&include=1");
    initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));

    if (document.getElementById("subOffice").Code == "") {
        var rtn = getCodeList("TeamSalesRep", "ofc_cd=" + value + "&level=4");
        initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
    }

    // 2010.05.10 subOffice Index = 0 값을 늦게 가져와서 재호출 -> 2013.4.17 srep 의 INIT 확인 위해 주석처리함0 -> 2013.04.25 LEDBA -1 문제로 재처리
    var subObj = document.getElementById("subOffice");
    subOffice_OnChange(subObj, subObj.Code, subObj.Text);
}

function subOffice_OnChange(comObj, value, text) {
    var rtn = "";
    if (value == "") {
        rtn = getCodeList("TeamSalesRep", "ofc_cd="
                + document.getElementById("salesOffice").Code + "&level=4");
    } else {
        rtn = getCodeList("TeamSalesRep", "ofc_cd=" + value + "&level=5");
    }

    initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
}

function salesRep_OnChange(comObj, value, text){
    if(value == "" || value == "-1") 
        return;
    
    var arrSRep = text.split("|");
    
    if(arrSRep.length > 1) {
        document.subOffice.Code2 = arrSRep[2];
    } else {
        document.subOffice.Code2 = comObj.GetText(value,2);  
    }
}

function initDataValue_salesOffice() {
    var sheetObj = document.getElementById("salesOffice");
    with (sheetObj) {
        Index2 = 0;
    }
}

function initData_salesOffice(codes, names) {
    var sheetObj = document.getElementById("salesOffice");
    var cnt = 0;

    with (sheetObj) {
        RemoveAll();
        SetTitle("Office|Name");
        SetColWidth("60|250");
        SetColAlign("left|left");
        ShowCol = 0;
        MultiSelect = false;
        MaxSelect = 1;
        DropHeight = 190;

        if (codes == undefined || codes == null) {
            return;
        }

        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }

        var selectCode = "";
        for ( var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[1] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
        }

        if (selectCode != "") {
            Code = selectCode;
        } else {
            Index = 0;
        }
        Enable = (GetCount() > 1);
    }
}

function initData_subOffice(codes, names) {
    var sheetObj = document.getElementById("subOffice");
    var cnt = 0;

    with (sheetObj) {
        RemoveAll();
        SetTitle("Office|Name");
        SetColWidth("60|250");
        SetColAlign("left|left");
        ShowCol = 0;
        MultiSelect = false;
        MaxSelect = 1;
        DropHeight = 190;

        if (codes == undefined || codes == null) {
            return;
        }

        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }

        var selectCode = "";
        for ( var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[1] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
        }

        if (selectCode != "") {
            Code = selectCode;
        } else {
            Index = 0;
        }

        Enable = (GetCount() > 1);
        Enable = !(Index > 1);
    }
}

function initDataValue_subOffice() {
    var sheetObj = document.getElementById("subOffice");
    with (sheetObj) {
        Index2 = 0;
    }
}

function initData_salesRep(codes, names) {
    var sheetObj = document.getElementById("salesRep");
    var cnt = 0;

    with (sheetObj) {
        RemoveAll();
        SetTitle("Code|Name|OFC|OFC NM");
        SetColWidth("60|150|60|100");
        SetColAlign("left|left|left|left");
        ShowCol = 0;
        MultiSelect = false;
        MaxSelect = 1;
        DropHeight = 190;

        if (codes == undefined || codes == null) {
            return;
        }

        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }

        var selectCode = "";
        for ( var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[3] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + names[i].replace(/~/g, "|"),
                    codes[i]);
        }
        
        if (selectCode != "" && document.subOffice.Code!="") {
            Code = selectCode;
            firFlg = "";
        } else {
            Index = 0;
        }
    }
}

function initDataValue_salesRep() {
    var sheetObj = document.getElementById("salesRep");
    with (sheetObj) {
//      Code2 = sheetObj.Code;
    }
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH: // 조회
        var sel_vvd    = formObj.vvd.value;
        var sel_trade  = comObjects[0].Code;
        var sel_subtrd = comObjects[1].Code;
        var sel_lane   = comObjects[2].Code;    
        var sel_ofc    = comObjects[3].Code;
        var sel_subOfc = comObjects[4].Code;
        var sel_sRep   = comObjects[5].Code;
        var sel_dur    = formObj.duration.value;
        
        if (sel_vvd == "" && sel_trade == "") {
            ComShowMessage(getMsg("SPC90114", "Trade"));
            formObj.vvd.focus();// 아래 바로 Focus안잡혀서 임시로 먼저 잡음
            comObjects[0].focus();
            return false;
        }
        
        if(sel_vvd == ""){
            if (sel_subtrd == "" && sel_lane == "") {
                ComShowMessage(getMsg("SPC90143", "Sub Trade", "Lane"));
                comObjects[1].focus();
                return false;
            }
        }

        if (sel_ofc == "") {
            ComShowMessage(getMsg("SPC90114", "Sales Office"));
            formObj.vvd.focus();// 아래 바로 Focus안잡혀서 임시로 먼저 잡음
            if (comObjects[3].Enable)
                comObjects[3].focus();
            return false;
        }

        if (sel_vvd != "" && sel_vvd.length < 9) {
            ComShowCodeMessage("COM12174", "VVD", "9");
            formObj.vvd.focus();
            return false;
        }
        
        if (formObj.bound.className == "input1" && formObj.bound.value == ""){
            ComShowMessage(getMsg("SPC90114", "Bound"));
            formObj.bound.focus();
            return false;
        }
        
        //Trade:IAS , Sales Office:SELSC 조회 조건 일 때 Duration을 1주로 제한 (Out Of Memory 에러 조치)
        if(sel_trade == "IAS" && sel_ofc == "SELSC" && sel_dur != "1" && sel_vvd == "" && sel_lane == "" && sel_subOfc == ""){
            ComShowMessage(getMsg("SPC90313"));
            formObj.duration.focus();
            return false;
        }
        
        //Sales Rep선택 후 조회 시 해당 Sales Rep이 몇 개의 Account를 체크했는지 개수를 세서 50개 이상의 Account를 체크한 경우 Duration 을 1주로 제한.
        if(sel_sRep != "" && sel_dur != "1" && sel_vvd == "" && sel_lane == ""){
            var rtn = checkSrepCnt();
            if (rtn > 49){
                ComShowMessage(getMsg("SPC90314"));
                formObj.duration.focus();
                return false;
            }
        }
        break;
    }
    return true;
}

function checkSrepCnt(){
    var sheetObj = sheetObjects[0];
    var param = "trade="      + comObjects[0].Code
              + "&subtrade="  + comObjects[1].Code
              + "&salesRep="  + comObjects[5].Code;

    var rtn = sheetObj.GetSearchXml("ESM_SPC_0102GS1.do", "f_cmd="+ (SEARCHLIST02) + "&" + param);
    var etcData = getEtcData(rtn);
    var dataCnt = etcData["dataCnt"];
    return dataCnt;
}

function initDataValue_trade() {
    var sheetObj = document.getElementById("trade");
    with (sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_subtrade1() {
    var sheetObj = document.getElementById("subtrade1");
    with (sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_lane1() {
    var sheetObj = document.getElementById("lane1");
    with (sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_subOffice() {
    var sheetObj = document.getElementById("subOffice");
    with (sheetObj) {
        Index2 = 0;
    }
}

/**
 * Start Week 의 year 변경시
 * Start Week 의 year 변경시 주차 변경
 */
function checkWeek(){
    SpcSearchOptionWeek("week",false,document.form.year.value)  
}

   /**
     *  OTHERS 선택시 처리 
     */
    function sheet1_OnClick(sheetObj, row, col){      
        sheetObj.disabled = true;   
        var colName = sheetObj.ColSaveName(col);    
        if(col > 23) {//22->23
            colName = colName.substring(0, colName.length-2);
        }
        
        switch(colName){ 
        case "d_pod_cd":
            var mark = sheetObj.CellValue(row, col);
            if (mark == "+" || mark == "-") {
                toggleExpand(sheetObj, row, col);
            }
            break;
        
        case "fcast_rmk":
            if((sheetObj.CellValue(row, "cust_cnt_cd") != "") && (sheetObj.CellValue(row, col) != ""))
                ComShowMemoPad(sheetObj, row, col, true);
            break;
        }
        
        sheetObj.disabled = false;
        
    }
    
    /*function setBkgYN(sheetObj, row, col, tempCust, BkgYN, sts){
        
        var tempSubCust="";

        for ( var i = row ; i < sheetObj.Rows; i++) {
            
            tempSubCust=sheetObj.CellValue(i, 0)
                        +sheetObj.CellValue(i, 1)
                        +sheetObj.CellValue(i, 2)
                        +sheetObj.CellValue(i, 3)
                        +sheetObj.CellValue(i, 4)
                        +sheetObj.CellValue(i, 5)
                        +sheetObj.CellValue(i, 6)
                        +sheetObj.CellValue(i, 7)
                        +sheetObj.CellValue(i, 8)
                        +sheetObj.CellValue(i, 9)
                        +sheetObj.CellValue(i, 10);     
            
            if( tempSubCust == tempCust){               
                sheetObj.CellValue2(i, "BkgYN") = BkgYN;
                sheetObj.RowStatus(i) = sts;
            }else
                break;
                
        }   
    }*/
    
    
    /**
     * sheet1 의 조회 후
     */
    function setBkgCust( ){
        
        var sheetObj = sheetObjects[0];
        var bkgCust="";
        var cust="";        
        var sts="";
        for (var i = 0 ; i < sheetObj.Rows; i++) {      
            cust =sheetObj.CellValue(i,"d_cust_nm");
            bkgCust = ComTrim(sheetObj.CellValue(i,"bkg_cust_cd")); 
            
            if( cust ==  "OTHERS (+)"
                && bkgCust != null 
                && bkgCust.length > 0 ){        
//              sts = sheetObj.RowStatus(i);
                
//              sheetObj.CellValue2(i, "BkgYN") = "N";
//              sheetObj.RowStatus(i) = sts;
                sheetObj.CellValue2(i, "rowGrp") = "0";
                sheetObj.RowHidden(i) = true;  
            }   
        }
    }
    
    /**
     * Revenue Lane Setting
     *  - 선택된 Trade / Sub Trade 에 해당하는 Rev. Lane 조회 후 Combo 셋팅
     */
    function RevenueLaneSetting(trdCd, subTrdCd ) { 
        
        if(trdCd == undefined || trdCd == null){
            trdCd = '';
        }           
        if(subTrdCd == undefined || subTrdCd == null){
            subTrdCd = '';
        }    
        rlane_rtn_xml = SpcSearchRevLane("rlane1",true,"N",true,trdCd,subTrdCd);        
        var rlane1_combo = document.getElementById("rlane1");       
        ComXml2ComboItem(rlane_rtn_xml, rlane1_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
        rlane1_combo.InsertItem(0, "||ALL|ALL|");
    }
    
    /**
     * sheet1의 조회 후
     */
    /*
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){  
        if (sheetObj.RowCount > 0 
            && strSrep_cd !=""
            && strSrep_cd.length > 0 ) {
            checkCustByLogInUser();
        }           
        // add 2012.09.14.
        setBkgCust();   
    }&/
    
    
    /**
     *   Grid에 Data Loading 할때, LogIn User의 고객사 점검
     *      
     */
    function checkCustByLogInUser() {   
        
        var existFlg      = "";
        var listSrepCd    = "";
        var listCustCd    = "";
        var listBkgCustCd = "";
        var redColor      = sheetObjects[0].RgbColor(255, 200, 200);
        var redFlg        = "N";
        
        for(i=3; i < sheetObjects[0].RowCount; i++){
            existFlg      = ComTrim(sheetObjects[0].CellValue(i, "chk_cust_cd"));
            listSrepCd    = sheetObjects[0].CellValue(i, "d_srep_usr_id");
            listCustCd    = sheetObjects[0].CellValue(i, "d_cust_cd");
            listBkgCustCd = ComTrim(sheetObjects[0].CellValue(i, "bkg_cust_cd"));
            
            if(listCustCd !="" && listCustCd.length > 1 && listCustCd != "XX999999"){
                // 색상 변경
                if(existFlg == "N" ){
                    // 화면의 Account Code, Name 에 해당하는 d_cust_cd, d_cust_nm 부분 색상변경
                    sheetObjects[0].RangeBackColor( i, 13, i, 14 ) = redColor;
                    redFlg = "Y";
                }
            }
        }// End For
        
        if(redFlg == "Y") {
            //ComShowMessage(getMsg("SPC90137"));
        }
    }
    
    /**
     * 마우스가 이동될 때 이벤트 처리 
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row = sheetObj.MouseRow;
        var Col = sheetObj.MouseCol;
        
        var colNm = sheetObj.ColSaveName(Col);
        var wk    = colNm.substring(colNm.length-1);
        var rmk = sheetObj.CellText(Row, "fcast_rmk_"+wk);
        
        // VVD 항목에서만 마우스 포인터 손가락 모양으로 변경.
        var vvd = sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol);
        var dir = vvd.substr(vvd.length-1);
            
        if(vvd.length == 9 && (dir == "E" || dir ==  "W" || dir == "N" || dir ==  "S")){
            sheetObj.MousePointer = "Hand";
        }else{
            sheetObj.MousePointer = "Default";
        }
        
        // Contract Forecast 항목 위로 마우스 오버시 Contract Forecast Remark 를 보여준다.
        if(sheetObj.CellValue(Row, "d_pol_cd") == "CTRT FCST" && colNm.substr(0, 6) == "fcast_"){
            sheetObj.MouseToolTipText = rmk;
        }else
            sheetObj.MouseToolTipText = "";
    }  

    function sheet1_OnDblClick(sheetObj, row, col) {
        var formObj = document.form;
        
        // Name|Bkg Cust     wait   
        var cust="";
        var bkgCust="";
        var bkgCustNm="";
        var tempCust="";
        
        var tempOther="";
        var tempSubCust="";
        var tempPOD="";
        
        var bkgYN ="N"; 
        var pod ="";
        
        var colNm = sheetObj.ColSaveName(col);
        
        switch(colNm){
        case "d_cust_nm":
            
            sheetObj.disabled = true;
            
            cust        =sheetObj.CellValue(row, col);
            bkgCust     =ComTrim(sheetObj.CellValue(row, col+4));   
            bkgCustNm   =ComTrim(sheetObj.CellValue(row, col+5));
            pod         =sheetObj.CellValue(row, col+8);
            tempCust    =sheetObj.CellValue(row, 0)
                        +sheetObj.CellValue(row, 1)
                        +sheetObj.CellValue(row, 2)
                        +sheetObj.CellValue(row, 3)
                        +sheetObj.CellValue(row, 4)
                        +sheetObj.CellValue(row, 5)
                        +sheetObj.CellValue(row, 6)
                        +sheetObj.CellValue(row, 7)
                        +sheetObj.CellValue(row, 8)                         
                        +sheetObj.CellValue(row, 9)
                        +sheetObj.CellValue(row, 10);
            bkgYN = ComTrim(sheetObj.CellValue(row, col+3));
            
            if(    cust == "OTHERS (+)"
                && bkgCust ==""
                // && pod =="-"
               ) {
                
                var flg = bkgYN=="Y"?"N":"Y";
                var sts = sheetObj.CellValue(row, "editFlag");
                sheetObj.CellValue2(row, "BkgYN") = flg;        // 이거 때문에 값이 바뀌면서 POL Merge 깨짐
                sheetObj.RowStatus(row) = sts;

                for ( var i = row ; i < sheetObj.Rows; i++) {
                    bkgCust     = ComTrim(sheetObj.CellValue(i, col+4));
                    bkgCustNm   = ComTrim(sheetObj.CellValue(i, col+5));
                    tempSubCust = sheetObj.CellValue(i, 0)
                                + sheetObj.CellValue(i, 1)
                                +sheetObj.CellValue(i, 2)
                                +sheetObj.CellValue(i, 3)
                                +sheetObj.CellValue(i, 4)
                                +sheetObj.CellValue(i, 5)
                                +sheetObj.CellValue(i, 6)
                                +sheetObj.CellValue(i, 7)
                                +sheetObj.CellValue(i, 8)
                                +sheetObj.CellValue(i, 9)
                                +sheetObj.CellValue(i, 10);
                    
                    tempOther =sheetObj.CellValue(i, col);
                    tempPOD=sheetObj.CellValue(i, col+8 );
                    
                    if(    tempSubCust == tempCust
                        && bkgCust != null
                        && bkgCust.length > 0 ){
                        
                        // Stpe 1 : Row 감추기
                        if( bkgYN =="Y" ){
                            sheetObj.RowHidden(i) = true;
                            var sts = sheetObj.CellValue(i, "editFlag");
                            
                            sheetObj.CellValue2(i, col-1)="XX999999";
                            sheetObj.CellValue2(i, col)="OTHERS (+)";
                            //sheetObj.CellValue2(i, "BkgYN") ="N";
                            sheetObj.RowStatus(i) = sts;
                            //setBkgYN(sheetObj, i, col, tempCust, "N", sts);
                        } else {
                            if( (document.all.chkDs2POD.checked == false && tempPOD == "-") || tempPOD == "CTRT FCST") {
                                sheetObj.RowHidden(i) = false;
                            } else if(document.all.chkDs2POD.checked == true) {
                                sheetObj.RowHidden(i) = false;
                            }
                            
                            var sts = sheetObj.CellValue(i, "editFlag");
                            
                            sheetObj.CellValue2(i, col-1)=bkgCust;
                            sheetObj.CellValue2(i,   col)=bkgCustNm;
                            //sheetObj.CellValue2(i, col+1) ="Y";
                            sheetObj.RowStatus(i) = sts;
                            //setBkgYN(sheetObj, i, col, tempCust, "Y", sts);
                            
                            sheetObj.CellValue2(i, "rowGrp") = "0";
                        }
                    }else if(tempSubCust != tempCust)
                        break;
                    
                    if(sheetObj.CellValue(row, col+8) == 'Y'){
                        var mark = sheetObj.CellValue(row, col+8);
                        if (mark == "+" || mark == "-") {
                            toggleExpand(sheetObj, row, col+8);
                        }
                    }
                }// end For
            }
            
            sheetObj.disabled = false;
            break;
        }
        
        
        
        if(colNm.substr(0, 8) == "usd_bkg_" && ComTrim(sheetObj.CellValue(row, "d_pol_cd")) != "Alloc" ){
            
        
            sUrl = "/hanjin/ESM_SPC_0049.do";
            var cnt = eval(sheetObj.CellValue(row, col));
            
            var tmpOfc  = ComTrim(sheetObj.CellValue(row, "d_sub_ofc_cd"))==""?(formObj.subOffice.Code==""?"":formObj.subOffice.Code):ComTrim(sheetObj.CellValue(row, "d_sub_ofc_cd"));
            var ofc_lvl = (tmpOfc=="" && formObj.salesRep.Code=="")?5:6;
            var ofc_cd  = tmpOfc==""?sheetObj.CellValue(row, "d_rgn_ofc_cd"):(tmpOfc.substr(0, 3)=="SEL"?sheetObj.CellValue(row, "d_rgn_ofc_cd"):tmpOfc);
            var srep_cd = ComTrim(sheetObj.CellValue(row, "d_srep_usr_id"))==""?(formObj.salesRep.Code==""?"":formObj.salesRep.Code):sheetObj.CellValue(row, "d_srep_usr_id");
            
            var i = Number(colNm.substr(colNm.length-1, 1)) - 1;
            var baseCol = sheet1.masterColumnCount + sheet1.itemColumnCount * i;
            var vvd = sheetObj.CellValue(row, baseCol + 4)
                    + sheetObj.CellValue(row, baseCol + 5)
                    + sheetObj.CellValue(row, baseCol + 6);
            
            if( cnt > 0 && ComTrim(sheetObj.CellValue(0, col)) != "TTL" && ComTrim(sheetObj.CellValue(row, "d_pol_cd")) != "Alloc" && sheetObj.CellValue(row, "d_pol_cd") != "CTRT FCST"){
                param = "?f_cmd="+SEARCHLIST
                    + "&trade="         + sheetObj.CellValue(row, "d_trd_cd")
                    + "&subtrade="      + sheetObj.CellValue(row, "d_sub_trd_cd")
                    + "&lane="          + sheetObj.CellValue(row, "d_rlane_cd")
                    + "&bound="         + sheetObj.CellValue(row, "d_dir_cd")
                    + "&year="          + sheetObj.CellValue(0, col).substring(0, 4)
                    + "&week="          + sheetObj.CellValue(0, col).substring(4)
                    + "&vvd="           + vvd
                    
                    + "&ioc_cd="        + sheetObj.CellValue(row, "d_ioc_ts_cd")
                    + "&sls_area_cd="   + sls_rhq_cd
                    + "&sls_ofc_cd="    + ofc_cd
                    + "&pol_cd="        + sheetObj.CellValue(row, "d_pol_cd")
                    + "&pod_cd="        + sheetObj.CellValue(row, "d_pod_cd")
                    + "&ofc_lvl="       + ofc_lvl
                    + "&srep_cd="       + srep_cd
                    + "&cust_cd="       + sheetObj.CellValue(row, "d_cust_cd")
                    + "&sc_no="         + ComTrim(sheetObj.CellValue(row, "d_sc_no"))
                    + "&rfa_no="        + ComTrim(sheetObj.CellValue(row, "d_rfa_no"))
                    + "&cust_ctrl="     + ComTrim(sheetObj.CellValue(row, "d_acct_lvl"));
                
                //usa mode, dest 추가,  destLvl, destLocTp, usModFlg = "";
                if(usModFlg == "Y") {
                    param = param + "&usa_bkg_mod_cd=" + sheetObj.CellValue(row, "d_usa_bkg_mod_cd") ; // usa_bkg_mod_cd bkg_del_cd bkg_pod_cd 
                }   
                
                //if(destLocTp != "" ) {
                //  param = param  + "&dest_loc_tp=" + destLocTp +  "&" + ( "T" == destLvl?"bkg_del_cd=" :"bkg_pod_cd=")  + sheetObj.CellValue(row, "d_dest_loc_cd") ;  
                //} //destLocTp = 'L' 이면 그대로 걸어주고, 'E' 이면 coa_loc_fnc(coa_bkg_expn_dtl.bkg_pod_cd, 'ECC') 이런식으로 변환해서 비교해준다.              

                var leftpos = (screen.width - 1024) / 2;
                if (leftpos < 0)
                    leftpos = 0;
                var toppos = (screen.height - 540) / 2;
                if (toppos < 0)
                    toppos = 0;                 

                var rtn = window.open(sUrl+param, "none", "height=540px,width=1024px,status=no,toolbar=no,menubar=no,location=no,resizable=yes,Left="+leftpos + ",dialogTop:" + toppos)
            }
        }
    }
       
    function othersToZero(sheetObj, row, col) {
        
        var cust     = "";
        var tempCust = "";
        var custCd   = "";
        var polCd    = "";
        var podCd    = "";
        var postfix  = sheetObj.ColSaveName(col).substring(sheetObj.ColSaveName(col).length-2);
        otherFlg = "N";
        
        cust = sheetObj.CellValue(row, 0)
             + sheetObj.CellValue(row, 1)
             + sheetObj.CellValue(row, 2)
             + sheetObj.CellValue(row, 3)
             + sheetObj.CellValue(row, 4)
             + sheetObj.CellValue(row, 5)
             + sheetObj.CellValue(row, 6)
             + sheetObj.CellValue(row, 7)
             + sheetObj.CellValue(row, 8)
             + sheetObj.CellValue(row, 9)
             + sheetObj.CellValue(row, 11);
        
        for ( var i = row ; i < sheetObj.Rows; i++) {
            custCd = ComTrim(sheetObj.CellValue(i, "bkg_cust_cd"));
            polCd  = sheetObj.CellValue(i, "d_pol_cd");
            podCd  = sheetObj.CellValue(i, "d_pod_cd");
            
            tempCust = sheetObj.CellValue(i, 0)
                     + sheetObj.CellValue(i, 1)
                     + sheetObj.CellValue(i, 2)
                     + sheetObj.CellValue(i, 3)
                     + sheetObj.CellValue(i, 4)
                     + sheetObj.CellValue(i, 5)
                     + sheetObj.CellValue(i, 6)
                     + sheetObj.CellValue(i, 7)
                     + sheetObj.CellValue(i, 8)
                     + sheetObj.CellValue(i, 9)
                     + sheetObj.CellValue(i, 11);
            
            if(cust == tempCust) {
                if(    custCd != ""
                    && sheetObj.CellValue(i, "treeLevel") =="6" //"5"//POL/POd레벨변경
                    && (    sheetObj.CellValue(i, "fcast_ttl_teu_qty" + postfix) > 0
                         || sheetObj.CellValue(i, "fcast_rf_qty"      + postfix) > 0
                         || sheetObj.CellValue(i, "fcast_ttl_wgt"     + postfix) > 0)) {
                    //sheetObj.SelectCell(i, col);
                    sheetObj.CellValue2(i, sheetObj.SaveNameCol("fcast_ttl_teu_qty" + postfix) - 1) = "U";
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_20ft_qty"    + postfix);
                    sheetObj.CellValue(i, "fcast_20ft_qty"    + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_40ft_qty"    + postfix);
                    sheetObj.CellValue(i, "fcast_40ft_qty"    + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_40ft_hc_qty" + postfix);
                    sheetObj.CellValue(i, "fcast_20ft_dry_qty" + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_20ft_dry_qty" + postfix);
                    sheetObj.CellValue(i, "fcast_40ft_dry_qty" + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_40ft_dry_qty" + postfix);
                    sheetObj.CellValue(i, "fcast_40ft_hc_qty" + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_45ft_hc_qty" + postfix);
                    sheetObj.CellValue(i, "fcast_45ft_hc_qty" + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_53ft_qty"    + postfix);
                    sheetObj.CellValue(i, "fcast_53ft_qty"    + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_rf_qty"      + postfix);
                    sheetObj.CellValue(i, "fcast_rf_qty"      + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_rd_qty"      + postfix);
                    sheetObj.CellValue(i, "fcast_rd_qty"      + postfix) = 0;
                    selectedCell_OldValue = sheetObj.CellValue(i, "fcast_ttl_wgt"     + postfix);
                    sheetObj.CellValue(i, "fcast_ttl_wgt"     + postfix) = 0;
                }
            } else {
//              sheetObj.SelectCell(row, col);
                break;
            }
        }
        
        otherFlg = "Y";
    }

     // Daily Forecast Status - FCST&PFMC Status by ACCT 탭 링크
     function callDailyForecast(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var selRow   = sheetObj.SelectRow;
        
        if(sheetObj.CellValue(selRow, "d_cust_cd") == ""){
            ComShowCodeMessage("COM12113", "Account Code");
            return;
        }
        
        var cust_cd  = sheetObj.CellValue(selRow, "d_cust_cd");
        cust_cd = cust_cd.substr(0,2) + ComLpad(cust_cd.substr(2), 6, "0");
        
        var paramTrade = formObj.trade.Code==""?sheetObj.CellValue(selRow, "trd_cd"):formObj.trade.Code;
        var paramSubTrade = formObj.subtrade1.Code==""?sheetObj.CellValue(selRow, "sub_trd_cd"):formObj.subtrade1.Code;
        var paramRlane = formObj.rlane1.Code==""?sheetObj.CellValue(selRow, "rlane_cd"):formObj.rlane1.Code;
        
        var param = "year="             + formObj.year.value;
        param = param + "&week="        + formObj.week.value;
        param = param + "&duration="    + formObj.duration.value;
        param = param + "&trade="       + paramTrade;
        param = param + "&sub_trade="   + paramSubTrade;
        param = param + "&rlane_cd="    + paramRlane;
        param = param + "&rhq="         + sls_rhq_cd;
        param = param + "&rgn_cd="      + sheetObj.CellValue(selRow, "d_rgn_ofc_cd")
        param = param + "&acct_cd="     + cust_cd;
        
        ComOpenWindow("ESM_SPC_0021.do?" + param, 'none',"height=650,width=1024,status=0,resizable=yes");
     }
     
     function laneCompulsory(formObj){
         var obj = (document.getElementById("bound"));
         remove_select_box(obj);
         if(formObj.trade.Code == "IAS"){
             formObj.bound.className = "input1";
             SpcSearchOptionBound("bound", false, false, false, false);
         }else{
             formObj.bound.className = "input";
             SpcSearchOptionBound("bound", false, true, false, true);
         }
     }

     function remove_select_box(obj){
         for(var i=0; i<obj.options.length; i++){
             obj.options[i].value = null;
             obj.options[i].text = null;
         }
         obj.options.length = 0;
     }

     /**
      * Yield Group 팝업 호출(ESM_SPC_0094)
      */
     function yieldGrpPopup() {
        var formObj = document.form;
        var sheet1  = sheetObjects[0];
        
        var param = "yrwk="   + sheet1.CellValue(0, "trd_cd");//header에 있는 첫번째 주차
        var trd = formObj.trade.Code==""?sheet1.CellValue(sheet1.HeaderRows, "d_trd_cd"):formObj.trade.Code;
        param = param + "&trd_cd=" + trd;
        ComOpenWindow("ESM_SPC_0094.do?" + param, "Yield Group", "height=300,width=450,status=0");
     }
     
     /**
      * US Mode의 total값이 0인 OTHERS 데이터 모두 접기
      */
     function hiddenZeroUsModeRows(sheetObj) {//fcast_ttl_teu_qty_ fcast_ttl_qty_ usd_bkg_ttl_qty_
         if(usModFlg == 'Y') {
             var zRow = 0;
             var postfix  =  "_" + sheet1.weekCount ;
             var sQty = 0;       
             for (var z = 0; z <= sheetObj.Rows; z++) {
                 zRow = sheetObj.FindText("treeLevel", "4", z);
                 sQty =  sheetObj.CellValue(zRow, "fcast_ttl_teu_qty" + postfix) + sheetObj.CellValue(zRow, "fcast_ttl_qty" + postfix) + sheetObj.CellValue(zRow, "usd_bkg_ttl_qty" + postfix);      
                 if(sheetObj.CellValue(zRow, "d_usa_bkg_mod_cd").trim() == 'OTHERS') {
                     if(sQty == 0) {
                         sheetObj.RowExpanded(zRow) = false;
                     }
                     
                 }
                 if(zRow > 0 ) z = zRow+1;
                 
             }
         }
     }
     
     /**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
     /*
      * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
      */
     function trade_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("trade").focus(); 
     }

     function subtrade1_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("subtrade1").focus(); 
     }
     
     function rlane1_OnFocus(combj, value, text){
         document.getElementById("year").focus();
         document.getElementById("rlane1").focus(); 
     }
     
     function trade_OnChange(combj, value, text){
         var formObj = document.form;
         setTimeout(function(){trade_OnChange_t(formObj,value)},10);
     }

     function subtrade1_OnChange(combj, value, text){
         var formObj = document.form;
         setTimeout(function(){subtrade1_OnChange_t(formObj,value)},10);
     }

/* 개발자 작업 끝 */
