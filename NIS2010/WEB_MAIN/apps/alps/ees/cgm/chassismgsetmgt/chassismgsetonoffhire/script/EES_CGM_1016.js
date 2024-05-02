/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1016.js
*@FileTitle : Chassis Status를 조회하고 수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.11 최민회
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.07.09 김창헌 [CHM-201218594-01] Enter나 Retrieve 하지 않고 자동적으로 조회되게 수정
* 2012.07.30 김창헌 [선작업] 180일 지난 건에 대해서도 삭제 허용
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
     * @class ees_cgm_1016 : ees_cgm_1016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1016() {
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

 var SEARCH_ENABLE = true;
 
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

                 case "btn_retrieve":
                	 doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                     break;

                 case "btn_new":
                	 sheetObject1.RemoveAll();
                	 sheetObject2.RemoveAll();
  				 	 formObject.reset();
                     break; 

                 case "btn_del":
                	 doActionIBSheet(sheetObject2,formObject,REMOVE);
                     break;

                 case "btn_save2":
                	 doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;

             } // end switch
             tRoleApply();
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
     
     
     function set_serch()
     {
    	 var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;
    	 doActionIBSheet(sheetObject2, formObject, IBSEARCH);
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
    	 var formObj = document.form;
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         
         for(i=0;i<sheetObjects.length;i++){

             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);

             ComEndConfigSheet(sheetObjects[i]);

         }
         
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- 키 눌렸을때
         axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
         axon_event.addListenerForm('change',	'obj_change',	form); //- 변경될때

      }
      
    /**
   	 * Key-Down Event 처리
   	 */
  	 
   	function obj_keydown() {
  		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var ctrlKey = event.ctrlKey;
  		var formObj  = document.form;
    		switch (obj.name) {
  			case "eq_no":
  	  		if ( vKeyCode == 9 || vKeyCode == 13 ) {
  	  			SEARCH_ENABLE = false;
  	  			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
  	  			SEARCH_ENABLE = true;
  	  			ComSetFocus(formObj.eq_no);
  	  		}
  	  		break;
    		}	
  	} 	 

   	/**
   	 * obj_keyup
   	 */   
   	function obj_keyup() {
   		var obj = event.srcElement;
   		
   		switch (obj.name) {
   			case "eq_no": 
   				ComKeyEnter('LengthNextFocus');
   		  		break;
   		}
   	}

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "eq_no":
	    			if ( SEARCH_ENABLE ) {
	    				//formObj.eq_no.value=formObj.eq_no.value.toUpperCase(); // Copy&paste 소문자를 대문자로 변경
	    				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				ComSetFocus(formObj.eq_no);
	    			}
					break;	
		    }
		}	
	}		

   	  /**
       * 
       * @param sheetObj
       * @return
       */
      function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.WaitImageVisible = false;
          var sheetObject2 = sheetObjects[1];
          formObj = document.form;
          //axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
 		 
 		 if(formObj.eq_no.value != "")
 		 {
 			 doActionIBSheet(sheetObject2, formObj, IBSEARCH);
 		 }
 		 initControl(sheetObjects[0]);
 		 tRoleApply();
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
            formObj.eq_no.focus();
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

             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 62;
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
                     
                     var HeadTitle = "|Status|Event Date|Office|Yard|Agreement No|Ref. No.|Lessor||||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,	daCenter,	false,		"ibflag");
                     InitDataProperty(0, cnt++ , dtData,            100,	daCenter,	false,		"eq_aset_sts_cd",	false,		"",      dfNone,      	 	0,     false,		true);
//                     InitDataProperty(0, cnt++ , dtPopupEditFormat, 140,	daCenter,	false,		"sts_evnt_dt",		false,		"",      dfDateYmd,		0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,            140,	daCenter,	false,		"sts_evnt_dt",		false,		"",      dfUserFormat2,		0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,            120,	daCenter,	false,		"sts_evnt_ofc_cd",  false,		"",      dfNone,     	 		0,     false,		true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,       120,	daCenter,	false,		"sts_evnt_yd_cd",   false,		"",      dfNone,      	 	0,     false,		true);
 					 
                     //AGMT 수정 불가로 변경 (2010.04.12)
                     //InitDataProperty(0, cnt++ , dtPopupEdit,       140,	daCenter,	false,		"agreeement",   	false,		"",      dfNone,  			0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,   		    140,	daCenter,	false,		"agreeement",   	false,		"",      dfNone,  			0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,            140,	daCenter,	false,		"agmt_ref_no",      false,		"",      dfNone,      	 	0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,            120,	daCenter,	false,		"vndr_seq",   		false,		"",      dfNone,     	 		0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,          120,	daCenter,	false,		"eq_no",   		false,		"",      dfNone,     	 		0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,          120,	daCenter,	false,		"eq_sts_seq",   		false,		"",      dfNone,     	 		0,     false,		true);
   										
                     InitDataProperty(0, cnt++ , dtHidden,          120,	daCenter,	false,		"evnt_dt",   		false,		"",      dfDateYmd,     	 		0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,          120,	daCenter,	false,		"sts_evnt_dt2",   		false,		"",      dfNone,     	 		0,     false,		true);
                     CountPosition= 0;
                     sheetObj.InitDataValid(0, "sts_evnt_yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
                     sheetObj.InitDataValid(0, "agreeement", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
                     InitUserFormat2(0, "sts_evnt_dt", "####-##-## ##:##", "-|:" );
 					 ImageList(0) = "img/btns_calendar.gif";
// 				     PopupButtonImage(1,"sts_evnt_dt") = 1;
 				     ShowButtonImage = 1;
 				     SelectionMode   = smSelectionFree;
 				 }
                 break;

             case "sheet2":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(21, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다

                     var HeadTitle = "||Seq.|Status|Event Date|System Date|Office|Yard|Agreement No.|Ref. No.| Lessor|Lessor Name|User ID|||||||";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  	 false,    "ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,   	 0, 	  daCenter,  false,   "del_chk",    		 false,          "",      dfNone,      	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtDataSeq,  30,    daCenter,  	 false,   "no",    		 false,          "",      dfNone,      	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,  	 50,	daCenter,  	 false,   "eq_aset_sts_cd",    		 false,          "",      dfNone,      	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,   	110,    daCenter,  	 false,   "sts_evnt_dt",   	 false,          "",      dfNone, 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,  	110,    daCenter,  	 false,   "cre_dt",    false,          "",      dfNone, 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,   	 60,    daCenter,  	 false,   "sts_evnt_ofc_cd",   		 false,          "",      dfNone,     	 0,     false,		true);
                                                                                                                                                                 		
                     InitDataProperty(0, cnt++ , dtData,  	 70,    daCenter,  	 false,   "sts_evnt_yd_cd",    			 false,          "",      dfNone,      	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,   	100,    daCenter,  	 false,   "agreeement",   false,          "",      dfNone,  			 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,  	90,    daCenter,  	 false,   "agmt_ref_no",    	 	 false,          "",      dfNone,      	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,   	 60,    daCenter,  	 false,   "vndr_seq",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtData,  	190,    daCenter,  	 false,   "vndr_lgl_eng_nm",    false,          "",      dfNone,      	 0,     false,		true);
                                                                                                                                                                 		
                     InitDataProperty(0, cnt++ , dtData,   	 70, 	  daCenter,  false,   "cre_usr_id",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "aciac_div_nm",   		 false,          "",      dfNone,     	 0,     false,		true);
                     
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "eq_tpsz_cd",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "agmt_lstm_cd",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "eq_sts_seq",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "eq_no",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "aciac_div_cd",   		 false,          "",      dfNone,     	 0,     false,		true);
                     
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "term_cng_seq",   		 false,          "",      dfNone,     	 0,     false,		true);
                     InitDataProperty(0, cnt++ , dtHidden,   	 90, 	  daCenter,  false,   "chk_val",   		 false,          "",      dfNone,     	 0,     false,		true);
                     
//					InitUserFormat2(0, "EventDate", "####-##-## ##:##", "-|:" );
//					InitUserFormat2(0, "SystemDate", "####-##-## ##:##", "-|:" );
//                     colhidden("chk")=true;

					
					
				}
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case IBSEARCH:      //조회
                 var sheetObject1 = sheetObjects[0];
                 var sheetObject2 = sheetObjects[1];
                 
                 sheetObject1.RemoveAll();
                 sheetObject2.RemoveAll();
	             var params = FormQueryString(formObj);
 			 	 queryString = "f_cmd=" + SEARCH ;
// 			 	 sheetObj.Redraw = false;
 			 	 if(!validateForm(sheetObj,formObj,sAction)) return;
 			 	 
				 sheetObj.WaitImageVisible=false;
		 	     ComOpenWait(true);
		 	     
                 sheetObj.DoSearch("EES_CGM_1016GS.do",  queryString+"&"+params);

                 if(sheetObj.LastRow>0)
                 {
                	 formObj.aciac_div_nm.value = sheetObj.CellValue(sheetObj.LastRow, "aciac_div_nm") ;
                     formObj.eq_tpsz_cd.value = sheetObj.CellValue(sheetObj.LastRow, "eq_tpsz_cd") ;
                     formObj.agmt_lstm_cd.value = sheetObj.CellValue(sheetObj.LastRow, "agmt_lstm_cd") ;
                     formObj.eq_sts_seq.value = sheetObj.CellValue(sheetObj.LastRow, "eq_sts_seq") ;
                	 
                 } else {
                	 ComShowCodeMessage("CGM10004", "Chassis No");
                 }
                 ComOpenWait(false);
                 break;
           case REMOVE:
        	   var sts_seq ="";
        	   var chk_val = "";
        	   for(i=1; i<sheetObj.rowCount+1; i++){
//	   	        	ComShowMessage(Row);
//	   	        	ComShowMessage(i);
					if(sheetObj.cellValue(i,'del_chk')=="1")
					{
						sts_seq = sheetObj.cellValue(i,'eq_sts_seq') ;
						chk_val = sheetObj.cellValue(i,'chk_val') ;
						sheetObj.RowStatus(i) = "D";
					} else {
						sheetObj.RowStatus(i) = "R";
					}
	   	        	
	  		   }
        	   
        	    if( sts_seq ==formObj.eq_sts_seq.value )
				{
//					 ComRowHideDelete(sheetObj,"del_chk");
				}
				else
				{
					ComShowCodeMessage("CGM10064");
					return false;
				}
        	    
//        	    if(chk_val == "Y"){
//        	    	ComShowCodeMessage('CGM20034');
//					return false;
//        	    }
        	   var params = sheetObj.GetSaveString(true);
   			  formObj.f_cmd.value = MULTI02;
   			  queryString = "f_cmd=" + MULTI02 ;
    		  if(sheetObj.DoSave("EES_CGM_1016GS.do",queryString + "&" + ComGetPrefixParam(""))){
    			  
    		  }  
//	          ComRowHideDelete(sheetObj,"del_chk");
    		    
        	   break;
 		   case IBSAVE:        //저장
 		        if(!validateForm(sheetObj,formObj,sAction)) return;
	 		    var params = sheetObj.GetSaveString(true);
				formObj.f_cmd.value = MULTI01;
				queryString = "f_cmd=" + MULTI01 ;
				
				sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
	 		    sheetObj.DoSave("EES_CGM_1016GS.do",queryString + "&" + ComGetPrefixParam(""));
	 		    ComOpenWait(false);
                  

            break;

 				
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	 with(formObj){
    		 switch(sAction) {
    		 	case IBSAVE:
    		 		for(i=1; i<sheetObj.rowCount+1; i++){
//    	   	        	ComShowMessage(Row);
    					if(sheetObj.cellValue(i,'sts_evnt_dt')== "")
    					{
    						ComShowCodeMessage("CGM10004", "Event Date");
    						sheetObj.SelectCell(i, 2, true);
    						return false;
    					}
    					
    					if(sheetObj.cellValue(i,'sts_evnt_yd_cd')== "")
    					{
    						ComShowCodeMessage("CGM10004", "Yard");
    						sheetObj.SelectCell(i, 4, true);
    						return false;
    					}
    					
    					if(sheetObj.cellValue(i,'agreeement')== "")
    					{
    						ComShowCodeMessage("CGM10004", "Agreement No");
    						sheetObj.SelectCell(i, 5, true);
    						return false;
    					}
    	   	        	
    	  		   }
    		 		
    		 	  

    		 		
           			break;
    		 	case IBSEARCH:
    		 		 
            	   if( formObj.eq_no.value == '' )
    				{
            		   ComShowCodeMessage("CGM10004", "Chassis No");
            		   formObj.eq_no.focus();
            		   return false;
    				}
    		 		
    		 		
           			break;
    		 }      
    	 }

         return true;
     }

      /**
       * 시트네 팝업 클릭
       * @param sheetObj
       * @param row
       * @param col
       * @return
       */
      function sheet1_OnPopupClick(sheetObj, row, col){
//    	   ComShowMessage(row);
    		switch (sheetObj.ColSaveName(col)) {
    	       	case "sts_evnt_dt" :
    	       		sheetObj.SelectCell(row, "eq_aset_sts_cd", true);

//    	       		ComShowMessage(row);
    			    if (sheetObj.ColSaveName(col) != "sts_evnt_dt") return;//chss_rgst_exp_dt
    			    var cal = new ComCalendarGrid("myCal");
    			    cal.setEndFunction("processEndCal");    // Calendar 선택 후의 이벤트를 발생시키기 위해 (onChange Event 대용)
    			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    			    break;

    	       	case "sts_evnt_yd_cd" :
                	//chungpa 20100415 new yard popup start
         			//ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true);
         			ComOpenPopup("/hanjin/EES_LSE_0101.do", 800, 450, "setPopData_AvailYard", '1,0', true, false, row, col, 0);
         			//chungpa 20100415 new yard popup end
    			    break;
    			    
    	    	case "agreeement" :
    	    		ComOpenPopup('/hanjin/EES_CGM_1117.do?pgmNo=EES_CGM_1117', 820, 420, "setProgramNo", "1,0,1,1,1,1", true, false);
    			break;   
    			    
    			    
    		}
    	}
      
       /**
        * Yard Code Pop-up Return Value 처리 부분<br>
        * @param {arry} returnedValues Pop-up 화면의 Return value array
        * @param Row 대상Object가 IBSheet일 경우 해당 Row index
        * @param Col 대상Object가 IBSheet일 경우 해당 Col index
        * @param 대상IBSheet의 Sheet Array index
        */
       function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
       	if(aryPopupData.length > 0) {
  			with(sheetObjects[sheetIdx]) {
  				CellValue2(Row, Col) = aryPopupData[0][4]; //Yard
  			}
  		}
       }
       
      function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
			var sheetObject = sheetObjects[0];
			sheetObject.CellValue(1, "sts_evnt_yd_cd") = aryPopupData[0][3];
 	 }
      
      
      /**
       * Found date 입력시, 현재 날짜/시간 이후를 입력시 오류.
       * "Found Date cannot be later than now."
       * @return
       */
      function processEndCal(){
     	  var sheetObj = sheetObjects[0];
     	  var sheetObj2 = sheetObjects[1];
     	  var evnt_dt   = sheetObj2.CellValue(sheetObj2.rowCount-1, "sts_evnt_dt").substring(0,10);
     	  evnt_dt =  ComReplaceStr(evnt_dt,"-","");
     	  //alert(sheetObj.CellValue(sheetObj.SelectRow, "sts_evnt_dt") );
          if(sheetObj.CellValue(sheetObj.SelectRow, "sts_evnt_dt") < evnt_dt){
	   	    	sheetObj.CellValue(sheetObj.SelectRow, "sts_evnt_dt") = "";
	 	    	sheetObj.focus();
	 	    	sheetObj.SelectCell(sheetObj.SelectRow,sheetObj.SelectCol-1, false);
	  	    	ComShowCodeMessage("CGM10060",sheetObj2.CellValue(sheetObj2.rowCount-1, "sts_evnt_dt"));
  	      }  
  
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
    	  var sheetObject = sheetObjects[0];
      	 var vndrSeq = "";
      	 var i = 0;
//      	 ComShowMessage('setProgramNo'+aryPopupData.length);
      	 for(i = 0; i < aryPopupData.length; i++){
      		 vndrSeq = vndrSeq + aryPopupData[i][2];
      		
      		/* if(aryPopupData.length == 1){
      			 vndrNm = vndrNm + aryPopupData[i][4];
      		 }*/
      		 
      		 if(i < aryPopupData.length - 1){
      			 vndrSeq = vndrSeq + ",";
      		 }
//      		ComShowMessage('vndrSeq=='+vndrSeq);
      	 }
      	 
      	  sheetObject.CellValue(1, "agreeement") = vndrSeq;
//      	  ComShowMessage(vndrSeq);
      	 
      	 
      }
       
      function sheet1_OnChange(sheetObj,Row,Col,sValue){
    	  var formObj = document.form;
    	  switch (sheetObj.ColSaveName(Col)) {
	       	case "sts_evnt_yd_cd" :
	   			formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value =sheetObj.CellValue(1, "sts_evnt_yd_cd");
			   	if(formObj.yd_cd.value!="")
			   	{
			   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
				   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
				   	if(sCheckResult == COM_VALIDATION_FALSE){
				   		ComShowCodeMessage('CGM10009','Yard');
				   		sheetObj.CellValue(1, "sts_evnt_yd_cd") = "";
				   		sheetObj.SelectCell(Row, Col-1, true);
//				   		formObj.sts_evnt_yd_cd.focus();
				   	} else {
				   		sheetObj.RowStatus(1) = "U";
				   	} 
				   	
			   	}
			    break;
	       	case "sts_evnt_dt" :
	       		  var sheetObj2 = sheetObjects[1];
		     	  var evnt_dt   = sheetObj2.CellValue(sheetObj2.rowCount-1, "sts_evnt_dt").substring(0,10);
		     	  var evnt_hs   = sheetObj2.CellValue(sheetObj2.rowCount-1, "sts_evnt_dt").substring(11,16);
		     	  var evntDt    = sheetObj.CellValue(sheetObj.SelectRow, "sts_evnt_dt").substring(0,8);
		     	  evnt_dt =  ComReplaceStr(evnt_dt,"-","")+ComReplaceStr(evnt_hs,":","");
		     	  evntDt  =  ComReplaceStr(evntDt,"-","")
		          if(sheetObj.CellValue(sheetObj.SelectRow, "sts_evnt_dt") < evnt_dt){
			   	    	sheetObj.CellValue2(sheetObj.SelectRow, "sts_evnt_dt") = "";
			 	    	sheetObj.focus();
			 	    	
			 	    	ComShowCodeMessage("CGM10060",sheetObj2.CellValue(sheetObj2.rowCount-1, "sts_evnt_dt"));
			 	    	sheetObj.SelectCell(sheetObj.SelectRow,sheetObj.SelectCol, false);
			 	    	return false;
		  	      }  
		          if(document.form.form_day.value < evntDt){
		        	    sheetObj.CellValue2(sheetObj.SelectRow, "sts_evnt_dt") = "";
			 	    	sheetObj.focus();
			 	    	
			 	    	ComShowCodeMessage("CGM10059");
			 	    	sheetObj.SelectCell(sheetObj.SelectRow,sheetObj.SelectCol, false);
			 	    	return false;
		          }
				  break;
	       	case "agreeement" :
	   			formObj.f_cmd.value = COMMAND01;
			   	formObj.agmt_ofc_cty_cd.value =sheetObj.CellValue(1, "agreeement");
			   	var agmtOfcCytCd = formObj.agmt_ofc_cty_cd.value;
			   	if(agmtOfcCytCd !="" )
			   	{
			   		
			   		if(ComIsNumber(agmtOfcCytCd.substr(3,agmtOfcCytCd.length))){
			   			var sXml = sheetObj.GetSearchXml("EES_CGM_AGREEMENTGS.do", FormQueryString(formObj));
					   	var sCheckResult = ComGetEtcData(sXml,"checkResult"); 
					   	if(sCheckResult == COM_VALIDATION_FALSE){
					   		ComShowCodeMessage('CGM10009','agreeement');
					   		sheetObj.CellValue(1, "agreeement") = "";
					   		sheetObj.SelectCell(Row, Col-1, true);
//					   		formObj.sts_evnt_yd_cd.focus();
					   	}
					   	else
					   	{
					   		sheetObj.CellValue(Row, "agreeement") = sCheckResult;
					   	}
			   		} else
			   		{
			   			ComShowCodeMessage('CGM10009','agreeement');
				   		sheetObj.CellValue(1, "agreeement") = "";
				   		sheetObj.SelectCell(Row, Col-1, true);
			   		}
			   		
			   	}
			    break;
	     		    
			    
		}
    	 
//	   		ComShowMessage(Col);
//	   		if(Col==4){
//	   			formObj.f_cmd.value = COMMAND01;
//			   	formObj.yd_cd.value =sheetObj.CellValue(1, "sts_evnt_yd_cd");
//			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
//			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
//			   	
//			   	if(sCheckResult == COM_VALIDATION_FALSE){
//			   		ComShowCodeMessage('CGM10009','Yard');
//			   		sheetObj.CellValue(1, "sts_evnt_yd_cd") = "";
////			   		formObj.sts_evnt_yd_cd.focus();
//			   	}
//	   		}
   	  }

 		
 		

 	    /**
  	     * 시트  클릭시 
  	     * @param sheetObj
  	     * @param Row
  	     * @param Col
  	     * @return
  	     */
  	   function sheet2_OnClick(sheetObj, Row, Col) {
  	         try{
  	        	var sheetObject1 = sheetObjects[0];
//   	            ComShowMessage("sheet2_OnDblClick  Row==========="+Row);
   	            var strSaveNames = "eq_aset_sts_cd|sts_evnt_dt|sts_evnt_ofc_cd|sts_evnt_yd_cd|agreeement|agmt_ref_no|vndr_seq|eq_no|eq_sts_seq";  //test....
   	            var strStatus    = "";
  	            var termCngSeq   = "";
  	            var termChk      = 0;
  	            var chkVal       = "N";
	   	         for(i=1; i<sheetObj.rowCount+1; i++){
//	   	        	ComShowMessage(Row);
//	   	        	ComShowMessage(i);
					if(i==Row)
					{
						 sheetObj.cellValue(Row,'del_chk') = "1";
					}
					else
					{
						sheetObj.cellValue(i,'del_chk') = "0";
					}
	   	        	
	  			 }
	   	         sheetObj.cellValue(Row,'del_chk') = "1";
	   	         termCngSeq = sheetObj.cellValue(Row,'term_cng_seq');
	   	   // termCngSeq 값이 있는 경우
	   	       if(termCngSeq != '')
	   	       {
	   	   	    	for(i=1; i<sheetObj.rowCount+1; i++){
	   					if(sheetObj.cellValue(i,'term_cng_seq')== termCngSeq && Row != i)
	   					{
	   						sheetObj.cellValue(i,'del_chk') = "1";
	   						termChk = i;
	   					}
	   	  	        	
	   	 		   }
	   	   	       var sXml = ComMakeSearchXml(sheetObj   , false,"del_chk", strSaveNames, false);  //all column : move 
	   	    	   sheetObjects[0].RemoveAll();
	      	       sheetObjects[0].LoadSearchXml(sXml, true);
	      	       sheetObj.cellValue(termChk,'del_chk') = "0";
	   	       }
	   	       else
	   	       {
	   	    	   var sXml = ComMakeSearchXml(sheetObj   , false,"del_chk", strSaveNames, false);  //all column : move 
	   	    	   sheetObjects[0].RemoveAll();
	      	       sheetObjects[0].LoadSearchXml(sXml, true);
	   	       }
            
   	          
	   	       for(i=1; i<sheetObj.rowCount+1; i++){
	//  	        	ComShowMessage(Row);
	//  	        	ComShowMessage(i);
					if(sheetObj.cellValue(i,'del_chk')=="1")
					{
						sts_seq    = sheetObj.cellValue(i,'eq_sts_seq') ;
						strStatus  = sheetObj.cellValue(i,'eq_aset_sts_cd') ;
						chkVal     = sheetObj.cellValue(i,'chk_val') ;
					}
	  	        	
	 		   }
	   	       if( sts_seq ==formObj.eq_sts_seq.value ){
	   	    	   sheet1_edit(strStatus,chkVal);
			   } 
   	          
   	          
   	         }catch(e){}
  	   }
  	     
  	
  	   
  	   /**
  	    * 마지막 열일때 상태에 따라 sheet1 화면 제어
  	    * @param strStatus
  	    * @return
  	    */
  	   function sheet1_edit(strStatus,chkVal)
	   {
  	    	if(chkVal == "N"){
  	    		if(strStatus=='LSO' || strStatus=='SBO'  || strStatus=='SBI'  || strStatus=='MUI'  || strStatus=='LST'  || strStatus=='FND')
  	  		    {
  			      	sheetObjects[0].CellEditable(1, "sts_evnt_dt")      = true;
  			      	sheetObjects[0].CellEditable(1, "sts_evnt_yd_cd")      = true;
  			      	sheetObjects[0].cellValue(1, "sts_evnt_dt2")      = sheetObjects[0].cellValue(1, "sts_evnt_dt");
  		   		}
  	  		    if(strStatus=='LSO' || strStatus=='SBO'  )
  			    {
  	  			    //AGMT 수정 불가로 변경 (2010.04.12)
  	  		    	//sheetObjects[0].CellEditable(1, "agreeement")      = true;
  	  		    	sheetObjects[0].CellEditable(1, "agreeement")      = false;
  	  			    sheetObjects[0].cellValue(1, "sts_evnt_dt2")      = sheetObjects[0].cellValue(1, "sts_evnt_dt");
  		   		}
  	    	}
  	    	
	   }
  	    
  	    // 저장후 조회 기능 
  	    function sheet1_OnSaveEnd(sheetObj, errMsg) {

  	    	if(errMsg =='') {   
  	    		ComShowCodeMessage('CGM00003');
  	        	set_serch();
  			}
  	    }    	
  	    
  	    // 삭제후 조회기능
  	    function sheet2_OnSaveEnd(sheetObj2, errMsg) {
  	    	if(errMsg =='') {   
  	    		ComShowCodeMessage('CGM00003');
  	        	set_serch();
  			}
  	    }

  	    
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
       	    case "engup":
       	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    
       	 }
       	 
       	 
        }
         
         
 /**
  * 기능(ex:btn_save)에 권한(trole) 적용  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2010.03.05
  */     
  function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_del");
		  ComBtnDisable("btn_save2");
	  }
  } 
	/* 개발자 작업  끝 */