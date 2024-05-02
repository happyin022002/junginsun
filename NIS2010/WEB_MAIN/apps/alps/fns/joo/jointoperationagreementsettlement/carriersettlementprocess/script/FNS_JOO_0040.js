/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0040.js
*@FileTitle : Slot Exchange Status by Lane &amp; Partner->Space Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.18 장강철
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
     * @class FNS_JOO_0040 : FNS_JOO_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0040() {
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
                     doActionIBSheet( sheetObjects[0], document.form, IBSEARCH);
                     break;
                 
                 case "btn_New":
                     doActionIBSheet( sheetObjects[0], document.form, IBRESET);
 
                     break;

                 case "btn_Down_Excel":
                     var paramObj = new Object();
                     var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
                     sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );
                    // sheetObjects[0].Down2Excel();
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
     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);
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

      }
       
       /**
        * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
        * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
        * @param {ibsheet} sheetObj    IBSheet Object
        * @param {int}     sheetNo     sheetObjects 배열에서 순번
        **/
       function initControl() {
           var formObject = document.form;
           axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);  
           axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
           
           axon_event.addListenerForm  ('click',   'fnDocClick', formObject );
           axon_event.addListener      ('click',   'fnDocClick',    "btn_yr_from_back"   );         
           axon_event.addListener      ('click',   'fnDocClick',    "btn_yr_from_next"   );
           axon_event.addListener      ('click',   'fnDocClick',    "btn_yr_to_back"     );
           axon_event.addListener      ('click',   'fnDocClick',    "btn_yr_to_next"   );
      
           axon_event.addListener      ('click',   'fnDocClick',    "btn_wkmon_fr_back"   );
           axon_event.addListener      ('click',   'fnDocClick',    "btn_wkmon_fr_next"   );
           
           axon_event.addListener      ('click',   'fnDocClick',    "btn_wkmon_to_back"   );
           axon_event.addListener      ('click',   'fnDocClick',    "btn_wkmon_to_next"   );


           
           
           
           axon_event.addListenerFormat('BeforeDeactivate' ,  'fnDeactivate',  formObject);      
           axon_event.addListenerFormat('BeforeActivate'   ,  'fnActivate'  ,  formObject);     
           
           axon_event.addListenerForm('focus'   ,  'fnFocus'  ,  formObject);                  
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
                     style.height = 380;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);


                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle  = "|Year|Month|Week|Trade|Lane|Carrier|VVD|Release|Release|Release|Purchas|Purchas|Purchas";
                     var HeadTitle1 = "|Year|Month|Week|Trade|Lane|Carrier|VVD|Slot|Price|Amount|Slot|Price|Amount|Partner";


                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);           
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     InitHeadRow(1, HeadTitle1, true);

 
                     //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,        true,       "Status");
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,        true,       "cost_yr"          ,   false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,        true,       "cost_mon"          ,   false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,        true,       "cost_wk"          ,   false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,        true,       "trd_cd"           ,   false,      "",         dfNone,         0,          true,       true);                     
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,        true,       "rlane_cd"         ,   false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,        true,       "jo_crr_cd"        ,   false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         78,       daLeft,        true,       "vvd"              ,   false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,      100,     daRight,        true,       "r_stl_bsa_qty"    ,   false,      "",         dfInteger,      0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         80,      daRight,        true,       "r_stl_bsa_slt_prc",   false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,      120,     daRight,        true,       "r_stl_locl_amt"   ,   false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,      100,     daRight,        true,       "e_stl_bsa_qty"    ,   false,      "",         dfInteger,      0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         80,      daRight,        true,       "e_stl_bsa_slt_prc",   false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,      120,     daRight,        true,       "e_stl_locl_amt"   ,   false,      "",         dfFloat,        2,          true,       true);

                }
                 break;
           
         }
     }
      // Sheet관련 프로세스 처리
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg = false;
          switch(sAction) {

             case IBSEARCH_ASYNC01: //Get trd_cd
                  formObj.f_cmd.value = SEARCH01;       
                  var param = FormQueryString(formObj);  
                  var sXml  = sheetObj.GetSearchXml("FNS_JOO_0040GS.do", param);
                  var aXml  = sXml.split("|$$|");
                  ComXml2ComboItem( aXml[0], formObj.trd_cd, "code","code" );
                  ComXml2ComboItem( aXml[1], formObj.skd_dir_cd, "code","code" );
                  
                  formObj.wkmon_fr.value = gSmmF;
                  formObj.wkmon_to.value = gSmmT;
                  formObj.yr_from.value  = yyyy;
                  formObj.yr_to.value    = yyyy;
                  
                  
                  fnLblSetting();
                  break;

             case IBSEARCH_ASYNC02: //Get Lane By TradeCode
                  formObj.f_cmd.value = SEARCHLIST07;  
                  var super_cd2 = formObj.trd_cd.Code;
                  var param = FormQueryString(formObj)+"&super_cd2="+super_cd2;  
                  var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                  ComXml2ComboItem( sXml, formObj.rlane_cd, "code","code" );
                  break;
                  
                  
             case IBSEARCH_ASYNC03: //Get Carrier By Lane
                  formObj.f_cmd.value = SEARCHLIST13;            
                  var super_cd2 = formObj.rlane_cd.Code;
                  var param = FormQueryString(formObj)+"&super_cd2="+super_cd2;  
                  var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                  ComXml2ComboItem( sXml, formObj.jo_crr_cd, "code","code" );
                  break;
 
             case IBSEARCH:      //조회
                  if( !validateForm(sheetObj,formObj,sAction) ){return;}
                  formObj.f_cmd.value = SEARCHLIST01;            
                  var param =  FormQueryString(formObj);  
                  sheetObj.DoSearch("FNS_JOO_0040GS.do", param);

                  break;
 
                   
              case IBRESET:      
                   
                   formObj.wkmon_fr.value = gSmmF;
                   formObj.wkmon_to.value = gSmmT;
                   formObj.yr_from.value  = yyyy;
                   formObj.yr_to.value    = yyyy;
                   
                   formObj.week_month[0].checked = true;
                   fnLblSetting();
                   
                   fnBtnNew();   
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
               /*Year from Navi   yr_from*/
               case "btn_yr_from_back":
                   if (formObj.yr_from.value != "" ){
                       formObj.yr_from.value = ComGetDateAdd(formObj.yr_from.value+"0101","Y",-1).substring(0,4);    
                   }
                   fnBtnNew();              
               
                   break;
              case "btn_yr_from_next":
                   if (formObj.yr_from.value != "" ){
                      formObj.yr_from.value = ComGetDateAdd(formObj.yr_from.value+"0101","Y",+1).substring(0,4);    
                   }
                   fnBtnNew();                      
                   break;
              /*Year to Navi   yr_to */
              case "btn_yr_to_back":
                  if (formObj.yr_to.value != "" ){
                      formObj.yr_to.value = ComGetDateAdd(formObj.yr_to.value+"0101","Y",-1).substring(0,4);    
                  }
                  fnBtnNew();              
              
                  break;
             case "btn_yr_to_next":
                  if (formObj.yr_to.value != "" ){
                     formObj.yr_to.value = ComGetDateAdd(formObj.yr_to.value+"0101","Y",+1).substring(0,4);    
                  }
                  fnBtnNew();                      
                  break;
                   
              /*Week Month Navi*  wkmon_fr --*/
              case "btn_wkmon_fr_back":
                  if (formObj.wkmon_fr.value != "" ){
                      
                      var  wkmon_fr = formObj.wkmon_fr.value;
                      if(wkmon_fr==""){wkmon_fr = "00";}
                      if(wkmon_fr=="00"){return;}
                      formObj.wkmon_fr.value = ComLpad(eval(wkmon_fr)-1,2, '0'); 
                      
                  }
                  fnBtnNew();              
              
                  break;
              case "btn_wkmon_fr_next": //wkmon_fr ++
                  if (formObj.wkmon_fr.value != "" ){
                      
                      var wkmon_fr = formObj.wkmon_fr.value;
                      if(wkmon_fr==""){wkmon_fr = "";}
                      if(wkmon_fr=="00"){return;}
                      formObj.wkmon_fr.value = ComLpad(eval(wkmon_fr)+1,2, '0'); 
                      
                  }
                  fnBtnNew();                      
                  break;
                  
                  /*Week Month Navi*  wkmon_to*/
              case "btn_wkmon_to_back":
                  if (formObj.wkmon_to.value != "" ){
                      var wkmon_to = formObj.wkmon_to.value;
                      if(wkmon_to==""){wkmon_to = "";}
                      if(wkmon_to=="00"){return;}
                      formObj.wkmon_to.value = ComLpad(eval(wkmon_to)-1,2, '0');
                  }
                  fnBtnNew();
                  break;
              case "btn_wkmon_to_next":
                  if (formObj.wkmon_to.value != "" ){
                      var wkmon_to = formObj.wkmon_to.value;
                      if(wkmon_to==""){wkmon_to = "";}
                      if(wkmon_to=="00"){return;}
                      formObj.wkmon_to.value = ComLpad(eval(wkmon_to)+1,2, '0');
                  }
                  fnBtnNew();                      
                  break;
                  
              case "week_month":
                   fnLblSetting();
                   break;
           }
       } 
      /**
      * NEW 버튼 처리 
      * @param    void
      * @return   void
      */    
      function fnBtnNew(){
          var formObj = document.form;
          formObj.trd_cd.Code2="";
          formObj.rlane_cd.RemoveAll();
          formObj.jo_crr_cd.RemoveAll();
          formObj.skd_dir_cd.Code2="";

          formObj.vvd.value = "";
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
           switch ( obj.name ){
               case "yr_from":
                   ComKeyOnlyNumber( obj );
                   break;
               case "yr_to":
                   ComKeyOnlyNumber( obj );
                    break;
               case "wkmon_fr":
                   ComKeyOnlyNumber( obj );
                    break;   
               case "wkmon_to":
                   ComKeyOnlyNumber( obj );
                    break; 
               case "vvd":
                   ComKeyOnlyAlphabet( 'uppernum' );
                    break;        
                    
           }
 
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
          switch ( obj.name ){
              case "yr_from":
                  ComAddSeparator(obj);
                  break;
              case "yr_to":
                  ComAddSeparator(obj);
                   break;
              case "wkmon_fr":
                   if( eval(obj.value.length) != eval( obj.getAttribute("maxlength") ) ){
                       obj.value = ComLpad( obj.value, 2, '0');
                   }
                   break;   
              case "wkmon_to":
                  if( eval(obj.value.length) != eval( obj.getAttribute("maxlength") ) ){
                      obj.value = ComLpad( obj.value, 2, '0');
                  }
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
            var obj = event.srcElement;            
 
           event.srcElement.select();
       }        
      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리
       */
      function validateForm(sheetObj,formObj,sAction){
  
          with(formObj){
              switch ( sAction ){
                   case IBSEARCH :
                        if (!ComChkValid(formObj)) return false;

                        if ( formObj.trd_cd.Code == ""){
                            ComShowCodeMessage("JOO00115", "Trade Code");
                            formObj.trd_cd.focus();
                            return false;
                        }
//                        if ( formObj.rlane_cd.Code == ""){
//                            ComShowCodeMessage("JOO00115", "Lane Code");
//                            formObj.rlane_cd.focus();
//                            return false;
//                        }
                        break;
              }
          }

          return true;
      }
      function fnFocus(){
          var formObj = document.form;
          event.srcElement.select();
                        
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
                       MultiSelect     = false;  
                       UseAutoComplete = true;    
                       SetColAlign("left");        
                       SetColWidth("60");
                       DropHeight = 200;
                       ValidChar(2,1);//영문대문자+숫자만 입력가능
                   }  
                   break;  
                   
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
  
              case "skd_dir_cd": 
                  with (comboObj) { 
                       UseAutoComplete = true;
                       SetColAlign("left");
                       SetColWidth("60");
                       DropHeight = 200;
                       ValidChar(2,0);     
                       MaxLength = 1;                            
                   }  
                   break;   
           } 
      }   
       /**
        * Trade Change시, Lane Code 가져온다. <br>
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
                fnGridClear();
                formObj.rlane_cd.RemoveAll();
                formObj.jo_crr_cd.RemoveAll();
                formObj.skd_dir_cd.Code2="";
        }
   
        function rlane_cd_OnFocus(comboObj ) {
            var formObj = document.form;
            if(formObj.trd_cd.Code == ""){return;}
            if (comboObj.GetCount()== 0) {
                comboObj.Enable = false;
                doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC02);
                comboObj.Enable = true;
            }
        }
        
       /**
        * Lane Change시, Carrier Code 가져온다. <br>
        * <br><b>Example : </b>
        * <pre>
        *     rlane_cd Code 
        * </pre>
        * @param {인자Type} 콤보object 선택
        * @return void
        * @see #링크연결
        * @author jang kang cheol
        * @version 2009.07.01
        */
        function rlane_cd_OnChange(comboObj,value,text) {
            var formObj = document.form;
            fnGridClear();
            formObj.jo_crr_cd.RemoveAll();
            formObj.skd_dir_cd.Code2="";
        }
        function jo_crr_cd_OnFocus(comboObj ) {
            var formObj = document.form;
            if (comboObj.GetCount()== 0) {
                comboObj.Enable = false;
                doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC03);
                comboObj.Enable = true;
            }
        }
        function jo_crr_cd_OnChange(comboObj,value,text) {
            var formObj = document.form;
            fnGridClear();
            formObj.skd_dir_cd.Code2="";
        }        
       /**
        *  Form Clear
        * @param    void
        * @return   void
        */    
        function fnGridClear(){
            var formObj = document.form;
            if( sheetObjects[0].RowCount > 0) {
                sheetObjects[0].RemoveAll();
            }
        }
        /**
         * 
         * <pre>
         *     Week/Month Lable 셋팅.
         * </pre>
         *
         * @param   void 
         * @return  void
         * @author jang kang cheol
         */
        function fnLblSetting(){
            var formObj = document.form;
            var doc     = document.all;
            if( formObj.week_month[0].checked == true){//Month
                doc.lbl_mon_week.innerHTML = "Month";
                sheetObjects[0].ColHidden("cost_mon") = false;        
                sheetObjects[0].ColHidden("cost_wk")  = true;            
 
            }else if( formObj.week_month[1].checked == true){//Week
                doc.lbl_mon_week.innerHTML = "Week";
            sheetObjects[0].ColHidden("cost_mon") = true;        
            sheetObjects[0].ColHidden("cost_wk")  = false;    
            }
        }

	/* 개발자 작업  끝 */