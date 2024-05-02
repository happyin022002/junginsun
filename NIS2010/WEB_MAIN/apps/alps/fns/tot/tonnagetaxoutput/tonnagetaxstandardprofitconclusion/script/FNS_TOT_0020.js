/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0020.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.05 장창수
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
     * @class fns_tot_020 : fns_tot_020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_020() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }


    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var closing_dt = "";

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
                    case "btn_Retrieve":
                    	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                        break;
                    
                    case "btn_New":
       				 		setDate();
       				 	    formObject.vsl_cnt.value = "";
       				        formObject.vsl_total.value = "";
       				 		sheetObject1.RemoveAll();
                        break;
                        
                    case "btn_DownExcel":
                    	sheetObject1.SpeedDown2Excel(-1);
                        break;
    				case "btns_back":

	   	                 if(formObject.s_stl_yrmon.value == null || formObject.s_stl_yrmon.value == ""){
	   	                	 ComShowCodeMessage('TOT00003');
	   	                	 return;
	   	                 }
	   	                 formObject.s_stl_yrmon.value = ComGetDateAdd(formObject.s_stl_yrmon.value+"-01","M",-1).substring(0,7);

   					break;

    				case "btns_next":
   					
	   	                 if(formObject.s_stl_yrmon.value == null || formObject.s_stl_yrmon.value == ""){
	   	                	 ComShowCodeMessage('TOT00003');
	   	                	 return;
	   	                 }
	   	                 formObject.s_stl_yrmon.value = ComGetDateAdd(formObject.s_stl_yrmon.value+"-01","M", 1).substring(0,7);
   	                 
   					break;
   					
    				case "btns_back2":

	   	                 if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
	   	                	 ComShowCodeMessage('TOT00003');
	   	                	 return;
	   	                 }
	   	                 formObject.e_stl_yrmon.value = ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M",-1).substring(0,7);

  					break;

   				    case "btns_next2":
  					
	   	                 if(formObject.e_stl_yrmon.value == null || formObject.e_stl_yrmon.value == ""){
	   	                	 ComShowCodeMessage('TOT00003');
	   	                	 return;
	   	                 }
	   	                 formObject.e_stl_yrmon.value = ComGetDateAdd(formObject.e_stl_yrmon.value+"-01","M", 1).substring(0,7);
  	                 
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
        
    function setDate(){
        	var today=new Date();
        	var y = today.getFullYear().toString();
        	var m = today.getMonth();
        		
        	if(m<10){
        		m = "0"+m;
        	}
        	document.form.s_stl_yrmon.value = y+"-01";    	
        	document.form.e_stl_yrmon.value = closing_dt;	
    }
        
    /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        	//** Date 구분자 **/
        	DATE_SEPARATOR = "-";
        	var formObject = document.form;
        	
           //Axon 이벤트 처리1. 이벤트catch
       	  	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
       	  	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
       	   axon_event.addListenerFormat('keypress','obj_keypress', form);            
       	   axon_event.addListener  ('blur'  , 's_stl_yrmon_onblur', 's_stl_yrmon');//- customer code 입력 후 name 가져오기
           axon_event.addListener  ('blur'  , 'e_stl_yrmon_onblur', 'e_stl_yrmon');//- customer code 입력 후 name 가져오기
           axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    

       	   //axon_event.addListener  ('blur'  , 'c_stl_yrmon_onblur', 'c_stl_yrmon');//- customer code 입력 후 name 가져오기
           //axon_event.addListenerFormat('click'           , 'obj_onclick'  , 	form);
    }

    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
         ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
         ComClearSeparator(event.srcElement);
    }

	function obj_keypress(){
		switch(event.srcElement.dataformat){
		    case "ym":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		}
	}      
	  
	function form_keyup(){
		ComKeyEnter('lengthnextfocus');
	}        
    
	//s_stl_yrmon 변경시 조회 
    function s_stl_yrmon_onblur(){
       	//alert("s_stl_yrmon_onblur");
       	var formObject = document.form;

      		if (formObject.s_stl_yrmon.value ==null || formObject.s_stl_yrmon.value ==""){
      			
      			ComShowCodeMessage('TOT00007');
      			ComSetFocus(formObject.s_stl_yrmon);
      			
      			return false;
      		}

    }       
    
    //e_stl_yrmon 변경시 조회 
    function e_stl_yrmon_onblur(){
       	//alert("e_stl_yrmon_onblur");
       	var formObject = document.form;

      		if (formObject.e_stl_yrmon.value ==null || formObject.e_stl_yrmon.value ==""){
      			
      			ComShowCodeMessage('TOT00008');
      			ComSetFocus(formObject.e_stl_yrmon);
      			
      			return false;
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
    function loadPage(e_stl_yrmon) {

            //IBSheet 초기화하기
            for(i=0;i<sheetObjects.length;i++){

                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
                
                ComEndConfigSheet(sheetObjects[i]);
            }
            closing_dt = e_stl_yrmon;
            initControl();

    }

    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      // t1sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 380;
                        
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 10, 100);

                        var HeadTitle1 = "|Vessel|NRT|USE (%)|Day|Taxable Amount|OPER|Charter Year";
                        var headCount = ComCountHeadTitle(HeadTitle1);					

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)
                        
                         var prefix = "sheet1_";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++, dtHiddenStatus,	          0,	daCenter,	true,		"Status");
                        InitDataProperty(0, cnt++, dtData,					130,	daCenter,	true,		prefix+"vsl_cd",				false,		"",       dfNone,	0,	false,	false);
                        InitDataProperty(0, cnt++, dtData,					130,	daRight,	false,	prefix+"nrt_wgt",					false,		"",       dfNullInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,					140,	daRight,	false,	prefix+"use",					false,		"",       dfNullFloat,		2,	false,	false);
						InitDataProperty(0, cnt++, dtData,					120,	daRight,	false,	prefix+"voy_dys",					false,		"",       dfNullInteger,	0,	false,	false);
						
						InitDataProperty(0, cnt++, dtData,					200,	daRight,	false,	prefix+"tong_tax_amt",		false,		"",       dfNullInteger,	0,	false,	false);
						InitDataProperty(0, cnt++, dtCombo,					100,	   daCenter,	true,		prefix+"tong_flet_tp_cd",					false,		"",       dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++, dtData,					60,	daRight,	true,		prefix+"ctrt_dys",	false,		"",       dfNullFloat,		2,	false,	false);


						InitDataCombo(0, prefix+"tong_flet_tp_cd", "Joint Oper|Charter|Feeder|T/C Out|Owner", "J|C|F|T|O");
    					
                    }
                    break;
            }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
                case IBSEARCH:      //조회
		             if (validateForm(sheetObj, formObj, sAction)){
			             	
		                 if ( sheetObj.id == "sheet1"){
		     				 formObj.f_cmd.value = SEARCH;
		     				 var prefix = "sheet1_";	//prefix 문자열 배열
		
			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0020GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			    			 sheetObjects[0].LoadSearchXml(sXml);

			    			formObj.vsl_cnt.value = ComGetEtcData(sXml,"total_cnt"); 
			    	     	formObj.vsl_total.value = ComRound(ComGetEtcData(sXml,"total_txAmt"),3); 
			    			
			    			ComChkObjValid(formObj.vsl_cnt);
			    			ComChkObjValid(formObj.vsl_total);
		                 }
		                 
		             }

                    break;

            }
    }

    /*
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
       		sheetObj.ShowDebugMsg = false;
       		var formObject = document.form;
       		var prefix="sheet1_";
       		switch (sAction) {

   			
   			   case IBSEARCH: //조회
   					if (formObject.s_stl_yrmon.value ==null || formObject.s_stl_yrmon.value ==""){
   						ComShowCodeMessage('TOT00003');
   						ComSetFocus(formObject.s_stl_yrmon);
   						return false;
   					}

					if (formObject.e_stl_yrmon.value ==null || formObject.e_stl_yrmon.value ==""){
						ComShowCodeMessage('TOT00003');
   						ComSetFocus(formObject.e_stl_yrmon);
   						return false;
   					}

   				break;
   				
       			default:
       				break;
       		}
       		return true;

    }

	/* 개발자 작업  끝 */