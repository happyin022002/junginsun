/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0021.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.24 장창수
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
      * @extends 
      * @class fns_tot_0021 : fns_tot_021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
      */
    function fns_tot_0021() {
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
	var comboObjects = new Array();
	var comboCnt = 0;
	var jobStatus = "";
	var closing_dt = "";

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

				case "btns_back":

   	                 if(formObject.param_start_dt.value == null || formObject.param_start_dt.value == ""){
   	                	 ComShowCodeMessage('TOT00003');
   	                	 return;
   	                 }
   	                 formObject.param_start_dt.value = ComGetDateAdd(formObject.param_start_dt.value+"-01","M",-1).substring(0,7);
	                 
					break;

				case "btns_next":
					
   	                 if(formObject.param_start_dt.value == null || formObject.param_start_dt.value == ""){
   	                	 ComShowCodeMessage('TOT00003');
   	                	 return;
   	                 }
   	                 formObject.param_start_dt.value = ComGetDateAdd(formObject.param_start_dt.value+"-01","M", 1).substring(0,7);
	                 
   	                 break;
					
				case "btns_back2":

   	                 if(formObject.param_end_dt.value == null || formObject.param_end_dt.value == ""){
   	                	 ComShowCodeMessage('TOT00003');
   	                	 return;
   	                 }
   	                 formObject.param_end_dt.value = ComGetDateAdd(formObject.param_end_dt.value+"-01","M",-1).substring(0,7);
	                 
					break;

				    case "btns_next2":
					
   	                 if(formObject.param_end_dt.value == null || formObject.param_end_dt.value == ""){
   	                	 ComShowCodeMessage('TOT00003');
   	                	 return;
   	                 }
   	                  formObject.param_end_dt.value = ComGetDateAdd(formObject.param_end_dt.value+"-01","M", 1).substring(0,7);
	                 
					break;

                  
               case "btn_Calendar":
               	
               	  //활성여부 체크
               	   if(formObject.all.item("btn_Calendar").disabled){
                   }else{
              	     // 객체 활성화
                   	var cal = new ComCalendar();
                   	cal.select(formObject.st_date, 'yyyy-MM-dd');
                   }

	                break;

               case "btn_calendar2":
                  	
                	  //활성여부 체크
                	if(formObject.all.item("btn_Calendar2").disabled){
                    }else{
               	     // 객체 활성화
               	        var cal = new ComCalendarFromTo();
               	        cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');

                    }

 	                break;
               case "btn_Retrieve":
               	    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	                break;
               case "btn_New":
            	   sheetObject1.RemoveAll();

                 break;	                
               case "btn_Submit":
               	   doActionIBSheet(sheetObject1,formObject,IBSAVE);

                   break;

               case "btn_Cancel":
              	 	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
              	 	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
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
      * IBCombo Object를 배열로 등록
      * param : combo_obj ==> 콤보오브젝트
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */ 
    function setComboObject(combo_obj) {  
    	    comboObjects[comboCnt++] = combo_obj;  
    }
    
    /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
    function loadPage() {
    	  
         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         for(var k=0;k<comboObjects.length;k++){
        	 
        	 initCombo(comboObjects[k],k+1);
         }
         initControl();
         
         var formObject = document.form;
         
		 formObject.st_date.disabled = true;
		 ComEnableObject(formObject.all.item("btn_Calendar"), false);
		 formObject.st_date_hh.disabled = true;
		 formObject.st_date_mm.disabled = true;

    }
    
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
        
          switch(sheetNo) {
              case 1:      // t1sheet1 init
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 390;
                      
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo( 1, 1, 10, 100);

                      var HeadTitle1 = "||Seq|From Year Month|To Year Month|Item|Batch Id|Status|Job Start Date|Job End Date|Job Id";
                      var headCount = ComCountHeadTitle(HeadTitle1);					

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false)
                      
                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);
    
                      var prefix = "sheet1_";
                      //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          			  InitDataProperty(0, cnt++, dtHiddenStatus,  0, daCenter, true, prefix+"ibflag"   );
        			  InitDataProperty(0, cnt++, dtCheckBox    ,  20, daCenter, true , prefix+"upd_chk"  );                     
                      InitDataProperty(0, cnt++, dtSeq,				30,			daCenter,		true,		"Seq");
                      InitDataProperty(0, cnt++, dtData,					120,		daCenter,	true,		prefix+"jb_fm_yrmon",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					120,		daCenter,	true,		prefix+"jb_to_yrmon",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					200,		daCenter,	false,	prefix+"bat_itm_nm",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					160,		daCenter,	false,	prefix+"bat_id",				false,		"",       dfNone, -1, false ,false);
 					  InitDataProperty(0, cnt++, dtData,					160,		daCenter,	false,	prefix+"jb_status",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					150,	daCenter,	false,	prefix+"eff_dt",			false,		"",       dfUserFormat2, -1, false ,false);
 					  InitDataProperty(0, cnt++, dtHidden,					150,	daCenter,	false,	prefix+"jb_end_dt",			false,		"",       dfUserFormat2, -1, false ,false);
 					  InitDataProperty(0, cnt++, dtHidden,					0,	daCenter,	false,	prefix+"jb_id",			false,		"",       dfNone, -1, false ,false);
 					 
 					  InitUserFormat2(0, prefix+"eff_dt", "####-##-## ##:##", "-|:" );
 					  InitUserFormat2(0, prefix+"jb_end_dt", "####-##-## ##:##", "-|:" );
  					
                  }
                  break;
          }
    }   


    /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
    function initControl() {
   	  
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	var form = document.form;
     	
        //Axon 이벤트 처리1. 이벤트catch
   	  	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
   	  	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
   	  	axon_event.addListenerFormat('keypress','obj_keypress', form); 
 		axon_event.addListener('keypress', 'obj_keypress', 'from_dt', 'to_dt');
 		//axon_event.addListener('focusout', 'chk_datevalue', 'from_dt', 'to_dt');    	  	
    	//axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    
    	axon_event.addListener  ('blur'  , 'param_date_onblur', 'param_date');
    }
      
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
     	 ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
     	 ComClearSeparator(event.srcElement);
    }

	function obj_keypress(){
		 
		switch(event.srcElement.dataformat){
		    case "ym":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		    case "ymd":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;	
		}
	}      
	  
	function form_keyup(){
	   	ComKeyEnter('lengthnextfocus');
	}        
	 
    //param_date 변경시 조회 
    function param_date_onblur(){
     	
   	 	var formObject = document.form;
		
		if (formObject.param_date.value ==null || formObject.param_date.value ==""){
			
			ComShowCodeMessage('TOT00003');
			ComSetFocus(formObject.param_date);
			
			return false;
		}

    }          
	  
    //run_job 변경시 조회 
    function run_job_OnChange(idx_cd, text){
   	  
	   	var formObject = document.form;
	   	//alert("jobStatus ::: "+jobStatus);
		      	if(text == "0"){
						//ComBtnEnable("btn_Calendar");
						ComEnableObject(formObject.all.item("btn_Calendar"), true);
						formObject.st_date.disabled = false;
						formObject.st_date_hh.disabled = false;
						formObject.st_date_mm.disabled = false;  
						formObject.st_date.value = "";
						formObject.st_date_hh.value = "";
						formObject.st_date_mm.value = "";
						
		      	}else{
					    //ComBtnEnable("btn_Calendar");
					    ComEnableObject(formObject.all.item("btn_Calendar"), false);
					    formObject.st_date.disabled = true;
						formObject.st_date_hh.disabled = true;
						formObject.st_date_mm.disabled = true;   

						var ymd = ComGetNowInfo("ymd");
						var hm  = ComGetNowInfo("hm");
						
						formObject.st_date.value = ymd;
						
						formObject.st_date_hh.value = hm.substring(0,2);
						formObject.st_date_mm.value = hm.substring(3,5);

		      	}
    }

    /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
	function initCombo(comboObj, comboNo) {
	
	    var formObject = document.form
	     
	    switch(comboNo) {  
	     	case 1: 
	            with (comboObj) { 
	 				MultiSelect = false; 
	 				UseAutoComplete = false;	
	 				SetColAlign("left|left");        
	 				SetColWidth("0|130");
	 				DropHeight = 160;
	  		   }
	            
		             comboObj.InsertItem(0, "Period Setting" + "|" + "Period Setting", "0");
		             comboObj.InsertItem(1, "As soon as possible" + "|" + "As soon as possible", "1");
		            
		             comboObj.index = -1;
	  	    break; 
	     	case 2: 
	            with (comboObj) { 
	 				MultiSelect = false; 
	 				UseAutoComplete = false;	
	 				SetColAlign("left|left");        
	 				SetColWidth("0|130");
	 				DropHeight = 160;
	  		   }
	          
		             comboObj.InsertItem(0, "ALL" + "|" + "ALL", "FNS_TOT_B001");
		             comboObj.InsertItem(1, "MAIN TRADE" + "|" + "MAIN TRADE", "FNS_TOT_B002");
		             comboObj.InsertItem(2, "FEEDER" + "|" + "FEEDER", "FNS_TOT_B003");
		             comboObj.index = -1;
	  	    break; 	
	  	} 
	}     

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg = false;
          
          switch(sAction) {
  					case IBSEARCH:      //조회
  					
 	 		             if (validateForm(sheetObj, formObj, sAction)){
 	 		             	
 	 		                 if ( sheetObj.id == "sheet1"){
 	 		     				 formObj.f_cmd.value = SEARCH;
 	 		     				 var prefix = "sheet1_";	//prefix 문자열 배열
 	 		     				
 	 			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0021GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
 	 		
 	 			    			sheetObjects[0].LoadSearchXml(sXml);
 	 			    			
	 	 			  	    	for(var i=1; i<=sheetObjects[0].RowCount; i++){
	 	 				    		
	 	 				    		if(sheetObjects[0].CellValue(i, prefix+"jb_status") == "Scheduled"){
	 	 				    			sheetObjects[0].CellEditable(i,prefix+"upd_chk") = true;
	 	 				    		}else{
	 	 				    			sheetObjects[0].CellEditable(i,prefix+"upd_chk") = false;
	 	 				    		}
	 	 			            }
	 	 			  	   
 	 		                 }
 	 		             }   
 	 					 
  					break;
  					
  					case IBSAVE:        //저장

 				     	if (validateForm(sheetObj, formObj, sAction)){
 					     	
			    			var SaveStr = ComGetSaveString(sheetObjects);
			    			
			    			if (!ComShowCodeConfirm('TOT00061')){
			    				return;
			    			}

		                	sheetObj.WaitImageVisible=false;
		                	ComOpenWait(true);	
		                	
			    			formObj.f_cmd.value = MULTI;
			    			
			    	   		 var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
			    			 var sXml = sheetObj.GetSaveXml("FNS_TOT_0021GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			    			 sheetObj.LoadSaveXml(sXml);

			    			 ComOpenWait(false);
 				    	} 						
 	 					
  					break;
  					
  					case IBSEARCH_ASYNC01:     
  						
 				     	if (validateForm(sheetObj, formObj, sAction)){
 					     	
 			    			var SaveStr = ComGetSaveString(sheetObjects);
 			    			
 			    			if (SaveStr == ""){
 			    				ComShowCodeMessage('TOT00011');
 			    				return;
 			    			}

			    			if (!ComShowCodeConfirm('TOT00079')){
			    				return;
			    			}
			    			
		                	 sheetObj.WaitImageVisible=false;
		                	 ComOpenWait(true);
		                	 
			    			 formObj.f_cmd.value = REMOVE01;
			    	   		 var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
			    			 var sXml = sheetObj.GetSaveXml("FNS_TOT_0021GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			    			 sheetObj.LoadSaveXml(sXml);
			    			 ComOpenWait(false);
 				    	} 						
 						
  					break;
          }
    }

    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
   		sheetObj.ShowDebugMsg = false;
   		var formObject = document.form;
   		var prefix="sheet1_";
   		
   		switch (sAction) {

 			
 			   case IBSEARCH: //조회
 			  
 				    if (formObject.from_dt.value ==null || formObject.from_dt.value ==""){
 					    ComShowCodeMessage('TOT00062');
 					    ComSetFocus(formObject.from_dt);
 					    return false;
 				    }
 				   
			       if (formObject.to_dt.value ==null || formObject.to_dt.value ==""){
					    ComShowCodeMessage('TOT00062');
					    ComSetFocus(formObject.to_dt);
					    return false;
				    }
			      
			        if (formObject.from_dt.value > formObject.to_dt.value){
					    ComShowCodeMessage('TOT00039');
					    ComSetFocus(formObject.to_dt);
					    return false;
				    }
			       
 				break;
 			   case IBSAVE:   //저장
 			   
				    if (formObject.param_start_dt.value ==null || formObject.param_start_dt.value ==""){
 					    ComShowCodeMessage('TOT00062');
 					    ComSetFocus(formObject.param_start_dt);
 					    return false;
 				    }

			        if (formObject.param_end_dt.value ==null || formObject.param_end_dt.value ==""){
					    ComShowCodeMessage('TOT00062');
					    ComSetFocus(formObject.param_end_dt);
					    return false;
				    }

			        var cur_ym = ComGetNowInfo("ym"); 
			        cur_ym = ComGetUnMaskedValue(cur_ym,"ym");  
			       
			        var rev_s_ym = ComGetUnMaskedValue(formObject.param_start_dt.value,"ym"); 
			        var rev_e_ym = ComGetUnMaskedValue(formObject.param_end_dt.value,"ym"); 
			        
			        if(cur_ym < rev_s_ym){
			           ComShowCodeMessage('TOT00076');
			           ComSetFocus(formObject.param_start_dt);
					   return false;
			        }

			        if(cur_ym < rev_e_ym){
				           ComShowCodeMessage('TOT00076');
				           ComSetFocus(formObject.param_end_dt);
						   return false;
				    }
			        
			        if (formObject.param_end_dt.value ==null || formObject.param_end_dt.value ==""){
					    ComShowCodeMessage('TOT00062');
					    ComSetFocus(formObject.param_end_dt);
					    return false;
				    }
			        
			        if (formObject.param_start_dt.value > formObject.param_end_dt.value){
					    ComShowCodeMessage('TOT00039');
					    ComSetFocus(formObject.param_end_dt);
					    return false;
				    }
			        
 				    if (formObject.run_job.Code ==null || formObject.run_job.Code ==""){
 				    	ComShowCodeMessage('TOT00063');
 					    ComSetFocus(formObject.run_job);
 					    return false;
 				    }

				    
 			        if(formObject.run_job.Code == "0"){
     				    if (formObject.st_date.value ==null || formObject.st_date.value ==""){
     				    	ComShowCodeMessage('TOT00064');
     					    ComSetFocus(formObject.st_date);
     					    return false;
     				    }
     				    if (formObject.st_date_hh.value ==null || formObject.st_date_hh.value ==""){
     				    	ComShowCodeMessage('TOT00065');
     					    ComSetFocus(formObject.st_date_hh);
     					    return false;
     				    }     				    
     				    if (formObject.st_date_mm.value ==null || formObject.st_date_mm.value ==""){
     				    	ComShowCodeMessage('TOT00066');
     					    ComSetFocus(formObject.st_date_mm);
     					    return false;
     				    } 
                        var cur_ymdhm ="";
                        var rev_ymdhm ="";
                        
     				    var cur_ymd = ComGetNowInfo("ymd"); 
     				    var cur_hm = ComGetNowInfo("hm");
                        
                        cur_ymdhm = ComGetUnMaskedValue(cur_ymd,"ymd");  
     		    	    cur_ymdhm = cur_ymdhm + ComGetUnMaskedValue(cur_hm,"hm"); 
     		    	    rev_ymdhm = ComGetUnMaskedValue(formObject.st_date.value,"ymd");
     		    	    rev_ymdhm = rev_ymdhm + formObject.st_date_hh.value + formObject.st_date_mm.value;

     		    	    if(cur_ymdhm >rev_ymdhm){
     				    	ComShowCodeMessage('TOT00075');
     					    ComSetFocus(formObject.st_date);
     					    return false;
     		    	    }
     		    	     
 			        }
 			        
				    if (formObject.bat_id.Code ==null || formObject.bat_id.Code ==""){
 				    	ComShowCodeMessage('TOT00074');
 					    ComSetFocus(formObject.bat_id);
 					    return false;
 				    } 			        
 			   break;
 			   
 			   case IBSEARCH_ASYNC01: //취소


			break;     			   
   			default:
   				break;
   		}
   		return true;

    }
