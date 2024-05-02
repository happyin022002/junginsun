/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0228.js
*@FileTitle :  Auto Audit Statistics
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : CJH
*@LastVersion : 1.0
* 2016.02.11 CJH
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
     * @class ESD_EAS_0228 : ESD_EAS_0228 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0228() {
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
				
                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
    	            cal.select(frm.s_inv_cfm_fm_dt, "yyyy-MM-dd");
                	break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
                	cal.select(frm.s_inv_cfm_to_dt, "yyyy-MM-dd");
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
			 ComConfigSheetEas(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
		// IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
	    
	    doActionIBSheet(sheetObjects[1], frm,"offce_level");
	    getEasIbComboList(frm.s_mdl_cd , 'TES|TRS|PSO|MNR' ,  'TES|TRS|PSO|MNR' , 'ALL');  // Module
	    getEasIbComboList(frm.s_auto_expn_aud_sts_cd , 'S|F|C' ,  'Coincidence|Discrepancy|Candidate EAC' , 'ALL');  // Audit Item
	    getEasIbComboList(frm.s_eac_if_flg , 'Y|N' ,  'Yes|No' , 'ALL');  // EAC I/F

		//frm.s_inv_cfm_fm_dt.value = ComGetDateAdd(ComGetNowInfo(),"D", -30, "-");
		//frm.s_inv_cfm_to_dt.value =  ComGetNowInfo();
		initControl();
		
		//TODAY setting
  		ComSetObjValue(formObj.s_today, ComGetNowInfo("dd"));
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

	        break;
	    }
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_inv_cfm_fm_dt":
			case "s_inv_cfm_to_dt":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();
				};
				sheetObjects[0].RemoveAll();
			break;
		}
	} 	
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_inv_cfm_fm_dt":
			//getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_inv_cfm_to_dt":
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
		case "s_inv_cfm_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_inv_cfm_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		var formObj = document.form;
		if(obj.value.length >= 8) {
			formObj.s_eac_inp_to_dt.value = ComGetDateAdd(obj.value,"D", 30, "-");
		}else{
			formObj.s_eac_inp_to_dt.value = "";
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
					MergeSheet = msAll;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = false;
				    
				    //Ellipsis = true; 
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(3, 1, 10, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false) ;

					var HeadTitle1 = "|SEQ.|RHQ|Office|Auto Audit|Module|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|Audit Status|tp_cd|auto_expn_aud_sts_cd";
					var HeadTitle2 = "|SEQ.|RHQ|Office|Auto Audit|Module|Total INV & AMT|Total INV & AMT|Total INV & AMT|Total INV & AMT|Audited|Audited|Audited|Audited|Audited|No-Audit|No-Audit|No-Audit|No-Audit|tp_cd|auto_expn_aud_sts_cd";
					var HeadTitle3 = "|SEQ.|RHQ|Office|Auto Audit|Module|Case|Ratio(%)|AMT($)|Ratio(%)|Case|Ratio(%)|AMT($)|Diff AMT($)|Ratio(%)|Case|Ratio(%)|AMT($)|Ratio(%)|tp_cd|auto_expn_aud_sts_cd";

					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					InitHeadRow(2, HeadTitle3, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtData,         72, daCenter,   true,   "rhq_cd",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55, daCenter,   true,   "inv_ofc_cd",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "auto_expn_aud_sts_nm",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "mdl_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   false,   "tot_cnt",         false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        60,  daRight,    false,   "tot_cnt_per",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  daRight,    false,   "tot_amt",         	false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        60,  daRight,    false,   "tot_amt_per",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);

					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   false,   "audit_cnt",         false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        60,  daRight,    false,   "audit_cnt_per",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  daRight,    false,   "audit_amt",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  daRight,    false,   "aud_usd_diff_amt",   false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        60,  daRight,    false,   "audit_amt_per",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					
					InitDataProperty(0, cnt++ , dtData,         50,  	daRight,   false,   "no_audit_cnt",         false,    "",      dfNullInteger,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        60,  daRight,    false,   "no_audit_cnt_per",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  daRight,    false,   "no_audit_amt",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        60,  daRight,    false,   "no_audit_amt_per",         false,    "",      dfNullFloat,     2,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,     100,  daLeft,    true,   "tp_cd",         false,    "",      dfNone,     0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,        100,  daLeft,    true,   "auto_expn_aud_sts_cd",         false,    "",      dfNone,     0,          true,        true,   0,  false, true,  "", false);
					
					DataRowMerge(0) = false;
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
	    		
	    		var HeadTitle1 = "|SEQ";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
	    		InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
	    		
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
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0228GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
					}
					break;



				case "btn_downexcel":	// EXCEL DOWNLOAD
					//sheetObj.SpeedDown2Excel(1);
					//sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					sheetObjects[0].Down2Excel(-1); 
					break;
		  		case "offce_level":    
		  			frm.f_cmd.value = COMMAND01;
	        		var sXml = sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
	        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
	        		var rhqSearchFlag = false;
	        		var ofcSearchFlag = false;
	        		// 로그인한 RHQ OFFCD 셋팅
	        		frm.s_rhq_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
	        		// 로그인한 OFFCD 셋팅
	        		frm.s_ofc_cd.InsertItem(0, frm.ofc_cd.value, frm.ofc_cd.value);
	        		if(ofcLevel=="O"){
	        			// 본사(심사팀) RHQ 소속이외
	            		rhqSearchFlag = false;
	            		ofcSearchFlag = true;        			
	            		frm.s_rhq_ofc_cd.Enable=false;
	            		frm.s_ofc_cd.Enable=false;  
	            		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
	            		frm.s_ofc_cd.code2 = frm.ofc_cd.value; 
	        		}else if(ofcLevel=="R"){
	        			rhqSearchFlag = false;
	        			ofcSearchFlag = false;
	        			frm.s_rhq_ofc_cd.Enable=false;
	        			frm.s_ofc_cd.Enable=true;        			
	        			frm.s_rhq_ofc_cd.Index2=0;
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        			
	        		}else if(ofcLevel=="H"){
	        			// 본사(심사팀) 소속
	            		rhqSearchFlag = true;
	            		ofcSearchFlag = false;
	            		frm.s_rhq_ofc_cd.Enable=true;
	            		frm.s_ofc_cd.Enable=true;                		
	        		}
	    			
	        		if(rhqSearchFlag){
	        			//RHQ 콤보 리스트 조회
	        			frm.s_rhq_ofc_cd.RemoveAll();
	        			frm.f_cmd.value = COMMAND02;
	        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        			ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
	        			frm.s_rhq_ofc_cd.InsertItem(0, '', '');
	        			frm.s_rhq_ofc_cd.Index2 = 0;
	        			doActionIBCombo(frm.s_rhq_ofc_cd);
	        		}
	        		if(ofcSearchFlag){
	        			doActionIBCombo(frm.s_ofc_cd)
	        		}
	        		
		  		break;  				
			}
		}

	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	    	var sheetObj = sheetObjects[1];
	        switch(comboObj.id) {
		    case "s_rhq_ofc_cd":  
		        frm.f_cmd.value = COMMAND03;
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		    	
		        frm.s_ofc_cd.RemoveAll();
		    	ComXml2ComboItem(sXml, frm.s_ofc_cd, "ofc_cd", "ofc_cd");
		        if (comboObj.Code != "") {
			    	frm.s_ofc_cd.InsertItem(0, "ALL", "ALL");
		        }
		    	frm.s_ofc_cd.InsertItem(0, "", "");
//		    	frm.s_ofc_cd.Index=0;
		    	frm.s_ofc_cd.code2 = frm.ofc_cd.value
		    	doActionIBCombo(frm.s_ofc_cd)
		    	
		    	break;  
	        }
	    }

		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){ 
			doActionIBCombo(frm.s_rhq_ofc_cd); // RHQ
		}	 
					
		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,formObj,sAction){
			switch(sAction) {
			case IBSEARCH :
				if(formObj.s_inv_cfm_fm_dt.value == "" || formObj.s_inv_cfm_to_dt.value == ""){
					ComShowCodeMessage('COM130201', 'Entered Date'); // Entered Date 값을 입력하셔야 합니다;
					return false;
				}

				var ls_fm_dt = removeBar(formObj.s_inv_cfm_fm_dt.value);
				var ls_to_dt = removeBar(formObj.s_inv_cfm_to_dt.value);
				var days_between = ComGetDaysBetween(ls_fm_dt , ls_to_dt) ;  // 조회 기간
				if ( days_between > 365 ) {
					ComShowCodeMessage("EAS90075");
					return false;
				}
				
				break;
			} // end switch()
			return true;
		}	
		
	  	/**
	  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	  	 */
	  	function sheet1_OnSearchEnd(sheetObj,errMsg){
	  		var formObj = document.form;
	  		
	  		var colCount = sheetObj.LastCol;
	  		for (var i = 0; i < colCount; i++) {
	  			var colStr = sheetObj.ColSaveName(i);
	  			var pos = colStr.indexOf('_');
	  			var colStr2 = colStr.substr(0,pos);
	  			if (colStr2 == 'audit' || colStr2 ==  'no') { 
	  				sheetObj.ColBackColor(i) = sheetObj.RgbColor(250,220,240);
	  			}
	  		}
	  		
	  		for (var i = sheetObj.HeaderRows ; i< sheetObj.RowCount + sheetObj.HeaderRows ; i++) {
	  			if (sheetObj.CellValue(i, "tp_cd") == "2") {
	  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(244,244,186);
	  			}else if (sheetObj.CellValue(i, "tp_cd") == "3") {
	  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(226,245,240);
	  			}else if (sheetObj.CellValue(i, "tp_cd") == "4") {
	  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(220,220,120);
	  			}

	  			// 마이너스 금액은 빨간색으로 표시
	  			if (sheetObj.CellValue(i, "tot_amt") < 0) {
	  				sheetObj.CellFontColor(i, "tot_amt") = sheetObj.RgbColor(255,0,0);
	  			}
                if (sheetObj.CellValue(i, "audit_amt") < 0) {
	  				sheetObj.CellFontColor(i, "audit_amt") = sheetObj.RgbColor(255,0,0);
	  			}
                if (sheetObj.CellValue(i, "no_audit_amt") < 0) {
	  				sheetObj.CellFontColor(i, "no_audit_amt") = sheetObj.RgbColor(255,0,0);
	  			}
	  		}
	  		
	  		if(ComIsEmpty(ComGetObjValue(formObj.s_ofc_cd))){
	    		sheetObjects[0].ColHidden("inv_ofc_cd") = true;
	    	} else {
	    		sheetObjects[0].ColHidden("inv_ofc_cd") = false;
	    	}
	  	}		
		
	  	function sheet1_OnDblClick(sheetObj,Row, Col) {
			var ls_fm_dt = removeBar(frm.s_inv_cfm_fm_dt.value);
			var ls_to_dt = removeBar(frm.s_inv_cfm_to_dt.value);
			var days_between = ComGetDaysBetween(ls_fm_dt , ls_to_dt) ;  // 조회 기간

			//RHQ별 집계일 경우엔 3달간의 심사결과만 팝업 할 수 있다.
	  		if (sheetObjects[0].ColHidden("inv_ofc_cd")) {
				if ( days_between > 92 ) {
					ComShowCodeMessage("EAS90215");
					return false;
				}
	  		}
	  		
	  		var value = sheetObj.CellValue(Row, "mdl_cd");
	  		var rhq_value = sheetObj.CellValue(Row, "rhq_cd");
	  		var sParam = Array();
	  		sParam[0] = "s_popup_flg=Y";
	  		sParam[1] = "s_popup_fm_dt="+ frm.s_inv_cfm_fm_dt.value;
	  		sParam[2] = "s_popup_to_dt="+ frm.s_inv_cfm_to_dt.value;
	  		sParam[3] = "s_popup_rhq_cd="+ sheetObj.CellValue(Row, "rhq_cd");

	  		if (sheetObj.ColHidden("inv_ofc_cd")) {
	  			sParam[4] = "s_popup_inv_ofc_cd=";
	  		}else{
	  			sParam[4] = "s_popup_inv_ofc_cd="+ sheetObj.CellValue(Row, "inv_ofc_cd");
	  		}
	  		sParam[5] = "s_popup_auto_aud_sts_cd="+ sheetObj.CellValue(Row, "auto_expn_aud_sts_cd");

	  		var colStr = sheetObj.ColSaveName(Col);
	  		var pos = colStr.indexOf('_');
	  		var colStr2 = colStr.substr(0,pos);
	  		
	  		if (colStr2 == 'audit') { 
	  			sParam[6] = "s_popup_expn_aud_sts_cd=D";
	  		}else if (colStr2 == 'no') { 
	  			sParam[6] = "s_popup_expn_aud_sts_cd=N";
	  		}else{
	  			sParam[6] = "s_popup_expn_aud_sts_cd=";
	  		}

  			var winName = "AutoAuditPopup";

  			if (rhq_value != "") {
  				if (value == "TRS") {
  					var theURL = "ESD_EAS_0340.do?"+sParam.join("&");
  					var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1018px;dialogHeight:630px";
  					ComOpenWindow(theURL,winName,features,true);
  				}else if (value == "MNR") {
  					var theURL = "ESD_EAS_0360.do?"+sParam.join("&");
  					var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1018px;dialogHeight:630px";
  					ComOpenWindow(theURL,winName,features,true);
  				}else if (value == "PSO") {
  					var theURL = "ESD_EAS_0301.do?CHARGE_TYPE=1&"+sParam.join("&");
  					var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1018px;dialogHeight:630px";
  					ComOpenWindow(theURL,winName,features,true);
  				}else if (value == "TES") {
  					var theURL = "ESD_EAS_0372.do?"+sParam.join("&");
  					var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:1018px;dialogHeight:630px";
  					ComOpenWindow(theURL,winName,features,true); 	
  				}
  			}
	  	}
	  	
	/* 개발자 작업  끝 */