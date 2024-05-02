/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_175.js
*@FileTitle :Re-Assignment by Bound(OP4)
*Open Issues :
*Change history :
* @LastModifyDate : 2010-02-22
* @LastModifier : 이연각
* @LastVersion : 1.0
*   2009-09-21 IM OKYOUNG
*  1.0 최초 생성
* History
* 2009-09-24 임옥영 Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영)
* 2010-01-07 김기식 Alps FrameWork 적용
* 2010-02-22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.12.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2011.02.21 김상수 [CHM-201108827-01] 1. R.month/Week 및 OPR/OPR2 정보 보여주는 컬럼 추가
*                                      2. Re-Assignment by bound, Re-Assignment by bound(OP4)
*                                         화면상에서 틀고정 기능 추가
*                                      3. js상의 validation함수 정리 및  coCoa.js로 소스이동
* 2011.09.15 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
* 2013.01.14 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
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
     * @class ees_coa_0175 : ees_coa_0175 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0175() {
        this.processButtonClick = processButtonClick;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.setSheetObject = setSheetObject;
        this.cobTrade_OnChange = cobTrade_OnChange;
        this.setPeriod() = setPeriod();
        this.sheet1_OnChange = sheet1_OnChange;
        this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
        this.doActionIBSheet = doActionIBSheet;
    }
    /* 개발자 작업    */
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    var loadingMode = false;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btn_Create":
                    doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;

                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;

        sheetObjects[0].ColHidden("cost_yrmon") = true;
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
            InsertItem(0, 'All' ,'');
            if (comboId == "f_trd_cd") {
                MaxLength = 3;
                ValidChar(2, 1);
            } else if (comboId == "f_rlane_cd") {
                MaxLength = 5;
                ValidChar(2, 1);
            }
            IMEMode = 0;
            DropHeight = 300;
            Index = 0;
        }
    }

    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(19) ;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(23, 0, 0, true);

                    //헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                    InitHeadMode(true, true, false, true, false, false);
                    var HeadTitle1 =  "S.Month|R.Month|R.Week|Trade|R.Lane|GROUP|VVD|Trade Dir.|BSA"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Fixed Expense"
                                   + "|Opertaion Variable Cost"
                                   + "|Opertaion Variable Cost"
                                   + "|Opertaion Variable Cost";
                    var HeadTitle2 =  "S.Month|R.Month|R.Week|Trade|R.Lane|GROUP|VVD|Trade Dir.|BSA"
                                   + "|Crew \nExpense"
                                   + "|Insurance"
                                   + "|Store Supply \nExpense"
                                   + "|Lubricant \nExpense"
                                   + "|Vessel \nM&R"
                                   + "|Depreciations"
                                   + "|Telecom \nExpense"
                                   + "|Other Operation \nFixed Exp"
                                   + "|Time \nCharterage"
                                   + "|Space \nCharterage"
                                   + "|Space \nCHT Revenue"
                                   + "|Port \nExpense"
                                   + "|Canal \nTransit Fee"
                                   + "|Bunker\nExpanse";

                    //          var HeadTitle = "TOTAL소계|소계용 머지 컬럼|"
                    //              + "Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Conti.|Port|Call IND|Call SEQ|Apply(%)"
                    //              + "|Port \nExpense"
                    //              + "|Canal \nTransit Fee"
                    //              + "|Port Days|Sea Days"
                    //              + "|Total Days"
                    //              + "|FO Cons.|Bunker"
                    //              + "|Crew \nExpense"
                    //              + "|Insurance"
                    //              + "|Lubricant \nExpense"
                    //              + "|Store Supply \nExpense"
                    //              + "|Vessel \nM&R"
                    //              + "|Depreciations"
                    //              + "|Telecom \nExpense"
                    //              + "|Other Operation \nFixed Exp"
                    //              + "|Time \nCharterage";

                    //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var cnt = 0;
                    //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
                    //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
                    //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
                    //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                    InitDataProperty(0, cnt++, dtData,    60,  daCenter, true,  "sls_yrmon",   false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    60,  daCenter, true,  "cost_yrmon",  false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,  daCenter, true,  "cost_wk",     false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    50,  daCenter, true,  "trd_cd",      false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,  daCenter, true,  "rlane_cd",    false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,  daCenter, true,  "lane_tp_cd",  false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    80,  daCenter, true,  "vvd",         false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    75,  daCenter, true,  "hul_bnd_cd",         false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    50,  daCenter, true,  "bsa",         false, "", dfNone);
                    //
                    InitDataProperty(0, cnt++, dtAutoSum, 75,  daRight,  false, "amt_01",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 75,  daRight,  false, "amt_02",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 75,  daRight,  false, "amt_03",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_04",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_05",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_06",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_07",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_08",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_09",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_10",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 100, daRight,  false, "amt_11",      false, "", dfFloat);
                    //
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_12",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_13",      false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtAutoSum, 85,  daRight,  false, "amt_14",      false, "", dfFloat);

                    CellBackColor(1,"amt_01") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_02") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_03") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_04") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_05") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_06") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_07") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_08") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_09") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_10") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_11") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_12") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_13") = RgbColor(184, 218, 231);
                    CellBackColor(1,"amt_14") = RgbColor(184, 218, 231);

                    CountPosition  = 0;
                    FrozenCols = 9;
                    WaitImageVisible = false;
                }
                break;
        }
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
    * IBSheet Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.SearchRows > 0) {
            // dtAutoSum의 속성으로 인하여 최하단 SUM row에 TOTAL이라는 글자가 첫컬럼에만 생성되므로
            //  강제로 두번째 컬럼에도 보여지게끔 setting
            //  (align속성에 맞게 글자가 정렬되지 않는 버그가 있으므로 align도 seetting)
            sheetObj.CellText(sheetObj.LastRow, "sls_yrmon") = "TOTAL";
            sheetObj.CellText(sheetObj.LastRow, "cost_yrmon") = "TOTAL";
            sheetObj.CellAlign(sheetObj.LastRow, "sls_yrmon") = daCenter;
            sheetObj.CellAlign(sheetObj.LastRow, "cost_yrmon") = daCenter;
        }
    }

    /**
      * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
      */
     function f_trd_cd_OnChange(obj,value,text) {
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
        formObj.f_cmd.value = SEARCHLIST10;
        var sXml = sheetObj.GetSearchXml("ESM_COA_0175GS.do", coaFormQueryString(formObj));
        var arrXml = sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
        formObj.f_rlane_cd.InsertItem(0, "All", "All");
        formObj.f_rlane_cd.Index = 0;

     }

    /**
    * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
    */
    function setPeriod(obj) {
        ComCoaSetPeriod1(obj);
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBCLEAR:          //조회
                formObj.f_cmd.value = INIT;
                var sXml = sheetObj.GetSearchXml("ESM_COA_0175GS.do", coaFormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
 
                formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
                formObj.f_fm_mon.value = formObj.f_to_mon.value = ComGetNowInfo("mm");
                formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon, 2, '0');
                formObj.f_to_mon.value = ComLpad(formObj.f_to_mon, 2, '0');
                formObj.f_fm_wk.value = formObj.f_to_wk.value = ComGetEtcData(arrXml[0],"prevWeek");
                setPeriod(formObj.f_to_wk);

                if (arrXml.length > 0)
                    ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "code");
                if (arrXml.length > 1)
                    ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");
              
                if (arrXml.length > 2) {
					ComXml2ComboItem(arrXml[2], formObj.f_op_lane_tp_cd, "code", "name");
					comboObjects[2].InsertItem(0, "Lane Avg U/C", "LA");
				}
                break;

            case IBSEARCH:      //조회
                if(!validateForm1(formObj)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESM_COA_0175GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                ComOpenWait(false);
                break;

            case IBCREATE:      //생성
                if(!validateForm1(formObj)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSearch4Post("ESM_COA_0175GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                var err_cd = sheetObj.EtcData("err_cd");
                var err_msg = sheetObj.EtcData("err_msg");

                if (err_cd == "00000") {
                    ComShowMessage(ComGetMsg('COA10018','CREATION'));
                }
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:   //엑셀 다운로드
            //sheetObj.Down2Excel(-1, false, false, true);
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
