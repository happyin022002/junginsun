/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0139.js
*@FileTitle : Logistic Revenue TPB Invoice Creation - Single 
*Open Issues :
*Change history :
*@LastModifyDate :2015-02-15
*@LastModifier : Kim Hyun Ju
*@LastVersion : 1.16
* --------------------------------------------------------
* History
* 2015-02-26  불필요한주석 소스 정리-Kim Hyun Hwa
* 2015-03-10 [CHM-201534706] KIM HYUN HWA- Logistics(Operational) Revenue 에서 통화 관련 수정
*             1. loading 시 Login ofc setting 
*             2. Office별 Billing Currency 보완. USD,EUR 기본
*             3. Customer Type 구분
*2015.07.30 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정(8/22적용)             
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
     * @class ESD_TPB_0139 : ESD_TPB_0139 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0139() { 
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
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  //IBMultiCombo
  var comboObjects = new Array();
  var comboCnt = 0;
  var dtl_chk = 0;
  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */


  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  	}
  	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
  	
  	/**
  	 * Sheet 기본 설정 및 초기화 
  	 * body 태그의 onLoad 이벤트핸들러 구현
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	 */
  	var var_ofc_cd_timer; 
  	var interval = 2000; // initial condition
  	
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
		//html컨트롤 이벤트초기화
  		
		initControl();	
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
 		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
  		document.form.s_n3pty_expn_tp_cd.onchange = s_n3pty_expn_tp_cd_OnChange;
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		document.form.s_dtl_rmk.value = "Maximum 1,000 characters are allowed to leave as remarks.\n";
		ComBtnDisable("btn_recoveryactivity");

  	}
  	
  	function initControl() {		
		var formObj = document.form;

		axon_event.addListener('focus', 's_dtl_rmk_OnFocus', 's_dtl_rmk'); 
		axon_event.addListener('change', 's_if_ofc_cd_OnChange', 's_if_ofc_cd'); 
		axon_event.addListener('change', 's_curr_OnChange', 's_curr'); 
		
	    //Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ('blur', 			'obj_deactivate',  		formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리	
		axon_event.addListenerFormat('focus', 			'obj_activate'  ,  		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 		'obj_keypress'  , 		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리	    
	    axon_event.addListenerFormat('keyup', 			'obj_keyup'     ,  		formObj);
	}
	
    function obj_deactivate() {
    	var formObj = document.form;
		var obj = event.srcElement;
		
		if( obj.name == "s_dtl_amt" ){
	    	obj.value = obj.value.trim();
	    	if( obj.value != "" ) obj.value = ComAddComma2(ComTrimAll(obj.value,","), "#,###.00");
		}
    	
    	ComChkObjValid(obj);
    }
  
	function obj_activate() {
    	var formObj = document.form;
    	var obj = event.srcElement;
		ComClearSeparator(obj);  
	}
	
	function obj_keypress(){
		obj = event.srcElement;
		
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement,"-");
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engnum":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet('num');
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "int":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('int');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	}
	
	function obj_keyup() { 
		ComKeyEnter('lengthnextfocus');
	}
  	
  	function sleep(milliseconds) {
  		var start=new Date().getTime();
  		for(var i=0; i < 1e7; i++) {
  			if ( (new Date().getTime() - start )  > milliseconds ) {
  				break;
  			}
  		}
  	}
  	
  	function run_ofc_cd_timer() {
        clearInterval(var_ofc_cd_timer);
        if(interval > 15000 ){        
        	clearInterval(var_ofc_cd_timer);
        	alert("Fail to load Office List");
        	return false;
        }
        if(callback_populate_ofc_cd()){
        	clearInterval(var_ofc_cd_timer);
        	return false;
        }

        interval = interval * 1.5;
        var_ofc_cd_timer = setInterval(run_ofc_cd_timer, interval);

    }
  	

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					var cnt = 0;
  					style.height = 0;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 9);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(3, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  					
   					var HeadTitle1 = "Del.|STS|SEQ";
  					
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					
					//                [ROW ,COL	  ,DATATYPE     ,WIDTH ,DATAALIGN ,COLMERGE ,SAVENAME                 ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT ,EDITLEN ,FULLINPUT ,SORTENABLE ,TOOLTIP ,ALLCHECK ,SAVESTATUS ,FORMATFIX]
					InitDataProperty(0   ,cnt++   ,dtHidden     ,30    ,daLeft    ,true     ,""                       ,false    ,""         ,dfNone     ,0          ,true       ,true       ,1       ,false     ,false      ,""      ,false );
					InitDataProperty(0   ,cnt++   ,dtStatus     ,30    ,daCenter  ,true     ,"ibflag" );
					InitDataProperty(0   ,cnt++   ,dtSeq        ,30    ,daCenter  ,true     ,"seq" );
					
  					RowHeight (0) = RowHeight(1) = 0;
  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
//  		 if(curTab == 2)
//  			formObject = document.form2;
  	
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_3rdParty":
  					get3rdParty(formObject.s_vndr_cust_div_cd.value);
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					formObject.s_if_ofc_cd.Code = formObject.s_usr_ofc_cd.value ;
  					s_if_ofc_cd_OnChange();
  					// Save 버튼 보여준다
 					document.all.btn_save_t.style.display = '';
 					ComBtnDisable("btn_recoveryactivity");
  					break;
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.setDisplayType('date');
  					cal.select(formObject.s_sdate, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendar();
  					cal.setDisplayType('date');
  					cal.select(formObject.s_edate, 'yyyy-MM-dd');
  					break;
				case "btn_recoveryactivity":
					var read = "N"
					openRecoveryActPopup(formObject.s_n3pty_no.value, '', '', read);
					break;
				case "btn_yd":
					var param = '?loc_port_ind=1';
				    param = param+'&node_cd='+formObject.s_re_yd_cd.value;
					ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 820, 470, 'getYardCd', "1,0,1,1,1,1,1,1,1,1,1,1", true);
					break;
	 			   	
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBSAVE:
  				// Save Validation 들어 가야함.
  	
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				// Tpb no, invoice no 초기화
  				formObj.s_n3pty_no.value ="";
  				
  				// 저장 Operation
  				formObj.f_cmd.value = MULTI;
  				var sXml = sheetObj.GetSaveXml("ESD_TPB_0139GS.do", tpbFrmQryStr(formObj));
  				
				var sRtnN3ptyNo = "";
				var sRtnInvNo = "";
				
 				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
 				if ( State == "S" ) {
 					sRtnN3ptyNo =  ComGetEtcData(sXml,"s_n3pty_no");			// TPB No.
 	 				if (sRtnN3ptyNo == ""||sRtnN3ptyNo == "null"||sRtnN3ptyNo == null||sRtnN3ptyNo == undefined){
 	 					formObj.s_n3pty_no.value ="";
 	 				} else {
 	 					formObj.s_n3pty_no.value =sRtnN3ptyNo;
 	 				}
 	 				
					if (sRtnN3ptyNo == ""||sRtnN3ptyNo == "null"||sRtnN3ptyNo == null||sRtnN3ptyNo == undefined){
 						ComShowCodeMessage("COM130103", "Data");
 					} else {
 						ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
 						// Save 버튼 감준다.
 						document.all.btn_save_t.style.display = 'none';
 						ComBtnEnable("btn_recoveryactivity");
 					}
 				}else{
 				 	sheetObj.LoadSearchXml(sXml);
 				}
 				
  				break;
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert();
  				break;
  				
  			case IBCLEAR:	   //Clear
  				formObj.f_cmd.value = SEARCH11;
  				var sXml = sheetObj.GetSearchXml("ESD_TPB_0139GS.do", tpbFrmQryStr(formObj));
  				var sStr = ComGetEtcData(sXml,"cost_ofc_cd");
  				var arrStr = sStr.split("|");
  				MakeComboObject(formObj.s_if_ofc_cd,arrStr);
  				formObj.s_if_ofc_cd.Code = formObj.s_usr_ofc_cd.value ;
  				
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
  			case IBSEARCH_ASYNC02: 	//currency
  				formObj.f_cmd.value = SEARCH12;
  				sheetObj.WaitImageVisible = false;
  				var sXml = sheetObj.GetSearchXml("ESD_TPB_0139GS.do", tpbFrmQryStr(formObj));
  				return ComGetEtcData(sXml,"bil_curr_cd");
  				break;	
			case ADD: //ERP I/F    				
				formObj.f_cmd.value = ADD;
				div_processing_show(); // show processing image
				
				var sXml = sheetObj.GetSaveXml("ESD_TPB_0139GS.do", tpbFrmQryStr(formObj)); //alert("sXml:"+sXml);
				sheetObj.LoadSaveXml(sXml);
				div_processing_hide(); // hide processing image
				
				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
  			case IBSAVE:
  				if(!ComChkValid(formObj)) return false;
  					
  				// Select Combo
  				if(formObj.s_n3pty_expn_tp_cd.value == "" || formObj.s_n3pty_expn_tp_cd.value == "<<Select>>"){
  					ComShowCodeMessage("COM12113","Expense Type","","");
  					return false;
  				}
  				
  				if(formObj.s_n3pty_bil_tp_cd.value == "" || formObj.s_n3pty_bil_tp_cd.value == "<<Select>>"){
  					ComShowCodeMessage("COM12113","Logistic Rev. Code","","");
  					return false;
  				}

  				if(formObj.s_if_ofc_cd.value == "" || formObj.s_if_ofc_cd.value == "ALL"){
  					ComShowCodeMessage("COM12113","Cost Office","","");
  					return false;
  				}

  				if(formObj.s_curr.value == ""){
  					ComShowCodeMessage("COM12113","Currency","","");
  					return false;
  				}

  				if(formObj.s_trd_party_val.value == ""){
  					ComShowCodeMessage("COM130403","the 3rd Party","","");
  					return false;
  				}
  				
  				if(formObj.s_sdate.value == ""){
  					ComShowCodeMessage("COM130403","From Date","","");
  					return false;
  				}
  				
  				if(formObj.s_edate.value == ""){
  					ComShowCodeMessage("COM130403","To Date","","");
  					return false;
  				}
  				
  	  			var sdate = formObj.s_sdate.value;
  	  			var cdate = formObj.c_date.value;

  	  			var ret = ComGetDaysBetween(cdate, sdate) ;  
  	  		     if( ret > 0 ){
  	  		    	ComShowCodeMessage("TPB90113","From Date", "Current Date");
  	  		    	return false;
  	  		     }

  				if(formObj.s_dtl_amt.value == ""){
  					ComShowCodeMessage("COM130403","Amount","","");
  					return false;
  				}  				

  				if(formObj.s_dtl_rmk.value == ""){
  					ComShowCodeMessage("COM130403","Detail","","");
  					return false;
  				}  				

  				if(formObj.s_re_yd_cd.value == ""){
  					ComShowCodeMessage("COM130403","Yard","","");
  					return false;
  				}
 				
  				break;
  		}
  		
  		return true;
  	}


  	function getStaff_sheet_formail(rowArray, row, col){
  		var gubun = ':';
  		var user_id = '';
  		var user_email = '';

  		for(var i=0; i<rowArray.length; i++){
  			if(i == rowArray.length-1) gubun = '';

  			colArray = rowArray[i];
  			
  			user_id += colArray[0] + gubun;
  			user_email += colArray[1] + gubun;
  		}

  		var sheetObj = sheetObjects[0];

  		sheetObj.CellValue(row, 'toEmail') = user_email+";"+user_id;

  	}
  	
  	function getCheckN3ptyNo(formObj, sheetObj){
  	    
  		var str = '';
  		var temp = '';
  		if(sheetObj.RowCount > 0){
      		for ( var i=2; i < sheetObj.RowCount+2; i++ ){
      			//if(sheetObj.RowStatus(i) == 'U'){
      			temp = sheetObj.CellValue(i,'n3pty_no'); 
      			if ( temp.length==14 ){
      				str += temp+"|";
       			    temp = '';
      			}
      			//}
      		}
      		document.form.s_n3pty_no_strs_link.value = str;
  		} else {
  		    str = '';
  		}

  		if(str == ''){
  			ComShowCodeMessage('COM12176','','','');
  		}
  		
  		return str;
  	}
  	
  	/**
  	 * Expense Type 에 따라 changeBillingCase 호출
  	 */
  	function s_n3pty_expn_tp_cd_OnChange() {
  		changeBillingCase(document.form);
  	}
  	
  	/**
  	 * Expense Type 에 따라 Billing case 콤보를 만드는 함수
  	 */
 	function changeBillingCase(f){
  		var ifVal  = f.s_n3pty_if_tp_cd.value;				// R
  		var expVal = f.s_n3pty_expn_tp_cd.value;
  		

  		if(expVal == ""){
  			ComClearCombo(f.s_n3pty_bil_tp_cd);
  			ComAddComboItem(f.s_n3pty_bil_tp_cd, "<<Select>>", "");
  		}else{
  			var p_state = "1" ; // document.form.p_state.value;			// p_state 어떤거라고 생각하고 접근해야 하나?
  			
  			if(p_state == 1){
  				getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd"));
  			}else{
  				//alert("y");
  				getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_bil_tp_cd", "s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd", "s_jo_display"));
  			}
  			 
  		}
 	}
    
    function s_dtl_rmk_OnFocus(){
    	if(dtl_chk == 0){
    		document.form.s_dtl_rmk.value = "";
		}
    	
    	dtl_chk = 1;
    }
    
    // Vat 조회 
    function s_if_ofc_cd_OnChange(){
    	var formObj = document.form;
    	formObj.s_ofc_cd.value = formObj.s_if_ofc_cd.Code ; 
    	//formObj.s_rhq_cd.value = "HAMRU"; // "HAMUR" ; // EUR  Currency 추가
    	getTPBGenCombo('s_curr','searchCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", ""));
    }
	 
	// show processing image 
	function div_processing_show(){
		document.all.div_processing.style.display = ''; 
		// setTimeout("div_processing_hide();", 1000);
	}
		
	// hide processing image 
	function div_processing_hide(){
		document.all.div_processing.style.display = 'none'; 
	}

	function getYardCd(rowArray) {
		var colArray = rowArray[0];
		document.all.s_re_yd_cd.value =  colArray[3];   	
	}

	function setSelectBox(obj, value){
  		if(obj.length > 0){
  			for(var i = 0; i<obj.options.length; i++){
  				if(obj.options(i).value == value){
  					obj.options.selectedIndex = i;
  					
  				}
  			}
  		}
  	}
  	
	function MakeComboObject(cmbObj, arrStr) {
  	 	cmbObj.RemoveAll();   	 

  		for (var i = 1; i < arrStr.length;i++ ) {
  			var arrStr2 = arrStr[i].split("|");
  			if(arrStr2 != ""){
  				cmbObj.InsertItem(i-1, arrStr2, arrStr2);
  			}
  		}
  	 }
	
	
	/** 
	 * 콤보 초기설정값<br>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return 없음
     */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "s_if_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 150;
					ValidChar(2,1);
					MaxLength = 6;
					}
			break;
			
		}
  	}

/* 개발자 작업  끝 */