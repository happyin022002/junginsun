/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0018.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.24 장창수
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
     * @class fns_tot_0018 : fns_tot_018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0018() {
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
	var closing_yn = "N";
	
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
				 		setCloseYn();
				 		checkMonth();

						  if(sheetObjects[0].RowCount >0){
							  if(formObj.status.value == "Completed"){
								  ComBtnEnable("btn_ERPIF");
							  }else{
								  ComBtnDisable("btn_ERPIF");
							  }
					      }else{
					      	ComBtnDisable("btn_ERPIF");
					      }
				 		formObject.status.value = "";
   				 	    formObject.vsl_cnt.value = "";
   				        formObject.vsl_total.value = "";
   				 		sheetObject1.RemoveAll();
                     break;
                     
                 case "btn_YearClose":
                	 if(formObj.strUsr_id.value == "0510142" && closing_yn =="N"){
                		 doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                	 }
                	 
                     break;
                     
                 case "btn_Status":
                	 openPopup();
                     break;
                     
                 case "btn_ERPIF":
                	 if(closing_yn =="N"){
                		 doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
                	 }
                     break;
 				 case "btns_back":

	                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
	                	 ComShowCodeMessage('TOT00003');
	                	 return;
	                 }
	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M",-1).substring(0,7);
	                 formObject.vsl_cnt.value = "";
				     formObject.vsl_total.value = "";
				     formObject.status.value = "";
	                 setCloseYn();
	                 checkMonth();
					break;

				 case "btns_next":
					
	                 if(formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == ""){
	                	 ComShowCodeMessage('TOT00003');
	                	 return;
	                 }
	                 formObject.stl_yrmon.value = ComGetDateAdd(formObject.stl_yrmon.value+"-01","M", 1).substring(0,7);
	                 formObject.vsl_cnt.value = "";
				     formObject.vsl_total.value = "";
				     formObject.status.value = "";
	                 setCloseYn();
	                 checkMonth();
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
    function loadPage(stlClzFlg) {

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         initControl();
         var formObj = document.form;
       
         closing_yn = stlClzFlg;
         
         ComBtnDisable("btn_ERPIF");
    	 checkMonth();

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
                     style.height = 400;
                     
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

                     var HeadTitle1 = "|Vessel|NRT|USE (%)|Day|Taxable Amount|OPER|Charter Year|Remark|";
                     var headCount = ComCountHeadTitle(HeadTitle1);					

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     var prefix = "sheet1_";
                     
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,	0,		daCenter,	true,		"Status");
                     InitDataProperty(0, cnt++, dtData,					60,		daCenter,	true,		prefix+"vsl_cd",				false,		"",       dfNone,	0,	false,	false);
                     InitDataProperty(0, cnt++, dtData,					65,		daRight,	false,	prefix+"nrt_wgt",					false,		"",       dfNullInteger,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtData,					70,		daRight,	false,	prefix+"use",					false,		"",       dfNullFloat,		2,	false,	false);
					 InitDataProperty(0, cnt++, dtData,					55,		daRight,	false,	prefix+"voy_dys",					false,		"",       dfNullInteger,	0,	false,	false);
					
					 InitDataProperty(0, cnt++, dtData,					120,	daRight,	false,	prefix+"tong_tax_amt",		false,		"",       dfNullInteger,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtData,					80,	    daCenter,		true,		prefix+"tong_flet_tp_cd",					false,		"",       dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtData,					80,	daRight,	true,		prefix+"ctrt_dys",	false,		"",       dfNullFloat,		2,	false,	false);
					 InitDataProperty(0, cnt++, dtData,					600,	daLeft,		true,		prefix+"vvd_rmk",				false,		"",       dfNone,	0,	false,	false);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"stl_yrmon",		false,		"",       dfNone,	0,	false,	false);


 										
 					
                 }
                 break;
             case 2:      // t1sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 0;
                 
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

                 var HeadTitle1 = "|Vessel|NRT|USE (%)|Day|Taxable Amount|OPER|Charter Year|Remark|";
                 var headCount = ComCountHeadTitle(HeadTitle1);					

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 var prefix = "sheet2_";
                 
                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus,	0,		daCenter,	true,		"Status");
                 InitDataProperty(0, cnt++, dtData,					0,		daCenter,	true,		prefix+"vsl_cd",				false,		"",       dfNone,	0,	false,	false);
                 InitDataProperty(0, cnt++, dtData,					0,		daRight,	false,	prefix+"nrt_wgt",					false,		"",       dfNullInteger,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtData,					0,		daRight,	false,	prefix+"use",					false,		"",       dfNullFloat,		2,	false,	false);
				 InitDataProperty(0, cnt++, dtData,					0,		daRight,	false,	prefix+"voy_dys",					false,		"",       dfNullInteger,	0,	false,	false);
				
				 InitDataProperty(0, cnt++, dtData,					0,	daRight,	false,	prefix+"tong_tax_amt",		false,		"",       dfNullInteger,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtData,					0,	daLeft,		true,		prefix+"tong_flet_tp_cd",					false,		"",       dfNone,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtData,					0,	daCenter,	true,		prefix+"ctrt_dys",	false,		"",       dfNullFloat,		1,	false,	false);
				 InitDataProperty(0, cnt++, dtData,					0,	daLeft,		true,		prefix+"vvd_rmk",				false,		"",       dfNone,	0,	false,	false);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"stl_yrmon",		false,		"",       dfNone,	0,	false,	false);


										
					
             }
             break; 
         }
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
    	axon_event.addListener  ('blur'  , 'stl_yrmon_onblur', 'stl_yrmon');//- customer code 입력 후 name 가져오기
        axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    

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
	 
    function setDate(){
  		var today=new Date();
  		var y = today.getFullYear().toString();
  		var m = today.getMonth();
  			
  		if(m<10){
  			m = "0"+m;
  		}
  		
  		document.form.stl_yrmon.value = y+"-"+m;    	
  	}
      
    //stl_yr 변경시 조회 
    function stl_yrmon_onblur(){
      	//alert("stl_yrmon_onblur");
      	var formObject = document.form;

     		if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
     			
     			 ComShowCodeMessage('TOT00003');
     			ComSetFocus(formObject.stl_yrmon);
     			
     			return false;
     		}

          setCloseYn();
          checkMonth();
          
		  if(sheetObjects[0].RowCount >0){
			ComBtnEnable("btn_ERPIF");
          }else{
        	ComBtnDisable("btn_ERPIF");
          }

    }

    /** 
      * Summary Preview 버튼 클릭시 팝업호출
      */
    function openPopup() {

      	var formObject = document.form;

     	var stl_yrmon = formObject.stl_yrmon.value;
     	stl_yrmon = stl_yrmon.substring(0,4)+stl_yrmon.substring(5,7);

      	var param = "?stl_yrmon="+stl_yrmon;

       	ComOpenPopup('/hanjin/FNS_TOT_0019.do'+param, 500, 350, 'getVVD', '1,0,1,1,1,1,1,1');

    }
      
    /*
     * 조건녀의 월이 12월인지 여부를  조회하여 Year Close버튼을 활성또는 비활성 한다.
     */
    function checkMonth(){
     	
     	var formObj = document.form;

     	var stlYm = formObj.stl_yrmon.value;
        var december_yn = "N"
        	
     	if(formObj.strUsr_id.value == "0510142" && stlYm.substr(5,6) == "12" && closing_yn == "N"){
    		 ComBtnEnable("btn_YearClose");
      		
      	}else{
      		ComBtnDisable("btn_YearClose");
      		
      	}

 		
    }        

    /*
     * 조건 년도가 마감 되었는지 여부를  조회하여 저장버튼을 활성또는 비활성 한다.
     */
    function setCloseYn(){
     	
     	var formObj = document.form;

     	var stlYr = formObj.stl_yrmon.value;

     	formObj.f_cmd.value = SEARCHLIST02;
     	formObj.stl_yr.value = stlYr.substr(0,4);
 		var sXml = sheetObjects[1].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj));

 		closing_yn = ComGetEtcData(sXml,"stlClzFlg");
 		     
 		     ComBtnDisable("btn_ERPIF");
	    	 if(closing_yn == "Y"){
	    		 
	      		ComBtnDisable("btn_YearClose");
	      		
	      	 }else{
	      		
	      		 if(formObj.strUsr_id.value == "0510142"){
	      			 ComBtnEnable("btn_YearClose");
	      		 }else{
	      			 ComBtnDisable("btn_YearClose");
	      		 }
	      		//ComBtnEnable("btn_ERPIF");
	      	 }

    	 formObj.vsl_cnt.value = "";
    	 formObj.vsl_total.value = "";
    	 formObj.status.value = ""; 		
	     
 		 sheetObjects[0].RemoveAll(); 
 		
    }   
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
             case IBSEARCH:      //조회
            
		             if (validateForm(sheetObj, formObj, sAction)){
		            	//alert("search :: ");
		                 if ( sheetObj.id == "sheet1"){
		     				formObj.f_cmd.value = SEARCH;
		     				 	//prefix 문자열 배열
		     				var prefix = "sheet1_";
			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0018GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
			    			sheetObjects[0].LoadSearchXml(sXml);
			    			formObj.vsl_cnt.value = ComGetEtcData(sXml,"total_cnt"); 
			    			formObj.vsl_total.value = ComRound(ComGetEtcData(sXml,"total_txAmt"),3);   
			    			ComChkObjValid(formObj.vsl_cnt);
			    			ComChkObjValid(formObj.vsl_total);
			    			formObj.status.value = ComGetEtcData(sXml,"status");
			    			formObj.feeder_yn.value = ComGetEtcData(sXml,"feederYn");
                            
			    			if(sheetObjects[0].RowCount >0){
			    				if(formObj.status.value == "Completed"){
			    					 ComBtnEnable("btn_ERPIF");
			    				}else{
			    					ComBtnDisable("btn_ERPIF");
			    				}
		                    }else{
		                    	ComBtnDisable("btn_ERPIF");
		                    }
		                 }
		                 
		             }
                 break;

              case IBSEARCH_ASYNC01:        //마감처리
			            if(closing_yn == "N"){
			            	if (validateForm(sheetObj, formObj, sAction)){
				     			var SaveStr = ComGetSaveString(sheetObjects);
				    			
				    			if (!ComShowCodeConfirm('TOT00060')){
				    				return;
				    			}

			                	sheetObj.WaitImageVisible=false;
			                	ComOpenWait(true);
			                	
				    			var stlYr = formObj.stl_yrmon.value;
				    	     	formObj.stl_yr.value = stlYr.substr(0,4);
				    	     	
				    	     	formObj.f_cmd.value = MULTI01;
				    	     	
				    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
				    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0018GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				    			sheetObj.LoadSaveXml(sXml);
				    			ComOpenWait(false);
				    			setCloseYn();
			            	}
			            }	

                 break;

              case IBSEARCH_ASYNC02:        //ERP I/F
	            if(closing_yn == "N"){
	            	if (validateForm(sheetObj, formObj, sAction)){

		    			if (!ComShowCodeConfirm('TOT00071')){
		    				return;
		    			}
		    			
		    			var stlYr = formObj.stl_yrmon.value;
		    	     	formObj.stl_yr.value = stlYr.substr(0,4);
		    	     	formObj.f_cmd.value = MULTI02;
		    	     	
		    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
		    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0018GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		    			//sheetObj.LoadSaveXml(sXml);
		    			var backendJobKey = ComGetEtcData(sXml,"KEY"); 
		    			//alert("backendJobKey :: "+backendJobKey);
		    			
						if (backendJobKey.length > 0) {
							formObj.back_end_job_key.value = backendJobKey;
							sheetObj.WaitImageVisible = false;
							
							ComOpenWait(true);			
							getBackEndJobStatus();
							sheetObj.RequestTimeOut = 10000;
							timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}		
						
	            	}
	            }	

              break;

         }
    }

    /**
      * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
      */
    function getBackEndJobStatus() {
     	// sheet1
     	var formObj = document.form;
     	 var sheetObject1 = sheetObjects[1];
     	formObj.f_cmd.value = SEARCH02;
     	var sXml = sheetObject1.GetSearchXml("TOTCommonGS.do", FormQueryString(formObj),-1,false);
     	sheetObject1.LoadSearchXml(sXml);
     	var arrXml = sXml.split("|$$|");
     	var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
     	//alert(":::>> jobState : "+jobState);

     	if(jobState == "3") {
         	//alert("jobState 3인 경우: "+jobState);
         	//doActionIBSheet(sheetObject1, formObj, IBSEARCH);
         	ComOpenWait(false);
         	clearInterval(timer);    	
         } else if(jobState == "0") {
         	//ComShowCodeMessage('GEM00001',"BackEndJob관련");
         	//alert("jobState 0인 경우: "+jobState);
         	clearInterval(timer);
         	ComOpenWait(false);
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
					if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
						ComShowCodeMessage('TOT00003');
						ComSetFocus(formObject.stl_yrmon);
						return false;
					}

				break;
				
			   case IBSEARCH_ASYNC01: //마감처리
				if (formObject.stl_yrmon.value ==null || formObject.stl_yrmon.value ==""){
					ComShowCodeMessage('TOT00003');
					ComSetFocus(formObject.stl_yrmon);
					return false;
				}
			   
			   case IBSEARCH_ASYNC02: //ERP_IF
				if (formObject.feeder_yn.value =="N"){
					ComShowCodeMessage('TOT00073');
					return false;
				}
			    break;
				
    		    default:
    		    break;
    		}
    		return true;

    }

