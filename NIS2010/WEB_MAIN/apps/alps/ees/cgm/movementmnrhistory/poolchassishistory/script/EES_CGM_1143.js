/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1143.js
*@FileTitle : Pool Chassis Expense Trend
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회
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
     * @class EES_CGM_1143 : EES_CGM_1143 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1143() {
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
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
					case "btn_retrieve":
						 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
					break; 
					
					case "btn_new":
						 formObj.reset();
	                	 formObj.chss_pool_cd.text = "";
	                	 sheetObject1.RemoveAll();
					break; 
					
					case "btn_downexcel":
						sheetObject1.SpeedDown2Excel(-1);
					break;
					case "btns_Calendar1" :		// Agreement Date (From Date)
		 				var cal = new ComCalendar();
	                    cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_fr, "yyyy-MM");
	 				break;  
					case "btns_Calendar2" :		// Agreement Date (From Date)
		 				var cal = new ComCalendar();
	                    cal.setDisplayType('month');
		 				cal.select(formObject.mvmt_dt_to, "yyyy-MM");
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
     	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
     	
     	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
     	formObj.chss_pool_cd.text = formObj.chss_pool.value;
     	if(formObj.prgId.value != ""){
     		doActionIBSheet(sheetObj,document.form,IBSEARCH); 
     	}
     	formObj.chss_pool_cd.focus();
       
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
   	  	            MultiSelect = true;
   	  	            MaxSelect = 100;	    
   	  	            UseCode = true;
   	  	            Enable = true;
   	  	        }
   	  	        
   	  	        break;
   	  	        
   	    	
   	    	
   	  	      
       	}
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
                     style.height = 440;
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
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false) 
                      
                     var HeadTitle1 = "|Seq.|Pool Name|YYYYMM|Estimated Amount|Invoice Amount|Credit|Debit";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 40,   daCenter, false, "HidStatus");
                     InitDataProperty(0, cnt++ , dtDataSeq,    	 30,   daCenter, false, "no",   		false, "", dfNone,     	0,     false,  false);
                     InitDataProperty(0, cnt++ , dtData, 		265,   daCenter, true,  "chss_pool_nm", false, "", dfNone,      0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,    	120,   daCenter, false, "mvmt_dt", 		false, "", dfDateYm,   	0,     true,	true);
 					 InitDataProperty(0, cnt++ , dtAutoSum,   	140,   daRight,  false,  "est_amount",  false, "", dfNullFloat, 2,     true,	true);
                                                                                                                                                   
                     InitDataProperty(0, cnt++ , dtAutoSum,   	140,   daRight,  false,  "inv_amount",  false, "", dfNullFloat, 2,     true,	true);
 					 InitDataProperty(0, cnt++ , dtAutoSum, 	140,   daRight,  false,  "credit",   	false, "", dfNullFloat,	2,     true,	true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   	100,   daRight,  false,  "debit",		false, "", dfNullFloat, 2,     true,	true);
                     
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
	 					   queryString = "f_cmd=" + SEARCH ;
		 				   var params = FormQueryString(formObj);
		 				   sheetObj.WaitImageVisible=false;
	  			 	       ComOpenWait(true);
	 					   sheetObj.DoSearch("EES_CGM_1143GS.do",  params);
	 					   sheetObj.SumText(0,1) = "";
	 					   sheetObj.SumText(0,2) = "Grand Total";
	 					   ComOpenWait(false);
 						}
 					break;
 					
 		       	   case IBSEARCH_ASYNC01:	// CP Combo 조회
 		     		
	 					formObj.f_cmd.value = SEARCH02;
	 					var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	 					ss = ComCgmXml2ComboString(sXml, "TOTAL");
	 					var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
	 				  
	 					//IBSHEET GRID 밖에 있는 콤보
	 					makeCPMultiCombo(formObj.chss_pool_cd, cols, 0, 0);
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
            	cmbObj.InsertItem(0,"All","");
            	for (var i = 1; i < arrCode.length+1;i++ ) {
	          		var arrCode3 = arrCode[i-1].split("|");
	          		var arrCode4 = arrCode2[i-1].split("|");
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

             	cmbObj.InsertItem(0,"All","");
             	for (var i = 1; i < arrStr.length+1;i++ ) {
             		var arrCode = arrStr[i-1].split("|");
              		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
 	          	}
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
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리
       */
      function validateForm(sheetObj,formObj,sAction){
     	     with(formObj){
                  switch(sAction) {
                  	case IBSEARCH:      //조회
	                  	if(formObj.mvmt_dt_fr.value == ''){
	           				ComShowCodeMessage('CGM10004','YYYYMM ');
	           				formObj.mvmt_dt_fr.focus();
	           				
	           				return false;
	           			}	
	    		 		if(formObj.mvmt_dt_to.value == ''){
	           				ComShowCodeMessage('CGM10004','YYYYMM ');
	           				formObj.mvmt_dt_to.focus();
	           				
	           				return false;
	           			}
	    		 		 var dt_str = ComReplaceStr(document.form.mvmt_dt_fr.value,"-","");
	        			 var dt_end = ComReplaceStr(document.form.mvmt_dt_to.value,"-","");
	    	        	
	  
	    	    		if(dt_str != '' && dt_end != ''){
	    	    			if(dt_end < dt_str){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				mvmt_dt_fr.value='';
	    	    				
	    	    				formObj.mvmt_dt_fr.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		
	    	    		if(chss_pool_cd.text == ''){
	           				ComShowCodeMessage('CGM10004','Pool ');
	           				formObj.chss_pool_cd.focus();
	           				
	           				return false;
	           			}
                  	    break;
                  	
                  }

      			
              }

              return true;
      }

 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			ShowSubSum(2, "4|5|6|7",-1, true, false, 0, "mvmt_dt=;chss_pool_nm=Sub Total");
 		}
 	}
 	
 	/**
 	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 	 * @return
 	 */
 	function chss_pool_cd_OnCheckClick(comboObj, index, code) {
 		if(index==0) {
 	    	//checked
 	    	var bChk = comboObj.CheckIndex(index);
 			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
 				comboObj.CheckIndex(i) = bChk;
 	    	}
 	    } else {
 			comboObj.CheckIndex(0) = false;
 	    }
 	}

	/* 개발자 작업  끝 */