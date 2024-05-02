/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0372.js
*@FileTitle : TES Auto Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-14 Jong-Ock Kim
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class ESD_EAS_0372 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0372() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.initCombo				= initCombo;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;
	
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
				
			case "btn_confirm":
				formObj.s_save_tp_cd.value = 'C';
				doActionIBSheet(sheetObject,formObject, IBSAVE);
			    break;
				
			case "btn_rebatch":
				doActionIBSheet(sheetObject, formObject, IBBATCH);
				break;
				
			case "btn_new":
				formObject.reset();
				initSet(true);
			    break;
			    
			case "btn_down_excel":
				sheetObject.SpeedDown2Excel(true);
				break;
				
    		case "btns_from_inv_cfm_dt":
    			var cal = new ComCalendar();
    			cal.select(formObject.s_from_inv_cfm_dt, 'yyyy-MM-dd');
    			break;

    		case "btns_to_inv_cfm_dt":
    			var cal = new ComCalendar();
    			cal.select(formObject.s_to_inv_cfm_dt, 'yyyy-MM-dd');
    			break;
    			
  			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
				break;

			case "btn_vndr":
				var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
				var classId = "COM_ENS_0C1";
				var param = '?classId='+classId;
				var chkStr = dispaly.substring(0,3)
				// radio PopUp
				if (chkStr == "1,0") {
					ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
				} else {
					//ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
					return;
				}
				break;
				
			case "btn_detail" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openTesInvoiceDetail();
       			}else{
					ComShowCodeMessage("COM12177");
				}
       			break;
       			
			case "btn_agreement" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openTesInvoiceAgreement();
       			}else{
					ComShowCodeMessage("COM12177");
				}
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
	 * IBSheet Object를 배열로 등록
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
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			ComConfigSheetEas(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		
 		//html컨트롤 이벤트초기화
 		initControl();
		initSet(false);

		formObj = document.form;
//		ComBtnDisable("btn_confirm"); // Save 버튼 비활성화
		doActionIBSheet(sheetObjects[1], formObj, "offce_level"); // RHQ
		
		initPage();
	}
	
	function initPage(){
		formObj = document.form;
		var s_popup_flg = formObj.s_popup_flg.value;

		if (s_popup_flg == "Y") {
			formObj.s_rhq_ofc_cd.code2 = formObj.s_popup_rhq_cd.value;
			doActionIBCombo(formObj.s_rhq_ofc_cd); // RHQ
			formObj.s_inv_ofc_cd.code2 = formObj.s_popup_inv_ofc_cd.value;
			formObj.s_from_inv_cfm_dt.value = formObj.s_popup_fm_dt.value;
			formObj.s_to_inv_cfm_dt.value = formObj.s_popup_to_dt.value;
			formObj.s_auto_expn_aud_sts_cd.code2 = formObj.s_popup_auto_aud_sts_cd.value;
			formObj.s_expn_aud_sts_cd.code2 = formObj.s_popup_expn_aud_sts_cd.value;

			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.DoSearch("ESD_EAS_0372GS2.do", EasFrmQryString(formObj));
		}
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
	function initControl() {
		axon_event.addListenerForm  ( 'blur'   , 'obj_blur', document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
	}

	function obj_blur(){
  		var formObj = document.form;
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_loc_cd":
				if(!ComIsNull(formObj.s_loc_cd)){
			  		var vlist = getYardCombo(formObj.s_nod_cd, sheetObjects[0], formObj, ComGetObjValue(formObj.s_loc_cd));
			  		if(vlist == ""){
			  			ComSetObjValue(formObj.s_loc_cd, "");
			  			ComAlertFocus(formObj.s_loc_cd, ComGetMsg("EAS29021"));
			  		}else{
			  			formObj.s_nod_cd.insertItem(0, "", "");
			  		}					
				}else{
					formObj.s_nod_cd.RemoveAll();
				}
			break;
		}
	} 
	
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="s_diff_rto") ComKeyOnlyNumber(obj, "-.")
	            else ComKeyOnlyNumber(obj);
	        break;
			case "engup":		//영문대문자
				ComKeyOnlyAlphabet('upper');
			break;
	        
	    }
	}

	function initSet(flg) {
  		var formObj = document.form;
  		ComSetObjValue(formObj.s_from_inv_cfm_dt, ComGetDateAdd(null, "d", -30, "-"));
  		ComSetObjValue(formObj.s_to_inv_cfm_dt, ComGetNowInfo());
  		setloginOfcCd();
  		if(flg){
  			ComSetObjValue(formObj.s_tml_inv_tp_cd, "");
  			ComSetObjValue(formObj.s_tml_inv_tp_cd, "");
  			ComSetObjValue(formObj.s_nod_cd, "");
  			ComSetObjValue(formObj.s_diff_sgn, "");
  			ComSetObjValue(formObj.s_auto_expn_aud_sts_cd, "");
  			ComSetObjValue(formObj.s_expn_aud_sts_cd, "");
  			ComSetObjValue(formObj.s_csr_sts_cd, "");
  		}
  		
  		//TODAY setting
  		ComSetObjValue(formObj.s_today, ComGetNowInfo("dd"));

  	}
  	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {
			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(19);
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
					
					var HeadTitle  = "|Sel.|Seq.|Select|Auto Audit|Audit Result|Batch Result||||Change Detail|Change Detail|RHQ|Cost\nOffice|Invoice\nOffice|Yard|S/P No.|Inv.\nType|Invoice No.";
					HeadTitle  += "|Rej.|Issued\nDate|Confirmed\nDate|CSR Status|CSR No.|Inv User|Audit Date|Checked By|Payment\nTerm|Payment\nDue Date|Paid\nDate|VVD";
					HeadTitle  += "|Bound|ATB|Period|Cur.|Inv. Amount|Est. Amount|Diff(%)|Diff Amount($)\nby Auditor|aud_curr_cd|aud_diff_amt|Cal. Type|Audit Case|Verify|Vol\nDiff|EAC\nI/F|RE-BATCH\nStatus|inv_cfm_dt|expn_aud_seq|fm_prd_dt|to_prd_dt|atch_file_lnk_id|||";
					
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,10,daCenter,	false,	"ibflag");
//	                InitDataProperty(0, cnt++, dtCheckBox,	30,	 daCenter,	true,	"chk");
					InitDataProperty(0, cnt++ , dtCheckBox, 		40, 	daCenter, 	true, 	"chk", 			false, "", dfNone, 0, true, true);
	                
	                InitDataProperty(0, cnt++, dtDataSeq,	40,	 daCenter,	true,	"seq");
	                InitDataProperty(0, cnt++, dtCombo,		90,	daLeft,		true,	"sel_aud_cd",			false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtCombo,		90,	daLeft,		true,	"auto_expn_aud_sts_cd",	false,          "",       dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtCombo,		90,	daLeft,		true,	"expn_aud_sts_cd",		false,			"",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		80,	daLeft,		true,	"bat_rslt",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden, 	50, daLeft, 	true, 	"expn_aud_rslt_usr_nm",false,    		"", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++, dtHidden, 	50, daLeft, 	true, 	"expn_aud_rslt_usr_id", false,    		"", 	   dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++, dtHidden, 	50, daLeft, 	true, 	"rslt_chk", 				false,    		"", 	   dfNone, 			0,			true, 		  true);
					
					InitDataProperty(0, cnt++, dtData,		30,	daCenter,	true,	"expn_aud_rslt_cd",		false,          "",       dfNone, 0,     false,       false);
					InitDataProperty(0, cnt++, dtPopup, 	130,daLeft, 	true, 	"expn_aud_rslt_rmk", 	false,    		"",		dfNone, 			0,			true, 		  true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"rhq_cd",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"cost_ofc_cd",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"inv_ofc_cd",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"yd_cd",					false,          "",       dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"vndr_seq",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		60,	daLeft,		true,	"tml_inv_tp_cd",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		100,daLeft,	true,	"inv_no",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		60,	daLeft,		true,	"tml_inv_rjct_sts_cd",	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"iss_dt",					false,          "",       dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"inv_cfm_dt_ymd",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		140,daLeft,	true,	"csr_sts_cd",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		150,daLeft,	true,	"csr_no",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		100,daLeft,	true,	"inv_cre_usr_nm",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		120,daCenter,true,	"aud_upd_dt",			false,          "",       dfDateYmd,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtData,		100,daLeft,	true,	"aud_upd_usr_nm",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"pay_term",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"pay_due_dt",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"pay_dt",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"vvd",						false,          "",       dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"io_bnd_cd",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"atb_dt",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		140,daCenter,	true,	"inv_prd_dt",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"curr_cd",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		100,daRight,	true,	"inv_amt",					false,          "",       dfFloatOrg,	2,  false,       false);
					
					InitDataProperty(0, cnt++, dtData,		100,daRight,	true,	"expn_aud_estm_amt",	false,          "",       dfFloatOrg,	2,  false,       false);
					InitDataProperty(0, cnt++, dtData,		60,	daRight,	true,	"diff_rto",					false,          "",       dfFloatOrg,   1,  false,       false);
					
					/* 추가::START */
					InitDataProperty(0, cnt++ , dtData,     100,daRight,    true,   "inv_aud_usd_diff_amt",     false,  "",		  dfNullFloat,     2, false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   65, daRight,    true,   "inv_aud_curr_cd",     		false,  "",       dfNone,          0, false,    false);
					InitDataProperty(0, cnt++ , dtHidden,   65, daRight,    true,   "inv_aud_diff_amt",     	false,  "",       dfNullFloat,     2, false,    false);
					/* 추가::END */
					
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"calc_tp_cd_ctnt",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"aud_case_dtl_qty",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"vrfy_rslt_cd_ctnt",		false,          "",       dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++, dtData,		60,	daRight,	true,	"vol_aud_tgt_qty",		false,          "",       dfNullInteger,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"eac_flg",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		70,	daCenter,	true,	"bat_prog_sts_cd",		false,          "",       dfNone, 0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"inv_cfm_dt",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"expn_aud_seq",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"fm_prd_dt",				false,          "",       dfDateYmd, 0,     false,       false);
					
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"to_prd_dt",				false,          "",       dfDateYmd, 0,     false,       false);

					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"atch_file_lnk_id",		false,          "",       dfNone, 0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"vsl_cd",					false,          "",       dfNone, 0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"skd_voy_no",			false,          "",       dfNone, 0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,		70,	daCenter,	true,	"skd_dir_cd",				false,          "",       dfNone, 0,     false,       false);
					
					InitDataCombo(0, "sel_aud_cd",  expn_aud_sts_cdText, expn_aud_sts_cdCode);
	                InitDataCombo(0, "auto_expn_aud_sts_cd",  auto_expn_aud_sts_cdText, auto_expn_aud_sts_cdCode);
	                InitDataCombo(0, "expn_aud_sts_cd",  expn_aud_sts_cdText, expn_aud_sts_cdCode);
	                InitDataCombo(0, "tml_inv_tp_cd",  "Terminal|Storage|On-dock|Off-dock", "TM|ST|ON|OF");
	                InitDataCombo(0, "tml_inv_rjct_sts_cd",  tml_inv_rjct_sts_cdText, tml_inv_rjct_sts_cdCode);
	                InitDataCombo(0, "csr_sts_cd",  csr_sts_cdText, csr_sts_cdCode);
					InitDataCombo(0, 'bat_prog_sts_cd', bat_prog_sts_cdText, bat_prog_sts_cdCode);
                
					HeadRowHeight = 30;
				}
				break;
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch("ESD_EAS_0372GS2.do", EasFrmQryString(formObj));
				break;
				
			case IBBATCH:	// Batch 대상 저장.
				//selected row
				var sRow = sheetObj.FindCheckedRow("chk");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
				var arrRow = sRow.split("|");							// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태

				if (arrRow.length == 1) {
					ComShowCodeMessage("COM12189");
			   		return;
				}
				
				for (var idx=0; idx < arrRow.length - 1 ; idx++) {	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
					if ( sheetObj.CellValue( arrRow[idx], "bat_prog_sts_cd") == 'P') {
						ComShowCodeMessage('EAS90214'); 		// Already invoice included in re-batch target
						return false;
					}
				}				

				if (!ComShowCodeConfirm("EAS90099", "Re-Batch")) return; // Do you want to {?msg1}?
				
				formObj.f_cmd.value = MODIFY02;
            	var sParam = sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0372GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	    		
				if (State != "S") {
					ComShowCodeMessage('EAS90214');		// Already invoice included in re-batch target
					return false;
				} else if (State == "S") {
					for( var i=0; i<arrRow.length-1; i++ ) {
						iRow = arrRow[i];
						sheetObj.CellValue(iRow, "bat_prog_sts_cd") = 'P';
						sheetObj.CellBackColor(iRow, "chk") = sheetObjects[0].RgbColor(255, 190, 130);
					}
				}
				
				break;
				
			case IBSAVE:	// Save
				//selected row
				var sRow = sheetObj.FindCheckedRow("chk");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
				var arrRow = sRow.split("|");					// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태
				
				//  EAC Interfce 대상으로 선택된 Row 가 없을 경우. Error
				if (arrRow.length == 1) {
					ComShowCodeMessage("COM12189");
			   		return;
				}
				
				for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
					if ( sheetObj.CellValue( arrRow[idx], "bat_prog_sts_cd") == 'P') {
						ComShowCodeMessage('EAS90214'); 		// Already invoice included in re-batch target
						return false;
					}

					if( sheetObj.CellValue( arrRow[idx], "sel_aud_cd") == '') {
						ComShowMessage(ComGetMsg("EAS80001", "[Select] column"));
						return false;
					}
					
					// CHM-201539630 Split03-Auto Audit Change Detail 수정 요청 - (2016-01-05 김대준C)
					if ((getEasAudCdMapg(sheetObj.CellValue( arrRow[idx], "sel_aud_cd")) != sheetObj.CellValue( arrRow[idx], "auto_expn_aud_sts_cd")) 
							&& sheetObj.CellValue( arrRow[idx], "expn_aud_rslt_rmk") == "") {
						ComShowMessage(ComGetMsg("EAS05014", "Change reason"));
						return false;
					}
				}				
				
				if (!ComShowCodeConfirm("EAS90076")) return; // Do you want to confirm{?msg1}?
				
				formObj.f_cmd.value = MODIFY01;
				var sParam =  ComGetSaveString(sheetObj, true, false);
				if( sParam == ""){ return;}
				var sXml = sheetObj.GetSaveXml("ESD_EAS_0372GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

	    		if (State != "S") {
					ComShowCodeMessage('EAS90212'); //It is included in the re-batch target.
					return false;
				} if (State == "S") {
					for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
						sheetObj.CellValue2(arrRow[idx], "expn_aud_sts_cd") = sheetObjects[0].CellValue(arrRow[idx], "sel_aud_cd");
						sheetObj.CellValue2(arrRow[idx], "chk") = "";

						sheetObj.RowBackColor(arrRow[idx]) = sheetObjects[0].RgbColor(245,235,245);
						sheetObj.RowFontColor(arrRow[idx]) = sheetObjects[0].RgbColor(100,100,100);
					}
				}
				break;				

			case MODIFY02:
            	formObj.f_cmd.value = MODIFY01;
				var sParam = sheetObj.GetSaveString(false, true, "rslt_chk") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0372GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					var sRow = sheetObj.SelectRow;
					ComShowCodeMessage('EAS90213'); //Re-batch Target is unable to register the change detail.
					sheetObj.CellValue2(sRow, "expn_aud_rslt_rmk") = "";
					sheetObj.CellValue2(sRow, "rslt_chk") = "";
//					sheetObj.CellValue2(sRow, "locl_cre_dt") = "";
					return false;
				} else if (State == "S") {
					var sRow = sheetObj.SelectRow;
					sheetObj.CellValue2(sRow, "rslt_chk") = "";
//					sheetObj.CellValue2(sRow, "locl_cre_dt") = ComGetNowInfo("ymd");
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
        		formObj.s_inv_ofc_cd.InsertItem(0, formObj.ofc_cd.value, formObj.ofc_cd.value);
        		if(ofcLevel=="O"){
        			// 본사(심사팀) RHQ 소속이외
            		rhqSearchFlag = false;
            		formObj.s_rhq_ofc_cd.Enable=false;
            		formObj.s_inv_ofc_cd.Enable=false;  
            		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		formObj.s_inv_ofc_cd.code2 = formObj.ofc_cd.value; 
            		ComBtnDisable("btn_confirm"); // Confirm 버튼 비활성화
        		}else if(ofcLevel=="R"){
        			rhqSearchFlag = false;
        			formObj.s_rhq_ofc_cd.Enable=false;
        			formObj.s_inv_ofc_cd.Enable=true;        			
        			formObj.s_rhq_ofc_cd.Index2=0;
        			doActionIBCombo(formObj.s_rhq_ofc_cd)
//        			ComBtnEnable("btn_confirm"); // Save 버튼 활성화
        			ComBtnDisable("btn_confirm"); // Confirm 버튼 비활성화
        		}else if(ofcLevel=="H"){
        			// 본사(심사팀) 소속
            		rhqSearchFlag = true;
            		formObj.s_rhq_ofc_cd.Enable=true;
            		formObj.s_inv_ofc_cd.Enable=true;              
            		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
            		formObj.s_inv_ofc_cd.code2 = formObj.ofc_cd.value;
            		ComBtnEnable("btn_confirm"); // Save 버튼 활성화
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
	
	/**
	 * Combo관련 프로세스 처리
	 */
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[0];
    	switch(comboObj.id) {
	    case "s_rhq_ofc_cd":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        ComXml2ComboItem(sXml, formObj.s_inv_ofc_cd, "ofc_cd", "ofc_cd");
	    	break;
    	}
    }
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(ComIsNull(s_from_inv_cfm_dt)) {
				ComAlertFocus(s_from_inv_cfm_dt, ComGetMsg("COM130201", "Period"));
				return false;
			} else if(ComIsNull(s_to_inv_cfm_dt)) {
				ComAlertFocus(s_to_inv_cfm_dt, ComGetMsg("COM130201", "Period"));
				return false;
			}
			
			var days_between = ComGetDaysBetween(s_from_inv_cfm_dt , s_to_inv_cfm_dt) ;  // 조회 기간
			if ( days_between > 92 ) {
				ComShowCodeMessage("EAS90075");
				s_from_inv_cfm_dt.focus();
				return false;
			}
        }

        return true;
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
					SetColWidth("50");
					DropHeight = 140;
					setComboData(comboObj);
				}
			break;

			case "s_inv_ofc_cd":
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 300;
				}
			break;
			
			case "s_tml_inv_tp_cd":
				with (comboObj) { 
					SetColWidth("80");
					DropHeight = 100;
					setComboData(comboObj);
				}
			break;
			
			case "s_diff_sgn":
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 100;
					setComboData(comboObj);
				}
			break;
			
			case "s_auto_expn_aud_sts_cd":
				with (comboObj) { 
					SetColWidth("110");
					DropHeight = 100;
					getEasIbComboList(comboObj, auto_expn_aud_sts_cdCode, auto_expn_aud_sts_cdText , "");
				}
			break;
			
			case "s_expn_aud_sts_cd":
				with (comboObj) { 
					SetColWidth("110");
					DropHeight = 140;
					getEasIbComboList(comboObj, s_expn_aud_sts_cdCode, s_expn_aud_sts_cdText , "");
				}
			break;
			
			case "s_csr_sts_cd":
				with (comboObj) { 
					SetColWidth("130");
					DropHeight = 200;
					getEasIbComboList(comboObj, csr_sts_cdCode, csr_sts_cdText , "");
				}
			break;
		}
	}
	
	/**
	 * 
	 * @param comboObj
	 */
	function setComboData(comboObj){ 
		var comboID = comboObj.id;
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
		var cnt  = 0 ;
		switch(comboID){
			case "s_rhq_ofc_cd":
				formObj.f_cmd.value = COMMAND02;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
	    		comboObj.insertItem(0, "", "");
				break;
				
			case "s_inv_ofc_cd":
		        formObj.s_inv_ofc_cd.RemoveAll();
		    	formObj.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
		    	ComXml2ComboItem(sXml, formObj.s_inv_ofc_cd, "ofc_cd", "ofc_cd");	//(데이터, 누구한테 던져주는 대상, 칼럼코드명, 컬럼이름)
		    	formObj.s_inv_ofc_cd.InsertItem(0, "", "");				
		    	break;

			case "s_tml_inv_tp_cd":
				comboObj.InsertItem(cnt++, "", "");
				comboObj.InsertItem(cnt++, "Terminal", "TM");
				comboObj.InsertItem(cnt++, "Storage", "ST");
				comboObj.InsertItem(cnt++, "On-dock", "ON");
				comboObj.InsertItem(cnt++, "Off-dock", "OF");
				break;
				
			case "s_diff_sgn":
				comboObj.InsertItem(cnt++, "", "");
				comboObj.InsertItem(cnt++, "<", "1");
				comboObj.InsertItem(cnt++, ">", "2");
				comboObj.InsertItem(cnt++, "=", "3");
				comboObj.InsertItem(cnt++, "<=", "4");
				comboObj.InsertItem(cnt++, ">=", "5");
				break;
		}
	}

	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function  vender_change(){
		var frm = document.form;
		if(frm.s_vndr_seq.value =="" ){
			frm.s_vndr_seq.value="";
			frm.s_vndr_seq_name.value="";
			return;
		}
		
	    var vParam = "f_cmd="+SEARCH05+"&s_vndr_seq="+ComGetObjValue(frm.s_vndr_seq);
		var sXml=sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", vParam);
		var vndrNm = EasXmlString(sXml,"vndr_nm");
		
		if(vndrNm==0){
			ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
			frm.s_vndr_seq.value="";
			frm.s_vndr_seq_name.value="";
			return;
		}
		frm.s_vndr_seq_name.value = vndrNm;
	}
	
	/**
	 * Vendor Help 화면에서 선택한 벤더를 작업화면으로 보내준다.
	 * @param(rowArray) 
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		document.all.s_vndr_seq.value = colArray[6];
		document.all.s_vndr_seq_name.value = colArray[4];
	}
	
	function s_rhq_ofc_cd_OnChange(comboObj, Code, Text){
		var formObj = document.form;
		setComboData(formObj.s_inv_ofc_cd);
	}	
	
	function fnYearSet(obj){
	    obj.value = ComGetMaskedValue(obj.value, "ymd");
	}
	 
	/**
	* Invoice Office 에 값이 존재하는지 체크 한다.
	*/ 
	function  invoiceOffice_change(obj){
		if(ComIsNull(obj)){
			return;
		}
		var sheetObj = sheetObjects[1];
	    var vParam = "f_cmd="+SEARCH+"&ofc_cd="+obj.value;		
		var sXml = sheetObj.GetSearchXml("COM_ENS_071GS.do", vParam);

		if(ComGetTotalRows(sXml) < 1){
			ComShowCodeMessage('COM132202', 'Invoice Office'); //사용할수 없는 Resp. Office 
			obj.value ="";
			obj.focus();
		}
	}
	
  	/**
  	 * 공통 Node popup
  	 */
  	function openHireYardPopup(objName) {
  		var formObject = document.form;
  		var cmdt_cd_val ="";   //향후 사용가능 예정변수
  		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
  		var cmdt_desc_val ="";   //향후 사용가능 예정변수
  		var classId = objName;
  		var xx1 = ""; //CONTI
  		var xx2 = ""; //SUB CONTI
  		var xx3 = ""; //COUNTRY
  		var xx4 = ""; //STATE
  		var xx5 = ""; //CONTROL OFFIC
  		var xx6 = ""; //LOC CODE
  		var xx7 = ""; //LOC NAME
  		var xx8 = "";
  		var xx9 = "";
  		if( objName == "getDorLoc" ) {
  			v6 = "zone"
  		} else {
  			v6 = "yard";
  		}
  		
  		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
  		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
  	}
  	
  	/**
  	 * From Node 팝업에 대한 리턴값
  	 */
  	function getFromNode(rowArray) {
  		var formObject = document.form;
  		var colArray = rowArray[0];
  		var node = colArray[3];
  		var lvLoc = node.substring(0, 5);
  		var lvYard = node.substring(5, 7);
  		formObject.s_loc_cd.value = lvLoc;
  		getYardCombo(formObject.s_nod_cd, sheetObjects[0], formObject, lvLoc);
  		document.s_nod_cd.CODE = lvYard;
  	}
  	
  	/**
  	 * 
  	 * @param sheetObj
  	 * @param row
  	 * @param col
  	 * @param value
  	 */
	function sheet1_OnChange(sheetObj, row, col, value){
		var ColName = sheetObj.colSaveName(col);
			switch(ColName){
			case  "sel_aud_cd" :
				//행의 글자색을 파란색으로 설정한다.
				sheetObj.RowFontColor(row) = sheetObj.RgbColor(0,84,255);
				sheetObj.CellValue2(row, "chk") = "1";
			}
	}  	
		
	/**
	 * 
	 */
    function sheet1_OnDblClick(sheetObj, Row, Col){
    	openTesInvoiceDetail();
    }
	
    /**
     * 
     * @param sheetObj
     * @param errMsg
     */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		var formObject = document.form;
		doActionIBSheet(sheetObj,formObject,IBSEARCH);
	}
    
	/**
	 * 
	 */
	function openTesInvoiceDetail(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var popupHeight = 640;
		var sUrl = "";
		
		var tml_inv_tp_cd = sheetObj.CellValue(sheetObj.SelectRow, "tml_inv_tp_cd");
		if( tml_inv_tp_cd == "TM") {
			sUrl = "/hanjin/ESD_EAS_0377.do";
		} else if( tml_inv_tp_cd == "OF") {
			sUrl = "/hanjin/ESD_EAS_0373.do";
		} else if( tml_inv_tp_cd == "ST") {
			sUrl = "/hanjin/ESD_EAS_0375.do";
		} else if( tml_inv_tp_cd == "ON") {
			popupHeight = 670;
			sUrl = "/hanjin/ESD_EAS_0379.do";
		}
		
		var sParam = "?s_eas_flg=Y&s_inv_ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow, "inv_ofc_cd")
						+"&s_tml_inv_tp_cd="+sheetObj.CellValue(sheetObj.SelectRow, "tml_inv_tp_cd")
						+"&s_yd_cd="+sheetObj.CellValue(sheetObj.SelectRow, "yd_cd")
						+"&s_vndr_seq="+sheetObj.CellValue(sheetObj.SelectRow, "vndr_seq")
						+"&s_inv_no="+sheetObj.CellValue(sheetObj.SelectRow, "inv_no")
						+"&s_vvd="+sheetObj.CellValue(sheetObj.SelectRow, "vvd")
						+"&s_io_bnd_cd="+sheetObj.CellValue(sheetObj.SelectRow, "io_bnd_cd")
						+"&s_atb_dt="+sheetObj.CellValue(sheetObj.SelectRow, "atb_dt")
						+"&s_fm_prd_dt="+sheetObj.CellText(sheetObj.SelectRow, "fm_prd_dt")
						+"&s_to_prd_dt="+sheetObj.CellText(sheetObj.SelectRow, "to_prd_dt")
						+"&s_expn_aud_sts_cd="+sheetObj.CellValue(sheetObj.SelectRow, "expn_aud_sts_cd")
						+"&s_iss_dt="+sheetObj.CellValue(sheetObj.SelectRow, "iss_dt")
						+"&s_inv_cfm_dt="+sheetObj.CellValue(sheetObj.SelectRow, "inv_cfm_dt")
						+"&s_expn_aud_seq="+sheetObj.CellValue(sheetObj.SelectRow, "expn_aud_seq")
						;
		sUrl += sParam;

		var winName = "Audit Detail";
	   	var features = "scroll:no;status:no;resizable=yes;help:no;dialogWidth:940px;dialogHeight:"+popupHeight+"px";			
	   	ComOpenWindow(sUrl, winName, features, true);		
	}

	/**
	 * 
	 */
	function openTesInvoiceAgreement(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var sUrl = "/hanjin/ESD_TES_0039.do";
		
		var sParam = "?pre_cond_yd_cd="+sheetObj.CellValue(sheetObj.SelectRow, "yd_cd")
						+"&pre_cond_vndr_seq="+sheetObj.CellValue(sheetObj.SelectRow, "vndr_seq")
						;
		sUrl += sParam;
		ComOpenPopup(sUrl, 1020, 540, "", "0,0", true, false, "", "", "", "Detail");
	}	
	
	/**
	 * 
	 */
	function setloginOfcCd(){
		var sheetObj = sheetObjects[1];
		var formObj = document.form;
	    var vParam = "f_cmd="+COMMAND01+"&ofc_cd="+ComGetObjValue(formObj.usr_ofc_cd);		
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", vParam);
		var ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");

		// 로그인한 RHQ OFFCD 셋팅
		ComSetObjValue(formObj.s_rhq_ofc_cd, rhq_ofc_cd);

		if(ofcLevel=="O"){
			// 본사(심사팀) RHQ 소속이외
    		formObj.s_rhq_ofc_cd.Enable=false;
    		formObj.s_inv_ofc_cd.Enable=false;  
		}else if(ofcLevel=="R"){
			formObj.s_rhq_ofc_cd.Enable=false;
			formObj.s_inv_ofc_cd.Enable=true;        			
		}else if(ofcLevel=="H"){
			// 본사(심사팀) 소속
    		formObj.s_rhq_ofc_cd.Enable=true;
    		formObj.s_inv_ofc_cd.Enable=true;              
		}

		// 로그인한 OFFCD 셋팅
		ComSetObjValue(formObj.s_inv_ofc_cd, ComGetObjValue(formObj.usr_ofc_cd));
	}	
	
	
	/**
	 * Sheet1에서 Popup 이벤트를 발생시킴.
	 */
	function sheet1_OnPopupClick (sheetObj , row , col ){
		var colName = sheetObjects[0].ColSaveName(col);
		switch (colName) {
			case ('expn_aud_rslt_rmk') :
				formObj.pop_parent_row.value = row;
				formObj.pop_expn_aud_rslt_usr_nm.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_usr_nm");
				formObj.pop_expn_aud_rslt_usr_id.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_usr_id");
				formObj.pop_expn_aud_rslt_rmk.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_rmk");
				formObj.pop_ofcLevel.value = ofcLevel;
	
				// CHM-201539630 Split03-Auto Audit Change Detail 수정 요청 - (2016-01-05 김대준C)
				formObj.pop_mdl_tp_cd.value = 'TES';
				formObj.pop_auto_aud_sts_cd.value = sheetObjects[0].CellValue(row, "auto_expn_aud_sts_cd");
				formObj.pop_expn_aud_sts_cd.value = sheetObjects[0].CellValue(row, "expn_aud_sts_cd");
				formObj.pop_atch_file_lnk_id.value = sheetObjects[0].CellValue(row, "atch_file_lnk_id");
				formObj.pop_expn_aud_rslt_cd.value = sheetObjects[0].CellValue(row, "expn_aud_rslt_cd");
				formObj.pop_inv_no.value = sheetObjects[0].CellValue(row, "inv_no");
 
				var pop_inv_aud_curr_cd = sheetObj.CellValue(row, "inv_aud_curr_cd");
				if ( pop_inv_aud_curr_cd == null || pop_inv_aud_curr_cd == "")
					pop_inv_aud_curr_cd = sheetObj.CellValue(row, "curr_cd");
				
				formObj.pop_inv_aud_curr_cd.value 	= pop_inv_aud_curr_cd;
				formObj.pop_inv_usd_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_usd_diff_amt");
				formObj.pop_inv_aud_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_diff_amt");
				formObj.pop_inv_cfm_dt.value 		= sheetObj.CellValue(row, "inv_cfm_dt_ymd");
				
				if (sheetObjects[0].CellValue(row, "atch_file_lnk_id").length > 0) {
					formObj.pop_atch_file_lnk_flg.value = "Y";
				} else {
					formObj.pop_atch_file_lnk_flg.value = "";
				}
 
				var sParam = Array();
				sParam[0] = "sel_aud_cd=" + sheetObj.CellValue(row, "sel_aud_cd");
				var theURL = "ESD_EAS_0225.do?"+sParam.join("&");
				
				var winName = "AuditRemarkPopup";
				var features = "scroll:yes;status:no;resizable=no;help:no;dialogWidth:700px;dialogHeight:380px";
				ComOpenWindow(theURL,winName,features,true);
		}
	}
  
	/**
	 * Audit Remark 리턴값 설정
	 * CHM-201539630 Split03-Auto Audit Change Detail 수정 요청 - (2016-01-05 김대준C)
	 */ 
	function fn_setAuditRemark(rmk, name, id, rslt_cd, save_tp, file) {
		var sRow = sheetObjects[0].SelectRow;
		if (save_tp == 'S') {
			sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_cd') = rslt_cd;
		}
		
		sheetObjects[0].CellValue2(sRow, 'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow, 'rslt_chk') = '1';
		formObj.s_save_tp_cd.value = save_tp;
		
		doActionIBSheet(sheetObjects[0], formObj, MODIFY02);
	}  
	
	
	/**
	 * Audit Remark 리턴값 설정
	 */ 
	function fn_setAuditRemark2(rmk, name, id, rslt_cd, save_tp, file, curr_cd, aud_diff_amt, usd_diff_amt) {
		var sRow = sheetObjects[0].SelectRow;
		if (save_tp == 'S') {
			sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_cd') = rslt_cd;
		}
		
		sheetObjects[0].CellValue2(sRow, 'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow, 'expn_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow, 'rslt_chk') = '1';
		
		sheetObjects[0].CellValue(sRow, "inv_aud_curr_cd") = curr_cd;
		sheetObjects[0].CellValue(sRow, "inv_aud_diff_amt") = aud_diff_amt;
		sheetObjects[0].CellValue(sRow, "inv_aud_usd_diff_amt") = usd_diff_amt;
		
		formObj.s_save_tp_cd.value = save_tp;
		
		doActionIBSheet(sheetObjects[0], formObj, MODIFY02);

	}
		