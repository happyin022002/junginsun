/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4004.js
*@FileTitle  : Batch Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/17
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
     * @class ESM_COA_4004 : ESM_COA_4004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_4004() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.doActionIBSheet=doActionIBSheet;
    }
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
    var loginUsr="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var sheetObj=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var frmObj=document.form;
        var srcName=ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                break;
            //20150519.ADD
            case "btn_DownExcel":
                doActionIBSheet(sheetObj, frmObj, IBDOWNEXCEL);                
        } // end switch
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheetObj) {
       sheetObjects[sheetCnt++]=sheetObj;
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
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, shtNo) {
        with (sheetObj) {
            switch (sheetObj.id) {
            case "sheet1":
            	   var cnt=0;
            	   var HeadTitle="|Receive Date|Source Cost|Batch Description|Total Count|Complete Count|Missing Count";
            	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

            	   var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	   InitHeaders(headers, info);

            	   var cols = [  {Type:"Status",   Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	                 //SJH.20141127.MOD : YM->YMD
	            	             {Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bat_rcv_dt",   	KeyField:0,   CalcLogic:"",   Format:"Ymd",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",     Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"call_fm_src_id",  KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",     Hidden:0, Width:500,  Align:"Left",    ColMerge:1,   SaveName:"bat_desc",  		KeyField:0,   CalcLogic:"",   Format:"",     	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Int",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"total",      		KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Int",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"complete",      	KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             //20150519.ADD
	            	             {Type:"Int",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"missing",      	KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
            	    
            	   InitColumns(cols);
            	   SetSheetHeight(210);
                   SetEditable(1);
                   SetWaitImageVisible(0);
                   SetEditableColorDiff(0);
            	break;

            case "sheet2":
                var cnt=0;
               
                document.form.pagerows.value=500;
                var HeadTitle="|Batch Desciption|Booking No.|Batch Flag|Complete Date";			//20150519.MOD
                (ComCountHeadTitle(HeadTitle), 0, 0, false);
                SetEditEnterBehavior("tab");

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColvTextTextTextResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"Text",  Hidden:0,  Width:500,  Align:"Left",    ColMerge:1,   SaveName:"bat_desc",   		KeyField:0,   CalcLogic:"",   Format:"",     	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",  Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",   		KeyField:0,   CalcLogic:"",   Format:"",     	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bat_flg",  		KeyField:0,   CalcLogic:"",   Format:"",     	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",  Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"complete_date",   KeyField:0,   CalcLogic:"",   Format:"YmdHms",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(210);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetEditableColorDiff(0); 
                      break;
            }
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                if ( sheetObj.id == "sheet1" ) {
                	frmObj.f_cmd.value=SEARCH01;
                	sheet1.RemoveAll();
                	sheet2.RemoveAll();
                } 
                else if ( sheetObj.id == "sheet2" ) {
                	frmObj.f_cmd.value=SEARCH02;                	
                	sheet2.RemoveAll();
                }
                else return false;
                sheetObj.DoSearch("ESM_COA_4004GS.do", coaFormQueryString(frmObj) ,{Sync:2} );
                ComOpenWait(false);
                break;
            //20150519.ADD
            case IBDOWNEXCEL:       // Excell download
    			if(sheetObjects[0].RowCount() < 1){//no data
    				  ComShowCodeMessage("COM132501");
    				  return;
    			}        	
            	var excelType=selectDownExcelMethod(sheetObj);
                break;                
        }
    }
    
	/**
     * Downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj's selected Row
     * @param {ibsheet} Col     	sheetObj's selected Col
     * @param {String} 	Value     	file name
     **/
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){			
		var sRow=sheetObj.GetSelectRow();
		var frmObj=document.form;
        if (sRow < 1) {
            ComShowCodeMessage("COM12189");
            return;
        }
        frmObj.f_headernm.value = sheetObj.GetCellValue(sRow, "bat_desc");
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
	
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        loginUsr=document.form.usr_id.value;
        with (sheetObj) {
			for(var i=1; i<=sheetObj.LastRow(); i++) {
				//Processing or 유저가 다른 로우에 대해서 Check box 비활성화
				if ( GetCellValue(i, "com_cnt") != "0" || GetCellValue(i, "cre_usr_id") != loginUsr ) {
					SetCellEditable(i, "chk",0);
					//SetCellBackColor(i, "chk",RgbColor(239,240,243));
				}
            }
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	if (ErrMsg != "") return;
    	with (sheetObj) {
    		for(var i=1; i<=sheetObj.LastRow(); i++) {
    			//Processing or 유저가 다른 로우에 대해서 Check box 비활성화
    			if ( GetCellValue(i, "com_cnt") != "0" || GetCellValue(i, "cre_usr_id") != loginUsr ) {
    				SetCellEditable(i, "chk",0);
    				//SetCellBackColor(i, "chk",RgbColor(239,240,243));
    			}
    		}
    	}
    } 
    
    //20150519.ADD
    function callBackExcelMethod(excelType){
    	var sheetObj = sheetObjects[0];
    	sheetObjects[0].Down2ExcelBuffer(true);
        switch (excelType) {
            case "AY":
                if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet1', HiddenColumn:0, SheetDesign:1, Merge:1}); 
                if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet2', HiddenColumn:0, SheetDesign:1, Merge:1});            
                break;
            case "AN":
            	if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet1', HiddenColumn:0, SheetDesign:0, Merge:0}); 
                if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet2', HiddenColumn:0, SheetDesign:0, Merge:0}); 
    	    	break;
            case "DY":
            	if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet1', HiddenColumn:1, SheetDesign:1, Merge:1}); 
                if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet2', HiddenColumn:1, SheetDesign:1, Merge:1}); 
            	break;
            case "DN":
            	if ( sheetObjects[0].RowCount()> 0 ) sheetObjects[0].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet1', HiddenColumn:1, SheetDesign:0, Merge:0}); 
                if ( sheetObjects[1].RowCount()> 0 ) sheetObjects[1].Down2Excel({FileName:'Weekly Batch Monitoring',SheetName:'sheet2', HiddenColumn:1, SheetDesign:0, Merge:0}); 
    	    	break;
        } 
    	sheetObjects[0].Down2ExcelBuffer(false);              
    }    
/* 개발자 작업 끝 */
