/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0429.js
*@FileTitle : Release/Redelivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.18 김상수
* 1.0 Creation
* --------------------------------------------------------
* History
* 1.1 HJSBIZ_CR_40 적용
* 2014.05.08 김용습 [CHM-201430082] 최대 조회 허용기간을 92일로 변경
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
     * @class EES_CTM_0429 : EES_CTM_0429 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0429() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
		this.initCombo = initCombo;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
        
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Calendar":
                    var cal = new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    break;
                    
                // HJSBIZ_CR_40 - btn_more
                case "btn_more":
                	doActionIBSheet(sheetObj, frmObj, IBSEARCHAPPEND);
                    break;
                    
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;

                case "btn_new":
                    ComResetAll();
                    if (comboObjects[0].GetCount() > 0) {
                        comboObjects[0].Index = 0;
                    }
                    document.getElementById("p_yard2").RemoveAll();
                    
                    //HJSBIZ_CR_40 - add
                    processMode("NEW");                    
                    break;

                case "btn_downExcel":
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Sel");
                    ComOpenWait(false);
                    sheetObj.WaitImageVisible = true;
                    break;

                case "btn_recovery":
                    if (sheetObj.GetSaveString(false, false, "Sel") == "") {
                        ComShowCodeMessage("CTM30001");
                    } else if (ComShowCodeConfirm("CTM30006")) {
                        sheetObj.WaitImageVisible = false;
                        ComOpenWait(true);
                        doActionIBSheet(sheetObj, frmObj, IBSAVE);    // 저장
                        ComOpenWait(false);
                        sheetObj.WaitImageVisible = true;
                    }
                    break;
            } // end switch

        } catch(e) {
            if ( e == "[object Error]") {
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
     * IBMultiCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(var i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        // CTM-COMMON (& 예외처리)
        setEventProcess("yd_cd_disp");

        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
        // OnKeyUp 이벤트 (자체function)
        axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
        // OnChange 이벤트 (자체function)
        axon_event.addListener("change", "obj_onchange", "type");
        
        // 로그인한 사용자의 Office코드로 Multicombo용 TerritoryList 조회
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);

        // 페이지 로딩시 focus
        document.form.p_date1.focus();
        
        //HJSBIZ_CR_40 - add
        processMode("NEW");
 
    }
    
    
    /**
	 * //HJSBIZ_CR_40 - process Mode add
	 */
	function processMode(mode) {
		 var formObj = document.form;
		 if(mode == "NEW"){
			with (formObj) {
		        ComBtnDisable("btn_more");       		               
		        ComSetObjValue(bkg_chk, 			"");
		        ComSetObjValue(tro_chk, 			"");
		        ComSetObjValue(mh_chk, 			"");
		        ComSetObjValue(mt_repo_chk, 	"");
		        ComSetObjValue(st_chk, 			"");
		        ComSetObjValue(disp_total_cnt, "0");
			}
		 } 
		 else if(mode == "SEARCH"){
				with (formObj) {
                    ComBtnDisable("btn_more");
                    ComSetObjValue(page_no,   		"1");
                    ComSetObjValue(row_cnt,   		"0");
                    ComSetObjValue(total_cnt,     	"0");  
                    ComSetObjValue(disp_total_cnt, "0");
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
            style.height = 420;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, document.form.pagerows.value); //InitRowInfo(1, 1, 3, 500);
            

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

            // Ctrl키를 눌러 다중행 선택가능
            MultiSelection = true;
            SelectionMode = smSelectionList;

            var HeadTitle  = "|No.||I.Type|I.Office|Mode|Type|Empty CY|P/D Date|TP";
                HeadTitle += "|Booking No.|Seq.|B/L No.|Container No.|MVMT CNTR|VVD Code|POR|POL|POD|DEL|S/O Door|Deleted";  //HJSBIZ_CR_40 POR DEL S/O Door - as "|Booking No.|Seq.|B/L No.|Container No.|MVMT CNTR|VVD Code|POL|POD|Deleted";
                HeadTitle += "|Deleted Date|W/O No.|Empty R/R Date|User ID|SHPR Name|CNEE Name|NTFY Name|S.Office|S/C No.|RFA No.|Invoice|total_cnt";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(38, 9, 0, true);  //HJSBIZ_CR_40 as InitColumnInfo(34, 9, 0, true);
                
            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 자동 트림하여 조회및 저장
            DataAutoTrim = true;

            // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,    dtHiddenStatus, 0,     daCenter,    false,    "ibflag");
            InitDataProperty(0, cnt++,    dtDataSeq,      35,    daRight,     false,    "Seq");
            InitDataProperty(0, cnt++,    dtDummyCheck,   30,    daCenter,    false,    "Sel");
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "i_type",          false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "i_office",        false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         40,    daCenter,    false,    "mode_cd",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "type_disp",       false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "empty_cy",        false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         70,    daCenter,    false,    "pd_date",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         30,    daCenter,    false,    "tp",              false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,   daCenter,    false,    "bkg_no",          false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         30,    daCenter,    false,    "tro_seq",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         85,    daCenter,    false,    "bl_no",           false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         90,    daCenter,    false,    "cntr_no",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         90,    daCenter,    false,    "mvmt_cntr_no",    false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         75,    daCenter,    false,    "vvd",             false,    "",    dfNone,    0,    false,    false);
            
            InitDataProperty(0, cnt++,    dtData,         45,    daCenter,    false,    "por_cd",             false,    "",    dfNone,    0,    false,    false); //HJSBIZ_CR_40 add
            
            InitDataProperty(0, cnt++,    dtData,         45,    daCenter,    false,    "pol",             false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         45,    daCenter,    false,    "pod",             false,    "",    dfNone,    0,    false,    false);
            
            InitDataProperty(0, cnt++,    dtData,         45,    daCenter,    false,    "del_cd",             false,    "",    dfNone,    0,    false,    false); //HJSBIZ_CR_40 add
            InitDataProperty(0, cnt++,    dtData,         70,    daCenter,    false,    "dor_nod_cd",             false,    "",    dfNone,    0,    false,    false); //HJSBIZ_CR_40 add
            
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "deleted",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,   daCenter,    false,    "deleted_dt",      false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         85,    daCenter,    false,    "wo_no",           false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,   daCenter,    false,    "stk_jb_dt",       false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "user_id",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         150,   daLeft,      false,    "shpr",            false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         150,   daLeft,      false,    "cnee",            false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         150,   daLeft,      false,    "ntfy",            false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,    daCenter,    false,    "office",          false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         80,    daCenter,    false,    "sc_no",           false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         80,    daCenter,    false,    "rfa_no",          false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         90,    daCenter,    false,    "inv_no");
            InitDataProperty(0, cnt++,    dtHidden,       30,    daCenter,    false,    "bd");
            InitDataProperty(0, cnt++,    dtHidden,       40,    daCenter,    false,    "type_cd");
            InitDataProperty(0, cnt++,    dtHidden,       100,   daCenter,    false,    "so_ofc_cty_cd");
            InitDataProperty(0, cnt++,    dtHidden,       100,   daCenter,    false,    "so_seq");
            InitDataProperty(0, cnt++,    dtHidden,       100,   daCenter,    false,    "total_cnt");  //HJSBIZ_CR_40 add

            CountPosition = 0;
            RequestTimeOut = 20000;

        }
    }

    /**
     * 콤보 Text, Value셋팅
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboId) {
        var frmObj = document.form;
        with (comboObj) {
            UseCode = true;
            switch (comboId) {
                case "tpszCombo":
                    MultiSelect = true;
                    DropHeight = 160;
                    // coCtm.js의 code_get호출
//                    var rtnValues = code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
                    // 2014.02.04 Release-Redelivery 화면의 Cntr TP_SZ 순서 변경 - CHM-201428668
                    var rtnValues = "D2^#^D4^#^D5^#^D7^#^R2^#^R5^#^R7^#^O2^#^O4^#^O5^#^F2^#^F4^#^F5^#^A2^#^A4^#^S2^#^S4^#^T2^#^T4^#^C2^#^C4^#^D3^#^D8^#^D9^#^DW^#^DX^#^P2^#^P4^#^Q5^#^R4^#^R8^#^R9^#^";
                    // cntr_tpsz_cd IBMulticombo생성 (CoCtm.js)
                    parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
                    Text = "ALL";
                    break;
                    
                //HJSBIZ_CR_40 - add
    	    	case "hType1":
	                MultiSelect = false; 
	                UseAutoComplete = false;    
	                SetColAlign("left");
	                SetColWidth("70");
	                DropHeight = 100;
	                InsertItem(0,  "ALL",    		"A");
	                InsertItem(1,  "C/H",  		"CH");
	                InsertItem(2,  "M/H",   		"MH");
	                InsertItem(3,  "MT REPO",  "MT");
	                InsertItem(4,  "S/T",  		"ST");
	                Code = "A";	// Default로 초기화.
	            	break;
    	         
	            //HJSBIZ_CR_40 - add	
    	    	case "hType2":
	                MultiSelect = false; 
	                UseAutoComplete = false;    
	                SetColAlign("left");
	                SetColWidth("30");
	                DropHeight = 60;
	                InsertItem(0,  "ALL",     "A");
	                InsertItem(1,  "BKG",   "BKG");
	                InsertItem(2,  "TRO",   "TRO");
	                Code = "";	// Default로 초기화.
	            	break;                   
                    
                    
            }
        }
    }
	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        var frmObj = document.form;
        switch (sAction) {
            case SEARCH01:    // 사용자 ofcCd에 따른 Multicombo용 TerritoryList 조회
                var xml = sheetObj.GetSearchXml("EES_CTM_0426GS.do", "f_cmd=" + SEARCH01);
                ComXml2ComboItem(xml, comboObjects[0], "cntr_stk_terr_cd", "cntr_stk_terr_txt");
                if (comboObjects[0].GetCount() > 0) {
                    comboObjects[0].Index = 0;
                }
                break;

            // HJSBIZ_CR_40 - more button 시 추가 조회
            case IBSEARCHAPPEND:    //Append 조회

            	if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].WaitImageVisible = false;
                    ComOpenWait(true);
                    frmObj.f_cmd.value = COMMAND01;                   
                    var sXml = sheetObj.GetSearchXml("EES_CTM_0429GS.do", FormQueryString(frmObj));                    
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")                                       
                    if (backendJobKey.length > 0) {
                        frmObj.backendjob_key.value = backendJobKey;
                        sheetObj.RequestTimeOut = 20000;
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                    }                     
                }
                
                break;
                
            case IBSEARCH:    // 조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.RemoveAll();
                 
                 //HJSBIZ_CR_40 - 16일이상에서 92일 이상으로 변경 
                 // 2014.05.08 김용습 [CHM-201430082] 최대 조회 허용기간을 92일로 변경
                    if (ComGetDaysBetween(frmObj.p_date1.value, frmObj.p_date2.value) > 91) {
                        ComShowCodeMessage("CTM30012", "92 days");
                        frmObj.p_date1.focus();
                        return;
                    }
                    /*
                    // p_date1과 p_date2의 간격이 16일 이상일 경우 return
                    if (ComGetDaysBetween(frmObj.p_date1.value, frmObj.p_date2.value) > 15) {
                        ComShowCodeMessage("CTM30012", "16 days");
                        frmObj.p_date1.focus();
                        return;
                    }
                    */

                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    frmObj.office.value = comboObjects[0].GetIndexText(comboObjects[0].Index, 1);
                    
                    //HJSBIZ_CR_40 - add
                    processMode("SEARCH");
                    
                    frmObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("EES_CTM_0429GS.do", FormQueryString(frmObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                    
                    if (backendJobKey.length > 0) {
                        frmObj.backendjob_key.value = backendJobKey;
                        sheetObj.RequestTimeOut = 20000;
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                    }
                }
                break;

            case IBSAVE:    // 저장
                if (validateForm(sheetObj, formObj, sAction)) {
                    frmObj.f_cmd.value = MULTI;
                    sheetObj.DoSave("EES_CTM_0429GS.do", FormQueryString(frmObj), "Sel", true);
                }
                break;
        }
    }


    /**
     * HTML Object의 OnChange이벤트 처리
     */
    function obj_onchange(event) {
        sheetObjects[0].RemoveAll();
        var frmObj = document.form;
        switch(event.srcElement.name) {
            // vvdsts_change_combo선택에 따른 처리
            case "type":
                if (frmObj.type.value == "I") {    // Redelivery 선택시
                    sheetObjects[0].CellText(0, "MTYDest") = "Empty Org";
                    sheetObjects[0].ColHidden("qty") = true;
                    sheetObjects[0].ColHidden("q_qty") = true;

                } else {    // Release 선택시
                    sheetObjects[0].CellText(0, "MTYDest") = "Empty Dest";
                    sheetObjects[0].ColHidden("qty") = false;
                    sheetObjects[0].ColHidden("q_qty") = false;

                }
                break;
        }
        onShowErrMsg = false;
    }


    /**
     * HTML Object의 OnKeyUp이벤트 처리
     */
    function obj_onkeyup(event) {
        srcValue = event.srcElement.value;    // CoCtm.js의 공통스크립트의 자동실행 방지용
        var frmObj = document.form;
        var sheetObj = sheetObjects[0];
        switch(event.srcElement.name) {
            case "yd_cd_disp":
            // yd_cd_disp에 입력되는 값의 length에 따른 처리
                var ydCdDisp = frmObj.yd_cd_disp;
                var pYard2 = document.getElementById("p_yard2");
                if (ydCdDisp.value.length > 1) {
                    frmObj.p_yard1.value = ydCdDisp.value.toUpperCase();
                    if (ydCdDisp.value.length > 4) {
                          // p_yard1에 5글자가 채워지면 CTM공통함수의 yard_search() 호출
                          if (!yard_search()) {
                                ydCdDisp.select();
                                ydCdDisp.focus();
                          } else {
                                frmObj.p_yard2.focus();
                          }
                    } else {
                        pYard2.RemoveAll();
                    }
                } else {
                    frmObj.p_yard1.value = "";
                    pYard2.RemoveAll();
                }
                break;

        }
        onShowErrMsg = false;

    }


    /**
     * Sheet의 OnSearchEnd 이벤트 처리
     */	
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

    	var formObj = document.form;
    	 
        if (ErrMsg == "") {
            with (sheetObj) {
                Redraw = false;
                for (var i=1; i<RowCount+1; i++) {
                    if (CellValue(i, "inv_no") != "") {
                        RowEditable(i) = false;
                    }
                                        
                    //HJSBIZ_CR_40 - add
                    if ( i == 1) {
                    	ComSetObjValue(formObj.total_cnt, 	CellValue(1, "total_cnt")); 
                    	ComSetObjValue(formObj.disp_total_cnt, 	ComAddComma(CellValue(1, "total_cnt"))); 
                    }
                    
                }
                
                //HJSBIZ_CR_40 - add
                ComSetObjValue(formObj.row_cnt, 		RowCount);                
                if (ComParseInt(ComGetObjValue(formObj.total_cnt)) >  ComParseInt(ComGetObjValue(formObj.row_cnt))) {
                    // APPEND 검색을 위한 페이지번호 setting
                	ComSetObjValue(formObj.page_no,   	ComParseInt(ComGetObjValue(formObj.page_no)) + 1);
                    ComBtnEnable("btn_more");
                } else {
                    ComBtnDisable("btn_more");
                }
                
                Redraw = true;
            }
        }
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }

    

    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        if (sheetObj.ColSaveName(Col) != "Sel") {
            // row클릭시 해당 Check Box도 체크
            with(sheetObj) {
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    Redraw = false;
                    for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "Sel")) {
                            CellValue2(arr[i], "Sel") = "1";    // 선택된 행의 CheckBox 체크
                        }
                    }
                    Redraw = true;
                }
            }
        }
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            ComShowCodeMessage("CTM10022", "Release/Redelivery History");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }


    /**
     * territory[combo0] Object의 OnKeyDown이벤트 처리
     */
    function territory_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


    /**
     * p_yard2[combo1] Object의 OnKeyDown이벤트 처리
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


    /**
     * BackEndJob 호출함수
     */
    function getBackEndJobStatus() {
        frmObj = document.form;
        var sheetObj = sheetObjects[0];
        frmObj.f_cmd.value = SEARCH;
        var sXml = sheetObj.GetSearchXml("EES_CTM_0429GS.do", FormQueryString(frmObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")
        //alert("sheet1 :::>> jobState : "+jobState);

        if (jobState == "3") {
            getBackEndJobLoadFile();
            clearInterval(timer);
        } else if (jobState == "4") {
            ComOpenWait(false);
            // BackEndJob을 실패 하였습니다.
            ComShowCodeMessage('CTM10024');
        } else if (jobState == "5") {
            ComOpenWait(false);
            // 이미 BackEndJob 결과 파일을 읽었습니다.
            ComShowCodeMessage('CTM10024');
        }
    }


    /**
    * BackEndJob의 결과가 완료되면 sheet로 loading
    */
    function getBackEndJobLoadFile() {
        frmObj = document.form;
        frmObj.f_cmd.value = SEARCHLIST;
        
        //sheetObjects[0].DoSearch("EES_CTM_0429GS.do", FormQueryString(frmObj));
        //HJSBIZ_CR_40 - 페이징 APPEND 모드
        sheetObjects[0].DoSearch("EES_CTM_0429GS.do", FormQueryString(frmObj), "", true);
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
            /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
//            if (sAction == IBSEARCH) {
//             if (cancelDate == false) return false;
//            }
        	var tmpobjValue = document.getElementById("p_date1").value;
        	var tmpobjValue2 = document.getElementById("p_date2").value
            // 전체 내용중 -를 삭제.
        	
        	tmpobjValue = ComGetUnMaskedValue(tmpobjValue, "ymd");
            tmpobjValue2 = ComGetUnMaskedValue(tmpobjValue2, "ymd");
            if (!ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue2) || !ComIsDate(tmpobjValue2)) {
				return false;
            } else {
                    date1 = document.getElementById("p_date1").value;
                    date2 = document.getElementById("p_date2").value;
                    date1 = ComGetUnMaskedValue(date1, "ymd");
                    date2 = ComGetUnMaskedValue(date2, "ymd");
                    if (date1 == '' || date2 == '') return false;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	frmObj.p_date1.focus();
                        return false;
                    }

            }
        }
        return true;
    }

    /**
     * tpszCombo의 MultiSelection OnCheckClick 이벤트 처리
     */
    function tpszCombo_OnCheckClick(comboObj, index, code) {
        // coCtm의 multiComboOnCheckClick 호출
        multiComboOnCheckClick(comboObj, index, document.form.cntr_tpsz_cd);
    }
    
    //HJSBIZ_CR_40 - add
    /**
     * hType1_OnChange 의  chagne 이벤트 처리
     */
	function hType1_OnChange(ComboObj, Index_Code, Text){
		//alert("ComboObj : "+ComboObj.id + " ,Index_Code : "+Index_Code + " ,Text : "+Text);
		var formObj 	= document.form;
 		with(formObj) {
			if(Index_Code == 'CH'){
				ComSetObjValue(bkg_chk, 			"Y");
		        ComSetObjValue(tro_chk, 			"Y");
		        ComSetObjValue(mh_chk, 			"");
		        ComSetObjValue(mt_repo_chk, 	"");
		        ComSetObjValue(st_chk, 			"");
		        
		        //hType2_OnChange Enable
		        hType2.Enable = true;
		        hType2.Index = 0;
		        
			} else if(Index_Code == 'MH'){
				ComSetObjValue(bkg_chk, 			"");
		        ComSetObjValue(tro_chk, 			"");
		        ComSetObjValue(mh_chk, 			"Y");
		        ComSetObjValue(mt_repo_chk, 	"");
		        ComSetObjValue(st_chk, 			"");
		        
		        //hType2_OnChange Disable
		        hType2.Enable = false;
		        hType2.Index = -1;
		        
			} else if(Index_Code == 'MT'){
				ComSetObjValue(bkg_chk, 			"");
		        ComSetObjValue(tro_chk, 			"");
		        ComSetObjValue(mh_chk, 			"");
		        ComSetObjValue(mt_repo_chk, 	"Y");
		        ComSetObjValue(st_chk, 			"");
		        
		        //hType2_OnChange Disable
		        hType2.Enable = false;
		        hType2.Index = -1;
     
			} else if(Index_Code == 'ST'){
				ComSetObjValue(bkg_chk, 			"");
		        ComSetObjValue(tro_chk, 			"");
		        ComSetObjValue(mh_chk, 			"");
		        ComSetObjValue(mt_repo_chk, 	"");
		        ComSetObjValue(st_chk, 			"Y");
		        
		        //hType2_OnChange Disable
		        hType2.Enable = false;
		        hType2.Index = -1;
		        
			} else if(Index_Code == 'A'){
				ComSetObjValue(bkg_chk, 			"");
		        ComSetObjValue(tro_chk, 			"");
		        ComSetObjValue(mh_chk, 			"");
		        ComSetObjValue(mt_repo_chk, 	"");
		        ComSetObjValue(st_chk, 			"");
		        
		        //hType2_OnChange Disable
		        hType2.Enable = false;
		        hType2.Index = -1;
		        
			}
 		}
	}
	
	//HJSBIZ_CR_40 - add
    /**
     * hType2_OnChange 의  chagne 이벤트 처리
     */
    function hType2_OnChange(ComboObj, Index_Code, Text){
    	//alert("ComboObj : "+ComboObj.id + " ,Index_Code : "+Index_Code + " ,Text : "+Text);
    	var formObj 	= document.form;
 		with(formObj) {
	    	if(Index_Code == 'BKG'){
				ComSetObjValue(bkg_chk, 			"Y");
		        ComSetObjValue(tro_chk, 			"");
			} else if(Index_Code == 'TRO'){
				ComSetObjValue(bkg_chk, 			"");
				ComSetObjValue(tro_chk, 			"Y");
			} else if(Index_Code == 'A'){
				ComSetObjValue(bkg_chk, 			"Y");
		        ComSetObjValue(tro_chk, 			"Y");
			}
 		}
    }
    
	
/* 개발자 작업 끝 */
