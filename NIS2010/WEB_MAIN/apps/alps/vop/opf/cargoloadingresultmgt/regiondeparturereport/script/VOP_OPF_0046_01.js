/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046_01.js
*@FileTitle : RDR Creation – VSL Mvmt
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
     * @class VOP_OPF_0046_01 : VOP_OPF_0046_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0046_01() {
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
    var dddss = 0;

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
                                   sheetObjects[0].SelectCell( pRow, prefix+"port_cd") ;
                                   break;
                               
                            case   "btn_Row_Insert":
                                   var pRow = sheetObjects[0].DataInsert();
                                   sheetObjects[0].SelectCell( pRow, prefix+"port_cd") ;
                                   break;
                                
                            case   "btn_Row_Copy":
                                   sheetObjects[0].DataCopy();
                                   break;
                                
                            case   "btn_Row_Delete":
                                   ComRowHideDelete(sheetObjects[0], prefix+"sel_chk");
                                   break;
                                
                            case   "btn_ImportVesselMovement":
                                   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);        
                                   break;
                                
                            case "btn_DownExcel":
 
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
                        style.height = 340;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 10, 100);
                        
                        var HeadTitle = "|Sel.|Port|Arrival Time|Berthing Time|Unberthing Time|Departure Time|Call Ind";
                        var headCount = ComCountHeadTitle(HeadTitle);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix = sheetObj.id+"_";
                        InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,      false,  prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox    ,  30,    daCenter,       true,   prefix+"sel_chk",       false,  "",     dfNone,            0,  true,  true);
                        InitDataProperty(0, cnt++ , dtPopupEdit   , 100,    daCenter,       true,   prefix+"port_cd",       true,  "",      dfEngUpKey,        0,  true,  true, 5);
                        InitDataProperty(0, cnt++ , dtData        , 195,    daCenter,       true,   prefix+"arr_time",      false,  "",     dfUserFormat2,     0,  true,  true);
                        InitDataProperty(0, cnt++ , dtData        , 195,    daCenter,       true,   prefix+"berth_time",    false,  "",     dfUserFormat2,     0,  true,  true);
                        InitDataProperty(0, cnt++ , dtData        , 195,    daCenter,       true,   prefix+"unberth_time",  false,  "",     dfUserFormat2,     0,  true,  true);
                        InitDataProperty(0, cnt++ , dtData        , 180,    daCenter,       true,   prefix+"dep_time",      false,  "",     dfUserFormat2,     0,  true,  true);
                        InitDataProperty(0, cnt++ , dtHidden      , 180,    daCenter,       true,   prefix+"call_ind",      false,  "",     dfNone       ,     0,  true,  true);
 
                        
                        InitUserFormat2(0, prefix + "arr_time"    , "####-##-## ##:##", "-|:" );
                        InitUserFormat2(0, prefix + "berth_time"  , "####-##-## ##:##", "-|:" );
                        InitUserFormat2(0, prefix + "unberth_time", "####-##-## ##:##", "-|:" );
                        InitUserFormat2(0, prefix + "dep_time"    , "####-##-## ##:##", "-|:" );
                        
                        InitDataValid(0,  prefix+"port_cd",vtEngUpOnly);    
                       // ShowButtonImage = 2;
                    }
                    break;
               
            }
        }
        
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, cRow ) {
                if(sheetObj  == null ){ return;}
                var prefix =  sheetObj.id+"_";

                switch(sAction) {
                        case    IBSEARCH:      //조회
                                if(!validateForm(sheetObj,formObj,sAction)){return;}
                                formObj.f_cmd.value = SEARCHLIST01;  
 
                                var param  =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                                var sXml   =  sheetObj.GetSearchXml("VOP_OPF_0046_01GS.do",  param );
                                sheetObj.LoadSearchXml( sXml );
                                
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
 
                                    ComSetObjValue(formObj.next_port,  ComGetEtcData(sXml, "NEXT_PORT" ) );
                                    ComSetObjValue(formObj.eta       , ComGetEtcData(sXml, "ETA") );
                                    ComSetObjValue(formObj.next_canal, ComGetEtcData(sXml, "NEXT_CANAL") );
                                    ComSetObjValue(formObj.eta_canal , ComGetEtcData(sXml, "ETA_CANAL" ) );
         
                                }else{
                                    ComClearObject(formObj.next_port  );
                                    ComClearObject(formObj.eta  );
                                    ComClearObject(formObj.next_canal );
                                    ComClearObject(formObj.eta_canal  );
                                }
                                fnSubBtnAuth(true);
                                break;
                                
                        case    IBSEARCH_ASYNC01:  // Grid Port Code Key In시.
                                formObj.f_cmd.value   =  SEARCH12;            
                                formObj.port_cd.value =  sheetObj.CellValue( cRow, prefix+"port_cd");
                                var param             =  FormQueryString(formObj);
                                var sXml              =  sheetObj.GetSearchXml("VOP_OPF_UTILGS.do", param);
                                 
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                    if( ComGetTotalRows(sXml) == "0"  ){
                                        ComShowCodeMessage("COM132201", "Port");
                                        sheetObj.CellValue2( cRow, prefix+"port_cd") = "";
                                        sheetObj.SelectCell( cRow, prefix+"port_cd");
                                    } 
                                }
                                break;
 
                        case    IBSEARCH_ASYNC02:  
            
                                if( !validateForm( sheetObj,formObj,sAction )){return;}                            
                                /********   Main Frame의 조회옵션을 Sub Frame Hidden값으로 셋팅한다.   *******/
                                fnSetMainSearchOption();
                            
                                formObj.f_cmd.value = SEARCHLIST02;  
                                var param  =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                                sheetObj.DoSearch("VOP_OPF_0046_01GS.do", param);
                                break;   
                                
                        case    IBSAVE:
                                parent.bTabChangeGo = false;
                                formObj.f_cmd.value = MULTI01;
                              
                                if( !validateForm( sheetObj,formObj,sAction ) ){
                                    return;
                                }  
                                
                                var sParam = ComGetSaveString( sheetObj, true, true );
                                if( sParam == ""){
                                    parent.sSheetObjIdx   =  0;
                                    parent.iSelectCell    = sheetObj.SelectCol;
   
                                    return;
                                }
                                sParam  +=  "&"+FormQueryString(formObj);
                                

                                
                                
                                var sXml =   sheetObj.GetSaveXml("VOP_OPF_0046_01GS.do" ,   sParam  );
                                sheetObj.LoadSaveXml( sXml );
                                parent.bTabChangeGo = true;
                                
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {//정상처리면 재조회 
                                    parent.fnGetHeader();
                                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   
                                }
                                 
                                break;        
                                
                        case    IBDELETE:  
                                if(!validateForm( sheetObj,formObj,sAction  )){return;}
                                formObj.f_cmd.value = REMOVE;         
                                var sParam   =   FormQueryString(formObj);
                                var sXml     =   sheetObj.GetSaveXml("VOP_OPF_0046_01GS.do" ,   sParam  );
                                sheetObj.LoadSaveXml( sXml );
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                     for(var i=0;i<sheetObjects.length;i++){
                                         sheetObjects[i].RemoveAll();
                                     }
                                     if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                         for(var i=0;i<sheetObjects.length;i++){
                                             sheetObjects[i].RemoveAll();
                                         }
                                         ////////////Parent Header Sheet Clear//////////
                                         parent.sheetObjects[0].RemoveAll();
                                     }
                                }
                                break;  
                            
                        case    IBRESET: //Btn_New
                                ComClearObject(formObj.next_port  );
                                ComClearObject(formObj.eta  );
                                ComClearObject(formObj.next_canal );
                                ComClearObject(formObj.eta_canal  );
 
                                for(var i=0;i<sheetObjects.length;i++){
                                    sheetObjects[i].RemoveAll();
                                }
                                fnSubBtnAuth(false);
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
                if( sheetObj.ColSaveName(Col) == prefix+'port_cd' ){
                    var port_cd =  sheetObj.CellValue(Row, Col);
                    ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "setSheet1_PopupCallback_port", "0,0", true, false, Row, Col, 0);
 
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
                    case prefix+'port_cd' :
 
                          if( sheetObj.EditValue.length == 5){
                              sheetObj.CellValue2(Row, prefix+'port_cd'  )  = sheetObj.EditValue;
                              doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, Row);                            
                          } 
                          break;
             }
        }
        function  sheet1_OnChange(sheetObj, Row, Col,Value) {
            var formObj = document.form;
            var prefix = sheetObj.id+"_";
 
            switch( sheetObj.ColSaveName(Col)  ){
                   case prefix+'port_cd' :
            
                         if( sheetObj.CellValue( Row, Col ).length < 5 && sheetObj.CellValue( Row, Col ).length > 0 ){
                             ComShowCodeMessage('OPF50007', 'Port Code', "5");
                             sheetObj.CellValue2( Row, Col) = "";
                             sheetObj.SelectCell( Row, Col);
                             return;
                         }
                         break;
                   case prefix+'arr_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
                   case prefix+'berth_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
                   case prefix+'unberth_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
                   case prefix+'dep_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
            }
        }
        function fnCheckDate(sheetObj, Row, Col){
            var dateTmp = sheetObj.CellValue(Row, Col);
            if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
                ComShowMessage(ComGetMsg('COM12187', 'yyyy-mm-dd hh:mm'));
                sheetObj.SelectCell(Row, Col, true);
                return;
            } 
        }
        /**
         * Sheet1 OnPopupClick 이벤트 처리에 대한 CallBack 함수 
         * @param aryPopupData
         * @param row
         * @param col
         * @param seetIdx 
         * @return
         */
        function setSheet1_PopupCallback_port(aryPopupData,row, col, seetIdx){
            var formObj = document.form;
            sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][2];
            setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, row); }, 400);
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
                //ComOpfSetBtnEnable("c", false);
            	ComOpfSetBtnEnable("c", true);
            }else{
                ComOpfSetBtnEnable("c", bFlag);
            }
        }

        
        
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
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
                        if( sheetObj.RowCount > 9 ){
                            ComShowCodeMessage("OPF50023", "9");
                            return false;
                        }
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