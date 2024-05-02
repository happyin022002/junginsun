/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0039.js
*@FileTitle : Monthly Clearance Status by Carrier & Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.29 장강철
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
     * @class fns_joo_0039 : fns_joo_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0039() {
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

                 case "btn1_Retrieve":
 
                     doActionIBSheet(sheetObjects[0],formObject,IBSEARCH); 
                     break;
                 
                 case "btn1_New":
                     doActionIBSheet(sheetObjects[0],formObject,IBRESET);  
                     break;

                 case "btn1_Down_Excel":
                     //sheetObjects[1].Down2Excel(0, false,false,true,"","",false,false,"sheet1", true);
 
 
                      var rev_dir_cd_nm = "";
                      if(  formObject.rev_dir_cd[0].checked == true){//0:R 
                          rev_dir_cd_nm = "REVENUE";  
                      }else if(  formObject.rev_dir_cd[1].checked == true){//1:E
                          rev_dir_cd_nm = "EXPENSE";
                      }
                      var strTitle = "Account Month : "+formObject.acct_yrmon.value+"    Carrier : "+formObject.jo_crr_cd.Code+"    R/E : "+rev_dir_cd_nm;
                      sheetObjects[1].SetMergeCell(0, 1, 1, 9); 
                      sheetObjects[1].CellValue(0,1)  = strTitle;
                      sheetObjects[1].RowHidden(0) = false;
                      sheetObjects[1].Down2Excel(-1, false);
                      sheetObjects[1].RowHidden(0) = true;
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
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {
 
         var formObject = document.form;
        
         axon_event.addListener    ('click',   'fnDocClick', "btn_back"  );         
         axon_event.addListener    ('click',   'fnDocClick', "btn_next"  );  
         
         axon_event.addListenerForm    ('keypress',   'fnObjKeyPress', formObject );     
         axon_event.addListenerForm    ('click',     'fnObjClick'  , formObject );            
         
         axon_event.addListenerFormat('deactivate', 'fn_deactivate',  formObject);  
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
                     //style.height = 540;
                     style.height = 438;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);



                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|Lane|CFM";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo( ComCountHeadTitle(HeadTitle), 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,       false,      "ibflag");
                     InitDataProperty(0, cnt++ , dtData,          70,    daCenter,       false,      "rlane_cd",       false,      "",         dfNone,         0,          false,       true);
                     InitDataProperty(0, cnt++ , dtCheckBox,      40,    daCenter,       false,      "cfm",            false,      "",         dfNone,         0,          true,       true);

                }
                 break;
             case 2:      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 //style.height = 540;
                 style.height = 438;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 3, 100);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle2 = "";                 
                 var HeadTitle  = "|ITEM|ITEM|ITEM|LANE|CUR.|VVD|BSA|Price|Amount|Remark";


                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo( ComCountHeadTitle(HeadTitle), 7, 0, true);
                 
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle2, false);
                 InitHeadRow(1, HeadTitle , true);

                 //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME           ,KEYFIELD, CALCULOGIC,  DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,       false,      "ibflag");
                 InitDataProperty(0, cnt++ , dtData,        160,    daLeftTop,      true,       "jo_stl_itm_cd_nm",   false,      "",         dfNone,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtHidden,       90,    daLeftTop,      false,      "sub_sum_nm"      ,   false,      "",         dfNone,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtHidden,       90,    daLeftTop,      false,      "jo_stl_itm_cd"   ,   false,      "",         dfNone,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtData,         50,    daCenter,       false,      "rlane_cd"        ,   false,      "",         dfNone,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtData,         40,    daCenter,       false,      "locl_curr_cd"    ,   false,      "",         dfNone,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtData,         80,      daLeft,       false,      "vvd"             ,   false,      "",         dfNone,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtData,         50,      daRight,      false,      "bsa_qty"         ,   false,      "",  dfNullInteger,           0,       false,       true);
                 InitDataProperty(0, cnt++ , dtData,         60,     daRight,       false,      "bsa_slt_prc"     ,   false,      "",    dfNullFloat,           2,       false,       true);
                 InitDataProperty(0, cnt++ , dtAutoSum,     120,     daRight,       false,      "stl_locl_amt"    ,   false,      "",    dfNullFloat,           2,       false,       true);
                 InitDataProperty(0, cnt++ , dtData,        460,      daLeft,       false,      "stl_rmk"         ,   false,      "",         dfNone,           0,       false,       true);
                
                 RowHidden(0) = true;
                 
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
                   var sXml  =  sheetObj.GetSearchXml("FNS_JOO_0039GS.do", param);
                   ComXml2ComboItem( sXml, formObj.jo_crr_cd, "code","code" );
                   break;      
                   
              case IBSEARCH:      //조회
                   if( !validateForm(sheetObj,formObj,sAction) ){return;}
                   formObj.f_cmd.value = SEARCHLIST01;            
                   var param =  FormQueryString(formObj);  
                   sheetObj.DoSearch("FNS_JOO_0039GS.do", param);
                   if( sheetObjects[1].RowCount  > 0) {
                       sheetObjects[1].RemoveAll();
                   } 

                   break;
                   
              case SEARCHLIST02:     
                  formObj.f_cmd.value = SEARCHLIST02;            
                  var sParam  =  ComGetSaveString(sheetObjects[0]);                  
                  if( sParam == ""){ return;}
                  sParam +="&"+FormQueryString(formObj);
                  sheetObj.DoSearch("FNS_JOO_0039GS.do", sParam);
                  //sheetObj.ShowSubSum("sub_sum_nm", "stl_locl_amt" );JO_STL_ITM_CD_NM
                  sheetObj.ShowSubSum("jo_stl_itm_cd_nm", "stl_locl_amt" );
                  
                 // sheetObj.FitColWidth();
                  break;                     


              case IBSAVE:        //저장
                   break;
 

              case IBSEARCH_ASYNC01:      //Trade Combo List
                  formObj.f_cmd.value = SEARCHLIST06;            
                  var super_cd1 = formObj.jo_crr_cd.Text;
                  var param =  FormQueryString(formObj)+"&super_cd1="+super_cd1;
                  var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                  ComXml2ComboItem( sXml, formObj.trd_cd, "code","code" );
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

                     if (formObj.trd_cd.Index == -1){
                         ComShowCodeMessage('JOO00009');
                         formObj.trd_cd.focus();
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
     * 
     * <pre>
     *     Sheet2 DblClick 이벤트 처리.
     * </pre>
     *
     * @param   sheetObj 
     * @param   Row
     * @param   Col
     * @return  void
     * @author  jang kang cheol
     */
    function sheet2_OnDblClick(sheetObj, Row, Col ){
        var value  = sheetObj.CellValue(Row,Col);
        if(value == ""){return;}
        if( sheetObj.ColSaveName(Col) == "stl_rmk"){
            ComShowMemoPad(sheetObj, Row, Col, true);
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
        if( formObj.jo_crr_cd.value != ""){
             formObj.trd_cd.RemoveAll();
             fnGridClear();            

        }
    }
     function trd_cd_OnFocus(comboObj ) {
         var formObj = document.form;
         if(formObj.jo_crr_cd.Code ==""){return;}
         if (comboObj.GetCount()== 0) {
             comboObj.Enable = false;
             doActionIBSheet(sheetObjects[ sheetObjects.length-1 ],formObj,IBSEARCH_ASYNC01);
             comboObj.Enable = true;
         }
     }
     /**
     * Trade Code 콤보 OnChange 이벤트 처리.
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
    function trd_cd_OnChange(comboObj,value,text) {
        var formObj = document.form;
        if( formObj.trd_cd.value != ""){
             fnGridClear();    
        }
    }     

//    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
//        var formObj = document.form;
//        var TITLE_GB = "";
//
//        for(var i=2;i<sheetObj.RowCount; i++ ){
//            var row = 0;
//            if( TITLE_GB != sheetObj.CellValue(i, "jo_stl_itm_cd") ){
//                var tmpTitle =  sheetObj.CellValue(i, "jo_stl_itm_cd_nm");
//                row = sheetObj.DataInsert(i-1);   //빈Row 만들기. 
//                if(  sheetObj.CellValue(row+1, "jo_stl_itm_cd") == "S/H"){
//                    sheetObj.CellValue(row, "sub_sum_nm")       =   sheetObj.CellValue(row+1, "sub_sum_nm");             
//                }
//                //OUS : Over Used Slot Hire  or R/F : Reefer Surcharge
//                if(  sheetObj.CellValue(row+1, "jo_stl_itm_cd") == "OUS"){
//                    sheetObj.CellValue(row, "jo_stl_itm_cd_nm") =   sheetObj.CellValue(row+1, "jo_stl_itm_cd_nm").trim().substring(0,2)+" Over Used Slot Hire";
//                    sheetObj.CellValue(row, "sub_sum_nm")       =   sheetObj.CellValue(row+1, "sub_sum_nm");
//                }else if(  sheetObj.CellValue(row+1, "jo_stl_itm_cd")== "R/F"){
//                    sheetObj.CellValue(row, "jo_stl_itm_cd_nm" ) = sheetObj.CellValue(row+1, "jo_stl_itm_cd_nm").trim().substring(0,2)+" Reefer Surcharge";
//                    //sheetObj.CellValue(row, "jo_stl_itm_cd")    =  "R/F";
//                    sheetObj.CellValue(row, "sub_sum_nm")       =   sheetObj.CellValue(row+1, "sub_sum_nm");
//                }else{
//                    sheetObj.CellValue(row, "jo_stl_itm_cd_nm") = tmpTitle;
//                }
//                TITLE_GB = sheetObj.CellValue(row+1, "jo_stl_itm_cd");                
//            }     
// 
//        }
//    }        
    /**************************************USER FUNCTION *****************************************************/
    /**
     * NEW 버튼 처리 
     * @param    void
     * @return   void
     */    
     function fnBtnNew(){
         var formObj = document.form;
        formObj.jo_crr_cd.Text2  = "";
       //  formObj.jo_crr_cd.Text2 = formObj.jo_crr_cd.GetIndexText(0, 0); 
        // comboObjects[0].Index2 = "0";
         formObj.trd_cd.Text2     = "";
         formObj.rev_dir_cd.value = "";
         formObj.acct_yrmon.value = yyyyMM; 
         
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
         if( sheetObjects[0].RowCount  > 0) {
             sheetObjects[0].RemoveAll();
         }
         if( sheetObjects[1].RowCount  > 0) {
             sheetObjects[1].RemoveAll();
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
                     fnGridClear();
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
                 case 'rev_dir_cd':
                     fnGridClear();
                     break;
          }
      }
         
       
	/* 개발자 작업  끝 */