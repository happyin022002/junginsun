/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0371.js
*@FileTitle : Batch Result Inquiry
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
	 * @class ESD_EAS_0371 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0371() {
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
    			
			case "btn_inv_detail" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openTesInvoiceDetail();
       			}else{
					ComShowCodeMessage("COM12177");
				}
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
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
 		//html컨트롤 이벤트초기화
 		initControl();
		initSet(false);
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
	function initControl() {
		axon_event.addListenerForm  ( 'change' , 'obj_change', document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
	}
	
	function obj_keypress(){
		var srcName = event.srcElement.getAttribute("name");
		var srcValue = event.srcElement.getAttribute("value");
		
		switch(event.srcElement.dataformat){
			case "engup":		//영문대문자
				ComKeyOnlyAlphabet('upper');
			break;
			
			case "engupnum":	//숫자+영문대분자 입력하기
				ComKeyOnlyAlphabet('uppernum');
			break;
			
			case "engnum":		//숫자+영문대소 입력하기
				ComKeyOnlyAlphabet('num'); 
			break;
			case "float":       //실수 입력하기
				ComKeyOnlyNumber(event.srcElement, "-.");
			break;			
			
			case "engupcomma":	//영문대문자+Comma
				ComKeyOnlyAlphabet('upper', '44');
			break;
			
			case "engupnumcomma":	//숫자+영문대분자+Comma
				ComKeyOnlyAlphabet('upper', '44|48|49|50|51|52|53|54|55|56|57');
			break;
			default:
		}
	}
	
  	function initSet(flg) {
  		var formObj = document.form;
  		ComSetObjValue(formObj.s_from_inv_cfm_dt, ComGetDateAdd(null, "d", -30, "-"));
  		ComSetObjValue(formObj.s_to_inv_cfm_dt, ComGetNowInfo());
  		setloginOfcCd();
  		if(flg){
  			ComSetObjValue(formObj.s_bat_rslt_cd, "");
  		}
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
					style.height = GetSheetHeight(20);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 10, 100);
					
					var HeadTitle  = "|Seq.|RHQ|Inv\nOffice|Cost\nOffice|Inv\nType|Yard|S/P No.|Inv No.|Issued\nDate|Confirmed\nDate|VVD|I/O|Period|Period|Result (3Months)|Result (3Months)|Estimation\nVolume|expn_aud_sts_cd";
					var HeadTitle2 = "|Seq.|RHQ|Inv\nOffice|Cost\nOffice|Inv\nType|Yard|S/P No.|Inv No.|Issued\nDate|Confirmed\nDate|VVD|I/O|From|To|Vol/Voy|Amount|Estimation\nVolume|expn_aud_sts_cd";
					
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	10,		daCenter,	false,	"ibflag",			false,    		"",       dfNone,    0,     false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtDataSeq,	40,	 	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++, dtData,		44,		daCenter,	true,	"rhq_cd",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		44,		daCenter,	true,	"inv_ofc_cd",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		44,		daCenter,	true,	"cost_ofc_cd",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		60,		daLeft,		true,	"tml_inv_tp_cd",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		56,		daCenter,	true,	"yd_cd",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		50,		daCenter,	true,	"vndr_seq",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		80,		daLeft,		true,	"inv_no",				false,          "",       dfNone,    0,		false,       false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"iss_dt",				false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"inv_cfm_dt",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,		daLeft,		true,	"vvd",					false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		30,		daCenter,	true,	"io_bnd_cd",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"fm_prd_dt",			false,          "",       dfDateYmd, 0,     false,       false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"to_prd_dt",			false,          "",       dfDateYmd, 0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		55,		daLeft,		true,	"bat_vol_rslt_cd",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		55,		daLeft,		true,	"bat_amt_rslt_cd",		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtCombo,		55,		daLeft,		true,	"bat_estm_vol_rslt_cd",	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,	true,	"expn_aud_sts_cd",		false,          "",       dfNone,    0,     false,       true);
					
					InitDataCombo(0, "tml_inv_tp_cd",  "Terminal|Storage|On-dock|Off-dock", "TM|ST|ON|OF");
					InitDataCombo(0, "bat_vol_rslt_cd",  "Success|Fail", "S|F");
					InitDataCombo(0, "bat_amt_rslt_cd",  "Success|Fail", "S|F");
					InitDataCombo(0, "bat_estm_vol_rslt_cd",  "Success|Fail", "S|F");
					
					HeadRowHeight = 25;
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
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch("ESD_EAS_0371GS.do", EasFrmQryString(formObj));
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
			
			case "s_bat_rslt_cd":
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 100;
					setComboData(comboObj);
				}
			break;
		}
	}
	
	function setComboData(comboObj, param){ 
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
		    	
			case "s_bat_rslt_cd":
				comboObj.InsertItem(cnt++, "", "");
				comboObj.InsertItem(cnt++, "Success", "S");
				comboObj.InsertItem(cnt++, "Fail", "F");
				break;
		}
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
	
    function sheet1_OnDblClick(sheetObj, Row, Col){
    	openTesInvoiceDetail();
    }
	
	function openTesInvoiceDetail(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var popupHeight = 640;
		var sUrl = "";
		
		var tml_inv_tp_cd = sheetObj.CellValue(sheetObj.SelectRow, "tml_inv_tp_cd");
		if( tml_inv_tp_cd == "TM")
			sUrl = "/hanjin/ESD_EAS_0377.do";
		else if( tml_inv_tp_cd == "OF")
			sUrl = "/hanjin/ESD_EAS_0373.do";
		else if( tml_inv_tp_cd == "ST")
			sUrl = "/hanjin/ESD_EAS_0375.do";
		else if( tml_inv_tp_cd == "ON"){
			sUrl = "/hanjin/ESD_EAS_0379.do";
			popupHeight = 670;
		}		
		
		var sParam = "?s_inv_ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow, "inv_ofc_cd")
	+"&s_tml_inv_tp_cd="+sheetObj.CellValue(sheetObj.SelectRow, "tml_inv_tp_cd")
	+"&s_yd_cd="+sheetObj.CellValue(sheetObj.SelectRow, "yd_cd")
	+"&s_vndr_seq="+sheetObj.CellValue(sheetObj.SelectRow, "vndr_seq")
	+"&s_inv_no="+sheetObj.CellValue(sheetObj.SelectRow, "inv_no")
	+"&s_vvd="+sheetObj.CellValue(sheetObj.SelectRow, "vvd")
	+"&s_io_bnd_cd="+sheetObj.CellValue(sheetObj.SelectRow, "io_bnd_cd")
	+"&s_fm_prd_dt="+sheetObj.CellValue(sheetObj.SelectRow, "fm_prd_dt")
	+"&s_to_prd_dt="+sheetObj.CellValue(sheetObj.SelectRow, "to_prd_dt")
	+"&s_expn_aud_sts_cd="+sheetObj.CellValue(sheetObj.SelectRow, "expn_aud_sts_cd")
	;
		sUrl += sParam;
		var winName = "Audit Detail I";
	   	var features = "scroll:no;status:no;resizable=yes;help:no;dialogWidth:940px;dialogHeight:"+popupHeight+"px";			
	   	ComOpenWindow(sUrl, winName, features, true);		
	}

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