/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0140.js
*@FileTitle : Logistic Revenue TPB Invoice Creation -  Multiple
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-15
*@LastModifier : Kim Hyun Ju
*@LastVersion : 1.16
* --------------------------------------------------------
* History
* 2015-03-10 [CHM-201534706] KIM HYUN HWA- Logistics(Operational) Revenue 에서 통화 관련 수정
*             1. loading 시 Login ofc setting 
*             2. Office별 Billing Currency 보완. USD,EUR 기본
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
     * @class ESD_TPB_0140 : ESD_TPB_0140 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0140() {
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
  var prefix = "sheet1_";
  //IBMultiCombo
  var comboObjects = new Array();
  var comboCnt = 0;

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
  		
  		//ComClearCombo(document.form.s_if_ofc_cd);
  		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
  		
  		initControl();
  		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
  		
		//Expense Type을 TRS : Transportation으로 고정
		document.form.s_n3pty_expn_tp_cd.value = "TRS";
		document.form.s_n3pty_expn_tp_cd.disabled = true;
		
		//Logistics Rev. Code를 Q6 : Streent Turn F로 고정
		var comboObj = eval("document.all.s_n3pty_bil_tp_cd");
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
		ComAddComboItem(comboObj, "Street Turn F", "Q6" );
  		document.form.s_n3pty_bil_tp_cd.value = "Q6";
		
		
		get_month_info();
  		document.form.cost_month.onblur = get_month_info;

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
 				
 					// **** 0106 - TPB Handling 작업 참조 할 것. 
 					var cnt = 0;
 					// 높이 설정
 					style.height = 350;
 										
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msNone;

 				   //전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 3, 4999);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					//2009-07-31 O Wan-Ki
 					

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, true, true, false, false)
 					
 					var HeadTitle1 = "|||SEQ.|ULH S/P No.|SML S/P No.|EQ No.|ULH INV No.|SML 3rd Party No.|I/B BKG No.|ORN CY|O/B BKG No.|Return CY|Return DATE|Rate|AMT|Tax|RCVD AMT|SML INV No.|||||GRP Seq.";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 					
 					InitColumnInfo(headCount, 0, 0, true);
					
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
//					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
 				   
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++, dtHiddenStatus,100,    daCenter,  false,   "s_sts",                false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      30,     daCenter,  false,   "s_trnsctn",            false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtCheckBox,    30,     daCenter,  false,   "s_chk",                false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtData,        40,     daCenter,  true,    "s_seq",            	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        100,    daCenter,  true,    "s_n3pty_src_no",    	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtPopupEdit,   100,    daCenter,  true,    "s_trd_party_val",      false,          "",       dfNone,    0,     true,        true);
 					InitDataProperty(0, cnt++, dtData,        100,    daCenter,  true,    "eq_no",                false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        110,    daCenter,  true,    "s_src_inv_no",  		  false,          "",       dfNone,    0,     false,       true);					
 					InitDataProperty(0, cnt++, dtData,        110,    daCenter,  true,    "s_n3pty_no",      	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        110,    daCenter,  false,   "s_bkg_no",		  	  false,          "",       dfNone,    0,     false,       true); 					
 					InitDataProperty(0, cnt++, dtData,         80,    daCenter,  false,   "s_yd_cd",     		  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        110,    daCenter,  false,   "s_new_bkg",     		  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        80,     daCenter,  true,    "s_cntr_rtn_yd_cd",     false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        90,     daCenter,  true,    "s_cntr_rtn_dt",        false,          "",       dfNone,    0,     false,       true); 
 					InitDataProperty(0, cnt++, dtData,         50,    daRight,   true,    "s_rev_inv_rt",    	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,        100,    daRight,   true,    "s_dtl_amt",      	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,       50,    daRight,   true,    "s_tax",      		  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      100,    daRight,   true,    "s_ttl_amt",      	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter,  true,    "s_n3pty_inv_no",   	  false,          "",       dfNone,    0,     false,       true);				
 					InitDataProperty(0, cnt++, dtHidden,      100,    daRight,   true,    "s_total",      	  	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      100,    daRight,   true,    "s_locl_tax_amt",   	  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      100,    daRight,   true,    "s_n2nd_locl_tax_amt",  false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      100,    daRight,   true,    "s_tax_amt",   	      false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter,  true,    "grp_cfm_seq",          false,          "",       dfNone,    0,     false,       true);
					
 					PopupImage = "/hanjin/img/btns_search.gif";
 					ShowButtonImage = 2;
 					
 					SelectHighLight = false;
 					FocusAfterProcess = false;
 				}
 				break;
 				
 		}
 	}
  	 

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
//  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		
  		var sheetObject = sheetObjects[0];
  		var formObject = document.form;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;

  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					formObject.val_flag.value = "N" ;
 					// Save 버튼 보여준다
 					document.all.btn_save_t.style.display = '';  		
 					ComBtnEnable("btn_Load_Excel");
 					ComBtnEnable("btn_val_sp");
 					ComBtnEnable("btn_add");
 					ComBtnEnable("btn_delete");
 					formObject.s_if_ofc_cd.Code = formObject.s_usr_ofc_cd.value ;
  					s_if_ofc_cd_OnChange();
  					
  					//Expense Type을 TRS : Transportation으로 고정
  					document.form.s_n3pty_expn_tp_cd.value = "TRS";
  					document.form.s_n3pty_expn_tp_cd.disabled = true;
  					
  					//Logistics Rev. Code를 Q6 : Streent Turn F로 고정
  					var comboObj = eval("document.all.s_n3pty_bil_tp_cd");
  					if(comboObj != undefined) {
  						ComClearCombo(comboObj);
  					}
  					ComAddComboItem(comboObj, "Street Turn F", "Q6" );
  			  		document.form.s_n3pty_bil_tp_cd.value = "Q6";
 					
  					break;
  				case "btn_calendar":
  					var cal = new ComCalendar();
  					cal.setDisplayType('month');
  					cal.select(formObject.cost_month, "yyyy-MM");
  					break;
  				case "btn_inv":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0124.do?pgmNo=ESD_TPB_0124";
  						formObject.submit();
  					}
  					break;
				case "btn_Load_Excel":
					
					sheetObject.RemoveAll();
					sheetObject.LoadExcel();
					formObject.val_flag.value = "N" ;
					for ( var i = 1; i < sheetObject.RowCount + 1; i++ ){	
					  	check_sp_existence(sheetObject, i);					// sheet 에 sp 값이 존재 안하면 back칼러 변경  
			  		}
					
					break;
				case "btn_add":
					var row = sheetObject.DataInsert(-1);
					break;
				case "btn_delete":

					var row = sheetObject.SelectRow;
					var col = sheetObject.SelectCol;
						
					sheetObject.RowDelete(row,false);
					break;
					
				case "btn_val_sp":
					check_sp_validation();
					break;
//				case "btn_erpInterface":
//					if( ComShowConfirm(ComGetMsg("TPB90008","","","")) ){	
//						doActionIBSheet(sheetObject,formObject,ADD);
//					}					
//					break;
				case "btn_yd":
					var param = '?loc_port_ind=1';
				    param = param+'&node_cd='+formObject.s_re_yd_cd.value;
					ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getYardCd', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	 			   	
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
  			case IBSAVE:		//저장
  	 			// Save Validation 들어 가야함.
  				  	
  	  			if(!validateForm(sheetObj,formObj,sAction)) {
  	  				return false;
  	  			}
  	  					
  	  			// 저장 Operation
  	  			
//  				ComOpenWait(true);
  				formObj.f_cmd.value = MULTI;
  				var errMsg = "";
  				var sTmp = "";
  				
  				for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  					sheetObj.CellValue2(i,"s_trnsctn") = "Y";		// 트랜잭션 처리할 Row 
  					var chk = sheetObj.CellValue(i,"s_chk");		// User SAVE 처리 할려는 Row
  					if (chk == "Y" ||chk == "1"  ) {
	  					var sParam = sheetObj.GetSaveString(false, false,"s_trnsctn" ) + "&" + tpbFrmQryStr(formObj);
	  					var sXml = sheetObj.GetSaveXml("ESD_TPB_0140GS.do", sParam);
	  					var sRt = "";
	  	 				sRt = ComGetEtcData(sXml,"s_n3pty_no");
	  	 				if (sRt == ""||sRt == "null"||sRt == null||sRt == undefined){
	  	 					sheetObj.CellValue2(i,'s_n3pty_no') = "";
	  	 				} else {
	  	 					sheetObj.CellValue2(i,'s_n3pty_no') = sRt;
	  	 				}
	  	 				
	  					sTmp = sheetObj.CellValue(i,'s_n3pty_no');
	  					if (sTmp == "" || sTmp == null || sTmp == undefined) {
	  						errMsg = errMsg +  "\r\n" + "Seq: " + sheetObj.CellValue(i,'s_seq') + ",   ULH INV No.: " + sheetObj.CellValue(i,'s_src_inv_no');
	  					}
  					}
  					sheetObj.CellValue2(i,'s_trnsctn') = "";		// 현재 Row를 트랜잭션 처리 대상에서 제외
  				}
  				// Message 처리
  		  		if(errMsg == null || errMsg == ""){
  		  			ComShowCodeMessage("COM130102", "Data");
 					// Save 버튼 감준다.
 					document.all.btn_save_t.style.display = 'none';  
 					ComBtnDisable("btn_Load_Excel");
 					ComBtnDisable("btn_val_sp");
 					ComBtnDisable("btn_add");
 					ComBtnDisable("btn_delete");
 					
  		  		} else {
  		  			errMsg = "Failed to save data. " + errMsg;
  		  			ComShowMessage(errMsg);
  		  		}
//  				ComOpenWait(false);
  	  			break;
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				//sheetObj.RemoveAll();
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
  			case IBSEARCH_ASYNC01: 	//Cost Office 의  VAT Exchange Rate 조회 - 실제 존재하는 BL 유무 확인
  				formObj.f_cmd.value = SEARCH01;
  				sheetObj.WaitImageVisible = false;
  				var sParam = sheetObj.GetSaveString(false, false,"s_trnsctn" ) + "&" + tpbFrmQryStr(formObj);
  				var sXml = sheetObj.GetSearchXml("ESD_TPB_0140GS.do", sParam);
  				return ComGetEtcData(sXml,"s_trd_party_val");
  			
  				break;	
			case ADD: //ERP I/F    				
				formObj.f_cmd.value = ADD;
				div_processing_show(); // show processing image
				var errMsg = "";
				var sTmp = "";
				var iCnt = 0;
  				for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  
  					sheetObj.CellValue2(i,"s_trnsctn") = "Y";		// 트랜잭션 처리할 Row 
  					var chk = sheetObj.CellValue(i,"s_chk");		// User SAVE 처리 할려는 Row
  					if (chk == "Y" || chk == "1"  ) {
	  					var sParam = sheetObj.GetSaveString(false, false,"s_trnsctn" ) + "&" + tpbFrmQryStr(formObj);	
	  					var sXml = sheetObj.GetSaveXml("ESD_TPB_0140GS.do", sParam);
	  					sTmp = ComGetEtcData(sXml,"SucessYN");
	  					if (sTmp != "Y") {
	  						iCnt = iCnt + 1;
	  						errMsg = errMsg +  "\r\n" + "Seq: " + sheetObj.CellValue(i,'s_seq') + ",   SML Invoice No.: " + sheetObj.CellValue(i,'s_n3pty_inv_no');
	  					}
  					}
  					sheetObj.CellValue2(i,'s_trnsctn') = "";		// 현재 Row를 트랜잭션 처리 대상에서 제외
  				}		
  				
  				// Message 처리
  		  		if(errMsg == null || errMsg == ""){
  		  			ComShowMessage("ERP Interfaced Successfully");
  		  		} else {
  		  			errMsg = "Failed to execute ERP Interface " + "- Error Count : " + iCount + errMsg;
  		  			ComShowMessage(errMsg);
  		  		}
  				
				div_processing_hide(); // hide processing image	  				
				
  				break;
  		}
  	}
  	
	// show processing image 
	function div_processing_show(){
		document.all.div_processing.style.display = ''; 
	}
	
	// hide processing image 
	function div_processing_hide(){
		document.all.div_processing.style.display = 'none'; 
	}	  	
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if( sAction == IBSAVE ){
  				if(sheetObj.RowCount == 0){
  					ComShowCodeMessage("TPB90080");
  					return false; 
  				}
	          
  				//Validate S/P No 처리 하지 않은 경우
  				if (formObj.val_flag.value == "N"){
	  		  	  	ComShowCodeMessage("TPB90078","Validate S/P No");
	  				return false;
  				}
  				
  				//save row check  			
  				var saveRow = 0;
  				for ( var idx = 1; idx <= sheetObj.RowCount; idx++ ){
					var chk = sheetObj.CellValue(idx,"s_chk");
					var temp = sheetObj.CellValue(idx, "s_trd_party_val");
					if(temp =="" ||temp == null){
						sheetObj.CellValue2(idx,"s_chk") = 0 ;
						sheetObj.RowBackColor(idx) = sheetObj.RgbColor(255,168,80);
						chk = 0;
					}
					if (chk == "Y" ||chk == "1"){
						saveRow = saveRow+1 ;
					}
  				}
				if(saveRow == 0){
					ComShowCodeMessage("TPB90080");
					return false;
				}
				
				if( saveRow != sheetObj.RowCount ){
					ComShowCodeMessage("TPB90078","Validate S/P No");
					return false;
				}
				
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
	  				
	  			if(formObj.cost_month.value == ""){
	  				ComShowCodeMessage("COM130403","Cost Period","","");
	  				return false;
	  			}
	
	  			var sdate = formObj.s_sdate.value;
	  			var cdate = formObj.c_date.value;
	  			sdate = sdate.substring(0,4)+"-"+sdate.substring(4,6)+"-"+sdate.substring(6,8);
	  			    
	  			var ret = ComGetDaysBetween(cdate, sdate) ;  
	  		    if( ret > 0 ){
	  		    	ComShowCodeMessage("TPB90113","Cost Period", "Current Date");
	  		    	return false;
	  		    }
	  			
	  			if(formObj.s_curr.value == "" || formObj.s_curr.value == "<<Select>>"){
	  				ComShowCodeMessage("COM12113","Currency","","");
	  				return false;
	  			}
  			}
  		}
  		return true;
  	}
  	
  	// 자동 Grouping시 개별, Validation Alert를 무효/유효화하는 indicator 
  	var _alertSwitch = true;

  	
  	function sheet1_OnChange(sheetObj,Row,Col,Value){

  		if (sheetObj.ColSaveName(Col) == "s_trd_party_val" ){
  			if( sheetObj.CellValue(Row,Col).length < 6 ){
  				var strPrefix = "";
  				for( var idx=0; idx<6-sheetObj.CellValue(Row,Col).length; idx++ ){
  					strPrefix = strPrefix + "0";
  				}
  				sheetObj.CellValue2(Row,Col) = strPrefix + sheetObj.CellValue(Row,Col);
  			}
  			
  	  		var formObj = document.form;
  	  		var sRtn = "";
  	  		var errMsg = "";
  	  
  	  		sheetObj.CellValue2(Row,"s_trnsctn") = "Y";		// 트랜잭션 처리할 Row
  	  		sRtn = doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
  	  		sheetObj.CellValue2(Row,"s_trnsctn") = "";		// 트랜잭션 처리할 Row
  	  		
  	  		if (sRtn == undefined || sRtn == "FALSE" ) {
  	  			sheetObj.CellValue2(Row,"s_trd_party_val") = "";			
				ComShowCodeMessage('COM12114',"the S/P(Service Provider) Value! \nIt is a wrong value or doesn't have a Pseudo Customer Code \n(A pseudo customer will be registered using MDM System.)");
			}
  	  		sheetObj.CellValue2(Row,"s_chk") = "0";
  		}	
  	}
  	
  	function getCheckN3ptyNo(formObj, sheetObj){
  	    
  		var str = '';
  		var temp = '';
  		if(sheetObj.RowCount > 0){
      		for ( var i=2; i < sheetObj.RowCount+2; i++ ){
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
  	
  	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	function initControl() {		
		var formObj = document.form;
//  		document.form.s_n3pty_expn_tp_cd.onchange = s_n3pty_expn_tp_cd_OnChange;

//		axon_event.addListener('focus', 		's_dtl_OnFocus', 			's_dtl'); 
//		axon_event.addListener('change', 		's_if_ofc_cd_OnChange', 	's_if_ofc_cd'); 
//		
//	    //Axon 이벤트 처리1. 이벤트catch
//		axon_event.addListenerFormat('blur', 			'obj_deactivate',  		formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리	
//		axon_event.addListenerFormat('focus', 			'obj_activate'  ,  		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//	    axon_event.addListenerFormat('keypress', 		'obj_keypress'  , 		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리	    
//	    axon_event.addListenerFormat('keyup', 			'obj_keyup'     ,  		formObj);
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

  			var p_state = "1" ;
  			if(p_state == 1){
  				getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd"));
  			}else{
  				getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_bil_tp_cd", "s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd", "s_jo_display"));
  			}
  		}
 	}
 	
  	/**
  	 *  SML S/P NO 가 존재 하지 않으면 Sheet Row 의 Back Color를 변경한다.
  	 */
  	function check_sp_existence(sheetObj, row) {
		var temp = sheetObj.CellValue(row,  's_trd_party_val'); 
  		if ( temp == "" || temp == null ){
  			sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,168,80);
  		}
  	}
 	
  	
  	/**
  	 * SML S/P NO 가 존재 하고 DB에 저장된 값인지 Check 
  	 */
  	function check_sp_validation() {

  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];
  		var sRtn = "";
  		var sTrdPtyVl = "";
  		var tmpTrdPtyVl = "";
  		var errMsg = "";
  		var tmp = 0 ;
  		
		for ( var idx = 1; idx <= sheetObj.RowCount; idx++ ){

			sheetObj.CellValue2(idx,"s_trnsctn") = "Y";		// 트랜잭션 처리할 Row 
			sTrdPtyVl = sheetObj.CellValue(idx, 's_trd_party_val');
			if( idx == 1 ){
				tmpTrdPtyVl = sheetObj.CellValue(idx, 's_trd_party_val'); // 동일한 S/P인지 여부 체크를 위해 첫 번째 S/P의 값 저장 후 비교에 사용
			}
			
			// SML S/P NO 값이 없는 것은 대상에서 제외됨
			if ( sTrdPtyVl != "" && sTrdPtyVl != null ){

				sRtn = doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
			
  				if (sRtn == undefined || sRtn == "FALSE" || sTrdPtyVl != tmpTrdPtyVl ) {
  					errMsg = errMsg +  "\r\n" + "Seq: " + sheetObj.CellValue(idx,'s_seq') + ",   SML S/P No.: " + sheetObj.CellValue(idx,'s_trd_party_val');
  					sheetObj.CellValue2(idx, "s_chk") = "0";
  					sheetObj.RowBackColor(idx) = sheetObj.RgbColor(255,168,80);
  				} else {
  					sheetObj.CellValue2(idx, "s_chk") = "1";
  					sheetObj.RowBackColor(idx) = sheetObj.RgbColor(255,255,255);
  				}
  				
			} else {
				errMsg = errMsg +  "\r\n" + "Seq: " + sheetObj.CellValue(idx,'s_seq') + ",   SML S/P No.: " + sheetObj.CellValue(idx,'s_trd_party_val');
				sheetObj.CellValue(idx, "s_chk") = "0";
				sheetObj.RowBackColor(idx) = sheetObj.RgbColor(255,168,80);
			}
			sheetObj.CellValue2(idx,"s_total") =sheetObj.CellValue(idx,"s_dtl_amt") * 1 + sheetObj.CellValue(idx,"s_tax") * 1;
			sheetObj.CellValue2(idx,"s_trnsctn") = "";		// 트랜잭션 처리할 Row
			sheetObj.CellValue2(idx,"grp_cfm_seq") = idx - 1;
		}
		
		// Message 처리
		if(errMsg != null && errMsg != ""){
			formObj.val_flag.value = "N";
			errMsg = "Wrong S/P No. " + errMsg;
			ComShowMessage(errMsg);
		}else{
			formObj.val_flag.value = "Y";
		}
  	}
 
  	/**
  	 * SML S/P NO 가 존재 하고 DB에 저장된 값인지 Check 
  	 */
  	function get_month_info() {
  		
  		var formObj = document.form;
  		var yearmm = formObj.cost_month.value; 
  		var yy = yearmm.substr(0,4);
  		var mm =  yearmm.substr(5,2);
  		var lastday = "";

  		lastday = ComGetLastDay(yy*1,mm*1);
  		
  		formObj.s_sdate.value = yy + mm + "01";
  		formObj.s_edate.value = yy + mm + lastday;
  
  	}

	function getYardCd(rowArray) {
		var colArray = rowArray[0];
		document.all.s_re_yd_cd.value =  colArray[3];   	
	}
	
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		get3rdPartyTarget_sheet( "SP2", Row, Col, sheetObj );
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
	

    function s_if_ofc_cd_OnChange(){
    	var formObj = document.form;
    	formObj.s_ofc_cd.value = formObj.s_if_ofc_cd.Code ; 
    	getTPBGenCombo('s_curr','searchCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", ""));
   
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