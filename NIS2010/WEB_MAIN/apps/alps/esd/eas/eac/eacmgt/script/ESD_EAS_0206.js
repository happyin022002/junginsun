/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0206.js
*@FileTitle : EAC Inquiry Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
     * @class ESD_EAS_0206 : ESD_EAS_0206 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0206() {
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
    
	// offce_level 설정 H : 본부, R:RQH, O: 기타
	var ofcLevel="";    

    
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
						rep_OnPopupClick();
				break;
				case "btn_confirm":
					doActionIBSheet(sheetObject,frm,"btn_confirm");
				break;
				

                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
    	            cal.select(frm.s_eac_yrmon, "yyyy-MM");
                	break;
                	
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
			 ComConfigSheetEas(sheetObjects[i])
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	    doActionIBSheet(sheetObjects[0], frm,"offce_level");
	    doActionIBCombo(frm.s_eac_expn_tp_cd); // Expense Type
	    doActionIBCombo(frm.s_eac_tp_cd); // EAC Type
//	    doActionIBCombo(frm.s_eac_sts_cd); // Status
	    
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}	    
		
		frm.s_eac_yrmon.value = ComGetNowInfo("ym");	    // Entered Date 현재일자 셋팅		
		initControl();
	}
	

	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj, comboNo) {
	
		switch(comboObj.id) {
 
			case "s_eac_expn_tp_cd":  
			case "s_eac_tp_cd":
			case "s_eac_bil_tp_cd":
				comboObj.InsertItem(0, "", "");
				comboObj.Index2=0;
				break;
			case "s_eac_sts_cd": 
				comboObj.RemoveAll();
//				주석처리 CHM-201641905 RHQ 업무이관에 따른 EAC Recognition과 Auto Audit 수정 요청
//				if(ofcLevel == "R"){// RHQ 
//					comboObj.InsertItem(0, "", "");
//					comboObj.InsertItem(1, "Auditor Confirm", "AC");
//					comboObj.InsertItem(2, "RHQ Confirm", "RC");
//					comboObj.InsertItem(3, "RHQ Reject", "RR");
//  				}else if(ofcLevel == "H"){ // 본사
					comboObj.InsertItem(0, "", "");
//					comboObj.InsertItem(1, "RHQ Confirm", "RC");
					comboObj.InsertItem(1, "Auditor Confirm", "AC");
					comboObj.InsertItem(2, "HQ Confirm", "HC");
					comboObj.InsertItem(3, "HQ Reject", "HR");
//  				}				
				
				comboObj.Index2=1;
				break;  
				
			case "s_ofc_cd":  
//				comboObj.MultiSelect = true;
//				comboObj.MultiSeparator = ",";
				break;  
				
			case "s_eac_dup":
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Y", "Y");
				comboObj.InsertItem(2, "N", "N");
				comboObj.Index2=0;
			break;  
			case "s_tpb_dup":  
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Y", "Y");
				comboObj.InsertItem(2, "N", "N");
				comboObj.Index2=0;
				break;  
		}
	
	}	
	
	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
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
	
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_eac_yrmon":
				ComClearSeparator(obj);
				obj.select();
			break;			
	
		}		
	}
	
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_vndr_seq":
				vender_change();
			break;
			case "s_eac_yrmon":
				if(!ComChkObjValid(obj)){
					obj.value="";
					obj.focus()
				}
				break;
			case "s_inv_aud_usd_amt":
				foramtComma(frm.s_inv_aud_usd_amt);
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
				    Editable = true;
				    Ellipsis = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(46, 7, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "|eac_sts_cd|SEQ.||Status|Recognition|EAC No.|RHQ|Audit\nOffice|KPI\nOffice|Audit\nType|Entered\nDate|Audit\nMonth|Expense Type|EAC Type|EAC Type|Responsible\nOffice|Service Provider|Service Provider|Cost Code|VVD|BKG No|Location|W/O|Invoice No.|Invoice\nDate|Cur.|Invoice\nAmount|Should be\nAmount|Audit\nAmount(US$)|Settled\nAmount(US$)|Details|Internal\nnote|Action\nType|Action\nTaken|Evidence\nNo.|Auditor|Pre-audit\nI/F|Status\nDate|Approved\nby|Completion|Comp.\ndate|Completion\nby|Reason\nunapproval|EAC\nDuplication|TPB\nDuplication";
					var HeadTitle2 = "|eac_sts_cd|SEQ.||Status|Recognition|EAC No.|RHQ|Audit\nOffice|KPI\nOffice|Audit\nType|Entered\nDate|Audit\nMonth|Expense Type|Main|Sub|Responsible\nOffice|Code|Name|Cost Code|VVD|BKG No|Location|W/O|Invoice No.|Invoice\nDate|Cur.|Invoice\nAmount|Should be\nAmount|Audit\nAmount(US$)|Settled\nAmount(US$)|Details|Internal\nnote|Action\nType|Action\nTaken|Evidence\nNo.|Auditor|Pre-audit\nI/F|Status\nDate|Approved\nby|Completion|Comp.\ndate|Completion\nby|Reason\nunapproval|EAC\nDuplication|TPB\nDuplication";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daCenter,   true,   "eac_sts_cd",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtSeq,          50,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtCheckBox,     30,  	daCenter,   true,   "chk");
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "eac_sts_nm",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtComboEdit,    100,  	daCenter,   true,   "eac_vrfy_div_cd", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "eac_no",          false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "rhq_ofc_cd",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "audr_ofc_cd",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "kpi_ofc_cd",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daLeft,     true,   "eac_apro_tp_nm",  false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   true,   "eac_inp_dt",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "eac_yrmon",       false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "eac_expn_tp_nm",  false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,     true,   "eac_tp_nm",       false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "eac_bil_tp_nm",   false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "respb_ofc_cd",    false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "vndr_seq",        false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "vndr_nm",         false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "eac_cost_desc",   false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "vvd_cd_ctnt",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daLeft,     true,   "bkg_no",          false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "yd_cd",           false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,   "wo_no_ctnt",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "n3pty_src_no",    false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   true,   "n3pty_src_dt",    false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,   true,   "curr_cd",         false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "inv_amt",         false,    "",      dfNullFloat,     0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "inv_cng_amt",     false,    "",      dfNullFloat,     0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtAutoSum,      100,  	daRight,    true,   "inv_aud_usd_amt", false,    "",      dfNullFloat,     0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtAutoSum,      100,  	daRight,    true,   "stl_amt",         false,    "",      dfNullFloat,     0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "eac_desc",        false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "eac_inter_rmk",   false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "eac_rsn_nm",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "eac_rsn_desc",    false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "expn_evid_desc",  false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "audr_usr_nm",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "eac_sys_if_cd",   false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   true,   "eac_sts_dt",      false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,   	true,   "apro_usr_nm",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,   "eac_cmpl_nm",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         75,  	daCenter,   true,   "eac_cmpl_dt",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "cmpl_usr_nm",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
//					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "rjct_desc",       false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
//					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "rjct_ofc_cd",     false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "apro_desc",       false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);

					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "eac_dup",         false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "tpb_dup",         false,    "",      dfNone,          0,          true,        false,   0,  false, true,  "", false);
					
					InitDataCombo(0, "eac_vrfy_div_cd", "|Recognition|Reject", "|V|R");    // IBSheet내 Combo 초기화
					
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
	    		Editable = true;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(2, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(2, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "|SEQ";
	    		var HeadTitle2 = "|SEQ";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		InitHeadRow(1, HeadTitle2, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
	    		InitDataProperty(0, cnt++ , dtSeq,          50,  	daCenter,   true,   "seq");
	    		
	    		
	    	}
	    		break;
			}
		}	
	 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			sheetObj.ShowDebugMsg = false;
			var frm = document.form;
			
			switch (sAction) {
				// SEARCH LOGIC
				case IBSEARCH:
						sheetObjects[0].RemoveAll();
						frm.f_cmd.value = SEARCH01;
						var sParam = FormQueryString(frm);
						var sXml = sheetObjects[1].GetSearchXml("ESD_EAS_0206GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
						

					break;
				case "btn_confirm":
	  				if(!validateForm(sheetObj,frm,sAction)) return false;
	  				if(!ComShowCodeConfirm("EAS90076")){ // Issued 하시겠습니까?
						return false;
					}	  				
	  				ComOpenWait(true);
	  				frm.f_cmd.value = MODIFY01;

					var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
	  				var sXml = sheetObjects[1].GetSaveXml("ESD_EAS_0201GS.do", sParam);
	  				
	  				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	  				var ErrMsg = EacGetMsgData(sXml);

	  				if (State != "S") {
	  					if (ErrMsg.length > 0) {
	  						ComShowCodeMessage("EAS99999", ErrMsg);
	  					}else{
	  						ComShowCodeMessage("EAS90077"); // confirm Fail
	  					}
	  					ComOpenWait(false);
	  					return false;
	  				} else if (State == "S") {
	  					ComShowCodeMessage("EAS90078"); // EAC has been confirm
	  					doActionIBSheet(sheetObj,frm,IBSEARCH);
	  				}
	  				ComOpenWait(false);
					break;

				case "btn_downexcel":	// EXCEL DOWNLOAD
//					sheetObj.SpeedDown2Excel(1);
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					break;
		  		case "offce_level":    
		  			frm.f_cmd.value = COMMAND01;
	        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
	        		frm.ofclevel.value = ofcLevel;
	        		
	        		
	        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
	        		var rhqSearchFlag = true;
	        		// 로그인한 RHQ OFFCD 셋팅
	        		frm.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
	        		// 로그인한 OFFCD 셋팅
	        		frm.s_ofc_cd.InsertItem(0, frm.ofc_cd.value, frm.ofc_cd.value);
	        		if(ofcLevel=="O"){
	        			// 본사(심사팀) RHQ 소속이외
	            		rhqSearchFlag = false;
	            		frm.s_rhq_ofc_cd.Enable=false;
	            		frm.s_ofc_cd.Enable=false;  
	            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
	            		frm.s_ofc_cd.code2 = frm.ofc_cd.value;
	        		}else if(ofcLevel=="R"){
	        			rhqSearchFlag = false;
	        			frm.s_rhq_ofc_cd.Enable=false;
	        			frm.s_ofc_cd.Enable=true;        			
	        			frm.s_rhq_ofc_cd.Index2=0;
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        		}else if(ofcLevel=="H"){
	        			// 본사(심사팀) 소속
	            		rhqSearchFlag = true;
	            		frm.s_rhq_ofc_cd.Enable=true;
	            		frm.s_ofc_cd.Enable=true;              
//	            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
//	            		frm.s_ofc_cd.code2 = frm.ofc_cd.value;   	            		
	        		}
	    			
	        		if(rhqSearchFlag){
	        			//RHQ 콤보 리스트 조회
	        			frm.s_rhq_ofc_cd.RemoveAll();
	        			frm.f_cmd.value = COMMAND02;
	        			var sXml = sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        			ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
	            		frm.s_rhq_ofc_cd.InsertItem(0, '', '');		// 2015-04-23, Head Office 일 경우 All Option의 의미로 Null 추가. 전체 RHQ 자료 조회용.
	            		//frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
	            		frm.s_rhq_ofc_cd.Index2 = 0;
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        		}
	        		
		  		break;  				
			}
		}

	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	    	var sheetObj = sheetObjects[1];
	        sheetObj.ShowDebugMsg = false;
	        switch(comboObj.id) {
		    case "s_rhq_ofc_cd":  
		    	frm.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		    	
		        frm.s_ofc_cd.RemoveAll();
		    	ComXml2ComboItem(sXml, frm.s_ofc_cd, "ofc_cd", "ofc_cd");
		    	frm.s_ofc_cd.InsertItem(0, "", "");
//		    	frm.s_ofc_cd.Index2=0;
		    	
		    	frm.s_ofc_cd.code2 = frm.ofc_cd.value
		    	break;  
			case "s_eac_expn_tp_cd":    
				searchCommonCombo("CD03352",frm.s_eac_expn_tp_cd);
			break;  
			case "s_eac_tp_cd":    
				searchCommonCombo("CD00587",frm.s_eac_tp_cd);
			case "s_eac_sts_cd":    
				searchCommonCombo("CD03337",frm.s_eac_sts_cd);
			break;  
			case "s_eac_bil_tp_cd":    
				var eacCode = form.s_eac_tp_cd.Code;
					
				
				if(eacCode=="I"){
					//Internal Error
					frm.f_cmd.value = SEARCH01;
					frm.code_key.value = "CD03340";
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				}else if(eacCode=="M"){
					//Misbilling
					frm.f_cmd.value = SEARCH01;
					frm.code_key.value = "CD03339";
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				}else if(eacCode=="T"){
					// Missing 3rd Party Billing
					frm.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				}
				// 공통 테이블에서 조회할 키
				
				frm.s_eac_bil_tp_cd.RemoveAll();
				ComXml2ComboItem(sXml, frm.s_eac_bil_tp_cd, "code_cd", "code_nm");
				initCombo(frm.s_eac_bil_tp_cd);
			break;
	        }
	    }
	    
		
		/*
		* rep_commodity팝업호출
		*/
		function rep_OnPopupClick() {
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_rep";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
		}

		/**
		* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
		*/
		function getCOM_ENS_rep(rowArray) {
			for(var i=0; i<rowArray.length; i++) {
				var colArray = rowArray[0];
				var colArray2 = colArray[2];
				var colArray3 = colArray[3];
				var colArray4 = colArray[4];
				frm.s_vndr_seq.value =colArray2;
				frm.s_vndr_nm.value =colArray4;
			}
		}	
		
		// 공통테이블에 등록된 코드값을 조회 한다.    
		function searchCommonCombo(codeKey,comboObj){
			var sheetObj = sheetObjects[1];
				frm.f_cmd.value = SEARCH01;
				// 공통 테이블에서 조회할 키
				frm.code_key.value = codeKey
				sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				sheetObj.WaitImageVisible = true;
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}
		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_rhq_ofc_cd); // RHQ
		}	 
		
		function s_eac_tp_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_eac_bil_tp_cd); // EAC Type
		}	

		// Expense Type
		function s_eac_expn_tp_cd_OnChange(comboObj,Index_Code, Text){   
			if(form.s_eac_tp_cd.Code=="T"){
				doActionIBCombo(frm.s_eac_bil_tp_cd); // EAC Type2
			}
	
		}			
	  

		
		/**
		* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
		*/
		function  vender_change(){
			if(frm.s_vndr_seq.value =="" ){
				frm.s_vndr_seq.value="";
				frm.s_vndr_nm.value="";
				return;
			}
			frm.f_cmd.value = SEARCH05;
			var sXml=sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
			var vndrNm = EasXmlString(sXml,"vndr_nm");
			
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				frm.s_vndr_seq.value="";
				frm.s_vndr_nm.value="";
				return;
			}
			frm.s_vndr_nm.value = vndrNm;
		
		}
		
		function foramtComma(obj){
			if(obj.value==0||obj.value==null) {
				obj.value="";
			return;
			}
			
			if( obj.value.indexOf('.')==-1||obj.value.indexOf('.')==0){
				obj.value = obj.value+".00";
			}else{
				var inVal = ComReplaceStr(obj.value,",","") // 입력한값
				var intVal = inVal.substring(0,inVal.indexOf('.')) //소수점 제외한 값
				var subVal = inVal.substring(inVal.indexOf('.')+1,inVal.length)     //  소수점 이하값
			
			
			if(subVal.length==2){ //  잘입력된 케이스
				obj.value = inVal;
			}else if(subVal.length==1){
				obj.value = intVal+"."+subVal+"0";
			}else{
				obj.value = intVal+"."+subVal.substring(0,2);
				}
			}
			
			ComAddSeparator(obj);		
		}
		
		/**
		* 화면 폼입력값에 대한 유효성검증 프로세스 처리
		*/
		function validateForm(sheetObj,frm,sAction){
			 switch(sAction) {
				 case "btn_confirm" :
					 var chkStr = sheetObj.GetSaveString(false, true, sheetObj.SaveNameCol("chk"));
					     if(chkStr == ""){
					    	 ComShowCodeMessage('COM12113', 'EAC Inquiry Confirm Grid'); //EAC Inquiry Confirm Grid 를 선택하세요
					    	 return false;
					     }
			 			 break;
			 } // end switch()
		 return true;
		}

		/**
		 * sheet1 OnChange 이벤트
		 * @param {ibsheet} sheet 해당 시트   
		 * @param {long} row 해당 셀의 Row Index
		 * @param {long} col 해당 셀의 Column Index
		 * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
		 */
		 function sheet1_OnChange(sheetObj,Row, Col, Value) {
			 
			 if(sheetObj.ColSaveName(Col)=="chk"){
				 if(ofcLevel=="R"){  //  RHQ 소속
					 sheetObj.CellValue2(Row , "eac_sts_cd") = "RC";
	        	 }else if(ofcLevel=="H"){  // 본사(심사팀) 소속
	        		 sheetObj.CellValue2(Row , "eac_sts_cd") = "HC";
	        	 }				 
     			
			 }
			 
			 if(sheetObj.ColSaveName(Col)=="eac_vrfy_div_cd" && Value == "R"){ // 리젝을 선택하였을때
				 var param = "";

				 if(ofcLevel=="R"){  //  RHQ 소속
					 param = "&EAC_STS_CD=RR&EAC_NO="+sheetObj.CellValue(Row , "eac_no");
	        	 }else if(ofcLevel=="H"){  // 본사(심사팀) 소속
	        		 param = "&EAC_STS_CD=HR&EAC_NO="+sheetObj.CellValue(Row , "eac_no");
	        	 }
				 
				 var eacNo = sheetObj.CellValue(Row, "eac_no");
				 var pgmNo = 'ESD_EAS_0216';
				 var pgmUrl = 'ESD_EAS_0216.do?';
				 var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + param;
				     ComOpenPopup(pgmUrl + src, 480, 200, "", "1,0", true, false);
				     
				     sheetObj.CellValue(Row,"chk") = 0;
//				var rejectYn = ComOpenPopup('ESD_EAS_0216.do' + param, 480, 200, 'callBackReject', '1,0,1,1,1,1,1,1,1,1,1,1');
			 }
		 }

		 function callBackReject(rowArray){
			 
			 if(rowArray == "Y"){
				 if(ofcLevel=="R"){  //  RHQ 소속
					 sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"eac_sts_nm") = "RHQ Reject";
					 sheetObjects[0].CellEditable(sheetObjects[0].SelectRow,"eac_vrfy_div_cd") = false;	
					 sheetObjects[0].CellEditable(sheetObjects[0].SelectRow,"eac_sts_nm") = false;	
					 sheetObjects[0].CellEditable(sheetObjects[0].SelectRow,"chk") = false;	
	        	 }else if(ofcLevel=="H"){  // 본사(심사팀) 소속
	        		 sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"eac_sts_nm") = "HQ Reject";
	        		 sheetObjects[0].CellEditable(sheetObjects[0].SelectRow,"eac_vrfy_div_cd") = false;	
	        		 sheetObjects[0].CellEditable(sheetObjects[0].SelectRow,"eac_sts_nm") = false;	
	        		 sheetObjects[0].CellEditable(sheetObjects[0].SelectRow,"chk") = false;	
	        	 }				 
				 
			 }
		 }

		/**
		 * sheet1 OnSearchEnd 이벤트
		 * @param {ibsheet} sheet 해당 시트   
		 * @param {ErrMsg}  리턴 메세지
		 */
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			for (var i=2; i<=sheetObj.LastRow; i++) {
        		if(ofcLevel=="R"){  //  RHQ 소속
        			if(sheetObj.CellValue(i,"eac_sts_cd")=="RC" || sheetObj.CellValue(i,"eac_sts_cd") == "RR"){
        				sheetObj.CellEditable(i,"chk") = false;	
        				sheetObj.CellEditable(i,"eac_vrfy_div_cd") = false;	
        			}else if(sheetObj.CellValue(i,"eac_sts_cd")=="AC"){
        				sheetObj.CellEditable(i,"chk") = true;	
        				sheetObj.CellEditable(i,"eac_vrfy_div_cd") = true;	
        			}
        		}else if(ofcLevel=="H"){  // 본사(심사팀) 소속
        			if(sheetObj.CellValue(i,"eac_sts_cd")=="HC" || sheetObj.CellValue(i,"eac_sts_cd") == "HR"){
        				sheetObj.CellEditable(i,"chk") = false;	
        				sheetObj.CellEditable(i,"eac_vrfy_div_cd") = false;	
        			}else if(sheetObj.CellValue(i,"eac_sts_cd")=="RC"){
        				sheetObj.CellEditable(i,"chk") = true;	
        				sheetObj.CellEditable(i,"eac_vrfy_div_cd") = true;		
        			}
        		}
        		
        		if(sheetObj.CellValue(i,"eac_vrfy_div_cd") != "V" && ( sheetObj.CellValue(i,"eac_sts_cd") == "AC" || sheetObj.CellValue(i,"eac_sts_cd") == "RC") ){ //결재 대상만 배경색 변경
        			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,218,185)
        		}
			}	    	
	    	
	    }
	    
		/**
		* sheet1 doubleClick후 이벤트 
		* @param {ibsheet} sheet 해당 시트   
		* @param {long} row 해당 셀의 Row Index
		* @param {long} col 해당 셀의 Column Index
		*/
		function sheet1_OnDblClick(sheetObj, Row, Col) {
			var sgName = sheetObj.ColSaveName(Col);
			if(sgName=="eac_vrfy_div_cd" || sgName =="chk") return;
			
			var eacNo = sheetObj.CellValue(Row, "eac_no");
			var pgmNo = 'ESD_EAS_0201';
			var pgmUrl = 'ESD_EAS_0201.do?';
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&EAC_NO=" + eacNo
			ComOpenPopup(pgmUrl + src, 1024, 610, "", "1,0", true, false);
		}	    
	    
	    
	    
	    
	/* 개발자 작업  끝 */