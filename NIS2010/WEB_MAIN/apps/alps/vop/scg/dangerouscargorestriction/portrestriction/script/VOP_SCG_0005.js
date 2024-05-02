/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0005.js
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철 jkc
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
     * @class vop_scg_0005 : vop_scg_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0005() {
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

 var callbackEvent = "";
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
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                        
                    break;
                    
                case "btn_new":
                    doActionIBSheet(sheetObjects[0],document.form,IBINSERT);   
                    break;
                    
                case "btn_delete":
                    doActionIBSheet(sheetObjects[0],document.form,IBDELETE);                        
                    break;
                    
                case "btn_save":
                     doActionIBSheet(sheetObjects[0],document.form,IBSAVE);   
                    break;
                    
                case "btn_saveAs":
                    doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
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
     function initControl() {
            //Axon 이벤트 처리1. 이벤트catch(개발자변경)
          var formObj = document.form;
          formObj.imdg_clss_cd.DropHeight = 200;            
          axon_event.addListener    ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm('keypress', 'obj_keypress',    form  );          
          axon_event.addListenerForm('keyup',    'obj_keyup',       form);                
   
          
          axon_event.addListenerForm('change',  'obj_change',   form);
          axon_event.addListenerForm('click',   'obj_click',    form);   
          axon_event.addListenerForm('blur',    'obj_blur',     form);    
 
         
    
          axon_event.addListener    ('click',   'img_click',    "srch_port_cd");         
          axon_event.addListener    ('click',   'img_click',    "srch_imdg_un_no");
          axon_event.addListener    ('click',   'img_click',    "btn_retrieve");          
          
          axon_event.addListener    ('mousedown', 'mouse_down',   "btn_Retrieve");                 
          // IBMultiCombo초기화
          for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
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
       * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
       * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
       **/
      function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
      }      
      /**
       * Combo 기본 설정
       * Combo의 항목을 설정한다.
       */
      function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
            case "imdg_clss_cd":
 
                with(comboObj) {
                    SetTitle("Class|Definition");
                    SetColWidth("50|700")
                    DropHeight = 190;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;  
        }
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
 
             //setInitValue(sheetObjects[i], true);                          
         }
         initControl();
         initClass();
 
         doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBCLEAR);  
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
                     style.height = 80;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 2, 2 );
 
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(6, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                     InitHeadMode(false, false, false, false, false,false)

                     var HeadTitle = "|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|Prohibition|";
                    
      
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
           
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix  = "sheet1_";
                    InitDataProperty(0, 0 , dtStatus,              30,  daCenter,false, prefix+"ibflag"        );               
                    InitDataProperty(0, 1 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_lod_flg",                 false,  "",     dfNone,         0,          true,       true);
                    InitDataProperty(0, 2 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_dchg_flg",                false,  "",     dfNone,         0,          true,       true);
                    InitDataProperty(0, 3 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_ts_flg",                  false,  "",     dfNone,         0,          true,       true);
                    InitDataProperty(0, 4 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_pass_flg",                false,  "",     dfNone,         0,          true,       true);
                    InitDataProperty(0, 5 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_dy_tm_op_flg",            false,  "",     dfNone,         0,          true,       true);
 
                    InitDataProperty(1, 0 , dtHiddenStatus);                
                    InitDataProperty(1, 1 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_dy_tm_inlnd_tz_flg",      false,  "",     dfNone,         0,          true,       true);
                    InitDataProperty(1, 2 , dtData,                150, daLeft, false,  prefix+"1",                             false,  "",     dfNone,         0,          false,      false);
                    InitDataProperty(1, 3 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_port_flg",                false,  "",     dfNone,         0,          true,       true);
                    InitDataProperty(1, 4 , dtData,                150, daLeft, false,  prefix+"2",                             false,  "",     dfNone,         0,          false,      false);
                    InitDataProperty(1, 5 , dtCheckBox,            150, daLeft, false,  prefix+"prohi_ngt_flg",                 false,  "",     dfNone,         0,          true,       true);
                    

                    DataRowMerge(1) =true;
                    CountPosition=0;
                    //라벨 글자를 설정하고 데이터를 초기화
                    Visible = true;
    
               }
               break;
               
             case 2:      // sheet2 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 120;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 4, 4 );

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(8, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle = "|Competent Authority|Competent Authority|Competent Authority|Competent Authority|";
                 HeadTitle     += "Ton Over|Need Time|Need Time|";
                
  
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
       
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                var cRow = 0;
                var prefix  = "sheet2_";                 
                InitDataProperty(0, 0 , dtHiddenStatus,         30, daCenter,   false,  prefix+"ibflag"        );           
                InitDataProperty(cRow, 1 , dtData,             100, daCenter,   false,  prefix+"load",                  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,         100, daLeft ,    false,  prefix+"load_cmptn_auth_cd_p",  false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtCheckBox,         100, daLeft,     false,  prefix+"load_cmptn_auth_cd_d",  false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 4 , dtCheckBox,         100, daLeft,     false,  prefix+"load_cmptn_auth_cd_n",  false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,             100, daRight,    false,  prefix+"load_ton_ovr_vol_qty",  false,  "",   dfNumber,         0,          true,       true,9);
                InitDataProperty(cRow, 6 , dtData,              70, daRight,    false,  prefix+"load_nd_tm_hrs",        false,  "",   dfNumber,         0,          true,       true,5);
                InitDataProperty(cRow, 7 , dtData,             150, daLeft,     false,  prefix+"load_2",                false,  "",     dfNone,         0,          false,      false);
                
                 


                cRow++;                                                                
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,             100, daCenter,   false,  prefix+"dis",                   false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,         100, daLeft ,    false,  prefix+"dis_cmptn_auth_cd_p",   false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtCheckBox,         100, daLeft,     false,  prefix+"dis_cmptn_auth_cd_d",   false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 4 , dtCheckBox,         100, daLeft,     false,  prefix+"dis_cmptn_auth_cd_n",   false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,             100, daRight,    false,  prefix+"dis_ton_ovr_vol_qty",  false,   "",   dfNumber,         0,          true,       true,9);
                InitDataProperty(cRow, 6 , dtData,              70, daRight,    false,  prefix+"dis_nd_tm_hrs",     false,  "",       dfNumber,         0,          true,       true,5);
                InitDataProperty(cRow, 7 , dtData,             150, daLeft,     false,  prefix+"dis_2",             false,  "",         dfNone,         0,          false,      false);
                                                                  
                                                                                        
                cRow++;                                                                 
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,             100, daCenter,   false,  prefix+"ts",                    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,         100, daLeft ,    false,  prefix+"ts_cmptn_auth_cd_p",    false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtCheckBox,         100, daLeft,     false,  prefix+"ts_cmptn_auth_cd_d",    false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 4 , dtCheckBox,         100, daLeft,     false,  prefix+"ts_cmptn_auth_cd_n",    false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,             100, daRight,    false,  prefix+"ts_ton_ovr_vol_qty",  false,    "",   dfNumber,         0,          true,       true,9);
                InitDataProperty(cRow, 6 , dtData,              70, daRight,    false,  prefix+"ts_nd_tm_hrs",      false,  "",       dfNumber,         0,          true,       true,5);
                InitDataProperty(cRow, 7 , dtData,             150, daLeft,     false,  prefix+"ts_2",              false,  "",     dfNone,         0,          false,      false);
                                                                                      
                cRow++;                                                                 
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,             100, daCenter,   false,  prefix+"pass",                   false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,         100, daLeft ,    false,  prefix+"pass_cmptn_auth_cd_p",   false, "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtCheckBox,         100, daLeft,     false,  prefix+"pass_cmptn_auth_cd_d",   false, "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 4 , dtCheckBox,         100, daLeft,     false,  prefix+"pass_cmptn_auth_cd_n",   false, "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,             100, daRight,    false,  prefix+"pass_ton_ovr_vol_qty",  false,  "",   dfNumber,         0,          true,       true,9);
                InitDataProperty(cRow, 6 , dtData,              70, daRight,    false,  prefix+"pass_nd_tm_hrs",        false,  "",  dfNumber,          0,          true,       true,5);
                InitDataProperty(cRow, 7 , dtData,             150, daLeft,     false,  prefix+"pass_2",                false,  "",     dfNone,         0,          false,      false);
                      
                CountPosition=0;
                DataRowMerge(1) =true;
                    //라벨 글자를 설정하고 데이터를 초기화
                Visible = true;
        
               }
               break;
               
             case 3:      // sheet3 init
             with (sheetObj) {
 
                 // 높이 설정
                 style.height = 120;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 4, 4 );

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(13, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])                  
                 InitHeadMode(false, false, false, true, false,false)

                 var HeadTitle ="|";
                 for(var k=0;k<12;k++){
                     HeadTitle+= "Max. Quantity|";
                 }
 
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                       
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                var cRow = 0;
                var prefix  = "sheet3_";                       
                InitDataProperty(0, 0 , dtHiddenStatus,         30, daCenter,false,   prefix+"ibflag"        );         
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"load_L1",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 100, daLeft ,    false,  prefix+"load_L2",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,                 100, daRight,    false,  prefix+"load_tml_max_qty",         false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 4 , dtData,                  30, daLeft,     false,  prefix+"load_L3",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,                  50, daCenter,   false,  prefix+"load_L4",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,                 100, daLeft,     false,  prefix+"load_L4",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,                 100, daRight,    false,  prefix+"load_obrd_max_qty",        false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 8 , dtData,                  50, daLeft,     false,  prefix+"load_L5",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 9 , dtData,                  30, daCenter,   false,  prefix+"load_L6",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,10 , dtData,                 140, daLeft,     false,  prefix+"load_L7",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,11 , dtData,                 100, daRight,    false,  prefix+"load_one_tm_hndl_max_qty", false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow,12 , dtData,                  30, daLeft,     false,  prefix+"load_L8",                  false,   "",     dfNone,         0,          false,      false);             
 

                cRow++;                                                                     
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"dis_L1",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 100, daLeft ,    false,  prefix+"dis_L2",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,                 100, daRight,    false,  prefix+"dis_tml_max_qty",          false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 4 , dtData,                  30, daLeft,     false,  prefix+"dis_L3",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,                  50, daCenter,   false,  prefix+"dis_L4",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,                 100, daLeft,     false,  prefix+"dis_L9",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,                 100, daRight,    false,  prefix+"dis_obrd_max_qty",         false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 8 , dtData,                  50, daLeft,     false,  prefix+"dis_L5",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 9 , dtData,                  30, daCenter,   false,  prefix+"dis_L6",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,10 , dtData,                 140, daLeft,     false,  prefix+"dis_L7",                   false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,11 , dtData,                 100, daRight,    false,  prefix+"dis_one_tm_hndl_max_qty",  false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow,12 , dtData,                  30, daLeft,     false,  prefix+"dis_L8",                   false,   "",     dfNone,         0,          false,      false);             
                                                                     
                cRow++;                                                                      
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"ts_L1",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 100, daLeft ,    false,  prefix+"ts_L2",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,                 100, daRight,    false,  prefix+"ts_tml_max_qty",         false, "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 4 , dtData,                  30, daLeft,     false,  prefix+"ts_L3",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,                  50, daCenter,   false,  prefix+"ts_L4",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,                 100, daLeft,     false,  prefix+"ts_L9",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,                 100, daRight,    false,  prefix+"ts_obrd_max_qty",        false, "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 8 , dtData,                  50, daLeft,     false,  prefix+"ts_L5",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 9 , dtData,                 30,  daCenter,   false,  prefix+"ts_L6",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,10 , dtData,                 140, daLeft,     false,  prefix+"ts_L7",                  false, "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,11 , dtData,                 100, daRight,    false,  prefix+"ts_one_tm_hndl_max_qty", false, "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow,12 , dtData,                  30, daLeft,     false,  prefix+"ts_L8",                  false, "",     dfNone,         0,          false,      false);             
                                                                                                     
                cRow++;                                                                      
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"pass_L1",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 100, daLeft ,    false,  prefix+"pass_L2",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,                 100, daRight,    false,  prefix+"pass_tml_max_qty",         false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 4 , dtData,                  30, daLeft,     false,  prefix+"pass_L3",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,                  50, daCenter,   false,  prefix+"pass_L4",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,                 100, daLeft,     false,  prefix+"pass_L9",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,                 100, daRight,    false,  prefix+"pass_obrd_max_qty",        false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow, 8 , dtData,                  50, daLeft,     false,  prefix+"pass_L5",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 9 , dtData,                 30,  daCenter,   false,  prefix+"pass_L6",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,10 , dtData,                 140, daLeft,     false,  prefix+"pass_L7",                  false,   "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow,11 , dtData,                 100, daRight,    false,  prefix+"pass_one_tm_hndl_max_qty", false,   "",     dfNumber,           0,          true,       true,  9);
                InitDataProperty(cRow,12 , dtData,                  30, daLeft,     false,  prefix+"pass_L8",                  false,   "",     dfNone,         0,          false,      false);             
                       
                //SetMergeCell(0,1,1,12);
                //CellFont("FontBold", 0,1,1,10) = true;                  
                //DataRowMerge(1) =true;
                    //라벨 글자를 설정하고 데이터를 초기화
                CountPosition=0;
                Visible = true;
        
               }
               break;      
               
             case 4:      // sheet4 init
             with (sheetObj) {
 
                 // 높이 설정
                 style.height = 120;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 4, 4 );

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(3, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
 
                 InitHeadMode(false, false, false, true, false,false)

                 var HeadTitle ="|";
                 for(var k=0;k<LastCol ;k++){
                     HeadTitle+= "Text Explanation|";
                 }
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
 
                       
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix  = "sheet4_";    
                var cRow = 0;
                InitDataProperty(0, 0 , dtHiddenStatus,         30, daCenter,false,   prefix+"ibflag"        );             
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"load_L1",           false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 800, daLeft ,    false,  prefix+"load_txt_desc",     false,  "",     dfNone,         0,          true,       true, 250);
 
                cRow++;
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"dis_L1",            false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 800, daLeft ,    false,  prefix+"dis_txt_desc",      false,  "",     dfNone,         0,          true,       true, 250);
                
                cRow++;
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"ts_L1",             false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 800, daLeft ,    false,  prefix+"ts_txt_desc",       false,  "",     dfNone,         0,          true,       true, 250);
                
                cRow++;
                InitDataProperty(cRow, 1 , dtData,                 100, daCenter,   false,  prefix+"pass_L1",           false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,                 800, daLeft ,    false,  prefix+"pass_txt_desc",     false,  "",     dfNone,         0,          true,       true, 250);
                
               
                //CellFont("FontBold", 0,1,1,10) = true;                  
                //DataRowMerge(1) =true;
                //라벨 글자를 설정하고 데이터를 초기화
                CountPosition=0;
                Visible = true;
        
               }
               break;      
             case 5:      // sheet5 init
             with (sheetObj) {
 
                 // 높이 설정
                 style.height = 180;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 7, 7);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(9, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false,false)

                 var HeadTitle = "|Direct Load / Delivery / T/S|Direct Load / Delivery / T/S|Direct Load / Delivery / T/S|Direct Load / Delivery / T/S|";
                     HeadTitle += "Storage at CY|Storage at CY|Storage at CY|Storage at CY|";                 

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                       
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix  = "sheet5_";    
                var cRow = 0;//0
                InitDataProperty(0, 0 , dtHiddenStatus,         30, daCenter,false,   prefix+"ibflag"        );         
                InitDataProperty(cRow, 1 , dtData,          150,    daCenter,   false,  prefix+"dir_lod_flg_L1",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,       50,    daCenter ,  false,  prefix+"dir_lod_flg",           false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtData,          150,    daCenter,   false,  prefix+"dir_lod_flg_L2",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 4 , dtData,          100,    daLeft,     false,  prefix+"dir_lod_flg_L3",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,          100,    daCenter,   false,  prefix+"dir_lod_flg_L4",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtCheckBox,       50,    daCenter,   false,  prefix+"load_dys_sto_flg",      false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 7 , dtData,          100,    daRight,    false,  prefix+"load_sto_dys",          false,  "",     dfNumber,           0,          true,       true,  5);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"load_sto_dys_L2",       false,  "",     dfNone,         0,          false,      false);
 
                                                          
                cRow++;//1                                                              
                InitDataProperty(cRow, 0 , dtHiddenStatus);                             
                InitDataProperty(cRow, 1 , dtData,          150,    daCenter,   false,  prefix+"dir_dchg_flg_L1",       false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,       50,    daCenter ,  false,  prefix+"dir_dchg_flg",          false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtData,          150,    daCenter,   false,  prefix+"dir_dchg_flg_L1",       false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 4 , dtData,          100,    daLeft,     false,  prefix+"dir_dchg_flg_L2",       false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,          100,    daCenter,   false,  prefix+"dir_dchg_flg_L3",       false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtCheckBox,       50,    daCenter,   false,  prefix+"dis_dys_sto_flg",       false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 7 , dtData,          100,    daRight,    false,  prefix+"dis_sto_dys",           false,  "",     dfNumber,           0,          true,       true, 5);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"dis_sto_dys_L2",        false,  "",     dfNone,         0,          false,      false);                                                                                     
                cRow++;//2                                                              
                InitDataProperty(cRow, 0 , dtHiddenStatus);                              
                InitDataProperty(cRow, 1 , dtData,          150,    daCenter,   false,  prefix+"dir_ts_flg_L1",         false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtCheckBox,       50,    daCenter ,  false,  prefix+"dir_ts_flg",            false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 3 , dtData,          150,    daCenter,   false,  prefix+"dir_ts_flg_L2",         false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 4 , dtData,          100,    daLeft,     false,  prefix+"dir_ts_flg_L3",         false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 5 , dtData,          100,    daCenter,   false,  prefix+"dir_ts_flg_L4",         false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtCheckBox,       50,    daCenter,   false,  prefix+"ts_dys_sto_flg",        false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 7 , dtData,          100,    daRight,    false,  prefix+"ts_sto_dys",            false,  "",     dfNumber,           0,          true,       true, 5);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"ts_sto_dys_L2",         false,  "",     dfNone,         0,          false,      false);
 
                
                cRow++;     //3 
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,          150,    daLeft,     false,  prefix+"prohi_pinsp_flg_L1",    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,           50,    daLeft ,    false,  prefix+"prohi_pinsp_flg_L2",    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,          100,    daLeft,     false,  prefix+"prohi_pinsp_flg_L3",    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 4 , dtCheckBox,       30,    daCenter,   false,  prefix+"prohi_pinsp_flg",       false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,          100,    daCenter,   false,  prefix+"prohi_pinsp_flg_L4",    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,          100,    daLeft,     false,  prefix+"prohi_pinsp_flg_L5",    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,          100,    daCenter,   false,  prefix+"prohi_pinsp_flg_L6",    false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"prohi_pinsp_flg_L7",    false,  "",     dfNone,         0,          false,      false);
                DataRowMerge(3) =true;
                 
 
                cRow++;     //4 
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,          150,    daLeft,     false,  prefix+"xtra_hndl_chg_flg_L1",  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,           50,    daLeft ,    false,  prefix+"xtra_hndl_chg_flg_L2",  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,          100,    daLeft,     false,  prefix+"xtra_hndl_chg_flg_L3",  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 4 , dtCheckBox,       30,    daCenter,   false,  prefix+"xtra_hndl_chg_flg",     false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,          100,    daCenter,   false,  prefix+"xtra_hndl_chg_flg_L4",  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,          100,    daLeft,     false,  prefix+"xtra_hndl_chg_flg_L5",  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,          100,    daCenter,   false,  prefix+"xtra_hndl_chg_flg_L6",  false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"xtra_hndl_chg_flg_L7",  false,  "",     dfNone,         0,          false,      false);
                DataRowMerge(4) =true;      
                
                cRow++;     //5 
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,          150,    daLeft,     false,  prefix+"sft_gad_flg_L1",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,           50,    daLeft ,    false,  prefix+"sft_gad_flg_L2",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,          150,    daLeft,     false,  prefix+"sft_gad_flg_L3",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 4 , dtCheckBox,       30,    daCenter,   false,  prefix+"sft_gad_flg",           false,  "",     dfNone,         0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,          100,    daCenter,   false,  prefix+"sft_gad_flg_L4",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 6 , dtData,          100,    daLeft,     false,  prefix+"sft_gad_flg_L5",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,          100,    daCenter,   false,  prefix+"sft_gad_flg_L6",        false,  "",     dfNone,         0,          false,      false);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"sft_gad_flg_L7",        false,  "",     dfNone,         0,          false,      false);
                DataRowMerge(5) =true;  
                
                cRow++;     //6 
                InitDataProperty(cRow, 0 , dtHiddenStatus);             
                InitDataProperty(cRow, 1 , dtData,          150,    daLeft,     false,  prefix+"kep_sft_dist_ihb_flg_L1", false,    "",     dfNone,     0,          false,      false);
                InitDataProperty(cRow, 2 , dtData,           50,    daLeft ,    false,  prefix+"kep_sft_dist_ihb_flg_L2", false,    "",     dfNone,     0,          false,      false);
                InitDataProperty(cRow, 3 , dtData,          150,    daLeft,     false,  prefix+"kep_sft_dist_ihb_flg_L3", false,    "",     dfNone,     0,          false,      false);
                InitDataProperty(cRow, 4 , dtCheckBox,       50,    daCenter,   false,  prefix+"kep_sft_dist_ihb_flg",    false,    "",     dfNone,     0,          true,       true);
                InitDataProperty(cRow, 5 , dtData,          100,    daRight,    false,  prefix+"kep_sft_dist_ihb_dist",   false,    "",     dfNumber,       0,          true,       true,   6);
                InitDataProperty(cRow, 6 , dtData,           50,    daLeft,     false,  prefix+"kep_sft_dist_ihb_flg_L5", false,    "",     dfNone,     0,          false,      false);
                InitDataProperty(cRow, 7 , dtData,          100,    daCenter,   false,  prefix+"kep_sft_dist_ihb_flg_L6", false,    "",     dfNone,     0,          false,      false);
                InitDataProperty(cRow, 8 , dtData,          100,    daLeft,     false,  prefix+"kep_sft_dist_ihb_flg_L7", false,    "",     dfNone,     0,          false,      false);
                DataRowMerge(6) = true; 
                
    
                 //SetMergeCell( 4, 5, 1, 3);
                //SetMergeCell(0,1,1,2);
                //CellAlign(0,1)=daCenter;                
                //CellFont("FontBold", 0,1,1,10) = true;                  
                //DataRowMerge(1) =true;
                //라벨 글자를 설정하고 데이터를 초기화
                CountPosition=0;
                Visible = true;
        
               }
               break;    
                
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction) {
         sheetObj.ShowDebugMsg = false;
         sheetObj.SelectionMode = smSelectionCol;          
         switch(sAction) {
            case IBCLEAR:      //초기화 1. Class Combo 가져오기
 
                 formObj.f_cmd.value = SEARCH02;      //SEARCH02            
                 var param =  FormQueryString(formObj);
 
                 var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
     
                 ComXml2ComboItem( sXml, formObj.imdg_clss_cd, "imdg_clss_cd","imdg_clss_cd|imdg_clss_cd_desc" );
                 formObj.port_cd.focus();

         
                 break;
            case IBSEARCH:      //조회

                  if( !validateForm(sheetObj,formObj,sAction)){
                      return;
                  }else{
                      formObj.f_cmd.value = SEARCH01;
                  }
 
                  var param     = "";
                  var optClass  = formObj.optClass[0].checked==true?"class":"unno"; 
                  param +="f_cmd="+formObj.f_cmd.value+"&port_cd="+formObj.port_cd.value+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
                  param +="&imdg_un_no="+formObj.imdg_un_no.value+"&imdg_un_no_seq="+formObj.imdg_un_no_seq.value+"&optClass="+optClass;
                 
                  var aryPrefix = new Array( "sheet1_","sheet2_","sheet3_","sheet4_","sheet5_"  );                
                  var sXml      = sheetObj.GetSearchXml("VOP_SCG_0005GS.do", param + "&" + ComGetPrefixParam( aryPrefix ) );
                  
 
                  var arrXml = sXml.split("|$$|");
                  var sMsg   = getMessage(arrXml[0]);
                  
                  if( document.all.btn_delete.className == "btn1_1" ){
                      document.all.btn_delete.className =  "btn1";
                  }                   
                  fnGridEnble(true);
                  /******************************************/
                  if( document.form.optClass[0].checked == true ){//Class시 
                          if( getTotal(arrXml[0]) != "0"){
                              /*  데이타가 존재시 Setting */
                              for(var i = 0; i < arrXml.length; i++){ 
                                  setSheetObjectRetValue(sheetObjects[i], arrXml);
                              }
                              document.all.btn_saveAs.className= 'btn1';
                          }else{//sMsg
                              /*  데이타가 없을시, */
                              if( !ComShowConfirm(sMsg) ){//취소 SEARCH로 ...CLEAR 처리
                                     doActionIBSheet(sheetObjects[0], formObj,IBINSERT);   
                                     return;                              
                              }else{//New Insert Ok
                                     /******************* 그리드 초기값 설정 ********************/
                                     for(i=0;i<sheetObjects.length;i++){
                                         setInitValue(sheetObjects[i], true);    
                                     }  
                                     setIuputMode();
                                     return;
                                     /******************* 입력모드로 변경 END ********************/                                     
                              }  
                          }
                  }else{//Unno 조회 시
 
                      var NO_DATA_MSG  = ComGetEtcData(arrXml[0], "NO_DATA_MSG");   
                      /* UNNO, 조회시, 해당 CLASS 코드를 조회옵션에 셋팅한다. */
                      var etcImdg_clss_cd      =   ComGetEtcData(arrXml[0], "imdg_clss_cd");
                      var etcImdg_clss_cd_desc =   ComGetEtcData(arrXml[0], "imdg_clss_cd_desc");
                      if( etcImdg_clss_cd != ""){
                          formObj.imdg_clss_cd.Code2 = etcImdg_clss_cd;
                      }
                      if( etcImdg_clss_cd_desc != ""){
                          formObj.imdg_clss_cd_desc.value = etcImdg_clss_cd_desc;  
                      }         
 
                      /******************************************************************
                       *  UN NO 조회시, CLASS로 조회해야한다.  
                       *     처음 조회시, 데이타가 없는 처리 구분자를  NO_DATA_MSG 로 사용.
                       *         
                       ******************************************************************/
                      if( NO_DATA_MSG != undefined && NO_DATA_MSG != ""){

                          //unno으로 조회시 데이타 없어서 CLASS로 조회해도  없는 경우 
                          if( NO_DATA_MSG == "NO_DATA"){ //UNNO, CLASS로도 조회했는데 DATA가 없는경우
                              
                                  if( !ComShowConfirm(sMsg) ){//CLEAR 
                                         doActionIBSheet(sheetObjects[0], formObj,IBINSERT);   
                                         return;                              
                                  }else{//New Insert Ok    입력모드로 수정.
                                         /******************* 그리드 초기값 설정 ********************/
                                         for(i=0;i<sheetObjects.length;i++){
                                             setInitValue(sheetObjects[i], true);    
                                         }  
                                         setIuputMode();
                                         return;
                                         /******************* 입력모드로 변경 END ********************/                                     
                                  }                                 
                          }
                          if(  etcImdg_clss_cd != undefined  ){
                              /* 
                               * 그리드 중에 MAIN MASTER 역할을 하는 Prohibition 그리드를  Edtitable 처리 한다.
                               */
                              formObj.imdg_clss_cd.Text2 = etcImdg_clss_cd;
                              for(var i=0;i<=sheetObjects[0].RowCount;i++){
                                  sheetObjects[0].RowEditable( i )= true;
                              }                                   
                          }
 
                          /*
                           *  UNNO  으로 조회시 데이타 없어서 CLASS로 조회해서  DATA 있는경우
                           *    1. 메시지 보여주기    
                           *       Check! This Un No./Seq. restriction is based on Class restriction. O.K.
                           *    2. Grid 셋팅.
                           *
                           * NO_DATA_MSG : USE_UNNO - UNNO로 조회했지만, 데이타가 없어서, CLASS코드로
                           *               조회하여 나온결과
                           */
                          if( NO_DATA_MSG == "USE_UNNO"){  
                              if( getTotal(arrXml[0]) != "0"){
                                  //Check! This Un No./Seq. restriction is based on Class restriction. O.K.
                                  ComShowMessage( sMsg  ); 
                                  document.all.btn_delete.className = 'btn1_1';
                                  for(var i = 0; i < arrXml.length; i++){ 
                                      setSheetObjectRetValue(sheetObjects[i], arrXml);
                                  }
                                  formObj.imdg_port_rstr_seq.value = "";//등록용처리.
                              }
                          }
                      }else{
                          if( getTotal(arrXml[0]) != "0"){
                              for(var i = 0; i < sheetObjects.length; i++){ 
                                  setSheetObjectRetValue(sheetObjects[i], arrXml);
                              }
                              document.all.btn_saveAs.className= 'btn1';
                          }else{
                              ComShowMessage( sMsg );  
                              setIuputMode();
                          }
                      }
                  }
                  break;
                   
             case IBSAVE:        //저장
                 if(!validateForm(sheetObj,formObj,sAction)){
                      return;
                 }
                 formObj.f_cmd.value = MULTI01;             
 
                 if(!setCmptnAuthCd()){
                	 return;
                 }
 
                 var aryPrefix = new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_" );
                 var sParam    = ComGetSaveString(sheetObjects,true, true);//3번쨰 파람 전체 저장.
 
                 if (sParam == "") return;
                  sParam +="&f_cmd="+formObj.f_cmd.value+"&port_cd="+formObj.port_cd.value+"&imdg_clss_cd="+formObj.imdg_clss_cd.Text;
                  sParam +="&imdg_un_no="+formObj.imdg_un_no.value+"&imdg_un_no_seq="+formObj.imdg_un_no_seq.value;
                  sParam +="&imdg_port_rstr_seq="+formObj.imdg_port_rstr_seq.value;
                  sParam +="&rstr_rmk="+formObj.rstr_rmk.value;
                  sParam +="&load_imdg_cmptn_auth_cd="+formObj.load_imdg_cmptn_auth_cd.value;
                  sParam +="&dis_imdg_cmptn_auth_cd="+formObj.dis_imdg_cmptn_auth_cd.value;
                  sParam +="&ts_imdg_cmptn_auth_cd="+formObj.ts_imdg_cmptn_auth_cd.value;
                  sParam +="&pass_imdg_cmptn_auth_cd="+formObj.pass_imdg_cmptn_auth_cd.value;
             
                  var sXml = sheetObjects[0].GetSaveXml("VOP_SCG_0005GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
                  
                  var NEW_IMDG_PORT_RSTR_SEQ  = ComGetEtcData( sXml , "NEW_IMDG_PORT_RSTR_SEQ");
 
                  if( NEW_IMDG_PORT_RSTR_SEQ != "" && NEW_IMDG_PORT_RSTR_SEQ !=  undefined ){
                       formObj.imdg_port_rstr_seq.value = NEW_IMDG_PORT_RSTR_SEQ;
                  }
                  sheetObjects[0].LoadSaveXml(sXml);
                 
 
                 break;
             case IBDELETE:        //삭제
               
                 if(!validateForm(sheetObj,formObj,sAction)){
                     return;
                 }
                 formObj.f_cmd.value = REMOVE;
 
                 var aryPrefix = new Array("sheet1_"  );
                 var sParam    = ComGetSaveString(sheetObjects,true, true);//3번쨰 파람 전체 저장.

                 if (sParam == "") return;
                 sParam += "&" + FormQueryString(formObj);
                 var sXml = sheetObjects[0].GetSaveXml("VOP_SCG_0005GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
                 sheetObjects[0].LoadSaveXml(sXml);
                 if( getTrAllValue(sXml) == "OK") { 
                     for(var i =0;i<sheetObjects.length;i++){
                          setInitValue(sheetObjects[i], true);
                     } 
                     for(var i=0;i<=sheetObjects[0].RowCount;i++){
                          sheetObjects[0].RowEditable( i )= true;
                     }
 
                     formObj.rstr_rmk.value = "";
                 }  
                            
               break;                 
                 
            case IBINSERT:      // 입력
                 var aryPrefix       =  new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_");
//               var sParam          =  ComGetSaveString(sheetObjects, true, true);             
//                 if( sParam !=  ""){
//               if( !ComShowCodeConfirm("SCG02007", "Data") )
//                   return;
//                 }
                 for(i=0;i<sheetObjects.length;i++){
                     setInitValue(sheetObjects[i], true);                          
                 }
                 
                 
                 formObj.port_cd.value = "";
                 formObj.port_cd_nm.value = "";
                 formObj.optClass[0].checked = true;
                 formObj.upd_usr_id.value = "";
                 formObj.upd_dt.value = "";
                 
                 formObj.imdg_clss_cd.Enable = true;
                 
                 
                 formObj.imdg_clss_cd.Code = "";
                 formObj.imdg_clss_cd.Text = "";
                 
                 formObj.imdg_clss_cd_desc.value = "";
                 formObj.imdg_un_no.value = "";
                 formObj.imdg_un_no_seq.value = "";
                 formObj.prp_shp_nm.value = "";                
            
                 formObj.optClass[0].fireEvent("onclick");
 
                 document.form.rstr_rmk.value = "";
                 formObj.imdg_port_rstr_seq.value = "";
                 formObj.port_cd.focus();
             
                 break;
            case COMMAND04:      //SAVE  AS 기능 .
                 var param  = "port_cd="            +formObj.port_cd           .value;
                     param += "&port_cd_nm="        +formObj.port_cd_nm        .value;
                     param += "&imdg_clss_cd="      +formObj.imdg_clss_cd      .Text;
                     param += "&imdg_clss_cd_desc=" +formObj.imdg_clss_cd_desc .value;
                     param += "&imdg_un_no="        +formObj.imdg_un_no        .value;
                     param += "&imdg_un_no_seq="    +formObj.imdg_un_no_seq    .value;
                     param += "&imdg_port_rstr_seq="+formObj.imdg_port_rstr_seq.value;                     
                     if( formObj.imdg_port_rstr_seq.value == ""){
                         ComShowCodeMessage("SCG50018");
                         return;
                     }  
                     if(formObj.optClass[0].checked){
                         param += "&optClass=class";
                     }else{
                         param += "&optClass=unno";
                     }
            
                 ComOpenPopup('/hanjin/VOP_SCG_1005.do?'+param, 623, 360, "setSaveAs", "1,0,1,1,1,1,1,1", true,false);            
                 break;
            case IBSEARCH_ASYNC01:      //조회   PORT_NM구하기
                 formObj.f_cmd.value = SEARCH09;
                 var aryPrefix       =  new Array("sheet1_");
                 var param           =  FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );
                 var sXml            =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);
                 var sMsg            =  getMessage(sXml);
 
                 if(sMsg != ""){
                     ComShowMessage(sMsg);
                     formObj.port_cd.value = "";
                     formObj.port_cd_nm.value = "";
                     formObj.port_cd.focus(); 
                     formObj.port_cd.select();  
                     
                     return;
                 }
                 var port_cd_nm      =  ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm  
                 document.form.port_cd_nm.value = port_cd_nm;       
                 
                 if( port_cd_nm != ""   ){ 
                     if( formObj.imdg_clss_cd.Text != ""  ){
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                     }
                 }
                 break; 
            case IBSEARCH_ASYNC02:      //prp_shp_nm 조회
                 formObj.f_cmd.value = SEARCH05;
           
            
                 var param =  FormQueryString(formObj) ;
                 //var sXml  =  sheetObj.GetSearchXml("VOP_SCG_0005GS.do", param);
                 var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                 
 
                  

                 var sTotal = ComScgGetTotalValue(sXml);

                 formObj.prp_shp_nm.value = "";
                 if( sTotal == "0"){
                     ComShowCodeMessage("SCG50010", 'Data');
                     formObj.imdg_un_no_seq.value = '';                      
                     formObj.imdg_un_no_seq.focus();
                     return;
                 }else{
                     var prp_shp_nm                  =  ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
                     var imdg_clss_cd_desc           =  ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
                     var imdg_clss_cd                =  ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd                         
                     
                     formObj.prp_shp_nm.value        =  prp_shp_nm;   
                     formObj.imdg_clss_cd_desc.value =  imdg_clss_cd_desc;
                     formObj.imdg_clss_cd.Code2      =  imdg_clss_cd;                            
                 }
                 
                 /*************************unno_seq 처리후 retrieve 처리 *****************************/
                 if( prp_shp_nm !="" && callbackEvent != ""){
                     if( callbackEvent == "btn_Retrieve"){
                         callbackEvent="";
                        // doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                     }
                 }
                 
                 break;
            case IBSEARCH_ASYNC03:      //checkUNNumber
                formObj.f_cmd.value = SEARCH01;
 
                var param =  FormQueryString(formObj) ;
                var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                var sTotal = ComScgGetTotalValue(sXml);
 
                if( sTotal == "0"){
                     ComShowCodeMessage("SCG50010", 'Data');
                     formObj.imdg_un_no.value = "";                      
                     formObj.imdg_un_no.focus();
                }else{

                     formObj.imdg_un_no_seq.focus();
                }
            break; 
                                  
         }
     }
     function setSaveAs(){
         
     }
     function setIuputMode(){
 
             for(var i=0;i<=sheetObjects[0].RowCount;i++){
                 sheetObjects[0].RowEditable( i )= true;
             }
             for(var i=4;i<=sheetObjects[4].RowCount;i++){
                 sheetObjects[4].RowEditable( i )= true;
             }

 
             document.form.rstr_rmk.value                = "";
             document.form.imdg_port_rstr_seq.value       = "";              
     }
     function setInitValue(sheetObj, dataInsYn){
 
         with (sheetObj)
         {
             if(sheetObj.id == 'sheet1') {
                 Redraw = false;
                 if( dataInsYn ){
                    RemoveAll();
                    DataInsert();
                 }
                 CellText(1,1) = "Load";
                 CellText(1,2) = "Discharge";
                 CellText(1,3) = "T/S";             
                 CellText(1,4) = "Pass";
                 CellText(1,5) = "Day Time Operation";
                 
                 CellText(2,1) = "Day Time In-Land Transit";
 
                   
                 CellText(2,3) = "In-port Operation";        
 
                 CellText(2, 5)= "Night Time Operation";    
 
                 Redraw = true;              
             }else if(sheetObj.id == 'sheet2') {
 
                 RemoveAll();
                 DataInsert();     
                 CellText(1,1) = "Load";       
                 CellText(1,2) = "Permit";      
                 CellText(1,3) = "Declare";              
                 CellText(1,4) = "No Need";  
                 CellText(1,7) = " HRs before BKG or Enter";   
                 
                 CellText(2,1) = "Dis";    
                 CellText(2,2) = "Permit";      
                 CellText(2,3) = "Declare";              
                 CellText(2,4) = "No Need";  
                 CellText(2,7) = " HRs before BKG or Enter";    
                 
                 CellText(3,1) = "T/S";    
                 CellText(3,2) = "Permit";      
                 CellText(3,3) = "Declare";              
                 CellText(3,4) = "No Need";  
                 CellText(3,7) = " HRs before BKG or Enter";  

                 CellText(4,1) = "Pass";       
                 CellText(4,2) = "Permit";      
                 CellText(4,3) = "Declare";              
                 CellText(4,4) = "No Need";  
                 CellText(4,7) = " HRs before BKG or Enter";    
                
                 ColBackColor(1) = RgbColor(235,246,249);      
 
             }else if(sheetObj.id == 'sheet3') {
                 
                 RemoveAll();
                 DataInsert();     
                 CellText(1,1) = "Load";       
                 CellText(1,2) = "Terminal";        
                 CellText(1,4) = "Kg";               
                 CellText(1,6) = "On Board";  
                 CellText(1,8) = "Kg";   
                 CellText(1,10) = "One Time handling";  
                 CellText(1,12) = "Kg";  
                 
                 CellText(2,1) = "Dis";    
                 CellText(2,2) = "Terminal";        
                 CellText(2,4) = "Kg";               
                 CellText(2,6) = "On Board";  
                 CellText(2,8) = "Kg";   
                 CellText(2,10) = "One Time handling";                   
                 CellText(2,12) = "Kg";        
                 
                 CellText(3,1) = "T/S";    
                 CellText(3,2) = "Terminal";        
                 CellText(3,4) = "Kg";               
                 CellText(3,6) = "On Board";  
                 CellText(3,8) = "Kg";   
                 
                 CellText(4,1) = "Pass";       
                 CellText(4,2) = "Terminal";        
                 CellText(4,4) = "Kg";               
                 CellText(4,6) = "On Board";  
                 CellText(4,8) = "Kg";   
                 ColBackColor(1) = RgbColor(235,246,249);   
                 
                 CellEditable(3, "sheet3_pass_one_tm_hndl_max_qty") = false;
                 CellEditable(4, "sheet3_pass_one_tm_hndl_max_qty") = false;
//               for(var i=1;i<=RowCount;i++){
//                   RowEditable( i )= false;
//               }               
             }else if(sheetObj.id == 'sheet4') {
                 
                 RemoveAll();
                 DataInsert();     
                 CellText(1,1) = "Load";       
                 CellText(2,1) = "Dis";     
                 CellText(3,1) = "T/S";              
                 CellText(4,1) = "Pass";
 
                 CellFont("FontBold", 0,1, 0, 10) = true;   
                 ColBackColor(1) = RgbColor(235,246,249);   
          
             }else if(sheetObj.id == 'sheet5') {
                 
                 RemoveAll();
                 DataInsert();     
                 CellText(1,1) = "Direct Load";    
                 CellText(1,5) = "Load";      
                 CellText(1,8) = "Days Storage";        
                 
                 CellText(2,1) = "Direct Delivery";     
                 CellText(2,5) = "Dis";   
                 CellText(2,8) = "Days Storage";                    
                 
                 CellText(3,1) = "Direct T/S";      
                 CellText(3,5) = "T/S";   
                 CellText(3,8) = "Days Storage";    
                 
                 CellText(4,1) = "Pre-Inspection";
                 CellText(4,2) = "Pre-Inspection";  
                 CellText(4,3) = "Pre-Inspection";
                 
                 CellText(4,5) = " ";   
                 CellText(4,6) = " ";   
                 CellText(4,7) = " ";
                 CellText(4,8) = " ";                
                 
                 
                 CellText(5,1) = "Extra Handling Charge";
                 CellText(5,2) = "Extra Handling Charge";   
                 CellText(5,3) = "Extra Handling Charge";

                 CellText(5,5) = " ";   
                 CellText(5,6) = " ";   
                 CellText(5,7) = " ";
                 CellText(5,8) = " ";     
                 
                 
                 CellText(6,1) = "Safe Guard";
                 CellText(6,2) = "Safe Guard";  
                 CellText(6,3) = "Safe Guard";               
                
                 CellText(6,5) = " ";   
                 CellText(6,6) = " ";   
                 CellText(6,7) = " ";
                 CellText(6,8) = " ";
                 
                 
                 CellText(7,1) = "Keep Safety Distance from Inhabitation";
                 CellText(7,2) = "Keep Safety Distance from Inhabitation";
                 CellText(7,3) = "Keep Safety Distance from Inhabitation";
                 
                 CellText(7,6) = "Meter";                
                 CellText(7,7) = "Meter";      
                 CellText(7,8) = "Meter";                    
                 
                 ColBackColor(1) = RgbColor(235,246,249);      
                 ColBackColor(5) = RgbColor(235,246,249);   
                 CellBackColor(7,5) = RgbColor(255,255,255);
 
 
             }
             document.form.rstr_rmk.value        = "";
            // document.form.prp_shp_nm.value      = "";    
             document.form.imdg_port_rstr_seq.value      = "";               
         }       
     }
     function setSheetObjectRetValue(sheetObj, aXml ){ 
         if( sheetObj.id == 'sheet1'){
            with(sheetObj){
               var sXml = aXml[0];
               var aColorder  = getColOrder(sXml).split("|");
              Redraw = false;
               document.form.imdg_port_rstr_seq.value   =  getSearchRow(sXml, 1,"sheet1_imdg_port_rstr_seq") ;
              //document.form.imdg_clss_cd.Text2         =  getSearchRow(sXml, 1,"sheet1_imdg_clss_cd") ;
 
              CellValue2( 1, "sheet1_prohi_dchg_flg" )     =  getSearchRow(sXml, 1,"sheet1_prohi_dchg_flg")=="Y"?"1":"0";
              CellValue2( 1, "sheet1_prohi_lod_flg" )      =  getSearchRow(sXml, 1,"sheet1_prohi_lod_flg")=="Y"?"1":"0"; 
 
              CellValue2( 1, "sheet1_prohi_ts_flg" )       =  getSearchRow(sXml, 1,"sheet1_prohi_ts_flg"  )=="Y"?"1":"0";
              CellValue2( 1, "sheet1_prohi_pass_flg" )     =  getSearchRow(sXml, 1,"sheet1_prohi_pass_flg")=="Y"?"1":"0";             
              CellValue2( 1, "sheet1_prohi_dy_tm_op_flg" ) =  getSearchRow(sXml, 1,"sheet1_prohi_dy_tm_op_flg")=="Y"?"1":"0";
 
              CellValue2( 2, "sheet1_prohi_dy_tm_inlnd_tz_flg" )  = getSearchRow(sXml, 1,"sheet1_prohi_dy_tm_inlnd_tz_flg")=="Y"?"1":"0";
              CellValue2( 2, "sheet1_prohi_port_flg" )  = getSearchRow(sXml, 1,"sheet1_prohi_port_flg") =="Y"?"1":"0";      
              CellValue2( 2, "sheet1_prohi_ngt_flg" )   = getSearchRow(sXml, 1,"sheet1_prohi_ngt_flg")=="Y"?"1":"0";
              
              document.form.upd_usr_id.value = getSearchRow(sXml, 1,"sheet1_upd_usr_id") ;
              document.form.upd_dt.value     = getSearchRow(sXml, 1,"sheet1_upd_dt_f") ;
             
 
              for(var i=1;i<=sheetObjects[0].RowCount;i++){                      
                  sheetObjects[0].RowEditable( i )= true;
              }
              
              if(  CellValue ( 1, "sheet1_prohi_lod_flg" ) == 1 ){
                  for(var i=1;i<2;i++){                      
                      ScgRowEditable(sheetObjects[i], 1, "", false);
                  } 
              }else{
                  for(var i=1;i<2;i++){
                      ScgRowEditable(sheetObjects[i], 1, sheetObjects[i].id+"_load", true);                               
                     // ScgRowClear(sheetObjects[i], 1);    
                  }                   
              }   
            
              if(  CellValue ( 1, "sheet1_prohi_dchg_flg" ) == 1 ){
                  for(var i=1;i<2;i++){                      
                      ScgRowEditable(sheetObjects[i], 2, "", false);
                  }
              }else{
                    for(var i=1;i<2;i++){   
                        ScgRowEditable(sheetObjects[i], 2, sheetObjects[i].id+"_dis", true);                            
                        ScgRowClear(sheetObjects[i], 2);      
                    }                 
              }  
              if(  CellValue ( 1, "sheet1_prohi_ts_flg" ) == 1 ){
                  for(var i=1;i<2;i++){                      
                      ScgRowEditable(sheetObjects[i], 3, sheetObjects[i].id+"_ts|"+sheetObjects[i].id+"_ts_one_tm_hndl_max_qty|", false);
                  } 
              }else{
                     for(var i=1;i<2;i++){  

                         ScgRowEditable(sheetObjects[i], 3,   sheetObjects[i].id+"_ts|"+sheetObjects[i].id+"_ts_L5|"+sheetObjects[i].id+"_ts_L6|"+ sheetObjects[i].id+"_ts_L7|"+
                                 sheetObjects[i].id+"_ts_L8|"+sheetObjects[i].id+"_ts_one_tm_hndl_max_qty", true);                                  
                         ScgRowClear(sheetObjects[i], 3);       
                     }        
              }
 
              if(  CellValue ( 1, "sheet1_prohi_pass_flg" ) == 1 ){
                  for(var i=1;i<2;i++){             
                    ScgRowEditable(sheetObjects[i], 4, "", false);                      
                  }                      
              }else{
                  for(var i=1;i<2;i++){   //
                         ScgRowEditable(sheetObjects[i], 4, sheetObjects[i].id+"_pass|"+sheetObjects[i].id+"_pass_one_tm_hndl_max_qty|"+sheetObjects[i].id+"_pass_L8", true);                             
                         ScgRowClear(sheetObjects[i], 4);          
                 }   
              }
 
 
              sheetObjects[4].RowEditable( 4 )= true;
              sheetObjects[4].RowEditable( 5 )= true;
              sheetObjects[4].RowEditable( 6 )= true;
              sheetObjects[4].RowEditable( 7 )= true;
 
            Redraw = true;
            }
         }
         if( sheetObj.id == 'sheet2'){
            with(sheetObj){ 
               var sXml = aXml[1];  
 
               var  imdg_cmptn_auth_cd = getSearchRow(sXml, 1, sheetObj.id+"_"+"load_imdg_cmptn_auth_cd");
               
            
               CellValue2( 1, sheetObj.id+"_"+"load_cmptn_auth_cd_p" )  = imdg_cmptn_auth_cd=="P"?"1":"0" ;
               CellValue2( 1, sheetObj.id+"_"+"load_cmptn_auth_cd_d" )  = imdg_cmptn_auth_cd=="D"?"1":"0" ;
               CellValue2( 1, sheetObj.id+"_"+"load_cmptn_auth_cd_n" )  = imdg_cmptn_auth_cd=="N"?"1":"0" ;
                   
               CellValue2( 1, sheetObj.id+"_"+"load_ton_ovr_vol_qty" )  =  getSearchRow(sXml, 1, sheetObj.id+"_"+"load_ton_ovr_vol_qty") ;
               CellValue2( 1, sheetObj.id+"_"+"load_nd_tm_hrs" )        =  getSearchRow(sXml, 1, sheetObj.id+"_"+"load_nd_tm_hrs");

               imdg_cmptn_auth_cd = getSearchRow(sXml, 2, sheetObj.id+"_"+"dis_imdg_cmptn_auth_cd");               
               CellValue2( 2, sheetObj.id+"_"+"dis_cmptn_auth_cd_p" )  = imdg_cmptn_auth_cd=="P"?"1":"0" ;
               CellValue2( 2, sheetObj.id+"_"+"dis_cmptn_auth_cd_d" )  = imdg_cmptn_auth_cd=="D"?"1":"0" ;
               CellValue2( 2, sheetObj.id+"_"+"dis_cmptn_auth_cd_n" )  = imdg_cmptn_auth_cd=="N"?"1":"0" ;
               CellValue2( 2, sheetObj.id+"_"+"dis_ton_ovr_vol_qty" )  =  getSearchRow(sXml, 2, sheetObj.id+"_"+"dis_ton_ovr_vol_qty") ;
               CellValue2( 2, sheetObj.id+"_"+"dis_nd_tm_hrs" )        =  getSearchRow(sXml, 2, sheetObj.id+"_"+"dis_nd_tm_hrs");      
                
               imdg_cmptn_auth_cd = getSearchRow(sXml, 3, sheetObj.id+"_"+"ts_imdg_cmptn_auth_cd");  
   
               CellValue2( 3, sheetObj.id+"_"+"dis_cmptn_auth_cd_p" )  = imdg_cmptn_auth_cd=="P"?"1":"0" ;
                
               CellValue2( 3, sheetObj.id+"_"+"dis_cmptn_auth_cd_d" )  = imdg_cmptn_auth_cd=="D"?"1":"0" ;
               CellValue2( 3, sheetObj.id+"_"+"dis_cmptn_auth_cd_n" )  = imdg_cmptn_auth_cd=="N"?"1":"0" ;
               CellValue2( 3, sheetObj.id+"_"+"dis_ton_ovr_vol_qty" )  =  getSearchRow(sXml, 3, sheetObj.id+"_"+"ts_ton_ovr_vol_qty") ;
               CellValue2( 3, sheetObj.id+"_"+"dis_nd_tm_hrs" )        =  getSearchRow(sXml, 3, sheetObj.id+"_"+"ts_nd_tm_hrs");

               imdg_cmptn_auth_cd = getSearchRow(sXml, 4, sheetObj.id+"_"+"pass_imdg_cmptn_auth_cd");              
               CellValue2( 4, sheetObj.id+"_"+"pass_cmptn_auth_cd_p" )  = imdg_cmptn_auth_cd=="P"?"1":"0" ;
               CellValue2( 4, sheetObj.id+"_"+"pass_cmptn_auth_cd_d" )  = imdg_cmptn_auth_cd=="D"?"1":"0" ;
               CellValue2( 4, sheetObj.id+"_"+"pass_cmptn_auth_cd_n" )  = imdg_cmptn_auth_cd=="N"?"1":"0" ;
               CellValue2( 4, sheetObj.id+"_"+"pass_ton_ovr_vol_qty" )  =  getSearchRow(sXml, 4, sheetObj.id+"_"+"pass_ton_ovr_vol_qty") ;
               CellValue2( 4, sheetObj.id+"_"+"pass_nd_tm_hrs" )        =  getSearchRow(sXml, 4, sheetObj.id+"_"+"pass_nd_tm_hrs");
      
            }
         }   
         if( sheetObj.id == 'sheet3'){
            with(sheetObj){ 
               var sXml = aXml[2]; 
               var cRow = 1;
               CellValue2( cRow, sheetObj.id+"_"+"load_tml_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_tml_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"load_obrd_max_qty" ) =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_obrd_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"load_one_tm_hndl_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_one_tm_hndl_max_qty") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"dis_tml_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_tml_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"dis_obrd_max_qty" ) =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_obrd_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"dis_one_tm_hndl_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_one_tm_hndl_max_qty") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"ts_tml_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_tml_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"ts_obrd_max_qty" ) =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_obrd_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"ts_one_tm_hndl_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_one_tm_hndl_max_qty") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"pass_tml_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_tml_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"pass_obrd_max_qty" ) =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_obrd_max_qty") ;
               CellValue2( cRow, sheetObj.id+"_"+"pass_one_tm_hndl_max_qty" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_one_tm_hndl_max_qty") ;
                   
            }
         }  
         if( sheetObj.id == 'sheet4'){
            with(sheetObj){ 
               var sXml = aXml[3];
               var cRow = 1;
               CellValue2( cRow, sheetObj.id+"_"+"load_txt_desc" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_txt_desc") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"dis_txt_desc" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_txt_desc") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"ts_txt_desc" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_txt_desc") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"pass_txt_desc" )  =  getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_txt_desc") ;             
            }
         } 
         if( sheetObj.id == 'sheet5'){
            with(sheetObj){ 
               var sXmlM = aXml[0]; 
               var sXmlD = aXml[4];
               var cRow = 1;
               CellValue2( cRow, sheetObj.id+"_"+"dir_lod_flg" )  =  getSearchRow(sXmlM, cRow,  "sheet1_"+"dir_lod_flg") ;
 
               CellValue2( cRow, sheetObj.id+"_"+"load_dys_sto_flg" ) =  getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"load_dys_sto_flg") ;
               CellValue2( cRow, sheetObj.id+"_"+"load_sto_dys" )  =  getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"load_sto_dys") ;

               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"dir_dchg_flg" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"dir_dchg_flg") ;
               CellValue2( cRow, sheetObj.id+"_"+"dis_dys_sto_flg" ) =  getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"dis_dys_sto_flg") ;
               CellValue2( cRow, sheetObj.id+"_"+"dis_sto_dys" )  =  getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"dis_sto_dys") ;
               
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"dir_ts_flg" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"dir_ts_flg") ;
               CellValue2( cRow, sheetObj.id+"_"+"ts_dys_sto_flg" ) =  getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"ts_dys_sto_flg") ;
               CellValue2( cRow, sheetObj.id+"_"+"ts_sto_dys" )  =  getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"ts_sto_dys") ;
               
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"prohi_pinsp_flg" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"prohi_pinsp_flg") ;
 
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"xtra_hndl_chg_flg" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"xtra_hndl_chg_flg") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"sft_gad_flg" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"sft_gad_flg") ;
               cRow++;
               CellValue2( cRow, sheetObj.id+"_"+"kep_sft_dist_ihb_flg" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"kep_sft_dist_ihb_flg") ;
               CellValue2( cRow, sheetObj.id+"_"+"kep_sft_dist_ihb_dist" )  =  getSearchRow(sXmlM, 1,  "sheet1_"+"kep_sft_dist_ihb_dist") ;            
               document.form.rstr_rmk.value  =  getSearchRow(sXmlM, 1,  "sheet1_"+"rstr_rmk") ;
            }
         }       
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
               if( sAction  ==  IBSEARCH ){
  
                   if( formObj.port_cd.value  == ""){
                       ComShowCodeMessage( "SCG50007", " Port Code"  );
                       formObj.port_cd.focus();
                       return false;
                   }
 
                   if( formObj.optClass[0].checked   ){
                       if( formObj.imdg_clss_cd.Code == ""){
                           ComShowCodeMessage( "SCG50011", " Class"  );
                           formObj.imdg_clss_cd.focus();
                           return false;
                       }
                   }else{
                   
                       if( formObj.imdg_un_no.value == "" ){
                           ComShowCodeMessage( "SCG50007", " UN No."  );
                           formObj.imdg_un_no.focus();
                           return false;
                       }  
                       if( formObj.imdg_un_no.value.length != 4 ){
                           ComShowCodeMessage( "SCG50006", "UN No.", "4"  );
                           formObj.imdg_un_no.select();
                           return false;
                       }                           
                       if( formObj.imdg_un_no_seq.value == "" ){
                           ComShowCodeMessage( "SCG50007", " UN No./Seq."  );
                           formObj.imdg_un_no_seq.focus();
                           return false;
                       }                       
 
                   }
               } 
               if( sAction  ==  IBDELETE ){
                   if ( document.all.btn_delete.className == "btn1_1" ){
                       return false;
                   }
                   if( formObj.imdg_port_rstr_seq.value == ""){
                       return false;
                   } 
                   if( !ComShowCodeConfirm('SCG50002' , 'data' ) ){
                       return false;
                   }
               }
               if( sAction  ==  IBSAVE ){
                   if( formObj.port_cd.value  == ""){
                       ComShowCodeMessage( "SCG50007", " Port Code"  );
                       formObj.port_cd.focus();
                       return false;
                   }             
                   if( formObj.optClass[0].checked   ){
                       if(  formObj.imdg_clss_cd.Text == ""  ){
                           ComShowCodeMessage( "SCG50011", " Class"  );//'Please select {?msg1}';
                           formObj.imdg_clss_cd.focus();
                           return false;                              
                       }
                   }else{
                       
                       if(  formObj.imdg_un_no.value == ""   ){
                           ComShowCodeMessage( "SCG50007", " UN No."  );//'Please input {?msg1}.'
                           formObj.imdg_un_no.focus();
                           return false;                              
                       }
                       if( formObj.imdg_un_no.value.length != 4 ){
                           ComShowCodeMessage( "SCG50006", " UN No.","4"  );
                           formObj.imdg_un_no.select();
                           return false;
                       }                       
                       if(  formObj.imdg_un_no_seq.value == "" ){
                           ComShowCodeMessage( "SCG50007", " UN No./Seq."  );//'Please input {?msg1}.'
                           formObj.imdg_un_no_seq.focus();
                           return false;       
                       } 
                       
                   }
 
                     
                   var cByte = ComGetLenByByte(formObj.rstr_rmk  );
                   if ( cByte > 4000  ){
                       ComShowCodeMessage("COM12142", "［Remark(s)］", "4000byte (Current:"+cByte+")");
                       formObj.rstr_rmk.focus();
                       return false;
                   }
                   if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
                       return false;   
                   }
                   for(var i =0;i<sheetObjects.length;i++){
                       var ibflag = sheetObjects[i].RowStatus(0);
                       if( ibflag == "U"){
                           sheetObjects[0].RowStatus[0] = "U";   
                       }
                   }
               }               
               
         }

         return true;
     }
     
    // 셀의 값이 바뀌었을 때 발생하는 이벤트
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {  
        with(sheetObj)
        {
         
             if( ColSaveName(Col) == sheetObj.id+"_prohi_lod_flg" ){
 
                 if( Value == 1 ){
                      for(var i=1;i<2;i++){
                          ScgRowClear(sheetObjects[i], 1);                                
                          ScgRowEditable(sheetObjects[i], 1, "", false);
                      }
                 }else{
                     
                      for(var i=1;i<2;i++){
                          ScgRowEditable(sheetObjects[i], 1, sheetObjects[i].id+"_load", true);                               
                          ScgRowClear(sheetObjects[i], 1);      
                      }                         
                 }
             }
             if( ColSaveName(Col) == sheetObj.id+"_prohi_dchg_flg"  ){
                 if( Value == 1){
                     for(var i=1;i<2;i++){      
                          ScgRowClear(sheetObjects[i], 2);                               
                          ScgRowEditable(sheetObjects[i], 2, "", false);
                     }
                 }else{
                    for(var i=1;i<2;i++){   
                        ScgRowEditable(sheetObjects[i], 2, sheetObjects[i].id+"_dis", true);                            
                        ScgRowClear(sheetObjects[i], 2);      
                        
                    }                       
                 }
             } 
             if( ColSaveName(Col) == sheetObj.id+"_prohi_ts_flg"  ){
 
                 if( Value == 1){
                     for(var i=1;i<2;i++){                       
                         ScgRowClear(sheetObjects[i], 3);   
                         ScgRowEditable(sheetObjects[i], 3,   "", false);
                     }
                 }else{
                     for(var i=1;i<2;i++){  
 
                         ScgRowEditable(sheetObjects[i], 3,   sheetObjects[i].id+"_ts|"+sheetObjects[i].id+"_ts_L5|"+sheetObjects[i].id+"_ts_L6|"+ sheetObjects[i].id+"_ts_L7|"+
                                 sheetObjects[i].id+"_ts_L8|"+sheetObjects[i].id+"_ts_one_tm_hndl_max_qty", true);                                     
                     }                          
                 }
             }
             if( ColSaveName(Col) == sheetObj.id+"_prohi_pass_flg"  ){
                 if( Value == 1){
                      for(var i=1;i<2;i++){     
                         ScgRowClear(sheetObjects[i], 4);                                 
                         ScgRowEditable(sheetObjects[i], 4,   "", false);
                      }
                 }else{
                      for(var i=1;i<2;i++){   //
                         ScgRowEditable(sheetObjects[i], 4, sheetObjects[i].id+"_pass|"+sheetObjects[i].id+"_pass_one_tm_hndl_max_qty|"+sheetObjects[i].id+"_pass_L8", true); 
                      }                         
                 }
             }               
        }
                            
    }
    /**
     * 
     */
 
    /**
     *   Cell당 클리어 하기 .
     * @param sheetObj
     * @param Row
     * @return
     */
    function ScgRowClear(sheetObj, Row){
        var Col = sheetObj.LastCol;
 
        for(var i=0;i<= Col;i++){
             if (  sheetObj.CellEditable(Row, i) == true  ){
                 if( sheetObj.id == 'sheet5'){
                      if( Row == 3){
                         sheetObj.CellValue2(Row, 2) = 0;
                         sheetObj.CellValue2(Row, 6) = 0;
                      }
                 }
                 if ( sheetObj.ReadDataProperty(Row, i, dpDataType) ==  dtCheckBox  ){

                      sheetObj.CellValue2(Row, i) = 0;
                 }       
                 if ( sheetObj.ReadDataProperty(Row, i, dpDataType) ==  dtData  ){
                     
                    sheetObj.CellValue2(Row, i) = "";
                
                 }
             }
        }
    }
 
    // 셀의 값이 바뀌었을 때 발생하는 이벤트
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {  
        with(sheetObj)
        {
         
             if( ColSaveName(Col) == sheetObj.id+"_load_cmptn_auth_cd_p" ){
                 if( Value == 1 ){
                     CellValue2( Row, sheetObj.id+"_load_cmptn_auth_cd_d" ) = 0;
                     CellValue2( Row, sheetObj.id+"_load_cmptn_auth_cd_n" ) = 0;
                 } 
             }
             if( ColSaveName(Col) == sheetObj.id+"_load_cmptn_auth_cd_d" ){
                 if( Value == 1 ){
                     CellValue2( Row, sheetObj.id+"_load_cmptn_auth_cd_p" ) = 0;
                     CellValue2( Row, sheetObj.id+"_load_cmptn_auth_cd_n" ) = 0;
                 } 
             }
             if( ColSaveName(Col) == sheetObj.id+"_load_cmptn_auth_cd_n" ){
                 if( Value == 1 ){
                     CellValue2( Row, sheetObj.id+"_load_cmptn_auth_cd_p" ) = 0;
                     CellValue2( Row, sheetObj.id+"_load_cmptn_auth_cd_d" ) = 0;
                 } 
             }               
             
        }
    }  
    /**
     * Form 내의 Object Onchange 이벤트시 처리.
     * 
     * @return void
     */
     function obj_change(){
        obj = event.srcElement;
        var formObj = document.form;
        //alert(obj.name);
        switch(obj.name ) {
            case "optClass":
//              for(var i =0;i<sheetObjects.length;i++){
//              //    setInitValue(sheetObjects[i], true);
//              }
//              break;
//          case "imdg_un_no_seq":
//               if( document.form.imdg_un_no.value.length  == 4  && document.form.imdg_un_no_seq.value.length  != ""    ){
//                       doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
//                   }  
//               break;
//           case "imdg_un_no":
//               if( formObj.imdg_un_no.value.length  == 4    ){
//                   doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);
//               }
//               break;                 
        } // end switch 
     } 
    /**
     * Form 내의 Object OnBLur 이벤트시 처리.
     * 
     * @return void
     */        
     function obj_blur(){ 
         obj = event.srcElement;
         var formObj = document.form;
 
         switch( obj.name ) {
             case "port_cd":
                 if( formObj.port_cd.value != ""    ){
                     if(!ComChkObjValid(obj)){       
                         obj.focus(); 
                         obj.select();                          
                         return false;
                     }
                 }
                 break;          
            case "imdg_un_no":
                 if( formObj.imdg_un_no.value != ""    ){
                     if(!ComChkObjValid(obj)){       
                         obj.focus(); 
                         obj.select();                          
                         return false;
                     }
 
                 }
                 break;
            case "imdg_un_no_seq":
            
                 if( formObj.imdg_un_no.value.length  == 4  && formObj.imdg_un_no_seq.value.length  != ""    ){
                     doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
                 }  
                 break;              
         }
     }
     function obj_click(){
 
        var obj = event.srcElement;
        if(obj.name == "optClass"){
            if(obj.value == "class"){
                initClass();
                fnGridEnble(false);
            }
            if(obj.value == "unno"){
                initUnno();
                fnGridEnble(false);
            }
        }    
      }
    /**
     * Form 내의 Object Onkeyup 이벤트시 처리.
     * 
     * @return void
     */     
      function obj_keyup(){
         obj = event.srcElement;
         var formObj = document.form;
 
         switch(obj.name ) {
       
            case "imdg_un_no":
                fnGridEnble(false);
                formObj.imdg_un_no_seq.value = "";
                formObj.prp_shp_nm.value     = ''; 
                formObj.imdg_clss_cd.Code2 = "";
                formObj.imdg_clss_cd_desc.value = "";              
    
                
                 if( formObj.imdg_un_no.value.length  == 4     ){
                     fnGridEnble(false);
                     formObj.imdg_un_no_seq.value = '';    
                     formObj.prp_shp_nm.value     = '';                     
                     formObj.imdg_un_no_seq.focus();
                     formObj.imdg_clss_cd.Code2 = "";
                     formObj.imdg_clss_cd_desc.value = "";               
                     
                     if( formObj.imdg_un_no.value.length  == 4     ){
                         doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);
                     }
                 }  
 
                break;
            case "imdg_un_no_seq":
                 fnGridEnble(false);

                 if( formObj.imdg_un_no_seq.value == '' ){
                     formObj.imdg_un_no_seq.value = "";
                 }
                 formObj.prp_shp_nm.value     = ''; 
                 formObj.imdg_clss_cd.Code2 = "";
                 formObj.imdg_clss_cd_desc.value = "";              
                 break;
             
                 
            case "port_cd"://Un No 또는 Seq 입력시 prp_shp_nm 가져오기

                 if( document.form.port_cd.value.length  == 5    ){
 
                       formObj.port_cd_nm.value = "";
                       formObj.imdg_clss_cd.Code2 = "";
                       formObj.imdg_clss_cd_desc.value = "";
                       formObj.imdg_un_no.value = '';
                       formObj.imdg_un_no_seq.value = '';    
                       formObj.prp_shp_nm.value = '';                       
 
                       fnGridEnble(false);
                       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);                       

                 }          
                 break;
             
         } // end switch

     }        
    /**
     * 
     */
     function obj_keypress(){
        obj = event.srcElement;
        var formObj = document.form;
        switch(obj.name ) {
            case "port_cd":  
                  ComKeyOnlyAlphabet('uppernum');  
                 break;
                 
        } // end switch
     }
     /**
      * Mouse down 처리 이벤트
      * @return
      */
     function mouse_down(){
         var obj = event.srcElement;
         var formObj = document.form;
         switch ( obj.id ){
            case "btn_Retrieve":                
                callbackEvent = "btn_Retrieve";     
            break;
         }
     }
     function img_click(){
        var obj = event.srcElement;
 
        if(obj.name == "srch_port_cd"){
        	var port_cd = document.form.port_cd.value; 
        	ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "setPortCd", "0,0", true);
        }    
 
        if(obj.name == "srch_imdg_un_no"){
             var imdg_un_no =  document.form.imdg_un_no.value;
             var imdg_un_no_seq =  document.form.imdg_un_no_seq.value; 
             ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
        }          
    } 
   /**
    * Unno Help 팝업으로 Unno, seq, ClassCd 구하기 
    * @param  {Array} aryPopupData  필수   Array Object
    * @param  {Int} row             선택 선택한 Row
    * @param  {Int} col             선택 선택한 Column
    * @param  {Int} sheetIdx        선택 Sheet Index
    * @return 없음
    */  
    function setUnnoAndClassCd(aryPopupData){
        with(document.form){
            //imdg_clss_cd.Text2    = aryPopupData[0][4]; 
            imdg_un_no.value     = aryPopupData[0][2];      
            imdg_un_no_seq.value = aryPopupData[0][3];                  
            prp_shp_nm.value     = aryPopupData[0][6]; 
            imdg_un_no_seq.focus();
            imdg_un_no_seq.select();
            //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);              
        }
    }
    function setPortCd(aryPopupData){
 
        with(document.form){
            port_cd.value = aryPopupData[0][2];
            doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);               
        }
    }    
 
   
    /**
     * 
     */
     function OnSearchEnd(obj, msg){
        // alert( msg );
     }
    /**
     *  OptClass 항목설정으로 인한 조회 옵션 Class style 변경 
     * @return
     */
    function initClass(){
            var formObj = document.form;
 
            
            
            formObj.imdg_clss_cd.DisabledBackColor = "#E8E7EC"; 
            formObj.imdg_clss_cd.Enable = true;      
            
            formObj.imdg_un_no.className          = 'input2';
            formObj.imdg_un_no.readOnly           = true;
            formObj.imdg_un_no_seq.className      = 'input2';
            formObj.imdg_un_no_seq.readOnly       = true;
            //formObj.srch_imdg_un_no.style.display = "none"; 
             
            formObj.imdg_un_no.value     = '';
            formObj.imdg_un_no_seq.value = '';
            formObj.prp_shp_nm.value = '';          
 
            ComEnableObject( document.all.srch_imdg_un_no, false);
//          document.all.srch_imdg_un_no.src =  '/hanjin/img/btns_search_off.gif';   
//          document.all.srch_imdg_un_no.className='';
 
    }     
    /**
     *  OptClass 항목설정으로 인한 조회 옵션 Class style 변경 
     * @return
     */
    function initUnno(){
        var formObj = document.form;
        formObj.imdg_clss_cd.DisabledBackColor = "#eeeeee"; 
        formObj.imdg_clss_cd.Enable = false;     
        
        formObj.imdg_clss_cd.Text2 = "";            
        formObj.imdg_clss_cd_desc.value = "";       
        
        formObj.imdg_un_no.className= 'input1';
        formObj.imdg_un_no.readOnly = false;
        formObj.imdg_un_no_seq.className= 'input1';
        formObj.imdg_un_no_seq.readOnly = false;        
        formObj.srch_imdg_un_no.style.display = ""; 
 
        formObj.imdg_un_no.focus();
        formObj.imdg_un_no.select();    
        
        ComEnableObject( document.all.srch_imdg_un_no, true);       
//      document.all.srch_imdg_un_no.src =  '/hanjin/img/btns_search.gif';   
//      document.all.srch_imdg_un_no.className='Cursor';        
    }    
    
 
     
     /**
      * Class 콤보 OnChange 이벤트 처리.
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
     function imdg_clss_cd_OnChange(comboObj,value,text) {
         var aText = text.split("|");
         document.form.imdg_clss_cd_desc.value = aText[1] ; 
         fnGridEnble(false);
     }
   
       
      /**
       * 한줄 xml 가져오기 
       *    savename 복수일경우 | 사용.
       * @param xmlStr
       * @param savename
       * @return
       */
      function getSearchRow(xmlStr, cRowIndx, savename)  {
          if (xmlStr == null || xmlStr == ""  ) {
               return;
          }
          if (savename  == null || savename == ""  ) {
              return;
          }
          try {
                var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
                xmlDoc.loadXML(xmlStr);

                var xmlRoot = xmlDoc.documentElement;
                if (xmlRoot == null) {
                        return;
                }

                var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
                if (dataNode == null || dataNode.attributes.length < 3) {
                        return;
                }
                
                var col = dataNode.getAttribute("COLORDER");
                var colArr = col.split("|");
                var sep = dataNode.getAttribute("COLSEPARATOR");
                var dataChildNodes = dataNode.childNodes;
                if (dataChildNodes == null) {
                        return;
                }
                //getSearchRow(sXml, 3, sheetObj.id+"_"+"ts_imdg_cmptn_auth_cd"); 
                var colListIdx = Array();
                var arrText = savename.split("|");
                for (var i = 0; i < colArr.length; i++) {
                        for (var j = 0; j < arrText.length; j++) {
                                if (colArr[i] == arrText[j]) {
                                        colListIdx[j] = i;
                                }
                        }
                }

                var TOTAL_ROWS = eval( dataNode.getAttribute("TOTAL") );
   
                if(  cRowIndx   >  TOTAL_ROWS ){
                    return "";
                }
                var arrData = dataChildNodes[cRowIndx-1].firstChild.nodeValue.split(sep);
 
                var trData = "";
                for (var j = 0; j < colListIdx.length; j++) {
                        trData += arrData[colListIdx[j]];
                }
                return trData;
          } catch (err) {
                 ComFuncErrMsg(err.message);
         }               
    }
   function getColOrder(xmlStr)  {
 
        try {
             var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
             xmlDoc.loadXML(xmlStr);

             var xmlRoot = xmlDoc.documentElement;
             if (xmlRoot == null) {
                     return;
             }

             var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
             if (dataNode == null || dataNode.attributes.length < 3) {
                     return;
             }
             
             var col = dataNode.getAttribute("COLORDER");
  
             return col;
       } catch (err) {
              ComFuncErrMsg(err.message);
       }               
 }
   function getTotal(sXml){
        if ( sXml == null  || sXml == "" ) return;

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(sXml);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
          
            if(dataNode == null) return "";

            return dataNode.getAttribute("TOTAL");
        } catch(err) { ComFuncErrMsg(err.message); }
    }   
   function getMessage(sXml){
        if ( sXml == null  || sXml == "" ) return;

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(sXml);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;
 
            var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
          
            if(msgNode == null) return "";

            return msgNode.firstChild.nodeValue;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
   function getTrAllValue(sXml){
        if ( sXml == null  || sXml == "" ) return;

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(sXml);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;

            var msgNode = xmlRoot.getElementsByTagName("TR-ALL").item(0);
          
            if(msgNode == null) return "";

            return msgNode.firstChild.nodeValue;
        } catch(err) { ComFuncErrMsg(err.message); }
    }  
 
   /**
    *  행 Editable 
    * @param sheetObj
    * @param cRow  행 
    * @param cCols 제외열  ex) aaa|bbb|
    * @return
    */
   function ScgRowEditable(sheetObj, cRow, cSaveNames, tf){
 
       var aSaveNames = cSaveNames.split("|");
 
       sheetObj.RowEditable(cRow) = tf;    
       for(var i=0;i<aSaveNames.length;i++){
 
           var switchvalue = !tf;
           sheetObj.CellEditable(cRow, aSaveNames[i] ) = switchvalue;
       }
   }
    /**
     * 그리드 Enable = true or false
     */    
    function fnGridEnble( yn ){
        var formObj = document.form;
        if( yn ){
            for(i=0;i<sheetObjects.length;i++){
                setInitValue(sheetObjects[i], true);                          
            }
        }else{
            fnNewGrid();   
            formObj.rstr_rmk.value = "";
        }

    }
     /**
      * 
      * <pre>
      *    Grid 데이타 크리어 
      * </pre>
      *
      * @param   
      * @return
      * @author jang kang cheol
      */
     function fnNewGrid(){
         for(var i=0;i<sheetObjects.length;i++){
             var cnt = sheetObjects[i].RowCount;
 
             for(var j=1;j<= cnt;j++ ){
                 sheetObjects[i].RowDelete(1, false);
             }
         }
         document.form.imdg_port_rstr_seq.value = "";
     }     
   /***************************************
    * CmptnAuthCd 셋팅오기 
    *
    * @param void
    * @return boolean
    ***************************************/
    function setCmptnAuthCd (){
         var load_cmptn_auth_cd = "";
         var dis_cmptn_auth_cd  = "";
         var ts_cmptn_auth_cd   = "";
         var pass_cmptn_auth_cd = "";         
 
         if (sheetObjects[1].CellValue (1, "sheet2_load_cmptn_auth_cd_p" ) ){ 
          	 if (ComLtrim(sheetObjects[3].CellValue (1, "sheet4_load_txt_desc" )) == "" ){
        		 ComShowCodeMessage("SCG50042");
                 return false;        		 
        	 }        	 
            load_cmptn_auth_cd = "P";
         }
         
         if (sheetObjects[1].CellValue (1, "sheet2_load_cmptn_auth_cd_d" ) ){
                load_cmptn_auth_cd = "D";
         }
         if (sheetObjects[1].CellValue (1, "sheet2_load_cmptn_auth_cd_n" ) ){
                load_cmptn_auth_cd = "N";
         }  
         
         if (sheetObjects[1].CellValue (2, "sheet2_dis_cmptn_auth_cd_p" ) ){
          	 if (ComLtrim(sheetObjects[3].CellValue (2, "sheet4_dis_txt_desc" )) == "" ){
        		 ComShowCodeMessage("SCG50042");
                 return false;        		 
        	 } 
             dis_cmptn_auth_cd = "P";
         }
         if (sheetObjects[1].CellValue (2, "sheet2_dis_cmptn_auth_cd_d" ) ){
             dis_cmptn_auth_cd = "D";
         }
         if (sheetObjects[1].CellValue (2, "sheet2_dis_cmptn_auth_cd_n" ) ){
             dis_cmptn_auth_cd = "N";
         }  
         
         if (sheetObjects[1].CellValue (3, "sheet2_ts_cmptn_auth_cd_p" ) ){
          	 if (ComLtrim(sheetObjects[3].CellValue (3, "sheet4_ts_txt_desc" )) == "" ){
        		 ComShowCodeMessage("SCG50042");
                 return false;        		 
        	 } 
             ts_cmptn_auth_cd = "P";
         }
         if (sheetObjects[1].CellValue (3, "sheet2_ts_cmptn_auth_cd_d" ) ){
             ts_cmptn_auth_cd = "D";
         }
         if (sheetObjects[1].CellValue (3, "sheet2_ts_cmptn_auth_cd_n" ) ){
             ts_cmptn_auth_cd = "N";
         } 
         
         if (sheetObjects[1].CellValue (4, "sheet2_pass_cmptn_auth_cd_p" ) ){
          	 if (ComLtrim(sheetObjects[3].CellValue (4, "sheet4_pass_txt_desc" )) == "" ){
        		 ComShowCodeMessage("SCG50042");
                 return false;        		 
        	 } 
             pass_cmptn_auth_cd = "P";
         }
         if (sheetObjects[1].CellValue (4, "sheet2_pass_cmptn_auth_cd_d" ) ){
             pass_cmptn_auth_cd = "D";
         }
         if (sheetObjects[1].CellValue (4, "sheet2_pass_cmptn_auth_cd_n" ) ){
             pass_cmptn_auth_cd = "N";
         }   
     
         document.form.load_imdg_cmptn_auth_cd.value = load_cmptn_auth_cd;
         document.form.dis_imdg_cmptn_auth_cd.value  = dis_cmptn_auth_cd;
         document.form.ts_imdg_cmptn_auth_cd.value   = ts_cmptn_auth_cd;
         document.form.pass_imdg_cmptn_auth_cd.value = pass_cmptn_auth_cd;
         
         return true;
  
    }
    /* 개발자 작업  끝 */