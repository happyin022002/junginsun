/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0069.js
*@FileTitle : CSR Approval - CSR Details POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.09 함대성
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
     * @class fns_joo_0069 : fns_joo_0069 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0069() {
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
 var prefix = "sheet1_";
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

             case "btn_Close":
            	 self.close();
                 break;


             } // end switch
     	}catch(e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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

            // alert('document.form.csr_no.value___>'+document.form.csr_no.value);
             
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		

     }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {
            	 ScrollBar = 2;
                 // 높이 설정
                 style.height = 220;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 2, 20, 100);

				 var HeadTitle1 = "Seq.|TC|ACCT #|VNDR #|CTR #|City|Eff.Date|Transaction Amount|Transaction Amount";
				 var HeadTitle2 = "Seq.|Description|Description|Description|Description|Description|Description|VVD|Key Number";
				  										 
				 var headCount = ComCountHeadTitle(HeadTitle1);


                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"seq_num",     false,          "",      dfNone 							  ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"dr_cr_cd",     false,          "",      dfNone 						  ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"acct_cd",     false,          "",      dfNone 							  ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"vndr",     false,          "",      dfNone 							    ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"ctr_cd",     false,          "",      dfNone  							  ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"loc_cd",     false,          "",      dfNone  							  ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"eff_dt",     false,          "",      dfNone  							  ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daRight ,  true,    prefix+"csr_locl_amt",     false,          "",      dfNullFloat, 2   ,false,       false);
                 InitDataProperty(0, cnt++ , dtData,    0,    daRight ,  true,    prefix+"csr_locl_amt",     false,          "",      dfNullFloat, 2   ,false,       false);

                 cnt = 0;

                 InitDataProperty(1,  cnt++ , dtData,    0,    daCenter,  true,    prefix+"seq_num",     false,          "",      dfNone 							,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daLeft,    true,    prefix+"slp_desc",     false,          "",      dfNone  						,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daLeft,    true,    prefix+"slp_desc ",     false,          "",      dfNone 						,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daLeft,    true,    prefix+"slp_desc",     false,          "",      dfNone  						,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daLeft,    true,    prefix+"slp_desc",     false,          "",      dfNone  						,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daLeft,    true,    prefix+"slp_desc",     false,          "",      dfNone  						,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daLeft,    true,    prefix+"slp_desc",     false,          "",      dfNone  						,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daCenter,  true,    prefix+"vvd",     false,          "",      dfNone 									,false,       false);
                 InitDataProperty(1,  cnt++ , dtData,    0,    daRight ,  true,    prefix+"key_no",     false,          "",      dfNone 								,false,       false);

				 FitColWidth("7|5|11|11|11|11|11|11|");
				 DataRowMerge(0) = false;
				 DataRowMerge(1) = false; 

                }
                 break;

  

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //조회
              if(validateForm(sheetObj,formObj,sAction)){
      			formObj.f_cmd.value = SEARCH;
      			//var prefix = "sheet1_";
      			//alert(FormQueryString(formObj));
      			sheetObj.DoSearch("FNS_JOO_0069GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
              }
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
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;

     }


     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {

                 }
              break;

          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {


         var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab= nItem;
 		

     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){  
        	 if(formObj.csr_no.value.length !=20){
        		 return false;
        	 }
        	 if(formObj.gubun[0].value.length == 0 || formObj.gubun[0].value.length == 0){
        		 return false;
        	 }
        	 if(formObj.fr_dt.value.length == 0){
        		 return false;
        	 }
        	 if(formObj.to_dt.value.length == 0){
        		 return false;
        	 }   	 
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }



	/* 개발자 작업  끝 */