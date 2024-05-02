/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046_03.js
*@FileTitle : RDR Creation – HC/45
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
* History --------------------------------------------------
* 2011.09.22 정상기 [CHM-201113608-01] HC/45 로직 보완 : 20HC/40HC BSA 없는경우에도 ADD SLOT 계산하도록 로직 수정
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
     * @class VOP_OPF_0046_03 : VOP_OPF_0046_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0046_03() {
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


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];

             /*******************************************************/
             var formObject = document.form;
             var prefix = sheetObjects[0].id+"_";
             
           // try {
                var srcName = window.event.srcElement.getAttribute("name");
                var className = window.event.srcElement.className;
                if( className.indexOf("_1") > -1 ){
                    return;
                }
                    switch(srcName) {

                         case   "btn_Retrieve":
                                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                             
                                break;
                            
                         case   "btn_ImportSubAllocation":
                                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);     
                                break;
                            
                         case   "btn_Row_Add":
                                var pRow = sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SelectCell( pRow, prefix+"opr_cd") ;
                                break;
                            
                         case   "btn_Row_Insert":
                                var pRow = sheetObjects[0].DataInsert();
                                sheetObjects[0].SelectCell(pRow, prefix+"opr_cd") ;
                                break;
                             
                         case   "btn_Row_Copy":
                                sheetObjects[0].DataCopy();
                                break;
                             
                         case   "btn_Row_Delete":
                                ComRowHideDelete(sheetObjects[0], prefix+"sel_chk");
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
                        style.height = 380;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(3, 1, 10, 100);
                        
                        var HeadTitle1 = "|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR";
                        var HeadTitle2 = "|Sel.|Operator|20 High Cubic|20 High Cubic|20 High Cubic|20 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|45’|45’|45’|45’|45’|Ratio\nType";
                        var HeadTitle3 = "|Sel.|Operator|Loaded|BSA\n(T)|Over Ratio\n(T)|Add Slot\n(T)|Loaded|BSA\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Loaded|BSA\n(F)|Under Ratio\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Ratio\nType";
                        
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);
                        InitHeadRow(2, HeadTitle3, true);

                        //2010.12.14 P.H.D. load 컬럼은 Externally인 경우 수정 불가함.
                        var updateSys =  parent.form.sys_create_desc.value; //Externally, Internally
                        var bEdt = true;

                        if( updateSys.indexOf( "Externally" ) > -1 ){
	                       	 bEdt = false;
                        }

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix= sheetObj.id+"_";
                        InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,   false,  prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox ,   30,    daCenter,   true,   prefix+"sel_chk", false,  "", dfNone,     0,  true,  true);

                        InitDataProperty(0, cnt++ ,dtPopupEdit, 70,    daCenter,      true,   prefix+"opr_cd",    true ,  "", dfEngUpKey, 0,  false,  true, 3);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  55,     daRight,    true,   prefix+"load_20",   false,  "", dfNumber,   0,  bEdt,   bEdt,4);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  40,     daRight,    true,   prefix+"hc20_qty",  false,  "", dfNumber,   0,  true,   true,4);
                        InitDataProperty(0, cnt++ , dtData,     80,     daRight,      true,   prefix+"hc20_rate", false,  "", dfFloat,    3,  true,   true,5);                  
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  70,     daRight,    true,   prefix+"add_20",    false,  "", dfNumber,   0,  false,  false,4);
                        
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  55,     daRight,    true,   prefix+"load_40",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  40,     daRight,    true,   prefix+"hc40_qty",  false,  "", dfNumber,   0,  true,  true,4);
                        InitDataProperty(0, cnt++ , dtData,     80,     daRight,      true,   prefix+"hc40_rat",  false,  "", dfFloat ,   3,  true,  true,5);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  70,     daRight,    true,   prefix+"add_40",    false,  "", dfNumber,   0,  false, false,4);
                        
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  55,     daRight,    true,   prefix+"load_45",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  40,     daRight,    true,   prefix+"bsa_45",    false,  "", dfNumber,   0,  true,  true,4);
                        InitDataProperty(0, cnt++ , dtData   ,  85,     daRight,      true,   prefix+"un_rat_45", false,  "", dfFloat,   3,   true,  true,5);
                        InitDataProperty(0, cnt++ , dtData,     80,     daRight,      true,   prefix+"ov_rat_45", false,  "", dfFloat,   3,   true,  true,5);
                        InitDataProperty(0, cnt++ , dtAutoSumEx,  70,     daRight,    true,   prefix+"add_45",    false,  "", dfNumber,   0,  false, false,4);
                        InitDataProperty(0, cnt++ , dtCombo,    60,     daCenter,     true ,  prefix+"ratio_type",false,  "", dfNone,     0,  true,  true,4);     
                        var slot_add_calcul = "|"+prefix+"add_20|+|"+prefix+"add_40|+|"+prefix+"add_45|";
                        //InitDataProperty(0, cnt++ , dtHidden ,    80,     daCenter,   true ,  prefix+"slot_add"  ,false,  slot_add_calcul, dfNone,     0,  true,  true);

                        InitDataValid(0,  prefix+"opr_cd",vtEngUpOnly); 
                        InitDataCombo(0,  prefix + "ratio_type", "Rate|Void", "R|V");                        
                        //ShowButtonImage = 4;
                    }
                    break;
               
            }
        }
 
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, cRow ) {
                var prefix =  sheetObj.id+"_";
                switch(sAction) {

                        case IBSEARCH:      //조회
                                 if(!validateForm(sheetObj,formObj,sAction)){return;}
                                 formObj.f_cmd.value = SEARCHLIST01;                     
                                 var param  =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                                 var sXml   =  sheetObj.GetSearchXml("VOP_OPF_0046_03GS.do",  param );
                                 sheetObj.LoadSearchXml(sXml);
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
                                
                        case    IBSEARCH_ASYNC02:  //Import Sub Allocation
                                if(!validateForm(sheetObj,formObj,sAction)){return;}
                                fnSetMainSearchOption();
                                formObj.f_cmd.value   =  SEARCHLIST02;            
                                formObj.crr_cd.value =  sheetObj.CellValue( cRow, prefix+"opr_cd");
                                var param             =  FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix);
                                var sXml              =  sheetObj.GetSearchXml("VOP_OPF_0046_03GS.do", param);
                                sheetObj.LoadSearchXml(sXml);
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
                                
                                var sXml =   sheetObj.GetSaveXml("VOP_OPF_0046_03GS.do" ,   sParam  );
                                sheetObj.LoadSaveXml( sXml );
                                parent.bTabChangeGo = true;
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {//정상처리면 재조회 
                                    parent.fnGetHeader();
                                }
 
                                break;        
                                
                        case    IBDELETE:  
                                if(!validateForm(sheetObj,formObj,sAction)){return;}
                                formObj.f_cmd.value = REMOVE;        
 
                                var sParam   =   FormQueryString(formObj);
                                var sXml     =   sheetObj.GetSaveXml("VOP_OPF_0046_03GS.do" ,   sParam  );
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
                                fnSubBtnAuth(false);;
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
                   ComOpenPopup('/hanjin/COM_ENS_0N1.do', 420, 450, "setSheet1_PopupCallback_port", "1,0,1,1,1", true, false, Row, Col, 0);
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
                   case prefix+'opr_cd' :
                         if( sheetObj.EditValue.length == 3){
                             sheetObj.CellValue2(Row, prefix+'opr_cd'  )  = sheetObj.EditValue;
                             doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, Row);                            
                         }
                         break;
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
           sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][3];
           setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, row); }, 400);
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
 
            
            with(sheetObj){
            	
                //{(Loaded – 20’ High Cubic Sub Allocation) x (Over Ratio-1)}  , 소수점 2째자리 반올림 (I-Stowage 에서 제공)
                if( ColSaveName(Col) == prefix + "load_20"  || 
                    ColSaveName(Col) == prefix + "hc20_qty" || 
                    ColSaveName(Col) == prefix + "hc20_rate" )
                {
                	
                    if( parseInt  (CellValue(Row,  prefix + "load_20"   ))  > 0 && 
                        //parseInt  (CellValue(Row,  prefix + "hc20_qty"  ))  > 0 &&   //2011.09.21 : 20HC or 40HC의 경우 BSA가 없는 경우에도 add slot 계산함// 
                        parseFloat(CellValue(Row,  prefix + "hc20_rate" ))  > 1    )
                    {
                            /**   
                             *   Load가 bsa보다 크면 =>   (Load - Bsa)
                             *    
                             */
                            if( parseInt(CellValue(Row,  prefix + "load_20")) > parseInt(CellValue(Row,  prefix + "hc20_qty")) )
                            {
                                
                                var addSlot =     ( parseInt(CellValue(Row,  prefix + "load_20")) - parseInt(CellValue(Row,  prefix + "hc20_qty")) )
                                               *  ( CellValue(Row,  prefix + "hc20_rate") - 1 );
                                
                                CellValue(Row,  prefix + "add_20") = ComRound(addSlot, 0); 
                                
                            }else{
                                CellValue(Row,  prefix + "add_20") = "0";
                            }
                             
                    }else{
                        CellValue(Row,  prefix + "add_20") = "0";
                    }
                }

                 //{(Loaded – 40’ High Cubic Sub Allocation) x (Over Ratio-1) } x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
                if( ColSaveName(Col) == prefix + "load_40"  || 
                    ColSaveName(Col) == prefix + "hc40_qty" || 
                    ColSaveName(Col) == prefix + "hc40_rat" )
                {
                	
                          if( parseInt  (CellValue(Row,  prefix + "load_40" )) > 0 && 
                              //parseInt  (CellValue(Row,  prefix + "hc40_qty")) > 0 && //2011.09.21 : 20HC or 40HC의 경우 BSA가 없는 경우에도 add slot 계산함// 
                              parseFloat(CellValue(Row,  prefix + "hc40_rat")) > 1 )    //2011.09.21 : 20HC or 40HC의 경우 Over Ratio 만큼   add slot 계산함 : org : parseFloat(CellValue(Row,  prefix + "hc40_rat")) > 1// 
                          {                        	
                        	
                                if( parseInt(CellValue(Row,  prefix + "load_40")) > parseInt(CellValue(Row,  prefix + "hc40_qty")) )
                                {
                                    var addSlot =   ( parseInt(CellValue(Row,  prefix + "load_40" )) - parseInt(CellValue(Row,  prefix + "hc40_qty")) )
                                                  * ( CellValue(Row,  prefix + "hc40_rat") - 1) * 2 ;
                                    
                                    CellValue(Row,  prefix + "add_40") = ComRound(addSlot, 0);
                                }else{
                                    CellValue(Row,  prefix + "add_40") = "0";
                                }
                                
                        }else{
                            CellValue(Row,  prefix + "add_40") = "0";
                        }
                }
                 
                 
                /**
                 * - HC45
                 *   case1) Load <= Bsa : Under일 경우
                 *                        Load * ( URate - 1) * 2
                 *   case2) Load > Bsa : Over 일 경우 
                 *                       Bsa  * (URate-1) * 2
                 *                    + (Load - Bsa ) * (ORate - 1) * 2
                 */
                if( ColSaveName(Col) == prefix + "load_45"   || 
                    ColSaveName(Col) == prefix + "bsa_45"    || 
                    ColSaveName(Col) == prefix + "un_rat_45" || 
                    ColSaveName(Col) == prefix + "ov_rat_45" )
                {
                	
                	var loaded45 = parseInt  (CellValue(Row,  prefix + "load_45"));
                	var bsa45    = parseInt  (CellValue(Row,  prefix + "bsa_45"));
                	var undRt45  = parseFloat(CellValue(Row,  prefix + "un_rat_45"));
                	var ovrRt45  = parseFloat(CellValue(Row,  prefix + "ov_rat_45"));
                	
                    if( parseInt(CellValue(Row,  prefix + "load_45")) > 0 && parseInt(CellValue(Row,  prefix + "bsa_45")) > 0 )
                    {

                    	/******************Case1 Under 일경우 ******************************/
                        if ( 
                            ( parseInt  (CellValue(Row,  prefix + "load_45"  )) <= parseInt(CellValue(Row,  prefix + "bsa_45")) ) &&
                            ( parseFloat(CellValue(Row,  prefix + "un_rat_45")) > 1 ) 
                           ){
                               var addSlot =   parseInt(CellValue(Row,  prefix + "load_45")) 
                                           *  (CellValue(Row,  prefix + "un_rat_45") - 1) * 2;
                               CellValue(Row,  prefix + "add_45") = ComRound(addSlot, 0);
 
                        }
                        
                        /******************Case2 Over 일경우 ******************************/
                        else 
                        if( 
                            ( parseInt(CellValue(Row,  prefix + "load_45")) > 
                              parseInt(CellValue(Row,  prefix + "bsa_45")) 
                            )
                            &&
                               ( parseFloat(CellValue(Row,  prefix + "un_rat_45")) > 1 ) 
                            && ( parseFloat(CellValue(Row,  prefix + "ov_rat_45")) > 1 )
                           ){
                               var addSlot = ( parseInt(CellValue(Row,  prefix + "bsa_45")) 
                                           * ( CellValue(Row,  prefix + "un_rat_45") - 1) * 2 ) 
                                           /****************************************************/
                                           + 
                                             ((parseInt(CellValue(Row,  prefix + "load_45")) 
                                           -   parseInt(CellValue(Row,  prefix + "bsa_45" ))
                                             )
                                           * (CellValue(Row,  prefix + "ov_rat_45") - 1) * 2 );
                              CellValue(Row,  prefix + "add_45") = ComRound(addSlot, 0);
                        }else{
                              CellValue(Row,  prefix + "add_45") = "0";
                        }
                    }else{
                    	
/* 2010.12.29 P.H.D 수정
    * BSA 0 and Over Ratio = 0   ==> Add Slots 0 (AS-IS 유지)
    * BSA 0 and Over Ratio > 0   ==> Add Slots,  X = ((A-B)*R2 - (A-B))*2 + (B*R1 - B)*2
      - A   : Loaded
      - B   : BSA
      - R1 : Under Ratio
      - R2 : Over Ratio 
 */                    	
                    	if (bsa45 == 0){
                    		CellValue2(Row, prefix+"un_rat_45") = 0;
	 						CellEditable(Row, prefix+"un_rat_45") = false;
 						}else{
	 						CellEditable(Row, prefix+"un_rat_45") = true;
 						}
                    	if (bsa45 == 0 && ovrRt45 > 0){
                    		CellValue(Row,  prefix + "add_45") = ComRound(2*loaded45*(ovrRt45 - 1), 0)+"";
                    	}else{
                    		CellValue(Row,  prefix + "add_45") = "0";
                    	}
                    }
                }
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
            //2010.12.14 P.H.D. Exteranlly여도 수정가능함
            if( update_sys.indexOf( "Externally" ) > -1 ){
                ComOpfSetBtnEnable("c", false);
//                ComOpfSetBtnEnable("c", true);
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
         
         /**
          * Load 후
          * @param sheetObj
          * @param sErrMsg
          */
         function sheet1_OnSearchEnd(sheetObj, sErrMsg){
        	 //Externally인지 Internally인지 모르고 조회한 경우 initSheet를 한번 더 태움으로써 editable한 column을 setting한다.
             var prefix= sheetObj.id+"_";
             var updateSys =  parent.form.sys_create_desc.value; //Externally, Internally
             var bEdt = true;

             if( updateSys.indexOf( "Externally" ) > -1 ){
                	 bEdt = false;
             }
             
             sheetObj.InitDataProperty(0, 3, dtAutoSumEx,  55,     daRight,    true,   prefix+"load_20",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
             sheetObj.InitDataProperty(0, 7, dtAutoSumEx,  55,     daRight,    true,   prefix+"load_40",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
             sheetObj.InitDataProperty(0,11, dtAutoSumEx,  55,     daRight,    true,   prefix+"load_45",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
         }         
    /* 개발자 작업  끝 */