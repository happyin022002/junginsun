/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0113.js
*@FileTitle  : Location Selection
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
     * @class ESM_ACM_0113 : ESM_ACM_0113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
//    function ESM_ACM_0113() {
//        this.processButtonClick=tprocessButtonClick;
//        this.setSheetObject=setSheetObject;
//        this.loadPage=loadPage;
//        this.initSheet=initSheet;
//        this.initControl=initControl;
//        this.doActionIBSheet=doActionIBSheet;
//        this.setTabObject=setTabObject;
//        this.validateForm=validateForm;
//    }
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var IBSEARCH02=30;
    var IBSEARCH03=31;
    var IBSEARCH04=32;
    var sheetFirstSearch=false;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var frmObj=document.form;
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_ok":        // Save
                    var shtChkRowArr=null;
                    var tmpArray=null;
                    var rArray=new Array();
                    rArray[0]="";
                    rArray[1]="";
                    rArray[2]="";
                    rArray[3]="";
                    rArray[4]="";
                    if (frmObj.route_div[0].checked) {
                        if (sheetObjects[0].CheckedRows("chk") < 1) {
                            ComShowCodeMessage("COM12113", "[Conti]");    // Please select {?msg1}
                            return;
                        }
                        rArray[0]=1;
                        shtChkRowArr=sheetObjects[0].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[0].GetCellValue(shtChkRowArr[i], "conti_cd");
                        }
                        rArray[1]=tmpArray.toString();
                    } else if (frmObj.route_div[1].checked) {
                        if (sheetObjects[1].CheckedRows("chk") < 1) {
                            ComShowCodeMessage("COM12113", "[Sub Conti]");    // Please select {?msg1}
                            return;
                        }
                        rArray[0]=2;
                        shtChkRowArr=sheetObjects[0].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[0].GetCellValue(shtChkRowArr[i], "conti_cd");
                        }
                        rArray[1]=tmpArray.toString();
                        shtChkRowArr=sheetObjects[1].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[1].GetCellValue(shtChkRowArr[i], "sconti_cd");
                        }
                        rArray[2]=tmpArray.toString();
                    } else if (frmObj.route_div[2].checked) {
                        if (sheetObjects[2].CheckedRows("chk") < 1) {
                            ComShowCodeMessage("COM12113", "[Country]");    // Please select {?msg1}
                            return;
                        }
                        rArray[0]=3;
                        shtChkRowArr=sheetObjects[0].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[0].GetCellValue(shtChkRowArr[i], "conti_cd");
                        }
                        rArray[1]=tmpArray.toString();
                        shtChkRowArr=sheetObjects[1].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[1].GetCellValue(shtChkRowArr[i], "sconti_cd");
                        }
                        rArray[2]=tmpArray.toString();
                        shtChkRowArr=sheetObjects[2].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[2].GetCellValue(shtChkRowArr[i], "cnt_cd");
                        }
                        rArray[3]=tmpArray.toString();
                    } else if (frmObj.route_div[3].checked) {
                        if (sheetObjects[3].CheckedRows("chk") < 1) {
                            ComShowCodeMessage("COM12113", "[Location]");    // Please select {?msg1}
                            return;
                        }
                        rArray[0]=4;
                        shtChkRowArr=sheetObjects[0].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[0].GetCellValue(shtChkRowArr[i], "conti_cd");
                        }
                        rArray[1]=tmpArray.toString();
                        shtChkRowArr=sheetObjects[1].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[1].GetCellValue(shtChkRowArr[i], "sconti_cd");
                        }
                        rArray[2]=tmpArray.toString();
                        shtChkRowArr=sheetObjects[2].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        	tmpArray[tmpArray.length]=sheetObjects[2].GetCellValue(shtChkRowArr[i], "cnt_cd");
                        }
                        rArray[3]=tmpArray.toString();
                        shtChkRowArr=sheetObjects[3].FindCheckedRow("chk").split("|");
                        tmpArray=new Array();
                        //for (var i=0; i<shtChkRowArr.length-1; i++) {
                        for (var i=0; i<shtChkRowArr.length; i++) {
                        		tmpArray[tmpArray.length]=sheetObjects[3].GetCellValue(shtChkRowArr[i], "loc_cd");
                        }
                        rArray[4]=tmpArray.toString();
                    }
                    var opener=window.dialogArguments;
                    var OpnerChr = "window.dialogArguments.";
                    if (!opener) OpnerChr="parent."; //이 코드 추가할것
                    //eval("window.dialogArguments." + sFunc + "(rArray, iRow, iCol, iSheetIdx)");    // JSP에서 request.getParameter로 받은 param
                    eval(OpnerChr + sFunc + "(rArray, iRow, iCol, iSheetIdx)");    // JSP에서 request.getParameter로 받은 param
                    ComClosePopup(); 
                    break;
                case "btn_close":    // close
                	ComClosePopup(); 
                    break;
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
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            document.form.pagerows.value=500;
            SetEditEnterBehavior("tab");

//            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
//
//            var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
//            var headers = [ ];
//            InitHeaders(headers, info);

//            var cols = [  ];
             
//            InitColumns(cols);

           
            switch (shtNo) {
                case 1:    // Conti
                    var cnt=0;
                    var HeadTitle="No.|STS|CHK|Code|Detail";
//                    (ComCountHeadTitle(HeadTitle), 0, 0, false);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                              {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"conti_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetCountPosition(0);
                    SetSheetHeight(150);
                    

                    break;
                case 2:    // Sub Conti
                    var cnt=0;
                    var HeadTitle="No.|STS|CHK|Code|Detail";
//                    (ComCountHeadTitle(HeadTitle), 0, 0, false);

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                              {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(108);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetCountPosition(0);

                    break;
                case 3:    // Country
                    var cnt=0;
                    var HeadTitle="No.|STS|CHK|Code|Detail";
//                    (ComCountHeadTitle(HeadTitle), 0, 0, false);

//                    SetConfig( { SearchMode:2, DataRowMerge:1 } );
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                        {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(300);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetCountPosition(0);

                    break;
                case 4:    // Location
	                    var cnt=0;
	                    var HeadTitle="No.|STS|CHK|Code|Detail";
	//                    (ComCountHeadTitle(HeadTitle), 0, 0, false);
	
//	                    SetConfig( { SearchMode:2, DataRowMerge:1 } );
	                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	                    var headers = [ { Text:HeadTitle, Align:"Center"}];
	                    InitHeaders(headers, info);
	
	                    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                           {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                           {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
	                     
	                    InitColumns(cols);
	                    SetEditable(1);
	                    SetWaitImageVisible(0);
	                    SetCountPosition(0);
	                    SetSheetHeight(300);
                    break;
            }
           
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                 shtObj.DoSearch("ESM_ACM_0113GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSEARCH02:
                ComOpenWait(true);
                frmObj.conti_cd.value=chkdArgs(sheetObjects[0], "chk", "conti_cd");
                frmObj.f_cmd.value=SEARCH02;
                 shtObj.DoSearch("ESM_ACM_0113GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSEARCH03:
                ComOpenWait(true);
                frmObj.sconti_cd.value=chkdArgs(sheetObjects[1], "chk", "sconti_cd");
                frmObj.f_cmd.value=SEARCH03;
                 shtObj.DoSearch("ESM_ACM_0113GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSEARCH04:
        		ComOpenWait(true);
                frmObj.cnt_cd.value=chkdArgs(sheetObjects[2], "chk", "cnt_cd");
                frmObj.f_cmd.value=SEARCH04;
                setTimeout(function(){
                	shtObj.DoSearch("ESM_ACM_0113GS.do", FormQueryString(frmObj), {Sync:2} );
                },100);                 
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
        var opener=window.dialogArguments;
        if (!opener) opener=parent; //이 코드 추가할것
        var routeLvlCd=opener.sheetObjects[iSheetIdx].GetCellValue(iRow, document.form.rout_ref_div_cd.value.toLowerCase() + "_lvl_cd");
        if (routeLvlCd == "") routeLvlCd="1";
        document.form.route_div[parseInt(routeLvlCd)-1].checked=true;
    }
 
    function routCd_SheetCheck(shtObj, level, colName) {
        var opener=window.dialogArguments;
        if (!opener) opener=parent; //이 코드 추가할것
    	var routVal=opener.sheetObjects[iSheetIdx].GetCellValue(iRow, document.form.rout_ref_div_cd.value.toLowerCase() + level);
        if (routVal != "") {
            var tmpArr=routVal.split(",");
            shtObj.ReDraw=false;
            for (var i=0; i<tmpArr.length; i++) {
                var findRowIdx=shtObj.FindText(colName, tmpArr[i]);
                if (findRowIdx > -1) {
                    shtObj.SetCellValue(findRowIdx, "chk","1",0);
                }
            }
            shtObj.ReDraw=true;
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        if (sheetFirstSearch) return;
        with (shtObj) {
            if (RowCount()> 0) {
                routCd_SheetCheck(shtObj, "_1", "conti_cd");
                if (shtObj.CheckedRows("chk") > 0) {
                    doActionIBSheet(sheetObjects[1], document.form, IBSEARCH02);
                } else {
                    sheetFirstSearch=true;
                }
            }
        }
    }
    

    /**
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet1_OnClick(shtObj, Row, Col, value) {
        with (shtObj) {        	
            switch (ColSaveName(Col)) {
                case "chk":                	
                    document.form.route_div[0].checked=true;
                    sheetObjects[3].ClearHeaderCheck();
                    sheetObjects[3].RemoveAll();
                    sheetObjects[2].ClearHeaderCheck();
                    sheetObjects[2].RemoveAll();
                    sheetObjects[1].ClearHeaderCheck();
                    doActionIBSheet(sheetObjects[1], document.form, IBSEARCH02);
                    break;
            }
        }
    }    

    function sheet1_OnCheckAllEnd(shtObj, Col, Value) {
        with (shtObj) {        	
            switch (ColSaveName(Col)) {
                case "chk":
                	document.form.route_div[0].checked=true;
                    sheetObjects[3].ClearHeaderCheck();
                    sheetObjects[3].RemoveAll();
                    sheetObjects[2].ClearHeaderCheck();
                    sheetObjects[2].RemoveAll();
                    sheetObjects[1].ClearHeaderCheck();
                    doActionIBSheet(sheetObjects[1], document.form, IBSEARCH02);                        
                    break;
            }
        }
    }    
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
//    function sheet1_OnChange(shtObj, Row, Col, Value) {
//        with (shtObj) {
//            switch (ColSaveName(Col)) {
//                case "chk":
//                    document.form.route_div[0].checked=true;
//                    sheetObjects[3].RemoveAll();
//                    sheetObjects[2].RemoveAll();
//                    doActionIBSheet(sheetObjects[1], document.form, IBSEARCH02);
//                    break;
//            }
//        }
//    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        if (sheetFirstSearch) return;
        with (shtObj) {
            if (RowCount()> 0) {
                routCd_SheetCheck(shtObj, "_2", "sconti_cd");
                if (shtObj.CheckedRows("chk") > 0) {
                    doActionIBSheet(sheetObjects[2], document.form, IBSEARCH03);
                } else {
                    sheetFirstSearch=true;
                }
            }
        }
    }
    
    
    /**
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet2_OnClick(shtObj, Row, Col, value) {
        with (shtObj) {        	
            switch (ColSaveName(Col)) {
                case "chk":                	
                	document.form.route_div[1].checked=true;
                    sheetObjects[3].ClearHeaderCheck();
                    sheetObjects[3].RemoveAll();
                    sheetObjects[2].ClearHeaderCheck();
                	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH03);
                    break;
            }
        }
    }    

    function sheet2_OnCheckAllEnd(shtObj, Col, Value) {
        with (shtObj) {        	
            switch (ColSaveName(Col)) {
                case "chk":
                	document.form.route_div[1].checked=true;
                    sheetObjects[3].ClearHeaderCheck();
                    sheetObjects[3].RemoveAll();
                    sheetObjects[2].ClearHeaderCheck();
                	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH03);
                    break;
            }
        }
    }    
    
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
//    function sheet2_OnChange(shtObj, Row, Col, Value) {
//        with (shtObj) {
//            switch (ColSaveName(Col)) {
//                case "chk":
//                    document.form.route_div[1].checked=true;
//                    sheetObjects[3].RemoveAll();
//                    doActionIBSheet(sheetObjects[2], document.form, IBSEARCH03);
//                    break;
//            }
//        }
//    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet3_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        if (sheetFirstSearch) return;
        with (shtObj) {
            if (RowCount()> 0) {
                routCd_SheetCheck(shtObj, "_3", "cnt_cd");
                if (shtObj.CheckedRows("chk") > 0) {
                    doActionIBSheet(sheetObjects[3], document.form, IBSEARCH04);
                } else {
                    sheetFirstSearch=true;
                }
            }
        }
    }
    

    /**
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet3_OnClick(shtObj, Row, Col, value) {
        with (shtObj) {        	
            switch (ColSaveName(Col)) {
                case "chk":
                	document.form.route_div[2].checked=true;
                	doActionIBSheet(sheetObjects[3], document.form, IBSEARCH04);
                    break;
            }
        }
    }    

    function sheet3_OnCheckAllEnd(shtObj, Col, Value) {
        with (shtObj) {        	
            switch (ColSaveName(Col)) {
                case "chk":
                	document.form.route_div[2].checked=true;
                	doActionIBSheet(sheetObjects[3], document.form, IBSEARCH04);
                    break;
            }
        }
    }    
    
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
//    function sheet3_OnChange(shtObj, Row, Col, Value) {
//        document.form.route_div[2].checked=true;
//        with (shtObj) {
//            switch (ColSaveName(Col)) {
//                case "chk":
//                    doActionIBSheet(sheetObjects[3], document.form, IBSEARCH04);
//                    break;
//            }
//        }
//    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet4_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        if (sheetFirstSearch) return;
        with (shtObj) {
            if (RowCount()> 0) {
                routCd_SheetCheck(shtObj, "_4", "loc_cd");
                sheetFirstSearch=true;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet4_OnChange(shtObj, Row, Col, Value) {
        document.form.route_div[3].checked=true;
    }
    /**
     * 조회파라미터 셋팅 conti_cd
     * @param {Object} shtObj
     * @param {Object} chkCol
     * @param {Object} valCol
     * @param {Object} isNum
     */
    function chkdArgs(shtObj, chkCol, valCol, isNum) {
        var rtn="";
        with (shtObj) {
            for (var i=0; i <= LastRow(); i ++) {
            	if ("1" == GetCellValue(i, chkCol))
            		rtn += (''!=rtn?', ':'') + (isNum?'':'\'') + GetCellValue(i, valCol) + (isNum?'':'\'');
            }
        }
        return rtn;
    }
/* 개발자 작업 끝 */
