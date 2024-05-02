/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0041.js
*@FileTitle : Slot Exchange Status by Lane & Partner->Space On Partner
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.19 장강철
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
     * @class FNS_JOO_0041 : FNS_JOO_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0041() {
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

                    case "btn_Down_Excel":
                        var paramObj = new Object();
                        paramObj.cols = 10;
                        var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);                         
                        sheetObjects[0].Down2Excel(-1, false,false, true, "", url);            
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
                      
                 case "rlane_cd": 
                     with (comboObj) {
                          MultiSelect     = false;  
                          UseAutoComplete = true;    
                          SetColAlign("left");        
                          SetColWidth("60");
                          DropHeight = 200;
                          ValidChar(2,1);//영문대문자+숫자만 입력가능
                          MaxLength = 5;
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
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * @param {ibsheet} sheetObj    IBSheet Object
       * @param {int}     sheetNo     sheetObjects 배열에서 순번
       **/
       function initControl() {
          var formObject = document.form;
          axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);  
          axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
          
          axon_event.addListener      ('click',   'fnDocClick', "btn_cost_yr_back"       );         
          axon_event.addListener      ('click',   'fnDocClick', "btn_cost_yr_next"       );  

          axon_event.addListenerFormat('BeforeDeactivate' ,  'fnDeactivate',  formObject);      
          axon_event.addListenerFormat('BeforeActivate'   ,  'fnActivate'  ,  formObject);     
          
          axon_event.addListenerForm('focus'   ,  'fnFocus'  ,  formObject);       
       }
       
       function sheet1_OnLoadFinish(sheetObj) {
           doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);
       }
           
      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
            var formObj = document.form;
            switch(sheetNo) {
                case 1:      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 184;
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

                        var termTitle =  formObj.cost_yr.value+" - "+formObj.cost_wk_fr.value+"~"+formObj.cost_wk_to.value;
                        var cumulTitle = formObj.cost_yr.value+" - 01~"+formObj.cost_wk_to.value;
                        
                        var HeadTitle  = "Partner|"+termTitle+"|"+termTitle+"|"+termTitle+"| "+cumulTitle+"| "+cumulTitle;
                        var HeadTitle1 = "Partner|Slot|Price|Amount|Slot|Amount";
                         
                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
                         
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);


                        //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData,             200,    daCenter,       true,       "jo_crr_cd",         false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          100,    daRight,        false,      "cur_stl_bsa_qty",   false,      "",         dfInteger,         0,       true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          100,    daRight,        false,      "prc"         ,      false,      "|stl_locl_amt|/|cur_stl_bsa_qty|",     dfFloat,      2,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          200,    daRight,        false,      "stl_locl_amt",      false,      "",         dfFloat,      2,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          160,    daRight,        false,      "term_stl_bsa_qty",  false,      "",         dfInteger,         0,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          200,    daRight,        false,      "term_stl_locl_amt", false,      "",         dfInteger,      0,          true,       true);
 
                   }
                    break;
               
                case 2:      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 184;
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

                        var termTitle =  formObj.cost_yr.value+" - "+formObj.cost_wk_fr.value+"~"+formObj.cost_wk_to.value;
                        var cumulTitle = formObj.cost_yr.value+" - 01~"+formObj.cost_wk_to.value;
                        
                        var HeadTitle  = "Partner|"+termTitle+"|"+termTitle+"|"+termTitle+"| "+cumulTitle+"| "+cumulTitle;
                        var HeadTitle1 = "Partner|Slot|Price|Amount|Slot|Amount";
                         
                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
                         
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);


                        //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    
                        InitDataProperty(0, cnt++ , dtData,             200,    daCenter,       true,       "jo_crr_cd",         false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          100,    daRight,        false,      "cur_stl_bsa_qty",   false,      "",         dfInteger,         0,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          100,    daRight,        false,      "prc",               false,      "|stl_locl_amt|/|cur_stl_bsa_qty|",         dfFloat,      2,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          200,    daRight,        false,      "stl_locl_amt",      false,      "",         dfFloat,      2,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          160,    daRight,        false,      "term_stl_bsa_qty",  false,      "",         dfInteger,         0,          true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,          200,    daRight,        false,      "term_stl_locl_amt", false,      "",         dfInteger,      0,          true,       true);

                   }
                    break;
               
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
                    
               case IBSEARCH_ASYNC01: //Get Carrier Code And Dir Code
                    formObj.f_cmd.value = SEARCH01;       
                    var param           = FormQueryString(formObj);  
                    var sXml            = sheetObj.GetSearchXml("FNS_JOO_0041GS.do", param);
                    var aXml            = sXml.split("|$$|");
                    ComXml2ComboItem( aXml[0], formObj.jo_crr_cd, "code","code" );
                    ComXml2ComboItem( aXml[1], formObj.skd_dir_cd, "code","code" );
                    break;
                    
               case IBSEARCH_ASYNC02: // Carrier Code OnChange, Get Trade Code
                    formObj.f_cmd.value = SEARCHLIST06;  
                    var super_cd1       = formObj.jo_crr_cd.Code;
                    var param           = FormQueryString(formObj)+"&super_cd1="+super_cd1;  
                    var sXml            = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                    ComXml2ComboItem( sXml, formObj.trd_cd, "code","code" );
                    break;
                    
               case IBSEARCH_ASYNC03: //Trade Code  OnChange, Get Lane 
                    formObj.f_cmd.value = SEARCHLIST07;            
                    var super_cd2       = formObj.trd_cd.Code;
                    var param           = FormQueryString(formObj)+"&super_cd2="+super_cd2;  
                    var sXml            = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                    ComXml2ComboItem( sXml, formObj.rlane_cd, "code","code" );
                    break;
                    
               case IBSEARCH:      //조회
                     if( !validateForm(sheetObj,formObj,sAction) ){return;}
                     formObj.f_cmd.value =  SEARCHLIST01;            
                     var param           =  FormQueryString(formObj);  
                     var sXml            =  sheetObj.GetSearchXml("FNS_JOO_0041GS.do", param);
                     var aXml            =  sXml.split("|$$|");
                     sheetObjects[0].LoadSearchXml(aXml[0]);
                     sheetObjects[1].LoadSearchXml(aXml[1]);                  
                     fnSetTitle(); 
                     break;
       
                case IBRESET:      
                     fnBtnNew();   
                     formObj.cost_yr.value = yyyy;
                     formObj.cost_wk_fr.value = "01";
                     formObj.cost_wk_to.value = "01";           
                     break;    
            }
        }
        /**
         * Carrier Change시, Trade Code 가져온다. <br>
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
                 formObj.skd_dir_cd.Code2="";
                 fnGridClear();
 
         }
         function trd_cd_OnFocus(comboObj) {
             var formObj = document.form;
             if(formObj.jo_crr_cd.Code == ""){return;}
             if (comboObj.GetCount()== 0) {
                 comboObj.Enable = false;
                 doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC02);
                 comboObj.Enable = true;
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
                  formObj.rlane_cd.RemoveAll();
                  formObj.skd_dir_cd.Code2="";
                  fnGridClear();
          }
          function rlane_cd_OnFocus(comboObj) {
              var formObj = document.form;
              if(formObj.trd_cd.Code == ""){return;}
              if (comboObj.GetCount()== 0) {
                  comboObj.Enable = false;
                  doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC03);
                  comboObj.Enable = true;
              }

          }

         /**
          * Lane Change시, Grid Clear <br>
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
              formObj.skd_dir_cd.Code2="";
              fnGridClear();
          }
          /**
           *  Dir Code 변경시, Grid Clear <br>
           * <br><b>Example : </b>
           * <pre>
           *     dir  Code 
           * </pre>
           * @param {인자Type} 콤보object 선택
           * @return void
           * @see #링크연결
           * @author jang kang cheol
           * @version 2009.07.01
           */
           function skd_dir_cd_OnChange(comboObj,value,text) {
               var formObj = document.form;
               fnGridClear();
               doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC06); 
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
    
                  case "btn_cost_yr_back":
                      if (formObj.cost_yr.value != "" ){
                          formObj.cost_yr.value = ComGetDateAdd(formObj.cost_yr.value+"0101","Y",-1).substring(0,4);    
                      }
                      fnBtnNew();              
                  
                      break;
                 case "btn_cost_yr_next":
                      if (formObj.cost_yr.value != "" ){
                         formObj.cost_yr.value = ComGetDateAdd(formObj.cost_yr.value+"0101","Y",+1).substring(0,4);    
                      }
                      fnBtnNew();                      
               
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
             fnGridClear();
             formObj.jo_crr_cd.Code2  = "";
             formObj.trd_cd.RemoveAll();
             formObj.rlane_cd.RemoveAll();
             formObj.skd_dir_cd.Code2 = "";
         }
         /**
          *  Form Clear
          * @param    void
          * @return   void
          */    
          function fnGridClear(){
              var formObj = document.form;
              
              for(var i=0;i<sheetObjects.length;i++){
                  if( sheetObjects[i].RowCount > 0) {
                      sheetObjects[i].RemoveAll();
                  }
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
              switch (obj.getAttribute("dataformat")){
                     case   'number':
                            ComKeyOnlyNumber( obj );
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
             switch(event.srcElement.name){
                 case 'cost_yr':
                     ComAddSeparator(event.srcElement);
                     break;
                 case 'cost_wk_fr':
                     if( obj.value.length == 1){
                         obj.value ='0'+obj.value;
                     }             
                     break;
                  
                 case   'cost_wk_to':
                     if( obj.value.length == 1){
                         obj.value ='0'+obj.value;
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
              var formObj = document.form;
              switch(event.srcElement.name){
                  case 'cost_yr':
                      ComClearSeparator(event.srcElement);
                      break;
              }
              event.srcElement.select();
          }        
          function fnFocus(){
              var formObj = document.form;
              switch(event.srcElement.name){
                  case 'cost_wk_fr':
                      formObj.cost_wk_fr.select();
                      break;
                  case 'cost_wk_to':
                      formObj.cost_wk_to.select();
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
                           if (!ComChkValid(formObj)) return false;
                           if ( formObj.jo_crr_cd.Code == ""){
                               ComShowCodeMessage("JOO00115", "Carrier Code");
                               formObj.jo_crr_cd.focus();
                               return false;
                           }
                           if ( formObj.trd_cd.Code == ""){
                               ComShowCodeMessage("JOO00115", "Trade Code");
                               formObj.trd_cd.focus();
                               return false;
                           }
                           break;
                 }
             }
             return true;
         }
         function fnSetTitle(){
             var formObj = document.form;
             for(var i=0;i<2;i++){
                 var termTitle =  formObj.cost_yr.value+" - "+formObj.cost_wk_fr.value+"~"+formObj.cost_wk_to.value;
                 sheetObjects[i].CellText(0,"cur_stl_bsa_qty")  = termTitle;
                 sheetObjects[i].CellText(0,"prc"            )  = termTitle;
                 sheetObjects[i].CellText(0,"stl_locl_amt"   )  = termTitle;
             
                 var cumulTitle = " "+formObj.cost_yr.value+" - 01~"+formObj.cost_wk_to.value;
                 sheetObjects[i].CellText(0,"term_stl_bsa_qty"   )   = cumulTitle;
                 sheetObjects[i].CellText(0,"term_stl_locl_amt"   )  = cumulTitle;       
             }
         }
       /* 개발자 작업  끝 */