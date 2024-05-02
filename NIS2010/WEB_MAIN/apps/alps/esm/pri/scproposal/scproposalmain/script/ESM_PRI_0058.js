/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0058.js
*@FileTitle :Filing Date Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.10 공백진
* 1.0 Creation
* 2014.05.28 전윤주 [CHM-201430580] FMC 자동 filing 기능 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2014.09.19 송호진 [CHM-201430558] New Filing Eff. Date 가 전체 Duration 의 Expire Date 와 같을 때는 진행되도록 로직 수정
* 2015.01.06 송호진 [CHM-201433371] New Filing Eff. Date 가 전체 Duration 의 Expire Date 와 같을 때는 진행되도록 로직 수정 - CEF
* 2015.02.03 송호진 [CHM-201533882] S/C New Filing Date 관련 과거 60일 Block validation 추가
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
     * @class ESM_PRI_0058 : ESM_PRI_0058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0058() {
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
 //데이터 변경 여부를 알기 위한 변수 메인으로 return하여 Y 인 경우 메인을 재조회한다.
 var returnData = "N";
 //Back End Job 수행 횟수 (지정된 횟수 이상 실행 방지)
 var backEndJobCnt = 0;

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
             switch(srcName) {
 				case "btn_save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					if (returnData == "Y"){
 	 					window.returnValue = returnData;
 	 					window.close();
 					}
 					break;
 					
 				case "btn_sendFMC":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
 					break;
 					
 				case "btn_correction":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
 					break;
 					
 				case "btn_close":
 					window.returnValue = returnData;
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }

 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		
 		if (sheetObjects[0].RowCount > 0){
 			sheetObjects[0].SelectCell(1, "eff_dt");
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
         var sheetID = sheetObj.id;
         
         switch(sheetID) {

             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 70;
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
                     var HeadTitle = "|propno|amdtseq|Previous Filing\nEffective Date|New Filing\nEffective Date|sysdate|pre eff date|File Date|FMC\nConfirmation Time|FMC\nConfirmation#|File Staff|Final C/T\nConfirmation Time|Final C/T\nConfirmation#|Final C/T Staff|# of C/T|C/T Comment|Pre C/T Comment|Error Message|FMC Filing Mandatory Flag";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

 					//데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
 					//	  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
 					//	  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
 					//	  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]                      
 	                 InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 					 InitDataProperty(0, cnt++, dtHidden, 		70, daLeft,   false, "prop_no",             false, "", dfNone,    0, false, false);
 					 InitDataProperty(0, cnt++, dtHidden, 	    40, daLeft,   false, "amdt_seq",            false, "", dfNone,    0, false, false); 
                     InitDataProperty(0, cnt++, dtData,     	110,daCenter, true,  "last_file_dt",        false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtData,     	130,daCenter, true,  "eff_dt",	             true, "", dfDateYmd, 0, true,  true);
                     InitDataProperty(0, cnt++, dtHidden,     	100,daCenter, false, "us_est_sys_dt",	    false, "", dfNone,    0, false,  false);                     
                     InitDataProperty(0, cnt++, dtHidden,     	 70,daCenter, false, "pre_eff_dt",	        false, "", dfDateYmd, 0, false,  false);
                     InitDataProperty(0, cnt++, dtHidden,     	 70,daCenter, false, "file_dt",	        	false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	130,daCenter, false, "fmc_file_cfm_dt",	    false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	120,daCenter, false, "cfm_no",	            false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	110,daCenter, false, "file_stff",	        false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	130,daCenter, false, "fnl_ct_dt",	        false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	150,daCenter, false, "fnl_ct_cfm_no",	    false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	110,daCenter, false, "fnl_ct_stff",	        false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	 70,daCenter, false, "ct_cnt",	            false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	110,daCenter, false, "file_corr_cmt_ctnt",  false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtHidden,     	110,daCenter, false, "file_corr_cmt_ctnt_org",  false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	110,daCenter, false, "fmc_file_err_msg",	false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtHidden,     	 70,daCenter, false, "fmc_file_mdt_flg",	false, "", dfNone,    0, false,  false);
          
 					 CountPosition = 0;
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
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         try{
             switch(sAction) {
             case IBSEARCH:      //조회
             	   ComOpenWait(true); 
             	   if(validateForm(sheetObj,formObj,sAction)){
                 	  formObj.f_cmd.value = SEARCH;
                 	  sheetObj.doSearch("ESM_PRI_0058GS.do", FormQueryString(formObj)); 
                 	  sheetObj.CellValue2 ( 1, "file_corr_cmt_ctnt_org" ) = sheetObj.CellValue ( 1, "file_corr_cmt_ctnt" );
                   }
             	   
             	  buttonControl();
                  break;
                  
  			 case IBSAVE:        //저장
  			   	  ComOpenWait(true); 
  			 	  formObj.eff_dt_chg.value = "";  
  			 	  if(validateForm(sheetObj,formObj,sAction)){
  			 		  formObj.f_cmd.value = MULTI;             	     
  			 		  sheetObj.CellValue(1,"file_dt") = sheetObj.CellValue(1,"eff_dt");
             	     sheetObj.DoAllSave("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value);
                   }   
                   break;
                   
  			case IBSEARCH_ASYNC01:  //Send To FMC
  				ComOpenWait(true); 			 		  
				backEndJobCnt = 0;
				if (validateForm(sheetObj,document.form,sAction)) {
					formObj.f_cmd.value = MULTI01;
					sheetObj.CellValue(1,"file_dt") = sheetObj.CellValue(1,"eff_dt");
					
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value+"&"+sheetObj.GetSaveString(true));
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				    
				    if (backendJobKey != null && backendJobKey.length > 0 ) {
				    	formObj.backendjob_key.value = backendJobKey;
				    	window.setTimeout(getBackEndJobStatus, 5000);
				    }
				} else {
					ComOpenWait(false);
				}
				
				break; 
			   	  /*
			 	  if(validateForm(sheetObj,formObj,sAction)){
  			 		  formObj.f_cmd.value = MULTI01;  
  			 		  sheetObj.CellValue(1,"file_dt") = sheetObj.CellValue(1,"eff_dt");
              	     sheetObj.DoAllSave("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value);
              	     
              	     var cfm_no = sheetObj.EtcData("CFM_NO");
              	     var fmc_file_cfm_dt = sheetObj.EtcData("FMC_FILE_CFM_DT");
              	     
              	     if ( typeof cfm_no != "undefined" && cfm_no != "" && cfm_no != "Error") {
              	    	 ComShowMessage ( "FMC Filing processed successfully");
              	     } else {
              	    	 ComShowMessage ( "FMC Filing has failed. Please check Error Message");              	    	 
              	     }
              	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
                 }   
                 break;
			   	 */
                 
  			case IBSEARCH_ASYNC02:  //Correction
			   	  ComOpenWait(true); 
					backEndJobCnt = 0;
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value = MULTI02;
						
						var sXml = sheetObj.GetSearchXml("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value+"&"+sheetObj.GetSaveString(true));
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
					    
					    if (backendJobKey != null && backendJobKey.length > 0 ) {
					    	formObj.backendjob_key.value = backendJobKey;
					    	window.setTimeout(getBackEndJobStatus, 5000);
					    }
					} else {
						ComOpenWait(false);
					}
					
					break; 
				   	  /*
			 	  if(validateForm(sheetObj,formObj,sAction)){
  			 		  formObj.f_cmd.value = MULTI02;  
               	     sheetObj.DoAllSave("ESM_PRI_0058GS.do", FormQueryString(formObj)+"&ibflag="+formObj.change_dt.value);

              	     var cfm_no = sheetObj.EtcData("CFM_NO");
              	     var fmc_file_cfm_dt = sheetObj.EtcData("FMC_FILE_CFM_DT");
              	     
              	     if ( typeof cfm_no != "undefined" && cfm_no != "" && cfm_no != "Error") {
              	    	 ComShowMessage ( "FMC Filing processed successfully");
              	     } else {
              	    	 ComShowMessage ( "FMC Filing has failed. Please check Error Message");              	    	 
              	     }
              	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
               }   
               break;
               */
          }        	 
         } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }finally{
         	if(sAction != IBSEARCH_ASYNC01 && sAction != IBSEARCH_ASYNC02 ){
        		ComOpenWait(false);
        	}
         }

     }

     /**
      * 버튼 권한을 제어하는 컨트롤 function <br>
      * 화면의 버튼을 상태에 따라 활성,비활성화 한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     buttonControl();
      * </pre>
      * @param   없음
      * @return 없음
      * @author 전윤주
      * @version 2014.05.29
      */  
     function buttonControl(){
    	 ComBtnDisable("btn_sendFMC");
    	 ComBtnDisable("btn_correction");
    	 ComBtnDisable("btn_save");
    	 
    	 var fmcFileMdtFlg = sheetObjects[0].CellValue ( 1, "fmc_file_mdt_flg" );
    	 if ( fmcFileMdtFlg == "Y" ) {
	    	 sheetObjects[0].CellEditable ( 1, "eff_dt" ) = false;
	
	    	 if (sheetObjects[0].CellValue(1, "cfm_no") == "" || sheetObjects[0].CellValue(1, "cfm_no") == "Error" ){ //최초 comfirm no. 가 들어오지 않으면 send 버튼 활성화
	    		 sheetObjects[0].CellEditable ( 1, "eff_dt" ) = true;
	    		 ComBtnEnable("btn_sendFMC");
	    	 } 
	    	 
	    	 if (sheetObjects[0].CellValue(1, "cfm_no") != "" && sheetObjects[0].CellValue(1, "cfm_no") != "Error" ){ //comfirm no. 가 들어오면 C/T 버튼 활성화
	    		 if(checkCorrLimit()=="Y"){ //마지막 Confirm 받은 날짜 이후 working day 48시간 이후인지 확인
	    			 ComBtnEnable("btn_correction");
	    		 }
	    		 ComBtnDisable("btn_sendFMC");
	    	 }
	    	 
	    	 //최종 approved date보다 FMC에서 confrim 받은 날짜가 이후이면 save 버튼 활성화
	    	 if (checkFmcConfirmDt()=="Y"){
	    		 ComBtnEnable("btn_save");	        	
	    	 }
    	 } else if ( fmcFileMdtFlg == "N") { // FMC Filing 이 필요없는 Prefix 에 대해서는 기존의 로직을 적용한다.
    		 sheetObjects[0].CellEditable ( 1, "eff_dt" ) = true;
    		 ComBtnEnable("btn_save");	        	
    	 }
     }
     
     
     /**
      * Save 버튼 활성화 시 체크<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkFmcConfirmDt();
      * </pre>
      * @param  없음
      * @return {string} <br>
      *          Y : Save 버튼 활성화<br>
      *          N : Save 버튼 비활성화<br>
      * @author 전윤주
      * @version 2014.06.02
      */ 
     function checkFmcConfirmDt(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "N";
         formObj.f_cmd.value = SEARCH02;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0058GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 if (arrData[0][0] > 0){
            	 rValue ="Y";
             }
         }
         return rValue;       
     }
     
     /**
      * Correction 버튼 활성화 시 체크<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkCorrLimit();
      * </pre>
      * @param  없음
      * @return {string} <br>
      *          Y : C/T 버튼 활성화<br>
      *          N : C/T 버튼 비활성화<br>
      * @author 전윤주
      * @version 2014.06.03
      */ 
     function checkCorrLimit(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "N";
         formObj.f_cmd.value = SEARCH03;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0058GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 if (arrData[0][0] > 0){
            	 rValue ="Y";
             }
         }
         return rValue;       
     }
     
     /**
      * Initial Filing Date 체크 (Correction 버튼 클릭 시 메시지 팝업)<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkInitFileDt();
      * </pre>
      * @param  없음
      * @return {string} <br>
      *          Y : 메시지 팝업 X <br>
      *          N : 메시지 팝업 O <br>
      * @author 전윤주
      * @version 2014.06.03
      */ 
     function checkInitFileDt(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "N";
         formObj.f_cmd.value = SEARCH04;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0058GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 if (arrData[0][0] > 0){
            	 rValue ="Y";
             }
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
    	function validateForm(sheetObj, formObj, sAction) {
    		switch (sAction) {
    		case IBSEARCH: // 조회
    			if (formObj.prop_no.value == "" ) {
    				return false;
    			} else {
    				return true;
    			}
    			break;
    		
    		case IBSAVE: // 저장
    			if ( sheetObj.CellValue ( 1, "fmc_file_mdt_flg" ) == "N" ) {
    				
	    			if (sheetObj.CellValue ( 1, "eff_dt" ) == ""  ) {
	    				ComShowCodeMessage("PRI01042", "appropriate Filing Effective Date.");
	    				sheetObj.SelectCell(1,"eff_dt");
	    				return false;
	    			}
	    			
	    			//Filing Date가 EXP_DATE보다 크지 않은지 비교
					if (checkExpireDate() != "Y"){
						return false;
					}
					
					//New filing Date 는 Last Filing Date 보다 앞서거나 현재일 보다 앞설수 없음
	    			var lastFileDt = sheetObj.CellValue(1,"last_file_dt");
	    			var effDt = sheetObj.CellValue(1, "eff_dt"); //filing 신고되는 eff date ( sending 하면서 이 날짜로 eff.date 업데이트 됨)
	    			var preEffDt = sheetObj.CellValue(1, "pre_eff_dt");
	    			var expDt = formObj.ctrt_exp_dt.value.replace(/-/g,'');

	    			//이전회차 eff.date보다 현재 filing 시 입력하는 eff.date가 커야함
	    			if (preEffDt >= effDt){
	    				ComShowCodeMessage("PRI01119");
	    				sheetObj.SelectCell(1,"eff_dt");
	    				return false;
	    			}
	    			
	    			//입력하는 filing eff.date는 exp_dt 안에 있어야 함
	    			// exp_dt 당일 자는 포함 ( 같은 값일 경우는 진행 되어야 함 ) 2015.01.06
	    			if (effDt > expDt){
	    				ComShowCodeMessage("PRI00306");
	    				sheetObj.SelectCell(1, "eff_dt");
	    				return false;
	    			}    
	    			
	    			//이전회차 file date보다 현재 file date가 커야함
	    			if (lastFileDt >= effDt ){
	    				ComShowCodeMessage("PRI01053");
	    				sheetObj.SelectCell(1,"eff_dt");
	    				return false;
	    			}
	    			
	    			
	    			var effDtChg = "N";
	    			if ( formObj.curr_eff_dt.value != sheetObj.CellValue ( 1, "eff_dt" )){
	    				effDtChg = "Y";
	    			} 
	    			
	    			formObj.eff_dt_chg.value = effDtChg;
    			}
	    	
    			break;
    			
    		case IBSEARCH_ASYNC02: // Correction    			
    			if (checkInitFileDt()=="N"){ //현재 correction이 최초 filing 보다 48시간 이후이면
    				if (!ComShowCodeConfirm("PRI01156")){ //최초 filing 이후 48시간 지났으나 filing은 가능
	   					return false;
	   				}	        	
    	    	 }
    			var bProgFlg;
    			if (sheetObj.CellValue ( 1, "file_corr_cmt_ctnt" ) == sheetObj.CellValue ( 1, "file_corr_cmt_ctnt_org" )  ) {
    				if ( sheetObj.CellValue ( 1, "file_corr_cmt_ctnt" ) == "" ) {
        				ComShowCodeMessage("PRI01042", "reason for the Correction in C/T Comment.");
        				bProgFlg = false;
    				} else {
    					bProgFlg = ComShowConfirm ("Correction Comment is not changed. Continue?" );
    				}
    				if ( !bProgFlg ) {
    					sheetObj.SelectCell(1,"file_corr_cmt_ctnt");
    					return false;
    				}
    			}
    			formObj.eff_dt_chg.value = "N";
    			break;
    			
    	    case IBSEARCH_ASYNC01: // Send to FMC
    			//Y 인 경우  main,scope,duration,conversion eff_dt 변경함 
    			var effDtChg = "";
    			
    			if (formObj.prop_no.value == ""  ) {
    				return false;
    			}
    	
    			if (sheetObj.CellValue ( 1, "eff_dt" ) == ""  ) {
    				ComShowCodeMessage("PRI01042", "appropriate New Filing Effective Date.");
    				sheetObj.SelectCell(1,"eff_dt");
    				return false;
    			}
    	
    			//Filing Date가 현재 EST 기준 날짜 보다 60 일 이상 크지 않은지 비교
    			if ( sheetObj.EvalDateDiff ( "D", sheetObj.CellValue(1,"us_est_sys_dt").substring(0,10), sheetObj.CellText ( 1, "eff_dt" )) > 60 ) {
    				ComShowCodeMessage("PRI01157", sheetObj.CellValue(1,"us_est_sys_dt").substring(0,10));
    				sheetObj.SelectCell(1,"eff_dt");
    				return false;
    			}
    			
    			//Filing Date가 EXP_DATE보다 크지 않은지 비교
				if (checkExpireDate() != "Y"){
					return false;
				}
				
				//New filing Date 는 Last Filing Date 보다 앞서거나 현재일 보다 앞설수 없음
    			var lastFileDt = sheetObj.CellValue(1,"last_file_dt");
    			var newFileDt = sheetObj.CellValue(1,"us_est_sys_dt"); //미주 동부 시간 현재 filing date
    			var newFileDtYmd = newFileDt.substring(0,10).replace(/-/g,''); //미주 동부 시간 현재 filing date
    			var effDt = sheetObj.CellValue(1, "eff_dt"); //filing 신고되는 eff date ( sending 하면서 이 날짜로 eff.date 업데이트 됨)
    			var preEffDt = sheetObj.CellValue(1, "pre_eff_dt");
    			var expDt = formObj.ctrt_exp_dt.value.replace(/-/g,'');

    			//eff.date보다 현재 filing 시 입력하는 eff.date가 커야함 
    			if (effDt < newFileDtYmd){
    				if (!ComShowCodeConfirm("PRI01155")){ //소급 filing도 메시지 이후 진행은 가능함
	   					sheetObj.SelectCell(1,"eff_dt");
	   					return false;
	   				}			
    			} else {
    				if (!ComShowCodeConfirm("PRI01154")){
	   					sheetObj.SelectCell(1,"eff_dt");
	   					return false;
	   				}
    			}
    			
    			//이전회차 eff.date보다 현재 filing 시 입력하는 eff.date가 커야함
    			if (preEffDt >= effDt){
    				ComShowCodeMessage("PRI01119");
    				sheetObj.SelectCell(1,"eff_dt");
    				return false;
    			}
    			
    			//입력하는 filing eff.date는 exp_dt 안에 있어야 함
    			// exp_dt 당일 자는 포함 ( 같은 값일 경우는 진행 되어야 함 ) 2014.09.19
    			if (effDt > expDt){
    				ComShowCodeMessage("PRI00306");
    				sheetObj.SelectCell(1, "eff_dt");
    				return false;
    			}    
    			
    			//이전회차 file date보다 현재 file date가 커야함
    			if (lastFileDt >= effDt ){
    				ComShowCodeMessage("PRI01053");
    				sheetObj.SelectCell(1,"eff_dt");
    				return false;
    			}

    			//Filing Date가 현재 EST 기준 날짜 보다 60 일 이상 과거 날짜인지를 확인 2015.01.27
    			if ( sheetObj.EvalDateDiff ( "D", sheetObj.CellText ( 1, "eff_dt" ), sheetObj.CellValue(1,"us_est_sys_dt").substring(0,10) ) > 60 ) {
    				ComShowCodeMessage("PRI01160");
    				sheetObj.SelectCell(1,"eff_dt");
    				return false;
    			}
    			
     			
    			var effDtChg = "N";
    			if ( formObj.curr_eff_dt.value != sheetObj.CellValue ( 1, "eff_dt" )){
    				effDtChg = "Y";
    			} 
    			
    			formObj.eff_dt_chg.value = effDtChg;

    			/**********이전 Save시 처리했던 validation************
    			//2009-12-15  eff_dt_chg Y or N
    			//filing date가 effective date와 같거나 이후(같거나 차이가  9일 이하)				
	   			if (effDt <= newFileDt && ComGetDateAdd(effDt, "D", 9,"") >= newFileDt){
	   				effDtChg = "Y";
    			}
    			//filing date가 effective date와 차이가 9일 초과
	   			if (ComGetDateAdd(effDt, "D", 9,"")< newFileDt){
	   				if (!ComShowCodeConfirm("PRI01054")){
	   					sheetObj.SelectCell(1,"file_dt");
	   					return false;
	   				}else{
	   					effDtChg = "Y";
	   				}
    			}
    			
    			var msg = ComGetMsg("PRI01059").split("\n")
    	
	   			//filing date가 effective date이전
	   			if (effDt > newFileDt){	   				
	   				execScript("rtn = msgbox(\"" + msg[0] + "\"+Chr(13)+\"" + msg[1] + "\", 3, \"Filing Date Creation\")", "vbscript");
	   				if (rtn == 6){
	   					effDtChg = "Y";
	   				}else if (rtn == 7){
	   					effDtChg = "N";
	   				}else{
	   					return false;
	   				}
	   			}
   			
	   			formObj.eff_dt_chg.value = effDtChg;
	   			**************************************/
    			
    			
    			
    			break;
    		}
			return true;
    	}

 	
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 데이터 수정 Flag에 Y로 Setting한다. <br>
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
			returnData = "Y";
		}
	}   
 	
 	
 	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Correction comment 입력 시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 전윤주
     * @version 2014.05.28
     */
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
 	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 	    var formObj = document.form;
 	    var colname = sheetObj.ColSaveName(Col);  	 
 	    
      	switch(colname)
      	{
      		case "file_corr_cmt_ctnt":
	    		sheetObj.CellEditable(Row,"file_corr_cmt_ctnt") = false;
	    		readOnly = true;
	    		if(sheetObj.CellValue(Row, "cfm_no") != "" && sheetObj.CellValue(Row, "cfm_no") != "Error"){
	    			readOnly = false; //confirm no. 들어오면 correction 가능, correction할 때 comment 넣음
	    		}
	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 150, 100, 3999);
	    		break;
	    		
      		case "fmc_file_err_msg":      			
	    		ComShowMemoPad(sheetObj, Row, Col, true, 150, 100, 1000);
	    		break;
      	}
	}    
     
     /**
     * filing시 main,scope의 exp_dt보다 filing date가 같거나 큰 경우를 검사한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *         checkExpireDate();
     * </pre>
     * @param 없음
     * @return {string} <br>
     *                   Y : filing 금지
     *                   N : filing 가능
     * @author 공백진
     * @version 2009.04.17
     */    
    function checkExpireDate(){
       document.form.f_cmd.value = SEARCH01;
       var rValue = "N"; // filing 금지
       var sParam = FormQueryString(document.form)+"&"+sheetObjects[0].GetSaveString(true);
       var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0058GS.do", sParam);
       var arrData = ComPriXml2Array(sXml, "svc_scp_cd|ctrt_eff_dt|ctrt_exp_dt|cnt");
       var msg = new Array();
       
       if (arrData != null && arrData.length > 0) {           
    	   if (arrData[0][3] == "1"){
               rValue = "N";
               msg[0] = arrData[0][0];
               msg[1] = arrData[0][1];
               msg[2] = arrData[0][2];
           }else{                              
               rValue = "Y";
           }           
       }else{
    	   rValue = "Y";
       }
       if (rValue =="N"){
           ComShowCodeMessage('PRI01094',msg[0],msg[1],msg[2]);
       }
       return rValue;
    }     

   
    
    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobStatus();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.08.17
     */     
    function getBackEndJobStatus() {
    	var form = document.form;	
    	form.f_cmd.value = SEARCH05;

    	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0058GS.do", FormQueryString(form));
    	var jobState = ComGetEtcData(sXml, "jb_sts_flg");     	
    	if (jobState == undefined){
    		backEndJobCnt = 0;
    		return;
    	}
    	form.job_status.value = jobState;

    	if (jobState == "3") {
     		ComOpenWait(false);		
    		getBackEndJobSearch();
    	} else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
    		backEndJobCnt = 5;
     		ComOpenWait(false);		
    	} else if (jobState == "5") {
    		backEndJobCnt = 5;
     		ComOpenWait(false);		
    	} else{
    		window.setTimeout(getBackEndJobStatus, 5000);
    	}
    }     
    

    /**
     * BackEndJob의 결과가 완료되면 결과를 조회하여 Performance,Attainment에 값을 입력한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobSearch();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.08.17
     */       
    function getBackEndJobSearch() {
		var form = document.form;
		form.f_cmd.value = SEARCH06;
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0058GS.do", FormQueryString(form));
		var arrData = ComPriXml2Array(sXml, "cfm_no|fmc_file_cfm_dt");
		
		var cfm_no = arrData[0][0];
		var fmc_file_cfm_dt = arrData[0][1];
		 
		if ( typeof cfm_no != "undefined" && cfm_no != "" && cfm_no != "Error") {
			ComShowMessage ( "FMC Filing processed successfully");
		} else {
			ComShowMessage ( "FMC Filing has failed. Please check Error Message");              	    	 
		}
		returnData = "Y";
		doActionIBSheet(sheetObjects[0],form,IBSEARCH);
    }     


    /* 개발자 작업  끝 */