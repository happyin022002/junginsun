/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0003.js
*@FileTitle  : Charge Deduction User Setting
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
     * @class ESM_ACM_0003 : ESM_ACM_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
                	var slctRepChg=document.form.slct_rep_chg;
                	var slctCharge=document.form.slct_charge;
                    // 신규 행추가는 한 row만 가능
                    if (shtObj.RowCount("I") > 0) return;
                    // 신규 행추가와 동시에 CHK에 체크
                    shtObj.SetCellValue(shtObj.DataInsert(), "chk",1,0);
                    // Rep.Charge uncheck all
                    sheetObjects[1].CheckAll("chk",0);
                    // Charge Code uncheck all
                    sheetObjects[2].CheckAll("chk",0);
                    slctRepChg.value="";
                    slctCharge.value="";
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
            SetEditable(1);
            SetEditEnterBehavior("tab");
            SetWaitImageVisible(0);
            switch (shtNo) {
                case 1:    // User Set List
                    var cnt=0;
                    var HeadTitle="STS|CHK|Group Name|Rep.Charge|Charge|org_chg_cd|org_chg_ddct_grp_nm";

                    SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chg_ddct_grp_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"org_chg_cd" },
                        {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"org_chg_ddct_grp_nm" } ];
                     
                    InitColumns(cols);
                    SetColProperty(0 ,"chg_ddct_grp_nm" , {AcceptKeys:"E|N|[ ]" , InputCaseSensitive:1}); 
                    SetSheetHeight(185);
                    break;
                case 2:
                    var cnt=0;
                    var HeadTitle="STS|CHK|Code|Description|chg_div_cd";

                    SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:0 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"chg_div_cd" } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(185);
                	break;
                case 3:    // Charge Code
                    var cnt=0;
                    var HeadTitle="STS|CHK|Code|Description|Rep.CHG|chg_div_cd";

                    SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:0 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rep_chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                        {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"chg_div_cd" } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(185);
                    break;
            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
                ComOpenWait(true);
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0003GS.do", "f_cmd=" + SEARCH).split("|$$|");
                // User Set List
                sheetObjects[0].LoadSearchData(xmlStr[0],{Sync:1} );
                // Rep.Charge
                sheetObjects[1].LoadSearchData(xmlStr[1],{Sync:1} );
                // Charge Code
                sheetObjects[2].LoadSearchData(xmlStr[2],{Sync:1} );
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
                } else if (sheetObjects[1].CheckedRows("chk") < 1 && sheetObjects[2].CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[Rep.Charge] or [Charge Code]");    // Please select {?msg1}
                    return;
                }
                ComOpenWait(true);
                var sParam0=ComSetPrifix(shtObj.GetSaveString(false, false, "chk"), "UsrSet_");
                var sParam1=ComSetPrifix(sheetObjects[1].GetSaveString(false, false, "chk"), "RepChg_");
                var sParam2=ComSetPrifix(sheetObjects[2].GetSaveString(false, false, "chk"), "Charge_");
                shtObj.LoadSaveData(shtObj.GetSaveData("ESM_ACM_0003GS.do", "f_cmd=" + MULTI + "&" + sParam0 + "&" + sParam1 + "&" + sParam2));
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
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "rep_chg_cd":
                case "chg_cd":
                    ComShowMemoPad(shtObj, Row, Col, true);
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
                case "chk":
                	if (GetRowStatus(Row) == "I" || GetRowStatus(Row) == "D") return;
                	
                	sheetObjects[1].CheckAll("chk", 0);

                    var repChgCd=GetCellValue(Row, "rep_chg_cd");
                    // Rep.Charge 선택
                    repChgChargeSelection(sheetObjects[1], "chg_cd", repChgCd);
                    document.form.slct_rep_chg.value=repChgCd;
                    
                    var orgChgCd=GetCellValue(Row, "org_chg_cd");
                    // Charge Code 선택
                    repChgChargeSelection(sheetObjects[2], "chg_cd", orgChgCd);
                    document.form.slct_charge.value=GetCellValue(Row, "chg_cd");    // org_chg_cd가 아님에 유의
                    
                    ACMRadioChkAction(shtObj, Row);    // CoAcm.js에 정의
                    break;
                case "chg_ddct_grp_nm":
                    if (ComTrim(Value) == CellSearchValue(Row, Col)) {
                        SetCellValue(Row, Col,ComTrim(Value),0);
                        return;
                    }
                    // Duplication check
                    var xmlStr=shtObj.GetSearchData("ESM_ACM_0003GS.do", "f_cmd=" + SEARCH01 + "&chg_ddct_grp_nm=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr,GetCellValue(Row, "chg_ddct_grp_nm"))){
                        //SetCellValue(Row, "chg_ddct_grp_nm", "");
                        //SetSelectCell(Row, Col, true, "");
                        SelectCell(Row, Col, true, "");
                        SetCellValue(Row, Col, "", 0);
                     }
                    break;
            }
        }
    }
        
    function repChgChargeSelection(targetShtObj, targetCol, value) {
        // sheet2_OnChang나 sheet3_OnChang와는 반대 기능임
        if (value == undefined || value == null || value == "") return;
        var tmpArr=value.split(",");
        targetShtObj.ReDraw=false;  
        targetShtObj.CheckAll("chk", 0);
        for (var i=0; i<tmpArr.length; i++) {
            var findRowIdx=targetShtObj.FindText(targetCol, tmpArr[i]);
            if (findRowIdx > -1) {
                targetShtObj.SetCellValue(findRowIdx, "chk",1);
            }
        }
        targetShtObj.ReDraw=true;
        
        switch(targetShtObj.id) {
	        case "sheet2" :
	        		form.slct_rep_chg.value = value;
	        	break;
	        case "sheet3" :
	        		form.slct_charge.value = value;
	        	break;
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
    function sheet2_OnClick(shtObj, Row, Col, Value) {
    	
    	var dispTextareaValue = "";
    	
    	with (shtObj) {    // Selected Rep.Charge
            switch (ColSaveName(Col)) {
                case "chk":
                    
                	// Selected Rep.Charge의 TextArea의 값을 취득한다.
                	dispTextareaValue = dispTextareaOfChgCdProc(shtObj, "sheet2");
                	// Selected Rep.Charge의 TextArea의 값을 설정한다.                	
                	form.slct_rep_chg.value = dispTextareaValue;
                	
                    var shtObj1 = sheetObjects[2]; // Selected Charge Code                    
                    // Selected Charge Code시트에 체크박스 설정
                    shtObj1.ReDraw=false;
                    for (var k=shtObj1.HeaderRows(); k<=shtObj1.LastRow(); k++) {
                    	// sheet2의 check된 row와 같은 rep_chg_cd에 해당하는 sheet3의 row도 check/uncheck
                        if (shtObj1.GetCellValue(k, "rep_chg_cd") == shtObj.GetCellValue(Row, "chg_cd")) {
                        	shtObj1.SetCellValue(k, "chk", Value);
                        }
                        
                    }
                    shtObj1.ReDraw=true;
                    

                    if (shtObj1.CheckedRows("chk") != 0) {
	                    // Selected Charge Coded의 TextArea의 값을 취득한다.
	                    dispTextareaValue = dispTextareaOfChgCdProc(shtObj1, "sheet3");
	                    // Selected Charge Coded의 TextArea의 값을 설정한다.                    
	                    form.slct_charge.value = dispTextareaValue;
                    }
                 
                    break;
            }
    	}
    }
    
    function sheet3_OnClick(shtObj, Row, Col, Value) {
    	var dispTextareaValue = "";
    	
    	with (shtObj) {    // Selected Rep.Charge
            switch (ColSaveName(Col)) {
                case "chk":
                	dispTextareaValue = dispTextareaOfChgCdProc(shtObj, "sheet3");
                	form.slct_charge.value = dispTextareaValue;
                	
                	break;
            }
    	}    	
    }
  
    
    /**
     * TextArea에 설정값 편집 처리<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    var checkFlg = false;
    function dispTextareaOfChgCdProc(shtObj, divSheet) {
    	
    	var dispTextareaValue = "";
    	var chkRowArr= new Array();
    	chkRowArr=shtObj.FindCheckedRow("chk").split("|");
    	
    	var tempArray=new Array();
    	
    	if("sheet2" == divSheet) {
    		 if (chkRowArr.length >= 1) {
    	            // 선택된 row의 rep_chg_cd를 textarea에 setting
    			 for (var i=0; i<= chkRowArr.length-1; i++) {
    	           	var checkedIdx = chkRowArr[i];
    	           	if(shtObj.GetCellValue(checkedIdx, "chg_cd")== -1){
    	           		tempArray[tempArray.length]="";
    	           	} else {
    	           		tempArray[tempArray.length]=shtObj.GetCellValue(checkedIdx, "chg_cd");
    	           	}    	            	
    			 }
    			 dispTextareaValue=tempArray.toString();
    		 } else {
    			 dispTextareaValue="";
    		 }    		  
    	} else if("sheet3" == divSheet) {
    		
    		var chgMap = new HashMap();
    	    var tempChgMap = new HashMap();
    		
    		var originCnt = 1; 
        	var chgCnt = 1;
    		
    		var shtObj1 = sheetObjects[1];
    		
    		var curIdx = shtObj.GetSelectRow();
    		
    		var sltReqCd =  shtObj.GetCellValue(curIdx, "rep_chg_cd");
    		
    		var searchRowIdx = shtObj1.FindText("chg_cd", sltReqCd);
    		
    		var chgCd = shtObj1.GetCellValue(searchRowIdx, "chg_cd");
    		
	    	if (chkRowArr.length >= 1) {	    		
	    		
	    		// Selected Charge Code시트의 체크된 row의 rep_chg_cd별로 카운저장
	    		for (var k=shtObj.HeaderRows(); k<=shtObj.LastRow(); k++) {	    			
	    			var reqCd = shtObj.GetCellValue(k, "rep_chg_cd");
	    			if(sltReqCd == reqCd) {
	    				chgMap.put(reqCd, originCnt++);
	    			}
	    		}
	    		
	    		// Selected Charge Code시트의 체크된 row의 rep_chg_cd별로 카운저장
	    		for (var i=0; i<= chkRowArr.length-1; i++) {
	            	var checkedIdx = chkRowArr[i];
	            	var reqCd = shtObj.GetCellValue(checkedIdx, "rep_chg_cd");
	            	if(sltReqCd == reqCd) {
	            		tempChgMap.put(reqCd, chgCnt++);
	            	}
	    		}
	    		
	    		if(chgMap.get(chgCd) == tempChgMap.get(chgCd)) {
	    			shtObj1.SetCellValue(searchRowIdx, "chk", true);
	    		} else {
	    			shtObj1.SetCellValue(searchRowIdx, "chk", false); 
	    		}
	    		
	    		// Selected Rep.Charge의 TextArea의 값을 취득한다.
	        	dispTextareaValue = dispTextareaOfChgCdProc(shtObj1, "sheet2");
	        	// Selected Rep.Charge의 TextArea의 값을 설정한다.
	        	form.slct_rep_chg.value = dispTextareaValue; 
	        	
	        	dispTextareaValue="";
	    		
	    		// 선택된 row의 Charge Code를 textarea에 setting
	            for (var i=0; i<= chkRowArr.length-1; i++) {
	            	var checkedIdx = chkRowArr[i];
	            	if (form.slct_rep_chg.value.indexOf(shtObj.GetCellValue(checkedIdx, "rep_chg_cd")) < 0) {
		            	if(shtObj.GetCellValue(checkedIdx, "chg_cd") != -1) {
		            		tempArray[tempArray.length]=shtObj.GetCellValue(checkedIdx, "chg_cd");		            		
		            	} else {
		            		tempArray[tempArray.length]="";
		            	}
	            	}
	            }
	            dispTextareaValue=tempArray.toString();
	        } else {
	        	dispTextareaValue="";
	        }
    	} 
       
    	return dispTextareaValue;
    }

/* 개발자 작업 끝 */
