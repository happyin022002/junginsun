/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0025.js
*@FileTitle : Budget vs Actual
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.08 박명종
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
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
     * @class vop_pso_0025 : vop_pso_0025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
   		this.initCombo				= initCombo;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
//    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0;

 var LANE = "lane";
 var ROWMARK = "|";
 var FIELDMARK = ",";

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
	
	        	case "btn_Detail"://Detail Button Click
	        		//showDetail();//Grid에 선택된 Row의 Detail값을 표현한다.
	        	    if(sheetObject1.RowCount == 0) return ;//ROW가 없으면 리턴
		        	var sUrl = "/hanjin/VOP_PSO_0201.do?acctNo="+sheetObject1.cellValue(sheetObject1.SelectRow, "sheet1_lgs_cost_cd")
		        	           +"&gubun="+formObject.gubun.value
		        	           +"&laneCd="+formObject.vsl_slan_cd.value
		        	           +"&locCd="+sheetObject1.cellValue(sheetObject1.SelectRow, "sheet1_vsl_slan_cd")
		        	           +"&vslCls="+comboObjects[2].Code
		        	           +"&creDtFr="+formObject.cre_dt_fr.value
		        	           +"&creDtTo="+formObject.cre_dt_to.value;
//        	alert("sUrl:="+sUrl);
					ComOpenPopup(sUrl, 750, 390, "", "0,0", false);
	        		break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_vsl_slan_cd":
					var sUrl = "/hanjin/VOP_VSK_0202.do?op=0202";
					ComOpenPopup(sUrl, 422, 470, "getLaneCodeData", "0,0", true);
					break;						
				case "btn_port_cd":
					var sUrl = "/hanjin/VOP_VSK_0043.do?op=0043";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.port_cd.value = rVal;
						loadTerminal();
						sheetObjects[0].RemoveAll();
					}
					break;
				case "btns_Calendar1" :		// Agreement Date (From Date)
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.cre_dt_fr, "yyyy-MM");
					break;
						
				case "btns_Calendar2" :		// Agreement Date (To Date)
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.cre_dt_to, "yyyy-MM");
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



    function loadTerminal(code) {
    	var formObject = document.form;
		doActionIBCombo(sheetObjects[0] ,formObject,IBSEARCH_ASYNC01,COMMAND01);
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
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		var formObject = document.form;
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}		
		
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
//			doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }


        
        

		initControl(sheetObjects[0]);  
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
     /**
      * 화면 깜빡임 처리 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.WaitImageVisible = false;
    	 var formObject = document.form;
    	 doActionIBCombo(sheetObjects[0] ,formObject,IBSEARCH,SEARCHLIST); 
//  	 initHOOfc();
//  	 initCombo();     

//  	 doActionIBSheet(sheetObj,document.form,IBCLEAR);
//  	 sheetObj.WaitImageVisible = true; 
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
     				MultiSelect = true; 
     				UseAutoComplete = true;	
	 		    	}
	 			break; 
	 		  case 2: 
	           with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;	
					SetColAlign("left");        
					SetColWidth("100");
	 		    	}
	 			break; 
		} 
 	}


    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function initControl(sheetObj){
    	// Form 객체 선언
    	formObj = document.form;
    	setToday(formObj.cre_dt_fr,"ym");
    	setToday(formObj.cre_dt_to,"ym");
        // axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListenerForm('keyup', 'obj_keyup', form);
//		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListener('change', 'obj_change', 'agmt_iss_ofc_cd'); 
        axon_event.addListener('change', 'obj_change', 'gubun'); 
          	
        // Lease Term Combo Control에  초기값을  설정한다.
//        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
        
        // 초기 focus
//        formObj.agmt_iss_ofc_cd.focus();
    }





 	// 조회조건필드인 Lane SVC Type 데이터 조회
	function doActionIBCombo( sheetObj , formObj,sAction,sComboAction ) {
    sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {

       case IBSEARCH:      // 조회
			if (sheetObj.id == "sheet1") {	
				//콤보필드를 초기화시킨다.
				comboObjects[1].RemoveAll();
				formObj.f_cmd.value = SEARCHLIST;
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0025GS.do", FormQueryString(formObj));
				var comboItems = ComGetEtcData(sXml, "account" ).split(ROWMARK);
				addComboItem(comboObjects[1],comboItems);		

				comboItems = ComGetEtcData(sXml, "vsl" ).split(ROWMARK);
				addComboItem(comboObjects[2],comboItems);		
				ComOpenWait(false);
			};
														
            break;
		case IBSEARCH_ASYNC01: 
			if (sheetObj.id == "sheet1") {				

				//콤보필드를 초기화시킨다.
				comboObjects[0].RemoveAll();
									
				//formObj.f_cmd.value = sComboAction;
				formObj.f_cmd.value = COMMAND01;

				//var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				//--> 내 SC에서 BC를 Implement해야 된다. 
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));

				var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
				addComboItem(comboObjects[0],comboItems);	
			};
            break;
	    }
	}

	function obj_change(){
		var HeadTitle1 = "";
		var HeadTitle2 = "";
			
		if( document.form.gubun.value == 0 ) {
			HeadTitle1 = "|Seq.|Port|Account\nCode|Budget|Budget|Monthly|Monthly|Actual|Actual|Budget vs Actual|Budget vs Actual|Estimate vs Actual|Estimate vs Actual|Budget vs Estimate|Budget vs Estimate";
			HeadTitle2 = "|Seq.|Port|Account\nCode|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call";
		} else {
			HeadTitle1 = "|Seq.|Lane|Account\nCode|Budget|Budget|Monthly|Monthly|Actual|Actual|Budget vs Actual|Budget vs Actual|Estimate vs Actual|Estimate vs Actual|Budget vs Estimate|Budget vs Estimate";
			HeadTitle2 = "|Seq.|Lane|Account\nCode|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call";
		}

		sheetObjects[0].InitHeadRow(0, HeadTitle1, true);
		sheetObjects[0].InitHeadRow(1, HeadTitle2, true);
		sheetObjects[0].RemoveAll();
	}	


	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj,comboItems) {
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] , comboItem[0]);
		}   		
		comboObj.InsertItem(0, " "," ");
	}


	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "cre_dt_fr":
		    	if(eleObj.value.length == 6){
		    		formObj.cre_dt_to.focus();
		    	}
				break; 
		    case "cre_dt_to":
		    	if(eleObj.value.length == 6){
		    		formObj.vsl_slan_cd.focus();
		    	}
				break;
		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.port_cd.focus();
					sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "port_cd":
		    	if(eleObj.value.length == 5){
			    	loadTerminal();
		    		formObj.term_code.focus();
					sheetObjects[0].RemoveAll();
		    	} else{
		    		formObj.term_code.RemoveAll();
		    	}
				break;
		    case "term_code":
		    	if(eleObj.value.length == 2){
		    		formObj.combo1.focus();
					sheetObjects[0].RemoveAll();
		    	}
				break;

		}
	}


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetid = sheetObj.id;
		switch(sheetid) {

				case "sheet1":
					with (sheetObj) {
						// 높이 설정
						style.height = 455;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

						//전체Edit 허용 여부 [선택, Default false]
						Editable = false;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 3, 100);
						
						var HeadTitle1 = "";
						var HeadTitle2 = "";
							
						HeadTitle1 = "|Seq.|Port|Account\nCode|Budget|Budget|Monthly|Monthly|Actual|Actual|Budget vs Actual|Budget vs Actual|Estimate vs Actual|Estimate vs Actual|Budget vs Estimate|Budget vs Estimate";
						HeadTitle2 = "|Seq.|Port|Account\nCode|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call";
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
						InitHeadMode(false, true, false, true, false,false);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						var prefix = "sheet1_";

					//데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE,		SAVENAME,				KEYFIELD,	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		"Status");
						
						InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"SEQ",									false,		"",	dfNone,				0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"vsl_slan_cd",						false,		"",	dfNone,				0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"lgs_cost_cd",					false,		"",	dfNone,			0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	70,		daRight,	true,		prefix+"budget_amount",					false,		"",	dfNullFloat,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	70,		daRight,	true,		prefix+"budget_call",					false,		"",	dfNullInteger,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"estima_amount",					false,		"",	dfNullFloat,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	70,		daRight,	true,		prefix+"estima_call",					false,		"",	dfNullInteger,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"actual_amount",					false,		"",	dfNullFloat,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"actual_call",					false,		"",	dfNullInteger,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"budget_vs_actual_amount",		false,		"",	dfNullFloat,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	70,		daRight,	true,		prefix+"budget_vs_actual_call",			false,		"",	dfNullInteger,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"estima_vs_actual_amount",		false,		"",	dfNullFloat,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	70,		daRight,	true,		prefix+"estima_vs_actual_call",			false,		"",	dfNullInteger,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"budget_vs_estima_amount",		false,		"",	dfNullFloat,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtAutoSumEx,	70,		daRight,	true,		prefix+"budget_vs_estima_call",			false,		"",	dfNullInteger,		0,		true,		true);

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
           			sheetObj.WaitImageVisible = false;
        	        ComOpenWait(true);
           			formObj.f_cmd.value = SEARCH;
	                sheetObj.DoSearch("VOP_PSO_0025GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	                ComOpenWait(false);
				}
			break;
		  	case IBCLEAR:       //초기화 
				initSearchControls("CLEAR");
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
    		 		if(cre_dt_fr.value == ''){
           				ComShowCodeMessage('PSO00003');
           				cre_dt_fr.focus();
           				
           				return false;
           			}	
           			if(cre_dt_to.value == ''){
           				ComShowCodeMessage('PSO00003');
           				cre_dt_fr.focus();
           				
           				return false;
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
    	        if(obj.name=="vsl_slan_cd") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    case "engdn":
    	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
    	        else ComKeyOnlyAlphabet('lower');
    	        break;
    	    case "uppernum":
    	    	ComKeyOnlyAlphabet('uppernum');
    	    	break;
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
    		 if(obj.name=="cre_dt_fr" || obj.name=="cre_dt_to"){
    			 var creDtFr = ComReplaceStr(cre_dt_fr.value,"-","");
    			 var creDtTo = ComReplaceStr(cre_dt_to.value,"-","");
	        	
    			 switch(obj.name) {
	    	    	case "cre_dt_fr":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				cre_dt_fr.value='';
	    	    				cre_dt_fr.focus();
	    	    				return;
	    	    			}
	    	    			
	    	    			//1년 이내
	    	    			if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
	    	    				ComShowCodeMessage('COM12133','Period','1 year','less');
	    	    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
	    	    				cre_dt_fr.value='';
	    	    				cre_dt_fr.focus();
	    	    				return;
	    	    			}
	    	    		}
	    	    			
	    	            break;
	    	            
	    	    	case "cre_dt_to":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				cre_dt_to.value='';
	    	    				cre_dt_to.focus();
	    	    				return;
	    	    			}
	    	    			
	    	    			//1년 이내
	    	    			if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
	    	    				ComShowCodeMessage('COM12133','Period','1 year','less');
	    	    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
	    	    				cre_dt_to.value='';
	    	    				cre_dt_to.focus();
	    	    				return;
	    	    			}
	    	    		}
	    	           	break;	
	        	}
	        
    			ComChkObjValid(event.srcElement);
    		 }
        }
        	
    }

    /**
     * 
     * @param rtnObjs
     * @return
     */
	function getLaneCodeData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_slan_cd.value = rtnDatas[1];
					sheetObjects[0].RemoveAll();
				}
			}
    	}
	}


	  
	/**
	  * INIT SETTING
	  */
	function initSearchControls(flag) {
		var formObj = document.form;
		ComClearObject( formObj.vsl_slan_cd );
		ComClearObject( formObj.port_cd );
		ComClearObject( formObj.term_code );
		comboObjects[0].Text = "";
		comboObjects[1].Text = "";
		setToday(formObj.cre_dt_fr,"ym");
    	setToday(formObj.cre_dt_to,"ym");
    	sheetObjects[0].RemoveAll(); 
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;
		with(sheetObj)
		{
//			sheetObj.ReNumberSeq(); 
		}
	}


    /**
    * IBCombo Event
    */
    function combo1_OnChange(comb, Index_Code, Text){
		//콤보필드를 초기화시킨다.
		sheetObjects[0].RemoveAll();
    }


    /**
    * IBCombo Event
    */
    function combo2_OnChange(comb, Index_Code, Text){
		//콤보필드를 초기화시킨다.
		sheetObjects[0].RemoveAll();
    }


    /**
    * IBCombo Event
    */
    function combo3_OnChange(comb, Index_Code, Text){
		//콤보필드를 초기화시킨다.
		sheetObjects[0].RemoveAll();
    }


	/* 개발자 작업  끝 */