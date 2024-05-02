/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0015.js
*@FileTitle : Monthly Clearance Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.11 장강철
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
     * @class FNS_JOO_0015 : FNS_JOO_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0015() {
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
 var queryStr = "";
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      
      var sheetObject1 = sheetObjects[0];
      
      /*******************************************************/
      var formObject = document.form;
 
     //try {
         var srcName = window.event.srcElement.getAttribute("name");
         switch(srcName) {
             case "btn_retrieve":
                 doActionIBSheet(sheetObjects[0],formObject,IBSEARCH); 
                 break;
             
             case "btn_new":
                 doActionIBSheet(sheetObjects[0],formObject,IBRESET);  
                 break;

             case "btn_Down_Excel":
                 var paramObj = new Object();
                 paramObj.cols= "15";
                 var title = "";
                 paramObj.align ="left";
                 paramObj.title = "Account Month : "+formObject.acct_yrmon.value+"     Carrier : "+formObject.jo_crr_cd.Code+"     Combined No : "+formObject.stl_cmb_seq.Code;
                 var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
 
                 sheetObjects[0].Down2Excel(-1, false,false, true, "", url);   
                 
                 break;

             case "btn_print":
                 rdOpen( document.form);
                 break;

         } // end switch
//     }catch(e) {
//         if( e == "[object Error]") {
//             ComShowMessage(OBJECT_ERROR);
//         } else {
//             ComShowMessage(e);
//         }
//     }
 }
 /**
  * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  * @param {ibsheet} sheetObj    IBSheet Object
  * @param {int}     sheetNo     sheetObjects 배열에서 순번
  **/
 function initControl() {

     var formObject = document.form;
     axon_event.addListener    ('keydown', 'ComKeyEnter', 'form');
     axon_event.addListener    ('click',   'fnDocClick', "btn_back"  );         
     axon_event.addListener    ('click',   'fnDocClick', "btn_next"  );  
     
     axon_event.addListenerForm    ('keypress',   'fnObjKeyPress', formObject );     
     axon_event.addListenerForm    ('click' ,     'fnObjClick'  , formObject );            
     
     axon_event.addListenerFormat('beforedeactivate', 'fn_deactivate',  formObject);  
     axon_event.addListenerFormat('beforeactivate'  , 'fn_activate'  ,  formObject);  

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
     doActionIBSheet(sheetObjects[sheetObjects.length - 1 ],document.form, SEARCH01);
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
          case "stl_cmb_seq": 
              with (comboObj) { 
                   MultiSelect = false; 
                   UseAutoComplete = true;    
                   SetColAlign("left");        
                   SetColWidth("60");
                   DropHeight = 160;
                   ValidChar(2,1);
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
 
             case 1: //t1sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 400;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;
     
                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     
                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msPrevColumnMerge + msHeaderOnly;//msAll;
          
                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;
     
                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 3, 100);
     
                 var HeadTitle  = "STS|Item|Lane|Cur.|SML|SML|SML|SML|Partner|Partner|Partner|Partner|Remark|Item";
                 var HeadTitle1 = "STS|Item|Lane|Cur.|VVD|BSA|Price|Amount|VVD|BSA|Price|Amount|Remark|Item";
                 var headCount = ComCountHeadTitle(HeadTitle);
     
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);
     
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false, false);
     
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle , true);
                 InitHeadRow(1, HeadTitle1, true);
 
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus ,  0, daCenter,  true,  "ibflag"); //JO_STL_ITM_CD_NM
                 InitDataProperty(0, cnt++ , dtData         ,160, daLeftTop, true,   "jo_stl_itm_cd_nm",  false,"",dfNone);
                 InitDataProperty(0, cnt++ , dtData         , 60, daCenter,  true,   "rlane_cd"        ,  false,"",dfNone);
 
                 InitDataProperty(0, cnt++ , dtData         , 35, daCenter,  true,   "locl_curr_cd"    ,  false,"",dfNone);
                 InitDataProperty(0, cnt++ , dtData         , 80, daLeft  ,  false,  "r_vvd"           ,  false,"",dfNone);
                 InitDataProperty(0, cnt++ , dtData         , 50, daRight ,  false,  "r_bsa_qty"       ,  false,"",dfNullInteger);
                 InitDataProperty(0, cnt++ , dtData         , 70, daRight ,  false,  "r_bsa_slt_prc"   ,  false,"",dfNullFloat  ,2);
                 InitDataProperty(0, cnt++ , dtAutoSum      ,100, daRight ,  false,  "r_stl_locl_amt"  ,  false,"",dfNullFloat  ,2);
                 InitDataProperty(0, cnt++ , dtData         , 80, daLeft  ,  false,  "e_vvd"           ,  false,"",dfNone);
                 InitDataProperty(0, cnt++ , dtData         , 50, daRight ,  false,  "e_bsa_qty"       ,  false,"",dfNullInteger);
                 InitDataProperty(0, cnt++ , dtData         , 70, daRight ,  false,  "e_bsa_slt_prc"   ,  false,"",dfNullFloat  ,2);
                 InitDataProperty(0, cnt++ , dtAutoSum      , 90, daRight ,  false,  "e_stl_locl_amt"  ,  false,"",dfNullFloat  ,2);
                 InitDataProperty(0, cnt++ , dtData         ,100, daCenter,  true,   "remark"          ,  false,"",dfNone);
                 InitDataProperty(0, cnt++ , dtHidden       ,160, daLeftTop, true,   "jo_stl_itm_cd"   ,  false,"",dfNone);
                 
               //  sheetObjects[0].SetMergeCell(0, 2, 2, 1); 
               //  sheetObjects[0].SetMergeCell(0, 3, 2, 1);
               //  sheetObjects[0].SetMergeCell(0, 4, 2, 1);
             }
             break;
         }
     }

      // Sheet관련 프로세스 처리
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg = false;
  
          switch(sAction) {
               case SEARCH01:      //초기화  
                    formObj.f_cmd.value = SEARCH01;            
                    var param =  FormQueryString(formObj);
                    var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0015GS.do", param);
                    ComXml2ComboItem( sXml, formObj.jo_crr_cd, "code","code" );//Carrier Code
                    break;      
                    
               case IBSEARCH_ASYNC01:      //stl_cmb_seq Combo List
                   formObj.f_cmd.value = SEARCH02;            
                   var super_cd1       = formObj.jo_crr_cd.Text;
                   var param           = FormQueryString(formObj);
                   var sXml            = sheetObj.GetSearchXml("FNS_JOO_0015GS.do", param);
                   ComXml2ComboItem( sXml, formObj.stl_cmb_seq, "stl_cmb_seq","stl_cmb_seq" );
                   break;
                  
                   
               case IBSEARCH:      //조회
                    if( !validateForm(sheetObj,formObj,sAction) ){return;}
                    formObj.f_cmd.value = SEARCHLIST01;            
                    var param =  FormQueryString(formObj);  
                    sheetObj.DoSearch("FNS_JOO_0015GS.do", param);
                    sheetObj.ShowSubSum("jo_stl_itm_cd_nm", "r_stl_locl_amt|e_stl_locl_amt" );                    
                    
                    formObj.bal_jo_crr_cd.value = formObj.jo_crr_cd.Code;
                    fnSetBalance(sheetObj);
                    
                    break;
 
               case IBRESET:      //NEW 버튼  
                   fnBtnNew();
                   break;                  
          }
      }
      
      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리
       */
      function validateForm(sheetObj,formObj,sAction){
          with(formObj){
              switch ( sAction ) {
                  case IBSEARCH:
                      if (formObj.acct_yrmon.value.length == 0){
                          ComShowCodeMessage('JOO00033');
                          formObj.acct_yrmon.focus();
                          return false;
                      }
                      if (formObj.jo_crr_cd.index == -1){
                          ComShowCodeMessage('JOO00008');
                          formObj.jo_crr_cd.focus();
                          return false;
                      }
                      if (formObj.stl_cmb_seq.Code == "" ){
                          ComShowCodeMessage('JOO00092');
                          formObj.stl_cmb_seq.focus();
                          return false;
                      }
                    
                      break;
              }
          }
          return true;
      }

     /************************************** Object EVENT FUNCTION ********************************************************/
  
      /**
       * 
       * <pre>
       *      Lane Code Grid 상태확인중 변경없으면 Sheet2 클리어.
       * </pre>
       *
       * @param   
       * @return
       * @author jang kang cheol
       */
      function sheet1_OnChange(comboObj, Row, Col,Value) {
           var formObj = document.form;
           
           doActionIBSheet(sheetObjects[1],formObj,SEARCHLIST02);
           if( sheetObjects[0].RowCount("U") == 0 ){
               if( sheetObjects[1].RowCount  > 0) {
                   sheetObjects[1].RemoveAll();
               } 
           }
     }    
      /**
      * Carrier Code 콤보 OnChange 이벤트 처리.
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
     function jo_crr_cd_OnChange(comboObj,value,text) {
         var formObj = document.form;
 
         if( formObj.jo_crr_cd.Code != ""){
            formObj.stl_cmb_seq.RemoveAll();
            fnGridClear();            
         }
     }
     function stl_cmb_seq_OnChange(comboObj,value,text) {
         var formObj = document.form;
         
         if( formObj.stl_cmb_seq.Code != ""){
            fnGridClear();            
         }
     }
      function stl_cmb_seq_OnFocus(comboObj,value,text) {
          var formObj = document.form;
          if (comboObj.GetCount()== 0) {
              comboObj.Enable = false;
              doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC01); 
              comboObj.Enable = true;
          } 
      }
  
 
     /**************************************USER FUNCTION *****************************************************/
     /**
      * NEW 버튼 처리 
      * @param    void
      * @return   void
      */    
      function fnBtnNew(){
          var formObj = document.form;
          formObj.jo_crr_cd.Text2  = "";
          formObj.stl_cmb_seq.RemoveAll();
          formObj.acct_yrmon.value  = yyyyMM;
 

          fnGridClear();       
      }
      /**
       * 
       * <pre>
       *    Grid Clear
       * </pre>
       *
       * @param   void
       * @return  void
       * @author jang kang cheol
       */
      function fnGridClear(){
           var formObj = document.form;
          if( sheetObjects[0].RowCount  > 0) {
              sheetObjects[0].RemoveAll();
          }
          if( sheetObjects[1].RowCount  > 0) {
              sheetObjects[1].RemoveAll();
          }  
          formObj.balance.value = "";
          formObj.bal_jo_crr_cd.value = "";
      }
      /**
       * <pre>
       *     form element의 dataformat을 이용한 입력 Validate 처리,
       *     focus 잃었을때발생.
       * </pre>
       * 
       * @return void
       */ 
      function fn_deactivate(){
          switch(event.srcElement.name){
              case 'acct_yrmon':
                  ComAddSeparator(event.srcElement);
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
       function fn_activate(){
           switch(event.srcElement.name){
               case 'acct_yrmon':
                   ComClearSeparator(event.srcElement);                  
                   break;
           }
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
               case "btn_next":
                    if (formObj.acct_yrmon.value != "" ){
                        formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",+1).substring(0,7);    
                        formObj.jo_crr_cd.Code2="";
                        formObj.stl_cmb_seq.RemoveAll();
                    }
                    fnGridClear();                
                    if( formObj.jo_crr_cd.Code == "" ){
                        formObj.jo_crr_cd.focus();
                    }
                    break;
               case "btn_back":
                    if (formObj.acct_yrmon.value != "" ){
                       formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);    
                    }
                    formObj.jo_crr_cd.Code2="";
                    formObj.stl_cmb_seq.RemoveAll();
                    fnGridClear();                   
                    if( formObj.jo_crr_cd.Code == "" ){
                        formObj.jo_crr_cd.focus();
                    }
                    break;                 
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
           switch (obj.name){
                  case 'acct_yrmon':
                      ComKeyOnlyNumber( obj );
                      
                      formObj.jo_crr_cd.Code2="";
                      formObj.stl_cmb_seq.RemoveAll();
                      break;
           }
       }
       /**
        * <pre>
        *    form Element의  Click Event 발생시 처리.
        *    
        * </pre>
        * @return
        */
       function fnObjClick(){
           var obj = event.srcElement;
           var formObj = document.form;
           switch (obj.name){
                  case 're_divr_cd':
                      fnGridClear();
                      break;
           }
       }
        /**
         * 
         * <pre>
         *    Carrier 별 Balane
         * </pre>
         *
         * @param   sheetObj
         * @return void
         * @author jang kang cheol
         */
       function fnSetBalance(sheetObj){
            var formObj = document.form;
            formObj.balance.value = "";
            var e_stl_locl_amt     = 0; 
            var r_stl_locl_amt     = 0; 
            var bal_amt            = 0; 
            var balCarrier =       "SML";
            if( sheetObj.RowCount > 0){
                e_stl_locl_amt     = sheetObj.CellValue(sheetObj.LastRow, "e_stl_locl_amt");
                r_stl_locl_amt     = sheetObj.CellValue(sheetObj.LastRow, "r_stl_locl_amt");
                bal_amt            = eval(r_stl_locl_amt) - eval(e_stl_locl_amt);
 
                if ( eval(r_stl_locl_amt) < eval(e_stl_locl_amt) ){
                    balCarrier = formObj.jo_crr_cd.Code;                    
                }
                bal_amt = Math.abs( bal_amt );
            }
 
            formObj.balance.value = bal_amt.toFixed(2);
            formObj.bal_jo_crr_cd.value = balCarrier;
            ComAddSeparator(formObj.balance,"float");
 
            if( formObj.balance.value.indexOf(".") == -1 ){
                formObj.balance.value += ".00";  
            }
       }
         
         function rdOpen( formObj){
             var formObj = document.form;
         
             queryStr="";
             if( !setQueryStr() ){
                 return;
             } 
             var rdParam   =  '/rp '+queryStr;
             var strPath   =  "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_0071.mrd"; 
             formObj.com_mrdPath.value      = strPath;
             formObj.com_mrdArguments.value = rdParam;
             ComOpenRDPopup();
         
         }
         function setQueryStr(){

             var formObj = document.form;         
             queryStr += " ["+formObj.acct_yrmon.value+"]";
             queryStr += " ["+formObj.jo_crr_cd.Code  +"]";
             if( formObj.stl_cmb_seq.Code == ""){
                 ComShowCodeMessage("JOO00092");
                 return false;         
             }else{
                 queryStr += " ["+formObj.stl_cmb_seq.Code+"]";//5  COMB
             }
             var bal_jo_crr_cd = formObj.bal_jo_crr_cd.value;
             queryStr += " ["+bal_jo_crr_cd+"]";           
      
             return true;
         }
         

         /**
          * 셀을 마우스 더블클릭했을때 발생하는 이벤트 <br>
          */

         function sheet1_OnDblClick(sheetObj, Row, Col ){
         	
         	var formObj = document.form;
            var value  = sheetObj.CellValue(Row,Col);

             if(value == ""){return;}
             
             if( sheetObj.ColSaveName(Col) == "remark"){
             	var acct_yrmon    = formObj.acct_yrmon.value;
             	var jo_crr_cd     = formObj.jo_crr_cd.Code;
             	var r_vvd         = sheetObj.CellValue(Row, "r_vvd");
             	var e_vvd         = sheetObj.CellValue(Row, "e_vvd");
             	var rlane_cd      = sheetObj.CellValue(Row, "rlane_cd")
             	var jo_stl_itm_cd = sheetObj.CellValue(Row, "jo_stl_itm_cd")
             	
             	var paramUrl = "pgmNo=FNS_JOO_0102&acct_yrmon="+acct_yrmon+"&jo_crr_cd="+jo_crr_cd+"&r_vvd="+r_vvd+"&e_vvd="+e_vvd+"&rlane_cd="+rlane_cd+"&jo_stl_itm_cd="+jo_stl_itm_cd;
             			
             	ComOpenPopup("/hanjin/FNS_JOO_0102.do?"+paramUrl, 400, 360,"", "1,0,1,1,1,1,1,1", true);
             }
         }
	/* 개발자 작업  끝 */