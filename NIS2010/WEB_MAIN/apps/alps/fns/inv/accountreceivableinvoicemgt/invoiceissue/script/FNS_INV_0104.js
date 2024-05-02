/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0104.js
*@FileTitle : CPR Download History Inquiry - Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
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
     * @class FNS_INV_0104 : FNS_INV_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0104() {
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

	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;

				case "btn_calendar": //달력버튼
 	               var cal = new ComCalendarFromTo();
		            cal.select(formObject.from_cre_dt,  formObject.to_cre_dt,  'yyyy-MM-dd');
 	                break;
 	             
				case "btn_calendar1":
   	                var cal = new ComCalendar();
   	                cal.select(formObject.from_cre_dt, 'yyyy-MM-dd');
   	            break;
	   	            
				case "btn_calendar2":
   	                var cal = new ComCalendar();
   	                cal.select(formObject.to_cre_dt, 'yyyy-MM-dd');
   	            break;
	   	            
                 case "btn_ok": //달력버튼   	   
                	 callParent();
                	 break; 
                	 
                 case "btn_New":
                	 ComResetAll();
                     break;
                     
                 case "btn_close": //달력버튼   	                
                	 window.close();
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
      * IBSheet Object를 sheetObjects 배열로 등록 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj IBSheet Object
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }



     /** 
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 			
         }
         initControl2();
         document.form.from_cre_dt.focus();
     }
     
     /** 
      * OnLoadFinish 이벤트 발생시 호출되는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트        
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function initControl2() {
  		var formObj = document.form;
  		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
  		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
  		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
  		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
  		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
  		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
  	}
     
     /** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
	}

     /** 
      * Sheet 기본 설정 및 초기화 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {IBSheet} sheetObj : 시트오브젝트
      * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 300;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(7, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Office|Report ID|Creation Date|Template Name|User ID";

                 
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++,	dtHiddenStatus,		 00,	daCenter,  false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,  		 40,    daCenter,  false,    "SelChk");
                     InitDataProperty(0, cnt++ , dtData,     		 60,   daCenter,  false,    "ar_ofc_cd",     false,		"",	dfNone,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,     		 170,   daLeft,  false,    "cust_rpt_id",     false,		"",	dfNone,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,     		 150,   daCenter,  false,    "cre_dt",     false,		"",	dfNone,	0,	false,		false);
                     InitDataProperty(0, cnt++ , dtData,     		 120,   daCenter,  false,    "rpt_tmplt_nm",     false,		"",	dfNone,	0,	false,		false);
                   
                     InitDataProperty(0, cnt++ , dtData,     		 120,   daCenter,  false,    "cre_usr_id",     false,		"",	dfNone,	0,	false,		false);                     
                    

                }
                 break;

  

         }
     }

     /** 
      * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
      * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
      * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
 						if(validateForm(sheetObj,formObj,sAction) == false) return false;  
 		 				
 		 				formObj.f_cmd.value = SEARCH;					
 						var sXml = sheetObj.GetSearchXml("FNS_INV_0104GS.do" , FormQueryString(formObj));
 						var arrXml = sXml.split("|$$|");
 						
 						sheetObjects[0].LoadSearchXml(arrXml[0], false);
 						
 					break;
 					
 					case IBSAVE:        //저장
 						if(validateForm(sheetObj,formObj,sAction))
 							alert (" Save .. ");
 					break;
 					
 					case IBINSERT:      // 입력
 					break;
 					
         }
     }


     /** 
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @return true, false
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
			case IBSEARCH: //조회
				if (ComIsNull(formObj.from_cre_dt)){
					ComShowCodeMessage('INV00004');
					ComSetFocus(form.from_cre_dt);
					return false;
				}else if (ComIsNull(formObj.to_cre_dt)){
					ComShowCodeMessage('INV00004');
					ComSetFocus(form.to_cre_dt);
					return false;
				}								
			break;
    	 }
    	 return true;
     }

     /** 
      * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
	}

	/** 
     * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		switch(event.srcElement.name){
			case "from_cre_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_cre_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;			
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				//ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	//업무 자바스크립트 OnFocusOut 이벤트 처리
	/*
	function obj_focusout11111() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		switch(event.srcElement.name){
			case "to_cre_dt":
				//조회기간 입력값 체크(3달)
				var nextDate = ComGetDateAdd(formObject.from_cre_dt.value, "M", 3);
				
				if (formObject.to_cre_dt.value >= nextDate) {
					//ComShowCodeMessage("INV00043");
					//formObject.to_cre_dt.focus();
				}		
			break;			
	    }
	}
	*/

	/** 
     * 업무 자바스크립트 KeyUp 이벤트 처리 <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_cre_dt":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_cre_dt.focus();
				}
	 		break;
			case "to_cre_dt":
				var toDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (toDt.length == 8) {
					//formObject.ar_ofc_cd.focus();
				}
	 		break;			
	 	}
	}
     
	/* 개발자 작업  끝 */