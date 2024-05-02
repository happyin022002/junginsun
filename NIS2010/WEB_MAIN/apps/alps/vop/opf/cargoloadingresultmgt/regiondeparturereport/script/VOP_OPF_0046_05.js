/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046_05.js
*@FileTitle : RDR Creation – VSL Alloc
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
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
     * @class VOP_OPF_0046_05 : VOP_OPF_0046_05 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0046_05() {
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
                var prefix = sheetObjects[0].id+"_";
                var className = window.event.srcElement.className;
                if( className.indexOf("_1") > -1 ){
                    return;
                }
                
                switch(srcName) {

                        case   "btn_Retrieve":
                               doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                             
                               break;
 
                        case   "btn_Row_Add":
                               var pRow = sheetObjects[0].DataInsert(-1);
                               sheetObjects[0].SelectCell( pRow, prefix+"opr_cd") ;
                               break;
                           
                        case   "btn_Row_Insert":
                               var pRow = sheetObjects[0].DataInsert();
                               sheetObjects[0].SelectCell( pRow, prefix+"opr_cd") ;
                               break;
                            
                        case   "btn_Row_Copy":
                               sheetObjects[0].DataCopy();
                               break;
                            
                        case   "btn_Row_Delete":
                               ComRowHideDelete(sheetObjects[0], prefix+"sel_chk");
                               break;
 
                        case   "btn_ImportAllocation":
                               doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);        
                               break;

                } // end switch
//            }catch(e) {
//                if( e == "[object Error]") {
//                    ComShowMessage(OBJECT_ERROR);
//                } else {
//                    ComShowMessage(e);
//                }
//            }
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
          * <pre>
          *     OnLoadFinish에서 탭 클릭시, 
          *       자동 Retrieve는 SubPage에서 Sheet가 Load전에 Search를 실행하는 경우가 발생한다.
          *       Sheet가 Load전에 Search가 발생하므로 script 에러가 발생하므로 
          *       OnloadFinish로 처리한다.
          * </pre>
          *
          * @param   sheetObj
          * @author jang kang cheol
          */
         function sheet1_OnLoadFinish(sheetObj){
             var  pFormObj = parent.document.form;
             var  formObj  = document.form;
             if(  pFormObj.flagRetrieveYn.value  == "Y" ){
                  parent.doActionIBSheet( parent.sheetObjects[0], pFormObj, IBSEARCH);
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
                        style.height = 390;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 10, 100);
                        
                        var HeadTitle1 = "|Sel.|Operator|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Weight\nper TEU|BSA\nType";
                        var HeadTitle2 = "|Sel.|Operator|Basic Slot|Slot Swap|Slot Release|TTL Allocation|Basic Weight|Weight Swap|Weight Release|TTL Weight|Weight\nper TEU|BSA\nType";

                        var headCount = ComCountHeadTitle(HeadTitle1);
                        var headCount2 = ComCountHeadTitle(HeadTitle2);
                        
                        //alert("headCount = " + headCount + ", headCount2 = " + headCount2);


                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix = sheetObj.id+"_";
                        InitDataProperty(0, cnt++ , dtHiddenStatus,    30,    daCenter,   false,  prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox ,  30,    daCenter,   true ,  prefix+"sel_chk",       false,  "", dfNone,     0,  true,   true);
                        InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true ,  prefix+"opr_cd",        true,  "", dfEngUpKey, 0,  false,  true, 3);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  80,     daRight,    false,  prefix+"basic_slot",    false,  "", dfInteger,  0,  true,   true,5);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  90,     daRight,    false,  prefix+"swap_slot",     false,  "", dfInteger,  0,  true,   true,5);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  80,     daRight,    false,  prefix+"release_slot",  false,  "", dfInteger,  0,  true,   true,5);
                        var tot_alloc_calculate = "|"+prefix+"basic_slot|+|"+prefix+"release_slot|+|"+prefix+"swap_slot|";
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  90,     daRight,    false,  prefix+"tot_alloc",     false,  tot_alloc_calculate, dfInteger,  0,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  90,     daRight,    false,  prefix+"basic_wgt",     false,  "", dfInteger,  1,  true,   true,7);
                        InitDataProperty(0, cnt++ , dtAutoSumEx, 120,     daRight,    false,  prefix+"swap_wgt",      false,  "", dfInteger,  1,  true,   true,7);
                        InitDataProperty(0, cnt++ , dtAutoSumEx, 100,     daRight,    false,  prefix+"release_wgt",   false,  "", dfInteger,  1,  true,   true,7);
                        var tot_wgt_calculate = "|"+prefix+"basic_wgt|+|"+prefix+"release_wgt|+|"+prefix+"swap_wgt|";
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  90,     daRight,    false,  prefix+"tot_wgt",       false,  tot_wgt_calculate, dfInteger,  1,  false,  false);

                        InitDataProperty(0, cnt++ , dtAutoSumEx,  80,     daRight,    true ,  prefix+"teu_wgt",       false,  "", dfFloat,    1,  false,  false,7);
                        InitDataProperty(0, cnt++ , dtCombo,      80,     daCenter,   true ,  prefix+"bsa_type",      false,  "", dfNone,     0,  true,  true);

                        InitDataCombo(0, prefix + "bsa_type", "Used|Fixed", "U|F");
                        
                        InitDataValid(0,  prefix+"opr_cd",vtEngUpOnly); 
                        //ShowButtonImage = 4;
 
                    }
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
             var prefix = sheetObj.id+"_";
             with(sheetObj)
             {
                 if( sheetObj.ColSaveName(Col) == prefix+'opr_cd' ){
                     var lane_cd = "";
                     ComOpenPopup('/hanjin/COM_ENS_0N1.do', 420, 450, "PopupCallback_opr_cd", "1,0,1,1,1", true, false, Row, Col, 0);
                 }
             }
         }
         /**
          * 
          * <pre>
          *     Sheet1 OnKeyUp 이벤트 처리
          * </pre>
          *
          * @author jang kang cheol
          */
          function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
              var formObj = document.form;
              if( KeyCode == 229){return;}
              var prefix = sheetObj.id+"_";

              switch( sheetObj.ColSaveName(Col)  ){
                      case  prefix+'opr_cd' :
                            if( sheetObj.EditValue.length == 3){
                                sheetObj.CellValue2(Row, prefix+'opr_cd'  )  = sheetObj.EditValue;
                                doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC01, Row);                            
                            }
                            break;
              }
          }
          function  sheet1_OnChange(sheetObj, Row, Col,Value) {
              var formObj = document.form;
              var prefix = sheetObj.id+"_";

              switch( sheetObj.ColSaveName(Col)  ){
                     case prefix+'opr_cd' :
              
                           if( sheetObj.CellValue( Row, Col ).length < 5 && sheetObj.CellValue( Row, Col ).length > 0 ){
                               ComShowCodeMessage('OPF50007', 'Operator', "3");
                               sheetObj.SelectCell( Row, sheetObj.id+"_opr_cd");  
                               sheetObj.CellValue2( Row, Col) = "";
                               return;
                           }
                           break;
              }
          }
          /**
           * OnPopupClick Opr Code 이벤트 처리에 대한 CallBack 함수 
           * @param aryPopupData
           * @param row
           * @param col
           * @param seetIdx 
           * @return
           */
          function  PopupCallback_opr_cd(aryPopupData,row, col, seetIdx){
              var formObj = document.form;
              sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][3];
              setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, row); }, 400);
          }
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
 
            var prefix =  sheetObj.id+"_";
            switch(sAction) {
                    case    IBSEARCH:      //조회
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value = SEARCHLIST01;
                            var param  =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                            var sXml   =  sheetObj.GetSearchXml("VOP_OPF_0046_05GS.do",  param );
                            sheetObj.LoadSearchXml( sXml );
                            fnSubBtnAuth(true);
                            break;
                            
                    case    IBSEARCH_ASYNC01:  // Grid Operator Code(=Carrier Code) Key In시.
                            formObj.f_cmd.value   =  SEARCH04;            
                            formObj.crr_cd.value =  sheetObj.CellValue( cRow, prefix+"opr_cd");
                            var param             =  FormQueryString(formObj);
                            var sXml              =  sheetObj.GetSearchXml("VOP_OPF_UTILGS.do", param);
                             
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                if( ComGetTotalRows(sXml) == "0"  ){
                                    ComShowCodeMessage("COM132201", "Operator");
                                    sheetObj.CellValue2( cRow, prefix+"opr_cd") = "";
                                    sheetObj.SelectCell( cRow, prefix+"opr_cd");
                                } 
                            }
                            break;

                    case    IBSEARCH_ASYNC02:  
                            fnSetMainSearchOption();
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value = SEARCHLIST02;  
                            var param  =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                            sheetObj.DoSearch("VOP_OPF_0046_05GS.do", param);
                            break;   
                            
                    case    IBSAVE:  
 
                            parent.bTabChangeGo = false;
                            formObj.f_cmd.value = MULTI01;         

                            
                            var sParam     =  ComGetSaveString(sheetObj );
                            if( sParam == ""){
                                parent.sSheetObjIdx   =  0;
                                parent.iSelectCell    = sheetObj.SelectCol;
                                return;
                            }
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            sParam        +=  "&"+FormQueryString(formObj);
                            var sXml =   sheetObj.GetSaveXml("VOP_OPF_0046_05GS.do" ,   sParam  );
                            sheetObj.LoadSaveXml( sXml );
                            parent.bTabChangeGo = true;
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {//정상처리면 헤더 재조회  
                                parent.fnGetHeader();
                            }
 
                            break;        
                            
                    case    IBDELETE:  
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value = REMOVE;         
                            var sParam   =   FormQueryString(formObj);
                            var sXml     =   sheetObj.GetSaveXml("VOP_OPF_0046_05GS.do" ,   sParam  );
                            sheetObj.LoadSaveXml( sXml );
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                 for(var i=0;i<sheetObjects.length;i++){
                                     sheetObjects[i].RemoveAll();
                                 }
                            }
                            break;  
                            
                    case    IBRESET: //Btn_New
                            for(var i=0;i<sheetObjects.length;i++){
                                sheetObjects[i].RemoveAll();
                            }
                            fnSubBtnAuth(false);
                            break;
            }
        }
        /**
        * 
        * <pre>
        *     선택한 코드 DupCheck
        * </pre>
        * @param  sheetObj
        * @param  cRow
        * @param  sColSaveName
        * @author jang kang cheol
        */
       function fnDupCheckSel(sheetObj, cRow, sColSaveName) {
           var dupRow = sheetObj.ColValueDupRows( sColSaveName, false, true );
           if( dupRow != "" ) {
                return false;   
           }
           return true;
       }
       function fnSetMainSearchOption(){
           var pForm   = parent.form;
           var cForm   = document.form;
   
 
           cForm.vsl_cd.value      =    pForm.vsl_cd.value;
           cForm.voy_no.value      =    pForm.voy_no.value;
           cForm.dir_cd.value      =    pForm.dir_cd.value;
           cForm.region.value      =    pForm.region.Code;
 
           cForm.port_cd.value     =    pForm.port_cd.Code;
       }
       function fnSubBtnAuth(bFlag){
           var pFormObj    = parent.form;
           var update_sys =  pFormObj.sys_create_desc.value; //Externally, Internally
           //2010.12.14 P.H.D. Externally여도 수정가능함
           if( update_sys.indexOf( "Externally" ) > -1 ){
//               ComOpfSetBtnEnable("c", false);
               ComOpfSetBtnEnable("c", true);
           }else{
               ComOpfSetBtnEnable("c", bFlag);
           }
       }
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction) {
                    case   IBSEARCH_ASYNC02:
                            var pForm = parent.form;
                            if( pForm.port_cd.Code  == "" ){
                                 ComShowCodeMessage("COM130201", "Port");
                                 pForm.port_cd.focus();
                                 return false;
                            }
                            break;            
                    case   IBSAVE:
                        
                            var dupRow = sheetObj.ColValueDupRows( sheetObj.id+"_opr_cd", false, true );
                            //2|6,7
                            var aDupRow = dupRow.split("|");
                            if(dupRow != "") {
                                ComShowCodeMessage('OPF50005', 'Data');
                                if (sheetObj.RowStatus( aDupRow[0]) == "R" ) {
                                    /*******중복건이 다수 일경우 첫번째 행으로 선택 ******/
                                    var sSelRow = "";
                                    if(aDupRow[1].indexOf(",") > -1 ){//다수.=>  ","
                                        var aDupRowComma  = aDupRow[1].split(",");
                                        sSelRow  = aDupRowComma[0];
                                    }else{
                                        sSelRow  = aDupRow[1];                                    
                                    }
                                    sheetObj.SelectCell(sSelRow, sheetObj.id+"_opr_cd");  
                                }else{
                                    sheetObj.SelectCell(aDupRow[0], sheetObj.id+"_opr_cd");                    
                                }
                                return false;
                            }
                            //change 여부  
                            if( parent.bChangedData ){
                                if( !ComShowCodeConfirm("OPF50003") ){
                                    parent.bTabChangeGo = true;                         
                                    return false;
                                }
                            }else{
                                if( !ComShowCodeConfirm("OPF50001") ){                            
                                    return false;
                                }
                            }
                           break;
                    case   IBDELETE:
                           if( !ComShowCodeConfirm("OPF50002", parent.aTabTitle[parent.beforetab] ) ){                            
                               return false;
                           }                            
                           break;
            }
            return true;            
       }
 
	/* 개발자 작업  끝 */