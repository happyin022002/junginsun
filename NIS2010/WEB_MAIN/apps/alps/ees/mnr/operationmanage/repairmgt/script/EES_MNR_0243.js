/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0243.js
*@FileTitle : EDI & Excel Estimate Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.23 장준우
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.09.09 김상수 [CHM-201113395-01] EDI & Excel Estimate Upload 팝업화면에서 Excel업로드 직후 Qty가 2개 이상일 경우
*                                      Hour를 [Qty * Hour]로 연산하여 표기하고 Cell배경색이 다르게 보이도록 수정
* 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
* 2011.11.15 김상수 [CHM-201114526-01] SPP UPLOAD 데이터 CNTR# 단위로 처리
*                                      - time out error로 인하여, EQ_NO별로 순차적 Transaction이 되도록 기능변경
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Excel Upload 직후 MST에서 EQ No 존재유무 확인 로직 추가
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2012.01.30 김상수 [CHM-201215889-01] Repair SPP Upload 화면 로직 변경 요청
*                                      - 엑셀로 업로드 받은 Hour와 Material은 Qty가 1이상일 경우 Hour*Qty, Material*Qty로 계산해서 업로드
* 2012.02.03 신혜정 [CSR선처리] Material*Qty 항목 삭제, Amount = Cost + Material
* 2012.02.10 김상수 [CSR선처리] Repair SPP Upload 화면 수정
*                                      - 엑셀로 업로드시 Hour의 Validation 로직 제거 (Hour가 0이더라도 Process진행 가능)
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가
*                                    - 그리드내 'Hour*Qty' 컬럼 삭제. 'Hour','Rate','Material' 필수 항목 제외 처리.   
* 2013.10.02 조경완 [CHM-201326905-01] [자체개선] SPP Repair Estimate Creation 기능 보완                     
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
     * @class EES_MNR_0243 : EES_MNR_0243 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0243() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

    /* 개발자 작업	*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var sheetComboList = new Array();    

var MNR_DISABLE_BACK_COLOR = 15723503;
//Confirm 처리된 결과
var vComplexPK = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject  = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            case "btn_loadExcel":
                doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                break;

            case "btns_DownFile":
                sheetObject2.Down2Excel();
                break;

            case "btn_Save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;

            case "btn_close":
                if (vComplexPK != "") {
                    ComOpenWait(true);
                    //모달창에서 window.open 호출시 세션이 끊기는 경우 모달리스로 변경
                    var opener = window.dialogArguments;
                    opener.callbackUploadConfirm(vComplexPK);
                    ComOpenWait(false);
                }
                self.close();
                break;
                
			case "btn_calc": // Calculation				
					doActionIBSheet(sheetObject, formObject, IBBATCH);	
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * IBCombo Object를 배열로 등록
     * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다.
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        ComBtnDisable("btn_Save");
        ComBtnDisable("btn_calc");
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
                    // 높이 설정
                    style.height = 310;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Seq||EQ No|Estimate No|Damage Date|Currency|EDI ID|Off-Hire|Location|Component|Damage|Repair|Division|Type|Qty|Size/Square|Hour * Qty|Hour|Rate|Cost|Material|Material * Qty|Amount|Verify Result|Verify Result"
                    var headCount = ComCountHeadTitle(HeadTitle)

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 9, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,      35,     daCenter,    true,     "seq_no");
                    InitDataProperty(0, cnt++ , dtHidden,       80,     daCenter,    false,    "complex_pk");
                    InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,    "rqst_eq_no",         true,     "",    dfNone,       0,    false,    false,     14);
                    InitDataProperty(0, cnt++ , dtData,         90,     daCenter,    false,    "rqst_ref_no",        true,     "",    dfNone,       0,    false,    false,     20);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "eq_dmg_dt",          true,     "",    dfDateYmd,    0,    false,    false,     8);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    false,    "curr_cd",            true,     "",    dfNone,       0,    false,    false,     3);
                    InitDataProperty(0, cnt++ , dtData,         75,     daCenter,    false,    "edi_id",             true,     "",    dfNone,       0,    false,    false,     20);
                    InitDataProperty(0, cnt++ , dtCombo,        55,     daCenter,    false,    "rpr_offh_flg",       false,    "",    dfNone,       0,    false,    false,     1);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    false,    "eq_loc_cd",          true,     "",    dfNone,       0,    false,    false,     4);
                    InitDataProperty(0, cnt++ , dtData,         85,     daCenter,    false,    "eq_cmpo_cd",         true,     "",    dfNone,       0,    false,    false,     3);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    false,    "eq_dmg_cd",          true,     "",    dfNone,       0,    false,    false,     2);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    false,    "eq_rpr_cd",          true,     "",    dfNone,       0,    false,    false,     2);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    false,    "trf_div_cd",         false,    "",    dfNone,       0,    false,    false,     2);
                    InitDataProperty(0, cnt++ , dtCombo,        70,     daCenter,    false,    "vol_tp_cd",          true,     "",    dfNone,       0,    false,    false,     1);
                    InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "rpr_qty",            false,    "",    dfInteger);
                    InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "rpr_sz_no",          false,    "",    dfInteger);
                    InitDataProperty(0, cnt++ , dtHidden,         80,     daRight,     false,    "disp_rpr_lbr_hrs",   false,     "",    dfFloat,      2,    false,    true);
                    InitDataProperty(0, cnt++ , dtData,       80,     daRight,     false,    "rpr_lbr_hrs",        false,    "",    dfFloat,      2,    false,    false); // Hour
                    InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "rpr_lbr_rt",         false,     "",    dfFloat,      2,    false,    true); // Rate
                    InitDataProperty(0, cnt++ , dtData,         80,     daRight,     false,    "lbr_cost_amt",       false,    "",    dfNullFloat,  2,    false,    false); // Cost
                    InitDataProperty(0, cnt++ , dtData,         100,    daRight,     false,    "mtrl_cost_amt", false,     "",    dfFloat,      2,    false,    true); // Material
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daRight,     false,    "disp_mtrl_cost_amt",      false,    "",    dfFloat,      2,    false,    false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daRight,     false,    "mnr_wrk_amt",        false,    "",    dfNullFloat,  2,    false,    false);
                    InitDataProperty(0, cnt++ , dtHidden,       30,     daCenter,    false,    "edi_err_cd");
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,    false,    "edi_err_nm");

                    // SELECT 로우 배경색
                    MultiSelection = true;
                    // 선택시 볼드 사용하지 않음
                    CountPosition = 0;

                    CountFormat = "[SELECTDATAROW / TOTALROWS]";
                    InitDataCombo(0, "rpr_offh_flg", "Y|N", "Y|N");
                    InitDataCombo(0, "vol_tp_cd", "Qty|Size|Square", "Q|Z|S");

                    WaitImageVisible = false;
                    ScrollTrack = true;
                    RequestTimeOut = 36000;
               }
               break;

            case 2:      // sheet2 init - (hidden) 엑셀 양식 다운로드용
                with (sheetObj) {

                    Visible  = false;
                    // 높이 설정
                    style.height = 310;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "EQ No|Estimate No|Damage Date|Currency|EDI ID|Off-Hire|Location|Component|Damage|Repair|Type|Qty|Size/Square|Hour|Rate|Material"
                    var headCount = ComCountHeadTitle(HeadTitle)

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, true, true, false,false)

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true, true);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "rqst_eq_no");
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "rqst_ref_no");
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "eq_dmg_dt");
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "edi_id");
                    InitDataProperty(0, cnt++, dtData,    60,     daCenter,    false,    "rpr_offh_flg");
                    InitDataProperty(0, cnt++, dtData,    70,     daCenter,    false,    "eq_loc_cd");
                    InitDataProperty(0, cnt++, dtData,    85,     daCenter,    false,    "eq_cmpo_cd");
                    InitDataProperty(0, cnt++, dtData,    70,     daCenter,    false,    "eq_dmg_cd");
                    InitDataProperty(0, cnt++, dtData,    70,     daCenter,    false,    "eq_rpr_cd");
                    InitDataProperty(0, cnt++, dtData,    70,     daCenter,    false,    "vol_tp_cd");
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "rpr_qty");
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "rpr_sz_no");
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "rpr_lbr_hrs"); // hour
                    InitDataProperty(0, cnt++, dtData,    80,     daCenter,    false,    "rpr_lbr_rt");
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "mtrl_cost_amt");

                    var rowIdx = DataInsert(-1);
                    WaitImageVisible = false;

               }
               break;
        }
    }


    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBLOADEXCEL:    // Load Excel
                with (sheetObj) {
                    ComOpenWait(true);

                    LoadExcel(-1, 1, "", -1, -1, "", false, false, "");

                    if (GetSaveString(false, true) != "") {
                        ReDraw = false;

                        // 무효데이터 제거
                        for (var i=LastRow; i>=HeaderRows; i--) {
                            if (CellValue(i, "rqst_eq_no") == "" || CellValue(i, "rqst_ref_no") == "" || CellValue(i, "eq_dmg_dt") == "" || CellValue(i, "curr_cd") == "" ||
                                CellValue(i, "edi_id") == "" || CellValue(i, "eq_loc_cd") == "" || CellValue(i, "eq_cmpo_cd") == "" || CellValue(i, "eq_dmg_cd") == "" ||
                                CellValue(i, "eq_rpr_cd") == "" || CellValue(i, "vol_tp_cd") == "" || CellValue(i, "rpr_lbr_hrs") == "" || CellValue(i, "rpr_lbr_rt") == "" || CellValue(i, "mtrl_cost_amt") == "") {

                                RowDelete(i, false);
                            }
                        }

                        vComplexPK = "";
                        formObj.f_cmd.value = SEARCH;
                        var EqErrRowNo = 0;
                        var invalidErrRowNo = 0;
                        // 기능상 SEARCH에 해당하나, Sheet내용을 전송해야하므로 DoSave를 사용 (EQ_NO검증)
                        DoSave("EES_MNR_0243GS.do", FormQueryString(formObj), -1, false);

                        // ColBackColor setting
                        setColBackColor(sheetObj);
                        ColBackColor("edi_err_nm") = MNR_DISABLE_BACK_COLOR;

                        var rprLbrHrs = ""; // Hour
                        var rprLbrRt = ""; // Rate
                        var dispMtrlCostAmt = ""; // Material
                        
                        for (var i=HeaderRows; i<=LastRow; i++) {
                        	rprLbrHrs = CellValue(i, "rpr_lbr_hrs");
                        	rprLbrRt = CellValue(i, "rpr_lbr_rt");
                        	dispMtrlCostAmt = CellValue(i, "disp_mtrl_cost_amt");	
                        	
                            // 기본 Validation
                            if (CellValue(i, "rpr_qty") == 0 && CellValue(i, "rpr_sz_no") == 0) {
                                if (invalidErrRowNo == 0) {invalidErrRowNo = i;}
                                CellValue2(i, "edi_err_nm") = "Qty or Size/Square Not Found!";
                                errRowSetColor(sheetObj, i);
                            }else if((rprLbrHrs == 0.00 && rprLbrRt != 0.00) || (rprLbrHrs != 0.00 && rprLbrRt == 0.00)){
                            	// hour, rate 는 한개라도 값이 있으면, 모두 값을 넣게.(Calculation)
                                if (invalidErrRowNo == 0) {invalidErrRowNo = i;}
                                CellValue2(i, "edi_err_nm") = "Hour or Rate Not Found!";
                                errRowSetColor(sheetObj, i);

                            } else {
                                // EQ_NO검증 결과
                                if(CellValue(i, "edi_err_cd") == "UE") {
                                    if (EqErrRowNo == 0) {EqErrRowNo = i;}
                                    errRowSetColor(sheetObj, i);
                                }

                            }
                        }

                        ReDraw = true;
                        ComOpenWait(false);
                        if (EqErrRowNo > 0) {
                            SelectCell(EqErrRowNo, "edi_err_nm", false);
                            ComShowCodeMessage("MNR00294", "Estimate Upload");
                        } else if (invalidErrRowNo > 0) {
                            SelectCell(EqErrRowNo, "edi_err_nm", false);
                        } else {
                            ComBtnEnable("btn_calc");
                        }
                    } else {
                        ComOpenWait(false);
                    }
                }
                break;

            case IBSAVE:         // Confirm
                ComOpenWait(true);
                if (!validateForm(sheetObj, formObj, sAction)) {
                    ComOpenWait(false);
                    return;
                }
                ComBtnDisable("btn_Save");
                formObj.f_cmd.value = MULTI;
                var fParam = FormQueryString(formObj) + "&";
                var sParam = "";
                var sXml = new Array();    // 결과xml
                var err = false;           // error여부
                var errStartRow = 0;       // error 발생을 대비하서 시작row를 setting
                var errFirstRow = 0;       // 첫error 시작row를 setting
                var errXml = "";           // error 발생시 결과xml을 임시로 setting

                with (sheetObj) {
                    ReDraw = false;
                    // EQ No.가 같은 row를 한 전송query로 묶음
                    for (var i=HeaderRows; i<=LastRow; i++) {
                        // error 발생을 대비하서 시작row를 setting
                        if (sParam == "") {errStartRow = i;}
                        // row data수집
                        sParam += (RowSaveStr(i) + "&");

                        // 끝라인이거나 다음 eq_no가 다를때
                        if (i == LastRow || CellValue(i, "rqst_eq_no") != CellValue(i + 1, "rqst_eq_no")) {
                            var kk = sXml.length;
                            // query를 전송
                            var tmpXml = GetSaveXml("EES_MNR_0243GS.do", fParam + sParam);
                            sParam = "";    // 전송query 초기화

                            if (MnrComGetErrMsg(tmpXml) == null) {
                                if (kk == 0) {
                                    vComplexPK = ComGetEtcData(tmpXml, "complex_pk");
                                } else {
                                    vComplexPK += (", " + ComGetEtcData(tmpXml, "complex_pk"));
                                }
                                // array에 결과xml을 setting
                                sXml[kk] = tmpXml;

                            } else {    // error message가 별견되면
                                err = true;
                                // error가 발생한 row들(동일 eq_no단위)을 xml로 변환하여 결과xml에 setting
                                sXml[kk] = getRowSearchXml(sheetObj, errStartRow, i);
                                // 첫 error row no. 와 첫 error message만 수집
                                if (errFirstRow == 0 && errXml == "") {
                                    errFirstRow = errStartRow;
                                    errXml = tmpXml;
                                }
                            }
                        }
                    }

                    // 전송이 완료 되었으면 sheet clear
                    RemoveAll();
                    RemoveEtcData();
                    // sheet에 sXml array내용 load (에러row들 포함)
                    for (var j=0; j<sXml.length; j++) {
                        LoadSearchXml(sXml[j], true);    // append
                    }

                    // ColBackColor setting
                    setColBackColor(sheetObj);
                    ColBackColor("edi_err_nm") = RgbColor(206, 255, 255);

                    // sheet에 load된 row를 edi_err_cd에 따라 색변경
                    var confirmScssCount = 0;    // Confirm 성공 Count
                    var confirmErrCount = 0;     // Confirm 실패 Count
                    var confirmErrRow = 0;       // Confirm 실패 첫 row no.
                    for (var i=HeaderRows; i<=LastRow; i++) {
                        if(CellValue(i, "edi_err_cd") == "") {
                            // 저장시 error data일때
                            errRowSetColor(sheetObj, i);
                        } else if(CellValue(i, "edi_err_cd") == "SS") {
                            // Confirm 성공 data일때
                            CellFontColor(i, "edi_err_nm") = RgbColor(0, 0, 255);
                            confirmScssCount++;
                        } else {
                            // Confirm 실패 data일때
                            errRowSetColor(sheetObj, i);
                            // 저장시 error가 없을때만 첫 Confirm Error row no.를 수집
                            if (confirmErrRow == 0) {
                                confirmErrRow = i;
                            }
                            confirmErrCount++;
                        }
                    }

                    ReDraw = true;
                    ComOpenWait(false);

                    if (err) {
                        // 첫 error row로 focus 이동
                        SelectCell(errFirstRow, 0, false);
                        // error message가 있을 경우에는 마지막에 alert으로 띄움
                        LoadSearchXml(errXml, true);    // append
                    } else {
                        // Confirm Error가 있으면 첫 Confirm Error row로 focus 이동
                        if (confirmErrRow > 0) {
                            SelectCell(confirmErrRow, "edi_err_nm", false);
                        }
                        // 'Data was confirmed.\n\n (Success : {?msg1} / Fail : {?msg2})'
                        ComShowCodeMessage("MNR00151", confirmScssCount, confirmErrCount);
                    }
                }
                break;

			case IBCLEAR:      //초기화       
   
				for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].Code = "-1"; 
						comboObjects[i].RemoveAll(); 	
				}				
				
				//공통콤보 정보를 가져온다.   
				var sCondition = new Array (
					new Array("MnrGenCd","CD00004", "COMMON") // Verify Result(Calculation)	
        		)
        		var comboList = MnrComSearchCombo(sheetObj, sCondition);
        		sheetComboList[0] = comboList[0];
                
        		break;
        		
            case IBBATCH:        // Calculation
            	ComOpenWait(true);
            	if(!validateForm(sheetObj,formObj,sAction)){
            		ComOpenWait(false);
            		return;
            	}
            	ComBtnDisable("btn_calc");
            	
            	// EQ No 별로 Calculation 처리            		
            	var fParam = "";
            	var sParam = "";
            	var sXml = new Array(); // 결과xml            	
            	var err = false; // error 여부
            	var errStartRow = 0; // error 발생을 대비해서 시작row를 setting
            	var errFirstRow = 0; // 첫 error 의 row 를 setting
            	var errXml = ""; // error 발생시 결과 xml 을 임시로 setting
            	            	
            	sheetObj.ReDraw = false;
            	// EQ No 가 같은 row를 한 전송 query 로 묶어 Calc 처리.
            	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
            		if(sParam == ""){
            			errStartRow = i;	// error 발생을 대비해서 시작row를 setting
            		}else{	
            			sParam += "&";	
            		} 

            		sParam += (sheetObj.RowSaveStr(i)); // row data 수집

            		// 끝라인이거나 다음 eq_no가 다를때
                    if (i==sheetObj.LastRow || sheetObj.CellValue(i, "rqst_eq_no") != sheetObj.CellValue(i + 1, "rqst_eq_no")) {
                    	// 1. eqNo 로 EqKndCd, EqTpszCd 조회, EDI ID, eq type 로 AGMT No 등 조회
        				var tXml = getHdrDataByEqNo(sheetObj, sParam);
        				var verifyRslt = ComGetEtcData(tXml,"verifyRslt");	                       	

                    	// EqKndCd, EqTpszCd, EDI ID, eq type 등 셋팅
        				if (MnrComGetErrMsg(tXml) != null || verifyRslt != null) {
        					// error 처리.. & Calc 처리는 skip
        					if(MnrComGetErrMsg(tXml) != null){
        						ComShowMessage(MnrComGetErrMsg(tXml));
        					}else if(verifyRslt != null){
        						ComShowMessage(verifyRslt);
        					}
        					sheetObj.ReDraw = true;
        					ComOpenWait(false);
							return;
        					
        				}else{
        					// 에러가 없을 경우, & 필수값이 모두 있을 경우, Calc 로직 처리.
							formObj.agmt_ofc_cty_cd.value = ComGetEtcData(tXml, "agmtOfcCtyCd");
							formObj.agmt_seq.value = ComGetEtcData(tXml, "agmtSeq");
							formObj.agmt_ver_no.value = ComGetEtcData(tXml, "agmtVerNo");
							formObj.eq_knd_cd.value = ComGetEtcData(tXml, "eqKndCd");
							formObj.eq_tpsz_cd.value = ComGetEtcData(tXml, "eqTpszCd");
							formObj.trf_no.value = ComGetEtcData(tXml, "trfNo");

        					// 2. Calc 로직 처리
							formObj.f_cmd.value = COMMAND01; 
                        	//fParam =  + "&";
                        	sParam = ComSetPrifix(sParam,"rqstDtl_");
                        	sParam += "&" + FormQueryString(formObj);
                        	sParam += "&" + "rqst_eq_no=" + sheetObj.CellValue(i, "rqst_eq_no");
                       	
                        	var kk = sXml.length;	
                            var tmpXml = sheetObj.GetSaveXml("EES_MNR_0243GS.do", sParam); // query를 전송
                            sParam = ""; // 전송query 초기화                    	
          	
                            if (MnrComGetErrMsg(tmpXml) == null) {
                            	// array에 결과xml을 setting
                                sXml[kk] = tmpXml; 
                            } else {
                                // error message가 발견되면
                                err = true;
                                // error가 발생한 row들(동일 eq_no단위)을 xml로 변환하여 결과xml에 setting
                                sXml[kk] = sheetObj.getRowSearchXml(sheetObj, errStartRow, i);
                                // 첫 error row no. 와 첫 error message만 수집
                                if (errFirstRow == 0 && errXml == "") {
                                    errFirstRow = errStartRow;
                                    errXml = tmpXml;
                                }
                            }
        				}        				
                    } //  end if 끝라인이거나 다음 eq_no가 다를때            		
            	}// end for
            	
            	sheetObj.RemoveAll(); // 전송이 완료되면 sheet clear
            	sheetObj.RemoveEtcData();		
                // sheet에 sXml array내용 load (에러row들 포함)
                for (var j=0; j<sXml.length; j++) {
                	sheetObj.LoadSearchXml(sXml[j], true);    // append
                }	
                
                // ColBackColor setting

                // sheet에 load된 row를 edi_err_cd에 따라 색변경
                var calculateScssCount = 0;    // calculate 성공 Count
                var calculateErrCount = 0;     // calculate 실패 Count
                var calculateErrRow = 0;       // calculate 실패 첫 row no.
                for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
    				var ediErrCd = sheetObj.CellValue(i,  "edi_err_cd");
    				var volTpCd = sheetObj.CellValue(i,  "vol_tp_cd");
    				
    				var ediErrNm = getDescription(ediErrCd, 0);
    				sheetObj.CellValue(i, "edi_err_nm") = ediErrNm;
    				
    				if(ediErrCd == "SS" || ediErrCd=="SL"){
    					sheetObj.CellFontColor(i,"edi_err_nm") = sheetObj.RgbColor(0,0,255); // blue
    					calculateScssCount++;

    				} else {
    					sheetObj.CellFontColor(i,"edi_err_nm") = sheetObj.RgbColor(255,0,0); // red
                        // 저장시 error가 없을때만 첫 Confirm Error row no.를 수집
                        if (calculateErrRow == 0) {
                            calculateErrRow = i;
                        }
                        calculateErrCount++;    					
    				}    			

    				//CellBackColor 초기화
    				sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"vol_tp_cd") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"rpr_qty") = sheetObj.WebColor("#ffffff");
    				sheetObj.CellBackColor(i,"rpr_sz_no") = sheetObj.WebColor("#ffffff");

    				// Verify 후, Verify Result결과에 대하여 RgbColor 추가
    				if(ediErrCd == "UH"){
    					sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "VT"){
    					sheetObj.CellBackColor(i,"vol_tp_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "UR"){
    					sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "UM"){
    					sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "SL"){
    					sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#fff000");
    					sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#fff000");
    					sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "NC"){
    					sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "NR"){
    					sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "ND"){
    					sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "LC"){
    					sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "LR"){
    					sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "LD"){
    					sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "LZ"){
    					sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
    				}else if(ediErrCd == "NZ"){
    					if(volTpCd == "Q"){
    						sheetObj.CellBackColor(i,"rpr_qty") = sheetObj.WebColor("#fff000");
    					}else{
    						sheetObj.CellBackColor(i,"rpr_sz_no") = sheetObj.WebColor("#fff000");
    					}
    				}    				
                }                
                
            	sheetObj.ReDraw = true;
            	ComOpenWait(false);
            	
            	// error 발생시
            	if(err){            		
            		sheetObj.SelectCell(errFirstRow, 0, false); // 첫 error row 로 focus 이동
            		sheetObj.LoadSearchXml(errXml, true);
            	}else{
                    // Confirm Error가 있으면 첫 Confirm Error row로 focus 이동
                    if (calculateErrRow > 0) {
                    	sheetObj.SelectCell(calculateErrRow, "edi_err_nm", false);
                    }
                    // 'Data was confirmed.\n\n (Success : {?msg1} / Fail : {?msg2}) /'
                    ComShowCodeMessage("MNR00374", calculateScssCount, calculateErrCount); 
                    
            	}
            	ComBtnEnable("btn_Save");

            	break;	                
        }
    }

    /**
     * Bidding End Date 시스템 날짜와 비교
     * @param sheetObj
     * @param dispEndDt
     * @returns true/false 
     */
  	function getHdrDataByEqNo(sheetObj, sParam){
  		//쿼리 스트링 조합시작
  		var f_query = "f_cmd=" + SEARCH01 + "&";
  		f_query += sParam;
  		
  		var sXml = sheetObj.GetSaveXml("EES_MNR_0243GS.do", f_query);
  		return sXml;
  	}	    

    // error row 색처리
    function errRowSetColor(sheetObj, row) {
        with(sheetObj) {
            RowBackColor(row) = RgbColor(255, 230, 190);
            CellFontColor(row, "edi_err_nm") = RgbColor(255, 0, 0);
        }
    }


    // ColBackColor setting
    function setColBackColor(sheetObj) {
        with(sheetObj) {
            ColBackColor("trf_div_cd") = MNR_DISABLE_BACK_COLOR;
            ColBackColor("rpr_lbr_hrs") = MNR_DISABLE_BACK_COLOR;
            ColBackColor("lbr_cost_amt") = MNR_DISABLE_BACK_COLOR;
            ColBackColor("mtrl_cost_amt") = MNR_DISABLE_BACK_COLOR;
            ColBackColor("mnr_wrk_amt") = MNR_DISABLE_BACK_COLOR;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
                case IBSAVE:			//저장
                    if(IsDataModified == false) {
                        ComShowMessage(MessageText("UserMsg13"));
                        return false;
                    }
                    break;
                    
				case IBBATCH:
																
					//각 시트의 VolumnType별 Q'ty,Size/Square체크
					if(sheetObj.RowCount >= 1) { 
						for(var j = 2; j <= sheetObj.LastRow - 1; j++) { 
						    var volTpCd		= sheetObj.CellValue(j, "vol_tp_cd");	//Type
						    var rprQty 		= sheetObj.CellValue(j, "rpr_qty");		//Q'ty
						    var rprSzNo 	= sheetObj.CellValue(j, "rpr_sz_no");	//Size/Square
							//Q'ty
							if(volTpCd == 'Q') {	 	
								if(rprQty < 1){
									ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Q'ty"); // {?msg1} should be above 0(zero).
									sheetObj.SelectCell(j, "rpr_qty", true);  
									return false;
								}
							} 
							//Size/Square
							else {		 
								if(rprSzNo < 1){	
									ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Size/Square");
									sheetObj.SelectCell(j, "rpr_sz_no", true);   
									return false;
								} 		
							}
						} 	
					} else { 	
						ComShowCodeMessage("MNR00207"); // At least one item needs to be inputted.
						return false;   
					}	
						
					//폼중 필수 입력값이 다 제대로 들어갔는지	       
					if (!ComChkValid(formObj)) return false; // EQ No. Repair Yard, Repair Status
					break;                    
                    
                default :	//do nothing
            }
        }
        return true;
    }


    /**
     * Sheet의 저정된 행을 조회XML 문자열로 구성하여 리턴한다. <br>
     *  - IBS_GetDataSearchXml함수 인용
     * @param {ibsheet} sheetObj  Sheet의 Object id
     * @param int 시작 row
     * @param int 끝 row
     * @return string
     */
    function getRowSearchXml(sheetObj, startRow, endRow) {
        var rowXml = "";
        var allXml = "<?xml version='1.0'  ?>\n<SHEET>\n  <DATA TOTAL='"+ (endRow - startRow + 1) +"'>\n";
        for (var ir=startRow; ir<=endRow; ir++) {
            rowXml = "    <TR>";
            for (var ic = 0; ic<= sheetObj.LastCol; ic++) {
                rowXml += ("<TD>" + String(sheetObj.CellValue(ir, ic)) + "</TD>");
            }
            rowXml += "</TR>\n";
            allXml += rowXml;
        }
        allXml += "  </DATA>\n</SHEET>";
        return allXml;
    }
	
	/** 
	 * 시트 콤보박스의 코드에 해당하는 값을 반환
	 * Component,Repair의 코드명을 구한다.
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	콤보서열
	 * @return  {String}    tempDesc    CodeName
	 */
	function getDescription(Value, comboSeq){
		var tempDesc = "";   
 		for(var j = 0; j < sheetComboList[comboSeq].length;j++){ 
			var tempText = sheetComboList[comboSeq][j].split("|");
			if(tempText[0] == Value) {
				tempDesc = tempText[1];
				return tempDesc; 
			}   
		}
		return tempDesc; 
	}	

    /* 개발자 작업  끝 */
