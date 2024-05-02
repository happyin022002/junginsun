/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0651.js
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.24 강동윤
* 1.0 Creation
* 2012.03.26 변종건 [CHM-201216730] Split 07-RD 리포트 성능을 위한 개선 요청(PreparedStatement)
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
     * @class ESM_BKG_0651 : ESM_BKG_0651 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0651() {
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
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
                      
                 case "btn_sand":
                	 doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
 					 break;
 					 
                 case "btn_print":
                	 goPrint();
 					 break;

                 case "btn_close":
 					 window.close();
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

 		 doActionIBSheet(sheetObjects[0],document.form,INIT);

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
                     style.height = 100;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(6, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "C/A Office|C/A Issue Staff|C/A Date||";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,    200,     daCenter,  	false,     "corr_ofc_cd",   		false,          "",      dfNone,      	0,    false,		false);
 					 InitDataProperty(0, cnt++ , dtData,	200,     daCenter,   	false,     "corr_usr_id",    		false,          "",      dfNone,      	0,    false,		false);
                     InitDataProperty(0, cnt++ , dtData,    200,     daCenter,  	false,     "corr_dt",   		  	false,          "",      dfNone,      	0,    false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,  200,     daCenter,  	false,     "corr_no",   		  	false,          "",      dfNone,      	0,    false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,  200,     daCenter,  	false,     "bkg_no",   		  		false,          "",      dfNone,      	0,    false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,  200,     daCenter,  	false,     "usr_eml",  		  		false,          "",      dfNone,      	0,    false,		false);


                }
                 break;

             case 2:      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 140;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(3, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "Correction Items|New|Old";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]CRNT_CTNT
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,    200,     daCenter,  	false,     "his_cate_nm",   	false,          "",      dfNone,      	  0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData,	200,     daCenter,   	false,     "crnt_ctnt",    		false,          "",      dfNone,      		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,    200,     daCenter,  	false,     "pre_ctnt",   		false,          "",      dfNone,      		0,     false,		false);


                }
                 break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case INIT:      //
 	        
	         	formObj.f_cmd.value = SEARCH;   
				sheetObj.DoSearch("ESM_BKG_0651GS.do",FormQueryString(formObj));	
         	
            break;
         	
 			case SEARCH:      // 
 				
 				sheetObj.WaitImageVisible = false;
 				ComOpenWait(true);
 					
	 			formObj.f_cmd.value = SEARCH01;   
				sheetObj.DoSearch("ESM_BKG_0651GS.do",FormQueryString(formObj));
				
				ComOpenWait(false);	
 			
            break;
            
 			case COMMAND01:      // 
 				
 				var sheetObj2 = sheetObjects[1];
 				
// 				formObj.usr_eml.value 	= sheetObj.CellValue(sheetObj.SelectRow, "usr_eml");
 				formObj.usr_eml.value 	= "dhhan@itsmt.co.kr";
 				
 				formObj.rd_param.value	= "/rp ['" + sheetObj.CellValue(sheetObj.SelectRow, "bkg_no") + "'] ['" + sheetObj.CellValue(sheetObj.SelectRow, "corr_no") + "'] /riprnmargin";
 				
 				formObj.title.value		= "C/A History List";
 				
 				formObj.content.value	= "C/A History List";
 				
	 			formObj.f_cmd.value = COMMAND01; 
	 				 			
				sheetObj.DoSearch("ESM_BKG_0651GS.do",FormQueryString(formObj));	
 			
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



 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		
 		var formObj = document.form;
 		
 		if (sheetObj.SearchRows > 0){
 			
 			formObj.bkg_no.value  = sheetObj.CellValue(1,"bkg_no");
 			formObj.corr_no.value = sheetObj.CellValue(1,"corr_no");
 			
 			doActionIBSheet(sheetObjects[1],document.form,SEARCH);
 		}
 	}
 	
 	function sheet1_OnClick(sheetObj,Row, Col, Value)
 	{
 		
 		var formObj = document.form;
 			
 		formObj.bkg_no.value = sheetObj.CellValue(Row,"bkg_no");
 		formObj.corr_no.value = sheetObj.CellValue(Row,"corr_no");
 			
 		doActionIBSheet(sheetObjects[1],document.form,SEARCH); 		
 	}
 	
 	/**
     * RD(Report Designer) Print
     */
     function goPrint(){		    			
     	
     	var sheetObj = sheetObjects[0];
     	var formObj = document.form;
     	   	
 		var bkg_no = formObj.bkg_no.value;
     	var ca_no  = formObj.corr_no.value; 			 	   
     	
 	   	var rdPath  = "apps/alps/esm/bkg/bookingcorrection/bdrcorrection/report/ESM_BKG_0182.mrd";
 	    
 	    formObj.com_mrdTitle.value 		= "C/A Detail(s)";
 	    formObj.com_mrdBodyTitle.value 	= "C/A Detail(s)";
 	   	formObj.com_mrdPath.value 		= rdPath;
// 	   	formObj.com_mrdArguments.value 	= "/rp ['" + bkg_no + "'] ['" + ca_no + "'] /riprnmargin";
 	   formObj.com_mrdArguments.value 	= "/rv bkg_no['" + bkg_no + "'] ca_no['" + ca_no + "'] /riprnmargin";

 	   	//ComDebug(formObj.com_mrdArguments.value);
 	   	//alert(formObj.com_mrdArguments.value);
	 	ComOpenRDPopup();
     }


	/* 개발자 작업  끝 */