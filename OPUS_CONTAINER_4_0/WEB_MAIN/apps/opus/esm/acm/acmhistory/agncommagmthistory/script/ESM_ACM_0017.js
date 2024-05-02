/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0017.js
*@FileTitle  : Special Compensation CSR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
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
     * @class ESM_ACM_0017 : ESM_ACM_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[1];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
            } // end switch
        }
        catch (e) {
        	
		}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++]=shtObj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {
                case "sheet1":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle1="|CHK|Agreement No.|Effrctive Date|Effrctive Date|Remark|Del|Event Date|Event Date|Event Date|Event Date|User Name|||||";
                    var HeadTitle2="|CHK|Agreement No.|From|To|Remark|Del|Local Time|Local Time|GMT|GMT|User Name|||||";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                    { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"agn_agmt_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt_tm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_gdt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cre_gdt_tm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_fm_dt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_to_dt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"h_cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_his_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    InitColumns(cols);
                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetEditEnterBehavior("tab");
                    SetSheetHeight(160);
                    break;
                    
                case "sheet2":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle="Agreement No.|Item|Current|Privious";
                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no" , 	  UpdateEdit:0, InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"item" , 		  UpdateEdit:0, InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:350,  Align:"Center",  ColMerge:0,   SaveName:"current_value",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:350,  Align:"Center",  ColMerge:0,   SaveName:"previous_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    InitColumns(cols);
                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetEditEnterBehavior("tab");
                    SetSheetHeight(135);
                    break;
                    
                case "sheet3":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle="Agreement No.|Item|Item|Current|Previous|Comp. Master Info";
                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"item1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"item2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:210,  Align:"Center",  ColMerge:0,   SaveName:"current_value",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:210,  Align:"Center",  ColMerge:0,   SaveName:"previous_value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:210,  Align:"Center",  ColMerge:0,   SaveName:"master_info",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    InitColumns(cols);
                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetEditEnterBehavior("tab");
                    SetSheetHeight(ComGetSheetHeight(shtObj, 10));
                    break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        // axon_event.addListener("change", "frmObj_OnChange", "", "ar_ofc_cd", "agn_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // RHQ level과 목록 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                ACMXml2SelectItem(xmlStr, frmObj.rhq_cd_disp, "value0", "value0", true);    // CoAcm.js에 정의
                var rhqCd=ComGetEtcData(xmlStr, "rhq_cd");
                ofcKndCd=ComGetEtcData(xmlStr, "ofc_knd_cd");    // *** 반드시 전역변수로 setting에 유의 ***
                if (rhqCd == "") {
                    // 본사 User일 경우 (rhqCd가 Null로 조회)
                    frmObj.rhq_cd_disp.style.display="inline";    // hidden인 form.rhq_cd_disp가 보여지게 함
                    frmObj.rhq_cd.style.display="none";    // form.rhq_cd는 숨김
                } else {
                    frmObj.rhq_cd_disp.value=rhqCd;    // hidden상태 그대로 form.rhq_cd_disp에 rhqCd가 선택되게 하고
                    //frmObj.rhq_cd_disp.fireEvent("onchange");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                    ComFireEvent(frmObj.rhq_cd_disp, "change");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                }
                break;
            case IBSEARCH:    // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                sheetObjects[1].RemoveAll();
                sheetObjects[0].DoSearch("ESM_ACM_0017GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case SEARCH02:    // 조회(Detail)
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH02;
                var shtObj2=sheetObjects[1];
                var shtObj3=sheetObjects[2];
                shtObj2.RemoveEtcData();
                shtObj3.RemoveEtcData();
                var xmlArr=shtObj2.GetSearchData("ESM_ACM_0017GS.do", FormQueryString(frmObj)).split("|$$|");
                shtObj2.LoadSearchData(xmlArr[0],{Sync:0} );
                shtObj3.LoadSearchData(xmlArr[1],{Sync:0} );
                ComOpenWait(false);
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
    /**
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet1_OnClick(shtObj, row, col, value) {
        var frmObj=document.form;
        frmObj.agmt_his_no.value=shtObj.GetCellValue(row,"agmt_his_no");
        frmObj.agn_agmt_no.value=shtObj.GetCellValue(row,"agn_agmt_no");
        doActionIBSheet(shtObj, document.form, SEARCH02);
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
            	GetRangeFontBold(SetTopRow, SaveNameCol("agn_agmt_no"), LastRow(), SaveNameCol("item"))(1);
            	GetRangeFontColor(SetTopRow, SaveNameCol("agn_agmt_no"), LastRow(), SaveNameCol("item"))("#275F65");
            	GetRangeBackColor(SetTopRow, SaveNameCol("agn_agmt_no"), LastRow(), SaveNameCol("item"))("#C1C4E8");
            }
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet3_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
            	GetRangeFontBold(SetTopRow, SaveNameCol("agn_agmt_no"), LastRow(), SaveNameCol("item2"))(1);
            	GetRangeFontColor(SetTopRow, SaveNameCol("agn_agmt_no"), LastRow(), SaveNameCol("item2"))("#275F65");
            	GetRangeBackColor(SetTopRow, SaveNameCol("agn_agmt_no"), LastRow(), SaveNameCol("item2"))("#C1C4E8");
            }
        }
    }
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        var shtObj=sheetObjects[0];
        with (document.form) {
            switch (elementName) {
                case "rhq_cd_disp":    // RHQ를 변경시 Office목록을 setting
                    if (rhq_cd_disp.value == "") {
                        ComClearCombo(ar_ofc_cd);
                        ComClearCombo(agn_cd);
                        return;
                    }
                    rhq_cd.value=rhq_cd_disp.value;
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH18 + "&value0=" + rhq_cd.value + "&value1=" + ofcKndCd );
                    if (ACMXml2SelectItem(xmlStr, ar_ofc_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (ar_ofc_cd.options.length > 1) {
                            // rhq_cd와 같은 값이 선택되게 함
                            ar_ofc_cd.value=rhq_cd.value;
                        }
                        document.form.ar_ofc_cd.addEventListener("change",frmObj_OnChange);
//                        $("#ar_ofc_cd").change();
                        if (ar_ofc_cd.value == "") {
                            ComClearCombo(agn_cd);
                            return;
                        }
                        var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                        if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                            // option이 하나 이상이라면
                            if (agn_cd.options.length > 1) {
                                // ar_ofc_cd와 같은 값이 선택되게 함
                                agn_cd.value=ar_ofc_cd.value;
                            }
                        }
                    }
                    break;
                case "ar_ofc_cd":    // Office를 변경시 Sub Office목록을 setting
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (agn_cd.options.length > 1) {
                            // ar_ofc_cd와 같은 값이 선택되게 함
                            agn_cd.value=ar_ofc_cd.value;
                        }
                    }
                    break;
            }
        }
    }
/* 개발자 작업 끝 */
