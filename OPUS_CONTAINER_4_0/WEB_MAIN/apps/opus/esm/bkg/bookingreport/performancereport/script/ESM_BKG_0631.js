/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0631.js
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/

 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 		          case "btn_retrieve":
 		        	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
               break;
 		          case "btn_new":
 		        	  ComResetAll();
 		        	  			//sheetObject1.RemoveAll();
               break;
 		          case "btn_downexcel":
 		        	//doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL,"","");
 		        	  if (sheetObject1.RowCount() < 1) {
 		        		 ComShowCodeMessage("COM132501");
 		        	  } else {
 		        		 sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
 		        	  }
 	                break;
               break;
 		          case "btn_print":
 					alert(srcName);
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
 			initControl();	
         	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      function initControl() {
    	  var formObject = document.form;
    	  /* KeyPress Event 받아서 format 변환 */
    	  DATE_SEPARATOR="-";
    	//  var formObject=document.form;axon_event.addListenerFormat('keypress','obj_KeyPress',formObject);
    	  ComSetObjValue(formObject.from_dt,ComGetNowInfo()) // 맨처음 로드시 오늘 날짜로 셋팅
    	  ComSetObjValue(formObject.to_dt,ComGetNowInfo())
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
	 			      var HeadTitle1="| |Week|VVD|Lane Name|1st POL|ETD|BKG QTY";
	
	 			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	 			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	 			      InitHeaders(headers, info);
	
	 			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"HidStatus" },
	 			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	 			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"week",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 			             {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 			             {Type:"Text",      Hidden:0, Width:290,  Align:"Left",    ColMerge:0,   SaveName:"lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pol",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"etd",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	 			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	 			       
	 			      InitColumns(cols);
	 			      SetSheetHeight(440);
	 			      SetEditable(0);
 			     }
                 break;
         }
     }
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         //sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 						case IBSEARCH:      //조회
 							//alert(FormQueryString(formObj));
 							if(!validateForm(sheetObj,formObj,sAction)) return;
 								formObj.f_cmd.value=SEARCH;
 								//var sXml = sheetObj.GetSearchXml("ESM_BKG_0631GS.do",FormQueryString(formObj));
 								sheetObj.DoSearch("ESM_BKG_0631GS.do",FormQueryString(formObj) );
 						break;
 						case IBSAVE:        //저장
 							if(validateForm(sheetObj,formObj,sAction))
 								alert (" Save .. ");
 						break;
 						case IBINSERT:      // 입력
 						break;
         }
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction){
    	 	case IBSEARCH:
    	 		if(ComIsNull(formObj.to_dt)){
    	 			ComShowCodeMessage('BKG08029');
    	 			formObj.from_dt.focus();
    	 			return false;
    	 		}
    	 		if(ComIsNull(formObj.from_dt)){
    	 			ComShowCodeMessage('BKG08029');
    	 			formObj.to_dt.focus();
    	 			return false;
    	 		}  	 		
    	 }
         return true;
     }
	function callDatePop(val){
		var cal=new ComCalendarFromTo();
  		if (val == 'BKG_DATE'){
  			cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd');
		}
	}
	function changedate(val){ 
		var dt=val.value; 
		if(!ComIsDate(dt)){
			ComShowCodeMessage('BKG00921');
			return false;
		}
	}
	/* 개발자 작업  끝 */
 