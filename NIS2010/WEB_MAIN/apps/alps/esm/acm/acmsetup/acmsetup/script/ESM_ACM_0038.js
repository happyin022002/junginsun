/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0038.js
*@FileTitle : Other Feederage Deduction Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 김원녕
*@LastVersion : 1.0
* 2015.03.17 김원녕
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
     * @class ESM_ACM_0038 : ESM_ACM_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0038() {
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
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_retrieve":     // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;

                case "btn_downexcel":    // Down Excel
                    ComOpenWait(true);
                    shtObj.SpeedDown2Excel(-1);
                    ComOpenWait(false);
                    break;
                    
                case "btn_uploadexcel":
                    if (!ComChkValid(frmObj)) return;//조건절 office 설정 여부 체크
                    shtObj.LoadExcel();
                    break;

                case "btn_add":           // Row Add
                    var newRowIdx = shtObj.DataInsert();
                    break;

            } // end switch

        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
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
        var cnt = 0;

        with (shtObj) {

            // 높이 설정
            style.height = 375;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(2, 1, 13, 500);
            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, false, true, false, false);

            // 컬럼 헤더타이틀
            var HeadTitle0  = "STS|SEQ|POL|POD|Container\nTP/SZ|Deduction\nAmount|Effective Date|Effective Date|Delete Flag";
            var HeadTitle1  = "STS|SEQ|POL|POD|Container\nTP/SZ|Deduction\nAmount|From|To|Delete Flag";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle0, true);
            InitHeadRow(1, HeadTitle1, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,       40,     daCenter,    true,    "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,    "seq");
            InitDataProperty(0, cnt++, dtPopupEdit,    120,    daCenter,    true,    "pol_cd",           true,     "",    dfNone,    0,    false,    true,    5,    true);
            InitDataProperty(0, cnt++, dtPopupEdit,    120,    daCenter,    true,    "pod_cd",           true,     "",    dfNone,    0,    false,    true,    5);
            InitDataProperty(0, cnt++, dtPopup,        120,    daCenter,    true,    "cntr_tpsz_cd",     true,     "",    dfNone,    0,    true,    true,     4);
            InitDataProperty(0, cnt++, dtData,         120,    daCenter,    true,    "ddct_amt",         true,     "",    dfFloat,   3);
            InitDataProperty(0, cnt++, dtData,         145,    daCenter,    false,   "fm_eff_dt",        false,    "",    dfDateYmd,  0,	   false,    true);
            InitDataProperty(0, cnt++, dtData,         145,    daCenter,    false,   "to_eff_dt",        false,     "",   dfDateYmd,  0,	   false,    true);
            InitDataProperty(0, cnt++, dtCombo,    	   30,     daCenter,    true,    "delt_flg");


            // 입력제한
            InitDataValid(0, "pol_cd", vtEngUpOnly);    // 영대문자만
            InitDataValid(0, "pod_cd", vtEngUpOnly);    // 영대문자만
            InitDataCombo(0, "delt_flg", "Y|N", "Y|N", "N");


            ShowButtonImage = 3;
            WaitImageVisible = false;
            HeadRowHeight = 18;
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
    	axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
		axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form); 
		axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0038GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:         // 저장
                if (!shtObj.IsDataModified) {
                    ComShowCodeMessage("COM130503");
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0038GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 RHQ Select Object 생성
//         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
     
     /**
      * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event<br>
      * @param {shtObj} String : 해당 IBSheet Object
      */
//     function sheet1_OnLoadExcel(shtObj) {
//         var rows = shtObj.RowCount + 2;
//         var tmp_ofc_cd = document.form.ar_ofc_cd.value;
//
//         for(var i=2; i<rows; i++) {
//             shtObj.CellValue2(i, "fac_ofc_cd") = tmp_ofc_cd; // 조회 조건의 Office를 fac_ofc_cd로 설정한다.
//         }
//     }


    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "pol_cd":
                	// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0113.do", 970, 455, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "pod_cd":
                	// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0113.do", 970, 455, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "cntr_tpsz_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0102.do?flag=Y", 742, 300, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
                    
            }
        }
    }


    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	
            	switch (ColSaveName(Col)) {
                
            	case "cntr_tpsz_cd":
            		CellValue(Row, Col) = aryPopupData[0];
                    break;
                    
            	case "pol_cd":
            	case "pod_cd":
            		CellValue(Row, ColSaveName(Col) + "_1") = aryPopupData[1];
                    CellValue(Row, ColSaveName(Col) + "_2") = aryPopupData[2];
                    CellValue(Row, ColSaveName(Col) + "_3") = aryPopupData[3];
                    CellValue(Row, ColSaveName(Col) + "_4") = aryPopupData[4];
                    CellValue(Row, ColSaveName(Col) + "_lvl_cd") = aryPopupData[0];
                    CellValue(Row, Col) = aryPopupData[aryPopupData[0]];
            		break;
                    
            	default:
            		CellValue2(Row, Col) = aryPopupData[0][3];
            		break;

                }
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



/* 개발자 작업 끝 */
