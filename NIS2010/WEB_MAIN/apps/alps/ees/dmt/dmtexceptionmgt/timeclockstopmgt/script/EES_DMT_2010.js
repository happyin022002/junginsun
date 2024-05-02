/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2010.js
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class EES_DMT_2010 : EES_DMT_2010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2010() {
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
 
    var comboObjects = new Array();
    var comboCnt = 0;
	
    var COMMON_TARIFF_CD = "common_tariff_cd"; 
    var ROWMARK = "|";
    var FIELDMARK = "=";

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
     		var srcObj = window.event.srcElement;

 				switch(srcName) {
						case "btns_calendar": //달력 버튼
				            if(srcObj.style.cursor == "hand") {
					            var cal = new ComCalendarFromTo();
					            cal.select(formObject.clk_stop_fm_dt,  formObject.clk_stop_to_dt,  'yyyy-MM-dd');
				         	}
							break;	
							
 						case "btn_Retrieve":
 							
 							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    						break;
 						
 						case "btn_New":
 							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
 							break;
 							
 						case "btn_Save":
 							doActionIBSheet(sheetObject1,formObject,IBSAVE);
    						break;
 						
 						case "btn_Cancel":
 							doActionIBSheet(sheetObject1,formObject,IBDELETE);
    						break;
 							
 						case "btn_Print":
 							window.print();
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
			initSheet(sheetObjects[i],i+1);
		}
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		
		//html컨트롤 이벤트초기화
		initControl();
		
		//EES_DMT_2011 화면에서 팝업 호출일 경우에 바로 조회
//		var formObject = document.form;
//		var popupVal = formObject.popup.value;  // 팝업 호출 상태인지 호출:Y
//		var popupVal2 = formObject.clk_stop_no.value;
//		if(popupVal == 'Y' && popupVal2 != ''){
//			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
//		}
		var formObj = document.form;
 		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC01,	comboObjects[0]);
 		doActionIBCombo(sheetObjects[0], formObj, IBROWSEARCH,		comboObjects[1]);
 		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC02,	comboObjects[2]);
 		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03,	comboObjects[3]);
 		
 		
 		//조회한 날짜를 화면의 필드에 매핑 시킨다.
		ComSetObjValue(formObj.upd_dt, 	DmtComOfficeCurrDate(sheetObjects[0], formObj)); 
		
 		//BUTTON MODE
 		DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  						//2010.04.09
 		DmtComEnableManyBtns(false, "btn_Cancel");  //2010.04.09
 	}
      
	function initControl() {
		axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',	'obj_activate',    form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress',    document.form); //- 키보드 입력할때
		axon_event.addListener('click', 'obj_click', 'cond_type'); 
		axon_event.addListener      ("focusout", "obj_focusout","clk_stop_fm_dt", "clk_stop_to_dt");
	}
	
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		var obj = event.srcElement;
		var days = getDaysBetween();
		formObj.stop_days.value = days;
	}
	/**
	 * 날짜 차이 값 가져오기
	 */
	function getDaysBetween(){
		var formObj = document.form;
		var days = "";
		if((formObj.clk_stop_fm_dt.value == "") || (formObj.clk_stop_to_dt.value == "")){
			return days;
		} else {
				days = ComGetDaysBetween(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value);
			if(days >= 0) {
				return days+1;
			} else {
				return "";
			}
		}
	}		
	
    function obj_click() {
    	 doEnableCondObj(event.srcElement.value);
    } 
     	

    //포커스가 나갈 때
    function obj_deactivate(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
	   	 switch(event.srcElement.dataformat){
	        	case "engup":
					// 영문대+숫자 
					ComKeyOnlyAlphabet('uppernum', ',');
					break;
	          	case "engup2":
	 		    	// 영문대+숫자+예외문자
	          		DmtComKeyOnlyAlphabet('uppernum', ',');
	 		        break;
	          	case "engup3":
	          		//영문입력시에는 대문자로 변환
	          		DmtComKeyOnlyAlphabet('upperall')
	          		break; 		        
	          	case "int":
	     	        //숫자 만입력하기
	     	        ComKeyOnlyNumber(event.srcElement);
	     	        break;
	          	default:
	 	         	// 숫자만입력하기(정수,날짜,시간)
	 	            ComKeyOnlyNumber(event.srcElement);
	   	 }
    }	
	function getTodate() {
		var today = new Date();
		var year = today.getYear();
		var month = today.getMonth() + 1;
		var day = today.getDate();
		if (month < 10) {
			month = "0" + month;
		}
		if (day < 10) {
			day = "0" + day;
		}
		var currDate = year + "-" + month + "-" + day;// 현재 날짜 생성
		return currDate;
	}
	
	
    /** 
  	 * IBCombo Object를 배열로 등록
  	 * param : combo_obj ==> 콤보오브젝트
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */ 
  	function setComboObject(combo_obj) {  
  	    comboObjects[comboCnt++] = combo_obj;  
  	} 
  	
  	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObject = document.form
  		
  	    switch(comboNo) {  
  	          case 1: 
  	        	with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					SetColAlign("left|left");   
					SetColWidth("50|300");				
					FontName = "Tahoma";
					DropHeight = 160;
					ValidChar(2, 2);	// 영어대문자 사용
  		    	}
  	        	
  	        	//doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
  	        	break;
  	          case 2: 
  	           with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					SetColAlign("left|left"); 
					SetColWidth("60|300");
					FontName = "Tahoma";
					DropHeight = 160;
					ValidChar(2, 2);	// 영어대문자 사용
  		    	}
  				//doActionIBCombo(sheetObjects[0],formObject,IBROWSEARCH,comboObj);
  				break; 
  				
  	          case 3: 
  	  	           with (comboObj) { 
  						MultiSelect = true; 
  						UseAutoComplete = false;
  						SetColAlign("left|left"); 
  						SetColWidth("65|295");
  						FontName = "Tahoma";
  						DropHeight = 160;
  						ValidChar(2, 3);	// 영어대문자,숫자, 콤마(.) 사용
  	  		    	}
  	  				break; 
  	          case 4: 
 	  	           with (comboObj) { 
 						MultiSelect = true; 
 						UseAutoComplete = false;
 						SetColAlign("left|left"); 
 						SetColWidth("35|80");
 						FontName = "Tahoma";
 						DropHeight = 160;
 						ValidChar(2, 3);	// 영어대문자,숫자, 콤마(.) 사용
 	  		    	}
 	  				break; 		
  	     } 
  	}

     //쉬트 로드 후에 콤보리스트 콜. 깜빡임 방지 방안
//   	function sheet1_OnLoadFinish() {
// 		var formObj = document.form
// 		sheetObjects[0].WaitImageVisible = false;   
//
// 		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC01,	comboObjects[0]);
// 		doActionIBCombo(sheetObjects[0], formObj, IBROWSEARCH,		comboObjects[1]);
//
//       	sheetObjects[0].WaitImageVisible = true;   
//       	
// 	}        	 

  	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
        switch(sAction) {

		        case IBSEARCH_ASYNC01:     
			 		//1. Tariff type comboList
					formObj.f_cmd.value = SEARCHLIST;
					var xmlStr = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
					var data = ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
					if (data != undefined && data != '') {
						var comboItems = data.split(ROWMARK);
						addComboItem(sComboObj,comboItems);
						comboItem = comboItems[0].split(FIELDMARK);
					}	
			 		
							
				break;	
					
		        case IBROWSEARCH:    
					//2. Office comboList
					formObj.f_cmd.value = SEARCHLIST02;
		    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		    	    if (sXml != undefined && sXml != '') {
			    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
			    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");

			    	    var comboCodeArr = ofc_cds.split("|");			    	    
			    	    var comboTextArr = ofc_nms.split("|");
			    	    var comboObj = comboObjects[1];
			    	   
			    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
		    	    }
		    	   
				break;
				
		        case IBSEARCH_ASYNC02:
		        	//3. Office 별 yard comboList
					formObj.f_cmd.value = SEARCH03;
					formObj.clk_stop_ofc_cd.value 	= comboObjects[1].Text;
					var sXml = sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
					if (sXml != undefined && sXml != '') {
			    	    var yard_cds = ComGetEtcData(sXml, "YARD_CD");
			    	    var yard_nms = ComGetEtcData(sXml, "YARD_NM");
			    	    
			    	    if(yard_cds != undefined && yard_cds != '') {
			    	    	comboObjects[2].Code="-1";
                            comboObjects[2].RemoveAll();
				    	    var comboCodeArr = yard_cds.split("|");			    	    
				    	    var comboTextArr = yard_nms.split("|");
				    	    var comboObj = comboObjects[2];
				    	    
				    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
				    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
				         	}
			    	    }
					}
					break;
					
		        case IBSEARCH_ASYNC03:
		        	//4. term comboList  I/B: CD02191 , O/B:CD02192
					formObj.f_cmd.value = SEARCH15;
					 var dmdt_trf_cd 	= comboObjects[0].Text;
					 if (dmdt_trf_cd.substring(2,3)== "I"){
						 formObj.intg_cd_id.value = "CD02191";
					 }else{
					     formObj.intg_cd_id.value = "CD02192";
					 }
					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
					if (sXml != undefined && sXml != '') {
						var term_cd =ComGetEtcData(sXml, "COMMON_CD");
					if (term_cd != undefined && term_cd != '') {
                              comboObjects[3].RemoveAll();
				    	    var combo_cd = term_cd.split("|");	
				    	    comboObjects[3].InsertItem(0, "All" + "|" + "", "All");
				    	    for (var i =0 ; i < combo_cd.length ; i++) {
				    	      var combo_text = combo_cd[i].split("=");
				    	    	comboObjects[3].InsertItem(i+1, combo_text[0] + "|" + combo_text[1], combo_text[0]);		
				         	}
			    	    }
					}
					break;
        }
		sheetObj.WaitImageVisible = true;
    }
	

	
    /**
    * 콤보필드에 데이터를 추가해준다.
    */	
	function addComboItem(comboObj,comboItems) {
	   	for (var i = 0 ; i < comboItems.length ; i++) {
	   		var comboItem = comboItems[i].split(FIELDMARK);
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
	   	}   		
	}

	/**
	 * onchange 시에 tariff코드의 상세 정보를 변경해서 보여주는 함수 <br>
	 * @param 없음
	 * @return 없음
	 * @see #링크연결
	 * @author 최성환
	 * @version 2009.04.28
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var textValue = comboObj.GetText(Index_Code, 1);
		document.form.dmdt_trf_nm.value = textValue;
		
		//combo3 초기화
		document.form.dmdt_bkg_term_ctnt.value = "";
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03,	comboObjects[3]);

	} 
	 
	/**
	 * onchange 시에 office코드의 상세 정보를 변경해서 보여주는 함수 <br>
	 * @param 없음
	 * @return 없음
	 * @see #링크연결
	 * @author 최성환
	 * @version 2009.04.28
	 */
	function combo2_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var textValue = comboObj.GetText(Index_Code, 1);
		document.form.clk_stop_ofc_nm.value = textValue;
		
		//combo3 초기화
		document.form.clk_stop_yd_nm.value = "";
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC02,	comboObjects[2]);
	}	 
	 
    function combo3_OnCheckClick(comboObj, index, code) {
	    setMultiCombo(comboObj, index, code) ;
	    //All 선택
	    if(index==0) {
	    	document.form.all_yd_flg.value = "Y";
	    }else{
	    	document.form.all_yd_flg.value = "N";
	    }
		//TEXT 필드 값 보여주기
		document.form.clk_stop_yd_nm.value = comboObj.Code;
		

    }
    
    function combo4_OnCheckClick(comboObj, index, code) {
	    setMultiCombo(comboObj, index, code) ;
	    if (comboObj.Code.substr(0,3) == "All"){
	       document.form.dmdt_bkg_term_ctnt.value = comboObj.Code.substr(4,20);
	    }else {
	    	document.form.dmdt_bkg_term_ctnt.value = comboObj.Code
	    }
	    	
    }
	
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

		 var sheetID = sheetObj.id;

         switch(sheetID) {

             case "sheet1":
                 with (sheetObj) {
                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 				}
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
    	 switch(sAction) {
			
    	 	case IBSEARCH:     
    	 		
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
    	 		//2010.04.14.clock stop no의 ofc_cd의 rhq_ofc_cd 와 session rhq_ofc_cd와 동일 한지 CHECK 
    	 		var sRhqOfcCd = formObj.rhq_ofc_cd.value;
    	 		//sRhqOfcCd 가 SELHO 일 경우 체크 로직 수행 안함. 
    	 		if(sRhqOfcCd != 'SELHO'){
    	 			formObj.f_cmd.value = COMMAND19;
    				var xmlStr = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    				if(sRhqOfcCd != ComGetEtcData(xmlStr, "RHQ_OFC_CD")){
    					ComShowCodeMessage('DMT06001');
    					return ; 
    				}
    	 		} 
    	 		
				
				
				formObj.f_cmd.value = SEARCH01;
				var xmlStr = sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
				if(undefined != ComGetEtcData(xmlStr, "clk_stop_no")){
					initSearchControls("SEARCH");
					searchSetting(xmlStr);
					
					buttonMode("IBSEARCH"); 
					
					//button mode - 2010.04.09
					var cxl_flg = formObj.cxl_flg.value;
					if(cxl_flg == 'Live'){
						DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Cancel");  								
						DmtComEnableManyBtns(false, "btn_Save");  
					} else if(cxl_flg == 'Cancelled'){
						DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New");  								
						DmtComEnableManyBtns(false, "btn_Save", "btn_Cancel");  
					} 
					
				} else {
					initSearchControls("SEARCH");
					ComShowCodeMessage("DMT06001");
				}
				
			break;
						
			case IBCLEAR:       //초기화 
				initSearchControls("CLEAR");
				buttonMode("IBCLEAR");
				
				//button mode - 2010.04.09
				DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
				DmtComEnableManyBtns(false, "btn_Cancel");  
				
				//조회한 날짜를 화면의 필드에 매핑 시킨다.
				ComSetObjValue(formObj.upd_dt, 	DmtComOfficeCurrDate(sheetObjects[0], formObj)); 
				
			break;

			case IBSAVE:   
				//NEW 버튼 클릭 및 페이지 오픈시만 저장 가능..
				if(formObj.button_mode.value == 'IBCLEAR' || formObj.button_mode.value == ''){
					//COMBO 내용을 html object로 전달 후 저장하기
					formObj.dmdt_trf_cd.value 		= comboObjects[0].Text;
					formObj.clk_stop_ofc_cd.value 	= comboObjects[1].Text;
					formObj.clk_stop_yd_cd.value 	= comboObjects[2].Text;
					
				   if (comboObjects[3].Text.substr(0,3) == "All"){
					   formObj.dmdt_bkg_term_ctnt.value = comboObjects[3].Text.substr(4,20);
				    }else {
				    	formObj.dmdt_bkg_term_ctnt.value = comboObjects[3].Text;
				    }			
					
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					if(!validateDate(formObj)){
						return false;
					}
					if(!validateLength(formObj)){
						return false;
					}
					
					if(!ComShowCodeConfirm('DMT00135', 'save')){
						return false;
					}
						
					//Back End Job으로 처리
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					formObj.f_cmd.value = COMMAND01;
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")
					
					if (backendJobKey.length > 0) {
						formObj.backendjob_key.value = backendJobKey;
						sheetObj.WaitImageVisible = false;
						sheetObj.RequestTimeOut = 10000;
						timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
					}
					
				}
				
				//button mode - 2010.04.09
				DmtComEnableManyBtns(true,  "btn_New", "btn_Retrieve", "btn_Cancel" );  								
				DmtComEnableManyBtns(false,  "btn_Save"); 
				ComEnableManyObjects(false, formObj.clk_stop_no);
				formObj.clk_stop_no.className 	 = 'input1'; //2010.04.15.
				
			break;

			case IBDELETE:      
				if(formObj.auth_yn.value == 'Y'){ //권한이 있을 경우만 삭제가능. 
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					//formObj.f_cmd.value = MULTI02;	
					var cxl_flg = formObj.cxl_flg.value;
					if(cxl_flg == 'Live'){
						if(!ComShowCodeConfirm('DMT00135', 'cancel')){
							return false;
						}
						
						//sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
						//Back End Job으로 처리
						ComOpenWait(true);
						sheetObj.WaitImageVisible = false;
						formObj.f_cmd.value = COMMAND11;
						var sXml = sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
						var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")

						if (backendJobKey.length > 0) {
							formObj.backendjob_key.value = backendJobKey;
							sheetObj.WaitImageVisible = false;
							sheetObj.RequestTimeOut = 10000;
							timer = setInterval(getCancelBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}
						
						//처리 완료 후 재 해당 내용 조회
						//doActionIBSheet(sheetObj,formObj,IBSEARCH);		
						//buttonMode("IBSEARCH");
					} else {
						ComShowCodeMessage('DMT00106');
					}
				} else {
					ComShowCodeMessage('DMT00112');
				}
				
				//button mode - 2010.04.09
				DmtComEnableManyBtns(true,  "btn_New" , "btn_Retrieve");  								
				DmtComEnableManyBtns(false, "btn_Save", "btn_Cancel"); 
				ComEnableManyObjects(false, formObj.clk_stop_no);
				formObj.clk_stop_no.className 	 = 'input1'; //2010.04.15.
				
			break;
			
		}
     }

     /// BACK END JOB Create Start ////////////////////////////////////////////
     /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     */
    function getBackEndJobStatus() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
       	formObj.f_cmd.value = COMMAND02; //It gets a status of backendjob. 2
       	sheetObjects[0].WaitImageVisible = false;
      	var sXml = sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
       	var jobState = ComGetEtcData(sXml, "jb_sts_flg")
       	// alert("sheet1 :::>> jobState : "+jobState);

       	if (jobState == "3") {
       		clearInterval(timer);
       		
       		getBackEndJobLoadFile();
       	} else if (jobState == "4") {
       		// BackEndJob을 실패 하였습니다.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
			DmtComEnableManyBtns(false, "btn_Cancel");
       	} else if (jobState == "5") {
       		// 이미 BackEndJob 결과 파일을 읽었습니다.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
			DmtComEnableManyBtns(false, "btn_Cancel");
       	}
     }

     function getBackEndJobLoadFile() {
    	 formObj = document.form;
    	 formObj.f_cmd.value = MULTI01; //It returns a result. 3 
    	 ComOpenWait(false);
    	 var sheetObj = sheetObjects[0];
    	 
    	 //ComOpenWait Start
		 sheetObj.WaitImageVisible=false;
	     ComOpenWait(true);
    	 
    	 var sXml = sheetObj.GetSearchXml ("EES_DMT_2010GS.do", FormQueryString(formObj));
    	 
    	 //ComOpenWait End
		 ComOpenWait(false);
			
    	 if("Y" != ComGetEtcData(sXml, "dup_yn")){
    		 searchSetting(sXml);
    	 } else {
    		 ComShowCodeMessage("DMT00105");
    		 //PERIOD OVERLAPPED DATA EXISTS!발생시에 버튼 상태.
    		 DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
 			 DmtComEnableManyBtns(false, "btn_Cancel");
    	 }   	
     } 
      
     /// BACK END JOB Create End ////////////////////////////////////////////  
      
     /// BACK END JOB Cancel Start ////////////////////////////////////////////
      /**
      * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
      */
     function getCancelBackEndJobStatus() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
       	formObj.f_cmd.value = COMMAND22; //It gets a status of backendjob. 2
       	sheetObjects[0].WaitImageVisible = false;
      	var sXml = sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
       	var jobState = ComGetEtcData(sXml, "jb_sts_flg")
       	// alert("sheet1 :::>> jobState : "+jobState);

       	if (jobState == "3") {
       		clearInterval(timer);
       		getCancelBackEndJobLoadFile();
       	} else if (jobState == "4") {
       		// BackEndJob을 실패 하였습니다.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New");  								
			DmtComEnableManyBtns(false, "btn_Cancel", "btn_Save");
       	} else if (jobState == "5") {
       		// 이미 BackEndJob 결과 파일을 읽었습니다.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New");  								
			DmtComEnableManyBtns(false, "btn_Cancel", "btn_Save");
       	}
      }

      function getCancelBackEndJobLoadFile() {
    	  formObj = document.form;
    	  formObj.f_cmd.value = MULTI02; //It returns a result. 3 
    	  ComOpenWait(false);
    	  var sheetObj = sheetObjects[0];
    	  //ComOpenWait Start
 		  sheetObj.WaitImageVisible=false;
 	      ComOpenWait(true);
 	      
    	  var sXml = sheetObj.GetSearchXml ("EES_DMT_2010GS.do", FormQueryString(formObj));
    	  
    	  //ComOpenWait End
 		  ComOpenWait(false);
 		 
    	  if("Y" == ComGetEtcData(sXml, "cxl_flg")){
    	 	  //처리 완료 후 재 해당 내용 조회
    		  doActionIBSheet(sheetObj,formObj,IBSEARCH);		
    		  buttonMode("IBSEARCH");
    	  }
      }   
      
      /// BACK END JOB Cancel End ////////////////////////////////////////////  
      
      
	/**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	function validateForm(sheetObj,formObj,sAction){
		if(IBSEARCH == sAction || IBDELETE == sAction){
		    if(formObj.clk_stop_no.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Clock Stop No");
				ComSetFocus(formObj.clk_stop_no);
				return false;
			}
		} else if(IBSAVE == sAction ){
			if(formObj.dmdt_trf_cd.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Tariff Type");
				ComSetFocus(formObj.dmdt_trf_cd);
				return false;
			} else if(formObj.clk_stop_ofc_cd.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Office");
				ComSetFocus(formObj.clk_stop_ofc_cd);
				return false;
			} else if(formObj.clk_stop_yd_cd.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Yard");
				ComSetFocus(formObj.clk_stop_yd_cd);
				return false;
			} else if(formObj.clk_stop_fm_dt.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Stop Period");
				ComSetFocus(formObj.clk_stop_fm_dt);
				return false;
			} else if(formObj.clk_stop_to_dt.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Stop Period");
				ComSetFocus(formObj.clk_stop_to_dt);
				return false;
			} else if(formObj.clk_stop_rmk.value.trimAll().lengthByte() <= 0){
				ComShowCodeMessage('DMT02002', "Remark");
				ComSetFocus(formObj.clk_stop_rmk);
				return false;
			}
		}
		return true;
	}

	/**
	  * 날짜값의 유효성검증 프로세스 처리
	  */
	function validateDate(formObj){
		if(ComChkPeriod(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value) > 0){
			if(ComGetDaysBetween(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value) > 21){
				ComShowCodeMessage('DMT00103');
				return false;
			}
		} else if (ComChkPeriod(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
		return true;
	}
	  
	/**
	  * 문자길이의 유효성검증 프로세스 처리
	  */
	function validateLength(formObj){
		if(formObj.clk_stop_rmk.value.trimAll().lengthByte() > 501){
			ComShowCodeMessage('DMT00104');
			ComSetFocus(formObj.clk_stop_rmk);
			return false
		}
		return true;
	} 
	  
	/**
	  * INIT SETTING
	  */
	function initSearchControls(flag) {
		var formObj = document.form;
		if(flag == 'CLEAR'){  
			ComClearObject(formObj.clk_stop_no);
	    	comboObjects[2].Code="-1";
            comboObjects[2].RemoveAll();
		}
		ComClearObject(formObj.cxl_flg);
		ComClearObject(formObj.dmdt_trf_cd);
		comboObjects[0].Text = "";
		ComClearObject(formObj.dmdt_trf_nm);
		ComClearObject(formObj.clk_stop_ofc_cd);
		comboObjects[1].Text = "";
		ComClearObject(formObj.clk_stop_ofc_nm);
		ComClearObject(formObj.clk_stop_yd_cd);
		comboObjects[2].Text = "";
		ComClearObject(formObj.clk_stop_yd_nm);
		ComClearObject(formObj.all_yd_flg);
		ComClearObject(formObj.clk_stop_fm_dt);
		ComClearObject(formObj.clk_stop_to_dt);
		ComClearObject(formObj.stop_days);
		formObj.upd_usr_id.value = formObj.s_usr_nm.value;
		formObj.upd_ofc_cd.value = formObj.s_ofc_cd.value;
		formObj.upd_dt.value = formObj.s_cre_dt.value;
		formObj.clk_stop_rmk.value = "";
		comboObjects[3].Text = "";
		ComClearObject(formObj.intg_cd_id);
		ComClearObject(formObj.dmdt_bkg_term_ctnt);
	}
	  
	/**
	  * SEARCH SETTING
	  */
	function searchSetting(xmlStr) {
		var formObj = document.form;
		
		formObj.clk_stop_no.value 		= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_no"));		
		formObj.cxl_flg.value 			= undefinedToNull(ComGetEtcData(xmlStr, "cxl_flg"));
		comboObjects[0].Text 			= undefinedToNull(ComGetEtcData(xmlStr, "dmdt_trf_cd"));
		formObj.dmdt_trf_cd.value 		= undefinedToNull(ComGetEtcData(xmlStr, "dmdt_trf_cd"));
		formObj.dmdt_trf_nm.value 		= undefinedToNull(ComGetEtcData(xmlStr, "dmdt_trf_nm"));
		formObj.clk_stop_ofc_cd.value 	= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_ofc_cd"));
		comboObjects[1].Text 			= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_ofc_cd"));
		formObj.clk_stop_ofc_nm.value 	= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_ofc_nm"));
		formObj.clk_stop_yd_cd.value 	= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_yd_cd"));
		comboObjects[2].Text 			= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_yd_cd"));
		formObj.clk_stop_yd_nm.value 	= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_yd_nm"));
		formObj.clk_stop_fm_dt.value 	= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_fm_dt"));
		formObj.clk_stop_to_dt.value 	= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_to_dt"));
		formObj.stop_days.value 		= undefinedToNull(ComGetEtcData(xmlStr, "stop_days"));
		formObj.clk_stop_rmk.value 		= undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_rmk"));
		formObj.upd_dt.value 			= undefinedToNull(ComGetEtcData(xmlStr, "upd_dt"));
		formObj.upd_ofc_cd.value 		= undefinedToNull(ComGetEtcData(xmlStr, "upd_ofc_cd"));
		formObj.upd_usr_id.value 		= undefinedToNull(ComGetEtcData(xmlStr, "upd_usr_id"));
		comboObjects[3].Text 			= undefinedToNull(ComGetEtcData(xmlStr, "dmdt_bkg_term_ctnt"));
		formObj.dmdt_bkg_term_ctnt.value = undefinedToNull(ComGetEtcData(xmlStr, "dmdt_bkg_term_ctnt"));
		
		formObj.auth_yn.value 		= undefinedToNull(ComGetEtcData(xmlStr, "auth_yn"));
//		alert("[formObj.auth_yn.value]"+formObj.auth_yn.value);
		
		buttonMode("IBSEARCH");
	}
	  
	/**
	 * Replace from undefined TO ''
	 */
	function undefinedToNull(str){
		var returnVal = "";
		if(undefined == str){
			returnVal = "";
		} else {
			returnVal = str;
		}
		return returnVal;
	}

	/**
	  * Button Event setting
	  */
	function buttonMode(mode) {
		
		if(mode == "IBSEARCH"){
			var formObj = document.form;
			with (formObj) {
				ComEnableManyObjects(false, clk_stop_fm_dt, clk_stop_to_dt, btns_calendar);
				ComEnableManyObjects(false, clk_stop_no);
				comboObjects[0].Enable = false;
				comboObjects[1].Enable = false;
				comboObjects[2].Enable = false;
				comboObjects[3].Enable = false;
				formObj.clk_stop_no.className 	 = 'input2'; //2010.04.15.
				formObj.clk_stop_fm_dt.className = 'input2';
				formObj.clk_stop_to_dt.className = 'input2';
				formObj.clk_stop_rmk.className = 'noinput2'; //textarea2
				formObj.clk_stop_rmk.readOnly = true;
			}
			formObj.button_mode.value = "IBSEARCH";
			
		} else if(mode == "IBCLEAR"){
			var formObj = document.form;
			with (formObj) {
				ComEnableManyObjects(true, clk_stop_fm_dt, clk_stop_to_dt, btns_calendar);
				ComEnableManyObjects(true, clk_stop_no);
				comboObjects[0].Enable = true;
				comboObjects[1].Enable = true;
				comboObjects[2].Enable = true;
				comboObjects[3].Enable = true;
				formObj.clk_stop_no.className 	 = 'input'; //2010.04.15.
				formObj.clk_stop_fm_dt.className = 'input1';
				formObj.clk_stop_to_dt.className = 'input1';
				formObj.clk_stop_rmk.className = 'noinput1';  //textarea1
				formObj.clk_stop_rmk.readOnly = false
			}
			formObj.button_mode.value = "IBCLEAR";
			
		} 
	} 

	/* 개발자 작업  끝 */