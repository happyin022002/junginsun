/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0220.jsp
*@FileTitle : TPB Inquiry by EAC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.23 백형인
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
     * @class ESD_EAS_0220 : ESD_EAS_0220 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0220() {
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

	//공통전역변수
    var frm = null;
    var ofcLevel = null;

    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;    
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/	
		var sheetObject = sheetObjects[0]; 
		var sheetObject2 = sheetObjects[1]; 
		/*******************************************************/
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				/* [1.1.조회로직] */
				case "btn_retrieve":
						doActionIBSheet(sheetObject,frm,IBSEARCH);
				break;
				case "btn_new":
						ComResetAll();
						loadPage();
				break;

				/* [2.1.엑셀다운로드 버튼] */
				case "btn_downexcel":
						doActionIBSheet(sheetObject,frm,"btn_downexcel");
				break;
				
				case "btn_vndr_seq":
				break;
				

                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
    	            cal.select(frm.s_eac_yrmon_fr, "yyyy-MM");
                	break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
                	cal.select(frm.s_eac_yrmon_to, "yyyy-MM");
                	break;  			
				case "btn_party_val":
					open3rdParty(frm.s_vndr_cust_div_cd.Code);                	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TRS90404');
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
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     

     
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
        
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	    doActionIBSheet(sheetObjects[1], frm,"offce_level");
	    doActionIBCombo(frm.s_eac_expn_tp_cd); // Expense Type
	    doActionIBCombo(frm.s_eac_tp_cd); // EAC Type
	    doActionIBCombo(frm.s_vndr_cust_div_cd); // 3RD Party
	    
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}	    
		frm.s_eac_yrmon_fr.value = ComGetNowInfo("ym");
		frm.s_eac_yrmon_to.value = ComGetNowInfo("ym");
		//getMonthBetween(frm.s_eac_yrmon_fr);
		initControl();
	}

	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
 
			case "s_eac_expn_tp_cd":  
			case "s_eac_tp_cd":  
			case "s_vndr_cust_div_cd":  
				comboObj.InsertItem(0, "", "");
				comboObj.Index2=0;
				break;  
			case "s_ots_sts_cd":  
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Open", "T");
				comboObj.InsertItem(2, "Closed", "P");
				comboObj.Index2=0;
				break;  
			case "s_ots_sts_dtl_cd":  
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Initial Confirmation", "O");
				comboObj.InsertItem(2, "Invoice Issued", "I");
				comboObj.InsertItem(3, "Collection Agency", "Y");
				comboObj.InsertItem(4, "Adjustment Request", "R");
				comboObj.InsertItem(5, "Adjustment Reject", "J");
				comboObj.InsertItem(6, "Closed", "E");
				comboObj.InsertItem(7, "ERP Interface", "L");
				comboObj.InsertItem(8, "Process Close", "D");
				comboObj.InsertItem(9, "RHQ Cancelled", "S");
				comboObj.Index2=0;
				break;  
		}
	
	}	
	
	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
	}
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="s_vndr_seq") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	        break;
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_vndr_seq":
				vender_change();
			break;
			
			case "s_eac_yrmon_fr":
			case "s_eac_yrmon_to":
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
		case "s_eac_yrmon_fr":
			//getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ym");
			break;	
		case "s_eac_yrmon_to":
			obj.value = ComGetMaskedValue(obj,   "ym");
			break;
		case "s_n3tpy_src_cd":
			tpb3rdPartyChk();
		break;
		}
	}
	
	
	// 입력한 3rdParty Value 값이 유효한지 체크한다.
	function tpb3rdPartyChk(){
		if(frm.s_n3tpy_src_cd.value==""){
				frm.s_n3tpy_src_cd.value     = ""; 
				frm.s_n3tpy_src_nm.value      = ""; 
			return;
		}
		
		/*
		 * 1. 3RD Party Code 입력 값이 사용가능 한지 체크 한다.
		 * */		
		var vpValue = frm.s_n3tpy_src_cd.value;
		if(frm.s_vndr_cust_div_cd.Code == "V"){
			// 첫번재 숫자의 위치를 찾아 그앞의 문자는 삭제한다.
			frm.s_trd_party_val.value = vpValue.substring(chkChars(vpValue,"0123456789"));
		}else{
			frm.s_trd_party_val.value = vpValue;
		}
		frm.f_cmd.value = COMMAND06;
		
		var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		var chkData = EasXmlString(sXml,"val");
		var vdData = "";
		if(chkData == ""){
			ComShowCodeMessage('COM132202', frm.s_vndr_cust_div_cd.Text); //사용할수 없는 S/P Code
			frm.s_trd_party_val.value =""; 
			frm.s_n3tpy_src_cd.value =""; 
			frm.s_n3tpy_src_nm.value =""; 			
		}else{
			vdData = chkData.split("|$|");
			
			if(frm.s_vndr_cust_div_cd.Code  =="V"){
				frm.s_trd_party_val.value = vdData[1]; 
				frm.tpb_vndr_cnt_cd.value   = vdData[2];  // 국가 코드
				frm.tpb_vndr_seq.value      = vdData[1];  // 코드
			
				frm.s_n3tpy_src_cd.value =vdData[1]; 
				frm.s_n3tpy_src_nm.value =vdData[3]; 
				
			}else if(frm.s_vndr_cust_div_cd.Code  =="S"){
				frm.s_trd_party_val.value = vdData[2];
				frm.n3pty_ofc_cd.value = vdData[2];
				
				frm.s_n3tpy_src_cd.value     = vdData[2];
				frm.s_n3tpy_src_nm.value      = vdData[2];
				
			}else if(frm.s_vndr_cust_div_cd.Code  =="C"){
				frm.s_trd_party_val.value = vdData[2]+vdData[1]			
				
				frm.cust_cnt_cd.value       = vdData[2];  // 국가 코드
				frm.cust_seq.value          = vdData[1];  // 코드
				
				frm.s_n3tpy_src_cd.value     = vdData[2]+vdData[1];  // 국가 코드 + 코드
				frm.s_n3tpy_src_nm.value      = vdData[3];  // 명칭
			}			
		}
		
	}
	
	function chkChars(input,chars) {
	    for (var inx = 0; inx < input.length; inx++) {
	       if (chars.indexOf(input.charAt(inx)) > -1) return inx;
	    }
	    return 0;
	}	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_eac_yrmon_fr":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_eac_yrmon_to":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}

	
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		if(obj.value.length >= 6) {
			frm.s_eac_yrmon_to.value = ComGetDateAdd(obj.value,"D", 364, "-").substring(0,7);
		}else{
			frm.s_eac_yrmon_to.value = "";
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
	    	case 1:      //sheet1 init
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
		    		
		    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		    		InitColumnInfo(32, 3, 0, true);
		    		
		    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		    		InitHeadMode(true, true, true, true, false,false) ;
		    		
		    		var HeadTitle1 = "|SEQ.|EAC No.|RHQ|Audit\nOffice|Audit\nType|Entered\ndate|Audit\nmonth|Expense\nType|EAC Type|EAC Type|Responsible\nOffice|3rd party|3rd party|3rd party|Cost Code|S/P Name|Invoice no|Audit\namount(US$)|TPB No.|TPB Office|EQ Kind|EQ No.\nor VVD|BKG No.|B/L No.|VVD|TPB I/F Amount|TPB I/F Amount|ROC\noffice|TPB\nstatus|Invoiced amount|Invoiced amount";
		    		var HeadTitle2 = "|SEQ.|EAC No.|RHQ|Audit\nOffice|Audit\nType|Entered\ndate|Audit\nmonth|Expense\nType|Main|Sub|Responsible\nOffice|Type|Code|Name|Cost Code|S/P Name|Invoice no|Audit\namount(US$)|TPB No.|TPB Office|EQ Kind|EQ No.\nor VVD|BKG No.|B/L No.|VVD|Cur|Amount|ROC\noffice|TPB\nstatus|Cur|Amount";
		    		
		    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		    		InitHeadRow(0, HeadTitle1, true);
		    		InitHeadRow(1, HeadTitle2, true);
		    		
		    		HeadRowHeight = 12;
		    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,  "ibflag");
		    		InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,  "seq");
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "eac_no",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,  "rhq_ofc_cd",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,  "audr_ofc_cd",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         70,  	daLeft,     true,  "eac_apro_tp_nm",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,  "eac_inp_dt",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,  "eac_yrmon",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         90,  	daLeft,     true,  "eac_expn_tp_nm",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,  "eac_tp_nm",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,  "eac_bil_tp_nm",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "respb_ofc_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         50,  	daLeft,     true,  "vndr_cust_div_nm",  false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,  "n3pty_src_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,  "n3pty_src_nm",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,  "eac_cost_desc",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,  "vndr_nm",           false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,  "n3pty_src_no",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daRight,    true,  "inv_aud_usd_amt",   false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "n3pty_no",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,  "tpb_ofc_cd",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         70,  	daLeft,     true,  "eq_knd_nm",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,  "eq_no",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "bkg_no",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "bl_no",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "vvd_cd",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,  "cfm_curr_cd",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daRight,    true,  "cfm_amt",           false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "tpb_roc_ofc_cd",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,  "ots_sts_nm",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,  "curr_cd",           false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		    		InitDataProperty(0, cnt++ , dtData,         110,  	daRight,    true,  "inv_aud_amt",       false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
	    	    }
				break;
	    	case 2:      //sheet1 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = 0;
	    		//전체 너비 설정
	    		SheetWidth = mainTable.clientWidth;
	    		
	    		//Host정보 설정[필수][HostIp, Port, PagePath]
	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    		
	    		//전체Merge 종류 [선택, Default msNone]
	    		MergeSheet = msHeaderOnly;
	    		
	    		//전체Edit 허용 여부 [선택, Default false]
	    		Editable = false;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(3, 3, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "|SEQ.|EAC No";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
	    		InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
	    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "eac_no",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
	    		
	    	    }
	    		break;
			}
		}	
	 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			var frm = document.form;
			
			switch (sAction) {

				// SEARCH LOGIC
				case IBSEARCH:
					if(validateForm(sheetObj,frm,sAction)){
						sheetObjects[0].RemoveAll();
						frm.f_cmd.value = SEARCH01;
						var sParam = FormQueryString(frm);
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0220GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
					}
					break;



				case "btn_downexcel":	// EXCEL DOWNLOAD
//					sheetObj.SpeedDown2Excel(1);
					sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					break;
		  		case "offce_level":    
		  			frm.f_cmd.value = COMMAND01;
	        		var sXml = sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
	        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
	        		var rhqSearchFlag = false;
	        		// 로그인한 RHQ OFFCD 셋팅
	        		frm.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
	        		// 로그인한 OFFCD 셋팅
	        		frm.s_audr_ofc_cd.InsertItem(0, frm.ofc_cd.value, frm.ofc_cd.value);
	        		if(ofcLevel=="O"){
	        			// 본사(심사팀) RHQ 소속이외
	            		rhqSearchFlag = false;
	            		frm.s_rhq_ofc_cd.Enable=false;
	            		frm.s_audr_ofc_cd.Enable=false;  
	            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
	            		frm.s_audr_ofc_cd.code2 = frm.ofc_cd.value; 
	        		}else if(ofcLevel=="R"){
	        			rhqSearchFlag = false;
	        			frm.s_rhq_ofc_cd.Enable=false;
	        			frm.s_audr_ofc_cd.Enable=true;        			
	        			frm.s_rhq_ofc_cd.Index2=0;
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        			
	        		}else if(ofcLevel=="H"){
	        			// 본사(심사팀) 소속
	            		rhqSearchFlag = true;
	            		frm.s_rhq_ofc_cd.Enable=true;
	            		frm.s_audr_ofc_cd.Enable=true;                		
	        		}
	    			
	        		if(rhqSearchFlag){
	        			//RHQ 콤보 리스트 조회
	        			frm.s_rhq_ofc_cd.RemoveAll();
	        			frm.f_cmd.value = COMMAND02;
	        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        			ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
	        			frm.s_rhq_ofc_cd.InsertItem(0, '', '');
	        			frm.s_rhq_ofc_cd.Index2 = 0;
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        		}
	        		
		  		break;  				
			}
		}

		/**
		* sheet1 doubleClick후 이벤트 
		* @param {ibsheet} sheet 해당 시트   
		* @param {long} row 해당 셀의 Row Index
		* @param {long} col 해당 셀의 Column Index
		*/
		function sheet1_OnDblClick(sheetObj, Row, Col) {
			var eacNo = sheetObj.CellValue(Row, "eac_no");
			var pgmNo = 'ESD_EAS_0201';
			var pgmUrl = 'ESD_EAS_0201.do?';
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&EAC_NO=" + eacNo+"&READ_ONLY_FLG=Y";
			ComOpenPopup(pgmUrl + src, 1024, 610, "", "1,0", true, false);
		}

	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	    	var sheetObj = sheetObjects[1];
	        switch(comboObj.id) {
			    case "s_rhq_ofc_cd":  
			        frm.f_cmd.value = COMMAND03;
			        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
			    	
			        frm.s_audr_ofc_cd.RemoveAll();
			    	ComXml2ComboItem(sXml, frm.s_audr_ofc_cd, "ofc_cd", "ofc_cd");
			    	frm.s_audr_ofc_cd.InsertItem(0, "", "");
	//		    	frm.s_audr_ofc_cd.Index=0;
			    	frm.s_audr_ofc_cd.code2 = frm.ofc_cd.value
			    	
			    	break;  
				case "s_eac_expn_tp_cd":    
					searchCommonCombo("CD03352",frm.s_eac_expn_tp_cd);
					break;  
				case "s_eac_tp_cd":    
					searchCommonCombo("CD00587",frm.s_eac_tp_cd);
					break;  
				case "s_ots_sts_cd":
					frm.s_ots_sts_dtl_cd.RemoveAll();
					frm.s_ots_sts_dtl_cd.InsertItem(0, "", "");
					if(frm.s_ots_sts_cd.Code == ""){
						frm.s_ots_sts_dtl_cd.InsertItem(1, "Initial Confirmation", "O");
						frm.s_ots_sts_dtl_cd.InsertItem(2, "Invoice Issued", "I");
						frm.s_ots_sts_dtl_cd.InsertItem(3, "Collection Agency", "Y");
						frm.s_ots_sts_dtl_cd.InsertItem(4, "Adjustment Request", "R");
						frm.s_ots_sts_dtl_cd.InsertItem(5, "Adjustment Reject", "J");
						frm.s_ots_sts_dtl_cd.InsertItem(6, "Closed", "E");
						frm.s_ots_sts_dtl_cd.InsertItem(7, "ERP Interface", "L");
						frm.s_ots_sts_dtl_cd.InsertItem(8, "Process Close", "D");
						frm.s_ots_sts_dtl_cd.InsertItem(9, "RHQ Cancelled", "S");
					}else if(frm.s_ots_sts_cd.Code == "T"){
						frm.s_ots_sts_dtl_cd.InsertItem(1, "Initial Confirmation", "O");
						frm.s_ots_sts_dtl_cd.InsertItem(2, "Invoice Issued", "I");
						frm.s_ots_sts_dtl_cd.InsertItem(3, "Collection Agency", "Y");
						frm.s_ots_sts_dtl_cd.InsertItem(4, "Adjustment Request", "R");
						frm.s_ots_sts_dtl_cd.InsertItem(5, "Adjustment Reject", "J");
					}else if(frm.s_ots_sts_cd.Code == "P"){
						frm.s_ots_sts_dtl_cd.InsertItem(1, "Closed", "E");
						frm.s_ots_sts_dtl_cd.InsertItem(2, "ERP Interface", "L");
						frm.s_ots_sts_dtl_cd.InsertItem(3, "Process Close", "D");
						frm.s_ots_sts_dtl_cd.InsertItem(4, "RHQ Cancelled", "S");
					}
					frm.s_ots_sts_dtl_cd.Index2=0;
					break;  
				case "s_vndr_cust_div_cd":
					searchCommonCombo("CD00583",frm.s_vndr_cust_div_cd)
					break;
	        }
	    }
	    
		
		
		// 공통테이블에 등록된 코드값을 조회 한다.    
		function searchCommonCombo(codeKey,comboObj){
			var sheetObj = sheetObjects[1];
				frm.f_cmd.value = SEARCH01;
				// 공통 테이블에서 조회할 키
				frm.code_key.value = codeKey
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}
		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_rhq_ofc_cd); // RHQ
		}	 
		function s_ots_sts_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_ots_sts_cd); // RHQ
		}	 
		function s_vndr_cust_div_cd__OnChange(comboObj,Index_Code, Text){   
				frm.s_trd_party_val.value   = ""; 
				frm.s_n3tpy_src_cd.value     = ""; 
				frm.s_n3tpy_src_nm.value      = ""; 			
				frm.tpb_vndr_cnt_cd.value   = "";
				frm.tpb_vndr_seq.value      = "";
				frm.n3pty_ofc_cd.value      = "";
				frm.cust_cnt_cd.value       = "";
				frm.cust_seq.value          = "";
		}	 
		
		
  
		
		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,frm,sAction){
			switch(sAction) {
			case IBSEARCH :
				if(frm.s_eac_yrmon_fr.value == "" || frm.s_eac_yrmon_to.value == ""){
					ComShowCodeMessage('COM130201', 'Entered Date'); // Entered Date 값을 입력하셔야 합니다;
					return false;
				}

				var ls_fm_dt = removeBar(frm.s_eac_yrmon_fr.value);
				var ls_to_dt = removeBar(frm.s_eac_yrmon_to.value);
				var days_between = ComGetDaysBetween(ls_fm_dt , ls_to_dt) ;  // 조회 기간

				if ( days_between > 364 ) {
					ComShowCodeMessage("EAS90079");
					return false;
				}
				
				break;
			} // end switch()
			return true;
		}
		
		/**
		* vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
		*
		* @param : val - vndr_cust_div_cd
		*/
		function open3rdParty(val) {
			var strTrd_party = val;
			if(strTrd_party=='C') { // Customer
				ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 420, 'openCustomer', '1,0,1,1,1',true);
			} else if(strTrd_party=='S') { // Staff
				openPopup3rdParty(val);
			} else if(strTrd_party=='V') { // Vendor
				ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 410, 'openVendor', '1,0,1,1,1',true);
			} 
			
		}
		
		
		/**
		* 3rd Party Staff 팝업창을 여는 함수
		*/
		function openPopup3rdParty(val) {
			var theURL = "ESD_TPB_0813.do?title=Select Staff";
			var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:510px";
			var rtnValue = window.showModalDialog(theURL, window, features);
				frm.s_trd_party_val.value = rtnValue;
				frm.s_n3tpy_src_cd.value = rtnValue;
				frm.s_n3tpy_src_nm.value = rtnValue;
				frm.n3pty_ofc_cd.value = rtnValue;
				
				frm.cust_cnt_cd.value = "";
				frm.cust_seq.value = "";
				frm.tpb_vndr_cnt_cd.value = "";
				frm.tpb_vndr_seq.value = "";
				tpb3rdPartyChk();
				
			
		}
		
		/**
		* 3rd Party Customer popup close시 호출되는 함수
		*/
		function openCustomer(rArray) {
			var cArray = rArray[0];
			
			var parVal = cArray[3]
			var parNm = cArray[4]
				frm.s_trd_party_val.value = parVal;
				frm.s_n3tpy_src_cd.value = parVal;
				frm.s_n3tpy_src_nm.value = parNm;
				frm.cust_cnt_cd.value = parVal.substring(0,2)
				frm.cust_seq.value = parVal.substring(2,8)
				
				frm.n3pty_ofc_cd.value = "";
				frm.tpb_vndr_cnt_cd.value = "";
				frm.tpb_vndr_seq.value = "";
				tpb3rdPartyChk();
		}   
		
		
		/**
		* 3rd Party Vendor popup close시 호출되는 함수
		*
		*/
		function openVendor(rArray) {
			var cArray = rArray[0];
			
			var parVal = cArray[7]+cArray[2];
			var parNm = cArray[4];
		    	frm.s_trd_party_val.value = cArray[2];
				frm.s_n3tpy_src_cd.value = cArray[2];
				frm.s_n3tpy_src_nm.value = cArray[4];
					
				frm.tpb_vndr_cnt_cd.value = cArray[7] // 국가코드
				frm.tpb_vndr_seq.value = cArray[2]    // 국가코드 SEQ
				
				frm.n3pty_ofc_cd.value = "";
				frm.cust_cnt_cd.value = "";
				frm.cust_seq.value = "";
				tpb3rdPartyChk();
		}		
		
	/* 개발자 작업  끝 */