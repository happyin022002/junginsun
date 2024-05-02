/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4001.js
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
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
     * @class EES_DMT_4001 : EES_DMT_4001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4001() {
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

    // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var COMMON_TARIFF_CD = "common_tariff_cd";
	var USER_TARIFF_TYPE = "user_tariff_type"; 
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var USR_TRF_TP;
	var Mincount = 0 ;

	var IBSEARCH_CHECK_ROLE		= 101;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;

     	try {
     		var srcObj = window.event.srcElement;
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             	case "btns_calendar": //달력 버튼
	         		if(srcObj.style.cursor == "hand") {
	    	            var cal = new ComCalendarFromTo();
	    	            cal.select(form.fm_cfm_dt,  form.to_cfm_dt,  'yyyy-MM-dd');
	         		}
					break;
 				case "btns_multisearch1":
 					if(srcObj.style.cursor == "hand") {
	 					openPopup('s_bkg_no');
 					}
 					break;						
 				case "btns_multisearch2":
 					if(srcObj.style.cursor == "hand") {
 						openPopup('s_bl_no');
 					}
 					break;						

 				case "btns_multisearch3":
 					if(srcObj.style.cursor == "hand") {
 						openPopup('s_cntr_no');
 					}
 					break;						

             	case "btns_cust_cd":
             		openPopup('s_cust_cd');
 					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;

 				case "btn_new":
					initControl();
					date_enable();
					//EnableControls();
 					break;

 				case "btn_minimize":
                    Mincount = (Mincount+1)%2 ;
                    Minimize(Mincount);
 					break;

 				case "btn_group_billing":
 					if(ComIsBtnEnable(srcName)) {
 						openPopupWindow(sheetObject1, formObject, srcName);
 					}
 					break;

 				case "btn_billing":
 					if(ComIsBtnEnable(srcName)) {
 						openPopupWindow(sheetObject1, formObject, srcName);
 					}
 					break;

 				case "btn_downexcel":
 					if(ComIsBtnEnable(srcName)) {
 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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

	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		initButton();
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    
		initAxonControl();
		
		date_enable();
		
  		//권한을 확인한다.
    	var formObj 	= document.form;
    	var sheetObj 	= sheetObjects[0];
   		doActionIBCommon(sheetObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);  	
	}
	
    // 화면 깜빡임때문에 sheet1_OnLoadFinish 이벤트 적용
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST02);	//office
    	
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCHLIST);	//tariff_type
    }
	
	
    function condType_click() {
    	//doEnableCondObj(event.srcElement.value);
    	var formObj = document.form;
   		if (formObj.s_cont_type[0].checked ) {
   			date_enable();

    	}else if (formObj.s_cont_type[1].checked ) {
    		cntr_enable();
    	}
    }
    
    function date_enable(){
    	var formObj = document.form;

		ComEnableObject(formObj.fm_cfm_dt, true);
		ComEnableObject(formObj.to_cfm_dt, true);
    	
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_cntr_no, true);

    	formObj.fm_cfm_dt.className = "input1";
    	formObj.to_cfm_dt.className = "input1";

    	formObj.s_bkg_no.className 	= "input2";
    	formObj.s_bl_no.className		= "input2";
    	formObj.s_cntr_no.className 	= "input2";
    	
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_cntr_no, "");
    	
		ComEnableObject(formObj.btns_calendar, true);
    	
		ComEnableObject(formObj.btns_multisearch1, false);
		ComEnableObject(formObj.btns_multisearch2, false);
		ComEnableObject(formObj.btns_multisearch3, false);
		
	    //Period Date 초기화
		ComSetObjValue(formObj.today_dt, ComGetMaskedValue(formObj.today_dt.value, "ymd"));
		var temp_day = ComGetDateAdd(ComGetObjValue(formObj.today_dt), "M", -1);
		ComSetObjValue(formObj.fm_cfm_dt, temp_day);
		ComSetObjValue(formObj.to_cfm_dt, ComGetObjValue(formObj.today_dt));
		
		//cntr disabled
		formObj.s_bkg_no.readOnly = true;
		formObj.s_bl_no.readOnly = true;
		formObj.s_cntr_no.readOnly = true;
		
		//calendar
		formObj.fm_cfm_dt.readOnly = false;
		formObj.to_cfm_dt.readOnly = false;
		

    }
    function cntr_enable(){
    	var formObj = document.form;

		ComEnableObject(formObj.fm_cfm_dt, true);
		ComEnableObject(formObj.to_cfm_dt, true);
    	
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_cntr_no, true);

    	formObj.fm_cfm_dt.className = "input2";
    	formObj.to_cfm_dt.className = "input2";

    	formObj.s_bkg_no.className 	= "input1";
    	formObj.s_bl_no.className		= "input1";
    	formObj.s_cntr_no.className 	= "input1";
    	
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_cntr_no, "");
    	
		ComEnableObject(formObj.btns_calendar, false);
    	
		ComEnableObject(formObj.btns_multisearch1, true);
		ComEnableObject(formObj.btns_multisearch2, true);
		ComEnableObject(formObj.btns_multisearch3, true);
    	
		ComSetObjValue(formObj.fm_cfm_dt, "");
		ComSetObjValue(formObj.to_cfm_dt, "");
		
		//cntr disabled
		formObj.s_bkg_no.readOnly = false;
		formObj.s_bl_no.readOnly = false;
		formObj.s_cntr_no.readOnly = false;
		
		//calendar
		formObj.fm_cfm_dt.readOnly = true;
		formObj.to_cfm_dt.readOnly = true;
		
		
    }
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {  
   	    	case "office": 
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = false;	
   					SetColAlign("left|left");        
  					SetColWidth("60|250");
  					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 5;
   		    	}
   				break; 
   				
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					MultiSelect = true;
					SetColAlign("left|left");        
					SetColWidth("45|310");
					DropHeight = 160;
					ValidChar(2,2);		//영문 대문자.특수문자
   		    	}
   				break; 
   				
   	     }
   	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 380;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);

					var HeadTitle  = "||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|Office|Tariff|Payer|Payer|S/C No.|RFA No.|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|gb|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq|delt_rqst";
					var HeadTitle1  = "||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|Office|Tariff|Code|Name|S/C No.|RFA No.|Cur.|Billing AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|gb|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq|delt_rqst";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		0,		daCenter,		true,		"CheckBox");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"SEQ");
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"bkg_no",			false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		"bl_no",			false,		"",		dfNone,				0,		false,		true);
	                                                                                      		      		   		       				  		     		
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"cntr_cnt",			false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		"cntr_no",			false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"ofc_cd",			false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"dmdt_trf_cd",		false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"cust_cd",			false,		"",		dfNone,				0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,			true,		"cust_nm",			false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"sc_no",			false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"rfa_no",			false,		"",		dfNone,				0,		false,		true);
					//InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"ar_curr_cd",		false,		"",		dfNone,				0,		false,		true,	18, false,	true,	"Amount per A/R Office Currency");
					//InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"inv_amt",			false,		"",		dfFloat,			2,		false,		true,	18, false,	true,	"Amount per A/R Office Currency");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"ar_curr_cd",		false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"inv_amt",			false,		"",		dfFloat,			2,		false,		true);
				
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"bzc_trf_curr_cd",	false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"org_chg_amt",		false,		"",		dfFloat,			2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"sc_rfa_expt_amt",	false,		"",		dfFloat,			2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"aft_expt_dc_amt",	false,		"",		dfFloat,			2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"bil_amt",			false,		"",		dfFloat,			2,		false,		true);
				
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"inv_xch_rt",		false,		"",		dfFloat,			6,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"gb");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"pol_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"pod_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"por_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"del_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"chg_cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"chg_cust_seq");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,		true,		"dmdt_delt_rqst_sts_cd");


					//CountPosition = 0;
					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"ar_curr_cd") = "Amount per A/R Office Currency";
					ToolTipText(0,"inv_amt") 	= "Amount per A/R Office Currency";
					ToolTipText(1,"ar_curr_cd") = "Amount per A/R Office Currency";
					ToolTipText(1,"inv_amt") 	= "Amount per A/R Office Currency";
					
                    FrozenCols = SaveNameCol("cntr_cnt");
                    
                    //말줄임표
                    Ellipsis = true;
					
   				}
			break;

		}
	}
	
    function initAxonControl() {
		axon_event.addListener('mouseover', 'btn_mouseover', 'btn1_billing');	// onMouseover 이벤트
		axon_event.addListener('mouseout', 'btn_mouseout', 'btn1_billing');	// onMouseout 이벤트
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때

    }
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
        
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }	
    
    //포커스가 나갈 때
    function obj_blur(){
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		if(obj.name == 's_bkg_no' || obj.name == 's_bl_no' || obj.name == 's_cntr_no') {
		}else if(obj.name == 's_cust_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else{
			ComChkObjValid(obj);
		}
    }    
    
    
    // (버튼 말풍선  보여줌)
	function btn_mouseover() {
		var bak = 'lightyellow';
		var msg = 'Invoice Creation & Issue by Booking';
		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
		var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;
		skn.left = x-150;
		skn.top  = y+20;
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
    }
    
    // (버튼 말풍선 숨김)
	function btn_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
	
  	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 's_bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 's_bl_no':		// B/L No. 멀티입력 팝업 호출
	  			case 's_cntr_no':		// CNTR No. 멀티입력 팝업 호출
	  				var returntitle = '';
	  				if(flag == 's_bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 's_bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 's_cntr_no')
	  					returntitle = 'CNTR No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
	  			case 's_cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  				
	  		} // switch-end
  		} // with-end
  		
  	}
  	
  	
     /*
      * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
      * - 해당 필드에 멀티 입력값을 설정해준다.
      */
     function getDmt_Multi(rArray, return_val) {
     	var targObj = eval("document.form." + return_val);
     	var retStr = rArray.toString().toUpperCase();
     	
     	ComSetObjValue(targObj, retStr);
     }
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.s_cust_cd.value = aryPopupData[0][3];
    	document.form.s_cust_name.value = aryPopupData[0][4];
    }    

	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:      //조회
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.

				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					formObj.s_ofc_cd.value = comboObjects[0].Code;
					setParameters(SEARCH);

					if (validateForm(sheetObj,formObj,sAction)) {
						
						if(ComGetObjValue(formObj.s_group_by) == "1") {
							sheetObj.ColHidden("cntr_cnt") = false;
							sheetObj.ColHidden("cntr_no") = true;
						} else {
							sheetObj.ColHidden("cntr_cnt") = true;
							sheetObj.ColHidden("cntr_no") = false;
						}

	                    //ComOpenWait Start
	                    sheetObj.WaitImageVisible=false;
	                    ComOpenWait(true);
						
						sheetObj.DoSearch("EES_DMT_4001GS.do", FormQueryString(formObj));

	                    //ComOpenWait End
	                    ComOpenWait(false);
						
	                    if(sheetObj.TotalRows > 0) {
	                    	//조회 내용이 있으면 버튼을 활성화 한다.
							searchButton();
						} else {
							//조회 내용이 없으면 버튼을 비활성화 한다.
							initButton()
						}
					}
				}
				
				break;
				
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'CheckBox');
				}; 
				
				break;
		}
	}
	
	/**
	 * EES_DMT_4013, EES_DMT_4002 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
	
		if(srcName == "btn_billing") {
			var ret = fnc_delt_rqst_sts_cd(sheetObj, -1);
			 if (ret =='R'){
				 return;
			 }
				
			var url = "EES_DMT_4002.do"
				+"?group_by="+ComGetObjValue(formObj.s_group_by)
				+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
				+"&ofc_cd="+ComGetObjValue(formObj.s_ofc_cd)
				+"&bkg_no="+sheetObj.CellValue(sheetObj.SelectRow, "bkg_no")
				+"&dmdt_trf_cd="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_trf_cd")
				+"&invoice_issue=1"	//Invoice Issue BEFORE
				;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", EES_DMT_4002_WIDTH, EES_DMT_4002_HEIGHT, true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}

		}else if(srcName == "btn_group_billing") {
			if(sheetObj.CheckedRows("CheckBox") == 0) {
     			ComShowCodeMessage('COM12114', 'BKG No');
     			return;
     		}
			
			var ret = fnc_delt_rqst_sts_cd(sheetObj, -1);
			 if (ret =='R'){
				 return;
			 }
			 
			var chk_curr_cd     = "";
      		var chg_dmdt_trf_cd = "";
      		var chkRows = sheetObj.FindCheckedRow("CheckBox").split("|");
				for (var i=0; i < chkRows.length-1; i++) {
					var trfCd         = sheetObj.CellValue(chkRows[i], "dmdt_trf_cd");             	
					var currCd        = sheetObj.CellValue(chkRows[i], "bzc_trf_curr_cd");

         		if (i == 0) {
         			chg_dmdt_trf_cd = trfCd;
         			chk_curr_cd = currCd;
         		} 
         		else {
         			if (chg_dmdt_trf_cd != trfCd) {
      					ComShowCodeMessage('DMT02002', 'Tariff');
      					return;
         			}
         			if (chk_curr_cd != currCd) {
      					ComShowCodeMessage('DMT02002', 'Curr.');
      					return;
         			}
         		} 
      		}
  				
			var url = "EES_DMT_4013.do"
				+"?s_group_by="+ComGetObjValue(formObj.s_group_by)
				+"&s_chg_type="+ComGetObjValue(formObj.s_chg_type)
				+"&jspno=4001"
				;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4013", "1020","645", true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}

    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
   	 
		switch(comboObj.id) {
			case "office":
				ComSetObjValue(formObj.f_cmd, SEARCHLIST02);	
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				// Office List
				var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
				var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
   	    	
	    	    var comboCodeArr = ofc_cds.split("|");
	    	    var comboTextArr = ofc_nms.split("|");
	    	    
	    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
	    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
	         	}
	    	    
	    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
				var usr_ofc_cd = document.form.usr_ofc_cd.value;
				comboObj.Code = usr_ofc_cd;
   	  		
   	  			if(comboObj.Code != usr_ofc_cd) {
	    	  		comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
	    	  		comboObj.Code = usr_ofc_cd;
   	  			}
	    	    break;
	        	
	        case "tariff_type":
		 		// Tariff type comboList
				ComSetObjValue(formObj.f_cmd, SEARCHLIST);	
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem = comboItems[0].split(FIELDMARK);
				}
				
				var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
				// User Setup Tariff Type 이 없을 경우 Default값으로.
				if(data2 == '') data2 = 'CTIC,DMIF';
				
				comboObj.Code2 = data2;
				USR_TRF_TP = data2;
				formObj.usr_trf_tp.value = data2;
				break;
			
        }
        sheetObj.WaitImageVisible = true;
    }
    
    //Payer 체크
    
    /**
     * @param sheetObj
     * @param formObj
     * @param object
     * @param formCmd
     */
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
		
		if(cust_len == 0){
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_name, "");
			return;
		}
		
		var cre_cnt_cd = "";
		
		if(cust_len > 2) {
			var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
			//2자리가 영문자이면 CUSTOMER 조회
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
			//아니면 VENDOR 조회
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
			}
		}else if(cust_len > 0){
			//VENDOR 조회
			ComSetObjValue(formObj.s_cust_gubun, "1");
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_name, "");
			return;
		}		
		
		ComSetObjValue(formObj.f_cmd, SEARCH20);
		
		var sXml 	= sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		var cust_cd = ComGetEtcData(sXml, "PAYER_CODE");
		var cust_nm = ComGetEtcData(sXml, "PAYER_NM");
		var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
		
		if(cust_nm == null || cust_nm == "") {
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_name, "");
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(formObj.s_cust_cd);
		}else{
			ComSetObjValue(formObj.s_cust_cd, cust_cd);
			ComSetObjValue(formObj.s_cust_name, cust_nm);
		}
		
        sheetObj.WaitImageVisible = true;
    }
    
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
			
				//로그인 User가 Security 상에서 Access 권한이 있는지 조회한다.
			case IBSEARCH_CHECK_ROLE:

				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회결과 처리
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));
				
				var roleAuth = ComGetObjValue(formObj.role_auth);
				if (roleAuth == "DMT01" || roleAuth == "DMT02" ){
					comboObjects[0].Enable = true;
				}else{
					comboObjects[0].Enable = false;
				}
				
				break;

        }
		sheetObj.WaitImageVisible = true;
    }
    
    
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		
 		switch(comboObj.id) {
 			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
		  		
 		}
 	}    
 	
	//멀티콤보 클릭 이벤트
	function tariff_type_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	
	/*
	 * 더블클릭 팝업(Billing)
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		
		 var ret = fnc_delt_rqst_sts_cd(sheetObj, Row );
		
		 if (ret =='R'){
			 return;
		 }
		
		var url = "EES_DMT_4002.do"
			+"?group_by="+ComGetObjValue(formObj.s_group_by)
			+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
			+"&ofc_cd="+ComGetObjValue(formObj.s_ofc_cd)
			+"&bkg_no="+sheetObj.CellValue(Row, "bkg_no")
			+"&dmdt_trf_cd="+sheetObj.CellValue(Row, "dmdt_trf_cd")
			+"&cntr_no="+sheetObj.CellValue(Row, "cntr_no")
			+"&invoice_issue=1"	//Invoice Issue BEFORE
			;

		var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", EES_DMT_4002_WIDTH, EES_DMT_4002_HEIGHT, true);
		if(returnValue == "Y") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	
  	/**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
	 function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		 with(sheetObj) {
			 if (ColSaveName(Col) != "CheckBox") {
				// row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
				var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "CheckBox")) {
                            CellValue2(arr[i], "CheckBox") = "1";    // 선택된 행의 CheckBox 체크
                        }
                    }
                    
                    if (CheckedRows("CheckBox") == RowCount) {//체크된 행의 갯수 == 전체행갯수
					    for(var i = 0 ; i < HeaderRows ; i++)
							HeadCheck(i,"CheckBox") = true;
                    }
                }
            } else {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
            	ComSyncAllCheck(sheetObj, Col, Value);
            }
		 }
	 }
	 
	 
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.s_ofc_cd, ComGetObjValue(formObj.office));
		ComSetObjValue(formObj.s_dmdt_trf_cd, ComGetObjValue(formObj.tariff_type));
		
		if(sAction == SEARCH) {
			var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			if(cust_len > 2) {
				var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//2자리가 영문자이면 CUSTOMER 조회
				if(ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				//아니면 VENDOR 조회
				}else{
					ComSetObjValue(formObj.s_cust_gubun, "1");
				}
			}
		}
		
		
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
    	var msg ="";
    	
    	with(formObj) {
    		
    		switch(sAction) {
    			case IBSEARCH:      //조회
    				//필수입력값 체크(office)
    				if(comboObjects[0].Text == '') {
		        		ComAlertFocus(formObj.office, ComGetMsg('DMT02002', "Office"));
		        		return false;
		        	}
    				//필수입력값 체크(Tariff Type)
    				if(ComTrim(ComGetObjValue(formObj.tariff_type)) == "") {
		        		ComAlertFocus(formObj.tariff_type, ComGetMsg('DMT02002', "Tariff Type"));
		        		return false;
		        	}
    				//Date checked
    				if(formObj.s_cont_type[0].checked) {
    					var fm_dt = ComTrim(ComGetObjValue(formObj.fm_cfm_dt));
    					var to_dt = ComTrim(ComGetObjValue(formObj.to_cfm_dt));
    					
    					//null check
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.fm_cfm_dt, ComGetMsg('DMT02002', "Confirmed Date"));
    						return false;
    					}
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.to_cfm_dt, ComGetMsg('DMT02002', "Confirmed Date"));
    						return false;
    					}
    					//from , to 유효성 체크
    					if(ComChkPeriod(fm_dt, to_dt) == 0) {
    			  			ComShowCodeMessage('DMT01048');
    			  			ComSetFocus(formObj.fm_cfm_dt);
    			  			return false;
    					}
    					//from, to 3개월 유효성 체크
    					var fm_dt_three_month = ComGetDateAdd(fm_dt, "M", 3);
    					if(ComChkPeriod(to_dt, fm_dt_three_month) == 0) {
    			  			ComShowCodeMessage('COM12133', "To Date", "From Date", "3 month");
    			  			ComSetFocus(formObj.fm_cfm_dt);
    			  			return false;
    					}
    					
    				//CNTR checked
    				} else if(formObj.s_cont_type[1].checked) {
             			if(ComIsNull(formObj.s_bkg_no) && ComIsNull(formObj.s_bl_no) && ComIsNull(formObj.s_cntr_no)) {
             				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
                 			return false;
             			}

             			var bkgNo = ComGetObjValue(formObj.s_bkg_no);
             			if(bkgNo != '') {
             				var arrBkgNo = bkgNo.split(',');
             				for(var i=0; i<arrBkgNo.length; i++) {
             					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
             						ComAlertFocus(formObj.s_bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
    	                 			return false;
             					}
             				}
             			}
             			
             			var blNo = ComGetObjValue(formObj.s_bl_no);
             			if(blNo != '') {
             				var arrBlNo = blNo.split(',');
             				for(var i=0; i<arrBlNo.length; i++) {
             					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
             						ComAlertFocus(formObj.s_bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
    	                 			return false;
             					}
             				}
             			}
             			
             			var cntrNo = ComGetObjValue(formObj.s_cntr_no);
             			if(cntrNo != '') {
             				var arrCntrNo = cntrNo.split(',');
             				for(var i=0; i<arrCntrNo.length; i++) {
             					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// 길이 초과
             						ComAlertFocus(formObj.s_cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
    	                 			return false;
             					}
             				}
             			}
    				}
    				
    				break;
    		}
    		

		}
	
		return true;
	}
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(24);
    	    sheetObjects[0].style.height = 480;
    	}
    	else
    	{
    	    objs.style.display = "inline";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(19);
    	    sheetObjects[0].style.height = 380;
    	}
    }
	
	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		for(var k=0;k<comboObjects.length;k++){
			//initCombo(comboObjects[k],k+1);
			comboObjects[k].Code = "-1";
			comboObjects[k].RemoveAll();
		}
		
		formObj.s_group_by.selectedIndex = 0;
		formObj.s_chg_type.selectedIndex = 0;

		ComSetObjValue(formObj.s_ofc_cd, 		"");
		ComSetObjValue(formObj.s_dmdt_trf_cd, "");
		ComSetObjValue(formObj.fm_cfm_dt, 	"");		
		ComSetObjValue(formObj.to_cfm_dt, 	"");		
		ComSetObjValue(formObj.s_bkg_no, 		"");
		ComSetObjValue(formObj.s_bl_no, 		"");
		ComSetObjValue(formObj.s_cntr_no, 	"");
		ComSetObjValue(formObj.s_sc_no, 		"");
		ComSetObjValue(formObj.s_rfa_no, 		"");
		ComSetObjValue(formObj.s_cust_cd, 	"");
		ComSetObjValue(formObj.s_cust_name, 	"");
		
		formObj.s_cont_type[0].checked = true;

	}		
	
	/*
	 * 조회결과 정보 초기화
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}	
	
	/*
	 * 버튼 초기화
	 */
	function initButton() {
		ComBtnDisable("btn_group_billing");
		ComBtnDisable("btn_billing");
		ComBtnDisable("btn_downexcel");
	}
	
	function searchButton() {
		ComBtnEnable("btn_group_billing");
		ComBtnEnable("btn_billing");
		ComBtnEnable("btn_downexcel");
	}
	
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		initResultControls();
		// IBMultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		//DATA 초기화
    	var formObj = document.form;
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST02);	//office
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCHLIST);	//tariff_type
		
	    //Button 초기화
	    initButton();
		
	}	
		 /*
		  * Billing 시 delt_rqst_sts_cd Check
	      * <br><b>Example :</b>
	      * <pre>
	      * </pre>
	      * @param  없음
	      * @return ret
	      * @author KIM HYUN HWA
	      * @version 2011.10.14
		 */
		function fnc_delt_rqst_sts_cd(sheetObj, Row) {
			 if ( Row < 0 ) {	 
					//2011.10.14 KHH [CHM-201113639-01]			
		     		var chkRows = sheetObj.FindCheckedRow("CheckBox").split("|");
		  			
						for(var i=0; i < chkRows.length-1; i++) {
		     			   var delt_rqst_sts = sheetObj.CellValue(chkRows[i], "dmdt_delt_rqst_sts_cd"); 
		     			 
		    			   if(delt_rqst_sts=='R'){
		    				  ComShowCodeMessage('DMT01154');
		    				 return "R";
		    			   }
						}
		       }else{	
		    	   var delt_rqst_sts = sheetObj.CellValue(Row, "dmdt_delt_rqst_sts_cd"); 
		    	   if(delt_rqst_sts=='R'){
	    				  ComShowCodeMessage('DMT01154');
	    				 return "R";
	    			   }
		       }
				return "N";
		   }
	      
	      /**
	       * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
	       */
	      function handleNullString(sVal) {
	     	
	          if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

	          return ComTrim(sVal);
	      }

	/* 개발자 작업  끝 */