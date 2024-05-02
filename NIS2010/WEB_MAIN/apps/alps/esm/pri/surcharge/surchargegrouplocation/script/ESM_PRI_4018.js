/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4018.js
*@FileTitle : Surcharge Location Group Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.29 김재연
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
     * @class ESM_PRI_4018 : ESM_PRI_4018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4018() {
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
    ﻿
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    // new 버튼 또는 화면 리셋 플래그
    // var isNew = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var eventStatus = "";

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        
        /*******************************************************/
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
              
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;
    
                case "btn_new":
                    removeAll(document.form);
                    break;
                    
                case "btn_Close":
                    window.close();
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
     * @author 김재연
     * @version 2009.07.29
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
     * @param {ibcombo} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.29
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
     * @author 김재연
     * @version 2009.07.29
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        pageOnLoadFinish();
    }
    
    /**
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.07.29
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
            case "svc_scp_cd":
                var i=0;
                with(comboObj) {
                    Style = 0;
                    //BackColor = "cyan";
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;
           
            case "chg_cd":
                var i=0;
                with(comboObj) {
                    Style = 0;
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;
               
        }
    }
     
    /**
     * svc_scp_cd의 value를 가져오는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		getSvcScpCd()
     * </pre>
     * @return (String)
     * @author 김재연
     * @version 2009.07.29
     */ 
    function getSvcScpCd() {
        return comboObjects[0].Code;
    }
    
    /**
     * chg_cd의 value를 가져오는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		getSvcScpCd()
     * </pre>
     * @return (String)
     * @author 김재연
     * @version 2009.07.29
     */
    function getChgCd() {
        return comboObjects[1].Code;
    } 
     
    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function svc_scp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var arrText = text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.svc_scp_nm.value = arrText[1];
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }

    /**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function svc_scp_cd_OnBlur (comboObj) {
        var formObj = document.form;
        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != -1) {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value = text;
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        } else {
            formObj.svc_scp_nm.value = "";
            comboObj.Code2 = -1;
        }
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * chg_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function chg_cd_OnChange (comboObj, code, text) {
        var formObj = document.form;
        var arrText = text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.chg_nm.value = arrText[1];
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }

    /**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * chg_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function chg_cd_OnBlur (comboObj) {
        var formObj = document.form;
        var code = comboObj.FindIndex(comboObj.Code, 0);
        if (code != -1) {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.chg_nm.value) {
                formObj.chg_nm.value = text;
                doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
            }
        } else {
            formObj.chg_nm.value = "";
            comboObj.Code2 = -1;
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
      * @author 김재연
      * @version 2009.07.29
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
         
            case "sheet1":      //sheet1 init
                 with (sheetObj) {

                    // 높이 설정
                    style.height = 438;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Seq.|Group\nCode|Description|Creation\nDate|svc_scp_cd|chg_cd|grp_loc_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false,      "Seq");
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,      "scg_grp_loc_cd",  false,  "",  dfNone,  0);
                    InitDataProperty(0, cnt++ , dtData,         180,   daLeft,     false,      "scg_grp_loc_desc",false,  "",  dfNone,  0);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   false,      "cre_dt",          false,  "",  dfNone,  0);
                    InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "svc_scp_cd",      false,  "",  dfNone,  0);
                    InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "chg_cd",          false,  "",  dfNone,  0);
                    InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "grp_loc_seq",     false,  "",  dfNone,  0);
                    
                    AutoRowHeight = false;
                    WaitImageVisible = false;
                }
            	break;

            case "sheet2":      //sheet2 init
                 with (sheetObj) {

                    // 높이 설정
                     style.height = 438;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(11, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "Seq.|Location\nType|Code|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_loc_cd|grp_loc_dtl_seq";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false,     "Seq");
                     InitDataProperty(0, cnt++ , dtCombo,        85,    daCenter,   false,     "dtl_loc_tp_cd",    false,   "",  dfNone,     0);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    70,    daCenter,   false,     "dtl_loc_def_cd",   false,   "",  dfNone,     0);
                     InitDataProperty(0, cnt++ , dtData,         110,   daLeft,     false,     "loc_des",          false,   "",  dfNone,     0);
                     InitDataProperty(0, cnt++ , dtData,         80,    daCenter,   false,     "eff_dt",           false,   "",  dfDateYmd,  0);
                     InitDataProperty(0, cnt++ , dtData,         80,    daCenter,   false,     "exp_dt",           false,   "",  dfDateYmd,  0);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   false,     "upd_dt",           false,   "",  dfDateYmd,  0);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "svc_scp_cd",       false,   "",  dfNone,     0);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "chg_cd",           false,   "",  dfNone,     0);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "grp_loc_seq",      false,   "",  dfNone,     0);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "grp_loc_dtl_seq",  false,   "",  dfNone,     0);
                     
                     AutoRowHeight = false;
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
     * @author 김재연
     * @version 2009.07.29
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
         
            case IBCLEAR:
                // 화면 로딩시 Service Scope 조회
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
                
                //공통 - type
                sheetObjects[2].InitDataCombo(0,"dtl_loc_tp_cd", LOCATION_TYPE3[1], LOCATION_TYPE3[0], " ", " ", 0);
                
                break;  
        
            
            case IBSEARCH:      //조회

                if (sheetObj.id == "sheet0") {
                    // Surcharge combo
                    formObj.f_cmd.value = COMMAND12;
                    formObj.etc1.value = getSvcScpCd();
                    sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                    ComPriXml2ComboItem(sXml, formObj.chg_cd, "cd", "cd|nm");
                } else {
                	ComOpenWait(true);
                    if (validateForm(sheetObj,document.form,sAction)) {
                        if ( sheetObj.id == "sheet1") {
                            
                            for (var i = 0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }    
                            
                            formObj.f_cmd.value = SEARCH01;
                            if (formObj.pre_svc_scp_cd.value != "") {
                                sheetObj.DoSearch("ESM_PRI_4029GS.do", FormQueryString(formObj));
                            } else {
                                sheetObj.DoSearch("ESM_PRI_4018GS.do", FormQueryString(formObj));
                            }
        
                        }       
                        else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value = SEARCH02;
                            if (formObj.pre_svc_scp_cd.value != "") {
                                sheetObj.DoSearch("ESM_PRI_4029GS.do", FormQueryString(formObj));
                            } else {
                                sheetObj.DoSearch("ESM_PRI_4018GS.do", FormQueryString(formObj));
                            }
                        }   
                    }
                    ComOpenWait(false);
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
     *         true  : 폼입력값이 유효할 경우<br>
     *         false : 폼입력값이 유효하지 않을 경우
     * @author 김재연
     * @version 2009.07.29
     */
     function validateForm(sheetObj,formObj,sAction){
          switch (sAction) {
          
            case IBSEARCH: // 조회
                
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
            
                if (comboObjects[1].Code == "") {
                    ComPriInputValueFailed("Select","Charge","");
                    return false;
                }   
                
                return true;
                break;
            }

         return true;
     }

     /**
      * 화면 object 값들 reset하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param {form} formObj 필수 html form object
      * @return 없음
      * @author 김재연
      * @version 2009.07.29
      */
    function removeAll(formObj) {
        if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
            
            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm = true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm = false;
            } else {
                comboObjects[0].Index = "-1";
                comboObjects[1].Index = "-1";
                
                formObj.reset();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {    
            comboObjects[0].Index = "-1";
            comboObjects[1].Index = "-1";
            
            formObj.reset();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }
    
    }

    /**
     * 조회 조건 값들 reset하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {form} formObj 필수 html form object
     * @return 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function searchConditionReset(formObj) {
        comboObjects[1].Index = "-1";
        formObj.chg_nm.value = "";  
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        
    }
    
    /**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} OldRow 필수 Onclick 이벤트가 발생하기 이전의 셀 Row Index
	 * @param {int} OldCol 필수 Onclick 이벤트가 발생하기 이전의 셀 Column Index
	 * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index 
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.29
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
    }
    
    var isFiredNested = false;
    var supressConfirm = false;
    
    /**
	 * Row Change 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetM 필수 IBSheet Object
	 * @param {ibsheet} sheetD 필수 IBSheet Object
	 * @param {int} OldRow 필수 Change 할 대상 Row Index
	 * @param {int} NewRow 필수 Change 할 타겟 Row Index
	 * @param {int} OldCol 필수 Change 할 대상 Column Index
	 * @param {int} NewCol 필수 Change 할 타겟 Column Index
	 * @param {int} appendRow 필수 
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.29
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
                formObj.grp_loc_seq.value = sheetM.CellValue(NewRow,"grp_loc_seq");
                if(formObj.grp_loc_seq.value == "undefined" || ComIsEmpty(formObj.grp_loc_seq.value)) {
                    formObj.grp_loc_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"grp_loc_seq");
                }
                if (formObj.pre_svc_scp_cd.value != "") {
                	sheetD.DoSearch("ESM_PRI_4029GS.do", FormQueryString(formObj));
                } else {
                	sheetD.DoSearch("ESM_PRI_4018GS.do", FormQueryString(formObj));
                }
            }
        }
    }
   
    /**
     * sheet1에서 OnBeforeCheck 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
        }
    }
    
    /**
     * sheet2에서 OnBeforeCheck 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
        }
    } 
    
	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.07.29
     */ 
    function pageOnLoadFinish() {
    	 var formObj = document.form;
    	 doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
         
         if(formObj.pre_svc_scp_cd.value != "") {
             comboObjects[0].Code = formObj.pre_svc_scp_cd.value;
             formObj.svc_scp_nm.focus();
             comboObjects[1].Code = formObj.pre_chg_cd.value;
             comboObjects[1].focus();
             comboObjects[0].focus();
         }
    }
     
    /**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.29
	 */
    function sheet1_OnSearchEnd(ErrMsg)  {
        //alert(sheetObjects[1].EtcData("max_seq"))
        //if (ErrMsg == "") {
            var formObj = document.form;
            formObj.max_seq.value = sheetObjects[1].EtcData("max_seq"); 
            
        //}
    }

    /* 개발자 작업  끝 */