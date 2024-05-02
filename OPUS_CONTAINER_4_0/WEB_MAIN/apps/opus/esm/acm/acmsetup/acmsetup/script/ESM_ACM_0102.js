/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0102.js
*@FileTitle  : Container TP/SZ Grouping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
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
     * @class ESM_ACM_0102 : ESM_ACM_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
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
//        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "grp_idv_div":
                    if (frmObj.grp_idv_div[0].checked) {
                        //ACMGetCellEditable(shtObj, "chk", "cntr_tpsz_cd", true);    // CoAcm.js에 정의
                    	ACMCellEditable(shtObj, "chk", "cntr_tpsz_cd", true);    // CoAcm.js에 정의
                        shtObj.SetDataBackColor(shtObj.GetEditableColor());
                        sheetObjects[1].DataBackColor=sheetObjects[1].UnEditableColor;
                        //ACMGetCellEditable(sheetObjects[1], "chk", "cntr_tpsz_desc", false);    // CoAcm.js에 정의
                        ACMCellEditable(sheetObjects[1], "chk", "cntr_tpsz_desc", false);    // CoAcm.js에 정의
                    } else {
                        //ACMGetCellEditable(sheetObjects[1], "chk", "cntr_tpsz_desc", true);    // CoAcm.js에 정의
                    	ACMCellEditable(sheetObjects[1], "chk", "cntr_tpsz_desc", true);    // CoAcm.js에 정의
                        sheetObjects[1].SetDataBackColor(sheetObjects[1].GetEditableColor());
                        shtObj.DataBackColor=shtObj.UnEditableColor;
                        //ACMGetCellEditable(shtObj, "chk", "cntr_tpsz_cd", false);    // CoAcm.js에 정의
                        ACMCellEditable(shtObj, "chk", "cntr_tpsz_cd", false);    // CoAcm.js에 정의
                    }
                    break;
                case "btn_clear":    // clear
                    ComResetAll();
                    document.form.slct_tpsz.value="";
                    doActionIBSheet(shtObj, document.form, IBSEARCH);
                    break;
                case "btn_select":    // select
                    var rArray=new Array();
                    if (frmObj.grp_idv_div[0].checked) {    // By Container Group
                        if (shtObj.CheckedRows("chk") < 1) {
                            ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
                            return;
                        }
                        var s1chkRowIdx=shtObj.FindCheckedRow("chk").split("|")[0];
                        rArray[0]=shtObj.GetCellValue(s1chkRowIdx, "cntr_tpsz_cd");
                    } else {    // By Individual TP/SZ
                        if (sheetObjects[1].CheckedRows("chk") < 1) {
                            ComShowCodeMessage("COM12113", "[Container TP/SZ Code]");    // Please select {?msg1}
                            return;
                        }
                        rArray[0]=document.form.slct_tpsz.value;
                    }
                    var opener=window.dialogArguments;
                    var OpnerChr = "window.dialogArguments.";
                    if (!opener) OpnerChr="parent."; //이 코드 추가할것
                    eval(OpnerChr + sFunc + "(rArray, iRow, iCol, iSheetIdx)");    // JSP에서 request.getParameter로 받은 param
                    ComClosePopup(); 
                    break;
                case "btn_close":    // close
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
            document.form.pagerows.value=500;
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            switch (shtNo) {
                case 1:    // User Set List
                    var cnt=0;
                    var HeadTitle="STS|CHK|Group Name|Detail";
                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"},];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetEditable(1);
                    SetEditEnterBehavior("tab");
                    SetWaitImageVisible(0);
                    SetEditableColorDiff(0);
                    SetSheetHeight(130);
                break;
                case 2:    // Container TP/SZ Code Selection
                    var cnt=0;
                    var HeadTitle="STS|CHK|Code|Description";
                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"},];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                           {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                           {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetEditable(1);
                    SetEditEnterBehavior("tab");
                    SetWaitImageVisible(0);
                    SetEditableColorDiff(0);
                    SetSheetHeight(135);
                break;
            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
            	var xmlStr=shtObj.GetSearchData("ESM_ACM_0102GS.do", "f_cmd=" + SEARCH).split("|$$|");
                // User Set List
                sheetObjects[0].LoadSearchData(xmlStr[0],{Sync:1} );
                // Container TP/SZ Code
                sheetObjects[1].LoadSearchData(xmlStr[1],{Sync:1} );
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     */
    function sheet2_OnSearchEnd(shtObj) {
        document.form.grp_idv_div[0].checked=true;
        var appname = window.navigator.appName;
        //document.form.grp_idv_div[0].fireEvent("onclick")
        ComFireEvent(document.form.grp_idv_div[0], "click");
//        $("[name='grp_idv_div']").click();
        var slctTpSz=document.form.slct_tpsz.value;
        if (slctTpSz != "") {
            // Container TP/SZ Code 선택
            // sheet2_OnChang나 sheet3_OnChang와는 반대 기능임
            var tmpArr=slctTpSz.split(",");
            shtObj.ReDraw=false;
            shtObj.CheckAll("chk",0);
            for (var i=0; i<tmpArr.length; i++) {
                var findRowIdx=shtObj.FindText("cntr_tpsz_cd", tmpArr[i]);
                if (findRowIdx > -1) {
                    shtObj.SetCellValue(findRowIdx, "chk",1,0);
                }
            }
            shtObj.ReDraw=true;
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet2_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {  
            switch (ColSaveName(Col)) {
                case "chk":
                    var chkRowArr=shtObj.FindCheckedRow("chk").split("|");
                    var slctTpSz=document.form.slct_tpsz;
                    if (chkRowArr.length > 0) {
                        // 선택된 row의 Container TP/SZ Code를 textarea에 setting
                        var tempArray=new Array();
                        //for (var i=0; i<chkRowArr.length-1; i++) {
                        for (var i=0; i<chkRowArr.length; i++) {
                        	if(chkRowArr[i] != 0) {
                        		tempArray[tempArray.length]=shtObj.GetCellValue(chkRowArr[i], "cntr_tpsz_cd");
                        	}
                        }
                        slctTpSz.value=tempArray.toString();
                    } else {
                        slctTpSz.value="";
                    }
                    break;
            }
        }
    }
/* 개발자 작업 끝 */
