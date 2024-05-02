/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ESD_EAS_0340.js
*@FileTitle : Transportation Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-5-15
*@LastModifier : Sung-Gil Hyun
*@LastVersion : 1.0
* 2015-5-15 Sung-Gil Hyun
* 1.0 최초 생성
*  
=========================================================*/

	function ESD_EAS_0340() {
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
	
	// offce_level 설정 H : 본부, R:RQH, O: 기타
	var ofcLevel="";   

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject = sheetObjects[0];
		
		 /** *************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
				break;
			case "btn_new":
				ComResetAll();
				loadPage();
				break;				
			case "btn_confirm":
				formObj.s_save_tp_cd.value = 'C';
				doActionIBSheet(sheetObject,formObj, MULTI01);
				break;		

			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
				
			case "btn_vndr_seq":
				rep_OnPopupClick();
				break;
				
			case "btns_calendar_s":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObj.s_fm_dt, 'yyyy-MM-dd');
   	         	break;

            case "btns_calendar_e":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObj.s_to_dt, 'yyyy-MM-dd');
   	         	break;
   	         	
            case "btng_detail":
            	var sRow = sheetObject.SelectRow;
            	if (sRow > 0) {
            		 detail_OnPopupClick(sheetObject, sRow);
            	}
            	break;
            case "btng_rebatch":
				doActionIBSheet(sheetObject,formObj, MULTI03);
				break;	
			case "inv_no_multi1":  
				rep_Multiful_inquiry("s_inv_no", "Invoice No. "); 
				break;	
			case "csr_no_multi1":  
				rep_Multiful_inquiry("s_csr_no", "CSR No."); 
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
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	 
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는
	 * 기능을 추가한다
	 */
	function loadPage() {
		formObj = document.form;													
		for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet(sheetObjects[i]);
			ComConfigSheetEas(sheetObjects[i])
			initSheet(sheetObjects[i],i+1);

			ComEndConfigSheet(sheetObjects[i]);
		}
		// IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}

	    doActionIBSheet(sheetObjects[0], formObj, "offce_level"); // RHQ
	    
	    // 화면 Combo 설정
		getEasIbComboList(formObj.s_aud_itm_cd , 'DA|DF|NT|OT|EX' , 'Difference All|Diff Amount|No Tariff|Non-Opt. Route|Exceed Average' , 'ALL');  // Difference 
		getEasIbComboList(formObj.s_auto_aud_sts_cd , s_auto_aud_sts_cdCode , s_auto_aud_sts_cdText , 'ALL'); // Audit Status - AUTO 
		getEasIbComboList(formObj.s_trsp_so_tp_cd , s_trsp_so_tp_cdCode , s_trsp_so_tp_cdText , 'ALL'); // Service Order Type 
		formObj.s_trsp_so_tp_cd.DeleteItem("H");
		formObj.s_trsp_so_tp_cd.DeleteItem("S");
		formObj.s_trsp_so_tp_cd.DeleteItem("O");
		getEasIbComboList(formObj.s_trsp_cost_dtl_mod_cd , s_trsp_cost_dtl_mod_cdCode , s_trsp_cost_dtl_mod_cdText , 'ALL'); // Cost Mode
		formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("HD");
		formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("HF");
		formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("HN");
		formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("GN");
		formObj.s_trsp_cost_dtl_mod_cd.DeleteItem("GF");
		getEasIbComboList(formObj.s_trsp_crr_mod_cd , s_trsp_crr_mod_cdCode , s_trsp_crr_mod_cdText , 'ALL'); // Trans Mode 
		getEasIbComboList(formObj.s_expn_aud_sts_cd , s_expn_aud_sts_cdCode , s_expn_aud_sts_cdText , 'ALL'); // Audist Status 
		getEasIbComboList(formObj.s_csr_sts_cd , s_csr_sts_cdCode , s_csr_sts_cdText , 'ALL'); // CSR Status 
		
		initPage();
		initControl();
	}

	function initPage(){
		formObj = document.form;
		var s_popup_flg = formObj.s_popup_flg.value;

		if (s_popup_flg == "Y") {
			formObj.s_rhq_ofc_cd.code2 = formObj.s_popup_rhq_cd.value;
			doActionIBCombo(formObj.s_rhq_ofc_cd); // RHQ
			formObj.s_ofc_cd.code2 = formObj.s_popup_inv_ofc_cd.value;
			formObj.s_fm_dt.value = formObj.s_popup_fm_dt.value;
			formObj.s_to_dt.value = formObj.s_popup_to_dt.value;
			formObj.s_auto_aud_sts_cd.code2 = formObj.s_popup_auto_aud_sts_cd.value;
			formObj.s_expn_aud_sts_cd.code2 = formObj.s_popup_expn_aud_sts_cd.value;
			
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.DoSearch4Post("ESD_EAS_0340GS.do", FormQueryString(formObj));
		}else{
			formObj.s_fm_dt.value = ComGetDateAdd(ComGetNowInfo(),"D", -30, "-");
			formObj.s_to_dt.value =  ComGetNowInfo();
		}
		
		if (ofcLevel == 'O'|| ofcLevel == 'R') {
			ComBtnDisable("btn_confirm"); // Confirm 버튼 비활성화
		}
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
  	function initControl() {
		axon_event.addListenerForm  ( 'blur'     ,'obj_blur'      ,document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    ,'obj_focus'     ,document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change'   ,'obj_change'    ,document.form );
		axon_event.addListenerFormat( 'keypress' ,'obj_keypress'  ,document.form); //- 키보드 입력할때
  	}
  	
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="s_inv_vndr_seq") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	        break;
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_inv_vndr_seq":
				vender_change();
			break;
			case "s_fm_dt":
			case "s_to_dt":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();
				};
			break;
		}
	} 	
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		var formObj = document.form;
		if(obj.value.length >= 8) {
			formObj.s_to_dt.value = ComGetDateAdd(obj.value,"D", 30, "-");
		}else{
			formObj.s_to_dt.value = "";
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
	 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {

	 	var cnt = 0;

	 	switch(sheetNo) {
	    	case 1:      // sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height =395;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    // 전체Edit 허용 여부 [선택, Default false]
				    Editable = true;
				    
				    //말줄임 기능 사용하기
				    //Ellipsis = true; 
				    
				    //행의 높이를 자동으로 조정하지 않고, 1줄 높이로 고정
				    AutoRowHeight = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				    InitRowInfo( 1, 1, 14, 10);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle = "|SEL|SEQ.|Select|Auto Audit|Audit Result||||Change Detail|Change Detail|RHQ|Invoice\nOffice|Service Order\nType|inv_no|Invoice\nS/P Code|Invoice\nS/P Name|Invoice No.|Invoice\nIssued Date|Confirm Date|CSR Status|CSR No.|W/O\nCur.|W/O Amount|Inv Amount" +
							"|Curr.\nConversion|Diff\nAmount|Diff\nRatio(%)|Diff Amount($)\nby Auditor|aud_curr_cd|aud_diff_amt|Diff|Tariff|Op\nRoute|Exceed Average\nDiff Amount|Exceed Average|Audit Date|Inv User|Checked\nBy|Payment\nTerm|Payment\nDue Date|Paid Date|EAC I/F|ETS INV NO(E.U)|RE-BATCH\nStatus|hjl_inv_vndr_seq|atch_file_lnk_id";
					var HeadCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(HeadCount, 11, 0, true);
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//HeadRowHeight = 12;
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox, 	40, 	daCenter, 	true, 	"chk", 					false, 	  "", 	   dfNone, 			0, 			true, 		  true);
					InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtCombo, 		90, 	daLeft, 	true, 	"sel_aud_cd", 			false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++ , dtCombo,        90,  	daLeft,   	true,   "auto_aud_sts_cd",      false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtCombo,        90,  	daLeft,   	true,   "expn_aud_sts_cd",      false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden, 		50, 	daLeft, 	true, 	"expn_aud_rslt_usr_nm", false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++ , dtHidden, 		50, 	daLeft, 	true, 	"expn_aud_rslt_usr_id", false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++ , dtHidden, 		50, 	daLeft, 	true, 	"rslt_chk", 			false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++ , dtData,         30,  	daCenter,   true,   "expn_aud_rslt_cd",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtPopup, 		130, 	daLeft, 	true, 	"expn_aud_rslt_rmk", 	false,    "", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "rhq_ofc_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "inv_ofc_cd",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtCombo,        90,  	daLeft,   	true,   "trsp_so_tp_cd",        false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       70,  	daCenter,   true,   "inv_vndr_seq",         false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "dis_inv_vndr_seq",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "dis_inv_vndr_nm",      false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "inv_no",               false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "inv_iss_dt",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "inv_cfm_dt",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtCombo,        80,  	daLeft,   	true,   "inv_aud_sts_cd",       false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         145,  	daCenter,   true,   "csr_no",               false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "curr_cd",              false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
				    InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "wo_amt",               false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
				    InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "inv_amt",              false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   true,   "curr_cng_flg",         false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daRight,    true,   "inv_diff_amt",         false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daRight,    true,   "inv_diff_pct",         false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					/* 추가::START */
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "inv_aud_usd_diff_amt",     false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       65,  	daRight,    true,   "inv_aud_curr_cd",     	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       65,  	daRight,    true,   "inv_aud_diff_amt",     false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					/* 추가::END */
					InitDataProperty(0, cnt++ , dtHidden,       65,  	daRight,    true,   "inv_diff_amt_flg",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "no_agmt_flg",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "no_optm_rout_flg",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,   	true,   "exceed_avg_diff_amt",  false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  	daRight,    true,   "exceed_avg_flg",       false,    "",      dfNone,          0,          false,        true,    0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "auto_aud_cfm_dt",  	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         140,  	daLeft,     true,   "inv_iss_usr_nm",       false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         140,  	daLeft,     true,   "aud_cfm_usr_nm",       false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         65,  	daCenter,   true,   "pay_term_cd",          false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "pay_due_dt",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "pay_dt",               false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "eac_if_flg",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "hjl_inv_no",           false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtCombo,        100,  	daLeft,     true,   "bat_prog_sts_cd",      false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "hjl_inv_vndr_seq",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "atch_file_lnk_id",     false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);

				
					InitDataCombo(0, 'sel_aud_cd', sel_aud_cdText, sel_aud_cdCode);
					InitDataCombo(0, 'auto_aud_sts_cd', auto_aud_sts_cdText, auto_aud_sts_cdCode);
					InitDataCombo(0, 'expn_aud_sts_cd', expn_aud_sts_cdText, expn_aud_sts_cdCode);
					InitDataCombo(0, 'trsp_so_tp_cd', trsp_so_tp_cdText, trsp_so_tp_cdCode);
					InitDataCombo(0, 'inv_aud_sts_cd', inv_aud_sts_cdText, inv_aud_sts_cdCode);
					InitDataCombo(0, 'bat_prog_sts_cd', bat_prog_sts_cdText, bat_prog_sts_cdCode);
	    	}
				break;
	    	}
		}	
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		    case IBSEARCH:
		    	if(validateForm(sheetObj,formObj,sAction)){
		    		sheetObj.RemoveAll();
					formObj.f_cmd.value = SEARCHLIST01;
					sheetObj.DoSearch4Post("ESD_EAS_0340GS.do", FormQueryString(formObj));
		    	}
				break;	
				
			case IBDOWNEXCEL:  // EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
						
				break;		
				
			case MULTI01:
				//selected row
				var sRow = sheetObj.FindCheckedRow("chk");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
				var arrRow = sRow.split("|");					// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태
				
				//  EAC Interfce 대상으로 선택된 Row 가 없을 경우. Error
				if (arrRow.length == 1) {
					ComShowCodeMessage("COM12189");
			   		return;
				}

				for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
					if( sheetObj.CellValue( arrRow[idx], "bat_prog_sts_cd") == 'P') {
						ComShowCodeMessage('EAS90214'); //Already invoice included in re-batch target
						return false;
					}
					
					if( sheetObj.CellValue( arrRow[idx], "sel_aud_cd") == '') {
						ComShowMessage(ComGetMsg("EAS80001", "[Select] column"));
						return false;
					}

					if ((getEasAudCdMapg(sheetObj.CellValue( arrRow[idx], "sel_aud_cd")) != sheetObj.CellValue( arrRow[idx], "auto_aud_sts_cd")) 
							&& sheetObj.CellValue( arrRow[idx], "expn_aud_rslt_rmk") == "") {
						ComShowMessage(ComGetMsg("EAS05014", "Change reason"));
						return false;
					}
				}

				if (!ComShowCodeConfirm("EAS90076")) return; // Do you want to confirm{?msg1}?
            	formObj.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0340GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('EAS90212'); //It is included in the re-batch target.
					return false;
				} else if (State == "S") {
					for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
						sheetObj.CellValue2(arrRow[idx], "expn_aud_sts_cd") = sheetObjects[0].CellValue(arrRow[idx], "sel_aud_cd");
						sheetObj.CellValue2(arrRow[idx], "chk") = "";
						sheetObj.CellValue2(arrRow[idx], "auto_aud_cfm_dt") = ComGetNowInfo("ymd");
						//sheetObj.CellValue2(arrRow[idx], "auto_aud_cfm_dt") = ComGetNowInfo("ymd") + " " +ComGetNowInfo("hms");
						
						sheetObj.RowBackColor(arrRow[idx]) = sheetObjects[0].RgbColor(245,235,245);
						sheetObj.RowFontColor(arrRow[idx]) = sheetObjects[0].RgbColor(100,100,100);

						//sheetObjects[0].CellEditable(arrRow[idx], "chk") = false;
						//sheetObjects[0].CellEditable(arrRow[idx], "sel_aud_cd") = false;
					}
				}
				break;
				
			case MULTI02:
            	formObj.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true,"rslt_chk") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0340GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					var sRow = sheetObj.SelectRow;
					sheetObj.CellValue2(sRow, "expn_aud_rslt_rmk") = "";
					sheetObj.CellValue2(sRow, "rslt_chk") = "";
					sheetObj.CellValue2(sRow, "auto_aud_cfm_dt") = "";
					ComShowCodeMessage('EAS90213'); //Re-batch Target is unable to register the change detail.
					return false;
				} else if (State == "S") {
					var sRow = sheetObj.SelectRow;
					sheetObj.CellValue2(sRow, "rslt_chk") = "";
					sheetObj.CellValue2(sRow, "auto_aud_cfm_dt") = ComGetNowInfo("ymd");
				}
				break;
				
			case MULTI03:
				//selected row
				var sRow = sheetObj.FindCheckedRow("chk");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
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
            	formObj.f_cmd.value = MULTI03;
            	var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0340GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('EAS90214'); //Already invoice included in re-batch target
					return false;
				} else if (State == "S") {
					for( var i=0; i<arrRow.length-1; i++ ) {
						iRow = arrRow[i];
						sheetObj.CellValue(iRow, "bat_prog_sts_cd") = 'P';
						sheetObj.CellBackColor(iRow, "chk") = sheetObjects[0].RgbColor(255,190,130);
					}
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
        		}
        		if(rhqSearchFlag){
        			// RHQ 콤보 리스트 조회
        			formObj.s_rhq_ofc_cd.RemoveAll();
        			formObj.f_cmd.value = COMMAND02;
        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        			ComXml2ComboItem(sXml, formObj.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
        			// 이폼에서는 권한 체크를 하지 않는다.
        			formObj.s_rhq_ofc_cd.InsertItem(0, "", "");
	        		// RHQ에 해당하는 Office 조회
        			doActionIBCombo(formObj.s_rhq_ofc_cd);
        		}
	  		break; 	
		}
	}
	
    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[0];
    	switch(comboObj.id) {
	    case "s_rhq_ofc_cd":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        formObj.s_ofc_cd.RemoveAll();
	        ComXml2ComboItem(sXml, formObj.s_ofc_cd, "ofc_cd", "ofc_cd");
	    	formObj.s_ofc_cd.InsertItem(0, "", "");
	    	formObj.s_ofc_cd.code2 = formObj.s_ofc_cd.value
	    	//doActionIBCombo(formObj.s_ofc_cd)
	    	break;
    	}
    }
    	
	// 공통테이블에 등록된 코드값을 조회 한다.
	function searchCommonCombo(codeKey,comboObj){
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH01;
			// 공통 테이블에서 조회할 키
			formObj.code_key.value = codeKey
			sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
	}    
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수 IBSheetConfig.js에서
	 * DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){ 

	}

	function sheet1_OnChange(sheetObj, row, col, value){
		var ColName = sheetObj.colSaveName(col);
			switch(ColName){
			case  "sel_aud_cd" :
				//행의 글자색을 파란색으로 설정한다.
				sheetObj.RowFontColor(row) = sheetObj.RgbColor(0,84,255);
				sheetObj.CellValue2(row, "chk") = "1";
			}	
	}
	
	function sheet1_OnClick(sheetObj, Row,Col,Value){

	}

	/**
	* S/P Code 팝업호출
	*/
	function rep_OnPopupClick() {
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	/**
	* S/P Code 팝업 리턴값 세팅
	*/
	function getCOM_ENS_rep(rowArray) {
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			formObj.s_inv_vndr_seq.value =colArray2;
			formObj.s_inv_vndr_nm.value =colArray4;
		}
	}	
	/**
	 * Detail 팝업호출
	 */
	function detail_OnPopupClick(sheetObject, row) {
		var sParam = Array();
		sParam[0] = "s_inv_vndr_seq="+ sheetObject.CellValue(row, "inv_vndr_seq");
		sParam[1] = "s_inv_vndr_nm="+ sheetObject.CellValue(row, "inv_vndr_nm");
		sParam[2] = "s_inv_no="+ sheetObject.CellValue(row, "inv_no");
		sParam[3] = "s_trsp_so_tp_cd="+ sheetObject.CellValue(row, "trsp_so_tp_cd");
		sParam[4] = "s_expn_aud_sts_cd="+ sheetObject.CellValue(row, "expn_aud_sts_cd");
		sParam[5] = "s_trsp_cost_dtl_mod_cd="+ formObj.s_trsp_cost_dtl_mod_cd.Code;
		sParam[6] = "s_trsp_crr_mod_cd="+ formObj.s_trsp_crr_mod_cd.Code;
		sParam[7] = "s_inv_iss_usr_nm="+ sheetObject.CellValue(row, "inv_iss_usr_nm");
		sParam[8] = "s_aud_itm_cd="+ formObj.s_aud_itm_cd.Code;
		sParam[9] = "s_hjl_inv_vndr_seq="+ sheetObject.CellValue(row, "hjl_inv_vndr_seq");
		sParam[10] = "s_hjl_inv_no="+ sheetObject.CellValue(row, "hjl_inv_no");
		sParam[11] = "s_dis_inv_vndr_seq="+ sheetObject.CellValue(row, "dis_inv_vndr_seq");
		sParam[12] = "s_dis_inv_vndr_nm="+ sheetObject.CellValue(row, "dis_inv_vndr_nm");
		
		var theURL = "ESD_EAS_0341.do?"+sParam.join("&");
	   	var winName = "TrsAutoAuditDetailPopup";
	   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1018px;dialogHeight:650px";
	   	ComOpenWindow(theURL,winName,features,true);
	}

	/**
	 * Detail 팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getDetail(rowArray) {
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			formObj.s_inv_vndr_seq.value =colArray2;
			formObj.s_inv_vndr_nm.value =colArray4;
		}
	}	

  	/**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row) {
    	detail_OnPopupClick(sheetObj,Row)
		return;
    }

	/**
	 * 화면 로딩시 콤보조회
	 */
	function sheet1_OnLoadFinish(sheetObj){
	}
			
	function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){
		doActionIBCombo(formObj.s_rhq_ofc_cd); // RHQ
	}	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				// Mandatory Item Check
				if(formObj.s_fm_dt.value == "" || formObj.s_to_dt.value == ""){
					ComShowCodeMessage('COM130201', 'Inv Cfm Date'); // Entered Date 값을 입력하셔야 합니다;
					return false;
				}

				var ls_fm_dt = removeBar(formObj.s_fm_dt.value);
				var ls_to_dt = removeBar(formObj.s_to_dt.value);
				var days_between = ComGetDaysBetween(ls_fm_dt , ls_to_dt) ;  // 조회 기간

				if ( days_between > 92 ) {
					ComShowCodeMessage("EAS90075");
					return false;
				}
				break;
		}
		return result;
	}
	
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function  vender_change(){
		formObj = document.form;
		if(formObj.s_inv_vndr_seq.value =="" ){
			formObj.s_inv_vndr_seq.value="";
			formObj.s_inv_vndr_nm.value="";
			return;
		}

		var sParam = Array();
		sParam[0] = "f_cmd="+ SEARCH05;
		sParam[1] = "s_vndr_seq="+ formObj.s_inv_vndr_seq.value;
		var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", sParam.join("&"));
		var vndrNm = EasXmlString(sXml,"vndr_nm");
		
		if(vndrNm==0){
			ComShowCodeMessage('COM132202', 'Inv. S/P'); //사용할수 없는 S/P Code 
			formObj.s_inv_vndr_seq.value="";
			formObj.s_inv_vndr_nm.value="";
			return;
		}
		formObj.s_inv_vndr_nm.value = vndrNm;
	}
	
	/**
	 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인
	 * 일련번호 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */ 
	function initCombo(comboObj, comboNo) {

	}
	
	/**
	 * EAC I/F 여부 설정
	 */ 
	function fn_setEacIfFlg() {
		var sRow = sheetObjects[0].SelectRow;
		sheetObjects[0].CellValue2(sRow,'eac_if_flg') = "Y";
	}
	
  /**
   * Sheet1에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  switch(colName){
	  	case('expn_aud_rslt_rmk'):
			formObj.pop_parent_row.value = row;
			formObj.pop_expn_aud_rslt_usr_nm.value = sheetObj.CellValue(row, "expn_aud_rslt_usr_nm");
			formObj.pop_expn_aud_rslt_usr_id.value = sheetObj.CellValue(row, "expn_aud_rslt_usr_id");
			formObj.pop_expn_aud_rslt_rmk.value = sheetObj.CellValue(row, "expn_aud_rslt_rmk");
			formObj.pop_ofcLevel.value = ofcLevel;
			formObj.pop_mdl_tp_cd.value = 'TRS';
			formObj.pop_auto_aud_sts_cd.value = sheetObj.CellValue(row, "auto_aud_sts_cd");
			formObj.pop_expn_aud_sts_cd.value = sheetObj.CellValue(row, "expn_aud_sts_cd");
			formObj.pop_atch_file_lnk_id.value = sheetObj.CellValue(row, "atch_file_lnk_id");
			formObj.pop_expn_aud_rslt_cd.value = sheetObj.CellValue(row, "expn_aud_rslt_cd");
			formObj.pop_inv_no.value = sheetObj.CellValue(row, "inv_no");

			var pop_inv_aud_curr_cd = sheetObj.CellValue(row, "inv_aud_curr_cd");
			if ( pop_inv_aud_curr_cd == null || pop_inv_aud_curr_cd == "")
				pop_inv_aud_curr_cd = sheetObj.CellValue(row, "curr_cd");
			
			formObj.pop_inv_aud_curr_cd.value 	= pop_inv_aud_curr_cd;
			formObj.pop_inv_usd_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_usd_diff_amt");
			formObj.pop_inv_aud_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_diff_amt");
			formObj.pop_curr_cd.value 			= sheetObj.CellValue(row, "curr_cd");
			formObj.pop_inv_cfm_dt.value 		= sheetObj.CellValue(row, "inv_cfm_dt");
			
			if (sheetObj.CellValue(row, "atch_file_lnk_id").length > 0) {
				formObj.pop_atch_file_lnk_flg.value = "Y";
			}else{
				formObj.pop_atch_file_lnk_flg.value = "";
			}

			var sParam = Array();
			sParam[0] = "sel_aud_cd="+ sheetObj.CellValue(row, "sel_aud_cd");
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
		var sRow = sheetObjects[0].SelectRow;
		if (save_tp == 'S') {
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_cd') = rslt_cd;
		}
		sheetObjects[0].CellValue2(sRow,'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow,'rslt_chk') = '1';
		formObj.s_save_tp_cd.value = save_tp;

		doActionIBSheet(sheetObjects[0],formObj, MULTI02);
	}
	
	
	/**
	 * Audit Remark 리턴값 설정
	 */ 
	function fn_setAuditRemark2(rmk, name, id, rslt_cd, save_tp, file, curr_cd, aud_diff_amt, usd_diff_amt) {
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
		
		formObj.s_save_tp_cd.value = save_tp;

		doActionIBSheet(sheetObjects[0],formObj, MULTI02);
	}
	