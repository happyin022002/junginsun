/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0079.js
*@FileTitle : Authority Office Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철
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
     * @class FNS_JOO_0079 : FNS_JOO_0079 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0079() {
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
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObject = document.form;
          var doc = document.all;
         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
 
                case "btn_delete":
 
                     if(    doc.btn_delete.className == "btn2_1"){
                         return;
                     }
                     sheetObject.RowDelete( sheetObject.SelectRow, false);
                 break;  
   
                
                 case "btn_copy":
                     if(    doc.btn_copy.className == "btn2_1"){
                         return;
                     }
                     sheetObjects[0].DataCopy();
                 break;   
                 case "btn_Retrieve":
                     doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
                     break;

                 case "btn_Save":
                     doActionIBSheet(sheetObjects[0],document.form, IBSAVE);
                     break;

                 case "btn_DownExcel":
                     var paramObj = new Object();
                     paramObj.cols = 10;
                     var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
                     sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );           
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
                       MultiSelect     = false;  
                       UseAutoComplete = true;    
                       SetColAlign("left");        
                       SetColWidth("60");
                       DropHeight = 200;
                       ValidChar(2,1);                                             
                   }  
                   break;    
              case "auth_ofc_cd": 
                  with (comboObj) {
                       MultiSelect     = false;  
                       UseAutoComplete = true;    
                       SetColAlign("left");        
                       SetColWidth("60");
                       DropHeight = 200;
                       ValidChar(2,0);                                             
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
             
         }
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }       
     }
      
      function sheet1_OnLoadFinish(sheetObj) {
          var formObj = document.form; 
          doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
      }
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetObj.id) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 412;
                    
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                      var HeadTitle1 = "|Carrier\nCode|Trade|Lane|Service\nProvider|Customer\nCode|Service Provider/\nCustomer Name|Authority Office|Authority Code|DEL_MK";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,            WIDTH,      DATAALIGN,      COLMERGE,       SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                     InitDataProperty(0, cnt++ , dtHiddenStatus,       0,          daCenter,       true,           "Status");
                     InitDataProperty(0, cnt++ , dtHiddenStatus,       0,          daCenter,       true,           "ibflag");
                     InitDataProperty(0, cnt++ , dtData,         60,         daCenter,       true,           "jo_crr_cd",          false,          "",      dfNone,      0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,         50,         daCenter,       true,           "trd_cd",             false,          "",      dfNone,      0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,         50,         daCenter,       true,           "rlane_cd",           false,          "",      dfNone,      0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,         70,         daCenter,        true,           "vndr_seq",           false,          "",      dfNone,      0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,         80,         daCenter,        true,           "crm_row_id",         false,          "",      dfNone,      0,     false,       false);

                     InitDataProperty(0, cnt++ , dtData,        360,        daLeft,         true,           "vndr_lgl_eng_nm",  false,          "",      dfNone,      0,     false,       false);
                     InitDataProperty(0, cnt++ , dtPopupEdit,   110,        daCenter,       true,           "auth_ofc_cd",        true,          "",      dfEngUpKey,      0,     true,       true, 6);
                     InitDataProperty(0, cnt++ , dtComboEdit,   110,        daCenter,       true,           "jo_crr_auth_cd",     true,          "",      dfNone,      0,     true,       true);
                     InitDataProperty(0, cnt++ , dtComboEdit,    10,        daCenter,       true,           "delt_flg"      ,     true,          "",      dfNone,      0,     true,       true);
                     InitDataValid(0,  "auth_ofc_cd",vtEngUpOnly);   
                     InitDataCombo (0, "jo_crr_auth_cd", "R|W", "R|W");
                     InitDataCombo (0, "delt_flg", "NO|YES","N|Y");
                     ShowButtonImage = 1;
      
                 }
                 break;

         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
             case    IBCLEAR:      //초기 
                     formObj.f_cmd.value = SEARCH01;            
                     var param  =  FormQueryString(formObj)+"&auth_delcheck_yn=N"; //auth_delcheck_yn
                     var sXml   =  sheetObj.GetSearchXml("FNS_JOO_0079GS.do", param);
                     var aXml   = sXml.split("|$$|");
                     ComXml2ComboItem( aXml[0], formObj.jo_crr_cd   , "code","code" );
                     ComXml2ComboItem( aXml[1], formObj.auth_ofc_cd , "code","code" );
                     break;

                     
             case    IBSEARCH_ASYNC02:      //Get List Trade Code By Carrier Code 
                     formObj.f_cmd.value = SEARCHLIST06;            
                     var code  = formObj.jo_crr_cd.Text;
                     var param = FormQueryString(formObj)+"&super_cd1="+code+"&auth_delcheck_yn=N"; 
                     var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                     ComXml2ComboItem( sXml, formObj.trd_cd, "code","code" );
 
                     break;  
            
             case    IBSEARCH_ASYNC03:      //Get List Lane Code By Trade Code  
                     formObj.f_cmd.value = SEARCHLIST07;            
                     var code  = formObj.trd_cd.Text;
                     var param =  FormQueryString(formObj)+"&super_cd2="+code+"&auth_delcheck_yn=N"; 
                     var sXml  =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                     ComXml2ComboItem( sXml, formObj.rlane_cd, "code","code" );
                     break; 
             
             case    IBSEARCH_ASYNC04:      //Check Office Code , KeyUp Event
                     formObj.f_cmd.value = SEARCH11;            
                     var code   = sheetObjects[0].CellValue( cRow, "auth_ofc_cd");
 
                     var param =  FormQueryString(formObj)+"&code="+code+"&auth_delcheck_yn=N";
                     var sXml  =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                     
                     if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
                         if(ComGetTotalRows(sXml) == 0 ){
                             ComShowCodeMessage("JOO00117", "Authority Office");
                             sheetObjects[0].CellValue2( cRow, "auth_ofc_cd") = "";
 
                             sheetObjects[0].SelectCell( cRow, "auth_ofc_cd");
                         } 
                     }
                     break; 
             case    IBSEARCH_ASYNC05:       
                     formObj.f_cmd.value = SEARCH01;            
                     var param  =  FormQueryString(formObj)+"&auth_delcheck_yn=N";
                     var sXml   =  sheetObj.GetSearchXml("FNS_JOO_0079GS.do", param);
                     var aXml   = sXml.split("|$$|");
                     ComXml2ComboItem( aXml[1], formObj.auth_ofc_cd , "code","code" );
                     break;
                     
             case    IBSEARCH:      //조회
                     formObj.f_cmd.value = SEARCHLIST01;    
                     if(!validateForm(sheetObj,formObj,sAction)){return;}
                     var param =  FormQueryString(formObj);
                     sheetObj.DoSearch("FNS_JOO_0079GS.do", param);
 
                     break;

             case    IBSAVE:        //저장
                     if(!validateForm(sheetObj,formObj,sAction)){ return;}
                     sheetObj.WaitImageVisible=false;
                     ComOpenWait(true);
                     formObj.f_cmd.value = MULTI;         
                     var sParam     =  ComGetSaveString(sheetObj );
                     sParam        +=  "&"+FormQueryString(formObj);
                     var sXml =   sheetObj.GetSaveXml("FNS_JOO_0079GS.do" ,   sParam  );
                     sheetObj.LoadSaveXml( sXml );
                     ComOpenWait(false);
                     break;

             case    IBINSERT:      // 입력
             
             
                     break;
         }
     }
    
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
         var doc = document.all;
         if(sheetObj.RowCount > 0){
             //doc.btn_delete.className = "btn2";
             doc.btn_copy.className   = "btn2"; 
         }
     }
     function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
         var doc = document.all;

         if(sheetObj.RowStatus(NewRow) == "I" || sheetObj.RowStatus(NewRow) == "U"){
              doc.btn_delete.className = "btn2";
         }else{
              doc.btn_delete.className = "btn2_1";
         }
     }
     function sheet1_OnChange(sheetObj, row, col) {
         var doc = document.all;
         var formObj = document.form;

         if(sheetObj.ColSaveName (col) == "auth_ofc_cd" ){ 
             if( sheetObj.EditValue.length < 6 ){
                 sheetObj.CellValue2(row, "auth_ofc_cd")  = sheetObj.EditValue;
                 doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC04, row);
             }
        }
     }
 
     
     function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
         var formObj = document.form;
 
         if( KeyCode == 229){return;}
         if(sheetObj.ColSaveName (Col) == "auth_ofc_cd" ){ 
              if( sheetObj.EditValue.length == 6){
                  sheetObj.CellValue2(Row, "auth_ofc_cd")  = sheetObj.EditValue;
                  doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC04, Row);
              }
         }
     }
     
     /**
      * Sheet1 OnPopupClick 이벤트 처리  
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnPopupClick(sheetObj, Row, Col)
     {
         with(sheetObj)
         {
             if( sheetObj.ColSaveName(Col) ==  'auth_ofc_cd' ){
                 var lane_cd = ""; 
                 ComOpenPopup('/hanjin/COM_ENS_071.do',  770, 480, "PopupCallback_OffCd", "1,0,0", true, false, Row, Col, 0);
             }
         }
     }  
     function PopupCallback_OffCd(aryPopupData,row, col, seetIdx){ 
          sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][3];
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             switch(sAction) {
                 case IBSAVE:
                     var sParam     =  ComGetSaveString(sheetObj );
                     if( sParam == ""){
                         return false;
                     }
                     var Row = sheetObj.ColValueDup("jo_crr_cd|rlane_cd|auth_ofc_cd", false);
                     if( Row > -1){
                         ComShowCodeMessage("JOO00161");
                         sheetObj.SelectCell(Row, "auth_ofc_cd");
                         return false;
                     }
                     if( !ComShowCodeConfirm("JOO00046") ){
                         return false;
                     }
                     break;  
             } // end switch
         }
         return true;
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
            formObj.rlane_cd.RemoveAll();
 
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
        function   auth_ofc_cd_OnFocus(comboObj) {
            var formObj = document.form;
 
                comboObj.Enable = false;
                doActionIBSheet(sheetObjects[sheetObjects.length-1],formObj,IBSEARCH_ASYNC05);
                comboObj.Enable = true;
 
        }
        
        
        function fnBtnNew(){
            
        }

	/* 개발자 작업  끝 */