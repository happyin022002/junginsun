/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1017.js
*@FileTitle : 분실 또는 되찾은 Chassis Status를 Creation 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.04 최민회
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.07.09 김창헌 [CHM-201218594-01] Enter나 Retrieve 하지 않고 자동적으로 조회되게 수정
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
     * @class ees_cgm_1017 : ees_cgm_1017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1017() {
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

                 case "btn_new":
                	 objectClear();
                     break; 

                 case "btn_save":
 					 doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;
                     
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	                 if(formObj.yardChk[0].checked == true){
	                	 var cal = new ComCalendar();
	                	 cal.setEndFunction("processEndCal");  
	 	 				 cal.select(formObject.l_evnt_dt, "yyyy-MM-dd");
	 	 				
	                 }
                 	break;	
	 			 case "btns_Calendar2" :		// Agreement Date (To Date)
	 	    		if(formObj.yardChk[1].checked == true){
	                	 var cal = new ComCalendar();
	                	 cal.setEndFunction("processEndCal");  
	 	 				 cal.select(formObject.f_evnt_dt, "yyyy-MM-dd");
	 	 				
	                 }
	 			 	break;         
	 			case "ComOpenPopupWithTargetYard1":
	 				if(formObj.yardChk[0].checked == true){
	 					ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:l_evnt_yd_cd", "1,0,1,1,1,1,1", true);
	 					Matched_Chk('Yard');
	                }
          			break;
	 			case "ComOpenPopupWithTargetYard2":
          			if(formObj.yardChk[1].checked == true){
	 					ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:f_evnt_yd_cd", "1,0,1,1,1,1,1", true);
	 					Matched_Chk('Yard');
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
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
    	  for(i=0;i<sheetObjects.length;i++){

       		//khlee-시작 환경 설정 함수 이름 변경
           ComConfigSheet (sheetObjects[i] );

           initSheet(sheetObjects[i],i+1);
       		 
        	
         //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
       }
     	  formObj = document.form;
     	  axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
     	  axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
     	  axon_event.addListenerFormat('beforeactivate',	  'obj_activate',		formObj);
     	//  axon_event.addListener('change', 'obj_change' , 'l_evnt_yd_cd','f_evnt_yd_cd','eq_no' ); 
     	  axon_event.addListener('change', 'obj_change' ,'eq_no' ); 
     	  axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
     	  axon_event.addListenerForm('focusout', 'obj_focusout',formObj);
          initControl(sheetObjects[0]);   

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
        * Found date 입력시, 현재 날짜/시간 이후를 입력시 오류.
        * "Found Date cannot be later than now."
        * @return
        */
       function processEndCal(){
      	 var form = document.form;
      	 var dt   = ComReplaceStr(form.form_day.value,"-","");
      	 var dt2  = "";
      	 var dt3  = ComReplaceStr(form.sts_evnt_dt.value,"-","");
      	 var dt4  = ComReplaceStr(form.mvmt_dt.value,"-","");
      	 
      	 if(form.l_evnt_dt.value !=""){
      		 dt2  = ComReplaceStr(form.l_evnt_dt.value,"-","");
      		 if(dt2 > dt){
              	 form.l_evnt_dt.value = "";
              	 form.l_evnt_dt.focus();
              	 ComShowCodeMessage("CGM10058");
              	 return ;
       	    } 
      		if(dt2 < dt3){
            	 form.l_evnt_dt.value = "";
            	 form.l_evnt_dt.focus();
            	 ComShowCodeMessage("CGM10057");
            	 return ;
     	    } 
     		if(dt2 < dt4){
            	 form.l_evnt_dt.value = "";
            	 form.l_evnt_dt.focus();
            	 ComShowCodeMessage("CGM10057");
            	 return ;
     	    } 
      	 } else {
      		 dt2  = ComReplaceStr(form.f_evnt_dt.value,"-","");
      		 if(dt2 > dt){
              	 form.f_evnt_dt.value = "";
              	 form.f_evnt_dt.focus();
              	 ComShowCodeMessage("CGM10058");
              	 return ;
       	    } 
      		if(dt2 < dt3){
      			 form.f_evnt_dt.value = "";
             	 form.f_evnt_dt.focus();
                 ComShowCodeMessage("CGM10055");
	           	 return ;
    	    } 
      	 }
   
       }
        
        // 업무 자바스크립트 OnFocusOut 이벤트 처리
        function obj_focusout() {
        	switch(event.srcElement.name){ 
        	case "l_evnt_dt":
        		 var form = document.form;
	          	 var dt   =ComReplaceStr(form.form_day.value,"-","");
	          	 var dt2  = "";
	          	 var dt3  = ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	          	 var dt4  = ComReplaceStr(ComReplaceStr(ComReplaceStr(form.mvmt_dt.value,"-",""),":","")," ","");
	          	 var dt5  = ComReplaceStr(form.l_evnt_dt_hm.value,":","");
	          	 if(form.l_evnt_dt.value !="" && form.l_evnt_dt_hm.value !="" ){
	          		 dt2  = ComReplaceStr(form.l_evnt_dt.value,"-","");
		  	       	 if(dt2  > dt){
		             	 form.l_evnt_dt.value = "";
		             	 form.l_evnt_dt_hm.value = "";
		             	 form.l_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	          		if(dt2 + dt5 <= dt3){
	                 	 form.l_evnt_dt.value = "";
	                 	 form.l_evnt_dt_hm.value = "";
	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          		if(dt2+ dt5 <= dt4){
	                 	 form.l_evnt_dt.value = "";
	                 	 form.l_evnt_dt_hm.value = "";
	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          	 }
	  	 		break;
        	case "l_evnt_dt_hm":
        		var form = document.form;
	          	 var dt   =ComReplaceStr(form.form_day.value,"-","");
	          	 var dt2  = "";
	          	 var dt3  = ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	          	 var dt4  = ComReplaceStr(ComReplaceStr(ComReplaceStr(form.mvmt_dt.value,"-",""),":","")," ","");
	          	 var dt5  = ComReplaceStr(form.l_evnt_dt_hm.value,":","");
	          	 if(form.l_evnt_dt.value !="" && form.l_evnt_dt_hm.value !="" ){
	          		dt2  = ComReplaceStr(form.l_evnt_dt.value,"-","");
		  	       	 if(dt2  > dt){
		             	 form.l_evnt_dt.value = "";
		             	 form.l_evnt_dt_hm.value = "";
		             	 form.l_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	          		if(dt2 + dt5 <= dt3){
	                 	 form.l_evnt_dt.value = "";
	                 	 form.l_evnt_dt_hm.value = "";
	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          		if(dt2+ dt5 <= dt4){
	                 	 form.l_evnt_dt.value = "";
	                 	 form.l_evnt_dt_hm.value = "";
	                 	 form.l_evnt_dt.focus();
	                 	 ComShowCodeMessage("CGM10057");
	                 	 return ;
	          	    } 
	          	 }
	  	 		break;
        	case "f_evnt_dt":
	       		 var form = document.form;
	  	       	 var dt   = ComReplaceStr(form.form_day.value,"-","");
	  	       	 var dt2  = "";
	  	         var dt3  = ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	  	         var dt5  = ComReplaceStr(form.f_evnt_dt_hm.value,":","");
	  	       	 if(form.f_evnt_dt.value !="" && form.f_evnt_dt_hm.value !="" ){
	  	       		 dt2  = ComReplaceStr(form.f_evnt_dt.value,"-","");
		  	       	 if(dt2 > dt){
		             	 form.f_evnt_dt.value = "";
		             	 form.f_evnt_dt_hm.value = "";
		             	 form.f_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	  	       		 if(dt2+dt5 <= dt3){
			           	 form.f_evnt_dt.value = "";
		             	 form.f_evnt_dt_hm.value = "";
			           	 form.f_evnt_dt.focus();
			             ComShowCodeMessage("CGM10055");
			           	 return ;
	  	       		 } 
	  	       	 }
	  	         
	  	 		 break;
        	case "f_evnt_dt_hm":
	       		 var form = document.form;
	  	       	 var dt   = ComReplaceStr(form.form_day.value,"-","");
	  	       	 var dt2  = "";
	  	         var dt3  = ComReplaceStr(ComReplaceStr(ComReplaceStr(form.sts_evnt_dt.value,"-",""),":","")," ","");
	  	         var dt5  = ComReplaceStr(form.f_evnt_dt_hm.value,":","");
	  	       	 if(form.f_evnt_dt.value !="" && form.f_evnt_dt_hm.value !="" ){
	  	       		 dt2  = ComReplaceStr(form.f_evnt_dt.value,"-","");
		  	       	 if(dt2 > dt){
		             	 form.f_evnt_dt.value = "";
		             	 form.f_evnt_dt_hm.value = "";
		             	 form.f_evnt_dt.focus();
		             	 ComShowCodeMessage("CGM10058");
		             	 return ;
		      	     } 
	  	       		 if(dt2+dt5 <= dt3){
			           	 form.f_evnt_dt.value = "";
		             	 form.f_evnt_dt_hm.value = "";
			           	 form.f_evnt_dt.focus();
			             ComShowCodeMessage("CGM10055");
			           	 return ;
	  	       		 } 
	  	       	 }
	  	         
	  	 		 break;

	  	    // chungpa 20100414 keyup->focusout start	  	 		 
    	 	case "l_evnt_yd_cd":
    	 		var formObj = document.form;
    	    	var sheetObj = sheetObjects[0];    	 		
	    	    var l_evnt_yd_cd;
    	    	l_evnt_yd_cd = formObj.l_evnt_yd_cd.value;
    	    	if (l_evnt_yd_cd.length == 7) {
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	    	}
    	    	break;	 	
    	    	
    	 	case "f_evnt_yd_cd":
    	 		var formObj = document.form;
    	    	var sheetObj = sheetObjects[0];    	 		
	    	    var f_evnt_yd_cd;
    	    	f_evnt_yd_cd = formObj.f_evnt_yd_cd.value;
    	    	if (f_evnt_yd_cd.length == 7) {
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
    	    	}
    	    	break;    	    	
    	    // chungpa 20100414 keyup->focusout end    	    	
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
                      style.height = 170;
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

                      
                      var HeadTitle = "|Location|Term|Lessor|Total|SF2|SL2|TA2|SF4|GN4|CB4|GN5|EG5|EG8|ZT4";
                      var headCount = ComCountHeadTitle(HeadTitle);
                      
                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false) 

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);
                     	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,	120,	daCenter,		false,		"agreement");
                  	  InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                      InitDataProperty(0, cnt++ , dtData,			80,		daCenter,  false,		"eq_no",  		false,          "",      dfNone,     		0,     false,       false, 10);
    				  InitDataProperty(0, cnt++ , dtData,			50,		daCenter,  false,		"ofc_cd",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,	  	   100,	    daCenter,  false,		"eq_tpsz_cd",   	false,          "",      dfNone,     		0,     false,       false);
    				  InitDataProperty(0, cnt++ , dtData,			90,		 daRight,  false,		"agmt_lstm_cd",    	false,          "",      dfNone,      	0,     false,       false);
    										
                      InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"vndr_seq",   			false,          "",      dfNone,     		0,     false,       false);
    				  InitDataProperty(0, cnt++ , dtData,		    65,		 daRight,  false,		"eq_aset_sts_cd",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,		    65,		 daRight,  false,		"chss_mvmt_sts_cd",   			false,          "",      dfNone,  			0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"l_evnt_dt",   			false,          "",      dfNone,     		0,     false,       false);
    				  InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"f_evnt_dt",    		false,          "",      dfNone,      	0,     false,       false);
    										
                      InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"l_evnt_yd_cd",   			false,          "",      dfNone,     		0,     false,       false);
    				  InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"f_evnt_yd_cd",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"sts_evnt_dt",   			false,          "",      dfNone,   		  0,     false,       false);
    				  InitDataProperty(0, cnt++ , dtData,			65,		 daRight,  false,		"mvmt_dt",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,		    65,		 daRight,  false,		"zt4",   			false,          "",      dfNone,  			0,     false,       false);
                 }
                  break;
              

          }
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
         // 초기 focus
         formObj.eq_no.focus();
//         formObj.l_evnt_dt.disabled = true;
//         formObj.f_evnt_dt.disabled = false;
         
         
         yard_Chk();
  
     }
     
      /**
       * Form 의 Date yard 제어
       * @return
       * @author 최민회
       * @version 2009.06.04
       */
      function yard_Chk(){
    	  formObj = document.form;
    	  var l_chk ,f_chk;
    	  var l_cName,f_cName;
    	  if(formObj.yardChk[0].checked == true){
 
    		  l_chk = false;
    		  f_chk = true;
    		  l_cName = "input1";
    		  f_cName = "input2";
    	  } else {
       		  l_chk = true;
    		  f_chk = false;
    		  l_cName = "input2";
    		  f_cName = "input1";
    	  }
    	  
    	  formObj.l_evnt_dt.readOnly = l_chk;
          formObj.l_evnt_yd_cd.readOnly = l_chk;
          formObj.l_evnt_dt_hm.readOnly = l_chk;
          formObj.f_evnt_dt.readOnly = f_chk;
          formObj.f_evnt_yd_cd.readOnly = f_chk;
          formObj.f_evnt_dt_hm.readOnly = f_chk;
          
          formObj.l_evnt_dt.value = "";
          formObj.l_evnt_yd_cd.value = "";
          formObj.l_evnt_dt_hm.value = "";
          formObj.f_evnt_dt.value = "";
          formObj.f_evnt_yd_cd.value = "";
          formObj.f_evnt_dt_hm.value = "";
          
          ComEnableObject(formObj.btns_Calendar1, f_chk);
          ComEnableObject(formObj.btns_Calendar2, l_chk);
          
          ComEnableObject(formObj.ComOpenPopupWithTargetYard1, f_chk);
          ComEnableObject(formObj.ComOpenPopupWithTargetYard2, l_chk);
          
          
          
          formObj.l_evnt_dt.className = l_cName;
          formObj.l_evnt_yd_cd.className = l_cName;
          formObj.l_evnt_dt_hm.className = l_cName;
          formObj.f_evnt_dt.className = f_cName;
          formObj.f_evnt_yd_cd.className = f_cName;
          formObj.f_evnt_dt_hm.className = f_cName;
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
        
      	 if(obj.name=="l_evnt_dt"  ){
          			
      		 with(formObj){
   	        			
      			 var creDtFr = ComReplaceStr(l_evnt_dt.value,"-","");
   	        }
   	        	
   	        ComChkObjValid(event.srcElement);
          }
        	if(obj.name=="f_evnt_dt"  ){
   			
     		 with(formObj){
   	        			
     			 var creDtFr = ComReplaceStr(l_evnt_dt.value,"-","");
   	        }
   	        	
   	        ComChkObjValid(event.srcElement);
         }
        	
        	if(obj.name=="l_evnt_dt_hm"  ){
         		 with(formObj){
         			 var creDtFr = ComReplaceStr(l_evnt_dt_hm.value,":","");
      	        }
         		 ComChkObjValid(event.srcElement);
            }
        	if(obj.name=="f_evnt_dt_hm"  ){
         		 with(formObj){
         			 var creDtFr = ComReplaceStr(f_evnt_dt_hm.value,":","");
      	        }
         		 ComChkObjValid(event.srcElement);
            }
          	
       }
       
       /** 
        * Object 의 deactivate 이벤트에 대한 처리  <br>
        * @param  없음
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */
        function domFunFocusDel(a)
        {
        	var formObj = document.form;
          	 obj = event.srcElement;
          	if(obj.name=="l_evnt_dt"  ){
       			
          		document.form.l_evnt_dt.value = ComReplaceStr(document.form.l_evnt_dt.value,"-","");
              }
            if(obj.name=="f_evnt_dt"  ){
       			
            		document.form.f_evnt_dt.value = ComReplaceStr(document.form.l_evnt_dt.value,"-","");
             }
        	
           //ComShowMessage("domFunFocusDel");
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
        	 	case "hm":
        	 		ComKeyOnlyNumber(obj);
        	        break;
	       	    case "eng":
	       	    	if(obj.name=="l_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
	       	        else ComKeyOnlyAlphabet('upper');
	       	        break;
	       	    case "engup":
	       	        if(obj.name=="f_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
	       	        else ComKeyOnlyAlphabet('upper');
	       	        break;
	       	    case "engup2":	       	    	
	       	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
	       	        else ComKeyOnlyAlphabet('upper');
	       	        break;
	       	    
	       	 }
       	 
       	 
        }
 	
         /**
          * 기본 오브젝트 초기화 
          */
         function objectClear(){
  	       	var formObj = document.form;
  	       	formObj.eq_no.value = "";
  	       	formObj.eq_tpsz_cd.value = "";
  	        formObj.agmt_lstm_cd.value = "";
  	       	formObj.vndr_seq.value = "";
  	  	    formObj.vndr_lgl_eng_nm.value = "";
  	  	    formObj.eq_aset_sts_cd.value = "";
	  	    formObj.chss_mvmt_sts_cd.value = "";
	  	    formObj.sts_evnt_dt.value = "";
	  	    formObj.mvmt_dt.value = "";
	  	    yard_Chk();

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
    	 case "eq_no":
   		  
  		   if(formObj.eq_no.value != ''){
 	 			doActionIBSheet(sheetObj, formObj, IBSEARCH);
 	 			break;
 	 		} 

    	 }   var sheetObj = sheetObjects[0];

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
	 		case "eq_no": 
				ComKeyEnter('LengthNextFocus');
		  		break;
    	 	case "l_evnt_yd_cd":
    		    // chungpa 20100414 keyup->focusout start
    		    //ComKeyEnter('lengthnextfocus'); // 자동 이동이 안되는 관계로 수동으로 처리함. 
    	 		var l_evnt_yd_cd;
    	    	l_evnt_yd_cd = formObj.l_evnt_yd_cd.value;
    	    	if (l_evnt_yd_cd.length == 7) {
    	    		//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	    		formObj.f_evnt_dt.focus();
    	    	}
		    	// chungpa 20100414 keyup->focusout end		 		
    	    	break;
    	 	case "f_evnt_yd_cd":
    		    // chungpa 20100414 keyup->focusout start
    		    //ComKeyEnter('lengthnextfocus'); // 자동 이동이 안되는 관계로 수동으로 처리함. 
	    	    var f_evnt_yd_cd;
    	    	f_evnt_yd_cd = formObj.f_evnt_yd_cd.value;
    	    	if (f_evnt_yd_cd.length == 7) {
    	    		//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
    	    		formObj.eq_no.focus();
    	    	}
    	    	// chungpa 20100414 keyup->focusout end	
    	    	break;
    	 }
    }
     
    
     /**
      * chass 에서 enter 제어
      * @return
      */
     
     function keychk(){
    	 if(event.keyCode==13)
    	 {
    		 var formObj = document.form;
        	 var sheetObj = sheetObjects[0]; 
       		  
      		   if(formObj.eq_no.value != ''){
      			    sheetObj.WaitImageVisible=false;
 		 	        //ComOpenWait(true);
     	 			doActionIBSheet(sheetObj, formObj, IBSEARCH);
     	 			//ComOpenWait(false);
      		   }
    	 }
     }
     
 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var sheetObj = sheetObjects[0];

        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	 	   case IBSEARCH:	// Office Code 에 대한 Validation 체크 
			   	formObj.f_cmd.value = SEARCH;
//	 	        queryString = "f_cmd=" + SEARCHLIST ;
				
	 	        var sXml = sheetObj.GetSearchXml("EES_CGM_1017GS.do",  FormQueryString(formObj));
	 
	 	        
	 	        eqNo_set(sXml,formObj);
	 	        
	 	        formObj.l_evnt_dt.focus();
	 	        
			   	break;
    	   case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
			   	formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value = formObj.l_evnt_yd_cd.value;
			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.l_evnt_yd_cd.value = "";
			   		formObj.l_evnt_yd_cd.focus();
			   	} else {
			   		Matched_Chk('Yard');
			   	}
			   	break;
    	  case IBSEARCH_ASYNC04:	// Term Code Combo 조회
    	  		formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value = formObj.f_evnt_yd_cd.value;
			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.f_evnt_yd_cd.value = "";
			   		formObj.f_evnt_yd_cd.focus();
			   	} else {
			   		Matched_Chk('Yard');
			   	}
			   	break;
		  case IBSAVE:      // 저장
		  	    if(formObj.yardChk[0].checked == true)
		  	    {
		  	    	formObj.f_cmd.value = MULTI01;
		  	    }
		  	    else
		  	    {
		  	    	formObj.f_cmd.value = MULTI02;
		  	    }
		  		
//	        queryString = "f_cmd=" + SEARCHLIST ;
//	        	var sXml = sheetObj.GetSearchXml("EES_CGM_1017GS.do",  FormQueryString(formObj));
		  
		  		if(validateForm(sheetObj,formObj,sAction)){
		  			for(i=sheetObj.rowCount; i>0; i--){
		  				sheetObj.RowDelete(i, false);
			  		 }
			  		sheetObj.DataInsert(-1);
			  		sheetObj.CellValue(1, "eq_no") = formObj.eq_no.value;
			  		sheetObj.CellValue(1, "ofc_cd") = formObj.ofc_cd.value;
			  		sheetObj.CellValue(1, "eq_tpsz_cd") = formObj.eq_tpsz_cd.value;
			  		sheetObj.CellValue(1, "agmt_lstm_cd") = formObj.agmt_lstm_cd.value;
			  		sheetObj.CellValue(1, "vndr_seq") = formObj.vndr_seq.value;
			  		sheetObj.CellValue(1, "eq_aset_sts_cd") = formObj.eq_aset_sts_cd.value;
			  		sheetObj.CellValue(1, "l_evnt_dt") = formObj.l_evnt_dt.value;
			  		sheetObj.CellValue(1, "f_evnt_dt") = formObj.f_evnt_dt.value;
			  		sheetObj.CellValue(1, "l_evnt_yd_cd") = formObj.l_evnt_yd_cd.value;
			  		sheetObj.CellValue(1, "f_evnt_yd_cd") = formObj.f_evnt_yd_cd.value;
			  		
			  		sheetObj.RowStatus(1) = "U";
	//                ComShowMessage(sheetObj.rowCount);
	//                ComShowMessage("ibflag=="+sheetObj.CellValue(1, "ibflag"));
//			  		sheetObj.DoSave("EES_CGM_1017GS.do",queryString + "&" + params);
//			  	    ComShowMessage(FormQueryString(formObj));
			  		sheetObj.WaitImageVisible=false;
			 	    ComOpenWait(true);
			  		if(sheetObj.DoSave("EES_CGM_1017GS.do", FormQueryString(formObj)))
			  		{
			  			
			  			
			  		}
			  		//sheetObj.DoSave("EES_CGM_1017GS.do", FormQueryString(formObj));
			  		
			  		ComOpenWait(false);
		        }
		  		
               
                break;
        }
    }
 
 // 저장후 조회 기능 
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(errMsg =='') {   
    		if(formObj.yardChk[0].checked == true){
  				ComShowCodeMessage('CGM00002','LOST');
  			}else
  			{
  				ComShowCodeMessage('CGM00002','FOUND');
  			}
    		form_clear();
		}
    }   

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
   		 switch(sAction) {
   		 	case IBSAVE:
   		 		 
   		 		if(formObj.eq_no.value == ''){
          				ComShowCodeMessage('CGM10004','Chassis No. ');
          				formObj.eq_no.focus();
          				
          				return false;
          		}	
   		 		if(formObj.yardChk[0].checked == true){
   		 			if(formObj.l_evnt_dt.value=='')
   		 			{
	   		 			ComShowCodeMessage('CGM10004','Lost Date ');
	   		 		    formObj.l_evnt_dt.focus();
	      				
	      				return false;
   		 			}
   		 		    if(formObj.l_evnt_dt_hm.value=='')
		 			{
	   		 			ComShowCodeMessage('CGM10004','Lost Date ');
	   		 		    formObj.l_evnt_dt_hm.focus();
	      				
	      				return false;
		 			}
   		 			if(formObj.l_evnt_yd_cd.value=='')
		 			{
	   		 			ComShowCodeMessage('CGM10004','Lost Yard ');
	   		 		    formObj.l_evnt_yd_cd.focus();
	      				
	      				return false;
		 			}
	   		 		if(formObj.l_evnt_yd_cd.value.length !=7){
			 			ComShowCodeMessage('CGM10044','Lost Yard (7)');
			 			formObj.l_evnt_yd_cd.focus();
	       				
	       				return false;
	       			}
          				
          		} else {
          			if(formObj.f_evnt_dt.value=='')
   		 			{
	   		 			ComShowCodeMessage('CGM10004','Found Date ');
	   		 		    formObj.f_evnt_dt.focus();
	      				
	      				return false;
   		 			}
          			if(formObj.f_evnt_dt_hm.value=='')
   		 			{
	   		 			ComShowCodeMessage('CGM10004','Found Date ');
	   		 		    formObj.f_evnt_dt_hm.focus();
	      				
	      				return false;
   		 			}
   		 			if(formObj.f_evnt_yd_cd.value=='')
		 			{
	   		 			ComShowCodeMessage('CGM10004','Found Yard ');
	   		 		    formObj.f_evnt_yd_cd.focus();
	      				
	      				return false;
		 			}
   			 		if(formObj.f_evnt_yd_cd.value.length !=7){
			 			ComShowCodeMessage('CGM10044','Found Yard (7)');
			 			formObj.f_evnt_yd_cd.focus();
	       				
	       				return false;
	       			}
          		}
   		 		 
          		break;
   		 }      
   	 }

        return true;
    }

    /**
     * eq_no 정보 조회 
     * @param sXml
     * @param formObj
     * @return
     */
    function eqNo_set(sXml,formObj){
 

    	if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
        	// 체크 메시지 출력
        	ComShowCodeMessage('CGM20003');
//        	ComShowCodeMessage("CGM10004", "Equipment is not found");
        	// 해당 Cell 값을 Null로 설정
        	form_clear();
    	} else if(DomXml2String(sXml, "prestatus") =="X"){
    		var status = DomXml2String(sXml,  "eq_aset_sts_cd");
    		ComShowCodeMessage('CGM20015',status);
//    		EQ_ASET_STS_CD
    		//ComShowCodeMessage("CGM10004", "Equipment ");
    		form_clear();
		} else {
			formObj.eq_tpsz_cd.value       = DomXml2String(sXml, "eq_tpsz_cd");
			formObj.agmt_lstm_cd.value     = DomXml2String(sXml, "agmt_lstm_cd");
 			formObj.aciac_div_cd.value     = DomXml2String(sXml, "aciac_div_cd");
 			formObj.vndr_seq.value         = DomXml2String(sXml, "vndr_seq");
 			formObj.vndr_lgl_eng_nm.value  = DomXml2String(sXml, "vndr_lgl_eng_nm");
 			formObj.eq_aset_sts_cd.value   = DomXml2String(sXml, "eq_aset_sts_cd");
 			formObj.chss_mvmt_sts_cd.value = DomXml2String(sXml, "chss_mvmt_sts_cd");
 			formObj.mvmt_dt.value          = DomXml2String(sXml, "mvmt_dt");
 			formObj.sts_evnt_dt.value      = DomXml2String(sXml, "sts_evnt_dt");
// 			formObj.prestatus.value        = prestatus;
 			if(DomXml2String(sXml, "aciac_div_cd") == "I"){
 				formObj.yardChk[0].checked = false;
 				formObj.yardChk[1].checked = true;
 				
 			}else {
 				formObj.yardChk[1].checked = false;
 				formObj.yardChk[0].checked = true;
 			}
 			yard_Chk();
		}
    }
    /**
     * 폼 클리어
     * @return
     */
    function form_clear(){
    	var formObj = document.form;
    	formObj.eq_no.value            = "";
    	formObj.eq_tpsz_cd.value       = "";
    	formObj.aciac_div_cd.value     = "";
		formObj.vndr_seq.value         = "";
		formObj.vndr_lgl_eng_nm.value  = "";
		formObj.eq_aset_sts_cd.value   = "";
		formObj.chss_mvmt_sts_cd.value = "";
		formObj.agmt_lstm_cd.value     = "";
		formObj.mvmt_dt.value          = "";
		formObj.sts_evnt_dt.value      = "";
        formObj.l_evnt_dt.value = "";
        formObj.l_evnt_dt_hm.value = "";
        formObj.l_evnt_yd_cd.value = "";
        formObj.f_evnt_dt.value = "";
        formObj.f_evnt_yd_cd.value = "";
        formObj.f_evnt_dt_hm.value = "";
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
     	 if(formObj.l_evnt_yd_cd.value != ""  ){
     		    formObj.f_cmd.value = SEARCH01;
     		    formObj.loc_cd.value = formObj.l_evnt_yd_cd.value.substr(0,5);
     	   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
     		    if(DomXml2String(sXml, "chk")!="OK"){
     				ComShowCodeMessage("CGM10028");
     				 
     					formObj.l_evnt_yd_cd.value = "";
     					formObj.l_evnt_yd_cd.focus();
     			 
     				
     				return;
     		    }
     		 
     	 }
     	 
     	if(formObj.f_evnt_yd_cd.value != ""  ){
 		    formObj.f_cmd.value = SEARCH01;
 		    formObj.loc_cd.value = formObj.f_evnt_yd_cd.value.substr(0,5);
 	   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
 		    if(DomXml2String(sXml, "chk")!="OK"){
 				ComShowCodeMessage("CGM10028");
 				 
 					formObj.f_evnt_yd_cd.value = "";
 					formObj.f_evnt_yd_cd.focus();
 			 
 				
 				return;
 		    }
 	 	 
 	    }
     	 
      }
      
	/* 개발자 작업  끝 */