/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1019.js
*@FileTitle : Lost Chassis Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.09 최민회
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
     * @class ees_cgm_1019 : ees_cgm_1019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1019() {
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
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

                 case "btn_summary":
                	 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                     break;

                 case "btn_new":
                	 objectClear();
                	 Period_Chk();
                	 sheetObject1.RemoveAll();
                     break; 

                 case "btn_downexcel":
                	 sheetObject1.SpeedDown2Excel(-1);
                     break;
                      
                         
                 case "btn_griddownexcel":
 									ComShowMessage("btn_griddownexcel");
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
		 			if(formObj.eq_aset_sts_cd[0].checked != true ){
		 				var cal = new ComCalendarFromTo();
			            cal.select(formObject.evnt_dt_str,  formObject.evnt_dt_end,  'yyyy-MM-dd');
		 	    		break;
		 			}
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
      * AXON 이벤트 처리
      */
     function obj_activate(){
         ComClearSeparator(event.srcElement);
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
      * Sheet 기본 설정  및 초기화
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
		 axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
		 axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
		 axon_event.addListenerFormat('beforeactivate',	  'obj_activate',   formObj);
//		 axon_event.addListener('change', 'obj_change' , 'sts_evnt_yd_cd'  ,'scc_cd'  ); 
		 
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
//         doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
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
//    	   case "scc_cd":
//	   	 		if(formObj.scc_cd.value != ''){
//	   	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
//	   	 		}
//   	 			break;
//    	 		
//    	  
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
	    	sheetObj.cellValue(0, 1) = "LCC";
    	} else if(formObj.location.text=="LCC") {
	    	sheetObj.cellValue(0, 1) = "SCC";
	    } else if(formObj.location.text=="SCC"){
	    	sheetObj.cellValue(0, 1) = "Yard";
	    } else {
	    	sheetObj.cellValue(0, 1) = "LCC";
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
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false) 
                      
                      
                     var HeadTitle = "|Location|Term|Lessor|Total|SF2|SL2|TA2|SF4|GN4|CB4|GN5|EG5|EG8|ZT4|";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false) 

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                    	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	  InitDataProperty(0, cnt++ , dtHidden,	0,	daCenter,		false,		"agreement");
//                	  InitDataProperty(0, cnt++ , dtData,	0,	daCenter,		false,		"agreement");
                      InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		false,		"sts_evnt_loc_cd",  		false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"agmt_lstm_cd",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData,					210,	daLeft,	    	false,		"vndr_lgl_eng_nm",   	false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    65,		daRight,		false,		"total",    	false,          "",      dfNone,      	0,     false,       false);
  										
                      InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"sf2",   			false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"sl2",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"ta2",   			false,          "",      dfNone,  			0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"sf4",   			false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"gn4",    		false,          "",      dfNone,      	0,     false,       false);
  										
                      InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"cb4",   			false,          "",      dfNone,     		0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"gn5",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"eg5",   			false,          "",      dfNone,   		  0,     false,       false);
  					  InitDataProperty(0, cnt++ , dtAutoSum,			    55,		daRight,		false,		"eg8",    		false,          "",      dfNone,      	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtAutoSum,		       	55,		daRight,		false,		"zt4",   			false,          "",      dfNone,  			0,     false,       false);
                      
                      InitDataProperty(0, cnt++ , dtHidden,		       	    55,		daCenter,		false,		"vndr_seq",   			false,          "",      dfNone,  			0,     false,       false);


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
			 	 formObj.location2.value = comboObjects[0].Code;
			  	 sheetObj.WaitImageVisible=false;
		 	     ComOpenWait(true);
                 sheetObj.DoSearch("EES_CGM_1019GS.do",  queryString+"&"+params);
                 sheetObj.SumText(0,1) = "Grand Total";
	             sheetObj.SumText(0,"agreement")        = "";
//	             for(i=1; i<sheetObj.rowCount+1; i++){
//	            	 sheetObj.CellValue(i, "agreement") = "";
//        		 }
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
 		   			
      	   case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
				   	formObj.f_cmd.value = COMMAND01;
				   	formObj.yd_cd.value = formObj.sts_evnt_yd_cd.value;
				   	if(formObj.yd_cd.value != ""){
				   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
					   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
					   	
					   	if(sCheckResult == COM_VALIDATION_FALSE){
					   		ComShowCodeMessage('CGM10009','Yard');
					   		formObj.sts_evnt_yd_cd.value = "";
					   		formObj.sts_evnt_yd_cd.focus();
					   	}
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


 	/*
 	function sheet1_OnChangeSum(sheetObj, Row )
 	{
 		with(sheetObj)
 		{
 			for (var i = 0; i <= LastCol; i ++)
 			{
 				if (0 == SumText(0, i))
 					SumText(0, i) = "";
 			}
 			SumText(0,"LCC") = "Grand Total";
 			SumText(0,"1") = "Grand Total";
 			RowMerge(Row) = true;
 		}

 	} */
 	
 	
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
  		with(sheetObj)
  		{
  	    	ShowSubSum("sts_evnt_loc_cd", "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "agreement=;sts_evnt_loc_cd=Sub.total");
 		
  			ShowSubSum("agreement", "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "agreement=;agmt_lstm_cd=Total");
  			
 			//ShowSubSum("LCC", "3|4|5|6|7|8|9",-1, false, false, -1,"LCC=Total");
 		//	ShowSubSum("Term", "3|4|5|6|7|8|9",-1, false, false, -1,"LCC=%s;Term=Total");
 		}
 	
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
//      	cmbObj.InsertItem(0,"","");
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
//	       	ComShowMessage(formObj.eq_aset_sts_cd[0].checked);
	       	formObj.eq_aset_sts_cd[0].checked = true;
//     	formObj.eq_spec_no.Code = "";
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
   	   if(Col>3 && Col<=14){
   		   
   			var eqTpszCd = "";
            var colSaveName = sheetObj.ColSaveName(Col);
              	
           	var eqKndCd			= EQ_KND_CD_CHASSIS;
           	var crntYdCd		= document.form.sts_evnt_yd_cd.value;
           	var eqStrDt 		= document.form.evnt_dt_str.value;
           	var eqEndDt		    = document.form.evnt_dt_end.value;
           	var eqAsetStsCd	    = "";
           	var location        = document.form.location2.value;
           	var scc_cd          = document.form.scc_cd.value;
           	var vndr_seq        = sheetObj.CellValue(Row, "vndr_seq");
//           	var sts_evnt_log_cd = "";
           	var sts_evnt_loc_cd = "";
           	var kind            = "";
        //   	alert(location);
              	
				if(colSaveName == 'sf2') 		eqTpszCd = "SF2";
				else if(colSaveName == 'sl2')	eqTpszCd = "SL2";
				else if(colSaveName == 'ta2')	eqTpszCd = "TA2";
				else if(colSaveName == 'sf4')	eqTpszCd = "SF4";
				else if(colSaveName == 'gn4')	eqTpszCd = "GN4";
				else if(colSaveName == 'cb4')	eqTpszCd = "CB4";
				else if(colSaveName == 'eg5')	eqTpszCd = "EG5";
				else if(colSaveName == 'eg8')	eqTpszCd = "EG8";
				else if(colSaveName == 'gn5')	eqTpszCd = "GN5";
				else if(colSaveName == 'zt4')	eqTpszCd = "ZT4";
				else if(colSaveName == 'total')	eqTpszCd = "";
   		    
       	   if(sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "" && sheetObj.CellValue(Row, "agmt_lstm_cd")=="Total"){
       		   sts_evnt_loc_cd = sheetObj.CellValue(Row-1, "sts_evnt_loc_cd");
       		   vndr_seq        = "";
       	   } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "Sub.total" && sheetObj.CellValue(Row, "agmt_lstm_cd") == ""){
       		   sts_evnt_loc_cd = sheetObj.CellValue(Row-2, "sts_evnt_loc_cd");
       		   vndr_seq        = "";
       	   } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "Grand Total"  ){
    		   sts_evnt_loc_cd = "";
    		   vndr_seq        = "";
       	   } else {
       		   sts_evnt_loc_cd = sheetObj.CellValue(Row, "sts_evnt_loc_cd");
       		   vndr_seq        = sheetObj.CellValue(Row, "vndr_seq");
       	   }
       	   
       	   if(formObj.eq_aset_sts_cd[0].checked == true){
       		   eqAsetStsCd = ""
       	   } else if (formObj.eq_aset_sts_cd[1].checked == true){
       		   eqAsetStsCd = "LST"
       	   } else if (formObj.eq_aset_sts_cd[2].checked == true){
       		   eqAsetStsCd = "FND"
       	   } 
       	   
       	    if(sheetObj.CellValue(Row, "agmt_lstm_cd")==""){
       	    	agmtLstmCd	    = "";
       	    } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "" && sheetObj.CellValue(Row, "agmt_lstm_cd") == "Total"){
       	    	agmtLstmCd = sheetObj.CellValue(Row-1, "agmt_lstm_cd");
       	    } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "Total" && sheetObj.CellValue(Row, "agmt_lstm_cd") == ""){
    	    	agmtLstmCd = sheetObj.CellValue(Row-2, "agmt_lstm_cd");
       	    } else {
       	    	agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
       	    }
       	    
     	   if(document.form.location.Code=="S")
	   	   {
    		   crntYdCd = sts_evnt_loc_cd;
    		   sts_evnt_loc_cd = "";
	   	   } 
    	         
       	                                                       
//alert(sts_evnt_loc_cd);
       	    //kind 	= document.form.kind.value;

	           	var param = "?pgmNo=EES_CGM_1091&program_id=1019";
	           	param = param + "&f_cmd=" + SEARCH01; 
	        	param = param + "&eq_tpsz_cd=" + eqTpszCd;           	
	           	param = param + "&eq_knd_cd=" + eqKndCd;
	           	param = param + "&crnt_yd_cd=" + crntYdCd;
	           	param = param + "&sts_evnt_dt_fr=" + eqStrDt;
	           	param = param + "&sts_evnt_dt_to=" + eqEndDt;
	           	param = param + "&eq_aset_sts_cd=" + eqAsetStsCd;
	           	param = param + "&location=" + location;
	           	param = param + "&scc_cd=" + scc_cd;
	           	param = param + "&agmt_lstm_cd=" + agmtLstmCd;
	           	param = param + "&sts_evnt_loc_cd="+sts_evnt_loc_cd;
	        	param = param + "&vndr_seq="+vndr_seq;
	        	param = param + "&kind="+kind;
          	    ComOpenPopup('/hanjin/EES_CGM_1091.do' + param, 900, 600, "", "1,0", true, false);
          	
   	   }
   	   
   	   
   	   
      }

	/* 개발자 작업  끝 */