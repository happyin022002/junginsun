/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0310.jsp
*@FileTitle : Rehandling Expense - TOR vs. TPB
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2014.12.26 KIM HYUN JOO
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
     * @class ESD_EAS_0310 : ESD_EAS_0310 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0310() {
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
    	            cal.select(frm.s_fm_dt, "yyyy-MM-dd");
                	break;
                case "btns_calendar_e":
                	var cal = new ComCalendar();
                	cal.setDisplayType('date');
                	cal.select(frm.s_to_dt, "yyyy-MM-dd");
                	break;  			
                	
    			case "btn_eacif": // EAC transfer
    				eac_transfer(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
    				break;
    			case "btn_bkg_no":
    				popUpMultiSelectWin("s_bkg_no")
    				break;
    			case "btn_cntr_no":
    				popUpMultiSelectWin("s_cntr_no")
    				break;
    			case "btn_vvd":
    				popUpMultiSelectWin("s_vvd")
    				break;
				case "btn_port_cd":
					var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
					if(rVal){
						frm.s_port_cd.value = rVal;
						loadTerminal();
					}
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
	    // Set RHQ, Office
	    doActionIBSheet(sheetObjects[0], frm,"offce_level");
	    
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k]);
		}
		
//		frm.s_snd_fm_dt.value = ComGetDateAdd(ComGetNowInfo(),"D",-90, "-");
//		getMonthBetween(frm.s_snd_fm_dt);
		
		initControl();
	}

	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj) {
		switch(comboObj.id) {
			case "s_shift_rsn":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "BIC,QIC", "1");
				comboObj.InsertItem(2, "BIT,QIT", "2");
				comboObj.InsertItem(3, "OTHERS", "3");
				comboObj.Index2=0;
				break;
				
			case "s_tpb_flg":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Y", "Y");
				comboObj.InsertItem(2, "N", "N");
				comboObj.Index2=0;
				break;  

			case "s_eac_if":
				comboObj.RemoveAll();
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Y", "Y");
				comboObj.InsertItem(2, "N", "N");
				comboObj.Index2=0;
				break;
				
	    	case "s_trmnl_cd":		//Yard Code
	    		comboObj.MultiSelect = true; 
	    		comboObj.UseAutoComplete = true;
	    		comboObj.SetColAlign("left|left");
	    		comboObj.SetColWidth("30|340");
	    		comboObj.DropHeight = 160;
	    		break; 	
		}
	
	}	
	
	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      	, document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     	, document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm	( 'change' 	 , 'obj_change' 	, document.form );
		axon_event.addListenerFormat( 'keypress' , 'obj_keypress'	, document.form); //- 키보드 입력할때
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
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자/ '44' = ',' <- 예외 입력문자
				ComKeyOnlyAlphabet('uppernum','44');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
        	case "float":
        		ComKeyOnlyNumber(event.srcElement, "-.");
            	break;
	    }
	}
    
	
	function obj_change(){
//		var obj = event.srcElement;
//		switch(obj.name) {
//			case "s_vndr_seq":
//				vender_change();
//			break;
//			case "s_fm_dt":
//				alert("wow");
//			case "s_to_dt":
//				if(!ComChkObjValid(obj)){
//					obj.value = "";
//					obj.focus();
//				};
//			break;
//		}
	} 	
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			if(!ComChkObjValid(obj)){
				obj.value = "";
				obj.focus();
			}
			break;	
		case "s_to_dt":
			if(!ComChkObjValid(obj)){
				obj.value = "";
				obj.focus();
			}
			break;	
		
	    case "s_port_cd":
	    	if(obj.value.length == 5){
	    		loadTerminal();
	    		frm.s_trmnl_cd.focus();
	    	} else{
	    		frm.s_trmnl_cd.RemoveAll();
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
		case "s_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
//	//월에 더하기를 한다.
//	function getMonthBetween(obj) {
//		var formObj = document.form;
//		if(obj.value.length >= 8) {
//			formObj.s_to_dt.value = ComGetDateAdd(obj.value,"D", 90, "-");
//		}else{
//			formObj.s_to_dt.value = "";
//		}
//	}
	
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
	
					var HeadTitle1 = "||Seq.|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data";
					HeadTitle1 += 	 "|TOR Data|TOR Data|TOR Data|TOR Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|BL Data|EAC I/F";
	
					var HeadTitle2 = "||Seq.|Office|Port|VVD|Call IND\nSeq||Lane|ATD|CNTR No.|RESPB No.|TPSZ|POL|OPR\nCode|Precell"
					HeadTitle2 += 	 "|Position|Reason|Party|File Attached|TPB No.|Amount\n(USD)|TPB OFC|3rd Party|TPB Status|BKG No.|EAC I/F";
						
					var headCount = ComCountHeadTitle(HeadTitle1);
						
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);
						
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
	
//					HeadRowHeight = 12;
					
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 10,     daRight,   	true,   "ibflag");
					InitDataProperty(0, cnt++, 	dtRadioCheck,	30,		daCenter, 	true,	"chk");
					InitDataProperty(0, cnt++ , dtSeq,          30,  	daCenter,   true,   "seq");
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "ofc_cd",         	false,    "",      dfNone,        	0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "port_cd",      	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "vvd", 		   		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "clpt_ind_seq",   	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       60,  	daCenter,   true,   "rhnd_expn_seq",   	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         40,  	daCenter,   true,   "lane_cd",  		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "act_dep_dt",       false,    "",      dfDateYm,        0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "cntr_no",    		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "respb_cntr_no",  	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         45,  	daCenter,   true,   "sztp",         	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "pol",        		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         45,  	daCenter,   true,   "opr_cd",         	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "precell",     		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "position", 	   	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "shift_rsn",     	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         55,  	daCenter,   true,   "party", 			false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "file_atch", 		false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);					
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "tpb_no",       	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "tpb_amt_usd",      false,    "",      dfNullFloat,     2,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "tpb_ofc",   	   	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "tpb_pty_3rd",      false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "tpb_sts_nm",     	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,   "bkg_no",    	   	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "eac_if_flg",   	false,    "",      dfNone,          0,          false,        false,   0,  false, true,  "", false);
					
					//Check Box Column Header 강제 Merge 
					SetMergeCell(0, 1, 2, 0);


	    		}
				break;
	    	case 2:      //t6sheet1 init 
	    		//이 시트는 조회시에 사용되지 않지만 TOR shift_rsn 팝업창에서 OK 버튼 선택시 값을  t6sheet1시트로 리턴해주고 있어 오류를 OK시 오류 메시지를 방지하기 위하여 기술함.
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
	    		
	    		var HeadTitle1 = "|SEQ.|Reason";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		var prefix = "t6sheet1_";
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag");
	    		InitDataProperty(0, cnt++ , dtSeq,          40,  	daCenter,   true,   "seq");
	    		InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   prefix + "shift_rsn",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
	    		
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
						var sXml = sheetObj.GetSearchXml("ESD_EAS_0310GS.do", sParam);
						sheetObj.loadSearchXml(sXml);
					}
					break;

				case "btn_downexcel":	// EXCEL DOWNLOAD
//					sheetObj.SpeedDown2Excel(1);
					sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					break;

				case "offce_level":

		  			// ofcLevel, rqh_ofc_cd 값을 구한다. 
		  			frm.f_cmd.value = COMMAND01;
	        		var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        		ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
	        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
	        		var rhqSearchFlag = true;
	        		
	        		if(rhqSearchFlag){
	        			//RHQ 콤보 리스트 조회
	        			frm.s_rhq_ofc_cd.RemoveAll();
	        			frm.f_cmd.value = COMMAND02;
	        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        			ComXml2ComboItem(sXml, frm.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");
	        			// 이폼에서는 권한 체크를 하지 않는다.
		        		frm.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
		        		
		        		// RHQ에 해당하는 Office 조회
	        			doActionIBCombo(frm.s_rhq_ofc_cd)
	        		}
		  		break;  				
			}
		}

		/**
		* sheet1 Click후 이벤트 
		* @param {ibsheet} sheet 해당 시트   
		* @param {long} row 해당 셀의 Row Index
		* @param {long} col 해당 셀의 Column Index
		*/
		function sheet1_OnClick(sheetObj, Row, Col) {
			
			var bkg_no = "";
			var param =  "";
			if (sheetObj.ColSaveName(Col) == "bkg_no")	{
				// B8 Charge Tab ( from ESM_BKG_0079 : Booking Creation )
				bkg_no = sheetObj.CellValue(Row, "bkg_no");
				if (bkg_no != "" && bkg_no != null) {
					param = "pgmNo=ESM_BKG_0079&openTab=B8&bkg_no=" + bkg_no;
					ComOpenWindowCenter("ESM_BKG_0079.do?" + param, "ESM_BKG_0079", 1024, 650,true);	
				}
			}else if (sheetObj.ColSaveName(Col) == "shift_rsn") {	
				ComOpenPopupWithTarget('/hanjin/VOP_OPF_0040.do?shift_rsn=' + sheetObj.CellValue(Row, "shift_rsn"), 740, 530, "s_bkg_no:s_bkg_no", "0,1,1,1,1,1,1", true);
			}
		}
	    
	    // Combo관련 프로세스 처리
	    function doActionIBCombo(comboObj) {
	    	var sheetObj = sheetObjects[0];
	    	
	    	switch(comboObj.id) {
		    case "s_rhq_ofc_cd":  
		        frm.f_cmd.value = COMMAND03;
		        
		        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
//		        frm.s_ofc_cd.RemoveAll();
//		    	ComXml2ComboItem(sXml, frm.s_ofc_cd, "ofc_cd", "ofc_cd");
//		    	frm.s_ofc_cd.InsertItem(0, "", "");
////		    	frm.s_ofc_cd.Index=0;
//		    	frm.s_ofc_cd.code2 = frm.ofc_cd.value
//		    	doActionIBCombo(frm.s_ofc_cd)
		    	
		    	break;
		    case "s_trmnl_cd":
		    	
				//콤보필드를 초기화시킨다.
								
				frm.f_cmd.value = COMMAND01;
				// vop_pso_0002GS.do 에서 필요한 인자 port_cd="USLGB" 
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(frm)+ "&port_cd=" + frm.s_port_cd.value);
				frm.s_trmnl_cd.RemoveAll();	//Yard	
				var comboItems = ComGetEtcData(sXml, "lane").split("|");
				if (comboItems != ''){
					addComboItemTermCode(frm.s_trmnl_cd, comboItems);
				}
				break;	
	        }
	    }
		
	    /**
		 * 콤보필드에 데이터를 추가해준다.
		*/	
		function addComboItemTermCode(comboObj,comboItems) {
			comboObj.InsertItem(-1, "ALL","");
			for (var i = 0 ; i < comboItems.length ; i++) {
				var comboItem = comboItems[i].split(",");
				comboObj.InsertItem(-1, comboItem[0] + "|" + comboItem[1] , comboItem[0]);
			}   		
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

		/*
		 * 각 공통팝업창 호출 함수 
		 */
		function popUpMultiSelectWin(rtnValBoxNm) {
			
			var returntitle = '';
			var flag = ComReplaceStr(rtnValBoxNm,"s_","");
			
  			if(flag == 'bkg_no')
  				returntitle = 'BKG No.';
  			else if(flag == 'bl_no')
  				returntitle = 'B/L No.';
  			else if(flag == 'cntr_no')
  				returntitle = 'CNTR No.';
  			else if(flag == 'vvd')
  				returntitle = 'VVD.';
  			
  			var param = "?returnval=" + rtnValBoxNm + "&returntitle=" + returntitle;
  			ComOpenPopup('ESD_EAS_MULTI.do'+param, 400, 380, 'getEas_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
  			
			
//  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
//  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
		}

	    /*
	     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
	     * - 해당 필드에 멀티 입력값을 설정해준다.
	     */
	    function getEas_Multi(rArray, return_val) {
	    	var targObj = eval("document.form." + return_val);
	    	var retStr = rArray.toString().toUpperCase();
	    	
	    	ComSetObjValue(targObj, retStr);
	    }
  				
		/**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,formObj,sAction){
			switch(sAction) {
			case IBSEARCH :
				// Mandatory Item Check
				
				if(formObj.s_fm_dt.value == "" || formObj.s_to_dt.value == "" ){
					ComShowCodeMessage("COM130403", "Duration"); // S/O creation period;
					return false;
				}
				if(formObj.s_rhq_ofc_cd.Code == "" ){
					ComShowCodeMessage("COM130403", "RHQ"); // RHQ;
					return false;
				}
//				if(formObj.s_ofc_cd.Code == "" ){
//					ComShowCodeMessage("COM130403", "Office"); // Office;
//					return false;
//				}
				if (!checkPeriodValidation(formObj.s_fm_dt,formObj.s_to_dt)) {
					return false;
				}
				break;
			} // end switch()
			return true;
		}	
		
		
		// hjkim - Check Period Validation 
		function checkPeriodValidation(objFm,objTo){
			
			// from > to 
			var sFm = ComTrimAll(objFm.value, "-"); 
			var sTo = ComTrimAll(objTo.value, "-"); 
			
			if ( sFm > sTo) {
				ComShowCodeMessage("COM132002"); 	// msgs['COM132002'] = 'End date must be greater than start date';
				return false;
			}
			
			// to < fm + 1 Month
			var sMax = ComGetDateAdd(objFm.value,"M", 2, "");
			
			if ( sTo > sMax){
				ComShowCodeMessage("COM132001", "Duration","2 Month"); // msgs['COM132001'] = '{?msg1} exceeds maximum duration {?msg2}.';
				return false;
			}
			
			return true;
		}				
		
		/**
	     * Sheet 조회완료 후 이벤트 발생
	     */
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			with(sheetObj) {
				ColFontUnderline("bkg_no") = true;
				DataLinkMouse("bkg_no") = true;
				
				ColFontUnderline("shift_rsn") = true;
				DataLinkMouse("shift_rsn") = true;
			}
			
			// EAC I/F된 자료는 체크박스 비활성
			for (var idx = sheetObj.HeaderRows ; idx< sheetObj.RowCount + sheetObj.HeaderRows ; idx++) {
				if(sheetObj.CellValue(idx, "eac_if_flg") == "Y"){ 
					sheetObj.CellEditable(idx, "chk") = false;
					sheetObj.CellValue2(idx, "chk") = "";
				}
			}
			
			// CNTR 2개 이상 존재하면 Check
//			for (var idx = sheetObj.HeaderRows ; idx< sheetObj.RowCount + sheetObj.HeaderRows ; idx++) {
//				var cn = sheetObj.CellValue(idx, "cntr_no");
//				for (var idx2 = idx + 1; idx2< sheetObj.RowCount + sheetObj.HeaderRows ; idx2++) {
//					if ( cn == sheetObj.CellValue(idx2, "cntr_no") ){
//						sheetObj.RowBackColor(idx) = sheetObj.RgbColor(0,192,192);
//						sheetObj.RowBackColor(idx2) = sheetObj.RgbColor(0,192,192);
//					}
//				}
//			}
		}
	    
		/**
		 * EAC transfer
		 * Rehandling 은 EAC I/F 를 한 건씩 처리 한다.
		 */		
		function eac_transfer(sheetObj,Row,Col){
			
			// interface variable
			var chk = "";
			var cntr_no = "";
			var vvd = "";
			var cntr_tpsz = "";
			var bkg_no = "";
			var ofc_cd = "";
			var port_cd = "";
			var clpt_ind_seq = "";
			var rhnd_expn_seq = "";
			var eac_if_flg = "";
			
			//selected row
			var sRow = sheetObj.FindCheckedRow("chk");		// Select 된 Row의 index 번호를 넘겨준다. "5|9|" 			
			var arrRow = sRow.split("|");					// 실제 index 번호 + null 값이 arrRow에 assign 됨. 즉, 불필요한 값이 하나 추가된 상태
			
			//  EAC Interfce 대상으로 선택된 Row 가 없을 경우. Error
			if (arrRow.length == 1) {
				ComShowCodeMessage("COM12189");
		   		return;
			}
			
			for (var idx=0; idx < arrRow.length - 1 ; idx++){	// 마지막 불필요한 값을 실행 못하게 하기 위해 arrRow.length 에 - 1 처리.
				cntr_no = ComTrim(sheetObj.CellValue(arrRow[idx],"cntr_no"));
  				vvd = ComTrim(sheetObj.CellValue(arrRow[idx],"vvd"));
				cntr_tpsz = ComTrim(sheetObj.CellValue(arrRow[idx],"sztp"));
				bkg_no = ComTrim(sheetObj.CellValue(arrRow[idx],"bkg_no"));
				ofc_cd = ComTrim(sheetObj.CellValue(arrRow[idx],"ofc_cd"));
				port_cd = ComTrim(sheetObj.CellValue(arrRow[idx],"port_cd"));
				clpt_ind_seq = ComTrim(sheetObj.CellValue(arrRow[idx],"clpt_ind_seq"));
				rhnd_expn_seq = ComTrim(sheetObj.CellValue(arrRow[idx],"rhnd_expn_seq"));
				eac_if_flg = ComTrim(sheetObj.CellValue(arrRow[idx],"eac_if_flg"));
				
				// EAC Interfce 된 Row 가 EAC Interface 대상인 경우 Error.
				if (eac_if_flg == "Y") {
					ComShowCodeMessage("EAS90103");
					return;
				}
			}
			
			// for Data Setting 
		   	var theURL = "ESD_EAS_0224.do?p_sys_div_cd="		+ "TES"													// System 구분 : TES
										+"&p_sys_if_cd="		+ "TE2"													// System 별 interface 구분 : TE2 (Rhandle)
										+"&p_eq_knd="			+ "U"													// Container Code Setting
										+"&p_eq_no="			+ cntr_no												
										+"&p_tp_sz="			+ cntr_tpsz		
										+"&p_bkg_no="			+ bkg_no												// BKG No.
										+"&p_ofc_cd="			+ ofc_cd												// resp. office
										// for Interface Key
										+"&p_if_vvd="			+ vvd												
										+"&p_if_port_cd="		+ port_cd																							
										+"&p_if_clpt_ind_seq="	+ clpt_ind_seq											
										+"&p_if_cntr_no="		+ cntr_no												 
										+"&p_if_rhnd_expn_seq="	+ rhnd_expn_seq										
										+"&p_if_rhnd_ofc_cd="	+ ofc_cd;							

		   	var winName = "EACTransferPopup";
		   	var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:620px";			
		   	ComOpenWindow(theURL,winName,features,true);

		}		
		
		/**
		 * EAC transfer 팝업호출 및 저장 후 eac_no 선택한 Row에 셋팅.
		 */	
		function fn_setEacNo(eac_no){
			if (eac_no.length == 14) {
				var sRow = sheetObjects[0].FindCheckedRow("chk");					
				var arrRow = sRow.split("|");
				for (idx=0; idx<arrRow.length-1; idx++){ 
					sheetObjects[0].CellValue2(arrRow[idx],'eac_if_flg') = "Y";
					sheetObjects[0].CellEditable(arrRow[idx], "chk") = false;
					sheetObjects[0].CellValue2(arrRow[idx], "chk") = "";
				}
			}
		}
		
		/**
		 * Port 에 해당하는 Terminal 정보 조회
		 */
	    function loadTerminal() {
			doActionIBCombo(frm.s_trmnl_cd);
		}
	    
		function s_trmnl_cd_OnCheckClick(comboObj, index){
			if(index==0) {
			    if(comboObj.CheckIndex(index)) {
			    	for(var i = 1 ; i < comboObj.GetCount () ; i++) {
			    		comboObj.CheckIndex(i) = true;
			    	}
			    } else {
			    	for(var i = 1 ; i < comboObj.GetCount () ; i++) {
		      			comboObj.CheckIndex(i) = false;
		      		}
		      	}
			}    
		}
		 
	/* 개발자 작업  끝 */
