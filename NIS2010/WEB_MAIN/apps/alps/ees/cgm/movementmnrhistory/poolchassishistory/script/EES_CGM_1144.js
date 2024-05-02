/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1144.js
*@FileTitle : Pool Chassis M&R Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.13 최민회
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
     * @class EES_CGM_1144 : EES_CGM_1144 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1144() {
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

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;

 				case "btn_New":
 					formObj.reset();
               	    formObj.chss_pool_cd.text = "";
 					sheetObject1.RemoveAll();
 					sort_OnChange();
 					break;

 				case "btn_DownExcel":
 					sheetObject1.SpeedDown2Excel();
 					break;
				case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal = new ComCalendar();
				    if(document.form.sort.value == "1"){
		 				cal.select(formObject.mvmt_dt_fr, "yyyy-MM-dd");
				    } else {
				    	cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_fr, "yyyy-MM");
				    }
	                
					break;  
				case "btns_Calendar2" :		// Agreement Date (From Date)
	 				var cal = new ComCalendar();
	 				 if(document.form.sort.value == "1"){
		 				cal.select(formObject.mvmt_dt_to, "yyyy-MM-dd");
				    } else {
				    	cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_to, "yyyy-MM");
				    }
		                
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

         formObj = document.form;
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
         axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         comboObjects[0] = document.chss_pool_cd;
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
 		 sort_OnChange();
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
     	formObj.chss_pool_cd.focus();
       
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
                     style.height = 335;

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

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(21, 5, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     var HeadTitle1 = "|Seq.|S. Provider Name|S. Provider Location (FV-Office)|Invoice No.|Invoice Date|Chassis No.|MST chk|Repair Request Date|Repair Complete Date|Component|Location|Damage|Repair Type|Repair Inspection Type|Supplied Comp.|Hours|Labor Cost|Material Cost|Tax Amount|Total Cost";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,   0, daCenter, false, "ibflag");                                  
                     InitDataProperty(0, cnt++ ,  dtDataSeq,      40, daCenter, false, "Seq",    false, "", dfNone);               
                     InitDataProperty(0, cnt++ , dtData,         200,   daLeft, false, "vndr_nm");                                 
                     InitDataProperty(0, cnt++ , dtData,         200,   daLeft, false, "vndr_loc_nm");                             
                     InitDataProperty(0, cnt++ , dtData,         100,   daCenter, false, "inv_no");                                  
                                                                                                                                   
                     InitDataProperty(0, cnt++ , dtData,         100, daCenter, false, "inv_cre_dt",	false, "", dfDateYmd);        
                     InitDataProperty(0, cnt++ , dtData,         100, daCenter, false, "chss_no");                                 
                     InitDataProperty(0, cnt++ , dtData,          55, daCenter, false, "mst_chk"	);                            
                     InitDataProperty(0, cnt++ , dtData,         130, daCenter, false, "rpr_rqst_dt", false, "", dfDateYmd);   
                     InitDataProperty(0, cnt++ , dtData,         140, daCenter, false, "rpr_cmpl_dt", false, "", dfDateYmd);  
                     
                     InitDataProperty(0, cnt++ , dtData,         160,   daLeft, false, "chss_cmpo_nm");                            
                     InitDataProperty(0, cnt++ , dtData,         200,   daLeft, false, "chss_loc_nm"); 				
                     InitDataProperty(0, cnt++ , dtData,         120,   daLeft, false, "dmg_desc");                                
                     InitDataProperty(0, cnt++ , dtData,         140,   daLeft, false, "rpr_desc");   
                     InitDataProperty(0, cnt++ , dtData,         140,   daLeft, false, "rpr_insp_tp_desc"); 
                     
                     InitDataProperty(0, cnt++ , dtData,         140,   daLeft, false, "spl_cmpo_tp_cd");   
                     InitDataProperty(0, cnt++ , dtData,         100,  daRight, false, "rpr_hrs",     false, "", dfNumber);        
                     InitDataProperty(0, cnt++ , dtData,         100,  daRight, false, "lbr_cost_amt",  false, "", dfNullFloat, 2);                                                                                                                                    
                     InitDataProperty(0, cnt++ , dtData,         100,  daRight, false, "mtrl_cost_amt", false, "", dfNullFloat, 2);
                     InitDataProperty(0, cnt++ , dtData,          80,  daRight, false, "tax_amt",       false, "", dfNullFloat, 2);
                     
                     InitDataProperty(0, cnt++ , dtData,          80,  daRight, false, "cost_ttl_amt",  false, "", dfNullFloat, 2);
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
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 			    formObj.f_cmd.value = SEARCH;
	 			    
	 			    sheetObj.WaitImageVisible=false;
			 	    ComOpenWait(true);
			        var sXml = sheetObj.GetSearchXml("EES_CGM_1144GS.do" , FormQueryString(formObj));
	  		        var arrXml = sXml.split("|$$|");
	  		
	  		        var Xml = (arrXml[0]);
	  		        Summary_set(Xml,formObj);
	  		        
	  		        //alert(Xml);
	        	    sheetObjects[0].LoadSearchXml(arrXml[1]);
	        	    ComOpenWait(false);
 				break;

	       case IBSEARCH_ASYNC01:	// CP Combo 조회
	     		
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
				ss = ComCgmXml2ComboString(sXml, "TOTAL");
				var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
			  
				//IBSHEET GRID 밖에 있는 콤보
				makeCPMultiCombo(formObj.chss_pool_cd, cols, 0, 0);
	 	  	break;
	       	case IBSEARCH_ASYNC02:	// CP Combo 조회
	    		
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("CGM_CHSS_POOLGS.do?chss_Pool_Cd="+formObj.chss_pool_cd.text, FormQueryString(formObj));
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
			 		makeCPMultiCombo2(formObj.chss_pool_cd, arrStr1, 0, 0);     
			 		idx++;      
//				  	
			  	  	
			 		break;
         }
     }

     /**
      * Summary 세팅 
      * @param sXml
      * @param formObj
      * @return
      */
     function Summary_set(Xml,formObj){
//    	 formObj.chss_cnt.value  =    ComAddComma2(DomXml2String(Xml, "chss_cnt")+'', "#,###.00"); 
    	 formObj.chss_cnt.value  =    DomXml2String(Xml, "chss_cnt"); 
    	 formObj.chss_lbr.value  =    DomXml2String(Xml, "chss_lbr");
    	 formObj.chss_mtrl.value =    DomXml2String(Xml, "chss_mtrl");
    	 formObj.chss_amt.value  =    DomXml2String(Xml, "chss_amt"); 
    	 formObj.chss_ttl.value  =    DomXml2String(Xml, "chss_ttl"); 
    	 formObj.chss_cost.value =    DomXml2String(Xml, "chss_cost");
    	 
    	 formObj.un_chss_cnt.value  =    DomXml2String(Xml, "un_chss_cnt"); 
    	 formObj.un_chss_lbr.value  =    DomXml2String(Xml, "un_chss_lbr");  
    	 formObj.un_chss_mtrl.value =    DomXml2String(Xml, "un_chss_mtrl"); 
    	 formObj.un_chss_amt.value  =    DomXml2String(Xml, "un_chss_amt");  
    	 formObj.un_chss_ttl.value  =    DomXml2String(Xml, "un_chss_ttl");  
    	 formObj.un_chss_cost.value =    DomXml2String(Xml, "un_chss_cost"); 
    	 
    	 
    	 //alert(ComAddComma(formObj.chss_cnt.value));
//    	 formObj.chss_cnt.value  =    ComAddComma(formObj.chss_cnt.value);
//      	 formObj.chss_lbr.value  =    ComAddComma2(DomXml2String(Xml, "chss_lbr")+'', "#,###.00");
//    	 formObj.chss_mtrl.value =    ComAddComma2(DomXml2String(Xml, "chss_mtrl")+'', "#,###.00");
//    	 formObj.chss_amt.value  =    ComAddComma2(DomXml2String(Xml, "chss_amt")+'', "#,###.00"); 
//    	 formObj.chss_ttl.value  =    ComAddComma2(DomXml2String(Xml, "chss_ttl")+'', "#,###.00"); 
//    	 formObj.chss_cost.value =    ComAddComma2(DomXml2String(Xml, "chss_cost")+'', "#,###.00");
//    	 
    	 
//    	 formObj.un_chss_cnt.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_cnt")+'', "#,###.00");  
//    	 formObj.un_chss_cnt.value  =    DomXml2String(Xml, "un_chss_cnt"); 
//    	 formObj.un_chss_cnt.value  =    ComAddComma(formObj.un_chss_cnt.value);
//    	 formObj.un_chss_lbr.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_lbr")+'', "#,###.00");  
//    	 formObj.un_chss_mtrl.value =    ComAddComma2(DomXml2String(Xml, "un_chss_mtrl")+'', "#,###.00"); 
//    	 formObj.un_chss_amt.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_amt")+'', "#,###.00");  
//    	 formObj.un_chss_ttl.value  =    ComAddComma2(DomXml2String(Xml, "un_chss_ttl")+'', "#,###.00");  
//    	 formObj.un_chss_cost.value =    ComAddComma2(DomXml2String(Xml, "un_chss_cost")+'', "#,###.00"); 

    	 
     	
     }


      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리
       */
      function validateForm(sheetObj,formObj,sAction){
     	     with(formObj){
                  switch(sAction) {
                  	case IBSEARCH:      //조회
	                  	if(chss_pool_cd.text == ''){
	           				ComShowCodeMessage('CGM10004','Pool ');
	           				formObj.chss_pool_cd.focus();
	           				
	           				return false;
	           			}
	                  	if(formObj.mvmt_dt_fr.value == ''){
	           				ComShowCodeMessage('CGM10004','Period ');
	           				formObj.mvmt_dt_fr.focus();
	           				
	           				return false;
	           			}	
	    		 		if(formObj.mvmt_dt_to.value == ''){
	           				ComShowCodeMessage('CGM10004','Period ');
	           				formObj.mvmt_dt_to.focus();
	           				
	           				return false;
	           			}
	    		 		 var dt_str = ComReplaceStr(document.form.mvmt_dt_fr.value,"-","");
	        			 var dt_end = ComReplaceStr(document.form.mvmt_dt_to.value,"-","");
	    	        	
	  
	    	    		if(dt_str != '' && dt_end != ''){
	    	    			if(dt_end < dt_str){
	    	    				ComShowCodeMessage('COM12133','To date','From date','Period');
	    	    				mvmt_dt_fr.value='';
	    	    				
	    	    				formObj.mvmt_dt_fr.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		
	    	    		
                  	    break;
                  	
                  }

      			
              }

              return true;
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
          
        	   if(obj.name=="mvmt_dt_fr"  ){
            			
        		 with(formObj){
    	        			
        			 var creDtFr = ComReplaceStr(mvmt_dt_fr.value,"-","");
    	        }
    	        	
    	        ComChkObjValid(event.srcElement);
        	   }
    	        
    	       if(obj.name=="mvmt_dt_to"  ){
       			
    	     		 with(formObj){
    	 	        			
    	     			 var creDtFr = ComReplaceStr(mvmt_dt_to.value,"-","");
    	 	        }
    	 	        	
    	 	        ComChkObjValid(event.srcElement);
             }
            	
        }
         /** 
          * Object 의 activate 이벤트에 대한 처리  <br>
          * @param  없음
          * @return 없음
          * @author 최민회
          * @version 2009.07.17
          */
         function obj_activate(){
           	ComClearSeparator(event.srcElement);
         } 
         
          /** 
           * Combo Object 초기화  <br>
           * @param  {object} comboObj	필수 Combo Object
           * @return 없음
           * @author 최민회
           * @version 2009.07.16
           */ 
          function initCombo(comboObj) {
          	switch(comboObj.id) {
      	  	        
      	    	case "chss_pool_cd":
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
        * @author 최민회
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
         * CP Combo Object 에 값을 추가하는 처리 <br>
         * @param  {object} cmbObj	필수 Combo Object
         * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
         * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
         * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
         * @return 없음
         * @author 최민회
         * @version 2009.07.16
         */ 
         function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
            	cmbObj.RemoveAll();
         
            	// LOOP를 돌리기 위해 데이타 갯수를 구함 
            	if(arrStr == undefined ){
            		cmbObj.Index2 = "" ;
            	} else {
                	for (var i = 0; i < arrStr.length;i++ ) {
                		var arrCode = arrStr[i].split("|");
                  		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
    	          	}
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
	function chss_pool_cd_OnChange(comboObj, Index_Code, Text){
		
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
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
    	 	case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	        break;
    	 }
     }
      
      function sort_OnChange(){
    	  document.form.mvmt_dt_fr.value = "";
    	  document.form.mvmt_dt_to.value = "";
       	  if(document.form.sort.value == "1"){
       		  document.getElementById("mvmt_dt_fr").setAttribute("maxLength", 8);
       		  document.getElementById("mvmt_dt_fr").setAttribute("dataformat", "ymd");
       	      document.getElementById("mvmt_dt_to").setAttribute("maxLength", 8);
       	      document.getElementById("mvmt_dt_to").setAttribute("dataformat", "ymd");
       	  } else {
       		  document.getElementById("mvmt_dt_fr").setAttribute("maxLength", 6);
       		  document.getElementById("mvmt_dt_fr").setAttribute("dataformat", "ym");
     	      document.getElementById("mvmt_dt_to").setAttribute("maxLength", 6);
     	      document.getElementById("mvmt_dt_to").setAttribute("dataformat", "ym");
       	  }
      }
	/* 개발자 작업  끝 */