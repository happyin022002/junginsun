/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0026.js
*@FileTitle  : Revenue Structure Setting
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
     * @class ESM_ACM_0026 : ESM_ACM_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0026() {
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
//        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_retrieve":     // Retrieve
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
                case "btn_add":           // Row Add
                    doActionIBSheet(shtObj, frmObj, IBINSERT);
                    break;
                case "btn_delete":       // Row Delete
                    doActionIBSheet(shtObj, frmObj, IBDELETE);
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
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
                    with(shtObj){
                              document.form.pagerows.value=500;
                              SetEditEnterBehavior("tab");
                              switch (shtNo) {
                              case 1:    // sheet[0] init
                              case 2:
                    	   var cnt=0;
                    	   var HeadTitle0="STS|CHK|Charge to Add to Revenue|RHQ|Scope|Effective Date|Effective Date|Effective Date|Effective Date|Prev STS|CHG_SEQ";
                    	   var HeadTitle1="STS|CHK|Charge to Add to Revenue|RHQ|Scope|From|From|To|To|Prev STS|CHG_SEQ";
                    	   SetConfig( { SearchMode:2, MergeSheet:5, Page:30, FrozenCol:0, DataRowMerge:1 } );
                    	   var info={ Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                    	   var headers=[ { Text:HeadTitle0, Align:"Center"},
                    	   { Text:HeadTitle1, Align:"Center"} ];
                    	   InitHeaders(headers, info);
                    	   var cols=[ {Type:"Status",    Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                    	   {Type:"DummyCheck", Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                    	   {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"chg_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                    	   {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rhq_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                    	   {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                    	   {Type:"Combo",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"rev_fm_dt_cd",  KeyField:1 },
                    	   {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_fm_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd", EditLen:8 },
                    	   {Type:"Combo",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"rev_to_dt_cd",  KeyField:1 },
                    	   {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rev_to_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd", EditLen:8 },
                    	   {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_sts" },
                    	   {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_chg_seq" },
                    	   ];
                    	   InitColumns(cols);
                    	   //SetSheetWidth(mainTable1.clientWidth);
                    	   SetColProperty("rev_fm_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
                    	   SetColProperty("rev_to_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
                    	   SetColProperty(0 ,"chg_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
                    	   SetShowButtonImage(3);
                    	   SetHeaderRowHeight(18);
                    	   SetSheetHeight(520);
                    	   //지원안함[확인요망]: InitDataValid(0, "chg_cd", vtEngUpOnly);    // 영대문자만
                    	   break;
                              }
                              }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // RHQ 목록 조회
                 var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                //if (ACMDecideErrXml(shtObj, xmlStr)) return;
                var comboStr=ComXml2ComboString(xmlStr, "value0", "value0");
                shtObj.SetColProperty("rhq_ofc_cd", {ComboText:"|"+comboStr[0], ComboCode:"|"+comboStr[1]} );
                break;
            case SEARCH02:       // Service Scope 목록 조회
                var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH11 + "&value8=SCP");
                //if (ACMDecideErrXml(shtObj, xmlStr)) return;
                var comboString=ComXml2ComboString(xmlStr, "value0", "value1");
                var codeStrTemp=comboString[0].split('|'); // Scope 코드
                var nameStrTemp=comboString[1].split('|'); // Scope 이름
                var fullStrTemp='';  // 코드 + 이름
                for(var i=0; i<codeStrTemp.length; i++){
                    fullStrTemp=fullStrTemp +'|'+ codeStrTemp[i] + '\t' + nameStrTemp[i] ;
                }
                shtObj.SetColProperty("scp_cd", {ComboText:"All"+fullStrTemp, ComboCode:"|"+comboString[0]} );
                break;
            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0026GS.do",FormQueryString(frmObj), {Sync:2}  );
                //ComOpenWait(false);
                break;
            case IBSAVE:         // 저장
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.DoSave("ESM_ACM_0026GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
            case IBINSERT:       // 신규 행추가
                // 신규 행추가와 동시에 CHK에 체크
                //shtObj.CellValue2(shtObj.DataInsert(), "chk") = 1;
                var newRowIdx=shtObj.DataInsert(-1);
                break;
            case IBDELETE:       // 체크된 행삭제
                var checkedNum=shtObj.CheckedRows("chk");
                var chkRowArr=shtObj.FindCheckedRow("chk").split("|");
                if (chkRowArr == "") {
                    //체크 안하면 리턴
                    ComShowCodeMessage("ACM00031","");	//Please check rows to request.
                    ComOpenWait(false);
                    return;
                }
                if(checkedNum > 0){
                    var chkRowNum=shtObj.FindCheckedRow(1);
                    var arrRow=chkRowNum.split("|");
                    //for (var idx=0; idx < arrRow.length-1; idx++){
                    for (var idx=0; idx < arrRow.length; idx++){
                    	shtObj.SetCellValue(arrRow[idx],"pre_sts",shtObj.GetCellValue(arrRow[idx] , 0));
                    	shtObj.SetRowStatus(arrRow[idx] ,"D");
                    }
                }
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
	function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, SEARCH01);
         doActionIBSheet(shtObj, document.form, SEARCH02);
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }
     function sheet1_OnSearchEnd(shtObj) {
    	 ComOpenWait(false);
     }
    	
     /**
      * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {Row} Long : 해당 셀의 Row Index
      * @param {Col} Long : 해당 셀의 Column Index
      * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      */
     function sheet1_OnBeforeCheck(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                	if(GetCellValue(Row,Col) == 1){
                		var PrevSts=shtObj.GetCellValue(Row,"pre_sts");
                		shtObj.SetRowStatus(Row ,PrevSts);
                    }
                    break;
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
                case "chg_cd":
                    // validation
                     var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH10 + "&value0=" + Value + "&value8=Charge Code");
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	//SelectCell(Row, Col, 1, "");
                    	setTimeout(function(){                    	
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
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
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
/* 개발자 작업 끝 */
