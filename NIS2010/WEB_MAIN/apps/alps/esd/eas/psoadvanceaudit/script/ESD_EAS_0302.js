/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0302.js
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0302 : 예)Route UnMatch List 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0302() {
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
	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code

	var loadVessel = 1;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
//				formObject.vvd.value = "";
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_port_cd":	// Port Code Popup
				var sUrl = "/hanjin/VOP_VSK_0043.do";
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
				if(rVal){
					formObject.port_cd.value = rVal;
					loadTerminal();				//COMBO YARD
					f_ClearSheets();
					formObject.yard_cd.focus();
				}
				break;
			case "btns_calendar_s":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.period1, 'yyyy-MM-dd');
   	         	break;

            case "btns_calendar_e":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.period2, 'yyyy-MM-dd');
   	         	break;				
   	         	
			case "btn_Tariff": // Port Tariff
				port_tariff(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
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
	function loadPage(divChargeType) {

		for(i=0;i<sheetObjects.length;i++){
	 		//khlee-시작 환경 설정 함수 이름 변경
	 		ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	 	
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
 		//html컨트롤 이벤트초기화
 		initControl();
 		
 		var formObj = document.form;
 		
 		doActionIBSheet(sheetObjects[0], formObj,"rhq");
 		getEasIbComboList(document.vessel_class , vessel_classCode , vessel_classText , 'ALL'); // vessel_class
 		getContractTypeComboList(document.contract_type , contract_typeCode , contract_typeText, 'ALL'); 	// 멀티 콤보 (Contract type) 설정
 		
		if(formObj.port_cd.value.length == 5){
			doActionIBSheet(sheetObjects[0], formObj, COMMAND07);
		} else{
			formObj.yard_cd.RemoveAll();
		}
		
		formObj.rhq.Code2 = formObj.param_rhq.value;		
		formObj.contract_type.Code2 = formObj.param_contract_type.value
		
		formObj.contract_type_nm.value = formObj.contract_type.GetIndexText(formObj.contract_type.Index,1);
		formObj.charge_type.Code2 = formObj.param_charge_type.value;
		formObj.vessel_class.Code = formObj.param_vessel_class.value;

		doActionIBSheet(sheetObjects[0], formObj, COMMAND01);	//Account Combo
		doActionIBSheet(sheetObjects[0], formObj, COMMAND02);	//Cost Combo
		
		formObj.acct_cd.Code2 = formObj.param_acct_cd.value;
		formObj.cost_cd.Code2 = formObj.param_cost_cd.value;
		
		formObj.period1.value = ComGetDateAdd(formObj.period2.value,"M", -3, "-");
		
 		// 팝업 오픈시 조회.
 		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 		
 		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
  		 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
  		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
  		axon_event.addListenerForm  ('keyup', 'obj_keyup', form);
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
	                style.height = GetSheetHeight(20) ;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(14, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "Port|Yard|VVD|ATB|Bound|S/P Name|Invoice No|Issued|Cur.|Tariff Cost|Adjust Cost|Inv Amount|Remark|acct_cd";
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					HeadRowHeight = 12;					
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "port",            	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "yard",            	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "vvd",            	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "vps_atb_dt",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "bound",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,   false,    "sp_nm",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "inv_no",           false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "issued",           false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "curr_cd",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daRight,  false,    "tariff_cost",      false,          "",       dfFloat,   2,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daRight,  false,    "adjcost",          false,          "",       dfFloat,   2,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daRight,  false,    "amount",           false,          "",       dfFloat,   2,     false,       true);
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,   false,    "rmk",            	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,   false,    "acct_cd",          false,          "",       dfNone,    0,     false,       true);
					
					ColHidden("acct_cd") = true;
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_EAS_0302GS.do", EasFrmQryString(formObj));
				ComOpenWait(false);
				break;
				
			case IBDOWNEXCEL:	//EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
			
			case COMMAND01:     // Account Combo
				formObj.f_cmd.value = sAction;	// COMMAND01
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", FormQueryString(formObj));
				createCustomCombo("account", ComGetEtcData(sXml, "account"));	//Account & Cost 초기화
			break;
			
			case COMMAND02:     // Cost Combo
				formObj.f_cmd.value = sAction;	// COMMAND02
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", FormQueryString(formObj));
				createCustomCombo("Cost", ComGetEtcData(sXml, "cost"));	//Account & Cost 초기화
			break;
			
			case COMMAND06:     // Vessel Combo
				formObj.f_cmd.value = COMMAND05;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", FormQueryString(formObj));
				createCustomCombo("vslClasssVessel", ComGetEtcData(sXml, "vslClasssVessel"));	//Vessel 초기화
			break;
			
			case COMMAND07:		//Port Code [keyup:5자리]  
			    formObj.f_cmd.value = COMMAND05;	//
			
				var param = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
				var isPort = ComGetEtcData(sXml, "isPort");	//O or X
				if(isPort == "O"){
					rVal = formObj.port_cd.value;
					loadTerminal();
					formObj.yard_cd.focus();
				} else if(isPort == "X"){
					ComShowCodeMessage("PSO00014", "[Port]");
					formObj.port_cd.value = "";
					formObj.port_cd.focus();
				}
			break;
	  		case "rhq":    
    			//RHQ 콤보 리스트 조회
	  			formObj.rhq.RemoveAll();
	  			formObj.f_cmd.value = COMMAND02;
    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
    			ComXml2ComboItem(sXml, formObj.rhq, "ofc_cd", "ofc_cd");
    			formObj.rhq.InsertItem(0, "", "");
    			formObj.rhq.Index2 = 0;
	  		break; 			
		}
	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){

	}

	function sheet1_OnClick(sheetObj, Row,Col,Value){
	
	}
	
	function rhq_OnChange(comboObj,Index_Code, Text){
		
	}
	
	 /**
	  * contract_type Combo 선택시 contract_type_name 셋팅
	  */
	 function contract_type_OnChange(combo, Index_Code, Text) {
		var formObj = document.form;
		if ( formObj.contract_type_nm.value == Text )  return;
		formObj.contract_type_nm.value = combo.GetText(Index_Code,1);

//		doActionIBSheet(sheetObjects[0], formObj, COMMAND06);	//Vessel Class - Vessel Combo
	 }	
	
	/**
	 * 화면 로딩시 콤보조회 
	 */
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
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
		}
	}
	
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
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				if (formObj.period1.value == "" || formObj.period1.value.length != 10) {
					ComShowCodeMessage("EAS90045", "Period");
					ComSetFocus(formObj.period1);
					return false;
				} else if (formObj.period2.value == "" || formObj.period2.value.length != 10) {
					ComShowCodeMessage("EAS90045", "Period");
					ComSetFocus(formObj.period2);
					return false;
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
		var formObject = document.form;
		switch(comboObj.id) {  
			case "yard_cd":		//Yard 
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;	
					UseCode = true;
					SetColAlign("center|left");        
					SetColWidth("50|300");
					DropHeight = 190;
					ValidChar(2,1);	//영문대문자,숫자
					MaxLength = 2;
				}
			break; 
			
			case "acct_cd":		//Account 
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;
					UseCode = true;
					DropHeight = 190;
					ValidChar(5,0);	//숫자
					MaxLength = 6;
				}
			break; 	
			
			case "cost_cd":		//Cost 
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;	
					UseCode = true;
					DropHeight = 190;
					ValidChar(2,0);	//영문대문자
					MaxLength = 6;
				}
			break;
			
			case "vessel_class":		//Vessel class
				with (comboObj) { 
					MultiSelect = false;
					UseAutoComplete = true;	
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
					ValidChar(5,0);	//숫자
				}
			break;
			case "vessel":		//Vessel
				with (comboObj) { 
					MultiSelect = false;
					UseAutoComplete = true;	
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
					ValidChar(2,0);	//영문대문자
					MaxLength = 4;
				}
			break;
			case "charge_type":		//charge_type
				with (comboObj) {
					InsertItem(0, "PORT CHARGE", "01");
					InsertItem(1, "PORT SERVICE CHARGE", "02");
					InsertItem(2, "CANAL TRANSIT FEE", "03");
					
					if (formObject.divChargeType.value == "2") {
						InsertItem(3, "OTHER", "04");
					}
				
			    }
				break;			
			
		}
	}
	 
	/**
	 * Period 체크
	 */
	function pointAutoMove(val) {
		if ( val.length == 8  ) {
//			document.form.period2.focus();
		}
	}
	
	 /**
	  * Custom Combo 셋팅
	  */
	 function createCustomCombo(codeType, comboCode){
	 	var formObj = document.form;
	 	arrComboItems = comboCode.split("↔");
	 	var preCode = "";
	 	if(codeType == 'account'){
	 		var chkIndex = 0;
		 	formObj.acct_cd.InsertItem(-1, "ALL|", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];

		 		if(preCode == formObj.param_acct_cd.value){
		 			chkIndex = i+1;
		 		}
		 	}  
		 	formObj.acct_cd.Index = chkIndex;
	 	}else if(codeType == 'Cost'){
	 		var chkIndex = 0;
		 	formObj.cost_cd.InsertItem(-1, "ALL|", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.cost_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];

		 		if(preCode == formObj.param_cost_cd.value){
		 			chkIndex = i+1;
		 		}
		 	}  
		 	formObj.cost_cd.Index = chkIndex;
	 	}else if(codeType == 'vslClasssVessel'){
	 		var chkIndex = 0;
		 	formObj.vessel.InsertItem(-1, "ALL|", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.vessel.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];
		 		
		 		if(preCode == formObj.param_vessel.value){
		 			chkIndex = i+1;
		 		}
		 	}
//		 	if(loadVessel == 1 ){
//		 		loadVessel = 2;
//		 		formObj.vessel.Code2 = formObj.param_vessel.value;
//		 	}else{
//		 		formObj.vessel.Index = chkIndex;
//		 		
//		 	}
		 	formObj.vessel.Index = chkIndex;
	 	}
	 	
	 }
	 
	/**
	 * 외부 콤보박스의 리스트 가져오기
	 * 멀티 콤보 (Contract type) 설정
	 **/
	 function getContractTypeComboList( combo , code , text , option) {
		var comboNoList = code;
		var comboNmList = text;
		var comboNoArray = new Array();
		var comboNmArray = new Array();
 
		comboNoArray = comboNoList.split("|");
 		comboNmArray = comboNmList.split("|");
 
 		combo.RemoveAll();

 		for(var i=0; i<comboNoArray.length; i++) {
			combo.InsertItem(i, comboNoArray[i]+'|'+comboNmArray[i],  comboNoArray[i]);
 		}

 		combo.InsertItem(0, "" ,  option);
	 }	 
		
	 /**
	  * Account Combo 선택시 Account_name 셋팅
	  */
	 function acct_cd_OnChange(comboObj, Index_Code, Text){
	 	var formObj = document.form;
	 	formObj.acct_nm.value = formObj.acct_cd.GetIndexText(formObj.acct_cd.Index, 1);
	 }
	
	 /**
	  * Cost Combo 선택시 Cost_name 셋팅
	  */
	 function cost_cd_OnChange(){
	 	var formObj = document.form;
	 	formObj.cost_nm.value = formObj.cost_cd.GetIndexText(formObj.cost_cd.Index, 1);
	 } 
	 
	 /**
	  * vessel_class Combo 선택시 vessel 셋팅
	  */
	 function vessel_class_OnChange(combo, Index_Code, Text) {
		var formObj = document.form;
		formObj.vessel.RemoveAll();
		doActionIBSheet(sheetObjects[0], formObj, COMMAND06);	//Vessel Class - Vessel Combo
	 }
	 
	/**
	 * 해당 Port 선택 및 입력시 Yard 조회
	 */
	function loadTerminal() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		sheetObj.ShowDebugMsg = false;
		
		//콤보필드를 초기화시킨다.
		formObj.yard_cd.RemoveAll();
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
		var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
		addComboItem(formObj.yard_cd, comboItems);
		
	}
	
	/**
	 * 로딩시 Vessel Class 셋팅
	 * Port Code 선택시 Yard name 셋팅
	 */	
	function addComboItem(comboObj,comboItems) {
		var formObj = document.form;
		var chkIndex = 0;
		var chk_yard_cd = ""; 
		if(formObj.port_cd.value.length == 5){
			formObj.country.value = (formObj.port_cd.value).substring(0, 2);
			if(formObj.param_yard.value != ''){
				chk_yard_cd = (formObj.param_yard.value).substring(formObj.port_cd.value.length);
			}
		}
		
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
			
	 		if(comboItem[0] == chk_yard_cd){
	 			chkIndex = i;
	 		}
		}
		
		formObj.yard_cd.Index = chkIndex;
	}
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		var formObj = document.form;
		if(obj.value.length >= 8) {
			formObj.period2.value = ComGetDateAdd(obj.value,"D", 14, "-");
		}else{
			formObj.period2.value = "";
		}
	}	

	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "period1":
			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "period2":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}	
	
	/**
	 * Port Tariff
	 */		
	function port_tariff(sheetObj,Row,Col){
	   	var yard = ComTrim(sheetObj.CellValue(Row, 'yard'));
	   	var acct_cd = ComTrim(sheetObj.CellValue(Row, 'acct_cd'));

	   	var theURL = "VOP_PSO_0036.do?yard="+yard
	   								+"&acct_cd="+acct_cd;
							
	   	var winName = "PortTariffPopup";
	   	var features = "scroll:yes;status:no;help:no;dialogWidth:1024px;dialogHeight:620px";
	   	ComOpenWindow(theURL,winName,features,true);
	}
	