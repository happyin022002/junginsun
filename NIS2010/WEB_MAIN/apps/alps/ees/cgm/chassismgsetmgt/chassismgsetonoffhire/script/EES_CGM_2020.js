/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_2020.js
*@FileTitle : Lost M.G.Set Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.10 최민회
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
     * @class ees_cgm_2020 : ees_cgm_2020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_2020() {
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
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

                 case "btn_retrieve":
                	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					 break;


                 case "btn_new":
                	 objectClear();
                	 sheetObject.RemoveAll();
                     break; 

                 case "btn_downexcel":
                	 sheetObject.SpeedDown2Excel(-1);
                     break;
                      
                 case "ComOpenPopupWithScc_cd":
                 	var tmp = formObject.location.text;
                 	if(tmp == "RCC")
                 	{
                 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}else if(tmp == "LCC")
                 	{
                 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}else if(tmp == "SCC")
                 	{
                 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}
           			
           			break;
                 case "ComOpenPopupWithTargetYard":
           			ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
           			break;
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal = new ComCalendar();
	 				cal.select(formObject.evnt_dt_str, "yyyy-MM-dd");
	 				break;
	 					
	 			 case "btns_Calendar2" :		// Agreement Date (To Date)
//	 				var cal = new ComCalendar();
//	 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
	 			    var cal = new ComCalendarFromTo();
		            cal.select(formObject.evnt_dt_str,  formObject.evnt_dt_end,  'yyyy-MM-dd');
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
      * Sheet 기본 설정 
 및 초기화
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


             comboObjects[comboCnt++] = document.location;
             for(var k=0;k<comboObjects.length;k++){
       	         initCombo(comboObjects[k]);
      	     }  
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
         // axon event 등록
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
         axon_event.addListenerFormat('beforeactivate',	  'obj_activate',		formObj);
//         axon_event.addListener('change', 'obj_change' , 'sts_evnt_yd_cd'  ,'scc_cd'  ); 
         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
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
//      // Lease Term Combo Control에  초기값을  설정한다.
        // doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//         doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
//         
     	 doActionIBSheet(sheetObj, formObj, IBRESET);
         formObj.location.text ='RCC';
         Period_Chk();
         // 초기 focus
         formObj.scc_cd.focus();
       
     }
      
      function Period_Chk(){
    	  formObj = document.form;
	   	  var l_chk ,f_chk;
	   	  var l_cName,f_cName;
	   	  if(formObj.eq_aset_sts_cd[0].checked == true  ){
	   		  l_chk = true;
	   		  f_chk = false;
	   		  l_cName = "input2";
	   	  } else {
	      	  l_chk = false;
	      	  f_chk = true;
	   		  l_cName = "input1";
	   	  }
		  formObj.evnt_dt_str.readOnly = l_chk;
	      formObj.evnt_dt_end.readOnly = l_chk;
	      
	      formObj.evnt_dt_str.className = l_cName;
	      formObj.evnt_dt_end.className = l_cName;
	      
	      ComEnableObject(formObj.btns_Calendar2, f_chk);
     }
      /**
       * AXON 이벤트 처리
       */
      function obj_activate(){
          ComClearSeparator(event.srcElement);
      }
      
          /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */  
//    function obj_change(){
//    	 var formObj = document.form;
//    	 var sheetObj = sheetObjects[0]; 
//    	 obj = event.srcElement;
//    	 switch(obj.name){
//    	   case "sts_evnt_yd_cd":
//    	 		if(formObj.sts_evnt_yd_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
//    	 		} 
//    	 		break;
//    	 		
//    	   case "scc_cd":
//	   	 		if(formObj.scc_cd.value != ''){
//	   	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
//	   	 		}
//   	 			break;
//    	 }   
//    }
     
       /**
      * YA_CD 값 체크
      * @return
      */
     function obj_keyup(){
		 var formObj = document.form;
		 var sheetObj = sheetObjects[0];
		 obj = event.srcElement;
		 switch(obj.name){
		 	case "sts_evnt_yd_cd":
	    	    var sts_evnt_yd_cd;
		    	frmObj = document.form;
		    	//alert("sss");
		    	sts_evnt_yd_cd = frmObj.sts_evnt_yd_cd.value;
		    	if (sts_evnt_yd_cd.length == 7) {
		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
		    	}
		    	break;

     	 	case "scc_cd":
    	 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
    	   		var arrCrntLocCd = crntLocCd.split(",");
    	   		
    	   		for(var i = 0; i < arrCrntLocCd.length; i++){
    	   		// 입력오류 체크 (예> ,,)
    	 			if(arrCrntLocCd[i] == ''){
    	 				ComShowCodeMessage('CGM10009','Location');
    	 				formObj.scc_cd.value = "";
    	 				ComSetFocus(formObj.scc_cd);
    	 				break;
    	 			}else{
    	    	 		//if(formObj.scc_cd.value != ''){
    	    	 		if(formObj.scc_cd.value.length == 5){
    	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
    	    	 		}
    	    	 	}
    	 		}
    	 		break;		    	
		 }
	}     
     /** 
      * Object 의 change 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */  
     function location_OnChange(){
     	var formObj = document.form;
     	var sheetObj = sheetObjects[0]; 
     	if(formObj.location.text=="RCC") {
 	    	sheetObj.cellValue(0, 0) = "LCC";
     	} else if(formObj.location.text=="LCC") {
 	    	sheetObj.cellValue(0, 0) = "SCC";
 	    } else if(formObj.location.text=="SCC"){
 	    	sheetObj.cellValue(0, 0) = "Yard";
 	    } else {
 	    	sheetObj.cellValue(0, 0) = "LCC";
 	    }
     	sheetObj.RemoveAll();
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
       
     	 if(obj.name=="evnt_dt_str"  ){
         			
     		 with(formObj){
  	        			
     			 var creDtFr = ComReplaceStr(evnt_dt_str.value,"-","");
  	        }
  	        	
  	        ComChkObjValid(event.srcElement);
         }
       	if(obj.name=="evnt_dt_end"  ){
  			
    		 with(formObj){
  	        			
    			 var creDtFr = ComReplaceStr(evnt_dt_end.value,"-","");
  	        }
  	        	
  	        ComChkObjValid(event.srcElement);
        }
         	
      }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 290;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

					 var HeadTitle = "Lessor|Term|Total|UMG|CLG";
					 var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,     "sts_evnt_loc_cd",    false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,     "agmt_lstm_cd",    	false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtAutoSum,       230,    daRight,  	true,     "total",              false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtAutoSum,       230,    daRight,   true,     "umg",               	false,          "",      dfNone);
                     InitDataProperty(0, cnt++ , dtAutoSum,       200,    daRight,   true,     "clg",     	        false,          "",      dfNone);
                     MessageText("Sum") = "Grand Total";



                }
                 break;

  

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
                 if(!validateForm(sheetObj,formObj,sAction)) return;
                 var params = FormQueryString(formObj);
 			 	 formObj.f_cmd.value = SEARCH;
 			 	 queryString = "f_cmd=" + SEARCH ;
		  		 sheetObj.WaitImageVisible=false;
		 	     ComOpenWait(true);
                 sheetObj.DoSearch("EES_CGM_2020GS.do",  queryString+"&"+params);
                 ComOpenWait(false);
                 break;

 			case IBSEARCH_ASYNC01:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
		  			MakeComboObject(formObj.location, arrStr, 0, 0);
		       	break;
 	        case IBSEARCH_ASYNC02:	// ( location)조회
 		       	formObj.f_cmd.value = SEARCH;
 		       	formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
 		   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
 		   			    			
 		   	// 데이터 건수
 		        var dataCount = ComGetTotalRows(sXml);
 		        if(dataCount==0){
 		        	ComShowCodeMessage('CGM10009','location cd');
 			   		formObj.scc_cd.value = "";
 			   		formObj.scc_cd.focus();
 		        }
 		   			
 		  		 
 		       	break;
		   case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
			   	formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value = formObj.sts_evnt_yd_cd.value;
			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.sts_evnt_yd_cd.value = "";
			   		formObj.sts_evnt_yd_cd.focus();
			   	}
			   	break;
			   	
 	    case IBSEARCH_ASYNC08:
 	    	formObj.f_cmd.value = SEARCH17;
 	    	var location = formObj.location.text;
 	    	
 	    	if(location == "RCC")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "RCC";
 	    		formObj.eq_orz_cht_rcc_cd.value = formObj.scc_cd.value;
 	    	}else if(location == "LCC")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "LCC";
 	    		formObj.eq_orz_cht_lcc_cd.value = formObj.scc_cd.value;
 	    	}else if(location == "SCC")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "SCC";
 	    		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
 	    	}else
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "";
 	    		formObj.eq_orz_cht_scc_cd.value = "";
 	    	}
 	 		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
 	   		// 데이터 건수
 	        var dataCount = ComGetTotalRows(sXml);
 	        if(dataCount==0){
 	        	ComShowCodeMessage('CGM10009','location cd');
 		   		formObj.scc_cd.value = "";
 		   		formObj.scc_cd.focus();
 	        }
 	  	    break;	
 	   case IBRESET:
	 		var idx = 0
	 		var sXml2 = document.form2.sXml.value;
	 		var arrXml = sXml2.split("|$$|");
	
	 		
	 		
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject(formObj.location, arrStr1, 0, 0);
	 		idx++;       
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
					if(formObj.eq_aset_sts_cd[0].checked != true ){
				 		if(evnt_dt_str.value == ''){
								ComShowCodeMessage('CGM10004','Period ');
								evnt_dt_str.focus();
								
								return false;
							}	
				 		if(evnt_dt_end.value == ''){
								ComShowCodeMessage('CGM10004','Period ');
								evnt_dt_end.focus();
								
								return false;
							}
				 		 var dt_str = ComReplaceStr(document.form.evnt_dt_str.value,"-","");
						 var dt_end = ComReplaceStr(document.form.evnt_dt_end.value,"-","");
			    	
			
						if(dt_str != '' && dt_end != ''){
							if(dt_end < dt_str){
								ComShowCodeMessage('COM12133','To date','From date','greater');
								evnt_dt_str.value='';
								
								evnt_dt_str.focus();
								return false;
							}
						}
					}
					if(scc_cd.value!='' && scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
           				scc_cd.focus();
           				
           				return false;
           			}
					if(sts_evnt_yd_cd.value!='' && sts_evnt_yd_cd.value.length !=7){
    		 			ComShowCodeMessage('CGM10044','Yard (7)');
    		 			sts_evnt_yd_cd.focus();
           				
           				return false;
           			}
			 }    
         }

         return true;
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
    	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
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
        	if(obj.name=="evnt_dt_str"  ){
     			
        		document.form.evnt_dt_str.value = ComReplaceStr(document.form.evnt_dt_str.value,"-","");
            }
          if(obj.name=="evnt_dt_end"  ){
     			
          		document.form.evnt_dt_end.value = ComReplaceStr(document.form.evnt_dt_end.value,"-","");
           }
      	
         //ComShowMessage("domFunFocusDel");
      }
      

      /** 
       * Combo Object 초기화  <br>
       * @param  {object} comboObj	필수 Combo Object
       * @return 없음
       * @author 최민회
       * @version 2009.05.25
       */ 
      function initCombo(comboObj) {
       	switch(comboObj.id) {
    	       case "agmt_lstm_cd":
    	           var cnt=0;
    	           with(comboObj) {
    	            	Code = "";
    	            	Text = "";
    	            	DropHeight = 100;
    	            	MultiSelect = false;
    	            	MaxSelect = 1;	    
    	            	UseCode = true;
    	            	Enable = true;
    	            }
    	            break;
    	    }
    	} 
       
      /** 
       * Combo Object 에 값을 추가하는 처리 <br>
       * @param  {object} cmbObj	필수 Combo Object
       * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
       * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
       * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
       * @return 없음
       * @author 최민회
       * @version 2009.05.20
       */ 
      function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
      	 cmbObj.RemoveAll();
//        	cmbObj.InsertItem(0,"","");
        	for (var i = 0; i < arrStr.length;i++ ) {
        		var arrCode = arrStr[i].split("|");
        		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
             	}
        	cmbObj.Index2 = "" ;
      }
       
       /**
        * 기본 오브젝트 초기화 
        */
       function objectClear(){
  	       	var formObj = document.form;
  	       	var sheetObject  = sheetObjects[0];
  	       	//IBMultiCombo 초기화
  	//       	
  	       	formObj.location.Code = "";
  	       	formObj.location.text = "";
  	       	formObj.evnt_dt_str.value = "";
  	       	formObj.evnt_dt_end.value = "";
  	       	formObj.scc_cd.value = "";
  	       	formObj.sts_evnt_yd_cd.value = "";
//  	       	ComShowMessage(formObj.eq_aset_sts_cd[0].checked);
  	       	formObj.eq_aset_sts_cd[0].checked = true;
//       	formObj.eq_spec_no.Code = "";
       }
      
     	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     	{
      		with(sheetObj)
      		{
      	    	ShowSubSum("sts_evnt_loc_cd", "2|3|4",-1, true, false, 0, "sts_evnt_loc_cd=;agmt_lstm_cd=Sub Total");
     		
      			 
     		}
     	
     	}
     	 /**
         * Sheet1 의 OnMouseDown 이벤트처리 <br>
         * @param  {Integer} Button	필수 Integer
         * @param  {integer} Shift	필수 Integer
         * @param  {Integer} X	필수 Integer
         * @param  {integer} Y	필수 Integer
         * @return 없음
         * @author 조재성
         * @version 2009.09.16
         */ 
         function sheet1_OnMouseDown (Button, Shift, X, Y){
        	 var sheetObj = sheetObjects[0];
        	 var formObj = document.form;
        	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
        	 {
        		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
        		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
        		 //alert(groupValue1);
        		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
        	 }
        	 
         }
      
        function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
     	   if(Col>1 && Col<=5){
//     			var eqTpszCd = "";
                var colSaveName = sheetObj.ColSaveName(Col);
//                	
             	var crntYdCd		= document.form.sts_evnt_yd_cd.value;
             	var eqStrDt 		= document.form.evnt_dt_str.value;
             	var eqEndDt		    = document.form.evnt_dt_end.value;
             	var scc_cd          = document.form.scc_cd.value;
             	var eq_tpsz_cd      = "";
             	var agmt_lstm_cd    = "";
             	var sts_evnt_loc_cd = "";
                	
  				if(colSaveName == 'umg') 		eq_tpsz_cd = "UMG";
  				else if(colSaveName == 'clg')	eq_tpsz_cd = "CLG";
  				else if(colSaveName == 'total')	eq_tpsz_cd = "";
     		    
         	   if(sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "" && sheetObj.CellValue(Row, "agmt_lstm_cd")=="Sub Total"){
         		  sts_evnt_loc_cd = sheetObj.CellValue(Row-1, "sts_evnt_loc_cd");
         		  agmt_lstm_cd = sheetObj.CellValue(Row-1, "agmt_lstm_cd");
         	   } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "Grand Total"  ){
         		  sts_evnt_loc_cd = "";
         		  agmt_lstm_cd ="";
         	   } else {
         		  sts_evnt_loc_cd   = sheetObj.CellValue(Row, "sts_evnt_loc_cd");
         		  agmt_lstm_cd = sheetObj.CellValue(Row, "agmt_lstm_cd");
         	   }
//         	   
         	   if(formObj.eq_aset_sts_cd[0].checked == true){
         		   eqAsetStsCd = ""
         	   } else if (formObj.eq_aset_sts_cd[1].checked == true){
         		   eqAsetStsCd = "LST"
         	   } else if (formObj.eq_aset_sts_cd[2].checked == true){
         		   eqAsetStsCd = "FND"
         	   } 
 

  	           	var param = "?pgmNo=EES_CGM_2084&program_id=2020";
  	           	param = param + "&s_crnt_yd_cd=" + crntYdCd;
  	           	param = param + "&sts_evnt_dt_fr=" + eqStrDt;
  	           	param = param + "&sts_evnt_dt_to=" + eqEndDt;
  	           	param = param + "&s_eq_tpsz_cd=" + eqAsetStsCd;
  	            param = param + "&s_location=" + document.form.location.Code;
  	            param = param + "&s_crnt_loc_cd=" + sts_evnt_loc_cd;
  	            param = param + "&eq_tpsz_cd=" + eq_tpsz_cd;
  	            param = param + "&s2_agmt_lstm_cd=" + agmt_lstm_cd;
  	           	param = param + "&location=" + location;
  	           	param = param + "&scc_cd=" + scc_cd;
  	        	ComOpenPopup('/hanjin/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
            	
     	   }
        }
	/* 개발자 작업  끝 */