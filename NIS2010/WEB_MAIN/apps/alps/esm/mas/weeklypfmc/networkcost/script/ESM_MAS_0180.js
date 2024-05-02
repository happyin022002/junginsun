/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_MAS_0180.js
*@FileTitle : Re-Assignment by Bound(Internal Pricing)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.13
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.10.12 이행지
* 1.0 Creation
*=========================================================
* History
* 2010.10.22 이행지 [CHM-201006375-01][MAS] Trunk IPC와 Ocean간 내부거래 신규 추가
* 2011.02.21 김상수 [CHM-201108827-01] 1. R.month/Week 및 OPR/OPR2 정보 보여주는 컬럼 추가
*                                      2. Re-Assignment by bound, Re-Assignment by bound(OP4)
*                                         화면상에서 틀고정 기능 추가
*                                      3. js상의 validation함수 정리 및  coMas.js로 소스이동
* 2012.05.04 전윤주 [CHM-201217586] CNTR_TEU_QTY 컬럼 추가
* 2013.01.15 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
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
     * @class ESM_MAS_0180 : ESM_MAS_0180 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0180() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
    }

       /* 개발자 작업    */
    //공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":        //조회
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_Create":            //저장
                    doActionIBSheet(sheetObject,formObject,IBCREATE);
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_Downexcel":        //엑셀 다운로드
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
            }
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111", "", ""));
            } else {
                ComShowMessage(e);
            }
        }
    }

    function loadPage(){
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
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

    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:        //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(17) ;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    //헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                    InitHeadMode(true, true, false, true, false, false);
                    var HeadTitle =  "STS|S.Month|R.Month|R.Week|Trade|R.Lane|VVD|Load(TEU)|Load(BOX)|Unit Cost|Total Expense";

                    //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
                    //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
                    //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
                    //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                    var cnt = 0;
                    InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");
                    InitDataProperty(0, cnt++, dtData,   60, daCenter, true, "sls_yrmon");
                    InitDataProperty(0, cnt++, dtData,   60, daCenter, true, "cost_yrmon");
                    InitDataProperty(0, cnt++, dtData,   55, daCenter, true, "cost_wk");
                    InitDataProperty(0, cnt++, dtData,   80, daCenter, true, "trd_cd");
                    InitDataProperty(0, cnt++, dtData,   80, daCenter, true, "rlane_cd");
                    InitDataProperty(0, cnt++, dtData,   80, daCenter, true, "vvd");
                    InitDataProperty(0, cnt++, dtData,   80, daRight,  true, "cntr_teu_qty");
                    InitDataProperty(0, cnt++, dtData,   80, daRight,  true, "cntr_lod_qty");
                    InitDataProperty(0, cnt++, dtData,   80, daRight,  true, "inter_prc_uc_amt");
                    InitDataProperty(0, cnt++, dtData,  100, daRight,  true, "inter_prc_ttl_expn_amt");

                    WaitImageVisible = false;
                }
                break;
        }
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
            }
            IMEMode = 0;
            DropHeight = 300;
            Index = 0;
        }
    }

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

    function doActionIBSheet(sheetObj,formObj,sAction) {

        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBCLEAR:          //조회
                formObj.f_cmd.value = INIT;
                var sXml = sheetObj.GetSearchXml("ESM_MAS_0180GS2.do", masFormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                var prevWeek = "";
                if (0 < arrXml.length) {
                    ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
                    prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
                }
                if (1 < arrXml.length)
                    ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");

                formObj.f_year.focus();
                formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
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
                sheetObj.DoSearch4Post("ESM_MAS_0180GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBCREATE:      //생성
                if(!validateForm1(formObj)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSearch4Post("ESM_MAS_0180GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                var err_cd = sheetObj.EtcData("err_cd");
                var err_msg = sheetObj.EtcData("err_msg");

                if (err_cd == "00000") {
                    ComShowMessage(ComGetMsg('MAS10018','CREATION'));
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

    /**
    * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
    */
    function setPeriod(obj) {
       ComMasSetPeriod1(obj);
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
        if(srcName == "f_to_mon") {
            if( formObject.f_to_mon.value.length == 2 ){
                formObject.f_to_mon.select();
            }
        }
        if(srcName == "f_to_wk") {
            if( formObject.f_to_wk.value.length == 2 ){
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
        axon_event.addListenerForm('focusin',        'form_focusin',    formObject); //- 클릭시
    }

    /**
     * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
     */
     function f_seltrade_OnChange(obj,value,text) {
        var formObj = document.form;
        if ("All"!=value) {
            var sheetObj = sheetObjects[0];
            formObj.f_cmd.value = SEARCHLIST01;
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0180GS2.do", masFormQueryString(formObj));
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
    /* 개발자 작업  끝 */