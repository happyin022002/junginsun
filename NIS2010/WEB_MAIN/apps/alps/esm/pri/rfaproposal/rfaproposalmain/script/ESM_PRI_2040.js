/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2040.js
*@FileTitle : RFA Proposal Creation[Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 이은섭
*@LastVersion : 1.1
* 2009.05.13 공백진
* 1.0 Creation
* 1.1 Modify - 구주 Hinterland 프로젝트로 인한 변경
=========================================================
* History
* 2011.01.14 최성민 [CHM-201108327-01] 현재 RFA Duration 연장이 최대 1년으로 되어 있는 Logic 을 삭제하여, 1년 이상 연장 가능하도록 logic 변경 
* 2012.05.30 이은섭 - 구주 Hinterland 프로젝트 오픈 이전에 발생한 AEW, AEE에 대해서는 Ament 불가
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2016.07.18 이민경 [CHM-201642492] Contract RFA 수정 Logic 변경 요청의 건
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
     * @class ESM_PRI_2040 : ESM_PRI_2040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2040() {
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
 var rData = "N";
 var exSvrScpCd = false;
 
 // T/F 전환을 위한 기준 EXP_DT
 var editableCopy = true;
 var exceptionScopeFlag = false;
 var usedScope = new Array();
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 var tempAddOnEndExpDt =  "20130119";
 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {              
                if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                    return false;
                }
            }
             switch(srcName) {
	             case "btns_calendar1": //달력버튼
		             var cal = new ComCalendar();                
		             cal.select(formObject.exp_dt, 'yyyy-MM-dd');
		             break; 
	             case "btns_calendar2": //달력버튼
		             var cal = new ComCalendar();                
		             cal.select(formObject.eff_dt, 'yyyy-MM-dd');
		             break; 		
             
				case "btn_OK":
	                var rValue = doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	     
	                if (!rValue){
	                	return;
	                }
	                
	                rData = "Y";
	                window.returnValue = rData;
	                window.close();
					break;
				
				case "btn_Close":
					window.returnValue = rData;
					window.close();
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
      * IBSheet Object를 배열로 등록 <br>
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
      * 배열은 소스 상단에 정의 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj 필수 IBSheet Object
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */   
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj; 			
     }

     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         setInitData();         
         var formObj = document.form;  
         if(formObj.rfa_ctrt_tp_cd.value == "C"){
        	 /**2016.07.13 C.RFA Logic 변경 요청 by. 이종욱
         	 * Contract RFA Amend 시 EXP 변경 가능하도록 수정
         	 * */
//        	 formObj.exp_dt.readOnly = true; 
//        	 formObj.exp_dt.setAttribute("className","input2");
//        	 btnImgEnable(formObj.btns_calendar1, false);
        	 formObj.exp_dt.readOnly = false; 
        	 formObj.exp_dt.setAttribute("className","input1");
        	 btnImgEnable(formObj.btns_calendar1, true);
        	 /** End */
        	 
         }else{
        	 formObj.exp_dt.readOnly = false;
        	 btnImgEnable(formObj.btns_calendar1, true);
         }
    	 formObj.eff_dt.focus();
    	 var ctrtEffDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value,"ymd");
    	 exceptionScopeFlag = searchAllSvcScpCd(sheetObjects[0], document.form);
    	 
    	 if(ctrtEffDt < addOnEndExpDt) {
    	 	editableCopy = isCheckForBeforeAmend(sheetObjects[0], document.form);
    	 }
    	 
     }

      /**
       * 시트 초기설정값, 헤더 정의 <br>
       * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
       * <br><b>Example :</b>
       * <pre>
       *     initSheet(sheetObj,1);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */
       function initSheet(sheetObj,sheetNo) {
           var cnt = 0;
           var amdt_seq = document.form.amdt_seq.value;
           var sheetID = sheetObj.id;
           switch(sheetID) {
               case "sheet1":      //t1sheet1 init
                   with (sheetObj) {

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo( 1, 1, 3, 100);

                       var HeadTitle = "|propno|amdtseq|new duration|new duration|amdeffdt";
                       var headCount = ComCountHeadTitle(HeadTitle);
                       
                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(false, true, true, true, false,false)

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle, true);

                       InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");                       
   					   InitDataProperty(0, cnt++, dtData,  90, daLeft, false, "prop_no",  	 false, "", dfNone,    0, false, false);
  					   InitDataProperty(0, cnt++, dtData,  90, daLeft, false, "amdt_seq", 	 false, "", dfNone,    0, false, false);                     
                       InitDataProperty(0, cnt++, dtData, 100, daLeft, true,  "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);     
                       InitDataProperty(0, cnt++, dtData, 100, daLeft, true,  "exp_dt",      false, "", dfDateYmd, 0, false, false);                             
                       InitDataProperty(0, cnt++, dtData, 110, daLeft, true,  "eff_dt",      false, "", dfDateYmd, 0, false, false);
                       WaitImageVisible = false;    
                  }
                   break;

           }
       }

       /**
        * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
        * <br><b>Example :</b>
        * <pre>
        *     initControl()
        * </pre>
        * @param 없음
        * @return 없음
        * @author 공백진
        * @version 2009.04.17
        */        
      function initControl() {
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
          axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
          axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
    }      
      
      /**
       * Onbeforedeactivate  event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_deactivate()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */          
      function obj_deactivate() {
          var formObj = document.form;
          var sheetObj = sheetObjects[0]; 

          var eleName = event.srcElement.name;

          switch(eleName){
              case "ctrt_eff_dt":
                  ComChkObjValid(event.srcElement);   
                  break;
              case "exp_dt":
            	  if (formObj.exp_dt.value !=""){
            		  formObj.pos_exp_dt.value = ComGetMaskedValue(formObj.exp_dt.value, "ymd") ;
            	  }
            	  sheetObj.CellValue2(1, "exp_dt") = formObj.exp_dt.value;            	 
                  ComChkObjValid(event.srcElement);     
                  if (checkNewDurValidation() == false){
                	  formObj.exp_dt.focus();
                	  formObj.exp_dt.select(); 
                	  return false;
                  }
                  
                  break;   
              case "eff_dt":
	          	  sheetObj.CellValue2(1, "eff_dt") = formObj.eff_dt.value;
	              ComChkObjValid(event.srcElement);
                  if (checkAmdEffValidation() == false){
                	  formObj.eff_dt.focus();
                	  ComSetFocus(formObj.eff_dt);
                	  return false;
                  }
	              break;   
              default:
                  ComChkObjValid(event.srcElement);       
          }
          
      }    
       
      /**
       * OnBeforeActivate   event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_activate()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */         
      function obj_activate() {
          var formObj = document.form;
          var srcName = event.srcElement.getAttribute("name");
          ComClearSeparator (event.srcElement);
      }      
      
      /**
       * OnKeyPress event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_keypress();
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */        
      function obj_keypress() {
          switch (event.srcElement.dataformat) {
              case "ymd":
              	ComKeyOnlyNumber(event.srcElement, "-");
              	break;
          }
      }         
      

      
      /**
       * Sheet관련 프로세스 처리 <br>
       * <br><b>Example :</b>
       * <pre>
       *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 html form object
       * @param {int} sAction 필수 프로세스 플래그 상수
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */
       function doActionIBSheet(sheetObj,formObj,sAction) {
           try{
        	   switch(sAction) {
     			 case IBSAVE:        //저장 	 		
	     			 ComOpenWait(true); //->waiting->start
	  	             if (!validateForm(sheetObj,document.form,sAction)) {
	  	                 return false;
	  	             }     			 
  	             	formObj.f_cmd.value = MULTI01;
	  				var newDurFlg = "Y";
	  				if (ComGetUnMaskedValue(formObj.eDurDt.value,"ymd") == ComGetUnMaskedValue(formObj.exp_dt.value,"ymd")){
	  					newDurFlg="N";				
	  				}
	  				var sParam = FormQueryString(formObj);
	  				    sParam +="&new_dur_flg="+ newDurFlg + "&" + sheetObjects[0].GetSaveString();
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_2040GS.do", sParam);
	  				sheetObjects[0].LoadSaveXml(sXml);
	  				ComOpenWait(false); //->waiting->End	  				
	                break;
               }        	   
        	   return true;
           } catch (e) {
              	if (e == "[object Error]") {
                      ComShowMessage(OBJECT_ERROR);
                  } else {
                      ComShowMessage(e);
                  }
           }finally{
   	           	ComOpenWait(false); //->waiting->End
           }
       }

       /**
        * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
        * <br><b>Example :</b>
        * <pre>
        *     if (validateForm(sheetObj,document.form,IBSAVE)) {
        *         로직처리;
        *     }
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {form} formObj 필수 html form object
        * @param {int} sAction 필수 프로세스 플래그 상수
        * @return bool <br>
        *          true  : 폼입력값이 유효할 경우<br>
        *          false : 폼입력값이 유효하지 않을 경우
        * @author 공백진
        * @version 2009.04.17
        */
       function validateForm(sheetObj, formObj, sAction) {
           var rfa_no = formObj.rfa_no.value;
           var prop_no = formObj.prop_no.value;
           var amdt_seq = formObj.amdt_seq.value;
           
           switch (sAction) {               
	           case IBSAVE: // Save
		   	        var formObj = document.form;	           
	 	            var ctrtEffDt = ComGetUnMaskedValue(sheetObj.CellValue(1,"ctrt_eff_dt"),"ymd");
	 	            var expDay = ComGetUnMaskedValue(formObj.new_ctrt_exp_dt.value, "ymd");  
	 	            if(!exceptionScopeFlag) {
		 	            if(expDay != "" && !editableCopy) {
		 	            	if(ctrtEffDt <= endExpDt && expDay > endExpDt) {
	 	            			ComShowCodeMessage('PRI07012'); 
	 	            			formObj.exp_dt.focus();
	           					return false;
		 	            	}
		 	            }
//		 	            var toDate = searchSystemToDate(sheetObjects[0]);
//		 	            if(ctrtEffDt < addOnEndExpDt && expDay >= addOnEndExpDt && toDate >= tempAddOnEndExpDt) {
//	 	            		ComShowCodeMessage('PRI07040'); 
//	 	            		formObj.exp_dt.focus();
//	           				return false;
//	 	            	}
						if (ctrtEffDt < tempAddOnEndExpDt && expDay >= tempAddOnEndExpDt && ctrtEffDt < addOnEndExpDt) {
	 	            		ComShowCodeMessage('PRI07044'); 
	 	            		formObj.exp_dt.focus();
	           				return false;
	 	            	}
	 	            }
	 	            	
	           		if (formObj.pos_exp_dt.value =="" && formObj.exp_dt.value !=""){
	           			ComShowCodeMessage("COM130201","New Duration Exp Date");
	           			formObj.exp_dt.focus();
	           			return false;
	           		}
	           		
	           		 /**2016.07.13 C.RFA Logic 변경 요청 by. 이종욱
	        	  	 * 수정 가능 범위 Validation - 현재 날짜 ~ 기존 Exp + 3개월
	        	  	 * */
	        	     if(formObj.rfa_ctrt_tp_cd.value == "C"){
	        	    	 //기존 Exp +3개월
	        	    	 var orgExpDt = ComGetUnMaskedValue(formObj.edur_dt.value,"ymd");
	        		     var expDayAft3M = getMonthAdd(orgExpDt, 3, "");
	        		     //Current Date
	        		     var gCurrDate = ComGetNowInfo('ymd')
	        		     var today = gCurrDate.replace(/-/g,'');
	        		        
	        			     if(parseInt(expDay,10) < parseInt(today,10)){
	        			    	 ComShowCodeMessage("PRI07063");//Amend Eff date must be same or later than requested date.
	        			    	 formObj.new_ctrt_exp_dt.focus();
	        			    	 return false;
	        			     }
	        			     if(parseInt(expDay,10) > parseInt(expDayAft3M,10)){
	        			    	 ComShowCodeMessage("PRI07064");//Amend Eff date can’t be over 3months from current expiration date.
	        			    	 formObj.new_ctrt_exp_dt.focus();
	        			    	 return false;
	        			     }
	        	     }
	        	     /** End */
	        	     
	           		if (formObj.eff_dt.value ==""){
	           			ComShowCodeMessage("COM130201","Amend Eff Date");
	           			formObj.eff_dt.focus();
	           			return false;
	           		}	
	           		
	           		if ( !ComPriConfirmSave()) {
	 	                 return false;
	 	            } 
	           		
		   	        break;           
           }
           return true;
       }           
       
   /**
    * 화면 로드 후 메인에서 받아온 정보를 Sheet에  Update한다. <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	   
   function setInitData(){
 	  var sheetObj = sheetObjects[0];
 	  var formObj = document.form;
 	  
 	  formObj.pos_eff_dt.focus();
 	  formObj.pos_exp_dt.focus();
 	  formObj.ctrt_eff_dt.focus();
 	  formObj.sdur_dt.focus();
 	  formObj.edur_dt.focus(); 	   	  
 	  sheetObj.DataInsert(); 	  
 	  sheetObj.CellValue2(1, "rfa_no") = formObj.rfa_no.value;
 	  sheetObj.CellValue2(1, "prop_no") = formObj.prop_no.value;
 	  sheetObj.CellValue2(1, "amdt_seq") = formObj.amdt_seq.value;    	  
 	  sheetObj.CellValue2(1, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;	

   }       
    
       
   /**
    * OnSaveEnd 이벤트 발생시 호출되는 function <br>
    * 저장완료 후 수정 Flag에 Y 로 Setting 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
    		rData ="Y";
    	}
}          
       
/**
 * Image Button을 enable,disable 한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 		btnImgEnable(formObj.btns_calendar1, false);
 * </pre>
 * @param {object} obj 필수 button image name
 * @param {boolean}  필수
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */ 	        
   function btnImgEnable(obj, gb) {
	    if(obj.constructor == String){
	        obj = document.getElementsByName(obj)[0];    	        
	    }
	    var btnStyle = obj.style;
	    if (gb){    	       
	    	obj.Enable = true;
	        btnStyle.cursor = "hand";
	        btnStyle.filter="";
	        obj.disabled = false;
	    } else {    	     
	    	obj.Enable = false;    	        
	        btnStyle.cursor = "auto";
	        btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
	        obj.disabled = true;   
	    }
	}       
 
 
 /**
  * 사용자가 입력하는 Duration에 대한 validation을 처리한다. <br>
  * <br><b>Example :</b>
  * <pre>
  * 		checkNewDurValidation();
  * </pre>
  * @param  없음
  * @return bool  <br>
  * 			true  : 저장 가능
  * 			false : 저장 할 수 없음
  * @author 공백진
  * @version 2009.04.17
  */ 	  
 function checkNewDurValidation(){
     var sheetObj = sheetObjects[0];
     var formObj = document.form; 

     var expDay = ComGetUnMaskedValue(sheetObj.CellValue(1,"exp_dt"),"ymd");
     var posEffDay = ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
     var posExpDay = ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd");	                

     var ctrtEffDt = ComGetUnMaskedValue(sheetObj.CellValue(1,"ctrt_eff_dt"),"ymd");
     
	     /**2016.07.13 C.RFA Logic 변경 요청 by. 이종욱
	  	 * 수정 가능 범위 Validation - 현재 날짜 ~ 기존 Exp + 3개월
	  	 * */
	     if(formObj.rfa_ctrt_tp_cd.value == "C"){
	    	 //기존 Exp +3개월
	    	 var orgExpDt = ComGetUnMaskedValue(formObj.edur_dt.value,"ymd");
	    	 var expDayAft3M = getMonthAdd(orgExpDt, 3, "");
		     //Current Date
		     var gCurrDate = ComGetNowInfo('ymd')
		     var today = gCurrDate.replace(/-/g,'');
		        
			     if(parseInt(expDay,10) < parseInt(today,10)){
			    	 ComShowCodeMessage("PRI07063");//Amend Eff date must be same or later than requested date.
			    	 return false;
			     }
			     if(parseInt(expDay,10) > parseInt(expDayAft3M,10)){
			    	 ComShowCodeMessage("PRI07064");//Amend Eff date can’t be over 3months from current expiration date.
			    	 return false;
			     }
	     }
	     /** End */
	     
     
	 var effDay = ComGetUnMaskedValue(formObj.eff_dt.value,"ymd");
     
     //new duration은 Possible Effective Date보다 클수 없다.	                
     if (posEffDay > expDay && expDay !=""){
     	ComShowCodeMessage("PRI01089");
     	return false; 
     } else if (effDay > expDay) {
    	 ComShowCodeMessage("PRI01104");
    	 return false;
     }
     
     if(!exceptionScopeFlag) {
	     /**
	      * Add-On Tariff PJ, 구주 Hinter land PJ.
	      */
		var ctrtEffDt = ComGetUnMaskedValue(sheetObj.CellValue(1, "ctrt_eff_dt"), "ymd");
		if (expDay != "" && !editableCopy) {
			if (ctrtEffDt <= endExpDt && expDay > endExpDt) {
				ComShowCodeMessage('PRI07012');
				return false;
			}
		}
//		var toDate = searchSystemToDate(sheetObjects[0]);
//		if (ctrtEffDt < addOnEndExpDt && expDay >= addOnEndExpDt && toDate >= tempAddOnEndExpDt) {
//			ComShowCodeMessage('PRI07040');
//			return false;
//		}
		if (ctrtEffDt < tempAddOnEndExpDt && expDay >= tempAddOnEndExpDt && ctrtEffDt < addOnEndExpDt) {
			ComShowCodeMessage('PRI07044');
			return false;
		}
     }
     
     return true;
 }
 
 /**
 * 사용자가 입력하는 Amend Effective Date에 대한 validation을 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 		checkAmdEffValidation();
 * </pre>
 * @param  없음
 * @return bool  <br>
 * 			true  : 저장 가능
 * 			false : 저장 할 수 없음
 * @author 공백진
 * @version 2009.04.17
 */ 	 
 function checkAmdEffValidation(){
     var sheetObj = sheetObjects[0];
     var formObj = document.form; 
	 var amdtDay = sheetObj.CellValue(1,"eff_dt");

     var posEffDay = ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
     var posExpDay = ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd");	                
     var msg = " ["+formObj.pos_eff_dt.value + " ~ " + formObj.pos_exp_dt.value +"]"
     
      //Amend Date는 Possible Effective Date 보다 작거나  Possible Expire Date 보다 작아야한다.
     if (amdtDay !="" && ( posEffDay > amdtDay || posExpDay < amdtDay) ){
     	ComShowCodeMessage("PRI01088",msg);
     	formObj.eff_dt.focus();
     	return false;
     }
     return true;
 }
 
 	/**
 	 * 예외 Scope 체크
 	 */
    function searchAllSvcScpCd(checkSheetObj, formObj) {
		var checkParam = "f_cmd="+COMMAND37+"&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value;
		var sXml = checkSheetObj.GetSearchXml("PRICommonGS.do", checkParam);
		usedScope = ComPriXml2Array(sXml, "cd");
		var totalCnt = 0;
		for(var g = 0; g < usedScope.length; g++) {
			if(ComCheckGuideExcepSvcScpCd(usedScope[g])) {
				totalCnt ++;
			}
		}
		if(totalCnt == 0) {
			return false;
		}
		//모두 예외 Scope일 경우
		if(totalCnt == usedScope.length-1) {
			return true;
		} 
		return false;
    }
    
     	/**
	 * 2012.05.22 추가 <br>
	 * 구주 Hinterland 프로젝트에 따른 변경 사항 <br>
	 * 구주 Hinterland 프로젝트 오픈 이전에 발생한 AEW, AEE에 대해서는 Ament 불가<br>
	 */
    function isCheckForBeforeAmend(checkSheetObj, formObj) {
		for(var g = 0; g < usedScope.length; g++) {
			if(usedScope[g] == 'AEE' || usedScope[g] == 'AEW') {
				return false;
			}
		}
		return true;
    }
    
 	/**
	 * 2016.07.18 추가 <br>
	 * ComGetDateAdd function에 월별 말일 구분처리 추가<br>
	 * sDate : 선택,기준 날짜 문자열; null이면 PC의 현재날짜 기준으로 계산된다. default=null(PC의 현재날짜) YYYY-MM-DD
	 * iVal : 필수,연산할 값
	 * sDelim : 선택,결과에 사용할 날짜구분자, default="-"<br>
	 */
    function getMonthAdd(sDate, iVal, sDelim){
        try {
            if (sDelim==null || sDelim==undefined) sDelim = "-";

            if (sDate==null || sDate==undefined) {
                sDate = new Date();
            } else {
                //문자열 또는 HTML태그(Object)인 경우 처리
                sDate = getArgValue(sDate);

                sDate = getDateObj(sDate);
                if(isNaN(sDate.getYear())) return "";
            }

            var yy = sDate.getFullYear();
            var mm1 = sDate.getMonth();
            var dd = sDate.getDate();
            iVal = ComParseInt(iVal);	//인자가 문자열로 들어온 경우 에러 발생함

            var mm2 = mm1+ iVal; 
            
        	if(dd> ComGetLastDay(yy,mm2%12+1) || dd == ComGetLastDay(yy,mm1+1)){
        		dd = ComGetLastDay(yy,mm2%12+1);        		
        	}
            date = new Date(yy,mm2,dd);
            
            yy = date.getFullYear();
            mm2 = date.getMonth() + 1;
            dd = date.getDate();

            return yy + sDelim + ComLpad(mm2,2,"0") + sDelim + ComLpad(dd,2,"0");
        } catch(err) { ComFuncErrMsg(err.message); }
    }

	/* 개발자 작업  끝 */