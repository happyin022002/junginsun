/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0370.js
*@FileTitle : TES Auto Audit Criterion Setting
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
	 * @class ESD_EAS_0370 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0370() {
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
			case "btn_save":
				doActionIBSheet(sheetObject,formObject, IBSAVE);
			    break;
			case "btn_downexcel":
				sheetObject.SpeedDown2Excel(true);
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
		var formObj = document.form;
		var usrId = formObj.login_usr_id.value;

//		비용심사 파트장 성범수 부장 :  사번 9100342
//  	비용심사 시스템 B/A 김대준 차장 : 사번  0010140
		if(usrId !="9100342" &&usrId!="0010140"){
			ComBtnDisable("btn_save"); // Save 버튼 비활성화
		}
		
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

	    doActionIBSheet(sheetObjects[1], formObj, "offce_level"); // RHQ
		
 		//html컨트롤 이벤트초기화
// 		initControl();
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
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
					style.height = GetSheetHeight(22);
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
					
					var HeadTitle  = "|RHQ|Cost\nGroup|Cost\nCode|F/M|Cal.\nMethod|Auto-\nAudit|Diff.\nRatio(%)|T/S|Special\nCargo\nType|Grouping|Estimation Formula|Estimation Formula|Remark|lgs_cost_full_nm";
					var HeadTitle2 = "|RHQ|Cost\nGroup|Cost\nCode|F/M|Cal.\nMethod|Auto-\nAudit|Diff.\nRatio(%)|T/S|Special\nCargo\nType|Grouping|Marine Invoice|ODCY/Storage|Remark|lgs_cost_full_nm";

					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	10,		daCenter,	false,	"ibflag",			false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++, dtData,		50,		daCenter,	true,	"aud_ofc_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,	true,	"lgs_cost_subj_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"lgs_cost_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"cntr_sty_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"cost_calc_mzd_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtCheckBox,	60,		daCenter,	true,	"expn_aud_tgt_flg",		false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daRight,	true,	"expn_max_prmt_rto",	false,          "",       dfNullFloat,    1,true,       true,  4);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"ts_flg",				false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"spcl_cgo_tp_calc_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"tpsz_grp_flg",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daLeft,		true,	"act_vvd_calc_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daLeft,		true,	"sto_prd_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,		true,	"aud_rmk",				false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtHidden,	150,	daLeft,		true,	"lgs_cost_full_nm",		false,          "",       dfNone,    0,     true,       true);
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
//				if(!validateForm(sheetObj,formObj,sAction)) {
//					return false;
//				}
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch("ESD_EAS_0370GS.do", EasFrmQryString(formObj));
				break;
				
			case IBSAVE:	// Save
				formObj.f_cmd.value = MODIFY01;
				var sParam =  ComGetSaveString(sheetObj, true, false);
				if ( sParam == "") { return;}
				var sXml = sheetObj.GetSaveXml("ESD_EAS_0370GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
				sheetObj.LoadSaveXml(sXml);
				break;			
				
			case "offce_level":    
				formObj.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        		ofcLevel = EasXmlString(sXml, "ofc_tp_cd");
        		formObj.ofclevel.value = ofcLevel;

        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		var rhqSearchFlag = true;
        		// 로그인한 RHQ OFFCD 셋팅
//        		formObj.s_aud_ofc_cd.InsertItem(0, rhq_ofc_cd, rhq_ofc_cd);
        		if (ofcLevel == "O") {
        			// 본사(심사팀) RHQ 소속이외
            		rhqSearchFlag = false;
            		formObj.s_aud_ofc_cd.Enable	= false;
            		formObj.s_aud_ofc_cd.code2 = rhq_ofc_cd;
        		} else if (ofcLevel == "R") {
        			rhqSearchFlag = false;
        			formObj.s_aud_ofc_cd.Enable	= false;
        			formObj.s_aud_ofc_cd.Index2	= 0;
        			formObj.s_aud_ofc_cd.code2	= rhq_ofc_cd;
        		} else if (ofcLevel == "H") {
        			// 본사(심사팀) 소속
            		rhqSearchFlag = true;
            		formObj.s_aud_ofc_cd.Enable	= true;
            		formObj.s_aud_ofc_cd.code2	= rhq_ofc_cd;
//            		ComBtnEnable("btn_save"); // Save 버튼 활성화
        		}
        		
        		if(rhqSearchFlag){
        			// RHQ 콤보 리스트 조회
        			formObj.s_aud_ofc_cd.RemoveAll();
        			formObj.f_cmd.value = COMMAND02;
        			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        			ComXml2ComboItem(sXml, formObj.s_aud_ofc_cd, "ofc_cd", "ofc_cd");
        			// 이폼에서는 권한 체크를 하지 않는다.
        			formObj.s_aud_ofc_cd.Text2(formObj.s_aud_ofc_cd.value);
        			formObj.s_aud_ofc_cd.InsertItem(0, "", "");
	        		// RHQ에 해당하는 Office 조회
        			doActionIBCombo(formObj.s_aud_ofc_cd);
        		}
        		
	  		break; 					
		}
	}
	
    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[0];
    	switch(comboObj.id) {
	    case "s_rhq_ofc_cd":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        ComXml2ComboItem(sXml, formObj.s_ofc_cd, "ofc_cd", "ofc_cd");
	    	break;
    	}
    }
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "s_aud_ofc_cd": 	//RHQ OFFICE
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 140;
					setComboData(comboObj);
				}
			break;
			
			case "s_lgs_cost_subj_cd": 
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 280;
					setComboData(comboObj);
				}
			break;

			case "s_cost_calc_mzd_cd":
			case "s_expn_aud_tgt_flg":
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 100;
//					ValidChar(2,1);	//영문대문자,숫자
//					MaxLength = 2;
					setComboData(comboObj);
				}
			break;
		}
	}
	
	function setComboData(comboObj, param){ 
		var comboID = comboObj.id;
		var frm = document.form;
		var sheetObj = sheetObjects[1];
		switch(comboID){
			case "s_aud_ofc_cd":
				frm.f_cmd.value = COMMAND02;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				ComXml2ComboItem(sXml, frm.s_aud_ofc_cd, "ofc_cd", "ofc_cd");
	    		comboObj.insertItem(0, "", "");
				break;
			case "s_lgs_cost_subj_cd":
				frm.f_cmd.value = COMMAND01;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0370GS.do", FormQueryString(frm));
				ComXml2ComboItem(sXml, comboObj, "lgs_cost_subj_cd", "lgs_cost_subj_cd");
	    		comboObj.insertItem(0, "", "");
				break;
			case "s_cost_calc_mzd_cd":
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Auto", "A");
				comboObj.InsertItem(2, "Manual", "M");
				break;
			case "s_expn_aud_tgt_flg":
				comboObj.InsertItem(0, "", "");
				comboObj.InsertItem(1, "Yes", "Y");
				comboObj.InsertItem(2, "No", "N");
				break;

		}
	}
	
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with (sheetObj) {
			Row = MouseRow;
			var colName = ColSaveName(MouseCol);
			if ("lgs_cost_cd" == colName) {
				MousePointer = "Hand";
				sText = CellText(Row, "lgs_cost_full_nm");
				MouseToolTipText = sText;
			} else {
				MouseToolTipText = "";
			}
		}
	}
