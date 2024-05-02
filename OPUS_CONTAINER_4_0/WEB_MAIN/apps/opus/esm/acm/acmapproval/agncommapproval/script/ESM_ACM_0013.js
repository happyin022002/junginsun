/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0013.js
*@FileTitle  : Returned CSR Reprocess
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
     * @class ESM_ACM_0013 : ESM_ACM_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
                case "btn_calendar":
                	var objEvnt = ComGetEvent();
                    if (!objEvnt.disabled) {
                        var cal=new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;
                case "btn_retrieve":
                	sheetObjects[1].RemoveAll();
                	sheetObjects[2].RemoveAll();
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_confirm":
					if(shtObj.CheckedRows("chk") < 1){
						//Please select **.
						ComShowCodeMessage("COM12113", "row");
						return;
					}
                	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;
                case "btn_cancel":
                	if(shtObj.CheckedRows("chk") < 1){
                		//Please select **.
                		ComShowCodeMessage("COM12113", "row");
                		return;
                	}
                	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
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
            case 1:    // CSR Main
                var cnt=0;
                var HeadTitle="STS|CHK|Returned CSR No.|Total BKG No.";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Radio",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                             {Type:"Text",      Hidden:0,  Width:240,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                             {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"bkg_cnt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetEditableColorDiff(0);
                SetSheetHeight(150);
                SetSheetWidth(500);
                break;


            case 2:    // CSR Detail
                var cnt=0;
                var HeadTitle="|SEQ|Audit No.|Agent|VVD Count|Cur|Net\nAMT(USD)|VAT|TTL\nAMT(USD)|Approval Date";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"aud_no" },
                             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agn_cd" },
                             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_cnt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0 },
                             {Type:"Text",   	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
                             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"net_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
                             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vat",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
                             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tot_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
                             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_dt" } ];
                 
                InitColumns(cols);
                SetEditable(0);
                SetSheetHeight(150);
                break;
            case 3:    // Reprocessed Audit No. Detail
                var cnt=0;
                var HeadTitle="|Audit No.|Agent|VVD Count|Cur|Total Net Amount(USD)";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2, DataRowMerge:0 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",   Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"aud_no" },
                             {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"agn_cd" },
                             {Type:"Int",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"vvd_cnt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0 },
                             {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
                             {Type:"Int",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"net_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(0);
                SetSheetHeight(150);
                break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        //axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:       // 조회 (Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0013GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case SEARCH02:       // 조회 (Detail)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH02;
                shtObj.DoSearch("ESM_ACM_0013GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01:      	// Reprocess to Audit Confirm
				if (!ComChkValid(frmObj)) return;
	            ComOpenWait(true);
	            var saveParam="f_cmd=" + MULTI01 + "&ar_ofc_cd=" + frmObj.ar_ofc_cd.value + "&agn_cd=" + frmObj.agn_cd.value 
	            		+ "&" + shtObj.GetSaveString(false, true, "chk");
	            var xmlStr=shtObj.GetSaveData("ESM_ACM_0013GS.do", saveParam);
	            if (ACMDecideErrXml(shtObj, xmlStr)) return;
	            sheetObjects[2].LoadSaveData(xmlStr);
	            ComOpenWait(false);
				break;
            case IBSEARCH_ASYNC02:      	// CSR Cancel
            	if (!ComChkValid(frmObj)) return;
            	ComOpenWait(true);
            	frmObj.f_cmd.value=MULTI02;
            	shtObj.DoSave("ESM_ACM_0013GS.do", FormQueryString(frmObj), "chk", false);
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
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                	document.form.csr_no_master.value=GetCellValue(Row, "csr_no");
                    doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
                    break;
            }
        }
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
                ReDraw=false;
                SetCellText(LastRow(), "seq" ,"");
                SetCellText(LastRow(), "aud_no" ,"TOTAL");
                SetCellAlign(LastRow(), "aud_no","Right");
                ReDraw=true;
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet3_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        // 저장 후 재조회
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        sheetObjects[1].RemoveAll();
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
/* 개발자 작업 끝 */
