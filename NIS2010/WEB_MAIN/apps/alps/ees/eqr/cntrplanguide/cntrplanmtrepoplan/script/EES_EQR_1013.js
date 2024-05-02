/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_EQR_1013.js
 *@FileTitle : Empty Repo Plan.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.5.27
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2013.05.27 SHIN DONG IL
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
	 * @class EES_EQR_1013 : EES_EQR_1013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_EQR_1013() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	var comboObjects = new Array();
	var comboCnt 	 = 0 ;
	var comObjects   = new Array();
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;

    /**
     * 초기 이벤트 등록 
     */
    function initControl() {
         //axon_event.addListener('keydown', 'ComKeyEnter', 'form'); //엔터키 조회 이벤트처리 
    } 
	
	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
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
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage(mainPage) {
		
//		// 임시 조치 S 
//		alert("Under Construction. \nWill open at this Friday.");
//		if (document.form.usr_id.value != '2012502' &&
//			document.form.usr_id.value != '2007812' &&
//			document.form.usr_id.value != '2007809' &&
//			document.form.usr_id.value != '9102273' &&
//			document.form.usr_id.value != '0560082') {
//				 
//			parent.location.href = "/hanjin/alpsMain.screen?parentPgmNo=EES_EQR_M001";
//			return false;
//		}
//		// 임시 조치 E
		
		var formObj = document.form;
		
		//Trade, Sub Trade, Lane Multi Select ComboBox
		searchOptionTrade("trade", true, true,"","","",true);
		searchOptionSubTrade("subtrade", true, true,"","","","",true);
		searchOptionLane("lane",true, true,"","","","","",true);
	
	    for(i=0;i<sheetObjects.length;i++){
	    	//시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
			//마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	    }
		initControl();
	
		// multi combo box setting
		for(var p=0; p< comboObjects.length; p++) {
	    	initCombo(comboObjects[p], p+1);
		}
		
	
		//Trade Combo비활성화.
	//	comboObjects[0].Enable = false;
		//화면 권한 제어
		if (mainPage == "true"){
			ComBtnEnable("btn_save");
		} else {
			ComBtnDisable("btn_save");
		}
	
		//CNTR TY/SZ DRY로 설정
		formObj.cntr_tpsz_cd.value = ("D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4,A5").toLowerCase();
//		var consTpsz               = "D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4,A5";
		
		formObj.tpsz.value ="D";
		tpszChange("D");
		
		formObj.s_eff_st_dt.value  = formObj.h_eta_fm_dt.value;
		formObj.s_eff_end_dt.value = formObj.h_eta_to_dt.value;
	
		var h_ofc_tp_cd = formObj.h_ofc_tp_cd.value;
		if (h_ofc_tp_cd != "HQ" && h_ofc_tp_cd != "QT" && h_ofc_tp_cd != "HT" && h_ofc_tp_cd != "AF" && h_ofc_tp_cd != "HO"){
			formObj.rcc_cd.value = formObj.h_rcc_cd.value;
			ComEnableObject(formObj.rcc_cd,false);
		}
		
		chg_dt_tp();
		
		sheetObjects[0].ExtendLastCol = false; 
		sheetObjects[1].ExtendLastCol = false; 
		
		setPlanSelCond();
		setInfoSelCond();
	}
	
	function processButtonClick() {
		
		var sheetObject = sheetObjects[0];
	
		/** **************************************************** */
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObj,IBSEARCH);
				break;

				case "btn_info_sel":
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC01);
				break;
				
				case "btn_save":
//				    if (validateSave()){
				    	doActionIBSheet(sheetObject, formObj, MULTI);
//					}
				break;
	
				case "btn_new":
					init_form();//화면 초기화.
				break;
	
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
	
				case "btns_calendar_eff_dt":
					if (!formObj.btns_calendar_eff_dt.disabled){
						var cal = new ComCalendarFromTo();
		                cal.select(formObj.s_eff_st_dt, formObj.s_eff_end_dt, 'yyyy-MM-dd');
					}
	            break;
	
				case "btns_calendar_fcbf_dt":
					if (!formObj.btns_calendar_fcbf_dt.disabled){
						var cal = new ComCalendarFromTo();
		                cal.select(formObj.s_fcbf_st_dt, formObj.s_fcbf_end_dt, 'yyyy-MM-dd');
					}
	            break;
	
				case "btn_loc_cd_second":
	    			if (formObj.rcc_cd.value!=null && formObj.rcc_cd.value!='') {
						var code_type = formObj.loc_tp_cd_second.value;
						if (code_type.substr(0,1) == "E"){
							ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd_second", "0,1,1,1,1,1", true);
						} else if(code_type.substr(0,1) == "L"){	
							ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd_second", "0,1,1,1,1,1", true);
					    } else if(code_type.substr(0,1) == "S"){
					    	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd_second", "0,1,1,1,1,1", true);
					    }
	    			}
	            break;

				case "btn_vvd_result":
					doActionIBSheetVvdResult(sheetObject,formObj,IBSEARCH);
				break;

								
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				alert("지금은 사용하실 수가 없습니다 ");
			} else {
				alert(e);
			}
		}
	}
	
	function rcc_cd_onchange() {
		ComEnableObject(document.form.loc_cd_second,  	  true);
		ComEnableObject(document.form.btn_loc_cd_second,  true);  // Location 돋보기창 활성화
		document.getElementById("loc_cd_second").className = "input";
		document.getElementById("loc_cd_second").focus();
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	
	    switch(sAction) {
	    	case IBSEARCH:      //조회
	    		ComOpenWait(true);
	    		var vvd;
				if (formObj.s_vvd_cd.value!=null && formObj.s_vvd_cd.value!=''){
					vvd = formObj.s_vvd_cd.value;
				} else {
					vvd = comboObjects[4].Code;
				}
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				
				if (vvd!=null && vvd!=''){
					formObj.f_cmd.value = SEARCH04;
					var param = 'vvd_retrieve_val='+vvd+'&'+FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("EES_EQR_1013GS2.do",param);
					sheetObj.LoadSearchXml(sXml);
					
//					formObj.f_cmd.value = SEARCH05;
//					var param = 'vvd_retrieve_val='+vvd+'&'+FormQueryString(formObj);
//					var sXml = sheetObjects[1].GetSearchXml("EES_EQR_1013GS.do",param);
//					sheetObjects[1].LoadSearchXml(sXml);
					
//					var arrXml = sXml.split("|$$|");
//					sheetObj.LoadSearchXml(arrXml[0]);
				}else{
					ComShowCodeMessage("EQR01034");// "Please put VVD first or select VVD after hitting 'VVD search' button for the filtering condition."
				}
				ComOpenWait(false);
				break;

	    	case IBSEARCH_ASYNC01:      //조회
    			ComOpenWait(true);

				if (sheetObjects[0].RowCount >0){
					var vvd = sheetObjects[0].CellValue(sheetObjects[0].RowCount,'vvd_cd');
					
					var trd_cd = sheetObjects[0].CellValue(sheetObjects[0].RowCount,'trd_cd');
					var sub_trd_cd = sheetObjects[0].CellValue(sheetObjects[0].RowCount,'sub_trd_cd');
					var slan_cd = sheetObjects[0].CellValue(sheetObjects[0].RowCount,'slan_cd');
					var rlane = (slan_cd + trd_cd).substring(0,5);
					var eff_eta_dt = sheetObjects[0].CellValue(sheetObjects[0].RowCount,'eff_eta_dt');
					var polcds = findPols(sheetObj);
					if (vvd!=null && vvd!='' && trd_cd!=null && trd_cd!='' && slan_cd!=null && slan_cd!=''){
						rlane = (slan_cd + trd_cd).substring(0,5);
						formObj.f_cmd.value = SEARCH05;
						var param = 's_eta_dt='+eff_eta_dt+'&trade='+trd_cd+'&subtrade='+sub_trd_cd+'&s_vvd_cd='+vvd+'&rlane='+rlane+'&s_pol_cd='+polcds+'&'+FormQueryString(formObj);
						var sXml = sheetObjects[1].GetSearchXml("EES_EQR_1013GS.do",param);
						
						//initSheet(sheetObjects[1], 2);
						sheetObjects[1].LoadSearchXml(sXml);
					}
				}
				ComOpenWait(false);
				break;
			
	    	case MULTI:	// Save
	    		ComOpenWait(true);
	    		var tmp_row_sts;
		   		var temp_tpsz_vals = '';
	    		var headCnt = sheetObj.HeaderRows;
	    		for (var i=headCnt; i<=sheetObj.LastRow; i++){
		   			temp_tpsz_vals = '';
		   			if (sheetObj.CellValue(i,"pod_yd_cd")!='+' && sheetObj.CellValue(i,"pod_yd_cd")!='-'){
			   			for (var j=0; consTpszArr!=null && j<consTpszArr.length; j++) {
					 		temp_tpsz_vals += (j>0?'#':'') + (ComIsNull(sheetObj.CellValue(i,"mty_lodg_"+(consTpszArr[j]).toLowerCase()))?'0':sheetObj.CellValue(i,"mty_lodg_"+(consTpszArr[j]).toLowerCase()));
						}
			   			tmp_row_sts = sheetObj.RowStatus(i);
						sheetObj.CellValue2(i,"mty_lodg_tpsz_vals") = temp_tpsz_vals;
						sheetObj.RowStatus(i) = tmp_row_sts;
		   			}
		   		}
	    		formObj.f_cmd.value = MULTI;
	    		var param = sheetObj.GetSaveString(true,false);
	    		param = param + "&" + FormQueryString(formObj);
//		   		if (!confirm(param)){
//		   			break;
//		   		}
				var sXml = sheetObj.GetSaveXml("EES_EQR_1013GS2.do", param);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
		   		break;
	
	       case IBDOWNEXCEL:   //엑셀 다운로드
	       		ComOpenWait(true);
	       		if (sheetObj.RowCount >0){
		       		sheetObj.SpeedDown2Excel(-1);
				} else {
					ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
				}
				ComOpenWait(false);
	       		break;
	    }
	}

	function doActionIBSheetVvdResult(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	       case IBSEARCH:
				
				// 조회 기간 validation 체크
				var chkPeriod = 0;
				if(formObj.s_dt_tp_cd[0].checked){ // ETA
					if( !ComIsDate(formObj.s_eff_st_dt.value) || !ComIsDate(formObj.s_eff_end_dt.value) ){
						ComShowCodeMessage("EQR01101","pefiod"); // 'Please input {?msg1}.'
						return false;
					}
					chkPeriod = ComGetDaysBetween(formObj.s_eff_st_dt.value,formObj.s_eff_end_dt.value);	
				}else if(formObj.s_dt_tp_cd[1].checked){ // FCBF
					if( !ComIsDate(formObj.s_fcbf_st_dt.value) || !ComIsDate(formObj.s_fcbf_end_dt.value) ){
						ComShowCodeMessage("EQR01101","pefiod"); // 'Please input {?msg1}.'
						return false;
					}
					chkPeriod = ComGetDaysBetween(formObj.s_fcbf_st_dt.value,formObj.s_fcbf_end_dt.value);	
				}
				if(chkPeriod > 30){ // 30 일 초과
					ComShowCodeMessage("EQR01106","30 days"); // 'Maximum period is {?msg1}.'
					return false;
				}
				
				ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("EES_EQR_1013GS.do", sParam);
				var vvd_cd  = ComGetEtcData(sXml,"vvd_cd");
				var vvd_result  = ComGetEtcData(sXml,"vvd_rslt");
				comboObjects[4].RemoveAll();
				if (vvd_cd!=null && vvd_cd!=''){
					var tmp_vvd_cd = '';
					var tmp_vvd_result = '';
					if (vvd_cd != undefined && vvd_cd != null) {
						tmp_vvd_cd = vvd_cd.split('|');
					}
					if (vvd_result != undefined && vvd_result != null) {
						tmp_vvd_result = vvd_result.split('|');
					}
					for (var i=0; tmp_vvd_cd!=null && i<tmp_vvd_cd.length; i++){
						comboObjects[4].InsertItem(i, new String(tmp_vvd_result[i]), new String(tmp_vvd_cd[i]));
					}
				}
				ComOpenWait(false);
						
				document.form.vvdrslt.backcolor = "#FFFFA2"; // 1초간 콤보 노란색으로 표시
				setTimeout('document.form.vvdrslt.backcolor = "#CCFFFD";',1000); // 1초 뒤 아쿠아 색으로 	
				break;
	    }
	}
	
	/**
	 * 조회 조건 유효성 체크
	 */
	function validateForm() {
		var formObj = document.form;
		var rtn_val = true;
	
		return rtn_val;
	}
	
	/**
	 * 저장시 유효성 체크
	 */
	function validateSave() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var row_cnt = sheetObj.RowCount;
		var rtn_val = true;
		var cnt = 0;
		var str_cfm_flg = "";
		return rtn_val;
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo){
		var cnt = 0;
	
		switch (sheetNo) {
			case 1: // sheet1 init
				with (sheetObj) {
	
					// 높이 설정
					style.height = 350;
					
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
	
					// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
//					MergeSheet = msPrevColumnMerge;
//					MergeSheet = msAll;
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
//					EditableColorDiff = false;
	
					SpaceDupCheck = true;
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 50);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//					var col_cnt = 18+eval(consTpszArr.length)+3+eval(consTpszArr.length*2)+3+eval(consTpszArr.length)+15;
//					var col_cnt = 18+eval(consTpszArr.length)+3+eval(consTpszArr.length*2)+3+eval(consTpszArr.length)+16; //ofc_rcc_cd 추가, 2013-12-13
					var col_cnt = 18+eval(consTpszArr.length)+3+eval(consTpszArr.length*2)+3+eval(consTpszArr.length)+18; //ofc_lcc_cd, loc_lcc_cd 추가, 2013-12-20
					InitColumnInfo(col_cnt, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(false, false, false, true, false, false);
					
					//============ Set Header 0 ============ 
					var HeadTitle0 = "Trade|Sub|LANE|VVD|POL|ETA|ETD|FCBF Date\n(YYYY-MM-DD)|avl|avl|Available|Available|MT Plan|MT Plan|MTY Loading Plan|MTY Loading Plan|MTY Loading Plan|MTY Loading Plan";
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle0 = HeadTitle0+"|MTY Loading Plan"; //MT LOADING PLAN
					}
					HeadTitle0 = HeadTitle0+"|MTY Loading Plan|POD|POD2"
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle0 = HeadTitle0+"|Guideline"; //Guideline Priority/Percent
						HeadTitle0 = HeadTitle0+"|Guideline"; //Guideline Unit
					}
					HeadTitle0 = HeadTitle0+"|Guideline|MTY BKG|MTY BKG";
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle0 = HeadTitle0+"|MTY BKG"; //MTY BKG
					}
					HeadTitle0 = HeadTitle0+"|ShotFall Reason|ShotFall Reason|Remark|etd_past_flg|eff_eta_dt|cre_ofc_cd|cre_conti_cd|aloc_hc_calc_qty|aloc_45ft_calc_qty|pol_rcc_cd|pol_conti_cd|mty_vvd_cd|tpszvals|Sts|level";
					
					//============ Set Header 1 ============ 
					var HeadTitle1 = "Trade|Sub|LANE|VVD|POL|ETA|ETD|FCBF Date\n(YYYY-MM-DD)|Teu|Ton|Teu|Ton|Teu|Ton|Teu|Box|F.CBF|F.CBF";
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];
					}
					HeadTitle1 = HeadTitle1+"|BKG Plan|POD|POD2";
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];//Guideline Priority/Percent
						HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];//Guideline Unit
					}
					HeadTitle1 = HeadTitle1+"|Remark|TEU|BOX";
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];//MTY BKG
					}
					HeadTitle1 = HeadTitle1+"|Type1|Type2|Remark|etd_past_flg|eff_eta_dt|cre_ofc_cd|cre_conti_cd|aloc_hc_calc_qty|aloc_45ft_calc_qty|pol_rcc_cd|pol_conti_cd|mty_vvd_cd|tpszvals|Sts|level";
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
	
					HeadRowHeight = 28; // Head Row 높이 고정
					
					FrozenCols = 7;
					
					// 데이터속성 [   ROW, COL, DATATYPE,       WIDTH,DATAALIGN,	COLMERGE,  SAVENAME,	  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData, 			40,	daCenter ,	true,  "trd_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			40, daCenter ,	true,  "sub_trd_cd", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			40, daCenter , 	true,  "slan_cd",			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData,			80, daCenter, 	true,  "vvd_cd",			false, "", 		dfNone,     0,false, 	false);
					InitDataProperty(0, cnt++, dtData,			70, daCenter, 	true,  "pol_yd_cd",			false, "", 		dfNone,     0,false, 	false);
					InitDataProperty(0, cnt++, dtData,			80, daCenter, 	true,  "eta_dt",			false, "", 		dfNone,  	0,false, 	false);
					InitDataProperty(0, cnt++, dtData,			80, daCenter, 	true,  "etd_dt",			false, "", 		dfNone,  	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			90, daCenter , 	true,  "fnl_cbf_dt", 		false, "", 		dfDateYmd, 	0,true, 	true); //
					InitDataProperty(0, cnt++, dtHidden, 		58, daRight, 	true,  "avl_teu",  			false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 		58, daRight, 	true,  "avl_ton",  			false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			58, daRight, 	true,  "show_avl_teu",  	false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			58, daRight, 	true,  "show_avl_ton",  	false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			58, daRight, 	true,  "mty_pln_teu",  		false, "", 		dfInteger, 	0,isMainPage, 	isMainPage, 6);
					InitDataProperty(0, cnt++, dtData, 			58, daRight, 	true,  "mty_pln_ton",  		false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			45, daRight, 	true,  "mty_lodg_pln_teu",	false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			45, daRight, 	true,  "mty_lodg_pln_ton",	false, "", 		dfInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			90, daCenterTop,true,  "fnl_cbf_flg", 		false, "", 		dfNone, 	0,isMainPage, 	isMainPage);
					InitDataProperty(0, cnt++, dtHidden, 		90, daCenterTop,true,  "fnl_cbf_flg2", 		false, "", 		dfNone, 	0,isMainPage, 	isMainPage);
					for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				 		InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false, "mty_lodg_"+(consTpszArr[i]).toLowerCase(),  		false, "", dfNullInteger, 	0,isMainPage, isMainPage, 6 );
					}
					InitDataProperty(0, cnt++, dtData, 			70, daCenterTop, 	true,  "mty_pln_shw_flg", 	false, "", 		dfNone, 	0,isMainPage,isMainPage);
					InitDataProperty(0, cnt++, dtData, 			70, daCenter, 	true,  "pod_yd_cd", 		false, "", 		dfNone, 	0,false, false);
					InitDataProperty(0, cnt++, dtHidden, 			70, daCenter, 	true,  "pod_yd_cd2", 		false, "", 		dfNone, 	0,false, false);
					for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				 		InitDataProperty(0, cnt++, dtHidden, 			50, daRight, 		false, "gl_qty_"+(consTpszArr[i]).toLowerCase(),  		false, "", dfNone, 	0,false, false );
						InitDataProperty(0, cnt++, dtCombo, 			33, daRight, 		false, "gl_ut_"+(consTpszArr[i]).toLowerCase(),  		false, "", dfNone, 	0,false, false );
					}
					InitDataProperty(0, cnt++, dtData, 			120, daLeft, 		false,  "repo_gline_rmk", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false, 	"mty_bkg_teu",  		false, "", 		dfNullInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false, 	"mty_bkg_qty",  		false, "", 		dfNullInteger, 	0,false, 	false);
					for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				 		InitDataProperty(0, cnt++, dtHidden, 			45, daRight, 		false, "mty_bkg_"+(consTpszArr[i]).toLowerCase(),  		false, "", dfNullInteger, 	0,false, false, 6 );
					}
					InitDataProperty(0, cnt++, dtCombo, 			100, daLeft, 		false,  "pln_rsn_hdr_cd", 		false, "", 		dfNone, 	0,isMainPage, 	isMainPage);
					InitDataProperty(0, cnt++, dtCombo, 			150, daLeft, 		false,  "pln_rsn_sub_cd", 		false, "", 		dfNone, 	0,isMainPage, 	isMainPage);
					InitDataProperty(0, cnt++, dtData, 				135, daLeft, 		true,   "pln_rsn_rmk", 			false, "", 		dfNone, 	0,isMainPage, 	isMainPage,	4000);
					InitDataProperty(0, cnt++, dtHidden, 			 20, daLeft, 		true,   "etd_past_flg", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "eff_eta_dt", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "cre_ofc_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "cre_conti_cd", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "aloc_hc_calc_qty", 	false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "aloc_45ft_calc_qty", 	false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "pol_rcc_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "pol_lcc_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "ofc_rcc_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "ofc_lcc_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "pol_conti_cd", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		true,   "mty_vvd_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden, 			500, daLeft, 		false,  "mty_lodg_tpsz_vals", 	false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++ ,dtHiddenStatus,		40,	daCenter,		true,   "ibflag");
					InitDataProperty(0, cnt++, dtHidden, 			100, daLeft, 		false,  "level", 			    false, "", 		dfNone, 	0,false, 	false);
					
					InitTreeInfo(col_cnt-1, "level", RgbColor(0,0,255), false);
					for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
						InitDataCombo (0, "gl_ut_"+(consTpszArr[i]).toLowerCase(), " |"+glinetpText, " |"+glinetpCode);	
					}
					
					InitDataCombo(0, "pln_rsn_hdr_cd", ' |'+pln_rsn_hdr_text, ' |'+pln_rsn_hdr_code);
					pln_rsn_sub_text = ComReplaceStr(pln_rsn_sub_text, '@@', '\t');
					InitDataCombo(0, "pln_rsn_sub_cd", '|'+pln_rsn_sub_text, '|'+pln_rsn_sub_code, "", "", 1);
					
					SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
					SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
					SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
					
					WaitImageVisible=false;
					SelectHighLight = false; //HighLight를 설정하지 않음
				}
			break;
	
			case 2: // sheet1 init
				with (sheetObj) {
		
					// 높이 설정
					style.height = 400;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
//					EditableColorDiff = false;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 50);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					var col_cnt = 11+eval(consTpszArr.length);
					InitColumnInfo(col_cnt, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(false, false, false, true, false, false);
					
					//============ Set Header 0 ============ 
					var HeadTitle0 = "POL|Title|dp_seq|Item|TTL|TTL|TTL|TTL|TTL|TTL|TTL";
					
					for(var i=0; i<consTpszArr.length; i++){
						HeadTitle0 = HeadTitle0+"|TYPE/SIZE";
					}
					
					//============ Set Header 1 ============
					var HeadTitle1 = "POL|Title|dp_seq|Item|TEU|WT|Box|20'|40'|HC|45'";
					for(var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
						HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];
					}
	
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					
					FrozenCols = 4;
		
					// 데이터속성 [   ROW, COL, DATATYPE,       WIDTH,DATAALIGN,	COLMERGE,  SAVENAME,	  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData, 			70,	daCenter ,	true,  "port_cd", 			false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			100, daCenter ,	true,  "item_title", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtHidden,		25, daCenter ,	true,  "dp_seq", 		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			100, daCenter ,	true,  "item_tp_cd",		false, "", 		dfNone, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData,			80, daRight, 	false,  "ttl_teu",			false, "", 		dfNullInteger,     0,false, 	false);
					InitDataProperty(0, cnt++, dtData,			80, daRight, 	false,  "ttl_wt",			false, "", 		dfNullInteger,  	0,false, 	false);
					
					// 임시로 컬럼 히든
					InitDataProperty(0, cnt++, dtData,			70, daRight, 	false,  "ttl_box",			false, "", 		dfNullInteger,  	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			70, daRight , 	false,  "ttl_20", 		false, "", 		dfNullInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			70, daRight, 	false,  "ttl_40", 		false, "", 		dfNullInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			70, daRight, 	false, "ttl_hc",  			false, "", 		dfNullInteger, 	0,false, 	false);
					InitDataProperty(0, cnt++, dtData, 			70, daRight, 	false, "ttl_45",  			false, "", 		dfNullInteger, 	0,false, 	false);

					for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				 		InitDataProperty(0, cnt++, dtData, 			60, daRight, 		false, "box_"+(consTpszArr[i]).toLowerCase(),  		false, "", dfNullInteger, 	0,false, false, 5 );
					}
					
					SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
					SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
					SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
					
					WaitImageVisible=false;
					SelectHighLight = false; //HighLight를 설정하지 않음
				}
			break;		
		}
	}
	
	/**
	 * Location by 변경시 이벤트 처리
	 * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
	 * 나머지 활성화
	 */
	function form_keypress() {
		var formObj = document.form;
		switch (event.srcElement.name) {
			case "s_eff_st_dt":
				ComKeyOnlyNumber(formObj.s_eff_st_dt,"");//숫자만 입력허용
			break;
			
			case "s_eff_st_dt":
				ComKeyOnlyNumber(formObj.s_eff_st_dt,"");//숫자만 입력허용
			break;
			
			case "s_fcbf_st_dt":
				ComKeyOnlyNumber(formObj.s_fcbf_st_dt,"");//숫자만 입력허용
			break;
			
			case "s_fcbf_end_dt":
				ComKeyOnlyNumber(formObj.s_fcbf_end_dt,"");//숫자만 입력허용
			break;
		
			case "s_sub_loc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
			break;
				
			case "s_vvd_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
			break;
			
			case "loc_cd_second":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자
			break;
		}
	}
	
	/**
	 * 설  명 : Form Object Event - onBlur <br>
	 * @author SHIN DONG IL
	 * @version 2013.05.27
	 */
	function form_focus(){
		var formObj = document.form;
		srcName = window.event.srcElement.getAttribute("name");
	}
	
	/**
	 * 설  명 : Form Object Event - onBlur <br>
	 * @author SHIN DONG IL
	 * @version 2013.05.27
	 */
	function form_blur(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName){
			case "s_eff_st_dt":
				formObj.s_eff_st_dt.value = ComGetMaskedValue(formObj.s_eff_st_dt.value, "ymd");
				
				if (ComTrimAll(formObj.s_eff_st_dt) != "" && ComTrimAll(formObj.s_eff_end_dt) != "") {
		
					diffDay = ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
		
					if (diffDay < 0) {
						ComShowCodeMessage('EQR01118');
						formObj.s_eff_st_dt.value = "";
						formObj.s_eff_st_dt.focus();
					}
				}
			break;
			
			case "s_eff_end_dt":
				formObj.s_eff_end_dt.value = ComGetMaskedValue(formObj.s_eff_end_dt.value, "ymd");
				
				if (ComTrimAll(formObj.s_eff_st_dt) != "" && ComTrimAll(formObj.s_eff_end_dt) != "") {
		
					diffDay = ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
		
					if (diffDay < 0) {
						ComShowCodeMessage('EQR01118');
						formObj.s_eff_end_dt.value = "";
						formObj.s_eff_end_dt.focus();
					}
				}
			break;
	
			case "s_fcbf_st_dt":
				formObj.s_fcbf_st_dt.value = ComGetMaskedValue(formObj.s_fcbf_st_dt.value, "ymd");
				
				if (ComTrimAll(formObj.s_fcbf_st_dt) != "" && ComTrimAll(formObj.s_fcbf_end_dt) != "") {
		
					diffDay = ComGetDaysBetween(formObj.s_fcbf_st_dt, formObj.s_fcbf_end_dt);
		
					if (diffDay < 0) {
						ComShowCodeMessage('EQR01118');
						formObj.s_fcbf_st_dt.value = "";
						formObj.s_fcbf_st_dt.focus();
					}
				}
			break;
	
			case "s_fcbf_end_dt":
				formObj.s_fcbf_end_dt.value = ComGetMaskedValue(formObj.s_fcbf_end_dt.value, "ymd");
				
				if (ComTrimAll(formObj.s_fcbf_st_dt) != "" && ComTrimAll(formObj.s_fcbf_end_dt) != "") {
		
					diffDay = ComGetDaysBetween(formObj.s_fcbf_st_dt, formObj.s_fcbf_end_dt);
		
					if (diffDay < 0) {
						ComShowCodeMessage('EQR01118');
						formObj.s_fcbf_end_dt.value = "";
						formObj.s_fcbf_end_dt.focus();
					}
				}
			break;
	
			case "loc_cd":
				if (ComTrimAll(formObj.loc_cd) != "" && formObj.loc_tp_cd.value !="") {
					formObj.f_cmd.value = SEARCH01;
					
					var sXml = sheetObj.GetSearchXml("EES_EQR_1025GS.do", FormQueryString(formObj));
					var sCheck = ComGetEtcData(sXml, "check");
					
					if (sCheck != "T") {
						if (formObj.loc_tp_cd.value == "L") {
							ComShowCodeMessage("EQR01005");
						}else if (formObj.loc_tp_cd.value == "E") {
							ComShowCodeMessage("EQR01006");
						}else if (formObj.loc_tp_cd.value == "S") {
							ComShowCodeMessage("EQR01007");
						}
		
						formObj.loc_cd.value = "";
					}
				}
			break;
		}
	}
	
	
	/*
	 * Container Type Combo OnChange Event
	 * */
	function tpszChange(key){
	    switch (key){
	        case "":
	            comboObjects[3].Code = consTpsz;
	        break;
	
	        case "D":
	            comboObjects[3].Code = consTpszDry;
	        break;
	
	        case "R":
	            comboObjects[3].Code = consTpszRfr;
	        break;
	
	        case "O":
	            comboObjects[3].Code = consTpszOt;
	        break;
	
	        case "F":
	            comboObjects[3].Code = consTpszFr;
	        break;
	    }
	}
	
	/**
	 * MultiSelectCombo 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initCombo (comboObj, comboNo) {
	    var cnt  = 0 ;
		var formObj = document.form;
		with (comboObj) {
			var strId = comboObj.id;
			switch (strId) {
	
				case "tpsztype":
					DropHeight = 9 * 20;
	
					var menuname = tpszallText.split('|');
					var menucode = tpszallCode.split('|')
	
					MultiSelect = true;
					MaxSelect = menuname.length;
					MultiSeparator = ",";
	
					for (i = 0; i < menuname.length; i++) {
						InsertItem(cnt++, menuname[i], menucode[i]);
					}
				break;
				
//				case "vvdrslt":
//					InsertItem(cnt++, 'Lane/VVD/next POL/FCBF/MT Loading plan', 'HJCU0001W');
//				break;
				
			}
		}
	}
	
	//선택된 CONTAINER TYPE/SIZE에 따라 그리드의 헤더를 변경한다.
	function tpsztype_OnChange(comboObj, value, text) {
		//조회 완료 후 선택된 Container Type/Size 이외 Hidden
		setGridHidden();
		setGridHidden2();
	}

	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 *
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author
	 * @version
	 */	
	function trade_OnChange(comboObj, code, text) {
		searchOptionSubTrade("subtrade", true, true, "",  "",  code,   "", true);
		searchOptionLane("lane",true, true, "", code,"", true,"",true);
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 *
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author
	 * @version
	 */
	function subtrade_OnChange(comboObj, value, text) {
		searchOptionLane("lane",true,true,"",document.form.trade.Code,value,true,"",true);
	}
	
	/*
	 * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
	 * OnloadPage,OnSearchEnd event에서 호출
	 * @param {String} tpsz_cd
	 * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
	 */
	function setGridHidden(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		for (var i=0; consTpszArr!=null && i<consTpszArr.length;i++){
			if (formObj.cbx_plan_sel_MP.checked) {
				sheetObj.ColHidden('mty_lodg_'+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(consTpszArr[i].toLowerCase());
			} else {
				sheetObj.ColHidden('mty_lodg_'+consTpszArr[i].toLowerCase())= true;
			}
			if (formObj.cbx_plan_sel_GL.checked) {
				sheetObj.ColHidden('gl_qty_'+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(consTpszArr[i].toLowerCase());
				sheetObj.ColHidden('gl_ut_'+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(consTpszArr[i].toLowerCase());
			} else {
				sheetObj.ColHidden('gl_qty_'+consTpszArr[i].toLowerCase())= true;
				sheetObj.ColHidden('gl_ut_'+consTpszArr[i].toLowerCase())= true;
			}
			if (formObj.cbx_plan_sel_MB.checked) {
				sheetObj.ColHidden('mty_bkg_'+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(consTpszArr[i].toLowerCase());	
			} else {
				sheetObj.ColHidden('mty_bkg_'+consTpszArr[i].toLowerCase())= true;
			}
		}
	}

	function setGridHidden2(){
		var sheetObj2 = sheetObjects[1];
		var formObj = document.form;
		
		for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++){
			sheetObj2.ColHidden('box_'+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(consTpszArr[i].toLowerCase());
		}
	}

	/**
	 * EQR: EQR에서 취급하는 CNTR TP SZ가 맞는지 확인  
	 **/
	function isValidEQRCntrTpSz(tpsz) {
		var arr_tpsz = comboObjects[3].Code.split(",");
		for (var i=0; tpsz!=undefined && tpsz!=null && tpsz!='' && arr_tpsz!=null && i<arr_tpsz.length; i++){
			if (arr_tpsz[i]!=undefined && arr_tpsz[i]!='' && arr_tpsz[i].toLowerCase()==tpsz.toLowerCase()){
				return true;
			}
		}
		return false;
	}
	 

	/**
	 * 기본 key에 해당하는 row(들)을 구함
	 */
	function findSamePolRows(sheetObj, row) {
		var retval = '';
		if (row!=null && row!=''){
			var tmpTrdCd 	= sheetObj.CellValue(row, 'trd_cd');
			var tmpSubTrdCd = sheetObj.CellValue(row, 'sub_trd_cd');
			var tmpSlanCd 	= sheetObj.CellValue(row, 'slan_cd');
			var tmpVvdCd 	= sheetObj.CellValue(row, 'vvd_cd');
			var tmpPolYdCd 	= sheetObj.CellValue(row, 'pol_yd_cd');
			
			var headCnt 	= sheetObj.HeaderRows;
			for (var i=headCnt; i<=sheetObj.LastRow; i++){
   			if (tmpTrdCd == sheetObj.CellValue(i,'trd_cd')
					&& tmpSubTrdCd == sheetObj.CellValue(i,'sub_trd_cd')
					&& tmpSlanCd == sheetObj.CellValue(i,'slan_cd')
					&& tmpVvdCd == sheetObj.CellValue(i,'vvd_cd')
					&& tmpPolYdCd == sheetObj.CellValue(i,'pol_yd_cd')
				){
   				retval = retval + (retval!=null&&retval.length>0?'|':'') + (i);
   			}
			}
		}
		return retval;
	}
	 
	 /**
	  * POL들만 조회
	  * @ first_pol_only가 true인 경우 첫번째 pol 하나만 준다. @
	  */
	function findPols(sheetObj, first_pol_only) {
		var retval = '';
		var headCnt	= sheetObj.HeaderRows;
		for (var i=headCnt; i<=sheetObj.LastRow; i++){
			if (sheetObj.CellValue(i,'pod_yd_cd')=='+' || sheetObj.CellValue(i,'pod_yd_cd')=='-'){
				if (first_pol_only){
					retval = sheetObj.CellValue(i,'pol_yd_cd');
					break;
				} else {
					retval = retval + (retval!=null&&retval.length>0?',':'') + sheetObj.CellValue(i,'pol_yd_cd');	
				}
			}
		}
		return retval;
	}
	 
	/**
	 * 기본 key에 해당하는 Gline data의 NULL 확인
	 */
	function chkGlineAllValIsNull(sheetObj,polRow) {
		var retval = true;
		var pol_rows = findSamePolRows(sheetObj,polRow); // POL의 해당 POD row(들)
		var arr_pol_rows = pol_rows.split('|');
		for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
			for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"gl_qty_"+(consTpszArr[i]).toLowerCase())) && sheetObj.CellValue(arr_pol_rows[j],"gl_qty_"+(consTpszArr[i]).toLowerCase())!=0){
					retval = false;
					break;
				}
				if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"gl_ut_"+(consTpszArr[i]).toLowerCase())) && sheetObj.CellValue(arr_pol_rows[j],"gl_ut_"+(consTpszArr[i]).toLowerCase())!=0){
					retval = false;
					break;
				}
			}
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"repo_gline_rmk"))){
				retval = false;
				break;
			}
			if (!retval){
				break;
			}
		}
		return retval;
	}	

   /**
	 * 기본 key에 해당하는 MTY BKG data의 NULL 확인
	 */
	function chkMtBkgAllValIsNull(sheetObj,polRow) {
		var retval = true;
		var pol_rows = findSamePolRows(sheetObj,polRow); // POL의 해당 POD row(들)
		var arr_pol_rows = pol_rows.split('|');

		for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_bkg_teu")) && sheetObj.CellValue(arr_pol_rows[j],"mty_bkg_teu")!=0){
				retval = false;
				break;
			}
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_bkg_qty")) && sheetObj.CellValue(arr_pol_rows[j],"mty_bkg_qty")!=0){
				retval = false;
				break;
			}
			for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_bkg_"+(consTpszArr[i]).toLowerCase()))){
					retval = false;
					break;
				}
			}
			if (!retval){
				break;
			}
		}

		return retval;
	}

   /**
	 * 기본 key에 해당하는 MTY Lodg Pln data의 NULL 확인
	 */
	function chkMtLodgPlnAllValIsNull(sheetObj,polRow) {
		var retval = true;
		var pol_rows = findSamePolRows(sheetObj,polRow); // POL의 해당 POD row(들)
		var arr_pol_rows = pol_rows.split('|');

		for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_lodg_pln_teu")) && sheetObj.CellValue(arr_pol_rows[j],"mty_lodg_pln_teu")!=0){
				retval = false;
				break;
			}
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_lodg_pln_ton")) && sheetObj.CellValue(arr_pol_rows[j],"mty_lodg_pln_ton")!=0){
				retval = false;
				break;
			}
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"fnl_cbf_flg")) && sheetObj.CellValue(arr_pol_rows[j],"fnl_cbf_flg")!=0){
				retval = false;
				break;
			}
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"fnl_cbf_flg2")) && sheetObj.CellValue(arr_pol_rows[j],"fnl_cbf_flg2")!=0){
				retval = false;
				break;
			}
			for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
				if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_lodg_"+(consTpszArr[i]).toLowerCase())) && sheetObj.CellValue(arr_pol_rows[j],"mty_lodg_"+(consTpszArr[i]).toLowerCase())!=0){
					retval = false;
					break;
				}
			}
			if (!ComIsNull(sheetObj.CellValue(arr_pol_rows[j],"mty_pln_shw_flg")) && sheetObj.CellValue(arr_pol_rows[j],"mty_pln_shw_flg")!=0){
				retval = false;
				break;
			}
			if (!retval){
				break;
			}
		}
		return retval;
	}
	 
	/**
	 * 조회 완료 이벤트 후 로직 <br>
	 */
//	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//	}
	 
	/**
	 * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
	 */
	function sheet1_OnClick(sheetObj, row, col, value) {
	    switch (sheetObj.ColSaveName(col)) {
			case "pod_yd_cd":
				var tmp_row_sts = sheetObj.RowStatus(row);
	    		if (sheetObj.CellValue(row, col) == "+"){
	    			sheetObj.RowExpanded(row) = true;
	   				sheetObj.CellValue2(row, col) = "-";
	    		} else if(sheetObj.CellValue(row, col) == "-"){
	    			sheetObj.RowExpanded(row) = false;
	   				sheetObj.CellValue2(row, col) = "+";
	    		}
	    		sheetObj.RowStatus(row) = tmp_row_sts;
	    		break;
	    }
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		switch (sheetObj.ColSaveName(Col)){
			case "mty_pln_teu":
			
				if (sheetObj.CellValue(Row,'mty_pln_teu')!=null && sheetObj.CellValue(Row,'mty_pln_teu')!=''){ // && Number(sheetObj.CellValue(Row,'mty_pln_teu'))>0){
				
					var pol_rows = findSamePolRows(sheetObj,Row);
					var arr_pol_rows = pol_rows.split('|');
					var ARR_DRY_TPSZ = tpszdryCode.split('|'); //일단 DRY만 잡아온다.

					sheetObj.CellValue(Row,'mty_pln_ton') = sheetObj.CellValue(Row,'mty_pln_teu')*2.2;
					
					// ETD 를 경과하기 전 POL 에 대하여 , Available 에 MT Plan 을 빼고 MT BKG 를 더한다
					for(var j=0; j<sheetObj.LastRow; j++){
						if(sheetObj.CellValue(j,'pod_yd_cd')=='+' || sheetObj.CellValue(j,'pod_yd_cd')=='-'){ // POL Row
							
							// ETD 를 경과하기 전 POL 에 대하여 , Available 에 MT Plan 을 빼고 MT BKG 를 더한다
							if(sheetObj.CellValue(j,"etd_past_flg") == "N"){
								//var vvd_str_row = sheetObj.GetColSameDataRange(j,"vvd_cd").split("|")[0]*1; // 해당 VVD의 시작 줄
								var vvd_str_row = Math.max( sheetObj.GetColSameDataRange(j,"vvd_cd").split("|")[0]*1,    // 해당 VVD의 시작 줄 과
				                           		  			sheetObj.GetColSameDataRange(j,"trd_cd").split("|")[0]*1 );  // 해당 Traid의 시작 줄 중 큰 값
								var tmp_mt_pln = 0;
								var tmp_mt_bkg = 0;
								var tmp_mt_pln_ton = 0; //추가
								for(var i=vvd_str_row; i<=j; i++){
									if((sheetObj.CellValue(i,'pod_yd_cd')=='+' || sheetObj.CellValue(i,'pod_yd_cd')=='-') && (sheetObj.CellValue(i,"etd_past_flg") == "N")){
										tmp_mt_pln = tmp_mt_pln + sheetObj.CellValue(i,"mty_pln_teu")*1;
										tmp_mt_bkg = tmp_mt_bkg + sheetObj.CellValue(i,"mty_bkg_teu")*1;
										tmp_mt_pln_ton = tmp_mt_pln_ton + sheetObj.CellValue(i,"mty_pln_ton")*1; //추가
									}					
								}
								sheetObj.CellValue2(j,"show_avl_teu") = ComAddComma(sheetObj.CellValue(j,"avl_teu")*1 - tmp_mt_pln + tmp_mt_bkg) ;
								sheetObj.CellValue2(j,"show_avl_ton") = ComAddComma(sheetObj.CellValue(j,"avl_ton")*1 - tmp_mt_pln_ton); //추가
							}else{
								sheetObj.CellValue2(j,"show_avl_teu") = ComAddComma(sheetObj.CellValue(j,"avl_teu"));
								sheetObj.CellValue2(j,"show_avl_ton") = ComAddComma(sheetObj.CellValue(j,"avl_ton")); //추가
							}
//							sheetObj.CellValue2(j,"show_avl_ton") =  ComAddComma(Math.round(sheetObj.CellValue(j,"avl_teu")*2.2)); //제거
						}
					}
					
					/***
					 *    A : MT PLAN TEU, a : HC 수치(SPC), b: 45FT 수치(SPC) 
						  => TP/SZ별 Volume 산출 , a,b=노선별 type별 계산 수치
						         D2 : A X D2(%)/[D2(%)+2*D4(%)+a*D5(%)+b*D7(%)]
						         D4 : A X D4(%)/[D2(%)+2*D4(%)+a*D5(%)+b*D7(%)]
						         D5 : A X D5(%)/[D2(%)+2*D4(%)+a*D5(%)+b*D7(%)]
						         D7 : A X D7(%)/[D2(%)+2*D4(%)+a*D5(%)+b*D7(%)]
						         onboard가 D5/D7 sub-allocation이상이면 해당 size의 추가되는 void teu 에서 해당 box x 노선별 계산수치를 차감하고 남는것은 D2 추가
						    => Portion 중 Box가 있을 시에는, A에서 Box 우선 제외한 후 A 산출 후,
						         나머지 TP/SZ 에 한하여 위 로직에 맞게 산출
						         (ex) D7이 Box(B)로 지정 된 경우, 
						          D2: (A-b*B) X D2(%)/[D2(%)+2*D4(%)+a*D5(%)]
						          D4: (A-b*B) X 2*D4(%)/[D2(%)+2*D4(%)+a*D5(%)]
						          D5: (A-b*B) X a*D5(%)/[D2(%)+2*D4(%)+a*D5(%)]
						     => 계산 로직에 소수점은 모두 버림 처리
						     => [LODG] 버림으로 인해 발생한 GAP은 모두 D2에 Add
						        [DCHG] 계산이 마치고도 남아있는 나머지 액수는 금액이 있는 마지막 CELL에 그냥 더한다.						     
					  ***/
					
					
					/** MT Loading Plan 항목 non-editable 상황 일 경우엔 분배 안함 **/
					if (sheetObj.CellValue(Row,"etd_past_flg") == "Y" || sheetObj.CellValue(Row,"fnl_cbf_flg") == "1") {
						break;
					}
					
					/** Gline이 있는 경우만 하기 처리 수행 **/
					if (chkGlineAllValIsNull(sheetObj,Row)){
						break;
					}

					/** 이미 MTY Loading Plan 값이 있는 경우엔 수정할지 메시지를 띄움 **/
					if (!chkMtLodgPlnAllValIsNull(sheetObj,Row)){
						if(!ComShowCodeConfirm("EQR01030")){
							break;
						} else {
							/** 초기화 - B **/
							for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
								for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
									sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
								}
							}
							sheetObj.CellValue2(Row,'mty_lodg_pln_ton') = 0;
							sheetObj.CellValue2(Row,'mty_lodg_pln_teu') = 0;
							/** 초기화 - E **/
						}
					}
					
//					if (Number(sheetObj.CellValue(Row,'mty_pln_teu'))<=0){
//						/** 초기화 **/
//						for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
//							for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
//								sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
//							}
//						}
//						break;
//					}
					
					var lodg_val_chg	= false;
					var input_mty_pln_teu_val 		= sheetObj.CellValue(Row,'mty_pln_teu'); // 참조만 하고 절대 수정하지 않는다
					var input_mty_pln_teu_val_lodg 	= sheetObj.CellValue(Row,'mty_pln_teu'); // 계산시 값을 가공한다.
					var input_mty_pln_teu_val_dchg 	= sheetObj.CellValue(Row,'mty_pln_teu');
					var ARR_TPSZ_CALC_CONST 	= [['d2',1],['d4',2],['d5',sheetObj.CellValue(Row,'aloc_hc_calc_qty')],['d7',sheetObj.CellValue(Row,'aloc_45ft_calc_qty')]];
					var base_val = 0;
					
					
					/** [LODG] Gline의 우선순위를 잡아서 TPSZ별 계산 순서를 재정리 **/
					var tmp_arr_tpsz = new Array();
					var tmp_arr_idx = 0;
					var priority_no = 1;
					var max_priority_no = (ARR_DRY_TPSZ!=null?ARR_DRY_TPSZ.length:0); //일단 priority는 Gline 대상 TPSZ 수만큼만 할당한다.
					var arr_chk_ut_tp = ['B','P','R']; // 유형별 우선순위 부여 순서 : Box/Percent/Rest
					/** 정상적인 순위 순서를 부여 **/
					for (var u=0; arr_chk_ut_tp!=null && u<arr_chk_ut_tp.length; u++){
						for (var p=1; max_priority_no!=null && p<=max_priority_no; p++){
							for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
								var gl_ut_val = sheetObj.CellValue(Row,'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
								if (gl_ut_val!=null && arr_chk_ut_tp[u]!=null && gl_ut_val==arr_chk_ut_tp[u]){
									var gl_qty_val = sheetObj.CellValue(Row,'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase());
									var tmp_qty_val = gl_qty_val.split('/');
									if (tmp_qty_val!=null && tmp_qty_val.length==2){
										if (tmp_qty_val[0]!=null && tmp_qty_val[0].trim()!='' && !isNaN(tmp_qty_val[0].trim())){
											if (tmp_qty_val[0] == p){
												tmp_arr_tpsz[tmp_arr_idx++] = ARR_DRY_TPSZ[i];
											}
										}
									}
								}
							}
						}
					}
					/** 정상적인 순위가 부여되지 않은 나머지에 대해서는 앞에서부터 그냥 순서대로 자동으로 순서를 부여 **/
					var found = false;
					var tmp_arr_tpsz2 = new Array;
					var tmp_arr_idx2 = 0;
					for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
						found = false;
						for (var j=0; tmp_arr_tpsz!=null && j<tmp_arr_tpsz.length; j++){
							if (ARR_DRY_TPSZ[i]==tmp_arr_tpsz[j]){
								found = true;
								break;
							}
						}
						if (!found){
							tmp_arr_tpsz2[tmp_arr_idx2++] = ARR_DRY_TPSZ[i];
						}
					}
					var tmp_arr_tpsz3 = tmp_arr_tpsz.concat(tmp_arr_tpsz2);
					
					ARR_DRY_TPSZ = tmp_arr_tpsz3; // 우선순위 적용 하기
					
					
					/***************************************************************** 
					 * [LOGD] 계산
					 *****************************************************************/					
					/** [LODG] Gline BOX에 해당하는 BOX knt 구하기 **/
					if (sheetObj.CellValue(Row,'pol_yd_cd')!=null && sheetObj.CellValue(Row,'pol_yd_cd')!=''){
						if (sheetObj.CellValue(Row,'pol_yd_cd')==findPols(sheetObj,true)){
							for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
								var tmp_calc_const = 1;
								var gl_ut_val = sheetObj.CellValue(Row,'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
								if (gl_ut_val!=null && gl_ut_val=='B'){
									var gl_qty_val = sheetObj.CellValue(Row,'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase());
									var tmp_qty_val = gl_qty_val.split('/');
									if (tmp_qty_val!=null && tmp_qty_val.length==2){
										if (tmp_qty_val[1]!=null && tmp_qty_val[1].trim()!='' && !isNaN(tmp_qty_val[1].trim())){
											for (var t=0; ARR_TPSZ_CALC_CONST!=null && t<ARR_TPSZ_CALC_CONST.length; t++){
												if (ARR_TPSZ_CALC_CONST[t][0]==ARR_DRY_TPSZ[i].toLowerCase()){
													tmp_calc_const = ARR_TPSZ_CALC_CONST[t][1]!=null&&ARR_TPSZ_CALC_CONST[t][1]!=''&&ARR_TPSZ_CALC_CONST[t][1]!=0?ARR_TPSZ_CALC_CONST[t][1]:1;
													break;
												}
											}
											if (input_mty_pln_teu_val_lodg > 0){
												var tmp_cal_val = (input_mty_pln_teu_val_lodg>Number(tmp_qty_val[1].trim())*tmp_calc_const?Number(tmp_qty_val[1].trim())*tmp_calc_const:input_mty_pln_teu_val_lodg);
												sheetObj.CellValue2(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = Math.floor(tmp_cal_val/tmp_calc_const); //box knt를 넣는다.
												input_mty_pln_teu_val_lodg = input_mty_pln_teu_val_lodg - Math.floor(tmp_cal_val/tmp_calc_const)*tmp_calc_const; //teu단위로 뺀다.
											} else {
												sheetObj.CellValue2(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
											}
										}
									}
								}
							}							
						}
					}


					/** [LODG] Gline %에 해당하는 기본값 구하기 **/
					for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
						var gl_ut_val = sheetObj.CellValue(Row,'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
						if (gl_ut_val!=null && gl_ut_val=='P'){
							var gl_qty_val = sheetObj.CellValue(Row,'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase());
							var tmp_qty_val = gl_qty_val.split('/');
							if (tmp_qty_val!=null && tmp_qty_val.length==2){
								if (tmp_qty_val[1]!=null && tmp_qty_val[1].trim()!='' && !isNaN(tmp_qty_val[1].trim())){
									for (var b=0; ARR_TPSZ_CALC_CONST!=null && b<ARR_TPSZ_CALC_CONST.length; b++){
										if (ARR_TPSZ_CALC_CONST[b][0]==(ARR_DRY_TPSZ[i]).toLowerCase()){
											base_val = base_val + (tmp_qty_val[1] * ARR_TPSZ_CALC_CONST[b][1]);
										}
									}
								}
							}
						}
					}

					/** [LODG] Gline % type당 BOX knt 구하기 **/
					var p_tmp_dry_qty_val = 0;
					var p_tmp_input_mty_pln_teu_val_lodg = input_mty_pln_teu_val_lodg;  // ->  바로전 BOX type을 빼고 남은 값을 할당하되 본 값은 더 이상 가공하지 않고 참조만 한다.
					for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
						var tmp_calc_const = 1;
						var gl_ut_val = sheetObj.CellValue(Row,'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
						if (gl_ut_val!=null && gl_ut_val=='P'){
							var gl_qty_val = sheetObj.CellValue(Row,'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase());
							var tmp_qty_val = gl_qty_val.split('/');
							if (tmp_qty_val!=null && tmp_qty_val.length==2){
								if (tmp_qty_val[1]!=null && tmp_qty_val[1].trim()!='' && !isNaN(tmp_qty_val[1].trim())){
									for (var t=0; ARR_TPSZ_CALC_CONST!=null && t<ARR_TPSZ_CALC_CONST.length; t++){
										if (ARR_TPSZ_CALC_CONST[t][0]==ARR_DRY_TPSZ[i].toLowerCase()){
											tmp_calc_const = ARR_TPSZ_CALC_CONST[t][1]!=null&&ARR_TPSZ_CALC_CONST[t][1]!=''&&ARR_TPSZ_CALC_CONST[t][1]!=0?ARR_TPSZ_CALC_CONST[t][1]:1;
											break;
										}
									}
									var tmp_p_val = p_tmp_input_mty_pln_teu_val_lodg * (base_val>0?Number(tmp_qty_val[1].trim())*tmp_calc_const/base_val:0);
									if (input_mty_pln_teu_val_lodg > 0){
										sheetObj.CellValue2(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = Math.floor(tmp_p_val/tmp_calc_const); //box knt를 넣는다.
										input_mty_pln_teu_val_lodg = input_mty_pln_teu_val_lodg -  Math.floor(tmp_p_val/tmp_calc_const)*tmp_calc_const; //teu단위로 뺀다. 
										p_tmp_dry_qty_val = p_tmp_dry_qty_val + Number(tmp_qty_val[1].trim());
									} else {
										sheetObj.CellValue2(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
									}
								}
							}
						}
					}
					
					/** [LODG] Gline % type당 REST knt 구하기 **/
					for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
						var tmp_calc_const = 1;
						var gl_ut_val = sheetObj.CellValue(Row,'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
						if (gl_ut_val!=null && gl_ut_val=='R'){
							if (input_mty_pln_teu_val_lodg>0){
								for (var t=0; ARR_TPSZ_CALC_CONST!=null && t<ARR_TPSZ_CALC_CONST.length; t++){
									if (ARR_TPSZ_CALC_CONST[t][0]==ARR_DRY_TPSZ[i].toLowerCase()){
										tmp_calc_const = ARR_TPSZ_CALC_CONST[t][1]!=null&&ARR_TPSZ_CALC_CONST[t][1]!=''&&ARR_TPSZ_CALC_CONST[t][1]!=0?ARR_TPSZ_CALC_CONST[t][1]:1;
										break;
									}
								}
								sheetObj.CellValue2(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = input_mty_pln_teu_val_lodg/tmp_calc_const; //box knt를 넣는다.
								break;
							} else {
								sheetObj.CellValue2(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
							}
						}
					}

				
					/** 
					 * LODG 배부가 완료되면 TPSZ별 BOX KNT를 모아서 합계에 넣어준다. 
					 * 단, 계산 로직에 소수점은 모두 버림으로 인해 발생한 GAP은 모두 D2에 Add한다.
					 * **/
					var ttl_mty_pln_teu = 0;
					var ttl_mty_pln_box = 0;
					for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
						var tmp_calc_const = 1;
						for (var t=0; ARR_TPSZ_CALC_CONST!=null && t<ARR_TPSZ_CALC_CONST.length; t++){
							if (ARR_TPSZ_CALC_CONST[t][0]==ARR_DRY_TPSZ[i].toLowerCase()){
								tmp_calc_const = ARR_TPSZ_CALC_CONST[t][1]!=null&&ARR_TPSZ_CALC_CONST[t][1]!=''&&ARR_TPSZ_CALC_CONST[t][1]!=0?ARR_TPSZ_CALC_CONST[t][1]:1;
								break;
							}
						}
						if (Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) > 0){
							lodg_val_chg = true;
							ttl_mty_pln_teu = ttl_mty_pln_teu + Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) * tmp_calc_const;
							ttl_mty_pln_box = ttl_mty_pln_box + Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()));
						}
					}
					if (lodg_val_chg){
						if (input_mty_pln_teu_val > ttl_mty_pln_teu){
							sheetObj.CellValue2(Row,'mty_lodg_d2') = Number(sheetObj.CellValue(Row,'mty_lodg_d2')) + (input_mty_pln_teu_val - ttl_mty_pln_teu);  //d2 box
						}
						
						/** 보정 ttl에 재반영 **/
						ttl_mty_pln_teu = 0;
						ttl_mty_pln_box = 0;
						for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
							var tmp_calc_const = 1;
							for (var t=0; ARR_TPSZ_CALC_CONST!=null && t<ARR_TPSZ_CALC_CONST.length; t++){
								if (ARR_TPSZ_CALC_CONST[t][0]==ARR_DRY_TPSZ[i].toLowerCase()){
									tmp_calc_const = ARR_TPSZ_CALC_CONST[t][1]!=null&&ARR_TPSZ_CALC_CONST[t][1]!=''&&ARR_TPSZ_CALC_CONST[t][1]!=0?ARR_TPSZ_CALC_CONST[t][1]:1;
									break;
								}
							}
							if (Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) > 0){
								ttl_mty_pln_teu = ttl_mty_pln_teu + Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) * tmp_calc_const;
								ttl_mty_pln_box = ttl_mty_pln_box + Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()));
							}
						}
						sheetObj.CellValue2(Row,'mty_lodg_pln_ton') = ttl_mty_pln_box;
						sheetObj.CellValue2(Row,'mty_lodg_pln_teu') = ttl_mty_pln_teu;
					}

					
					
					/***************************************************************** 
					 * [DCHG] 계산
					 *****************************************************************/
					
					var p_tmp_dchg_tpsz_sum_val = 0;  // LODG BOX - TPSZ별 현재의 LODG 가지고만 있는다. (가공않함)
					var p_tmp_dchg_tpsz_calc_val = 0; // LODG BOX - 계산시 뺀다.
					var tmp_calc_const = 1;
					for (var i=0; ARR_DRY_TPSZ!=null && i<ARR_DRY_TPSZ.length; i++){
						for (var t=0; ARR_TPSZ_CALC_CONST!=null && t<ARR_TPSZ_CALC_CONST.length; t++){
							if (ARR_TPSZ_CALC_CONST[t][0]==ARR_DRY_TPSZ[i].toLowerCase()){
								tmp_calc_const = ARR_TPSZ_CALC_CONST[t][1]!=null&&ARR_TPSZ_CALC_CONST[t][1]!=''&&ARR_TPSZ_CALC_CONST[t][1]!=0?ARR_TPSZ_CALC_CONST[t][1]:1;
								break;
							}
						}
						p_tmp_dchg_tpsz_sum_val 	= Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())); // LODG BOX (가공않함)
						p_tmp_dchg_tpsz_calc_val 	= Number(sheetObj.CellValue(Row,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())); // LODG BOX
						if (p_tmp_dchg_tpsz_sum_val>0){

							/** [DCHG] Gline BOX type별 BOX knt 구하기 **/
							if (sheetObj.CellValue(Row,'pol_yd_cd')!=null && sheetObj.CellValue(Row,'pol_yd_cd')!=''){
								if (sheetObj.CellValue(Row,'pol_yd_cd')==findPols(sheetObj,true)){
									for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
										if (Row!=arr_pol_rows[j]){
											var gl_ut_val = sheetObj.CellValue(arr_pol_rows[j],'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
											if (gl_ut_val!=null && gl_ut_val=='B'){
												var gl_qty_val = Number(sheetObj.CellValue(arr_pol_rows[j],'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase()));
												if (gl_qty_val!=null && gl_qty_val!=''){
													if (Row!=arr_pol_rows[j]){
														if (p_tmp_dchg_tpsz_calc_val > 0){
															var tmp_cal_val = (p_tmp_dchg_tpsz_calc_val>Number(gl_qty_val)?Number(gl_qty_val):p_tmp_dchg_tpsz_calc_val);
															sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = tmp_cal_val;
															p_tmp_dchg_tpsz_calc_val = p_tmp_dchg_tpsz_calc_val - tmp_cal_val;
														} else {
															sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
														}
													}
												} else {
													sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
												}
											}									
										}
									}									
								}
							}
							
							/** [DCHG] Gline %용 type별 기본값 구하기 **/
							var dchg_pct_base_val = 0;
							for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
								if (Row!=arr_pol_rows[j]){
									var gl_ut_val = sheetObj.CellValue(arr_pol_rows[j],'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
									if (gl_ut_val!=null && gl_ut_val=='P'){
										var gl_qty_val = Number(sheetObj.CellValue(arr_pol_rows[j],'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase()));
										if (gl_qty_val!=null && gl_qty_val!=''){
											if (Row!=arr_pol_rows[j]){
												dchg_pct_base_val = dchg_pct_base_val + (gl_qty_val * tmp_calc_const);
											}
										}
									}
								}
							}
							var p_tmp_dchg_dry_qty_val = p_tmp_dchg_tpsz_calc_val; // %용으로 앞값을 받아서 가공하지 않고 참조만 한다.
							for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
								if (Row!=arr_pol_rows[j]){
									var gl_ut_val = sheetObj.CellValue(arr_pol_rows[j],'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
									if (gl_ut_val!=null && gl_ut_val=='P'){
										var gl_qty_val = Number(sheetObj.CellValue(arr_pol_rows[j],'gl_qty_'+(ARR_DRY_TPSZ[i]).toLowerCase()));
										if (gl_qty_val!=null && gl_qty_val!=''){
											if (Row!=arr_pol_rows[j]){
												if (p_tmp_dchg_dry_qty_val > 0){
													//var tmp_cal_val = (p_tmp_dchg_tpsz_calc_val>Math.floor(p_tmp_dchg_tpsz_sum_val*(gl_qty_val*tmp_calc_const/dchg_pct_base_val))?Math.floor(p_tmp_dchg_tpsz_sum_val*(gl_qty_val*tmp_calc_const/dchg_pct_base_val)):p_tmp_dchg_tpsz_calc_val); //box
													var tmp_cal_val = p_tmp_dchg_dry_qty_val*(gl_qty_val*tmp_calc_const/dchg_pct_base_val); //box
													sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = Math.floor(tmp_cal_val); //BOX
													p_tmp_dchg_tpsz_calc_val = p_tmp_dchg_tpsz_calc_val - Math.floor(tmp_cal_val);//*tmp_calc_const;
												} else {
													sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
												}
											}
										} else {
											sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
										}
									}									
								}
							}
							for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
								if (Row!=arr_pol_rows[j]){
									var gl_ut_val = sheetObj.CellValue(arr_pol_rows[j],'gl_ut_'+(ARR_DRY_TPSZ[i]).toLowerCase());
									if (gl_ut_val!=null && gl_ut_val=='R'){
										if (p_tmp_dchg_tpsz_calc_val>0){
											sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = Math.floor(p_tmp_dchg_tpsz_calc_val);
											p_tmp_dchg_tpsz_calc_val = 0;
										} else {
											sheetObj.CellValue2(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) = '';
										}
									}
								}
							}

							/**
							 * [DCHG] - 보정 
							-> 계산이 마치고도 남아있는 나머지 액수는 금액이 있는 마지막 CELL에 그냥 더한다. -> [정부장님 말씀]
							**/
							var tmp_ttl_dchg_teu = 0;
							var last_row_notnull = '';
							for (var j=0; arr_pol_rows!=null && j<arr_pol_rows.length; j++){
								if (Row!=arr_pol_rows[j]){
									if (Number(sheetObj.CellValue(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) > 0){
										last_row_notnull = arr_pol_rows[j];
										tmp_ttl_dchg_teu = tmp_ttl_dchg_teu + Math.floor(Number(sheetObj.CellValue(arr_pol_rows[j],'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) * tmp_calc_const);
									}
								}
								/** 마지막 row 할당 **/
								if (j==(arr_pol_rows.length-1) && (last_row_notnull==null || last_row_notnull=='')){
									last_row_notnull = arr_pol_rows[j];
								}
							}
							if ((p_tmp_dchg_tpsz_sum_val*tmp_calc_const - tmp_ttl_dchg_teu)>0){
								if (last_row_notnull!=null && last_row_notnull!='' && Number(last_row_notnull)>=1 && last_row_notnull!=Row){
									sheetObj.CellValue2(last_row_notnull,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase()) 
									= Number(sheetObj.CellValue(last_row_notnull,'mty_lodg_'+(ARR_DRY_TPSZ[i]).toLowerCase())) 
										+ Math.floor((p_tmp_dchg_tpsz_sum_val*tmp_calc_const - tmp_ttl_dchg_teu) / tmp_calc_const);
								}
							}
						}
					} // FOR STAT - ARR_DRY_TPSZ
				}
				break;
				
			case "pln_rsn_hdr_cd":
				var tmp_pln_rsn_hdr_val = sheetObj.CellValue(Row,'pln_rsn_hdr_cd');
				if (tmp_pln_rsn_hdr_val!=null && tmp_pln_rsn_hdr_val!=''){
					formObj.pln_rsn_hdr_cd.value = tmp_pln_rsn_hdr_val;
					formObj.f_cmd.value = SEARCH03;
				}
				var sParam = FormQueryString(formObj);
				var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1013GS.do", sParam);
				var tmp_pln_rsn_sub_code  = ComGetEtcData(sXml,"pln_rsn_sub_code");
				var tmp_pln_rsn_sub_text  = ComGetEtcData(sXml,"pln_rsn_sub_text");
				tmp_pln_rsn_sub_text = ComReplaceStr(tmp_pln_rsn_sub_text, '@@', '\t');
				sheetObj.CellComboItem(Row, 'pln_rsn_sub_cd', '|'+tmp_pln_rsn_sub_text, '|'+tmp_pln_rsn_sub_code, 1);
				break;
				
			case "pln_rsn_sub_cd":
				var tmp_pln_rsn_sub_cd = sheetObj.CellValue(Row,'pln_rsn_sub_cd');
				if (tmp_pln_rsn_sub_cd!=null && tmp_pln_rsn_sub_cd!=''){
					sheetObj.CellValue2(Row,'pln_rsn_hdr_cd') = tmp_pln_rsn_sub_cd.substr(0,1);
				}
				break;
				
			case "fnl_cbf_flg":
				var login_ofc = document.form.h_ofc_cd.value;
				var cre_ofc_conti_cd = sheetObj.CellValue(Row,'cre_conti_cd');
				if (sheetObj.CellValue(Row,Col)=='1' || sheetObj.CellValue(Row,Col)=='0'){
					if (sheetObj.CellValue(Row,'pod_yd_cd')=="+" || sheetObj.CellValue(Row,'pod_yd_cd')=="-"){
						
						if (Value != sheetObj.CellSearchValue(Row,Col)){
	
							if (login_ofc!=null && login_ofc!=''){								
								if (sheetObj.CellValue(Row,'pol_rcc_cd')=="DEHAM"){
								// CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환, -- HAMUR-->HAMRU, HAMUOG-->HAMRUO
								//	if (!(login_ofc=='HAMUR' || login_ofc=='HAMUOG') && Value=="0"){ // 구주 POL을 대상으로 HAMUR/HAMUOG 오피스가 아닌데, 체크를 풀려 할 때
									if (!(login_ofc=='HAMRU' || login_ofc=='HAMRUO') && Value=="0"){ // 구주 POL을 대상으로 HAMRU/HAMRUO 오피스가 아닌데, 체크를 풀려 할 때										
										ComShowCodeMessage('EQR01031'); // 'No authority to change.'
										sheetObj.CellValue2(Row,Col) = sheetObj.CellSearchValue(Row,Col);
										return false;
									}
								}
								
//								if(sheetObj.CellValue(Row,'cre_ofc_cd') != ""){
//									if (cre_ofc_conti_cd!=null && cre_ofc_conti_cd!=''){
//										if (cre_ofc_conti_cd=='E'){
//											if (login_ofc!='HAMUR' && Value=="0"){ // HAMUR 오피스가 아닌데, 체크를 풀려 할 때
//												ComShowCodeMessage('EQR01031'); // 'No authority to change.'
//												sheetObj.CellValue2(Row,Col) = sheetObj.CellSearchValue(Row,Col);
//	//											sheetObj.RowStatus(Row) = sheetObj.CellSearchValue(Row,'ibflag');
//												return false;
//											}
//										} else {
//											if (login_ofc!=sheetObj.CellValue(Row,'cre_ofc_cd') && Value=="0"){
//												ComShowCodeMessage('EQR01031'); // 'No authority to change.'
//												sheetObj.CellValue2(Row,Col) = sheetObj.CellSearchValue(Row,Col);
//	//											sheetObj.RowStatus(Row) = sheetObj.CellSearchValue(Row,'ibflag');
//												return false;
//											}
//										}
//									} else {
//										ComShowCodeMessage('EQR01032'); // 'Create OFC Conti Code Not Found Exception!'
//										sheetObj.CellValue2(Row,Col) = sheetObj.CellSearchValue(Row,Col);
//	//									sheetObj.RowStatus(Row) = sheetObj.CellSearchValue(Row,'ibflag'); //tmp_row_sts;
//										return false;
//									}
//								}
	
							} else {
									ComShowCodeMessage('EQR01033'); // 'Login OFC Not Found Exception!'
									sheetObj.CellValue2(Row,Col) = sheetObj.CellSearchValue(Row,Col);
	//								sheetObj.RowStatus(Row) = sheetObj.CellSearchValue(Row,'ibflag'); //tmp_row_sts;
									return false;
							}
						
						}
			
					}
					
					var tmpTrdCd 	= sheetObj.CellValue(Row, 'trd_cd');
					var tmpSubTrdCd = sheetObj.CellValue(Row, 'sub_trd_cd');
					var tmpSlanCd 	= sheetObj.CellValue(Row, 'slan_cd');
					var tmpVvdCd 	= sheetObj.CellValue(Row, 'vvd_cd');
					var tmpPolYdCd 	= sheetObj.CellValue(Row, 'pol_yd_cd');
					var headCnt 	= sheetObj.HeaderRows;
					for (var i=headCnt; i<=sheetObj.LastRow; i++){
		    			if (tmpTrdCd == sheetObj.CellValue(i,'trd_cd') 
	    					&& tmpSubTrdCd == sheetObj.CellValue(i,'sub_trd_cd')
	    					&& tmpSlanCd == sheetObj.CellValue(i,'slan_cd')
	    					&& tmpVvdCd == sheetObj.CellValue(i,'vvd_cd')
	    					&& tmpPolYdCd == sheetObj.CellValue(i,'pol_yd_cd')
						){
		    				if (sheetObj.CellValue(i,'pod_yd_cd')!='+' && sheetObj.CellValue(i,'pod_yd_cd')!='-'){
			    				for (var j=0; consTpszArr!=null && j<consTpszArr.length; j++) {
			    					sheetObj.CellEditable(i,"mty_lodg_"+(consTpszArr[j]).toLowerCase()) = sheetObj.CellValue(Row,Col)=='1'?false:true;	
				    			}
		    				}
		    			}
	    			}
				}
	    		break;				
		}
	}
	
	// 저장후 메세지 표현
	function sheet1_OnSaveEnd(sheetObj, errMsg){
		var formObj = document.form;
		
		if (errMsg == "") {
			ComShowCodeMessage("EQR01001");
		}
	}
	
	// 조회 후 처리
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		for(var j=0; j<sheetObj.LastRow; j++){
			if(sheetObj.CellValue(j,'pod_yd_cd')=='+' || sheetObj.CellValue(j,'pod_yd_cd')=='-'){ // POL Row
				
				// ETD 를 경과하기 전 POL 에 대하여 , Available 에 MT Plan 을 빼고 MT BKG 를 더한다
				if(sheetObj.CellValue(j,"etd_past_flg") == "N"){
					//var vvd_str_row = sheetObj.GetColSameDataRange(j,"vvd_cd").split("|")[0]*1; // 해당 VVD의 시작 줄
					var vvd_str_row = Math.max( sheetObj.GetColSameDataRange(j,"vvd_cd").split("|")[0]*1,    // 해당 VVD의 시작 줄 과
					                            sheetObj.GetColSameDataRange(j,"trd_cd").split("|")[0]*1 );  // 해당 Traid의 시작 줄 중 큰 값
					var tmp_mt_pln = 0;
					var tmp_mt_bkg = 0;
					var tmp_mt_pln_ton = 0; //추가
					for(var i=vvd_str_row; i<=j; i++){
						if((sheetObj.CellValue(i,'pod_yd_cd')=='+' || sheetObj.CellValue(i,'pod_yd_cd')=='-') && (sheetObj.CellValue(i,"etd_past_flg") == "N")){
							tmp_mt_pln = tmp_mt_pln + sheetObj.CellValue(i,"mty_pln_teu")*1;
							tmp_mt_bkg = tmp_mt_bkg + sheetObj.CellValue(i,"mty_bkg_teu")*1;
							tmp_mt_pln_ton = tmp_mt_pln_ton + sheetObj.CellValue(i,"mty_pln_ton")*1; //추가
						}					
					}
					sheetObj.CellValue2(j,"show_avl_teu") = ComAddComma(sheetObj.CellValue(j,"avl_teu")*1 - tmp_mt_pln + tmp_mt_bkg) ;
					sheetObj.CellValue2(j,"show_avl_ton") = ComAddComma(sheetObj.CellValue(j,"avl_ton")*1 - tmp_mt_pln_ton); //추가
				}else{
					sheetObj.CellValue2(j,"show_avl_teu") = ComAddComma(sheetObj.CellValue(j,"avl_teu"));
					sheetObj.CellValue2(j,"show_avl_ton") = ComAddComma(sheetObj.CellValue(j,"avl_ton")); //추가
				}
//				sheetObj.CellValue2(j,"show_avl_ton") =  ComAddComma(Math.round(sheetObj.CellValue(j,"avl_teu")*2.2));
				
			}else{ // POD Row
				
				// BOOKING (MTY BKG) 이 해당 PLAN에 생성이 되면 (BKG Plan) UNCHECK 불가능하다
				if(!ComIsNull(sheetObj.CellValue(j,"mty_bkg_teu")) && sheetObj.CellValue(j,"mty_bkg_teu")!=0){
					sheetObj.CellEditable(j,"mty_pln_shw_flg") = false;
				}else if(!ComIsNull(sheetObj.CellValue(i,"mty_bkg_qty")) && sheetObj.CellValue(j,"mty_bkg_qty")!=0){
					sheetObj.CellEditable(j,"mty_pln_shw_flg") = false;
				}else{
					for (var i=0; consTpszArr!=null && i<consTpszArr.length; i++) {
						if (!ComIsNull(sheetObj.CellValue(j,"mty_bkg_"+(consTpszArr[i]).toLowerCase()))){
							sheetObj.CellEditable(j,"mty_pln_shw_flg") = false;
							break;
						}
					}
				}
			}
		}
		setPlanSelCondPOD(); // Plan Selecttion POD 선택 사항 반영
	}

	// 조회 후 처리
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		// L/F 값 뒤에 '%' 표시 붙이기
		var next_lf_row = sheetObj.FindText("dp_seq","2",sheetObj.HeaderRows); // L/F 줄 찾기
        while (next_lf_row != -1) {
			for(var j=4; j<sheetObj.LastCol; j++){ 
				if(sheetObj.CellValue(next_lf_row,j) != ""){
					sheetObj.InitCellProperty(next_lf_row,j,dtData,daRight,sheetObj.SaveNameCol(j),"",dfNone); // DataFormat 변경
					sheetObj.CellValue2(next_lf_row,j) = sheetObj.CellValue(next_lf_row,j)+"%";
				}
			}
			next_lf_row = sheetObj.FindText("dp_seq","2",next_lf_row*1+1);     // 다음 줄 찾기
		}
		setInfoSelCond(); // Information Selecttion 선택 사항 반영
	}
	
	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		
		formObj.s_dt_tp_cd[0].checked= true;	
		
		formObj.s_eff_st_dt.value = "";
		formObj.s_eff_end_dt.value = "";
		
		formObj.s_fcbf_st_dt.value = "";
		formObj.s_fcbf_end_dt.value = "";
		
		chg_dt_tp();
		
		formObj.trade.Code ="";
		formObj.subtrade.Code ="";
		formObj.lane.Code = "";
		
		//CNTR TY/SZ DRY로 설정
		formObj.tpsz.value ="D";
		tpszChange("D");
	
		formObj.rcc_cd.value = "";
		formObj.loc_tp_cd_second.value = "L";
		formObj.s_vvd_cd.value = "";
		formObj.vvdrslt.Code = "";
		
		sheetObj.RemoveAll();
		sheetObj2.RemoveAll();
	}
	 
	 /**
	  * Radio Button Click Event
	  */
	function chg_dt_tp() {
		var formObj = document.form;
		
		if (formObj.s_dt_tp_cd[0].checked) {
			formObj.s_eff_st_dt.value = formObj.h_eta_fm_dt.value;
	 		formObj.s_eff_end_dt.value = formObj.h_eta_to_dt.value;
	 		formObj.s_fcbf_st_dt.value = "";
	 		formObj.s_fcbf_end_dt.value = "";
	 		
			ComEnableObject(formObj.s_eff_st_dt,true);
			ComEnableObject(formObj.s_eff_end_dt,true);
			ComEnableObject(formObj.btns_calendar_eff_dt,true);
			ComEnableObject(formObj.s_fcbf_st_dt,false);
			ComEnableObject(formObj.s_fcbf_end_dt,false);
			ComEnableObject(formObj.btns_calendar_fcbf_dt,false);

			formObj.s_eff_st_dt.className = "input";
			formObj.s_eff_end_dt.className = "input";
			
		} else if(formObj.s_dt_tp_cd[1].checked) {
			formObj.s_eff_st_dt.value = "";
			formObj.s_eff_end_dt.value = "";
	 		formObj.s_fcbf_st_dt.value = formObj.h_eta_fm_dt.value;
	 		formObj.s_fcbf_end_dt.value = formObj.h_eta_to_dt.value;

	 		ComEnableObject(formObj.s_eff_st_dt,false);
	 		ComEnableObject(formObj.s_eff_end_dt,false);
	 		ComEnableObject(formObj.btns_calendar_eff_dt,false);
			ComEnableObject(formObj.s_fcbf_st_dt,true);
			ComEnableObject(formObj.s_fcbf_end_dt,true);
			ComEnableObject(formObj.btns_calendar_fcbf_dt,true);
			
			formObj.s_fcbf_st_dt.className = "input";
			formObj.s_fcbf_end_dt.className = "input";
	 	}
	}
	
	/**
	 * 설  명 : To Date = From Date + 30  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     calToDate()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function calToDate(){
		formObj = document.form;
		var to_dt = calc_Date(formObj.eff_st_dt.value,30,true);
	
		if (formObj.eff_st_dt.value != "" && to_dt == "") {
			ComShowCodeMessage('EQR90222','YYYY-MM-DD');
			formObj.eff_st_dt.value = "";
			formObj.eff_end_dt.value = "";
			formObj.eff_st_dt.focus();
			return false;
		} else {
			formObj.eff_end_dt.value = to_dt;
		}
	}
	
	function setPlanSelCond() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		sheetObj.ColHidden('show_avl_ton') = !formObj.cbx_plan_sel_WT.checked;
		sheetObj.ColHidden('mty_pln_ton') = !formObj.cbx_plan_sel_WT.checked;
		
		sheetObj.ColHidden('mty_lodg_pln_teu') = !formObj.cbx_plan_sel_MP.checked;
		sheetObj.ColHidden('mty_lodg_pln_ton') = !formObj.cbx_plan_sel_MP.checked;
		sheetObj.ColHidden('fnl_cbf_flg') = !formObj.cbx_plan_sel_MP.checked;
		sheetObj.ColHidden('mty_pln_shw_flg') = !formObj.cbx_plan_sel_MP.checked;
		
		sheetObj.ColHidden('repo_gline_rmk') = !formObj.cbx_plan_sel_GL.checked;
		
		sheetObj.ColHidden('mty_bkg_teu') = !formObj.cbx_plan_sel_MB.checked;
		sheetObj.ColHidden('mty_bkg_qty') = !formObj.cbx_plan_sel_MB.checked;
		
		setGridHidden();

	}
	
	// OD(Except Null Data) / POD(All) 선택에 따라 POD row 를 보이거나 숨김
	function setPlanSelCondPOD(p_pod_tp) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var headCnt = sheetObj.HeaderRows;
		
		var pod_tp;
		if(p_pod_tp == null || p_pod_tp == ''){
			if(formObj.cbx_plan_sel_PN.checked){
				pod_tp = "PN";
			}else if(formObj.cbx_plan_sel_PA.checked){
				pod_tp = "PA";
			}
		}else{
			pod_tp = p_pod_tp;
		}
		
		if(!formObj.cbx_plan_sel_PN.checked && !formObj.cbx_plan_sel_PA.checked){ // 선택 없음 - Row 전부 오그리기
			formObj.cbx_plan_sel_PN.checked = false;
			formObj.cbx_plan_sel_PA.checked = false;
			for (var i=headCnt; i<=sheetObj.LastRow; i++){
				if (sheetObj.CellValue(i, 'pod_yd_cd') == '+' || sheetObj.CellValue(i, 'pod_yd_cd') == '-') {
						var tmp_row_sts = sheetObj.RowStatus(i);
						sheetObj.RowExpanded(i) = false;
						sheetObj.CellValue2(i,'pod_yd_cd') = "+";
						sheetObj.RowStatus(i) = tmp_row_sts;
				}
			}
		}else if (pod_tp=='PN'){ // POD(Except Null Data) 선택 - 데이터 없는 Row 오그리기 
			if (formObj.cbx_plan_sel_PN.checked) {
				formObj.cbx_plan_sel_PN.checked = true;
				formObj.cbx_plan_sel_PA.checked = false;
				for (var i=headCnt; i<=sheetObj.LastRow; i++){
					if (sheetObj.CellValue(i,'pod_yd_cd')=='+' || sheetObj.CellValue(i,'pod_yd_cd')=='-'){
						if (chkGlineAllValIsNull(sheetObj,i) && chkMtBkgAllValIsNull(sheetObj,i) && chkMtLodgPlnAllValIsNull(sheetObj,i)){
							var tmp_row_sts = sheetObj.RowStatus(i);
							sheetObj.RowExpanded(i) = false;
							sheetObj.CellValue2(i,'pod_yd_cd') = "+";
							sheetObj.RowStatus(i) = tmp_row_sts;
						}
					}
				}
			}
		} else if (pod_tp=='PA'){ // POD(All) 선택 - Row 다 펼치기
			if (formObj.cbx_plan_sel_PA.checked) {
				formObj.cbx_plan_sel_PN.checked = false;
				formObj.cbx_plan_sel_PA.checked = true;
				for (var i=headCnt; i<=sheetObj.LastRow; i++){
					if (sheetObj.CellValue(i,'pod_yd_cd')=='+' || sheetObj.CellValue(i,'pod_yd_cd')=='-'){
						var tmp_row_sts = sheetObj.RowStatus(i);
						sheetObj.RowExpanded(i) = true;
						sheetObj.CellValue2(i,'pod_yd_cd') = "-";
						sheetObj.RowStatus(i) = tmp_row_sts;
					}
				}
			}			
		}
	}
	
	function setInfoSelCond() {
		var formObj = document.form;
		var sheetObj2 = sheetObjects[1];
		var headCnt = sheetObj2.HeaderRows;
		
		sheetObj2.ColHidden('ttl_wt') = !formObj.cbx_info_sel_WT.checked;
		
		for (var i=headCnt; i<=sheetObj2.LastRow; i++){
			if (sheetObj2.CellValue(i,'dp_seq')=='3'){
				sheetObj2.RowHidden(i) = !formObj.cbx_info_sel_OB.checked;
			}
			if (sheetObj2.CellValue(i,'dp_seq')=='4'){				
				sheetObj2.RowHidden(i) = !formObj.cbx_info_sel_FE.checked;
			}
			if (sheetObj2.CellValue(i,'dp_seq')=='6'){
				sheetObj2.RowHidden(i) = !formObj.cbx_info_sel_EI.checked;
			}			
			if (sheetObj2.CellValue(i,'dp_seq')=='7'){
				sheetObj2.RowHidden(i) = !formObj.cbx_info_sel_OT.checked;
			}
		}
	}
