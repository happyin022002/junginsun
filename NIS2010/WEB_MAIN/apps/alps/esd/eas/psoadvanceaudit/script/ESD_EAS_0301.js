/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0301.js
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : 
*@LastVersion : 1.0
* 2014-12-05 
* 1.0 최초 생성
* 
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
* 2016.07.09 CHM-201641447 PSO Auto Audit - Audit Tool(Tariff Simulation) 추가
* 2016.07.13 CHM-201642602 PSO Auto Audit - ComShowCodeMessage("EAS90045", "office") 주석 처리
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0301 : 예)Route UnMatch List 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0301() {
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

	// offce_level 설정 H : 본부, R:RQH, O: 기타
	var ofcLevel="";   
	var oldChk="";

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
			case "btn_retrieve2":
				doActionIBSheet(sheetObject,formObject,SEARCH02);
				
				break;
			case "btn_new":
				init_form();
				break;				
			case "btng_confirm":
				formObject.s_save_tp_cd.value = 'C';
				doActionIBSheet(sheetObject,formObject, MODIFY01);
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
	        case "btn_sp_cd":	// S/P No. Popup 
	        	ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setServiceProviderInfo', '0,0', true, true);
	        	break;
			case "btn_transfer": // EAC transfer
				eac_transfer(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				break;
			case "btn_history":	// History Account
				if(sheetObject.RowCount > 0) {
					sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				} else {
					ComShowMessage(ComGetMsg("EAS00009"));
				}			
				
				break;
				
			case "btn_simulation": // Tariff Simulation
				if(sheetObject.RowCount > 0) {
					tariffSimulation(sheetObject, sheetObject.SelectRow);
				} else {
					ComShowMessage(ComGetMsg("EAS00009"));
				}
				break;
				
			case "btn_Tariff": // Port Tariff
				if(sheetObject.RowCount > 0) {
					port_tariff(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				} else {
					ComShowMessage(ComGetMsg("EAS00009"));
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
   	         	
			case "inv_no_multi1":  
				rep_Multiful_inquiry("inv_no", "Invoice No. "); 
				break;	
			case "csr_no_multi1":  
				rep_Multiful_inquiry("csr_no", "CSR No."); 
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
	function loadPage(divChargeType) {
		var formObj = document.form;
		
		
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		getContractTypeComboList(document.contract_type , contract_typeCode , contract_typeText, 'ALL'); 						// 멀티 콤보 (Contract type) 설정
		getVesselClassComboList(document.vessel_class , vessel_classCode , vessel_classText, 'ALL'); 						// 멀티 콤보 (Vessel Class) 설정
//		getEasIbComboList(document.contract_type, contract_typeCode , contract_typeText   , 'ALL'); // 멀티 콤보 (Contract type) 설정
		getEasIbComboList(document.audit_status , audit_statusCode , audit_statusText , 'ALL'); // s_expn_aud_sts_cdCode
		getEasIbComboList(document.s_expn_aud_sts_cd , s_expn_aud_sts_cdCode , s_expn_aud_sts_cdText , 'ALL'); // s_expn_aud_sts_cdCode
		getEasIbComboList(document.if_status , if_statusCode , if_statusText , 'ALL'); // if_status 
		doActionIBSheet(sheetObjects[0], formObj, COMMAND03);	//RHQ Combo
 		doActionIBSheet(sheetObjects[0], formObj, "offce_level"); // RHQ
 		
 		//html컨트롤 이벤트초기화
 		initControl();
 		init_form();
 		
		if (ofcLevel == 'O' || ofcLevel == 'R') {
			ComBtnDisable("btng_confirm"); // Confirm 버튼 비활성화
		}

//		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
	 

	/**
	 * Diff 변경 시 Diff값 변경.
	*/
	function diffChange() {
		formObj= document.form;
		formObj.diff_num.value = '';

		if(formObj.diff.value == ''){
			ComEnableObject(formObj.diff_num,false);
		}else{
			ComEnableObject(formObj.diff_num,true);		
		}
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  		axon_event.addListenerForm  ('keyup', 'obj_keyup', document.form);
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
  	}
  	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "spcode":
				vender_change();
			break;
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
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "period1":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "period2":
			ComClearSeparator(obj);
			obj.select();
			break;	
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
	                style.height = GetSheetHeight(15) ;
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

					var HeadTitle = "||Select|Auto Audit|Audit Result|Change Detail|Change Detail||||RHQ|Office|Port|Yard|VVD|Bound|ATB|Account Code|Account Name|Cost Code|Cost Code Name|S/P No.|Invoice No.|Issued|Confirmed|Invoice User|CSR No.|Cur.|Tariff Cost|Adjust Cost|Inv Amount|Diff.(%)|Diff Amount($)\nby Auditor|aud_curr_cd|aud_diff_amt|Formula Expression|Formula Expression|Audit Date|Checked by|Remark" +
							"|Berthing Hour|Last Port|Country of N.P|GRT|NRT|No of TUG(Arr)|No of TUG(Dep)|Payment Term |Payment Due Date|Paid Date" +
							"|SCGT|SCNT|Night|SDR|Tier|Contract"+
							"|iss_cty_cd|so_seq|so_dtl_seq|VSL_CD|CNTR_VSL_CLSS_CAPA|EAC_NO|atch_file_lnk_id|RE-BATCH\nStatus|bat_prog_sts_cd";
					var headCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(headCount, 5, 0, true);
					
					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
//					HeadRowHeight = 12;	
				   
					//데이터속성    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,                       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtCheckBox, 	   30,	  daCenter, true,	  "sel", 			  	          false,     	  "",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtHiddenStatus, 50,    daCenter, false,    "ibflag",         	          false,    	  "",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtCombo,        90,    daCenter, false,    "select_flg",                   false,          "",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtCombo,        90,    daCenter, false,    "auto_audit_flg",               false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtCombo,        90,    daCenter, false,    "select_flg_temp",              false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         30,    daCenter, true,     "expn_aud_rslt_cd",             false,    	  "",       dfNone,    0,     false,       false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtPopup, 	  130, 	  daLeft, 	true, 	  "port_chg_aud_rslt_rmk", 		  false,    	  "", 	    dfNone,    0,	  true, 	   true);
					InitDataProperty(0, cnt++, dtHidden,        0,    daCenter, false,    "rslt_chk",     				  false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,        0,    daCenter, false,    "port_chg_aud_rslt_usr_id",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,        0,    daCenter, false,    "port_chg_aud_rslt_usr_nm",     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         60,    daCenter, false,    "rhq",            	          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         60,    daCenter, false,    "office",                       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         60,    daCenter, false,    "port",            	          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter, false,    "yard",            	          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter, false,    "vvd",            	          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         60,    daCenter, false,    "bound",                        false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "vps_atb_dt",                   false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "acct_cd",                      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        250,    daLeft,   false,    "acct_nm",                      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "cost_cd",                      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        250,    daLeft,   false,    "cost_nm",                      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         60,    daCenter, false,    "sp_no",                        false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daLeft,   false,    "inv_no",                       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter, false,    "iss_dt",                       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter, false,    "upd_dt",                       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "cre_usr_id",                   false,          "",       dfNone,    0,     false,       true);					
					InitDataProperty(0, cnt++, dtData,        130,    daCenter, false,    "csr_no",       	              false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         50,    daCenter, false,    "curr_cd",                      false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "tariff_cost",                  false,          "",       dfFloat,   2,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "adjcost",                      false,          "",       dfFloat,   2,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "amount",                       false,          "",       dfFloat,   2,     false,       true);
					InitDataProperty(0, cnt++, dtData,         60,    daRight,  false,    "diff",                         false,          "",       dfFloat,   2,     false,       true);
					
					/* 추가::START */
					InitDataProperty(0, cnt++, dtData,     	  100, 	  daRight,	true,     "inv_aud_usd_diff_amt",     	  false,  		  "",		dfNullFloat,2, 	  false,	   true);
					InitDataProperty(0, cnt++, dtHidden,   	   65,    daRight,  true,     "inv_aud_curr_cd",     		  false,  		  "",       dfNone,     0, 	  false,       true);
					InitDataProperty(0, cnt++, dtHidden,   	   65, 	  daRight,  true,     "inv_aud_diff_amt",     		  false,  		  "",       dfNullFloat,2, 	  false,       true);
					/* 추가::END */
					
					InitDataProperty(0, cnt++, dtData,        250,    daLeft,   false,    "foml2",                        false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        250,    daLeft,   false,    "foml1",                        false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daLeft,   false,    "audit_dt",                     false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daLeft,   false,    "audit_usr_id",                 false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        250,    daLeft,   false,    "rmk",                          false,          "",       dfNone,    0,     false,       true);
					
					//sheet2 추가
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "berthing_hour",                false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         80,    daCenter, false,    "last_port",                    false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "country_of_np",                false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  false,    "grt",                          false,          "",       dfFloat,   0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  false,    "nrt",            	          false,          "",       dfFloat,   0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "arr_no_of_tug",                false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "dep_no_of_tug",                false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daRight,  false,    "pay_term_dys",                 false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        120,    daCenter, false,    "pay_due_dt",                   false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "ap_pay_dt",                    false,          "",       dfNone,    0,     false,       true);
					
				    //sheet3
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  false,    "suz_gt_wgt",    	              false,          "",       dfFloat,   0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  false,    "madn_voy_suz_net_tong_wgt",    false,          "",       dfFloat,   0,     false,       true);
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "night_flg",                    false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  false,    "sdr_rt",                       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  false,    "scg_car_tier",                 false,          "",       dfNone,    0,     false,       true);
					
					// sheet4 
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, false,    "contract",                     false,          "",       dfNone,    0,     false,       true);
					
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "iss_cty_cd",                   false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "so_seq",                       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "so_dtl_seq",                   false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "vsl_cd",                   	  false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, false,    "cntr_vsl_clss_capa",           false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,       80,    daCenter, false,    "eac_no",   		              false,          "",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtHidden,      100,    daLeft,   true,     "atch_file_lnk_id",             false,    	  "",       dfNone,    0,     false,       false,   0,  false, true,  "", false);

					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	false,	"bat_prog_sts_nm",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	80,		daCenter,	false,	"bat_prog_sts_cd",	false,          "",       dfNone,    0,    false,       true);
					
					InitDataCombo(0, 'select_flg',"|"+sel_aud_cdText, "|"+sel_aud_cdCode);
					InitDataCombo(0, 'select_flg_temp', "|"+s_expn_aud_sts_cdText,"|"+s_expn_aud_sts_cdCode);
					InitDataCombo(0, 'auto_audit_flg', "|"+auto_audit_flgText,"|"+auto_audit_flgCode);
					
				}
				break;

		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			
		case SEARCH02:
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("ESD_EAS_0301GS.do", EasFrmQryString(formObj));
	
				break;
			
		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
//				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_EAS_0301GS.do", EasFrmQryString(formObj));
//				ComOpenWait(false);
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
						if( sheetObj.CellValue( rowArr[i], "select_flg") == '') {
							ComShowMessage(ComGetMsg("EAS80001", "[Select] column"));
							return false;
						}

						if ((getEasAudCdMapg(sheetObj.CellValue( rowArr[i], "select_flg")) != sheetObj.CellValue( rowArr[i], "auto_audit_flg"))
								&& sheetObj.CellValue( rowArr[i], "port_chg_aud_rslt_rmk") == "") {
							ComShowMessage(ComGetMsg("EAS05014", "Change reason"));
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
	            	sheetObj.DoSave("ESD_EAS_0301GS.do",EasFrmQryString(formObj),'sel',false);
				}
				// 저장 후 조회.
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
				break;
			case MULTI02:
            	formObj.f_cmd.value = MODIFY01;
				var sParam = sheetObj.GetSaveString(false, true,"rslt_chk") + "&" + FormQueryString(formObj);
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0301GS.do", sParam);
	    		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					return false;
				} else if (State == "S") {
					var sRow = sheetObj.SelectRow;
					sheetObj.CellValue2(sRow, "rslt_chk") = "";
//					sheetObjects[0].CellValue2(sRow,'sel') = oldChk;
				}
				
//				// 저장 후 조회.
//				doActionIBSheet(sheetObj,document.form,IBSEARCH);
				break;
				 
			
			case COMMAND01:     // Account Combo
				formObj.f_cmd.value = sAction;	// COMMAND01
				var param = FormQueryString(formObj);
				var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0301GS.do", param);
				createCustomCombo("account", ComGetEtcData(sXml, "account"));	//Account & Cost 초기화
			break;
			
			case COMMAND02:     // Cost Combo
				formObj.f_cmd.value = sAction;	// COMMAND02
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", FormQueryString(formObj));
				createCustomCombo("Cost", ComGetEtcData(sXml, "cost"));	//Account & Cost 초기화
			break;
			
			case COMMAND03:		// RHQ Combo
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0026GS.do", sParam);
				var rhqCdArr = (ComGetEtcData(sXml, "rhq_list")).split("|");	//CTRL H/Q
				var rhqDescArr = (ComGetEtcData(sXml, "rhq_list")).split("|");	
				appendMultiComboItem(formObj.rhq, rhqCdArr, rhqDescArr, "", "DEF");
				formObj.rhq.InsertItem(0, "", "");
//				formObj.rhq.InsertItem(0, "ALL", "ALL");
				
				document.form.rhq.Index = 0;
				document.form.office.Index2 = 0;
			break;  
			
			case COMMAND04:      // Office Combo
		    	formObj.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
				
				return sXml;
			break;
			
			case COMMAND05:     // Vessel Class Combo
				formObj.f_cmd.value = COMMAND04;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", FormQueryString(formObj));
				createCustomCombo("vslClasss", ComGetEtcData(sXml, "vslClasss"));	//Vessel Class 초기화
			break;
			
			case COMMAND06:     // Vessel Combo
				formObj.f_cmd.value = COMMAND05;
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
			
			case COMMAND08:		//S/P No. [keyup:6자리]  
			    formObj.f_cmd.value = COMMAND03;	//

				var param = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", param );
				var spName = ComGetEtcData(sXml, "spname");
	
				if(spName == ''){
					ComShowCodeMessage("EAS90047", "S/P No.");
					ComSetFocus(formObj.spcode);
					return false;
				}
				document.form.spname.value = spName;
			break;
			
			case COMMAND09:		//CANAL Charge Type Check.  
			    formObj.f_cmd.value = COMMAND06;	//

				var param = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0301GS.do", param );
//				var canalChargeType = ComGetEtcData(sXml, "canalChargeType");
				formObj.portlChargeType.value = ComGetEtcData(sXml, "portlChargeType");
				formObj.serviceChargeType.value = ComGetEtcData(sXml, "serviceChargeType");
				formObj.canalChargeType.value = ComGetEtcData(sXml, "canalChargeType");
				formObj.otherChargeType.value = ComGetEtcData(sXml, "otherChargeType");
			break;
			
			case "offce_level":
				formObj.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
        		formObj.ofclevel.value = ofcLevel;
        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		var rhqSearchFlag = true;
        		// 로그인한 RHQ OFFCD 셋팅
        		formObj.rhq.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
        		// 로그인한 OFFCD 셋팅
        		formObj.office.InsertItem(0, formObj.ofc_cd.value, formObj.ofc_cd.value);
        		formObj.s_rhq_ofc_cd.value = rhq_ofc_cd;
        		if(ofcLevel=="O"){
        			// 본사(심사팀) RHQ 소속이외
            		rhqSearchFlag = false;
            		formObj.rhq.Enable=false;
            		formObj.office.Enable=false;  
//            		formObj.rhq.code2 = rhq_ofc_cd;
            		formObj.office.code2 = formObj.ofc_cd.value; 
        		}else if(ofcLevel=="R"){
        			rhqSearchFlag = false;
        			formObj.rhq.Enable=false;
        			formObj.office.Enable=true;        			
        			formObj.rhq.Index2=0;
//        			doActionIBCombo(formObj.rhq)
        			doActionIBCombo(formObj.office)
        		}else if(ofcLevel=="H"){
        			// 본사(심사팀) 소속
            		rhqSearchFlag = true;
            		formObj.rhq.Enable=true;
            		formObj.office.Enable=true;              
//            		formObj.rhq.code2 = rhq_ofc_cd;
            		formObj.office.code2 = formObj.ofc_cd.value;   	            		
        		}
        		
        		if(rhqSearchFlag){
        			// RHQ 콤보 리스트 조회
        			formObj.rhq.RemoveAll();
        			formObj.f_cmd.value = COMMAND02;
        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        			ComXml2ComboItem(sXml, formObj.rhq, "ofc_cd", "ofc_cd");
        			// 이폼에서는 권한 체크를 하지 않는다.
        			formObj.rhq.InsertItem(0, "", "");
	        		// RHQ에 해당하는 Office 조회
//        			doActionIBCombo(formObj.rhq);
        			doActionIBCombo(formObj.office)
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
		        var sXml = sheetObj.GetSaveXml("ESD_EAS_0301GS.do", sParam);
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

    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	switch(comboObj.id) {
	    case "office":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        formObj.office.RemoveAll();
	        ComXml2ComboItem(sXml, formObj.office, "ofc_cd", "ofc_cd");
	    	formObj.office.InsertItem(0, "", "");
	    	formObj.office.code2 = formObj.office.value
	    	//doActionIBCombo(formObj.s_ofc_cd)
	    	break;
    	}
    }
	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
//		if(sheetObj.RowCount > 0) {
//			for (var i=1; i < sheetObj.Rows; i++){
//				if(sheetObj.CellValue(i,"auto_audit_flg") == "O"){
//					if(sheetObj.CellValue(i,"select_flg") == ""){
//						sheetObjects[0].CellValue2(i, "auto_audit_flg") = "C";						
//					}
//	
//					if(sheetObj.CellValue(i,"select_flg") == "E"){
//						sheetObjects[0].CellValue2(i, "auto_audit_flg") = "F";
//					}
//				}
//			}
//		}
		
		if(sheetObj.RowCount > 0) {
			for (var i=1; i < sheetObj.Rows; i++){
				if(sheetObj.CellValue(i,"auto_audit_flg") == "F" && sheetObj.CellValue(i,"select_flg_temp") == ""){
					sheetObj.CellValue2(i, "select_flg") = "E";
					sheetObj.CellValue2(i, "sel") = "0";
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
	 				sheetObj.CellValue2(row, "sel") = "1";
	 				sheetObj.RowFontColor(row) = sheetObj.RgbColor(0,84,255);	// 파란
	 			} else {
	 				sheetObj.CellValue2(row, "sel") = "0";
	 			}
	 		break;
	 	}
	}
	
	function sheet1_OnClick(sheetObj, Row,Col,Value){
	
	}
	
	/**
	 * 화면 로딩시 콤보조회 
	 */
	function sheet1_OnLoadFinish(sheetObj){
//		var formObj = document.form;
	}
	
	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			
			sheetObj.RemoveAll();
			formObj.reset();
			formObj.rhq.index = 0;
			formObj.office.index = 0;
			
			formObj.period1.value = ComGetDateAdd(ComGetNowInfo(),"D", -14, "-");
			formObj.period2.value = ComGetNowInfo();
			
			formObj.charge_type.index = 0;
			if (formObj.divChargeType.value == "1") {
				formObj.charge_type.disabled = false;
				sheetObjects[0].ColHidden("bat_prog_sts_nm") = false; // 추가컬럼 Auto Audit에서만 보이게 처리
			}else if (formObj.divChargeType.value == "2") {
				formObj.charge_type.disabled = true;
				sheetObjects[0].ColHidden("bat_prog_sts_nm") = true; // 추가컬럼 Auto Audit에서만 보이게 처리
			}
			formObj.acct_cd.index = 0;
			formObj.acct_nm.value = "";
			formObj.cost_cd.index = 0;
			formObj.cost_nm.value = "";
			formObj.port_cd.value = "";
			formObj.yard_cd.Code = "";
			formObj.spcode.value = "";
			formObj.spname.value = "";
//			formObj.audit_status.value = "";
			formObj.audit_status.index = 0;
			formObj.contract_type.index = 0;
			formObj.contract_type_nm.value = formObj.contract_type.GetIndexText(formObj.contract_type.Index, 1);
			formObj.vessel_class.index = 0;
			formObj.vessel.index = 0;
			if (formObj.divChargeType.value == "1") {
				formObj.diff.value = "";
				formObj.diff_num.value = "";
				ComEnableObject(formObj.diff_num,false);
			}else if (formObj.divChargeType.value == "2") {
				formObj.remark.value = "";
			}
			formObj.csr_no.value = "";
			formObj.inv_no.value = "";
			formObj.if_status.index = 0;
			
			//팝업으로 호출시
			var s_popup_flg = formObj.s_popup_flg.value;
			if (s_popup_flg == "Y") {
				formObj.rhq.Code = formObj.s_popup_rhq_cd.value;
				//doActionIBCombo(formObj.rhq); // RHQ
				formObj.office.code2 = formObj.s_popup_inv_ofc_cd.value;
				
				formObj.period1.value = formObj.s_popup_fm_dt.value;
				formObj.period2.value = formObj.s_popup_to_dt.value;
				formObj.audit_status.code2 = formObj.s_popup_auto_aud_sts_cd.value;
				formObj.s_expn_aud_sts_cd.code2 = formObj.s_popup_expn_aud_sts_cd.value;
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_EAS_0301GS.do", EasFrmQryString(formObj));
			}
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
				
			//	if (formObj.office.index < 1) {
			//		ComShowCodeMessage("EAS90045", "office");
			//		ComSetFocus(formObj.office);
			//		return false;
			//	}
				
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
				if(obj.name=="csr_no"){
					ComKeyOnlyAlphabet('uppernum', "44");
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
				
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
//				if (formObj.rhq.Index == -1 || formObj.rhq.Index == 0) {
//					ComShowCodeMessage("EAS90045", "RHQ");
//					ComSetFocus(formObj.rhq);
//					return false;
//				} else if (formObj.office.Index == -1) {
//					ComShowCodeMessage("EAS90045", "Office");
//					ComSetFocus(formObj.office);
//					return false;
//				}

				if (formObj.period1.value == "" || formObj.period1.value.length != 10) {
					ComShowCodeMessage("EAS90045", "Period");
					ComSetFocus(formObj.period1);
					return false;
				} else if (formObj.period2.value == "" || formObj.period2.value.length != 10) {
					ComShowCodeMessage("EAS90045", "Period");
					ComSetFocus(formObj.period2);
					return false;
				} else if (formObj.divChargeType.value == "1") {
					if (formObj.diff.value != "" && formObj.diff_num.value == "") {
						ComShowCodeMessage("EAS90004", "Diff");
						ComSetFocus(formObj.diff_num);
						return false;
					}
				}

				// The period cannot exceed 90 days.
				if(ComGetDaysBetween(formObj.period1, formObj.period2) > 92){
					ComShowMessage(msgs['EAS90087']);
	                ComSetFocus(formObj.period1);
	                return false;
				}

			break;
		}
		
		return result;
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
	  * 외부 콤보박스의 리스트 가져오기
	  * 멀티 콤보 (Contract type) 설정
	  **/
	 function getVesselClassComboList( combo , code , text , option) {
		 var comboNoList = code;
		 var comboNmList = text;
		 var comboNoArray = new Array();
		 var comboNmArray = new Array();
		 
		 comboNoArray = comboNoList.split("|");
		 comboNmArray = comboNmList.split("|");
		 
		 combo.RemoveAll();
		 
		 for(var i=0; i<comboNoArray.length; i++) {
			 combo.InsertItem(i, comboNmArray[i],  comboNoArray[i]);
		 }
		 
		 combo.InsertItem(0, "" ,  option);
	 }
		

	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "rhq": 	//CTRL H/Q
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 5;
				}
			break;
				
			case "office":		//CTRL H/Q
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
//					ValidChar(2,0);	//영문대문자
//					MaxLength = 6;
				}
			break;	    

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
//					ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
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
					SetColWidth("160");
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
//					InsertItem(0, "PORT CHARGE", "01");
//					InsertItem(1, "PORT SERVICE CHARGE", "02");
//					InsertItem(2, "CANAL TRANSIT FEE", "03");
//					
//					if (formObject.divChargeType.value == "2") {
//						InsertItem(3, "OTHER", "04");
//					}
					InsertItem(0, "", "00");
					InsertItem(1, "PORT CHARGE", "01");
					InsertItem(2, "PORT SERVICE CHARGE", "02");
					InsertItem(3, "CANAL TRANSIT FEE", "03");
					
					if (formObject.divChargeType.value == "2") {
						InsertItem(4, "OTHER", "04");
					}
				
			    }
				break;
			case "if_status":		//if_status
				with (comboObj) {
				DropHeight = 170;
				
			}
				break;
			case "s_expn_aud_sts_cd":		//if_status
				with (comboObj) {
				DropHeight = 170;
				
			}
				break;
			
		}
	}
	 
	 /**
	  * RHQ onchange
	  */
	 function rhq_OnChange(comboObj, Index_Code, Text) {
		var frm = document.form;
     		frm.s_rhq_ofc_cd.value = comboObj.Code;
		var sXml = doActionIBSheet(sheetObjects[0], frm, COMMAND04);
		
			
    	ComXml2ComboItem(sXml, document.form.office, "ofc_cd", "ofc_cd");
    	frm.office.InsertItem(0, "", "ALL");
    	frm.office.Index2=0;
    	
		doActionIBSheet(sheetObjects[0], frm, COMMAND01);	//Account Combo
		
		if(Index_Code != ''){
			doActionIBSheet(sheetObjects[0], frm, COMMAND09);	//CANAL Charge Type Check.
		}
		
		var i = 0;
		comboObjects[2].RemoveAll();
		comboObjects[2].InsertItem(0, "", "00");

		if (frm.divChargeType.value == "1") {
			if(frm.portlChargeType.value == "5117"){
				i = i+1;
				comboObjects[2].InsertItem(i, "PORT CHARGE", "01");
			}
			if(frm.serviceChargeType.value == "5118"){
				i = i+1;
				comboObjects[2].InsertItem(i, "PORT SERVICE CHARGE", "02");
			}
			if(frm.canalChargeType.value == "5119"){
				i = i+1;
				comboObjects[2].InsertItem(i, "CANAL TRANSIT FEE", "03");
			}
			if(frm.otherChargeType.value == "564611"){
				i = i+1;
				comboObjects[2].InsertItem(i, "OTHER", "04");
			}

			comboObjects[2].Index2=0;
		}else if (frm.divChargeType.value == "2") {
//			comboObjects[2].RemoveAll();
//			comboObjects[2].InsertItem(0, "", "00");
//			comboObjects[2].InsertItem(1, "PORT CHARGE", "01");
//			comboObjects[2].InsertItem(2, "PORT SERVICE CHARGE", "02");
//			comboObjects[2].InsertItem(3, "CANAL TRANSIT FEE", "03");
//			comboObjects[2].InsertItem(4, "OTHER", "04");
//			comboObjects[2].Index2=0;
			if(frm.portlChargeType.value != "5117"){
				i = i+1;
				comboObjects[2].InsertItem(i, "PORT CHARGE", "01");
			}
			if(frm.serviceChargeType.value != "5118"){
				i = i+1;
				comboObjects[2].InsertItem(i, "PORT SERVICE CHARGE", "02");
			}
			if(frm.canalChargeType.value != "5119"){
				i = i+1;
				comboObjects[2].InsertItem(i, "CANAL TRANSIT FEE", "03");
			}
			if(frm.otherChargeType.value != "564611"){
				i = i+1;
				comboObjects[2].InsertItem(i, "OTHER", "04");
			}

			comboObjects[2].Index2=0;
		}
	}
	 
	/**
	 * Charge Type 변경 시 sheet 변경
	*/
	function charge_type_OnChange(comboObj, Index_Code, Text) {
		
		 var strChargeType = document.form.charge_type.Code;

//		sheetObjects[0].RemoveAll();
// 		ComConfigSheet(sheetObjects[0]);
// 		if(strChargeType == ''){			// ALL
// 			initSheet(sheetObjects[0],1);
// 		}else if(strChargeType == '01' || strChargeType == '02'){	// PORT CHARGE, PORT SERVICE CHARGE
// 			initSheet(sheetObjects[0],2);
// 		}else if(strChargeType == '03'){	// CANAL TRANSIT FEE
// 			initSheet(sheetObjects[0],3);
// 		}
 		if(strChargeType == ''){			// ALL
 			
 		}else if(strChargeType == '01'){	// PORT CHARGE
			//sheet2 추가
 			sheetObjects[0].ColHidden("berthing_hour")               = true;
 			sheetObjects[0].ColHidden("last_port")                   = true;
 			sheetObjects[0].ColHidden("country_of_np")               = true;
 			sheetObjects[0].ColHidden("grt")                         = true;
 			sheetObjects[0].ColHidden("nrt")                         = true;
 			sheetObjects[0].ColHidden("arr_no_of_tug")               = true;
 			sheetObjects[0].ColHidden("dep_no_of_tug")               = true;
 			sheetObjects[0].ColHidden("upd_usr_id")                  = true;
 			sheetObjects[0].ColHidden("pay_term_dys")                = true;
 			sheetObjects[0].ColHidden("pay_due_dt")                  = true;
 			sheetObjects[0].ColHidden("ap_pay_dt")                   = true;
 			sheetObjects[0].ColHidden("suz_gt_wgt")                  = true;
 			sheetObjects[0].ColHidden("madn_voy_suz_net_tong_wgt")   = true;
 			sheetObjects[0].ColHidden("night_flg")                   = true;
 			sheetObjects[0].ColHidden("sdr_rt")                      = true;
 			sheetObjects[0].ColHidden("scg_car_tier")                = true;
 			sheetObjects[0].ColHidden("contract")                    = true;
 		}else if(strChargeType == '02'){	// PORT SERVICE CHARGE
 			sheetObjects[0].ColHidden("berthing_hour")               = false;
 			sheetObjects[0].ColHidden("last_port")                   = false;
 			sheetObjects[0].ColHidden("country_of_np")               = false;
 			sheetObjects[0].ColHidden("grt")                         = false;
 			sheetObjects[0].ColHidden("nrt")                         = false;
 			sheetObjects[0].ColHidden("arr_no_of_tug")               = false;
 			sheetObjects[0].ColHidden("dep_no_of_tug")               = false;
 			sheetObjects[0].ColHidden("upd_usr_id")                  = false;
 			sheetObjects[0].ColHidden("pay_term_dys")                = false;
 			sheetObjects[0].ColHidden("pay_due_dt")                  = false;
 			sheetObjects[0].ColHidden("ap_pay_dt")                   = false;
 			sheetObjects[0].ColHidden("suz_gt_wgt")                  = true;
 			sheetObjects[0].ColHidden("madn_voy_suz_net_tong_wgt")   = true;
 			sheetObjects[0].ColHidden("night_flg")                   = true;
 			sheetObjects[0].ColHidden("sdr_rt")                      = true;
 			sheetObjects[0].ColHidden("scg_car_tier")                = true;
 			sheetObjects[0].ColHidden("contract")                    = true; 			
 		}else if(strChargeType == '03'){	// CANAL TRANSIT FEE
 			sheetObjects[0].ColHidden("berthing_hour")               = false;
 			sheetObjects[0].ColHidden("last_port")                   = false;
 			sheetObjects[0].ColHidden("country_of_np")               = false;
 			sheetObjects[0].ColHidden("grt")                         = false;
 			sheetObjects[0].ColHidden("nrt")                         = true;
 			sheetObjects[0].ColHidden("arr_no_of_tug")               = true;
 			sheetObjects[0].ColHidden("dep_no_of_tug")               = true;
 			sheetObjects[0].ColHidden("upd_usr_id")                  = false;
 			sheetObjects[0].ColHidden("pay_term_dys")                = false;
 			sheetObjects[0].ColHidden("pay_due_dt")                  = false;
 			sheetObjects[0].ColHidden("ap_pay_dt")                   = false;
 			sheetObjects[0].ColHidden("suz_gt_wgt")                  = false;
 			sheetObjects[0].ColHidden("madn_voy_suz_net_tong_wgt")   = false;
 			sheetObjects[0].ColHidden("night_flg")                   = false;
 			sheetObjects[0].ColHidden("sdr_rt")                      = false;
 			sheetObjects[0].ColHidden("scg_car_tier")                = false;
 			sheetObjects[0].ColHidden("contract")                    = false; 		 			
 		}else if(strChargeType == '04'){	// Other
 			sheetObjects[0].ColHidden("berthing_hour")               = true;
 			sheetObjects[0].ColHidden("last_port")                   = true;
 			sheetObjects[0].ColHidden("country_of_np")               = true;
 			sheetObjects[0].ColHidden("grt")                         = true;
 			sheetObjects[0].ColHidden("nrt")                         = true;
 			sheetObjects[0].ColHidden("arr_no_of_tug")               = true;
 			sheetObjects[0].ColHidden("dep_no_of_tug")               = true;
 			sheetObjects[0].ColHidden("upd_usr_id")                  = false;
 			sheetObjects[0].ColHidden("pay_term_dys")                = false;
 			sheetObjects[0].ColHidden("pay_due_dt")                  = false;
 			sheetObjects[0].ColHidden("ap_pay_dt")                   = false;
 			sheetObjects[0].ColHidden("suz_gt_wgt")                  = true;
 			sheetObjects[0].ColHidden("madn_voy_suz_net_tong_wgt")   = true;
 			sheetObjects[0].ColHidden("night_flg")                   = true;
 			sheetObjects[0].ColHidden("sdr_rt")                      = true;
 			sheetObjects[0].ColHidden("scg_car_tier")                = true;
 			sheetObjects[0].ColHidden("contract")                    = true; 		  			
 		}
		
//        ComEndConfigSheet(sheetObjects[0]);
		var formObj = document.form;
//		formObj.acct_cd.RemoveAll();
//		formObj.cost_cd.RemoveAll();
		doActionIBSheet(sheetObjects[0], formObj, COMMAND01);	//Account Combo
//			doActionIBSheet(sheetObjects[0], formObj, COMMAND02);	//Cost Combo
		
	}
		 	 
	 
	/**
	 * RHQ Combo 선택시 Office Combo 셋팅
	 */	
	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
		comboObj.RemoveAll();
		
		if(optionCdArr != null){
			if(sFlag == "DEF"){
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}else{
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}
			comboObj.Code2 = selCode;
		}
		document.form.office.Index = 0;
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
	 		formObj.acct_cd.RemoveAll();
		 	formObj.acct_cd.InsertItem(0, "| ", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];
		 	}  
		 	formObj.acct_cd.Index = 0;
	 	}else if(codeType == 'Cost'){
	 		formObj.cost_cd.RemoveAll();
	 		formObj.cost_nm.value="";
		 	formObj.cost_cd.InsertItem(0, "| ", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.cost_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];
		 	}  
		 	formObj.cost_cd.Index2 = 0;
	 	}else if(codeType == 'vslClasss'){
	 		formObj.vessel_class.RemoveAll();
		 	formObj.vessel_class.InsertItem(0, " | ", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.vessel_class.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];
		 	}  
		 	formObj.vessel_class.Index2 = 0;
	 	}else if(codeType == 'vslClasssVessel'){
	 		formObj.vessel.RemoveAll();
		 	formObj.vessel.InsertItem(0, "| ", " ");	//ALL
		 	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		 		var comboItem = arrComboItems[i].split("↕");
		 		
		 		if(preCode != comboItem[0]){
		 			formObj.vessel.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		 		}
		 		preCode = comboItem[0];
		 	}  
		 	formObj.vessel.Index2 = 0;
	 	}
	 }
		
	 /**
	  * Account Combo 선택시 Account_name 셋팅
	  */
	 function acct_cd_OnChange(comboObj, Index_Code, Text){
	 	var formObj = document.form;
	 	formObj.acct_nm.value = formObj.acct_cd.GetText(Index_Code, 1);
	 	doActionIBSheet(sheetObjects[0], formObj, COMMAND02);	//Cost Combo
	 }
	
	 /**
	  * Cost Combo 선택시 Cost_name 셋팅
	  */
	 function cost_cd_OnChange(comboObj, Index_Code, Text){
	 	var formObj = document.form;
	 	formObj.cost_nm.value = formObj.cost_cd.GetText(Index_Code, 1);
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
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
		}   		
	}
	
	function yard_cd_OnKeyDown(comboObj, KeyCode, Shift){
//		gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");	//영문대문자,숫자만 입력 가능	
	} 
	
	/**
	 * S/P No. Popup
	 */	
	function setServiceProviderInfo(aryPopupData, row, col, sheetIdx) {
		
		var formObj = document.form;
		formObj.spcode.value = aryPopupData[0][1];
		formObj.spname.value = aryPopupData[0][2];
	 }
	
	 /**
	  * contract_type Combo 선택시 contract_type_name 셋팅
	  */
	 function contract_type_OnChange(combo, Index_Code, Text) {
		var formObj = document.form;
		if ( formObj.contract_type_nm.value == Text )  return;
		formObj.contract_type_nm.value = combo.GetText(Index_Code,1);

//		formObj.vessel_class.RemoveAll();
//		formObj.vessel.RemoveAll();
//		doActionIBSheet(sheetObjects[0], formObj, COMMAND05);	//Vessel Combo
		doActionIBSheet(sheetObjects[0], formObj, COMMAND06);	//Vessel Class - Vessel Combo
	 }
		
	 /**
	  * vessel_class Combo 선택시 vessel 셋팅
	  */
	 function vessel_class_OnChange(combo, Index_Code, Text) {
		var formObj = document.form;
//		formObj.vessel.RemoveAll();
		doActionIBSheet(sheetObjects[0], formObj, COMMAND06);	//Vessel Class - Vessel Combo
	 }
		
	/**
	 * History Account
	 */	
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var formObj = document.form;		
//	   	var contract_type = formObj.contract_type.GetIndexText(formObj.contract_type.Index, 0);
	   	var contract_type = formObj.contract_type.Code;
	   	var rhq = formObj.rhq.Code;
	   	var period1 = formObj.period1.value;
	   	var period2 = formObj.period2.value;
	   	var divChargeType = formObj.divChargeType.value;
	   	var charge_type = formObj.charge_type.Code;
	   	var vessel_class = formObj.vessel_class.Code; // vessel_class
	   	var vessel = formObj.vessel.Code;             // vessel
//	   	var acct_cd = formObj.acct_cd.Code;
//	   	var cost_cd = formObj.cost_cd.Code;
	   	var acct_cd = ComTrim(sheetObj.CellValue(Row, 'acct_cd'));
	   	var cost_cd = ComTrim(sheetObj.CellValue(Row, 'cost_cd'));
	   	var iss_cty_cd = ComTrim(sheetObj.CellValue(Row, 'iss_cty_cd'));
	   	var so_seq = ComTrim(sheetObj.CellValue(Row, 'so_seq'));
	   	var so_dtl_seq = ComTrim(sheetObj.CellValue(Row, 'so_dtl_seq'));
	   	var port = ComTrim(sheetObj.CellValue(Row, 'port'));
	   	var yard = ComTrim(sheetObj.CellValue(Row, 'yard'));
	   	var vsl_cd = ComTrim(sheetObj.CellValue(Row, 'vsl_cd'));
	   	var cntr_vsl_clss_capa = ComTrim(sheetObj.CellValue(Row, 'cntr_vsl_clss_capa'));
	   	var vvd = ComTrim(sheetObj.CellValue(Row, 'vvd'));
	   	
	   	

	   	if(iss_cty_cd == 'iss_cty_cd' || so_seq == 'so_seq'){
	   		ComShowMessage(ComGetMsg("EAS00009"));
	   		return false;
	   	}

	   	var theURL = "ESD_EAS_0302.do?contract_type="+contract_type
	   												+"&charge_type="+charge_type
	   												+"&period1="+period1
	   												+"&period2="+period2
	   												+"&iss_cty_cd="+iss_cty_cd
	   												+"&so_seq="+so_seq
	   												+"&so_dtl_seq="+so_dtl_seq
	   											   	+"&port="+port
	   											   	+"&yard="+yard
	   											   	+"&acct_cd="+acct_cd
	   											   	+"&cost_cd="+cost_cd
	   											   	+"&vsl_cd="+vsl_cd
	   											   	+"&cntr_vsl_clss_capa="+cntr_vsl_clss_capa
	   											    +"&vessel_class="+vessel_class
	   											    +"&vessel="+vessel
	   											    +"&rhq="+rhq
	   											    +"&divChargeType="+divChargeType
	   											   	+"&vvd="+vvd;
	   	var winName = "PortServiceChargeHistoryPopup";
//	   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1040px;dialogHeight:560px";
//	   	ComOpenWindow(theURL,winName,features,false);
	   	var features = "scroll:yes;status:no;help:no;dialogWidth:1024px;dialogHeight:620px";
	   	ComOpenWindow(theURL,winName,features,true);
	   	
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

	   	if(select_flg == 'A' || select_flg == 'E'){
	   		//EAC I/F
	   	}else{
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
	
	/**
	 * EAC transfer 팝업호출 및 저장 후 eac_no 선택한 Row에 셋팅.
	 */		
	function fn_setEacNo(eac_no){
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,'eac_no') = eac_no
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "select_flg_temp") = "EAC I/F";
		sheetObjects[0].CellEditable(sheetObjects[0].SelectRow, "sel") = false;
		sheetObjects[0].CellEditable(sheetObjects[0].SelectRow, "select_flg") = false;
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "sel") = ""; 
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
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function  vender_change(){
		formObj = document.form;
		if(formObj.spcode.value =="" ){
			formObj.spcode.value="";
			formObj.spname.value="";
			return;
		}

		var sParam = Array();
		sParam[0] = "f_cmd="+ SEARCH05;
		sParam[1] = "s_vndr_seq="+ formObj.spcode.value;
		var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", sParam.join("&"));
		var vndrNm = EasXmlString(sXml,"vndr_nm");
		
		if(vndrNm==0){
			ComShowCodeMessage('COM132202', 'S/P No.'); //사용할수 없는 S/P Code 
			formObj.spcode.value="";
			formObj.spname.value="";
			return;
		}
		formObj.spname.value = vndrNm;
	}
	
  /**
   * Sheet1에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var formObj = document.form;
	  var colName = sheetObjects[0].ColSaveName(col);
	  switch(colName){
	  	case('port_chg_aud_rslt_rmk'):
			formObj.pop_parent_row.value = row;
			formObj.pop_expn_aud_rslt_usr_nm.value = sheetObjects[0].CellValue(row, "port_chg_aud_rslt_usr_nm");
			formObj.pop_expn_aud_rslt_usr_id.value = sheetObjects[0].CellValue(row, "port_chg_aud_rslt_usr_id");
			formObj.pop_expn_aud_rslt_rmk.value = sheetObjects[0].CellValue(row, "port_chg_aud_rslt_rmk");
			formObj.pop_ofcLevel.value = ofcLevel;
			
			formObj.pop_mdl_tp_cd.value = 'PSO';
			formObj.pop_auto_aud_sts_cd.value = sheetObj.CellValue(row, "auto_audit_flg");
			formObj.pop_expn_aud_sts_cd.value = sheetObj.CellValue(row, "select_flg_temp");
			formObj.pop_atch_file_lnk_id.value = sheetObj.CellValue(row, "atch_file_lnk_id");
			formObj.pop_expn_aud_rslt_cd.value = sheetObj.CellValue(row, "expn_aud_rslt_cd");
			formObj.pop_inv_no.value = sheetObj.CellValue(row, "inv_no");

			var pop_inv_aud_curr_cd = sheetObj.CellValue(row, "inv_aud_curr_cd");
			if ( pop_inv_aud_curr_cd == null || pop_inv_aud_curr_cd == "")
				pop_inv_aud_curr_cd = sheetObj.CellValue(row, "curr_cd");
			
			formObj.pop_inv_aud_curr_cd.value 	= pop_inv_aud_curr_cd;
			formObj.pop_inv_usd_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_usd_diff_amt");
			formObj.pop_inv_aud_diff_amt.value 	= sheetObj.CellValue(row, "inv_aud_diff_amt");
			formObj.pop_inv_cfm_dt.value 		= sheetObj.CellValue(row, "upd_dt");
			
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
			sheetObjects[0].CellValue2(sRow,'port_chg_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_cd') = rslt_cd;
		}
		sheetObjects[0].CellValue2(sRow,'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow,'port_chg_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow,'port_chg_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow,'rslt_chk') = '1';
		formObj.s_save_tp_cd.value = save_tp;

		doActionIBSheet(sheetObjects[0],formObj, MULTI02);
		
	}	
	
  	
    
	/**
	 * Audit Remark 리턴값 설정
	 */ 
	function fn_setAuditRemark2(rmk, name, id, rslt_cd, save_tp, file, curr_cd, aud_diff_amt, usd_diff_amt) {

		var formObj = document.form;
		var sRow = sheetObjects[0].SelectRow;
		if (save_tp == 'S') {
			sheetObjects[0].CellValue2(sRow,'port_chg_aud_rslt_rmk') = rmk;
			sheetObjects[0].CellValue2(sRow,'expn_aud_rslt_cd') = rslt_cd;
		}
		
		sheetObjects[0].CellValue(sRow, "inv_aud_curr_cd") = curr_cd;
		sheetObjects[0].CellValue(sRow, "inv_aud_diff_amt") = aud_diff_amt;
		sheetObjects[0].CellValue(sRow, "inv_aud_usd_diff_amt") = usd_diff_amt;
	
		sheetObjects[0].CellValue2(sRow,'atch_file_lnk_id') = file;
		sheetObjects[0].CellValue2(sRow,'port_chg_aud_rslt_usr_nm') = name;
		sheetObjects[0].CellValue2(sRow,'port_chg_aud_rslt_usr_id') = id;
		sheetObjects[0].CellValue2(sRow,'rslt_chk') = '1';
		formObj.s_save_tp_cd.value = save_tp;

		doActionIBSheet(sheetObjects[0],formObj, MULTI02);
		
	}	
	
  	
  	
	/**
	 * Tariff Simulation 팝업 오픈
	 */   	
  	function tariffSimulation(sheetObj ,row){
  		
//  		port, yard, vvd, acct_cd, cost_cd, sp_no, iss_dt
//  		pPortCd, pYardCd, pAcctCd, pCostCd, pVvd, pVndrSeq, pIssueDate
		var sParam = Array();
		sParam[0] = "pPortCd="		+ sheetObj.CellValue(row, "port");
		sParam[1] = "pYardCd="		+ sheetObj.CellValue(row, "yard");
		sParam[2] = "pAcctCd="		+ sheetObj.CellValue(row, "acct_cd");
		sParam[3] = "pCostCd="		+ sheetObj.CellValue(row, "cost_cd");
		sParam[4] = "pVvd="			+ sheetObj.CellValue(row, "vvd");
		sParam[5] = "pVndrSeq="		+ sheetObj.CellValue(row, "sp_no");
		sParam[6] = "pIssueDate="	+ sheetObj.CellValue(row, "iss_dt");
		sParam[7] = "pUiId=ESD_EAS_0301";
		
		var theURL = "VOP_PSO_0038.do?"+sParam.join("&");
	   	var winName = "TariffSimulation";
	   	var features = "scroll:yes;status:no;resizable=no;help:no;dialogWidth:1024px;dialogHeight:620px";
	   	ComOpenWindow(theURL,winName,features,true);
  	}
	