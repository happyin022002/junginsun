/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0221.jsp
*@FileTitle : Rejection Notice Send History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.26 백형인
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
     * @class ESD_EAS_0221 : ESD_EAS_0221 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0221() {
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
						rep_OnPopupClick();
				break;
				

                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
    	            cal.select(frm.s_snd_fm_dt, "yyyy-MM-dd");
                	break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
                	cal.select(frm.s_snd_to_dt, "yyyy-MM-dd");
                	break;  			
                case "btn_auditdetail":
                	openAuditdetail();
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
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	    doActionIBSheet(sheetObjects[1], frm,"offce_level");
	    
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}	    
		//frm.s_snd_fm_dt.value = ComGetDateAdd(ComGetNowInfo(),"D",-90, "-");
		//getMonthBetween(frm.s_snd_fm_dt);
		initControl();
	}

	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
 
			case "s_snd_tp_cd":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "FAX", "F");
				comboObj.InsertItem(2, "e-Mail", "M");
				comboObj.Index2=0;
				break;  
			case "s_snd_rslt_cd":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Success", "S");
				comboObj.InsertItem(2, "Fail", "F");
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
			case "s_snd_fm_dt":
			case "s_snd_to_dt":
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
		case "s_snd_fm_dt":
			//getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_snd_to_dt":
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
		case "s_snd_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_snd_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	//월에 더하기를 한다.
	function getMonthBetween(obj) {
		var formObj = document.form;
		if(obj.value.length >= 8) {
			formObj.s_snd_to_dt.value = ComGetDateAdd(obj.value,"D", 90, "-");
		}else{
			formObj.s_snd_to_dt.value = "";
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
				    
				    Ellipsis = true; 
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 3, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "|Seq.|EAC No.|No. of notice|S/P code|S/P Name|Send Type|Send Date/time|Send by Office|User id|User Name|Fax number|Fax status|e-Mail address|e-Mail status";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "eac_no",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "ntc_his_seq",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,   "vndr_seq",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "vndr_nm",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daLeft,     true,   "snd_tp_cd",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "ntc_snd_dt",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "cre_ofc_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,   "cre_usr_id",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,   "cre_usr_nm",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,   "rcvr_fax_no",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,   "fax_sts_nm",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,   "rcvr_eml",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "eml_sts_nm",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					
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
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0221GS.do", sParam);
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
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        		}
	        		if(ofcSearchFlag){
	        			doActionIBCombo(frm.s_ofc_cd)
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
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&EAC_NO=" + eacNo+"&READ_ONLY_FLG=N"
			ComOpenPopup(pgmUrl + src, 1024, 610, "", "1,0", true, false);
		}
		
		function openAuditdetail(){
			
			var eacNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eac_no");
			var pgmNo = 'ESD_EAS_0201';
			var pgmUrl = 'ESD_EAS_0201.do?';
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl, "/", "^") + "&EAC_NO=" + eacNo+"&READ_ONLY_FLG=N"
			ComOpenPopup(pgmUrl + src, 1024, 610, "", "1,0", true, false);			
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
		    	frm.s_ofc_cd.InsertItem(0, "", "");
//		    	frm.s_ofc_cd.Index=0;
		    	frm.s_ofc_cd.code2 = frm.ofc_cd.value
		    	doActionIBCombo(frm.s_ofc_cd)
		    	
		    	break;  
		    case "s_ofc_cd":
		    	frm.f_cmd.value = SEARCH02;
		    	var sParam = FormQueryString(frm);
		    	var sXml = sheetObj.GetSearchXml("ESD_EAS_0205GS.do", sParam);
		    	
		    	
		    	if(ofcLevel=="O"){
		    		frm.s_eac_reg_usr_id.InsertItem(0, frm.session_usr_nm.value+"("+frm.usr_id.value+")", frm.usr_id.value);
		    	}else{
		    			ComXml2ComboItem(sXml, frm.s_eac_reg_usr_id, "eac_usr_id", "eac_usr_code");
		    			frm.s_eac_reg_usr_id.InsertItem(0, "", "");
		    	}
		    	
		    	frm.s_eac_reg_usr_id.Code2=frm.usr_id.value;
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
			ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getComEnsRep', '1,0,1,1,1');
		}	  

		/**
		* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
		*/
		function getComEnsRep(rowArray){
			for(var i=0; i<rowArray.length; i++){
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
//				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
//				sheetObj.WaitImageVisible = true;
				ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
		}
		function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){   
			doActionIBCombo(frm.s_rhq_ofc_cd); // RHQ
		}	 
		
		function s_ofc_cd_OnChange(comboObj,Index_Code, Text){
			if(Index_Code!=0){
				doActionIBCombo(frm.s_ofc_cd); // Audit Office
			}else{
				frm.s_eac_reg_usr_id.RemoveAll();
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
		
		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,formObj,sAction){
			switch(sAction) {
			case IBSEARCH :
				if(formObj.s_snd_fm_dt.value == "" || formObj.s_snd_to_dt.value == ""){
					ComShowCodeMessage('COM130201', 'Entered Date'); // Entered Date 값을 입력하셔야 합니다;
					return false;
				}

				var ls_fm_dt = removeBar(formObj.s_snd_fm_dt.value);
				var ls_to_dt = removeBar(formObj.s_snd_to_dt.value);
				var days_between = ComGetDaysBetween(ls_fm_dt , ls_to_dt) ;  // 조회 기간

				if ( days_between > 365 ) {
					ComShowCodeMessage("EAS90075");
					return false;
				}
				
				break;
			} // end switch()
			return true;
		}	
		
	/* 개발자 작업  끝 */