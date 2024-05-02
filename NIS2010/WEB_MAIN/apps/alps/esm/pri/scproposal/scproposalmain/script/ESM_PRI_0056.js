/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0056.js
*@FileTitle : S/C No. Assignment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.10 공백진
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
     * @extends Pri
     * @class ESM_PRI_0056 : ESM_PRI_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0056() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.setComboObject 		= setComboObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;

 var returnData = new Array();
 returnData[0] = "N";//데이터 변경 여부를 알기 위한 변수 메인으로 return하여 Y 인 경우 메인을 재조회한다.
 returnData[1] = "";//생성한S/C No.를 메인으로 넘기기 위한 변수
 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

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
          
          /*******************************************************/
          var formObj = document.form;
          var sheetObj = sheetObjects[0];
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
 				case "btn_Ok":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					if (returnData[0] == "Y"){
 	 					window.returnValue = returnData;
 	 					window.close();
 					}
 					break;
 				case "btn_Close":
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
    	 var formObj = document.form;
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
  			 initSheet(sheetObjects[i],i+1);  	
  			 ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         formObj.prop_no.readOnly = true;
         formObj.ctrt_eff_dt.readOnly = true;
         formObj.ctrt_exp_dt.readOnly = true;
         formObj.gpre_fix.readOnly = true;
         if (formObj.svcCnt.value == "1"){
        	 formObj.opt_sc[1].disabled = true;
        	 formObj.gpre_fix.disabled = true;
        	 formObj.gsc_no.disabled = true;        	 
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  	 
 	function obj_keypress() {

		switch (event.srcElement.dataformat) {
		case "engup":
            ComKeyOnlyAlphabet('upper');            
			break;
		case "int":
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "num":
			ComKeyOnlyNumber("int");
			break;
		case "float":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		default:
			ComKeyOnlyNumber(event.srcElement);

		}
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
			case "spre_fix":
				var preFixChk = checkPreFix();
				if (preFixChk != "Y"){
					formObj.spre_fix.value = "";
				}				
				ComChkObjValid(event.srcElement);
				break;
			case "gpre_fix":
				ComChkObjValid(event.srcElement);
				break;		
			case "ssc_no":
				
				break;		
			case "gsc_no":
				
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
      function initSheet (sheetObj, sheetNo) {
      
          var cnt = 0;
          var sheetID = sheetObj.id;
          switch (sheetID) {
      
              case "sheet1":
                  with (sheetObj) {
      
                      // 높이 설정
                      style.height = 0;      
                      //전체 너비 설정
                      SheetWidth = mainTable.clientWidth;
      
                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "")
                          InitHostInfo(location.hostname, location.port, page_path);
      
                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;
      
                      //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;
      
                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(1, 1, 3, 100);
      
                      var HeadTitle = "|||";
                      var headCount = ComCountHeadTitle(HeadTitle);
      
                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);
      
                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(false, true, false, true, false, false);
      
                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);
      
                      // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
                      // COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
                      // POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
                      // SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                      InitDataProperty(0, cnt++, dtStatus, 50, daCenter, false, "ibflag");
                      InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no");
                      InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "sc_no");
                      WaitImageVisible = false;
                  }
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
       function doActionIBSheet (sheetObj, formObj, sAction) {
           sheetObj.ShowDebugMsg = false;
           try{
               switch (sAction) {
	               case IBSEARCH: // 조회
	               	   ComOpenWait(true); 
	                   formObj.f_cmd.value = SEARCH;               	   
	                   var sXml = sheetObj.GetSearchXml("ESM_PRI_0056GS.do" , FormQueryString(formObj));
	                   var arrData = ComPriXml2Array(sXml, "sc_no");
		       			var preFix = "";
		    			var seq = "";	
		    			//복수 scope일 경우 general s/c와 global s/c 사용가능
		           		if (arrData !=null && arrData.length > 0){
		           			if (arrData[0][0].length == 9){
			           			preFix = arrData[0][0].substr(0, 3);			           			
			        			seq = arrData[0][0].substr(3, 6); 
		           			}else if(arrData[0][0].length==5){
		           				preFix = arrData[0][0].substr(0, 3);
		           				seq = arrData[0][0].substr(3, 2)+"0001";
		           			}
		        			formObj.spre_fix.value = preFix;
		        			formObj.ssc_no.value = seq;
		        			formObj.gsc_no.value = seq;	 
		           		}		    			
		           		formObj.ssc_no.focus();		               	 
		                if (formObj.svcCnt.value == "1"){
		               	 	formObj.gpre_fix.value = "";
		               	 	formObj.gsc_no.value = "";	               	 
		                }		           		
	                   break;	       
	               case IBSAVE: // 저장	   
	               		ComOpenWait(true); 
	                   if (!validateForm (sheetObjects[0], formObj, sAction)) {                     
	                	   return;
	                   }	               		
						var sc_no = "";
						if (formObj.opt_sc[0].checked){
							sc_no = formObj.spre_fix.value +formObj.ssc_no.value;
						}else{
							sc_no = formObj.gpre_fix.value +formObj.gsc_no.value;
						}	
	                   formObj.f_cmd.value = MULTI;
	                   var sParam =   FormQueryString(formObj)+"&sc_no="+sc_no ;
	                   var sXml = sheetObj.GetSaveXml("ESM_PRI_0056GS.do", sParam);
	                   sheetObjects[0].LoadSaveXml(sXml);	
	                   break;
	
	           }        	   
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
    * 사용자가 입력한 S/C No.가 데이터베이스에 저장되어 있는지 조회한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		checkScNo();
    * </pre>
    * @param  없음
    * @return {string} <br>
    *                   Y : 중복값이 있음
    *                   N : 중복값이 없음
    * @author 공백진
    * @version 2009.05.07
    */          
    function checkScNo(){
   		var formObj = document.form;
		var sheetObj = sheetObjects[0]
		var rValue = "N";// 
		formObj.f_cmd.value = SEARCH01;
		
		var sc_no = "";
		if (formObj.opt_sc[0].checked){
			sc_no = formObj.spre_fix.value + formObj.ssc_no.value;
		}else{
			sc_no = formObj.gpre_fix.value + formObj.gsc_no.value;
		}      		
		var sParam =   FormQueryString(formObj)+"&sc_no="+sc_no ;
		var sXml = sheetObj.GetSearchXml("ESM_PRI_0056GS.do" , sParam);

		var arrData = ComPriXml2Array(sXml, "sc_no");
		
		if (arrData !=null && arrData.length > 0){
			rValue ="Y";
		}

		return rValue;    	   
    	   
    }
    
    /**
     * 입력한 PreFix가 유효한 값인지 조회한다.<br>
     * 저장시 유효한 값이 아니라면 저장할 수 없다.
     * <br><b>Example :</b>
     * <pre>
     *		checkPreFix();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *                   Y : 유효함
     *                   N : 유효하지 않음
     * @author 공백진
     * @version 2009.05.07
     */        
    function checkPreFix(){
   		var formObj = document.form;
		var sheetObj = sheetObjects[0]
		var rValue = "N";// 
		formObj.f_cmd.value = SEARCH02;
		
		var preFix = "";
		if (formObj.opt_sc[0].checked){
			preFix = formObj.spre_fix.value;
		}else{
			preFix = formObj.gpre_fix.value;
		}      		
		var sParam = FormQueryString(formObj)+"&pre_fix="+preFix ;
		var sXml = sheetObj.GetSearchXml("ESM_PRI_0056GS.do" , sParam);
		var arrData = ComPriXml2Array(sXml, "svc_scp_cd");		
		if (arrData !=null && arrData.length > 0){
			rValue ="Y";
		}
		return rValue;  
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
    * @returns bool <br>
    *          true  : 폼입력값이 유효할 경우<br>
    *          false : 폼입력값이 유효하지 않을 경우
    * @author 공백진
    * @version 2009.04.17
    */
   function validateForm (sheetObj, formObj, sAction) {
       with (sheetObj) {
           switch (sAction) {
               case IBSAVE:
            	   if (formObj.prop_no.value =="" ){
            		   return false;
            	   }
            	   if (formObj.svc_scp_cd.value =="" || formObj.ofc_cd.value ==""){            		   
            		   return false;
            	   }     
	    			
            	   if (!ComShowCodeConfirm("PRI01056")){            		   
            		   return false;
            	   }

					if (formObj.opt_sc[0].checked){
						if (formObj.spre_fix.value =="" ){
							ComShowCodeMessage("PRI01061");
							formObj.spre_fix.focus();
							return false;
						}					
						if (formObj.ssc_no.value == "" || formObj.ssc_no.value.length != 6){
							ComShowCodeMessage("PRI01061");
							formObj.ssc_no.focus();
							return false;
						}						
					}else{
						if (formObj.gpre_fix.value =="" || formObj.gsc_no.value == "" || formObj.gsc_no.value.length != 6){
							ComShowCodeMessage("PRI01061");
							formObj.gsc_no.focus();
							return false;
						}	
					}  
					
					var preFixChk = checkPreFix();
					if (preFixChk != "Y"){
						formObj.spre_fix.value = "";
						formObj.spre_fix.focus();
						ComShowCodeMessage("PRI01061");						
						return false;
					}						
					
            	   var dup = checkScNo();            	   
            	   if (dup =="Y"){
            		   ComShowCodeMessage("PRI01062")
            			return false;            		               		   
            	   }
					
                   break;
           }
       }

       return true;
   }       
    
    /**
    * OnSaveEnd 이벤트 발생시 호출되는 function <br>
    * 저장완료 후 Edit 컬럼을 설정한다. <br>
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
			var formObj = document.form;

			returnData[0] = "Y";			
			var sc_no = "";
			if (formObj.opt_sc[0].checked){
				sc_no = formObj.spre_fix.value +formObj.ssc_no.value;
			}else{
				sc_no = formObj.gpre_fix.value +formObj.gsc_no.value;
			}  
			returnData[1] = sc_no;
		}
   	}     	        

    /* 개발자 작업  끝 */