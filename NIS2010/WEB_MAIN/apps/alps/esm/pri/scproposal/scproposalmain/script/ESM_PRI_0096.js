/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0096.js
*@FileTitle : S/C Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.10 문동규
* 1.0 Creation
=========================================================
* History
* 2011.05.13 김민아 [CHM-201110785-01] ANW03588 에 대해서 S/C Copy 요청 -  NVOCC Customer의 경우 G.Rate, OAR, DAR Copy를 막아 놨는데 급하게 오늘 구주의 특정 S/C를 copy 하고 싶다는 요청 수용을 위해 임시 코드 작성.
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
     * @class ESM_PRI_0096 : ESM_PRI_0096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0096() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.setComboObject 		= setComboObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


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
     * @version 2009.06.10
     */
    function processButtonClick () {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        /** **************************************************** */
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
                case "btn_Ok":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
    
                case "btn_Close":
                    window.close();
                    break;

                case "blpl_chk_frm":
                    if (formObj.blpl_chk_frm.checked) {
                        sheetObject1.CellValue(1,"blpl_chk") = 1;
                    } else {
                        sheetObject1.CellValue(1,"blpl_chk") = 0;
                    }
                    break;

                case "afil_chk_frm":
                    if (formObj.afil_chk_frm.checked) {
                        sheetObject1.CellValue(1,"afil_chk") = 1;
                    } else {
                        sheetObject1.CellValue(1,"afil_chk") = 0;
                    }
                    break;
            } // end switch
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
     * @author 문동규
     * @version 2009.06.10
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
     * @version 2009.06.10
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );

 			initSheet(sheetObjects[i],i+1);
 	
 			ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * @author 문동규
     * @version 2009.06.10
     */
    function initSheet (sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
    
            case "sheet1":
                with (sheetObj) {
    
                    // 높이 설정
                    style.height = 0;
    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
    
                    var HeadTitle = "|||Boiler Plate|Affiliate|Legacy IF Flag";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
                    // COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
                    // POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
                    // SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,   0, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData,     0, daCenter, false, "prop_no");
                    InitDataProperty(0, cnt++, dtData,     0, daCenter, false, "amdt_seq");
                    InitDataProperty(0, cnt++, dtCheckBox, 0, daCenter, false, "blpl_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 0, daCenter, false, "afil_chk");
                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, false, "prc_prop_cre_tp_cd");
                    WaitImageVisible = false;
                }
                break;
            case "sheet2":
                with (sheetObj) {
    
                    // 높이 설정
                    style.height = 130;
    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
    
                    var HeadTitle = "|SEQ|prop_no|amdt_seq|prc_prop_cre_tp_cd|SVC\nScope|SVC\nScope|Origin|Destination|Group\nLocation|Group\nCommodity|Origin\nArbitrary|Destination\nArbitrary|General\nRate|Special\nRate|Special\nNote|Loading\nAgent|IHC|GOH";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
                    // COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
                    // POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
                    // SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                    InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "prop_no");
                    InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "amdt_seq");
                    InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "prc_prop_cre_tp_cd");
                    InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "svc_scp_cd", false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, false, "scp_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, false, "orgn_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 70, daCenter, false, "dest_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, false, "loca_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, false, "cmdt_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, false, "aror_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, false, "arde_chk");
                    // General/Special Rate Copy 구분을 위한 컬럼 구성 변경  2010.07.12 - HJSONG 
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, false, "grate_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, false, "srate_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, false, "spnt_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, false, "load_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, false, "ihc_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "goh_chk");
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
     * @author 문동규
     * @version 2009.06.10
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH: // 조회
            	ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_0096GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                
                for (var i = 0 , n = arrXml.length; i < n; i++) {
                    sheetObjects[i].LoadSearchXml(arrXml[i]);
                }
                ComOpenWait(false);
                break;
    
            case IBSAVE: // 저장
                ComOpenWait(true);
                if (!validateForm (sheetObjects[1], formObj, sAction)) {
                    return;
                }
                
                if (!ComShowCodeConfirm('PRI00012')) {
                	return;
                }
                
                for (var i = 1, n = sheetObjects[0].RowCount; i <= n; i++) {
                    if (sheetObjects[0].CellValue(i, "blpl_chk") == 1 || sheetObjects[0].CellValue(i, "afil_chk") == 1) {
                        sheetObjects[0].RowStatus(i) = "U";
                    } else {
                        sheetObjects[0].RowStatus(i) = "R";
                    }
                }
    
                for (var i = 1, n = sheetObjects[1].RowCount; i <= n; i++) {
                    if (sheetObjects[1].CellValue(i, "scp_chk") == 1) {
                        sheetObjects[1].RowStatus(i) = "U";
                    } else {
                        sheetObjects[1].RowStatus(i) = "R";
                    }
                }
                
                formObj.f_cmd.value = MULTI;
                var sParam = "";
                var sParamSheet1 = sheetObjects[0].GetSaveString();
                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2 = sheetObjects[1].GetSaveString();
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }

                sParam += "&" + FormQueryString(formObj);
                var sXml = sheetObjects[1].GetSaveXml("ESM_PRI_0096GS.do", sParam);
                sheetObjects[0].LoadSaveXml(sXml);
                ComOpenWait(false);
                break;
        }
    }
    
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * 조회한 sheet의 데이터를 form에 적용한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            var formObj = document.form;
            if (sheetObj.SearchRows == 1) {
                formObj.blpl_chk_frm.checked = (sheetObj.CellValue(1, "blpl_chk")==1);
                formObj.afil_chk_frm.checked = (sheetObj.CellValue(1, "afil_chk")==1);
                formObj.blpl_chk_frm.disabled = (sheetObj.CellValue(1, "blpl_chk")==0);
                formObj.afil_chk_frm.disabled = (sheetObj.CellValue(1, "afil_chk")==0);
            }
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * 데이터가 없는 항목은 선택을 못하게 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet2_OnSearchEnd (sheetObj, errMsg) {
        if (errMsg == "") {
            for (var i = 1, n = sheetObj.RowCount; i <= n; i++) {
                sheetObj.CellValue2(i, "prc_prop_cre_tp_cd") = sheetObjects[0].CellValue(1, "prc_prop_cre_tp_cd");
                for (var j = sheetObj.SaveNameCol("scp_chk"), k = sheetObj.LastCol; j <= k ; j++) {
                    // 이행/Legacy Interface 인 경우 Special Note 는 Copy 하지 않음
                    if (j == sheetObj.SaveNameCol("spnt_chk") && sheetObj.CellValue(i, "prc_prop_cre_tp_cd") == "I") {
                        sheetObj.CellValue2(i, j) = "0";
                        sheetObj.CellEditable(i, j) = false;
                        continue;
                    }
                    if (sheetObj.CellValue(i, j) != 1) {
                        //////////////////////////////////
                        // 임시 코드         시작                                  //
                        /////////////////////////////////
                        if( document.form.isSuper.value == "Y" ){
                        	continue;
                        }
                        //////////////////////////////////
                        // 임시 코드         끝                                  //
                        /////////////////////////////////

                    	sheetObj.CellEditable(i, j) = false;
                    }
                }
            }

        }
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * SVC Scope Uncheck 시 해당 Line 의 모든 항목이 Uncheck 표시됨<br>
     * SVC Scope check 시 해당 Line 의 모든 항목이 check 표시됨<br>
     * Uncheck 이후 다시 Check 했을때는 처음 Open 시와 Check했던 동일한 항목에만 Check 표시<br>
     * Rate Option 선택시에는 Origin, Destination, Group Commodity, Group Location은 자동 선택됨<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet2_OnChange (sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);
        var formObj = document.form;
    
        switch (colname) {
            case "scp_chk":
//                var chk = sheetObj.CellValue(Row, "scp_chk");
                for (i = 7; i <= 18; i++) {
                    if (sheetObj.CellEditable(Row, i)) {
                        sheetObj.CellValue2(Row, i) = Value;
                    }
                }
                break;
            // General/Special Rate Copy 구분을 위한 컬럼 구성 변경  2010.07.12 - HJSONG                
            case "grate_chk":
                if (Value == 1) {
                    if (sheetObj.CellEditable(Row, "orgn_chk")) {
                        sheetObj.CellValue2(Row, "orgn_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "dest_chk")) {
                        sheetObj.CellValue2(Row, "dest_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "loca_chk")) {
                        sheetObj.CellValue2(Row, "loca_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "cmdt_chk")) {
                        sheetObj.CellValue2(Row, "cmdt_chk") = 1;
                    }
                }
                break;
            case "srate_chk":
                if (Value == 1) {
                    if (sheetObj.CellEditable(Row, "orgn_chk")) {
                        sheetObj.CellValue2(Row, "orgn_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "dest_chk")) {
                        sheetObj.CellValue2(Row, "dest_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "loca_chk")) {
                        sheetObj.CellValue2(Row, "loca_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "cmdt_chk")) {
                        sheetObj.CellValue2(Row, "cmdt_chk") = 1;
                    }
                }
                break;
                
            case "loca_chk":
                if (Value == 0) {
                	// General/Special Rate Copy 구분을 위한 컬럼 구성 변경  2010.07.12 - HJSONG 
                    sheetObj.CellValue2(Row, "grate_chk") = 0;
                    sheetObj.CellValue2(Row, "srate_chk") = 0;
                }
                break;
                
            case "cmdt_chk":
                if (Value == 0) {
                	// General/Special Rate Copy 구분을 위한 컬럼 구성 변경  2010.07.12 - HJSONG                 	
                    sheetObj.CellValue2(Row, "grate_chk") = 0;
                    sheetObj.CellValue2(Row, "srate_chk") = 0;
                }
                break;
        }// end switch
        
        if (Value == 1) {
            sheetObj.CellValue2(Row, "scp_chk") = 1;
        } else {
            var b = true;
            // Terms 체크박스 체크
            for (i = 7; i <= 18; i++) {
                if (sheetObj.CellValue(Row, i) == 1) {
                    b = false;
                }
            }
            
            if (b) {
                // 모든 Terms가 체크해지되면 Scope의 체크도 해지한다.
                sheetObj.CellValue2(Row, "scp_chk") = 0;
            }
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
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.06.10
     */
    function validateForm (sheetObj, formObj, sAction) {
        with (sheetObj) {
            switch (sAction) {
                case IBSAVE:
                    if (FindCheckedRow("scp_chk") == "") {
                        ComShowCodeMessage('PRI01007');
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 후 로직을 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            var newPropNo = sheetObj.EtcData("newPropNo");
            window.returnValue = newPropNo;
            window.close();
        }
    }
    /* 개발자 작업  끝 */