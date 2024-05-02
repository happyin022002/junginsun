/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0075.js
*@FileTitle : Bank detail & Signature
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.29 장강철
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
     * @class FNS_JOO_0075 : FNS_JOO_0075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0075() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업   */

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
                             doActionIBSheet(sheetObjects[0],document.form,IBRESET);
                             break;
                             
                         case "btn_Save":
                             doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                             break;  
                             
                         case "btn_copy":
                             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
                             break; 
                         case "btn_delete":
                             if( document.all.btn_delete.className == "btn1_1" ){
                                 return;
                             }  
                             doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
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

           for(i=0;i<sheetObjects.length;i++){

           //khlee-시작 환경 설정 함수 이름 변경
               ComConfigSheet (sheetObjects[i] );

               initSheet(sheetObjects[i],i+1);
           //khlee-마지막 환경 설정 함수 추가
               ComEndConfigSheet(sheetObjects[i]);
           }
           // IBMultiCombo초기화
           for(var k=0; k<comboObjects.length; k++){
               initCombo(comboObjects[k], k + 1);
           }         
           initControl();
           doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
           
       }

        /**
        * Combo 기본 설정
        * Combo의 항목을 설정한다.
        * @param comboObj 
        * @param comboIndex Number
        */
       function initCombo(comboObj, comboNo ) {
           var formObject = document.form
 
           switch(comboObj.id) {  
               case "usr_id":  
                   with (comboObj) { 
                       MultiSelect = false; 
                       UseAutoComplete = true;    
                       SetColAlign("left");        
                       SetColWidth("80|100");
                       DropHeight = 160;
                       ValidChar(1,1);
                       MaxLength = 8;
                    }  
                    break; 
    
               case "jo_tmplt_no": 
                   with (comboObj) { 
                        UseAutoComplete = true;
                        SetColAlign("left");
                        SetColWidth("60");
                        DropHeight = 200;
                        ValidChar(2,1);     
                        MaxLength = 6;                            
                    }  
                    break;   
            } 
       }      
        /**
        * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
        * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
        * @param {ibsheet} sheetObj    IBSheet Object
        
        * @param {int}     sheetNo     sheetObjects 배열에서 순번
        **/
       function initControl() {
           var formObject = document.form;
           axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject ); 
       }    

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            switch(sheetNo) {
                case 1:      // sheet1 init
            }
        }
         // Sheet관련 프로세스 처리
         function doActionIBSheet(sheetObj,formObj,sAction) {
             sheetObj.ShowDebugMsg = false;
 
                     switch(sAction) {
                     
                         case    IBCLEAR:         //Open  
                                 formObj.f_cmd.value = SEARCH01;            
                                 var param  =  FormQueryString(formObj); 
                                 var sXml   =  sheetObj.GetSearchXml("FNS_JOO_0075GS.do", param);
                                 var aXml   = sXml.split("|$$|");
                                 ComXml2ComboItem( aXml[0], formObj.ofc_cd      , "ofc_cd","ofc_cd" );
                                 ComXml2ComboItem( aXml[1], formObj.usr_id      , "usr_id","usr_id|usr_nm" );  
                                 ComSetObjValue( formObj.ofc_cd     , formObj.strOfc_cd.value);
                                 ComSetObjValue( formObj.usr_id     , formObj.str_usr_id.value);
           
                                 var message = ComJooGetMessageFromXml(aXml[0]);
                                 if( message != ""){
                                      ComShowMessage(message);
                                 }                            
                                 break;
 
                         case    IBSEARCH_ASYNC02:      //Get UserNm
                                 formObj.f_cmd.value = SEARCH02;            
                                 var param =  FormQueryString(formObj);
                                 var sXml  = sheetObj.GetSearchXml("FNS_JOO_0075GS.do", param);
                                 ComXml2ComboItem( sXml, formObj.usr_id, "usr_id","usr_id|usr_nm" );
                                 formObj.usr_id.focus(); 
                                 break;  
                        
                         case    IBSEARCH_ASYNC03:      //Get Text No
                                 formObj.f_cmd.value = SEARCH03;            
                                 var param           =  FormQueryString(formObj);
 
                                 var sXml            = sheetObj.GetSearchXml("FNS_JOO_0075GS.do", param);
                                 ComXml2ComboItem( sXml, formObj.jo_tmplt_no, "jo_tmplt_no","jo_tmplt_no_seq" );
                                 formObj.jo_tmplt_no.focus();
                                 var message = ComJooGetMessageFromXml(sXml);
                                 if( message != ""){
                                      ComShowMessage(message); 
                                 }                                      
 
                                 break; 
    
                         case    IBSEARCH:      //조회 
                                 if( !validateForm(sheetObj,formObj,sAction) ){return;}
 
                                 formObj.f_cmd.value = SEARCHLIST01;            
                                 var param =  FormQueryString(formObj);
                                 var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0075GS.do", param,"", true);
 
                                 ComSetObjValue( formObj.sig_stmt_ctnt    , ComJooGetRowValue(sXml,1,"sig_stmt_ctnt" ) );
                                 ComSetObjValue( formObj.bank_stmt_ctnt   , ComJooGetRowValue(sXml,1,"bank_stmt_ctnt") );
                                 ComSetObjValue( formObj.jo_ltr_tmplt_seq , ComJooGetRowValue(sXml,1,"jo_ltr_tmplt_seq") );
                                 
                                 var message = ComJooGetMessageFromXml(sXml);
 
                                 if( message != ""){
                                      ComShowMessage(message);
                                 }
                                 if(ComGetTotalRows(sXml) != "0"){
                                     formObj.sig_stmt_ctnt.className  = "textarea2";
                                     formObj.sig_stmt_ctnt.readOnly   = true;
                                     formObj.bank_stmt_ctnt.className = "textarea2";
                                     formObj.bank_stmt_ctnt.readOnly   = true;
                                     /***Delete Button Enable 처리 **/
                                     if( formObj.ofc_cd.Code == formObj.strOfc_cd.value 
                                     &&  formObj.usr_id.Code == formObj.str_usr_id.value){
                                         if( document.all.btn_delete.className == "btn1_1" ){
                                             document.all.btn_delete.className = "btn1";
                                         }  
                                     }                                     
                                 }    
                                 break;
                                 
                         case    IBRESET:                                 
                                 ComSetObjValue( formObj.usr_id     , formObj.str_usr_id.value);
                                 fnFormClear('');
                                 break;
                                            
                         case    IBSEARCH_ASYNC04:        //COPY
                                 formObj.usr_id.Code2         = "";
                                 formObj.jo_tmplt_no.Code2    = "";
                                 formObj.sig_stmt_ctnt.className  = "textarea1_1";
                                 formObj.sig_stmt_ctnt.readOnly   = false;
                                 formObj.bank_stmt_ctnt.className = "textarea1_1";
                                 formObj.bank_stmt_ctnt.readOnly   = false;
                                 formObj.jo_ltr_tmplt_seq.value = "";
                                 formObj.jo_tmplt_no.Enable   = false;
                                 formObj.usr_id.Enable   = false;
                                 break;
                                 
                         case    IBSAVE:   
                                 if( !validateForm(sheetObj,formObj,sAction) ){return;}
                                 sheetObj.WaitImageVisible=false;
                                 ComOpenWait(true);
                                 formObj.f_cmd.value = MULTI01;         
                                 var param =  FormQueryString(formObj);
 
                                 var sXml  =  sheetObj.GetSaveXml("FNS_JOO_0075GS.do", param );
                                 var aXml  = sXml.split("|$$|");
  
                                 ComXml2ComboItem( aXml[0], formObj.usr_id      , "usr_id","usr_id|usr_nm" );
                                 ComXml2ComboItem( aXml[1], formObj.jo_tmplt_no , "jo_tmplt_no", "jo_tmplt_no_seq" );
                                 
                                 formObj.usr_id.Code2 = formObj.str_usr_id.value;                                 
                                 formObj.ofc_cd.Code2 = formObj.strOfc_cd.value;    
                                 
                                 var NEW_JO_TMPLT_NO = ComGetEtcData ( aXml[0], "NEW_JO_TMPLT_NO");
                                 var NEW_JO_LTR_TMPLT_SEQ = ComGetEtcData ( aXml[0], "NEW_JO_LTR_TMPLT_SEQ");                                 
      
                                 if( NEW_JO_TMPLT_NO != undefined ){
                                     formObj.jo_tmplt_no.Code2 = NEW_JO_TMPLT_NO;
                                 }
                                 if(formObj.jo_ltr_tmplt_seq.value == ""){
                                     formObj.usr_id.Enable     = true;
                                     formObj.jo_tmplt_no.Enable = true;  
                                 }
                                 if( NEW_JO_LTR_TMPLT_SEQ != undefined ){
                                     ComSetObjValue( formObj.jo_ltr_tmplt_seq , NEW_JO_LTR_TMPLT_SEQ  );        
                                 }

                                 
                                 var message = ComJooGetMessageFromXml(aXml[0]); 
                                 if( message != ""){
                                      ComShowMessage(message);
                                 }
                                 ComOpenWait(false);
                                 break;
                            
                         case    IBDELETE:   
                                if( !validateForm(sheetObj,formObj,sAction) ){return;}      
                                sheetObj.WaitImageVisible=false;
                                ComOpenWait(true);
                                formObj.f_cmd.value = REMOVE;         
                                var param =  FormQueryString(formObj);
                                var usr_id_value = formObj.usr_id.Code;
                                var sXml  =  sheetObj.GetSaveXml("FNS_JOO_0075GS.do", param );
                                var aXml  = sXml.split("|$$|");
 
                                ComXml2ComboItem( aXml[0], formObj.usr_id      , "usr_id","usr_id|usr_nm" );
                                ComXml2ComboItem( aXml[1], formObj.jo_tmplt_no , "jo_tmplt_no", "jo_tmplt_no_seq" );
                                if(  formObj.usr_id.FindIndex(usr_id_value, 0) == -1){ 
                                    formObj.usr_id.Code = "";
                                }else{
                                    ComSetObjValue( formObj.usr_id     , formObj.str_usr_id.value);
                                }
                 
                                var message = ComJooGetMessageFromXml(aXml[0]); 
                                if( message != ""){
                                     ComShowMessage(message);
                                }
                                ComOpenWait(false);
                                /**
                                 * 정상 처리 완료시.
                                 */
                                if( ComGetEtcData ( aXml[0], "TRANS_RESULT_KEY") == "S") {
                                    formObj.jo_ltr_tmplt_seq.value = "";
                                    formObj.jo_tmplt_no.Enable   = true;
                                    formObj.usr_id.Enable        = true;
                                }
                                break;
                     }
         }
       /**
        * 화면 폼입력값에 대한 유효성검증 프로세스 처리
        */
       function validateForm(sheetObj,formObj,sAction){
   
           with(formObj){
               switch ( sAction ){
                    case IBSEARCH :
                         if( formObj.ofc_cd.Code == "" ){
                             ComShowCodeMessage('JOO00115', "Office");   
                             return false;    
                         }
                         if( formObj.usr_id.Code == "" ){
                             ComShowCodeMessage('JOO00115', "Creation User NM");   
                             return false;    
                         }
 
                         if( formObj.jo_tmplt_no.GetCount() != 0 ) {
                             if( formObj.jo_tmplt_no.Code == "" ){
                                 ComShowCodeMessage('JOO00115', "Seq.");   
                                 formObj.jo_tmplt_no.focus();
                                 return false;    
                             }
                         }
                         break;
                         
                    case  IBSAVE :
                          
                          if ( formObj.sig_stmt_ctnt.className  != "textarea1_1" ){
                              return false;
                          }
                          if( formObj.sig_stmt_ctnt.value == ""){
                              ComShowCodeMessage('JOO00116', "Signature");   
                              formObj.sig_stmt_ctnt.focus();
                              return false;   
                          }
                          if( formObj.bank_stmt_ctnt.value == ""){
                              ComShowCodeMessage('JOO00116', "Bank Details");
                              formObj.bank_stmt_ctnt.focus();
                              return false;      
                          }
                              
                          if( ComGetLenByByte(formObj.sig_stmt_ctnt)  > 4000 ){
                              ComShowCodeMessage('JOO00117', "Signature Length(4000 Byte)");   
                              return false;   
                          }
                          if( ComGetLenByByte(formObj.bank_stmt_ctnt)  > 4000 ){
                              ComShowCodeMessage('JOO00117', "Bank Details Length(4000 Byte)");   
                              return false;   
                          }
                          break;                            

                    case IBDELETE :
                         if( formObj.jo_tmplt_no.Code == "" ) {
                             return false;
                         }
                         if( ComShowCodeConfirm("JOO00061") ){
                             return true;   
                         }else{
                             return false;
                         }
                   }
               }

               return true;
           }         
     /**
      * 설명영역. <br>
      * <br><b>Example : </b>
      * <pre>
      *     ofc_cd(Object Name : trd_cd) OnChange 
      *                                이벤트 발생시 처리.  
      * </pre>
      * @param {인자Type} 콤보object 선택
      * @return void
      * @see #링크연결
      * @author jang kang cheol
      * @version 2009.07.01
      */
      function ofc_cd_OnChange(comboObj,value,text) {
          var formObj = document.form;
          fnFormClear(comboObj.id);           
          doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02); 
         
      } 
      /**
       * 설명영역. <br>
       * <br><b>Example : </b>
       * <pre>
       *     usr_id(Object Name : trd_cd) OnChange 
       *                                이벤트 발생시 처리.  
       * </pre>
       * @param {인자Type} 콤보object 선택
       * @return void
       * @see #링크연결
       * @author jang kang cheol
       * @version 2009.07.01
       */      
      function usr_id_OnChange(comboObj,value,text) {
          var formObj = document.form;
          fnFormClear(comboObj.id);
          doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);  
 

      }    
      
      function jo_tmplt_no_OnChange(comboObj,value,text) {
          var formObj = document.form;
          if(value == ""){
              formObj.sig_stmt_ctnt.value  = "";
              formObj.bank_stmt_ctnt.value = "";
          }
         // doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
      }
      
      /**
       * 
       * <pre>
       *     폼 클리어 
       * </pre>
       *
       * @param   obj : element object
       * @return  void
       * @author  Jang Kang Cheol
       */
      function fnFormClear(obj_name){
          var formObject = document.form;
 
          switch( obj_name ) {
              case "ofc_cd":                                  
                   ComSetObjValue( formObject.usr_id, formObject.str_usr_id.value);
                   formObject.jo_tmplt_no.Code2    = "";            
                   formObject.sig_stmt_ctnt.value  = "";
                   formObject.bank_stmt_ctnt.value = "";                   
                   break;

              case "usr_id": 
                   formObject.jo_tmplt_no.Code2    = "";            
                   formObject.sig_stmt_ctnt.value  = "";
                   formObject.bank_stmt_ctnt.value = "";                   
                   break;
                   
              case "": 
                  formObject.usr_id.Code2         = "";
                  formObject.jo_tmplt_no.Code2    = "";
                  formObject.sig_stmt_ctnt.className  = "textarea1_1";
                  formObject.sig_stmt_ctnt.readOnly   = false;
                  formObject.bank_stmt_ctnt.className = "textarea1_1";
                  formObject.bank_stmt_ctnt.readOnly   = false;         
                  formObject.sig_stmt_ctnt.value  = "";
                  formObject.bank_stmt_ctnt.value = "";           
                  formObject.jo_ltr_tmplt_seq.value = "";
                  break;
           } 
      }
       /* 개발자 작업  끝 */