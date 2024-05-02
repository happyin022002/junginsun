/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0029.js
*@FileTitle  : Special Compensation Audit
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
     * @class ESM_ACM_0029 : ESM_ACM_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var memoShtObj2=sheetObjects[1];
        var shtObj=sheetObjects[2];
        var frmObj=document.form;
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
                    ComResetAll();
                    memo_sheet1_OnChange(memoShtObj1);                    
                    memo_sheet2_OnChange(memoShtObj2);                    
                    memo_sheet1_OnLoadFinish(memoShtObj1)    // CoAcm.js에 정의
                    memo_sheet2_OnLoadFinish(memoShtObj2)    // CoAcm.js에 정의
    		        ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
    		        ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
    		        ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
    		        ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
                    break;
                case "btn_downexcel":
//                    ComOpenWait(true);
//                    shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
//                    ComOpenWait(false);
                    if(shtObj.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                   }else{
                       shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                   }

                    break;
                case "btn_save":
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;
                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;
                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;
                case "btn_popup":
                    //var cust_cd = "US"; // Default 셋팅
                    var url="COM_ENS_041.do";
                    var width=775;
                    var height=484;
                    var func="setForwarder";
                    var display="1,0,1,1,1,1,1,1,1,1,1,1";
                    ComOpenPopup(url, width, height, func, display, true, false);
                    break;
            } // end switch
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
    	var frmObj=document.form;
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        memo_sheet1_OnLoadFinish(sheetObjects[0]);
        memo_sheet2_OnLoadFinish(sheetObjects[1]);
        ACMMemoSheet_Open(sheetObjects[0]);    // CoAcm.js에 정의
        ACMMemoSheet_Open(sheetObjects[1]);    // CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[0], frmObj.vvd_cd);    // CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[1], frmObj.bl_no);    // CoAcm.js에 정의
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
                case "memo_sheet1":
                	ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "memo_sheet2":
                	ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                   
                    document.form.pagerows.value=500;
                    var HeadTitle0="STS|Pay|No.|CA\nSeq|Agreement\nCustomer|Vendor|Customer Name|BKG No.|B/L No.|BKG\nSTS|VVD|ETD|Calculation\nDate|" +
                    "Freight Status|Freight Status|Freight Status|Container Status|Container Status|Container Status|Container Status|" +
                    "Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Prev.\nAMT|Difference|Ex.\nRate|Cur|Local\nI/F AMT|Status|Remarks|||";
                    var HeadTitle1="STS|CHK|No.|CA\nSeq|Agreement\nCustomer|Vendor|Customer Name|BKG No.|B/L No.|BKG\nSTS|VVD|ETD|Calculation\nDate|" +
                    "Commissionable|Rate|Compensation|BOX(CNT/AMT)|BOX(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|" +
                    "RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|Compensation|Prev.\nAMT|Difference|Ex.\nRate|Cur|Local\nI/F AMT|Status|Remarks|||";
                    (ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    SetEditEnterBehavior("tab");

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                           {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_chk" },
                           {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cmpn_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_dep_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"act_comm_able",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"spcl_bkg_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"act_comm_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_bx_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"spcl_bx_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_teu_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"spcl_teu_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_feu_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"spcl_feu_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_rf_teu_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"spcl_rf_teu_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_rf_feu_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"spcl_rf_feu_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cntr_comm_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ppd_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_xch_rt",          KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:0,   InsertEdit:0 },

                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cmpn_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"spcl_cmpn_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"spcl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"spcl_agmt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(465);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    SetShowButtonImage(3);
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
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
//        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
//        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH16);
            	ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", false);
                break;
            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0029GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.DoSave("ESM_ACM_0029GS.do", FormQueryString(frmObj));
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
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function sheet1_OnSearchEnd(shtObj, ErrMsg) {
         if (ErrMsg != "") return;
         with (shtObj) {
             if (RowCount()> 0) {
                 ReDraw=false;
                 for (var i=HeaderRows(); i<=LastRow(); i++) {
                     // Status 가 'CS' 이외의 경우 Pay Check 편집 비활성화
                	 if (GetCellValue(i, "spcl_cmpn_sts_cd") != "CS") {
                         SetCellEditable(i, "pay_chk",0);
                     }
                 }
                 ReDraw=true;
             }
         }
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
                case "cust_cnt_cd_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        //Cellvalue2(Row, "cust_lgl_eng_nm")="";
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "cust_lgl_eng_nm")="";
                    	SetCellValue(Row, Col, "", 0);
                        SelectCell(Row, Col, true, "");
                    } else {
                        SetCellValue(Row, "cust_lgl_eng_nm",ComGetEtcData(xmlStr, "cust_lgl_eng_nm"),0);
                    }
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
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray=rowArray[0];
        document.form.spcl_cnt_cust_seq.value=colArray[3];
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
