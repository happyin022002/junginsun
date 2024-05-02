/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_169.js
*@FileTitle  :  IAS T/S Volume
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
    /**
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
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
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
        	  ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        with(sheetObj){
         var HeadTitle0="IOC|STS|Vessel|T/S Volume|T/S Volume";
         var HeadTitle1="IOC|STS|Vessel|E|W";

         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
         var headers = [ { Text:HeadTitle0, Align:"Center"},
                   { Text:HeadTitle1, Align:"Center"} ];
         InitHeaders(headers, info);

         var cols = [ {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"e_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"w_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
          
         InitColumns(cols);

         SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
                  }


    }
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0169GS.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "ioc_cd", true, 0);
				ComOpenWait(false);
				break;    
            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST01;
                 sheetObj.DoSearch("ESM_COA_0169GS.do", coaFormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:        //저장
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;
                sheetObj.DoSave("ESM_COA_0169GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
        }
    }
    /**
    * sheet1을 더블클릭하여 상세조회한다
    */
    function sheet1_OnChange(sheetObj, row, col, value){
     	var sht=sheetObj;
    	var total_idx=sht.RowCount()+2;
      if(col==0) {  	
    	  for(i=2;i < total_idx;i++) {
    		  sht.SetCellValue(i,col,value);
      	}
      }
    }    
