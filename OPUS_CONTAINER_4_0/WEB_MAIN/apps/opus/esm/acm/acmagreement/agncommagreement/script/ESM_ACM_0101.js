/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0101.js
*@FileTitle  : Agreement Copy From
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
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
     * @class ESM_ACM_0101 : ESM_ACM_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var preValue="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
//        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "opt":    // Retrieve
                    if (frmObj.opt[0].checked) {
                        with (frmObj) {
                            dir_agmt_no.readOnly=false;
                            dir_agmt_no.className="input1";
                            dir_agmt_no.setAttribute("required", "");
                            rhq_cd_disp.removeAttribute("required");
                            rhq_cd_disp.className="input2";
                            rhq_cd_disp.disabled=true;
                            ar_ofc_cd.removeAttribute("required");
                            ar_ofc_cd.className="input2";
                            ar_ofc_cd.disabled=true;
                            agn_cd.removeAttribute("required");
                            agn_cd.className="input2";
                            agn_cd.disabled=true;
                        }
                        ComBtnDisable("btn_retrieve");
                        //no support[check again]CLT shtObj.DataBackColor=shtObj.UnEditableColor;
//                        ACMGetCellEditable(shtObj, "chk", "agn_agmt_no", false);    // CoAcm.js에 정의
                        ACMCellEditable(shtObj, "chk", "agn_agmt_no", false); 
                    } else {
                        with (frmObj) {
                            dir_agmt_no.removeAttribute("required");
                            dir_agmt_no.className="input2";
                            dir_agmt_no.readOnly=true;
                            rhq_cd_disp.disabled=false;
                            rhq_cd_disp.className="input";
                            rhq_cd_disp.removeAttribute("required");
                            ar_ofc_cd.disabled=false;
                            ar_ofc_cd.className="input";
                            ar_ofc_cd.removeAttribute("required");
                            agn_cd.disabled=false;
                            agn_cd.className="input";
                            agn_cd.removeAttribute("required");
                        }
                        ComBtnEnable("btn_retrieve");
//                        ACMGetCellEditable(shtObj, "chk", "agn_agmt_no", true);    // CoAcm.js에 정의
                        ACMCellEditable(shtObj, "chk", "agn_agmt_no", true);
                        shtObj.SetDataBackColor(shtObj.GetEditableColor());
                    }
                    break;
                case "btn_retrieve":    // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_select":   // Select
                    doActionIBSheet(shtObj, frmObj, MULTI);
                    break;
                case "btn_close":   // close
                	ComClosePopup(); 
                    break;
            } // end switch
//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
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
       // sheet1_OnLoadFinish(sheet1); 메서드 반드시 참조
        sheet1_OnLoadFinish(sheetObjects[0]);
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
                    var HeadTitle0="STS|CHK|AGMT No.|Effective date|Effective date|DEL";
                    var HeadTitle1="STS|CHK|AGMT No.|From|To|DEL";
//                    (ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    SetEditEnterBehavior("tab");

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                           {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                           {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);

                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetCountPosition(0);
                    SetShowButtonImage(3);
                    SetSheetHeight(200);
                   break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
//        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
//        axon_event.addListener("change", "frmObj_OnChange", "rhq_cd_disp", "ar_ofc_cd", "agn_cd");
        // OnKeyUp 이벤트
        axon_event.addListener("keyup", "frmObj_OnKeyUp", "dir_agmt_no");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // RHQ 목록 조회
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
            case IBSEARCH:
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                 shtObj.DoSearch("ESM_ACM_0001GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case MULTI:
                if (!ComChkValid(frmObj)) return;
                var saveParam="f_cmd=" + MULTI + "&agn_agmt_no=" + frmObj.agn_agmt_no.value + "&agn_cd=" + frmObj.opnr_agn_cd.value;
                if (frmObj.opt[1].checked) {
                    if (shtObj.CheckedRows("chk") < 1) {
                        ComShowCodeMessage("COM12113", "Agreement Data");    // Please select {?msg1}
                        return;
                    }
                    saveParam += "&" + shtObj.GetSaveString(false, true, "chk");
                }
                ComOpenWait(true);
                 shtObj.LoadSaveData(shtObj.GetSaveData("ESM_ACM_0101GS.do", saveParam));
                ComOpenWait(false);
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
 function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 RHQ Select Object 생성
        doActionIBSheet(shtObj, document.form, SEARCH01);
        //document.form.opt[0].fireEvent("onclick");
        ComFireEvent(document.form.opt[0] , "click");
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") return;
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                    // OnChange 이벤트가 발생하면 document.agn_agmt_no에 값을 setting
                	document.form.agn_agmt_no.value=GetCellValue(Row, "agn_agmt_no");
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "agn_agmt_no":
                	ComOpenWindowCenter("ESM_ACM_0114.do?agn_agmt_no=" + shtObj.GetCellValue(Row, Col), "Agreement Information", 800, 456, true);
                    break;
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        // 저장 후 부모창 재조회 후 창 닫기
//        var opener=window.dialogArguments; 
        var opener;// MODAL창에서 부모창 호출
        if (!opener) opener=window.dialogArguments;
        if(!opener) opener=parent;
        opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
        ComClosePopup(); 
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
                            //ar_ofc_cd.value=rhq_cd.value;
                        }
                        //ar_ofc_cd.fireEvent("onchange");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                        ComFireEvent(ar_ofc_cd, "change");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
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
    /**
     * Form Element의 OnKeyUp 이벤트
     */
    function frmObj_OnKeyUp() {
        var elementName=ComGetEvent("name");
        var shtObj=sheetObjects[0];
        with (document.form) {
            switch (elementName) {
                case "dir_agmt_no":
                    if (dir_agmt_no.value.length > 8) {
                        // validation
                         var xmlStr=shtObj.GetSearchData("ESM_ACM_0101GS.do", "f_cmd=" + SEARCH02 + "&agn_agmt_no=" + dir_agmt_no.value);
                        if (ACMDecideErrXml(shtObj, xmlStr)) {
                            dir_agmt_no.value="";
                            ComSetFocus(dir_agmt_no);
                        } else {
                            // 오류가 없으면 document.agn_agmt_no에 값을 setting
                            agn_agmt_no.value=dir_agmt_no.value;
                        }
                    }
                    break;
            }
        }
    }
    /**
     * IBSheet 의 OnKeyDown 이벤트
     */
    function sheet1_OnKeyDown(Object, Row, Col, KeyCode){
    	if(KeyCode == "46"){
    		preValue=sheetObjects[0].GetCellValue(Row,Col);
    	}
    }
    /**
     * IBSheet 의 OnKeyUp 이벤트
     */
    function sheet1_OnKeyUp(Object, Row, Col, KeyCode){
    	if(KeyCode == "46"){
    		 sheetObjects[0].SetCellValue(Row,Col,preValue);
    	}
    }
/* 개발자 작업 끝 */
