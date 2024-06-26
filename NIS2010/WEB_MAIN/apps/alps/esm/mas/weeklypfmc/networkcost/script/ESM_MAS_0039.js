/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0039.js
*@FileTitle : 구간별 운항일수 및 비율관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
 *=========================================================
 * History
 * 2009.10.23 김기대 New FrameWork 적용
 * 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
 * 2010.03.04 이행지 CHM-201002932 chkValidSearch메소드 수정-Week,Month체크시 해당부분만 체크하도록
 * 2010.04.14 이행지 FormQueryString =>masFormQueryString 변경
 * 2010.09.01 이일민 [CHM-201004982-01] MAS Architecture 위배사항 수정
 * 2011.03.02 김상수 [CHM-201109144-01] Lane Transit time 메뉴 개선
 *                                      - Lane Transit time 화면내의 Sheet에 OPR2(Operation) 칼럼추가
 *                                      - js상의 validation함수 정리 및  coMas.js로 소스이동
 *                                      - 멀티콤보및 html엘리먼트들의 입력규칙 추가보완
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_MAS_0039 : ESM_MAS_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0039() {
    this.processButtonClick = processButtonClick;
    this.setPeriod = setPeriod;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.setSheetObject = setSheetObject;
    this.doActionIBSheet = doActionIBSheet;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;


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

                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111", "", ""));
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
     */
      function f_seltrade_OnChange(obj,value,text) {
          var formObj = document.form;
          if ("All"!=value) {
               var sheetObj = sheetObjects[0];
               formObj.f_cmd.value = SEARCHLIST02;
               var sXml = sheetObj.GetSearchXml("ESM_MAS_0039GS2.do", masFormQueryString(formObj));
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
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
          ComMasSetPeriod1(obj);
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        for (k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k], comboObjects[k].id);
        }
        document.form.f_year.focus();
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
            } else {
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(14) ;
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);     //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msNone;                                        //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(19, 0, 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false, false);         //해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-WW|OPR2\n(Operation)|VSL CD|Voy.|Dir.|Continent|S.Lane|Trade|Rev.Lane|IOC|Loc.|Call Ind.|SEQ|Port Day|Sea Day|Total Days|Apply(%)|Remark";
                    InitHeadRow(0, HeadTitle, false);                           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,  30,   daCenter, true, "ibflag");
                    InitDataProperty(0, cnt++, dtData,    70,   daCenter, true, "cost_yrwk",        false, "",                     dfDateYm,   0, false, false);
                    InitDataProperty(0, cnt++, dtData,    75,   daCenter, true, "vop_cd",           false, "",                     dfDateYm,   0, false, false);
                    InitDataProperty(0, cnt++, dtData,    50,   daCenter, true, "vsl_cd",           false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    40,   daCenter, true, "skd_voy_no",       false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    30,   daCenter, true, "dir_cd",           false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    70,   daCenter, true, "conti_nm",         false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    50,   daCenter, true, "slan_cd",          false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    45,   daCenter, true, "trd_cd",           false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    65,   daCenter, true, "rlane_cd",         false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,  60,   daCenter, true, "ioc_cd",           false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    50,   daCenter, true, "loc_cd",           false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    55,   daCenter, true, "vsl_dbl_call_seq", false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,    30,   daCenter, true, "clpt_seq",         false, "",                     dfNone,     0, false, false);
                    InitDataProperty(0, cnt++, dtAutoSum, 70,   daRight,  true, "port_dys",         false, "",                     dfFloatOrg, 4);
                    InitDataProperty(0, cnt++, dtAutoSum, 70,   daRight,  true, "sea_dys",          false, "",                     dfFloatOrg, 4);
                    InitDataProperty(0, cnt++, dtAutoSum, 70,   daRight,  true, "ttl_tz_dys",       false, "|sea_dys|+|port_dys|", dfFloatOrg, 4, false, false);
                    InitDataProperty(0, cnt++, dtData,    65,   daCenter, true, "aply_voy_rto",     false, "",                     dfNone,     0);
                    InitDataProperty(0, cnt++, dtData,    1000, daLeft,   true, "vvd_rmk",          false, "",                     dfNone,     0);

                    CountPosition  = 0 ;
                    WaitImageVisible = false;

                }
                break;

        }
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.SearchRows > 0) {
            // dtAutoSum의 속성으로 인하여 최하단 SUM row에 TOTAL이라는 글자가 첫컬럼에만 생성되므로
            //  강제로 두번째 컬럼에 보여지게끔 setting
            sheetObj.CellText(sheetObj.LastRow, "ibflag") = "";
            sheetObj.CellText(sheetObj.LastRow, "cost_yrwk") = "TOTAL";
        }
    }

    /**
     * sea_dys, port_dys 데이터 변경시 음수일경우 Row의 색상을 변경시킨다.
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        if(sheetObj.ColSaveName(col) == "sea_dys" || sheetObj.ColSaveName(col) == "port_dys") {
            if(sheetObj.CellValue(row, "sea_dys") < 0 || sheetObj.CellValue(row, "port_dys") < 0){
                sheetObj.RowBackColor(row) = sheetObj.RgbColor(247, 231, 236);
            } else {
                // RgbColor(247, 231, 236)로 RowBackColor가 변경된 row라면 원래 BackColor로 되돌림
                sheetObj.RowBackColor(row) = sheetObj.UnEditableColor;
                sheetObj.CellBackColor(row, "port_dys") = sheetObj.EditableColor;
                sheetObj.CellBackColor(row, "sea_dys") = sheetObj.EditableColor;
                sheetObj.CellBackColor(row, "aply_voy_rto") = sheetObj.EditableColor;
                sheetObj.CellBackColor(row, "vvd_rmk") = sheetObj.EditableColor;
            }
        }
    }

    function sheet1_OnDblClick(sheetObj, row, col) {
        var vvd  = "";
        var classId = "COM_ENS_0B1";
        var param = "";

        vvd = sheetObj.CellValue(row, "vsl_cd")+sheetObj.CellValue(row, "skd_voy_no")+sheetObj.CellValue(row, "dir_cd");
        param = '?vvd_cd='+vvd+'&classId='+classId;
        ComOpenPopup("/hanjin/COM_ENS_0B1.do"+param, 630, 430, "", "0,0,1,1,1,1,1,1,1,1", true);
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBCLEAR:          //조회
                formObj.f_cmd.value = INIT;
                var sXml = sheetObj.GetSearchXml("ESM_MAS_0039GS2.do", masFormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
                if (arrXml.length > 1) ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
                if (arrXml.length > 2) ComXml2ComboItem(arrXml[2], formObj.f_seldir, "code", "name");
                if (arrXml.length > 3) ComXml2ComboItem(arrXml[3], formObj.f_selioc, "code", "name");

                formObj.f_year.value = ComGetNowInfo("yy");
                formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
                formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
                formObj.f_fm_wk.value = formObj.f_to_wk.value = ComGetEtcData(arrXml[0],"prevWeek");
                setPeriod(formObj.f_to_wk);
                break;

            case IBSEARCH:      //조회
                if(!validateForm1(formObj)) return false;
                ComOpenWait(true);
                if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
                if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
                if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
                if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch4Post("ESM_MAS_0039GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                if(!validateForm1(formObj)) return false;
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSave("ESM_MAS_0039GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
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
