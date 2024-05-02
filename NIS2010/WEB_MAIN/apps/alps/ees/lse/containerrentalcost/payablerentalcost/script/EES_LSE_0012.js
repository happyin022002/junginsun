/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0012.js
*@FileTitle : Rental payable invoice inquiry and Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 진준성
*@LastVersion : 1.0
*
* 2009.10.08 진준성
* 1.0 Creation
*
* 2010.03.15 노정용
* 1.1 Modification
* Operation Charge 처리를 위하여 GRID 에 chg_tp 추가
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
     * @class EES_LSE_0012 : EES_LSE_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0012() {
    	this.processButtonClick = processButtonClick;
    	this.setSheetObject     = setSheetObject;
    	this.setComboObject     = setComboObject;
    	this.loadPage           = loadPage;
    	this.initSheet          = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet    = doActionIBSheet;
    	this.setTabObject       = setTabObject;
    	this.validateForm       = validateForm;
    	this.obj_change         = obj_change;
    	this.obj_keypress       = obj_keypress;
    	this.validateForm       = validateForm;
    	this.loc_tp_OnChange    = loc_tp_OnChange;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo1_OnBlur 			= combo1_OnBlur;
    	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
    }

    /* 개발자 작업	*/
  //공통전역변수
  var sheetObjects = new Array();
  var sheetCnt = 0;

  //Combo Object Array
  var comboObjects = new Array();
  var comboCnt = 0;

  var now  ;
  var year ;
  var mon  ;

  var arrTpSz  = new Array();
  var arrTpSz2 = new Array();

  //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  function initControl() {
  	var formObj = document.form;
  	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
  	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
  	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
  	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
  	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
  	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
  }

  // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  function processButtonClick(){
  	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  	var sheetObject1 = sheetObjects[0];
  	/*******************************************************/
  	var formObject = document.form;

  	try {
  		var srcObj  = window.event.srcElement;
  		var srcName = window.event.srcElement.getAttribute("name");

  		switch(srcName) {

  		case "btn_Retrieve":
  			if ( srcObj.style.filter == "" ) {
  				sheetObject1.RemoveAll();
  				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			}
  			break;
  		case "btn_Save":
  			if ( srcObj.style.filter == "" ) {
  			    doActionIBSheet(sheetObjects[0], document.form,IBSAVE);
  			}
  		break;
  		case "btn_New":
  			sheetObject1.RemoveAll();
  			formObject.search_tp[0].selected = true;

  			formObject.cost_st_month.value    = "";
  			formObject.cost_ed_month.value    = "";
  			formObject.invoice_st_month.value = "";
  			formObject.invoice_ed_month.value = "";
  			formObject.invoice_no.value       = "";
  			formObject.register_no.value      = "";
  			formObject.invoice_user.value     = "";

  	        var OBJ1 = document.getElementById("fixLayer1");
			OBJ1.style.visibility = "visible";
			var OBJ2 = document.getElementById("fixLayer2");
			OBJ2.style.visibility = "hidden";
            var OBJ3 = document.getElementById("fixLayer3");
			OBJ3.style.visibility = "hidden";
			var OBJ4 = document.getElementById("fixLayer4");
			OBJ4.style.visibility = "hidden";

            document.form.cost_st_month.value = year + "-" + mon;
		    document.form.cost_ed_month.value = year + "-" + mon;
		    //formObject.cost_st_month.focus();

			formObject.vndr_seq.value = "";
			formObject.vndr_nm.value  = "";

			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
		        comboObjects[0].CheckIndex(i)=false;
			}
			comboObjects[0].CheckIndex(0) = true;
		    formObject.invoice_user.value = "";



  			break;

  		case "btns_calendar1":
  			if ( srcObj.style.filter == "" ) {
  				var cal = new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.cost_st_month, "yyyy-MM");
  			}
  			break;

  		case "btns_calendar2":
  			if ( srcObj.style.filter == "" ) {
  				var cal = new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.cost_ed_month, "yyyy-MM");
  			}
  			break;

  		case "btns_calendar3":
  			if ( srcObj.style.filter == "" ) {
  				var cal = new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.invoice_st_month, "yyyy-MM");
  			}
  			break;
  		case "btns_calendar4":
  			if ( srcObj.style.filter == "" ) {
  				var cal = new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.invoice_ed_month, "yyyy-MM");
  			}
  			break;

  		case "btns_search2":     // lessor
  		if ( srcObj.style.filter == "" ) {
  			openPopup("2");
  		}
  		break;

  		} // end switch
  	}catch(e) {
  		if( e == "[object Error]") {
  			ComShowMessage(OBJECT_ERROR);
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
  * IBMultiCombo Object를 배열로 등록
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

  	for(i=0;i<sheetObjects.length;i++){

  		//khlee-시작 환경 설정 함수 이름 변경
  		ComConfigSheet (sheetObjects[i] );

  		initSheet(sheetObjects[i],i+1);
  		//khlee-마지막 환경 설정 함수 추가
  		ComEndConfigSheet(sheetObjects[i]);
  	}

  	initControl();

  	/* IBMultiCombo 초기화 */
  	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
  		initCombo(comboObjects[k], k+1);
  	}
  }

  function sheet1_OnLoadFinish(){
  	/* IBMulti Combo Item Setting */
  	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);

	//ComBtnDisable("btn_Save");
  	var OBJ = document.getElementById("fixLayer1");
  	OBJ.style.visibility = "visible";
  	comboObjects[0].CheckIndex(0) = true;

    now  = new Date();
    year = now.getFullYear();
    mon  = (now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);

    document.form.cost_st_month.value = year + "-" + mon;
    document.form.cost_ed_month.value = year + "-" + mon;
    //document.form.cost_st_month.focus();
  }
  /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
  function initSheet(sheetObj,sheetNo) {

  	var cnt = 0;
  	var sheetid = sheetObj.id;

  	switch(sheetid) {
  	case "sheet1":
  		with (sheetObj) {

  			// 높이 설정
  			style.height = 400;
  			//전체 너비 설정
  			SheetWidth = 984;//mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
		    MergeSheet = msPrevColumnMerge + msHeaderOnly;
 			//MergeSheet = msHeaderOnly;
 			//전체Edit 허용 여부 [선택, Default false]
  			Editable = true;
 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo( 1, 1, 15, 100);
  			var HeadTitle   = "sta|SEQ|A/P\nI/F|Lessor|Pay Vendor|Term|Invoice No|Register No|Issue Date|Receive Date|Cost Month|Payable AMT|AMT|Credit AMT|INV Month|INV Credit DT|User Name|Cancel|inv_sts_cd|if_flg|if_err_rsn|";

  			var headCount   = ComCountHeadTitle(HeadTitle);
  			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  			InitColumnInfo(headCount, 0, 0, true);

  			// 해더에서 처리할 수 있는 각종 기능을 설정한다
  			InitHeadMode(true, true, false, true, false,false)

  			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  			InitHeadRow(0, HeadTitle , true);


  			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  			InitDataProperty(0, cnt++ , dtHiddenStatus,  0,  daCenter,  true,  "ibflag");
  			InitDataProperty(0, cnt++ , dtDataSeq,      40,  daCenter,  true,  "seq",               false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,        160,  daLeft,    true,  "remark",            false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,         60,  daCenter,  true,  "vndr_seq",          false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,         70,  daCenter,  true,  "pay_vndr_seq",      false,  "",  dfNone ,0,false);

  			InitDataProperty(0, cnt++ , dtData,         50,  daCenter,  true,  "lstm_cd",           false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,         90,  daCenter,  true,  "inv_no",            false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  true,  "if_rgst_no",        false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,         90,  daCenter,  true,  "inv_iss_dt",        false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  true,  "inv_rcv_dt",        false,  "",  dfNone ,0,false);

  			InitDataProperty(0, cnt++ , dtData,         90,  daCenter,  true,  "chg_cost_yrmon",    false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,        100,  daRight,   true,  "pay_rntl_cost_amt", false,  "",  dfFloat,2,false);
  			InitDataProperty(0, cnt++ , dtData,        100,  daRight,   true,  "ttl_cost_amt",      false,  "",  dfFloat,2,false);
  			InitDataProperty(0, cnt++ , dtData,        100,  daRight,   true,  "cr_ttl_amt",        false,  "",  dfFloat,2,false);
  			InitDataProperty(0, cnt++ , dtData,         80,  daCenter,  true,  "inv_eff_yrmon",     false,  "",  dfNone ,0,false);

  			InitDataProperty(0, cnt++ , dtData,         85,  daCenter,  true,  "apro_dt",           false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtData,         80,  daCenter,  true,  "apro_usr_id",       false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtDelCheck,     35,  daCenter,  true,  "cancel_flag",       false,  "",  dfNone ,0,true );
  			InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter,  true,  "inv_sts_cd",        false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter,  true,  "if_flg",            false,  "",  dfNone ,0,false);

  			InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter,  true,  "if_err_rsn",        false,  "",  dfNone ,0,false);
  			InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter,  true,  "chg_tp",            false,  "",  dfNone ,0,false);

  			SelectBackColor = LSE_SELECT_BACK_COLOR;
 			//FrozenCols = 5;

  		}
  		break;

  	}
  }

  //Sheet관련 프로세스 처리
  function doActionIBSheet(sheetObj,formObj,sAction) {
  	switch(sAction) {
	  	case IBSEARCH:      //조회
		  	if(validateForm(sheetObj,formObj,sAction)){
		  		if (sheetObj.id == "sheet1"){
		  			formObj.f_cmd.value = SEARCH;

		  			sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
		  			sheetObj.DoSearch("EES_LSE_0012GS.do",FormQueryString(formObj));

		  			for(var i = 0 ; i <= sheetObjects[0].lastRow; i++){
		  				/*if(sheetObjects[0].CellValue( i , "inv_sts_cd") == "C" ){
		  					sheetObjects[0].CellEditable(i, "cancel_flag") = true;
		  				}else{
		  					sheetObjects[0].CellEditable(i, "cancel_flag") = false;
		  				}*/

		  				if(sheetObjects[0].CellValue( i , "inv_sts_cd") == "C" ||  sheetObjects[0].CellValue(i ,"inv_sts_cd") == "G" ||
		  				   sheetObjects[0].CellValue(i ,"inv_sts_cd") == "B" || sheetObjects[0].CellValue(i ,"inv_sts_cd") == "X"){
		  					sheetObjects[0].CellEditable(i, "cancel_flag") = true;
		  				}else if(sheetObjects[0].CellValue( i , "inv_sts_cd") == "P" ||  sheetObjects[0].CellValue(i ,"inv_sts_cd") == "E" ){
		  					if(sheetObjects[0].CellValue(i ,"if_flg") == "E" ){
		  						sheetObjects[0].CellEditable(i, "cancel_flag") = true;
		  					}else if( sheetObjects[0].CellValue(i ,"if_flg") == "Y" ){
		  						sheetObjects[0].CellEditable(i, "cancel_flag") = false;
		  					}else{
		  						sheetObjects[0].CellEditable(i, "cancel_flag") = false;
		  					}
		  				}else{
		  					sheetObjects[0].CellEditable(i, "cancel_flag") = false;
		  				}
		  			}
		  			ComOpenWait(false);
		  		}
		  	}
		  	break;

	  	case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				if ( sheetObj.id == "sheet1") {
					formObj.f_cmd.value = MULTI;
					var sParam = sheetObj.GetSaveString();
					sParam += "&" + FormQueryString(formObj);
					ComOpenWait(true);
					var sXml   = sheetObj.GetSaveXml("EES_LSE_0012GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}
			}
			break;


	  	case IBSEARCH_ASYNC03:
	  		/* Lease Term Form Combo Item Setting */
	  		ComSetObjValue(formObj.f_cmd, SEARCH01);
	  		sheetObj.WaitImageVisible = false;
	  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

	  		if ( sXml != "" ) {
	  			comboObjects[0].InsertItem(0 , 'ALL','ALL');
	  			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
	  		}
	  		vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");

	  		break;

	  	case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
		  	if ( validateForm(sheetObj, formObj, sAction) ) {
		  		var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		  		sheetObj.WaitImageVisible = false;
		  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);

		  		if ( sXml != "" ) {
		  			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
		  				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
		  				//ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
		  				ComSetFocus(formObj.vndr_nm);
		  			} else {
		  				ComShowCodeMessage("LSE01019");
		  				formObj.vndr_seq.value = "";
		  				formObj.vndr_nm.value  = "";
		  				ComSetFocus(formObj.vndr_seq);
		  			}
		  		} else {
		  			ComShowCodeMessage("LSE01019");
		  			formObj.vndr_seq.value = "";
		  			formObj.vndr_nm.value  = "";
		  			ComSetFocus(formObj.vndr_seq);
		  		}
		  	}
		  	break;


  	}
  }

  /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
  function validateForm(sheetObj,formObj,sAction){
  	with(sheetObj){
  		with(formObj){
  			switch(sAction) {
  			case IBSEARCH:
  			if(document.form.search_tp.value == "01"  ){
  				var costStMonth = formObj.cost_st_month.value;
  				var costEdMonth = formObj.cost_ed_month.value;
  				if ( costStMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.cost_st_month);
  					return false;
  					break;
  				}
  				if ( costEdMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.cost_ed_month);
  					return false;
  					break;
  				}
  			}else if(document.form.search_tp.value == "02"  ){
  				var invoiceStMonth = formObj.invoice_st_month.value;
  				var invoiceEdMonth = formObj.invoice_ed_month.value;
  				if ( invoiceStMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.invoice_st_month);
  					return false;
  					break;
  				}
  				if ( invoiceEdMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.invoice_ed_month);
  					return false;
  					break;
  				}
  			}else if(document.form.search_tp.value == "03"  ){
  				if ( formObj.invoice_no.value == "" ) {
  					ComShowCodeMessage("LSE01104");
  					ComSetFocus(formObj.invoice_no);
  					return false;
  					break;
  				}
  			}else if(document.form.search_tp.value == "04"  ){
  				if ( formObj.register_no.value == "" ) {
  					ComShowCodeMessage("LSE01105");
  					ComSetFocus(formObj.register_no);
  					return false;
  					break;
  				}
  			}
  			break;
  			case IBSAVE:
  			    if(sheetObjects[0].RowCount <= 0){
  			    	ComShowCodeMessage("LSE01048");
  			    	return false;
  					break;
  			    }else{
  			    	if(sheetObjects[0].CheckedRows("cancel_flag") <= 0){
  			    		ComShowCodeMessage("LSE01045");
  			    		return false;
  	  					break;
  			    	}
  			    }
  			break;

  			}
  		}
  	}
  	return true;
  }


  /**
  * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
  */
  function obj_blur(){
  	var obj = event.srcElement;
  	switch(obj.name){

  	case "btns_calendar3":
  		//숫자이면서 천단위 구분을 하지 않는다.
  		ComChkObjValid(obj);
  		break;

  	case "vndr_seq":
  		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
  			document.form.vndr_nm.value = "";
  			//document.form.abbr_nm.value = "";
  		}
  		break;
  	default:
  		//Validation 전체 체크(길이,format,최대,최소 등등)
  	break;
  	}
  }

  /**
  * 콤보 초기설정값, 헤더 정의
  * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
  function initCombo(comboObj, comboNo) {
  	switch(comboObj.id) {
  	case "combo1":
  		with(comboObj) {
  			DropHeight = 200;
  			MultiSelect = true;
  			//MaxSelect = 1;
  			MultiSeparator = ",";
  			Style = 0;
  			UseAutoComplete = true;
  			//영문(대)+특수문자,숫자 - TP/SZ
  			ValidChar(2,3);
  		}
  		break;
  	}
  }

  /**
   * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
   * @return
   */
  function combo1_OnCheckClick(comboObj, index, code) {
  	if(index==0) {
  		var bChk = comboObj.CheckIndex(index);
  		if(bChk){
  			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
  				comboObj.CheckIndex(i) = false;
  			}
  		}
  	} else {
  		comboObj.CheckIndex(0) = false;
  	}
  }


  /**
   * combo1_OnBlur
   */
  function combo1_OnBlur(comboObj, Index_Code, Text) {
  	var formObj = document.form;
  	if( comboObj.CheckIndex(0)){
  		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
  			comboObj.CheckIndex(i) = false;
  		}
  		formObj.lstm_cd.value = "";
  	}else if(comboObj.Text == ""){
  		comboObj.CheckIndex(0) = true;
  		formObj.lstm_cd.value = "";
  	}else{
  	    formObj.lstm_cd.value = ComGetObjValue(comboObj);
  	}
  }


  /**
   * combo1_OnKeyDown
   */
  function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
      with(comboObj) {
          if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
              comboObj.Text = "";
  		  }else if(KeyCode == 13){
 		      sheetObjects[0].RemoveAll();
 			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  }
  	  }
  }


  /**
  * Pop-up Open 부분<br>
  * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
  * @param object 대상 Object
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  */
  function openPopup(type, Row, Col) {
  	var formObj = document.form;
  	if ( type == "2") {
  		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
  	}
  }

  /**
  * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
  * @param {arry} returnedValues Pop-up 화면의 Return value array
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  * @param 대상IBSheet의 Sheet Array index
  */
  function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
  	var sheetObj = sheetObjects[SheetIdx];
  	var formObj  = document.form;
  	if ( aryPopupData.length > 0 ) {
  		formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
  		formObj.vndr_nm.value  = aryPopupData[0][4];
  		//formObj.abbr_nm.value  = aryPopupData[0][5];
  	}
  }

  /**
  * HTML Control의 Value가 변경되었을 경우 처리한다.
  */
  function obj_change(){
  	var obj      = event.srcElement;
  	var formObj  = document.form;
  	switch(obj.name) {


  	case "vndr_seq":
  		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
  		}
  	break;

  	case "search_tp":		//Location Code

  	formObj.cost_st_month.value    = "";
  	formObj.cost_ed_month.value    = "";
  	formObj.invoice_st_month.value = "";
  	formObj.invoice_ed_month.value = "";
  	formObj.invoice_no.value       = "";
  	formObj.register_no.value      = "";

  	if(document.form.search_tp.value == "01"  ){
  		var OBJ1 = document.getElementById("fixLayer1");
  		OBJ1.style.visibility = "visible";

  		var OBJ2 = document.getElementById("fixLayer2");
  		OBJ2.style.visibility = "hidden";

  		var OBJ3 = document.getElementById("fixLayer3");
  		OBJ3.style.visibility = "hidden";

  		var OBJ4 = document.getElementById("fixLayer4");
  		OBJ4.style.visibility = "hidden";

        document.form.cost_st_month.value = year + "-" + mon;
	    document.form.cost_ed_month.value = year + "-" + mon;
  		//formObj.cost_st_month.focus();
  	}else if(document.form.search_tp.value == "02"  ){
  		var OBJ1 = document.getElementById("fixLayer1");
  		OBJ1.style.visibility = "hidden";

  		var OBJ2 = document.getElementById("fixLayer2");
  		OBJ2.style.visibility = "visible";

  		var OBJ3 = document.getElementById("fixLayer3");
  		OBJ3.style.visibility = "hidden";

  		var OBJ4 = document.getElementById("fixLayer4");
  		OBJ4.style.visibility = "hidden";

        document.form.invoice_st_month.value = year + "-" + mon;
	    document.form.invoice_ed_month.value = year + "-" + mon;
  		//formObj.invoice_st_month.focus();
  	}else if(document.form.search_tp.value == "03"  ){
  		var OBJ1 = document.getElementById("fixLayer1");
  		OBJ1.style.visibility = "hidden";

  		var OBJ2 = document.getElementById("fixLayer2");
  		OBJ2.style.visibility = "hidden";

  		var OBJ3 = document.getElementById("fixLayer3");
  		OBJ3.style.visibility = "visible";

  		var OBJ4 = document.getElementById("fixLayer4");
  		OBJ4.style.visibility = "hidden";
  		formObj.invoice_no.focus();
  	}else if(document.form.search_tp.value == "04"  ){
  		var OBJ1 = document.getElementById("fixLayer1");
  		OBJ1.style.visibility = "hidden";

  		var OBJ2 = document.getElementById("fixLayer2");
  		OBJ2.style.visibility = "hidden";

  		var OBJ3 = document.getElementById("fixLayer3");
  		OBJ3.style.visibility = "hidden";

  		var OBJ4 = document.getElementById("fixLayer4");
  		OBJ4.style.visibility = "visible";
  		formObj.register_no.focus();
  	}

  	break;

  	case "cost_st_month":
  		if ( formObj.cost_ed_month.value != null && formObj.cost_ed_month.value != "" ) {
  			checkDatePeriod( formObj.cost_st_month , formObj.cost_ed_month , "ym") ;
  		}
  	break;

  	case "cost_ed_month":
  		checkDatePeriod( formObj.cost_st_month , formObj.cost_ed_month , "ym") ;
  	break;

  	case "invoice_st_month":
  		if ( formObj.invoice_ed_month.value != null && formObj.invoice_ed_month.value != "" ) {
  			checkDatePeriod( formObj.invoice_st_month , formObj.invoice_ed_month , "ym") ;
  		}
  	break;

  	case "invoice_ed_month":
  		checkDatePeriod( formObj.invoice_st_month , formObj.invoice_ed_month , "ym") ;
   	break;

  	}
  }
  /**
  * HTML Control의 키보드 이벤트 방 포멧처리 한다.
  */
  function obj_keypress() {
  	var obj = event.srcElement;
  	switch(obj.dataformat) {
  	case "ymd":
  	case "ym":
  	case "hms":
  	case "hm":
  	case "jumin":
  	case "saupja":
  	case "int":
  		ComKeyOnlyNumber(obj);
  		break;
  	case "float":
  		ComKeyOnlyNumber(obj, "-.");
  		break;
  	case "eng":
  		ComKeyOnlyAlphabet();
  		break;
  	case "engup":
  		ComKeyOnlyAlphabet('upper');
  		break;
  	case "engdn":
  		ComKeyOnlyAlphabet('lower');
  		break;
  	default:
  		ComKeyOnlyNumber(obj);
  	break;
  	}
  }

/**
* HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
*/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){
	case "cost_st_month":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "cost_ed_month":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "invoice_st_month":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "invoice_ed_month":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value = "";
			//document.form.abbr_nm.value = "";
		}
		break;
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
	break;
	}
}

/**
* sheet1_OnSaveEnd
* 그리드 저장후 이벤트 처리
* 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if ( ErrMsg == "" ) {
		ComShowCodeMessage("LSE10001");
	} else {
		ComShowMessage(ErrMsg);
	}
}

  /**
  * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
  */
  function obj_focus(){
  	var obj  = event.srcElement;
  	if( obj.readOnly ) {
  		ComSetNextFocus(obj);
  	} else {
  		//마스크구분자 없애기
  		ComClearSeparator(event.srcElement);
  	}
  }
  /**
  * Key-Down Event 처리
  */
  function obj_keydown() {
  	var obj      = event.srcElement;
  	var vKeyCode = event.keyCode;
  	var formObj  = document.form;
  	var srcObj  = window.event.srcElement;
  	if ( vKeyCode == 13 ) {
  		switch(obj.name) {
  		    case "aaa":
  		    default :
  			    if ( srcObj.style.filter == "" ) {
  				    sheetObjects[0].RemoveAll();
  				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			    }
  	    }
  	}
  }
  /* 개발자 작업  끝 */