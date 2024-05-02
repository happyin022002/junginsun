/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3017.js
*@FileTitle : TAA Creation & Amendment [Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.01 문동규
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
     * @extends Pri
     * @class ESM_PRI_3017 : ESM_PRI_3017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3017() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

    /* 개발자 작업 */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.12.01
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }

            switch(srcName) {

                case "btn_OK":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;

                case "btn_Close":
                    window.close();
                    break;

                case "btns_calendar1": //달력버튼
                case "btns_calendar2":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
                    break;

            } // end switch
        }catch(e) {
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
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
     * @author 문동규
     * @version 2009.12.01
     */
    function loadPage() {
        var formObj = document.form;
        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();
        if (!isNaN(amdtSeq)) {
            formObj.amdt_seq.value = Number(amdtSeq) + 1;
        }
        formObj.eff_dt.focus();
    }

    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.01
     */
    function initControl () {
        var formObj = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
    }

    /**
     * Onbeforedeactivate Event를 처리한다. <br>
     * 날짜 masking 처리<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.01
     */
    function obj_deactivate () {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        if (srcName == "eff_dt" && formObj.eff_dt.value != "" && !check_eff_date()) {
            return false;
        }
        ComChkObjValid(event.srcElement);
    }

    /**
     * OnBeforeActivate Event를 처리한다. <br>
     * 날짜 unmasking 처리<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.01
     */
    function obj_activate () {
        var sElement = event.srcElement;
        ComClearSeparator(sElement);
    }

    /**
     * Amend Effective Date를 체크한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     if(check_eff_date()) {
     *         ........
     *     }
     * </pre>
     * @param 없음
     * @return {boolean}
     * @author 문동규
     * @version 2009.12.21
     */
    function check_eff_date() {
        var formObj = document.form;
        if (ComGetDaysBetween(formObj.eff_dt.value, formObj.old_eff_dt.value) >= 0){
            ComShowCodeMessage("PRI05006", "["+formObj.old_eff_dt.value+"]");
            formObj.eff_dt.focus();
            formObj.eff_dt.select();
            return false;
        } else {
            return true;
        }
    }


    /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.21
     */     
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "ymd":
                ComKeyOnlyNumber(event.srcElement, "-");
                break;
            default:
        }
    }
     
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.12.01
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "ibflag";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
                    Visible = false;
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
     * @author 문동규
     * @version 2009.12.01
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSAVE:        //저장
                ComOpenWait(true);
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                
                formObj.f_cmd.value = MULTI;
                var sParam = FormQueryString(formObj);
                var sXml = sheetObj.GetSaveXml("ESM_PRI_3017GS.do", sParam);
                sheetObj.LoadSaveXml(sXml);
                ComOpenWait(false);
                break;
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
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @returns bool, <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.11.20
     */
    function validateForm(sheetObj,formObj,sAction){
        var taa_no = formObj.taa_no.value;

        switch (sAction) {
            case IBSEARCH: // 조회
                if (taa_no == null) {
                    ComShowCodeMessage('PRI00316','TAA Number');
                    formObj.taa_no.focus();
                    return false;
                }
                break;

            case IBSAVE: // Save
                if(!ComChkRequired(formObj)){
                    return false;
                }
                return check_eff_date();
                break;
        }
        return true;
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 form 에 데이터를 보여줌 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            var formObj = document.form;
            var obj = new Object();
            obj.taaNo = formObj.taa_no.value;
            obj.amdtSeq = formObj.amdt_seq.value;
            window.returnValue = obj;
            window.close();
        }
    }

	/* 개발자 작업  끝 */