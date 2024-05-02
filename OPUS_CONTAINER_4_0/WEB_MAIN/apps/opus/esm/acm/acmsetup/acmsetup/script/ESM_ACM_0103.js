/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0103.js
*@FileTitle  :  Charge Deduction User Setting
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
     * @class ESM_ACM_0103 : ESM_ACM_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "grp_idv_div":
                if (frmObj.grp_idv_div[0].checked) {
                    ACMCellEditable(shtObj, "chk", "chg_cd", true);    // CoAcm.js에 정의
                    shtObj.SetDataBackColor(shtObj.GetEditableColor());
                    ACMCellEditable(sheetObjects[1], "chk", "chg_nm", false);    // CoAcm.js에 정의
                    ACMCellEditable(sheetObjects[2], "chk", "rep_chg_cd", false);    // CoAcm.js에 정의
                } else {
                	ACMCellEditable(sheetObjects[1], "chk", "chg_nm", true);    // CoAcm.js에 정의
                    sheetObjects[1].SetDataBackColor(sheetObjects[1].GetEditableColor());
                    ACMCellEditable(sheetObjects[2], "chk", "rep_chg_cd", true);    // CoAcm.js에 정의
                    sheetObjects[2].SetDataBackColor(sheetObjects[2].GetEditableColor());
                    ACMCellEditable(shtObj, "chk", "chg_cd", false);    // CoAcm.js에 정의
                }
                break;
            case "btn_clear":    // clear
                ComResetAll();
                document.form.slct_rep_chg.value="";
                document.form.slct_charge.value="";
                doActionIBSheet(shtObj, document.form, IBSEARCH);
                break;
            case "btn_select":    // select
                var rArray=new Array();
                if (frmObj.grp_idv_div[0].checked) {    // User Setting
                    if (shtObj.CheckedRows("chk") < 1) {
                        ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
                        return;
                    }
                    var s1chkRowIdx=shtObj.FindCheckedRow("chk").split("|")[0];
                    rArray[0]=shtObj.GetCellValue(s1chkRowIdx, "rep_chg_cd");
                    rArray[1]=shtObj.GetCellValue(s1chkRowIdx, "chg_cd");
                } else {    // Individual TP/SZ
                    if (sheetObjects[1].CheckedRows("chk") < 1 && sheetObjects[2].CheckedRows("chk") < 1) {
                        ComShowCodeMessage("COM12113", "[Rep.Charge] or [Charge Code]");    // Please select {?msg1}
                        return;
                    }
                    rArray[0]=document.form.slct_rep_chg.value;
                    rArray[1]=document.form.slct_charge.value;
                }
                
                var opener=window.dialogArguments;
                var OpnerChr = "window.dialogArguments.";
                if (!opener) OpnerChr="parent."; //이 코드 추가할것
                eval(OpnerChr + sFunc + "(rArray, iRow, iCol, iSheetIdx)");    // JSP에서 request.getParameter로 받은 param
                ComClosePopup(); 
                break;
            case "btn_close":    // close
            	ComClosePopup(); 
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
        doActionIBSheet(sheet1, document.form, IBSEARCH);
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
            switch (shtNo) {
                case 1:    // User Set List
                    var cnt=0;
                    var HeadTitle="STS|CHK|Group Name|Rep.Charge|Charge";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chg_ddct_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(120);
                    

                    break;
                case 2:    // Rep.Charge
                    var cnt=0;
                    var HeadTitle="STS|CHK|Code|Description";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(125);
                    

                    break;
                case 3:    // Charge Code
                    var cnt=0;                    
                    var HeadTitle="STS|CHK|Code|Description|Rep.CHG";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rep_chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(125);
                    

                    break;
            }
            SetEditable(1);
            SetWaitImageVisible(0);
            SetCountPosition(0);
            SetEditableColorDiff(0);
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:       // 조회
                 var xmlStr=shtObj.GetSearchData("ESM_ACM_0103GS.do", "f_cmd=" + SEARCH).split("|$$|");
                // User Set List
                sheetObjects[0].LoadSearchData(xmlStr[0],{Sync:1} );
                // Rep.Charge
                sheetObjects[1].LoadSearchData(xmlStr[1],{Sync:1} );
                // Charge Code
                sheetObjects[2].LoadSearchData(xmlStr[2],{Sync:1} );
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
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
     function sheet3_OnSearchEnd(shtObj) {
        shtObj.ReDraw=false;
        var slctRepChg=document.form.slct_rep_chg.value;
        if (slctRepChg != "") {
            // Rep.Charge 선택
            var tmpArr=slctRepChg.split(",");
            sheetObjects[1].ReDraw=false;
            for (var i=0; i<tmpArr.length; i++) {
                var findRowIdx=sheetObjects[1].FindText("chg_cd", tmpArr[i]);
                if (findRowIdx > -1) {
                    sheetObjects[1].SetCellValue(findRowIdx, "chk","1",0);
                    // sheet3의 해당rep_chg_cd값이 같은 row를 전부 check/uncheck
                    for (var k=shtObj.HeaderRows(); k<=shtObj.LastRow(); k++) {
                        // sheet2의 check된 row와 같은 rep_chg_cd에 해당하는 sheet3의 row도 check
                    	if (shtObj.GetCellValue(k, "rep_chg_cd") == sheetObjects[1].GetCellValue(findRowIdx, "chg_cd")) {
                            shtObj.SetCellValue(k, "chk","1",0);
                        }
                    }
                }
            }
            sheetObjects[1].ReDraw=true;
        }
        var slctCharge=document.form.slct_charge.value;
        if (slctCharge != "") {
            // Charge Code 선택
            var tmpArr=slctCharge.split(",");
            for (var i=0; i<tmpArr.length; i++) {
                var findRowIdx=shtObj.FindText("chg_cd", tmpArr[i]);
                if (findRowIdx > -1) {
                    shtObj.SetCellValue(findRowIdx, "chk","1",0);
                }
            }
        }
        shtObj.ReDraw=true;
        document.form.grp_idv_div[0].checked=true;
        ComFireEvent(document.form.grp_idv_div[0], "click");    // form.grp_idv_div 강제로 onclick 발생(processButtonClick를 호출)
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
     
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
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
