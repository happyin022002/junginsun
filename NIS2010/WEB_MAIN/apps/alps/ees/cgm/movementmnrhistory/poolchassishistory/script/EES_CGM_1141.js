/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1141.js
*@FileTitle : Pool Chassis Comparison Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.04 최민회
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
     * @class EES_CGM_1141 : EES_CGM_1141 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1141() {
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
                	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                     break;

                 case "btn_downexcel":
					 sheetObject1.SpeedDown2Excel(-1);
					 sheetObject2.SpeedDown2Excel(-1, true);
					 break;

                 case "btn_new":
                	 formObj.reset();
                	 formObj.chss_pool_co_cd.text = "";
                	 sheetObject1.RemoveAll();
                	 sheetObject2.RemoveAll();
                     break; 

                 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal = new ComCalendar();
                    cal.setDisplayType('month');
	 				cal.select(formObject.mvmt_dt, "yyyy-MM");
	 				break;  
                 case "btn_trend" :
                	 doActionPageMove(sheetObject1,formObject,srcName);
                	break;
                 case "btn_file" :
                	 doActionPageMove2();
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
             //ComEndConfigSheet(sheetObjects[i]);
             sheetObjects[i].ExtendLastCol = true;
             sheetObjects[i].Visible = true;

         }
         formObj = document.form;
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
         axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         comboObjects[0] = document.chss_pool_co_cd;
         for(var k=0;k<comboObjects.length;k++){
   	         initCombo(comboObjects[k]);
  	    }  
     }
      
      /**
       * 
       * @param sheetObj
       * @return
       */
      function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.WaitImageVisible = false;
          
   	     
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
     	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
     	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
     	formObj.chss_pool_co_cd.focus();
       
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
       
     	 if(obj.name=="mvmt_dt"  ){
         			
     		 with(formObj){
 	        			
     			 var creDtFr = ComReplaceStr(mvmt_dt.value,"-","");
 	        }
 	        	
 	        ComChkObjValid(event.srcElement);
         }
         	
     }
      /** 
       * Object 의 activate 이벤트에 대한 처리  <br>
       * @param  없음
       * @return 없음
       * @author 김창식
       * @version 2009.07.17
       */
      function obj_activate(){
        	ComClearSeparator(event.srcElement);
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
                     style.height = 210;
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
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다

                     var HeadTitle = "|Company Division|EQ Divison|CNTR / CHSS|CHSS Units|Used Days|Rate (USD)|Total Amount (USD)|CHSS_OWNR_CO_CD|CNTR_OWNR_CO_CD";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  40, daCenter, false, "HidStatus");                                            
                     InitDataProperty(0, cnt++ , dtData,         140, daCenter, true,  "com_division",     false, "", dfNone,     0, true, true);
                     InitDataProperty(0, cnt++ , dtData,         140, daCenter, true,  "divison",          false, "", dfNone,     0, true, true);
                     InitDataProperty(0, cnt++ , dtData,         140, daCenter, false, "cntr_chss",        false, "", dfNone,     0, true, true);
                     InitDataProperty(0, cnt++ , dfInteger,      140, daRight,  false, "chss_no",          false, "", dfInteger,  0, true, true);
                                                                                                                                             
                     InitDataProperty(0, cnt++ , dfInteger,      140, daRight,  false, "hjs_chss_usd_dys", false, "", dfInteger,  0, true, true);
                     InitDataProperty(0, cnt++ , dfInteger,      140, daRight,  false, "rate",             false, "", dfFloat,    2, true, true);    
                     InitDataProperty(0, cnt++ , dfInteger,      140, daRight,  false, "total",            false, "", dfInteger,  0, true, true);    
                     InitDataProperty(0, cnt++ , dtHidden,        85, daCenter, false, "chss_ownr_co_cd",  false, "", dfNone,     0, true, true);
                     InitDataProperty(0, cnt++ , dtHidden,        30, daCenter, false, "cntr_ownr_co_cd",  false, "", dfNone,     0, true, true);
//                                                                                                                                             
                     
                     NumberComma = 0;
                   }
                    break;
              case 2:      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 200;
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
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다

                     var HeadTitle1 = "| |EQ Divison|CNTR / CHSS|CHSS Units|CHSS Units|Used Days|Used Days|CHSS_OWNR_CO_CD|CNTR_OWNR_CO_CD";
                     var HeadTitle2 = "| |EQ Divison|CNTR / CHSS|Matching|Unmatching|Matching|Unmatching|CHSS_OWNR_CO_CD|CNTR_OWNR_CO_CD";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 			         InitHeadRow(1, HeadTitle2, true);
 			          

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 			        InitDataProperty(0, cnt++ , dtHiddenStatus,   30, daCenter,  true,   "");                                                  
 			        InitDataProperty(0, cnt++ , dtData,          110, daCenter,  true, "com_division",     false, "", dfNone,    0, true,  true); 
 			        InitDataProperty(0, cnt++ , dtData,  	     130, daCenter,  true, "divison",          false, "", dfNone,    0, true,  true); 
 			        InitDataProperty(0, cnt++ , dtData,          130, daCenter,  true, "cntr_chss",        false, "", dfNone,    0, true,  true); 
 			        InitDataProperty(0, cnt++ , dfInteger,       150, daRight,  false, "matching",         false, "", dfInteger, 0, true,  true); 
 			                                                                                                                                 
 			        InitDataProperty(0, cnt++ , dfInteger,       150, daRight,  false, "unmatching",       false, "", dfInteger, 0, true,  true); 
 			        InitDataProperty(0, cnt++ , dfInteger,       150, daRight,  false, "matching_day",     false, "", dfInteger, 0, true,  true); 
 			        InitDataProperty(0, cnt++ , dfInteger,       150, daRight,  false, "unmatching_day",   false, "", dfInteger, 0, true,  true); 
 			        InitDataProperty(0, cnt++ , dtHidden,         85, daCenter, false, "chss_ownr_co_cd",  false, "", dfNone,    0, false, false);
 			        InitDataProperty(0, cnt++ , dtHidden,         30, daCenter, false, "cntr_ownr_co_cd",  false, "", dfNone,    0, false, false);
 			        
 			        NumberComma = 0;
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
 	        	   formObj.chss_pool_cd.value 		= document.form.chss_pool_co_cd.Code;
 	        	   sheetObj.WaitImageVisible=false;
 			 	   ComOpenWait(true);
 			 		
 			       var sXml = sheetObj.GetSearchXml("EES_CGM_1141GS.do" , FormQueryString(formObj));
 	   		       var arrXml = sXml.split("|$$|");
 	   		
 	         	   sheetObjects[0].LoadSearchXml(arrXml[0]);
 	         	   
 	         	 //  sheetObjects[0].CellBackColor(1,"com_division") = RgbColor(231,250,249);
 	         	 //  sheetObjects[0].CellBackColor(1,"com_division") = RgbColor(231,250,249);

 	         	   sheetObjects[1].LoadSearchXml(arrXml[1]);
 	         	   ComOpenWait(false);
 	            }
	         	break;
       	   case IBSEARCH_ASYNC01:	// CP Combo 조회
   		
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
				ss = ComCgmXml2ComboString(sXml, "TOTAL");
				var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
			  
				//IBSHEET GRID 밖에 있는 콤보
				makeCPMultiCombo(formObj.chss_pool_co_cd, cols, 0, 0);
		 	  	break;

       	 case IBSEARCH_ASYNC02:	// CP Combo 조회
    		
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("CGM_CHSS_POOLGS.do?chss_pool_cd="+formObj.chss_pool_co_cd.Code, FormQueryString(formObj));
				// 데이터 건수
			    var dataCount = ComGetTotalRows(sXml);
			    // 데이터가 존재할 경우
			    if(dataCount > 0){
			    	formObj.chss_pool_nm.value     = DomXml2String(sXml,"chss_pool_nm");
			    	formObj.pool_mgmt_co_nm.value  = DomXml2String(sXml,"pool_mgmt_co_nm");
		
			    } else {
			    	formObj.chss_pool_nm.value = "";
			    }
		 	  	break;
       	 case IBRESET:
 	 		var idx = 0
 	 		var sXml2 = document.form2.sXml.value;
 	 		var arrXml = sXml2.split("|$$|");
 	

 	 		if ( arrXml[idx] == null ) {return;}
 	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
 	 	    var arrStr1 = new Array();
 	 		for ( var i = 0; i < vArrayListData.length; i++) {
 	 		    vListData = vArrayListData[i];
 	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
 	 		}
 	 		// combo control, 결과 문자열, Text Index, Code Index
 	 		makeCPMultiCombo2(formObj.chss_pool_co_cd, arrStr1, 0, 0);     
 	 		idx++;        

 		
         }
     }

     
     /**
      * 시트 1 배경색갈바꾸기
      * @param sheetObj
      * @return
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var i=1; i<sheetObj.Rows; i++){
			sheetObj.CellBackColor(i,"com_division") = sheetObj.RgbColor(231,250,249);
			sheetObj.CellBackColor(i,"divison") = sheetObj.RgbColor(231,250,249);
			sheetObj.CellBackColor(i,"cntr_chss") = sheetObj.RgbColor(231,250,249);
		}

     	with(sheetObj)
     	{
     		if(comboObjects[0].Text != ''){
     			ShowSubSum("com_division", "4|5|7",-1, false, false, -1,"com_division=Total", "6");
     		}
     	}
     }
     
     /**
      * 시트 2 배경색갈바꾸기
      * @param sheetObj
      * @return
      */
     function sheet2_OnSearchEnd(sheetObj) {
 		for(var i=1; i<sheetObj.Rows; i++){
 			sheetObj.CellBackColor(i,"com_division") = sheetObj.RgbColor(231,250,249);
 			sheetObj.CellBackColor(i,"divison") = sheetObj.RgbColor(231,250,249);
 			sheetObj.CellBackColor(i,"cntr_chss") = sheetObj.RgbColor(231,250,249);
 		}
      }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	     with(formObj){
                 switch(sAction) {
                 	case IBSEARCH:      //조회
                 	     if(formObj.chss_pool_co_cd.text==""  ){
                 	    	 ComShowCodeMessage('CGM10009','Pool');
                 	    	 formObj.chss_pool_co_cd.focus();
                 	    	 return false;
                 	     }
    	             	 if(formObj.mvmt_dt.value==""  ){
    	        	    	 ComShowCodeMessage('CGM10009','Month');
    	        	    	 formObj.mvmt_dt.focus();
    	        	    	 return false;
    	        	     }
                 	     break;
                 	
                 }

     			
             }

             return true;
     }
         /** 
          * Combo Object 초기화  <br>
          * @param  {object} comboObj	필수 Combo Object
          * @return 없음
          * @author 김창식
          * @version 2009.07.16
          */ 
         function initCombo(comboObj) {
         	switch(comboObj.id) {
     	  	        
     	    	case "chss_pool_co_cd":
     	 	 		var cnt=0;
     	  	        with(comboObj) {
     	  	        	Code = "";
     	  	            Text = "";
     	  	            DropHeight = 100;
     	  	            MultiSelect = false;
     	  	            MaxSelect = 1;	    
     	  	            UseCode = true;
     	  	            Enable = true;
     		        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
     		            IMEMode = 0;            // 영문
     		            MaxLength = 20;         // 100자까지 입력
     	  	            comboObj.UseAutoComplete = true;
     	  	        }
     	  	        
     	  	        break;
     	  	        
     	    	
     	    	
     	  	      
         	}
         }  


     /** 
      * CP Combo Object 에 값을 추가하는 처리 <br>
      * @param  {object} cmbObj	필수 Combo Object
      * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
      * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
      * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
      * @return 없음
      * @author 김창식
      * @version 2009.07.16
      */ 
      function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
         	cmbObj.RemoveAll();
      
         	// LOOP를 돌리기 위해 데이타 갯수를 구함 
         	if(arrStr == undefined ){
         		cmbObj.Index2 = "" ;
         	} else {
             	var arrCode = arrStr[0].split("|");
             	var arrCode2 = arrStr[1].split("|");
  	          	
             	for (var i = 0; i < arrCode.length;i++ ) {
	          		var arrCode3 = arrCode[i].split("|");
	          		var arrCode4 = arrCode2[i].split("|");
	          		cmbObj.InsertItem(i, arrCode3[codeCol], arrCode3[codeCol]);
	          	}
         	}

         	
         } 
      /** 
       * IBSHEET GRID 밖에 콤보 추가(POOL COMBO)
       */ 
      function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
    	   cmbObj.RemoveAll();
          	 
//            	//ComShowMessage(arrCode2);
        	for (var i = 0; i < arrStr.length;i++ ) {
          		var arrCode = arrStr[i].split("|");
          		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
      	    }
       }

 
    /**
     * 시트 그리드 클릭시 팝업 호출
     * @param sheetObj
     * @param Row
     * @param Col
     * @param CellX
     * @param CellY
     * @param CellW
     * @param CellH
     * @return
     */
    function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
 	  
 	   if(Col>3 && Col<=7){
 		    var mvmt_dt		        = document.form.mvmt_dt.value;
 	    	var chss_pool_cd 		= document.form.chss_pool_co_cd.Code;
 	    	var chss_ownr_co_cd		= sheetObj.CellValue(Row, "chss_ownr_co_cd");
 	    	var cntr_ownr_co_cd	    = sheetObj.CellValue(Row, "cntr_ownr_co_cd");
 	    	var chss_pool_nm        = document.form.chss_pool_nm.value;
 	    	var pool_mgmt_co_nm     = document.form.pool_mgmt_co_nm.value;
 	    	var gubun         	    = "";
 	    	if(Col == 4 || Col == 6){
 	    		gubun ="M";
 	    	} else {
 	    		gubun ="U";
 	    	}
 		    var param = "?pgmNo=EES_CGM_1142&program_id=1141";
 		   	param = param + "&f_cmd=" + SEARCH; 
 			param = param + "&mvmt_dt=" + mvmt_dt;           	
 		   	param = param + "&chss_pool_cd=" + chss_pool_cd;
 		   	param = param + "&chss_ownr_co_cd=" + chss_ownr_co_cd;
 		   	param = param + "&cntr_ownr_co_cd=" + cntr_ownr_co_cd;
 		    param = param + "&chss_pool_nm=" + chss_pool_nm;
		   	param = param + "&pool_mgmt_co_nm=" + pool_mgmt_co_nm;
 		    param = param + "&gubun=" + gubun; 
 		    ComOpenPopup('/hanjin/EES_CGM_1142.do' + param, 900, 530, "", "1,0", true, false);
        	
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
   	 	case "ym":
   	 		ComKeyOnlyNumber(obj);
   	        break;
   	    
   	 }
   	 
   	 
    }
   
     /**
      * Group3 Multi-Combo 의 OnChange 이벤트처리 <br>
      * @param  {object} ComboObj	필수	 Sheet Object
      * @param  {int} 	Index_Code	필수
      * @param  {string} Text		필수
      * @return 없음
      * @version 2009.07.16
      */ 
     function chss_pool_co_cd_OnChange(comboObj, Index_Code, Text){
     	
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
     }
    
      
      /**
       * Step 단계별로 화면 이동 
       */
      function doActionPageMove(sheetObj, formObj, btnName){
          formObj.f_cmd.value = "";
          formObj.method = "POST";
          formObj.chss_pool.value = formObj.chss_pool_co_cd.Code;
          formObj.target = "";
          
          // MultCombo 일경우 submit()으로 넘기면 데이터를 정상적으로 넘길수 었기 때문에 아래와 같이 GET 방식으로 데이터를 넘긴다        
           if(validateForm(sheetObj,formObj,IBSEARCH)){
        	  formObj.action = "EES_CGM_1143.do?pgmNo=EES_CGM_1143";
          	  formObj.submit();
          }
          
          
      }
       
       /**
        *  1145 파일 입력 화면 열기 
        * @return
        */
       function doActionPageMove2(){
        	if(formObj.chss_pool_co_cd.text==""  ){
    	    	 ComShowCodeMessage('CGM10009','Pool');
    	    	 formObj.chss_pool_co_cd.focus();
    	    	 return false;
    	     }
        	if(formObj.mvmt_dt.value==""  ){
	   	    	 ComShowCodeMessage('CGM10009','Month');
	   	    	 formObj.mvmt_dt.focus();
	   	    	 return false;
   	        }
        	
		    var mvmt_dt		        = document.form.mvmt_dt.value;
 	    	var chss_pool_cd 		= document.form.chss_pool_co_cd.Code;
 	    	var pool_mgmt_co_nm     = document.form.pool_mgmt_co_nm.value;
 	    	
    	    var param = "?pgmNo=EES_CGM_1145&program_id=1145";
		   	param = param + "&f_cmd=" + SEARCH; 
			param = param + "&mvmt_dt=" + mvmt_dt;           	
		   	param = param + "&chss_pool_co_cd=" + chss_pool_cd;
		   	param = param + "&pool_mgmt_co_nm=" + pool_mgmt_co_nm;

   		    ComOpenPopup('/hanjin/EES_CGM_1145.do' + param, 700, 490, "", "1,0", true, false);
            	
      
        }
	/* 개발자 작업  끝 */