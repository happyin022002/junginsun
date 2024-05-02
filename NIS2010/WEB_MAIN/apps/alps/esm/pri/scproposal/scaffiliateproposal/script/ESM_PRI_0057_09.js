/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ESM_PRI_0057_09.js (ESM_PRI_0025 참조)
 * @FileTitle : Amendment History Inquiry - Affiliate Company
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.09.15
 * @LastModifier : 김대호
 * @LastVersion : 1.0
 * 2009.09.15 김대호
 * 1.0 Creation
 * 
 * 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
 * 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직(컬럼 추가만 함. 별도 화면에서 체크 없음)
=========================================================*/
    /**
     * @fileoverview Amendment History Inquiry - Affiliate Company 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends Pri
     * @class ESM_PRI_0057_09:ESM_PRI_0057_09 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

    /** 
     * @extends
     * @class ESM_PRI_0057_09 : ESM_PRI_0057_09 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0057_09() {
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.processButtonClick     = processButtonClick;
        this.doActionIBSheet        = doActionIBSheet;
    }

    // ===================================================================================
    // 전역변수
    // ===================================================================================
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1;

    var comboObjects = new Array();
    var comboCnt = 0;
    // 업무전역변수
    // ===================================================================================
    // 페이지 초기화
    // ===================================================================================

    /**
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.15
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.15
     */
    function loadPage() {
        var form = document.form;
        sheet1 = sheetObjects[0];
        sheetCnt = sheetObjects.length ;
        //IBSheet 초기화
        for (i = 0 ; i < sheetCnt ; i++) {
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }

        loadSts = true;
        sheet1.WaitImageVisible = false;
        parent.loadTabPage();
        sheet1.WaitImageVisible = true;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.15
     */
    function initSheet(sheetObj, sheetNo) {
        var form = document.form;
        var cnt = 0;
        var sheetID = sheetObj.id;

        var amdt_seq = document.form.amdt_seq.value;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                    //높이 설정
                    style.height = 320;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7, 100);
                    var HeadTitle1 = "Seq.|propno|amdtseq|afilseq|Customer code|Customer code|Mannual Input|Type|Customer Name|Address|Location|Effective Date|Effective Date|Source|Status|||||||";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성     ROW , COL   ,DATATYPE      ,WIDTH,DATAALIGN,COLMERGE,SAVENAME       ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++, dtDataSeq,   35,  daCenter, false, "seq");
                    InitDataProperty(0, cnt++, dtHidden,    90,  daLeft,   false, "prop_no",          false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    90,  daLeft,   false, "amdt_seq",         false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    90,  daLeft,   false, "afil_seq",         false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,      35,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, false, false,  2, true);
                    InitDataProperty(0, cnt++, dtData,      70,  daCenter, true,  "cust_seq",         false, "", dfNone,    0, false, false,  6);
                    InitDataProperty(0, cnt++, dtCheckBox,  90,  daCenter, true,  "mnl_inp_flg",      false, "", dfNone,    0, false, false);
                    
                    InitDataProperty(0, cnt++, dtData,      80, daCenter,   true,  "rvis_cntr_cust_tp_nm",          false, "", dfNone,    0, false, false,  100);
                    
                    InitDataProperty(0, cnt++, dtData,      200, daLeft,   true,  "cust_nm",          false, "", dfNone,    0, false, false,  100);
                    InitDataProperty(0, cnt++, dtData,      220, daLeft,   true,  "cust_addr",        false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,      70,  daCenter, true,  "cust_loc_cd",      false, "", dfNone,    0, false, false,  5);
                    InitDataProperty(0, cnt++, dtData,      70,  daCenter, true,  "eff_dt",           false, "", dfDateYmd, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,      70,  daCenter, true,  "exp_dt",           false, "", dfDateYmd, 0, false, false);
                    InitDataProperty(0, cnt++, dtCombo,     60,  daCenter, false, "src_info_cd",      false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtCombo,     60,  daCenter, false, "prc_prog_sts_cd",  false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    80,  daCenter, false, "prc_prog_sts_dtl", false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    100, daCenter, false, "acpt_usr_id",      false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    100, daCenter, false, "acpt_ofc_cd",      false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    100, daCenter, false, "acpt_dt",          false, "", dfDateYmd, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,    40,  daCenter, true,  "cust_cnt_cd_tmp",  false, "", dfNone,    0, true,  false,  2);
                    InitDataProperty(0, cnt++, dtHidden,    85,  daCenter, true,  "cust_seq_tmp",     false, "", dfNone,    0, true,  false,  6);
                    InitDataProperty(0, cnt++, dtHidden,    100, daCenter, false, "n1st_cmnc_amdt_seq",false,"", dfNone,    0, false, false);

                    InitDataCombo(0, "src_info_cd",     infoCdComboText, infoCdComboValue);
                    InitDataCombo(0, "prc_prog_sts_cd", stsCdComboText,  stsCdComboValue);

                    Ellipsis = true;
                    CountPosition = 0;      // Total 없음.
                    WaitImageVisible = false;
                }
                break;

        }
    }

    //===================================================================================
    //버튼 이벤트 처리
    //===================================================================================
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.15
     */
    function processButtonClick(){
        var form = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheet1, form, IBSEARCH);
                    break;

            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    //===================================================================================
    //Axson Event Handler
    //===================================================================================
    //===================================================================================
    //UI Object Event Handler
    //===================================================================================
    //===================================================================================
    //서버 조회/저장
    //===================================================================================
    /**
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.15
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH: //조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH01;
                sheet1.DoSearch("ESM_PRI_0057_09GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;

        }
    }

    /**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sConChk 필수 Conversion check 값
     * @return 없음
     * @author 김대호
     * @version 2009.05.21
     */
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
        var form = document.form;
        if (form.prop_no.value != sPropNo || form.svc_scp_cd.value != sSvcScpCd || form.amdt_seq.value != sAmdtSeq) {
            form.prop_no.value = sPropNo;
            form.amdt_seq.value = sAmdtSeq;
            form.svc_scp_cd.value = sSvcScpCd;
            form.lgcy_if_flg.value = sLgcyIfFlg;
            form.con_flg.value = sConChk;

            getManualCheck();

            doActionIBSheet(sheet1, form, IBSEARCH);
        }
    }

    /**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2009.05.20
     */
    function tabClearSheet() {
        var formObject = document.form;
        formObject.prop_no.value = "";
        formObject.amdt_seq.value = "";
        formObject.svc_scp_cd.value = "";
        sheet1.RemoveAll();
    }

    var loadSts = false;
    // 메인에서 호출한다.
    /**
     * parent 화면에서 탭 화면이 Frame에 Load 되었는지 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *      loadFinishCheck()
     * </pre>
     * @param 없음
     * @return bool  loadSts  <br>
     *              true  : load 완료
     *              false : load 미완료
     * @author 공백진
     * @version 2009.05.20
     */
    function loadFinishCheck() {
        return loadSts;
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.05.20
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        var sCols = "";
        searchEndFontChange(sheetObj, sCols, document.form.lgcy_if_flg.value);
        columnControl();
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell (sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet의 해당 Sel을 클릭 시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        var colname = sheetObj.ColSaveName(Col);
        var readOnly = true;
        switch (colname) {
            case "cust_nm":
            case "cust_addr":
                ComShowMemoPad(sheetObj, Row, Col, readOnly, 450, 80);
                break;
        }
    }

    /**
     * Sheet 컬럼의 edit 여부를 지정하는  function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *      columnControl
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function columnControl() {
        var mnChk = document.form.mnl_chk.value;
        if (mnChk == 'N') {
            sheet1.ColHidden("mnl_inp_flg") = false;
        } else {
            sheet1.ColHidden("mnl_inp_flg") = true;
        }
    }

    /**
     * SVC Scope이 TAW/TAE/ASE/ASW 이 아닌 경우가 하나라도 있을 경우 Mannual Input 칼럼을<br>
     * 숨기기위하여 값을 가져오는 함수<br>
     * form load 시 호출한다.
     * <pre>
     *     getManualCheck();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */
    function getManualCheck() {
        var formObj = document.form;
        formObj.f_cmd.value = SEARCH;
        var sXml = sheet1.GetSearchXml("ESM_PRI_0025GS.do", FormQueryString(formObj));
        var arrData = ComPriXml2Array(sXml, "mnl_inp_flg");
        if (arrData != null && arrData.length > 0) {
            formObj.mnl_chk.value = arrData[0][0];
        }
    }