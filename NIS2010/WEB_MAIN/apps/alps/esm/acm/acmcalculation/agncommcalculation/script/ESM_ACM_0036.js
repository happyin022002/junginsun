/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0036.js
*@FileTitle : FF Compensation CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.04 김영오
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
     * @class ESM_ACM_0036 : ESM_ACM_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0036() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1 = sheetObjects[0];
        var shtObj = sheetObjects[1];
        var frmObj = document.form;

        var srcName = window.event.srcElement.getAttribute("name");

        if (srcName != "btn2_bkg_no") {
            ACMMemoSheet_Close(memoShtObj1, frmObj.bkg_no);    // CoAcm.js에 정의
        }

        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;

            case "btn_downexcel":
                ComOpenWait(true);
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                ComOpenWait(false);
                break;

            case "btn_calculate":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;

            case "btn2_bkg_no":
                ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                break;

            case "chk_all":
                if (frmObj.chk_all.checked) {
                    frmObj.chk_comm_cmpn.checked = true;
                    frmObj.chk_fac.checked = true;
                    frmObj.chk_cmpn.checked = true;
                } else {
                    frmObj.chk_comm_cmpn.checked = false;
                    frmObj.chk_fac.checked = false;
                    frmObj.chk_cmpn.checked = false;
                }
                break;
        }
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {

                case "memo_sheet1":
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 200;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "||Seq|BKG No.|B/L No.|BKG STS|R.VVD|Last Calculation Date";


                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,    daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,     50,    daCenter,    false,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      50,    daCenter,    false,    "seq");
                    InitDataProperty(0, cnt++, dtData,         150,   daCenter,    false,    "bkg_no",        false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         150,   daCenter,    false,    "bl_no",         false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         100,   daCenter,    false,    "bkg_sts_cd",    false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         200,   daCenter,    false,    "rev_vvd_cd",    false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         200,   daCenter,    false,    "upd_dt",        false,    "",    dfNone,     0,   false,    false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    break;

                case "sheet2":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 200;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "|Seq|BKG No.|Bound|General|CHF|Charge|T/S|Brokerage|FAC|F/F Comp.|Special Comp.";


                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,    daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      50,    daCenter,    false,    "seq");
                    InitDataProperty(0, cnt++, dtData,         120,   daCenter,    false,    "bkg_no",        	false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         40,    daCenter,    false,    "io_bnd_cd",       false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "general_amt",     false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "chf_amt",    		false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "chg_comm_amt",    false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "ts_amt",        	false,    "",    dfNone,     0,   false,    false);
					InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "brog_amt",    	false,    "",    dfNone,     0,   false,    false);
					
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "fac_amt",    		false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "ff_amt",    		false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    false,    "spcl_amt",        false,    "",    dfNone,     0,   false,    false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:    // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
				
            case IBSEARCH:    // 조회            
				if (frmObj.ar_ofc_cd.value == "") {
                    ComShowCodeMessage("COM130201", "[Office]");    // Please input {?msg1}.
                    return;
				}
				if (frmObj.agn_cd.value == "") {
                    ComShowCodeMessage("COM130201", "[Sub Office]");    // Please input {?msg1}.
                    return;
				}
                if (frmObj.bkg_no.value == "") {
                    ComShowCodeMessage("COM130201", "[BKG No]");    // Please input {?msg1}.
                    shtObj.SelectCell(1, 1);
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0036GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
				
				doActionIBSheet(shtObj, document.form, SEARCH02);
                break;

            case IBSAVE:    // Calculate
                if (!frmObj.chk_comm_cmpn.checked  && !frmObj.chk_fac.checked && !frmObj.chk_cmpn.checked) {
                    ComShowCodeMessage("COM12114", "Calculate Condition.");    // Please check {?msg1}
                    ComSetFocus(frmObj.chk_comm_cmpn);
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0036GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
							
            case SEARCH02:    // 조회
                if (frmObj.bkg_no.value == "") {
                    ComShowCodeMessage("COM130201", "[BKG No]");    // Please input {?msg1}.
                    shtObj.SelectCell(1, 1);
                    return;
                }
				
                
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH02;
                sheetObjects[2].DoSearch("ESM_ACM_0036GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    }

    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
	 
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
	
	
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];
        with (document.form) {
            switch (elementName) {

                case "ar_ofc_cd":
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (agn_cd.options.length > 1) {
                            // ar_ofc_cd와 같은 값이 선택되게 함
                            agn_cd.value = ar_ofc_cd.value;
                        }
                    }
                    break;
            }
        }
    }

    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }

    /**
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet1_OnClick(shtObj, row, col, value) {
        //doActionIBSheet(shtObj, document.form, SEARCH02);
    }

/* 개발자 작업 끝 */
