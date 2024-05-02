/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_2012.js
*@FileTitle : On & Off-Hire Status Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.02 최민회
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
     * @class ees_cgm_2012 : ees_cgm_2012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_2012() {
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
var comboObjects2 = new Array();

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 var IBSEARCH02 = 30;
 var IBSEARCH03 = 31;
 
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject1 = sheetObjects[0];
     var sheetObject2 = sheetObjects[1];

     /*******************************************************/
     var formObject = document.form;
     var agmt_lstm_cd  = document.agmt_lstm_cd.Text;
     

	try {
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

            case "btn_new":
            	 objectClear();
            	 if(formObject.str_gubun[0].checked){
            		 sheetObject1.RemoveAll();
            	 }
            	 else if (formObject.str_gubun[1].checked)
            	 {
            		 sheetObject2.RemoveAll();
            	 }
            	 
                break; 

            case "btn_retrieve":
//						
//           	 ComShowMessage(formObject.str_gubun[0].checked);
//           	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
           	 if(formObject.str_gubun[0].checked){
           		 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
           	 }
           	 else if (formObject.str_gubun[1].checked)
           	 {
           		 doActionIBSheet(sheetObject2, formObject, IBSEARCH);
           	 }
           		 
//           	 
                break;
                 
            case "btn_downexcel":
           	 if(formObject.str_gubun[0].checked){
           		 sheetObject1.SpeedDown2Excel();
           	 }
           	 else if (formObject.str_gubun[1].checked)
           	 {
           		 sheetObject2.SpeedDown2Excel();
           	 }
           	  
                break;                   

            case "btn_print":
	           	 if(formObject.str_gubun[0].checked){
						if( sheetObjects[0].rowcount==0 ) {
							errMsg = 'No data found.';
							ComShowMessage(msgs["CGM10012"]);
							return;
						}
						formObject.f_cmd.value = IBSEARCH02;
						ComOpenPopupWithTarget('/hanjin/EES_CGM_2202.do?pgmNo=EES_CGM_2202', 775, 800, "", "0,1,1,1,1,1,1", true);
	         	 }
	         	 else if (formObject.str_gubun[1].checked)
	         	 {
						if( sheetObjects[1].rowcount==0 ) {
							errMsg = 'No data found.';
							ComShowMessage(msgs["CGM10012"]);
							return;
						}
						formObject.f_cmd.value = IBSEARCH03;
						ComOpenPopupWithTarget('/hanjin/EES_CGM_2203.do?pgmNo=EES_CGM_2203', 775, 800, "", "0,1,1,1,1,1,1", true);
	         	 }
                break;
            case "ComOpenPopupWithTargetYard":
            	//chungpa 20100415 new yard popup start
     			//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
     			ComOpenPopup("/hanjin/EES_LSE_0101.do", 800, 450, "setPopData_AvailYard", '1,0', true, false);//, Row, Col, 0);
     			//chungpa 20100415 new yard popup end     			
     			break;
     			
            case "ComOpenPopupWithTarget2":
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
            case "ComOpenPopupWithTargetKind":
       			if(formObject.kind.value=="L"){
       				ComOpenPopup('/hanjin/COM_ENS_0C1.do?pgmNo=COM_ENS_0C1', 700, 455, "setProgramNo", "0,1,1,1,1,1", true, false);
//       				ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 1000, 600, "vndr_seq:kind_txt", "1,0,1,1,1,1,1", true);
       			}
       			else
       			{
       				ComOpenPopup('/hanjin/EES_CGM_2022.do?pgmNo=EES_CGM_2022', 820, 435, "setProgramNo", "0,1,1,1,1,1", true, false);
       			}
      			break;
            case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal = new ComCalendar();
				cal.select(formObject.evnt_dt_str, "yyyy-MM-dd");
				break;
					
			case "btns_Calendar2" :		// Agreement Date (To Date)
//				var cal = new ComCalendar();
				var cal = new ComCalendarFromTo();
//	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
	    		cal.select(formObject.evnt_dt_str,  formObject.evnt_dt_end,  'yyyy-MM-dd');
// 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
  * New Yard Code Pop-up Return Value 처리 부분<br>
  * chungpa 20100415 new yard popup
  */
 function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
 	var formObj = document.form;
 	if(aryPopupData.length > 0) {
 		formObj.sts_evnt_yd_cd.value = aryPopupData[0][4]; //Yard
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
           
        // IBMultiCombo 초기화
        	comboObjects[comboCnt++] = document.agmt_lstm_cd;
        	for(var k=0;k<comboObjects.length;k++){
    	        initCombo(comboObjects[k]);
   	        }  
          
//        	comboObjects2[comboCnt2++] = document.location;
        	for(var k=0;k<comboObjects2.length;k++){
//    	        initCombo(comboObjects2[k]);
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
//         axon_event.addListener('change', 'obj_change' , 'scc_cd','sts_evnt_yd_cd','eq_aset_sts_cd','kind'   ); 
         axon_event.addListener('change', 'obj_change' , 'eq_aset_sts_cd','kind'   ); 
         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
         axon_event.addListener('focusout', 'obj_focusout','sts_evnt_yd_cd');
         initControl(sheetObjects[0]);   
         
		 sheetObj.WaitImageVisible = true; 
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
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
//                     ComShowMessage(document.form.kind.value);
                     var tmp
                     if(document.form.kind.value == "L"){
                    	 tmp = "Lessor";
                     }else{
                    	 tmp = " AGMT No. ";
                     }
                    	 
                     var HeadTitle = "|Location|Term|"+tmp+"|Total|UMG|CLG";
 					 var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHidden ,   0, daCenter, false, "agreement"       );                                   
                     InitDataProperty(0, cnt++ , dtData   ,  50, daCenter, false, "sts_evnt_loc_cd", false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData   ,  50, daCenter, false, "agmt_lstm_cd"   , false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData   ,  70, daCenter, false, "vndr_seq"       , false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum,  110, daRight , false, "total"          , false, "", dfNone, 0, false, false);
                                                                                                                                         
                     InitDataProperty(0, cnt++ , dtAutoSum,  115, daRight , false, "umg"            , false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtAutoSum,  115, daRight , false, "clg"            , false, "", dfNone, 0, false, false);

 					 FitColWidth("0|40|40|30|60|60|60|");
//                     FitColWidth("0|15|15|15|15|15|");

                }
                 break;

             case 2:      //t1sheet1 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 380;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 if(document.form.kind.value == "L"){
                	 tmp = "Lessor";
                 }else{
                	 tmp = "Agreement No. ";
                 }
				 var HeadTitle = "|Seq|M.G.Set No.|"+tmp+"|Type|Term|On-hire|LCC|SCC|Yard|Event Date|System Date";
				 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter,  true, "Sta");                                                
                 InitDataProperty(0, cnt++, dtDataSeq,      0, daCenter,  true, "Seq"           , false, "", dfNone);                  
                 InitDataProperty(0, cnt++, dtData,  	  100, daCenter, false, "eq_no"         , false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,    	  100, daCenter, false, "vndr_seq"      , false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,  	   90, daCenter, false, "eq_tpsz_cd"    , false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,        60, daCenter, false, "agmt_lstm_cd"  , false, "", dfNone, 0, false, false); 
                                                                                                                                        
                 InitDataProperty(0, cnt++, dtData,    	   80, daCenter, false, "sts_evnt_dt"   , false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,    	   80, daCenter, false, "lcc_cd"        , false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,  	   80, daCenter, false, "scc_cd"        , false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,    	   80, daCenter, false, "sts_evnt_yd_cd", false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, dtData,  	  100, daCenter, false, "evnt_dt"       , false, "", dfNone, 0, false, false); 
                 
                 InitDataProperty(0, cnt++, dtData,   	  100, daCenter, false, "upd_dt"        , false, "", dfNone, 0, false, false); 


//                 FitColWidth("0|5|10|10|5|5|5|10|10|10|10|10|");

            }
             break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
          
            case IBSEARCH:      //조회

            if(validateForm(sheetObj,formObj,sAction)){
             	 queryString = "f_cmd=" + SEARCH ;
             	formObj.f_cmd.value = SEARCH;
	        	 var params = FormQueryString(formObj);
				 
				 
				 if(formObj.str_gubun[0].checked)
				 {
					 sheetObj.WaitImageVisible=false;
				 	 ComOpenWait(true);
	                 sheetObj.DoSearch("EES_CGM_2012GS.do",  params);
	                  
//	                 sheetObj.SumText(1,"")= "";
//	 	             
	                 sheetObj.SumText(0,3) = "Grand Total";
	                 sheetObj.SumText(0,"sts_evnt_loc_cd")        = "";
//	                 sheetObj.SumText(0,"Month")="Grand Total";
	                
	                 ComOpenWait(false);
				 }
				 else
				 {
					 sheetObj.WaitImageVisible=false;
				 	 ComOpenWait(true);
	                 sheetObj.DoSearch("EES_CGM_2012GS.do",  params);
	                 ComOpenWait(false);
				 }
	          }
                 break;
                 
            case IBSEARCH_ASYNC01:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
		  			MakeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0);
		       	break;
	       case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
			   /*	formObj.f_cmd.value = COMMAND01;
			   	formObj.ofc_cd.value = formObj.scc_cd.value;
			   	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Office');
			   		formObj.sts_evnt_ofc_cd.value = "";
			   		formObj.sts_evnt_ofc_cd.focus();
			   	}
			   	*/
			   	break;
	 	   case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크
			   	formObj.f_cmd.value = COMMAND01;
			   	formObj.yd_cd.value = formObj.sts_evnt_yd_cd.value;
			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
			   	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.sts_evnt_yd_cd.value = "";
			   	    
			   		// chungpa 20100414 keyup->focusout start
			   		//formObj.sts_evnt_yd_cd.focus();
   			   	    // chungpa 20100414 keyup->focusout end
			   	}
			   	break;
	 	  case IBSEARCH_ASYNC04:	// Term Code Combo 조회
		       	formObj.f_cmd.value = SEARCH;
		       	formObj.intg_cd_id.value = COM_CD_TYPE_CD02117;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   			    			
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		   			
		   		// combo control, 결과 문자열, Text Index, Code Index
		  			MakeComboObject2(formObj.location, arrStr, 0, 0);
		       	break;

     	  case IBSEARCH_ASYNC05:	// ( location)조회
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
	
	 		//agmt_lstm_cd
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0);
	 		idx++;       
	 		
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject2(formObj.location, arrStr1, 0, 0);
	 		idx++;       
	 		
//		  	
	  	  	
	 		break;
         }
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
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {

                 }
              break;

          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {


         var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab= nItem;
 		

     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
//     		 		ComShowMessage(location.text);
     		 		location.value  = location.text;
//     		 		 
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
     	    		
     		 		if(location.value == ''){
            				ComShowCodeMessage('CGM10004','location ');
            				location.focus();
            				
            				return false;
            			}
     		 		if(scc_cd.value == ''){
            				ComShowCodeMessage('CGM10004','scc_cd');
            				scc_cd.focus();
            				
            				return false;
            			}
    		 		if(scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
           				scc_cd.focus();
           				
           				return false;
           			}
    		 		if(sts_evnt_yd_cd.value!= '' && sts_evnt_yd_cd.value.length !=7){
    		 			ComShowCodeMessage('CGM10044','Yard(7)');
           				scc_cd.focus();
           				
           				return false;
           			}
            			break;
     		 }      
     	 }

          return true;
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
	   	    	    // chungpa 20100405 combo 변경 single => multi start
		   	 	 		var cnt=0;
		   	  	        with(comboObj) {
		   	  	        	Code = "";
		   	  	            Text = "";
		   	  	            DropHeight = 180;
		   	  	            MultiSelect = true;
		   	  	            MaxSelect = 100;	    
		   	  	            UseCode = true;
		   	  	            Enable = true;
		     	            
			   	            ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
			   	            IMEMode = 0;            // 영문
			   	            MaxLength = 20;         // 100자까지 입력
		   	  	       }
	  	  	        
	   	    	   /*
	   	           var cnt=0;
	   	           with(comboObj) {
	   	            	Code = "";
	   	            	Text = "";
	   	            	DropHeight = 100;
	   	            	MultiSelect = false;
	   	            	MaxSelect = 1;	    
	   	            	UseCode = true;
	   	            	Enable = true;
	   	            	comboObj.UseAutoComplete = true;
	   	           }*/
	   	           // chungpa 20100405 combo 변경 single => multi end
    	            break;
    	       case "location":
    	           var cnt=0;
    	           with(comboObj) {
    	            	Code = "";
    	            	Text = "";
    	            	DropHeight = 100;
    	            	MultiSelect = false;
    	            	MaxSelect = 1;	    
    	            	UseCode = true;
    	            	Enable = true;
    	            	comboObj.UseAutoComplete = true;
    	            }
    	            break;
    	    }
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
         
      // Lease Term Combo Control에  초기값을  설정한다.
//         doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//         doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
     	 doActionIBSheet(sheetObj, formObj, IBRESET);
         //formObj.agmt_lstm_cd.text ='ALL'; // chungpa 20100405 combo 변경 single => multi
         formObj.location.text ='RCC';
         // 초기 focus
         formObj.evnt_dt_str.focus();
      
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
        * programNo 입력부분. <br>
        * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
        * @param  {Array} aryPopupData	필수	 Array Object
        * @param  {Int} row				필수 선택한 Row
        * @param  {Int} col				필수 선택한 Column
        * @param  {Int} sheetIdx			필수 Sheet Index
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */   
       function setProgramNo(aryPopupData, row, col, sheetIdx){
       	 
      	 var formObj = document.form;
       	 var vndrSeq = "";
       	 var vndrNm = "";
       	 var i = 0;
//           	 ComShowMessage('setProgramNo'+aryPopupData.length);
       	 for(i = 0; i < aryPopupData.length; i++){
       		 vndrSeq = vndrSeq + aryPopupData[i][2];
       		
       		/* if(aryPopupData.length == 1){
       			 vndrNm = vndrNm + aryPopupData[i][4];
       		 }*/
       		 
       		 if(i < aryPopupData.length - 1){
       			 vndrSeq = vndrSeq + ",";
       		 }
//           		ComShowMessage('vndrSeq=='+vndrSeq);
       	 }
       	 
       	  formObj.vndr_seq.value = vndrSeq;
       	 
       	 
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
            // chungpa 20100405 combo 변경 single => multi start
          	for (var i = 0; i < arrStr.length;i++ ) {
          		var arrCode = arrStr[i].split("|");
          		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
          	}
          	
          	/*
          	cmbObj.InsertItem(0,"ALL","");
          	for (var i = 0; i < arrStr.length;i++ ) {
          		var arrCode = arrStr[i].split("|");
          		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
          	}
          	cmbObj.Index2 = "" ;
          	*/
            // chungpa 20100405 combo 변경 single => multi end        	
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
         function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
         	cmbObj.RemoveAll();
//         	cmbObj.InsertItem(0,"","");
         	for (var i = 0; i < arrStr.length;i++ ) {
         		var arrCode = arrStr[i].split("|");
         		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
              	}
//         	cmbObj.Index2 = "" ;
         }
         
         /**
          * 기본 오브젝트 초기화 
          */
         function objectClear(){
         	var formObj = document.form;
         	var sheetObject  = sheetObjects[0];
         	var sheetObject1 = sheetObjects[1];
         	
         	//IBMultiCombo 초기화
        	formObj.location.Code = "R";
	       	formObj.agmt_lstm_cd.Code = "";
	       	if(formObj.str_gubun[0].checked== true)
	       	{
	       		formObj.reset();
	       		formObj.str_gubun[0].checked = true;
	       	}
	       	else
	       	{
	       		formObj.reset();
	       		formObj.str_gubun[1].checked = true;
	       	}
			//formObj.agmt_lstm_cd.text ='ALL'; // chungpa 20100405 combo 변경 single => multi
//             	formObj.eq_spec_no.Code = "";
//             	formObj.vndr_seq.Code = "";
//
//             	formObj.eq_tpsz_cd.Code = "UMG";
//             	sheetObject1.RowStatus(1)="I";
//             	sheetObject1.CellValue(1, "eq_knd_cd") = "G";
//             	sheetObject1.CellValue(1, "mgst_vltg_capa") = "220";
         	
//             	formObj.mgst_vltg_capa[0].checked = true;
         }
          
       	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     	{
      
     		with(sheetObj)
     		{
     			ShowSubSum(1, "4|5|6",-1, true, false, 0, "agreement=;vndr_seq=Sub Total");
//     			ShowSubSum(1, "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "vndr_seq=Sub Total");
     		}	
     	}

       	function chk(a)
        {
     	   var objs = document.all.item("tabLayer");
     	   var sheetObj = sheetObjects[0];  
     	   var sheetObj2 = sheetObjects[1];   
     	   if(a=="1")
     	   {
     		   objs[1].style.display = "none";
 	           objs[0].style.display = "Inline";
 	           sheetObj.RemoveAll();
 	            if(formObj.kind.value=="L") {
 		    		sheetObj.cellValue(0, 3)  = "Lessor";
 		    		sheetObj2.cellValue(0, 3) = "Lessor";
	   		    } else {
	   		    	sheetObj.cellValue(0, 3)  = "Agreement No.";
	   		    	sheetObj2.cellValue(0, 3) = "Agreement No.";
	   		    }
     	   }
     	   else
     	   {
     		   objs[0].style.display = "none";
 	           objs[1].style.display = "Inline";
 	           sheetObj2.RemoveAll();
 	           if(formObj.kind.value=="L") {
 		    		sheetObj.cellValue(0, 3)  = "Lessor";
 		    		sheetObj2.cellValue(0, 3) = "Lessor";
	   		   } else {
	   		    	sheetObj.cellValue(0, 3)  = "Agreement No.";
	   		    	sheetObj2.cellValue(0, 3) = "Agreement No.";
	   		   }
     	   }
     	   
        }
       	
       	/** 
         * location 의 change 이벤트에 대한 처리  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */    
        function location_OnChange()
        {
       	  Grid_Remove();
        }
        
        /** 
        * agmt_lstm_cd_OnChange 의 change 이벤트에 대한 처리  <br>
        * @param  없음
        * @return 없음
        * @author 최민회
        * @version 2009.05.20
        */    
        function agmt_lstm_cd_OnChange()
        {
       	 Grid_Remove();
        }
       	
        /** 
         * Object 의 change 이벤트에 대한 처리  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */  
        function obj_change(){
        	 var formObj = document.form;
        	 var sheetObj  = sheetObjects[0]; 
        	 var sheetObj2 = sheetObjects[1];
        	 obj = event.srcElement;
        	 switch(obj.name){
        	   case "kind":
        		    formObj.vndr_seq.value='';
        		    Grid_Remove();
//        		    initSheet(sheetObj,1);
        		    if(formObj.kind.value=="L") {
        		    	sheetObj.cellValue(0, 3)  = "Lessor";
        		    	sheetObj2.cellValue(0, 3) = "Lessor";
        		    } else {
        		    	sheetObj.cellValue(0, 3)  = "Agreement No.";
        		    	sheetObj2.cellValue(0, 3) = "Agreement No.";
        		    }
        		   
        		   
        	 		break;    	 	
        	   case "eq_aset_sts_cd":
    	    	    Grid_Remove();
    		 		break;    	
//        	   case "sts_evnt_yd_cd":
//        	 		if(formObj.sts_evnt_yd_cd.value != ''){
//        	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
//        	 			
//        	 		} 
//        	 		break;
//        	   case "scc_cd":
//	       	 		if(formObj.scc_cd.value != ''){
//	       	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
//	       	 		}
//       	 			break;
        	 }   
        }
         
         
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
    		    // chungpa 20100414 keyup->focusout start
    		    ComKeyEnter('lengthnextfocus');    	 
    		    /*
	    	    var sts_evnt_yd_cd;
    	    	sts_evnt_yd_cd = formObj.sts_evnt_yd_cd.value;
    	    	if (sts_evnt_yd_cd.length == 7) {
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	    	}*/
    		    // chungpa 20100414 keyup->focusout end    	    	
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
         
         function  Grid_Remove()
         {
        	 var formObj = document.form;
        	 var sheetObj = sheetObjects[0];  
      	     var sheetObj2 = sheetObjects[1];
    	  	 if(formObj.str_gubun[0].checked){
    	  		 sheetObj.RemoveAll();
//    	  		ComShowMessage("1");
    	  	 }
    	  	 else if (formObj.str_gubun[1].checked)
    	  	 {
    	  		sheetObj2.RemoveAll();
//    	  		ComShowMessage("2");
    	  	 }   	
    	  	 
         }
         
         /**
          * AXON 이벤트 처리
          */
         function obj_activate(){
             ComClearSeparator(event.srcElement);
         }
          
        
       	/**
       	 * detail화면 double클릭시 해당 Equipment No에 대한 M.G.Set Master Inquiry 화면을 보여줌 <br>
       	 * 
       	 * @author 조재성
       	 * @version 2009.10.14
       	 */   
        function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH)
        {
        	var formObject = document.form;
           	if(formObject.str_gubun[0].checked){

           	}
           	else if (formObject.str_gubun[1].checked)
           	{
           	   	if(Row >= 1)
            	{
        			if(sheetObj.cellValue(Row, "eq_no") == null || sheetObj.cellValue(Row, "eq_no") == "")
        			{
        				return;
        			}
        			var eqNo = sheetObj.cellValue(Row, "eq_no");
        			
        			
        			var param = "?pgmNo=EES_CGM_1003&eq_no=" + eqNo;
        			var seq = sheetObj.cellValue(Row, "Seq");
        			if(seq != ''){
        				//기존 ComOpenPopup('/hanjin/EES_CGM_1003.do' + param, 1100, 500, "", "1,0", true, false);
        				
        		  		var pgmNo = 'EES_CGM_2006';
        		  		var pgmUrl = '/hanjin/EES_CGM_2006.do';
        		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';   
        		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
        		    	
        		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
        		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
        			}
            	}
           	}
        }
       	 
       	 
         function  Grid_Remove()
         {
        	 var formObj = document.form;
        	 var sheetObj = sheetObjects[0];  
      	     var sheetObj2 = sheetObjects[1];
    	  	 if(formObj.str_gubun[0].checked){
    	  		 sheetObj.RemoveAll();
//    	  		ComShowMessage("1");
    	  	 }
    	  	 else if (formObj.str_gubun[1].checked)
    	  	 {
    	  		sheetObj2.RemoveAll();
//    	  		ComShowMessage("2");
    	  	 }   	
    	  	 
         }
         /** 
          * location 의 change 이벤트에 대한 처리  <br>
          * @param  없음
          * @return 없음
          * @author 최민회
          * @version 2009.05.20
          */    
         function location_OnChange()
         {
        	   var sheetObj = sheetObjects[0];  
    	   	   if(document.form.location.Code=="S")
    	   	   {
    	           sheetObj.cellValue(0, 1)  = "Yard";
    	   	   } else {
    	   		   sheetObj.cellValue(0, 1)  = "Location";
    	   	   }
        	  Grid_Remove();
         }
         
         /** 
         * agmt_lstm_cd_OnChange 의 change 이벤트에 대한 처리  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */    
         function agmt_lstm_cd_OnChange()
         {
        	 
        	 Grid_Remove();
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
       	   if(Col>3 && Col<=6){
//      			var eqTpszCd = "";
                 var colSaveName = sheetObj.ColSaveName(Col);
//                 	
              	var crntYdCd		= document.form.sts_evnt_yd_cd.value;
              	var eqStrDt 		= document.form.evnt_dt_str.value;
              	var eqEndDt		    = document.form.evnt_dt_end.value;
              	var scc_cd          = document.form.scc_cd.value;
              	var eqAsetStsCd	    = document.form.eq_aset_sts_cd.value;
              	var sAgmtLstmCd		= document.agmt_lstm_cd.Text; // chungpa 20100405 combo 변경 single => multi
              	var eq_tpsz_cd      = "";
              	var agmt_lstm_cd    = "";
              	var sts_evnt_loc_cd = "";
                 	
   				if(colSaveName == 'umg') 		eq_tpsz_cd = "UMG";
   				else if(colSaveName == 'clg')	eq_tpsz_cd = "CLG";
   				else if(colSaveName == 'total')	eq_tpsz_cd = "";
   				if( sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "" || sheetObj.CellValue(Row, "vndr_seq") == "Sub Total"){
         		   if(crntYdCd ==""){
         			   sts_evnt_loc_cd = sheetObj.CellValue(Row-1, "sts_evnt_loc_cd");
         		   } else {
         			   sts_evnt_loc_cd = "";
         		   }
         		   vndr_seq        = "";
         	   } else if (sheetObj.CellValue(Row, "sts_evnt_loc_cd")== "Grand Total" && sheetObj.CellValue(Row, "vndr_seq") == ""){
         		   sts_evnt_loc_cd = "";
         		   vndr_seq        =  sheetObj.CellValue(Row, "sts_evnt_loc_cd");
         	   } else {
         		   if(crntYdCd ==""){
         			   sts_evnt_loc_cd = sheetObj.CellValue(Row, "sts_evnt_loc_cd");
         		   } else {
         			   sts_evnt_loc_cd = "";
         		   }
         		   vndr_seq        =  sheetObj.CellValue(Row, "vndr_seq")
         	   }
         	   agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
//         	   if(sheetObj.CellValue(Row, "agmt_lstm_cd")==""){
//         	    	agmtLstmCd	    = document.form.agmt_lstm_cd.Code;
//         	    } else {
//         	    	agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
//         	    }
//         	   if(document.form.location.Code=="S")
//     	   	   {
//         		   crntYdCd = sts_evnt_loc_cd;
//         		   sts_evnt_loc_cd = "";
//     	   	   } 
         	  kind 	= document.form.kind.value;
 

   	           	var param = "?pgmNo=EES_CGM_2084&program_id=2012";
   	           	param = param + "&s_crnt_yd_cd=" + crntYdCd;
   	           	param = param + "&sts_evnt_dt_fr=" + eqStrDt;
   	           	param = param + "&sts_evnt_dt_to=" + eqEndDt;
   	     	    param = param + "&s1_inq_to_dys=" + eqAsetStsCd;
   	            param = param + "&s_location=" + document.form.location.Code;
   	            param = param + "&s_crnt_loc_cd=" + sts_evnt_loc_cd;
   	     	    param = param + "&s_vndr_seq=" + vndr_seq;
   	            param = param + "&eq_tpsz_cd=" + eq_tpsz_cd;
   	            param = param + "&s_agmt_lstm_cd=" + sAgmtLstmCd; // chungpa 20100405 combo 변경 single => multi
   	            param = param + "&s2_agmt_lstm_cd=" + agmtLstmCd;
   	            param = param + "&s2_loc_cd=" + scc_cd;
   	            param = param + "&s2_group1="+kind;

   	        	ComOpenPopup('/hanjin/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
             	
      	   }
         }
         // 업무 자바스크립트 OnFocusOut 이벤트 처리
         function obj_focusout() {
         	switch(event.srcElement.name){ 
	    	 	case "sts_evnt_yd_cd":
	    		    // chungpa 20100414 keyup->focusout start
		  	 		var formObj = document.form;
		  	 		var sheetObj = sheetObjects[0];
		    	    var sts_evnt_yd_cd;
		    	    sts_evnt_yd_cd = formObj.sts_evnt_yd_cd.value;
	    	    	if (sts_evnt_yd_cd.length == 7) {
	    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	    	}
	    		    // chungpa 20100414 keyup->focusout end    	    	
	    	    	break;		  		    	    		  
         	}
         }          
	/* 개발자 작업  끝 */