/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1043.js
*@FileTitle  : OP/MG Forecast Log 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var headCount=0;
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1043 : EES_EQR_1044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt=0;
        var sheetObject=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    break;
                case "btn_Close":
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
	                var HeadTitle="Balance Report ID|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|User Name|Office|Date(Local)|Date(GMT)";
	                headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, FrozenCol:1, MergeSheet:2, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inp_yrwk",      KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"d7_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"r2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"r5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"r9_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"o2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"s2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"o4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"s4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"f2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"a2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"f4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"a4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"f5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_nm",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"locl_dt",       KeyField:0,   CalcLogic:"",   Format:"" },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                sheetObj.FrozenCols=1;
	                SetSheetHeight(540);
               }
               break;               
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //조회
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true); 
                formObj.f_cmd.value=SEARCH;
                var sXml=sheetObj.GetSearchData("EES_EQR_1043GS.do",FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                ComOpenWait(false); 
                break;
            case IBDOWNEXCEL:      // 입력
            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
            	}
             break;
        }
    }    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
 		if ( document.form.search_flag.value=="0" ) {  // DRY
			setCellHidden(sheetObj,false,true);
		} else if ( document.form.search_flag.value=="1" ) { // SPCL
			setCellHidden(sheetObj,true,false);
		} else {  // ALL
			setCellHidden(sheetObj,false,false);
		}
     }
     /**
      * 관리대상 EQ TP/SZ를 결정
      */
     function setCellHidden(sheetObj,showFlag1,showFlag2) {
 		sheetObj.SetColHidden("d2_fcast_qty",showFlag1);
 		sheetObj.SetColHidden("d4_fcast_qty",showFlag1);
 		sheetObj.SetColHidden("d5_fcast_qty",showFlag1);
 		sheetObj.SetColHidden("d7_fcast_qty",showFlag1);
 		sheetObj.SetColHidden("r2_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("r5_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("r9_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("o2_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("s2_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("o4_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("s4_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("f2_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("a2_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("f4_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("a4_fcast_qty",showFlag2);
 		sheetObj.SetColHidden("f5_fcast_qty",showFlag2);
     }
