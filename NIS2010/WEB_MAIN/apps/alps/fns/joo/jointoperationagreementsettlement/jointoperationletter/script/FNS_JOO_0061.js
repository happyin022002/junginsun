/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0061.js
*@FileTitle : Invoice Letter Information Text Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.24 함대성
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
     * @class fns_joo_0061 : fns_joo_0061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0061() {
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
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    var prefix = "sheet1_";
    
    var IBSAVE02    = 32;
     
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
       var sheetObject = sheetObjects[0];

       /*******************************************************/
       var formObject = document.form;

//       try {
           var srcName = window.event.srcElement.getAttribute("name");
           switch (srcName) {
               case "btn_retrieve":
    
                   doActionIBSheet(sheetObject, formObject, IBSEARCH);
               break; 
               
               case "btn_new":
                   doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
               break;
               
               case "btn_save":
                    doActionIBSheet(sheetObject, formObject, IBSAVE); 
               break;
               
               case "btn_Copy":
                   doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
               break;
               
               case "btn_del":
                       doActionIBSheet(sheetObject, formObject, REMOVE);
               break;

           } // end switch
//       } catch (e) {
//           if (e == "[object Error]") {
//               ComShowCodeMessage('JOO00001');
//           } else {
//               ComShowMessage(e);
//           }
//       }
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
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

       for (i = 0; i < sheetObjects.length; i++) {

           //khlee-시작 환경 설정 함수 이름 변경
           ComConfigSheet(sheetObjects[i]);

           initSheet(sheetObjects[i], i + 1);
           //khlee-마지막 환경 설정 함수 추가
           //ComEndConfigSheet(sheetObjects[i]);
       }
       //combo 초기화
       for(var k=0;k<comboObjects.length;k++){
           initCombo(comboObjects[k], k+1);
       }
    
       initControl();
    }
    
     function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
      }
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {
         var formObject = document.form;
         axon_event.addListenerForm  ('keypress', 'fnEnterCheck',  formObject);  
    
     }    
     function fnEnterCheck(){
         var obj = window.event.srcElement;
         var keyCheck = false;
         var elementName = "n1st_stmt_ctnt,n2nd_stmt_ctnt,n3rd_stmt_ctnt,sig_stmt_ctnt";
         
    
         if( elementName.indexOf( obj.name ) > -1  ){
             keyCheck = true;
         }
         
         if (keyCheck){
              if( event.keyCode == "13" ){
                  if(  obj.value.indexOf("\n") >-1 ){
                       var crCnt = obj.value.split("\n");
                       if( crCnt.length >= eval( obj.getAttribute("rows") )  ){
                           event.returnValue = false;
                       }
                  }
              }
         }
     }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

       var cnt = 0;
       switch (sheetNo) {
       case 1: //t1sheet1 init
           with (sheetObj) {

               // 높이 설정
               style.height = 0;
               //전체 너비 설정
               SheetWidth = mainTable.clientWidth;

               //Host정보 설정[필수][HostIp, Port, PagePath]
               if (location.hostname != "")
                   InitHostInfo(location.hostname, location.port, page_path);

               //전체Merge 종류 [선택, Default msNone]
               MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
               Editable = false;

               //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
               InitRowInfo(1, 1, 3, 100);

               //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
               InitColumnInfo(1, 0, 0, true);

               // 해더에서 처리할 수 있는 각종 기능을 설정한다
               InitHeadMode(true, true, false, true, false, false)

               //var HeadTitle = "|Del.|Carrier|Trade|Lane|Vendor Code|Customer Code|Vendor / Customer Name|Address|DEL_MK";
               var HeadTitle = "|";

               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
               InitHeadRow(0, HeadTitle, true);
     
               //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]           
               InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, false, prefix+"ibflag"); 
                
           }
           break;

       }
    }

    // combo object 초기화
    function initCombo(comboObj, comboNo) {
        var formObject = document.form
        switch(comboObj.id) {   
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

           case "user_id": 
                with (comboObj) { 
                    MultiSelect = false; 
                    UseAutoComplete = true;    
                    SetColAlign("left");        
                    SetColWidth("80|100");
                    DropHeight = 160;
                    ValidChar(2,1);
                    MaxLength = 8;
               }
               break; 
        } 
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
       sheetObj.ShowDebugMsg = false;
       switch (sAction) {
       
           case IBSEARCH_ASYNC02: // 조회
               formObj.user_id.Code = formObj.userIdSave.value;
               formObj.user_id.Enable        = true;     
               formObj.jo_tmplt_no.Enable   = true;
               reset0061();
               fnEditEnable(true);
           break;
           case IBSEARCH: // 조회
               if(!validateForm(sheetObj,formObj,sAction))return;
               formObj.f_cmd.value = SEARCH;

               var sXml = sheetObj.GetSearchXml("FNS_JOO_0061GS.do" , FormQueryString(form));
               var n1st_stmt_ctnt      = ComGetEtcData(sXml,"n1st_stmt_ctnt");   
               var n2nd_stmt_ctnt      = ComGetEtcData(sXml,"n2nd_stmt_ctnt");  
               var n3rd_stmt_ctnt      = ComGetEtcData(sXml,"n3rd_stmt_ctnt"); 
               var sig_stmt_ctnt       = ComGetEtcData(sXml,"sig_stmt_ctnt");
               var jo_ltr_tmplt_seq    = ComGetEtcData(sXml,"jo_ltr_tmplt_seq");            
               
               var bank_stmt_ctnt       = ComGetEtcData(sXml,"bank_stmt_ctnt");
               //var cre_usr_id            = ComGetEtcData(sXml,"cre_usr_id");
               
               formObj.n1st_stmt_ctnt  .value = n1st_stmt_ctnt;
               formObj.n2nd_stmt_ctnt  .value = n2nd_stmt_ctnt;
               formObj.n3rd_stmt_ctnt  .value = n3rd_stmt_ctnt;
               formObj.sig_stmt_ctnt   .value = sig_stmt_ctnt;
               formObj.bank_stmt_ctnt   .value = bank_stmt_ctnt;
               formObj.jo_ltr_tmplt_seq   .value = jo_ltr_tmplt_seq;
               
               var n4th_stmt_ctnt      = ComGetEtcData(sXml,"n4th_stmt_ctnt");       
               formObj.n4th_stmt_ctnt  .value = n4th_stmt_ctnt;               
               
               fnEditCheck();
           break;
               
           case IBSAVE:  
               if(!validateForm(sheetObj,formObj,sAction))return;
               sheetObj.WaitImageVisible=false;
               ComOpenWait(true);
               formObj.f_cmd.value = MULTI; 
               var sXml = sheetObj.GetSaveXml("FNS_JOO_0061GS.do",FormQueryString(formObj));
               sheetObj.LoadSearchXml(sXml);
               ComOpenWait(false);
               if(formObj.jo_ltr_tmplt_seq.value != ""){return;}//UPDATE 확인.
               ComXml2ComboItem( sXml, formObj.jo_tmplt_no, "code","code" );
               var NEW_JO_TMPLT_NO      = ComGetEtcData(sXml,"NEW_JO_TMPLT_NO");
               var NEW_JO_LTR_TMPLT_SEQ = ComGetEtcData(sXml,"NEW_JO_LTR_TMPLT_SEQ");
               


               if(formObj.jo_ltr_tmplt_seq.value == ""){
    
                   formObj.user_id.Enable     = true;
                   formObj.jo_tmplt_no.Enable = true;  
                   
                   formObj.user_id.Code2      = formObj.userIdSave.value;
                   var usernm = formObj.user_id.GetIndexText( formObj.user_id.Index ,1);
                   formObj.user_nm.value  = usernm;
                   
                   formObj.jo_tmplt_no.Code2  = NEW_JO_TMPLT_NO;
                   formObj.jo_ltr_tmplt_seq.value = NEW_JO_LTR_TMPLT_SEQ;
               }

           break;
   
           case IBCLEAR:
               formObj.f_cmd.value = SEARCH02;
               var sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0061GS.do" , FormQueryString(form));
               var aXml = sXml.split("|$$|");
    
               ComXml2ComboItem( aXml[0], formObj.user_id    , "usr_id","usr_id|usr_nm" );  
               ComXml2ComboItem( aXml[1], formObj.jo_tmplt_no, "code"  ,"code" );  
               
               var ofc_addr = ComGetEtcData(aXml[0],"ofc_addr");
               formObj.ofc_addr.value  = ofc_addr;
               
               formObj.bank_stmt_ctnt.value      = ComGetEtcData(aXml[0],"bank_stmt_ctnt"); 
               formObj.sig_stmt_ctnt .value      = ComGetEtcData(aXml[0],"sig_stmt_ctnt");
               
               formObj.user_id.Code  = formObj.userIdSave.value;
    
               
           break;
           case IBSEARCH_ASYNC01:
               formObj.user_id.Code2         = "";
               formObj.user_id.Enable        = false;
               formObj.user_nm.value         = "";
              
               formObj.jo_tmplt_no.Code2    = "";         
               formObj.jo_tmplt_no.Enable   = false;
               
               formObj.jo_ltr_tmplt_seq  .value = "";//KEY Clear
               
               formObj.n1st_stmt_ctnt.className  = "textarea1_1";
               formObj.n1st_stmt_ctnt.readOnly   = false;
               formObj.n2nd_stmt_ctnt.className  = "textarea1_1";
               formObj.n2nd_stmt_ctnt.readOnly   = false;
               formObj.n3rd_stmt_ctnt.className  = "textarea1_1";
               formObj.n3rd_stmt_ctnt.readOnly   = false;
 
                
            break;
           case IBSEARCH_ASYNC03:
               //콤보필드를 초기화시킨다.
               formObj.jo_tmplt_no.RemoveAll();
               formObj.f_cmd.value =  SEARCHLIST01; 
               var sXml = sheetObj.GetSearchXml("FNS_JOO_0061GS.do", FormQueryString(formObj));
               ComXml2ComboItem( sXml, formObj.jo_tmplt_no, "code","code" );  
           break;
           case REMOVE:
               if(!validateForm(sheetObj,formObj,sAction))return;
               sheetObj.WaitImageVisible=false;
               ComOpenWait(true);
               formObj.f_cmd.value = REMOVE;
               var sXml = sheetObj.GetSaveXml("FNS_JOO_0061GS.do", FormQueryString(formObj)); 
               sheetObj.LoadSearchXml(sXml);
               ComXml2ComboItem( sXml, formObj.jo_tmplt_no, "code"  ,"code" );  
               var rstTr = ComJooGetTrAllValue(sXml);
               if( rstTr == "OK"){
                     reset0061();
               }
               ComOpenWait(false);
           break;  
               
       }
    }

    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
       sheetObj.ShowDebugMsg = false;
       switch (sAction) {
           case IBSEARCH: //조회 
               if(formObj.user_id.text.length == 0){
                   ComShowCodeMessage('JOO00115', 'Creation User NM'); 
                   formObj.user_id.focus();
                   return false;
               }
               if(formObj.jo_tmplt_no.text.length == 0){
                   ComShowCodeMessage('JOO00115', 'Text No.'); 
                   formObj.jo_tmplt_no.focus();
                   return false;
               }
           break;
               
           case IBSAVE:   //저장
    
               if( formObj.jo_ltr_tmplt_seq.value != "" ){
                   if( formObj.userIdSave.value != formObj.user_id.Code  ){
                       return false;
                   }
               }
               if( !len_chk() ){
                   return false;
               }
               if(formObj.n1st_stmt_ctnt.value.length == 0){
                   ComShowCodeMessage('JOO00116', 'Text Detail - 1');
                   formObj.n1st_stmt_ctnt.focus();
                   return false;
               }
               if(formObj.n2nd_stmt_ctnt.value.length == 0){
                   ComShowCodeMessage('JOO00116', 'Text Detail - 2');
                   formObj.n2nd_stmt_ctnt.focus();
                   return false;
               }
               if(formObj.n3rd_stmt_ctnt.value.length == 0){
                   ComShowCodeMessage('JOO00116', 'Attachment');
                   formObj.n3rd_stmt_ctnt.focus();
                   return false;
               }
               if(formObj.sig_stmt_ctnt.value.length == 0){
                   ComShowCodeMessage('JOO00116', 'Signature');
                   formObj.sig_stmt_ctnt.focus();
                   return false;
               }
           break;
           
    
           
           case REMOVE:   //삭제 
               if( formObj.userIdSave.value != formObj.user_id.Code  ){
                   return false;
               }
               if(formObj.user_id.text.length == 0){
                   ComShowCodeMessage('JOO00115', 'Creation User NM');
                   formObj.user_id.focus();
                   return false;
               }
               if(formObj.jo_tmplt_no.text.length == 0){
                   ComShowCodeMessage('JOO00115', 'Text No');
                   formObj.jo_tmplt_no.focus();
                   return false;
               }
               if( !ComShowCodeConfirm("JOO00135","Template") ){
                   return false;
               }


           break;
       } 
       
       return true;
    }  

    function reset0061(){
       var formObject = document.form;
    
       formObject.jo_tmplt_no    .text2  = "";
       formObject.n1st_stmt_ctnt .value = "";
       formObject.n2nd_stmt_ctnt .value = "";
       formObject.n3rd_stmt_ctnt .value = "";
       formObject.n4th_stmt_ctnt  .value = "";
       formObject.jo_ltr_tmplt_seq  .value = "";
       
      // formObject.bank_stmt_ctnt  .value = "";
       
       
    }
    
    
    function user_id_OnChange(comboObj, code, text){
        var formObj = document.form;
    
        var usernm = comboObj.GetIndexText( comboObj.Index ,1);
    
        if ( usernm != "") {
            formObj.user_nm.value = usernm;
        } else {
            formObj.user_nm.value = "";
        }
        reset0061();
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
    
    }
    
    function jo_tmplt_no_OnChange(comboObj, code, text){
        var formObj = document.form;
        formObj.n1st_stmt_ctnt .value = "";
        formObj.n2nd_stmt_ctnt .value = "";
        formObj.n3rd_stmt_ctnt .value = "";
        formObj.n4th_stmt_ctnt .value = "";
        //doActionIBSheet(sheetObjects[0], form, IBSEARCH);
    }
    
    
    function len_chk(){
         
        var formObj = document.form;
        if(formObj.n1st_stmt_ctnt.value.length > 4000){
            ComShowCodeMessage('JOO00134', 'Text Detail - 1');
            var n1st_stmt_ctnt = formObj.n1st_stmt_ctnt.value.substring(0, 4000);
            formObj.n1st_stmt_ctnt.value = n1st_stmt_ctnt;
            formObj.n1st_stmt_ctnt.focus();
            return false;
        }else if(formObj.n2nd_stmt_ctnt.value.length > 4000){
            ComShowCodeMessage('JOO00134', 'Text Detail - 2');
            var n2nd_stmt_ctnt = formObj.n2nd_stmt_ctnt.value.substring(0, 4000);
            formObj.n2nd_stmt_ctnt.value = n2nd_stmt_ctnt;
            formObj.n2nd_stmt_ctnt.focus();
            return false;
        }else if(formObj.n4th_stmt_ctnt.value.length > 4000){
            ComShowCodeMessage('JOO00134', 'Greeting');
            var n4th_stmt_ctnt = formObj.n4th_stmt_ctnt.value.substring(0, 4000);
            formObj.n4th_stmt_ctnt.value = n4th_stmt_ctnt;
            formObj.n4th_stmt_ctnt.focus();
            return false;
        }else if(formObj.n3rd_stmt_ctnt.value.length > 4000){
            ComShowCodeMessage('JOO00134', 'Attachment');
            var n3rd_stmt_ctnt = formObj.Attachment.value.substring(0, 4000);
            formObj.n3rd_stmt_ctnt.value = n3rd_stmt_ctnt;
            formObj.n3rd_stmt_ctnt.focus();
            return false;
        }else if(formObj.sig_stmt_ctnt.value.length > 4000){
            ComShowCodeMessage('JOO00134', 'Signature');
            var sig_stmt_ctnt = formObj.sig_stmt_ctnt.value.substring(0, 4000);
            formObj.sig_stmt_ctnt.value = sig_stmt_ctnt;
            formObj.sig_stmt_ctnt.focus();
            return false;
        }else if(formObj.bank_stmt_ctnt.value.length > 4000){
            ComShowCodeMessage('JOO00134', 'Bank detail');
            var sig_stmt_ctnt = formObj.sig_stmt_ctnt.value.substring(0, 4000);
            formObj.sig_stmt_ctnt.value = sig_stmt_ctnt;
            formObj.sig_stmt_ctnt.focus();
            return false;
        }
        
        return true;
    }
    /**
     * 
     * <pre>
     *     Edit Check 함수 
     * </pre>
     *
     * @param    void
     * @return   void
     * @author jang kang cheol
     */
    function fnEditCheck(){
        var formObj = document.form;
        if( formObj.userIdSave.value != formObj.user_id.Code  ){

            formObj.n1st_stmt_ctnt.className  = "textarea2";
            formObj.n1st_stmt_ctnt.readOnly   = true;
            formObj.n2nd_stmt_ctnt.className  = "textarea2";
            formObj.n2nd_stmt_ctnt.readOnly   = true;
            formObj.n3rd_stmt_ctnt.className  = "textarea2";
            formObj.n3rd_stmt_ctnt.readOnly   = true;
 
            
        }

        if( formObj.userIdSave.value == formObj.user_id.Code  
        ||  formObj.jo_tmplt_no.GetCount() == 0){
            formObj.n1st_stmt_ctnt.className  = "textarea1_1";
            formObj.n1st_stmt_ctnt.readOnly   = false;
            formObj.n2nd_stmt_ctnt.className  = "textarea1_1";
            formObj.n2nd_stmt_ctnt.readOnly   = false;
            formObj.n3rd_stmt_ctnt.className  = "textarea1_1";
            formObj.n3rd_stmt_ctnt.readOnly   = false;
 
        }
    }
    function fnEditEnable(bYn){
        var formObj = document.form;
        if(bYn){
            formObj.n1st_stmt_ctnt.className  = "textarea1_1";
            formObj.n1st_stmt_ctnt.readOnly   = false;
            formObj.n2nd_stmt_ctnt.className  = "textarea1_1";
            formObj.n2nd_stmt_ctnt.readOnly   = false;
            formObj.n3rd_stmt_ctnt.className  = "textarea1_1";
            formObj.n3rd_stmt_ctnt.readOnly   = false;
 
        }else{
            formObj.n1st_stmt_ctnt.className  = "textarea2";
            formObj.n1st_stmt_ctnt.readOnly   = true;
            formObj.n2nd_stmt_ctnt.className  = "textarea2";
            formObj.n2nd_stmt_ctnt.readOnly   = true;
            formObj.n3rd_stmt_ctnt.className  = "textarea2";
            formObj.n3rd_stmt_ctnt.readOnly   = true;
 
        }
    }

       /* 개발자 작업  끝 */    
  