/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0013.js
*@FileTitle : Interface to ERP
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
* 
* History
* 2010.10.27 진마리아 CHM-201006714-01 추정결산 로직 보완
* 2011.03.04 진마리아 CHM-201108564-01 I/F to ERP화면내 조회 로직 및 버튼 추가
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
     * @class vop_pso_0013 : vop_pso_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0013() {
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
	
	var ROWMARK = "|";
	var FIELDMARK = ",";
	 
    var isShift = false;

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
        	
            case "btns_calendar_s":
            	var cal = new ComCalendar();
            	cal.setDisplayType('month');
	            cal.select(form.txtsdate, "yyyy-MM");
            	break;
            case "btns_calendar_e":
            	var cal = new ComCalendar();
            	cal.setDisplayType('month');
            	cal.select(form.txtedate, "yyyy-MM");
            	break;
            case "btn_Retrieve":
//					alert(srcName);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
            case "btn_New":
//	            	alert(srcName);
            	//조회조건 Clear 
				clearCondition(formObject);
            	break;
			case "btn_Detail":
//					alert(srcName);
//					alert(sheetObject1.CellValue(sheetObject1.SelectRow , "sheet1_acct_cd"));
//					alert(sheetObject1.SelectRow);
				if(sheetObject1.SelectRow === -1 ) break;//선택된 데이터가 없을 경우 
				var turl = "/hanjin/VOP_PSO_0207.do?sdt="+formObject.txtsdate.value + "&xxx=" + sheetObject1.CellText(sheetObject1.SelectRow, "sheet1_rev_yrmon");
				turl += "&edt="+formObject.txtedate.value;
				turl += "&acctCd="+sheetObject1.CellValue(sheetObject1.SelectRow , "sheet1_acct_cd");
				ComOpenPopup( turl , 1024, 610, '', '0,0', true, true);
				break;
				
			case "btn_creation":
				doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
				break;
				
			case "btn_down_excel":
				doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
				sheetObjects[1].SpeedDown2Excel(-1);
				break;
				
			default : break;
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
     * 조회 조건을 클리어 한다. 
     * @param formObj
     * @return
     */
    function clearCondition(formObj){
    	form.txtsdate.value = "";
    	form.txtedate.value = "";
    	form.acct_cd.value = "";
    	sheetObjects[0].RemoveAll(); 
    	setToday(document.form.txtsdate, "ym");//올해 설정
    	setToday(document.form.txtedate, "ym");//올해 설정
    	form.txtsdate.focus();
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

	 	//IBMultiCombo 초기화 
	    for (var k=0 ; k<comboObjects.length ; k++) {
	    	
	        initCombo(comboObjects[k],k+1);
	    }  
	    
	    //IBSheet 초기화
        for (var i=0; i<sheetObjects.length; i++) {

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

//      for(i=0;i<sheetObjects.length;i++){
//      	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
//      }
		initControl();
    }
    
    function sheet1_OnLoadFinish(sheetObj){ 
		var formObj = document.form;
		
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);	// [Account Code] Combo Data Loading 
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);	// Check Running Batch
	}
    
	/*
	 * Form의 필드 초기화 및 이벤트 초기화 
	 *  
	 */
	function initControl(){
		axon_event.addListener ('keydown', 'obj_keydown', 'form');
    	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
     	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
     	axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
     	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    	setToday(document.form.txtsdate, "ym");//올해 설정
    	setToday(document.form.txtedate, "ym");//올해 설정
     	document.form.txtsdate.focus();
	}
	 
	function obj_keydown(){
	       	isShift = event.shiftKey ? true : false;
	   	if(event.keyCode === 13 && checkPeriod()) 
	       		ComKeyEnter();
	}
	function checkPeriod(){
		 var formObj = document.form;
	   	 obj = event.srcElement;      	
	   	 with(formObj){
	   		 if(obj.name=="txtsdate" || obj.name=="txtedate" || obj.name == "btn_Retrieve"){
	   			 var creDtFr = ComReplaceStr(txtsdate.value,"-","");
	   			 var creDtTo = ComReplaceStr(txtedate.value,"-","");
	   			 switch(obj.name) {
		    	    	case "txtsdate":	// Agreement From Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtsdate.value='';
		    	    				document.form.txtsdate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	    			
		    	            break;
		    	            
		    	    	case "txtedate":	// Agreement To Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtedate.value='';
		    	    				txtedate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	           	break;	
		        	}
	   		 }
	       }
	       return true;	
	}
     /**
      * onBlur처리 
      * @return
      */
     function obj_blur(){
    	  var formObj = document.form;
    	   	 obj = event.srcElement;      	
    	   	 
    	   	 with(formObj){
    	   		 if(obj.name=="txtsdate" || obj.name=="txtedate"){
    	   			 var creDtFr = ComReplaceStr(txtsdate.value,"-","");
    	   			 var creDtTo = ComReplaceStr(txtedate.value,"-","");
    		        	
    	   			 switch(obj.name) {
    		    	    	case "txtsdate":	// Agreement From Date
    		    	    		if(creDtFr != '' && creDtTo != ''){
    		    	    			if(creDtFr > creDtTo){
    		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
    		    	    				txtsdate.value='';
    		    	    				document.form.txtsdate.focus();
    		    	    				return false;
    		    	    			}
    		    	    		}
    		    	    			
    		    	            break;
    		    	            
    		    	    	case "txtedate":	// Agreement To Date
    		    	    		if(creDtFr != '' && creDtTo != ''){
    		    	    			if(creDtFr > creDtTo){
    		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
    		    	    				txtedate.value='';
    		    	    				txtedate.focus();
    		    	    				return false;
    		    	    			}
    		    	    		}
    		    	           	break;	
    		        	}
    		        
    	   			ComChkObjValid(event.srcElement);
    	   		 }
    	       }
    	       return true;	
     }

     /**
      * onFocus처리 
      * @return
      */
     function obj_focus(){
         ComClearSeparator(event.srcElement);
     }
    /**
     * keypress처리 함수
     * @return
     */
    function obj_keypress(){
  	    obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	
  	    switch(obj.dataformat) {
  	        case "ymd":
  	        case "ym":
  	        case "hms":
  	        case "hm":
  	        case "jumin":
  	        case "saupja":
  	            ComKeyOnlyNumber(obj);
  	            break;
  	        case "int":
  	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
  	            else ComKeyOnlyNumber(obj);
  	            break;
  	        case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;
  	        case "eng":
  	            ComKeyOnlyAlphabet(); break;
  	        case "engup":
  	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
  	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
  	            else ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "engdn":
  	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
  	            else ComKeyOnlyAlphabet('lower');
  	            break;
  	    }
  	}
    /**
    * KEYUP의 경우 FOCUS이동 처리를 한다. 
    * @return
    */
	function obj_keyup() {
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		//KEYTYPE이 마우스 클릭이면 리턴.
		if (!event.keyCode) return;
		
		if(event.keyCode === 9 || isShift ){
			return true;
		}
		
		switch (eleObj.name) {
			case "txtsdate":
				if (eleObj.value.length == 6) {
					formObj.txtedate.focus();
				}
				break;
			default:
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
    							style.height = 445;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = false;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, 100);

    							var HeadTitle1 = "|Revenue Month|Account Code|Estimate Cost|Actual Cost|Accrual Cost";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);

    							var prefix = "sheet1_";
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		"Status");
    							InitDataProperty(0, cnt++ , dtData,					190,	daCenter,	true,		prefix+"rev_yrmon",		false,		"",	dfUserFormat,	0,		true,		true);
    							InitDataProperty(0, cnt++ , dtData,					190,	daCenter,	true,		prefix+"acct_cd",		false,		"",	dfNone,			0,		true,		true);
    							InitDataProperty(0, cnt++ , dtData,					190,	daRight,	true,		prefix+"estm_amt",		false,		"",	dfNullFloat,	2,		true,		true);
    							
    							InitDataProperty(0, cnt++ , dtData,					190,	daRight,	true,		prefix+"act_amt",		false,		"",	dfNullFloat,	2,		true,		true);
    							InitDataProperty(0, cnt++ , dtData,					180,	daRight,	true,		prefix+"accl_amt",		false,		"",	dfNullFloat,	2,		true,		true);
    							

    							InitUserFormat(0, prefix+"rev_yrmon", "####-##", "-");
	
    						}
    						break;
    						
    						
    						
    				case "sheet2":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 0;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = false;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, 100);

    							var HeadTitle1 = "Actual Month|Revenue Month|Account Code|Revenue lane|Port|Revenue VVD|Design Capacity|Estimate Cost|Actual Cost|Accrual Cost";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);

    							var prefix = "sheet2_";
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	true,		prefix+"exe_yrmon",		false,		"",	dfDateYm,		0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	true,		prefix+"rev_yrmon",		false,		"",	dfDateYm,		0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	true,		prefix+"acct_cd",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	true,		prefix+"rev_lane",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	true,		prefix+"port",			false,		"",	dfNone,			0,		false,		true);
    							
    							InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	true,		prefix+"rev_vvd",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daRight,	true,		prefix+"dcapa",			false,		"",	dfInteger,		0,		false,		true);    							    							
    							InitDataProperty(0, cnt++ , dtData,					105,	daRight,	true,		prefix+"estm_amt",		false,		"",	dfNullFloat,	2,		true,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daRight,	true,		prefix+"act_amt",		false,		"",	dfNullFloat,	2,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					105,	daRight,	true,		prefix+"accl_amt",		false,		"",	dfNullFloat,	2,		false,		true);
    							
    						}
    						break;
    						
            }
    }

 	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObj = document.form

  	    switch(comboNo) {
	    	
	    	case 1:	//Account Code
	    		with(comboObj) {
					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left|left");        
  					SetColWidth("55|330");
  					DropHeight = 160;
	    		}
	    	break;
  	    }
  	}
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        switch (sAction) {
			case IBSEARCH: //조회
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet1") {
						sheetObjects[0].WaitImageVisible = false;
						ComSetObjValue(formObj.f_cmd, SEARCH);
						ComSetObjValue(formObj.acct_cd, getAccountCd());
						
						ComOpenWait(true);
		                var sXml = sheetObj.GetSearchXml("VOP_PSO_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		                ComOpenWait(false);
		                
		                var isRunning = ComGetEtcData(sXml, "IS_RUNNING");
		                formObj.status.value = isRunning == "true" ? "Processing" : "";
		                sheetObjects[0].LoadSearchXml(sXml);
					}
				}
				break;
				
			case IBCREATE: //Creation
				if (validateForm(sheetObj, formObj, sAction)) {
					
					if(!ComShowCodeConfirm("PSO00041", "create accrual amount")){
						break;
					}
				
					if (sheetObj.id == "sheet1") {
						ComOpenWait(true);
						//formObj.f_cmd.value = COMMAND02;	//[2010.05.12:jmh]
						formObj.f_cmd.value = ADD;
						var sXml = sheetObj.GetSearchXml("VOP_PSO_0013GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam("sheet1_"));
						var statusCode = ComGetEtcData(sXml, "BatchStatus" );
//						alert(statusCode);
						sheetObj.RemoveAll();
						ComOpenWait(false);
						switch(statusCode){
//						case "0": // H/C
						case "4":	//Completed
							ComShowCodeMessage("COM12116", "Interface To ERP");
							break;
						case "5":	//failed
							ComShowCodeMessage("COM12151", "Interface To ERP");
							break;
						case "6":	//Processing
							formObj.status.value = "Processing";
							ComShowCodeMessage("PSO00038", "Interface To ERP");
							break;
						default: break;		
						}
					}
					
				break;
				}
					
         	case IBSEARCH_ASYNC01:      //OPEN (Check Running Batch)
     			var aryPrefix = new Array("sheet1_");
     			formObj.f_cmd.value = COMMAND02;
     			
     			sheetObjects[0].WaitImageVisible = false;
     			var sXml = sheetObj.GetSearchXml("VOP_PSO_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
     			var isRunning = ComGetEtcData(sXml, "IS_RUNNING");
     			formObj.status.value = isRunning == "true" ? "Processing" : "";
     			sheetObjects[0].LoadSearchXml(sXml);
             	break;
             	
         	case SEARCH01: //raw data 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet2") {
					formObj.sdt.value = formObj.txtsdate.value;
					formObj.edt.value = formObj.txtedate.value;
					sheetObjects[1].WaitImageVisible = false;
					formObj.f_cmd.value = SEARCH01;
					ComOpenWait(true);
	                var sXml = sheetObj.GetSearchXml("VOP_PSO_0013GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
	                ComOpenWait(false);
	                sheetObjects[1].LoadSearchXml(sXml);
				}
			}
			break;
             	
			default:
				break;
		}
    }
        
	/**
	 * 콤보필드를 초기화 시키기 위해서 해당 데이터를 조회후 조회된 데이터로 채운다.
	 */	
	function doActionIBCombo(sheetObj, formObj, sAction, sComboAction) {
	    sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
	    switch(sAction) {
	    	case IBSEARCH:      // 조회	    
				//콤보필드를 초기화시킨다.
	    		comboObjects[0].RemoveAll();
				formObj.f_cmd.value = sComboAction;
				
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("PSO_COMGS.do", FormQueryString(formObj));
				ComOpenWait(false);

				var comboDatas = "All,All|" + ComGetEtcData(sXml, "account");
				var comboItems = comboDatas.split(ROWMARK);
				addComboItem(comboObjects[0], comboItems);
			break;
	    }
	    
		sheetObj.WaitImageVisible = true;	    
	}

	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj, comboItems) {
		for (var i=0; i<comboItems.length; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
		}   		
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 //필수 입력 값 체크 
    	 if(formObj.txtsdate.value === "" || formObj.txtsdate.value === "undefined"){
    		 ComShowCodeMessage("PSO00003", "From Revenue Month");
    		 formObj.txtsdate.focus();
    		 return false;
    	 }
    	 else if(formObj.txtedate.value === "" || formObj.txtsdate.value === "undefined"){
    		 ComShowCodeMessage("PSO00003", "To Revenue Month");
    		 formObj.txtedate.focus();
    		 return false;
    	 }
    	 return true;
    }

 	// Account Code 멀티콤보 클릭 이벤트
 	function combo1_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	
	/**
	 * 	 * 멀티콤보 클릭 이벤트  <br>
	 * <b>Example :</b>
	 *
	 * @param comboObj	멀티콤보 오브젝트
	 * @param index		멀티콤보 index
	 * @param code		멀티콤보 code
	 * @return
	 */
	function setMultiCombo(comboObj, index, code) {
		//All 인 경우
	    if (index == 0) {
	    	//checked
	    	if (comboObj.CheckIndex(index)) {
	    		for (var i = 1 ; i < comboObj.GetCount () ; i++) {
	    			comboObj.checkIndex(i) = true;
	    		}
	    	} 
	    	else {
	    		for (var i = 1 ; i < comboObj.GetCount () ; i++) {
	    			comboObj.checkIndex(i) = false;
	    		}
	    	}
		//All 이 아닌 경우
	    } 
	    else {
	    	var checkCnt = 0;
    		for (var i = 1 ; i < comboObj.GetCount () ; i++) {
    			if (comboObj.checkIndex(i)) {
    				checkCnt++;
    			}
    		}
    		if (checkCnt == comboObj.GetCount ()-1) {
    			comboObj.checkIndex(0) = true;
    		}
    		else {
    			comboObj.checkIndex(0) = false;
    		}
	    }
	}
	
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */		
	function getAccountCd() {
		var acctCd = ComTrim(comboObjects[0].Text);
		
		if (acctCd.indexOf("All,") != -1) {
			acctCd = acctCd.replace("All,", "")
		}
		return acctCd;
	}
	
	/* 개발자 작업  끝 */