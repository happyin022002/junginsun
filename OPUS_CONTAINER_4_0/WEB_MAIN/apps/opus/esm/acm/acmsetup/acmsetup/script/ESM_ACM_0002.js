/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0002.js
*@FileTitle  : Container TP/SZ Grouping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
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
     * @class ESM_ACM_0002 : ESM_ACM_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
            	case "btn_retreive":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;
                case "btn_delete":       // Row Delete
                    // RowStatus만 Delete로
                    var chkRowArr=shtObj.FindCheckedRow("chk").split("|");
                    if (chkRowArr.length >= 1) {
                        shtObj.SetRowStatus(chkRowArr[0],"D");
                        shtObj.RowDelete(parseInt(chkRowArr[1]));
                    }
                    break;
                case "btn_add":           // Row Add
                    // 신규 행추가는 한 row만 가능
                	var slctTpSz=document.form.slct_tpsz;
                    if (shtObj.RowCount("I") > 0) return;
                    // 신규 행추가와 동시에 CHK에 체크
                    shtObj.SetCellValue(shtObj.DataInsert(), "chk",1,0);
                    // Container TP/SZ Code uncheck all
                    sheetObjects[1].CheckAll("chk",0);
                    slctTpSz.value="";
                    sheetObjects[1].CheckAll("chk",0);
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
            switch (shtNo) {
                case 1:    // User Set List
                    var cnt=0;
                    var HeadTitle="STS|CHK|Group Name|Detail test|org_tpsz_grp_nm";

                    SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Radio",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_grp_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                        {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"org_cntr_tpsz_grp_nm" } ];
                     
                    InitColumns(cols);
                    SetEditEnterBehavior("tab");
                    SetWaitImageVisible(0);
                    SetSheetHeight(135);
                    SetColProperty(0 ,"cntr_tpsz_grp_nm" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                    break;
                case 2:
                    var cnt=0;
                    var HeadTitle="STS|CHK|Code|Description";

                    SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:0 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetEditEnterBehavior("tab");
                    SetWaitImageVisible(0);
                    SetSheetHeight(250);
                	break;
            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
                ComOpenWait(true);
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0002GS.do", "f_cmd=" + SEARCH).split("|$$|");
                // User Set List
                sheetObjects[0].LoadSearchData(xmlStr[0],{Sync:1} );
                // Container TP/SZ Code
                sheetObjects[1].LoadSearchData(xmlStr[1],{Sync:1} );
                ComOpenWait(false);
                break;
            case IBSAVE:         // 저장
                if (shtObj.RowCount()< 1) {
                    ComShowCodeMessage("COM130201", "[User Set List]");    // Please input {?msg1}.
                    return;
                } else if (shtObj.CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
                    return;
                } else if (shtObj.GetSaveString() == "") {    // sheet mandatory check 용도
                    return;
                } else if (sheetObjects[1].CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[Container TP/SZ Code]");    // Please select {?msg1}
                    return;
                }
                ComOpenWait(true);
                var sParam0=ComSetPrifix(shtObj.GetSaveString(false, false, "chk"), "UsrSet_");
                var sParam1=ComSetPrifix(sheetObjects[1].GetSaveString(false, false, "chk"), "TpszCd_");
                shtObj.LoadSaveData(shtObj.GetSaveData("ESM_ACM_0002GS.do", "f_cmd=" + MULTI + "&" + sParam0 + "&" + sParam1));
                ComOpenWait(false);
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
                	if (GetRowStatus(Row) == "I" || GetRowStatus(Row) == "D") return;
                    // Container TP/SZ Code 선택(sheet2_OnChang와는 반대 기능임)
                    var cntrTpszCd=GetCellValue(Row, "cntr_tpsz_cd");
                    if (cntrTpszCd == null || cntrTpszCd == undefined) cntrTpszCd="";
                    var tmpArr=cntrTpszCd.split(",");
                    var shtObj2=sheetObjects[1];
                    shtObj2.ReDraw=false;
                    shtObj2.CheckAll("chk",0);
                    for (var i=0; i< tmpArr.length; i++) {
                        var findRowIdx=shtObj2.FindText("cntr_tpsz_cd", tmpArr[i]);
                        if (findRowIdx > -1) {
                            shtObj2.SetCellValue(findRowIdx, "chk",1,0);
                        }
                    }
                    shtObj2.ReDraw=true;
                    document.form.slct_tpsz.value=GetCellValue(Row, "cntr_tpsz_cd");
                    ACMRadioChkAction(shtObj, Row);    // CoAcm.js에 정의
                    break;
                case "cntr_tpsz_grp_nm":
                    if (ComTrim(Value) == CellSearchValue(Row, Col)) {
                        SetCellValue(Row, Col,ComTrim(Value),0);
                        return;
                    }
                    // Duplication check
                    var xmlStr=GetSearchData("ESM_ACM_0002GS.do", "f_cmd=" + SEARCH01 + "&cntr_tpsz_grp_nm=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
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
        ComResetAll();
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
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
                var chkRowArr=shtObj.FindCheckedRow(Col).split("|");
                var slctTpSz=document.form.slct_tpsz;
                if (chkRowArr.length >= 1) {
                    // 선택된 row의 rep_chg_cd를 textarea에 setting
                    var tempArray=new Array();
                    for (var i=0; i<= chkRowArr.length-1; i++) {
                    	if(shtObj.GetCellValue(chkRowArr[i], "cntr_tpsz_cd")== -1){
                    		tempArray[tempArray.length]="";
                    	}else{
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
