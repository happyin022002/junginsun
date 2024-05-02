/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1126.js
*@FileTitle : Estimated Pool Chassis Expense Report (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.19 최민회
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
     */

    /**
     * @extends 
     * @class EES_CGM_1126 : EES_CGM_1126 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1126() {
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

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 

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

	            case "btn_close":
					 window.close();
	                 break; 
				
				case "btn_downexcel":
					 sheetObject1.SpeedDown2Excel(-1);
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
      * Sheet 기본 설정  및 초기화
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
         
         initControl(); // chungpa 20100428 초기화 및 init DB 쿼리
     }
      
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.WaitImageVisible = false;
  	     
 		 //
         // 이곳에 initControl을 호출시 ComOpemWaitError발생함.
         //
		 sheetObj.WaitImageVisible = true; 
    }
     
     /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */
    function initControl(){
    	var sheetObj = sheetObjects[0];
    	// Form 객체 선언
    	  formObj = document.form;
        // axon event 등록
       	// axon event 등록

    	// Lease Term Combo Control에  초기값을  설정한다.
    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	
    	//formObj.chss_pool_cd.focus();
      
    }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 280;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                     InitColumnInfo(8, 0, 0, true);

                  // 해더에서 처리할 수 있는 각종 기능을 설정한다

                     var HeadTitle = "Type|Lessor/Pool|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|Lessor/Pool Total";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     var tmp="";
                     var tmp2="";
        
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 2, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData   , 100, daCenter,  true, "chss_pool_tp_cd", false, "", dfNone,      0, false, false);
                     //if(document.form.chss_pool_tp_cd.value== "CP"){
                    //	 InitDataProperty(0, cnt++ , dtData   , 100, daCenter,   false, "chss_pool_cd",    false, "", dfNone,      0, false, false);
                     //} else {
                    	 
                    	 InitDataProperty(0, cnt++ , dtData   , 400, daLeft,   false, "chss_pool_cd",    false, "", dfNone,      0, false, false);
                     //}
                     
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "jan",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "feb",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "mar",             false, "", dfNullFloat, 2, false, false);
                                                                                                                                              
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "apr",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "may",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "jun",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "jul",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "aug",             false, "", dfNullFloat, 2, false, false);
                                                                                                                                              
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "sep",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "oct",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "nov",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "dec",             false, "", dfNullFloat, 2, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight,  false, "total",           false, "", dfNullFloat, 2, false, false);

//                     FrozenCols = 6;
                 }
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case IBSEARCH:      //조회
		       	formObj.f_cmd.value = SEARCH;
			    sheetObj.WaitImageVisible=false;
			 	ComOpenWait(true);
			    var sXml = sheetObj.DoSearch("EES_CGM_1126GS.do" , FormQueryString(formObj)); 
			    sheetObj.LoadSearchXml(sXml);
			    ComOpenWait(false);
             break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

     /**
      * Sheet1 의 OnSearchEnd 이벤트처리 <br>
      * @param  {object} sheetObj	필수	 Sheet Object
      * @param  {string} ErrMsg		필수 String
      * @return 없음
      * @version 2009.07.16
      * @author 조재성
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
     	with(sheetObj)
     	{
   			ShowSubSum("chss_pool_tp_cd", "2|3|4|5|6|7|8|9|10|11|12|13|14",-1, false, false, -1,"chss_pool_tp_cd=;chss_pool_cd=Sub Total");
     	}
     }
      
	  /**
	   * 콜백 함수. <br>
	   * Total display 
	   * @param  {Object} sheetObj		필수	 SheetObj
	   * @param  {Int} row				필수 선택한 Row
	   * @return 없음
	   * @author 조재성
	   * @version 2009.10.01
	   */ 
	  function sheet1_OnChangeSum(sheetObj, Row)
	  {
	  	with(sheetObj)
	  	{
	  		SumText(0, "chss_pool_tp_cd") = "";
	  		SumText(0, "chss_pool_cd") = "Grand Total";
	  		
	  		CellAlign(Row, "chss_pool_tp_cd") = daCenter;
	  	}
	  }      
	/* 개발자 작업  끝 */