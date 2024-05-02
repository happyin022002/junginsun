/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0361.js
*@FileTitle : M&R Invoice Charge Detail
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
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code

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
			case "btn_invoice":
				goInvoicePopup(sheetObject);
				break;
			case "btn_repair":
				goRepairPopup(sheetObject);
				break;
			case "btn_agreement":
				goAgreementPopup(sheetObject);
				break;				
			case "btn_tariff":
				goTariffPopup(sheetObject);
			    break;
			case "btn_eac_if":
				goEacIFPopup(sheetObject);
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
		}
		
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		if(req_cost_cd != ""){
			formObject.s_cost_cd.Code = req_cost_cd;
		}
		if(req_difference != ""){
			formObject.s_difference.Code = req_difference;
		}
		if(req_err_type != ""){
			formObject.s_err_type.Code = req_err_type;
		}
		
		if(subsysIF){
			ComBtnDisable('btn_eac_if');
		}
		
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/


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
					style.height = GetSheetHeight(15);
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
					
					var HeadTitle = "RHQ|W/O Office|Invoice Office|Cost Group|EQ_KND_CD|" +
							        "Cost Detail|W/O No.|EQ No.|TP/SZ|W/O Cur.|W/O AMT|INV. Cur.|" +
							        "Adjusted\nINV AMT|INV AMT\n(USD)|Diff\nAmount|Diff\nRatio|Est. Error|Tariff\nAmount|W/O Error|INV_NO|CFM_DT|VNDR_SEQ|" +
							        "MNR_GRP_TP_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|SPR_PRT_UC_AMT|" +
							        "BZC_AMT|CHG_WO_AMT|AGMT_NO|AGMT_OFC_CD|TRF_NO|EAC I/F|MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|COST_CD";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"rhq_inv_ofc_cd",	false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"wo_ofc_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"inv_ofc_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"eq_knd_cd_nm",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"eq_knd_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,		false,	"cost_cd_nm",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daCenter,	false,	"wo_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daCenter,	false,	"eq_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"eq_tpsz_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"wo_curr_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,		daRight,	false,	"cost_amt",			false,			 "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	false,	"inv_curr_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,		daRight,	false,	"inv_amt",			false,			 "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,		daRight,	false,	"inv_usd_amt",		false,			 "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	50,		daRight,	false,	"chg_wo_amt",		false,			 "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	50,		daRight,	false,	"inv_diff_pct",		false,			 "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		200,	daLeft,		false,	"est_vrfy_yn",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,		daRight,	false,	"trf_amt",			false,			 "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		200,	daLeft,		false,	"wk_vrfy_desc",		false,          "",       dfNone,	0,     false,       true);

					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"inv_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"cfm_dt",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"vndr_seq",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"mnr_grp_tp_cd",	false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"mnr_agmt_amt",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"mnr_wrk_amt",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"inv_amt",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"spr_prt_uc_amt",	false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"bzc_amt",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"chg_wo_amt",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"agmt_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"agmt_ofc_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"trf_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,	false,	"eac_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"mnr_ord_ofc_cty_cd",false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"mnr_ord_seq",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"cost_cd",			false,          "",       dfNone,	0,     false,       true);
					
				}
				break;
		}
	}
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
			case "s_eq_knd_cd":		//COST GROUP CODE (MNR_GEN_CD : CD00004 
				with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;	
					UseCode = true;
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 190;
					ValidChar(2,1);	//영문대문자,숫자
					MaxLength = 2;
					
					setComboData(comboObj);
				}
			break; 
			
			case "s_cost_cd":		//COST CODE MNG_GEN_CD : (UG, GG, ZG) 
				with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("center|left");        
					SetColWidth("80|250");
					DropHeight = 190;
//					ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
					ValidChar(5,0);	//숫자
					MaxLength = 6;
				}
			break; 	
			case "s_difference":		//DIFFERENCE
				with (comboObj) { 
					MultiSelect = false;
					UseAutoComplete = false;	
					SetColAlign("left");        
					SetColWidth("50");
					DropHeight = 160;
					ValidChar(2,0);	//영문대문자
					MaxLength = 4;
					setComboData(comboObj);
				}
			break;
			case "s_err_type":		//ERROR TYPE
				with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = false;
					UseCode = true;
					SetColAlign("center|left");        
					SetColWidth("80|250");
					DropHeight = 160;
					ValidChar(2,0);	//영문대문자
					MaxLength = 4;
				}
			break;
		}
	}
	
	function setComboData(comboObj, param){ 
		var comboID = comboObj.id;
		var frm = document.form;
		var sheetObj = sheetObjects[1];
		switch(comboID){
			case "s_eq_knd_cd":
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
			case "s_difference":
				comboObj.InsertItem(0, "Estimate Error", "E");
				comboObj.InsertItem(1, "W/O Error", "W");
				comboObj.InsertItem(2, "Unmatch Between W/O & INV", "U");
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
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_EAS_0361GSAdap.do", EasFrmQryString(formObj));
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
					}
					
					if( !confirm(ComGetMsg("EAS90046", "Confirm"))) {
						return false;
					}
					formObj.f_cmd.value = MODIFY01;
	            	sheetObj.DoSave("ESD_EAS_0360GS.do",EasFrmQryString(formObj),'sel',false);
				}
				// 저장 후 조회.
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
				break;			
			
			case COMMAND01:     // Account Combo
				formObj.f_cmd.value = sAction;	// COMMAND01
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GS.do", FormQueryString(formObj));
				createCustomCombo("account", ComGetEtcData(sXml, "account"));	//Account & Cost 초기화
			break;
			
			case COMMAND02:     // Cost Combo
				formObj.f_cmd.value = sAction;	// COMMAND02
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0360GS.do", FormQueryString(formObj));
				createCustomCombo("Cost", ComGetEtcData(sXml, "cost"));	//Account & Cost 초기화
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
		
		if(frm.s_cost_group_cd.value != ""){
			comboObj.Code = frm.s_cost_group_cd.value;
			comboObj.Enable = false;
		}
		
	}
	
	/**
	 * Cost Group Code 데이터 변경시
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 */
	function s_eq_knd_cd_OnChange(comboObj, Index_Code, Text){
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
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				// The period cannot exceed 90 days.
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
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	var sParam = Array();
    	var formObject = document.form;
		sParam[0] = "s_inv_no="+sheetObj.CellValue(Row, "inv_no");
		
//        ComOpenWindowCenter("ESD_EAS_0361.do?"+sParam.join("&"), "winSpDtl", "1030", "535", true, "no");
		
		return;
    }
    
    /**
     * MNR INVOICE POPUP
     * @param sheetObj
     */
    function goInvoicePopup(sheetObj){
    	var row = sheetObj.SelectRow;
    	
		var sUrl    = '/hanjin/EES_MNR_0042.do';
		var iWidth  = 1030;
		var iHeight = 700;
		var sTargetObjList = "";
		var sDisplay = "0,1";
		var param = "?from_sys=EAS&inv_no="+sheetObj.CellValue(row, "inv_no") + "&wo_no=" + sheetObj.CellValue(row, "wo_no") + "&inv_ofc_cd=" + sheetObj.CellValue(row, "inv_ofc_cd") + "&inv_cfm_dt=" + sheetObj.CellValue(row, "cfm_dt");
		
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);	   
    }
    
    /**
     * MNR REPAIR POPUP
     * @param sheetObj
     */
    function goRepairPopup(sheetObj){
    	var row = sheetObj.SelectRow;
    	
		var sUrl    = '/hanjin/EES_MNR_0028.do';
		var iWidth  = 1030;
		var iHeight = 600;
		var sTargetObjList = "";
		var sDisplay = "0,1";
		var param = "?from_sys=EAS&eq_no="+sheetObj.CellValue(row, "eq_no") + "&wo_no=" + sheetObj.CellValue(row, "wo_no");
		
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);	   
    }

    /**
     * MNR REPAIR AGREEMENT POPUP
     * @param sheetObj
     */
    function goAgreementPopup(sheetObj){
    	var row = sheetObj.SelectRow;
    	
		if(row < 0) {return;}
		
		var agmt_no = sheetObj.CellValue(row, "agmt_no");
		var agmt_ofc_cd = sheetObj.CellValue(row, "agmt_ofc_cd");

		if(agmt_no.trim() == ""){
			ComShowCodeMessage("COM130402","Agreement");  //{?msg1} doesn\'t exist
		} else {
			ComOpenPopup('/hanjin/EES_MNR_0218.do?agmt_no='+agmt_no+'&agmt_ofc_cd='+agmt_ofc_cd, 1050, 620, '', "0,1,1,1,1,1", true);
		}
    }

    /**
     * MNR REPAIR TARIFF POPUP
     * @param sheetObj
     */
    function goTariffPopup(sheetObj){
    	var row = sheetObj.SelectRow;
    	
		if(row < 0) {return;}
		var trfNo = sheetObj.CellValue(row, "trf_no");
		if(trfNo.trim() == ""){
			ComShowCodeMessage("COM130402","Tariff No");  //{?msg1} doesn\'t exist
		} else {
	        ComOpenPopup('/hanjin/EES_MNR_0215.do?trf_no='+trfNo, 1015, 670, '', '1,0,1,1,1,1,1,1,1,1,1,1', true);
		}

    }

    /**
     * EAC INTERFACE POPUP
     * @param sheetObj
     */
    function goEacIFPopup(sheetObj){
    	var row = sheetObj.SelectRow;
    	var url = "ESD_EAS_0224.do?";

    	var param = "p_sys_div_cd=MNR"
    		      + "&p_sys_if_cd=MNR"
    		      + "&p_inv_no=" + sheetObj.CellValue(row, "inv_no")
    		      + "&p_vndr_seq=" + sheetObj.CellValue(row, "vndr_seq")
    		      + "&p_eq_knd_cd=" + sheetObj.CellValue(row, "eq_knd_cd")
    		      + "&p_mnr_ord_ofc_cty_cd=" + sheetObj.CellValue(row, "mnr_ord_ofc_cty_cd")
    		      + "&p_mnr_ord_seq=" + sheetObj.CellValue(row, "mnr_ord_seq")
    		      + "&p_eq_no=" + sheetObj.CellValue(row, "eq_no")
    		      + "&p_cost_cd=" + sheetObj.CellValue(row, "cost_cd")
    		      + "&p_cur_cd=" + sheetObj.CellValue(row, "inv_curr_cd")
    		      + "&p_inv_amt=" + sheetObj.CellValue(row, "inv_amt")
    		      + "&p_ofc_cd=" + sheetObj.CellValue(row, "inv_ofc_cd")
    		      + "&p_if_inv_no=" + sheetObj.CellValue(row, "inv_no")
    		      + "&p_if_inv_vndr_seq=" + sheetObj.CellValue(row, "vndr_seq")
    		      + "&p_if_eq_knd_cd=" + sheetObj.CellValue(row, "eq_knd_cd")
    		      + "&p_if_wo_no=" + sheetObj.CellValue(row, "wo_no")
    		      + "&p_if_cntr_no=" + sheetObj.CellValue(row, "eq_no")
    		      + "&p_if_cost_cd=" + sheetObj.CellValue(row, "cost_cd"); 
    	

	   	var winName = "EACTransferPopup";
	   	var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:620px";

	   	ComOpenWindow(url+param,winName,features,true);
    }
    
    /**
     * EAC TRANSFER 작업 후 후처리 FUNCTION
     * 1. DETAIL GRID에 EAC NO 입력
     * 2. 해당 데이터 DB UPDATE
     * 3. 해당 부모 데이터 DB UPDATE
     * 4. DETAIL POPUP 닫힐때 부모 데이터 COMBO BOX 수정 가능하도록 변경
     * @param eac_no
     */
    function fn_setEacNo(eac_no){
		var formObj = document.form; 
    	if(eac_no != ''){
    		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,'eac_no') = "Y";
    		if(formObj.t_eac_if_flg.value == ""){
    			formObj.t_eac_if_flg.value = "Y";
    		}
    	}
    }

	/**
	 * EAC I/F시 Parent 화면의 상태값 변경
	 */	
	function unLoadEac(){
		var formObj = document.form; 
		if(formObj.t_eac_if_flg.value == "") return;
		var parentObj = window.dialogArguments;
		parentObj.fn_setEacIfFlg();
	}
