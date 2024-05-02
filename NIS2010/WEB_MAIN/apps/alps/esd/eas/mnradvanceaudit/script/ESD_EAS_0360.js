/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0360.js
*@FileTitle : M&R Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-14 Jeong-Min Park
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class ESD_EAS_0360 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0360() {
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
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code
	
	var timer = null;
	var sheetNum = null;
	
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
			case "btn_confirm":
				doActionIBSheet(sheetObject,formObject, MODIFY01);
			    break;
			case "btn_detail":
				goDetail();
			    break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
            case "btn_start_dt":
            	var cal = new ComCalendar();
	            cal.select(formObject.s_start_dt, "yyyy-MM-dd");
            	break;
            case "btn_end_dt":
            	var cal = new ComCalendar();
            	cal.select(formObject.s_end_dt, "yyyy-MM-dd");
            	break;  			
	        case "btn_sp_cd":	// S/P No. Popup 
	    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 699, 402, 'callBackVendor', '1,0,1,1,1',true);
	        	break;
			case "inv_no_multi1":  
				rep_Multiful_inquiry("s_inv_no", "Invoice No."); 
				break;	
			case "csr_no_multi1":  
				rep_Multiful_inquiry("s_csr_no", "CSR NO."); 
				break;
			case "btng_rebatch":
				doActionIBSheet(sheetObject,formObject, MULTI03);
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

		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			ComConfigSheetEas(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
		
//		ComBtnDisable("btn_confirm"); // Save 버튼 비활성화 
		
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
  		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
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
					style.height = GetSheetHeight(17);
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
					var HeadTitle = "||Seq.|Select|Select Temp|Auto Audit|Audit Result|||||Change Detail|Change Detail|RHQ|Invoice Office|Cost Group|eq_knd_cd|vndr_seq|S/P Name|" +
									"Inovice No.|INV Issued Date|INV Confirm Date|Inv Remark|CSR Status|inv_sts_cd|CSR No.|" +
									"W/O\nCurr.|W/O Amount|Inv Cur.|Inv Amount|Curr.\nConversion|DIFF\nAmount|Diff\nRatio|Diff Amount($)\nby Auditor|aud_curr_cd|aud_diff_amt|Est Error|W/O Error|" +
									"Inv User.|Audit Date|Checked By|Payment\nTerm|Payment\nDue Date|Paid Date|Multi W/O\nCurrency|" +
									"mnr_agmt_amt|mnr_wrk_amt|ttl_inv_amt|spr_prt_uc_amt|bzc_amt|cfm_dt|wo_inv_rto|expn_max_prmt_rto|EAC I/F|ATCH_FILE_LNK_ID|RE-BATCH\nStatus|bat_prog_sts_cd";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 7, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtCheckBox,	30,		daCenter,	true,	"sel",				false,    		"",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtStatus,	0,		daCenter,	false,	"ibflag",			false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtSeq,		50,		daCenter,	true,	"seq",				false,    		"",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtCombo,		80,		daCenter,	false,	"select_flg",		false,          "",       dfNone,    0,    true,        true);
					InitDataProperty(0, cnt++, dtHidden,	80,		daCenter,	false,	"select_flg_temp",	false,          "",       dfNone,    0,    true,        true);
					InitDataProperty(0, cnt++, dtCombo,		120,	daCenter,	false,	"auto_audit",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtCombo,		120,	daCenter,	false,	"audit_result",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	120,	daCenter,	false,	"est_vrfy_desc",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden, 	50, 	daLeft, 	true, 	"expn_aud_rslt_usr_nm", false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++, dtHidden, 	50, 	daLeft, 	true, 	"expn_aud_rslt_usr_id", false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++, dtHidden, 	50, 	daLeft, 	true, 	"s_save_tp_cd", 	false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++, dtData,		30,		daCenter,	false,	"expn_aud_rslt_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtPopup, 	130, 	daLeft, 	true, 	"expn_aud_rslt_rmk",false,    		"", 	  dfNone, 	 0,		true, 		  true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"rhq_inv_ofc_cd",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"inv_ofc_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"eq_knd_cd_nm",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	120,	daCenter,	false,	"eq_knd_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	100,	daCenter,	false,	"vndr_seq",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,		false,	"vndr_nm",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"inv_no",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"iss_dt",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"cfm_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		200,	daLeft,		false,	"inv_rmk",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"inv_sts_nm",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"inv_sts_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		150,	daCenter,	false,	"csr_no",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	false,	"wo_curr_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"cost_amt",			false,          "",       dfFloat,   2,		false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"inv_curr_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"inv_chg_amt",		false,          "",       dfFloat,   2,   false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"refl_ex_yn",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daRight,	false,	"chg_wo_amt",		false,          "",       dfFloat,   2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daRight,	false,	"inv_diff_pct",		false,          "",       dfFloat,   2,    false,       true);
					/* 추가::START */
					InitDataProperty(0, cnt++ , dtData,     100,  	daRight,    true,   "inv_aud_usd_diff_amt",     false,  "",		  dfNullFloat,     2, false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   65,  	daRight,    true,   "inv_aud_curr_cd",     		false,  "",       dfNone,          0, false,    true);
					InitDataProperty(0, cnt++ , dtHidden,   65,  	daRight,    true,   "inv_aud_diff_amt",     	false,  "",       dfNullFloat,     2, false,    true);
					/* 추가::END */
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"est_vrfy_yn",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"wk_vrfy_yn",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daCenter,	false,	"inv_cre_user_nm",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"audit_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daCenter,	false,	"checked_user_nm",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"gen_pay_term_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"pay_due_dt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"ap_pay_dt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"mlt_wo_curr_flg",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"mnr_agmt_amt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"mnr_wrk_amt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"ttl_inv_amt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"spr_prt_uc_amt",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"bzc_amt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"cfm_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"wo_inv_rto",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"expn_max_prmt_rto",false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	false,	"eac_yn",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	60,		daCenter,	false,	"atch_file_lnk_id",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	false,	"bat_prog_sts_nm",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	80,		daCenter,	false,	"bat_prog_sts_cd",	false,          "",       dfNone,    0,    false,       true);
					
					InitDataCombo(0, 'auto_audit', auto_auditText, auto_auditCode);
					InitDataCombo(0, 'audit_result', audit_resultText, audit_resultCode);
					InitDataCombo(0, 'select_flg', select_flgText, select_flgCode, "", "P");

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
				//20160311 BackEndJob 제거-->
//				if(!validateForm(sheetObj,formObj,sAction)) {
//					return false;
//				}
//
//    			sheetObj.WaitImageVisible=false;
//    			ComOpenWait(true);
//				formObj.f_cmd.value = SEARCH;
//    			
//    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GS.do",EasFrmQryString(formObj));
//    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
//    			
//    			if (backendJobKey.length > 0) {
//					formObj.backendjob_key.value = backendJobKey;
//					sheetObj.RequestTimeOut = 10000;
//					timer = setInterval(getBackEndJobStatus, 3000);
//					sheetNum = sheetObj;
//				}
    			//<--20160311 BackEndJob 제거
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.RemoveAll();
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GSAdap.do",EasFrmQryString(formObj));
					sheetObj.LoadSearchXml(sXml);
				}
				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
				
			case MODIFY01:	// confirm
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("EAS00009"));
					return false;
				} else {
					var checkedRow = sheetObj.FindCheckedRow("sel");
					var rowArr = checkedRow.split("|"); 
					for(i=0; i < rowArr.length-1; i++) {
						sheetObj.CellValue( rowArr[i], "s_save_tp_cd") = '';
						if( sheetObj.CellValue( rowArr[i], "select_flg") == '') {
							ComShowMessage(ComGetMsg("EAS80001", "[Select] column"));
							return false;
						}
						if ((getEasAudCdMapg(sheetObj.CellValue( rowArr[i], "select_flg")) != sheetObj.CellValue( rowArr[i], "auto_audit")) 
								&& sheetObj.CellValue( rowArr[i], "expn_aud_rslt_rmk") == "") {
							ComShowMessage(ComGetMsg("EAS05014", "Change reason"));
							sheetObj.SelectCell(rowArr[i], "expn_aud_rslt_rmk", false);
							return false;
						}	
						
						if( sheetObj.CellValue( rowArr[i], "bat_prog_sts_cd") == 'P') {
							ComShowCodeMessage('EAS90214'); //Already invoice included in re-batch target
							return false;
						}

					}
					
					if( !confirm(ComGetMsg("EAS90046", "Confirm"))) {
						return false;
					}
					formObj.f_cmd.value = MODIFY01;
	            	var isSuccess = sheetObj.DoSave("ESD_EAS_0360GS.do",EasFrmQryString(formObj),'sel',false);
					
		    		if(!isSuccess){
		    			return false;
		    		} else {
						for (var idx=0; idx < rowArr.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
							sheetObj.CellValue2(rowArr[idx], "audit_result") = sheetObjects[0].CellValue(rowArr[idx], "select_flg");
							sheetObj.CellValue2(rowArr[idx], "chk") = "";
							sheetObj.RowBackColor(rowArr[idx]) = sheetObjects[0].RgbColor(245,235,245);
							sheetObj.RowFontColor(rowArr[idx]) = sheetObjects[0].RgbColor(100,100,100);
							//sheetObjects[0].CellEditable(arrRow[idx], "chk") = false;
							//sheetObjects[0].CellEditable(arrRow[idx], "sel_aud_cd") = false;
						}
		    		}

				}
				break;			
			
			case COMMAND02:     // Cost Combo
				formObj.f_cmd.value = sAction;	// COMMAND02
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GS.do", FormQueryString(formObj));
				createCustomCombo("Cost", ComGetEtcData(sXml, "cost"));	//Account & Cost 초기화
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
            		ComBtnDisable("btn_confirm"); // Save 버튼 비활성화
        		}else if(ofcLevel=="R"){
            		formObj.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
        			rhqSearchFlag = false;
        			formObj.s_rhq_ofc_cd.Enable=false;
        			formObj.s_ofc_cd.Enable=true;        			
        			formObj.s_rhq_ofc_cd.Code=formObj.ofc_cd.value;
//        			ComBtnEnable("btn_confirm"); // Save 버튼 활성화 
        			ComBtnDisable("btn_confirm"); // Save 버튼 비활성화
        		}else if(ofcLevel=="H"){
        			// 본사(심사팀) 소속
            		rhqSearchFlag = true;
            		formObj.s_rhq_ofc_cd.Enable=true;
            		formObj.s_ofc_cd.Enable=true;              
            		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		formObj.s_ofc_cd.code2 = formObj.ofc_cd.value;
        			ComBtnEnable("btn_confirm"); // Save 버튼 활성화 
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
			case MULTI02:
            	formObj.f_cmd.value = MODIFY01;
            	
				var sRow = sheetObj.FindCheckedRow("sel");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 	
				var arrRow = sRow.split("|");					// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태
				
				//  EAC Interfce 대상으로 선택된 Row 가 없을 경우. Error
				if (arrRow.length == 1) {
					ComShowCodeMessage("COM12189");
			   		return;
				}
				
				for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
//					if( sheetObj.CellValue( arrRow[idx], "audit_result") == '') {
//						ComShowMessage(ComGetMsg("EAS80001", "[Select] column"));
//						return false;
//					}
					
					if( sheetObj.CellValue( arrRow[idx], "bat_prog_sts_cd") == 'P') {
						ComShowCodeMessage('EAS90214'); //Already invoice included in re-batch target
						return false;
					}
				}

            	
				var sParam = sheetObj.GetSaveString(false, true,"s_save_tp_cd") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0360GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	    		
	    		
				if (State != "S") {
					return false;
				} else if (State == "S") {
					var sRow = sheetObj.SelectRow;
//					sheetObj.CellValue2(sRow, "s_save_tp_cd") = "";
//					sheetObj.CellValue2(sRow, "locl_cre_dt") = ComGetNowInfo("ymd");
				}
				break;
				
			case MULTI03:
				//selected row
				var sRow = sheetObj.FindCheckedRow("sel");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
				var arrRow = sRow.split("|");					// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태
				if (arrRow.length == 1) {
					ComShowCodeMessage("COM12189");
			   		return;
				}
				
				for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
					if( sheetObj.CellValue( arrRow[idx], "bat_prog_sts_cd") == 'P') {
						ComShowCodeMessage('EAS90214'); //Already invoice included in re-batch target
						return false;
					}
				}
				
				if (!ComShowCodeConfirm("EAS90099", "Re-Batch")) return; // Do you want to {?msg1}?
            	formObj.f_cmd.value = MODIFY03;
            	var sParam = sheetObj.GetSaveString(false, true,"sel") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0360GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('EAS90214'); //Already invoice included in re-batch target
					return false;
				} else if (State == "S") {
					for( var i=0; i<arrRow.length-1; i++ ) {
						iRow = arrRow[i];
						sheetObj.CellValue(iRow, "bat_prog_sts_cd") = 'P';
						sheetObj.CellValue(iRow, "bat_prog_sts_nm") = 'Progressing';
						sheetObj.CellBackColor(iRow, "sel") = sheetObjects[0].RgbColor(255,190,130);
					}
				}
				break;
		}
	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		/*
		for(var idx=1;idx<=sheetObj.RowCount;idx++){
			if(sheetObj.CellValue(idx, "select_flg") == 'P' && sheetObj.CellValue(idx, "select_flg_temp") == ''){
				// pass일경우에는 pass(글자회색) 및 (체크박스), comfirm하면 체크 풀리고 select값 지우기
				sheetObj.CellValue2(idx, "sel") = "1";
				sheetObj.CellFont("FontBold", idx,"select_flg") = true;
				sheetObj.CellFont("FontItalic", idx,"select_flg") = true;
				sheetObj.CellFont("FontColor", idx,"select_flg") = sheetObj.RgbColor(192,192,192);	// 회색
			}else{
				// Confirmed 된 것은 Select란이 역시 공란이나 다른 것으로 선택 및 변경 가능
				sheetObj.CellValue2(idx, "select_flg") = "";
			}

			// Pass는  자동 계산 값은 Pass, confirm된 값은 Passed
			if(sheetObj.CellValue(idx, "select_flg_temp") == 'P'){
				sheetObj.CellValue2(idx, "select_flg_temp") = "Passed";
			}

			if(sheetObj.CellValue(idx, "eac_no") != ''){
				sheetObj.CellValue2(idx, "select_flg_temp") = "EAC I/F";
				// Confirm하여 EAS Transfer한 경우는 EAC I/F로 저장 및 조회(수정불가) 가능.
				sheetObj.CellEditable(idx, "sel") = false;
				sheetObj.CellEditable(idx, "select_flg") = false;
			}
			
			// 심사된 것은 행 전체 글자를 회색으로 표시
			if(sheetObj.CellValue(idx, "select_flg_temp") != ''){
				sheetObj.RowFontColor(idx) = sheetObj.RgbColor(192,192,192);	// 회색
			}
		}
		*/
	}

	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			
			sheetObj.RemoveAll();
			formObj.reset();
//			formObj.s_rhq_ofc_cd.Code = "";
			formObj.s_start_dt.value = ComGetDateAdd(null, "d", -30, "-");
			formObj.s_end_dt.value = ComGetDateAdd(null, "d", 0, "-");
			formObj.s_cost_group_cd.Code = "";
			formObj.s_vndr_seq.value = "";
			formObj.s_vndr_nm.value = "";
			formObj.s_auto_aud_sts_cd.Code = "";
			formObj.s_expn_aud_sts_cd.Code = "";
			formObj.s_difference.Code = "";
			
			formObj.s_inv_no.value = "";
			formObj.s_csr_no.value = "";
			formObj.s_csr_status.Code = "";
			
//			formObj.s_ofc_cd.RemoveAll();
//			formObj.s_ofc_cd.InsertItem(0, "", "");
//			formObj.s_ofc_cd.Code2 = "";
			
			formObj.s_err_type.RemoveAll();
//			formObj.s_err_type.InsertItem(0, "", "");
//			formObj.s_err_type.Code2 = "";
			
			
			var s_popup_flg = formObj.s_popup_flg.value;

			if (s_popup_flg == "Y") {
				formObj.s_rhq_ofc_cd.Code = formObj.s_popup_rhq_cd.value;
				formObj.s_ofc_cd.code2 = formObj.s_popup_inv_ofc_cd.value;
				formObj.s_start_dt.value = formObj.s_popup_fm_dt.value;
				formObj.s_end_dt.value = formObj.s_popup_to_dt.value;
				formObj.s_auto_aud_sts_cd.code2 = formObj.s_popup_auto_aud_sts_cd.value;
				formObj.s_expn_aud_sts_cd.code2 = formObj.s_popup_expn_aud_sts_cd.value;
				
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GSAdap.do",EasFrmQryString(formObj));
				sheetObj.LoadSearchXml(sXml);
			}
	}

	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_vndr_seq":
				vender_change();
			break;
		}
	} 	

	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_start_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_end_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_start_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			getMonthBetween();
			break;	
		case "s_end_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			getMonthBetween();
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
				// The period cannot exceed 90 days.
				if(ComGetDaysBetween(formObj.s_start_dt, formObj.s_end_dt) < 0){
					ComShowMessage(msgs['EAS90027']);
					formObj.s_end_dt.value = ComGetDateAdd(formObj.s_start_dt.value, "d", +30, "-");
	                ComSetFocus(formObj.s_start_dt);
	                return false;
				}
				if(ComGetDaysBetween(formObj.s_start_dt, formObj.s_end_dt) > 90){
					ComShowMessage(msgs['EAS90087']);
	                ComSetFocus(formObj.s_start_dt);
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
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "s_rhq_ofc_cd": 	//RHQ OFFICE
				with (comboObj) { 
					setComboData(comboObj);
				}
			break;
				
			case "s_ofc_cd":		//OFFICE
				with (comboObj) { 
				}
			break;	    

			case "s_cost_group_cd":		//COST GROUP CODE (MNR_GEN_CD : CD00004 
				with (comboObj) { 
					setComboData(comboObj);
				}
			break; 
			
			case "s_cost_cd":		//COST CODE MNG_GEN_CD : (UG, GG, ZG) 
				with (comboObj) { 
					MultiSelect = true; 
					SetColWidth("80|250");
				}
			break; 	
			
			case "s_auto_aud_sts_cd":		//AUTO AUDIT STATUS CODE
				with (comboObj) { 
					setComboData(comboObj);
				}
			break;
			case "s_expn_aud_sts_cd":		//EXPENSE AUDIT STATUS CD
				with (comboObj) { 
					setComboData(comboObj);
				}
			break;
			case "s_difference":		//DIFFERENCE
				with (comboObj) { 
					setComboData(comboObj);
				}
			break;
			case "s_err_type":		//ERROR TYPE
				with (comboObj) { 
					MultiSelect = true; 
					SetColWidth("80|250");
				}
			break;
			case "s_csr_status":		//CSR STATUS CODE
				with (comboObj) { 
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
		        
		        if(param == "ALL"){
		        	return;
		        }
		        
		        frm.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		    	ComXml2ComboItem(sXml, comboObj, "ofc_cd", "ofc_cd");
		    	comboObj.InsertItem(0, "", "");
	    		comboObj.Code2 = "";
				break;
			case "s_cost_group_cd":
				searchCommonCombo("CD01132", comboObj, true);
				break;
			case "s_cost_cd":
				if(param == "ALL"){
					comboObj.RemoveAll();
					return;
				}
				
				var f_query = '';
				//쿼리 스트링 조합시작
				f_query += 'f_cmd' + '=' + SEARCH + '&';

				f_query += 'ibflag=X&';
				f_query += 'del_chk=0&';
				f_query += 'searchinfo=MnrGenCd&';
				f_query += 'searchcon=COMMON&';
				f_query += 'searchkey=' + param + "G";

				var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
				
				ComXml2ComboItem(sXml, comboObj, "cd_id", "cd_id|cd_desc");
				
				break;
			case "s_auto_aud_sts_cd":
				searchCommonCombo("CD03417", comboObj, true);
				break;
			case "s_expn_aud_sts_cd":
				searchCommonCombo("CD03410", comboObj, true);
				break;
			case "s_csr_status":
				searchCommonCombo("CD03411", comboObj, true);
				break;
			case "s_difference":
				comboObj.InsertItem(0, "Estimate Error", "E");
				comboObj.InsertItem(1, "W/O Error", "W");
				comboObj.InsertItem(2, "Unmatch Between W/O & INV", "U");
				comboObj.InsertItem(3, "Multi W/O Currency", "M");
				comboObj.InsertItem(0, "", "");
				
				comboObj.Code2 = "";
				break;
			case "s_err_type":
		        comboObj.RemoveAll();
		        
		        if(param == ""){
//			    	comboObj.InsertItem(0, "|", "");
//		    		comboObj.Code2 = "";
		        	return;
		        }
		        
		        frm.f_cmd.value = SEARCH10;
		        if(param == "U"){
//			    	comboObj.InsertItem(0, "|", "");
		        	comboObj.InsertItem(0, "ZERO|Diff AMT Zero", "ZERO")
		        	comboObj.InsertItem(1, "PLUS|Adjusted Invoice Amount(Plus)", "PLUS")
		        	comboObj.InsertItem(2, "MINUS|Adjusted Invoice Amount(Minus)", "MINUS")
		    		comboObj.Code2 = "";
		        } else if(param == "M") {
		        } else {
			        frm.s_mnr_code_type.value = param;
			        var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GS.do", FormQueryString(frm));
			    	ComXml2ComboItem(sXml, comboObj, "code_cd", "code_cd|code_nm");
//			    	comboObj.InsertItem(0, "|", "");
//		    		comboObj.Code2 = "";
		        }
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
	 * Cost Group Code 데이터 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function s_cost_group_cd_OnChange(comboObj, Index_Code, Text){
		var frm = document.form;
		setComboData(frm.s_cost_cd, Index_Code); // RHQ
	}	 

	/**
	 * Difference 데이터 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function s_difference_OnChange(comboObj, Index_Code, Text){
		var frm = document.form;
		setComboData(frm.s_err_type, Index_Code); // RHQ
	}
	
	
	/**
	 * Difference 데이터 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function s_difference_OnChange(comboObj, Index_Code, Text){
		var frm = document.form;
		setComboData(frm.s_err_type, Index_Code); // RHQ
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
	
	/**
	 * 월 비교
	 */
	function getMonthBetween() {
		
	}
	
	
	/**
	* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
	*/
	function callBackVendor(rowArray) {
		var frm = document.form;
		for(var i=0; i<rowArray.length; i++) 
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			frm.s_vndr_seq.value =colArray2;
			frm.s_vndr_nm.value =colArray4;
		}
	}
	
	function s_cost_cd_OnCheckClick(comboObj, index, text){
		var frm = document.form;
	}
	
	
  	/**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	var sParam = Array();
    	var formObj = document.form;

    	goDetailPopup(sheetObj.CellValue(Row, "inv_no"), sheetObj.CellValue(Row, "vndr_seq"), sheetObj.CellValue(Row, "vndr_nm"), sheetObj.CellValue(Row, "eq_knd_cd"), formObj.s_cost_cd.Code, formObj.s_difference.Code, formObj.s_err_type.Code);
		
		return;
    }

    /**
     * Sheet내에서 Audit Status(Select Flg) 변경시
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     */
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
	
	function goDetail(){
		var sheetObj = sheetObjects[0];
		
		var row = sheetObj.SelectRow;
		
		var formObj = document.form;
		
		goDetailPopup(sheetObj.CellValue(row, "inv_no"), sheetObj.CellValue(row, "vndr_seq"), sheetObj.CellValue(row, "vndr_nm"), sheetObj.CellValue(row, "eq_knd_cd"), formObj.s_cost_cd.Code, formObj.s_difference.Code, formObj.s_err_type.Code);
	}
	
	function goDetailPopup(invNo, vndrSeq, vndrNm, eqKndCd, sCostCd, sDifference, sErrType){
    	var sParam = Array();
    	var formObject = document.form;
    	
		sParam[0] = "s_inv_no="+invNo;
		sParam[1] = "s_vndr_seq="+vndrSeq;
		sParam[2] = "s_eq_knd_cd="+eqKndCd;
		sParam[3] = "s_vndr_nm="+encodeURIComponent(vndrNm);
		sParam[4] = "s_difference="+sDifference;
		sParam[5] = "s_err_type="+encodeURIComponent(sErrType);
		sParam[6] = "s_cost_cd="+encodeURIComponent(sCostCd);
		
        ComOpenWindowCenter("ESD_EAS_0361.do?"+sParam.join("&"), "setEAC_IF", "1030", "535", true, "no");
		
		return;
	}
	
	/**
	 * 
	 */
	function fn_setEacIfFlg(eacNo){
		var sRow = sheetObjects[0].SelectRow;
		sheetObjects[0].CellValue2(sRow,'eac_yn') = "Y";
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetNum.GetSearchXml("ESD_EAS_0360GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") {
			ComShowCodeMessage("EAS90207");
			ComOpenWait(false);
			sheetNum.WaitImageVisible = true;
			clearInterval(timer);
		} else if (jobState == "5") {
			ComShowCodeMessage("EAS90208");
			clearInterval(timer);
		}
	}
	
	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH03;
		ComOpenWait(false);
		var sXml = sheetNum.GetSearchXml("ESD_EAS_0360GSAdap.do", FormQueryString(form));
		sheetNum.LoadSearchXml(sXml);
	}
	
	
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function  vender_change(){
		formObj = document.form;
		if(formObj.s_vndr_seq.value =="" ){
			formObj.s_vndr_seq.value="";
			formObj.s_vndr_nm.value="";
			return;
		}

		var sParam = Array();
		sParam[0] = "f_cmd="+ SEARCH05;
		sParam[1] = "s_vndr_seq="+ formObj.s_vndr_seq.value;
		var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", sParam.join("&"));
		var vndrNm = EasXmlString(sXml,"vndr_nm");
		
		if(vndrNm==0){
			ComShowCodeMessage('COM132202', 'Inv. S/P'); //사용할수 없는 S/P Code 
			formObj.s_vndr_seq.value="";
			formObj.s_vndr_nm.value="";
			return;
		}
		formObj.s_vndr_nm.value = vndrNm;
	}

	
	  /**
   * Sheet1에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObjects[0].ColSaveName(col);
	  var formObj = document.form;
	  switch(colName){
	  	case('expn_aud_rslt_rmk'):
			formObj.pop_parent_row.value = row;
			formObj.pop_expn_aud_rslt_usr_nm.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_usr_nm");
			formObj.pop_expn_aud_rslt_usr_id.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_usr_id");
			formObj.pop_expn_aud_rslt_rmk.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_rmk");
			formObj.pop_ofcLevel.value = ofcLevel;
			formObj.pop_mdl_tp_cd.value = 'MNR';
			formObj.pop_auto_aud_sts_cd.value = sheetObjects[0].CellValue(row, "auto_audit");
			formObj.pop_expn_aud_sts_cd.value = sheetObjects[0].CellValue(row, "audit_result");
			formObj.pop_atch_file_lnk_id.value = sheetObjects[0].CellValue(row, "atch_file_lnk_id");
			formObj.pop_expn_aud_rslt_cd.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_cd");
			formObj.pop_inv_no.value = sheetObjects[0].CellValue(row, "inv_no");
			
			var pop_inv_aud_curr_cd = sheetObj.CellValue(row, "inv_aud_curr_cd");
			if ( pop_inv_aud_curr_cd == null || pop_inv_aud_curr_cd == "")
				pop_inv_aud_curr_cd = sheetObj.CellValue(row, "wo_curr_cd");
			
			formObj.pop_inv_aud_curr_cd.value 	= pop_inv_aud_curr_cd;
			formObj.pop_inv_usd_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_usd_diff_amt");
			formObj.pop_inv_aud_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_diff_amt");
			formObj.pop_inv_cfm_dt.value 		= sheetObj.CellValue(row, "cfm_dt");
			
			if (sheetObj.CellValue(row, "atch_file_lnk_id").length > 0) {
				formObj.pop_atch_file_lnk_flg.value = "Y";
			}else{
				formObj.pop_atch_file_lnk_flg.value = "";
			}
			
			var sParam = Array();
			sParam[0] = "sel_aud_cd="+ sheetObj.CellValue(row, "select_flg");
			var theURL = "ESD_EAS_0225.do?"+sParam.join("&");
			
		   	var winName = "AuditRemarkPopup";
		   	var features = "scroll:yes;status:no;resizable=no;help:no;dialogWidth:700px;dialogHeight:380px";
		   	ComOpenWindow(theURL,winName,features,true);
	  }
  }
  
	/**
	 * Audit Remark 리턴값 설정
	 */ 
	function fn_setAuditRemark(rmk, name, id, rslt_cd, save_tp, file) {
		var formObj = document.form;
		var sRow = sheetObjects[0].SelectRow;
		
		if (save_tp == 'S') {
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_cd') = rslt_cd;
		}

		sheetObjects[0].CellValue2(sRow,'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow,'rslt_chk') = '1';
		
		// EAC공통 팝업에서 처음에 S의 코드만 내려오다 추가로 F의 값도 추가 S로 통일
		save_tp = save_tp == "F" ? "S" : save_tp;
		
		sheetObjects[0].CellValue2(sRow,'s_save_tp_cd') = save_tp;
		
		if(sheetObjects[0].CellValue(sRow, "sel") == "0"){
			sheetObjects[0].CellValue(sRow, "sel") = "1"
		}
			
		
		doActionIBSheet(sheetObjects[0],formObj, MULTI02);
	}
	
	
	/**
	 * Audit Remark 리턴값 설정
	 */ 
	function fn_setAuditRemark2(rmk, name, id, rslt_cd, save_tp, file, curr_cd, aud_diff_amt, usd_diff_amt) {
		var formObj = document.form;
		var sRow = sheetObjects[0].SelectRow;
		
		if (save_tp == 'S') {
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_cd') = rslt_cd;
		}

		sheetObjects[0].CellValue2(sRow,'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow,'rslt_chk') = '1';
		
		sheetObjects[0].CellValue(sRow, "inv_aud_curr_cd") = curr_cd;
		sheetObjects[0].CellValue(sRow, "inv_aud_diff_amt") = aud_diff_amt;
		sheetObjects[0].CellValue(sRow, "inv_aud_usd_diff_amt") = usd_diff_amt;
		
		// EAC공통 팝업에서 처음에 S의 코드만 내려오다 추가로 F의 값도 추가 S로 통일
		save_tp = save_tp == "F" ? "S" : save_tp;
		
		sheetObjects[0].CellValue2(sRow,'s_save_tp_cd') = save_tp;
		
		if(sheetObjects[0].CellValue(sRow, "sel") == "0"){
			sheetObjects[0].CellValue(sRow, "sel") = "1"
		}
			
		doActionIBSheet(sheetObjects[0],formObj, MULTI02);
	}