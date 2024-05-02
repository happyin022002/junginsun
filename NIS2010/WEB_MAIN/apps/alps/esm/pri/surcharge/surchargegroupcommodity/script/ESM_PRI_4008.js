/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4008.js
*@FileTitle : Surcharge Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.08 이승준
* 1.0 Creation
=========================================================
* History
* 2015.06.19 전지예 [CHM-201536236] Non-Cargo NOS 체크박스 삽입
* 2015.07.03 전지예 [CHM-201536741] Blocking 되어 있는 Non cargo NOS를 User가 화면에서 정정가능하도록 Open
* 2015.09.04 전지예 [CHM-201537789] [Non-Cargo NOS] Surcharge Commodity Group 관련 요청_끗
* 2016.02.04 전지예 [CHM-201640066] TPW Non-Cargo NOS 체크 권한 로직 부여 Request by Hye-In Ahn
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
     * @class ESM_PRI_4008 : ESM_PRI_4008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4008() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    ﻿
    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;
    
    var eventStatus = "";

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
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_add":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;

                case "btn_del":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;

                case "btn_add2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;

                case "btn_del2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;		

                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;

                case "btn_new":
                    searchConditionReset(document.form);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
     * setSheetObject(sheetObj);
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
        doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
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
                    Style = 0;
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseCode = true;
                    UseAutoComplete = false;
                    ValidChar(2, 0);
                    MaxLength = 3;
                }
                break;

        }
    }

    /**
     * comboObjects[0]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */
    function getSvcScpCd() {
        return comboObjects[0].Code;
    }

    /**
     * comboObjects[0]의 Text값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      var code = getSvcScpTxt(code);
     * </pre>
     * @param {String} code
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */
    function getSvcScpTxt(code) {
        return comboObjects[0].GetText(code,1);
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

        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != "-1") {
            var text = comboObj.GetText(comboObj.Text, 1);

            if (text == "" && !ComIsEmpty(comboObj.Text)) {
                formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
                searchConditionReset(formObj,"1");
                doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
                formObj.svc_scp_nm.focus();
            }
        } else {
            ComShowCodeMessage("PRI00315");
            comboObj.Text = "";
            comboObj.Index = "-1";
            formObj.svc_scp_nm.value = "";

            sheetObjects[1].removeAll();
            sheetObjects[2].removeAll();
        }
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
            var formObj = document.form;
            var desc = null;
            if (isNaN(parseInt(code, 10))) {
                desc = formObj.svc_scp_cd.GetText(code,1);
            } else {
                desc = formObj.svc_scp_cd.GetIndexText(code,1);
            }
            formObj.svc_scp_nm.value = desc;
            
            // TPW, ACW Scope에만 NON Cargo NOS 적용
            if(comboObjects[0].Code == 'TPW' || comboObjects[0].Code == 'ACW') {
            	document.all.notice.style.display = "inline";
            	sheetObjects[2].ColHidden("non_cgo_nos_flg") = false;
            	sheetObjects[3].ColHidden("non_cgo_nos_flg") = false;
            } else {
            	document.all.notice.style.display = "none";
            	sheetObjects[2].ColHidden("non_cgo_nos_flg") = true;
            	sheetObjects[3].ColHidden("non_cgo_nos_flg") = true;
            }
            
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
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
        var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet0":      //hidden
                with (sheetObj) {
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                }
                break;

            case "sheet1":      //hidden
                with (sheetObj) {

                    // 높이 설정
                    style.height = 458;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Group\nCode|Group Name|Delete\nMark|Creation\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,   false,     "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,    40,    daCenter,   false,     "chk");
                    InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   false,     "scg_grp_cmdt_cd",       true,    "",   dfNone,     0,  false, false, 2);
                    InitDataProperty(0, cnt++ , dtData,          120,   daLeft,     false,     "scg_grp_cmdt_desc",     true,    "",   dfNone,     0,  true,  true);
                    InitDataProperty(0, cnt++,  dtCheckBox,      50,    daCenter,   false,     "delt_flg",              false,   "",   dfNone,     0,  true,  true,0,   false,false,"",false);
                    InitDataProperty(0, cnt++ , dtData,          60,    daCenter,   false,     "cre_dt",                false,   "",   dfNone,     0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,     "svc_scp_cd",            false,   "",   dfNone,     0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,     "chg_cd",                false,   "",   dfNone,     0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,     "scg_grp_cmdt_seq",      false,   "",   dfNone,     0,  false, false);

                    InitDataValid(0, "scg_grp_cmdt_cd", vtNumericOnly);     // 숫자만 입력
                    WaitImageVisible = false;

                }
                break;

            case "sheet2":      //hidden
                with (sheetObj) {

                    // 높이 설정
                    style.height = 458;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Non-Cargo\nNOS|Seq.|Commodity\nCode|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq|scg_grp_cmdt_dtl_seq|non_cgo_nos_auth";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,    40,    daCenter,   false,  "chk");
                    InitDataProperty(0, cnt++,  dtCheckBox,	70,	daCenter,		false,	"non_cgo_nos_flg",		false,	"",	dfNone,	0,	false, false,	0,	false, false, "", false);
                    InitDataProperty(0, cnt++ , dtSeq,           40,    daCenter,   false,  "Seq");
                    InitDataProperty(0, cnt++ , dtPopupEdit,     90,    daCenter,   false, "cmdt_cd",               true,    "",  dfNone,  0, true,  true ,6);
                    InitDataProperty(0, cnt++ , dtData,          250,   daLeft,     false,  "cmdt_des",             false,   "",  dfNone,  0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   false,  "eff_dt",               true,    "",  dfDateYmd,  0,  true,  true);
                    InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   false,  "exp_dt",               true,    "",  dfDateYmd,  0,  true,  true);
                    InitDataProperty(0, cnt++ , dtData,          70,    daCenter,   false,  "upd_dt",               false,   "",  dfNone,  0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,  "svc_scp_cd",           false,   "",  dfNone,  0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,  "chg_cd",               false,   "",  dfNone,  0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,  "scg_grp_cmdt_seq",     false,   "",  dfNone,  0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,  "scg_grp_cmdt_dtl_seq", false,   "",  dfNone,  0,  false, false);
                    InitDataProperty(0, cnt++,  dtHidden,        90,    daLeft,     false,  "non_cgo_nos_auth", false,   "",  dfNone,  0,  false, false);

                    InitDataValid(0, "cmdt_cd", vtNumericOnly);     // 숫자만 입력
                    ShowButtonImage = 2;
                    ColHidden("exp_dt") = true;
                    WaitImageVisible = false;

                }
                break;

            case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 270;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle = "Non-Cargo\nNOS|Seq.|Service Scope|Charge|Group\nCode|Group Name|Delete\nMark|Creation\nDate|Commodity\nCode|Description|Effective\nDate|Update\nDate";

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                    // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                    // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                    // SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,    90,  daCenter,	false, "non_cgo_nos_flg",		false, "", dfNone,	0,	false,  false,	0,	false, false, "", false);
                    InitDataProperty(0, cnt++, dtDataSeq, 50,  daCenter,    false, "seq");
                    InitDataProperty(0, cnt++, dtData,    90,  daLeft,      false, "svc_scp_cd",        true,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,    90,  daLeft,      false, "chg_cd",            true,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,    90,  daLeft,      false, "scg_grp_cmdt_cd",   true,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,    90,  daLeft,      false, "scg_grp_cmdt_desc", true,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,    100, daCenter,    false, "delt_flg",          true,  "", dfNone, 0, true,  true);
                    InitDataProperty(0, cnt++, dtData,    200, daLeft,      false, "cre_dt",            true,  "", dfNone, 0, true,  true);
                    InitDataProperty(0, cnt++, dtData,    100, daCenter,    false, "cmdt_cd",           true,  "", dfNone, 0, true,  true);
                    InitDataProperty(0, cnt++, dtData,    200, daLeft,      false, "cmdt_des",          true,  "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,    100, daCenter,    false, "eff_dt",            false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,    100, daLeft,      false, "upd_dt",            false, "", dfNone, 0, false, false);

                    Visible = false;
                    WaitImageVisible = false;
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

                comboObjects[0].Index = "-1";
                comboObjects[0].Code = "TPW";
                break;

            case IBSEARCH:      //조회
                if (validateForm(sheetObj,document.form,sAction)) {
                    try {
                        ComOpenWait(true);

                        if ( sheetObj.id == "sheet1") {
                            for (var i = 0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }

                            formObj.f_cmd.value = SEARCH01;
                            sheetObj.DoSearch("ESM_PRI_4008GS.do", FormQueryString(formObj));
                        }
                        else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value = SEARCH02;
                            sheetObj.DoSearch("ESM_PRI_4008GS.do", FormQueryString(formObj));
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
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }

                eventStatus = "IBSAVE";
                formObj.f_cmd.value = MULTI01;
                var sParam = FormQueryString(formObj);
                sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");

                try {
                    ComOpenWait(true);
                    var sXml = sheetObj.GetSaveXml("ESM_PRI_4008GS.do", sParam);
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
                break;

            case IBINSERT: // Row Add

                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        var idx = doRowChange(sheetObj, sheetObjects[2], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
                        if (idx < 0) {
                            return false;
                        }

                        //service scoup
                        sheetObj.CellValue(idx, "svc_scp_cd")     = getSvcScpCd();
                        sheetObj.CellValue(idx, "chg_cd") = formObj.chg_cd.value;
                        //맥스시퀀스 세팅
                        sheetObj.CellValue(idx, "scg_grp_cmdt_seq") = parseInt(formObj.max_seq.value, 10) + 1;

                        //GROUP CODE 자동 채번
                        var scg_grp_cmdt_cd = "01";
                        if(sheetObj.RowCount > 1) {
                            var max_seq = (parseInt(formObj.max_seq.value, 10) + 1) + "";

                            if(max_seq.length ==1) {
                                scg_grp_cmdt_cd = "0" + max_seq;
                            }

                            else if(max_seq.length ==2) {
                                scg_grp_cmdt_cd = max_seq;
                            }

                            else if(max_seq.length ==3) {
                                return;
                            }
                        }
                        sheetObj.CellValue2(idx, "scg_grp_cmdt_cd") = scg_grp_cmdt_cd;
                        sheetObjects[2].RemoveAll();

                        //max 1  증가
                        formObj.max_seq.value = sheetObj.CellValue(idx, "scg_grp_cmdt_seq");

                        sheetObj.SelectCell(idx,"scg_grp_cmdt_desc");
                    } else if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataInsert();
                        sheetObj.CellValue(idx, "svc_scp_cd")     = getSvcScpCd();
                        sheetObj.CellValue(idx, "chg_cd") = formObj.chg_cd.value;
                        var scg_grp_cmdt_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "scg_grp_cmdt_seq");
                        sheetObj.CellValue(idx, "scg_grp_cmdt_seq") = scg_grp_cmdt_seq;
                        sheetObj.CellValue(idx, "scg_grp_cmdt_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "scg_grp_cmdt_dtl_seq"), 10) + 1;

                        //exp_date
                        sheetObj.CellValue(idx, "exp_dt") = "99991231";
                        sheetObj.SelectCell(idx,"cmdt_cd");
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

                var delCnt = deleteRowCheck(sheetObj, "chk");

                //삭제한 row를 제외한 맥스값 다시 세팅
                formObj.max_seq.value = ComPriGetMaxExceptDelete(sheetObj, "scg_grp_cmdt_seq");

                if (delCnt > 0 && sheetObj.id == "sheet1") {
                    for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
                        sheetObjects[2].CellValue(i, "chk") = "1";
                    }
                    deleteRowCheck(sheetObjects[2], "chk");
                }
                break;

            case IBDOWNEXCEL:
                if (validateForm(sheetObj,document.form,sAction)) {
                    formObj.f_cmd.value = SEARCH03;
                    sheetObj.DoSearch("ESM_PRI_4008GS.do" , FormQueryString(formObj));
                    sheetObj.Down2Excel(-1);
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

            case IBSEARCH: // 조회

                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }

                return true;
                break;

            case IBSAVE: // 저장

                if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
                    return false;
                }

                if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
                    return false;
                }

                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }

                if (!sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }

                if (sheetObjects[1].IsDataModified ) {
                    var rowM = sheetObjects[1].ColValueDup("svc_scp_cd|chg_cd|scg_grp_cmdt_cd",false);
                    if (rowM >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet", rowM);
                        return false;
                    }
                }

                if (sheetObjects[2].IsDataModified ) {
                    var rowD = sheetObjects[2].ColValueDup("cmdt_cd",false);
                    if (rowD >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet", rowD);
                        return false;
                    }
                }

                //sheet1에서 하나라도 저장했는지 체크
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    ComPriInputValueFailed("input","Group Code","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }

                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("PRI00319", "Commodity Code");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }

                return true;
                break;

            case IBINSERT: // Row Add
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }

                return true;
                break;


            case IBDELETE: // Delete
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }

                return true;
                break;

            case IBDOWNEXCEL:      // excel down
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }

                return true;
                break;
        }

        return true;
    }

    /**
     * sheet에서 데이터가 변경시 호출된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row
     * @param {int} Col
     * @param {String} Value
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
        setDeltFlg(Row);
    }

    /**
     * sheet에서 데이터가 변경시 호출된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row
     * @param {int} Col
     * @param {String} Value
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value){
        var colname = sheetObj.ColSaveName(Col);
        var formObj = document.form
        switch(colname) {
            case "cmdt_cd":
                if (Value.length==6){
                    formObj.f_cmd.value = SEARCH08;
                    formObj.cd.value=sheetObj.Cellvalue(Row,Col);
                    var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                    var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

                    if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                        sheetObj.CellValue2(Row,"cmdt_des") = arrData[1];
                    }else{
                        ComShowCodeMessage("PRI00315");
                        sheetObj.Cellvalue2(Row,"cmdt_cd") = "";
                        sheetObj.Cellvalue2(Row,"cmdt_des") = "";
                        sheetObj.SelectCell(Row,"cmdt_cd");
                    }
                }else{
                    ComShowCodeMessage("PRI00315");
                    sheetObj.Cellvalue2(Row,"cmdt_cd") = "";
                    sheetObj.Cellvalue2(Row,"cmdt_des") = "";
                    sheetObj.SelectCell(Row,"cmdt_cd");
                }
            break;
        }
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
    function searchConditionReset(formObj) {

        if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {

            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm = true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm = false;
            } else {
                //sc change
                comboObjects[0].Index = "-1";
                formObj.svc_scp_nm.value = "";

                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {
            //sc change
            comboObjects[0].Index = "-1";
            formObj.svc_scp_nm.value = "";

            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
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
                formObj.f_cmd.value = SEARCH02;
                formObj.scg_grp_cmdt_seq.value = sheetM.CellValue(NewRow,"scg_grp_cmdt_seq");
                if(formObj.scg_grp_cmdt_seq.value == "undefined" || ComIsEmpty(formObj.scg_grp_cmdt_seq.value)) {
                    formObj.scg_grp_cmdt_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"scg_grp_cmdt_seq");
                }

                try {
                    ComOpenWait(true);
                    sheetD.DoSearch("ESM_PRI_4008GS.do", FormQueryString(formObj));
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
    }

    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Location PopUp을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;

        if (colName == "cmdt_cd"){
            var sUrl = "/hanjin/ESM_PRI_4027.do?commodity_cmd=C";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);

            if (rtnVal != null){
                sheetObj.CellValue2(Row, Col) = rtnVal.cd;
                sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
            }
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
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, colName);
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
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, colName);
        }
    }

    /**
     * 조회 시 etc data에서 맥스시퀀스 세팅. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {String} ErrMsg
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSearchEnd(ErrMsg)  {
        var formObj = document.form;
        formObj.max_seq.value = sheetObjects[1].EtcData("max_seq");
    }
    
    /**
    * OnSearchEnd 이벤트 발생시 호출되는 function <br>
    * Non-Cargo NOS 권한 여부에 따라 편집 가능하도록 활성화 시켜준다.<br>
    * <br><b>Example :</b>
    * <pre>
    * 	sheet2_OnSearchEnd(sheetObj, errMsg)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
    * @return 없음
    * @author 
    * @version 2016.02.02
    */ 	
    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	var formObj = document.form;
    	// Non-Cargo NOS 편집 권한
    	if(comboObjects[0].Code == 'TPW' || comboObjects[0].Code == 'ACW') {
    		if( sheetObj.CellValue(1,"non_cgo_nos_auth") == 'Y') {
    			for (var i = 1; i <= sheetObj.RowCount;i++){
    				sheetObj.CellEditable(i, "non_cgo_nos_flg") = true;
    			}
    		}
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
     * @return 없음
     * @author 문동규
     * @version 2010.03.11
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                doRowChange(sheetObjects[1], sheetObjects[2], -1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, false);
            }
        }
    }

    /**
     * delt_flag가 체크된 경우 의 row 와  detail sheet disable한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     setDeltFlg(Row)
     * </pre>
     * @param {String} Row
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function setDeltFlg(Row)  {

        var formObj = document.form;
        var delt_flg = sheetObjects[1].CellValue(Row,"delt_flg");

        if(delt_flg == "1") {
            sheetObjects[1].CellEditable(Row, "scg_grp_cmdt_desc") = false;
        }
        else if(delt_flg == "0") {
            sheetObjects[1].CellEditable(Row, "scg_grp_cmdt_desc") = true;
        }
    }

    /* 개발자 작업  끝 */