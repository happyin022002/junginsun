/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0065.js
*@FileTitle : MCS & Invoice Letter Fax/E-mail Inquiry
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
     * @class fns_joo_0065 : fns_joo_0065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0065() {
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


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

          var sheetObject1 = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

        // try {
             var srcName = window.event.srcElement.getAttribute("name");

                 switch(srcName) {

                         case "btn_Retrieve":
                             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                             
                             break;
                         case "btns_calendar":
                             var cal = new ComCalendarFromTo();
                             cal.select(formObject.ltr_iss_dt_fr, formObject.ltr_iss_dt_to, 'yyyy-MM-dd');
                             break;
                         case "btn_New":
                             fnNewBtn();
                             break;
                             
                         case "btn_DownExcel":
                             
                             var Row  = sheetObjects[1].LastRow;
 
                                              
                                 sheetObjects[1].CellValue(Row, 0) = "E-mail Count";     
                                 sheetObjects[1].CellValue(Row, 1) = formObject.cnt_eml_snd_no.value;                                 
                                 sheetObjects[1].CellValue(Row, 2) = "";                                 
                                 sheetObjects[1].CellValue(Row, 3) = "Fax Count";   
                                 sheetObjects[1].CellValue(Row, 4) = formObject.cnt_jo_cntc_fax_no_ctnt.value ;                                 
                                 sheetObjects[1].CellValue(Row, 5) = "";                                 
                                 sheetObjects[1].CellValue(Row, 6) = "Total Count";                                 
                                 sheetObjects[1].CellValue(Row, 7) = formObject.tot_cnt.value;                                 
 
                                 sheetObjects[1].RowHidden(0) = true;
 
                                 var paramObj = new Object();
             
                                 var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
       
                                 sheetObjects[0].Down2Excel(-1, false,false, true, "", url);
                                 sheetObjects[1].SpeedDown2Excel(-1, true);
                             break;

             } // end switch
//         }catch(e) {
//             if( e == "[object Error]") {
//                 ComShowMessage(OBJECT_ERROR);
//             } else {
//                 ComShowMessage(e);
//             }
//         }
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
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);

             ComEndConfigSheet(sheetObjects[i]);
         }
         
         var formObj = document.form;
         formObj.ofc_cd.value     = strOfc_cd;
 
         
         initControl();

     }
      function initControl() {
        var formObj = document.form;
           
        axon_event.addListener    ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('keypress', 'obj_keypress',    form  );    
        
         
        axon_event.addListenerFormat('BeforeDeactivate' ,  'fn_deactivate',  form);      
        axon_event.addListenerFormat('BeforeActivate'   ,  'fn_activate'  ,  form);     
        
      }
      /**
       * 
       */
       function obj_keypress(){
          obj = event.srcElement;
          var formObj = document.form;
          switch(obj.name ) {
              case "ofc_cd":  
                    ComKeyOnlyAlphabet('upper');  
                   break;
              case "cre_usr_id":  
                  ComKeyOnlyAlphabet('uppernum');  
                 break;      
              case 'ltr_iss_dt_fr':
                  ComKeyOnlyNumber(event.srcElement);                  
                  break;
              case 'ltr_iss_dt_to':
                  ComKeyOnlyNumber(event.srcElement);                  
                  break;  
          } // end switch
       }
      function sheet1_OnLoadFinish(sheetObj) {
          //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
      }  
      function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
          fnSetSummary();        
      }   
      //New Button 처리
      function fnNewBtn(){
          var formObj = document.form;
          formObj.ofc_cd.value     = strOfc_cd;
          formObj.cre_usr_id.value = formObj.strUsr_id.value;
          formObj.ltr_iss_dt_fr.value = yyyyMMfr;
          formObj.ltr_iss_dt_to.value = yyyyMMto;
                    
          
          sheetObjects[0].RemoveAll();
          fnSetSummary();
      }
      function fnSetSummary(){
          var formObj = document.form;
          var cnt_eml_snd_no     = 0;
          var cnt_jo_cntc_fax_no_ctnt = 0;          
          var sheetObj = sheetObjects[0];
 
          for(var i=0; i<= sheetObj.LastRow ;i++){
 
              if( sheetObj.CellValue(i, "eml_proc_sts_cd")   == "Completed" ){
                  cnt_eml_snd_no++;
              }
              if( sheetObj.CellValue(i, "fax_proc_sts_cd")  == "Completed" ){  
                  cnt_jo_cntc_fax_no_ctnt++;
              }
          }
 
          formObj.cnt_eml_snd_no.value     = cnt_eml_snd_no;
          formObj.cnt_jo_cntc_fax_no_ctnt.value = cnt_jo_cntc_fax_no_ctnt;
          ComAddComma(formObj.cnt_eml_snd_no );
          ComAddComma(formObj.cnt_jo_cntc_fax_no_ctnt);
          
          formObj.tot_cnt.value            = cnt_eml_snd_no+cnt_jo_cntc_fax_no_ctnt;
 
          
          
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
             case 'ltr_iss_dt_fr':
                 ComAddSeparator(event.srcElement);
                 break;
             case 'ltr_iss_dt_to':
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
          var formObj = document.form;
          switch(event.srcElement.name){
              case 'ofc_cd':
                  formObj.select();       
                  break;          
              case 'ltr_iss_dt_fr':
                  ComClearSeparator(event.srcElement);                  
                  break;
              case 'ltr_iss_dt_to':
                  ComClearSeparator(event.srcElement);                  
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
                 var sheetID = sheetObj.id;
         switch(sheetID) {

             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 418;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 1, 100);


                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]


                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false, false);
      
                     var HeadTitle1 = "Creation\nUser ID|Sender|Carrier|Send Office|Letter Type|Letter No.|E-mail|E-mail|E-mail|Fax|Fax|Fax|File\nExists";
                     var HeadTitle2 = "Creation\nUser ID|Sender|Carrier|Send Office|Letter Type|Letter No.|Mail\nAddress|Send\nStatus|Send Time|Fax No.|Send\nStatus|Send Time|File\nExists";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitColumnInfo( ComCountHeadTitle(HeadTitle1), 0, 0, false);                     
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);                     

                     //데이터속성    [ROW, COL,  DATATYPE,WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,     60,     daCenter,   true,       "cre_usr_id"  , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     90,     daCenter,   true,       "sndr_nm"     , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     50,     daCenter,   true,       "jo_crr_cd"   , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     70,     daCenter,   true,       "ofc_cd"      , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   true,       "jo_ltr_tp_cd", false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   true,       "jo_ltr_no"   , false,      "",     dfNone, 0,  true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,     130,     daCenter,   false,     "rcvr_eml"     , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,      60,     daCenter,   false,     "eml_proc_sts_cd", false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     100,     daCenter,   false,     "eml_dt"         , false,      "",     dfTimeHm, 0,  true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,       "jo_cntc_fax_no_ctnt" , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,   false,       "fax_proc_sts_cd", false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,       "fax_dt"         , false,      "",     dfTimeHm, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,      90,    daCenter ,   true,      "upd_usr_id"      , false,      "",     dfNone, 0,  true,       true);
                      
                     CountPosition = 0;
                     DataLinkMouse("cre_usr_id") = true;

                 }
                 break;

             case "sheet2":
                 with (sheetObj) {
                     Visible = false;
                     // 높이 설정
                     style.height = 240;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 1, 100);


                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]


                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false, false);
      
                     var HeadTitle1 = "Creation\nUser ID|Sender|Carrier|Send Office|Letter Type|Letter No.|E-mail|E-mail|E-mail|Fax|Fax|Fax|";
         
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitColumnInfo(HeadTitle1.split("|").length-1, 0, 0, true);                     
                     InitHeadRow(0, HeadTitle1, true);
                    

                     //데이터속성    [ROW, COL,  DATATYPE,WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,     60,     daCenter,   true,       "cre_usr_id"  , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,    90,     daCenter,   true,       "sndr_nm"     , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     50,     daCenter,   true,       "jo_crr_cd"   , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     70,     daCenter,   true,       "ofc_cd"      , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   true,       "jo_ltr_tp_cd", false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   true,       "jo_ltr_no"   , false,      "",     dfNone, 0,  true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,     130,     daCenter,   false,     "rcvr_eml"     , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,      60,     daCenter,   false,     "eml_proc_sts_cd", false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,     100,     daCenter,   false,     "eml_dt"         , false,      "",     dfTimeHm, 0,  true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,     90,    daCenter,   false,       "jo_cntc_fax_no_ctnt" , false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,   false,       "fax_proc_sts_cd", false,      "",     dfNone, 0,  true,       true);
                     InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,       "fax_dt"         , false,      "",     dfTimeHm, 0,  true,       true);

                     CountPosition = 0;
                     DataLinkMouse("cre_usr_id") = true;
                     DataInsert(-1);

                 }
                 break;                 
         }
     }
     
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
                 switch(sAction) {
                 case IBSEARCH:      //조회
                     switch (sheetObj.id){
                         case "sheet1":
                             if(!validateForm(sheetObj,formObj,sAction)){return;}
                             formObj.f_cmd.value = SEARCHLIST01;                     
                             var param =  FormQueryString(formObj);
                             sheetObj.DoSearch("FNS_JOO_0065GS.do",  param );
                             sheetObj.ColFontUnderline("cre_usr_id") = true;
                         break;
                     }
                 break;
 
                 case IBCLEAR:    
                     fnSetSummary();
                     break;
                 }
     }

     function sheet1_OnClick(sheetObj, Row, Col, Value ){
         var SaveName = sheetObj.ColSaveName(Col);
         switch  ( SaveName ) {
                   case "cre_usr_id":
                         ComUserPopup(Value);
                   break;
         }
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             if( ofc_cd.value == ""  ){
                 ComShowCodeMessage('JOO00112');
                 ofc_cd.focus();
                 return false;
             }
         }

         return true;
     }


	/* 개발자 작업  끝 */