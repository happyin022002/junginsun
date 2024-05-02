/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EES_DOD_0004.js
*@FileTitle : DOD DropOff Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class EES_DOD_0004 : 예)DOD DropOff Invoice Inquiry 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_DOD_0004() {
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
	
	var comboObjects = new Array();
	var comboCnt = 0;

	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code
	
	var timer = null;
	var sheetNum = null;
	
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
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_correction":
				goCorrection();
			    break;
			case "btn_detail":
				goDetail();
			    break;
            case "btn_cfm_from_dt":
            	var cal = new ComCalendar();
	            cal.select(formObject.s_cfm_from_dt, "yyyy-MM-dd");
            	break;
            case "btn_cfm_to_dt":
            	var cal = new ComCalendar();
            	cal.select(formObject.s_cfm_to_dt, "yyyy-MM-dd");
            	break;  			
			case "bkg_no_multi1":  
				rep_Multiful_inquiry("s_bkg_no", "BKG NO."); 
				break;	
			case "btn_location":  
				goLocation(); 
				break;	
			case "btn_customer":
				goCustomer();
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

	 
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		formObj = document.form;
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
					InitRowInfo( 1, 1, 10, 100);
					
					var HeadTitle = "|SEQ||BKG No.|CUR|AR I/F AMT|AR I/F AMT\n(USD)|INV Issue Date|INV OFC|INV Issuer|Special CUST|Special Customer|Special Customer|Special Customer|IND|TRO\nCancel";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,	0,		daCenter,	false,	"ibflag",				false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtSeq,		40,		daCenter,	false,	"seq",					false,    		"",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtRadioCheck,30,		daCenter,	false,	"sel",					false,    		"",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"bkg_no",				false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	false,	"curr_cd",				false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daRight,	false,	"ttl_amt",				false,          "",       dfFloat,   2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	70,		daRight,	false,	"ttl_usd_amt",			false,          "",       dfFloat,   2,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"iss_dt",				false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"iss_ofc_cd",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"iss_user",				false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"spcl_cust_cnt_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	false,	"spcl_cust_cnt_seq",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"customer",				false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		180,	daLeft,		false,	"spcl_cust_lgl_eng_nm",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"drp_off_chg_mnl_flg",	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtHidden,	80,		daCenter,	false,	"cxl_flg",				false,          "",       dfNone,    0,    false,       true);
					
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
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("EES_DOD_0004GS.do", FormQueryString(formObj));
				ComBtnEnable("btn_detail");
				
		    	if(formObj.s_cfm_ofc_cd.value == loginOfcCd){
		    		ComBtnEnable("btn_correction");
		    	}

				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}

	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			
			formObj.s_cfm_ofc_cd.value = loginOfcCd;
			
			formObj.s_cfm_from_dt.value = ComGetDateAdd(null, "d", -90, "-");
			formObj.s_cfm_to_dt.value = ComGetDateAdd(null, "d", 0, "-");

			comboObjects[0].Code2 = "A";

			formObj.s_bkg_no.value = "";
			formObj.s_loc_tp_cd.selectedIndex = 1;
			formObj.s_loc_cd.value = "";

			formObj.s_cust_cd.value = "";
			formObj.s_cust_nm.value = "";
			formObj.s_cntr_no.value = "";

			ComBtnDisable("btn_correction");
			ComBtnDisable("btn_detail");
	}

	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_cfm_ofc_cd":
				if(obj.value != loginOfcCd){
					ComBtnDisable("btn_correction");
				} else {
					ComBtnEnable("btn_correction");
				}
			break;
			case "s_cfm_ofc_cd":		// OFFICE CODE VAILIDATION
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH01 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				
				
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "Office Code"));
						obj.value = "";
						obj.focus();
					}
				}
			break;
			case "s_loc_cd":			// RCC, LCC, ECC, SCC, YARD, VALIDATION
				var formObjects = document.form;
				if(obj.value.trim() == ""){
					return;
				}
					
       			var s_type = formObjects.s_loc_tp_cd.options[formObjects.s_loc_tp_cd.selectedIndex].text;
				if ( formObjects.s_loc_tp_cd.value == '5' ) {	//yard
					var param = "f_cmd=" + SEARCH09 + "&s_value=" + obj.value;
	       		} else {	// AREA CD RCC, LCC, ECC, SCC
					var param = "f_cmd=" + SEARCH10 + "&s_value=" + obj.value + "&s_type=" + s_type;
	       		}
				
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				
				
				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", s_type));
						obj.value = "";
						obj.focus();
					}
				}
			break;
			case "s_cust_cd":		// Customer VAILIDATION
				if(obj.value.trim() == ""){
					document.form.s_cust_nm.value = "";
					return;
				}
				var param = "f_cmd="+SEARCH+"&cust_cd="+ obj.value.substr(0,2).toUpperCase() +"&cust="+ obj.value.substr(2);
				var sXml = sheetObjects[1].GetSearchXml("COM_ENS_041GS.do", param);
				var rtnArr = ComXml2ComboString(sXml, "cust_cd", "cust_nm");
				if(rtnArr != null && rtnArr.length > 1){
					obj.value = rtnArr[0];
					formObj.s_cust_nm.value = rtnArr[1];
				} else {
					ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
					obj.value = "";
					formObj.s_cust_nm.value = "";
					obj.focus();
				}
				
			break;
		}
	} 	

	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_cfm_from_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_cfm_to_dt":
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
		case "s_cfm_from_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			getMonthBetween();
			break;	
		case "s_cfm_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			getMonthBetween();
			break;
		}
	}

	function getMonthBetween() {
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
				if(formObj.s_cfm_ofc_cd == ''){
					ComShowMessage(ComGetMsg("COM130201", "Office"));
				}
				// The period cannot exceed 90 days.
				if(ComGetDaysBetween(formObj.s_cfm_from_dt, formObj.s_cfm_to_dt) < 0){
					ComShowMessage(ComGetMsg("DOD00007"));
					formObj.s_cfm_to_dt.value = ComGetDateAdd(formObj.s_cfm_from_dt.value, "d", +90, "-");
	                ComSetFocus(formObj.s_cfm_from_dt);
	                return false;
				}
				if(ComGetDaysBetween(formObj.s_cfm_from_dt, formObj.s_cfm_to_dt) > 90){
					ComShowMessage(ComGetMsg("DOD00008", "90"));
	                ComSetFocus(formObj.s_cfm_from_dt);
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
		
			case "s_ind_cd":
				with (comboObj) { 
			    	comboObj.InsertItem(0, "ALL", "A");
			    	comboObj.InsertItem(1, "Invoice", "I");  
			    	comboObj.InsertItem(2, "Manual", "M");
		    		comboObj.Code2 = "A";
				}
			break;
		}
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
    	
    	var bkg_no = sheetObj.CellValue(Row, "bkg_no");
    	var ind_cd = sheetObj.CellValue(Row, "drp_off_chg_mnl_flg");
    	
    	if(ind_cd == "Invoice") 
    		ind_cd = "I";
    	else if(ind_cd == "Manual")
    		ind_cd = "M";
    	
    	goDetailPopup(bkg_no, ind_cd);
		
		return;
    }
    
  	/**
     * 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnClick(sheetObj,Row,Col) {
    	var amt = sheetObj.CellValue(Row, "ttl_amt");
    	
    	if(formObj.s_cfm_ofc_cd.value == loginOfcCd){
    		ComBtnEnable("btn_correction");
    	}
    	
    	if(parseInt(amt) == 0){
//    		ComBtnDisable("btn_correction");
    	}
    	
		return;
    }


    function goCorrection(){
    	var sheetObj = sheetObjects[0];
    	
    	var row = sheetObj.SelectRow;
		
    	var bkg_no = sheetObj.CellValue(row, "bkg_no");
    	var ind_cd = sheetObj.CellValue(row, "drp_off_chg_mnl_flg");
    	
    	goCorrectionPopup(bkg_no, ind_cd);
    }
	
	function goDetail(){
		var sheetObj = sheetObjects[0];
		
		var row = sheetObj.SelectRow;
		
    	var bkg_no = sheetObj.CellValue(row, "bkg_no");
    	var ind_cd = sheetObj.CellValue(row, "drp_off_chg_mnl_flg");
    	
    	if(ind_cd == "Invoice") 
    		ind_cd = "I";
    	else if(ind_cd == "Manual")
    		ind_cd = "M";
    	
    	goDetailPopup(bkg_no, ind_cd);
		
		return;
	}
	
	// Return Location popup
	function goLocation(){
		var formObject = document.form;
        var cnt_cd = "";
        var loc_cd = "";
        cnt_cd = formObject.s_loc_tp_cd.value;
        loc_cd = formObject.s_loc_cd.value;
        if ( formObject.s_loc_tp_cd.value != '0' ) {	
			if ( formObject.s_loc_tp_cd.value == '5' ) {	//yard
				var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
				ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 800, 480, "3:s_loc_cd", "1,0,1,1,1,1,1", true);
       		} else {
    			var loc_code = "";
    			
    			if ( formObject.s_loc_tp_cd.value == "1" )  {
    				loc_code = "rcc_cd";
    			} else if ( formObject.s_loc_tp_cd.value == "2" ) {
    				loc_code = "lcc_cd";
    			} else if ( formObject.s_loc_tp_cd.value == "3" ) {
    				loc_code = "ecc_cd";
    			} else if ( formObject.s_loc_tp_cd.value == "4" ) {
    				loc_code = "scc_cd";
    			}
				var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code+":s_loc_cd", "0,1,1,1,1,1", true);		           		
       		}
        }
	}
	
	/**
	 * Customer popup
	 */
	function goCustomer(){
		ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustomer", "1,0,1,1,1,1,1", true);
	}
	
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustomer(aryPopupData) {
    	document.form.s_cust_cd.value = aryPopupData[0][3];
    	document.form.s_cust_nm.value = aryPopupData[0][4];
    }

	function goCorrectionPopup(bkgNo, indCd){
		var sParam = Array();
		
		sParam[0] = "bkg_no="+bkgNo;
		if(indCd == "Invoice") {
			indCd = "N";			
		} else if(indCd == "Manual") {
			indCd = "Y";			
		}
		sParam[1] = "drp_off_chg_mnl_flg="+indCd;

//		ComOpenWindowCenter("EES_DOD_0013.do?popup=yes&"+sParam.join("&"), "", "1030", "535", true, "no");
		ComOpenPopup("EES_DOD_0013.do?popup=yes&" + sParam.join("&"), 1024, 590, "setCorrection", "0,0,1,1,1,1");
	}
	
	function goDetailPopup(bkgNo, indCd){
    	var sParam = Array();
    	var formObject = document.form;
    	
		sParam[0] = "s_bkg_no="+bkgNo;
		sParam[1] = "s_ind_cd="+indCd;

        ComOpenWindowCenter("EES_DOD_0011.do?"+sParam.join("&"), "", "1030", "535", true, "no");
		
		return;
	}
	
    function setCorrection() {
    	// Correction Popup에서 AR Invoice수행 하고 나서
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getDod_Multi(rowArray,ret_val) {
		
		var formObj = document.form;  
		var tempText = ""; 
		//초기화   
		eval("document.form." + ret_val + ".value = '';"); 
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ',';    
		}      
		//마지막에 ,를 없애기 위함      
		if (tempText != "")       
	        tempText = tempText.substr(0, tempText.length - 1);   	
		     
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
	}