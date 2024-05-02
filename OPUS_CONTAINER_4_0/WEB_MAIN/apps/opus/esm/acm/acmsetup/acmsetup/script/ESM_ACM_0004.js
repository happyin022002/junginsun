/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0004.js
*@FileTitle  : Office Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
                case "btn_retrieve":     // Retrieve
                	if(shtObj.IsDataModified()==true){
                   	 doActionIBSheet(shtObj, frmObj, IBSAVE);
                   	 }
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;
                case "btn_downexcel":    // Down Excel
                    if(shtObj.RowCount() < 2){//no data
                        ComShowCodeMessage("COM132501");
                    }else{
                	   shtObj.Down2Excel({ HiddenColumn:true, DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                    }
                    break;
                case "btn_add":           // Row Add
                    var newRowIdx=shtObj.DataInsert();
                    // 조회 조건의 RHQ를 rhq_cd에 setting
                    shtObj.SetCellValue(newRowIdx, "rhq_cd",frmObj.rhq_cd_disp.value,0);
                    shtObj.SetCellValue(newRowIdx, "curr_cd","USD",0);
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
        sheet1_OnLoadFinish(sheet1);
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
	         var HeadTitle0="STS|SEQ|RHQ|Office|Sub-Office|Office\nGroup|Display\nGroup|Office Character|Effective Date|Effective Date|Effective Date|Effective Date|Vendor|Ex. Rate.|Currency|A/R Office|";
	         var HeadTitle1="STS|SEQ|RHQ|Office|Sub-Office|Office\nGroup|Display\nGroup|Office Character|From|From|To|To|Vendor|Ex. Rate.|Currency|A/R Office|";
	         SetEditEnterBehavior("tab");
	
	         SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	         var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle0, Align:"Center"},
	                   { Text:HeadTitle1, Align:"Center"} ];
	         InitHeaders(headers, info);
	
	         var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	             {Type:"PopupEdit", Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	             {Type:"PopupEdit", Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_grp_id",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_grp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	             {Type:"Combo",     Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"ofc_chr_cd",      KeyField:1 },
	             {Type:"Combo",     Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"agn_fm_dt_cd",    KeyField:1 },
	             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agn_fm_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd" },
	             {Type:"Combo",     Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"agn_to_dt_cd",    KeyField:1 },
	             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agn_to_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd" },
	             {Type:"PopupEdit", Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"xch_rt_div_lvl",  KeyField:1 },
	             {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_ofc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_info_seq" } ];
	          
	         InitColumns(cols);
	         SetSheetHeight(485);
	         SetEditable(1);
	         SetWaitImageVisible(0);
	         SetColProperty("ofc_chr_cd", {ComboText:"|"+ofcChrText, ComboCode:"|"+ofcChrCode} );
	         SetColProperty("agn_fm_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
	         SetColProperty("agn_to_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
	         SetColProperty("xch_rt_div_lvl", {ComboText:"|"+xchRtDivLvlText, ComboCode:"|"+xchRtDivLvlCode} );
	         SetColProperty("curr_cd", {ComboText:"|"+currText, ComboCode:"|"+currCode} );
	         InitComboNoMatchText(true);
	         SetShowButtonImage(3);
	         SetHeaderRowHeight(18);
	         SetColProperty(0 ,"rhq_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	         SetColProperty(0 ,"agn_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	         SetColProperty(0 ,"ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	         SetColProperty(0 ,"ofc_grp_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	         SetColProperty(0 ,"dp_grp_nm" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	         SetColProperty(0 ,"vndr_seq" , {AcceptKeys:"N"});
	         SetColProperty(0 ,"ar_ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
         }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "rhq_cd_disp");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // RHQ 목록 조회
                // RHQ level과 목록 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                ACMXml2SelectItem(xmlStr, frmObj.rhq_cd_disp, "value0", "value0", true);    // CoAcm.js에 정의
                var rhqCd=ComGetEtcData(xmlStr, "rhq_cd");
                if (rhqCd == "") {
                    // 본사 User일 경우 (rhqCd가 Null로 조회)
//                    rhq_cd_disp.style.display="inline";    // hidden인 form.rhq_cd_disp가 보여지게 함
//                    rhq_cd.style.display="none";    // form.rhq_cd는 숨김
                } else {
                    // 그 외에는 조회된 rhqCd를 form.rhq_cd에 setting
                    frmObj.rhq_cd.value=rhqCd;
                }
                break;
            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0004GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:         // 저장
                if (!shtObj.IsDataModified()) {
                    ComShowCodeMessage("COM130503");
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                var result = shtObj.DoAllSave("ESM_ACM_0004GS.do", FormQueryString(frmObj));
                if(!result){
                    ComOpenWait(false);               	
                }
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
      function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 RHQ Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
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
                case "ofc_cd":
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
                    SetCellValue(Row, Col,aryPopupData[0][2],0);
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
/*
                case "agn_cd":
                    // validation
var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value);
                    if (
shtObj, xmlStr)) {
                        SelectCell(Row, Col, true, "");
                    } else {
                        SetCellValue(Row, "ar_ofc_cd",ComGetEtcData(xmlStr, "ar_ofc_cd"),0);
                    }
                    break;
*/
                case "ofc_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&ofc_cd=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "ofc_cd"))){
                        //SetCellValue(Row, "ofc_cd", "");
                    	setTimeout(function(){
                    		SelectCell(Row, Col, true, "");
                    		SetCellValue(Row, Col, "", 0);
                    	},10); 
                    }
                    break;
                case "vndr_seq":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value + "&vndr_seq=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "vndr_seq"))){
                        //SetCellValue(Row, "vndr_seq", "");
                    	setTimeout(function(){
                    		SelectCell(Row, Col, true, "");
                    		SetCellValue(Row, Col, "", 0);
                    	},10); 
                    }
                    break;
                case "ar_ofc_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=A/R Office" + "&ar_ofc_cd=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "ar_ofc_cd"))){
                        //SetCellValue(Row, "ar_ofc_cd", "");
                    	setTimeout(function(){
                    		SelectCell(Row, Col, true, "");
                    		SetCellValue(Row, Col, "", 0);
                    	},10);                     		
                    }
                    break;
                case "agn_fm_dt":
                	if( GetCellValue(Row,"agn_to_dt") != "" && GetCellValue(Row,"agn_fm_dt") > GetCellValue(Row,"agn_to_dt") ) {
                        ComShowCodeMessage("ACM00017", "From Effective Date", "To Effective Date");
                        //ComShowMessage("Eff. Date is later than Exp. Date. Please check Eff. Or Exp. Date.");
                    	setTimeout(function(){
                        SelectCell(Row, Col, true, "");
                    	},10);                     		                        
                    }
                    break;
                case "agn_to_dt":
                	if( GetCellValue(Row,"agn_fm_dt") > GetCellValue(Row,"agn_to_dt") ) {
                        ComShowCodeMessage("ACM00018", "To Effective Date", "Form Effective Date");
                        //ComShowMessage("Exp. Date is earlier than Eff. Date. Please check Eff. Or Exp. Date.");
                    	setTimeout(function(){
                        SelectCell(Row, Col, true, "");
                    	},10);                     		
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
    	ComOpenWait(false);
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var elementName=ComGetEvent("name");
        with (document.form) {
            switch (elementName) {
                case "rhq_cd_disp":
                    rhq_cd.value=rhq_cd_disp.value;
                    break;
            }
        }
    }
    function rhq_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.rhq_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
/* 개발자 작업 끝 */
