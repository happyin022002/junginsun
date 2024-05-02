/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0044.js
*@FileTitle : Allocate Slot-cost By HJS VS Slot-release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================
* History
* 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.03.05 이행지 CHM-201002932 chkValidSearch메소드 수정-Week,Month체크시 해당부분만 체크하도록
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 이일민 [CHM-201004982-01] COA Architecture 위배사항 수정
* 2011.02.21 김상수 [CHM-201108827-01] 1. R.month/Week 및 OPR/OPR2 정보 보여주는 컬럼 추가
*                                      2. Re-Assignment by bound, Re-Assignment by bound(OP4)
*                                         화면상에서 틀고정 기능 추가
*                                      3. js상의 validation함수 정리 및  coCoa.js로 소스이동
* 2013.01.16 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정                                       
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_COA_0044 : ESM_COA_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
    function ESM_COA_0044() {
        this.processButtonClick = processButtonClick;
        this.loadPage = loadPage;
        this.initControl = initControl;
        this.initSheet = initSheet;
        this.setSheetObject = setSheetObject;
        this.setPeriod = setPeriod;
        this.sheet1_OnChange = sheet1_OnChange;
        this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
        this.doActionIBSheet = doActionIBSheet;
    }

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
    var fYear = "";

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 설  명 : 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <b>Example : </b>
     * <pre>
     *    processButtonClick()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function processButtonClick() {
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
     * 설  명 :  Sheet 기본 설정 및 초기화 <br>
     *          body 태그의 onLoad 이벤트핸들러 구현<br>
     *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     * <br><b>Example : </b>
     * <pre>
     *     loadPage()
     * </pre>
     * @param
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
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

        initControl();

        sheetObjects[0].ColHidden("cost_yrmon") = true;
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
            if (comboId == "f_seltrade") {
                MaxLength = 3;
                ValidChar(2, 1);
            } else if (comboId == "f_selrlane") {
                MaxLength = 5;
                ValidChar(2, 1);
            } else if (comboId == "f_selioc") {
                MaxLength = 1;
                ValidChar(2, 0);
            }
            IMEMode = 0;
            DropHeight = 300;
            Index = 0;
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
     * 설  명 :  시트 초기설정값, 헤더 정의 <br>
     *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
     * <br><b>Example : </b>
     * <pre>
     *     initSheet(sheetObj,sheetNo,tpszValue)
     * </pre>
     * @param {object}    sheetObj - Sheet Object
     * @param {Number}    sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
     * @param {String}    Trade  - Trade
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
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
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(36, 0, 0, true);

                    //헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle    = "TOTAL소계|소계용 머지 컬럼"
                                    + "|S.Month|R.Month|R.Week|OPR\n(Operaion)|OPR2\n(Owner)"
                                    + "|Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir.|VSL Class|Conti.|Port|Call IND|Call SEQ|Apply(%)"
                                    + "|Port\nExpense"
                                    + "|Canal\nTransit Fee"
                                    + "|Port Days|Sea Days"
                                    + "|Total Days"
                                    + "|FO Cons.|Bunker"
                                    + "|Crew\nExpense"
                                    + "|Insurance"
                                    + "|Lubricant\nExpense"
                                    + "|Store Supply\nExpense"
                                    + "|Vessel\nM&R"
                                    + "|Depreciations"
                                    + "|Telecom\nExpense"
                                    + "|Other Operation \nFixed Exp"
                                    + "|Time\nCharterage";

                    //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
                    //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
                    //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
                    //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                    var cnt = 0;
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, true,  "totsum_code",      false, "", dfNone);
                    InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, true,  "subsum_code",      false, "", dfNone);

                    InitDataProperty(0, cnt++, dtData,    60,   daCenter, true,  "sls_yrmon",        false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    60,   daCenter, true,  "cost_yrmon",       false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,   daCenter, true,  "cost_wk",          false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    70,   daCenter, true,  "vop_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    70,   daCenter, true,  "vsl_oshp_cd",      false, "", dfNone);

                    InitDataProperty(0, cnt++, dtData,    50,   daCenter, true,  "trd_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,   daCenter, true,  "rlane_cd",         false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    40,   daCenter, true,  "ioc_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    60,   daCenter, true,  "vsl_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    50,   daCenter, true,  "skd_voy_no",       false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    40,   daCenter, true,  "dir_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    75,   daCenter, true,  "hul_bnd_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    60,   daCenter,  false, "vsl_clss_capa",    false, "", dfInteger);

                    InitDataProperty(0, cnt++, dtData,    60,   daCenter, false, "conti_nm",         false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,   daCenter, false, "loc_cd",           false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    60,   daCenter, false, "vsl_dbl_call_seq", false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    60,   daCenter, false, "clpt_seq",         false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData,    55,   daRight,  false, "aply_voy_rto",     false, "", dfFloatOrg);

                    InitDataProperty(0, cnt++, dtData,    75,   daRight,  false, "amt_01",           false, "", dfInteger);
                    InitDataProperty(0, cnt++, dtData,    75,   daRight,  false, "amt_02",           false, "", dfInteger);

                    InitDataProperty(0, cnt++, dtData,    65,   daRight,  false, "port_dys",         false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    65,   daRight,  false, "sea_dys",          false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    65,   daRight,  false, "ttl_tz_dys",       false, "", dfFloat);

                    InitDataProperty(0, cnt++, dtData,    75,   daRight,  false, "amt_13",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    75,   daRight,  false, "amt_03",           false, "", dfFloat);

                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_04",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_05",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_06",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_07",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_08",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_09",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_10",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    100,  daRight,  false, "amt_11",           false, "", dfFloat);
                    InitDataProperty(0, cnt++, dtData,    85,   daRight,  false, "amt_12",           false, "", dfFloat);

                    CellBackColor(0,"amt_01") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_02") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_03") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_04") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_05") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_06") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_07") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_08") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_09") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_10") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_11") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_12") = RgbColor(184, 218, 231);
                    CellBackColor(0,"amt_13") = RgbColor(184, 218, 231);

                    CountPosition  = 0 ;
                    FrozenCols = 15;
                    WaitImageVisible = false;
                }
                break;
        }
    }

    /**
     * 설  명 : IBSheet Object를 배열로 등록 <br>
     *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *         배열은 소스 상단에 정의<br>
     * <b>Example : </b>
     * <pre>
     *    setComboObject(sheet_obj)
     *    </pre>
     * @param {object}    sheet_obj - Sheet Object
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * 설  명 : Sheet관련 프로세스 처리 <br>
     * <br><b>Example : </b>
     * <pre>
     *     doActionIBSheet(sheetObj,formObj,sAction)
     * </pre>
     * @param {object}    sheetObj - Sheet Object
     * @param {form}    formObj  - From Object
     * @param {String}    sAction  - 프로세스 종류
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBCLEAR:          //조회
                formObj.f_cmd.value = INIT;

                var sXml = sheetObj.GetSearchXml("ESM_COA_0044GS2.do", coaFormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                var prevWeek = "";
                if (0 < arrXml.length) {
                    ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
                    prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
                    fYear = ComGetEtcData(arrXml[0], "fYear"); 
                }
                if (1 < arrXml.length)
                    ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
                if (2 < arrXml.length)
                    ComXml2ComboItem(arrXml[2], formObj.f_selioc, "code", "name");

                formObj.f_year.focus();
                formObj.f_year.value = fYear;
                formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
                formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
                formObj.f_fm_wk.value = formObj.f_to_wk.value = prevWeek;
                setPeriod(formObj.f_to_wk);
                break;

            case IBSEARCH:      //조회
                if(!validateForm1(formObj)) return false;
                ComOpenWait(true);
                if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
                if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
                if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
                if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');

                formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESM_COA_0044GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
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

    /**
     * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
     */
     function f_seltrade_OnChange(obj,value,text) {
        var formObj = document.form;
        if ("All"!=value) {
            var sheetObj = sheetObjects[0];
            formObj.f_cmd.value = SEARCHLIST01;
            var sXml = sheetObj.GetSearchXml("ESM_COA_0044GS2.do", coaFormQueryString(formObj));
            var arrXml = sXml.split("|$$|");
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "name");
            formObj.f_selrlane.Index = 0;
        } else {
            formObj.f_selrlane.RemoveAll();
            formObj.f_selrlane.InsertItem(0, "All", "All");
            formObj.f_selrlane.Index = 0;
        }
    }

    /**
    * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
    */
    function setPeriod(obj) {
        ComCoaSetPeriod1(obj);
    }

    /**
     * 설  명 : 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트 <br>
     * <br><b>Example : </b>
     * <pre>
     *     sheet1_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {object}    sheetObj - sheet
     * @param {String}    errMsg  - 조회 후 메시지
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var cols = "amt_01|amt_02|sea_dys|port_dys|ttl_tz_dys|amt_13|amt_03|amt_04|amt_05|amt_06|amt_07|amt_08|amt_09|amt_10|amt_11|amt_12";
        sheetObj.ShowSubSum(0, cols, -1, true, false, 1, "2=TOTAL;3=TOTAL");
        sheetObj.ShowSubSum(1, cols, -1, true, false, 1, "2=SUB;3=SUB");
    }

    /**
     * 설  명 : Form Object Event - Focusin <br>
     * <br><b>Example : </b>
     * <pre>
     *     form_focusin()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function form_focusin(){
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
        if (srcName == "f_to_mon") {
            if (formObject.f_to_mon.value.length == 2) {
                formObject.f_to_mon.select();
            }
        } else if (srcName == "f_to_wk") {
            if (formObject.f_to_wk.value.length == 2) {
                formObject.f_to_wk.select();
            }
        }
    }

    /**
     * 설  명 :페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     *
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function initControl() {
        var formObject = document.form;
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm("focusin", "form_focusin", formObject); //- 클릭시
    }
