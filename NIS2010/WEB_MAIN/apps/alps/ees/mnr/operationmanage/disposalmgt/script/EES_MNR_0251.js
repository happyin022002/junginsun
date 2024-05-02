/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0251.js
*@FileTitle : SLD Cancelation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.19 김종옥
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
* 2012.05.23 신혜정 [선처리] Sel 체크시,Chassis, M.G.Set 은 SLD 만 체크. CNTR 는 SLD, XX 체크                                       
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
     * @class EES_MNR_0251 : EES_MNR_0251 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0251() {
        this.processButtonClick		= tprocessButtonClick;
        this.setSheetObject 		= setSheetObject;
        this.loadPage 				= loadPage;
        this.initSheet 				= initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet 		= doActionIBSheet;
        this.setTabObject 			= setTabObject;
        this.validateForm 			= validateForm;
        this.setComboObject			= setComboObject;
    }

    /* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_New":
                    doActionIBSheet(sheetObject,formObject,IBCLEAR);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btn_DownExcel":
                    sheetObject.SpeedDown2Excel(-1);
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
      * Combo Object를 배열로 등록
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
        MnrWaitControl(true);

        initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //IBMultiCombo초기화
        for(var c=0; c<comboObjects.length; c++){
            initCombo(comboObjects[c], c+1);
        }

        //Axon이벤트 초기화
        initControl();
        MnrWaitControl(false);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 392;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;    //msPrevColumnMerge;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "|Sel|Seq.|Invoice No.|Invoice Status|Disposal No.|Buyer Code|Buyer Name|EQ No.|EQ Type|TP/SZ|Term|Status|MVMT|Date|Yard|disp_dtl_seq|eq_knd_cd";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false, false)

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,	daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	false,	"del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,			40,	daCenter,	true,	"seq");
                    InitDataProperty(0, cnt++ , dtData,			84,	daCenter,	true,	"inv_no",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	"mnr_inv_sts_cd",	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			94,	daCenter,	false,	"disp_no",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	"buyer_code",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			140,daLeft,		false,	"buyer_name",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	"eq_no",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	false,	"eq_knd_nm",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			44,	daCenter,	false,	"eq_tpsz_cd",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			44, daCenter,	false,	"lstm_cd",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			44,	daCenter,	false,	"cntr_sts_cd",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			44,	daCenter,	false,	"cnmv_sts_cd",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			70, daCenter,	false,	"disp_sold_dt",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			60, daCenter,	false,	"lst_sts_yd_cd",	false,	"",	dfNone,		0,	false,	false);

                    InitDataProperty(0, cnt++ , dtHidden,		50, daLeft,		true,	"disp_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		40,	daCenter,	false,	"eq_knd_cd");
                    EditableColorDiff = false;
                }
                break;
        }
    }


    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboNo) {
        var i=0;
        switch(comboObj.id) {
            case "kind_cd":
                with(comboObj) {
                    comboObj.DropHeight=100;
                    comboObj.BackColor = "#CCFFFD";
                    InsertItem(i++, "Disposal No.", "D");
                    InsertItem(i++, "Invoice No.", "I");
                    InsertItem(i++, "EQ No.", "E");
                    comboObj.Code = "D";
                }
                break;
        }
    }


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                if (validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("EES_MNR_0251GS.do", FormQueryString(formObj));
                }
                break;

            case IBCLEAR:      //초기화
                formObj.kind_cd.Code = "D";
                formObj.kind_no.value = "";
                sheetObj.RemoveAll();
                break;

            case IBSAVE:      //저장
                if (validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = MULTI;
                    sheetObjects[0].DoSave("EES_MNR_0251GS.do", FormQueryString(formObj), -1, false);
                }
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction==IBSEARCH) {
                if(ComIsEmpty(formObj.kind_no.value))
                {
                    ComShowCodeMessage("MNR00172", "KIND");
                    ComSetFocus(formObj.kind_no);
                    return false;
                }
            } else if(sAction==IBSAVE) {
                if(sheetObj.RowCount("U")==0){
                        return false;
                }
            }
        }
        return true;
    }


    function initControl() {
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }


    function obj_keypress(){
        obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;

        switch(obj.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('uppernum', "45");
                break;
        }
    }


    /**
     * 조회후 설정
     *     Sel 컬럼 Edit 설정
     * @param	{IBSheet}	sheetObj	시트오브젝트
     * @param	{String}	ErrMsg		에러메세지
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if(sheetObj.RowCount > 0) {
            for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
                var mnrInvStsCd = sheetObj.CellValue(i, "mnr_inv_sts_cd");
                var cntrStsCd = sheetObj.CellValue(i, "cntr_sts_cd");
                var cnmvStsCd = sheetObj.CellValue(i, "cnmv_sts_cd");
                var eqKndCd = sheetObj.CellValue(i, "eq_knd_cd");
                
                // Z(Chassis), G(M.G.Set)는 XX 체크 제외                   
                if ((cntrStsCd == "SLD" && cnmvStsCd == "XX" && eqKndCd == "U") // U = CNTR
                		|| (cntrStsCd == "SLD" && eqKndCd == "Z") || (cntrStsCd == "SLD" && eqKndCd == "G")) { // Z = Chassis, G = M.G.Set
                    sheetObj.CellEditable(i, "del_chk") = true;
                } else {
                    sheetObj.CellEditable(i, "del_chk") = false;
                    sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR, ErrorColBackColorG, ErrorColBackColorB);
                }
            }
        }
    }


    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        var formObject = document.form;
        doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    }


    function sheet1_OnClick(sheetObj, Row, Col, Value){
        var vSelDelChk = sheetObj.CellValue(Row, "del_chk");
        var vSelInvNo = sheetObj.CellValue(Row, "inv_no");
        var vSelDelChkFlg = sheetObj.CellEditable(Row, "del_chk");
        var vCheckValue = 0;

        //Sel 이벤트
        if(Col == 1 && vSelDelChkFlg){
            for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
                var invNo = sheetObj.CellValue(i, "inv_no");
                var mnrInvStsCd = sheetObj.CellValue(i, "mnr_inv_sts_cd");
                var cntrStsCd = sheetObj.CellValue(i, "cntr_sts_cd");
                var cnmvStsCd = sheetObj.CellValue(i, "cnmv_sts_cd");
                var eqKndCd = sheetObj.CellValue(i, "eq_knd_cd");

                if(vSelDelChk){ // vSelDelChk = 1
                    if( vSelInvNo == invNo && cntrStsCd == "SLD") {		
                        sheetObj.CellValue(i, "del_chk") = 0;
                    }
                    var vCheckValue = 1;
                }else{	
                    //if( vSelInvNo == invNo && (mnrInvStsCd == "Invoice Confirmed" || mnrInvStsCd == "ERP Interfaced")&& cntrStsCd == "SLD") {
                    if( (vSelInvNo == invNo && cntrStsCd == "SLD" && cnmvStsCd == "XX" && eqKndCd == "U") // U = CNTR
                    		|| (vSelInvNo == invNo && cntrStsCd == "SLD" && eqKndCd == "Z") // Z = Chassis, G = M.G.Set 
                    		|| (vSelInvNo == invNo && cntrStsCd == "SLD" && eqKndCd == "G")) {	
                        sheetObj.CellValue(i, "del_chk") = 1;
                    }
                    var vCheckValue = 0;
                }
            }
            sheetObj.CellValue(Row, "del_chk") = vCheckValue;
        }
    }

    /* 개발자 작업  끝 */