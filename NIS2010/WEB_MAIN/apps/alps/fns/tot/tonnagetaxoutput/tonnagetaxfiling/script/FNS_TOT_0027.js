/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_TOT_0027.js
*@FileTitle : Summary Creation - Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.12.16 이병훈
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
      * @class fns_tot_0027 : fns_tot_027 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
      */
    function fns_tot_0027() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

    // 공통전역변수
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
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

				case "btns_back":
 	                 if(formObject.batch_year.value == null || formObject.batch_year.value == ""){
 	                	ComShowCodeMessage('TOT00084', 'Batch Period');
   	                	 ComSetFocus(formObject.batch_year);
   	                	 return;
   	                 }
   	                 formObject.batch_year.value = ComGetDateAdd(formObject.batch_year.value+"-01-01","Y",-1).substring(0,4);
            	break;

				case "btns_next":
	                 if(formObject.batch_year.value == null || formObject.batch_year.value == ""){
	                	 ComShowCodeMessage('TOT00084', 'Batch Period');
   	                	 ComSetFocus(formObject.batch_year);
   	                	 return;
   	                 }
   	                 formObject.batch_year.value = ComGetDateAdd(formObject.batch_year.value+"-01-01","Y", 1).substring(0,4);
            	break;
            	
				case "btns_back2":
	                 if(formObject.search_year.value == null || formObject.search_year.value == ""){
	                	 ComShowCodeMessage('TOT00084', 'Period');
  	                	 ComSetFocus(formObject.search_year);
  	                	 return;
  	                 }
  	                 formObject.search_year.value = ComGetDateAdd(formObject.search_year.value+"-01-01","Y",-1).substring(0,4);
  	                 break;

				case "btns_next2":
	                 if(formObject.search_year.value == null || formObject.search_year.value == ""){
	                	 ComShowCodeMessage('TOT00084', 'Period');
  	                	 ComSetFocus(formObject.search_year);
  	                	 return;
  	                 }
  	                 formObject.search_year.value = ComGetDateAdd(formObject.search_year.value+"-01-01","Y", 1).substring(0,4);
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
    
                      //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          			  InitDataProperty(0, cnt++, dtHiddenStatus,  0, daCenter, true, "ibflag"   );
        			  InitDataProperty(0, cnt++, dtCheckBox    ,  20, daCenter, true , "upd_chk"  );
                      InitDataProperty(0, cnt++, dtSeq,				30,			daCenter,		true,		"Seq");
                      InitDataProperty(0, cnt++, dtData,					120,		daCenter,	true,		"jb_fm_yrmon",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					120,		daCenter,	true,		"jb_to_yrmon",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					200,		daCenter,	false,	"bat_itm_nm",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					160,		daCenter,	false,	"bat_id",				false,		"",       dfNone, -1, false ,false);
 					  InitDataProperty(0, cnt++, dtData,					150,		daCenter,	false,	"jb_status",				false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,					150,	daCenter,	false,	"eff_dt",			false,		"",       dfUserFormat2, -1, false ,false);
 					  InitDataProperty(0, cnt++, dtHidden,					150,	daCenter,	false,	"jb_end_dt",			false,		"",       dfUserFormat2, -1, false ,false);
 					  InitDataProperty(0, cnt++, dtHidden,					0,	daCenter,	false,	"job_id",			false,		"",       dfNone, -1, false ,false);
 					 
 					  InitUserFormat2(0, "eff_dt", "####-##-## ##:##", "-|:" );
 					  InitUserFormat2(0, "jb_end_dt", "####-##-## ##:##", "-|:" );
                  }
                  break;
          }
    }   
	  
    //run_job 변경시 조회 
    function run_job_OnChange(idx_cd, text){
	   	var formObject = document.form;
	   	
		      	if(text == "0"){
						ComEnableObject(formObject.all.item("btn_Calendar"), true);
						formObject.st_date.disabled = false;
						formObject.st_date_hh.disabled = false;
						formObject.st_date_mm.disabled = false;  
						formObject.st_date.value = "";
						formObject.st_date_hh.value = "";
						formObject.st_date_mm.value = "";
						
		      	}else{
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
	 				SetColWidth("0|150");
	 				DropHeight = 160;
	  		   }
	          
	             comboObj.InsertItem(0, "ALL" + "|" + "ALL", "");
	             comboObj.InsertItem(1, "Basic BSA Summary" + "|" + "Basic BSA Summary", "FNS_TOT_B004");
	             comboObj.InsertItem(2, "Actual BSA Summary" + "|" + "Actual BSA Summary", "FNS_TOT_B005");
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
 		     				 formObj.f_cmd.value = SEARCH;
 		     				
 			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0027GS.do", FormQueryString(formObj));
 			    			sheetObjects[0].LoadSearchXml(sXml);
 			    			
 	 			  	    	for(var i=1; i<=sheetObjects[0].RowCount; i++){
 	 				    		
 	 				    		if(sheetObjects[0].CellValue(i, "jb_status") == "Scheduled"){
 	 				    			sheetObjects[0].CellEditable(i, "upd_chk") = true;
 	 				    		}else{
 	 				    			sheetObjects[0].CellEditable(i, "upd_chk") = false;
 	 				    		}
 	 			            }
 	 		             }   
 	 					 
  					break;
  					
  					case IBSAVE:        //저장

 				     	if (validateForm(sheetObj, formObj, sAction)){
			    			
			    			if (!ComShowCodeConfirm('TOT00061')){
			    				return;
			    			}

		                	sheetObj.WaitImageVisible=false;
		                	ComOpenWait(true);	
		                	
			    			formObj.f_cmd.value = MULTI;
			    			formObj.bat_itm_nm.value = formObj.bat_id.Text;
			    			
			    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0027GS.do", FormQueryString(formObj));
			    			sheetObj.LoadSaveXml(sXml);
			    			ComOpenWait(false);
			    			 
//			    			 if(ComGetEtcData(sXml,"exp_msg") == "0"){
//			    				 ComShowCodeMessage('TOT00077');
//			    			 }else if(ComGetEtcData(sXml,"exp_msg") == "1"){
//			    				 ComShowCodeMessage('TOT00078');
//			    			 }
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
		                	 
			    			 formObj.f_cmd.value = REMOVE;
			    			 var sXml = sheetObj.GetSaveXml("FNS_TOT_0027GS.do", SaveStr + "&" + FormQueryString(formObj));
			    			 sheetObj.LoadSaveXml(sXml);
			    			 ComOpenWait(false);
 				    	} 						
 						
  					break;
          }
    }
    
    // 저장완료후 재조회
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	var formObject = document.form;
		
		doActionIBSheet(sheetObj,formObject,IBSEARCH);
  	}

    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
   		sheetObj.ShowDebugMsg = false;
   		var formObject = document.form;
   		
   		switch (sAction) {
 			
 			   case IBSEARCH: //조회
 			  
					if (formObj.search_year.value ==null || formObj.search_year.value ==""){
 						ComShowCodeMessage('TOT00084', 'Period');
 						ComSetFocus(formObj.search_year);
 						return false;
 					}
			       
 				break;
 				
 			   case IBSAVE:   //저장
 			   
 					if (formObj.batch_year.value ==null || formObj.batch_year.value ==""){
 						ComShowCodeMessage('TOT00084', 'Batch Period');
 						ComSetFocus(formObj.batch_year);
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
   		}
   		return true;

    }
