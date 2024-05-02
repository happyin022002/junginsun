/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2016.js
*@FileTitle : M.G.Set의 Attach 또는 Detach를 Manual로 Creation 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.20 최민회
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
     * @class EES_CGM_2016 : EES_CGM_2016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_2016() {
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

                 case "Delete":
                	 doActionIBSheet(sheetObject,formObject,REMOVE);
 					break;

 				case "Save":
 					doActionIBSheet(sheetObject, formObject, IBSAVE);
 					break;


                 case "New":
                	 sheetObject.RemoveAll();
                	 formObject.reset();
 					 break;


                 case "Row_Add":
                	 sheetObject.DataInsert();
 					break;
                 case "ComOpenPopupWithTargetYard":
           			ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
           			break;

 	 		     case "btns_Calendar1" :		// Agreement Date (From Date)
 	 				var cal = new ComCalendar();
 	 		        cal.setEndFunction("processEndCal");
	 	 			cal.select(formObject.acth_dt, "yyyy-MM-dd");
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

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

         var formObj = document.form;
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
         axon_event.addListenerFormat('beforeactivate',		'obj_activate',		formObj);
         axon_event.addListener('focusout', 'obj_focusout',  'acth_dt','acth_dt_hm');
         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
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
                     style.height = 400;
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

 					var HeadTitle = "||Seq|M.G.Set No.|Type|AT/DT|Container/Chassis No.|Status||AT/DT Time||||";
 					var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30, daCenter, false, "ibflag");
//                     InitDataProperty(0, cnt++ , dtStatus, 30, daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter, false, "del_chk",        false, "", dfNone, 0,  true,   true);
                     InitDataProperty(0, cnt++ , dtDataSeq,      60, daCenter,  true, "Seq",            false, "", dfNone);
                     InitDataProperty(0, cnt++ , dtData,        150, daCenter,  true, "eq_no",          false, "", dfNone, 0,  true,       true,10);
                     InitDataProperty(0, cnt++ , dtData,        80, daCenter,  true, "eq_tpsz_cd",     false, "", dfNone, 0,  true,       false);

                     InitDataProperty(0, cnt++ , dtCombo,        80, daCenter,  true, "at",             false, "", dfNone,  0, false,       false);
                     InitDataProperty(0, cnt++ , dtData,        180, daCenter,  true, "cntr_no1",       false, "", dfNone,  0, false,       false,11);
                     InitDataProperty(0, cnt++ , dtData,        280, daCenter,  true, "Status",         false, "", dfNone,  0, false,       false);
                     InitDataProperty(0, cnt++ , dtHidden,      100, daCenter, false, "cntr_tpsz_cd",   false, "", dfNone,  0, false,       false);
                     InitDataProperty(0, cnt++ , dtData,        100, daCenter, false, "atch_dt"     ,   false, "", dfNone,  0, false,       false);

                     InitDataProperty(0, cnt++ , dtHidden,      10, daCenter, false, "dtch_dt"     ,   false, "", dfNone,  0, false,       false);
                     InitDataProperty(0, cnt++ , dtHidden,      10, daCenter, false, "atch_yd_cd"  ,   false, "", dfNone,  0, false,       false);
                     InitDataProperty(0, cnt++ , dtHidden,      10, daCenter,  true, "cntr_no2",       false, "", dfNone,  0, false,       false);
                     InitDataProperty(0, cnt++ , dtHidden,      10, daCenter,  true, "aciac_div_cd",   false, "", dfNone,  0, false,       false);

                     InitDataValid(0, "eq_no", vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_no1", vtEngUpOther, "1234567890");
                     InitDataCombo(0, "at",	" |AT|DT",	" |AT|DT",	" ",	" ");
 					 SelectionMode   = smSelectionFree;

                    // FitColWidth("0|5|10|15|15|15|");

                }
                 break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 			case IBSAVE:        //저장
			    var actionFlag = false;
 			    var chkFlag    = false;
//       		if(validateForm(sheetObj,formObj,sAction))
	            if(formObj.acth_dt.value==""){
	            	ComShowCodeMessage('CGM10004','Date. ');
					formObj.acth_dt.focus();
					return false;
	            }
	 			 if(formObj.acth_dt_hm.value==""){
	             	ComShowCodeMessage('CGM10004','Time. ');
					formObj.acth_dt_hm.focus();
					return false;
	             }

	 			 if(formObj.sts_evnt_yd_cd.value==""){
		             	ComShowCodeMessage('CGM10004','Yard. ');
						formObj.sts_evnt_yd_cd.focus();
						return false;
		         }
	 			if(formObj.sts_evnt_yd_cd.value!='' && formObj.sts_evnt_yd_cd.value.length !=7){
		 			 ComShowCodeMessage('CGM10044','Yard (7)');
		 			formObj.sts_evnt_yd_cd.focus();

      				 return false;
      			}
	       		formObj.f_cmd.value = MODIFY;
				queryString = "f_cmd=" + MODIFY ;
				  for(i=1;i<sheetObj.LastRow+1;i++)
	              {
					  sheetObj.CellValue(i, "atch_yd_cd") =  formObj.sts_evnt_yd_cd.value;
					  if(sheetObj.CellValue(i, "at") == "AT"){
						  sheetObj.CellValue(i, "atch_dt") = formObj.acth_dt.value + " " +formObj.acth_dt_hm.value;
						  if(sheetObj.CellValue(i, "cntr_no1") == ""){
							  chkFlag = true;
						  }

					  } else {
						  sheetObj.CellValue(i, "dtch_dt") = formObj.acth_dt.value + " " +formObj.acth_dt_hm.value;
					  }
					  sheetObj.CellValue(i, "atch_yd_cd") = formObj.sts_evnt_yd_cd.value;

					  if(sheetObj.CellValue(i, "del_chk") == "1" && sheetObj.CellValue(i, "Status")!= 'OK'){
						 // Status 가 OK 가 아닌 ROW 를 Save 시도시 CGM10007 메시지 출력
	//					 sheetObj.CellValue(i, "del_chk") = "0";
	//					 sheetObj.RowStatus(i) = "R";
						 actionFlag = true;
					  } else if (sheetObj.CellValue(i, "del_chk") == "0") {
						 sheetObj.RowStatus(i) = "R";
					  }


	              }

				  if(actionFlag){
					    // Status 가 OK 가 아닌 ROW 를 Save 시도시 CGM10007 메시지 출력
			        	ComShowCodeMessage("CGM10007");
					    return false;
				  } else if(chkFlag){
					    ComShowCodeMessage("CGM10009"," Container/Chassis No.");
					    return false;
				  } else {
						if(sheetObj.DoSave("EES_CGM_2016GS.do",queryString + "&" + ComGetPrefixParam(""), -1, false),'del_chk')
						{

						} else {
							 for(i=1;i<sheetObj.LastRow+1;i++)
							 {
								 sheetObj.RowStatus(i) = "I";
							 }
						}
				  }
				  var params = sheetObj.GetSaveString(true);



                break;

            case REMOVE: 	   // 삭제
				for(i=sheetObj.rowCount; i>0; i--){
		   			if(sheetObj.CellValue(i, "del_chk") != "0" ) {
		   				sheetObj.RowDelete(i, false);
		   			}
		   		 }
				 break;
 			case IBSEARCH_ASYNC01:	// Office Code 에 대한 Validation 체크
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
         }
     }





     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
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
	 	case "hm":
	 		ComKeyOnlyNumber(obj);
	        break;
	    case "eng":
	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
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
    	    if(obj.name=="acth_dt"  ){
        		 with(formObj){
        			 var creDtFr = ComReplaceStr(acth_dt.value,"-","");
     	        }


     	        ComChkObjValid(event.srcElement);
          }
    	   if(obj.name=="acth_dt_hm"  ){
         		 with(formObj){
         			 var creDtFr = ComReplaceStr(acth_dt.value,":","");
      	        }
         		 ComChkObjValid(event.srcElement);
          }

     }
      /**
       * AXON 이벤트 처리
       */
      function obj_activate(){
          ComClearSeparator(event.srcElement);
      }

   /**
     * Object 의 obj_focusout 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */
    function obj_focusout(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
//    	 	case "sts_evnt_yd_cd":
//    	 		if(formObj.sts_evnt_yd_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//    	 			break;
//    	 		}
    	 	case "acth_dt":
    	 		 var dt   =   ComReplaceStr(form.form_day.value,"-","");
    	 		 var dt2  =   ComReplaceStr(form.acth_dt.value,"-","");;
	   	         if(form.acth_dt.value!="" &&  dt2 > dt){
	   	        	 form.acth_dt.value = "";
	   	        	 form.acth_dt.focus();
	   	        	 ComShowCodeMessage('CGM10059');

	   	        	 return;
	   	 	    }
    	 		 for(i=1;i<sheetObj.LastRow+1;i++)
				 {
    	 			 //Date,time 의 경우 해당 장비의 최근 at/dt 이력 이후이어야 하고 현재 시간 이전이어야 한다.
    	 			 // 아닐경우 Status 에 결과(check date/time)
    	 			if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") < sheetObj.CellValue(i, "atch_dt")   ){
    	 				sheetObj.CellValue2(i, "Status")         = "check date/time";
			    	} else {
			    		sheetObj.CellValue2(i, "Status")         = "";
			    		sheetObj.CellEditable(i, "at") = true;
			    	}
				 }
    	 		break;
    	 	case "acth_dt_hm":
    	 		 for(i=1;i<sheetObj.LastRow+1;i++)
				 {
    	 			 //Date,time 의 경우 해당 장비의 최근 at/dt 이력 이후이어야 하고 현재 시간 이전이어야 한다.
    	 			 // 아닐경우 Status 에 결과(check date/time)
    	 			if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") < sheetObj.CellValue(i, "atch_dt")   ){
    	 				sheetObj.CellValue2(i, "Status")         = "check date/time";
			    	} else {
			    		sheetObj.CellValue2(i, "Status")         = "";
			    		sheetObj.CellEditable(i, "at") = true;
			    	}
				 }
    	 		break;
    	 }
    }

	  /**
      * Found date 입력시, 현재 날짜/시간 이후를 입력시 오류.
      * "Found Date cannot be later than now."
      * @return
      */
     function processEndCal(){
    	 var form = document.form;
    	 var dt   =   ComReplaceStr(form.form_day.value,"-","");
 		 var dt2  =   ComReplaceStr(form.acth_dt.value,"-","");;
         if(form.acth_dt.value!="" &&  dt2 > dt){
        	 form.acth_dt.value = "";
        	 form.acth_dt.focus();
        	 ComShowCodeMessage('CGM10059');

        	 return;
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
    	    	    var sts_evnt_yd_cd;
    		    	frmObj = document.form;
    		    	//alert("sss");
    		    	sts_evnt_yd_cd = frmObj.sts_evnt_yd_cd.value;
    		    	if (sts_evnt_yd_cd.length == 7) {
    		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    		    	}
    		    	break;
    		 }
    	}
     /**
 	 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
 	 * Agreement No 과 Referece No 의 유효성을 체크한다.
 	 */
 	function sheet1_OnChange(sheetObj, Row, Col){
       var formObj = document.form;
       var chk      = true;

    	  switch (sheetObj.ColSaveName(Col)) {

          case "eq_no" :
     	        formObj.f_cmd.value = SEARCH;
			   	formObj.eq_no.value =sheetObj.CellValue(Row, "eq_no");
			   	var cellValue = sheetObj.cellValue(Row, Col);
			   	if(sheetObj.CellValue(Row, "eq_no")!="")
			   	{
	 			   	if(Row >1)
	 				{
	 					// chassis no 체크
	 					for(i=1; i<sheetObj.rowCount; i++){

	 						if(sheetObj.CellValue(i, "eq_no")== cellValue && Row != i )
		 					{
		 						chk = false;
		 					}
		 				}


	 				}

	 			    if(chk == true)
					{
	 			   		var sXml = sheetObj.GetSearchXml("EES_CGM_2016GS.do", FormQueryString(formObj));
	 				    // 데이터 건수
	 				    var dataCount = ComGetTotalRows(sXml);
	 				    // 데이터가 존재할 경우
	 				    if(dataCount > 0){
	 				    	// Date,time 의 경우 해당 장비의 최근 at/dt 이력 이후이어야 하고 현재 시간 이전이어야 한다.
	 				    	// 아닐경우 Status 에 결과(check date/time)
 				    		if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") > DomXml2String(sXml,"atch_dt")){
 				    			if( DomXml2String(sXml,"aciac_div_cd")=="I"){
		 				    		sheetObj.CellValue2(Row, "Status")         = "Inputted M.G.Set No. is not active";
		 				    		sheetObj.CellEditable(Row, "at") = false;
		 				    	} else {
		 				    		sheetObj.CellValue2(Row, "Status")         = "";
		 				    		sheetObj.CellEditable(Row, "at") = true;
		 				    	}
	 				    	} else {

	 				    		sheetObj.CellValue2(Row, "Status")         = "check date/time";
	 				    		sheetObj.CellEditable(Row, "at") = false;
	 				    	}

	 				    	sheetObj.CellValue2(Row, "eq_tpsz_cd")     = DomXml2String(sXml,"eq_tpsz_cd");
	 				    	sheetObj.CellValue2(Row, "at")             = "";
	 				    	sheetObj.CellValue2(Row, "cntr_no1")       = DomXml2String(sXml,"cntr_no1");
	 				    	sheetObj.CellValue2(Row, "cntr_tpsz_cd")   = DomXml2String(sXml,"cntr_tpsz_cd");
	 				    	sheetObj.CellValue2(Row, "atch_dt")        = DomXml2String(sXml,"atch_dt");
	 				    	sheetObj.CellValue2(Row, "cntr_no2")       = DomXml2String(sXml,"cntr_no2");
	 				    	sheetObj.CellValue2(Row, "aciac_div_cd")   = DomXml2String(sXml,"aciac_div_cd");

	 				    	sheetObj.CellValue2(Row, "del_chk") = "1";
//	 				    	sheet1_edit(Row,true);
	 				   	} else {
	 				   		ComShowCodeMessage('CGM10009','M.G.Set No.');
	 				     	sheetObj.CellValue2(Row, "eq_no")          = "";
	 				   		sheetObj.CellValue(Row, "eq_tpsz_cd")     = "";
	 				     	sheetObj.CellValue2(Row, "cntr_no1")       = "";
					    	sheetObj.CellValue2(Row, "at")             = "";
					    	sheetObj.CellValue2(Row, "cntr_tpsz_cd")   = "";
					    	sheetObj.CellValue2(Row, "Status")         = "";
					    	sheetObj.CellValue2(Row, "del_chk")        = "0";
					    	sheetObj.CellValue2(Row, "atch_dt")        = "";
					    	sheetObj.CellEditable(Row, "at") = false;
//					    	sheet1_edit(Row,false);
	 				   	}
					}
					else
					{

			        	ComShowCodeMessage("CGM10017","  M.G.Set No.");
			        	// 해당 Cell 값을 Null로 설정
						sheetObj.CellValue(i, "eq_no") = "";
					}
			   	}
			    break;
        	case "at" :

        		if((formObj.acth_dt.value + " "+ formObj.acth_dt_hm.value+":00") < sheetObj.CellValue(Row, "atch_dt")   ){
	 				sheetObj.CellValue2(Row, "Status")         = "check date/time";
	 				return false ;
		    	} else {
		    		sheetObj.CellValue2(Row, "Status")         = "";
		    	}
        		// 각 Row 에서 어떤 항목이라도 수정하면 Status 를 Null 로 만들어주세요.
        		if(sheetObj.CellValue(Row, "at") ==""  ){
        			sheetObj.CellValue(Row, "Status")             = "";
        			sheetObj.CellValue2(Row, "cntr_no1") = sheetObj.CellValue(Row, "cntr_no2") ;
        		}

        		if(sheetObj.CellValue(Row, "at") =="DT"  ){
        			if(sheetObj.CellValue(Row, "cntr_no2") ==""){
	           			ComShowCodeMessage("CGM10045");
	           			sheetObj.CellValue(Row, "Status")             = "Error";
	           			return false;
        			} else {
        				// Chassis No 입력후 DT 선택시, 기존의 Cntr 는 모두 null 로 만들고 Status 는 OK.
        				sheetObj.CellValue(Row, "cntr_no1")           = "";
//        				sheetObj.CellValue(Row, "cntr_no2")           = "";
        				sheetObj.CellValue(Row, "Status")             = "OK";
        			}
        		}

        		if(sheetObj.CellValue(Row, "at") =="AT"  ){
        			sheetObj.CellValue2(Row, "cntr_no1") = sheetObj.CellValue(Row, "cntr_no2") ;

        			if(sheetObj.CellValue(Row, "cntr_no1") ==""){
        				sheetObj.CellValue(Row, "Status")             = "";
        			} else {
        				sheetObj.CellValue(Row, "Status")             = "Error";
        				return false;
        			}
//
        		}

        		if(sheetObj.CellValue(Row, "at") =="AT" && sheetObj.CellValue(Row, "Status") != "Error" ){
        			//3. Cntr 가 없을때   CB4,SF4 만  Cntr(2) 를 입력가능하게 하고, Cntr(1) 는 항상 입력가능하게.
        			if(sheetObj.CellEditable(Row, "cntr_no1")  == ""){
        				sheetObj.CellEditable(Row, "cntr_no1")        = true;
        			}

        			if(sheetObj.CellValue(Row, "eq_tpsz_cd")== "CB4" || sheetObj.CellValue(Row, "eq_tpsz_cd")== "SF4" ){
        				sheetObj.CellEditable(Row, "cntr_no2")        = true;
        			}
        		} else {
        			sheetObj.CellEditable(Row, "cntr_no1")        = false;
        			sheetObj.CellEditable(Row, "cntr_no2")        = false;
        		}


        		// 아무것도 않할때
        		if(sheetObj.CellValue(Row, "at") ==""  ){
        			sheetObj.CellValue(Row, "Status")         = "";
        		}
        		break;
        	case "cntr_no1" :
        		var cntr_no1_Value = sheetObj.cellValue(Row, Col);
//           		if(cntr_no1_Value!=""){
//           			for(icntr=1; icntr<sheetObj.rowCount; icntr++){
// 						if(sheetObj.CellValue(icntr, "cntr_no1")== cntr_no1_Value && Row != icntr)
//	 					{
//							ComShowCodeMessage("CGM10017"," CNTR No.");
// 							sheetObj.cellValue(Row, Col) = "";
//	 					}
//	 				}
//           		}
        		if(sheetObj.CellValue(Row, "cntr_no1")!="")
			   	{
        			    formObj.f_cmd.value = SEARCH;
        			    if(sheetObj.CellValue(Row, "eq_tpsz_cd") == "CLG"){
        			    	var sXml = sheetObj.GetSearchXml("CGM_MST_CONTAINERGS.do?cntr_no="+sheetObj.CellValue(Row, "cntr_no1"), FormQueryString(formObj));
    	 				    // 데이터 건수
    	 				    var dataCount = ComGetTotalRows(sXml);
    	 				    // 데이터가 존재할 경우
    	 				    if(dataCount > 0){
    	 				    	if(DomXml2String(sXml,"disp_flg")=='DT'){
    	 				    		sheetObj.CellValue(Row, "cntr_no1")     = DomXml2String(sXml,"cntr_no");
        	 				    	sheetObj.CellValue(Row, "cntr_tpsz_cd") = DomXml2String(sXml,"cntr_tpsz_cd");
        	 				    	sheetObj.CellValue(Row, "Status")       = "OK";
    	 				    	} else {
    	 				    		if(DomXml2String(sXml,"eq_knd_cd")=='Z'){ // Chassis일경우 Valication을 타지 않는다
        	 				    		sheetObj.CellValue(Row, "cntr_no1")     = DomXml2String(sXml,"cntr_no");
            	 				    	sheetObj.CellValue(Row, "cntr_tpsz_cd") = DomXml2String(sXml,"cntr_tpsz_cd");
    	 				    		} 
//    	 				    		else {
//    	 				    		ComShowCodeMessage('CGM20035',DomXml2String(sXml,"eq_no"));
//        		 				   	sheetObj.CellValue(Row, "cntr_no1")     = "";
//        		 				    sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
//    	 				    		}
    	 				    		sheetObj.CellValue(Row, "Status")       = "OK";
    	 				    	}

    	 				   	} else {
    	 				   		ComShowCodeMessage('CGM10009','Container/Chassis No.');
    		 				   	sheetObj.CellValue(Row, "cntr_no1")     = "";
    		 				    sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
    	 				   	}
        			    } else {
        			    	var sXml = sheetObj.GetSearchXml("CGM_CHS_MASTERGS.do?eq_knd_cd=Z&eq_no="+sheetObj.CellValue(Row, "cntr_no1"), FormQueryString(formObj));
        			    	// 데이터 건수
    	 				    var dataCount = ComGetTotalRows(sXml);
    	 				    // 데이터가 존재할 경우
    	 				    if(dataCount > 0){
    	 				    	sheetObj.CellValue(Row, "cntr_no1")     = DomXml2String(sXml,"eq_no");
    	 				    	sheetObj.CellValue(Row, "cntr_tpsz_cd") = DomXml2String(sXml,"eq_tpsz_cd");
    	 				    	sheetObj.CellValue(Row, "Status")       = "OK";


    	 				   	} else {
    	 				   		ComShowCodeMessage('CGM10009','Container/Chassis No.');
    		 				   	sheetObj.CellValue(Row, "cntr_no1")     = "";
    		 				    sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
    	 				   	}
        			    }

        			// 각 Row 에서 어떤 항목이라도 수정하면 Status 를 Null 로 만들어주세요.
//        				sheetObj.CellValue(Row, "Status")             = "";
					}
				 break;

			   	}
   }

 	//저장후 조회 기능
 	  function sheet1_OnSaveEnd(sheetObj, errMsg) {
 		 if(errMsg =='') {
 			ComShowCodeMessage('CGM00003');
     		for(i=sheetObj.LastRow; i>0; i--){
 				  if(sheetObj.CellValue(i, "del_chk") == "1" ){
 					  sheetObj.RowDelete(i, false);
 				  }
 				}
 		}
 	  }
	/* 개발자 작업  끝 */