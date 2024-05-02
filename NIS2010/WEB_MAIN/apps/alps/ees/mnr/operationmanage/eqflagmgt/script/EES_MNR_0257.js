/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0257.js
*@FileTitle : Hanger Rack/Bar Using Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.12.20 김상수
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
* 2012.01.04 신혜정 [CHM-201215407-01] Detail EQ no 내역 팝업 조회 추가
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
     * @class ees_mnr_0257 : ees_mnr_0257 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0257() {
        this.processButtonClick        = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage                 = loadPage;
        this.initSheet                 = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet         = doActionIBSheet;
        this.setTabObject             = setTabObject;
        this.validateForm             = validateForm;
    }

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
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btn_new":
                    doActionIBSheet(sheetObject1, formObject, IBCLEAR);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
                    break;
                case "cre_dt_cal":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
                    break;
                case "btns_search":    // Form Location. 조회 팝업
                    if (formObject.p_loc_tp.Code != "ALL") {
                        openPopup("1");
                    }
                     break;

            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComFuncErrMsg(e);
            } else {
                ComFuncErrMsg(e);
            }
        }
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        MnrWaitControl(true);
        initControl()

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화
        for(var i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        MnrOfficeLevel(currOfcCd,rhqOfcCd);
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * IBCombo Object를 배열로 등록
     * @param    {IBMultiCombo}    combo_obj    화면에서 사용할 콤보들을 추가한다.
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Combo 기본 설정
     * @param    {IBMultiCombo}    combo_obj    콤보오브젝트.
     * @param    {Number}    comboNo        콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initCombo (comboObj, comboId) {
        with (comboObj) {
            switch(comboId) {
                case "p_loc_tp":
                    SetColAlign("left|left");
                    DropHeight = 160;
                    UseAutoComplete = true;
                    break;

                case "mnr_hngr_rck_cd":
                    SetColAlign("left");
                    DropHeight = 160;
                    UseAutoComplete = true;
                    break;

                case "mnr_hngr_trf_cd":
                    SetColAlign("left");
                    DropHeight = 160;
                    UseAutoComplete = true;
                    break;
            }
        }
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        with (sheetObj) {
            // 높이 설정
            style.height = 396;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 10, 100);
            var HeadTitle1 = "|Year|Month|Location|Hanger Rack Type|Tariff Type|Sales PFMC|Sales PFMC|Sales PFMC|Installation\nQty|Collection Qty|Collection Qty|Collection Qty|Collection Qty|Collection Qty|Ratio|year_month|mnr_hngr_rck_cd|mnr_hngr_trf_cd|p_loc_tp|p_loc_cd|from_date|to_date|eq_tpsz_cd";
            var HeadTitle2 = "|Year|Month|Location|Hanger Rack Type|Tariff Type|20ft|40ft|Total|Installation\nQty|Sound|Repair|Missing|Disposal|Total|Ratio|year_month|mnr_hngr_rck_cd|mnr_hngr_trf_cd|p_loc_tp|p_loc_cd|from_date|to_date|eq_tpsz_cd";
            var headCount = ComCountHeadTitle(HeadTitle2);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 6, 0, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

            // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            // dtComboEdit [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");
            InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,    "year");
            InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "month_nm");
            InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "location");
            InitDataProperty(0, cnt++, dtData,         160,   daLeft,      true,    "mnr_hngr_rck_nm");
            InitDataProperty(0, cnt++, dtData,         140,   daLeft,      true,    "mnr_hngr_trf_nm");

            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "sales_20ft");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "sales_40ft");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "sales_total");
            InitDataProperty(0, cnt++, dtAutoSum,      80,    daRight,     true,    "install_qty");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "collect_sound");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "collect_repair");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "collect_missing");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "collect_disposal");
            InitDataProperty(0, cnt++, dtAutoSum,      60,    daRight,     true,    "collect_total");
            InitDataProperty(0, cnt++, dtData,         60,    daRight,     true,    "ratio");
			// 팝업조회 추가 dtHidden	          
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "year_month");			
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "mnr_hngr_rck_cd");
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "mnr_hngr_trf_cd");
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "p_loc_tp");		
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "p_loc_cd");			
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "from_date");
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "to_date");
			InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,   "eq_tpsz_cd");

            // Col 여백설정
            ColIndent("mnr_hngr_rck_nm") = 2;
            ColIndent("mnr_hngr_trf_nm") = 2;
            ColIndent("sales_20ft") = 5;
            ColIndent("sales_40ft") = 5;
            ColIndent("sales_total") = 5;
            ColIndent("install_qty") = 5;
            ColIndent("collect_sound") = 5;
            ColIndent("collect_repair") = 5;
            ColIndent("collect_missing") = 5;
            ColIndent("collect_disposal") = 5;
            ColIndent("collect_total") = 5;
            ColIndent("ratio") = 5;

            // SELECT 로우 배경색
            SelectionMode   = smSelectionRow;
            SelectHighLight = true;
            SelectFontBold  = false;
            SelectBackColor = RgbColor(SelectBackColorR, SelectBackColorG, SelectBackColorB);

            // Sub SUM 관현 setting
            SubSumBackColor = RgbColor(190, 255, 210);
            MessageText("SubSum") = "S.TTL";

            CountPosition = 0;
        }
    }


    /**
     * Sheet1관련 프로세스 처리
     * @param    {IBSheet}    sheetObj    프로세스 처리될 시트오브젝트
     * @param    {Form}        formObj        프로세스 처리될 폼오브젝트
     * @param    {Number}    sAction        분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //조회
                if (validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id =="sheet1"){
                        formObj.f_cmd.value = SEARCH;
                        sheetObj.DoSearch4Post("EES_MNR_0257GS.do",FormQueryString(formObj));
                    }
                }
                break;

            case IBCLEAR:        //초기화
                MnrWaitControl(true);
                sheetObj.WaitImageVisible = false;

                //쉬트 초기화
                for(i = 0;i < sheetObjects.length;i++){
                    sheetObjects[i].RemoveAll();
                }

                //콤보 초기화
                for(var i = 0; i < comboObjects.length;i++){
                    comboObjects[i].Code = "-1";
                    comboObjects[i].RemoveAll();
                }

                //콤보 값 세팅
                var sCondition = new Array (
                    //MULTICOMBO
                    new Array("MnrGenCd","CD00061", "COMMON"),    // Location By
                    //MULTICOMBO  + SHEETCOMBO
                    new Array("MnrGenCd","CD00021", "COMMON"),    // Hanger Rack Type
                    new Array("MnrGenCd","CD00092", "COMMON")     // Tariff Type
                )
                var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);

                //*** Location By
                var comboDefValue = "";
                if(comboList[0] != null){
                    formObj.p_loc_tp.InsertItem(0, 'ALL', 'ALL');
                    for(var j = 1; j < comboList[0].length + 1;j++){
                        var tempText = comboList[0][j-1].split("|");
                        formObj.p_loc_tp.InsertItem(j, tempText[1] ,tempText[0]);
                    }
                }
                formObj.p_loc_tp.Code = "ALL";

                //*** Hanger Rack Type
                if(comboList[1] != null){
                    formObj.mnr_hngr_rck_cd.InsertItem(0, 'ALL', 'ALL');
                    for (var j=1; j<comboList[1].length + 1; j++) {
                        var tempText = comboList[1][j-1].split("|");
                        formObj.mnr_hngr_rck_cd.InsertItem(j, tempText[1] ,tempText[0]);
                    }
                }
                formObj.mnr_hngr_rck_cd.Code = "ALL";

                //*** Tariff Type
                if(comboList[2] != null){
                    formObj.mnr_hngr_trf_cd.InsertItem(0, 'ALL', 'ALL');
                    for(var j = 1; j < comboList[2].length + 1;j++){
                        var tempText = comboList[2][j-1].split("|");
                        formObj.mnr_hngr_trf_cd.InsertItem(j, tempText[1] ,tempText[0]);
                    }
                }
                formObj.mnr_hngr_trf_cd.Code = "ALL";

                //폼 기본값 세팅
                formObj.from_date.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
                formObj.to_date.value = ComGetNowInfo();

                sheetObj.WaitImageVisible = true;
                MnrWaitControl(false);
                break;

            case IBDOWNEXCEL:
                //sheetObj.Down2Excel(-1);
                sheetObj.SpeedDown2Excel(-1);
                break;
        }
    }


    /**
    * 조회후 처리
    */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        //소계처리
        sheetObj.ShowSubSum("location", "sales_20ft|sales_40ft|sales_total|install_qty|collect_sound|collect_repair|collect_repair|collect_missing|collect_disposal|collect_total");
    }

    /**
     * 그리드 셀 더블클릭시
     */    
	function sheet1_OnDblClick(sheetObj, Row, Col){
		var formObj = document.form;
		var mnrHngrRckCd = sheetObj.CellValue(Row,"mnr_hngr_rck_cd");
		var mnrHngrTrfCd = sheetObj.CellValue(Row,"mnr_hngr_trf_cd");
		var eqTpszCd = sheetObj.CellValue(Row,"eq_tpsz_cd");
		
		if("S.TTL" == sheetObj.CellValue(Row,"year").substr(0, 5)){
			Row = Row - 1;
		}
		// 소계 라인일 경우, 바로 위 row의 값을 가져옴.
		var yearMonth = sheetObj.CellValue(Row,"year_month");
		var location = sheetObj.CellValue(Row,"location");		
		var pLocTp = sheetObj.CellValue(Row,"p_loc_tp");
		var pLocCd = sheetObj.CellValue(Row,"p_loc_cd");
		var fromDate = sheetObj.CellValue(Row,"from_date");
		var toDate = sheetObj.CellValue(Row,"to_date");
		
		ComOpenPopup('EES_MNR_0258.do?mnrHngrRckCd='+mnrHngrRckCd+'&mnrHngrTrfCd='+mnrHngrTrfCd+'&yearMonth='+yearMonth+'&location='+location+'&pLocTp='+pLocTp+'&pLocCd='+pLocCd+'&fromDate='+fromDate+'&toDate='+toDate+'&eqTpszCd='+eqTpszCd, 990, 505, '', '0,0', true);
	}    
    
     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param    {IBSheet}    sheetObj    유효성을 검증할 시트오브젝트
     * @param    {Form}        formObj        유효성을 검증할 폼오브젝트
     * @param    {Number}    sAction        분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
            if(sAction==IBSEARCH) {
                if (!ComChkValid(formObj)) return false;
                if (p_loc_tp.Text != "ALL" && ComIsEmpty(p_loc_cd)) {
                    ComShowCodeMessage("MNR00172", "Location");
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * p_loc_tp 체인지 이벤트
     * @param    {IBMultiCombo}        comboObj    콤보오브젝트
     * @param    {Number}             Index_Code     선택된 row
     * @param    {String}             Text         선택된 Text
     */
    function p_loc_tp_OnChange(comboObj, Index_Code, Text){
        var formObj = document.form;
        formObj.p_loc_cd.value = "";
        if(Text == "ALL") {
            MnrFormSetReadOnly(formObj, true, "p_loc_cd");
        } else {
            MnrFormSetReadOnly(formObj, false, "p_loc_cd");
            ComSetFocus(formObj.p_loc_cd);
        }
    }


    /**
     * rep_Multiful_inquiry 사용시 받는부분
     * 소스에 붙여서 사용하세요
     * Location : 팝업에서 단일 선택을 한경우..
     */
    function getMnr_Multi(rowArray,ret_val) {
        var formObj = document.form;
        var tempText = "";
        //초기화
        for(var i=0; i<rowArray.length; i++) {
            var colArray = rowArray[i];
            tempText +=  rowArray[i] + ',';
        }
        //마지막에 ,를 없애기 위함
        tempText = MnrDelLastDelim(tempText);
        tempText = tempText.toUpperCase();
        eval("document.form." + ret_val + ".value = '" + tempText + "';");
    }


    /**
     * Pop-up Open 부분<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
        var formObj = document.form;
        if (type == "1") {
            switch(formObj.p_loc_tp.Code) {
                case "RCC" :    //RCC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
                    break;
                case "LCC" :    //LCC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
                    break;
                case "SCC" :    //SCC
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
                    break;
                default :       //do nothing
            }
        }
        return;
    }


    //Axon 이벤트 처리1. 이벤트catch
    function initControl() {
        axon_event.addListenerForm  ('blur', 'obj_deactivate', form);      //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('focus', 'obj_activate', form);       //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }


    //Axon 이벤트 처리. activate이벤트처리함수
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }


    //Axon 이벤트 처리. deactivate이벤트처리함수
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }


    //Axon 이벤트 처리. keypress이벤트처리함수
    function obj_keypress(){
        obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;

        switch(obj.dataformat) {
            case "ymd":
            case "int":
                ComKeyOnlyNumber(obj);
                break;
            case "float":
                ComKeyOnlyNumber(obj, "-.");
                break;
            case "eng":
                ComKeyOnlyAlphabet();
                break;
            case "engup":
                ComKeyOnlyAlphabet('uppernum');
                break;
        }
    }
    /* 개발자 작업  끝 */