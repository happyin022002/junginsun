/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0026.js
*@FileTitle : Port Charge Invoice Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.07
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.08 박명종
* 1.0 Creation
* 
* History
* 2010.09.16 진마리아 CHM-201005696-01 Port charge invocie Summary 메뉴 수정 요청건
*										지역본부및 office별, Port별 S/P No.로 발생한 Actual invoice를 조회하기 위한 조건 추가/삭제 및 Grid내 칼럼 추가 요청함
*										기존 Main 화면에서 조회조건이 속한 Invoice Master 정보를 보여주고, Detail에서는 해당 Invoice의 Detail  모든 정보를 보여주도록 되어있으나, 조회조건에 맞는 Detail 정보만이 조회되도록 수정.
* 2010.12.08 진마리아 CHM-201007135-01 Vessel class 호출 로직 변경 요청건
* 2011.01.12 이석준 CHM-201108296-01 Invoice Summary Report내 Down Excel 변경 요청
* 2011.03.04 진마리아 CHM-201108565-01 Port Charge Invoice Summary 조회 로직 변경 - ctrl h/q 조회로직 변경 및 조회조건(created id), 결과(csr no, status) 컬럼 추가
* 2011.04.12 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완 - vsl popup 호출로직 수정
* 2011.10.07 진마리아 CHM-201113739-01 [VOP-PSO] Port Charge Invocie Summary 조회 로직 변경 - Invocie Created Date, Issue Date로 조회시 ALPS내 스케줄 Check없이 invocie내 data로 조회 가능하도록 로직 수정
* 2011.12.19 진마리아 CHM-201114861-01 [VOP-PSO] yard 다중 선택 시 조회 가능하도록 로직 수정
* 2014.07.22 이성훈 CHM-201430727 [PSO] Tariff 및 Adjustment Cost 칼럼 추가
* 2014.12.29 김기원 CHM-201433349 [PSO] 조회 조건 추가 및 정렬기준 변경
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
     * @class VOP_PSO_0026 : VOP_PSO_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0026() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
   		this.initCombo				= initCombo;
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

 var LANE = "lane";
 var ROWMARK = "|";
 var FIELDMARK = ",";
 
 var WIDTH_DETAIL_POPUP = 870;
 var HEIGHT_DETAIL_POPUP = 550;
 


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
       	  			//if(!checkVvd(document.form)) break;	//[2009.12.31:jmh] 조회조건 체크 없앰 
					//initSheet(sheetObject1,1);
					
					//2014.12.29 조회조건 변경
					sheetObjects[0].RemoveAll();
					for(i=0;i<sheetObjects.length;i++){
						if(i==0){
						 initSheet(sheetObjects[i],i+1);}
				     
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
       	  		   
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;

				case "btn_port_cd":
					if (document.form.s_retrieve_cp[1].checked) {   //2014.12.29 PORT lov enable기능 추가
						var sUrl = "/hanjin/VOP_VSK_0043.do";
						var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
						if(rVal){
							formObject.port_cd.value = rVal;
							loadTerminal();
							sheetObjects[0].RemoveAll();
						}
					}
					break;
				case "btn_cnt_cd":          //2014.12.29 country lov 추가
					if (document.form.s_retrieve_cp[0].checked) { 
						param = '?classId=COM_ENS_051&cnt_cd='+formObject.cnt_cd.value;
						ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
					}
					break;
			
				case "btns_Calendar1" :		// From Date
					var cal = new ComCalendar();
					cal.select(formObject.from_date, 'yyyy-MM-dd');
					break;
	
				case "btns_Calendar2" :		// To Date
					var cal = new ComCalendar();
					cal.select(formObject.to_date, 'yyyy-MM-dd');
					break;
			
				case "btn_vvd_search":
					var vsl_cd = formObject.vsl_cd.value;
                	var sUrl = "";
                	
                	if(vsl_cd == ""){
                		sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y";
                		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 340, 423, "getVvdData", "0,0", true);
                	}
				break;
	
				case "btn_lane_search":
					openLaneCode();
					
		        break;
				
				case "btn_DownExcel":
					if (sheetObject1.RowCount <= 0) {
						// There is no related data!
						ComCodeMsgByNoRelatedData();
						return;
					} else {
						if (sheetObject1.RowCount > 0) {
//							sheetObject1.Down2Excel(1,false,true,true,"","",false,false,"Invoice Summary");
							doActionIBSheet(sheetObjects[1], formObject, SEARCH01);
						}
					}	
				break;	
				
				case "btn_Detail":
					var prefix = "sheet1_";
					var selectRow = sheetObjects[0].SelectRow;
					if(selectRow < 0 || sheetObjects[0].RowCount < 1) return;
					var param  = "port_cd="     + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(selectRow, prefix + "yd_cd"));
						param += "&vvd="     + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(selectRow, prefix + "vvd"));
						param += "&acct_cd="     + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(selectRow, prefix + "acct_cd"));
						param += "&vndr_seq="     + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(selectRow, prefix + "vndr_seq"));
						param += "&iss_cty_cd=" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(selectRow, prefix + "iss_cty_cd"));
						param += "&so_seq="     + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(selectRow, prefix + "so_seq"));
					;
					var url = "/hanjin/VOP_PSO_0214.do?" + param;	
					var sFeatures = "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_DETAIL_POPUP + ",height=" + HEIGHT_DETAIL_POPUP;
					ComOpenWindow(url, "DETAIL", sFeatures, false);					
				break;	
			
				case "btns_VendorSeq":
					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 430, 'setVendorSeq', '1,0,1,1,1', true);
					
				break;
            }
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

    function getCountry(rowArray) {
    	var colArray = rowArray[0];
    	document.form.cnt_cd.value = colArray[3];
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
		var formObject = document.form
		
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
		initComboStatus();	//Status Combo
		chg_retrieve_cp(); // 2014.12.29  port와 country 조회 조건 선택 radio button
		
    }

     function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.WaitImageVisible = false;
    	 var formObject = document.form;
//   	 doActionIBCombo(sheetObjects[0] ,formObject,IBSEARCH,SEARCHLIST); 
//    	 doActionIBCombo(sheetObjects[0], formObject, COMMAND02);
    	 doActionIBCombo(sheetObjects[0], formObject, IBSEARCH, SEARCH01); 
     }


	
      /**
       * Combo 기본 설정 
       * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
       * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
       */ 
      function initCombo(comboObj, comboNo) {
    	  var formObject = document.form;
    	  var id = comboObj.id;

    	  switch(comboObj.id) {  
	    	  case "term_code":		//Yard 
		    	  with (comboObj) { 
		    		  MultiSelect = true; 
		    		  UseAutoComplete = true;
		    		  SetColAlign("left|left");
		    		  SetColWidth("30|340");
		    		  DropHeight = 160;
		    	  }
	    	  break; 
	    	  

	    	  case "combo1":		//Account 
		    	  with (comboObj) { 
		    		  MultiSelect = true; 
		    		  UseAutoComplete = true;	
		    		  MultiSeparator = ",";
		    		  SetColAlign("left");        
		    		  SetColWidth("100");
					  DropHeight = 190;
					  ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨. 따라서 User Function 사용)
					  MaxLength = 6;
		    	  }
	    	  break; 

	    	  //VOP_VSK_0027 참조
			  case "vskd_port_rhq_cd": 	//CTRL H/Q
					with (comboObj) { 
						MultiSelect = false;
						UseAutoComplete = true;	
						SetColAlign("left");        
						SetColWidth("50");
						DropHeight = 160;
					}
			  break;
			  
			  case "sls_ofc_cd":		//CTRL H/Q
					with (comboObj) { 
						MultiSelect = false;
						UseAutoComplete = true;	
						SetColAlign("left");        
						SetColWidth("50");
						DropHeight = 160;
					}
			  break;	    
			  
			  case "cntr_vsl_clss_capa":		//Vessel Class
					with (comboObj) { 
						MultiSelect = false;
						UseAutoComplete = true;	
						SetColAlign("left");        
						SetColWidth("50");
						DropHeight = 160;
					}
			  break;
			  
//			  case "vsl_slan_cd":		//Lane CDs
//					with (comboObj) { 
//						MultiSelect = false;
//						UseAutoComplete = true;	
//						SetColAlign("left");        
//						SetColWidth("50");
//						DropHeight = 160;
//					}
//			  break;
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
    	setToday(formObj.from_date,"ymd");
    	setToday(formObj.to_date,"ymd");
        // axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListenerForm  ('blur', 'obj_deactivate', form);
        axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
    	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
    	axon_event.addListenerForm  ('drop', 'obj_drop', form); 
    }



 // 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo( sheetObj , formObj,sAction,sComboAction ) {
    sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {

    
//       case IBSEARCH:      // 조회
////			if(validateForm(sheetObj,formObj,sAction))
//			if (sheetObj.id == "sheet1") {	
//				//콤보필드를 초기화시킨다.
//				formObj.combo1.RemoveAll();		//Account
//				formObj.f_cmd.value = SEARCHLIST;
//				var sXml = sheetObj.GetSearchXml("VOP_PSO_0025GS.do", FormQueryString(formObj));
//				var comboItems = ComGetEtcData(sXml, "account" ).split(ROWMARK);
//				addComboItem(formObj.combo1,comboItems);		
//
//			};
//														
//            break;
    
		case IBSEARCH_ASYNC01: 
			if (sheetObj.id == "sheet1") {				

				//콤보필드를 초기화시킨다.
				formObj.term_code.RemoveAll();	//Yard	
									
				formObj.f_cmd.value = COMMAND01;

				//var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				//--> 내 SC에서 BC를 Implement해야 된다. 
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));

				var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
				addComboItemTermCode(formObj.term_code,comboItems);	
			};
            break;
            
//		case COMMAND02:      // Open
//			formObj.f_cmd.value = SEARCH01;
//			var sParam = FormQueryString(formObj);
//		//	var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
//			var sXml = sheetObj.GetSearchXml("VOP_PSO_0026GS.do", sParam);
//			var rhqCdArr = (" |"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
//			var rhqDescArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
//			
//			//CTRL Combo Setting.
//			appendMultiComboItem(formObj.vskd_port_rhq_cd, rhqCdArr, rhqDescArr, "", "DEF");
//		break;  
		
		case COMMAND03:      // Control Office
			formObj.f_cmd.value = SEARCH02;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0027GS.do", sParam);
			
			return sXml;
		break;
		
            
		case IBSEARCH:      // Open
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0026GS.do", sParam);
			var rhqCdArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//CTRL H/Q
			var rhqDescArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	
			appendMultiComboItem(formObj.vskd_port_rhq_cd, rhqCdArr, rhqDescArr, "", "DEF");
			
			var comboItems = ComGetEtcData(sXml, "account" ).split(ROWMARK); //Account
			
			addComboItem(formObj.combo1,comboItems);
			
			var comboItems1 = ComGetEtcData(sXml, "vsl" ).split(ROWMARK); //Vessel Class
			addComboItem(formObj.cntr_vsl_clss_capa,comboItems1);
		break;  

			
	    }
	}



	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj,comboItems) {
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1] , comboItem[0]);
		}   		
		comboObj.InsertItem(0, "ALL","");
		
	
	}
	 
	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo1_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}

	
	 /**
	  * 콤보필드에 데이터를 추가해준다.
	  */	
	 function addComboItemTermCode(comboObj,comboItems) {
		  comboObj.InsertItem(-1, "ALL","");
		 for (var i = 0 ; i < comboItems.length ; i++) {
			 var comboItem = comboItems[i].split(FIELDMARK);
			 comboObj.InsertItem(-1, comboItem[0] + "|" + comboItem[1] , comboItem[0]);
		 }   		
	 }
	 
	/**
	 * 조회 후, class 콤보에 대해서 데이터를 추가해준다.
	 */	
	function addComboItemClass(comboObj,comboItems) {
		 if(comboItems == null || comboItems.length == 1 ){
			 comboObj.Enable = false;
		 }else{
			 comboObj.Enable = true;
		 }
		 for (var i = 1 ; i < comboItems.length ; i++) {
			 comboObj.InsertItem(i-1, comboItems[i] , comboItems[i]);
		 }
		 if(!(comboItems == null || comboItems.length == 1)){
			 comboObj.InsertItem(0, "ALL","");
		 }
	}

	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
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
		    		formObj.vsl_cd.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.combo1.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;

		}
	}

	//Copy & Paste 로 값을 입력할 경우
	function obj_paste(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
			case "port_cd":
				gf_SetControlPastePattern(event, "A");		//영대문자
				break;
	
			case "vsl_cd":
				gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
				break;
	
			case "skd_voy_no":
				gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
				break;
	
			case "skd_dir_cd":
				gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
				break;				
	
			case "vndr_seq":
				gf_SetControlPastePattern(event, "0");		//숫자
				break;			
	
			case "from_date":
				gf_SetControlPastePattern(event, "0");		//숫자
				break;			
	
			case "to_date":
				gf_SetControlPastePattern(event, "0");		//숫자
				break;			
		}
	}

	//Drag & Drop으로 값을 입력하는 것은 배제함
	function obj_drop(){
		event.returnValue = false;
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
			case "sheet2":
				
				with (sheetObj) {
					// 높이 설정
					
					if(sheetid=="sheet2"){
						style.height = 0;
					}else{
						style.height = 420;
					}
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					MultiSelection = false;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//var HeadTitle1 = "|Terminal|CSR No.|Invoice No.|Status|VVD|Account\nCode|Account Code\nDescription|Service\nProvider|Tariff\nCost|Adjustment\nCost|Amount|Formula|Expression|Remark";
					//var HeadTitle1 = "|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account Code|Account Code|Cost Code|Cost Code|Service Provider|Service Provider|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
					//var HeadTitle2 = "|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|CD|Des.|CD|Des.|CD|Des.|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
					
					if(document.form.date_type.value=="VVD") {
						var HeadTitle1 = "|ETD|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account\nCode|DESC|Cost\nCode|DESC|SP|DESC|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
						var HeadTitle2 = "|ETD|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account\nCode|DESC|Cost\nCode|DESC|CD|DESC|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
						
					}
					else if(document.form.date_type.value=="CR"){
						var HeadTitle1 = "|Invoice|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account\nCode|DESC|Cost\nCode|DESC|SP|DESC|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
						var HeadTitle2 = "|Created DT|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account\nCode|DESC|Cost\nCode|DESC|CD|DESC|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
						
					}
					else if(document.form.date_type.value=="IS"){
						var HeadTitle1 = "|Invoice|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account\nCode|DESC|Cost\nCode|DESC|SP|DESC|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
						var HeadTitle2 = "|Issue DT|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Berth\nDate|Account\nCode|DESC|Cost\nCode|DESC|CD|DESC|INV.NBR|Curr.|Tariff Cost|ADJ. Cost|INV.AMT|INV.AMT(USD)|Remark|Vessel Class|CSR No.|Status|Created ID||";
						
					}
								
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
					InitHeadMode(true, false, false, false, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

        			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,		    95,		daCenter,	true,	prefix+"con_dt",	        false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	true,	prefix+"vskd_port_rhq_cd",	false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"sls_ofc_cd",		false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"port_cd",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"yd_cd",				false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"vsl_slan_cd",		false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"vvd",				false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	prefix+"berth_date",		false,		"",			dfNone);

					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"acct_cd",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,   	70,		daLeft,		true,	prefix+"acct_eng_nm",		false,		"",			dfNone); //2014.12.29 DISPALY 막음
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"cost_cd",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,   	70,		daLeft,		true,	prefix+"cost_nm",			false,		"",			dfNone);// 2014.12.29 DISPALY 막음
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"vndr_seq",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daLeft,		true,	prefix+"vndr_lgl_eng_nm",	false,		"",			dfNone); //2014.12.29 DISPALY 막음	
					
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"inv_no",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"curr_cd",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	108,	daRight,	true,	prefix+"tariff_cost",		false,		"",			dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	108,	daRight,	true,	prefix+"adjust_cost",		false,		"",			dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	109,	daRight,	true,	prefix+"locl_amt",			false,		"",			dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	110,	daRight,	true,	prefix+"usd_amt",			false,		"",			dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,			50,		daLeft,		true,	prefix+"diff_rmk",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"vsl_clss",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"csr_no",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"status",			false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"cre_usr_id",		false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"iss_cty_cd",		false,		"",			dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		10,		daLeft,		true,	prefix+"so_seq",			false,		"",			dfNone);
					
					CountPosition = 2;
					
					RowHeight(0) = 20;
					RowHeight(1) = 20;
					
				}
				break;
        }
    }

 

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var prefix = "sheet1_";
		switch(sAction) {
			case IBSEARCH:      //조회
           		if(validateForm(sheetObj,formObj,sAction)){
           			if(!checkPeriod(formObj.from_date, formObj.to_date, "Y")){
        				return false;
        			}
           			
           			sheetObj.WaitImageVisible = false;
       	  			ComOpenWait(true);
           			formObj.f_cmd.value = SEARCH;
           			sheetObj.Redraw = false;
//	                sheetObj.DoSearch("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	                var sXml = sheetObj.GetSearchXml("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	                sheetObjects[0].LoadSearchXml(sXml);
	                sheetObj.Redraw = true;
	                ComOpenWait(false);
	                var comboItems = ComGetEtcData(sXml, "VSL_CLASS").split(ROWMARK);	//vsl Class
	                formObj.cntr_vsl_clss_capa.RemoveAll();         
	                addComboItemClass(formObj.cntr_vsl_clss_capa, comboItems);
				}
			break;
			
		  	case IBCLEAR:       //초기화 
				initSearchControls("CLEAR");
			break;
			
			case COMMAND06:	//Service Provider   
				formObj.f_cmd.value = COMMAND06;//
				var param = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
				var spName = ComGetEtcData(sXml, "spName");	//Service Provider Name
				formObj.vndr_lgl_eng_nm.value = spName;
			
				if(spName != ""){
			
				} else{
					ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
					//formObj.vndr_seq.focus();
					formObj.vndr_seq.value = "";
				}
			break;
			
			
			case SEARCH01:
				
    			if(!checkPeriod(formObj.from_date, formObj.to_date, "Y")){
    				return false;
    			}
       			
       			sheetObj.WaitImageVisible = false;
   	  			ComOpenWait(true);
       			formObj.f_cmd.value = SEARCH;
       			sheetObj.Redraw = false;
//	                sheetObj.DoSearch("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                var sXml = sheetObj.GetSearchXml("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&diff_rmk=Y&" + ComGetPrefixParam("sheet1_"));
                sheetObj.LoadSearchXml(sXml);
                sheetObj.Redraw = true;
                ComOpenWait(false);
				
                sheetObj.Down2Excel(1,false,true,true,"","",false,false,"Invoice Summary");
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
    		 		if(from_date.value == ''){
           				ComShowCodeMessage('PSO00003');
           				from_date.focus();
           				
           				return false;
           			}	
           			if(to_date.value == ''){
           				ComShowCodeMessage('PSO00003');
           				to_date.focus();
           				
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
    	 	case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	 		break;
    	 	case "num":
    	 		if(obj.name=="vndr_seq"){
    	    		ComKeyOnlyNumber(obj,",");
    	    	} else {
    	    		ComKeyOnlyNumber(obj);
    	    	}
    	        break;
   	        case "int":
   	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
   	            else ComKeyOnlyNumber(obj);
   	            break;
   	        case "float":
   	            ComKeyOnlyNumber(obj, "-.");
   	            break;
    	    case "eng":
    	        ComKeyOnlyAlphabet(); 
    	        break;
    	    case "engup":
    	        if( obj.name=="vsl_slan_cd" || obj.name=="csr_no" ){
    	        	ComKeyOnlyAlphabet('uppernum');
    	        } else if(obj.name=="inv_no"){
    	        	//ComKeyOnlyAlphabet('uppernum', "45");	//영대문자, 숫자, -
    	        } else{	
    	        	ComKeyOnlyAlphabet('upper');
    	        }
    	        break;
    	    case "engdn":
    	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
    	        else ComKeyOnlyAlphabet('lower');
    	        break;
    	    case "engupnumber":
    	    	ComKeyOnlyAlphabet('uppernum');
    	        break;
    	 }
     }
     
     
     
     /* 
      * Object 의 activate 이벤트에 대한 처리
      */
     function obj_activate(){
    	 var srcName = event.srcElement.name;
 		
 		switch(srcName){
 			case "from_date":
 			case "to_date":
 				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
 				event.srcElement.select();
 				break;
 		}
     }
     
//     function checkPeriod(){
//
//    	 var formObj = document.form;
//    	 var creDtFr = formObj.from_date.value;
//    	 var creDtTo = formObj.to_date.value;
//    	 
//    	 var i = 0;
//    	 
//    	 with(formObj){
//			if(creDtFr != '' && creDtTo != ''){
//				
//				if(creDtFr > creDtTo){
//					ComShowCodeMessage('COM12133','To date','From date','greater');
//					from_date.value='';
//					from_date.focus();
//					return false;
//				}
//				
//				//1년 이내
//				if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
//					ComShowCodeMessage('COM12133','Period','1 year','less');
//					//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
//					
//					from_date.value='';
//					from_date.focus();
//					return false;
//				}
//				return true;
//			}else{
//				return false;
//			}
//    	 }
//     }
     
     /**
      * 주어진 기간이 해당 기간이 맞는지 검사.
      * 
      * @param fmDtObj
      * @param toDtObj
      * @param periodType	D : 일, M : 월, Y : 년
      * @return
      */
     function checkPeriod(fmDtObj, toDtObj, periodType){
     	var fmDt = ComReplaceStr(fmDtObj.value, "-", "");
     	var toDt = ComReplaceStr(toDtObj.value, "-", "");
     	var tmpDt = ComGetDateAdd(fmDt, periodType, 1);
     	
     	if(fmDt > toDt){
     		ComShowCodeMessage('COM12133','To date','From date','greater');
     		fmDtObj.value='';
     		fmDtObj.focus();
			return false;
     	}
     	
     	if(ComChkPeriod(toDt, tmpDt) == 1){
     		return true;
     	}else{
     		ComShowCodeMessage('COM12133','Period','1 year','less');
     		fmDtObj.value='';
     		fmDtObj.focus();
			return false;
     	}
     }
        
     /** 2014.12.29 추가
      * 조회구분(Radio Button) Click Event
      */
     function chg_retrieve_cp() {
   		var formObj = document.form;
   		
   		if (formObj.s_retrieve_cp[0].checked) {
   			
   			for(var k=0;k<comboObjects.length;k++){  //2014.12.17 combo init 추가
   				if(k==3){
   				comboObjects[k].RemoveAll();}
   			}
   			
   			formObj.port_cd.value = "";
   			formObj.term_code.Enable   = false;
   			
   			ComEnableObject(formObj.btn_cnt_cd,true);
   			ComEnableObject(formObj.cnt_cd,true);
   			ComEnableObject(formObj.port_cd,false);
   			ComEnableObject(formObj.btn_port_cd,false);
   			
   		} else if(formObj.s_retrieve_cp[1].checked) {
   			formObj.term_code.Enable   = true;
   			formObj.cnt_cd.value = "";
   			
   			ComEnableObject(formObj.btn_cnt_cd,false);
   			ComEnableObject(formObj.cnt_cd,false);
   			ComEnableObject(formObj.port_cd,true);
   			ComEnableObject(formObj.btn_port_cd,true);
   			
   		}
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
    		 if(obj.name=="from_date" || obj.name=="to_date"){
    			 var creDtFr = ComReplaceStr(from_date.value,"-","");
    			 var creDtTo = ComReplaceStr(to_date.value,"-","");
	        	
    			 switch(obj.name) {
    			 case "from_date":
                 	formObj.from_date.value = ComGetMaskedValue(formObj.from_date.value, "ymd");
                 	break;
                 	
                 case "to_date":
                 	formObj.to_date.value = ComGetMaskedValue(formObj.to_date.value, "ymd");
                 	break;
	        	}
	        
    			ComChkObjValid(event.srcElement);
    		 }
    		 
    		 if(obj.name == "vndr_seq"){
 				if(obj.value != ""){
					doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
				} else{
					formObj.vndr_lgl_eng_nm.value = "";
				}
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
				}
			}
    	}
	}


	  
	/**
	  * INIT SETTING
	  */
	function initSearchControls(flag) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		  
		ComClearObject( formObj.port_cd );
		ComClearObject( formObj.term_code );
		ComClearObject( formObj.vsl_cd );
		ComClearObject( formObj.skd_voy_no );
		ComClearObject( formObj.skd_dir_cd );
		ComClearObject( formObj.date_type );
		
	

		formObj.vskd_port_rhq_cd.Text = "";
		formObj.sls_ofc_cd.Text = "";
		
		
			//formObj.differ.checked = false;
		formObj.vndr_seq.value = "";
		formObj.vndr_lgl_eng_nm.value = "";
		
//		ComClearObject( formObj.csr_no );
//		ComClearObject( formObj.inv_no );
		
		formObj.term_code.Text = "";	//Yard
		formObj.combo1.Text = "";		//Account
		formObj.cntr_vsl_clss_capa.Text = "";		//Vessel Class
//		formObj.status.Text = "";		//Status
	
		for(var k=0;k<comboObjects.length;k++){  //2014.12.29 combo init 추가
			comboObjects[k].RemoveAll();
		}
		formObj.s_retrieve_cp[1].checked= true;
		chg_retrieve_cp();
		
		
		setToday(formObj.from_date,"ymd");
    	setToday(formObj.to_date,"ymd");
    	sheetObjects[0].RemoveAll(); 
    	initControl(sheetObjects[0]);
    	sheet1_OnLoadFinish(sheetObjects[0]);
	}


    /**
     * VVD관련 데이터 설정 
     * @param obj
     * @return
     */
    function getVslCdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value = rtnDatas[1];
					sheetObjects[0].RemoveAll();
				}
			}
    	}
    }

	function getVvdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value = rtnDatas[2];
					document.form.skd_dir_cd.value = rtnDatas[3];
					sheetObjects[0].RemoveAll();
				}
			}
    	}
    }
        

    /**
     * VVD의 3항목에 한개라도 값이 셋팅되면 3개 모두 셋팅되어야 함을 체크 한다. 
     * @param formObj
     * @return
     */
    function checkVvd(formObj){
    	if( formObj.vsl_cd.value != "" 
          ||formObj.skd_voy_no.value != ""
          ||formObj.skd_dir_cd.value != "")
    	{
    		if(formObj.vsl_cd.value == "")
    		{
    			ComShowCodeMessage("PSO00031");
    			formObj.vsl_cd.focus();
    			return false;
    		}
    		else if(formObj.skd_voy_no.value == "")
    		{
    			ComShowCodeMessage("PSO00032");
    			formObj.skd_voy_no.focus();
    			return false;
    		}
    		else if(formObj.skd_dir_cd.value == "")
    		{
    			ComShowCodeMessage("PSO00033");
    			formObj.skd_dir_cd.focus();
    			return false;
    		}
    		else{
    			formObj.vvd.value = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
    			return true;
    		}
    	}
    	return true;
    }            



    /**
     * Combo Account
     */
    function combo1_OnChange(comb, Index_Code, Text){
		//콤보필드를 초기화시킨다.
		sheetObjects[0].RemoveAll();
    }

	/**
	 * Combo Account
	 */
    function combo1_OnKeyDown(comboObj, KeyCode, Shift){
    	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");	//숫자만 입력 가능
    } 
    
  
	 /**
	  * CTRL H/Q onchange
	  */
	 function vskd_port_rhq_cd_OnChange(comboObj, Index_Code, Text) {

		var sXml = doActionIBCombo(sheetObjects[0], document.form, COMMAND03);
			
		var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
		if(sCtrlOfc != null && sCtrlOfc != undefined){
			strText = ("ALL|"+sCtrlOfc).split("|");	//
		}

		//CTRL Combo Setting.
		appendMultiComboItem(document.form.sls_ofc_cd, strText, strText, "", "DEF");
	}
	 
    /**
     * vendor 팝업설정
     */
    function setVendorSeq(aryPopupData, row, col, sheetIdx){
    	var formObject = document.form;
    	formObject.vndr_seq.value = aryPopupData[0][2];
    	formObject.vndr_lgl_eng_nm.value = aryPopupData[0][4];
    }     
    
    /**
     * Combo Status
     */ 
    function initComboStatus(){
		/**
		 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
		 * IBMultiCombo의 item으로 insert 해준다.<br>
		 * <b>Example :</b>
		 * <pre>
		 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
		 * var arrData = ComXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
		 * </pre>
		 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
		 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
		 * @param {string} codeCol 필수, Combo의 Code컬럼명.
		 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
		 */
		var formObject = document.form; 
	    	var sXml = "<SHEET>"
					 + "	<DATA COLORDER='cd|nm|' COLSEPARATOR='☜☞' TOTAL='12'>"
					 + "		<TR><![CDATA[☜☞]]></TR>"
					 + "		<TR><![CDATA[1☜☞Confirmed]]></TR>"
					 + "		<TR><![CDATA[2☜☞CSR Approval Request]]></TR>"
					 + "		<TR><![CDATA[3☜☞A/P Interfaced]]></TR>"
					 + "		<TR><![CDATA[4☜☞Paid]]></TR>"
					 + "		<TR><![CDATA[5☜☞CSR Reject]]></TR>"
					 + "		<TR><![CDATA[6☜☞ERP A/P Reject]]></TR>"
					 + "		<TR><![CDATA[7☜☞A/P I/F Error]]></TR>"
					 + "		<TR><![CDATA[8☜☞CSR Cancel]]></TR>"
					 + "		<TR><![CDATA[9☜☞CSR Cancelled after Disapproval]]></TR>"
					 + "		<TR><![CDATA[10☜☞CSR Cancelled after ERP Reject]]></TR>"
					 + "		<TR><![CDATA[11☜☞Received]]></TR>"
					 + "	</DATA>"
					 + "</SHEET>";   
    	ComXml2ComboItem(sXml, formObj.status, "cd", "nm");
    }
     
  	/**
 	 * Mutil Combo에 item을 추가한다.
 	 * @param comboObj
 	 * @param optionCds
 	 * @param optionTxts
 	 * @param selCode
 	 * @return
 	 */
 	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
 		comboObj.RemoveAll();
 		
 		if(optionCdArr != null){
 			if(sFlag == "DEF"){
 				for(var i=0; i<optionCdArr.length; i++) {
 					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
 				}
 			}else{
 				for(var i=0; i<optionCdArr.length; i++) {
 					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
 				}
 			}
 	    	
 			comboObj.Code2 = selCode;
 		}
 	}     

 	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
// 		var prefix = sheetObj.id+"_";
// 		var Row = sheetObj.MouseRow;
// 		var Col = sheetObj.MouseCol;
// 		var colName = sheetObj.ColSaveName(Col);
// 		
// 		if(Row>=sheetObj.HeaderRows && Row!=sheetObj.LastRow && colName==prefix+"vvd"){
// 			var tipText = sheetObj.CellText(Row, prefix + "vsl_clss");
// 			sheetObj.MouseToolTipText = tipText;
// 		}else if(Row<sheetObj.HeaderRows || Row==sheetObj.LastRow ||
// 				(colName!=prefix+"acct_eng_nm" &&
// 						colName!=prefix+"cost_nm" &&
// 						colName!=prefix+"vndr_lgl_eng_nm" &&
// 						colName!=prefix+"diff_rmk")){
// 			sheetObj.MouseToolTipText = "";
// 		}else{
// 			var tipText = sheetObj.CellText(Row, Col);
// 			sheetObj.MouseToolTipText = tipText;
// 		}
// 		
 //위 부분 막고, tip 정보 변경 2014.12.29
 	      with(sheetObj) {
 	        	
 	        	var tip = "";
 	    		if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

 	    			if (ColSaveName(MouseCol) == "sheet1_acct_cd") {

 	    				tip += CellValue(MouseRow, "sheet1_acct_cd");			// ACCOUNT CD
 	    				tip += " - ";
 	    				tip += CellValue(MouseRow, "sheet1_acct_eng_nm");	//DESC
 	    			}
 	    			else if(ColSaveName(MouseCol) == "sheet1_cost_cd"){

 	    				tip += CellValue(MouseRow, "sheet1_cost_cd");			// Cost CD
 	    				tip += " - ";
 	    				tip += CellValue(MouseRow, "sheet1_cost_nm");	// DESC
 	    			  }
 	    			else if(ColSaveName(MouseCol) == "sheet1_vndr_seq") {

 	    				tip += CellValue(MouseRow, "sheet1_vndr_seq");			// VENDOR CD
 	    				tip += " - ";
 	    				tip += CellValue(MouseRow, "sheet1_vndr_lgl_eng_nm");	// DESC
 	    			  }
 	    			else {
 	    				tip = CellText(MouseRow, MouseCol);
 	    			}				
 	    		}
 	    		MouseToolTipText = tip;
 	    	}
 		
 	}
 	
 	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
 		var prefix = sheetObj.id + "_";
		var colName = sheetObj.ColSaveName(Col);
		var colWidth = sheetObj.ColWidth(Col);
		
		if(colName!=prefix+"acct_eng_nm" &&
				colName!=prefix+"cost_nm" &&
				colName!=prefix+"vndr_lgl_eng_nm"){
			return false;
		}
		
		switch(colName){
			case prefix+"acct_eng_nm":
				if(colWidth!=70){
					colWidth = 70;
				}else{
					colWidth = 0;
				}
				break;
			case prefix+"cost_nm":
				if(colWidth!=70){
					colWidth = 70;
				}else{
					colWidth = 0;
				}
				break;
			case prefix+"vndr_lgl_eng_nm":
				if(colWidth!=70){
					colWidth = 70;
				}else{
					colWidth = 0;
				}
				break;
		}
		sheetObj.ColWidth(colName) = colWidth;
 	}
 	
 	/**
	 * VOP_VSK-0202 Lance Code Help 팝업 창 오픈 
	 */
	function openLaneCode() {
		ComOpenPopup('/hanjin/VOP_VSK_0202.do', 420, 470, 'setLaneCode', '0,0',
				false, false);
	}
	
	function setLaneCode(aryPopupData, row, col, sheetIdx) {
		document.form.vsl_slan_cd.value = aryPopupData[0][1];
	}
	

	
	function term_code_OnCheckClick(comboObj, Index){
		setMultiCombo(comboObj, Index);
	}
	 
	function setMultiCombo(comboObj, index) {
		//All 인 경우
		if(index==0) {
			//checked
		    if(comboObj.CheckIndex(index)) {
		    	for(var i = 1 ; i < comboObj.GetCount () ; i++) {
		    		comboObj.CheckIndex(i) = true;
		    	}
		    } else {
		    	for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	      			comboObj.CheckIndex(i) = false;
	      		}
	      	}
	  //All 이 아닌 경우
	     } else {
	    	 var checkCnt = 0;
	    	 for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	    		 if(comboObj.CheckIndex(i)) {
	    			 checkCnt++;
	    		 }
	    	 }
	    	 if(checkCnt == comboObj.GetCount ()-1) {
	    		 comboObj.CheckIndex(0) = true;
	    	 }else{
	    		 comboObj.CheckIndex(0) = false;
	    	 }
	     }
	}
	/* 개발자 작업  끝 */