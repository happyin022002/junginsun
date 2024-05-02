/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_TEST.js
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
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
     * @class ESD_PRD_0003 : ESD_PRD_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_PRD_0003() {
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
   
    var docObjects = new Array();
  
    var nodeCd = "";
    var retValidate = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    
        function processButtonClick(){
        	
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject1 = sheetObjects[0];
    		        // var sheetObject2 = sheetObjects[1];
             /*******************************************************/
             var formObject = document.form;
             var param ;
        	try {
        	
        		var srcName = window.event.srcElement.getAttribute("name");
        		
        		 var srcObj=window.event.srcElement.nodeName;
                 var keyObj=window.event.keyCode;
                 //if(srcObj =='INPUT' && keyObj ==13) {
                //	 srcName ='btn_retrieve';
                 //}    
                switch(srcName) {
    				case "btn_new":
    					sheetObject1.RemoveAll();
        	            formObject.reset();
        	            break;
    				case "btn_retrieve":
    						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    						break;
    				case "loc_btn":
            		    param = '?classId='+"COM_ENS_0051"+'&loc_cd='+formObject.location_code.value;
            		    ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                        break;
                    case "node_btn":
            		    param = '?classId='+"COM_ENS_0061"+'&node_cd='+formObject.node_code.value;
            		    ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                        break;        
                        
           	        case "btn_cnt":
          	            selectCountry('cnt');
            	        break; 
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			alert(ComGetMsg('COM12111'));
        		} else {
        			ComShowMessage(e);
        		}
        	}
        }
        
        function getLoc(rowArray) {
        	//alertComPopupData('3:'+rowArray);
        	
        	var colArray = rowArray[0];

        	document.all.location_code.value = colArray[3];

        }

        function getNode(rowArray) {
            
        	var colArray = rowArray[0];
        	document.all.node_code.value = colArray[3];    	
        }
        
        
        function prdComKeyEnter(){
       
        	
          
          var keyObj=window.event.keyCode;
        
          if(keyObj ==13) {
        	  ComKeyEnter('search');
          }
        }
          
        function prdComKeyDown(){
        	var keyObj=window.event.keyCode;
        	if(keyObj == 9){
      	  		inputChkUpper(document.form.location_code,keyObj , 'SEARCH02');
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
    			
    			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			//Axon 이벤트 처리1. 이벤트catch
    			axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    			axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    			axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    			axon_event.addListener('keypress', 'prdComKeyEnter' , 'country_code', 'location_code', 'node_code');
    			axon_event.addListener('keydown', 'prdComKeyDown' , 'location_code');
    			
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
                        style.height = 100;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;
                        //MergeSheet = msNone;
                        
                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        var HeadTitle1 = "No.|Yard Code|Yard Name";
    					//var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(28, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false, false);
                        

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        var prefix="sheet1_";
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++, dtSeq,        60,    daCenter,  true,    "");
                        InitDataProperty(0, cnt++, dtData,      200,    daCenter,  true,   prefix +  "yard_code",        false,          "",       dfNone,    0,     false,       true);
                        InitDataProperty(0, cnt++, dtData,      300,    daLeft,    true,   prefix + "yard_name",        false,          "",       dfNone,    0,     false,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "address",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "pic",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "tel",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "fax",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "email",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code1",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name1",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code2",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name2",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code3",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name3",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code4",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name4",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code5",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name5",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code6",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name6",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code7",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name7",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code8",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name8",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code9",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name9",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_code10",        false,          "",       dfNone,    0,     true,       true);
                        InitDataProperty(0, cnt++, dtHidden,      300,    daLeft,    true,  prefix +   "com_name10",        false,          "",       dfNone,    0,     true,       true);

    					//CountPosition = 0;
    								}
                    break;



            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

				case IBSEARCH:      //조회
					if(validateForm(sheetObj,formObj,sAction))
						
						if (sheetObj.id == "sheet1")
							formObj.f_cmd.value = SEARCH;
							sheetObj.DoSearch("ESD_PRD_0003GS.do",PrdFQString(formObj) + "&" + ComGetPrefixParam("sheet1_"));

				break;
    						
            }
        }


        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }

            return true;
        }


            
            
            function sheet1_OnDblClick(sheetObj, row, col, value) {
                var prefix = "sheet1_";
        		document.form.yard_code.value = sheetObj.cellValue(row,prefix+ "yard_code");
        		document.form.yard_name.value = sheetObj.cellValue(row,prefix+ "yard_name");
        		document.form.address.value = sheetObj.cellValue(row,prefix+ "address");
        		document.form.pic.value = sheetObj.cellValue(row,prefix+ "pic");
        		document.form.tel.value = sheetObj.cellValue(row,prefix+ "tel");
        		document.form.fax.value = sheetObj.cellValue(row,prefix+ "fax");
        		document.form.e_mail.value = sheetObj.cellValue(row,prefix+ "email");
        		document.form.com_code1.value = sheetObj.cellValue(row,prefix+ "com_code1");
        		document.form.com_name1.value = sheetObj.cellValue(row,prefix+ "com_name1");
        		document.form.com_code2.value = sheetObj.cellValue(row,prefix+ "com_code2");
        		document.form.com_name2.value = sheetObj.cellValue(row,prefix+ "com_name2");
        		document.form.com_code3.value = sheetObj.cellValue(row,prefix+ "com_code3");
        		document.form.com_name3.value = sheetObj.cellValue(row,prefix+ "com_name3");
        		document.form.com_code4.value = sheetObj.cellValue(row,prefix+ "com_code4");
        		document.form.com_name4.value = sheetObj.cellValue(row,prefix+ "com_name4");
        		document.form.com_code5.value = sheetObj.cellValue(row,prefix+ "com_code5");
        		document.form.com_name5.value = sheetObj.cellValue(row,prefix+ "com_name5");
        		document.form.com_code6.value = sheetObj.cellValue(row,prefix+ "com_code6");
        		document.form.com_name6.value = sheetObj.cellValue(row,prefix+ "com_name6");
        		document.form.com_code7.value = sheetObj.cellValue(row,prefix+ "com_code7");
        		document.form.com_name7.value = sheetObj.cellValue(row,prefix+ "com_name7");
        		document.form.com_code8.value = sheetObj.cellValue(row,prefix+ "com_code8");
        		document.form.com_name8.value = sheetObj.cellValue(row,prefix+ "com_name8");
        		document.form.com_code9.value = sheetObj.cellValue(row,prefix+ "com_code9");
        		document.form.com_name9.value = sheetObj.cellValue(row,prefix+ "com_name9");
        		document.form.com_code10.value = sheetObj.cellValue(row,prefix+ "com_code10");
        		document.form.com_name10.value = sheetObj.cellValue(row,prefix+ "com_name10");
        		
        		
            }

            
            function selectCountry(cnt){
                cntGb = cnt;
                var frm = document.form;
                var param = '?classId='+"COM_ENS_0051"
                //var sheetObj = docObjects[0];
                if(cntGb == 'cnt') {
                    param = param+'&cnt_cd='+frm.country_code.value;
                } 
                ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);        
                
            }
            
            function getCountry(rowArray) {
            	//alertComPopupData(rowArray);
            	
            	var colArray = rowArray[0];	
                //var sheetObj = docObjects[0];
                var frm = document.form;
                if(cntGb == 'cnt') {
                    frm.country_code.value = colArray[3];
                } 
            }

	/* 개발자 작업  끝 */