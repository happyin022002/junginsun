/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0028.js
*@FileTitle  : Agent Commission Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
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
     * @class ESM_ACM_0028 : ESM_ACM_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var xmlStrOfc2;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var memoShtObj2=sheetObjects[1];
        var shtObj=sheetObjects[2];
        var frmObj=document.form;
//        try {
            var srcName=ComGetEvent("name");
            if (srcName != "btn2_vvd_cd") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
            }
            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal=new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;
                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_new":
                    ComResetAll();    //기본 object 초기화
                    memo_sheet1_OnChange(memoShtObj1);                    
                    memo_sheet2_OnChange(memoShtObj2);                    
                    memo_sheet1_OnLoadFinish(memoShtObj1)    // CoAcm.js에 정의
                    memo_sheet2_OnLoadFinish(memoShtObj2)    // CoAcm.js에 정의
    		        ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
    		        ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
    		        ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
    		        ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의

                    break;
                case "btn_calculate":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;
                case "btn_downexcel":
                    ComOpenWait(true);
//                    shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                    if(shtObj.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                   }else{
                	   //shtObj.Down2Excel({ HiddenColumn:true});
                	   shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                   }
                    ComOpenWait(false);
                    break;
                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;
                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;
                case "btn_forwarder":
                    var url="COM_ENS_041.do";
                    var width=775;
                    var height=484;
                    var func="setForwarder";
                    var display="1,0,1";
                    //comPopup(url, width, height, func, display, bModal, b2ndSheet);
                    ComOpenPopup(url, width, height, func, display, true, false);
                    break;
                case "ofc_option":
                    if (frmObj.ofc_option[0].checked) {
                        //ar_ofc_cd 목록을 조회
                        ACMXml2SelectItem(xmlStrOfc1, frmObj.ar_ofc_cd, "value0", "value0", false);
                    } else if (frmObj.ofc_option[1].checked) {
                        //Sales Office 목록을 조회
                        ACMXml2SelectItem(xmlStrOfc2, frmObj.ar_ofc_cd, "value0", "value0", false);
                    }
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
        memo_sheet1_OnLoadFinish(memo_sheet1);
        memo_sheet2_OnLoadFinish(memo_sheet2);        
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        sheet1_OnLoadFinish(sheet1)
        
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, SEARCH01);
        //최초 페이지 로드 시 [AR Office] 셋팅
//        document.form.ofc_option[0].fireEvent("onclick");
        ComFireEvent(document.form.ofc_option[0] , "click");
     }    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {
                case "memo_sheet1":
                    ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                    
                    document.form.pagerows.value=500;
                    var HeadTitle0="STS|CHK|Seq|Calc.\nSeq|Freight\nForwarder|Name|BKG No.|B/L No.|BKG\nSTS|VVD|ETD|B/L AMT|Cur|" +
                    "Freight Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|" +
                    "Container Status|Previous\nAmount|Comm.\nStatus|Remarks||||||||||";
                    var HeadTitle1="STS||Seq|Calc.\nSeq|Freight\nForwarder|Name|BKG No.|B/L No.|BKG\nSTS|VVD|ETD|B/L AMT|Cur|" +
                    "Commission|Box(CNT/AMT)|Box(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|" +
                    "Commission|Previous\nAmount|Comm.\nStatus|Remarks|||||||||";
                    (ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //SetGetEditEnterBehavior()("tab");

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                    { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                 {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fac_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ff_cnt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_dep_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bl_crnt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"crnt_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_bx_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fac_bx_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_dry_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fac_dry_teu_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_dry_feu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fac_dry_feu_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bkg_rf_teu_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fac_rf_teu_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bkg_rf_feu_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fac_rf_feu_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_crnt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ppd_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fac_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:570,  Align:"Left",    ColMerge:1,   SaveName:"fac_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fac_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ff_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ff_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fac_agmt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fac_div_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fac_div_cd_1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"old_crnt_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(465);
                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    break;

            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
    
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
//        var elementName=ComGetEvent("name");
//        var shtObj=sheetObjects[0];
//        var shtObj1=sheetObjects[1];
//        var formObj = document.form;
//        
//        switch (elementName) {
//        case "ar_ofc_cd":
//            if (formObj.ar_ofc_cd.value == "") {
//                ComClearCombo(formObj.agn_cd);
//                return;
//            }
//             var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + formObj.ar_ofc_cd.value);
//            if (ACMXml2SelectItem(xmlStr, formObj.agn_cd, "value0", "value0", false)) {
//                // option이 하나 이상이라면
//                if (formObj.agn_cd.options.length > 1) {
//                    // ar_ofc_cd와 같은 값이 선택되게 함
//                	formObj.agn_cd.value = formObj.ar_ofc_cd.value;
//                }
//                ComFireEvent(formObj.agn_cd , "change");
//            }
//            shtObj.RemoveAll();
//            shtObj1.RemoveAll();
//            break;
//
//        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                    ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", false);
                    xmlStrOfc1=xmlStr;    // *** 반드시 전역변수로 setting에 유의 ***
//                if (ACMDecideErrXml(shtObj, xmlStr)) {
//                    return;
//                } else {
//                    xmlStrOfc1=xmlStr;    // *** 반드시 전역변수로 setting에 유의 ***
//                }
                
                // 로그인한 사용자의 ofc_cd로 Sales Office 목록을 조회
                var xmlStr2=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH15);
//                ACMXml2SelectItem(xmlStr2, ar_ofc_cd, "value0", "value0", false);
                if (ACMDecideErrXml(shtObj, xmlStr2)) {
                    return;
                } else {
                    xmlStrOfc2=xmlStr2;    // *** 반드시 전역변수로 setting에 유의 ***
                }
                break;
            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0028GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01: // 재계산
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MODIFY ;
                //alert(FormQueryString(frmObj));
                shtObj.DoSave("ESM_ACM_0028GS.do", FormQueryString(frmObj),"chk",false);
                ComOpenWait(false);
            break;
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
    }
    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray=rowArray[0];
        document.form.ff_cnt_seq.value=colArray[3];
    }
    
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function memo_sheet2_OnChange(shtObj, Row, Col, Value) {
    	var myElement =document.getElementById(shtObj.id.toString() + "_change");
    	myElement.textContent = "Y";
    	var formObj=document.form; 
    	var val = "";
        for (var i=shtObj.HeaderRows(); i<=shtObj.LastRow(); i++) {
       	 if (shtObj.GetCellValue(i, 1) != "") {
       		 val = "Y"
       	 }
        }
        if (val == "Y") {
        	formObj.date_fm.className="input";
        	formObj.date_fm.removeAttribute("required");
        	formObj.date_to.className="input";
        	formObj.date_to.removeAttribute("required");
        }else{
        	formObj.date_fm.className="input1";
        	formObj.date_fm.setAttribute("required", "");
        	formObj.date_to.className="input1";
        	formObj.date_to.setAttribute("required", "");        	
        }
    }
    
/* 개발자 작업 끝 */
