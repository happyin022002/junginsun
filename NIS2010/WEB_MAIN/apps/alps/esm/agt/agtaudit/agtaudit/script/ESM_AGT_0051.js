// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
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

    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }

    // S/A Date Unit 날짜 세팅
    var formObj = document.form;
    var today = ComGetNowInfo();
    var frday = ComGetDateAdd(today, "D", -7);
    formObj.search_dt_fr.value = frday;
    formObj.search_dt_to.value = today;
    formObj.ar_ofc_cd.focus();
}

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

                style.height = GetSheetHeight(15);                                                      //높이 설정
                SheetWidth = mainTable1.clientWidth;                                                    //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                                                              //전체Merge 종류 [선택, Default msNone]
                Editable = true;                                                                        //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(1, 1, 9, 1000);                                                             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(11, 4, 0, true);                                                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, true, true, false, false);                                     //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle = "STS|CHK|No.|B/L No.|BKG No.|VVD|BKG Sts|BKG Ofc|BKG Date|Comm Cnt|Remarks";
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,   DATATYPE,  WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,30,   daCenter,   true,       "ibflag",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtCheckBox,  40,     daCenter,   true,       "check",    false,      "",         dfNone,     0,          true,       false);
                InitDataProperty(0, cnt++, dtSeq,       30,     daCenter,   true,       "seq",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bl_no",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bkg_no",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      80,     daCenter,   true,       "vvd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      55,     daCenter,   true,       "bkg_sts_cd",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    55,     daCenter,   true,       "bkg_ofc_cd",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      75,     daCenter,   true,       "bkg_cre_dt",  false,      "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      65,     daCenter,   true,       "agt_comm_cnt",  false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      300,    daLeft,     true,       "rsn",      false,      "",         dfNone,     0,          false,      false);
            }
            break;
        case 2:      //sheet2 init
            with (sheetObj) {

                style.height = GetSheetHeight(10);                                                      //높이 설정
                SheetWidth = mainTable2.clientWidth;                                                    //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                                                              //전체Merge 종류 [선택, Default msNone]
                Editable = false;                                                                       //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(2, 1, 9, 1000);                                                             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(27, 3, 0, true);                                                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, false, true, false, false);                                     //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle1 = "STS|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|PRE AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
                var HeadTitle2 = "STS|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|PRE AMT|Common1|Common2|BRKG|CHF|T/S|T/R|SOC|Cross|DOC|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,   DATATYPE,  WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,30,   daCenter,   true,       "ibflag",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtSeq,       30,     daCenter,   true,       "seq",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bl_no",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      90,     daCenter,   true,       "bkg_no",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      30,     daCenter,   true,       "io_bnd_cd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      80,     daCenter,   true,       "vvd",      false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,     daCenter,   true,       "port",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,     daCenter,   true,       "sail_arr_dt",   false,      "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      35,     daCenter,   true,       "ac_seq",    false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 70,     daRight,    true,       "pre_amt",   false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 65,     daRight,    false,      "comm1",  false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 65,     daRight,    false,      "comm2",  false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "brkg",     false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "chf",      false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "ts",       false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "tr",       false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "soc",      false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "cross",    false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 60,     daRight,    false,      "doc",      false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,     daRight,    true,       "usd_amt",   false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,     daRight,    true,       "ex_rate",   false,      "",         dfFloat,    4,          false,      false);
                InitDataProperty(0, cnt++, dtData,      40,     daCenter,   true,       "curr_cd",     false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,     daRight,    true,       "lcl_amt",   false,      "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtData,      45,     daCenter,   true,       "comm_proc_sts_cd",   false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      500,    daLeft,     true,       "comm_proc_sts_rsn",   false,      "",         dfNone,     0,          true,       false);
                InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,   true,       "ar_ofc_cd",  false,      "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    50,     daCenter,   true,       "agn_cd",    false,      "",         dfNone,     0,          false,      false);

                RangeBackColor(1,10,1,18) = RgbColor(222, 251, 248);   // Current AMT
            }
            break;
    }
}

/*
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject,formObj,IBSEARCH);
                break;

            case "btn_recalculate":
                doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
                break;

            case "btn_downexcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;

            case "btn_cal_fr":
            	var cal = new ComCalendar();
				 cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
                break;

            case "btn_cal_to":
            	var cal = new ComCalendar();
                cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
                break;

        } // end switch

    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage("COM12111", "", "");
        } else {
            ComShowMessage(e);
        }
    }
}

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //Retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = SEARCH;
            //alert("http://127.0.0.1:7001/hanjin/ESM_AGT_0051GS.do?" + agtQryStr(formObj));

            //alert("ESM_AGT_0051GS.do?" + agtQryStr(formObj));
            sheetObj.DoSearch4Post("ESM_AGT_0051GS.do", agtQryStr(formObj));

            sheetObj.SumText(0,1) = "";
            sheetObj.SumText(0,2) = "";
            sheetObj.SumText(0,3) = "TOTAL";

            //Status에 따른 색깔 표시
            var rows = sheetObj.RowCount;
            for (var i=0; i<rows; i++) {
                cnt = sheetObj.CellValue(i+1,"agt_comm_cnt");

                if (cnt == "0") {
                    sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
                }
            }

            var sheetObj2 = sheetObjects[1];
            sheetObj2.RemoveAll();

            break;

        case IBSEARCH_ASYNC02:  //Re-calculate
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = REPLY;
            sheetObj.DoSave("ESM_AGT_0051GS.do", agtQryStr(formObj));

            var sheetObj2 = sheetObjects[1];
            sheetObj2.RemoveAll();

            break;

        case IBDOWNEXCEL:   //Down Excel
            sheetObj.SpeedDown2Excel(-1);
            break;
    }
}

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet2(sheetObj,formObj,sAction) {
    var sheetObject2 = sheetObjects[1];
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //Retrieve
            formObj.f_cmd.value = SEARCHLIST;
            param = sheetObj.RowSaveStr(sheetObj.SelectRow);

            sheetObject2.DoSearch4Post("ESM_AGT_0051GS.do", agtQryStr(formObj) + param);

            sheetObject2.SumText(0,1) = "";
            sheetObject2.SumText(0,2) = "";
            sheetObject2.SumText(0,3) = "TOTAL";

            //Status에 따른 색깔 표시
            var rows = sheetObject2.RowCount;
            for (var i=0; i<rows; i++) {
                sts = sheetObject2.CellValue(i+2,"status");

                if (sts == "CE") {
                    sheetObject2.RowFontColor(i+2) = sheetObject2.RgbColor(255,0,0); //red
                } else if(sts == "RS" || sts == "RM") {
                    sheetObject2.RowFontColor(i+2) = sheetObject2.RgbColor(0,255,0); //green
                } else if(sts == "AS" || sts == "IF") {
                    sheetObject2.RowFontColor(i+2) = sheetObject2.RgbColor(0,0,255); //blue
                }
            }

            break;
    }
}

// sheet1을 더블클릭하여 sheet2를 상세조회한다.
function sheet1_OnDblClick(sheetObj, row, col) {
    var formObj = document.form;
    doActionIBSheet2(sheetObj,formObj,IBSEARCH);
}

/**
 * A/R Office를 변경하면, 해당 Subject Office를 다시 조회한다.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj1 = sheetObjects[0];
    var sheetObj2 = sheetObjects[1];

    //Grid Reset
    sheetObj1.RemoveAll();
    sheetObj2.RemoveAll();

    //Sub Office ComboBox Setting
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0051FR.do";
    formObj.submit();
}

/**
 * Subject Office를 변경하면, 그리드를 초기화한다.
 */
function agn_cd_OnChange(obj){
    var sheetObj1 = sheetObjects[0];
    var sheetObj2 = sheetObjects[1];

    //Grid Reset
    sheetObj1.RemoveAll();
    sheetObj2.RemoveAll();
}


/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function search_dt_fr_onfocus(obj){
    if (obj.value.length > 0) {
        delete_Char(obj,'-');   //입력값에서 '-'를 없앤다.
        obj.select();   //입력값을 전체선택한다.
    }
}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function search_dt_to_onfocus(obj){
    if (obj.value.length > 0) {
        delete_Char(obj,'-');   //입력값에서 '-'를 없앤다.
        obj.select();   //입력값을 전체선택한다.
    }
}

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다.
 */
function search_dt_fr_onchange(obj){
    var str = "";

    if (obj.value.length > 0) {
        str = delete_Char(obj.value,'-');
    }

    if (!ComIsDate(obj) && str.length != 0) {
        ComShowCodeMessage("COM12179", "", "", "");
        obj.focus();
    } else {
        if (str.length == 8) {
            obj.value = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
        }
    }
}

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다.
 */
function search_dt_to_onchange(obj){
    var str = "";

    if (obj.value.length > 0) {
        str = delete_Char(obj.value,'-');
    }

    if (!ComIsDate(obj) && str.length != 0) {
        ComShowCodeMessage("COM12179", "", "", "");
        obj.focus();
    } else {
        if (str.length == 8) {
            obj.value = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
        }
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//        if (!ComIsNumber(iPage)) {
//            return false;
//        }

        switch(sAction) {
            case IBSEARCH:  //Retrieve
                //alert("bl = " + bl.value + ",  selBlNo = " + selBlNo.value);
                if(s_bl_no.value == "" && bl_nos.value == "") {
                    ComShowCodeMessage("COM12113", "B/L", "", "");
                    s_bl_no.focus();
                    return false;
                }

                if(search_dt_fr.value.length > 0 && search_dt_to.value.length > 0 && search_dt_fr.value > search_dt_to.value){
                    //TO DATE must be greater than FROM DATE.
                    ComShowCodeMessage("COM12133", "End date", "start date", "greater");
                    search_dt_fr.focus();
                    return false;
                }

                break;

            case IBSEARCH_ASYNC02:  //Re-calculate
                //선택건수 체크
                var checkCnt = sheetObj.CheckedRows("check");
                if(checkCnt < 1){
                    //Please select **.
                    ComShowCodeMessage("COM12113", "row for re-calculate", "", "");
                    return false;
                }

                //200건이상 실행금지 체크
                if(checkCnt > 200){
                    //Please select **.
                    ComShowCodeMessage("COM12113", "under 200 B/Ls at a time when you re-calculate.", "", "");
                    return false;
                }

                break;

        }
    }

    return true;
}

