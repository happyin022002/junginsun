/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0631.js
*@FileTitle : RBC (Revenue Base CCA) Vessel Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.08.26 김태경
* 1.0 Creation
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
     * @extends 
     * @class esm_bkg_0631  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0631() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 		          case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
               break;

 		          case "btn_new":
 		        	  			ComResetAll();
 		        	  			//sheetObject1.RemoveAll();

               break;
                
 		          case "btn_downexcel":
 								sheetObject1.Down2Excel();
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

        sheetObjects[sheetCnt++] = sheet_obj;

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
    	  /* KeyPress Event 받아서 format 변환 */
    	  DATE_SEPARATOR ="-";
    	  
    	  var formObject = document.form;
    	  axon_event.addListenerFormat('keypress','obj_KeyPress',formObject);
    	  ComSetObjValue(formObject.from_dt,ComGetNowInfo()) // 맨처음 로드시 오늘 날짜로 셋팅
    	  ComSetObjValue(formObject.to_dt,ComGetNowInfo())
      }
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 				var sheetID = sheetObj.id;
 				
         switch(sheetID) {
 				case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 440;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     
                     var HeadTitle1 = "| |Week|VVD|Lane Name|1st POL|ETD|BKG QTY";
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,    "HidStatus");
                     InitDataProperty(0, cnt++ , dtSeq,      		 50,    daCenter,  true,    "Seq");
                     InitDataProperty(0, cnt++ , dtData,   		 	 100,   daCenter,  false,   "week",  	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 	 145,   daCenter,  false,   "vvd", 	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 	 290,   daLeft,    false,   "lane",  	false,          "",      dfNone,   0,     false,       true);
                                                               	                                                                       
                     InitDataProperty(0, cnt++ , dtData,       	 	 100,   daCenter,  false,   "pol", 	 	false,          "",      dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 	 100,   daCenter,  false,   "etd", 	 	false,          "",      dfDateYmd,0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,       	 	 40,    daCenter,  false,   "bkg_qty", 	false,          "",      dfNone,   0,     false,       true);


 										CountPosition = 2;
                }
                 break;


         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 						case IBSEARCH:      //조회
 							//alert(FormQueryString(formObj));
 							if(!validateForm(sheetObj,formObj,sAction)) return;
 								formObj.f_cmd.value = SEARCH;
 								//var sXml = sheetObj.GetSearchXml("ESM_BKG_0631GS.do",FormQueryString(formObj));
 								sheetObj.doSearch("ESM_BKG_0631GS.do",FormQueryString(formObj));
 						
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
		var cal = new ComCalendarFromTo();
  		if (val == 'BKG_DATE'){
  			cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd');
		}
	}
	function changedate(val){ 
		var dt = val.value; 
		if(!ComIsDate(dt)){
			ComShowCodeMessage('BKG00921');
			return false;
		}
	}

	/* 개발자 작업  끝 */