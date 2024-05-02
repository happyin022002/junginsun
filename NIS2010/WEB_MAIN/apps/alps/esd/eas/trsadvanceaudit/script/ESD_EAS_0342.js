/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ESD_EAS_0342.js
*@FileTitle : TRS Pre-Audit Criterion setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015-5-4
*@LastModifier : Moon-Seok Jang
*@LastVersion : 1.0
* 2015-5-4 Moon-Seok Jang
* 1.0 최초 생성
*  
=========================================================*/

	function ESD_EAS_0342() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.initCombo				= initCombo;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var formObj = "";
	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObj, MODIFY01);
				break;
			case "btn_new":
				init_form();
				break;				
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btng_addoffice":
				doActionIBSheet(sheetObject,formObj,"btng_addoffice");
				break;
			case "btng_deloffice":
				doActionIBSheet(sheetObject,formObj, REMOVE01);
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
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
		var formObj = document.form;
		var usrId = formObj.login_usr_id.value;
//		비용심사 파트장 성범수 부장 :  사번 9100342
//  	비용심사 시스템 B/A 김대준 차장 : 사번  0010140
		if(usrId !="9100342" && usrId!="0010140"){
			ComBtnDisable("btn_save"); // Save 버튼 비활성화
		}
		for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);

			ComEndConfigSheet(sheetObjects[i]);
		}
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}

	    doActionIBSheet(sheetObjects[1], formObj, "offce_level"); // RHQ
	    
	    doActionIBCombo(formObj.s_cgo_tp_cd); // Cargo Type
	    doActionIBCombo(formObj.s_trsp_crr_mod_cd); // Trans Mode
	    doActionIBCombo(formObj.s_expn_aud_crte_tp_cd); // Type
	    doActionIBCombo(formObj.i_expn_aud_crte_tp_cd); // Type
		//html컨트롤 이벤트초기화
		initControl();

	}


	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  			axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
  		    axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//  		axon_event.addListenerForm  ('keyup', 'obj_keyup', form);
  	}
  	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "i_ofc_cd":
				check_available_office();
			break;

		}
	} 
	/**
	* HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
	*/
	function obj_keypress(){
		var srcName = event.srcElement.getAttribute("name");
		var srcValue = event.srcElement.getAttribute("value");
		
		switch(event.srcElement.dataformat){
			case "engup":		//영문대문자
				ComKeyOnlyAlphabet('upper');
			break;
			
			case "engupnum":	//숫자+영문대분자 입력하기
				ComKeyOnlyAlphabet('uppernum');
			break;
			
			case "engnum":		//숫자+영문대소 입력하기
				ComKeyOnlyAlphabet('num'); 
			break;
			case "float":       //실수 입력하기
				ComKeyOnlyNumber(event.srcElement, "-.");
			break;			
			
			case "engupcomma":	//영문대문자+Comma
				ComKeyOnlyAlphabet('upper', '44');
			break;
			
			case "engupnumcomma":	//숫자+영문대분자+Comma
				ComKeyOnlyAlphabet('upper', '44|48|49|50|51|52|53|54|55|56|57');
			break;

			default:
		}
	}		
	
	/**
	 * Responsible Office, KPI Office 에 값이 존재하는지 체크 한다.
	 * responsible_office_change() 함수 :  Responsible Office 만 체크
	 * check_available_office() 함수 : Responsible Office, KPI Office 체크 
	 */
	function  check_available_office(){
	    
	    if(formObj.i_ofc_cd.value ==""){
			return ;
		}else{
			formObj.respb_ofc_cd.value =formObj.i_ofc_cd.value; 
		}
		
		formObj.f_cmd.value = SEARCH07;
		var sXml=sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
		var isflag = EasXmlString(sXml,"isflag");
		isflag = isflag.split("|");
		if (isflag[0] == 0) {
			ComShowCodeMessage('COM132202', 'Office'); 	//사용할수 없는 Office  입니다.
			formObj.respb_ofc_cd.value="";
			formObj.i_ofc_cd.value="";
		}else{
			formObj.rhq_ofc_cd.value = EasXmlString(sXml,"rhq_ofc_cd");
		}
	}
	

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {

			case 1:	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
	                style.height = 400 ;
	                
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 14, 10);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "|Seq.|Module|RHQ|Office|Type|Cargo\nType|Trans\nMode|Description|Object of\nAuto Audit|Max\nPermissible\nRatio (%)|Update\nBy|Update\nDate|Remark";
					var HeadCount = ComCountHeadTitle(HeadTitle);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(HeadCount, 0, 0, true);
					
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,      COLMERGE,     SAVENAME,                 KEYFIELD,      CALCULOGIC,      DATAFORMAT,         POINTCOUNT,           UPDATEEDIT,      INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, 	dtHiddenStatus,  10,     daCenter, 			true,    "ibflag");
					InitDataProperty(0, cnt++, 	dtSeq,	         30,	 daCenter, 			true,	 "seq");
					InitDataProperty(0, cnt++, 	dtData,          50,     daCenter, 			true,    "mdl_cd",            	      false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtData,          60,     daCenter, 			true,    "rhq_ofc_cd",            	  false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtData,          60,     daCenter, 			true,    "aud_ofc_cd",           	  false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtCombo,         100,    daCenter, 			true,    "expn_aud_crte_tp_cd",       false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtCombo,         80,     daCenter, 			true,    "cgo_tp_cd",           	  false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtData,          60,     daCenter, 			true,    "trsp_crr_mod_cd",           false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);;
					InitDataProperty(0, cnt++, 	dtData,          100,    daLeft, 			true,    "trsp_crr_mod_nm",           false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtCheckBox,      80,     daCenter, 			true,    "expn_aud_tgt_flg",          false,          "",       		dfNone,    				0,     				true,       	true,			 1,			false,			true,	   				"",	  		true);
					InitDataProperty(0, cnt++, 	dtData,          80,     daRight, 			true,    "expn_max_prmt_rto",         false,          "",       		dfNullInteger,    		0,     				true,       	true,			 5,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtData,          70,     daCenter, 			true,    "cre_ofc_cd",          	  false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtData,          80,     daCenter, 			true,    "upd_dt",          	      false,          "",       		dfNone,    				0,     				false,       	false,			 0,			false,			true,	   				"",	  		false);
					InitDataProperty(0, cnt++, 	dtData,          100,    daLeft, 			true,    "expn_prmt_rto_rsn",         false,          "",       		dfNone,    				0,     				true,       	true,			 500,		false,			true,	   				"",	  		false);
	                InitDataCombo(0, "expn_aud_crte_tp_cd",  expn_aud_crte_tp_cdText, expn_aud_crte_tp_cdCode);
	            	InitDataCombo(0, "cgo_tp_cd",  cgo_tp_cdText, cgo_tp_cdCode);
				}
				break;

		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

		    case IBSEARCH:
//				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCHLIST01;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0342GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
//				}
				break;	
		    case "btng_addoffice":
				if(validateForm(sheetObj,formObj,sAction)){
					makeAddOffice();
				}
		    	break;	
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
				
			case MODIFY01:	// Save
				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY01;
				sheetObj.DoSave("ESD_EAS_0342GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
				break;

			case REMOVE01:	// Delete
				if(validateForm(sheetObj,formObj,sAction)){
					
		        	if (!ComShowCodeConfirm("COM12165", "Office")) {
		        		return false;
		        	}
		        	
					ComOpenWait(true);
					formObj.f_cmd.value = REMOVE01;
		         	var params = FormQueryString(formObj);
		         	var sXml = sheetObj.GetSaveXml("ESD_EAS_0342GS.do", params);
					sheetObj.LoadSaveXml(sXml);
					ComOpenWait(false);
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}	
				break;				
			
			case "offce_level":    
				formObj.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
        		formObj.ofclevel.value = ofcLevel;

        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		var rhqSearchFlag = true;
        		// 로그인한 RHQ OFFCD 셋팅
        		formObj.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
        		// 로그인한 OFFCD 셋팅
        		formObj.s_ofc_cd.InsertItem(0, formObj.ofc_cd.value, formObj.ofc_cd.value);
        		if(ofcLevel=="O"){
        			// 본사(심사팀) RHQ 소속이외
            		rhqSearchFlag = false;
            		formObj.s_rhq_ofc_cd.Enable=false;
            		formObj.s_ofc_cd.Enable=false;  
            		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		formObj.s_ofc_cd.code2 = formObj.ofc_cd.value; 
        		}else if(ofcLevel=="R"){
        			rhqSearchFlag = false;
        			formObj.s_rhq_ofc_cd.Enable=false;
        			formObj.s_ofc_cd.Enable=true;        			
        			formObj.s_rhq_ofc_cd.Index2=0;
        			doActionIBCombo(formObj.s_rhq_ofc_cd)
        		}else if(ofcLevel=="H"){
        			// 본사(심사팀) 소속
            		rhqSearchFlag = true;
            		formObj.s_rhq_ofc_cd.Enable=true;
            		formObj.s_ofc_cd.Enable=true;              
            		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		formObj.s_ofc_cd.code2 = formObj.ofc_cd.value;
//            		ComBtnEnable("btn_save"); // Save 버튼 활성화
        		}
        		if(rhqSearchFlag){
        			// RHQ 콤보 리스트 조회
        			formObj.s_rhq_ofc_cd.RemoveAll();
        			formObj.f_cmd.value = COMMAND02;
        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        			ComXml2ComboItem(sXml, formObj.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
        			// 이폼에서는 권한 체크를 하지 않는다.
        			formObj.s_rhq_ofc_cd.Text2(formObj.ofc_cd.value);
        			formObj.s_rhq_ofc_cd.InsertItem(0, "", "");
	        		// RHQ에 해당하는 Office 조회
        			doActionIBCombo(formObj.s_rhq_ofc_cd);
        		}
	  		break; 	
				

		}
	}
	
    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	formObj = document.form;
    	switch(comboObj.id) {
	    case "s_rhq_ofc_cd":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        formObj.s_ofc_cd.RemoveAll();
	    	ComXml2ComboItem(sXml, formObj.s_ofc_cd, "ofc_cd", "ofc_cd");	//(데이터, 누구한테 던져주는 대상, 칼럼코드명, 컬럼이름)
	    	formObj.s_ofc_cd.InsertItem(0, "", "");
	    	formObj.s_ofc_cd.code2 = formObj.s_ofc_cd.value
	    	doActionIBCombo(formObj.s_ofc_cd)
	    	break;  
	    case "s_cgo_tp_cd":
	    	searchCommonCombo("CD00748",formObj.s_cgo_tp_cd);
	    	formObj.s_cgo_tp_cd.InsertItem(0, "", "");
	    	break;  
	    case "s_trsp_crr_mod_cd":
//	    	formObj.s_trsp_crr_mod_cd.SetColWidth("80");
//	    	formObj.s_trsp_crr_mod_cd.DropHeight = 180;
	    	searchCommonCombo("CD00283",formObj.s_trsp_crr_mod_cd);
	    	formObj.s_trsp_crr_mod_cd.InsertItem(0, "", "");
	    	break;  
	    case "s_expn_aud_crte_tp_cd":
	    	searchCommonCombo("CD03413",formObj.s_expn_aud_crte_tp_cd);
	    	formObj.s_expn_aud_crte_tp_cd.Index2 = 0
	    	break;  
	    case "i_expn_aud_crte_tp_cd":
	    	searchCommonCombo("CD03413",formObj.i_expn_aud_crte_tp_cd);
	    	formObj.i_expn_aud_crte_tp_cd.Index2 = 0
	    	break;  
        }
    }
    
	// 공통테이블에 등록된 코드값을 조회 한다.    
	function searchCommonCombo(codeKey,comboObj){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH01;
		// 공통 테이블에서 조회할 키
		formObj.code_key.value = codeKey
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
	}    
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){ 

	}
	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){ 
		if(formObj.f_cmd.value == SEARCHLIST01){
			if(sheetObj.RowCount == 0 && ComGetObjValue(formObj.s_ofc_cd) != "" ){
				ComShowCodeMessage("EAS90210", ComGetObjValue(formObj.s_ofc_cd));
			}
		}
	}
	
	/**
	 * 화면 로딩시 콤보조회 
	 */
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0], formObj, COMMAND01);	//Account Combo
		doActionIBSheet(sheetObjects[0], formObj, COMMAND02);	//Cost Combo
		doActionIBSheet(sheetObjects[0], formObj, COMMAND03);	//RHQ Combo
	}
	
	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			
			//IBMultiCombo 설정
			for(var k = 0; k < comboObjects.length; k++){
				comboObjects[k].Index = 0;
			}
			
			sheetObj.RemoveAll();
			formObj.reset();
	}

	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
	
		switch (eleObj.name) {
		case "port_cd":	// Port Code Key In시 Yard Combo 셋팅
			if(eleObj.value.length == 5){
				doActionIBSheet(sheetObjects[0], formObj, COMMAND07);
			} else{
				formObj.yard_cd.RemoveAll();
			}
			break;
		case "spcode":	// S/P No. Key In시 S/P Name 셋팅 
			if(eleObj.value.length == 6){
				
				if (formObj.office.index < 1) {
					ComShowCodeMessage("EAS90045", "office");
					ComSetFocus(formObj.office);
					return false;
				}
				
				doActionIBSheet(sheetObjects[0], formObj, COMMAND08);
			} else{
				formObj.yard_cd.RemoveAll();
			}
			break;
		}
	}
	
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
					//ComKeyOnlyNumber(obj,",");
					ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
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
				if(obj.name=="vsl_cd"){
					ComKeyOnlyAlphabet('uppernum');
				} else {
					ComKeyOnlyAlphabet('upper');
				}
				
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
	
	function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){
		formObj = document.form;
		doActionIBCombo(formObj.s_rhq_ofc_cd); // RHQ
	}	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case "btng_addoffice":
				if(formObj.i_ofc_cd.value ==""){
					ComShowCodeMessage('EAS05014', 'Office'); // Office 값을 입력하셔야 합니다;
					result = false ;
				}
			break;
			
			case REMOVE01:
				if(formObj.i_ofc_cd.value ==""){
					ComShowCodeMessage('EAS05014', 'Office'); // Office 값을 입력하셔야 합니다;
					result = false ;
				}else{
					var inOfc = formObj.i_ofc_cd.value;
					var i=0;
					for(i;i<formObj.s_rhq_ofc_cd.GetCount();i++){
						if(formObj.s_rhq_ofc_cd.FindIndex(inOfc,i)!=-1){
							result = false ; 
							i = formObj.s_rhq_ofc_cd.GetCount();
							ComShowCodeMessage('EAS90202', ''); // Office 값을 입력하셔야 합니다;
						}
					}
				}
			break;
		}
		
		return result;
	}
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {  
		
			case "s_rhq_ofc_cd": 	//CTRL H/Q
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
				}
			break;
				
			case "s_ofc_cd":		//CTRL H/Q
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
				}
			break;
			
			case "s_trsp_crr_mod_cd":		//Trans Mode
				with (comboObj) { 
					SetColWidth("80");
					DropHeight = 180;
				}
			break;
			
			case "s_expn_aud_crte_tp_cd":	//Type
			case "i_expn_aud_crte_tp_cd":	//Type
				with (comboObj) { 
					SetColWidth("90");
					DropHeight = 60;
				}
			break;
			
		}
	}
	
	/**
	 * 추가되는 Office 정보를 만든다.
	 * Cargo Type 과 Trans Mode 를 섞어서 만든다.
	 *  
	 */ 	
	function makeAddOffice(){
		var formObj = document.form;
		var arrCgo_tp_cd = cgo_tp_cdCode.split("|");
		var arrTrsp_crr_mod_cd = trsp_crr_mod_cdCode.split("|");
		var i=0;

		// 조회 데이터가 없을경우엔 DB 에서 확인하고 조회 데이터가 있으면 화면에서 확인한다.
		if(sheetObjects[0].SearchRows < 1){
			formObj.f_cmd.value = SEARCHLIST02;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0342GS.do", sParam);		
			if(EasXmlString(sXml,"cnt")>0){
				ComShowCodeMessage('EAS90209', ''); 	//사용할수 없는 Office  입니다.
				return;
				
			};
		}else{
			for(i=0;i<sheetObjects[0].SearchRows;i++){
				if(sheetObjects[0].CellValue(i,"aud_ofc_cd") == ComGetObjValue(formObj.i_ofc_cd)){
					ComShowCodeMessage('EAS90209', ''); 	//사용할수 없는 Office  입니다.
				   return;
				}
			}
		}
	
		
    	for(x=0; x<arrCgo_tp_cd.length; x++){
        	for(y=0; y<arrTrsp_crr_mod_cd.length; y++){
				var adRow = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].CellValue2(adRow,"mdl_cd") = "TRS";
				sheetObjects[0].CellValue2(adRow,"rhq_ofc_cd") = ComGetObjValue(formObj.rhq_ofc_cd);
				sheetObjects[0].CellValue2(adRow,"aud_ofc_cd") = ComGetObjValue(formObj.i_ofc_cd);
				sheetObjects[0].CellValue2(adRow,"expn_aud_crte_tp_cd") = ComGetObjValue(formObj.i_expn_aud_crte_tp_cd);
				sheetObjects[0].CellValue2(adRow,"cgo_tp_cd") = arrCgo_tp_cd[x];
				sheetObjects[0].CellValue2(adRow,"trsp_crr_mod_cd") = arrTrsp_crr_mod_cd[y];
				sheetObjects[0].CellValue2(adRow,"cre_ofc_cd") = ComGetObjValue(formObj.login_ofc_cd);
        	}
    	}
	}
	
	
	// Set Data Only 클릭 했을경우
	function chkClickEvn(){
		easRowHide(sheetObjects[0],"expn_aud_tgt_flg",formObj.s_expn_aud_tgt_flg.checked)
	}



	
	
	