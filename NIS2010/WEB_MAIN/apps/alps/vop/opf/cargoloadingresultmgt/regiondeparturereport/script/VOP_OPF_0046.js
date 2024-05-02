/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046.js
*@FileTitle : RDR Creation – Main
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
* ---------------------------------------------------------------
* History
* 2011.06.29 이준범 [CHM-201111792-01]
* 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
* 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
*       2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
*                      해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리
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
     * @class VOP_OPF_0046 : VOP_OPF_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0046() {
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
       
       var tabObjects = new Array();
       var tabCnt    = 0 ;
       var beforetab = -1;
       
       var bRetrive     = false;    // ReTrieve YN
       var bChangedData = false; //Iframe Chang YN
       var bTabChangeGo = false; //Change후 Save시 정상처리 여부 
       
       var sSheetObjIdx = 0;
       var iSelectCell  = 0;
       var iSelectRow   = 0;
       
 
/***************************************************************************
 * Tab Title, Tab IFrame Id, Tab Iframe src Url과 같은 Index 로 관리한다.
 * 
 * aTabTitle     : Tab Title 
 * aTabIframe    : Tab Iframe Name
 * aTabIframeSrc : Tab Iframe Src
 ***************************************************************************/       
       /* Tab Title 정리 */
       var aTabTitle = new Array(   
               "VSL Mvmt",
               "Slot/WGT Util",
               "HC/45'",
               "RF",
               "VSL Alloc.",
               "Remark(s)"
           );
       /* Tab Title별 Iframe id 정리*/
       var aTabIframeId = new Array(   
               "ifrVslMvmt",
               "ifrSlotWgtUtil",
               "ifrHc45",
               "ifrRf",
               "ifrVslAlloc",
               "ifrRemark"
           );
       /* Tab Title별 Iframe src 정리 */
       var aTabIframeSrc = new Array(   
               "VOP_OPF_0046_01.do",   
               "VOP_OPF_0046_02.do",
               "VOP_OPF_0046_03.do",
               "VOP_OPF_0046_04.do",
               "VOP_OPF_0046_05.do",
               "VOP_OPF_0046_06.do"
           );
/***************************************************************************/ 
       
       // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
       document.onclick = processButtonClick;

       // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
       function processButtonClick(){
            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
                var sheetObject1 = sheetObjects[0];
            /*******************************************************/
            var formObject = document.form;

         //  try {
               var srcName = window.event.srcElement.getAttribute("name");
 
               var className = window.event.srcElement.className;
               if( className == "btn1_1"){
                   return;
               }
               
               switch(srcName) {
               
                   case "btns_searchVvd":
                       var vslcd = formObject.vsl_cd.value;
                       var sUrl = "";
                       
                       if(vslcd == ""){
                           sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
                           ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                       }else{
                           sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslcd;
                           ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                       }
                       break;
                   case "btn_New":

                       doActionIBSheet(sheetObjects[0], document.form, IBRESET );
                       
                       break;
 
                   case "btn_Retrieve":
                         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH );
                         formObject.flagRetrieveYn.value = "Y";
                         break;
                   case "btn_Save":
                         doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
                         break;
                         
                   case "btn_Delete":
                         doActionIBSheet(sheetObjects[0], document.form, IBDELETE );
                         break;
                       
                   case "btn_Print":
                       formObject.f_cmd.value = SEARCH;
                       var addHeaderXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObject));
                       var addSlotHeaderList = ComGetEtcData(addHeaderXml, "operatorList");
                       
                       var addSlotHeader = addSlotHeaderList.split("|");

                       for(var idx = 0; idx < addSlotHeader.length; idx++){
                           addSlotHeader[idx] = addSlotHeader[idx].substring(0, addSlotHeader[idx].indexOf(","));
                       }

                       // Load Header
                       formObject.f_cmd.value = SEARCH19;
                       var loadHeaderXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObject));
                       var loadHeaderList = ComGetEtcData(loadHeaderXml, "operatorList");

                       var loadHeader = loadHeaderList.split("|");

                       var rdParam = "/rp ["+(formObject.vsl_cd.value)+"]"    // 1.Vessel Code
                                       + " ["+(formObject.voy_no.value)+"]"    // 2.Voyage Number
                                       + " ["+(formObject.dir_cd.value)+"]"    // 3.Direction
                                       + " ["+(comboObjects[0].Code)+"]"       // 4.Region Code
                                       + " ["+nullParam(loadHeader[0])+"]"            // 5.Load Header 1
                                       + " ["+nullParam(loadHeader[1])+"]"            // 6.Load Header 2
                                       + " ["+nullParam(loadHeader[2])+"]"            // 7.Load Header 3
                                       + " ["+nullParam(loadHeader[3])+"]"            // 8.Load Header 4
                                       + " ["+nullParam(loadHeader[4])+"]"            // 9.Load Header 5
                                       + " ["+nullParam(loadHeader[5])+"]"            // 10.Load Header 6
                                       + " ["+nullParam(loadHeader[6])+"]"            // 11.Load Header 7
                                       + " ["+nullParam(loadHeader[7])+"]"            // 12.Load Header 8
                                       + " ["+nullParam(loadHeader[8])+"]"            // 13.Load Header 9
                                       + " ["+nullParam(loadHeader[9])+"]"            // 14.Load Header 10
                                       + " ["+nullParam(loadHeader[10])+"]"           // 15.Load Header 11
                                       + " ["+nullParam(loadHeader[11])+"]"           // 16.Load Header 12
                                       + " ["+nullParam(loadHeader[12])+"]"           // 17.Load Header 13
                                       + " ["+nullParam(loadHeader[13])+"]"           // 18.Load Header 14
                                       + " ["+nullParam(loadHeader[14])+"]"           // 19.Load Header 15
                                       + " ["+nullParam(addSlotHeader[0])+"]"             // 20.AddSlot Header 1
                                       + " ["+nullParam(addSlotHeader[1])+"]"             // 21.AddSlot Header 2
                                       + " ["+nullParam(addSlotHeader[2])+"]"             // 22.AddSlot Header 3
                                       + " ["+nullParam(addSlotHeader[3])+"]"             // 23.AddSlot Header 4
                                       + " ["+nullParam(addSlotHeader[4])+"]"             // 24.AddSlot Header 5
                                       + " ["+nullParam(addSlotHeader[5])+"]"             // 25.AddSlot Header 6
                                       + " ["+nullParam(addSlotHeader[6])+"]"             // 26.AddSlot Header 7
                                       + " ["+nullParam(addSlotHeader[7])+"]"             // 27.AddSlot Header 8
                                       + " ["+nullParam(addSlotHeader[8])+"]";            // 28.AddSlot Header 9
                       
                       formObject.com_mrdArguments.value = rdParam;
                       ComOpenRDPopup('resizable=yes');
                       
                       break;
 
               } // end switch
//           }catch(e) {
//               if( e == "[object Error]") {
//                   ComShowMessage(OBJECT_ERROR);
//               } else {
//                   ComShowMessage(e);
//               }
//           }
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
        * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
        * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
        * @param {ibmulticombo} combo_obj    IBMultiCombo Object
        **/
       function setComboObject(combo_obj){
          comboObjects[comboCnt++] = combo_obj;
       }
       
       /**
        * IBTab Object를 배열로 등록
        * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
        * 배열은 소스 상단에 정의
        */
       function setTabObject(tab_obj){
           tabObjects[tabCnt++] = tab_obj;

       }
       
       /**
        * Combo 기본 설정
        * Combo의 항목을 설정한다.
        */
       function initCombo(comboObj) {
           with(comboObj) {
               switch(id) {
                   case "region":
                       SetTitle("Code|Description");
                       SetColWidth("45|120")
                       DropHeight = 0;
                       MultiSelect = false;
                       MaxSelect = 1;
                       UseAutoComplete = true;
                       ValidChar(2,0);
                       Enable = false;
                       break;
                       
                   case "port_cd":
                      // SetTitle("Code|Description|CallInd");
                       SetColWidth("50|230|0")
                       DropHeight = 250;
                       MultiSelect = false;
                       MaxSelect = 1;
                       UseAutoComplete = true;
                       ValidChar(2,0);
                       break;
               }
           }
       }
 
        
       /**
        * Tab 기본 설정
        * 탭의 항목을 설정한다.
        */
       function initTab(tabObj , tabNo) {

            switch(tabNo) {
                case 1:
                   with (tabObj) {
                       var cnt  = 0 ;
                       for(; cnt < aTabTitle.length; cnt++){
                           InsertTab(cnt, aTabTitle[cnt], -1);
                       }
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
            var formObj = document.form;
            for(i=0;i<sheetObjects.length;i++){

                //khlee-시작 환경 설정 함수 이름 변경
                    ComConfigSheet (sheetObjects[i] );
        
                    initSheet(sheetObjects[i],i+1);
                    
                //khlee-마지막 환경 설정 함수 추가
                    ComEndConfigSheet(sheetObjects[i]);
            }

            
           for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
           }
           //Combo 초기화
           for(var m=0; m<comboObjects.length; m++){
               initCombo(comboObjects[m]);
           }
           
           initControl();
           
           doActionIBSheet( sheetObjects[0], formObj, IBCLEAR);
           tab1_OnClick( tabObjects[0] , 0);
           formObj.vsl_cd.focus();
       }
        
        /**
         * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
         * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
         * @param {ibsheet} sheetObj    IBSheet Object
         * @param {int}     sheetNo     sheetObjects 배열에서 순번
         **/
        function initControl(){
            var form = document.form;
 
           axon_event.addListenerForm  ('keyup'   , 'obj_keyup'  ,   form);
           axon_event.addListenerForm  ('keypress', 'obj_keypress',     form); 
 
        }
     
      /**
       * Form Object  keydown 이벤트시 처리
       * @param  void
       * @return void
       */     
       function obj_keyup(){
            
            var obj = event.srcElement;
            var formObj = document.form;
 
            switch (obj.name){
            

               case 'vsl_cd':
                     var objMaxLength = obj.getAttribute("maxLength");

                     if (ComChkLen(obj.value, objMaxLength) == 2) {
                         ComSetNextFocus(obj);
                     }
                     ComClearObject(formObj.voy_no);
                     ComClearObject(formObj.dir_cd);
                     fnClearSearchOption();
                     break;
                     
               case 'voy_no':
                     var objMaxLength = obj.getAttribute("maxLength");
                     if (ComChkLen(obj.value, objMaxLength) == 2) {
                         ComSetNextFocus(obj);
                     }
                     ComClearObject(formObj.dir_cd);
                     fnClearSearchOption();
                     break;
                     
               case 'dir_cd':
                     fnClearSearchOption();
                     doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC03 );//Check VVD 
                     break;
            }
       }
       /**
        * Popup 클릭시 Call Back Start ...
        */

      function setCallBackVSL(rtnObjs) {
 
          var formObj = document.form;
 
          if(rtnObjs){
 
              var rtnDatas = rtnObjs[0];
 
              if(rtnDatas){
 
                  if(rtnDatas.length > 0){
 
                      formObj.vsl_cd.value =  rtnDatas[1];
                      formObj.voy_no.focus();
                  }
              }
          }
      } 

      function setCallBackVVD(obj) {
          var formObj = document.form;
          if(obj){
              var rtnDatas = obj[0];
              if(rtnDatas){
                  if(rtnDatas.length > 0){
                      formObj.voy_no.value = rtnDatas[2];
                      formObj.dir_cd.value = rtnDatas[3];
                  }
              }
          }
        
          doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01 ); 
      } 
       /**
        * 
        * <pre>
        *   조회옵션 Clear , Region, Port Cd, port nm, sys_create_desc
        * </pre>
        *
        * @author jang kang cheol
        */
       function fnClearSearchOption(){
           var formObj = document.form;
           formObj.region.Code2 = "";
           formObj.port_cd.Code2 = "";
           ComClearObject(formObj.port_cd_nm);
           ComClearObject(formObj.sys_create_desc);
           fnClear();
       }
        /**
         * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
         **/
        function obj_keypress() {
            var obj = event.srcElement;
            var formObj = document.form;
            switch (obj.name){
                case 'vsl_cd':
                      ComKeyOnlyAlphabet('uppernum');
                      break;
                      
                case 'voy_no':
                     //숫자만 입력가능.
                      ComKeyOnlyNumber(event.srcElement);
                      break;
                      
                case 'dir_cd':
                      ComKeyOnlyAlphabet('upper');

                      break; 
            } 
        }
        
 
       
       /**
        * HTML Control의 onfocus이벤트에서 블럭설정. <br>
        **/
       function focus_event(){
           //ComSetFocus(event.srcElement);
           event.srcElement.select();
       }
 
    
       /**
        * 시트 초기설정값, 헤더 정의
        * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
        * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
        */
       function initSheet(sheetObj,sheetNo ) {
 
                var sheetID = sheetObj.id;
                var cnt = 0;
                switch(sheetID) {
                    case "sheet1":
                        with (sheetObj) {

                            // 높이 설정
                            style.height = 120;
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
                            
                            var HeadTitle = "|VSL_CD|VOY_NO|DIR_CD|REGION|PORT_CD|RDR_DATE|RDR_USER|NIS_DATE|REMARK|UPDATE_USER|UPDATE_TIME|NEXT_PORT|ETA|NEXT_CANAL|ETA_CANAL|UPDATE_SYS";
                            var headCount = ComCountHeadTitle(HeadTitle);

                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                            InitColumnInfo(headCount, 0, 0, true);

                            // 해더에서 처리할 수 있는 각종 기능을 설정한다
                            InitHeadMode(true, true, false, true, false,false);

                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                            InitHeadRow(0, HeadTitle, true);

                            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                            var prefix = sheetObj.id+"_";
                            InitDataProperty(0, cnt++ , dtStatus,  30,    daCenter,      false,  prefix+"ibflag");
                            InitDataProperty(0, cnt++ , dtData   , 40,    daCenter,       true,   prefix+"vsl_cd"     ,  false,  "",     dfNone,     0,  false,  true );
                            InitDataProperty(0, cnt++ , dtData   , 40,    daCenter,       true,   prefix+"voy_no"     ,  false,  "",     dfNone,     0,  false,  true );
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"dir_cd"     ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"region"     ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"port_cd"    ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"rdr_date"   ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"rdr_user"   ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"nis_date"   ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"remark"     ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"update_user",  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"update_time",  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"next_port"  ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"eta"        ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"next_canal" ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"eta_canal"  ,  false,  "",     dfNone,     0,  true,  true);
                            InitDataProperty(0, cnt++ , dtData        , 40,    daCenter,       true,   prefix+"update_sys" ,  false,  "",     dfNone,     0,  true,  true); 
                        }
                        break;
                   
                }
       }

        /*************************************************************
         * Sheet관련 프로세스 처리
         *   Main Frame의 조회옵션을 Sub Frame Hidden값으로 셋팅하여 
         *   Sub Frame의 Sheet를 구동하는 방식으로 프로그램을 제작한다.
         *************************************************************/
        function doActionIBSheet(sheetObj,formObj,sAction ) {
 
            switch(sAction) {
            
                case    IBCLEAR:      //초기 Region Combo Setting
                        formObj.f_cmd.value = SEARCH01;            
                        var param  =  FormQueryString(formObj)+"&comboCd=CD02169"; //Region 코드 
                        var sXml   =  sheetObj.GetSearchXml("VOP_OPF_UTILGS.do", param );
                        ComXml2ComboItem( sXml, formObj.region, "val","val|desc" );
                        break;

                        
                case    IBSEARCH_ASYNC01:      //Port(Port Code) Combo Setting
                        formObj.f_cmd.value = SEARCHLIST02;            
                        var param           =  FormQueryString(formObj);
                        var sXml            = sheetObj.GetSearchXml("VOP_OPF_0046GS.do", param);
                        ComXml2ComboItem( sXml, formObj.port_cd, "val","name|call_ind|region" );
                        formObj.region.focus();
                        break;

                case    IBSEARCH_ASYNC02:   //Header 정보 가져오기.
                        formObj.f_cmd.value = SEARCHLIST01;            
                        var prefix = sheetObj.id+"_";
                        var param =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                        sheetObj.DoSearch("VOP_OPF_0046GS.do", param);
                        
                        if(sheetObj.RowCount > 0){
                            if(sheetObj.CellValue(sheetObj.LastRow, prefix + "update_sys") == "N"){
                                formObj.sys_create_desc.value = "Internally Produced";
                            }else{
                                formObj.sys_create_desc.value = "Externally Produced";
                            }
                        }
                         
                        break;
                        
                case    IBSEARCH_ASYNC03:   //VVD Check
 
                        formObj.f_cmd.value = SEARCH06;
                        var param =  FormQueryString(formObj)+"&skd_voy_no="+formObj.voy_no.value+"&skd_dir_cd="+formObj.dir_cd.value;
                        var sXml   =  sheetObj.GetSearchXml("VOP_OPF_UTILGS.do", param );
                        if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                            if( ComGetTotalRows(sXml) == "0"  ){
                                ComShowCodeMessage("OPF50004", "VVD Code");
                                ComClearObject( formObj.vsl_cd );
                                ComClearObject( formObj.voy_no );
                                ComClearObject( formObj.dir_cd );
                                ComSetFocus   ( formObj.vsl_cd );
                                return;
                            }else{//검증정상시, Port List 조회
                                doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                            }
                        }
                        break;
                        
                case    IBSEARCH:      //Retrieve 
                        if( !validateForm( sheetObj,formObj,sAction ) ){ return;} 
                        if(formObj.sys_create_desc.value == ""){
                            fnGetHeader();
                        }
                       /**********************************************************************************************
                        * beforetab : Tab 이벤트에서는 before로 사용하지만, 그외에는 현재 Current Tab Page로 사용한다.
                        *********************************************************************************************/
                        var subFrameObj  =  eval( aTabIframeId[beforetab] ); //Iframe 추출.
                        
                        /********   Main Frame의 조회옵션을 Sub Frame Hidden값으로 셋팅한다.   *******/
                        fnSetFramSearchOption(subFrameObj);
                        /***************************************************************************/
                        subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, sAction);
                        fnSetBtnAuth();
                        break;
 
                case    IBSAVE:        //저장
                        if(!validateForm( sheetObj,formObj,sAction )){ return;}
                        /**********************************************************************************************
                         * beforetab : Tab 이벤트에서는 before로 사용하지만, 그외에는 현재 Current Tab Page로 사용한다.
                         *********************************************************************************************/
                        var subFrameObj  =  eval( aTabIframeId[beforetab] ); //Iframe 추출.
                        
                        /********   Main Frame의 조회옵션을 Sub Frame Hidden값으로 셋팅한다.   *******/
                        fnSetFramSearchOption(subFrameObj);
                        /***************************************************************************/
                        subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, sAction);
                        break;

                case    IBDELETE:      //삭제.
                        if(!validateForm( sheetObj,formObj,sAction )){ return;}
    //                    /**********************************************************************************************
    //                     * beforetab : Tab 이벤트에서는 before로 사용하지만, 그외에는 현재 Current Tab Page로 사용한다.
    //                     *********************************************************************************************/
    //                    var subFrameObj  =  eval( aTabIframeId[beforetab] ); //Iframe 추출.
    //                    
    //                    /********   Main Frame의 조회옵션을 Sub Frame Hidden값으로 셋팅한다.   *******/
    //                    fnSetFramSearchOption(subFrameObj);
    //                    /***************************************************************************/
    //                    subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, sAction);
     
                        formObj.f_cmd.value = REMOVELIST;
                        var sParam =   FormQueryString(formObj);
                        var sXml   =   sheetObj.GetSearchXml("VOP_OPF_0046GS.do" ,   sParam  );
                        sheetObj.LoadSearchXml( sXml );
                        
                        if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                            fnAllGridInit();
                        }
                        break;
                        
                case    IBRESET: //Btn_New

                        formObj.vsl_cd.value          = "";
                        formObj.voy_no.value          = "";
                        formObj.dir_cd.value          = "";
                        formObj.region.Code2          = "";
                        
                        fnClear();
                        
                        formObj.vsl_cd.focus();
                        break; 
            }
        }
       function sheet1_OnLoadFinish(sheetObj){

   
       }
       
       function   fnGetHeader(){
           var formObj = document.form;
           doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC02);
       }
       function fnClear(){
           var formObj = document.form;
           ComOpfSetBtnEnable("c", false);                        
           formObj.port_cd.Code2         = "";
           formObj.port_cd_nm.value      = "";
           formObj.sys_create_desc.value = "";
           
           formObj.port_cd.RemoveAll();

           fnGridClear();
       }
       function fnGridClear(){
           var formObj = document.form;
           formObj.flagRetrieveYn.value = "N";//페이지 조회 발생  Flag
           for(var i=0;i<sheetObjects.length;i++){
               sheetObjects[i].RemoveAll();
           }

           for(var i=0;i<aTabIframeId.length;i++){
               /**********************************************************************************************
                * aTabIframeId : Tab Page Iframe Name 항목 배열. 
                *********************************************************************************************/
                
               var frame    = eval( "document.getElementById('"+aTabIframeId[i]+"')" ); //Iframe 추출.
               if( frame.src != ""){
                   var subFrameObj  =  eval( aTabIframeId[i] ); //Iframe Content Object 추출.
                   subFrameObj.doActionIBSheet(subFrameObj.sheetObjects[0], subFrameObj.form, IBRESET);    
               }
               /***************************************************************************/
           }
       }
       /**
        * Tab 클릭시 이벤트 관련
        * 선택한 탭의 요소가 활성화 된다.
        */
       function tab1_OnClick(tabObj , nItem)
       {
             if(nItem == beforetab){
                return;
             }
             if ( fnSetChangeData() ){//데이타 변경시.
                  doActionIBSheet(sheetObjects[0], document.form, IBSAVE );
                  if( !bTabChangeGo ){//  Save 정상처리 여부, 실패시 페이지 이동-> false :오류, true 정상.
                       tabObj.SelectedIndex = beforetab;
                       var subSheets   =    eval( aTabIframeId[beforetab]+".sheetObjects["+sSheetObjIdx+"]" );
                       subSheets.SelectCell( subSheets.SelectRow,  iSelectCell );
 
                       return;
                  }
             }
             bChangedData = false;
             var objs = document.all.item("tabLayer");
             objs[nItem].style.display     = "Inline";
             
             if( beforetab != -1 ){
                 objs[beforetab].style.display = "none";
             }
 
            beforetab= nItem;
 
            var frame    = eval( "document.getElementById('"+aTabIframeId[nItem]+"')" ); //Iframe 추출.
            var frameSrc = aTabIframeSrc[nItem];
 
            if(frame.src == ""){
                frame.src = frameSrc;
            }else{
                /* Iframe에 src 값이 존재할경우  */
                var  formObj = document.form;
                if(  formObj.flagRetrieveYn.value  == "Y" ){
                     doActionIBSheet( sheetObjects[0], formObj, IBSEARCH);
                }
            }
       }
         
        /**
         * 
         * <pre>
         *     변경여부 
         * </pre>
         *
         * @param   
         * @return {true(변경시), false}
         * @author jang kang cheol
         */
       function fnSetChangeData(){
           var subFrameObj  =  eval( aTabIframeId[beforetab] ); //Iframe 추출.
           if(beforetab == -1){
               return false;
           }
           var subSheets    =  subFrameObj.sheetObjects;
           if(subSheets == undefined||subSheets == null){return;}
           var rowCnt = 0;
           for(var i=0;i< subSheets.length ;i++){
               rowCnt += subSheets[i].RowCount("I")+subSheets[i].RowCount("U")+subSheets[i].RowCount("D");
 
           }
           if( rowCnt > 0){
               bChangedData = true;
               return true;
           }
           return false;
       }
        /**
         * 
         * <pre>
         *    Region Combo OnChange 이벤트 구현.
         * </pre>
         *
         * @author jang kang cheol
         */
       function region_OnChange( comboObj, idx_cd, text ){
           var formObj = document.form;
           formObj.port_cd.Code2 = "";
           ComClearObject(formObj.port_cd_nm);
           ComClearObject(formObj.sys_create_desc);
       }
     /**
      * 
      * <pre>
      *    Port Code Combo OnChange 이벤트 구현.
      * </pre>
      *
      * @author jang kang cheol
      */
       function port_cd_OnChange( comboObj, idx_cd, text ){
           var formObj = document.form;
           var aText = text.split("|");
           formObj.port_cd_nm.value = comboObj.GetIndexText( comboObj .Index, 1  );
           formObj.region.Code2 = comboObj.GetIndexText( comboObj .Index, 3  );
           formObj.sys_create_desc.value = "";
           fnGridClear();
       }
       /**
        * 화면 폼입력값에 대한 유효성검증 프로세스 처리
        */
       function validateForm(sheetObj,formObj,sAction){
           if(!ComChkValid(formObj))
           {
             return false;
           }
           if( formObj.region.Code  == "" ){
               ComShowCodeMessage("COM130201", "Region");
               formObj.region.focus();
               return false;
           }
           if( formObj.port_cd.Code  == "" ){
               ComShowCodeMessage("COM130201", "Port");
               formObj.port_cd.focus();
               return false;
           }
           switch( sAction ){
                   case IBSEARCH: 
                        break;
                        
                   case IBSAVE: 
                         if( formObj.port_cd.Code  == "" ){
                            ComShowCodeMessage("COM130201", "Port");
                            formObj.port_cd.focus();
                            return false;
                         }
                       break;

                   case IBDELETE: 

                       if( !ComShowCodeConfirm("OPF50002", "RDR Data" ) ){                            
                           return false;
                       }   
                       break;           

           }
           return true;
       }
     /**
      *  Main Frame의 조회옵션을 SubFrame의 Hidden Element로 셋팅한다.
      *  Sub Frame에서 Submit() <br>
      *  
      * @param subFrameObj : Sub Frame Object
      * @return void
      * @author jang kang cheol
      * @version 2010.03.03
      */
       function fnSetFramSearchOption(subFrameObj){
           var mForm   = document.form;
           var sForm   = subFrameObj.form;
           if(sForm == undefined||sForm ==null){return;}
           sForm.vsl_cd.value      =    mForm.vsl_cd.value;
           sForm.voy_no.value      =    mForm.voy_no.value;
           sForm.dir_cd.value      =    mForm.dir_cd.value;
           sForm.region.value      =    mForm.region.Code;
 
           sForm.port_cd.value     =    mForm.port_cd.Code;
       }
      /**
       * 화면 폼입력값에 Null Check
       */
      function nullParam(itemValue){
          
          if(itemValue==null || itemValue=="" || itemValue=="undefined"){
              return "";
          }
          else{
              return itemValue;
          }
      }
      /**
       * 
       * <pre>
       *    버튼 권한 부여 Externally 데이타는  ReadOnly
       * </pre>
       * @author jang kang cheol
       */
      function fnSetBtnAuth(){
          var formObj    = document.form;
          var update_sys =  formObj.sys_create_desc.value; //Externally, Internally
          //2010.12.14 P.H.D. Externally도 수정가능하게 한다.
          if( update_sys.indexOf( "Externally" ) > -1 ){
        	  if (beforetab == 1){
        		  ComOpfSetBtnEnable("c", false);
        	  }else{
        		  ComOpfSetBtnEnable("c", true);
        	  }
          }else{
              ComOpfSetBtnEnable("c", true);
          }
      }
      function fnAllGridInit(){
          
          for(var k=0;k<aTabIframeId.length ;k++ ){
              var subFrameObj  =  eval( aTabIframeId[k] ); //Iframe 추출.
              var subSheets    =  subFrameObj.sheetObjects;
              if(subSheets == undefined||subSheets == null){continue;}
              
              for(var i=0;i< subSheets.length ;i++){
                  subSheets[i].RemoveAll();
              } 

              var subForm_ifrVslMvmt =   eval( aTabIframeId[k] );
              if( aTabIframeId[k] == "ifrVslMvmt"){
                  ComClearObject( subForm_ifrVslMvmt.form.next_port    );
                  ComClearObject( subForm_ifrVslMvmt.form.eta          );
                  ComClearObject( subForm_ifrVslMvmt.form.next_canal   );
                  ComClearObject( subForm_ifrVslMvmt.form.eta_canal    ); 
              }
              if( aTabIframeId[k] == "ifrRemark"){
                  subForm_ifrVslMvmt.form.remark.value = "";
              }

          }
           
          

          
          
          var formObj = document.form;
 
          ComClearObject(formObj.vsl_cd);
          ComClearObject(formObj.voy_no);
          ComClearObject(formObj.dir_cd);
          formObj.region.Code2 = "";
          formObj.port_cd.RemoveAll();
          ComClearObject(formObj.port_cd_nm);
          ComClearObject(formObj.sys_create_desc);  
          formObj.flagRetrieveYn.value = "";
 
          formObj.vsl_cd.focus();
      }
       /* 개발자 작업  끝 */