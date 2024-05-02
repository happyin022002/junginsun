/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4004.js
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class ESM_PRI_4004 : ESM_PRI_4004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4004() {
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 
    
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
	  * @author 이승준
	  * @version 2009.04.17
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
                    removeAll(document.form);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
	   	 sheetObj.WaitImageVisible = false; 
	   	 doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
//	   	 sheetObj.WaitImageVisible = true; 
    }

    /**
     * IBSHEET COMBO를 LOAD하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * 		initCombo(comboObj, comboNo)
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
                    //BackColor = "cyan";
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 3;
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
     * 		var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
    function getSvcScpCd() {
        return comboObjects[0].Code;
    }
    
    /**
     * comboObjects[1]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getChgCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
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
     * @author 이승준
     * @version 2009.06.05
     */
    function svc_scp_cd_OnChange (comboObj, code, text) {
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
     * @author 이승준
     * @version 2009.06.02
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
     * @author 이승준
     * @version 2009.07.20
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
     * @author 이승준
     * @version 2009.07.20
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
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Seq.|Group\nCode|Description|Creation\nDate|svc_scp_cd|chg_cd|grp_loc_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,      "ibflag");
                     InitDataProperty(0, cnt++,  dtDummyCheck,   40,    daCenter,   false,      "chk");
                     InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false,      "Seq");
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   false,      "scg_grp_loc_cd",  true,   "",  dfNone,  0, true, true,4,true);
                     InitDataProperty(0, cnt++ , dtData,         180,   daLeft,     false,      "scg_grp_loc_desc",true,   "",  dfNone,  0, true, true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   false,      "cre_dt",          false,  "",  dfNone,  0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "svc_scp_cd",      false,  "",  dfNone,  0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "chg_cd",          false,  "",  dfNone,  0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "grp_loc_seq",     false,  "",  dfNone,  0, false, false);
                     
                     //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				 InitDataValid(0, "scg_grp_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

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
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Seq.|Location\nType|Code|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_loc_cd|grp_loc_dtl_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,     "ibflag");
                     InitDataProperty(0, cnt++,  dtDummyCheck,   40,    daCenter,   false,     "chk");
                     InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false,     "Seq");
                     InitDataProperty(0, cnt++ , dtCombo,        85,    daCenter,   false,     "dtl_loc_tp_cd",    true,    "",  dfNone,     0,  true,  true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    70,    daCenter,   false,     "dtl_loc_def_cd",   true,    "",  dfNone,     0,  true,  true, 5);
                     InitDataProperty(0, cnt++ , dtData,         110,   daLeft,     false,     "loc_des",          false,   "",  dfNone,     0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         80,    daCenter,   false,     "eff_dt",           true,    "",  dfDateYmd,  0,  true,  true);
                     InitDataProperty(0, cnt++ , dtData,         80,    daCenter,   false,     "exp_dt",           false,   "",  dfDateYmd,  0,  true,  true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   false,     "upd_dt",           false,   "",  dfDateYmd,  0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "svc_scp_cd",       false,   "",  dfNone,     0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "chg_cd",           false,   "",  dfNone,     0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "grp_loc_seq",      false,   "",  dfNone,     0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "grp_loc_dtl_seq",  false,   "",  dfNone,     0, false, false);

                     InitDataValid(0, "dtl_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
                     ShowButtonImage = 2;
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
                //alert()
                // 화면 로딩시 Service Scope 조회
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
                
                //공통 - type
                sheetObjects[2].InitDataCombo(0,"dtl_loc_tp_cd", LOCATION_TYPE3[1], LOCATION_TYPE3[0], " ", " ", 0);
                
                if(formObj.pre_svc_scp_cd.value != "") {
	                comboObjects[0].Code = formObj.pre_svc_scp_cd.value;
	                //var formObj = document.form;
	                var code = comboObjects[0].FindIndex(comboObjects[0].Code, 0);
	                
	                if (code != -1) {
	                    var text = comboObjects[0].GetText(code, 1);
	                    if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
	                        formObj.svc_scp_nm.value = text;
	                        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	                    }
	                } else {
	                    formObj.svc_scp_nm.value = "";
	                    comboObjects[0].Code2 = -1;
	                }
	                formObj.pre_svc_scp_cd.value = "";
                }

                break;  
        
            
            case IBSEARCH:      //조회
            	
            	try {
     			    for (var i = 0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].WaitImageVisible = false;
				    }
				    ComOpenWait(true);

	                if (sheetObj.id == "sheet0") {
	                    // Surcharge combo
	                    formObj.f_cmd.value = COMMAND12;
	                    formObj.etc1.value = getSvcScpCd();
	                    sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	                    ComPriXml2ComboItem(sXml, formObj.chg_cd, "cd", "cd|nm");
	                } else {
	                    if (validateForm(sheetObj,document.form,sAction)) {
	                        if ( sheetObj.id == "sheet1") {
	                            
	                            for (var i = 0; i < sheetObjects.length; i++) {
	                                sheetObjects[i].RemoveAll();
	                            }    
	                            
	                            formObj.f_cmd.value = SEARCH01;
	                            
	                            if (formObj.pre_svc_scp_cd.value != "") {
	                                sheetObj.DoSearch("ESM_PRI_4028GS.do", FormQueryString(formObj));
	                            } else {
	                                sheetObj.DoSearch("ESM_PRI_4004GS.do", FormQueryString(formObj));
	                            }
	        
	                        }       
	                        else if ( sheetObj.id == "sheet2") {
	                            formObj.f_cmd.value = SEARCH02;
	                            if (formObj.pre_svc_scp_cd.value != "") {
	                                sheetObj.DoSearch("ESM_PRI_4028GS.do", FormQueryString(formObj));
	                            } else {
	                                sheetObj.DoSearch("ESM_PRI_4004GS.do", FormQueryString(formObj));
	                            }
	                        }
	                    }
	                }
	            	
		            if(formObj.pre_chg_cd.value != "") {
			            comboObjects[1].Code = formObj.pre_chg_cd.value;
			            var code = comboObjects[1].FindIndex(comboObjects[1].Code, 0);
			            if (code != -1) {
			                var text = comboObjects[1].GetText(code, 1);
			                if (text != null && text != "" && text != formObj.chg_nm.value) {
			                    formObj.chg_nm.value = text;
			                }
			            } else {
			                formObj.chg_nm.value = "";
			                comboObjects[1].Code2 = -1;
			            }
			            formObj.pre_chg_cd.value = "";
			            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
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
     	       
                break;

            case IBSAVE:        //저장
            
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                    
                eventStatus = "IBSAVE";
                
                formObj.f_cmd.value = MULTI01;
                        
                var sParam = FormQueryString(formObj);
                var sParamSheet1 = sheetObjects[1].GetSaveString(); 
                    
                if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
                    return;
                }
                    
                sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                    
                var sParamSheet2 = sheetObjects[2].GetSaveString();                 
                if (sheetObjects[2].IsDataModified && sParamSheet2 == "") {
                    return;
                }
                    
                sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");
                
                
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }
                    
                
                try {
     			    for (var i = 0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].WaitImageVisible = false;
				    }
				    ComOpenWait(true);
               
	                var sXml = "";
	                if (formObj.pre_svc_scp_cd.value != "") {
	                    sXml = sheetObj.GetSaveXml("ESM_PRI_4028GS.do", sParam);
	                } else {
	                    sXml = sheetObj.GetSaveXml("ESM_PRI_4004GS.do", sParam);
	                }
	                //sheetObjects[0].LoadSaveXml(sXml);
	                sheetObjects[2].LoadSaveXml(sXml);
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
                    
                if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
                    return false;
                } else {
                    ComPriSaveCompleted();
                    
//                    doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);

                    if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                        doRowChange(sheetObjects[1], sheetObjects[2], -1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, false);
                    }
                    return true;
                }
                
                eventStatus = "";
                
                break;
                 
        
            case IBINSERT: // Row Add
                
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow, 
//                                            sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, true);
                        
                        var idx = doRowChange(sheetObj, sheetObjects[2], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
                        if (idx < 0) {
                            return false;
                        }
                        //service scoup
                        sheetObj.CellValue(idx, "svc_scp_cd")     = getSvcScpCd();
                        sheetObj.CellValue(idx, "chg_cd")         = getChgCd();
                        //맥스시퀀스 세팅
                        sheetObj.CellValue(idx, "grp_loc_seq")    = parseInt(formObj.max_seq.value) + 1;
                        //max 1  증가
                        formObj.max_seq.value = sheetObj.CellValue(idx, "grp_loc_seq");
                        
                        sheetObjects[2].RemoveAll();
                        
                        sheetObj.SelectCell(idx,"scg_grp_loc_cd");
                    }
                    if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataInsert();
                        sheetObj.CellValue(idx, "svc_scp_cd")     = getSvcScpCd();
                        sheetObj.CellValue(idx, "chg_cd")         = getChgCd();
                        var grp_loc_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "grp_loc_seq");
                        sheetObj.CellValue(idx, "grp_loc_seq") = grp_loc_seq;
                        sheetObj.CellValue(idx, "grp_loc_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1;
                    
                        sheetObj.SelectCell(idx,"dtl_loc_def_cd");
                    }
                }
                break;
                
            case IBDELETE: // Delete
//              if (validateForm(sheetObj,document.form,sAction)) {
//                  //alert(sheetObj.id);
//                  deleteRowCheck(sheetObj, "chk");
//                  if (sheetObj.id == "sheet1") {
//                      deleteRowCheck(sheetObjects[2], "chk");
//                  } 
//              }   
//              break;
                
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                
                if (sheetObj.CheckedRows("chk") <= 0) {
                    sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
                }

                var delCnt = deleteRowCheck(sheetObj, "chk");
                
                //삭제한 row를 제외한 맥스값 다시 세팅
                formObj.max_seq.value = ComPriGetMaxExceptDelete(sheetObj, "grp_loc_seq");
                
                
                if (delCnt > 0 && sheetObj.id == "sheet1") {
                    for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
                        sheetObjects[2].CellValue(i, "chk") = "1";
                    }
                    deleteRowCheck(sheetObjects[2], "chk");
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
            
                if (comboObjects[1].Code == "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                
                return true;
                break;
        
            case IBSAVE: // 저장
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
            
                if (comboObjects[1].Code == "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                
                if (!sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                
                if (sheetObjects[1].IsDataModified ) {
                     var rowM = sheetObjects[1].ColValueDup("svc_scp_cd|chg_cd|scg_grp_loc_cd",false);
                     if (rowM >= 0) {
                         ComShowCodeMessage("PRI00303", "Sheet", rowM);
                         return false;
                    }               
                }
                
                
                if (sheetObjects[2].IsDataModified ) {
                     var rowD = sheetObjects[2].ColValueDup("svc_scp_cd|chg_cd|grp_loc_seq|dtl_loc_tp_cd|dtl_loc_def_cd",false);
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
                
                //sheet2에서 하나라도 저장했는지 체크
//                if (getValidRowCount(sheetObjects[1]) >= 1 && (sheetObjects[2].RowCount <= 0 || sheetObjects[2].SelectRow <= 0)) {
//                    ComShowCodeMessage("PRI00319", "Location Type");
//                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
//                    return false;
//                }
                
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                	ComShowCodeMessage("PRI00319", "Location Type");
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
            
                if (comboObjects[1].Code == "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                
                return true;
                break;
                
            
            case IBDELETE: // Delete
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
            
                if (comboObjects[1].Code == "") {
                    ComPriInputValueFailed("select","Charge","");
                    return false;
                }   
                
                return true;
                break;
            }

         return true;
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
        * @version 2009.04.17
        */               
        function sheet2_OnPopupClick(sheetObj, Row, Col)
        {
            var colName = sheetObj.ColSaveName(Col);
            var formObj = document.form;
            
            switch(colName)
            {
                case "dtl_loc_def_cd":
                    var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=LCR&svc_scp_cd=" + getSvcScpCd() + "&chg_cd=" + getChgCd();
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
                    var tpCd = "C";
                    if (rtnVal != null){
                        sheetObj.CellValue2(Row, Col) = rtnVal.cd;
                        sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
        
                        if (rtnVal.cd.length == 5){
                            tpCd = "L";
                        } else if (rtnVal.cd.length == 2){
                            tpCd = "C";
                        }else if (rtnVal.cd.length == 3){
                            tpCd = "R";
                        }
                        sheetObj.CellValue2(Row, "dtl_loc_tp_cd") = tpCd;
                    }
                    break;
            }
            
    
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
        function sheet1_OnChange(sheetObj, Row, Col, Value) {
    		var formObj = document.form;
    		var sName = sheetObj.ColSaveName(Col);
    		
    		if (sName == "scg_grp_loc_cd") {
    			if (Value != "" && Value.length != 4) {
    				sheetObj.CellValue2(Row, "scg_grp_loc_cd") = "";
    				sheetObj.SelectCell(Row, "scg_grp_loc_cd", true);
    			}
    		}
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
            switch(colname)
            {
                case "dtl_loc_def_cd":
                    if (Value.length==2){
                        formObj.f_cmd.value = SEARCH07;
                        formObj.cd.value=sheetObj.Cellvalue(Row,Col);                       
                        //sheetObj.WaitImageVisible = false; // 처리 중 대기 이미지를 표시하지 않도록 설정한다. 
                        var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
                        //alert(arrData[0]+"/"+arrData[1])
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])){
                            sheetObj.CellValue2(Row,"loc_des") = arrData[1];
                            sheetObj.CellValue2(Row,"dtl_loc_tp_cd") = "C" ;
                        }else{
//                            ComShowCodeMessage("PRI00315");
                            locationCellClear(sheetObj,Row);
                        }   
                        
                    }else if(Value.length==5){
                        formObj.f_cmd.value = SEARCH05;
                        formObj.cd.value=sheetObj.Cellvalue(Row,Col);   
                        //sheetObj.WaitImageVisible = false; // 처리 중 대기 이미지를 표시하지 않도록 설정한다.
                        var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)); 
                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");                  
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                            sheetObj.CellValue2(Row,"loc_des") = arrData[1];
                            sheetObj.CellValue2(Row,"dtl_loc_tp_cd") = "L" ;
                        }else{      
//                            ComShowCodeMessage("PRI00315");
                            locationCellClear(sheetObj,Row);
                        }           
                    }else if(Value.length==3){
                        formObj.f_cmd.value = COMMAND08;
                        formObj.cd.value=sheetObj.Cellvalue(Row,Col);   
                        //sheetObj.WaitImageVisible = false; // 처리 중 대기 이미지를 표시하지 않도록 설정한다.
                        var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)); 
                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");                  
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                            sheetObj.CellValue2(Row,"loc_des") = arrData[1];
                            sheetObj.CellValue2(Row,"dtl_loc_tp_cd") = "R" ;
                        }else{      
//                            ComShowCodeMessage("PRI00315");
                            locationCellClear(sheetObj,Row);
                        }                               
                    }else{
//                        ComShowCodeMessage("PRI00315");
                        locationCellClear(sheetObj,Row);
                    }
                    break;
                    
                    
                    
                    
                    
//              case "rout_pnt_loc_def_cd":
//                  if (Value.length==2){
//                      formObj.f_cmd.value = SEARCH07;
//                      formObj.cd.value=sheetObj.Cellvalue(Row,Col);                       
//                      //sheetObj.WaitImageVisible = false; // 처리 중 대기 이미지를 표시하지 않도록 설정한다. 
//                      var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));               
//                      var arrData = ComPriXml2ComboString(sXml, "cd", "nm");                  
//                      if (arrData[1] != ""){
//                          sheetObj.CellValue2(Row,"loc_des") = arrData[1];
//                          sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "C" ;
//                      }else{
//                          ComShowCodeMessage("PRI00315");
//                          locationCellClear(sheetObj,Row);
//                      }                   
//                  }else if(Value.length==5){
//                      formObj.f_cmd.value = SEARCH05;
//                      formObj.cd.value=sheetObj.Cellvalue(Row,Col);   
//                      var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));               
//                      var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");                 
//                      if (arrData != null && arrData.length > 0) {
//                          sheetObj.CellValue2(Row, "loc_des") = arrData[0][1];
//                          sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "L" ;
//                      }else{      
//                          ComShowCodeMessage("PRI00315");
//                          locationCellClear(sheetObj,Row);
//                      }   
//                  }else{
//                      ComShowCodeMessage("PRI00315");
//                      locationCellClear(sheetObj,Row);
//              
//                  }
//                  break;
//              case "rout_pnt_loc_tp_cd":          
//                  locationCellClear(sheetObj,Row);
//                  break;      
                    
                    
                    
            }
        }  
        
        
        /**
         * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
         * <br><b>Example :</b>
         * <pre>
         *      locationCellClear(sheetObj,Row)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
         * @return 없음
         * @author 공백진
         * @version 2009.04.17
         */         
        function locationCellClear(sheetObj,Row){
            sheetObj.CellValue2(Row,"dtl_loc_def_cd")= "";
            sheetObj.CellValue2(Row,"loc_des")= "";         
            sheetObj.CellValue2(Row,"dtl_loc_tp_cd")= "";
            
            sheetObj.SelectCell(Row,"dtl_loc_def_cd");
        }    
        
        
        
        
        /**
         * 화면 전체를 리셋한다.<br>
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
            comboObjects[1].Index = "-1";
            formObj.chg_nm.value = "";  
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
            
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
                    formObj.grp_loc_seq.value = sheetM.CellValue(NewRow,"grp_loc_seq");
                    if(formObj.grp_loc_seq.value == "undefined" || ComIsEmpty(formObj.grp_loc_seq.value)) {
                        formObj.grp_loc_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"grp_loc_seq");
                    }
                    
                    try {
         			  	ComOpenWait(true);
	                    if (formObj.pre_svc_scp_cd.value != "") {
	                        sheetD.DoSearch("ESM_PRI_4028GS.do", FormQueryString(formObj));
	                    } else {
	                        sheetD.DoSearch("ESM_PRI_4004GS.do", FormQueryString(formObj));
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
            //alert(sheetObjects[1].EtcData("max_seq"))
            //if (ErrMsg == "") {
                var formObj = document.form;
                formObj.max_seq.value = sheetObjects[1].EtcData("max_seq"); 
                
            //}
        }
        

    /* 개발자 작업  끝 */