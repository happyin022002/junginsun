/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0022.js
*@FileTitle  : Customer-Vendor Match for Special Compensation
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
     * @class ESM_ACM_0022 : ESM_ACM_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ESM_ACM_0022() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_retrive":     // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;
                case "btn_downexcel":    // Down Excel
                	if(shtObj.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                   }else{
                	   //shtObj.Down2Excel({ HiddenColumn:true});
                	   shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                   }
                    break;
                case "btn_cust_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_041.do", 775, 465, "setPopupData_custCntSeq", "1,0,1,1,1,1,1", true);
                    break;
                case "btn_add":           // Row Add
                    shtObj.DataInsert();
                    break;
            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     */
    function setPopupData_custCntSeq(aryPopupData) {
        if (aryPopupData.length > 0 ) {
            document.form.cust_cnt_seq.value=aryPopupData[0][3];
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
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var cnt=0;
        with(shtObj){
            
         document.form.pagerows.value=500;
         var HeadTitle="DEL|STS|SEQ|AGMT Customer|Customer Name|Vendor Code|Vendor Name" +
         "|vndr_cnt_cd|cust_cnt_cd|org_cust_seq|org_vndr_cnt_cd|org_vndr_seq";
         (ComCountHeadTitle(HeadTitle), 0, 0, false);
         //SetGetEditEnterBehavior()("tab");

         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

         var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
         var headers = [ { Text:HeadTitle, Align:"Center"} ];
         InitHeaders(headers, info);

         var cols = [ {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
             {Type:"Status",    Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cnt_cd" },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_cust_seq" },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_vndr_cnt_cd" },
             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_vndr_seq" } ];
          
         InitColumns(cols);
         SetSheetHeight(485);
         SetEditable(1);
         SetWaitImageVisible(0);
         SetShowButtonImage(3);
         SetColProperty("cust_cnt_seq", {AcceptKeys:"E|N", InputCaseSensitive:1}); 
         }


    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0022GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSAVE:         // 저장
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.DoSave("ESM_ACM_0022GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
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
                case "cust_cnt_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_041.do", 775, 465, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
                case "vndr_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_0C1.do", 700, 515, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
            }
        }
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                if (ColSaveName(Col) == "cust_cnt_seq") {
                    SetCellValue(Row, Col,aryPopupData[0][3]);
                } else if (ColSaveName(Col) == "vndr_seq") {
                    SetCellValue(Row, Col,aryPopupData[0][2]);
                }
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
        if (Value == "") {
            with (shtObj) {
                switch (ColSaveName(Col)) {
                case "cust_cnt_seq":
                	SetCellValue(Row, "cust_lgl_eng_nm", "", 0);
                	return;
                	break;
                case "vndr_seq":
                	SetCellValue(Row, "vndr_lgl_eng_nm", "", 0);
                	return;
                	break;
                	default:
                		return;
                }
            }
        }     	
    	
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "cust_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        //Cellvalue2(Row, "cust_lgl_eng_nm")="";
                    	SetCellValue(Row, "cust_lgl_eng_nm", "", 0);
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "cust_lgl_eng_nm")="";
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    } else {
                        SetCellValue(Row, "cust_lgl_eng_nm",ComGetEtcData(xmlStr, "cust_lgl_eng_nm"),0);
                    }
                    break;
                case "vndr_seq":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "vndr_lgl_eng_nm")="";
                    	SetCellValue(Row, "vndr_lgl_eng_nm", "", 0);
                    	SetCellValue(Row, Col, "", 0);
                    	setTimeout(function(){
                            SelectCell(Row, Col, true, "");
                        	},10);     
                    } else {
                        SetCellValue(Row, "vndr_lgl_eng_nm",ComGetEtcData(xmlStr, "vndr_lgl_eng_nm"),0);
                        SetCellValue(Row, "vndr_cnt_cd",ComGetEtcData(xmlStr, "vndr_cnt_cd"),0);
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
/* 개발자 작업 끝 */
