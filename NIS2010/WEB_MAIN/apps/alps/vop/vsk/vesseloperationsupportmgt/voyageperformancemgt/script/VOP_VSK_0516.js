/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_VSK_0516.js
*@FileTitle : Voyage Performance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 
	 */

	/**
	 * @extends
	 * @class User Management : User Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_VSK_0516() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
 
/* 개발자 작업 */
 
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sheetNames   = new Array("sheet1", "sheet2");
	var sheetInits   = new Array(   false,    false);
	
	var comboObjects = new Array();
	var comboCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj1 = sheetObjects[0];
		var frmObj 	= document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
				case "btn_calendar":
					////if (frmObj.vsl_flg.value != "VF") {
						var cal = new ComCalendar();
						cal.select(frmObj.curr_dt, 'yyyy-MM-dd');
						frmObj.vvd.value	= "";
						frmObj.vsl_port.RemoveAll();
					////}
					break; 
										
				case "btn_retrieve":
					doActionIBSheet(shtObj1, frmObj, IBSEARCH);
					break;			

				case "btn_new":
					ComResetAll();
					frmObj.curr_dt.value 	= frmObj.todate.value;;
					frmObj.curr_dt.disabled = false;
					////DomSetFormObjDisable(document.form, false);	
					frmObj.vsl_flg.value = "";	
					frmObj.vsl_port.RemoveAll();
					break;			

				case "btn_DownExcel":
					//::[]:://
					shtObj1.Down2Excel(1);
					break;
					
				case "sel_schedule":							//체크박스 선택에 따라 컬럼 hidden 여부 설정(col index로 구분, col 추가/삭제 시 index값 변경필요)
					if (frmObj.sel_schedule.checked) {
						flg = false;
						//doActionIBSheet(shtObj1, frmObj, IBSEARCH);
					} else {
						flg = true;
					}
					for (i=12; i<=15; i++) {
						shtObj1.ColHidden(i) = flg;
					}
					
					
					break;					

				case "sel_navi":							//체크박스 선택에 따라 컬럼 hidden 여부 설정(col index로 구분, col 추가/삭제 시 index값 변경필요)
					if (frmObj.sel_navi.checked) {
						flg = false;
						//doActionIBSheet(shtObj1, frmObj, IBSEARCH);
					} else {
						flg = true;
					}
					for (i=16; i<=26; i++) {
						shtObj1.ColHidden(i) = flg;
					}
					
					break;
					
				case "sel_consum":							//체크박스 선택에 따라 컬럼 hidden 여부 설정(col index로 구분, col 추가/삭제 시 index값 변경필요)
					if (frmObj.sel_consum.checked) {
						flg = false;
						if( frmObj.sel_navi.checked && frmObj.sel_schedule.checked){
							doActionIBSheet(shtObj1, frmObj, IBSEARCH);
						}else{
							frmObj.sel_navi.checked = true;
							frmObj.sel_schedule.checked = true;
							//alert( frmObj.sel_navi.checked  +" :: " + frmObj.sel_navi.checked );
							doActionIBSheet(shtObj1, frmObj, IBSEARCH);
						}
					} else {
						flg = true;
					}
					for (i=27; i<=36; i++) {
						shtObj1.ColHidden(i) = flg;
					}
					
					
					break;			

				case "sel_draft":							//체크박스 선택에 따라 컬럼 hidden 여부 설정(col index로 구분, col 추가/삭제 시 index값 변경필요)
					if (frmObj.sel_draft.checked) {
						flg = false;
						doActionIBSheet(shtObj1, frmObj, IBSEARCH);
					} else {
						flg = true;
					}
					for (i=37; i<=42; i++) {
						shtObj1.ColHidden(i) = flg;
					}
					
					break;				

				case "sel_cargo":							//체크박스 선택에 따라 컬럼 hidden 여부 설정(col index로 구분, col 추가/삭제 시 index값 변경필요)
					if (frmObj.sel_cargo.checked) {
						flg = false;
						doActionIBSheet(shtObj1, frmObj, IBSEARCH);
					} else {
						flg = true;
					}
					for (i=43; i<=61; i++) {
						shtObj1.ColHidden(i) = flg;
					}
					
					break;			
					
				case "btns_search":
					openLandCdHelp(shtObj1);
					break;	
					
				case "btn_vvd_search":
					var vslCd = frmObj.vvd.value.substr(0,4);
		          	var sUrl = "";
                	
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
					break;

			} // end switch

		} catch(e) {
			if (e == "[object Error]") {
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
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}

	/** 
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++] = combo_obj;  
    }
    
	/**
	 * Sheet initialization function
	 * <br><b>Example : </b>
	 * <pre>
	 * </pre>
	 * @param {int} idx mandatory, Sheet Index
	 * @return {void}
	 * @author
	 * @version
	 */
	function sheetInit(idx) {
		if (sheetInits[idx] == false) {
	        ComConfigSheet (sheetObjects[idx] );
	        initSheet(sheetObjects[idx],idx+1);
	        ComEndConfigSheet(sheetObjects[idx]);
	        sheetInits[idx] = true;
	    }
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}		

    	for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
   	
		initControl();

		document.form.vsl_slan_cd.focus();
		document.form.vsl_flg.value = "";
		
		
		// ※※※ sheet1_OnLoadFinish 메서드 반드시 참조 ※※※
	}

	/**
	* 시트 초기설정값, 헤더 정의
	* param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(shtObj, shtNo) {
		var cnt 	= 0;
		var sheetID = shtObj.id;
		
		switch (sheetID) {
			
		case "sheet1":
			with (shtObj) {
				var cnt = 0;
				// 높이 설정
				style.height = 385;

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
				InitRowInfo(3, 1, 3, 100);
				document.form.pagerows.value = 500;

				// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(false, false, false, true, false, false);
				
				// 컬럼 헤더타이틀
				////var HeadTitle1  = "|Signal Index|Signal Index|Signal Index|Index|Lane/Class|VVD|Status|From|To|Date|Schedule|Schedule|Schedule|Schedule|Run\nHrs|Distance|Distance|Distance|Speed|Speed|Speed|RPM|Slip|Slip|Daily FOC|Daily FOC|Daily FOC|Daily FOC|Daily FOC|From to FOC|From to FOC|From to FOC|From to FOC|From to FOC|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Gross PRD|Gross PRD|Gang Arrangement|Gang Arrangement|Gang Arrangement|Gang Arrangement|Loadable|Loadable|On Board|On Board|BSA|BSA|L/F|To Port(TEU)|To Port(TEU)|R/H|On Board|On Board|On Board";
				////var HeadTitle2  = "|Signal Index|Signal Index|Signal Index|Index|Lane/Class|VVD|Status|From|To|Date|Schedule|Schedule|Schedule|Schedule|Run\nHrs|Distance|Distance|Distance|Speed|Speed|Speed|RPM|Slip|Slip|Daily FOC|Daily FOC|Daily FOC|Daily FOC|Daily FOC|From to FOC|From to FOC|From to FOC|From to FOC|From to FOC|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Gross PRD|Gross PRD|From|From|From|To|Loadable|Loadable|On Board|On Board|BSA|BSA|L/F|To Port(TEU)|To Port(TEU)|R/H|RF|AWK|BB";
				
				var HeadTitle1  = "|Signal Index|Signal Index|Signal Index|Index|Class|Lane|VVD|Status|Previous|Next|Received\nDate|Schedule|Schedule|Schedule|Schedule|Run\nHrs|Distance|Distance|Distance|Speed|Speed|Speed|Speed|RPM|Slip|Slip|Daily FOC|Daily FOC|Daily FOC|Daily FOC|Daily FOC|Port to Port FOC|Port to Port FOC|Port to Port FOC|Port to Port FOC|Port to Port FOC|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Draft & Trim|Productivity|Productivity|No. of used Crane|No. of used Crane|No. of used Crane|No. of used Crane|Operation\ncapacity|Operation\ncapacity|BSA|BSA|On Board|On Board|L/F|Next Port(TEU)|Next Port(TEU)|R/H|Special Cargo|Special Cargo|Special Cargo|pps Desc";
				var HeadTitle2  = "|SKED|NAV|FOC|Index|Class|Lane|VVD|Status|Previous|Next|Received\nDate|ETA(P/F)|ETA(ALPS)|ETA(Noon)|Delay|Run\nHrs|Short|PPS|Noon|ETA|PPS|Noon|Diff|RPM|AVG|Noon|Standard|Calculated|PPS|Noon|Diff.|TTL\nStandard|Accumulated|Accumulated|Balance|Consumption\nRatio|FWD|AFT|Trim|Trim|Bow|Transum|Previous|Next|Previous|Previous|Previous|Next|TEU|WT|SML|Alliance|TEU|WT|TTL|I/B|O/B|EA|RF|AWK|BB|pps Desc";
				var HeadTitle4  = "|SKED|NAV|FOC|Index|Class|Lane|VVD|Status|Previous|Next|Received\nDate|ETA(P/F)|ETA(ALPS)|ETA(Noon)|Delay|Run\nHrs|Short|PPS|Noon|ETA|PPS|Noon|Diff|RPM|AVG|Noon|Standard|Calculated|PPS|Noon|Diff.|TTL\nStandard|Standard|Actual FOC|Balance|Consumption\nRatio|FWD|AFT|Trim|Trim|Bow|Transum|Previous|Next|ISTWG|AVG|USED|AVG|TEU|WT|SML|Alliance|TEU|WT|TTL|I/B|O/B|EA|EA|EA|EA|pps Desc";

				//				alert(ComCountHeadTitle(HeadTitle1)+","+ComCountHeadTitle(HeadTitle2)+","+ComCountHeadTitle(HeadTitle3)+","+ComCountHeadTitle(HeadTitle4));
				var headCount 	= ComCountHeadTitle(HeadTitle1);

				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				//InitHeadRow(2, HeadTitle3, true);s
				InitHeadRow(2, HeadTitle4, true);

				// Enter키를 눌렀을때 Tab키처럼 작동
				EditEnterBehavior = "tab";

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	40,      daCenter,    true,    "ibflag");    // [필수]

                //InitDataProperty(0, cnt++, dtData,  				50,     daCenter,    true,    "signal_sked_img",         	false,    "",    dfNone,    0,    false,     false);		//Signal Index - SKED 
				//InitDataProperty(0, cnt++, dtImage,         		50,     daCenter,    true,    "signal_navi_img",     		false,     "",    dfNone,    0,    false,     false);	//Signal Index - NAV
				//InitDataProperty(0, cnt++, dtImage,     			50,     daCenter,    true,    "signal_foc_img",     		false,     "",    dfNone,    0,    false,     true);		//Signal Index - FOC
				
                InitDataProperty(0, cnt++, dtData,  		35,     daCenter,    true,    "signal_sked_idx",         	false,    "",    dfNone,    0,    false,     false);		//Signal Index - SKED 
				InitDataProperty(0, cnt++, dtData,         	30,     daCenter,    true,    "signal_navi_idx",     		false,     "",    dfNone,    0,    false,     false);	//Signal Index - NAV
				InitDataProperty(0, cnt++, dtData,     		30,     daCenter,    true,    "signal_foc_idx",     		false,     "",    dfNone,    0,    false,     true);		//Signal Index - FOC
				
				InitDataProperty(0, cnt++, dtData,     		80,     daCenter,    true,    "signal_index",     		false,     "",    dfNone,    0,    false,     true);			//Index
				
				InitDataProperty(0, cnt++, dtHidden,     	45,     daRight,    true,    "cntr_dzn_capa",     		false,     "",    dfNone,    0,    false,     true);			//Lane Class
				
				InitDataProperty(0, cnt++, dtData,     		35,     daCenter,    true,    "vsl_slan_cd",     		false,     "",    dfNone,    0,    false,     true);			//Lane Class
				
				InitDataProperty(0, cnt++, dtData,     	   	70,     daCenter,    true,    "vvd",     		false,     "",    dfNone,    0,    false,     true, 2);			//VVD
				InitDataProperty(0, cnt++, dtData,         	60,     daCenter,    true,    "vsl_sts",		false,     "",    dfNone,    0,    false,     true);			//Status
				InitDataProperty(0, cnt++, dtData,         	60,     daCenter,    true,    "from_port_cd",      	false,     "",    dfNone,    0,    false,     true, 3);	//From
				InitDataProperty(0, cnt++, dtData,         	45,     daCenter,    true,    "to_port_cd",		false,     "",    dfNone,    0,    false,     true);			//To
				InitDataProperty(0, cnt++, dtData,         	95,     daCenter,    true,    "noon_rpt_dt",		false,     "",    dfNone,    0,    false,     true);		//Date

				//InitDataProperty(0, cnt++, dtData,     	45,     daRight,    true,    "cntr_dzn_capa",     		false,     "",    dfNone,    0,    false,     true);			//Lane Class
				
				InitDataProperty(0, cnt++, dtHidden,         95,    daCenter,    true,    "skd_pf_eta_dt",      		false,     "",    dfNone,    0,    false,     true, 3);	//schedule-ETA(P/F)
				InitDataProperty(0, cnt++, dtHidden,         110,    daCenter,    true,    "skd_loc_eta_dt",    		false,     "",    dfNone,    0,    false,     false);		//schedule-ETA(ALPS)
				InitDataProperty(0, cnt++, dtHidden,         110,    daCenter,    true,    "skd_rpt_eta_dt",      		false,     "",    dfNone,    0,    false,     false);	//schedule-ETA(Vessel)
				InitDataProperty(0, cnt++, dtHidden,         45,	daCenter,    true,    "skd_delay_hrs",      	false,     "",    dfFloat,    0,    false,     false);		//schedule-Delay
				
				InitDataProperty(0, cnt++, dtHidden,         55,	daRight,    true,    "navi_run_hrs",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-Run Hrs
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_opt_dist",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-OPT				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_dr_dist",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-DR		
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_noon_dist",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-Noon				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_eta_spd",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-ETA				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_pps_spd",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-PPS				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_noon_spd",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-Noon				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_speed_diff",      false,     "",    dfFloat,    0,    false,     false);		//navigation-Diff
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_rpm",      	false,     "",    dfFloat,    0,    false,     false);		//navigation-RPM				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_avg_slip",      	false,     "",    dfFloat,    0,    false,     false);	//navigation-AVG				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "navi_noon_slip",      	false,     "",    dfFloat,    0,    false,     false);	//navigation-Noon	
				
				InitDataProperty(0, cnt++, dtHidden,         70,	daRight,    true,    "csm_daily_foc_std",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-STD				
				InitDataProperty(0, cnt++, dtHidden,         70,	daRight,    true,    "csm_daily_foc_t_line",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-Cal.				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "csm_daily_foc_pps",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-PPS				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "csm_daily_foc_noon",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-Noon				
				InitDataProperty(0, cnt++, dtHidden,         115,	daCenter,    true,    "csm_daily_foc_diff",      	false,     "",    dfNone,    0,    false,     false);	//consumption-DIFF				
				
				////InitDataProperty(0, cnt++, dtHidden,         100,	daCenter,    true,    "csm_foc_rpt",      	false,     "",    dfNone,    0,    false,     false);	//consumption-Stand				
				InitDataProperty(0, cnt++, dtHidden,         60,	daRight,    true,    "csm_from_foc_std",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-Stand				
				
				InitDataProperty(0, cnt++, dtHidden,         70,	daRight,    true,    "csm_from_avg_std",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-A_STD				
				InitDataProperty(0, cnt++, dtHidden,         70,	daRight,    true,    "csm_from_avg_foc",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-A_FOC				
				InitDataProperty(0, cnt++, dtHidden,         50,	daRight,    true,    "csm_from_balance_foc",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-Balance				
				InitDataProperty(0, cnt++, dtHidden,         85,	daRight,    true,    "csm_from_ach_percentage",      	false,     "",    dfFloat,    0,    false,     false);	//consumption-Ach.%		
				
				InitDataProperty(0, cnt++, dtHidden,         45,	daRight,    true,    "opt_fwd_trim",      	false,     "",    dfFloat,    -1,    false,     false);		//Draft&Term - FWD				
				InitDataProperty(0, cnt++, dtHidden,         55,	daRight,    true,    "opt_aft_trim",      	false,     "",    dfFloat,    -1,    false,     false);		//Draft&Term - AFT				
				InitDataProperty(0, cnt++, dtHidden,         55,	daRight,    true,    "opt_trm",      		false,     "",    dfNone,    -1,    false,     false);		//Draft&Term-Trim				
				InitDataProperty(0, cnt++, dtHidden,         55,	daCenter,    true,    "opt_trm_img",      	false,     "",    dfNone,    -1,    false,     false);		//Draft&Term-Trim			
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "opt_bow_hgt",      	false,     "",    dfFloat,    -1,    false,     false);		//Draft&Term-Bow					
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "opt_trsm_hgt",      	false,     "",    dfFloat,    -1,    false,     false);		//Draft&Term-Transum					
				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_from_gross_prod",      	false,     "",    dfFloat,    0,    false,     false);		//Cargo operation-From				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_to_gross_prod",      	false,     "",    dfFloat,    0,    false,     false);			//Cargo operation-To		
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_from_stwg_arrangement",      	false,     "",    dfFloat,    0,    false,     false);		//Cargo operation-ISTWG				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_from_avg_arrangement",      	false,     "",    dfFloat,    0,    false,     false);		//Cargo operation-AVG				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_from_used_arrangement",      	false,     "",    dfFloat,    0,    false,     false);		//Cargo operation-USED				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_to_avg_arrangement",      	false,     "",    dfFloat,    0,    false,     false);		//Cargo operation-AVG			
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,     "cgo_vol_teu_qty",      	false,     "",    dfInteger,    0,    false,     false);			//Cargo operation-Loadable TEU			
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,     "cgo_vol_wgt",      	false,     "",    dfFloat,    0,    false,     false);		//Carog operation-Loadable WT				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_bsa_hjs_qty",      	false,     "",    dfInteger,    0,    false,     false);		//Carog operation-BSA SML			
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_bsa_alliance_qty",      	false,     "",    dfInteger,    0,    false,     false);		//Carog operation-BSA Alliance								
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_onboard_teu_qty",      	false,     "",    dfInteger,    0,    false,     false);		//Cargo operation-On Board TEU				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_onboard_wgt",      	false,     "",    dfFloat,    0,    false,     false);		//Cargo operation-On Board WT				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_total_lf_ratio",      	false,     "",    dfNone,    0,    false,     false);		//Cargo operation-TTL				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_to_ib_teu_qty",      	false,     "",    dfInteger,    0,    false,     false);		//Carog operation-I/B				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_to_ob_teu_qty",      	false,     "",    dfInteger,    0,    false,     false);		//Cargo operation-O/B				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_rhdl_qty",      	false,     "",    dfInteger,    0,    false,     false);		//Cargo operation-R/H EA				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_rf_qty",      	false,     "",    dfInteger,    0,    false,     false);		//cargo operation-RF EA				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_ak_qty",      	false,     "",    dfInteger,    0,    false,     false);		//cargo operation-AWK EA				
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "cgo_bb_qty",      	false,     "",    dfInteger,    0,    false,     false);		//cargo operation-BB EA		
			
				InitDataProperty(0, cnt++, dtHidden,         80,	daRight,    true,    "pps_desc",      	false,     "",    dfNone,    0,    false,     false);		//
				//setHiddenInitDataProperty(shtObj, cnt++, "pps_desc");
				
				WaitImageVisible 	= false;
				HeadRowHeight 		= 20;
				
				//InitUserFormat(0, "cgo_total_lf_ratio", "#,###.#%");		//InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
				//InitUserFormat2(0, "navi_run_hrs", "#,##0.", "");
				
/*				SetMergeCell(0,1,3,3);		//Signal Index
				SetMergeCell(0,11,3,4);		//schedule
				SetMergeCell(1,16,2,3);		//navigation- distance
				SetMergeCell(1,19,2,3);		//navigation- speed
				SetMergeCell(1,23,2,2);		//navigation- slip
				SetMergeCell(1,25,2,5);		//consumption - daily FOC
				SetMergeCell(1,30,2,5);		//consumption - From to FOC
				SetMergeCell(0,35,3,6);		//opt trim - Draft & trim
				SetMergeCell(1,41,2,2);		//Cargo operation - Gross PRD
				SetMergeCell(1,47,2,2);		//Cargo operation - Loadable
				SetMergeCell(1,49,2,2);		//Cargo operation - On Board
				SetMergeCell(1,51,2,2);		//Cargo operation - BSA
				SetMergeCell(1,54,2,2);		//Cargo operation - To Port (TEU)
*/				
				ImageList(0)	= "/hanjin/img/btng_icon_green.gif";
				ImageList(1)	= "/hanjin/img/btng_icon_y.gif";
				ImageList(2)	= "/hanjin/img/btng_icon_r.gif";
				
				ImageList(3)	= "/hanjin/img/alps/angle_left_12.gif";
				ImageList(4)	= "/hanjin/img/alps/angle_center_12.gif";
				ImageList(5)	= "/hanjin/img/alps/angle_right_12.gif";
				
				//FrozenCols 		= 8;		 
				FrozenCols 		= SaveNameCol("vvd");
				
			}
			
			break;
		}
	}
	
	
	/**
	 * OnSearchEnd 이벤트
	 * @param sheetObj
	 * @param ErrMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		
		sheetObj.Redraw = false;
		
		var lastRow		= sheetObj.LastRow;
		
		with(sheetObj){
			
			for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				
				if(CellValue(i, "vvd")	== CellValue(i+2, "vvd") && CellValue(i, "from_port_cd")	== CellValue(i+2, "from_port_cd")){
					CellFontColor	(i+1,"vvd")								= RgbColor(234, 234, 234);
					CellFontColor	(i+1,"vsl_slan_cd")						= RgbColor(234, 234, 234);
					CellFontColor	(i+1,"vsl_sts")							= RgbColor(234, 234, 234);
					CellFontColor	(i+1,"from_port_cd")					= RgbColor(234, 234, 234);
					CellFontColor	(i+1,"to_port_cd")						= RgbColor(234, 234, 234);
				}
				
				//::SCHEDULE:://
				//::<<====================================================================================>>:://
				if(CellValue(i,"skd_loc_eta_dt") != CellValue(i,"skd_rpt_eta_dt")){
					CellFont		("FontBold"	,i,"skd_rpt_eta_dt")		= true;
					CellFontColor	(i,"skd_rpt_eta_dt")					= RgbColor(255, 0, 0);
				}

				if(CellValue(i,"signal_sked_idx") == "RED"){
					CellFont		("FontBold"	,i,"skd_delay_hrs")			= true;
					CellFontColor	(i,"skd_delay_hrs")						= RgbColor(255, 0, 0);
				}else if(CellValue(i,"signal_sked_idx") == "YELLOW"){
					CellFont		("FontBold"	,i,"skd_delay_hrs")			= true;
					CellFontColor	(i,"skd_delay_hrs")						= RgbColor(255, 187, 0);
				}else{
					CellFont		("FontBold"	,i,"skd_delay_hrs")			= true;
				}
				//::<<====================================================================================>>:://
				
				//::NAVIGATION:://
				//::<<====================================================================================>>:://
				if(CellValue(i,"signal_navi_idx") == "RED"){
					CellFont		("FontBold"	,i,"navi_noon_spd")			= true;
					CellFontColor	(i,"navi_noon_spd")						= RgbColor(255, 0, 0);
				}else if(CellValue(i,"signal_navi_idx") == "YELLOW"){
					CellFont		("FontBold"	,i,"navi_noon_spd")			= true;
					CellFontColor	(i,"navi_noon_spd")						= RgbColor(255, 187, 0);
				}else{
					CellFont		("FontBold"	,i,"navi_noon_spd")			= true;
				}
				//::<<====================================================================================>>:://	
				
				//::CONSUMPTION:://
				//::<<====================================================================================>>:://
				if(CellValue(i,"signal_foc_idx") == "RED"){
					CellFont		("FontBold"	,i,"csm_daily_foc_noon")	= true;
					CellFontColor	(i,"csm_daily_foc_noon")				= RgbColor(255, 0, 0);
				}else if(CellValue(i,"signal_foc_idx") == "YELLOW"){
					CellFont		("FontBold"	,i,"csm_daily_foc_noon")	= true;
					CellFontColor	(i,"csm_daily_foc_noon")				= RgbColor(255, 187, 0);
				}else{
					CellFont		("FontBold"	,i,"csm_daily_foc_noon")	= true;
				}
				//::<<====================================================================================>>:://	
				
				
				if(CellValue(i, "signal_sked_idx") == "GREEN") {
					InitCellProperty(i, "signal_sked_idx", dtImage, daCenter, "signal_sked_idx", "");
					//InitDataProperty(0, cnt++, dtImage, 40, daCenter, true, prefix + "atch_file_knt", false, "", dfNone, 0, false, true);
					CellImage(i,"signal_sked_idx") = 0;
				} else if (CellValue(i, "signal_sked_idx") == "YELLOW"){
					InitCellProperty(i, "signal_sked_idx", dtImage, daCenter, "signal_sked_idx", "");
					CellImage(i,"signal_sked_idx") = 1;
				} else if (CellValue(i, "signal_sked_idx") == "RED"){
					InitCellProperty(i, "signal_sked_idx", dtImage, daCenter, "signal_sked_idx", "");
					CellImage(i,"signal_sked_idx") = 2;
				}
				
				if(CellValue(i, "signal_navi_idx") == "GREEN") {
					InitCellProperty(i, "signal_navi_idx", dtImage, daCenter, "signal_navi_idx", "");
					CellImage(i,"signal_navi_idx") = 0;
				} else if (CellValue(i, "signal_navi_idx") == "YELLOW"){
					InitCellProperty(i, "signal_navi_idx", dtImage, daCenter, "signal_navi_idx", "");
					CellImage(i,"signal_navi_idx") = 1;
				} else if (CellValue(i, "signal_navi_idx") == "RED"){
					InitCellProperty(i, "signal_navi_idx", dtImage, daCenter, "signal_navi_idx", "");
					CellImage(i,"signal_navi_idx") = 2;
				}			
				
				if(CellValue(i, "signal_foc_idx") == "GREEN") {
					InitCellProperty(i, "signal_foc_idx", dtImage, daCenter, "signal_foc_idx", "");
					CellImage(i,"signal_foc_idx") = 0;
				} else if (CellValue(i, "signal_foc_idx") == "YELLOW"){
					InitCellProperty(i, "signal_foc_idx", dtImage, daCenter, "signal_foc_idx", "");
					CellImage(i,"signal_foc_idx") = 1;
				} else if (CellValue(i, "signal_foc_idx") == "RED"){
					InitCellProperty(i, "signal_foc_idx", dtImage, daCenter, "signal_foc_idx", "");
					CellImage(i,"signal_foc_idx") = 2;
				}			
				
				//::VESSEL TRIM (BOW, TRANSUM):://
				if(CellValue(i, "opt_trm") != ''){
					
					if(CellValue(i, "opt_trm") > 0) {
						InitCellProperty(i, "opt_trm_img", dtImage, daCenter, "opt_trm_img", "");
						CellImage(i,"opt_trm_img") = 3;
					} else if (CellValue(i, "opt_trm") == 0){
						InitCellProperty(i, "opt_trm_img", dtImage, daCenter, "opt_trm_img", "");
						CellImage(i,"opt_trm_img") = 4;
					//} else if (CellValue(i, "opt_trm") < 0){
					} else {	
						InitCellProperty(i, "opt_trm_img", dtImage, daCenter, "opt_trm_img", "");
						CellImage(i,"opt_trm_img") = 5;
					}	
					
				}
				
				sheetObj.Redraw = true;
			}
		}

	}
	
	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {   	    
			case "cntr_dzn_capa":
	    		ComOpenWait(true);
				class_combo(sheetObjects[0],document.form,IBSEARCH,comboObjects[0]);
	    		ComOpenWait(false);
				with (comboObj) { 
					MultiSelect 	= true;
					UseAutoComplete = true;	
					SetColAlign		("left");        
					SetColWidth		("50");
					DropHeight 		= 160;
		    	}
		   		break;
		   		
			case "vsl_port":
				with (comboObj) { 
					MultiSelect 	= true;
					UseAutoComplete = true;	
					SetColAlign		("left");        
					SetColWidth		("50");
					DropHeight 		= 160;
		    	}
		   		break;   	    
	    }
   	}

	/**
	* Form의 Conrol 초기화 및 초기 이벤트 등록
	*/
	function initControl() {
		// 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)
		axon_event.addListenerForm	("beforedeactivate"	, "frmObj_OnBeforeDeactivate"	, document.form	);
		axon_event.addListenerFormat("beforeactivate"	, "frmObj_OnBeforeActivate"		, document.form	);
		axon_event.addListenerFormat("keypress"			, "frmObj_OnKeyPress"			, document.form	);
		axon_event.addListenerFormat('keyup'			, 'frmObj_OnKeyUp' 				, form			);
	}
	
	/**
	 * Form Element의  OnBeforeDeactivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeDeactivate() {
		ComChkObjValid(window.event.srcElement);
	}


	/**
	 * Form Element의 OnBeforeActivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeActivate() {
		ComClearSeparator(window.event.srcElement);
	}
	
	/**
	 * Form Element의 OnKeyPress 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
	 */
	function cntr_dzn_capa_OnChange() {
		
		var formObject 	= document.form;
		var comboValue	= formObject.cntr_dzn_capa.Code;
		var	colInxLane	= 6;
		var colInxClass	= 5;
		
		if(comboValue == null || comboValue == ""){
			sheetObjects[0].ColHidden(colInxLane) 	= false;
			sheetObjects[0].ColHidden(colInxClass) 	= true;
		}else{
			sheetObjects[0].ColHidden(colInxLane) 	= true;
			sheetObjects[0].ColHidden(colInxClass) 	= false;
		}
	}
	
	/**
	 * Form Element의 OnKeyPress 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
	 */
	function frmObj_OnKeyPress() {
		var obj = window.event.srcElement;
		if (obj.dataformat == null) return;

		switch (obj.dataformat) {
			case "ymd":
			case "ym":
			case "hms":
			case "hm":
			case "jumin":
			case "saupja":
				ComKeyOnlyNumber(obj);
				break;

			case "int":
				ComKeyOnlyNumber(obj, "-");
				break;

			case "float":
				ComKeyOnlyNumber(obj, "-.");
				break;

			case "eng":
				ComKeyOnlyAlphabet("num", "32|64|~");
				break;

			case "engup":
				ComKeyOnlyAlphabet("uppernum");
				break;

			case "engdn":
				ComKeyOnlyAlphabet("lowernum");
				break;	
		}
	}
	
	/**
	 * 필드 데이타가 CHANGE될 경우 이벤트
	 */
	function frmObj_OnKeyUp(){
		
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	            
	        	case "vsl_slan_cd":
		        	var cnt = formObject.vsl_slan_cd.value;
					cnt = cnt.length;
		
					if(cnt == 3){
						doActionIBSheet(sheetObjects[0], formObject, SEARCH02);
					}
	        	break;
	        	
	        	case "vvd":
		        	var cnt = formObject.vvd.value;
					cnt 	= cnt.length;
		
					if(cnt == 9){
						doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
					}else if(cnt == 0){
						formObject.curr_dt.disabled 		= false;
						formObject.btn_calendar.disabled	= false;
						formObject.vsl_port.RemoveAll();
						////DomSetFormObjDisable(document.form, false);	
						if(formObject.curr_dt.value == formObject.todate.value || formObject.curr_dt.value == "" || formObject.curr_dt.value == null){
							formObject.curr_dt.value			= formObject.todate.value;
						}
					}	 
	        	break;
	                
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
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
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case IBSEARCH:    // 조회
				if(!validateForm(shtObj,frmObj,sAction)) return;  // VALIDATION
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				
				//shtObj.showDebugMsg	= true;
				
				shtObj.DoSearch("VOP_VSK_0516GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;		
				
			case SEARCH02:			//Lane 유효값 조회
				ComOpenWait(true);			
				frmObj.f_cmd.value = COMMAND12;
				var sParam = "f_cmd="+ frmObj.f_cmd.value +
							"&vsl_slan_cd=" +frmObj.vsl_slan_cd.value;
				var sXml = shtObj.GetSearchXml("VOP_VSK_0202GS.do", sParam);
				var checkLane = ComGetEtcData(sXml, "checkLane");
				
				if(checkLane == undefined){
					shtObj.LoadSearchXml(sXml);
					frmObj.vsl_slan_cd.value = "";	
					frmObj.vsl_slan_cd.focus();
					
				}else{
					var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
					
					if(vslSlanNm == ""){
						ComShowCodeMessage('VSK00021', frmObj.vsl_slan_cd.value);
						frmObj.vsl_slan_cd.value = "";	
						frmObj.vsl_slan_cd.focus();
					}else{
						frmObj.cntr_dzn_capa.focus();
					}
				}
				
				ComOpenWait(false);				
			break;
			
			case SEARCH03:			//VVD 유효값 조회
				ComOpenWait(true);			
				frmObj.f_cmd.value = SEARCH03;
				var sParam = "f_cmd="+ frmObj.f_cmd.value +
							"&vvd=" +frmObj.vvd.value;
				
				var sXml = shtObj.GetSearchXml("VOP_VSK_0516GS.do", sParam);
				
				if (ComGetEtcData(sXml,"vvd_rtn") == "0") {
					ComShowCodeMessage('COM132201', frmObj.vvd.value);
					frmObj.vvd.value = "";	
					frmObj.vvd.focus();	
					
					frmObj.curr_dt.value = frmObj.todate.value;;
					frmObj.curr_dt.disabled = false;
					////DomSetFormObjDisable(document.form, false);	
					frmObj.vsl_flg.value = "";	
					frmObj.vsl_port.RemoveAll();
				} else {																// VVD가 있으면 Port to Port 가져오기
					vessel_port_to_port();
				}
				
				ComOpenWait(false);				
			break;
		}
	}
	
	 /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch (sAction) {
    		case IBSEARCH:    		
	    	
    			// Date 입력값 체크
    			if (document.form.curr_dt.value == '' && document.form.vvd.value == '') {
    				ComShowCodeMessage('VSK00027', 'Date or Vessel');
    				document.form.curr_dt.focus();
    				return false;
    			}
    			
    			//::2007816::2014-05-21::TEMPORARY SETTING:://
    			document.form.vsl_flg.value 	= "VF";
    			
    			// Vessel 값 있을때 자리수 체크
    			if (document.form.vsl_flg.value != "VF") {
    				if (document.form.vvd.value != "") {
    					ComShowCodeMessage('COM132201', document.form.vvd.value);
    					return false;
    				}
    			}    	
    		}   	
    	}
    	return true;
    }
   	
	//Class combo리스트 조회
	function class_combo(sheetObj,formObj,sAction,sComboObj,sComboAction) {
		//콤보필드를 초기화시킨다.
		sComboObj.RemoveAll();
							
		formObj.f_cmd.value = SEARCH01;
		
		var param = "f_cmd=" + SEARCH01;
		var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", param);
		var comboItems = ComGetEtcData(sXml, "vslCls");
		
		idxArr = comboItems.split("|");
		appendMultiComboItem(getComboObject("cntr_dzn_capa"), idxArr, idxArr);
	}
	
	function vessel_port_to_port(){
		var frmObj = document.form;
		
		frmObj.vsl_port.RemoveAll();
		
		frmObj.f_cmd.value = SEARCH04;
		var sParam = "f_cmd="+ frmObj.f_cmd.value +	"&vvd=" +frmObj.vvd.value;
		
		var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0516GS.do", sParam);
		var comboItems = ComGetEtcData(sXml, "port_to_port");
		
		idxArr = comboItems.split("|");
		appendMultiComboItem(getComboObject("vsl_port"), idxArr, idxArr);
		
		//Date 비활성화
		frmObj.curr_dt.value = "";
		//:2014-06-18::frmObj.curr_dt.disabled = true;
		////DomSetFormObjDisable(document.form, true);
		frmObj.vsl_flg.value = "VF";
	}
   	   	
   	/**
   	 * Mutil Combo에 item을 추가한다.
   	 * @param comboObj
   	 * @param optionCds
   	 * @param optionTxts
   	 * @param selCode
   	 * @return
   	 */
   	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
   		comboObj.RemoveAll();
   		for(var i=0; i<optionCds.length; i++) {
   			comboObj.InsertItem(i, optionTxts[i], optionCds[i]);
   		}
   	}
		
   	/**
   	 * Lane Code Help 파일을 오픈한다
   	 */
   	function openLandCdHelp(sheetObj){
   	   var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
   	   var v_display = "0,0";
   	   var laneCd = document.form.vsl_slan_cd.value;
   		ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);

   	}
   	
   	/**
   	 * VVD 팝업 조회 결과 받아오기
   	 * @param obj
   	 */
   	function getVvdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vvd.value = rtnDatas[1]+rtnDatas[2]+rtnDatas[3];
					vessel_port_to_port();
				}
			}
    	}
    }
   	
   	
   	/**
	 * 
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */

	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		
	    if(sheetObj.RowCount > 0){
	        var Row = sheetObj.MouseRow;
	        var Col = sheetObj.MouseCol;
	        var prefix = sheetObj.id+"_";
	        
	        
	        if(Row > 0 && Col == 18){
	        	var desc = sheetObj.CellValue(Row, "pps_desc");
	        		        	
	        	sheetObj.MouseToolTipText = desc;
		        sheetObj.MousePointer = "Hand";
		        
	        }
	    }    
	}

/* 개발자 작업 끝 */
