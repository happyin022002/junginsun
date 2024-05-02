﻿/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9040.js
*@FileTitle : Total Amount List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 1.0 최초 생성 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];
         var formObject = document.form;

    	 try {
    		 var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btn_ok":
         	    	ComShowMessage ("btn_ok button click");
        	        break;

         	   case "btn_close":
        	    	ComClosePopup(); 
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //showErrMessage("지금은 사용하실 수가 없습니다");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		setTotalAmountSheet();
    }

    
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheet_obj) sheet object
     * @param(sheetNo) 	 sheet number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
            		var HeadTitle = "VVD|BND|Cost Code||Amount";
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ 
					  {Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"vvd",  		KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",   Hidden:1,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"sum_basis",    KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"AutoSum",   Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"",  PointCount:2,   UpdateEdit:0,   InsertEdit:0 }];
  
					InitColumns(cols);				
					resizeSheet();//SetSheetHeight(240);
					SetEditable(1);
               }
                break;
        }
    }
    
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}


  /** Sheet관련 프로세스 처리
  * @param(sheet_obj) 		sheet object
  * @param(formObj) 	 	form  object
  * @param(sAction) 		action 값
  */
  
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBLOADEXCEL:      //조회
                   sheetObj.LoadExcel();
                break;
        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param(sheet_obj) 		sheet object
     * @param(formObj) 	 	form  object
     * @param(sAction) 		action 값
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

        /**
         * total sheet 내용을 넣어줌  
         * @return
         */
		function setTotalAmountSheet(){

			var opener=window.dialogArguments;
		
			if (!opener) opener=window.opener;  //이 코드 추가할것
			if (!opener) opener=parent;         // 기존 가이드 부분

			sheetObjects[0].ShowSubSum([{StdCol:"sum_basis", SumCols:"inv_amt", ShowCumulate:0, OtherColText:"vvd=VVD Amount;io_bnd_cd=VVD AMOUNT;lgs_cost_cd=VVD Amount"}]);
			
			var openerObject = opener.total_hidden;
			var xml = "<SHEET><DATA>";
			for(var i= openerObject.HeaderRows(); i< openerObject.HeaderRows() + openerObject.RowCount(); i++){
				xml += "<TR>"
				xml += "<TD>"+ openerObject.GetCellValue(i,"vvd") +"</TD>";
				xml += "<TD>"+ openerObject.GetCellValue(i,"io_bnd_cd") +"</TD>";
				xml += "<TD>"+ openerObject.GetCellValue(i,"lgs_cost_cd") +"</TD>";
				xml += "<TD>"+ openerObject.GetCellValue(i,"sum_basis") +"</TD>";
				xml += "<TD>"+ tes_round(openerObject.GetCellValue(i,"inv_amt"), 2) +"</TD>";
				xml += "</TR>";
			}
			xml += "</DATA></SHEET>";
			
			sheetObjects[0].LoadSearchData(xml , {Sync:1});
			
			var findRows = sheetObjects[0].FindSubSumRow();
			var findRowsArr = findRows.split("|");
			for( var i=0 ; i < findRows.length;i++){
				sheetObjects[0].SetMergeCell(parseInt(findRows[i],10),0 ,1,3);
			}
			
			sheetObjects[0].SetSumBackColor("#CCCCFF");
			sheetObjects[0].SetSumFontBold(1);
			sheetObjects[0].SetRowMerge(sheetObjects[0].RowCount,1);
			sheetObjects[0].SetSumText(0,"vvd","TOTAL");
	}

		
