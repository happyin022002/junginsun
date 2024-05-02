/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0021.js
*@FileTitle : VSL SKD Inquiry by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 Jung Jinwoo
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.06.15 진마리아 CHM-201111079-01 ALPS Error 처리 요청 (Enter키 이벤트 제어)
* 2012.07.10 이혜민   CHM-201218616-01 Port SKD Inquiry 에 PFS 대비 지연 시간 컬럼 추가, short cut 기능 및 조회 기능 추가
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
* 2015.09.04 이병훈	[CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
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
	 * @class vop_vsk_0021 : vop_vsk_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0021() {
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

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 
		 var sheetObject = sheetObjects[0];
		 
		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_port":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
					break;
					
				case "btn_vsl_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND04);
					break;
					
				case "btn_lane_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
					
				case "btn_carrier_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
					break;
					
				case "btn_period1":
					var cal = new ComCalendar();
					cal.select(formObject.fm_dt, 'yyyy-MM-dd');
					break;
					
				case "btn_period2":
					var cal = new ComCalendar();
					cal.select(formObject.to_dt, 'yyyy-MM-dd');
					break;
				case "btn_GroupRegister":
					var sUrl = "/hanjin/VOP_VSK_9001.do?use_pgm_nm="+formObject.use_pgm_nm.value+"&use_pgm_desc="+formObject.use_pgm_desc.value;
					ComOpenPopupWithTarget(sUrl, 720, 465, "", "0,0", true);
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
 	 * IBCombo Object를 배열로 등록
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
		
		// Week/Month 라디오 버튼 선택에 따라 변경
		div_month.style.display="inline";
		div_week.style.display="none";
		document.form.wm_cd.value = "M";
		
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		
		//CTRL Combo Setting.
		doActionIBSheet(sheetObjects[0], document.form, COMMAND05);

		//Group Combo Setting.
		doActionIBSheet(sheetObjects[0], document.form, COMMAND09);
		
		initControl();
		
		//현재월의 첫날부터 현재일까지 셋팅.
//		document.form.fm_dt.value = ComGetNowInfo("ym") + "-01";
//		document.form.fm_dt.value = ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
//		document.form.to_dt.value = ComGetNowInfo();
		
		//당일부터 이후 한달까지 셋팅.
		document.form.fm_dt.value = ComGetNowInfo();
		document.form.to_dt.value = ComGetDateAdd(null, "M", 1);
		
		document.form.vps_port_cd.focus();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	}
	

	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) { 
	    	case "vskd_port_rhq_cd": 
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
   	    	case "usr_def_grp_nm": 
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
	    	case "vop_port_ctrl_ofc_cd":
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left");        
  					SetColWidth("50");
  					DropHeight = 160;
   		    	}
   	    		break;
   	    	case "tml_cd":
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("70|300");
  					DropHeight = 160;
//  					Enable = false;
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
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";
		
		switch(sheetID) {
			case "sheet1":      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 455;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 16, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(27, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

//					var HeadTitle = "VVD|Vessel Name|Lane\nCode|TMNL\nCode|Coastal SKD|Coastal SKD|Coastal SKD|Next Port|Next Port|P/F SKD|P/F SKD|Delay|Delay|Carrier\nCode|TMNL\nName";
//					var HeadTitle2 = "VVD|Vessel Name|Lane\nCode|TMNL\nCode|ETA|ETB|ETD|Port|ETA|ETB|ETD|Berth|Dep|Carrier\nCode|TMNL\nName";
					
					var HeadTitle  = "CTRL\nH/Q|CTRL\nOffice|Port|TMNL|Lane|VVD|Vessel Name|OPR|P/F SKD|P/F SKD|P/F SKD|Coastal SKD|Coastal SKD|Coastal SKD|PFS\nType|Design\n(TEU)|Next Port|Next Port|Delay|Delay|Delay|Major Delay (Arrival)|Major Delay (Arrival)|Major Delay (Arrival)|Major Delay (Arrival)";
					var HeadTitle2 = "CTRL\nH/Q|CTRL\nOffice|Port|TMNL|Lane|VVD|Vessel Name|OPR|ETA|ETB|ETD|ETA|ETB|ETD|PFS\nType|Design\n(TEU)|Port|ETA|Arr.|Berth|Dep.|Hours|Port|Reason|Reason";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);


					//데이터속성    [	ROW, COL,  	DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		prefix+"vskd_port_rhq_cd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		prefix+"vop_port_ctrl_ofc_cd",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,	daCenter,	true,		prefix+"pol_port",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,	daCenter,	true,		prefix+"pol_tml_cd",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,		prefix+"vsl_slan_cd",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		prefix+"vvd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		prefix+"vsl_eng_nm",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,		prefix+"carrier_cd",	false,	"",		dfNone,				0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"pf_eta",		false,	"",		dfUserFormat2,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"pf_etb",		false,	"",		dfUserFormat2,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"pf_etd",		false,	"",		dfUserFormat2,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"pol_eta",		false,	"",		dfUserFormat2,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"pol_etb",		false,	"",		dfUserFormat2,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"pol_etd",		false,	"",		dfUserFormat2,		0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,		prefix+"pf_skd_tp_cd",		false,	"",		dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,		prefix+"cntr_dzn_capa",		false,	"",		dfNullInteger,		0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,		prefix+"next_port",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	prefix+"next_eta",		false,	"",		dfUserFormat2,		0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,		prefix+"dely_eta_tm",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,		prefix+"dely_etb_tm",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,		prefix+"dely_etd_tm",	false,	"",		dfNone,				0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,		prefix+"major_dely_hr",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,	daCenter,	false,		prefix+"vsl_dlay_rsn_loc_cd",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,		prefix+"vsl_dlay_rsn_cd",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,	false,		prefix+"vsl_dlay_rmk",	false,	"",		dfNone,				0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,       200,	daLeft,	false,		prefix+"vsl_dlay_rsn_desc",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,		prefix+"pol_yard_nm",	false,	"",		dfNone,				0,			true,		true);
					
					InitUserFormat2(0, prefix+"pol_eta", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pol_etb", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pol_etd", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix+"next_eta", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pf_eta", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pf_etb", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"pf_etd", "####-##-## ##:##", "-|:" );
					
				}
				break;
				
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetID = sheetObj.id;
		var sUrl = "";
		
		switch(sAction) {

		   case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj,formObj,sXml);
				}

				break;

			case SEARCH01:				//Port Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
					
					return sXml;
				}

			case SEARCH02:				//Carrier Check
				if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value = SEARCH;
					var sParam = FormQueryString(formObj);
					var code = formObj.carrier_cd.value;
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0252GS.do?grd_nm=CD0XXXX&code="+code, sParam);
					
					return sXml;
				}
						 
				break;

			case SEARCH03:				//Vessel Check
				if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value = SEARCH03;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
					
					return sXml;
				}
						 
				break;

			case SEARCH04:				//Lane Check
				if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value = SEARCH03;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
					return sXml;
				}
						 
				break;

			case IBDOWNEXCEL:        	//엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case COMMAND01:      // Port Pop-up
				sUrl = "/hanjin/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
				break;

			case COMMAND02:      // Lane Pop-up
				sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 422, 470, "returnLaneCdHelp", "0,0", true);
				break;

			case COMMAND03:      // Carrier Pop-up
				sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD0XXXX&code_value="+formObj.carrier_cd.value;
				var rVal = ComOpenPopupWithTarget(sUrl, 500, 420, "", "0,0", true);
				returnCrrCdHelp(rVal);
				break;

			case COMMAND04:      // Vessel Code Pop-up
				sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y";
        		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
				break;

			case COMMAND05:      // Open
				formObj.f_cmd.value = SEARCH04;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
				
				var rhqCdArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
				var rhqDescArr = ("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//
				
				//CTRL Combo Setting.
				appendMultiComboItem(getComboObject("vskd_port_rhq_cd"), rhqCdArr, rhqDescArr, "", "DEF");
				break;

			case COMMAND06:      // Control Office
				formObj.f_cmd.value = SEARCH05;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
				
				var sCtrlOfc = ComGetEtcData(sXml, "ctrl_ofc_list");
				var ctrlOfcArr = null;
				if(sCtrlOfc != null && sCtrlOfc != undefined){
					ctrlOfcArr = ("ALL|"+sCtrlOfc).split("|");	//
				}
				
				//CTRL Combo Setting.
				appendMultiComboItem(getComboObject("vop_port_ctrl_ofc_cd"), ctrlOfcArr, ctrlOfcArr, "", "DEF");
				break;
				
			case COMMAND07:      //vps_port_cd
				if(validateForm(sheetObj, formObj, sAction)){
					var sXml = null;
					formObj.f_cmd.value = SEARCH04;
					var sParam = FormQueryString(formObj);
					sXml = sheetObj.GetSearchXml("VSK_COMGS.do", sParam);
					
					return sXml;
				}else{
					return "";
				}
				break;
				
			case COMMAND08:      // Date
				var sXml = null;
				formObj.f_cmd.value = SEARCH06;
				var sParam = FormQueryString(formObj);
				sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
				
				var rtnDateArr = ComGetEtcData(sXml, "rtn_date").split("~");	//
				formObj.fm_dt.value = rtnDateArr[0];
				formObj.to_dt.value = rtnDateArr[1];
				break;
				
			case COMMAND09:     //Group Combo Setting.
				formObj.usr_def_grp_nm.RemoveAll();
        	
	        	formObj.f_cmd.value = SEARCH07;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0021GS.do", sParam);
				var grNm= ComGetEtcData(sXml, "grp_nm")
				
				if(grNm != ""){
					var comboItems = ("|"+grNm).split("|");
					appendMultiComboItem(getComboObject("usr_def_grp_nm"), comboItems, comboItems, "", "DEF");
				 } 		
				break;				
		}
	}


	/*
	 * 선처리 CSR(SRM-201011796) Port 필수입력해제, 기간 제한 1년확대
	 */
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {

		case IBSEARCH:      //조회
//			if(ComIsNull(formObj.vps_port_cd.value)){
//				ComShowCodeMessage('VSK00027', "Port");
//				formObj.vps_port_cd.focus();
//				return false;
//			}
			
			if(formObj.wm_cd[0].checked){
				if (ComIsNull(formObj.fm_dt.value)) {
					ComShowCodeMessage('VSK00027', "Period(From date)");
					formObj.fm_dt.focus();
					return false;
				}
				if (ComIsNull(formObj.to_dt.value)) {
					ComShowCodeMessage('VSK00027', "Period(To date)");
					formObj.to_dt.focus();
					return false;
				}
				
				// fm_dt to_dt보다 앞선일자가 아니면 오류
				if(!checkPeriod(formObj.fm_dt, formObj.to_dt)){
					ComShowCodeMessage("VSK00025", "End date", "start date");
					return false;
				}
			}else{

				if (ComIsNull(formObj.fm_wk.value)) {
					ComShowCodeMessage('VSK00027', "Period(From)");
					formObj.fm_wk.focus();
					return false;
				}
				if (ComIsNull(formObj.to_wk.value)) {
					ComShowCodeMessage('VSK00027', "Period(To)");
					formObj.to_wk.focus();
					return false;
				}
				
				// fm_week to_week보다 앞선일자가 아니면 오류
				if(!checkPeriod(formObj.fm_wk, formObj.to_wk)){
					ComShowCodeMessage("VSK00025", "End week", "start week");
					return false;
				}
				doActionIBSheet(sheetObj, formObj, COMMAND08);
			}
			
			// 검색 기간 Check(1개월 이내에서만 검색 가능하게).
			if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
				ComShowCodeMessage("VSK00105", "1 year");
				return false;
			}
		    	
			break;
    	}

		return true;
	}
	
	/**
     * 조회 후 처리로직.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix = sheetObj.id + "_";
		if(sXml != null){
			var rootNode = VskGetXmlRootNode(sXml);
			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				if(totValue > 0){
					sheetObj.Redraw = false;
					
					var xmlYdKind = ComGetEtcData(sXml, "yd_kind");
					
					sheetObj.InitDataCombo(0, prefix+"pol_tml_cd", xmlYdKind, xmlYdKind);
					
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}else{
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	
	function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	}
    
    function usr_def_grp_nm_OnChange(formObj) {
    	var formObj = document.form;
 
		if(formObj.usr_def_grp_nm.Code != ""){
			formObj.vsl_slan_cd.value="";
			formObj.vps_port_cd.value="";
			formObj.tml_cd.RemoveAll();

	//		ComEnableObject(formObj.vsl_slan_cd, false);
	//		ComEnableObject(formObj.vps_port_cd, false);
			formObj.vsl_slan_cd.readOnly = true;
			formObj.vsl_slan_cd.className = "input2";
			formObj.vps_port_cd.readOnly = true;
			formObj.vps_port_cd.className = "input2";
			formObj.tml_cd.Enable = false;
			
		}else{
			formObj.vsl_slan_cd.value="";
			formObj.vps_port_cd.value="";
			formObj.tml_cd.RemoveAll();
			
			formObj.vsl_slan_cd.readOnly = false;
			formObj.vsl_slan_cd.className = "input";
			formObj.vps_port_cd.readOnly = false;
			formObj.vps_port_cd.className = "input";
			formObj.tml_cd.Enable = true;
		}
	}
    
	function obj_change(){
		var formObj = document.form;
		
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObj = sheetObjects[0];
	    /*******************************************************/
		try {
			var eleObj = window.event.srcElement;
			var srcName = eleObj.getAttribute("name");
			checkObj(srcName);
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
		
	}
	
	function obj_keypress(){
		var formObj = document.form;
		switch (event.srcElement.name) {
		    case "vps_port_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
				
		    case "carrier_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
				
		    case "fm_dt":
		    	ComKeyOnlyNumber(formObj.fm_dt);
				break;
				
		    case "to_dt":
		    	ComKeyOnlyNumber(formObj.to_dt);
				break;
				
		    case "fm_wk":
		    	ComKeyOnlyNumber(formObj.fm_wk);
		    	break;
		    	
		    case "to_wk":
		    	ComKeyOnlyNumber(formObj.to_wk);
		    	break;
		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "vps_port_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.vsl_cd.focus();
		    	}
				break; 
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.vsl_slan_cd.focus();
		    	}
				break; 
		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.carrier_cd.focus();
		    	} 
		    case "carrier_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.type_cd[0].focus();
		    	}
				break;
		}
	}
	
	function obj_activate() {
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
			case "fm_wk":
			case "to_wk":
				ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
				event.srcElement.select();
				break;
		}
	}
	
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_dt":
			case "to_dt":
			case "fm_wk":
			case "to_wk":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
	
	function obj_keydown() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		//Enter event
		if(keyValue == 13){
			var flg = 0;
			var srcName = event.srcElement.name;
			switch(srcName){
			
				case "fm_dt":
				case "to_dt":
				case "fm_wk":
				case "to_wk":
				case "vps_port_cd":
				case "vsl_cd":
				case "vsl_slan_cd":
				case "carrier_cd":
					
					if(!checkObj(srcName)){
						flg = 1;
					}
					break;

			}
			//올바르지 않은 조회조건을 넣었을 때는 조회하지 않는다.
			if(flg != 1){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}
	

	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
	
	/**
	 * [Port] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value = rtnDatas[2];
					formObj.loc_cd.value = rtnDatas[2];
					
					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.vps_port_cd.value = "";
						formObj.vps_port_cd.focus();
					}else{
						formObj.country_cd.value = rtnDatas[2];
						var rtnXml = doActionIBSheet(sheetObj, formObj, COMMAND07);	// Terminal Code 가져온다.
						setTmlCdCombo(rtnXml);
					
						formObj.tml_cd.focus();
//						formObj.fm_dt.focus();
					}
				}
			}
		}
	}
	
	/**
	 * [Lane Code] Button Click 후 Pop-up에서 호출.
	 * @param rtnObjs
	 * @return
	 */
	function returnLaneCdHelp(rtnObjs){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_slan_cd.value = rtnDatas[1];
				}
			}
		}
		
	}
    
	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 처리.
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj = document.form;
    	
    	if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value = rtnDatas[1];
				}
			}
    	}
    }
	
	/**
	 * [Carrier Code] 입력 받은 Carrier Code 를 Setting.
	 * @param sCrrCd
	 * @return
	 */
	function returnCrrCdHelp(sCrrCd){
		var formObj = document.form;
		
		if(sCrrCd != null && sCrrCd != undefined && sCrrCd != ""){
			formObj.carrier_cd.value = sCrrCd;
		}else{
			formObj.carrier_cd.value = "";
		}
	}
	
	/**
     * Port Code 존재여부에 따라 화면 제어
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	var chkPort = ComGetEtcData(sXml, "check_port");
    	
		if(chkPort == "X"){
			return true;
		}else{
			if(!ComIsNull(formObj.loc_cd.value)){
				//해당 Port({?msg1})가 존재하지 않습니다.
				ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
				
				formObj.loc_cd.value = "";
			}
			
		}
		
		return false;
    }
    
    /**
     * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
    	
    	if(ComChkLen(formObj.vsl_cd, 4) == 2){
			var sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
			var chkVslCd = ComGetEtcData(sXml, "vsl_chk");
			if(chkVslCd == "Y"){
	    		//MDM_VSL_CNTR 에 Vessel Code가 존재
	    		return true;
	    	}else{
	    		sheetObj.LoadSearchXml(sXml);
	    		formObj.vsl_cd.value = "";
	    		return false;
	    	}
    	}else{
    		ComShowCodeMessage("COM12114", "Vessel Code");
    		formObj.vsl_cd.value = "";
			return false;
    	}
	}
    
    /**
     * Lane Code가 유효한지 조회한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslSlanCd(sheetObj, formObj){
    	if(formObj.vsl_slan_cd.value == null || formObj.vsl_slan_cd.value == undefined || formObj.vsl_slan_cd.value == "") return false;

    	if(ComChkLen(formObj.vsl_slan_cd, 3) == 2){
			var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
			var chkLane = ComGetEtcData(sXml, "checkLane");
			if(chkLane == null || chkLane == undefined || chkLane == ""){
	    		sheetObj.LoadSearchXml(sXml);
	    		formObj.vsl_slan_cd.value = "";
	    		return false;
	    	}else{
	    		return true;
	    	}
    	}else{
    		ComShowCodeMessage("COM12114", "Lane Code");
    		formObj.vsl_slan_cd.value = "";
			return false;
    	}
	}
    
    /**
     * Carrier Code가 유효한지 조회한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckCarrierCd(sheetObj, formObj){
    	if(formObj.carrier_cd.value == null || formObj.carrier_cd.value == undefined || formObj.carrier_cd.value == "") return false;
    	
    	if(ComChkLen(formObj.carrier_cd, 3) == 2){
    		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
    		var crrCd = ComGetEtcData(sXml, "crr_cd");
    		if(crrCd == null || crrCd == undefined || crrCd == ""){
    			ComShowCodeMessage('VSK00021', formObj.carrier_cd.value);
    			formObj.carrier_cd.value = "";
    			return false;
    		}else{
    			return true;
    		}
		}else{
			ComShowCodeMessage("COM12114", "Carrier Code");
			formObj.carrier_cd.value = "";
			return false;
		}
    }
    /**
    * 로우를 더블클릭 했을 때 이벤트 처리
 	*/ 
	function sheet1_OnDblClick(sheetObj,Row,Col,Value) {
//		var formObj = document.form;
		var prefix 		= "sheet1_";
		
		sheetObj.ShowDebugMsg = false;
		
		var vvd 		= sheetObj.CellValue(Row, prefix+"vvd");
		var vsl_cd 		= vvd.substr(0,4);
		var skd_voy_no 	= vvd.substr(4,4);
		var skd_dir_cd 	= vvd.substr(8,1);
		
		/* =====================================================================
		 * Column "PFS Type" : P/F SKD Type 팝업화면 생성 
		 * "PFS Type" 이외       : Vessel Schedule Inquiry by V.V.D 팝업화면 생성
		 * =====================================================================
		 */
		
		var sColGubun	= sheetObj.ColSaveName(Col);
		var sPfSkdTpCd	= sheetObj.CellValue(Row,Col);
		
		if(sColGubun == "sheet1_pf_skd_tp_cd" && (sPfSkdTpCd == "" || sPfSkdTpCd == undefined)){
			return false;
		}else if(sColGubun == "sheet1_pf_skd_tp_cd" && sPfSkdTpCd != "" && sPfSkdTpCd != undefined){
			
			 var v_display 	= "0,0";
			 var laneCd 	= sheetObj.CellValue(Row,"sheet1_vsl_slan_cd");
			 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0004.do?vsl_slan_cd='+laneCd+'&pf_skd_tp_cd='+sPfSkdTpCd+'&read_only=Y', 1024, 555, "", v_display, true);			
			
		}else{
			var url = "/hanjin/VOP_VSK_0019.do?vsl_cd="+ vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd;
			var rtnObj = ComOpenPopup(url, 1010, 655, "", "0,0", true);			
		}

	}    
    
    /**
     * 마우스가 이동될 때 이벤트 처리 
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var Row = sheetObj.MouseRow;
    	var Col = sheetObj.MouseCol;
    	var ydText = sheetObj.CellText(Row, sheetObj.id + "_pol_yard_nm");
    	var dlyText = sheetObj.CellText(Row, sheetObj.id + "_vsl_dlay_rsn_desc");
    	
    	// TMNL Code 셀에서 POL YARD Name 툴팁이 뜨게 한다.
    	if(Row > 1 && Col == sheetObj.SaveNameCol(sheetObj.id + "_pol_tml_cd")){
    		sheetObj.MouseToolTipText = ydText;	
    		sheetObj.MousePointer = "Hand";
    		
    	// Delay Code 셀에서 Delay Desc. Tooltip이 뜨게 한다.
    	}else if(Row > 1 && Col == sheetObj.SaveNameCol(sheetObj.id + "_vsl_dlay_rsn_cd")){
    		sheetObj.MouseToolTipText = dlyText;	
    		sheetObj.MousePointer = "Hand";
    	}else{
    		sheetObj.MouseToolTipText = "";
    		sheetObj.MousePointer = "Default";	
    	}
    	
    }  
    
 	function checkObj(srcName){
		var formObj = document.form;
		
	    var sheetObj = sheetObjects[0];
        switch(srcName) {
            case "vps_port_cd":
            	var portCd = formObj.vps_port_cd.value;
            	if(portCd != ""){
            		formObj.loc_cd.value = portCd;
					var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.vps_port_cd.value = "";
						formObj.vps_port_cd.focus();
						return false;
					}else{
						formObj.country_cd.value = formObj.vps_port_cd.value;
						var rtnXml = doActionIBSheet(sheetObj, formObj, COMMAND07);	// Terminal Code 가져온다.
						setTmlCdCombo(rtnXml);
						
						formObj.tml_cd.focus();
						return true;
					}
            	}else{
            		appendMultiComboItem(getComboObject("tml_cd"), "", "", "", "DEF");
            	}
            	break;
            	
            case "vsl_cd":
            	if(isCheckVslCd(sheetObj, formObj)){
            		formObj.vsl_slan_cd.focus();
            		return true;
            	}else{
            		formObj.vsl_cd.focus();
            		return false;
            	}
            	
            	break;

            case "vsl_slan_cd":
            	if(isCheckVslSlanCd(sheetObj, formObj)){
            		formObj.carrier_cd.focus();
            		return true;
            	}else{
            		formObj.vsl_slan_cd.focus();
            		return false;
            	}
            	
            	break;
            	
        	case "carrier_cd":
        		if(isCheckCarrierCd(sheetObj, formObj)){
        			formObj.type_cd[0].focus();
        			return true;
            	}else{
            		formObj.carrier_cd.focus();
            		return false;
            	}
        		
        		break;
                
        	case "fm_dt":
        		var fmDt = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
        		if(formObj.fm_dt.value == fmDt){
        			return true;
        		}else{
        			formObj.fm_dt.value = fmDt;
        			return false;
        		}
               	break;
               	
            case "to_dt":
            	var toDt = ComGetMaskedValue(formObj.to_dt.value, "ymd")
            	if(formObj.to_dt.value == toDt){
        			return true;
        		}else{
        			formObj.to_dt.value = toDt;
        			return false;
        		}
               	break;
               	
            case "fm_wk":
            	var fmWk = ComGetMaskedValue(formObj.fm_wk.value, "yw");
            	if(formObj.fm_wk.value == fmWk){
            		return true;
            	}else{
            		formObj.fm_wk.value = fmWk;
            		return false;
            	}
            	break;
            	
            case "to_wk":
            	var toWk = ComGetMaskedValue(formObj.to_wk.value, "yw")
            	if(formObj.to_wk.value == toWk){
            		return true;
            	}else{
            		formObj.to_wk.value = toWk;
            		return false;
            	}
            	break;
                
        } // end switch
	}
 	
	function checkPeriod(fromDate, toDate){
		var fmDt = ComReplaceStr(fromDate.value, "-", "");
		var toDt = ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}
	
	function wm_change( kind ){
	    var formObj = document.form;
		if ( kind == "0" ){// Month
			document.getElementById("div_month").style.display= "inline";
			document.getElementById("div_week").style.display= "none";
			document.form.wm_cd[0].checked= true;
		}else if ( kind == "1" ){// Week
			document.getElementById("div_month").style.display= "none";
			document.getElementById("div_week").style.display= "inline";
			document.form.wm_cd[1].checked= true;
		}
	}
 	
 	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
		comboObj.RemoveAll();
		
		if(optionCdArr != null){
			if(sFlag == "DEF"){
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}else{
				for(var i=0; i<optionCdArr.length; i++) {
					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
				}
			}
	    	
			comboObj.Code2 = selCode;
		}
	}
    
    /**
     * combo id 로 해당 comboObject를 찾아 반환한다.
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt = comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].id == comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	
    	return null;
    }
    
    /*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	
	function vskd_port_rhq_cd_OnChange(comboObj, Index_Code, Text) {
		doActionIBSheet(sheetObjects[0], document.form, COMMAND06);
	}	
	
	/**
	 * Tml Cd Combo를 Setting.
	 * @return
	 */
	function setTmlCdCombo(sXml){
		if(sXml == null || sXml == undefined || sXml == ""){
			return;
		}
		
		var ydCd = ComGetEtcData(sXml, "yd_cd");
		var ydNm = ComGetEtcData(sXml, "yd_nm");

		var ydTxtArr = new Array();
		var ydCdArr = ("ALL|"+ ydCd).split("|");
		var ydNmArr = ("ALL|"+ ydNm).split("|");
		var ydCnt = ydCdArr.length;
		
		ydTxtArr[0] = ydCdArr[0] + "|" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxtArr[i] = ydCdArr[i] + "|" + ydNmArr[i];
		}
		appendMultiComboItem(getComboObject("tml_cd"), ydCdArr, ydTxtArr, "", "DEF");
	}
	
	/**
	 * CTRL Office - ALL 선택시 전체 체크
	 */
	function vop_port_ctrl_ofc_cd_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "ALL") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }
	
	/**
	 * TMNL Code - ALL 선택시 전체 체크
	 */
	function tml_cd_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "ALL") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
    	   comboObj.CheckIndex(0) = false;
       }
    }
    
	/* 개발자 작업  끝 */