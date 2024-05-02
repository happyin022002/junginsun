/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1021.js
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.19 김창식
* 1.0 Creation
* ------------------------------------------------------------------------------------------------------------------------------
* 2014-02-24 Jonghee HAN Lease Agreement Term Code 내 ZP Code 삭제
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
     * @class ees_cgm_1021 : ees_cgm_1021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1021() {
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
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var IBSEARCH02 = 30;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             
    	var sheetObject1 = sheetObjects[0];
             
    	/*******************************************************/
    	var formObject = document.form;

    	try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	setEffFlag(formObject, srcName);	
        		
        	switch(srcName) {

    			case "btn_Retrieve":		// 조회 Action
    				if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
    					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				}
    				break;
    				
    			case "btn_New":
    				initControl();
    				break;

   				case "btn_VersionDetails":	// Version Detail
   					if(formObject.agmt_no.value != ''){
   						var param = "?agmt_no=" + formObject.agmt_no.value;
   						ComOpenPopup('/hanjin/EES_CGM_1022.do' + param, 900, 650, "", "1,0", true, false);
   					}
   					break;

   				case "btn_DownExcel":		// Excel Download
   					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
   					break;

   				case "btn_Print":			// Print (RD Open)
   					if( sheetObjects[0].rowcount==0 ) {
 						errMsg = 'No data found.';
 						ComShowMessage(msgs["CGM10012"]);
 						return;
 					}
 					formObject.f_cmd.value = IBSEARCH02;
 					ComOpenPopupWithTarget('/hanjin/EES_CGM_1023.do', 775, 800, "", "0,1,1,1,1,1,1", true);
   					break;
   					
   				case "ComOpenPopupWithTarget1":	// Office Code 가져오기 팝업
   					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:agmt_iss_ofc_cd", "1,0,1,1,1,1,1,1", true);
   					break;
    					
   				case "ComOpenPopupWithTarget2":	// Lessor Code, Name 가져오기 팝업
   					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "setProgramNo", "0,1,1,1,1,1", true, false);
   					break;
    					
    			case "btns_Calendar" :		// Agreement Date (From Date)
    				var cal = new ComCalendarFromTo();
    				cal.select(formObject.agmt_dt_fr,  formObject.agmt_dt_to,  'yyyy-MM-dd');
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
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function setSheetObject(sheetObj){

    	sheetObjects[sheetCnt++] = sheetObj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function loadPage() {
    	 
    	// axon event 등록
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerFormat('keydown', 'obj_keydown', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change', 'agmt_iss_ofc_cd'); 
        axon_event.addListener('change', 'obj_change', 'vndr_seq');  

    	// IBSheet 초기화
    	for(i=0;i<sheetObjects.length;i++){

    		//시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
                
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]); 
    	}
    	
    	// IBMultiCombo 초기화
    	comboObjects[comboCnt++] = document.agmt_lstm_cd;
    	for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }
    	
    	// Lease Term Combo Control에  초기값을  설정한다.
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    		
    	// Form Object 초기화 및  Control Value Reset 처리
        initControl();   
    }
    
    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function initControl(){
    	// Form 객체 선언
    	formObj = document.form;
    	sheetObj = sheetObjects[0];
    	
    	formObj.agmt_iss_ofc_cd.value = "";
    	formObj.agmt_dt_fr.value = "";
    	formObj.agmt_dt_to.value = "";
    	formObj.vndr_seq.value = "";
    	formObj.vndr_lgl_eng_nm.value = "";
    	
    	formObj.eff_flag_all.checked = true;
    	formObj.eff_flag_yes.checked = false;
    	formObj.eff_flag_no.checked  = false;
    	
    	// Multi Combo 초기화
    	document.agmt_lstm_cd.Text2 = "";
    	
    	// Sheet Object 초기화
    	sheetObj.RemoveAll();
        
        // 초기 focus
        formObj.agmt_iss_ofc_cd.focus();
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;

         switch(sheetNo) {
         	case 1:      // sheet1 init
         		with (sheetObj) {
         			// 높이 설정
                    style.height = 420;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Seq.|AGMT No.|Reference No.|Office|Date|Term|AGMT Effective|Lessor|Lessor Name|Created By|Created Date|Updated By|Updated Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"Status");
                        
    				InitDataProperty(0, cnt++ , dtDataSeq,	30,	 daCenter,	false,	"seq");
    				InitDataProperty(0, cnt++ ,    dtData,	90,	 daCenter,	false,	"agmt_no",			false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	100, daCenter,	false,	"agmt_ref_no",		false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	60,  daCenter,	false,	"agmt_iss_ofc_cd",	false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	80,	 daCenter,	false,	"agmt_dt",			false,	"",	dfNone, 0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	50,	 daCenter,	false,	"agmt_lstm_cd",		false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	150, daCenter,	false,	"effective_date",	false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	70,	 daCenter,	false,	"vndr_seq",			false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	260, daLeft,	false,	"vndr_lgl_eng_nm",	false,	"",	dfNone,	0, false, true);
    				
    				InitDataProperty(0, cnt++ ,    dtData,	90,	 daCenter,	false,	"cre_usr_id",		false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	90,	 daCenter,	false,	"cre_dt",			false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	80,	 daCenter,	false,	"upd_usr_id",		false,	"",	dfNone,	0, false, true);
    				InitDataProperty(0, cnt++ ,    dtData,	70,	 daCenter,	false,	"upd_dt",			false,	"",	dfNone,	0, false, true);
    				
    				//마스크 설정하기
    				//sheetObj.InitUserFormat(0, "agmt_dt", "####-##-##", "-" );

         		} // End With(Object)
                    
         		break;
         } // End Switch
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
    	 switch(sAction) {
    	 
    	 	case IBSEARCH:      	// Retrive
    	 		formObj.f_cmd.value = SEARCH;
    	 		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;	// EQ TYPE 을 CHASSIS 로 설정
        	    sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
               	sheetObj.DoSearch("EES_CGM_1021GS.do",FormQueryString(formObj));
                ComOpenWait(false);
               	break;
               		
            case IBSEARCH_ASYNC01:	// Term Code Combo 조회
            		
            	formObj.f_cmd.value = SEARCH;
            	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
        		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
        			    			
        		var sStr = ComGetEtcData(sXml,"comboList");    			
        		var arrStr = sStr.split("@");
        			
        		// combo control, 결과 문자열, Text Index, Code Index
       			MakeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0);
            	break;
            
            case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
            	formObj.f_cmd.value = COMMAND01;
            	formObj.ofc_cd.value = formObj.agmt_iss_ofc_cd.value;
            	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj), '', true);
            	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
            	
            	if(sCheckResult == COM_VALIDATION_FALSE){            		
            		return false;
            	} else {
            		return true;
            	}
            	
            	break;
            	
            case IBSEARCH_ASYNC03:	// Vendor Code,Name 조회
            	formObj.f_cmd.value = SEARCH07;
            	var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
            	var text = ComGetEtcData(sXml,"text");
            	
            	formObj.vndr_lgl_eng_nm.value = text;
            	break;
            
            case RDPRINT:      		// Print
                  
            	break;

            case IBDOWNEXCEL:     	// 엑셀 다운로드

            	sheetObj.SpeedDown2Excel(1,false,true,"","",false,false,"");

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
    	 			//2014-02-24 Jonghee HAN Lease Agreement Term Code 내 ZP Code 삭제
    	 		    vListData = vArrayListData[i];
    	 		    if( vListData["code1"] != 'ZP'){
    	 		    	arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
    	 		    }
    	 		}
    	 		// combo control, 결과 문자열, Text Index, Code Index
    		  	MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0);     
    	 		idx++;       
    	 		
    	 		 
    	  	  	
    	 		break;
    	 }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.05.20
     */      
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 switch(sAction) {
    		 	case IBSEARCH:
//    		 		if(agmt_iss_ofc_cd.value == ''){
//           				ComShowCodeMessage('CGM10004','Office');
//           				ComSetFocus(agmt_iss_ofc_cd);
//           				return false;
//           			}	
           			break;
    		 }      
    	 }

         return true;
    }
     
    /**
     * programNo 입력부분. <br>
     * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */   
    function setProgramNo(aryPopupData, row, col, sheetIdx){
    	 
    	 var formObj = document.form;
    	 var vndrSeq = "";
    	 var vndrNm = "";
    	 var i = 0;
    	 
    	 for(i = 0; i < aryPopupData.length; i++){
    		 vndrSeq = vndrSeq + aryPopupData[i][2];
    		 
    		 if(aryPopupData.length == 1){
    			 vndrNm = vndrNm + aryPopupData[i][4];
    		 }
    		 
    		 if(i < aryPopupData.length - 1){
    			 vndrSeq = vndrSeq + ",";
    		 }
    	 }
    	 
    	 formObj.vndr_seq.value = vndrSeq;
    	 formObj.vndr_lgl_eng_nm.value = vndrNm;
    }
     
    /** 
     * Effective Option 버튼 처리  <br>
     * @param  {object} formObj	필수 Form Object
     * @param  {String} srcName	필수 document 내의 객체명
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */ 
    function setEffFlag(FormObj, srcName){

    	 switch(srcName) {
	     	case "eff_flag_yes" :      
	     		FormObj.eff_flag_yes.checked=true;
    			FormObj.eff_flag_no.checked=false;
    			FormObj.eff_flag_all.checked=false;
    			FormObj.eff_flag.value="Y";
	            break;
	
	     	case "eff_flag_no" :        
	     		FormObj.eff_flag_yes.checked=false;
	     		FormObj.eff_flag_no.checked=true;
	     		FormObj.eff_flag_all.checked=false;
	     		FormObj.eff_flag.value="N";
	     		break;
	
	 		case "eff_flag_all" :      
	 			FormObj.eff_flag_yes.checked=false;
	    		FormObj.eff_flag_no.checked=false;
	    		FormObj.eff_flag_all.checked=true;
	    		FormObj.eff_flag.value="";
	    		break;
	    }	
    }
     
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */ 
    function obj_keypress(){
    	 obj = event.srcElement;
    	 if(obj.dataformat == null) return;
    	 	
    	 window.defaultStatus = obj.dataformat;
    	 
    	 switch(obj.dataformat) {
    	 	case "ym": case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	 		break;
    	 	case "num":
    	 		if(obj.name=="vndr_seq"){
    	    		ComKeyOnlyNumber(obj,",");
    	    	} else {
    	    		ComKeyOnlyNumber(obj);
    	    	}
    	        break;
    	    case "eng":
    	        ComKeyOnlyAlphabet(); 
    	        break;
    	    case "engup":
    	        if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    case "engdn":
    	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
    	        else ComKeyOnlyAlphabet('lower');
    	        break;
    	 }
    	 
    	 
    }
      
    /** 
     * Object 의 Keydown 이벤트에 대한 처리  <br>
     * enter 키 발생시 조회실행.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */ 
    function obj_keydown(){
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	
    	var keyValue = null;
    	if(event == undefined || event == null) {
    		keyValue = 13;
    	} else {
    		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		}
    	
		if(keyValue != 13) return;
		
		obj = event.srcElement;
		switch(obj.name){
			case "agmt_iss_ofc_cd":
				if(formObj.agmt_iss_ofc_cd.value != ''){
    	 			if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02)){
                		formObj.agmt_iss_ofc_cd.value = "";
                		ComSetFocus(formObj.agmt_iss_ofc_cd);
                		return;
    	 			} else {	
    	 				ComKeyEnter();
    	 				return;
    	 			}
    	 		}
				break;

			default:
				ComKeyEnter();
				return;
		}
    }
      
    /** 
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function obj_activate(){
    	ComClearSeparator(event.srcElement);
    }
     
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function obj_deactivate(){
    	 var formObj = document.form;
    	 obj = event.srcElement;      	
    	 
    	 with(formObj){
    		 if(obj.name=="agmt_dt_fr" || obj.name=="agmt_dt_to"){
    			 var creDtFr = ComReplaceStr(agmt_dt_fr.value,"-","");
    			 var creDtTo = ComReplaceStr(agmt_dt_to.value,"-","");
	        	
    			 switch(obj.name) {
	    	    	case "agmt_dt_fr":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				agmt_dt_fr.value='';
	    	    				agmt_dt_fr.focus();
	    	    			}
	    	    		}
	    	    			
	    	            break;
	    	            
	    	    	case "agmt_dt_to":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				agmt_dt_to.value='';
	    	    				agmt_dt_to.focus();
	    	    			}
	    	    		}
	    	           	break;	
	        	}
	        
    			ComChkObjValid(event.srcElement);
    		 }
        }
        	
    }
    
    /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */  
    function obj_change(){ 	 
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 
    	 obj = event.srcElement;
    	 switch(obj.name){
    	 	case "agmt_iss_ofc_cd":
    	 		if(formObj.agmt_iss_ofc_cd.value != ''){
    	 			if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02)){
    	 				ComShowCodeMessage('CGM10009','Office');
                		formObj.agmt_iss_ofc_cd.value = "";
                		ComSetFocus(formObj.agmt_iss_ofc_cd);
    	 			}
    	 		}
    	 		break;
    	 		
    	 	case "vndr_seq":
    	 		
    	 		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
    	 		
    	 		if(vndrSeq != ''){
	    	 		var arrVndrSeq = vndrSeq.split(",");
	    	 		
	    	 		if(arrVndrSeq.length == 1){
	    	 			// vndr_seq 에 하나의 Lessor Code 만 들어올 경우  Lessor 명칭을 취득
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	 		} else {	
		    	 		for(var i = 0; i < arrVndrSeq.length; i++){
		    	 			// 입력오류 체크 (예> ,,)
		    	 			if(arrVndrSeq[i] == ''){
		    	 				ComShowCodeMessage('CGM10009','Lessor');
		    	 				formObj.vndr_seq.value = "";
		    	 				formObj.vndr_lgl_eng_nm.value = "";
		    	 				ComSetFocus(formObj.vndr_seq);
		    	 				break;
		    	 			} else {
		    	 				// vndr_seq 입력 텍스트 입력 오류가 아니더라도 
		    	 				// vndr_seq 가 변경되면 Lessorr 명칭을 삭제
		    	 				formObj.vndr_lgl_eng_nm.value = "";
		    	 			}
		    	 		}
	    	 		}
    	 		} else {
    	 			// vndr_seq 입력 텍스트에서 삭제할 경우 Lessor 명칭을 삭제
    	 			formObj.vndr_lgl_eng_nm.value = "";
    	 		}
    	 		
    	 		break;
    	 
    	 }
    }
    
    /**
     * Sheet1 의 검색완료 후 데이터가 존재하면 첫번째 Row의 Agreement No를  <br>
     * Hidden Column 에 저장	<br>
     * @author 김창식
     * @version 2009.08.14
     */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	if(sheetObj.RowCount > 0){
    		document.form.agmt_no.value = sheetObj.cellValue(1,"agmt_no");
    	}
    }
     
    /**
     * Sheet1 의 Click 할 경우 선택 Agreement No를 Hidden Column 에 저장 <br>
     * @author 김창식
     * @version 2009.08.14
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
    	document.form.agmt_no.value = sheetObj.cellValue(Row,"agmt_no");
    }
    
    /**
     * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
     * @author 김창식
     * @version 2009.08.14
     */      
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	
    	var colSaveName = sheetObj.ColSaveName(Col);
    	
    	if(colSaveName == 'agmt_no') {
    		
    		var param = "?agmt_no=" + sheetObj.cellValue(Row,"agmt_no");
    		
    		ComOpenPopup('/hanjin/EES_CGM_1022.do' + param, 900, 650, "", "1,0", true, false);
    	}
    }
    
    /** 
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 김창식
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
  	            	comboObj.UseAutoComplete = true;
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
     * @author 김창식
     * @version 2009.05.20
     */ 
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
    	cmbObj.InsertItem(0,"","");
    	for (var i = 0; i < arrStr.length;i++ ) {
    		var arrCode = arrStr[i].split("|");
    		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
    	}
    	cmbObj.Index2 = "" ;
    }
 
	/* 개발자 작업  끝 */