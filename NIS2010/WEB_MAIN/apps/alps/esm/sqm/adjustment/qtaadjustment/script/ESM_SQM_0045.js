/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0045.js
*@FileTitle      : QTA Edit_Office Add
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.10
*@LastModifier   :
*@LastVersion    : 1.0
* 2013.12.10 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
function ESM_SQM_0045() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

/* 개발자 작업   */

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/**
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObj  = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObj,IBSEARCH);
                break;

            case "btn_Creation":
                doActionIBSheet(sheetObject,formObj,"Creation");
                break;

            case "btn_Close":
                window.close();
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

    /**
     * IBSheet Object 를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBSheet Object 를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     *  Load 시
     */
    function loadPage(){
        var formObj = document.form;
        loadingMode = true;

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
    function initCombo(comboObj, comboId) {
        switch(comboObj.id) {
            case "f_sub_trd_cd":
            default:
                with (comboObj) {
                    DropHeight = 300;
                    Index      = 0;
                }
                break;
        }
    }

    /**
     *  Sheet 설정
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:     //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(14) ;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle1 =  "STS|SEQ|Trade|R.Lane|Lane\nBound|RHQ|Office|Active| |bse_tp_cd|bse_yr|bse_qtr_cd|ofc_vw_cd|sub_trd_cd";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 12, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                    InitHeadMode(true, false, false, false, false, false);

                    //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                    InitDataProperty(0, cnt++,  dtStatus,      30, daCenter,   true,   "ibflag",       false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtSeq,         30, daCenter,   true,   "seq",          false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtData,        60, daCenter,   true,   "trd_cd",       false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtData,        80, daCenter,   true,   "rlane_cd",     false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtData,        60, daCenter,   true,   "dir_cd",       false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtData,        70, daCenter,   true,   "rhq_cd",       false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtData,       100, daCenter,   true,   "rgn_ofc_cd",   false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtCheckBox,    80, daCenter,   true,   "sqm_act_flg",  false,  "", dfNone,     0,  true,   false);
                    InitDataProperty(0, cnt++,  dtData,       100, daCenter,   true,   "",             false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtHidden,     100, daCenter,   true,   "bse_tp_cd",    false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtHidden,     100, daCenter,   true,   "bse_yr",       false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtHidden,     100, daCenter,   true,   "bse_qtr_cd",   false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtHidden,     100, daCenter,   true,   "ofc_vw_cd",    false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++,  dtHidden,     100, daCenter,   true,   "sub_trd_cd",   false,  "", dfNone,     0,  false,  false);
                }
                break;
        }
    }

    /**
     * Sheet 관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBCLEAR:          // 화면 접속 시
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);

                formObj.f_cmd.value = INIT;
                var sXml   = sheetObj.GetSearchXml("ESM_SQM_0045GS.do", FormQueryString(formObj));
                var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
                var arrXml = sXml.split("|$$|");

                if (arrXml.length > 0)
                    ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "name");
                if (arrXml.length > 1)
                    ComXml2ComboItem(arrXml[1], formObj.f_ias_rgn_cd, "code", "name");
                if (arrXml.length > 2)
                    ComXml2ComboItem(arrXml[2], formObj.f_rhq_cd, "code", "name");
                if (arrXml.length > 3)
                    ComXml2ComboItem(arrXml[3], formObj.f_dir_cd, "code", "name");

                ComOpenWait(false);
                break;

            case IBSEARCH:          //조회
                if (!validateForm(sheetObj, formObj, sAction)) {
                    return false;
                }

                formObj.f_cmd.value = SEARCH;
                searchParams = FormQueryString(formObj);
                sheetObj.DoSearch("ESM_SQM_0045GS2.do",searchParams);
                break;

            case "Creation":          //생성
                if (!validateForm(sheetObj, formObj, sAction)) return false;

                if (sheetObj.isDataModified == false) {
                    ComShowCodeMessage("SQM00006");
                    return false;
                } else if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
                    return false;
                }

                ComOpenWait(true);

                ComSetSearchParams("f_cmd", MULTI02);
                sheetObj.DoSave("ESM_SQM_0045GS2.do", searchParams, -1, false);

                ComOpenWait(false);

                var State = sheetObj.EtcData("TRANS_RESULT_KEY");
                if(State != "S"){
                    ComShowMessage(ComResultMessage(sXml));
                    return false;
                }else if(State == "S"){
                    ComShowCodeMessage('SQM00010','Data');

                    window.returnValue = "S"; // 메인화면의 재조회하기 위해 성공시 플래그를 넘김
                    window.close();
                }
                break;

        }
    }


    /**
     * onChange event
     *  f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
     */
    function f_sub_trd_cd_OnChange(obj, value, text) {
        var formObj  = document.form;

        if (value != "All") {
            var param = "f_cmd=" + SEARCH01
                      + "&code_name=rLane"
                      + "&code_param=IAS|" + value+ "|"+formObj.f_ias_rgn_cd.Code
                      + "&all_flag=";

            var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
            var arrXml = xmlStr.split("|$$|");
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");

            formObj.f_rlane_cd.Index = 0;
        } else {
            formObj.f_rlane_cd.RemoveAll();
            formObj.f_rlane_cd.InsertItem(0, "", "");
            formObj.f_rlane_cd.Index = 0;
        }
    }
 
    /**
     * onChange event
     *  f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
     */   
    function f_ias_rgn_cd_OnChange(obj, value, text) {
        var formObj  = document.form;
        var param = "f_cmd=" + SEARCH01
                  + "&code_name=rLane"
                  + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code + "|" + value
                  + "&all_flag=";

        var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
        var arrXml = xmlStr.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");

        formObj.f_rlane_cd.Index = 0;

    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){

        switch(sAction) {
            case IBSEARCH:
                var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
                var dir_cd       = ComGetObjValue(formObj.f_dir_cd);
                var rlane_cd        = ComGetObjValue(formObj.f_rlane_cd);
                var rhq_cd     = ComGetObjValue(formObj.f_rhq_cd);

                if ( sub_trd_cd == "" ) {
                    ComShowCodeMessage("SQM00013", "Sub Trade");
                    formObj.f_sub_trd_cd.focus();
                    return false;
                }

                if ( dir_cd == "" ) {
                    ComShowCodeMessage("SQM00013", "Lane Bound");
                    formObj.f_dir_cd.focus();
                    return false;
                }

                if ( rlane_cd == "" ) {
                    ComShowCodeMessage("SQM00013", "R/Lane");
                    formObj.f_rlane_cd.focus();
                    return false;
                }

                if ( rhq_cd == "" ) {
                    ComShowCodeMessage("SQM00013", "RHQ");
                    formObj.f_rhq_cd.focus();
                    return false;
                }

                break;
        }
        return true;
    }
/* 개발자 작업  끝 */