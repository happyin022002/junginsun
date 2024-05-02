/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3014.js
*@FileTitle : TRI Creation & Amendment - Publication
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.11.30 박성수
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3014() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업 */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var uploadObjects = new Array();
    var uploadCnt = 0;

    var bIsReqUsr = false;
    var bIsAproUsr = false;

    var beforeIndex = -1;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 박성수
     * @version 2009.05.01
     */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

        var sheetObject1 = sheetObjects[0];

        /** **************************************************** */
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }

            switch (srcName) {

                case "btn_delete":
                    doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
                    break;

                case "btn_send":
                    doActionIBSheet(sheetObjects[0], document.form, IBLOADEXCEL);
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
                    break;

                case "btn_close":
                    window.close();
                    break;

            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
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
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 박성수
     * @version 2009.05.01
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     setUploadObject(uploadObj);
     * </pre>
     * @param {ibupload} uploadObj 필수, IBUpload Object
     * @return 없음
     * @author 문동규
     * @version 2009.12.29
     **/
    function setUploadObject(uploadObj) {
        uploadObjects[uploadCnt++] = uploadObj;
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
     * @author 박성수
     * @version 2009.05.01
     */
    function loadPage() {

        for (i = 0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
            ComEndConfigSheet(sheetObjects[i]);
        }

        //UPLOAD 환경 설정
        for ( var i = 0; i < uploadObjects.length; i++) {
            //1. 기본 환경 설정
            ComConfigUpload(uploadObjects[i], "/hanjin/ESM_PRI_3014GS.do");

            //2. Upload 초기화
            //initUpload(uploadObjects[i],i+1);
        }
        uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DELETE_NO";
        try {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * initSheet(sheetObj, 1);
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 박성수
     * @version 2009.05.01
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {

        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 320;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                var HeadTitle = "|Sel.|Seq.|Tariff Code|Tariff Rate Item\n(TRI)|Current\nStatus|Commodity|Route|Route|Route|Route|Rate to be\nDeleted|Rate Basis|Per|Cargo\nType|Cur.|Rate|Note|Effective\nDate|Expiration\nDate|tri_prop_no|amdt_seq";
                var HeadTitle1 = "|Sel.|Seq.|Tariff Code|Tariff Rate Item\n(TRI)|Current\nStatus|Commodity|Origin|Origin Via|Dest Via|Dest|Rate to be\nDeleted|Rate Basis|Per|Cargo\nType|Cur.|Rate|Note|Effective\nDate|Expiration\nDate|tri_prop_no|amdt_seq";
                var headCount = ComCountHeadTitle(HeadTitle);

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 6, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                InitHeadRow(1, HeadTitle1, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "chk", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "trf_cd", false, "", dfNone, 0, false, false)
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "tri_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cur_status", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 130, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "org_rout_pnt_loc_nm_snd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "org_rout_via_port_nm_snd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "dest_rout_via_port_nm_snd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "dest_rout_pnt_loc_nm_snd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rt_deleted", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rt_basis", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prop_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 250, daLeft, true, "note_ctnt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "tri_prop_no", false, "", dfNone);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "amdt_seq", false, "", dfNone);

                WaitImageVisible = false;
                AutoRowHeight = true;
                ShowButtonImage = 2;
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
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 박성수
     * @version 2009.05.01
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
         try {
             if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                 ComOpenWait(true);
             }
            sheetObj.ShowDebugMsg = false;
            switch (sAction) {

                case IBSEARCH: // 조회
                    ComOpenWait(true);
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    var sXml = dialogArguments.getSheetXml(0);
                    sheetObjects[0].LoadSearchXml(sXml);
                    sheetObjects[0].CheckAll("chk") = 0
                    ComOpenWait(false);
                    break;

                case IBDELETE: // 삭제
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    if (!ComPriConfirmDelete()) {
                        return false;
                    }

                    if (sheetObj.CheckedRows("chk") <= 0) {
                        sheetObj.RowDelete(sheetObj.SelectRow, false);
                    } else {
                        var iCheckRow = sheetObj.FindCheckedRow("chk");
                        var arrRow = iCheckRow.split("|");

                        for (var i = arrRow.length-2, n = 0 ; i >= n ; i--) {
                            sheetObj.RowDelete(arrRow[i], false);
                        }
                    }
                    break;

                case IBLOADEXCEL: // Down Excel, Upload Excel, Send Mail
                    ComOpenWait(true);
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    if (!ComShowCodeConfirm("PRI00118")) {
                        return false;
                    }
                    var dt = new Date();
                    var tm = dt.getYear()+ComLpad((dt.getMonth()+1),2,"0")+ComLpad(dt.getDate(), 2, "0")+ComLpad(dt.getHours(), 2, "0")+ComLpad(dt.getMinutes(), 2, "0")+ComLpad(dt.getSeconds(), 2, "0")+ComLpad(dt.getMilliseconds(), 3, "0");

//                    var excelname = "C:\\Windows\\Temp\\TRI_LIST_"+tm+".xls";
                    var excelname = "C:\\temp\\TRI_LIST_"+tm+".xls";

                    // 1. Excel Download
                    sheetObj.Down2Excel(-1, false, false, true, excelname, "", false, false, "", false, "chk");
//                    sheetObj.Down2Excel(-1, false, false, true, excelname, "apps/alps/esm/pri/triproposal/triproposal/script/ESM_PRI_3014.xml", false, false, "", false, "chk");

                    // 2. Excel Upload
                    // IBUpload에 파일 추가하기
                    var upObj = uploadObjects[0];
                    upObj.Files = ""; // 먼저 기존파일을 모두 지운후 추가함
                    upObj.AddFile(excelname);
                    formObj.f_cmd.value = MULTI;
                    //3.Sheet Data 와 Form Data QueryString으로 묶기
                    var sParam = sheetObj.GetSaveString(true);
                    sParam += "&" + FormQueryString(formObj);

                    //3.저장조건으로 저장실행
                    upObj.ExtendParam = sParam; //param값 추가
                    upObj.ParamDecoding = true;
                    var sXml = upObj.DoUpload(true);

                    //4.저장후 결과처리
                    if (sXml.length > 0) {
                        sheetObj.LoadSaveXml(sXml);
                    }
                    ComOpenWait(false);
                    break;

                case IBDOWNEXCEL: // Down
                    ComOpenWait(true);
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    // 1. Excel Download
                    sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                    ComOpenWait(false);
                    break;

            }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 저장 완료 후 로직을 실행 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2010.04.20
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            dialogArguments.reloadRate();
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 박성수
     * @version 2009.05.01
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {

            case IBSEARCH: //
                break;

            case IBDELETE: //
                if (sheetObj.RowCount == 0) {
                    ComShowCodeMessage("PRI00011");
                    return false;
                }
                break;

            case IBLOADEXCEL: //
            case IBDOWNEXCEL: //
                if (sheetObj.RowCount == 0) {
                    ComShowCodeMessage("PRI00018");
                    return false;
                }
                break;
        }
        return true;
    }
