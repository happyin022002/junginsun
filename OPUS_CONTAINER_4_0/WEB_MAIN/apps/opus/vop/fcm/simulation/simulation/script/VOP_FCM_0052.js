/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0052.js
*@FileTitle : Bunker Consumption Simulation 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.04.15 진마리아
* 1.0 Creation 
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
* 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
* 2014.09.25 Lee Byoung Hoon CHM-201431761 PF SKED simulation 기능과 연동으로 Bunker 소모량 산출 기능
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
	 * @extends
	 * @class VOP_FCM_0052 : VOP_FCM_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    function VOP_FCM_0052() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet3_OnKeyUp         = sheet3_OnKeyUp; 
    }
    
   	/* 개발자 작업 */
 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var portDataFlgs = new Array();		// 그리드의 Port 변경여부(Port 변경 시에만 Terminal
										// 조회하기 위함)
    var ydCdsArr = new Array();
    
    // M/Simulation 와 A/Simulation 상태관리
    // var statusFlag = "";
    var submitFlg = "N";
    
    // Vsl Cls 중복 호출 체크
    var vslClsCheck = "N";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var pfXml;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
         /** **************************************************** */
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				
				case "btn_DownExcel":
					sheetObject2.Down2Excel(true);
					break;	


				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, SEARCH);
					break;

				case "btn_Simulation":
					doActionIBSheet(sheetObject2, formObj, SEARCH02);
					break;

				case "btn_New":
					clearAllData();
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject2, formObj, IBSAVE);
					break;
					
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;	
					
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
					break;
					
				case "btn_SetUp":
					openSetup(sheetObject1);
					break;
				// Add By 2014.09.25 Lee Byoung Hoon
				case "btns_simulation_no":
					var sUrl = "/opuscntr/VOP_VSK_0201.do?uiFlg=A&vsl_slan_cd=";
					ComOpenPopup(sUrl, 800, 470, "getSimData", "0,0", true);
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
	 * Lane Code Help 파일을 오픈한다
	 */
    function openLandCdHelp(sheetObj){
       var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
       var v_display = "0,0";      var laneCd = document.form.vsl_slan_cd.value;
    	ComOpenPopupWithTarget('VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);

    }

    /**
	 * P/F Lane Type Code Help 파일을 오픈한다
	 */
    function openPfLandTypeCdHelp(sheetObj){
    	 var targetObjList = "sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
    	 var v_display = "0,0";
    	 var laneCd = document.form.vsl_slan_cd.value;
    	 ComOpenPopupWithTarget('VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 640, 490, targetObjList, v_display, true);
    }

	function openSetup(sheetObj){
		
		// P/F 정보가 조회 되었을 경우에만 Setup 창 호출
		if(sheetObjects[0].SearchRows>0 && sheetObjects[0].CellValue(1, sheetObjects[0].prefix+"vsl_slan_cd")!=""){
			var v_display = "0,1";//checkbox, 다건row 선택
			ComOpenPopup("VOP_FCM_0053.do", 800, 430, "setTrndLine", v_display, true);
		}else{
			ComShowMessage("Please retrieve first.");
		}
	}
    
    /**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
	 * IBCombo Object를 배열로 등록 param : combo_obj ==> 콤보오브젝트 향후 다른 항목들을 일괄처리할 필요가
	 * 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
	 */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++] = combo_obj;  
    }

    /**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는
	 * 기능을 추가한다
	 */                    
    function loadPage() {
    	var formObj = document.form;
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
    	
    	doActionIBCombo(sheetObjects[0],formObj,SEARCH,comboObjects[0],SEARCH01);
    	
    	initControl();
    	
    	if(sheetObjects[0].RowCount == 0){
    		sheetObjects[0].DataInsert(-1);
    	}
    	initSumSheet();
    	document.form.vsl_slan_cd.focus();

    }

function initSumSheet(){
	/** Sum Sheet 초기화 >>> */
	var sumSheetObj = findSheetObj(sheetObjects, "sheet6");
	sumSheetObj.Redraw = false;
	sumSheetObj.DataInsert(-1);
	sumSheetObj.DataInsert(-1);
	sumSheetObj.DataInsert(-1);
	
	var prefix = sumSheetObj.prefix;
	sumSheetObj.CellValue2(1, prefix+"Sel") = "Sub Total";
	sumSheetObj.CellValue2(1, prefix+"row_seq") = "Sub Total";
	sumSheetObj.CellValue2(1, prefix+"skd_dir_cd") = "Sub Total";
	sumSheetObj.CellValue2(1, prefix+"vps_port_cd") = "Sub Total";
	
	sumSheetObj.CellValue2(2, prefix+"Sel") = "Sub Total";
	sumSheetObj.CellValue2(2, prefix+"row_seq") = "Sub Total";
	sumSheetObj.CellValue2(2, prefix+"skd_dir_cd") = "Sub Total";
	sumSheetObj.CellValue2(2, prefix+"vps_port_cd") = "Sub Total";
	
	sumSheetObj.CellValue2(3, prefix+"Sel") = "Grand Total";
	sumSheetObj.CellValue2(3, prefix+"row_seq") = "Grand Total";
	sumSheetObj.CellValue2(3, prefix+"skd_dir_cd") = "Grand Total";
	sumSheetObj.CellValue2(3, prefix+"vps_port_cd") = "Grand Total";
	
	sumSheetObj.SetMergeCell(1, sumSheetObj.SaveNameCol(prefix+"Sel"), 2, 9);
	sumSheetObj.SetMergeCell(3, sumSheetObj.SaveNameCol(prefix+"Sel"), 1, 11);
	
	sumSheetObj.Redraw = true;
	/** <<< Sum Sheet 초기화 */
}
    
/**
 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form
    switch(comboNo) {  
          case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("50");
				BackColor = "#FFFFFF";
				FontColor = "#000000";
				ColBackColor(0) = "#FFFFFF";
				ColFontColor(0) = "#000000";

 				DropHeight = 160;
 		    	}

 			break;
          case 2: 
              with (comboObj) { 
   				MultiSelect = false; 
   				UseAutoComplete = true;	
   				SetColAlign("left");        
   				SetColWidth("50");
   				BackColor = "#FFFFFF";
   				FontColor = "#000000";
   				ColBackColor(0) = "#FFFFFF";
   				ColFontColor(0) = "#000000";

				DropHeight = 160;
		    	}

    		break;
    	
          case 3: 
              with (comboObj) { 
   				MultiSelect = false; 
   				UseAutoComplete = true;	
   				SetColAlign("left");        
   				SetColWidth("50");
   				BackColor = "#FFFFFF";
   				FontColor = "#000000";
   				ColBackColor(0) = "#FFFFFF";
   				ColFontColor(0) = "#000000";

				DropHeight = 160;
		    	}

    		break;
 	     }
 	}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";
	sheetObj.prefix = prefix;
	sheetObj.classNo = "";
			
    switch(sheetID) {
	    case "sheet1":      // sheet1 init
	    with (sheetObj) {
	
	        // 높이 설정
	        style.height = 0;
	// style.height = 100;
	        // 전체 너비 설정
	        SheetWidth = 0;
	
	        // Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	        // 전체Merge 종류 [선택, Default msNone]
	        MergeSheet = msNone;
	
	       // 전체Edit 허용 여부 [선택, Default false]
	        Editable = false;
	
	        // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        InitRowInfo( 1, 1, 3, 100);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, true, true, false,false)
	
	        var HeadTitle = "STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|CRE_DT|UPD_DT";
	        var headCount = ComCountHeadTitle(HeadTitle);
	        
	        // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(headCount, 0, 0, true);
	
	        // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        InitHeadRow(0, HeadTitle, true);
	        
	        // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
	        InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter, 	false, 		prefix+"ibflag");
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"vsl_slan_cd",    		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"pf_svc_tp_cd",    		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"slan_stnd_flg",    		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"svc_dur_dys",    		false,          "",      dfNone);
	        
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"stnd_svc_spd",    		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"brth_itval_dys",   false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"mml_usd_flg",  		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_dt",     	false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"bnk_csm_sim_no",     	false,          "",      dfNone);
	        
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_cd",    		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_knt",   false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n2nd_vsl_clss_cd",  		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n2nd_vsl_clss_knt",     	false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n3rd_vsl_clss_cd",     	false,          "",      dfNone);

	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n3rd_vsl_clss_knt",    		false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"clpt_knt",   false,          "",      dfNone);
	        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"ttl_dist",  		false,          "",      dfNone);
	    
	        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"delt_flg",     	false,          "",      dfNone);

	        
	        WaitImageVisible = false;
	        // CountPosition = 0;
	        // SelectionMode = smSelectionList; //추가
	   }
	    
	    break;
	    	   
        case "sheet2":      // sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = GetSheetHeight(15);
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                var HeadTitle1 = "||Sel.|No.|DIR|Port\nCode|TMNL\nCode|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|Manv.|Manv.|Port\nTime|Port\nBUF";
                var HeadTitle2 = "||Sel.|No.|DIR|Port\nCode|TMNL\nCode|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF";
                var HeadTitle3 = "|||No.|DIR|Port\nCode|TMNL\nCode|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF";
                
                HeadTitle1 = HeadTitle1 + "|Design Capa.|Design Capa.|Design Capa.|Design Capa.|Design Capa.|Design Capa.";
                HeadTitle2 = HeadTitle2 + "||||||";
                HeadTitle3 = HeadTitle3 + "|TTL\nFOC(S)|TTL\nFOC(B)|TTL\nFOC(S)|TTL\nFOC(B)|TTL\nFOC(S)|TTL\nFOC(B)";
                
				var headCount = ComCountHeadTitle(HeadTitle1);

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(3, 1, 10, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, false, false, false);

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                InitHeadRow(2, HeadTitle3, true);
                
// var prefix = "sheet2_";
                // 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 35, 	daCenter, 	false, 	prefix+"ibflag");
                InitDataProperty(0, cnt++ , dtHidden, 35, 	daCenter, 	false, 	prefix+"clpt_seq");
				InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,	prefix+"Sel");
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"row_seq",           false,	"",			dfNone,		0,		true,		false,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"skd_dir_cd",		false,		"",		dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,      true,      true);			
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNone,		0, 		true,		true,		1,			false,		false );
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfNullFloat,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    40,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfNullFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				// class1 ttl foc
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt1",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt1",	false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				// class2 ttl foc
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt2",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt2",	false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				// class3 ttl foc
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt3",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt3",	false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				

				CountPosition = 0;
				SetSortDialog(false);		
				// SheetOutLineColor = RgbColor(0,0,0);
				RowHeight(0) = DataRowHeight;
				RowHeight(1) = DataRowHeight;
				RowHeight(2) = DataRowHeight;
				ToolTipOption="balloon:true;width:320";
				
				ExtendLastCol = false;
				SelectHighLight = false;
				WaitImageVisible = false;
				ScrollBar = 2;
				
			}
			break;				
           	   
			
        case "sheet6":      // sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = GetSheetHeight(3);
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                
                var HeadTitle = " | | | | | | | | | | | | | | | | | | | | | | | | | | | ";
				var headCount = ComCountHeadTitle(HeadTitle);

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 1, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, false, false, false);

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true, true);
                
// var prefix = "sheet2_";
                // 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 35, 	daCenter, 	false, 	prefix+"ibflag");
                InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"clpt_seq");
				InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,	prefix+"Sel");
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"row_seq",           false,	"",		dfNone,		0,		true,		false,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",		dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"port_cd",			false,	"",		dfEngUpKey,	0, 		true,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	true,	prefix+"yd_cd",				false,	"",		dfNone,		0,      true,      true);			
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etb_dy_no",			false,	"",		dfNone,		0, 		true,		true,		1,			false,		false );
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",		dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",		dfTimeHm,	0);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etd_dy_no",			false,	"",		dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",		dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etd_tm_hrmnt",		false,	"",		dfTimeHm,	0);
				
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix+"lnk_dist",			false,	"",		dfNullFloat,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    40,		daRight,	true,	prefix+"lnk_spd",			false,	"",		dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"tztm_hrs",			false,	"",		dfNullFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",		dfNullFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",		dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",		dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",		dfNullFloat,		1,      true,		true,		3,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",		dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",		dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				// class1 ttl foc
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt1",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt1",	false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				// class2 ttl foc
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt2",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt2",	false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				
				// class3 ttl foc
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt3",		false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			52,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt3",	false,	"",			dfNullFloat,		1,      true,		true,		3,			false,		false);
				

				CountPosition = 0;
				SetSortDialog(false);		
				// SheetOutLineColor = RgbColor(0,0,0);
				ToolTipOption="balloon:true;width:320";
				
				ExtendLastCol = false;
				SelectHighLight = false;
				WaitImageVisible = false;
				
			}
			break;
			
        case "sheet3":      // sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 0;

                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
             // 해더 높이 설정
    			sheetObj.HeadRowHeight = 12;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                var HeadTitle1 = "|||||||||||||||||||";
                var HeadTitle2 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Speed|Speed|Speed|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|TTL\nFOC|Buffer\nSpeed|FOC(M/T/Day)|FOC(M/T/Day)|TTL\nFOC";
                var HeadTitle3 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Speed|Speed|Speed|M/E&BLR|M/E&BLR|M/E&BLR|G/E|TTL\nFOC|Buffer\nSpeed|M&B|G/E|TTL\nFOC";
                var HeadTitle4 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Max|Min|G/E|Sea|MANU|Port|G/E|TTL\nFOC|Buffer\nSpeed|Sea|G/E|TTL\nFOC";
				var headCount = ComCountHeadTitle(HeadTitle1);

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(4, 1, 10, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);		
                InitHeadRow(1, HeadTitle2, true);		
                InitHeadRow(2, HeadTitle3, true);	
                InitHeadRow(3, HeadTitle4, true);

                // var prefix = "sheet3_";
                // 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
                InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"clpt_seq");
                InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"vsl_clss_cd");
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"row_seq",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"skd_dir_cd",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"port_cd",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
                InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"yd_cd",           			false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
                InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_sea_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
                InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_max_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_min_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_gnr_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_sea_foil_csm_wgt",      false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_mnvr_foil_csm_wgt",     false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_port_foil_csm_wgt",     false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_gnr_port_foil_csm_wgt", false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt",      false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_sea_spd",           false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_sea_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_gnr_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
				
				InitDataValid(0,    prefix+"sim_max_spd",   vtNumericOther,".");
				InitDataValid(0,    prefix+"sim_min_spd",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_gnr_spd",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_sea_spd",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_sea_foil_csm_wgt",   vtNumericOther,".");
				
				InitDataValid(0,    prefix+"sim_mnvr_foil_csm_wgt",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_port_foil_csm_wgt",   vtNumericOther,".");
				InitDataValid(0,    prefix+"sim_gnr_port_foil_csm_wgt",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_ttl_foil_csm_wgt",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_buf_sea_spd",   vtNumericOther,".");
				
				InitDataValid(0,    prefix+"sim_buf_sea_foil_csm_wgt",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_buf_gnr_foil_csm_wgt",   vtNumericOther,".");	
				InitDataValid(0,    prefix+"sim_buf_ttl_foil_csm_wgt",   vtNumericOther,".");
				
				CountPosition = 0;
				SetSortDialog(false);		
				// SheetOutLineColor = RgbColor(0,0,0);
				RowHeight(0) = 10;
				RowHeight(1) = 10;
				RowHeight(2) = 10;
				ToolTipOption="balloon:true;width:320";
				
				SelectHighLight = false;
				WaitImageVisible = false;
				ScrollBar = 2;
										
				classNo = 1;
			}
            break;
            
        case "sheet4":      // sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 0;
            
            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;
         // 해더 높이 설정
			sheetObj.HeadRowHeight = 12;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            
            var HeadTitle1 = "|||||||||||||||||||";
            var HeadTitle2 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Speed|Speed|Speed|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|TTL\nFOC|Buffer\nSpeed|FOC(M/T/Day)|FOC(M/T/Day)|TTL\nFOC";
            var HeadTitle3 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Speed|Speed|Speed|M/E&BLR|M/E&BLR|M/E&BLR|G/E|TTL\nFOC|Buffer\nSpeed|M&B|G/E|TTL\nFOC";
            var HeadTitle4 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Max|Min|G/E|Sea|MANU|Port|G/E|TTL\nFOC|Buffer\nSpeed|Sea|G/E|TTL\nFOC";
			var headCount = ComCountHeadTitle(HeadTitle1);

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(4, 1, 10, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, true, true, false, false);

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);		
            InitHeadRow(1, HeadTitle2, true);		
            InitHeadRow(2, HeadTitle3, true);	
            InitHeadRow(3, HeadTitle4, true);
            
            // var prefix = "sheet4_";
            // 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
            InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"clpt_seq");
            InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"vsl_clss_cd");
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"row_seq",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"skd_dir_cd",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"port_cd",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"yd_cd",           			false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_sea_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_max_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_min_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_gnr_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_sea_foil_csm_wgt",      false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_mnvr_foil_csm_wgt",     false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_port_foil_csm_wgt",     false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_gnr_port_foil_csm_wgt", false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt",      false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_sea_spd",           false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_sea_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_gnr_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			
			InitDataValid(0,    prefix+"sim_max_spd",   vtNumericOther,".");
			InitDataValid(0,    prefix+"sim_min_spd",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_gnr_spd",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_sea_spd",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_sea_foil_csm_wgt",   vtNumericOther,".");
			
			InitDataValid(0,    prefix+"sim_mnvr_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_port_foil_csm_wgt",   vtNumericOther,".");
			InitDataValid(0,    prefix+"sim_gnr_port_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_ttl_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_buf_sea_spd",   vtNumericOther,".");
			
			InitDataValid(0,    prefix+"sim_buf_sea_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_buf_gnr_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_buf_ttl_foil_csm_wgt",   vtNumericOther,".");

			CountPosition = 0;
			SetSortDialog(false);		
			// SheetOutLineColor = RgbColor(0,0,0);
			RowHeight(0) = 10;
			RowHeight(1) = 10;
			RowHeight(2) = 10;
			ToolTipOption="balloon:true;width:320";
			
			SelectHighLight = false;
			WaitImageVisible = false;
			ScrollBar = 2;
			
			classNo = 2;
									
           }
            break;
        case "sheet5":      // sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 0;
            
            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;
         // 해더 높이 설정
			sheetObj.HeadRowHeight = 12;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            
            var HeadTitle1 = "|||||||||||||||||||";
            var HeadTitle2 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Speed|Speed|Speed|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|Daily Consumption(MT/Day)|TTL\nFOC|Buffer\nSpeed|FOC(M/T/Day)|FOC(M/T/Day)|TTL\nFOC";
            var HeadTitle3 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Speed|Speed|Speed|M/E&BLR|M/E&BLR|M/E&BLR|G/E|TTL\nFOC|Buffer\nSpeed|M&B|G/E|TTL\nFOC";
            var HeadTitle4 = "|||No.|DIR|Port\nCD|TMNL|Sea\nSpeed|Max|Min|G/E|Sea|MANU|Port|G/E|TTL\nFOC|Buffer\nSpeed|Sea|G/E|TTL\nFOC";
			var headCount = ComCountHeadTitle(HeadTitle1);

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(4, 1, 10, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, true, true, false, false);

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);		
            InitHeadRow(1, HeadTitle2, true);		
            InitHeadRow(2, HeadTitle3, true);	
            InitHeadRow(3, HeadTitle4, true);
            
            // var prefix = "sheet5_";
            // 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
            InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"clpt_seq");
            InitDataProperty(0, cnt++ , dtHidden, 		35, 	daCenter, 	false, 	prefix+"vsl_clss_cd");
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"row_seq",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"skd_dir_cd",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"port_cd",           		false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"yd_cd",           			false,	"",			dfNone,		0,		false,		false,		6,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_sea_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
            InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_max_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_min_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_gnr_spd",           	false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_sea_foil_csm_wgt",      false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_mnvr_foil_csm_wgt",     false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_port_foil_csm_wgt",     false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_gnr_port_foil_csm_wgt", false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_ttl_foil_csm_wgt",      false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_sea_spd",           false,	"",			dfNone,		1,		false,		false,		8,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_sea_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_gnr_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sim_buf_ttl_foil_csm_wgt",  false,	"",			dfNone,		1,		false,		false,		13,			false,		false);
			
			InitDataValid(0,    prefix+"sim_max_spd",   vtNumericOther,".");
			InitDataValid(0,    prefix+"sim_min_spd",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_gnr_spd",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_sea_spd",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_sea_foil_csm_wgt",   vtNumericOther,".");
			
			InitDataValid(0,    prefix+"sim_mnvr_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_port_foil_csm_wgt",   vtNumericOther,".");
			InitDataValid(0,    prefix+"sim_gnr_port_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_ttl_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_buf_sea_spd",   vtNumericOther,".");
			
			InitDataValid(0,    prefix+"sim_buf_sea_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_buf_gnr_foil_csm_wgt",   vtNumericOther,".");	
			InitDataValid(0,    prefix+"sim_buf_ttl_foil_csm_wgt",   vtNumericOther,".");

			CountPosition = 0;
			SetSortDialog(false);		
			// SheetOutLineColor = RgbColor(0,0,0);
			RowHeight(0) = 10;
			RowHeight(1) = 10;
			RowHeight(2) = 10;
			ToolTipOption="balloon:true;width:320";
			
			SelectHighLight = false;
			WaitImageVisible = false;
			ScrollBar = 2;
			
			classNo = 3;
									
           }
            break;
            
		case "sheet7":      // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 200;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, false, false, false)

				var HeadTitle = "|Design Capacity|Design Capacity|Fuel Consumption Trend Line|Fuel Consumption Trend Line|trnd_line_seq|n1st_coef_val|n2nd_coef_val|trnd_line_cons_val|sim_min_spd|sim_max_spd|sim_gnr_spd|sim_mnvr_foil_csm_wgt|sim_gnr_port_foil_csm_wgt|avg_gnr_csm_wgt|avg_blr_csm_wgt";
				var HeadTitle2 = "|Class|Lane|Type No.|Remark|trnd_line_seq|n1st_coef_val|n2nd_coef_val|trnd_line_cons_val|sim_min_spd|sim_max_spd|sim_gnr_spd|sim_mnvr_foil_csm_wgt|sim_gnr_port_foil_csm_wgt|avg_gnr_csm_wgt|avg_blr_csm_wgt";
				var headCount = ComCountHeadTitle(HeadTitle);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle2, false);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0,	daCenter, false, prefix+"ibflag");
				InitDataProperty(0, cnt++, dtData,		   100,	daCenter, true,  prefix+"cntr_dzn_capa",    false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,         120, daCenter, false, prefix+"vsl_slan_cd",      false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup,        150, daCenter, false, prefix+"trnd_line_no", false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, false, prefix+"trnd_line_rmk",    false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"trnd_line_seq",    false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"n1st_coef_val",    false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"n2nd_coef_val",    false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"trnd_line_cons_val",         false, "", dfNone, 0, true,  true);
				
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"sim_min_spd",               false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"sim_max_spd",               false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"sim_gnr_spd",               false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"sim_mnvr_foil_csm_wgt",     false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"sim_gnr_port_foil_csm_wgt", false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"avg_gnr_csm_wgt",           false, "", dfNone, 0, true,  true);
				InitDataProperty(0, cnt++, dtData,       100, daCenter, false, prefix+"avg_blr_csm_wgt",           false, "", dfNone, 0, true,  true);
				
				
				
				// CountFormat = "[SELECTDATAROW / TOTALROWS]";

				FocusAfterProcess = false;
				CountPosition = 0;
				WaitImageVisible = false;
			}
			break;
                
        }
    }

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(",");
		comboObj.InsertItem(i, comboItem,comboItem);
	}   		
}

//Add By 2014.09.25 Lee Byoung Hoon
function combo1_OnChange(comboObj, comboText, comboValue){
	var formObj = document.form

	if(comboValue == ""){
		formObj.n1st_vsl_clss_knt.value = "";
		sheetObjects[0].CellValue(1, "sheet1_n1st_vsl_clss_knt") = "";
	} else{
		formObj.n1st_vsl_clss_knt.value = "0";
		sheetObjects[0].CellValue(1, "sheet1_n1st_vsl_clss_knt") = "0";
	}
}

function combo2_OnChange(comboObj, comboText, comboValue){
	var formObj = document.form

	if(comboValue == ""){
		formObj.n2nd_vsl_clss_knt.value = "";
		// Add By 2014.09.25 Lee Byoung Hoon
		sheetObjects[0].CellValue(1, "sheet1_n2nd_vsl_clss_knt") = "";
	} else{
		formObj.n2nd_vsl_clss_knt.value = "0";
		// Add By 2014.09.25 Lee Byoung Hoon
		sheetObjects[0].CellValue(1, "sheet1_n2nd_vsl_clss_knt") = "0";
	}
}

function combo3_OnChange(comboObj, comboText, comboValue){
	var formObj = document.form

	if(comboValue == ""){
		formObj.n3rd_vsl_clss_knt.value = "";
		// Add By 2014.09.25 Lee Byoung Hoon
		sheetObjects[0].CellValue(1, "sheet1_n3rd_vsl_clss_knt") = "";
	} else {
		formObj.n3rd_vsl_clss_knt.value = "0";	
		// Add By 2014.09.25 Lee Byoung Hoon
		sheetObjects[0].CellValue(1, "sheet1_n3rd_vsl_clss_knt") = "0";
	} 
}
 
function combo1_OnBlur(comboObj){
	var val = comboObjects[0].Text;
	var cnt = comboObjects[0].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[0].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[0].Text = "";
	// Add By 2014.09.25 Lee Byoung Hoon
	} else {
		sheetObjects[0].CellValue(1, "sheet1_n1st_vsl_clss_cd") = comboObjects[0].Code;
	}
}

function combo2_OnBlur(comboObj){
	var val = comboObjects[1].Text;
	var cnt = comboObjects[1].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[1].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[1].Text = "";
	// Add By 2014.09.25 Lee Byoung Hoon
	} else {
		sheetObjects[0].CellValue(1, "sheet1_n2nd_vsl_clss_cd") = comboObjects[1].Code;
	}
}

function combo3_OnBlur(comboObj){
	var val = comboObjects[2].Text;
	var cnt = comboObjects[2].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[2].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[2].Text = "";
	// Add By 2014.09.25 Lee Byoung Hoon
	} else {
		sheetObjects[0].CellValue(1, "sheet1_n3rd_vsl_clss_cd") = comboObjects[2].Code;
	}
}

/**
 * 이벤트 컨드롤 정의
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm	('focus', 		'obj_focus', 	formObj);
	axon_event.addListenerFormat('keypress', 	'obj_keypress', form);
	axon_event.addListenerForm	('keyup', 		'obj_keyup' , 	form);
	axon_event.addListenerForm	('change', 		'obj_change' , 	form);	
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * KEY PRESS 이벤트
 */
function obj_keypress() {
    switch(event.srcElement.dataformat){
        case "float":
            // 숫자+"."입력하기
            ComKeyOnlyNumber(event.srcElement, ".");
            break;
        case "eng":
            // 영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
            ComKeyOnlyAlphabet();
            break;
        case "engdn":
            // 영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
            ComKeyOnlyAlphabet('lower');
            break;
        case "engup":
            // 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        case "uppernum":
            // 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
            break;    
        // Add By 2014.09.25 Lee Byoung Hoon
        case "hyphennum":
            // 숫자+"-"입력하기
            ComKeyOnlyNumber(event.srcElement, "-");
            break;
        default:
            // 숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
}

/**
 * 필드 데이타가 CHANGE될 경우 이벤트
 */
function obj_keyup(){
	
	var formObj = document.form;
    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
    var sheetObject1 = sheetObjects[0];
    var prefix1 = "sheet1_";
    /** **************************************************** */
    
    if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
    
	try {
		var eleObj = window.event.srcElement;
		var srcName = eleObj.getAttribute("name");

		switch(srcName) {
        	case "vsl_slan_cd":
				if(eleObj.value.length == 3){
					formObj.pf_svc_tp_cd.focus();					
				}
				break;
        	
        	case "pf_svc_tp_cd":
				if(eleObj.value.length == 4){
					if(comboObjects[0].disabled == false){
						comboObjects[0].focus();
					}
					sheetObjects[0].CellValue(1,prefix1+"pf_svc_tp_cd") = eleObj.value;
				}
				break;  	
        	case "n1st_vsl_clss_cd":
        		var cnt = formObj.n1st_vsl_clss_cd.value.length;
        		
        		if(cnt == 5){
        			formObj.n1st_vsl_clss_knt.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n1st_vsl_clss_cd") = comboObjects[0].Code;
        		break;
        	
        	case "n1st_vsl_clss_knt":
        		var cnt = formObj.n1st_vsl_clss_knt.value.length;
        		
        		if(cnt == 2){
        			comboObjects[1].focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
        		break;
        	
        	case "n2nd_vsl_clss_cd":
        		var cnt = formObj.n2nd_vsl_clss_cd.value.length;
        		
        		if(cnt == 5){
        			formObj.n2nd_vsl_clss_knt.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n2nd_vsl_clss_cd") = comboObjects[1].Code;
        		break;
        	
        	case "n2nd_vsl_clss_knt":
        		var cnt = formObj.n2nd_vsl_clss_knt.value.length;
        		
        		if(cnt == 2){
        			comboObjects[2].focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n2nd_vsl_clss_knt") = formObj.n2nd_vsl_clss_knt.value;
        		break;
        	
        	case "n3rd_vsl_clss_cd":
        		var cnt = formObj.n3rd_vsl_clss_cd.value.length;
        		
        		if(cnt == 5){
        			formObj.n3rd_vsl_clss_knt.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n3rd_vsl_clss_cd") = comboObjects[2].Code;
        		break;
        	
        	case "n3rd_vsl_clss_knt":
        		var cnt = formObj.n3rd_vsl_clss_knt.value.length;
        		
        		if(cnt == 2){
        			formObj.svc_dur_dys.focus();
        		}
        		sheetObject1.CellValue(1,prefix1+"n3rd_vsl_clss_knt") = formObj.n3rd_vsl_clss_knt.value;
        		break;
        	
        	case "svc_dur_dys":
        		var cnt = formObj.svc_dur_dys.value.length;
        		sheetObject1.CellValue(1,prefix1+"svc_dur_dys") = formObj.svc_dur_dys.value;
        		break;
        	
        	case "slan_stnd_flg":
        		sheetObject1.CellValue(1,prefix1+"slan_stnd_flg") = formObj.slan_stnd_flg.value;
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

function obj_change(){
	var formObj = document.form;
    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
    var sheetObject1 = sheetObjects[0];
    var prefix1 = "sheet1_";
    /** **************************************************** */
    
    if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
    
	try {
		var eleObj = window.event.srcElement;
		var srcName = eleObj.getAttribute("name");

		switch(srcName) {
        	case "vsl_slan_cd":
        		clearDescData(sheetObjects[0],sheetObjects[1],formObj);
				if(eleObj.value.length == 3){
					var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
					
					var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
		  		  	var dirCds = ComGetEtcData(sXml, "checkDirCd");
		  		  	sheetObjects[1].InitDataCombo(0, "sheet2_skd_dir_cd", dirCds,dirCds);

					if(vslSlanNm == ""){
						ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
						formObj.vsl_slan_cd.focus();
						formObj.vsl_slan_cd.value = "";
						formObj.pf_svc_tp_cd.value = "";
					}else{
						formObj.pf_svc_tp_cd.focus();
						formObj.pf_svc_tp_cd.value = "";
					}
					sheetObjects[0].CellValue2(1,prefix1+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
				}
				break;
        	
        	case "pf_svc_tp_cd":
// clearDescData(sheetObjects[0],sheetObjects[1],formObj);
        		break;
        	// Add By 2014.09.25 Lee Byoung Hoon
        	case "bnk_csm_sim_no":
        		var simTemp = formObj.bnk_csm_sim_no.value;
        		simTemp = ComReplaceStr(simTemp,"-","");
        		
        		if (simTemp.length == 11) {
        			formObj.bnk_csm_sim_no.value = simTemp.substring(0,4) + "-" + simTemp.substring(4,6) + "-" + simTemp.substring(6,8) + "-" + simTemp.substring(8,11);
        			formObj.sim_dt.value = simTemp.substring(0,8);
        			formObj.sim_no.value = Number(simTemp.substring(8,11));
        		} else {
        			formObj.sim_dt.value = "";
        			formObj.sim_no.value = "";
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    
	var classSheet1 = null;
	var classSheet2 = null;
	var classSheet3 = null;
	
	for(var i=0; i<sheetObjects.length; i++){
		if(sheetObjects[i].id=="sheet3"){
			classSheet1 = sheetObjects[i];
		}else if(sheetObjects[i].id=="sheet4"){
			classSheet2 = sheetObjects[i];
		}else if(sheetObjects[i].id=="sheet5"){
			classSheet3 = sheetObjects[i];
		}
	}
	
    switch(sAction) {
		case SEARCH:      // 조회
			
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				
//				formObj.check_vsl_skd.value = "N" ;	// P/F SKD를 Vessel SKD에서
//													// 사용 여부를 "N"으로 초기화 한다.
		
				formObj.f_cmd.value = SEARCH;
				// Modify By 2014.09.25 Lee Byoung Hoon
				var	parm = "f_cmd=" +formObj.f_cmd.value+
						"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
						"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value+
						"&sim_dt=" +formObj.sim_dt.value+
						"&sim_no=" +formObj.sim_no.value;
				
				var aryPrefix = new Array("sheet1_", "sheet2_");	// prefix

		        var sXml = sheetObj.GetSearchXml("VOP_FCM_0052GS.do", parm + "&" + ComGetPrefixParam(aryPrefix));

		        ComOpenWait(false);
		        var arrXml = sXml.split("|$$|");

				submitFlg = "Y";

				// 조회 결과가 존재하지 않을 경우 모든 데이터 초기화 - Add By 2014.09.25 Lee Byoung Hoon
				if (arrXml.length == 1) {
					clearAllData();
					sheetObjects[1].LoadSearchXml(arrXml[0]);
					
				} else {
					for(var inx=0; inx<arrXml.length; inx++){
						showSheetData(sheetObjects[inx],formObj,arrXml[inx], "N");
					}
				}

				if(arrXml.length == 2){
					pfXml = arrXml[1];
				}
				
				var lastPos = sheetObjects[1].RowCount+sheetObjects[1].HeaderRows;
				setlastLowView(sheetObjects[1],lastPos);
				
				formObj.vsl_slan_cd.className = "input2";
				formObj.pf_svc_tp_cd.className = "input2";
				formObj.vsl_slan_cd.readOnly = true;
				formObj.pf_svc_tp_cd.readOnly = true;

			}
			
		break;

		case IBSAVE:        // 저장
			var prefix = sheetObj.id + "_";
			var headCnt = sheetObj.HeaderRows;
			var totCnt = sheetObj.LastRow;
			 if( document.form.flag.value == "I"){
			  for(var i=3;i<classSheet1.RowCount;i++){	  
				  classSheet1.CellValue(i+1,"sheet3_ibflag") = "I" 
			  }
			  for(var i=3;i<classSheet2.RowCount;i++){	  
				  classSheet2.CellValue(i+1,"sheet4_ibflag") = "I" 
			  }
			  for(var i=3;i<classSheet3.RowCount;i++){	  
				  classSheet3.CellValue(i+1,"sheet5_ibflag") = "I" 
			  }
             }  

			// if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
	     	   	var SaveStr = ComGetSaveString(sheetObjects);

	     	   	var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");		
	     	   	var sXml = sheetObj.GetSaveXml("VOP_FCM_0052GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	   	ComOpenWait(false);
	     	    var simNo = ComGetEtcData(sXml, "simNo").split("|");
				document.form.bnk_csm_sim_no.value =simNo;	
	     		doActionIBSheet(sheetObjects[0], formObj, SEARCH);
				
	     	    sheetObjects[1].CheckAll("sheet2_Sel") = 0;
		// }
		
		break;
		
		case SEARCH01:
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("VOP_FCM_0052GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				return sXml;
			}
			
			break;
	
		case SEARCH02: // Simulation
			if(validateForm(sheetObj,formObj,sAction)){
				
//				if(arrXml.length == 2  && sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_cd") != undefined){	
//					document.form.flag.value="I"
//					showSheetData(classSheet1,formObj,arrXml[1], "Y"); 
//					ChangeValue(classSheet1,sheetObjects[1],"sheet3_",sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_cd"))
//				}
//				if(arrXml.length == 2  && sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_cd") != undefined){
//					document.form.flag.value="I"
//					showSheetData(classSheet2,formObj,arrXml[1], "Y");
//					ChangeValue(classSheet2,sheetObjects[1],"sheet4_",sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_cd"))
//				}
//				if(arrXml.length == 2  && sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_cd") != ""){
//					document.form.flag.value="I"  
//					showSheetData(classSheet3,formObj,arrXml[1], "Y");
//					ChangeValue(classSheet3,sheetObjects[1],"sheet5_",sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_cd"))
//				}
//
	
				ComOpenWait(true);
				
				if(sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_cd")){
					showSheetData(classSheet1,formObj, pfXml, "Y");
					ChangeValue(classSheet1,sheetObjects[1],"sheet3_",sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_cd"));
				}
				if(sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_cd")){
					showSheetData(classSheet2,formObj, pfXml, "Y");
					ChangeValue(classSheet2,sheetObjects[1],"sheet4_",sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_cd"));
				}
				if(sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_cd")){
					showSheetData(classSheet3,formObj, pfXml, "Y");
					ChangeValue(classSheet3,sheetObjects[1],"sheet5_",sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_cd"));
				}
				
				var objs = document.all.item("SheetLayer");
				if(classSheet1.RowCount > 0){
					classSheet1.style.height = classSheet1.GetSheetHeight(20);
//					objs[0].style.display = "Inline";
				}
				if(classSheet2.RowCount > 0){
					classSheet2.style.height = classSheet2.GetSheetHeight(20);
//					objs[1].style.display = "Inline";
				}
				if(classSheet3.RowCount > 0){
					classSheet3.style.height = classSheet3.GetSheetHeight(20);
//					objs[2].style.display = "Inline";
				}

				parent.syncHeight();
				
				ComOpenWait(false);
				
			}
			break;
	}	
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction) {

    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

       case SEARCH:      // 조회

			if (sheetObj.id == "sheet1") {				
				// 콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH01;
				// var sXml =
				// sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202",
				// FormQueryString(formObj));
				
				var param = "f_cmd=" + SEARCH01;
				var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", param);
// var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				var comboItems = ComGetEtcData(sXml, "vslCls").split("|");
				
				addComboItem(comboObjects[0],comboItems);
				addComboItem(comboObjects[1],comboItems);	
				addComboItem(comboObjects[2],comboItems);	
				
				comboObjects[1].InsertItem(0, '', '');
				comboObjects[2].InsertItem(0, '', ''); 

			};
														
            break;
    }
}

/**
 * 조회 후 처리로직.
 * 
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml,Pos){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
	
	case "sheet1":
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(sXml);
		var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
		if(dataNode){
			var totValue = dataNode.value;

			sheetObj.LoadSearchXml(sXml);
			if(totValue > 0){
				if(Pos != "Y"){
					formObj.vsl_slan_cd.value = sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					formObj.pf_svc_tp_cd.value = sheetObj.CellValue(1,prefix+"pf_svc_tp_cd");
				}
				// formObj.n1st_vsl_clss_cd.value =
				// sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
				setValCls(comboObjects[0],sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd"));
				formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
				// formObj.n2nd_vsl_clss_cd.value =
				// sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");

				setValCls(comboObjects[1],sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd"));
				formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
				// formObj.n3rd_vsl_clss_cd.value =
				// sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
				setValCls(comboObjects[2],sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd"));
				formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
				formObj.svc_dur_dys.value = sheetObj.CellValue(1,prefix+"svc_dur_dys");
				formObj.brth_itval_dys.value = sheetObj.CellValue(1,prefix+"brth_itval_dys");
				var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
				if(ydCds != null && ydCds != undefined && ydCds != ""){
					for(var i=0 ; i < ydCds.length ; i++ ){
						ydCdsArr[i] = ydCds[i];
					}
				}
				if (formObj.n2nd_vsl_clss_knt.value == "0"){formObj.n2nd_vsl_clss_knt.value = ""};
				if (formObj.n3rd_vsl_clss_knt.value == "0"){formObj.n3rd_vsl_clss_knt.value = ""};
				// ![CDATA[23.4|22.7|17.7|2.9|3.6|0|2266.4|1946.5|1]]
				var etcdts = ComGetEtcData(sXml, "etcdt").split("|");
				// 조회한 Lane Cd와 P/F TYPE CD가 Feeder 인지 Trunker인지
				formObj.vsl_svc_tp_cd.value = etcdts[9];
				// 조회한 Lane Cd와 P/F TYPE CD가 VSL SKD에 등록이 되어 있는지
				formObj.check_vsl_skd.value = etcdts[10];
				if(Pos == "Y"){
					formObj.currPos.value = ComGetEtcData(sXml, "currPos");
				}	
				

			}
		}
	break;
	
		case "sheet2":
			sheetObj.Redraw = false;
			sheetObj.Editable = true;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			if(sheetObj.RowCount > 0){
				sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				
				// VSL SKD에 등록이 되어 있는 Profoma Schedule일 경우
				if(formObj.check_vsl_skd.value == "Y"){
					// 해당 Lane Cd가 Feeder 일 경우는 Editable 가능
					if(formObj.vsl_svc_tp_cd.value == "O"){
						sheetObj.Editable = true;
						
						formObj.brth_itval_dys.disabled 	= false;
						comboObjects[0].Enable = true;
						formObj.n1st_vsl_clss_knt.disabled 	= false;
						comboObjects[1].Enable = true;
						formObj.n2nd_vsl_clss_knt.disabled 	= false;
						comboObjects[2].Enable = true;
						formObj.n3rd_vsl_clss_knt.disabled 	= false;
						formObj.svc_dur_dys.disabled 		= false;
						
					// 해당 Lane Cd가 Trunk 일 경우는 Editable 불가능
					}else{
						sheetObj.Editable 					= false;						
						formObj.brth_itval_dys.disabled 	= true;
						comboObjects[0].Enable 				= false;
						formObj.n1st_vsl_clss_knt.disabled 	= true;
						comboObjects[1].Enable 				= false;
						formObj.n2nd_vsl_clss_knt.disabled 	= true;
						comboObjects[2].Enable 				= false;
						formObj.n3rd_vsl_clss_knt.disabled 	= true;
						formObj.svc_dur_dys.disabled 		= true;
						
					}
				// VSL SKD에 등록이 되어 있는 Profoma Schedule이 아닌 경우 Editable 가능
				}else{
					sheetObj.Editable = true;
					
					formObj.brth_itval_dys.disabled 	= false;
					comboObjects[0].Enable 				= true;
					formObj.n1st_vsl_clss_knt.disabled 	= false;
					comboObjects[1].Enable 				= true;
					formObj.n2nd_vsl_clss_knt.disabled 	= false;
					comboObjects[2].Enable 				= true;
					formObj.n3rd_vsl_clss_knt.disabled 	= false;
					formObj.svc_dur_dys.disabled 		= false;
				}
				
				var lastPos 	= sheetObjects[1].RowCount+sheetObjects[1].HeaderRows - 1;
				var whiteColor	= sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
				var grayColor	= sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
				
				sheetObj.CellEditable(3, prefix+"mnvr_in_hrs") 			= false;
				sheetObj.CellFontColor(3,prefix+"mnvr_in_hrs") 			= grayColor;
				
				sheetObj.CellEditable(lastPos, prefix+"mnvr_in_hrs") 	= true;
				sheetObj.CellBackColor(lastPos, prefix+"mnvr_in_hrs") 	= whiteColor;
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					if(k%2 == 0){
						sheetObj.CellEditable(k, "sheet2_Sel") 	= false;
						sheetObj.CellEditable(k, "sheet2_row_seq") 	= false;
						sheetObj.CellEditable(k, "sheet2_skd_dir_cd") 	= false;
						sheetObj.CellEditable(k, "sheet2_port_cd") 	= false;
						sheetObj.CellEditable(k, "sheet2_yd_cd") 	= false;
						sheetObj.CellEditable(k, "sheet2_etb_dy_no") 	= false;
						sheetObj.CellEditable(k, "sheet2_etb_dy_cd") 	= false;
						sheetObj.CellEditable(k, "sheet2_etb_tm_hrmnt") 	= false;
						sheetObj.CellEditable(k, "sheet2_etd_dy_no") 	= false;
						sheetObj.CellEditable(k, "sheet2_etd_dy_cd") 	= false;
						sheetObj.CellEditable(k, "sheet2_etd_tm_hrmnt") 	= false;
						sheetObj.CellEditable(k, "sheet2_act_wrk_hrs") 	= false;
						sheetObj.CellEditable(k, "sheet2_port_buf_hrs") 	= false;
					
					}else{
						sheetObj.CellEditable(k, "sheet2_lnk_dist") 	= false;
						sheetObj.CellEditable(k, "sheet2_lnk_spd") 	= false;
						sheetObj.CellEditable(k, "sheet2_tztm_hrs") 	= false;
						sheetObj.CellEditable(k, "sheet2_sea_buf_hrs") 	= false;
						sheetObj.CellEditable(k, "sheet2_sea_buf_spd") 	= false;
					
					}
	       	 	}
		
				for(var k=3; k<=sheetObj.RowCount+2; k++){
					if(sheetObj.CellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.CellValue(k, "sheet2_crane_wk_tm") != ""){
						var redColor = sheetObj.RgbColor(eval("255"),eval("128"),eval("0"));
						sheetObj.CellBackColor(k,"sheet2_port_cd") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_dy_no") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_dy_cd") = redColor;
						sheetObj.CellBackColor(k,"sheet2_etb_tm_hrmnt") = redColor;
					}
	       	 	}
				
				for(var i=0; i<sheetObj.RowCount; i++){
					sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
				}
				
				if(Pos == "Y"){
					var posTemp = Number(formObj.currPos.value);
					sheetObj.SelectCell(posTemp, sheetObj.id+"_port_cd", true);
				}
			}
			
		break;
		

		case "sheet3":
			sheetObj.Redraw = false;
			sheetObj.Editable = true;
			sheetObj.LoadSearchXml(sXml);
			DataSet(sheetObj,"sheet3_");
			sheetObj.Redraw = true;
			if(Pos == "N"){
				document.form.flag.value="U"
				for(var i=4;i<sheetObj.RowCount+4;i++){	  
			 		sheetObj.CellValue(i,"sheet3_ibflag") ="U" 
			    }
			}
		break;
		case "sheet4":
			sheetObj.Redraw = false;
			sheetObj.Editable = true;
			sheetObj.LoadSearchXml(sXml);
			DataSet(sheetObj,"sheet4_");
			sheetObj.Redraw = true;	
			if(Pos == "N"){
				document.form.flag.value="U"
				for(var i=4;i<sheetObj.RowCount+4;i++){	  
			 		sheetObj.CellValue(i,"sheet4_ibflag") ="U" 
			    }
			}
		break;
		case "sheet5":
			sheetObj.Redraw = false;
			sheetObj.Editable = true;
			sheetObj.LoadSearchXml(sXml);
			DataSet(sheetObj,"sheet5_");
			sheetObj.Redraw = true;
			if(Pos == "N"){
				document.form.flag.value="U"
				for(var i=4;i<sheetObj.RowCount+4;i++){	  
			 		sheetObj.CellValue(i,"sheet5_ibflag") ="U" 
			    }
			}
		break;
	}
}
 
 
 /**
	 * 조회 후 처리로직.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
 function DataSet(sheetObj,sheet){
	  var skdDirCd1,skdDirCd2
	  for(var i=4;i<sheetObj.RowCount+4;i++){
			if(i%2 == 0){
				sheetObj.CellEditable(i, sheet+"row_seq") = false;
				sheetObj.CellEditable(i, sheet+"skd_dir_cd") = false;
				sheetObj.CellEditable(i, sheet+"port_cd") = false;
				sheetObj.CellEditable(i, sheet+"yd_cd") = false;
				sheetObj.CellEditable(i, sheet+"sim_max_spd") = false;
				sheetObj.CellEditable(i, sheet+"sim_min_spd") = false;
				sheetObj.CellEditable(i, sheet+"sim_gnr_spd") = false;
				sheetObj.CellEditable(i, sheet+"sim_sea_spd") = false;
				sheetObj.CellEditable(i, sheet+"sim_sea_foil_csm_wgt") = false;
				
//				sheetObj.CellEditable(i, sheet+"sim_mnvr_foil_csm_wgt") = false;
				sheetObj.CellEditable(i, sheet+"sim_ttl_foil_csm_wgt") = false;
				sheetObj.CellEditable(i, sheet+"sim_buf_sea_spd") = false;
				sheetObj.CellEditable(i, sheet+"sim_buf_sea_foil_csm_wgt") = false;
				sheetObj.CellEditable(i, sheet+"sim_buf_gnr_foil_csm_wgt") = false;
				sheetObj.CellEditable(i, sheet+"sim_buf_ttl_foil_csm_wgt") = false;
				
			}else{
				sheetObj.CellEditable(i, sheet+"row_seq") = false;
				sheetObj.CellEditable(i, sheet+"skd_dir_cd") = false;
				sheetObj.CellEditable(i, sheet+"port_cd") = false;
				sheetObj.CellEditable(i, sheet+"yd_cd") = false;
				sheetObj.CellEditable(i, sheet+"sim_port_foil_csm_wgt") = false;
				// sheetObj.CellEditable(i, sheet+"sim_gnr_port_foil_csm_wgt") =
				// false;
			}
			if(i==4) skdDirCd1 = sheetObj.CellValue(i,sheet+"skd_dir_cd")
		    else if(i == sheetObj.RowCount+2) skdDirCd2 = sheetObj.CellValue(i,sheet+"skd_dir_cd")
		}
	  
		var nowRow = sheetObj.DataInsert(-1);
	   	sheetObj.CellValue2(nowRow, sheet+"row_seq") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"skd_dir_cd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"port_cd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"yd_cd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_max_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_min_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_gnr_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_sea_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_sea_foil_csm_wgt") = "West";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_mnvr_foil_csm_wgt") = "West";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_port_foil_csm_wgt") = "West";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_gnr_port_foil_csm_wgt") = "West";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_ttl_foil_csm_wgt") = "";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_buf_sea_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_buf_sea_foil_csm_wgt") = "West";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_buf_gnr_foil_csm_wgt") = "West";
	   	sheetObj.CellValue2(nowRow, sheet+"sim_buf_ttl_foil_csm_wgt") = "";
	   	
	   	sheetObj.CellAlign(nowRow, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow, sheet+"sim_buf_sea_spd") = daCenter;
	   	sheetObj.CellAlign(nowRow, sheet+"sim_buf_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow, sheet+"sim_buf_gnr_foil_csm_wgt") = daCenter;
	   	
	   	sheetObj.DataInsert(-1);
	   	sheetObj.CellValue2(nowRow+1, sheet+"row_seq") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"skd_dir_cd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"port_cd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"yd_cd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_max_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_min_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_gnr_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_sea_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_sea_foil_csm_wgt") = "East";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_mnvr_foil_csm_wgt") = "East";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_port_foil_csm_wgt") = "East";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_gnr_port_foil_csm_wgt") = "East";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_ttl_foil_csm_wgt") = "";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_buf_sea_spd") = "Bound";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_buf_sea_foil_csm_wgt") = "East";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_buf_gnr_foil_csm_wgt") = "East";
	   	sheetObj.CellValue2(nowRow+1, sheet+"sim_buf_ttl_foil_csm_wgt") = "";
	   	
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_buf_sea_spd") = daCenter;
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_buf_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow+1, sheet+"sim_buf_gnr_foil_csm_wgt") = daCenter;
	   	
	   	sheetObj.DataInsert(-1);
	   	sheetObj.CellValue2(nowRow+2, sheet+"row_seq") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"skd_dir_cd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"port_cd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"yd_cd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_max_spd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_min_spd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_gnr_spd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_sea_spd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_sea_foil_csm_wgt") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_mnvr_foil_csm_wgt") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_port_foil_csm_wgt") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_gnr_port_foil_csm_wgt") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_ttl_foil_csm_wgt") = "";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_buf_sea_spd") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_buf_sea_foil_csm_wgt") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_buf_gnr_foil_csm_wgt") = "TTL";
	   	sheetObj.CellValue2(nowRow+2, sheet+"sim_buf_ttl_foil_csm_wgt") = "";
	   	
	   	sheetObj.CellAlign(nowRow+2, sheet+"sim_buf_sea_spd") = daCenter;
	   	sheetObj.CellAlign(nowRow+2, sheet+"sim_buf_sea_foil_csm_wgt") = daCenter;
	   	sheetObj.CellAlign(nowRow+2, sheet+"sim_buf_gnr_foil_csm_wgt") = daCenter;
	   	
	   	sheetObj.SetMergeCell (nowRow, 3,2, 8);
	   	sheetObj.SetMergeCell (nowRow, 11, 1, 4);
		sheetObj.SetMergeCell (nowRow, 15, 1, 1);
	   	sheetObj.SetMergeCell (nowRow, 16, 2, 1);
	    sheetObj.SetMergeCell (nowRow, 17, 1, 2);
	    sheetObj.SetMergeCell (nowRow, 19, 1, 1);
	   	sheetObj.SetMergeCell (nowRow+1, 11, 1, 4);
	   	sheetObj.SetMergeCell (nowRow+1, 15, 1, 1);
	   	sheetObj.SetMergeCell (nowRow+1, 17, 1, 2);
	    sheetObj.SetMergeCell (nowRow+1, 19, 1, 1)
	   	sheetObj.SetMergeCell (nowRow+2, 3, 1, 12);
	   	sheetObj.SetMergeCell (nowRow+2, 15, 1, 1);
	   	sheetObj.SetMergeCell (nowRow+2, 16, 1, 3);
	    sheetObj.SetMergeCell (nowRow+2, 19, 1, 1)

			 if(skdDirCd1 =="E") skdDirCd1 ="East";
			 else if(skdDirCd1 =="W") skdDirCd1 ="West";
			 else if(skdDirCd1 =="N") skdDirCd1 ="Nouth";
			 else if(skdDirCd1 =="S") skdDirCd1 ="South";
				 
			 if(skdDirCd2 =="E") skdDirCd2 ="East";
			 else if(skdDirCd2 =="W") skdDirCd2 ="West";
			 else if(skdDirCd2 =="N") skdDirCd2 ="Nouth";
			 else if(skdDirCd2 =="S") skdDirCd2 ="South";
			 
			sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_sea_foil_csm_wgt") = skdDirCd1;
			sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_mnvr_foil_csm_wgt") = skdDirCd1;
			sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_port_foil_csm_wgt") = skdDirCd1;
			sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_gnr_port_foil_csm_wgt") = skdDirCd1;
			sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_buf_sea_foil_csm_wgt") = skdDirCd1;
		   	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_buf_gnr_foil_csm_wgt") = skdDirCd1;
		   	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_sea_foil_csm_wgt") = skdDirCd2;
			sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_mnvr_foil_csm_wgt") = skdDirCd2;
			sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_port_foil_csm_wgt") = skdDirCd2;
			sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_gnr_port_foil_csm_wgt") = skdDirCd2;
			sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_buf_sea_foil_csm_wgt") = skdDirCd2;
		   	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_buf_gnr_foil_csm_wgt") = skdDirCd2;
		    ttlSum(sheetObj,sheet)
 }
  
  /**
	 * 조회 후 처리로직.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
  function ChangeValue(sheetObj,sheetObj2,sheet, cntrDznCapa){
	   var skdDirCd1,skdDirCd2
 	  for(var i=3;i<sheetObj.RowCount;i++){	  

 		   sheetObj.CellValue(i+1,sheet+"clpt_seq") = sheetObj2.CellValue(i,"sheet2_clpt_seq"); 
	       sheetObj.CellValue(i+1,sheet+"row_seq") = sheetObj2.CellValue(i,"sheet2_row_seq");
	       sheetObj.CellValue(i+1,sheet+"skd_dir_cd") = sheetObj2.CellValue(i,"sheet2_skd_dir_cd"); 
	       sheetObj.CellValue(i+1,sheet+"port_cd") = sheetObj2.CellValue(i,"sheet2_port_cd");
	       sheetObj.CellValue(i+1,sheet+"yd_cd") = sheetObj2.CellValue(i,"sheet2_yd_cd");
	       sheetObj.CellValue(i+1,sheet+"vsl_clss_cd") = cntrDznCapa;
	       if(i==3) skdDirCd1 = sheetObj.CellValue(i+1,sheet+"skd_dir_cd");
	       else if(i == sheetObj.RowCount-1) skdDirCd2 = sheetObj.CellValue(i,sheet+"skd_dir_cd");
	       
 		}
	 if(skdDirCd1 =="E") skdDirCd1 ="East"
	 else if(skdDirCd1 =="W") skdDirCd1 ="West"
	 else if(skdDirCd1 =="N") skdDirCd1 ="Nouth"
	 else if(skdDirCd1 =="S") skdDirCd1 ="South"
		 
	 if(skdDirCd2 =="E") skdDirCd2 ="East"
	 else if(skdDirCd2 =="W") skdDirCd2 ="West"
	 else if(skdDirCd2 =="N") skdDirCd2 ="Nouth"
	 else if(skdDirCd2 =="S") skdDirCd2 ="South"
	 
	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_sea_foil_csm_wgt") = skdDirCd1;
	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_mnvr_foil_csm_wgt") = skdDirCd1;
	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_port_foil_csm_wgt") = skdDirCd1;
	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_gnr_port_foil_csm_wgt") = skdDirCd1;
	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_buf_sea_foil_csm_wgt") = skdDirCd1;
   	sheetObj.CellValue(sheetObj.RowCount+1, sheet+"sim_buf_gnr_foil_csm_wgt") = skdDirCd1;
   	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_sea_foil_csm_wgt") = skdDirCd2;
	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_mnvr_foil_csm_wgt") = skdDirCd2;
	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_port_foil_csm_wgt") = skdDirCd2;
	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_gnr_port_foil_csm_wgt") = skdDirCd2;
	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_buf_sea_foil_csm_wgt") = skdDirCd2;
   	sheetObj.CellValue(sheetObj.RowCount+2, sheet+"sim_buf_gnr_foil_csm_wgt") = skdDirCd2;
	 
 	 for(var i=1;i<sheetObj.LastCol+1;i++){	  
 		sheetObj.CellValue2(0,i)=cntrDznCapa;
     }
 	 
  }
   


/**
 * P/F Type 설정위한 초기 데이타 셋팅.
 * 
 * @param sheetObj
 * @return
 */
function initPortDataFlg(sheetObj){ 
	var rows = sheetObj.Rows;

	for(var i=3; i<rows; i++){
		portDataFlgs[i-3] = "N";
	}
}

/**
 * SHEET2 그리드 Terminal 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
	var ydKindCode = ComGetEtcData(xmlStr, "yd_kind");
	var ydNm = ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt = "";
	
	if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
		var ydKindCodeArr = ydKindCode.split("|");
		var ydNmArr = ydNm.split("|");
		var ydCnt = ydKindCodeArr.length;
		
		ydTxt = ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt = ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}
		
		sheetObject.CellComboItem(Row, sheetObject.id+"_yd_cd", ydTxt, ydKindCode);

	}
}

/**
 * 화면을 초기화 한다.
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(){
	var formObj = document.form;
	formObj.reset();
	
//	var objs = document.all.item("SheetLayer");
	
	for(var i=0; i<sheetObjects.length; i++){
		sheetObjects[i].RemoveAll();
		if(sheetObjects[i].id!="sheet2" && sheetObjects[i].id!="sheet6"){
			sheetObjects[i].style.height = 0;
//			if(objs[i]){
//				objs[i].style.display = "Inline";
//			}
		}
	}
	
	parent.syncHeight();
	
	for(var i=0; i<comboObjects.length; i++){
		comboObjects[i].RemoveAll();
	}
	
	doActionIBCombo(sheetObjects[0],formObj,SEARCH,comboObjects[0],SEARCH01);
	
	if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
	
	initSumSheet();
	
	formObj.vsl_slan_cd.className = "input1";
	formObj.pf_svc_tp_cd.className = "input1";
	formObj.vsl_slan_cd.readOnly = false;
	formObj.pf_svc_tp_cd.readOnly = false;
	formObj.vsl_slan_cd.focus();
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * Modify By 2014.09.25 Lee Byoung Hoon
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case SEARCH:      // 조회
			
			if (ComIsNull(formObj.bnk_csm_sim_no.value)) {
				if(ComIsNull(formObj.vsl_slan_cd.value)){
					ComShowCodeMessage('FCM00002', "Lane Code");
					formObj.vsl_slan_cd.focus();
					return false;
				}
				
				if(ComIsNull(formObj.pf_svc_tp_cd.value)){
					ComShowCodeMessage('FCM00002', "P/F SKD Type");
					formObj.pf_svc_tp_cd.focus();
					return false;
				}
				
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("FCM00003", "Lane Code");
					formObj.vsl_slan_cd.value = "";
					formObj.vsl_slan_cd.focus();
					
					return false;
				}
			} else {
				var simTemp = ComReplaceStr(formObj.bnk_csm_sim_no.value,"-","");
				if (simTemp.length != 11) {
					ComShowCodeMessage("FCM00003", "Simulation No.");
					formObj.bnk_csm_sim_no.focus();
					return false;
				}
			}

			break;
		
		case SEARCH02:
			var trndLineSheetObj = findSheetObj(sheetObjects, "sheet7");
			if(trndLineSheetObj.RowCount > 0){
				return true;
			}else{
				ComShowMessage("Please setup first");
				return false;
			}
			break;
		default:
	}
    return true;
}

/**
 * Enter키 이벤트
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){
	var formObj = document.form;

	doActionIBSheet(sheetObjects[0], formObj, SEARCH);
}

/**
 * grid 출력 후 Duration,Frequency 셋팅
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function gridEndJob(sheetObj,formObj){

	var lastEtbDyNo 		= parseInt(sheetObj.CellValue(sheetObj.HeaderRows+sheetObj.RowCount - 1,"sheet2_etb_dy_no"));
	var lastEtbTmHrmnt		= sheetObj.CellValue(sheetObj.HeaderRows+sheetObj.RowCount - 1,"sheet2_etb_tm_hrmnt");
	
	var firstEtbDyNo 		= parseInt(sheetObj.CellValue(sheetObj.HeaderRows,"sheet2_etb_dy_no"));
	var firstEtbTmHrmnt 	= sheetObj.CellValue(sheetObj.HeaderRows,"sheet2_etb_tm_hrmnt");
	
	var tempLastEtbTmHrmnt 	= lastEtbTmHrmnt.length;
	var tempFirstEtbTmHrmnt = firstEtbTmHrmnt.length;
	
	var lastEtbTmHrmntVal = 0;
	var firstEtbTmHrmntVal = 0;

	if(tempLastEtbTmHrmnt == 4){
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,2);
	}else{
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,1);
	}
	
	if(tempFirstEtbTmHrmnt == 4){
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,2);
	}else{
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,1);
	}
	
	if(tempLastEtbTmHrmnt == 4){
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,2);
	}else{
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,1);
	}
	
	if(tempFirstEtbTmHrmnt == 4){
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,2);
	}else{
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,1);
	}

	var lastTot = parseInt(lastEtbDyNo * 24) + parseInt(lastEtbTmHrmntVal);
	var firstTot = parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);
	var tempDur = parseInt(lastTot - firstTot);

	// Duration, Frequency는 소수점 첫째짜리까지만 사용. 그 이하는 모두 버림
	var durVal1 = tempDur/24;
	durVal1 = parseInt(durVal1 * 10); // 소수점 첫제짜리이하 숫자 삭제
	durVal1 = parseFloat(durVal1/10);
	
	var resultDurVal = isNaN(durVal1);
	
	if(resultDurVal == true){
		durVal1 = 0;
	}
	
	formObj.svc_dur_dys.value = durVal1;
	
	
	// Frequency
	var vslCnt = Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
	var frequency = durVal1/vslCnt;
	frequency = Math.round(parseInt(frequency * 10))/10;
	formObj.brth_itval_dys.value = frequency;	
	
}

/**
 * grid 출력 후 last 로우 Color 셋팅
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */ 
function setlastLowView(sheetObj,rowPos){

	var rdInx = rowPos - 1;	

	var prefix = "sheet2_";
	
	if(sheetObj.RowCount  > 0){
		// 회색
		var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
		// 흰색
		var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
		
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_dist") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_spd") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"tztm_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_spd") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_in_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_out_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"act_wrk_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"port_buf_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ipcgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ipcgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ocn_cgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ocn_cgo_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"tml_prod_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"crn_knt") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"turn_port_flg") = false;
		
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_no") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_cd") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_tm_hrmnt") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_dist") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_spd") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tztm_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_spd") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"mnvr_out_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"act_wrk_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"port_buf_hrs") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ipcgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ipcgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ocn_cgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ocn_cgo_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tml_prod_qty") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"crn_knt") = grayColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"turn_port_flg") = grayColor;
		sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
	}

}

/**
 * grid 출력 후 last 로우 Color 셋팅
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowViewUndo(sheetObj,rowPos){
	var rdInx = rowPos - 1;					
	var prefix = "sheet2_";

	if(sheetObj.RowCount > 0){
		// 회색
		var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
		// 흰색
		var withrColor = sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));
		// 검은색
		var blackColor = sheetObj.RgbColor(eval("0"),eval("0"),eval("0"));
		
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_dist") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"lnk_spd") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"tztm_hrs") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"sea_buf_spd") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_in_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"mnvr_out_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"act_wrk_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"port_buf_hrs") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ipcgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ipcgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ib_ocn_cgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"ob_ocn_cgo_qty") = true;
		sheetObjects[1].CellEditable(rdInx, prefix+"tml_prod_qty") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"crn_knt") = false;
		sheetObjects[1].CellEditable(rdInx, prefix+"turn_port_flg") = true;
		
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_no") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_dy_cd") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"etd_tm_hrmnt") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_dist") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"lnk_spd") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tztm_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"sea_buf_spd") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"mnvr_in_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"mnvr_out_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"act_wrk_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"port_buf_hrs") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ipcgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ipcgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ib_ocn_cgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"ob_ocn_cgo_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"tml_prod_qty") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"crn_knt") = blackColor;
		sheetObjects[1].CellFontColor(rdInx,prefix+"turn_port_flg") = blackColor;
		// sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") =
		// withrColor;
	}
}

/**
 * CLPT_SEQ 순차적으로 다시 생성
 * 
 * @param sheetObj
 * @return
 */

function resetRowSeq(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var prefix = sheetObj.id + "_";
	var idx = 0;
	var vIbFlag = "";
	
	for(var i=0; i<rowCnt; i++){
// if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
// vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
// idx++;
// sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
// sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
// }
		if(sheetObj.RowStatus(i+headCnt) != "D"){
			vIbFlag = sheetObj.RowStatus(i+headCnt);
			idx++;
			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
			sheetObj.RowStatus(i+headCnt) = vIbFlag;
		}
	}
}



/**
 * 조회 조건이 아닌 모든 데이타 초기화.
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearDescData(sheetObj1, sheetObj2, formObj){

	formObj.brth_itval_dys.value = "";
	// formObj.n1st_vsl_clss_cd.value = "";
	comboObjects[0].Index2 = -1;
	formObj.n1st_vsl_clss_knt.value = "";
	// formObj.n2nd_vsl_clss_cd.value = "";
	comboObjects[1].Index2 = -1;
	formObj.n2nd_vsl_clss_knt.value = "";
	// formObj.n3rd_vsl_clss_cd.value = "";
	comboObjects[2].Index2 = -1;
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.svc_dur_dys.value = "";

	sheetObj1.RemoveAll();
	sheetObj1.DataInsert(-1);
	sheetObj2.RemoveAll();
	
	// All Check 초기화
	sheetObj2.CheckAll(sheetObj2.id+"_Sel") = 0;
}



function getRowCount(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var rowCnt = sheetObj.RowCount;
	var totalCnt = headCnt+rowCnt;
	var idx = 0;
	var rtnIdx = 0;
	var prefix = "sheet2_";
	
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.CellValue(i, 0) != "D"){
			idx++;
			
		}
	}
	
	return idx;
}

function setValCls(comboObj,val){
	var cnt = comboObj.GetCount;
	var comboPos = -1;
	
	for(var i=0; i<cnt; i++){
		if(comboObj.GetIndexText(i,0) == val){
			comboPos = i;
			break;
		}
	}
	
	if(comboPos >= 0){
		comboObj.Index2 =  comboPos;
	}else{
		comboObj.Index2 =  -1;
	}
	
}

/**
 * Sheet의 Terminal Combo Data Clear...
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function setSheetClearCombo(sheetObj, Row, Col){
	sheetObj.CellComboItem(Row, sheetObj.id+"_yd_cd", "", "");
}

function sheet2_OnAfterEdit(sheetObj, Row,Col){
	var formObj = document.form;
	
	
}

function sheet3_OnChange(sheetObject, Row, Col, Value) {	 
	ttlSum(sheetObject,"sheet3_")	
}  
function sheet4_OnChange(sheetObject, Row, Col, Value) {	 
	 ttlSum(sheetObject,"sheet4_")	
}  
function sheet5_OnChange(sheetObject, Row, Col, Value) {	 
	 ttlSum(sheetObject,"sheet5_")
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var sumSheetObj = findSheetObj(sheetObjects, "sheet6");
	var searchRows = 0;
	if((searchRows = sheetObj.SearchRows)>0){
		sumSheetObj.Redraw = false;
		
		var preDirCd = "";
		var curDirCd = "";
		
		var sumLnkDist = 0;
		var sumLnkSpd = 0;
		var sumTztmHrs = 0;
		var sumSeaBufHrs = 0;
		var sumSeaBufSpd = 0;
		var sumMnvrInHrs = 0;
		var sumMnvrOutHrs = 0;
		var sumActWrkHrs = 0;
		
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.SearchRows; i++){

			curDirCd = getBound(sheetObj, i);

			if(preDirCd!="" && preDirCd!=curDirCd){
				// firstDir에 대한 셋팅
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"lnk_dist") = sumLnkDist;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"lnk_spd") = sumLnkSpd;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"tztm_hrs") = sumTztmHrs;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sea_buf_hrs") = sumSeaBufHrs;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sea_buf_spd") = sumSeaBufSpd;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"mnvr_in_hrs") = sumMnvrInHrs;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"mnvr_out_hrs") = sumMnvrOutHrs;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"act_wrk_hrs") = sumActWrkHrs;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"etd_dy_cd") = preDirCd;
				sumSheetObj.SetMergeCell(1, sumSheetObj.SaveNameCol(sumSheetObj.prefix+"etd_dy_cd"), 1, 2);
				
				sumLnkDist = 0;
				sumLnkSpd = 0;
				sumTztmHrs = 0;
				sumSeaBufHrs = 0;
				sumSeaBufSpd = 0;
				sumMnvrInHrs = 0;
				sumMnvrOutHrs = 0;
				sumActWrkHrs = 0;
			}
			
			if(sheetObj.CellValue(i, sheetObj.prefix+"vps_port_cd")!=""){
				sumLnkDist = sumLnkDist + getNumberVal(sheetObj.CellValue(i+1, sheetObj.prefix+"lnk_dist"));
				sumLnkSpd = sumLnkSpd + getNumberVal(sheetObj.CellValue(i+1, sheetObj.prefix+"lnk_spd"));
				sumTztmHrs = sumTztmHrs + getNumberVal(sheetObj.CellValue(i+1, sheetObj.prefix+"tztm_hrs"));
				sumSeaBufHrs = sumSeaBufHrs + getNumberVal(sheetObj.CellValue(i+1, sheetObj.prefix+"sea_buf_hrs"));
				sumSeaBufSpd = sumSeaBufSpd + getNumberVal(sheetObj.CellValue(i+1, sheetObj.prefix+"sea_buf_spd"));
				sumMnvrInHrs = sumMnvrInHrs + getNumberVal(sheetObj.CellValue(i+1, sheetObj.prefix+"mnvr_in_hrs"));
				sumMnvrOutHrs = sumMnvrOutHrs + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"mnvr_out_hrs"));
				sumActWrkHrs = sumActWrkHrs + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"act_wrk_hrs"));
			}
			
			preDirCd = curDirCd;
		}
		
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"lnk_dist") = sumLnkDist;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"lnk_spd") = sumLnkSpd;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"tztm_hrs") = sumTztmHrs;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sea_buf_hrs") = sumSeaBufHrs;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sea_buf_spd") = sumSeaBufSpd;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"mnvr_in_hrs") = sumMnvrInHrs;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"mnvr_out_hrs") = sumMnvrOutHrs;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"act_wrk_hrs") = sumActWrkHrs;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"etd_dy_cd") = preDirCd;
		sumSheetObj.SetMergeCell(2, sumSheetObj.SaveNameCol(sumSheetObj.prefix+"etd_dy_cd"), 1, 2);
		
		// GRAND TOTAL = SUB_TOTAL의 합
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"lnk_dist")     = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"lnk_dist"))     + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"lnk_dist"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"lnk_spd")      = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"lnk_spd"))      + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"lnk_spd"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"tztm_hrs")     = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"tztm_hrs"))     + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"tztm_hrs"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sea_buf_hrs")  = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sea_buf_hrs"))  + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sea_buf_hrs"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sea_buf_spd")  = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sea_buf_spd"))  + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sea_buf_spd"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"mnvr_in_hrs")  = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"mnvr_in_hrs"))  + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"mnvr_in_hrs"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"mnvr_out_hrs") = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"mnvr_out_hrs")) + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"mnvr_out_hrs"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"act_wrk_hrs")  = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"act_wrk_hrs"))  + Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"act_wrk_hrs"));
		
		sumSheetObj.Redraw = true;
	}
}

function applyTtlFoc(sheetObj){

	var formObj = document.form;
	var sumSheetObj = findSheetObj(sheetObjects, "sheet6");
	var searchRows = 0;
	if((searchRows = sheetObj.SearchRows)>0){
		sumSheetObj.Redraw = false;
		
		var preDirCd = "";
		var curDirCd = "";
		
		var sumSimTtlFoilCsmWgt1 = 0;
		var sumSimBufTtlFoilCsmWgt1 = 0;
		var sumSimTtlFoilCsmWgt2 = 0;
		var sumSimBufTtlFoilCsmWgt2 = 0;
		var sumSimTtlFoilCsmWgt3 = 0;
		var sumSimBufTtlFoilCsmWgt3 = 0;
		
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.SearchRows; i++){

			curDirCd = getBound(sheetObj, i);

			if(preDirCd!="" && preDirCd!=curDirCd){
				// firstDir에 대한 셋팅
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt1") = sumSimTtlFoilCsmWgt1;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt1") = sumSimBufTtlFoilCsmWgt1;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt2") = sumSimTtlFoilCsmWgt2;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt2") = sumSimBufTtlFoilCsmWgt2;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt3") = sumSimTtlFoilCsmWgt3;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt3") = sumSimBufTtlFoilCsmWgt3;
				sumSheetObj.CellValue2(1, sumSheetObj.prefix+"skd_dir_cd") = preDirCd;
				
				sumSimTtlFoilCsmWgt1 = 0;
				sumSimBufTtlFoilCsmWgt1 = 0;
				sumSimTtlFoilCsmWgt2 = 0;
				sumSimBufTtlFoilCsmWgt2 = 0;
				sumSimTtlFoilCsmWgt3 = 0;
				sumSimBufTtlFoilCsmWgt3 = 0;
			}
			
			sumSimTtlFoilCsmWgt1 = sumSimTtlFoilCsmWgt1 + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"sim_ttl_foil_csm_wgt1"));
			sumSimBufTtlFoilCsmWgt1 = sumSimBufTtlFoilCsmWgt1 + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"sim_buf_ttl_foil_csm_wgt1"));
			sumSimTtlFoilCsmWgt2 = sumSimTtlFoilCsmWgt2 + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"sim_ttl_foil_csm_wgt2"));
			sumSimBufTtlFoilCsmWgt2 = sumSimBufTtlFoilCsmWgt2 + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"sim_buf_ttl_foil_csm_wgt2"));
			sumSimTtlFoilCsmWgt3 = sumSimTtlFoilCsmWgt3 + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"sim_ttl_foil_csm_wgt3"));
			sumSimBufTtlFoilCsmWgt3 = sumSimBufTtlFoilCsmWgt3 + getNumberVal(sheetObj.CellValue(i, sheetObj.prefix+"sim_buf_ttl_foil_csm_wgt3"));

			preDirCd = curDirCd;
		}
		
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt1") = sumSimTtlFoilCsmWgt1;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt1") = sumSimBufTtlFoilCsmWgt1;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt2") = sumSimTtlFoilCsmWgt2;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt2") = sumSimBufTtlFoilCsmWgt2;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt3") = sumSimTtlFoilCsmWgt3;
		sumSheetObj.CellValue2(2, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt3") = sumSimBufTtlFoilCsmWgt3;
		
		// GRAND TOTAL = SUB_TOTAL의 합
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt1")     = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt1")) +
		                                                                            Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt1"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt1") = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt1")) +
		                                                                            Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt1"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt2")     = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt2")) +
		                                                                            Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt2"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt2") = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt2")) +
		                                                                            Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt2"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt3")     = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt3")) +
		                                                                            Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sim_ttl_foil_csm_wgt3"));
		sumSheetObj.CellValue2(3, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt3") = Number(sumSheetObj.CellValue(1, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt3")) +
		                                                                            Number(sumSheetObj.CellValue(2, sumSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt3"));
		sumSheetObj.Redraw = true;
	}

}

function sheet3_OnSearchEnd(sheetObj, ErrMsg){
	sheet_OnSearchEnd(sheetObj, ErrMsg);
}

function sheet4_OnSearchEnd(sheetObj, ErrMsg){
	sheet_OnSearchEnd(sheetObj, ErrMsg);	
}

function sheet5_OnSearchEnd(sheetObj, ErrMsg){
	sheet_OnSearchEnd(sheetObj, ErrMsg);
}

function sheet_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var mainSheetObj = findSheetObj(sheetObjects, "sheet2");
	var searchRows = 0;
	
	var lnkDist = 0;
	var tztmHrs = 0;
	var seaBufHrs = 0;
	var mnvrInHrs = 0;
	var mnvrOutHrs = 0;
	var portHrs = 0;
	
	var classNo = sheetObj.classNo;
	var prefix = sheetObj.prefix;
	
	sheetObj.Redraw = false;
	mainSheetObj.Redraw = false;
	
	if((searchRows = mainSheetObj.SearchRows) > 0){
		
		document.getElementById(sheetObj.id+"Table").style.display = "";
		sheetObj.style.height = sheetObj.GetSheetHeight(searchRows);
		
		for(var i=mainSheetObj.HeaderRows; i<mainSheetObj.HeaderRows+searchRows; i++){
			if((lnkDist=mainSheetObj.CellValue(i, mainSheetObj.prefix+"lnk_dist")) && lnkDist!=""){
				lnkDist = Number(lnkDist);
			}else{
				lnkDist = null;
			}
			
			if((tztmHrs=mainSheetObj.CellValue(i, mainSheetObj.prefix+"tztm_hrs")) && tztmHrs!=""){
				if(tztmHrs=="0"){
					tztmHrs = "1";
				}
				tztmHrs = Number(tztmHrs);
			}else{
				tztmHrs = null;
			}
			
			if((seaBufHrs=mainSheetObj.CellValue(i, mainSheetObj.prefix+"sea_buf_hrs")) && seaBufHrs!=""){
				seaBufHrs = Number(seaBufHrs);
			}else{
				seaBufHrs = null;
			}

			// PF Port Time
			if((portHrs=mainSheetObj.CellValue(i-1, mainSheetObj.prefix+"act_wrk_hrs")) && portHrs!=""){
				portHrs = Number(portHrs);
			}else{
				portHrs = null;
			}
			
			if((mnvrInHrs=mainSheetObj.CellValue(i, mainSheetObj.prefix+"mnvr_in_hrs")) && mnvrInHrs!=""){
				mnvrInHrs = Number(mnvrInHrs);
			}else{
				mnvrInHrs = null;
			}
			
			if((mnvrOutHrs=mainSheetObj.CellValue(i-1, mainSheetObj.prefix+"mnvr_out_hrs")) && mnvrOutHrs!=""){
				mnvrOutHrs = Number(mnvrOutHrs);
			}else{
				mnvrOutHrs = null;
			}
			
			if(!lnkDist || !tztmHrs || tztmHrs==0){
				continue;
			}

			//sheetObj 헤더의 갯수가 mainSheetObj보다 1개 많음 ==> i:Port 구간, i+1:Sea 구간
			
			// PF Sea Time
			var seaTime = tztmHrs;
			
			//Sea Speed
			var simSeaSpd = getSeaSpeed(sheetObj, lnkDist/seaTime);
			var simMaxSpd = getMaxSpeed(sheetObj);
			var simMinSpd = getMinSpeed(sheetObj);
			var simGnrSpd = getGnrSpeed(sheetObj);

			sheetObj.CellValue2(i+1, prefix+"sim_sea_spd") = round(simSeaSpd, 1);
			sheetObj.CellValue2(i+1, prefix+"sim_max_spd") = round( simMaxSpd, 1);
			sheetObj.CellValue2(i+1, prefix+"sim_min_spd") = round( simMinSpd, 1);
			sheetObj.CellValue2(i+1, prefix+"sim_gnr_spd") = round( simGnrSpd, 1);
			
			// 만약 simSeaSpd < simMinSpd 이면, seaTime 다시 구함
			// 1. simSeaSpd <== simMinSpd
			// 2. seaTime = lnkDist/simSeaSpd 
			if(simSeaSpd < simMinSpd){
				simSeaSpd = simMinSpd;
				seaTime = lnkDist/simSeaSpd;
			}
			
			// Sea FOC : 24기준 해당 Speed의 연료 소모량을 표시함
			var simSeaFoilCsmWgt = getSeaFoc(sheetObj, simSeaSpd);
			var simSeaFoilCsmWgt24 = simSeaFoilCsmWgt;
			sheetObj.CellValue2(i+1, prefix+"sim_sea_foil_csm_wgt") = round( simSeaFoilCsmWgt24, 1); // 24시간 단위표기
			simSeaFoilCsmWgt = simSeaFoilCsmWgt * (seaTime/24); // TTL FOC용
			
			
			// Menuvering FOC : Class별 Set up된 값을 호출하여 표시함
			var simMnvrOutFoilCsmWgt = getMnvrCsmWgt(sheetObj);
			var simMnvrOutFoilCsmWgt24 = simMnvrOutFoilCsmWgt;
			sheetObj.CellValue2(i, prefix+"sim_mnvr_foil_csm_wgt") = round( simMnvrOutFoilCsmWgt24, 1); // 24시간 단위표기
			simMnvrOutFoilCsmWgt = Number(simMnvrOutFoilCsmWgt) * (mnvrOutHrs/24); // TTL FOC 용
			
			var simMnvrInFoilCsmWgt = getMnvrCsmWgt(sheetObj);
			var simMnvrInFoilCsmWgt24 = simMnvrInFoilCsmWgt;
			sheetObj.CellValue2(i+1, prefix+"sim_mnvr_foil_csm_wgt") = round( simMnvrInFoilCsmWgt24, 1); // 24시간 단위표기
			simMnvrInFoilCsmWgt = Number(simMnvrInFoilCsmWgt) * (mnvrInHrs/24); // TTL FOC 용
			
			// Port FOC : Trend Line에 저장된 24 G/E값에 70%값을 표시함
			var simGnrPortFoilCsmWgt = Number(getGnrPortCsmWgt(sheetObj))*0.7;
			var simGnrPortFoilCsmWgt24 = simGnrPortFoilCsmWgt;
			sheetObj.CellValue2(i, prefix+"sim_port_foil_csm_wgt") = round(simGnrPortFoilCsmWgt24 , 1); // 24시간 단위표기
			simGnrPortFoilCsmWgt = simGnrPortFoilCsmWgt*(portHrs/24); // TTL FOC용
			 
			// G/E FOC
			var simGnrFoilCsmWgtPort = Number(getGnrFoc(sheetObj, simSeaSpd));
			var simGnrFoilCsmWgtPort24 = simGnrFoilCsmWgtPort;
			sheetObj.CellValue2(i, prefix+"sim_gnr_port_foil_csm_wgt") = round( simGnrFoilCsmWgtPort24, 1);
			simGnrFoilCsmWgtPort = simGnrFoilCsmWgtPort * ((portHrs+mnvrOutHrs)/24);
			
			var simGnrFoilCsmWgtSea = Number(getGnrFoc(sheetObj, simSeaSpd));
			var simGnrFoilCsmWgtSea24 = simGnrFoilCsmWgtSea;
			sheetObj.CellValue2(i+1, prefix+"sim_gnr_port_foil_csm_wgt") = round( simGnrFoilCsmWgtSea24, 1);
			simGnrFoilCsmWgtSea = simGnrFoilCsmWgtSea * ((seaTime+seaBufHrs+mnvrInHrs)/24);
			
			// TTL FOC Port 구간
			var simTtlFoilCsmWgtPort = simGnrPortFoilCsmWgt + simGnrFoilCsmWgtPort + simMnvrOutFoilCsmWgt;
			sheetObj.CellValue2(i, prefix+"sim_ttl_foil_csm_wgt") = round( simTtlFoilCsmWgtPort, 1);
			mainSheetObj.CellValue2(i-1, mainSheetObj.prefix+"sim_ttl_foil_csm_wgt"+classNo) = round( simTtlFoilCsmWgtPort, 1);
			
			// TTL FOC Sea 구간 : Sea FOC/24*Sea Time + Manv FOC/24 * Manuv Time +
			// G/E FOC/24* (Sea Time+Manuv. Time+ Sea Buffer time )
			var simTtlFoilCsmWgtSea = simSeaFoilCsmWgt + simMnvrInFoilCsmWgt + simGnrFoilCsmWgtSea;
			sheetObj.CellValue2(i+1, prefix+"sim_ttl_foil_csm_wgt") = round( simTtlFoilCsmWgtSea, 1);
			mainSheetObj.CellValue2(i, mainSheetObj.prefix+"sim_ttl_foil_csm_wgt"+classNo) = round( simTtlFoilCsmWgtSea, 1);
			
			// ///// 이하 BUffER ////////
			// ///// 이하 BUffER ////////
			// ///// 이하 BUffER ////////
			
			seaTime = seaTime + seaBufHrs;
			var simBufSeaSpd = lnkDist/seaTime;
			sheetObj.CellValue2(i+1, prefix+"sim_buf_sea_spd") = round( simBufSeaSpd, 1);
			
			// 만약 simBufSeaSpd < simMinSpd 이면, seaTime 다시 구함
			// 1. simBufSeaSpd <== simMinSpd
			// 2. seaTime = lnkDist/simBufSeaSpd 
			if(simBufSeaSpd < simMinSpd){
				simBufSeaSpd = simMinSpd;
				seaTime = lnkDist/simBufSeaSpd;
			}
			
			// Sea FOC : Buffer Speed에 의한 Sea구간의 FOC를 산출함
			var simBufSeaFoilCsmWgt = getSeaBuffFoc(sheetObj, simBufSeaSpd);
			var simBufSeaFoilCsmWgt24 = simBufSeaFoilCsmWgt;
			sheetObj.CellValue2(i+1, prefix+"sim_buf_sea_foil_csm_wgt") = round( simBufSeaFoilCsmWgt24, 1);
			simBufSeaFoilCsmWgt = simBufSeaFoilCsmWgt * (seaTime/24);
			
			// G/E FOC
			var simBufGnrPortFoilCsmWgtPort = Number(getGnrFoc(sheetObj, simBufSeaSpd));
			var simBufGnrPortFoilCsmWgtPort24 = simBufGnrPortFoilCsmWgtPort;
			simBufGnrPortFoilCsmWgtPort = simBufGnrPortFoilCsmWgtPort * ((portHrs+mnvrOutHrs)/24);
			sheetObj.CellValue2(i, prefix+"sim_buf_gnr_foil_csm_wgt") = round( simBufGnrPortFoilCsmWgtPort24, 1);
			
			var simBufGnrPortFoilCsmWgtSea = Number(getGnrFoc(sheetObj, simBufSeaSpd));
			var simBufGnrPortFoilCsmWgtSea24 = simBufGnrPortFoilCsmWgtSea;
			sheetObj.CellValue2(i+1, prefix+"sim_buf_gnr_foil_csm_wgt") = round( simBufGnrPortFoilCsmWgtSea24, 1);
			simBufGnrPortFoilCsmWgtSea = simBufGnrPortFoilCsmWgtSea * ((seaTime+seaBufHrs+mnvrInHrs)/24);
			
			// Buffer TTL Port 구간 : Port FOC/24* Port Time + G/E FOC/24* (Manuv
			// IN Time + Port Time+ Port Buffer Time )
			var simBufTtlFoilCsmWgtPort = simGnrPortFoilCsmWgt + simBufGnrPortFoilCsmWgtPort + simMnvrOutFoilCsmWgt;
			sheetObj.CellValue2(i, prefix+"sim_buf_ttl_foil_csm_wgt") = round( simBufTtlFoilCsmWgtPort, 1);
			mainSheetObj.CellValue2(i-1, mainSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt"+classNo) = round( simBufTtlFoilCsmWgtPort, 1);
			
			// Buffer TTL FOC Sea 구간 : Sea FOC/24*Sea Time + Manv FOC/24 * Manuv
			// Time + G/E FOC/24* (Sea Time+Manuv. out Time+ Sea Buffer time )
			var simBufTtlFoilCsmWgtSea = simBufSeaFoilCsmWgt + simMnvrInFoilCsmWgt + simBufGnrPortFoilCsmWgtSea;
			sheetObj.CellValue2(i+1, prefix+"sim_buf_ttl_foil_csm_wgt") = round( simBufTtlFoilCsmWgtSea, 1);
			mainSheetObj.CellValue2(i, mainSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt"+classNo) = round( simBufTtlFoilCsmWgtSea, 1);

		}
		
		// Class 헤더값
		mainSheetObj.RowHeight(2) = mainSheetObj.DataRowHeight*2;
		var cntrDznCapa = "";
		if(classNo=="1"){
			cntrDznCapa = sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_cd");
		}else if(classNo=="2"){
			cntrDznCapa = sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_cd");
		}else if(classNo=="3"){
			cntrDznCapa = sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_cd");
		}
			
		mainSheetObj.CellValue2(1, mainSheetObj.prefix+"sim_ttl_foil_csm_wgt"+classNo) = cntrDznCapa;
		mainSheetObj.CellValue2(1, mainSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt"+classNo) = cntrDznCapa;

		// mainSheetObj TTL Hidden 처리 해제
		mainSheetObj.ColHidden(mainSheetObj.prefix+"sim_ttl_foil_csm_wgt"+classNo) = false;
		mainSheetObj.ColHidden(mainSheetObj.prefix+"sim_buf_ttl_foil_csm_wgt"+classNo) = false;
		
		parent.syncHeight();
		
		sheetObj.FitColWidth();
		sheetObj.Redraw = true;
		mainSheetObj.Redraw = true;
		
		applyTtlFoc(mainSheetObj);
	}
}

function searchFcmVslRgstInfo(sheetObj, Row){
	var sXml = doActionIBSheet(sheetObj, document.form, SEARCH01);
	var prefix = sheetObj.prefix;
	
	sheetObj.CellValue2(Row, prefix+"sim_min_spd") = ComGetEtcData(sXml, "op_min_spd");
	sheetObj.CellValue2(Row, prefix+"sim_max_spd") = ComGetEtcData(sXml, "op_max_spd");
	sheetObj.CellValue2(Row, prefix+"sim_gnr_spd") = ComGetEtcData(sXml, "op_gnr_spd");
	sheetObj.CellValue2(Row, prefix+"sim_mnvr_foil_csm_wgt") = ComGetEtcData(sXml, "mnvr_csm_wgt");
	sheetObj.CellValue2(Row, prefix+"sim_gnr_port_foil_csm_wgt") = ComGetEtcData(sXml, "gnr_csm_wgt");
}


/**
 * TTL FOC 합
 */	 
function ttlSum(sheetObj,sheet){

	var ftotal=0;
	var stotal=0;
	var skdDirCd;
	var tmpDirCd;
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount - 3;
	for(var i=sRow; i<eRow; i++){
		if(i == sRow){
			skdDirCd = sheetObj.CellValue(i,sheet+"skd_dir_cd");
		}
		tmpDirCd = sheetObj.CellValue(i-1, sheet+"skd_dir_cd");
		if(skdDirCd == sheetObj.CellValue(i,sheet+"skd_dir_cd") || skdDirCd == tmpDirCd){
			ftotal = ftotal + Number(sheetObj.CellValue(i, sheet+"sim_ttl_foil_csm_wgt"))  
		}else{
			stotal = stotal + Number(sheetObj.CellValue(i, sheet+"sim_ttl_foil_csm_wgt"))  
		}
	}
	sheetObj.CellValue2(eRow  ,sheet+"sim_ttl_foil_csm_wgt") = ftotal;
	sheetObj.CellValue2(eRow+1,sheet+"sim_ttl_foil_csm_wgt") = stotal;
	sheetObj.CellValue2(eRow+2,sheet+"sim_ttl_foil_csm_wgt") = ftotal+stotal;
	
	var ftotal2=0;
	var stotal2=0;
	for(var i=sRow; i<eRow; i++){
		if(i == sRow){
			skdDirCd = sheetObj.CellValue(i,sheet+"skd_dir_cd");
		}
		tmpDirCd = sheetObj.CellValue(i-1, sheet+"skd_dir_cd");
		if(skdDirCd == sheetObj.CellValue(i,sheet+"skd_dir_cd") || skdDirCd == tmpDirCd){
			ftotal2 = ftotal2+ Number(sheetObj.CellValue(i, sheet+"sim_buf_ttl_foil_csm_wgt"))  
		}else{
			stotal2 = stotal2+ Number(sheetObj.CellValue(i, sheet+"sim_buf_ttl_foil_csm_wgt"))  
		}
	}
	sheetObj.CellValue2(eRow  ,sheet+"sim_buf_ttl_foil_csm_wgt") = ftotal2;
	sheetObj.CellValue2(eRow+1,sheet+"sim_buf_ttl_foil_csm_wgt") = stotal2;
	sheetObj.CellValue2(eRow+2,sheet+"sim_buf_ttl_foil_csm_wgt") = ftotal2+stotal2;

}

function getNumberVal(val){
	if(FcmIsNull(val)){
		return 0;
	}else{
		return Number(val);
	}
}

function getBound(sheetObj, i){
	var bound = sheetObj.CellValue(i, sheetObj.prefix+"skd_dir_cd");
	if(!bound){
		if(sheetObj.HeaderRows==i){
			bount = "";
		}else{
			bound = sheetObj.CellValue(i-1, sheetObj.prefix+"skd_dir_cd");
		}
	}
	return bound;
}

function setTrndLine(aryPopupData){
	var sheetObj = findSheetObj(sheetObjects, "sheet7");
	var formObj = document.form;
	var prefix = sheetObj.prefix;
	
	sheetObj.RemoveAll();
		if(aryPopupData!=""){
		var rowIdx = 0;
		for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+aryPopupData.length; Row++){
			
			sheetObj.DataInsert(-1);
			sheetObj.CellValue2(Row, prefix+"cntr_dzn_capa") = aryPopupData[rowIdx][1];
			sheetObj.CellValue2(Row, prefix+"vsl_slan_cd") = aryPopupData[rowIdx][2];
			sheetObj.CellValue2(Row, prefix+"trnd_line_no") = aryPopupData[rowIdx][3];
			sheetObj.CellValue2(Row, prefix+"trnd_line_rmk") = aryPopupData[rowIdx][4];
			sheetObj.CellValue2(Row, prefix+"trnd_line_seq") = aryPopupData[rowIdx][5];
			
			sheetObj.CellValue2(Row, prefix+"n1st_coef_val") = aryPopupData[rowIdx][7];
			sheetObj.CellValue2(Row, prefix+"n2nd_coef_val") = aryPopupData[rowIdx][8];
			sheetObj.CellValue2(Row, prefix+"trnd_line_cons_val") = aryPopupData[rowIdx][9];
			
			sheetObj.CellValue2(Row, prefix+"avg_gnr_csm_wgt") = aryPopupData[rowIdx][12];
			sheetObj.CellValue2(Row, prefix+"avg_blr_csm_wgt") = aryPopupData[rowIdx][13];
			
			formObj.trnd_line_tp_cd.value = aryPopupData[rowIdx][6];
			formObj.vsl_cd.value = aryPopupData[rowIdx][10];
			formObj.cntr_dzn_capa.value = aryPopupData[rowIdx][11];
						
			searchFcmVslRgstInfo(sheetObj, Row);
			rowIdx++;
		}
	}
}

function getTgtRow(classNo, tSheetObj){
	var prefix = tSheetObj.prefix;
	var tgtRow = 0;
	var sRow = tSheetObj.HeaderRows;
	var eRow = sRow + tSheetObj.RowCount;
	for(var i=sRow; i<eRow; i++){ // 헤더부터 시작해도 무방
		
		if(classNo==(i-sRow)+1){ // design capa.에 따른 trand line 위치 식별
			tgtRow = i;
			break;
		}
	}
	
	return tgtRow;
}

function getSeaSpeed(sheetObj, pfSpd){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var seaSpeed = pfSpd;
	var minSpeed = "";
	if(tgtRow!=0){
		minSpeed = tSheetObj.CellValue(tgtRow, prefix+"sim_min_spd");
		if(Number(seaSpeed)<Number(minSpeed)){
			seaSpeed = minSpeed;
		}
	}
	return seaSpeed;
}

function getMaxSpeed(sheetObj){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var simMaxSpd = "";
	if(tgtRow!=0){
		simMaxSpd = tSheetObj.CellValue(tgtRow, prefix+"sim_max_spd");
	}
	return simMaxSpd;
}

function getMinSpeed(sheetObj){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var simMinSpd = "";
	if(tgtRow!=0){
		simMinSpd = tSheetObj.CellValue(tgtRow, prefix+"sim_min_spd");
	}
	return simMinSpd;
}

function getGnrSpeed(sheetObj){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var simGnrSpd = "";
	if(tgtRow!=0){
		simGnrSpd = tSheetObj.CellValue(tgtRow, prefix+"sim_gnr_spd");
	}
	return simGnrSpd;
}

function getSeaFoc(sheetObj, seaSpd){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var seaFoc = "";
	
	if(tgtRow!=0){
		seaFoc = calcFoc(tSheetObj.CellValue(tgtRow, prefix+"n1st_coef_val"), tSheetObj.CellValue(tgtRow, prefix+"n2nd_coef_val"), tSheetObj.CellValue(tgtRow, prefix+"trnd_line_cons_val"), seaSpd);
	}
	
	return seaFoc;
}

function getSeaBuffFoc(sheetObj, seaBuffSpd){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var seaBuffFoc = "";
	
	if(tgtRow!=0){
		seaBuffFoc = calcFoc(tSheetObj.CellValue(tgtRow, prefix+"n1st_coef_val"), tSheetObj.CellValue(tgtRow, prefix+"n2nd_coef_val"), tSheetObj.CellValue(tgtRow, prefix+"trnd_line_cons_val"), seaBuffSpd);
	}
	
	return seaBuffFoc;
}

function getMnvrCsmWgt(sheetObj){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var mnvrCsmWgt = "";
	
	if(tgtRow!=0){
		mnvrCsmWgt = tSheetObj.CellValue(tgtRow, prefix+"sim_mnvr_foil_csm_wgt");
	}
	
	return mnvrCsmWgt;
}

function getGnrPortCsmWgt(sheetObj){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var gnrPortCsmWgt = "";
	
	if(tgtRow!=0){
		gnrPortCsmWgt = tSheetObj.CellValue(tgtRow, prefix+"sim_gnr_port_foil_csm_wgt");
	}
	
	return gnrPortCsmWgt;
}

function getGnrFoc(sheetObj, seaSpd){
	var tSheetObj = findSheetObj(sheetObjects, "sheet7"); // trend line sheet
	var prefix = tSheetObj.prefix;
	var tgtRow = getTgtRow(sheetObj.classNo, tSheetObj);
	var simGnrSpd = "";
	var gnrCsmWgt = "";
	
	if(tgtRow!=0){
		gnrCsmWgt = tSheetObj.CellValue(tgtRow, prefix+"sim_gnr_port_foil_csm_wgt");
		simGnrSpd = tSheetObj.CellValue(tgtRow, prefix+"sim_gnr_spd");
	}
	
	if(Number(seaSpd)<Number(simGnrSpd)){
		gnrCsmWgt = Number(gnrCsmWgt) + 2;
	}
	
	return gnrCsmWgt;
}

/**
 * Simulation No. Inquiry 팝업 후 처리
 * Add By 2014.09.25 Lee Byoung Hoon
 */
function getSimData(obj){
	if(obj){
		var rtnDatas = obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				var vslSlanCdTemp = rtnDatas[2];
				document.form.vsl_slan_cd.value = vslSlanCdTemp;
				
				var simTemp = rtnDatas[4];
				document.form.bnk_csm_sim_no.value = simTemp;
				simTemp = ComReplaceStr(simTemp,"-","");
				document.form.sim_dt.value = simTemp.substring(0,8);
				document.form.sim_no.value = Number(simTemp.substring(8,11));
			}
		}
	}
}

/* 개발자 작업 끝 */