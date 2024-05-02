/*=========================================================
*Copyright(c) 2016 CyberLogitecs
*@FileName : ESM_PRI_2240.js
*@FileTitle : Master RFA Proposal & Amendment [Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class ESM_PRI_2240 : ESM_PRI_2240 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2240() {
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
 
 var usedScope = new Array();
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
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];

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
		       			// 높이 설정
		       			style.height = 80;
		       			// 전체 너비 설정
		       			SheetWidth = mainTable.clientWidth;
		       			
		                // 전체Merge 종류 [선택, Default msNone]
		                MergeSheet = msNone;    
		                // 전체Edit 허용 여부 [선택, Default false]
		                Editable = true;         

		                // Host정보 설정[필수][HostIp, Port, PagePath]
		                if (location.hostname != "")
		                    InitHostInfo(location.hostname, location.port, page_path);
		       			
                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo( 1, 1, 3, 100);

                       var HeadTitle = "|propno|Amd No.|new duration|new duration|Amd Effective";
                       var headCount = ComCountHeadTitle(HeadTitle);
                       
                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(false, true, true, true, false,false)

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle, true);

                       InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
   					   InitDataProperty(0, cnt++, dtHidden,  90, daLeft, false, "prop_no",  	 false, "", dfNone,    0, false, false);
  					   InitDataProperty(0, cnt++, dtData,  90, daCenter, false, "amdt_seq", 	 false, "", dfNone,    0, false, false);
                       InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true,  "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                       InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true,  "exp_dt",      false, "", dfDateYmd, 0, false, false);
                       InitDataProperty(0, cnt++, dtData, 110, daCenter, true,  "eff_dt",      false, "", dfDateYmd, 0, true, true);
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
            
                ComChkObjValid(event.srcElement);
                if (checkNewDurValidation() == false) {
                	  formObj.exp_dt.focus();
                	  formObj.exp_dt.select();
                	  return false;
                }
                break;
            case "eff_dt":
            
            	ComChkObjValid(event.srcElement);
                if (checkAmdEffValidation() == false) {
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
  	             	formObj.f_cmd.value = MULTI02;
	  				var newDurFlg = "Y";
	  				if (ComGetUnMaskedValue(formObj.eDurDt.value,"ymd") == ComGetUnMaskedValue(formObj.exp_dt.value,"ymd")){
	  					newDurFlg="N";
	  				}
	  				formObj.eff_dt.value = sheetObj.CellValue(2, "eff_dt");
	  				var sParam = FormQueryString(formObj) + "&new_dur_flg="+ newDurFlg;
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_2240GS.do", sParam);
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
	 	            
	           		if (formObj.pos_exp_dt.value =="" && formObj.exp_dt.value !=""){
	           			ComShowCodeMessage("COM130201","New Duration Exp Date");
	           			return false;
	           		}
	           		if (sheetObj.CellValue(2, "eff_dt") == "") {
	           			ComShowCodeMessage("COM130201","Amend Eff Date");
	           			return false;
	           		} else if (ComGetDaysBetween(ComGetNowInfo('ymd', ''), sheetObj.CellValue(2, "eff_dt")) < 0) {
	           			// Retroactive Filing is not allowed
	           			ComShowCodeMessage("PRI01160");
	           			sheetObj.CellValue2(2, "eff_dt") = ComGetNowInfo('ymd', '');
	           			return false;
	           		}
	           		// Duration 기간 체크. 이전 eff date 이후의날이며 exp date 이전이어야 한다.
	           		if (checkNewDurValidation() == false) {
	           			return false;
	           		}
	           		
	                if (!checkAmdEffValidation()){
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
    	
    	// 기존 Amd의 row
    	var idx = sheetObj.DataInsert();
    	sheetObj.CellValue2(idx, "rfa_no") = formObj.rfa_no.value;
    	sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
    	sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
    	sheetObj.CellValue2(idx, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;
    	sheetObj.CellValue2(idx, "eff_dt") = formObj.now_eff_dt.value;
    	sheetObj.RowEditable(idx) = false;
    	// 신규 Amd의 row
    	idx = sheetObj.DataInsert();
    	sheetObj.CellValue2(idx, "rfa_no") = formObj.rfa_no.value;
    	sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
    	sheetObj.CellValue2(idx, "amdt_seq") = parseInt(formObj.amdt_seq.value) +1;
    	sheetObj.CellValue2(idx, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;
    	sheetObj.CellValue2(idx, "eff_dt") = ComGetNowInfo('ymd', '-');
    	sheetObj.RowEditable(idx) = true;
    	
    	// Date 값을 YYYY-MM-DD로 보여주기 위해서
    	formObj.sdur_dt.value = ComGetMaskedValue(formObj.sdur_dt.value, "ymd"); 
    	formObj.exp_dt.value = ComGetMaskedValue(formObj.exp_dt.value, "ymd");
    	
    	sheetObj.SelectRow = idx;
    	sheetObj.FocusStyle = fsHeavy;
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
	  * OnChange 이벤트 발생시 호출되는 function <br>
	  * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *
	  * </pre>
	  * @param {ibsheet} sheetObj 필수 IBSheet Object
	  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	  * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	  * @return 없음
	  * @author 최성민
	  * @version 2009.06.25
	  */  
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
	  	var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if(colName == "eff_dt" && Row == 2) {
            if (checkAmdEffValidation()){
            	formObj.eff_dt.value = Value;
            } else {
            	return false;
            }
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

     var expDay = ComGetUnMaskedValue(sheetObj.CellValue(2,"exp_dt"),"ymd");
     var posEffDay = ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
     var posExpDay = ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd");

     var ctrtEffDt = ComGetUnMaskedValue(sheetObj.CellValue(2,"ctrt_eff_dt"),"ymd");
     
     //new duration은 Possible Effective Date보다 클수 없다.
     if (posEffDay > expDay && expDay !=""){
     	ComShowCodeMessage("PRI01089");
     	return false; 
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
	 var amdtDay = sheetObj.CellValue(2,"eff_dt");

     var posEffDay = ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
     //var posExpDay = ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd");//
     //var msg = " ["+formObj.pos_eff_dt.value + " ~ " + ComGetMaskedValue(formObj.pos_exp_dt.value, "ymd") +"]"
     var posExpDay = ComGetUnMaskedValue(formObj.exp_dt.value,"ymd");//일반 rFA와 동일한 로직으로 바꾸기 위해서 화면의 exp dt를 이용하도록수정

     var msg = " ["+formObj.pos_eff_dt.value + " ~ " + ComGetMaskedValue(formObj.exp_dt.value, "ymd") +"]"
     
      //Amend Date는 Possible Effective Date 보다 작거나  Possible Expire Date 보다 작아야한다.
     if (amdtDay !="" && ( posEffDay > amdtDay || posExpDay < amdtDay) ){
     	ComShowCodeMessage("PRI01088",msg);
     	sheetObj.CellValue2(2, "eff_dt") = ComGetNowInfo('ymd', '-');
     	return false;
     }
     
     var ctrtExpDay = ComGetUnMaskedValue(formObj.exp_dt.value, "ymd");
	// 현재 Eff Date 기준으로 14일 체크
//	if(ComGetDaysBetween(amdtDay, formObj.exp_dt.value) >= 15) {
    if( PriCheckMonthBetween(amdtDay, formObj.exp_dt.value,1) < 1 ){

		ComShowCodeMessage("PRI07060"); // Duration should not be more than 14 days for Master RFA Publishing.
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
    
	/* 개발자 작업  끝 */