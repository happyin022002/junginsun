/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1010.js
*@FileTitle : On & Off-Hire Status Detailed Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.29 최민회
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.13 신혜정 [CHM-201115037-01] Location 'USNYC' default 셋팅 
*                                      조회기간 시작일: 당해연도 1/1일. 종료일을 오늘일자로 default 셋팅  
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
     * @class EES_CGM_1010 : EES_CGM_1010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1010() {
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
 
 var comboObjects = new Array();
 var comboCnt = 0;
 var comboObjects2 = new Array();
 var comboCnt2 = 0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 var IBSEARCH02 = 30;
 var IBSEARCH03 = 31;
 
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          var formObject = document.form;
          var agmt_lstm_cd  = document.agmt_lstm_cd.Text;
          

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

                 case "btn_new":
                	 objectClear();
                	 if(formObject.str_gubun[0].checked){
                		 sheetObject1.RemoveAll();
                	 }
                	 else if (formObject.str_gubun[1].checked)
                	 {
                		 sheetObject2.RemoveAll();
                	 }
                	 
                     break; 

                 case "btn_retrieve":
// 							
//                	 ComShowMessage(formObject.str_gubun[0].checked);
//                	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                	 if(formObject.str_gubun[0].checked){
                		 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                	 }
                	 else if (formObject.str_gubun[1].checked)
                	 {
                		 doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                	 }
                     break;
                      
                 case "btn_downexcel":
                	 if(formObject.str_gubun[0].checked){
                		 sheetObject1.SpeedDown2Excel();
                	 }
                	 else if (formObject.str_gubun[1].checked)
                	 {
                		 sheetObject2.SpeedDown2Excel();
                	 }
                     break;                   

                 case "btn_print":
                	 
                	 if(formObject.str_gubun[0].checked){
       					if( sheetObjects[0].rowcount==0 ) {
     						errMsg = 'No data found.';
     						ComShowMessage(msgs["CGM10012"]);
     						return;
     					}
     					formObject.f_cmd.value = IBSEARCH02;
     					ComOpenPopupWithTarget('/hanjin/EES_CGM_1011.do?pgmNo=EES_CGM_1011', 775, 800, "", "0,1,1,1,1,1,1", true);
                	 }
                	 else if (formObject.str_gubun[1].checked)
                	 {
       					if( sheetObjects[1].rowcount==0 ) {
     						errMsg = 'No data found.';
     						ComShowMessage(msgs["CGM10012"]);
     						return;
     					}
     					formObject.f_cmd.value = IBSEARCH03;
     					ComOpenPopupWithTarget('/hanjin/EES_CGM_1013.do?pgmNo=EES_CGM_1013', 775, 800, "", "0,1,1,1,1,1,1", true);
                	 }
                	 
                	 

					break;
                     
                 case "ComOpenPopupWithTargetYard":
                	//chungpa 20100415 new yard popup start
         			//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
         			ComOpenPopup("/hanjin/EES_LSE_0101.do", 800, 450, "setPopData_AvailYard", '1,0', true, false);//, Row, Col, 0);
         			//chungpa 20100415 new yard popup end          			
          			title_chk();
          			break;
          			
                 case "ComOpenPopupWithTargetLocation":
                	var tmp = formObject.location.text;
                	if(tmp == "RCC")
                	{
                		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                	}else if(tmp == "LCC")
                	{
                		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                	}else if(tmp == "SCC")
                	{
                		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                	}
          			
          			break;
          			
                 case "ComOpenPopupWithTargetKind":
           			if(formObject.kind.value=="L"){
           				ComOpenPopup('/hanjin/COM_ENS_0C1.do?pgmNo=COM_ENS_051', 700, 455, "setProgramNo", "0,1,1,1,1,1", true, false);
           			}
           			else
           			{
           				ComOpenPopup('/hanjin/EES_CGM_1117.do?pgmNo=EES_CGM_1117', 820, 420, "setProgramNo", "0,1,1,1,1,1", true, false);
           			}
           			break;
           			
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal = new ComCalendar();
	 				cal.select(formObject.evnt_dt_str, "yyyy-MM-dd");
	 				break;
	 					
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
//	 				var cal = new ComCalendar();
		 			var cal = new ComCalendarFromTo();
		            cal.select(form.evnt_dt_str,  form.evnt_dt_end,  'yyyy-MM-dd');
//	 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
     * New Yard Code Pop-up Return Value 처리 부분<br>
     * chungpa 20100415 new yard popup
     */
    function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
    	var formObj = document.form;
    	if(aryPopupData.length > 0) {
    		formObj.sts_evnt_yd_cd.value = aryPopupData[0][4]; //Yard
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
          // IBMultiCombo 초기화
         	comboObjects[comboCnt++] = document.agmt_lstm_cd;
         	comboObjects[comboCnt++] = document.location;
          	for(var k=0;k<comboObjects.length;k++){
      	        initCombo(comboObjects[k]);
     	    }  
            
//          	comboObjects2[comboCnt2++] = document.location;
//          	for(var k=0;k<comboObjects2.length;k++){
//      	        initCombo(comboObjects2[k]);
//     	    }  
          	
           //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
 

     }
      
      /**
       * 
       * @param sheetObj
       * @return
       */
      function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.WaitImageVisible = false;
          formObj = document.form;
          // axon event 등록
          axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',	formObj);
          //axon_event.addListener('change', 'obj_change' , 'scc_cd', 'sts_evnt_yd_cd','eq_aset_sts_cd','kind'   ); 
          axon_event.addListener('change', 'obj_change' , 'eq_aset_sts_cd','kind'   ); 
          axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
          
          initControl(sheetObjects[0]);  
          sheetObj.WaitImageVisible = true; 
     }
      
      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  {object} sheetObj	필수
       * @return 없음
       * @author 최민회
       * @version 2009.05.20
       */
      function initControl(sheetObj){
      	// Form 객체 선언
      	  formObj = document.form;
          // axon event 등록
          
       // Lease Term Combo Control에  초기값을  설정한다.
//          doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//          doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
      	
      	  doActionIBSheet(sheetObjects[0], document.form, IBRESET);
          
          //formObj.agmt_lstm_cd.text ='ALL'; // chungpa 20100405 combo 변경 single => multi
          formObj.location.text ='RCC';
          formObj.scc_cd.value = "USNYC"; // USNYC default 셋팅 
          // 초기 focus
          formObj.evnt_dt_str.focus();
        
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
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     if(document.form.kind.value == "L"){
                    	 tmp = "Lessor";
                     }else{
                    	 tmp = "Agreement No. ";
                     }
                    	 
                     
                     var HeadTitle = "|Location|Term|"+tmp+"|Total|SF2|SL2|TA2|SF4|GN4|GN5|CB4|EG5|EG8|ZT4";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false) 

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                    	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                       InitDataProperty(0, cnt++ , dtHiddenStatus,	120,	daCenter,		false,		"agreement");
                	  InitDataProperty(0, cnt++ , dtHidden,	0,	daCenter,		false,		"agreement");
                      InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		false,		"sts_evnt_loc_cd",  		false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"agmt_lstm_cd",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		false,		"vndr_seq",   	false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,		        90,		daRight,		false,		"total",    	false,          "",      dfNone,      	0,     false,       false);
  										
                      InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"sf2",   			false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"sl2",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"ta2",   			false,          "",      dfNone,  			0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"sf4",   			false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"gn4",    		false,          "",      dfNone,      	0,     false,       false);
  										
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"gn5",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"cb4",   			false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"eg5",   			false,          "",      dfNone,   		  0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"eg8",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,		     	65,		daRight,		false,		"zt4",   			false,          "",      dfNone,  			0,     false,       false);
                      
                      
                      MessageText("Sum") = "Grand Total";


                }
                 break;
             case 2:      //sheet2 init
             with (sheetObj) {
                 // 높이 설정
              // 높이 설정
                 style.height = 390;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
   
                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 6, 100);
                 
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(11, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false) 
                 if(document.form.kind.value == "L"){
                	 tmp = "Lessor";
                 }else{
                	 tmp = "Agreement No. ";
                 }
                 
                 if(document.form.eq_aset_sts_cd.value == "LSO"){
                	 tmp2 = "Off-hire";
                 }else{
                	 tmp2 = "On-hire";
                 }
                  
                 var HeadTitle = "No.|Chassis No.|"+tmp+"|Type/Size|Term|"+tmp2+"|LCC|SCC|Yard|Event Date|System Date";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);


                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtDataSeq,   40, daCenter, false,   "No",   	        false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData, 100, daCenter, false,   "eq_no",           false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData, 100, daCenter, false,   "vndr_seq",        false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData,  90, daCenter, false,   "eq_tpsz_cd",      false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData,  60, daCenter, false,   "agmt_lstm_cd",    false, "", dfNone, 0, false, false);
                                                                                                                                    
                 InitDataProperty(0, cnt++ ,    dtData,  80, daCenter, false,   "sts_evnt_dt",     false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData,  80, daCenter, false,   "lcc_cd",          false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData,  80, daCenter, false,   "scc_cd",          false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData,  80, daCenter, false,   "sts_evnt_yd_cd",  false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++ ,    dtData, 130, daCenter, false,   "evnt_dt",         false, "", dfNone, 0, false, false);
                 
                 InitDataProperty(0, cnt++ ,    dtData, 100, daCenter, false,   "upd_dt",          false, "", dfNone, 0, false, false);


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
		    	 var params = FormQueryString(formObj);
				 formObj.f_cmd.value = SEARCH;
//				 queryString = "f_cmd=" + SEARCH ;
				 if(formObj.str_gubun[0].checked)
				 {
					 sheetObj.WaitImageVisible=false;
			 	     ComOpenWait(true);
		             sheetObj.DoSearch("EES_CGM_1010GS.do",  params);
		              
		// 	                 sheetObj.SumText(1,"")= "";
		//	 	             
		// 	                 sheetObj.SumText(0,3) = "Grand Total";
		// 	                 sheetObj.SumText(0,"sts_evnt_loc_cd")        = "";
		// 	                 sheetObj.SumText(0,"Month")="Grand Total";
		            
		             ComOpenWait(false);
				 }
				 else
				 {
		             sheetObj.DoSearch("EES_CGM_1010GS.do",  params);
				 }
		      }
		         break;
		   case IBSEARCH_ASYNC01:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
		  		MakeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0);
		       	break;
		   case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
			   /*	formObj.f_cmd.value = COMMAND01;
			   	formObj.ofc_cd.value = formObj.scc_cd.value;
			   	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Office');
			   		formObj.sts_evnt_ofc_cd.value = "";
			   		formObj.sts_evnt_ofc_cd.focus();
			   	}
			   	*/
			   	break;
		   case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
			   	formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value = formObj.sts_evnt_yd_cd.value;
			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.sts_evnt_yd_cd.value = "";
			   		formObj.sts_evnt_yd_cd.focus();
			   	}
			   	break;
		  case IBSEARCH_ASYNC04:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
		  			MakeComboObject2(formObj.location, arrStr, 0, 0);
		       	break;
			case IBSEARCH_ASYNC05:	// ( location)조회
				   	formObj.f_cmd.value = SEARCH;
				   	formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
					var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
						    			
					// 데이터 건수
				    var dataCount = ComGetTotalRows(sXml);
				    if(dataCount==0){
				    	ComShowCodeMessage('CGM10009','location cd');
				   		formObj.scc_cd.value = "";
				   		formObj.scc_cd.focus();
				    }
					break;
					
		  case IBSEARCH_ASYNC08:
		    	formObj.f_cmd.value = SEARCH17;
		    	var location = formObj.location.text;
		    	
		    	if(location == "RCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "RCC";
		    		formObj.eq_orz_cht_rcc_cd.value = formObj.scc_cd.value;
		    	}else if(location == "LCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "LCC";
		    		formObj.eq_orz_cht_lcc_cd.value = formObj.scc_cd.value;
		    	}else if(location == "SCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "SCC";
		    		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
		    	}else
		    	{
		    		formObj.eq_orz_cht_chktype.value = "";
		    		formObj.eq_orz_cht_scc_cd.value = "";
		    	}
		 		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		// 데이터 건수
		        var dataCount = ComGetTotalRows(sXml);
		        if(dataCount==0){
		        	ComShowCodeMessage('CGM10009','location cd');
			   		formObj.scc_cd.value = "";
			   		formObj.scc_cd.focus();
		        }
		  	    break;	
		  case IBRESET:
		 		var idx = 0
		 		var sXml2 = document.form2.sXml.value;
		 		var arrXml = sXml2.split("|$$|");
		
		 		//agmt_lstm_cd
		 		if ( arrXml[idx] == null ) {return;}
		 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
		 	    var arrStr1 = new Array();
		 		for ( var i = 0; i < vArrayListData.length; i++) {
		 		    vListData = vArrayListData[i];
		 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		 		}
		 		// combo control, 결과 문자열, Text Index, Code Index
			  	MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0);
		 		idx++;       
		 		
		 		if ( arrXml[idx] == null ) {return;}
		 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
		 	    var arrStr1 = new Array();
		 		for ( var i = 0; i < vArrayListData.length; i++) {
		 		    vListData = vArrayListData[i];
		 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		 		}
		 		// combo control, 결과 문자열, Text Index, Code Index
			  	MakeComboObject2(formObj.location, arrStr1, 0, 0);
		 		idx++;       
		 		
		 		formObj.evnt_dt_str.value = ComGetNowInfo("yy") + "0101";	// Period
		 		formObj.evnt_dt_end.value = ComGetNowInfo("ymd");	// Period
		 		
		 		break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	 with(formObj){
    		 switch(sAction) {
    		 	case IBSEARCH:
    		 		location.value  = location.text;
    		 		 
    		 		if(evnt_dt_str.value == ''){
           				ComShowCodeMessage('CGM10004','Period ');
           				evnt_dt_str.focus();
           				
           				return false;
           			}	
    		 		if(evnt_dt_end.value == ''){
           				ComShowCodeMessage('CGM10004','Period ');
           				evnt_dt_end.focus();
           				
           				return false;
           			}
    		 		 var dt_str = ComReplaceStr(document.form.evnt_dt_str.value,"-","");
        			 var dt_end = ComReplaceStr(document.form.evnt_dt_end.value,"-","");
    	        	
  
    	    		if(dt_str != '' && dt_end != ''){
    	    			if(dt_end < dt_str){
    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
    	    				evnt_dt_str.value='';
    	    				
    	    				evnt_dt_str.focus();
    	    				return false;
    	    			}
    	    		}
    	    		
    		 		if(location.value == ''){
           				ComShowCodeMessage('CGM10004','location ');
           				location.focus();
           				
           				return false;
           			}
    		 		if(scc_cd.value == ''){
           				ComShowCodeMessage('CGM10004','scc_cd');
           				scc_cd.focus();
           				
           				return false;
           			}
    		 		if(scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
           				scc_cd.focus();
           				
           				return false;
           			}
    		 		if(sts_evnt_yd_cd.value!= '' && sts_evnt_yd_cd.value.length !=7){
    		 			ComShowCodeMessage('CGM10044','Yard(7)');
           				scc_cd.focus();
           				
           				return false;
           			}
           			break;
    		 }      
    	 }

         return true;
     }


//
// 	function sheet1_OnChangeSum(sheetObj, Row )
// 	{
// 		with(sheetObj)
// 		{
// 			SumText(0,"Office") = "";
// 			SumText(0,"Lessor") = "Grand Total";
// 			CellAlign(LastRow, "Lessor") = daCenter;
// 		}
// 	} 
 	
 	
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
  
 		with(sheetObj)
 		{
 			ShowSubSum(1, "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "vndr_seq=Sub Total");
// 			ShowSubSum(1, "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "vndr_seq=Sub Total");
 		}	
 	}
// 	
  	/** 
    * Object 의 Keypress 이벤트에 대한 처리  <br>
    * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
    * @param  없음
    * @return 없음
    * @author 최민회
    * @version 2009.05.20
    */ 
   function obj_keypress(){
  	 obj = event.srcElement;
  	 if(obj.dataformat == null) return;
  	 	
  	 window.defaultStatus = obj.dataformat;
  	 switch(obj.dataformat) {
  	 	case "ymd":
  	 		ComKeyOnlyNumber(obj);
  	        break;
  	    case "eng":
  	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
  	        else ComKeyOnlyAlphabet('upper');
  	        break;
  	    case "engup":
  	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
  	        else ComKeyOnlyAlphabet('upper');
  	        break;
  	    
  	 }
  	 
  	 
   }
   
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */
    function obj_deactivate(){
   	 var formObj = document.form;
   	 obj = event.srcElement;
     
   	 if(obj.name=="evnt_dt_str"  ){
       			
   		 with(formObj){
	        			
   			 var creDtFr = ComReplaceStr(evnt_dt_str.value,"-","");
	        }
	        	
	        ComChkObjValid(event.srcElement);
       }
     	if(obj.name=="evnt_dt_end"  ){
			
  		 with(formObj){
	        			
  			 var creDtFr = ComReplaceStr(evnt_dt_end.value,"-","");
	        }
	        	
	        ComChkObjValid(event.srcElement);
      }
       	
    }
    
    /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */  
    function obj_change(){
    	 var formObj = document.form;
    	 var sheetObj  = sheetObjects[0]; 
    	 var sheetObj2 = sheetObjects[1]; 
    	 obj = event.srcElement;
    	 switch(obj.name){
    	   case "kind":
    		    formObj.vndr_seq.value='';
    		    Grid_Remove();
    		    if(formObj.kind.value=="L") {
    		    	sheetObj.cellValue(0, 3)  = "Lessor";
    		    	sheetObj2.cellValue(0, 2) = "Lessor";
    		    } else {
    		    	sheetObj.cellValue(0, 3)  = "Agreement No.";
    		    	sheetObj2.cellValue(0, 2) = "Agreement No.";
    		    }
    	 		break;    	 	
    	   case "eq_aset_sts_cd":
	   		    if(formObj.eq_aset_sts_cd.value=="LSO") {
			    	sheetObj2.cellValue(0, 5) = "Off-hire";
			    } else {
			    	sheetObj2.cellValue(0, 5) = "On-hire";
			    }
	    	    Grid_Remove();
		 		break;    	
    	   case "sts_evnt_yd_cd":
    	 		if(formObj.sts_evnt_yd_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	 		}
    	 		break;
	 		case "scc_cd":
    	 		if(formObj.scc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
    	 		}
    	 		break;
    	 }   
    }
     
     
    /**
      * YA_CD 값 체크
      * @return
      */
     function obj_keyup(){
	    	 var formObj = document.form;
	    	 var sheetObj = sheetObjects[0];
	    	 obj = event.srcElement;
	    	 switch(obj.name){
	    	 	case "sts_evnt_yd_cd":
		    	    var sts_evnt_yd_cd;
	    	    	frmObj = document.form;
	    	    	//alert("sss");
	    	    	sts_evnt_yd_cd = frmObj.sts_evnt_yd_cd.value;
	    	    	if (sts_evnt_yd_cd.length == 7) {
	    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	    	}
	    	    	title_chk();
	    	    	break;
	     	 	case "scc_cd":
	    	 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
	    	   		var arrCrntLocCd = crntLocCd.split(",");
	    	   		
	    	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	    	   		// 입력오류 체크 (예> ,,)
	    	 			if(arrCrntLocCd[i] == ''){
	    	 				ComShowCodeMessage('CGM10009','Location');
	    	 				formObj.scc_cd.value = "";
	    	 				ComSetFocus(formObj.scc_cd);
	    	 				break;
	    	 			}else{
	    	    	 		//if(formObj.scc_cd.value != ''){
	    	    	 		if(formObj.scc_cd.value.length == 5){
	    	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
	    	    	 		}
	    	    	 	}
	    	 		}
	    	 		break;
	    	 }
	    }
     
     function  Grid_Remove()
     {
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];  
  	     var sheetObj2 = sheetObjects[1];
	  	 if(formObj.str_gubun[0].checked){
	  		 sheetObj.RemoveAll();
//	  		ComShowMessage("1");
	  	 }
	  	 else if (formObj.str_gubun[1].checked)
	  	 {
	  		sheetObj2.RemoveAll();
//	  		ComShowMessage("2");
	  	 }   	
	  	 
     }
     /** 
      * location 의 change 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */    
     function location_OnChange()
     {
    	   var sheetObj = sheetObjects[0];  
	   	   if(document.form.location.Code=="S")
	   	   {
	           sheetObj.cellValue(0, 1)  = "Yard";
	   	   } else {
	   		   sheetObj.cellValue(0, 1)  = "Location";
	   	   }
	   	   document.form.scc_cd.value = "";
    	  Grid_Remove();
     }
     
     /** 
     * agmt_lstm_cd_OnChange 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */    
     function agmt_lstm_cd_OnChange()
     {
    	 
    	 Grid_Remove();
     }
     
     /**
      * programNo 입력부분. <br>
      * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
      * @param  {Array} aryPopupData	필수	 Array Object
      * @param  {Int} row				필수 선택한 Row
      * @param  {Int} col				필수 선택한 Column
      * @param  {Int} sheetIdx			필수 Sheet Index
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */   
     function setProgramNo(aryPopupData, row, col, sheetIdx){
     	 
    	 var formObj = document.form;
     	 var vndrSeq = "";
     	 var vndrNm = "";
     	 var i = 0;
//     	 ComShowMessage('setProgramNo'+aryPopupData.length);
     	 for(i = 0; i < aryPopupData.length; i++){
     		 vndrSeq = vndrSeq + aryPopupData[i][2];
     		
     		/* if(aryPopupData.length == 1){
     			 vndrNm = vndrNm + aryPopupData[i][4];
     		 }*/
     		 
     		 if(i < aryPopupData.length - 1){
     			 vndrSeq = vndrSeq + ",";
     		 }
//     		ComShowMessage('vndrSeq=='+vndrSeq);
     	 }
     	 
     	  formObj.vndr_seq.value = vndrSeq;
     	 
     	 
     }
      
      /** 
       * Combo Object 초기화  <br>
       * @param  {object} comboObj	필수 Combo Object
       * @return 없음
       * @author 최민회
       * @version 2009.05.25
       */ 
      function initCombo(comboObj) {
       	switch(comboObj.id) {
    	       case "agmt_lstm_cd":
    	    	    // chungpa 20100405 combo 변경 single => multi start
	   	 	 		var cnt=0;
	   	  	        with(comboObj) {
	   	  	        	Code = "";
	   	  	            Text = "";
	   	  	            DropHeight = 180;
	   	  	            MultiSelect = true;
	   	  	            MaxSelect = 100;	    
	   	  	            UseCode = true;
	   	  	            Enable = true;
	     	            
		   	            ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
		   	            IMEMode = 0;            // 영문
		   	            MaxLength = 20;         // 100자까지 입력
	   	  	       }
   	  	        
    	    	   /*
    	           var cnt=0;
    	           with(comboObj) {
    	            	Code = "";
    	            	Text = "";
    	            	DropHeight = 100;
    	            	MultiSelect = false;
    	            	MaxSelect = 1;	    
    	            	UseCode = true;
    	            	Enable = true;
    	            	comboObj.UseAutoComplete = true;
    	           }*/
    	           // chungpa 20100405 combo 변경 single => multi end
    	           break;
    	       case "location":
    	           var cnt=0;
    	           with(comboObj) {
    	            	Code = "";
    	            	Text = "";
    	            	DropHeight = 100;
    	            	MultiSelect = false;
    	            	MaxSelect = 1;	    
    	            	UseCode = true;
    	            	Enable = true;
    	            	comboObj.UseAutoComplete = true;
    	            }
    	            break;
    	    }
    	} 
       
      /** 
       * Combo Object 에 값을 추가하는 처리 <br>
       * @param  {object} cmbObj	필수 Combo Object
       * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
       * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
       * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
       * @return 없음
       * @author 최민회
       * @version 2009.05.20
       */ 
      function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
      	cmbObj.RemoveAll();
      	
        // chungpa 20100405 combo 변경 single => multi start
      	for (var i = 0; i < arrStr.length;i++ ) {
      		var arrCode = arrStr[i].split("|");
      		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
      	}
      	
      	/*
      	cmbObj.InsertItem(0,"ALL","");
      	for (var i = 0; i < arrStr.length;i++ ) {
      		var arrCode = arrStr[i].split("|");
      		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
      	}
      	cmbObj.Index2 = "" ;
      	*/
        // chungpa 20100405 combo 변경 single => multi end
      }
       
       /** 
        * Combo Object 에 값을 추가하는 처리 <br>
        * @param  {object} cmbObj	필수 Combo Object
        * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
        * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
        * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */ 
       function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
       	cmbObj.RemoveAll();
//       	cmbObj.InsertItem(0,"","");
       	for (var i = 0; i < arrStr.length;i++ ) {
       		var arrCode = arrStr[i].split("|");
       		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
            	}
//       	cmbObj.Index2 = "" ;
       }
       
       /**
        * 기본 오브젝트 초기화 
        */
       function objectClear(){
	       	var formObj = document.form;
	       	var sheetObject  = sheetObjects[0];
	       	var sheetObject1 = sheetObjects[1];
	       	//IBMultiCombo 초기화
	//       	
	       	formObj.location.Code = "";
	       	formObj.agmt_lstm_cd.Code = "";
	       	if(formObj.str_gubun[0].checked== true)
	       	{
	       		formObj.reset();
	       		formObj.str_gubun[0].checked = true;
	       	}
	       	else
	       	{
	       		formObj.reset();
	       		formObj.str_gubun[1].checked = true;
	       	}
//       	formObj.eq_spec_no.Code = "";
			//formObj.agmt_lstm_cd.text ='ALL'; // chungpa 20100405 combo 변경 single => multi
			formObj.location.text ='RCC';
			formObj.scc_cd.value = "USNYC"; // USNYC default 셋팅 
	 		formObj.evnt_dt_str.value = ComGetNowInfo("yy") + "0101";	// Period
	 		formObj.evnt_dt_end.value = ComGetNowInfo("ymd");	// Period
       }
        
 
       function chk(a)
       {
    	   var objs = document.all.item("tabLayer");
    	   var sheetObj = sheetObjects[0];  
    	   var sheetObj2 = sheetObjects[1];   
    	   if(a=="1")
    	   {
    		   objs[1].style.display = "none";
	           objs[0].style.display = "Inline";
	           sheetObj.RemoveAll();
	           if(formObj.kind.value=="L") {
   		    		sheetObj.cellValue(0, 3)  = "Lessor";
   		    		sheetObj2.cellValue(0, 2) = "Lessor";
	   		    } else {
	   		    	sheetObj.cellValue(0, 3)  = "Agreement No.";
	   		    	sheetObj2.cellValue(0, 2) = "Agreement No.";
	   		    }
    	   }
    	   else
    	   {
    		   objs[0].style.display = "none";
	           objs[1].style.display = "Inline";
	           sheetObj2.RemoveAll();
	           if(formObj.kind.value=="L") {
   		    		sheetObj.cellValue(0, 3)  = "Lessor";
   		    		sheetObj2.cellValue(0, 2) = "Lessor";
	   		   } else {
	   		    	sheetObj.cellValue(0, 3)  = "Agreement No.";
	   		    	sheetObj2.cellValue(0, 2) = "Agreement No.";
	   		   }
    	   }
    	   
       }
       
       function title_chk(){
    	   var sheetObj = sheetObjects[0]; 
    	   if(formObj.sts_evnt_yd_cd.value != ""){
    		   sheetObj.cellValue(0, 1)  = "Yard";
    	   } else {
    		   sheetObj.cellValue(0, 1)  = "Location";
    	   }
    	   
       }
       /**
        * AXON 이벤트 처리
        */
       function obj_activate(){
           ComClearSeparator(event.srcElement);
       }
        
        
        /**
         * Sheet1 의 OnMouseDown 이벤트처리 <br>
         * @param  {Integer} Button	필수 Integer
         * @param  {integer} Shift	필수 Integer
         * @param  {Integer} X	필수 Integer
         * @param  {integer} Y	필수 Integer
         * @return 없음
         * @author 조재성
         * @version 2009.09.16
         */ 
         function sheet1_OnMouseDown(Button, Shift, X, Y) {
        	 var sheetObj = sheetObjects[0];
        	 var formObj = document.form;
        	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
        	 {
        		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol);
        	 }
        	 
         }
       
       function sheet1_OnDblClick(sheetObj, Row, Col){
    	   if(Col>3 && Col<=14){
    		   
    			var eqTpszCd = "";
               	var colSaveName = sheetObj.ColSaveName(Col);
               	
            	var eqKndCd			= EQ_KND_CD_CHASSIS;
            	var crntYdCd		= document.form.sts_evnt_yd_cd.value;
            	var eqStrDt 		= document.form.evnt_dt_str.value;
            	var eqEndDt		    = document.form.evnt_dt_end.value;
            	var eqAsetStsCd	    = document.form.eq_aset_sts_cd.value;
            	var location        = comboObjects[1].Code;
            	var scc_cd          = document.form.scc_cd.value;
            	var agmtLstmCd		= "";
            	var sAgmtLstmCd		= document.agmt_lstm_cd.Text; // chungpa 20100405 combo 변경 single => multi
            	var vndr_seq        = "";
//            	var sts_evnt_log_cd = "";
            	var sts_evnt_loc_cd = "";
            	var kind            = "";
               	
				if(colSaveName == 'sf2') 		eqTpszCd = "SF2";
				else if(colSaveName == 'sl2')	eqTpszCd = "SL2";
				else if(colSaveName == 'ta2')	eqTpszCd = "TA2";
				else if(colSaveName == 'sf4')	eqTpszCd = "SF4";
				else if(colSaveName == 'gn4')	eqTpszCd = "GN4";
				else if(colSaveName == 'cb4')	eqTpszCd = "CB4";
				else if(colSaveName == 'eg5')	eqTpszCd = "EG5";
				else if(colSaveName == 'eg8')	eqTpszCd = "EG8";
				else if(colSaveName == 'gn5')	eqTpszCd = "GN5";
				else if(colSaveName == 'zt4')	eqTpszCd = "ZT4";
				else if(colSaveName == 'total')	eqTpszCd = "";
    		    
        	   if( sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "" || sheetObj.CellValue(Row, "vndr_seq") == "Sub Total"){
        		   if(crntYdCd ==""){
        			   sts_evnt_loc_cd = sheetObj.CellValue(Row-1, "sts_evnt_loc_cd");
        		   } else {
        			   sts_evnt_loc_cd = "";
        		   }
        		   vndr_seq        = document.form.vndr_seq.value;
        	   } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "Grand Total" && sheetObj.CellValue(Row, "vndr_seq") == ""){
        		   sts_evnt_loc_cd = "";
        		   vndr_seq        =  document.form.vndr_seq.value;
        	   } else {
        		   if(crntYdCd ==""){
        			   sts_evnt_loc_cd = sheetObj.CellValue(Row, "sts_evnt_loc_cd");
        		   } else {
        			   sts_evnt_loc_cd = "";
        		   }
        		   vndr_seq        = sheetObj.CellValue(Row, "vndr_seq");
        	   }
        	   agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
        	   
        	   // chungpa 20100405 combo 변경 single => multi start
        	   agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
        	   
        	   /* old version.
        	   if(sheetObj.CellValue(Row, "agmt_lstm_cd")==""){
        	    	agmtLstmCd	    = document.form.agmt_lstm_cd.Code;
        	    } else {
        	    	agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
        	    }
        	   */
        	   // chungpa 20100405 combo 변경 single => multi end
        	   if(document.form.location.Code=="S")
    	   	   {
        		   crntYdCd = sts_evnt_loc_cd;
        		   sts_evnt_loc_cd = "";
    	   	   } 
        	                                                       

        	    kind 	= document.form.kind.value;
 
	           	var param = "?pgmNo=EES_CGM_1091&program_id=1010";
	           	param = param + "&f_cmd=" + SEARCH01; 
	        	param = param + "&eq_tpsz_cd=" + eqTpszCd;           	
	           	param = param + "&eq_knd_cd=" + eqKndCd;
	           	param = param + "&crnt_yd_cd=" + crntYdCd;
	           	param = param + "&sts_evnt_dt_fr=" + eqStrDt;
	           	param = param + "&sts_evnt_dt_to=" + eqEndDt;
	           	param = param + "&eq_aset_sts_cd=" + eqAsetStsCd;
	           	param = param + "&location=" + location;
	           	param = param + "&scc_cd=" + scc_cd;
	           	param = param + "&agmt_lstm_cd=" + agmtLstmCd;
	           	param = param + "&s_agmt_lstm_cd=" + sAgmtLstmCd; // chungpa 20100405 combo 변경 single => multi
	           	param = param + "&sts_evnt_loc_cd="+sts_evnt_loc_cd;
	        	param = param + "&vndr_seq="+vndr_seq;
	        	param = param + "&kind="+kind;

	        	ComOpenPopup('/hanjin/EES_CGM_1091.do' + param, 900, 600, "", "1,0", true, false);
           	
    	   }
    	   
    	   
    	   
       }
       
       /** 
 * Object 의 focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */  
    function obj_focusout(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0]; 
    	 obj = event.srcElement;
    	 switch(obj.name){
 	 
    	   case "scc_cd":
    	 		if(formObj.scc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
    	 			break;
    	 		} 
    	  
    	 }   
    }
 
       
	/* 개발자 작업  끝 */