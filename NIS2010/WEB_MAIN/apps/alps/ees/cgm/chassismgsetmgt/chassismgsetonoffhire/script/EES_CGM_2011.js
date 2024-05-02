/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2011.js
*@FileTitle : M.G.Set 반납 Creation 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.26 최민회
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
     * @class ees_cgm_2011 : ees_cgm_2011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_2011() {
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
                    case "New":
                    	sheetObject1.RemoveAll();
     					formObject.reset();
     					document.forms[0].sts_evnt_ofc_cd.value = "";
     					document.forms[0].sts_evnt_yd_cd.value = "";
     					document.forms[0].sts_evnt_dt.value = "";
    					break;

                    case "Row_Add":
                    	doActionIBSheet(sheetObject1,formObject,IBINSERT);
    					break;

                    case "Delete":
                    	doActionIBSheet(sheetObject1,formObject,REMOVE);
    					break;
    					
                    case "btn_verify":
                   	    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        break;
                        
                    case "Save":
                    	doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					break;
    					
                    case "btn_loadexcel":
                      	//sheetObject1.SpeedDown2Excel();  
                     	doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
                         break
                         
                    case "ComOpenPopupWithTargetYard":
             			//chungpa 20100415 new yard popup start
             			//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
             			ComOpenPopup("/hanjin/EES_LSE_0101.do", 800, 450, "setPopData_AvailYard", '1,0', true, false);//, Row, Col, 0);
             			//chungpa 20100415 new yard popup end             			
             			Matched_Chk('Yard');
             			break;
             			
                    case "ComOpenPopupWithTargetOffice":
             			ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?pgmNo=COM_ENS_071', 800, 480, "ofc_cd:sts_evnt_ofc_cd", "1,0,1,1,1,1,1", true);
             			Matched_Chk('Office');
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
             formObj = document.form;
             // axon event 등록
             axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
             
             axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
             axon_event.addListenerFormat('beforeactivate',	  'obj_activate',   formObj);
             axon_event.addListener('change', 'obj_change', 'sts_evnt_ofc_cd');
             axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
             axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   formObj);
             // 초기화
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
              
              // 초기 focus
              formObj.sts_evnt_ofc_cd.focus();
            
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

                        // 높이 설정
                        style.height = 380;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

    					var HeadTitle = "|||Seq.|M.G.Set No.|Type|Lease Term|On-Hire Date|Agreement No.|Reference No.|Lessor|Verify Result|||";
    					var headCount = ComCountHeadTitle(HeadTitle);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,      0,    daCenter,  true,     "ibflag");
//                        InitDataProperty(0, cnt++ , dtStatus,      30,    daCenter,  true,     "ibflag");
                        InitDataProperty(0, cnt++ ,  dtHidden,       0,     daCenter,  	     false,    "vndr_seq",   	   false,  "",      dfNone,  	    0,     false, false);
		                InitDataProperty(0, cnt++ , dtCheckBox,		   30,     daCenter,	  true,	   "del_chk",	       false,  "",      dfNone,	   0,      true,  true);
	                    InitDataProperty(0, cnt++ , dtDataSeq,         30,     daCenter,  	 false,    "no",   			   false,  "",      dfNone,     	0,     false, false);
	                    InitDataProperty(0, cnt++ , dtData,  		  100,     daCenter,  	 false,    "eq_no",    	       false,  "",      dfNone,      	0,     true,  true,10);
	                    
	                    InitDataProperty(0, cnt++ , dtData,    		   60,     daCenter,  	 false,    "eq_tpsz_cd",   	   false,  "",      dfNone,     	0,     false, false);
	                    InitDataProperty(0, cnt++ , dtData,  		   80,     daCenter,  	 false,    "agmt_lstm_cd",     false,  "",      dfNone,      	0,     false, false);
	                    InitDataProperty(0, cnt++ , dtData,   		  110,     daCenter,  	 false,    "onh_dt",     	   false,  "",      dfDateYmd,     0,     false, false);
	                    InitDataProperty(0, cnt++ , dtData,  		  110,     daCenter,  	 false,    "agreement",        false,  "",      dfNone,      	0,     false, false);
	                    InitDataProperty(0, cnt++ , dtData,  		  110,     daCenter,  	 false,    "agmt_ref_no",      false,  "",      dfNone,      	0,     false, false);
	                    
	                    InitDataProperty(0, cnt++ , dtData,    		  250,     daCenter,  	 false,    "vndr_nm",   	   false,  "",      dfNone,  	    0,     false, false);
	                    InitDataProperty(0, cnt++ , dtData,      	  100,     daCenter,  	 false,    "verify", 	       false,  "",      dfNone,  	    0,     false, false);
	                    InitDataProperty(0, cnt++ , dtHidden,      		0,     daCenter,  	 false,    "sts_evnt_ofc_cd"  );
	                    InitDataProperty(0, cnt++ , dtHidden,     		0,     daCenter,  	 false,    "sts_evnt_yd_cd"  );
	                    InitDataProperty(0, cnt++ , dtHidden,     		0,     daCenter,  	 false,    "sts_evnt_dt"  );
	                    
	                    InitDataValid(0,  "eq_no", vtEngUpOther, "1234567890");

                   }
                    break;

     

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

                 case IBSEARCH:      //조회
			 		 	var verifyFlag = false; 
			              var chkFlag    = false;
					 	  formObj.f_cmd.value = SEARCHLIST;
//			              var sXm = sheetObj.DoSave("EES_CGM_1009GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
//			             var sXml = sheetObj.GetSearchXml("EES_CGM_1009GS.do");
			             queryString = "f_cmd=" + SEARCHLIST ;
//			    		 var sXml = sheetObj.GetSearchXml ("EES_CGM_1009GS.do", queryString+"&"+params);
			    		 for(i=1; i<=sheetObj.rowCount; i++){
						 		var del_chk = sheetObj.CellValue(i, "del_chk");
								// 필수 입력값 검증
								if(del_chk == "1"  ) {
									sheetObj.RowStatus(i) = "U";
									//ComShowMessage(sheetObj.CellValue(i, "ibflag"));
									sheetObj.CellValue(i, "sts_evnt_dt")      = formObj.sts_evnt_dt.value;
									chkFlag = true;
								}
								 
						 }
			    		 var params = sheetObj.GetSaveString(true);
					 	 if(sheetObj.rowCount>0  && chkFlag)
					 	 {
					  		sheetObj.WaitImageVisible=false;
					 	    ComOpenWait(true);
					 		sheetObj.DoSearch("EES_CGM_2011GS.do",  queryString+"&"+params);
						 	for(i=1; i<=sheetObj.rowCount; i++){
						 		var verify = sheetObj.CellValue(i, "verify");
			 					// 필수 입력값 검증
			 					if(verify != "OK"  ) {
			 						if(sheetObj.CellValue(i, "eq_no") == ""){
			 							sheetObj.CellValue(i, "del_chk") = "1";
			 						}else{
			 							verifyFlag = true;
			 						} 							
			 					}
								 
							}
						 	ComOpenWait(false);
						 	if(verifyFlag )
			 			 	{
			 			 		ComShowCodeMessage("CGM10005", "Please check up the Verify Result.");
			 			 	}
			 		 	 }
			 		 	 else
			 		 	 {
			 		 		ComShowCodeMessage("CGM10008");
			 		 	 }
						 sheet_delete2(sheetObj);
			             break;
                    break;

    			 case IBSAVE:        //저장
    			 	var actionFlag = false; 
    			    var VerifyFlag = false;
    			 
    		 		
    			 	// 필수 입력값 검증
    					if(formObj.sts_evnt_ofc_cd.value == "" || formObj.sts_evnt_ofc_cd.value == null) {
    						ComShowCodeMessage("CGM10004", "Office");
    			
    						return;
    					}
    					
    					if(formObj.sts_evnt_yd_cd.value == "" || formObj.sts_evnt_yd_cd.value == null) {
    						ComShowCodeMessage("CGM10004", "Yard");
    			
    						return;
    					}
    					var yard = formObj.sts_evnt_yd_cd.value;
    					if(yard.length != 7) {
    						ComShowCodeMessage('CGM10044','Yard(7)');
    						return;
    					}
    					if(formObj.sts_evnt_dt.value == "" || formObj.sts_evnt_dt.value == null) {
    						ComShowCodeMessage("CGM10004", "Off-Hire Date");
    			
    						return;
    					}
    			
    					for(i=1; i<=sheetObj.rowCount; i++){
    						var verify = sheetObj.CellValue(i, "verify");
    						// 필수 입력값 검증
    						if(verify == "OK" && sheetObj.CellValue(i, "del_chk")== "1" ) {
    							
    							sheetObj.CellValue(i, "sts_evnt_ofc_cd")  = formObj.sts_evnt_ofc_cd.value;
    							sheetObj.CellValue(i, "sts_evnt_yd_cd")   = formObj.sts_evnt_yd_cd.value;
    							sheetObj.CellValue(i, "sts_evnt_dt")      = formObj.sts_evnt_dt.value;
//    							ComShowMessage(formObj.sts_evnt_ofc_cd.value);
//    							ComShowMessage(sheetObj.CellValue(i, "sts_evnt_ofc_cd"));
//    							sheetObj.CellValue(i, "ibflag")  = "U";
    							sheetObj.RowStatus(i) = "U";
    							actionFlag = true; 
    						}
    						else if(verify == "" && sheetObj.CellValue(i, "del_chk")== "1" ) {
    							
    							ComShowCodeMessage("CGM10004", "verify");
    							actionFlag = false; 
    							break;
    						}
    						else if(verify != "OK" && sheetObj.CellValue(i, "del_chk")== "1" ) {
    							VerifyFlag = true; 
    							break;
    						}
    						else
    						{
    							sheetObj.RowStatus(i) = "R";
//    							sheetObj.CellValue(i, "ibflag")  = "";
    						}
    					}
    			
    					if(VerifyFlag){
    				        	ComShowCodeMessage("CGM10005");
    				    }else if(actionFlag){
    						var params = sheetObj.GetSaveString(true);
    						formObj.f_cmd.value = MULTI;
    						queryString = "f_cmd=" + MULTI ;
    						var params = sheetObj.GetSaveString(true);
//    						ComShowMessage(" params ... "+params);
    						sheetObj.WaitImageVisible=false;
					 	    ComOpenWait(true);
    						if(sheetObj.DoSave("EES_CGM_2011GS.do",queryString + "&" + ComGetPrefixParam("")))
    						{
    							
//    							ComRowHideDelete(sheetObj,"del_chk");
    					 		sheet_delete(sheetObj);
    						}
    						 ComOpenWait(false);
//    						sheetObj.DoSave("EES_CGM_1009GS.do",queryString + "&" + params);
    					}
    					else
    					{
    						ComShowCodeMessage("CGM10008");
    					}
    		             break;

    			 case IBINSERT:      // 입력
    	 			sheetObj.DataInsert(-1);
    		        break;
    		        
    			 case REMOVE:	
//    		 		ComRowHideDelete(sheetObj,"del_chk");
    		 		sheet_delete(sheetObj);
    			    break;
    			    
    		 	 case IBLOADEXCEL:	// EXCEL UPLOAD
    	 			if (sheetObj.id == "sheet1") {
    	 				sheetObj.RemoveAll(); 				
    	 				sheetObj.LoadExcel();
    	 			}; 
    	 			break;
    	 			
    		 	 case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
    			   	formObj.f_cmd.value = COMMAND01;
    			   	formObj.ofc_cd.value = formObj.sts_evnt_ofc_cd.value;
    			   	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj));
    			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
    			   	
    			   	if(sCheckResult == COM_VALIDATION_FALSE){
    			   		ComShowCodeMessage('CGM10009','Office');
    			   		formObj.sts_evnt_ofc_cd.value = "";
    			   		formObj.sts_evnt_ofc_cd.focus();
    			   	} else {
    			   		Matched_Chk('Office');
    			   	}
    			   	
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
    			   	} else {
    			   		Matched_Chk('Yard');
    			   	}
    			   	break;
            }
        }

         /**
          * sheet 삭제 
          * @param sheetObj
          * @return
          */
          function sheet_delete(sheetObj)
          {
        	  for(i=sheetObj.rowCount; i>0; i--){
      			if(sheetObj.CellValue(i, "ibflag") != "" &&  sheetObj.CellValue(i, "del_chk")=="1") {
      				sheetObj.RowDelete(i, false);
      			}
      		 }
          }
          
          /**
           * sheet 삭제 
           * @param sheetObj
           * @return
           */
          function sheet_delete2(sheetObj)
          {
        	  for(i=sheetObj.rowCount; i>0; i--){
      			if(sheetObj.CellValue(i, "ibflag") != ""   && sheetObj.CellValue(i, "eq_no")== "") {
      				sheetObj.RowDelete(i, false);
      			}
      		 }
          }
         
      	/**
      	 * 달력
      	 * @return
      	 */
      	function showCalendar(){
          	var form = document.form;
          	var cal = new ComCalendar();
              //cal.setDisplayType('month');
          	cal.setEndFunction("processEndCal"); 
            cal.select(form.sts_evnt_dt, "yyyy-MM-dd");
        }
      	
         /**
          * Found date 입력시, 현재 날짜/시간 이후를 입력시 오류.
          * "Found Date cannot be later than now."
          * @return
          */
         function processEndCal(){
        	 var form = document.form;
        	 var dt   = ComReplaceStr(form.form_day.value,"-","");
        	 var dt2  = ComReplaceStr(form.sts_evnt_dt.value,"-","");
             if(dt2 > dt){
            	 form.sts_evnt_dt.value = "";
            	 form.sts_evnt_dt.focus();
            	 ComShowCodeMessage('CGM10069');
            	 return ;
     	    }  else {
     	    	var sheetObj = sheetObjects[0];
    				// chassis no 체크
    				for(jj=1; jj<sheetObj.rowCount+1; jj++){
    					sheetObj.CellValue(jj, "verify")= "";
    				}
     	    }
     
         }
      	 
      	/**
      	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
      	 * Agreement No 과 Referece No 의 유효성을 체크한다. 
      	 */
      	function sheet1_OnChange(sheetObj, Row, Col){
      		var sheetObj = sheetObjects[0];
      	 	var formObj  = document.form;
      	 	var prefix   = "";
      	 	var chk      = true;
//      	 	var Dupchk   = false;
      	 	var eqNoCol  = sheetObj.SaveNameCol( "eq_no");
     	 	
     	 	// Column 이 NIS Agreement No 일 경우 실행
     	 	if (Col == eqNoCol && Row !=0) {
     	 		
     	 		var cellValue = sheetObj.cellValue(Row, Col); 
     	 		
     	 		if (cellValue != ''){
     	 		    // Form parameter 에 값 세팅
 	 				if(Row >1)
 	 				{
 	 					// chassis no 체크
 	 					for(i=1; i<sheetObj.rowCount; i++){

 	 						if(sheetObj.CellValue(i, "eq_no")== cellValue && Row != i )
 		 					{
 		 						chk = false;
 		 					}
 		 				}
 	 					
 	 					if(chk == true)
 	 					{
 	 						OnChack(sheetObj, Row, Col,cellValue);
 	 					}
 	 					else
 	 					{
 	 						//ComShowMessage('Please check up the Duplicated Chassis No.');
 	 			        	ComShowCodeMessage("CGM10017"," Chassis No.");
 	 			        	// 해당 Cell 값을 Null로 설정
 	 						sheet_row_clear(sheetObj, Row, Col);
 	 					}
 	 				}
 	 				else
 	 				{
 	 					// 처음에는  chassis no 체크  않함 
 	 					OnChack(sheetObj, Row, Col,cellValue);
 	 				}
     	 		} else {
     	 		    // 해당 Cell 값을 Null로 설정
     	 			sheet_row_clear(sheetObj, Row, Col);
     	 		}
     	 	}
      	 
      	}
      	
      	/**
       	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
       	 * Agreement No 과 Referece No 의 유효성을 체크한다. 
       	 */
      	function OnChack(sheetObj, Row, Col,cellValue){
      		var sheetObj = sheetObjects[0];
      	 	var formObj = document.form;
      	 	
      		formObj.f_cmd.value = SEARCH;
     		formObj.eq_no.value = cellValue;
             var sXml             = sheetObj.GetSearchXml("EES_CGM_2011GS.do", FormQueryString(formObj));
             
             if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
     			// 체크 메시지 출력
             	//ComShowMessage('CGM20007');
             	ComShowCodeMessage("CGM10004", "Chassis No");
             	// 해당 Cell 값을 Null로 설정
             	sheet_row_clear(sheetObj, Row, Col);
     		}
             else
             {
             	sheetObj.cellValue(Row, "eq_tpsz_cd")            = DomXml2String(sXml, "eq_tpsz_cd");
             	sheetObj.cellValue(Row, "agmt_lstm_cd")          = DomXml2String(sXml, "agmt_lstm_cd");
             	sheetObj.cellValue(Row, "onh_dt")                = DomXml2String(sXml, "onh_dt");
         		sheetObj.cellValue(Row, "agreement")             = DomXml2String(sXml, "agreement");
         		sheetObj.cellValue(Row, "agmt_ref_no")           = DomXml2String(sXml, "agmt_ref_no");
         		sheetObj.cellValue(Row, "vndr_seq")              = DomXml2String(sXml, "vndr_seq");
         		sheetObj.cellValue(Row, "vndr_nm")               = DomXml2String(sXml, "vndr_nm");
         		sheetObj.cellValue(Row, "verify")                = '';
             }
     			// DB에 Agreement No 가 존재하지 않을 경우
     	 
            
      	}
       	 
       	 /**
     	  * 엑셀 업로드시 체크
     	  * @param sheetObj
     	  * @return
     	  */
     	function sheet1_OnLoadExcel(sheetObj){
     
     	// chassis no 체크
    		for(iChk=1; iChk<sheetObj.rowCount+1; iChk++){
    			
    			var cellValue = sheetObj.cellValue(iChk, "eq_no"); 
    			if (cellValue != ''){
    				formObj.f_cmd.value = SEARCH;
    		 		formObj.eq_no.value = cellValue;
    		 		//alert(Row);
    		         var sXml             = sheetObj.GetSearchXml("EES_CGM_2011GS.do", FormQueryString(formObj));
    		         if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
    		          	// 해당 Cell 값을 Null로 설정
	    		          	sheetObj.cellValue(iChk, "eq_tpsz_cd")            = '';
	    		          	sheetObj.cellValue(iChk, "agmt_lstm_cd")          = '';
	    		          	sheetObj.cellValue(iChk, "onh_dt")                = '';
	    		      		sheetObj.cellValue(iChk, "agreement")             = '';
	    		      		sheetObj.cellValue(iChk, "agmt_ref_no")           = '';
	    		      		sheetObj.cellValue(iChk, "vndr_seq")              = '';
	    		      		sheetObj.cellValue(iChk, "vndr_nm")               = '';
	    		      		sheetObj.cellValue(iChk, "verify")                = '';
    		  		  } else {
    		        	  sheetObj.cellValue(iChk, "eq_tpsz_cd")            = DomXml2String(sXml, "eq_tpsz_cd");
		             	  sheetObj.cellValue(iChk, "agmt_lstm_cd")          = DomXml2String(sXml, "agmt_lstm_cd");
		             	  sheetObj.cellValue(iChk, "onh_dt")                = DomXml2String(sXml, "onh_dt");
		         		  sheetObj.cellValue(iChk, "agreement")             = DomXml2String(sXml, "agreement");
		         		  sheetObj.cellValue(iChk, "agmt_ref_no")           = DomXml2String(sXml, "agmt_ref_no");
		         		  sheetObj.cellValue(iChk, "vndr_seq")              = DomXml2String(sXml, "vndr_seq");
		         		  sheetObj.cellValue(iChk, "vndr_nm")               = DomXml2String(sXml, "vndr_nm");
		         		  sheetObj.cellValue(iChk, "verify")                = '';
    		          }
    			}
    		}
     		
     	}
       	
       	 /**
       	  * 해당 Cell 값을 Null로 설정
       	  * @param sheetObj
       	  * @param Row
       	  * @param Col
       	  * @return
       	  */
       	function sheet_row_clear(sheetObj, Row, Col)
       	{
         	// 해당 Cell 값을 Null로 설정 
     		sheetObj.cellValue(Row, Col) = '';
     		sheetObj.cellValue(Row,  "eq_tpsz_cd") = '';
     		sheetObj.cellValue(Row,  "agmt_lstm_cd") = '';
     		sheetObj.cellValue(Row,  "onh_dt") = '';
     		sheetObj.cellValue(Row,  "agreement") = '';
     		sheetObj.cellValue(Row,  "agmt_ref_no") = '';
     		sheetObj.cellValue(Row,  "vndr_seq") = '';
     		sheetObj.cellValue(Row,  "vndr_nm") = '';
     		sheetObj.cellValue(Row,  "verify") = '';
     		
     		// 그리드에 포커스 이동
     		sheetObj.SelectCell(Row, Col, true);
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
         	        
         	    case "eng":
         	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
         	        else ComKeyOnlyAlphabet('upper');
         	        break;
         	        
         	    case "engup":
         	        if(obj.name=="sts_evnt_ofc_cd") ComKeyOnlyAlphabet('uppernum')
         	        else ComKeyOnlyAlphabet('upper');
         	        break;
         	        
         	    case "engdn":
         	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
         	        else ComKeyOnlyAlphabet('lower');
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
           
         	 if(obj.name=="sts_evnt_dt"  ){
         		 with(formObj){
         			 var creDtFr = ComReplaceStr(sts_evnt_dt.value,"-","");
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
        	 var sheetObj = sheetObjects[0];
        	 
        	 obj = event.srcElement;
        	 switch(obj.name){
        	 	case "sts_evnt_ofc_cd":
        	 		if(formObj.sts_evnt_ofc_cd.value != ''){
        	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
        	 			break;
        	 		}
//        	 	case "sts_evnt_yd_cd":
//        	 		if(formObj.sts_evnt_yd_cd.value != ''){
//        	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
//        	 			break;
//        	 		} 
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
        		    // chungpa 20100414 keyup->focusout start
        		    ComKeyEnter('lengthnextfocus');
        		    /*
    	    	    var sts_evnt_yd_cd;
        	    	sts_evnt_yd_cd = formObj.sts_evnt_yd_cd.value;
        	    	if (sts_evnt_yd_cd.length == 7) {
        	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
        	    	}
        	    	*/
        		    // chungpa 20100414 keyup->focusout end        	    	
        	    	break;
    	    	 }
    	    }
         
        	 
        	 
      
          
      /**
       * AXON 이벤트 처리
       */
      function obj_activate(){
          ComClearSeparator(event.srcElement);
      }
           
       /**
        * 야드와 오피스 체크
        * @param chk
        * @return
        */
       function Matched_Chk(chk){
 		 formObj = document.form;
 		 var sheetObj = sheetObjects[0];
 		 if(formObj.sts_evnt_yd_cd.value != "" && formObj.sts_evnt_ofc_cd.value != "" ){
 			 formObj.f_cmd.value = SEARCH01;
 			    formObj.ofc_cd.value = formObj.sts_evnt_ofc_cd.value;		//   ( location)
 			    formObj.loc_cd.value = formObj.sts_evnt_yd_cd.value.substr(0,5);
 		   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
 			    if(DomXml2String(sXml, "chk")!="OK"){
 					ComShowCodeMessage("CGM10028");
 					if(chk == 'Yard'){
 						formObj.sts_evnt_yd_cd.value = "";
 						formObj.sts_evnt_yd_cd.focus();
 					} else {
 						formObj.sts_evnt_ofc_cd.value = "";
 						formObj.sts_evnt_ofc_cd.focus();
 					}
 					
 					return;
 			    }
 			 
 		 }
     		 
       }  
       
       // 업무 자바스크립트 OnFocusOut 이벤트 처리
       function obj_focusout() {
       	switch(event.srcElement.name){ 
       	case "sts_evnt_dt":
       		 var form = document.form;
 	    	 var dt   =   ComReplaceStr(form.form_day.value,"-","");
 	    	 var dt2  =   ComReplaceStr(form.sts_evnt_dt.value,"-","");;
 	         if(form.sts_evnt_dt.value!="" &&  dt2 > dt){
 	        	 form.sts_evnt_dt.value = "";
 	        	 form.sts_evnt_dt.focus();
 	        	 ComShowCodeMessage('CGM10069');
 	        	 
 	        	 return;
 	 	    }  else {
 	 	    	var sheetObj = sheetObjects[0];
 	 	 					// chassis no 체크
 				for(jj=1; jj<sheetObj.rowCount+1; jj++){
 					sheetObj.CellValue(jj, "verify")= "";
  				}
 				return;			
 	 	    }
 	 		break;
	 	case "sts_evnt_yd_cd":
		    // chungpa 20100414 keyup->focusout start
	 		var formObj = document.form;
	 		var sheetObj = sheetObjects[0];
    	    var sts_evnt_yd_cd;
    	    sts_evnt_yd_cd = formObj.sts_evnt_yd_cd.value;
	    	if (sts_evnt_yd_cd.length == 7) {
	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	}
		    // chungpa 20100414 keyup->focusout end        	    	
	    	break;   	    		  
       	}
       } 
	/* 개발자 작업  끝 */