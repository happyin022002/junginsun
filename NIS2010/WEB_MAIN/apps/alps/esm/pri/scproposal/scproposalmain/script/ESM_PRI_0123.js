/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057.js
*@FileTitle : Amendment History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.01 공백진
* 1.0 Creation
*=========================================================
* History :
* 2011.04.01 이관샨 [CHM-201109657-01] Amend history 에서 과거 Amendment Print 기능 추가, 변경된 내용만 출력되는 Print 버튼 기능 추가
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
* 2012.04.18 이석준[CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
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
     * @class ESM_PRI_0123 : ESM_PRI_0123 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0123() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage; 
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
     
    
    /* 개발자 작업   */

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 
 var beforeChk = 0; 
 var sheetObjects = new Array();
 var sheetCnt = 0; 
 var comboObjects = new Array();
 var comboCnt = 0; 
 //이전 sc_no 
 var preScNo = "";
 var sUrl = "";
 var tabDataExist = new Array();
 tabDataExist[0] = 0;//rate
 tabDataExist[1] = 0;//note
 //wait image적용 후 각 tab 별로 tab enable 여부를 가지고 있는 변수
 var tabEnableFlg = new Array();
 
 //tab을 활성,비활성 상태로 보이게 하기위하여 지정하는 tab color
 var TAB_SELECT_COLOR = "131,133,217"; 
 var TAB_TRUE_COLOR = "206,220,246";
 var TAB_FALSE_COLOR = "192,192,192";
 
 var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
 var ICON_URL_AMEND = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon4.gif";
 
 //terms가 load 되었는지 확인
 var termLoad = false;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */
 function processButtonClick(){

	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var sRow = sheetObj.SelectRow;
	
  	try {
  		var srcName = window.event.srcElement.getAttribute("name");
          switch(srcName) {
          
          case "btn_retrieve":  
        	  
         	 sheetObj.RemoveAll();     
         	 doActionIBSheet(sheetObj,formObj,IBSEARCH);  
             break;
             
          case "btns_calendar1": //달력버튼
          case "btns_calendar2":
              var cal = new ComCalendarFromTo();                
              cal.select(document.form.fm_dt, document.form.to_dt, 'yyyy-MM-dd');

              break;              
          case "btn_new":
         	 formObj.reset();
         	 sheetObj.RemoveAll();
         	 formObj.sc_no.focus();

         	 break;
          case "rqst_usr_popup":
        	  ComOpenPopup('/hanjin/COM_ENS_091.do', 780, 535, 'getCOM_ENS_091_1', '1,0,1,1,1,1,1,1',true, true);
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
  * IBSheet Object를 배열로 등록 <br>
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
  * 배열은 소스 상단에 정의 <br>
  * <br><b>Example :</b>
  * <pre>
  *     setSheetObject(sheetObj);
  * </pre>
  * @param {ibsheet} sheet_obj 필수 IBSheet Object
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */ 
 function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
 }


    /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
     function loadPage() {
         for(var i=0;i<sheetObjects.length;i++){
         		//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         		//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         
         initControl();

         form.sc_no.focus();
     }
  
      
      /**
       * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *     initControl()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */        
     function initControl() {
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)          
    	  axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);   
    	  axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    	  axon_event.addListener ('keyup', "ComKeyEnter('LengthNextFocus')", document.form);

    }      

     /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */      
     function obj_keypress() {
         switch (event.srcElement.dataformat) {
             case "engup":
                 if (event.srcElement.name == "sc_no" ) {
                     ComKeyOnlyAlphabet('uppernum');
                 } else {
                     ComKeyOnlyAlphabet('upper');
                 }    
                 break;
             case "int":
                 ComKeyOnlyNumber(event.srcElement);
                 break;
             case "float":
                 ComKeyOnlyNumber(event.srcElement, ".");
                 break;
             case "ymd":
              	ComKeyOnlyNumber(event.srcElement, "-");
              	break;                 
             default:
         }
     }         
       
     /**
      * Onbeforedeactivate  event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_deactivate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */   
      function obj_deactivate() {
          var formObj = document.form;
          var sheetObj = sheetObjects[0]; 
          var eleName = event.srcElement.name;

          switch(eleName){
  	        default:
                  ComChkObjValid(event.srcElement);       
          }
          
      }        
     /**
      * Sheet관련 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */  
      function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         try{
             switch(sAction) {
             case IBSEARCH:      //조회
            	    
       		    formObj.f_cmd.value = SEARCH;
//       		 if (validateForm(sheetObj,document.form,sAction)) {
    				ComOpenWait(true);   
    				sheetObj.RemoveAll();
    				var sXml = sheetObj.GetSearchXml("ESM_PRI_0123GS.do", FormQueryString(formObj) );
    				sheetObj.LoadSearchXml(sXml)	
 				    ComOpenWait(false);
//       		   }
    				break;
	
	          }        	 
         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
         }

     }   

      /** 
       * 시트 초기설정값, 헤더 정의
       * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
       * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
       * <br><b>Example :</b>
       * <pre>
       * </pre>
       * @param {object} sheetObj 필수, sheet Object
       * @param {String} sheetNo 필수, sheet의 ID
       * @return 없음
       */ 
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            sheetObj.WaitImageVisible = false; 
            switch(sheetObj.id) {
            
    			case "sheet1":      // sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 440;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 15, 100);

                        var HeadTitle1  = "|SEQ|Request Date|Request Staff|Request Staff|Request Office|Creation Staff|Creation Staff|Reason|S/C No|Proposal No|AMD No|Creation Date";
    					var headCount = ComCountHeadTitle(HeadTitle1);
                        
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 13, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,   	"ibflag");

    					InitDataProperty(0, cnt++ , dtData,		     40,   	daCenter,  	true,		"file_cxl_seq",   		false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"rqst_dt",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			140,   	daCenter,  	true,		"rqst_usr_nm",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData ,    		60,   	daCenter,  	true,		"rqst_usr_id",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			110,   	daCenter,  	true,		"rqst_ofc_cd",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			140,   	daCenter,  	true,		"cre_usr_nm",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"cre_usr_id",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"file_cxl_rsn",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"sc_no",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"prop_no",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daCenter,  	true,		"amdt_seq",   	false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			100,   	daCenter,  	true,		"cre_dt",   	false,          "",      dfNone,      		0,			false,       false);

    					CountPosition = 0;

    			   }
    			break;
            }
        }
        
	    /**
	     * Sample 1 : 팝업에서 Radio로 단일 선택을 한경우..
	     */
	    function getCOM_ENS_091_1(rowArray) {
	    	var formObj = document.form;

	    	var colArray = rowArray[0];

	    	formObj.rqst_usr_id.value = colArray[4];
	    	formObj.rqst_usr_nm.value = colArray[5];

	      	                                                 
	    }
	    
	    /**
	     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	     *         로직처리;
	     *     }
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {form} formObj 필수 html form object
	     * @param {int} sAction 필수 프로세스 플래그 상수
	     * @return bool <br>
	     *          true  : 폼입력값이 유효할 경우<br>
	     *          false : 폼입력값이 유효하지 않을 경우
	     * @author 공백진
	     * @version 2009.04.17
	     */
	    function validateForm(sheetObj, formObj, sAction) {
	        var fm_dt = formObj.fm_dt.value;
	        var to_dt = formObj.to_dt.value;
	        var rqst_usr_nm = formObj.rqst_usr_nm.value;

	        switch (sAction) {
	        case IBSEARCH: // Request
	        	if (formObj.fm_dt.value =="" || formObj.fm_dt.value ==""){
		            ComShowCodeMessage('PRI01030');  
		            formObj.fm_dt.focus();
		            return false;
		        }               		                       
	        	break;
	        }
			return true;
	    } 	    
	    function sheet1_OnClick(sheetObj, Row, Col, Value) {
	      	var colname = sheetObj.ColSaveName(Col);
	        	switch(colname)
	        		{
	    	    	case "file_cxl_rsn":	    		
	    	  			ComShowMemoPad(sheetObj,Row,Col,true,300,200);  
                     break;
	        		}
	    }	    
    /* 개발자 작업  끝 */

