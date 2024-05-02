/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1142.js
*@FileTitle : Pool Chassis Comparison Detailed
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.05 최민회
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
     * @class EES_CGM_1142 : EES_CGM_1142 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1142() {
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
 				
     }
      
      /**
       * 
       * @param sheetObj
       * @return
       */
      function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.WaitImageVisible = false;
          
   	     
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
          
 		 sheetObj.WaitImageVisible = true; 
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
                     style.height = 310;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 6, 100);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(17, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false) 
                     
                      
                     var HeadTitle1 = "||||||SML|SML|SML|SML|SML|MGMT|MGMT|MGMT|MGMT|MGMT|";
                     var HeadTitle2 = "||Matching|Chassis No|Owner|CNTR No|On-Hire Date|On-Hire Yard|Off-Hire Date|Off-Hire Yard|Used Days|On-Hire Date|On-Hire Yard|Off-Hire Date|Off-Hire Yard|Used Days|Units";
                                                                       				
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  40, daCenter, false, "HidStatus");                                                   
                     InitDataProperty(0, cnt++ , dtHidden,        35, daCenter, false, "mst",                       false, "", dfNone,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,          90, daCenter, true , "matching",                  false, "", dfNone,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,         100, daCenter, true , "chss_no",                   false, "", dfNone,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,          75, daCenter, true , "chss_ownr_co_cd",           false, "", dfNone,    0, true,true);
                                                                                                                                                       
                     InitDataProperty(0, cnt++ , dtData,         115, daCenter, true , "cntr_no",                   false, "", dfNone,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,         140, daCenter, false, "hjs_onhdt",                 false, "", dfUserFormat2,    0, false,true);
                     InitDataProperty(0, cnt++ , dtData,          80, daCenter, false, "hjs_onhyd",                 false, "", dfNone,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,         140, daCenter, false, "hjs_offhdt",                false, "", dfUserFormat2,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,          90, daCenter, false, "hjs_offhyd",                false, "", dfNone,    0, true,true);
                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       90, daCenter, false, "hjs_usdy",                  false, "", dfInteger,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,          140, daCenter, false, "mgmt_onhdt",                false, "", dfUserFormat2, 0, true,true);
                     InitDataProperty(0, cnt++ , dtData,         145, daCenter, false, "mgmt_onhyd",                false, "", dfNone,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,          140, daCenter, false, "mgmt_offhdt",               false, "", dfUserFormat2,    0, true,true);
                     InitDataProperty(0, cnt++ , dtData,          80, daCenter, false, "mgmt_offhyd",               false, "", dfNone, 0, true,true);
                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       80, daCenter, false, "mgmt_usddys",               false, "", dfInteger, 0, true,true);
                     InitDataProperty(0, cnt++ , dtHidden,        75, daCenter, false, "pool_unit",                 false, "", dfInteger, 0, false,false);
                     
                     InitUserFormat2(0, "hjs_onhdt", "####-##-## ##:##:##", "-|:" );
                     InitUserFormat2(0, "hjs_offhdt", "####-##-## ##:##:##", "-|:" );
                     InitUserFormat2(0, "mgmt_onhdt", "####-##-## ##:##:##", "-|:" );
                     InitUserFormat2(0, "mgmt_offhdt", "####-##-## ##:##:##", "-|:" );
//                     ColHidden(10) = true;
//                     ColHidden(15) = true;
                 
                }
                 break;         	

         }
     }
      
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
   	{
    
   		with(sheetObj)
   		{
//   			ShowSubSum(3, "8|13",-1, true, false, 0, "matching=%s;hjs_chss_mvmt_dt=S.Total  by SML;pool_chss_mvmt_dt=S.Total by MGMT");
//   			ShowSubSum(1, "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "vndr_seq=Sub Total");
   		}	
   	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
 					    formObj.f_cmd.value = SEARCH;
 					    
 	 				    queryString = "f_cmd=" + SEARCH ;
 	 				  var params = FormQueryString(formObj);
//	 	 				var sXml = sheetObj.GetSearchXml("EES_CGM_1142GS.do" , FormQueryString(formObj));
//	 	 	     		sheetObj.LoadSearchXml(sXml);
 	 				  sheetObj.WaitImageVisible=false;
  			 	      ComOpenWait(true);
 	 				  sheetObj.DoSearch("EES_CGM_1142GS.do",  params);
// 	 				    var sXml = sheetObj.GetSearchXml("EES_CGM_1142GS.do" , FormQueryString(formObj));
// 	 				    sheetObj.LoadSearchXml(sXml);
 	 				    
// 	 				  sheetObj.SumText(0,6)  = "G.Total by SML";
// 	 				  sheetObj.SumText(0,9)  = "("+sheetObj.SumText(0,10)+") Units";
// 	 				  sheetObj.SumText(0,11) = "G.Total by MGMT";
// 	 				  sheetObj.SumText(0,14) = "("+sheetObj.SumText(0,15)+") Units";
// 	                  sheetObj.SumText(0,"matching")   = "";
  			 	      ComOpenWait(false);
 						//		
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

 		
 		

	/* 개발자 작업  끝 */