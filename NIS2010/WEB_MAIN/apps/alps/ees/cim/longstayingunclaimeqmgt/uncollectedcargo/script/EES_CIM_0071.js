/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_CIM_0071.js
*@FileTitle : Help Exchange
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
=========================================================*/

    /**
     * @extends 
     * @class EES_CIM_0071 : EES_CIM_0071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CIM_0071() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject         = setComboObject;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
	var curTab = 1;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var isReadOnly = "";
	
	/****** comboUtil start ********/
	var comboObjects = new Array();
	var comboCnt = 0 ;

	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		
		var formObj = document.form;
		axon_event.addListener('change', 	'frCurrCdCombo_change', 			'frCurrCdCombo'); 
	    	    
	}
	
	/**
	 * IBCombo Object를 배열로 등록 
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
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
  	
  	/**
  	 * Sheet 기본 설정 및 초기화 
  	 * body 태그의 onLoad 이벤트핸들러 구현
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	 */
  	function loadPage() {
  		var formObj = document.form;
  		isReadOnly = document.form.s_readonly.value;
  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
  	    /* IBMultiCombo 초기화 */
  	 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
  	 		initCombo(comboObjects[k], k+1);
  	 	}
  	 	
  	 	initControl();
  		 
  	 	/* 통화코드 Combo 호출 */
  		getExchangeCdListCombo();
  		/* 오픈시 조회 */
  		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
  		 
  		//INV, CRNT 일 경우 변환 환율을 USD로 고정
  		if (formObj.exch_pop_gb.value == "INV" || formObj.exch_pop_gb.value == "CRNT") {
  			formObj.toCurrCdCombo.enable = false;
  			formObj.toCurrCdCombo.readonly = true;
  		}
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  		case 1:      
  			with (sheetObj) {
  				//세로높이설정
  				style.height = 0;//400 ;
  				//전체 너비 설정
  				SheetWidth = 0;//200
  				//Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  				//전체Merge 종류 [선택, Default msNone]
  				MergeSheet = msAll;
  				//전체Edit 허용 여부 [선택, Default false]
  				Editable = true;
  				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  				InitRowInfo( 1, 1, 10, 100);
  				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  				InitColumnInfo(5, 0, 0, true);
  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
  				InitHeadMode(true, true, false, true, false,false)

  				var HeadTitle = "ACCT_XCH_RT_YRMON|CURR_CD|CNT_CD|USD_LOCL_XCH_RT|LOCL_KRW_XCH_RT" ;

  				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//데이터속성     [ROW,     COL,   DATATYPE,WIDTH, DATAALIGN, COLMERGE, SAVENAME, 			 KEYFIELD, CALCULOGIC, 	 DATAFORMAT, POINTCOUNT,  UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0, cnt++ , dtHidden,     100,  daLeft,   	false,     "acct_xch_rt_yrmon", false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       100,  daLeft,   	false,     "curr_cd",       	false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       100,  daLeft,   	false,     "cnt_cd",       		false,         "",       dfNone,           	0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       120,  daRight,	false,     "usd_locl_xch_rt",	false,         "",       dfNone,   			0,     false,     false,	8);
  				InitDataProperty(0, cnt++ , dtData,       120,  daRight,   	false,     "locl_krw_xch_rt",   false,         "",       dfNone,           	0,     false,     false,	8);

  				WordWrap = true;
  			}
  			break;
  			
    	case 2 :
    		with (sheetObj) {
    			style.height = 0; // 높이 설정
    			SheetWidth = 0; //전체 너비 설정
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
    			MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
    			Editable = false; //전체Edit 허용 여부 [선택, Default false]
    			InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitColumnInfo(1, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false,false)

    			var HeadTitle0 = "mutistatus";

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle0, true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "mutistatus", false, "", dfNone, 0, false, false);						
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
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
				/* [Exchange Date] */
				case "btns_onecalendar":
					var cal = new ComCalendar();
					//cal.displayType = "date";
					cal.setDisplayType('month');
	        		cal.select(formObject.s_acct_xch_rt_yrmon, 'yyyy-MM');
	        		break;
  				case "btn_cal":
//  					var cal_fr_curr_cd = formObject.s_fr_curr_cd.value;
  					var cal_fr_curr_cd = formObject.frCurrCdCombo.Text;
  					var cal_fr_curr_nm = "";
  					var cal_fr_curr_lcl_usd_rt = "";
  					var cal_fr_curr_amt = ComRound(ComTrimAll(formObject.s_fr_curr_amt.value,","));	// 소수점2자리까지 계산(소수점3자리에서 반올림)
//  					var cal_to_curr_cd = formObject.s_to_curr_cd.value;
  					var cal_to_curr_cd = formObject.toCurrCdCombo.Text;
  					var cal_to_curr_amt = 0;
  					var cal_to_curr_rt = 0;
  					var cal_fr_curr_cnt = 0;
  					var cal_to_curr_cnt = 0;
  					
  					if(ComIsNull(cal_fr_curr_cd)) {
  						ComShowCodeMessage("CIM21001", " Exchange Code");
  						return false;
  					}
  					
  					if(ComIsNull(cal_fr_curr_amt)) {
  						ComShowCodeMessage("CIM21001", " Exchange Amount");
  						return false;
  					}

  		  			for(var idx=1;idx<=sheetObject.RowCount;idx++){
//  		  			if(cal_fr_curr_cd == sheetObject.CellValue(idx,"cnt_cd")){
  		  				if(cal_fr_curr_cd == sheetObject.CellValue(idx,"curr_cd")){
  		  					cal_fr_curr_cnt++;
  		  					cal_fr_curr_nm = sheetObject.CellValue(idx,"curr_cd");
  		  					cal_fr_curr_amt = cal_fr_curr_amt * sheetObject.CellValue(idx,"locl_krw_xch_rt");
  		  					cal_fr_curr_lcl_usd_rt = sheetObject.CellValue(idx,"usd_locl_xch_rt");
  		  				}
  		  			}
  		  		
  		  			for(var idx=1;idx<=sheetObject.RowCount;idx++){
//  		  			if(cal_to_curr_cd == sheetObject.CellValue(idx,"cnt_cd")){
  		  				if(cal_to_curr_cd == sheetObject.CellValue(idx,"curr_cd")){
  		  					cal_to_curr_cnt++;
  		  					cal_to_curr_rt = sheetObject.CellValue(idx,"locl_krw_xch_rt");
  		  					cal_to_curr_amt = (cal_fr_curr_amt / cal_to_curr_rt);
  		  				}
  		  			}
  		  			
  					if(cal_fr_curr_cnt == 0) {
  						ComShowCodeMessage("CIM30036");
  						return false;
  					}

  					if(cal_to_curr_cnt == 0) {
  						ComShowCodeMessage("CIM30036");
  						return false;
  					}
  		  			
  		  			formObject.s_to_curr_amt.value = cal_to_curr_amt;
  		  			formObject.s_to_curr_amt.value = ComAddComma2(ComRound(formObject.s_to_curr_amt.value), "#,###");
  		  			formObject.s_to_curr_rt.value = ComAddComma2(cal_fr_curr_lcl_usd_rt, "#,###.00");
  		  			
  		  			formObject.s_fr_curr_nm.value = cal_fr_curr_nm;

  					break;
  				case "btn_ok":
  					if (formObject.s_to_curr_amt.value == "" || formObject.s_to_curr_amt.value == null || formObject.s_to_curr_amt.value == "0"){
  						if(formObject.exch_pop_gb.value == "INV"){
  	  						window.dialogArguments.document.form.uc_inv_curr_cd.value = "";
  	  						window.dialogArguments.document.form.uc_inv_amt.value = "";
  	  						window.dialogArguments.document.form.uc_inv_xch_rt.value = "";
  	  						window.dialogArguments.document.form.uc_inv_usd_amt.value = "";
  	  					}else if(formObject.exch_pop_gb.value == "CRNT"){
  	  						window.dialogArguments.document.form.uc_crnt_curr_cd.value = "";
  	  						window.dialogArguments.document.form.uc_crnt_amt.value = "";
  	  						window.dialogArguments.document.form.uc_crnt_xch_rt.value = "";
  	  						window.dialogArguments.document.form.uc_crnt_usd_amt.value = "";
  	  					}
  					} else {
  						if(formObject.exch_pop_gb.value == "INV"){
  	  						window.dialogArguments.document.form.uc_inv_curr_cd.value = formObject.s_fr_curr_nm.value;
  	  						window.dialogArguments.document.form.uc_inv_amt.value = formObject.s_fr_curr_amt.value;
  	  						if(null==formObject.s_to_curr_rt.value || formObject.s_to_curr_rt.value ==""){
  	  							window.dialogArguments.document.form.uc_inv_xch_rt.value = formObject.s_to_curr_rt.value;
  	  						}else{
  	  							window.dialogArguments.document.form.uc_inv_xch_rt.value = ComAddComma2(formObject.s_to_curr_rt.value, "#,###.00");
  	  						}
  	  						window.dialogArguments.document.form.uc_inv_usd_amt.value = formObject.s_to_curr_amt.value;
  	  					}else if(formObject.exch_pop_gb.value == "CRNT"){
  	  						window.dialogArguments.document.form.uc_crnt_curr_cd.value = formObject.s_fr_curr_nm.value;
  	  						window.dialogArguments.document.form.uc_crnt_amt.value = formObject.s_fr_curr_amt.value;
  	  						window.dialogArguments.document.form.uc_crnt_xch_rt.value = formObject.s_to_curr_rt.value;
  	  						window.dialogArguments.document.form.uc_crnt_usd_amt.value = formObject.s_to_curr_amt.value;
  	  					}
  					}
  					window.close();	
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage("COM12111");
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case SEARCH01:	  //조회
  			 if(validateForm(sheetObj,formObj,sAction)){
  				 formObj.f_cmd.value = SEARCH01;
  				 sheetObj.DoSearch4Post("EES_CIM_0071GS.do", FormQueryString(formObj));
  			 }
  			 calculate();
  			 break;
  		}
  	}
  	
  	function retrieveEnd(sheetObj){
  		var cnt = sheetObj.RowCount;
  		var idx;
  	}
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		var acct_xch_rt_yrmon_trim = ComTrimAll(ComTrimAll(formObj.s_acct_xch_rt_yrmon.value, " "), "-");
    		if( acct_xch_rt_yrmon_trim != "" ) { //날짜 체크하는 부분
    			if( !ComIsDate(acct_xch_rt_yrmon_trim, "ym") ) {
    				ComShowCodeMessage("CIM30035");
    				formObj.acct_xch_rt_yrmon.focus();
    				return false;
    			}
    		}
    	}
    	formObj.acct_xch_rt_yrmon.value = acct_xch_rt_yrmon_trim; 
    	return true;
    }  	

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		
	   	 if( sheetObj.RowCount == 0 ){
	   		 ComShowCodeMessage("CIM30037",document.form.s_acct_xch_rt_yrmon.value);
			 return;
		 }

  		if(errMsg!=null){
  			ComShowMessage(errMsg);
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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
    */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * 통화코드 Combo 속성 설정 - frCurrCdCombo_OnBlur
     **/
    function frCurrCdCombo_OnBlur(comboObj, Index_Code, Text) {
    	var formObj = document.form;
		if(ComIsNull(ComGetObjValue(comboObj))) {
			ComShowCodeMessage("CIM30036");
			return;
		}
	   	 
    	formObj.s_fr_curr_cd.value = ComGetObjValue(comboObj);
    	calculate();
    }

    /**
     * 통화코드 Combo 속성 설정 - frCurrCdCombo_OnBlur
     **/
    function frCurrCdCombo_change() {
    	var formObj = document.form;
    	with (formObj) {
    		s_fr_curr_amt.value = "0.00";
    		calculate();
    	}
    }

    /**
     * 통화코드 Combo 속성 설정 - toCurrCdCombo_OnBlur
     **/
    function toCurrCdCombo_OnBlur(comboObj, Index_Code, Text) {
    	var formObj = document.form;
		if(ComIsNull(ComGetObjValue(comboObj))) {
			ComShowCodeMessage("CIM30036");
			return;
		}
    	formObj.s_to_curr_cd.value = ComGetObjValue(comboObj);
    	calculate();
    }
    
    /**
     * 통화코드 Combo 셋팅
     **/  
    function getExchangeCdListCombo()
   {
   	  var formObj = document.form;
   	  var TySzList = getExchangeCdList(sheetObjects[1], formObj);	  
   	  var TySzArray = new Array();	  	 
   	  TySzArray = TySzList.split("|");
   	  document.frCurrCdCombo.RemoveAll();
   	  document.toCurrCdCombo.RemoveAll();
   	  for(var i=0; i<TySzArray.length; i++)
   	  {
   		  document.frCurrCdCombo.InsertItem(i, TySzArray[i].substring(3), TySzArray[i].substring(0,2));
   		  document.toCurrCdCombo.InsertItem(i, TySzArray[i].substring(3), TySzArray[i].substring(0,2));
   	  }
   	  
   	  document.toCurrCdCombo.Index=58;
   	  document.form.s_to_curr_cd.value = 'US';
   }
   
   /**
    * 통화코드 Combo 조회
    **/
    function getExchangeCdList(sheetObj, formObject)
    {
    	 sheetObj.WaitImageVisible  = false;
    	 formObject.f_cmd.value = SEARCH02;
    	 var queryString = FormQueryString(formObject);
    	 sheetObj.DoRowSearch("EES_CIM_0071GS.do", queryString);
    	 sheetObj.WaitImageVisible  = true;
    	 return sheetObj.EtcData('MUTI_STATUS');
    }  
   
    /**
     * 통화코드 Combo 속성 설정
     **/
    function initCombo (comboObj, comboNo) {
  		 switch(comboObj.id) {
  		   	 case "frCurrCdCombo":
  					with(comboObj) {
  						DropHeight = 150;
  						MultiSelect = false;
  						UseAutoComplete = true;
  						MultiSeparator = ",";
  						Style = 0;
  						ValidChar(2,3);
  					}
  				break;
  		   	 case "toCurrCdCombo":
  					with(comboObj) {
  						DropHeight = 150;
  						MultiSelect = false;
  						UseAutoComplete = true;
  						MultiSeparator = ",";
  						Style = 0;
  					}
  				break;
  		 }      	
  	}
    

    /**
     * Exchange Date 속성 설정 - 년월 변경시 조회 호출
     **/
    function acct_xch_rt_yrmon_change() {
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    }    

    /**
     * 금액 속성 설정 - 금액 변경시 calculate() 호출
     **/
    function fr_curr_amt_change(obj){
    	if (obj.readOnly==true){return false;}
    	
    	obj.value = obj.value.trim();
    	document.form.s_fr_curr_amt.value = ComAddComma2(ComTrimAll(obj.value,","), "#,###");
    	calculate();
    }    
    
    /**
     * 금액 INPUT BOX 속성설정 - 통화만 -> 숫자,.까지  + 소숫점 이하 2자리만 허용
     **/
    function isMon(obj, isChkFmt){
    	if (!ComIsNumber(obj,'-.,')){
    		obj.value = '';
    	}

    	if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
    		var src = ComTrimAll(obj.value);
    		if (src.indexOf('.') != -1){
    			if (src.length-1 > src.indexOf('.')+2){
    				src = src.substring(0,src.indexOf('.')+3);
    				obj.value = src;
    			}
    			if (src.indexOf('.') != src.lastIndexOf('.')){
    				src = src.substring(0,src.lastIndexOf('.'));
    				obj.value = chkAmtFmt(src);
    			}
    		}
    	}
    }
    
    /**
     * calculate
     **/
	function calculate() {
			var sheetObject = sheetObjects[curTab-1];
			var formObject = document.form;
//			var cal_fr_curr_cd = formObject.s_fr_curr_cd.value;
			var cal_fr_curr_cd = formObject.frCurrCdCombo.Text;
//			alert(formObject.frCurrCdCombo.Text);
			var cal_fr_curr_nm = "";
			var cal_fr_curr_lcl_usd_rt = "";
			var cal_fr_curr_amt = ComRound(ComTrimAll(formObject.s_fr_curr_amt.value,","));	// 소수점2자리까지 계간(소수점3자리에서 반올림)
			
//			var cal_to_curr_cd = formObject.s_to_curr_cd.value;
			var cal_to_curr_cd = formObject.toCurrCdCombo.Text;
//			alert(formObject.toCurrCdCombo.Text);
			var cal_to_curr_amt = 0;
			var cal_to_curr_rt = 0;
			var cal_fr_curr_cnt = 0;
			var cal_to_curr_cnt = 0;
			
//			if(!ComIsNull(cal_fr_curr_cd) && !ComIsNull(cal_fr_curr_amt)) {
			if(!ComIsNull(cal_fr_curr_cd)) {
	  			for(var idx=1;idx<=sheetObject.RowCount;idx++){
//	  				if(cal_fr_curr_cd == sheetObject.CellValue(idx,"cnt_cd")){
					if(cal_fr_curr_cd == sheetObject.CellValue(idx,"curr_cd")){
	  					cal_fr_curr_cnt++;
	  					cal_fr_curr_nm = sheetObject.CellValue(idx,"curr_cd");
//	  					alert("cal_fr_curr_amt : " + sheetObject.CellValue(idx,"locl_krw_xch_rt"));
	  					cal_fr_curr_amt = cal_fr_curr_amt * sheetObject.CellValue(idx,"locl_krw_xch_rt");
	  					cal_fr_curr_lcl_usd_rt = sheetObject.CellValue(idx,"usd_locl_xch_rt");
	  				}
	  			}
//	  			alert("cal_fr_curr_amt (t) : " + cal_fr_curr_amt);
	  			for(var idx=1;idx<=sheetObject.RowCount;idx++){
//	  				if(cal_to_curr_cd == sheetObject.CellValue(idx,"cnt_cd")){
  					if(cal_to_curr_cd == sheetObject.CellValue(idx,"curr_cd")){
	  					cal_to_curr_cnt++;
	  					cal_to_curr_rt = sheetObject.CellValue(idx,"locl_krw_xch_rt");
//	  					alert("cal_to_curr_rt : " + cal_to_curr_rt);
	  					cal_to_curr_amt = (cal_fr_curr_amt / cal_to_curr_rt);
	  				}
	  			}
	  			formObject.s_to_curr_amt.value = cal_to_curr_amt;
	  			formObject.s_to_curr_amt.value = ComAddComma2(ComRound(formObject.s_to_curr_amt.value), "#,###");
	  			formObject.s_to_curr_rt.value = ComAddComma2(cal_fr_curr_lcl_usd_rt, "#,###");			// Local 의 USD 환율
	  			formObject.s_fr_curr_nm.value = cal_fr_curr_nm;
			}
	}
    