/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0364.js
*@FileTitle : Multiple Repair CNTR by Area
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
	 * @class ESD_EAS_0364 : 예)Multiple Repair CNTR by Area 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0364() {
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
				sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				initForm();
				break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_loc_cd":
				var param="?loc_cd="+ComGetObjValue(formObject.s_loc_cd); 
			    param+="&pgmNo=COM_ENS_061";
		        ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 780, 470, 'getLocation', '1,0,1,1,1,1,1,1,1,1,1,1', true);	
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
			case "btn_movement":
				popupMovement(sheetObjects[0]);
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
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
		
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		initControl();
		initForm();

//		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	
	function initForm(){
		var formObj = document.form;
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		formObj.reset();
		
		formObj.s_start_dt.value = ComGetDateAdd(null, "d", -90, "-");
		formObj.s_end_dt.value = ComGetDateAdd(null, "d", 0, "-");
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
	
	function initCombo(comboObj, no){

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
					style.height = GetSheetHeight(8);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);
					
					var HeadTitle = "SEQ|CNTR No.|Type/Size|Lease Term|Ownership|Entry Day|Total\nUsing Days|D/Value|No of\nCases|Total AMT\n(USD)|Location|Yard|S/P Name|No of Cases|AMT(USD)";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,		50,		daCenter,	true,	"seq",				false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"eq_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"eq_tpsz_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	true,	"lstm_cd",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"ownr_co_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	true,	"onh_dt",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daRight,	true,	"using_days",		false,          "",       dfNumber,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daRight,	true,	"dv_value",			false,          "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	true,	"ttl_no_of_cases",	false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	true,	"ttl_cost_amt",		false,          "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"loc_cd",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"yd_cd",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daLeft,		false,	"vndr_nm",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"no_of_cases",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daRight,	false,	"cost_amt",			false,          "",       dfFloat,	2,     false,       true);
					
				}
				break;
			case "sheet2":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(9);
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
					
					var HeadTitle = "SEQ|RHQ|Office|CNTR No.|Type/Size|Est No|W/O Issue\nDate|W/O No|W/O User|S/P Code|S/P Name|W/O CUR|" +
									"W/O AMT|W/O AMT(USD)|Repair Yard|Location\nCode|Location\nName|Component\nCode|" +
									"Component\nName|Damage\nCode|Damage\nName|Repair\nCode|Repair\nName|W/O Verify\nResult|vndr_cnt";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,		50,		daCenter,	false,	"seq",				false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"rhq_ofc_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"ofc_cd",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"eq_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"eq_tpsz_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		130,	daLeft,		false,	"rqst_ref_no",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"mnr_inp_dt",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"wo_no",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	false,	"wo_user",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	false,	"vndr_seq",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		140,	daLeft,		false,	"vndr_lgl_eng_nm",	false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	false,	"curr_cd",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"wo_amt",			false,          "",       dfNumber,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	false,	"chg_cost_amt",		false,          "",       dfFloat,	2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"yd_cd",			false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"eq_loc_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daLeft,		false,	"eq_loc_nm",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"eq_cmpo_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daLeft,		false,	"eq_cmpo_nm",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"eq_dmg_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daLeft,		false,	"eq_dmg_nm",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	false,	"eq_rpr_cd",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daLeft,		false,	"eq_rpr_nm",		false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daLeft,		false,	"mnr_vrfy_tp_nm",	false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	80,		daCenter,	false,	"vndr_cnt",			false,          "",       dfNumber,	0,     false,       true);
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
			    if(validateForm(sheetObj, formObj, sAction)){
	    			sheetObj.WaitImageVisible=false;
	    			ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
	    			
	    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0364GS.do",EasFrmQryString(formObj));
	    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
	    			
	    			if (backendJobKey.length > 0) {
						formObj.backendjob_key.value = backendJobKey;
						sheetObj.RequestTimeOut = 10000;
						timer = setInterval(getBackEndJobStatus, 3000);
						sheetNum = sheetObj;
					}    
			    }
				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
				
			case IBROWSEARCH:	// confirm
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESD_EAS_0364GS.do", EasFrmQryString(formObj));
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
			break;	
		case "s_end_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
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
				ComKeyOnlyNumber(obj);
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
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_vndr_seq":
				vender_change();
			break;
		}
	} 	


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		var formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				// The period cannot exceed 90 days.
				if(ComGetDaysBetween(formObj.s_start_dt, formObj.s_end_dt) < 0){
					ComShowMessage(msgs['EAS90027']);
					formObj.s_end_dt.value = ComGetDateAdd(formObj.s_start_dt.value, "d", +30, "-");
	                ComSetFocus(formObj.s_start_dt);
	                return false;
				} else if(ComGetDaysBetween(formObj.s_start_dt, formObj.s_end_dt) > 90){
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
    	
    	var formObject = document.form;
    	
    	formObject.s_eq_no.value = sheetObj.CellValue(Row, "eq_no");
    	formObject.s_param_loc_cd.value = sheetObj.CellValue(Row, "loc_cd");
    	doActionIBSheet(sheetObjects[1],formObject,IBROWSEARCH);
		return;
    }
    
	 /*
	 * Location 정보를 가져오는 함수
	 */
	function getLocation(rowArray){
		var formObject = document.form;
		var colArray = rowArray[0]; 
		formObject.s_loc_cd.value= colArray[3].substring(0,5);
        formObject.s_yd_cd.value = colArray[3].substring(5); 
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
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetNum.GetSearchXml("ESD_EAS_0364GS.do", FormQueryString(formObj));
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
		var sXml = sheetNum.GetSearchXml("ESD_EAS_0364GS.do", FormQueryString(form));
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
	 * VNDR SEQ에 따른 BACKGROUND COLOR 구분 재설정
	 */
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		// 조회 데이터가 있는 경우
		if(sheetObj.TotalRows > 0){
			// vendor가 2개 이상 존재 하는 경우
			if(sheetObj.FindText("vndr_cnt", "2") > -1){
				var startRow = sheetObj.HeaderRows;
				var lastRow = sheetObj.HeaderRows + sheetObj.TotalRows;
				
				// bgcolor 설정
				var BG_COLORS = new Array();
				BG_COLORS[0] = sheetObj.RgbColor(255, 255, 0);
				BG_COLORS[1] = sheetObj.RgbColor(0, 255, 255);
				BG_COLORS[2] = sheetObj.RgbColor(0, 255, 0);
				BG_COLORS[3] = sheetObj.RgbColor(255, 0, 255);

				for(i=startRow; i<lastRow; i++){
					
					
					var tmpCnt = (sheetObj.CellValue(i, "vndr_cnt") - 1) % 4;
					
					sheetObj.CellBackColor(i, "vndr_seq") = BG_COLORS[tmpCnt];
					sheetObj.CellBackColor(i, "vndr_lgl_eng_nm") = BG_COLORS[tmpCnt];
				}
			}
		}
    }
	
	/**
	 * sheet1의 선택된 Row의 CNTR Movement 팝업 오픈
	 * @param sheetObj
	 */
	function popupMovement(sheetObj){
		var row = sheetObj.SelectRow;
		var cntrNo = sheetObj.CellValue(row, "eq_no");
		var tpSz = sheetObj.CellValue(row, "eq_tpsz_cd");
		var fromDate = document.form.s_start_dt.value;
		var toDate = document.form.s_end_dt.value;

		fromDate = ComGetDateAdd(fromDate, "M", -12, "-", true);

		// 데이터가 없는(-1)경우, 선택된 row가 없을(0) 경우
		if(row < 1){
			ComShowCodeMessage("COM12176");
			return;
		} else {
            
            ComOpenWindowCenter("/hanjin/EES_CTM_0408.do?" +
                                "p_cntrno=" 	+ cntrNo.substring(0,10) + "&" +
                                "check_digit=" 	+ cntrNo.substring(10,11) + "&" +
                                "ctnr_tpsz_cd=" + tpSz + "&" +
                                "p_date1=" 		+ fromDate + "&" +
                                "p_date2=" 		+ toDate + "&" +
                                "pop_mode=1"
                                ,"EES_CTM_0408", 1020, 682);
            return;
		}
	}
