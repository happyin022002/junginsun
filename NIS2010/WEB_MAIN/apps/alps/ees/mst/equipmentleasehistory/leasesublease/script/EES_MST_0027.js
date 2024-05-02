/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0027.js
*@FileTitle : Container Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.26 민정호
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
     * @class EES_MST_0027 : EES_MST_0027 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MST_0027() {
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
             	case "btns_calendar1": //달력버튼
             	    if (!formObject.ls_flg.checked){
						var cal = new ComCalendar();
						cal.setDisplayType('month');
						cal.select(formObject.evnt_dt11, 'yyyy-MM');           	 
	             	 	break;
             	    }
             	 	
             	case "btns_calendar2": //달력버튼
         	    	if (!formObject.ls_flg.checked){
						var cal = new ComCalendar();
						cal.setDisplayType('month');
						cal.select(formObject.evnt_dt22, 'yyyy-MM');
         	    	}
          	 	break;    

				case "ComOpenPopupWithTargetLoc":
					var tmp = formObject.loc_tp_cd.value;
					if(tmp == "R")
					{
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"rcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
					}else if(tmp == "L")
					{
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"lcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
					}else if(tmp == "S")
					{
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"scc_cd:loc_cd", "0,0,1,1,1,1,1", true);
					}
				break;

				case "Retrieve":
					formObject.evnt_dt1.value = ComReplaceStr(formObject.evnt_dt11.value, "-", "");
					formObject.evnt_dt2.value = ComReplaceStr(formObject.evnt_dt22.value, "-", "");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
				case "New":
					ComSetFocus(formObj.evnt_dt11);					
					document.getElementById("loc_cd").className = "input2";					
			        formObj.loc_cd.readOnly = true;
			        formObj.ComOpenPopupWithTargetLoc.Enable = false;  					
				    ComResetAll();
					sheetObject1.RemoveAll();
					obj_change();
				break;
				
				case "Down_Excel":
					sheetObject1.Down2Excel();
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
    	 formObj = document.form;
    	  
         for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
     	ComSetFocus(formObj.evnt_dt11);
     	
        document.getElementById("loc_cd").className = "input2";         
        formObj.loc_cd.readOnly = true;
        formObj.ComOpenPopupWithTargetLoc.Enable = false;         
        axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);	
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);   
        axon_event.addListener('change', 'obj_change' , 'loc_tp_cd');     
    	axon_event.addListener('keyup', 'evnt_dt11_onkeyUp', 'evnt_dt11');					//from_bse_dt keyup 이벤트 처리
    	axon_event.addListener('keyup', 'evnt_dt22_onkeyUp', 'evnt_dt22');						//to_bse_dt keyup 이벤트 처리
    	axon_event.addListener('click', 'obj_click' , 'ls_flg');
     }
     
      /**
       * Period TO  keyup 이벤트 처리
       * Period TO  keyup YYYY-MM 포멧 처리
       */
     function evnt_dt11_onkeyUp() {
        var formObject = document.form;
        var evnt_dt11 = formObject.evnt_dt11.value;
        if ( evnt_dt11.length == 6 ){
           formObject.evnt_dt11.value = evnt_dt11.substr(0,4)+"-"+evnt_dt11.substr(4,6);
           ComSetFocus(formObject.evnt_dt22);
        }
     }  
       
     /**
      * Period TO  keyup 이벤트 처리
      * Period TO  keyup YYYY-MM 포멧 처리
     */
     function evnt_dt22_onkeyUp() {
        var formObject = document.form;
        var evnt_dt22 = formObject.evnt_dt22.value;
        if ( evnt_dt22.length == 6 ){
           formObject.evnt_dt22.value = evnt_dt22.substr(0,4)+"-"+evnt_dt22.substr(4,6);           
        }
     }
     
     /**
      * obj_keypress
     */	  
	 function obj_keypress(){
    	 obj = event.srcElement;
    	 if(obj.dataformat == null) return;
    	 	
    	 window.defaultStatus = obj.dataformat;
    	 switch(obj.dataformat) {
    	 	case "ym":
    	 		ComKeyOnlyNumber(obj);
    	        break;    	  
    	    case "engup":
    	    	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
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
      
       if(obj.name=="evnt_dt11"  ){        			
          with(formObj){ 	        			
             var creDtFr = ComReplaceStr(evnt_dt11.value,"-","");
          } 	        	
 	      ComChkObjValid(event.srcElement);
       }
       if(obj.name=="evnt_dt22"  ){ 			
          with(formObj){ 	        			
             var creDtFr = ComReplaceStr(evnt_dt22.value,"-","");
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
    	   case "loc_tp_cd":
    		   if(formObj.loc_tp_cd.value == 'A'){    			   
    			   formObj.ComOpenPopupWithTargetLoc.Enable = false;
    			   formObj.loc_cd.value = '';
    		       formObj.loc_cd.readOnly = true;
				   document.getElementById("loc_cd").className = "input2";    		       
    		   }else{
    		       formObj.loc_cd.readOnly = false;    			   
    			   formObj.ComOpenPopupWithTargetLoc.Enable = true;    		
				   document.getElementById("loc_cd").className = "input";    			   
    		   }
    		   break;
    	 }   
    } 
     
    function obj_click(){
	   	 var formObj = document.form;
		 obj = event.srcElement;

    	 switch(obj.name){
	  	   case "ls_flg":
	  		   if(formObj.ls_flg.checked){
	  			 document.getElementById("loc_tp_cd").className = "input";
	  			 document.getElementById("evnt_dt11").className = "input";
	  			 document.getElementById("evnt_dt22").className = "input";
	  			 formObj.ls_flg.value = "Y";
	  			 formObj.evnt_dt11.value = "";
	  			 formObj.evnt_dt22.value = "";
	  			 formObj.loc_tp_cd.value = "A";
	  			 formObj.loc_tp_cd.readOnly = false; 
	  			 formObj.loc_tp_cd.disabled = true;
	  			 
	  			 formObj.evnt_dt11.readOnly = false;
	  			 formObj.evnt_dt11.disabled = true;
	  			 
	  			 formObj.evnt_dt22.readOnly = false;
	  			 formObj.evnt_dt22.disabled = true;
	  		   } else {
	  			 document.getElementById("loc_tp_cd").className = "input1";  
	  			 document.getElementById("evnt_dt11").className = "input1";
	  			 document.getElementById("evnt_dt22").className = "input1";	  		
	  			 formObj.ls_flg.value = "N";
	  			 
	  			 formObj.loc_tp_cd.readOnly = true; 
	  			 formObj.loc_tp_cd.disabled = false;
	  			 
	  			 formObj.evnt_dt11.readOnly = true;
	  			 formObj.evnt_dt11.disabled = false;
	  			 
	  			 formObj.evnt_dt22.readOnly = true;
	  			 formObj.evnt_dt22.disabled = false;
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
                     style.height = 410;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     var HeadTitle = "CNTR No.|TP/SZ|Term|AGMT No.|Contract No.|Lessor|Lessor Name|F/M|Pre\nMovement|Lost Date|Lost\nYard|Found Date|Found\nYard|Days";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData, 	90,  daCenter,  	false,     "cntr_no",     false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     40,  daCenter,  	false,     "tp_sz",    	 false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,  	40,  daCenter,  	false,     "term",       false,    "",      dfNone, 			0,     true,       false);
					InitDataProperty(0, cnt++ , dtData,     80,  daCenter,  	false,     "agmt_no",     false,    "",      dfNone,				0,     true,       true);
					  
					InitDataProperty(0, cnt++ , dtData, 	100, daLeft,  	false,    	"container_no",	     false,    "",      dfNone,				0,     true,       true);                     
					InitDataProperty(0, cnt++ , dtData,  	65,  daCenter,  false,     	"lessor",			false,    "",      dfNone,				0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     190,  daLeft,  	false,     	"lessor_name",     false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     40,  daCenter,  false,     	"f_m",     		 false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     70,  daCenter,  false,     	"pre_movemert",    false,    "",      dfNone, 			0,     true,       true); 
													
					InitDataProperty(0, cnt++ , dtData,     80,  daCenter,  false,     "lst_dt",    false,    "",      dfDateYmd,		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     60,  daCenter,  false,     "lst_yd",     false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     80,  daCenter,  false,     "fnd_dt",     false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     60,  daCenter,  false,     "fnd_yd",      false,    "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,     20,  daRight,  	false,     "days",     	 false,    "",      dfNullInteger, 			0,     true,       true);

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
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);					
					formObj.f_cmd.value = SEARCH;
	 				var xml = "";					
	 				xml = sheetObj.GetSearchXml("EES_MST_0027GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchXml(xml);
	 				ComOpenWait(false);
				}
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
     		 		if (!formObj.ls_flg.checked){
	     		 		if(evnt_dt11.value == ''){
	            				ComShowCodeMessage('MST00001','Period ');
	            				evnt_dt11.focus();
	            				
	            				return false;
	            		}	
	
	     		 		if(evnt_dt22.value == ''){
	            				ComShowCodeMessage('MST00001','Period ');
	            				evnt_dt22.focus();
	            				
	            				return false;
	            		}
	     		 		
	     		 		var dt1 = ComReplaceStr(evnt_dt11.value,"-","");
	         			var dt2 = ComReplaceStr(evnt_dt22.value,"-","");
	
						if(dt1 != '' && dt2 != ''){
	     	    			if(dt2 < dt1){
	     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	     	    				evnt_dt11.value='';
	     	    				
	     	    				evnt_dt11.focus();
	     	    				return false;
	     	    			}
	     	    		}
     		 		}
					
					if(loc_tp_cd.value != 'A'){
						if(loc_cd.value == ''){
								ComShowCodeMessage('MST00001','Location');
								loc_cd.focus();								
								return false;
						}
						
	        		    if(loc_cd.value.trim().length > 0){
	        			   if(loc_cd.value.trim().length < 5){
	        				   ComShowCodeMessage('MST01019','Location');
							   loc_cd.focus();	        				   
	        				   return false;
	        			   }
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
      function domFunFocusDel(a)
      {
      	var formObj = document.form;
        	 obj = event.srcElement;
        	if(obj.name=="evnt_dt11"  ){
     			
        		document.form.evnt_dt11.value = ComReplaceStr(document.form.evnt_dt11.value,"-","");
            }
          if(obj.name=="evnt_dt22"  ){
     			
          		document.form.evnt_dt22.value = ComReplaceStr(document.form.evnt_dt22.value,"-","");
           }
      }      
	/* 개발자 작업  끝 */