/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0060.js
*@FileTitle : MCS Letter Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
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
     * @class fns_joo_0060 : fns_joo_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0060() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;
    var queryStr = "";
    
    // 리턴팝업에서 사용하는 전역변수
    var rtnPopValue= new Array(20);    

    var  gHead_ltr_tit_ctnt = "Monthly Clearance for ";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             
             var sheetObject1 = sheetObjects[0];
             
             /*******************************************************/
             var formObject = document.form;

           //  try {
                 var srcName = window.event.srcElement.getAttribute("name");
                 if(srcName==null){
                     return; 
                 }
 
//                 if( !JooBtnClickEnable(srcName) ){
//                     return;
//                 }
                 
                     switch(srcName) {
                     
                         case "btn_File_View":
                             var className = window.event.srcElement.className;
                             if( className == "btn1_1"){
                                 return;
                             }
                             doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC07);
                         break;
                         
                         case "btn_Retrieve":
                             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                             break;
                         
                         case "btn_New":
                             doActionIBSheet(sheetObjects[0],document.form,IBRESET);
                             break;
                             
                         case "btn_Save":
                             doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                             break;                             
                             
                         case "btn_DownExcel":
                             sheetObjects[0].SpeedDown2Excel(-1);                
                             break;
                             
                         case "btns_calendar": //달력버튼
                              var cal = new ComCalendar();
                              cal.select(formObject.ltr_iss_dt, 'yyyy-MM-dd');
                              if( document.form.jo_ltr_seq.value != "" ){
                                 document.form.changeyn.value = "Y";
                              }
                              break;   
                              
                         case "btn_Send": //Send
                              doActionIBSheet(sheetObjects[0],document.form,MULTI02);                              
                              break;   
                              
                         case "btn_Attach": //Attach
                              doActionIBSheet(sheetObjects[0],document.form,MULTI03);                              
                              break;   

                         case "btn_Print": //btn_Print
                              rdOpen();                                
                              break;                                 
                         case "btn_Retrieve2":
                             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
                             break;
                             
                        
                              
                 } // end switch
//             }catch(e) {
//                 if( e == "[object Error]") {
//                     ComShowMessage(OBJECT_ERROR);
//                 } else {
//                     ComShowMessage(e);
//                 }
//             }
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
           
           var doc = document.all;
           var formObj = document.form;
           formObj.com_mrdBodyTitle.value = doc.title.innerHTML.replace("&nbsp;","");
           formObj.com_mrdTitle.value     = doc.title.innerHTML.replace("&nbsp;","");
           initControl();
           

       }
 
        function rdOpen(){
            var formObj = document.form;
            queryStr="";
            if( !setQueryStr() ){
                return;
            }
           var rdParam = '/rp '+queryStr;
           var strPath   =  "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_0063.mrd";
           
           var strPath   =  "";
           var ofc_cd    = formObj.ofccd.value;
           if( ofc_cd.toUpperCase() == "SINRS"){
               strPath = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_1063.mrd";
           }else{
               strPath = "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_0063.mrd";
           }
           
           
            // 열고자 하는 RD 파일을 지정한다.
           // Rdviewer.FileOpen( strPath, RDServerBAT + rdParam);
        
           formObj.com_mrdPath.value = strPath;
           formObj.com_mrdArguments.value = rdParam;
           ComOpenRDPopup();
 
        }
        function setQueryStr(){
            //     rdParam = "/rp [1]";
            var formObj = document.form;

            if(formObj.jo_ltr_seq.value == ""){
                ComShowCodeMessage("JOO00124");
                return false;
            }else{
                queryStr += " ["+formObj.jo_ltr_seq.value+"]";                     
            }
            return true;
        }        
        
        function sheet1_OnLoadFinish(sheetObj) {
            var formObj = document.form; 
             
            if( formObj.jo_ltr_seq.value == ""){
                doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
            }else{//0070에서 링크시. 
                doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
                doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC05);
            }
        }
        /**
         * 
         * <pre>
         *    Lane Code Multi Combo 체크 이벤트 처리
         * </pre>
         *
         * @param   
         * @return
         * @author jang kang cheol
         */
        function rlane_cd_OnCheckClick(index,code){
             //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        function rlane_cd_OnChange(comboObj,value,text) {
           // doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
               case "jo_crr_cd":  
                   with (comboObj) { 
                       MultiSelect = false; 
                       UseAutoComplete = true;    
                       SetColAlign("left");        
                       SetColWidth("60");
                       DropHeight = 160;
                       ValidChar(2,0);
                       MaxLength = 3;
                    }  
                    break; 
                case "trd_cd":  
                    with (comboObj) { 
                        MultiSelect = false; 
                        UseAutoComplete = true;    
                        SetColAlign("left");        
                        SetColWidth("60");
                        DropHeight = 160;
                        ValidChar(2,0);
                        MaxLength = 3;
                     }  
                     break;   
               case "rlane_cd": 
                   with (comboObj) {
                        MultiSeparator  = "|";
                        MultiSelect     = true;  
                        UseAutoComplete = true;    
                        SetColAlign("left");        
                        SetColWidth("60");
                        DropHeight = 200;
                        ValidChar(2,0);                                             
                    }  
                    break;    
               case "jo_tmplt_no": 
                   with (comboObj) { 
                        UseAutoComplete = true;
                        SetColAlign("left");
                        SetColWidth("60|0");
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
           //axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);  
           axon_event.addListenerForm  ('keydown', "fnOnKeyDown",  formObject);
           
           axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
           axon_event.addListenerForm  ('change', 'fnObjChange', formObject );
           axon_event.addListenerForm  ('click',   'fnDocClick',  formObject             );    
           
           axon_event.addListener      ('click',   'fnDocClick', "btn_acct_yrmon_back"       );         
           axon_event.addListener      ('click',   'fnDocClick', "btn_acct_yrmon_next"       );  
           axon_event.addListener      ('click',   'fnDocClick', "btns_search01"             );           

           
           axon_event.addListenerFormat('blur'   ,  'fnDeactivate',  formObject);  
           axon_event.addListenerFormat('focus'     ,  'fnActivate'  ,  formObject);           
 
           
           var monthEng = ComJooDateForEng(yyyyMM);
           for(var i=0;i< formObject.ltr_tit_ctnt_mnth.length;i++ ){
               if ( formObject.ltr_tit_ctnt_mnth[i].value == monthEng){
                   formObject.ltr_tit_ctnt_mnth[i].selected = true;
                   break;
               }
           }

       }    
    
        function fnEnterCheck(obj){

            var keyCheck = false;
            var elementName = "n1st_stmt_ctnt,n2nd_stmt_ctnt,n3rd_stmt_ctnt,bank_stmt_ctnt,sig_stmt_ctnt";
            
       
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
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
            
                case 1:      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 120;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                        var HeadTitle1 = "|Year/Month|Service Lane|Amount|Remark";
                                                
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        
                        var prefix  = "sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,            WIDTH,    DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,      30,     daCenter,       false,       prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtData,             100,     daCenter,       true,        prefix+"acct_yrmon",      false,      "",                     dfUserFormat,       0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,             100,     daCenter,       true,        prefix+"rlane_cd",        false,      "",                     dfNone,             0,          false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,          160,     daRight,        false,       prefix+"ttl_amt",         false,      "",                     dfNullFloat,        2,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,             200,     daLeft,         false,       prefix+"stl_rmk",         false,      "",                     dfEngKey,           0,          true,        true, 100);
                        InitUserFormat  (0,  prefix+"acct_yrmon" , "####-##", "-" );       
                        
                        InitDataValid(0,  prefix+"stl_rmk", vtEngOther," ");
                    }
                    break;
                case 2:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle1 = "|Year/Month|Service Lane|Amount|Remark";
                                            
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    var prefix  = "sheet2_";
                    //데이터속성    [ROW, COL,  DATATYPE,            WIDTH,    DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,     daCenter,       false,       prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,             100,     daCenter,       true,        prefix+"cust_lgl_eng_nm",      false,      "",                     dfUserFormat,       0,           false,       false);
                }
                break;
              
            }
        }
         // Sheet관련 프로세스 처리
         function doActionIBSheet(sheetObj,formObj,sAction) {
             sheetObj.ShowDebugMsg = false;
 
                     switch(sAction) {
                     
                         case    IBCLEAR:         //Open  
                                 formObj.f_cmd.value = SEARCH01;            
                                 var param  =  FormQueryString(formObj); 
                                 var sXml   =  sheetObj.GetSearchXml("FNS_JOO_0060GS.do", param);
                                 var aXml   = sXml.split("|$$|");
                                 ComXml2ComboItem( aXml[0], formObj.jo_crr_cd   , "code","code" );
                                 ComXml2ComboItem( aXml[1], formObj.jo_tmplt_no , "jo_tmplt_no","jo_tmplt_no|jo_ltr_tmplt_seq" );
                                 break;
 
                         case    IBSEARCH_ASYNC02:      //Get List Trade Code By Carrier Code 
                                 formObj.f_cmd.value = SEARCHLIST06;            
                                 var code  = formObj.jo_crr_cd.Text;
                                 var param =  FormQueryString(formObj)+"&super_cd1="+code;
                                 var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                                 ComXml2ComboItem( sXml, formObj.trd_cd, "code","code" );
                                 
                                 //formObj.trd_cd.focus();
                                 break;  
                        
                         case    IBSEARCH_ASYNC03:      //Get List Lane Code By  ( jo_crr_cd AND Trade Code)  
                                 formObj.f_cmd.value = SEARCH12;            
                                 var code1  = formObj.jo_crr_cd.Text;
                                 var code2  = formObj.trd_cd.Text;
                                 var param =  FormQueryString(formObj)+"&super_cd1="+code1+"&super_cd2="+code2+"&jo_crr_auth_cd=W";
                                 var sXml  =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                                 ComXml2ComboItem( sXml, formObj.rlane_cd, "code","code" );
                                 
                                 //formObj.rlane_cd.focus();
                                 break; 
                                 
                         case    IBSEARCH_ASYNC04:      //Get Template  On Change
                                 if( !validateForm(sheetObj,formObj,sAction) ){
                                      formObj.jo_tmplt_no.Code2 = "";
                                      return;
                                 }                         
                                 formObj.f_cmd.value = SEARCH02;            
                                 var param =  FormQueryString(formObj);  
                                 var sXml    =  sheetObj.GetSearchXml("FNS_JOO_0060GS.do", param);
                                 var aXml    =  sXml.split("|$$|");
                                 fnSetTmplt( aXml[0] );
                                 ComXml2ComboItem( aXml[1], formObj.ltr_rcvr_co_nm, "cust_lgl_eng_nm","cust_lgl_eng_nm" );    
                                 
                                 var TotalCnt = ComGetTotalRows(aXml[1]);
                                 if( TotalCnt == "0" ){
                                     
                                 }else{
                                     if( TotalCnt == "1" ){
                                         formObj.ltr_rcvr_co_nm.index = 0;
                                     }else {
                                         formObj.ltr_rcvr_co_nm.index = -1;                                         
                                     }
 
                                     //var objBtnSearch  = document.all.btns_search01;
                                     //objBtnSearch.fireEvent("onclick");
                                 }
                                 break; 
                                 
                         case    IBSEARCH:      //조회 
                                 if( !validateForm(sheetObj,formObj,sAction) ){return;}
                                 formObj.f_cmd.value = SEARCHLIST01;            
                                 var aryPrefix = new Array("sheet1_");
                                 var param =  FormQueryString(formObj)+"&" + ComGetPrefixParam( aryPrefix ) ;  
          
                                 var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0060GS.do", param,"", true);
                                 sheetObj.LoadSearchXml(sXml);
                                 var TotalCnt = ComGetTotalRows( sXml );
                                 if( eval(TotalCnt) > 0 ){
                                     var ttl_amt   = sheetObj.CellValue(sheetObj.RowCount+1, aryPrefix[0]+"ttl_amt");
                                     formObj.ttl_stl_amt.value = ComAddComma2(  ttl_amt+"","#,###.00"   );
 
                                 }
                                 fnLtrTitCtnt();
                                 break;
                                 
                         case    IBRESET:   
 
                                 var monthEng = ComJooDateForEng(yyyyMM);
                                 for(var i=0;i< formObj.ltr_tit_ctnt_mnth.length;i++ ){
                                     if ( formObj.ltr_tit_ctnt_mnth[i].value == monthEng){
                                         formObj.ltr_tit_ctnt_mnth[i].selected = true;
                                         break;
                                     }
                                 }                           
                                 var sYear= yyyyMM.substring(0,4);
                                 for(var i=0;i< formObj.ltr_tit_ctnt_year.length;i++ ){
                                     if ( formObj.ltr_tit_ctnt_year[i].value == sYear){
                                          formObj.ltr_tit_ctnt_year[i].selected = true;
                                          break;
                                     }                                     
                                 }
                                 formObj.jo_ltr_seq.value = "";
                                 formObj.jo_crr_cd.Code2 = '';                                
                                 formObj.trd_cd.RemoveAll();
                                 formObj.rlane_cd.RemoveAll();
                                 fnFormClear();
                                 fnBtnNew();   
                                 formObj.acct_yrmon.value = yyyyMM;     
                                 if( formObj.changeyn.value == "Y" ){
                                     formObj.changeyn.value = "";
                                 }
                                 ComEnableObject(formObj.send_type[0], true);
                                 ComEnableObject(formObj.send_type[1], true);
                                 break;     
                                 
                         case    IBSAVE:   
                                 fnLtrTitCtnt();//제목만들기 
                                 if( !validateForm(sheetObj,formObj,sAction) ){return;}
                                 
                                 sheetObj.WaitImageVisible=false;
                                 ComOpenWait(true);
                                 
                                 formObj.f_cmd.value = MULTI01;         
                                 var sParam     =  ComGetSaveString(sheetObj, true, true);
                                 var aryPrefix = new Array("sheet1_"  );
                                 sParam        +=  "&"+FormQueryString(formObj)+"&" + ComGetPrefixParam( aryPrefix );
  
                                 var sXml =   sheetObj.GetSaveXml("FNS_JOO_0060GS.do" ,   sParam  );
                                 sheetObj.LoadSaveXml( sXml );
                                 var TRANS_RESULT_KEY = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                                 if(TRANS_RESULT_KEY=="S"){
                                     var jo_ltr_no  = ComGetEtcData( sXml,"jo_ltr_no"); //
                                     var jo_ltr_seq = ComGetEtcData( sXml,"jo_ltr_seq");//JOO_LETTER PK
 
   
                                     if(jo_ltr_seq == "undefined"){
                                         jo_ltr_seq =  "";
                                         jo_ltr_no  =  "";
                                     }
                                     formObj.letter_no.value   = jo_ltr_no;
                                     formObj.jo_ltr_seq.value  = jo_ltr_seq;
                                     formObj.tmplparam.value  = "["+jo_ltr_seq+"]";
                                     if( formObj.changeyn.value == "Y" ){
                                         formObj.changeyn.value = "";
                                      }
                                 }
                                 ComOpenWait(false);
                                 break; 

                         case    MULTI02:  //Btn_Send
                                 if( !validateForm(sheetObj,formObj,sAction) ){return;}    
                                 sheetObj.WaitImageVisible=false;
                                 ComOpenWait(true);
                                 formObj.f_cmd.value = MULTI02;         
                                 var sParam     =  ComGetSaveString(sheetObj, true, true);
                                 var aryPrefix  =  new Array("sheet1_"  );
                                 sParam        +=  "&"+FormQueryString(formObj)+"&" + ComGetPrefixParam( aryPrefix );
                                  
                                 var sXml =   sheetObj.GetSaveXml("FNS_JOO_0060GS.do" ,   sParam  );
                                 sheetObj.LoadSaveXml( sXml );
                                 var TRANS_RESULT_KEY = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                                 if(TRANS_RESULT_KEY=="S"){
                                     /**
                                      * 전송된건이면 mail, fax radio Disable 처리한다.
                                      * 
                                      */
                                     ComEnableObject(formObj.send_type[0], false);
                                     ComEnableObject(formObj.send_type[1], false);
                                 }
                                 ComOpenWait(false);
                                 break;
                                 
                                 
                         case    MULTI03:  //Btn_Attach
                                 doUpload(document.getElementsByName("subSysCd"));
                                 break;        
 
                                 
                         case    IBSEARCH_ASYNC05: //0070에서 이동후 저장건 조회           
                                 sheetObj.WaitImageVisible=false;
                                 ComOpenWait(true); 
                         
                                 formObj.f_cmd.value = SEARCHLIST02;  
                                 var aryPrefix = new Array("sheet1_","sheet2_");
                                 var param =  FormQueryString(formObj)+"&" + ComGetPrefixParam( aryPrefix ) ;  
                                 var sXml  =  sheetObjects[  sheetObjects.length-1 ].GetSearchXml("FNS_JOO_0060GS.do", param,"", true);
                                 /**
                                  * aXml
                                  *   0 : Grid1 금액.
                                  *   1 : Letter To 내용 
                                  */
                                 var aXml  =  sXml.split("|$$|");
                                 /**
                                  * 순서 지킬것. 
                                  * 1.조회옵션 셋(Lane Code 제외 fnSetTmpltFor0070처리 Grid 항목 Lane 사용 )
                                  * 2.Grid 셋.
                                  * 3. To Multi Select 항목 Set
                                  * 4. Form Data Set
                                  * 5. 추가 조회옵션 셋(Lane Code).
                                  */
                                 /*** 1.조회옵션 셋.***/
                                 fnSetTmpltFor0070Search(aXml);
                                 /*** 2.Grid 셋.***/
                                 sheetObj.LoadSearchXml( aXml[0] );

                                 /*** 3. To Multi Select 항목 Set  ***/
                                 ComXml2ComboItem( aXml[1], formObj.ltr_rcvr_co_nm, "sheet2_cust_lgl_eng_nm","sheet2_cust_lgl_eng_nm" );   
                                 /*** 4. Form Data Set ***/
                                 fnSetTmpltFor0070(aXml );
 
                                 var TotalCnt = ComGetTotalRows( aXml[0] );
                                 if( eval(TotalCnt) > 0 ){
                                     var ttl_amt   = sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_ttl_amt");
                                     formObj.ttl_stl_amt.value = ComAddComma2(  ttl_amt+"","#,###.00"   );
                                 }
                                 /*** 5.조회옵션 셋.***/
                                 fnSetSearchLaneCode0070(aXml[0],sheetObjects[0], formObj);
                                 
                                 ComOpenWait(false);
                                 break;
                                 
                         case    IBSEARCH_ASYNC07:  
                                 formObj.f_cmd.value = SEARCHLIST01;   
                                 var jo_ltr_seq      = formObj.jo_ltr_seq.value;
 
                                 var param = '?f_cmd='+formObj.f_cmd.value+"&jo_ltr_seq="+jo_ltr_seq;
                                 ComOpenPopup('/hanjin/FNS_JOO_FILEVIEW.do'+param, 620, 480, "", "0,1,1,1,1,1",true);   
                                 break;        
                     }
         }
         /**
          * Carrier Code OnChange시 처리  <br>
          * <br><b>Example : </b>
          * <pre>
          *     Carrier Code(Object Name : trd_cd) OnChange 
          *                                이벤트 발생시 처리.  
          * </pre>
          * @param {인자Type} 콤보object 선택
          * @return void
          * @see #링크연결
          * @author jang kang cheol
          * @version 2009.07.01
          */
          function jo_crr_cd_OnChange(comboObj,value,text) {
              var formObj = document.form;
              
              formObj.trd_cd.RemoveAll();
              formObj.rlane_cd.RemoveAll();
 
              fnBtnNew();   
              fnFormClear();
 
          }
          /**
          * 설명영역. <br>
          * <br><b>Example : </b>
          * <pre>
          *     Trade Code(Object Name : trd_cd) OnChange 
          *                                이벤트 발생시 처리.  
          * </pre>
          * @param {인자Type} 콤보object 선택
          * @return void
          * @see #링크연결
          * @author jang kang cheol
          * @version 2009.07.01
          */
         function  trd_cd_OnFocus(comboObj) {
             var formObj = document.form;
             if(formObj.jo_crr_cd.Code == ""){return;}
             if (comboObj.GetCount()== 0) {
                comboObj.Enable = false;
                doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC02);
                comboObj.Enable = true;
             }
         }
         
        /**
         * 설명영역. <br>
         * <br><b>Example : </b>
         * <pre>
         *     Trade Code(Object Name : trd_cd) OnChange 
         *                                이벤트 발생시 처리.  
         * </pre>
         * @param {인자Type} 콤보object 선택
         * @return void
         * @see #링크연결
         * @author jang kang cheol
         * @version 2009.07.01
         */
         function trd_cd_OnChange(comboObj,value,text) {
             var formObj = document.form;
             formObj.jo_tmplt_no.Code2 = "";
             formObj.rlane_cd.RemoveAll();
             fnFormClear();
             fnBtnNew();  

         }   
         function  rlane_cd_OnFocus(comboObj) {
             var formObj = document.form;
             if(formObj.trd_cd.Code == ""){return;}
             if (comboObj.GetCount()== 0) {
                 comboObj.Enable = false;
                 doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC03);
                 comboObj.Enable = true;
             }
         }
         /**
         *  Text No ( Template )OnChange시 처리  <br>
         * <br><b>Example : </b>
         * <pre>
         *     Jo_Tmplt_No(Object Name : trd_cd) OnChange 
         *                                이벤트 발생시 처리.  
         * </pre>
         * @param {인자Type} 콤보object 선택
         * @return void
         * @see #링크연결
         * @author jang kang cheol
         * @version 2009.07.01
         */
         function jo_tmplt_no_OnChange(comboObj,value,text) {
             var formObj = document.form;
 
             formObj.jo_ltr_tmplt_seq.value = formObj.jo_tmplt_no.GetIndexText(formObj.jo_tmplt_no.Index, 1  );
             doActionIBSheet( sheetObjects[sheetObjects.length-1] , formObj, IBSEARCH_ASYNC04); 
         }          
        
      
         /**
         * 년월 NAVI 처리 이벤트 
         * @param void
         * @return void
         */
         function fnDocClick(){
             var obj = event.srcElement;
             var formObj = document.form;

             switch (obj.name){
                 case "ltr_tit_ctnt_mnth":
                      if( formObj.rlane_cd.Code == ""){
                         ComShowCodeMessage("JOO00115", "Lane Code");
                         event.returnValue = false;
                      }
                      
                      break;                     
                 case "ltr_tit_ctnt_year":
                      if( formObj.rlane_cd.Code == ""){
                         ComShowCodeMessage("JOO00115", "Lane Code");
                         event.returnValue = false;
                      }
                      break;
                 case "btn_acct_yrmon_back":
                     if (formObj.acct_yrmon.value != "" ){
                         formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);    
                     }
                     fnBtnNew();
                     fnFormClear(); 
                     formObj.jo_crr_cd.Code2     = '';
                     formObj.trd_cd.RemoveAll();
                     formObj.rlane_cd.RemoveAll();
                     formObj.jo_tmplt_no.Code2  = '';
                     break;
                case "btn_acct_yrmon_next":
                     if (formObj.acct_yrmon.value != "" ){
                        formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",+1).substring(0,7);    
                     }
                     fnBtnNew();
                     fnFormClear(); 
                     formObj.jo_crr_cd.Code2     = '';
                     formObj.trd_cd.RemoveAll();
                     formObj.rlane_cd.RemoveAll();
                     formObj.jo_tmplt_no.Code2  = '';               
                     break;
                case "btns_search01"://Attn 버튼.
                    if( formObj.jo_crr_cd.Code == "") {
                        ComShowCodeMessage('JOO00008');   
                        formObj.jo_crr_cd.focus();
                        return false;
                    }
                    var param = '?joCrrCd='+formObj.jo_crr_cd.Code;
                    ComOpenPopup('/hanjin/FNS_JOO_0073.do'+param, 600, 395, "setAttenCC", "0,1,1,1,1,1",false);                                         
                    break; 
             }
         }
         /**
          * 
          * <pre>
          *     0073호출하여 (팝업) 셋팅 처리 Callback Function
          * </pre>
          *
          * @param  
          * @return at1 : atten , at2 : attenEmail, cc : cc1, ccEmail :  cc2, fax : fax
          * @author Create by ham,  modify jang kang cheol
          */
         function setAttenCC(at1, at2, cc1, cc2, fax){
            // alert('at1____>'+at1+', at2___>'+at2+', cc1___>'+cc1+', cc2___>'+cc2+', fax___>'+fax);
             var formObj = document.form; 
             
            formObj.ltr_rcvr_cntc_pson_nm.value    = at1;
            formObj.rcvr_eml.value                 = at2;
            formObj.ltr_cc_rcvr_cntc_pson_nm_ctnt.value = cc1;
            formObj.cc_rcvr_eml_ctnt.value              = cc2;
            formObj.jo_cntc_fax_no_ctnt.value           = fax; 
 
            if( formObj.jo_ltr_seq.value != "" ){
                formObj.changeyn.value = "Y";
             }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }           
        /**
        * NEW 버튼 처리 
        * @param    void
        * @return   void
        */    
        function fnBtnNew(){
            var formObj = document.form;
        
            if( sheetObjects[0].RowCount > 0) {
                sheetObjects[0].RemoveAll();
            }
        }  

        /**
         * <pre>
         *    form Element의 KeyPress Event 발생시 처리.
         *    
         * </pre>
         * @return
         */ 
        function fnObjKeyPress(){
            var obj = event.srcElement;
            var formObj = document.form;
            var attr   = obj.getAttribute("dataformat");
            switch (attr){
                   case   'ym':
                          ComKeyOnlyNumber( obj );
                          break;
                          
                   case   'ymd':
                          ComKeyOnlyNumber( obj );
                          break;             
            }
            fnEnterCheck(obj);
        }
           /**
            * <pre>
            *     form element의 dataformat을 이용한 입력 Validate 처리,
            *     focus 잃었을때발생.
            * </pre>
            * 
            * @return void
            */ 
           function fnDeactivate(){ 
                var obj = event.srcElement;                
                var formObj = document.form;
                var attr   =  obj.getAttribute("dataformat");                
               switch(attr){
                   case 'ym':
                       ComAddSeparator(obj );
                       break;
                   case 'ymd':
                       ComAddSeparator(obj );
                       break; 
               }
           }
            /**
             * <pre>
             *     form element의 dataformat을 이용한 입력 Validate 처리,
             *     focus 얻었을때발생.
             * </pre>
             * 
             * @return void
             */ 
            function fnActivate(){
                switch(event.srcElement.name){
                    case 'acct_yrmon':
                        ComClearSeparator(event.srcElement);
                        break;
 
                    case 'ltr_iss_dt':
                        ComClearSeparator(event.srcElement);
                        break;                        
                        
                }
                event.srcElement.select();
            }        
           /**
            * 화면 폼입력값에 대한 유효성검증 프로세스 처리
            */
           function validateForm(sheetObj,formObj,sAction){
       
               with(formObj){
                   switch ( sAction ){
                        case IBSEARCH :
                            // if (!ComChkValid(formObj)) return false;
                             if (!fnValidCheck()) return false;                            
                             break;
                             
                        case IBSEARCH_ASYNC04 : 
                            //if (!ComChkValid(formObj)) return false;
                            if (!fnValidCheck()    ) return false; 
                            
                            break;
                            
                        case IBSAVE :
                            if (sheetObj.RowCount == 0 ){
                                ComShowCodeMessage('JOO00131');   
                                return false;   
                            }
                            if( ComGetLenByByte(formObj.n1st_stmt_ctnt)  > 4000 ){
                                ComShowCodeMessage('JOO00117', "Text Details Length(4000 Byte)");   
                                formObj.n1st_stmt_ctnt.select();
                                return false;   
                            }
                            if( ComGetLenByByte(formObj.n3rd_stmt_ctnt)  > 4000 ){
                                ComShowCodeMessage('JOO00117', "Text Details Length(4000 Byte)");   
                                formObj.n3rd_stmt_ctnt.select();
                                return false;   
                            }
 
                            if( formObj.ltr_rcvr_co_nm.Text == '' ){
                                ComShowCodeMessage('JOO00115', "Receive Co Name");   
                                formObj.ltr_rcvr_co_nm.focus();
                                return false;   
                            } 
                            if( formObj.keys.value == 'undefined' ){
                                formObj.keys.value = "";
                            }                            
                            if (!fnValidCheck()    ) return false;                               
                            if (!ComChkValid(formObj)) return false;
                            break;                            
                            
                        case MULTI02 ://SEND 
                            if( formObj.keys.value == 'undefined' ){
                                formObj.keys.value = "";
                            }                         
                            if (!fnValidCheck()) return false;
                            if ( formObj.send_type[0].checked ){//0 Email, 1:Fax
                                if( formObj.rcvr_eml.value == ""){
                                    ComShowCodeMessage('JOO00116', "Attn E-mail");  
                                    return false;
                                }
                            }else{
                                if( formObj.jo_cntc_fax_no_ctnt.value == ""){
                                    ComShowCodeMessage('JOO00116', "Fax No.");  
                                    return false;
                                }
                            }
                            if ( formObj.letter_no.value == "" || formObj.changeyn.value == "Y"){
                                ComShowCodeMessage('JOO00118');   
                                return false;        
                            }        
  
                            break;                            
                   }
               }

               return true;
           }
       function fnValidCheck(){
           var formObj = document.form;
           if( formObj.jo_crr_cd.Code == "") {
               ComShowCodeMessage('JOO00008');   
               formObj.jo_crr_cd.focus();
               return false;
           }
           if( formObj.trd_cd.Code == "") {
               ComShowCodeMessage('JOO00009');   
               formObj.trd_cd.focus();
               return false;
           }  
           if( formObj.rlane_cd.Code == "") {
               ComShowCodeMessage('JOO00010');   
               formObj.rlane_cd.focus();
               return false;
           }     
           if( formObj.ofc_cd.Code == "") {
               ComShowCodeMessage('JOO00112');   
               formObj.ofc_cd.focus();
               return false;
           }                   
           
           return true;
       }
       function fnOnKeyDown(){
           var searchNm =  "acct_yrmon,jo_crr_cd,trd_cd,rlane_cd,jo_tmplt_no";
           var nextNm   =  "";           
           var evNm     = event.srcElement.name;
 
           if( event.srcElement.type == "textarea" ){
 
               return;
           }
           if( searchNm.indexOf(evNm) > -1  ){
               ComKeyEnter();    
           }else  {
               ComKeyEnter('nextfocus');    
           }           
       }
       /**
        * 
        * <pre>
        *    FormObject OnChange 이벤트 처리 
        * </pre>
        *
        * @author jang kang cheol
        */
       function fnObjChange(){//ltr_rcvr_co_nm
           var elementsName = "ltr_iss_dt,n1st_stmt_ctnt,n2st_stmt_ctnt,n3rd_stmt_ctnt,ltr_tit_ctnt_year,ltr_tit_ctnt_mnth";
           var formObj = document.form;
 
           switch(event.srcElement.name){
               case 'ltr_tit_ctnt_mnth':
                     fnLtrTitCtntForChange();
                     break;
                     
               case 'ltr_tit_ctnt_year':
                     fnLtrTitCtntForChange();
                     break;                 
           }
           if(  elementsName.indexOf(event.srcElement.name) >-1 ){
               if( formObj.jo_ltr_seq.value != "" ){
                   formObj.changeyn.value = "Y";
               }
           }
       }
       
       /**
        * 
        * <pre>
        *     Template 데이타를 Form Element에 Setting 한다.
        * </pre>
        *
        * @param  
        * @return at1 : atten , at2 : attenEmail, cc : cc1, ccEmail :  cc2, fax : fax
        * @author Create by ham,  modify jang kang cheol
        */       
       function fnSetTmplt( sXml ){
           var formObj = document.form;
           var prefix  = "";           

           ComSetObjValue(formObj.ofc_addr,           ComJooGetRowValue(sXml, 1, prefix+"ofc_addr"      )  );
           ComSetObjValue(formObj.ltr_iss_dt,         curYYYYMM  );      
           ComSetObjValue(formObj.n1st_stmt_ctnt,     ComJooGetRowValue(sXml, 1, prefix+"n1st_stmt_ctnt")  ); 
           ComSetObjValue(formObj.n2nd_stmt_ctnt,     ComJooGetRowValue(sXml, 1, prefix+"n2nd_stmt_ctnt")  );        
           ComSetObjValue(formObj.n3rd_stmt_ctnt,     ComJooGetRowValue(sXml, 1, prefix+"n3rd_stmt_ctnt")  );      
           ComSetObjValue(formObj.sig_stmt_ctnt ,     ComJooGetRowValue(sXml, 1, prefix+"sig_stmt_ctnt" )  );
           
           ComSetObjValue(formObj.ltr_sndr_co_nm ,    "HANJIN SHIPPING CO.,LTD. / "+strOfc_eng_nm );//FM
           
           var  ltr_tit_ctnt_mnth = ComJooDateForEng( formObj.acct_yrmon.value );
           var  ltr_tit_ctnt_year =  formObj.acct_yrmon.value.substring(0,4);
           ComSetObjValue(formObj.ltr_tit_ctnt_mnth, ltr_tit_ctnt_mnth       );            
           ComSetObjValue(formObj.ltr_tit_ctnt_year, ltr_tit_ctnt_year       ); 
                      
           fnLtrTitCtnt();
       }
        /**
         * 
         * <pre>
         *   0070에서 Called 된 조회옵션 셋팅. 
         * </pre>
         *
         * @param  aXml : Xml 배열   
         * @return void
         * @author jang kang cheol
         */
        function fnSetTmpltFor0070Search(aXml){
            var formObj = document.form;
            var prefix  = "sheet1_";    
            var sXml    = aXml[0];
            var sXml2   = aXml[1];

 
            ComSetObjValue(formObj.acct_yrmon              , ComGetEtcData(sXml, "acct_yrmon")  );//조회 trd_cd
            ComSetObjValue(formObj.jo_crr_cd               , ComGetEtcData(sXml, "jo_crr_cd")  );//조회 Carrier Code
 
            /*** TrdCode를 가져온다.  ***/
            doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC02);
            ComSetObjValue(formObj.trd_cd                  , ComGetEtcData(sXml, "trd_cd")  );//조회 trd_cd
            doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC03);
            
            ComAddSeparator(formObj.acct_yrmon);//조회 ACCT_YEAR
            formObj.jo_tmplt_no.code2 = ComGetEtcData(sXml, "jo_tmplt_no") ;//조회  Text No.
            
            if( ComGetEtcData(sXml, "eml_snd_no") != "" ){
                ComSetObjValue(formObj.send_type   , "MAIL"  );//Letter No.
            }
            if( ComGetEtcData(sXml, "fax_snd_no") != "" ){
                ComSetObjValue(formObj.send_type   , "FAX"  );//Letter No.
            } 
            var ltr_tit_ctnt = ComGetEtcData(sXml, "ltr_tit_ctnt");
 
            var  tail_ltr_tit_ctnt = ltr_tit_ctnt.substring( ltr_tit_ctnt.indexOf(" on ") );
 
            formObj.tail_ltr_tit_ctnt.value = tail_ltr_tit_ctnt;
            
 
        }
        /**
         * 
         * <pre>
         *       조회옵션 Combined Seq 셋.
         * </pre>
         *
         * @param  sXml, sheetObj, formObj
         * @author jang kang cheol
         */
        function fnSetSearchLaneCode0070(sXml, sheetObj, formObj){
 
            /**
            * 조회옵션은 (fnSetTmpltFor0070Search)에서 처리하나,
            * Combined Seq 만 제외
            * 조회했던  Combined Seq Code Setting
            */
           var TotalCnt = ComGetTotalRows( sXml );

           var rlane_cd = "";
            
           for(var i=sheetObj.HeaderRows; i<= eval(TotalCnt);i++){
               rlane_cd +=   ComJooGetRowValue(sXml, i, "sheet1_rlane_cd")+"|";
           }
           formObj.rlane_cd.Code2 = rlane_cd;//조회 trd_cd   
        }        
        /**
         * 
         * <pre>
         *     Template 데이타를 Form Element에 Setting 한다.
         * </pre>
         *
         * @param  aXml : Xml 배열 
         * @return at1 : atten , at2 : attenEmail, cc : cc1, ccEmail :  cc2, fax : fax
         * @author Create by ham,  modify jang kang cheol
         */       
        function fnSetTmpltFor0070( aXml ){
            var formObj = document.form;
            var prefix  = "sheet1_";    
            var sXml    = aXml[0];
            var sXml2   = aXml[1];
            
            ComSetObjValue(formObj.ofc_addr,              ComJooGetRowValue(sXml, 1, prefix+"ofc_addr" ));
            ComSetObjValue(formObj.n1st_stmt_ctnt,        ComGetEtcData(sXml, "n1st_stmt_ctnt"         ));
            ComSetObjValue(formObj.n2nd_stmt_ctnt,        ComGetEtcData(sXml, "n2nd_stmt_ctnt"         ));
            ComSetObjValue(formObj.n3rd_stmt_ctnt,        ComGetEtcData(sXml, "n3rd_stmt_ctnt"         ));
            ComSetObjValue(formObj.sig_stmt_ctnt ,        ComGetEtcData(sXml, "sig_stmt_ctnt"          ));            
            ComSetObjValue(formObj.ltr_sndr_co_nm ,       "HANJIN SHIPPING CO.,LTD. / "+strOfc_eng_nm );//FM
            ComSetObjValue(formObj.ltr_iss_dt ,           ComGetEtcData(sXml, "ltr_iss_dt")  );       
            
            ComSetObjValue(formObj.ltr_rcvr_cntc_pson_nm   , ComGetEtcData(sXml, "ltr_rcvr_cntc_pson_nm")  ); //Attn            
            ComSetObjValue(formObj.ltr_cc_rcvr_cntc_pson_nm_ctnt, ComGetEtcData(sXml, "ltr_cc_rcvr_cntc_pson_nm_ctnt")  );//cc
            ComSetObjValue(formObj.ltr_sndr_co_nm          , ComGetEtcData(sXml, "ltr_sndr_co_nm")  );//FM
            ComSetObjValue(formObj.jo_cntc_fax_no_ctnt          , ComGetEtcData(sXml, "jo_cntc_fax_no_ctnt")  );//Fax No.
            ComSetObjValue(formObj.rcvr_eml                , ComGetEtcData(sXml, "rcvr_eml")  );//Attn E-mail
            ComSetObjValue(formObj.cc_rcvr_eml_ctnt             , ComGetEtcData(sXml, "cc_rcvr_eml_ctnt")  );//CC E-mail
            ComSetObjValue(formObj.letter_no               , ComGetEtcData(sXml, "jo_ltr_no")  );//Letter No.
            ComSetObjValue(formObj.attach_yn               , ComGetEtcData(sXml, "attach_yn")  );//Attach 첨부 여부 Y 존재.
            ComSetObjValue(formObj.jo_ltr_tmplt_seq        , ComGetEtcData(sXml, "jo_ltr_tmplt_seq")  );

            ComSetObjValue(formObj.fax_snd_no        , ComGetEtcData(sXml, "fax_snd_no")  );
            ComSetObjValue(formObj.eml_snd_no        , ComGetEtcData(sXml, "eml_snd_no")  );
            ComSetObjValue(formObj.eml_snd_no        , ComGetEtcData(sXml, "eml_snd_no")  );
 
            formObj.ltr_rcvr_co_nm.Text2  = ComGetEtcData(sXml, "ltr_rcvr_co_nm");
            /**
             * 전송된건이면 mail, fax radio Disable 처리한다.
             * 
             */
            if( formObj.eml_snd_no.value != "" || formObj.fax_snd_no.value != "" ){
                ComEnableObject(formObj.send_type[0], false);
                ComEnableObject(formObj.send_type[1], false);
            }

            
            /******  RE -> Letter 처리. ******/
            fnLtrTitCtntFor0070(sXml);//ltr_tit_ctnt
        }
         /**
          * 
          * <pre>
          *   0070에서 Call시, RE  Set 처리 제목 
          * </pre>
          *
          * @param   
          * @return
          * @author jang kang cheol
          */
         function fnLtrTitCtntFor0070(sXml){
             var formObj = document.form;
             formObj.head_ltr_tit_ctnt.value = gHead_ltr_tit_ctnt;//제목 HEAD 처리.
             var ltr_tit_ctnt = ComGetEtcData(sXml, "ltr_tit_ctnt"); 
             /*************************************************
              * 날짜 처리 월, 년 
              *************************************************/
             var yearMon = ltr_tit_ctnt.substring( gHead_ltr_tit_ctnt.length, ltr_tit_ctnt.indexOf(" on ") );
             yearMon = yearMon.trim();
             var arrYearMon = yearMon.split(" ");//0:Mon, 1 Year
             /*    월 처리           */ 
             for(var i=0;i< formObj.ltr_tit_ctnt_mnth.length;i++){
                  if( formObj.ltr_tit_ctnt_mnth[i].value == arrYearMon[0]){
                      formObj.ltr_tit_ctnt_mnth[i].selected = true;
                      break;
                  }
             }
             /*   년   처리           */ 
             for(var i=0;i< formObj.ltr_tit_ctnt_year.length;i++){
                 if( formObj.ltr_tit_ctnt_year[i].value == arrYearMon[1]){
                     formObj.ltr_tit_ctnt_year[i].selected = true;
                     break;
                 }
            }
             var  tail_ltr_tit_ctnt = ltr_tit_ctnt.substring( ltr_tit_ctnt.indexOf(" on ") );
             formObj.tail_ltr_tit_ctnt.value = tail_ltr_tit_ctnt;
             
             //fnLtrTitCtnt();//제목만들기
         }
       /**
        * 
        * <pre>
        *    RE 값 Set 처리 
        * </pre>
        *
        * @param   
        * @return
        * @author jang kang cheol
        */
       function fnLtrTitCtnt() {
           var  formObj = document.form;
           var  ltr_tit_ctntnm    = "";           
           //  head_ltr_tit_ctnt = "Monthly Clearance for ";

           
           var  tail_ltr_tit_ctnt =  " on "+formObj.rlane_cd.Text.replaceStr("|","/")+" Service";    
 
           ComSetObjValue(formObj.head_ltr_tit_ctnt, gHead_ltr_tit_ctnt      ); 
              

           ltr_tit_ctntnm = formObj.head_ltr_tit_ctnt.value+formObj.ltr_tit_ctnt_mnth.value+" "+formObj.ltr_tit_ctnt_year.value
                            +formObj.tail_ltr_tit_ctnt.value;
           
           ComSetObjValue(formObj.ltr_tit_ctnt, ltr_tit_ctntnm    );//RE
           
           var rlane_cds = "";
           for(var i=sheetObjects[0].HeaderRows;i<=sheetObjects[0].RowCount ;i++){
               if(i<sheetObjects[0].RowCount){
                   rlane_cds  += sheetObjects[0].CellValue(i, "sheet1_rlane_cd")+"/";    
               }else{
                   rlane_cds  += sheetObjects[0].CellValue(i, "sheet1_rlane_cd");
               }
           }
           if(rlane_cds != ""){
               tail_ltr_tit_ctnt =  " on "+rlane_cds+" Service";  
           }
           
           ComSetObjValue(formObj.tail_ltr_tit_ctnt, tail_ltr_tit_ctnt       );         
            
               
       }
        /**
         * 
         * <pre>
         *    RE 값 Set 처리 
         * </pre>
         *
         * @param   
         * @return
         * @author jang kang cheol
         */
        function fnLtrTitCtntForChange() {
            var  formObj = document.form;
            var  monthAbbreviations = new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");            
            var  ltr_tit_ctntnm    = "";           
            var  head_ltr_tit_ctnt = "Monthly Clearance for ";
            var  monthnum = "";
            
            if( formObj.rlane_cd.Code == ""){
                ComShowCodeMessage("JOO00115", "Lane Code");
                return;
            }
            
            for(var i=0;i<monthAbbreviations.length;i++){
                if( formObj.ltr_tit_ctnt_mnth.value == monthAbbreviations[i] ){
                    monthnum = (i+"").lpad(2,'0');
                }
            }
            var  ltr_tit_ctnt_mnth = ComJooDateForEng( formObj.ltr_tit_ctnt_year.value +"-"+monthnum );
            
            
            var  ltr_tit_ctnt_year =  formObj.ltr_tit_ctnt_year.value;
            var  tail_ltr_tit_ctnt =  " on "+formObj.rlane_cd.Text.replaceStr("|","/")+" Service";    
  
            ComSetObjValue(formObj.head_ltr_tit_ctnt, head_ltr_tit_ctnt    );            
            ComSetObjValue(formObj.tail_ltr_tit_ctnt, tail_ltr_tit_ctnt       );         
            
            ltr_tit_ctntnm = formObj.head_ltr_tit_ctnt.value+formObj.ltr_tit_ctnt_mnth.value+" "+formObj.ltr_tit_ctnt_year.value
                             +formObj.tail_ltr_tit_ctnt.value;
            
            ComSetObjValue(formObj.ltr_tit_ctnt, ltr_tit_ctntnm    );//RE           
        }        
         /**
          * 
          * <pre>
          *    Form Clear 처리 
          * </pre>
          *
          * @param   
          * @return
          * @author jang kang cheol
          */
         function fnFormClear(){
             var formObj = document.form; 
             //ComClearObject(formObj.usr_id);
             formObj.jo_tmplt_no.Code2 = '';
            // ComClearObject(formObj.usr_id);
             ComSetObjValue(formObj.send_type, "MAIL");
             
             ComSetObjValue(formObj.send_type, "MAIL");
             
             formObj.ofc_addr.value = "";
             ComSetObjValue(formObj.ltr_iss_dt, curYYYYMM);
             formObj.ltr_rcvr_co_nm.RemoveAll();
             ComClearObject(formObj.letter_no);
             ComClearObject(formObj.ltr_rcvr_cntc_pson_nm);
             ComClearObject(formObj.ltr_cc_rcvr_cntc_pson_nm_ctnt);
             ComClearObject(formObj.ltr_sndr_co_nm);
             ComClearObject(formObj.ltr_tit_ctnt);
             ComClearObject(formObj.head_ltr_tit_ctnt);
             ComClearObject(formObj.ltr_tit_ctnt_mnth);
             ComClearObject(formObj.ltr_tit_ctnt_year);
             
             ComClearObject(formObj.tail_ltr_tit_ctnt);
             
             
             ComClearObject(formObj.ttl_stl_amt);
             
             
             ComClearObject(formObj.jo_cntc_fax_no_ctnt   );
             ComClearObject(formObj.rcvr_eml         );
             ComClearObject(formObj.cc_rcvr_eml_ctnt      );
             
             formObj.n1st_stmt_ctnt.value = "";
             formObj.n2nd_stmt_ctnt.value = "";
             formObj.n3rd_stmt_ctnt.value = "";
             formObj.sig_stmt_ctnt.value = "";            
             
         }         
       /**
        *  2009-03을,  Mar. 2009 
        * @param yyyyMM
        * @param str
        * @return value   
        * @author jkc
        */
       function ComJooDateForEng( yyyyMM){
           var monthAbbreviations = new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
           var idx    = eval( yyyyMM.substring(yyyyMM.indexOf("-")+1)  ) -1;
           var yyyy   = yyyyMM.substring(0,4);
           return monthAbbreviations [ idx ];
       }
       function rlane_cd_OnBlur(){
           var formObj = document.form;
           formObj.jo_tmplt_no.focus();
       }
              
       function doUpload(subSysCd){
           var returnValue = openUpload("JOO");
           if( returnValue == ""){
               return;
           }
           document.form.keys.innerText = returnValue;
           var formObj = document.all;
           if( formObj.jo_ltr_seq.value != "" ){
               formObj.changeyn.value = "Y";
            }
 
       }
       function sheet1_OnChange(Row,Col,Value){
           var formObj = document.all;
           if( formObj.jo_ltr_seq.value != "" ){
               formObj.changeyn.value = "Y";
            }
       }
       /* 개발자 작업  끝 */