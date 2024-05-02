/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0423.js
 *@FileTitle : Queue Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.30
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2011.05.30 김상수
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
     * @extends
     * @class esm_bkg_0423  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0423() {
        this.processButtonClick = trocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
        this.setComboObject     = setComboObject;
    }


/* 개발자 작업  */


// 공통전역변수
var comboCnt = 0;
var comboObjects = new Array();

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick  = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var frmObj = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        try {
            switch (srcName) {
                case "btn_dura_date":
                    (new ComCalendarFromTo()).select(frmObj.dura_from_dt, frmObj.dura_to_dt,'yyyy-MM-dd');
                    break;

                case "chk_key":
                    if (ComGetObjValue(frmObj.chk_key) == "DT") {
                        frmObj.dura_from_dt.value = frmObj.tmp_dura_from_dt.value;
                        frmObj.dura_to_dt.value = frmObj.tmp_dura_to_dt.value
                        frmObj.tmp_dura_from_dt.value = "";
                        frmObj.tmp_dura_to_dt.value = "";
                        frmObj.dura_from_dt.className = "input1";
                        frmObj.dura_to_dt.className = "input1";
                        frmObj.btn_dura_date.style.display = "inline";
                    } else {
                        frmObj.tmp_dura_from_dt.value = frmObj.dura_from_dt.value;
                        frmObj.tmp_dura_to_dt.value = frmObj.dura_to_dt.value
                        frmObj.dura_from_dt.value = "";
                        frmObj.dura_to_dt.value = "";
                        frmObj.dura_from_dt.className = "input2";
                        frmObj.dura_to_dt.className = "input2";
                        frmObj.btn_dura_date.style.display = "none";
                    }
                    if (ComGetObjValue(frmObj.chk_key) == "VVD") {
                        frmObj.vvd_cd.className = "input1";
                        frmObj.vvd_cd.setAttribute("required","",true);
                    } else {
                        frmObj.vvd_cd.className = "input";
                        frmObj.vvd_cd.removeAttribute("required",true);
                    }
                    if (ComGetObjValue(frmObj.chk_key) == "BKG") {
                        frmObj.bkg_no.className = "input1";
                        frmObj.bkg_no.setAttribute("required","",true);
                    } else {
                        frmObj.bkg_no.className = "input";
                        frmObj.bkg_no.removeAttribute("required",true);
                    }
                    break;

                case "btn_SRCH_SET":
                    var param = "";
                    ComOpenPopup("ESM_BKG_0446.do" + param, 650, 330, "PopupEsmBkg446", "1,0,1,1,1", true);
                    break;

                case "btn_Retrieve":
                    sheetObjects[0].RemoveEtcData();
                    sheetObjects[1].RemoveEtcData();
                    sheetObjects[2].RemoveEtcData();
                    sheetObjects[3].RemoveEtcData();
                    sheetObjects[4].RemoveEtcData();
                    sheetObjects[5].RemoveEtcData();
                    doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
                    break;

                case "btn_New":
                    sheetObjects[0].RemoveEtcData();
                    sheetObjects[1].RemoveEtcData();
                    sheetObjects[2].RemoveEtcData();
                    sheetObjects[3].RemoveEtcData();
                    sheetObjects[4].RemoveEtcData();
                    sheetObjects[5].RemoveEtcData();
                    ComResetAll();
                    break;

                case "btn_DownExcel_sheet1":
                    doActionIBSheet(sheetObjects[0], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet2":
                    doActionIBSheet(sheetObjects[1], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet3":
                    doActionIBSheet(sheetObjects[2], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet4":
                    doActionIBSheet(sheetObjects[3], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet5":
                    doActionIBSheet(sheetObjects[4], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet6":
                    doActionIBSheet(sheetObjects[5], frmObj, IBDOWNEXCEL);
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


/*********************** EDTITABLE MULIT COMBO START ********************/

    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    //ComComboObject생성자 메소드에서 호출됨
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
        	if(comboId == "dpcs_ofc_cd"){
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	 	 				
 	 			BackColor = "#ccfffd";	 	 	
        	}else if (comboId == "rgnCdCombo") {
                MultiSelect = true;
                UseEdit = false;
                DropHeight = 200;
            } else {
                MultiSelect = false;
                UseEdit = false;
                DropHeight = 200;
            }
        }
    }


    /*############################# combo event start ########################*/
    /**
     * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
     * 입력값을 upper로 변경하여 재등록 한다.
     * @param comboObj
     * @return
     */
    function p_eq_type_OnChange(comboObj) {
        combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
    }

    function combo_Change(comboObj, multiComboDataAddedFlag) {
        var frmObj = document.form;
        // 사용자 입력값을 uppercase로 변경
        var comboText =  comboObj.Text.toUpperCase();
        // 이전에 등록되었으면 삭제
        if (multiComboDataAddedFlag) {
            comboObj.DeleteItem(0);
            multiComboDataAddedFlag = false;
        }
        // 선택 또는 입력한  값이 콤보에 있으면 리턴
        if (comboObj.FindIndex(comboText, 0) != -1) {
            return;
        }
        comboObj.InsertItem(0, comboText, comboText);
        multiComboDataAddedFlag = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수)
        comboObj.Text2 = comboText;  // 입력값이 선택되게 한다.
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
    
    /*############################# combo event end ########################*/

/*********************** EDTITABLE MULIT COMBO END********************/


   /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++] = tabObj;
    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt = 0 ;
                    InsertTab(cnt++, " Status by SI Event", -1);
                    InsertTab(cnt++, " By SI Kind", -1);
                    InsertTab(cnt++, " Just in Time(JIT) Completion", -1);
                    InsertTab(cnt++, " By Urgency", -1);
                    InsertTab(cnt++, " By Return Feedback Status", -1);
                    InsertTab(cnt++, " Aging Status(P.F)", -1);
                }
                break;
        }
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
        var objs = document.all.item("tabLayer");
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";
        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
        //------------------------------------------------------//
        beforetab = nItem;
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        //MultiCombo초기화
        for (var k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k], comboObjects[k].id);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        var frmObj = document.form;
        axon_event.addListenerFormat('keypress', 'bkg_keypress', frmObj); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate', frmObj); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate', frmObj); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        ComBtnDisable("btn_Split");
    }


    /*********************** KEY EVENT START ********************/
    function bkg_keypress() {
        switch (event.srcElement.dataformat) {
            case "ymd":
                //number
                ComKeyOnlyNumber(event.srcElement, "-");
            break;
            case "engup":
                //영문대문자
                ComKeyOnlyAlphabet('upper');
            break;
            case "engupnum":
                //숫자+"영문대분자"입력하기
                ComKeyOnlyAlphabet('uppernum');
            break;
            case "num":
                //숫자 입력하기
                ComKeyOnlyNumber(event.srcElement);
            break;
            case "custname":
                //숫자 입력하기
                ComKeyOnlyAlphabet("uppernum", "40|41|46|44|32|42|38|35|45");
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
        switch (event.srcElement.getAttribute("name")) {
            case "dura_from_dt":
                ComAddSeparator(event.srcElement);
            break;
            case "dura_to_dt":
                ComAddSeparator(event.srcElement);
            break;
        }
    }


    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        //입력Validation 확인하기
        switch (event.srcElement.name) {
            case "dura_from_dt":
                ComClearSeparator(event.srcElement);
            break;
            case "dura_to_dt":
                ComClearSeparator(event.srcElement);
            break;
        }
    }

    /*********************** KEY EVENT END ********************/


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, Row, Col, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch (sAction) {
            case IBSEARCH:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.vvd_cd.focus();//duration date 체크를 위함
                frmObj.f_cmd.value = SEARCH;

                var sXml = sheetObj.GetSearchXml("ESM_BKG_0423GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");

                sheetObjects[0].LoadSearchXml(arrXml[0]);
                sheetObjects[1].LoadSearchXml(arrXml[1]);
                sheetObjects[2].LoadSearchXml(arrXml[2]);
                sheetObjects[3].LoadSearchXml(arrXml[3]);
                sheetObjects[4].LoadSearchXml(arrXml[4]);
                sheetObjects[5].LoadSearchXml(arrXml[5]);

                ComOpenWait(false); //대기이미지 숨김

                break;

            case SEARCH01:      //페이지 최초 로딩시 조회
                frmObj.f_cmd.value = SEARCH01;
                sheetObj.Redraw = false;

                var sXml = sheetObj.GetSearchXml("ESM_BKG_0421GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");
                ComXml2ComboItem(arrXml[0], frmObj.elements["input"], "val", "name");
                frmObj.elements["input"].Index = 0;  //All
                ComXml2ComboItem(arrXml[0], frmObj.elements["rate"], "val", "name");
                frmObj.elements["rate"].Index = 0;  //All
                ComXml2ComboItem(arrXml[0], frmObj.elements["qa"], "val", "name");
                frmObj.elements["qa"].Index = 0;  //All
                ComXml2ComboItem(arrXml[0], frmObj.elements["fax"], "val", "name");
                frmObj.elements["fax"].Index = 0;  //All
                if (arrXml.length > 1) ComXml2ComboItem(arrXml[1], frmObj.elements["rgnCdCombo"], "val", "val|name");
                frmObj.elements["rgnCdCombo"].Index = 0;  //ALL
                if (arrXml.length > 2) ComXml2ComboItem(arrXml[2], frmObj.elements["sts"], "val", "val|name");
                ComSetObjValue(frmObj.elements["sts"], "A");
                if (arrXml.length > 3) ComXml2ComboItem(arrXml[3], frmObj.elements["src_cd"], "val", "val|name");
                frmObj.elements["src_cd"].Index = 0;  //All
                if (arrXml.length > 4) ComXml2ComboItem(arrXml[4], frmObj.elements["sr_amd_tp_cd"], "val", "name");
                frmObj.elements["sr_amd_tp_cd"].Index = 0;
                if (arrXml.length > 5) ComXml2ComboItem(arrXml[5], frmObj.elements["slan_cd"], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
                frmObj.slan_cd.InsertItem(0, "All", "All");
                frmObj.slan_cd.Index =0 ;
                if (arrXml.length > 6) ComXml2ComboItem(arrXml[6], frmObj.elements["bkg_cust_tp_cd"], "val", "name");
                frmObj.elements["bkg_cust_tp_cd"].Index =0 ;
                if (arrXml.length > 7) {
                	ComXml2ComboItem(arrXml[7], frmObj.elements["dpcs_ofc_cd"], "val", "name");
                	if(frmObj.usr_ofc_cd.value == "PKGSA"){
                		frmObj.elements["dpcs_ofc_cd"].Index =0 ;
                	}else if(frmObj.usr_ofc_cd.value == "SZPSC" || frmObj.usr_ofc_cd.value == "ZHOSO" ||
                			 frmObj.usr_ofc_cd.value == "CANSO" || frmObj.usr_ofc_cd.value == "FOCSO" ||
                			 frmObj.usr_ofc_cd.value == "XMNSC" || frmObj.usr_ofc_cd.value == "HKGSC" ){
                		frmObj.elements["dpcs_ofc_cd"].Index =1 ;
                	}
                }

                if ("Y"!= ComGetEtcData(arrXml[0], "isPicBtn")) ComBtnDisable("btn_pic");
                if ("U" == ComGetEtcData(arrXml[0], "grp_cd")) {
                    ComBtnEnable("btn_stsc");
                    ComBtnEnable("btn_Delete");
                } else {
                    ComBtnDisable("btn_stsc");
                    ComBtnDisable("btn_Delete");
                }
                ComSetObjValue(frmObj.grp_cd, ComGetEtcData(arrXml[0], "grp_cd"));
                sheetObj.Redraw = true;
                break;

            case IBDOWNEXCEL:      // 엑셀다운
                sheetObj.SpeedDown2Excel(-1);
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        switch(sAction) {
            case IBSEARCH:
                if (!ComChkValid(frmObj)) return false;
            	if(ComGetObjValue(frmObj.dpcs_ofc_cd) == ""){
            		ComShowCodeMessage("BKG01101", "Doc OFC")
                    frmObj.dpcs_ofc_cd.focus();
                    return false;
            	}
                if (ComIsNull(frmObj.bkg_no) && ComGetObjValue(frmObj.chk_key) == "DT") {
                    if (ComIsNull(frmObj.dura_from_dt) ||  ComIsNull(frmObj.dura_to_dt)) {
                        ComShowCodeMessage("BKG00626", "Duration");
                        if(ComIsNull(frmObj.dura_from_dt))frmObj.dura_from_dt.focus();
                        else if(ComIsNull(frmObj.dura_to_dt))frmObj.dura_to_dt.focus();
                        return false;
                    } else if(ComGetDaysBetween(frmObj.dura_from_dt.value, frmObj.dura_to_dt.value) > 14 ) {
                        ComShowCodeMessage("COM132001", "Duration", "14Days")
                        frmObj.dura_to_dt.focus();
                        return false;
                    }
                }
                //최소입력길이확인(vvd) - engupnum 은 공통적용안됨
                if (ComGetObjValue(frmObj.chk_key) == "VVD") {
                    var objs = frmObj.elements;
                    for (var i=0; i<objs.length; i++) {
                        if (objs[i] && ""==objs[i].getAttribute("fullfill")) {
                            var chkLen = objs[i].getAttribute("maxLength");
                            var caption = objs[i].getAttribute("caption");
                            if (2!=ComChkLenByByte(objs[i], objs[i].getAttribute("maxLength"))) {
                                ComShowCodeMessage("COM12174", caption, chkLen);  //{?msg1} must be at least {?msg2} characters long.
                                ComSetFocus(objs[i]);
                                return false;
                            }
                        }
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
        with(sheetObj) {

            // 높이 설정
            style.height = 350;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            CountPosition = 0;
            WaitImageVisible = false;


            switch (sheetNo) {
                // Status by SI Event
                case 1:    // sheet1 init
                    cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

                    var HeadTitle0 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|Overall Progress|Overall Progress|Overall Progress|Overall Progress|Overall Progress|Overall Progress|Overall Progress|Overall Progress" +
                                     "|Completion Status by Event|Completion Status by Event|Completion Status by Event|Completion Status by Event|Completion Status by Event|Completion Status by Event|Completion Status by Event|Completion Status by Event";

                    var HeadTitle1 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|Done|%|DC Pend|%|FO Pend|%|Open|%" +
                                     "|Input|%|Rate|%|QA|%|BL Proof|%";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "region");                                 // Region
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");                             // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "kind");                                   // Kind
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  true,  "total",        false, "", dfInteger);     // Total

                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "done",         false, "", dfInteger);     // [Overall~] Done
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "done_per",     false, "", dfFloat, 2);    // [Overall~] %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "dc_pend",      false, "", dfInteger);     // [Overall~] DC Pend
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "dc_pend_per",  false, "", dfFloat, 2);    // [Overall~] %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "fo_pend",      false, "", dfInteger);     // [Overall~] FO Pend
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "fo_pend_per",  false, "", dfFloat, 2);    // [Overall~] %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "open_ind",     false, "", dfInteger);     // [Overall~] FO Pend
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "open_ind_per", false, "", dfFloat, 2);    // [Overall~] %

                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "input",        false, "", dfInteger);     // [Completion~] Input
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "input_per",    false, "", dfFloat, 2);    // [Completion~] %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "rate",         false, "", dfInteger);     // [Completion~] Rate
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_per",     false, "", dfFloat, 2);    // [Completion~] %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "qa",           false, "", dfInteger);     // [Completion~] QA
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "qa_per",       false, "", dfFloat, 2);    // [Completion~] %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "bl_proof",     false, "", dfInteger);     // [Completion~] BL Proof
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "bl_proof_per", false, "", dfFloat, 2);    // [Completion~] %

                    break;

                // By SI Kind
                case 2:    // sheet2 init
                    cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;  //msNone; msHeaderOnly; msPrevColumnMerge;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "|Seq.|Region|BKG Ofc.|Kind|Total|Original|%|Amend|%|Addition|%|Customs|%|BL Confirm|%";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "region");                                   // Region
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");                               // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "kind");                                     // Kind
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  true,  "total",          false, "", dfInteger);     // Total

                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "original",       false, "", dfInteger);     // Original
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "original_per",   false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "amend",          false, "", dfInteger);     // Amend
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "amend_per",      false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "addition",       false, "", dfInteger);     // Addition
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "addition_per",   false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "customs",        false, "", dfInteger);     // Customs
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "customs_per",    false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         70,  daRight,  false, "bl_confirm",     false, "", dfInteger);     // BL Confirm
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "bl_confirm_per", false, "", dfFloat, 2);    // %

                    break;

                // Just in Time(JIT) Completion
                case 3:    // sheet3 init
                    cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

                    var HeadTitle0 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|SI Rec. Status|SI Rec. Status|SI Rec. Status|SI Rec. Status|SI Rec. Status|SI Rec. Status" +
                                     "|Completion Status|Completion Status|Completion Status|Completion Status";

                    var HeadTitle1 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|DCT-1day|%|PCT (After)|%|BDR (After)|%" +
                                     "|Rate after PCT|%|Com. After BDR|%";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "region");                              // Region
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");                          // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "kind");                                // Kind
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  true,  "total",     false, "", dfInteger);     // Total

                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "dct_flag",  false, "", dfInteger);     // [SI Rec.~] DCT-1day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "dct_per",   false, "", dfFloat, 2);    // [SI Rec.~] %
                    InitDataProperty(0, cnt++, dtData,         75,  daRight,  false, "pct_flag",  false, "", dfInteger);     // [SI Rec.~] PCT (After)
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "pct_per",   false, "", dfFloat, 2);    // [SI Rec.~] %
                    InitDataProperty(0, cnt++, dtData,         75,  daRight,  false, "bdr_flag",  false, "", dfInteger);     // [SI Rec.~] BDR (After)
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "bdr_per",   false, "", dfFloat, 2);    // [SI Rec.~] %

                    InitDataProperty(0, cnt++, dtData,         90,  daRight,  false, "rate_flag", false, "", dfInteger);     // [Completion~] Rate after PCT
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_per",  false, "", dfFloat, 2);    // [Completion~] %
                    InitDataProperty(0, cnt++, dtData,         95,  daRight,  false, "com_flag",  false, "", dfInteger);     // [Completion~] Com. After BDR
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "com_per",   false, "", dfFloat, 2);    // [Completion~] %

                    break;

                // By Urgency
                case 4:    // sheet4 init
                    cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;  //msNone; msHeaderOnly; msPrevColumnMerge;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "|Seq.|Region|BKG Ofc.|Kind|Total|Normal|%|VIP|%|Urgent|%|EDI|%";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "region");                               // Region
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");                           // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "kind");                                 // Kind
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  true,  "total",      false, "", dfInteger);     // Total

                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "normal",     false, "", dfInteger);     // Normal
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "normal_per", false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "vip",        false, "", dfInteger);     // VIP
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "vip_per",    false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "urgent",     false, "", dfInteger);     // Urgent
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "urgent_per", false, "", dfFloat, 2);    // %
                    InitDataProperty(0, cnt++, dtData,         60,  daRight,  false, "edi",        false, "", dfInteger);     // EDI
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "edi_per",    false, "", dfFloat, 2);    // %

                    break;

                // By Return Feedback Status
                case 5:    // sheet5 init
                    cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

                    var HeadTitle0 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|RTN Total|RTN Total" +
                                     "|RTN to Inputter|RTN to Inputter|RTN to Inputter|RTN to Inputter|RTN to Inputter" +
                                     "|RTN to Rater|RTN to Rater|RTN to Rater|RTN to Rater|RTN to Rater" +
                                     "|RTN to FO|RTN to FO|RTN to FO|RTN to FO|RTN to FO" +
                                     "|RTN to Customer|RTN to Customer|RTN to Customer|RTN to Customer|RTN to Customer";

                    var HeadTitle1 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|RQST|%" +
                                     "|RQST|1 Day|3 Day|5 Day|%" +
                                     "|RQST|1 Day|3 Day|5 Day|%" +
                                     "|RQST|1 Day|3 Day|5 Day|%" +
                                     "|RQST|1 Day|3 Day|5 Day|%";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "region");                                  // Region
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");                              // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "kind");                                    // Kind
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  true,  "total",         false, "", dfInteger);     // Total

                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "total_rqst",    false, "", dfInteger);     // [~Total] RQST
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "total_per",     false, "", dfFloat, 2);    // [~Total] %

                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "input_rqst",    false, "", dfInteger);     // [~Inputter] RQST
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "input_d1",      false, "", dfInteger);     // [~Inputter] 1 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "input_d3",      false, "", dfInteger);     // [~Inputter] 3 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "input_d5",      false, "", dfInteger);     // [~Inputter] 5 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "input_per",     false, "", dfFloat, 2);    // [~Inputter] %

                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_rqst",     false, "", dfInteger);     // [~Rater] Request
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_d1",       false, "", dfInteger);     // [~Rater] 1 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_d3",       false, "", dfInteger);     // [~Rater] 3 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_d5",       false, "", dfInteger);     // [~Rater] 5 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "rate_per",      false, "", dfFloat, 2);    // [~Rater] %

                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "fo_rqst",       false, "", dfInteger);     // [~FO] RQST
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "fo_d1",         false, "", dfInteger);     // [~FO] 1 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "fo_d3",         false, "", dfInteger);     // [~FO] 3 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "fo_d5",         false, "", dfInteger);     // [~FO] 5 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "fo_per",        false, "", dfFloat, 2);    // [~FO] %

                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "customer_rqst", false, "", dfInteger);     // [~Customer] RQST
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "customer_d1",   false, "", dfInteger);     // [~Customer] 1 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "customer_d3",   false, "", dfInteger);     // [~Customer] 3 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "customer_d5",   false, "", dfInteger);     // [~Customer] 5 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "customer_per",  false, "", dfFloat, 2);    // [~Customer] %

                    break;

                // Aging Status(P.F)
                case 6:    // sheet6 init
                    cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

                    var HeadTitle0 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|Aging-DC Pend|Aging-DC Pend|Aging-DC Pend|Aging-DC Pend|Aging-DC Pend|Aging-DC Pend" +
                                     "|Aging-FO Pend|Aging-FO Pend|Aging-FO Pend|Aging-FO Pend|Aging-FO Pend|Aging-FO Pend";

                    var HeadTitle1 = "|Seq.|Region|BKG Ofc.|Kind|Total" +
                                     "|1-2 Day|%|3-5 Day|%|5 Over|%" +
                                     "|1-2 Day|%|3-5 Day|%|5 Over|%";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "region");                             // Region
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "bkg_ofc_cd");                         // BKG Ofc.
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true,  "kind");                               // Kind
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  true,  "total",    false, "", dfInteger);     // Total

                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "p_d1",     false, "", dfInteger);     // [~DC~] 1-2 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "p_d1_per", false, "", dfFloat, 2);    // [~DC~] %
                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "p_d3",     false, "", dfInteger);     // [~DC~] 3-5 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "p_d3_per", false, "", dfFloat, 2);    // [~DC~] %
                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "p_d5",     false, "", dfInteger);     // [~DC~] 5 Over
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "p_d5_per", false, "", dfFloat, 2);    // [~DC~] %

                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "f_d1",     false, "", dfInteger);     // [~FO~] 1-2 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "f_d1_per", false, "", dfFloat, 2);    // [~FO~] %
                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "f_d3",     false, "", dfInteger);     // [~FO~] 3-5 Day
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "f_d3_per", false, "", dfFloat, 2);    // [~FO~] %
                    InitDataProperty(0, cnt++, dtData,         55,  daRight,  false, "f_d5",     false, "", dfInteger);     // [~FO~] 5 Over
                    InitDataProperty(0, cnt++, dtData,         40,  daRight,  false, "f_d5_per", false, "", dfFloat, 2);    // [~FO~] %

                    break;

            }
        }
    }


    function sheet1_OnLoadFinish(sheetObj) {
        doActionIBSheet(sheetObj, document.form, SEARCH01);
    }


/* 개발자 작업  끝 */
