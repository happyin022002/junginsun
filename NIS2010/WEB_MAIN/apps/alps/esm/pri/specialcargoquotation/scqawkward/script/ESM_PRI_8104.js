/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8104.js
*@FileTitle : Office Hierarchy Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.10 송호진
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
     * @class ESM_PRI_8104 : ESM_PRI_8104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_8104() {
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

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

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
     * @version 2009.08.17
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_close":
                	window.returnValue = "";
                    window.close();
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
     * @version 2009.08.17
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수, IBMultiCombo Object
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
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
     * @author 문동규
     * @version 2009.08.17
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                // khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                // khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
    
            // IBMultiCombo초기화
            for(var k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
    
            var formObj = document.form;
            // 조직도 조회
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            axon_event.addListenerForm('change', 'obj_change', formObj);
            axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
            axon_event.addListener('keyup', 'obj_keyup', 'form');
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
     * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Office Code를 변경하면 조직도,User List,권한정보를 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_change ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function obj_change () {
        try {
            var formObj = document.form;
            var srcName = event.srcElement.getAttribute("name");
            var sheetObject1 = sheetObjects[0];
            var sheetObject2 = sheetObjects[1];
            var sheetObject3 = sheetObjects[2];
            var comboObject1 = comboObjects[0];
            var comboObject2 = comboObjects[1];
    
            if (srcName == "ofc_cd") {
                if (formObj.ofc_cd.value == "") {
                    comboObject2.removeAll();
                    sheetObject2.removeAll();
                    // 전체 조직도 조회
                    doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                } else {
                    comboObject2.removeAll();
                    sheetObject2.removeAll();
                    var idx = sheetObject1.FindText("ofc_cd", formObj.ofc_cd.value);
                    if (idx != -1) {
                        sheetObject1.ShowTreeLevel(0,1);
                        // Tree에서 선택
                        sheetObject1.SelectCell(idx, "ofc_eng_nm");
                        // 사용자콤보 데이터 조회
                        doActionIBSheet(sheetObject3,formObj,IBSEARCH_ASYNC01);
                        // 권한정보 조회
                        doActionIBSheet(sheetObject2,formObj,IBSEARCH);
                    } else {
                        formObj.ofc_cd.value = "";
                        sheetObject1.SelectCell(1, "ofc_eng_nm");
                        sheetObject1.ShowTreeLevel(2, 1);
                    }
                }
            }
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
     * OnKeyUp 이벤트 발생시 호출되는 function <br>
     * Enter 키를 입력하면 조회함수를 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2010.02.04
     */
    function obj_keyup () {
        try {
            var formObj = document.form;
            var sheetObject2 = sheetObjects[1];
            var srcName = event.srcElement.getAttribute("name");
              
            if (event.keyCode == 13) {
                if (srcName == "ofc_cd") {
                    document.body.focus();
                } else {
                    doActionIBSheet(sheetObject2, formObj, IBSEARCH);
                }
            }
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
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * Office Code를 입력하면 해당 User List를 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
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
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1: // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "||Name||";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 10, daLeft, false, "", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "ofc_eng_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "prnt_ofc_cd");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "ofc_cd");
                    WaitImageVisible = false;

                    InitTreeInfo(2, "slevel", RgbColor(0,0,255), true);
                    GridLine = 0;
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
     * @author 문동규
     * @version 2009.08.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCH01;
                    sheetObj.DoSearch("ESM_PRI_8104GS.do", FormQueryString(formObj));
                }
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
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.08.17
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction){

            case IBSEARCH:
                if(sheetObj.id == "sheet2") {
                    if (formObj.ofc_cd.value == "") {
                        // ComShowCodeMessage('PRI01001');
                        ComShowCodeMessage('PRI00316', 'Office Code');
                        formObj.ofc_cd.focus();
                        return false;
                    }
                }
                break;
        }

        return true;
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Node를 펼침 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.06.03
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            sheetObj.ShowTreeLevel(2, 1);
        }
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Node를 펼침 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
     * @param {int} Row 필수, Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 문동규
     * @version 2009.06.03
     */
    function sheet1_OnClick (sheetObj, Row, Col, Value) {
        try {
            var colname = sheetObj.ColSaveName(Col);
    
            switch(colname) {
                case "ofc_eng_nm":
                    var formObj = document.form;
                    window.returnValue = sheetObj.CellValue(Row, "ofc_cd");
                    self.close();
                    break;
    
            }
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


	/* 개발자 작업  끝 */