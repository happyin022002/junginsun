/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0035.js
*@FileTitle  : Agent Commission Agreement Inquiry
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
 * @class ESM_ACM_0035 : ESM_ACM_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var t1s1chkRowIdx=-1;
    var t2s2chkRowIdx=-1;
    document.onclick=processButtonClick;
    function processButtonClick() {
        var t3shtObj2=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "tab3btn_retrieve":
                    doActionIBSheet(t3shtObj2, frmObj, SEARCH03);
                    break;
            }
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++]=tabObj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var frmObj=document.form;
        for (var k=0; k<tabObjects.length; k++){
            initTab(tabObjects[k], k+1);
        }
        for (var i=0; i<sheetObjects.length; i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        tab3sheet1_OnLoadFinish(tab3sheet1);
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var shtId=shtObj.id;
        with(shtObj){
          switch (shtId) {
          case "tab3sheet1":
	          var cnt=0;
	          var HeadTitle0="STS|CHK|Agreement No.|Effective date|Effective date|Effective date|Effective date|Remark|DEL|agn_cd";
	          var HeadTitle1="STS|CHK|Agreement No.|From|From|To|To|Remark|DEL|agn_cd";
	          (ComCountHeadTitle(HeadTitle1), 0, 0, false);
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	          var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	          var headers = [ { Text:HeadTitle0, Align:"Center"},
	                      { Text:HeadTitle1, Align:"Center"} ];
	          InitHeaders(headers, info);
	          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
	                       {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0, Width:680,  Align:"Left",    ColMerge:1,   SaveName:"agn_agmt_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd" } ];
	           
	          InitColumns(cols);
	          SetWaitImageVisible(0);
	          SetEditable(1);
	          SetEditableColorDiff(0);
	          SetColProperty("agmt_fm_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
	          SetColProperty("agmt_to_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
	          SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
	          document.form.pagerows.value=500;
	          SetEditEnterBehavior("tab");
	          InitComboNoMatchText(true);
	          SetShowButtonImage(3);
	          SetSheetHeight(200);
	          break;

          case "tab3sheet2":
        	   var cnt=0;
        	   var HeadTitle0="STS|Bound|Account|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Rate Base|Rate Base|Rate Base|Deduction|Deduction|Deduction|Deduction|Deduction|Deduction|Route Setting|Route Setting|Route Setting|Route Setting|Office Setting|Office Setting|Office Setting|||||||||||||||||||||||";
        	   var HeadTitle1="STS|Bound|Account|TP/SZ|Full/MT|Curr|Fixed Amount|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage|POR|POL|POD|DEL|Type|Covered Location|Office|||||||||||||||||||||||";
        	   (ComCountHeadTitle(HeadTitle1), 0, 0, false);
        	   SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5,Page:20, DataRowMerge:1 } );
        	   var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
        	   var headers = [ { Text:HeadTitle0, Align:"Center"},
        	                 { Text:HeadTitle1, Align:"Center"} ];
        	   InitHeaders(headers, info);
        	   var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        	                {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"ac_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"comm_fx_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"comm_pay_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rev_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"comm_rt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_org_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_dest_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_org_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_dest_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Popup",     Hidden:0, Width:78,   Align:"Center",  ColMerge:0,   SaveName:"por",    				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Popup",     Hidden:0, Width:78,   Align:"Center",  ColMerge:0,   SaveName:"pol",    				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Popup",     Hidden:0, Width:78,   Align:"Center",  ColMerge:0,   SaveName:"pod",    				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Popup",     Hidden:0, Width:78,   Align:"Center",  ColMerge:0,   SaveName:"del",    				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_set_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cvrg_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agn_cd" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agn_agmt_no" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agn_agmt_seq" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_1" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_2" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_3" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_4" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_lvl_cd" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_1" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_2" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_3" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_4" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_lvl_cd" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_1" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_2" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_3" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_4" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_lvl_cd" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_1" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_2" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_3" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_4" },
        	                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_lvl_cd" } ];
        	    
        	   InitColumns(cols);
        	   SetEditable(1);
        	   SetEditableColorDiff(0);
        	   SetColProperty("io_bnd_cd", {ComboText:ioBndText, ComboCode:ioBndCode} );
        	   SetColProperty("ac_tp_cd", {ComboText:acTpText, ComboCode:acTpCode} );
        	   SetColProperty("full_mty_cd", {ComboText:fullMtyText, ComboCode:fullMtyCode} );
        	   SetColProperty("comm_pay_term_cd", {ComboText:commPayTermText, ComboCode:commPayTermCode} );
        	   SetColProperty("rev_div_cd", {ComboText:revDivText, ComboCode:revDivCode} );
        	   SetColProperty("hlg_ddct_org_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
        	   SetColProperty("hlg_ddct_dest_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
        	   SetColProperty("fdrg_ddct_org_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
        	   SetColProperty("fdrg_ddct_dest_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
        	   SetColProperty("ofc_set_tp_cd", {ComboText:ofcSetTpText, ComboCode:ofcSetTpCode} );
        	   SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
        	   SetSheetHeight(250);
    	   break;
    	   }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm("change", "frmObj_OnChange",formObj);
    }
    
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                ACMXml2SelectItem(xmlStr,document.form.rhq_cd_disp, "value0", "value0", true);    // CoAcm.js
                var rhqCd=ComGetEtcData(xmlStr, "rhq_cd");
                ofcKndCd=ComGetEtcData(xmlStr, "ofc_knd_cd");
                if (rhqCd == "") {
                	document.form.rhq_cd_disp.style.display="inline";
                    frmObj.rhq_cd.style.display="none";
                } else {
                	document.form.rhq_cd_disp.value=rhqCd;
                	$("#rhq_cd_disp").change();
//                	rhq_cd_disp.fireEvent("onchange");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                	ComFireEvent(rhq_cd_disp, "change");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                }
                break;
            case SEARCH11:    // TAB2_Sheet2_Retrieve / TAB3_Sheet2_Retrieve
                ComOpenWait(true);
                sheetObjects[1].DoSearch("ESM_ACM_0001GS.do", "f_cmd=" + SEARCH11 + "&" + CondParam, {Sync:2} );
                ComOpenWait(false);
                break;
            case SEARCH03:    // TAB3_Sheet1_Retrieve (TAB3에서만 조회 - TAB3에서 호출)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                for (var i=0; i<sheetObjects.length; i++){
                    sheetObjects[i].RemoveAll();
                }
                frmObj.f_cmd.value=SEARCH;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0001GS.do", FormQueryString(frmObj));
                shtObj.LoadSearchData(xmlStr,{Sync:1} );
                ComOpenWait(false);
            break;
        }
    }
    
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
	 function tab3sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
	 
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab3sheet1_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                    // check된 한 row의 Data를 param으로 TAB3의 Sheet2 내용 조회
                	doActionIBSheet(sheetObjects[1], document.form, SEARCH11, RowSaveStr(Row));
                    break;
            }
        }
    }
    
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab3sheet2_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "cntr_tpsz_cd":
                case "rep_chg_cd":
                case "chg_cd":
                    ComShowMemoPad(shtObj, Row, Col, true);
                    break;
            }
        }
    }
    
    /**
     * IBSheet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab3sheet2_OnPopupClick(shtObj, Row, Col) {
        with (sheetObjects[1]) {
        	var param="?agnCd=" + GetCellValue(Row, "agn_cd") +
        	"&agnAgmtNo=" + GetCellValue(Row, "agn_agmt_no") +
			"&ioBndCd=" + GetCellValue(Row, "io_bnd_cd") +
			"&acTpCd=" + GetCellValue(Row, "ac_tp_cd") +
			"&agnAgmtSeq=" + GetCellValue(Row, "agn_agmt_seq");
        }
        switch (shtObj.ColSaveName(Col)) {
            case "por":
                param += "&routRefDivCd=POR";
                break;
            case "pol":
                param += "&routRefDivCd=POL";
                break;
            case "pod":
                param += "&routRefDivCd=POD";
                break;
            case "del":
                param += "&routRefDivCd=DEL";
                break;
        }
      //ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
        ComOpenPopup("ESM_ACM_0113.do" + param, 970, 455, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 1);
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
                switch (ColSaveName(Col)) {
                    case "por":
                    case "pol":
                    case "pod":
                    case "del":
                        SetCellValue(Row, ColSaveName(Col) + "_1",aryPopupData[1]);
                        SetCellValue(Row, ColSaveName(Col) + "_2",aryPopupData[2]);
                        SetCellValue(Row, ColSaveName(Col) + "_3",aryPopupData[3]);
                        SetCellValue(Row, ColSaveName(Col) + "_4",aryPopupData[4]);
                        SetCellValue(Row, ColSaveName(Col) + "_lvl_cd",aryPopupData[0]);
                        SetCellValue(Row, Col,aryPopupData[aryPopupData[0]]);
                        break;
                }
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
                case "rhq_cd_disp":
                    if (document.form.rhq_cd_disp.value == "") {
                        ComClearCombo(ar_ofc_cd);
                        ComClearCombo(agn_cd);
                        return;
                    }
                    rhq_cd.value=document.form.rhq_cd_disp.value;
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH18 + "&value0=" + rhq_cd.value + "&value1=" + ofcKndCd );
                    if (ACMXml2SelectItem(xmlStr, ar_ofc_cd, "value0", "value0", false)) {
                        if (ar_ofc_cd.options.length > 1) {
                            ar_ofc_cd.value=rhq_cd.value;
                        }
                		$("#ar_ofc_cd").change();
//                        ar_ofc_cd.fireEvent("onchange");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                		ComFireEvent(ar_ofc_cd, "change");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)

                    }
                    break;
                case "ar_ofc_cd":    // Office를 변경시 Sub Office목록을 setting
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        if (agn_cd.options.length > 1) {
                            agn_cd.value=ar_ofc_cd.value;
                        }
                    }
                    break;
            }
        }
    }
