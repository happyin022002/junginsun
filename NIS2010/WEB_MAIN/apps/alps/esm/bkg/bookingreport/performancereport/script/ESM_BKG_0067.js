/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0067.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.21 김경섭
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.05.11 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면, 쿼리, VO및 java Method들의 전면수정
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 : B/L Turn Time Report (ESM_BKG_0067) Summary Sheet추가 및 로직 변경
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
     * @extends
     * @class esm_bkg_0067  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0067() {
        this.processButtonClick = processButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
        this.setComboObject = setComboObject;
    }

/* 개발자 작업    */
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
     }


// 공통전역변수
var sheetCnt = 0;
var sheetObjects = new Array();
var comboCnt = 0;
var comboObjects = new Array();


    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    //ComComboObject생성자 메소드에서 호출됨
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //MultiCombo초기화
        for(var k=0;k<comboObjects.length;k++) {
            initCombo(comboObjects[k], comboObjects[k].id);
        }

        initControl();
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
        ComSetFocus(document.form.from_dt);
    }


    function initControl() {
        var frmObj = document.form;
        axon_event.addListener("click", "obj_onclick", "divide");
        axon_event.addListener("keydown", "ComKeyEnter", "form");
        axon_event.addListenerForm("beforedeactivate", "bkg_deactivate", frmObj); // 포커스 나갈때
        axon_event.addListenerFormat("keypress", "bkg_keypress", frmObj); // 키보드 입력할때
        axon_event.addListenerFormat("beforeactivate", "bkg_activate", frmObj); // 포커스 들어갈때
    }


    /**
      * Combo 기본 설정
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initCombo(comboObj, comboId) {
        with(comboObj) {
        	if(comboId=="rgnCdCombo"){
        		UseCode = true;
        		UseAutoComplete = true;
        		UseEdit = false;
        		MultiSelect = true;
        	}else if(comboId=="dpcs_ofc_cd"){
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	 	 				
 	 			BackColor = "#ccfffd";	 	 	
        	}
        }
    }


    /**
     * rgnCdCombo의 MultiSelection OnCheckClick 이벤트 처리
     */
    function rgnCdCombo_OnCheckClick(comboObj, index, code) {
        var rgnCdS = document.form.rgn_cd;
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            comboObj.CheckIndex(0) = true;

        } else {
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
            if (index == 0) {
                for(var i=1; i<comboObj.GetCount(); i++) {
                    comboObj.CheckIndex(i) = false;
                }
                rgnCdS.value = "";

            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                rgnCdS.value = "'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'";
            }
        }
    }
    


    function dpcs_ofc_cd_OnChange(comboObj) {
    	var formObj = document.form;
    	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
    	var param = FormQueryString(formObj);
    	
        if(comboObj.Text == 'PKGSA'){
        	param = param + "&cm_code=CD03249";
        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
        	var arrXml = sXml.split("|$$|");
        	if (arrXml[0].length > 0) {
        		ComXml2ComboItem(arrXml[0], formObj.rgnCdCombo, "val", "val|name");
        	}

		    formObj.elements["rgnCdCombo"].Index = 0;
        }else{
        	param = param + "&cm_code=CD03250";
        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
        	var arrXml = sXml.split("|$$|");
        	if (arrXml[0].length > 0) {
        		ComXml2ComboItem(arrXml[0], formObj.rgnCdCombo, "val", "val|name");
        	}
		    formObj.elements["rgnCdCombo"].Index = 0;
        }
    }


/*********************** EVENT START ********************/
    function bkg_keypress() {
        switch(event.srcElement.dataformat) {
            case "engup":
                //영문대문자
                ComKeyOnlyAlphabet("upper");
                break;
            case "engupnum":
                //숫자+"영문대분자"입력하기
                ComKeyOnlyAlphabet("uppernum");
                break;
            case "engdnnum":
                //숫자+"영문대분자"입력하기
                ComKeyOnlyAlphabet("lowernum");
                break;
            case "num":
                //숫자 입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                break;
        }
    }


    /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
        var frmObj = document.form;
        switch(event.srcElement.getAttribute("name")) {
            case "from_dt":
                ComAddSeparator(event.srcElement);
                break;
            case "to_dt":
                ComAddSeparator(event.srcElement);
                break;
            default:
                break;
        }
    }


    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        var frmObj = document.form;
        switch(event.srcElement.getAttribute("name")) {
            case "from_dt":
                ComClearSeparator(event.srcElement);
                break;
            case "to_dt":
                ComClearSeparator(event.srcElement);
                break;
            default:
                break;
        }
    }


    /**
     * HTML Control의 onClick를 제어한다.
     **/
    function obj_onclick() {
        var frmObj = document.form;
        switch(event.srcElement.getAttribute("name")) {
            case "divide":
                if(frmObj.divide[0].checked) {
                    frmObj.from_dt.className = "input1";
                    frmObj.to_dt.className = "input1";
                    frmObj.bkg_no.className = "input";
                } else {
                    frmObj.from_dt.value = "";
                    frmObj.from_dt.className = "input";
                    frmObj.to_dt.value = "";
                    frmObj.to_dt.className = "input";
                    frmObj.bkg_no.className = "input1";
                }
                break;
        }
    }
/*********************** EVENT END ********************/


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var frmObj = document.form;
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Period":
                    // disabled때는 실행하지 않음
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.from_dt, frmObj.to_dt, "yyyy-MM-dd");
                    }
                    break;

                case "btn_Retrieve":
                    sheetObj1.RemoveEtcData();
                    sheetObj1.RemoveAll();
                    sheetObj2.RemoveEtcData();
                    sheetObj2.RemoveAll();
                    doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                    break;

                case "btn_DownExcelSummary":
                    doActionIBSheet(sheetObj1, frmObj, IBDOWNEXCEL);
                    break;

                case "btn_Retrieve_Detail":
                    if (sheetObj1.CheckedRows("Sel") > 0) {
                        frmObj.rgn_cd_d.value = "";
                        frmObj.bkg_ofc_cd_d.value = "";
                        sheetObj2.RemoveEtcData();
                        sheetObj2.RemoveAll();
                        // "|" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3|4|5"
                        var cRowStr = sheetObj1.FindCheckedRow("Sel");
                        var arr = cRowStr.split("|");
                        var frontAdd = "";
                        for (var i=0; i<arr.length-1; i++) {
                            if (i < 1) {
                                frontAdd = "'";
                            } else {
                                frontAdd = ", '";
                            }
                            frmObj.rgn_cd_d.value += (frontAdd + sheetObj1.CellValue(arr[i], "rgn_cd") + "'");
                            frmObj.bkg_ofc_cd_d.value += (frontAdd + sheetObj1.CellValue(arr[i], "bkg_ofc_cd") + "'");
                        }
                        doActionIBSheet(sheetObj2, frmObj, IBROWSEARCH);
                    }
                    break;

                case "btn_DownExcelDetail":
                    doActionIBSheet(sheetObj2, frmObj, IBDOWNEXCEL);
                    break;

                case "btn_New":
                    sheetObj1.RemoveEtcData();
                    sheetObj2.RemoveEtcData();
                    ComResetAll();
                    ComEnableManyObjects(true, frmObj.divide[0], frmObj.divide[1], frmObj.period, frmObj.from_dt, frmObj.to_dt, frmObj.btn_Period, frmObj.vvd_cd, frmObj.bkg_ofc_cd, frmObj.bkg_no, frmObj.pol_cd, frmObj.pod_cd);
                    frmObj.rgnCdCombo.Enable = true;
                    frmObj.rgnCdCombo.Index = 0;
                    frmObj.dpcs_ofc_cd.Enable = true;

                    // 필수입력 항목 css 추가처리
                    frmObj.from_dt.className = "input1";
                    frmObj.to_dt.className = "input1";

                    ComSetFocus(document.form.from_dt);
                    break;
            } // end switch

        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }

    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, Row, Col) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      // Summary 조회
                if(!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_BKG_0067GS.do", FormQueryString(frmObj));
                break;

            case IBROWSEARCH:      // Detail 조회
                if(!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch("ESM_BKG_0067GS.do", FormQueryString(frmObj));
                break;

            case SEARCH01:      // MultiCombo조회
                frmObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0067GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");
                ComXml2ComboItem(arrXml[0], frmObj.rgnCdCombo, "val", "val|name");
                frmObj.rgnCdCombo.Index = 0;
                ComXml2ComboItem(arrXml[1], frmObj.dpcs_ofc_cd, "val", "val|name");
                if(frmObj.usr_ofc_cd.value == "PKGSA"){
            		frmObj.elements["dpcs_ofc_cd"].Index =0 ;
            	}else if(frmObj.usr_ofc_cd.value == "SZPSC" || frmObj.usr_ofc_cd.value == "ZHOSO" ||
           			     frmObj.usr_ofc_cd.value == "CANSO" || frmObj.usr_ofc_cd.value == "FOCSO" ||
           			     frmObj.usr_ofc_cd.value == "XMNSC" || frmObj.usr_ofc_cd.value == "HKGSC" ){
            		frmObj.elements["dpcs_ofc_cd"].Index =1 ;
            	}
                break;

            case IBDOWNEXCEL:      // 엑셀다운
                sheetObj.Down2Excel(-1);
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        switch(sAction) {
            case IBSEARCH:
                if(frmObj.divide[0].checked) {
                	if(ComGetObjValue(frmObj.dpcs_ofc_cd) == ""){
                        ComShowCodeMessage("BKG01101", "Doc OFC")
                        frmObj.dpcs_ofc_cd.focus();
                        return false;
                	}
                    if(ComIsNull(frmObj.from_dt.value)) {
                        ComShowCodeMessage("BKG00499")
                        frmObj.from_dt.focus();
                        return false;
                    }
                    if(!ComIsDate(frmObj.from_dt.value)) {
                        ComShowCodeMessage("BKG00921")
                        frmObj.from_dt.focus();
                        return false;
                    }
                    if(ComIsNull(frmObj.to_dt.value)) {
                        ComShowCodeMessage("BKG00499")
                        frmObj.to_dt.focus();
                        return false;
                    }
                    if(!ComIsDate(frmObj.to_dt.value)) {
                        ComShowCodeMessage("BKG00921")
                        frmObj.to_dt.focus();
                        return false;
                    }
                    if(ComGetDaysBetween(frmObj.from_dt.value, frmObj.to_dt.value) > 14) {
                        ComShowCodeMessage("COM132001", "Period", "14Days")
                        frmObj.to_dt.focus();
                        return false;
                    }
                } else {
                    if(ComIsNull(frmObj.bkg_no.value)) {
                        ComShowCodeMessage("BKG01101", "BKG No.")
                        frmObj.bkg_no.focus();
                        return false;
                    }
                }
                break;
        }
        return true;
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        with (sheetObj) {

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
            InitRowInfo(2, 1, 9, 100);

            // 자동 트림
            DataAutoTrim = true;

            CountPosition = 0;
            WaitImageVisible = false;


            switch (sheetNo) {
                case 1:    // sheet1 init
                    cnt = 0;

                    // 높이 설정
                    style.height = 150;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle0 = "|Seq.|Sel.|RGN|BKG Ofc.|TTL BKG" +
                                     "|Input|Input|Input|Input|Input|Input|Input|Input|Input|Input" +
                                     "|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate" +
                                     "|QA|QA|QA|QA|QA|QA|QA|QA|QA|QA" +
                                     "|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total" +
                                     "|rgn_cd";

                    var HeadTitle1 = "|Seq.||RGN|BKG Ofc.|TTL BKG" +
                                     "|TTL Event|TTL Pic|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)" +
                                     "|TTL Event|TTL Pic|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)" +
                                     "|TTL Event|TTL Pic|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)" +
                                     "|TTL Event|TTL Pic|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|TTL(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)|Aver(Dd Hh:Mi:Ss)" +
                                     "|rgn_cd";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,  daCenter, false, "Sel");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "rgn",                false, "", dfNone, 0, false, false);    // RGN
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd",         false, "", dfNone, 0, false, false);    // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  true,  "ttl_bkg",            false, "", dfNone, 0, false, false);    // TTL_BKG

                    InitDataProperty(0, cnt++, dtData,         65,  daRight,  false, "input_ttl_event",    false, "", dfNone, 0, false, false);    // [INPUT] TTL Event
                    InitDataProperty(0, cnt++, dtData,         45,  daRight,  false, "input_ttl_pic",      false, "", dfNone, 0, false, false);    // [INPUT] TTL Pic
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_hour_dd",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Hour (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_hour_hh",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Hour (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_hour_mi",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Hour (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_hour_ss",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Hour (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_aver_dd",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Aver (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_aver_hh",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Aver (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_aver_mi",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Aver (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "input_ttl_aver_ss",  false, "", dfNone, 0, false, false);    // [INPUT] TTL Aver (SS)

                    InitDataProperty(0, cnt++, dtData,         65,  daRight,  false, "rate_ttl_event",     false, "", dfNone, 0, false, false);    // [RATE] TTL Event
                    InitDataProperty(0, cnt++, dtData,         45,  daRight,  false, "rate_ttl_pic",       false, "", dfNone, 0, false, false);    // [RATE] TTL Pic
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_hour_dd",   false, "", dfNone, 0, false, false);    // [RATE] TTL Hour (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_hour_hh",   false, "", dfNone, 0, false, false);    // [RATE] TTL Hour (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_hour_mi",   false, "", dfNone, 0, false, false);    // [RATE] TTL Hour (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_hour_ss",   false, "", dfNone, 0, false, false);    // [RATE] TTL Hour (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_aver_dd",   false, "", dfNone, 0, false, false);    // [RATE] TTL Aver (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_aver_hh",   false, "", dfNone, 0, false, false);    // [RATE] TTL Aver (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_aver_mi",   false, "", dfNone, 0, false, false);    // [RATE] TTL Aver (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "rate_ttl_aver_ss",   false, "", dfNone, 0, false, false);    // [RATE] TTL Aver (SS)

                    InitDataProperty(0, cnt++, dtData,         65,  daRight,  false, "qa_ttl_event",       false, "", dfNone, 0, false, false);    // [QA] TTL Event
                    InitDataProperty(0, cnt++, dtData,         45,  daRight,  false, "qa_ttl_pic",         false, "", dfNone, 0, false, false);    // [QA] TTL Pic
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_hour_dd",     false, "", dfNone, 0, false, false);    // [QA] TTL Hour (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_hour_hh",     false, "", dfNone, 0, false, false);    // [QA] TTL Hour (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_hour_mi",     false, "", dfNone, 0, false, false);    // [QA] TTL Hour (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_hour_ss",     false, "", dfNone, 0, false, false);    // [QA] TTL Hour (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_aver_dd",     false, "", dfNone, 0, false, false);    // [QA] TTL Aver (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_aver_hh",     false, "", dfNone, 0, false, false);    // [QA] TTL Aver (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_aver_mi",     false, "", dfNone, 0, false, false);    // [QA] TTL Aver (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "qa_ttl_aver_ss",     false, "", dfNone, 0, false, false);    // [QA] TTL Aver (SS)

                    InitDataProperty(0, cnt++, dtData,         65,  daRight,  false, "total_ttl_event",    false, "", dfNone, 0, false, false);    // [TOTAL] TTL Event
                    InitDataProperty(0, cnt++, dtData,         45,  daRight,  false, "total_ttl_pic",      false, "", dfNone, 0, false, false);    // [TOTAL] TTL Pic
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_hour_dd",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Hour (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_hour_hh",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Hour (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_hour_mi",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Hour (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_hour_ss",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Hour (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_aver_dd",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Aver (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_aver_hh",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Aver (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_aver_mi",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Aver (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_ttl_aver_ss",  false, "", dfNone, 0, false, false);    // [TOTAL] TTL Aver (SS)

                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "rgn_cd",             false, "", dfNone, 0, false, false);    // rgn_cd

                    break;


                case 2:    // sheet2 init
                    cnt = 0;

                    // 높이 설정
                    style.height = 205;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    var HeadTitle0 = "|Seq.|BKG No.|SI Kind|T.VVD|BKG Ofc.|POL|POD|Via|CM|HBL|AMD|Add|RGN" +
                                     "|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)|B/L Turn Time (Original)" +
                                     "|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)|B/L Turn Time (Amend)" +
                                     "|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)|B/L Turn Time (Total)" +
                                     "|SI Transfer|SI Transfer|SI Transfer|SI Transfer|SI Transfer|SI Transfer" +
                                     "|Input|Input|Input|Input|Input|Input" +
                                     "|Rate|Rate|Rate|Rate|Rate|Rate" +
                                     "|QA|QA|QA|QA|QA|QA" +
                                     "|sr_amd_tp_cd|sr_no|pnd_flg|sr_knd_cd|sr_crnt_info_cd|bl_doc_inp_flg|bl_rt_flg|bl_aud_flg|bl_drft_fax_out_flg|sr_wrk_sts_cd";

                    var HeadTitle1 = "|Seq.|BKG No.|SI Kind|T.VVD|BKG Ofc.|POL|POD|Via|CM|HBL|AMD|Add|RGN" +
                                     "|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)" +
                                     "|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)" +
                                     "|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Actual(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Idle(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)|Total(Dd Hh:Mi:Ss)" +
                                     "|SR Trans.|SI Rec.|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)" +
                                     "|IS-Start|IC-End|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)" +
                                     "|RS-Start|RC-End|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)" +
                                     "|QS-Start|QC-End|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)|Elapsed(Dd Hh:Mi:Ss)" +
                                     "|sr_amd_tp_cd|sr_no|pnd_flg|sr_knd_cd|sr_crnt_info_cd|bl_doc_inp_flg|bl_rt_flg|bl_aud_flg|bl_drft_fax_out_flg|sr_wrk_sts_cd";

                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 3, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, false, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         85,  daCenter, true,  "bkg_no");                 // BKG NO
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "sr_amd_td");              // SI Kind
                    InitDataProperty(0, cnt++, dtData,         70,  daCenter, true,  "vvd_cd");                 // T.VVD
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");             // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "pol_cd");                 // POL
                    InitDataProperty(0, cnt++, dtData,         45,  daCenter, true,  "pod_cd");                 // POD
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "via");                    // Via
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "cm");                     // CM
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "hbl");                    // HBL
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "amd");                    // AMD
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, true,  "add_val");                // Add
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "rgn");                    // RGN

                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_actual_dd");     // [ORIGINAL] Actual (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_actual_hh");     // [ORIGINAL] Actual (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_actual_mi");     // [ORIGINAL] Actual (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_actual_ss");     // [ORIGINAL] Actual (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_idle_dd");       // [ORIGINAL] Idle (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_idle_hh");       // [ORIGINAL] Idle (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_idle_mi");       // [ORIGINAL] Idle (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_idle_ss");       // [ORIGINAL] Idle (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_total_dd");      // [ORIGINAL] Total (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_total_hh");      // [ORIGINAL] Total (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_total_mi");      // [ORIGINAL] Total (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "original_total_ss");      // [ORIGINAL] Total (SS)
                    

                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_actual_dd");        // [AMEND] Actual (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_actual_hh");        // [AMEND] Actual (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_actual_mi");        // [AMEND] Actual (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_actual_ss");        // [AMEND] Actual (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_idle_dd");          // [AMEND] Idle (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_idle_hh");          // [AMEND] Idle (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_idle_mi");          // [AMEND] Idle (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_idle_ss");          // [AMEND] Idle (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_total_dd");         // [AMEND] Total (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_total_hh");         // [AMEND] Total (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_total_mi");         // [AMEND] Total (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "amend_total_ss");         // [AMEND] Total (SS)
                    

                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_actual_dd");        // [TOTAL] Actual (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_actual_hh");        // [TOTAL] Actual (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_actual_mi");        // [TOTAL] Actual (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_actual_ss");        // [TOTAL] Actual (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_idle_dd");          // [TOTAL] Idle (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_idle_hh");          // [TOTAL] Idle (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_idle_mi");          // [TOTAL] Idle (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_idle_ss");          // [TOTAL] Idle (SS)
                    
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_total_dd");         // [TOTAL] Total (DD)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_total_hh");         // [TOTAL] Total (HH)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_total_mi");         // [TOTAL] Total (MI)
                    InitDataProperty(0, cnt++, dtData,         35,  daCenter, false, "total_total_ss");         // [TOTAL] Total (SS)
                    

                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "sr_trans");               // [SI Transfer] SR Trans.
                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "si_rec");                 // [SI Transfer] SI Rec.
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "si_elapsed_dd");          // [SI Transfer] Elapsed (DD)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "si_elapsed_hh");          // [SI Transfer] Elapsed (HH)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "si_elapsed_mi");          // [SI Transfer] Elapsed (MI)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "si_elapsed_ss");          // [SI Transfer] Elapsed (SS)

                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "is_start");               // [Input] IS-Start
                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "ic_end");                 // [Input] IC-End
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "input_elapsed_dd");       // [Input] Elapsed (DD)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "input_elapsed_hh");       // [Input] Elapsed (HH)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "input_elapsed_mi");       // [Input] Elapsed (MI)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "input_elapsed_ss");       // [Input] Elapsed (SS)

                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "rs_start");               // [Rate] IS-Start
                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "rc_end");                 // [Rate] IC-End
                    
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "rate_elapsed_dd");        // [Rate] Elapsed (DD)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "rate_elapsed_hh");        // [Rate] Elapsed (HH)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "rate_elapsed_mi");        // [Rate] Elapsed (MI)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "rate_elapsed_ss");        // [Rate] Elapsed (SS)
                    

                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "qs_start");               // [QA] IS-Start
                    InitDataProperty(0, cnt++, dtData,         90,  daCenter, false, "qc_end");                 // [QA] IC-End
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "qa_elapsed_dd");          // [QA] Elapsed (DD)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "qa_elapsed_hh");          // [QA] Elapsed (HH)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "qa_elapsed_mi");          // [QA] Elapsed (MI)
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, false, "qa_elapsed_ss");          // [QA] Elapsed (SS)

                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "sr_amd_tp_cd");           // sr_amd_tp_cd
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "sr_no");                  // sr_no
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "pnd_flg");                // pnd_flg
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "sr_knd_cd");              // sr_knd_cd
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "sr_crnt_info_cd");        // sr_crnt_info_cd
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "bl_doc_inp_flg");         // bl_doc_inp_flg
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "bl_rt_flg");              // bl_rt_flg
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "bl_aud_flg");             // bl_aud_flg
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "bl_drft_fax_out_flg");    // bl_drft_fax_out_flg
                    InitDataProperty(0, cnt++, dtHidden,       80,  daCenter, true,  "sr_wrk_sts_cd");          // sr_wrk_sts_cd

                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        ComSyncAllCheck(sheetObj, "Sel", Value, 1);
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet2_OnDblClick(sheetObj, Row, Col) {
        with (sheetObj) {
            // Queue Detail 상세 팝업 호출
            var param = "?bkg_no=" + CellValue(Row, "bkg_no") +
                        "&ui_id=ESM_BKG_0067" +
                        "&sr_kind=" + CellValue(Row, "sr_amd_tp_cd") +
                        "&sr_no=" + CellValue(Row, "sr_no") +
                        "&pnd_flg=" + CellValue(Row, "pnd_flg") +
                        "&src_cd=" + CellValue(Row, "sr_knd_cd") +
                        "&sr_crnt_info_cd=" + CellValue(Row, "sr_crnt_info_cd") +
                        "&sr_crnt_sts_cd=" + CellValue(Row, "sr_crnt_sts_cd") +
                        "&bl_doc_inp_flg=" + CellValue(Row, "bl_doc_inp_flg") +
                        "&bl_rt_flg=" + CellValue(Row, "bl_rt_flg") +
                        "&bl_aud_flg=" + CellValue(Row, "bl_aud_flg") +
                        "&bl_drft_fax_out_flg=" + CellValue(Row, "bl_drft_fax_out_flg") +
                        "&sr_wrk_sts_cd=" + CellValue(Row, "sr_wrk_sts_cd") +
                        "&row_idx=" + Row;

            ComOpenWindowCenter2("/hanjin/ESM_BKG_0422.do" + param, "Queue Detail", 1020, 602, false, "scrollbars=no,resizable=yes");
        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        if (ErrMsg == "") {
            if (sheetObj.SearchRows > 0) {
                // Total 컬럼에 색 지정
                with (sheetObj) {
                    var tmpCommon = "_hour_dd".length;
                    Redraw = false;
                    for (var i=0; i<LastCol; i++) {
                        if (ColSaveName(i).indexOf("_hour_") > -1) {
                            ColBackColor(i) = RgbColor(190, 250, 210);
                        } else {
                            ColBackColor(i) = RgbColor(255, 255, 255);
                        }
                    }
                    Redraw = true;
                }

                var frmObj = document.form;
                // 필수입력 항목 css 추가처리 (Disable상태로 [조회]등을 하게 되어서 다시 Disable이 될때 css가 이상해짐)
                frmObj.from_dt.className = "input";
                frmObj.to_dt.className = "input";
                ComEnableManyObjects(false, frmObj.divide[0], frmObj.divide[1], frmObj.period, frmObj.from_dt, frmObj.to_dt, frmObj.btn_Period, frmObj.vvd_cd, frmObj.bkg_ofc_cd, frmObj.bkg_no, frmObj.pol_cd, frmObj.pod_cd);
                frmObj.rgnCdCombo.Enable = false;
                frmObj.dpcs_ofc_cd.Enable = false;
            }
        }
    }


    /**
     * Sheet2의 OnSearchEnd 이벤트 처리
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        if (ErrMsg == "") {
            if (sheetObj.SearchRows > 0) {
                // Total 컬럼에 색 지정
                with (sheetObj) {
                    Redraw = false;
                    ColBackColor("original_total_dd") = RgbColor(190, 250, 210);
                    ColBackColor("original_total_hh") = RgbColor(190, 250, 210);
                    ColBackColor("original_total_mi") = RgbColor(190, 250, 210);
                    ColBackColor("original_total_ss") = RgbColor(190, 250, 210);
                    ColBackColor("amend_total_dd") = RgbColor(190, 250, 210);
                    ColBackColor("amend_total_hh") = RgbColor(190, 250, 210);
                    ColBackColor("amend_total_mi") = RgbColor(190, 250, 210);
                    ColBackColor("amend_total_ss") = RgbColor(190, 250, 210);
                    ColBackColor("total_total_dd") = RgbColor(190, 250, 210);
                    ColBackColor("total_total_hh") = RgbColor(190, 250, 210);
                    ColBackColor("total_total_mi") = RgbColor(190, 250, 210);
                    ColBackColor("total_total_ss") = RgbColor(190, 250, 210);
                    Redraw = true;
                }
            }
        }
    }


/* 개발자 작업  끝 */
