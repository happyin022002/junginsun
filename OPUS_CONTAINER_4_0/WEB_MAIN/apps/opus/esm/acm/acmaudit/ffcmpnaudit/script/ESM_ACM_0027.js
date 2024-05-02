/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0027.js
*@FileTitle  : FF Compensation Audit
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
     * @class ESM_ACM_0027 : ESM_ACM_0027 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
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
            case "btn_inv_dt":
                var cal=new ComCalendar();
                cal.select(frmObj.inv_dt, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH);
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
            case "btn_save":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;
            case "btn_re_calculate":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC01);
                break;
            case "btn_downexcel":
                ComOpenWait(true);
                if(shtObj.RowCount() < 1){//no data	
                	ComShowCodeMessage("COM132501");
                }else{	
                	//shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                	shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                }	
                ComOpenWait(false);
                break;
            case "btn_popup":
                // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                ComOpenPopup("COM_ENS_041.do", 775, 475, "setForwarder", "1,0,1,1,1,1,1", true, false);
                break;
            case "btn2_vvd_cd":
                ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                break;
            case "btn2_bl_no":
                ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
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
        memo_sheet1_OnLoadFinish(sheetObjects[1]);
        ACMMemoSheet_Open(sheetObjects[0]);    // CoAcm.js에 정의
        ACMMemoSheet_Open(sheetObjects[1]);    // CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[0], frmObj.vvd_cd);    // CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[1], frmObj.bl_no);    // CoAcm.js에 정의
        doActionIBSheet(sheet1,document.form,IBCLEAR);
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
                    ACMMemoSheet_InitSheet(shtObj,"150");    // CoAcm.js에 정의
                    break;
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj,"150");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                    
                    document.form.pagerows.value=500;
                    var HeadTitle0="STS|CHK|No.|AP Office|CA\nSeq|Freight\nForwarder|Vender|F/Forwarder Name|BKG No.|B/L No.|Remarks|BKG\nSTS|Comm VVD|ETD|Calculation\nDate|FMC|REF No.|" +
                    "Freight Status|Freight Status|Freight Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Prev. AMT|Calc. Diff|Status|AP IF Date";
                    var HeadTitle1="STS||No.|AP Office|CA\nSeq|Freight\nForwarder|Vender|F/Forwarder Name|BKG No.|B/L No.|Remarks|BKG\nSTS|Comm VVD|ETD|Calculation\nDate|FMC|REF No.|" +
                    "Commissionable|Rate|Compensation|BOX(CNT/AMT)|BOX(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|REU(CNT/AMT)|REU(CNT/AMT)|Commission|Prev. AMT|Calc. Diff|Status|AP IF Date";
                    (ComCountHeadTitle(HeadTitle1), 4, 0, true);
                    SetEditEnterBehavior("tab");

                    SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                           {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ap_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                           
                           {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ff_cmpn_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"frt_fwrd_cnt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"ff_cmpn_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"comm_vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_dep_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fmc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ff_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                           {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"act_comm_able",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ff_bkg_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"bkg_crnt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_bx_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ff_bx_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_teu_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ff_teu_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_feu_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ff_feu_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_rf_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ff_rf_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_crnt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ppd_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ff_cmpn_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(475);
                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    SetRangeBackColor(1,16,1,27,"#555555")
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
//        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "ac_sts_cd");
        // date_div_disp에 초기값 setting
        with (document.form) {
           // date_div_disp.value = ac_sts_cd.options[ac_sts_cd.selectedIndex].text;
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
        
        	case IBCLEAR://Office 목록 조회
        		ComOpenWait(false);
				var sXml=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], f_ap_ofc_cd, "value0", "value0");
					}
				if(ofc_cd.value === "NYCHQ"){
					f_ap_ofc_cd.SetMultiSelect(1);	
				}else{
					f_ap_ofc_cd.SetSelectIndex(0);					
				}
				ComOpenWait(false);
        		break;
            case SEARCH01:    // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:     // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0027GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSAVE:    // Save
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.DoSave("ESM_ACM_0027GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01:    // 재계산
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MODIFY ;
                //alert(FormQueryString(frmObj));
                shtObj.DoSave("ESM_ACM_0027GS.do", FormQueryString(frmObj),"chk",false);
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
    function sheet1_OnSearchEnd(shtObj,errMsg){
        if(shtObj.RowCount()> 0){
            for(var i=1;i<= shtObj.RowCount()+1;i++){
            	if(shtObj.GetCellValue(i, "ff_cmpn_sts_cd") == "CE"){
                    shtObj.SetRowFontColor(i,"#FF0000");
            	}else if(shtObj.GetCellValue(i, "ff_cmpn_sts_cd") == "CM"){
                    shtObj.SetRowFontColor(i,"#0000FF");
                }
            }
        }
        //if(errMsg!=null){
        if(errMsg!=""){
            ComShowMessage(errMsg);
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(shtObj, Row, Col) {
        if(shtObj.ColSaveName(Col) != "fmc_no" && shtObj.ColSaveName(Col) != "ff_ref_no") {
        	var param="?bl_no=" + shtObj.GetCellValue(Row, "bl_no") + "&bkg_no=" + shtObj.GetCellValue(Row, "bkg_no");
            // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
            ComOpenPopup("ESM_ACM_0117.do" + param, 1000, 700, "", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
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
                case "ac_sts_cd":
                    date_div_disp.value=ac_sts_cd.options[ac_sts_cd.selectedIndex].text;
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
        if (shtObj.RowCount()> 0) {
            for (var i=1;i<= shtObj.RowCount()+1;i++) {
            	if (shtObj.GetCellValue(i, "ff_cmpn_sts_cd") == "CE") {
                    shtObj.SetRowFontColor(i,"#FF0000");
            	} else if(shtObj.GetCellValue(i, "ff_cmpn_sts_cd") == "CM") {
                    shtObj.SetRowFontColor(i,"#0000FF");
                }
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
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(aryPopupData) {
        document.form.search_brog_cnt_cust_seq.value=aryPopupData[0][3];
        document.form.search_brog_cnt_cust_seqName.value=aryPopupData[0][4];
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
