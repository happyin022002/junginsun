/*=================================================================================================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_CGM_1157.js
*@FileTitle : Land Inventory Monitoring
*Open Issues :
*Change history : 2014-07 CHM-201430787 [EES_CGM_1157] Land Inventory Monitoring function development request에서 수정 및 변경 건
*                 2015-03-17 CHM-201534671, 신용찬, 1. COP_HDR 에서 MASTER='Y' 인 MST_BKG_NO 로 TRS 정보를 조회(TRS는 MASTER BKG 으로 W/O 생성)
                                                   2. FACTORY NAME 정보 추가
                                                   3. NTFY 조회 되던 내용 CNEE 로 수정
                                                   4. VVD 검색조건 추가, (EVENT DATE 는 OPTINAL)
                  2015-07-22 CHM-201537162, 신용찬, TRS Door W/O From 추가, TRS W/O 연결조건 변경                                                                        
*@LastModifyDate : 2015-07-22
*@LastModifier : 
*@LastVersion : v1.1
=================================================================================================================================*/
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
	function EES_CGM_1157() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.setComboObject			= setComboObject;
		this.setTabObject			= setTabObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.validateForm			= validateForm;
		this.tab1_OnChange			= tab1_OnChange;
		this.t1sheet1_OnSearchEnd	= t1sheet1_OnSearchEnd;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var comboObjects = new Array();
	var comboCnt = 0 ;

	var tot_cntr_tpsz_cd ="";
	var HeadTitleCnt =0;
	var headCnt = 0;
	
	//TP/SZ 
//	var uTpSz = new Array(); 
	
	var IBSEARCH01  = 29;
	var IBSEARCH02  = 30;
	var IBSEARCH03  = 31;
	var IBSEARCH04  = 32;
	var IBSEARCH05  = 33;
	var IBSEARCH06  = 34;
	
	var backEndJobKey = "";
   
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];	
		/*********************************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {


			case "btn_Retrieve":	//조회
				
				if(tabObjects[0].SelectedIndex == 0) {
					sheetObject1.RemoveAll();
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				} else {
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1,document.form,IBSEARCH02);
				}
				
				break;
				
			case "btn_new":		//조회조건 초기화								
				ComResetAll();
				document.getElementById("fm_dt").className = "input1";  // 필수입력으로 변경
				document.getElementById("lt_dt").className = "input1";  // 필수입력으로 변경				
				break;				
				
			case "btn_downexcel":	//DOWN EXCEL
				
				if(tabObjects[0].SelectedIndex == 0) {
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				} else {
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
				}
				
				break;
			
			case "loc_no_multi":		
				rep_Multiful_inquiry("loc_list");			
				break;	
				
			case "bkg_no_multi":		
				rep_Multiful_inquiry("bkg_no");			
				break;	
				
			case "sc_no_multi":		
				rep_Multiful_inquiry("sc_no");			
				break;	
				
			case "cntr_no_multi":		
				rep_Multiful_inquiry("cntr_no");			
				break;	
				
			case "vvd_no_multi":		
				rep_Multiful_inquiry("vvd_no");			
				break;					

			case "btn_calendar": 
				var cal = new ComCalendarFromTo();		
				cal.select(formObject.fm_dt, formObject.lt_dt, 'yyyy-MM-dd');
				break;								
				
			} // end switch
		} catch(e) {
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
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// Tab Object 초기화
		for(j=0;j<tabObjects.length;j++){
			initTab(tabObjects[j],j+1);
		}
		
		// IBMultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
		initControl();
		
	}

	function initSheet(sheetObj,sheetNo,headTitle) {
		var cnt = 0;
		
		switch (sheetNo) {
			case 1:	//t1sheet1 init
			with (sheetObj) {
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					// 높이 설정
				style.height = 346;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 1, 100);  // 1줄을 패키지로 사용
				document.form.pagerows.value = 500;
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(false, true, true, true, false,false)
				
					// 컬럼 헤더타이틀
				headTitle = "Seq|LCC|LOC|Yard|F/M|Finished|Former\nMVMT|Latter\nMVMT|TP/SZ|VOL\n(box)|Staying\nDays|";
				headTitle = headTitle + "Beyond\nF.Days /\nCS Date|Average\nS.Days|Average\nBeyond\nDays|Total CHZ\nFee\n(USD)|MVMT";
				 
				var headCount = ComCountHeadTitle(headTitle);
					
				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, headTitle, true)
				
				// Enter키를 눌렀을때 Tab키처럼 작동
				EditEnterBehavior = "tab";
				
				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,		35,		daCenter,	true,		"seq",			false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"lcc_cd",		false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"loc_cd",		false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"org_yd_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	true,		"fcntr_flg",	false,		"",			dfNone,		0,			false,		false);		//F/M
				InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	true,		"finished",		false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"fm_sts_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"lt_sts_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"cntr_tpsz_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"box",			false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,		"stay_dys",		false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"bynd_fdys",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"avg_stay_dys",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"avg_bynd_fdys",false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daRight,	true,		"chz_tot",		false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,		"mvmt_cd",		false,		"",			dfNone,		0,			false,		false);
				
				WaitImageVisible = false;
				
				Ellipsis = true;
				
			}	
			break;
			
			case 2:	  //t2sheet2 init
				with (sheetObj) {
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						// 높이 설정
					style.height = 346;

					  // 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 1, 100);  // 1줄을 패키지로 사용
					document.form.pagerows.value = 500;
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					//InitHeadMode(false, true, true, true, false,false)
					/* 2014.07.01 Chang Young Kim Added In accordance with the "CHM-201430787" (S) */
					InitHeadMode(true, true, true, true, false,false)
					/* 2014.07.01 Chang Young Kim Added In accordance with the "CHM-201430787" (E) */
	
						// 컬럼 헤더타이틀
					headTitle = "Seq|LCC|ECC|SCC|LOC|Yard|CNTR No|TP/SZ|F/M|Finished|MVMT|Former\nMVMT|Former\nMVMT\nDate|Former\nMVMT\nTime|Latter\nYard|Latter\nMVMT|Latter\nMVMT\nDate|Latter\nMVMT\nTime|Staying\nDays|Free\nDays|";
					headTitle = headTitle + "Beyond\nF.Days /\nCS Date|RCV/DEL\nTerm|SC/RFA No|Contact Customer|Clock\nStop|CS Date|CHZ\nExempt|CHZ Pay\nFlag|CHZ\nAGMT No.|CHZ\nPOOL|CHZ\nVendor\nCode|CHZ\nVendor\nName|Daily\nCHZ Fee\n(USD)|Total CHZ\nFee\n(USD)|Trucker\nCode|Trucker Name|CHZ No|";
					headTitle = headTitle + "DEM/DET\nStatus|DEM/DET\nFrom|DEM/DET\nTo|DEM/DET\nTariff|DEM/DET\nFee Time|DEM/DET\nBillable\nDays|DEM/DET\nFrom DT|DEM/DET\nTo DT|DEM/DET\nMT DT|DEM/DET\nF/T CMNC|";
					headTitle = headTitle + "DEM/DET\nF/T End|DEM/DET\nCurrency|DEM/DET\nBillable AMT|TRS W/O\nS/P Code|TRS W/O\nS/P Name|TRS W/O\nISS User|TRS Door\nW/O From|Appointment\nDate|Appointment\nTime|Delivery\nDate|Delivery\nTime|TRS W/O\nINV STS|";
					headTitle = headTitle + "TRS W/O\nINV CNFM\nDate|BKG No|B/L No|Bound|POL/POD\nYard|POR/DEL\nNode|Trunk VVD|POL ETD/\nPOD ETA|Factory|SHPR|CNEE|CMDT|RF|DMG|UC|Contact\nOFC|Contract\nSales Rep"; // Factory 추가
					 
						var headCount = ComCountHeadTitle(headTitle);
						
						// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, headTitle, true)

						// Enter키를 눌렀을때 Tab키처럼 작동
						EditEnterBehavior = "tab";
		
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,	true,		"seq",				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"lcc_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"ecc_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"scc_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"loc_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"org_yd_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"cntr_no",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"cntr_tpsz_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		35,		daCenter,	true,		"fcntr_flg",		false,		"",			dfNone,		0,			false,		false);		//F/M
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,		"finished",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"mvmt_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"fm_sts_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"fm_dt",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"fm_tm",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"lt_yd_cd",			false,		"",			dfNone,		0,			false,		false);		//Latter Yard
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"lt_sts_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"lt_dt",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"lt_tm",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"stay_dys",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"free_days",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,		"bynd_fdys",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"de_term_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,		"sc_rfa_no",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		240,	daLeft,		true,		"sc_cust_nm",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"cs_flg",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,		"cs_dt",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,		"chz_except",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"chz_pay_flg",		false,		"",			dfNone,		0,			false,		false);		//CHZ Pay Flag
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"chz_agmt_no",		false,		"",			dfNone,		0,			false,		false);		//CHZ AGMT No.
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"chz_pool_cd",		false,		"",			dfNone,		0,			false,		false);		//CHZ POOL
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"chz_vndr_seq",		false,		"",			dfNone,		0,			false,		false);		//CHZ Vendor Code
					InitDataProperty(0, cnt++ , dtData,		200,	daLeft,		true,		"chz_vndr_nm",		false,		"",			dfNone,		0,			false,		false);		//CHZ Vendor Name
					InitDataProperty(0, cnt++ , dtData,		55,		daRight,	true,		"chz_rt",			false,		"",			dfNone,		0,			false,		false);		//Daily CHZ Fee(USD)
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	true,		"chz_tot",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,		"trk_vndr_seq",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		200,	daLeft,		true,		"trk_vndr_nm",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"chss_no",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"dmt_chg_sts_cd",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"dmt_fm_sts_cd",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"dmt_to_sts_cd",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"dmt_trf_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,		"dmt_ft_dys",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,		"dmt_bill_dys",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"dmt_fm_dt",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"dmt_to_dt",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"dmt_mt_dt",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"dmt_ft_cmnc_dt",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"dmt_ft_end_dt",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"dmt_curr_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,		"dmt_bil_amt",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"trs_vndr_seq",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,		"trs_vndr_nm",		false,		"",			dfNone,		0,			false,		false);
					/* 2014.07.01 Chang Young Kim Added In accordance with the "CHM-201430787" (S) */
					InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,		"trs_wo_iss_usr_nm",false,		"",			dfNone,		0,			false,		false);
					/* 2014.07.01 Chang Young Kim Added In accordance with the "CHM-201430787" (E) */

					// added by shin yongchan, 2015-07-22, CHM-201537162
					InitDataProperty(0, cnt++ , dtData,		70,	    daLeft,		true,		"trs_wo_fm_yd",     false,		"",			dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"trs_appt_dt",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"trs_appt_tm",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"trs_de_dt",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"trs_de_tm",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"trs_inv_sts_cd",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"trs_inv_cfm_dt",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"bkg_no",			false,		"",			dfNone,		0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	true,		"bl_no",			false,		"",			dfNone,		0,			false,		false);		//B/L No
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"bnd_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"pol_pod_nod",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"por_del_nod",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"trnk_vvd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"poletd_podeta",	false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		true,		"trs_fact_nm",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,		"shpr",				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,		"cnee",				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		400,	daLeft,		true,		"cmdt_nm",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"rd_cgo_flg",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"cntr_dmg_flg",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"dmt_uc_flg",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"ctrt_ofc_cd",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"srep_nm",			false,		"",			dfNone,		0,			false,		false);

					WaitImageVisible = false;
					
					Ellipsis = true;
//					WordWrap = true;
					
				}	
				break;
		}
	} 
	
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++ , "Summary" , -1 );
					InsertTab( cnt++ , "Detail" , -1 );
				}
				break;

		}
	}
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var formObject = document.form;
	
		switch(comboNo) {		
		  case 1:		
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH01);
			with (comboObj) { 
				MultiSelect = true;
				UseAutoComplete = true;	
				SetColAlign("left");		
				SetColWidth("50");
				DropHeight = 160;
			}
			break;
			
		  case 2:
				mvmt_code();
				with (comboObj) { 
					MultiSelect = true;
					UseAutoComplete = true;	
					SetColAlign("left");		
					SetColWidth("50");
					DropHeight = 160;
				}
			break;			
		 } 
	}   

	/**
	* 초기 이벤트 등록 
	*/
	function initControl() {
 
		axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
		axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
		axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
		axon_event.addListener('click',  'check_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', '');	//TP/SZ 체크박스 체크 이벤트 처리
		axon_event.addListenerForm('change',  'vvdNoChange', document.form);	//TP/SZ 체크박스 체크 이벤트 처리
		
	}
	
	/**
	 * Form Element의  OnBeforeDeactivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeDeactivate() {

		//ComChkObjValid(window.event.srcElement);
		
        var formObj = document.form;
        var eleName = event.srcElement.name;

        switch(eleName){
            
            case "fm_dt":
            case "lt_dt":
                if(eleName == "fm_dt") {  
                    var tdate = formObj.fm_dt.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
                    if (tdate.length >= 8) {                                                                                                                                                                                                                                                                                                                                                                                                                                           
                        formObj.fm_dt.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);
                    }              
					if(!ComIsDate(formObj.fm_dt.value) && formObj.fm_dt.value !=""){ // 날짜 형식이 아니면
					    ComShowCodeMessage("CGM10087","From Date"); //'{?msg1} :  Date format is wrong';   
						formObj.fm_dt.value = "";
					}                                                                                                                                                                                                                                                                                                                              
                }else if(eleName == "lt_dt"){
                    var tdate = formObj.lt_dt.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
                    if (tdate.length >= 8) {  
						formObj.lt_dt.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);
                    }
					if(!ComIsDate(formObj.lt_dt.value) && formObj.lt_dt.value !=""){ // 날짜 형식이 아니면
					    ComShowCodeMessage("CGM10087","To Date"); //'{?msg1} :  Date format is wrong';
                        formObj.lt_dt.value = "";
                    }
                }
                break; 
        }		
	}

	/**
	 * Form Element의 OnBeforeActivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeActivate() {

		//ComClearSeparator(window.event.srcElement);
		
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);

        switch(srcName){
            case "fm_dt":
            case "lt_dt":
                if(srcName == "fm_dt") {                                                                                                                                                                                                                                                                                                                                                                                                                                               
                    formObj.fm_dt.value = formObj.fm_dt.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
                } else if(srcName == "lt_dt") {                                                                                                                                                                                                                                                                                                                                                                                                                                        
                    formObj.lt_dt.value = formObj.lt_dt.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
                }
                break; 
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
				
			case "engupnum":  //숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum'); 
				break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:	  // Summary 조회 (Back End Job)
				if(!validateForm(sheetObj,formObj,sAction)) return;  // VALIDATION
				ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH;
				
				var xmlStr = sheetObj.GetSearchXml("EES_CGM_1157GS.do",FormQueryString(formObj));
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")	// 전역변수로 setting
				if (backEndJobKey != "") {
					sheetObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}							
				break;
			 
			case IBSEARCH01:		//TP SZ
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1157GS.do","" ,FormQueryString(formObj));
		
				var idxArr = null;
				
				idxArr = ComGetEtcData(sXml,"cntr_tpsz_nm").split("|");		
				formObj.cntr_tpsz_cd.InsertItem(0,"ALL","A");		
				for(var i = 1;i < idxArr.length+1; i++){	 
					getComboObject("cntr_tpsz_cd").InsertItem(i, idxArr[i-1], idxArr[i-1]);
				}		
			break;
			
			case IBSEARCH02:	  // Detail 조회 (Back End Job)
				if(!validateForm(sheetObj,formObj,sAction)) return;  // VALIDATION
				ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH02;
				
//				prompt("Detail",FormQueryString(formObj)); ComOpenWait(false); return;
				
				var xmlStr = sheetObj.GetSearchXml("EES_CGM_1157GS.do",FormQueryString(formObj));
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")	// 전역변수로 setting
				if (backEndJobKey != "") {
					sheetObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}							
				break;
			
			case IBSEARCH_ASYNC01:	// Movement Status Combo 조회
				formObj.f_cmd.value = SEARCH13;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
								
				var cols = ComCgmXml2ComboString(sXml, "code1", "code1");
				ComCgmMakeMultiCombo(form.mvmt_sts_cd, cols[0], cols[1], 0);
				break;					 

			case IBDOWNEXCEL:	 //엑셀다운로드
				
				/* 2014.07.01 Chang Young Kim Added In accordance with the "CHM-201430787" (S) */
				if(tabObjects[0].SelectedIndex == 0) {
					sheetObj.Down2Excel(-1);
				} else {
					sheetObj.Down2Excel(1, false, false, true, "", "/apps/alps/ees/cgm/chassisreport/chassisreportinventory/xml/EES_CGM_1157_FORMAT.xml");
				}
				/* 2014.07.01 Chang Young Kim Added In accordance with the "CHM-201430787" (E) */
				break;				
		}
	}

	/**
	 * Back End Job 호출함수
	 */
	function getBackEndJobStatus() {
		var formObject = document.form;
		var shtObj = null;
		
		if(tabObjects[0].SelectedIndex == 0) {
			shtObj = sheetObjects[0];
		} else {
			shtObj = sheetObjects[1];
		}
		
		var xmlStr = shtObj.GetSearchXml("EES_CGM_1157GS.do", "f_cmd=" + SEARCHLIST02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg")

		if (jbStsFlg == "3") {
			shtObj.DoSearch4Fx("EES_CGM_1157GS.do", "f_cmd=" + SEARCHLIST03 + "&backEndJob_Key=" + backEndJobKey);
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);

		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");	// Failed to retrieve {?msg1}. Please try again.
		}
		
		// Cell Click Detail Search Param Reset
		formObject.hdn_pop_yn.value			= "N";
		formObject.hdn_org_yd_cd.value		= "";
		formObject.hdn_fcntr_flg.value		= "";
		formObject.hdn_finished.value		= "";
		formObject.hdn_fm_sts_cd.value		= "";
		formObject.hdn_lt_sts_cd.value		= "";
		formObject.hdn_cntr_tpsz_cd.value	= "";
		formObject.hdn_mvmt_sts_cd.value	= "";
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch (sAction) {
			case IBSEARCH:
			case IBSEARCH02:
				// location 입력값 체크
				if (document.form.loc_list.value == '') {
					ComShowCodeMessage('CGM10004', 'Location');
					document.form.loc_list.focus();
					return false;
				}
				
				// vvd 입력값 체크
				if (document.form.vvd_no.value != "" && document.form.vvd_no.value.length < 9) {
					ComShowCodeMessage('CGM10009', 'T.VVD');
					document.form.vvd_no.focus();
					return false;
				}				
				
				// Event Date 입력값 체크
                if(document.form.fm_dt.className == "input1" && document.form.fm_dt.value == ""){
			    	ComShowCodeMessage('CGM10004', 'Event Date');
			    	document.form.fm_dt.focus();
                    return false;
                }
                if(document.form.lt_dt.className == "input1" && document.form.lt_dt.value == ""){
                	ComShowCodeMessage('CGM10004', 'Event Date');
			    	document.form.lt_dt.focus();
                    return false;
                }
				if(ComGetDaysBetween(document.form.fm_dt.value, document.form.lt_dt.value) > 30){
					ComShowCodeMessage('CGM20085', '30 Days');
                    return false;
                }
				if(ComGetDaysBetween(document.form.fm_dt.value, document.form.lt_dt.value) < 0){
                    ComShowCodeMessage('CGM10088'); // 'From date must be earlier than To date.'
                    return false;
                }				

				// 2015.03.02 데이터 조회용량이 많아 제한 별도 CSR없이 수정
				// SUMMARY만 VALIDATION체크 하던 로직을 별도로 DETAIL조회에도 적용
				// DETAIL의 LOCATION이 RCC, FINISHED가 ALL OR YES일경우 조회기간을 10일로 제한
				if(sAction == IBSEARCH02){  // DETAIL 탭
				    var vLocationCd = document.form.loc_cd.value;
				    var vFinishedCd = document.form.finish_cd.value;
				    	
				    if(vLocationCd == "R" && (vFinishedCd == "" || vFinishedCd == "Y") ){ // RCC 이면서 FINISHED : ALL
				    	if (ComGetDaysBetween(document.form.fm_dt.value, document.form.lt_dt.value) > 10) {
				    		ComShowCodeMessage('CGM20085', '10 Days. When Location RCC and Finished All/Yes');
				    		return false;
				    	}
				    }
				}				

				// MVMT 선택값 확인(필수)
				if (document.form.mvmt_sts_cd.Code == "") {
					ComShowCodeMessage('CGM10004', 'MVMT Status');
					document.form.mvmt_sts_cd.focus();
					return false;
				}
		
			}	
		}
		return true;
	}
	
	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요		  
	 * Location : 팝업에서 단일 선택을 한경우..	 
	 */	  
	function getCgm_Multi(rowArray,ret_val) {
		var formObj = document.form;  
		var tempText = ""; 
		//초기화	
//		formObj.loc_list.value = '';	
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];	 
			tempText +=  rowArray[i] + ',';	  
		}	  
		//마지막에 ,를 없애기 위함	 
		tempText = CgmDelLastDelim(tempText);	 
		tempText = tempText.toUpperCase();		
						
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
		
		vvdNoChange(ret_val);  // vvd change 호출

	}		
	
	 /**
	* TP/SZ 체크박스 체크 이벤트 처리
	* TP/SZ 체크박스 체크시 전체체크,전체해재 기능
	*/
	function check_cntr_tpsz_cd_check() {
		
		var formObject = document.form;
		if ( formObject.chk_cntr_tpsz_cd.checked ) {
			comboObjects[0].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
		} else {
			comboObjects[0].Code = "";
		}

	}
		
	function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
			if(index==0) {			
				var bChk = comboObj.CheckIndex(index);
				if(bChk){
					for(var i = 1 ; i < comboObj.GetCount() ; i++) {
						comboObj.CheckIndex(i) = false;
					}
				}
			} else {
				comboObj.CheckIndex(0) = false;
			}
	} 
   
   //MVMT Status 리스트 조회
	function mvmt_code(){
	//Index Combo Setting.
    // CHM-201534285, 2015-02-16, 신용찬, MT 추가
	var sIdx = "MP|MO|MT|VD(MTY)|VD(Full)|VL(MTY)|VL(Full)|OP|OC|IC|ID|EN(Full)|EN(MTY)|TN(Full)|TN(MTY)|TS|CM|CP|CI|CO|CD|CT|CE|XX|OP-MT|OC-MT|OP-OC|ID-OC|ID-MT|OC-VL|MT-OP|MT-TN|MT-EN|IC-ID|IC-EN|IC-TN";
		var idxArr = null;
		
	idxArr = sIdx.split("|");
		appendMultiComboItem(getComboObject("mvmt_sts_cd"), idxArr, idxArr);
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
	
	//멀티콤보 클릭 이벤트
	function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) { 
		CgmAllChkMultiCombo(comboObj,index);				  
	}
	
	/**
	 * 멀티콤보 클릭 이벤트  <br>
	 * <b>Example :</b>
	 *
	 * @param comboObj	멀티콤보 오브젝트
	 * @param index		멀티콤보 index
	 */
	 function CgmAllChkMultiCombo(comboObj,index) {
		//All 인 경우
		if(index == 0) {
			//checked
			if(comboObj.CheckIndex(index)) {
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.checkIndex(i) = false;
				}

			} else {
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.checkIndex(i) = false;
				}
			}
		//All 이 아닌 경우
		} else {
			var checkCnt = 0;
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				if(comboObj.checkIndex(i)) {
					checkCnt++;
				}
			}
			if(checkCnt == comboObj.GetCount() - 1) {
				comboObj.checkIndex(0) = true;
			}else{
				comboObj.checkIndex(0) = false;
			}
		}
	 }
	 
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");
		
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}
	
	
	/**
	 * t1sheet1의 OnSearchEnd 이벤트처리 <br>
	 * @param  {object} sheetObj	Sheet Object
	 * @param  {string} ErrMsg		String
	 * @return 없음
	 * @version 2014.07.02
	 * @author Chang Young Kim
	 */ 
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		
		if(sheetObj.RowCount > 0 && ComIsEmpty(ErrMsg)) {
			for(var idx = sheetObj.HeaderRows; idx < sheetObj.Rows; idx++) {
				sheetObj.CellFont("FontColor", idx, "box") = sheetObj.RgbColor(42, 0, 255);
				sheetObj.CellFont("FontBold", idx, "box") = true;
				sheetObj.CellFont("FontUnderline", idx, "box") = true;
				if(ComIsEmpty(sheetObj.CellValue(idx, "cntr_tpsz_cd"))) {
					sheetObj.RowBackColor(idx) = sheetObj.RgbColor(230, 224, 238);
				}
			}
		}
	}
	
	/**
	 * t1sheet1의 OnClick 이벤트처리 <br>
	 * @param  {object} sheetObj	Sheet Object
	 * @param  {string} Row		String
	 * @param  {string} Col		String
	 * @param  {string} Value	String
	 * @return 없음
	 * @version 2014.07.02
	 * @author Chang Young Kim
	 */ 
	function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];	
		/*********************************************************************/
		var formObject = document.form;
		
		if(sheetObj.ColSaveName(Col) == "box" && Row >= sheetObj.HeaderRows) {
			
			formObject.hdn_pop_yn.value			= "Y";
			formObject.hdn_org_yd_cd.value		= sheetObj.CellValue(Row, "org_yd_cd");
			formObject.hdn_fcntr_flg.value		= sheetObj.CellValue(Row, "fcntr_flg");
			formObject.hdn_finished.value		= sheetObj.CellValue(Row, "finished");
			formObject.hdn_fm_sts_cd.value		= sheetObj.CellValue(Row, "fm_sts_cd");
			formObject.hdn_lt_sts_cd.value		= sheetObj.CellValue(Row, "lt_sts_cd");
			
			if(!ComIsEmpty(sheetObj.CellValue(Row, "cntr_tpsz_cd"))) {
				formObject.hdn_cntr_tpsz_cd.value	= sheetObj.CellValue(Row, "cntr_tpsz_cd");
			} else {
				formObject.hdn_cntr_tpsz_cd.value	= "";
			}
			
			formObject.hdn_mvmt_sts_cd.value	= sheetObj.CellValue(Row, "mvmt_cd");
			
			sheetObject2.RemoveAll();
			tabObjects[0].SelectedIndex = 1;
			doActionIBSheet(sheetObject1,document.form,IBSEARCH02);
		}
	}
	
	/**
	 * t1sheet1의 OnMouseMove 이벤트처리 <br>
	 * @param  {object} sheetObj	Sheet Object
	 * @param  {string} Button		String
	 * @param  {string} Shift		String
	 * @param  {string} X			String
	 * @param  {string} Y			String
	 * @return 없음
	 * @version 2014.07.02
	 * @author Chang Young Kim
	 */ 
	function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var sText = sheetObj.CellText(sheetObj.MouseRow, sheetObj.MouseCol);
		
		//마우스 위치가 2컬럼이고 값이 있을 때만 마우스 손가락 모양
		if(sheetObj.MouseCol == 9 && !ComIsEmpty(sText) ) {
			sheetObj.MousePointer = "Hand";
		}
		else {
			sheetObj.MousePointer = "Default";
		}

	}
	
	/**
	 * VVD 입력되면 Event Date 필수입력 제외, VVD 제거되면 Event Date 필수 입력으로 변경
	 */
	function vvdNoChange(target){

		var obj = null;
		if(target=="[object]") obj = window.event.srcElement.name; // T.VVD 직접 입력
		else                   obj = target;                       // M 버튼 클릭후 팝업에서 선택   

		switch (obj) {
			case "vvd_no":
				
				var formObj = document.form;

				if (formObj.vvd_no.value == '') {
					document.getElementById("fm_dt").className = "input1";  // 필수입력으로 변경
					document.getElementById("lt_dt").className = "input1";  // 필수입력으로 변경
				}else {
					document.getElementById("fm_dt").className = "input";  // 선택입력으로 변경
					document.getElementById("lt_dt").className = "input";  // 선택입력으로 변경
				}
			break;
		}	
	}	
	
	/* 개발자 작업  끝 */