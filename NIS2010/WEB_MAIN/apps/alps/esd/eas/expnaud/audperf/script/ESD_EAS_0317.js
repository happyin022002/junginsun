/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_EAS_0317.js
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015-02-02 9014613 			1.0	최초 생성
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
     * @class ESD_EAS_0317 : ESD_EAS_0317 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0317() {
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
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  		// 1-1. jsp에서 선언된 sheet Object들을 배열화 한다.(sheet Object가 여러개일수 있으므로)
  	}
    	
  	/**
  	 * Sheet 기본 설정 및 초기화 
  	 * body 태그의 onLoad 이벤트핸들러 구현
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	 */
  	function loadPage() {
  		var frm = document.form;
  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			ComConfigSheetEas(sheetObjects[i]);

  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
		// IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
  		
  		//RHQ 콤보 리스트 조회
		frm.s_rhq_ofc_cd.RemoveAll();
		frm.f_cmd.value = COMMAND02;
		var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");		
		frm.s_rhq_ofc_cd.InsertItem(0, "", "");
		doActionIBCombo(frm.s_rhq_ofc_cd);
		doActionIBCombo(frm.s_cgo_tp_cd);
		doActionIBCombo(frm.s_lgs_cost_cd);
		
		getEasIbComboList(frm.s_rto_tp_cd , 'A|M|Y' , 'All|Last Month|Over Last Year' , '');  // 금액 체크 범위 조건 
		frm.s_rto_tp_cd.code2 = 'A';
  		initControl();
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
  					var cnt = 0;
  					
  					style.height = GetSheetHeight(20) ; //420;
  					
  					//전체 너비 설정
  					//SheetWidth = 785;
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msAll;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(15, 1, 0, false);
  		
  					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable, ColumnMove, AllCheckEnable, UserResize, RowMove, Head3D]
  					InitHeadMode(true, true, false, true, false, false)
 					
  					var HeadTitle1 = "|Seq|RHQ|Office|Month|TES|TES|TRS|TRS|M&R|M&R|PSO|PSO||";
  					var HeadTitle2 = "|Seq|RHQ|Office|Month|Invoice QTY|Amount(USD)|Invoice QTY|Amount(USD)|Invoice QTY|Amount(USD)|Invoice QTY|Amount(USD)||";
  					  					
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);  					
  		
  					//데이터속성	[   ROW,   COL,	DATATYPE, 	  WIDTH,	DATAALIGN,  COLMERGE,	SAVENAME,   	   KEYFIELD,	CALCULOGIC,   DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty( 0, cnt++,	dtHiddenStatus,	 40,	daCenter,	   false,	"ibflag");
  					InitDataProperty( 0, cnt++, dtDataSeq,      	50,     daCenter,    true,    "seq"	,			false,    "",     dfNone,    		0,    	false,    	false);
  					InitDataProperty( 0, cnt++, dtData, 		 60, 	daCenter,	    true, 	"rhq_cd"       		,   false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtHidden, 		60, 	daCenter,	    true, 	"ofc_cd"        , false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 70, 	daCenter,	    true, 	"gl_mon", 			false, 	"", 			dfDateYm, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		85, 	daRight,	    false, 	"inv_tes_qty"    		, 	false, 	"", 			dfNullInteger, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		 100, 	daRight,	    false, 	"inv_tes_amt"      	, 	false, 	"", 			dfNullFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		85, 	daRight,	   false, 	"inv_trs_qty"      ,false, 	"", 			dfNullInteger, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		100, 	daRight ,	   false, 	"inv_trs_amt"      ,false, 	"", 			dfNullFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		 85, 	daRight,	   false, 	"inv_mnr_qty"   			  , false, 	"", 			dfNullInteger, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		 100, 	daRight,	   false, 	"inv_mnr_amt"       	    ,   false, 	"", 			dfNullFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		85, 	daRight  ,	   false, 	"inv_pso_qty"      		,   false, 	"", 			dfNullInteger, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtAutoSum, 		100, 	daRight,	   false, 	"inv_pso_amt"        	,   false, 	"", 			dfNullFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtHidden, 		90, 	daCenter,	   false, 	"stnd_ym"    	,			false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtHidden, 		70, 	daCenter,	   false, 	"ym_tp_cd"  	, 		false, 	"", 			dfNone, 			0, 		false, 		false );
  					
  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 var sheetObject = sheetObjects[0];
  		 var formObject = document.form;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  	
  			switch(srcName) {
  				case "btns_calendar1":  					
	  				var cal = new ComCalendar();
	  				cal.setDisplayType('month');
	  				cal.select(formObject.s_fm_ym,'yyyy-MM');
  					break;
  				case "btns_calendar2":  					
	  				var cal = new ComCalendar();
	  				cal.setDisplayType('month');
	  				cal.select(formObject.s_to_ym,'yyyy-MM');  					
  					break;  				
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					formObject.reset();
  					formObject.s_rhq_ofc_cd.Index=0;
  					//doActionIBCombo(formObject.s_rhq_ofc_cd);
  					doActionIBCombo(formObject.s_cgo_tp_cd);
  					doActionIBCombo(formObject.s_lgs_cost_cd);
  					sheetObjects[0].RemoveAll(); 
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
 // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var frm = document.form;
    	var sheetObj = sheetObjects[0];
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
		case "s_cgo_tp_cd":    
			searchCommonCombo("CD00748",frm.s_cgo_tp_cd);
			frm.s_cgo_tp_cd.InsertItem(0, "", "");
		break;  
		case "s_lgs_cost_cd":    
			frm.s_lgs_cost_cd.RemoveAll();
			frm.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0317GS.do", FormQueryString(frm));
			ComXml2ComboItem(sXml, frm.s_lgs_cost_cd, "lgs_cost_cd", "lgs_cost_cd|lgs_cost_nm|mdl_cd|cgo_tp_cd");	
			frm.s_lgs_cost_cd.InsertItem(0, "", "");
			frm.s_lgs_cost_cd.ValidChar(2,0);
		break;
        }
    }
  	
	// 공통테이블에 등록된 코드값을 조회 한다.    
	function searchCommonCombo(codeKey,comboObj){
		var frm = document.form;
		var sheetObj = sheetObjects[1];
			frm.f_cmd.value = SEARCH01;
			// 공통 테이블에서 조회할 키
			frm.code_key.value = codeKey
//			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
//			sheetObj.WaitImageVisible = true;
			ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
	}
    
    function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){
    	sheetObjects[0].RemoveAll();
    	if(ComIsEmpty(ComGetObjValue(comboObj))){
    		sheetObjects[0].ColHidden("ofc_cd") = true;
    		document.form.s_rhq_yn.value="Y";
    	} else {
    		sheetObjects[0].ColHidden("ofc_cd") = false;
    		document.form.s_rhq_yn.value="N";
    	}
		doActionIBCombo(document.form.s_rhq_ofc_cd); // RHQ
	}	 
	
	function s_ofc_cd_OnChange(comboObj,Index_Code, Text){
		//doActionIBCombo(document.form.s_ofc_cd); // Office
		
	}
    
  	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListenerForm  ( 'click'     , 'obj_click'      , document.form ); 
	}
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "float":
	        	ComKeyOnlyNumber(event.srcElement, "-.");
	        break;
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {			
			case "s_fm_ym":
			case "s_to_ym":
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
		case "s_fm_ym":
			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ym");
			break;	
		case "s_to_ym":
			obj.value = ComGetMaskedValue(obj,   "ym");
			break;	
		}
	}
	/**
	 * HTML Control의 onclick이벤트 처리<br>
	 **/
	function obj_click(){
		var obj = event.srcElement;
		switch(obj.name) {	
			case "s_compare_mon_radio":
				//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
		}
	}
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_ym":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_ym":
			ComClearSeparator(obj);
			obj.select();
			break;
		}
	}
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		var formObj = document.form;
		if(obj.value.length >= 8) {
			formObj.s_to_ym.value = ComGetDateAdd(obj.value,"D", 30, "-");
		}else{
			formObj.s_to_ym.value = "";
		}
	}
  	
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  	
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
		   case IBSEARCH:	  //조회
			   	if(!validateForm(sheetObj,formObj,sAction)) {
 					return false;
 				}
				formObj.f_cmd.value = SEARCHLIST01;
				if(formObj.s_compare_mon_radio.checked){
					formObj.s_compare_mon.value = "3";
				} else {
					formObj.s_compare_mon.value = "1";
				}
				sheetObj.DoSearch("ESD_EAS_0317GS.do", FormQueryString(formObj));
				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				//sheetObj.SpeedDown2Excel(true);
  				sheetObj.Down2Excel(-1, false, false, true);
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		
  		if(!ComChkValid(formObj)) return false;
  		switch(sAction) {
		case IBSEARCH:      //조회			
			if (ComGetDaysBetween(formObj.s_to_ym.value, ComGetDateAdd(formObj.s_fm_ym.value, "M", 3)) < 0) {
                ComShowCodeMessage("COM12133", "The start and end date", "3 Month", "less");    // {?msg1} must be {?msg3} than {?msg2}.
                return false;
            }	
			break;
    	}
		return true;
  		
  		
  		
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
		sParam[0] = "s_ym="+sheetObj.CellValue(Row, "stnd_ym");
		sParam[1] = "s_ofc_cd="+sheetObj.CellValue(Row, "ofc_cd");
		sParam[2] = "s_vndr_seq="+sheetObj.CellValue(Row, "vndr_no");
		sParam[3] = "s_rhq_yn="+formObject.s_rhq_yn.value;
		
		
        ComOpenWindowCenter("ESD_EAS_0318.do?"+sParam.join("&"), "winSpDtl", "1030", "560", true, "no");
		
		return;
    }
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		var formObj = document.form;
  		var txtRtoTpCd = formObj.s_rto_tp_cd.Code;
  		var txtRto = formObj.s_rto.value;
  		for (var i = sheetObj.HeaderRows ; i< sheetObj.RowCount + sheetObj.HeaderRows ; i++) {
  			var fColor = sheetObj.RgbColor(255, 0, 0);
  			if ( formObj.s_compare_mon_radio.checked && sheetObj.CellValue(i, "ym_tp_cd") == '1' && txtRto.length > 0 ) {
  				setAmtHighLight(sheetObj, formObj, "inv_tes_amt", txtRto, i, txtRtoTpCd);
  				setAmtHighLight(sheetObj, formObj, "inv_trs_amt", txtRto, i, txtRtoTpCd);
  				setAmtHighLight(sheetObj, formObj, "inv_mnr_amt", txtRto, i, txtRtoTpCd);
  				setAmtHighLight(sheetObj, formObj, "inv_pso_amt", txtRto, i, txtRtoTpCd);
  			}
  			if( formObj.s_compare_mon_radio.checked ) {
	  			if ( ComIsNumber( Math.ceil((i+1.9)/3)/2) ) {
  	  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(226,245,240);
  	  			}
  			}
  		}
  	}

  	function sheet1_OnClick(sheetObj, Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "blahblah" ) { 
  		
  		}
  	}
  	
	/* 개발자 작업  끝 */