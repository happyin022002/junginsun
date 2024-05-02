/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0362.jsp
*@FileTitle : M&R Pre-Audit Criterion By Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-08
*@LastModifier : YulKyu Lee
*@LastVersion : 1.0
* 2015-05-08 YulKyu Lee
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class ESD_EAS_0362 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0362() {
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
	
	var nowLoad=0;
	var checkOfficeCode = 0;
	
	// offce_level 설정 H : 본부, R:RQH, O: 기타
	var ofcLevel="";   

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
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				init_form();
				break;				
			case "btn_save":
				doActionIBSheet(sheetObject,formObject, MODIFY);
			    break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				sheetObject.SpeedDown2Excel(true);
				break;
			case "btn_add_office" : // 새로운 Office Code를 88가지 Audit에 관하여 추가
				if(respb_ofc_cd_Check(1)){
					doActionIBSheet(sheetObjects[1],formObject, ADD);
				} else {
					form.i_ofc_cd.value = "";
				}
				break;
			case "btn_delete_office" :
				if(respb_ofc_cd_Check(2)){
					doActionIBSheet(sheetObjects[1],formObject, REMOVE);
				} else {
					form.i_ofc_cd.value = "";
				}
				break;
				
//			case "s_set_data_only" :
//				doActionIBSheet(sheetObject,formObject, COMMAND01);
//				break;
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
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}

		// office level check
		initOfcCheck();
		
 		//html컨트롤 이벤트초기화
 		initControl();
 		init_form();
	}
	
	
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress'  , 'obj_keypress'  , form);
  		axon_event.addListenerForm  ('keyup'     , 'obj_keyup'     , form);
  		axon_event.addListenerFormat('change'    , 'obj_change'    , document.form);		//- 변경될때
  	}

  	/**
  	 * RHQ, OFC소속 USER는 OFC CODE제한
  	 */
  	function initOfcCheck(){
  		var formObj = document.form;
  		doActionIBSheet(sheetObjects[0], formObj, "offce_level"); // RHQ
  	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {

			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(21);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);
					
					var HeadTitle = "|Seq|Module|RHQ|Office|Type|Code|Description|Objective of\nAuto-Audit|Updated By|Update Date|Remarks|";
									
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount-1, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		  KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,	30,		daCenter,	true,	"ibflag",			false,    		"",       dfNone,    0,     false,        true);
					InitDataProperty(0, cnt++, dtSeq,		30,		daCenter,	true,	"seq",				false,    		"",       dfNone,    0,     false,        true);
					InitDataProperty(0, cnt++, dtData,		50,		daCenter,	false,	"module",			false,    		"",       dfNone,    0,     false,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"rhq_ofc_cd",		false,    		"",       dfNone,    0,     false,        true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"ofc_cd",			false,          "",       dfNone,    0,     false,        true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"expn_vrfy_tp_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,	false,	"mnr_vrfy_tp_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,		false,	"mnr_vrfy_tp_cd_nm",false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtCheckBox,  100,  	daCenter,   true,   "obj_pre_aud",		false,   		"",       dfNone,    0,     true,        true,    1);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"upt_ofc_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"upt_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,		false,	"aut_rmk",			false,          "",       dfNone,    0,     true,       true);
					
					ColHidden('ibflag')= true;

				}
				break;
			case "sheet2":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "";
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,    50,  	daCenter, false,    "ibflag",         	false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_EAS_0362GS.do", EasFrmQryString(formObj));
				formObj.i_ofc_cd.value = "";
				
				
				break;
				
			case ADD:	//ADD OFFICE
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				//formojb.s_ofc_cd.value = s_ofc_cd1;
					formObj.f_cmd.value = ADD;	
					sheetObj.DoSearch("ESD_EAS_0362GS.do", EasFrmQryString(formObj));
					
					// 저장 후 조회.
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					form.i_ofc_cd.value = "";
				break;
				
				
			case REMOVE:	//DELETE OFFICE
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}

				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSearch("ESD_EAS_0362GS.do", EasFrmQryString(formObj));

				// 저장 후 조회.
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				form.i_ofc_cd.value = "";
				break;	
				
			case MODIFY:	//MODIFY OFFICE AUDIT STATUS
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = MODIFY;
				
				sheetObj.DoSave("ESD_EAS_0362GS.do", EasFrmQryString(formObj));
				
				// 저장 후 조회.
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
				break;
				
			case COMMAND01:		// CheckBox에 Check 표시된 Rows만 보이게 하는 함수
				for(var i = 1; i < sheetObj.Rows; i++){
					if("0" == sheetObj.CellValue(i,"obj_pre_aud") && sheetObj.RowHidden(i) == false){
						sheetObj.RowHidden(i) = true;
					} else{
						sheetObj.RowHidden(i) = false;
					}
				}
				if(formObj.s_set_data_only.checked){
					var newRowsCount = sheetObj.CheckedRows("obj_pre_aud");
					sheetObj.CountFormat="SELECTDATAROW/"+newRowsCount;
				} else{
					sheetObj.CountFormat="SELECTDATAROW/TOTALROWS";
				}
				break;
			case "offce_level":
				formObj.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
        		formObj.ofclevel.value = ofcLevel;

        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		var rhqSearchFlag = true;

        		if(ofcLevel=="O"){
        			// 본사(심사팀) RHQ 소속이외
            		rhqSearchFlag = false;
            		formObj.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
               		formObj.s_ofc_cd.InsertItem(0, formObj.ofc_cd.value, formObj.ofc_cd.value);
            		formObj.s_rhq_ofc_cd.Enable=false;
            		formObj.s_ofc_cd.Enable=false;  
            		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		formObj.s_ofc_cd.code2 = formObj.ofc_cd.value;
        		}else if(ofcLevel=="R"){
            		formObj.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
        			rhqSearchFlag = false;
        			formObj.s_rhq_ofc_cd.Enable=false;
        			formObj.s_ofc_cd.Enable=true;        			
        			formObj.s_rhq_ofc_cd.Code=formObj.ofc_cd.value;
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
        			formObj.s_rhq_ofc_cd.InsertItem(0, "", "");
            		formObj.s_ofc_cd.DeleteItem(0);
            		formObj.s_ofc_cd.InsertItem(0, "", "");
	        		// RHQ에 해당하는 Office 조회
        			initCombo(formObj.s_rhq_ofc_cd);
        		}
	  		break; 	
		}
	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		if(sheetObj.RowCount == 0){
			if(comboObjects[1].Code==""){
				ComShowCodeMessage("EAS90210", comboObjects[0].Code);
			} else {
				ComShowCodeMessage("EAS90210", comboObjects[1].Code);
			}
		}
	}

	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			
			sheetObj.RemoveAll();
			formObj.reset();
			formObj.s_type.Code = "";
//			formObj.s_rhq_ofc_cd.Code = "";
//			formObj.s_start_dt.value = ComGetDateAdd(null, "d", -14, "-");
//			formObj.s_end_dt.value = ComGetDateAdd(null, "d", 0, "-");
//			formObj.s_cost_group_cd.Code = "ALL";
//			formObj.s_vndr_seq.value = "";
//			formObj.s_vndr_nm.value = "";
//			formObj.s_auto_aud_sts_cd.Code = "ALL";
//			formObj.s_expn_aud_sts_cd.Code = "ALL";
//			formObj.s_difference.Code = "ALL";
			
//			formObj.s_inv_no.value = "";
//			formObj.s_csr_no.value = "";
//			formObj.s_csr_status.Code = "ALL";
			
//			formObj.s_ofc_cd.RemoveAll();
//			formObj.s_ofc_cd.InsertItem(0, "", "");
//			formObj.s_ofc_cd.Code2 = "";
			
//			formObj.s_err_type.RemoveAll();
//			formObj.s_err_type.InsertItem(0, "ALL", "ALL");
//			formObj.s_err_type.Code2 = "ALL";

	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		formObj = document.form;
		var result = true ;
		
//		result = sheetObj.GetSearchXml("ESD_EAS_0362GS.do", EasFrmQryString(formObj));
		
		return result;
	}
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "s_rhq_ofc_cd": 	//RHQ OFFICE
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					setComboData(comboObj);
				}
			break;
				
			case "s_ofc_cd":		//OFFICE
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 6;
				}
			break;	  
			
			case "s_type": 	//EXPENSE AUDIT M&R VERIFY TYPE CODE(MNR_GEN_CD : CD03412
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
					setComboData(comboObj);
				}
			break;
		}
	}
	
	function setComboData(comboObj, param){ 
		var comboID = comboObj.id;
		var frm = document.form;
		var sheetObj = sheetObjects[1];
		switch(comboID){
			case "s_rhq_ofc_cd":
				frm.s_rhq_ofc_cd.RemoveAll();
				frm.f_cmd.value = COMMAND02;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
				// 이폼에서는 권한 체크를 하지 않는다.
	    		comboObj.insertItem(0, "", "");
	    		comboObj.Code2 = "";
				break;
			case "s_ofc_cd":
		        comboObj.RemoveAll();
		        
		        if(param == ""){
		        	return;
		        }
		        
		        frm.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		        ComXml2ComboItem(sXml, comboObj, "ofc_cd", "ofc_cd");
		    	comboObj.InsertItem(0, "", "");
	    		comboObj.Code2 = "";
				break;
			case "s_type":
				searchCommonCombo("CD03412", comboObj, true);
				break;
		}
	}
	
	/**
	 * RHQ Combo Box 데이터 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function s_rhq_ofc_cd_OnChange(comboObj, Index_Code, Text){
		var frm = document.form;
		setComboData(frm.s_ofc_cd, Text); // RHQ
	}
	


	/**
	 * 공통 테이블 콤보 조회
	 * @param codeKey 공통 코드키
	 * @param comboObj combo object
	 */
	function searchCommonCombo(codeKey,comboObj, isAll){
		var sheetObj = sheetObjects[1];
		var frm = document.form;
		frm.f_cmd.value = SEARCH01;
		// 공통 테이블에서 조회할 키
		frm.code_key.value = codeKey
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");
		
		if(isAll){
			comboObj.InsertItem(0, "", "");
    		comboObj.Code2 = "";
		}
		
	}
	 
	
	/**
	 * EAC transfer
	 */		
	function eac_transfer(sheetObj,Row,Col){
	   	var eac_no = ComTrim(sheetObj.CellValue(Row, 'eac_no'));
	   	var iss_cty_cd = ComTrim(sheetObj.CellValue(Row, 'iss_cty_cd'));
	   	var so_seq = ComTrim(sheetObj.CellValue(Row, 'so_seq'));
	   	var so_dtl_seq = ComTrim(sheetObj.CellValue(Row, 'so_dtl_seq'));
	   	var select_flg = ComTrim(sheetObj.CellValue(Row, 'select_flg_temp'));
	   	var ofc_cd = ComTrim(sheetObj.CellValue(Row, 'office'));
	   	var acct_cd = ComTrim(sheetObj.CellValue(Row, 'acct_cd'));
	   	var cost_cd = ComTrim(sheetObj.CellValue(Row, 'cost_cd'));
	   	var vndr_seq = ComTrim(sheetObj.CellValue(Row, 'sp_no'));	   	
	   	var inv_no = ComTrim(sheetObj.CellValue(Row, 'inv_no'));
	   	var cur_cd = ComTrim(sheetObj.CellValue(Row, 'curr_cd'));
	   	var inv_amt = ComTrim(sheetObj.CellValue(Row, 'amount'));
	   	var vvd = ComTrim(sheetObj.CellValue(Row, 'vvd'));

	   	if(iss_cty_cd == 'iss_cty_cd' || so_seq == 'so_seq'){
	   		ComShowMessage(ComGetMsg("EAS00009"));	// At least one row needs to be selected
	   		return false;
	   	}

	   	if(select_flg == ''){
	   		ComShowMessage(ComGetMsg("EAS90049"));	// You must Confirm for selected row before EAC Transfer. : Confirm안하고 시트 Select만 선택 후, EAC Transfer 클릭 시 체크.
	   		return false;
	   	}

	   	if(eac_no != ''){
	   		ComShowMessage(ComGetMsg("EAS90048"));	// Selected Row cannot be EAC_Transfer. because EAC No. already exist.
	   		return false;
	   	}
	   	
	   	if(select_flg != 'A'){
	   		ComShowMessage(ComGetMsg("EAS90100"));	// Audit Result Audit can only be EAC transferred available.
	   		return false;
	   	}

	   	var theURL = "ESD_EAS_0224.do?p_sys_div_cd=PSO"
	   	                         	+"&p_sys_if_cd=PSO"
									+"&p_iss_cty_cd="+iss_cty_cd
									+"&p_so_seq="+so_seq
									+"&p_so_dtl_seq="+so_dtl_seq
									+"&p_ofc_cd="+ofc_cd
									+"&p_acct_cd="+acct_cd
									+"&p_cost_cd="+cost_cd
									+"&p_vndr_seq="+vndr_seq
									+"&p_inv_no="+inv_no
									+"&p_cur_cd="+cur_cd
									+"&p_inv_amt="+inv_amt
	   								+"&p_vvd="+vvd;
									
	   	var winName = "EACTransferPopup";
	   	var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:620px";
	   	ComOpenWindow(theURL,winName,features,true);
	}
	
	//ResponsibleOFC Check
	function respb_ofc_cd_Check(checkOfficeCode){
		//alert("validating start");
		var sheetObj=sheetObjects[1];
		var formObj=document.form;
		
		formObj.f_cmd.value = COMMAND02;	
		//alert(EasFrmQryString(formObj));
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0362GS.do", EasFrmQryString(formObj));
		//alert("ck1");
		var availability = ComGetEtcData(sXml, "EAS_0362_AVAILABILITY")
		var validation = ComGetEtcData(sXml, "EAS_0362_VALIDATION")
		var rhqCheck = ComGetEtcData(sXml, "EAS_0362_0363_RHQ_CHECK")
		
		if(checkOfficeCode == 1){
			if(validation != "Y"){
				alert(msgs['EAS29009']);
				return false;
			}else if (validation == "Y"){
				if(availability == "Y"){
					return confirm(msgs['EAS90205']);	
				}else{
					alert(msgs['EAS90201']);
					return false;
				}
				return true;
			}	
		} else if(checkOfficeCode == 2){
			if(validation != "Y"){
				alert(msgs['EAS29009']);
				return false;
			}else if (validation == "Y"){
				if(rhqCheck == "Y"){
					alert(msgs['EAS90202'])
					return false;	
				}else{
					if(availability != "Y"){
						return confirm(msgs['EAS90203']);
					}else{
						alert(msgs['EAS90204']);
						return false;
					}
					return true;
				}
			}
		}
	}
	
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
	 	switch(colName) {
	 		case('select_flg'):
	 			// Select 값을 변경시 confirm위해 자동으로 Select Check box 표시
	 			if(sheetObj.cellValue(row, 'select_flg') != sheetObj.cellValue(row, 'select_flg_temp')) {
	 				sheetObj.CellValue2(row, "sel") = "Y";
	 				sheetObj.RowFontColor(row) = sheetObj.RgbColor(0,84,255);	// 파란
	 			} else {
	 				sheetObj.CellValue2(row, "sel") = "N";
	 			}
	 		break;
	 	}
	}
