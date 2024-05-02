/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_ACM_0015.js
*@FileTitle  : Other Commission Audit
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
     * @class ESM_ACM_0015 : ESM_ACM_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
    var searchFlg = false;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_calendar":
                if (!window.event.srcElement.disabled) {
                    var cal=new ComCalendarFromTo();
                    cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                }
                break;
            case "btn_inv_dt":
                var cal=new ComCalendar();
                cal.select(frmObj.inv_dt, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;
            case "btn_add":
                doActionIBSheet(shtObj, frmObj, IBINSERT);
                break;
            case "btn_delete":       // Row Delete
                doActionIBSheet(shtObj, frmObj, IBDELETE);
                break;
            case "btn_audit":
                var sRow=shtObj.CheckedRows("chk");
                if (sRow < 1) {
                    ComShowCodeMessage("COM12189");
                    return;
                }
                doActionIBSheet(shtObj, frmObj, MULTI);
                break;
            case "btn_reject":
                var sRow=shtObj.CheckedRows("chk");
                if (sRow < 1) {
                    ComShowCodeMessage("COM12189");
                    return;
                }
                doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                break;
            case "btn_audit_cancel":
                var sRow=shtObj.CheckedRows("chk");
                if (sRow < 1) {
                    ComShowCodeMessage("COM12189");
                    return;
                }
                doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
                break;
            case "btn_downexcel":
                doActionIBSheet(shtObj,frmObj,IBDOWNEXCEL);
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
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        document.form.ac_sts_cd.value = "RQ";
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
                    var HeadTitle="STS|CHK|No.|Acct.|Description|vdCnt|Office|Vendor|Name|City|Center|Apply Date|" +
                    "VVD|Cur|Payment Amount|Ex. Rate|USD Amount|Approval Date|Status|Remark|||||"

                    SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"DummyCheck", Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                                 {Type:"Seq",        Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                                 {Type:"Text",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"comm_stnd_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:0,  Width:200,  Align:"Left",  	 ColMerge:1,   SaveName:"otr_comm_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_cd" },
                                 {Type:"Popup",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Popup",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                                 {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ac_occr_info_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ap_ctr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"aply_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Combo",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pay_if_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pay_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"if_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",       Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"apro_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ac_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ac_proc_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:1,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"otr_comm_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agn_cd" },
                                 {Type:"Text",       Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",       Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"io_bnd_cd" },
                                 {Type:"Text",       Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ac_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty("curr_cd", {ComboText:"|"+currText, ComboCode:"|"+currCode} );
                    SetShowButtonImage(3);
                    SetEditEnterBehavior("tab");
                    SetSheetHeight(500);
                    break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
//        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "ac_sts_cd");
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate",   "frmObj_OnBeforeActivate", document.form);
        $('#ar_ofc_cd, #ac_sts_cd').on('change', function(){
        	frmObj_OnChange();
        });
//        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0015GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case MULTI:    		 // Audit
                //if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                
                var checkedRows = shtObj.FindCheckedRow("chk");
                var checkedRowIdx = checkedRows.split("|");                
                
                for(var i=0 ; i<checkedRowIdx.length ; i++){
                	if (shtObj.GetCellValue(checkedRowIdx[i], "ac_sts_cd") !="RS"){
                        ComShowCodeMessage("ACM00035","Requested");	//Please select {?msg1} bookings only!
                        ComOpenWait(false);
                        return;                		
                	}
                }
                
                frmObj.f_cmd.value=MULTI;
                var rArray=getCheckedRows(shtObj, "chk");
                
                frmObj.bkg_no_array.value=rArray;
                var bkgNoArray=new Array();
                var bkgNoArraySplit=frmObj.bkg_no_array.value.split(",");
                var queryVal="";
                for(j=0;j<bkgNoArraySplit.length; j++){
                    if(j < bkgNoArraySplit.length-1){
                        queryVal += bkgNoArraySplit[j]+"','";
                    }else{
                        queryVal += bkgNoArraySplit[j];
                    }
                }
                frmObj.bkg_no.value="'"+queryVal+"'";
                
                //Audit for the selected rows will be completed. Are you sure to proceed?
                if(ComShowConfirm(ComGetMsg("ACM00010"))){
                    var sParam=FormQueryString(frmObj);
                    var sXml=shtObj.GetSaveData("ESM_ACM_0015GS.do", "f_cmd=" + MULTI + "&ar_ofc_cd=" + frmObj.ar_ofc_cd.value+ "&bkg_no=" + frmObj.bkg_no.value);
                    shtObj.LoadSaveData(sXml);
                } else {
                	ComOpenWait(false);
                    return;
                }
                break;
            case IBDOWNEXCEL:		//Down Excel
            	if(shtObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            		}else{
            			//shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
            			shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
            		}
                break;
            case IBINSERT:       	// 신규 행추가
                shtObj.DataInsert();
                break;
            case IBDELETE:       	// 체크된 행삭제
                // RowStatus만 Delete로
                var chkRowArr=shtObj.FindCheckedRow("chk").split("|");
                if (chkRowArr.length > 1) {
                    shtObj.SetRowStatus(chkRowArr[0],"D");
                }
                break;
            case IBSEARCH_ASYNC01:    //Reject
                ComOpenWait(true);
                
                var checkedRows = shtObj.FindCheckedRow("chk");
                var checkedRowIdx = checkedRows.split("|");                
                
                for(var i=0 ; i<checkedRowIdx.length ; i++){
                	if (shtObj.GetCellValue(checkedRowIdx[i], "ac_sts_cd") !="RS"){
                        ComShowCodeMessage("ACM00035","Requested");	//Please select {?msg1} bookings only!
                        ComOpenWait(false);
                        return;                		
                	}
                }
                
                frmObj.doAction.value="Reject";
                frmObj.f_cmd.value=MULTI01;
                shtObj.DoSave("ESM_ACM_0015GS.do", FormQueryString(frmObj), "chk", false);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0015GS.do", FormQueryString(frmObj), {Sync:2} );
                break;
            case IBSEARCH_ASYNC02:    //Audit Cancel
                ComOpenWait(true);
                var lenPlus = searchFlg ? 1 : 0;
                //for(var i=1; i<=shtObj.LastRow() + lenPlus; i++) {
                
                var checkedRows = shtObj.FindCheckedRow("chk");
                var checkedRowIdx = checkedRows.split("|");                
                
                for(var i=0 ; i<checkedRowIdx.length ; i++){
                	if (shtObj.GetCellValue(checkedRowIdx[i], "ac_sts_cd") !="AS"){
                        ComShowCodeMessage("ACM00024","");	//Please select Audited bookings only!
                        ComOpenWait(false);
                        return;                		
                	}
                }
                
                frmObj.f_cmd.value=MULTI02;
                shtObj.DoSave("ESM_ACM_0015GS.do", FormQueryString(frmObj), "chk", false);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0015GS.do", FormQueryString(frmObj), {Sync:2} );
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
        document.form.comm_yrmon.value=ComGetNowInfo("ym");//최초 페이지 로드 시 현재 YYY-MM 셋팅
    }
    /***
     * Audit 후 재조회 이벤트
     */
    function sheet1_OnSaveEnd(sheetObj, code, errMsg) {
    	ComOpenWait(false);
    	if(code >= 0) {
    		var frmObj = document.form;
    		doActionIBSheet(sheetObj, frmObj, IBSEARCH);
    		var temp = frmObj.doAction.value;
    		if(temp =="Reject"){
    			frmObj.doAction.value = "";
    			ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    		}else{
//    			ComShowCodeMessage("ACM00011","");
    	        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
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
                case "ar_ofc_cd":
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} formObj
     * @param {Object} sAction
     */
    function validateForm(shtObj,fromObj,sAction){
        with(fromObj){
            switch(sAction) {
                case RDPRINT:	//Print
                    //if(if_option.value != "IF"){
                    //	ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
                    //	return false;
                    //}
                    var checkCnt=shtObj.CheckedRows("chk");
                    if(checkCnt < 1 || checkCnt > 1){
                        ComShowMessage(ComGetMsg("AGT10016", "", "", ""));
                        return false;
                    }
                    break;
            }
        }
        return true;
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
                case "ar_ofc_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 445, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
                case "vndr_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_0C1.do", 700, 423, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
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
                if (ColSaveName(Col) == "vndr_seq") {
                    SetCellValue(Row, Col,aryPopupData[0][2]);
                } else {
                    SetCellValue(Row, Col,aryPopupData[0][3],0);
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
        if (Value == "") return;
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "ar_ofc_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=Sub Office");
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
                    }
                    break;
                case "vndr_seq":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //Cellvalue2(Row, "vndr_lgl_eng_nm")="";
                    	SetCellValue(Row, Col, "", 0);
                        SelectCell(Row, Col, true, "");
                    } else {
                        SetCellValue(Row, "vndr_lgl_eng_nm",ComGetEtcData(xmlStr, "vndr_lgl_eng_nm"),0);
                        SetCellValue(Row, "vndr_cnt_cd",ComGetEtcData(xmlStr, "vndr_cnt_cd"),0);
                    }
                    break;
            }
        }
    }
    /**
     * 선택한 행의 정보를 Array에 담는다.
     * @param {Object} sheetObj
     * @param {Object} colName
     */
    function getCheckedRows(shtObj, colName) {
        var colsCnt=shtObj.LastCol()+ 1;
        //no support[check again]CLT var rows=shtObj.Rows;
        var rArray=null; //행데이터를 담고 있는 배열
       
        
        var checkRows=shtObj.CheckedRows(colName);
        var temp = shtObj.FindCheckedRow (colName);
        var checkedRowIdx = temp.split("|");

        var bkg_no;
        var bkg_no_tmp;
        var bkg_no_len=0;
        if(checkRows == 0){
            return null;
        }else{
            var idx=0;
            rArray=new Array(checkRows);
            //for(var i=0; i<rows; i++) {
            for(var i=0; i<checkedRowIdx.length; i++) {
                //if(shtObj.GetCellText(i,colName) == 1) {
                //if(shtObj.GetCellText(checkedRowIdx[i],colName) == "CHK") {
                    bkg_no="";
                    bkg_no_tmp="";
                    bkg_no_len=0;
                    bkg_no_tmp=shtObj.GetCellText(checkedRowIdx[i],"otr_comm_no");
                    bkg_no_len=bkg_no_tmp.length;
                    bkg_no=bkg_no_tmp;
                    rArray[idx++]=bkg_no + document.form.agn_cd.value + shtObj.GetCellText(checkedRowIdx[i],"io_bnd_cd") + shtObj.GetCellText(checkedRowIdx[i],"ac_seq");
               // }
            }
            
            return rArray;
        }
    }
/* 개발자 작업 끝 */
    
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	searchFlg = true;
    }
