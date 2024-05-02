/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0073.js
*@FileTitle : Special Provisions for Segregation (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.08 장강철 jkc
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
     * @class vop_scg_0073 : vop_scg_0073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0073() {
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

       //  try {
             var srcName = window.event.srcElement.getAttribute("name");
             var doc     = document.all;
             var srcObj = window.event.srcElement;
             if( srcName == null ){return;}
             if( srcName.indexOf("btn") == -1  ){
                 return;
             }else{
                 if( srcObj.className=="btn2_1" ){
                     return;
                 }
             }
             switch(srcName) {
                 case "btn2_Row_Add":
               
                     sheetObjects[0].DataInsert(-1);
                     sheetObjects[0].SelectCell( sheetObjects[0].LastRow, "imdg_un_no") ;
                     break;
                 case "btn2_Row_Insert":
                     var pRow = sheetObjects[0].DataInsert();
                     sheetObjects[0].SelectCell( pRow, "imdg_un_no") ;
                   //  sheetObject.SelectCell( sheetObject.SelectRow ,"sheet1_vsl_slan_cd");          
                     break;
                 case "btn2_Row_Copy":
                     sheetObjects[0].DataCopy();
                     break;
                 case "btn2_Row_Delete":
                     ComRowHideDelete(sheetObjects[0], "sel_chk");
                     break;
                 case "btn_Retrieve":
                     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                     break;
                 case "btn_save":
                     doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
             //IBMultiCombo초기화
             for(var k = 0; k < comboObjects.length; k++){
                 initCombo(comboObjects[k], k + 1);
             }
         }
         initControl();         
        // doActionIBSheet(sheetObjects[0],document.form,IBRESET);         
     }
     
     function initControl() {
          axon_event.addListenerForm('keypress', 'obj_keypress',    form  );
          axon_event.addListenerForm('change',   'obj_change',form); //- 포커스 나갈때
          axon_event.addListenerForm('keyup',    'obj_keyup',form);  
     }
     /** 
      * IBCombo Object를 배열로 등록
      * @param    {IBCombo}  combo_obj   배열로 등록될 IBCombo Object
      */ 
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }      
      /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
      function initCombo(comboObj, comboNo) {
  
             switch(comboObj.id) {
   
                 case "imdgsclprovino":    
                     var i=0;
                     with(comboObj) {
                         InsertItem(0,   "1", "1");
                         InsertItem(1,   "2", "2");                         
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
         switch(sheetObj.id) {
             case "sheet1":      //sheet1 init
                with (sheetObj) {
                     // 높이 설정
                     style.height = 420;
                                         
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|No.|UN No./Seq.|UN No./Seq.|Proper Shipping Name|Class|Subsidiary risk(s)|Packing Group";
                     var headCount = ComCountHeadTitle(HeadTitle1);
                                         
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성   [ROW, COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC,     DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,   true,       "ibflag");                                         
                     InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   false,      "sel_chk"       ,         false,      "",             dfNone,     0,          true,        true);
                     InitDataProperty(0, cnt++ , dtDataSeq,      30,    daCenter);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,   false,      "imdg_un_no"    ,         true,      "",              dfNone,     0,          false,       true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    30,     daCenter,   false,      "imdg_un_no_seq",         true,      "",              dfNumber,     0,          false,       true);                     
                     InitDataProperty(0, cnt++ , dtData,         560,    daLeft,     false,      "prp_shp_nm"    ,         false,      "",             dfNone,     0,          false,       false);
                     InitDataProperty(0, cnt++ , dtData,         50,     daCenter,   false,      "imdg_clss_cd"  ,         false,      "",             dfNullFloat,1,          false,       false);
                     InitDataProperty(0, cnt++ , dtData,        120,     daCenter,   false,      "imdg_subs_rsk_lbl_cd_1", false,      "",             dfNone,     0,          false,       false);
                     InitDataProperty(0, cnt++ , dtData,         34,     daCenter,   false,      "imdg_pck_grp_cd",        false,      "",             dfNone,     0,          false,       false);
                     
                     InitDataValid(0, "imdg_un_no"     , vtNumericOnly);
                     //CountPosition = 0;

                 }
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,pRow) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 
                  
             case IBSEARCH:      //조회
                  if( !validateForm(sheetObj,formObj,sAction)){
                      return;
                  }             
                  formObj.f_cmd.value = SEARCHLIST01;
                  var param =  FormQueryString(formObj);  
                  sheetObj.DoSearch("VOP_SCG_0073GS.do", param);  
                  if( sheetObj.RowCount > 0 ){
                      initBtn(true);
                  }                  
                  break;
             
             case IBSAVE:        //저장
                  if( !validateForm(sheetObj,formObj,sAction)){
                      return;
                  }
                  var sParam =  ComGetSaveString(sheetObjects );
                  if( sParam == ""){ return;}
                  formObj.f_cmd.value = MULTI;                  
                  sParam  +=  "&"+FormQueryString(formObj);
                  //var sXml  =  sheetObj.GetSaveXml( "VOP_SCG_0073GS.do", sParam);
                  var sXml  =  sheetObj.DoSave( "VOP_SCG_0073GS.do", sParam, '-1', false);
 
                  break;

             case IBSEARCH_ASYNC01:      //Unno, Unnoseq로 정보 가져오기.
                  formObj.f_cmd.value = SEARCH01;
                  var param  =  "f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+sheetObj.CellValue(pRow, "imdg_un_no");
                      param  +=  "&imdg_un_no_seq="+sheetObj.CellValue(pRow, "imdg_un_no_seq");
                  var sXml  =  sheetObj.GetSearchXml("VOP_SCG_0073GS.do", param);
 
                  var sTotal = ComGetTotalRows(sXml);
                  if( sTotal == "0"){
                      ComShowCodeMessage("SCG50010", 'Data');  
                      sheetObj.SelectCell(pRow,  "imdg_un_no_seq", true );
                      sheetObj.CellValue2(pRow,  "imdg_un_no_seq") = ""; 
                  }else{
                      fnSetUnnoInfo( sheetObj, sXml, pRow);
                  }
                  break;                  
                  
             case IBSEARCH_ASYNC05:  //그리드2 CheckUnNumber
                  sheetObj.CellValue2(pRow, "imdg_un_no_seq") = "";
 
                  formObj.f_cmd.value = SEARCH01;
                  var param  =  "f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+sheetObj.CellValue(pRow, "imdg_un_no");
                      param  +=  "&imdg_un_no_seq="+sheetObj.CellValue(pRow, "imdg_un_no_seq");
    
                  var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                  var sTotal = ComGetTotalRows(sXml);
    
                  if( sTotal == "0"){
                      ComShowCodeMessage("SCG50010", 'Data');
                      sheetObj.CellValue2(pRow, "imdg_un_no")   = "";
                      sheetObj.SelectCell(pRow, "imdg_un_no") ;
                  }else{
                      sheetObj.SelectCell(pRow, "imdg_un_no_seq") ;
                  }
                  break;                   
 
         }
     }
     /**
     * Sheet1  OnKeyUp 이벤트 처리  
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */     
     function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
         var formObj = document.form;
         if( KeyCode == 229){return;}
         
         switch( sheetObj.ColSaveName(Col)  ){
        
                 case 'imdg_un_no' :                          
                     if( sheetObj.EditValue.length == 4){
                         sheetObj.CellValue2(Row, "imdg_un_no"    )  = sheetObj.EditValue;
                         sheetObj.CellValue2(Row, "imdg_un_no_seq")  = "";
                         doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC05, Row);                            
                     }else{
                         if( sheetObj.EditValue !=  sheetObj.CellValue (Row, "imdg_un_no") ){
                             fnClearUnnoInfo(sheetObj, Row);
                             sheetObj.CellValue2(Row, "imdg_un_no_seq") = "";
                         }                         
                     }
                     break;
                case 'imdg_un_no_seq' :
                      if( sheetObj.EditValue !=  sheetObj.CellValue (Row, "imdg_un_no_seq") ){
                          fnClearUnnoInfo(sheetObj, Row);
                      }
                      if(sheetObj.EditValue == ""){
                          sheetObj.CellValue2 (Row, "imdg_un_no_seq") = sheetObj.EditValue;
                      }
                      break;
         }
    }    
     /**
     * Sheet1 OnChange 이벤트 처리.
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
     function sheet1_OnChange(sheetObj, Row, Col) {
         var formObj = document.form;
         switch( sheetObj.ColSaveName(Col)  ){
    
             case 'imdg_un_no_seq' :
                   if( sheetObj.CellValue(Row, "imdg_un_no") == ""   ){return;}
                   doActionIBSheet( sheetObj, formObj, IBSEARCH_ASYNC01, Row);
                   break;    
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
              if( sheetObj.ColSaveName(Col) ==  'imdg_un_no_seq' ){
                   var imdg_un_no     =  sheetObj.CellText(Row,   'imdg_un_no'     );
                   var imdg_un_no_seq =  sheetObj.CellText(Row,   'imdg_un_no_seq' );
                   ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,
                		   940, 400, "setSheet1_PopupCallback_ImdgUnNoSeq", "0,1,1,1,1,1,1,1", true,true, Row, Col, 0);
              }
          }
      }
     /**
     * Sheet1 OnPopupClick ImdgUnNoSeq 이벤트 처리에 대한 CallBack 함수 
     * @param aryPopupData
     * @param row
     * @param col
     * @param seetIdx 
     * @return
     */
     function setSheet1_PopupCallback_ImdgUnNoSeq(aryPopupData,row, col, seetIdx){
 
         sheetObjects[seetIdx].CellValue2(row, "imdg_un_no")       = aryPopupData[0][2];//UnNo
         sheetObjects[seetIdx].CellValue2(row, "imdg_un_no_seq")   = aryPopupData[0][3];//UnNoSeq
         sheetObjects[seetIdx].CellValue2(row, "imdg_clss_cd")     = aryPopupData[0][4];//ClassCd
         sheetObjects[seetIdx].CellValue2(row, "prp_shp_nm")       = aryPopupData[0][6]; 
         sheetObjects[seetIdx].CellValue2(row, "imdg_pck_grp_cd")  = aryPopupData[0][8];
         
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01,row);
 
     }
 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             switch ( sAction ){
                     case IBSEARCH:
                         if(formObj.imdgsclprovino.Text == ""){
                             ComShowCodeMessage('SCG50011', 'Table No.');   
                             formObj.imdgsclprovino.focus();
                             return false;
                         }
 
                         break;             
                     case IBSAVE:
                          var Row = sheetObj.ColValueDup("imdg_un_no|imdg_un_no_seq",false);
                          if( Row != -1){
                             ComShowCodeMessage("SCG50005","Data");
                             sheetObj.SelectCell(Row, "imdg_un_no");
                             return false;
                          }          
                          if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
                              return false;   
                          }
                          break;
             }
         } 
         return true;
     }
     /**
      * Grid 한줄 Clear
      * @param  void
      * @return void
      */            
      function fnClearUnnoInfo(sheetObj, pRow){
          sheetObj.CellValue2(pRow, "prp_shp_nm"  )           = "";
          sheetObj.CellValue2(pRow, "imdg_clss_cd")           = "";
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_1") = "";
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_2") = "";
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_3") = "";
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_4") = "";
          
          sheetObj.CellValue2(pRow, "imdg_pck_grp_cd"       ) = "";  
      }
      /**
       * 
       * <pre>
       *     Unno, Unnoseq로 Unno정보를 셋.
       * </pre>
       *
       * @param  Object sheetObj, String sXml, String pRow 
       * @return void
       * @author jang kang cheol
       */
      function fnSetUnnoInfo(sheetObj, sXml, pRow){
          var formObj = document.form;
          var imdg_tbl_no = ComScgGetRowValue(sXml,1,"imdg_tbl_no");
          if( formObj.imdgsclprovino.value != imdg_tbl_no && imdg_tbl_no != ""){
              ComShowCodeMessage("SCG50005", 'Data');
              sheetObj.CellValue2(pRow, "imdg_un_no"  )           = "";
              sheetObj.CellValue2(pRow, "imdg_un_no_seq")         = "";          
              sheetObj.SelectCell( pRow, "imdg_un_no") ;              
              return;
          }
          sheetObj.CellValue2(pRow, "prp_shp_nm"  )           = ComScgGetRowValue(sXml,1,"prp_shp_nm");
          sheetObj.CellValue2(pRow, "imdg_clss_cd")           = ComScgGetRowValue(sXml,1,"imdg_clss_cd");
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_1") = ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_1");
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_2") = ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_2");
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_3") = ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_3");
          sheetObj.CellValue2(pRow, "imdg_subs_rsk_lbl_cd_4") = ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_4");          
 
          sheetObj.CellValue2(pRow, "imdg_pck_grp_cd"       ) = ComScgGetRowValue(sXml,1,"imdg_pck_grp_cd"       );          
 
      }
     /**
      * Form Object obj_keypress 이벤트시 처리
      * @param  void
      * @return void
      */     
      function obj_keypress (){
          var obj = event.srcElement;
 
          switch (obj.name){
               case 'imdgsclprovino':
                    ComKeyOnlyNumber(obj);
                    break;
          }
          
      }      
      /**
       * Form Object  blur 이벤트시 처리
       * @param  void
       * @return void
       */     
       function obj_change (){
             var obj = event.srcElement;
             var formObj = document.form;
   
             switch (obj.name){
                case "imdgsclprovino":
                      if( obj.value != "" ){
                          doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                      }else{
                          fnNewGrid();
                          initBtn(false);
                      }
                      break;
             }
       }
       function initBtn(Yn){
           var doc = document.all;
           var ClassName = "";
    
           if( Yn ){
               ClassName = "btn2";
           }else{
               ClassName = "btn2_1";           
           }
           
           doc.btn2_Row_Add.className     = ClassName;
           doc.btn2_Row_Insert.className     = ClassName;
           doc.btn2_Row_Copy.className       = ClassName;
           doc.btn2_Row_Delete.className     = ClassName;     
 
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
           var cnt = sheetObjects[0].RowCount;
           for(var j=1;j<= cnt;j++ ){
               sheetObjects[0].RowDelete(1, false);
           }
       } 
        function imdgsclprovino_OnChange(comboObj, Index_Code, Text){
 
            var formObj = document.form;
  
            switch (comboObj.id){
               case "imdgsclprovino":
                     if( comboObj.Code != "" ){
                         doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                     }else{
                         fnNewGrid();
                         initBtn(false);
                     }
                     break;
            }          
        }
       
	/* 개발자 작업  끝 */