/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0209.js
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.03 박명종
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
     * @class Service Provider Help : Service Provider Help 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0209() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo				= initCombo;    	
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
﻿// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var LANE = "lane";
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var TerminalList = "";
    var AccountList = "";
    var ObjList = "";
    var WIDTH_FORMULA_POPUP = 600;		//VOP_PSO_0210.do Popup 
    var HEIGHT_FORMULA_POPUP = 360;

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
	    				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_OK":
					comPopupOK(); //--> 선택된 로우가 넘어 간다. 이넘을 호출 하면.. 
					break;
					
				case "btn_Close":
					window.close();
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

        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            
	        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
        
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
		
       	initControl(sheetObjects[0]);  
       	getIdNo();
       	self.focus();
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
    	var formObj = document.form;
        // axon event 등록
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        
  		var data = ",|B,Base|S,Surcharge|D,Discount"
        var comboItems = data.split(ROWMARK);

		//ID No.	
  		addComboItem(comboObjects[1],comboItems);
  		  		
  		//Object
    	comboItems = ObjList.split("↕");
  		addObjectComboItem(comboObjects[2],comboItems);
		comboObjects[2].InsertItem(0, "", ""); 
		comboObjects[2].Index = 0;
 		
   
    }
     
     /**
      * 화면 로딩시 콤보조회 
      * 기 생성된 Formula ID, Condition ID 를 조회한다.
      */
     function sheet1_OnLoadFinish(sheetObj){
    	 //OnLoadFinish가 OnLoad보다 먼저 발생하여 문제가 되므로 loadPage() 하단으로 이동
    	 //getIdNo();
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
	                    UseAutoComplete = true;	                
		            	DropHeight = 200;
	                    ValidChar(2,3);
	                    MaxLength = 10;
	    		  }
	
	    	  break; 

	    	  case 3: 
	    		  with (comboObj) { 
	                    MultiSelect = false;
	                    UseAutoComplete = true;	                
		            	DropHeight = 200;
	                    ValidChar(1,3);
	                    MaxLength = 40;
	    				UseCode = true;
	    				SetColAlign("left|left");        
	    				SetColWidth("180|100");
	    		  }
	
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
	    	 }
	    	 
	    	 if(obj.name == "cre_usr"){
	    		 ComKeyOnlyAlphabet("num", "45|95");	//영문대소문자, 숫자, -, _ 만 입력가능
	    	 }
	     }
     

        /**
         * 콤보필드에 데이터를 추가해준다.
         */	
        function addComboItem(comboObj,comboItems) {
        	for (var i = 0 ; i < comboItems.length ; i++) {
        		var comboItem = comboItems[i].split(FIELDMARK);
        		comboObj.InsertItem(i, comboItem[1] , comboItem[0]);
        	}   		
        	//comboObj.InsertItem(0, "ALL","");
       	}
         
        /**
         * Object 콤보필드에 데이터를 추가해준다.
         */	
        function addObjectComboItem(comboObj,comboItems) {
         	for (var i = 0 ; i < comboItems.length ; i++) {
         		var comboItem = comboItems[i].split("↔");
         		comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[2], comboItem[0]);
         	}   		
        } 
         
       	
       	

	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "se_prv":
		    	if(eleObj.value.length == 8){
		    		formObj.from_date.focus();
		    	}
				break;
		    case "from_date":
		    	if(eleObj.value.length == 8){
		    		formObj.to_date.focus();
		    	}
				break; 
		    case "to_date":
		    	if(eleObj.value.length == 8){
		    		formObj.port_cd.focus();
		    	}
				break;
		}
	}


	/**
	 * IBCombo Event
	 */
	function combo1_OnChange(comboObj,value,text){
		return;  
		var formObj = document.form;
		var aText = text.split("|");


		//var sText =  comboObj.GetText( value , 1);
		var sText =  comboObj.GetText( value , 0);

		if( text == "" ){
			formObj.imdg_clss_cd_desc.value = "";
		}else{
			formObj.imdg_clss_cd_desc.value = sText;
		}     	
	}
    
    /**
     * IBCombo Event
     */
    function combo2_OnChange(comboObj,value,text){
    }


    /**
    * IBCombo Event
    */
    function combo3_OnChange(comboObj,value,text){
    }


    /**
    * IBCombo Event
    */
    function getIdNo(){
    	var formObj = document.form;
		//콤보필드를 초기화시킨다.
		comboObjects[0].RemoveAll();  //ID No 를 클리어 한다.
		formObj.f_cmd.value = COMMAND01;

		//ID No. 를 조회 한다.
		var sXml = sheetObjects[0].GetSearchXml("VOP_PSO_0209GS.do", FormQueryString(formObj));  
		var comboItems = ComGetEtcData(sXml, "id" ).split(ROWMARK);
		if( comboItems != "" ){ 
			addComboItem(comboObjects[0],comboItems);
			comboObjects[0].InsertItem(0, "", ""); 
			comboObjects[0].Index = 0;
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
							style.height = 212;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);

							var HeadTitle1 = "|ID|Description|Link Status|Created date|Created By|UPD_MNU_NO_FOML|UPD_MNU_NO_COND|FOML_SYS_DESC";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							var prefix = "sheet1_";

	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		"Status" );
							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"id",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,			340,	daLeft,		true,		prefix+"descript",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtPopup,		80,		daCenter,	true,		prefix+"link",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"cre_date",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cre_usr",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix+"upd_mnu_no_foml",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix+"upd_mnu_no_cond",		false,		"",	dfNone,	0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix+"foml_sys_desc",		false,		"",	dfNone,	0,		true,		true);
							
							CountPosition = 0;
							ShowButtonImage = 1;
				
						}
						break;
						
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
    	var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_","sheet4_" , "sheet5_" ,"sheet6_" );        
        switch(sAction) {
 		   case IBSEARCH:      // 조회
		    	formObj.f_cmd.value = SEARCH;//COMBO

 		   		sheetObj.WaitImageVisible = false;
		        ComOpenWait(true);
 		   
 		   		//조회 옵션에 따른 ID List 를 생성 날짜등의 정보와 함께 조회한다.
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0209GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				for(var i = 0; i < arrXml.length; i++){ 
					if(i > 0) {
						sheetObjects[i].WaitImageVisible = false;	
					}  
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
					sheetObjects[i].Redraw = true; 
				}
				ComOpenWait(false);
				
				break;
        }
    }
    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    	 }
         return true;
    }
    
 
     /**
      * 검색된 열에서 Double Click 시 PopUp을 발생시킨 위치에 데이터를 설정한다.
      */
     function sheet1_OnDblClick(sheetObj, Row, Col) {
    	 comPopupOK();
     }

     function sheet1_OnPopupClick(sheetObj,Row,Col){
    	 var formObj = document.form;
    	 var prefix = "sheet1_";
    	 switch (sheetObj.ColSaveName(Col)) {
	    	case prefix + "link" :				//VOP_PSO_0210.do 팝업
		    	var turl = "/hanjin/VOP_PSO_0210.do?id_tp=" + formObj.id_tp.value + "&id_no=" + sheetObj.CellValue(Row, prefix + "id");
	    	 	ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, '', '0,0', true, false, Row, Col, 1);
	    	 break;	 
    	 }
     }     



	/* 개발자 작업  끝 */