/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0214.js
*@FileTitle : Contact point config
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
     * @class ESD_EAS_0214 : ESD_EAS_0214 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0214() {
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

    
	//공통전역변수
    var frm = null;
	var usdRt ="";  // 환율
    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	
	// offce_level 설정
	// 1 : 본부, 2:RQH, 3: 기타
	var ofcLevel="";
	
	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 	var frm = document.form;
	 	var change = 0;

	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	 				
	 				break;
	 			case "btn_del":
	 				doActionIBSheet(sheetObjects[0],document.form,REMOVE01);
	 				break;
	 			case "btn_save":
	 				doActionIBSheet(sheetObjects[0],document.form,MULTI01);
	 				break;
	 			case "btn_downexcel":
	 				doActionIBSheet(sheetObjects[0],document.form,"btn_downexcel","","");
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	    initControl();
	    doActionIBSheet(sheetObjects[0], frm,"offce_level")
	}
    
 	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
//      axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
//		axon_event.addListener('keydown', 'ComKeyEnter', 'form');  //jsp name 옆에 id 추가 예)name="btn_retrieve" id="btn_Retrieve"
//		axon_event.addListenerForm( 'beforedeactivate', 'obj_deactivate',frm  );
	}    
 	
	function obj_change(){

	} 	 	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {

	 	var cnt = 0;

	 	switch(sheetNo) {
	    	case 1:      //sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(22);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(14, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|SEQ.||RHQ|Office|KPI Office|Global ID|Name|Audit Scope|TEL|FAX|E-mail|Date|Delete";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
					InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"chk",              	false,    "",      dfNone,          0,          true,         true,    10);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "rhq_ofc_cd",         	false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "ofc_cd",               false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtCombo,         70,  	daCenter,   true,   "kpi_ofc_cd",               false,    "",      dfNone,          0,          true,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "eac_usr_id",           false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "eac_usr_nm",           false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         180,  	daLeft,     true,   "expn_aud_scp_desc",    false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "phn_no",         		false,    "",      dfNone,          0,          false,        false,   20);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "fax_no",         	    false,    "",      dfNone,          0,          false,        false,   20);
					InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "usr_eml",         	    false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "cre_dt",         	    false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "delt_flg",         	false,    "",      dfNone,          0,          false,        false,   10);
					
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
					
				}
				break;

			}
		}	
	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		var frm = document.form;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
//				if(validateForm(sheetObj,frm,sAction)){
					sheetObjects[0].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0214GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
//				}
				break;
			case REMOVE01:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				
				if (!ComShowCodeConfirm("COM12165")) return; // Do you want to save {?msg1}?
				
				frm.f_cmd.value = REMOVE01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESD_EAS_0214GS.do", sParam);
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('COM130102', 'Data');
				}
				ComOpenWait(false);
				
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				
				break;
				
			case MULTI01:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
				frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESD_EAS_0214GS.do", sParam);
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('COM130102', 'Data');
				}
				ComOpenWait(false);				
				break;
				
			case "btn_downexcel":	// EXCEL DOWNLOAD
//				sheetObj.SpeedDown2Excel(1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
	  		case "offce_level":    
	  			frm.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		var rhqSearchFlag = true;
        		// 로그인한 RHQ OFFCD 셋팅
        		frm.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
        		// 로그인한 OFFCD 셋팅
        		frm.s_ofc_cd.InsertItem(0, frm.ofc_cd.value, frm.ofc_cd.value);
        		if(ofcLevel=="O"){
        			// 본사(심사팀) RHQ 소속이외
            		rhqSearchFlag = false;
            		frm.s_rhq_ofc_cd.Enable=false;
            		frm.s_ofc_cd.Enable=false;  
            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		frm.s_ofc_cd.code2 = frm.ofc_cd.value; 
        		}else if(ofcLevel=="R"){
        			rhqSearchFlag = false;
        			frm.s_rhq_ofc_cd.Enable=false;
        			frm.s_ofc_cd.Enable=true;        			
        			frm.s_rhq_ofc_cd.Index2=0;
        			doActionIBCombo(frm.s_rhq_ofc_cd)
        		}else if(ofcLevel=="H"){
        			// 본사(심사팀) 소속
            		rhqSearchFlag = true;
            		frm.s_rhq_ofc_cd.Enable=true;
            		frm.s_ofc_cd.Enable=true;
            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		frm.s_ofc_cd.code2 = frm.ofc_cd.value;
            		btn_save_auth.style.display = "";
        		}
    			
        		if(rhqSearchFlag){
        			//RHQ 콤보 리스트 조회
        			frm.s_rhq_ofc_cd.RemoveAll();
        			frm.f_cmd.value = COMMAND02;
        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
        			ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
        			//frm.s_rhq_ofc_cd.Index2 = 0;
        			//doActionIBCombo(frm.s_rhq_ofc_cd);
        			frm.s_rhq_ofc_cd.InsertItem(0,'', '');
            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
        			doActionIBCombo(frm.s_rhq_ofc_cd)        			
        		}
	  			break;  				
		}
	}

    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[0];
    	
        sheetObj.ShowDebugMsg = false;
        switch(comboObj.id) {
	    case "s_rhq_ofc_cd":  
	        frm.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	    	
	        frm.s_ofc_cd.RemoveAll();
	    	ComXml2ComboItem(sXml, frm.s_ofc_cd, "ofc_cd", "ofc_cd");
	    	frm.s_ofc_cd.InsertItem(0, "", "");
//	    	frm.s_ofc_cd.Index=0;
	    	frm.s_ofc_cd.code2 = frm.ofc_cd.value
	    	break;  
	    }
    }	
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case REMOVE01 :
	 		 if(sheetObj.RowCount == 0){
	 			 //alert("조회된 데이터가 없습니다.");
	 			 ComShowCodeMessage('COM12189');
	 			 return false;
	 		 }
	 		 for(var i=1;i<=sheetObj.RowCount;i++){
	 			 if(1==sheetObj.CellValue(i, 2)){
	 				 return true;
	 			 }
	 		 }
	 		 ComShowCodeMessage('COM12113', 'Data.');
	 		 return false;
	 		 break;
	 	 case MULTI01 :
	 		 if(sheetObj.RowCount == 0){
	 			 //alert("조회된 데이터가 없습니다.");
	 			 ComShowCodeMessage('COM12189');
	 			 return false;
	 		 }

//	 		 for(var i=1;i<=sheetObj.RowCount;i++){
//	 			 if(sheetObj.CellValue(i, "kpi_ofc_cd") == "" ){
//	 				 ComShowCodeMessage('COM130201', "KPI Office");
//	 				 //return false;
//	 			 }
//	 		 }
	 		 
	 		 break;
	 	 } // end switch()
	 	 return true;
	  }	 
	  
	  
	  function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(form.s_rhq_ofc_cd); // EAC Type
	  }
	  
	// ===================================================================================
	// Sheet 이벤트 처리
	// ===================================================================================
	/**
	* sheet1 doubleClick후 이벤트 
	* @param {ibsheet} sheet 해당 시트   
	* @param {long} row 해당 셀의 Row Index
	* @param {long} col 해당 셀의 Column Index
	*/
	function sheet1_OnDblClick(sheetObj, row, col) {
		if (row < 1) {
			return;
		}
		var param = "main_page=yes&popup=yes&EAC_USR_ID="+sheetObj.CellValue(row, "eac_usr_id");
		ComOpenPopup("ESD_EAS_0204.do?"+param, 714, 380, "setCallback_Personnel ", "1,0,1,1,1,1,1,1", true, false);
	}	  

    function setCallback_Personnel(){
    	
    }
	 
	/**
	* sheet1 Click 이벤트 
	* @param {ibsheet} sheet 해당 시트   
	* @param {long} row 해당 셀의 Row Index
	* @param {long} col 해당 셀의 Column Index
	* @param {long} col 해당 셀의 Column Value
	*/
    function sheet1_OnClick(sheetObj, row , col , value) {
    	if( sheetObj.ColSaveName(col) == "kpi_ofc_cd" ) {
    		sheetObj.InitCellProperty(row, col, dtCombo);
	        var frmStr = "f_cmd=" + COMMAND03 + "&s_rhq_ofc_cd=" + sheetObj.CellValue(row, "rhq_ofc_cd");
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", frmStr);
	        var sCombo = ComXml2ComboString(sXml, "ofc_cd", "ofc_cd");
	        sheetObj.CellComboItem(row, col, sCombo[1], sCombo[0]);
    	}
    }
    
	/* 개발자 작업  끝 */