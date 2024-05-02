/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_ACM_0014.js
*@FileTitle  : Other Commission Request
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
     * @class ESM_ACM_0014 : ESM_ACM_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
                case "btn_retrieve":      // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_save":          // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;
                case "btn_request":       // Request
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC03);
                    break;
                case "btn_downexcel":     // Down Excel
                    ComOpenWait(true);
                    if(shtObj.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                    	}else{
                    		//shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                    		shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                    	}
                    ComOpenWait(false);
                    break;
                case "btn_add":           // Row Add
                    doActionIBSheet(shtObj, frmObj, IBINSERT);
                    break;
                case "btn_delete":        // Row Delete
                    var chkRowArr=shtObj.FindCheckedRow("chk").split("|");
                    if (chkRowArr == "") {
                        //체크 안하면 리턴
                        ComShowCodeMessage("ACM00031","");	//Please check rows to request.
                        ComOpenWait(false);
                        return;
                    }
                    if (chkRowArr.length > 0) {
                        for(var i=chkRowArr.length-1; i>=0; i--) {
                            // RowStatus만 Delete로
                            shtObj.SetRowStatus(chkRowArr[i],"D");
                        }
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
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
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
                    var HeadTitle="STS||No.|Acct.|Description|vdCnt|Office|Vendor|Name|City|Center|Apply\nDate|VVD|Cur|Payment\nAmount|Ex. Rate|USD\nAmount|Approval\nDate|Status|Remarks||||||";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                              {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                              {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"comm_stnd_cost_cd" , KeyField:1},
                              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"otr_comm_rmk" },
                              {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_cd" },
                              {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd" },
                              {Type:"PopupEdit", Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" },
                              {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ac_occr_info_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ap_ctr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"aply_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",			      KeyField:1,   EditLen:10, 	AcceptKeys:"E|N", 	  InputCaseSensitive:1 },
                              {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd"},
                              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                              {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"usd_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ac_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"ac_proc_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"hid_comm_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"otr_comm_no" },
                              {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ar_ofc_cd" },
                              {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"io_bnd_cd" },
                              {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ac_tp_cd" },
                              {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ac_seq" } ];
                     
                    InitColumns(cols);

                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty("curr_cd", {ComboText:"|"+currText, ComboCode:"|"+currCode} );
                    SetShowButtonImage(3);
                    SetEditEnterBehavior("tab");
                    SetSheetHeight(485);
                    break;
            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:       		// Retrieve
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0014GS.do", FormQueryString(frmObj), {Sync:2} );
                frmObj.hid_add_row.value="0";
                ComOpenWait(false);
                break;
            case IBSAVE:         		// Save
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.DoSave("ESM_ACM_0014GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC03:    	//Request
                ComOpenWait(true);
                var sRow=shtObj.FindCheckedRow("chk").split("|");
                if (sRow == "") {
                    //체크 안하면 리턴
                    ComShowCodeMessage("ACM00014","");	//Please check rows to request.
                    ComOpenWait(false);
                    return;
                } else {
                    //for (var i=0; i<sRow.length-1; i++) {
                    for (var i=0; i<sRow.length; i++) {
                        // Center 정보가 없을 때
                    	if (shtObj.GetCellValue(sRow[i], "ap_ctr_cd") == "") {
                            ComShowCodeMessage("ACM00029");
                            ComOpenWait(false);
                            return;
                        }
                    }
                }
                for(var i=1; i<=shtObj.LastRow(); i++) {
                	if (shtObj.GetCellValue(i, "ibflag") == "I") {
                        ComShowCodeMessage("ACM00015","");	//Please save data first.
                        ComOpenWait(false);
                        return;
                    }
                }
                frmObj.f_cmd.value=MODIFY;
                shtObj.DoSave("ESM_ACM_0014GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
            case IBINSERT:       // 신규 행추가
                if (!ComChkValid(frmObj)) return;
                var insRow=shtObj.DataInsert(-1);
                //Office정보 및 Vendor정보 조회
                frmObj.f_cmd.value='116';
                frmObj.ofc_cd.value=frmObj.agn_cd.value;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + '116' + "&ofc_cd=" + frmObj.agn_cd.value);
                ComEtcDataToForm(frmObj, shtObj, "frm_");	//조회된 ETC데이터를 Form의 Hidden오브젝트에 담는다.
                frmObj.hid_vndr_seq.value=ComGetEtcData(xmlStr, "vndr_seq");		//사용자가 선택한 Sub Office기준의 vndr_seq
                frmObj.hid_ac_occr_info_cd.value=ComGetEtcData(xmlStr, "ac_occr_info_cd");	//사용자가 선택한 Sub Office기준의 ac_occr_info_cd
                frmObj.hid_ap_ctr_cd.value=ComGetEtcData(xmlStr, "ap_ctr_cd");		//사용자가 선택한 Sub Office기준의 ap_ctr_cd
                frmObj.hid_curr_cd.value=ComGetEtcData(xmlStr, "curr_cd");			//사용자가 선택한 Sub Office기준의 curr_cd
                shtObj.SetCellValue(insRow, "hid_comm_yrmon",frmObj.comm_yrmon.value,0);
                var yyyymm=ComTrimAll(frmObj.comm_yrmon.value,'-');
                IBS_CopyFormToRow(frmObj, shtObj, insRow, "frm_");
                shtObj.SetCellValue(insRow, "agn_cd",frmObj.agn_cd.value,0);//로그온 사용자의 ofc_cd가 아닌 사용자가 선택한 Sub Office
//                shtObj.CellValue2(insRow, "ar_ofc_cd") = frmObj.ar_ofc_cd.value;
                shtObj.SetCellValue(insRow, "ar_ofc_cd",ComGetEtcData(xmlStr, "ar_ofc_cd"),0);//화면의 ar_ofc_cd가 아닌 DB에서 가지고 온 값을 설정
                // pay_xch_rt를 설정
                frmObj.f_cmd.value=SEARCH17;
                var row=shtObj.GetSelectRow();
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH17 + "&aply_dt=" + frmObj.comm_yrmon.value + "&curr_cd=" + frmObj.hid_curr_cd.value);
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                shtObj.SetCellValue(row, "pay_xch_rt",ComGetEtcData(xmlStr,"pay_xch_rt"),0);
                // aply_dt를 설정
                shtObj.SetCellValue(insRow, "aply_dt",frmObj.to_date.value,0);
                //사용자가 선택한 Sub Office기준의 vndr_seq의 VendorName
                if (frmObj.hid_vndr_seq.value != "undefined") {
                    shtObj.SetCellValue(insRow, "vndr_seq",frmObj.hid_vndr_seq.value,0);
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + frmObj.hid_vndr_seq.value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        //shtObj.Cellvalue2(insRow, "vndr_lgl_eng_nm")="";
                        shtObj.SetCellValue(insRow, "vndr_lgl_eng_nm", "", 0);
                        shtObj.SelectCell(insRow, "vndr_lgl_eng_nm", true, "");
                    } else {
                        shtObj.SetCellValue(insRow, "vndr_lgl_eng_nm",ComGetEtcData(xmlStr, "vndr_lgl_eng_nm"),0);
                        shtObj.SetCellValue(insRow, "vndr_cnt_cd",ComGetEtcData(xmlStr, "vndr_cnt_cd"),0);
                    }
                }
                //사용자가 선택한 Sub Office기준의 ap_ctr_cd
                if (frmObj.hid_ac_occr_info_cd.value != "undefined") {
                    shtObj.SetCellValue(insRow, "ap_ctr_cd",frmObj.hid_ap_ctr_cd.value,0);
                }
                //사용자가 선택한 Sub Office기준의 ac_occr_info_cd
                if (frmObj.hid_ac_occr_info_cd.value != "undefined") {
                    shtObj.SetCellValue(insRow, "ac_occr_info_cd",frmObj.hid_ac_occr_info_cd.value,0);
                }
                //사용자가 선택한 Sub Office기준의 curr_cd
                if (frmObj.hid_vndr_seq.value != "undefined") {
                    shtObj.SetCellValue(insRow, "curr_cd",frmObj.hid_curr_cd.value,0);
                }
                frmObj.hid_add_row.value="1";
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH20
				+ "&agn_cd=" + frmObj.agn_cd.value 
				+ "&aply_dt=" + frmObj.to_date.value
				+ "&curr_cd=" + frmObj.hid_curr_cd.value);
				if (ComGetEtcData(xmlStr, "pay_xch_rt") != "0") {
					shtObj.SetCellValue(insRow, "pay_xch_rt",ComGetEtcData(xmlStr, "pay_xch_rt"),0);
				}
                break;
            case SEARCH16:       // 최초 조회 시 Office정보 및 Vendor정보 조회
                frmObj.f_cmd.value=SEARCH16;
                shtObj.DoSearch("ESM_ACM_0014GS.do", FormQueryString(frmObj), {Sync:2} );
                ComEtcDataToForm(frmObj, shtObj, "frm_");	//조회된 ETC데이터를 Form의 Hidden오브젝트에 담는다.
                shtObj.RemoveAll();
                break;
            case SEARCH18:       // Cur 변경시 , PatmentAmt, UsdAmt, EX.Rate 를 재설정 한다.
                var row=shtObj.GetSelectRow();
                var xmlStr1=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH17+ "&aply_dt=" + shtObj.GetCellValue(row, "aply_dt") + "&curr_cd=" + shtObj.GetCellValue(row, "curr_cd"));
				if (ComGetEtcData(xmlStr1,"pay_xch_rt") == undefined || ComGetEtcData(xmlStr1,"pay_xch_rt") == '') {
					ComShowCodeMessage("ACM00027","");	//No ex. rate exits. Please update exchange rate.
					return;
				}
				var xmlStr2=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH18 + "&aply_dt=" + shtObj.GetCellValue(row, "aply_dt") + "&curr_cd=" + shtObj.GetCellValue(row, "curr_cd") + "&pay_if_amt=" + shtObj.GetCellValue(row, "pay_if_amt"));
//				var xmlStr2=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH18 + "&" + shtObj.RowSaveStr(row));
                if (ACMDecideErrXml(shtObj, xmlStr2)) return;
                shtObj.SetCellValue(row, "pay_if_amt",ComGetEtcData(xmlStr2,"pay_if_amt"),0);
                shtObj.SetCellValue(row, "usd_amt",ComGetEtcData(xmlStr2,"usd_amt"),0);
                shtObj.SetCellValue(row, "pay_xch_rt",ComGetEtcData(xmlStr2,"pay_xch_rt"),0);
				if (ComGetEtcData(xmlStr2,"pay_xch_rt") == undefined) {
					ComShowCodeMessage("ACM00027","");	//No ex. rate exits. Please update exchange rate.
					return;
				}
				frmObj.hid_pay_xch_rt.value=ComGetEtcData(xmlStr2,"pay_xch_rt");
				var xmlStr3=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH20
				+ "&agn_cd=" + frmObj.agn_cd.value
				+ "&aply_dt=" + frmObj.to_date.value+ "&curr_cd=" + shtObj.GetCellValue(row, "curr_cd"));
				//위 SQL결과가 0 이 아닐때만 아래 쿼리 실행 하여 쉬트에 반영.
				if (ComGetEtcData(xmlStr3, "pay_xch_rt") != "0") {
					var xmlStr4=shtObj.GetSearchData("ESM_ACM_0014GS.do", "f_cmd=" + SEARCH19+ "&pay_if_amt=" + shtObj.GetCellValue(row, "pay_if_amt")
					+ "&agn_cd=" + frmObj.agn_cd.value
					+ "&aply_dt=" + frmObj.to_date.value+ "&curr_cd=" + shtObj.GetCellValue(row, "curr_cd"));
                shtObj.SetCellValue(row, "pay_if_amt",ComGetEtcData(xmlStr4,"pay_if_amt"),0);
                shtObj.SetCellValue(row, "usd_amt",ComGetEtcData(xmlStr4,"usd_amt"),0);
                shtObj.SetCellValue(row, "pay_xch_rt",ComGetEtcData(xmlStr4,"pay_xch_rt"),0);
				}
                break;
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
//        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 RHQ Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
        // Sheet내 Combo생성
        var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH12);
        if (ACMDecideErrXml(shtObj, xmlStr)) return;
        var comboStr=ComXml2ComboString(xmlStr, "value0", "value1");
        var codeStrTemp=comboStr[0].split('|'); // Acconut 코드
        var nameStrTemp=comboStr[1].split('|'); // Account 이름
        var fullStrTemp=codeStrTemp[0]+ '\t' +nameStrTemp[0];  // 코드 + 이름
        for(var i=1; i<codeStrTemp.length; i++){
            fullStrTemp=fullStrTemp +'|'+ codeStrTemp[i] + '\t' + nameStrTemp[i] ;
        }
        shtObj.SetColProperty("comm_stnd_cost_cd", {ComboText:fullStrTemp, ComboCode: comboStr[0]} );
        
        // 최초 조회 시 Office정보 및 Vendor정보 조회
//        doActionIBSheet(shtObj, document.form, SEARCH16);
        document.form.comm_yrmon.value=ComGetNowInfo("ym");
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
                case "agn_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 515, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
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
        if (Value == "") {
            with (shtObj) {
                switch (ColSaveName(Col)) {
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
                case "agn_cd":
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
                    	SetCellValue(Row, "vndr_lgl_eng_nm", "", 0);
                    	SetCellValue(Row, Col, "", 0);
                        SelectCell(Row, Col, true, "");
                    } else {
                        SetCellValue(Row, "vndr_lgl_eng_nm",ComGetEtcData(xmlStr, "vndr_lgl_eng_nm"),0);
                        SetCellValue(Row, "vndr_cnt_cd",ComGetEtcData(xmlStr, "vndr_cnt_cd"),0);
                    }
                    break;
                case "pay_if_amt":		//USD AMT 변경시, PAYMENT AMT를 재계산한다.
                	shtObj.SetCellValue(Row, "usd_amt",shtObj.GetCellValue(Row, "pay_if_amt") / shtObj.GetCellValue(Row, "pay_xch_rt"),0);
                    break;
                case "curr_cd":			//Cur 변경시 , xchRt를 재설정 한다.
                    doActionIBSheet(shtObj, document.form, SEARCH18);
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
    	ComOpenWait(false);
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
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
