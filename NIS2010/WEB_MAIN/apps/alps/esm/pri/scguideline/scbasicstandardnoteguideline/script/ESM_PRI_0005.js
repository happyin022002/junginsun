/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0005.js
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.16 이승준
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
     * @class Standard Note Creation : Standard Note Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0005() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */


    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    var errMsg = "";

    //현재 이벤트를 저장
    var eventStatus = "";
    var eventStatus2 = "";

    var selectedMrow = -1;
    var selectedDrow = -1;

    var selectedGlineSeq = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

//        var sheetObject1 = sheetObjects[0];
//        var sheetObject2 = sheetObjects[1];
//        var sheetObject3 = sheetObjects[2];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
//                  doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;

                case "btn_new":
                    removeAll(document.form);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;

                case "btn_confirm":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                    break;

                case "btn_cancel":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
                    break;

                case "btn_copy":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
                    break;  

                case "btn_add":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;

                case "btn_add2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;  

                case "btn_delete":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;

                case "btn_delete2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;

                case "btn_delete3":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
                    break;

                case "btns_calendar": //달력버튼
                    if (comboObjects[0].Code == "") {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');

                    break;  

				case "btn_downexcel":
					doActionIBSheet(sheetObjects[3],document.form,IBDOWNEXCEL);
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
     * @author 이승준
     * @version 2009.04.17
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
     * @author 이승준
     * @version 2009.04.17
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }

        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);

//      var formObj = document.form;
//      formObj.note_ref_yr.focus();

        toggleButtons("INIT");
    }
     
    /**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnLoadFinish(sheetObj) {
        sheetObj.WaitImageVisible = false; 
        doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
//      sheetObj.WaitImageVisible = true; 

        document.form.note_ref_yr.focus();
    }

    /**
     * Onactivate event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
    function obj_activate() {
        var formObject = document.form;
        var srcName = event.srcElement.getAttribute("name");
        var comboObj = comboObjects[1];

        ComClearSeparator (event.srcElement);

    }
    
    /**
     * OnDeactivate event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
    function obj_deactivate() {
        ComChkObjValid(event.srcElement);
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
     * @author 이승준
     * @version 2009.04.17
     */  
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {

            case "sheet0":      //hidden 
                with (sheetObj) {
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "status";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
    
                Visible = false;                    
                }
                break; 

            case "sheet1":      //t1sheet1 init)
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Del Check|Seq.|Title|dp_seq|note_hdr_seq|note_seq|prc_cust_tp_cd|svc_scp_cd|note_tit_nm";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,       "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,        40,    daCenter,  false,       "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck,          40,    daCenter,  false,       "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,               50,    daCenter,  false,       "Seq");
                    InitDataProperty(0, cnt++ , dtData,              150,   daLeft,    false,       "note_tit_nm",      false,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "dp_seq",           false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "note_hdr_seq",     false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "note_seq",         false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "prc_cust_tp_cd",   false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "svc_scp_cd",       false, "", dfNone, 0, false, false);

                    //CountPosition = 0;
                    ColHidden("del_chk") = true;
                    //AutoRowHeight = false;    
                    WaitImageVisible = false;
                }
                break;

            case "sheet2":      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 160;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Del Seq|Seq.|Content|Conversion|Conversion|dp_seq|note_hdr_seq|note_seq|note_ctnt_seq|prc_cust_tp_cd|svc_scp_cd|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,       "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,        40,    daCenter,  false,       "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck,          40,    daCenter,  false,       "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,               50,    daCenter,  true,        "seq");
                    InitDataProperty(0, cnt++ , dtData,              700,   daLeft,    false,       "note_ctnt",        true,  "", dfNone, 0, false,false);
                    InitDataProperty(0, cnt++ , dtCheckBox,         50, daCenter,  false,       "note_conv_flg",    false, "", dfNone, 0, false,false);
                    InitDataProperty(0, cnt++ , dtPopup,         90,    daCenter,  false,       "conversion_pop",   false, "", dfNone, 0, true, true);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "dp_seq",           false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "note_hdr_seq",     false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "note_seq",         false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "note_ctnt_seq",    false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "prc_cust_tp_cd",   false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "svc_scp_cd",       false, "", dfNone, 0, false, false);

                    InitDataProperty(0, cnt++,  dtHidden,            90,    daLeft,    false,       "note_conv_mapg_id");

                    ShowButtonImage = 2;
                    //CountPosition = 0;

                    ColHidden("del_chk") = true;
                    AutoRowHeight = false;
                    WaitImageVisible = false;
                }
                break; 
                

            case "sheet3":      //DOWNEXCEL
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Seq.|Title|Content|Conversion";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,    	50,    	daCenter,  false,	"Seq");
                    InitDataProperty(0, cnt++ , dtData,   	100,   	daLeft,    false,	"note_tit_nm",      false,	"", dfNone, 0, false,	false);
                    InitDataProperty(0, cnt++ , dtData,   	700,   	daLeft,    false,	"note_ctnt",        false,	"", dfNone, 0, false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	50, 	daCenter,  false,	"note_conv_flg",	false, 	"", dfNone, 0, false,	false);
                                   
                    WaitImageVisible = false;
                }
                break;
        }
    }
     
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
        }
    }
    
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
        }
    } 
    
    /**
     * saveEnd 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet0_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {
//        errMsg = ErrMsg;
        //}
    }
    
    /**
     * saveEnd 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {
//      errMsg = ErrMsg;
        //}
    }
    
    /**
     * saveEnd 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
        var formObj = document.form;
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            //저장후 MAPPING ID값을 가져오기 위해서 조회한다.           
            if(formObj.f_cmd.value == MULTI01) {
                formObj.note_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_seq");
            }
            //날짜 콤보 재세팅
            doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
            //note_nm combo
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   
        }
    }

    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if(eventStatus == "IBSAVE") return;
        selectedDrow = Math.max(NewRow - sheetObj.RowCount("D"), sheetObj.HeaderRows);
    }
    
    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if(eventStatus == "IBSAVE") return;
        selectedMrow = Math.max(NewRow - sheetObj.RowCount("D"), sheetObj.HeaderRows);

        doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
    }
    
    var isFiredNested = false;
    var supressConfirm = false;

    /**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
        var formObj = document.form;
        var adjNewRow = NewRow;

        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetM.IsDataModified) {
                isFiredNested = true;
                sheetM.SelectCell(OldRow, OldCol, false);
                isFiredNested = false;

                if (validateForm(sheetM,document.form,IBSAVE)) {
                    isFiredNested = true;
                    sheetM.SelectCell(NewRow, NewCol, false);
                    isFiredNested = false;
                } else {
                    isFiredNested = true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
            }

            if (sheetD.IsDataModified) {
                isFiredNested = true;
                sheetM.SelectCell(OldRow, OldCol, false);
                isFiredNested = false;

                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
                    var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                    isFiredNested = true;
                    sheetM.SelectCell(adjNewRow, NewCol, false);
                    isFiredNested = false;
                } else {
                    isFiredNested = true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
            }

            if (appendRow) {
                isFiredNested = true;
                var idx = sheetM.DataInsert();
                isFiredNested = false;
                return idx;

            } else {
                formObj.note_seq.value = sheetM.CellValue(adjNewRow, "note_seq");
                if(formObj.note_seq.value == "undefined" || ComIsEmpty(formObj.note_seq.value)) {
                    formObj.note_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_seq");
                }

                if(formObj.note_hdr_seq.value == "undefined" || ComIsEmpty(formObj.note_hdr_seq.value)) {
                    formObj.note_hdr_seq.value = getNoteNmCd();
                }
                isFiredNested = true;
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                isFiredNested = false;
                showMemoPad(sheetM, NewRow, NewCol);
            }
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
     * @author 이승준
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBCLEAR: 
                // 화면 로딩시 Service Scope 조회
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");

                // 화면 로딩시customer type 조회
                formObj.f_cmd.value = SEARCH20;
                formObj.cd.value="CD01714";

                sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.prc_cust_tp_cd, "cd", "cd|nm");
                formObj.prc_cust_tp_cd.InsertItem(0,'','');
                break;  

            case IBCREATE: // Service Scope 선택시, Duration 조회
                formObj.f_cmd.value = SEARCH05;

                var sXml = sheetObj.GetSearchXml("ESM_PRI_0005GS.do", FormQueryString(formObj));
                //ComPriXml2ComboItem(sXml, formObj.eff_dt, "eff_dt", "eff_dt|exp_dt");
                ComPriXml2ComboItem(sXml, formObj.gline_seq, "note_hdr_seq", "eff_dt|exp_dt");
                break;  

            case IBSEARCH:      //조회
                if (validateForm(sheetObj, formObj, sAction)) {
                    try {
                        for (var i = 0; i < sheetObjects.length; i++) {
                            sheetObjects[i].WaitImageVisible = false;
                        }    
                        ComOpenWait(true);

                        if ( sheetObj.id == "sheet0") {

                            formObj.f_cmd.value = SEARCH01;

                            //키값을 새로 조회 하므로  clear
                            //formObj.note_hdr_seq.value = "";

                            var sXml = sheetObj.GetSearchXml("ESM_PRI_0005GS.do", FormQueryString(formObj));
                            var arrData = ComPriXml2Array(sXml, "note_hdr_seq|prc_cust_tp_cd|cfm_flg|note_nm|note_ref_yr|eff_dt|exp_dt|svc_scp_cd");
                            if (arrData != null && arrData.length > 0) {
                                formObj.note_hdr_seq.value = arrData[0][0];
                                //formObj.prc_cust_tp_cd.value = arrData[0][1];

                                formObj.note_ref_yr.value        = arrData[0][4];
                                comboObjects[3].Code2            = arrData[0][1];

                                formObj.cfm_flg.value            = arrData[0][2];
                                comboObjects[2].Code2            = arrData[0][0];

                                formObj.svc_scp_cd_hidden.value  = arrData[0][7];
                                formObj.note_nm_hidden.value     = arrData[0][3];
                                formObj.note_ref_yr_hidden.value = arrData[0][4];
                                formObj.eff_dt_hidden.value      = arrData[0][5];
                                formObj.exp_dt_hidden.value      = arrData[0][6];
                                formObj.prc_cust_tp_cd_hidden.value = arrData[0][1];

                                comboObjects[1].Text2            = arrData[0][5];
                                formObj.exp_dt.value             = arrData[0][6];
                            } else {
                                //comboObjects[2].Index = "-1";
                                formObj.note_hdr_seq.value = "";
                                formObj.cfm_flg.value = "";
                                formObj.note_nm.value = "";

                                formObj.svc_scp_cd_hidden.value  = "";
                                formObj.note_nm_hidden.value     = "";
                                formObj.note_ref_yr_hidden.value = "";
                                formObj.eff_dt_hidden.value      = "";
                                formObj.exp_dt_hidden.value      = "";
                                formObj.prc_cust_tp_cd_hidden.value = "";
                            }

                            setConfirmButton();
                        } else if ( sheetObj.id == "sheet1") {
                            formObj.f_cmd.value = SEARCH02;

                            for (var i = 0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }

                            sheetObj.DoSearch("ESM_PRI_0005GS.do", FormQueryString(formObj));

                            setConfirmButton();
                        } else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value = SEARCH03;

                            sheetObj.DoSearch("ESM_PRI_0005GS.do", FormQueryString(formObj));

                            setConfirmButton();
                        }   

                        ComOpenWait(false);

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
                break;

            case IBSAVE:        //저장

                //COPY 후 저장인 경우
                if(eventStatus == "IBCOPY") {
                    if (!validateForm(sheetObj,document.form,IBSEARCH_ASYNC04)) return;
                    if (ComShowCodeConfirm('PRI00012')) {

                        formObj.f_cmd.value = MULTI05;

                        //note_nm_cd의 text 값을 세팅
                        formObj.note_nm.value = getNoteNmTxt();

                        var sParam = FormQueryString(formObj);
                        sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                        sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");

                        try {
                            ComOpenWait(true);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0005GS.do", sParam);
                            
                            //저장 후 저장한 note_hdr_seq를 세팅한다.
                            if(typeof ComGetEtcData(sXml, "note_hdr_seq") != "undefined" && ComGetEtcData(sXml, "note_hdr_seq") != "") {
                                formObj.note_hdr_seq.value = ComGetEtcData(sXml, "note_hdr_seq");
                            }

                            sheetObjects[2].LoadSaveXml(sXml);
                            sXml = ComDeleteMsg(sXml);
                            sheetObjects[1].LoadSaveXml(sXml);

                            ComOpenWait(false);
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
                    eventStatus = "";
                } else {
                    try {
                        ComOpenWait(true);
                        if (!validateForm(sheetObj,document.form,sAction)) {
                            return false;
                        }
                        if (!supressConfirm && !ComPriConfirmSave()) {
                            return false;
                        }

                        eventStatus = "IBSAVE";

                        formObj.f_cmd.value = MULTI01;

                        //note_nm_cd의 text 값을 세팅
                        formObj.note_nm.value = getNoteNmTxt();

                        setDpSeq(sheetObjects[1]);
                        setDpSeq(sheetObjects[2]);

                        var sParam = FormQueryString(formObj);
                        sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                        sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");

                        var sXml = sheetObj.GetSaveXml("ESM_PRI_0005GS.do", sParam);

                        //저장 후 저장한 note_hdr_seq를 세팅한다.
                        if(typeof ComGetEtcData(sXml, "note_hdr_seq") != "undefined" && ComGetEtcData(sXml, "note_hdr_seq") != "") {
                            formObj.note_hdr_seq.value = ComGetEtcData(sXml, "note_hdr_seq");
                        }

                        sheetObjects[2].LoadSaveXml(sXml);
                        sXml = ComDeleteMsg(sXml);
                        sheetObjects[1].LoadSaveXml(sXml);

                        ComOpenWait(false);
                    } catch (e) {
                        if (e == "[object Error]") {
                            ComShowMessage(OBJECT_ERROR);
                        } else {
                            ComShowMessage(e);
                        }
                    } finally {
                        ComOpenWait(false);
                    }
                    eventStatus = "";
                    eventStatus2 = "";
                }
                break;

            case IBSEARCH_ASYNC01:        //컨폼

                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC01)) {
                    if (ComPriConfirmConfirm()) {
                        try {
                            ComOpenWait(true);

                            formObj.f_cmd.value = MULTI02;

                            //formObj.cfm_flg.value = "Y";

                            var sParam = FormQueryString(formObj);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0005GS.do", sParam);

                            ComOpenWait(false);

                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }

                        ComPriConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    }   
                }
                break;  

            case IBSEARCH_ASYNC02:        //컨폼 CANCEL
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC02)) {
                    if (ComPriConfirmCancelConfirm()) {

                        try {
                            ComOpenWait(true);

                            formObj.f_cmd.value = MULTI03;

                            //formObj.cfm_flg.value = "N";

                            var sParam = FormQueryString(formObj);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0005GS.do", sParam);

                            ComOpenWait(false);

                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }

                        ComPriCancelConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    }   
                }
                break;  

            case IBSEARCH_ASYNC03:        //all delete
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC03)) {
                    if (ComPriConfirmDeleteAll()) {

                        try {
                            ComOpenWait(true);

                            formObj.f_cmd.value = MULTI04;
                            var sParam = FormQueryString(formObj);
                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0005GS.do", sParam);
        	  				sheetObj.LoadSaveXml(sXml);
        	  		        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
        	  		        		removeAll2(formObj);
        	  		        }        	  				
                            ComOpenWait(false);
                            
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
                }
                break;          

            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow, 
//                      sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, true);


                        var idx = doRowChange(sheetObj, sheetObjects[2], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
                        if (idx < 0) {
                            return false;
                        }


                        //service scoup
                        sheetObj.CellValue(idx, "svc_scp_cd")     = getSvcScpCd();
                        //customer type
                        sheetObj.CellValue(idx, "prc_cust_tp_cd") = getCustTypeCd();
                        //header sequence
                        sheetObj.CellValue(idx, "note_hdr_seq")   = formObj.note_hdr_seq.value;
                        sheetObj.CellValue(idx, "note_seq") = parseInt(ComPriGetMax(sheetObj, "note_seq")) + 1;
                        sheetObjects[2].RemoveAll();

                        sheetObj.SelectCell(idx, "note_tit_nm");

                    }
                    if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataInsert();
                        //service scoup
                        sheetObj.CellValue(idx, "svc_scp_cd")     = getSvcScpCd();
                        //customer type
                        sheetObj.CellValue(idx, "prc_cust_tp_cd") = getCustTypeCd();
                        //header sequence
                        sheetObj.CellValue(idx, "note_hdr_seq")   = formObj.note_hdr_seq.value;
                        var note_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_seq");
                        sheetObj.CellValue(idx, "note_seq") = note_seq;
                        sheetObj.CellValue(idx, "note_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1;

                        //not null 나중 수정
                        sheetObj.CellValue(idx, "note_conv_flg") = "N"
                            sheetObj.CellValue(idx, "conversion_pop") = " " 

                                sheetObj.SelectCell(idx, "note_ctnt");  
                    }
                }
                break;

            case IBDELETE: // Delete

                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }

                if (sheetObj.CheckedRows("chk") <= 0) {
                    sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
                }

//              var delCnt = deleteRowCheck(sheetObj, "chk");
//              if (delCnt > 0 && sheetObj.id == "sheet1") {
//              for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
//              sheetObjects[2].CellValue(i, "chk") = "1";
//              }
//              deleteRowCheck(sheetObjects[2], "chk");
//              }

                if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
                    sheetObjects[2].RemoveAll();
                }

                var delCnt = deleteRowCheck(sheetObj, "chk");
                if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
                    sheetObjects[2].RemoveAll();
                }

                break;


            case IBSEARCH_ASYNC04:        //COPY

                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC04)) {

                    removeCopy(document.form);
                    eventStatus = "IBCOPY";
                    toggleButtons(eventStatus);
                }
                break;  

            case IBSEARCH_ASYNC05:        //NOTE_NM COMBO SEARCH

                if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {

                    formObj.f_cmd.value = SEARCH01;

                    formObj.note_hdr_seq.value =  "";

                    var sXml = sheetObj.GetSearchXml("ESM_PRI_0005GS.do", FormQueryString(formObj));
                    //ComPriXml2ComboItem(sXml, formObj.eff_dt, "eff_dt", "eff_dt|exp_dt");
                    ComPriXml2ComboItem(sXml, formObj.note_nm_cd, "note_hdr_seq", "note_nm");

                    break;  
                }
                break;
             
			case IBDOWNEXCEL:
				try {
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value = SEARCH06;
						sheetObj.DoSearch("ESM_PRI_0005GS.do" , FormQueryString(formObj));

						//sheetObj.SpeedDown2Excel(-1);
						sheetObj.SpeedDown2Excel(-1, false,false, "", "apps/alps/esm/pri/scguideline/scbasicstandardnoteguideline/script/ESM_PRI_0005.xml");
					} else {
						ComShowCodeMessage('PRI08001');
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
				break;
				
        }
    }

    /**
     * IBSHEET COMBO를 LOAD하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     *      initCombo(comboObj, comboNo)
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
            case "svc_scp_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
//                  MaxSelect = 1;
                    UseAutoComplete = true;
                    IMEMode = 0;
                    ValidChar(2, 0);
                    MaxLength = 3;      // 3자리만 입력
                }
                break;

            case "gline_seq":
                var i=0;
                with(comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
//                  MaxSelect = 1;
                    UseAutoComplete = false;
//                  SetColWidth("76|76|0");
                }
                break;

            case "note_nm_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
//                  MaxSelect = 1;
                    UseAutoComplete = false;
                }
                break;      

            case "prc_cust_tp_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
//                  MaxSelect = 1;
                    UseAutoComplete = false;
                    ValidChar(2, 0);
                    MaxLength = 1;
                    SetColWidth("18|170");
                }
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
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {

            case IBCREATE: // service scope 선택시

                if ( sheetObj.id == "sheet0") {
                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                        return false;
                    }
                } else if( sheetObj.id == "sheet1") {
                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("i","year",formObj.note_ref_yr);
                        return false;
                    }
                    if (ComIsEmpty(comboObjects[0].Text)) {
                        ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                        return false;
                    }
                }
                return true;

                break;

            case IBSEARCH: // 조회

                if ( sheetObj.id == "sheet0") {

                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                        return false;
                    }   

//                  if(!ComIsNumber(document.form.note_ref_yr,'0123456789')) {
//                  ComShowCodeMessage('PRI00311');
//                  document.form.note_ref_yr.value = "";
//                  return;
//                  }

                    if (ComIsEmpty(comboObjects[0].Text)) {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }

//                  if (comboObjects[1].Text == "") {
//                  ComPriInputValueFailed("Duration을","선택",comboObjects[1]);
//                  return false;
//                  }

//                  if (formObj.eff_dt.value == "") {
//                  ComPriInputValueFailed("Duration을","선택",formObj.eff_dt);
//                  return false;
//                  }

                } else if ( sheetObj.id == "sheet1") {  

                    if (ComIsEmpty(formObj.note_ref_yr.value)) {
                        ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                        return false;
                    }   

                    if (ComIsEmpty(comboObjects[0].Text)) {
                        ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                        return false;
                    }

                    if (ComIsEmpty(comboObjects[1].Text)) {
                        ComPriInputValueFailed("input","Duration",comboObjects[1]);
                        return false;
                    }

                    if (ComIsEmpty(formObj.exp_dt.value)) {
                        ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                        return false;
                    }

                    if (ComIsEmpty(comboObjects[2].Text)) {
                        ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                        return false;
                    }
                }

                return true;
                break;

            case IBSAVE: // 저장
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }       
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }

//              if (ComIsEmpty(formObj.eff_dt.value)) {
//              ComPriInputValueFailed("Duration을","선택",formObj.eff_dt);
//              return false;
//              }

                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                var eff_dt = removeDash(formObj.eff_dt.value);
                var exp_dt = removeDash(formObj.exp_dt.value);
                if (eff_dt > exp_dt) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }

                var note_ref_year = formObj.note_ref_yr.value;
                if (note_ref_year != eff_dt.substr(0,4) && note_ref_year != exp_dt.substr(0,4)) {
                    ComShowCodeMessage('PRI00323');
                    formObj.note_ref_yr.focus();
                    return false;
                }


                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }

                if (formObj.cfm_flg.value == "Yes" && eventStatus2 != "CONV") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                //변경사항 체크 없으면
                if(!checkModified(formObj)) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }   

                //sheet1에서 하나라도 저장했는지 체크
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }

                //sheet2에서 하나라도 저장했는지 체크
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("PRI00319", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }

                if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
                    return false;
                }

                if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
                    return false;
                }

                if (sheetObjects[1].IsDataModified ) {
                    var rowM = sheetObjects[1].ColValueDup("svc_scp_cd|prc_cust_tp_cd|note_hdr_seq|note_seq",false);
                    if (rowM >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet1", rowM);
                        return false;
                    }               
                }

                if (sheetObjects[2].IsDataModified ) {
                    var rowD = sheetObjects[2].ColValueDup("svc_scp_cd|prc_cust_tp_cd|note_hdr_seq|note_seq|note_ctnt_seq",false);
                    if (rowD >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet2", rowD);
                        return false;
                    }               
                }

//              if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D"
//              && getValidRowCount(sheetObjects[2]) <= 0) {
//              ComShowCodeMessage("PRI00319", "Title");
//              return false;
//              }

                formObj.eff_dt.value = setDash(eff_dt);
                formObj.exp_dt.value = setDash(exp_dt);

                return true;
                break;

            case IBINSERT: // Row Add
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }       
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }

                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;

            case IBSEARCH_ASYNC01: // CONFIRM

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }   
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }       
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }

                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }

                //sheet1에서 하나라도 저장했는지 체크
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }

                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("PRI00319", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }

                if (checkModified(formObj)) {
                    ComShowCodeMessage("PRI03009","");
                    return false;
                }

                return true;
                break;

            case IBSEARCH_ASYNC02: //CONFIRM cancel

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "No") {
                    ComShowCodeMessage('PRI00106');
                    return false;
                }

                return true;
                break;  

            case IBSEARCH_ASYNC03: //All Delete

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }

                return true;
                break;      


            case IBDELETE: // Delete

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    return false;
                }
                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
//                  ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;


            case IBSEARCH_ASYNC04: // COPY


                if (ComIsEmpty(formObj.note_hdr_seq.value)) {
                    ComShowCodeMessage('PRI08015');
                    return false;
                }

                if (ComIsEmpty(formObj.note_ref_yr.value)) {
                    ComPriInputValueFailed("input","year",formObj.note_ref_yr);
                    return false;
                }   
                if (ComIsEmpty(comboObjects[0].Text)) {
                    ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
                    return false;
                }
                if (ComIsEmpty(comboObjects[1].Text)) {
                    ComPriInputValueFailed("input","Duration",comboObjects[1]);
                    return false;
                }
                if (ComIsEmpty(formObj.exp_dt.value)) {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }

                if (formObj.eff_dt.value > formObj.exp_dt.value) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }

                var note_ref_year = formObj.note_ref_yr.value;
                if (note_ref_year != formObj.eff_dt.value.substr(0,4) && note_ref_year != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00323');
                    formObj.note_ref_yr.focus();
                    return false;
                }

                if (ComIsEmpty(comboObjects[2].Text)) {
                    ComPriInputValueFailed("input","Standard Note",comboObjects[2]);
                    return false;
                }

                return true;
                break; 

    		case IBDOWNEXCEL: // 엑셀저장
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				return false;
    			}
    			break;
    			
        }


        return true;
    }

    /**
     * service scope combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     *      
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
    function svc_scp_cd_OnChange(comboObj, code, text) {

        if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
            if (validateForm(sheetObjects[0],document.form,IBCREATE)) {

                var formObj = document.form;

                var arrText = text.split("|");

                if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {

                    formObj.svc_scp_nm.value = formObj.svc_scp_cd.GetText(code,1);

                    searchConditionReset(formObj,"1");

                    if(eventStatus != "IBCOPY") doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

                    formObj.svc_scp_nm.focus();
                }

            } else {
                comboObjects[0].Index = "-1";
            }
        }   
    }
    
    /**
     * service scope combo 초기화시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     *      
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
    function svc_scp_cd_OnClear(comboObj) {
        var formObject = document.form;
        formObject.svc_scp_nm.value = "";

        comboObj.Index2 = -1;
    }
    
    /**
     * service scope combo 포커스 아웃시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     *      
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
    function svc_scp_cd_OnBlur(comboObj) {

        var formObj = document.form;

        if (!validateForm(sheetObjects[0],document.form,IBCREATE)) return;

        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != null && code != "") {

            var text = comboObj.GetText(code, 1);

            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
                searchConditionReset(formObj,"1");

                if(eventStatus != "IBCOPY") doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

                formObj.svc_scp_nm.focus();
            }
        }
    }
    
    /**
     * IBCombo 인 경우 날짜 체크<br>
     * <br><b>Example :</b>
     * <pre>
     *      isDateIBCombo(comboObj)
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
    function isDateIBCombo(comboObj) {

        if(ComIsEmpty(comboObj.Text)) return;

        if(!ComIsDate(comboObj.Text)) {
            ComPriDateFormatFailed("Effective Date");
            comboObj.Text2 = "";
            comboObj.focus();
            return false;
        }

        return true;
    }
    
    /**
     * eff_dt combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     *      gline_seq_OnChange(comboObj, code, text);
     * </pre>
     * @param {comboObj} comboObj    
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
    function gline_seq_OnChange(comboObj, code, text) {

        if(comboObjects[1].GetCount () > 0 && comboObjects[1].Index != "-1") {

            if (validateForm(sheetObjects[0],document.form,IBCREATE)) {

                if(!isDateIBCombo(comboObj)) {
                    comboObj.focus();
                    return;
                }

                var formObj = document.form;

                var arrText = text.split("|");

                if (arrText[1] != null && arrText[1] != undefined) {
                    formObj.eff_dt.value =  setDash(comboObj.GetText(code,0));

                    if(!ComIsEmpty(comboObj.GetText(code,1))) {
                        formObj.exp_dt.value =  setDash(arrText[1]);

                        comboObj.Code2   =  code;

                        selectedGlineSeq = code;

                        setNoteNmCd();

                    } else {
                        formObj.exp_dt.focus();

                        selectedGlineSeq = "";
                    }

                }

            } else {
                comboObjects[1].Index = "-1";
                selectedGlineSeq = "";
            }
        }
    }
    
    /**
     * eff_dt combo 포커스 아웃시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     *      gline_seq_OnBlur(comboObj);
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
    function gline_seq_OnBlur(comboObj) {

        var formObj = document.form;

        var glineSeq = formObj.note_hdr_seq.value;

        var selEffDt = comboObj.Text;

        if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
            return false;
        }

        selEffDt = selEffDt.replace(/-/gi, "");
        selEffDt = selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 


        var code = comboObj.FindIndex(selEffDt, 0);
        var expDt = "";

        if(code != "-1" && !ComIsEmpty(glineSeq)) {
            expDt = comboObj.GetText(code, 1); 
        }


        //select
        if(!ComIsEmpty(selectedGlineSeq)) {
            comboObj.SetText(selectedGlineSeq, 0, selEffDt);
            formObj.eff_dt.value = selEffDt;
        }



        if(ComIsEmpty(expDt)) { 

            if(!isDateIBCombo(comboObj)) return;

            var code = comboObj.FindIndex("", 1);
            var txt =  setDash(comboObj.GetText(code,0));

            if(code != "-1") {
                comboObj.DeleteItem(code);
            }

            //combo item insert
            comboObj.InsertItem(-1,selEffDt + "|", selEffDt);
            comboObj.Code = selEffDt;
            formObj.eff_dt.value = selEffDt;

            comboObj.SetText(selEffDt,0,selEffDt);

        } 

        //auto search or select
        else {
//          if(selectedGlineSeq != "") {
            if(!isDateIBCombo(comboObj)) {
                comboObj.focus();
                return;
            }

            formObj.eff_dt.value = selEffDt;
//          }   
        }

    }
    
    /**
     * NOTE NAME COMBO 리스트를 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      setNoteNmCd();
     * </pre>
     * @param 없음
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
    function setNoteNmCd() {

        var formObj = document.form;

        if(eventStatus == "IBCOPY") return;


        //eff_dt combo를 선택한 경우 
//      if(!ComIsEmpty(formObj.note_hdr_seq.value)) {

        //같은 듀레이션의 노트가 다 나오도록 hdr_seq를 reset
        formObj.note_hdr_seq.value =  "";


        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);

        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();

        formObj.note_nm_cd.Index2 = "-1";
        formObj.prc_cust_tp_cd.Index2 = "-1";


//      formObj.exp_dt_hidden_select.value = "";
        formObj.cfm_flg.focus();

        return;
//      }


    }

    /**
     * note_nm_cd combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     *      
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
    function note_nm_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        if(eventStatus != "IBCOPY") {
            if(comboObjects[2].GetCount () > 0 && comboObjects[2].Index != "-1") {
                if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {

//                  formObj.eff_dt.value = setDash(formObj.eff_dt.value);
//                  formObj.exp_dt.value = setDash(formObj.exp_dt.value);

                    //note_nm_cd의 키 값을 세팅
                    formObj.note_hdr_seq.value = code;

                    //note_nm_cd의 text 값을 세팅
                    formObj.note_nm.value = getNoteNmTxt(code);

                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

                    if(eventStatus != "IBSAVE")
                        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);

                } 
            }   
        }   
    }
    
    /**
     * exp_dt 이후의 데이터를 리셋한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll4(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeAll4(formObj) {

        comboObjects[3].Index = "-1";

        comboObjects[2].Index = "-1";
        comboObjects[2].RemoveAll();


//      formObj.reset();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();

        eventStatus = "";
        toggleButtons("INIT");
    }

    /**
     * year를 제외한 화면을 리셋한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll3(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeAll3(formObj) {

        var note_ref_yr = formObj.note_ref_yr.value;

        comboObjects[3].Index = "-1";

        comboObjects[2].Index = "-1";
        comboObjects[2].RemoveAll();

        comboObjects[1].Index = "-1";
        comboObjects[1].RemoveAll();

        comboObjects[0].Index = "-1";

        formObj.reset();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();

        eventStatus = "";
        toggleButtons("INIT");

        formObj.note_ref_yr.value = note_ref_yr;
    }
    
    /**
     * 화면을 전체 리셋한다.(전체 Delete 후 초기화)<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll2(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeAll2(formObj) {

        var note_ref_yr = formObj.note_ref_yr.value;
        var svc_scp_nm = formObj.svc_scp_nm.value;

        comboObjects[3].Index = "-1";

        comboObjects[2].Index = "-1";
        comboObjects[2].RemoveAll();

        comboObjects[1].Index = "-1";
        comboObjects[1].RemoveAll(); 

        formObj.reset();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();

        eventStatus = "";
        toggleButtons("INIT");

        formObj.note_ref_yr.value = note_ref_yr;
        formObj.svc_scp_nm.value = svc_scp_nm;

        doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

        if(formObj.gline_seq.GetCount() <= 0) {
            comboObjects[0].Index = "-1";
            formObj.reset();
        }

        formObj.note_ref_yr.focus();
    }
    
    /**
     * 화면을 전체 리셋한다.<br>
     * 데이터가 변경된 경우 저장한다.
     * <br><b>Example :</b>
     * <pre>
     *     removeAll(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeAll(formObj) {

        if (checkModified(formObj)) {

            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm = true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm = false;
            } else {

                comboObjects[3].Index = "-1";

                comboObjects[2].Index = "-1";
                comboObjects[2].RemoveAll();

                comboObjects[1].Index = "-1";
                comboObjects[1].RemoveAll();

                comboObjects[0].Index = "-1";


                formObj.reset();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();

            }
        } else {    
            comboObjects[3].Index = "-1";

            comboObjects[2].Index = "-1";
            comboObjects[2].RemoveAll();

            comboObjects[1].Index = "-1";
            comboObjects[1].RemoveAll();

            comboObjects[0].Index = "-1";

            formObj.reset();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();

        }

        formObj.note_ref_yr.focus();

        eventStatus = "";
        toggleButtons("INIT");
    }
    
    /**
     * 조회 조건을 리셋한다.<br>
     * 데이터가 변경된 경우 저장한다.
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {form} formObj 
     * @param {String} gubun    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function searchConditionReset(formObj,gubun) {

        if(eventStatus == "IBCOPY") return;

        //sc change
        if(gubun == "1") {
            comboObjects[1].Index = "-1";
            comboObjects[1].RemoveAll();
            //alert(0)
            formObj.eff_dt.value = "";
            formObj.exp_dt.value = "";
            comboObjects[2].Index = "-1";
            comboObjects[2].RemoveAll();
            comboObjects[3].Index = "-1";
            formObj.cfm_flg.value = "";
            formObj.note_nm.value = "";

            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        } 
        //eff_dt change
        else if(gubun == "2") { 
            //formObj.exp_dt.value = "";
            comboObjects[2].Index = "-1";
            comboObjects[2].RemoveAll();
            comboObjects[3].Index = "-1";
            formObj.cfm_flg.value = "";
            formObj.note_nm.value = "";

            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }

        toggleButtons("INIT");
    }

    /**
     * copy 시 기존 조회 조건을 히든값에 카피한 후 조회조건 리셋.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sremoveCopy(formObj)
     * </pre>
     * @param {form} formObj   
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeCopy(formObj) {

        if (eventStatus == "IBCOPY") {
            return false;
        }
        //alert(1111)
        var svc_scp_cd_beforeCopy       = comboObjects[0].Code;
        var prc_cust_tp_cd_beforeCopy   = comboObjects[2].Code;
        var note_hdr_seq_beforeCopy     = formObj.note_hdr_seq.value;

        comboObjects[0].Index = "-1";
//      comboObjects[0].RemoveAll();

        comboObjects[1].Index = "-1";
        comboObjects[1].RemoveAll();
        comboObjects[2].Index = "-1";
        comboObjects[2].RemoveAll();
        comboObjects[3].Index = "-1";
//      sheetObjects[1].RemoveAll();
//      sheetObjects[2].RemoveAll();

        formObj.reset();

        formObj.svc_scp_cd_copy.value       = svc_scp_cd_beforeCopy;
        formObj.prc_cust_tp_cd_copy.value   = prc_cust_tp_cd_beforeCopy;
        formObj.note_hdr_seq_copy.value     = note_hdr_seq_beforeCopy;
        formObj.note_hdr_seq.value          = note_hdr_seq_beforeCopy;

        formObj.note_ref_yr.focus();
    }

    /**
     * comboObjects[0]의 code값을 리턴<br>
     * <br>
     * <b>Example :</b>
     * <pre>
     *     code = getSvcScpCd();
     * </pre>
     *
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */
    function getSvcScpCd() {
        return comboObjects[0].Code;
    }

    /**
     * comboObjects[1]의 code값을 리턴<br>
     * <br>
     * <b>Example :</b>
     * <pre>
     *     code = getGlineSeq();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getGlineSeq() {
        return comboObjects[1].Code;
    }

    /**
     * comboObjects[1]의 Text값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var txt = getGlineSeqTxt();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getGlineSeqTxt() {
        return comboObjects[1].Text;
    }
    /**
     * comboObjects[2]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getNoteNmCd();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getNoteNmCd() {
        return comboObjects[2].Code;
    }

    /**
     * comboObjects[2]의text값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getNoteNmTxt();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getNoteNmTxt() {
        //return comboObjects[2].GetText(code,0);
         return comboObjects[2].Text;
    }

    /**
     * comboObjects[3]의 text값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getCustTypeCd();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getCustTypeCd() {
        return comboObjects[3].Code;
    }

    /**
     * eff_dt 의 value값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getEffDt();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getEffDt() {
        return document.form.eff_dt.value;
    }

    /**
     * exp_dt 의 value값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getExpDt();
     * </pre>
     * @return string
     * @author 이승준
     * @version 2009.06.10
     */
    function getExpDt() {
        return document.form.exp_dt.value;
    }

    /**
     * 변경사항이 있으면 true 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      checkModified(formObj)
     * </pre>
     * @return boolean <br>
     * @author 이승준
     * @version 2009.06.10
     */
    function checkModified(formObj) {
        isModified = false;

        if (formObj.note_ref_yr.value != formObj.note_ref_yr_hidden.value
            || formObj.eff_dt.value != formObj.eff_dt_hidden.value
            || formObj.exp_dt.value != formObj.exp_dt_hidden.value
            || getNoteNmTxt() != formObj.note_nm_hidden.value
            || getSvcScpCd() != formObj.svc_scp_cd_hidden.value
            || getCustTypeCd() != formObj.prc_cust_tp_cd_hidden.value
            || sheetObjects[1].IsDataModified
            || sheetObjects[2].IsDataModified) {

            isModified = true;
        }

        return isModified;
    }

    /**
     * 날짜에 -를 세팅한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(comboObject)
     * </pre>
     * @param {string} 날짜 comboObject
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
    function setDashIBCombo(obj) {

        if(obj.Text == "" || obj.Text.length == 0) return;

        var date = obj.Text.replace(/-/g, "");

        if(!ComIsNumber(date,'0123456789')) {
            ComShowCodeMessage('PRI00311');
            obj.Text2 = "";
            //obj.focus();
            return;
        }

        var str = "";
        for(var i=0; i<date.length; i++) {
            if(i == 4 || i == 6) {
                str += "-" + date.substring(i,i+1);
            }
            else {
                str += date.substring(i,i+1);
            }
        }
        obj.Text2 = str;
    }

    /**
     * 날짜에 -를 세팅한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(date)
     * </pre>
     * @param {string} 날짜 input box의 value
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
    function setDash(value) {

        if(value == "" || value.length == 0) return;

        var date = ComTrimAll(value).replace(/-/g, "");

        var str = "";
        for(var i=0; i<date.length; i++) {
            if(i == 4 || i == 6) {
                str += "-" + date.substring(i,i+1);
            }
            else {
                str += date.substring(i,i+1);
            }
        }
        return str;

    }

    /**
     * 날짜에 -를 remove한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      removeDash(date)
     * </pre>
     * @param {string} 날짜 input box의 value
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
    function removeDash(date) {
        if(date == "" || date.length == 0) return;

        date = date.replace(/-/g, "");

        return date;
    }

    /**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function toggleButtons(mode) {

        switch (mode) {

            case "INIT":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_cancel");
                ComBtnDisable("btn_delete3");
                ComBtnDisable("btn_copy");

                ComBtnEnable("btn_add");
                ComBtnEnable("btn_add2");
                ComBtnEnable("btn_delete");
                ComBtnEnable("btn_delete2");
                
                ComBtnDisable("btn_downexcel");
                
                sheetControl(true);
                break;
            case "CONF_YES":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnDisable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnEnable("btn_cancel");
                ComBtnDisable("btn_delete3");
                ComBtnEnable("btn_copy");

                ComBtnDisable("btn_add");
                ComBtnDisable("btn_add2");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_delete2");

                ComBtnEnable("btn_downexcel");
                
                sheetControl(false);
                break;
            case "CONF_NO":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_confirm");
                ComBtnDisable("btn_cancel");
                ComBtnEnable("btn_delete3");
                ComBtnEnable("btn_copy");

                ComBtnEnable("btn_add");
                ComBtnEnable("btn_add2");
                ComBtnEnable("btn_delete");
                ComBtnEnable("btn_delete2");

                ComBtnEnable("btn_downexcel");
                
                sheetControl(true);
                break;
            case "IBCOPY":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_cancel");
                ComBtnDisable("btn_delete3");
                ComBtnDisable("btn_copy");

                ComBtnDisable("btn_add");
                ComBtnDisable("btn_add2");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_delete2");

                ComBtnDisable("btn_downexcel");                
                sheetControl(false);
                break;
            case "CONV":
                ComBtnEnable("btn_save");

                ComBtnEnable("btn_downexcel");                
                break;

        }
    }

    /**
     * IBSheet의 Cell을  컨폼 여부에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sheetControl(mode);
     * </pre>
     * @param   {boolean} flag 필수
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheetControl(flag) {
        var sheetObj1 = sheetObjects[1];
        var sheetObj2 = sheetObjects[2];

        for (var i = 1; i <= sheetObj1.RowCount;i++) {
            sheetObj1.CellEditable(i, "chk") = flag;
//          sheetObj1.CellEditable(i, "note_tit_nm") = flag;
        }

        for (var i = 1; i <= sheetObj2.RowCount;i++) {
            sheetObj2.CellEditable(i, "chk") = flag;
        }
    }

    /**
     * 버튼을 confirm에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setConfirmButton()
     * </pre>
     * @param {String} mode
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function setConfirmButton()  {
        var cfm_flg = document.form.cfm_flg.value;

        if(cfm_flg == "Yes") toggleButtons("CONF_YES");
        else if(cfm_flg == "No") toggleButtons("CONF_NO");
    }

    /**
     * 저장시 dp_seq 세팅.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setDpSeq(sheetObj)
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function setDpSeq(sheetObj)  {
        if(!sheetObj.IsDataModified) return;

//        for(var i=1; i<=sheetObj.RowCount; i++) {
//            sheetObj.CellValue2(i, "dp_seq") = i;
//
//            if(sheetObj.RowStatus(i) == "R") {
//                sheetObj.RowStatus(i) = "U";
//            }
//        }
        var idx = 0;
        for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n ; i++) {
            sheetObj.CellValue(i, "dp_seq") = ++idx;
        }
    }

    /**
     * 년도 OnKeyPress 시 호출된다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchDuration
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function searchDuration() {

        if(ComIsEmpty(document.form.note_ref_yr)) return;

        if(!ComIsNumber(document.form.note_ref_yr,'0123456789')) {
            ComShowCodeMessage('PRI00311');
            document.form.note_ref_yr.value = "";
            return;
        }

        if(eventStatus == "IBCOPY") return;

        var formObj = document.form;
        var length = document.form.note_ref_yr.value.length;

        if(length == 4) {
            if(getSvcScpCd() != "" && getGlineSeq() == "") {
                removeAll3(document.form);
//              comboObjects[0].focus();
                return;
            }
        }

        if(length == 4) {
            var note_ref_year = formObj.note_ref_yr.value;
            if(!ComIsEmpty(formObj.note_hdr_seq.value)) {
                if (note_ref_year != formObj.eff_dt.value.substr(0,4) && note_ref_year != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00323');
                    formObj.note_ref_yr.value = formObj.note_ref_yr_hidden.value;
                    formObj.note_ref_yr.focus();
                    return false;
                }
            }
        }
    }

    /**
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
     * @author 이승준
     * @version 2009.06.03
     */
    function showMemoPad(sheetObj, Row, Col) {

        if(isFiredNested) return;

        var cfm_flg = document.form.cfm_flg.value;
        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "note_tit_nm":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,892,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,892,200);
                break;
        }
    }


    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
     * @author 이승준
     * @version 2009.06.03
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {

        if(isFiredNested) return;

        var cfm_flg = document.form.cfm_flg.value;

        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "note_tit_nm":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,892,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,892,200);

                break;
        }
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
     * @author 이승준
     * @version 2009.06.03
     */
    function sheet2_OnClick(sheetObj, Row, Col, Value) {

        var cfm_flg = document.form.cfm_flg.value;

        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "note_ctnt":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,700,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,700,200);
                break;
        }
    }

    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Standard Note Conversion PopUp을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 최성민
     * @version 2009.05.07
     */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        var effDt = formObj.eff_dt.value;
        var expDt = formObj.exp_dt.value;
        //var expDt = "99991231"; //2009.11.09 적용

        if (colName == "conversion_pop") {
            if(!ComIsNull(sheetObj.CellValue(Row, "note_conv_mapg_id")))    {
                var sParam = "";
                sParam += "svc_scp_cd=" + getSvcScpCd();
                sParam += "&note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
                sParam += "&prc_ctrt_tp_cd=" + getCustTypeCd();
                sParam += "&note_hdr_seq=" + sheetObj.CellValue(Row, "note_hdr_seq");
                sParam += "&note_ctnt=" + encodeURIComponent(sheetObj.CellValue( Row, "note_ctnt"));
                sParam += "&eff_dt=" + effDt;
                sParam += "&exp_dt=" + expDt;

                var sUrl = "/hanjin/ESM_PRI_0008.do?"+sParam;

                var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0008", 825, 500, true);

                if (rtnVal != null) {
                    var prevStatus = sheetObj.RowStatus(Row);
                    sheetObj.CellValue2(Row, "note_conv_flg") = rtnVal.note_conv_flg;
                    sheetObj.RowStatus(Row) = prevStatus;

                    eventStatus2 = "CONV";
                    toggleButtons("CONV");
                }
            } else {
                ComShowCodeMessage("PRI08015");
            }
        }
    }

    /**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet1_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj
     * @param {String} ErrMsg
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        sheetObj.SelectCell(selectedMrow, 1, false);
    }

    /**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet2_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj
     * @param {String} ErrMsg
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        sheetObj.SelectCell(selectedDrow, 1, false);
    }

    /* 개발자 작업  끝 */