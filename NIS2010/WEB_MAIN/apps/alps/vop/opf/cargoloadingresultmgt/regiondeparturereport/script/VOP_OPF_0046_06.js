/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046_06.js
*@FileTitle : RDR Creation – Remark
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
     * @class VOP_OPF_0046_06 : VOP_OPF_0046_06 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0046_06() {
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
             axon_event.addListenerForm('change', 'obj_change',    form  );    
         }
         /**
          * Form 내의 Object Onchange 이벤트시 처리.
          * 
          * @return void
          */
          function obj_change(){
             obj = event.srcElement;
             var formObj = document.form;
             switch(obj.name ) {
                 case "remark":
 
                       var cRow;
                       if(sheetObjects[0].RowCount == 0 ){
                           cRow = sheetObjects[0].DataInsert(-1);
                       }else{
                           cRow = sheetObjects[0].LastRow;
                           sheetObjects[0].RowStatus( cRow ) = "U";
                       }
 
                       break;
                 
             } // end switch 
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
                         InitRowInfo(1, 1, 10, 100);
                         
                         var HeadTitle1 = "";
 
                         var headCount = ComCountHeadTitle(HeadTitle1);
 

                         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         InitColumnInfo(headCount, 0, 0, true);

                         // 해더에서 처리할 수 있는 각종 기능을 설정한다
                         InitHeadMode(true, true, false, true, false,false);

                         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle1, true);
 

                         //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                         var prefix = sheetObj.id+"_";
                         InitDataProperty(0, cnt++ , dtStatus,    30,    daCenter,   false,  prefix+"ibflag");
                     }
                     break;
             }
         }
        
        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
 
            var prefix =  sheetObj.id+"_";
            switch(sAction) {
                    case    IBSEARCH:      //조회
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value = SEARCHLIST01;
                            var param  =  FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                            var sXml   =  sheetObj.GetSearchXml("VOP_OPF_0046_06GS.do",  param );
    
                            var sMessage = ComOpfGetMessageFromXml(sXml);
                            if( sMessage != ""){
                                ComShowMessage(  sMessage  );
                            }else{
                                var sRemark =   ComGetEtcData(sXml, "remark");
                                if(sRemark == "null"){sRemark="";}
                                ComSetObjValue( formObj.remark,   sRemark );    
                            }
                            break;
  
                    case    IBSAVE:  
                            parent.bEditTabChange = false;
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value =   MULTI01;         
                            var sParam          =   FormQueryString(formObj);
                            var sXml            =   sheetObj.GetSaveXml("VOP_OPF_0046_06GS.do" ,   sParam  );
                            sheetObj.LoadSaveXml( sXml );
                            
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {//정상처리면 헤더 재조회  
                                parent.fnGetHeader();
                            }
                            
                            parent.bEditTabChange = true;
                            break;        
                            
                    case    IBDELETE:  
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value = REMOVE;         
                            var sParam   =   FormQueryString(formObj);
                            var sXml     =   sheetObj.GetSaveXml("VOP_OPF_0046_06GS.do" ,   sParam  );
                            sheetObj.LoadSaveXml( sXml );
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                 formObj.remark.value = "";
                            }
                            break;  
                        
                    case    IBRESET: //Btn_New
                            formObj.remark.value = "";
                            for(var i=0;i<sheetObjects.length;i++){
                                sheetObjects[i].RemoveAll();
                            }
                            break;
            }
        }
 
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
         function validateForm(sheetObj,formObj,sAction){
             switch(sAction) {
             
                     case   IBSAVE:
                            if( ComGetLenByByte(formObj.remark)  > 1000 ){
                                 ComShowCodeMessage('OPF50022',   parent.aTabTitle[parent.beforetab], "1000 Byte ( Current"+ComGetLenByByte(formObj.remark)+" Byte)" );   
                                 return false;   
                            }
                             
                            if( parent.bChangedData ){
                                if( !ComShowCodeConfirm("OPF50003") ){                            
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