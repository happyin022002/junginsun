/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0052.js
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완
* 2014.12.08 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
* 2015.01.12 [CHM-201533666] Control Registration 보완요청 - SC/RFA PK로 변경
* 2015.01.22 신자영 [CHM-201533823] Control Option 데이터 보여주는 방식 변경 요청
* 2015.01.30 신자영 [CHM-201533908] Control Option 보완 - SC/RFA컬럼 제거 
* 2015.03.19 김성욱 [CHM-201533908] Control Option 보완 - Sheet3, 4 추가, sheet2, 3, 4에 delete check box 추가
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
* 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완 - 패키지 이동 및 ECC, LOC group중 mandatory 체크 추가, 변경된 OPtion항목 삭제 등 정리
* 2015.07.30 Arie MasterTable 조건 삭제(control option 저장화면에서)
* 2015.08.17 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(7.30내용 포함)
* 2015.08.20 bkg_ctrl_fcast_fm_yrwk 날짜 포멧 변경
* 2015.09.24 이혜민 [CHM-201537552] BKG Control - SMP통제 조건 by lane 변경요청
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
     * @class ESM_SPC_0052 : ESM_SPC_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0052() {
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
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;

    var cust_code;
    var isReduceSheet1 = false; //Sheet1의 byAlloc, bySMP, byMaster의 값에 의해 조건이 완화된경우
    var isReduceSheet3 = false; //Sheet3의 Booking Control option 의 SMP Group 의 ratio 값에 의해 조건이 완화된경우
    
    var sh1Condition = new Array(); //Alloc Option 의 초기 값 저장
    var sh3Condition = new Array(); //Booking control option 의 초기 값 저장
    
    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var init_year1 = ''; 
    var init_week1 = ''; 
    var init_year2 = ''; 
    var init_week2 = ''; 
    
    var recentClick = "";
    
    var LFARY; //LoadFact flag가 check 되어있는지 여부 확인, 초기 값 저장용.
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		 var sheetObject = sheetObjects[0];
		 
		 /*******************************************************/
		 var formObject = document.form;

			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_new":
					if(checkModifiedSheet(sheetObject)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//공통함수사용: 화면을 초기화
					resetAll();
		    		
					SpcSearchOptionTrade("trade", true, true);
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("lane"); // 0207 SHKIM
					
					// 2015.02.14 김성욱, 추가된 내용 리셋.
					sheetObjects[1].RemoveAll();
		        	sheetObjects[2].RemoveAll();
		        	
		        	document.getElementById("acc_rep_trade").innerHTML = "";
			    	document.getElementById("acc_sub_trade").innerHTML = "";
			    	document.getElementById("acc_lane").innerHTML = "";
			    	document.getElementById("acc_bound").innerHTML = "";
			    	
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;	
				
				case "btn_sheet2RowAdd" :
					var mainRow = sheetObjects[0].SelectRow;	
					
					if(mainRow < 0) {
						ComShowCodeMessage("COM12189"); 
						return;
					}    				
					
					if(sheetObjects[0].CellValue(mainRow, "ctrl_ecc_flg")=="0" && sheetObjects[0].CellValue(mainRow, "ctrl_ecc_grp_flg")=="0" && sheetObjects[0].CellValue(mainRow, "ctrl_acct_flg")=="0") {    						    						
						ComShowMessage(getMsg("SPC90146"));
						return;    					
					}    					
					
					var row = sheetObjects[1].DataInsert(-1);
					sheetObjects[1].CellValue2(row, "trd_cd") = sheetObjects[0].CellValue(mainRow, "trd_cd");
					sheetObjects[1].CellValue2(row, "sub_trd_cd") = sheetObjects[0].CellValue(mainRow, "sub_trd_cd");
					sheetObjects[1].CellValue2(row, "rlane_cd") = sheetObjects[0].CellValue(mainRow, "rlane_cd");
					sheetObjects[1].CellValue2(row, "dir_cd") = sheetObjects[0].CellValue(mainRow, "dir_cd");
					
					break;
					
				case "btn_sheet2Save" :
					doActionIBSheet(sheetObjects[1],formObject,COMMAND01);

					break;
				case "btn_sheet2Excel" :
					sheetObjects[1].Down2Excel(-1, false, false, true);
					break;
					
				case "btn_match" :    					    					
					
					var leftpos = (screen.width - 1024) / 2;
					if (leftpos < 0)
						leftpos = 0;
					var toppos = (screen.height - 540) / 2;
					if (toppos < 0)
						toppos = 0;    
					
					ComOpenWindow("EES_CIM_1018.do",       'none',"scroll:yes;status:no;maximize:yes;minimize:yes;help:no;dialogWidth:1024px;dialogHeight:700px;resizable:yes;dialogLeft:"+leftpos + ";dialogTop:" + toppos, true);
					
					break;
					
	    	    case "btn_import": 
	    			var popup = window.showModalDialog("ESM_SPC_0114.do", null, "dialogHeight:600px;dialogWidth:900px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
	   				break;	
				
	    	    case "btn_sheet4RowAdd" : 
	    	    	var mainRow = sheetObjects[0].SelectRow;	
					if(mainRow < 0) {
						ComShowCodeMessage("COM12189"); 
						return;
					}    		
					var secondRow = sheetObjects[1].SelectRow;
					if( secondRow < 0 ) {
						ComShowCodeMessage("COM12189"); 
						return;
					}
					
					//ROW 추가시 SMP 의 경우 이전에 입력된 RLANE, DIR 이 있으면 그 값을 기본 값으로 사용함. 없는 경우 현재 선택된 RLANE, DIR 을 사용함.
	    	    	var row = sheetObjects[2].DataInsert(-1);
	    	    	var mainRow = sheetObjects[0].SelectRow;
	    			sheetObjects[2].CellValue2( row , "rlane_cd") = sheetObjects[0].CellValue(mainRow, "rlane_cd");
        			sheetObjects[2].CellValue2( row , "dir_cd") = sheetObjects[0].CellValue(mainRow, "dir_cd");
	    	    	break;
	    	    	
	    	    case "btn_sheet4Save" : 
					doActionIBSheet(sheetObjects[2],formObject,COMMAND02);
    			   break;
	    	    	
			} // end switch
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		SpcSearchOptionYear("year1");
    	SpcSearchOptionWeek("week1");
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionLane("lane");
    	SpcSearchOptionBound("bound",false,true,false);

		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initComboData();
		var sheetResizeFull = true;
		document_onresize();
		
		init_year1 = document.form.year1.value;	//년 초기화용
		init_week1 = document.form.week1.value;	//주차 초기화용
		
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
					//style.height = 300 ;
					style.height = GetSheetHeight(11) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]    					
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
					
				    //전체Edit 허용 여부 [선택, Default false]
					Editable = true;
                    FocusEditMode = default_edit_mode; 
                    ScrollTrack = false;                
                    MassOfSearch = -1;		//ibsheet버전 변경시 속성값변경
					
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 3, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(42, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(true, false, true, true, false, false);

					// 2015.01.12 BKG control FLAG 3개 추가 Allocation/SMP Group/Account
					
					var HeadTitle  = "Rep.\nTrade|Sub\nTrade|Lane|BD|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Account Group|Account Group|Account Group|BKG Control|BKG Control|BKG Control|BKG Control|BKG Control|BKG Control|BKG Control|BKG Control|BKG Control|";
					var HeadTitle1 = "Rep.\nTrade|Sub\nTrade|Lane|BD|D2|D4|HC|45'|53'|RF|RD|WGT|POL\n/POD|Dest|Dest|Dest|US\nMode|Acct/\nCMDT|Fixed\nFlag|Yield\nGroup|From|To|ALOC|ALOC|ALOC|ALOC|SMP|SMP|SMP|SMP|SMP|SMP|F.L/F\nFrom|";
					// 2015.02.12 LOC->ECC Group 으로 변경
					var HeadTitle2 = "Rep.\nTrade|Sub\nTrade|Lane|BD|D2|D4|HC|45'|53'|RF|RD|WGT|POL\n/POD|ECC|LocGroup|POD/DEL|US\nMode|Acct/\nCMDT|Fixed\nFlag|Yield\nGroup|From|To|Must|Type|F'CST|F.L/F|Must|Type|F'CST|F.L/F|By Lane|upd|F.L/F\nFrom|";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,         40,    daCenter,  true,	   "trd_cd",     	   				false,          "",       dfNone,    		0,     false,  true, 		0,		false,		false); //Rep. Trade
					InitDataProperty(0, cnt++, dtData,         40,    daCenter,  true,     "sub_trd_cd", 	   				false,          "",       dfNone,    		0,     false,  true, 		0,		false,		false); //Sub Trade
					InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "rlane_cd",         				false,          "",       dfNone,    		0,     false,  true, 		0,		false,		false); //Lane
					InitDataProperty(0, cnt++, dtData,         30,    daCenter,  true,     "dir_cd",           				false,          "",       dfNone,    		0,     false,  true, 		0,		false,		false); //Bound

					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_d2_flg",     				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //D2
					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_d4_flg",     				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //D4
				
					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_40ft_hc_flg", 				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //HC
					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_45ft_hc_flg", 				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //45
					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_53ft_flg",    				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //53
					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_rf_flg",      				false,          "",       dfNone,   		0,     true,   true, 		0,		false,		false, false, false, "", false); //Reefer
					
					InitDataProperty(0, cnt++, dtCheckBox,     28,    daCenter,  true,     "ctrl_rd_flg",     				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //RD
					
					InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  true,     "ctrl_wgt_flg",     				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //Weight
					InitDataProperty(0, cnt++, dtCombo,        60,    daCenter,  true,     "ctrl_lvl_cd",      				false,          "",       dfNone,    		0,     true,   true); //POL/POD
					
					InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  false,    "ctrl_ecc_flg",     				false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //ECC    					    				
					InitDataProperty(0, cnt++, dtCheckBox,     58,    daCenter,  false,    "ctrl_ecc_grp_flg",     			false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //LOC    					
					InitDataProperty(0, cnt++, dtCombo,  	   55,    daCenter,  false,	   "ctrl_dest_lvl_cd",   			false,  		"",  	  dfNone,   		0, 	   true,   true);	//POD/DEL
					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,     "ctrl_usa_svc_mod_flg",  		false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //US MOD
					InitDataProperty(0, cnt++, dtCheckBox,     38,    daCenter,  true,     "ctrl_acct_flg",     			false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //Account
					InitDataProperty(0, cnt++, dtCheckBox,     38,    daCenter,  true,     "ctrl_fx_rt_flg",     			false,          "",       dfNone,    		0,     true,   true, 		0,		false,		false, false, false, "", false); //Fixed Rate Apply

					
					InitDataProperty(0, cnt++, dtCheckBox,     40,    daCenter,  true,     "acct_grp_ctrl_flg",				false,          "",       dfNone,    		0,     false,   true, 		0,		false,		false, false, false, "", false); //Yield Group
					InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "aply_fm_yrwk",     				false,          "",       dfUserFormat,     0,     false,   false); 
					InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "aply_to_yrwk",     				false,          "",       dfUserFormat,     0,     false,   false); 
					
					//2015.06.  요건 변경으로 추가됨
					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,		"bkg_ctrl_aloc_aply_flg",		false,			"",		  dfNone,			0, 		true,	true, 		0,		false,		false, false, false, "", false);
					//2015.09.23 이혜민 by lane 반영하면서 bkg_ctrl_aloc_tp_cd, bkg_ctrl_acct_grp_tp_cd dtCombo->dtHidden으로 바꿈
					InitDataProperty(0, cnt++, dtCombo,  	   55,    daCenter,  false,	   "bkg_ctrl_aloc_tp_cd",   			false,  		"",  	  dfNone,   		0, 	   true,   true);				
					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,		"bkg_ctrl_aloc_fcast_flg",		false,			"",		  dfNone,			0,     	true,	true, 		0,		false,		false, false, false, "", false);
					InitDataProperty(0, cnt++, dtData,  	   40,    daCenter,  true,		"bkg_ctrl_aloc_fcast_rto",  	false,			"",		  dfNullInteger,	0, 		true,	true);
					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,		"bkg_ctrl_acct_grp_aply_flg",	false,			"",  	  dfNone,			0, 		true,	true, 		0,		false,		false, false, false, "", false);
					InitDataProperty(0, cnt++, dtCombo,  	   55,    daCenter,  false,	   "bkg_ctrl_acct_grp_tp_cd",   			false,  		"",  	  dfNone,   		0, 	   true,   true);
					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,		"bkg_ctrl_acct_grp_fcast_flg",	false,			"",       dfNone,			0,     	true,	true, 		0,		false,		false, false, false, "", false);
					InitDataProperty(0, cnt++ ,dtData,  	   40,    daCenter,  true,		"bkg_ctrl_acct_grp_rto",		false,			"",		  dfNullInteger,	0, 		true,	true);
					InitDataProperty(0, cnt++ ,dtCheckBox,     70,    daCenter,  true,		"bkg_ctrl_lane_flg",			false,			"",		  dfNone,	0, 		true,	true);
					InitDataProperty(0, cnt++ ,dtHidden,       30,    daCenter,  true,		"bkg_ctrl_lane_upd_flg",		false,			"",		  dfNone,	0, 		true,	true);
//					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,		"bkg_ctrl_mst_tbl_aply_flg",   	false,			"",  	  dfNone,			0, 		true,	true, 		0,		false,		false, false, false, "", false);
//					InitDataProperty(0, cnt++, dtCheckBox,     35,    daCenter,  true,		"bkg_ctrl_mst_tbl_fcast_flg",	false,			"",       dfNone,			0,     	true,	true, 		0,		false,		false, false, false, "", false);
//					InitDataProperty(0, cnt++ ,dtData,  	   40,    daCenter,  true,		"bkg_ctrl_mst_tbl_fcast_rto",  	false,			"",    	  dfNullInteger,	0, 		true,	true);
			
					InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "bkg_ctrl_fcast_fm_yrwk",           false,          "",       dfUserFormat,    0,     false,      false);
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "ctrl_port_flg",    				false,          "",       dfNone,    		0,      true,   true, 		0,		false,		false);
					InitDataProperty(0, cnt++, dtHiddenStatus, 80,    daCenter,  true,     "ibflag",     	   				false,          "",       dfNone,    		0,      false,  true, 		0,		false,		false);    					
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "tmp_acct_flg",     				false,          "",       dfNone,    		0,      false,  false, 		0,		false,		false);
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "tmp_fm_yrwk",      				false,          "",       dfNone,    		0,      false,  false, 		0,		false,		false);
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "tmp_to_yrwk",      				false,          "",       dfNone,    		0,      false,  false);
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "hh_flg",           				false,          "",       dfNone,    		0,      false,  false);
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "rd_flg",           				false,          "",       dfNone,    		0,      false,  false);
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,    "",                 				false,          "",       dfNone,    		0,      true,   true, 		0,		false,		false);

					HeadRowHeight = 20 ;
//    					HeadRowHeight = 21 ;
					
					InitDataCombo (0, "ctrl_lvl_cd", "Office|POL|POL/POD|Dest", "O|L|D|T");
					InitDataCombo (0, "ctrl_dest_lvl_cd", " |POD|DEL", " |D|T");
					InitDataCombo (0, "bkg_ctrl_aloc_tp_cd", "-|Standby|Attention", " |S|A");
					InitDataCombo (0, "bkg_ctrl_acct_grp_tp_cd", "-|Standby|Attention", " |S|A");
	    			InitUserFormat(0, "aply_fm_yrwk", "####-##", "-" );
	    			InitUserFormat(0, "aply_to_yrwk", "####-##", "-" );
	    			InitUserFormat(0, "bkg_ctrl_fcast_fm_yrwk", "####-##", "-" );

			   }
				break;
				
   			 case 2:      //sheet2 init
 				with (sheetObj) {
 					// 높이 설정
 					style.height = GetSheetHeight(7) ;
 					//전체 너비 설정
 					SheetWidth = mainTable2.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]    					
 					MergeSheet = msPrevColumnMerge + msHeaderOnly;
 					
 				    //전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 					
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 1, 1, 9, 100);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(13, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
 					InitHeadMode(true, false, true, true, false, false);     					
 					
 					var HeadTitle  = "DEL.|Fixed\nFlag|STS|Rep. Trade|Sub Trade|Lane|Bound|Control|ECC/LocGroup\n/Contract|Office|Acct/CMDT|Contractor Name|Account Name/\nCommodity Desc.";
 					
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 					
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtDelCheck,   			40,   daCenter,   	false,  "",     	 		false,	"",  dfNone,   		0, true,  true);
					InitDataProperty(0, cnt++,  dtCheckBox,     		50,   daCenter,  	true,   "ctrl_fx_rt_flg",   false,  "",  dfNone,    	0, true,  false); 		//Fixed Rate Apply
 					InitDataProperty(0, cnt++ , dtHiddenStatus,     	30,   daCenter,   	false,  "ibflag",   		false,	"",  dfNone,   		0, false, true);
 					InitDataProperty(0, cnt++ , dtHidden,  				70,   daCenter,  	true,	"trd_cd",  			false,  "",  dfNone,   		0, false, false);		//	Rep Trade
 					InitDataProperty(0, cnt++ , dtHidden,  				70,   daCenter,  	true,	"sub_trd_cd",  		false,  "",  dfNone,   		0, false, false);		//	Sub Trade
 					InitDataProperty(0, cnt++ , dtHidden,  				70,   daCenter,  	true,	"rlane_cd",  		false,  "",  dfNone,   		0, false, false);		//	Lane
 					InitDataProperty(0, cnt++ , dtHidden,  				50,   daCenter,  	true,	"dir_cd",  			false,  "",  dfNone,   		0, false, false);		//	Bound
 					
 					InitDataProperty(0, cnt++ , dtCombo,  				110,  daCenter,  	false,	"aloc_ctrl_tp_cd",   false,  "",  dfNone,   	0, false, true);		//	Control   					
 					InitDataProperty(0, cnt++ , dtPopup,  				85,   daCenter,  	false,	"ctrl_loc_acct_cd",  false,  "",  dfNone,   	0, false, true, 10);	//	ctrl_loc_acct_cd Code
 					InitDataProperty(0, cnt++ , dtPopup,  				70,   daCenter,  	false,	"ofc_cd",  			 false,  "",  dfNone,   	0, true,  true);		//	Control Office List
 					InitDataProperty(0, cnt++ , dtData,  				70,  daCenter,  	false,	"aloc_ctrl_dtl_cd",  false,  "",  dfNone,   	0, false, true);		//	Code
 					InitDataProperty(0, cnt++ , dtData,  				110,  daLeft,  	    false,	"ctrt_nm",  		 false,  "",  dfNone,   	0, false, false);		//	Code
 					InitDataProperty(0, cnt++ , dtData,  				110,  daLeft,  	    false,	"acct_nm",  		 false,  "",  dfNone,   	0, false, false);		//	Code

 					// 2015.01.26 location option 제외 (향후 다시 살릴 수도 있으므로 주석 지우지 말 것)
 					// 2015.06.01 MetaSys에 CD03297 코드 최신화 되지 않아서 사용하는 코드로 최신화 함
//     					InitDataCombo (0, "aloc_ctrl_tp_cd", "ECC|LOC Group|Contract(I/Acct)|Contract(A/Acct)|Contract(Commodity)", "E|G|A|B|C");
 					HeadRowHeight = 37 ;


 					sheetObj.ToolTipOption="balloon:true;width:430";
 			   }
 				break;
				
   			case 3:
 				with (sheetObj) {
   				        				 
 					// 높이 설정
 					style.height = GetSheetHeight(7) ;
 					//전체 너비 설정
 					SheetWidth = mainTable4.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]    					
 					MergeSheet = msPrevColumnMerge + msHeaderOnly;
 					
 				    //전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 					
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 1, 1, 9, 100);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(10, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
 					InitHeadMode(true, false, true, true, false, false);     					
 					
 					var HeadTitle  = "DEL.|STS|Alloc Office\nYield Group|Code|Ratio(%)|By\nAccount|By\nLane|rd_flg|rlane_cd|dir_cd";
 					
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 					
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtDelCheck,   	40,   daCenter,   	false,  "",     	 			false,	"",  dfNone,   		0,      true,  true);
 		            InitDataProperty(0, cnt++ , dtHiddenStatus, 50,   daCenter,   	false,  "ibflag",   			false,	"",  dfNone,   		0,      false, true);
 					InitDataProperty(0, cnt++ , dtCombo,  		110,  daCenter,  	false,	"bkg_ctrl_tp_cd",  		false,  "",  dfNone,   		0, 		false, true);	
 					InitDataProperty(0, cnt++ , dtPopup,  		60,   daCenter,  	false,	"bkg_ctrl_dtl_cd",  	false,  "",  dfNone,   		0, 		false, true);	
 					InitDataProperty(0, cnt++ , dtData,  		80,   daCenter,  	false,	"bkg_ctrl_rto",  		false,  "",  dfNumber,   	0, 		false, true);	
 					InitDataProperty(0, cnt++ , dtCheckBox,  	80,   daCenter,  	false,	"bkg_ctrl_acct_flg",  	false,  "",  dfNone,   		0, 		false, false);	
 					InitDataProperty(0, cnt++ , dtData,  		70,   daCenter,  	false,	"bkg_ctrl_lane_flg",  	false,  "",  dfNone,   		0, 		false, false);	
 					InitDataProperty(0, cnt++ , dtHidden,  		70,   daCenter,  	false,	"rd_flg",  				false,  "",  dfNone,   		0, 		false, true);	//	조건 완화되면 spc_aloc_ctrl 테이블의 RAPLY_CFM_FLG를 setting
 					InitDataProperty(0, cnt++ , dtHidden,  		70,   daCenter,  	false,	"rlane_cd",  			false,  "",  dfNone,   		0, 		false, true);	//	조건 완화되면 spc_aloc_ctrl 테이블의 RAPLY_CFM_FLG를 setting
 					InitDataProperty(0, cnt++ , dtHidden,  		70,   daCenter,  	false,	"dir_cd",  				false,  "",  dfNone,   		0, 		false, true);	//	조건 완화되면 spc_aloc_ctrl 테이블의 RAPLY_CFM_FLG를 setting
 					

 					// 2015.02.13 회의에서 booking control detail office와 SMP Group로 확정, SMP Group일 경우 account레벨로 control할지 Flag추가
 					InitDataCombo (0, "bkg_ctrl_tp_cd", "Alloc Office|SMP Group", "O|S");
 					
 					HeadRowHeight = 35 ;

 			   }
 				break;
		}
	}



  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:      //조회
				if(checkModifiedSheet(sheetObj)){
					//두개 이상의 Sheet를 동시에 체크해야 하여 하나라도 수정된 Sheet가 존재하는 경우를 체크하고자 하는경우 사용
			        if(ComShowConfirm (getMsg("SPC90001")) != 1){
			            return;
			        }
				}			
				
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
				
				document.getElementById("acc_rep_trade").innerHTML = "";
		    	document.getElementById("acc_sub_trade").innerHTML = "";
		    	document.getElementById("acc_lane").innerHTML = "";
		    	document.getElementById("acc_bound").innerHTML = "";
		    	
				formObj.f_cmd.value = SEARCHLIST;
				
				var param = SpcFormString(formObj,"f_cmd,trade,subtrade,lane,bound");
				
				sheetObj.DoSearch4Post("ESM_SPC_0052GS.do", param);
				break;
				
		   case IBSAVE: //Sheet1 의 save
			   
			   if (sheetObj.isDataModified == false){
				   ComShowMessage(getMsg("SPC90142"));
				   return false;
			   }
			   
			   if(!validateForm(sheetObj,formObj,sAction)){
                   return false;
               }
			   
			   //조건이 완화 되었는지 확인 한다. => bkg_ctrl_aloc_flg 등 3개 변경됨.
			   for( var x=0 ; x<sheetObj.RowCount ; x++ ) {
    			   var flag1=false;
    			   var flag2=false;
//    			   var flag3=false;

    			   var cRow = x + 3;
    			   if( sh1Condition[x][0] == 1 && sheetObj.CellValue( cRow , "bkg_ctrl_aloc_aply_flg" ) == 0 ){
    	    			flag1 = true;
    	    		}
    	    		
    	    		if( sh1Condition[x][1] == 1 && sheetObj.CellValue( cRow , "bkg_ctrl_acct_grp_aply_flg" ) == 0 ) {
    	    			flag2 = true;    			
    	    		}
    	    		
//    	    		if( sh1Condition[x][2] == 1 && sheetObj.CellValue( cRow , "bkg_ctrl_mst_tbl_aply_flg" ) == 0 ) {
//    	    			flag3 = true;
//    	    		}
    	    		
    	    		if( flag1 || flag2 )//|| flag3 )
    	    			sheetObj.CellValue( cRow, "rd_flg" ) = "1";
    	    		else
    	    			sheetObj.CellValue( cRow, "rd_flg" ) = "";
			   }
			   formObj.f_cmd.value = MULTI;
			   var param = SpcFormString(formObj,"f_cmd");
			   var rtn = doSaveSheet(sheetObj, "ESM_SPC_0052GS.do", param);
			   break;

		   case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

		   case SEARCHLIST02:		
			   var mainRow = sheetObjects[0].SelectRow; 
			   var param = "f_cmd=" + SEARCHLIST02 + "&trade=" + sheetObjects[0].CellValue(mainRow,"trd_cd") + "&subtrade=" + sheetObjects[0].CellValue(mainRow,"sub_trd_cd") + "&lane=" + sheetObjects[0].CellValue(mainRow,"rlane_cd") + "&bound=" + sheetObjects[0].CellValue(mainRow,"dir_cd");
			   sheetObj.DoSearch4Post("ESM_SPC_0052GS.do", param);    
			
			   param = "&trd_cd=" + sheetObjects[0].CellValue(mainRow,"trd_cd") + "&sub_trd_cd=" + sheetObjects[0].CellValue(mainRow,"sub_trd_cd") + "&rlane_cd=" + sheetObjects[0].CellValue(mainRow,"rlane_cd") + "&dir_cd=" + sheetObjects[0].CellValue(mainRow,"dir_cd") + "&aloc_ctrl_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow , "aloc_ctrl_tp_cd");
			   var param2 = "f_cmd=" + SEARCHLIST03 + param;
			   sheetObjects[2].DoSearch4Post("ESM_SPC_0052GS.do", param2); //Booking Control option용
			   
			   //Tooltip 넣기.
           		var size = sheetObjects[1].RowCount;
           		for( var x=0 ; x<size ; x++ ){
           			if( sheetObjects[1].CellValue( x , "ofc_cd" ) != '' ){
           				var t = sheetObjects[1].CellValue( x , "ofc_cd" );
           				sheetObjects[1].ToolTipText(x, "ofc_cd") = t;
           			}
           		}
			   break;
		   case COMMAND01: //sheet2 save
			   if(!validateForm(sheetObj,formObj,sAction)){
                   return false;
               }  
			   
			   formObj.f_cmd.value = COMMAND01;
			   var param = SpcFormString(formObj,"f_cmd");
			   var rtn = doSaveSheet(sheetObj, "ESM_SPC_0052GS.do", param);
			
			   break;
		
		   case COMMAND02: //sheet4 save
  	    		if(!checkDupRow(sheetObjects[2])){		//동일한 값이 있는지 검사.
					ComShowMessage(getMsg("SPC90135"));
	            	return false;
	            }
  				
			    if (sheetObjects[2].isDataModified == false){ //수정된 row가 없다면
				   ComShowMessage(getMsg("SPC90142"));
				   return false;
			    }
			    
			   if(!validateForm(sheetObj,formObj,sAction)){
                   return false;
               }  
			   
			   var mainRow 	 = sheetObjects[0].SelectRow; 
			   var thisRow   = sheetObjects[2].SelectRow;
			   
			   var param = "f_cmd=" + MULTI02;
   			   param += "&trd_cd=" 			+ sheetObjects[0].CellValue(mainRow, "trd_cd") + 
   			   			"&sub_trd_cd=" 		+ sheetObjects[0].CellValue(mainRow, "sub_trd_cd") + 
   			   			"&aloc_ctrl_tp_cd=" + sheetObjects[2].CellValue(thisRow, "aloc_ctrl_tp_cd") +
   			   			"&ctrl_loc_acct_cd="+ sheetObjects[2].CellValue(thisRow, "ctrl_loc_acct_cd") ;
			   var rtn = doSaveSheet(sheetObjects[2], "ESM_SPC_0052GS.do", param);
			
			   break;	   
			   
		   case IBDELETE :
			   if(!validateForm(sheetObj,formObj,sAction)){
                   return false;
               } 
			   
			   if (ComShowCodeConfirm("COM12165", "the selected data")) { 	
				   var selRow = sheetObjects[1].SelectRow;
    			           			       				   
    			   if(sheetObjects[1].CellValue(selRow, "ibflag") == "I") { //신규행의 경우 그리드에서만 삭제
    				   sheetObjects[1].RowDelete(selRow, false);
    			   }
    			   else {	//조회건은 데이터 삭제    			   
	    			   var param = "f_cmd=" + REMOVE + "&trd_cd=" + sheetObjects[1].CellValue(selRow,"trd_cd") + "&sub_trd_cd=" + sheetObjects[1].CellValue(selRow,"sub_trd_cd") 
	    			           + "&rlane_cd=" + sheetObjects[1].CellValue(selRow,"rlane_cd") + "&dir_cd=" + sheetObjects[1].CellValue(selRow,"dir_cd") 
	    			           + "&aloc_ctrl_tp_cd=" + sheetObjects[1].CellValue(selRow,"aloc_ctrl_tp_cd") + "&ctrl_loc_acct_cd=" + sheetObjects[1].CellValue(selRow,"ctrl_loc_acct_cd")
	    					   + "&aloc_ctrl_dtl_cd=" + sheetObjects[1].CellValue(selRow,"aloc_ctrl_dtl_cd");    
	    			   var sXml = sheetObj.GetSaveXml("ESM_SPC_0052GS.do", param);      			      			
	    			   
	                   var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	                   if(result != "F") { // 성공시				     				   				
	         				doActionIBSheet(sheetObjects[1], formObj, SEARCHLIST02);   
	                   }else{
	         				ComShowCodeMessage("COM130304", "Data");
	                   }	
    			   }
			   }
			       			   
			   break;
		}
	}	
  	
	/*
	 *  trade변경시
	 */
	function trade_OnChange(comObj,value,text){		
//    		if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
    	//sub_trade value change  
    	comObjects[1].Index2 = 0; 
    	//lane value change
    	comObjects[2].Index2 = 0;
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
	}
				
	/*
	 * sub_trade변경시
	 */
	function subtrade_OnChange(comObj,value,text ){
    	if(value == "" ) return;
     	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    	}     	    
    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
	    //lane value change
	    comObjects[2].Index2 = 0;        
  	} 
   
   	/*
	 * lane변경시
	 */
   	function lane_OnChange(comObj,value,text ){
		var repTrade = comObj.GetText(value,0);  
	    var subTrade = comObj.GetText(value,1);
	    if(value != "" ){  
		   	comObjects[0].Code2 = repTrade;		   	
		   	comObjects[1].Code2 = subTrade;
	 	}else{
	 		comObjects[0].Code2 = "";
			comObjects[1].Code2 = "";
	    }
   	}    
		
   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction){
			case  IBSAVE:
				var sList   = sheetObj.FindStatusRow("U|I");
				var sArr    = sList.split(";");
				var fm_yrwk = "";
				var to_yrwk = "";
				for ( var i = 0; i < sArr.length - 1; i++) {
					if(sheetObj.CellValue(sArr[i], "acct_grp_ctrl_flg") == "1") { // 0 이 N, 1 이 Y
    					fm_yrwk = sheetObj.CellValue(sArr[i], "aply_fm_yrwk");
    					to_yrwk = sheetObj.CellValue(sArr[i], "aply_to_yrwk");
    					
    					if(fm_yrwk.length != 6) {
    						ComShowMessage(getMsg("SPC90141", "From Week"));
    						sheetObj.CellValue2(sArr[i], "aply_fm_yrwk") = "";
    						sheetObj.SelectCell(sArr[i], "aply_fm_yrwk");
    						return false;
    					} else if(to_yrwk.length != 6) {
    						ComShowMessage(getMsg("SPC90141", "To Week"));
    						sheetObj.CellValue2(sArr[i], "aply_to_yrwk") = "";
    						sheetObj.SelectCell(sArr[i], "aply_to_yrwk");
    						return false;
    					} else if(sheetObj.CellValue(sArr[i], "aply_fm_yrwk") > sheetObj.CellValue(sArr[i], "aply_to_yrwk")) {
    						ComShowMessage(getMsg("SPC90140",'Period','From Week','To Week'));
    						sheetObj.CellValue2(sArr[i], "aply_to_yrwk") = "";
    						sheetObj.SelectCell(sArr[i], "aply_to_yrwk");
    						return false;
    					}
					}
					
					// POL/POD dest 선택시 
					if(sheetObj.CellValue(sArr[i], "ctrl_lvl_cd") == "T") {
						if(sheetObj.CellValue(sArr[i], "ctrl_ecc_flg") == "0" && sheetObj.CellValue(sArr[i], "ctrl_ecc_grp_flg") == "0") { // ECC 또는 Loc 필수 체크
							ComShowCodeMessage("COM12113", "ECC or Loc Group"); 
							sheetObj.SelectCell(sArr[i], "ctrl_ecc_flg");
							return false;
						}
						
						if(ComTrimAll(sheetObj.CellValue(sArr[i], "ctrl_dest_lvl_cd")) == "") {  // POD/DEL 필수 체크  							
							ComShowCodeMessage("COM12113", "POD/DEL"); 
							sheetObj.SelectCell(sArr[i], "ctrl_dest_lvl_cd");
							return false;
						}
					}
					
					//BKG Control F'CST 선택시 From DATA 필수 bkg_ctrl_aloc_fcast_flg bkg_ctrl_acct_grp_fcast_flg
					var f_from_wk = ComTrimAll(sheetObj.CellValue(sArr[i], "bkg_ctrl_fcast_fm_yrwk")).replace('-', '');
					if(sheetObj.CellValue(sArr[i],"bkg_ctrl_aloc_fcast_flg") + sheetObj.CellValue( sArr[i], "bkg_ctrl_acct_grp_fcast_flg") > 0 
							&& f_from_wk.length != 6) {
						ComShowMessage(getMsg("SPC90141", "F.L/F From"));
						sheetObj.SelectCell(sArr[i], "bkg_ctrl_fcast_fm_yrwk");
						return false;
					}
				}
				break;
				
			case COMMAND01: //sheet2 save
				var mainRow = sheetObjects[0].SelectRow;	
				
				if(mainRow < 0) {
					ComShowCodeMessage("COM12189"); 
					return false;
				} 
				
				if(sheetObjects[0].CellValue(mainRow, "ctrl_ecc_flg")=="0" && sheetObjects[0].CellValue(mainRow, "ctrl_ecc_grp_flg")=="0" && sheetObjects[0].CellValue(mainRow, "ctrl_acct_flg")=="0") {    						
					ComShowMessage(getMsg("SPC90146"));
					return false;    					
				}
				
				//입력된, 수정된 Row 의 값중 ctrl_loc_acct_cd 에 해당 하는 값의 길이 5자 이상인지 확인 하는 로직
				var thisSelRow = sheetObjects[1].SelectRow;
				var code = sheetObjects[1].CellValue( thisSelRow , "ctrl_loc_acct_cd" );
				if( code.length < 5 ) {
					ComShowMessage(getMsg("SPC90304","Ecc, Loc Group Code"));
					return false;
				}
				
				if(sheetObjects[1].IsDataModified == false) {
					ComShowCodeMessage("COM130503"); 
					return false;
				}
				
				// Code 열 필수처리 체크
				for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].HeaderRows+sheetObjects[1].RowCount; i++) {
					if(ComTrimAll(sheetObjects[1].CellValue(i, "ctrl_loc_acct_cd")) == "") {
						ComShowCodeMessage("COM130404", "CODE", "CODE"); 
						return false;
					}
				}

				// Control - Code 중복체크
				var dupRow = sheetObjects[1].ColValueDup("aloc_ctrl_tp_cd|ctrl_loc_acct_cd|aloc_ctrl_dtl_cd"); //|ofc_cd"); //중복검사.- control / ecc,loc / acc,cmdt
				if(dupRow != -1) {
					ComShowCodeMessage("COM12115", "Control"); 
					return false;						
				}
				
				break;
				
			case COMMAND02: //sheet4 save
				//빈값 체크
			    for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows + sheetObjects[2].RowCount ; i++){
				   //Ratio 
				   if( sheetObjects[2].CellValue(i, "ibflag") != "D" && sheetObjects[2].CellValue(i, "bkg_ctrl_rto") == "") {
					   ComShowMessage(getMsg("SPC90147")); //Please input Ratio.
					   return false;
				   }
				   //Code
				   if( sheetObjects[2].CellValue(i, "ibflag") != "D" && sheetObjects[2].CellValue(i, "bkg_ctrl_dtl_cd") == "" ) {
					   ComShowMessage(getMsg("SPC90148")); //Please input Code.
					   return false;
				   }
				}
			    
 			   	for( var x=1 ; x<=sheetObjects[2].RowCount ; x++ ) {
				   var cRow = x + 1;
				   var nVal = sheetObjects[2].CellValue( x , "bkg_ctrl_rto" );
				   var oVal = sh3Condition[x];
				   nVal = parseInt( nVal );
				   oVal = parseInt( oVal );
				   if( sheetObjects[2].CellValue( x , "bkg_ctrl_tp_cd" ) == "S" && oVal > nVal )
					   sheetObjects[2].CellValue( x , "rd_flg") = "1";
 			   	}
				break;
				
			case IBDELETE :
				var selRow = sheetObjects[1].SelectRow;	
				
				if(selRow < 0) {
					ComShowCodeMessage("COM12189"); 
					return false;
				} 
				
				break;
		}
		return true;
	}

	
	function initDataValue_trade(){
    	var sheetObj = document.getElementById("trade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_subtrade(){
    	var sheetObj = document.getElementById("subtrade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_lane(){
    	var sheetObj = document.getElementById("lane");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }  
    
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek1(){
    	SpcSearchOptionWeek("week1",false,document.form.year1.value);
    	
    }  	
    
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var sName = sheetObj.ColSaveName(Col);
    	switch(sName){
    	    case "acct_grp_ctrl_flg":
    	    	if(Value == "0"){
    	    		if(sheetObj.CellValue(Row, "hh_flg") == "Y") {
    	    			sheetObj.CellEditable(Row, "aply_fm_yrwk") = false;
    	    			sheetObj.CellEditable(Row, "aply_to_yrwk") = false;
    	    		}
    	    	} else {
    	    		if(sheetObj.CellValue(Row, "hh_flg") == "Y") {
    	    			sheetObj.CellEditable(Row, "aply_fm_yrwk") = true;
    	    			sheetObj.CellEditable(Row, "aply_to_yrwk") = true;
    	    			
    	    			if(sheetObj.CellValue(Row, "aply_fm_yrwk") == "") sheetObj.SelectCell(Row, "aply_fm_yrwk");
    	    		}
    	    	}
    	    	
    	    	break;
        	case "ctrl_lvl_cd":
        		if(Value == "D")
        			sheetObj.CellValue2(Row, "ctrl_port_flg") = "Y";
        		else
        			sheetObj.CellValue2(Row, "ctrl_port_flg") = "N";
        		
        		//POL/POD 컬럼에 Dest 선택시 활성화, 비활성화
        		if(Value == "T") {
        			sheetObj.CellEditable(Row, "ctrl_ecc_flg") = true;
        			sheetObj.CellEditable(Row, "ctrl_ecc_grp_flg") = true;
        			sheetObj.CellEditable(Row, "ctrl_dest_lvl_cd") = true;
        			//deault값 세팅
        			sheetObj.CellValue2(Row, "ctrl_ecc_flg") = "1"; 
        			sheetObj.CellValue2(Row, "ctrl_dest_lvl_cd") = "POD";
        		}	
        		else {
        			sheetObj.CellEditable(Row, "ctrl_ecc_flg") = false;
        			sheetObj.CellEditable(Row, "ctrl_ecc_grp_flg") = false;
        			sheetObj.CellEditable(Row, "ctrl_dest_lvl_cd") = false;
        			
        			sheetObj.CellValue2(Row, "ctrl_ecc_flg") = "0";
        			sheetObj.CellValue2(Row, "ctrl_ecc_grp_flg") = "0";	 
        			sheetObj.CellValue2(Row, "ctrl_dest_lvl_cd") = " ";
        		}
        		
        		break;
        	case "ctrl_ecc_flg" :	        		
        		sheetObj.CellValue2(Row, "ctrl_ecc_grp_flg") = "0"; 
        		break;        		
        	case "ctrl_ecc_grp_flg" :
        		sheetObj.CellValue2(Row, "ctrl_ecc_flg") = "0";
        		break;	   
        	// 2015.02.13 F'CST flag켠 경우에만 Ratio입력 가능
        	case "bkg_ctrl_aply_flg" :
        		if(Value == "1") {
        			sheetObj.CellValue2(Row, "bkg_ctrl_fcst_flg") = "0";
        			sheetObj.CellEditable(Row, "bkg_ctrl_fcst_rto") = false;
        			sheetObj.CellValue2(Row, "bkg_ctrl_fcst_rto")  = "";
        		}
        		break;		
        	case "bkg_ctrl_fcst_flg" :
        		sheetObj.CellValue2(Row, "bkg_ctrl_aply_flg") = "0";
        		if(Value == "1") {
        			sheetObj.CellEditable(Row, "bkg_ctrl_fcst_rto") = true;
        		}	
        		else{
        			sheetObj.CellEditable(Row, "bkg_ctrl_fcst_rto") = false;
        			sheetObj.CellValue2(Row, "bkg_ctrl_fcst_rto")  = "";
        		}
        		break;	 
        		
	        // 추가
        	case "bkg_ctrl_acct_grp_aply_flg" :
        		if(Value == "1") {
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_fcast_flg") = "0";
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_rto") = false;
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_tp_cd") = true;
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_tp_cd")  = "S";
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_rto")  = "";
        			var v = sheetObj.CellValue(Row,"bkg_ctrl_aloc_fcast_flg") + sheetObj.CellValue( Row, "bkg_ctrl_acct_grp_fcast_flg")
//        					+sheetObj.CellValue( Row, "bkg_ctrl_mst_tbl_fcast_flg")
        					;
            		if( v == 0 ){
//	            			if( !LFARY[row] ) { //하나라도 체크가 안된 경우 에만 from 값 제거
//	            			}
            			sheetObj.CellValue( Row, "bkg_ctrl_fcast_fm_yrwk" ) = "" ;
            			sheetObj.CellEditable( Row, "bkg_ctrl_fcast_fm_yrwk") = false;
            		}
        		}else{
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_tp_cd")  = "";
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_tp_cd") = false;
        		}
        		break;		
        	case "bkg_ctrl_acct_grp_fcast_flg" :
        		sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_aply_flg") = "0";
        		if(Value == "1") {
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_rto") = true;
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_tp_cd")  = "S";
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_tp_cd") = true;
        		}	
        		else{
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_rto") = false;
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_rto")  = "";
        			sheetObj.CellValue2(Row, "bkg_ctrl_acct_grp_tp_cd")  = "";
        			sheetObj.CellEditable(Row, "bkg_ctrl_acct_grp_tp_cd") = false;
        		}
        		setFlfFrom( Row, Value );
        		break;	
        		
//		    // 추가
//        	case "bkg_ctrl_mst_tbl_aply_flg" :
//        		if(Value == "1") {
//        			sheetObj.CellValue2(Row, "bkg_ctrl_mst_tbl_fcast_flg") = "0";
//        			sheetObj.CellEditable(Row, "bkg_ctrl_mst_tbl_fcast_rto") = false;
//        			sheetObj.CellValue2(Row, "bkg_ctrl_mst_tbl_fcast_rto")  = "";
//        			var v = sheetObj.CellValue(Row,"bkg_ctrl_aloc_fcast_flg") + sheetObj.CellValue( Row, "bkg_ctrl_acct_grp_fcast_flg")+sheetObj.CellValue( Row, "bkg_ctrl_mst_tbl_fcast_flg");
//            		if( v == 0 ){
////	            			if( !LFARY[row] ) { //하나라도 체크가 안된 경우 에만 from 값 제거
////	            			}
//            			sheetObj.CellValue( Row, "bkg_ctrl_fcast_fm_yrwk" ) = "" ;
//            			sheetObj.CellEditable( Row, "bkg_ctrl_fcast_fm_yrwk") = false;
//            		}
//        		}
//        		break;		
//        	case "bkg_ctrl_mst_tbl_fcast_flg" :
//        		sheetObj.CellValue2(Row, "bkg_ctrl_mst_tbl_aply_flg") = "0";
//        		if(Value == "1") {
//        			sheetObj.CellEditable(Row, "bkg_ctrl_mst_tbl_fcast_rto") = true;
//        		}	
//        		else{
//        			sheetObj.CellEditable(Row, "bkg_ctrl_mst_tbl_fcast_rto") = false;
//        			sheetObj.CellValue2(Row, "bkg_ctrl_mst_tbl_fcast_rto")  = "";
//        		}
//        		setFlfFrom( Row, Value );
//        		break;
        		
			    // 추가
        	case "bkg_ctrl_aloc_aply_flg" :
        		if(Value == "1") {
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_fcast_flg") = "0";
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_fcast_rto") = false;
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_tp_cd") = true;
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_tp_cd")  = "S";
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_fcast_rto")  = "";
        			var v = sheetObj.CellValue(Row,"bkg_ctrl_aloc_fcast_flg") + sheetObj.CellValue( Row, "bkg_ctrl_acct_grp_fcast_flg")
//        			+sheetObj.CellValue( Row, "bkg_ctrl_mst_tbl_fcast_flg")
        			;
            		if( v == 0 ){
//	            			if( !LFARY[row] ) { //하나라도 체크가 안된 경우 에만 from 값 제거
//	            			}
            			sheetObj.CellValue( Row, "bkg_ctrl_fcast_fm_yrwk" ) = "" ;
            			sheetObj.CellEditable( Row, "bkg_ctrl_fcast_fm_yrwk") = false;
            		}
        		}else{
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_tp_cd")  = "";
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_tp_cd") = false;
        		}
        		break;		
        	case "bkg_ctrl_aloc_fcast_flg" :
        		sheetObj.CellValue2(Row, "bkg_ctrl_aloc_aply_flg") = "0";
        		if(Value == "1") {
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_fcast_rto") = true;
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_tp_cd") = true;
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_tp_cd")  = "S";
        		}	
        		else{
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_fcast_rto") = false;
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_fcast_rto")  = "";
        			sheetObj.CellValue2(Row, "bkg_ctrl_aloc_tp_cd")  = "";
        			sheetObj.CellEditable(Row, "bkg_ctrl_aloc_tp_cd") = false;
        		}
        		setFlfFrom( Row, Value );
        		break;
        		
    	    case "bkg_ctrl_lane_flg":
    	    	var mainRow = sheetObjects[0].SelectRow;	
				if(mainRow < 0) {
					ComShowCodeMessage("COM12189");
					sheetObj.CellValue2(Row, "bkg_ctrl_lane_flg") = sheetObj.CellSearchValue(Row, "bkg_ctrl_lane_flg");
					return;
				}    		
				var secondRow = sheetObjects[1].SelectRow;
				if( secondRow < 0 ) {
					ComShowCodeMessage("COM12189");
					sheetObj.CellValue2(Row, "bkg_ctrl_lane_flg") = sheetObj.CellSearchValue(Row, "bkg_ctrl_lane_flg");
					return;
				}
				if(Value == 1){
					ComShowMessage(getMsg("SPC90310")); //'For applying By Lane condition, please save [Booking Control Option] sheet.'
	    			sheetObj.CellValue2(Row, "bkg_ctrl_lane_upd_flg")   = "";
				    for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows + sheetObjects[2].RowCount ; i++){
				    	if(sheetObjects[2].CellValue(i, "bkg_ctrl_tp_cd") == "S"){
				    		sheetObjects[2].CellValue2(i, "bkg_ctrl_lane_flg")   = "Y";
				    		sheetObjects[2].CellValue2(i, "rlane_cd") = sheetObj.CellValue(Row, "rlane_cd");
				    		sheetObjects[2].CellValue2(i, "dir_cd")   = sheetObj.CellValue(Row, "dir_cd");
				    		sheetObjects[2].CellValue2(i, "ibflag")   = "U";
				    		sheetObjects[2].RowHidden(i) = false;
				    	}
				    }
	    		}else if(Value == 0){
	    	    	if(sheetObj.CellSearchValue(Row, "bkg_ctrl_lane_flg") != Value){
	    	    		//위 시트의 by Lane uncheck시 SPC_BKG_CTRL_OPT_DTL 에서 해당 Lane, Bound 데이터를 지움
	    	    		sheetObj.CellValue2(Row, "bkg_ctrl_lane_upd_flg") = "Y";
    				    for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows + sheetObjects[2].RowCount ; i++){
    				    	if(sheetObjects[2].CellValue(i, "bkg_ctrl_tp_cd") == "S"){
    				    		sheetObjects[2].CellValue2(i, "bkg_ctrl_lane_flg")   = "N";
    				    		sheetObjects[2].CellValue2(i, "ibflag")   = "D";
    				    		sheetObjects[2].RowHidden(i) = true;
    				    	}
    				    }
	    	    	}else{
		    			sheetObj.CellValue2(Row, "bkg_ctrl_lane_upd_flg") = "";
    				    for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows + sheetObjects[2].RowCount ; i++){
    				    	if(sheetObjects[2].CellValue(i, "bkg_ctrl_tp_cd") == "S"){
    				    		sheetObjects[2].CellValue2(i, "bkg_ctrl_lane_flg")   = "N";
    				    		sheetObjects[2].CellValue2(i, "rlane_cd") = "XXXXX";
    				    		sheetObjects[2].CellValue2(i, "dir_cd")   = "X";
    				    	}
    				    }
	    	    	}	
	    		}
    	    	break;	
    	}
    }
    
    /**
     * 추가 요건 사항.
     * L/F 가 set/reset 되는 경우 호출
     * bkg_ctrl_fcast_fm_yrwk 에 값을 넣는다.
     */
    function setFlfFrom( row, value ) {
    	if( value == '1' ) { //이전에 check 되어 있지 않고 현재 체크 한경우만 bkg_ctrl_fcast_fm_yrwk에 현재 주차정보 입력
    		sheetObjects[0].CellValue( row, "bkg_ctrl_fcast_fm_yrwk" ) = init_year1 + "" + init_week1 ;
    		sheetObjects[0].CellEditable(row, "bkg_ctrl_fcast_fm_yrwk") = true;
    	} else {
    		var v = sheetObjects[0].CellValue( row,"bkg_ctrl_aloc_fcast_flg") + sheetObjects[0].CellValue( row, "bkg_ctrl_acct_grp_fcast_flg")
//    		+sheetObjects[0].CellValue( row, "bkg_ctrl_mst_tbl_fcast_flg")
    		;
    		if( v == 0 ){
//        			if( !LFARY[row] ) { //하나라도 체크가 안된 경우 에만 from 값 제거
//        			}
    			sheetObjects[0].CellValue( row, "bkg_ctrl_fcast_fm_yrwk" ) = "" ;
    			sheetObjects[0].CellEditable(row, "bkg_ctrl_fcast_fm_yrwk") = false;
    		}
    	}
    }
    
    function sheet1_OnSaveEnd(sheetObj, errMsg){
    	var formObject = document.form;
    	
    	if(errMsg == ""){
    		ComShowCodeMessage("COM130102", "Data"); 
    		doActionIBSheet(sheetObj,formObject,IBSEARCH);
    	}
    }
         
    function sheet2_OnSaveEnd(sheetObj, errMsg){
    	var formObject = document.form;
    	
    	if(errMsg == ""){
    		ComShowCodeMessage("COM130102", "Data"); 
    		doActionIBSheet(sheetObjects[1],formObject,SEARCHLIST02);
    	}
    }
    
    function sheet4_OnSaveEnd(sheetObj, errMsg){
    	var formObject = document.form;
    	
    	if(errMsg == ""){
    		ComShowCodeMessage("COM130102", "Data"); 
    		doActionIBSheet(sheetObjects[1],formObject,SEARCHLIST02);
    	}
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	ComOpenWait(true);
    	LFARY = new Array( sheetObj.RowCount );
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    		if(sheetObj.CellValue(i, "hh_flg") == "Y") {
    			sheetObj.CellEditable(i, "acct_grp_ctrl_flg") = true;
    			
    			if(sheetObj.CellValue(i, "acct_grp_ctrl_flg") == "N") {
    				sheetObj.CellEditable(i, "aply_fm_yrwk") = false;
    				sheetObj.CellEditable(i, "aply_to_yrwk") = false;
    			}else{
    				sheetObj.CellEditable(i, "aply_fm_yrwk") = true;
    				sheetObj.CellEditable(i, "aply_to_yrwk") = true;
    			}
    		}
    		
    		//POL/POD 컬럼에 Dest 선택시 활성화, 비활성화
    		if(sheetObj.CellValue(i, "ctrl_lvl_cd") == "T") {
    			sheetObj.CellEditable(i, "ctrl_ecc_flg") = true;
    			sheetObj.CellEditable(i, "ctrl_ecc_grp_flg") = true;
    			sheetObj.CellEditable(i, "ctrl_dest_lvl_cd") = true;
    		}
    		else {
    			sheetObj.CellEditable(i, "ctrl_ecc_flg") = false;
    			sheetObj.CellEditable(i, "ctrl_ecc_grp_flg") = false;  
    			sheetObj.CellEditable(i, "ctrl_dest_lvl_cd") = false;
    		}
    		
    		
    		//bkg_ctrl_acct_grp_fcast_flg
    		var flag =false;
    		if(sheetObj.CellValue(i, "bkg_ctrl_acct_grp_fcast_flg") == "1") {
    			sheetObj.CellEditable(i, "bkg_ctrl_acct_grp_rto") = true;
    			flag = true;
    		} else {
    			sheetObj.CellEditable(i, "bkg_ctrl_acct_grp_rto") = false;
    			sheetObj.CellValue2(i, "bkg_ctrl_acct_grp_rto")  = "";
    		}
    		//bkg_ctrl_acct_grp_aply_flg
    		if(sheetObj.CellValue(i, "bkg_ctrl_acct_grp_aply_flg") == "1") {
    			sheetObj.CellEditable(i, "bkg_ctrl_acct_grp_rto") = true;
    			flag = true;
    		} else {
    			sheetObj.CellEditable(i, "bkg_ctrl_acct_grp_rto") = false;
    			sheetObj.CellValue2(i, "bkg_ctrl_acct_grp_rto")  = "";
    		}
    		if(sheetObj.CellValue(i, "bkg_ctrl_acct_grp_fcast_flg") == "1" || sheetObj.CellValue(i, "bkg_ctrl_acct_grp_aply_flg") == "1"){
    			sheetObj.CellEditable(i, "bkg_ctrl_acct_grp_tp_cd") = true;
    		}else{
    			sheetObj.CellEditable(i, "bkg_ctrl_acct_grp_tp_cd") = false;
    		}
    		
    		//bkg_ctrl_aloc_aply_flg
    		if(sheetObj.CellValue(i, "bkg_ctrl_aloc_aply_flg") == "1") {
    			sheetObj.CellEditable(i, "bkg_ctrl_aloc_fcast_rto") = true;
    			flag = true;
    		} else {
    			sheetObj.CellEditable(i, "bkg_ctrl_aloc_fcast_rto") = false;
    			sheetObj.CellValue2(i, "bkg_ctrl_aloc_fcast_rto")  = "";
    		}    		
    		if(sheetObj.CellValue(i, "bkg_ctrl_aloc_fcast_flg") == "1") {
    			sheetObj.CellEditable(i, "bkg_ctrl_aloc_fcast_rto") = true;
    			flag = true;
    		} else {
    			sheetObj.CellEditable(i, "bkg_ctrl_aloc_fcast_rto") = false;
    			sheetObj.CellValue2(i, "bkg_ctrl_aloc_fcast_rto")  = "";
    		}
    		
    		if(sheetObj.CellValue(i, "bkg_ctrl_aloc_aply_flg") == "1" || sheetObj.CellValue(i, "bkg_ctrl_aloc_fcast_flg") == "1") {
    			sheetObj.CellEditable(i, "bkg_ctrl_aloc_tp_cd") = true;
    		}else{
    			sheetObj.CellEditable(i, "bkg_ctrl_aloc_tp_cd") = false;    			
    		}
    		LFARY[i] = flag;
    		if( !flag )sheetObj.CellEditable(i, "bkg_ctrl_fcast_fm_yrwk") = false;
    		
    		
    		sh1Condition[i-3] = new Array();
    		sh1Condition[i-3][0] = sheetObj.CellValue( i , "bkg_ctrl_aloc_aply_flg" );
    		sh1Condition[i-3][1] = sheetObj.CellValue( i , "bkg_ctrl_acct_grp_aply_flg" );
//    		sh1Condition[i-3][2] = sheetObj.CellValue( i , "bkg_ctrl_mst_tbl_aply_flg" );

    	}
    	        	
    	sheetObjects[1].RemoveAll();
    	sheetObjects[2].RemoveAll();
//        	sheetObjects[3].RemoveAll();
    	
    	//bkg_ctrl_aloc_flg 등 컬럼 3개 삭제 예정, Reduce 조건 다시 정의 후 개발해야 함.
//        	for( var x=0 ; x<sheetObj.RowCount ; x++ ) {
//        		sh1Condition[x] = new Array();
//        		var xRow = x + 3;
//        		sh1Condition[x][0] = sheetObj.CellValue( xRow , "bkg_ctrl_aloc_aply_flg" );
//        		sh1Condition[x][1] = sheetObj.CellValue( xRow , "bkg_ctrl_acct_grp_aply_flg" );
//        		sh1Condition[x][2] = sheetObj.CellValue( xRow , "bkg_ctrl_mst_tbl_aply_flg" );
//        	}
//        	
		ComOpenWait(false);
    }
        
    function sheet1_OnDblClick(sheetObj, row, col){
//	    function sheet1_OnClick(sheetObj, row, col) {
    	var formObject = document.form;
    	recentClick = sheetObj.ColSaveName(col);
    	
//	    	if(recentClick != "ctrl_dest_lvl_cd" && recentClick != "ctrl_lvl_cd" && recentClick != "aply_fm_yrwk" && recentClick != "aply_to_yrwk"
//	    	&&recentClick != "bkg_ctrl_aply_flg" &&recentClick != "bkg_ctrl_aloc_flg" &&recentClick != "bkg_ctrl_acct_grp_flg" &&recentClick != "bkg_ctrl_mst_flg"
//	    		&&recentClick != "bkg_ctrl_aply_flg" &&recentClick != "bkg_ctrl_fcst_flg" &&recentClick != "bkg_ctrl_fcst_rto") { 
    		//콘보박스나 편집행의 경우 조회를 태우면 콤보박스가 초기화 또는 편집행의 불능화가 되므로 클릭 이벤트에서 제외시킴	
    	if( recentClick == "trd_cd" || recentClick == "sub_trd_cd" || recentClick == "rlane_cd" || recentClick == "dir_cd" ){
	    	sheetObjects[1].RemoveAll();
	    	
	    	document.getElementById("acc_rep_trade").innerHTML = "Rep.Trade : "+sheetObj.CellValue(row, "trd_cd");
	    	document.getElementById("acc_sub_trade").innerHTML = "Sub Trade : "+sheetObj.CellValue(row, "sub_trd_cd");
	    	document.getElementById("acc_lane").innerHTML = "Lane : "+sheetObj.CellValue(row, "rlane_cd");
	    	document.getElementById("acc_bound").innerHTML = "Bound : "+sheetObj.CellValue(row, "dir_cd");
//		    	document.getElementById("acc_control").innerHTML = "";
	    	

        	var yrwk = weekNo();
        	var tc = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "trd_cd" );
        	
//	        	yrwk = "201406"; //나중에 없애야 합니다......
        	var param = "f_cmd="+SEARCHLIST06+"&yrwk="+yrwk+"&trd_cd="+tc;
        	var rtnXml = sheetObjects[0].GetSearchXml ("ESM_SPC_0052GS.do" , param ); //Control List
//	        	var total = ComGetTotalRows(rtnXml);
        	cust_code = ComXml2ComboString( rtnXml , "cust_ctrl_cd" , "cust_ctrl_cd" );
	    	doActionIBSheet(sheetObjects[1],formObject,SEARCHLIST02); //BKG Control
	    	
    	} /*else if( recentClick == "bkg_ctrl_aloc_flg" || recentClick == "bkg_ctrl_acct_grp_flg" || recentClick == "bkg_ctrl_mst_flg" ) {
    		checkFlag( sheetObjects[0] , recentClick , row );
    	}*/
    }
    
    function weekNo() {
  	  var totalDays = 0;                 
  	  var now = new	Date();
  	  var days = new Array(12);
  	  days[0] = 31;
  	  days[2] = 31;
  	  days[3] = 30;
  	  days[4] = 31;
  	  days[5] = 30;
  	  days[6] = 31;
  	  days[7] = 31;
  	  days[8] = 30;
  	  days[9] = 31;
  	  days[10] = 30;
  	  days[11] = 31;

  	  if (Math.round(now.getYear()/4) == now.getYear()/4) {
  	     days[1] = 29;
  	  }else{
  	     days[1] = 28;
  	  }

  	  if (now.getMonth() == 0) {                
  	     totalDays = totalDays + now.getDate();
  	  }else{
  	     var curMonth = now.getMonth();
  	     for (var count = 1; count <= curMonth; count++) {
  	         totalDays = totalDays + days[count - 1];
  	     }
  	     totalDays = totalDays + now.getDate();
  	   }
  	   var week = Math.round(totalDays/7);
  	   
  	   if( week < 10 )
  		   week = "0"+week;
  	   
  	   var yr = now.getFullYear();
  	   
  	   return yr+""+week;
  }
    	
	//조건이 완화 되어 SPC_ALOC_CTRL의 flag 값 변경.
	function setConditionReduce() {
		var param = "f_cmd=" + MODIFY + "&trade=" + sheetObjects[0].CellValue(mainRow,"trd_cd") + "&subtrade=" + sheetObjects[0].CellValue(mainRow,"sub_trd_cd") 
						+ "&lane=" + sheetObjects[0].CellValue(mainRow,"rlane_cd") + "&bound=" + sheetObjects[0].CellValue(mainRow,"dir_cd");
		var rtn = doSaveSheet(sheetObj, "ESM_SPC_0052GS.do", param);
	}
	
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
    	//ECC/Contract 선택
    	if(sheetObj.ColSaveName(Col) == "ctrl_loc_acct_cd") { 
    		// 2014.12.10 Actual/Individual Customer 모두 contract code base로 
    		// 2014.12.12 A: Individual (Booking의 계약 화주) B: Actual (실제화주) C:Booking commodity
    		if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "A") 
    		{url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no="+""+"&sc_no="
				+""+"&rfa_no="+""+"&svc_scp_cd="+""+"&app_dt="+""+"&type="+"A";}
    		else if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "B") 
    			{url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no="+""+"&sc_no="
					+""+"&rfa_no="+""+"&svc_scp_cd="+""+"&app_dt="+""+"&type="+"B";}
    		else if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "C")
    		{url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no="+""+"&sc_no="
				+""+"&rfa_no="+""+"&svc_scp_cd="+""+"&app_dt="+""+"&type="+"C";}
    		else if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "E")
    		{url = "COM_ENS_051.do?pgmNo=COM_ENS_051";}// Control 콤보를 Ecc, Loc 선택시
    		
    		if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") != "G"){
    		ComOpenPopup(url, 800, 420, "callBackPopup", "0,1,1,1,1,1", true, false, Row, Col, 1);	
    		}
    	}
    	// 2015.02. 12 Office Popup sheet 합쳐서 이리로 이동함. - ofc_cd 선택
    	else if(sheetObj.ColSaveName(Col) == "ofc_cd") { 
    		var mainRow = sheetObjects[0].SelectRow; 
    		var controlRow = sheetObjects[1].SelectRow;
    		var param = "f_cmd=" + SEARCHLIST03 + "&trd_cd=" + sheetObjects[0].CellValue(mainRow,"trd_cd") + "&sub_trd_cd=" + sheetObjects[0].CellValue(mainRow,"sub_trd_cd") + "&rlane_cd=" + sheetObjects[0].CellValue(mainRow,"rlane_cd") + "&dir_cd=" + sheetObjects[0].CellValue(mainRow,"dir_cd") + "&aloc_ctrl_tp_cd=" + sheetObjects[1].CellValue( controlRow , "aloc_ctrl_tp_cd");
    		param += "&ctrl_loc_acct_cd="+ sheetObjects[1].CellValue( controlRow , "ctrl_loc_acct_cd")+"&ofc_cd="+sheetObjects[1].CellValue( controlRow , "ofc_cd");
    		
    		selSheet = sheetObj;
    		selRow = Row;
    		
    		url = "ESM_SPC_0119.do?"+param;
    		
    		var chVal = ComOpenPopup(url, 300, 270, "", "0,1,1,1,1,1", true, false, Row, Col, 1);
    		setOfficeValue( chVal );
    	}
    	// 2015.02.12 Control이 ECC group 인 경우 popup 추가 - Account/Commodity 선택
    	else if(sheetObj.ColSaveName(Col) == "aloc_ctrl_dtl_cd") {
    		if (sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "G")
    		{url = "COM_ENS_051.do?pgmNo=COM_ENS_051";}// Control 콤보를 Ecc, Loc 선택시    			
    		ComOpenPopup(url, 800, 420, "callBackPopup", "0,1,1,1,1,1", true, false, Row, Col, 1);	
    	}
    }
	    
    // 돋보기 popup 닫을 때 data setting
    function callBackPopup(aryPopupData, Row, Col, ShtIdx) {	
    	
    	var mainRow = sheetObjects[0].SelectRow;
    	var aloc_ctrl_tp_cd = sheetObjects[1].CellValue(Row, "aloc_ctrl_tp_cd");
    	
		var elac = sheetObjects[1].CellValue( Row , "ctrl_loc_acct_cd" );
		var oc = sheetObjects[1].CellValue( Row , "ofc_cd" );
		
    	for(i=0; i<aryPopupData.length; i++) {	    			    		
    		if(i == 0) { // 팜업에서 1개만 선택시
    			if(aloc_ctrl_tp_cd == "E") { //ECC 선택시
    				sheetObjects[1].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][10];
    			}
    			else if(aloc_ctrl_tp_cd == "G") { //ECC Group 선택시
    				sheetObjects[1].CellValue2(Row, "aloc_ctrl_dtl_cd") = aryPopupData[i][3];//aryPopupData[i][10]; //ECC Group 인경우 Location 입력으로 변경
    			}
    			// 2015.02.12 Location control 막음
//	    			else if(aloc_ctrl_tp_cd == "L") { //Loc 선택시
//	    				sheetObjects[1].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][3];
//	    			}
    			else {
//	    				sheetObjects[1].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][3];
    				if(aryPopupData[i][4].length > 1 ){
    					sheetObjects[1].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][4];
    				}else{
    					sheetObjects[1].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][5];
    				}
    				sheetObjects[1].CellValue2(Row, "aloc_ctrl_dtl_cd") = aryPopupData[i][3];
//	    				sheetObjects[1].CellValue2(Row, "sc_no") = aryPopupData[i][4];
//	    				sheetObjects[1].CellValue2(Row, "rfa_no") = aryPopupData[i][5];
    			}
    			
    		} else { // 팝업에서 2개 이상 선택시
    			
				var detailRow = sheetObjects[1].DataInsert(-1);
				
				sheetObjects[1].CellValue2(detailRow, "trd_cd") = sheetObjects[0].CellValue(mainRow, "trd_cd");
				sheetObjects[1].CellValue2(detailRow, "sub_trd_cd") = sheetObjects[0].CellValue(mainRow, "sub_trd_cd");
				sheetObjects[1].CellValue2(detailRow, "rlane_cd") = sheetObjects[0].CellValue(mainRow, "rlane_cd");
				sheetObjects[1].CellValue2(detailRow, "dir_cd") = sheetObjects[0].CellValue(mainRow, "dir_cd");
				sheetObjects[1].CellValue2(detailRow, "aloc_ctrl_tp_cd") = aloc_ctrl_tp_cd;
				if(aloc_ctrl_tp_cd == "E") { //ECC 선택시
					sheetObjects[1].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][10];	   
				}
				else if(aloc_ctrl_tp_cd == "G") { //ECC Group 선택시
    				sheetObjects[1].CellValue2(detailRow, "aloc_ctrl_tp_cd") = aloc_ctrl_tp_cd;
    				sheetObjects[1].CellValue2(detailRow, "ctrl_loc_acct_cd") = elac;
    				sheetObjects[1].CellValue2(detailRow, "ofc_cd") = oc;
    				sheetObjects[1].CellValue2(detailRow, "aloc_ctrl_dtl_cd") = aryPopupData[i][3];//aryPopupData[i][10]; //ECC Group 인경우 Location 입력으로 변경
    				
    				sheetObjects[1].InitCellProperty ( detailRow , 7 , dtData , daCenter , "ctrl_loc_acct_cd" , "" , dfNone );
    				sheetObjects[1].InitCellProperty ( detailRow , 9 , dtPopup , daCenter , "aloc_ctrl_dtl_cd" , "" , dfNone );
    			}
//					else if(aloc_ctrl_tp_cd == "L") {  //Loc 선택시
//						sheetObjects[1].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][3];	
//					}
				else {
					if(aryPopupData[i][4].length > 1 ){
    					sheetObjects[1].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][4];
    				}else{
    					sheetObjects[1].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][5];
    				}
    				sheetObjects[1].CellValue2(detailRow, "aloc_ctrl_dtl_cd") = aryPopupData[i][3];
    			}
    		}
    	}
    		    	
    }
	    
    function sheet2_OnChange(sheetObj, Row, Col, Value){
    	var sName = sheetObj.ColSaveName(Col);
    	var formObject = document.form;

    	switch(sName){
    	    case "aloc_ctrl_tp_cd":
    	    	sheetObj.CellValue2(Row, "ctrl_loc_acct_cd") = "";
    	    	// ECC Group인 경우는 TEXT 나머지는 popup으로 속성 변경
    	    	if( Value == "G" ) {
    	    		sheetObj.InitCellProperty ( Row , Col + 1 , dtData , daCenter , "ctrl_loc_acct_cd" , "" , dfNone );
    	    		sheetObj.InitCellProperty ( Row , Col + 3 , dtPopup , daCenter , "aloc_ctrl_dtl_cd" , "" , dfNone );
    	    		sheetObj.CellEditable(Row, "aloc_ctrl_dtl_cd") = true;
	    			sheetObj.CellEditable(Row, "ctrl_fx_rt_flg")   = false;
    	    	//Fixed 일때는 ECC/Loc Group/Contract 직접입력	
    	    	}else if( Value == "F" ){
    	    		sheetObj.InitCellProperty ( Row , Col + 1 , dtData , daCenter , "ctrl_loc_acct_cd" , "" , dfNone );
    	    		sheetObj.InitCellProperty ( Row , Col + 3 , dtData , daCenter , "aloc_ctrl_dtl_cd" , "" , dfNone );
    	    		//aloc_ctrl_dtl_cd는 입력 불가 (저장될때 ECC/Loc Group/Contract와 동일하게 저장)
    	    		sheetObj.CellEditable(Row, "aloc_ctrl_dtl_cd") = false;
    	    		//Fixed 일때 Fixed Flag 체크 가능
	    			sheetObj.CellEditable(Row, "ctrl_fx_rt_flg") = true;

 				}else{
    	    		sheetObj.InitCellProperty ( Row , Col + 1 , dtPopup , daCenter , "ctrl_loc_acct_cd" , "" , dfNone );
    	    		sheetObj.InitCellProperty ( Row , Col + 3 , dtData , daCenter , "aloc_ctrl_dtl_cd" , "" , dfNone );
    	    		sheetObj.CellEditable(Row, "aloc_ctrl_dtl_cd") = true;
	    			sheetObj.CellEditable(Row, "ctrl_fx_rt_flg")   = false;
 				}
    	    	break;
    	    	
    	    //입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
    	    case "ctrl_loc_acct_cd":
		    	if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "F" && sheetObj.CellValue(Row, "ctrl_loc_acct_cd") != ""){
    	    		var param = "f_cmd=" + SEARCHLIST07 + "&scNo="+Value;
    	            var sXml = sheetObj.GetSearchXml("ESM_SPC_0052GS.do", param);
    				var ScNoCnt = ComGetEtcData(sXml, "ScNoCnt");
    				if(ScNoCnt == 0){
        				ComShowMessage(getMsg("SPC90306", Value)); //'Contract No (' + msg1 + ') is invalid.'
	    				sheetObj.CellValue(Row, "ctrl_loc_acct_cd") = "";
    				}
    	    	}
    	    	break;
    	}    	
    }
	    
    var selSheet;
    var selRow;
	    
    function sheet4_OnChange(sheetObj, Row, Col, Value) {
    	var sName = sheetObj.ColSaveName(Col);
    	switch(sName){
    	    case "bkg_ctrl_tp_cd":
    	    	if( Value == "S" && ( cust_code == "undefined" || cust_code == "" || cust_code == null ) ) {
    	    		sheetObj.CellValue2( Row, "bkg_ctrl_tp_cd" ) = "O";
    	    		ComShowMessage(getMsg("SPC90304",""));
    	    	} else if( Value == "S" ) { //Row Add 시 By Account 선택은 SMP Group 인경우 안됨.
    	    		sheetObj.InitCellProperty ( Row , Col + 1 , dtCombo , daCenter , "bkg_ctrl_dtl_cd" , "" , dfNone );
    	    		sheetObj.InitDataCombo( 0 ,  "bkg_ctrl_dtl_cd" , cust_code[0] , cust_code[1] );
//        	    		sheetObj.CellEditable(Row, "bkg_ctrl_rto") = true;
    	    		sheetObj.CellEditable(Row, "bkg_ctrl_acct_flg") = true;
    	    		
    	    		var mainRow = sheetObjects[0].SelectRow;
    	    		if(sheetObjects[0].CellValue(mainRow, "bkg_ctrl_lane_flg") == 1){
    	    			sheetObj.CellValue2( Row , "rlane_cd") = sheetObjects[0].CellValue(mainRow, "rlane_cd");
    	    			sheetObj.CellValue2( Row , "dir_cd")   = sheetObjects[0].CellValue(mainRow, "dir_cd");
    	    			sheetObj.CellValue2( Row , "bkg_ctrl_lane_flg") = "Y";
    	    		}else{
    	    			sheetObj.CellValue2( Row , "rlane_cd") = "XXXXX";
    	    			sheetObj.CellValue2( Row , "dir_cd") = "X";
    	    		}

    	    	} else if( Value == "O" ) {
    	    		sheetObj.InitCellProperty ( Row , Col + 1 , dtPopup , daCenter , "bkg_ctrl_dtl_cd" , "" , dfNone );
    	    		sheetObj.CellEditable(Row, "bkg_ctrl_acct_flg") = false;
    	    		sheetObj.CellValue2(Row, "bkg_ctrl_acct_flg") = "0";
    	    		sheetObj.CellValue2(Row, "bkg_ctrl_lane_flg") = "N";
//        	    		sheetObj.CellValue2(Row, "bkg_ctrl_rto") = "";
    	    		
    	    		var mainRow = sheetObjects[0].SelectRow;
	    			sheetObjects[2].CellValue2( Row , "rlane_cd") = sheetObjects[0].CellValue(mainRow, "rlane_cd");
        			sheetObjects[2].CellValue2( Row , "dir_cd") = sheetObjects[0].CellValue(mainRow, "dir_cd");
    	    	}
    	    	break;
    	    	
    	    case "bkg_ctrl_acct_flg":
    	    	if( Value == "1" ) { //checked
    	    		if( sheetObj.CellValue(Row, "bkg_ctrl_tp_cd") =='O'){ //combo가 SMP가 아닌경우 Check 를 풀거나 못하게 함.
    	    			sheetObj.CellValue2(Row, "bkg_ctrl_acct_flg") = "0";
    	    			sheetObj.CellValue2(Row, "bkg_ctrl_lane_flg") = "N";
    	    		}
    	    	}
    	    	break;
    	}
    }
	    
    function sheet4_OnPopupClick(sheetObj, Row, Col) {
    	if(sheetObj.ColSaveName(Col) == "bkg_ctrl_dtl_cd") {

    		var mainRow = sheetObjects[0].SelectRow; 
    		var controlRow = sheetObjects[1].SelectRow;
		   	var param = "f_cmd=" + SEARCHLIST03 + "&trd_cd=" + sheetObjects[0].CellValue(mainRow,"trd_cd") + "&sub_trd_cd=" + sheetObjects[0].CellValue(mainRow,"sub_trd_cd") + "&rlane_cd=" + sheetObjects[0].CellValue(mainRow,"rlane_cd") + "&dir_cd=" + sheetObjects[0].CellValue(mainRow,"dir_cd") + "&aloc_ctrl_tp_cd=" + sheetObjects[1].CellValue( controlRow , "aloc_ctrl_tp_cd")
		   	 + "&ctrl_loc_acct_cd=" + sheetObjects[1].CellValue( controlRow , "ctrl_loc_acct_cd");
		   	
		    selSheet = sheetObj;
		    selRow = Row;
    		if( sheetObj != sheetObjects[1])
    			param += "&sheet=2";
		    url = "ESM_SPC_0119.do?"+param;
    		
    		var chVal = ComOpenPopup(url, 300, 270, "", "0,1,1,1,1,1", true, false, Row, Col, 1);
    		setOfficeValue( chVal );
    		
    	}
    }	    

    function sheet4_OnSearchEnd(sheetObj, ErrMsg){
    	for( var x=1 ; x<=sheetObj.RowCount ; x++ ) {
    		sh3Condition[x] = sheetObj.CellValue( x , "bkg_ctrl_rto" );
    		if( sheetObj.CellValue( x , "bkg_ctrl_tp_cd" ) == "S" ){
    			sheetObj.CellEditable( x , "bkg_ctrl_rto") = true;
    			sheetObj.CellEditable( x , "bkg_ctrl_acct_flg") = true;
    		}
    	}       	
    }
	    
    function setOfficeValue( ofc_cd ) {
    	if( ofc_cd == null )
    		return;
    	
    	var ofc_ary = ofc_cd.split("|");
    	var colNm = "";
    	if( selSheet == sheetObjects[1] ) {
    		var flag = false;
    		if( ofc_cd.substr(0,2) == "A|") {
    			ofc_cd = ofc_cd.substr(2);
    			flag = true;
    		}
    		colNm = "ofc_cd";
    		ofc_cd = ofc_cd.replace( /\|/gi , "," );
    		if( flag ) {
    			var controlNM = selSheet.CellValue( selRow , "aloc_ctrl_tp_cd" );
    			for(var i=selSheet.HeaderRows ; i <= selSheet.LastRow ; i++){
    				if( selSheet.CellValue( i , "aloc_ctrl_tp_cd" ) == controlNM ){
    					selSheet.CellValue( i , colNm ) = ofc_cd;
    				}
    			}
    		} else {
	    		selSheet.ToolTipText(selRow, colNm) = ofc_cd;
	    		selSheet.CellValue2( selRow , colNm ) = ofc_cd;
    		}
    	} else {
    		colNm = "bkg_ctrl_dtl_cd";
    		mkRowNsetValue( selSheet , ofc_ary , selRow , colNm );
    	}
    }
	    
    function mkRowNsetValue( sheetObj, data , row , colNm ) {
    	for( var x=0 ; x<data.length ; x++ ) {
    		if( x == 0 ){
    			selSheet.CellValue2( selRow , colNm ) = data[x];
    		} else {
    			var row = sheetObj.DataInsert(-1);
    			selSheet.CellValue2( row , colNm ) = data[x];
    		}
    	}
    }
    
    
	function checkDupRow(sheetObj){
		sheetObj.SpaceDupCheck = true;
		var cmprCol;
		if( sheetObj == sheetObjects[2] )
			cmprCol = "2|3";		//Alloc Office/Yield Group , Cod
		else
			cmprCol = "6|7|9|10|11";		//Control, ECC, Account , Contractor Name, Account Name
		
		var rtn = sheetObj.ColValueDup(cmprCol, false);
		
		if(rtn!="-1"){
//				ComShowMessage("There are duplicated rows. Please check again.");
			ComShowMessage(getMsg("SPC90135"));
			sheetObj.SelectCell(rtn, "tmp_seq");
			return false;
		}
		return true;
	}
		
	function initComboData() {
		//2번째 시트내 Control 컬럼 code 가져옴
		sheetObjects[1].InitDataCombo(0, "aloc_ctrl_tp_cd", arrCtrlTpComboNm, arrCtrlTpComboCd);
	}
		
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
        		if(sheetObj.CellValue(i, "aloc_ctrl_tp_cd") != "F") {
	    			sheetObj.CellEditable(i, "ctrl_fx_rt_flg") = false;
        	}
        }
    }    	
		
	/* 개발자 작업  끝 */