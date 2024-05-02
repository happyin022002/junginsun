/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1146.js
*@FileTitle : Chassis Off-Hire Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.20 최민회
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
     * @class ees_cgm_1146 : ees_cgm_1146 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1146() {
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

 var comboObjects = new Array();
 var comboCnt = 0;
 
 var sheetObjects = new Array();
 var sheetCnt = 0;
 //var prefix = "sheet1_"; prefix를 쓰게 되면 유저 입력 parameter가 default로 VOs에 적재되지 않기 때문에 "sheet1_" >> "" 로 정정함.
 var prefix = "";
 
 var chkFlag = false;
 
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
        	 formObj.reset();
        	 sheetObject1.RemoveAll();
             break; 

         case "btn_save":
        	 doActionIBSheet(sheetObject1, formObject, IBSAVE);
        	 break;
        	 
         case "btn_downexcel":
        	sheetObject1.SpeedDown2Excel(-1);
             break;                   
         case "btns_Calendar1" :		// Agreement Date (From Date)
			var cal = new ComCalendar();
            cal.setDisplayType('month');
			cal.select(formObject.de_yrmon, "yyyy-MM");
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
     
         //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
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
     axon_event.addListenerFormat('beforeactivate',		'obj_activate',	formObj);
     axon_event.addListener('keyup', 'enterFire', 'eq_knd_cd');
     axon_event.addListener('keyup', 'enterFire', 'de_yrmon');
     axon_event.addListener('keyup', 'enterFire', 'eq_no_fm');
     axon_event.addListener('keyup', 'enterFire', 'eq_no_to');
     axon_event.addListener('keyup', 'enterFire', 'fa_if_sts_cd');
     
     comboObjects[comboCnt++] = document.fa_if_sts_cd;
     for(var k=0;k<comboObjects.length;k++){
    	 initCombo(comboObjects[k]);
     }  
     
     /*
     doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
     formObj.fa_if_sts_cd.text = "ALL";
     */
     doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	
     //chungpa 20091014 FA I/F 버튼을, EES_CGM_1146 으로 버튼 링크.  변수 : eq_knd_cd, serian Range, delivery month 로 조회되도록.
     if(formObj.de_yrmon.value != "" && formObj.eq_no_fm.value != "" && formObj.eq_no_to.value != "")
		 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
     
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
         case 1:      //sheet1 init
             with (sheetObj) {
									 // 높이 설정
                 style.height = 480;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 6, 100);
                 
                 var HeadTitle = "||EQ.No.|TP/SZ|On-hire Date|AGMT No.|Spec. No.|Curr. Code|ACQ AMT|Invest code|Manufacturer|Delivery Month|Result";
                 HeadTitle = HeadTitle + "|lifid";
                 HeadTitle = HeadTitle + "|seq";
                 HeadTitle = HeadTitle + "|total_count";
                 HeadTitle = HeadTitle + "|rnum";
                 HeadTitle = HeadTitle + "|book_type_code";
                 HeadTitle = HeadTitle + "|asset_description";
                 HeadTitle = HeadTitle + "|asset_type";
                 HeadTitle = HeadTitle + "|category_segment";
                 HeadTitle = HeadTitle + "|cost";
                 HeadTitle = HeadTitle + "|location_segment";
                 HeadTitle = HeadTitle + "|date_placed_in_service";
                 HeadTitle = HeadTitle + "|tag_number";
                 HeadTitle = HeadTitle + "|attribute1";
                 HeadTitle = HeadTitle + "|attribute2";
                 HeadTitle = HeadTitle + "|attribute3";
                 HeadTitle = HeadTitle + "|attribute4";
                 HeadTitle = HeadTitle + "|created_by";
                 HeadTitle = HeadTitle + "|creation_date";
                 HeadTitle = HeadTitle + "|last_updated_by";
                 HeadTitle = HeadTitle + "|last_update_date";
                 HeadTitle = HeadTitle + "|manufacturer";
                 HeadTitle = HeadTitle + "|attribute21";
                 HeadTitle = HeadTitle + "|acq_mth";
                                      
				 var headCount = ComCountHeadTitle(HeadTitle);
                 
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 7, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false) 

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus, 30,  daCenter, false, prefix+"ibflag" );
                 InitDataProperty(0, cnt++, dtCheckBox,     30,  daCenter, false, prefix+"del_chk");
                 InitDataProperty(0, cnt++, dtData,         80,  daCenter, false, prefix+"eq_no",          		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,         50,  daCenter, false, prefix+"eq_tpsz_cd",     		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,         80,  daCenter, false, prefix+"onh_dt",         		false, "", dfNone, 0, false, false);
                                                                                                                                  
                 InitDataProperty(0, cnt++, dtData,         80,  daCenter, false, prefix+"agmt",            	false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,         120, daCenter, false, prefix+"eq_spec_no",     		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,         80,  daCenter, false, prefix+"curr_cd",        		false, "", dfNone, 0, true,  true,3);
                 InitDataProperty(0, cnt++, dtData,         80,  daCenter, false, prefix+"act_amt",        		false, "", dfFloat,2, true,  true,7);
                 InitDataProperty(0, cnt++, dtData,         80,  daCenter, false, prefix+"invest_cd",      		false, "", dfNone, 0, true,  true,12);
                                                                                                                           
                 InitDataProperty(0, cnt++, dtData,         240, daCenter, false, prefix+"vndr_lgl_eng_nm",		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,         100, daCenter, false, prefix+"de_yrmon",       		false, "", dfNone, 0, false, false);
                 //InitDataProperty(0, cnt++, dtData,		100, daCenter, false, prefix+"Manufacturer", 		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,         100, daCenter, false, prefix+"fa_if_sts_cd",   		false, "", dfNone, 0, false, false);
                 
                 
                 //FNS026-0001 save연동데이터
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"lifid",					false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"seq",						false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"total_count",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"rnum",					false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"book_type_code",			false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"asset_description",		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"asset_type",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"category_segment",		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"cost",					false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"location_segment",		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"date_placed_in_service",	false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"tag_number",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"attribute1",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"attribute2",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"attribute3",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"attribute4",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"created_by",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"creation_date",			false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"last_updated_by",			false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"last_update_date",		false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"manufacturer",			false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"attribute21",				false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++,	dtHidden,		100, daCenter, true,  prefix+"acq_mth",					false, "", dfNone, 0, false, false);
                 
                 SelectionMode   = smSelectionFree;
                 InitDataValid(0, prefix+"curr_cd", vtEngUpOnly);
                 
            }
             break;

     }
 }

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) 
     {
         case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
         	if(validateForm(sheetObj,formObj,sAction)){
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);	         		
         		//prefix sheet1
         		//var sXml = sheetObj.GetSearchXml("EES_CGM_1146GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
         		var sXml = sheetObj.GetSearchXml("EES_CGM_1146GS.do" , FormQueryString(formObj))
		 		sheetObj.LoadSearchXml(sXml);
		 		for(i=1; i<sheetObj.rowCount+1; i++){
                	if(sheetObj.CellValue(i, prefix+"fa_if_sts_cd") == "Complete"){
                		sheetObj.CellEditable(i, prefix+"del_chk") = false;
                	} else {
                		sheetObj.CellEditable(i, prefix+"del_chk") = true;
                	}
                }
				
				ComOpenWait(false);			 		
          	}
            break;

		 case IBSAVE:        //저장
           	if(validateForm(sheetObj,formObj,sAction))
           	{
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);	
        		
           		for(i=1; i<=sheetObj.rowCount; i++){
    				if(sheetObj.CellValue(i, prefix+"del_chk")== "1" ) {
    					sheetObj.RowStatus(i) = "U";
    				}else{
    					sheetObj.RowStatus(i) = "R";
    				}
    			}
           		formObj.f_cmd.value = MULTI;
				var sParam = "";
				//var sParam1 = sheetObjects[0].GetSaveString(true);
				//sParam = sParam1 +  "&" + FormQueryString(formObj);
				sParam = FormQueryString(formObj);
				//if(sheetObj.DoSave("EES_CGM_1146GS.do", sParam + "&" + ComGetPrefixParam("sheet1_")))
				if(sheetObj.DoSave("EES_CGM_1146GS.do", sParam ))
				{
					//ok 
					// 뷰의 상태를 Send로 (전송성공)으로 보여준다. 
	  		 		/*
	  				var chkRows = sheetObj.FindCheckedRow("del_chk");
	  				var arrChkRows = chkRows.split("|");
	  				
	  				// 체크된 행만큼 루프를 돌면서 chss_pool_cdw 가  선택되지 않은 항목이 있으면 CGM10009 메시지 띄운다.
	  				var cellText;
	  				for(var k=0; k < arrChkRows.length-1; k++){
	  					sheetObj.CellValue2(arrChkRows[k], "fa_if_sts_cd") = "Send";
	  				}
	  				*/
					//그냥 공통적으로 reloading을 하는게 빠르지 않을까...
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					
				}else
				{
					//nok
					//그냥 공통적으로 reloading을 하는게 빠르지 않을까...
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
				
				ComOpenWait(false);	
           	}

           	break;
		    
      	  case IBSEARCH_ASYNC01:	// Term Code Combo 조회
 	       	formObj.f_cmd.value = SEARCH;
 	       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01863;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
 	   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
 	   			    			
 	   		var sStr = ComGetEtcData(sXml,"comboList");    			
 	   		var arrStr = sStr.split("@");

 	   		// combo control, 결과 문자열, Text Index, Code Index
 	  		MakeComboObject(formObj.fa_if_sts_cd, arrStr, 0, 0);
 	       	break;
 	       	
          case IBSEARCH_ASYNC11:
      	    formObj.f_cmd.value = SEARCH;
       		var sXml = sheetObj.GetSearchXml("EES_CGM_CURRENCYGS.do", FormQueryString(formObj));
      	    // 데이터 건수
      	    var dataCount = ComGetTotalRows(sXml);
      	    if(dataCount==0){
      	        ComShowCodeMessage('CGM10009','Currency');
      	        formObj.curr_cd.value = "";
      	        sheetObj.CellValue2(sheetObj.SelectRow,sheetObj.SelectCol) = "";
      	    }
      	    break;     
      	    
      	 case IBRESET:
    		var idx = 0
    		var sXml2 = document.form2.sXml.value;
    		var arrXml = sXml2.split("|$$|");

    		// Term Code 
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1 = new Array();
    		for ( var i = 0; i < vArrayListData.length; i++) {
    		    vListData = vArrayListData[i];
    		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
    		}
    		MakeComboObject(formObj.fa_if_sts_cd, arrStr1, 0, 0);    
    		formObj.fa_if_sts_cd.text = "ALL";
    		idx++;        		

    		break;      	    
     }
 }

 /**
  * 저장후 조회 호츨
  * @return
  */ 
 function sheet1_OnSaveEnd(sheetObj, errMsg) {
 	if(errMsg =='') {   
 		ComShowCodeMessage('CGM00003');
	}
 }  

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	  with(formObj){
    	  switch(sAction) {
			 	case IBSEARCH:
			 		 
			 		if(de_yrmon.value == ''){
	     				ComShowCodeMessage('CGM10004','Event Date ');
	     				formObj.de_yrmon.focus();
	     				
	     				return false;
	     			}	
			 		if(eq_no_fm.value == ''){
	     				ComShowCodeMessage('CGM10004','EQ. No ');
	     				formObj.eq_no_fm.focus();
	     				
	     				return false;
	     			}
			 		if(eq_no_to.value == ''){
	     				ComShowCodeMessage('CGM10004','EQ. No ');
	     				formObj.eq_no_to.focus();
	     				
	     				return false;
	     			}
	     			break;
	     			
			 	case IBSAVE:
			 		if(sheetObjects[0].CheckedRows(1) == 0)
			 		{
			 			return false;
			 		}else{
    	  				//Currency가 비어있으면 오류처리(추후 문제가 나오면처리예정)
    	  			
    	  				return true;
    	  			}
			 		break;
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
	 	case "ym":
	 		ComKeyOnlyNumber(obj);
	        break;
  	    case "engup":
	        if(obj.name == "eq_no_fm"){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
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
   
 	 if(obj.name=="de_yrmon"  ){
     			
 		 with(formObj){
        			
 			 var creDtFr = ComReplaceStr(de_yrmon.value,"-","");
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
    * Combo Object 초기화  <br>
    * @param  {object} comboObj	필수 Combo Object
    * @return 없음
    * @author 최민회
    * @version 2009.05.25
    */ 
   function initCombo(comboObj) {
    	switch(comboObj.id) {
 	       case "fa_if_sts_cd":
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
    	cmbObj.InsertItem(0, "ALL", "ALL");
    	cmbObj.InsertItem(1, "Not Interfaced", "Not Interfaced");
    	for (var i = 2; i < arrStr.length+2;i++ ) {
    		var arrCode = arrStr[i-2].split("|");
    		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
         	}
    	cmbObj.Index2 = "" ;
    }
         
 /**
  * Sheet1 의 cell을 edit 할 경우 <br>
  * @author 조재성
  * @version 2009.09.14
  */   
 function sheet1_OnChange(sheetObj, Row, Col)
 {
  	var formObj = document.form;
  	
  	//alert("test>>>>"+ Row + ":"+ Col + ": "+ sheetObj.RowCount);
  	if(Col == 7) // prefix+"curr_cd"
  	{
  		formObj.curr_cd.value = sheetObj.CellValue(Row,Col);
   		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC11);
  	}
 }       

 /** 
  * 기본조건 입력 후 ENTER키 적용 <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.09.10
  */ 
  function enterFire() {
   var formObj = document.form;
  
   if(formObj.eq_knd_cd.value != ''
	   && formObj.de_yrmon.value != ''
	   && formObj.eq_no_fm.value != ''
	   && formObj.eq_no_to.value != '')
   {
	   if(event.keyCode == 13)
		   ComKeyEnter('search');
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
   * @version 2009.09.23
   */ 
   function sheet1_OnMouseDown (Button, Shift, X, Y){
  	 var sheetObj = sheetObjects[0];
  	 var formObj = document.form;
  	
  	 /* 전체 자동 체크/해제 기능으로 대체함.
  	  * 수동 설정은 현재 지원안함. chungpa 20091007 1146 all check/uncheck support.  
  	 if(sheetObj.mouseRow == 0 && sheetObj.mouseCol == 1 )
  	 {
  		 if(chkFlag) // uncheck로.
  		 {
  			for(var i =1 ; i<= sheetObj.rowCount; i++)
  			{
  				//if(sheetObj.CellEditable(i, prefix+"del_chk")== true)
  				//
  			}
  		 }else	// check로.
  		 {
  			 
  		 }
  	 }*/
  	 
   }  
	/* 개발자 작업  끝 */