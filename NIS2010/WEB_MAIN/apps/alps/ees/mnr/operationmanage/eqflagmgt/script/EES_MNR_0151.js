	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0151.js 
	 *@FileTitle : M&R Disposal Candidate Selection
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.10.19
	 *@LastModifier : 조경완
	 *@LastVersion : 1.0
	 *   2009.09.15 권영법
	 * 1.0 Creation
	 * 2012.10.19 조경완 [CHM-201220504-01] ALPS MNR-Disposal에서 Disposal candidate  Flagging 화면에서 column 추가 요청
	=========================================================*/
	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class ees_mnr_0151 : ees_mnr_0151 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0151() {
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
	//탭 
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	//쉬트 
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//콤보 객체   
	var comboObjects = new Array();
	var comboCnt = 0; 
	
	//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
	var uTpSz = new Array();    
	var gTpSz = new Array();  
	var zTpSz = new Array(); 
	
	var costDtlCode = "";
	var costDtlDesc = "";
	var OrgCostType = "";
	var nowLoad = 0;
	
	//Calculate 요청
	var calReq = 0;
	
	//삭제 calculate 계산
	var calDel = "";
	
	//작업 카운트 
	var startCopyRow = 0;
	var OrgVndrSeq = "";
	var OrgCostCd = "";
	
	//이전 Eq Kind Cd를 저장하기 위한
	var preEqkinCd =  ""; 
	
	// 로그인 유저의 Office 레벨 : HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴 (CoMnr.js에서
	// MnrOfficeLevel 함수에 의해 셋팅)
	var strMnrOfficeLevel = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick; 

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			var formObj = document.form;
				switch(srcName) {
					case "btn_calendar":
						var cal = new ComCalendarFromTo();
					    cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
					    break;	
					case "btn_fryear": //calender button
						var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.fryear, 'yyyy');
						break;
					case "btn_toyear": //calender button
						var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.toyear, 'yyyy');
						break;
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
						break;
					
					case "btn_new":
						doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
						break;
					
					case "btn_save":
						MnrWaitControl(true);
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
						
					case "btn_loadexcel": //수정중
						sheetObjects[4].RemoveAll();
						sheetObjects[4].LoadExcel(-1);
//						doActionIBSheet(sheetObjects[1], formObject,IBINSERT);
						break;
					
					case "btn_rowadd":
						doActionIBSheet(sheetObjects[1], formObject,IBINSERT);
						break;
					
					case "btn_rowdel":
						
						for(var i = sheetObjects[1].Rows; i > 0; i--){
							if(sheetObjects[1].CellValue(i, "del_chk") == 1){
								sheetObjects[1].RowDelete(i, false);
							}
						}
						
						/*sheetObjects[1].RowDelete()
						
						
						if(sheetObjects[1].FindCheckedRow("del_chk") == ""){ 
							ComShowCodeMessage("MNR00038","DELETE ");
							return false;             	   
						}
						if(ComShowCodeConfirm("MNR00026")){
							ComRowHideDelete(sheetObjects[1], "del_chk");
							calReq=0;
						}
						// 수정필요
						for(var i = sheetObjects[1].Rows; i >= 1; i--){
							if(sheetObjects[1].RowStatus(i) == "D"){
								sheetObjects[1].CellValue(i, "sheet2_mnr_disp_sel_flg") = "0";		
							}
						}*/
							
						
						break;
						
					//멀티입력
					case "eq_no_multi1":  
						if(formObj.combo_select_cd.Code=="N") {
							rep_Multiful_inquiry("rqst_eq_no_multi"); 
						}
					break;	
					
					case "btn_downexcel":
						sheetObjects[0].SpeedDown2Excel(-1);    
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
	
	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
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
		MnrWaitControl(true);
		
		// Office Level 조회 및 전역변수(strMnrOfficeLevel)에 세팅
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
		
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);  
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();   
		setTpSzArray(sheetObjects[0]);     
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
 	  
 	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) 
     {
       var cnt = 0;
       switch(sheetNo) 
       {
       case 1:      // sheet1 init
         with (sheetObj) 
         {
           // 높이 설정
           style.height = 380;
           // 전체 너비 설정
           SheetWidth = mainTable.clientWidth;
  
           //Host정보 설정[필수][HostIp, Port, PagePath]
           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  
           //전체Merge 종류 [선택, Default msNone]
           MergeSheet = msHeaderOnly;
  
           //전체Edit 허용 여부 [선택, Default false]
           Editable = true;
  
           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
           InitRowInfo(1, 1, 10, 100);
  
           var HeadTitle1 = "|Seq.|FLAG|Manu Year|EQ Range|TP/SZ|Q'ty|M/Facturer|M/Facture Date|Maker|Model No|Flag Date|Creation Date|Creation ID";
           var headCount = ComCountHeadTitle(HeadTitle1) + 5;
  
           //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
           InitColumnInfo(headCount, 0, 0, true);
  
           // 해더에서 처리할 수 있는 각종 기능을 설정한다
           InitHeadMode(true, true, true, true, false,false)
  
           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
           InitHeadRow(0, HeadTitle1, true);
  
           //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
           var prefix = "sheet1_";
           InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter, true, prefix+ "ibflag");
           InitDataProperty(0, cnt++ , dtDataSeq,       40,   daCenter, true,         "Seq");
           InitDataProperty(0, cnt++ , dtCheckBox,      50,   daCenter, true, prefix+ "mnr_disp_sel_flg",     false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtData,          70,   daCenter, true, prefix+ "mft_yr",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          150,  daCenter, true, prefix+ "eq_range_no",          false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          40,   daCenter, true, prefix+ "eq_tpsz_cd",           false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          40,   daCenter, true, prefix+ "eq_qty",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          75,   daCenter, true, prefix+ "mft_vndr_nm",          false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,         100,   daCenter, true, prefix+ "mft_dt",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          80,   daCenter, true, prefix+ "rf_mkr_nm",            false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,         100,   daCenter, true, prefix+ "rf_mdl_nm",            false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          110,  daCenter, true, prefix+ "mnr_disp_sel_flg_dt",  false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          110,  daCenter, true, prefix+ "upd_dt",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          90,   daCenter, true, prefix+ "upd_usr_id",           false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "eq_knd_cd",            false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "lot_eq_pfx_cd",        false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "fm_ser_no",            false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "to_ser_no",            false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "mnr_grp_tp_cd",        false,  "",   dfNone,       0,      true,   true);
         }
         break;   
       case 2:
         with (sheetObj) 
         {
           // 높이 설정
           style.height = 0;
           // 전체 너비 설정
           SheetWidth = mainTable.clientWidth;

           //Host정보 설정[필수][HostIp, Port, PagePath]
           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

           //전체Merge 종류 [선택, Default msNone]
           MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
           Editable = true;

           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
           InitRowInfo(1, 1, 10, 100);

           var HeadTitle1 = "|Sel|Seq.|FLAG|Sale Category|EQ No|TS|Term|Disposal No|Disposal Status|Yard|U.date|User ID";
           var headCount = ComCountHeadTitle(HeadTitle1) + 1;

           //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
           InitColumnInfo(headCount, 0, 0, true);

           // 해더에서 처리할 수 있는 각종 기능을 설정한다
           InitHeadMode(true, true, true, true, false,false)

           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
           InitHeadRow(0, HeadTitle1, true);

           //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
           var prefix = "sheet2_";
           InitDataProperty(0, cnt++ , dtHiddenStatus,  0,  daCenter, true,   prefix+ "ibflag");
           InitDataProperty(0, cnt++ , dtCheckBox,     40,  daCenter, true,           "del_chk",                false,  "",   dfNone,       0,  true,   true);
           InitDataProperty(0, cnt++ , dtDataSeq,      40,  daCenter, true,           "Seq");
           InitDataProperty(0, cnt++ , dtCheckBox,     50,  daCenter, true,   prefix+ "mnr_disp_sel_flg",       false,  "",   dfNone,       0,  true,   true);
           InitDataProperty(0, cnt++ , dtCombo,       100,  daLeft,   true,   prefix+ "disp_rsn_cd",            false,  "",   dfNone,       0,  true,   true);
           InitDataProperty(0, cnt++ , dtData,        125,  daLeft,   true,   prefix+ "eq_no",                  false,  "",   dfEngUpKey ,  0,  true,   true ,11  );
           
           InitDataProperty(0, cnt++ , dtData,         40,  daCenter, true,   prefix+ "eq_tpsz_cd",             false,  "",   dfNone,       0,  false,  false);
           InitDataProperty(0, cnt++ , dtData,         80,  daCenter, true,   prefix+ "lstm_cd",                false,  "",   dfNone,       0,  false,  false);
           InitDataProperty(0, cnt++ , dtData,        110,  daCenter, true,   prefix+ "disp_no", 				false,  "",   dfNone,       0,  false,   false);
           InitDataProperty(0, cnt++ , dtData,        110,  daCenter, true,   prefix+ "disp_sts_nm", 			false,  "",   dfNone,       0,  false,   false);
           InitDataProperty(0, cnt++ , dtData,         80,  daCenter, true,   prefix+ "mnr_disp_sel_flg_yd_cd", false,  "",   dfNone,       0,  true,   true);

           InitDataProperty(0, cnt++ , dtData,        110,  daCenter, true,   prefix+ "upd_dt",                 false,  "",   dfNone,       0,  false,  false);
           InitDataProperty(0, cnt++ , dtData,         60,  daCenter, true,   prefix+ "upd_usr_id",             false,  "",   dfNone,       0,  false,  false);
           InitDataProperty(0, cnt++ , dtHidden,       90,  daCenter, true,   prefix+ "eq_knd_cd",              false,  "",   dfNone,       0,  false,  false);
		  	 			       
           ColHidden(prefix+"mnr_disp_sel_flg") = false;   
		   InitDataValid(0, prefix + "eq_no" ,vtEngUpOther, "0123456789");  
		   InitDataValid(0, prefix + "mnr_disp_sel_flg_yd_cd" ,vtEngUpOther, "0123456789");  
		   WaitImageVisible = true;

         }
         break;   

       case 3: 
         with (sheetObj) {
           //Host정보 설정[필수][HostIp, Port, PagePath]
           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         }   
         break; 

       case 4:  // sheet1 init
         with (sheetObj) 
         {
           // 높이 설정
           style.height = 0;
           // 전체 너비 설정
           SheetWidth = mainTable.clientWidth;
  
           //Host정보 설정[필수][HostIp, Port, PagePath]
           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  
           //전체Merge 종류 [선택, Default msNone]
           MergeSheet = msHeaderOnly;
  
           //전체Edit 허용 여부 [선택, Default false]
           Editable = true;
  
           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
           InitRowInfo(1, 1, 10, 100);
  
           var HeadTitle1 = "|Seq.|FLAG|MANU|EQ S/No. Range|TS|Q'ty|M/Facturer|M/Facture Date|Maker|Model No|Flag Date|U.date|User ID";
           var headCount = ComCountHeadTitle(HeadTitle1) + 5;
  
           //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
           InitColumnInfo(headCount, 0, 0, true);
  
           // 해더에서 처리할 수 있는 각종 기능을 설정한다
           InitHeadMode(true, true, true, true, false,false)
  
           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
           InitHeadRow(0, HeadTitle1, true);
  
           //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
           var prefix = "sheet4_";
           InitDataProperty(0, cnt++ , dtHiddenStatus,   0,   daCenter, true, prefix+ "ibflag");
           InitDataProperty(0, cnt++ , dtSeq,           40,   daCenter, true,         "Seq");
           InitDataProperty(0, cnt++ , dtCheckBox,      50,   daCenter, true, prefix+ "mnr_disp_sel_flg",     false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtData,          55,   daCenter, true, prefix+ "mft_yr",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          150,  daCenter, true, prefix+ "eq_range_no",          false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          40,   daCenter, true, prefix+ "eq_tpsz_cd",           false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          40,   daCenter, true, prefix+ "eq_qty",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          75,   daCenter, true, prefix+ "mft_vndr_nm",          false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,         100,   daCenter, true, prefix+ "mft_dt",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          80,   daCenter, true, prefix+ "rf_mkr_nm",            false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,         100,   daCenter, true, prefix+ "rf_mdl_nm",            false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          110,  daCenter, true, prefix+ "mnr_disp_sel_flg_dt",  false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          110,  daCenter, true, prefix+ "upd_dt",               false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtData,          90,   daCenter, true, prefix+ "upd_usr_id",           false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "eq_knd_cd",            false,  "",   dfNone,       0,      false,  false);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "lot_eq_pfx_cd",        false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "fm_ser_no",            false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "to_ser_no",            false,  "",   dfNone,       0,      true,   true);
           InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter, true, prefix+ "mnr_grp_tp_cd",        false,  "",   dfNone,       0,      true,   true);
         }
         break; 
        
       case 5:  // sheet3 init
           with (sheetObj) 
           {
             // 높이 설정
             style.height = 0;
             // 전체 너비 설정
             SheetWidth = mainTable.clientWidth;
    
             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;
    
             //전체Edit 허용 여부 [선택, Default false]
             Editable = true;
    
             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo(1, 1, 10, 1);
    
             var HeadTitle1 = "|EQ_NO";
             var headCount = ComCountHeadTitle(HeadTitle1);
    
             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(headCount, 0, 0, true);
    
             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(true, true, true, true, false,false)
    
             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle1, true);
    
             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             var prefix = "sheet5_";
             InitDataProperty(0, cnt++ , dtHiddenStatus,   0,   daCenter, true, prefix+ "ibflag");
             InitDataProperty(0, cnt++ , dtData,          55,   daCenter, true, prefix+ "eq_no",               false,  "",   dfNone,       0,      false,  false);
           }
           break;
       }
     }
    
     
 	/**
 	* 멀티 콤보 초기화 
 	* @return
 	*/
 	function initCombo() { 
 		var formObject = document.form;
		with (formObject.combo_select_cd) {  
 			SetColAlign("left");   
 			SetColWidth("80");
 			DropHeight = 160;
 			Enable=true; 
 		}
 		with (formObject.combo_eq_knd_cd) {
 			SetColAlign("left"); 
 			SetColWidth("80");
 			DropHeight = 160;
 			Enable=true;
 		}
 		with (formObject.combo_eq_tpsz_cd) {
			MultiSelect = true; 
			UseAutoComplete = true;	
			SetColAlign("left");
			SetColWidth("40");  
			DropHeight = 200;
 		} 
 		
 	}    

	//멀티콤보 클릭 이벤트
	function combo_eq_tpsz_cd_OnCheckClick(comboObj, index, code) { 
		MnrAllChkMultiCombo(comboObj,index);  		  
	}
	
	/**  
	 * combo3 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function combo_eq_tpsz_cd_OnChange(comboObj,Index_Code, Text){
		formObj = document.form;  
		formObj.eq_tpsz_cd.value = comboObj.Code;      			 
	}  
 	
 	
	function combo_eq_knd_cd_OnChange(comboObj,indexCode, Text){
		formObject = document.form;

		if(formObject.combo_select_cd.Code == "N" && sheetObjects[1].RowCount > 0){
			if (!ComShowCodeConfirm("MNR00297")){
				comboObj.Code2 = preEqkinCd;    
				return;      
			}       
		} 
		 
		//EQ No sheet 초기화
		sheetObjects[1].RemoveAll();  
		if(indexCode == null) return; 
 		formObject.combo_eq_tpsz_cd.RemoveAll();
		var selTpSz = new Array();
		if(indexCode == "U"){
			selTpSz = uTpSz;  	
		} else if(indexCode == "G"){
			selTpSz = gTpSz; 
		} else {
			selTpSz = zTpSz;   
		}  	
		//디폴트로 올삽입		
		formObject.combo_eq_tpsz_cd.InsertItem(0,"ALL","ALL");  		
		for(var i = 1;i < (selTpSz.length + 1);i++){            
			formObject.combo_eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
		}
		
		preEqkinCd = comboObj.Code;  	    
	}   

 	function combo_select_cd_OnChange(indexCode, Text){
		var formObj = document.form;
		var TTK= document.getElementById("mainKeyName");
		var TTN= document.getElementById("titleChangedName");
		
		var btn_rowadd_id= document.getElementById("btn_rowadd_id");
		var btn_rowdel_id= document.getElementById("btn_rowdel_id");
		var btn_downexcel_id= document.getElementById("btn_downexcel_id");
		var btn_loadexcel_id= document.getElementById("btn_loadexcel_id");
		if(Text=="R")
		{
			sheetObjects[0].style.height = 380;
			sheetObjects[1].style.height = 0;
			TTK.cells[6].innerHTML="EQ Selection Date&nbsp;";
			TTK.cells[7].innerHTML="<input type=\"text\" maxlength=4 style=\"width:40;text-align:center\" class=\"input\" name=\"fryear\" dataformat=\"int\">&nbsp;"
				+ "<img name =\"btn_fryear\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" alt=\"\" border=\"0\" align=\"absmiddle\" class=\"cursor\">"
				+ "&nbsp;~&nbsp;<input type=\"text\" maxlength=4 style=\"width:40;text-align:center\" class=\"input\" name=\"toyear\" dataformat=\"int\">&nbsp;"
				+ "<img name =\"btn_toyear\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" alt=\"\" border=\"0\" align=\"absmiddle\" class=\"cursor\">"
				;
			TTN.cells[1].innerText="Disposal Candidate Selection by Serial Range";

			btn_rowadd_id.style.display="none";
			btn_rowdel_id.style.display="none";
			btn_loadexcel_id.style.display="none";
			btn_downexcel_id.style.display="block";
		}
		else if(Text=="N")
		{
			sheetObjects[0].style.height = 0;
			sheetObjects[1].style.height = 378;
			TTK.cells[6].innerHTML="EQ Selection Date&nbsp;";
			
			TTK.cells[7].innerHTML="<input   name=\"fromcal\" type=\"text\" maxlength=8  style=\"width:70;text-align:center\" class=\"input\" dataformat=\"ymd\" required fullfill>"
								  +"&nbsp;~&nbsp;<input  name=\"tocal\" type=\"text\"    maxlength=8  style=\"width:70;text-align:center\" class=\"input\" dataformat=\"ymd\" required fullfill>"
								  +"&nbsp;<img class=\"cursor\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\" name=\"btn_calendar\">";
			TTN.cells[1].innerText="Disposal Candidate Selection by EQ No";

			btn_rowadd_id.style.display="block";
			btn_rowdel_id.style.display="block";
			btn_loadexcel_id.style.display="block";
			btn_downexcel_id.style.display="none";
		}
		  
		if(formObj.combo_select_cd.Code=="R")
		{  
			formObj.fryear.value = ComGetNowInfo("yy") - 5;
			formObj.toyear.value = ComGetNowInfo("yy");
			formObj.rqst_eq_no_multi.disabled=true;
			formObj.eq_no_multi1.disabled=true;
			formObj.rqst_eq_no_multi.value = "";
			formObj.rqst_eq_no.value = "";
		}   
		else if(formObj.combo_select_cd.Code=="N")
		{ 
			formObj.tocal.value = ComGetNowInfo("ymd"); 
			formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -3);
			formObj.rqst_eq_no_multi.disabled=false;
			formObj.eq_no_multi1.disabled=false;
			formObj.rqst_eq_no_multi.value = "";
			formObj.rqst_eq_no.value = "";
			
		} 
		
		initControl();
	}   	
	 
	function sheet1ToSheet4Copy(fromSheet,toSheet){
	    //원본에서 역순으로 Check 된 데이터를 확인하여 이동
	    //원본에서 지움
	    toSheet.RemoveAll(); 

	    var row =0;
	    for (var idx = startCopyRow ; idx<=fromSheet.LastRow ; idx++) {
	    	if(row>10)break;
	    	if(fromSheet.CellValue(idx,"sheet1_ibflag")!='U') continue;
			 row = toSheet.DataInsert(-1);
	        //데이터 옮기기
	        for (ic = 0; ic<=fromSheet.LastCol; ic++) {
	            toSheet.CellValue(row, ic) = fromSheet.CellValue(idx, ic);
	        } 
	    }
		 
	    startCopyRow=idx;
	    var formObj=document.form;
		formObj.f_cmd.value = MULTI;
		var aryPrefix = new Array("sheet4_", "sheet2_");
		var sParam = ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
		{
			MnrWaitControl(false);
			setSaveBtnDisplay();
			formObj.combo_select_cd.Enable=true;
			return false;
		}
	
		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);
	
		//ComDebug(sParam);
		var sXml = toSheet.GetSaveXml("EES_MNR_0151GS.do", sParam);
	
		toSheet.LoadSaveXml(sXml);
	    //이동완료 후 그림 그리기
		fromSheet.Redraw      = true;
	}
 	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 

				ComShowCodeMessage("MNR00111");
/***** 저장 후 재 조회 시 발생하는 작업 시간 소요를 없애기 위하여 재조회 기능 삭제. 2016-06-15(이율규) 시작 *****/
//				if(formObj.combo_select_cd.Code=="R") 
//					sheetObjects[0].RemoveAll();
//				else if(formObj.combo_select_cd.Code=="N")
//					sheetObjects[1].RemoveAll();
//				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
				var formObj = document.form;
				formObj.combo_select_cd.Enable=true;
				
/***** 저장 후 재 조회 시 발생하는 작업 시간 소요를 없애기 위하여 재조회 기능 삭제. 2016-06-15(이율규) 종료 *****/

			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
		setSaveBtnDisplay();
		ComEnableObject(formObj.select_cd,true);
	}
	 	
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		var formObj = document.form;
		var prefix = "sheet3_";
		formObj.combo_select_cd.Enable=true;
		nowLoad=0; 
		MnrWaitControl(false);
		setSaveBtnDisplay();
	}
	
	function sheet2_OnSearchEnd(sheetObj, errMsg)
	{
		for(var i = 1; i < sheetObjects[1].Rows; i++){
			if(sheetObjects[1].CellValue(i, "sheet2_disp_no") != "" &&
			   sheetObjects[1].CellValue(i, "sheet2_mnr_disp_sel_flg") == 1 &&
			   sheetObjects[1].CellValue(i, "sheet2_disp_sts_nm") != "Disposal Delete"
			   ){
				sheetObjects[1].CellEditable(i, "sheet2_mnr_disp_sel_flg") = false;
				sheetObjects[1].CellEditable(i, "sheet2_disp_rsn_cd") = false;
				sheetObjects[1].CellEditable(i, "sheet2_eq_no") = false;
				sheetObjects[1].CellEditable(i, "sheet2_mnr_disp_sel_flg_yd_cd") = false;
			}
		}
	}
	
	function sheet2_OnClick(sheetObj, Row, Col){
		if(sheetObj.CellValue(Row, "sheet2_disp_no") != "" && 
		   sheetObj.ColSaveName(Col) == "sheet2_mnr_disp_sel_flg" &&
		   sheetObj.CellValue(Row, Col) == 1 &&
		   sheetObj.CellValue(Row, "sheet2_disp_sts_nm") != "Disposal Delete"){
			ComShowCodeMessage("MNR00414");
		}
	}

	

	function sheet2_OnChange(sheetObj,Row, Col, Value)
	{
		var formObj=document.form;
				
		if(nowLoad == 0) 
		{ 
			if(sheetObj.ColSaveName(Col) == "sheet2_eq_no") 
			{ 
				var checkEqn = sheetObjects[1].CellValue(Row,"sheet2_eq_no");
				sheetObjects[1].CellValue2(Row,"sheet2_eq_no") = checkEqn.toUpperCase();
				checkEqn = checkEqn.toUpperCase();   
				var retArray = MnrGeneralCodeCheck(sheetObjects[0],"ESTEQN",checkEqn + "," + formObj.combo_eq_knd_cd.Code);      
				if(retArray == null){ 	           
					ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");           				
					sheetObjects[1].CellValue2(Row,"sheet2_eq_no") = "";     
					sheetObjects[1].SelectCell(Row,"sheet2_eq_no");   
					return; 	     	          
				} else {		     
					//맞는 EQ_NUMBER Equipment Information 를 표시한다.
					setEqInfo(sheetObjects[2],Row,formObj.combo_eq_knd_cd.Code,checkEqn,ComGetNowInfo("ymd"));	 
					return;  	   
				}  	
			} 
			else if(sheetObj.ColSaveName(Col) == "sheet2_mnr_disp_sel_flg_yd_cd") 
			{ 
				var checkYard = Value;
				retArray = MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);      
				if(retArray == null){         
					ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
					sheetObj.CellValue2(Row ,Col) = ""; 
					sheetObj.SelectCell(Row ,Col);                  
				} else {     
					return;      
				}  		 	
			}
		}
	}    
	
	
	function sheet3_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI && startCopyRow > sheetObjects[0].LastRow)
		{
	 		sheetObjects[0].SelectCell(sheetObjects[0].LastRow, "sheet1_mft_yr",true);
			sheetObjects[0].WaitImageVisible = false;
			ComOpenWait(false);
			if (errMsg == "") {  
				ComShowCodeMessage("MNR00111");
				if(formObj.combo_select_cd.Code=="R")
					sheetObjects[0].RemoveAll();
				else if(formObj.combo_select_cd.Code=="N")
					sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);

			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
			nowLoad = 0;
			MnrWaitControl(false);
			setSaveBtnDisplay();
			formObj.combo_select_cd.Enable=true;
		}else{
	 		sheetObjects[0].SelectCell(startCopyRow - 1, "sheet1_mft_yr",true);
	 		setTimeout("sheet1ToSheet4Copy(sheetObjects[0],sheetObjects[3])",300); 
			//sheet1ToSheet4Copy(sheetObjects[0],sheetObjects[3]);
		}
		formObj.combo_select_cd.Enable=true;
	}		
	
 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, sAction2) {
        sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:
				MnrWaitControl(true);
				formObj.f_gubuns.value = ""; 
				formObj.cost_ofc_cd.value = currOfcCd;
			 	
				//콤보 초기화  
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].Code = "-1";  
					comboObjects[i].RemoveAll(); 	
				}  
				
				//쉬트 초기화    
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				
				//콤보 세팅   
				var sCondition = new Array ( 
					new Array("MnrGenCd","CD00066", "COMMON"),     
					new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9"),
					new Array("MnrGenCd","CD00038", "COMMON") 
				) 	   	     
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 	
				          
				//1. combo_select_cd 
				if(comboList[0] != null){        
					for(var j = 0; j < comboList[0].length;j++){  
						var tempText = comboList[0][j].split("|");           
						formObj.combo_select_cd.InsertItem(j,tempText[1] ,tempText[0]);
					}  
				} 	   		   
				formObj.combo_select_cd.Code = "R";
				   
				//2. combo_eq_knd_cd     
				if(comboList[1] != null){         
					for(var j = 0; j < comboList[1].length;j++){    
						var tempText = comboList[1][j].split("|");  
						formObj.combo_eq_knd_cd.InsertItem(j,tempText[1] ,tempText[0]);
					}     
				}	   		   
				formObj.combo_eq_knd_cd.Code = "U"; 
				 
				//3  sheet2_disp_rsn_cd
				if(comboList[2] != null){
		 			sheetComboText = "";
		 			sheetComboCode = ""; 
		 			sheetComboDefault = ""; 
		 			    
		 	 		for(var j = 0; j < comboList[2].length;j++){ 
		 				var tempText = comboList[2][j].split("|");    
		 				sheetComboText +=  tempText[1] + "|";
		 				sheetComboCode +=  tempText[0] + "|";
		 				if(j == 0){  
		 					sheetComboDefault = tempText[0];      	
		 				}    
		 			}  
					sheetComboText = MnrDelLastDelim(sheetComboText);
					sheetComboCode = MnrDelLastDelim(sheetComboCode);
		 			//탭별 쉬트 콤보 설정   
					sheetObjects[1].InitDataCombo(0, "sheet2_disp_rsn_cd", sheetComboText, sheetComboCode,sheetComboDefault);
		 		} 
				  
				//콤보에 따른 초기값 세팅  
				if(formObj.combo_select_cd.Code == "R") 
				{ 
					formObj.fryear.value = ComGetNowInfo("yy") - 5;  
					formObj.toyear.value = ComGetNowInfo("yy");
				}  
				else if(formObj.combo_select_cd.Code=="N")
				{      
					formObj.tocal.value = ComGetNowInfo("ymd"); 
					formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -3);
				} 
				MnrWaitControl(false);
				
				//저장버튼 Display 설정
				setSaveBtnDisplay();
				
				break; 
				 
			case IBINSERT:
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				var row = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(row, "sheet2_disp_rsn_cd") = "C";
				sheetObj.CellValue2(row, "sheet2_mnr_disp_sel_flg") = "1";
				sheetObj.CellEditable(row,"sheet2_mnr_disp_sel_flg") = false;
				sheetObj.CellValue2(row, "sheet2_eq_knd_cd") = formObj.combo_eq_knd_cd.Code;
				sheetObj.SelectCell(row, "sheet2_eq_no",true);

				MnrWaitControl(false);
				setSaveBtnDisplay();
		
				break;				
			case IBSEARCH:      //조회
				MnrWaitControl(true);
				
				if(sAction2 != 2){
					if(!validateForm(sheetObj,formObj,sAction))
					{
						MnrWaitControl(false);
						setSaveBtnDisplay();
						return; 
					}					
				} else{
					MnrWaitControl(false);
					setSaveBtnDisplay();
				}
				
				nowLoad = 1;
				formObj.f_gubuns.value = ""; 
				sheetObjects[0].RemoveAll(); 
				sheetObjects[1].RemoveAll(); 
				formObj.select_cd.value=formObj.combo_select_cd.Code;
				formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Code;
				formObj.eq_tpsz_cd.value=formObj.combo_eq_tpsz_cd.Code;
				
				
				
				formObj.rqst_eq_no.value = formObj.rqst_eq_no_multi.value.replace(/,/g,"','");	
				
				var sParam = "";
				
				if(sAction2 == 2){
					formObj.f_cmd.value = SEARCH01;
					var aryPrefix = new Array("sheet2_");
					
					sParam = ComGetPrefixParam(aryPrefix) + "&" + ComGetSaveString(sheetObj)+ "&f_cmd=" + formObj.f_cmd.value + "&eq_knd_cd=" + formObj.eq_knd_cd.value;
				} else{
					formObj.f_cmd.value = SEARCH;
					var aryPrefix = new Array("sheet1_", "sheet2_");
					sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
				}
				
				//alert("IBSEARCH : " + "\n"+ sParam);
				var sXml   = sheetObj.GetSearchXml("EES_MNR_0151GS.do", sParam);
				
				if(sAction2 == 2){
					sheetObjects[1].LoadSearchXml(sXml);
					nowLoad = 0;
				}else{
					arrDataSearchDbXml = sXml.split("|$$|");

					for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
							sheetObjects[i].Redraw = false;
							sheetObjects[i].WaitImageVisible = false;
							sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
							sheetObjects[i].Redraw = true;
					}  			
				}
				break; 
	
		case IBSAVE:        //저장
			if(nowLoad != 0) return;
			MnrWaitControl(true);
			formObj.combo_select_cd.Enable=false;
			var sheetObjCheck;
			if(formObj.combo_select_cd.Code=="R")
				sheetObjCheck=sheetObjects[0];
			else if(formObj.combo_select_cd.Code=="N")
				sheetObjCheck=sheetObjects[1];

			
			if(!validateForm(sheetObjCheck,formObj,sAction))
			{
				formObj.combo_select_cd.Enable=true;
				nowLoad=0;
				MnrWaitControl(false);
				setSaveBtnDisplay();
				return;
			}
			nowLoad=1;
			formObj.select_cd.value=formObj.combo_select_cd.Code;
			formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Code;
			formObj.eq_tpsz_cd.value=formObj.combo_eq_tpsz_cd.Code;
		
			formObj.f_cmd.value = MULTI;
			if(formObj.select_cd.value == "R") 
			{
				MnrWaitControl(true);
				ComOpenWait(true);
			 	startCopyRow=sheetObjects[0].HeaderRows;
				sheet1ToSheet4Copy(sheetObjects[0],sheetObjects[3]);

			}else{
				MnrWaitControl(true);
				var aryPrefix = new Array("sheet1_", "sheet2_");
				var sParam = ComGetSaveString(sheetObjects, true, false);
				if (sParam == "")
				{
					MnrWaitControl(false);
					setSaveBtnDisplay();
					formObj.combo_select_cd.Enable=true;
					return false;
				}
			
				sParam += "&" + FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(aryPrefix);
			      
				var sXml = sheetObj.GetSaveXml("EES_MNR_0151GS.do", sParam);
			
				sheetObjects[0].LoadSaveXml(sXml);
			}
			break;
        }
    } 
 	
 	/**
 	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
 	*/
 	function validateForm(sheetObj,formObj,sAction){
 		with(formObj){
 			//추가시
 			if(sAction==IBINSERT)
 			{
 				
 			}		
 			//조회시
 			else if(sAction==IBSEARCH)
 			{
 				var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
 				if(sRow != "") // sheet 수정내용 있음
 				{                               	
 					if(!ComShowCodeConfirm("MNR00007"))
 					{
 						return false;
 					}
 				}
 	
 				if(formObj.combo_eq_knd_cd.Index == "-1"){
 					ComShowCodeMessage("MNR00036","EQ KIND");    
 					ComSetFocus(formObj.combo_eq_knd_cd);     
 					return false;
 				}
 			}
 			//저장(확정)시
 			else if(sAction==IBSAVE) {
 				if(sheetObj.RowCount <=0)return false;
 				if(!sheetObj.IsDataModified){
 					ComShowCodeMessage("MNR00369");
 					return false;
 				}
 					
 					
 				if(formObj.combo_select_cd.Code=="N")
 				{
	 				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
	 				{
	 					if(sheetObj.CellValue(i, "sheet2_ibflag")!="R" && sheetObj.CellValue(i, "sheet2_ibflag")!="D")
	 					{
		 					var strEqNo =ComTrimAll(sheetObj.CellValue(i, "sheet2_eq_no")," ");
		 					if(strEqNo=="")
		 					{
		 						ComShowCodeMessage("MNR00172","EQ No.");
		 						sheetObj.SelectCell(i, "sheet2_eq_no",true);
		 						return false; 
		 					}
		 					
		 					var checkYard = ComTrimAll(sheetObj.CellValue(i, "sheet2_mnr_disp_sel_flg_yd_cd")," ");; 
							retArray = MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);      
							if(retArray == null){        
								ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
								sheetObj.SelectCell(i, "sheet2_mnr_disp_sel_flg_yd_cd",true);   
								return false; 
							}
	 					}
	 				}
 				}
 			}
 	
 		
 			//복사시
 			else if (sAction=="COPY") {
 				//그리드 존재유무 
 				if(!checkIsDetailRow()) {return false;}
 			}
 			//행 삭제시
 			else if (sAction==IBDELETE) {
 				if(sheetObj.FindCheckedRow("del_chk") == ""){ 
 					ComShowCodeMessage("MNR00038","DELETE ");
 					return false;             	   
 				}
 			}
 			//행 복사시
 			else if (sAction==IBCOPYROW) {
 				//그리드 존재유무 
 				if(!checkIsDetailRow()) {return false;}
 			}
 			//Load Excel
 			else if (sAction==IBLOADEXCEL) {
 				//Tariff상태값 체크
 				if(!checkTariffStatus()) {return false;}
 			}
 		}
 		return true;
 	}
	
	function setTpSzArray(sheetObj){ 
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
			 
		if(arrXml != null){          
		    for(var i = 0; i < arrXml.length; i++){   
				if(i == 0){	       
					uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
				} else if(i == 1){	  
					zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");  
				} else if(i == 2){	    
					gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
				}	  	 
		    }  	 
		}				
	} 	

 	function setEqInfo(sheetObj,Row,sEqType,sEqNo,sTotalLossDate){
 		var formObj = document.form;
 		var sCostType = ""; 
 		if(formObj.combo_eq_knd_cd.Code == "U"){
 			sCostType = "MRDRRC";	
 		} else if(formObj.combo_eq_knd_cd.Code == "G"){
 			sCostType = "MRGSRC"; 		
 		} else {
 			sCostType = "MRZSRC";    
 		}	   	 	
 		var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
 		var retArr =  MnrXmlToArray(sXml); 
  		 	
 		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt						
 		if(retArr != null){	  
 			//TpSz			 
 			sheetObjects[1].CellValue2(Row,"sheet2_eq_tpsz_cd") = retArr[0][31];
 			//Lstm		
 			sheetObjects[1].CellValue2(Row,"sheet2_lstm_cd") = retArr[0][19];
 			//Yard		  
 			sheetObjects[1].CellValue2(Row,"sheet2_mnr_disp_sel_flg_yd_cd") = retArr[0][18]; 
 		} else {	  
 			//TpSz	 
 			sheetObjects[1].CellValue2(Row,"sheet2_eq_tpsz_cd") = "";
 			//Lstm		 
 			sheetObjects[1].CellValue2(Row,"sheet2_lstm_cd") = "";
 			//Yard	 
 			sheetObjects[1].CellValue2(Row,"sheet2_mnr_disp_sel_flg_yd_cd") = "";
 		}	
 		calReq=0;
 	}
	
	function initControl() {       
		//Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
 	}
	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){    
		var formObject = document.form; 
		ComChkObjValid(event.srcElement); 
		obj = event.srcElement;   
		if(obj.name=="fryear" || obj.name=="toyear" )
		{
			keys = event.keyCode;
			if(formObject.fryear!=undefined)
			{
				va=formObject.fryear.value;
				va=va.split(",");
				formObject.fryear.value=va.join("");
			}
			
			if(formObject.toyear!=undefined)
			{
				va=formObject.toyear.value;
				va=va.split(",");
				formObject.toyear.value=va.join("");
			}
		}
	} 
					
	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) { 
 		var formObj = document.form; 	 
 		var tempText = "";       
 		//초기화     
		eval("document.form." + return_val + ".value = '';"); 
 
 		for(var i=0; i < rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함      
		tempText = MnrDelLastDelim(tempText);		
 			     
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	}
	
	function obj_activate(){   
		ComClearSeparator(event.srcElement);
	}   
 
	
	function obj_change()
	{	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{      
			case "empty":   
				
  				break;   	
			}       
		} 
	}    
	
	function obj_keypress(){   
		obj = event.srcElement;    
		keys = event.keyCode;

		if(obj.dataformat == null) return; 
		window.defaultStatus = obj.dataformat;
		var formObj  = document.form; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
			case "empty":   
  				break;    			
			}        
		}				 			              
		switch(obj.dataformat) { 
		
        case "ymd":
		case "int":       
			ComKeyOnlyNumber(obj); 
			break;     
		case "float":    
			ComKeyOnlyNumber(obj, "-.");
			break; 
		case "eng":   
			ComKeyOnlyAlphabet();
			break;   
		case "engup":  
			ComKeyOnlyAlphabet('uppernum');           
			break; 
		case "int":  
			ComKeyOnlyNumber(obj);           
			break; 
		}         
	}   
	
	/**
	 * 저장버튼 Display 설정
	 * 로그인한 OFFICE 의 LEVEL 이  L1 일 때만 Display 시키고 
	 * 나머지는  Disalbe 시킨다. 
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_save");
		} else {
			ComBtnDisable("btn_save");
		}
	}
	
	
	function sheet3_OnLoadExcel() {
		doActionIBSheet(sheetObjects[4],formObject,IBSEARCH, 2);
		
	}