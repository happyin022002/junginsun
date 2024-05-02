/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0074.js
 *@FileTitle : S/C Boiler Plate Creation - Excel Import
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.06
 *@LastModifier : 서호열
 *@LastVersion : 1.0
 * 2009.07.06 서호열
 * 1.0 Creation
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
     * @class ESM_PRI_0074 : ESM_PRI_0074 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0074() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1;

    var errFlg = false; // Check 버튼동작후 flag 값 세팅

    var vOpener = window.dialogArguments;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김대호
     * @version 2009.12.01
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_new":
                    sheetObject1.RemoveAll();
                    ComBtnDisable("btn_check");
                    break;

                case "btn_openfile":
                    sheetObject1.WaitImageVisible = false;
                    sheetObject1.LoadExcel(-1);
                    sheetObject1.Editable = true;
                    ComBtnEnable("btn_check");
                    ComBtnDisable("btn_save");
                    break;

                case "btn_save":
                    if(!ComIsBtnEnable("btn_save")) {
                        return false;
                    }else {
                        if(validateForm(sheetObject1, formObject, IBSAVE)){
                            ComOpenWait(true);
                            doActionIBSheet(sheetObject1, formObject, IBSAVE);
                            ComOpenWait(false);
                        }
                    }
                    break;

                case "btn_check":
                    if(validateForm(sheetObject1, formObject, IBSEARCH)) {
                        ComOpenWait(true);
                        doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                        ComOpenWait(false);
                    }
                    break;

                case "btn_close":
                    vOpener.doActionIBSheet(vOpener.sheetObjects[0],vOpener.form,vOpener.IBSEARCH)
                    window.close();
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김대호
     * @version 2009.12.01
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김대호
     * @version 2009.12.01
     */
    function loadPage() {
        sheet1 = sheetObjects[0];
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        ComBtnDisable("btn_check");
        ComBtnDisable("btn_save");
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김대호
     * @version 2009.12.01
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 452;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 14, 100);

                    var HeadTitle = "|Seq.|Title|Content|prop_no|amdt_seq|blpl_seq|prc_prog_sts_cd|src_info_cd|dp_seq|blpl_tit_nm|n1st_cmnc_amdt_seq|blpl_ctnt_seq|blpl_ctnt|dp_seq2";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          30,     daCenter,   false,  "Seq");
                    InitDataProperty(0, cnt++ , dtData,         130,    daLeft,     false,  "Title",              false,        "",     dfNone,     0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,         200,    daLeft,     false,  "Content",            false,        "",     dfNone,     0,  true,   true);

                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "prop_no",            false,        "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "amdt_seq",           false,        "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "blpl_seq",           false,        "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "prc_prog_sts_cd",    false,        "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "src_info_cd",        false,        "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "dp_seq",             false,        "",     dfNone,     0,  false,  false); //PriSpBlplVO변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "blpl_tit_nm",        false,        "",     dfNone,     0,  false,  false); //PriSpBlplVO변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "n1st_cmnc_amdt_seq", false,        "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "blpl_ctnt_seq",      false,        "",     dfNone,     0,  false,  false); //PriSpBlplCtntVO변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "blpl_ctnt",          false,        "",     dfNone,     0,  false,  false); //PriSpBlplCtntVO변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "dp_seq2",            false,        "",     dfNone,     0,  false,  false); //PriSpBlplCtntVO변수

                    CountPosition = 0;
                }
                break;

            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 11, 100);

                    var HeadTitle = "|Seq.|Title|Content|prop_no|amdt_seq|blpl_seq|prc_prog_sts_cd|src_info_cd|n1st_cmnc_amdt_seq|dp_seq|blpl_tit_nm";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          30,     daCenter,   false,  "Seq");
                    InitDataProperty(0, cnt++ , dtData,         130,    daLeft,     false,  "Title",            false,      "",     dfNone,     0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,         100,    daLeft,     false,  "Content",          false,      "",     dfNone,     0,  true,   true);

                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "prop_no",          false,      "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "amdt_seq",         false,      "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "blpl_seq",         false,      "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "prc_prog_sts_cd",  false,      "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "src_info_cd",      false,      "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "n1st_cmnc_amdt_seq",       false,      "",     dfNone,     0,  false,  false); //공통변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "dp_seq",           false,      "",     dfNone,     0,  false,  false); //PriSpBlplVO변수
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daLeft,     false,  "blpl_tit_nm",      false,      "",     dfNone,     0,  false,  false); //PriSpBlplVO변수

                    CountPosition = 0;
                }
                break;

        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @return 없음
     * @author 김대호
     * @version 2009.12.01
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSAVE:        //저장
                formObj.f_cmd.value = MULTI;
                var sParam = FormQueryString(formObj);
                var sParam2 = "";
                var sParamSheet1 = sheetObjects[0].GetSaveString();
                var bBtm = "";
                var bBs = "";

                if (sParamSheet1 != "") {

                    for(i = 1; i<=sheetObjects[0].RowCount;i++){

                        if( bBtm != sheetObjects[0].CellValue(i,"blpl_tit_nm")
                                && bBs != sheetObjects[0].CellValue(i,"blpl_seq") ){
                            sParam += "&sheet1_ibflag="+sheetObjects[0].RowStatus(i);
                            sParam += "&sheet1_prop_no="+sheetObjects[0].CellValue(i,"prop_no");
                            sParam += "&sheet1_amdt_seq="+sheetObjects[0].CellValue(i,"amdt_seq");
                            sParam += "&sheet1_blpl_seq="+sheetObjects[0].CellValue(i,"blpl_seq");
                            sParam += "&sheet1_prc_prog_sts_cd="+sheetObjects[0].CellValue(i,"prc_prog_sts_cd");
                            sParam += "&sheet1_src_info_cd="+sheetObjects[0].CellValue(i,"src_info_cd");
                            sParam += "&sheet1_dp_seq="+sheetObjects[0].CellValue(i,"dp_seq");
                            sParam += "&sheet1_blpl_tit_nm="+sheetObjects[0].CellValue(i,"blpl_tit_nm");
                            sParam += "&sheet1_n1st_cmnc_amdt_seq="+sheetObjects[0].CellValue(i,"n1st_cmnc_amdt_seq");
                        }

                        sParam2 += "&sheet2_ibflag="+sheetObjects[0].RowStatus(i);
                        sParam2 += "&sheet2_prop_no="+sheetObjects[0].CellValue(i,"prop_no");
                        sParam2 += "&sheet2_amdt_seq="+sheetObjects[0].CellValue(i,"amdt_seq");
                        sParam2 += "&sheet2_blpl_seq="+sheetObjects[0].CellValue(i,"blpl_seq");
                        sParam2 += "&sheet2_prc_prog_sts_cd="+sheetObjects[0].CellValue(i,"prc_prog_sts_cd");
                        sParam2 += "&sheet2_src_info_cd="+sheetObjects[0].CellValue(i,"src_info_cd");
                        sParam2 += "&sheet2_n1st_cmnc_amdt_seq="+sheetObjects[0].CellValue(i,"n1st_cmnc_amdt_seq");
                        sParam2 += "&sheet2_blpl_ctnt_seq="+sheetObjects[0].CellValue(i,"blpl_ctnt_seq");
                        sParam2 += "&sheet2_blpl_ctnt="+sheetObjects[0].CellValue(i,"blpl_ctnt");
                        sParam2 += "&sheet2_dp_seq="+sheetObjects[0].CellValue(i,"dp_seq2");

                        bBtm = sheetObjects[0].CellValue(i,"blpl_tit_nm");
                        bBs = sheetObjects[0].CellValue(i,"blpl_seq");
                    }
                }

                //데이터합치기
                sParam = sParam + sParam2;
                var sXml = sheetObj.GetSaveXml("ESM_PRI_0074GS.do", sParam);
                sheetObjects[0].LoadSaveXml(sXml);
                break;

        }
    }

    /**
     * sheet1 정보를 BD에 반영후 발생하는 sheet1_OnSaveEnd 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트
     * @param  {string} ErrMsg : 에러 메세지
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.12.07
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
        if (ErrMsg == "") {
            ComPriSaveCompleted();
            vOpener.doActionIBSheet(vOpener.sheetObjects[0],vOpener.form,vOpener.IBSEARCH)
            window.close();
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * validateForm(sheetObj, document.form, sAction)
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수
     * @return 없음
     * @author 김대호
     * @version 2009.12.01
     */
    function validateForm(sheetObj, formObj, sAction) {

        switch (sAction) {

            case IBSEARCH: // 체크

                // 오류셀 색지정
                var color = sheetObj.RgbColor(255, 0, 0); // 빨강
                // 오류데이터 체크
                var check = 0;
                // 이전타이틀네임
                var bTitleNm = "";

                // MAX blplSeq값
                var mBlplSeq = parseInt(formObj.blplSeq.value, 10);

                // MAX blplSeq값
                var mDpSeq = parseInt(formObj.dpSeq.value, 10);

                // blpl_seq
                var blplSeq = 1;

                // dp_seq
                var dpSeq = 1;
                // Cnt테이블dp_seq
                var dpSeq2 = 1;

                // blpl_ctnt_seq
                var blplCtntSeq = 1;

                if (!sheetObjects[0].IsDataModified) {
                    ComShowCodeMessage("PRI00312");
                    return false;
                }

                // 초기색지정-흰색
                for ( var i = 0; i < sheetObj.RowCount; i++) {
                    sheetObj.RowBackColor(i + 1) = sheetObj.RgbColor(255, 255, 255);
                }

                for ( var i = 0; i < sheetObj.RowCount; i++) {
                    // prop_no 세팅
                    sheetObj.CellValue2(i + 1, "prop_no") = formObj.propNo.value;

                    // amdt_seq 세팅
                    sheetObj.CellValue2(i + 1, "amdt_seq") = formObj.amdtSeq.value;

                    if (sheetObj.CellValue(i + 1, "Title") == "") {
                        sheetObj.CellBackColor(i + 1, "Title") = color;
                        check++;
                    }
                    // 타이틀네임세팅
                    sheetObj.CellValue2(i + 1, "blpl_tit_nm") = sheetObj.CellValue(i + 1, "Title");

                    if (sheetObj.CellValue(i + 1, "Content") == "") {
                        sheetObj.CellBackColor(i + 1, "Content") = color;
                        check++;
                    }

                    // 컨텐츠네임세팅
                    sheetObj.CellValue2(i+1, "blpl_ctnt") = sheetObj.CellValue(i + 1, "Content");

                    if (bTitleNm == "" && blplSeq == 1) {

                        bTitleNm = sheetObj.CellValue(i + 1, "Title");
                        blplSeq = blplSeq + mBlplSeq;
                        dpSeq = dpSeq + mDpSeq;

                    } else if (bTitleNm != "") {
                        if (bTitleNm != sheetObj.CellValue(i + 1, "Title")) {
                            blplSeq = blplSeq + 1;
                            dpSeq = dpSeq + 1;
                            blplCtntSeq = 1;
                            dpSeq2 = 1;

                        } else if (bTitleNm == sheetObj.CellValue(i + 1, "Title")) {
                            blplCtntSeq++;
                            dpSeq2++;
                        }
                    }

                    // blpl_seq 세팅
                    sheetObj.CellValue2(i + 1, "blpl_seq") = blplSeq;

                    // blpl_ctnt_seq 세팅
                    sheetObj.CellValue2(i + 1, "blpl_ctnt_seq") = blplCtntSeq;

                    // 이전타이틀 세팅
                    bTitleNm = sheetObj.CellValue(i + 1, "Title");

                    // prc_prog_sts_cd 세팅
                    sheetObj.CellValue2(i + 1, "prc_prog_sts_cd") = "I";

                    // src_info_cd 세팅
                    sheetObj.CellValue2(i + 1, "src_info_cd") = "NW";

                    // dp_seq 세팅
                    sheetObj.CellValue2(i + 1, "dp_seq") = dpSeq;

                    sheetObj.CellValue2(i + 1, "dp_seq2") = dpSeq2;

                    // n1st_cmnc_dt 세팅
                    sheetObj.CellValue2(i + 1, "n1st_cmnc_amdt_seq") = formObj.amdtSeq.value;

                }

                if (check > 0) {
                    errFlg = true;
                    ComBtnDisable("btn_save");
                    return false;
                } else {
                    errFlg = false;
                    // 모든셀 readonly 처리할것
                    sheetObj.Editable = false;
                    ComBtnEnable("btn_check");
                    ComBtnEnable("btn_save");
                }

                break;

            case IBSAVE: // 체크

                // 오류데이터 체크
                var check = 0;
                var check2 = 0;

                if (formObj.propNo.value == "" || formObj.amdtSeq.value == "") {
                    ComShowCodeMessage('PRI01055');
                    check++;
                }

                for ( var i = 0; i < sheetObj.RowCount; i++) {
                    if (sheetObj.CellValue(i + 1, "blpl_seq") == "") {
                        check2++;
                    }
                }

                if (check > 0) {
                    ComBtnDisable("btn_save");
                    return false;
                } else if (check2 > 0) {
                    ComShowCodeMessage('PRI01058');
                    ComBtnDisable("btn_save");
                    return false;
                } else {
                    // 모든셀 readonly 처리할것
                    sheetObj.Editable = false;
                    ComBtnEnable("btn_save");
                }
                break;

        }

        return true;
    }

    /**
     * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event function <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {Long} Row 필수 해당 셀의 Row Index
     * @param {Long} Col 필수 해당 셀의 Column Index
     * @param {Integer} KeyCode 필수 키보드의 아스키 값
     * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @return 없음
     * @author 김대호
     * @version 2009.12.22
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (errFlg && KeyCode == 9) {
            while (true) {
                if (Col > sheetObj.LastCol) {
                    Row++;
                    Col = 1;
                }
                if (Row > sheetObj.LastRow) {
                    Row = sheetObj.HeaderRows;
                }
                if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255,0,0)) {
                    sheetObj.SelectCell(Row, Col, true);
                    break;
                }
                Col++;
            }
        }
    }

    /* 개발자 작업  끝 */