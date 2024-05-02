/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1105.js
*@FileTitle : 개별 Chassis Movement 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.06.26 최민회
* 1.0 Creation
* 2013.03.12 조경완 [CHM-201323141-01] Movement History를 근거로 Master Data 조회 가능하도록 수정
* 2013.04.15 조경완 [CHM-201323976-01] Oracle SQL Error 방지를 위한 Date Validation 강화 
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
     * @class ees_cgm_1105 : ees_cgm_1105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1105() {
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
 var prefix1 = "sheet1_";
 var prefix2 = "sheet2_";
 
 var IBSEARCH02 = 30;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn_retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;

 				case "btn_new":
 					objectClear();
               	    sheetObject1.RemoveAll();
               	    sheetObject2.RemoveAll();
               	    formObject.eq_no.focus();
 					break;
 					
 				case "btn_downexcel":
 					sheetObject1.SpeedDown2Excel(-1);
 					break;
 				case "btn_print":
 					if( sheetObjects[0].rowcount==0 && sheetObjects[1].rowcount==0) {
 						errMsg = 'No data found.';
 						ComShowMessage(msgs["CGM10012"]);
 						return;
 					}
 					formObject.f_cmd.value = IBSEARCH02;
 					ComOpenPopupWithTarget('/hanjin/EES_CGM_1106.do?pgmNo=EES_CGM_1106', 775, 800, "", "0,1,1,1,1,1,1", true);
					break;
 				 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal = new ComCalendar();
	 				cal.select(formObject.str_mvmt_dt, "yyyy-MM-dd");
	 				break;
	 					
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
//	 				var cal = new ComCalendar();
//	 	    		cal.select(formObject.end_mvmt_dt, "yyyy-MM-dd");
	 	    		var cal = new ComCalendarFromTo();
		            cal.select(formObject.str_mvmt_dt,  formObject.end_mvmt_dt,  'yyyy-MM-dd');
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
    	 var sheetObject1 = sheetObjects[0];
         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);

 				 
         }
        
         
         
         
     }
      
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.WaitImageVisible = false;
         formObj = document.form;
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
         axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
 			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         // 초기화
         initControl(sheetObjects[0]); 
         sheetObj.WaitImageVisible = true; 
    }
     
      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  {object} sheetObj	필수
       * @return 없음
       * @author 최민회
       * @version 2009.05.20
       */
      function initControl(sheetObj){
      	// Form 객체 선언
      	  formObj = document.form;
          // axon event 등록

          
      	if(formObj.eq_no.value !=""){
        	//chungpa 20091006 popup으로 띄울때 default 날짜가 세팅이 안되고 전체 데이터가 조회되는 버그 fix.
 	        var fr_dt = new String(document.form.calend1.value).substring(0,8);
			var to_dt = new String(document.form.calend2.value).substring(0,8);
  			formObj.str_mvmt_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
			formObj.end_mvmt_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
			
        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
         } else {
        	 objectClear();
        	 formObj.eq_no.focus();
         }
        
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
                     style.height = 220;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                     InitRowInfo( 2, 1, 10, 100);

// 					 var HeadTitle1 = "|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History|Chassis Movement History";
                     var HeadTitle2 = "|Seq.|Status|Movement Date|Org. Yard|Dest. Yard|CNTR No.|M.G.Set No.|User company|Remark(s)|Creation Date|User ID|Office|Creation User Name|Update Date|User ID|Office|Update User Name|Trucker|Trucker Description";
                     
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                     InitColumnInfo(headCount, 0, 0, true);
                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(20, 8, 0, true);

                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle2, true);
                  //   InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	45,		daCenter,			false,	prefix1+ "hdnStatus");
					InitDataProperty(0, cnt++ , dtDataSeq,	    		30,		daCenter,			false,	prefix1+ "Seq");
					InitDataProperty(0, cnt++ , dtData,					55,		daCenter,			false,	prefix1+ "mvmt_sts_cd",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,			false,	prefix1+ "mvmt_dt",		    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					90,		daCenter,			false,	prefix1+ "yd_cd",		    false,	"",		dfNone,	0,			false,		true);
					
					InitDataProperty(0, cnt++ , dtData,					90,		daCenter,			false,	prefix1+ "dest_yd_cd",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					100, 	daCenter,			false,	prefix1+ "cntr_no",		    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,			false,	prefix1+ "mg_set_no",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daCenter,			false,	prefix1+ "cntr_ownr_co_cd",	false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,			false,	prefix1+ "diff_rmk",		false,	"",		dfNone,	0,			false,		true);
					
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,			false,	prefix1+ "cre_dt",		    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,			false,	prefix1+ "cre_usr_id",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,			false,	prefix1+ "cre_ofc_cd",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,			false,	prefix1+ "cre_usr_nm",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,			false,	prefix1+ "upd_dt",		    false,	"",		dfNone,	0,			false,		true);

					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,			false,	prefix1+ "upd_usr_id",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,			false,	prefix1+ "upd_ofc_cd",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					120, 	daCenter,			false,	prefix1+ "upd_usr_nm",	    false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,			false,	prefix1+ "vndr_seq",		false,	"",		dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daLeft,				false,	prefix1+ "vndr_abbr_nm",  	false,	"",		dfNone,	0,			false,		true);


// 										InitUserFormat2(0, "MovementDate", "####-##-## ##:##", "-|:" );
// 										InitUserFormat2(0, "CreationDate", "####-##-## ##:##", "-|:" ); 
// 										InitUserFormat2(0, "UpdateDate", "####-##-## ##:##", "-|:" );										

//					CountPosition = 0;

 			  				 }
                 break;
                  
             case "sheet2":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 150;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(6, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

//                     var HeadTitle1 = "Chassis Attach/Detach History|Chassis Attach/Detach History|Chassis Attach/Detach History|Chassis Attach/Detach History|Chassis Attach/Detach History|Chassis Attach/Detach History";
                     var HeadTitle2 = "Seq.|CNTR No.|Attach Date|Attach Yard|Detach Date|Detach Yard";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle2, true);
//                     InitHeadRow(1, HeadTitle2, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDataSeq,		45,		daCenter,			false,	prefix2+ "Seq",			false,	"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			180,	daCenter,			false,	prefix2+ "cntr_no",	    false,	"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			200,	daCenter,			false,	prefix2+ "atch_dt",		false,	"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			170,	daCenter,			false,	prefix2+ "atch_yd_cd",	false,	"",		dfNone,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			200,	daCenter,			false,	prefix2+ "dtch_dt",		false,	"",		dfNone,			0,			false,		true);
                                                      	                                      				
					InitDataProperty(0, cnt++ , dtData,			170, 	daCenter,			false,	prefix2+ "dtch_yd_cd",	false,	"",		dfNone,			0,			false,		true);


//					InitUserFormat2(0, "AttachDate", "####-##-## ##:##", "-|:" );
//					InitUserFormat2(0, "DetachDate", "####-##-## ##:##", "-|:" ); 
				
//					CountPosition = 0;

 			  				 }
                 break;                 

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
            if(validateForm(sheetObj,formObj,sAction)){
            	
            	var prefix0 = "";
            	var aryPrefix = new Array(prefix0,prefix1,prefix2);
            	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
 			 	 
            	sheetObj.WaitImageVisible=false;
 			 	ComOpenWait(true);
 			 	 
                var sXml = sheetObj.GetSearchXml("EES_CGM_1105GS.do" , sParam);
           		var arrXml = sXml.split("|$$|");
           		
//           		if(DomXml2String(arrXml[0], "eq_no") == null || DomXml2String(arrXml[0], "eq_no") == "") {
//        			// 체크 메시지 출력
//        			ComShowCodeMessage("CGM10012");
//        		}
           		//2013.03.12 조경완 [CHM-201323142-01] Master 에 없는 Chassis 에 대한 Mvmt 및 Atch/Dtch 정보도 불러옴
           		if(ComGetTotalRows(arrXml[0])== 0&&ComGetTotalRows(arrXml[1])== 0&&ComGetTotalRows(arrXml[2])== 0){
           			ComShowCodeMessage("CGM10012");
           			objectClear();
               	    sheetObjects[0].RemoveAll();
               	    sheetObjects[1].RemoveAll();
               	    formObj.eq_no.focus();
           		}
                else
                {
                	formObj.eq_tpsz_cd.value   =  DomXml2String(arrXml[0], "eq_tpsz_cd") == undefined ? "" : DomXml2String(arrXml[0], "eq_tpsz_cd");
                	formObj.agmt_lstm_cd.value =  DomXml2String(arrXml[0], "agmt_lstm_cd") == undefined ? "" : DomXml2String(arrXml[0], "agmt_lstm_cd");
                	formObj.chss_pool_cd.value =  DomXml2String(arrXml[0], "chss_pool_cd") == undefined ? "" : DomXml2String(arrXml[0], "chss_pool_cd");
                	formObj.onh_dt.value       =  DomXml2String(arrXml[0], "onh_dt") == undefined ? "" : DomXml2String(arrXml[0], "onh_dt");
                	formObj.aciac_div_cd.value =  DomXml2String(arrXml[0], "aciac_div_cd") == undefined ? "" : DomXml2String(arrXml[0], "aciac_div_cd");
                	// tab1 Sheet Object
             		sheetObjects[0].LoadSearchXml(arrXml[1]);
             		
             	// tab1 Sheet Object
             		sheetObjects[1].LoadSearchXml(arrXml[2]);
                }
           		ComOpenWait(false);
              	
            }
            break;

         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
     		 		if(formObj.eq_no.value == ''){
        				ComShowCodeMessage('CGM10004','Chassis No. ');
        				formObj.eq_no.focus();
        				
        				return false;
        			}
     		 		 var dt_str = ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
         			 var dt_end = ComReplaceStr(document.form.end_mvmt_dt.value,"-","");
     	        	
         			//2013.04.04 2011514 조경완 Oracle Error 수정을 위해 Input Date 의 Validation 강화 
     	    		if(dt_str != '' && dt_end != ''){
     	    			if(dt_end < dt_str){
     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
     	    				str_mvmt_dt.value='';
     	    				str_mvmt_dt.focus();
     	    				return false;
     	    			}

     	    			if(dt_str.length != 8 || dt_end.length != 8){
     	    				ComShowCodeMessage('CGM10084');
     	    				
     	    				if(dt_str.length != 8){
     	    					str_mvmt_dt.focus();
     	    				}else if(dt_end.length != 8){
     	    					end_mvmt_dt.focus();
     	    				}
     	    				
         	    			return false;
     	    			}
     	    		}else if(dt_end == ''){
     	    			ComShowCodeMessage('CGM20048');
     	    			end_mvmt_dt.focus();
 	    				
     	    			return false;
     	    		}
     	    		
     		 		
     		 
            			break;
     		 }      
     	 }

           

         return true;
     }
     
     
 		function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
 			with(sheetObj)
 			{
 				CellAlign(0, "Seq") = daLeft;
 			}
 		}
 		
 		function sheet2_OnSearchEnd(sheetObj, ErrMsg)
 		{
 			with(sheetObj)
 			{
 				CellAlign(0, "Seq") = daLeft;
 			}
 		}
 	      /**
 	       * 기본 오브젝트 초기화 
 	       */
      function objectClear(){
 	       	var formObj = document.form;
 	        var fr_dt = new String(document.form.calend1.value).substring(0,8);
			var to_dt = new String(document.form.calend2.value).substring(0,8);
			
 	        formObj.eq_no.value        = "";
 	        formObj.eq_tpsz_cd.value   = "";
 	        formObj.agmt_lstm_cd.value = "";
 	        formObj.chss_pool_cd.value = "";
 	        formObj.onh_dt.value       = "";
 			formObj.str_mvmt_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
			formObj.end_mvmt_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
			
      }
 	       
 	  	

       
     	/** 
        * Object 의 Keypress 이벤트에 대한 처리  <br>
        * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
        * @param  없음
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */ 
       function obj_keypress(){
      	 obj = event.srcElement;
      	 if(obj.dataformat == null) return;
      	 	
      	 window.defaultStatus = obj.dataformat;
      	 switch(obj.dataformat) {
      	 	case "ymd":
      	 		ComKeyOnlyNumber(obj);
      	        break;
      	    case "eng":
      	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    case "engup":
      	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    
      	 }
      	 
      	 
       }
       
       /** 
        * Object 의 deactivate 이벤트에 대한 처리  <br>
        * @param  없음
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */
        function domFunFocusDel(a)
        {
        	var formObj = document.form;
          	 obj = event.srcElement;
          	if(obj.name=="str_mvmt_dt"  ){
       			
          		document.form.str_mvmt_dt.value = ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
              }
            if(obj.name=="end_mvmt_dt"  ){
       			
            		document.form.end_mvmt_dt.value = ComReplaceStr(document.form.end_mvmt_dt.value,"-","");
             }
        	
           //ComShowMessage("domFunFocusDel");
        }
        
        /** 
         * Object 의 deactivate 이벤트에 대한 처리  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */
        function obj_deactivate(){
       	 var formObj = document.form;
       	 obj = event.srcElement;
         
       	 if(obj.name=="str_mvmt_dt"  ){
           			
       		 with(formObj){
    	        			
       			 var creDtFr = ComReplaceStr(str_mvmt_dt.value,"-","");
    	        }
    	        	
    	        if(!ComChkObjValid(event.srcElement)){
    	        	formObj.str_mvmt_dt.value = "";
    	        }
           }
         	if(obj.name=="end_mvmt_dt"  ){
    			
      		 with(formObj){
    	        			
      			 var creDtFr = ComReplaceStr(end_mvmt_dt.value,"-","");
    	        }
    	        	
    	        if(!ComChkObjValid(event.srcElement)){
    	        	formObj.end_mvmt_dt.value = "";
    	        }
          }
           	
        }
         
         /**
          * AXON 이벤트 처리
          */
         function obj_activate(){
             ComClearSeparator(event.srcElement);
         }
        
	/* 개발자 작업  끝 */