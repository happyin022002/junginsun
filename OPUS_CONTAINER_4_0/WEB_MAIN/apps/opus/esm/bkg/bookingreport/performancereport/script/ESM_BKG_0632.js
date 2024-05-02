/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0632.js
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author CLT
     */
    /**
     * @extends 
     * @class ESM_BKG_0632 : ESM_BKG_0632 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
 
   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var combo1=null;
    var comboCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다.
         * 배열은 소스 상단에 정의
         */
        function setSheetObject(sheet_obj){
        	sheetObjects[sheetCnt++]=sheet_obj;
        }
        function setComboObject(combo_obj){
        	comboObjects[comboCnt++]=combo_obj;
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
            //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	    	initCombo(comboObjects[k],comboObjects[k].options.id);
	 	    }
            initControl();
            doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
//            document.form.vvd_sig.focus();
        }
     /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj, comboId) {
    	  comboObj.SetMultiSelect(0);
    	  //comboObj.LineColor = "#ffffff";
    	  //comboObj.SetColAlign("left|left");
    	  comboObj.SetMultiSeparator(",");
    	  comboObj.SetDropHeight(170);
    	  if (comboId == "vvd"){
    		  comboObj.SetMultiSelect(1);
        	  comboObj.SetUseEdit(1);
        	  comboObj.SetBackColor("#CCFFFD");
    	  }else if (comboId == "grp_by"){
    		  comboObj.SetMultiSelect(1);
    	  }
    	  
    	  comboObj.SetUseAutoComplete(1);// 편집시 자동 코드 검색 //SetUseAutoComplete is not defined
      }  
      /**
      * 조회조건 입력할 때 처리
      */
//     function obj_KeyUp() {
//	     var formObj=document.form;
//	     var srcName=ComGetEvent("name");
//	     var srcMaxLength=ComGetEven("maxlength");
//	     var srcValue=ComGetEven("value");
//	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
//	     	ComSetNextFocus();
//	     }
//     }
          /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
    		var formObject = document.form;
          	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
              axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
              axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
              axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
              
              axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
              axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
				case "sheet1":      //sheet1 init
				    with(sheetObj){
    			      var HeadTitle1="VVD|BKG\nPOD|Loading Volume|Loading Volume|Loading Volume|Void Slot|Void Slot|Gross\nRevenue|Revenue Class|Revenue Class|Revenue Class|Non-Rev\n(Others)|Revenue Per Box|Revenue Per Box";
    			      var HeadTitle2="VVD|BKG\nPOD|TEU|FEU|TTL(TEU)|20'|40'|Gross\nRevenue|Net|Non Net|MISC|Non-Rev\n(Others)|20'|40'";
    			      var headCount=ComCountHeadTitle(HeadTitle1);
    			      (headCount, 0, 0, true);

    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

    			      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
    			                  { Text:HeadTitle2, Align:"Center"} ];
    			      InitHeaders(headers, info);

    			      var cols = [ 
    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"teu",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"feu",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"ttl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"void_teu",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"void_feu",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"net",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"non_net",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"misc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"non_rev",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"teu_gross",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"feu_gross",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
    			       
    			      InitColumns(cols);
    			      SetSheetHeight(350);
    			      SetEditable(0);
    			      SetMergeCell(0, 7, 2, 1);
    			      SetMergeCell(0, 11, 2, 1);
    			      SetRangeBackColor(1,2,1,6,"#555555");
    			      SetRangeBackColor(1,8,1,10,"#555555");
    			      SetRangeBackColor(1,12,1,13,"#555555");
    			      SetCountPosition(0);
    			    }
                    break;
    				case "sheet2":      //sheet2 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Load Volume|Load Volume|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|20'|40'|TEU|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"20",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"40",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"TEU",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 7, 2, 1);
	    			      SetMergeCell(0, 8, 2, 1);
	    			      SetCountPosition(0);
    			    }
                    break; 
    				case "sheet3":      //sheet3 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|D2|D4|D5|R2|R4|RD2|RD4|S2|S4";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"D2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"D4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"D5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"R2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"R4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"RD2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"RD4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"S2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"S4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 8, 2, 1);
	    			      SetMergeCell(0, 9, 2, 1);
	    			      SetCountPosition(0);
    			    }
                    break;                   
    				case "sheet4":      //sheet4 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Sales Office|Sales Office|Sales Office|Sales Office|Sales Office|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|R/HQ|R/OFC|R/OFC|OFC|OFC|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"RHQ",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ROFC1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ROFC2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"OFC1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"OFC2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 13, 2, 1);
	    			      SetMergeCell(0, 14, 2, 1);
	    			      SetCountPosition(0);
    			      }

                    break;     
    				case "sheet5":      //sheet5 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Rep Commodity|Rep Commodity|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"Name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 10, 2, 1);
	    			      SetMergeCell(0, 11, 2, 1);
	    			      SetCountPosition(0);
    			    }
                    break;     
    				case "sheet6":      //sheet6 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Customer(Shipper)|Customer(Shipper)|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"Code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"Name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 10, 2, 1);
	    			      SetMergeCell(0, 11, 2, 1);
	    			      SetCountPosition(0);
    			    }
                    break;  
    				case "sheet7":      //sheet7 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Customer(Group)|Customer(Group)|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"Code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"Name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 10, 2, 1);
	    			      SetMergeCell(0, 11, 2, 1);
	    			      SetCountPosition(0);
    			    }
                    break;  
    				case "sheet8":      //sheet8 init
    				    with(sheetObj){
	    			      var HeadTitle1="VVD|Lane|Origin|POD|Sales Rep|Sales Rep|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    			      var HeadTitle2="VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ 
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"Name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	    			      SetSheetHeight(350);
	    			      SetEditable(1);
	    			      SetMergeCell(0, 10, 2, 1);
	    			      SetMergeCell(0, 11, 2, 1);
	    			      SetCountPosition(0);
    			    }
                    break;                   
    			case "sheet9":      //sheet9 init
    			    with(sheetObj){
	    		      var HeadTitle1="VVD|Lane|Origin|POD|Inbound Office|Inbound Office|Inbound Office|Inbound Office|Inbound Office|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
	    		      var HeadTitle2="VVD|Lane|Origin|POD|R/HQ|R/OFC|R/OFC|OFC|OFC|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";
	
	    		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	    		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    		      var headers = [ { Text:HeadTitle1, Align:"Center"},
	    		                  { Text:HeadTitle2, Align:"Center"} ];
	    		      InitHeaders(headers, info);
	
	    		      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Origin",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"RHQ",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ROFC1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ROFC2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"OFC1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"OFC2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Load40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"Void40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"TEUTTL",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"Gross",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"PlusVoid",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"EQ",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OFT",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"BAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"CAF",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"OTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DTH",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"DOC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"TAC",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"Other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    		       
	    		      InitColumns(cols);
	    		      SetSheetHeight(350);
	    		      SetEditable(1);
	    		      SetMergeCell(0, 13, 2, 1);
	    		      SetMergeCell(0, 14, 2, 1);
	    		      SetCountPosition(0);
    		    }
                break; 
    			case "sheet10":      //sheet9 init
    		        with(sheetObj){
		                var HeadTitle1="||Booking No.|B/L No.|Lane|T/VVD|POR|POL|POD|DEL|I/O|TEU TTL|TEU TTL|REV TTL|RPB|Shipper|Shipper|S/REP|S/OFC|CGO";
		                HeadTitle1 += "|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type";
		                HeadTitle1 += "|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type";
		                HeadTitle1 += "|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type";
		                HeadTitle1 += "|TOS|1st VVD|On Board|Week|Rep Commodith|Rep Commodith|IB CNT|IB OFC|SVC Mode|SVC Mode";
		                HeadTitle1 += "|Consignee or Notify|Consignee or Notify|OB RHQ|OB GSO|C/OFC|REP|RFA No.|S/C No.|BKG OFC|IB WK POD|IB WK";
		                var HeadTitle2="||Booking No.|B/L No.|Lane|T/VVD|POR|POL|POD|DEL|I/O|BKG|CNTR|(USD)|(TEU)|NAME|CD|S/REP|S/OFC|CGO";
		                HeadTitle2 += "|D2|D4|D5|D7|R2|R4|R5|RD2|RD4|F2|F4|O2|O4|P2|P4|T2|T4|Q2|Q4";
		                HeadTitle2 += "|Rev D2|Rev D4|Rev D5|Rev D7|Rev R2|Rev R4|Rev R5|Rev RD2|Rev RD4|Rev F2|Rev F4|Rev O2|Rev O4|Rev P2|Rev P4|Rev T2|Rev T4|Rev Q2|Rev Q4";
		                HeadTitle2 += "|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Others";
		                HeadTitle2 += "|TOS|1st VVD|On Board|Week|Code|Description|IB CNT|IB OFC|Origin|Dest.";
		                HeadTitle2 += "|Code|Name|OB RHQ|OB GSO|C/OFC|REP|RFA No.|S/C No.|BKG OFC|IB WK POD|IB WK";
		                var headCount=ComCountHeadTitle(HeadTitle1);
		                (headCount, 0, 0, true);
		
		                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"},
		                        { Text:HeadTitle2, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"HidStatus" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"io",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"teu_ttl",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_ttl",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"tot_sum",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpb",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ob_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d5",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"d7",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"r2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"r4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"r5",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rd2",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rd4",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"f2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"f4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"o2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"o4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"p2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"p4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"t2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"t4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"q2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"q4",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_d2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_d4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_d5",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_d7",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_r2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_r4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_r5",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_rd2",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_rd4",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_f2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_f4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_o2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_o4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_p2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_p4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_t2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_t4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_q2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rev_q4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"oft",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"baf",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"caf",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"oth",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dth",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"doc",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"tac",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"r_other",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"frt_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"first_vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_wk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"rep_cmdt_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibs_ofc_nt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ib_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_svc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dst_svc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnnf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cnnf_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rhq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gso",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_srep_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ib_wk_pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ib_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		                 
		                InitColumns(cols);
		                SetSheetHeight(350);
		                SetEditable(1);
		                SetCountPosition(0);
                    }
                    break;
            }
        }
      // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
         function processButtonClick(){
              /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     	         var sheetObject1=sheetObjects[0];
     	         var sheetObject2=sheetObjects[1];
     	         var sheetObject3=sheetObjects[2];
     	         var sheetObject4=sheetObjects[3]; 
     	         var sheetObject5=sheetObjects[4];
     	         var sheetObject6=sheetObjects[5];
     	         var sheetObject7=sheetObjects[6];
     	         var sheetObject8=sheetObjects[7];	         	         
     	         var sheetObject9=sheetObjects[8];
     			 var sheetObject10=sheetObjects[9];
              /*******************************************************/
              var formObj=document.form;
         	try {
         		var srcName=ComGetEvent("name");
                 switch(srcName) {
     		    	case "btn_retrieve":
     		    		/*1.General*/
     		    		if (ComGetObjValue(formObj.rep_knd) == "G"){
     		    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		    		/*2.By Route	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "R"){
     		    			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
     		    		/*3.By E/Q Type	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "E"){
     		    			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
     		    		/*4.By Sales Office	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "O"){
     		    			doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
     		    		/*5.By Rep Commodity*/	
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "C"){
     		    			doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
     		    		/*6.By Shipper Code*/	
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "M"){
     		    			doActionIBSheet(sheetObjects[5],document.form,IBSEARCH);
     		    		/*7.By Group Code	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "P"){
     		    			doActionIBSheet(sheetObjects[6],document.form,IBSEARCH);
     		    		/*8.By Sales Rep	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "S"){
     		    			doActionIBSheet(sheetObjects[7],document.form,IBSEARCH);
     		    		/*9.By I/B Control Office	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "I"){
     		    			doActionIBSheet(sheetObjects[8],document.form,IBSEARCH);
     		    		/*10.Data Download	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "D"){
     		    			doActionIBSheet(sheetObjects[9],document.form,IBSEARCH);
     		    		}
     		        break;
     		    	case "btn_new":    		    		
     		    		ComResetAll();
     		    		clearVvds();
     		    		comboObjects[6].SetSelectIndex(0, false);
     		    		var objs=document.all.item("reportKind");
     		    		for (var i=0 ; i < 10 ; i++){
     		    			if (i == 0){
     		    				objs[i].style.display="Inline";
     		    			}else{
     		    				objs[i].style.display="none";
     		    			}
     		    		}
     		    	break;
     		    	case "btn_excel":
     		    		/*1.General*/
     		    		if (ComGetObjValue(formObj.rep_knd) == "G"){
//     		    			sheetObjects[0].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[0].RowCount() < 1){//no data
     		                   ComShowCodeMessage("COM132501");
     		              }else{
//     		            	sheetObjects[0].SetHeaderBackColor("#CCCCCC");
     		            	sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
//     		            	sheetObjects[0].SetHeaderBackColor("#333333");
     		              }

     		    		/*2.By Route	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "R"){
//     		    			sheetObjects[1].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[1].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[1].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*3.By E/Q Type	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "E"){
//     		    			sheetObjectss[2].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[2].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[2].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*4.By Sales Office	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "O"){
//     		    			sheetObjectss[3].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[3].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[3].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*5.By Rep Commodity*/	
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "C"){
//     		    			sheetObjectss[4].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[4].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[4].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*6.By Shipper Code*/	
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "M"){
//     		    			sheetObjectss[5].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[5].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[5].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*7.By Group Code	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "P"){
//     		    			sheetObjectss[6].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[6].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[6].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*8.By Sales Rep	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "S"){
//     		    			sheetObjectss[7].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[7].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[7].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*9.By I/B Control Office	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "I"){
//     		    			sheetObjectss[8].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[8].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[8].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		/*10.Data Download	*/
     		    		}else if (ComGetObjValue(formObj.rep_knd) == "D"){
//     		    			sheetObjectss[9].Down2Excel({ HiddenColumn:-1});
     		    			if(sheetObjects[9].RowCount() < 1){//no data
      		                   ComShowCodeMessage("COM132501");
      		              }else{
      		                sheetObjects[9].Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:1 });
      		              }
     		    		}
     		        break;
                 } // end switch
         	}catch(e) {
         		if( e == "[object Error]") {
         			ComShowMessage(OBJECT_ERROR);
         		} else {
         			ComShowMessage(e);
         		}
         	}
         }
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
    						case IBSEARCH:      //조회
    							if(!validateForm(sheetObj,formObj,sAction)) return;
	    						sheetObj.SetWaitImageVisible(0);
 								ComOpenWait(true);
	    						formObj.f_cmd.value=SEARCH;   
	    						var xml = sheetObj.GetSearchData("ESM_BKG_0632GS.do",FormQueryString(formObj) );
	    						sheetObj.LoadSearchData(xml, {Sync:1});
	    						ComOpenWait(false);
    						break;
    						case COMMAND01:      // INIT
		 						formObj.f_cmd.value=INIT;   
		 						var searchXml=sheetObj.GetSearchData("ESM_BKG_0632GS.do", FormQueryString(formObj));
	 							var sXml=searchXml.split("|$$|");
	 							/*
	 							comboObjects[0].InsertItem(0, "HNPH0073E",          "HNPH0073E");
	 							comboObjects[0].InsertItem(1, "HNBN0027E",          "HNBN0027E");
	 							comboObjects[0].InsertItem(1, "HNPH0063E",          "HNPH0063E");
	 							comboObjects[0].InsertItem(1, "KMAB0033W",          "KMAB0033W");
	 							comboObjects[0].InsertItem(1, "AEAF0049E",          "AEAF0049E");
	 							comboObjects[0].InsertItem(1, "HNLS0034W",          "HNLS0034W");
	 							*/
	 							//Booking Cargo Type Code
	 							ComBkgXml2ComboItem(sXml[0], bkg_cgo_tp_cd, "val", "desc");
	 							comboObjects[1].index2=0;
	 							//Sales Performance Report Kind Code
	 							//ComBkgXml2ComboItem(sXml[1], formObj.rep_knd, "val", "name");
	 							ComXml2ComboItem(sXml[1], rep_knd, "val", "desc");
	 							//comboObjects[6].index2=0;
	 							//Sales Performance Group By Code
	 							//ComBkgXml2ComboItem(sXml[2], grp_by, "val", "name");
	 							ComXml2ComboItem(sXml[2], grp_by, "desc", "desc");
	 							//Service Mode Code >>> Origin
	 							ComBkgXml2ComboItem(sXml[3], org_svc_mod_cd, "val", "desc");
	 							//Service Mode Code >>> Dest
	 							ComBkgXml2ComboItem(sXml[3], dest_inlnd_svc_mod_cd, "val", "desc");
	 							//Service Route >>> Origin
	 							ComBkgXml2ComboItem(sXml[4], org_rout_cd, "val", "desc");
	 							//Service Route >>> Dest
	 							ComBkgXml2ComboItem(sXml[4], dest_rout_cd, "val", "desc");
	 							
	 							// [Luc Duong] Commented out these lines (S)
//	 							comboObjects[2].DeleteItem("XX"); //org_rout_cd
//	 							comboObjects[2].DeleteItem("YY");
//	 							comboObjects[3].DeleteItem("XX"); //dest_rout_cd
//	 							comboObjects[3].DeleteItem("YY");
	 							// [Luc Duong] Commented out these lines (E)
	 							rep_knd.SetSelectIndex(0);
	 							grp_by.SetMultiSelect(1);
	 						break;
            }
        }
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	if (vvd.GetSelectText()== ''){
        		ComShowCodeMessage("BKG00007");//VVD is not available !    		  
	      	   	formObj.vvd.focus();    		  
	      	   	return false;
        	}        	
            return true;
        }

    	/**
		 * Report Kind OnChange Event
    	 */
//    	function rep_knd_OnChange(comboObj,value,text){
   		function rep_knd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode){
    		var objs=document.all.item("reportKind");
    		form.rep_knd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    		var repKnd="none|none|none|none|none|none|none|none|none|none".split("|");
    		//value = "D";
    		var value = NewCode;
    		if (value == "G"){    			
    			repKnd[0]="Inline";
    		}else if (value == "R"){
    			repKnd[1]="Inline";
    		}else if (value == "E"){
    			repKnd[2]="Inline";
    		}else if (value == "O"){
    			repKnd[3]="Inline";
    		}else if (value == "C"){
    			repKnd[4]="Inline";
    		}else if (value == "M"){
    			repKnd[5]="Inline";
    		}else if (value == "P"){
    			repKnd[6]="Inline";
    		}else if (value == "S"){
    			repKnd[7]="Inline";
    		}else if (value == "I"){
    			repKnd[8]="Inline";
    		}else if (value == "D"){
    			repKnd[9]="Inline";
    		}
    		for (var i=0 ; i < repKnd.length ; i++){
    			objs[i].style.display=repKnd[i];
    		}
    	}
		 /**
		 * VVD Name Upper Event
    	 */
   		var oldVvd="";
    	 function searchLane(vvd) {
    		 if(oldVvd==vvd.value) return;
    		 var formObj=document.form;
			 var sheetObj=sheetObjects[0];
			 if (vvd.value == ""){
				 formObj.slan_cd.value="";
				 formObj.vvd_idx.value="";				 
				 return;
			 }else if (vvd.value.length != 9){
				 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
				 formObj.vvd.focus();
				 return;
			 }			 			
			 formObj.f_cmd.value=SEARCH01;   
			 var searchXml=sheetObj.GetSearchData("ESM_BKG_0632GS.do" , FormQueryString(formObj));
			 if (ComGetEtcData(searchXml,"lane") == "none"){
				 ComShowCodeMessage("BKG00163");//VVD is NOT Registered
				 vvd.focus();
				 return;
			 }
			 
			 formObj.slan_cd.value=ComGetEtcData(searchXml,"lane");
//			 formObj.vvd_idx.value="1";

			 oldVvd = vvd.value;
			 var comboObj=comboObjects[0];
			 formObj.vvd_idx.value= comboObj.GetItemCount()+1; /*vvd_OnChange 안됨*/			 
			 comboObj.InsertItem(-1, vvd.value, vvd.value); 
//	   		 comboObj.SetMultiSelect(1);
//	    	 comboObj.SetUseEdit(1);
//	    	 comboObj.SetMultiSeparator(",");			 
//			 comboObj.SetSelectIndex(comboObj.GetItemCount()-1,false);
	    	 comboObj.SetItemCheck(comboObj.GetItemCount()-1, true, false);
//			 fromObj.vvd.focus();			 
		 }
		 /**
		  * VVD Combo Change Event
	      */
//		 function vvd_OnChange(comboObj,value,text){
//			 var formObj=document.form;
//			 var comIdx=text.split(",");
//			 if (comIdx.length > 1){
//				 formObj.vvd_sig.value="";
//				 formObj.slan_cd.value="";
//				 //formObj.vvd_idx.value=comIdx.length;
//			 }
//		 }
		 
		 /**
	       * VVD Selection Inquiry Popup Open
	      */ 
	      function getVvds(){
	    	  var param=""
	    	  var pWin=ComOpenWindow("/opuscntr/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=395,left=200,top=0");
	      }
	      function clearVvds(){
	    	  vvd.RemoveAll();
		  }
	      /**
		   * VVD Selection Inquiry Popup Value Import
		   */
	      function setVvds(vvds){
			  var formObj=document.form;
	    	  var comboObj=comboObjects[0];
	    	  ComClearCombo(formObj.rpt_nm);	    	  
	    	  var arVvds=vvds.split(",");
	    	  for (var i=0 ; i < arVvds.length ; i++){
	    		  comboObj.InsertItem(-1, arVvds[i], arVvds[i]);
	    	  }
	    	  comboObj.SetSelectText(vvds,false);
	    	  formObj.vvd_sig.value="";
			  formObj.slan_cd.value="";
			  formObj.vvd_idx.value=arVvds.length;
	      }
	/* 개발자 작업  끝 */
